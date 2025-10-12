package androidx.fragment.app;

import android.view.ViewGroup;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* compiled from: FragmentTransaction.java */
/* loaded from: classes.dex */
public abstract class r {

    /* renamed from: a, reason: collision with root package name */
    private final h f2281a;

    /* renamed from: b, reason: collision with root package name */
    private final ClassLoader f2282b;

    /* renamed from: d, reason: collision with root package name */
    int f2284d;

    /* renamed from: e, reason: collision with root package name */
    int f2285e;

    /* renamed from: f, reason: collision with root package name */
    int f2286f;

    /* renamed from: g, reason: collision with root package name */
    int f2287g;

    /* renamed from: h, reason: collision with root package name */
    int f2288h;

    /* renamed from: i, reason: collision with root package name */
    boolean f2289i;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    String f2291k;

    /* renamed from: l, reason: collision with root package name */
    int f2292l;

    /* renamed from: m, reason: collision with root package name */
    CharSequence f2293m;

    /* renamed from: n, reason: collision with root package name */
    int f2294n;

    /* renamed from: o, reason: collision with root package name */
    CharSequence f2295o;

    /* renamed from: p, reason: collision with root package name */
    ArrayList<String> f2296p;

    /* renamed from: q, reason: collision with root package name */
    ArrayList<String> f2297q;

    /* renamed from: s, reason: collision with root package name */
    ArrayList<Runnable> f2299s;

    /* renamed from: c, reason: collision with root package name */
    ArrayList<a> f2283c = new ArrayList<>();

    /* renamed from: j, reason: collision with root package name */
    boolean f2290j = true;

    /* renamed from: r, reason: collision with root package name */
    boolean f2298r = false;

    /* compiled from: FragmentTransaction.java */
    static final class a {

        /* renamed from: a, reason: collision with root package name */
        int f2300a;

        /* renamed from: b, reason: collision with root package name */
        Fragment f2301b;

        /* renamed from: c, reason: collision with root package name */
        int f2302c;

        /* renamed from: d, reason: collision with root package name */
        int f2303d;

        /* renamed from: e, reason: collision with root package name */
        int f2304e;

        /* renamed from: f, reason: collision with root package name */
        int f2305f;

        /* renamed from: g, reason: collision with root package name */
        Lifecycle.State f2306g;

        /* renamed from: h, reason: collision with root package name */
        Lifecycle.State f2307h;

        a() {
        }

        a(int i2, Fragment fragment) {
            this.f2300a = i2;
            this.f2301b = fragment;
            Lifecycle.State state = Lifecycle.State.RESUMED;
            this.f2306g = state;
            this.f2307h = state;
        }
    }

    r(@NonNull h hVar, @Nullable ClassLoader classLoader) {
        this.f2281a = hVar;
        this.f2282b = classLoader;
    }

    @NonNull
    public r b(@IdRes int i2, @NonNull Fragment fragment, @Nullable String str) {
        k(i2, fragment, str, 1);
        return this;
    }

    r c(@NonNull ViewGroup viewGroup, @NonNull Fragment fragment, @Nullable String str) {
        fragment.mContainer = viewGroup;
        return b(viewGroup.getId(), fragment, str);
    }

    @NonNull
    public r d(@NonNull Fragment fragment, @Nullable String str) {
        k(0, fragment, str, 1);
        return this;
    }

    void e(a aVar) {
        this.f2283c.add(aVar);
        aVar.f2302c = this.f2284d;
        aVar.f2303d = this.f2285e;
        aVar.f2304e = this.f2286f;
        aVar.f2305f = this.f2287g;
    }

    public abstract int f();

    public abstract int g();

    public abstract void h();

    public abstract void i();

    @NonNull
    public r j() {
        if (this.f2289i) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.f2290j = false;
        return this;
    }

    void k(int i2, Fragment fragment, @Nullable String str, int i3) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str2 = fragment.mTag;
            if (str2 != null && !str.equals(str2)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
            fragment.mTag = str;
        }
        if (i2 != 0) {
            if (i2 == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
            int i4 = fragment.mFragmentId;
            if (i4 != 0 && i4 != i2) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i2);
            }
            fragment.mFragmentId = i2;
            fragment.mContainerId = i2;
        }
        e(new a(i3, fragment));
    }

    @NonNull
    public r l(@NonNull Fragment fragment) {
        e(new a(3, fragment));
        return this;
    }

    @NonNull
    public r m(boolean z2) {
        this.f2298r = z2;
        return this;
    }
}
