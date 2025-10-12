package androidx.lifecycle;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;

/* loaded from: classes.dex */
class SingleGeneratedAdapterObserver implements k {

    /* renamed from: a, reason: collision with root package name */
    private final g f2424a;

    SingleGeneratedAdapterObserver(g gVar) {
        this.f2424a = gVar;
    }

    @Override // androidx.lifecycle.k
    public void d(@NonNull m mVar, @NonNull Lifecycle.Event event) {
        this.f2424a.a(mVar, event, false, null);
        this.f2424a.a(mVar, event, true, null);
    }
}
