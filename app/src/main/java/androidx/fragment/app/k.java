package androidx.fragment.app;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: FragmentLifecycleCallbacksDispatcher.java */
/* loaded from: classes.dex */
class k {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final CopyOnWriteArrayList<a> f2259a = new CopyOnWriteArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private final FragmentManager f2260b;

    /* compiled from: FragmentLifecycleCallbacksDispatcher.java */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        final boolean f2261a;
    }

    k(@NonNull FragmentManager fragmentManager) {
        this.f2260b = fragmentManager;
    }

    void a(@NonNull Fragment fragment, @Nullable Bundle bundle, boolean z2) {
        Fragment fragmentW0 = this.f2260b.w0();
        if (fragmentW0 != null) {
            fragmentW0.getParentFragmentManager().v0().a(fragment, bundle, true);
        }
        Iterator<a> it = this.f2259a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z2 || next.f2261a) {
                next.getClass();
                throw null;
            }
        }
    }

    void b(@NonNull Fragment fragment, boolean z2) {
        this.f2260b.t0().f();
        Fragment fragmentW0 = this.f2260b.w0();
        if (fragmentW0 != null) {
            fragmentW0.getParentFragmentManager().v0().b(fragment, true);
        }
        Iterator<a> it = this.f2259a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z2 || next.f2261a) {
                next.getClass();
                throw null;
            }
        }
    }

    void c(@NonNull Fragment fragment, @Nullable Bundle bundle, boolean z2) {
        Fragment fragmentW0 = this.f2260b.w0();
        if (fragmentW0 != null) {
            fragmentW0.getParentFragmentManager().v0().c(fragment, bundle, true);
        }
        Iterator<a> it = this.f2259a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z2 || next.f2261a) {
                next.getClass();
                throw null;
            }
        }
    }

    void d(@NonNull Fragment fragment, boolean z2) {
        Fragment fragmentW0 = this.f2260b.w0();
        if (fragmentW0 != null) {
            fragmentW0.getParentFragmentManager().v0().d(fragment, true);
        }
        Iterator<a> it = this.f2259a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z2 || next.f2261a) {
                next.getClass();
                throw null;
            }
        }
    }

    void e(@NonNull Fragment fragment, boolean z2) {
        Fragment fragmentW0 = this.f2260b.w0();
        if (fragmentW0 != null) {
            fragmentW0.getParentFragmentManager().v0().e(fragment, true);
        }
        Iterator<a> it = this.f2259a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z2 || next.f2261a) {
                next.getClass();
                throw null;
            }
        }
    }

    void f(@NonNull Fragment fragment, boolean z2) {
        Fragment fragmentW0 = this.f2260b.w0();
        if (fragmentW0 != null) {
            fragmentW0.getParentFragmentManager().v0().f(fragment, true);
        }
        Iterator<a> it = this.f2259a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z2 || next.f2261a) {
                next.getClass();
                throw null;
            }
        }
    }

    void g(@NonNull Fragment fragment, boolean z2) {
        this.f2260b.t0().f();
        Fragment fragmentW0 = this.f2260b.w0();
        if (fragmentW0 != null) {
            fragmentW0.getParentFragmentManager().v0().g(fragment, true);
        }
        Iterator<a> it = this.f2259a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z2 || next.f2261a) {
                next.getClass();
                throw null;
            }
        }
    }

    void h(@NonNull Fragment fragment, @Nullable Bundle bundle, boolean z2) {
        Fragment fragmentW0 = this.f2260b.w0();
        if (fragmentW0 != null) {
            fragmentW0.getParentFragmentManager().v0().h(fragment, bundle, true);
        }
        Iterator<a> it = this.f2259a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z2 || next.f2261a) {
                next.getClass();
                throw null;
            }
        }
    }

    void i(@NonNull Fragment fragment, boolean z2) {
        Fragment fragmentW0 = this.f2260b.w0();
        if (fragmentW0 != null) {
            fragmentW0.getParentFragmentManager().v0().i(fragment, true);
        }
        Iterator<a> it = this.f2259a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z2 || next.f2261a) {
                next.getClass();
                throw null;
            }
        }
    }

    void j(@NonNull Fragment fragment, @NonNull Bundle bundle, boolean z2) {
        Fragment fragmentW0 = this.f2260b.w0();
        if (fragmentW0 != null) {
            fragmentW0.getParentFragmentManager().v0().j(fragment, bundle, true);
        }
        Iterator<a> it = this.f2259a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z2 || next.f2261a) {
                next.getClass();
                throw null;
            }
        }
    }

    void k(@NonNull Fragment fragment, boolean z2) {
        Fragment fragmentW0 = this.f2260b.w0();
        if (fragmentW0 != null) {
            fragmentW0.getParentFragmentManager().v0().k(fragment, true);
        }
        Iterator<a> it = this.f2259a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z2 || next.f2261a) {
                next.getClass();
                throw null;
            }
        }
    }

    void l(@NonNull Fragment fragment, boolean z2) {
        Fragment fragmentW0 = this.f2260b.w0();
        if (fragmentW0 != null) {
            fragmentW0.getParentFragmentManager().v0().l(fragment, true);
        }
        Iterator<a> it = this.f2259a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z2 || next.f2261a) {
                next.getClass();
                throw null;
            }
        }
    }

    void m(@NonNull Fragment fragment, @NonNull View view, @Nullable Bundle bundle, boolean z2) {
        Fragment fragmentW0 = this.f2260b.w0();
        if (fragmentW0 != null) {
            fragmentW0.getParentFragmentManager().v0().m(fragment, view, bundle, true);
        }
        Iterator<a> it = this.f2259a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z2 || next.f2261a) {
                next.getClass();
                throw null;
            }
        }
    }

    void n(@NonNull Fragment fragment, boolean z2) {
        Fragment fragmentW0 = this.f2260b.w0();
        if (fragmentW0 != null) {
            fragmentW0.getParentFragmentManager().v0().n(fragment, true);
        }
        Iterator<a> it = this.f2259a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z2 || next.f2261a) {
                next.getClass();
                throw null;
            }
        }
    }
}
