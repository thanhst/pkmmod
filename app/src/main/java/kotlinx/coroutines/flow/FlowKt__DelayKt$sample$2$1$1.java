package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.h;
import kotlinx.coroutines.flow.internal.ChildCancelledException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Delay.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"T", "Lkotlinx/coroutines/channels/h;", "", "result", "Lkotlin/t;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$1$1", f = "Delay.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class FlowKt__DelayKt$sample$2$1$1 extends SuspendLambda implements p0.p<kotlinx.coroutines.channels.h<? extends Object>, kotlin.coroutines.c<? super kotlin.t>, Object> {
    final /* synthetic */ Ref$ObjectRef<Object> $lastValue;
    final /* synthetic */ ReceiveChannel<kotlin.t> $ticker;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FlowKt__DelayKt$sample$2$1$1(Ref$ObjectRef<Object> ref$ObjectRef, ReceiveChannel<kotlin.t> receiveChannel, kotlin.coroutines.c<? super FlowKt__DelayKt$sample$2$1$1> cVar) {
        super(2, cVar);
        this.$lastValue = ref$ObjectRef;
        this.$ticker = receiveChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final kotlin.coroutines.c<kotlin.t> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
        FlowKt__DelayKt$sample$2$1$1 flowKt__DelayKt$sample$2$1$1 = new FlowKt__DelayKt$sample$2$1$1(this.$lastValue, this.$ticker, cVar);
        flowKt__DelayKt$sample$2$1$1.L$0 = obj;
        return flowKt__DelayKt$sample$2$1$1;
    }

    @Override // p0.p
    public /* bridge */ /* synthetic */ Object invoke(kotlinx.coroutines.channels.h<? extends Object> hVar, kotlin.coroutines.c<? super kotlin.t> cVar) {
        return m172invokeWpGqRn0(hVar.getHolder(), cVar);
    }

    @Nullable
    /* renamed from: invoke-WpGqRn0, reason: not valid java name */
    public final Object m172invokeWpGqRn0(@NotNull Object obj, @Nullable kotlin.coroutines.c<? super kotlin.t> cVar) {
        return ((FlowKt__DelayKt$sample$2$1$1) create(kotlinx.coroutines.channels.h.b(obj), cVar)).invokeSuspend(kotlin.t.f3507a);
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v8, types: [T, kotlinx.coroutines.internal.d0] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        kotlin.coroutines.intrinsics.b.d();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kotlin.h.b(obj);
        ?? holder = ((kotlinx.coroutines.channels.h) this.L$0).getHolder();
        Ref$ObjectRef<Object> ref$ObjectRef = this.$lastValue;
        boolean z2 = holder instanceof h.c;
        if (!z2) {
            ref$ObjectRef.element = holder;
        }
        ReceiveChannel<kotlin.t> receiveChannel = this.$ticker;
        if (z2) {
            Throwable thE = kotlinx.coroutines.channels.h.e(holder);
            if (thE != null) {
                throw thE;
            }
            receiveChannel.a(new ChildCancelledException());
            ref$ObjectRef.element = kotlinx.coroutines.flow.internal.n.f3763c;
        }
        return kotlin.t.f3507a;
    }
}
