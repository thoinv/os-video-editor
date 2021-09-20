package com.xvideostudio.videoeditor.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.b;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.content.FileProvider;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.funcamerastudio.videomaker.C1521R$color;
import com.funcamerastudio.videomaker.C1523R$drawable;
import com.funcamerastudio.videomaker.C1524R$id;
import com.funcamerastudio.videomaker.C1527R$layout;
import com.funcamerastudio.videomaker.C1528R$menu;
import com.funcamerastudio.videomaker.C1532R$string;
import com.funcamerastudio.videomaker.C1533R$style;
import com.mopub.mobileads.VastVideoViewController;
import com.xvideostudio.videoeditor.VideoEditorApplication;
import com.xvideostudio.videoeditor.activity.Tools;
import com.xvideostudio.videoeditor.activity.basic.AbstractConfigActivity;
import com.xvideostudio.videoeditor.adapter.o2;
import com.xvideostudio.videoeditor.entity.FxMediaClipEntity;
import com.xvideostudio.videoeditor.tool.MSeekbarNew;
import com.xvideostudio.videoeditor.tool.SpeedMSeekbarNew;
import com.xvideostudio.videoeditor.view.RobotoBoldButton;
import com.xvideostudio.videoeditor.view.SeekVolume;
import com.xvideostudio.videoeditor.view.SetTextSizeView;
import com.xvideostudio.videoeditor.view.SplitSeekBar;
import com.xvideostudio.videoeditor.view.StoryBoardViewOne;
import com.xvideostudio.videoeditor.view.TrimSeekBar;
import com.xvideostudio.videoeditor.view.ZoomImageView;
import com.xvideostudio.videoeditor.x0.b2;
import com.xvideostudio.videoeditor.x0.m1;
import com.xvideostudio.videoeditor.x0.z0;
import hl.productor.ffmpeg.SerializeEditData;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import org.stagex.danmaku.helper.SystemUtility;
import org.xvideo.videoeditor.database.MediaClip;
import org.xvideo.videoeditor.database.MediaDatabase;
import org.xvideo.videoeditor.database.SoundEntity;
import org.xvideo.videoeditor.database.VideoEditData;

public class EditorClipActivity extends AbstractConfigActivity implements View.OnClickListener, StoryBoardViewOne.a, StoryBoardViewOne.b, o2.e, SetTextSizeView.a {
    public static int M1;
    private RelativeLayout A0;
    private float A1;
    public int B = 1;
    private CardView B0;
    protected SetTextSizeView B1;
    boolean C = false;
    private CardView C0;
    private TextView C1;
    private Button D;
    private LinearLayout D0;
    private Button D1;
    ArrayList<String> E;
    private LinearLayout E0;
    protected Dialog E1;
    ArrayList<String> F;
    private LinearLayout F0;
    protected RelativeLayout F1;
    String G;
    private LinearLayout G0;
    protected TextView G1;
    String H;
    private SwitchCompat H0;
    protected TextView H1;
    String I;
    private int I0 = 0;
    protected SpeedMSeekbarNew I1;
    int J = 0;
    private TextView J0;
    private Float J1;
    int K = 0;
    private SeekBar K0;
    private SeekVolume K1;
    int L;
    private RelativeLayout L0;
    private Thread L1 = new Thread(new z());
    int M;
    private TextView M0;
    boolean N = false;
    private TextView N0;
    Dialog O = null;
    private TextView O0;
    ProgressBar P = null;
    private RelativeLayout P0;
    TextView Q = null;
    private View Q0;
    TextView R = null;
    private Button R0;
    boolean S = false;
    private int S0;
    int T = -1;
    private TrimSeekBar T0;
    private Context U;
    private SplitSeekBar U0;
    private RelativeLayout V;
    private boolean V0;
    private Button W;
    private boolean W0;
    private Button X;
    private String X0;
    private int Y = 0;
    private boolean Y0;
    private boolean Z = false;
    private MediaClip Z0;
    private MediaClip a0;
    private MediaClip a1;
    private int b0;
    private int b1;
    private int c0;
    private boolean c1;
    private int d0;
    private Boolean d1 = Boolean.FALSE;
    private MediaClip e0;
    private Toolbar e1;
    private MediaClip f0;
    private int f1 = 1;
    private ZoomImageView g0;
    private boolean g1 = false;
    private h.a.b h0 = new h.a.b();
    private MediaClip h1;
    private int i0;
    private boolean i1;
    private int j0;
    private boolean j1 = false;
    private ArrayList<MediaClip> k0 = new ArrayList<>();
    private float k1 = 0.0f;
    private Handler l0;
    private boolean l1 = false;
    private Handler m0;
    private ArrayList<MediaClip> m1;
    private ViewGroup n0;
    public boolean n1 = false;
    private RelativeLayout o0;
    private ZoomImageView.b o1 = new k();
    private int p0 = 0;
    private int p1 = 0;
    private StoryBoardViewOne q0;
    private int q1 = 0;
    private View r0;
    private RelativeLayout r1;
    private int s0 = 20;
    private com.xvideostudio.videoeditor.r s1;
    private boolean t0 = false;
    private boolean t1 = false;
    private boolean u0 = false;
    private MediaDatabase u1;
    private boolean v0 = false;
    private boolean v1 = false;
    private TextView w0;
    private boolean w1 = false;
    private TextView x0;
    private boolean x1 = false;
    private MSeekbarNew y0;
    @SuppressLint({"HandlerLeak"})
    final Handler y1 = new l();
    private LinearLayout z0;
    private View.OnClickListener z1 = new g0();

