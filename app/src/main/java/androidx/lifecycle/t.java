package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ReportFragment;

/* compiled from: ProcessLifecycleOwner.java */
/* loaded from: classes.dex */
public class t implements m {

    /* renamed from: m, reason: collision with root package name */
    private static final t f2462m = new t();

    /* renamed from: i, reason: collision with root package name */
    private Handler f2467i;

    /* renamed from: e, reason: collision with root package name */
    private int f2463e = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f2464f = 0;

    /* renamed from: g, reason: collision with root package name */
    private boolean f2465g = true;

    /* renamed from: h, reason: collision with root package name */
    private boolean f2466h = true;

    /* renamed from: j, reason: collision with root package name */
    private final n f2468j = new n(this);

    /* renamed from: k, reason: collision with root package name */
    private Runnable f2469k = new a();

    /* renamed from: l, reason: collision with root package name */
    ReportFragment.a f2470l = new b();

    /* compiled from: ProcessLifecycleOwner.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            t.this.f();
            t.this.g();
        }
    }

    /* compiled from: ProcessLifecycleOwner.java */
    class b implements ReportFragment.a {
        b() {
        }

        @Override // androidx.lifecycle.ReportFragment.a
        public void a() {
        }

        @Override // androidx.lifecycle.ReportFragment.a
        public void onResume() {
            t.this.b();
        }

        @Override // androidx.lifecycle.ReportFragment.a
        public void onStart() {
            t.this.c();
        }
    }

    /* compiled from: ProcessLifecycleOwner.java */
    class c extends e {

        /* compiled from: ProcessLifecycleOwner.java */
        class a extends e {
            a() {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostResumed(@NonNull Activity activity) {
                t.this.b();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostStarted(@NonNull Activity activity) {
                t.this.c();
            }
        }

        c() {
        }

        @Override // androidx.lifecycle.e, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (Build.VERSION.SDK_INT < 29) {
                ReportFragment.f(activity).h(t.this.f2470l);
            }
        }

        @Override // androidx.lifecycle.e, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            t.this.a();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        @RequiresApi(29)
        public void onActivityPreCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
            activity.registerActivityLifecycleCallbacks(new a());
        }

        @Override // androidx.lifecycle.e, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            t.this.d();
        }
    }

    private t() {
    }

    @NonNull
    public static m h() {
        return f2462m;
    }

    static void i(Context context) {
        f2462m.e(context);
    }

    void a() {
        int i2 = this.f2464f - 1;
        this.f2464f = i2;
        if (i2 == 0) {
            this.f2467i.postDelayed(this.f2469k, 700L);
        }
    }

    void b() {
        int i2 = this.f2464f + 1;
        this.f2464f = i2;
        if (i2 == 1) {
            if (!this.f2465g) {
                this.f2467i.removeCallbacks(this.f2469k);
            } else {
                this.f2468j.h(Lifecycle.Event.ON_RESUME);
                this.f2465g = false;
            }
        }
    }

    void c() {
        int i2 = this.f2463e + 1;
        this.f2463e = i2;
        if (i2 == 1 && this.f2466h) {
            this.f2468j.h(Lifecycle.Event.ON_START);
            this.f2466h = false;
        }
    }

    void d() {
        this.f2463e--;
        g();
    }

    void e(Context context) {
        this.f2467i = new Handler();
        this.f2468j.h(Lifecycle.Event.ON_CREATE);
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new c());
    }

    void f() {
        if (this.f2464f == 0) {
            this.f2465g = true;
            this.f2468j.h(Lifecycle.Event.ON_PAUSE);
        }
    }

    void g() {
        if (this.f2463e == 0 && this.f2465g) {
            this.f2468j.h(Lifecycle.Event.ON_STOP);
            this.f2466h = true;
        }
    }

    @Override // androidx.lifecycle.m
    @NonNull
    public Lifecycle getLifecycle() {
        return this.f2468j;
    }
}
