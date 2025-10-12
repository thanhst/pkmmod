package f;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.SparseArray;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationTargetException;

/* compiled from: DrawableContainerCompat.java */
/* loaded from: classes.dex */
public class b extends Drawable implements Drawable.Callback {

    /* renamed from: e, reason: collision with root package name */
    private d f3240e;

    /* renamed from: f, reason: collision with root package name */
    private Rect f3241f;

    /* renamed from: g, reason: collision with root package name */
    private Drawable f3242g;

    /* renamed from: h, reason: collision with root package name */
    private Drawable f3243h;

    /* renamed from: j, reason: collision with root package name */
    private boolean f3245j;

    /* renamed from: l, reason: collision with root package name */
    private boolean f3247l;

    /* renamed from: m, reason: collision with root package name */
    private Runnable f3248m;

    /* renamed from: n, reason: collision with root package name */
    private long f3249n;

    /* renamed from: o, reason: collision with root package name */
    private long f3250o;

    /* renamed from: p, reason: collision with root package name */
    private c f3251p;

    /* renamed from: i, reason: collision with root package name */
    private int f3244i = 255;

    /* renamed from: k, reason: collision with root package name */
    private int f3246k = -1;

    /* compiled from: DrawableContainerCompat.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(true);
            b.this.invalidateSelf();
        }
    }

    /* compiled from: DrawableContainerCompat.java */
    @RequiresApi(21)
    /* renamed from: f.b$b, reason: collision with other inner class name */
    private static class C0050b {
        public static boolean a(Drawable.ConstantState constantState) {
            return constantState.canApplyTheme();
        }

        public static void b(Drawable drawable, Outline outline) {
            drawable.getOutline(outline);
        }

        public static Resources c(Resources.Theme theme) {
            return theme.getResources();
        }
    }

    /* compiled from: DrawableContainerCompat.java */
    static class c implements Drawable.Callback {

        /* renamed from: e, reason: collision with root package name */
        private Drawable.Callback f3253e;

        c() {
        }

        public Drawable.Callback a() {
            Drawable.Callback callback = this.f3253e;
            this.f3253e = null;
            return callback;
        }

        public c b(Drawable.Callback callback) {
            this.f3253e = callback;
            return this;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(@NonNull Drawable drawable) {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j2) {
            Drawable.Callback callback = this.f3253e;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j2);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
            Drawable.Callback callback = this.f3253e;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }
    }

    /* compiled from: DrawableContainerCompat.java */
    static abstract class d extends Drawable.ConstantState {
        int A;
        int B;
        boolean C;
        ColorFilter D;
        boolean E;
        ColorStateList F;
        PorterDuff.Mode G;
        boolean H;
        boolean I;

        /* renamed from: a, reason: collision with root package name */
        final b f3254a;

        /* renamed from: b, reason: collision with root package name */
        Resources f3255b;

        /* renamed from: c, reason: collision with root package name */
        int f3256c;

        /* renamed from: d, reason: collision with root package name */
        int f3257d;

        /* renamed from: e, reason: collision with root package name */
        int f3258e;

        /* renamed from: f, reason: collision with root package name */
        SparseArray<Drawable.ConstantState> f3259f;

        /* renamed from: g, reason: collision with root package name */
        Drawable[] f3260g;

        /* renamed from: h, reason: collision with root package name */
        int f3261h;

        /* renamed from: i, reason: collision with root package name */
        boolean f3262i;

        /* renamed from: j, reason: collision with root package name */
        boolean f3263j;

        /* renamed from: k, reason: collision with root package name */
        Rect f3264k;

        /* renamed from: l, reason: collision with root package name */
        boolean f3265l;

        /* renamed from: m, reason: collision with root package name */
        boolean f3266m;

        /* renamed from: n, reason: collision with root package name */
        int f3267n;

        /* renamed from: o, reason: collision with root package name */
        int f3268o;

        /* renamed from: p, reason: collision with root package name */
        int f3269p;

