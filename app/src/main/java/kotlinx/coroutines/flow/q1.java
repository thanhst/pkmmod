package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import org.jetbrains.annotations.NotNull;

/* compiled from: StateFlow.kt */
@Metadata(bv = {}, d1 = {"\u00000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a6\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0000\"\u001a\u0010\u0012\u001a\u00020\u000e8\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u0012\u0004\b\u0010\u0010\u0011\"\u001a\u0010\u0015\u001a\u00020\u000e8\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u000f\u0012\u0004\b\u0014\u0010\u0011¨\u0006\u0016"}, d2 = {"T", "value", "Lkotlinx/coroutines/flow/g1;", "a", "(Ljava/lang/Object;)Lkotlinx/coroutines/flow/g1;", "Lkotlinx/coroutines/flow/p1;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/d;", "d", "Lkotlinx/coroutines/internal/d0;", "Lkotlinx/coroutines/internal/d0;", "getNONE$annotations", "()V", "NONE", "b", "getPENDING$annotations", "PENDING", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class q1 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final kotlinx.coroutines.internal.d0 f3775a = new kotlinx.coroutines.internal.d0("NONE");

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final kotlinx.coroutines.internal.d0 f3776b = new kotlinx.coroutines.internal.d0("PENDING");

    @NotNull
    public static final <T> g1<T> a(T t2) {
        if (t2 == null) {
            t2 = (T) kotlinx.coroutines.flow.internal.n.f3761a;
        }
        return new StateFlowImpl(t2);
    }

    @NotNull
    public static final <T> d<T> d(@NotNull p1<? extends T> p1Var, @NotNull CoroutineContext coroutineContext, int i2, @NotNull BufferOverflow bufferOverflow) {
        boolean z2 = false;
        if (i2 >= 0 && i2 < 2) {
            z2 = true;
        }
        return ((z2 || i2 == -2) && bufferOverflow == BufferOverflow.DROP_OLDEST) ? p1Var : k1.c(p1Var, coroutineContext, i2, bufferOverflow);
    }
}
