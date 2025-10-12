package androidx.core.view;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

/* loaded from: classes.dex */
public class WindowInsetsCompat {

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public static final WindowInsetsCompat f1674b;

    /* renamed from: a, reason: collision with root package name */
    private final l f1675a;

    public static final class Type {

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public @interface InsetsType {
        }

        static int a(int i2) {
            if (i2 == 1) {
                return 0;
            }
            if (i2 == 2) {
                return 1;
            }
            if (i2 == 4) {
                return 2;
            }
            if (i2 == 8) {
                return 3;
            }
            if (i2 == 16) {
                return 4;
            }
            if (i2 == 32) {
                return 5;
            }
            if (i2 == 64) {
                return 6;
            }
            if (i2 == 128) {
                return 7;
            }
            if (i2 == 256) {
                return 8;
            }
            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i2);
        }
    }

    @RequiresApi(21)
    @SuppressLint({"SoonBlockedPrivateApi"})
    static class a {

        /* renamed from: a, reason: collision with root package name */
        private static Field f1676a;

        /* renamed from: b, reason: collision with root package name */
        private static Field f1677b;

        /* renamed from: c, reason: collision with root package name */
        private static Field f1678c;

        /* renamed from: d, reason: collision with root package name */
        private static boolean f1679d;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                f1676a = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                f1677b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                f1678c = declaredField3;
                declaredField3.setAccessible(true);
                f1679d = true;
            } catch (ReflectiveOperationException e2) {
                Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e2.getMessage(), e2);
            }
        }

        @Nullable
        public static WindowInsetsCompat a(@NonNull View view) throws IllegalAccessException, IllegalArgumentException {
            if (f1679d && view.isAttachedToWindow()) {
                try {
                    Object obj = f1676a.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) f1677b.get(obj);
                        Rect rect2 = (Rect) f1678c.get(obj);
                        if (rect != null && rect2 != null) {
                            WindowInsetsCompat windowInsetsCompatA = new b().b(androidx.core.graphics.b.c(rect)).c(androidx.core.graphics.b.c(rect2)).a();
                            windowInsetsCompatA.r(windowInsetsCompatA);
                            windowInsetsCompatA.d(view.getRootView());
                            return windowInsetsCompatA;
                        }
                    }
                } catch (IllegalAccessException e2) {
                    Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e2.getMessage(), e2);
                }
            }
            return null;
        }
    }

    @RequiresApi(30)
    private static class e extends d {
        e() {
        }

        e(@NonNull WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
        }
    }

    private static class f {

        /* renamed from: a, reason: collision with root package name */
        private final WindowInsetsCompat f1688a;

        /* renamed from: b, reason: collision with root package name */
        androidx.core.graphics.b[] f1689b;

        f() {
            this(new WindowInsetsCompat((WindowInsetsCompat) null));
        }

        protected final void a() {
            androidx.core.graphics.b[] bVarArr = this.f1689b;
            if (bVarArr != null) {
                androidx.core.graphics.b bVarF = bVarArr[Type.a(1)];
                androidx.core.graphics.b bVarF2 = this.f1689b[Type.a(2)];
                if (bVarF2 == null) {
                    bVarF2 = this.f1688a.f(2);
                }
                if (bVarF == null) {
                    bVarF = this.f1688a.f(1);
                }
                f(androidx.core.graphics.b.a(bVarF, bVarF2));
                androidx.core.graphics.b bVar = this.f1689b[Type.a(16)];
                if (bVar != null) {
                    e(bVar);
                }
                androidx.core.graphics.b bVar2 = this.f1689b[Type.a(32)];
                if (bVar2 != null) {
                    c(bVar2);
                }
                androidx.core.graphics.b bVar3 = this.f1689b[Type.a(64)];
                if (bVar3 != null) {
                    g(bVar3);
                }
            }
        }

        @NonNull
        WindowInsetsCompat b() {
            a();
            return this.f1688a;
        }

        void c(@NonNull androidx.core.graphics.b bVar) {
        }

        void d(@NonNull androidx.core.graphics.b bVar) {
        }

        void e(@NonNull androidx.core.graphics.b bVar) {
        }

        void f(@NonNull androidx.core.graphics.b bVar) {
        }

        void g(@NonNull androidx.core.graphics.b bVar) {
        }

        f(@NonNull WindowInsetsCompat windowInsetsCompat) {
            this.f1688a = windowInsetsCompat;
        }
    }

    @RequiresApi(28)
    private static class i extends h {
        i(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        @Override // androidx.core.view.WindowInsetsCompat.l
        @NonNull
        WindowInsetsCompat a() {
            return WindowInsetsCompat.u(this.f1695c.consumeDisplayCutout());
        }

        @Override // androidx.core.view.WindowInsetsCompat.g, androidx.core.view.WindowInsetsCompat.l
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            return Objects.equals(this.f1695c, iVar.f1695c) && Objects.equals(this.f1699g, iVar.f1699g);
        }

        @Override // androidx.core.view.WindowInsetsCompat.l
        @Nullable
        androidx.core.view.c f() {
            return androidx.core.view.c.e(this.f1695c.getDisplayCutout());
        }

        @Override // androidx.core.view.WindowInsetsCompat.l
        public int hashCode() {
            return this.f1695c.hashCode();
        }

        i(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull i iVar) {
            super(windowInsetsCompat, iVar);
        }
    }

    @RequiresApi(30)
    private static class k extends j {

        /* renamed from: q, reason: collision with root package name */
        @NonNull
        static final WindowInsetsCompat f1704q = WindowInsetsCompat.u(WindowInsets.CONSUMED);

        k(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        @Override // androidx.core.view.WindowInsetsCompat.g, androidx.core.view.WindowInsetsCompat.l
        final void d(@NonNull View view) {
        }

        @Override // androidx.core.view.WindowInsetsCompat.g, androidx.core.view.WindowInsetsCompat.l
        @NonNull
        public androidx.core.graphics.b g(int i2) {
            return androidx.core.graphics.b.d(this.f1695c.getInsets(m.a(i2)));
        }

        k(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull k kVar) {
            super(windowInsetsCompat, kVar);
        }
    }

    private static class l {

        /* renamed from: b, reason: collision with root package name */
        @NonNull
        static final WindowInsetsCompat f1705b = new b().a().a().b().c();

        /* renamed from: a, reason: collision with root package name */
        final WindowInsetsCompat f1706a;

        l(@NonNull WindowInsetsCompat windowInsetsCompat) {
            this.f1706a = windowInsetsCompat;
        }

        @NonNull
        WindowInsetsCompat a() {
            return this.f1706a;
        }

        @NonNull
        WindowInsetsCompat b() {
            return this.f1706a;
        }

        @NonNull
        WindowInsetsCompat c() {
            return this.f1706a;
        }

        void d(@NonNull View view) {
        }

        void e(@NonNull WindowInsetsCompat windowInsetsCompat) {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof l)) {
                return false;
            }
            l lVar = (l) obj;
            return o() == lVar.o() && n() == lVar.n() && androidx.core.util.c.a(k(), lVar.k()) && androidx.core.util.c.a(i(), lVar.i()) && androidx.core.util.c.a(f(), lVar.f());
        }

        @Nullable
        androidx.core.view.c f() {
            return null;
        }

        @NonNull
        androidx.core.graphics.b g(int i2) {
            return androidx.core.graphics.b.f1492e;
        }

        @NonNull
        androidx.core.graphics.b h() {
            return k();
        }

        public int hashCode() {
            return androidx.core.util.c.b(Boolean.valueOf(o()), Boolean.valueOf(n()), k(), i(), f());
        }

        @NonNull
        androidx.core.graphics.b i() {
            return androidx.core.graphics.b.f1492e;
        }

        @NonNull
        androidx.core.graphics.b j() {
            return k();
        }

        @NonNull
        androidx.core.graphics.b k() {
            return androidx.core.graphics.b.f1492e;
        }

        @NonNull
        androidx.core.graphics.b l() {
            return k();
        }

        @NonNull
        WindowInsetsCompat m(int i2, int i3, int i4, int i5) {
            return f1705b;
        }

        boolean n() {
            return false;
        }

        boolean o() {
            return false;
        }

        public void p(androidx.core.graphics.b[] bVarArr) {
        }

        void q(@NonNull androidx.core.graphics.b bVar) {
        }

        void r(@Nullable WindowInsetsCompat windowInsetsCompat) {
        }

        public void s(androidx.core.graphics.b bVar) {
        }
    }

    @RequiresApi(30)
    private static final class m {
        static int a(int i2) {
            int iStatusBars;
            int i3 = 0;
            for (int i4 = 1; i4 <= 256; i4 <<= 1) {
                if ((i2 & i4) != 0) {
                    if (i4 == 1) {
                        iStatusBars = WindowInsets.Type.statusBars();
                    } else if (i4 == 2) {
                        iStatusBars = WindowInsets.Type.navigationBars();
                    } else if (i4 == 4) {
                        iStatusBars = WindowInsets.Type.captionBar();
                    } else if (i4 == 8) {
                        iStatusBars = WindowInsets.Type.ime();
                    } else if (i4 == 16) {
                        iStatusBars = WindowInsets.Type.systemGestures();
                    } else if (i4 == 32) {
                        iStatusBars = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i4 == 64) {
                        iStatusBars = WindowInsets.Type.tappableElement();
                    } else if (i4 == 128) {
                        iStatusBars = WindowInsets.Type.displayCutout();
                    }
                    i3 |= iStatusBars;
                }
            }
            return i3;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            f1674b = k.f1704q;
        } else {
            f1674b = l.f1705b;
        }
    }

    @RequiresApi(20)
    private WindowInsetsCompat(@NonNull WindowInsets windowInsets) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 30) {
            this.f1675a = new k(this, windowInsets);
            return;
        }
        if (i2 >= 29) {
            this.f1675a = new j(this, windowInsets);
            return;
        }
        if (i2 >= 28) {
            this.f1675a = new i(this, windowInsets);
            return;
        }
        if (i2 >= 21) {
            this.f1675a = new h(this, windowInsets);
        } else if (i2 >= 20) {
            this.f1675a = new g(this, windowInsets);
        } else {
            this.f1675a = new l(this);
        }
    }

    static androidx.core.graphics.b m(@NonNull androidx.core.graphics.b bVar, int i2, int i3, int i4, int i5) {
        int iMax = Math.max(0, bVar.f1493a - i2);
        int iMax2 = Math.max(0, bVar.f1494b - i3);
        int iMax3 = Math.max(0, bVar.f1495c - i4);
        int iMax4 = Math.max(0, bVar.f1496d - i5);
        return (iMax == i2 && iMax2 == i3 && iMax3 == i4 && iMax4 == i5) ? bVar : androidx.core.graphics.b.b(iMax, iMax2, iMax3, iMax4);
    }

    @NonNull
    @RequiresApi(20)
    public static WindowInsetsCompat u(@NonNull WindowInsets windowInsets) {
        return v(windowInsets, null);
    }

    @NonNull
    @RequiresApi(20)
    public static WindowInsetsCompat v(@NonNull WindowInsets windowInsets, @Nullable View view) {
        WindowInsetsCompat windowInsetsCompat = new WindowInsetsCompat((WindowInsets) androidx.core.util.h.f(windowInsets));
        if (view != null && ViewCompat.A(view)) {
            windowInsetsCompat.r(ViewCompat.u(view));
            windowInsetsCompat.d(view.getRootView());
        }
        return windowInsetsCompat;
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat a() {
        return this.f1675a.a();
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat b() {
        return this.f1675a.b();
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat c() {
        return this.f1675a.c();
    }

    void d(@NonNull View view) {
        this.f1675a.d(view);
    }

    @Nullable
    public androidx.core.view.c e() {
        return this.f1675a.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WindowInsetsCompat) {
            return androidx.core.util.c.a(this.f1675a, ((WindowInsetsCompat) obj).f1675a);
        }
        return false;
    }

    @NonNull
    public androidx.core.graphics.b f(int i2) {
        return this.f1675a.g(i2);
    }

    @NonNull
    @Deprecated
    public androidx.core.graphics.b g() {
        return this.f1675a.i();
    }

    @Deprecated
    public int h() {
        return this.f1675a.k().f1496d;
    }

    public int hashCode() {
        l lVar = this.f1675a;
        if (lVar == null) {
            return 0;
        }
        return lVar.hashCode();
    }

    @Deprecated
    public int i() {
        return this.f1675a.k().f1493a;
    }

    @Deprecated
    public int j() {
        return this.f1675a.k().f1495c;
    }

    @Deprecated
    public int k() {
        return this.f1675a.k().f1494b;
    }

    @NonNull
    public WindowInsetsCompat l(@IntRange(from = 0) int i2, @IntRange(from = 0) int i3, @IntRange(from = 0) int i4, @IntRange(from = 0) int i5) {
        return this.f1675a.m(i2, i3, i4, i5);
    }

    public boolean n() {
        return this.f1675a.n();
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat o(int i2, int i3, int i4, int i5) {
        return new b(this).c(androidx.core.graphics.b.b(i2, i3, i4, i5)).a();
    }

    void p(androidx.core.graphics.b[] bVarArr) {
        this.f1675a.p(bVarArr);
    }

    void q(@NonNull androidx.core.graphics.b bVar) {
        this.f1675a.q(bVar);
    }

    void r(@Nullable WindowInsetsCompat windowInsetsCompat) {
        this.f1675a.r(windowInsetsCompat);
    }

    void s(@Nullable androidx.core.graphics.b bVar) {
        this.f1675a.s(bVar);
    }

    @Nullable
    @RequiresApi(20)
    public WindowInsets t() {
        l lVar = this.f1675a;
        if (lVar instanceof g) {
            return ((g) lVar).f1695c;
        }
        return null;
    }

    @RequiresApi(api = 20)
    private static class c extends f {

        /* renamed from: e, reason: collision with root package name */
        private static Field f1681e = null;

        /* renamed from: f, reason: collision with root package name */
        private static boolean f1682f = false;

        /* renamed from: g, reason: collision with root package name */
        private static Constructor<WindowInsets> f1683g = null;

        /* renamed from: h, reason: collision with root package name */
        private static boolean f1684h = false;

        /* renamed from: c, reason: collision with root package name */
        private WindowInsets f1685c;

        /* renamed from: d, reason: collision with root package name */
        private androidx.core.graphics.b f1686d;

        c() {
            this.f1685c = h();
        }

        @Nullable
        private static WindowInsets h() {
            if (!f1682f) {
                try {
                    f1681e = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e2) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e2);
                }
                f1682f = true;
            }
            Field field = f1681e;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get(null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException e3) {
                    Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e3);
                }
            }
            if (!f1684h) {
                try {
                    f1683g = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException e4) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e4);
                }
                f1684h = true;
            }
            Constructor<WindowInsets> constructor = f1683g;
            if (constructor != null) {
                try {
                    return constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException e5) {
                    Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e5);
                }
            }
            return null;
        }

        @Override // androidx.core.view.WindowInsetsCompat.f
        @NonNull
        WindowInsetsCompat b() {
            a();
            WindowInsetsCompat windowInsetsCompatU = WindowInsetsCompat.u(this.f1685c);
            windowInsetsCompatU.p(this.f1689b);
            windowInsetsCompatU.s(this.f1686d);
            return windowInsetsCompatU;
        }

        @Override // androidx.core.view.WindowInsetsCompat.f
        void d(@Nullable androidx.core.graphics.b bVar) {
            this.f1686d = bVar;
        }

        @Override // androidx.core.view.WindowInsetsCompat.f
        void f(@NonNull androidx.core.graphics.b bVar) {
            WindowInsets windowInsets = this.f1685c;
            if (windowInsets != null) {
                this.f1685c = windowInsets.replaceSystemWindowInsets(bVar.f1493a, bVar.f1494b, bVar.f1495c, bVar.f1496d);
            }
        }

        c(@NonNull WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
            this.f1685c = windowInsetsCompat.t();
        }
    }

    @RequiresApi(api = 29)
    private static class d extends f {

        /* renamed from: c, reason: collision with root package name */
        final WindowInsets.Builder f1687c;

        d() {
            this.f1687c = new WindowInsets.Builder();
        }

        @Override // androidx.core.view.WindowInsetsCompat.f
        @NonNull
        WindowInsetsCompat b() {
            a();
            WindowInsetsCompat windowInsetsCompatU = WindowInsetsCompat.u(this.f1687c.build());
            windowInsetsCompatU.p(this.f1689b);
            return windowInsetsCompatU;
        }

        @Override // androidx.core.view.WindowInsetsCompat.f
        void c(@NonNull androidx.core.graphics.b bVar) {
            this.f1687c.setMandatorySystemGestureInsets(bVar.e());
        }

        @Override // androidx.core.view.WindowInsetsCompat.f
        void d(@NonNull androidx.core.graphics.b bVar) {
            this.f1687c.setStableInsets(bVar.e());
        }

        @Override // androidx.core.view.WindowInsetsCompat.f
        void e(@NonNull androidx.core.graphics.b bVar) {
            this.f1687c.setSystemGestureInsets(bVar.e());
        }

        @Override // androidx.core.view.WindowInsetsCompat.f
        void f(@NonNull androidx.core.graphics.b bVar) {
            this.f1687c.setSystemWindowInsets(bVar.e());
        }

        @Override // androidx.core.view.WindowInsetsCompat.f
        void g(@NonNull androidx.core.graphics.b bVar) {
            this.f1687c.setTappableElementInsets(bVar.e());
        }

        d(@NonNull WindowInsetsCompat windowInsetsCompat) {
            WindowInsets.Builder builder;
            super(windowInsetsCompat);
            WindowInsets windowInsetsT = windowInsetsCompat.t();
            if (windowInsetsT != null) {
                builder = new WindowInsets.Builder(windowInsetsT);
            } else {
                builder = new WindowInsets.Builder();
            }
            this.f1687c = builder;
        }
    }

    @RequiresApi(21)
    private static class h extends g {

        /* renamed from: m, reason: collision with root package name */
        private androidx.core.graphics.b f1700m;

        h(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
            this.f1700m = null;
        }

        @Override // androidx.core.view.WindowInsetsCompat.l
        @NonNull
        WindowInsetsCompat b() {
            return WindowInsetsCompat.u(this.f1695c.consumeStableInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.l
        @NonNull
        WindowInsetsCompat c() {
            return WindowInsetsCompat.u(this.f1695c.consumeSystemWindowInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.l
        @NonNull
        final androidx.core.graphics.b i() {
            if (this.f1700m == null) {
                this.f1700m = androidx.core.graphics.b.b(this.f1695c.getStableInsetLeft(), this.f1695c.getStableInsetTop(), this.f1695c.getStableInsetRight(), this.f1695c.getStableInsetBottom());
            }
            return this.f1700m;
        }

        @Override // androidx.core.view.WindowInsetsCompat.l
        boolean n() {
            return this.f1695c.isConsumed();
        }

        @Override // androidx.core.view.WindowInsetsCompat.l
        public void s(@Nullable androidx.core.graphics.b bVar) {
            this.f1700m = bVar;
        }

        h(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull h hVar) {
            super(windowInsetsCompat, hVar);
            this.f1700m = null;
            this.f1700m = hVar.f1700m;
        }
    }

    @RequiresApi(20)
    private static class g extends l {

        /* renamed from: h, reason: collision with root package name */
        private static boolean f1690h = false;

        /* renamed from: i, reason: collision with root package name */
        private static Method f1691i;

        /* renamed from: j, reason: collision with root package name */
        private static Class<?> f1692j;

        /* renamed from: k, reason: collision with root package name */
        private static Field f1693k;

        /* renamed from: l, reason: collision with root package name */
        private static Field f1694l;

        /* renamed from: c, reason: collision with root package name */
        @NonNull
        final WindowInsets f1695c;

        /* renamed from: d, reason: collision with root package name */
        private androidx.core.graphics.b[] f1696d;

        /* renamed from: e, reason: collision with root package name */
        private androidx.core.graphics.b f1697e;

        /* renamed from: f, reason: collision with root package name */
        private WindowInsetsCompat f1698f;

        /* renamed from: g, reason: collision with root package name */
        androidx.core.graphics.b f1699g;

        g(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat);
            this.f1697e = null;
            this.f1695c = windowInsets;
        }

        @NonNull
        @SuppressLint({"WrongConstant"})
        private androidx.core.graphics.b t(int i2, boolean z2) {
            androidx.core.graphics.b bVarA = androidx.core.graphics.b.f1492e;
            for (int i3 = 1; i3 <= 256; i3 <<= 1) {
                if ((i2 & i3) != 0) {
                    bVarA = androidx.core.graphics.b.a(bVarA, u(i3, z2));
                }
            }
            return bVarA;
        }

        private androidx.core.graphics.b v() {
            WindowInsetsCompat windowInsetsCompat = this.f1698f;
            return windowInsetsCompat != null ? windowInsetsCompat.g() : androidx.core.graphics.b.f1492e;
        }

        @Nullable
        private androidx.core.graphics.b w(@NonNull View view) throws IllegalAccessException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
            if (Build.VERSION.SDK_INT >= 30) {
                throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
            }
            if (!f1690h) {
                x();
            }
            Method method = f1691i;
            if (method != null && f1692j != null && f1693k != null) {
                try {
                    Object objInvoke = method.invoke(view, new Object[0]);
                    if (objInvoke == null) {
                        Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                        return null;
                    }
                    Rect rect = (Rect) f1693k.get(f1694l.get(objInvoke));
                    if (rect != null) {
                        return androidx.core.graphics.b.c(rect);
                    }
                    return null;
                } catch (ReflectiveOperationException e2) {
                    Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e2.getMessage(), e2);
                }
            }
            return null;
        }

        @SuppressLint({"PrivateApi"})
        private static void x() throws ClassNotFoundException, SecurityException {
            try {
                f1691i = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                f1692j = cls;
                f1693k = cls.getDeclaredField("mVisibleInsets");
                f1694l = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                f1693k.setAccessible(true);
                f1694l.setAccessible(true);
            } catch (ReflectiveOperationException e2) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e2.getMessage(), e2);
            }
            f1690h = true;
        }

        @Override // androidx.core.view.WindowInsetsCompat.l
        void d(@NonNull View view) throws IllegalAccessException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
            androidx.core.graphics.b bVarW = w(view);
            if (bVarW == null) {
                bVarW = androidx.core.graphics.b.f1492e;
            }
            q(bVarW);
        }

        @Override // androidx.core.view.WindowInsetsCompat.l
        void e(@NonNull WindowInsetsCompat windowInsetsCompat) {
            windowInsetsCompat.r(this.f1698f);
            windowInsetsCompat.q(this.f1699g);
        }

        @Override // androidx.core.view.WindowInsetsCompat.l
        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return Objects.equals(this.f1699g, ((g) obj).f1699g);
            }
            return false;
        }

        @Override // androidx.core.view.WindowInsetsCompat.l
        @NonNull
        public androidx.core.graphics.b g(int i2) {
            return t(i2, false);
        }

        @Override // androidx.core.view.WindowInsetsCompat.l
        @NonNull
        final androidx.core.graphics.b k() {
            if (this.f1697e == null) {
                this.f1697e = androidx.core.graphics.b.b(this.f1695c.getSystemWindowInsetLeft(), this.f1695c.getSystemWindowInsetTop(), this.f1695c.getSystemWindowInsetRight(), this.f1695c.getSystemWindowInsetBottom());
            }
            return this.f1697e;
        }

        @Override // androidx.core.view.WindowInsetsCompat.l
        @NonNull
        WindowInsetsCompat m(int i2, int i3, int i4, int i5) {
            b bVar = new b(WindowInsetsCompat.u(this.f1695c));
            bVar.c(WindowInsetsCompat.m(k(), i2, i3, i4, i5));
            bVar.b(WindowInsetsCompat.m(i(), i2, i3, i4, i5));
            return bVar.a();
        }

        @Override // androidx.core.view.WindowInsetsCompat.l
        boolean o() {
            return this.f1695c.isRound();
        }

        @Override // androidx.core.view.WindowInsetsCompat.l
        public void p(androidx.core.graphics.b[] bVarArr) {
            this.f1696d = bVarArr;
        }

        @Override // androidx.core.view.WindowInsetsCompat.l
        void q(@NonNull androidx.core.graphics.b bVar) {
            this.f1699g = bVar;
        }

        @Override // androidx.core.view.WindowInsetsCompat.l
        void r(@Nullable WindowInsetsCompat windowInsetsCompat) {
            this.f1698f = windowInsetsCompat;
        }

        @NonNull
        protected androidx.core.graphics.b u(int i2, boolean z2) {
            androidx.core.graphics.b bVarG;
            int i3;
            if (i2 == 1) {
                return z2 ? androidx.core.graphics.b.b(0, Math.max(v().f1494b, k().f1494b), 0, 0) : androidx.core.graphics.b.b(0, k().f1494b, 0, 0);
            }
            if (i2 == 2) {
                if (z2) {
                    androidx.core.graphics.b bVarV = v();
                    androidx.core.graphics.b bVarI = i();
                    return androidx.core.graphics.b.b(Math.max(bVarV.f1493a, bVarI.f1493a), 0, Math.max(bVarV.f1495c, bVarI.f1495c), Math.max(bVarV.f1496d, bVarI.f1496d));
                }
                androidx.core.graphics.b bVarK = k();
                WindowInsetsCompat windowInsetsCompat = this.f1698f;
                bVarG = windowInsetsCompat != null ? windowInsetsCompat.g() : null;
                int iMin = bVarK.f1496d;
                if (bVarG != null) {
                    iMin = Math.min(iMin, bVarG.f1496d);
                }
                return androidx.core.graphics.b.b(bVarK.f1493a, 0, bVarK.f1495c, iMin);
            }
            if (i2 != 8) {
                if (i2 == 16) {
                    return j();
                }
                if (i2 == 32) {
                    return h();
                }
                if (i2 == 64) {
                    return l();
                }
                if (i2 != 128) {
                    return androidx.core.graphics.b.f1492e;
                }
                WindowInsetsCompat windowInsetsCompat2 = this.f1698f;
                androidx.core.view.c cVarE = windowInsetsCompat2 != null ? windowInsetsCompat2.e() : f();
                return cVarE != null ? androidx.core.graphics.b.b(cVarE.b(), cVarE.d(), cVarE.c(), cVarE.a()) : androidx.core.graphics.b.f1492e;
            }
            androidx.core.graphics.b[] bVarArr = this.f1696d;
            bVarG = bVarArr != null ? bVarArr[Type.a(8)] : null;
            if (bVarG != null) {
                return bVarG;
            }
            androidx.core.graphics.b bVarK2 = k();
            androidx.core.graphics.b bVarV2 = v();
            int i4 = bVarK2.f1496d;
            if (i4 > bVarV2.f1496d) {
                return androidx.core.graphics.b.b(0, 0, 0, i4);
            }
            androidx.core.graphics.b bVar = this.f1699g;
            return (bVar == null || bVar.equals(androidx.core.graphics.b.f1492e) || (i3 = this.f1699g.f1496d) <= bVarV2.f1496d) ? androidx.core.graphics.b.f1492e : androidx.core.graphics.b.b(0, 0, 0, i3);
        }

        g(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull g gVar) {
            this(windowInsetsCompat, new WindowInsets(gVar.f1695c));
        }
    }

    @RequiresApi(29)
    private static class j extends i {

        /* renamed from: n, reason: collision with root package name */
        private androidx.core.graphics.b f1701n;

        /* renamed from: o, reason: collision with root package name */
        private androidx.core.graphics.b f1702o;

        /* renamed from: p, reason: collision with root package name */
        private androidx.core.graphics.b f1703p;

        j(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
            this.f1701n = null;
            this.f1702o = null;
            this.f1703p = null;
        }

        @Override // androidx.core.view.WindowInsetsCompat.l
        @NonNull
        androidx.core.graphics.b h() {
            if (this.f1702o == null) {
                this.f1702o = androidx.core.graphics.b.d(this.f1695c.getMandatorySystemGestureInsets());
            }
            return this.f1702o;
        }

        @Override // androidx.core.view.WindowInsetsCompat.l
        @NonNull
        androidx.core.graphics.b j() {
            if (this.f1701n == null) {
                this.f1701n = androidx.core.graphics.b.d(this.f1695c.getSystemGestureInsets());
            }
            return this.f1701n;
        }

        @Override // androidx.core.view.WindowInsetsCompat.l
        @NonNull
        androidx.core.graphics.b l() {
            if (this.f1703p == null) {
                this.f1703p = androidx.core.graphics.b.d(this.f1695c.getTappableElementInsets());
            }
            return this.f1703p;
        }

        @Override // androidx.core.view.WindowInsetsCompat.g, androidx.core.view.WindowInsetsCompat.l
        @NonNull
        WindowInsetsCompat m(int i2, int i3, int i4, int i5) {
            return WindowInsetsCompat.u(this.f1695c.inset(i2, i3, i4, i5));
        }

        @Override // androidx.core.view.WindowInsetsCompat.h, androidx.core.view.WindowInsetsCompat.l
        public void s(@Nullable androidx.core.graphics.b bVar) {
        }

        j(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull j jVar) {
            super(windowInsetsCompat, jVar);
            this.f1701n = null;
            this.f1702o = null;
            this.f1703p = null;
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final f f1680a;

        public b() {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 30) {
                this.f1680a = new e();
                return;
            }
            if (i2 >= 29) {
                this.f1680a = new d();
            } else if (i2 >= 20) {
                this.f1680a = new c();
            } else {
                this.f1680a = new f();
            }
        }

        @NonNull
        public WindowInsetsCompat a() {
            return this.f1680a.b();
        }

        @NonNull
        @Deprecated
        public b b(@NonNull androidx.core.graphics.b bVar) {
            this.f1680a.d(bVar);
            return this;
        }

        @NonNull
        @Deprecated
        public b c(@NonNull androidx.core.graphics.b bVar) {
            this.f1680a.f(bVar);
            return this;
        }

        public b(@NonNull WindowInsetsCompat windowInsetsCompat) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 30) {
                this.f1680a = new e(windowInsetsCompat);
                return;
            }
            if (i2 >= 29) {
                this.f1680a = new d(windowInsetsCompat);
            } else if (i2 >= 20) {
                this.f1680a = new c(windowInsetsCompat);
            } else {
                this.f1680a = new f(windowInsetsCompat);
            }
        }
    }

    public WindowInsetsCompat(@Nullable WindowInsetsCompat windowInsetsCompat) {
        if (windowInsetsCompat != null) {
            l lVar = windowInsetsCompat.f1675a;
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 30 && (lVar instanceof k)) {
                this.f1675a = new k(this, (k) lVar);
            } else if (i2 >= 29 && (lVar instanceof j)) {
                this.f1675a = new j(this, (j) lVar);
            } else if (i2 >= 28 && (lVar instanceof i)) {
                this.f1675a = new i(this, (i) lVar);
            } else if (i2 >= 21 && (lVar instanceof h)) {
                this.f1675a = new h(this, (h) lVar);
            } else if (i2 >= 20 && (lVar instanceof g)) {
                this.f1675a = new g(this, (g) lVar);
            } else {
                this.f1675a = new l(this);
            }
            lVar.e(this);
            return;
        }
        this.f1675a = new l(this);
    }
}
