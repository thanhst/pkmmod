package androidx.lifecycle;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;

/* loaded from: classes.dex */
class CompositeGeneratedAdaptersObserver implements k {

    /* renamed from: a, reason: collision with root package name */
    private final g[] f2381a;

    CompositeGeneratedAdaptersObserver(g[] gVarArr) {
        this.f2381a = gVarArr;
    }

    @Override // androidx.lifecycle.k
    public void d(@NonNull m mVar, @NonNull Lifecycle.Event event) {
        q qVar = new q();
        for (g gVar : this.f2381a) {
            gVar.a(mVar, event, false, qVar);
        }
        for (g gVar2 : this.f2381a) {
            gVar2.a(mVar, event, true, qVar);
        }
    }
}