        /* renamed from: q, reason: collision with root package name */
        int f3270q;

        /* renamed from: r, reason: collision with root package name */
        boolean f3271r;

        /* renamed from: s, reason: collision with root package name */
        int f3272s;

        /* renamed from: t, reason: collision with root package name */
        boolean f3273t;

        /* renamed from: u, reason: collision with root package name */
        boolean f3274u;

        /* renamed from: v, reason: collision with root package name */
        boolean f3275v;

        /* renamed from: w, reason: collision with root package name */
        boolean f3276w;

        /* renamed from: x, reason: collision with root package name */
        boolean f3277x;

        /* renamed from: y, reason: collision with root package name */
        boolean f3278y;

        /* renamed from: z, reason: collision with root package name */
        int f3279z;

        d(d dVar, b bVar, Resources resources) {
            this.f3262i = false;
            this.f3265l = false;
            this.f3277x = true;
            this.A = 0;
            this.B = 0;
            this.f3254a = bVar;
            this.f3255b = resources != null ? resources : dVar != null ? dVar.f3255b : null;
            int iF = b.f(resources, dVar != null ? dVar.f3256c : 0);
            this.f3256c = iF;
            if (dVar == null) {
                this.f3260g = new Drawable[10];
                this.f3261h = 0;
                return;
            }
            this.f3257d = dVar.f3257d;
            this.f3258e = dVar.f3258e;
            this.f3275v = true;
            this.f3276w = true;
            this.f3262i = dVar.f3262i;
            this.f3265l = dVar.f3265l;
            this.f3277x = dVar.f3277x;
            this.f3278y = dVar.f3278y;
            this.f3279z = dVar.f3279z;
            this.A = dVar.A;
            this.B = dVar.B;
            this.C = dVar.C;
            this.D = dVar.D;
            this.E = dVar.E;
            this.F = dVar.F;
            this.G = dVar.G;
            this.H = dVar.H;
            this.I = dVar.I;
            if (dVar.f3256c == iF) {
                if (dVar.f3263j) {
                    this.f3264k = dVar.f3264k != null ? new Rect(dVar.f3264k) : null;
                    this.f3263j = true;
                }
                if (dVar.f3266m) {
                    this.f3267n = dVar.f3267n;
                    this.f3268o = dVar.f3268o;
                    this.f3269p = dVar.f3269p;
                    this.f3270q = dVar.f3270q;
                    this.f3266m = true;
                }
            }
            if (dVar.f3271r) {
                this.f3272s = dVar.f3272s;
                this.f3271r = true;
            }
            if (dVar.f3273t) {
                this.f3274u = dVar.f3274u;
                this.f3273t = true;
            }
            Drawable[] drawableArr = dVar.f3260g;
            this.f3260g = new Drawable[drawableArr.length];
            this.f3261h = dVar.f3261h;
            SparseArray<Drawable.ConstantState> sparseArray = dVar.f3259f;
            if (sparseArray != null) {
                this.f3259f = sparseArray.clone();
            } else {
                this.f3259f = new SparseArray<>(this.f3261h);
            }
            int i2 = this.f3261h;
            for (int i3 = 0; i3 < i2; i3++) {
                Drawable drawable = drawableArr[i3];
                if (drawable != null) {
                    Drawable.ConstantState constantState = drawable.getConstantState();
                    if (constantState != null) {
                        this.f3259f.put(i3, constantState);
                    } else {
                        this.f3260g[i3] = drawableArr[i3];
                    }
                }
            }
        }

