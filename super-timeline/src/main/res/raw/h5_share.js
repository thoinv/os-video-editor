window.H5Share || (function() {
    var H5Share = {};
    var shareMessage = {
        title: "",
        imgUrl: "",
        desc: "",
        ready: false
    };
    var collectReadyState = {
        title: false,
        imgUrl: false,
        desc: false
    };
    var imgArr;
    var H5ShareCollector = {
        init: function() {
            var t = this;
            t.collectTitle();
            t.collectDesc();
            t.collectThumbnail();
        },
        collectTitle: function() {
            var t = this;
            if (collectReadyState.title) {
                return;
            }
            if (document.title && document.title.trim() !== "") {
                shareMessage.title = t.contentTidy(document.title);
                collectReadyState.title = true;
                t.collectReady();
            } else {
                if (document.getElementsByTagName("H1").length > 0 && document.getElementsByTagName("H1")[0].textContent.length > 0) {
                    var tmpH1 = t.nodeStrFliter(document.getElementsByTagName("H1")[0]);
                    if (t.getStrLen(tmpH1) <= 64 && tmpH1.length > 0) {
                        shareMessage.title = tmpH1;
                        collectReadyState.title = true;
                        t.collectReady();
                    }
                }
            }
        },
        collectThumbnail: function() {
            var t = this;
            var metaImgNode = document.querySelector('meta[name="JSBridge:imgUrl"]');
            if (metaImgNode && metaImgNode.getAttribute("content") && metaImgNode.getAttribute("content").trim()) {
                collectReadyState.imgUrl = true;
                shareMessage.imgUrl = metaImgNode.getAttribute("content");
                t.collectReady();
            } else {
                collectReadyState.imgUrl = false;
                t.collectReady();
                imgArr = Array.prototype.slice.call(document.images);
                t.findImgUrl();
            }
        },
        findImgUrl: function() {
            var t = H5ShareCollector,
            limitWidth = 200,
            limitHeight = 50;
            if (imgArr.length === 0) {
                collectReadyState.imgUrl = true;
                t.collectReady();
                return;
            }
            if (imgArr.length > 0 && !collectReadyState.imgUrl) {
                for (var i = 0; i < imgArr.length; i++) {
                    var curImg = imgArr[i];
                    if (curImg.complete || curImg.natureWidth) {
                        if (curImg.naturalWidth >= limitWidth && curImg.naturalHeight >= limitHeight && curImg.naturalHeight * curImg.naturalWidth < 2000 * 500) {
                            shareMessage.imgUrl = curImg.src;
                            collectReadyState.imgUrl = true;
                            t.collectReady();
                            imgArr = [];
                            break;
                        }
                    }
                }
            }
        },
        collectDesc: function() {
            if (collectReadyState.desc) {
                return;
            }
            var t = this;
            var metaDescNode = document.querySelector('meta[name="JSBridge:desc"]');
            if (metaDescNode && metaDescNode.getAttribute("content") && metaDescNode.getAttribute("content").trim()) {
                collectReadyState.desc = true;
                shareMessage.desc = metaDescNode.getAttribute("content");
                t.collectReady();
            }
            if (!collectReadyState.desc) {
                var pArr = Array.prototype.slice.call(document.getElementsByTagName("P"));
                if (pArr.length > 0) {
                    for (var i = 0; i < pArr.length; i++) {
                        var pConetent = pArr[i].textContent;
                        if (pArr[i].id == "Debug") {
                            continue;
                        }
                        if (t.getStrLen(pConetent) >= 50 && t.getStrLen(pConetent) <= 2000) {
                            pConetent = t.nodeStrFliter(pArr[i], false);
                            if (t.getStrLen(pConetent) >= 50 && t.getStrLen(pConetent) <= 2000) {
                                shareMessage.desc = pConetent;
                                collectReadyState.desc = true;
                                t.collectReady();
                                break;
                            }
                        }
                    }
                }
            }
            if (!collectReadyState.desc) {
                t.travelDocument(document.body);
            }
            if (!collectReadyState.desc) {
                var descNode = document.querySelector('meta[name="description"]');
                if (descNode && descNode.getAttribute("content") && descNode.getAttribute("content").trim()) {
                    shareMessage.desc = t.contentTidy(descNode.getAttribute("content"));
                    collectReadyState.desc = true;
                    t.collectReady();
                }
            }
        },
        collectReady: function() {
            if (collectReadyState.title && collectReadyState.imgUrl && collectReadyState.desc) {
                shareMessage.ready = true;
            }
        },
        travelDocument: function(el) {
            var t = this,
            childNodes = el.childNodes;
            if (childNodes && childNodes.length > 0) {
                for (var i = 0; i < childNodes.length; i++) {
                    var c = childNodes[i],
                    tmp;
                    switch (c.nodeType) {
                    case 1:
                        if (c.nodeName != "P" && c.nodeName != "SCRIPT" && c.nodeName != "STYLE") {
                            t.travelDocument(c);
                        }
                        break;
                    case 3:
                        tmp = c.nodeValue;
                        if (t.getStrLen(tmp) >= 50 && t.getStrLen(tmp) <= 2000) {
                            tmp = t.contentTidy(tmp);
                        }
                        if (t.getStrLen(tmp) >= 50 && t.getStrLen(tmp) <= 2000) {
                            shareMessage.desc = tmp;
                            collectReadyState.desc = true;
                            t.collectReady();
                        }
                        break;
                    }
                    if (collectReadyState.desc) {
                        break;
                    }
                }
            }
        },
        getStrLen: function(str) {
            return str.replace(/[^\x00-\xff]/g, "xx").length;
        },
        nodeStrFliter: function(element, imgAlt) {
            imgAlt = imgAlt || true;
            var t = this,
            tmp = element.cloneNode(true);
            if (imgAlt) {
                Array.prototype.forEach.call(tmp.querySelectorAll("img[alt]"),
                function(el) {
                    el.parentNode.replaceChild(document.createTextNode(el.alt), el);
                });
            }
            Array.prototype.forEach.call(tmp.querySelectorAll("script,style,link"),
            function(el) {
                el.parentNode.replaceChild(document.createTextNode(""), el);
            });
            tmp = t.contentTidy(tmp.textContent);
            return tmp;
        },
        contentTidy: function(str) {
            return str.replace(/\s{4}/g, " ").replace(/(\r|\n)/g, "").trim();
        }
    };
    if (/complete|loaded|interactive/.test(document.readyState)) {
        H5ShareCollector.init();
    } else {
        document.addEventListener("DOMContentLoaded",
        function(e) {
            H5ShareCollector.init();
        },
        true);
    }
    H5Share.getShareContent = function() {
        H5ShareCollector.init();
        return JSON.stringify(shareMessage);
    };
    document.addEventListener("JSPlugin_H5Share",
    function(e) {
        if (JSBridge && e.clientId) {
            H5ShareCollector.init();
            JSBridge.callback(e.clientId, shareMessage);
        }
    });
    window.H5Share = H5Share;
})();