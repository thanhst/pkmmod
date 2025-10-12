package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.i;
import kotlin.jvm.internal.s;
import kotlin.t;
import kotlinx.coroutines.internal.a0;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.k;
import kotlinx.coroutines.n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p0.l;

/* compiled from: Semaphore.kt */
@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001J\u0013\u0010\u0003\u001a\u00020\u0002H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\f\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\tJ\u0013\u0010\r\u001a\u00020\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0011R \u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lkotlinx/coroutines/sync/e;", "Lkotlinx/coroutines/sync/d;", "Lkotlin/t;", "d", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/k;", "cont", "", "e", "(Lkotlinx/coroutines/k;)Z", "g", "()Z", "f", "a", "release", "()V", "", "I", "permits", "Lkotlin/Function1;", "", "b", "Lp0/l;", "onCancellationRelease", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
final class e implements d {

    /* renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f3984c = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "head");

    /* renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f3985d = AtomicLongFieldUpdater.newUpdater(e.class, "deqIdx");

    /* renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f3986e = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "tail");

    /* renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f3987f = AtomicLongFieldUpdater.newUpdater(e.class, "enqIdx");

    /* renamed from: g, reason: collision with root package name */
    static final /* synthetic */ AtomicIntegerFieldUpdater f3988g = AtomicIntegerFieldUpdater.newUpdater(e.class, "_availablePermits");

    @NotNull
    volatile /* synthetic */ int _availablePermits;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int permits;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final l<Throwable, t> onCancellationRelease;

    @NotNull
    private volatile /* synthetic */ long deqIdx;

    @NotNull
    private volatile /* synthetic */ long enqIdx;

    @NotNull
    private volatile /* synthetic */ Object head;

    @NotNull
    private volatile /* synthetic */ Object tail;

