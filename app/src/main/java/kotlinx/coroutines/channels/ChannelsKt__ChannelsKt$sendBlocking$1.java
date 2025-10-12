package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Channels.kt */
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {"E", "Lkotlinx/coroutines/g0;", "Lkotlin/t;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__ChannelsKt$sendBlocking$1", f = "Channels.kt", i = {}, l = {58}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class ChannelsKt__ChannelsKt$sendBlocking$1 extends SuspendLambda implements p0.p<g0, kotlin.coroutines.c<? super kotlin.t>, Object> {
    final /* synthetic */ Object $element;
    final /* synthetic */ s<Object> $this_sendBlocking;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ChannelsKt__ChannelsKt$sendBlocking$1(s<Object> sVar, Object obj, kotlin.coroutines.c<? super ChannelsKt__ChannelsKt$sendBlocking$1> cVar) {
        super(2, cVar);
        this.$this_sendBlocking = sVar;
        this.$element = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final kotlin.coroutines.c<kotlin.t> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
        return new ChannelsKt__ChannelsKt$sendBlocking$1(this.$this_sendBlocking, this.$element, cVar);
    }

    @Override // p0.p
    @Nullable
    public final Object invoke(@NotNull g0 g0Var, @Nullable kotlin.coroutines.c<? super kotlin.t> cVar) {
        return ((ChannelsKt__ChannelsKt$sendBlocking$1) create(g0Var, cVar)).invokeSuspend(kotlin.t.f3507a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objD = kotlin.coroutines.intrinsics.b.d();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.h.b(obj);
            s<Object> sVar = this.$this_sendBlocking;
            Object obj2 = this.$element;
            this.label = 1;
            if (sVar.y(obj2, this) == objD) {
                return objD;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.h.b(obj);
        }
        return kotlin.t.f3507a;
    }
}
