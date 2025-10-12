package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlinx.coroutines.internal.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConcurrentLinkedList.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\b \u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u00020\u0002B\u0011\u0012\b\u0010\u0019\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\tR\u0016\u0010\r\u001a\u0004\u0018\u00010\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u0004\u0018\u00018\u00008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00028\u00008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0014\u001a\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0017\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0019\u001a\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u000fR\u0014\u0010\u001b\u001a\u00020\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0016¨\u0006\u001e"}, d2 = {"Lkotlinx/coroutines/internal/f;", "N", "", "value", "", "k", "(Lkotlinx/coroutines/internal/f;)Z", "Lkotlin/t;", "b", "()V", "j", "e", "()Ljava/lang/Object;", "nextOrClosed", "c", "()Lkotlinx/coroutines/internal/f;", "leftmostAliveNode", "h", "rightmostAliveNode", "d", "next", "i", "()Z", "isTail", "f", "prev", "g", "removed", "<init>", "(Lkotlinx/coroutines/internal/f;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public abstract class f<N extends f<N>> {

    /* renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f3810a = AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, "_next");

    /* renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f3811b = AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, "_prev");

    @NotNull
    private volatile /* synthetic */ Object _next = null;

    @NotNull
    private volatile /* synthetic */ Object _prev;

    public f(@Nullable N n2) {
        this._prev = n2;
    }

    private final N c() {
        N n2 = (N) f();
        while (n2 != null && n2.g()) {
            n2 = (N) n2._prev;
        }
        return n2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e, reason: from getter */
    public final Object get_next() {
        return this._next;
    }

    private final N h() {
        N n2 = (N) d();
        kotlin.jvm.internal.s.b(n2);
        while (n2.g()) {
            n2 = (N) n2.d();
            kotlin.jvm.internal.s.b(n2);
        }
        return n2;
    }

    public final void b() {
        f3811b.lazySet(this, null);
    }

    @Nullable
    public final N d() {
        Object obj = get_next();
        if (obj == e.f3809a) {
            return null;
        }
        return (N) obj;
    }

    @Nullable
    public final N f() {
        return (N) this._prev;
    }

    public abstract boolean g();

    public final boolean i() {
        return d() == null;
    }

    public final void j() {
        while (true) {
            f fVarC = c();
            f fVarH = h();
            fVarH._prev = fVarC;
            if (fVarC != null) {
                fVarC._next = fVarH;
            }
            if (!fVarH.g() && (fVarC == null || !fVarC.g())) {
                return;
            }
        }
    }

    public final boolean k(@NotNull N value) {
        return kotlin.i.a(f3810a, this, null, value);
    }
}
