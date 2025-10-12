package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Channels.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {"E", "Lkotlinx/coroutines/g0;", "Lkotlinx/coroutines/channels/h;", "Lkotlin/t;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__ChannelsKt$trySendBlocking$2", f = "Channels.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class ChannelsKt__ChannelsKt$trySendBlocking$2 extends SuspendLambda implements p0.p<g0, kotlin.coroutines.c<? super h<? extends kotlin.t>>, Object> {
    final /* synthetic */ Object $element;
    final /* synthetic */ s<Object> $this_trySendBlocking;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ChannelsKt__ChannelsKt$trySendBlocking$2(s<Object> sVar, Object obj, kotlin.coroutines.c<? super ChannelsKt__ChannelsKt$trySendBlocking$2> cVar) {
        super(2, cVar);
        this.$this_trySendBlocking = sVar;
        this.$element = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final kotlin.coroutines.c<kotlin.t> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
        ChannelsKt__ChannelsKt$trySendBlocking$2 channelsKt__ChannelsKt$trySendBlocking$2 = new ChannelsKt__ChannelsKt$trySendBlocking$2(this.$this_trySendBlocking, this.$element, cVar);
        channelsKt__ChannelsKt$trySendBlocking$2.L$0 = obj;
        return channelsKt__ChannelsKt$trySendBlocking$2;
    }

    @Override // p0.p
    public /* bridge */ /* synthetic */ Object invoke(g0 g0Var, kotlin.coroutines.c<? super h<? extends kotlin.t>> cVar) {
        return invoke2(g0Var, (kotlin.coroutines.c<? super h<kotlin.t>>) cVar);
    }

    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull g0 g0Var, @Nullable kotlin.coroutines.c<? super h<kotlin.t>> cVar) {
        return ((ChannelsKt__ChannelsKt$trySendBlocking$2) create(g0Var, cVar)).invokeSuspend(kotlin.t.f3507a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objM158constructorimpl;
        Object objD = kotlin.coroutines.intrinsics.b.d();
        int i2 = this.label;
        try {
            if (i2 == 0) {
                kotlin.h.b(obj);
                s<Object> sVar = this.$this_trySendBlocking;
                Object obj2 = this.$element;
                Result.Companion companion = Result.INSTANCE;
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
            objM158constructorimpl = Result.m158constructorimpl(kotlin.t.f3507a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM158constructorimpl = Result.m158constructorimpl(kotlin.h.a(th));
        }
        return h.b(Result.m165isSuccessimpl(objM158constructorimpl) ? h.INSTANCE.c(kotlin.t.f3507a) : h.INSTANCE.a(Result.m161exceptionOrNullimpl(objM158constructorimpl)));
    }
}
