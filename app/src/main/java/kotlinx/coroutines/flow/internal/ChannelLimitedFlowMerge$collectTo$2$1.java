package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.t;
import kotlinx.coroutines.g0;
import p0.p_p0;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Merge.kt */
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {"T", "Lkotlinx/coroutines/g0;", "Lkotlin/t;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelLimitedFlowMerge$collectTo$2$1", f = "Merge.kt", i = {}, l = {96}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class ChannelLimitedFlowMerge$collectTo$2$1 extends SuspendLambda implements p_p0<g0, c<? super t>, Object> {
    final /* synthetic */ p<Object> $collector;
    final /* synthetic */ kotlinx.coroutines.flow.d<Object> $flow;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ChannelLimitedFlowMerge$collectTo$2$1(kotlinx.coroutines.flow.d<Object> dVar, p<Object> pVar, kotlin.coroutines.c<? super ChannelLimitedFlowMerge$collectTo$2$1> cVar) {
        super(2, cVar);
        this.$flow = dVar;
        this.$collector = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final kotlin.coroutines.c<t> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
        return new ChannelLimitedFlowMerge$collectTo$2$1(this.$flow, this.$collector, cVar);
    }

    @Override // p0.p
    @Nullable
    public final Object invoke(@NotNull g0 g0Var, @Nullable kotlin.coroutines.c<? super t> cVar) {
        return ((ChannelLimitedFlowMerge$collectTo$2$1) create(g0Var, cVar)).invokeSuspend(t.f3507a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objD = kotlin.coroutines.intrinsics.b.d();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.h.b(obj);
            kotlinx.coroutines.flow.d<Object> dVar = this.$flow;
            p<Object> pVar = this.$collector;
            this.label = 1;
            if (dVar.a(pVar, this) == objD) {
                return objD;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.h.b(obj);
        }
        return t.f3507a;
    }
}
