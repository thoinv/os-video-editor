package com.xvideostudio.videoeditor.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.b;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.ads.AdError;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.funcamerastudio.videomaker.C1522R$dimen;
import com.funcamerastudio.videomaker.C1524R$id;
import com.funcamerastudio.videomaker.C1527R$layout;
import com.google.android.material.tabs.TabLayout;
import com.mopub.mobileads.VastIconXmlManager;
import com.mopub.mobileads.VastVideoViewController;
import com.xvideostudio.videoeditor.VideoEditorApplication;
import com.xvideostudio.videoeditor.VideoMakerApplication;
import com.xvideostudio.videoeditor.activity.Tools;
import com.xvideostudio.videoeditor.adapter.o0;
import com.xvideostudio.videoeditor.adapter.p0;
import com.xvideostudio.videoeditor.ads.handle.ProPrivilegeAdHandle;
import com.xvideostudio.videoeditor.bean.MediaClipBean;
import com.xvideostudio.videoeditor.entity.FxFilterEntity;
import com.xvideostudio.videoeditor.entity.VidCompactThirdPartParam;
import com.xvideostudio.videoeditor.fragment.StoryBoardFragment;
import com.xvideostudio.videoeditor.tool.ImageDetailInfo;
import com.xvideostudio.videoeditor.view.DisableScrollViewPager;
import com.xvideostudio.videoeditor.view.RobotoRegularTextView;
import com.xvideostudio.videoeditor.view.StoryBoardView;
import com.xvideostudio.videoeditor.workmanager.FileScannerWorker;
import com.xvideostudio.videoeditor.x0.c0;
import com.xvideostudio.videoeditor.x0.e0;
import com.xvideostudio.videoeditor.x0.l1;
import com.xvideostudio.videoeditor.x0.m0;
import com.xvideostudio.videoeditor.x0.m1;
import com.xvideostudio.videoeditor.x0.z0;
import hl.productor.ffmpeg.SerializeEditData;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.cookie.ClientCookie;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;
import org.stagex.danmaku.helper.SystemUtility;
import org.xvideo.videoeditor.database.MediaClip;
import org.xvideo.videoeditor.database.MediaDatabase;
import org.xvideo.videoeditor.database.SoundEntity;
import org.xvideo.videoeditor.database.VideoEditData;

public class EditorChooseActivityTab extends BaseActivity implements StoryBoardView.d, StoryBoardFragment.d, o0.e {
    private View A;
    private int B = 0;
    private MediaClip C;
    private MediaClip D;
    private int E = 0;
    private List<ImageDetailInfo> F = null;
    private int G;
    private PopupWindow H;
    private ProgressBar I;
    private RobotoRegularTextView J;
    private PopupWindow K;
    private com.xvideostudio.videoeditor.tool.g L;
    private boolean M = false;
    private RelativeLayout N;
    private PopupWindow O;
    private Toolbar P;
    private TabLayout Q;
    private SoundEntity R;
    private Uri S;
    private RecyclerView T;
    private p0 U;
    private TextView V = null;
    private ImageView W;
    public boolean X;
    final Boolean Y;
    private StoryBoardFragment Z;
    private final List<com.xvideostudio.videoeditor.fragment.o> a0;
    private int b0;
    private boolean c0;
    private Handler d0;
    private int e0;
    Boolean f0;
    private boolean g0;
    z h0;

    /* renamed from: m  reason: collision with root package name */
    private Context f7954m;

    /* renamed from: n  reason: collision with root package name */
    private DisableScrollViewPager f7955n;

    /* renamed from: o  reason: collision with root package name */
    public MediaDatabase f7956o = null;

    /* renamed from: p  reason: collision with root package name */
    private MediaDatabase f7957p = null;
    private boolean q;
    private boolean r;
    private boolean s;
    private String t = "video";
    private String u = "false";
    private boolean v;
    private int w = 0;
    private Dialog x;
    private int y;
    private boolean z;

    /* access modifiers changed from: package-private */
    public class a implements DialogInterface.OnKeyListener {
        a(EditorChooseActivityTab editorChooseActivityTab) {
        }

        public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
            dialogInterface.dismiss();
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public static class a0 extends androidx.fragment.app.n {

        /* renamed from: g  reason: collision with root package name */
        private final List<com.xvideostudio.videoeditor.fragment.o> f7958g;

        /* renamed from: h  reason: collision with root package name */
        private Context f7959h;

        public a0(androidx.fragment.app.k kVar, List<com.xvideostudio.videoeditor.fragment.o> list, Context context) {
            super(kVar);
            ArrayList arrayList = new ArrayList();
            this.f7958g = arrayList;
            arrayList.clear();
            arrayList.addAll(list);
            this.f7959h = context;
        }

        @Override // androidx.viewpager.widget.a
        public int f() {
            return this.f7958g.size();
        }

        @Override // androidx.viewpager.widget.a
        public CharSequence h(int i2) {
            return this.f7959h.getString(this.f7958g.get(i2).j());
        }

        @Override // androidx.fragment.app.n
        public Fragment v(int i2) {
            return this.f7958g.get(i2);
        }
    }

    /* access modifiers changed from: package-private */
    public class b implements Runnable {
        b() {
        }

        public void run() {
            EditorChooseActivityTab.this.z1();
        }
    }

    /* access modifiers changed from: package-private */
    public class c implements Runnable {

        class a implements Runnable {
            a() {
            }

            public void run() {
                Intent intent = new Intent(EditorChooseActivityTab.this.f7954m, EditorActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("load_type", EditorChooseActivityTab.this.t);
                bundle.putString("editor_type", w4.a);
                bundle.putString("editor_mode", w4.b);
                bundle.putInt("contest_id", EditorChooseActivityTab.this.y);
                bundle.putInt("apply_new_theme_id", EditorChooseActivityTab.this.B);
                bundle.putSerializable("item", EditorChooseActivityTab.this.R);
                bundle.putInt("goEditorTtemType", EditorChooseActivityTab.this.b0);
                bundle.putSerializable(MediaDatabase.SERIALIZABLE_EXTRA, EditorChooseActivityTab.this.f7956o);
                intent.putExtras(bundle);
                ArrayList arrayList = new ArrayList();
                if (EditorChooseActivityTab.this.f7956o.getClipArray().size() > 0) {
                    arrayList.add(EditorChooseActivityTab.this.f7956o.getClip(0).path);
                }
                intent.putExtra("selected", 0);
                intent.putExtra("playlist", arrayList);
                intent.putExtra("is_from_editor_choose", true);
                EditorChooseActivityTab.this.startActivity(intent);
                EditorChooseActivityTab.this.finish();
            }
        }

        c() {
        }

