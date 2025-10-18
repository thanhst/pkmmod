package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.t;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.g0;
import p0.p_p0;
import p0.q_p0;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FlowCoroutine.kt */
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {"R", "Lkotlinx/coroutines/g0;", "Lkotlin/t;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.FlowCoroutineKt$scopedFlow$1$1", f = "FlowCoroutine.kt", i = {}, l = {51}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class FlowCoroutineKt$scopedFlow$1$1 extends SuspendLambda implements p_p0<g0, c<? super t>, Object> {
    final /* synthetic */ q_p0<g0, e<Object>, c<? super t>, Object> $block;
    final /* synthetic */ kotlinx.coroutines.flow.e<Object> $this_unsafeFlow;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    FlowCoroutineKt$scopedFlow$1$1(q_p0<? super g0, ? super e<Object>, ? super c<? super t>, ? extends Object> qP0Var, kotlinx.coroutines.flow.e<Object> eVar, kotlin.coroutines.c<? super FlowCoroutineKt$scopedFlow$1$1> cVar) {
        super(2, cVar);
        this.$block = qP0Var;
        this.$this_unsafeFlow = eVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final kotlin.coroutines.c<t> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
        FlowCoroutineKt$scopedFlow$1$1 flowCoroutineKt$scopedFlow$1$1 = new FlowCoroutineKt$scopedFlow$1$1(this.$block, this.$this_unsafeFlow, cVar);
        flowCoroutineKt$scopedFlow$1$1.L$0 = obj;
        return flowCoroutineKt$scopedFlow$1$1;
    }

    @Override // p0.p
    @Nullable
    public final Object invoke(@NotNull g0 g0Var, @Nullable kotlin.coroutines.c<? super t> cVar) {
        return ((FlowCoroutineKt$scopedFlow$1$1) create(g0Var, cVar)).invokeSuspend(t.f3507a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objD = kotlin.coroutines.intrinsics.b.d();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.h.b(obj);
            g0 g0Var = (g0) this.L$0;
            q_p0<g0, e<Object>, c<? super t>, Object> qP0Var = this.$block;
            kotlinx.coroutines.flow.e<Object> eVar = this.$this_unsafeFlow;
            this.label = 1;
            if (qP0Var.invoke(g0Var, eVar, this) == objD) {
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
