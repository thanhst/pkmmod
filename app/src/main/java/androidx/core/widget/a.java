package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;

/* compiled from: AutoScrollHelper.java */
/* loaded from: classes.dex */
public abstract class a implements View.OnTouchListener {

    /* renamed from: v, reason: collision with root package name */
    private static final int f1816v = ViewConfiguration.getTapTimeout();

    /* renamed from: g, reason: collision with root package name */
    final View f1819g;

    /* renamed from: h, reason: collision with root package name */
    private Runnable f1820h;

    /* renamed from: k, reason: collision with root package name */
    private int f1823k;

    /* renamed from: l, reason: collision with root package name */
    private int f1824l;

    /* renamed from: p, reason: collision with root package name */
    private boolean f1828p;

    /* renamed from: q, reason: collision with root package name */
    boolean f1829q;

    /* renamed from: r, reason: collision with root package name */
    boolean f1830r;

    /* renamed from: s, reason: collision with root package name */
    boolean f1831s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f1832t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f1833u;

    /* renamed from: e, reason: collision with root package name */
    final C0023a f1817e = new C0023a();

    /* renamed from: f, reason: collision with root package name */
    private final Interpolator f1818f = new AccelerateInterpolator();

    /* renamed from: i, reason: collision with root package name */
    private float[] f1821i = {0.0f, 0.0f};

    /* renamed from: j, reason: collision with root package name */
    private float[] f1822j = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: m, reason: collision with root package name */
    private float[] f1825m = {0.0f, 0.0f};

    /* renamed from: n, reason: collision with root package name */
    private float[] f1826n = {0.0f, 0.0f};

    /* renamed from: o, reason: collision with root package name */
    private float[] f1827o = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* compiled from: AutoScrollHelper.java */
    /* renamed from: androidx.core.widget.a$a, reason: collision with other inner class name */
    private static class C0023a {

        /* renamed from: a, reason: collision with root package name */
        private int f1834a;

        /* renamed from: b, reason: collision with root package name */
        private int f1835b;

        /* renamed from: c, reason: collision with root package name */
        private float f1836c;

        /* renamed from: d, reason: collision with root package name */
        private float f1837d;

        /* renamed from: j, reason: collision with root package name */
        private float f1843j;

        /* renamed from: k, reason: collision with root package name */
        private int f1844k;

        /* renamed from: e, reason: collision with root package name */
        private long f1838e = Long.MIN_VALUE;

        /* renamed from: i, reason: collision with root package name */
        private long f1842i = -1;

        /* renamed from: f, reason: collision with root package name */
        private long f1839f = 0;

        /* renamed from: g, reason: collision with root package name */
        private int f1840g = 0;

        /* renamed from: h, reason: collision with root package name */
        private int f1841h = 0;

        C0023a() {
        }

        private float e(long j2) {
            if (j2 < this.f1838e) {
                return 0.0f;
            }
            long j3 = this.f1842i;
            if (j3 < 0 || j2 < j3) {
                return a.e((j2 - r0) / this.f1834a, 0.0f, 1.0f) * 0.5f;
            }
            float f2 = this.f1843j;
            return (1.0f - f2) + (f2 * a.e((j2 - j3) / this.f1844k, 0.0f, 1.0f));
        }

        private float g(float f2) {
            return ((-4.0f) * f2 * f2) + (f2 * 4.0f);
        }

        public void a() {
            if (this.f1839f == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float fG = g(e(jCurrentAnimationTimeMillis));
            long j2 = jCurrentAnimationTimeMillis - this.f1839f;
            this.f1839f = jCurrentAnimationTimeMillis;
            float f2 = j2 * fG;
            this.f1840g = (int) (this.f1836c * f2);
            this.f1841h = (int) (f2 * this.f1837d);
        }

        public int b() {
            return this.f1840g;
        }

        public int c() {
            return this.f1841h;
        }

        public int d() {
            float f2 = this.f1836c;
            return (int) (f2 / Math.abs(f2));
        }

        public int f() {
            float f2 = this.f1837d;
            return (int) (f2 / Math.abs(f2));
        }

        public boolean h() {
            return this.f1842i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f1842i + ((long) this.f1844k);
        }

        public void i() {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f1844k = a.f((int) (jCurrentAnimationTimeMillis - this.f1838e), 0, this.f1835b);
            this.f1843j = e(jCurrentAnimationTimeMillis);
            this.f1842i = jCurrentAnimationTimeMillis;
        }

        public void j(int i2) {
            this.f1835b = i2;
        }

        public void k(int i2) {
            this.f1834a = i2;
        }

        public void l(float f2, float f3) {
            this.f1836c = f2;
            this.f1837d = f3;
        }

        public void m() {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f1838e = jCurrentAnimationTimeMillis;
            this.f1842i = -1L;
            this.f1839f = jCurrentAnimationTimeMillis;
            this.f1843j = 0.5f;
            this.f1840g = 0;
            this.f1841h = 0;
        }
    }