    private final Object d(kotlin.coroutines.c<? super t> cVar) {
        kotlinx.coroutines.l lVarB = n.b(IntrinsicsKt__IntrinsicsJvmKt.c(cVar));
        while (true) {
            if (e(lVarB)) {
                break;
            }
            if (f3988g.getAndDecrement(this) > 0) {
                lVarB.H(t.f3507a, this.onCancellationRelease);
                break;
            }
        }
        Object objT = lVarB.t();
        if (objT == kotlin.coroutines.intrinsics.b.d()) {
            kotlin.coroutines.jvm.internal.e.c(cVar);
        }
        return objT == kotlin.coroutines.intrinsics.b.d() ? objT : t.f3507a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean e(k<? super t> cont) {
        Object objA;
        boolean z2;
        a0 a0Var = (f) this.tail;
        long andIncrement = f3987f.getAndIncrement(this);
        long j2 = andIncrement / SemaphoreKt.f3980f;
        do {
            a0 a0Var2 = a0Var;
            while (true) {
                if (a0Var2.getId() >= j2 && !a0Var2.g()) {
                    objA = b0.a(a0Var2);
                    break;
                }
                Object obj = a0Var2.get_next();
                if (obj == kotlinx.coroutines.internal.e.f3809a) {
                    objA = b0.a(kotlinx.coroutines.internal.e.f3809a);
                    break;
                }
                a0 a0VarH = (a0) ((kotlinx.coroutines.internal.f) obj);
                if (a0VarH == null) {
                    a0VarH = SemaphoreKt.h(a0Var2.getId() + 1, (f) a0Var2);
                    if (a0Var2.k(a0VarH)) {
                        if (a0Var2.g()) {
                            a0Var2.j();
                        }
                    }
                }
                a0Var2 = a0VarH;
            }
            if (b0.c(objA)) {
                break;
            }
            a0 a0VarB = b0.b(objA);
            while (true) {
                a0 a0Var3 = (a0) this.tail;
                if (a0Var3.getId() >= a0VarB.getId()) {
                    break;
                }
                if (!a0VarB.p()) {
                    z2 = false;
                    break;
                }
                if (i.a(f3986e, this, a0Var3, a0VarB)) {
                    if (a0Var3.l()) {
                        a0Var3.j();
                    }
                } else if (a0VarB.l()) {
                    a0VarB.j();
                }
            }
            z2 = true;
        } while (!z2);
        f fVar = (f) b0.b(objA);
        int i2 = (int) (andIncrement % SemaphoreKt.f3980f);
        if (kotlinx.coroutines.debug.internal.a.a(fVar.f3991e, i2, null, cont)) {
            cont.s(new a(fVar, i2));
            return true;
        }
        if (!kotlinx.coroutines.debug.internal.a.a(fVar.f3991e, i2, SemaphoreKt.f3976b, SemaphoreKt.f3977c)) {
            return false;
        }
        cont.H(t.f3507a, this.onCancellationRelease);
        return true;
    }

    private final boolean f(k<? super t> kVar) {
        Object objD = kVar.D(t.f3507a, null, this.onCancellationRelease);
        if (objD == null) {
            return false;
        }
        kVar.G(objD);
        return true;
    }

    private final boolean g() {
        Object objA;
        int i2;
        boolean z2;
        a0 a0Var = (f) this.head;
        long andIncrement = f3985d.getAndIncrement(this);
        long j2 = andIncrement / SemaphoreKt.f3980f;
        do {
            a0 a0Var2 = a0Var;
            while (true) {
                if (a0Var2.getId() >= j2 && !a0Var2.g()) {
                    objA = b0.a(a0Var2);
                    break;
                }
                Object obj = a0Var2.get_next();
                if (obj == kotlinx.coroutines.internal.e.f3809a) {
                    objA = b0.a(kotlinx.coroutines.internal.e.f3809a);
                    break;
                }
                a0 a0VarH = (a0) ((kotlinx.coroutines.internal.f) obj);
                if (a0VarH == null) {
                    a0VarH = SemaphoreKt.h(a0Var2.getId() + 1, (f) a0Var2);
                    if (a0Var2.k(a0VarH)) {
                        if (a0Var2.g()) {
                            a0Var2.j();
                        }
                    }
                }
                a0Var2 = a0VarH;
            }
            i2 = 0;
            if (b0.c(objA)) {
                break;
            }
            a0 a0VarB = b0.b(objA);
            while (true) {
                a0 a0Var3 = (a0) this.head;
                if (a0Var3.getId() >= a0VarB.getId()) {
                    break;
                }
                if (!a0VarB.p()) {
                    z2 = false;
                    break;
                }
                if (i.a(f3984c, this, a0Var3, a0VarB)) {
                    if (a0Var3.l()) {
                        a0Var3.j();
                    }
                } else if (a0VarB.l()) {
                    a0VarB.j();
                }
            }
            z2 = true;
        } while (!z2);
        f fVar = (f) b0.b(objA);
        fVar.b();
        if (fVar.getId() > j2) {
            return false;
        }
        int i3 = (int) (andIncrement % SemaphoreKt.f3980f);
        Object andSet = fVar.f3991e.getAndSet(i3, SemaphoreKt.f3976b);
        if (andSet != null) {
            if (andSet == SemaphoreKt.f3979e) {
                return false;
            }
            return f((k) andSet);
        }
        int i4 = SemaphoreKt.f3975a;
        while (i2 < i4) {
            i2++;
            if (fVar.f3991e.get(i3) == SemaphoreKt.f3977c) {
                return true;
            }
        }
        return !kotlinx.coroutines.debug.internal.a.a(fVar.f3991e, i3, SemaphoreKt.f3976b, SemaphoreKt.f3978d);
    }

    @Override // kotlinx.coroutines.sync.d
    @Nullable
    public Object a(@NotNull kotlin.coroutines.c<? super t> cVar) {
        if (f3988g.getAndDecrement(this) > 0) {
            return t.f3507a;
        }
        Object objD = d(cVar);
        return objD == kotlin.coroutines.intrinsics.b.d() ? objD : t.f3507a;
    }

    @Override // kotlinx.coroutines.sync.d
    public void release() {
        while (true) {
            int i2 = this._availablePermits;
            int i3 = this.permits;
            if (!(i2 < i3)) {
                throw new IllegalStateException(s.m("The number of released permits cannot be greater than ", Integer.valueOf(i3)).toString());
            }
            if (f3988g.compareAndSet(this, i2, i2 + 1) && (i2 >= 0 || g())) {
                return;
            }
        }
    }
}
