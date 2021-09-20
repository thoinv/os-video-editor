package com.xvideostudio.videoeditor.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.b;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.funcamerastudio.videomaker.C1521R$color;
import com.funcamerastudio.videomaker.C1523R$drawable;
import com.funcamerastudio.videomaker.C1524R$id;
import com.funcamerastudio.videomaker.C1527R$layout;
import com.funcamerastudio.videomaker.C1528R$menu;
import com.funcamerastudio.videomaker.C1532R$string;
import com.funcamerastudio.videomaker.C1533R$style;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mopub.mobileads.VastIconXmlManager;
import com.mopub.mobileads.VastVideoViewController;
import com.xvideostudio.videoeditor.VideoEditorApplication;
import com.xvideostudio.videoeditor.VideoMakerApplication;
import com.xvideostudio.videoeditor.activity.basic.AbstractConfigActivity;
import com.xvideostudio.videoeditor.activity.basic.AbstractConfigAudioActivity;
import com.xvideostudio.videoeditor.adapter.EditorAOneAdapter;
import com.xvideostudio.videoeditor.adapter.q0;
import com.xvideostudio.videoeditor.ads.AdConfig;
import com.xvideostudio.videoeditor.ads.AdsInitUtil;
import com.xvideostudio.videoeditor.ads.Utils.DialogAdUtils;
import com.xvideostudio.videoeditor.ads.handle.ProPrivilegeAdHandle;
import com.xvideostudio.videoeditor.bean.BackgroundItem;
import com.xvideostudio.videoeditor.bean.ExportNotifyBean;
import com.xvideostudio.videoeditor.editorsort.ConfigSortItemActivity;
import com.xvideostudio.videoeditor.entity.FxFilterEntity;
import com.xvideostudio.videoeditor.entity.FxMediaClipEntity;
import com.xvideostudio.videoeditor.entity.FxThemeU3DEffectEntity;
import com.xvideostudio.videoeditor.entity.FxThemeU3DEntity;
import com.xvideostudio.videoeditor.entity.FxU3DEntity;
import com.xvideostudio.videoeditor.entity.MusicInf;
import com.xvideostudio.videoeditor.entity.SimpleInf;
import com.xvideostudio.videoeditor.entity.ThirdPartParam;
import com.xvideostudio.videoeditor.entity.VidCompactThirdPartParam;
import com.xvideostudio.videoeditor.firebasemessaging.a;
import com.xvideostudio.videoeditor.fragment.u0;
import com.xvideostudio.videoeditor.gsonentity.Material;
import com.xvideostudio.videoeditor.gsonentity.SiteInfoBean;
import com.xvideostudio.videoeditor.tool.MSeekbarNew;
import com.xvideostudio.videoeditor.view.HorizontalListView;
import com.xvideostudio.videoeditor.view.SeekVolume;
import com.xvideostudio.videoeditor.x0.h2;
import com.xvideostudio.videoeditor.x0.i1;
import com.xvideostudio.videoeditor.x0.j2;
import com.xvideostudio.videoeditor.x0.k0;
import com.xvideostudio.videoeditor.x0.l1;
import com.xvideostudio.videoeditor.x0.l2;
import com.xvideostudio.videoeditor.x0.m0;
import com.xvideostudio.videoeditor.x0.m1;
import com.xvideostudio.videoeditor.x0.p1;
import com.xvideostudio.videoeditor.x0.y1;
import com.xvideostudio.videoeditor.x0.z0;
import java.io.File;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.apache.http.cookie.ClientCookie;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.stagex.danmaku.helper.SystemUtility;
import org.xvideo.videoeditor.database.FxStickerEntity;
import org.xvideo.videoeditor.database.FxTitleEntity;
import org.xvideo.videoeditor.database.FxTransEntityNew;
import org.xvideo.videoeditor.database.MediaClip;
import org.xvideo.videoeditor.database.MediaDatabase;
import org.xvideo.videoeditor.database.SoundEntity;
import org.xvideo.videoeditor.database.TextEntity;
import org.xvideo.videoeditor.database.VideoEditData;

public class EditorActivity extends AbstractConfigAudioActivity implements View.OnTouchListener, SeekBar.OnSeekBarChangeListener, com.xvideostudio.videoeditor.materialdownload.a, View.OnClickListener, com.xvideostudio.videoeditor.k0.c {
    public static final String T1 = (com.xvideostudio.videoeditor.l0.b.A0() + "/music/preload/");
    public static Set<Integer> U1 = new k();
    public static Map<Integer, String> V1 = new v();
    public static int[] W1 = {71};
    public static String[] X1 = {"Romance"};
    public static int[] Y1 = {2131231829};
    public static int[] Z1 = {C1523R$drawable.ic_music_love, C1523R$drawable.ic_music_smile};
    public static String[] a2 = {"Romantic Moonlight", "floating"};
    private EditorAOneAdapter A0;
    private boolean A1;
    private int B = -1;
    private HorizontalListView B0;
    private boolean B1 = false;
    public Context C;
    private int C0 = -1;
    private boolean C1 = false;
    public boolean D = false;
    private q0 D0;
    @SuppressLint({"HandlerLeak"})
    final Handler D1 = new b0();
    int E = 0;
    private String E0;
    private int E1;
    float F = 0.0f;
    private String F0;
    private int F1;
    boolean G = false;
    private MediaClip G0 = null;
    private int G1;
    int H;
    private int H0 = 0;
    private int H1;
    int I;
    private float I0 = 0.0f;
    private Handler I1 = new Handler(new c0());
    int J = 0;
    private float J0 = 0.0f;
    private View.OnClickListener J1 = new d0(this);
    int K = 0;
    private float K0 = 0.0f;
    private long K1 = 0;
    int L = 0;
    private int L0 = -1;
    private long L1 = 0;
    int M = 0;
    private boolean M0 = false;
    private View.OnTouchListener M1 = new r1(this);
    int N = -1;
    private PopupWindow N0;
    private TabLayout N1;
    com.xvideostudio.videoeditor.tool.f O = null;
    private boolean O0 = false;
    private Dialog O1;
    SeekBar P = null;
    private String P0 = "";
    private boolean P1 = false;
    TextView Q = null;
    private int Q0 = 0;
    private boolean Q1;
    boolean R = false;
    private boolean R0 = false;
    private boolean R1 = false;
    boolean S = false;
    private boolean S0 = false;
    private Dialog S1;
    boolean T = false;
    private com.xvideostudio.videoeditor.l0.a T0 = null;
    boolean U = false;
    private SeekVolume U0;
    private boolean V = false;
    private SeekVolume V0;
    private RelativeLayout W;
    private int W0 = 0;
    private RelativeLayout X;
    private int X0;
    private LinearLayout Y;
    private boolean Y0 = false;
    private TextView Z;
    private int Z0 = 0;
    private boolean a0;
    private Toolbar a1;
    private MSeekbarNew b0;
    private boolean b1 = false;
    private TextView c0;
    private boolean c1 = false;
    private TextView d0;
    private int d1 = 0;
    private LinearLayout e0;
    private int e1 = 0;
    private Button f0;
    private int f1 = 0;
    private Button g0;
    private FxThemeU3DEntity g1;
    private Button h0;
    private boolean h1 = true;
    private Button i0;
    private float i1 = 0.0f;
    private int j0 = 0;
    private float j1 = 0.0f;
    private Button k0;
    private boolean k1 = false;
    private boolean l0;
    private boolean l1 = false;
    private boolean m0;
    private boolean m1 = false;
    private Handler n0;
    private h0 n1;
    private boolean o0;
    private int o1 = 1;
    private Button p0;
    private int p1 = -1;
    private boolean q0;
    private int q1 = -1;
    private boolean r0;
    private p1 r1;
    private boolean s0 = true;
    private int s1;
    private RecyclerView t0;
    private int t1 = -1;
    private RecyclerView u0;
    private int u1 = 0;
    private RelativeLayout v0;
    private Context v1;
    private ImageView w0;
    private boolean w1 = false;
    private RecyclerView x0;
    private final boolean x1 = com.xvideostudio.videoeditor.u.i0(g.c.a.b()).booleanValue();
    private EditorAOneAdapter y0;
    private BroadcastReceiver y1 = new a0();
    private EditorAOneAdapter z0;
    private long z1;

    /* access modifiers changed from: package-private */
    public class a implements p1.f {
        final /* synthetic */ int a;

        a(int i2) {
            this.a = i2;
        }

        @Override // com.xvideostudio.videoeditor.x0.p1.f
        public void a(SoundEntity soundEntity) {
            MediaDatabase mediaDatabase = EditorActivity.this.f8720m;
            if (mediaDatabase != null) {
                if (mediaDatabase.getSoundList() != null) {
                    EditorActivity.this.f8720m.getSoundList().clear();
                    EditorActivity.this.f8720m.upCameraClipAudio();
                }
                soundEntity.gVideoStartTime = 0;
                soundEntity.gVideoEndTime = EditorActivity.this.f8720m.getTotalDuration();
                soundEntity.index = this.a;
                EditorActivity.this.f8720m.addSoundEntity(soundEntity);
                if (((AbstractConfigActivity) EditorActivity.this).f8722o != null) {
                    ((AbstractConfigActivity) EditorActivity.this).f8722o.U(EditorActivity.this.f8720m);
                }
                EditorActivity.this.e1();
                EditorActivity.this.f8720m.setCurrentClip(0);
                EditorActivity editorActivity = EditorActivity.this;
                editorActivity.G0 = editorActivity.f8720m.getCurrentClip();
                EditorActivity editorActivity2 = EditorActivity.this;
                MediaDatabase mediaDatabase2 = editorActivity2.f8720m;
                mediaDatabase2.isExecution = true;
                mediaDatabase2.isVideosMute = false;
                editorActivity2.b0.setList(EditorActivity.this.f8720m);
                EditorActivity.this.b0.setMax(((float) EditorActivity.this.f8720m.getTotalDuration()) / 1000.0f);
                EditorActivity.this.o6();
                if (((AbstractConfigActivity) EditorActivity.this).f8721n != null && ((AbstractConfigActivity) EditorActivity.this).f8721n.h0()) {
                    ((AbstractConfigActivity) EditorActivity.this).f8721n.j0();
                }
                EditorActivity.this.l1 = true;
                if (((AbstractConfigActivity) EditorActivity.this).f8721n != null) {
                    ((AbstractConfigActivity) EditorActivity.this).f8721n.L0(0.0f);
                    EditorActivity editorActivity3 = EditorActivity.this;
                    editorActivity3.s8(((AbstractConfigActivity) editorActivity3).f8721n.h0(), false);
                }
                EditorActivity.this.d1();
            }
        }

        @Override // com.xvideostudio.videoeditor.x0.p1.f
        public void b() {
            EditorActivity.this.z0();
        }
    }