        private void e() {
            SparseArray<Drawable.ConstantState> sparseArray = this.f3259f;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.f3260g[this.f3259f.keyAt(i2)] = s(this.f3259f.valueAt(i2).newDrawable(this.f3255b));
                }
                this.f3259f = null;
            }
        }

        private Drawable s(Drawable drawable) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            if (Build.VERSION.SDK_INT >= 23) {
                androidx.core.graphics.drawable.a.l(drawable, this.f3279z);
            }
            Drawable drawableMutate = drawable.mutate();
            drawableMutate.setCallback(this.f3254a);
            return drawableMutate;
        }

        public final int a(Drawable drawable) {
            int i2 = this.f3261h;
            if (i2 >= this.f3260g.length) {
                o(i2, i2 + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.f3254a);
            this.f3260g[i2] = drawable;
            this.f3261h++;
            this.f3258e = drawable.getChangingConfigurations() | this.f3258e;
            p();
            this.f3264k = null;
            this.f3263j = false;
            this.f3266m = false;
            this.f3275v = false;
            return i2;
        }

        @RequiresApi(21)
        final void b(Resources.Theme theme) {
            if (theme != null) {
                e();
                int i2 = this.f3261h;
                Drawable[] drawableArr = this.f3260g;
                for (int i3 = 0; i3 < i2; i3++) {
                    Drawable drawable = drawableArr[i3];
                    if (drawable != null && androidx.core.graphics.drawable.a.b(drawable)) {
                        androidx.core.graphics.drawable.a.a(drawableArr[i3], theme);
                        this.f3258e |= drawableArr[i3].getChangingConfigurations();
                    }
                }
                y(C0050b.c(theme));
            }
        }

        public boolean c() {
            if (this.f3275v) {
                return this.f3276w;
            }
            e();
            this.f3275v = true;
            int i2 = this.f3261h;
            Drawable[] drawableArr = this.f3260g;
            for (int i3 = 0; i3 < i2; i3++) {
                if (drawableArr[i3].getConstantState() == null) {
                    this.f3276w = false;
                    return false;
                }
            }
            this.f3276w = true;
            return true;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @RequiresApi(21)
        public boolean canApplyTheme() {
            int i2 = this.f3261h;
            Drawable[] drawableArr = this.f3260g;
            for (int i3 = 0; i3 < i2; i3++) {
                Drawable drawable = drawableArr[i3];
                if (drawable == null) {
                    Drawable.ConstantState constantState = this.f3259f.get(i3);
                    if (constantState != null && C0050b.a(constantState)) {
                        return true;
                    }
                } else if (androidx.core.graphics.drawable.a.b(drawable)) {
                    return true;
                }
            }
            return false;
        }

        protected void d() {
            this.f3266m = true;
            e();
            int i2 = this.f3261h;
            Drawable[] drawableArr = this.f3260g;
            this.f3268o = -1;
            this.f3267n = -1;
            this.f3270q = 0;
            this.f3269p = 0;
            for (int i3 = 0; i3 < i2; i3++) {
                Drawable drawable = drawableArr[i3];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.f3267n) {
                    this.f3267n = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.f3268o) {
                    this.f3268o = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.f3269p) {
                    this.f3269p = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.f3270q) {
                    this.f3270q = minimumHeight;
                }
            }
        }

        final int f() {
            return this.f3260g.length;
        }

        public final Drawable g(int i2) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            int iIndexOfKey;
            Drawable drawable = this.f3260g[i2];
            if (drawable != null) {
                return drawable;
            }
            SparseArray<Drawable.ConstantState> sparseArray = this.f3259f;
            if (sparseArray == null || (iIndexOfKey = sparseArray.indexOfKey(i2)) < 0) {
                return null;
            }
            Drawable drawableS = s(this.f3259f.valueAt(iIndexOfKey).newDrawable(this.f3255b));
            this.f3260g[i2] = drawableS;
            this.f3259f.removeAt(iIndexOfKey);
            if (this.f3259f.size() == 0) {
                this.f3259f = null;
            }
            return drawableS;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f3257d | this.f3258e;
        }

        public final int h() {
            return this.f3261h;
        }

        public final int i() {
            if (!this.f3266m) {
                d();
            }
            return this.f3268o;
        }

        public final int j() {
            if (!this.f3266m) {
                d();
            }
            return this.f3270q;
        }

        public final int k() {
            if (!this.f3266m) {
                d();
            }
            return this.f3269p;
        }

        public final Rect l() {
            Rect rect = null;
            if (this.f3262i) {
                return null;
            }
            Rect rect2 = this.f3264k;
            if (rect2 != null || this.f3263j) {
                return rect2;
            }
            e();
            Rect rect3 = new Rect();
            int i2 = this.f3261h;
            Drawable[] drawableArr = this.f3260g;
            for (int i3 = 0; i3 < i2; i3++) {
                if (drawableArr[i3].getPadding(rect3)) {
                    if (rect == null) {
                        rect = new Rect(0, 0, 0, 0);
                    }
                    int i4 = rect3.left;
                    if (i4 > rect.left) {
                        rect.left = i4;
                    }
                    int i5 = rect3.top;
                    if (i5 > rect.top) {
                        rect.top = i5;
                    }
                    int i6 = rect3.right;
                    if (i6 > rect.right) {
                        rect.right = i6;
                    }
                    int i7 = rect3.bottom;
                    if (i7 > rect.bottom) {
                        rect.bottom = i7;
                    }
                }
            }
            this.f3263j = true;
            this.f3264k = rect;
            return rect;
        }

        public final int m() {
            if (!this.f3266m) {
                d();
            }
            return this.f3267n;
        }

        public final int n() {
            if (this.f3271r) {
                return this.f3272s;
            }
            e();
            int i2 = this.f3261h;
            Drawable[] drawableArr = this.f3260g;
            int opacity = i2 > 0 ? drawableArr[0].getOpacity() : -2;
            for (int i3 = 1; i3 < i2; i3++) {
                opacity = Drawable.resolveOpacity(opacity, drawableArr[i3].getOpacity());
            }
            this.f3272s = opacity;
            this.f3271r = true;
            return opacity;
        }

        public void o(int i2, int i3) {
            Drawable[] drawableArr = new Drawable[i3];
            Drawable[] drawableArr2 = this.f3260g;
            if (drawableArr2 != null) {
                System.arraycopy(drawableArr2, 0, drawableArr, 0, i2);
            }
            this.f3260g = drawableArr;
        }

        void p() {
            this.f3271r = false;
            this.f3273t = false;
        }

        public final boolean q() {
            return this.f3265l;
        }

        abstract void r();

        public final void t(boolean z2) {
            this.f3265l = z2;
        }

        public final void u(int i2) {
            this.A = i2;
        }

        public final void v(int i2) {
            this.B = i2;
        }

        final boolean w(int i2, int i3) {
            int i4 = this.f3261h;
            Drawable[] drawableArr = this.f3260g;
            boolean z2 = false;
            for (int i5 = 0; i5 < i4; i5++) {
                Drawable drawable = drawableArr[i5];
                if (drawable != null) {
                    boolean zL = Build.VERSION.SDK_INT >= 23 ? androidx.core.graphics.drawable.a.l(drawable, i2) : false;
                    if (i5 == i3) {
                        z2 = zL;
                    }
                }
            }
            this.f3279z = i2;
            return z2;
        }

        public final void x(boolean z2) {
            this.f3262i = z2;
        }

        final void y(Resources resources) {
            if (resources != null) {
                this.f3255b = resources;
                int iF = b.f(resources, this.f3256c);
                int i2 = this.f3256c;
                this.f3256c = iF;
                if (i2 != iF) {
                    this.f3266m = false;
                    this.f3263j = false;
                }
            }
        }
    }

    private void d(Drawable drawable) {
        if (this.f3251p == null) {
            this.f3251p = new c();
        }
        drawable.setCallback(this.f3251p.b(drawable.getCallback()));
        try {
            if (this.f3240e.A <= 0 && this.f3245j) {
                drawable.setAlpha(this.f3244i);
            }
            d dVar = this.f3240e;
            if (dVar.E) {
                drawable.setColorFilter(dVar.D);
            } else {
                if (dVar.H) {
                    androidx.core.graphics.drawable.a.n(drawable, dVar.F);
                }
                d dVar2 = this.f3240e;
                if (dVar2.I) {
                    androidx.core.graphics.drawable.a.o(drawable, dVar2.G);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f3240e.f3277x);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 23) {
                androidx.core.graphics.drawable.a.l(drawable, androidx.core.graphics.drawable.a.e(this));
            }
            androidx.core.graphics.drawable.a.i(drawable, this.f3240e.C);
            Rect rect = this.f3241f;
            if (i2 >= 21 && rect != null) {
                androidx.core.graphics.drawable.a.k(drawable, rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            drawable.setCallback(this.f3251p.a());
        }
    }

    private boolean e() {
        return isAutoMirrored() && androidx.core.graphics.drawable.a.e(this) == 1;
    }

    static int f(@Nullable Resources resources, int i2) {
        if (resources != null) {
            i2 = resources.getDisplayMetrics().densityDpi;
        }
        if (i2 == 0) {
            return 160;
        }
        return i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void a(boolean r14) {
        /*
            r13 = this;
            r0 = 1
            r13.f3245j = r0
            long r1 = android.os.SystemClock.uptimeMillis()
            android.graphics.drawable.Drawable r3 = r13.f3242g
            r4 = 255(0xff, double:1.26E-321)
            r6 = 0
            r7 = 0
            if (r3 == 0) goto L38
            long r9 = r13.f3249n
            int r11 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r11 == 0) goto L3a
            int r11 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r11 > 0) goto L22
            int r9 = r13.f3244i
            r3.setAlpha(r9)
            r13.f3249n = r7
            goto L3a
        L22:
            long r9 = r9 - r1
            long r9 = r9 * r4
            int r10 = (int) r9
            f.b$d r9 = r13.f3240e
            int r9 = r9.A
            int r10 = r10 / r9
            int r9 = 255 - r10
            int r10 = r13.f3244i
            int r9 = r9 * r10
            int r9 = r9 / 255
            r3.setAlpha(r9)
            r3 = 1
            goto L3b
        L38:
            r13.f3249n = r7
        L3a:
            r3 = 0
        L3b:
            android.graphics.drawable.Drawable r9 = r13.f3243h
            if (r9 == 0) goto L65
            long r10 = r13.f3250o
            int r12 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r12 == 0) goto L67
            int r12 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r12 > 0) goto L52
            r9.setVisible(r6, r6)
            r0 = 0
            r13.f3243h = r0
            r13.f3250o = r7
            goto L67
        L52:
            long r10 = r10 - r1
            long r10 = r10 * r4
            int r3 = (int) r10
            f.b$d r4 = r13.f3240e
            int r4 = r4.B
            int r3 = r3 / r4
            int r4 = r13.f3244i
            int r3 = r3 * r4
            int r3 = r3 / 255
            r9.setAlpha(r3)
            goto L68
        L65:
            r13.f3250o = r7
        L67:
            r0 = r3
        L68:
            if (r14 == 0) goto L74
            if (r0 == 0) goto L74
            java.lang.Runnable r14 = r13.f3248m
            r3 = 16
            long r1 = r1 + r3
            r13.scheduleSelf(r14, r1)
        L74:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f.b.a(boolean):void");
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(21)
    public void applyTheme(@NonNull Resources.Theme theme) {
        this.f3240e.b(theme);
    }

    d b() {
        throw null;
    }

    int c() {
        return this.f3246k;
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(21)
    public boolean canApplyTheme() {
        return this.f3240e.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Drawable drawable = this.f3242g;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f3243h;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    boolean g(int r10) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            r9 = this;
            int r0 = r9.f3246k
            r1 = 0
            if (r10 != r0) goto L6
            return r1
        L6:
            long r2 = android.os.SystemClock.uptimeMillis()
            f.b$d r0 = r9.f3240e
            int r0 = r0.B
            r4 = 0
            r5 = 0
            if (r0 <= 0) goto L2e
            android.graphics.drawable.Drawable r0 = r9.f3243h
            if (r0 == 0) goto L1a
            r0.setVisible(r1, r1)
        L1a:
            android.graphics.drawable.Drawable r0 = r9.f3242g
            if (r0 == 0) goto L29
            r9.f3243h = r0
            f.b$d r0 = r9.f3240e
            int r0 = r0.B
            long r0 = (long) r0
            long r0 = r0 + r2
            r9.f3250o = r0
            goto L35
        L29:
            r9.f3243h = r4
            r9.f3250o = r5
            goto L35
        L2e:
            android.graphics.drawable.Drawable r0 = r9.f3242g
            if (r0 == 0) goto L35
            r0.setVisible(r1, r1)
        L35:
            if (r10 < 0) goto L55
            f.b$d r0 = r9.f3240e
            int r1 = r0.f3261h
            if (r10 >= r1) goto L55
            android.graphics.drawable.Drawable r0 = r0.g(r10)
            r9.f3242g = r0
            r9.f3246k = r10
            if (r0 == 0) goto L5a
            f.b$d r10 = r9.f3240e
            int r10 = r10.A
            if (r10 <= 0) goto L51
            long r7 = (long) r10
            long r2 = r2 + r7
            r9.f3249n = r2
        L51:
            r9.d(r0)
            goto L5a
        L55:
            r9.f3242g = r4
            r10 = -1
            r9.f3246k = r10
        L5a:
            long r0 = r9.f3249n
            r10 = 1
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 != 0) goto L67
            long r0 = r9.f3250o
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 == 0) goto L79
        L67:
            java.lang.Runnable r0 = r9.f3248m
            if (r0 != 0) goto L73
            f.b$a r0 = new f.b$a
            r0.<init>()
            r9.f3248m = r0
            goto L76
        L73:
            r9.unscheduleSelf(r0)
        L76:
            r9.a(r10)
        L79:
            r9.invalidateSelf()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: f.b.g(int):boolean");
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f3244i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f3240e.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (!this.f3240e.c()) {
            return null;
        }
        this.f3240e.f3257d = getChangingConfigurations();
        return this.f3240e;
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable getCurrent() {
        return this.f3242g;
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(@NonNull Rect rect) {
        Rect rect2 = this.f3241f;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f3240e.q()) {
            return this.f3240e.i();
        }
        Drawable drawable = this.f3242g;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f3240e.q()) {
            return this.f3240e.m();
        }
        Drawable drawable = this.f3242g;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        if (this.f3240e.q()) {
            return this.f3240e.j();
        }
        Drawable drawable = this.f3242g;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        if (this.f3240e.q()) {
            return this.f3240e.k();
        }
        Drawable drawable = this.f3242g;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f3242g;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        return this.f3240e.n();
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(21)
    public void getOutline(@NonNull Outline outline) {
        Drawable drawable = this.f3242g;
        if (drawable != null) {
            C0050b.b(drawable, outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        boolean padding;
        Rect rectL = this.f3240e.l();
        if (rectL != null) {
            rect.set(rectL);
            padding = (rectL.right | ((rectL.left | rectL.top) | rectL.bottom)) != 0;
        } else {
            Drawable drawable = this.f3242g;
            padding = drawable != null ? drawable.getPadding(rect) : super.getPadding(rect);
        }
        if (e()) {
            int i2 = rect.left;
            rect.left = rect.right;
            rect.right = i2;
        }
        return padding;
    }

    void h(d dVar) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        this.f3240e = dVar;
        int i2 = this.f3246k;
        if (i2 >= 0) {
            Drawable drawableG = dVar.g(i2);
            this.f3242g = drawableG;
            if (drawableG != null) {
                d(drawableG);
            }
        }
        this.f3243h = null;
    }

    final void i(Resources resources) {
        this.f3240e.y(resources);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        d dVar = this.f3240e;
        if (dVar != null) {
            dVar.p();
        }
        if (drawable != this.f3242g || getCallback() == null) {
            return;
        }
        getCallback().invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.f3240e.C;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        boolean z2;
        Drawable drawable = this.f3243h;
        boolean z3 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.f3243h = null;
            z2 = true;
        } else {
            z2 = false;
        }
        Drawable drawable2 = this.f3242g;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f3245j) {
                this.f3242g.setAlpha(this.f3244i);
            }
        }
        if (this.f3250o != 0) {
            this.f3250o = 0L;
            z2 = true;
        }
        if (this.f3249n != 0) {
            this.f3249n = 0L;
        } else {
            z3 = z2;
        }
        if (z3) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (!this.f3247l && super.mutate() == this) {
            d dVarB = b();
            dVarB.r();
            h(dVarB);
            this.f3247l = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f3243h;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.f3242g;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i2) {
        return this.f3240e.w(i2, c());
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i2) {
        Drawable drawable = this.f3243h;
        if (drawable != null) {
            return drawable.setLevel(i2);
        }
        Drawable drawable2 = this.f3242g;
        if (drawable2 != null) {
            return drawable2.setLevel(i2);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(@NonNull int[] iArr) {
        Drawable drawable = this.f3243h;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        Drawable drawable2 = this.f3242g;
        if (drawable2 != null) {
            return drawable2.setState(iArr);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j2) {
        if (drawable != this.f3242g || getCallback() == null) {
            return;
        }
        getCallback().scheduleDrawable(this, runnable, j2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        if (this.f3245j && this.f3244i == i2) {
            return;
        }
        this.f3245j = true;
        this.f3244i = i2;
        Drawable drawable = this.f3242g;
        if (drawable != null) {
            if (this.f3249n == 0) {
                drawable.setAlpha(i2);
            } else {
                a(false);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z2) {
        d dVar = this.f3240e;
        if (dVar.C != z2) {
            dVar.C = z2;
            Drawable drawable = this.f3242g;
            if (drawable != null) {
                androidx.core.graphics.drawable.a.i(drawable, z2);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        d dVar = this.f3240e;
        dVar.E = true;
        if (dVar.D != colorFilter) {
            dVar.D = colorFilter;
            Drawable drawable = this.f3242g;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z2) {
        d dVar = this.f3240e;
        if (dVar.f3277x != z2) {
            dVar.f3277x = z2;
            Drawable drawable = this.f3242g;
            if (drawable != null) {
                drawable.setDither(z2);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f2, float f3) {
        Drawable drawable = this.f3242g;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.j(drawable, f2, f3);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i2, int i3, int i4, int i5) {
        Rect rect = this.f3241f;
        if (rect == null) {
            this.f3241f = new Rect(i2, i3, i4, i5);
        } else {
            rect.set(i2, i3, i4, i5);
        }
        Drawable drawable = this.f3242g;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.k(drawable, i2, i3, i4, i5);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(@ColorInt int i2) {
        setTintList(ColorStateList.valueOf(i2));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        d dVar = this.f3240e;
        dVar.H = true;
        if (dVar.F != colorStateList) {
            dVar.F = colorStateList;
            androidx.core.graphics.drawable.a.n(this.f3242g, colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(@NonNull PorterDuff.Mode mode) {
        d dVar = this.f3240e;
        dVar.I = true;
        if (dVar.G != mode) {
            dVar.G = mode;
            androidx.core.graphics.drawable.a.o(this.f3242g, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z2, boolean z3) {
        boolean visible = super.setVisible(z2, z3);
        Drawable drawable = this.f3243h;
        if (drawable != null) {
            drawable.setVisible(z2, z3);
        }
        Drawable drawable2 = this.f3242g;
        if (drawable2 != null) {
            drawable2.setVisible(z2, z3);
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        if (drawable != this.f3242g || getCallback() == null) {
            return;
        }
        getCallback().unscheduleDrawable(this, runnable);
    }
}
