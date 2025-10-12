package androidx.lifecycle;

import android.view.C0077b;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;

/* loaded from: classes.dex */
final class SavedStateHandleController implements k {

    /* renamed from: a, reason: collision with root package name */
    private final String f2414a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f2415b = false;

    /* renamed from: c, reason: collision with root package name */
    private final w f2416c;

    SavedStateHandleController(String str, w wVar) {
        this.f2414a = str;
        this.f2416c = wVar;
    }

    @Override // androidx.lifecycle.k
    public void d(@NonNull m mVar, @NonNull Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.f2415b = false;
            mVar.getLifecycle().c(this);
        }
    }

    void h(C0077b c0077b, Lifecycle lifecycle) {
        if (this.f2415b) {
            throw new IllegalStateException("Already attached to lifecycleOwner");
        }
        this.f2415b = true;
        lifecycle.a(this);
        c0077b.h(this.f2414a, this.f2416c.getSavedStateProvider());
    }

    w i() {
        return this.f2416c;
    }

    boolean j() {
        return this.f2415b;
    }
}