    class a0 extends BroadcastReceiver {
        a0() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals(AdConfig.AD_INSTALL_WATERMARK)) {
                com.xvideostudio.videoeditor.u.S1(context);
                EditorActivity.this.x8();
                if (!com.xvideostudio.videoeditor.u.w1(context)) {
                    m1.a(context, "INCENTIVE_AD_AGAIN_REMOVE_WATER_EDITORACTIVITY");
                }
            } else if (action.equals(AdConfig.AD_INSTALL_MATERIAL)) {
                if (com.xvideostudio.videoeditor.u.l0(context).booleanValue() && EditorActivity.this.S1 != null && EditorActivity.this.S1.isShowing()) {
                    EditorActivity.this.S1.dismiss();
                }
            } else if (action.equals(AdConfig.AD_DOWNLOAD_TO_GP) && AdConfig.AD_DIALOG_SHOW_ID == 4) {
                String format = String.format(EditorActivity.this.getString(2131821196), context.getResources().getString(2131820630));
                EditorActivity editorActivity = EditorActivity.this;
                editorActivity.S1 = com.xvideostudio.videoeditor.x0.e0.d0(editorActivity.v1, EditorActivity.this.getString(2131821200), format, true, false, "back_show");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class b extends TypeToken<ArrayList<SimpleInf>> {
        b(EditorActivity editorActivity) {
        }
    }

    class b0 extends Handler {

        class a extends Handler {
            a() {
            }

            public void handleMessage(Message message) {
                int i2 = message.what;
                if (i2 == 0) {
                    Bundle data = message.getData();
                    EditorActivity.this.P.setProgress((int) ((data.getLong("progress") * 100) / data.getLong("total")));
                    EditorActivity.this.P.setMax(100);
                } else if (i2 == 1) {
                    Intent intent = new Intent();
                    intent.setClass(EditorActivity.this.C, ShareActivity.class);
                    intent.putExtra(ClientCookie.PATH_ATTR, com.xvideostudio.videoeditor.t.b);
                    intent.putExtra("exporttype", "2");
                    intent.putExtra("date", EditorActivity.this.f8720m);
                    intent.putExtra("isDraft", true);
                    intent.putExtra("enableads", true);
                    intent.putExtra("export2share", false);
                    intent.putExtra(ViewHierarchyConstants.TAG_KEY, 1);
                    intent.putExtra("contest_id", EditorActivity.this.X0);
                    intent.putExtra("isClip1080p", EditorActivity.this.A1);
                    intent.putExtra("name", EditorActivity.this.P0);
                    intent.putExtra("ordinal", EditorActivity.this.Q0);
                    intent.putExtra("editor_mode", EditorActivity.this.F0);
                    VideoEditorApplication.H = 0;
                    if (hl.productor.fxlib.h.G) {
                        ((AbstractConfigActivity) EditorActivity.this).f8721n.K().setVisibility(4);
                    }
                    EditorActivity.this.c1();
                    EditorActivity.this.C.startActivity(intent);
                    hl.productor.fxlib.h.n0 = false;
                    EditorActivity.this.S = false;
                    k0.b().a();
                    com.xvideostudio.videoeditor.tool.f fVar = EditorActivity.this.O;
                    if (fVar != null && fVar.isShowing()) {
                        EditorActivity.this.O.dismiss();
                    }
                    EditorActivity editorActivity = EditorActivity.this;
                    editorActivity.O = null;
                    ((Activity) editorActivity.C).finish();
                }
            }
        }

        class b implements Runnable {
            b() {
            }

            public void run() {
                ((AbstractConfigActivity) EditorActivity.this).f8721n.w0(1);
                ((AbstractConfigActivity) EditorActivity.this).f8721n.L0(EditorActivity.this.F);
                ((AbstractConfigActivity) EditorActivity.this).f8721n.k0();
                EditorActivity.this.l1();
            }
        }

        class c implements Runnable {
            c() {
            }

            public void run() {
                ((AbstractConfigActivity) EditorActivity.this).f8721n.w0(-1);
                ((AbstractConfigActivity) EditorActivity.this).f8721n.L0(0.0f);
            }
        }

        b0() {
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void b() {
            if (((AbstractConfigActivity) EditorActivity.this).f8721n != null) {
                ((AbstractConfigActivity) EditorActivity.this).f8721n.N0(false);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: c */
        public /* synthetic */ void d() {
            EditorActivity editorActivity = EditorActivity.this;
            if (editorActivity.f8720m != null && ((AbstractConfigActivity) editorActivity).f8722o != null) {
                EditorActivity.this.f8720m.deleteWaterMarkSticker(MediaDatabase.WATERMARK);
                ((AbstractConfigActivity) EditorActivity.this).f8722o.k(EditorActivity.this.f8720m);
                if (((AbstractConfigActivity) EditorActivity.this).f8722o != null) {
                    ((AbstractConfigActivity) EditorActivity.this).f8722o.E(true, 0, true);
                }
                EditorActivity.this.S0 = false;
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: e */
        public /* synthetic */ void f() {
            k0.b().d(((AbstractConfigActivity) EditorActivity.this).f8721n.D(), 2);
            com.xvideostudio.videoeditor.t.o(VideoEditorApplication.y(), com.xvideostudio.videoeditor.l0.b.x0(), com.xvideostudio.videoeditor.l0.b.w0(), 100, EditorActivity.this.P0);
        }

        /* access modifiers changed from: private */
        /* renamed from: g */
        public /* synthetic */ void h() {
            k0.b().d(((AbstractConfigActivity) EditorActivity.this).f8721n.D(), 1);
            ((AbstractConfigActivity) EditorActivity.this).f8721n.g(EditorActivity.this.H0, ((AbstractConfigActivity) EditorActivity.this).f8721n.K().getWidth(), ((AbstractConfigActivity) EditorActivity.this).f8721n.K().getHeight());
        }

        /* access modifiers changed from: private */
        /* renamed from: i */
        public /* synthetic */ void j(String str, Handler handler) {
            k0.b().d(((AbstractConfigActivity) EditorActivity.this).f8721n.D(), 3);
            StringBuilder sb = new StringBuilder();
            sb.append(com.xvideostudio.videoeditor.l0.b.x0());
            EditorActivity editorActivity = EditorActivity.this;
            sb.append(com.xvideostudio.videoeditor.l0.b.V(editorActivity, ".mp4", editorActivity.P0));
            String sb2 = sb.toString();
            com.xvideostudio.videoeditor.t.b = sb2;
            if (m0.d(str, sb2, handler)) {
                handler.sendEmptyMessage(1);
            } else {
                handler.sendEmptyMessage(2);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: k */
        public /* synthetic */ void l() {
            ((AbstractConfigActivity) EditorActivity.this).f8722o.Z(EditorActivity.this.f8720m);
            EditorActivity.this.S0 = false;
        }

        public void handleMessage(Message message) {
            boolean z;
            boolean z2;
            EditorActivity editorActivity;
            MediaDatabase mediaDatabase;
            boolean z3;
            boolean z4;
            TextView textView;
            boolean z5;
            float f2;
            if (((AbstractConfigActivity) EditorActivity.this).f8721n != null && ((AbstractConfigActivity) EditorActivity.this).f8722o != null) {
                String str = "handleMessage , msg what is   " + message.what;
                int i2 = message.what;
                if (i2 != 0) {
                    if (i2 == 54) {
                        int intValue = ((Integer) message.obj).intValue();
                        if (intValue == 0 || intValue == 8 || intValue == 10) {
                            if (intValue != 8) {
                                org.greenrobot.eventbus.c.c().l(new com.xvideostudio.videoeditor.d0.e());
                            }
                            EditorActivity.this.y6();
                            EditorActivity editorActivity2 = EditorActivity.this;
                            if (editorActivity2.S || !y4.b || ((AbstractConfigActivity) editorActivity2).f8721n.h0()) {
                                z = true;
                            } else {
                                EditorActivity editorActivity3 = EditorActivity.this;
                                z = true;
                                editorActivity3.s8(((AbstractConfigActivity) editorActivity3).f8721n.h0(), true);
                            }
                            y4.b = z;
                            Message message2 = new Message();
                            message2.what = 6;
                            message2.obj = Integer.valueOf(((AbstractConfigActivity) EditorActivity.this).f8722o.e(EditorActivity.this.I0));
                            message2.arg1 = 1;
                            EditorActivity.this.D1.sendMessageDelayed(message2, 200);
                            EditorActivity.this.S0 = false;
                        }
                    } else if (i2 == 29) {
                        String string = message.getData().getString("state");
                        EditorActivity.this.D1.sendEmptyMessage(8);
                        if (string.equals("play")) {
                            EditorActivity.this.D1.post(new b());
                        } else if (string.equals("exit")) {
                            EditorActivity.this.D1.post(new c());
                        }
                    } else if (i2 == 30) {
                        Bundle data = message.getData();
                        data.getInt("trim_start_time");
                        data.getInt("trim_end_time");
                        data.getInt("trim_select_thumb");
                        if (((AbstractConfigActivity) EditorActivity.this).f8721n != null && ((AbstractConfigActivity) EditorActivity.this).f8721n.h0()) {
                            ((AbstractConfigActivity) EditorActivity.this).f8721n.j0();
                            EditorActivity.this.f0.setBackgroundResource(C1523R$drawable.btn_preview_play_select);
                            EditorActivity.this.e0.setVisibility(0);
                        }
                    } else if (i2 == 37) {
                        EditorActivity.this.d1();
                    } else if (i2 != 38) {
                        SoundEntity soundEntity = null;
                        MediaClip mediaClip = null;
                        switch (i2) {
                            case 3:
                                if (!EditorActivity.this.r0) {
                                    Bundle data2 = message.getData();
                                    EditorActivity.this.I0 = data2.getFloat("cur_time");
                                    EditorActivity.this.K0 = data2.getFloat("total_time");
                                    String str2 = "update current time  ,current time is  " + EditorActivity.this.I0 + " , total time " + EditorActivity.this.K0;
                                    int H = (int) (((AbstractConfigActivity) EditorActivity.this).f8721n.H() * 1000.0f);
                                    if ((EditorActivity.this.K0 - EditorActivity.this.I0) * 1000.0f < 50.0f) {
                                        EditorActivity.this.c0.setText(SystemUtility.getTimeMinSecFormt((int) (EditorActivity.this.K0 * 1000.0f)));
                                    } else {
                                        EditorActivity.this.c0.setText(SystemUtility.getTimeMinSecFormt((int) (EditorActivity.this.I0 * 1000.0f)));
                                    }
                                    EditorActivity.this.b0.setMax(EditorActivity.this.K0);
                                    EditorActivity.this.b0.setProgress(EditorActivity.this.I0);
                                    int e2 = ((AbstractConfigActivity) EditorActivity.this).f8722o.e(EditorActivity.this.I0);
                                    ((AbstractConfigActivity) EditorActivity.this).f8722o.J(false);
                                    if (EditorActivity.this.L0 != e2) {
                                        EditorActivity.this.L0 = e2;
                                        if (EditorActivity.this.V) {
                                            MediaDatabase mediaDatabase2 = EditorActivity.this.f8720m;
                                            if (!(mediaDatabase2 == null || mediaDatabase2.getClipArray() == null || EditorActivity.this.f8720m.getClipArray().size() <= e2)) {
                                                if (EditorActivity.this.f8720m.getClip(e2).isAppendClip) {
                                                    EditorActivity.this.U0.setVisibility(4);
                                                } else {
                                                    EditorActivity.this.U0.setVisibility(0);
                                                    EditorActivity editorActivity4 = EditorActivity.this;
                                                    editorActivity4.u1 = editorActivity4.f8720m.getClip(e2).videoVolume;
                                                    EditorActivity editorActivity5 = EditorActivity.this;
                                                    editorActivity5.h8(editorActivity5.U0, EditorActivity.this.u1);
                                                }
                                            }
                                        } else {
                                            EditorActivity.this.U0.setVisibility(8);
                                        }
                                    }
                                    MediaDatabase mediaDatabase3 = EditorActivity.this.f8720m;
                                    if (mediaDatabase3 != null) {
                                        soundEntity = mediaDatabase3.getSoundEntityForTimeline(H);
                                    }
                                    if (soundEntity != null) {
                                        EditorActivity.this.V0.setVisibility(0);
                                        EditorActivity.this.V0.setProgress(soundEntity.volume);
                                    } else {
                                        EditorActivity.this.V0.setVisibility(8);
                                    }
                                    String str3 = "index:" + e2;
                                    return;
                                }
                                return;
                            case 4:
                                EditorActivity.this.K0 = ((Float) message.obj).floatValue();
                                EditorActivity.this.c0.setText(SystemUtility.getTimeMinSecFormt(0));
                                EditorActivity.this.d0.setText(SystemUtility.getTimeMinSecFormt((int) (EditorActivity.this.K0 * 1000.0f)));
                                EditorActivity.this.b0.setMax(EditorActivity.this.K0);
                                return;
                            case 5:
                                Bundle data3 = message.getData();
                                ((AbstractConfigActivity) EditorActivity.this).f8721n.w0(-1);
                                EditorActivity.this.I0 = ((Float) message.obj).floatValue();
                                int i3 = (int) (EditorActivity.this.K0 * 1000.0f);
                                int i4 = (int) (EditorActivity.this.I0 * 1000.0f);
                                if (i4 != 0 && i3 / i4 >= 50) {
                                    EditorActivity.this.I0 = 0.0f;
                                }
                                if (i3 - i4 < 50) {
                                    EditorActivity.this.c0.setText(SystemUtility.getTimeMinSecFormt((int) (EditorActivity.this.K0 * 1000.0f)));
                                } else {
                                    EditorActivity.this.c0.setText(SystemUtility.getTimeMinSecFormt((int) (EditorActivity.this.I0 * 1000.0f)));
                                }
                                ((AbstractConfigActivity) EditorActivity.this).f8721n.L0(EditorActivity.this.I0);
                                int e3 = ((AbstractConfigActivity) EditorActivity.this).f8722o.e(EditorActivity.this.I0);
                                ArrayList<FxMediaClipEntity> clipList = ((AbstractConfigActivity) EditorActivity.this).f8722o.b().getClipList();
                                if (clipList != null) {
                                    if (EditorActivity.this.L0 < 0) {
                                        EditorActivity editorActivity6 = EditorActivity.this;
                                        editorActivity6.L0 = ((AbstractConfigActivity) editorActivity6).f8722o.e(((AbstractConfigActivity) EditorActivity.this).f8721n.H());
                                    }
                                    int size = clipList.size();
                                    if (EditorActivity.this.L0 < size && e3 < size) {
                                        FxMediaClipEntity fxMediaClipEntity = clipList.get(EditorActivity.this.L0);
                                        FxMediaClipEntity fxMediaClipEntity2 = clipList.get(e3);
                                        String str4 = "cur_clip_index:" + EditorActivity.this.L0 + ",index:" + e3 + "clipCur.type=" + fxMediaClipEntity.type.toString();
                                        if (data3.getInt("state") == 2) {
                                            ((AbstractConfigActivity) EditorActivity.this).f8721n.N0(true);
                                        } else {
                                            EditorActivity.this.D1.postDelayed(new n0(this), 200);
                                        }
                                        if (EditorActivity.this.L0 == e3 && data3.getInt("state") == 2) {
                                            EditorActivity.this.M0 = true;
                                            return;
                                        }
                                        if (!(EditorActivity.this.L0 != e3 && fxMediaClipEntity.type == hl.productor.fxlib.a0.Video && fxMediaClipEntity2.type == hl.productor.fxlib.a0.Image) && EditorActivity.this.L0 == e3 && fxMediaClipEntity.type == hl.productor.fxlib.a0.Video) {
                                            String str5 = "seek FX_STATE_PLAY_DRAG_PROGRESS seekTime=" + ((EditorActivity.this.I0 - fxMediaClipEntity.gVideoClipStartTime) + fxMediaClipEntity.trimStartTime);
                                        }
                                        if (EditorActivity.this.L0 != e3) {
                                            String str6 = "FX_STATE_PLAY_DRAG_PROGRESS cur_clip_index:" + EditorActivity.this.L0 + " index" + e3;
                                            if (fxMediaClipEntity2.type == hl.productor.fxlib.a0.Video) {
                                                z2 = true;
                                                EditorActivity.this.M0 = true;
                                            } else {
                                                z2 = true;
                                                ((AbstractConfigActivity) EditorActivity.this).f8721n.z0();
                                            }
                                            EditorActivity.this.L0 = e3;
                                            EditorActivity.this.p1(e3, z2);
                                        }
                                        if (EditorActivity.this.q0) {
                                            EditorActivity.this.q0 = false;
                                            ((AbstractConfigActivity) EditorActivity.this).f8721n.k0();
                                            if (EditorActivity.this.I0 < EditorActivity.this.K0 - 0.1f) {
                                                EditorActivity.this.j1();
                                            }
                                        }
                                        EditorActivity.this.r0 = false;
                                        EditorActivity editorActivity7 = EditorActivity.this;
                                        editorActivity7.h8(editorActivity7.U0, clipList.get(EditorActivity.this.L0).videoVolume);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            case 6:
                                int i5 = message.arg1;
                                int intValue2 = ((Integer) message.obj).intValue();
                                ArrayList<FxMediaClipEntity> clipList2 = ((AbstractConfigActivity) EditorActivity.this).f8722o.b().getClipList();
                                if (clipList2 != null && clipList2.size() > 0) {
                                    if (intValue2 >= clipList2.size()) {
                                        intValue2 = 0;
                                    }
                                    String str7 = "FX_STATE_PLAY_CLICK_CLIPS cur_clip_index:" + EditorActivity.this.L0 + " index:" + intValue2 + " auto:" + i5;
                                    int i6 = EditorActivity.this.L0;
                                    EditorActivity.this.L0 = intValue2;
                                    if (clipList2.size() > 0 && clipList2.size() > EditorActivity.this.L0 && EditorActivity.this.L0 > -1) {
                                        FxMediaClipEntity fxMediaClipEntity3 = clipList2.get(EditorActivity.this.L0);
                                        if (i5 == 0) {
                                            z3 = true;
                                            ((AbstractConfigActivity) EditorActivity.this).f8721n.w0(1);
                                        } else {
                                            z3 = true;
                                        }
                                        if (fxMediaClipEntity3.type == hl.productor.fxlib.a0.Video) {
                                            if (i5 == 0) {
                                                EditorActivity.this.M0 = z3;
                                            }
                                            float f3 = fxMediaClipEntity3.trimStartTime;
                                        } else {
                                            ((AbstractConfigActivity) EditorActivity.this).f8721n.z0();
                                        }
                                    }
                                    if (i5 == 0) {
                                        ((AbstractConfigActivity) EditorActivity.this).f8721n.L0(((AbstractConfigActivity) EditorActivity.this).f8722o.g(intValue2));
                                    }
                                    EditorActivity editorActivity8 = EditorActivity.this;
                                    editorActivity8.I0 = ((AbstractConfigActivity) editorActivity8).f8721n.H();
                                    EditorActivity.this.p1(intValue2, i5 == 1);
                                    ((AbstractConfigActivity) EditorActivity.this).f8722o.K(true);
                                    if (EditorActivity.this.G0 == null && (mediaDatabase = (editorActivity = EditorActivity.this).f8720m) != null) {
                                        editorActivity.G0 = mediaDatabase.getCurrentClip();
                                        return;
                                    }
                                    return;
                                }
                                return;
                            case 7:
                                Bundle data4 = message.getData();
                                int i7 = data4.getInt("position");
                                data4.getString(ClientCookie.PATH_ATTR);
                                ((AbstractConfigActivity) EditorActivity.this).f8722o.a(i7, true);
                                EditorActivity.this.n6(false);
                                return;
                            case 8:
                                if (EditorActivity.this.B1 && !EditorActivity.this.l0) {
                                    MediaDatabase mediaDatabase4 = EditorActivity.this.f8720m;
                                    if (mediaDatabase4 != null) {
                                        mediaDatabase4.deleteWaterMarkSticker(MediaDatabase.WATERMARK);
                                    }
                                    ((AbstractConfigActivity) EditorActivity.this).f8722o.k(EditorActivity.this.f8720m);
                                    ((AbstractConfigActivity) EditorActivity.this).f8722o.D(true, 0);
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(String.format("!isExporting=%s,canAutoPlay=%s,!myView.isPlaying()=%s", Boolean.toString(!EditorActivity.this.S), Boolean.toString(y4.b), Boolean.toString(!((AbstractConfigActivity) EditorActivity.this).f8721n.h0())));
                                    sb.append("@");
                                    EditorActivity editorActivity9 = EditorActivity.this;
                                    sb.append(Boolean.toString(!editorActivity9.S && y4.b && !((AbstractConfigActivity) editorActivity9).f8721n.h0()));
                                    sb.toString();
                                    EditorActivity editorActivity10 = EditorActivity.this;
                                    if (editorActivity10.S || !y4.b || ((AbstractConfigActivity) editorActivity10).f8721n.h0()) {
                                        z4 = true;
                                    } else {
                                        EditorActivity editorActivity11 = EditorActivity.this;
                                        z4 = true;
                                        editorActivity11.s8(((AbstractConfigActivity) editorActivity11).f8721n.h0(), true);
                                    }
                                    y4.b = z4;
                                    Message message3 = new Message();
                                    message3.what = 6;
                                    message3.obj = Integer.valueOf(((AbstractConfigActivity) EditorActivity.this).f8722o.e(EditorActivity.this.I0));
                                    message3.arg1 = 1;
                                    EditorActivity.this.D1.sendMessageDelayed(message3, 200);
                                    return;
                                }
                                return;
                            case 9:
                                if (EditorActivity.this.B1 && !EditorActivity.this.l0) {
                                    new com.xvideostudio.videoeditor.fragment.s().show(EditorActivity.this.getSupportFragmentManager(), "");
                                    com.xvideostudio.videoeditor.tool.a0.a(1).execute(new q0(this));
                                    return;
                                }
                                return;
                            case 10:
                                EditorActivity.this.D1.sendEmptyMessage(8);
                                return;
                            case 11:
                                EditorActivity.this.D1.sendEmptyMessage(8);
                                return;
                            default:
                                switch (i2) {
                                    case 18:
                                        y4.b = false;
                                        EditorActivity.this.D1.sendEmptyMessage(8);
                                        return;
                                    case 19:
                                        EditorActivity.this.D1.sendEmptyMessage(8);
                                        return;
                                    case 20:
                                        EditorActivity editorActivity12 = EditorActivity.this;
                                        editorActivity12.R = false;
                                        editorActivity12.S = true;
                                        editorActivity12.l1();
                                        if (((AbstractConfigActivity) EditorActivity.this).f8721n.h0()) {
                                            EditorActivity editorActivity13 = EditorActivity.this;
                                            editorActivity13.s8(((AbstractConfigActivity) editorActivity13).f8721n.h0(), true);
                                        }
                                        EditorActivity.this.D1.sendEmptyMessage(21);
                                        return;
                                    case 21:
                                        if (com.xvideostudio.videoeditor.t.h() != 4) {
                                            EditorActivity.this.j8();
                                        }
                                        if (com.xvideostudio.videoeditor.t.h() == 4) {
                                            Intent intent = new Intent(EditorActivity.this, ShareActivity.class);
                                            intent.putExtra(MediaDatabase.SERIALIZABLE_EXTRA, EditorActivity.this.f8720m);
                                            intent.putExtra("glViewWidth", EditorActivity.this.H);
                                            intent.putExtra("glViewHeight", EditorActivity.this.I);
                                            intent.putExtra("exportvideoquality", EditorActivity.this.H0);
                                            intent.putExtra("exporttype", "4");
                                            intent.putExtra("videoLength", SystemUtility.getTimeMinSecFormt((int) (EditorActivity.this.K0 * 1000.0f)));
                                            intent.putExtra("exportVideoTotalTime", EditorActivity.this.K0);
                                            intent.putExtra(ViewHierarchyConstants.TAG_KEY, 2);
                                            intent.putExtra("contest_id", EditorActivity.this.X0);
                                            intent.putExtra("isClip1080p", EditorActivity.this.A1);
                                            intent.putExtra("name", EditorActivity.this.P0);
                                            intent.putExtra("ordinal", EditorActivity.this.Q0);
                                            intent.putExtra("editor_mode", EditorActivity.this.F0);
                                            VideoEditorApplication.H = 0;
                                            EditorActivity.this.startActivity(intent);
                                            return;
                                        } else if (com.xvideostudio.videoeditor.t.h() == 0) {
                                            if (((AbstractConfigActivity) EditorActivity.this).f8721n != null) {
                                                ((AbstractConfigActivity) EditorActivity.this).f8721n.w();
                                            }
                                            com.xvideostudio.videoeditor.tool.a0.a(1).execute(new o0(this));
                                            return;
                                        } else if (com.xvideostudio.videoeditor.t.h() == 3) {
                                            if (((AbstractConfigActivity) EditorActivity.this).f8721n != null) {
                                                ((AbstractConfigActivity) EditorActivity.this).f8721n.w();
                                            }
                                            com.xvideostudio.videoeditor.tool.a0.a(1).execute(new p0(this));
                                            return;
                                        } else if (com.xvideostudio.videoeditor.t.h() == 2) {
                                            MediaDatabase mediaDatabase5 = EditorActivity.this.f8720m;
                                            if (mediaDatabase5 != null) {
                                                mediaClip = mediaDatabase5.getClip(0);
                                            }
                                            if (mediaClip != null) {
                                                com.xvideostudio.videoeditor.tool.a0.a(1).execute(new s0(this, mediaClip.path, new a()));
                                                return;
                                            }
                                            return;
                                        } else {
                                            return;
                                        }
                                    case 22:
                                        if (EditorActivity.this.S) {
                                            Bundle data5 = message.getData();
                                            EditorActivity.this.E = data5.getInt("state");
                                            int i8 = data5.getInt("progress");
                                            k0.b().f(i8 + "");
                                            EditorActivity editorActivity14 = EditorActivity.this;
                                            SeekBar seekBar = editorActivity14.P;
                                            if (!(seekBar == null || editorActivity14.Q == null)) {
                                                seekBar.setProgress(i8);
                                                EditorActivity.this.Q.setText(EditorActivity.this.getResources().getString(2131821059) + String.format("   %d/100", Integer.valueOf(i8)));
                                            }
                                            EditorActivity editorActivity15 = EditorActivity.this;
                                            if (1 == editorActivity15.E && (textView = editorActivity15.Q) != null) {
                                                textView.setText(2131821054);
                                            }
                                            if (hl.productor.fxlib.h.G) {
                                                ExportNotifyBean exportNotifyBean = new ExportNotifyBean();
                                                exportNotifyBean.title = EditorActivity.this.getResources().getString(2131820630);
                                                exportNotifyBean.progress = i8;
                                                exportNotifyBean.speedStr = "";
                                                exportNotifyBean.exportInfo = "";
                                                EditorActivity editorActivity16 = EditorActivity.this;
                                                int i9 = editorActivity16.E;
                                                if (1 == i9) {
                                                    editorActivity16.Q.setText(2131821054);
                                                    exportNotifyBean.tip = EditorActivity.this.getString(2131821054);
                                                } else if (i9 == 0) {
                                                    exportNotifyBean.tip = editorActivity16.getString(2131821059);
                                                }
                                                if (EditorActivity.this.T0 == null) {
                                                    EditorActivity editorActivity17 = EditorActivity.this;
                                                    editorActivity17.T0 = new com.xvideostudio.videoeditor.l0.a(editorActivity17);
                                                }
                                                EditorActivity.this.T0.b(exportNotifyBean, false);
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    case 23:
                                        if (((AbstractConfigActivity) EditorActivity.this).f8721n != null) {
                                            ((AbstractConfigActivity) EditorActivity.this).f8721n.v0();
                                        }
                                        hl.productor.fxlib.h.n0 = false;
                                        EditorActivity editorActivity18 = EditorActivity.this;
                                        editorActivity18.S = false;
                                        editorActivity18.I0 = 0.0f;
                                        com.xvideostudio.videoeditor.tool.f fVar = EditorActivity.this.O;
                                        if (fVar != null && fVar.isShowing()) {
                                            EditorActivity.this.O.dismiss();
                                        }
                                        EditorActivity editorActivity19 = EditorActivity.this;
                                        editorActivity19.O = null;
                                        if (!hl.productor.fxlib.h.G || editorActivity19.T0 == null) {
                                            z5 = true;
                                        } else {
                                            z5 = true;
                                            EditorActivity.this.T0.b(null, true);
                                        }
                                        com.xvideostudio.videoeditor.l0.c.U(AbstractConfigActivity.t, AbstractConfigActivity.u);
                                        EditorActivity editorActivity20 = EditorActivity.this;
                                        editorActivity20.R = z5;
                                        editorActivity20.D1.sendEmptyMessage(24);
                                        return;
                                    case 24:
                                        if (((AbstractConfigActivity) EditorActivity.this).f8721n != null) {
                                            ((AbstractConfigActivity) EditorActivity.this).f8721n.v0();
                                        }
                                        hl.productor.fxlib.h.n0 = false;
                                        EditorActivity.this.S = false;
                                        k0.b().a();
                                        com.xvideostudio.videoeditor.tool.f fVar2 = EditorActivity.this.O;
                                        if (fVar2 != null && fVar2.isShowing() && !EditorActivity.this.isFinishing()) {
                                            EditorActivity.this.O.dismiss();
                                        }
                                        EditorActivity editorActivity21 = EditorActivity.this;
                                        editorActivity21.O = null;
                                        if (editorActivity21.R) {
                                            editorActivity21.I0 = 0.0f;
                                            ((AbstractConfigActivity) EditorActivity.this).f8721n.s0();
                                            m0.l(com.xvideostudio.videoeditor.t.b);
                                            EditorActivity.this.R = false;
                                            EditorActivity.this.D1.sendEmptyMessage(8);
                                            return;
                                        }
                                        if (hl.productor.fxlib.h.G && editorActivity21.T0 != null) {
                                            ExportNotifyBean exportNotifyBean2 = new ExportNotifyBean();
                                            exportNotifyBean2.title = EditorActivity.this.getResources().getString(2131820630);
                                            exportNotifyBean2.progress = 100;
                                            exportNotifyBean2.speedStr = "";
                                            exportNotifyBean2.exportInfo = "";
                                            exportNotifyBean2.tip = EditorActivity.this.getResources().getString(2131821051);
                                            exportNotifyBean2.clsName = "activity.ShareActivity";
                                            EditorActivity.this.T0.b(exportNotifyBean2, false);
                                        }
                                        if (h.a.x.e.l0 > 5.0f && hl.productor.fxlib.h.g(EditorActivity.this.C)) {
                                            HashMap hashMap = new HashMap();
                                            hashMap.put("appver", com.xvideostudio.videoeditor.x0.c0.r(EditorActivity.this.C));
                                            hashMap.put("rate", "1-" + h.a.x.e.l0);
                                            hashMap.put("passtime", h.a.x.e.m0 + "");
                                            hashMap.put("outwh", h.a.x.e.n0 + "*" + h.a.x.e.o0);
                                            hashMap.put("phonewh", AbstractConfigActivity.r + "*" + AbstractConfigActivity.s);
                                            StringBuilder sb2 = new StringBuilder();
                                            sb2.append(com.xvideostudio.videoeditor.x0.c0.H());
                                            sb2.append("");
                                            hashMap.put("os:", sb2.toString());
                                            hashMap.put("cpuname", com.xvideostudio.videoeditor.x0.c0.o());
                                            hashMap.put("cpunum", com.xvideostudio.videoeditor.x0.c0.G() + "");
                                            hashMap.put("cpufreq", com.xvideostudio.videoeditor.x0.c0.B());
                                            hashMap.put("model", com.xvideostudio.videoeditor.x0.c0.E());
                                            m1.b(EditorActivity.this.C, "EXPORT_VIDEO_SPEED_INFO", hashMap.toString());
                                        }
                                        VideoEditorApplication.y().u0(com.xvideostudio.videoeditor.t.b, !TextUtils.isEmpty(EditorActivity.this.P0), EditorActivity.this.Q0, "");
                                        Intent intent2 = new Intent();
                                        intent2.setClass(EditorActivity.this.C, ShareActivity.class);
                                        intent2.putExtra(ClientCookie.PATH_ATTR, com.xvideostudio.videoeditor.t.b);
                                        intent2.putExtra("exporttype", "3");
                                        intent2.putExtra(MediaDatabase.SERIALIZABLE_EXTRA, EditorActivity.this.f8720m);
                                        intent2.putExtra(ViewHierarchyConstants.TAG_KEY, 1);
                                        intent2.putExtra("isDraft", true);
                                        intent2.putExtra("enableads", true);
                                        intent2.putExtra("export2share", true);
                                        intent2.putExtra("contest_id", EditorActivity.this.X0);
                                        intent2.putExtra("isClip1080p", EditorActivity.this.A1);
                                        intent2.putExtra("name", EditorActivity.this.P0);
                                        intent2.putExtra("ordinal", EditorActivity.this.Q0);
                                        intent2.putExtra("editor_mode", EditorActivity.this.F0);
                                        VideoEditorApplication.H = 0;
                                        EditorActivity.this.C.startActivity(intent2);
                                        ((Activity) EditorActivity.this.C).finish();
                                        if (hl.productor.fxlib.h.G) {
                                            ((AbstractConfigActivity) EditorActivity.this).f8721n.K().setVisibility(4);
                                        }
                                        EditorActivity.this.c1();
                                        com.xvideostudio.videoeditor.t.b = null;
                                        return;
                                    case 25:
                                        ((AbstractConfigActivity) EditorActivity.this).f8722o.X(EditorActivity.this.f8720m);
                                        return;
                                    case 26:
                                        if (!EditorActivity.this.r0) {
                                            boolean z6 = message.getData().getBoolean("state");
                                            if (EditorActivity.this.M0 || EditorActivity.this.J0 != EditorActivity.this.I0 || z6) {
                                                EditorActivity editorActivity22 = EditorActivity.this;
                                                editorActivity22.J0 = editorActivity22.I0;
                                                int e4 = ((AbstractConfigActivity) EditorActivity.this).f8722o.e(((AbstractConfigActivity) EditorActivity.this).f8721n.H());
                                                ArrayList<FxMediaClipEntity> clipList3 = ((AbstractConfigActivity) EditorActivity.this).f8722o.b().getClipList();
                                                String str8 = "EditorActivityStatesEntity.FX_STATE_PLAY_VIDEO_PREPARED tmp_cur_clip_index:" + e4;
                                                if (clipList3 != null && clipList3.size() != 0) {
                                                    FxMediaClipEntity fxMediaClipEntity4 = clipList3.get(e4);
                                                    if (fxMediaClipEntity4.type != hl.productor.fxlib.a0.Image) {
                                                        String str9 = "prepared: fx_play_cur_time:" + EditorActivity.this.I0 + " clipCur1.gVideoClipStartTime:" + fxMediaClipEntity4.gVideoClipStartTime + " clipCur1.trimStartTime:" + fxMediaClipEntity4.trimStartTime;
                                                        String str10 = "prepared: local_time:" + ((EditorActivity.this.I0 - fxMediaClipEntity4.gVideoClipStartTime) + fxMediaClipEntity4.trimStartTime) + " needSeekVideo:" + EditorActivity.this.M0;
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                            String str11 = "prepared: break; fx_play_cur_time:" + EditorActivity.this.I0;
                                            return;
                                        }
                                        return;
                                    case 27:
                                        if (!EditorActivity.this.r0) {
                                            if (EditorActivity.this.L0 < 0) {
                                                EditorActivity editorActivity23 = EditorActivity.this;
                                                editorActivity23.L0 = ((AbstractConfigActivity) editorActivity23).f8722o.e(((AbstractConfigActivity) EditorActivity.this).f8721n.H());
                                            }
                                            int i10 = message.getData().getInt("cur_time_seek_complete");
                                            ArrayList<FxMediaClipEntity> clipList4 = ((AbstractConfigActivity) EditorActivity.this).f8722o.b().getClipList();
                                            if (clipList4 != null && clipList4.size() != 0) {
                                                if (EditorActivity.this.L0 >= clipList4.size()) {
                                                    EditorActivity editorActivity24 = EditorActivity.this;
                                                    editorActivity24.L0 = ((AbstractConfigActivity) editorActivity24).f8722o.e(((AbstractConfigActivity) EditorActivity.this).f8721n.H());
                                                }
                                                float f4 = clipList4.get(EditorActivity.this.L0).trimStartTime;
                                                String str12 = "seek FX_STATE_PLAY_VIDEO_SEEK_COMPLETE seek_complete=" + i10 + " trimStartTime=" + f4 + " new_time_float=" + (((AbstractConfigActivity) EditorActivity.this).f8722o.f(EditorActivity.this.L0) + ((((float) i10) / 1000.0f) - f4));
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    default:
                                        switch (i2) {
                                            case 40:
                                                if (EditorActivity.this.C1) {
                                                    int i11 = message.arg1;
                                                    if (i11 >= 0) {
                                                        f2 = ((float) i11) / 1000.0f;
                                                    } else {
                                                        f2 = ((AbstractConfigActivity) EditorActivity.this).f8722o.f(EditorActivity.this.L0);
                                                    }
                                                    ((AbstractConfigActivity) EditorActivity.this).f8721n.L0(f2);
                                                    EditorActivity.this.C1 = false;
                                                    return;
                                                }
                                                return;
                                            case 41:
                                                EditorActivity.this.r6(12);
                                                return;
                                            case 42:
                                                EditorActivity.this.D1.sendEmptyMessage(8);
                                                return;
                                            default:
                                                switch (i2) {
                                                    case 44:
                                                        EditorActivity editorActivity25 = EditorActivity.this;
                                                        if (!editorActivity25.D) {
                                                            editorActivity25.D = true;
                                                            ((AbstractConfigActivity) editorActivity25).f8722o.a0(EditorActivity.this.f8720m);
                                                            EditorActivity.this.D = false;
                                                            return;
                                                        }
                                                        return;
                                                    case 45:
                                                        EditorActivity.this.n6(true);
                                                        return;
                                                    case 46:
                                                    case 47:
                                                        if (!EditorActivity.this.S0) {
                                                            EditorActivity.this.S0 = true;
                                                            if (message.what == 47) {
                                                                new com.xvideostudio.videoeditor.fragment.s().show(EditorActivity.this.getSupportFragmentManager(), "");
                                                                com.xvideostudio.videoeditor.tool.a0.a(1).execute(new r0(this));
                                                                return;
                                                            }
                                                            ((AbstractConfigActivity) EditorActivity.this).f8722o.Y(EditorActivity.this.f8720m);
                                                            Message message4 = new Message();
                                                            message4.what = 54;
                                                            message4.obj = 8;
                                                            EditorActivity.this.D1.sendMessage(message4);
                                                            return;
                                                        }
                                                        return;
                                                    default:
                                                        return;
                                                }
                                        }
                                }
                        }
                    } else {
                        EditorActivity.this.r6(10);
                    }
                } else if (!EditorActivity.this.r0) {
                    EditorActivity.this.u8();
                    EditorActivity.this.I0 = 0.0f;
                    EditorActivity.this.L0 = -1;
                    EditorActivity.this.p1(0, true);
                    EditorActivity.this.b0.setProgress(0.0f);
                    if (EditorActivity.this.m1) {
                        EditorActivity.this.m1 = false;
                        ((AbstractConfigActivity) EditorActivity.this).f8721n.L0(0.0f);
                        return;
                    }
                    ((AbstractConfigActivity) EditorActivity.this).f8721n.s0();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class c implements Runnable {
        c() {
        }

        public void run() {
            EditorActivity.this.z0.F(EditorActivity.this.q1);
        }
    }

    class c0 implements Handler.Callback {
        c0() {
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void b(int i2, View view) {
            EditorActivity.this.i6(i2);
            EditorActivity.this.h1 = !((Boolean) view.getTag()).booleanValue();
        }

        /* access modifiers changed from: private */
        /* renamed from: c */
        public /* synthetic */ void d(View view) {
            EditorActivity.this.h1 = !((Boolean) view.getTag()).booleanValue();
        }

        public boolean handleMessage(Message message) {
            RecyclerView recyclerView;
            int i2 = message.what;
            if (i2 == 3) {
                SiteInfoBean siteInfoBean = (SiteInfoBean) message.getData().getSerializable("item");
                if (siteInfoBean == null) {
                    return false;
                }
                if (EditorActivity.this.y0 != null) {
                    EditorActivity.this.y0.notifyDataSetChanged();
                }
                if (com.xvideostudio.videoeditor.materialdownload.d.h() < ((long) (siteInfoBean.fileSize - siteInfoBean.downloadLength))) {
                    com.xvideostudio.videoeditor.tool.m.p(2131820885, -1, 0);
                    return false;
                } else if (!i1.c(EditorActivity.this.C)) {
                    com.xvideostudio.videoeditor.tool.m.p(2131821483, -1, 0);
                }
            } else if (i2 == 4) {
                int i3 = message.getData().getInt("materialID");
                if (EditorActivity.this.Z0 == 0) {
                    if (EditorActivity.this.y0 != null) {
                        EditorActivity.this.y0.notifyDataSetChanged();
                    }
                    if (i3 > 0 && !EditorActivity.this.P1) {
                        if (EditorActivity.this.g1 == null) {
                            EditorActivity editorActivity = EditorActivity.this;
                            String str = editorActivity.F0;
                            EditorActivity editorActivity2 = EditorActivity.this;
                            editorActivity.g1 = com.xvideostudio.videoeditor.l0.c.r(i3, 0, str, editorActivity2.f8720m, editorActivity2.C);
                        }
                        if (EditorActivity.this.h1) {
                            EditorActivity editorActivity3 = EditorActivity.this;
                            if (editorActivity3.K7(editorActivity3.g1)) {
                                com.xvideostudio.videoeditor.x0.e0.c0(EditorActivity.this, new v0(this, i3), new u0(this));
                            }
                        }
                        EditorActivity.this.i6(i3);
                    }
                } else if (EditorActivity.this.Z0 == 1) {
                    EditorActivity editorActivity4 = EditorActivity.this;
                    editorActivity4.O7(editorActivity4.p1);
                    if (!(EditorActivity.this.z0 == null || EditorActivity.this.z0.p() == null)) {
                        int i4 = 0;
                        while (true) {
                            if (i4 >= EditorActivity.this.z0.p().size()) {
                                break;
                            } else if (i3 == EditorActivity.this.z0.p().get(i4).getMaterial().getId()) {
                                EditorActivity.this.q1 = i4;
                                EditorActivity.this.t1 = -1;
                                break;
                            } else {
                                i4++;
                            }
                        }
                        if (EditorActivity.this.z0.p().size() > EditorActivity.this.q1 && EditorActivity.this.q1 > -1) {
                            EditorActivity editorActivity5 = EditorActivity.this;
                            editorActivity5.N7(editorActivity5.z0.p().get(EditorActivity.this.q1), EditorActivity.this.q1);
                            EditorActivity.this.z0.F(EditorActivity.this.q1);
                            EditorActivity.this.A0.F(EditorActivity.this.p1);
                        }
                    }
                } else if (!(EditorActivity.this.z0 == null || EditorActivity.this.z0.p() == null)) {
                    SimpleInf simpleInf = null;
                    int i5 = 0;
                    while (true) {
                        if (i5 >= EditorActivity.this.z0.p().size()) {
                            break;
                        } else if (i3 == EditorActivity.this.z0.p().get(i5).getMaterial().getId()) {
                            simpleInf = EditorActivity.this.z0.p().get(i5);
                            break;
                        } else {
                            i5++;
                        }
                    }
                    if (simpleInf != null) {
                        SiteInfoBean k2 = VideoEditorApplication.y().o().a.k(simpleInf.music_id);
                        Material material = simpleInf.getMaterial();
                        if (!(material == null || k2 == null)) {
                            material.setSave_path(k2.getMusicPath());
                        }
                    }
                }
                if (EditorActivity.this.Q1) {
                    EditorActivity.this.Q1 = false;
                    DialogAdUtils.showRewardDialog(EditorActivity.this.v1, "inner_material_vip_once_unlock");
                }
            } else if (i2 == 5) {
                int i6 = message.getData().getInt("materialID");
                int i7 = message.getData().getInt("process");
                if (EditorActivity.this.Z0 == 0) {
                    recyclerView = EditorActivity.this.t0;
                } else {
                    recyclerView = EditorActivity.this.u0;
                }
                if (!(recyclerView == null || i7 == 0)) {
                    ImageView imageView = (ImageView) recyclerView.findViewWithTag("iv_down" + i6);
                    if (imageView != null) {
                        if (imageView.getVisibility() != 8) {
                            imageView.setVisibility(8);
                        }
                        if (EditorActivity.this.P1) {
                            imageView.setVisibility(8);
                        }
                    }
                    if (EditorActivity.this.P1 && EditorActivity.this.O1 != null) {
                        ((ProgressBar) EditorActivity.this.O1.findViewById(C1524R$id.pb_download_material_materail_detail)).setProgress(i7);
                        if (i7 >= 100) {
                            ((TextView) EditorActivity.this.O1.findViewById(C1524R$id.tv_material_name)).setText(EditorActivity.this.getString(2131820887));
                            Object[] objArr = new Object[1];
                            objArr[0] = EditorActivity.this.Z0 == 0 ? "主题" : "配乐";
                            String format = String.format("素材列表下载成功_%s", objArr);
                            com.xvideostudio.videoeditor.x0.p2.b.e(format, "material_id", i6 + "");
                        }
                    }
                    TextView textView = (TextView) recyclerView.findViewWithTag("tv_process" + i6);
                    if (textView != null) {
                        if (textView.getVisibility() != 0) {
                            textView.setVisibility(0);
                        }
                        textView.setText(i7 + "%");
                        if (EditorActivity.this.P1) {
                            textView.setVisibility(8);
                        }
                    }
                }
            }
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public class d implements Runnable {
        d() {
        }

        public void run() {
            EditorActivity.this.b1 = true;
            EditorActivity.this.invalidateOptionsMenu();
        }
    }

    class d0 implements View.OnClickListener {
        d0(EditorActivity editorActivity) {
        }

        public void onClick(View view) {
        }
    }

    /* access modifiers changed from: package-private */
    public class e implements View.OnClickListener {

        class a implements Runnable {
            a() {
            }

            public void run() {
                EditorActivity.this.f0.setEnabled(true);
                EditorActivity.this.g0.setEnabled(true);
            }
        }

        e() {
        }

        public void onClick(View view) {
            if (((AbstractConfigActivity) EditorActivity.this).f8721n != null && ((AbstractConfigActivity) EditorActivity.this).f8721n.h0()) {
                EditorActivity.this.e0.setVisibility(0);
                EditorActivity.this.f0.setEnabled(false);
                EditorActivity.this.g0.setEnabled(false);
                EditorActivity editorActivity = EditorActivity.this;
                editorActivity.D1.postDelayed(new a(), (long) editorActivity.getResources().getInteger(2131361806));
                EditorActivity editorActivity2 = EditorActivity.this;
                editorActivity2.s8(((AbstractConfigActivity) editorActivity2).f8721n.h0(), true);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class e0 implements SeekBar.OnSeekBarChangeListener {
        e0() {
        }

        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            EditorActivity.this.u1 = i2;
            EditorActivity.this.f8(z);
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("百分百", EditorActivity.this.e1 + "%");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            m1.a(EditorActivity.this, "EDITOR_SCREEN_VOLUME_SEEKBAR_SET");
            EditorActivity.this.d1();
        }
    }

    /* access modifiers changed from: package-private */
    public class f implements MSeekbarNew.b {
        f() {
        }

        @Override // com.xvideostudio.videoeditor.tool.MSeekbarNew.b
        public void a(float f2) {
            Message message = new Message();
            message.what = 5;
            Bundle bundle = new Bundle();
            bundle.putInt("state", 1);
            message.setData(bundle);
            message.obj = Float.valueOf(f2);
            EditorActivity.this.D1.sendMessage(message);
        }

        @Override // com.xvideostudio.videoeditor.tool.MSeekbarNew.b
        public void b(float f2) {
            if (((AbstractConfigActivity) EditorActivity.this).f8721n != null) {
                EditorActivity.this.r0 = true;
                if (((AbstractConfigActivity) EditorActivity.this).f8721n.h0()) {
                    EditorActivity.this.q0 = true;
                    ((AbstractConfigActivity) EditorActivity.this).f8721n.j0();
                }
            }
        }

        @Override // com.xvideostudio.videoeditor.tool.MSeekbarNew.b
        public void c(float f2) {
            String str = "OnSeekBarChange value=" + f2;
            Message message = new Message();
            message.what = 5;
            Bundle bundle = new Bundle();
            bundle.putInt("state", 2);
            message.setData(bundle);
            message.obj = Float.valueOf(f2);
            EditorActivity.this.D1.sendMessage(message);
        }
    }

    /* access modifiers changed from: package-private */
    public class f0 implements SeekBar.OnSeekBarChangeListener {
        f0() {
        }

        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            EditorActivity.this.e1 = i2;
            EditorActivity.this.d8(z);
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            m1.a(VideoEditorApplication.y(), "SOUND_MUSIC_ADJUST");
            EditorActivity.this.d1();
        }
    }

    /* access modifiers changed from: package-private */
    public class g implements View.OnClickListener {
        g() {
        }

        public void onClick(View view) {
            if (((AbstractConfigActivity) EditorActivity.this).f8721n != null) {
                if (EditorActivity.this.S0) {
                    if (EditorActivity.this.f1 > 2) {
                        EditorActivity.this.S0 = false;
                    }
                    EditorActivity.t3(EditorActivity.this);
                    return;
                }
                EditorActivity.this.f1 = 0;
                m1.a(EditorActivity.this.C, "EDITOR_ACTIVITY_CLICK_FULLSCREEN_BUTTON");
                EditorActivity.this.l0 = true;
                Intent intent = new Intent(EditorActivity.this, EditorPreviewActivity.class);
                float H = ((AbstractConfigActivity) EditorActivity.this).f8721n.H();
                intent.putExtra("editorRenderTime", H);
                if (((AbstractConfigActivity) EditorActivity.this).f8722o != null) {
                    intent.putExtra("editorClipIndex", ((AbstractConfigActivity) EditorActivity.this).f8722o.e(H));
                }
                intent.putExtra(MediaDatabase.SERIALIZABLE_EXTRA, EditorActivity.this.f8720m);
                intent.putExtra("glWidthEditor", EditorActivity.this.H);
                intent.putExtra("glHeightEditor", EditorActivity.this.I);
                if (((AbstractConfigActivity) EditorActivity.this).f8721n != null) {
                    intent.putExtra("isPlaying", ((AbstractConfigActivity) EditorActivity.this).f8721n.h0());
                } else {
                    intent.putExtra("isPlaying", false);
                }
                EditorActivity.this.startActivityForResult(intent, 15);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class g0 implements Runnable {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f7928f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ int f7929g;

        g0(int i2, int i3) {
            this.f7928f = i2;
            this.f7929g = i3;
        }

        /* JADX WARNING: Removed duplicated region for block: B:62:0x0149  */
        public void run() {
            int i2;
            int i3;
            Exception e2;
            String string;
            EditorActivity editorActivity = EditorActivity.this;
            MediaDatabase mediaDatabase = editorActivity.f8720m;
            if (mediaDatabase != null) {
                FxThemeU3DEntity fxThemeU3DEntity = null;
                mediaDatabase.titleEntity = null;
                int i4 = this.f7928f;
                int i5 = this.f7929g;
                String str = editorActivity.F0;
                EditorActivity editorActivity2 = EditorActivity.this;
                FxThemeU3DEntity r = com.xvideostudio.videoeditor.l0.c.r(i4, i5, str, editorActivity2.f8720m, editorActivity2.C);
                EditorActivity.this.f8720m.initThemeU3D(r, true, EditorActivity.this.E0 != null && EditorActivity.this.E0.equals(MessengerShareContentUtility.MEDIA_IMAGE), true);
                EditorActivity editorActivity3 = EditorActivity.this;
                if (this.f7929g != 1) {
                    fxThemeU3DEntity = r;
                }
                editorActivity3.l6(fxThemeU3DEntity);
                EditorActivity.this.f8720m.setThemeU3dEntity(r);
                ArrayList<SoundEntity> soundList = EditorActivity.this.f8720m.getSoundList();
                if ((soundList == null || soundList.size() == 0 || (soundList.size() == 1 && soundList.get(0).isTheme)) && r != null && !TextUtils.isEmpty(r.musicConfig)) {
                    int i6 = 50;
                    if (soundList != null) {
                        try {
                            if (soundList.size() >= 1 && !soundList.get(0).isCamera) {
                                i6 = soundList.get(0).volume;
                            }
                            soundList.clear();
                            EditorActivity.this.f8720m.upCameraClipAudio();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    int totalDuration = EditorActivity.this.f8720m.getTotalDuration();
                    if (!r.musicConfig.startsWith("{") || !r.musicConfig.endsWith("}")) {
                        Map<String, String> map = VideoMakerApplication.E0().get(r.musicConfig);
                        if (map != null) {
                            String str2 = com.xvideostudio.videoeditor.l0.b.f0() + map.get("fileName");
                            if (new File(str2).exists()) {
                                int intValue = Integer.valueOf(map.get(VastIconXmlManager.DURATION)).intValue();
                                EditorActivity.this.f8720m.addClipAudio(map.get("musicName"), str2, 0, intValue, intValue, true, 0, totalDuration, false, true);
                                EditorActivity.this.f8720m.getSoundList().get(0).volume = i6;
                                EditorActivity.this.e1();
                            }
                        }
                    } else {
                        try {
                            JSONObject jSONObject = new JSONObject(r.musicConfig);
                            String str3 = r.u3dThemePath + jSONObject.getString(ClientCookie.PATH_ATTR);
                            if (new File(str3).exists()) {
                                String x = com.xvideostudio.videoeditor.x0.c0.x();
                                String w = com.xvideostudio.videoeditor.x0.c0.w();
                                String str4 = "";
                                if (!jSONObject.isNull(x)) {
                                    string = jSONObject.getString(x);
                                } else if (!jSONObject.isNull(w)) {
                                    string = jSONObject.getString(w);
                                } else {
                                    if (!jSONObject.isNull("en")) {
                                        string = jSONObject.getString("en");
                                    }
                                    MediaPlayer create = MediaPlayer.create(EditorActivity.this.C, Uri.parse(str3));
                                    i3 = create.getDuration();
                                    try {
                                        create.release();
                                    } catch (Exception e4) {
                                        e2 = e4;
                                    }
                                    if (i3 > 0) {
                                        EditorActivity.this.f8720m.addClipAudio(str4, str3, 0, i3, i3, true, 0, totalDuration, false, true);
                                        EditorActivity.this.f8720m.getSoundList().get(0).volume = i6;
                                        EditorActivity.this.e1();
                                    }
                                }
                                str4 = string;
                                try {
                                    MediaPlayer create2 = MediaPlayer.create(EditorActivity.this.C, Uri.parse(str3));
                                    i3 = create2.getDuration();
                                    create2.release();
                                } catch (Exception e5) {
                                    e2 = e5;
                                    i3 = 0;
                                    e2.printStackTrace();
                                    try {
                                        MediaPlayer mediaPlayer = new MediaPlayer();
                                        mediaPlayer.setDataSource(str3);
                                        mediaPlayer.prepare();
                                        i3 = mediaPlayer.getDuration();
                                        mediaPlayer.release();
                                    } catch (Exception e6) {
                                        e6.printStackTrace();
                                    }
                                    if (i3 > 0) {
                                    }
                                    MediaDatabase mediaDatabase2 = EditorActivity.this.f8720m;
                                    int[] calculateGlViewSizeDynamic = mediaDatabase2.calculateGlViewSizeDynamic(mediaDatabase2, AbstractConfigActivity.t, AbstractConfigActivity.u, AbstractConfigActivity.r);
                                    i2 = calculateGlViewSizeDynamic[1];
                                    int i7 = calculateGlViewSizeDynamic[2];
                                    if (AbstractConfigActivity.t == i2) {
                                    }
                                    EditorActivity.this.k1 = true;
                                    EditorActivity.this.D1.sendEmptyMessage(45);
                                    EditorActivity.this.d1();
                                    return;
                                }
                                if (i3 > 0) {
                                }
                            }
                        } catch (Exception e7) {
                            e7.printStackTrace();
                        }
                    }
                } else if (soundList != null && soundList.size() > 0) {
                    if (soundList.size() == 1 && soundList.get(0).isTheme) {
                        EditorActivity.this.f8720m.getSoundList().clear();
                    } else if (soundList.size() != 1 || soundList.get(0).isCamera) {
                        EditorActivity.this.f8720m.addCameraClipAudio();
                    } else {
                        EditorActivity.this.f8720m.getSoundList().get(0).gVideoEndTime = EditorActivity.this.f8720m.getTotalDuration();
                    }
                }
                MediaDatabase mediaDatabase22 = EditorActivity.this.f8720m;
                int[] calculateGlViewSizeDynamic2 = mediaDatabase22.calculateGlViewSizeDynamic(mediaDatabase22, AbstractConfigActivity.t, AbstractConfigActivity.u, AbstractConfigActivity.r);
                i2 = calculateGlViewSizeDynamic2[1];
                int i72 = calculateGlViewSizeDynamic2[2];
                if (AbstractConfigActivity.t == i2 || AbstractConfigActivity.u != i72) {
                    EditorActivity.this.k1 = true;
                    EditorActivity.this.D1.sendEmptyMessage(45);
                    EditorActivity.this.d1();
                    return;
                }
                if (((AbstractConfigActivity) EditorActivity.this).f8721n != null && ((AbstractConfigActivity) EditorActivity.this).f8721n.h0()) {
                    ((AbstractConfigActivity) EditorActivity.this).f8721n.j0();
                }
                EditorActivity.this.l1 = true;
                if (((AbstractConfigActivity) EditorActivity.this).f8721n != null) {
                    ((AbstractConfigActivity) EditorActivity.this).f8721n.L0(0.0f);
                }
                EditorActivity.this.D1.sendEmptyMessage(47);
                EditorActivity.this.d1();
                org.greenrobot.eventbus.c.c().l(new com.xvideostudio.videoeditor.d0.m());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class h implements View.OnClickListener {
        h() {
        }

        public void onClick(View view) {
            if (((AbstractConfigActivity) EditorActivity.this).f8721n != null) {
                m1.a(EditorActivity.this.C, "EDITOR_ACTIVITY_CLICK_TIME_BATCH_EDITOR");
                if (((AbstractConfigActivity) EditorActivity.this).f8721n.h0()) {
                    EditorActivity editorActivity = EditorActivity.this;
                    editorActivity.s8(((AbstractConfigActivity) editorActivity).f8721n.h0(), true);
                }
                EditorActivity.this.n8();
            }
        }
    }

    public class h0 implements com.xvideostudio.videoeditor.m0.a {
        public h0() {
        }

        @Override // com.xvideostudio.videoeditor.m0.a
        public void U(com.xvideostudio.videoeditor.m0.b bVar) {
            switch (bVar.a()) {
                case 6:
                case 7:
                case 8:
                case 9:
                    EditorActivity.this.W7();
                    return;
                default:
                    return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class i implements View.OnClickListener {

        class a implements Runnable {
            a() {
            }

            public void run() {
                EditorActivity.this.i0.setEnabled(true);
            }
        }

        class b implements Runnable {
            b() {
            }

            public void run() {
                if (!EditorActivity.this.isFinishing() && EditorActivity.this.R0) {
                    EditorActivity editorActivity = EditorActivity.this;
                    com.xvideostudio.videoeditor.tool.v.n(editorActivity, editorActivity.i0, 2131820714, 0, 10, 3);
                }
            }
        }

        class c extends AsyncTask<Void, Void, Void> {
            c() {
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public Void doInBackground(Void... voidArr) {
                ((AbstractConfigActivity) EditorActivity.this).f8722o.a0(EditorActivity.this.f8720m);
                return null;
            }

            /* access modifiers changed from: protected */
            /* renamed from: b */
            public void onPostExecute(Void r3) {
                EditorActivity editorActivity = EditorActivity.this;
                editorActivity.s8(((AbstractConfigActivity) editorActivity).f8721n.h0(), false);
            }
        }

        i() {
        }

        public void onClick(View view) {
            if (((AbstractConfigActivity) EditorActivity.this).f8721n != null) {
                m1.a(EditorActivity.this.C, "CLICK_EDITOR_SCREEN_CANCEL_SOUND");
                EditorActivity.this.i0.setEnabled(false);
                EditorActivity.this.i0.postDelayed(new a(), 1000);
                if (!EditorActivity.this.i0.isSelected() && com.xvideostudio.videoeditor.tool.w.j(EditorActivity.this)) {
                    EditorActivity.this.n0.postDelayed(new b(), (long) EditorActivity.this.getResources().getInteger(2131361831));
                }
                if (((AbstractConfigActivity) EditorActivity.this).f8721n.h0()) {
                    ((AbstractConfigActivity) EditorActivity.this).f8721n.j0();
                }
                ((AbstractConfigActivity) EditorActivity.this).f8721n.L0(0.0f);
                MediaDatabase mediaDatabase = EditorActivity.this.f8720m;
                if (mediaDatabase != null) {
                    ArrayList<SoundEntity> soundList = mediaDatabase.getSoundList();
                    if (soundList != null && soundList.size() > 0) {
                        int i2 = soundList.get(0).volume;
                        if (i2 != 0) {
                            EditorActivity.this.j0 = i2;
                        }
                        for (int i3 = 0; i3 < soundList.size(); i3++) {
                            SoundEntity soundEntity = soundList.get(i3);
                            if (!EditorActivity.this.i0.isSelected()) {
                                soundEntity.volume = 0;
                            } else {
                                soundEntity.volume = EditorActivity.this.j0;
                            }
                        }
                    }
                    ArrayList<SoundEntity> voiceList = EditorActivity.this.f8720m.getVoiceList();
                    if (!(voiceList == null || voiceList.size() <= 0 || soundList == null)) {
                        int i4 = soundList.get(0).volume;
                        if (i4 != 0) {
                            EditorActivity.this.j0 = i4;
                        }
                        for (int i5 = 0; i5 < voiceList.size(); i5++) {
                            SoundEntity soundEntity2 = voiceList.get(i5);
                            if (!EditorActivity.this.i0.isSelected()) {
                                soundEntity2.volume = 0;
                            } else {
                                soundEntity2.volume = EditorActivity.this.j0;
                            }
                        }
                    }
                }
                EditorActivity editorActivity = EditorActivity.this;
                editorActivity.g8(!editorActivity.i0.isSelected(), true);
                new c().execute(new Void[0]);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class j implements View.OnClickListener {

        class a implements Runnable {
            a() {
            }

            public void run() {
                EditorActivity.this.f0.setEnabled(true);
                EditorActivity.this.g0.setEnabled(true);
            }
        }

        j() {
        }

        public void onClick(View view) {
            if (((AbstractConfigActivity) EditorActivity.this).f8721n != null) {
                EditorActivity.this.l1 = false;
                EditorActivity.this.m1 = false;
                EditorActivity.this.e0.setVisibility(8);
                EditorActivity.this.f0.setEnabled(false);
                EditorActivity.this.g0.setEnabled(false);
                EditorActivity editorActivity = EditorActivity.this;
                editorActivity.s8(((AbstractConfigActivity) editorActivity).f8721n.h0(), true);
                EditorActivity editorActivity2 = EditorActivity.this;
                editorActivity2.D1.postDelayed(new a(), (long) editorActivity2.getResources().getInteger(2131361806));
            }
        }
    }

    static class k extends HashSet<Integer> {
        k() {
            add(Integer.valueOf((int) C1523R$drawable.ic_proeditor_scrolltext));
            add(Integer.valueOf((int) C1523R$drawable.ic_proeditor_pixelate));
            add(Integer.valueOf((int) C1523R$drawable.ic_proeditor_watermark));
        }
    }

    /* access modifiers changed from: package-private */
    public class l implements TabLayout.OnTabSelectedListener {
        l() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            int i2 = 0;
            EditorActivity.this.m1 = false;
            EditorActivity.this.Z7();
            EditorActivity.this.a8(tab.getPosition());
            int position = tab.getPosition();
            if (position == 0) {
                EditorActivity.this.b8(0, true);
                com.xvideostudio.videoeditor.x0.p2.b.a(0, "EDIT_THEME", null);
                m1.a(EditorActivity.this.C, "CLICK_EDITOR_SCREEN_THEME");
            } else if (position == 1) {
                View customView = tab.getCustomView();
                Objects.requireNonNull(customView);
                View findViewById = customView.findViewById(C1524R$id.new_tip);
                if (findViewById.getVisibility() == 0) {
                    findViewById.setVisibility(8);
                    com.xvideostudio.videoeditor.u.I1(EditorActivity.this.C, false);
                }
                com.xvideostudio.videoeditor.x0.p2.b.a(0, "EDIT_MUSIC", null);
                EditorActivity.this.b8(12, true);
                i2 = 1;
            } else if (position == 2) {
                EditorActivity.this.b8(3, true);
                m1.a(EditorActivity.this.C, "CLICK_EDITOR_SCREEN_ADVACNE");
                i2 = 2;
            }
            EditorActivity.this.Z0 = i2;
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }

    /* access modifiers changed from: package-private */
    public class m implements AdapterView.OnItemClickListener {
        m() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            EditorActivity.this.L7(i2);
        }
    }

    class n implements View.OnClickListener {
        n() {
        }

        public void onClick(View view) {
            if (((AbstractConfigActivity) EditorActivity.this).f8721n != null) {
                EditorActivity editorActivity = EditorActivity.this;
                if (editorActivity.f8720m != null && !editorActivity.G6()) {
                    if (((AbstractConfigActivity) EditorActivity.this).f8721n.h0()) {
                        EditorActivity editorActivity2 = EditorActivity.this;
                        editorActivity2.s8(((AbstractConfigActivity) editorActivity2).f8721n.h0(), true);
                    }
                    com.xvideostudio.videoeditor.x0.p2.b.a(0, "EDIT_CLICK_EXPORT", null);
                    if (EditorActivity.this.f8720m.hasAudio()) {
                        m1.a(EditorActivity.this, "EXPORT_HAD_AUDIO");
                    }
                    EditorActivity editorActivity3 = EditorActivity.this;
                    editorActivity3.H0 = com.xvideostudio.videoeditor.tool.w.v(editorActivity3.C, 0);
                    EditorActivity.this.d1();
                    com.xvideostudio.videoeditor.x0.p2.b.c(l2.c(EditorActivity.this).booleanValue() ? "EXPORT_WITH_WATERMARK" : "EXPORT_NO_WATERMARK", null, null, null);
                    EditorActivity.this.s6();
                }
            }
        }
    }

    class o implements DialogInterface.OnClickListener {
        o(EditorActivity editorActivity) {
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            com.xvideostudio.videoeditor.b0.j.r(true);
            if (i2 == 0) {
                com.xvideostudio.videoeditor.b0.j.s(true);
            } else {
                com.xvideostudio.videoeditor.b0.j.s(false);
            }
            dialogInterface.dismiss();
        }
    }

    /* access modifiers changed from: package-private */
    public class p extends RecyclerView.n {
        int a;

        p() {
            this.a = com.xvideostudio.videoeditor.tool.h.a(EditorActivity.this.C, 16.0f);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.n
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.z zVar) {
            com.xvideostudio.videoeditor.adapter.c3.a.a(rect, view, recyclerView, zVar, this.a);
        }
    }

    /* access modifiers changed from: package-private */
    public class q implements EditorAOneAdapter.d {
        q() {
        }

        @Override // com.xvideostudio.videoeditor.adapter.EditorAOneAdapter.d
        public void a(View view, int i2) {
            EditorActivity.this.M7(view, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public class r implements EditorAOneAdapter.d {
        r() {
        }

        @Override // com.xvideostudio.videoeditor.adapter.EditorAOneAdapter.d
        public void a(View view, int i2) {
            SimpleInf simpleInf = EditorActivity.this.z0.p().get(i2);
            EditorActivity.this.q1 = i2;
            EditorActivity.this.t1 = -1;
            if (EditorActivity.this.z0.q() != i2) {
                EditorActivity.this.N7(simpleInf, i2);
                EditorActivity.this.z0.F(EditorActivity.this.q1);
                EditorActivity.this.A0.F(EditorActivity.this.p1);
                return;
            }
            EditorActivity.this.p6(simpleInf, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public class s extends RecyclerView.n {
        int a;

        s() {
            this.a = com.xvideostudio.videoeditor.tool.h.a(EditorActivity.this.C, 10.0f);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.n
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.z zVar) {
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            int z = androidx.core.i.u.z(recyclerView);
            if (recyclerView.getAdapter() != null) {
                if (z == 1) {
                    if (childAdapterPosition == 0) {
                        rect.set(0, 0, this.a, 0);
                    } else if (childAdapterPosition == recyclerView.getAdapter().getItemCount() - 1) {
                        rect.set(this.a, 0, 0, 0);
                    } else {
                        rect.set(0, 0, 0, 0);
                    }
                } else if (childAdapterPosition == 0) {
                    rect.set(this.a, 0, 0, 0);
                } else if (childAdapterPosition == recyclerView.getAdapter().getItemCount() - 1) {
                    rect.set(0, 0, this.a, 0);
                } else {
                    rect.set(0, 0, 0, 0);
                }
            }
        }
    }

    class t extends TypeToken<ArrayList<SimpleInf>> {
        t(EditorActivity editorActivity) {
        }
    }

    /* access modifiers changed from: package-private */
    public class u implements Runnable {
        u() {
        }

        public void run() {
            EditorActivity.this.a0 = true;
            try {
                Thread.sleep(2000);
                EditorActivity.this.a0 = false;
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    static class v extends HashMap<Integer, String> {
        v() {
            put(Integer.valueOf((int) C1523R$drawable.ic_proeditor_scrolltext), "set_new_scroll_text_v2_tip_flag");
            put(Integer.valueOf((int) C1523R$drawable.ic_proeditor_watermark), "new_custom_watermark_tip_flag");
        }
    }

    /* access modifiers changed from: package-private */
    public class w implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ RadioGroup f7941f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ int f7942g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ int f7943h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ TextView f7944i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ String f7945j;

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ String f7946k;

        w(RadioGroup radioGroup, int i2, int i3, TextView textView, String str, String str2) {
            this.f7941f = radioGroup;
            this.f7942g = i2;
            this.f7943h = i3;
            this.f7944i = textView;
            this.f7945j = str;
            this.f7946k = str2;
        }

        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            if (i2 == 0) {
                i2 = 1;
            }
            EditorActivity.this.E1 = i2;
            EditorActivity editorActivity = EditorActivity.this;
            editorActivity.G1 = (editorActivity.E1 * 1000) / 10;
            int i3 = (this.f7942g * EditorActivity.this.G1) + EditorActivity.this.H1 + this.f7943h;
            TextView textView = this.f7944i;
            textView.setText(this.f7945j + SystemUtility.getTimeMinSecFormt(i3) + " / " + z0.d(((float) EditorActivity.this.G1) / 1000.0f) + this.f7946k);
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            this.f7941f.check(C1524R$id.rb_0);
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    /* access modifiers changed from: package-private */
    public class x implements View.OnClickListener {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ FxThemeU3DEffectEntity f7948f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ boolean f7949g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ FxThemeU3DEffectEntity f7950h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ boolean f7951i;

        x(FxThemeU3DEffectEntity fxThemeU3DEffectEntity, boolean z, FxThemeU3DEffectEntity fxThemeU3DEffectEntity2, boolean z2) {
            this.f7948f = fxThemeU3DEffectEntity;
            this.f7949g = z;
            this.f7950h = fxThemeU3DEffectEntity2;
            this.f7951i = z2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x0081  */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x00e4  */
        public void onClick(View view) {
            boolean z;
            boolean z2;
            EditorActivity editorActivity = EditorActivity.this;
            if (editorActivity.f8720m != null && ((AbstractConfigActivity) editorActivity).f8721n != null) {
                Object[] objArr = (Object[]) view.getTag();
                if (this.f7948f != null) {
                    boolean booleanValue = ((Boolean) objArr[2]).booleanValue();
                    if (this.f7949g != booleanValue) {
                        MediaDatabase mediaDatabase = EditorActivity.this.f8720m;
                        if (!(mediaDatabase == null || mediaDatabase.getFxThemeU3DEntity() == null)) {
                            EditorActivity.this.f8720m.getFxThemeU3DEntity().clipStartFlag = booleanValue;
                        }
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    String obj = objArr[0].toString();
                    if (!obj.equals(this.f7948f.textTitle)) {
                        this.f7948f.textTitle = obj;
                        if (EditorActivity.this.f8720m.getFxThemeU3DEntity() != null) {
                            com.xvideostudio.videoeditor.s0.a.g(EditorActivity.this.f8720m.getFxThemeU3DEntity().u3dThemePath, this.f7948f);
                        }
                        EditorActivity.this.f8720m.themeTitle = obj;
                        com.xvideostudio.videoeditor.x0.p2.b.a(0, "THEME_MODIFY_PROLOGUE_CHANGE", null);
                        z = true;
                        if (this.f7950h != null) {
                            boolean booleanValue2 = ((Boolean) objArr[3]).booleanValue();
                            if (this.f7951i != booleanValue2) {
                                if (EditorActivity.this.f8720m.getFxThemeU3DEntity() != null) {
                                    EditorActivity.this.f8720m.getFxThemeU3DEntity().clipEndFlag = booleanValue2;
                                }
                                z2 = true;
                            }
                            String obj2 = objArr[1].toString();
                            if (!obj2.equals(this.f7950h.textTitle)) {
                                this.f7950h.textTitle = obj2;
                                MediaDatabase mediaDatabase2 = EditorActivity.this.f8720m;
                                if (mediaDatabase2 != null) {
                                    if (mediaDatabase2.getFxThemeU3DEntity() != null) {
                                        com.xvideostudio.videoeditor.s0.a.g(EditorActivity.this.f8720m.getFxThemeU3DEntity().u3dThemePath, this.f7950h);
                                    }
                                    EditorActivity.this.f8720m.themeTail = obj2;
                                }
                                com.xvideostudio.videoeditor.x0.p2.b.a(0, "THEME_MODIFY_EPILOGUE_CHANGE", null);
                                z = true;
                            }
                        }
                        if (!z || z2) {
                            if (z2) {
                                MediaDatabase mediaDatabase3 = EditorActivity.this.f8720m;
                                mediaDatabase3.initThemeU3DClipTitle(mediaDatabase3.getFxThemeU3DEntity(), z);
                            }
                            EditorActivity.this.l1 = true;
                            ((AbstractConfigActivity) EditorActivity.this).f8721n.L0(0.0f);
                            EditorActivity.this.D1.sendEmptyMessage(47);
                            m1.a(EditorActivity.this.C, "THEME_TITLE_CHANGED");
                        }
                        return;
                    }
                } else {
                    z2 = false;
                }
                z = false;
                if (this.f7950h != null) {
                }
                if (!z) {
                }
                if (z2) {
                }
                EditorActivity.this.l1 = true;
                ((AbstractConfigActivity) EditorActivity.this).f8721n.L0(0.0f);
                EditorActivity.this.D1.sendEmptyMessage(47);
                m1.a(EditorActivity.this.C, "THEME_TITLE_CHANGED");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class y implements CompoundButton.OnCheckedChangeListener {
        y() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            EditorActivity.this.R1 = z;
            if (z) {
                com.xvideostudio.videoeditor.x0.p2.b.a(0, "MUSIC_FADE_ON", null);
                m1.b(EditorActivity.this.C, "MUSIC_FADE_ON", "音乐淡入淡出开启");
                return;
            }
            com.xvideostudio.videoeditor.x0.p2.b.a(0, "MUSIC_FADE_OFF", null);
            m1.b(EditorActivity.this.C, "MUSIC_FADE_OFF", "音乐淡入淡出关闭");
        }
    }

    /* access modifiers changed from: package-private */
    public static /* synthetic */ class z {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|19|20|21|22|23|24|26) */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0064 */
        static {
            int[] iArr = new int[a.EnumC0228a.values().length];
            b = iArr;
            try {
                iArr[a.EnumC0228a.MUSIC_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[a.EnumC0228a.PIXELATE_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            b[a.EnumC0228a.WATERMARK_TYPE.ordinal()] = 3;
            b[a.EnumC0228a.REVERSE_TYPE.ordinal()] = 4;
            b[a.EnumC0228a.SCROOLTEXT_TYPE.ordinal()] = 5;
            try {
                b[a.EnumC0228a.DRAW_TYPE.ordinal()] = 6;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[BackgroundItem.Type.values().length];
            a = iArr2;
            iArr2[BackgroundItem.Type.COLOR.ordinal()] = 1;
            a[BackgroundItem.Type.COLOR_GRADIENT.ordinal()] = 2;
            a[BackgroundItem.Type.STICKER.ordinal()] = 3;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: A7 */
    public /* synthetic */ boolean B7(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
        if (i2 == 4 && keyEvent.getRepeatCount() == 0 && keyEvent.getAction() == 1) {
            t8();
        }
        return false;
    }

    private void B6() {
        RecyclerView recyclerView = (RecyclerView) findViewById(C1524R$id.rv_theme);
        this.t0 = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this.v1, 0, false));
        this.u0 = (RecyclerView) findViewById(C1524R$id.rv_music);
        this.v0 = (RelativeLayout) findViewById(C1524R$id.layout_rv_music);
        this.w0 = (ImageView) findViewById(C1524R$id.iv_music_back);
        this.u0.setLayoutManager(new LinearLayoutManager(this.v1, 0, false));
        RecyclerView recyclerView2 = (RecyclerView) findViewById(C1524R$id.rv_music_main);
        this.x0 = recyclerView2;
        recyclerView2.setLayoutManager(new LinearLayoutManager(this.v1, 0, false));
        this.B0 = (HorizontalListView) findViewById(C1524R$id.ln_editor_advance_cloud_eye);
        TabLayout tabLayout = (TabLayout) findViewById(C1524R$id.mTablayout);
        this.N1 = tabLayout;
        tabLayout.addTab(tabLayout.newTab());
        TabLayout tabLayout2 = this.N1;
        tabLayout2.addTab(tabLayout2.newTab());
        TabLayout tabLayout3 = this.N1;
        tabLayout3.addTab(tabLayout3.newTab());
        this.N1.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new l());
        this.w0.setOnClickListener(new a1(this));
        b8(0, true);
        this.B0.setOnItemClickListener(new m());
    }

    private void C6() {
        Dialog P2 = com.xvideostudio.videoeditor.x0.e0.P(this.C);
        SwitchCompat switchCompat = (SwitchCompat) P2.findViewById(C1524R$id.sb_setting_music_fade);
        boolean v2 = com.xvideostudio.videoeditor.u.v(this.C);
        this.R1 = v2;
        switchCompat.setChecked(v2);
        switchCompat.setOnCheckedChangeListener(new y());
        ((Button) P2.findViewById(C1524R$id.bt_dialog_ok)).setOnClickListener(new j1(this, P2));
        P2.show();
    }

    static /* synthetic */ void C7(View view) {
    }

    private void D6() {
        this.U0 = (SeekVolume) findViewById(C1524R$id.volumeSeekBar);
        this.V0 = (SeekVolume) findViewById(C1524R$id.musicSeekBar);
        this.U0.n(SeekVolume.f11323n, new e0());
        this.V0.n(SeekVolume.f11325p, new f0());
    }

    /* access modifiers changed from: private */
    /* renamed from: D7 */
    public /* synthetic */ void E7(int i2) {
        this.C0 = i2;
        if (i2 >= 0 && this.f8720m.videoModeSelect != i2) {
            if (i2 == 0) {
                m1.a(this.C, "CLICK_VIDEO_SETTING_MODE_DEFAULT");
            } else if (i2 == 1) {
                m1.a(this.C, "CLICK_VIDEO_SETTING_MODE_WIDESCREEN_16_9");
            } else if (i2 == 2) {
                m1.a(this.C, "CLICK_VIDEO_SETTING_MODE_WIDESCREEN_4_3");
            } else if (i2 == 3) {
                m1.a(this.C, "CLICK_VIDEO_SETTING_MODE_SQUARE_1_1");
            } else if (i2 == 4) {
                m1.a(this.C, "CLICK_VIDEO_SETTING_MODE_VERTICAL_3_4");
            } else if (i2 == 5) {
                m1.a(this.C, "CLICK_VIDEO_SETTING_MODE_VERTICAL_9_16");
            }
            k6();
            this.f8720m.videoModeSelect = this.C0;
            d1();
        }
    }

    private void E6() {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.C).inflate(C1527R$layout.popup_select_clips_editor, (ViewGroup) null);
        PopupWindow popupWindow = new PopupWindow((View) linearLayout, getResources().getDimensionPixelSize(2131166609), getResources().getDimensionPixelSize(2131166608), true);
        this.N0 = popupWindow;
        popupWindow.setAnimationStyle(C1533R$style.select_clips_menu_animation);
        this.N0.setFocusable(true);
        this.N0.setTouchable(true);
        this.N0.setOutsideTouchable(true);
        this.N0.setBackgroundDrawable(new ColorDrawable(0));
        k1 k1Var = new k1(this);
        ((RelativeLayout) linearLayout.findViewById(C1524R$id.rl_paint_clips_editor)).setOnClickListener(k1Var);
        ((RelativeLayout) linearLayout.findViewById(C1524R$id.rl_select_clips_editor)).setOnClickListener(k1Var);
    }

    /* access modifiers changed from: private */
    /* renamed from: F7 */
    public /* synthetic */ void G7(int i2, int i3, TextView textView, String str, String str2, SeekBar seekBar, RadioGroup radioGroup, int i4) {
        switch (i4) {
            case C1524R$id.rb_0:
                this.F1 = 0;
                int i5 = (i2 * this.G1) + this.H1 + i3;
                textView.setText(str + SystemUtility.getTimeMinSecFormt(i5) + " / " + z0.d(((float) this.G1) / 1000.0f) + str2);
                seekBar.setProgress((int) ((((float) this.G1) / 1000.0f) * 10.0f));
                return;
            case C1524R$id.rb_1:
                this.F1 = 1;
                int i6 = this.H1;
                int i7 = ((15000 - i6) - i3) / i2;
                this.G1 = i7;
                if (i6 > 0 && i7 < 1000) {
                    this.G1 = 15000 / i2;
                }
                textView.setText(str + SystemUtility.getTimeMinSecFormt(15000) + " / " + z0.d(((float) this.G1) / 1000.0f) + str2);
                seekBar.setProgress((int) ((((float) this.G1) / 1000.0f) * 10.0f));
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: H6 */
    public /* synthetic */ void I6(int i2) {
        MediaDatabase mediaDatabase;
        j6(i2);
        if (this.f8721n != null && (mediaDatabase = this.f8720m) != null) {
            int[] calculateGlViewSizeDynamic = mediaDatabase.calculateGlViewSizeDynamic(mediaDatabase, AbstractConfigActivity.t, AbstractConfigActivity.u, AbstractConfigActivity.r);
            int i3 = calculateGlViewSizeDynamic[1];
            int i4 = calculateGlViewSizeDynamic[2];
            if (AbstractConfigActivity.t == i3 && AbstractConfigActivity.u == i4) {
                if (this.f8721n.h0()) {
                    this.f8721n.j0();
                }
                this.l1 = true;
                this.f8721n.L0(0.0f);
                this.D1.sendEmptyMessage(47);
                d1();
                return;
            }
            this.k1 = true;
            this.D1.sendEmptyMessage(45);
            d1();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: H7 */
    public /* synthetic */ void I7(int i2, int i3, com.xvideostudio.videoeditor.tool.f fVar, View view) {
        int i4;
        boolean z2 = false;
        if (this.F1 == 0) {
            i4 = (i2 * this.G1) + this.H1 + i3;
            m1.a(this.C, "EDITOR_ACTIVITY_CLICK_TIME_BATCH_DEFINED");
        } else {
            int i5 = this.H1;
            int i6 = ((15000 - i5) - i3) / i2;
            this.G1 = i6;
            if (i5 > 0 && i6 < 1000) {
                this.G1 = 15000 / i2;
                z2 = true;
            }
            m1.a(this.C, "EDITOR_ACTIVITY_CLICK_TIME_BATCH_INSTAGRAM");
            i4 = 15000;
        }
        w8(this.G1, i4, this.F1, z2);
        this.f8720m.durationBatchType = this.F1;
        fVar.dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: J6 */
    public /* synthetic */ void K6(int i2) {
        EditorAOneAdapter editorAOneAdapter = this.y0;
        if (editorAOneAdapter != null) {
            editorAOneAdapter.E(i2);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean K7(FxThemeU3DEntity fxThemeU3DEntity) {
        if (fxThemeU3DEntity == null || fxThemeU3DEntity.fxThemeId <= 1) {
            return false;
        }
        float f2 = ((float) AbstractConfigActivity.t) / ((float) AbstractConfigActivity.u);
        MediaDatabase mediaDatabase = this.f8720m;
        if (mediaDatabase == null) {
            return false;
        }
        if (f2 < 0.64285713f) {
            if (mediaDatabase.getIsThemeSupportSize2(5, fxThemeU3DEntity) || this.f8720m.getIsThemeSupportSize2(4, fxThemeU3DEntity) || !this.f8720m.getIsThemeSupportSize2(3, fxThemeU3DEntity)) {
                return false;
            }
            return true;
        } else if (f2 >= 0.9f || mediaDatabase.getIsThemeSupportSize2(4, fxThemeU3DEntity) || !this.f8720m.getIsThemeSupportSize2(3, fxThemeU3DEntity)) {
            return false;
        } else {
            return true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: L6 */
    public /* synthetic */ void M6(View view) {
        com.xvideostudio.videoeditor.b1.a.d(this.C, "export_5_min", true);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void L7(int i2) {
        boolean z2;
        boolean z3;
        if (this.f8721n != null && this.f8722o != null) {
            if (this.S0) {
                int i3 = this.f1;
                if (i3 > 2) {
                    this.S0 = false;
                }
                this.f1 = i3 + 1;
                return;
            }
            this.f1 = 0;
            q0 q0Var = this.D0;
            if (q0Var != null) {
                q0Var.h(i2);
            }
            try {
                JSONObject jSONObject = new JSONObject();
                switch (this.D0.getItem(i2).getId()) {
                    case 0:
                        com.xvideostudio.videoeditor.x0.p2.b.a(0, "EDIT_TRIM", null);
                        jSONObject.put("功能", "片段编辑");
                        this.l0 = true;
                        y4.b = false;
                        Intent intent = new Intent(this.C, EditorClipActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable(MediaDatabase.SERIALIZABLE_EXTRA, this.f8720m);
                        float H2 = this.f8721n.H();
                        intent.putExtra("editorRenderTime", H2);
                        intent.putExtra("editorClipIndex", this.f8722o.e(H2));
                        intent.putExtra("glWidthEditor", this.H);
                        intent.putExtra("glHeightEditor", this.I);
                        intent.putExtra("load_type", this.E0);
                        intent.putExtra("startType", "tab_pro_edit");
                        intent.putExtra("editor_clip_fun", 1);
                        intent.putExtras(bundle);
                        startActivityForResult(intent, 10);
                        return;
                    case 1:
                        com.xvideostudio.videoeditor.x0.p2.b.a(0, "EDIT_MULTIMUSIC", null);
                        jSONObject.put("功能", "配乐");
                        m1.a(this, "CLICK_EDITOR_SCREEN_BG_MUSIC");
                        this.l0 = true;
                        y4.b = false;
                        Intent intent2 = new Intent(this.C, ConfigMusicActivity.class);
                        Bundle bundle2 = new Bundle();
                        bundle2.putSerializable(MediaDatabase.SERIALIZABLE_EXTRA, this.f8720m);
                        intent2.putExtra("load_type", this.E0);
                        intent2.putExtra("volume", 50);
                        intent2.putExtra("musicset_voice", 50);
                        float H3 = this.f8721n.H();
                        intent2.putExtra("editorRenderTime", H3);
                        intent2.putExtra("editorClipIndex", this.f8722o.e(H3));
                        intent2.putExtra("glWidthEditor", this.H);
                        intent2.putExtra("glHeightEditor", this.I);
                        intent2.putExtras(bundle2);
                        startActivityForResult(intent2, 2);
                        return;
                    case 2:
                        com.xvideostudio.videoeditor.x0.p2.b.a(0, "EDIT_TEXT", null);
                        jSONObject.put("功能", "字幕");
                        m1.a(this, "CLICK_EDITOR_SCREEN_TEXT");
                        if (com.xvideostudio.videoeditor.tool.w.I(this.C)) {
                            z2 = false;
                            com.xvideostudio.videoeditor.tool.w.c1(this.C, false);
                        } else {
                            z2 = false;
                        }
                        this.l0 = true;
                        y4.b = z2;
                        Intent intent3 = new Intent(this.C, ConfigTextActivity.class);
                        Bundle bundle3 = new Bundle();
                        bundle3.putSerializable(MediaDatabase.SERIALIZABLE_EXTRA, this.f8720m);
                        float H4 = this.f8721n.H();
                        intent3.putExtra("editorRenderTime", H4);
                        intent3.putExtra("editorClipIndex", this.f8722o.e(H4));
                        intent3.putExtra("glWidthEditor", this.H);
                        intent3.putExtra("glHeightEditor", this.I);
                        intent3.putExtra("editor_type", "editor_video_activity");
                        intent3.putExtras(bundle3);
                        startActivityForResult(intent3, 2);
                        return;
                    case 3:
                        com.xvideostudio.videoeditor.x0.p2.b.a(0, "EDIT_RATIO", null);
                        l8();
                        return;
                    case 4:
                        com.xvideostudio.videoeditor.x0.p2.b.a(0, "EDIT_BACKGROUND", null);
                        m1.a(this.C, "CLICK_VIDEO_SETTING_BACKGROUND");
                        this.l0 = true;
                        y4.b = false;
                        Intent intent4 = new Intent(this.C, ConfigBackgroundActivity.class);
                        Bundle bundle4 = new Bundle();
                        bundle4.putSerializable(MediaDatabase.SERIALIZABLE_EXTRA, this.f8720m);
                        float H5 = this.f8721n.H();
                        intent4.putExtra("editorRenderTime", H5);
                        intent4.putExtra("editorClipIndex", this.f8722o.e(H5));
                        intent4.putExtra("glWidthEditor", this.H);
                        intent4.putExtra("glHeightEditor", this.I);
                        intent4.putExtras(bundle4);
                        startActivityForResult(intent4, 10);
                        return;
                    case 5:
                        com.xvideostudio.videoeditor.x0.p2.b.a(0, "EDIT_SCROLL", new Bundle());
                        q8();
                        return;
                    case 6:
                        jSONObject.put("功能", "特效");
                        com.xvideostudio.videoeditor.x0.p2.b.a(0, "EDIT_EFFECT", null);
                        m1.a(this, "CLICK_EDITOR_SCREEN_FX_SOUND");
                        this.l0 = true;
                        y4.b = false;
                        Intent intent5 = new Intent(this.C, ConfigFxActivity.class);
                        Bundle bundle5 = new Bundle();
                        bundle5.putSerializable(MediaDatabase.SERIALIZABLE_EXTRA, this.f8720m);
                        intent5.putExtra("volume", 50);
                        intent5.putExtra("musicset_voice", 50);
                        float H6 = this.f8721n.H();
                        intent5.putExtra("editorRenderTime", H6);
                        intent5.putExtra("editorClipIndex", this.f8722o.e(H6));
                        intent5.putExtra("glWidthEditor", this.H);
                        intent5.putExtra("glHeightEditor", this.I);
                        intent5.putExtras(bundle5);
                        startActivityForResult(intent5, 2);
                        h.a.x.e eVar = this.f8721n;
                        if (eVar != null) {
                            eVar.w0(1);
                            return;
                        }
                        return;
                    case 7:
                        com.xvideostudio.videoeditor.x0.p2.b.a(0, "EDIT_SPEED", null);
                        this.l0 = true;
                        y4.b = false;
                        Intent intent6 = new Intent(this.C, EditorClipActivity.class);
                        Bundle bundle6 = new Bundle();
                        bundle6.putSerializable(MediaDatabase.SERIALIZABLE_EXTRA, this.f8720m);
                        float H7 = this.f8721n.H();
                        intent6.putExtra("editorRenderTime", H7);
                        intent6.putExtra("editorClipIndex", this.f8722o.e(H7));
                        intent6.putExtra("glWidthEditor", this.H);
                        intent6.putExtra("glHeightEditor", this.I);
                        intent6.putExtra("load_type", this.E0);
                        intent6.putExtra("startType", "tab_pro_edit");
                        intent6.putExtra("editor_clip_fun", 5);
                        intent6.putExtras(bundle6);
                        startActivityForResult(intent6, 10);
                        return;
                    case 8:
                        com.xvideostudio.videoeditor.x0.p2.b.a(0, "EDIT_STICKER", null);
                        p8();
                        return;
                    case 9:
                        com.xvideostudio.videoeditor.x0.p2.b.a(0, "EDIT_TRANSTITION", null);
                        jSONObject.put("功能", "转场");
                        this.l0 = true;
                        y4.b = false;
                        Intent intent7 = new Intent(this.C, ConfigTransActivity.class);
                        Bundle bundle7 = new Bundle();
                        bundle7.putSerializable(MediaDatabase.SERIALIZABLE_EXTRA, this.f8720m);
                        float H8 = this.f8721n.H();
                        intent7.putExtra("editorRenderTime", H8);
                        intent7.putExtra("editorClipIndex", this.f8722o.e(H8));
                        intent7.putExtra("glWidthEditor", this.H);
                        intent7.putExtra("glHeightEditor", this.I);
                        intent7.putExtras(bundle7);
                        startActivityForResult(intent7, 10);
                        return;
                    case 10:
                        com.xvideostudio.videoeditor.x0.p2.b.a(0, "EDIT_FILTER", null);
                        jSONObject.put("功能", "滤镜");
                        this.l0 = true;
                        y4.b = false;
                        Intent intent8 = new Intent(this.C, ConfigFilterActivity.class);
                        Bundle bundle8 = new Bundle();
                        bundle8.putSerializable(MediaDatabase.SERIALIZABLE_EXTRA, this.f8720m);
                        float H9 = this.f8721n.H();
                        intent8.putExtra("editorRenderTime", H9);
                        intent8.putExtra("editorClipIndex", this.f8722o.e(H9));
                        intent8.putExtra("glWidthEditor", this.H);
                        intent8.putExtra("glHeightEditor", this.I);
                        intent8.putExtras(bundle8);
                        startActivityForResult(intent8, 10);
                        return;
                    case 11:
                        o8();
                        return;
                    case 12:
                        com.xvideostudio.videoeditor.x0.p2.b.a(0, "EDIT_SPLIT", null);
                        jSONObject.put("功能", "片段编辑");
                        this.l0 = true;
                        y4.b = false;
                        Intent intent9 = new Intent(this.C, EditorClipActivity.class);
                        Bundle bundle9 = new Bundle();
                        bundle9.putSerializable(MediaDatabase.SERIALIZABLE_EXTRA, this.f8720m);
                        float H10 = this.f8721n.H();
                        intent9.putExtra("editorRenderTime", H10);
                        intent9.putExtra("editorClipIndex", this.f8722o.e(H10));
                        intent9.putExtra("glWidthEditor", this.H);
                        intent9.putExtra("glHeightEditor", this.I);
                        intent9.putExtra("load_type", this.E0);
                        intent9.putExtra("startType", "tab_pro_edit");
                        intent9.putExtra("editor_clip_fun", 6);
                        intent9.putExtras(bundle9);
                        startActivityForResult(intent9, 10);
                        return;
                    case 13:
                        com.xvideostudio.videoeditor.x0.p2.b.a(0, "EDIT_MUSICFADE", null);
                        C6();
                        return;
                    case 14:
                        com.xvideostudio.videoeditor.x0.p2.b.a(0, "EDIT_SOUNDEFFECT", null);
                        jSONObject.put("功能", "音效");
                        this.l0 = true;
                        y4.b = false;
                        Intent intent10 = new Intent(this.C, ConfigSoundEffectActivity.class);
                        Bundle bundle10 = new Bundle();
                        bundle10.putSerializable(MediaDatabase.SERIALIZABLE_EXTRA, this.f8720m);
                        intent10.putExtra("volume", 50);
                        intent10.putExtra("musicset_voice", 50);
                        float H11 = this.f8721n.H();
                        intent10.putExtra("editorRenderTime", H11);
                        intent10.putExtra("editorClipIndex", this.f8722o.e(H11));
                        intent10.putExtra("glWidthEditor", this.H);
                        intent10.putExtra("glHeightEditor", this.I);
                        intent10.putExtras(bundle10);
                        startActivityForResult(intent10, 2);
                        h.a.x.e eVar2 = this.f8721n;
                        if (eVar2 != null) {
                            eVar2.w0(1);
                            return;
                        }
                        return;
                    case 15:
                        com.xvideostudio.videoeditor.x0.p2.b.a(0, "EDIT_ZOOM", null);
                        jSONObject.put("功能", "片段编辑");
                        this.l0 = true;
                        y4.b = false;
                        Intent intent11 = new Intent(this.C, EditorClipActivity.class);
                        Bundle bundle11 = new Bundle();
                        bundle11.putSerializable(MediaDatabase.SERIALIZABLE_EXTRA, this.f8720m);
                        float H12 = this.f8721n.H();
                        intent11.putExtra("editorRenderTime", H12);
                        intent11.putExtra("editorClipIndex", this.f8722o.e(H12));
                        intent11.putExtra("glWidthEditor", this.H);
                        intent11.putExtra("glHeightEditor", this.I);
                        intent11.putExtra("load_type", this.E0);
                        intent11.putExtra("startType", "tab_pro_edit");
                        intent11.putExtra("editor_clip_fun", 3);
                        intent11.putExtras(bundle11);
                        startActivityForResult(intent11, 10);
                        return;
                    case 16:
                        com.xvideostudio.videoeditor.x0.p2.b.a(0, "EDIT_DOODLE", null);
                        jSONObject.put("功能", "涂鸦");
                        this.l0 = true;
                        y4.b = false;
                        Intent intent12 = new Intent(this.C, ConfigDrawActivity.class);
                        Bundle bundle12 = new Bundle();
                        bundle12.putSerializable(MediaDatabase.SERIALIZABLE_EXTRA, this.f8720m);
                        intent12.putExtras(bundle12);
                        float H13 = this.f8721n.H();
                        intent12.putExtra("editorRenderTime", H13);
                        intent12.putExtra("editorClipIndex", this.f8722o.e(H13));
                        intent12.putExtra("glWidthEditor", this.H);
                        intent12.putExtra("glHeightEditor", this.I);
                        startActivityForResult(intent12, 2);
                        return;
                    case 17:
                        jSONObject.put("功能", "配音");
                        com.xvideostudio.videoeditor.x0.p2.b.a(0, "EDIT_VOICEOVER", null);
                        if (com.xvideostudio.videoeditor.tool.w.k0(this.C)) {
                            com.xvideostudio.videoeditor.tool.w.l1(this.C, false);
                        }
                        this.l0 = true;
                        y4.b = false;
                        Intent intent13 = new Intent(this.C, ConfigVoiceActivity.class);
                        Bundle bundle13 = new Bundle();
                        bundle13.putSerializable(MediaDatabase.SERIALIZABLE_EXTRA, this.f8720m);
                        intent13.putExtra("volume", 50);
                        intent13.putExtra("musicset_voice", 50);
                        float H14 = this.f8721n.H();
                        intent13.putExtra("editorRenderTime", H14);
                        intent13.putExtra("editorClipIndex", this.f8722o.e(H14));
                        intent13.putExtra("glWidthEditor", this.H);
                        intent13.putExtra("glHeightEditor", this.I);
                        intent13.putExtras(bundle13);
                        startActivityForResult(intent13, 2);
                        h.a.x.e eVar3 = this.f8721n;
                        if (eVar3 != null) {
                            eVar3.w0(1);
                            return;
                        }
                        return;
                    case 18:
                        com.xvideostudio.videoeditor.x0.p2.b.a(0, "EDIT_GIF", null);
                        this.l0 = true;
                        y4.b = false;
                        Intent intent14 = new Intent(this.C, ConfigGifActivity.class);
                        Bundle bundle14 = new Bundle();
                        bundle14.putSerializable(MediaDatabase.SERIALIZABLE_EXTRA, this.f8720m);
                        float H15 = this.f8721n.H();
                        intent14.putExtra("editorRenderTime", H15);
                        intent14.putExtra("editorClipIndex", this.f8722o.e(H15));
                        intent14.putExtra("glWidthEditor", this.H);
                        intent14.putExtra("glHeightEditor", this.I);
                        intent14.putExtras(bundle14);
                        startActivityForResult(intent14, 2);
                        return;
                    case 19:
                        com.xvideostudio.videoeditor.x0.p2.b.a(0, "EDIT_REVERSE", null);
                        this.l0 = true;
                        y4.b = false;
                        Intent intent15 = new Intent(this.C, EditorClipActivity.class);
                        Bundle bundle15 = new Bundle();
                        bundle15.putSerializable(MediaDatabase.SERIALIZABLE_EXTRA, this.f8720m);
                        float H16 = this.f8721n.H();
                        intent15.putExtra("editorRenderTime", H16);
                        intent15.putExtra("editorClipIndex", this.f8722o.e(H16));
                        intent15.putExtra("glWidthEditor", this.H);
                        intent15.putExtra("glHeightEditor", this.I);
                        intent15.putExtra("load_type", this.E0);
                        intent15.putExtra("startType", "tab_pro_edit");
                        intent15.putExtra("editor_clip_fun", 4);
                        intent15.putExtras(bundle15);
                        startActivityForResult(intent15, 10);
                        return;
                    case 20:
                        if (com.xvideostudio.videoeditor.u.N(this.C, "set_new_scroll_text_v2_tip_flag")) {
                            z3 = false;
                            com.xvideostudio.videoeditor.u.A2(this.C, "set_new_scroll_text_v2_tip_flag", false);
                        } else {
                            z3 = false;
                        }
                        int i4 = z3 ? 1 : 0;
                        int i5 = z3 ? 1 : 0;
                        int i6 = z3 ? 1 : 0;
                        com.xvideostudio.videoeditor.x0.p2.b.a(i4, "EDIT_WATERMARK", null);
                        this.l0 = true;
                        y4.b = z3;
                        Intent intent16 = new Intent(this.C, ConfigMarkActivity.class);
                        Bundle bundle16 = new Bundle();
                        bundle16.putSerializable(MediaDatabase.SERIALIZABLE_EXTRA, this.f8720m);
                        float H17 = this.f8721n.H();
                        intent16.putExtra("editorRenderTime", H17);
                        intent16.putExtra("editorClipIndex", this.f8722o.e(H17));
                        intent16.putExtra("glWidthEditor", this.H);
                        intent16.putExtra("glHeightEditor", this.I);
                        intent16.putExtras(bundle16);
                        startActivityForResult(intent16, 2);
                        return;
                    case 21:
                        com.xvideostudio.videoeditor.x0.p2.b.a(0, "EDIT_ROTATE", null);
                        jSONObject.put("功能", "片段编辑");
                        this.l0 = true;
                        y4.b = false;
                        Intent intent17 = new Intent(this.C, EditorClipActivity.class);
                        Bundle bundle17 = new Bundle();
                        bundle17.putSerializable(MediaDatabase.SERIALIZABLE_EXTRA, this.f8720m);
                        float H18 = this.f8721n.H();
                        intent17.putExtra("editorRenderTime", H18);
                        intent17.putExtra("editorClipIndex", this.f8722o.e(H18));
                        intent17.putExtra("glWidthEditor", this.H);
                        intent17.putExtra("glHeightEditor", this.I);
                        intent17.putExtra("load_type", this.E0);
                        intent17.putExtra("startType", "tab_pro_edit");
                        intent17.putExtra("editor_clip_fun", 2);
                        intent17.putExtras(bundle17);
                        startActivityForResult(intent17, 10);
                        return;
                    case 22:
                        jSONObject.put("功能", "排序");
                        r8();
                        return;
                    default:
                        return;
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void M7(View view, int i2) {
        if (this.f8721n != null && this.f8722o != null) {
            VideoEditorApplication.y();
            if (!VideoEditorApplication.Z()) {
                if (this.S0) {
                    int i3 = this.f1;
                    if (i3 > 2) {
                        this.S0 = false;
                    }
                    this.f1 = i3 + 1;
                    return;
                }
                this.f1 = 0;
                if (i2 == 1) {
                    com.xvideostudio.videoeditor.x0.p2.b.a(0, "THEME_STORE", null);
                    this.m0 = true;
                    Bundle bundle = new Bundle();
                    bundle.putInt("categoryIndex", 0);
                    bundle.putString("categoryTitle", getString(C1532R$string.style));
                    bundle.putBoolean("is_from_edit_page", true);
                    bundle.putInt("category_type", 1);
                    p4.f(this, bundle, 14);
                    m1.a(this.C, "CLICK_MATERIAL_THEME_DOWNLOAD_EDITOR");
                    return;
                }
                this.U = true;
                if (this.s0) {
                    this.s0 = false;
                }
                Object tag = ((EditorAOneAdapter.MyViewHolder) view.getTag()).image.getTag(2131297867);
                if (tag != null) {
                    SimpleInf simpleInf = (SimpleInf) tag;
                    int i4 = simpleInf.id;
                    if (simpleInf.isDown != 1) {
                        if (com.xvideostudio.videoeditor.l0.c.A(i4, 1).intValue() != 0) {
                            m1.a(this, com.xvideostudio.videoeditor.l0.c.N(i4, 3));
                        } else {
                            m1.a(this, "CLICK_EDITOR_SCREEN_3DTHEME_" + simpleInf.id);
                        }
                        try {
                            new JSONObject().put("主题", simpleInf.text);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        MediaDatabase mediaDatabase = this.f8720m;
                        if (mediaDatabase == null || this.s0 || mediaDatabase.getFxThemeU3DEntity() == null || this.f8720m.getFxThemeU3DEntity().fxThemeId != i4) {
                            this.T = false;
                            EditorAOneAdapter editorAOneAdapter = this.y0;
                            if (editorAOneAdapter != null) {
                                editorAOneAdapter.C(false);
                                this.y0.F(i2);
                            }
                            new com.xvideostudio.videoeditor.fragment.s().show(getSupportFragmentManager(), "");
                            com.xvideostudio.videoeditor.tool.a0.a(1).execute(new g0(i4, i2));
                        } else if (this.T) {
                            if (this.f8721n.h0()) {
                                s8(this.f8721n.h0(), true);
                            }
                            com.xvideostudio.videoeditor.x0.p2.b.a(0, "THEME_MODIFY", null);
                            e8();
                        } else if (!this.f8721n.h0()) {
                            s8(this.f8721n.h0(), true);
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: N6 */
    public /* synthetic */ void O6(View view) {
        ProPrivilegeAdHandle.getInstance().showAdmobVideoAd("export_5_min", this);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void N7(SimpleInf simpleInf, int i2) {
        boolean z2;
        String str;
        if (this.f8721n != null && this.f8722o != null) {
            this.z0.F(i2);
            String str2 = simpleInf.text + ".m4a";
            MediaDatabase mediaDatabase = this.f8720m;
            if (!(mediaDatabase == null || mediaDatabase.getSoundList() == null)) {
                this.f8720m.getSoundList().clear();
                this.f8720m.upCameraClipAudio();
            }
            if (!"".equals(str2)) {
                com.xvideostudio.videoeditor.x0.p2.b.a(0, "MUSIC_MATERIAL", null);
                String str3 = T1 + str2;
                if (!new File(str3).exists()) {
                    str = com.xvideostudio.videoeditor.l0.b.e0() + "/" + simpleInf.music_id + "material/music.m4a";
                } else {
                    str = str3;
                }
                MediaPlayer create = MediaPlayer.create(this, Uri.parse(str));
                if (create != null) {
                    if (this.j0 == 0) {
                        this.j0 = 50;
                    }
                    Boolean bool = Boolean.FALSE;
                    z2 = false;
                    SoundEntity createSoundEntity = SoundEntity.createSoundEntity(str2, str, bool, bool, "", 0, 0, create.getDuration(), create.getDuration(), true, this.j0);
                    createSoundEntity.gVideoStartTime = 0;
                    createSoundEntity.gVideoEndTime = (int) (this.f8722o.b().getMediaTotalTime() * 1000.0f);
                    createSoundEntity.index = i2;
                    this.f8720m.addSoundEntity(createSoundEntity);
                } else {
                    z2 = false;
                }
            } else {
                z2 = false;
                com.xvideostudio.videoeditor.x0.p2.b.a(0, "MUSIC_NONE", null);
            }
            com.xvideostudio.videoeditor.r rVar = this.f8722o;
            if (rVar != null) {
                rVar.U(this.f8720m);
            }
            e1();
            o6();
            if (this.f8721n.h0()) {
                this.f8721n.j0();
            }
            this.f8721n.L0(0.0f);
            this.l1 = true;
            s8(this.f8721n.h0(), z2);
            d1();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void O7(int i2) {
        int i3;
        if (this.f8721n != null && this.f8722o != null) {
            if (i2 == 0) {
                MediaDatabase mediaDatabase = this.f8720m;
                if (!(mediaDatabase == null || mediaDatabase.getSoundList() == null)) {
                    this.f8720m.getSoundList().clear();
                    this.f8720m.upCameraClipAudio();
                }
                this.f8722o.U(this.f8720m);
                if (this.f8721n.h0()) {
                    this.f8721n.j0();
                }
                this.f8721n.L0(0.0f);
                this.l1 = true;
                s8(this.f8721n.h0(), false);
                this.A0.F(0);
                this.z0.F(-1);
                this.p1 = 0;
                this.q1 = -1;
                this.s1 = 0;
                d1();
            } else if (i2 == 1) {
                if (!com.xvideostudio.videoeditor.tool.w.H(this.C)) {
                    com.xvideostudio.videoeditor.tool.w.A0(this.C, true);
                    this.z0.notifyDataSetChanged();
                }
                com.xvideostudio.videoeditor.x0.p2.b.a(0, "MUSIC_STORE", null);
                this.s1 = 0;
                this.l0 = true;
                y4.b = false;
                o6();
                Intent intent = new Intent(this.C, MusicStoreActivity.class);
                intent.putExtra("REQUEST_CODE", 12);
                intent.putExtra("RESULT_CODE", 12);
                intent.putExtra(MediaDatabase.SERIALIZABLE_EXTRA, this.f8720m);
                startActivityForResult(intent, 12);
            } else if (i2 == 2) {
                com.xvideostudio.videoeditor.x0.p2.b.a(0, "MUSIC_CLICK_VTM", null);
                this.s1 = 0;
                this.l0 = true;
                y4.b = false;
                o6();
                this.A0.n();
                Intent intent2 = new Intent(this.v1, MusicStoreActivity.class);
                intent2.putExtra("REQUEST_CODE", 12);
                intent2.putExtra("RESULT_CODE", 12);
                intent2.putExtra(MediaDatabase.SERIALIZABLE_EXTRA, this.f8720m);
                intent2.putExtra("video2audio", true);
                startActivityForResult(intent2, 12);
            } else {
                int i4 = this.o1;
                if (i2 > i4 + 2) {
                    String v02 = com.xvideostudio.videoeditor.u.v0(this.C);
                    if (!TextUtils.isEmpty(v02)) {
                        try {
                            ArrayList arrayList = new ArrayList();
                            JSONObject jSONObject = new JSONArray(v02).getJSONObject((i2 - 3) - this.o1);
                            String string = jSONObject.getString("materiallist");
                            HashMap hashMap = new HashMap();
                            int t6 = t6(jSONObject.getInt("id"));
                            if (t6 >= 0) {
                                for (int i5 = 0; i5 < a2.length; i5++) {
                                    SimpleInf simpleInf = new SimpleInf();
                                    simpleInf.id = W1[t6];
                                    simpleInf.music_id = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                                    simpleInf.isDown = 0;
                                    simpleInf.drawable = Z1[i5];
                                    simpleInf.text = a2[i5];
                                    simpleInf.isLocal = true;
                                    arrayList.add(simpleInf);
                                    hashMap.put(Integer.valueOf(simpleInf.music_id), simpleInf);
                                }
                            }
                            ArrayList arrayList2 = (ArrayList) new Gson().fromJson(com.xvideostudio.videoeditor.u.w0(this), new b(this).getType());
                            if (arrayList2 != null) {
                                i3 = 0;
                                for (int i6 = 0; i6 < arrayList2.size(); i6++) {
                                    if (((SimpleInf) arrayList2.get(i6)).id == jSONObject.getInt("id")) {
                                        arrayList.add(arrayList2.get(i6));
                                        i3++;
                                        hashMap.put(Integer.valueOf(((SimpleInf) arrayList2.get(i6)).getMaterial().getId()), arrayList2.get(i6));
                                    }
                                }
                            } else {
                                i3 = 0;
                            }
                            if (!TextUtils.isEmpty(string)) {
                                try {
                                    JSONArray jSONArray = new JSONArray(string);
                                    for (int i7 = 0; i7 < jSONArray.length(); i7++) {
                                        JSONObject jSONObject2 = jSONArray.getJSONObject(i7);
                                        int i8 = jSONObject2.getInt("id");
                                        SimpleInf simpleInf2 = new SimpleInf();
                                        if (!hashMap.containsKey(Integer.valueOf(i8))) {
                                            simpleInf2.id = i8;
                                            simpleInf2.music_id = jSONObject2.getString("id");
                                            simpleInf2.drawable = 0;
                                            simpleInf2.path = jSONObject2.getString("material_icon");
                                            simpleInf2.text = jSONObject2.getString("material_name");
                                            simpleInf2.verCode = jSONObject2.getInt("ver_code");
                                            simpleInf2.is_pro = jSONObject2.getInt("is_pro");
                                            simpleInf2.isLocal = false;
                                            simpleInf2.setDown_zip_url(jSONObject2.getString("down_zip_url"));
                                            String str = com.xvideostudio.videoeditor.l0.b.e0() + File.separator + simpleInf2.music_id + "material";
                                            File[] listFiles = new File(str).listFiles();
                                            if (listFiles == null || listFiles.length <= 0) {
                                                if (new File(str).exists()) {
                                                    VideoEditorApplication.y().o().a.b(simpleInf2.music_id);
                                                }
                                                simpleInf2.isDown = 1;
                                                Material material = new Material();
                                                material.setId(simpleInf2.id);
                                                material.setMaterial_name(simpleInf2.text);
                                                material.setMaterial_icon(simpleInf2.path);
                                                material.setMaterial_type(7);
                                                material.setMusic_id(simpleInf2.music_id);
                                                material.setIs_pro(simpleInf2.is_pro);
                                                material.setMaterial_pic(jSONObject2.getString("material_pic"));
                                                material.setDown_zip_url(simpleInf2.getDown_zip_url());
                                                simpleInf2.setMaterial(material);
                                                arrayList.add(simpleInf2);
                                            } else {
                                                simpleInf2.isDown = 0;
                                                Material material2 = new Material();
                                                material2.setId(simpleInf2.id);
                                                material2.setSave_path(listFiles[0].getAbsolutePath());
                                                simpleInf2.setMaterial(material2);
                                                arrayList.add(i3, simpleInf2);
                                            }
                                        }
                                    }
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                            this.v0.setVisibility(0);
                            this.x0.setVisibility(8);
                            this.z0.z(arrayList);
                            if (this.t1 > 0) {
                                for (int i9 = 0; i9 < this.z0.p().size(); i9++) {
                                    if (this.t1 == this.z0.p().get(i9).getMaterial().getId()) {
                                        this.q1 = i9;
                                        this.t1 = -1;
                                        this.D1.postDelayed(new c(), 50);
                                        return;
                                    }
                                }
                            }
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                } else if (i2 > 2 && i2 <= i4 + 2) {
                    int i10 = 0;
                    while (true) {
                        if (i10 >= W1.length) {
                            i10 = 0;
                            break;
                        } else if (this.A0.p().get(i2).id == W1[i10]) {
                            break;
                        } else {
                            i10++;
                        }
                    }
                    ArrayList arrayList3 = new ArrayList();
                    for (int i11 = 0; i11 < a2.length; i11++) {
                        SimpleInf simpleInf3 = new SimpleInf();
                        simpleInf3.drawable = Z1[i11];
                        simpleInf3.text = a2[i11];
                        simpleInf3.id = W1[i10];
                        simpleInf3.isLocal = true;
                        arrayList3.add(simpleInf3);
                    }
                    this.x0.setVisibility(8);
                    this.v0.setVisibility(0);
                    this.z0.z(arrayList3);
                }
            }
        }
    }

    static /* synthetic */ boolean P6(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
        return false;
    }

    private void P7() {
        if (com.xvideostudio.videoeditor.u.N(this.C, "set_new_scroll_text_v2_tip_flag")) {
            com.xvideostudio.videoeditor.u.A2(this.C, "set_new_scroll_text_v2_tip_flag", false);
        }
        com.xvideostudio.videoeditor.x0.p2.b.a(0, "EDIT_WATERMARK", null);
        this.l0 = true;
        y4.b = false;
        Intent intent = new Intent(this.C, ConfigMarkActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(MediaDatabase.SERIALIZABLE_EXTRA, this.f8720m);
        float f2 = 0.0f;
        h.a.x.e eVar = this.f8721n;
        if (eVar != null) {
            f2 = eVar.H();
        }
        intent.putExtra("editorRenderTime", f2);
        intent.putExtra("editorClipIndex", 0);
        intent.putExtra("glWidthEditor", this.H);
        intent.putExtra("glHeightEditor", this.I);
        intent.putExtras(bundle);
        startActivityForResult(intent, 2);
    }

    /* access modifiers changed from: private */
    /* renamed from: Q6 */
    public /* synthetic */ void R6(View view) {
        Boolean bool = Boolean.TRUE;
        Boolean bool2 = Boolean.FALSE;
        h.a.x.e eVar = this.f8721n;
        if (eVar != null) {
            if (eVar.h0()) {
                this.e0.setVerticalGravity(0);
                u8();
            }
            if (com.xvideostudio.videoeditor.u.d(this.C).booleanValue()) {
                org.greenrobot.eventbus.c.c().l(AdConfig.AD_REMOVE_WATER);
                com.xvideostudio.videoeditor.u.Q1(this.C, bool2);
                com.xvideostudio.videoeditor.u.R1(this.C, bool);
            } else if (com.xvideostudio.videoeditor.u.b(this.C).booleanValue()) {
                org.greenrobot.eventbus.c.c().l(AdConfig.AD_REMOVE_WATER);
                com.xvideostudio.videoeditor.u.O1(this.C, bool2);
                com.xvideostudio.videoeditor.u.P1(this.C, bool);
            } else if (com.xvideostudio.videoeditor.q.c("watermaker")) {
                com.xvideostudio.videoeditor.q.e("watermaker", false);
            } else {
                com.xvideostudio.videoeditor.x0.p2.b.c("WATERMARK_CLICK_IN_EDITOR", null, null, null);
                if (!com.xvideostudio.videoeditor.u.C0(this.C).booleanValue() || !ProPrivilegeAdHandle.getInstance().isAdSuccess()) {
                    com.xvideostudio.videoeditor.b1.a.c(this.C, "watermaker");
                } else {
                    com.xvideostudio.videoeditor.b0.j.t(this, new z0(this), new k0(this), m1.f8798f, "watermaker");
                }
            }
        }
    }

    private void Q7() {
        this.l0 = true;
        y4.b = false;
        Intent intent = new Intent(this.C, ConfigDrawActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(MediaDatabase.SERIALIZABLE_EXTRA, this.f8720m);
        intent.putExtras(bundle);
        h.a.x.e eVar = this.f8721n;
        intent.putExtra("editorRenderTime", eVar != null ? eVar.H() : 0.0f);
        intent.putExtra("editorClipIndex", 0);
        intent.putExtra("glWidthEditor", this.H);
        intent.putExtra("glHeightEditor", this.I);
        startActivityForResult(intent, 2);
    }

    private void R7() {
        com.xvideostudio.videoeditor.x0.p2.b.a(0, "EDIT_MUSICFADE", null);
        com.xvideostudio.videoeditor.u.J2(this.C, Boolean.TRUE);
        this.l0 = true;
        y4.b = false;
        Intent intent = new Intent(this.C, ConfigMosaicActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(MediaDatabase.SERIALIZABLE_EXTRA, this.f8720m);
        h.a.x.e eVar = this.f8721n;
        intent.putExtra("editorRenderTime", eVar != null ? eVar.H() : 0.0f);
        intent.putExtra("editorClipIndex", 0);
        intent.putExtra("glWidthEditor", this.H);
        intent.putExtra("glHeightEditor", this.I);
        intent.putExtras(bundle);
        startActivityForResult(intent, 2);
    }

    /* access modifiers changed from: private */
    /* renamed from: S6 */
    public /* synthetic */ void T6(View view) {
        this.x0.setVisibility(0);
        this.v0.setVisibility(8);
        this.s1 = 0;
    }

    private void S7() {
        this.m1 = false;
        Z7();
        a8(1);
        b8(12, true);
        com.xvideostudio.videoeditor.x0.p2.b.a(0, "EDIT_MUSIC", null);
    }

    private void T7() {
        com.xvideostudio.videoeditor.x0.p2.b.a(0, "EDIT_REVERSE", null);
        this.l0 = true;
        y4.b = false;
        Intent intent = new Intent(this.C, EditorClipActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(MediaDatabase.SERIALIZABLE_EXTRA, this.f8720m);
        h.a.x.e eVar = this.f8721n;
        intent.putExtra("editorRenderTime", eVar != null ? eVar.H() : 0.0f);
        intent.putExtra("editorClipIndex", 0);
        intent.putExtra("glWidthEditor", this.H);
        intent.putExtra("glHeightEditor", this.I);
        intent.putExtra("load_type", this.E0);
        intent.putExtra("startType", "tab_pro_edit");
        intent.putExtra("editor_clip_fun", 4);
        intent.putExtras(bundle);
        startActivityForResult(intent, 10);
    }

    /* access modifiers changed from: private */
    /* renamed from: U6 */
    public /* synthetic */ void V6(Dialog dialog, View view) {
        com.xvideostudio.videoeditor.x0.p2.b.a(0, "MUSIC_FADE_CONFIRM", null);
        if (this.R1 != com.xvideostudio.videoeditor.u.v(this.C)) {
            com.xvideostudio.videoeditor.u.k2(this.C, this.R1);
            n1(this.R1);
        }
        dialog.dismiss();
    }

    private void U7() {
        com.xvideostudio.videoeditor.x0.p2.b.a(0, "EDIT_SCROLL", new Bundle());
        if (com.xvideostudio.videoeditor.u.N(this.C, "set_new_scroll_text_v2_tip_flag")) {
            com.xvideostudio.videoeditor.u.A2(this.C, "set_new_scroll_text_v2_tip_flag", false);
        }
        this.l0 = true;
        y4.b = false;
        Intent intent = new Intent(this.C, ConfigScrollTextActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(MediaDatabase.SERIALIZABLE_EXTRA, this.f8720m);
        float f2 = 0.0f;
        h.a.x.e eVar = this.f8721n;
        if (eVar != null) {
            f2 = eVar.H();
        }
        intent.putExtra("editorRenderTime", f2);
        intent.putExtra("editorClipIndex", 0);
        intent.putExtra("glWidthEditor", this.H);
        intent.putExtra("glHeightEditor", this.I);
        intent.putExtra("editor_type", "SCROOLTEXT");
        intent.putExtras(bundle);
        startActivityForResult(intent, 2);
    }

    private void V7() {
        this.m1 = false;
        Z7();
        a8(0);
        b8(0, true);
        com.xvideostudio.videoeditor.x0.p2.b.a(0, "EDIT_THEME", null);
    }

    /* access modifiers changed from: private */
    /* renamed from: W6 */
    public /* synthetic */ void X6(View view) {
        int id = view.getId();
        if (id == 2131297648) {
            m1.a(this.C, "CLICK_EDITOR_ADD_NEW_BLANK_CLIPS");
            Intent intent = new Intent();
            intent.setClass(this.C, PaintNewClipActivity.class);
            intent.putExtra("type", "isFromEditorActivity");
            intent.putExtra("glWidthEditor", this.H);
            intent.putExtra("glHeightEditor", this.I);
            MediaDatabase mediaDatabase = this.f8720m;
            if (mediaDatabase != null) {
                intent.putExtra("clips_number", mediaDatabase.getClipArray().size());
            }
            startActivityForResult(intent, 5);
        } else if (id == 2131297659) {
            String str = z4.a;
            boolean z2 = true;
            if (str != null && !str.equals("image/video")) {
                z4.b = true;
            }
            Intent intent2 = new Intent();
            intent2.setClass(this, EditorChooseActivityTab.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable(MediaDatabase.SERIALIZABLE_EXTRA, this.f8720m);
            intent2.putExtra("type", "output");
            intent2.putExtra("load_type", "image/video");
            intent2.putExtra("bottom_show", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            MediaDatabase mediaDatabase2 = this.f8720m;
            if (mediaDatabase2 != null) {
                if (!mediaDatabase2.squareModeEnabled && mediaDatabase2.videoMode != 1) {
                    z2 = false;
                }
                intent2.putExtra("momentType", z2);
            }
            intent2.putExtra("editortype", "editor_video");
            intent2.putExtras(bundle);
            startActivityForResult(intent2, 4);
        }
        this.N0.dismiss();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void W7() {
        EditorAOneAdapter editorAOneAdapter = this.y0;
        if (editorAOneAdapter != null) {
            editorAOneAdapter.A(q6(0));
            MediaDatabase mediaDatabase = this.f8720m;
            if (mediaDatabase == null) {
                return;
            }
            if (mediaDatabase.getFxThemeU3DEntity() != null && this.f8720m.getFxThemeU3DEntity().fxThemeId > 0) {
                this.y0.E(this.f8720m.getFxThemeU3DEntity().fxThemeId);
            } else if (this.f8720m.getTitleEntity() == null || this.f8720m.getTitleEntity().fxThemeId != 1) {
                this.y0.F(1);
            } else {
                this.y0.E(1);
            }
        }
    }

    private void X7() {
        com.xvideostudio.videoeditor.m0.c.c().f(6, this.n1);
        com.xvideostudio.videoeditor.m0.c.c().f(7, this.n1);
        com.xvideostudio.videoeditor.m0.c.c().f(8, this.n1);
        com.xvideostudio.videoeditor.m0.c.c().f(9, this.n1);
    }

    /* access modifiers changed from: private */
    /* renamed from: Y6 */
    public /* synthetic */ boolean Z6(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.K1 = System.currentTimeMillis();
            return false;
        } else if (action != 1) {
            return false;
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            this.L1 = currentTimeMillis;
            if (currentTimeMillis - this.K1 <= 1000) {
                return false;
            }
            L7(Integer.parseInt(view.getTag().toString()));
            return false;
        }
    }

    private void Y7() {
        this.Z0 = 0;
        b8(0, true);
        TabLayout tabLayout = this.N1;
        if (tabLayout != null && tabLayout.getTabAt(0) != null) {
            this.N1.getTabAt(0).select();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void Z7() {
        TabLayout.Tab tabAt = this.N1.getTabAt(0);
        TabLayout.Tab tabAt2 = this.N1.getTabAt(1);
        TabLayout.Tab tabAt3 = this.N1.getTabAt(2);
        if (tabAt != null) {
            if (tabAt.getCustomView() == null) {
                tabAt.setCustomView(LayoutInflater.from(this).inflate(C1527R$layout.editor_bottom_tab_item_a_one, (ViewGroup) null));
            }
            TextView textView = (TextView) tabAt.getCustomView().findViewById(C1524R$id.tab_title);
            ((ImageView) tabAt.getCustomView().findViewById(C1524R$id.tab_icon)).setImageResource(C1523R$drawable.ic_maintab_style_n);
            textView.setText(C1532R$string.style);
            textView.setTextColor(getResources().getColor(C1521R$color.editor_bottom_panel_tab_text_normal_a_one));
        }
        if (tabAt2 != null) {
            if (tabAt2.getCustomView() == null) {
                View inflate = LayoutInflater.from(this).inflate(C1527R$layout.editor_bottom_tab_item_a_one, (ViewGroup) null);
                tabAt2.setCustomView(inflate);
                if (com.xvideostudio.videoeditor.u.C1()) {
                    inflate.findViewById(C1524R$id.new_tip).setVisibility(0);
                }
            }
            TextView textView2 = (TextView) tabAt2.getCustomView().findViewById(C1524R$id.tab_title);
            ((ImageView) tabAt2.getCustomView().findViewById(C1524R$id.tab_icon)).setImageResource(C1523R$drawable.ic_maintab_music_n);
            textView2.setText(2131822021);
            textView2.setTextColor(getResources().getColor(C1521R$color.editor_bottom_panel_tab_text_normal_a_one));
        }
        if (tabAt3 != null) {
            if (tabAt3.getCustomView() == null) {
                tabAt3.setCustomView(LayoutInflater.from(this).inflate(C1527R$layout.editor_bottom_tab_item_a_one, (ViewGroup) null));
            }
            TextView textView3 = (TextView) tabAt3.getCustomView().findViewById(C1524R$id.tab_title);
            ((ImageView) tabAt3.getCustomView().findViewById(C1524R$id.tab_icon)).setImageResource(C1523R$drawable.ic_maintab_edit_n);
            textView3.setText(2131821239);
            textView3.setTextColor(getResources().getColor(C1521R$color.editor_bottom_panel_tab_text_normal_a_one));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a7 */
    public /* synthetic */ void b7(View view) {
        com.xvideostudio.videoeditor.b1.a.d(this.C, "watermaker", true);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a8(int i2) {
        TabLayout.Tab tabAt;
        View customView;
        if (i2 >= 0 && i2 < 3 && (tabAt = this.N1.getTabAt(i2)) != null) {
            if (i2 == 0) {
                View customView2 = tabAt.getCustomView();
                if (customView2 != null) {
                    ((ImageView) customView2.findViewById(C1524R$id.tab_icon)).setImageResource(C1523R$drawable.ic_maintab_style_s);
                    ((TextView) customView2.findViewById(C1524R$id.tab_title)).setTextColor(getResources().getColor(2131099807));
                }
            } else if (i2 == 1) {
                View customView3 = tabAt.getCustomView();
                if (customView3 != null) {
                    ((ImageView) customView3.findViewById(C1524R$id.tab_icon)).setImageResource(C1523R$drawable.ic_maintab_music_s);
                    ((TextView) customView3.findViewById(C1524R$id.tab_title)).setTextColor(getResources().getColor(2131099807));
                }
            } else if (i2 == 2 && (customView = tabAt.getCustomView()) != null) {
                ((ImageView) customView.findViewById(C1524R$id.tab_icon)).setImageResource(C1523R$drawable.ic_maintab_edit_s);
                ((TextView) customView.findViewById(C1524R$id.tab_title)).setTextColor(getResources().getColor(2131099807));
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00cc  */
    private void b8(int i2, boolean z2) {
        MediaDatabase mediaDatabase;
        this.t0.setVisibility(8);
        this.x0.setVisibility(8);
        this.B0.setVisibility(4);
        if (i2 == 0) {
            if (this.y0 == null) {
                y6();
                List<SimpleInf> q6 = q6(0);
                EditorAOneAdapter editorAOneAdapter = new EditorAOneAdapter(this.v1, q6, true, 5, this);
                this.y0 = editorAOneAdapter;
                editorAOneAdapter.C(this.T);
                this.t0.setAdapter(this.y0);
                this.t0.addItemDecoration(new p());
                int i3 = 0;
                while (true) {
                    if (i3 >= q6.size()) {
                        i3 = 0;
                        break;
                    }
                    SimpleInf simpleInf = q6.get(i3);
                    if (simpleInf != null && (mediaDatabase = this.f8720m) != null && mediaDatabase.getFxThemeU3DEntity() != null && simpleInf.getId() == this.f8720m.getFxThemeU3DEntity().fxThemeId) {
                        break;
                    }
                    i3++;
                }
                this.y0.F(i3);
                this.y0.B(new q());
            }
            if (z2) {
                this.t0.setVisibility(0);
                this.x0.setVisibility(8);
                this.v0.setVisibility(8);
            }
        } else if (i2 == 3) {
            if (this.D0 == null) {
                q0 q0Var = new q0(this.C, q6(3), this.J1, this.M1);
                this.D0 = q0Var;
                q0Var.g(false);
                this.B0.setAdapter((ListAdapter) this.D0);
            }
            if (z2) {
                this.B0.setVisibility(0);
                this.x0.setVisibility(8);
                this.v0.setVisibility(8);
            }
        } else if (i2 == 12) {
            if (this.z0 == null) {
                EditorAOneAdapter editorAOneAdapter2 = new EditorAOneAdapter(this.C, q6(2), false, 7, null);
                this.z0 = editorAOneAdapter2;
                this.u0.setAdapter(editorAOneAdapter2);
                this.z0.B(new r());
            }
            if (this.A0 == null) {
                EditorAOneAdapter editorAOneAdapter3 = new EditorAOneAdapter(this.C, q6(12), false, 17, null);
                this.A0 = editorAOneAdapter3;
                this.x0.setAdapter(editorAOneAdapter3);
                this.x0.addItemDecoration(new s());
                this.A0.B(new e1(this));
            }
            if (z2) {
                MediaDatabase mediaDatabase2 = this.f8720m;
                if (!(mediaDatabase2 == null || mediaDatabase2.getSoundList() == null)) {
                    int i4 = 1;
                    if (this.f8720m.getSoundList().size() == 1) {
                        int i5 = this.f8720m.getSoundList().get(0).index;
                        if (this.f8720m.getSoundList().get(0).isTheme) {
                            this.z0.F(-1);
                        } else {
                            EditorAOneAdapter editorAOneAdapter4 = this.z0;
                            if (i5 != -1) {
                                i4 = i5;
                            }
                            editorAOneAdapter4.F(i4);
                        }
                        if (this.s1 != 0) {
                            this.x0.setVisibility(0);
                            this.v0.setVisibility(8);
                            return;
                        }
                        this.x0.setVisibility(8);
                        this.v0.setVisibility(0);
                        return;
                    }
                }
                this.s1 = 0;
                if (this.s1 != 0) {
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c7 */
    public /* synthetic */ void d7(View view) {
        ProPrivilegeAdHandle.getInstance().showAdmobVideoAd("watermaker", this);
    }

    private void c8() {
        MediaDatabase mediaDatabase = this.f8720m;
        if (mediaDatabase == null) {
            hl.productor.fxlib.h.O = 2;
            hl.productor.fxlib.h.T = -16777216;
            return;
        }
        if (this.O0) {
            mediaDatabase.background_color = hl.productor.fxlib.h.O;
        } else {
            int i2 = mediaDatabase.background_color;
            if (i2 == 0) {
                mediaDatabase.background_color = 2;
                hl.productor.fxlib.h.O = 2;
            } else {
                hl.productor.fxlib.h.O = i2;
            }
        }
        int i3 = hl.productor.fxlib.h.O;
        if (i3 == 1) {
            hl.productor.fxlib.h.T = -1;
            hl.productor.fxlib.h.V = false;
        } else if (i3 == 2) {
            hl.productor.fxlib.h.T = -16777216;
            hl.productor.fxlib.h.V = false;
        } else if (i3 == 3) {
            hl.productor.fxlib.h.T = -16777216;
            hl.productor.fxlib.h.V = true;
        } else {
            S s2 = h2.e().f().b;
            hl.productor.fxlib.h.V = false;
            if (s2 != null) {
                int i4 = z.a[s2.type.ordinal()];
                if (i4 == 1) {
                    hl.productor.fxlib.h.T = getResources().getColor(s2.color);
                    Iterator<MediaClip> it = this.f8720m.getClipArray().iterator();
                    while (it.hasNext()) {
                        it.next().setClipImageBKFxColor(s2.n_red / 255.0f, s2.n_green / 255.0f, s2.n_blue / 255.0f);
                    }
                } else if (i4 == 2 || i4 == 3) {
                    hl.productor.fxlib.h.T = -16777216;
                    if (s2.type == BackgroundItem.Type.COLOR_GRADIENT) {
                        j2.a(s2);
                    } else {
                        j2.b(s2, AbstractConfigActivity.t, AbstractConfigActivity.u);
                    }
                    Iterator<MediaClip> it2 = this.f8720m.getClipArray().iterator();
                    while (it2.hasNext()) {
                        MediaClip next = it2.next();
                        if (TextUtils.isEmpty(s2.generatePath)) {
                            next.setClipImageBKFxSelfImage();
                        } else {
                            next.setClipImageBKFxPath(s2.generatePath);
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void d8(boolean z2) {
        if (z2) {
            ArrayList<SoundEntity> arrayList = null;
            MediaDatabase mediaDatabase = this.f8720m;
            if (mediaDatabase != null) {
                arrayList = mediaDatabase.getSoundList();
            }
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    SoundEntity soundEntity = arrayList.get(i2);
                    if (soundEntity != null) {
                        soundEntity.volume = this.e1;
                    }
                }
            }
            h1(this.e1);
            if (z2 && this.e1 == 0) {
                m1.a(this, "EDITOR_SCREEN_VOLUME_SEEKBAR_SET_TO_ZERO");
                com.xvideostudio.videoeditor.tool.m.n(2131822110);
            }
            Message message = new Message();
            message.what = 44;
            this.D1.sendMessage(message);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e7 */
    public /* synthetic */ void f7() {
        if (this.f8721n.h0()) {
            s8(this.f8721n.h0(), true);
        }
        this.H0 = 1;
        s6();
    }

    private void e8() {
        String str;
        MediaDatabase mediaDatabase = this.f8720m;
        if (mediaDatabase != null && this.f8721n != null && mediaDatabase.getFxThemeU3DEntity() != null) {
            if (this.i1 >= 0.0f || this.j1 >= 0.0f) {
                if (this.f8721n.h0()) {
                    u8();
                }
                Iterator<FxThemeU3DEffectEntity> it = this.f8720m.getFxThemeU3DEntity().u3dThemeEffectArr.iterator();
                String str2 = null;
                FxThemeU3DEffectEntity fxThemeU3DEffectEntity = null;
                FxThemeU3DEffectEntity fxThemeU3DEffectEntity2 = null;
                while (it.hasNext()) {
                    FxThemeU3DEffectEntity next = it.next();
                    int i2 = next.type;
                    if (i2 == 3) {
                        fxThemeU3DEffectEntity = next;
                    } else if (i2 == 4) {
                        fxThemeU3DEffectEntity2 = next;
                    }
                }
                boolean z2 = this.f8720m.getFxThemeU3DEntity().clipStartFlag;
                boolean z3 = this.f8720m.getFxThemeU3DEntity().clipEndFlag;
                x xVar = new x(fxThemeU3DEffectEntity, z2, fxThemeU3DEffectEntity2, z3);
                if (fxThemeU3DEffectEntity == null || fxThemeU3DEffectEntity.textWhRatio <= 0.0f) {
                    str = null;
                } else {
                    str = fxThemeU3DEffectEntity.textTitle;
                    if (str == null) {
                        str = "";
                    }
                }
                if (fxThemeU3DEffectEntity2 != null && fxThemeU3DEffectEntity2.textWhRatio > 0.0f) {
                    String str3 = fxThemeU3DEffectEntity2.textTitle;
                    str2 = str3 == null ? "" : str3;
                }
                m1.a(this.C, "CLICK_THEME_TITLE");
                if (!isFinishing()) {
                    com.xvideostudio.videoeditor.x0.f0.b(this.C, xVar, null, str, str2, z2, z3);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void f8(boolean z2) {
        if (z2) {
            MediaDatabase mediaDatabase = this.f8720m;
            if (mediaDatabase != null) {
                Iterator<MediaClip> it = mediaDatabase.getClipArray().iterator();
                while (it.hasNext()) {
                    MediaClip next = it.next();
                    next.videoVolume = this.u1;
                    this.f8720m.isVideosMute = false;
                    String str = "===" + next.videoVolume;
                }
            }
            Message message = new Message();
            message.what = 44;
            this.D1.sendMessage(message);
        }
    }

    static /* synthetic */ boolean g7(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
        return false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void g8(boolean z2, boolean z3) {
        if (VideoEditorApplication.C) {
            if (z2) {
                this.i0.setSelected(true);
            } else {
                this.i0.setSelected(false);
            }
            if (z3) {
                d1();
            }
        }
    }

    private void h6() {
        if (getIntent() != null && this.B != -1) {
            a.EnumC0228a aVar = a.EnumC0228a.values()[this.B];
            String str = "--->>> PUSH_EDITOR_TYPE:" + aVar;
            switch (z.b[aVar.ordinal()]) {
                case 1:
                    S7();
                    break;
                case 2:
                    R7();
                    break;
                case 3:
                    P7();
                    break;
                case 4:
                    T7();
                    break;
                case 5:
                    U7();
                    break;
                case 6:
                    Q7();
                    break;
                default:
                    V7();
                    break;
            }
            this.B = -1;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h7 */
    public /* synthetic */ void i7() {
        this.b1 = true;
        invalidateOptionsMenu();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void h8(SeekVolume seekVolume, int i2) {
        seekVolume.setProgress(i2);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void i6(int i2) {
        MediaDatabase mediaDatabase = this.f8720m;
        if (mediaDatabase == null || this.s0 || mediaDatabase.getFxThemeU3DEntity() == null || this.f8720m.getFxThemeU3DEntity().fxThemeId != i2) {
            new com.xvideostudio.videoeditor.fragment.s().show(getSupportFragmentManager(), "");
            com.xvideostudio.videoeditor.tool.a0.a(1).execute(new x0(this, i2));
            this.I1.post(new q1(this, i2));
            return;
        }
        h.a.x.e eVar = this.f8721n;
        if (eVar != null && !eVar.h0()) {
            s8(this.f8721n.h0(), true);
        }
    }

    public static void i8(Context context, int i2, int i3) {
        boolean z2 = true;
        if (i3 != 1) {
            z2 = false;
        }
        VideoEditorApplication.y0(z2);
        VideoEditorApplication.y().W();
        com.xvideostudio.videoeditor.tool.m.p(i2, -1, 6000);
    }

    /* JADX WARNING: Removed duplicated region for block: B:61:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:87:? A[RETURN, SYNTHETIC] */
    private void j6(int i2) {
        String str;
        int i3;
        Exception e2;
        String string;
        MediaDatabase mediaDatabase = this.f8720m;
        if (mediaDatabase != null) {
            mediaDatabase.titleEntity = null;
            this.d1 = i2;
            FxThemeU3DEntity r2 = com.xvideostudio.videoeditor.l0.c.r(i2, 0, this.F0, mediaDatabase, this.C);
            String str2 = this.E0;
            this.f8720m.initThemeU3D(r2, true, str2 != null && str2.equals(MessengerShareContentUtility.MEDIA_IMAGE), false);
            l6(r2);
            this.f8720m.setThemeU3dEntity(r2);
            ArrayList<SoundEntity> soundList = this.f8720m.getSoundList();
            if ((soundList == null || soundList.size() == 0 || (soundList.size() == 1 && soundList.get(0).isTheme)) && r2 != null && !TextUtils.isEmpty(r2.musicConfig)) {
                int i4 = 50;
                if (soundList != null) {
                    try {
                        if (soundList.size() >= 1 && !soundList.get(0).isCamera) {
                            i4 = soundList.get(0).volume;
                        }
                        soundList.clear();
                        this.f8720m.upCameraClipAudio();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return;
                    }
                }
                int totalDuration = this.f8720m.getTotalDuration();
                if (!r2.musicConfig.startsWith("{") || !r2.musicConfig.endsWith("}")) {
                    Map<String, String> map = VideoMakerApplication.E0().get(r2.musicConfig);
                    if (map != null) {
                        String str3 = com.xvideostudio.videoeditor.l0.b.f0() + map.get("fileName");
                        if (new File(str3).exists()) {
                            int intValue = Integer.valueOf(map.get(VastIconXmlManager.DURATION)).intValue();
                            this.f8720m.addClipAudio(map.get("musicName"), str3, 0, intValue, intValue, true, 0, totalDuration, false, true);
                            this.f8720m.getSoundList().get(0).volume = i4;
                            e1();
                            return;
                        }
                        return;
                    }
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(r2.musicConfig);
                    String str4 = r2.u3dThemePath + jSONObject.getString(ClientCookie.PATH_ATTR);
                    if (new File(str4).exists()) {
                        String x2 = com.xvideostudio.videoeditor.x0.c0.x();
                        String w2 = com.xvideostudio.videoeditor.x0.c0.w();
                        if (!jSONObject.isNull(x2)) {
                            string = jSONObject.getString(x2);
                        } else if (!jSONObject.isNull(w2)) {
                            string = jSONObject.getString(w2);
                        } else if (!jSONObject.isNull("en")) {
                            string = jSONObject.getString("en");
                        } else {
                            str = "";
                            MediaPlayer create = MediaPlayer.create(this.C, Uri.parse(str4));
                            i3 = create.getDuration();
                            create.release();
                            if (i3 > 0) {
                                this.f8720m.addClipAudio(str, str4, 0, i3, i3, true, 0, totalDuration, false, true);
                                this.f8720m.getSoundList().get(0).volume = i4;
                                e1();
                                return;
                            }
                            return;
                        }
                        str = string;
                        try {
                            MediaPlayer create2 = MediaPlayer.create(this.C, Uri.parse(str4));
                            i3 = create2.getDuration();
                            try {
                                create2.release();
                            } catch (Exception e4) {
                                e2 = e4;
                            }
                        } catch (Exception e5) {
                            e2 = e5;
                            i3 = 0;
                            e2.printStackTrace();
                            try {
                                MediaPlayer mediaPlayer = new MediaPlayer();
                                mediaPlayer.setDataSource(str4);
                                mediaPlayer.prepare();
                                i3 = mediaPlayer.getDuration();
                                mediaPlayer.release();
                            } catch (Exception e6) {
                                e6.printStackTrace();
                            }
                            if (i3 > 0) {
                            }
                        }
                        if (i3 > 0) {
                        }
                    }
                } catch (Exception e7) {
                    e7.printStackTrace();
                }
            } else if (soundList != null && soundList.size() > 0) {
                if (soundList.size() == 1 && soundList.get(0).isTheme) {
                    this.f8720m.getSoundList().clear();
                } else if (soundList.size() != 1 || soundList.get(0).isCamera) {
                    this.f8720m.addCameraClipAudio();
                } else {
                    this.f8720m.getSoundList().get(0).gVideoEndTime = this.f8720m.getTotalDuration();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j7 */
    public /* synthetic */ void k7(int i2, View view) {
        i6(i2);
        this.h1 = !((Boolean) view.getTag()).booleanValue();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void j8() {
        com.xvideostudio.videoeditor.tool.f fVar = this.O;
        if (fVar == null || !fVar.isShowing()) {
            View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(C1527R$layout.dialog_export, (ViewGroup) null);
            this.O = null;
            com.xvideostudio.videoeditor.tool.f fVar2 = new com.xvideostudio.videoeditor.tool.f(this, 2131886886);
            this.O = fVar2;
            fVar2.setContentView(inflate);
            SeekBar seekBar = (SeekBar) inflate.findViewById(2131297500);
            this.P = seekBar;
            seekBar.setClickable(false);
            this.P.setEnabled(false);
            this.O.setCanceledOnTouchOutside(false);
            this.P.setFocusableInTouchMode(false);
            this.Q = (TextView) inflate.findViewById(2131297881);
            this.P.setMax(100);
            this.P.setProgress(0);
            ((Button) inflate.findViewById(C1524R$id.bt_dialog_ok)).setOnClickListener(new w0(this));
            this.O.setOnKeyListener(new p1(this));
            this.O.setCancelable(false);
            this.O.show();
        }
    }

    private void k6() {
        AbstractConfigActivity.t = 0;
        AbstractConfigActivity.u = 0;
        this.G = true;
        this.k1 = true;
        MediaDatabase mediaDatabase = this.f8720m;
        if (mediaDatabase != null) {
            mediaDatabase.setCurrentClip(0);
        }
    }

    private void k8() {
        if (com.xvideostudio.videoeditor.f0.a.c().a(this.C) && !com.xvideostudio.videoeditor.u.u(this.C)) {
            com.xvideostudio.videoeditor.x0.e0.U(this.C, f1.f8749f, null);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void l6(FxThemeU3DEntity fxThemeU3DEntity) {
        if (fxThemeU3DEntity == null) {
            if (!hl.productor.fxlib.h.V) {
                MediaDatabase mediaDatabase = this.f8720m;
                if (mediaDatabase != null) {
                    mediaDatabase.background_color = 2;
                }
                hl.productor.fxlib.h.O = 2;
                hl.productor.fxlib.h.T = -16777216;
                com.xvideostudio.videoeditor.tool.w.M0(this.C, hl.productor.fxlib.h.O);
            }
        } else if (!hl.productor.fxlib.h.V) {
            MediaDatabase mediaDatabase2 = this.f8720m;
            if (mediaDatabase2 != null) {
                mediaDatabase2.background_color = fxThemeU3DEntity.backgroundColor;
            }
            hl.productor.fxlib.h.O = fxThemeU3DEntity.backgroundColor;
            hl.productor.fxlib.h.V = false;
            int i2 = hl.productor.fxlib.h.O;
            if (i2 == 1) {
                hl.productor.fxlib.h.T = -1;
            } else if (i2 == 2) {
                hl.productor.fxlib.h.T = -16777216;
            } else if (i2 == 3) {
                hl.productor.fxlib.h.T = -16777216;
                hl.productor.fxlib.h.V = true;
                if (!hl.productor.fxlib.h.W) {
                    hl.productor.fxlib.h.O = 2;
                    hl.productor.fxlib.h.T = -16777216;
                    hl.productor.fxlib.h.V = false;
                }
            } else {
                S s2 = h2.e().f().b;
                hl.productor.fxlib.h.V = false;
                if (s2 != null) {
                    int i3 = z.a[s2.type.ordinal()];
                    if (i3 == 1) {
                        hl.productor.fxlib.h.T = getResources().getColor(s2.color);
                        Iterator<MediaClip> it = this.f8720m.getClipArray().iterator();
                        while (it.hasNext()) {
                            it.next().setClipImageBKFxColor(s2.n_red / 255.0f, s2.n_green / 255.0f, s2.n_blue / 255.0f);
                        }
                    } else if (i3 == 2 || i3 == 3) {
                        hl.productor.fxlib.h.T = -16777216;
                        if (s2.type == BackgroundItem.Type.COLOR_GRADIENT) {
                            j2.a(s2);
                        } else {
                            j2.b(s2, AbstractConfigActivity.t, AbstractConfigActivity.u);
                        }
                        Iterator<MediaClip> it2 = this.f8720m.getClipArray().iterator();
                        while (it2.hasNext()) {
                            MediaClip next = it2.next();
                            if (TextUtils.isEmpty(s2.generatePath)) {
                                next.setClipImageBKFxSelfImage();
                            } else {
                                next.setClipImageBKFxPath(s2.generatePath);
                            }
                        }
                    }
                }
            }
            com.xvideostudio.videoeditor.tool.w.M0(this.C, hl.productor.fxlib.h.O);
        } else if (!hl.productor.fxlib.h.W) {
            hl.productor.fxlib.h.O = 2;
            hl.productor.fxlib.h.T = -16777216;
            hl.productor.fxlib.h.V = false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: l7 */
    public /* synthetic */ void m7(View view) {
        this.h1 = !((Boolean) view.getTag()).booleanValue();
    }

    private void l8() {
        MediaDatabase mediaDatabase = this.f8720m;
        if (mediaDatabase != null) {
            u0 a3 = u0.a(mediaDatabase.videoModeSelect);
            a3.b(new t0(this));
            a3.show(getSupportFragmentManager(), "resolutionChoice");
        }
    }

    private void m6() {
        n6(false);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void n6(boolean z2) {
        int i2;
        int i3;
        int i4;
        MediaDatabase mediaDatabase = this.f8720m;
        if (mediaDatabase != null) {
            int[] calculateGlViewSizeDynamic = mediaDatabase.calculateGlViewSizeDynamic(mediaDatabase, AbstractConfigActivity.t, AbstractConfigActivity.u, AbstractConfigActivity.r);
            int i5 = calculateGlViewSizeDynamic[0];
            AbstractConfigActivity.t = calculateGlViewSizeDynamic[1];
            AbstractConfigActivity.u = calculateGlViewSizeDynamic[2];
            a1(this.W);
            if (this.N == i5) {
                hl.productor.fxlib.y.j();
            }
            int i6 = 9;
            if (this.k1 || this.N != i5 || this.f8721n == null) {
                this.k1 = false;
                c1();
                com.xvideostudio.videoeditor.l0.c.S();
                this.f8722o = null;
                this.f8721n = new h.a.x.e(this, this.D1);
                String str = "changeGlViewSizeDynamic myViewWidth2:" + AbstractConfigActivity.t + " myViewHeight2:" + AbstractConfigActivity.u;
                this.f8721n.K().setLayoutParams(new RelativeLayout.LayoutParams(AbstractConfigActivity.t, AbstractConfigActivity.u));
                com.xvideostudio.videoeditor.l0.c.U(AbstractConfigActivity.t, AbstractConfigActivity.u);
                this.f8721n.K().setVisibility(0);
                addRenderView(this.f8721n.K());
                if (VideoEditorApplication.B(this.C, true) * VideoEditorApplication.x >= 384000 && this.W != null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.xvideostudio.videoeditor.tool.h.a(this.C, 28.0f), com.xvideostudio.videoeditor.tool.h.a(this.C, 28.0f));
                    layoutParams.addRule(12);
                    layoutParams.addRule(9);
                    layoutParams.setMargins(((this.W.getWidth() - AbstractConfigActivity.t) / 2) + com.xvideostudio.videoeditor.tool.h.a(this.C, 7.0f), 0, 0, ((this.W.getHeight() - AbstractConfigActivity.u) / 2) + com.xvideostudio.videoeditor.tool.h.a(this.C, 10.0f));
                    Button button = this.k0;
                    if (button != null) {
                        button.setLayoutParams(layoutParams);
                    }
                }
                if (this.h0 != null) {
                    if (l2.b(this.C).booleanValue() && this.f8720m.getMarkStickerList().size() == 0 && x6() == 0) {
                        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.xvideostudio.videoeditor.tool.h.a(this.C, 75.0f), com.xvideostudio.videoeditor.tool.h.a(this.C, 39.0f));
                        if (VideoEditorApplication.B(this.C, true) * VideoEditorApplication.x == 153600) {
                            layoutParams2.addRule(10);
                            layoutParams2.addRule(11);
                            layoutParams2.setMargins(0, ((this.W.getHeight() - AbstractConfigActivity.u) / 2) + com.xvideostudio.videoeditor.tool.h.a(this.C, 6.0f), ((this.W.getWidth() - AbstractConfigActivity.t) / 2) + com.xvideostudio.videoeditor.tool.h.a(this.C, 7.0f), 0);
                        } else {
                            layoutParams2.addRule(12);
                            layoutParams2.addRule(11);
                            layoutParams2.setMargins(0, 0, ((this.W.getWidth() - AbstractConfigActivity.t) / 2) + com.xvideostudio.videoeditor.tool.h.a(this.C, 7.0f), ((this.W.getHeight() - AbstractConfigActivity.u) / 2) + com.xvideostudio.videoeditor.tool.h.a(this.C, 10.0f));
                        }
                        this.h0.setLayoutParams(layoutParams2);
                        if (com.xvideostudio.videoeditor.u.e(this.C).booleanValue()) {
                            this.h0.setVisibility(8);
                        } else if (com.xvideostudio.videoeditor.u.c(this.C).booleanValue()) {
                            this.h0.setVisibility(8);
                        } else {
                            this.h0.setVisibility(0);
                        }
                    } else {
                        this.h0.setVisibility(8);
                    }
                }
                if (!(!this.w1 || (i2 = this.M) == 0 || this.f8720m == null || (i2 == AbstractConfigActivity.t && this.L == AbstractConfigActivity.u))) {
                    int i7 = i2 - (i2 % 16);
                    int i8 = AbstractConfigActivity.t;
                    if (i7 != i8 - (i8 % 16) || (((i3 = this.L) != (i4 = AbstractConfigActivity.u) && Math.abs(i3 - i4) >= 125) || AbstractConfigActivity.t == AbstractConfigActivity.u || this.M == this.L)) {
                        this.f8720m.clearClipZoomValue();
                    }
                }
                this.w1 = false;
                RelativeLayout relativeLayout = this.X;
                if (relativeLayout != null) {
                    relativeLayout.bringToFront();
                }
                LinearLayout linearLayout = this.Y;
                if (linearLayout != null) {
                    linearLayout.bringToFront();
                }
                if (findViewById(C1524R$id.seek_text) != null) {
                    findViewById(C1524R$id.seek_text).bringToFront();
                }
                if (this.x1) {
                    this.Z.setVisibility(0);
                    this.Z.bringToFront();
                }
                this.N = i5;
            } else {
                this.f8722o = null;
            }
            String str2 = "changeGlViewSizeDynamic width:" + AbstractConfigActivity.t + " height:" + AbstractConfigActivity.u;
            this.M = AbstractConfigActivity.t;
            this.L = AbstractConfigActivity.u;
            this.H = this.f8721n.K().getWidth() == 0 ? AbstractConfigActivity.t : this.f8721n.K().getWidth();
            this.I = this.f8721n.K().getHeight() == 0 ? AbstractConfigActivity.u : this.f8721n.K().getHeight();
            h6();
            if (this.f8722o == null) {
                this.f8721n.F0(0, this.f8720m.getClipArray().size() - 1);
                this.f8722o = new com.xvideostudio.videoeditor.r(this, this.f8721n, this.D1);
                Message message = new Message();
                if (!z2) {
                    i6 = 8;
                }
                message.what = i6;
                this.D1.sendMessage(message);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: n7 */
    public /* synthetic */ void o7(int i2, View view) {
        i6(i2);
        this.h1 = !((Boolean) view.getTag()).booleanValue();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void n8() {
        int i2;
        if (this.f8721n != null && this.f8722o != null && this.f8720m != null) {
            View inflate = LayoutInflater.from(this.C).inflate(C1527R$layout.dialog_duration_batch_editor, (ViewGroup) null);
            com.xvideostudio.videoeditor.tool.f fVar = new com.xvideostudio.videoeditor.tool.f(this.C, 2131886886);
            fVar.setContentView(inflate);
            MediaDatabase mediaDatabase = this.f8720m;
            this.F1 = mediaDatabase.durationBatchType;
            this.H1 = mediaDatabase.getTotalTransDuration();
            int size = this.f8720m.getClipArray().size();
            int i3 = 0;
            MediaClip clip = this.f8720m.getClip(0);
            if (clip.isAppendClip) {
                i2 = clip.duration;
                size--;
            } else {
                i2 = 0;
            }
            MediaDatabase mediaDatabase2 = this.f8720m;
            MediaClip clip2 = mediaDatabase2.getClip(mediaDatabase2.getClipArray().size() - 1);
            if (clip2.isAppendClip) {
                i3 = clip2.duration;
                size--;
            }
            int i4 = i2 + i3;
            String str = this.C.getString(2131820910) + ": ";
            String str2 = "s " + this.C.getString(2131820907);
            int totalDuration = this.f8720m.getTotalDuration();
            this.G1 = Math.round(((float) ((totalDuration - this.H1) - i4)) / ((float) size));
            TextView textView = (TextView) fVar.findViewById(C1524R$id.tv_dialog_duration_title);
            textView.setText(str + SystemUtility.getTimeMinSecFormt(totalDuration) + " / " + z0.d(((float) this.G1) / 1000.0f) + str2);
            SeekBar seekBar = (SeekBar) fVar.findViewById(C1524R$id.seekbar_duration_batch);
            RadioGroup radioGroup = (RadioGroup) fVar.findViewById(C1524R$id.rg_group);
            int i5 = this.f8720m.durationBatchType;
            if (i5 == 0) {
                radioGroup.check(C1524R$id.rb_0);
            } else if (i5 == 1) {
                radioGroup.check(C1524R$id.rb_1);
            }
            t1 t1Var = new t1(this, size, i4, textView, str, str2, seekBar);
            seekBar.setMax(100);
            seekBar.setProgress((int) ((((float) this.G1) / 1000.0f) * 10.0f));
            seekBar.setOnSeekBarChangeListener(new w(radioGroup, size, i4, textView, str, str2));
            radioGroup.setOnCheckedChangeListener(t1Var);
            ((Button) fVar.findViewById(C1524R$id.bt_dialog_ok)).setOnClickListener(new b1(this, size, i4, fVar));
            ((Button) fVar.findViewById(C1524R$id.bt_dialog_cancel)).setOnClickListener(new h1(fVar));
            fVar.show();
        }
    }

    private void o1() {
        MediaDatabase mediaDatabase = this.f8720m;
        if (mediaDatabase != null && mediaDatabase.isSavedMark && mediaDatabase.getMarkStickerList() != null && this.f8720m.getMarkStickerList().isEmpty()) {
            this.f8720m.setMarkStickerList((ArrayList) com.xvideostudio.videoeditor.u.s(this));
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void o6() {
        boolean z2;
        MediaDatabase mediaDatabase = this.f8720m;
        if (mediaDatabase != null && mediaDatabase.getClipArray() != null && this.f8720m.getClipArray().size() != 0) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.f8720m.getClipArray().size()) {
                    i2 = 0;
                    z2 = false;
                    break;
                } else if (this.f8720m.getClip(i2).mediaType == VideoEditData.VIDEO_TYPE) {
                    z2 = true;
                    break;
                } else {
                    i2++;
                }
            }
            this.V = z2;
            if (z2) {
                SeekVolume seekVolume = this.U0;
                if (seekVolume != null) {
                    seekVolume.setVisibility(0);
                    this.u1 = this.f8720m.getClip(i2).videoVolume;
                    if (this.f8720m.getClip(0).mediaType == VideoEditData.IMAGE_TYPE) {
                        this.u1 = 0;
                    }
                    h8(this.U0, this.u1);
                }
            } else {
                SeekVolume seekVolume2 = this.V0;
                if (seekVolume2 != null) {
                    seekVolume2.setVisibility(8);
                }
            }
            SoundEntity soundEntity = null;
            MediaDatabase mediaDatabase2 = this.f8720m;
            if (!(mediaDatabase2 == null || mediaDatabase2.getSoundList() == null || this.f8720m.getSoundList().size() <= 0)) {
                soundEntity = this.f8720m.getSoundList().get(0);
            }
            if (soundEntity != null) {
                SeekVolume seekVolume3 = this.V0;
                if (seekVolume3 != null) {
                    seekVolume3.setVisibility(0);
                    h8(this.V0, soundEntity.volume);
                    this.e1 = soundEntity.volume;
                    return;
                }
                return;
            }
            SeekVolume seekVolume4 = this.V0;
            if (seekVolume4 != null) {
                seekVolume4.setVisibility(8);
            }
        }
    }

    private void o8() {
        com.xvideostudio.videoeditor.x0.p2.b.a(0, "EDIT_MOSAIC", null);
        com.xvideostudio.videoeditor.u.J2(this.C, Boolean.TRUE);
        this.l0 = true;
        y4.b = false;
        Intent intent = new Intent(this.C, ConfigMosaicActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(MediaDatabase.SERIALIZABLE_EXTRA, this.f8720m);
        h.a.x.e eVar = this.f8721n;
        float H2 = eVar != null ? eVar.H() : 0.0f;
        intent.putExtra("editorRenderTime", H2);
        com.xvideostudio.videoeditor.r rVar = this.f8722o;
        if (rVar != null) {
            intent.putExtra("editorClipIndex", rVar.e(H2));
        }
        intent.putExtra("glWidthEditor", this.H);
        intent.putExtra("glHeightEditor", this.I);
        intent.putExtras(bundle);
        startActivityForResult(intent, 2);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void p6(SimpleInf simpleInf, int i2) {
        h.a.x.e eVar = this.f8721n;
        if (eVar != null && eVar.h0()) {
            this.f8721n.j0();
        }
        String str = T1 + (simpleInf.text + ".m4a");
        if (!new File(str).exists()) {
            str = com.xvideostudio.videoeditor.l0.b.e0() + "/" + simpleInf.music_id + "material/music.m4a";
        }
        MusicInf musicInf = new MusicInf();
        musicInf.name = simpleInf.text;
        musicInf.path = str;
        musicInf.duration = simpleInf.duration;
        MediaDatabase mediaDatabase = this.f8720m;
        if (mediaDatabase != null && mediaDatabase.getSoundList() != null) {
            Iterator<SoundEntity> it = this.f8720m.getSoundList().iterator();
            while (true) {
                if (it.hasNext()) {
                    SoundEntity next = it.next();
                    if (next != null && str.equals(next.path) && next.gVideoEndTime == this.f8720m.getTotalDuration()) {
                        musicInf.trimStatrTime = next.start_time;
                        musicInf.trimEndTime = next.end_time;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        p1 p1Var = new p1(this.C, musicInf, new a(i2));
        this.r1 = p1Var;
        p1Var.p();
    }

    /* access modifiers changed from: private */
    /* renamed from: p7 */
    public /* synthetic */ void q7(View view) {
        this.h1 = !((Boolean) view.getTag()).booleanValue();
    }

    private void p8() {
        this.l0 = true;
        y4.b = false;
        Intent intent = new Intent(this.C, ConfigStickerActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(MediaDatabase.SERIALIZABLE_EXTRA, this.f8720m);
        h.a.x.e eVar = this.f8721n;
        float H2 = eVar != null ? eVar.H() : 0.0f;
        intent.putExtra("editorRenderTime", H2);
        com.xvideostudio.videoeditor.r rVar = this.f8722o;
        if (rVar != null) {
            intent.putExtra("editorClipIndex", rVar.e(H2));
        }
        intent.putExtra("glWidthEditor", this.H);
        intent.putExtra("glHeightEditor", this.I);
        intent.putExtras(bundle);
        startActivityForResult(intent, 2);
        overridePendingTransition(0, 0);
    }

    private List<SimpleInf> q6(int i2) {
        ArrayList arrayList = new ArrayList();
        if (i2 == 0) {
            SimpleInf simpleInf = new SimpleInf();
            simpleInf.drawable = com.xvideostudio.videoeditor.l0.c.A(0, 1).intValue();
            simpleInf.text = getResources().getString(com.xvideostudio.videoeditor.l0.c.A(0, 2).intValue());
            arrayList.add(simpleInf);
            SimpleInf simpleInf2 = new SimpleInf();
            simpleInf2.drawable = C1523R$drawable.bg_mainstyle_morestyle;
            simpleInf2.text = getResources().getString(C1532R$string.more_style);
            simpleInf2.id = -2;
            arrayList.add(simpleInf2);
            int i3 = 0;
            while (i3 < 2) {
                SimpleInf simpleInf3 = new SimpleInf();
                i3++;
                int s2 = com.xvideostudio.videoeditor.l0.c.s(i3);
                simpleInf3.id = s2;
                simpleInf3.music_id = com.xvideostudio.videoeditor.l0.c.A(s2, 7) + "";
                simpleInf3.drawable = com.xvideostudio.videoeditor.l0.c.A(s2, 1).intValue();
                simpleInf3.text = getResources().getString(com.xvideostudio.videoeditor.l0.c.A(s2, 2).intValue());
                String N2 = com.xvideostudio.videoeditor.l0.c.N(s2, 6);
                int intValue = com.xvideostudio.videoeditor.l0.c.A(s2, 5).intValue();
                if (intValue == 1) {
                    if (m0.U(N2 + "config.json")) {
                        intValue = 0;
                    }
                }
                simpleInf3.isLock = 0;
                simpleInf3.isDown = intValue;
                simpleInf3.path = N2;
                arrayList.add(simpleInf3);
            }
            ArrayList arrayList2 = new ArrayList();
            List<Material> p2 = VideoEditorApplication.y().o().a.p(5);
            HashMap hashMap = new HashMap();
            ArrayList arrayList3 = new ArrayList();
            int size = p2.size();
            if (size > 0) {
                for (int i4 = 0; i4 < size; i4++) {
                    Material material = p2.get(i4);
                    SimpleInf simpleInf4 = new SimpleInf();
                    simpleInf4.id = material.getId();
                    simpleInf4.music_id = material.getMusic_id();
                    simpleInf4.drawable = 0;
                    String save_path = material.getSave_path();
                    simpleInf4.path = save_path;
                    String str = File.separator;
                    if (!save_path.endsWith(str)) {
                        simpleInf4.path += str;
                    }
                    File file = new File(simpleInf4.path + "icon.png");
                    if (!file.exists()) {
                        file = new File(simpleInf4.path + "_icon.png");
                    }
                    if (!file.exists()) {
                        simpleInf4.path = material.getMaterial_icon();
                    }
                    simpleInf4.text = material.getMaterial_name();
                    simpleInf4.verCode = material.getVer_code();
                    arrayList2.add(simpleInf4);
                    hashMap.put(Integer.valueOf(simpleInf4.id), simpleInf4);
                    arrayList.add(simpleInf4);
                    String str2 = "material: " + material.getMaterial_name() + " | inf.verCode: " + simpleInf4.verCode;
                }
            }
            String c02 = com.xvideostudio.videoeditor.tool.w.c0(this.C);
            HashMap hashMap2 = new HashMap();
            if (!TextUtils.isEmpty(c02)) {
                try {
                    JSONArray jSONArray = new JSONArray(c02);
                    for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i5);
                        int i6 = jSONObject.getInt("id");
                        if (!hashMap.containsKey(Integer.valueOf(i6))) {
                            SimpleInf simpleInf5 = new SimpleInf();
                            simpleInf5.id = i6;
                            simpleInf5.music_id = jSONObject.getString("music_id");
                            simpleInf5.drawable = 0;
                            simpleInf5.path = jSONObject.getString("recommand_icon_name");
                            simpleInf5.text = jSONObject.getString("material_name");
                            simpleInf5.verCode = jSONObject.getInt("ver_code");
                            simpleInf5.is_pro = jSONObject.getInt("is_pro");
                            simpleInf5.setDown_zip_url(jSONObject.getString("down_zip_url"));
                            simpleInf5.setDown_zip_music_url(jSONObject.getString("down_zip_music_url"));
                            simpleInf5.isDown = 1;
                            Material material2 = new Material();
                            material2.setId(simpleInf5.id);
                            material2.setMaterial_name(simpleInf5.text);
                            material2.setMaterial_icon(jSONObject.getString("material_icon"));
                            material2.setMaterial_type(5);
                            material2.setMusic_id(simpleInf5.music_id);
                            material2.setIs_pro(simpleInf5.is_pro);
                            material2.setMaterial_pic(jSONObject.getString("material_pic"));
                            material2.setDown_zip_url(simpleInf5.getDown_zip_url());
                            material2.setDown_zip_music_url(simpleInf5.getDown_zip_music_url());
                            arrayList3.add(material2);
                            simpleInf5.setMaterial(material2);
                            arrayList.add(simpleInf5);
                            hashMap2.put(Integer.valueOf(simpleInf5.id), Integer.valueOf(simpleInf5.id));
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            com.xvideostudio.videoeditor.materialdownload.d.j(this.C, arrayList3);
            return arrayList;
        } else if (i2 == 3) {
            arrayList.addAll(com.xvideostudio.videoeditor.editorsort.a.c(this));
            SimpleInf a3 = com.xvideostudio.videoeditor.editorsort.a.a(0, arrayList);
            if (a3 != null) {
                MediaDatabase mediaDatabase = this.f8720m;
                if (mediaDatabase == null || !mediaDatabase.hasVideo()) {
                    a3.drawable = C1523R$drawable.ic_proeditor_duration;
                    a3.text = String.valueOf(2131821683);
                } else {
                    a3.drawable = C1523R$drawable.ic_proeditor_trim;
                    a3.text = String.valueOf(2131822059);
                }
            }
            for (int i7 = 0; i7 < arrayList.size(); i7++) {
                SimpleInf simpleInf6 = (SimpleInf) arrayList.get(i7);
                if (U1.contains(Integer.valueOf(simpleInf6.drawable))) {
                    simpleInf6.is_pro = 1;
                } else {
                    simpleInf6.is_pro = 0;
                }
                if (V1.containsKey(Integer.valueOf(simpleInf6.drawable))) {
                    simpleInf6.setWarn(com.xvideostudio.videoeditor.u.N(this, V1.get(Integer.valueOf(simpleInf6.drawable))));
                } else {
                    simpleInf6.setWarn(false);
                }
            }
            com.xvideostudio.videoeditor.u.T1(this, arrayList);
            return arrayList;
        } else if (i2 != 12) {
            return arrayList;
        } else {
            SimpleInf simpleInf7 = new SimpleInf();
            simpleInf7.drawable = C1523R$drawable.bg_materials_none;
            simpleInf7.text = getResources().getString(2131821010);
            arrayList.add(simpleInf7);
            SimpleInf simpleInf8 = new SimpleInf();
            simpleInf8.drawable = C1523R$drawable.ic_mymusic;
            simpleInf8.text = getResources().getString(C1532R$string.music_preload_loacal);
            simpleInf8.id = -2;
            arrayList.add(simpleInf8);
            SimpleInf simpleInf9 = new SimpleInf();
            simpleInf9.drawable = C1523R$drawable.bg_music_videomusic;
            simpleInf9.text = getString(C1532R$string.video_2_music);
            simpleInf9.id = -3;
            simpleInf9.is_pro = 1;
            simpleInf9.setWarn(com.xvideostudio.videoeditor.u.i4());
            arrayList.add(simpleInf9);
            this.o1 = 1;
            int i8 = 0;
            while (true) {
                int[] iArr = W1;
                if (i8 >= iArr.length) {
                    break;
                }
                if (u6(iArr[i8])) {
                    this.o1--;
                } else {
                    SimpleInf simpleInf10 = new SimpleInf();
                    simpleInf10.drawable = Y1[i8];
                    simpleInf10.text = X1[i8];
                    simpleInf10.id = W1[i8];
                    arrayList.add(simpleInf10);
                }
                i8++;
            }
            String v02 = com.xvideostudio.videoeditor.u.v0(this.C);
            if (!TextUtils.isEmpty(v02)) {
                try {
                    JSONArray jSONArray2 = new JSONArray(v02);
                    for (int i9 = 0; i9 < jSONArray2.length(); i9++) {
                        JSONObject jSONObject2 = jSONArray2.getJSONObject(i9);
                        SimpleInf simpleInf11 = new SimpleInf();
                        simpleInf11.id = jSONObject2.getInt("id");
                        simpleInf11.path = jSONObject2.getString("icon_url");
                        simpleInf11.text = jSONObject2.getString("name");
                        arrayList.add(simpleInf11);
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            return arrayList;
        }
    }

    private void q8() {
        com.xvideostudio.videoeditor.x0.p2.b.a(0, "EDIT_SCROLLTEXT", null);
        if (com.xvideostudio.videoeditor.u.N(this.C, "set_new_scroll_text_v2_tip_flag")) {
            com.xvideostudio.videoeditor.u.A2(this.C, "set_new_scroll_text_v2_tip_flag", false);
        }
        this.l0 = true;
        y4.b = false;
        Intent intent = new Intent(this.C, ConfigScrollTextActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(MediaDatabase.SERIALIZABLE_EXTRA, this.f8720m);
        float f2 = 0.0f;
        h.a.x.e eVar = this.f8721n;
        if (eVar != null) {
            f2 = eVar.H();
        }
        intent.putExtra("editorRenderTime", f2);
        com.xvideostudio.videoeditor.r rVar = this.f8722o;
        if (rVar != null) {
            intent.putExtra("editorClipIndex", rVar.e(f2));
        }
        intent.putExtra("glWidthEditor", this.H);
        intent.putExtra("glHeightEditor", this.I);
        intent.putExtra("editor_type", "SCROOLTEXT");
        intent.putExtras(bundle);
        startActivityForResult(intent, 2);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void r6(int i2) {
        h.a.x.e eVar;
        com.xvideostudio.videoeditor.r rVar = this.f8722o;
        if (rVar != null) {
            rVar.H(i2);
        }
        h.a.x.e eVar2 = this.f8721n;
        if (eVar2 != null) {
            eVar2.A0(i2);
        }
        if (this.G0 != null && (eVar = this.f8721n) != null && this.f8722o != null && i2 == 4) {
            if (y4.b && this.B1 && !eVar.h0()) {
                this.f8721n.L0(0.0f);
                p1(0, false);
                s8(this.f8721n.h0(), false);
            }
            y4.b = true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: r7 */
    public /* synthetic */ void s7(boolean z2) {
        if (!isFinishing()) {
            s8(z2, true);
        }
    }

    private void r8() {
        startActivityForResult(new Intent(this.C, ConfigSortItemActivity.class), 21);
        com.xvideostudio.videoeditor.x0.p2.b.a(0, "EDIT_SORTING", null);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0253  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x025d  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x0262 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x028c  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x028e  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x02a3  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x03b2 A[ADDED_TO_REGION] */
    private void s6() {
        boolean z2;
        FxFilterEntity fxFilterEntity;
        boolean z3;
        boolean z4;
        long j2;
        long j3;
        long J2;
        int i2;
        long j4;
        int i3;
        if (this.f8720m != null) {
            if ((com.xvideostudio.videoeditor.u.B1() || com.xvideostudio.videoeditor.c1.b.a || com.xvideostudio.videoeditor.c1.b.b) && !com.xvideostudio.videoeditor.tool.c0.b(this) && this.K0 > 300.0f) {
                if (com.xvideostudio.videoeditor.u.d(this.C).booleanValue()) {
                    com.xvideostudio.videoeditor.u.Q1(this.C, Boolean.FALSE);
                } else if (com.xvideostudio.videoeditor.q.c("export_5_min")) {
                    com.xvideostudio.videoeditor.q.e("export_5_min", false);
                } else if (!com.xvideostudio.videoeditor.u.C0(this.C).booleanValue() || !ProPrivilegeAdHandle.getInstance().isAdSuccess()) {
                    com.xvideostudio.videoeditor.b1.a.c(this, "export_5_min");
                    return;
                } else {
                    com.xvideostudio.videoeditor.b0.j.t(this, new d1(this), new j0(this), l1.f8792f, "export_5_min");
                    return;
                }
            }
            Tools.c();
            if (this.f8720m.isVideosMute) {
                m1.a(this.C, "EXPORT_VIDEO_REMOVE_ORIGINAL_VOICE");
            } else {
                m1.a(this.C, "EXPORT_VIDEO_REMAIN_ORIGINAL_VOICE");
            }
            if (this.f8720m.getConvertType() != -1 || this.f8720m.getClip(0).ffVideoRate != 0 || this.f8720m.getClip(0).isVideoReverse || this.f8720m.isHasMosaic()) {
                ShareActivity shareActivity = ShareActivity.M0;
                if (shareActivity != null && !shareActivity.f7438h) {
                    shareActivity.finish();
                }
                if (this.f8720m.getClipArray().size() == 1 && this.f8720m.getCurrentClip().mediaType == VideoEditData.VIDEO_TYPE && !this.f8720m.isHasMosaic() && (!this.f8720m.getCurrentClip().isCameraClip || (this.f8720m.getCurrentClip().isCameraClip && ((this.f8720m.getVoiceList() != null && this.f8720m.getVoiceList().size() > 0) || (this.f8720m.getSoundList() != null && this.f8720m.getSoundList().size() > 0))))) {
                    ArrayList<TextEntity> textList = this.f8720m.getTextList();
                    ArrayList<FxStickerEntity> stickerList = this.f8720m.getStickerList();
                    ArrayList<FxStickerEntity> drawStickerList = this.f8720m.getDrawStickerList();
                    ArrayList<FxStickerEntity> waterMarkStickerList = this.f8720m.getWaterMarkStickerList();
                    FxTitleEntity titleEntity = this.f8720m.getTitleEntity();
                    FxThemeU3DEntity fxThemeU3DEntity = this.f8720m.getFxThemeU3DEntity();
                    ArrayList<FxU3DEntity> fxU3DEntityList = this.f8720m.getFxU3DEntityList();
                    MediaClip clip = this.f8720m.getClip(0);
                    MediaDatabase mediaDatabase = this.f8720m;
                    if (!mediaDatabase.squareModeEnabled && ((mediaDatabase.videoMode != 1 || clip.getWidthReal() == clip.getHeightReal()) && !this.f8720m.isEditorClip && ((fxThemeU3DEntity == null || (fxThemeU3DEntity != null && fxThemeU3DEntity.fxThemeId == 0)) && ((titleEntity == null || (titleEntity != null && titleEntity.fxThemeId == 0)) && ((fxU3DEntityList == null || (fxU3DEntityList != null && fxU3DEntityList.size() == 0)) && ((textList == null || textList.size() == 0) && ((stickerList == null || stickerList.size() == 0) && ((this.f8720m.getGifStickerList() == null || this.f8720m.getGifStickerList().size() == 0) && ((drawStickerList == null || drawStickerList.size() == 0) && !com.xvideostudio.videoeditor.l0.g.f().e() && ((waterMarkStickerList == null || waterMarkStickerList.size() == 0) && (((fxFilterEntity = clip.fxFilterEntity) == null || (fxFilterEntity != null && fxFilterEntity.filterId == -1)) && this.f8720m.getOutputQuality() == 1))))))))))) {
                        long I2 = m0.I(clip.path);
                        if (clip.ffVideoRate != 0 && ((this.f8720m.getSoundList() == null || this.f8720m.getSoundList().size() <= 0) && (this.f8720m.getVoiceList() == null || this.f8720m.getVoiceList().size() <= 0))) {
                            int i4 = clip.endTime;
                            if (i4 == 0) {
                                i4 = clip.duration;
                            }
                            if (i4 - clip.startTime == clip.duration && !this.f8720m.isVideosMute) {
                                z3 = true;
                                if (!z3 && clip.isVideoReverse && ((this.f8720m.getSoundList() == null || this.f8720m.getSoundList().size() <= 0) && (this.f8720m.getVoiceList() == null || this.f8720m.getVoiceList().size() <= 0))) {
                                    i3 = clip.endTime;
                                    if (i3 == 0) {
                                        i3 = clip.duration;
                                    }
                                    if (i3 - clip.startTime == clip.duration) {
                                        z4 = true;
                                        if (!z3 || z4) {
                                            j2 = I2;
                                        } else {
                                            j2 = 2 * I2;
                                            long j5 = (long) ((((float) j2) * ((float) (clip.endTime - clip.startTime))) / ((float) clip.duration));
                                            if (j5 != 0) {
                                                j2 = j5;
                                            }
                                        }
                                        j3 = j2 / 1024;
                                        int i5 = VideoEditorApplication.c0() ? 2 : 1;
                                        J2 = Tools.J(i5);
                                        Tools.k0(J2, j3, 0, 0, I2 / 1024);
                                        if (j3 > J2) {
                                            if (VideoEditorApplication.A) {
                                                int i6 = 1;
                                                if (i5 == 1) {
                                                    j4 = Tools.J(2);
                                                    i2 = 2131821046;
                                                } else {
                                                    j4 = Tools.J(1);
                                                    i2 = 2131821047;
                                                    i6 = 0;
                                                }
                                                if (j3 >= j4) {
                                                    String str = "Have two sd card~" + getResources().getString(2131821504) + ", " + getResources().getString(2131821506) + " " + j3 + " KB, " + getResources().getString(2131821505) + " " + j4 + " KB ";
                                                    m1.b(this.C, "NOT_ENOUGHSPACE_EX", "model:" + Build.MODEL + ":" + str);
                                                    com.xvideostudio.videoeditor.tool.m.t(str, -1, VastVideoViewController.DEFAULT_VIDEO_DURATION_FOR_CLOSE_BUTTON);
                                                    return;
                                                }
                                                i8(this, i2, i6);
                                            } else {
                                                String str2 = "Only one sd card~" + getResources().getString(2131821504) + ", " + getResources().getString(2131821506) + " " + j3 + " KB, " + getResources().getString(2131821505) + " " + J2 + " KB ";
                                                m1.b(this.C, "NOT_ENOUGHSPACE_EX", "model:" + Build.MODEL + ":" + str2);
                                                com.xvideostudio.videoeditor.tool.m.t(str2, -1, VastVideoViewController.DEFAULT_VIDEO_DURATION_FOR_CLOSE_BUTTON);
                                                return;
                                            }
                                        }
                                        if (!z3 || z4) {
                                            com.xvideostudio.videoeditor.t.a(2);
                                        } else {
                                            int size = this.f8720m.getSoundList() != null ? this.f8720m.getSoundList().size() : 0;
                                            int size2 = this.f8720m.getClip(0).getVoiceList() != null ? this.f8720m.getClip(0).getVoiceList().size() : 0;
                                            if (size > 0 && size2 == 0) {
                                                m1.a(this.C, "OUTPUT_QUICK_ONE_VIDEO_ONE_MUSIC");
                                            } else if (size == 0 && size2 > 0) {
                                                m1.a(this.C, "OUTPUT_QUICK_ONE_VIDEO_ONE_VOICE");
                                            } else if (size > 0 && size2 > 0) {
                                                m1.a(this.C, "OUTPUT_QUICK_ONE_VIDEO_MUSIC_AND_VOICE");
                                            } else if (size == 0 && size2 == 0) {
                                                m1.a(this.C, "OUTPUT_QUICK_ONLY_ONE_VIDEO");
                                            }
                                            MediaDatabase mediaDatabase2 = this.f8720m;
                                            mediaDatabase2.setOutputWidthHeight(mediaDatabase2.getClip(0).getWidthReal(), this.f8720m.getClip(0).getHeightReal());
                                            com.xvideostudio.videoeditor.tool.m.t(this.C.getResources().getString(2131821589), -1, VastVideoViewController.DEFAULT_VIDEO_DURATION_FOR_CLOSE_BUTTON);
                                            com.xvideostudio.videoeditor.t.a(0);
                                        }
                                        hl.productor.fxlib.h.n0 = true;
                                        Message message = new Message();
                                        message.what = 20;
                                        this.D1.sendMessage(message);
                                        return;
                                    }
                                }
                                z4 = false;
                                if (!z3) {
                                }
                                j2 = I2;
                                j3 = j2 / 1024;
                                if (VideoEditorApplication.c0()) {
                                }
                                J2 = Tools.J(i5);
                                Tools.k0(J2, j3, 0, 0, I2 / 1024);
                                if (j3 > J2) {
                                }
                                if (!z3) {
                                }
                                com.xvideostudio.videoeditor.t.a(2);
                                hl.productor.fxlib.h.n0 = true;
                                Message message2 = new Message();
                                message2.what = 20;
                                this.D1.sendMessage(message2);
                                return;
                            }
                        }
                        z3 = false;
                        i3 = clip.endTime;
                        if (i3 == 0) {
                        }
                        if (i3 - clip.startTime == clip.duration) {
                        }
                        z4 = false;
                        if (!z3) {
                        }
                        j2 = I2;
                        j3 = j2 / 1024;
                        if (VideoEditorApplication.c0()) {
                        }
                        J2 = Tools.J(i5);
                        Tools.k0(J2, j3, 0, 0, I2 / 1024);
                        if (j3 > J2) {
                        }
                        if (!z3) {
                        }
                        com.xvideostudio.videoeditor.t.a(2);
                        hl.productor.fxlib.h.n0 = true;
                        Message message22 = new Message();
                        message22.what = 20;
                        this.D1.sendMessage(message22);
                        return;
                    }
                }
                com.xvideostudio.videoeditor.t.a(4);
                ArrayList<MediaClip> clipArray = this.f8720m.getClipArray();
                int size3 = clipArray.size();
                int i7 = 0;
                while (true) {
                    if (i7 >= size3) {
                        z2 = false;
                        break;
                    }
                    MediaClip mediaClip = clipArray.get(i7);
                    if (mediaClip.mediaType == VideoEditData.VIDEO_TYPE && mediaClip.getHeightReal() * mediaClip.getWidthReal() > hl.productor.fxlib.h.f13177c * hl.productor.fxlib.h.b) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("videowh", mediaClip.getWidthReal() + "*" + mediaClip.getHeightReal());
                        StringBuilder sb = new StringBuilder();
                        sb.append(mediaClip.getVideoRotation());
                        sb.append("");
                        hashMap.put("rotation", sb.toString());
                        hashMap.put("maxwh", hl.productor.fxlib.h.b + "*" + hl.productor.fxlib.h.f13177c);
                        hashMap.put("appver", com.xvideostudio.videoeditor.x0.c0.r(this.C));
                        hashMap.put("os:", com.xvideostudio.videoeditor.x0.c0.I());
                        hashMap.put("cpuname", com.xvideostudio.videoeditor.x0.c0.o());
                        hashMap.put("model", com.xvideostudio.videoeditor.x0.c0.E());
                        hashMap.put("androidid", com.xvideostudio.videoeditor.x0.c0.c(this.C));
                        m1.c(this.C, "TOO_BIG_VIDEO_EXPORT", hashMap);
                        z2 = true;
                        break;
                    }
                    i7++;
                }
                if (z2) {
                    com.xvideostudio.videoeditor.tool.m.t(getResources().getString(2131822015), -1, 1);
                    return;
                }
                h.a.x.e.I0(this.H0);
                Message message3 = new Message();
                message3.what = 20;
                this.D1.sendMessage(message3);
                return;
            }
            com.xvideostudio.videoeditor.tool.m.t(getResources().getString(2131821038), -1, 1);
        }
    }

    static /* synthetic */ int t3(EditorActivity editorActivity) {
        int i2 = editorActivity.f1;
        editorActivity.f1 = i2 + 1;
        return i2;
    }

    private int t6(int i2) {
        int i3 = 0;
        while (true) {
            int[] iArr = W1;
            if (i3 >= iArr.length) {
                return -1;
            }
            if (iArr[i3] == i2) {
                return i3;
            }
            i3++;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: t7 */
    public /* synthetic */ void u7() {
        if (!this.f8721n.h0()) {
            s8(this.f8721n.h0(), true);
        }
        this.n0.postDelayed(new g1(this), (long) (this.f8720m.getTotalDuration() + VastVideoViewController.DEFAULT_VIDEO_DURATION_FOR_CLOSE_BUTTON));
    }

    private void t8() {
        if (this.a0) {
            h.a.x.e eVar = this.f8721n;
            if (eVar != null) {
                eVar.f();
            }
            this.R = true;
            m1.a(this.C, "OUTPUT_STOP_EXPORTING");
            k0.b().a();
            if (com.xvideostudio.videoeditor.t.h() == 2) {
                h.a.x.e eVar2 = this.f8721n;
                if (eVar2 != null) {
                    eVar2.v0();
                }
                hl.productor.fxlib.h.n0 = false;
                this.S = false;
                com.xvideostudio.videoeditor.tool.f fVar = this.O;
                if (fVar != null && fVar.isShowing()) {
                    this.O.dismiss();
                }
                this.O = null;
                return;
            }
            return;
        }
        com.xvideostudio.videoeditor.tool.m.t(this.C.getResources().getString(2131821780), -1, 1);
        com.xvideostudio.videoeditor.tool.a0.a(1).execute(new u());
    }

    private boolean u6(int i2) {
        String v02 = com.xvideostudio.videoeditor.u.v0(this.C);
        if (!TextUtils.isEmpty(v02)) {
            try {
                JSONArray jSONArray = new JSONArray(v02);
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    if (jSONArray.getJSONObject(i3).getInt("id") == i2) {
                        return true;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void u8() {
        h.a.x.e eVar = this.f8721n;
        if (eVar != null) {
            eVar.j0();
        }
        this.e0.setVisibility(0);
    }

    private boolean v6() {
        VideoMakerApplication.B0(this);
        return false;
    }

    private void v8() {
        if (this.n1 == null) {
            this.n1 = new h0();
        }
        com.xvideostudio.videoeditor.m0.c.c().g(6, this.n1);
        com.xvideostudio.videoeditor.m0.c.c().g(7, this.n1);
        com.xvideostudio.videoeditor.m0.c.c().g(8, this.n1);
        com.xvideostudio.videoeditor.m0.c.c().g(9, this.n1);
    }

    public static Bitmap w6() {
        if (hl.productor.fxlib.h.V && y4.f8898f == null) {
            y4.f8898f = BitmapFactory.decodeResource(VideoEditorApplication.y().getResources(), C1523R$drawable.video_transparency);
        }
        return y4.f8898f;
    }

    /* access modifiers changed from: private */
    /* renamed from: w7 */
    public /* synthetic */ void x7(View view, int i2) {
        EditorAOneAdapter editorAOneAdapter;
        this.p1 = i2;
        this.s1 = 1;
        O7(i2);
        if (this.p1 != this.A0.q()) {
            this.z0.F(-1);
            this.u0.scrollToPosition(0);
        } else {
            this.z0.F(this.q1);
        }
        if (i2 == 0 && (editorAOneAdapter = this.z0) != null) {
            editorAOneAdapter.F(-1);
        }
        if (i2 == 2) {
            com.xvideostudio.videoeditor.u.L1(this.C, false);
        }
    }

    private void w8(int i2, int i3, int i4, boolean z2) {
        com.xvideostudio.videoeditor.r rVar = this.f8722o;
        if (rVar != null && this.f8721n != null && this.f8720m != null) {
            int mediaTotalTime = (int) (rVar.b().getMediaTotalTime() * 1000.0f);
            if (mediaTotalTime == 0) {
                this.f8720m.getTotalDuration();
            }
            ArrayList<MediaClip> clipArray = this.f8720m.getClipArray();
            if (clipArray != null) {
                FxTransEntityNew fxTransEntityNew = null;
                if (z2) {
                    fxTransEntityNew = new FxTransEntityNew();
                    int v2 = com.xvideostudio.videoeditor.l0.c.v(0);
                    fxTransEntityNew.index = 0;
                    fxTransEntityNew.transId = v2;
                    this.f8720m.setTR_CURRENT_VALUES(v2);
                }
                Iterator<MediaClip> it = clipArray.iterator();
                while (it.hasNext()) {
                    MediaClip next = it.next();
                    if (!next.isAppendClip && next.mediaType == VideoEditData.IMAGE_TYPE) {
                        next.duration = i2;
                        next.durationTmp = 0;
                        this.f8720m.isUpDurtion = true;
                        if (z2) {
                            next.fxTransEntityNew = fxTransEntityNew;
                        }
                    }
                }
            }
            if (this.f8720m.getFxThemeU3DEntity() != null && this.f8720m.getFxThemeU3DEntity().fxThemeId > 0 && this.f8720m.getSoundList() != null && this.f8720m.getSoundList().size() == 1 && !this.f8720m.getSoundList().get(0).isCamera && this.f8720m.getSoundList().get(0).isTheme && this.f8720m.getSoundList().get(0).gVideoEndTime >= mediaTotalTime - 150) {
                this.f8720m.getSoundList().get(0).gVideoEndTime = i3;
            }
            y4.b = false;
            this.f8721n.L0(0.0f);
            Message message = new Message();
            message.what = 8;
            this.D1.sendMessage(message);
            d1();
        }
    }

    private int x6() {
        if (this.f8720m != null) {
            for (int i2 = 0; i2 < this.f8720m.getTextList().size(); i2++) {
                if (this.f8720m.getTextList().get(i2).isMarkText) {
                    return 1;
                }
            }
        }
        return 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void x8() {
        if (com.xvideostudio.videoeditor.u.t1(this.C)) {
            this.h0.setVisibility(8);
            if (!com.xvideostudio.videoeditor.u.v1(this.C)) {
                com.xvideostudio.videoeditor.u.a3(this.C, true);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: y7 */
    public /* synthetic */ void z7(View view) {
        t8();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void z0() {
        if (this.f8721n != null) {
            o6();
            if (this.f8721n.h0()) {
                this.f8721n.j0();
            }
            this.f8721n.L0(0.0f);
            this.l1 = true;
            s8(this.f8721n.h0(), false);
        }
    }

    private void z6() {
        if (this.f8721n != null && this.f8722o != null) {
            this.l0 = true;
            y4.b = false;
            Intent intent = new Intent(this.C, EditorClipActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable(MediaDatabase.SERIALIZABLE_EXTRA, this.f8720m);
            float H2 = this.f8721n.H();
            intent.putExtra("editorRenderTime", H2);
            intent.putExtra("editorClipIndex", this.f8722o.e(H2));
            intent.putExtra("glWidthEditor", this.H);
            intent.putExtra("glHeightEditor", this.I);
            intent.putExtra("load_type", this.E0);
            intent.putExtra("startType", "tab_duration");
            intent.putExtras(bundle);
            startActivityForResult(intent, 10);
        }
    }

    @Override // com.xvideostudio.videoeditor.materialdownload.a
    public void A(Object obj) {
        SiteInfoBean siteInfoBean = (SiteInfoBean) obj;
        if (siteInfoBean != null) {
            Message obtainMessage = this.I1.obtainMessage();
            obtainMessage.getData().putInt("materialID", Integer.parseInt(siteInfoBean.materialID));
            obtainMessage.getData().putInt("process", siteInfoBean.getProgress() / 10);
            obtainMessage.what = 5;
            this.I1.sendMessage(obtainMessage);
        }
    }

    public void A6() {
        w6();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        AbstractConfigActivity.r = displayMetrics.widthPixels;
        AbstractConfigActivity.s = displayMetrics.heightPixels;
        Toolbar toolbar = (Toolbar) findViewById(2131297930);
        this.a1 = toolbar;
        toolbar.setTitle(getResources().getText(2131820920));
        T0(this.a1);
        if (M0() != null) {
            M0().s(true);
        }
        this.b1 = false;
        invalidateOptionsMenu();
        this.n0.postDelayed(new d(), 2000);
        this.X = (RelativeLayout) findViewById(C1524R$id.fm_float_container);
        this.Y = (LinearLayout) findViewById(C1524R$id.editor_toolbox_container_cloud_eye);
        Toolbar toolbar2 = this.a1;
        if (!(toolbar2 == null || toolbar2.getMenu().findItem(C1524R$id.action_settings) == null)) {
            this.a1.getMenu().findItem(C1524R$id.action_settings).setVisible(false);
        }
        B6();
        this.f8723p = (RelativeLayout) findViewById(2131297624);
        this.Z = (TextView) findViewById(C1524R$id.tv_fps);
        this.G = true;
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(C1524R$id.fm_editor);
        this.W = relativeLayout;
        relativeLayout.setOnClickListener(new e());
        this.c0 = (TextView) findViewById(C1524R$id.tx_bar_1);
        this.d0 = (TextView) findViewById(C1524R$id.tx_bar_2);
        MSeekbarNew mSeekbarNew = (MSeekbarNew) findViewById(C1524R$id.editor_seekbar);
        this.b0 = mSeekbarNew;
        mSeekbarNew.setTouchable(true);
        this.b0.setProgress(0.0f);
        this.b0.setmOnSeekBarChangeListener(new f());
        Button button = (Button) findViewById(C1524R$id.bt_video_sound_mute);
        this.i0 = button;
        button.setVisibility(4);
        Button button2 = (Button) findViewById(C1524R$id.bt_video_fullscreen);
        this.k0 = button2;
        button2.setOnClickListener(new g());
        this.p0 = (Button) findViewById(C1524R$id.bt_time_batch_editor);
        String str = this.E0;
        if (str != null && str.equals(MessengerShareContentUtility.MEDIA_IMAGE)) {
            this.p0.setVisibility(0);
            this.p0.setOnClickListener(new h());
        }
        this.p0.setVisibility(8);
        this.i0.setOnClickListener(new i());
        this.e0 = (LinearLayout) findViewById(C1524R$id.ll_video_control);
        Button button3 = (Button) findViewById(C1524R$id.bt_video_play);
        this.f0 = button3;
        button3.setOnClickListener(new j());
        Button button4 = (Button) findViewById(C1524R$id.bt_clip_edit_shortcut);
        this.g0 = button4;
        button4.setOnClickListener(this);
        Button button5 = (Button) findViewById(C1524R$id.bt_watermark);
        this.h0 = button5;
        button5.setBackgroundResource(C1523R$drawable.watermarks);
        this.h0.setOnClickListener(new o1(this));
        D6();
        Z7();
        a8(0);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0248  */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x03e1 A[Catch:{ Exception -> 0x04b6 }] */
    public boolean F6() {
        String G2;
        String G3;
        String str;
        Intent intent = getIntent();
        this.E0 = "image/video";
        if (intent.getIntExtra("fileScanOpenType", 0) == 1) {
            MediaDatabase mediaDatabase = (MediaDatabase) getIntent().getSerializableExtra("momentImages");
            this.f8720m = mediaDatabase;
            l6(mediaDatabase.getFxThemeU3DEntity());
            return true;
        }
        String action = intent.getAction();
        if (action == null) {
            return v6();
        }
        if (action.equals(ThirdPartParam.THIRD_PART_PARAM_ACTION_EDIT)) {
            m1.a(this.C, "THIRD_PART_EDIT_ACTION");
            try {
                Bundle bundleExtra = intent.getBundleExtra(ThirdPartParam.THIRD_PART_PARAM_DATA);
                if (bundleExtra == null) {
                    return v6();
                }
                String string = bundleExtra.getString(ThirdPartParam.THIRD_PART_PARAM_PACKAGE_NAME);
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(ThirdPartParam.THIRD_PART_PARAM_INPUT_FILES_PATH);
                String string2 = bundleExtra.getString(ThirdPartParam.THIRD_PART_PARAM_OUTPUT_DIR_PATH);
                String string3 = bundleExtra.getString(ThirdPartParam.THIRD_PART_PARAM_OUTPUT_FILE_NAME);
                String string4 = bundleExtra.getString(ThirdPartParam.THIRD_PART_PARAM_TEMP_DIR_PATH);
                if (string != null && string.equalsIgnoreCase(ThirdPartParam.GV_PACKAGE_NAME)) {
                    m1.a(this.C, "GALLERYVAULT_THIRD_PART_EDIT_ACTION");
                }
                if (stringArrayList != null) {
                    if (stringArrayList.size() != 0) {
                        if (string2 == null) {
                            str = com.xvideostudio.videoeditor.l0.b.Y(3);
                        } else {
                            str = m0.E(string2);
                            if (str != null && !str.equalsIgnoreCase(string2)) {
                                bundleExtra.putString(ThirdPartParam.THIRD_PART_PARAM_OUTPUT_DIR_PATH, str);
                            }
                        }
                        m0.Z(str);
                        if (string4 == null) {
                            string4 = com.xvideostudio.videoeditor.l0.b.q();
                        }
                        m0.Z(string4);
                        this.f8720m = new MediaDatabase(str, string4);
                        VideoEditorApplication.y().f7395g = bundleExtra;
                        this.E0 = "image/video";
                        String str2 = "video export ok";
                        Iterator<String> it = stringArrayList.iterator();
                        int i2 = 1;
                        while (it.hasNext()) {
                            String next = it.next();
                            String str3 = "inputPath:" + next;
                            if (m0.U(next)) {
                                if (!Tools.S(next)) {
                                    if (hl.productor.fxlib.h.X == 0) {
                                        ((VideoEditorApplication) getApplicationContext()).b();
                                    }
                                    if (!m0.Y(this.C, next, false)) {
                                        switch (this.f8720m.addClip(next, this.E0, true)) {
                                            case 1:
                                                com.xvideostudio.videoeditor.tool.m.n(2131822015);
                                                str2 = "video export error, video is too big";
                                                i2 = -2;
                                                break;
                                            case 2:
                                            case 3:
                                                com.xvideostudio.videoeditor.tool.m.n(2131822080);
                                                m1.a(this.C, "NOT_SUPPORTED_FORMAT_VIA_OUT_ACTIVITY");
                                                str2 = "video export error,unsupported video format";
                                                i2 = -4;
                                                break;
                                            case 4:
                                                com.xvideostudio.videoeditor.tool.m.p(2131821018, -1, 1);
                                                str2 = "video export error,unsupported video format";
                                                i2 = -4;
                                                break;
                                            case 5:
                                                com.xvideostudio.videoeditor.tool.m.p(2131821019, -1, 1);
                                                str2 = "video export error,unsupported video format";
                                                i2 = -4;
                                                break;
                                            case 6:
                                                com.xvideostudio.videoeditor.tool.m.p(2131820608, -1, 1);
                                                str2 = "video export error,unsupported video format";
                                                i2 = -4;
                                                break;
                                        }
                                    } else {
                                        return v6();
                                    }
                                } else {
                                    com.xvideostudio.videoeditor.tool.m.n(2131822080);
                                    if (VidCompactThirdPartParam.isInstalledVidCompact(this.C)) {
                                        if (stringArrayList.size() > 1) {
                                            m1.a(this.C, "NOT_SUPPORTED_FORMAT_OPEN_VIA_OUT_ACTIVITY_MULTI");
                                        } else {
                                            m1.a(this.C, "NOT_SUPPORTED_FORMAT_OPEN_VIA_OUT_ACTIVITY");
                                        }
                                        Intent intent2 = new Intent();
                                        intent2.setPackage(VidCompactThirdPartParam.VIDCOMPACT_PACKAGE_NAME);
                                        startActivity(intent2);
                                        finish();
                                        return false;
                                    }
                                    if (stringArrayList.size() > 1) {
                                        m1.a(this.C, "NOT_SUPPORTED_FORMAT_INSTALL_VIA_OUT_ACTIVITY_MULTI");
                                    } else {
                                        m1.a(this.C, "NOT_SUPPORTED_FORMAT_INSTALL_VIA_OUT_ACTIVITY");
                                    }
                                    g.c.b.a.b(this.C, VidCompactThirdPartParam.VIDCOMPACT_INSTALL_URL);
                                    return false;
                                }
                            }
                        }
                        if (i2 != 1) {
                            ThirdPartParam.returnThirdPartApp(this, str + File.separator + string3, i2, str2);
                            finish();
                            ThirdPartParam.exitAppReturnThirdPartApp(this.C);
                        }
                        if (this.f8720m.getClipArray().size() > 0) {
                            return true;
                        }
                        return v6();
                    }
                }
                return v6();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else if (action.equals("android.intent.action.SEND") || action.equals("android.intent.action.SEND_MULTIPLE") || action.equals("android.intent.action.EDIT")) {
            if (action.equals("android.intent.action.SEND")) {
                m1.a(this.C, "EDITOR_ACTIVITY_ACTION_SEND_ALL");
            } else {
                m1.a(this.C, "EDITOR_ACTIVITY_ACTION_EDIT");
            }
            Bundle extras = intent.getExtras();
            if (extras == null || !extras.containsKey("android.intent.extra.STREAM")) {
                if (!((extras != null && extras.containsKey("android.intent.extra.TEXT")) || intent.getData() == null || intent.getData().getPath() == null)) {
                    String N2 = m0.N(this.C, intent.getData());
                    if (N2 == null) {
                        return v6();
                    }
                    String Y2 = com.xvideostudio.videoeditor.l0.b.Y(3);
                    String I2 = VideoEditorApplication.I();
                    File file = new File(Y2);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    this.f8720m = new MediaDatabase(Y2, I2);
                    if (m0.Y(this.C, N2, false)) {
                        return v6();
                    }
                    if (hl.productor.fxlib.h.X == 0) {
                        ((VideoEditorApplication) getApplicationContext()).b();
                    }
                    switch (this.f8720m.addClip(N2, this.E0, true)) {
                        case 0:
                            return true;
                        case 1:
                            com.xvideostudio.videoeditor.tool.m.n(2131822015);
                            return v6();
                        case 2:
                        case 3:
                            com.xvideostudio.videoeditor.tool.m.n(2131822080);
                            m1.a(this.C, "NOT_SUPPORTED_FORMAT_VIA_OUT_ACTIVITY");
                            return v6();
                        case 4:
                            com.xvideostudio.videoeditor.tool.m.p(2131821018, -1, 1);
                            return v6();
                        case 5:
                            com.xvideostudio.videoeditor.tool.m.p(2131821019, -1, 1);
                            return v6();
                        case 6:
                            if (MessengerShareContentUtility.MEDIA_IMAGE.equals(this.E0)) {
                                com.xvideostudio.videoeditor.tool.m.p(2131820608, -1, 1);
                            } else if ("video".equals(this.E0)) {
                                com.xvideostudio.videoeditor.tool.m.p(2131820608, -1, 1);
                            }
                            return v6();
                        case 7:
                            return true;
                    }
                }
                com.xvideostudio.videoeditor.tool.m.t(getResources().getString(2131822083), -1, 1);
                return v6();
            }
            try {
                ArrayList arrayList = new ArrayList();
                if (action.equals("android.intent.action.SEND_MULTIPLE")) {
                    m1.a(this.C, "EDITOR_ACTIVITY_ACTION_SEND_MULTIPLE");
                    arrayList = extras.getParcelableArrayList("android.intent.extra.STREAM");
                } else {
                    m1.a(this.C, "EDITOR_ACTIVITY_ACTION_SEND");
                    Uri uri = (Uri) extras.getParcelable("android.intent.extra.STREAM");
                    if (uri != null) {
                        arrayList.add(uri);
                    }
                }
                if (arrayList != null) {
                    if (arrayList.size() != 0) {
                        String Y3 = com.xvideostudio.videoeditor.l0.b.Y(3);
                        String I3 = VideoEditorApplication.I();
                        File file2 = new File(Y3);
                        if (!file2.exists()) {
                            file2.mkdirs();
                        }
                        this.f8720m = new MediaDatabase(Y3, I3);
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            Uri uri2 = (Uri) it2.next();
                            String R2 = m0.R(this.C, uri2);
                            String str4 = "sendPath-->" + R2;
                            if (R2 == null) {
                                if (uri2.toString().contains("file://")) {
                                    G2 = uri2.getPath();
                                } else {
                                    if (uri2.toString().contains("content://") && (R2 = uri2.getPath()) != null) {
                                        G2 = m0.G(this, uri2);
                                    }
                                    if (R2 == null) {
                                    }
                                }
                                R2 = G2;
                                if (R2 == null) {
                                }
                            }
                            if (Tools.S(R2)) {
                                com.xvideostudio.videoeditor.tool.m.n(2131822080);
                                if (VidCompactThirdPartParam.isInstalledVidCompact(this.C)) {
                                    if (arrayList.size() > 1) {
                                        m1.a(this.C, "NOT_SUPPORTED_FORMAT_OPEN_VIA_OUT_ACTIVITY_MULTI");
                                    } else {
                                        m1.a(this.C, "NOT_SUPPORTED_FORMAT_OPEN_VIA_OUT_ACTIVITY");
                                    }
                                    Intent intent3 = new Intent();
                                    intent3.setPackage(VidCompactThirdPartParam.VIDCOMPACT_PACKAGE_NAME);
                                    startActivity(intent3);
                                    finish();
                                    return false;
                                }
                                if (arrayList.size() > 1) {
                                    m1.a(this.C, "NOT_SUPPORTED_FORMAT_INSTALL_VIA_OUT_ACTIVITY_MULTI");
                                } else {
                                    m1.a(this.C, "NOT_SUPPORTED_FORMAT_INSTALL_VIA_OUT_ACTIVITY");
                                }
                                g.c.b.a.b(this.C, VidCompactThirdPartParam.VIDCOMPACT_INSTALL_URL);
                                return false;
                            } else if (m0.Y(this.C, R2, false)) {
                                return v6();
                            } else {
                                if (hl.productor.fxlib.h.X == 0) {
                                    ((VideoEditorApplication) getApplicationContext()).b();
                                }
                                switch (this.f8720m.addClip(R2, this.E0, true)) {
                                    case 1:
                                        com.xvideostudio.videoeditor.tool.m.n(2131822015);
                                        continue;
                                    case 2:
                                    case 3:
                                        com.xvideostudio.videoeditor.tool.m.n(2131822080);
                                        m1.a(this.C, "NOT_SUPPORTED_FORMAT_VIA_OUT_ACTIVITY");
                                        continue;
                                    case 4:
                                        com.xvideostudio.videoeditor.tool.m.p(2131821018, -1, 1);
                                        continue;
                                    case 5:
                                        com.xvideostudio.videoeditor.tool.m.p(2131821019, -1, 1);
                                        continue;
                                    case 6:
                                        if (!MessengerShareContentUtility.MEDIA_IMAGE.equals(this.E0)) {
                                            if (!"video".equals(this.E0)) {
                                                break;
                                            } else {
                                                com.xvideostudio.videoeditor.tool.m.p(2131820608, -1, 1);
                                                break;
                                            }
                                        } else {
                                            com.xvideostudio.videoeditor.tool.m.p(2131820608, -1, 1);
                                            continue;
                                        }
                                    default:
                                        continue;
                                }
                            }
                        }
                        if (this.f8720m.getClipArray().size() > 0) {
                            return true;
                        }
                        return v6();
                    }
                }
                return v6();
            } catch (Exception e3) {
                e3.toString();
            }
        } else {
            if (action.equals("android.intent.action.VIEW")) {
                Uri data = intent.getData();
                if (data == null) {
                    return v6();
                }
                m1.a(this.C, "EDITOR_ACTIVITY_ACTION_VIEW");
                String N3 = m0.N(this.C, data);
                if (N3 == null) {
                    if (data.toString().contains("file://")) {
                        G3 = data.getPath();
                    } else {
                        if (data.toString().contains("content://") && (N3 = data.getPath()) != null) {
                            G3 = m0.G(this, data);
                        }
                        if (N3 == null) {
                            return v6();
                        }
                    }
                    N3 = G3;
                    if (N3 == null) {
                    }
                }
                if (Tools.S(N3)) {
                    com.xvideostudio.videoeditor.tool.m.n(2131822080);
                    if (VidCompactThirdPartParam.isInstalledVidCompact(this.C)) {
                        m1.a(this.C, "NOT_SUPPORTED_FORMAT_OPEN_VIA_OUT_ACTIVITY");
                        Intent intent4 = new Intent();
                        intent4.setPackage(VidCompactThirdPartParam.VIDCOMPACT_PACKAGE_NAME);
                        startActivity(intent4);
                        finish();
                        return false;
                    }
                    m1.a(this.C, "NOT_SUPPORTED_FORMAT_INSTALL_VIA_OUT_ACTIVITY");
                    g.c.b.a.b(this.C, VidCompactThirdPartParam.VIDCOMPACT_INSTALL_URL);
                    return false;
                }
                String Y4 = com.xvideostudio.videoeditor.l0.b.Y(3);
                String I4 = VideoEditorApplication.I();
                File file3 = new File(Y4);
                if (!file3.exists()) {
                    file3.mkdirs();
                }
                this.f8720m = new MediaDatabase(Y4, I4);
                if (m0.Y(this.C, N3, false)) {
                    return v6();
                }
                if (hl.productor.fxlib.h.X == 0) {
                    ((VideoEditorApplication) getApplicationContext()).b();
                }
                switch (this.f8720m.addClip(N3, this.E0, true)) {
                    case 0:
                        return true;
                    case 1:
                        com.xvideostudio.videoeditor.tool.m.n(2131822015);
                        return v6();
                    case 2:
                    case 3:
                        com.xvideostudio.videoeditor.tool.m.n(2131822080);
                        m1.a(this.C, "NOT_SUPPORTED_FORMAT_VIA_OUT_ACTIVITY");
                        return v6();
                    case 4:
                        com.xvideostudio.videoeditor.tool.m.p(2131821018, -1, 1);
                        return v6();
                    case 5:
                        com.xvideostudio.videoeditor.tool.m.p(2131821019, -1, 1);
                        return v6();
                    case 6:
                        if (MessengerShareContentUtility.MEDIA_IMAGE.equals(this.E0)) {
                            com.xvideostudio.videoeditor.tool.m.p(2131820608, -1, 1);
                        } else if ("video".equals(this.E0)) {
                            com.xvideostudio.videoeditor.tool.m.p(2131820608, -1, 1);
                        }
                        return v6();
                    case 7:
                        return true;
                }
            }
            com.xvideostudio.videoeditor.tool.m.t(getResources().getString(2131822083), -1, 1);
            return v6();
        }
    }

    public boolean G6() {
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = currentTimeMillis - this.z1;
        if (0 < j2 && j2 < 1000) {
            return true;
        }
        this.z1 = currentTimeMillis;
        return false;
    }

    @Override // com.xvideostudio.videoeditor.k0.c
    public void K0(Material material, DialogAdUtils.ImpDownloadSuc impDownloadSuc, int i2) {
        Dialog dialog = DialogAdUtils.toggleEditorAdDialog(this.C, material, impDownloadSuc, i2, 0, 0);
        this.O1 = dialog;
        if (dialog != null) {
            dialog.show();
            VideoEditorApplication.y().f7398j = this;
            this.P1 = true;
        }
    }

    @Override // com.xvideostudio.videoeditor.materialdownload.a
    public synchronized void m0(Exception exc, String str, Object obj) {
        SiteInfoBean siteInfoBean = (SiteInfoBean) obj;
        if (siteInfoBean != null) {
            siteInfoBean.state = 6;
            Bundle bundle = new Bundle();
            bundle.putString("msg", str);
            bundle.putSerializable("item", siteInfoBean);
            Message obtain = Message.obtain();
            obtain.setData(bundle);
            obtain.what = 3;
            this.I1.sendMessage(obtain);
        }
    }

    public void m8() {
        if (com.xvideostudio.videoeditor.tool.w.t(this.C)) {
            h.a.x.e eVar = this.f8721n;
            if (eVar != null && eVar.h0()) {
                s8(this.f8721n.h0(), true);
            }
            new com.xvideostudio.videoeditor.tool.e0.b(this.C, C1523R$drawable.ic_themeedit_tips, 2131820711).showAtLocation(getWindow().getDecorView(), 80, 0, 0);
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Bundle extras;
        int i4;
        MediaDatabase mediaDatabase;
        int i5;
        int i6;
        MediaDatabase mediaDatabase2;
        String str;
        MediaDatabase mediaDatabase3;
        List<SimpleInf> p2;
        SoundEntity soundEntity;
        super.onActivityResult(i2, i3, intent);
        int i7 = 0;
        boolean z2 = false;
        this.b1 = false;
        invalidateOptionsMenu();
        this.n0.postDelayed(new u1(this), 2000);
        if (i2 == 2) {
            if (i3 == 2 || i3 == 6 || i3 == 7 || i3 == 8 || i3 == 9 || i3 == 19) {
                y4.b = true;
                hl.productor.fxlib.h.m0 = false;
                MediaDatabase mediaDatabase4 = (MediaDatabase) intent.getSerializableExtra(MediaDatabase.SERIALIZABLE_EXTRA);
                this.f8720m = mediaDatabase4;
                if (mediaDatabase4.getClipArray().size() > 0) {
                    this.N = -1;
                    this.G = true;
                    this.l0 = false;
                    AbstractConfigActivity.t = 0;
                    AbstractConfigActivity.u = 0;
                    this.f8720m.setCurrentClip(0);
                    this.G0 = this.f8720m.getCurrentClip();
                    MediaDatabase mediaDatabase5 = this.f8720m;
                    mediaDatabase5.isExecution = true;
                    this.b0.setList(mediaDatabase5);
                    this.b0.setMax(((float) this.f8720m.getTotalDuration()) / 1000.0f);
                    com.xvideostudio.videoeditor.r rVar = this.f8722o;
                    if (rVar != null) {
                        rVar.S(this.f8720m);
                    }
                    d1();
                }
            }
            if (i3 == 2) {
                o6();
            }
        } else if (i2 != 3) {
            if (i2 != 4) {
                SoundEntity soundEntity2 = null;
                if (i2 != 5) {
                    if (i2 != 18) {
                        if (i2 != 20) {
                            if (i2 != 21) {
                                switch (i2) {
                                    case 10:
                                        if (intent != null) {
                                            float f2 = this.K0;
                                            if (f2 > 0.0f) {
                                                i6 = (int) (f2 * 1000.0f);
                                            } else {
                                                MediaDatabase mediaDatabase6 = this.f8720m;
                                                i6 = mediaDatabase6 != null ? mediaDatabase6.getTotalDuration() : 0;
                                            }
                                            this.f8720m = (MediaDatabase) intent.getSerializableExtra(MediaDatabase.SERIALIZABLE_EXTRA);
                                            this.w1 = intent.getBooleanExtra("isFromBackgroundAct", false);
                                            if (this.f8720m != null) {
                                                String str2 = "FILE_RESULT_EDITOR_CLIP list size = " + this.f8720m.getClipArray().size();
                                                if (this.f8720m.getClipArray().size() > 0) {
                                                    y4.b = true;
                                                    this.N = -1;
                                                    this.G = true;
                                                    this.l0 = false;
                                                    AbstractConfigActivity.t = 0;
                                                    AbstractConfigActivity.u = 0;
                                                    this.f8720m.setCurrentClip(0);
                                                    this.G0 = this.f8720m.getCurrentClip();
                                                    MediaDatabase mediaDatabase7 = this.f8720m;
                                                    mediaDatabase7.isExecution = true;
                                                    this.b0.setList(mediaDatabase7);
                                                    int totalDuration = this.f8720m.getTotalDuration();
                                                    if (i6 == 0) {
                                                        i6 = totalDuration;
                                                    }
                                                    this.b0.setMax(((float) totalDuration) / 1000.0f);
                                                    if (this.Y0 && (mediaDatabase2 = this.f8720m) != null && mediaDatabase2.hasVideo() && this.Z0 == 1) {
                                                        Y7();
                                                    }
                                                    if (this.f8720m.getFxThemeU3DEntity() != null && this.f8720m.getFxThemeU3DEntity().fxThemeId > 0 && this.f8720m.getSoundList() != null && this.f8720m.getSoundList().size() == 1 && !this.f8720m.getSoundList().get(0).isCamera && this.f8720m.getSoundList().get(0).isTheme && this.f8720m.getSoundList().get(0).gVideoEndTime >= i6 - 150) {
                                                        this.f8720m.getSoundList().get(0).gVideoEndTime = totalDuration;
                                                    }
                                                    d1();
                                                    h8(this.U0, this.G0.videoVolume);
                                                    o6();
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    case 11:
                                        if (i3 == 11) {
                                            y4.b = true;
                                            this.f8720m = (MediaDatabase) intent.getSerializableExtra(MediaDatabase.SERIALIZABLE_EXTRA);
                                            d1();
                                            MediaDatabase mediaDatabase8 = this.f8720m;
                                            if (!(mediaDatabase8 == null || mediaDatabase8.getClipArray() == null || this.f8720m.getClipArray().size() <= 0)) {
                                                this.N = -1;
                                                this.G = true;
                                                this.l0 = false;
                                                AbstractConfigActivity.t = 0;
                                                AbstractConfigActivity.u = 0;
                                                this.f8720m.setCurrentClip(0);
                                                this.G0 = this.f8720m.getCurrentClip();
                                                MediaDatabase mediaDatabase9 = this.f8720m;
                                                mediaDatabase9.isExecution = true;
                                                this.b0.setList(mediaDatabase9);
                                                this.b0.setMax(((float) this.f8720m.getTotalDuration()) / 1000.0f);
                                                d1();
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    case 12:
                                        if (intent != null) {
                                            if (intent.getBooleanExtra("isVideosMuteFlag", false)) {
                                                MediaDatabase mediaDatabase10 = (MediaDatabase) intent.getSerializableExtra(MediaDatabase.SERIALIZABLE_EXTRA);
                                                this.f8720m = mediaDatabase10;
                                                mediaDatabase10.isVideosMute = intent.getBooleanExtra("isVideosMute", false);
                                            } else {
                                                soundEntity2 = (SoundEntity) intent.getSerializableExtra("item");
                                                this.f8720m = (MediaDatabase) intent.getSerializableExtra(MediaDatabase.SERIALIZABLE_EXTRA);
                                            }
                                        } else if (i3 == 0 && intent == null && (soundEntity = MusicActivityNew.M) != null) {
                                            MusicActivityNew.M = null;
                                            soundEntity2 = soundEntity;
                                        }
                                        if (!(intent == null || (mediaDatabase3 = this.f8720m) == null || soundEntity2 == null)) {
                                            if (mediaDatabase3.getSoundList() != null) {
                                                this.f8720m.getSoundList().clear();
                                                this.f8720m.upCameraClipAudio();
                                            }
                                            soundEntity2.gVideoStartTime = 0;
                                            int totalDuration2 = this.f8720m.getTotalDuration();
                                            soundEntity2.gVideoEndTime = totalDuration2;
                                            if (totalDuration2 == 0) {
                                                com.xvideostudio.videoeditor.r rVar2 = this.f8722o;
                                                if (rVar2 == null || rVar2.b() == null) {
                                                    float f3 = this.K0;
                                                    if (f3 > 0.0f) {
                                                        soundEntity2.gVideoEndTime = (int) (f3 * 1000.0f);
                                                    }
                                                } else {
                                                    soundEntity2.gVideoEndTime = (int) (this.f8722o.b().getMediaTotalTime() * 1000.0f);
                                                }
                                            }
                                            this.f8720m.addSoundEntity(soundEntity2);
                                            if (intent.hasExtra("music_main_id") && this.A0 != null) {
                                                int intExtra = intent.getIntExtra("music_main_id", -1);
                                                EditorAOneAdapter editorAOneAdapter = this.A0;
                                                if (!(editorAOneAdapter == null || (p2 = editorAOneAdapter.p()) == null || p2.size() <= 0)) {
                                                    int i8 = 0;
                                                    while (true) {
                                                        if (i8 < p2.size()) {
                                                            if (intExtra == p2.get(i8).id) {
                                                                this.p1 = i8;
                                                            } else {
                                                                i8++;
                                                            }
                                                        }
                                                    }
                                                    this.A0.F(this.p1);
                                                }
                                            }
                                            if (intent.hasExtra("music_id")) {
                                                this.t1 = intent.getIntExtra("music_id", -1);
                                            }
                                        }
                                        MediaDatabase mediaDatabase11 = this.f8720m;
                                        if (mediaDatabase11 != null && mediaDatabase11.getClipArray().size() > 0) {
                                            y4.b = true;
                                            this.N = -1;
                                            this.G = true;
                                            this.l0 = false;
                                            AbstractConfigActivity.t = 0;
                                            AbstractConfigActivity.u = 0;
                                            this.f8720m.setCurrentClip(0);
                                            this.G0 = this.f8720m.getCurrentClip();
                                            MediaDatabase mediaDatabase12 = this.f8720m;
                                            mediaDatabase12.isExecution = true;
                                            this.b0.setList(mediaDatabase12);
                                            this.b0.setMax(((float) this.f8720m.getTotalDuration()) / 1000.0f);
                                            d1();
                                        }
                                        o6();
                                        if (!(soundEntity2 == null || (str = soundEntity2.musicTimeStamp) == null || str.equals(""))) {
                                            j6(this.d1);
                                        }
                                        Message message = new Message();
                                        message.what = 44;
                                        this.D1.sendMessage(message);
                                        return;
                                    case 13:
                                        if (intent == null || !intent.getBooleanExtra("is_complete_setting_video", false)) {
                                            this.k1 = false;
                                            MediaDatabase mediaDatabase13 = this.f8720m;
                                            if (mediaDatabase13 != null) {
                                                hl.productor.fxlib.h.O = mediaDatabase13.background_color;
                                                return;
                                            }
                                            return;
                                        }
                                        AbstractConfigActivity.t = 0;
                                        AbstractConfigActivity.u = 0;
                                        this.G = true;
                                        this.k1 = true;
                                        MediaDatabase mediaDatabase14 = this.f8720m;
                                        if (mediaDatabase14 != null) {
                                            mediaDatabase14.background_color = hl.productor.fxlib.h.O;
                                            mediaDatabase14.setCurrentClip(0);
                                        }
                                        int i9 = hl.productor.fxlib.h.O;
                                        if (i9 == 1) {
                                            hl.productor.fxlib.h.T = -1;
                                        } else if (i9 == 2) {
                                            hl.productor.fxlib.h.T = -16777216;
                                        } else if (i9 == 3) {
                                            hl.productor.fxlib.h.T = -16777216;
                                        } else {
                                            S s2 = h2.e().f().b;
                                            hl.productor.fxlib.h.V = false;
                                            if (s2 != null) {
                                                int i10 = z.a[s2.type.ordinal()];
                                                if (i10 == 1) {
                                                    hl.productor.fxlib.h.T = getResources().getColor(s2.color);
                                                    Iterator<MediaClip> it = this.f8720m.getClipArray().iterator();
                                                    while (it.hasNext()) {
                                                        it.next().setClipImageBKFxColor(s2.n_red / 255.0f, s2.n_green / 255.0f, s2.n_blue / 255.0f);
                                                    }
                                                } else if (i10 == 2 || i10 == 3) {
                                                    hl.productor.fxlib.h.T = -16777216;
                                                    if (s2.type == BackgroundItem.Type.COLOR_GRADIENT) {
                                                        j2.a(s2);
                                                    } else {
                                                        j2.b(s2, AbstractConfigActivity.t, AbstractConfigActivity.u);
                                                    }
                                                    Iterator<MediaClip> it2 = this.f8720m.getClipArray().iterator();
                                                    while (it2.hasNext()) {
                                                        MediaClip next = it2.next();
                                                        if (TextUtils.isEmpty(s2.generatePath)) {
                                                            next.setClipImageBKFxSelfImage();
                                                        } else {
                                                            next.setClipImageBKFxPath(s2.generatePath);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        d1();
                                        return;
                                    case 14:
                                        if (intent != null) {
                                            int intExtra2 = intent.getIntExtra("apply_new_theme_id", 0);
                                            FxThemeU3DEntity r2 = com.xvideostudio.videoeditor.l0.c.r(intExtra2, 0, this.F0, this.f8720m, this.C);
                                            this.g1 = r2;
                                            if (!this.h1 || !K7(r2)) {
                                                i6(intExtra2);
                                            } else {
                                                com.xvideostudio.videoeditor.x0.e0.c0(this, new s1(this, intExtra2), new y0(this));
                                            }
                                            this.U0.m();
                                        }
                                        this.l0 = false;
                                        return;
                                    case 15:
                                        if (i3 == 15) {
                                            y4.b = true;
                                            MediaDatabase mediaDatabase15 = (MediaDatabase) intent.getSerializableExtra(MediaDatabase.SERIALIZABLE_EXTRA);
                                            this.f8720m = mediaDatabase15;
                                            if (mediaDatabase15.getClipArray().size() > 0) {
                                                this.N = -1;
                                                this.G = true;
                                                this.l0 = false;
                                                AbstractConfigActivity.t = 0;
                                                AbstractConfigActivity.u = 0;
                                                this.f8720m.setCurrentClip(0);
                                                this.G0 = this.f8720m.getCurrentClip();
                                                MediaDatabase mediaDatabase16 = this.f8720m;
                                                mediaDatabase16.isExecution = true;
                                                this.b0.setList(mediaDatabase16);
                                                this.b0.setMax(((float) this.f8720m.getTotalDuration()) / 1000.0f);
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    case 16:
                                        if (intent != null) {
                                            z2 = intent.getBooleanExtra("exportend", true);
                                        }
                                        if (z2) {
                                            finish();
                                            return;
                                        } else {
                                            m6();
                                            return;
                                        }
                                    default:
                                        return;
                                }
                            } else {
                                q0 q0Var = this.D0;
                                if (q0Var != null) {
                                    q0Var.c(q6(3));
                                }
                            }
                        } else if (intent != null) {
                            int intExtra3 = intent.getIntExtra("apply_new_material_id", 0);
                            while (true) {
                                if (i7 >= this.z0.p().size()) {
                                    break;
                                } else if (intExtra3 == this.z0.p().get(i7).getMaterial().getId()) {
                                    this.q1 = i7;
                                    this.t1 = -1;
                                    break;
                                } else {
                                    i7++;
                                }
                            }
                            this.z0.F(this.q1);
                            this.A0.F(this.p1);
                            N7(this.z0.p().get(this.q1), this.q1);
                        }
                    } else if (intent != null) {
                        MediaDatabase mediaDatabase17 = (MediaDatabase) intent.getSerializableExtra(MediaDatabase.SERIALIZABLE_EXTRA);
                        this.f8720m = mediaDatabase17;
                        this.G = true;
                        this.l0 = false;
                        AbstractConfigActivity.t = 0;
                        AbstractConfigActivity.u = 0;
                        this.k1 = true;
                        mediaDatabase17.setCurrentClip(0);
                        d1();
                    }
                } else if (intent != null) {
                    float f4 = this.K0;
                    if (f4 > 0.0f) {
                        i5 = (int) (f4 * 1000.0f);
                    } else {
                        MediaDatabase mediaDatabase18 = this.f8720m;
                        i5 = mediaDatabase18 != null ? mediaDatabase18.getTotalDuration() : 0;
                    }
                    MediaDatabase mediaDatabase19 = (MediaDatabase) intent.getSerializableExtra(MediaDatabase.SERIALIZABLE_EXTRA);
                    String str3 = "list size = " + mediaDatabase19.getClipArray().size();
                    MediaDatabase mediaDatabase20 = this.f8720m;
                    MediaClip clip = mediaDatabase20 != null ? mediaDatabase20.getClip(mediaDatabase20.getClipArray().size() - 1) : null;
                    if (clip != null && clip.isAppendClip) {
                        this.f8720m.getClipArray().remove(this.f8720m.getClipArray().size() - 1);
                        soundEntity2 = clip;
                    }
                    for (int i11 = 0; i11 < mediaDatabase19.getClipArray().size(); i11++) {
                        this.f8720m.addClip(mediaDatabase19.getClip(i11).path, mediaDatabase19.getClip(i11).clipType);
                    }
                    if (soundEntity2 != null) {
                        this.f8720m.getClipArray().add(soundEntity2);
                    }
                    if (w4.f8878c && this.f8720m.getFxThemeU3DEntity() != null && this.f8720m.getFxThemeU3DEntity().fxThemeId > 0) {
                        String str4 = this.E0;
                        boolean z3 = str4 != null && str4.equals(MessengerShareContentUtility.MEDIA_IMAGE);
                        MediaDatabase mediaDatabase21 = this.f8720m;
                        mediaDatabase21.initThemeU3D(mediaDatabase21.getFxThemeU3DEntity(), false, z3, false);
                    }
                    if (this.f8720m.getClipArray().size() > 0) {
                        this.f8720m.setCurrentClip(0);
                        this.G0 = this.f8720m.getCurrentClip();
                        MediaDatabase mediaDatabase22 = this.f8720m;
                        mediaDatabase22.isExecution = true;
                        int totalDuration3 = mediaDatabase22.getTotalDuration();
                        if (i5 == 0) {
                            i5 = totalDuration3;
                        }
                        this.b0.setList(this.f8720m);
                        this.b0.setMax(((float) totalDuration3) / 1000.0f);
                        if (w4.f8878c && this.f8720m.getFxThemeU3DEntity() != null && this.f8720m.getFxThemeU3DEntity().fxThemeId > 0 && this.f8720m.getSoundList() != null && this.f8720m.getSoundList().size() == 1 && !this.f8720m.getSoundList().get(0).isCamera && this.f8720m.getSoundList().get(0).isTheme && this.f8720m.getSoundList().get(0).gVideoEndTime >= i5 - 150) {
                            this.f8720m.getSoundList().get(0).gVideoEndTime = totalDuration3;
                        }
                        d1();
                    }
                }
            } else if (intent != null) {
                float f5 = this.K0;
                if (f5 > 0.0f) {
                    i4 = (int) (f5 * 1000.0f);
                } else {
                    MediaDatabase mediaDatabase23 = this.f8720m;
                    i4 = mediaDatabase23 != null ? mediaDatabase23.getTotalDuration() : 0;
                }
                try {
                    this.f8720m = (MediaDatabase) intent.getSerializableExtra(MediaDatabase.SERIALIZABLE_EXTRA);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (this.f8720m != null) {
                    this.Y0 = intent.getBooleanExtra("isEditorToChooseToEditor", false);
                    if (w4.f8878c && (mediaDatabase = this.f8720m) != null && mediaDatabase.getFxThemeU3DEntity() != null && this.f8720m.getFxThemeU3DEntity().fxThemeId > 0) {
                        String str5 = this.E0;
                        boolean z4 = str5 != null && str5.equals(MessengerShareContentUtility.MEDIA_IMAGE);
                        MediaDatabase mediaDatabase24 = this.f8720m;
                        mediaDatabase24.initThemeU3D(mediaDatabase24.getFxThemeU3DEntity(), false, z4, false);
                    }
                    MediaDatabase mediaDatabase25 = this.f8720m;
                    if (!(mediaDatabase25 == null || mediaDatabase25.getClipArray() == null || this.f8720m.getClipArray().size() <= 0)) {
                        int totalDuration4 = this.f8720m.getTotalDuration();
                        if (i4 == 0) {
                            i4 = totalDuration4;
                        }
                        if (w4.f8878c) {
                            this.E0 = "image/video";
                            this.f8720m.load_type = "image/video";
                            Button button = this.p0;
                            if (button != null) {
                                button.setVisibility(8);
                            }
                            if (this.f8720m.getFxThemeU3DEntity() != null && this.f8720m.getFxThemeU3DEntity().fxThemeId > 0 && this.f8720m.getSoundList() != null && this.f8720m.getSoundList().size() == 1 && !this.f8720m.getSoundList().get(0).isCamera && this.f8720m.getSoundList().get(0).isTheme && this.f8720m.getSoundList().get(0).gVideoEndTime >= i4 - 150) {
                                this.f8720m.getSoundList().get(0).gVideoEndTime = totalDuration4;
                            }
                            q0 q0Var2 = this.D0;
                            if (q0Var2 != null) {
                                q0Var2.c(q6(3));
                            }
                        }
                        MediaDatabase mediaDatabase26 = this.f8720m;
                        if (mediaDatabase26 != null && mediaDatabase26.hasVideo() && this.Z0 == 1) {
                            Y7();
                        }
                        MediaDatabase mediaDatabase27 = this.f8720m;
                        if (mediaDatabase27 != null) {
                            mediaDatabase27.setCurrentClip(0);
                            this.G0 = this.f8720m.getCurrentClip();
                            MediaDatabase mediaDatabase28 = this.f8720m;
                            mediaDatabase28.isExecution = true;
                            MSeekbarNew mSeekbarNew = this.b0;
                            if (mSeekbarNew != null) {
                                mSeekbarNew.setList(mediaDatabase28);
                            }
                        }
                        MSeekbarNew mSeekbarNew2 = this.b0;
                        if (mSeekbarNew2 != null) {
                            mSeekbarNew2.setMax(((float) totalDuration4) / 1000.0f);
                        }
                        d1();
                    }
                    o6();
                }
            }
        } else if (intent != null && (extras = intent.getExtras()) != null) {
            int i12 = extras.getInt("filtermode");
            MediaDatabase mediaDatabase29 = this.f8720m;
            if (mediaDatabase29 != null) {
                mediaDatabase29.setmFilterMode(i12);
            }
            MediaDatabase mediaDatabase30 = this.f8720m;
            if (mediaDatabase30 != null) {
                Iterator<MediaClip> it3 = mediaDatabase30.getClipArray().iterator();
                while (it3.hasNext()) {
                    MediaClip next2 = it3.next();
                    if (next2.mediaType == 0) {
                        next2.setFilterMode(i12);
                    }
                }
            }
            com.xvideostudio.videoeditor.tool.m.p(2131820947, -1, 1);
        }
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        String str;
        boolean z2 = false;
        if (VideoEditorApplication.y().f7395g != null) {
            ThirdPartParam.returnThirdPartApp(this, null, 0, "video export cancel");
            finish();
            ThirdPartParam.exitAppReturnThirdPartApp(this.C);
            return;
        }
        p1 p1Var = this.r1;
        if (p1Var != null && p1Var.m()) {
            this.r1.j();
            z0();
        } else if (!isFinishing() && this.f8720m != null) {
            VideoEditorApplication.y().q().z(this.f8720m, true);
            String str2 = z4.a;
            if (str2 != null && !str2.equals("image/video")) {
                z4.b = true;
            }
            String str3 = this.E0;
            if (str3 == null || !str3.equals(MessengerShareContentUtility.MEDIA_IMAGE)) {
                this.E0 = "image/video";
                str = "editor_video";
            } else {
                str = "editor_photo";
            }
            Intent intent = new Intent();
            intent.setClass(this, EditorChooseActivityTab.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable(MediaDatabase.SERIALIZABLE_EXTRA, this.f8720m);
            intent.putExtra("type", "output");
            intent.putExtra("load_type", this.E0);
            intent.putExtra("bottom_show", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            MediaDatabase mediaDatabase = this.f8720m;
            if (mediaDatabase.squareModeEnabled || mediaDatabase.videoMode == 1) {
                z2 = true;
            }
            intent.putExtra("momentType", z2);
            intent.putExtra("editortype", str);
            intent.putExtra("isShowMyStudioAd", true);
            intent.putExtras(bundle);
            startActivityForResult(intent, 4);
        } else if (this.f8720m == null && !isFinishing()) {
            VideoMakerApplication.B0(this);
        }
    }

    public void onClick(View view) {
        if (view.getId() == 2131296443) {
            m1.a(this.C, "CLIP_EDIT_SHORTCUT_CLICK");
            z6();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x030b, code lost:
        if (new java.io.File(r4 + com.xvideostudio.videoeditor.activity.EditorActivity.a2[1] + ".m4a").exists() == false) goto L_0x030d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0267  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0298  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x02a2  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x02ec  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01ed  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x022b  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0260  */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.xvideostudio.videoeditor.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, com.xvideostudio.videoeditor.activity.basic.AbstractConfigActivity
    @SuppressLint({"InvalidWakeLockTag"})
    public void onCreate(Bundle bundle) {
        boolean z2;
        SoundEntity soundEntity;
        MediaDatabase mediaDatabase;
        String str;
        int i2;
        File file;
        MediaDatabase mediaDatabase2;
        StringBuilder sb;
        MediaDatabase mediaDatabase3;
        super.onCreate(bundle);
        y4.b = true;
        W0();
        if (VideoEditorApplication.y() != null) {
            VideoEditorApplication.y().f7395g = null;
        }
        if (!l1.a(this, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            y4.a = getIntent();
            startActivity(new Intent(this, SplashActivity.class));
            finish();
            return;
        }
        this.v1 = this;
        VideoEditorApplication.y().M();
        y1.c("EditorActivity onCreate before:");
        this.n0 = new Handler();
        FxTitleEntity.getFxTitleEntityInstance().resetState();
        VideoEditorApplication.y().q().t();
        if (getIntent() != null && getIntent().hasExtra("draftboxentity")) {
            try {
                Serializable serializableExtra = getIntent().getSerializableExtra("draftboxentity");
                if (serializableExtra != null) {
                    o.a.a.a.b bVar = (o.a.a.a.b) serializableExtra;
                    VideoEditorApplication.y().q().C(bVar);
                    this.f8720m = bVar.a();
                    z2 = true;
                    Tools.c();
                    this.C = this;
                    String str2 = "one_clip=" + getIntent().getStringExtra("isone_clip");
                    if (getIntent() != null && getIntent().hasExtra("goEditorTtemType")) {
                        this.B = getIntent().getIntExtra("goEditorTtemType", -1);
                    }
                    if (getIntent() != null) {
                        this.X0 = getIntent().getIntExtra("contest_id", 0);
                        this.W0 = getIntent().getIntExtra("apply_new_theme_id", 0);
                        this.P0 = getIntent().getStringExtra("name");
                        this.Q0 = getIntent().getIntExtra("ordinal", 0);
                    }
                    if (this.f8720m == null && getIntent() != null) {
                        this.f8720m = (MediaDatabase) getIntent().getSerializableExtra(MediaDatabase.SERIALIZABLE_EXTRA);
                    }
                    if ((com.xvideostudio.videoeditor.u.B1() || com.xvideostudio.videoeditor.c1.b.a || com.xvideostudio.videoeditor.c1.b.b) && !com.xvideostudio.videoeditor.tool.c0.b(this) && (mediaDatabase3 = this.f8720m) != null && mediaDatabase3.getTotalDuration() > 300000 && com.xvideostudio.videoeditor.u.H()) {
                        com.xvideostudio.videoeditor.u.u2();
                        com.xvideostudio.videoeditor.x0.f0.a(this);
                    }
                    soundEntity = (SoundEntity) getIntent().getSerializableExtra("item");
                    if (soundEntity != null) {
                        MediaDatabase mediaDatabase4 = this.f8720m;
                        if (!(mediaDatabase4 == null || mediaDatabase4.getSoundList() == null)) {
                            this.f8720m.getSoundList().clear();
                            this.f8720m.upCameraClipAudio();
                        }
                        soundEntity.gVideoStartTime = 0;
                        int totalDuration = this.f8720m.getTotalDuration();
                        soundEntity.gVideoEndTime = totalDuration;
                        if (totalDuration == 0) {
                            com.xvideostudio.videoeditor.r rVar = this.f8722o;
                            if (rVar == null || rVar.b() == null) {
                                float f2 = this.K0;
                                if (f2 > 0.0f) {
                                    soundEntity.gVideoEndTime = (int) (f2 * 1000.0f);
                                }
                            } else {
                                soundEntity.gVideoEndTime = (int) (this.f8722o.b().getMediaTotalTime() * 1000.0f);
                            }
                        }
                        this.f8720m.addSoundEntity(soundEntity);
                    }
                    mediaDatabase = this.f8720m;
                    if (mediaDatabase != null || TextUtils.isEmpty(mediaDatabase.load_type)) {
                        this.E0 = getIntent().getStringExtra("load_type");
                    } else {
                        this.E0 = this.f8720m.load_type;
                    }
                    this.O0 = getIntent().getBooleanExtra("is_from_editor_choose", false);
                    this.c1 = getIntent().getBooleanExtra("isClipDel", false);
                    this.F0 = getIntent().getStringExtra("editor_mode");
                    if (this.f8720m == null) {
                        if (F6()) {
                            if (!AdsInitUtil.is_ads_init) {
                                AdsInitUtil.is_ads_init = true;
                                AdsInitUtil.initAllAds(this.C, this.n0);
                            }
                        } else {
                            return;
                        }
                    }
                    str = this.F0;
                    if (str != null || str.equalsIgnoreCase("")) {
                        this.F0 = "editor_mode_pro";
                    } else {
                        this.f8720m.isEditorModeEasy = false;
                    }
                    setContentView(C1527R$layout.editor_activity_new);
                    org.greenrobot.eventbus.c.c().p(this);
                    c8();
                    i2 = this.W0;
                    if (i2 > 0) {
                        j6(i2);
                    }
                    MediaDatabase mediaDatabase5 = this.f8720m;
                    if (!(mediaDatabase5 == null || mediaDatabase5.getFxThemeU3DEntity() == null || this.f8720m.getFxThemeU3DEntity().fxThemeId != 600001)) {
                        this.W0 = 0;
                        j6(0);
                    }
                    A6();
                    E6();
                    file = new File(com.xvideostudio.videoeditor.l0.b.Y(3));
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    mediaDatabase2 = this.f8720m;
                    if (mediaDatabase2 != null) {
                        this.b0.setList(mediaDatabase2);
                        this.f8720m.setCurrentClip(0);
                        this.G0 = this.f8720m.getCurrentClip();
                        this.A1 = this.f8720m.isClip1080PExist();
                    }
                    AbstractConfigActivity.t = 0;
                    AbstractConfigActivity.u = 0;
                    y1.c("EditorActivity onCreate after:");
                    if (l2.c(this.C).booleanValue()) {
                        hl.productor.fxlib.h.j0 = false;
                        hl.productor.fxlib.h.k0 = false;
                        this.h0.setVisibility(8);
                    } else {
                        int i3 = hl.productor.fxlib.h.i0;
                        if (i3 == 0) {
                            hl.productor.fxlib.h.k0 = true;
                        } else if (i3 == 1) {
                            hl.productor.fxlib.h.j0 = true;
                            this.h0.setVisibility(8);
                        } else {
                            this.h0.setVisibility(8);
                        }
                    }
                    com.xvideostudio.videoeditor.t.i();
                    if (!z2 && this.f8720m != null) {
                        d1();
                    }
                    o1();
                    sb = new StringBuilder();
                    String str3 = T1;
                    sb.append(str3);
                    sb.append(a2[0]);
                    sb.append(".m4a");
                    if (new File(sb.toString()).exists()) {
                    }
                    Context context = this.C;
                    com.xvideostudio.videoeditor.tool.w.a1(context, false, com.xvideostudio.videoeditor.x0.c0.q(context));
                    Boolean bool = Boolean.FALSE;
                    com.xvideostudio.videoeditor.x0.r2.a.e(Boolean.TRUE, bool, bool, bool, bool, bool, bool);
                    o6();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        z2 = false;
        Tools.c();
        this.C = this;
        String str22 = "one_clip=" + getIntent().getStringExtra("isone_clip");
        this.B = getIntent().getIntExtra("goEditorTtemType", -1);
        if (getIntent() != null) {
        }
        this.f8720m = (MediaDatabase) getIntent().getSerializableExtra(MediaDatabase.SERIALIZABLE_EXTRA);
        com.xvideostudio.videoeditor.u.u2();
        com.xvideostudio.videoeditor.x0.f0.a(this);
        soundEntity = (SoundEntity) getIntent().getSerializableExtra("item");
        if (soundEntity != null) {
        }
        mediaDatabase = this.f8720m;
        if (mediaDatabase != null) {
        }
        this.E0 = getIntent().getStringExtra("load_type");
        this.O0 = getIntent().getBooleanExtra("is_from_editor_choose", false);
        this.c1 = getIntent().getBooleanExtra("isClipDel", false);
        this.F0 = getIntent().getStringExtra("editor_mode");
        if (this.f8720m == null) {
        }
        str = this.F0;
        if (str != null) {
        }
        this.F0 = "editor_mode_pro";
        setContentView(C1527R$layout.editor_activity_new);
        org.greenrobot.eventbus.c.c().p(this);
        c8();
        i2 = this.W0;
        if (i2 > 0) {
        }
        MediaDatabase mediaDatabase52 = this.f8720m;
        this.W0 = 0;
        j6(0);
        A6();
        E6();
        file = new File(com.xvideostudio.videoeditor.l0.b.Y(3));
        if (!file.exists()) {
        }
        mediaDatabase2 = this.f8720m;
        if (mediaDatabase2 != null) {
        }
        AbstractConfigActivity.t = 0;
        AbstractConfigActivity.u = 0;
        y1.c("EditorActivity onCreate after:");
        if (l2.c(this.C).booleanValue()) {
        }
        com.xvideostudio.videoeditor.t.i();
        d1();
        o1();
        sb = new StringBuilder();
        String str32 = T1;
        sb.append(str32);
        sb.append(a2[0]);
        sb.append(".m4a");
        if (new File(sb.toString()).exists()) {
        }
        Context context2 = this.C;
        com.xvideostudio.videoeditor.tool.w.a1(context2, false, com.xvideostudio.videoeditor.x0.c0.q(context2));
        Boolean bool2 = Boolean.FALSE;
        com.xvideostudio.videoeditor.x0.r2.a.e(Boolean.TRUE, bool2, bool2, bool2, bool2, bool2, bool2);
        o6();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C1528R$menu.menu_editor_activity, menu);
        MenuItem findItem = menu.findItem(C1524R$id.action_export);
        findItem.setActionView(C1527R$layout.action_export_item);
        findItem.getActionView().setOnClickListener(new n());
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.xvideostudio.videoeditor.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, com.xvideostudio.videoeditor.activity.basic.AbstractConfigAudioActivity, com.xvideostudio.videoeditor.activity.basic.AbstractConfigActivity
    public void onDestroy() {
        org.greenrobot.eventbus.c.c().r(this);
        l1();
        Bitmap bitmap = y4.f8898f;
        if (bitmap != null && !bitmap.isRecycled()) {
            y4.f8898f.recycle();
            y4.f8898f = null;
        }
        org.greenrobot.eventbus.c.c().l(new com.xvideostudio.videoeditor.d0.e());
        super.onDestroy();
        if (com.xvideostudio.videoeditor.t.h() != 4) {
            hl.productor.fxlib.y.j();
        }
        v8();
        try {
            unregisterReceiver(this.y1);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        Z0();
        Dialog dialog = this.O1;
        if (dialog != null && dialog.isShowing()) {
            this.O1.dismiss();
            this.O1 = null;
        }
    }

    @Override // com.xvideostudio.videoeditor.k0.c
    public void onDialogDismiss(int i2, int i3) {
        this.O1 = null;
        this.P1 = false;
        DialogAdUtils.showRewardDialog(this.v1, "inner_material_vip_once_unlock");
    }

    @Override // com.xvideostudio.videoeditor.k0.c
    public void onDownloadSucDialogDismiss(int i2, int i3) {
        if (i3 > 0) {
            if (this.g1 == null) {
                this.g1 = com.xvideostudio.videoeditor.l0.c.r(i3, 0, this.F0, this.f8720m, this.C);
            }
            if (!this.h1 || !K7(this.g1)) {
                i6(i3);
            } else {
                com.xvideostudio.videoeditor.x0.e0.c0(this, new n1(this, i3), new l0(this));
            }
        }
        DialogAdUtils.showRewardDialog(this.v1, "inner_material_vip_once_unlock");
    }

    @org.greenrobot.eventbus.m(threadMode = ThreadMode.MAIN)
    public void onEventMessage(String str) {
        String str2 = "=============" + str;
        if (str.equalsIgnoreCase(AdConfig.AD_REMOVE_WATER)) {
            this.h0.setVisibility(8);
        } else if (str.equalsIgnoreCase(AdConfig.AD_REMOVE_WATER_FAILED)) {
            com.xvideostudio.videoeditor.tool.m.r(getString(C1532R$string.string_remove_water_failed));
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            onBackPressed();
            return true;
        } else if (itemId == 2131296347) {
            m1.a(this, "CLICK_EDITOR_SCREEN_VIDEO_SETTING");
            if (!com.xvideostudio.videoeditor.u.X(this.C).booleanValue()) {
                com.xvideostudio.videoeditor.u.M2(this.C, Boolean.TRUE);
                menuItem.setIcon(C1523R$drawable.ic_edit_setting);
            }
            Intent intent = new Intent();
            intent.putExtra("glViewWidth", AbstractConfigActivity.t);
            intent.putExtra("glViewHeight", AbstractConfigActivity.u);
            intent.putExtra(MediaDatabase.SERIALIZABLE_EXTRA, this.f8720m);
            intent.setClass(this, EditorSettingsActivity.class);
            startActivityForResult(intent, 18);
            return true;
        } else {
            if (itemId == 2131296352) {
                new b.a(this.C).setTitle("请选择水印AB测试方案").setSingleChoiceItems(new String[]{"watermark_close_sub", "watermark_export_sub"}, -1, new o(this)).show();
            }
            return super.onOptionsItemSelected(menuItem);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.xvideostudio.videoeditor.activity.BaseActivity, androidx.fragment.app.FragmentActivity
    public void onPause() {
        super.onPause();
        this.R0 = false;
        y1.c("EditorActivity onPause before:");
        m1.d(this);
        if (this.S) {
            this.S = false;
            return;
        }
        p1 p1Var = this.r1;
        if (p1Var != null) {
            p1Var.n();
        }
        if (this.l0) {
            c1();
            this.e0.setVisibility(8);
        } else {
            h.a.x.e eVar = this.f8721n;
            if (eVar != null && eVar.h0()) {
                this.f8721n.j0();
            }
        }
        h.a.x.e eVar2 = this.f8721n;
        if (eVar2 != null) {
            eVar2.t0(false);
            if (isFinishing() || this.a0) {
                c1();
            }
        }
        y1.c("EditorActivity onPause after:");
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        if (this.b1) {
            menu.findItem(C1524R$id.action_export).setEnabled(true);
        } else {
            menu.findItem(C1524R$id.action_export).setEnabled(false);
        }
        menu.findItem(C1524R$id.action_settings).setVisible(false);
        if (com.xvideostudio.videoeditor.u.X(this.C).booleanValue()) {
            menu.findItem(C1524R$id.action_settings).setIcon(C1523R$drawable.ic_edit_setting);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
    }

    @Override // com.xvideostudio.videoeditor.activity.BaseActivity, androidx.fragment.app.FragmentActivity
    public void onResume() {
        com.xvideostudio.videoeditor.tool.f fVar;
        h.a.x.e eVar;
        MediaDatabase mediaDatabase;
        super.onResume();
        hl.productor.fxlib.h.n0 = false;
        this.S0 = false;
        VideoEditorApplication.y().f7398j = this;
        y1.c("EditorActivity onResume before:");
        m1.e(this);
        if (!this.S) {
            p1 p1Var = this.r1;
            if (p1Var != null) {
                p1Var.o();
            }
            if (AbstractConfigActivity.t != 0 && AbstractConfigActivity.u != 0 && !this.l0 && !this.m0 && !w4.f8878c && ((fVar = this.O) == null || !fVar.isShowing())) {
                if (!(this.f8722o != null || (eVar = this.f8721n) == null || (mediaDatabase = this.f8720m) == null)) {
                    eVar.F0(0, mediaDatabase.getClipArray().size() - 1);
                    this.f8722o = new com.xvideostudio.videoeditor.r(this, this.f8721n, this.D1);
                }
                h.a.x.e eVar2 = this.f8721n;
                if (eVar2 != null) {
                    boolean h02 = eVar2.h0();
                    if (!this.S && y4.b && !h02) {
                        this.D1.postDelayed(new m0(this, h02), 800);
                    }
                }
            }
            h.a.x.e eVar3 = this.f8721n;
            if (eVar3 != null) {
                eVar3.t0(true);
            }
            if (this.m0) {
                h.a.x.e eVar4 = this.f8721n;
                if (eVar4 != null && !eVar4.h0()) {
                    s8(this.f8721n.h0(), true);
                }
                this.m0 = false;
            }
            y1.c("EditorActivity onResume after:");
            if (com.xvideostudio.videoeditor.u.t1(this.C) || com.xvideostudio.videoeditor.u.P(this.C).booleanValue()) {
                this.h0.setVisibility(8);
            }
            Type type = new t(this).getType();
            Gson gson = new Gson();
            ArrayList arrayList = (ArrayList) gson.fromJson(com.xvideostudio.videoeditor.u.w0(this), type);
            if (arrayList != null && !arrayList.isEmpty()) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    String save_path = ((SimpleInf) it.next()).getMaterial().getSave_path();
                    if (TextUtils.isEmpty(save_path) || !new File(save_path).exists()) {
                        it.remove();
                    }
                }
                com.xvideostudio.videoeditor.u.l3(this, gson.toJson(arrayList));
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(AdConfig.AD_INSTALL_WATERMARK);
        intentFilter.addAction(AdConfig.AD_INSTALL_MATERIAL);
        intentFilter.addAction(AdConfig.AD_DOWNLOAD_TO_GP);
        registerReceiver(this.y1, intentFilter);
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, com.xvideostudio.videoeditor.activity.basic.AbstractConfigActivity
    public void onStop() {
        super.onStop();
        if (!this.S) {
            y1.c("EditorActivity onStop before:");
            l1();
            y1.c("EditorActivity onStop after:");
        }
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override // com.xvideostudio.videoeditor.activity.basic.AbstractConfigActivity
    public void onWindowFocusChanged(boolean z2) {
        String str = "onWindowFocusChanged==============" + z2;
        this.R0 = true;
        if (z2) {
            if (this.G) {
                this.G = false;
                RelativeLayout relativeLayout = this.f8723p;
                if (relativeLayout != null) {
                    AbstractConfigActivity.t = relativeLayout.getWidth();
                    AbstractConfigActivity.u = this.f8723p.getHeight();
                }
                this.J = AbstractConfigActivity.u;
                this.K = AbstractConfigActivity.t;
                h.a.x.e eVar = this.f8721n;
                if (eVar != null) {
                    AbstractConfigActivity.t = eVar.K().getWidth();
                    AbstractConfigActivity.u = this.f8721n.K().getHeight();
                }
                this.B1 = true;
                String str2 = "onWindowFocusChanged glOriginWidth:" + this.K + " glOriginHeight:" + this.J;
                MediaDatabase mediaDatabase = this.f8720m;
                if (mediaDatabase != null) {
                    if (mediaDatabase.getFxThemeU3DEntity() == null || this.f8720m.getFxThemeU3DEntity().fxThemeId <= 1) {
                        n6(false);
                    } else {
                        n6(true);
                    }
                }
                if (VideoEditorApplication.B) {
                    if (this.f8720m.getClipArray().size() > 0) {
                        p1(0, false);
                        this.b0.setMax(((float) this.f8720m.getTotalDuration()) / 1000.0f);
                    }
                    this.n0.postDelayed(new c1(this), 3000);
                }
                if (this.n1 == null) {
                    this.n1 = new h0();
                    X7();
                }
                if (this.c1) {
                    this.c1 = false;
                    com.xvideostudio.videoeditor.x0.e0.v(this.C, getString(2131820898), i1.f8770f);
                }
                k8();
                c8();
            } else {
                if (w4.f8878c) {
                    w4.f8878c = false;
                    MediaDatabase mediaDatabase2 = this.f8720m;
                    if (mediaDatabase2 != null) {
                        mediaDatabase2.addCameraClipAudio();
                    }
                    m6();
                }
                if (!(this.h0 == null || this.f8720m == null)) {
                    if (l2.b(this.C).booleanValue() && this.f8720m.getMarkStickerList().size() == 0 && x6() == 0) {
                        this.h0.setVisibility(0);
                        if (com.xvideostudio.videoeditor.u.e(this.C).booleanValue()) {
                            this.h0.setVisibility(8);
                        } else if (com.xvideostudio.videoeditor.u.c(this.C).booleanValue()) {
                            this.h0.setVisibility(8);
                        }
                    } else {
                        this.h0.setVisibility(8);
                    }
                }
            }
            w4.f8878c = false;
            RecyclerView recyclerView = this.t0;
            if (recyclerView != null && recyclerView.getVisibility() == 0) {
                this.y0.C(this.T);
                if (this.T && this.U) {
                    this.D1.postDelayed(new n4(this), 300);
                }
                this.y0.notifyDataSetChanged();
            }
        }
    }

    public void p1(int i2, boolean z2) {
        MediaDatabase mediaDatabase = this.f8720m;
        if (mediaDatabase != null && i2 < mediaDatabase.getClipArray().size()) {
            this.f8720m.setCurrentClip(i2);
            MediaClip currentClip = this.f8720m.getCurrentClip();
            this.G0 = currentClip;
            if (currentClip == null) {
                this.f8720m.setCurrentClip(0);
                this.G0 = this.f8720m.getCurrentClip();
            }
            this.f8720m.isExecution = true;
        }
    }

    @Override // com.xvideostudio.videoeditor.materialdownload.a
    public void r0(Object obj) {
        SiteInfoBean siteInfoBean = (SiteInfoBean) obj;
        String str = siteInfoBean.sFileName;
        String str2 = siteInfoBean.sFilePath + File.separator + str;
        siteInfoBean.downloadLength = 0;
        Bundle bundle = new Bundle();
        bundle.putInt("materialID", Integer.parseInt(siteInfoBean.materialID));
        Message obtain = Message.obtain();
        obtain.setData(bundle);
        obtain.what = 4;
        this.I1.sendMessage(obtain);
    }

    public void s8(boolean z2, boolean z3) {
        if (this.f8721n != null && this.f8722o != null && !this.o0) {
            if (z2) {
                this.e0.setVisibility(0);
                u8();
                return;
            }
            this.e0.setVisibility(8);
            j1();
            this.f8721n.k0();
            if (this.l1) {
                this.l1 = false;
                this.m1 = true;
            }
            h.a.x.e eVar = this.f8721n;
            if (!(eVar == null || eVar.A() == -1)) {
                this.f8721n.w0(-1);
            }
            if (this.K0 <= 0.0f) {
                this.K0 = this.f8722o.b().getMediaTotalTime();
            }
        }
    }

    @Override // com.xvideostudio.videoeditor.k0.c
    public void v0() {
        this.Q1 = true;
    }

    public boolean y6() {
        this.T = false;
        MediaDatabase mediaDatabase = this.f8720m;
        if (mediaDatabase != null && mediaDatabase.getFxThemeU3DEntity() != null && this.f8720m.getFxThemeU3DEntity().fxThemeId > 1) {
            Iterator<FxThemeU3DEffectEntity> it = this.f8720m.getFxThemeU3DEntity().u3dThemeEffectArr.iterator();
            while (it.hasNext()) {
                int i2 = it.next().type;
                if (i2 == 3) {
                    this.T = true;
                } else if (i2 == 4) {
                    this.T = true;
                }
                if (this.T) {
                    break;
                }
            }
        }
        return this.T;
    }

    @org.greenrobot.eventbus.m(threadMode = ThreadMode.MAIN)
    public void onEventMessage(com.xvideostudio.videoeditor.d0.f fVar) {
        O7(this.p1);
    }

    @org.greenrobot.eventbus.m(threadMode = ThreadMode.MAIN)
    public void onEventMessage(com.xvideostudio.videoeditor.d0.m mVar) {
        o6();
    }

    @org.greenrobot.eventbus.m(threadMode = ThreadMode.MAIN)
    public void onEventMessage(com.xvideostudio.videoeditor.d0.t tVar) {
        onDownloadSucDialogDismiss(tVar.b(), tVar.a());
    }

    @org.greenrobot.eventbus.m(threadMode = ThreadMode.MAIN)
    public void onEventMessage(com.xvideostudio.videoeditor.d0.s sVar) {
        onDialogDismiss(0, 0);
    }
}