    /* access modifiers changed from: package-private */
    public class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            EditorClipActivity.this.d4();
        }
    }

    /* access modifiers changed from: package-private */
    public class a0 implements TrimSeekBar.a {

        class a implements Runnable {
            a() {
            }

            public void run() {
                if (((AbstractConfigActivity) EditorClipActivity.this).f8721n != null) {
                    ((AbstractConfigActivity) EditorClipActivity.this).f8721n.N0(false);
                }
            }
        }

        class b implements Runnable {
            b() {
            }

            public void run() {
                String str = "$$Start this loop! startTime :" + EditorClipActivity.this.a0.startTime;
                int i2 = 0;
                while (true) {
                    if (i2 >= 1000) {
                        break;
                    }
                    int C = ((AbstractConfigActivity) EditorClipActivity.this).f8721n.C();
                    if (EditorClipActivity.this.S0 == 0) {
                        if (C == EditorClipActivity.this.a0.startTime) {
                            String str2 = "$$Skip this loop curMediaClip.startTime :" + C;
                        } else {
                            String str3 = "$$Update starttime:" + C + " |startTime :" + EditorClipActivity.this.a0.startTime;
                            if (C != 0 && Math.abs(EditorClipActivity.this.a0.startTime - C) < 5000) {
                                EditorClipActivity.this.a0.startTime = C;
                            }
                        }
                    } else if (EditorClipActivity.this.S0 == 1) {
                        break;
                    }
                    i2++;
                }
                EditorClipActivity.this.T0.setTriming(true);
                String str4 = "mTrimSeekBar MotionEvent.ACTION_UP2:" + EditorClipActivity.this.a0.startTime + "," + EditorClipActivity.this.a0.endTime;
            }
        }

        class c implements Runnable {
            c() {
            }

            public void run() {
                EditorClipActivity.this.c1 = false;
            }
        }

        a0() {
        }

        @Override // com.xvideostudio.videoeditor.view.TrimSeekBar.a
        public void a(TrimSeekBar trimSeekBar, float f2) {
            if (((AbstractConfigActivity) EditorClipActivity.this).f8721n != null) {
                ((AbstractConfigActivity) EditorClipActivity.this).f8721n.N0(true);
            }
            int i2 = (EditorClipActivity.this.a0.endTime == 0 ? EditorClipActivity.this.a0.duration : EditorClipActivity.this.a0.endTime) - EditorClipActivity.this.a0.startTime;
            if (i2 < 0) {
                i2 = 0;
            }
            int i3 = (int) (((float) i2) * f2);
            if (((AbstractConfigActivity) EditorClipActivity.this).f8721n != null) {
                ((AbstractConfigActivity) EditorClipActivity.this).f8721n.L0(((float) i3) / 1000.0f);
            }
            EditorClipActivity.this.O0.setText(EditorClipActivity.this.p4(i3));
        }

        @Override // com.xvideostudio.videoeditor.view.TrimSeekBar.a
        public void b(TrimSeekBar trimSeekBar) {
            EditorClipActivity.this.W0 = false;
            if (((AbstractConfigActivity) EditorClipActivity.this).f8721n != null) {
                trimSeekBar.postDelayed(new a(), 200);
                ((AbstractConfigActivity) EditorClipActivity.this).f8721n.k0();
            }
            EditorClipActivity.this.O0.setVisibility(0);
        }

        @Override // com.xvideostudio.videoeditor.view.TrimSeekBar.a
        public void c(TrimSeekBar trimSeekBar, float f2, float f3, int i2, MotionEvent motionEvent) {
            if (((AbstractConfigActivity) EditorClipActivity.this).f8721n != null && EditorClipActivity.this.a0 != null) {
                if (i2 == 0) {
                    EditorClipActivity.this.a0.startTime = (int) (((float) EditorClipActivity.this.a0.duration) * f2);
                    if (EditorClipActivity.this.a0.endTime <= 0 || EditorClipActivity.this.a0.endTime > EditorClipActivity.this.a0.duration) {
                        EditorClipActivity.this.a0.endTime = (int) (((float) EditorClipActivity.this.a0.duration) * f3);
                    }
                    if (EditorClipActivity.this.a0.startTime > EditorClipActivity.this.a0.endTime) {
                        EditorClipActivity.this.a0.endTime = EditorClipActivity.this.a0.startTime;
                    }
                } else if (i2 == 1) {
                    if (EditorClipActivity.this.a0.startTime <= 0 || EditorClipActivity.this.a0.startTime > EditorClipActivity.this.a0.duration) {
                        EditorClipActivity.this.a0.startTime = (int) (((float) EditorClipActivity.this.a0.duration) * f2);
                    }
                    EditorClipActivity.this.a0.endTime = (int) (((float) EditorClipActivity.this.a0.duration) * f3);
                    if (EditorClipActivity.this.a0.endTime < EditorClipActivity.this.a0.startTime) {
                        EditorClipActivity.this.a0.endTime = EditorClipActivity.this.a0.startTime;
                    }
                }
                String str = "mTrimSeekBar thumb:" + i2 + " minValue:" + f2 + " maxValue:" + f3 + " startTime:" + EditorClipActivity.this.a0.startTime + " endTime:" + EditorClipActivity.this.a0.endTime;
                if (EditorClipActivity.this.a0.startTime > EditorClipActivity.this.a0.endTime) {
                    EditorClipActivity.this.a0.endTime = EditorClipActivity.this.a0.startTime;
                }
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            String str2 = "mTrimSeekBar MotionEvent.ACTION_MOVE thumb:" + i2;
                            if (i2 == -1) {
                                TextView textView = EditorClipActivity.this.O0;
                                EditorClipActivity editorClipActivity = EditorClipActivity.this;
                                textView.setText(editorClipActivity.p4(editorClipActivity.a0.getClipDuration()));
                            } else if (i2 == 0) {
                                TextView textView2 = EditorClipActivity.this.O0;
                                EditorClipActivity editorClipActivity2 = EditorClipActivity.this;
                                textView2.setText(editorClipActivity2.p4(editorClipActivity2.a0.getClipDuration()));
                                TextView textView3 = EditorClipActivity.this.M0;
                                EditorClipActivity editorClipActivity3 = EditorClipActivity.this;
                                textView3.setText(editorClipActivity3.p4(editorClipActivity3.a0.startTime));
                                ((AbstractConfigActivity) EditorClipActivity.this).f8721n.L0(((float) EditorClipActivity.this.a0.startTime) / 1000.0f);
                            } else {
                                TextView textView4 = EditorClipActivity.this.N0;
                                EditorClipActivity editorClipActivity4 = EditorClipActivity.this;
                                textView4.setText(editorClipActivity4.p4(editorClipActivity4.a0.endTime));
                                TextView textView5 = EditorClipActivity.this.O0;
                                EditorClipActivity editorClipActivity5 = EditorClipActivity.this;
                                textView5.setText(editorClipActivity5.p4(editorClipActivity5.a0.getClipDuration()));
                                ((AbstractConfigActivity) EditorClipActivity.this).f8721n.L0(((float) EditorClipActivity.this.a0.endTime) / 1000.0f);
                            }
                            EditorClipActivity editorClipActivity6 = EditorClipActivity.this;
                            editorClipActivity6.b1 = editorClipActivity6.a0.startTime;
                            EditorClipActivity.this.t0 = true;
                            return;
                        } else if (action != 3) {
                            return;
                        }
                    }
                    System.gc();
                    if (!EditorClipActivity.this.L1.isAlive()) {
                        if (!EditorClipActivity.this.w1) {
                            EditorClipActivity.this.L1.start();
                            EditorClipActivity.this.w1 = true;
                        } else {
                            EditorClipActivity.this.L1.run();
                        }
                    }
                    EditorClipActivity.this.O0.setVisibility(0);
                    if (((AbstractConfigActivity) EditorClipActivity.this).f8721n.h0()) {
                        EditorClipActivity.this.W.setVisibility(8);
                    } else {
                        EditorClipActivity.this.W.setVisibility(0);
                    }
                    if (EditorClipActivity.this.S0 != -1) {
                        String str3 = "mTrimSeekBar MotionEvent.ACTION_UP1:" + EditorClipActivity.this.S0 + "," + EditorClipActivity.this.a0.startTime + "," + EditorClipActivity.this.a0.endTime;
                        EditorClipActivity.this.l0.post(new b());
                    }
                    EditorClipActivity.this.l0.postDelayed(new c(), 100);
                    return;
                }
                EditorClipActivity.this.c1 = true;
                String str4 = "mTrimSeekBar MotionEvent.ACTION_DOWN thumb:" + i2;
                EditorClipActivity.this.S0 = i2;
                TextView textView6 = EditorClipActivity.this.O0;
                EditorClipActivity editorClipActivity7 = EditorClipActivity.this;
                textView6.setText(editorClipActivity7.p4(editorClipActivity7.a0.getClipDuration()));
                EditorClipActivity.this.O0.setVisibility(0);
                if (i2 != -1) {
                    if (((AbstractConfigActivity) EditorClipActivity.this).f8721n.h0()) {
                        ((AbstractConfigActivity) EditorClipActivity.this).f8721n.j0();
                        EditorClipActivity.this.T0.setTriming(true);
                    }
                    EditorClipActivity.this.n0.setVisibility(0);
                    EditorClipActivity.this.W.setVisibility(8);
                    EditorClipActivity editorClipActivity8 = EditorClipActivity.this;
                    if (editorClipActivity8.B == 3) {
                        editorClipActivity8.e0 = editorClipActivity8.g0.h(EditorClipActivity.this.e0, false);
                        EditorClipActivity.this.g0.setIsZommTouch(false);
                    }
                    EditorClipActivity.this.e0.startTime = 0;
                    EditorClipActivity.this.e0.endTime = EditorClipActivity.this.e0.duration;
                    EditorClipActivity.this.z4();
                    if (EditorClipActivity.this.f1 == 1) {
                        m1.a(EditorClipActivity.this.U, "CLICK_EDITORCLIP_TRIM");
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class b implements SeekBar.OnSeekBarChangeListener {
        b() {
        }

        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            String str = "onProgressChanged  curprogress" + EditorClipActivity.this.s0;
            if (i2 <= 99) {
                int i3 = i2 + 1;
                EditorClipActivity.this.s0 = i3;
                EditorClipActivity.this.J0.setText(z0.d(((float) i3) / 10.0f) + "s");
                return;
            }
            EditorClipActivity.this.s0 = 101;
            EditorClipActivity.this.J0.setText(z0.d(((float) 100) / 10.0f) + "s");
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            String str = "onStopTrackingTouch curprogress" + EditorClipActivity.this.s0;
            m1.a(EditorClipActivity.this.U, "CLICK_EDITORCLIP_DURATION");
            if (EditorClipActivity.this.s0 >= 101) {
                EditorClipActivity.this.s0 = 100;
                EditorClipActivity.this.g5((EditorClipActivity.this.s0 * 1000) / 10, com.xvideostudio.videoeditor.tool.w.R(EditorClipActivity.this.U));
                EditorClipActivity.this.V4();
                return;
            }
            EditorClipActivity.this.g5((EditorClipActivity.this.s0 * 1000) / 10, com.xvideostudio.videoeditor.tool.w.R(EditorClipActivity.this.U));
            m1.a(EditorClipActivity.this.U, "CLICK_EDITORCLIP_DURATION");
        }
    }

    /* access modifiers changed from: package-private */
    public class b0 implements SplitSeekBar.a {

        class a implements Runnable {
            a() {
            }

            public void run() {
                EditorClipActivity.this.c1 = false;
            }
        }

        b0() {
        }

        /* access modifiers changed from: private */
        /* renamed from: d */
        public /* synthetic */ void e() {
            if (EditorClipActivity.this.a0.startTime > EditorClipActivity.this.a0.endTime) {
                EditorClipActivity.this.a0.endTime = EditorClipActivity.this.a0.startTime;
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: f */
        public /* synthetic */ void g() {
            EditorClipActivity.this.a0.startTime = Tools.N(EditorClipActivity.this.a0.path, EditorClipActivity.this.a0.startTime, Tools.q.mode_closer);
            if (EditorClipActivity.this.m0 != null) {
                EditorClipActivity.this.m0.post(new t2(this));
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: h */
        public /* synthetic */ void i() {
            if (((AbstractConfigActivity) EditorClipActivity.this).f8721n != null) {
                ((AbstractConfigActivity) EditorClipActivity.this).f8721n.N0(false);
            }
        }

        @Override // com.xvideostudio.videoeditor.view.SplitSeekBar.a
        public void a(SplitSeekBar splitSeekBar, float f2) {
            if (((AbstractConfigActivity) EditorClipActivity.this).f8721n != null) {
                ((AbstractConfigActivity) EditorClipActivity.this).f8721n.N0(true);
            }
            int i2 = EditorClipActivity.this.d0 - EditorClipActivity.this.c0;
            if (i2 < 0) {
                i2 = 0;
            }
            int i3 = (int) (((float) i2) * f2);
            if (((AbstractConfigActivity) EditorClipActivity.this).f8721n != null) {
                ((AbstractConfigActivity) EditorClipActivity.this).f8721n.L0(((float) i3) / 1000.0f);
            }
            EditorClipActivity.this.O0.setText(EditorClipActivity.this.p4(i3));
        }

        @Override // com.xvideostudio.videoeditor.view.SplitSeekBar.a
        public void b(SplitSeekBar splitSeekBar) {
            EditorClipActivity.this.W0 = false;
            if (((AbstractConfigActivity) EditorClipActivity.this).f8721n != null) {
                splitSeekBar.postDelayed(new u2(this), 200);
                ((AbstractConfigActivity) EditorClipActivity.this).f8721n.j0();
            }
            EditorClipActivity.this.O0.setVisibility(0);
            EditorClipActivity.this.P0.setVisibility(0);
            EditorClipActivity.this.Q0.setVisibility(0);
            EditorClipActivity.this.D1.setVisibility(8);
        }

        @Override // com.xvideostudio.videoeditor.view.SplitSeekBar.a
        public void c(SplitSeekBar splitSeekBar, float f2, MotionEvent motionEvent) {
            if (((AbstractConfigActivity) EditorClipActivity.this).f8721n != null && EditorClipActivity.this.a0 != null) {
                int i2 = (int) (((float) (EditorClipActivity.this.d0 - EditorClipActivity.this.c0)) * f2);
                EditorClipActivity.this.a0.endTime = EditorClipActivity.this.c0 + i2;
                String str = "mSplitSeekBar thumbValue:" + f2 + " startTime:" + EditorClipActivity.this.a0.startTime + " endTime:" + EditorClipActivity.this.a0.endTime;
                com.xvideostudio.videoeditor.tool.a0.a(1).execute(new v2(this));
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            EditorClipActivity editorClipActivity = EditorClipActivity.this;
                            editorClipActivity.b1 = editorClipActivity.a0.startTime;
                            EditorClipActivity.this.t0 = true;
                            ((AbstractConfigActivity) EditorClipActivity.this).f8721n.L0(((float) i2) / 1000.0f);
                            EditorClipActivity.this.O0.setText(EditorClipActivity.this.p4(i2));
                            return;
                        } else if (action != 3) {
                            return;
                        }
                    }
                    EditorClipActivity.this.O0.setVisibility(0);
                    if (((AbstractConfigActivity) EditorClipActivity.this).f8721n.h0()) {
                        EditorClipActivity.this.W.setVisibility(8);
                    } else {
                        EditorClipActivity.this.W.setVisibility(0);
                    }
                    EditorClipActivity.this.U0.setTriming(true);
                    EditorClipActivity.this.l0.postDelayed(new a(), 100);
                    return;
                }
                EditorClipActivity.this.c1 = true;
                if (((AbstractConfigActivity) EditorClipActivity.this).f8721n.h0()) {
                    ((AbstractConfigActivity) EditorClipActivity.this).f8721n.j0();
                    EditorClipActivity.this.U0.setTriming(true);
                }
                ((AbstractConfigActivity) EditorClipActivity.this).f8721n.L0(((float) i2) / 1000.0f);
                EditorClipActivity.this.O0.setVisibility(0);
                EditorClipActivity.this.O0.setText(EditorClipActivity.this.p4(i2));
                EditorClipActivity.this.n0.setVisibility(0);
                EditorClipActivity.this.W.setVisibility(8);
                EditorClipActivity.this.e0.startTime = EditorClipActivity.this.a0.startTime;
                EditorClipActivity.this.e0.endTime = EditorClipActivity.this.a0.endTime;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class c implements CompoundButton.OnCheckedChangeListener {
        c() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                EditorClipActivity.this.I0 = 1;
            } else {
                EditorClipActivity.this.I0 = 0;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class c0 implements View.OnClickListener {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Dialog f8001f;

        c0(Dialog dialog) {
            this.f8001f = dialog;
        }

        public void onClick(View view) {
            this.f8001f.dismiss();
            String str = z4.a;
            if (str != null && !str.equals("image/video")) {
                z4.b = true;
            }
            m1.a(EditorClipActivity.this.U, "EDITOR_CLIP_CLICK_ADD_EDITOR_CHOOSE");
            MediaDatabase mediaDatabase = EditorClipActivity.this.f8720m;
            mediaDatabase.deleteClip(mediaDatabase.getClipsSize("image/video") - 1);
            Intent intent = new Intent();
            intent.setClass(EditorClipActivity.this.U, EditorChooseActivityTab.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable(MediaDatabase.SERIALIZABLE_EXTRA, EditorClipActivity.this.f8720m);
            intent.putExtra("type", "editorClip");
            intent.putExtra("load_type", "image/video");
            intent.putExtra("bottom_show", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            intent.putExtra("isAddClip", true);
            intent.putExtra("isEditorAddClip", true);
            MediaDatabase mediaDatabase2 = EditorClipActivity.this.f8720m;
            intent.putExtra("momentType", mediaDatabase2.squareModeEnabled || mediaDatabase2.videoMode == 1);
            intent.putExtra("editortype", "editor_video");
            intent.putExtras(bundle);
            EditorClipActivity.this.startActivityForResult(intent, 1);
        }
    }

    /* access modifiers changed from: package-private */
    public class d implements View.OnClickListener {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ EditText f8003f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ Dialog f8004g;

        d(EditText editText, Dialog dialog) {
            this.f8003f = editText;
            this.f8004g = dialog;
        }

        public void onClick(View view) {
            float parseFloat = (TextUtils.isEmpty(this.f8003f.getText().toString()) || this.f8003f.getText().toString().trim().equals(".")) ? 10.0f : Float.parseFloat(this.f8003f.getText().toString());
            String str = "onClick duration为" + parseFloat;
            if (parseFloat > 3600.0f || parseFloat < 0.1f) {
                com.xvideostudio.videoeditor.tool.m.n(2131820845);
                return;
            }
            EditorClipActivity.this.s0 = (int) (parseFloat * 10.0f);
            EditorClipActivity.this.g5((EditorClipActivity.this.s0 * 1000) / 10, com.xvideostudio.videoeditor.tool.w.R(EditorClipActivity.this.U));
            EditorClipActivity.this.J0.setText(z0.d(((float) EditorClipActivity.this.s0) / 10.0f) + "s");
            if (EditorClipActivity.this.s0 <= 101) {
                EditorClipActivity.this.K0.setProgress(EditorClipActivity.this.s0 - 1);
            }
            this.f8004g.dismiss();
        }
    }

    /* access modifiers changed from: package-private */
    public class d0 implements View.OnClickListener {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Dialog f8006f;

        d0(Dialog dialog) {
            this.f8006f = dialog;
        }

        public void onClick(View view) {
            this.f8006f.dismiss();
            MediaDatabase mediaDatabase = EditorClipActivity.this.f8720m;
            mediaDatabase.deleteClip(mediaDatabase.getClipsSize("image/video") - 1);
            m1.a(EditorClipActivity.this.U, "EDITOR_CLIP_CLICK_ADD_NEW_BLANK_CLIPS");
            Intent intent = new Intent();
            intent.setClass(EditorClipActivity.this.U, PaintNewClipActivity.class);
            intent.putExtra("type", "isFromEditorActivity");
            intent.putExtra("isAddClip", true);
            intent.putExtra("glWidthEditor", AbstractConfigActivity.t);
            intent.putExtra("glHeightEditor", AbstractConfigActivity.u);
            intent.putExtra("clips_number", EditorClipActivity.this.f8720m.getClipArray().size());
            Bundle bundle = new Bundle();
            bundle.putSerializable(MediaDatabase.SERIALIZABLE_EXTRA, EditorClipActivity.this.f8720m);
            intent.putExtras(bundle);
            EditorClipActivity.this.startActivityForResult(intent, 1);
        }
    }

    /* access modifiers changed from: package-private */
    public class e implements View.OnClickListener {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ EditText f8008f;

        e(EditorClipActivity editorClipActivity, EditText editText) {
            this.f8008f = editText;
        }

        public void onClick(View view) {
            Float f2;
            if (!TextUtils.isEmpty(this.f8008f.getText().toString())) {
                f2 = Float.valueOf(Float.parseFloat(this.f8008f.getText().toString()));
            } else {
                f2 = Float.valueOf(10.0f);
            }
            if (f2.floatValue() >= 1.2f) {
                this.f8008f.setText(String.valueOf(Float.valueOf(f2.floatValue() - 1.0f)));
            }
        }
    }

    class e0 implements Runnable {
        e0() {
        }

        public void run() {
            if (EditorClipActivity.this.f0 != null) {
                int i2 = EditorClipActivity.this.f0.endTime != 0 ? EditorClipActivity.this.f0.endTime : EditorClipActivity.this.f0.duration;
                TextView textView = EditorClipActivity.this.O0;
                EditorClipActivity editorClipActivity = EditorClipActivity.this;
                textView.setText(editorClipActivity.p4((i2 - editorClipActivity.f0.startTime) / 2));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class f implements View.OnClickListener {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ EditText f8010f;

        f(EditorClipActivity editorClipActivity, EditText editText) {
            this.f8010f = editText;
        }

        public void onClick(View view) {
            Float f2;
            if (!TextUtils.isEmpty(this.f8010f.getText().toString())) {
                f2 = Float.valueOf(Float.parseFloat(this.f8010f.getText().toString()));
            } else {
                f2 = Float.valueOf(10.0f);
            }
            this.f8010f.setText(String.valueOf(Float.valueOf(f2.floatValue() + 1.0f)));
        }
    }

    /* access modifiers changed from: package-private */
    public class f0 implements View.OnClickListener {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Button f8011f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ boolean f8012g;

        f0(Button button, boolean z) {
            this.f8011f = button;
            this.f8012g = z;
        }

        public void onClick(View view) {
            if (!VideoEditorApplication.Z()) {
                this.f8011f.setEnabled(false);
                EditorClipActivity.this.d5(this.f8012g);
            }
        }
    }

    class g implements Runnable {
        g() {
        }

        public void run() {
            EditorClipActivity.this.P0.getLayoutParams().height = EditorClipActivity.this.q0.getHeight();
            EditorClipActivity.this.Q0.getLayoutParams().height = EditorClipActivity.this.e1.getHeight();
        }
    }

    class g0 implements View.OnClickListener {
        g0() {
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void b(int[] iArr) {
            if (iArr == null || iArr[6] <= hl.productor.fxlib.h.f0 || EditorClipActivity.this.a0.isTransCoded) {
                EditorClipActivity.this.J4();
            } else {
                EditorClipActivity.this.b5(iArr, "REVERSE");
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: c */
        public /* synthetic */ void d() {
            int[] P = Tools.P(EditorClipActivity.this.a0.path, EditorClipActivity.this.a0.contentUriString == null ? null : Uri.parse(EditorClipActivity.this.a0.contentUriString));
            if (EditorClipActivity.this.m0 != null) {
                EditorClipActivity.this.m0.post(new s2(this, P));
            }
        }

        public void onClick(View view) {
            if (((AbstractConfigActivity) EditorClipActivity.this).f8721n != null && EditorClipActivity.this.a0 != null) {
                EditorClipActivity.this.H4();
                switch (view.getId()) {
                    case C1524R$id.cv_clip_reverse:
                        Tools.c();
                        com.xvideostudio.videoeditor.x0.p2.b.a(0, "REVERSE_CLICK", null);
                        com.xvideostudio.videoeditor.tool.a0.a(1).execute(new r2(this));
                        return;
                    case C1524R$id.cv_rotate:
                        EditorClipActivity.this.K4();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    class h implements Runnable {
        h() {
        }

        public void run() {
            EditorClipActivity.this.V.setVisibility(0);
        }
    }

    /* access modifiers changed from: package-private */
    public class h0 implements DialogInterface.OnKeyListener {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Button f8017f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ boolean f8018g;

        h0(Button button, boolean z) {
            this.f8017f = button;
            this.f8018g = z;
        }

        public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
            if (i2 != 4 || keyEvent.getRepeatCount() != 0 || keyEvent.getAction() != 1 || VideoEditorApplication.Z()) {
                return false;
            }
            this.f8017f.setEnabled(false);
            boolean z = this.f8018g;
            if (!z) {
                EditorClipActivity.this.d5(z);
            } else if (!x4.b) {
                EditorClipActivity.this.d5(z);
            }
            return false;
        }
    }

    class i implements Runnable {

        class a implements Runnable {
            a() {
            }

            public void run() {
                EditorClipActivity.this.g0.setImageBitmap(EditorClipActivity.this.h0);
            }
        }

        i() {
        }

        public void run() {
            EditorClipActivity.this.g0.setIsZommTouch(false);
            h.a.b bVar = EditorClipActivity.this.h0;
            EditorClipActivity editorClipActivity = EditorClipActivity.this;
            bVar.b(h.a.a.d(editorClipActivity.j4(editorClipActivity.a0, false)), true);
            EditorClipActivity.this.g0.i(EditorClipActivity.this.p1, EditorClipActivity.this.q1);
            if (EditorClipActivity.this.h0 != null) {
                EditorClipActivity.this.l0.post(new a());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class i0 implements View.OnClickListener {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int[] f8022f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ String f8023g;

        i0(int[] iArr, String str) {
            this.f8022f = iArr;
            this.f8023g = str;
        }

        public void onClick(View view) {
            EditorClipActivity editorClipActivity = EditorClipActivity.this;
            editorClipActivity.f5(this.f8022f, editorClipActivity.a0.path, com.xvideostudio.videoeditor.x0.m0.D(EditorClipActivity.this.a0.path), this.f8023g);
        }
    }

    class j implements Runnable {
        j() {
        }

        public void run() {
            if (EditorClipActivity.this.e0 != null) {
                EditorClipActivity.this.z4();
                return;
            }
            EditorClipActivity editorClipActivity = EditorClipActivity.this;
            editorClipActivity.e0 = (MediaClip) com.xvideostudio.videoeditor.x0.j0.b(editorClipActivity.a0);
            EditorClipActivity.this.z4();
        }
    }

    /* access modifiers changed from: package-private */
    public class j0 implements View.OnClickListener {
        j0() {
        }

        public void onClick(View view) {
            EditorClipActivity editorClipActivity = EditorClipActivity.this;
            if (editorClipActivity.B == 4) {
                editorClipActivity.J4();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class k implements ZoomImageView.b {
        k() {
        }

        @Override // com.xvideostudio.videoeditor.view.ZoomImageView.b
        public void a() {
            EditorClipActivity editorClipActivity = EditorClipActivity.this;
            if (editorClipActivity.f8720m != null && editorClipActivity.a0 != null) {
                EditorClipActivity editorClipActivity2 = EditorClipActivity.this;
                editorClipActivity2.f8720m.isEditorClip = true;
                editorClipActivity2.a0.isZoomClip = true;
                if (EditorClipActivity.this.g0.getMediaClip() != null) {
                    EditorClipActivity.this.g0.getMediaClip().isZoomClip = true;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class k0 implements Tools.p {
        final /* synthetic */ Boolean a;
        final /* synthetic */ String b;

        k0(Boolean bool, String str) {
            this.a = bool;
            this.b = str;
        }

        @Override // com.xvideostudio.videoeditor.activity.Tools.p
        public void a(String str, MediaDatabase mediaDatabase) {
            Boolean bool = Boolean.TRUE;
            if (this.a.booleanValue()) {
                new com.xvideostudio.videoeditor.z.f(EditorClipActivity.this.U, new File(str));
                int p2 = EditorClipActivity.this.q0.getSortClipAdapter().p();
                EditorClipActivity editorClipActivity = EditorClipActivity.this;
                MediaDatabase mediaDatabase2 = editorClipActivity.f8720m;
                if (mediaDatabase2 != null) {
                    editorClipActivity.a0 = mediaDatabase2.addClipEntity(str);
                    if (EditorClipActivity.this.a0 != null) {
                        EditorClipActivity.this.f8720m.getClipArray().remove(EditorClipActivity.this.f8720m.getClipArray().size() - 1);
                        EditorClipActivity.this.f8720m.getClipArray().remove(p2);
                        EditorClipActivity.this.f8720m.getClipArray().add(p2, EditorClipActivity.this.a0);
                        EditorClipActivity.this.a0.index = p2;
                        EditorClipActivity.this.q0.g(EditorClipActivity.this.f8720m.getClipArray(), p2);
                        EditorClipActivity.this.h4(p2, true, false);
                        if (EditorClipActivity.this.e0 != null) {
                            EditorClipActivity.this.e0.path = str;
                        }
                        EditorClipActivity.this.a0.isTransCoded = true;
                        EditorClipActivity.this.d1 = bool;
                    }
                }
                EditorClipActivity editorClipActivity2 = EditorClipActivity.this;
                if (editorClipActivity2.B == 4) {
                    m1.b(editorClipActivity2, "TRANSCORD_SUCCESS", "编辑页面reverse");
                    EditorClipActivity.this.J4();
                    return;
                }
                return;
            }
            com.xvideostudio.videoeditor.x0.m0.o(this.b);
            com.xvideostudio.videoeditor.x0.m0.c0(str, this.b);
            File file = new File(this.b);
            if (file.exists()) {
                new com.xvideostudio.videoeditor.z.f(EditorClipActivity.this.U, file);
                z4.b = true;
                EditorClipActivity.this.a0.fileSize = file.length();
            }
            EditorClipActivity.this.a0.isTransCoded = true;
            EditorClipActivity.this.d1 = bool;
            EditorClipActivity.this.q0.g(EditorClipActivity.this.f8720m.getClipArray(), EditorClipActivity.this.a0.index);
            EditorClipActivity editorClipActivity3 = EditorClipActivity.this;
            editorClipActivity3.h4(editorClipActivity3.a0.index, false, false);
            EditorClipActivity editorClipActivity4 = EditorClipActivity.this;
            if (editorClipActivity4.B == 4) {
                m1.b(editorClipActivity4, "TRANSCORD_SUCCESS", "编辑页面reverse");
                EditorClipActivity.this.J4();
            }
        }
    }

    class l extends Handler {

        class a implements Runnable {
            a() {
            }

            public void run() {
                while (!Tools.B) {
                    try {
                        Tools.Y();
                        Thread.sleep(100);
                    } catch (Exception unused) {
                        return;
                    }
                }
                String str = "FFVideo delete file result:" + com.xvideostudio.videoeditor.x0.m0.l(EditorClipActivity.this.H);
            }
        }

        class b implements Runnable {

            class a implements Runnable {
                a() {
                }

                public void run() {
                    Dialog dialog = EditorClipActivity.this.O;
                    if (dialog != null && dialog.isShowing()) {
                        EditorClipActivity.this.O.dismiss();
                        EditorClipActivity.this.O = null;
                    }
                }
            }

            b() {
            }

            public void run() {
                while (!Tools.C) {
                    try {
                        Tools.Y();
                        Thread.sleep(100);
                    } catch (Exception unused) {
                        return;
                    }
                }
                boolean l2 = com.xvideostudio.videoeditor.x0.m0.l(EditorClipActivity.this.H);
                x4.b = false;
                EditorClipActivity.this.y1.post(new a());
                String str = "ReverseVideo delete file result:" + l2;
            }
        }

        l() {
        }

        public void handleMessage(Message message) {
            MediaClip mediaClip;
            boolean z;
            boolean z2;
            int i2 = Build.VERSION.SDK_INT;
            super.handleMessage(message);
            switch (message.what) {
                case 0:
                    EditorClipActivity editorClipActivity = EditorClipActivity.this;
                    if (editorClipActivity.O != null && editorClipActivity.P != null) {
                        int i3 = message.arg1;
                        int i4 = message.arg2;
                        boolean booleanValue = ((Boolean) message.obj).booleanValue();
                        if (i3 > i4) {
                            i3 = i4;
                        }
                        EditorClipActivity.this.P.setMax(i4);
                        EditorClipActivity.this.P.setProgress(i3);
                        TextView textView = EditorClipActivity.this.R;
                        textView.setText(((i3 * 100) / i4) + "%");
                        if (booleanValue) {
                            EditorClipActivity editorClipActivity2 = EditorClipActivity.this;
                            com.xvideostudio.videoeditor.x0.m0.c0(editorClipActivity2.H, editorClipActivity2.G);
                            EditorClipActivity editorClipActivity3 = EditorClipActivity.this;
                            if (editorClipActivity3 != null && !editorClipActivity3.isFinishing() && !VideoEditorApplication.Y(EditorClipActivity.this) && EditorClipActivity.this.O.isShowing()) {
                                EditorClipActivity.this.O.dismiss();
                                EditorClipActivity.this.d1();
                            }
                            EditorClipActivity editorClipActivity4 = EditorClipActivity.this;
                            editorClipActivity4.O = null;
                            if (editorClipActivity4.j1) {
                                Message message2 = new Message();
                                message2.what = 1;
                                EditorClipActivity editorClipActivity5 = EditorClipActivity.this;
                                message2.obj = editorClipActivity5.G;
                                Handler handler = editorClipActivity5.y1;
                                if (handler != null) {
                                    handler.sendMessage(message2);
                                    return;
                                }
                                return;
                            }
                            Message message3 = new Message();
                            message3.what = 2;
                            EditorClipActivity editorClipActivity6 = EditorClipActivity.this;
                            message3.obj = editorClipActivity6.G;
                            Handler handler2 = editorClipActivity6.y1;
                            if (handler2 != null) {
                                handler2.sendMessage(message3);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                case 1:
                    if (Math.min(VideoEditorApplication.w, VideoEditorApplication.x) < 400) {
                        EditorClipActivity.this.i1 = true;
                        if (((AbstractConfigActivity) EditorClipActivity.this).f8721n != null) {
                            EditorClipActivity.this.e5();
                            EditorClipActivity.this.r1.removeView(((AbstractConfigActivity) EditorClipActivity.this).f8721n.K());
                            ((AbstractConfigActivity) EditorClipActivity.this).f8721n.m0();
                            ((AbstractConfigActivity) EditorClipActivity.this).f8721n = null;
                        }
                        com.xvideostudio.videoeditor.l0.c.S();
                        EditorClipActivity.this.s1 = null;
                    }
                    Intent intent = new Intent("android.intent.action.VIEW");
                    String str = (String) message.obj;
                    if (i2 >= 24) {
                        try {
                            intent.setFlags(1);
                            Context context = EditorClipActivity.this.U;
                            intent.setDataAndType(FileProvider.e(context, EditorClipActivity.this.U.getPackageName() + ".fileprovider", new File(str)), "video/*");
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    } else {
                        intent.setDataAndType(Uri.fromFile(new File(str)), "video/*");
                    }
                    EditorClipActivity.this.startActivity(intent);
                    return;
                case 2:
                    if (EditorClipActivity.this.a0 != null && EditorClipActivity.this.u1 != null) {
                        EditorClipActivity.this.a0.path = (String) message.obj;
                        MediaClip createClip = EditorClipActivity.this.u1.createClip(EditorClipActivity.this.a0.path);
                        if (createClip != null && (mediaClip = EditorClipActivity.this.g0.getMediaClip()) != null) {
                            mediaClip.path = createClip.path;
                            mediaClip.fileSize = createClip.fileSize;
                            mediaClip.startTime = createClip.startTime;
                            mediaClip.endTime = createClip.endTime;
                            mediaClip.duration = createClip.duration;
                            if (((double) EditorClipActivity.this.A1) < 0.25d || EditorClipActivity.this.A1 > 4.0f) {
                                mediaClip.ffVideoRate = 0;
                            } else {
                                mediaClip.ffVideoRate = (int) EditorClipActivity.this.A1;
                            }
                            if (!(Math.max(mediaClip.video_w_real, mediaClip.video_h_real) == Math.max(createClip.video_w_real, createClip.video_h_real) && Math.min(mediaClip.video_w_real, mediaClip.video_h_real) == Math.min(createClip.video_w_real, createClip.video_h_real))) {
                                mediaClip.adjustHeight = 0;
                                mediaClip.adjustWidth = 0;
                                mediaClip.topleftXLoc = 0;
                                mediaClip.topleftYLoc = 0;
                                mediaClip.lastMatrixValue = new float[9];
                                mediaClip.isZoomClip = false;
                                if (mediaClip.lastRotation > 0) {
                                    z = true;
                                    mediaClip.video_w = createClip.video_w;
                                    mediaClip.video_h = createClip.video_h;
                                    mediaClip.video_w_real = createClip.video_w_real;
                                    mediaClip.video_h_real = createClip.video_h_real;
                                    mediaClip.video_rotate = createClip.video_rotate;
                                    mediaClip.picWidth = 0;
                                    mediaClip.picHeight = 0;
                                    EditorClipActivity.this.a0 = mediaClip;
                                    EditorClipActivity editorClipActivity7 = EditorClipActivity.this;
                                    editorClipActivity7.f8720m.resetClip(editorClipActivity7.p0, EditorClipActivity.this.a0);
                                    EditorClipActivity editorClipActivity8 = EditorClipActivity.this;
                                    editorClipActivity8.h4(editorClipActivity8.p0, true, z);
                                    m1.a(EditorClipActivity.this.U, "CLICK_EDITORCLIP_FF_SUCCESS");
                                    EditorClipActivity.this.d1();
                                    return;
                                }
                            }
                            z = false;
                            mediaClip.video_w = createClip.video_w;
                            mediaClip.video_h = createClip.video_h;
                            mediaClip.video_w_real = createClip.video_w_real;
                            mediaClip.video_h_real = createClip.video_h_real;
                            mediaClip.video_rotate = createClip.video_rotate;
                            mediaClip.picWidth = 0;
                            mediaClip.picHeight = 0;
                            EditorClipActivity.this.a0 = mediaClip;
                            EditorClipActivity editorClipActivity72 = EditorClipActivity.this;
                            editorClipActivity72.f8720m.resetClip(editorClipActivity72.p0, EditorClipActivity.this.a0);
                            EditorClipActivity editorClipActivity82 = EditorClipActivity.this;
                            editorClipActivity82.h4(editorClipActivity82.p0, true, z);
                            m1.a(EditorClipActivity.this.U, "CLICK_EDITORCLIP_FF_SUCCESS");
                            EditorClipActivity.this.d1();
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    com.xvideostudio.videoeditor.tool.a0.a(1).execute(new a());
                    return;
                case 4:
                default:
                    return;
                case 5:
                    EditorClipActivity editorClipActivity9 = EditorClipActivity.this;
                    if (editorClipActivity9.O != null && editorClipActivity9.P != null) {
                        int i5 = message.arg1;
                        int i6 = message.arg2;
                        boolean booleanValue2 = ((Boolean) message.obj).booleanValue();
                        if (i5 > i6) {
                            i5 = i6;
                        }
                        EditorClipActivity.M1 = i5;
                        if (!x4.b) {
                            EditorClipActivity.this.P.setMax(i6);
                            EditorClipActivity.this.P.setProgress(i5);
                            TextView textView2 = EditorClipActivity.this.R;
                            textView2.setText(((i5 * 100) / i6) + "%");
                        }
                        if (booleanValue2 && !x4.b) {
                            EditorClipActivity editorClipActivity10 = EditorClipActivity.this;
                            com.xvideostudio.videoeditor.x0.m0.c0(editorClipActivity10.H, editorClipActivity10.G);
                            EditorClipActivity editorClipActivity11 = EditorClipActivity.this;
                            if (editorClipActivity11 != null && !editorClipActivity11.isFinishing() && !VideoEditorApplication.Y(EditorClipActivity.this) && EditorClipActivity.this.O.isShowing()) {
                                EditorClipActivity.this.O.dismiss();
                            }
                            EditorClipActivity editorClipActivity12 = EditorClipActivity.this;
                            editorClipActivity12.O = null;
                            if (editorClipActivity12.j1) {
                                Message message4 = new Message();
                                message4.what = 6;
                                EditorClipActivity editorClipActivity13 = EditorClipActivity.this;
                                message4.obj = editorClipActivity13.G;
                                Handler handler3 = editorClipActivity13.y1;
                                if (handler3 != null) {
                                    handler3.sendMessage(message4);
                                    return;
                                }
                                return;
                            }
                            Message message5 = new Message();
                            message5.what = 7;
                            EditorClipActivity editorClipActivity14 = EditorClipActivity.this;
                            message5.obj = editorClipActivity14.G;
                            Handler handler4 = editorClipActivity14.y1;
                            if (handler4 != null) {
                                handler4.sendMessage(message5);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                case 6:
                    if (Math.min(VideoEditorApplication.w, VideoEditorApplication.x) < 400) {
                        EditorClipActivity.this.i1 = true;
                        if (((AbstractConfigActivity) EditorClipActivity.this).f8721n != null) {
                            EditorClipActivity.this.e5();
                            EditorClipActivity.this.r1.removeView(((AbstractConfigActivity) EditorClipActivity.this).f8721n.K());
                            ((AbstractConfigActivity) EditorClipActivity.this).f8721n.m0();
                            ((AbstractConfigActivity) EditorClipActivity.this).f8721n = null;
                        }
                        com.xvideostudio.videoeditor.l0.c.S();
                        EditorClipActivity.this.s1 = null;
                    }
                    Intent intent2 = new Intent("android.intent.action.VIEW");
                    String str2 = (String) message.obj;
                    if (i2 >= 24) {
                        intent2.setFlags(1);
                        Context context2 = EditorClipActivity.this.U;
                        intent2.setDataAndType(FileProvider.e(context2, EditorClipActivity.this.U.getPackageName() + ".fileprovider", new File(str2)), "video/*");
                    } else {
                        intent2.setDataAndType(Uri.fromFile(new File(str2)), "video/*");
                    }
                    EditorClipActivity.this.startActivity(intent2);
                    return;
                case 7:
                    if (EditorClipActivity.this.a0 != null && EditorClipActivity.this.u1 != null) {
                        EditorClipActivity.this.a0.path = (String) message.obj;
                        MediaClip createClip2 = EditorClipActivity.this.u1.createClip(EditorClipActivity.this.a0.path);
                        if (createClip2 != null && createClip2.duration > 0 && createClip2.video_w_real > 0) {
                            x4.b = false;
                            if (EditorClipActivity.this.q0.getVisibility() != 0) {
                                EditorClipActivity.this.q0.setVisibility(0);
                            }
                            MediaClip mediaClip2 = EditorClipActivity.this.g0.getMediaClip();
                            mediaClip2.path = createClip2.path;
                            mediaClip2.fileSize = createClip2.fileSize;
                            mediaClip2.startTime = createClip2.startTime;
                            mediaClip2.endTime = createClip2.endTime;
                            mediaClip2.duration = createClip2.duration;
                            if (!(Math.max(mediaClip2.video_w_real, mediaClip2.video_h_real) == Math.max(createClip2.video_w_real, createClip2.video_h_real) && Math.min(mediaClip2.video_w_real, mediaClip2.video_h_real) == Math.min(createClip2.video_w_real, createClip2.video_h_real))) {
                                mediaClip2.adjustHeight = 0;
                                mediaClip2.adjustWidth = 0;
                                mediaClip2.topleftXLoc = 0;
                                mediaClip2.topleftYLoc = 0;
                                mediaClip2.lastMatrixValue = new float[9];
                                mediaClip2.isZoomClip = false;
                                if (mediaClip2.lastRotation > 0) {
                                    z2 = true;
                                    mediaClip2.video_w = createClip2.video_w;
                                    mediaClip2.video_h = createClip2.video_h;
                                    mediaClip2.video_w_real = createClip2.video_w_real;
                                    mediaClip2.video_h_real = createClip2.video_h_real;
                                    mediaClip2.video_rotate = createClip2.video_rotate;
                                    mediaClip2.picWidth = 0;
                                    mediaClip2.picHeight = 0;
                                    mediaClip2.isVideoReverse = true;
                                    EditorClipActivity.this.a0 = mediaClip2;
                                    EditorClipActivity editorClipActivity15 = EditorClipActivity.this;
                                    editorClipActivity15.f8720m.resetClip(editorClipActivity15.p0, EditorClipActivity.this.a0);
                                    EditorClipActivity editorClipActivity16 = EditorClipActivity.this;
                                    editorClipActivity16.h4(editorClipActivity16.p0, true, z2);
                                    m1.a(EditorClipActivity.this.U, "CLICK_EDITORCLIP_REVERSE_SUCCESS");
                                    EditorClipActivity.this.h5();
                                    EditorClipActivity.this.d1();
                                    return;
                                }
                            }
                            z2 = false;
                            mediaClip2.video_w = createClip2.video_w;
                            mediaClip2.video_h = createClip2.video_h;
                            mediaClip2.video_w_real = createClip2.video_w_real;
                            mediaClip2.video_h_real = createClip2.video_h_real;
                            mediaClip2.video_rotate = createClip2.video_rotate;
                            mediaClip2.picWidth = 0;
                            mediaClip2.picHeight = 0;
                            mediaClip2.isVideoReverse = true;
                            EditorClipActivity.this.a0 = mediaClip2;
                            EditorClipActivity editorClipActivity152 = EditorClipActivity.this;
                            editorClipActivity152.f8720m.resetClip(editorClipActivity152.p0, EditorClipActivity.this.a0);
                            EditorClipActivity editorClipActivity162 = EditorClipActivity.this;
                            editorClipActivity162.h4(editorClipActivity162.p0, true, z2);
                            m1.a(EditorClipActivity.this.U, "CLICK_EDITORCLIP_REVERSE_SUCCESS");
                            EditorClipActivity.this.h5();
                            EditorClipActivity.this.d1();
                            return;
                        }
                        return;
                    }
                    return;
                case 8:
                    x4.b = true;
                    com.xvideostudio.videoeditor.tool.a0.a(1).execute(new b());
                    return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class l0 implements View.OnClickListener {

        class a implements Runnable {
            a() {
            }

            public void run() {
                String str = "mTrimSeekBar accurate1:" + EditorClipActivity.this.a0.startTime + "," + EditorClipActivity.this.a0.endTime;
                EditorClipActivity.this.a0.startTime = ((AbstractConfigActivity) EditorClipActivity.this).f8721n.C();
                String str2 = "mTrimSeekBar accurate12:" + EditorClipActivity.this.a0.startTime + "," + EditorClipActivity.this.a0.endTime;
            }
        }

        l0() {
        }

        public void onClick(View view) {
            boolean z;
            int[] iArr = (int[]) view.getTag();
            if (iArr[0] != EditorClipActivity.this.a0.startTime) {
                EditorClipActivity.this.a0.startTime = iArr[0];
                EditorClipActivity.this.a0.startTime = Tools.N(EditorClipActivity.this.a0.path, EditorClipActivity.this.a0.startTime, Tools.q.mode_closer);
                TextView textView = EditorClipActivity.this.M0;
                EditorClipActivity editorClipActivity = EditorClipActivity.this;
                textView.setText(editorClipActivity.p4(editorClipActivity.a0.startTime));
                z = true;
            } else {
                z = false;
            }
            if (iArr[1] != EditorClipActivity.this.a0.endTime) {
                EditorClipActivity.this.a0.endTime = iArr[1];
                TextView textView2 = EditorClipActivity.this.N0;
                EditorClipActivity editorClipActivity2 = EditorClipActivity.this;
                textView2.setText(editorClipActivity2.p4(editorClipActivity2.a0.endTime));
                z = true;
            }
            if (z) {
                EditorClipActivity.this.t0 = true;
                EditorClipActivity.this.O0.setVisibility(0);
                TextView textView3 = EditorClipActivity.this.O0;
                EditorClipActivity editorClipActivity3 = EditorClipActivity.this;
                textView3.setText(editorClipActivity3.p4(editorClipActivity3.a0.getClipDuration()));
                ((AbstractConfigActivity) EditorClipActivity.this).f8721n.L0(((float) EditorClipActivity.this.a0.startTime) / 1000.0f);
                EditorClipActivity.this.l0.post(new a());
                EditorClipActivity.this.T0.setMinMaxValue(EditorClipActivity.this.a0);
                EditorClipActivity.this.T0.setProgress(0.0f);
            }
        }
    }

    class m implements Runnable {
        m() {
        }

        public void run() {
            EditorClipActivity.this.P4(1);
        }
    }

    /* access modifiers changed from: package-private */
    public class m0 implements SeekBar.OnSeekBarChangeListener {
        m0() {
        }

        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            int p2;
            if (EditorClipActivity.this.e0 != null) {
                EditorClipActivity.this.e0.videoVolume = i2;
            }
            if (EditorClipActivity.this.a0 != null) {
                EditorClipActivity.this.a0.videoVolume = i2;
            }
            EditorClipActivity editorClipActivity = EditorClipActivity.this;
            MediaDatabase mediaDatabase = editorClipActivity.f8720m;
            if (mediaDatabase != null) {
                mediaDatabase.isVideosMute = false;
                if (!editorClipActivity.n1 && editorClipActivity.s1 != null && (p2 = EditorClipActivity.this.q0.getSortClipAdapter().p()) >= 0 && p2 < EditorClipActivity.this.f8720m.getClipArray().size()) {
                    EditorClipActivity.this.f8720m.getClipArray().set(EditorClipActivity.this.q0.getSortClipAdapter().p(), EditorClipActivity.this.a0);
                    Message message = new Message();
                    message.what = 56;
                    EditorClipActivity.this.l0.sendMessage(message);
                    ((MediaClip) EditorClipActivity.this.m1.get(EditorClipActivity.this.q0.getSortClipAdapter().p())).videoVolume = i2;
                }
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            m1.a(VideoEditorApplication.y(), "SOUND_CLIP_VIDEO_ADJUST");
        }
    }

    class n implements Runnable {
        n() {
        }

        public void run() {
            EditorClipActivity.this.P4(4);
        }
    }

    /* access modifiers changed from: package-private */
    public class n0 extends Handler {
        n0() {
        }

        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 10) {
                EditorClipActivity.this.T0.invalidate();
            } else if (i2 == 11) {
                EditorClipActivity.this.U0.invalidate();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class o implements View.OnClickListener {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f8036f;

        class a implements Runnable {

            /* renamed from: com.xvideostudio.videoeditor.activity.EditorClipActivity$o$a$a  reason: collision with other inner class name */
            class RunnableC0201a implements Runnable {
                RunnableC0201a() {
                }

                public void run() {
                    EditorClipActivity.this.g0.setImageBitmap(EditorClipActivity.this.h0);
                    EditorClipActivity.this.z4();
                }
            }

            a() {
            }

            public void run() {
                if (EditorClipActivity.this.a0 != null) {
                    EditorClipActivity editorClipActivity = EditorClipActivity.this;
                    editorClipActivity.e0 = (MediaClip) com.xvideostudio.videoeditor.x0.j0.b(editorClipActivity.a0);
                    EditorClipActivity.this.h0.c();
                    h.a.b bVar = EditorClipActivity.this.h0;
                    EditorClipActivity editorClipActivity2 = EditorClipActivity.this;
                    bVar.b(h.a.a.d(editorClipActivity2.j4(editorClipActivity2.a0, false)), true);
                    EditorClipActivity.this.g0.i(EditorClipActivity.this.p1, EditorClipActivity.this.q1);
                    EditorClipActivity.this.g0.setMediaClip(EditorClipActivity.this.a0);
                    EditorClipActivity.this.l0.post(new RunnableC0201a());
                }
            }
        }

        o(int i2) {
            this.f8036f = i2;
        }

        public void onClick(View view) {
            m1.a(EditorClipActivity.this.U, "CLICK_EDITORCLIP_DELETE_CONFIRM");
            int i2 = this.f8036f;
            if (i2 >= 0 && i2 < EditorClipActivity.this.f8720m.getClipArray().size()) {
                EditorClipActivity.this.d1 = Boolean.TRUE;
                EditorClipActivity.this.f8720m.getClipArray().remove(this.f8036f);
                EditorClipActivity.this.f8720m.updateIndex();
                EditorClipActivity.this.q0.g(EditorClipActivity.this.f8720m.getClipArray(), this.f8036f);
                EditorClipActivity.this.q0.getSortClipAdapter().x(-1);
                if (EditorClipActivity.this.q0.getSortClipAdapter().p() >= EditorClipActivity.this.f8720m.getClipArray().size() - 2) {
                    EditorClipActivity.this.q0.getSortClipAdapter().v(-1);
                    EditorClipActivity editorClipActivity = EditorClipActivity.this;
                    editorClipActivity.p0 = editorClipActivity.q0.getSortClipAdapter().p();
                    EditorClipActivity editorClipActivity2 = EditorClipActivity.this;
                    editorClipActivity2.a0 = editorClipActivity2.q0.getSortClipAdapter().o();
                } else {
                    EditorClipActivity editorClipActivity3 = EditorClipActivity.this;
                    editorClipActivity3.a0 = editorClipActivity3.q0.getSortClipAdapter().o();
                }
                EditorClipActivity.this.i4(false);
                com.xvideostudio.videoeditor.tool.a0.a(1).execute(new a());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class o0 implements MSeekbarNew.b {
        o0() {
        }

        @Override // com.xvideostudio.videoeditor.tool.MSeekbarNew.b
        public void a(float f2) {
            Message message = new Message();
            message.what = 5;
            Bundle bundle = new Bundle();
            bundle.putInt("state", 1);
            message.setData(bundle);
            message.obj = Float.valueOf(f2);
            EditorClipActivity.this.l0.sendMessage(message);
        }

        @Override // com.xvideostudio.videoeditor.tool.MSeekbarNew.b
        public void b(float f2) {
            if (((AbstractConfigActivity) EditorClipActivity.this).f8721n != null) {
                EditorClipActivity.this.W0 = true;
                if (((AbstractConfigActivity) EditorClipActivity.this).f8721n.h0()) {
                    EditorClipActivity.this.V0 = true;
                    ((AbstractConfigActivity) EditorClipActivity.this).f8721n.j0();
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
            EditorClipActivity.this.l0.sendMessage(message);
        }
    }

    /* access modifiers changed from: package-private */
    public class p implements DialogInterface.OnDismissListener {
        p(EditorClipActivity editorClipActivity) {
        }

        public void onDismiss(DialogInterface dialogInterface) {
        }
    }

    /* access modifiers changed from: package-private */
    public class p0 implements View.OnClickListener {
        p0() {
        }

        public void onClick(View view) {
            EditorClipActivity.this.m4(EditorClipActivity.this.q0.getSortClipAdapter().m());
        }
    }

    /* access modifiers changed from: package-private */
    public class q implements View.OnClickListener {
        q() {
        }

        public void onClick(View view) {
            int i2;
            MediaDatabase mediaDatabase = EditorClipActivity.this.f8720m;
            if (!(mediaDatabase == null || mediaDatabase.getClipArray() == null)) {
                ArrayList<MediaClip> clipArray = EditorClipActivity.this.f8720m.getClipArray();
                if (EditorClipActivity.this.a0 != null) {
                    if (EditorClipActivity.this.a0.isZoomClip || EditorClipActivity.this.a0.lastRotation != 0) {
                        EditorClipActivity editorClipActivity = EditorClipActivity.this;
                        editorClipActivity.a0 = editorClipActivity.g0.h(EditorClipActivity.this.a0, false);
                    }
                    if (EditorClipActivity.this.p0 < clipArray.size()) {
                        clipArray.set(EditorClipActivity.this.p0, EditorClipActivity.this.a0);
                    }
                }
                Iterator<MediaClip> it = clipArray.iterator();
                while (it.hasNext()) {
                    MediaClip next = it.next();
                    if (next.mediaType == VideoEditData.VIDEO_TYPE && (i2 = next.startTime) > 0 && next.ffmpegStartTime != i2) {
                        try {
                            String str = "Before getRealTrimSpot, trim_start =" + next.startTime + "ms";
                            String str2 = "After getRealTrimSpot, trim_start =" + next.startTime + "ms";
                            int i3 = next.startTime;
                            int i4 = next.endTime;
                            if (i3 >= i4) {
                                next.startTime = i4 - 1000;
                            }
                            if (next.startTime < 0) {
                                next.startTime = 0;
                            }
                            next.ffmpegStartTime = next.startTime;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
            EditorClipActivity.this.n4(true);
        }
    }

    /* access modifiers changed from: package-private */
    public class q0 implements View.OnClickListener {
        q0() {
        }

        public void onClick(View view) {
            EditorClipActivity editorClipActivity = EditorClipActivity.this;
            int i2 = editorClipActivity.B;
            if (i2 == 1) {
                editorClipActivity.U4(true);
            } else if (i2 == 6) {
                editorClipActivity.U4(false);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class r implements View.OnClickListener {
        r() {
        }

        public void onClick(View view) {
            EditorClipActivity.this.n4(false);
        }
    }

    /* access modifiers changed from: package-private */
    public class r0 implements SpeedMSeekbarNew.b {
        r0() {
        }

        @Override // com.xvideostudio.videoeditor.tool.SpeedMSeekbarNew.b
        public void a(float f2) {
            Message message = new Message();
            message.what = 5;
            Bundle bundle = new Bundle();
            bundle.putInt("state", 1);
            message.setData(bundle);
            message.obj = Float.valueOf(f2);
            EditorClipActivity.this.l0.sendMessage(message);
        }

        @Override // com.xvideostudio.videoeditor.tool.SpeedMSeekbarNew.b
        public void b(float f2) {
            if (((AbstractConfigActivity) EditorClipActivity.this).f8721n != null) {
                EditorClipActivity.this.W0 = true;
                if (((AbstractConfigActivity) EditorClipActivity.this).f8721n.h0()) {
                    EditorClipActivity.this.V0 = true;
                    ((AbstractConfigActivity) EditorClipActivity.this).f8721n.j0();
                }
            }
        }

        @Override // com.xvideostudio.videoeditor.tool.SpeedMSeekbarNew.b
        public void c(float f2) {
            String str = "OnSeekBarChange value=" + f2;
            Message message = new Message();
            message.what = 5;
            Bundle bundle = new Bundle();
            bundle.putInt("state", 2);
            message.setData(bundle);
            message.obj = Float.valueOf(f2);
            EditorClipActivity.this.l0.sendMessage(message);
        }
    }

    /* access modifiers changed from: package-private */
    public class s implements DialogInterface.OnKeyListener {
        s(EditorClipActivity editorClipActivity) {
        }

        public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
            dialogInterface.dismiss();
            return false;
        }
    }

    /* access modifiers changed from: private */
    public class s0 extends Handler {

        class a implements Runnable {
            a() {
            }

            public void run() {
                ((AbstractConfigActivity) EditorClipActivity.this).f8721n.k0();
                EditorClipActivity.this.T0.setTriming(false);
                EditorClipActivity.this.n0.setVisibility(0);
                EditorClipActivity.this.W.setVisibility(8);
            }
        }

        class b implements Runnable {
            b(s0 s0Var) {
            }

            public void run() {
                if (!com.xvideostudio.videoeditor.x0.c0.t().trim().equalsIgnoreCase("XIAOMIMT6582") || !hl.productor.fxlib.c0.f13159e.trim().equalsIgnoreCase("Mali-400 MP") || !hl.productor.fxlib.c0.f13160f.trim().equalsIgnoreCase("ARM")) {
                    hl.productor.fxlib.h.P = false;
                } else {
                    hl.productor.fxlib.h.P = true;
                }
            }
        }

        class c implements Runnable {
            c() {
            }

            public void run() {
                ((AbstractConfigActivity) EditorClipActivity.this).f8721n.N0(false);
            }
        }

        private s0() {
        }

        public void handleMessage(Message message) {
            if (((AbstractConfigActivity) EditorClipActivity.this).f8721n != null && EditorClipActivity.this.s1 != null) {
                int i2 = message.what;
                if (i2 != 0) {
                    if (i2 != 8) {
                        if (i2 != 26) {
                            if (i2 == 56) {
                                EditorClipActivity editorClipActivity = EditorClipActivity.this;
                                if (!editorClipActivity.n1 && editorClipActivity.s1 != null) {
                                    EditorClipActivity editorClipActivity2 = EditorClipActivity.this;
                                    editorClipActivity2.n1 = true;
                                    com.xvideostudio.videoeditor.r rVar = editorClipActivity2.s1;
                                    EditorClipActivity editorClipActivity3 = EditorClipActivity.this;
                                    rVar.c0(editorClipActivity3.f8720m, editorClipActivity3.q0.getSortClipAdapter().p(), true);
                                    EditorClipActivity.this.n1 = false;
                                }
                            } else if (i2 != 3) {
                                if (i2 == 4) {
                                    EditorClipActivity.this.x1 = true;
                                    EditorClipActivity.this.J1 = (Float) message.obj;
                                    EditorClipActivity.this.G1.setText(SystemUtility.getTimeMinSecFormt(0));
                                    EditorClipActivity editorClipActivity4 = EditorClipActivity.this;
                                    editorClipActivity4.H1.setText(SystemUtility.getTimeMinSecFormt((int) (editorClipActivity4.J1.floatValue() * 1000.0f)));
                                    EditorClipActivity editorClipActivity5 = EditorClipActivity.this;
                                    editorClipActivity5.I1.setMax(editorClipActivity5.J1.floatValue());
                                } else if (i2 == 5) {
                                    float floatValue = ((Float) message.obj).floatValue();
                                    System.out.println("--->" + floatValue);
                                    EditorClipActivity.this.O4(floatValue);
                                    int i3 = (int) (floatValue * 1000.0f);
                                    EditorClipActivity.this.w0.setText(EditorClipActivity.this.o4(i3));
                                    EditorClipActivity.this.G1.setText(SystemUtility.getTimeMinSecFormt(i3));
                                    Bundle data = message.getData();
                                    if (data.getInt("state") == 2) {
                                        ((AbstractConfigActivity) EditorClipActivity.this).f8721n.N0(true);
                                    } else {
                                        EditorClipActivity.this.l0.postDelayed(new c(), 200);
                                    }
                                    if (data.getInt("state") != 2) {
                                        if (EditorClipActivity.this.V0) {
                                            EditorClipActivity.this.V0 = false;
                                            EditorClipActivity.this.W.setVisibility(8);
                                            ((AbstractConfigActivity) EditorClipActivity.this).f8721n.k0();
                                            EditorClipActivity.this.T0.setTriming(true);
                                        }
                                        EditorClipActivity.this.W0 = false;
                                    }
                                }
                            } else if (!EditorClipActivity.this.W0) {
                                Bundle data2 = message.getData();
                                float f2 = data2.getFloat("cur_time");
                                float f3 = data2.getFloat("total_time");
                                int i4 = (int) (f2 * 1000.0f);
                                int i5 = (int) (f3 * 1000.0f);
                                int i6 = i4 == i5 + -1 ? i5 : i4;
                                if (EditorClipActivity.this.a0 != null && !EditorClipActivity.this.c1) {
                                    EditorClipActivity editorClipActivity6 = EditorClipActivity.this;
                                    editorClipActivity6.b1 = editorClipActivity6.a0.startTime + i6;
                                }
                                if (EditorClipActivity.this.a0 != null) {
                                    float f4 = f2 / f3;
                                    System.out.println(f2 + "___" + f3);
                                    EditorClipActivity.this.y0.setMax(f3);
                                    EditorClipActivity.this.y0.setProgress(f2);
                                    if (EditorClipActivity.this.a0.mediaType != VideoEditData.VIDEO_TYPE || EditorClipActivity.this.e0 == null) {
                                        EditorClipActivity.this.w0.setText(EditorClipActivity.this.o4(i6));
                                    } else {
                                        if (((AbstractConfigActivity) EditorClipActivity.this).f8721n.h0()) {
                                            EditorClipActivity.this.T0.setProgress(f4);
                                            EditorClipActivity.this.U0.setProgress(f4);
                                            EditorClipActivity editorClipActivity7 = EditorClipActivity.this;
                                            String p4 = editorClipActivity7.p4(editorClipActivity7.a0.startTime + i6);
                                            if (EditorClipActivity.this.f1 == 4) {
                                                EditorClipActivity.this.O0.setText(EditorClipActivity.this.p4(i6));
                                            } else {
                                                EditorClipActivity.this.O0.setText(p4);
                                            }
                                        }
                                        EditorClipActivity.this.w0.setText(EditorClipActivity.this.o4(i6));
                                    }
                                }
                                if ((f3 - f2) * 1000.0f < 50.0f) {
                                    EditorClipActivity.this.G1.setText(SystemUtility.getTimeMinSecFormt(i5));
                                } else {
                                    EditorClipActivity.this.G1.setText(SystemUtility.getTimeMinSecFormt(i4));
                                }
                                EditorClipActivity.this.I1.setMax(f3);
                                EditorClipActivity.this.I1.setProgress(f2);
                                String str = "FX_STATE_PLAY_UPDATE_CURRENT_TIME=======>" + f2 + "--->" + f3 + "--->" + i6;
                                int intValue = Integer.valueOf(EditorClipActivity.this.s1.e(f2)).intValue();
                                EditorClipActivity editorClipActivity8 = EditorClipActivity.this;
                                if (editorClipActivity8.T != intValue) {
                                    ArrayList<FxMediaClipEntity> clipList = editorClipActivity8.s1.b().getClipList();
                                    if (EditorClipActivity.this.T >= 0 && clipList.size() - 1 >= EditorClipActivity.this.T && intValue >= 0 && clipList.size() - 1 >= intValue) {
                                        clipList.get(EditorClipActivity.this.T);
                                        clipList.get(intValue);
                                        EditorClipActivity.this.T0.setTriming(true);
                                    }
                                    EditorClipActivity.this.T = intValue;
                                }
                            }
                        } else if (!EditorClipActivity.this.W0) {
                            message.getData().getBoolean("state");
                            EditorClipActivity editorClipActivity9 = EditorClipActivity.this;
                            editorClipActivity9.N4(((AbstractConfigActivity) editorClipActivity9).f8721n.H());
                        }
                    } else if (!EditorClipActivity.this.t1) {
                        EditorClipActivity.this.v1 = false;
                    } else {
                        EditorClipActivity.this.s1.k(EditorClipActivity.this.u1);
                        EditorClipActivity.this.s1.D(true, 0);
                        ((AbstractConfigActivity) EditorClipActivity.this).f8721n.w0(1);
                        if (x4.a) {
                            x4.a = false;
                            ((AbstractConfigActivity) EditorClipActivity.this).f8721n.L0(0.0f);
                            if (!(((AbstractConfigActivity) EditorClipActivity.this).f8721n == null || ((AbstractConfigActivity) EditorClipActivity.this).f8721n.A() == -1)) {
                                ((AbstractConfigActivity) EditorClipActivity.this).f8721n.w0(-1);
                            }
                            EditorClipActivity.this.l0.postDelayed(new a(), 250);
                        }
                        if (EditorClipActivity.this.e0 != null && EditorClipActivity.this.e0.mediaType == VideoEditData.VIDEO_TYPE) {
                            if (EditorClipActivity.this.k1 == 0.0f) {
                                EditorClipActivity.this.T0.setProgress(0.0f);
                                TextView textView = EditorClipActivity.this.O0;
                                EditorClipActivity editorClipActivity10 = EditorClipActivity.this;
                                textView.setText(editorClipActivity10.p4(editorClipActivity10.e0.getTrimStartTime() + 0));
                            } else {
                                ((AbstractConfigActivity) EditorClipActivity.this).f8721n.L0(EditorClipActivity.this.k1);
                                TextView textView2 = EditorClipActivity.this.O0;
                                EditorClipActivity editorClipActivity11 = EditorClipActivity.this;
                                textView2.setText(editorClipActivity11.p4(editorClipActivity11.e0.getTrimStartTime() + ((int) (EditorClipActivity.this.k1 * 1000.0f))));
                                EditorClipActivity.this.k1 = 0.0f;
                            }
                        }
                        EditorClipActivity.this.s1.b().getMediaTotalTime();
                        EditorClipActivity editorClipActivity12 = EditorClipActivity.this;
                        if (editorClipActivity12.B == 3) {
                            editorClipActivity12.n0.setVisibility(8);
                            EditorClipActivity.this.W.setVisibility(0);
                            EditorClipActivity.this.g0.setIsZommTouch(true);
                        } else {
                            if (!editorClipActivity12.l1) {
                                EditorClipActivity.this.n0.setVisibility(0);
                                EditorClipActivity.this.W.setVisibility(0);
                                EditorClipActivity.this.T0.setTriming(true);
                                EditorClipActivity.this.l1 = false;
                            }
                            EditorClipActivity.this.g0.setIsZommTouch(false);
                        }
                        if (EditorClipActivity.this.v0) {
                            EditorClipActivity.this.l0.postDelayed(new b(this), 1000);
                        }
                        EditorClipActivity.this.v1 = false;
                        EditorClipActivity.this.q0.getSortClipAdapter().notifyDataSetChanged();
                    }
                } else if (!EditorClipActivity.this.W0) {
                    ((AbstractConfigActivity) EditorClipActivity.this).f8721n.s0();
                    EditorClipActivity.this.W.setVisibility(0);
                    if (EditorClipActivity.this.e0 != null && EditorClipActivity.this.e0.mediaType == VideoEditData.VIDEO_TYPE) {
                        EditorClipActivity.this.T0.setProgress(0.0f);
                        EditorClipActivity.this.U0.setProgress(0.0f);
                        if (EditorClipActivity.this.f1 != 4) {
                            EditorClipActivity.this.O0.setVisibility(4);
                        }
                    }
                    EditorClipActivity.this.T0.setTriming(true);
                }
            }
        }

        /* synthetic */ s0(EditorClipActivity editorClipActivity, k kVar) {
            this();
        }
    }

    class t implements Runnable {
        t() {
        }

        public void run() {
            EditorClipActivity.this.n0.setVisibility(0);
            EditorClipActivity.this.W.setVisibility(0);
        }
    }

    class u implements Runnable {
        u() {
        }

        public void run() {
            EditorClipActivity.this.X.setEnabled(true);
        }
    }

    class v extends AsyncTask<Void, Void, Void> {
        v() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            EditorClipActivity.this.s1.a0(EditorClipActivity.this.f8720m);
            return null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(Void r1) {
            EditorClipActivity.this.z4();
        }
    }

    /* access modifiers changed from: package-private */
    public class w implements Runnable {
        w() {
        }

        public void run() {
            try {
                Iterator<String> it = EditorClipActivity.this.F.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (next.contains("_ffvideo_") || next.contains("_reversevideo_")) {
                        com.xvideostudio.videoeditor.x0.m0.l(next);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class x implements Runnable {
        x() {
        }

        public void run() {
            try {
                Iterator<String> it = EditorClipActivity.this.F.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (com.xvideostudio.videoeditor.x0.m0.U(EditorClipActivity.this.G)) {
                        boolean z = true;
                        Iterator<MediaClip> it2 = EditorClipActivity.this.f8720m.getClipArray().iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                MediaClip next2 = it2.next();
                                if (next2 != null && next.equalsIgnoreCase(next2.path)) {
                                    z = false;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        if (z && (next.contains("_ffvideo_") || next.contains("_reversevideo_"))) {
                            com.xvideostudio.videoeditor.x0.m0.l(next);
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class y implements Runnable {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ boolean f8050f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ boolean f8051g;

        class a implements Runnable {
            a() {
            }

            public void run() {
                EditorClipActivity.this.g0.setImageBitmap(EditorClipActivity.this.h0);
            }
        }

        class b implements Runnable {
            b() {
            }

            public void run() {
                EditorClipActivity.this.g0.setImageBitmap(EditorClipActivity.this.h0);
            }
        }

        class c implements Runnable {

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ int f8055f;

            c(int i2) {
                this.f8055f = i2;
            }

            public void run() {
                if (EditorClipActivity.this.h0 != null) {
                    EditorClipActivity.this.g0.setImageBitmap(EditorClipActivity.this.h0);
                    int i2 = this.f8055f;
                    if (i2 == 90) {
                        EditorClipActivity.this.g0.j();
                    } else if (i2 == 180) {
                        EditorClipActivity.this.g0.j();
                        EditorClipActivity.this.g0.j();
                    } else if (i2 == 270) {
                        EditorClipActivity.this.g0.j();
                        EditorClipActivity.this.g0.j();
                        EditorClipActivity.this.g0.j();
                    }
                }
                if (EditorClipActivity.this.a0.isZoomClip || EditorClipActivity.this.a0.lastRotation != 0) {
                    EditorClipActivity editorClipActivity = EditorClipActivity.this;
                    editorClipActivity.a0 = editorClipActivity.g0.h(EditorClipActivity.this.a0, false);
                }
                EditorClipActivity editorClipActivity2 = EditorClipActivity.this;
                editorClipActivity2.e0 = (MediaClip) com.xvideostudio.videoeditor.x0.j0.b(editorClipActivity2.a0);
                EditorClipActivity.this.z4();
            }
        }

        y(boolean z, boolean z2) {
            this.f8050f = z;
            this.f8051g = z2;
        }

        public void run() {
            synchronized (EditorClipActivity.this.a0) {
                int i2 = EditorClipActivity.this.a0.index;
                if (EditorClipActivity.this.p0 == i2) {
                    EditorClipActivity.this.h0.c();
                    h.a.b bVar = EditorClipActivity.this.h0;
                    EditorClipActivity editorClipActivity = EditorClipActivity.this;
                    bVar.b(h.a.a.d(editorClipActivity.j4(editorClipActivity.a0, this.f8050f)), true);
                    if (EditorClipActivity.this.p0 == i2) {
                        if (!this.f8050f) {
                            MediaClip mediaClip = EditorClipActivity.this.g0.getMediaClip();
                            if (mediaClip != null && (mediaClip.isZoomClip || mediaClip.lastRotation != 0)) {
                                EditorClipActivity.this.d1 = Boolean.TRUE;
                                mediaClip = EditorClipActivity.this.g0.h(mediaClip, false);
                            }
                            if (!(mediaClip == null || EditorClipActivity.this.f8720m.getClipArray() == null || EditorClipActivity.this.f8720m.getClipArray().size() <= mediaClip.index)) {
                                EditorClipActivity.this.f8720m.getClipArray().set(mediaClip.index, mediaClip);
                                EditorClipActivity.this.g0.i(EditorClipActivity.this.p1, EditorClipActivity.this.q1);
                                EditorClipActivity.this.g0.setMediaClip(EditorClipActivity.this.a0);
                                if (EditorClipActivity.this.h0 != null) {
                                    EditorClipActivity.this.l0.post(new a());
                                }
                            }
                        } else if (!this.f8051g) {
                            EditorClipActivity.this.g0.i(EditorClipActivity.this.p1, EditorClipActivity.this.q1);
                            EditorClipActivity.this.g0.setMediaClip(EditorClipActivity.this.a0);
                            if (EditorClipActivity.this.h0 != null) {
                                EditorClipActivity.this.l0.post(new b());
                            }
                        } else {
                            EditorClipActivity.this.g0.i(EditorClipActivity.this.p1, EditorClipActivity.this.q1);
                            int i3 = EditorClipActivity.this.a0.lastRotation;
                            EditorClipActivity.this.a0.lastRotation = 0;
                            EditorClipActivity.this.g0.setMediaClip(EditorClipActivity.this.a0);
                            EditorClipActivity.this.l0.post(new c(i3));
                        }
                    }
                }
            }
        }
    }

    class z implements Runnable {
        z() {
        }

        public void run() {
            EditorClipActivity.this.a0.startTime = Tools.N(EditorClipActivity.this.a0.path, EditorClipActivity.this.a0.startTime, Tools.q.mode_closer);
            if (EditorClipActivity.this.a0.startTime < 0) {
                EditorClipActivity.this.a0.startTime = 0;
            }
            if (EditorClipActivity.this.a0.startTime > EditorClipActivity.this.a0.endTime) {
                EditorClipActivity.this.a0.startTime -= 1000;
            }
        }
    }

    private boolean A4() {
        int i2 = this.B;
        return i2 == 1 || i2 == 6;
    }

    /* access modifiers changed from: private */
    /* renamed from: B4 */
    public /* synthetic */ void C4(DialogInterface dialogInterface, int i2) {
        dialogInterface.dismiss();
        this.I0 = 1;
    }

    /* access modifiers changed from: private */
    /* renamed from: D4 */
    public /* synthetic */ void E4(DialogInterface dialogInterface, int i2) {
        dialogInterface.dismiss();
        this.I0 = 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: F4 */
    public /* synthetic */ void G4(View view) {
        this.a0.endTime = ((Integer) view.getTag()).intValue();
        MediaClip mediaClip = (MediaClip) com.xvideostudio.videoeditor.x0.j0.b(this.f0);
        this.h1 = mediaClip;
        int i2 = this.a0.endTime + 1;
        mediaClip.startTime = i2;
        mediaClip.startTime = Tools.N(mediaClip.path, i2, Tools.q.mode_closer);
        MediaClip mediaClip2 = this.h1;
        if (mediaClip2.endTime == 0) {
            mediaClip2.endTime = mediaClip2.duration;
        }
        MediaClip mediaClip3 = this.a0;
        if (mediaClip3.endTime - mediaClip3.startTime < 1000 || mediaClip2.endTime - mediaClip2.startTime < 1000) {
            com.xvideostudio.videoeditor.tool.m.n(2131820728);
            com.xvideostudio.videoeditor.x0.p2.b.a(0, "SPLIT_CLICK_SPLITVIDEO_FAIL", null);
            return;
        }
        com.xvideostudio.videoeditor.x0.p2.b.a(0, "SPLIT_CLICK_SPLITVIDEO_SUC", null);
        this.t0 = true;
        u4();
        R4(this.a0);
        P4(0);
        m1.a(this.U, "CLICK_EDITORCLIP_SPLIT_OK");
        if (this.h1 != null) {
            this.d1 = Boolean.TRUE;
            this.f8720m.getClipArray().add(this.q0.getSortClipAdapter().p() + 1, this.h1);
            this.q0.g(this.f8720m.getClipArray(), this.q0.getSortClipAdapter().p() + 1);
            this.q0.getSortClipAdapter().v(1);
            this.f8720m.updateIndex();
            this.a0 = this.q0.getSortClipAdapter().o();
            h4(this.q0.getSortClipAdapter().p(), false, false);
            this.p0 = this.q0.getSortClipAdapter().p();
        }
        this.m1 = (ArrayList) com.xvideostudio.videoeditor.x0.j0.b(this.f8720m.getClipArray());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void H4() {
        if (this.f8721n.h0()) {
            this.f8721n.j0();
            this.W.setVisibility(0);
            this.T0.setTriming(true);
        }
    }

    private void I4() {
        int i2;
        x4.b = false;
        int e4 = e4();
        if (e4 == 2) {
            W4(true);
            int i3 = this.J;
            if (i3 == 0 && ((i2 = this.K) == 0 || i2 == this.a0.duration)) {
                Tools.f0((Activity) this.U, this.y1, this.E, this.H, 0, 0, 1, this.L, this.M, this.I, true);
            } else {
                Tools.f0((Activity) this.U, this.y1, this.E, this.H, i3, this.K, 1, this.L, this.M, this.I, true);
            }
        } else if (e4 == 1) {
            if (this.j1) {
                m1.a(this.U, "REVERSE_PREVIEW_FILE_EXIST");
                Message message = new Message();
                message.what = 6;
                message.obj = this.G;
                Handler handler = this.y1;
                if (handler != null) {
                    handler.sendMessage(message);
                    return;
                }
                return;
            }
            m1.a(this.U, "REVERSE_ENCODE_FILE_EXIST");
            Message message2 = new Message();
            message2.what = 7;
            message2.obj = this.G;
            Handler handler2 = this.y1;
            if (handler2 != null) {
                handler2.sendMessage(message2);
            }
        } else if (e4 == 3) {
            if (this.j1) {
                m1.a(this.U, "REVERSE_PREVIEW_NO_SPACE");
            } else {
                m1.a(this.U, "REVERSE_ENCODE_NO_SPACE");
            }
            Message message3 = new Message();
            message3.what = 9;
            message3.obj = this.G;
            Handler handler3 = this.y1;
            if (handler3 != null) {
                handler3.sendMessage(message3);
            }
        } else if (e4 == 4) {
            m1.a(this.U, "REVERSE_ENCODE_TOO_SHORT");
        } else if (e4 == 5) {
            m1.a(this.U, "REVERSE_ENCODE_TRANSCOING");
            com.xvideostudio.videoeditor.tool.m.n(2131821294);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void J4() {
        MediaClip mediaClip = this.a0;
        if (mediaClip != null && mediaClip.mediaType == 0) {
            if (Math.min(mediaClip.video_w_real, mediaClip.video_h_real) > hl.productor.fxlib.h.f13178d) {
                m1.a(this.U, "REVERSE_CLIP_EDIT_SHOW_RESOLUTION_TOO_HIGH");
                com.xvideostudio.videoeditor.tool.m.t(this.U.getResources().getString(2131821636), -1, 1);
                return;
            }
            I4();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void K4() {
        m1.a(this.U, "CLICK_EDITORCLIP_ROTATE");
        h.a.x.e eVar = this.f8721n;
        if (eVar == null || !eVar.h0()) {
            this.f8720m.isEditorClip = true;
            this.g0.j();
            this.a0.lastRotation = this.g0.getRotate();
            MediaClip mediaClip = this.a0;
            if (mediaClip.isZoomClip || mediaClip.lastRotation != 0) {
                this.d1 = Boolean.TRUE;
                this.e0 = this.g0.h(this.e0, false);
                this.a0 = this.g0.h(this.a0, false);
            } else {
                mediaClip.adjustHeight = 0;
                mediaClip.adjustWidth = 0;
                mediaClip.topleftXLoc = 0;
                mediaClip.topleftYLoc = 0;
                mediaClip.lastMatrixValue = new float[9];
                mediaClip.picWidth = 0;
                mediaClip.picHeight = 0;
                mediaClip.isZoomClip = false;
                MediaClip mediaClip2 = this.e0;
                mediaClip2.adjustHeight = 0;
                mediaClip2.adjustWidth = 0;
                mediaClip2.topleftXLoc = 0;
                mediaClip2.topleftYLoc = 0;
                mediaClip2.lastRotation = 0;
                mediaClip2.lastMatrixValue = new float[9];
                mediaClip2.picWidth = 0;
                mediaClip2.picHeight = 0;
                mediaClip2.isZoomClip = false;
            }
            if (this.B == 3) {
                this.n0.setVisibility(8);
            } else {
                this.n0.setVisibility(0);
            }
            this.W.setVisibility(0);
            MediaClip mediaClip3 = this.e0;
            MediaClip mediaClip4 = this.a0;
            mediaClip3.startTime = mediaClip4.startTime;
            mediaClip3.endTime = mediaClip4.endTime;
            if (this.v0) {
                hl.productor.fxlib.h.P = false;
            }
            z4();
            d1();
            return;
        }
        com.xvideostudio.videoeditor.tool.m.o(2131822216, 0);
    }

    private void L4() {
        MediaClip mediaClip = this.a0;
        if (mediaClip.mediaType != VideoEditData.VIDEO_TYPE) {
            return;
        }
        if (mediaClip.isZoomClip || mediaClip.lastRotation != 0) {
            this.d1 = Boolean.TRUE;
            this.a0 = this.g0.h(mediaClip, false);
        }
    }

    private void M4() {
        Boolean bool = Boolean.TRUE;
        if (this.a0 != null) {
            if (this.z0.getVisibility() == 0) {
                this.d1 = bool;
                if (this.I0 == 0) {
                    m1.a(this.U, "CLICK_EDITORCLIP_CURRENT_PICTURE_DURATION");
                } else {
                    m1.a(this.U, "CLICK_EDITORCLIP_ALL_PICTURE_DURATION");
                }
                com.xvideostudio.videoeditor.tool.w.E0(this.U, this.I0);
                g5(this.a0.duration, this.I0);
                this.w0.setText(o4(0));
                MediaClip mediaClip = this.a0;
                int i2 = mediaClip.endTime;
                if (i2 == 0) {
                    i2 = mediaClip.duration;
                }
                this.x0.setText(o4(i2));
                if (this.Z) {
                    this.q0.getSortClipAdapter().notifyDataSetChanged();
                    this.Z = false;
                } else {
                    this.q0.getSortClipAdapter().D(this.p0);
                }
                m1.a(this.U, "CLICK_EDITORCLIP_DURATION_OK");
            } else if (this.L0.getVisibility() == 0) {
                this.d1 = bool;
                m1.a(this.U, "CLICK_EDITORCLIP_TRIM_OK");
                this.t0 = true;
                u4();
                R4(this.a0);
                this.q0.getSortClipAdapter().D(this.p0);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void N4(float f2) {
        com.xvideostudio.videoeditor.r rVar;
        if (this.f8721n != null && (rVar = this.s1) != null) {
            int e2 = rVar.e(f2);
            ArrayList<FxMediaClipEntity> clipList = this.s1.b().getClipList();
            if (clipList != null && clipList.size() > e2) {
                String str = "EditorActivityStatesEntity.FX_STATE_PLAY_VIDEO_PREPARED tmp_cur_clip_index:" + e2;
                if (clipList.get(e2).type == hl.productor.fxlib.a0.Image) {
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void O4(float f2) {
        h.a.x.e eVar = this.f8721n;
        if (eVar != null && this.s1 != null && this.e0 != null) {
            eVar.L0(f2);
        }
    }

    private void P() {
        MediaClip mediaClip;
        this.V = (RelativeLayout) findViewById(C1524R$id.rl_editor_content);
        Toolbar toolbar = (Toolbar) findViewById(2131297930);
        this.e1 = toolbar;
        toolbar.setTitle(getResources().getText(2131822017));
        T0(this.e1);
        M0().s(true);
        this.e1.setNavigationIcon(C1523R$drawable.ic_cross_white);
        this.O0 = (TextView) findViewById(C1524R$id.tv_touch_tip);
        this.P0 = (RelativeLayout) findViewById(C1524R$id.rl_cover_view);
        this.Q0 = findViewById(C1524R$id.toolbar_cover_view);
        this.R0 = (Button) findViewById(C1524R$id.btn_split);
        this.X = (Button) findViewById(C1524R$id.bt_video_sound_mute);
        TextView textView = (TextView) findViewById(C1524R$id.tv_video_zoom_hint);
        StoryBoardViewOne storyBoardViewOne = (StoryBoardViewOne) findViewById(C1524R$id.choose_storyboard_view);
        this.q0 = storyBoardViewOne;
        storyBoardViewOne.setMoveListener(this);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(C1524R$id.llmoment);
        TextView textView2 = (TextView) findViewById(C1524R$id.editor_clip_tv_bar_1);
        this.w0 = textView2;
        textView2.setShadowLayer(3.0f, 0.0f, 0.0f, -16777216);
        TextView textView3 = (TextView) findViewById(C1524R$id.editor_clip_tv_bar_2);
        this.x0 = textView3;
        textView3.setShadowLayer(3.0f, 0.0f, 0.0f, -16777216);
        MSeekbarNew mSeekbarNew = (MSeekbarNew) findViewById(C1524R$id.editor_clip_seekbar);
        this.y0 = mSeekbarNew;
        mSeekbarNew.setTouchable(true);
        this.y0.setProgress(0.0f);
        this.y0.setmOnSeekBarChangeListener(new o0());
        this.i0 = AbstractConfigActivity.t;
        this.j0 = AbstractConfigActivity.u;
        this.X.setOnClickListener(this);
        Button button = (Button) findViewById(C1524R$id.btn_video_play);
        this.W = button;
        button.setOnClickListener(this);
        int i2 = (VideoEditorApplication.x * 494) / 1920;
        this.q0.setVisibility(0);
        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(C1524R$id.video_edit_container);
        this.n0 = (RelativeLayout) findViewById(C1524R$id.conf_preview_container);
        RelativeLayout relativeLayout3 = (RelativeLayout) findViewById(C1524R$id.conf_rl_fx_openglview);
        this.r1 = relativeLayout3;
        relativeLayout3.setOnClickListener(this);
        ZoomImageView zoomImageView = (ZoomImageView) findViewById(C1524R$id.clip_zoom_view);
        this.g0 = zoomImageView;
        zoomImageView.setBackgroundColor(hl.productor.fxlib.h.T);
        this.g0.setMediaClip(this.a0);
        this.g0.setOnZoomTouchListener(this.o1);
        this.o0 = (RelativeLayout) findViewById(C1524R$id.clip_float_container);
        this.l0 = new s0(this, null);
        p0 p0Var = new p0();
        this.P0.setOnClickListener(this);
        this.Q0.setOnClickListener(this);
        this.R0.setOnClickListener(this);
        MediaDatabase mediaDatabase = this.f8720m;
        if (mediaDatabase != null) {
            this.q0.setData(mediaDatabase.getClipArray());
            this.q0.getSortClipGridView().smoothScrollToPosition(0);
            this.q0.getSortClipAdapter().A(this);
            this.q0.getSortClipAdapter().z(p0Var);
            this.q0.getSortClipAdapter().E(true);
            this.q0.getSortClipAdapter().C(C1523R$drawable.edit_clip_select_bg);
            if (A4()) {
                this.q0.getSortClipAdapter().B(true);
            } else {
                this.q0.getSortClipAdapter().B(false);
            }
            this.q0.getSortClipAdapter().D(this.p0);
            s4();
            y4();
            x4();
            this.A0 = (RelativeLayout) findViewById(C1524R$id.rl_zoom);
            CardView cardView = (CardView) findViewById(C1524R$id.cv_rotate);
            this.B0 = cardView;
            cardView.setOnClickListener(this.z1);
            CardView cardView2 = (CardView) findViewById(C1524R$id.cv_clip_reverse);
            this.C0 = cardView2;
            cardView2.setOnClickListener(this.z1);
            this.D0 = (LinearLayout) findViewById(C1524R$id.ll_clip_reverse_image);
            this.E0 = (LinearLayout) findViewById(C1524R$id.ll_clip_speed);
            this.F0 = (LinearLayout) findViewById(C1524R$id.ll_clip_speed_image);
            this.G0 = (LinearLayout) findViewById(C1524R$id.ll_clip_split_image);
            this.B1 = (SetTextSizeView) findViewById(C1524R$id.stsv_seekbar);
            this.C1 = (TextView) findViewById(C1524R$id.tv_speed);
            this.B1.setOnPointResultListener(this);
            Q4();
            this.D1 = (Button) findViewById(C1524R$id.bt_trim_time);
            if (!A4() || (mediaClip = this.a0) == null || mediaClip.mediaType != VideoEditData.VIDEO_TYPE) {
                this.D1.setVisibility(8);
            } else {
                this.D1.setVisibility(0);
            }
            this.D1.setOnClickListener(new q0());
            w4();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void P4(int i2) {
        if (i2 == 1) {
            MediaClip mediaClip = this.a0;
            this.c0 = mediaClip.startTime;
            int i3 = mediaClip.endTime;
            if (i3 == 0) {
                i3 = mediaClip.duration;
            }
            this.d0 = i3;
            this.f1 = i2;
            this.L0.setVisibility(0);
            this.z0.setVisibility(8);
            this.D.setVisibility(4);
            this.A0.setVisibility(8);
            this.B0.setVisibility(8);
            this.C0.setVisibility(8);
            this.D0.setVisibility(8);
            this.E0.setVisibility(8);
            this.F0.setVisibility(8);
            this.G0.setVisibility(8);
            this.U0.setVisibility(8);
            this.D1.setVisibility(0);
            this.T0.setMinMaxValue(this.a0);
            this.T0.setProgress(0.0f);
            this.M0.setText(p4(this.a0.startTime));
            TextView textView = this.N0;
            MediaClip mediaClip2 = this.a0;
            int i4 = mediaClip2.endTime;
            if (i4 == 0) {
                i4 = mediaClip2.duration;
            }
            textView.setText(p4(i4));
            TextView textView2 = this.O0;
            MediaClip mediaClip3 = this.a0;
            int i5 = mediaClip3.endTime;
            textView2.setText(p4((i5 == 0 ? mediaClip3.duration : i5 - mediaClip3.startTime) / 2));
            TrimSeekBar trimSeekBar = this.T0;
            MediaClip mediaClip4 = this.a0;
            if (trimSeekBar.n(mediaClip4.path, mediaClip4)) {
                this.T0.m(this.a0.duration, this.m0);
            }
        } else if (i2 == 2) {
            this.b0 = this.a0.duration;
            this.f1 = i2;
            this.L0.setVisibility(8);
            this.z0.setVisibility(0);
            this.D.setVisibility(0);
            this.A0.setVisibility(8);
            this.B0.setVisibility(8);
            this.C0.setVisibility(8);
            this.D0.setVisibility(8);
            this.E0.setVisibility(8);
            this.F0.setVisibility(8);
            this.G0.setVisibility(8);
            this.U0.setVisibility(8);
            this.D1.setVisibility(8);
            int R2 = com.xvideostudio.videoeditor.tool.w.R(this.U);
            this.I0 = R2;
            if (R2 == 0) {
                this.H0.setChecked(false);
            } else {
                this.H0.setChecked(true);
            }
            this.J0.setText(z0.d(((float) this.a0.duration) / 1000.0f) + "s");
            this.K0.setProgress(((int) ((((float) this.a0.duration) / 1000.0f) * 10.0f)) - 1);
        } else if (i2 == 4) {
            this.A0.setVisibility(8);
            this.B0.setVisibility(8);
            this.C0.setVisibility(8);
            this.D0.setVisibility(8);
            this.E0.setVisibility(8);
            this.F0.setVisibility(8);
            this.L0.setVisibility(0);
            this.z0.setVisibility(8);
            this.D.setVisibility(4);
            this.T0.setVisibility(8);
            this.O0.setVisibility(0);
            MediaClip mediaClip5 = this.a0;
            if (mediaClip5.mediaType == VideoEditData.IMAGE_TYPE) {
                this.G0.setVisibility(0);
                this.U0.setVisibility(8);
                return;
            }
            this.c0 = mediaClip5.startTime;
            int i6 = mediaClip5.endTime;
            if (i6 == 0) {
                i6 = mediaClip5.duration;
            }
            this.d0 = i6;
            this.f1 = i2;
            invalidateOptionsMenu();
            this.G0.setVisibility(8);
            this.U0.setVisibility(0);
            this.U0.setThumbValueOriginal(this.a0);
            this.U0.setProgress(0.5f);
            this.O0.setText(p4((this.d0 - this.c0) / 2));
            this.M0.setText(p4(0));
            this.N0.setText(p4(this.d0 - this.c0));
            SplitSeekBar splitSeekBar = this.U0;
            MediaClip mediaClip6 = this.a0;
            if (splitSeekBar.o(mediaClip6.path, mediaClip6)) {
                SplitSeekBar splitSeekBar2 = this.U0;
                int i7 = this.d0;
                int i8 = this.c0;
                splitSeekBar2.n(i7 - i8, i8, this.m0);
            }
        }
    }

    private void Q4() {
        MediaClip mediaClip = this.a0;
        if (mediaClip != null) {
            float f2 = mediaClip.videoPlaySpeed;
            mediaClip.videoPlaySpeedTmp = f2;
            this.B1.setCurrentProgress(r4(f2));
            S4(r4(this.a0.videoPlaySpeed));
        }
    }

    private void R4(MediaClip mediaClip) {
        if (mediaClip.mediaType == VideoEditData.IMAGE_TYPE) {
            this.w0.setText(o4(0));
            MediaClip mediaClip2 = this.a0;
            int i2 = mediaClip2.endTime;
            if (i2 == 0) {
                i2 = mediaClip2.duration;
            }
            this.x0.setText(o4(i2));
            this.y0.setMax(((float) i2) / 1000.0f);
            this.y0.setProgress(0.0f);
            return;
        }
        this.w0.setText(o4(0));
        MediaClip mediaClip3 = this.a0;
        int i3 = mediaClip3.endTime;
        if (i3 == 0) {
            i3 = mediaClip3.duration;
        }
        this.x0.setText(o4(i3 - mediaClip3.startTime));
        this.y0.setMax(((float) (i3 - this.a0.startTime)) / 1000.0f);
        this.y0.setProgress(0.0f);
    }

    private void S4(int i2) {
        if (i2 == 0) {
            this.A1 = 0.25f;
        } else if (i2 == 1) {
            this.A1 = 0.3f;
        } else {
            this.A1 = (((float) (i2 - 1)) * 0.1f) + 0.3f;
            this.A1 = new BigDecimal((double) this.A1).setScale(1, 4).floatValue();
        }
        this.C1.setText(this.A1 + "x");
        String str = "==" + i2 + "=====" + this.A1;
    }

    private void T4() {
        MediaDatabase mediaDatabase;
        if (this.K1 != null && (mediaDatabase = this.f8720m) != null && mediaDatabase.getClipArray() != null) {
            int size = this.f8720m.getClipArray().size();
            int i2 = this.p0;
            if (size <= i2 || this.f8720m.getClip(i2).mediaType != VideoEditData.IMAGE_TYPE) {
                this.K1.setVisibility(0);
            } else {
                h5();
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void U4(boolean z2) {
        MediaClip mediaClip;
        int i2;
        h.a.x.e eVar = this.f8721n;
        if (eVar != null && this.e0 != null && (mediaClip = this.a0) != null && mediaClip.duration > 0) {
            if (eVar.h0()) {
                this.f8721n.j0();
            }
            int i3 = 0;
            this.n0.setVisibility(0);
            this.W.setVisibility(0);
            MediaClip mediaClip2 = this.e0;
            if (!(mediaClip2.startTime == 0 && ((i2 = mediaClip2.endTime) == 0 || i2 == mediaClip2.duration))) {
                mediaClip2.startTime = 0;
                mediaClip2.endTime = mediaClip2.duration;
                this.k1 = ((float) this.a0.startTime) / 1000.0f;
            }
            MediaClip mediaClip3 = this.a0;
            if (mediaClip3.endTime == 0) {
                mediaClip3.endTime = mediaClip3.duration;
            }
            l0 l0Var = new l0();
            int mediaTotalTime = (int) (this.s1.b().getMediaTotalTime() * 1000.0f);
            MediaClip mediaClip4 = this.a0;
            int i4 = mediaClip4.duration;
            int i5 = i4 > mediaTotalTime ? i4 : mediaTotalTime;
            if (z2) {
                com.xvideostudio.videoeditor.x0.e0.J(this.U, l0Var, null, i5, this.b1, mediaClip4.startTime, mediaClip4.endTime, 5);
                return;
            }
            h.a.x.e eVar2 = this.f8721n;
            if (eVar2 != null) {
                i3 = (int) (eVar2.H() * 1000.0f);
            }
            if (i3 == 0) {
                MediaClip mediaClip5 = this.a0;
                i3 = (mediaClip5.endTime - mediaClip5.startTime) / 2;
            }
            Context context = this.U;
            x2 x2Var = new x2(this);
            MediaClip mediaClip6 = this.a0;
            this.E1 = com.xvideostudio.videoeditor.x0.e0.t(context, x2Var, i3, mediaClip6.startTime, mediaClip6.endTime);
        }
    }

    private void W4(boolean z2) {
        Dialog dialog = this.O;
        if (dialog == null || !dialog.isShowing()) {
            View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(C1527R$layout.dialog_export_ff_speed_transcoding, (ViewGroup) null);
            this.O = null;
            Dialog dialog2 = new Dialog(this, 2131886886);
            this.O = dialog2;
            dialog2.setContentView(inflate);
            Window window = this.O.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -2;
            attributes.gravity = 80;
            window.setAttributes(attributes);
            window.setWindowAnimations(C1533R$style.sticker_popup_animation);
            ProgressBar progressBar = (ProgressBar) inflate.findViewById(2131297500);
            this.P = progressBar;
            progressBar.setClickable(false);
            this.P.setEnabled(false);
            this.O.setCanceledOnTouchOutside(false);
            this.P.setFocusableInTouchMode(false);
            this.Q = (TextView) inflate.findViewById(C1524R$id.tv_export_speed_transcoding_title);
            this.P.setMax(100);
            this.P.setProgress(0);
            TextView textView = (TextView) inflate.findViewById(C1524R$id.tv_export_speed_transcoding_progress);
            this.R = textView;
            textView.setText("0%");
            RobotoBoldButton robotoBoldButton = (RobotoBoldButton) inflate.findViewById(C1524R$id.bt_dialog_cancel);
            robotoBoldButton.setText(2131820930);
            robotoBoldButton.setOnClickListener(new f0(robotoBoldButton, z2));
            this.O.setOnKeyListener(new h0(robotoBoldButton, z2));
            this.O.setCancelable(false);
            if (!isFinishing()) {
                this.O.show();
            }
        }
    }

    private void X4() {
        com.xvideostudio.videoeditor.x0.e0.R(this, "", getString(2131821649), false, false, new q(), new r(), new s(this), true);
    }

    private void Y4() {
        this.L0.setVisibility(8);
        this.z0.setVisibility(8);
        this.D.setVisibility(4);
        this.A0.setVisibility(8);
        this.B0.setVisibility(8);
        if (this.a0.mediaType == VideoEditData.IMAGE_TYPE) {
            this.C0.setVisibility(8);
            this.D0.setVisibility(0);
        } else {
            this.C0.setVisibility(0);
            this.D0.setVisibility(8);
        }
        this.E0.setVisibility(8);
        this.F0.setVisibility(8);
        this.G0.setVisibility(8);
    }

    private void Z4() {
        this.L0.setVisibility(8);
        this.z0.setVisibility(8);
        this.D.setVisibility(4);
        this.A0.setVisibility(8);
        this.B0.setVisibility(0);
        this.C0.setVisibility(8);
        this.D0.setVisibility(8);
        this.E0.setVisibility(8);
        this.F0.setVisibility(8);
        this.G0.setVisibility(8);
    }

    private void a5() {
        this.L0.setVisibility(8);
        this.z0.setVisibility(8);
        this.D.setVisibility(4);
        this.A0.setVisibility(8);
        this.B0.setVisibility(8);
        this.C0.setVisibility(8);
        this.D0.setVisibility(8);
        this.G0.setVisibility(8);
        if (this.a0.mediaType == VideoEditData.IMAGE_TYPE) {
            this.E0.setVisibility(8);
            this.F0.setVisibility(0);
            return;
        }
        this.E0.setVisibility(0);
        this.F0.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void b5(int[] iArr, String str) {
        com.xvideostudio.videoeditor.x0.e0.F(this.U, "", getString(2131822056), new i0(iArr, str), new j0()).show();
    }

    private void c4() {
        View inflate = LayoutInflater.from(this.U).inflate(C1527R$layout.dialog_add_clip_select, (ViewGroup) null);
        Dialog dialog = new Dialog(this.U, 2131886886);
        dialog.setContentView(inflate);
        Window window = dialog.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        attributes.gravity = 80;
        window.setAttributes(attributes);
        ((LinearLayout) inflate.findViewById(C1524R$id.rv_select_clips_editor)).setOnClickListener(new c0(dialog));
        ((LinearLayout) inflate.findViewById(C1524R$id.rv_add_blank_clips_editor)).setOnClickListener(new d0(dialog));
        if (!isFinishing() && this.u0) {
            dialog.show();
        }
    }

    private void c5() {
        MediaClip mediaClip;
        ZoomImageView zoomImageView;
        this.L0.setVisibility(8);
        this.z0.setVisibility(8);
        this.D.setVisibility(4);
        this.A0.setVisibility(0);
        this.B0.setVisibility(8);
        this.C0.setVisibility(8);
        this.D0.setVisibility(8);
        this.E0.setVisibility(8);
        this.F0.setVisibility(8);
        this.G0.setVisibility(8);
        m1.a(this.U, "CLICK_EDITORCLIP_ZOOM");
        h.a.x.e eVar = this.f8721n;
        if (eVar != null && eVar.h0()) {
            this.f8721n.j0();
        }
        if (!(this.f8721n == null || (mediaClip = this.e0) == null || mediaClip.mediaType != VideoEditData.VIDEO_TYPE || (zoomImageView = this.g0) == null || zoomImageView.getMediaClip() == null || this.g0.getMediaClip().index != this.e0.index)) {
            float H2 = this.f8721n.H();
            this.k1 = H2;
            h.a.a d2 = h.a.a.d(k4(this.a0, (int) ((H2 * 1000.0f) + ((float) this.e0.startTime))));
            if (d2 != null) {
                this.h0.c();
                this.h0.b(d2, true);
                this.g0.setMediaClip(this.a0);
                this.g0.setImageBitmap(this.h0);
            }
        }
        this.n0.setVisibility(8);
        this.W.setVisibility(0);
        this.g0.setIsZommTouch(true);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void d4() {
        View inflate = LayoutInflater.from(this).inflate(C1527R$layout.dialog_evaluate_use_text_filmigo, (ViewGroup) null);
        ((TextView) inflate.findViewById(C1524R$id.tv_content)).setText(2131820919);
        androidx.appcompat.app.b create = new b.a(new androidx.appcompat.d.d(this, (int) C1533R$style.rate_dialog_filmigo)).setView(inflate).create();
        create.k(-1, getString(2131820866), new q2(this));
        create.k(-2, getString(2131820848), new w2(this));
        create.setCanceledOnTouchOutside(true);
        create.show();
        create.g(-2).setTextColor(getResources().getColor(C1521R$color.evaluate_negative_text_color_filmigo));
        create.g(-1).setTextColor(getResources().getColor(2131099807));
        create.g(-1).setTypeface(Typeface.createFromAsset(getAssets(), "font/Roboto-Bold.ttf"));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void d5(boolean z2) {
        Handler handler;
        if (z2) {
            m1.a(this.U, "REVERSE_CLIP_EDIT_STOP_ENCODING");
        } else if (this.j1) {
            m1.a(this.U, "FF_PREVIEW_ABORT_ENCODING");
        } else {
            m1.a(this.U, "FF_ENCODE_ABORT_ENCODING");
        }
        Dialog dialog = this.O;
        if (dialog != null && dialog.isShowing() && (handler = this.y1) != null) {
            if (z2) {
                TextView textView = this.Q;
                textView.setText(getString(2131820930) + "...");
                this.y1.sendEmptyMessage(8);
                return;
            }
            handler.sendEmptyMessage(3);
            this.O.dismiss();
            this.O = null;
        }
    }

    private int e4() {
        int i2;
        String str;
        long j2;
        int i3;
        if (!Tools.C) {
            return 5;
        }
        MediaClip mediaClip = this.a0;
        if (mediaClip == null) {
            return 0;
        }
        int i4 = mediaClip.duration;
        this.N = false;
        int i5 = mediaClip.endTime;
        int i6 = 1;
        if (i5 != 0) {
            i2 = i5 - mediaClip.startTime;
            this.N = true;
        } else {
            i2 = i4;
        }
        if (this.j1) {
            if (i2 >= 4000) {
                if (this.N) {
                    int i7 = mediaClip.startTime;
                    this.J = i7;
                    this.K = i7 + 4000;
                } else {
                    this.J = 0;
                    this.K = 4000;
                    this.N = true;
                }
            } else if (this.N) {
                this.J = mediaClip.startTime;
                this.K = i5;
            } else {
                this.J = 0;
                this.K = i4;
            }
            str = com.xvideostudio.videoeditor.l0.b.i0(3);
        } else {
            if (this.N) {
                this.J = mediaClip.startTime;
                this.K = i5;
            } else {
                this.J = 0;
                this.K = i4;
            }
            str = com.xvideostudio.videoeditor.l0.b.h0(3);
        }
        com.xvideostudio.videoeditor.x0.m0.Z(com.xvideostudio.videoeditor.l0.b.q());
        com.xvideostudio.videoeditor.x0.m0.Z(str);
        String i02 = com.xvideostudio.videoeditor.l0.b.i0(3);
        this.I = i02;
        com.xvideostudio.videoeditor.x0.m0.Z(i02);
        String str2 = com.xvideostudio.videoeditor.x0.m0.D(com.xvideostudio.videoeditor.x0.m0.C(mediaClip.path)) + "_reversevideo_" + mediaClip.duration + "_" + this.J + "_" + this.K + "_" + 0 + ".mp4";
        this.G = str + str2;
        this.H = this.I + str2 + "_" + b2.b(b2.a(), false) + ".mp4";
        String str3 = "outFilePath:" + this.G;
        String str4 = "outFilePathTmp:" + this.H;
        String str5 = "reverseTempDir:" + this.I;
        if (com.xvideostudio.videoeditor.x0.m0.U(this.G)) {
            return 1;
        }
        MediaClip mediaClip2 = this.a0;
        this.L = Math.max(mediaClip2.video_h_real, mediaClip2.video_w_real);
        MediaClip mediaClip3 = this.a0;
        this.M = Math.min(mediaClip3.video_h_real, mediaClip3.video_w_real);
        int i8 = this.L;
        if (i8 >= 1920) {
            MediaClip mediaClip4 = this.a0;
            int i9 = mediaClip4.video_w_real;
            if (i8 == i9) {
                this.L = 1920;
                int i10 = (mediaClip4.video_h_real * 1920) / i9;
                this.M = i10;
                this.M = i10 - (i10 % 8);
            } else {
                this.M = 1920;
                int i11 = (i9 * 1920) / mediaClip4.video_h_real;
                this.L = i11;
                this.L = i11 - (i11 % 8);
            }
        } else {
            MediaClip mediaClip5 = this.a0;
            this.L = mediaClip5.video_w_real;
            this.M = mediaClip5.video_h_real;
        }
        long j3 = ((long) (((((float) (mediaClip.video_w_real * mediaClip.video_h_real)) * ((((float) (this.K - this.J)) * 1.0f) / 1000.0f)) * 2.0f) / 3.0f)) / 1024;
        int i12 = VideoEditorApplication.c0() ? 2 : 1;
        long J2 = Tools.J(i12);
        if (j3 > J2) {
            if (VideoEditorApplication.A) {
                if (i12 == 1) {
                    j2 = Tools.J(2);
                    i3 = 2131821046;
                } else {
                    j2 = Tools.J(1);
                    i3 = 2131821047;
                    i6 = 0;
                }
                if (j3 >= j2) {
                    String str6 = "Have two sd card~" + getResources().getString(2131821504) + ", " + getResources().getString(2131821506) + " " + j3 + " KB, " + getResources().getString(2131821505) + " " + j2 + " KB ";
                    m1.b(this, "NOT_ENOUGHSPACE_EX_REVERSE", "model:" + Build.MODEL + ":" + str6);
                    com.xvideostudio.videoeditor.tool.m.t(str6, -1, VastVideoViewController.DEFAULT_VIDEO_DURATION_FOR_CLOSE_BUTTON);
                    return 3;
                }
                String i03 = com.xvideostudio.videoeditor.l0.b.i0(i12);
                this.I = i03;
                com.xvideostudio.videoeditor.x0.m0.Z(i03);
                com.xvideostudio.videoeditor.x0.m0.Z(com.xvideostudio.videoeditor.l0.b.q());
                EditorActivity.i8(this, i3, i6);
            } else {
                String str7 = "Only one sd card~" + getResources().getString(2131821504) + ", " + getResources().getString(2131821506) + " " + j3 + " KB, " + getResources().getString(2131821505) + " " + J2 + " KB ";
                m1.b(this, "NOT_ENOUGHSPACE_EX_REVERSE", "model:" + Build.MODEL + ":" + str7);
                com.xvideostudio.videoeditor.tool.m.t(str7, -1, VastVideoViewController.DEFAULT_VIDEO_DURATION_FOR_CLOSE_BUTTON);
                return 3;
            }
        }
        ArrayList<String> arrayList = this.E;
        if (arrayList != null) {
            arrayList.clear();
        } else {
            this.E = new ArrayList<>();
        }
        this.E.add(mediaClip.path);
        if (this.j1) {
            return 2;
        }
        if (this.F == null) {
            this.F = new ArrayList<>();
        }
        if (!this.F.contains(this.G)) {
            this.F.add(this.G);
        }
        if (this.F.contains(this.H)) {
            return 2;
        }
        this.F.add(this.H);
        return 2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void e5() {
        h.a.x.e eVar = this.f8721n;
        if (eVar != null) {
            eVar.Q0();
        }
    }

    private void f4(MediaClip mediaClip) {
        if (mediaClip.mediaType == VideoEditData.VIDEO_TYPE) {
            MediaClip mediaClip2 = this.a0;
            mediaClip2.startTime = this.c0;
            mediaClip2.endTime = this.d0;
            String str = "edit startTime--->" + this.a0.startTime + "---" + this.a0.endTime;
            this.t0 = true;
            u4();
            return;
        }
        g5(this.b0, com.xvideostudio.videoeditor.tool.w.R(this.U));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void f5(int[] iArr, String str, String str2, String str3) {
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
                    String str4 = "Have two sd card~" + getResources().getString(2131821504) + ", " + getResources().getString(2131821506) + " " + j3 + " KB, " + getResources().getString(2131821505) + " " + j2 + " KB ";
                    m1.b(this, "NOT_ENOUGHSPACE_TRANSCODE", "model:" + Build.MODEL + ":" + str4);
                    com.xvideostudio.videoeditor.tool.m.t(str4, -1, VastVideoViewController.DEFAULT_VIDEO_DURATION_FOR_CLOSE_BUTTON);
                    return;
                }
                EditorActivity.i8(this, i2, i4);
            } else {
                String str5 = "Only one sd card~" + getResources().getString(2131821504) + ", " + getResources().getString(2131821506) + " " + j3 + " KB, " + getResources().getString(2131821505) + " " + J2 + " KB ";
                m1.b(this, "NOT_ENOUGHSPACE_TRANSCODE", "model:" + Build.MODEL + ":" + str5);
                com.xvideostudio.videoeditor.tool.m.t(str5, -1, VastVideoViewController.DEFAULT_VIDEO_DURATION_FOR_CLOSE_BUTTON);
                return;
            }
        }
        File file = new File(com.xvideostudio.videoeditor.l0.b.Y(3));
        if (!file.exists()) {
            file.mkdirs();
        }
        if (z0.f(com.xvideostudio.videoeditor.x0.m0.D(str2))) {
            this.G = file + "/" + com.xvideostudio.videoeditor.l0.b.t0(this.U, ".mp4", str2, 0);
        } else {
            this.G = file + "/" + com.xvideostudio.videoeditor.l0.b.V(this.U, ".mp4", "");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        SerializeEditData c02 = Tools.c0(this.U, 0, arrayList, this.G, "", 0, 0, iArr[0], iArr[1], 0);
        Tools tools = null;
        if (str3.equals("trim")) {
            m1.b(this, "TRANSCORD_AGREE", "编辑页TRIM");
            tools = new Tools(this, 1, null, c02, "trim", Boolean.TRUE);
        } else if (str3.equals("split")) {
            m1.b(this, "TRANSCORD_AGREE", "编辑页SPLITE");
            tools = new Tools(this, 1, null, c02, "split", Boolean.TRUE);
        } else if (str3.equals("REVERSE")) {
            m1.b(this, "TRANSCORD_AGREE", "编辑页面reverse");
            tools = new Tools(this, 1, null, c02, "REVERSE", Boolean.TRUE);
        }
        if (tools.f8558c) {
            tools.l0(this, Boolean.TRUE);
        } else {
            if (str3.equals("trim")) {
                m1.b(this, "TRANSCORD_FAIL", "编辑页TRIM");
            } else if (str3.equals("split")) {
                m1.b(this, "TRANSCORD_FAIL", "编辑页SPLITE");
            } else if (str3.equals("REVERSE")) {
                m1.b(this, "TRANSCORD_FAIL", "编辑页面reverse");
            }
            com.xvideostudio.videoeditor.tool.m.t(this.U.getResources().getString(2131821052), -1, 1);
            finish();
        }
        tools.i0(new k0(Boolean.TRUE, str));
    }

    private void g4() {
        a1(this.n0);
        String str = "glViewWidth:" + AbstractConfigActivity.t;
        String str2 = "glViewHeight:" + AbstractConfigActivity.u;
        if (this.f8721n != null) {
            e5();
            this.r1.removeView(this.f8721n.K());
            this.f8721n.m0();
            this.f8721n = null;
        }
        com.xvideostudio.videoeditor.l0.c.S();
        this.s1 = null;
        this.f8721n = new h.a.x.e(this.U, this.l0);
        this.x1 = false;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(AbstractConfigActivity.t, AbstractConfigActivity.u);
        layoutParams.addRule(13);
        this.f8721n.K().setLayoutParams(layoutParams);
        com.xvideostudio.videoeditor.l0.c.U(AbstractConfigActivity.t, AbstractConfigActivity.u);
        this.r1.removeAllViews();
        this.r1.addView(this.f8721n.K());
        this.o0.bringToFront();
        this.q0.bringToFront();
        if (this.s1 == null) {
            this.f8721n.L0(0.0f);
            this.f8721n.F0(0, 1);
            this.s1 = new com.xvideostudio.videoeditor.r(this, this.f8721n, this.l0);
            Message message = new Message();
            message.what = 8;
            this.l0.sendMessage(message);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void g5(int i2, int i3) {
        if (i3 == 1) {
            ArrayList<MediaClip> clipArray = this.f8720m.getClipArray();
            if (clipArray != null) {
                Iterator<MediaClip> it = clipArray.iterator();
                while (it.hasNext()) {
                    MediaClip next = it.next();
                    if (next.mediaType == VideoEditData.IMAGE_TYPE) {
                        next.duration = i2;
                        next.durationTmp = 0;
                        this.f8720m.isUpDurtion = true;
                    }
                }
            }
            this.Z = true;
        } else {
            MediaClip mediaClip = this.a0;
            if (mediaClip != null && mediaClip.mediaType == VideoEditData.IMAGE_TYPE) {
                mediaClip.duration = i2;
                mediaClip.durationTmp = 0;
                this.f8720m.isUpDurtion = true;
            }
        }
        MediaClip mediaClip2 = this.e0;
        if (mediaClip2 != null) {
            mediaClip2.duration = i2;
            mediaClip2.durationTmp = 0;
        }
        this.t0 = true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void h4(int i2, boolean z2, boolean z3) {
        if (!this.v1 || z2) {
            this.v1 = true;
            h.a.x.e eVar = this.f8721n;
            if (eVar != null) {
                if (eVar.h0()) {
                    this.f8721n.j0();
                    this.T0.setTriming(true);
                }
                int i3 = this.B;
                if (i3 == 1) {
                    M4();
                } else if (i3 == 3) {
                    L4();
                }
                if (this.p0 != i2 || z2) {
                    MediaDatabase mediaDatabase = this.f8720m;
                    if (mediaDatabase != null && mediaDatabase.getClipArray().size() > i2 && i2 > -1) {
                        this.a0 = this.f8720m.getClip(i2);
                    }
                    if (this.a0 == null) {
                        this.v1 = false;
                        return;
                    }
                    this.p0 = i2;
                    this.q0.getSortClipAdapter().D(i2);
                    i4(false);
                    MediaClip mediaClip = this.a0;
                    if (mediaClip != null) {
                        int i4 = this.B;
                        if (i4 == 1) {
                            if (mediaClip.mediaType == VideoEditData.IMAGE_TYPE) {
                                P4(2);
                            } else {
                                P4(1);
                            }
                        } else if (i4 == 6) {
                            P4(4);
                        } else if (i4 == 2) {
                            Z4();
                        } else if (i4 == 3) {
                            c5();
                        } else if (i4 == 4) {
                            Y4();
                        } else if (i4 == 5) {
                            a5();
                        }
                        if (!z3) {
                            this.e0 = (MediaClip) com.xvideostudio.videoeditor.x0.j0.b(this.a0);
                            this.f0 = (MediaClip) com.xvideostudio.videoeditor.x0.j0.b(this.a0);
                            z4();
                        }
                        com.xvideostudio.videoeditor.tool.a0.a(1).execute(new y(z2, z3));
                        this.K1.setProgress(this.a0.videoVolume);
                        return;
                    }
                    return;
                }
                this.v1 = false;
                return;
            }
            return;
        }
        com.xvideostudio.videoeditor.tool.m.o(2131821293, 0);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void h5() {
        this.K1.l();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void i4(boolean z2) {
        MediaClip mediaClip = this.a0;
        if (mediaClip != null) {
            if (mediaClip.mediaType == VideoEditData.IMAGE_TYPE) {
                this.r0.setVisibility(4);
                this.s0 = ((int) (((float) this.a0.duration) / 1000.0f)) * 10;
                String str = "checkMediaClip curprogress" + this.s0;
                this.K0.setProgress(this.s0 - 2);
                this.J0.setText(z0.d(((float) this.a0.duration) / 1000.0f) + "s");
                this.J0.setVisibility(0);
                R4(this.a0);
                if (this.K1 != null) {
                    h5();
                }
            } else {
                this.J0.setVisibility(4);
                this.J0.setText(p4(0));
                this.r0.setVisibility(0);
                MediaClip mediaClip2 = this.a0;
                int i2 = mediaClip2.endTime;
                if (i2 == 0) {
                    i2 = mediaClip2.duration;
                }
                this.M0.setText(p4(mediaClip2.startTime));
                this.N0.setText(p4(i2));
                this.O0.setText(p4((i2 - this.a0.startTime) / 2));
                this.T0.setMinMaxValue(this.a0);
                this.T0.setProgress(0.0f);
                SeekVolume seekVolume = this.K1;
                if (seekVolume != null) {
                    seekVolume.setVisibility(0);
                }
                R4(this.a0);
            }
            com.xvideostudio.videoeditor.tool.w.E0(this.U, 0);
        }
    }

    private Bitmap k4(MediaClip mediaClip, int i2) {
        int i3;
        int i4;
        Bitmap bitmap;
        int i5;
        int i6;
        Bitmap bitmap2 = null;
        try {
            g.c.i.f fVar = new g.c.i.f();
            fVar.a(mediaClip.path, mediaClip.contentUriString);
            Bitmap frameAtTime = fVar.getFrameAtTime((long) (i2 * 1000));
            fVar.release();
            if (frameAtTime != null && !frameAtTime.isRecycled() && frameAtTime.getWidth() > 0 && frameAtTime.getHeight() > 0) {
                int i7 = this.i0;
                int i8 = this.p1;
                if (i7 >= i8) {
                    if (this.j0 >= this.q1) {
                        return (frameAtTime == null || !mediaClip.isFFRotation || (i6 = mediaClip.video_rotate) == 0) ? frameAtTime : com.xvideostudio.videoeditor.g0.a.f((float) i6, frameAtTime, true);
                    }
                }
                float min = Math.min(((float) this.j0) / ((float) this.q1), ((float) i7) / ((float) i8));
                String str = "比例大小 wRatio w > h:" + min;
                int i9 = this.p1;
                int i10 = (int) (((float) i9) * min);
                if (i9 >= this.q1) {
                    i4 = Math.max(frameAtTime.getWidth(), frameAtTime.getHeight());
                    i3 = Math.min(frameAtTime.getWidth(), frameAtTime.getHeight());
                } else {
                    i4 = Math.min(frameAtTime.getWidth(), frameAtTime.getHeight());
                    i3 = Math.max(frameAtTime.getWidth(), frameAtTime.getHeight());
                }
                if (i10 != i4) {
                    float min2 = Math.min(((float) this.j0) / ((float) i3), ((float) this.i0) / ((float) i4));
                    Matrix matrix = new Matrix();
                    matrix.postScale(min2, min2);
                    try {
                        bitmap = Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true);
                    } catch (IllegalArgumentException e2) {
                        e2.printStackTrace();
                        bitmap = null;
                    }
                    bitmap2 = (bitmap == null || !mediaClip.isFFRotation || (i5 = mediaClip.video_rotate) == 0) ? bitmap : com.xvideostudio.videoeditor.g0.a.f((float) i5, bitmap, true);
                }
            }
            if (frameAtTime != null && !frameAtTime.isRecycled()) {
                frameAtTime.recycle();
            }
            return bitmap2;
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }

    private void l4(int i2, int i3) {
        if (this.f8720m.getClipArray().size() <= i3) {
            com.xvideostudio.videoeditor.tool.m.o(2131821760, 0);
        } else {
            com.xvideostudio.videoeditor.x0.e0.z(this.U, getString(2131820995), getString(2131821921), false, new o(i2)).setOnDismissListener(new p(this));
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void m4(int i2) {
        m1.a(this.U, "CLICK_EDITORCLIP_DELETE");
        h.a.x.e eVar = this.f8721n;
        if (eVar != null && eVar.h0()) {
            com.xvideostudio.videoeditor.tool.m.o(2131822216, 0);
        } else if (A4()) {
            l4(i2, 2);
        } else {
            l4(i2, 1);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void n4(boolean z2) {
        MediaClip clip;
        this.q0.removeAllViews();
        if (!z2) {
            this.f8720m.setClipArray(this.k0);
            this.f8720m.isUpDurtion = this.Y0;
            ArrayList<String> arrayList = this.F;
            if (arrayList != null && arrayList.size() > 0) {
                com.xvideostudio.videoeditor.tool.a0.a(1).execute(new w());
            }
        } else {
            ArrayList<MediaClip> arrayList2 = (ArrayList) this.q0.getSortClipAdapter().l();
            this.f8720m.setClipArray(arrayList2);
            this.f8720m.updateIndex();
            ArrayList<String> arrayList3 = this.F;
            if (!(arrayList3 == null || arrayList3.size() <= 0 || arrayList2 == null)) {
                com.xvideostudio.videoeditor.tool.a0.a(1).execute(new x());
            }
        }
        int size = this.f8720m.getClipArray().size();
        if (size > 0 && (clip = this.f8720m.getClip(size - 1)) != null && clip.addMadiaClip == 1) {
            this.f8720m.getClipArray().remove(clip);
        }
        if (this.Z0 != null) {
            this.f8720m.getClipArray().add(0, this.Z0);
        }
        if (this.a1 != null) {
            this.f8720m.getClipArray().add(this.f8720m.getClipArray().size(), this.a1);
        }
        if (z2) {
            this.f8720m.addCameraClipAudio();
        }
        if (this.f8721n != null) {
            this.r1.removeAllViews();
            this.f8721n.m0();
        }
        Intent intent = new Intent(this.U, EditorActivity.class);
        intent.putExtra(MediaDatabase.SERIALIZABLE_EXTRA, this.f8720m);
        if (!this.g1) {
            setResult(10, intent);
        } else {
            startActivity(intent);
        }
        finish();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String o4(int i2) {
        return SystemUtility.getTimeMinSecNoMilliFormt(i2);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String p4(int i2) {
        return SystemUtility.getTimeMinSecFormt(i2);
    }

    private void q4() {
        Bundle extras = getIntent().getExtras();
        String str = "getIntentData....bundle:" + extras;
        if (extras != null) {
            Intent intent = getIntent();
            MediaDatabase mediaDatabase = (MediaDatabase) intent.getSerializableExtra(MediaDatabase.SERIALIZABLE_EXTRA);
            this.f8720m = mediaDatabase;
            if (mediaDatabase == null || mediaDatabase.getClipArray() == null || this.f8720m.getClipArray().size() == 0) {
                finish();
                return;
            }
            intent.getFloatExtra("editorRenderTime", 0.0f);
            this.p0 = intent.getIntExtra("editorClipIndex", 0);
            String str2 = "getIntentData....clipPosition:" + this.p0;
            ArrayList<MediaClip> clipArray = this.f8720m.getClipArray();
            int size = clipArray.size() - 1;
            MediaClip mediaClip = clipArray.get(size);
            this.a1 = mediaClip;
            if (mediaClip.isAppendClip) {
                clipArray.remove(size);
            } else {
                this.a1 = null;
            }
            try {
                MediaClip mediaClip2 = clipArray.get(0);
                this.Z0 = mediaClip2;
                if (mediaClip2.isAppendClip) {
                    clipArray.remove(0);
                } else {
                    this.Z0 = null;
                }
                if (this.p0 >= clipArray.size() || this.p0 < 0) {
                    this.p0 = size;
                    this.f8720m.getTotalDuration();
                }
                int i2 = this.p0;
                if (i2 < 0 || i2 > size) {
                    this.p0 = 0;
                }
                this.a0 = clipArray.get(this.p0);
                AbstractConfigActivity.t = intent.getIntExtra("glWidthEditor", AbstractConfigActivity.t);
                AbstractConfigActivity.u = intent.getIntExtra("glHeightEditor", AbstractConfigActivity.u);
                this.X0 = intent.getStringExtra("load_type");
                intent.getStringExtra("startType");
                this.B = intent.getIntExtra("editor_clip_fun", 0);
                if (this.a0 != null) {
                    this.e0 = (MediaClip) com.xvideostudio.videoeditor.x0.j0.b(this.a0);
                    this.f0 = (MediaClip) com.xvideostudio.videoeditor.x0.j0.b(this.a0);
                    this.k0.addAll(com.xvideostudio.videoeditor.x0.j0.a(this.f8720m.getClipArray()));
                    this.Y0 = this.f8720m.isUpDurtion;
                }
                if (A4()) {
                    this.f8720m.onAddMediaClip();
                }
                this.g1 = intent.getBooleanExtra("isShareActivityto", false);
            } catch (Exception e2) {
                e2.toString();
            }
        } else {
            finish();
        }
    }

    private int r4(float f2) {
        if (f2 == 0.25f) {
            return 0;
        }
        if (f2 == 0.3f) {
            return 1;
        }
        return (int) ((f2 * 10.0f) - 2.0f);
    }

    private void s4() {
        this.z0 = (LinearLayout) findViewById(C1524R$id.ln_editor_clip_duration);
        this.J0 = (TextView) findViewById(C1524R$id.tv_duration_touch_tip);
        this.H0 = (SwitchCompat) findViewById(C1524R$id.bt_setting_duration_photos);
        Button button = (Button) findViewById(C1524R$id.bt_duration_set);
        this.D = button;
        button.setOnClickListener(new a());
        SeekBar seekBar = (SeekBar) findViewById(C1524R$id.seekbar_editor_clip_duration);
        this.K0 = seekBar;
        int i2 = 100;
        seekBar.setMax(100);
        MediaClip mediaClip = this.a0;
        if (mediaClip == null || mediaClip.mediaType != VideoEditData.IMAGE_TYPE) {
            this.K0.setProgress(19);
        } else {
            int i3 = (((int) (((float) mediaClip.duration) / 1000.0f)) * 10) - 1;
            if (i3 < 100) {
                i2 = i3;
            }
            this.K0.setProgress(i2);
        }
        this.K0.setOnSeekBarChangeListener(new b());
        int R2 = com.xvideostudio.videoeditor.tool.w.R(this.U);
        this.I0 = R2;
        if (R2 == 0) {
            this.H0.setChecked(false);
        } else {
            this.H0.setChecked(true);
        }
        this.H0.setOnCheckedChangeListener(new c());
    }

    private void t4() {
        this.m0 = new n0();
    }

    private void u4() {
        MediaClip mediaClip = this.e0;
        MediaClip mediaClip2 = this.a0;
        mediaClip.startTime = mediaClip2.startTime;
        mediaClip.endTime = mediaClip2.endTime;
        if (this.t0 || this.i1) {
            x4.a = true;
            z4();
        } else if (this.f8721n != null && this.x1) {
            this.W.setVisibility(8);
            this.f8721n.k0();
            this.f8721n.w0(1);
            this.n0.setVisibility(0);
        }
    }

    private void v4() {
        SeekVolume seekVolume = (SeekVolume) findViewById(C1524R$id.volumeSeekBar);
        this.K1 = seekVolume;
        seekVolume.n(SeekVolume.f11323n, new m0());
        MediaClip mediaClip = this.a0;
        if (mediaClip != null) {
            this.K1.setProgress(mediaClip.videoVolume);
        }
        T4();
        MediaClip mediaClip2 = this.a0;
        if (mediaClip2 != null && mediaClip2.isVideoReverse) {
            h5();
        }
    }

    private void w4() {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(C1524R$id.rlSpeedSeekbar);
        this.F1 = relativeLayout;
        if (this.B == 5) {
            relativeLayout.setVisibility(0);
        } else {
            relativeLayout.setVisibility(8);
        }
        this.G1 = (TextView) findViewById(C1524R$id.tvStartTime);
        this.H1 = (TextView) findViewById(C1524R$id.tvEndTime);
        SpeedMSeekbarNew speedMSeekbarNew = (SpeedMSeekbarNew) findViewById(C1524R$id.editorClipSeekbar);
        this.I1 = speedMSeekbarNew;
        speedMSeekbarNew.setTouchable(true);
        this.I1.setProgress(0.0f);
        this.I1.setmOnSeekBarChangeListener(new r0());
    }

    private void x4() {
        SplitSeekBar splitSeekBar = (SplitSeekBar) findViewById(C1524R$id.clip_video_split_seekbar);
        this.U0 = splitSeekBar;
        splitSeekBar.setSeekBarListener(new b0());
    }

    private void y4() {
        this.r0 = findViewById(C1524R$id.set_video_duration_lay);
        this.L0 = (RelativeLayout) findViewById(C1524R$id.ln_editor_clip_trim);
        this.M0 = (TextView) findViewById(C1524R$id.tv_min_trim_time);
        this.N0 = (TextView) findViewById(C1524R$id.tv_max_trim_time);
        TrimSeekBar trimSeekBar = (TrimSeekBar) findViewById(C1524R$id.clip_video_seekbar);
        this.T0 = trimSeekBar;
        trimSeekBar.setSeekBarListener(new a0());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void z4() {
        MediaDatabase mediaDatabase = this.u1;
        if (mediaDatabase == null) {
            MediaDatabase mediaDatabase2 = new MediaDatabase(MediaDatabase.outputFilePath, MediaDatabase.tempDir);
            this.u1 = mediaDatabase2;
            mediaDatabase2.addClip(this.e0);
            this.u1.squareModeEnabled = this.f8720m.squareModeEnabled;
        } else {
            mediaDatabase.addClip(this.e0);
        }
        this.u1.isVideosMute = this.f8720m.isVideosMute;
        if (!this.S || this.i1) {
            this.S = true;
            g4();
            this.t1 = true;
        } else {
            h.a.x.e eVar = this.f8721n;
            if (eVar != null) {
                eVar.L0(0.0f);
                this.f8721n.F0(0, 1);
            }
            Message message = new Message();
            message.what = 8;
            this.l0.sendMessage(message);
        }
        this.t0 = false;
        this.i1 = false;
    }

    /* access modifiers changed from: protected */
    public void V4() {
        Dialog Q2 = com.xvideostudio.videoeditor.x0.e0.Q(this.U, null, null);
        EditText editText = (EditText) Q2.findViewById(C1524R$id.dialog_edit);
        this.s0 = 100;
        ((Button) Q2.findViewById(C1524R$id.bt_dialog_ok)).setOnClickListener(new d(editText, Q2));
        ((ImageView) Q2.findViewById(C1524R$id.iv_minus)).setOnClickListener(new e(this, editText));
        ((ImageView) Q2.findViewById(C1524R$id.iv_plus)).setOnClickListener(new f(this, editText));
    }

    @Override // com.xvideostudio.videoeditor.view.StoryBoardViewOne.b
    public void c() {
        if (this.f8720m != null) {
            this.p0 = this.q0.getSortClipAdapter().p();
            MediaClip o2 = this.q0.getSortClipAdapter().o();
            this.a0 = o2;
            MediaClip mediaClip = this.e0;
            if (mediaClip == null || o2 == null || o2.index == mediaClip.index) {
                this.f8720m.updateIndex();
            } else {
                this.f8720m.updateIndex();
                h4(this.p0, true, false);
            }
            if (this.f8720m.getFxThemeU3DEntity() != null && this.f8720m.getFxThemeU3DEntity().isTransRand == 0) {
                MediaDatabase mediaDatabase = this.f8720m;
                MediaClip clip = mediaDatabase.getClip(mediaDatabase.getClipArray().size() - 1);
                if (clip != null && clip.addMadiaClip == 1) {
                    this.f8720m.getClipArray().remove(clip);
                }
                String str = this.X0;
                boolean z2 = str != null && str.equals(MessengerShareContentUtility.MEDIA_IMAGE);
                MediaDatabase mediaDatabase2 = this.f8720m;
                mediaDatabase2.initThemeU3D(mediaDatabase2.getFxThemeU3DEntity(), false, z2, false);
                ArrayList<MediaClip> clipArray = this.f8720m.getClipArray();
                MediaClip mediaClip2 = clipArray.get(clipArray.size() - 1);
                this.a1 = mediaClip2;
                if (mediaClip2.isAppendClip) {
                    clipArray.remove(clipArray.size() - 1);
                } else {
                    this.a1 = null;
                }
                MediaClip mediaClip3 = clipArray.get(0);
                this.Z0 = mediaClip3;
                if (mediaClip3.isAppendClip) {
                    clipArray.remove(0);
                } else {
                    this.Z0 = null;
                }
                MediaDatabase mediaDatabase3 = this.f8720m;
                MediaClip clip2 = mediaDatabase3.getClip(mediaDatabase3.getClipArray().size() - 1);
                if (!(clip2 == null || clip2.addMadiaClip == 1)) {
                    this.f8720m.onAddMediaClip();
                }
            }
            d1();
        }
    }

    @Override // com.xvideostudio.videoeditor.adapter.o2.e
    public void h(int i2) {
        MediaDatabase mediaDatabase = this.f8720m;
        if (mediaDatabase != null && mediaDatabase.getClip(i2) != null) {
            if (this.f8720m.getClip(i2).addMadiaClip == 1) {
                m1.a(this.U, "EDITOR_CLIP_CLICK_ADD_CLIP");
                h.a.x.e eVar = this.f8721n;
                if (eVar != null) {
                    if (eVar.h0()) {
                        this.f8721n.j0();
                        this.T0.setTriming(true);
                        this.W.setVisibility(0);
                    }
                    c4();
                    return;
                }
                return;
            }
            MediaClip mediaClip = this.a0;
            if (mediaClip != null && this.B == 6) {
                MediaClip mediaClip2 = this.f0;
                mediaClip.startTime = mediaClip2.startTime;
                mediaClip.endTime = mediaClip2.endTime;
            }
            h4(i2, false, false);
            MediaClip mediaClip3 = this.a0;
            if (mediaClip3 != null && mediaClip3.isVideoReverse) {
                h5();
            }
            this.l0.postDelayed(new e0(), 10);
            Q4();
        }
    }

    @Override // com.xvideostudio.videoeditor.view.SetTextSizeView.a
    public void j(int i2) {
        S4(i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0244  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0290  */
    public Bitmap j4(MediaClip mediaClip, boolean z2) {
        MediaClip mediaClip2;
        Bitmap bitmap;
        float f2;
        int i2;
        int i3;
        int i4;
        int i5;
        float f3;
        int i6;
        int i7;
        int i8;
        int i9;
        Bitmap bitmap2;
        int i10;
        int i11;
        MediaDatabase mediaDatabase;
        Bitmap bitmap3 = null;
        if (mediaClip == null) {
            MediaClip mediaClip3 = this.a0;
            if (mediaClip3 == null && (mediaDatabase = this.f8720m) != null) {
                mediaClip3 = mediaDatabase.getClip(this.p0);
            }
            if (mediaClip3 == null) {
                return null;
            }
            mediaClip2 = mediaClip3;
        } else {
            mediaClip2 = mediaClip;
        }
        int i12 = 0;
        if (mediaClip2.mediaType == VideoEditData.IMAGE_TYPE) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            options.inDither = false;
            options.inPreferredConfig = null;
            if (mediaClip2.video_rotate % 180 == 0) {
                this.p1 = mediaClip2.video_w_real;
                this.q1 = mediaClip2.video_h_real;
            } else {
                this.p1 = mediaClip2.video_h_real;
                this.q1 = mediaClip2.video_w_real;
            }
            int i13 = this.i0;
            int i14 = this.p1;
            if (i13 < i14 || this.j0 < this.q1) {
                options.inSampleSize = hl.productor.fxlib.y.r(i14, this.q1, 3)[0];
                Bitmap decodeFile = g.c.i.a.decodeFile(mediaClip2.path, options);
                if (decodeFile == null) {
                    return null;
                }
                if (mediaClip2.video_rotate != 0) {
                    String str = "drawMomentBitmap clip.video_rotate : " + mediaClip2.video_rotate;
                    bitmap2 = com.xvideostudio.videoeditor.g0.a.f((float) mediaClip2.video_rotate, decodeFile, true);
                    if (bitmap2 == null) {
                        return null;
                    }
                } else {
                    bitmap2 = decodeFile;
                }
                String str2 = "op.outWidth:" + options.outWidth + " op.outHeight:" + options.outHeight;
                float min = Math.min(((float) this.j0) / ((float) this.q1), ((float) this.i0) / ((float) this.p1));
                String str3 = "比例大小 wRatio w > h:" + min;
                int i15 = (int) (((float) this.p1) * min);
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                if (bitmap2.getWidth() == i15 || width <= 0 || height <= 0 || (i10 = this.j0) <= 0 || (i11 = this.i0) <= 0) {
                    return bitmap2;
                }
                float min2 = Math.min((((float) i10) * 1.0f) / ((float) height), (((float) i11) * 1.0f) / ((float) width));
                Matrix matrix = new Matrix();
                matrix.postScale(min2, min2);
                if (bitmap2.isRecycled()) {
                    return null;
                }
                bitmap3 = Bitmap.createBitmap(bitmap2, 0, 0, width, height, matrix, true);
                bitmap = bitmap2;
            } else {
                bitmap = g.c.i.a.decodeFile(mediaClip2.path, options);
                if (bitmap == null) {
                    return null;
                }
                if (mediaClip2.video_rotate == 0) {
                    return bitmap;
                }
                String str4 = "drawMomentBitmap clip.video_rotate : " + mediaClip2.video_rotate;
                bitmap3 = com.xvideostudio.videoeditor.g0.a.f((float) mediaClip2.video_rotate, bitmap, true);
            }
        } else {
            int i16 = mediaClip2.picWidth;
            if (i16 == 0 && mediaClip2.picHeight == 0) {
                Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(mediaClip2.path, 2);
                if (createVideoThumbnail == null) {
                    if (mediaClip2.video_rotate % 180 == 0) {
                        this.p1 = mediaClip2.video_w_real;
                        this.q1 = mediaClip2.video_h_real;
                    } else {
                        this.p1 = mediaClip2.video_h_real;
                        this.q1 = mediaClip2.video_w_real;
                    }
                    MediaClip mediaClip4 = this.e0;
                    if (mediaClip4 != null && mediaClip2.index == mediaClip4.index) {
                        i12 = (int) ((this.k1 * 1000.0f) + ((float) mediaClip4.startTime));
                    }
                    return k4(mediaClip2, i12);
                }
                if (z2 && (i8 = this.p1) > 0 && (i9 = this.q1) > 0) {
                    int i17 = i8 >= i9 ? 1 : 0;
                    if (createVideoThumbnail.getWidth() >= createVideoThumbnail.getHeight()) {
                        i12 = 1;
                    }
                    if (i17 != i12) {
                        if (this.p1 >= this.q1) {
                            this.p1 = Math.max(createVideoThumbnail.getWidth(), createVideoThumbnail.getHeight());
                            this.q1 = Math.min(createVideoThumbnail.getWidth(), createVideoThumbnail.getHeight());
                        } else {
                            this.p1 = Math.min(createVideoThumbnail.getWidth(), createVideoThumbnail.getHeight());
                            this.q1 = Math.max(createVideoThumbnail.getWidth(), createVideoThumbnail.getHeight());
                        }
                        mediaClip2.isFFRotation = true;
                        MediaClip mediaClip5 = this.e0;
                        if (mediaClip5 != null) {
                            mediaClip5.isFFRotation = true;
                        }
                        if (Math.min(this.p1, this.q1) == Math.min(mediaClip2.video_w_real, mediaClip2.video_h_real) && Math.max(this.p1, this.q1) == Math.max(mediaClip2.video_w_real, mediaClip2.video_h_real)) {
                            mediaClip2.picWidth = this.p1;
                            mediaClip2.picHeight = this.q1;
                        }
                        i4 = this.i0;
                        i5 = this.p1;
                        if (i4 >= i5 || this.j0 < this.q1) {
                            f3 = Math.min(((float) this.j0) / ((float) this.q1), ((float) i4) / ((float) i5));
                            String str5 = "比例大小 wRatio w > h:" + f3;
                        } else {
                            f3 = 1.0f;
                        }
                        if (f3 != 1.0f) {
                            return (createVideoThumbnail == null || !mediaClip2.isFFRotation || (i6 = mediaClip2.video_rotate) == 0) ? createVideoThumbnail : com.xvideostudio.videoeditor.g0.a.f((float) i6, createVideoThumbnail, true);
                        }
                        Matrix matrix2 = new Matrix();
                        matrix2.postScale(f3, f3);
                        try {
                            if (!createVideoThumbnail.isRecycled() && createVideoThumbnail.getWidth() != 0) {
                                if (createVideoThumbnail.getHeight() != 0) {
                                    Bitmap createBitmap = Bitmap.createBitmap(createVideoThumbnail, 0, 0, createVideoThumbnail.getWidth(), createVideoThumbnail.getHeight(), matrix2, true);
                                    if (!(createBitmap == null || !mediaClip2.isFFRotation || (i7 = mediaClip2.video_rotate) == 0)) {
                                        createBitmap = com.xvideostudio.videoeditor.g0.a.f((float) i7, createBitmap, true);
                                    }
                                    bitmap3 = createBitmap;
                                    bitmap = createVideoThumbnail;
                                }
                            }
                            return null;
                        } catch (IllegalArgumentException e2) {
                            e2.printStackTrace();
                            if (!g.c.a.e()) {
                                return createVideoThumbnail;
                            }
                            throw e2;
                        }
                    }
                }
                this.p1 = createVideoThumbnail.getWidth();
                this.q1 = createVideoThumbnail.getHeight();
                mediaClip2.picWidth = this.p1;
                mediaClip2.picHeight = this.q1;
                i4 = this.i0;
                i5 = this.p1;
                if (i4 >= i5) {
                }
                f3 = Math.min(((float) this.j0) / ((float) this.q1), ((float) i4) / ((float) i5));
                String str52 = "比例大小 wRatio w > h:" + f3;
                if (f3 != 1.0f) {
                }
            } else {
                this.p1 = i16;
                this.q1 = mediaClip2.picHeight;
                MediaClip mediaClip6 = this.e0;
                if (mediaClip6 != null && mediaClip2.index == mediaClip6.index) {
                    i12 = (int) ((this.k1 * 1000.0f) + ((float) mediaClip6.startTime));
                }
                Bitmap k4 = k4(mediaClip2, i12);
                if (k4 != null) {
                    return k4;
                }
                Bitmap createVideoThumbnail2 = ThumbnailUtils.createVideoThumbnail(mediaClip2.path, 2);
                if (createVideoThumbnail2 == null || createVideoThumbnail2.isRecycled() || createVideoThumbnail2.getWidth() == 0 || createVideoThumbnail2.getHeight() == 0) {
                    return null;
                }
                int i18 = this.i0;
                int i19 = this.p1;
                if (i18 < i19 || this.j0 < this.q1) {
                    f2 = Math.min(((float) this.j0) / ((float) this.q1), ((float) i18) / ((float) i19));
                    String str6 = "比例大小 wRatio w > h:" + f2;
                } else {
                    f2 = 1.0f;
                }
                if (f2 == 1.0f) {
                    return (createVideoThumbnail2 == null || !mediaClip2.isFFRotation || (i2 = mediaClip2.video_rotate) == 0) ? createVideoThumbnail2 : com.xvideostudio.videoeditor.g0.a.f((float) i2, createVideoThumbnail2, true);
                }
                Matrix matrix3 = new Matrix();
                matrix3.postScale(f2, f2);
                try {
                    bitmap3 = Bitmap.createBitmap(createVideoThumbnail2, 0, 0, createVideoThumbnail2.getWidth(), createVideoThumbnail2.getHeight(), matrix3, true);
                } catch (IllegalArgumentException e3) {
                    e3.printStackTrace();
                    if (g.c.a.e()) {
                        throw e3;
                    }
                }
                if (!(bitmap3 == null || !mediaClip2.isFFRotation || (i3 = mediaClip2.video_rotate) == 0)) {
                    bitmap3 = com.xvideostudio.videoeditor.g0.a.f((float) i3, bitmap3, true);
                }
                bitmap = createVideoThumbnail2;
            }
        }
        if (bitmap != null && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return bitmap3;
    }

    @Override // com.xvideostudio.videoeditor.view.StoryBoardViewOne.a
    public void m(MediaClip mediaClip) {
    }

    @Override // com.xvideostudio.videoeditor.view.SetTextSizeView.a
    public void n(int i2) {
        S4(i2);
        if (this.f8720m != null && this.a0 != null) {
            h.a.x.e eVar = this.f8721n;
            if (eVar != null && eVar.h0()) {
                this.f8721n.j0();
            }
            float f2 = this.A1;
            MediaClip mediaClip = this.a0;
            if (f2 != mediaClip.videoPlaySpeed) {
                mediaClip.videoPlaySpeed = f2;
                this.e0 = mediaClip;
                this.f8720m.isEditorClip = true;
                z4();
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1 && intent != null) {
            MediaDatabase mediaDatabase = (MediaDatabase) intent.getSerializableExtra(MediaDatabase.SERIALIZABLE_EXTRA);
            this.f8720m = mediaDatabase;
            mediaDatabase.onAddMediaClip();
            if (this.q0 != null) {
                m1.a(this.U, "EDITOR_CLIP_ADD_CLIP_SUCCESS_ALL");
                this.q0.setData(this.f8720m.getClipArray());
            }
            if (w4.f8878c) {
                w4.f8878c = false;
            }
            this.d1 = Boolean.TRUE;
            this.i1 = true;
            if (intent.getBooleanExtra("is_from_paint", false)) {
                m1.a(this.U, "EDITOR_CLIP_ADD_BLANK_OK");
            }
        }
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        MediaClip mediaClip = this.a0;
        if (mediaClip != null) {
            if (mediaClip.isZoomClip || mediaClip.lastRotation != 0) {
                this.d1 = Boolean.TRUE;
            }
            if (this.d1.booleanValue()) {
                f4(this.a0);
                X4();
                return;
            }
            n4(false);
        } else if (this.d1.booleanValue()) {
            X4();
        } else {
            n4(false);
        }
    }

    public void onClick(View view) {
        MediaClip mediaClip;
        MediaClip mediaClip2;
        ZoomImageView zoomImageView;
        Boolean bool = Boolean.TRUE;
        switch (view.getId()) {
            case C1524R$id.bt_video_sound_mute:
                if (!(this.a0 == null || this.f8721n == null)) {
                    this.d1 = bool;
                    this.X.setEnabled(false);
                    this.X.postDelayed(new u(), 1000);
                    if (this.f8721n.h0()) {
                        this.f8721n.j0();
                        this.W.setVisibility(0);
                        this.T0.setTriming(true);
                    }
                    ArrayList<SoundEntity> soundList = this.f8720m.getSoundList();
                    if (soundList != null && soundList.size() > 0) {
                        int i2 = soundList.get(0).volume;
                        if (i2 != 0) {
                            this.Y = i2;
                        }
                        for (int i3 = 0; i3 < soundList.size(); i3++) {
                            SoundEntity soundEntity = soundList.get(i3);
                            if (!this.X.isSelected()) {
                                soundEntity.volume = 0;
                            } else {
                                soundEntity.volume = this.Y;
                            }
                        }
                    }
                    ArrayList<SoundEntity> voiceList = this.f8720m.getVoiceList();
                    if (voiceList != null && voiceList.size() > 0) {
                        int i4 = soundList.get(0).volume;
                        if (i4 != 0) {
                            this.Y = i4;
                        }
                        for (int i5 = 0; i5 < voiceList.size(); i5++) {
                            SoundEntity soundEntity2 = voiceList.get(i5);
                            if (!this.X.isSelected()) {
                                soundEntity2.volume = 0;
                            } else {
                                soundEntity2.volume = this.Y;
                            }
                        }
                    }
                    Button button = this.X;
                    button.setSelected(!button.isSelected());
                    new v().execute(new Void[0]);
                    return;
                }
                return;
            case C1524R$id.btn_split:
                com.xvideostudio.videoeditor.x0.p2.b.a(0, "SPLIT_CLICK_SPLITVIDEO", null);
                MediaClip mediaClip3 = (MediaClip) com.xvideostudio.videoeditor.x0.j0.b(this.f0);
                this.h1 = mediaClip3;
                int i6 = this.a0.endTime + 1;
                mediaClip3.startTime = i6;
                mediaClip3.startTime = Tools.N(mediaClip3.path, i6, Tools.q.mode_closer);
                MediaClip mediaClip4 = this.h1;
                if (mediaClip4.endTime == 0) {
                    mediaClip4.endTime = mediaClip4.duration;
                }
                MediaClip mediaClip5 = this.a0;
                if (mediaClip5.endTime - mediaClip5.startTime < 1000 || mediaClip4.endTime - mediaClip4.startTime < 1000) {
                    com.xvideostudio.videoeditor.tool.m.n(2131820728);
                    com.xvideostudio.videoeditor.x0.p2.b.a(0, "SPLIT_CLICK_SPLITVIDEO_FAIL", null);
                    return;
                }
                com.xvideostudio.videoeditor.x0.p2.b.a(0, "SPLIT_CLICK_SPLITVIDEO_SUC", null);
                this.t0 = true;
                u4();
                R4(this.a0);
                P4(0);
                m1.a(this.U, "CLICK_EDITORCLIP_SPLIT_OK");
                if (this.h1 != null) {
                    this.d1 = bool;
                    this.f8720m.getClipArray().add(this.q0.getSortClipAdapter().p() + 1, this.h1);
                    this.q0.g(this.f8720m.getClipArray(), this.q0.getSortClipAdapter().p() + 1);
                    this.q0.getSortClipAdapter().v(1);
                    this.f8720m.updateIndex();
                    this.a0 = this.q0.getSortClipAdapter().o();
                    h4(this.q0.getSortClipAdapter().p(), false, false);
                    this.p0 = this.q0.getSortClipAdapter().p();
                }
                this.P0.setVisibility(8);
                this.Q0.setVisibility(8);
                this.D1.setVisibility(0);
                this.m1 = (ArrayList) com.xvideostudio.videoeditor.x0.j0.b(this.f8720m.getClipArray());
                return;
            case C1524R$id.btn_video_play:
                if (!(this.f8721n == null || (mediaClip = this.a0) == null || this.e0 == null)) {
                    if (mediaClip.mediaType == VideoEditData.VIDEO_TYPE) {
                        this.T0.setProgress(0.0f);
                        if (this.f1 != 4) {
                            this.O0.setText(p4(this.a0.startTime));
                            if (this.k1 != 0.0f) {
                                this.k1 = 0.001f;
                            }
                        }
                        this.O0.setVisibility(0);
                    }
                    if (this.B == 3) {
                        this.g0.setIsZommTouch(false);
                        MediaClip mediaClip6 = this.a0;
                        if (mediaClip6.isZoomClip || mediaClip6.lastRotation != 0) {
                            this.d1 = bool;
                            this.e0 = this.g0.h(this.e0, false);
                        }
                        x4.a = true;
                        z4();
                        return;
                    }
                    u4();
                    this.T0.setTriming(false);
                    return;
                }
                return;
            case C1524R$id.conf_rl_fx_openglview:
                h.a.x.e eVar = this.f8721n;
                if (eVar != null && eVar.h0()) {
                    this.f8721n.j0();
                    this.W.setVisibility(0);
                    this.T0.setTriming(true);
                    if (this.B == 6) {
                        this.a0.endTime = (int) (this.f8721n.H() * 1000.0f);
                        this.P0.setVisibility(0);
                        this.Q0.setVisibility(0);
                        this.D1.setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            case C1524R$id.edit_clip_zoom:
                if (!(this.a0 == null || this.f8721n == null)) {
                    com.xvideostudio.videoeditor.x0.p2.b.a(0, "ZOOM_CLICK", null);
                    if (this.B != 3) {
                        com.xvideostudio.videoeditor.tool.m.t(this.U.getResources().getString(2131821540), -1, 0);
                        m1.a(this.U, "CLICK_EDITORCLIP_ZOOM");
                        h.a.x.e eVar2 = this.f8721n;
                        if (eVar2 != null && eVar2.h0()) {
                            this.f8721n.j0();
                        }
                        MediaClip mediaClip7 = this.a0;
                        if (mediaClip7.mediaType == VideoEditData.VIDEO_TYPE && (mediaClip7.isZoomClip || mediaClip7.lastRotation != 0)) {
                            this.d1 = bool;
                            this.a0 = this.g0.h(mediaClip7, false);
                        }
                        if (!(this.f8721n == null || (mediaClip2 = this.e0) == null || mediaClip2.mediaType != VideoEditData.VIDEO_TYPE || (zoomImageView = this.g0) == null || zoomImageView.getMediaClip() == null || this.g0.getMediaClip().index != this.e0.index)) {
                            float H2 = this.f8721n.H();
                            this.k1 = H2;
                            h.a.a d2 = h.a.a.d(k4(this.a0, (int) ((H2 * 1000.0f) + ((float) this.e0.startTime))));
                            if (d2 != null) {
                                this.h0.c();
                                this.h0.b(d2, true);
                                this.g0.setMediaClip(this.a0);
                                this.g0.setImageBitmap(this.h0);
                            }
                        }
                        this.n0.setVisibility(8);
                        this.W.setVisibility(0);
                        this.g0.setIsZommTouch(true);
                        return;
                    }
                    this.g0.setIsZommTouch(false);
                    if (this.e0 == null) {
                        MediaClip mediaClip8 = this.g0.getMediaClip();
                        this.e0 = mediaClip8;
                        if (mediaClip8 == null) {
                            this.e0 = this.a0;
                        }
                    }
                    MediaClip mediaClip9 = this.a0;
                    if (mediaClip9.isZoomClip || mediaClip9.lastRotation != 0) {
                        MediaClip h2 = this.g0.h(this.e0, false);
                        this.e0 = h2;
                        MediaClip mediaClip10 = this.a0;
                        h2.startTime = mediaClip10.startTime;
                        h2.endTime = mediaClip10.endTime;
                        z4();
                        this.l1 = true;
                        this.l0.postDelayed(new t(), 350);
                        return;
                    }
                    this.n0.setVisibility(0);
                    this.W.setVisibility(0);
                    return;
                }
                return;
            case C1524R$id.rl_cover_view:
            case C1524R$id.toolbar_cover_view:
                this.P0.setVisibility(8);
                this.Q0.setVisibility(8);
                this.D1.setVisibility(0);
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.xvideostudio.videoeditor.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, com.xvideostudio.videoeditor.activity.basic.AbstractConfigActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1527R$layout.activity_editor_clip);
        this.l0 = new Handler();
        this.U = this;
        q4();
        P();
        i4(true);
        t4();
        v4();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C1528R$menu.menu_config_editor_activity, menu);
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.xvideostudio.videoeditor.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, com.xvideostudio.videoeditor.activity.basic.AbstractConfigActivity
    public void onDestroy() {
        TrimSeekBar trimSeekBar = this.T0;
        if (trimSeekBar != null) {
            trimSeekBar.l();
        }
        h.a.x.e eVar = this.f8721n;
        if (!(eVar == null || this.f8720m == null)) {
            eVar.L0(0.0f);
        }
        super.onDestroy();
        this.h0.c();
        this.u1 = null;
        this.e0 = null;
        Dialog dialog = this.E1;
        if (dialog != null && dialog.isShowing()) {
            this.E1.dismiss();
            this.E1 = null;
        }
        System.gc();
    }

    @Override // com.xvideostudio.videoeditor.view.StoryBoardViewOne.b
    public void onMove(int i2, int i3) {
        this.d1 = Boolean.TRUE;
        z0.j(this.m1, i2, i3);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int i2;
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            onBackPressed();
            return true;
        } else if (itemId != 2131296340) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            M4();
            d1();
            int i3 = this.B;
            if (i3 == 6) {
                com.xvideostudio.videoeditor.x0.p2.b.a(0, "SPLIT_CONFIRM", null);
            } else if (i3 == 4) {
                com.xvideostudio.videoeditor.x0.p2.b.a(0, "REVERSE_CONFIRM", null);
            } else if (i3 == 3) {
                com.xvideostudio.videoeditor.x0.p2.b.a(0, "ZOOM_CONFIRM", null);
            } else if (i3 == 5) {
                com.xvideostudio.videoeditor.x0.p2.b.a(0, "SPEED_CONFIRM", null);
            } else if (i3 == 1) {
                com.xvideostudio.videoeditor.x0.p2.b.a(0, "TRIM_CONFIRM", null);
            }
            if (this.B == 6) {
                if (this.m1.size() > 0) {
                    ArrayList<MediaClip> arrayList = this.m1;
                    arrayList.remove(arrayList.get(arrayList.size() - 1));
                }
                this.f8720m.setClipArray(this.m1);
                this.f8720m.addCameraClipAudio();
                Intent intent = new Intent();
                intent.putExtra(MediaDatabase.SERIALIZABLE_EXTRA, this.f8720m);
                if (!this.g1) {
                    setResult(10, intent);
                } else {
                    startActivity(intent);
                }
                n4(true);
                return true;
            }
            MediaDatabase mediaDatabase = this.f8720m;
            if (!(mediaDatabase == null || mediaDatabase.getClipArray() == null)) {
                ArrayList<MediaClip> clipArray = this.f8720m.getClipArray();
                MediaClip mediaClip = this.a0;
                if (mediaClip != null) {
                    if (mediaClip.isZoomClip || mediaClip.lastRotation != 0) {
                        this.a0 = this.g0.h(mediaClip, false);
                    }
                    int i4 = this.p0;
                    if (i4 >= 0 && i4 < clipArray.size()) {
                        clipArray.set(this.p0, this.a0);
                    }
                }
                Iterator<MediaClip> it = clipArray.iterator();
                while (it.hasNext()) {
                    MediaClip next = it.next();
                    if (next != null && next.mediaType == VideoEditData.VIDEO_TYPE && (i2 = next.startTime) > 0 && next.ffmpegStartTime != i2) {
                        try {
                            String str = "Before getRealTrimSpot, trim_start =" + next.startTime + "ms";
                            String str2 = "After getRealTrimSpot, trim_start =" + next.startTime + "ms";
                            int i5 = next.startTime;
                            int i6 = next.endTime;
                            if (i5 >= i6) {
                                next.startTime = i6 - 1000;
                            }
                            if (next.startTime < 0) {
                                next.startTime = 0;
                            }
                            next.ffmpegStartTime = next.startTime;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
            n4(true);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.xvideostudio.videoeditor.activity.BaseActivity, androidx.fragment.app.FragmentActivity
    public void onPause() {
        super.onPause();
        this.u0 = false;
        m1.d(this);
        h.a.x.e eVar = this.f8721n;
        if (eVar != null && eVar.h0()) {
            this.f8721n.j0();
            MediaClip mediaClip = this.e0;
            if (mediaClip != null) {
                int i2 = mediaClip.mediaType;
                int i3 = VideoEditData.VIDEO_TYPE;
            }
            this.W.setVisibility(0);
            this.T0.setTriming(true);
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    /* access modifiers changed from: protected */
    @Override // com.xvideostudio.videoeditor.activity.BaseActivity, androidx.fragment.app.FragmentActivity
    public void onResume() {
        super.onResume();
        m1.e(this);
        if (this.i1) {
            z4();
        }
        this.m1 = (ArrayList) com.xvideostudio.videoeditor.x0.j0.b(this.f8720m.getClipArray());
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onStart() {
        super.onStart();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, com.xvideostudio.videoeditor.activity.basic.AbstractConfigActivity
    public void onStop() {
        h.a.x.e eVar = this.f8721n;
        if (eVar != null && eVar.h0()) {
            this.f8721n.j0();
            MediaClip mediaClip = this.e0;
            if (mediaClip != null) {
                int i2 = mediaClip.mediaType;
                int i3 = VideoEditData.VIDEO_TYPE;
            }
            this.W.setVisibility(0);
            this.T0.setTriming(true);
        }
        super.onStop();
    }

    @Override // com.xvideostudio.videoeditor.activity.basic.AbstractConfigActivity
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        this.u0 = true;
        this.l0.post(new g());
        if (!this.C) {
            this.C = true;
            this.l0.postDelayed(new h(), 200);
            com.xvideostudio.videoeditor.tool.a0.a(1).execute(new i());
            if (this.e0 != null) {
                z4();
            } else {
                this.l0.postDelayed(new j(), 10);
            }
            this.v0 = hl.productor.fxlib.h.P;
            int i2 = this.B;
            if (i2 == 1) {
                this.e1.setTitle(2131822059);
                MediaClip mediaClip = this.a0;
                if (mediaClip == null) {
                    return;
                }
                if (mediaClip.mediaType == VideoEditData.IMAGE_TYPE) {
                    P4(2);
                } else {
                    this.l0.postDelayed(new m(), 10);
                }
            } else if (i2 == 6) {
                this.e1.setTitle(2131820933);
                this.l0.postDelayed(new n(), 10);
            } else if (i2 == 2) {
                this.e1.setTitle(2131820988);
                Z4();
            } else if (i2 == 3) {
                this.e1.setTitle(2131820936);
                c5();
            } else if (i2 == 4) {
                this.e1.setTitle(2131821319);
                Y4();
            } else if (i2 == 5) {
                this.e1.setTitle(C1532R$string.editor_mode_easy_speed);
                a5();
            }
        }
    }
}