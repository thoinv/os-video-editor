(function() {
    var defaultHandler = function(res, callback) {
        if (window.WebViewJavascriptBridge._messageHandler) {
            window.WebViewJavascriptBridge._messageHandler(res, callback)
        }
    };
    var scanAppCallFunMap = {
        js_sc_alert: function(param, callback) {
            if ("string" === typeof param) {
                param = eval("(" + param + ")")
            }
            var buttons = [];
            if (param.buttons) {
                for (var i = 0,
                len = param.buttons.length; i < len; i++) {
                    buttons.push(param.buttons[i].title)
                }
                param.buttons = buttons
            } else {
                param.buttons = ["确定"]
            }
            window.JSBridge.call("showAlert", param,
            function(res) {
                if (!callback) {
                    defaultHandler(res,
                    function(res) {});
                    return
                }
                var clickIndex = res.index,
                title;
                title = (param.buttons[clickIndex] ? param.buttons[clickIndex] : "");
                callback(JSON.stringify({
                    title: title
                }))
            })
        },
        js_sc_pay: function(param, callback) {
            if ("string" === typeof param) {
                param = eval("(" + param + ")")
            }
            if (param.tradeNo) {
                param.tradeNO = param.tradeNo
            }
            window.JSBridge.call("tradePay", param,
            function(res) {
                if (!callback) {
                    defaultHandler(res);
                    return
                }
                if (res) {
                    res.resultStatus = res.resultCode
                }
                callback(JSON.stringify(res))
            })
        },
        js_sc_thirdpay: function(param, callback) {
            if (!param) {
                return
            }
            window.JSBridge.call("tradePay", {
                orderStr: param
            },
            function(res) {
                if (!callback) {
                    defaultHandler(res);
                    return
                }
                if (res) {
                    res.resultStatus = res.resultCode
                }
                if (res.resultStatus == "9000") {
                    if ("function" === typeof callback) {
                        try {
                            callback(JSON.stringify(res))
                        } catch(ex) {}
                    }
                } else {
                    window.JSBridge.call("startApp", {
                        appId: "20000003",
                        param: {
                            sourceId: "MobApp",
                            category: "ALL",
                            actionType: "toBillList"
                        }
                    },
                    function(res) {});
                    window.JSBridge.call("closeWebview")
                }
            })
        },
        js_sc_authcode: function(param, callback) {
            window.JSBridge.call("getThirdPartyAuthcode", {
                appId: param
            },
            function(res) {
                if (!callback) {
                    defaultHandler(res);
                    return
                }
                callback(JSON.stringify(res))
            })
        },
        js_sc_clearcookie: "clearAllCookie",
        js_sc_clientinfo: function(param, callback) {
            if (!param) {
                callback();
                return
            }
            var transParam = {};
            transParam[param] = "";
            window.JSBridge.call("getClientInfo", transParam,
            function(res) {
                if (!callback) {
                    defaultHandler(res);
                    return
                }
                var realResult = {};
                realResult[param] = res[param];
                callback(JSON.stringify(realResult))
            })
        },
        js_sc_exit: function(param, callback) {
            window.JSBridge.call("startApp", {
                appId: "20000001",
                param: {
                    actionType: "20000002"
                }
            },
            function(res) {
                if (!callback) {
                    defaultHandler(res);
                    return
                }
                callback(JSON.stringify(res))
            })
        },
        js_sc_sinasso: function(param, callback) {
            JSBridge.call("sinasso",
            function(res) {
                if (res && "object" === typeof res) {
                    res = JSON.stringify(res)
                }
                callback(res)
            })
        }
    };
    window.bridge = window.WebViewJavascriptBridge = {
        init: function(messageHandler) {
            if (self._messageHandler) {
                return
            }
            self._messageHandler = messageHandler
        },
        callHandler: function(func, param, callback) {
            if (func && "string" === typeof func) {
                var callFun = scanAppCallFunMap[func];
                if (!callFun) {
                    return
                }
                if (callFun && "function" === typeof callFun) {
                    callFun(param, callback)
                } else {
                    if ("string" === typeof callFun) {
                        JSBridge.call(callFun, param, callback)
                    }
                }
            }
        },
        _messageHandler: null
    };
    document.addEventListener("JSBridgeReady",
    function() {
        var doc = document,
        readyEvent = doc.createEvent("Events");
        readyEvent.initEvent("WebViewJavascriptBridgeReady");
        readyEvent.bridge = WebViewJavascriptBridge;
        doc.dispatchEvent(readyEvent)
    })
})();