        public void run() {
            EditorChooseActivityTab editorChooseActivityTab = EditorChooseActivityTab.this;
            if (editorChooseActivityTab.f7956o.isPrcVideoRel == 0) {
                editorChooseActivityTab.d0.post(new a());
                EditorChooseActivityTab.this.z1();
                return;
            }
            EditorChooseActivityTab.o1(editorChooseActivityTab);
            EditorChooseActivityTab.this.d0.postDelayed(this, 250);
            if (EditorChooseActivityTab.this.w == 2) {
                EditorChooseActivityTab.this.u2();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class d implements Runnable {

        class a implements Runnable {
            a() {
            }

            public void run() {
                EditorChooseActivityTab.this.f7956o.videoMode = -1;
                Intent intent = new Intent();
                if (EditorChooseActivityTab.this.s) {
                    intent.setClass(EditorChooseActivityTab.this.f7954m, EditorClipActivity.class);
                } else {
                    intent.setClass(EditorChooseActivityTab.this.f7954m, EditorActivity.class);
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("isEditorToChooseToEditor", true);
                bundle.putString("load_type", EditorChooseActivityTab.this.t);
                bundle.putString("editor_type", w4.a);
                bundle.putString("editor_mode", w4.b);
                bundle.putInt("apply_new_theme_id", EditorChooseActivityTab.this.B);
                bundle.putInt("goEditorTtemType", EditorChooseActivityTab.this.b0);
                bundle.putSerializable("item", EditorChooseActivityTab.this.R);
                if (EditorChooseActivityTab.this.f7957p != null) {
                    EditorChooseActivityTab.this.f7957p.getClipArray().addAll(EditorChooseActivityTab.this.f7956o.getClipArray());
                    bundle.putSerializable(MediaDatabase.SERIALIZABLE_EXTRA, EditorChooseActivityTab.this.f7957p);
                } else {
                    bundle.putSerializable(MediaDatabase.SERIALIZABLE_EXTRA, EditorChooseActivityTab.this.f7956o);
                }
                intent.putExtras(bundle);
                if (EditorChooseActivityTab.this.s) {
                    EditorChooseActivityTab.this.setResult(1, intent);
                } else {
                    EditorChooseActivityTab.this.setResult(4, intent);
                }
                EditorChooseActivityTab.this.finish();
            }
        }

        d() {
        }

        public void run() {
            EditorChooseActivityTab editorChooseActivityTab = EditorChooseActivityTab.this;
            if (editorChooseActivityTab.f7956o.isPrcVideoRel == 0) {
                editorChooseActivityTab.d0.post(new a());
                return;
            }
            EditorChooseActivityTab.o1(editorChooseActivityTab);
            EditorChooseActivityTab.this.d0.postDelayed(this, 250);
            if (EditorChooseActivityTab.this.w == 2) {
                EditorChooseActivityTab.this.u2();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class e implements Runnable {
        e(EditorChooseActivityTab editorChooseActivityTab) {
        }

        public void run() {
            com.xvideostudio.videoeditor.tool.m.n(2131821293);
        }
    }

    class f implements DialogInterface.OnClickListener {
        f() {
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            m1.a(EditorChooseActivityTab.this.f7954m, "AUTH_CAMERA_REFUSE");
            dialogInterface.dismiss();
        }
    }

    class g implements DialogInterface.OnClickListener {
        g() {
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            m1.a(EditorChooseActivityTab.this.f7954m, "AUTH_CAMERA_ALLOW");
            dialogInterface.dismiss();
            androidx.core.app.a.s(EditorChooseActivityTab.this, new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.RECORD_AUDIO"}, 1);
        }
    }

    class h implements DialogInterface.OnClickListener {
        h() {
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            m1.a(EditorChooseActivityTab.this.f7954m, "AUTH_CAMERA_REFUSE");
            dialogInterface.dismiss();
        }
    }

    class i implements DialogInterface.OnClickListener {
        i() {
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            m1.a(EditorChooseActivityTab.this.f7954m, "AUTH_CAMERA_ALLOW");
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", EditorChooseActivityTab.this.getPackageName(), null));
            EditorChooseActivityTab.this.startActivityForResult(intent, 7);
            dialogInterface.dismiss();
        }
    }

    class j implements Handler.Callback {
        j() {
        }

        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                if (EditorChooseActivityTab.this.L != null && !EditorChooseActivityTab.this.isFinishing() && EditorChooseActivityTab.this.L.isShowing()) {
                    try {
                        EditorChooseActivityTab.this.L.dismiss();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                Intent intent = new Intent(EditorChooseActivityTab.this.f7954m, MyStudioActivity.class);
                intent.putExtra("REQUEST_CODE", 1);
                EditorChooseActivityTab.this.startActivity(intent);
                EditorChooseActivityTab.this.finish();
            } else if (i2 == 2) {
                if (EditorChooseActivityTab.this.L != null && !EditorChooseActivityTab.this.isFinishing() && EditorChooseActivityTab.this.L.isShowing()) {
                    try {
                        EditorChooseActivityTab.this.L.dismiss();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
                String str = w4.a;
                if (str != null && str.equals("gif_photo")) {
                    Intent intent2 = new Intent(EditorChooseActivityTab.this.f7954m, ConfigTextActivity.class);
                    Bundle bundle = new Bundle();
                    Iterator<MediaClip> it = EditorChooseActivityTab.this.f7956o.getClipArray().iterator();
                    while (it.hasNext()) {
                        MediaClip next = it.next();
                        if (next.mediaType == VideoEditData.IMAGE_TYPE) {
                            next.duration = 200;
                            EditorChooseActivityTab.this.f7956o.isUpDurtion = true;
                        }
                    }
                    bundle.putSerializable(MediaDatabase.SERIALIZABLE_EXTRA, EditorChooseActivityTab.this.f7956o);
                    intent2.putExtra("editorRenderTime", 0.0f);
                    intent2.putExtra("editorClipIndex", 0);
                    EditorChooseActivityTab editorChooseActivityTab = EditorChooseActivityTab.this;
                    intent2.putExtra("glWidthEditor", editorChooseActivityTab.B1(editorChooseActivityTab.f7956o)[1]);
                    EditorChooseActivityTab editorChooseActivityTab2 = EditorChooseActivityTab.this;
                    intent2.putExtra("glHeightEditor", editorChooseActivityTab2.B1(editorChooseActivityTab2.f7956o)[2]);
                    intent2.putExtra("editor_type", "gif_photo_activity");
                    intent2.putExtras(bundle);
                    EditorChooseActivityTab.this.startActivity(intent2);
                    EditorChooseActivityTab.this.finish();
                } else if (!EditorChooseActivityTab.this.q) {
                    EditorChooseActivityTab.this.v2();
                } else {
                    EditorChooseActivityTab.this.w2();
                }
            } else if (i2 == 3) {
                if (EditorChooseActivityTab.this.I != null) {
                    EditorChooseActivityTab.this.I.setProgress((EditorChooseActivityTab.this.G * 100) / EditorChooseActivityTab.this.F.size());
                }
                if (EditorChooseActivityTab.this.J != null) {
                    RobotoRegularTextView robotoRegularTextView = EditorChooseActivityTab.this.J;
                    robotoRegularTextView.setText(EditorChooseActivityTab.this.G + "");
                }
            } else if ((i2 == 4 || i2 == 5) && EditorChooseActivityTab.this.H != null && EditorChooseActivityTab.this.H.isShowing()) {
                EditorChooseActivityTab.this.H.dismiss();
                EditorChooseActivityTab.this.H = null;
            }
            return false;
        }
    }

    class k implements DialogInterface.OnClickListener {
        k() {
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            m1.a(EditorChooseActivityTab.this.f7954m, "AUTH_CAMERA_REFUSE");
            dialogInterface.dismiss();
        }
    }

    class l implements DialogInterface.OnClickListener {
        l() {
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            m1.a(EditorChooseActivityTab.this.f7954m, "AUTH_CAMERA_ALLOW");
            dialogInterface.dismiss();
            androidx.core.app.a.s(EditorChooseActivityTab.this, new String[]{"android.permission.CAMERA"}, 1);
        }
    }

    class m implements DialogInterface.OnClickListener {
        m() {
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            m1.a(EditorChooseActivityTab.this.f7954m, "AUTH_CAMERA_REFUSE");
            dialogInterface.dismiss();
        }
    }

    class n implements DialogInterface.OnClickListener {
        n() {
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            m1.a(EditorChooseActivityTab.this.f7954m, "AUTH_CAMERA_ALLOW");
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", EditorChooseActivityTab.this.getPackageName(), null));
            EditorChooseActivityTab.this.startActivityForResult(intent, 6);
            dialogInterface.dismiss();
        }
    }

    class o implements Runnable {
        o() {
        }

        public void run() {
            int i2 = 0;
            while (!EditorChooseActivityTab.this.f7956o.isCachePictrueFinished()) {
                i2++;
                try {
                    Thread.sleep(100);
                    if (i2 == 200) {
                        break;
                    }
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            EditorChooseActivityTab.this.d0.sendEmptyMessage(2);
        }
    }

    /* access modifiers changed from: package-private */
    public class p implements DialogInterface.OnClickListener {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ String f7975f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ String f7976g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ String f7977h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ int[] f7978i;

        p(String str, String str2, String str3, int[] iArr) {
            this.f7975f = str;
            this.f7976g = str2;
            this.f7977h = str3;
            this.f7978i = iArr;
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
            Intent intent = new Intent(EditorChooseActivityTab.this.f7954m, TrimQuickActivity.class);
            if (this.f7975f.equals("trim")) {
                m1.b(EditorChooseActivityTab.this.f7954m, "TRANSCORD_REFUSE", "主页TRIM");
            } else if (this.f7975f.equals("multi_trim")) {
                m1.b(EditorChooseActivityTab.this.f7954m, "TRANSCORD_REFUSE", "主页TRIM");
                EditorChooseActivityTab.this.X = true;
                intent = new Intent(EditorChooseActivityTab.this.f7954m, TrimMultiSelectClipActivity.class);
            } else if (this.f7975f.equals("mp3")) {
                m1.b(EditorChooseActivityTab.this.f7954m, "TRANSCORD_REFUSE", "VIDEO TO MP3");
                EditorChooseActivityTab.this.X = true;
                intent = new Intent(EditorChooseActivityTab.this.f7954m, TrimActivity.class);
                intent.putExtra("trimaudio", 1);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f7976g);
            intent.putExtra("editor_type", w4.a);
            intent.putExtra("selected", 0);
            intent.putExtra("playlist", arrayList);
            intent.putExtra("name", this.f7977h);
            intent.putExtra(ClientCookie.PATH_ATTR, this.f7976g);
            intent.putExtra(VastIconXmlManager.DURATION, this.f7978i[3]);
            EditorChooseActivityTab.this.startActivity(intent);
            if (this.f7975f.equals("multi_trim") || this.f7975f.equals("mp3")) {
                EditorChooseActivityTab.this.finish();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class q implements DialogInterface.OnClickListener {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int[] f7980f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ String f7981g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ String f7982h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ String f7983i;

        q(int[] iArr, String str, String str2, String str3) {
            this.f7980f = iArr;
            this.f7981g = str;
            this.f7982h = str2;
            this.f7983i = str3;
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
            EditorChooseActivityTab.this.H2(this.f7980f, this.f7981g, this.f7982h, this.f7983i);
        }
    }

    /* access modifiers changed from: package-private */
    public class r implements Tools.p {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f7985c;

        r(String str, String str2, String str3) {
            this.a = str;
            this.b = str2;
            this.f7985c = str3;
        }

        @Override // com.xvideostudio.videoeditor.activity.Tools.p
        public void a(String str, MediaDatabase mediaDatabase) {
            if (EditorChooseActivityTab.this.Y.booleanValue()) {
                new com.xvideostudio.videoeditor.z.f(EditorChooseActivityTab.this.f7954m, new File(str));
                z4.b = true;
                com.xvideostudio.videoeditor.t.b = null;
                Tools.c();
                int[] O = Tools.O(str);
                Intent intent = new Intent(EditorChooseActivityTab.this.f7954m, TrimQuickActivity.class);
                if (this.a.equals("trim")) {
                    m1.b(EditorChooseActivityTab.this.f7954m, "TRANSCORD_SUCCESS", "主页TRIM");
                } else if (this.a.equals("multi_trim")) {
                    m1.b(EditorChooseActivityTab.this.f7954m, "TRANSCORD_SUCCESS", "主页TRIM");
                    EditorChooseActivityTab.this.X = true;
                    intent = new Intent(EditorChooseActivityTab.this.f7954m, TrimMultiSelectClipActivity.class);
                } else if (this.a.equals("mp3")) {
                    m1.b(EditorChooseActivityTab.this.f7954m, "TRANSCORD_SUCCESS", "VIDEO TO MP3");
                    EditorChooseActivityTab.this.X = true;
                    intent = new Intent(EditorChooseActivityTab.this.f7954m, TrimActivity.class);
                    intent.putExtra("trimaudio", 1);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                intent.putExtra("editor_type", w4.a);
                intent.putExtra("selected", 0);
                intent.putExtra("playlist", arrayList);
                intent.putExtra("name", this.b);
                intent.putExtra(ClientCookie.PATH_ATTR, str);
                intent.putExtra(VastIconXmlManager.DURATION, O[3]);
                EditorChooseActivityTab.this.startActivity(intent);
                if (this.a.equals("multi_trim") || this.a.equals("mp3")) {
                    EditorChooseActivityTab.this.finish();
                    return;
                }
                return;
            }
            m0.o(this.f7985c);
            m0.c0(str, this.f7985c);
            new com.xvideostudio.videoeditor.z.f(EditorChooseActivityTab.this.f7954m, new File(this.f7985c));
            z4.b = true;
            com.xvideostudio.videoeditor.t.b = null;
            Tools.c();
            int[] O2 = Tools.O(this.f7985c);
            Intent intent2 = new Intent(EditorChooseActivityTab.this.f7954m, TrimQuickActivity.class);
            if (this.a.equals("trim")) {
                m1.b(EditorChooseActivityTab.this.f7954m, "TRANSCORD_SUCCESS", "主页TRIM");
            } else if (this.a.equals("multi_trim")) {
                m1.b(EditorChooseActivityTab.this.f7954m, "TRANSCORD_SUCCESS", "主页TRIM");
                EditorChooseActivityTab.this.X = true;
                intent2 = new Intent(EditorChooseActivityTab.this.f7954m, TrimMultiSelectClipActivity.class);
            } else if (this.a.equals("mp3")) {
                m1.b(EditorChooseActivityTab.this.f7954m, "TRANSCORD_SUCCESS", "VIDEO TO MP3");
                EditorChooseActivityTab.this.X = true;
                intent2 = new Intent(EditorChooseActivityTab.this.f7954m, TrimActivity.class);
                intent2.putExtra("trimaudio", 1);
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(this.f7985c);
            intent2.putExtra("editor_type", w4.a);
            intent2.putExtra("selected", 0);
            intent2.putExtra("playlist", arrayList2);
            intent2.putExtra("name", this.b);
            intent2.putExtra(ClientCookie.PATH_ATTR, this.f7985c);
            intent2.putExtra(VastIconXmlManager.DURATION, O2[3]);
            EditorChooseActivityTab.this.startActivity(intent2);
            if (this.a.equals("multi_trim") || this.a.equals("mp3")) {
                EditorChooseActivityTab.this.finish();
            }
        }
    }

    class s implements DialogInterface.OnClickListener {
        s() {
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            m1.a(EditorChooseActivityTab.this.f7954m, "AUTH_CAMERA_REFUSE");
            dialogInterface.dismiss();
        }
    }

    class t implements DialogInterface.OnClickListener {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f7988f;

        t(int i2) {
            this.f7988f = i2;
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            m1.a(EditorChooseActivityTab.this.f7954m, "AUTH_CAMERA_ALLOW");
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", EditorChooseActivityTab.this.f7954m.getPackageName(), null));
            EditorChooseActivityTab.this.startActivityForResult(intent, this.f7988f);
            dialogInterface.dismiss();
        }
    }

    /* access modifiers changed from: package-private */
    public class u implements View.OnClickListener {
        u() {
        }

        public void onClick(View view) {
            EditorChooseActivityTab editorChooseActivityTab = EditorChooseActivityTab.this;
            if (!(editorChooseActivityTab == null || editorChooseActivityTab.isFinishing() || EditorChooseActivityTab.this.L == null)) {
                EditorChooseActivityTab.this.L.show();
            }
            com.xvideostudio.videoeditor.tool.m.p(2131820896, -1, 0);
            VideoEditorApplication.y().q().t();
            EditorChooseActivityTab editorChooseActivityTab2 = EditorChooseActivityTab.this;
            editorChooseActivityTab2.Y0(editorChooseActivityTab2.f7956o);
            EditorChooseActivityTab.this.d0.sendEmptyMessageDelayed(1, 500);
        }
    }

    /* access modifiers changed from: package-private */
    public class v implements View.OnClickListener {
        v() {
        }

        public void onClick(View view) {
            if (com.xvideostudio.videoeditor.tool.w.a(EditorChooseActivityTab.this.f7954m).equals("false")) {
                Intent intent = new Intent();
                intent.setClass(EditorChooseActivityTab.this.f7954m, MainActivity.class);
                EditorChooseActivityTab.this.startActivity(intent);
            }
            EditorChooseActivityTab.this.finish();
        }
    }

    /* access modifiers changed from: package-private */
    public class w implements DialogInterface.OnKeyListener {
        w() {
        }

        public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
            if (i2 != 4) {
                return false;
            }
            EditorChooseActivityTab.this.x.dismiss();
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public class x implements View.OnClickListener {
        x() {
        }

        public void onClick(View view) {
            VideoMakerApplication.B0(EditorChooseActivityTab.this);
        }
    }

    /* access modifiers changed from: package-private */
    public class y implements View.OnClickListener {
        y(EditorChooseActivityTab editorChooseActivityTab) {
        }

        public void onClick(View view) {
        }
    }

    public interface z {
        void a(boolean z);
    }

    public EditorChooseActivityTab() {
        Boolean bool = Boolean.TRUE;
        this.Y = bool;
        this.a0 = new ArrayList();
        this.b0 = -1;
        this.c0 = false;
        this.d0 = new Handler(new j());
        this.e0 = 1;
        this.f0 = bool;
        this.g0 = false;
    }

    private void A1(int i2, int i3, int i4) {
        com.xvideostudio.videoeditor.x0.p2.b.a(0, "SELECT_CLICK_NEXT", null);
        if (i4 == 1) {
            com.xvideostudio.videoeditor.x0.p2.b.a(0, "SELECT_CLIP_1", null);
        } else if (i4 > 1 || i4 < 5) {
            com.xvideostudio.videoeditor.x0.p2.b.a(0, "SELECT_CLIP_2_4", null);
        } else {
            com.xvideostudio.videoeditor.x0.p2.b.a(0, "SELECT_CLIP_4", null);
        }
        if (i2 == 0) {
            com.xvideostudio.videoeditor.x0.p2.b.a(0, "SELECT_VIDEO_ONLY", null);
        } else if (i3 == 0) {
            com.xvideostudio.videoeditor.x0.p2.b.a(0, "SELECT_PICTURE_ONLY", null);
        }
    }

    private void A2(MediaClip mediaClip, SoundEntity soundEntity) {
        if (soundEntity != null) {
            mediaClip.videoSound = soundEntity;
            this.f7956o.isCameraAudio = true;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0117  */
    private int[] B1(MediaDatabase mediaDatabase) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if (mediaDatabase == null) {
            int i7 = VideoEditorApplication.w;
            return new int[]{0, i7, i7};
        }
        ArrayList<MediaClip> clipArray = mediaDatabase.getClipArray();
        if (clipArray == null) {
            int i8 = VideoEditorApplication.w;
            return new int[]{0, i8, i8};
        }
        Object[] clipType = mediaDatabase.getClipType();
        int intValue = ((Integer) clipType[0]).intValue();
        ArrayList arrayList = (ArrayList) clipType[1];
        int i9 = mediaDatabase.videoMode;
        if (i9 == -1) {
            if (intValue == 0 || intValue == 1) {
                i9 = 0;
            } else if (intValue == 2) {
                i9 = 2;
            } else if (intValue == 3) {
                i9 = 1;
            }
        }
        PrintStream printStream = System.out;
        printStream.println("videoMode:" + mediaDatabase.videoMode);
        clipArray.size();
        float f2 = 0.0f;
        if (i9 != 0) {
            if (i9 == 1) {
                i2 = VideoEditorApplication.w;
                hl.productor.fxlib.h.x = false;
                i3 = i2;
            } else if (i9 != 2) {
                i3 = 0;
            } else {
                hl.productor.fxlib.h.x = true;
                i2 = VideoEditorApplication.w;
                int size = arrayList.size();
                if (size != 0) {
                    int i10 = 0;
                    for (int i11 = 0; i11 < size; i11++) {
                        MediaClipBean mediaClipBean = (MediaClipBean) arrayList.get(i11);
                        int i12 = mediaClipBean.height;
                        if (i12 != 0) {
                            float f3 = (((float) mediaClipBean.width) * 1.0f) / ((float) i12);
                            if (f3 > f2) {
                                i10 = i11;
                                f2 = f3;
                            }
                        }
                    }
                    MediaClipBean mediaClipBean2 = (MediaClipBean) arrayList.get(i10);
                    int i13 = mediaClipBean2.width;
                    int i14 = mediaClipBean2.height;
                    if (i13 != 0) {
                        i3 = (i13 * i2) / i14;
                    }
                }
                i3 = 0;
            }
            i4 = VideoEditorApplication.w;
            if (i3 > i4) {
                i3 = i4;
            }
            i5 = VideoEditorApplication.x;
            if (i2 > i5) {
                i2 = i5;
            }
            PrintStream printStream2 = System.out;
            printStream2.println("after videoMode:" + mediaDatabase.videoMode);
            return new int[]{intValue, i3, i2};
        }
        if (intValue == 2) {
            i3 = VideoEditorApplication.w;
            i2 = (i3 * 9) / 16;
        } else {
            hl.productor.fxlib.h.x = true;
            int i15 = VideoEditorApplication.w;
            int size2 = arrayList.size();
            if (size2 == 0) {
                i3 = i15;
            } else {
                int i16 = 0;
                for (int i17 = 0; i17 < size2; i17++) {
                    MediaClipBean mediaClipBean3 = (MediaClipBean) arrayList.get(i17);
                    int i18 = mediaClipBean3.width;
                    if (i18 != 0 && mediaClipBean3.orientationType == 0) {
                        float f4 = (((float) i18) * 1.0f) / ((float) mediaClipBean3.height);
                        if (f4 > f2) {
                            i16 = i17;
                            f2 = f4;
                        }
                    }
                }
                MediaClipBean mediaClipBean4 = (MediaClipBean) arrayList.get(i16);
                int i19 = mediaClipBean4.width;
                int i20 = mediaClipBean4.height;
                if (i19 == 0) {
                    i6 = 0;
                } else {
                    i6 = (i20 * i15) / i19;
                }
                if (((double) (((float) i6) / ((float) i15))) < 0.5625d) {
                    i6 = (VideoEditorApplication.w * 9) / 16;
                }
                i3 = i15;
                i2 = i6;
            }
        }
        i4 = VideoEditorApplication.w;
        if (i3 > i4) {
        }
        i5 = VideoEditorApplication.x;
        if (i2 > i5) {
        }
        PrintStream printStream22 = System.out;
        printStream22.println("after videoMode:" + mediaDatabase.videoMode);
        return new int[]{intValue, i3, i2};
        i2 = 0;
        i4 = VideoEditorApplication.w;
        if (i3 > i4) {
        }
        i5 = VideoEditorApplication.x;
        if (i2 > i5) {
        }
        PrintStream printStream222 = System.out;
        printStream222.println("after videoMode:" + mediaDatabase.videoMode);
        return new int[]{intValue, i3, i2};
    }

    private void B2(com.xvideostudio.videoeditor.tool.p pVar) {
        for (com.xvideostudio.videoeditor.fragment.o oVar : this.a0) {
            oVar.r(pVar.f11083c);
        }
    }

    private synchronized void C1(ImageDetailInfo imageDetailInfo, int i2) {
        if (imageDetailInfo != null) {
            int addClip = this.f7956o.addClip(imageDetailInfo.f10946i, imageDetailInfo.f10947j, this.t, false, true);
            Handler handler = this.d0;
            if (handler != null) {
                handler.post(new x1(this, addClip, imageDetailInfo, i2));
            }
        }
    }

    private void C2(String str) {
        if (str != null) {
            z4.f8906c = Uri.parse(str);
        }
    }

    private void D2() {
        e0.o(this, "", getString(2131821649), false, false, new x(), new y(this), new a(this), true);
    }

    private void E1() {
        if (getIntent() != null && getIntent().hasExtra("contest_id")) {
            this.y = getIntent().getIntExtra("contest_id", 0);
        }
        String Y2 = com.xvideostudio.videoeditor.l0.b.Y(3);
        String I2 = VideoEditorApplication.I();
        File file = new File(Y2);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.B = getIntent().getIntExtra("apply_new_theme_id", 0);
        this.s = getIntent().getBooleanExtra("isAddClip", false);
        this.R = (SoundEntity) getIntent().getSerializableExtra("item");
        MediaDatabase mediaDatabase = (MediaDatabase) getIntent().getSerializableExtra(MediaDatabase.SERIALIZABLE_EXTRA);
        this.f7956o = mediaDatabase;
        if (this.s) {
            this.f7957p = mediaDatabase;
            this.f7956o = null;
        }
        if (this.f7956o == null) {
            this.f7956o = new MediaDatabase(Y2, I2);
        }
        if ("input".equals(getIntent().getStringExtra("type"))) {
            this.q = true;
        } else {
            this.q = false;
            MediaDatabase mediaDatabase2 = this.f7956o;
            if (mediaDatabase2 != null) {
                ArrayList<MediaClip> clipArray = mediaDatabase2.getClipArray();
                if (clipArray == null || clipArray.size() <= 1) {
                    this.D = null;
                    this.C = null;
                } else {
                    MediaClip mediaClip = clipArray.get(clipArray.size() - 1);
                    this.D = mediaClip;
                    if (mediaClip.isAppendClip) {
                        clipArray.remove(clipArray.size() - 1);
                    } else {
                        this.D = null;
                    }
                    if (clipArray.size() > 1) {
                        MediaClip mediaClip2 = clipArray.get(0);
                        this.C = mediaClip2;
                        if (mediaClip2.isAppendClip) {
                            clipArray.remove(0);
                        } else {
                            this.C = null;
                        }
                    } else {
                        this.C = null;
                    }
                }
            }
        }
        if (this.f7956o == null) {
            this.f7956o = new MediaDatabase(Y2, I2);
        }
        x2();
        this.r = getIntent().getBooleanExtra("isEditorAddClip", false);
        String stringExtra = getIntent().getStringExtra("load_type");
        this.t = stringExtra;
        if (!"video".equals(stringExtra) && !MessengerShareContentUtility.MEDIA_IMAGE.equals(this.t)) {
            "image/video".equals(this.t);
        }
        String stringExtra2 = getIntent().getStringExtra("bottom_show");
        this.u = stringExtra2;
        if (stringExtra2 == null) {
            this.u = "false";
        }
        w4.b = getIntent().getStringExtra("editor_mode");
        String stringExtra3 = getIntent().getStringExtra("editortype");
        w4.a = stringExtra3;
        if (stringExtra3 == null) {
            w4.a = "editor_video";
        }
        "editor_photo".equals(w4.a);
    }

    /* access modifiers changed from: private */
    public void E2(View view) {
        com.xvideostudio.videoeditor.x0.p2.b.a(0, "CLIPCHOOSE_PAGE_LISTPOP_SHOW", null);
        if (this.O == null) {
            View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(C1527R$layout.popwindow_folder_dropdown, (ViewGroup) null);
            RecyclerView recyclerView = (RecyclerView) inflate.findViewById(2131297551);
            this.T = recyclerView;
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            p0 p0Var = new p0(this, this.e0, new l2(this));
            this.U = p0Var;
            this.T.setAdapter(p0Var);
            this.U.i(com.xvideostudio.videoeditor.workmanager.a.f11736e.a(this.e0));
            int c2 = com.xvideostudio.videoeditor.x0.u2.e.c(this);
            int dimensionPixelSize = getResources().getDimensionPixelSize(C1522R$dimen.actionbar_height_folder);
            if (Build.VERSION.SDK_INT >= 26) {
                dimensionPixelSize += c2;
            }
            PopupWindow popupWindow = new PopupWindow(inflate, -1, com.xvideostudio.videoeditor.x0.u2.d.b(this) - dimensionPixelSize);
            this.O = popupWindow;
            popupWindow.setOnDismissListener(new a2(this));
            inflate.setOnClickListener(new m2(this));
        }
        this.O.setFocusable(true);
        this.O.setOutsideTouchable(true);
        this.O.setBackgroundDrawable(new ColorDrawable(0));
        this.W.setSelected(true);
        this.O.showAsDropDown(view);
    }

    private void F1(boolean z2) {
        if (!z2) {
            this.f7955n.setVisibility(0);
        }
        invalidateOptionsMenu();
    }

    private void F2(int[] iArr, String str, String str2, String str3) {
        if (!this.f7438h) {
            new b.a(this).setMessage(2131822056).setPositiveButton(2131821518, new q(iArr, str, str2, str3)).setNegativeButton(2131820684, new p(str3, str, str2, iArr)).show();
        }
    }

    private void G2(String str) {
        if (str.startsWith("content")) {
            Cursor query = getContentResolver().query(Uri.parse(str), new String[]{"_data"}, null, null, null);
            if (query.getCount() == 0 || query.getColumnCount() == 0) {
                query.close();
                return;
            }
            int columnIndexOrThrow = query.getColumnIndexOrThrow("_data");
            query.moveToFirst();
            String string = query.getString(columnIndexOrThrow);
            query.close();
            String str2 = "record video path: " + str;
            String str3 = "real video path: " + string;
            str = string;
        }
        new com.xvideostudio.videoeditor.z.f(this, new File(str));
        ImageDetailInfo imageDetailInfo = new ImageDetailInfo();
        imageDetailInfo.f10947j = str;
        imageDetailInfo.f10953p = str.substring(str.lastIndexOf(File.separator) + 1, str.length());
        D1(imageDetailInfo, 0);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void H2(int[] iArr, String str, String str2, String str3) {
        String str4;
        long j2;
        int i2;
        long j3 = ((long) ((((iArr[0] * iArr[1]) * 14) * (iArr[3] / 1000)) / 8)) / 1024;
        int i3 = VideoEditorApplication.c0() ? 2 : 1;
        long J2 = Tools.J(i3);
        if (j3 > J2) {
            if (VideoEditorApplication.A) {
                int i4 = 1;
                if (i3 == 1) {
                    j2 = Tools.J(2);
                    i2 = 2131821046;
                } else {
                    j2 = Tools.J(1);
                    i2 = 2131821047;
                    i4 = 0;
                }
                if (j3 >= j2) {
                    String str5 = "Have two sd card~" + getResources().getString(2131821504) + ", " + getResources().getString(2131821506) + " " + j3 + " KB, " + getResources().getString(2131821505) + " " + j2 + " KB ";
                    m1.b(this, "NOT_ENOUGHSPACE_TRANSCODE", "model:" + Build.MODEL + ":" + str5);
                    com.xvideostudio.videoeditor.tool.m.t(str5, -1, VastVideoViewController.DEFAULT_VIDEO_DURATION_FOR_CLOSE_BUTTON);
                    return;
                }
                EditorActivity.i8(this, i2, i4);
            } else {
                String str6 = "Only one sd card~" + getResources().getString(2131821504) + ", " + getResources().getString(2131821506) + " " + j3 + " KB, " + getResources().getString(2131821505) + " " + J2 + " KB ";
                m1.b(this, "NOT_ENOUGHSPACE_TRANSCODE", "model:" + Build.MODEL + ":" + str6);
                com.xvideostudio.videoeditor.tool.m.t(str6, -1, VastVideoViewController.DEFAULT_VIDEO_DURATION_FOR_CLOSE_BUTTON);
                return;
            }
        }
        File file = new File(com.xvideostudio.videoeditor.l0.b.Y(3));
        if (!file.exists()) {
            file.mkdirs();
        }
        if (z0.f(m0.D(str2))) {
            str4 = file + "/" + com.xvideostudio.videoeditor.l0.b.t0(this.f7954m, ".mp4", str2, 0);
        } else {
            str4 = file + "/" + com.xvideostudio.videoeditor.l0.b.V(this.f7954m, ".mp4", "");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        SerializeEditData c02 = Tools.c0(this.f7954m, 0, arrayList, str4, "", 0, 0, iArr[0], iArr[1], 0);
        Tools tools = null;
        if (str3.equals("trim")) {
            m1.b(this.f7954m, "TRANSCORD_AGREE", "主页TRIM");
            tools = new Tools(this, 1, null, c02, "trim", Boolean.TRUE);
        } else if (str3.equals("multi_trim")) {
            m1.b(this.f7954m, "TRANSCORD_AGREE", "主页TRIM");
            tools = new Tools(this, 1, null, c02, "multi_trim", Boolean.TRUE);
        } else if (str3.equals("mp3")) {
            m1.b(this.f7954m, "TRANSCORD_AGREE", "VIDEO TO MP3");
            tools = new Tools(this, 1, null, c02, "mp3", Boolean.TRUE);
        }
        if (tools.f8558c) {
            tools.l0(this, Boolean.TRUE);
        } else {
            if (str3.equals("trim")) {
                m1.b(this.f7954m, "TRANSCORD_FAIL", "主页TRIM");
            } else if (str3.equals("multi_trim")) {
                m1.b(this.f7954m, "TRANSCORD_FAIL", "主页TRIM");
            } else if (str3.equals("mp3")) {
                m1.b(this.f7954m, "TRANSCORD_FAIL", "VIDEO TO MP3");
            }
            com.xvideostudio.videoeditor.tool.m.t(this.f7954m.getResources().getString(2131821052), -1, 1);
            finish();
        }
        tools.i0(new r(str3, str2, str));
    }

    /* access modifiers changed from: private */
    /* renamed from: K1 */
    public /* synthetic */ void L1(int i2, ImageDetailInfo imageDetailInfo, int i3) {
        switch (i2) {
            case 1:
                com.xvideostudio.videoeditor.tool.m.t(getResources().getString(2131822015), -1, 1);
                return;
            case 2:
                com.xvideostudio.videoeditor.tool.m.t(getResources().getString(2131822080), -1, 1);
                if (imageDetailInfo.f10944g == -9998) {
                    m1.a(this.f7954m, "NOT_SUPPORTED_FORMAT_VIA_THRID_PART");
                    return;
                }
                return;
            case 3:
                com.xvideostudio.videoeditor.tool.m.n(2131821546);
                return;
            case 4:
                com.xvideostudio.videoeditor.tool.m.p(2131821018, -1, 1);
                return;
            case 5:
                com.xvideostudio.videoeditor.tool.m.p(2131821019, -1, 1);
                return;
            case 6:
                if (MessengerShareContentUtility.MEDIA_IMAGE.equals(this.t)) {
                    com.xvideostudio.videoeditor.tool.m.p(2131820608, -1, 1);
                    return;
                } else if ("video".equals(this.t)) {
                    com.xvideostudio.videoeditor.tool.m.p(2131820608, -1, 1);
                    return;
                } else {
                    return;
                }
            case 7:
            default:
                imageDetailInfo.f10943f++;
                ArrayList<MediaClip> clipArray = this.f7956o.getClipArray();
                if (imageDetailInfo.f10949l > 0 && clipArray.size() > 0) {
                    imageDetailInfo.f10949l = (long) clipArray.get(clipArray.size() - 1).duration;
                }
                imageDetailInfo.f10948k = 1;
                o0.d dVar = new o0.d();
                dVar.a = i3;
                org.greenrobot.eventbus.c.c().l(dVar);
                com.xvideostudio.videoeditor.workmanager.a.f11735d.add(imageDetailInfo.f10947j);
                this.Z.h(clipArray);
                if (imageDetailInfo.f10943f >= 2 && MessengerShareContentUtility.MEDIA_IMAGE.equals(this.t)) {
                    m1.a(this.f7954m, "SLIDESHOW_CHOOSE_REPEATED_CLIP");
                    return;
                }
                return;
            case 8:
                com.xvideostudio.videoeditor.tool.m.n(2131821510);
                return;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: M1 */
    public /* synthetic */ void N1(View view) {
        com.xvideostudio.videoeditor.b1.a.d(this.f7954m, "import_2gb", true);
    }

    /* access modifiers changed from: private */
    /* renamed from: O1 */
    public /* synthetic */ void P1(View view) {
        ProPrivilegeAdHandle.getInstance().showAdmobVideoAd("import_2gb", this);
    }

    /* access modifiers changed from: private */
    /* renamed from: Q1 */
    public /* synthetic */ void R1(ImageDetailInfo imageDetailInfo, boolean z2) {
        Tools.c();
        int[] P2 = Tools.P(imageDetailInfo.f10947j, imageDetailInfo.f10946i);
        if (P2 != null) {
            if (this.u.equals("false") && z2) {
                String str = imageDetailInfo.f10947j;
                Uri uri = imageDetailInfo.f10946i;
                boolean a02 = c0.a0(str, uri != null ? uri.toString() : null);
                if (!a02) {
                    this.d0.post(j2.f8781f);
                    m1.b(this.f7954m, "TRIM_ACTIVITY_ACTION_VIEW_FAIL", "VIDEO_IS_SUPPORTED_OR_NOTBMP_EDITORCHOOSE");
                    return;
                }
                if (!SystemUtility.isSupportVideoEnFormat(imageDetailInfo.f10947j, P2)) {
                    this.d0.post(new h2(this));
                    Context context = this.f7954m;
                    m1.b(context, "TRIM_ACTIVITY_ACTION_VIEW_FAIL", "VIDEO_SUPPORT_NOT_FROMT_ENCODE_EditorChoose" + w4.a);
                    if (imageDetailInfo.f10944g == -9998) {
                        m1.a(this.f7954m, "NOT_SUPPORTED_FORMAT_VIA_THRID_PART");
                    }
                }
                if (!a02 && P2[0] * P2[1] > (hl.productor.fxlib.h.Z + 8) * (hl.productor.fxlib.h.Y + 8)) {
                    this.d0.post(g2.f8757f);
                    m1.b(this.f7954m, "TRIM_ACTIVITY_ACTION_VIEW_FAIL", "TOO_BIG_VIDEO_EDITORCHOOSE");
                    return;
                }
            }
            Handler handler = this.d0;
            if (handler != null) {
                handler.post(new i2(this, P2, z2, imageDetailInfo));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: S1 */
    public /* synthetic */ void T1(ImageDetailInfo imageDetailInfo, int i2) {
        try {
            C1(imageDetailInfo, i2);
        } catch (OutOfMemoryError unused) {
            System.gc();
        }
    }

    static /* synthetic */ boolean U1(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: W1 */
    public /* synthetic */ void X1() {
        com.xvideostudio.videoeditor.tool.m.t(getResources().getString(2131822080), -1, 1);
    }

    /* access modifiers changed from: private */
    /* renamed from: Z1 */
    public /* synthetic */ void a2(View view) {
        com.xvideostudio.videoeditor.b1.a.d(this.f7954m, "import_4k", true);
    }

    /* access modifiers changed from: private */
    /* renamed from: b2 */
    public /* synthetic */ void c2(View view) {
        ProPrivilegeAdHandle.getInstance().showAdmobVideoAd("import_4k", this);
    }

    static /* synthetic */ boolean d2(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: e2 */
    public /* synthetic */ void f2(int[] iArr, boolean z2, ImageDetailInfo imageDetailInfo) {
        int min = Math.min(iArr[0], iArr[1]);
        if (com.xvideostudio.videoeditor.u.B1() && !com.xvideostudio.videoeditor.tool.c0.b(this.f7954m) && min > hl.productor.fxlib.h.f13178d) {
            if (com.xvideostudio.videoeditor.u.d(this.f7954m).booleanValue()) {
                com.xvideostudio.videoeditor.u.Q1(this.f7954m, Boolean.FALSE);
            } else if (com.xvideostudio.videoeditor.q.c("import_4k")) {
                com.xvideostudio.videoeditor.q.e("import_4k", false);
            } else if (!com.xvideostudio.videoeditor.u.C0(this.f7954m).booleanValue() || !ProPrivilegeAdHandle.getInstance().isAdSuccess()) {
                com.xvideostudio.videoeditor.b1.a.c(this.f7954m, "import_4k");
                return;
            } else {
                com.xvideostudio.videoeditor.b0.j.t(this, new k2(this), new n2(this), c2.f8729f, "import_4k");
                return;
            }
        }
        if (!this.u.equals("false")) {
            return;
        }
        if (w4.a.equals("trim")) {
            if (!z2) {
                com.xvideostudio.videoeditor.tool.m.p(2131822080, -1, 1);
                if (imageDetailInfo.f10944g == -9998) {
                    m1.a(this.f7954m, "NOT_SUPPORTED_FORMAT_VIA_THRID_PART");
                }
            } else if (iArr == null || iArr[6] <= hl.productor.fxlib.h.f0) {
                Intent intent = new Intent(this.f7954m, TrimQuickActivity.class);
                ArrayList arrayList = new ArrayList();
                arrayList.add(imageDetailInfo.f10947j);
                intent.putExtra("editor_type", w4.a);
                intent.putExtra("selected", 0);
                intent.putExtra("playlist", arrayList);
                intent.putExtra("name", imageDetailInfo.f10953p);
                intent.putExtra(ClientCookie.PATH_ATTR, imageDetailInfo.f10947j);
                intent.putExtra(VastIconXmlManager.DURATION, iArr[3]);
                startActivity(intent);
            } else {
                F2(iArr, imageDetailInfo.f10947j, imageDetailInfo.f10953p, w4.a);
            }
        } else if (w4.a.equals("multi_trim")) {
            if (!z2) {
                com.xvideostudio.videoeditor.tool.m.p(2131822080, -1, 1);
                if (imageDetailInfo.f10944g == -9998) {
                    m1.a(this.f7954m, "NOT_SUPPORTED_FORMAT_VIA_THRID_PART");
                }
            } else if (iArr == null || iArr[6] <= hl.productor.fxlib.h.f0) {
                Intent intent2 = new Intent(this.f7954m, TrimMultiSelectClipActivity.class);
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(imageDetailInfo.f10947j);
                intent2.putExtra("editor_type", w4.a);
                intent2.putExtra("selected", 0);
                intent2.putExtra("playlist", arrayList2);
                intent2.putExtra("name", imageDetailInfo.f10953p);
                intent2.putExtra(ClientCookie.PATH_ATTR, imageDetailInfo.f10947j);
                intent2.putExtra(VastIconXmlManager.DURATION, iArr[3]);
                startActivity(intent2);
                finish();
            } else {
                F2(iArr, imageDetailInfo.f10947j, imageDetailInfo.f10953p, w4.a);
            }
        } else if (w4.a.equals("mp3")) {
            if (!z2) {
                com.xvideostudio.videoeditor.tool.m.p(2131822080, -1, 1);
                if (imageDetailInfo.f10944g == -9998) {
                    m1.a(this.f7954m, "NOT_SUPPORTED_FORMAT_VIA_THRID_PART");
                }
            } else if (iArr[4] == 0) {
                com.xvideostudio.videoeditor.tool.m.p(2131821411, -1, 1);
            } else if (iArr.length != 5 && iArr[5] != 86017 && iArr[5] != 86018) {
                com.xvideostudio.videoeditor.tool.m.p(2131822125, -1, 1);
            } else if (iArr == null || iArr[6] <= hl.productor.fxlib.h.f0) {
                Intent intent3 = new Intent(this.f7954m, TrimActivity.class);
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(imageDetailInfo.f10947j);
                intent3.putExtra("editor_type", w4.a);
                intent3.putExtra("selected", 0);
                intent3.putExtra("playlist", arrayList3);
                intent3.putExtra("name", imageDetailInfo.f10953p);
                intent3.putExtra(ClientCookie.PATH_ATTR, imageDetailInfo.f10947j);
                intent3.putExtra(VastIconXmlManager.DURATION, iArr[3]);
                intent3.putExtra("trimaudio", 1);
                startActivity(intent3);
                finish();
            } else {
                F2(iArr, imageDetailInfo.f10947j, imageDetailInfo.f10953p, w4.a);
            }
        } else if (w4.a.equals("compress")) {
            if (!z2) {
                com.xvideostudio.videoeditor.tool.m.p(2131822080, -1, 1);
                if (imageDetailInfo.f10944g == -9998) {
                    m1.a(this.f7954m, "NOT_SUPPORTED_FORMAT_VIA_THRID_PART");
                    return;
                }
                return;
            }
            Intent intent4 = new Intent(this.f7954m, TrimActivity.class);
            ArrayList arrayList4 = new ArrayList();
            arrayList4.add(imageDetailInfo.f10947j);
            intent4.putExtra("editor_type", w4.a);
            intent4.putExtra("selected", 0);
            intent4.putExtra("playlist", arrayList4);
            intent4.putExtra("name", imageDetailInfo.f10953p);
            intent4.putExtra(ClientCookie.PATH_ATTR, imageDetailInfo.f10947j);
            intent4.putExtra(VastIconXmlManager.DURATION, iArr[3]);
            startActivity(intent4);
            finish();
        } else if (w4.a.equals("video_reverse")) {
            if (!z2) {
                com.xvideostudio.videoeditor.tool.m.p(2131822080, -1, 1);
                if (imageDetailInfo.f10944g == -9998) {
                    m1.a(this.f7954m, "NOT_SUPPORTED_FORMAT_VIA_THRID_PART");
                }
            } else if (min > hl.productor.fxlib.h.f13178d) {
                m1.a(this.f7954m, "REVERSE_TOOLS_SHOW_RESOLUTION_TOO_HIGH");
                com.xvideostudio.videoeditor.tool.m.t(this.f7954m.getResources().getString(2131821636), -1, 1);
            } else {
                Intent intent5 = new Intent(this.f7954m, TrimActivity.class);
                ArrayList arrayList5 = new ArrayList();
                arrayList5.add(imageDetailInfo.f10947j);
                intent5.putExtra("editor_type", w4.a);
                intent5.putExtra("selected", 0);
                intent5.putExtra("playlist", arrayList5);
                intent5.putExtra("name", imageDetailInfo.f10953p);
                intent5.putExtra(ClientCookie.PATH_ATTR, imageDetailInfo.f10947j);
                intent5.putExtra(VastIconXmlManager.DURATION, iArr[3]);
                intent5.putExtra("width", iArr[0]);
                intent5.putExtra("height", iArr[1]);
                startActivity(intent5);
                finish();
            }
        } else if (w4.a.equals("gif_video")) {
            int addClip = this.f7956o.addClip(imageDetailInfo.f10947j);
            if (addClip == 1) {
                com.xvideostudio.videoeditor.tool.m.p(2131822015, -1, 1);
            } else if (addClip == 2) {
                com.xvideostudio.videoeditor.tool.m.p(2131822080, -1, 1);
                if (imageDetailInfo.f10944g == -9998) {
                    m1.a(this.f7954m, "NOT_SUPPORTED_FORMAT_VIA_THRID_PART");
                }
            } else if (addClip == 3) {
                com.xvideostudio.videoeditor.tool.m.p(2131821411, -1, 1);
            } else if (addClip == 4) {
                com.xvideostudio.videoeditor.tool.m.p(2131821018, -1, 1);
            } else if (!z2) {
                com.xvideostudio.videoeditor.tool.m.p(2131822080, -1, 1);
                if (imageDetailInfo.f10944g == -9998) {
                    m1.a(this.f7954m, "NOT_SUPPORTED_FORMAT_VIA_THRID_PART");
                }
            } else {
                Intent intent6 = new Intent(this.f7954m, GifTrimActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable(MediaDatabase.SERIALIZABLE_EXTRA, this.f7956o);
                intent6.putExtra("editorRenderTime", 0.0f);
                intent6.putExtra("editorClipIndex", 0);
                intent6.putExtra("glWidthEditor", B1(this.f7956o)[1]);
                intent6.putExtra("glHeightEditor", B1(this.f7956o)[2]);
                intent6.putExtra("load_type", this.t);
                intent6.putExtra("startType", "tab_pro_edit");
                intent6.putExtras(bundle);
                startActivity(intent6);
                finish();
            }
        } else {
            int addClip2 = this.f7956o.addClip(imageDetailInfo.f10947j);
            if (addClip2 == 1) {
                com.xvideostudio.videoeditor.tool.m.p(2131822015, -1, 1);
            } else if (addClip2 == 2) {
                com.xvideostudio.videoeditor.tool.m.p(2131822080, -1, 1);
                if (imageDetailInfo.f10944g == -9998) {
                    m1.a(this.f7954m, "NOT_SUPPORTED_FORMAT_VIA_THRID_PART");
                }
            } else if (addClip2 == 3) {
                com.xvideostudio.videoeditor.tool.m.p(2131821411, -1, 1);
            } else if (addClip2 == 4) {
                com.xvideostudio.videoeditor.tool.m.p(2131821018, -1, 1);
            } else {
                Intent intent7 = new Intent(this.f7954m, EditorActivity.class);
                Bundle bundle2 = new Bundle();
                bundle2.putString("load_type", this.t);
                bundle2.putString("editor_type", w4.a);
                bundle2.putString("editor_mode", w4.b);
                bundle2.putInt("contest_id", this.y);
                bundle2.putInt("apply_new_theme_id", this.B);
                bundle2.putSerializable("item", this.R);
                bundle2.putInt("goEditorTtemType", this.b0);
                bundle2.putSerializable(MediaDatabase.SERIALIZABLE_EXTRA, this.f7956o);
                intent7.putExtras(bundle2);
                intent7.putExtra("selected", 0);
                intent7.putExtra("isone_clip", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                startActivity(intent7);
                finish();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g2 */
    public /* synthetic */ void h2(DialogInterface dialogInterface, int i2) {
        m1.a(this.f7954m, "AUTH_CAMERA_ALLOW");
        dialogInterface.dismiss();
        androidx.core.app.a.s(this, new String[]{"android.permission.CAMERA"}, 1);
    }

    /* access modifiers changed from: private */
    /* renamed from: i2 */
    public /* synthetic */ void j2(DialogInterface dialogInterface, int i2) {
        m1.a(this.f7954m, "AUTH_CAMERA_REFUSE");
        dialogInterface.dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: k2 */
    public /* synthetic */ void l2(DialogInterface dialogInterface, int i2) {
        m1.a(this.f7954m, "AUTH_CAMERA_ALLOW");
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", getPackageName(), null));
        startActivityForResult(intent, 5);
        dialogInterface.dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: m2 */
    public /* synthetic */ void n2(DialogInterface dialogInterface, int i2) {
        m1.a(this.f7954m, "AUTH_CAMERA_REFUSE");
        dialogInterface.dismiss();
    }

    static /* synthetic */ int o1(EditorChooseActivityTab editorChooseActivityTab) {
        int i2 = editorChooseActivityTab.w;
        editorChooseActivityTab.w = i2 + 1;
        return i2;
    }

    /* access modifiers changed from: private */
    /* renamed from: o2 */
    public /* synthetic */ void p2(com.xvideostudio.videoeditor.tool.p pVar) {
        this.f0 = Boolean.FALSE;
        com.xvideostudio.videoeditor.x0.p2.b.a(0, "LISTPOP_CLICK_FOLDER", null);
        if (pVar == null) {
            Intent intent = new Intent();
            if (this.u.equals("false")) {
                intent.setType("video/*;");
                intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"video/*"});
            } else {
                intent.setType("video/*;image/*");
            }
            if (w4.a.equals("editor_photo")) {
                intent.setType("image/*");
            }
            intent.setAction("android.intent.action.GET_CONTENT");
            startActivityForResult(intent, AdError.NO_FILL_ERROR_CODE);
        } else {
            B2(pVar);
            this.V.setText(pVar.a);
        }
        this.O.dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: q2 */
    public /* synthetic */ void r2() {
        this.O = null;
        this.W.setSelected(false);
        if (this.f0.booleanValue()) {
            com.xvideostudio.videoeditor.x0.p2.b.a(0, "CLIPCHOOSE_PAGE_LISTPOP_CLOSE", null);
        }
        this.f0 = Boolean.TRUE;
    }

    /* access modifiers changed from: private */
    /* renamed from: s2 */
    public /* synthetic */ void t2(View view) {
        this.O.dismiss();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void v2() {
        if (this.C != null) {
            this.f7956o.getClipArray().add(0, this.C);
        }
        if (this.D != null) {
            this.f7956o.getClipArray().add(this.f7956o.getClipArray().size(), this.D);
        }
        MediaDatabase mediaDatabase = this.f7956o;
        if (mediaDatabase.isPrcVideoRel == 0) {
            mediaDatabase.videoMode = -1;
            Intent intent = new Intent();
            if (this.s) {
                intent.setClass(this.f7954m, EditorClipActivity.class);
            } else {
                intent.setClass(this.f7954m, EditorActivity.class);
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("isEditorToChooseToEditor", true);
            bundle.putString("load_type", this.t);
            bundle.putString("editor_type", w4.a);
            bundle.putString("editor_mode", w4.b);
            bundle.putInt("apply_new_theme_id", this.B);
            bundle.putInt("goEditorTtemType", this.b0);
            bundle.putSerializable("item", this.R);
            MediaDatabase mediaDatabase2 = this.f7957p;
            if (mediaDatabase2 != null) {
                mediaDatabase2.getClipArray().addAll(this.f7956o.getClipArray());
                bundle.putSerializable(MediaDatabase.SERIALIZABLE_EXTRA, this.f7957p);
            } else {
                bundle.putSerializable(MediaDatabase.SERIALIZABLE_EXTRA, this.f7956o);
            }
            intent.putExtras(bundle);
            if (this.s) {
                m1.a(this, "EDITOR_CLIP_ADD_CLIP_SUCCESS");
                setResult(1, intent);
            } else {
                setResult(4, intent);
            }
            finish();
            return;
        }
        this.w = 0;
        com.xvideostudio.videoeditor.tool.a0.a(1).execute(new d());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void w2() {
        this.f7956o.videoMode = -1;
        if (this.t.equals(MessengerShareContentUtility.MEDIA_IMAGE)) {
            if (this.B <= 0) {
                this.B = 1;
            }
            Map<String, String> map = VideoMakerApplication.E0().get("romantic_moonlight.aac");
            if (map != null) {
                if (!m0.U(com.xvideostudio.videoeditor.l0.b.f0() + map.get("fileName"))) {
                    Context context = this.f7954m;
                    com.xvideostudio.videoeditor.tool.w.a1(context, false, c0.q(context));
                    Boolean bool = Boolean.FALSE;
                    com.xvideostudio.videoeditor.x0.r2.a.e(Boolean.TRUE, bool, bool, bool, bool, bool, bool);
                }
            }
        } else {
            this.f7956o.addCameraClipAudio();
        }
        if (this.f7956o.isPrcVideoRel == 0) {
            Intent intent = new Intent(this.f7954m, EditorActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("load_type", this.t);
            bundle.putString("editor_type", w4.a);
            bundle.putString("editor_mode", w4.b);
            bundle.putInt("contest_id", this.y);
            bundle.putInt("apply_new_theme_id", this.B);
            bundle.putSerializable("item", this.R);
            bundle.putInt("goEditorTtemType", this.b0);
            bundle.putSerializable(MediaDatabase.SERIALIZABLE_EXTRA, this.f7956o);
            intent.putExtras(bundle);
            ArrayList arrayList = new ArrayList();
            if (this.f7956o.getClipArray().size() > 0) {
                arrayList.add(this.f7956o.getClip(0).path);
            }
            intent.putExtra("selected", 0);
            intent.putExtra("playlist", arrayList);
            intent.putExtra("is_from_editor_choose", true);
            try {
                startActivity(intent);
            } catch (ConcurrentModificationException e2) {
                e2.printStackTrace();
            }
            finish();
            com.xvideostudio.videoeditor.tool.a0.a(1).execute(new b());
            return;
        }
        this.w = 0;
        com.xvideostudio.videoeditor.tool.a0.a(1).execute(new c());
    }

    private void x2() {
        MediaDatabase mediaDatabase = this.f7956o;
        if (!(mediaDatabase == null || mediaDatabase.getClipArray() == null)) {
            Iterator<MediaClip> it = this.f7956o.getClipArray().iterator();
            while (it.hasNext()) {
                com.xvideostudio.videoeditor.workmanager.a.f11735d.add(it.next().path);
            }
        }
        MediaDatabase mediaDatabase2 = this.f7957p;
        if (mediaDatabase2 != null && mediaDatabase2.getClipArray() != null) {
            Iterator<MediaClip> it2 = this.f7957p.getClipArray().iterator();
            while (it2.hasNext()) {
                com.xvideostudio.videoeditor.workmanager.a.f11735d.add(it2.next().path);
            }
        }
    }

    private void y2() {
        androidx.work.t.d(this.f7954m).b(androidx.work.n.d(FileScannerWorker.class));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void z1() {
        try {
            if (this.f7956o != null) {
                HashMap hashMap = new HashMap();
                Iterator<MediaClip> it = this.f7956o.getClipArray().iterator();
                while (it.hasNext()) {
                    MediaClip next = it.next();
                    if (hashMap.containsKey(next.path)) {
                        hashMap.put(next.path, 2);
                    } else {
                        hashMap.put(next.path, 1);
                    }
                }
                for (Map.Entry entry : hashMap.entrySet()) {
                    if (entry != null && ((Integer) entry.getValue()).intValue() > 1) {
                        String str = this.t;
                        if (str == null || !str.equals(MessengerShareContentUtility.MEDIA_IMAGE)) {
                            m1.a(VideoEditorApplication.y(), "VIDEO_EDIT_CHOOSE_REPEATED_CLIP");
                        } else {
                            m1.a(VideoEditorApplication.y(), "SLIDESHOW_EDIT_CHOOSE_REPEATED_CLIP");
                        }
                    }
                }
                hashMap.clear();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void z2(MediaClip mediaClip, int i2) {
        FxFilterEntity fxFilterEntity = new FxFilterEntity();
        fxFilterEntity.index = i2;
        fxFilterEntity.startTime = 0.0f;
        fxFilterEntity.endTime = 1.0E10f;
        fxFilterEntity.filterId = com.xvideostudio.videoeditor.l0.c.l(i2);
        mediaClip.setFxFilter(fxFilterEntity);
    }

    public void D1(ImageDetailInfo imageDetailInfo, int i2) {
        boolean isSupVideoFormatPont = SystemUtility.isSupVideoFormatPont(imageDetailInfo.f10953p);
        if (isSupVideoFormatPont) {
            if (com.xvideostudio.videoeditor.u.B1() && !com.xvideostudio.videoeditor.tool.c0.b(this) && m0.Y(this.f7954m, imageDetailInfo.f10947j, true)) {
                if (com.xvideostudio.videoeditor.u.d(this.f7954m).booleanValue()) {
                    com.xvideostudio.videoeditor.u.Q1(this.f7954m, Boolean.FALSE);
                } else if (com.xvideostudio.videoeditor.q.c("import_2gb")) {
                    com.xvideostudio.videoeditor.q.e("import_2gb", false);
                } else if (!com.xvideostudio.videoeditor.u.C0(this.f7954m).booleanValue() || !ProPrivilegeAdHandle.getInstance().isAdSuccess()) {
                    com.xvideostudio.videoeditor.b1.a.c(this, "import_2gb");
                    return;
                } else {
                    com.xvideostudio.videoeditor.b0.j.t(this, new f2(this), new b2(this), e2.f8744f, "import_2gb");
                    return;
                }
            }
            com.xvideostudio.videoeditor.tool.a0.a(1).execute(new p2(this, imageDetailInfo, isSupVideoFormatPont));
        }
        com.xvideostudio.videoeditor.tool.a0.a(1).execute(new v1(this, imageDetailInfo, i2));
    }

    public void G1(String str) {
        this.g0 = true;
        MediaDatabase mediaDatabase = this.f7956o;
        if (mediaDatabase != null) {
            mediaDatabase.deleteClip(str);
        }
        MediaDatabase mediaDatabase2 = this.f7957p;
        if (mediaDatabase2 != null) {
            mediaDatabase2.deleteClip(str);
        }
        this.Z.c(str);
    }

    public void H1() {
        m1.a(this.f7954m, "CLIPCHOOSE_PAGE_SHOW");
        if ("editor_video".equals(w4.a)) {
            m1.a(this.f7954m, "CLIPCHOOSE_PAGE_SHOW_MAIN");
        }
        StoryBoardFragment storyBoardFragment = (StoryBoardFragment) getSupportFragmentManager().W(C1524R$id.story_board_fragment);
        this.Z = storyBoardFragment;
        if (storyBoardFragment != null) {
            storyBoardFragment.h(this.f7956o.getClipArray());
            this.Z.i(this);
        }
        this.E = (VideoEditorApplication.x * 660) / 1920;
        new RelativeLayout.LayoutParams(-1, this.E).addRule(12);
        z zVar = this.h0;
        if (zVar != null) {
            zVar.a(true);
        }
    }

    public void I1() {
        Toolbar toolbar = (Toolbar) findViewById(2131297930);
        this.P = toolbar;
        T0(toolbar);
        M0().s(true);
        this.N = (RelativeLayout) findViewById(C1524R$id.rl_folder_change);
        this.Q = (TabLayout) findViewById(C1524R$id.tab_layout);
        ImageView imageView = (ImageView) findViewById(C1524R$id.iv_folder);
        this.W = imageView;
        imageView.setSelected(false);
        this.V = (TextView) findViewById(C1524R$id.tv_folder_title);
        this.N.setOnClickListener(new w1(this));
        DisableScrollViewPager disableScrollViewPager = (DisableScrollViewPager) findViewById(C1524R$id.viewPager);
        this.f7955n = disableScrollViewPager;
        disableScrollViewPager.setOffscreenPageLimit(2);
        if (this.t == null) {
            this.t = "video";
        }
        String str = this.t;
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case 100313435:
                if (str.equals(MessengerShareContentUtility.MEDIA_IMAGE)) {
                    c2 = 0;
                    break;
                }
                break;
            case 112202875:
                if (str.equals("video")) {
                    c2 = 1;
                    break;
                }
                break;
            case 1146278599:
                if (str.equals("image/video")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                this.a0.add(com.xvideostudio.videoeditor.fragment.o.o(0, this));
                break;
            case 1:
                this.a0.add(com.xvideostudio.videoeditor.fragment.o.o(2, this));
                break;
            case 2:
                this.a0.add(com.xvideostudio.videoeditor.fragment.o.o(1, this));
                this.a0.add(com.xvideostudio.videoeditor.fragment.o.o(2, this));
                this.a0.add(com.xvideostudio.videoeditor.fragment.o.o(0, this));
                break;
        }
        this.f7955n.setAdapter(new a0(getSupportFragmentManager(), this.a0, this));
        this.Q.setupWithViewPager(this.f7955n);
        if (this.a0.size() == 1) {
            this.Q.setVisibility(8);
        }
    }

    @Override // com.xvideostudio.videoeditor.fragment.StoryBoardFragment.d
    public void b0() {
        com.xvideostudio.videoeditor.tool.g gVar;
        int size = this.f7956o.getClipArray().size();
        if (size == 0) {
            com.xvideostudio.videoeditor.tool.m.t(getResources().getString(2131820611), -1, 1);
            return;
        }
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            if (this.f7956o.getClip(i4).mediaType == VideoEditData.IMAGE_TYPE) {
                i2++;
            } else {
                i3++;
            }
        }
        if (!w4.a.equals("gif_photo") || i2 <= 50) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("照片片段数", i2);
                jSONObject.put("视频片段数", i3);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if ("editor_video".equals(w4.a)) {
                m1.a(this.f7954m, "CLIPCHOOSE_PAGE_NEXT_CLICK");
            }
            if (!this.f7956o.isCachePictrueFinished()) {
                if (this.L == null) {
                    this.L = com.xvideostudio.videoeditor.tool.g.a(this);
                }
                if (!isFinishing() && (gVar = this.L) != null) {
                    gVar.show();
                }
                com.xvideostudio.videoeditor.tool.a0.a(1).execute(new o());
            }
            A1(i2, i3, size);
            String str = w4.a;
            if (str != null && str.equals("gif_photo")) {
                Intent intent = new Intent(this.f7954m, ConfigTextActivity.class);
                Bundle bundle = new Bundle();
                Iterator<MediaClip> it = this.f7956o.getClipArray().iterator();
                while (it.hasNext()) {
                    MediaClip next = it.next();
                    if (next.mediaType == VideoEditData.IMAGE_TYPE) {
                        next.duration = 200;
                        this.f7956o.isUpDurtion = true;
                    }
                }
                bundle.putSerializable(MediaDatabase.SERIALIZABLE_EXTRA, this.f7956o);
                intent.putExtra("editorRenderTime", 0.0f);
                intent.putExtra("editorClipIndex", 0);
                intent.putExtra("glWidthEditor", B1(this.f7956o)[1]);
                intent.putExtra("glHeightEditor", B1(this.f7956o)[2]);
                intent.putExtra("editor_type", "gif_photo_activity");
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            } else if (!this.q) {
                v2();
            } else {
                w2();
            }
        } else {
            com.xvideostudio.videoeditor.tool.m.p(2131820604, -1, 1);
        }
    }

    @Override // com.xvideostudio.videoeditor.view.StoryBoardView.d
    public void m(MediaClip mediaClip) {
        w4.f8878c = true;
        if (mediaClip != null && mediaClip.path != null && this.g0) {
            this.g0 = false;
        }
    }

    @Override // com.xvideostudio.videoeditor.fragment.StoryBoardFragment.d
    public void n0(int i2, int i3) {
        MediaDatabase mediaDatabase = this.f7956o;
        if (mediaDatabase != null && mediaDatabase.getClipArray() != null && i2 < this.f7956o.getClipArray().size() && i3 < this.f7956o.getClipArray().size()) {
            MediaClip clip = this.f7956o.getClip(i2);
            this.f7956o.getClipArray().remove(clip);
            this.f7956o.getClipArray().add(i3, clip);
            this.f7956o.updateIndex();
        }
        MediaDatabase mediaDatabase2 = this.f7957p;
        if (mediaDatabase2 != null && mediaDatabase2.getClipArray() != null && i2 < this.f7957p.getClipArray().size() && i3 < this.f7957p.getClipArray().size()) {
            MediaClip clip2 = this.f7957p.getClip(i2);
            this.f7957p.getClipArray().remove(clip2);
            this.f7957p.getClipArray().add(i3, clip2);
            this.f7957p.updateIndex();
        }
        w4.f8878c = true;
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Uri uri;
        super.onActivityResult(i2, i3, intent);
        int i4 = 0;
        if (2001 == i2 || (!(intent == null || intent.getData() == null) || (uri = this.S) == null)) {
            if (i2 == 5 || i2 == 6 || i2 == 7) {
                if (l1.a(this.f7954m, "android.permission.CAMERA")) {
                    if (!com.xvideostudio.videoeditor.x0.y.a(this.f7954m)) {
                        com.xvideostudio.videoeditor.tool.m.n(2131820682);
                    } else if (i2 == 5) {
                        new Intent();
                        Intent intent2 = new Intent(this, CameraActivityExt.class);
                        intent2.setAction("com.xvideostudio.videoeditor.intent.action.CAMERA");
                        intent2.putExtra("isFromChoose", true);
                        startActivity(intent2);
                    } else if (i2 == 6) {
                        com.xvideostudio.videoeditor.tool.m.n(2131822096);
                    } else if (i2 == 7) {
                        Intent intent3 = new Intent("android.media.action.VIDEO_CAPTURE");
                        intent3.addCategory("android.intent.category.DEFAULT");
                        startActivityForResult(intent3, AdError.LOAD_TOO_FREQUENTLY_ERROR_CODE);
                    }
                } else if (this.z) {
                    this.z = false;
                } else {
                    m1.a(this.f7954m, "AUTH_CAMERA_SHOW");
                    new b.a(this.f7954m).setMessage(2131821616).setPositiveButton(2131820621, new t(i2)).setNegativeButton(2131821614, new s()).show();
                }
            } else if (i2 == 1001) {
                if (intent != null && intent.getData() != null) {
                    ImageDetailInfo imageDetailInfo = new ImageDetailInfo();
                    String N2 = m0.N(this.f7954m, intent.getData());
                    if (!TextUtils.isEmpty(N2)) {
                        String str = File.separator;
                        if (N2.indexOf(str) >= 0) {
                            imageDetailInfo.f10944g = -9998;
                            imageDetailInfo.f10947j = N2;
                            imageDetailInfo.f10953p = N2.substring(N2.lastIndexOf(str) + 1, N2.length());
                            if (Tools.S(imageDetailInfo.f10947j)) {
                                com.xvideostudio.videoeditor.tool.m.t(getResources().getString(2131822080), -1, 1);
                                Intent intent4 = new Intent(this, VidCompactInstallDialogActivity.class);
                                intent4.putExtra(VidCompactThirdPartParam.THIRD_PART_PARAM_INPUT_FILES_PATH, imageDetailInfo.f10947j);
                                intent4.putExtra(VidCompactThirdPartParam.THIRD_PART_PARAM_FROMTYPE, 10);
                                startActivityForResult(intent4, 10);
                            } else {
                                D1(imageDetailInfo, 0);
                            }
                            w4.f8878c = true;
                        }
                    }
                }
            } else if (i2 == 1002 || i2 == 1003) {
                if (intent != null && intent.getData() != null) {
                    String N3 = m0.N(this.f7954m, intent.getData());
                    C2(N3);
                    if (i2 != 1002 && i2 == 1003) {
                        if (intent.getExtras() != null) {
                            Bitmap bitmap = (Bitmap) intent.getExtras().get("data");
                            OutputStream outputStream = null;
                            try {
                                outputStream = g.c.i.d.c(N3);
                                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
                                outputStream.flush();
                                if (outputStream != null) {
                                    try {
                                        outputStream.close();
                                    } catch (IOException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                            } catch (Exception e3) {
                                e3.printStackTrace();
                                if (outputStream != null) {
                                    outputStream.close();
                                }
                            } catch (Throwable th) {
                                if (outputStream != null) {
                                    try {
                                        outputStream.close();
                                    } catch (IOException e4) {
                                        e4.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        } else {
                            return;
                        }
                    }
                    if (m0.U(N3)) {
                        G2(N3);
                        w4.f8878c = true;
                    }
                }
            } else if (i3 != 0) {
                Bundle extras = intent.getExtras();
                boolean z2 = extras.getBoolean("isFromFace", false);
                ArrayList<String> stringArrayList = extras.getStringArrayList("capture_data_path");
                ArrayList<Integer> integerArrayList = extras.getIntegerArrayList("capture_data_filter");
                List list = (List) extras.getSerializable("capture_data_sound");
                while (i4 < stringArrayList.size()) {
                    MediaClip addClipEntity = this.f7956o.addClipEntity(stringArrayList.get(i4));
                    if (addClipEntity != null && !z2) {
                        z2(addClipEntity, integerArrayList.get(i4).intValue());
                        A2(addClipEntity, (SoundEntity) list.get(i4));
                    }
                    i4++;
                }
                if (stringArrayList.size() > 0) {
                    z4.b = true;
                    z4.a = "";
                }
            }
        } else if (i2 == 1002 || i2 == 1003) {
            String path = uri.getPath();
            if (m0.U(path)) {
                synchronized (VideoEditorApplication.y()) {
                    MediaDatabase mediaDatabase = this.f7956o;
                    if (mediaDatabase != null) {
                        ArrayList<MediaClip> clipArray = mediaDatabase.getClipArray();
                        if (clipArray != null && clipArray.size() > 0) {
                            Iterator<MediaClip> it = clipArray.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    if (it.next().path.equals(path)) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                        }
                        i4 = 1;
                        if (i4 != 0) {
                            w4.f8878c = true;
                            G2(path);
                        }
                    }
                }
            }
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        y2();
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        MediaDatabase mediaDatabase;
        Dialog dialog = this.x;
        if (dialog != null && dialog.isShowing() && !isFinishing() && !VideoEditorApplication.Y(this)) {
            this.x.dismiss();
        } else if (this.r) {
            if (this.s || !((mediaDatabase = this.f7956o) == null || mediaDatabase.getClipArray() == null || this.f7956o.getClipArray().size() == 0)) {
                String str = w4.a;
                if (str == null || !str.equals("gif_photo")) {
                    v2();
                    return;
                }
                Intent intent = new Intent(this.f7954m, ConfigTextActivity.class);
                Bundle bundle = new Bundle();
                Iterator<MediaClip> it = this.f7956o.getClipArray().iterator();
                while (it.hasNext()) {
                    MediaClip next = it.next();
                    if (next.mediaType == VideoEditData.IMAGE_TYPE) {
                        next.duration = 200;
                        this.f7956o.isUpDurtion = true;
                    }
                }
                bundle.putSerializable(MediaDatabase.SERIALIZABLE_EXTRA, this.f7956o);
                intent.putExtra("editorRenderTime", 0.0f);
                intent.putExtra("editorClipIndex", 0);
                intent.putExtra("glWidthEditor", B1(this.f7956o)[1]);
                intent.putExtra("glHeightEditor", B1(this.f7956o)[2]);
                intent.putExtra("editor_type", "gif_photo_activity");
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
                return;
            }
            com.xvideostudio.videoeditor.tool.m.t(getResources().getString(2131820611), -1, 1);
        } else if (!this.q) {
            com.xvideostudio.videoeditor.tool.m.p(2131820896, -1, 0);
            Intent intent2 = new Intent(this.f7954m, MyStudioActivity.class);
            intent2.putExtra("REQUEST_CODE", 1);
            intent2.putExtra("isShowMyStudioAd", this.c0);
            startActivity(intent2);
            com.xvideostudio.videoeditor.k.c().e(EditorActivity.class);
            finish();
        } else {
            MediaDatabase mediaDatabase2 = this.f7956o;
            if (mediaDatabase2 == null || mediaDatabase2.getClipArray() == null || this.f7956o.getClipArray().size() <= 0) {
                if (com.xvideostudio.videoeditor.tool.w.a(this.f7954m).equals("false")) {
                    Intent intent3 = new Intent();
                    intent3.setClass(this.f7954m, MainActivity.class);
                    startActivity(intent3);
                }
                finish();
                return;
            }
            String str2 = w4.a;
            if (str2 == null || !str2.equals("gif_photo")) {
                this.x = e0.x(this.f7954m, getString(2131820895), new u(), new v(), new w());
            } else {
                D2();
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.xvideostudio.videoeditor.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        boolean z2;
        super.onCreate(bundle);
        if (bundle != null) {
            this.z = true;
        }
        String r0 = com.xvideostudio.videoeditor.l0.b.r0();
        if (r0 != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(r0);
            String str = File.separator;
            sb.append(str);
            sb.append("DCIM");
            sb.append(str);
            sb.append("Camera");
            sb.toString();
        }
        w4.f8878c = false;
        setContentView(C1527R$layout.editorchoose_activity_tab);
        org.greenrobot.eventbus.c.c().p(this);
        this.A = findViewById(C1524R$id.root_layout_id);
        Tools.c();
        this.f7954m = this;
        this.v = false;
        String str2 = null;
        E1();
        if (bundle != null) {
            MediaDatabase mediaDatabase = (MediaDatabase) bundle.getSerializable(MediaDatabase.SERIALIZABLE_EXTRA);
            this.f7956o = mediaDatabase;
            if (this.s) {
                this.f7957p = mediaDatabase;
                if (!(mediaDatabase == null || mediaDatabase.getClipArray() == null)) {
                    this.f7956o.getClipArray().clear();
                }
            }
            str2 = bundle.getString("recordPath");
            this.t = bundle.getString("load_type");
            if (str2 != null) {
                if (m0.U(str2)) {
                    this.v = true;
                }
                if (this.t != null && z4.f8906c == null) {
                    C2(str2);
                }
            }
        }
        I1();
        H1();
        F1(true);
        if (this.v) {
            synchronized (VideoEditorApplication.y()) {
                MediaDatabase mediaDatabase2 = this.f7956o;
                if (mediaDatabase2 != null) {
                    ArrayList<MediaClip> clipArray = mediaDatabase2.getClipArray();
                    if (clipArray != null && clipArray.size() > 0) {
                        Iterator<MediaClip> it = clipArray.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (it.next().path.equals(str2)) {
                                    z2 = false;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    z2 = true;
                    if (z2) {
                        w4.f8878c = true;
                        G2(str2);
                    }
                }
            }
        }
        MediaDatabase mediaDatabase3 = this.f7956o;
        if (mediaDatabase3 != null) {
            mediaDatabase3.clearCachePictrueFinished();
        }
        if (getIntent() != null) {
            this.b0 = getIntent().getIntExtra("goEditorTtemType", -1);
            this.c0 = getIntent().getBooleanExtra("isShowMyStudioAd", false);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.xvideostudio.videoeditor.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.c().r(this);
        PopupWindow popupWindow = this.K;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.K.dismiss();
            this.K = null;
        }
        com.xvideostudio.videoeditor.tool.g gVar = this.L;
        if (gVar != null && gVar.isShowing()) {
            this.L.show();
            this.L = null;
        }
        com.xvideostudio.videoeditor.workmanager.a.f11735d.clear();
    }

    @org.greenrobot.eventbus.m(threadMode = ThreadMode.MAIN)
    public void onEvent(FileScannerWorker.a aVar) {
        p0 p0Var;
        PopupWindow popupWindow = this.O;
        if (popupWindow != null && popupWindow.isShowing() && (p0Var = this.U) != null) {
            p0Var.i(com.xvideostudio.videoeditor.workmanager.a.f11736e.a(this.e0));
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        PopupWindow popupWindow = this.H;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.H.dismiss();
            return true;
        } else if (i2 == 4) {
            return super.onKeyDown(i2, keyEvent);
        } else {
            return false;
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.xvideostudio.videoeditor.activity.BaseActivity, androidx.fragment.app.FragmentActivity
    public void onPause() {
        super.onPause();
        m1.d(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.core.app.a.b
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        String str = "onRequestPermissionsResult requestCode:" + i2 + " permissions:" + com.xvideostudio.videoeditor.tool.l.b(strArr) + " grantResults:" + com.xvideostudio.videoeditor.tool.l.a(iArr);
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    if (iArr.length <= 0 || iArr[0] != 0) {
                        if (androidx.core.app.a.v(this, "android.permission.CAMERA")) {
                            m1.a(this.f7954m, "AUTH_CAMERA_SHOW");
                            new b.a(this).setMessage(2131821616).setPositiveButton(2131820621, new g()).setNegativeButton(2131821614, new f()).show();
                            return;
                        }
                        m1.a(this.f7954m, "AUTH_CAMERA_SHOW");
                        new b.a(this).setMessage(2131821616).setPositiveButton(2131820621, new i()).setNegativeButton(2131821614, new h()).show();
                    } else if (com.xvideostudio.videoeditor.x0.y.a(this.f7954m)) {
                        Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
                        intent.addCategory("android.intent.category.DEFAULT");
                        startActivityForResult(intent, AdError.LOAD_TOO_FREQUENTLY_ERROR_CODE);
                    } else {
                        com.xvideostudio.videoeditor.tool.m.n(2131820682);
                    }
                }
            } else if (iArr.length > 0 && iArr[0] == 0) {
                com.xvideostudio.videoeditor.tool.m.n(2131822096);
            } else if (androidx.core.app.a.v(this, "android.permission.CAMERA")) {
                m1.a(this.f7954m, "AUTH_CAMERA_SHOW");
                new b.a(this).setMessage(2131821616).setPositiveButton(2131820621, new l()).setNegativeButton(2131821614, new k()).show();
            } else {
                m1.a(this.f7954m, "AUTH_CAMERA_SHOW");
                new b.a(this).setMessage(2131821616).setPositiveButton(2131820621, new n()).setNegativeButton(2131821614, new m()).show();
            }
        } else if (iArr.length > 0 && iArr[0] == 0) {
            new Intent();
            Intent intent2 = new Intent(this, CameraActivityExt.class);
            intent2.putExtra("isFromChoose", true);
            if (com.xvideostudio.videoeditor.x0.y.a(this)) {
                startActivityForResult(intent2, AdError.INTERNAL_ERROR_CODE);
            } else {
                com.xvideostudio.videoeditor.tool.m.n(2131820682);
            }
        } else if (androidx.core.app.a.v(this, "android.permission.CAMERA")) {
            m1.a(this.f7954m, "AUTH_CAMERA_SHOW");
            new b.a(this).setMessage(2131821616).setPositiveButton(2131820621, new z1(this)).setNegativeButton(2131821614, new o2(this)).show();
        } else {
            m1.a(this.f7954m, "AUTH_CAMERA_SHOW");
            new b.a(this).setMessage(2131821616).setPositiveButton(2131820621, new y1(this)).setNegativeButton(2131821614, new d2(this)).show();
        }
    }

    @Override // com.xvideostudio.videoeditor.activity.BaseActivity, androidx.fragment.app.FragmentActivity
    public void onResume() {
        super.onResume();
        m1.e(this);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("load_type", this.t);
        Uri uri = this.S;
        bundle.putString("recordPath", uri != null ? uri.getPath() : "");
        bundle.putSerializable(MediaDatabase.SERIALIZABLE_EXTRA, this.f7956o);
    }

    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        if (!this.M) {
            this.M = true;
        }
    }

    @Override // com.xvideostudio.videoeditor.fragment.StoryBoardFragment.d
    public void s0(String str) {
        int i2;
        int i3;
        String str2;
        MediaDatabase mediaDatabase = this.f7956o;
        if (mediaDatabase != null) {
            Iterator<MediaClip> it = mediaDatabase.getClipArray().iterator();
            while (true) {
                if (!it.hasNext()) {
                    i3 = -1;
                    break;
                }
                MediaClip next = it.next();
                if (next != null && (str2 = next.path) != null && str2.equals(str)) {
                    i3 = this.f7956o.getClipArray().indexOf(next);
                    break;
                }
            }
            if (i3 != -1) {
                this.f7956o.deleteClip(i3);
            }
        }
        MediaDatabase mediaDatabase2 = this.f7957p;
        if (mediaDatabase2 != null) {
            Iterator<MediaClip> it2 = mediaDatabase2.getClipArray().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    i2 = -1;
                    break;
                }
                MediaClip next2 = it2.next();
                if (next2.path.equals(str)) {
                    i2 = this.f7957p.getClipArray().indexOf(next2);
                    break;
                }
            }
            if (i2 != -1) {
                this.f7957p.deleteClip(i2);
            }
        }
        w4.f8878c = true;
        com.xvideostudio.videoeditor.d0.d dVar = new com.xvideostudio.videoeditor.d0.d();
        dVar.b(str);
        com.xvideostudio.videoeditor.workmanager.a.f11735d.remove(str);
        org.greenrobot.eventbus.c.c().l(dVar);
    }

    public void u2() {
        this.d0.post(new e(this));
    }

    @Override // com.xvideostudio.videoeditor.adapter.o0.e
    public void y(ImageDetailInfo imageDetailInfo, int i2) {
        w4.f8878c = true;
        if (imageDetailInfo.f10948k == 0) {
            D1(imageDetailInfo, i2);
            return;
        }
        imageDetailInfo.f10948k = 0;
        o0.d dVar = new o0.d();
        dVar.a = i2;
        org.greenrobot.eventbus.c.c().l(dVar);
        com.xvideostudio.videoeditor.workmanager.a.f11735d.remove(imageDetailInfo.f10947j);
        G1(imageDetailInfo.f10947j);
    }
}