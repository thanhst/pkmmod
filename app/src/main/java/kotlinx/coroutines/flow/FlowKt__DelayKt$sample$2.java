package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Delay.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u008a@"}, d2 = {"T", "Lkotlinx/coroutines/g0;", "Lkotlinx/coroutines/flow/e;", "downstream", "Lkotlin/t;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2", f = "Delay.kt", i = {0, 0, 0, 0}, l = {352}, m = "invokeSuspend", n = {"downstream", "values", "lastValue", "ticker"}, s = {"L$0", "L$1", "L$2", "L$3"})
/* loaded from: classes.dex */
final class FlowKt__DelayKt$sample$2 extends SuspendLambda implements p0.q<kotlinx.coroutines.g0, e<Object>, kotlin.coroutines.c<? super kotlin.t>, Object> {
    final /* synthetic */ long $periodMillis;
    final /* synthetic */ d<Object> $this_sample;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FlowKt__DelayKt$sample$2(long j2, d<Object> dVar, kotlin.coroutines.c<? super FlowKt__DelayKt$sample$2> cVar) {
        super(3, cVar);
        this.$periodMillis = j2;
        this.$this_sample = dVar;
    }

    @Override // p0.q
    @Nullable
    public final Object invoke(@NotNull kotlinx.coroutines.g0 g0Var, @NotNull e<Object> eVar, @Nullable kotlin.coroutines.c<? super kotlin.t> cVar) {
        FlowKt__DelayKt$sample$2 flowKt__DelayKt$sample$2 = new FlowKt__DelayKt$sample$2(this.$periodMillis, this.$this_sample, cVar);
        flowKt__DelayKt$sample$2.L$0 = g0Var;
        flowKt__DelayKt$sample$2.L$1 = eVar;
        return flowKt__DelayKt$sample$2.invokeSuspend(kotlin.t.f3507a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        e eVar;
        ReceiveChannel receiveChannel;
        Ref$ObjectRef ref$ObjectRef;
        ReceiveChannel receiveChannelB;
        Object objD = kotlin.coroutines.intrinsics.b.d();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.h.b(obj);
            kotlinx.coroutines.g0 g0Var = (kotlinx.coroutines.g0) this.L$0;
            e eVar2 = (e) this.L$1;
            ReceiveChannel receiveChannelE = ProduceKt.e(g0Var, null, -1, new FlowKt__DelayKt$sample$2$values$1(this.$this_sample, null), 1, null);
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            eVar = eVar2;
            receiveChannel = receiveChannelE;
            ref$ObjectRef = ref$ObjectRef2;
            receiveChannelB = FlowKt__DelayKt.b(g0Var, this.$periodMillis, 0L, 2, null);
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            receiveChannelB = (ReceiveChannel) this.L$3;
            ref$ObjectRef = (Ref$ObjectRef) this.L$2;
            receiveChannel = (ReceiveChannel) this.L$1;
            eVar = (e) this.L$0;
            kotlin.h.b(obj);
        }
        while (ref$ObjectRef.element != kotlinx.coroutines.flow.internal.n.f3763c) {
            this.L$0 = eVar;
            this.L$1 = receiveChannel;
            this.L$2 = ref$ObjectRef;
            this.L$3 = receiveChannelB;
            this.label = 1;
            SelectInstance selectInstance = new SelectInstance(this);
            try {
                selectInstance.i(receiveChannel.q(), new FlowKt__DelayKt$sample$2$1$1(ref$ObjectRef, receiveChannelB, null));
                selectInstance.i(receiveChannelB.n(), new FlowKt__DelayKt$sample$2$1$2(ref$ObjectRef, eVar, null));
            } catch (Throwable th) {
                selectInstance.W(th);
            }
            Object objV = selectInstance.V();
            if (objV == kotlin.coroutines.intrinsics.b.d()) {
                kotlin.coroutines.jvm.internal.e.c(this);
            }
            if (objV == objD) {
                return objD;
            }
        }
        return kotlin.t.f3507a;
    }
}
