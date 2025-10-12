package com.lomfsqxinjb.KRgTbxlWh;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.PowerManager;
import android.os.Process;
import android.os.RemoteException;
import android.os.StatFs;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsoluteLayout;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.adjust.sdk.Constants;
import com.facebook.internal.security.CertificateUtil;
import com.facebook.share.internal.ShareConstants;
import com.helpergames.NHelper;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.DataUtil;
import com.thucungdoithu9gp.vn.R;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Properties;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL11;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class PCJDkVISZlhELOr extends Activity implements MediaPlayer.OnCompletionListener {
    private static String P0 = "";
    private static SurfaceHolder Q0;
    private static SharedPreferences R0;
    private static long S0;
    private static long T0;
    public static AssetManager U0;
    public static PCJDkVISZlhELOr V0;
    public static String W0;
    public static String X0;
    public static String Y0;
    public static String Z0;
    public static String a1;
    public static int b1;
    public static int c1;
    public static com.lomfsqxinjb.KRgTbxlWh.c e1;
    protected static String r1;
    public String D0;
    private HashMap<String, String> S;

    /* renamed from: q0, reason: collision with root package name */
    private ProgressDialog f2983q0;
    public static ArrayList<com.lomfsqxinjb.KRgTbxlWh.c> d1 = new ArrayList<>();
    public static com.lomfsqxinjb.KRgTbxlWh.a f1 = null;
    public static String g1 = null;
    public static j0.j h1 = null;
    public static String i1 = "56ef91f867e58e33d80011cd";
    public static String j1 = "536D728BE8371E063A1D9C94D86B3BF2";
    public static boolean k1 = true;
    public static float l1 = 1.0f;
    public static String m1 = "";
    public static o1 n1 = null;
    public static String o1 = "";
    protected static int p1 = 0;
    protected static String q1 = "";
    public static boolean s1 = false;

    /* renamed from: e, reason: collision with root package name */
    protected Handler f2958e = null;

    /* renamed from: f, reason: collision with root package name */
    private boolean f2960f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f2962g = false;

    /* renamed from: h, reason: collision with root package name */
    private Runnable f2964h = null;

    /* renamed from: i, reason: collision with root package name */
    public boolean f2966i = true;

    /* renamed from: j, reason: collision with root package name */
    private boolean f2968j = false;

    /* renamed from: k, reason: collision with root package name */
    public boolean f2970k = false;

    /* renamed from: l, reason: collision with root package name */
    private EGL10 f2972l = null;

    /* renamed from: m, reason: collision with root package name */
    private GL11 f2974m = null;

    /* renamed from: n, reason: collision with root package name */
    private EGLSurface f2976n = null;

    /* renamed from: o, reason: collision with root package name */
    private EGLDisplay f2978o = null;

    /* renamed from: p, reason: collision with root package name */
    private EGLContext f2980p = null;

    /* renamed from: q, reason: collision with root package name */
    private EGLConfig f2982q = null;

    /* renamed from: r, reason: collision with root package name */
    private SoundPool f2984r = null;

    /* renamed from: s, reason: collision with root package name */
    private Thread f2986s = null;

    /* renamed from: t, reason: collision with root package name */
    private MediaPlayer f2988t = null;

    /* renamed from: u, reason: collision with root package name */
    private MediaPlayer f2990u = null;

    /* renamed from: v, reason: collision with root package name */
    private boolean f2992v = false;

    /* renamed from: w, reason: collision with root package name */
    private MediaPlayer f2994w = null;

    /* renamed from: x, reason: collision with root package name */
    private SurfaceView f2995x = null;

    /* renamed from: y, reason: collision with root package name */
    private boolean f2996y = false;

    /* renamed from: z, reason: collision with root package name */
    private boolean f2997z = false;
    private Properties A = null;
    private boolean B = false;
    private boolean C = false;
    private boolean D = false;
    private boolean E = true;
    private final boolean F = false;
    private boolean G = false;
    private SurfaceView H = null;
    private float I = 1.0f;
    private boolean J = true;
    public boolean K = true;
    private boolean L = false;
    private boolean M = true;
    private boolean N = false;
    private int O = 0;
    private int P = 0;
    private int Q = 0;
    private int R = 24;
    private LinearLayout T = null;
    private EditText U = null;
    private boolean V = false;
    private int W = 0;
    private ImageView X = null;
    private ImageView Y = null;
    private SurfaceView Z = null;

    /* renamed from: a0, reason: collision with root package name */
    private TextView f2954a0 = null;

    /* renamed from: b0, reason: collision with root package name */
    private Runnable f2955b0 = null;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f2956c0 = false;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f2957d0 = false;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f2959e0 = false;

    /* renamed from: f0, reason: collision with root package name */
    private PowerManager.WakeLock f2961f0 = null;

    /* renamed from: g0, reason: collision with root package name */
    public String f2963g0 = "";

    /* renamed from: h0, reason: collision with root package name */
    public String f2965h0 = "";

    /* renamed from: i0, reason: collision with root package name */
    private String f2967i0 = "";

    /* renamed from: j0, reason: collision with root package name */
    private String f2969j0 = "";

    /* renamed from: k0, reason: collision with root package name */
    private String f2971k0 = "";

    /* renamed from: l0, reason: collision with root package name */
    private int f2973l0 = 0;

    /* renamed from: m0, reason: collision with root package name */
    private String f2975m0 = "";

    /* renamed from: n0, reason: collision with root package name */
    private String f2977n0 = "";

    /* renamed from: o0, reason: collision with root package name */
    private String f2979o0 = "";

    /* renamed from: p0, reason: collision with root package name */
    private Timer f2981p0 = new Timer();

    /* renamed from: r0, reason: collision with root package name */
    RelativeLayout f2985r0 = null;

    /* renamed from: s0, reason: collision with root package name */
    TextView f2987s0 = null;

    /* renamed from: t0, reason: collision with root package name */
    public RelativeLayout f2989t0 = null;

    /* renamed from: u0, reason: collision with root package name */
    public ImageView f2991u0 = null;

    /* renamed from: v0, reason: collision with root package name */
    public RelativeLayout f2993v0 = null;
    public RelativeLayout w0 = null;
    public TextView x0 = null;
    public View y0 = null;
    public RelativeLayout z0 = null;
    public View A0 = null;
    public View B0 = null;
    public TextView C0 = null;
    private ProgressBar E0 = null;
    public boolean F0 = false;
    public boolean G0 = false;
    private q1 H0 = null;
    public ArrayList<String> I0 = new ArrayList<>();
    private Runnable J0 = new k();
    public FrameLayout K0 = null;
    public AbsoluteLayout L0 = null;
    public WebView M0 = null;
    private View.OnClickListener N0 = new o0();
    private View.OnClickListener O0 = new p0();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z2 = PCJDkVISZlhELOr.this.F0;
        }
    }

    class a0 implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f2999e;

        a0(String str) {
            this.f2999e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(this.f2999e));
            PCJDkVISZlhELOr.this.startActivity(intent);
        }
    }

    class a1 implements Runnable {
        a1() {
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalStateException {
            if (PCJDkVISZlhELOr.this.f2990u != null) {
                try {
                    if (PCJDkVISZlhELOr.this.f2990u.isPlaying()) {
                        PCJDkVISZlhELOr.this.f2990u.stop();
                    }
                } catch (Exception unused) {
                }
                PCJDkVISZlhELOr.this.f2990u.release();
                PCJDkVISZlhELOr.this.f2990u = null;
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z2 = PCJDkVISZlhELOr.this.F0;
        }
    }

    class b0 implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f3003e;

        b0(boolean z2) {
            this.f3003e = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            WebView webView = PCJDkVISZlhELOr.this.M0;
            if (webView != null) {
                if (this.f3003e) {
                    webView.setVisibility(0);
                } else {
                    webView.setVisibility(4);
                }
            }
        }
    }

    class b1 implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ FileDescriptor f3005e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f3006f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f3007g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f3008h;

        b1(FileDescriptor fileDescriptor, long j2, long j3, boolean z2) {
            this.f3005e = fileDescriptor;
            this.f3006f = j2;
            this.f3007g = j3;
            this.f3008h = z2;
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalStateException, IOException, IllegalArgumentException {
            try {
                PCJDkVISZlhELOr.this.f2990u = new MediaPlayer();
                PCJDkVISZlhELOr.this.f2990u.setDataSource(this.f3005e, this.f3006f, this.f3007g);
                PCJDkVISZlhELOr.this.f2990u.prepare();
                PCJDkVISZlhELOr.this.f2990u.setLooping(this.f3008h);
                if (PCJDkVISZlhELOr.this.f2992v && NHelper.b().ncallback_GetMusicEnabled()) {
                    PCJDkVISZlhELOr.this.f2990u.start();
                }
            } catch (Exception unused) {
            }
        }
    }

    class c implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f3010e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f3011f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f3012g;

        c(String str, String str2, String str3) {
            this.f3010e = str;
            this.f3011f = str2;
            this.f3012g = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            PCJDkVISZlhELOr.h1.f(this.f3010e, this.f3011f, this.f3012g);
        }
    }

    class c0 implements Runnable {
        c0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PCJDkVISZlhELOr pCJDkVISZlhELOr = PCJDkVISZlhELOr.this;
            WebView webView = pCJDkVISZlhELOr.M0;
            if (webView == null || pCJDkVISZlhELOr.L0 == null) {
                return;
            }
            webView.clearCache(true);
            PCJDkVISZlhELOr.this.M0.clearHistory();
            PCJDkVISZlhELOr.this.M0.clearView();
            PCJDkVISZlhELOr.this.M0.removeAllViews();
            PCJDkVISZlhELOr pCJDkVISZlhELOr2 = PCJDkVISZlhELOr.this;
            pCJDkVISZlhELOr2.L0.removeView(pCJDkVISZlhELOr2.M0);
            PCJDkVISZlhELOr.this.M0.destroyDrawingCache();
            PCJDkVISZlhELOr.this.M0.destroy();
            PCJDkVISZlhELOr.this.M0 = null;
        }
    }

    class c1 implements Runnable {
        c1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PCJDkVISZlhELOr.this.M0();
        }
    }

    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    class d0 implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ PCJDkVISZlhELOr f3017e;

        class a implements DialogInterface.OnClickListener {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ EditText f3019e;

            a(EditText editText) {
                this.f3019e = editText;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                NHelper.b().ncallback_530183908992be8da21c9b61e8859c66(this.f3019e.getText().toString());
            }
        }

        class b implements DialogInterface.OnClickListener {
            b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                NHelper.b().ncallback_530183908992be8da21c9b61e8859c66("");
            }
        }

        d0(PCJDkVISZlhELOr pCJDkVISZlhELOr) {
            this.f3017e = pCJDkVISZlhELOr;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.f3017e);
            builder.setTitle("Title");
            EditText editText = new EditText(this.f3017e);
            editText.setInputType(1);
            builder.setView(editText);
            builder.setPositiveButton("OK", new a(editText));
            builder.setNegativeButton("Cancel", new b());
            builder.show();
        }
    }

    class d1 implements Runnable {
        d1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PCJDkVISZlhELOr.this.K0();
        }
    }

    class e implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f3023e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f3024f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f3025g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f3026h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f3027i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ int f3028j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ String f3029k;

        e(String str, String str2, String str3, String str4, String str5, int i2, String str6) {
            this.f3023e = str;
            this.f3024f = str2;
            this.f3025g = str3;
            this.f3026h = str4;
            this.f3027i = str5;
            this.f3028j = i2;
            this.f3029k = str6;
        }

        @Override // java.lang.Runnable
        public void run() {
            PCJDkVISZlhELOr.h1.C(this.f3023e, this.f3024f, this.f3025g, this.f3026h, this.f3027i, this.f3028j, this.f3029k);
        }
    }

    class e0 implements Runnable {
        e0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (PCJDkVISZlhELOr.V0.f2983q0 != null) {
                PCJDkVISZlhELOr.V0.f2983q0.setMessage(PCJDkVISZlhELOr.V0.C0("Checking"));
                PCJDkVISZlhELOr.V0.f2983q0.setIndeterminate(true);
            }
        }
    }

    class e1 implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f3031e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f3032f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f3033g;

        e1(String str, String str2, String str3) {
            this.f3031e = str;
            this.f3032f = str2;
            this.f3033g = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            PCJDkVISZlhELOr.this.R(this.f3031e, this.f3032f, this.f3033g);
        }
    }

    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PCJDkVISZlhELOr.h1.i();
        }
    }

    class f0 implements Runnable {
        f0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (PCJDkVISZlhELOr.V0.f2983q0 != null) {
                PCJDkVISZlhELOr.V0.f2983q0.setMessage(PCJDkVISZlhELOr.V0.C0("DownloadComplete"));
            }
        }
    }

    class f1 implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f3036e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f3037f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f3038g;

        f1(String str, String str2, String str3) {
            this.f3036e = str;
            this.f3037f = str2;
            this.f3038g = str3;
        }

        @Override // java.lang.Runnable
        public void run() throws InterruptedException {
            while (true) {
                PCJDkVISZlhELOr pCJDkVISZlhELOr = PCJDkVISZlhELOr.this;
                if (pCJDkVISZlhELOr.f2956c0 && pCJDkVISZlhELOr.f2957d0) {
                    AssetManager assetManager = PCJDkVISZlhELOr.U0;
                    PCJDkVISZlhELOr.p1 = j0.e.b(this.f3036e, "", this.f3037f, this.f3038g, true, false);
                    return;
                } else {
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PCJDkVISZlhELOr.h1.j();
        }
    }

    class g0 implements Runnable {
        g0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            new File(PCJDkVISZlhELOr.f1.f3198b).delete();
            if (PCJDkVISZlhELOr.V0.f2983q0 != null) {
                PCJDkVISZlhELOr.V0.f2983q0.setIndeterminate(false);
                PCJDkVISZlhELOr.V0.f2983q0.setMessage(PCJDkVISZlhELOr.V0.C0("TryReDownload"));
            }
            com.lomfsqxinjb.KRgTbxlWh.a aVar = PCJDkVISZlhELOr.f1;
            aVar.f3200d = j0.e.b(aVar.f3197a, "", aVar.f3198b, "", true, false);
        }
    }

    class g1 implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f3041e;

        g1(String str) {
            this.f3041e = str;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            try {
                File file = new File(this.f3041e);
                String strA1 = PCJDkVISZlhELOr.A1(file);
                if (PCJDkVISZlhELOr.q1.equals(strA1)) {
                    File file2 = new File(this.f3041e.substring(0, this.f3041e.lastIndexOf(".")) + ".pobb");
                    if (!file2.exists()) {
                        file.renameTo(file2);
                    }
                } else {
                    com.lomfsqxinjb.KRgTbxlWh.e.a("Invalid predownload obb md5 " + strA1 + " " + PCJDkVISZlhELOr.q1);
                    file.delete();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    class h implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f3042e;

        h(int i2) {
            this.f3042e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            PCJDkVISZlhELOr.h1.e(this.f3042e);
        }
    }

    class h0 implements Runnable {
        h0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PCJDkVISZlhELOr.h1.x();
        }
    }

    class h1 implements Runnable {
        h1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PCJDkVISZlhELOr.h1.A();
        }
    }

    class i implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f3046e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f3047f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f3048g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f3049h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f3050i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ String f3051j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ String f3052k;

        /* renamed from: l, reason: collision with root package name */
        final /* synthetic */ String f3053l;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ String f3054m;

        /* renamed from: n, reason: collision with root package name */
        final /* synthetic */ String f3055n;

        /* renamed from: o, reason: collision with root package name */
        final /* synthetic */ String f3056o;

        /* renamed from: p, reason: collision with root package name */
        final /* synthetic */ String f3057p;

        /* renamed from: q, reason: collision with root package name */
        final /* synthetic */ String f3058q;

        /* renamed from: r, reason: collision with root package name */
        final /* synthetic */ String f3059r;

        /* renamed from: s, reason: collision with root package name */
        final /* synthetic */ String f3060s;

        /* renamed from: t, reason: collision with root package name */
        final /* synthetic */ String f3061t;

        /* renamed from: u, reason: collision with root package name */
        final /* synthetic */ String f3062u;

        /* renamed from: v, reason: collision with root package name */
        final /* synthetic */ String f3063v;

        /* renamed from: w, reason: collision with root package name */
        final /* synthetic */ String f3064w;

        i(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19) {
            this.f3046e = str;
            this.f3047f = str2;
            this.f3048g = str3;
            this.f3049h = str4;
            this.f3050i = str5;
            this.f3051j = str6;
            this.f3052k = str7;
            this.f3053l = str8;
            this.f3054m = str9;
            this.f3055n = str10;
            this.f3056o = str11;
            this.f3057p = str12;
            this.f3058q = str13;
            this.f3059r = str14;
            this.f3060s = str15;
            this.f3061t = str16;
            this.f3062u = str17;
            this.f3063v = str18;
            this.f3064w = str19;
        }

        @Override // java.lang.Runnable
        public void run() {
            PCJDkVISZlhELOr.h1.v(this.f3046e, this.f3047f, this.f3048g, this.f3049h, this.f3050i, this.f3051j, this.f3052k, this.f3053l, this.f3054m, this.f3055n, this.f3056o, this.f3057p, this.f3058q, this.f3059r, this.f3060s, this.f3061t, this.f3062u, this.f3063v, this.f3064w);
        }
    }

    class i0 implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Activity f3066e;

        class a implements DialogInterface.OnClickListener {
            a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                PCJDkVISZlhELOr.this.i3();
            }
        }

        i0(Activity activity) {
            this.f3066e = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            new AlertDialog.Builder(this.f3066e).setMessage(PCJDkVISZlhELOr.this.getString(R.string.MemNotEnough)).setPositiveButton("Ok", new a()).setCancelable(false).show();
        }
    }

    class i1 implements Runnable {
        i1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PCJDkVISZlhELOr.this.P();
        }
    }

    class j implements Runnable {
        j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PCJDkVISZlhELOr.h1.a();
        }
    }

    class j0 implements Runnable {
        j0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(500L);
            alphaAnimation.setFillAfter(true);
            PCJDkVISZlhELOr.this.z0.startAnimation(alphaAnimation);
        }
    }

    class j1 implements Runnable {
        j1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PCJDkVISZlhELOr.this.Q();
        }
    }

    class k implements Runnable {
        k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PCJDkVISZlhELOr.this.I0();
        }
    }

    class k0 implements Runnable {
        k0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RelativeLayout relativeLayout = PCJDkVISZlhELOr.this.z0;
            if (relativeLayout != null) {
                relativeLayout.clearAnimation();
                ViewGroup viewGroup = (ViewGroup) PCJDkVISZlhELOr.this.z0.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(PCJDkVISZlhELOr.this.z0);
                    PCJDkVISZlhELOr.this.z0 = null;
                    Log.d("HO", "Removed welcome view");
                }
            }
        }
    }

    class k1 implements Runnable {
        k1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z2 = PCJDkVISZlhELOr.this.F0;
        }
    }

    class l implements FileFilter {
        l() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return Pattern.matches("cpu[0-9]", file.getName());
        }
    }

    class l0 implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Activity f3077e;

        class a implements DialogInterface.OnClickListener {
            a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                PCJDkVISZlhELOr.this.finish();
            }
        }

        l0(Activity activity) {
            this.f3077e = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            new AlertDialog.Builder(this.f3077e).setMessage(PCJDkVISZlhELOr.this.getString(R.string.Init_Failed)).setPositiveButton("Ok", new a()).setCancelable(false).show();
        }
    }

    class l1 {

        /* renamed from: a, reason: collision with root package name */
        private final String f3080a;

        l1(String str) {
            this.f3080a = str;
        }

        public String a() {
            return this.f3080a;
        }
    }

    class m implements Runnable {
        m() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PCJDkVISZlhELOr.h1.b();
        }
    }

    class m0 implements SurfaceHolder.Callback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f3083a;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PCJDkVISZlhELOr.this.S0();
            }
        }

        class b implements Runnable {

            class a implements DialogInterface.OnClickListener {
                a() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    PCJDkVISZlhELOr.this.finish();
                }
            }

            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                new AlertDialog.Builder(m0.this.f3083a).setMessage(PCJDkVISZlhELOr.this.getString(R.string.OpenGL_Failed)).setPositiveButton("Ok", new a()).setCancelable(false).show();
            }
        }

        class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                RelativeLayout relativeLayout = PCJDkVISZlhELOr.this.f2989t0;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(0);
                }
            }
        }

        class d implements Runnable {
            d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                RelativeLayout relativeLayout = PCJDkVISZlhELOr.this.f2989t0;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(4);
                }
            }
        }

        m0(Activity activity) {
            this.f3083a = activity;
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
            PCJDkVISZlhELOr.this.O = i3 > i4 ? i3 : i4;
            PCJDkVISZlhELOr pCJDkVISZlhELOr = PCJDkVISZlhELOr.this;
            if (i3 > i4) {
                i3 = i4;
            }
            pCJDkVISZlhELOr.P = i3;
            NHelper.b().ncallback_d2905d645ee0673f930cfeb43e487c68(PCJDkVISZlhELOr.this.O, PCJDkVISZlhELOr.this.P);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) throws IllegalStateException, SocketException, UnknownHostException {
            PCJDkVISZlhELOr.this.M = false;
            PCJDkVISZlhELOr.Q0 = surfaceHolder;
            PCJDkVISZlhELOr.this.N = true;
            surfaceHolder.setType(2);
            boolean zNcallback_5135700f5d3f4a3a8fd53c833a66f5c1 = PCJDkVISZlhELOr.this.f2980p == null ? NHelper.b().ncallback_5135700f5d3f4a3a8fd53c833a66f5c1() : true;
            if (!PCJDkVISZlhELOr.this.G && zNcallback_5135700f5d3f4a3a8fd53c833a66f5c1) {
                zNcallback_5135700f5d3f4a3a8fd53c833a66f5c1 = PCJDkVISZlhELOr.this.s1(surfaceHolder);
            }
            if (PCJDkVISZlhELOr.this.L) {
                PCJDkVISZlhELOr.this.Y0(false);
                if (!NHelper.b().ncallback_00856e6ed9bc4dde0025683a2866ae62(false)) {
                    Process.killProcess(Process.myPid());
                }
            }
            if (!PCJDkVISZlhELOr.this.L) {
                PCJDkVISZlhELOr.this.L = true;
                if (zNcallback_5135700f5d3f4a3a8fd53c833a66f5c1) {
                    PCJDkVISZlhELOr.this.f2958e.post(new a());
                } else {
                    PCJDkVISZlhELOr.this.f2958e.post(new b());
                }
            }
            PCJDkVISZlhELOr.this.f2958e.post(new c());
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) throws IllegalStateException, SocketException, UnknownHostException {
            if (!PCJDkVISZlhELOr.this.G) {
                PCJDkVISZlhELOr.this.Y0(true);
                NHelper.b();
                if (NHelper.ncallback_GetAllowFullRHIReset()) {
                    PCJDkVISZlhELOr.this.r1();
                } else {
                    PCJDkVISZlhELOr.this.t1();
                }
            }
            PCJDkVISZlhELOr.this.f2958e.post(new d());
        }
    }

    private static final class m1 implements ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        boolean f3090a;

        /* renamed from: b, reason: collision with root package name */
        private final LinkedBlockingQueue<IBinder> f3091b;

        private m1() {
            this.f3090a = false;
            this.f3091b = new LinkedBlockingQueue<>(1);
        }

        public IBinder a() throws InterruptedException {
            if (this.f3090a) {
                throw new IllegalStateException();
            }
            this.f3090a = true;
            return this.f3091b.take();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) throws InterruptedException {
            try {
                this.f3091b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    class n implements Runnable {
        n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PCJDkVISZlhELOr.h1.c();
        }
    }

    class n0 implements Runnable {
        n0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PCJDkVISZlhELOr.this.n1();
            PCJDkVISZlhELOr.this.f2958e.postDelayed(this, 1000L);
        }
    }

    final class n1 implements IInterface {

        /* renamed from: a, reason: collision with root package name */
        private IBinder f3094a;

        public n1(IBinder iBinder) {
            this.f3094a = iBinder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f3094a;
        }

        public String getId() throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f3094a.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }

    class o implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f3096e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f3097f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f3098g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f3099h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f3100i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ String f3101j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ String f3102k;

        /* renamed from: l, reason: collision with root package name */
        final /* synthetic */ String f3103l;

        o(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
            this.f3096e = str;
            this.f3097f = str2;
            this.f3098g = str3;
            this.f3099h = str4;
            this.f3100i = str5;
            this.f3101j = str6;
            this.f3102k = str7;
            this.f3103l = str8;
        }

        @Override // java.lang.Runnable
        public void run() {
            PCJDkVISZlhELOr.h1.w(this.f3096e, this.f3097f, this.f3098g, this.f3099h, this.f3100i, this.f3101j, this.f3102k, this.f3103l);
        }
    }

    class o0 implements View.OnClickListener {
        o0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PCJDkVISZlhELOr.this.N1(false);
        }
    }

    private class o1 extends BroadcastReceiver {
        private o1() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                PCJDkVISZlhELOr.l1 = (intent.getExtras().getInt("level") * 1.0f) / intent.getExtras().getInt("scale");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    class p implements Runnable {
        p() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PCJDkVISZlhELOr.h1.B();
        }
    }

    class p0 implements View.OnClickListener {
        p0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PCJDkVISZlhELOr.this.N1(true);
        }
    }

    public class p1 implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        private MediaPlayer f3109e;

        /* renamed from: f, reason: collision with root package name */
        private PCJDkVISZlhELOr f3110f;

        class a implements MediaPlayer.OnPreparedListener {
            a() {
            }

            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) throws IllegalStateException {
                mediaPlayer.start();
            }
        }

        public p1(MediaPlayer mediaPlayer, PCJDkVISZlhELOr pCJDkVISZlhELOr) {
            this.f3109e = mediaPlayer;
            this.f3110f = pCJDkVISZlhELOr;
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalStateException, IOException {
            try {
                this.f3109e.setOnPreparedListener(new a());
                this.f3109e.prepare();
            } catch (Exception e2) {
                com.lomfsqxinjb.KRgTbxlWh.e.b("Couldn't start video!!!", e2);
                this.f3110f.D0();
            }
        }
    }

    class q implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f3113e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f3114f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f3115g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f3116h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f3117i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ int f3118j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ String f3119k;

        /* renamed from: l, reason: collision with root package name */
        final /* synthetic */ String f3120l;

        q(String str, String str2, String str3, String str4, String str5, int i2, String str6, String str7) {
            this.f3113e = str;
            this.f3114f = str2;
            this.f3115g = str3;
            this.f3116h = str4;
            this.f3117i = str5;
            this.f3118j = i2;
            this.f3119k = str6;
            this.f3120l = str7;
        }

        @Override // java.lang.Runnable
        public void run() {
            PCJDkVISZlhELOr.h1.y(this.f3113e, this.f3114f, this.f3115g, this.f3116h, this.f3117i, this.f3118j, this.f3119k, this.f3120l);
        }
    }

    class q0 implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f3122e;

        q0(Context context) {
            this.f3122e = context;
        }

        @Override // java.lang.Runnable
        public void run() throws JSONException, IOException {
            String strValueOf = "";
            try {
                try {
                    strValueOf = String.valueOf(this.f3122e.getPackageManager().getPackageInfo(this.f3122e.getPackageName(), 0).versionCode);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                String strB1 = PCJDkVISZlhELOr.this.B1(this.f3122e);
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("idfv", strB1);
                    Locale locale = Locale.getDefault();
                    jSONObject2.put("language", locale.getLanguage() + "-" + locale.getCountry());
                    jSONObject2.put("packagename", this.f3122e.getPackageName());
                    jSONObject2.put("versioncode", strValueOf);
                    jSONObject2.put(DataUtil.ORDER_COLUMN.ORDER_SIGN, PCJDkVISZlhELOr.d3(jSONObject2.getString("idfv") + jSONObject2.getString("language") + jSONObject2.getString("packagename") + jSONObject2.getString("versioncode") + "6bca48a7e983fe9c0615999691f1c3c5"));
                    jSONObject.put("url", "http://170.106.2.35/tool/datatool/collect/idfv.php");
                    jSONObject.put(ShareConstants.WEB_DIALOG_PARAM_DATA, Base64.encodeToString(jSONObject2.toString().getBytes("UTF-8"), 0));
                    jSONObject.put("datatype", "SDK");
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                String string = jSONObject.toString();
                StringBuilder sb = new StringBuilder();
                Random random = new Random();
                ArrayList arrayList = new ArrayList();
                int i2 = 0;
                while (i2 < string.length()) {
                    int i3 = i2 + 1;
                    arrayList.add(string.substring(i2, i3));
                    i2 = i3;
                }
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    sb.append(random.nextInt(10) + ((String) arrayList.get(i4)));
                }
                String strE3 = PCJDkVISZlhELOr.e3(sb.toString(), PCJDkVISZlhELOr.d3("6bca48a7e983fe9c0615999691f1c3c5"));
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://protean-keyword-267902.appspot.com").openConnection();
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.setRequestProperty("Content-Type", "text/plain; charset=utf-8");
                httpURLConnection.connect();
                httpURLConnection.getOutputStream().write(strE3.getBytes());
                httpURLConnection.getOutputStream().flush();
                httpURLConnection.getOutputStream().close();
                if (httpURLConnection.getResponseCode() == 200) {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    while (inputStream.read() >= 0) {
                    }
                    inputStream.close();
                }
                httpURLConnection.disconnect();
            } catch (Exception unused) {
            }
        }
    }

    private class q1 extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        private String f3124a;

        private q1() {
            this.f3124a = null;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            this.f3124a = action;
            if ("android.intent.action.SCREEN_ON".equals(action) || "android.intent.action.SCREEN_OFF".equals(this.f3124a)) {
                return;
            }
            "android.intent.action.USER_PRESENT".equals(this.f3124a);
        }
    }

    class r implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f3126e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f3127f;

        r(int i2, int i3) {
            this.f3126e = i2;
            this.f3127f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            PCJDkVISZlhELOr.this.m1(this.f3126e, this.f3127f);
        }
    }

    class r0 implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ PCJDkVISZlhELOr f3129e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ FileDescriptor f3130f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f3131g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f3132h;

        class a implements SurfaceHolder.Callback {
            a() {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) throws IllegalStateException, IOException, IllegalArgumentException {
                if (PCJDkVISZlhELOr.this.f2995x != null && PCJDkVISZlhELOr.this.f2988t == null && surfaceHolder == PCJDkVISZlhELOr.this.f2995x.getHolder()) {
                    try {
                        PCJDkVISZlhELOr.this.f2988t = new MediaPlayer();
                        PCJDkVISZlhELOr.this.f2988t.setAudioStreamType(3);
                        PCJDkVISZlhELOr.this.f2988t.reset();
                        MediaPlayer mediaPlayer = PCJDkVISZlhELOr.this.f2988t;
                        r0 r0Var = r0.this;
                        mediaPlayer.setDataSource(r0Var.f3130f, r0Var.f3131g, r0Var.f3132h);
                        PCJDkVISZlhELOr.this.f2988t.setDisplay(surfaceHolder);
                        PCJDkVISZlhELOr.this.f2988t.setOnCompletionListener(r0.this.f3129e);
                        PCJDkVISZlhELOr pCJDkVISZlhELOr = PCJDkVISZlhELOr.this;
                        PCJDkVISZlhELOr pCJDkVISZlhELOr2 = PCJDkVISZlhELOr.this;
                        pCJDkVISZlhELOr.f2986s = new Thread(pCJDkVISZlhELOr2.new p1(pCJDkVISZlhELOr2.f2988t, r0.this.f3129e), "MoviePrepareThread");
                        PCJDkVISZlhELOr.this.f2986s.start();
                    } catch (Exception unused) {
                        PCJDkVISZlhELOr.this.D0();
                    }
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            }
        }

        r0(PCJDkVISZlhELOr pCJDkVISZlhELOr, FileDescriptor fileDescriptor, long j2, long j3) {
            this.f3129e = pCJDkVISZlhELOr;
            this.f3130f = fileDescriptor;
            this.f3131g = j2;
            this.f3132h = j3;
        }

        @Override // java.lang.Runnable
        public void run() {
            PCJDkVISZlhELOr.this.f2995x = new SurfaceView(this.f3129e);
            PCJDkVISZlhELOr.this.f2995x.setZOrderOnTop(true);
            SurfaceHolder holder = PCJDkVISZlhELOr.this.f2995x.getHolder();
            holder.setType(3);
            holder.addCallback(new a());
            PCJDkVISZlhELOr pCJDkVISZlhELOr = PCJDkVISZlhELOr.this;
            pCJDkVISZlhELOr.addContentView(pCJDkVISZlhELOr.f2995x, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    class s implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f3135e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f3136f;

        s(int i2, int i3) {
            this.f3135e = i2;
            this.f3136f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            PCJDkVISZlhELOr.this.o1(this.f3135e, this.f3136f);
        }
    }

    class s0 implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f3138e;

        s0(String str) {
            this.f3138e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            PCJDkVISZlhELOr.this.L0(this.f3138e);
        }
    }

    class t implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f3140e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f3141f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f3142g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f3143h;

        t(String str, String str2, String str3, String str4) {
            this.f3140e = str;
            this.f3141f = str2;
            this.f3142g = str3;
            this.f3143h = str4;
        }

        @Override // java.lang.Runnable
        public void run() {
            PCJDkVISZlhELOr.h1.d(this.f3140e, this.f3141f, this.f3142g, this.f3143h);
        }
    }

    class t0 implements Runnable {
        t0() {
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalStateException {
            if (PCJDkVISZlhELOr.this.f2988t != null) {
                PCJDkVISZlhELOr.this.f2988t.stop();
                PCJDkVISZlhELOr.this.f2988t.release();
                PCJDkVISZlhELOr.this.f2988t = null;
            }
            if (PCJDkVISZlhELOr.this.f2995x != null) {
                ((ViewGroup) PCJDkVISZlhELOr.this.f2995x.getParent()).removeView(PCJDkVISZlhELOr.this.f2995x);
                PCJDkVISZlhELOr.this.f2995x = null;
            }
        }
    }

    class u implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f3146e;

        u(String str) {
            this.f3146e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            PCJDkVISZlhELOr.this.p1(this.f3146e);
        }
    }

    class u0 implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f3148e;

        u0(String str) {
            this.f3148e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.f3148e));
            intent.addFlags(268435456);
            PCJDkVISZlhELOr.this.startActivity(intent);
        }
    }

    class v implements Runnable {
        v() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PCJDkVISZlhELOr.this.S0();
        }
    }

    class v0 implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ PCJDkVISZlhELOr f3151e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f3152f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f3153g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f3154h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f3155i;

        class a extends EditText {
            a(Context context) {
                super(context);
            }

            @Override // android.view.View
            public boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
                if (keyEvent.getKeyCode() != 4) {
                    return super.dispatchKeyEvent(keyEvent);
                }
                PCJDkVISZlhELOr.this.Z(true);
                return true;
            }
        }

        v0(PCJDkVISZlhELOr pCJDkVISZlhELOr, String str, int i2, String str2, int i3) {
            this.f3151e = pCJDkVISZlhELOr;
            this.f3152f = str;
            this.f3153g = i2;
            this.f3154h = str2;
            this.f3155i = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (PCJDkVISZlhELOr.this.T == null) {
                PCJDkVISZlhELOr.this.T = new LinearLayout(this.f3151e);
                PCJDkVISZlhELOr.this.T.setOrientation(1);
                LinearLayout linearLayout = PCJDkVISZlhELOr.this.T;
                PCJDkVISZlhELOr.this.U = new a(this.f3151e);
                PCJDkVISZlhELOr.this.U.setSingleLine(true);
                PCJDkVISZlhELOr.this.U.addTextChangedListener(new j0.d(PCJDkVISZlhELOr.this.U, this.f3152f, this.f3153g));
                PCJDkVISZlhELOr.this.U.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                linearLayout.addView(PCJDkVISZlhELOr.this.U, 0);
                PCJDkVISZlhELOr pCJDkVISZlhELOr = PCJDkVISZlhELOr.this;
                pCJDkVISZlhELOr.addContentView(pCJDkVISZlhELOr.T, new ViewGroup.LayoutParams(-1, -1));
                PCJDkVISZlhELOr.this.U.requestFocus();
                com.lomfsqxinjb.KRgTbxlWh.e.a("FinalText: " + this.f3154h);
                PCJDkVISZlhELOr.this.U.setText(this.f3154h);
                ((InputMethodManager) PCJDkVISZlhELOr.this.getSystemService("input_method")).showSoftInput(PCJDkVISZlhELOr.this.U, 2);
            }
            PCJDkVISZlhELOr.this.V = true;
            PCJDkVISZlhELOr.this.W = this.f3155i;
        }
    }

    class w extends TimerTask {
        w() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            PCJDkVISZlhELOr.this.j1();
        }
    }

    class w0 implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ PCJDkVISZlhELOr f3159e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f3160f;

        w0(PCJDkVISZlhELOr pCJDkVISZlhELOr, String str) {
            this.f3159e = pCJDkVISZlhELOr;
            this.f3160f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (PCJDkVISZlhELOr.this.T == null) {
                PCJDkVISZlhELOr.this.T = new LinearLayout(this.f3159e);
                PCJDkVISZlhELOr.this.T.setOrientation(1);
                LinearLayout linearLayout = PCJDkVISZlhELOr.this.T;
                PCJDkVISZlhELOr.this.U = new EditText(this.f3159e);
                PCJDkVISZlhELOr.this.U.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                linearLayout.addView(PCJDkVISZlhELOr.this.U, 0);
                PCJDkVISZlhELOr pCJDkVISZlhELOr = PCJDkVISZlhELOr.this;
                pCJDkVISZlhELOr.addContentView(pCJDkVISZlhELOr.T, new ViewGroup.LayoutParams(-1, -1));
                PCJDkVISZlhELOr.this.U.requestFocus();
                PCJDkVISZlhELOr.this.U.setText(this.f3160f);
                ((InputMethodManager) PCJDkVISZlhELOr.this.getSystemService("input_method")).showSoftInput(PCJDkVISZlhELOr.this.U, 2);
            }
            PCJDkVISZlhELOr.this.V = true;
        }
    }

    class x implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ PCJDkVISZlhELOr f3162e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f3163f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f3164g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f3165h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f3166i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ String f3167j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ boolean f3168k;

        /* renamed from: l, reason: collision with root package name */
        final /* synthetic */ boolean f3169l;

        class a implements DialogInterface.OnClickListener {
            a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                NHelper.b().ncallback_8f5798509bc86eeb660201c67bddfc93(x.this.f3166i, 0);
            }
        }

        class b implements DialogInterface.OnClickListener {
            b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                NHelper.b().ncallback_8f5798509bc86eeb660201c67bddfc93(x.this.f3166i, 1);
            }
        }

        class c implements DialogInterface.OnKeyListener {
            c() {
            }

            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                return i2 == 84;
            }
        }

        class d implements View.OnClickListener {
            d() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        }

        class e implements View.OnClickListener {
            e() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        }

        x(PCJDkVISZlhELOr pCJDkVISZlhELOr, String str, String str2, String str3, int i2, String str4, boolean z2, boolean z3) {
            this.f3162e = pCJDkVISZlhELOr;
            this.f3163f = str;
            this.f3164g = str2;
            this.f3165h = str3;
            this.f3166i = i2;
            this.f3167j = str4;
            this.f3168k = z2;
            this.f3169l = z3;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertDialog.Builder message = new AlertDialog.Builder(this.f3162e).setTitle(this.f3163f).setMessage(this.f3164g);
            String str = this.f3165h;
            if (str != null && str.length() > 0) {
                message.setPositiveButton(this.f3165h, new a());
            }
            String str2 = this.f3167j;
            if (str2 != null && str2.length() > 0) {
                message.setNegativeButton(this.f3167j, new b());
            }
            if (!this.f3168k) {
                message.setCancelable(false);
                message.setOnKeyListener(new c());
            }
            AlertDialog alertDialogCreate = message.create();
            alertDialogCreate.show();
            if (this.f3169l) {
                return;
            }
            alertDialogCreate.getButton(-1).setOnClickListener(new d());
            alertDialogCreate.getButton(-2).setOnClickListener(new e());
        }
    }

    class x0 implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f3176e;

        x0(boolean z2) {
            this.f3176e = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (PCJDkVISZlhELOr.this.T != null) {
                if (PCJDkVISZlhELOr.this.U != null && !this.f3176e) {
                    NHelper.b().ncallback_aa0da4cd257af7f7db4acdd7ed8c3c30(PCJDkVISZlhELOr.this.U.getText().toString().trim(), PCJDkVISZlhELOr.this.W);
                    PCJDkVISZlhELOr.h1.n(PCJDkVISZlhELOr.this.U.getText().toString().trim(), PCJDkVISZlhELOr.this.W);
                }
                ((InputMethodManager) PCJDkVISZlhELOr.this.getSystemService("input_method")).hideSoftInputFromWindow(PCJDkVISZlhELOr.this.U.getWindowToken(), 0);
                ((ViewGroup) PCJDkVISZlhELOr.this.T.getParent()).removeView(PCJDkVISZlhELOr.this.T);
                PCJDkVISZlhELOr.this.T = null;
                PCJDkVISZlhELOr.this.U = null;
            }
            PCJDkVISZlhELOr.this.V = false;
        }
    }

    class y implements Runnable {
        y() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RelativeLayout relativeLayout = PCJDkVISZlhELOr.V0.w0;
            if (relativeLayout != null) {
                ViewGroup viewGroup = (ViewGroup) relativeLayout.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(PCJDkVISZlhELOr.V0.w0);
                }
                PCJDkVISZlhELOr pCJDkVISZlhELOr = PCJDkVISZlhELOr.V0;
                pCJDkVISZlhELOr.w0 = null;
                pCJDkVISZlhELOr.x0 = null;
            }
            PCJDkVISZlhELOr.this.O0();
        }
    }

    class y0 implements Runnable {
        y0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Log.d("HO", "call hide splash");
            PCJDkVISZlhELOr pCJDkVISZlhELOr = PCJDkVISZlhELOr.this;
            if (pCJDkVISZlhELOr.f2989t0 != null) {
                ImageView imageView = pCJDkVISZlhELOr.f2991u0;
                if (imageView != null) {
                    try {
                        Drawable drawable = imageView.getDrawable();
                        if (drawable != null && (drawable instanceof BitmapDrawable)) {
                            ((BitmapDrawable) drawable).getBitmap().recycle();
                        }
                        PCJDkVISZlhELOr.this.f2991u0.setImageBitmap(null);
                        PCJDkVISZlhELOr.this.f2991u0 = null;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                ViewGroup viewGroup = (ViewGroup) PCJDkVISZlhELOr.this.f2989t0.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(PCJDkVISZlhELOr.this.f2989t0);
                }
                PCJDkVISZlhELOr.this.f2989t0.setVisibility(4);
                PCJDkVISZlhELOr.this.f2989t0 = null;
            }
            View view = PCJDkVISZlhELOr.this.y0;
            if (view != null) {
                ViewGroup viewGroup2 = (ViewGroup) view.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.removeView(PCJDkVISZlhELOr.this.y0);
                }
                PCJDkVISZlhELOr.this.y0.setVisibility(4);
                PCJDkVISZlhELOr.this.y0 = null;
            }
            RelativeLayout relativeLayout = PCJDkVISZlhELOr.this.f2993v0;
            if (relativeLayout != null) {
                ViewGroup viewGroup3 = (ViewGroup) relativeLayout.getParent();
                if (viewGroup3 != null) {
                    viewGroup3.removeView(PCJDkVISZlhELOr.this.f2993v0);
                }
                PCJDkVISZlhELOr.this.f2993v0.setVisibility(4);
                PCJDkVISZlhELOr.this.f2993v0 = null;
            }
        }
    }

    class z implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f3180e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f3181f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f3182g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f3183h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f3184i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ int f3185j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ int f3186k;

        /* renamed from: l, reason: collision with root package name */
        final /* synthetic */ int f3187l;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ String f3188m;

        z(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, String str) {
            this.f3180e = i2;
            this.f3181f = i3;
            this.f3182g = i4;
            this.f3183h = i5;
            this.f3184i = i6;
            this.f3185j = i7;
            this.f3186k = i8;
            this.f3187l = i9;
            this.f3188m = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            PCJDkVISZlhELOr.this.X().setLayoutParams(new AbsoluteLayout.LayoutParams(this.f3180e, this.f3181f, this.f3182g, this.f3183h));
            PCJDkVISZlhELOr.this.X().setBackgroundColor(Color.argb(this.f3184i, this.f3185j, this.f3186k, this.f3187l));
            PCJDkVISZlhELOr.this.X().setVisibility(0);
            PCJDkVISZlhELOr.this.X().loadUrl(this.f3188m);
        }
    }

    class z0 implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f3190e;

        z0(float f2) {
            this.f3190e = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            PCJDkVISZlhELOr.this.H.getHolder().setFixedSize((int) (PCJDkVISZlhELOr.this.H.getWidth() * this.f3190e), (int) (PCJDkVISZlhELOr.this.H.getHeight() * this.f3190e));
            ((ViewGroup) PCJDkVISZlhELOr.this.H.getParent()).removeView(PCJDkVISZlhELOr.this.H);
            PCJDkVISZlhELOr pCJDkVISZlhELOr = PCJDkVISZlhELOr.this;
            pCJDkVISZlhELOr.setContentView(pCJDkVISZlhELOr.H);
        }
    }

    static {
        System.loadLibrary("KRgTbxlWh");
    }

    public static String A1(File file) throws Throwable {
        String str;
        FileInputStream fileInputStream = null;
        String string = null;
        fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance(Constants.MD5);
                    byte[] bArr = new byte[102400];
                    while (true) {
                        int i2 = fileInputStream2.read(bArr);
                        if (i2 <= 0) {
                            break;
                        }
                        messageDigest.update(bArr, 0, i2);
                    }
                    string = new BigInteger(1, messageDigest.digest()).toString(16);
                    String str2 = "";
                    while (str2.length() + string.length() < 32) {
                        str2 = str2 + "0";
                    }
                    String str3 = str2 + string;
                    try {
                        fileInputStream2.close();
                        return str3;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        return str3;
                    }
                } catch (Exception e3) {
                    e = e3;
                    str = string;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    return str;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e6) {
            e = e6;
            str = null;
        }
    }

    public static void E0(int i2, String str, boolean z2) {
        com.lomfsqxinjb.KRgTbxlWh.c cVar = e1;
        boolean z3 = true;
        if (cVar != null && cVar.f3200d == i2) {
            if (z2) {
                int i3 = cVar.f3201e;
                if (i3 > 10) {
                    new File(e1.f3198b).delete();
                    PCJDkVISZlhELOr pCJDkVISZlhELOr = V0;
                    pCJDkVISZlhELOr.h2(pCJDkVISZlhELOr.C0("NotifyPlayer"), V0.C0("DownloadReboot"), V0.C0("Confirm"), "", false, false, 0);
                } else {
                    cVar.f3201e = i3 + 1;
                    cVar.f3200d = j0.e.b(cVar.f3197a, "", cVar.f3198b, "", true, false);
                }
            } else if (cVar.a()) {
                d1.remove(e1);
                e1 = null;
                if (d1.size() == 0) {
                    b1 = j0.e.g(X0, false);
                } else {
                    com.lomfsqxinjb.KRgTbxlWh.c cVar2 = d1.get(0);
                    e1 = cVar2;
                    cVar2.f3200d = j0.e.b(cVar2.f3197a, "", cVar2.f3198b, "", true, false);
                }
            } else {
                c1 = j0.e.g(a1, false);
                d1.clear();
                e1 = null;
            }
        }
        com.lomfsqxinjb.KRgTbxlWh.a aVar = f1;
        if (aVar != null && i2 == aVar.f3200d) {
            if (!z2) {
                V0.f2958e.post(new e0());
                if (f1.a()) {
                    V0.c0(f1.f3198b);
                    NHelper.b().ncallback_8f5798509bc86eeb660201c67bddfc93(0, 1);
                    V0.f2958e.post(new f0());
                    z3 = false;
                }
            }
            if (z3) {
                V0.f2958e.post(new g0());
            }
        }
        if (p1 == i2) {
            G0(str);
        }
    }

    private boolean E1(String str) {
        return Pattern.compile("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}").matcher(str).matches();
    }

    public static void F0(int i2, boolean z2, String str) throws JSONException {
        int i3 = b1;
        if (i3 > 0 && i2 == i3 && !z2) {
            if (str != "ERROR=MOERROR_SERVER_EXCEPTION;") {
                b1 = 0;
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    W0 = jSONObject.getString("version");
                    if (jSONObject.has("baseversion")) {
                        W0 = jSONObject.getString("baseversion");
                    }
                    String string = jSONObject.getString("serverurl");
                    Y0 = string;
                    if (string.indexOf("http://") == -1) {
                        Y0 = "http://" + Y0;
                    }
                    String string2 = jSONObject.getString("maplist_android");
                    Z0 = string2;
                    if (string2.indexOf("http://") == -1) {
                        Z0 = "http://" + Z0;
                    }
                } catch (JSONException unused) {
                    b1 = j0.e.g(X0, false);
                }
            } else {
                b1 = j0.e.g(X0, false);
            }
        }
        int i4 = c1;
        if (i4 <= 0 || i2 != i4) {
            return;
        }
        if (z2) {
            c1 = j0.e.g(a1, false);
            return;
        }
        c1 = 0;
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            String string3 = jSONObject2.getString("baseurl");
            JSONObject jSONObject3 = jSONObject2.getJSONObject("list");
            Iterator<String> itKeys = jSONObject3.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                com.lomfsqxinjb.KRgTbxlWh.c cVar = new com.lomfsqxinjb.KRgTbxlWh.c();
                cVar.f3197a = string3 + "/" + next;
                cVar.f3199c = jSONObject3.getJSONObject(next).getString("md5");
                cVar.f3198b = V0.W() + next;
                if (!cVar.a()) {
                    d1.add(cVar);
                    new File(cVar.f3198b).delete();
                }
            }
            if (d1.size() <= 0) {
                V0.y2();
                return;
            }
            com.lomfsqxinjb.KRgTbxlWh.c cVar2 = d1.get(0);
            e1 = cVar2;
            cVar2.f3200d = j0.e.b(cVar2.f3197a, "", cVar2.f3198b, "", true, false);
        } catch (JSONException unused2) {
            c1 = j0.e.g(a1, false);
        }
    }

    public static void G0(String str) {
        new Thread(new g1(str)).start();
    }

    public static void H0(int i2, int i3, int i4) {
        for (int i5 = 0; i5 < d1.size(); i5++) {
            com.lomfsqxinjb.KRgTbxlWh.c cVar = d1.get(i5);
            int i6 = cVar.f3200d;
            if (i6 != 0 && i6 == i2 && i3 > 0) {
                cVar.f3202f = i4 / i3;
                cVar.f3203g = i4;
                cVar.f3204h = i3;
            }
        }
        com.lomfsqxinjb.KRgTbxlWh.a aVar = f1;
        if (aVar == null || aVar.f3200d != i2) {
            return;
        }
        aVar.f3202f = i4 / i3;
        aVar.f3203g = i4;
        aVar.f3204h = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0() {
        ProgressDialog progressDialog;
        if (this.y0 != null) {
            NHelper.b();
            int iNcallback_GetStartupLoadingProgress = (int) (NHelper.ncallback_GetStartupLoadingProgress() * 100.0f);
            ProgressBar progressBar = (ProgressBar) this.y0.findViewById(R.id.start_loading_progress);
            if (progressBar != null) {
                progressBar.setProgress(iNcallback_GetStartupLoadingProgress);
            }
            TextView textView = (TextView) this.y0.findViewById(R.id.progressText);
            if (textView != null) {
                textView.setText(String.valueOf(iNcallback_GetStartupLoadingProgress) + "%");
            }
        }
        int i2 = 0;
        while (true) {
            if (i2 >= d1.size()) {
                break;
            }
            com.lomfsqxinjb.KRgTbxlWh.c cVar = d1.get(i2);
            if (cVar.f3200d != 0) {
                String str = C0("DownloadUpdate") + ((int) (cVar.f3202f * 100.0f)) + "%";
                TextView textView2 = V0.f2987s0;
                if (textView2 != null) {
                    textView2.setText(str);
                }
            } else {
                i2++;
            }
        }
        com.lomfsqxinjb.KRgTbxlWh.a aVar = f1;
        if (aVar != null && aVar.f3200d != 0 && (progressDialog = this.f2983q0) != null && progressDialog.isShowing()) {
            this.f2983q0.setProgressNumberFormat(String.format("%.2fM/%.2fM", Float.valueOf(f1.f3203g / 1048576.0f), Float.valueOf(f1.f3204h / 1048576.0f)));
            this.f2983q0.setProgress((int) (f1.f3202f * 100.0f));
        }
        View view = this.A0;
        if (view != null) {
            ProgressBar progressBar2 = (ProgressBar) view.findViewById(R.id.map_loading_progress);
            NHelper.b();
            int iNcallback_GetMapLoadingProgress = (int) (NHelper.ncallback_GetMapLoadingProgress() * 100.0f);
            if (progressBar2 != null) {
                progressBar2.setProgress(iNcallback_GetMapLoadingProgress);
            }
            TextView textView3 = (TextView) this.A0.findViewById(R.id.map_progressText);
            if (textView3 != null) {
                textView3.setText(String.valueOf(iNcallback_GetMapLoadingProgress) + "%");
            }
        }
    }

    private void J(int i2, int i3) {
        if (i2 > 0) {
            if (this.f2977n0 == "") {
                String packageName = getApplicationContext().getPackageName();
                this.f2963g0 = getFilesDir() + "/";
                String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/obb/" + packageName + "/";
                if (j0.b.b().a()) {
                    str = this.f2963g0 + "obb/" + packageName + "/";
                }
                if (this.C) {
                    this.f2977n0 = "" + ShareConstants.WEB_DIALOG_PARAM_DATA;
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.f2977n0);
                    sb.append(this.C ? ".png" : "");
                    this.f2977n0 = sb.toString();
                    str = "";
                } else {
                    String str2 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/obb/" + getApplicationContext().getPackageName();
                    try {
                        this.f2977n0 = str + ("main." + getPackageManager().getPackageInfo(getPackageName(), 0).versionCode + "." + getApplicationContext().getPackageName() + ".obb");
                        if (j0.b.b().a()) {
                            this.f2977n0 = str2 + "/" + ("main." + getPackageManager().getPackageInfo(getPackageName(), 0).versionCode + "." + getApplicationContext().getPackageName() + ".obb");
                        }
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                    try {
                        File file = new File(str);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        if (j0.b.b().a()) {
                            File file2 = new File(str2);
                            if (!file2.exists()) {
                                file2.mkdirs();
                            }
                        }
                    } catch (Exception unused2) {
                    }
                    i2 = i3;
                }
                if (i2 <= 0 || this.f2979o0 != "") {
                    return;
                }
                this.f2979o0 = str + "patch." + i2 + "." + packageName + ".asset";
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.f2979o0);
                sb2.append(this.C ? ".png" : "");
                this.f2979o0 = sb2.toString();
            }
        }
    }

    private void J0() {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://epicgames.com/technology/epic-citadel")));
    }

    private void N0() {
    }

    private int U() {
        if (R0 == null) {
            R0 = getApplicationContext().getSharedPreferences(getPackageName(), 0);
        }
        return R0.getInt("lw_performance", -1);
    }

    private void U0() throws IOException {
        String line;
        try {
            InputStream inputStreamOpen = U0.open("game_tip.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen));
            do {
                line = bufferedReader.readLine();
                if (line != null && line.trim().length() > 0) {
                    this.I0.add(line);
                }
            } while (line != null);
            inputStreamOpen.close();
        } catch (Exception unused) {
        }
    }

    private float V() {
        if (R0 == null) {
            R0 = getApplicationContext().getSharedPreferences(getPackageName(), 0);
        }
        return R0.getFloat("lw_resolution_scale", -1.0f);
    }

    public static String V0(File file) throws IOException {
        BufferedReader bufferedReader;
        String line;
        StringBuilder sb = new StringBuilder();
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        do {
            line = bufferedReader.readLine();
            if (line == null) {
                bufferedReader.close();
                return sb.toString();
            }
        } while (line.indexOf("MemTotal") == -1);
        sb.append(line);
        bufferedReader.close();
        return sb.toString();
    }

    public static String d3(String str) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(Constants.MD5);
            messageDigest.update(str.getBytes());
            byte[] bArrDigest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b2 : bArrDigest) {
                int i2 = b2 & 255;
                if (i2 < 16) {
                    stringBuffer.append(0);
                }
                stringBuffer.append(Integer.toHexString(i2));
            }
            return stringBuffer.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String e3(String str, String str2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(1, secretKeySpec);
            return new String(Base64.encode(cipher.doFinal(str.getBytes()), 0));
        } catch (Exception e2) {
            System.out.println("Error while encrypting: " + e2.toString());
            return null;
        }
    }

    private void i1() {
        this.f2996y = false;
        this.f2958e.post(new t0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m1(int i2, int i3) {
        if (this.x0 != null) {
            String strC0 = C0("InstallPatch");
            String str = String.format("(%d%%)", Integer.valueOf((i2 * 100) / i3));
            this.x0.setText(strC0 + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o1(int i2, int i3) {
        if (this.x0 != null) {
            String strC0 = C0("DownloadPatch");
            if (i3 >= 1048576) {
                String str = String.format("(%.2fM/%.2fM)", Float.valueOf(i2 / 1048576.0f), Float.valueOf(i3 / 1048576.0f));
                this.x0.setText(strC0 + str);
                return;
            }
            String str2 = String.format("(%.2fk/%.2fk)", Float.valueOf(i2 / 1024.0f), Float.valueOf(i3 / 1024.0f));
            this.x0.setText(strC0 + str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p1(String str) {
        TextView textView = this.x0;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public static String x1() {
        return "";
    }

    private void z0() {
        try {
            do {
            } while (new BufferedReader(new InputStreamReader(U0.open("misc_cfg.json"))).readLine() != null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static String z1() {
        return "";
    }

    public int A0(String str) {
        return this.f2984r.load(str, 0);
    }

    public boolean A2() {
        return this.f2996y;
    }

    public void B0() throws IOException {
        String strT = T();
        if (strT == "") {
            strT = "CHS";
        }
        String str = "localize." + strT;
        File file = new File(W() + str);
        InputStreamReader inputStreamReader = null;
        try {
            inputStreamReader = file.exists() ? new InputStreamReader(new FileInputStream(file), "UTF-8") : new InputStreamReader(U0.open(str), "UTF-8");
        } catch (Exception unused) {
        }
        if (inputStreamReader != null) {
            try {
                Properties properties = new Properties();
                this.A = properties;
                properties.load(inputStreamReader);
                inputStreamReader.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.f2958e.post(new d1());
    }

    String B1(Context context) {
        try {
            return u1(context).a();
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public void B2() {
        g1();
    }

    public String C0(String str) {
        Properties properties = this.A;
        return properties != null ? properties.getProperty(str) : str;
    }

    public boolean C1(String str) {
        return this.S.containsKey(str);
    }

    public void C2() {
        e1();
    }

    public void D0() {
        NHelper.b().ncallback_aa72e47328810372f8cee3a40a8e2842();
        i1();
    }

    public boolean D1(NHelper.EGLConfigParms eGLConfigParms) {
        int[] iArr = {12440, 2, 12344};
        char c2 = 0;
        int i2 = 12324;
        int i3 = 12323;
        int i4 = 12322;
        int i5 = 12321;
        int[] iArr2 = {12324, eGLConfigParms.redSize, 12323, eGLConfigParms.greenSize, 12322, eGLConfigParms.blueSize, 12321, eGLConfigParms.alphaSize, 12326, eGLConfigParms.stencilSize, 12325, eGLConfigParms.depthSize, 12325, 16, 12352, 4, 12344};
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        this.f2972l = egl10;
        egl10.eglGetError();
        EGLDisplay eGLDisplayEglGetDisplay = this.f2972l.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.f2978o = eGLDisplayEglGetDisplay;
        if (!this.f2972l.eglInitialize(eGLDisplayEglGetDisplay, new int[2]) || this.f2972l.eglGetError() != 12288) {
            return false;
        }
        int[] iArr3 = new int[1];
        this.f2972l.eglGetConfigs(this.f2978o, null, 0, iArr3);
        int i6 = iArr3[0];
        EGLConfig[] eGLConfigArr = new EGLConfig[i6];
        int[] iArr4 = new int[1];
        this.f2972l.eglChooseConfig(this.f2978o, iArr2, eGLConfigArr, i6, iArr4);
        if (iArr4[0] == 0) {
            return false;
        }
        int i7 = 1000000;
        int[] iArr5 = new int[1];
        int i8 = 0;
        boolean z2 = false;
        while (i8 < iArr4[c2]) {
            this.f2972l.eglGetConfigAttrib(this.f2978o, eGLConfigArr[i8], i2, iArr5);
            int i9 = iArr5[c2];
            this.f2972l.eglGetConfigAttrib(this.f2978o, eGLConfigArr[i8], i3, iArr5);
            int i10 = iArr5[c2];
            this.f2972l.eglGetConfigAttrib(this.f2978o, eGLConfigArr[i8], i4, iArr5);
            int i11 = iArr5[c2];
            this.f2972l.eglGetConfigAttrib(this.f2978o, eGLConfigArr[i8], i5, iArr5);
            int i12 = iArr5[c2];
            this.f2972l.eglGetConfigAttrib(this.f2978o, eGLConfigArr[i8], 12325, iArr5);
            int i13 = iArr5[c2];
            int[] iArr6 = iArr;
            this.f2972l.eglGetConfigAttrib(this.f2978o, eGLConfigArr[i8], 12326, iArr5);
            int iAbs = (Math.abs(iArr5[c2] - eGLConfigParms.stencilSize) << 24) + ((((Math.abs(i9 - eGLConfigParms.redSize) + Math.abs(i10 - eGLConfigParms.greenSize)) + Math.abs(i11 - eGLConfigParms.blueSize)) + Math.abs(i12 - eGLConfigParms.alphaSize)) << 16) + (Math.abs(1 - ((this.f2972l.eglGetConfigAttrib(this.f2978o, eGLConfigArr[i8], 12514, iArr5) && iArr5[0] == 12515) ? 1 : 0)) << 15) + (Math.abs(i13 - eGLConfigParms.depthSize) << 8);
            if (iAbs < i7 || !z2) {
                this.f2982q = eGLConfigArr[i8];
                this.R = i13;
                i7 = iAbs;
                z2 = true;
            }
            i8++;
            iArr = iArr6;
            c2 = 0;
            i2 = 12324;
            i3 = 12323;
            i4 = 12322;
            i5 = 12321;
        }
        int[] iArr7 = iArr;
        if (!z2) {
            return false;
        }
        EGLContext eGLContextEglCreateContext = this.f2972l.eglCreateContext(this.f2978o, this.f2982q, EGL10.EGL_NO_CONTEXT, iArr7);
        this.f2980p = eGLContextEglCreateContext;
        this.f2974m = (GL11) eGLContextEglCreateContext.getGL();
        return true;
    }

    public boolean D2() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public void E2(String str, String str2, int i2, int i3, int i4, int i5) {
        GmRXkjgJBQEyF.d(str, str2, i2, i3, i4, i5);
    }

    public float F1() {
        return V();
    }

    public boolean F2() {
        return this.C;
    }

    public void G1(String str) {
        this.f2958e.post(new u(new String(str)));
    }

    public boolean G2(NHelper.EGLConfigParms eGLConfigParms) {
        return D1(eGLConfigParms);
    }

    public void H() throws SocketException, UnknownHostException {
        s1 = true;
        j3();
        R0 = getApplicationContext().getSharedPreferences(getPackageName(), 0);
        q1(this);
    }

    public void H1(String str, String str2) {
        f3(str, str2);
    }

    public void H2() {
        SharedPreferences.Editor editorEdit;
        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName(), 0);
        String string = UUID.randomUUID().toString();
        r1 = string;
        r1 = string.replace("-", "");
        if (sharedPreferences == null || (editorEdit = sharedPreferences.edit()) == null) {
            return;
        }
        editorEdit.putString("game_device_id", r1);
        editorEdit.commit();
    }

    public void I() {
        SurfaceView surfaceView = new SurfaceView(this);
        this.H = surfaceView;
        SurfaceHolder holder = surfaceView.getHolder();
        holder.setType(2);
        holder.addCallback(new m0(this));
        this.L0 = new AbsoluteLayout(this);
        FrameLayout frameLayout = new FrameLayout(this);
        this.K0 = frameLayout;
        frameLayout.addView(this.H);
        this.K0.addView(this.L0);
        setContentView(this.K0);
    }

    public void I1() {
        N0();
    }

    public void I2() {
        this.f2958e.post(new i1());
    }

    public void J1(boolean z2) {
        this.f2958e.post(new b0(z2));
    }

    public void J2(String str, int i2, int i3, int i4, int i5, boolean z2, boolean z3, boolean z4, int i6, int i7, int i8, int i9) {
        this.f2958e.post(new z(i4, i5, i2, i3, i9, i6, i7, i8, new String(str)));
    }

    public void K() {
        if (h1 != null) {
            this.f2958e.post(new j());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void K0() {
        /*
            Method dump skipped, instructions count: 399
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lomfsqxinjb.KRgTbxlWh.PCJDkVISZlhELOr.K0():void");
    }

    public String K1() {
        return Z0;
    }

    public void K2() {
        J0();
    }

    public void L() {
        if (h1 != null) {
            this.f2958e.post(new m());
        }
    }

    public void L0(String str) {
        if (this.B0 == null) {
            View viewInflate = View.inflate(this, R.layout.maploadingview, null);
            this.B0 = viewInflate;
            this.C0 = (TextView) viewInflate.findViewById(R.id.textView_text);
            this.E0 = (ProgressBar) this.B0.findViewById(R.id.progressBar_loading);
            addContentView(this.B0, new ViewGroup.LayoutParams(-1, -1));
        }
        this.C0.setText(str);
        this.B0.setVisibility(0);
    }

    public boolean L1() {
        return g3();
    }

    public void L2(boolean z2) {
        this.f2968j = z2;
    }

    public void M() {
        if (h1 != null) {
            this.f2958e.post(new n());
        }
    }

    public void M0() {
        if (this.A0 == null) {
            View viewInflate = View.inflate(this, R.layout.new_map_loading, null);
            this.A0 = viewInflate;
            if (viewInflate != null) {
                Random random = new Random();
                ImageView imageView = (ImageView) this.A0.findViewById(R.id.bg_image);
                if (imageView != null) {
                    try {
                        NHelper.b();
                        if (NHelper.ncallback_GetContentType() == 2) {
                            imageView.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.maploading_safety));
                        } else {
                            imageView.setImageBitmap(BitmapFactory.decodeResource(getResources(), new int[]{R.drawable.maploading1, R.drawable.maploading2, R.drawable.maploading3, R.drawable.maploading4, R.drawable.maploading5, R.drawable.maploading6, R.drawable.maploading7, R.drawable.maploading8, R.drawable.maploading9}[(int) (random.nextDouble() * 8.0d)]));
                        }
                        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                TextView textView = (TextView) this.A0.findViewById(R.id.map_loading_game_tip);
                if (textView != null) {
                    try {
                        if (this.I0.size() > 0) {
                            double dNextDouble = random.nextDouble();
                            double size = this.I0.size();
                            Double.isNaN(size);
                            textView.setText(this.I0.get((int) (dNextDouble * size)));
                        } else {
                            textView.setVisibility(4);
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
                addContentView(this.A0, new ViewGroup.LayoutParams(-1, -1));
            }
        }
        this.A0.setVisibility(0);
    }

    public int M1() {
        return U();
    }

    public int M2(String str, String str2, String str3, boolean z2, String str4) {
        return j0.e.b(str, str2, str3, str4, z2, true);
    }

    public void N() {
    }

    public void N1(boolean z2) {
        Z(z2);
    }

    public void N2() {
        if (h1 != null) {
            this.f2958e.post(new f());
        }
    }

    public boolean O(String str, String str2) {
        try {
            return A1(new File(str)).equalsIgnoreCase(str2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void O0() {
        View viewInflate = View.inflate(this, R.layout.start_loading_with_tip, null);
        this.y0 = viewInflate;
        if (viewInflate != null) {
            addContentView(viewInflate, new ViewGroup.LayoutParams(-1, -1));
        }
        TextView textView = (TextView) this.y0.findViewById(R.id.loading_game_tip);
        if (textView != null) {
            try {
                if (this.I0.size() > 0) {
                    double dNextDouble = new Random().nextDouble();
                    double size = this.I0.size();
                    Double.isNaN(size);
                    textView.setText(this.I0.get((int) (dNextDouble * size)));
                } else {
                    textView.setVisibility(4);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        RelativeLayout relativeLayout = this.f2993v0;
        if (relativeLayout != null) {
            relativeLayout.bringToFront();
        }
        RelativeLayout relativeLayout2 = this.z0;
        if (relativeLayout2 != null) {
            relativeLayout2.bringToFront();
        }
    }

    public int O1() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new l()).length;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 1;
        }
    }

    public void O2(int i2) {
        k1(i2);
    }

    public void P() {
        View view = this.B0;
        if (view != null) {
            view.setVisibility(4);
        }
    }

    public void P0() throws IllegalStateException {
        try {
            MediaPlayer mediaPlayer = this.f2990u;
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                this.f2990u.pause();
            }
        } catch (Exception e2) {
            com.lomfsqxinjb.KRgTbxlWh.e.b("Failed PauseSong ", e2);
        }
        this.f2992v = false;
    }

    public void P1(FileDescriptor fileDescriptor, long j2, long j3, boolean z2) {
        Q0(fileDescriptor, j2, j3, z2);
    }

    public AssetManager P2() {
        return U0;
    }

    public void Q() {
        View view = this.A0;
        if (view != null) {
            try {
                ImageView imageView = (ImageView) view.findViewById(R.id.bg_image);
                if (imageView != null) {
                    Drawable drawable = imageView.getDrawable();
                    if (drawable != null && (drawable instanceof BitmapDrawable)) {
                        ((BitmapDrawable) drawable).getBitmap().recycle();
                    }
                    imageView.setImageBitmap(null);
                }
                this.A0.setVisibility(4);
                ViewGroup viewGroup = (ViewGroup) this.A0.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(this.A0);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.A0 = null;
        }
    }

    public void Q0(FileDescriptor fileDescriptor, long j2, long j3, boolean z2) {
        g1();
        this.f2958e.post(new b1(fileDescriptor, j2, j3, z2));
    }

    public void Q1(int i2, float f2) {
        a1(i2, f2);
    }

    public void Q2(String str, float f2, float f3, float f4, float f5, boolean z2, int i2, int i3, String str2, boolean z3, int i4) {
        b1(str, f2, f3, f4, f5, z2, i2, i3, str2, z3, i4);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void R(java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            r6 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.io.File r1 = r6.getFilesDir()
            r0.append(r1)
            java.lang.String r1 = "/"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r2 = 0
            java.lang.String r3 = android.os.Environment.getExternalStorageState()     // Catch: java.lang.Exception -> L36
            java.lang.String r4 = "mounted"
            boolean r3 = r3.equals(r4)     // Catch: java.lang.Exception -> L36
            if (r3 == 0) goto L3a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L36
            r3.<init>()     // Catch: java.lang.Exception -> L36
            java.io.File r4 = r6.getExternalFilesDir(r2)     // Catch: java.lang.Exception -> L36
            r3.append(r4)     // Catch: java.lang.Exception -> L36
            r3.append(r1)     // Catch: java.lang.Exception -> L36
            java.lang.String r0 = r3.toString()     // Catch: java.lang.Exception -> L36
            goto L3a
        L36:
            r1 = move-exception
            r1.printStackTrace()
        L3a:
            java.io.File r1 = new java.io.File
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            java.lang.String r4 = "/Apk"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r1.<init>(r3)
            r1.mkdirs()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "/Apk/"
            r1.append(r0)
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            r6.b0()
            android.app.ProgressDialog r0 = r6.f2983q0
            r0.show()
            com.lomfsqxinjb.KRgTbxlWh.a r0 = new com.lomfsqxinjb.KRgTbxlWh.a
            r0.<init>()
            com.lomfsqxinjb.KRgTbxlWh.PCJDkVISZlhELOr.f1 = r0
            r0.f3197a = r7
            r0.f3199c = r9
            r0.f3198b = r8
            java.io.File r7 = new java.io.File
            r7.<init>(r8)
            boolean r7 = r7.exists()
            r9 = 1
            r0 = 0
            if (r7 == 0) goto La3
            android.widget.TextView r7 = r6.f2987s0
            if (r7 == 0) goto L96
            java.lang.String r1 = "checking_exist_apk"
            java.lang.String r1 = r6.C0(r1)
            r7.setText(r1)
        L96:
            com.lomfsqxinjb.KRgTbxlWh.a r7 = com.lomfsqxinjb.KRgTbxlWh.PCJDkVISZlhELOr.f1
            boolean r7 = r7.a()
            if (r7 == 0) goto La3
            r6.c0(r8)
            r7 = 1
            goto La4
        La3:
            r7 = 0
        La4:
            if (r7 == 0) goto Lb0
            com.lomfsqxinjb.KRgTbxlWh.PCJDkVISZlhELOr.f1 = r2
            com.helpergames.NHelper r7 = com.helpergames.NHelper.b()
            r7.ncallback_8f5798509bc86eeb660201c67bddfc93(r0, r9)
            goto Lc2
        Lb0:
            com.lomfsqxinjb.KRgTbxlWh.a r7 = com.lomfsqxinjb.KRgTbxlWh.PCJDkVISZlhELOr.f1
            java.lang.String r0 = r7.f3197a
            java.lang.String r2 = r7.f3198b
            r4 = 1
            r5 = 0
            java.lang.String r1 = ""
            java.lang.String r3 = ""
            int r8 = j0.e.b(r0, r1, r2, r3, r4, r5)
            r7.f3200d = r8
        Lc2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lomfsqxinjb.KRgTbxlWh.PCJDkVISZlhELOr.R(java.lang.String, java.lang.String, java.lang.String):void");
    }

    public int R0(int i2, boolean z2) {
        return this.f2984r.play(i2, 0.0f, 0.0f, 0, z2 ? -1 : 0, 1.0f);
    }

    public void R1(String str) {
        d1(str);
    }

    public void R2(int i2, int i3, int i4, String str, String str2) {
        int i5 = 1;
        switch (i2) {
            case 1:
            case 2:
            case 3:
                break;
            case 4:
            default:
                i5 = 0;
                break;
            case 5:
            case 6:
            case 7:
            case 8:
                i5 = 2;
                break;
        }
        ((NotificationManager) getSystemService("notification")).cancel(i5);
        AlarmManager alarmManager = (AlarmManager) getSystemService("alarm");
        Intent intent = new Intent(this, (Class<?>) VGTARlgvP.class);
        PendingIntent broadcast = PendingIntent.getBroadcast(this, Integer.valueOf(i2).intValue(), intent, 603979776);
        if (broadcast != null) {
            broadcast.cancel();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(11, i3);
        calendar.set(12, i4);
        calendar.set(13, 0);
        calendar.set(14, 0);
        intent.putExtra("id", i2);
        intent.putExtra(ShareConstants.WEB_DIALOG_PARAM_TITLE, new String(str));
        intent.putExtra("content", new String(str2));
        PendingIntent broadcast2 = PendingIntent.getBroadcast(this, i2, intent, 67108864);
        long timeInMillis = calendar.getTimeInMillis();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long timeInMillis2 = calendar.getTimeInMillis();
        if (timeInMillis <= jCurrentTimeMillis) {
            timeInMillis2 += 86400000;
        }
        alarmManager.setRepeating(0, timeInMillis2, 86400000L, broadcast2);
    }

    public String S() {
        return w1();
    }

    public void S0() {
        n1();
        Environment.getExternalStorageState().equals("mounted");
        RelativeLayout relativeLayout = this.f2985r0;
        if (relativeLayout != null) {
            ViewGroup viewGroup = (ViewGroup) relativeLayout.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.f2985r0);
            }
            this.f2985r0 = null;
            this.f2987s0 = null;
        }
        try {
            new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).restat(Environment.getExternalStorageDirectory().getAbsolutePath());
            long blockSize = (r0.getBlockSize() * r0.getFreeBlocks()) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        NHelper.b().ncallback_8f3b0d49d4703c30fa0c65719a7c4146(getResources().getConfiguration().locale.getLanguage());
        getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        float fSqrt = (float) Math.sqrt(((float) Math.pow((1.0f / r0.xdpi) * r0.widthPixels, 2.0d)) + ((float) Math.pow((1.0f / r0.ydpi) * r0.heightPixels, 2.0d)));
        getPackageManager();
        try {
            String strZ1 = z1();
            String str = Build.MODEL;
            if (str == null) {
                str = "";
            }
            String strX1 = x1();
            NHelper.b();
            NHelper.ncallback_UpdateDeviceInfo(str, Build.VERSION.RELEASE, strZ1, strX1, "");
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        this.f2960f = true;
        if (NHelper.b().ncallback_15b30b7c011845d8e98ab04054819bb5(this.O, this.P, fSqrt, false)) {
            return;
        }
        this.f2958e.post(new l0(this));
    }

    public float S1() throws IOException, NumberFormatException {
        float f2 = 1048576.0f;
        try {
            int iO1 = O1();
            if (iO1 <= 0) {
                iO1 = 1;
            }
            float f3 = 0.0f;
            for (int i2 = 0; i2 < iO1; i2++) {
                String str = "";
                InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu" + i2 + "/cpufreq/cpuinfo_max_freq").start().getInputStream();
                byte[] bArr = new byte[24];
                while (true) {
                    int i3 = inputStream.read(bArr);
                    if (i3 <= 0) {
                        break;
                    }
                    str = str + new String(bArr, 0, i3);
                }
                inputStream.close();
                try {
                    float f4 = Float.parseFloat(str);
                    if (f4 > f3) {
                        f2 = f4;
                        f3 = f2;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return (f2 / 1024.0f) / 1024.0f;
    }

    public boolean S2() {
        return c3();
    }

    public String T() {
        if (R0 == null) {
            R0 = getApplicationContext().getSharedPreferences(getPackageName(), 0);
        }
        return R0.getString("lang", "");
    }

    public void T0(String str, String str2, String str3, String str4) {
        try {
            q1 = str2;
            if (new File(str3.substring(0, str3.lastIndexOf(".")) + ".pobb").exists()) {
                com.lomfsqxinjb.KRgTbxlWh.e.a("pobb exists, ignoring....");
            } else if (new File(str3).exists()) {
                G0(str3);
            } else {
                new Thread(new f1(str, str3, str4)).start();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public String T1() {
        return this.f2979o0;
    }

    public void T2(int i2) {
        h1(i2);
    }

    public int U1(String str, String str2) {
        return str2.length() == 0 ? j0.e.g(str, true) : j0.e.h(str, str2);
    }

    public void U2(int i2) {
        j0.e.a(i2);
    }

    public void V1(String str) {
        try {
            InputStream inputStreamOpen = U0.open(str);
            int iAvailable = inputStreamOpen.available();
            byte[] bArr = new byte[iAvailable];
            inputStreamOpen.read(bArr);
            NHelper.b();
            NHelper.ncallback_fd724baf5267862ee583e6cbfafac7bc(iAvailable, bArr);
            inputStreamOpen.close();
        } catch (Exception unused) {
        }
    }

    public void V2() {
        P0();
    }

    public String W() {
        String strValueOf;
        try {
            strValueOf = String.valueOf(getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
        } catch (PackageManager.NameNotFoundException e2) {
            com.lomfsqxinjb.KRgTbxlWh.e.b("", e2);
            strValueOf = "0.1.1";
        }
        return this.f2963g0 + getPackageName() + "/Update/" + strValueOf + "/DataAndroid/";
    }

    public void W0() throws IllegalStateException {
        try {
            MediaPlayer mediaPlayer = this.f2990u;
            if (mediaPlayer == null || !this.f2992v || mediaPlayer.isPlaying() || !NHelper.b().ncallback_GetMusicEnabled()) {
                return;
            }
            this.f2990u.start();
        } catch (Exception e2) {
            com.lomfsqxinjb.KRgTbxlWh.e.b("Failed RestoreMusic ", e2);
        }
    }

    public void W1(FileDescriptor fileDescriptor, long j2, long j3) {
        f1(fileDescriptor, j2, j3);
    }

    public String W2() {
        return Y0;
    }

    public WebView X() {
        if (this.M0 == null) {
            WebView webView = new WebView(this);
            this.M0 = webView;
            webView.setVisibility(4);
            WebSettings settings = this.M0.getSettings();
            settings.setJavaScriptEnabled(true);
            this.M0.setWebChromeClient(new WebChromeClient());
            this.M0.setWebViewClient(new WebViewClient());
            this.L0.addView(this.M0, new AbsoluteLayout.LayoutParams(100, 100, 0, 0));
            settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
            settings.setUseWideViewPort(true);
            settings.setLoadWithOverviewMode(true);
        }
        return this.M0;
    }

    public void X0(float f2) {
        this.I = f2;
        this.f2958e.post(new z0(f2));
    }

    public String X1() {
        return getPackageName();
    }

    public void X2(float f2) {
        X0(f2);
    }

    public void Y() throws IllegalStateException {
        try {
            if (this.f2988t != null) {
                D0();
            }
        } catch (Exception e2) {
            com.lomfsqxinjb.KRgTbxlWh.e.b("Failed Pause Movie ", e2);
        }
        try {
            MediaPlayer mediaPlayer = this.f2990u;
            if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                return;
            }
            this.f2990u.pause();
        } catch (Exception e3) {
            com.lomfsqxinjb.KRgTbxlWh.e.b("Failed HaltMusic ", e3);
        }
    }

    public void Y0(boolean z2) throws IllegalStateException, SocketException, UnknownHostException {
        if (NHelper.b().NativeCallback_IsInterruptionActive() && z2 && this.f2962g && !this.K) {
            this.f2962g = false;
        }
        if (z2) {
            this.f2962g = true;
            Y();
            if (!NHelper.b().ncallback_00856e6ed9bc4dde0025683a2866ae62(true)) {
                Process.killProcess(Process.myPid());
            }
            SharedPreferences.Editor editorEdit = R0.edit();
            if (editorEdit != null) {
                editorEdit.putString("language", getResources().getConfiguration().locale.getLanguage());
                editorEdit.commit();
            }
            PowerManager.WakeLock wakeLock = this.f2961f0;
            if (wakeLock != null) {
                wakeLock.release();
                this.f2961f0 = null;
            }
        }
        if (z2) {
            return;
        }
        this.f2962g = false;
        PowerManager.WakeLock wakeLock2 = this.f2961f0;
        if (wakeLock2 != null) {
            wakeLock2.release();
            this.f2961f0 = null;
        }
        PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) getSystemService("power")).newWakeLock(26, "DoNotDimScreen");
        this.f2961f0 = wakeLockNewWakeLock;
        wakeLockNewWakeLock.acquire();
        W0();
        l1();
        if (NHelper.b().ncallback_00856e6ed9bc4dde0025683a2866ae62(false)) {
            return;
        }
        Process.killProcess(Process.myPid());
    }

    public boolean Y1(String str) {
        return C1(str);
    }

    public String Y2() {
        return this.f2977n0;
    }

    public void Z(boolean z2) {
        this.f2958e.post(new x0(z2));
    }

    public void Z0(String str) {
        if (R0 == null) {
            R0 = getApplicationContext().getSharedPreferences(getPackageName(), 0);
        }
        SharedPreferences sharedPreferences = R0;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString("lang", str);
            editorEdit.commit();
        }
        h1.z(str);
    }

    public void Z1() {
        Process.killProcess(Process.myPid());
    }

    public int Z2(int i2, boolean z2) {
        return R0(i2, z2);
    }

    public void a0() {
        this.f2958e.post(new y0());
    }

    public void a1(int i2, float f2) {
        this.f2984r.setVolume(i2, f2, f2);
    }

    public void a2() {
        i1();
    }

    public void a3(boolean z2) {
        this.E = z2;
    }

    public void b0() {
        if (this.f2983q0 == null) {
            ProgressDialog progressDialog = new ProgressDialog(this);
            this.f2983q0 = progressDialog;
            progressDialog.setProgressStyle(1);
            this.f2983q0.setTitle(C0("apk_download_title"));
            this.f2983q0.setMessage(C0("found_new_version"));
            this.f2983q0.setIndeterminate(false);
            this.f2983q0.setCancelable(false);
            this.f2983q0.setMax(100);
        }
    }

    public void b1(String str, float f2, float f3, float f4, float f5, boolean z2, int i2, int i3, String str2, boolean z3, int i4) {
        this.f2958e.post(new v0(this, str2, i3, str, i4));
    }

    public void b2(String str) {
        this.f2958e.post(new s0(new String(str)));
    }

    public void b3(String str, String str2, String str3, String str4, String str5, int i2, String str6) {
        if (h1 != null) {
            this.f2958e.post(new e(str, str2, str3, str4, str5, i2, str6));
        }
    }

    public void c0(String str) {
        File file = new File(str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        startActivity(intent);
        ProgressDialog progressDialog = this.f2983q0;
        if (progressDialog == null || !progressDialog.isShowing()) {
            return;
        }
        this.f2983q0.dismiss();
    }

    public void c1(String str, boolean z2) {
        this.f2958e.post(new w0(this, str));
    }

    public boolean c2() {
        return k3();
    }

    public boolean c3() {
        EGLSurface eGLSurface;
        try {
            boolean zNcallback_5135700f5d3f4a3a8fd53c833a66f5c1 = (this.f2980p != null || this.M) ? false : NHelper.b().ncallback_5135700f5d3f4a3a8fd53c833a66f5c1();
            if (this.f2976n == null && zNcallback_5135700f5d3f4a3a8fd53c833a66f5c1) {
                s1(Q0);
            }
            EGLContext eGLContext = this.f2980p;
            if (eGLContext == null || (eGLSurface = this.f2976n) == null) {
                return false;
            }
            if (this.f2972l.eglMakeCurrent(this.f2978o, eGLSurface, eGLSurface, eGLContext)) {
                return true;
            }
            this.f2972l.eglGetError();
            return false;
        } catch (Exception e2) {
            com.lomfsqxinjb.KRgTbxlWh.e.a("Failed makeCurrent with exception:" + e2.getMessage());
            e2.printStackTrace();
            return false;
        }
    }

    public void d0() {
        B0();
    }

    public void d1(String str) {
        this.f2958e.post(new u0(str));
    }

    public void d2() {
        this.f2958e.post(new y());
    }

    public boolean e0(String str) {
        try {
            String str2 = File.separator;
            if (!str.endsWith(str2)) {
                str = str + str2;
            }
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                File[] fileArrListFiles = file.listFiles();
                boolean zE0 = true;
                for (int i2 = 0; i2 < fileArrListFiles.length; i2++) {
                    if (fileArrListFiles[i2].isFile()) {
                        zE0 = new File(fileArrListFiles[i2].getAbsolutePath()).delete();
                        if (!zE0) {
                            break;
                        }
                    } else {
                        zE0 = e0(fileArrListFiles[i2].getAbsolutePath());
                        if (!zE0) {
                            break;
                        }
                    }
                }
                if (zE0) {
                    return file.delete();
                }
                return false;
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void e1() throws IllegalStateException {
        try {
            MediaPlayer mediaPlayer = this.f2990u;
            if (mediaPlayer != null && !mediaPlayer.isPlaying() && NHelper.b().ncallback_GetMusicEnabled()) {
                this.f2990u.start();
            }
        } catch (Exception e2) {
            com.lomfsqxinjb.KRgTbxlWh.e.b("Failed StartSong ", e2);
        }
        this.f2992v = true;
    }

    public String e2() {
        String str = g1;
        return str == null ? new String("") : new String(str);
    }

    public float f0() {
        return l1;
    }

    public void f1(FileDescriptor fileDescriptor, long j2, long j3) throws InterruptedException {
        i1();
        Thread thread = this.f2986s;
        if (thread != null) {
            try {
                thread.join();
            } catch (Exception unused) {
            }
            this.f2986s = null;
        }
        this.f2996y = true;
        this.f2958e.post(new r0(this, fileDescriptor, j2, j3));
    }

    public String f2() throws IOException {
        InputStreamReader inputStreamReader;
        File file = new File(W() + "json/Client.json");
        try {
            inputStreamReader = file.exists() ? new InputStreamReader(new FileInputStream(file)) : new InputStreamReader(U0.open("Client.json"));
        } catch (Exception unused) {
            inputStreamReader = null;
        }
        if (inputStreamReader == null) {
            return "";
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    inputStreamReader.close();
                    return stringBuffer.toString();
                }
                stringBuffer.append(line);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public void f3(String str, String str2) {
        this.S.put(str, str2);
    }

    public String g0() {
        return z1().replace(CertificateUtil.DELIMITER, "").toLowerCase() + "_" + x1();
    }

    public void g1() {
        this.f2958e.post(new a1());
    }

    public String g2() {
        return new String(S());
    }

    public boolean g3() {
        EGLSurface eGLSurface = this.f2976n;
        if (eGLSurface != null && this.f2972l.eglSwapBuffers(this.f2978o, eGLSurface)) {
            return true;
        }
        if (this.Q > 10) {
            Process.killProcess(Process.myPid());
        }
        this.Q++;
        if (this.f2976n != null && this.f2972l.eglGetError() == 12302) {
            Process.killProcess(Process.myPid());
        }
        return false;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources resources = super.getResources();
        try {
            Configuration configuration = new Configuration();
            configuration.fontScale = 1.0f;
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return resources;
    }

    public String h0() {
        return Build.VERSION.RELEASE;
    }

    public void h1(int i2) {
        this.f2984r.stop(i2);
    }

    public int h2(String str, String str2, String str3, String str4, boolean z2, boolean z3, int i2) {
        this.f2958e.post(new x(this, new String(str), new String(str2), new String(str3), i2, new String(str4), z2, z3));
        return i2;
    }

    protected void h3() {
        try {
            unregisterReceiver(n1);
            unregisterReceiver(this.H0);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (!this.G) {
            r1();
        }
        Process.killProcess(Process.myPid());
        System.exit(0);
    }

    public String i0(String str) {
        try {
            return getApplicationContext().getSharedPreferences(getPackageName(), 0).getString(str, "");
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public void i2() {
        this.f2958e.post(new d0(this));
    }

    public boolean i3() {
        this.f2984r = new SoundPool(6, 3, 0);
        I();
        n0 n0Var = new n0();
        this.f2955b0 = n0Var;
        this.f2958e.post(n0Var);
        PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) getSystemService("power")).newWakeLock(26, "ScreenUp");
        this.f2961f0 = wakeLockNewWakeLock;
        wakeLockNewWakeLock.acquire();
        return true;
    }

    public boolean j0() {
        return this.f2976n == null;
    }

    public void j1() {
        NHelper.b().ncallback_f2247788582ca931a3a4392b5d7b5b21();
        Handler handler = this.f2958e;
        if (handler != null) {
            handler.post(this.J0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0047 A[Catch: Exception -> 0x007d, TryCatch #0 {Exception -> 0x007d, blocks: (B:17:0x0041, B:23:0x006b, B:25:0x0071, B:19:0x0047, B:21:0x0059), top: B:35:0x0041 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String j2() {
        /*
            r6 = this;
            java.lang.String r0 = com.lomfsqxinjb.KRgTbxlWh.PCJDkVISZlhELOr.r1
            if (r0 == 0) goto La
            int r0 = r0.length()
            if (r0 != 0) goto Lac
        La:
            java.lang.String r0 = ""
            com.lomfsqxinjb.KRgTbxlWh.PCJDkVISZlhELOr.r1 = r0
            java.lang.String r1 = r6.getPackageName()
            r2 = 0
            android.content.SharedPreferences r1 = r6.getSharedPreferences(r1, r2)
            r2 = 0
            java.lang.String r3 = "game_device_id"
            java.lang.String r1 = r1.getString(r3, r2)
            if (r1 == 0) goto L24
            com.lomfsqxinjb.KRgTbxlWh.PCJDkVISZlhELOr.r1 = r1
            goto Lac
        L24:
            java.lang.String r1 = z1()     // Catch: java.lang.Exception -> L7c
            if (r1 == 0) goto L3d
            int r2 = r1.length()     // Catch: java.lang.Exception -> L7c
            if (r2 <= 0) goto L3d
            java.lang.String r2 = ":"
            java.lang.String r1 = r1.replace(r2, r0)     // Catch: java.lang.Exception -> L7c
            java.lang.String r1 = r1.toLowerCase()     // Catch: java.lang.Exception -> L7c
            java.lang.String r2 = "mac"
            goto L3f
        L3d:
            r1 = r0
            r2 = r1
        L3f:
            if (r1 == 0) goto L47
            int r4 = r1.length()     // Catch: java.lang.Exception -> L7d
            if (r4 != 0) goto L69
        L47:
            android.content.ContentResolver r4 = r6.getContentResolver()     // Catch: java.lang.Exception -> L7d
            java.lang.String r5 = "android_id"
            java.lang.String r4 = android.provider.Settings.Secure.getString(r4, r5)     // Catch: java.lang.Exception -> L7d
            java.lang.String r5 = "9774d56d682e549c"
            boolean r5 = r5.equals(r4)     // Catch: java.lang.Exception -> L7d
            if (r5 != 0) goto L69
            java.lang.String r1 = "utf8"
            byte[] r1 = r4.getBytes(r1)     // Catch: java.lang.Exception -> L7d
            java.util.UUID r1 = java.util.UUID.nameUUIDFromBytes(r1)     // Catch: java.lang.Exception -> L7d
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L7d
            java.lang.String r2 = "aid"
        L69:
            if (r1 == 0) goto L71
            int r4 = r1.length()     // Catch: java.lang.Exception -> L7d
            if (r4 != 0) goto L85
        L71:
            java.util.UUID r1 = java.util.UUID.randomUUID()     // Catch: java.lang.Exception -> L7d
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L7d
            java.lang.String r2 = "rand"
            goto L85
        L7c:
            r2 = r0
        L7d:
            java.util.UUID r1 = java.util.UUID.randomUUID()
            java.lang.String r1 = r1.toString()
        L85:
            java.lang.String r4 = "-"
            java.lang.String r0 = r1.replace(r4, r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.lomfsqxinjb.KRgTbxlWh.PCJDkVISZlhELOr.r1 = r0
            android.content.SharedPreferences r0 = com.lomfsqxinjb.KRgTbxlWh.PCJDkVISZlhELOr.R0
            android.content.SharedPreferences$Editor r0 = r0.edit()
            if (r0 == 0) goto Lac
            java.lang.String r1 = com.lomfsqxinjb.KRgTbxlWh.PCJDkVISZlhELOr.r1
            r0.putString(r3, r1)
            r0.commit()
        Lac:
            java.lang.String r0 = new java.lang.String
            java.lang.String r1 = com.lomfsqxinjb.KRgTbxlWh.PCJDkVISZlhELOr.r1
            r0.<init>(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lomfsqxinjb.KRgTbxlWh.PCJDkVISZlhELOr.j2():java.lang.String");
    }

    public boolean j3() throws SocketException, UnknownHostException {
        setVolumeControlStream(3);
        ActivityManager activityManager = (ActivityManager) getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        this.J = NHelper.b().ncallback_58a7606c6850cf1d1c10f3b7539d020e(memoryInfo.availMem);
        this.f2963g0 = getFilesDir() + "/";
        if (D2()) {
            this.f2967i0 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/";
        } else {
            this.f2967i0 = this.f2963g0;
        }
        this.f2965h0 = this.f2963g0 + P0 + "/";
        try {
            this.f2969j0 = getPackageManager().getApplicationInfo(getPackageName(), 0).sourceDir;
        } catch (PackageManager.NameNotFoundException e2) {
            com.lomfsqxinjb.KRgTbxlWh.e.b("", e2);
        }
        try {
            this.f2971k0 = String.valueOf(getPackageManager().getPackageInfo(getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException e3) {
            com.lomfsqxinjb.KRgTbxlWh.e.b("", e3);
        }
        N();
        l1();
        NHelper.b().ncallback_1ee9897b9765a4dba1dd8987934ef019(getResources().getConfiguration().navigationHidden != 2);
        File file = new File("proc/meminfo");
        int i2 = 512;
        if (file.exists()) {
            String[] strArrSplit = V0(file).split("[ ]+");
            if (strArrSplit.length == 3) {
                i2 = Integer.parseInt(strArrSplit[1]) / 1024;
            }
        }
        if (i2 < 257) {
            this.f2958e.post(new i0(this));
        } else {
            i3();
        }
        return true;
    }

    public void k0(String str, String str2, String str3, String str4) {
        if (h1 != null) {
            this.f2958e.post(new t(str, str2, str3, str4));
        }
    }

    public void k1(int i2) {
        this.f2984r.unload(i2);
    }

    public void k2(String str, boolean z2) {
        c1(str, z2);
    }

    public boolean k3() {
        try {
            EGL10 egl10 = this.f2972l;
            EGLDisplay eGLDisplay = this.f2978o;
            EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
            return egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
        } catch (Exception e2) {
            e2.printStackTrace();
            return true;
        }
    }

    public void l0() {
        this.f2958e.post(new c1());
    }

    public void l1() throws SocketException, UnknownHostException {
        if (this.S == null) {
            this.S = new HashMap<>();
        }
        this.S.put("STORAGE_ROOT", this.f2965h0);
        this.S.put("EXTERNAL_FILES_DIR", getExternalFilesDir(null).toString());
        this.S.put("BASE_DIR", P0);
        this.S.put("EXTERNAL_ROOT", this.f2967i0);
        this.S.put("AppSource_DIR", this.f2969j0);
        this.S.put("AppVersionCode", this.f2971k0);
        String strY1 = y1();
        if (strY1 == null) {
            this.S.put("LOCAL_IP", "");
        } else {
            this.S.put("LOCAL_IP", strY1);
        }
    }

    public void l2(int i2) {
        ((AlarmManager) getSystemService("alarm")).cancel(PendingIntent.getBroadcast(this, Integer.valueOf(i2).intValue(), new Intent(this, (Class<?>) VGTARlgvP.class), 603979776));
    }

    public void m0(String str) {
        this.f2958e.post(new a0(new String(str)));
    }

    public void m2(int i2, int i3) {
        if (i3 > 0) {
            this.f2958e.post(new s(i2, i3));
        }
    }

    public void n0() {
        if (h1 != null) {
            this.f2958e.post(new h0());
        }
    }

    public void n1() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            if (networkInfo == null || !networkInfo.isConnectedOrConnecting()) {
                this.f2956c0 = false;
                this.f2957d0 = false;
                NHelper.b().ncallback_b7b8a14af93b8d8926f520a29153e985(false, false);
            } else {
                this.f2956c0 = true;
                if (networkInfo.isConnected()) {
                    this.f2957d0 = true;
                } else {
                    this.f2957d0 = false;
                }
                NHelper.b().ncallback_b7b8a14af93b8d8926f520a29153e985(true, true);
            }
        }
    }

    public void n2() {
        this.f2958e.post(new c0());
    }

    public void o0(int i2) {
        if (h1 != null) {
            this.f2958e.post(new h(i2));
        }
    }

    public String o2(String str) {
        return v1(str);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        j0.j jVar = h1;
        if (jVar != null) {
            jVar.k(i2, i3, intent);
        }
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        NHelper.b().ncallback_aa72e47328810372f8cee3a40a8e2842();
        i1();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        NHelper.b().ncallback_1ee9897b9765a4dba1dd8987934ef019(configuration.navigationHidden != 2);
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) throws IOException {
        NHelper.b().a(this);
        super.onCreate(bundle);
        V0 = this;
        if (U0 == null) {
            U0 = getAssets();
        }
        z0();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.D0 = extras.getString("DataString");
        }
        this.f2958e = new Handler();
        j0.j jVarA = j0.c.a();
        h1 = jVarA;
        jVarA.h(this);
        h1.l(bundle);
        if (h1 != null) {
            o1.length();
        }
        P0 = getPackageName();
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) getSystemService("activity")).getMemoryInfo(memoryInfo);
        T0 = memoryInfo.availMem;
        Debug.getMemoryInfo(new Debug.MemoryInfo());
        S0 = r7.getTotalPss() * 1024;
        AssetManager assets = getAssets();
        U0 = assets;
        try {
            InputStream inputStreamOpen = assets.open("data.png");
            if (inputStreamOpen != null) {
                this.C = true;
                this.B = true;
                inputStreamOpen.close();
            }
        } catch (IOException unused) {
        }
        try {
            if (Arrays.asList(getAssets().list("")).contains("DataAndroid")) {
                this.D = true;
            }
        } catch (IOException unused2) {
        }
        try {
            J(getPackageManager().getPackageInfo(getPackageName(), 0).versionCode, 0);
        } catch (PackageManager.NameNotFoundException e2) {
            com.lomfsqxinjb.KRgTbxlWh.e.b("", e2);
        }
        H();
        com.lomfsqxinjb.KRgTbxlWh.b.a(this);
        GmRXkjgJBQEyF.k(getApplicationContext());
        j0.e.i();
        this.f2981p0.scheduleAtFixedRate(new w(), 1L, 100L);
        n1 = new o1();
        this.H0 = new q1();
        try {
            registerReceiver(n1, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            registerReceiver(this.H0, intentFilter);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        U0();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        SharedPreferences.Editor editorEdit;
        j0.e.j();
        SharedPreferences sharedPreferences = R0;
        if (sharedPreferences != null && (editorEdit = sharedPreferences.edit()) != null) {
            editorEdit.putString("language", "null");
            editorEdit.commit();
        }
        super.onDestroy();
        j0.j jVar = h1;
        if (jVar != null) {
            jVar.m();
        }
        h3();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            if (this.E) {
                h1.x();
            }
            return true;
        }
        if (i2 == 82 || i2 == 84) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 == 82 || i2 == 84) {
            return true;
        }
        if (this.V && (i2 == 66 || i2 == 4)) {
            NHelper.b().jcallback_3707d28217c4cf0c3ed19593de4e15b0(false);
            return true;
        }
        if (!this.f2996y || i2 != 4) {
            return super.onKeyUp(i2, keyEvent);
        }
        D0();
        return true;
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        j0.j jVar = h1;
        if (jVar != null) {
            jVar.o(intent);
        }
    }

    @Override // android.app.Activity
    protected void onPause() throws IllegalStateException {
        super.onPause();
        this.f2966i = false;
        j0.j jVar = h1;
        if (jVar != null) {
            jVar.p();
        }
        NHelper.b();
        NHelper.NativeCallback_onEnterBack();
        P0();
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        j0.j jVar = h1;
        if (jVar != null) {
            jVar.q(i2, strArr, iArr);
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        j0.j jVar = h1;
        if (jVar != null) {
            jVar.r();
        }
    }

    @Override // android.app.Activity
    protected void onResume() throws IllegalStateException {
        super.onResume();
        j0.j jVar = h1;
        if (jVar != null) {
            jVar.s();
        }
        NHelper.b().ncallback_1ee9897b9765a4dba1dd8987934ef019(getResources().getConfiguration().navigationHidden != 2);
        n1();
        this.f2966i = true;
        NHelper.b();
        NHelper.NativeCallback_onEnterFront();
        e1();
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        j0.j jVar = h1;
        if (jVar != null) {
            jVar.t();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        SharedPreferences.Editor editorEdit;
        super.onStop();
        SharedPreferences sharedPreferences = R0;
        if (sharedPreferences != null && (editorEdit = sharedPreferences.edit()) != null) {
            editorEdit.putInt("lw_performance", R0.getInt("cur_performance", -1));
            editorEdit.putFloat("lw_resolution_scale", R0.getFloat("cur_resolution_scale", 1.0f));
            editorEdit.commit();
        }
        j0.j jVar = h1;
        if (jVar != null) {
            jVar.u();
        }
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
        if (this.V) {
            return true;
        }
        if (zOnTouchEvent) {
            return zOnTouchEvent;
        }
        int action = motionEvent.getAction();
        int i2 = action & 255;
        if (i2 != 2) {
            int i3 = action >> 8;
            return zOnTouchEvent | NHelper.b().ncallback_f6312d34d810a93c4f85e848f9745024(i2 == 5 ? 0 : i2 == 6 ? 1 : i2, (int) motionEvent.getX(i3), (int) motionEvent.getY(i3), motionEvent.getPointerId(i3), motionEvent.getEventTime());
        }
        for (int i4 = 0; i4 < motionEvent.getPointerCount(); i4++) {
            zOnTouchEvent |= NHelper.b().ncallback_f6312d34d810a93c4f85e848f9745024(2, (int) motionEvent.getX(i4), (int) motionEvent.getY(i4), motionEvent.getPointerId(i4), motionEvent.getEventTime());
        }
        return zOnTouchEvent;
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z2) {
        this.K = z2;
        if (z2) {
            j0.k.a(this);
            RelativeLayout relativeLayout = this.f2989t0;
            if (relativeLayout != null) {
                relativeLayout.invalidate();
                this.f2989t0.requestLayout();
            }
        }
    }

    public void p0() {
        if (h1 != null) {
            this.f2958e.post(new g());
        }
    }

    public void p2(String str, String str2, String str3) {
        this.f2958e.post(new e1(new String(str), new String(str2), new String(str3)));
    }

    public void q0(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19) {
        if (h1 != null) {
            this.f2958e.post(new i(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19));
        }
    }

    public void q1(Context context) {
        try {
            new Thread(new q0(context)).start();
        } catch (Exception unused) {
        }
    }

    public void q2() {
        a0();
    }

    public void r0(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        if (h1 != null) {
            this.f2958e.post(new o(str, str2, str3, str4, str5, str6, str7, str8));
        }
    }

    public void r1() {
        t1();
        EGLDisplay eGLDisplay = this.f2978o;
        if (eGLDisplay != null) {
            EGL10 egl10 = this.f2972l;
            EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
            egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
        }
        EGLContext eGLContext = this.f2980p;
        if (eGLContext != null) {
            this.f2972l.eglDestroyContext(this.f2978o, eGLContext);
        }
        EGLDisplay eGLDisplay2 = this.f2978o;
        if (eGLDisplay2 != null) {
            this.f2972l.eglTerminate(eGLDisplay2);
        }
        this.f2978o = null;
        this.f2980p = null;
        this.f2976n = null;
    }

    public int r2(String str) {
        return A0(str);
    }

    public void s0(String str, String str2, String str3, String str4, String str5, int i2, String str6, String str7) {
        if (h1 != null) {
            this.f2958e.post(new q(str, str2, str3, str4, str5, i2, str6, str7));
        }
    }

    public boolean s1(SurfaceHolder surfaceHolder) {
        try {
            this.f2976n = this.f2972l.eglCreateWindowSurface(this.f2978o, this.f2982q, surfaceHolder, null);
        } catch (Exception e2) {
            e2.printStackTrace();
            Process.killProcess(Process.myPid());
        }
        return this.f2976n != null;
    }

    public void s2(int i2, int i3) {
        if (i3 > 0) {
            this.f2958e.post(new r(i2, i3));
        }
    }

    public void t0(String str, String str2) {
        SharedPreferences.Editor editorEdit;
        try {
            SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(getPackageName(), 0);
            if (sharedPreferences == null || (editorEdit = sharedPreferences.edit()) == null) {
                return;
            }
            editorEdit.putString(new String(str), new String(str2));
            editorEdit.commit();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void t1() {
        EGL10 egl10 = this.f2972l;
        if (egl10 != null) {
            EGLDisplay eGLDisplay = this.f2978o;
            if (eGLDisplay != null && this.f2976n != null) {
                EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
                egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f2980p);
            }
            EGLSurface eGLSurface2 = this.f2976n;
            if (eGLSurface2 != null) {
                this.f2972l.eglDestroySurface(this.f2978o, eGLSurface2);
            }
        }
        this.f2976n = null;
        this.M = true;
    }

    public void t2() {
        this.f2958e.post(new j1());
    }

    public void u0() {
        if (h1 != null) {
            this.f2958e.post(new h1());
        }
    }

    public l1 u1(Context context) throws Exception {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot be called from the main thread");
        }
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            m1 m1Var = new m1();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            try {
                if (!context.bindService(intent, m1Var, 1)) {
                    throw new IOException("Google Play connection failed");
                }
                try {
                    return new l1(new n1(m1Var.a()).getId());
                } catch (Exception e2) {
                    throw e2;
                }
            } finally {
                context.unbindService(m1Var);
            }
        } catch (Exception e3) {
            throw e3;
        }
    }

    public void u2(String str, String str2, String str3) {
        if (h1 != null) {
            this.f2958e.post(new c(str, str2, str3));
        }
        if (str.equals("OnEnterComplete")) {
            this.f2958e.post(new d());
        }
    }

    public void v0() {
        if (h1 != null) {
            this.f2958e.post(new p());
        }
    }

    public String v1(String str) {
        return this.S.get(str);
    }

    public String v2() {
        return new String(T());
    }

    public void w0(String str) {
        new String(str);
        this.f2958e.post(new a());
    }

    public String w1() throws PackageManager.NameNotFoundException {
        PackageManager packageManager;
        ApplicationInfo applicationInfo = null;
        try {
            packageManager = getApplicationContext().getPackageManager();
            try {
                applicationInfo = packageManager.getApplicationInfo(getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        } catch (PackageManager.NameNotFoundException unused2) {
            packageManager = null;
        }
        return (String) packageManager.getApplicationLabel(applicationInfo);
    }

    public void w2(String str) {
        Z0(str);
    }

    public void x0(String str) {
        new String(str);
        this.f2958e.post(new b());
    }

    public boolean x2() {
        return this.D;
    }

    public void y0(String str) {
        new String(str);
        this.f2958e.post(new k1());
    }

    public String y1() throws SocketException, UnknownHostException {
        String str = null;
        try {
            InetAddress byAddress = InetAddress.getByAddress(new byte[]{0, 0, 0, 0});
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    String string = inetAddressNextElement.getHostAddress().toString();
                    if (!inetAddressNextElement.isLoopbackAddress() && !inetAddressNextElement.equals(byAddress) && E1(string)) {
                        str = string;
                    }
                }
            }
        } catch (Exception e2) {
            System.out.println(e2.toString());
        }
        return str;
    }

    public void y2() {
        this.f2958e.post(new v());
    }

    public int z2() {
        return this.R;
    }
}
