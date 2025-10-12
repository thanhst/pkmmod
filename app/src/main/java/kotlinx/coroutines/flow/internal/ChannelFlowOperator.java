package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.d;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.s;
import kotlin.t;
import kotlinx.coroutines.channels.BufferOverflow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChannelFlow.kt */
@Metadata(bv = {}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003B-\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0006\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ)\u0010\t\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0082@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000b\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004H¤@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000f\u001a\u00020\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\rH\u0094@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0011\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\fJ\b\u0010\u0013\u001a\u00020\u0012H\u0016R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00148\u0004X\u0085\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Lkotlinx/coroutines/flow/internal/ChannelFlowOperator;", "S", "T", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "Lkotlinx/coroutines/flow/e;", "collector", "Lkotlin/coroutines/CoroutineContext;", "newContext", "Lkotlin/t;", "o", "(Lkotlinx/coroutines/flow/e;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/c;)Ljava/lang/Object;", "p", "(Lkotlinx/coroutines/flow/e;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/n;", "scope", "h", "(Lkotlinx/coroutines/channels/n;Lkotlin/coroutines/c;)Ljava/lang/Object;", "a", "", "toString", "Lkotlinx/coroutines/flow/d;", "Lkotlinx/coroutines/flow/d;", "flow", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "<init>", "(Lkotlinx/coroutines/flow/d;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public abstract class ChannelFlowOperator<S, T> extends ChannelFlow<T> {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    protected final kotlinx.coroutines.flow.d<S> flow;

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowOperator(@NotNull kotlinx.coroutines.flow.d<? extends S> dVar, @NotNull CoroutineContext coroutineContext, int i2, @NotNull BufferOverflow bufferOverflow) {
        super(coroutineContext, i2, bufferOverflow);
        this.flow = dVar;
    }

    static /* synthetic */ Object m(ChannelFlowOperator channelFlowOperator, kotlinx.coroutines.flow.e eVar, kotlin.coroutines.c cVar) {
        if (channelFlowOperator.capacity == -3) {
            CoroutineContext context = cVar.getContext();
            CoroutineContext coroutineContextPlus = context.plus(channelFlowOperator.context);
            if (s.a(coroutineContextPlus, context)) {
                Object objP = channelFlowOperator.p(eVar, cVar);
                return objP == kotlin.coroutines.intrinsics.b.d() ? objP : t.f3507a;
            }
            d.Companion companion = kotlin.coroutines.d.INSTANCE;
            if (s.a(coroutineContextPlus.get(companion), context.get(companion))) {
                Object objO = channelFlowOperator.o(eVar, coroutineContextPlus, cVar);
                return objO == kotlin.coroutines.intrinsics.b.d() ? objO : t.f3507a;
            }
        }
        Object objA = super.a(eVar, cVar);
        return objA == kotlin.coroutines.intrinsics.b.d() ? objA : t.f3507a;
    }

    static /* synthetic */ Object n(ChannelFlowOperator channelFlowOperator, kotlinx.coroutines.channels.n nVar, kotlin.coroutines.c cVar) {
        Object objP = channelFlowOperator.p(new p(nVar), cVar);
        return objP == kotlin.coroutines.intrinsics.b.d() ? objP : t.f3507a;
    }

    private final Object o(kotlinx.coroutines.flow.e<? super T> eVar, CoroutineContext coroutineContext, kotlin.coroutines.c<? super t> cVar) {
        Object objC = d.c(coroutineContext, d.d(eVar, cVar.getContext()), null, new ChannelFlowOperator$collectWithContextUndispatched$2(this, null), cVar, 4, null);
        return objC == kotlin.coroutines.intrinsics.b.d() ? objC : t.f3507a;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow, kotlinx.coroutines.flow.d
    @Nullable
    public Object a(@NotNull kotlinx.coroutines.flow.e<? super T> eVar, @NotNull kotlin.coroutines.c<? super t> cVar) {
        return m(this, eVar, cVar);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @Nullable
    protected Object h(@NotNull kotlinx.coroutines.channels.n<? super T> nVar, @NotNull kotlin.coroutines.c<? super t> cVar) {
        return n(this, nVar, cVar);
    }

    @Nullable
    protected abstract Object p(@NotNull kotlinx.coroutines.flow.e<? super T> eVar, @NotNull kotlin.coroutines.c<? super t> cVar);

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @NotNull
    public String toString() {
        return this.flow + " -> " + super.toString();
    }
}
