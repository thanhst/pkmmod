package androidx.fragment.app;

import android.os.Bundle;
import android.view.C0077b;
import android.view.C0078c;
import android.view.InterfaceC0079d;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.e0;
import androidx.lifecycle.f0;

/* compiled from: FragmentViewLifecycleOwner.java */
/* loaded from: classes.dex */
class a0 implements androidx.lifecycle.i, InterfaceC0079d, f0 {

    /* renamed from: e, reason: collision with root package name */
    private final Fragment f2173e;

    /* renamed from: f, reason: collision with root package name */
    private final e0 f2174f;

    /* renamed from: g, reason: collision with root package name */
    private androidx.lifecycle.n f2175g = null;

    /* renamed from: h, reason: collision with root package name */
    private C0078c f2176h = null;

    a0(@NonNull Fragment fragment, @NonNull e0 e0Var) {
        this.f2173e = fragment;
        this.f2174f = e0Var;
    }

    void a(@NonNull Lifecycle.Event event) {
        this.f2175g.h(event);
    }

    void b() {
        if (this.f2175g == null) {
            this.f2175g = new androidx.lifecycle.n(this);
            this.f2176h = C0078c.a(this);
        }
    }

    boolean c() {
        return this.f2175g != null;
    }

    void d(@Nullable Bundle bundle) {
        this.f2176h.d(bundle);
    }

    void e(@NonNull Bundle bundle) {
        this.f2176h.e(bundle);
    }

    void f(@NonNull Lifecycle.State state) {
        this.f2175g.o(state);
    }

    @Override // androidx.lifecycle.i
    public /* synthetic */ s.a getDefaultViewModelCreationExtras() {
        return androidx.lifecycle.h.a(this);
    }

    @Override // androidx.lifecycle.m
    @NonNull
    public Lifecycle getLifecycle() {
        b();
        return this.f2175g;
    }

    @Override // android.view.InterfaceC0079d
    @NonNull
    public C0077b getSavedStateRegistry() {
        b();
        return this.f2176h.getSavedStateRegistry();
    }

    @Override // androidx.lifecycle.f0
    @NonNull
    public e0 getViewModelStore() {
        b();
        return this.f2174f;
    }
}
