package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: EventLoop.common.kt */
@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0012\u0010\n\u001a\u00020\t2\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007J\u0010\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\u0003\u001a\u00020\u0002J\b\u0010\r\u001a\u00020\tH\u0016R\u0016\u0010\u0010\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\"\u0010\u0017\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00048TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001d\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001f\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001c¨\u0006\""}, d2 = {"Lkotlinx/coroutines/u0;", "Lkotlinx/coroutines/CoroutineDispatcher;", "", "unconfined", "", "s", "E", "Lkotlinx/coroutines/n0;", "task", "Lkotlin/t;", "v", "y", "q", "shutdown", "f", "J", "useCount", "g", "Z", "shared", "Lkotlinx/coroutines/internal/a;", "h", "Lkotlinx/coroutines/internal/a;", "unconfinedQueue", "x", "()J", "nextTime", "B", "()Z", "isUnconfinedLoopActive", "D", "isUnconfinedQueueEmpty", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public abstract class u0 extends CoroutineDispatcher {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long useCount;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean shared;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private kotlinx.coroutines.internal.a<n0<?>> unconfinedQueue;

    private final long s(boolean unconfined) {
        return unconfined ? 4294967296L : 1L;
    }

    public static /* synthetic */ void z(u0 u0Var, boolean z2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
        }
        if ((i2 & 1) != 0) {
            z2 = false;
        }
        u0Var.y(z2);
    }

    public final boolean B() {
        return this.useCount >= s(true);
    }

    public final boolean D() {
        kotlinx.coroutines.internal.a<n0<?>> aVar = this.unconfinedQueue;
        if (aVar == null) {
            return true;
        }
        return aVar.c();
    }

    public final boolean E() {
        n0<?> n0VarD;
        kotlinx.coroutines.internal.a<n0<?>> aVar = this.unconfinedQueue;
        if (aVar == null || (n0VarD = aVar.d()) == null) {
            return false;
        }
        n0VarD.run();
        return true;
    }

    public final void q(boolean z2) {
        long jS = this.useCount - s(z2);
        this.useCount = jS;
        if (jS <= 0 && this.shared) {
            shutdown();
        }
    }

    public void shutdown() {
    }

    public final void v(@NotNull n0<?> n0Var) {
        kotlinx.coroutines.internal.a<n0<?>> aVar = this.unconfinedQueue;
        if (aVar == null) {
            aVar = new kotlinx.coroutines.internal.a<>();
            this.unconfinedQueue = aVar;
        }
        aVar.a(n0Var);
    }

    protected long x() {
        kotlinx.coroutines.internal.a<n0<?>> aVar = this.unconfinedQueue;
        return (aVar == null || aVar.c()) ? Long.MAX_VALUE : 0L;
    }

    public final void y(boolean z2) {
        this.useCount += s(z2);
        if (z2) {
            return;
        }
        this.shared = true;
    }
}