    /* compiled from: AutoScrollHelper.java */
    private class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            if (aVar.f1831s) {
                if (aVar.f1829q) {
                    aVar.f1829q = false;
                    aVar.f1817e.m();
                }
                C0023a c0023a = a.this.f1817e;
                if (c0023a.h() || !a.this.u()) {
                    a.this.f1831s = false;
                    return;
                }
                a aVar2 = a.this;
                if (aVar2.f1830r) {
                    aVar2.f1830r = false;
                    aVar2.c();
                }
                c0023a.a();
                a.this.j(c0023a.b(), c0023a.c());
                ViewCompat.J(a.this.f1819g, this);
            }
        }
    }

    public a(@NonNull View view) {
        this.f1819g = view;
        float f2 = Resources.getSystem().getDisplayMetrics().density;
        float f3 = (int) ((1575.0f * f2) + 0.5f);
        o(f3, f3);
        float f4 = (int) ((f2 * 315.0f) + 0.5f);
        p(f4, f4);
        l(1);
        n(Float.MAX_VALUE, Float.MAX_VALUE);
        s(0.2f, 0.2f);
        t(1.0f, 1.0f);
        k(f1816v);
        r(500);
        q(500);
    }

    private float d(int i2, float f2, float f3, float f4) {
        float fH = h(this.f1821i[i2], f3, this.f1822j[i2], f2);
        if (fH == 0.0f) {
            return 0.0f;
        }
        float f5 = this.f1825m[i2];
        float f6 = this.f1826n[i2];
        float f7 = this.f1827o[i2];
        float f8 = f5 * f4;
        return fH > 0.0f ? e(fH * f8, f6, f7) : -e((-fH) * f8, f6, f7);
    }

    static float e(float f2, float f3, float f4) {
        return f2 > f4 ? f4 : f2 < f3 ? f3 : f2;
    }

    static int f(int i2, int i3, int i4) {
        return i2 > i4 ? i4 : i2 < i3 ? i3 : i2;
    }

    private float g(float f2, float f3) {
        if (f3 == 0.0f) {
            return 0.0f;
        }
        int i2 = this.f1823k;
        if (i2 == 0 || i2 == 1) {
            if (f2 < f3) {
                if (f2 >= 0.0f) {
                    return 1.0f - (f2 / f3);
                }
                if (this.f1831s && i2 == 1) {
                    return 1.0f;
                }
            }
        } else if (i2 == 2 && f2 < 0.0f) {
            return f2 / (-f3);
        }
        return 0.0f;
    }

    private float h(float f2, float f3, float f4, float f5) {
        float interpolation;
        float fE = e(f2 * f3, 0.0f, f4);
        float fG = g(f3 - f5, fE) - g(f5, fE);
        if (fG < 0.0f) {
            interpolation = -this.f1818f.getInterpolation(-fG);
        } else {
            if (fG <= 0.0f) {
                return 0.0f;
            }
            interpolation = this.f1818f.getInterpolation(fG);
        }
        return e(interpolation, -1.0f, 1.0f);
    }

    private void i() {
        if (this.f1829q) {
            this.f1831s = false;
        } else {
            this.f1817e.i();
        }
    }

    private void v() {
        int i2;
        if (this.f1820h == null) {
            this.f1820h = new b();
        }
        this.f1831s = true;
        this.f1829q = true;
        if (this.f1828p || (i2 = this.f1824l) <= 0) {
            this.f1820h.run();
        } else {
            ViewCompat.K(this.f1819g, this.f1820h, i2);
        }
        this.f1828p = true;
    }

    public abstract boolean a(int i2);

    public abstract boolean b(int i2);

    void c() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f1819g.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    public abstract void j(int i2, int i3);

    @NonNull
    public a k(int i2) {
        this.f1824l = i2;
        return this;
    }

    @NonNull
    public a l(int i2) {
        this.f1823k = i2;
        return this;
    }

    public a m(boolean z2) {
        if (this.f1832t && !z2) {
            i();
        }
        this.f1832t = z2;
        return this;
    }

    @NonNull
    public a n(float f2, float f3) {
        float[] fArr = this.f1822j;
        fArr[0] = f2;
        fArr[1] = f3;
        return this;
    }

    @NonNull
    public a o(float f2, float f3) {
        float[] fArr = this.f1827o;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f3 / 1000.0f;
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0016  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.f1832t
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            int r0 = r7.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1a
            if (r0 == r2) goto L16
            r3 = 2
            if (r0 == r3) goto L1e
            r6 = 3
            if (r0 == r6) goto L16
            goto L58
        L16:
            r5.i()
            goto L58
        L1a:
            r5.f1830r = r2
            r5.f1828p = r1
        L1e:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.f1819g
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.d(r1, r0, r3, r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.f1819g
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.d(r2, r7, r6, r3)
            androidx.core.widget.a$a r7 = r5.f1817e
            r7.l(r0, r6)
            boolean r6 = r5.f1831s
            if (r6 != 0) goto L58
            boolean r6 = r5.u()
            if (r6 == 0) goto L58
            r5.v()
        L58:
            boolean r6 = r5.f1833u
            if (r6 == 0) goto L61
            boolean r6 = r5.f1831s
            if (r6 == 0) goto L61
            r1 = 1
        L61:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    @NonNull
    public a p(float f2, float f3) {
        float[] fArr = this.f1826n;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f3 / 1000.0f;
        return this;
    }

    @NonNull
    public a q(int i2) {
        this.f1817e.j(i2);
        return this;
    }

    @NonNull
    public a r(int i2) {
        this.f1817e.k(i2);
        return this;
    }

    @NonNull
    public a s(float f2, float f3) {
        float[] fArr = this.f1821i;
        fArr[0] = f2;
        fArr[1] = f3;
        return this;
    }

    @NonNull
    public a t(float f2, float f3) {
        float[] fArr = this.f1825m;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f3 / 1000.0f;
        return this;
    }

    boolean u() {
        C0023a c0023a = this.f1817e;
        int iF = c0023a.f();
        int iD = c0023a.d();
        return (iF != 0 && b(iF)) || (iD != 0 && a(iD));
    }
}
