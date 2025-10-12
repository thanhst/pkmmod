package androidx.lifecycle;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;

/* loaded from: classes.dex */
class FullLifecycleObserverAdapter implements k {

    /* renamed from: a, reason: collision with root package name */
    private final f f2382a;

    /* renamed from: b, reason: collision with root package name */
    private final k f2383b;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2384a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            f2384a = iArr;
            try {
                iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2384a[Lifecycle.Event.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2384a[Lifecycle.Event.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2384a[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2384a[Lifecycle.Event.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2384a[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2384a[Lifecycle.Event.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    FullLifecycleObserverAdapter(f fVar, k kVar) {
        this.f2382a = fVar;
        this.f2383b = kVar;
    }

    @Override // androidx.lifecycle.k
    public void d(@NonNull m mVar, @NonNull Lifecycle.Event event) {
        switch (a.f2384a[event.ordinal()]) {
            case 1:
                this.f2382a.c(mVar);
                break;
            case 2:
                this.f2382a.f(mVar);
                break;
            case 3:
                this.f2382a.a(mVar);
                break;
            case 4:
                this.f2382a.e(mVar);
                break;
            case 5:
                this.f2382a.g(mVar);
                break;
            case 6:
                this.f2382a.b(mVar);
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        k kVar = this.f2383b;
        if (kVar != null) {
            kVar.d(mVar, event);
        }
    }
}
