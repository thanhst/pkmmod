package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.t;
import kotlinx.coroutines.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Merge.kt */
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {"T", "Lkotlinx/coroutines/g0;", "Lkotlin/t;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$1", f = "Merge.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class ChannelFlowMerge$collectTo$2$1 extends SuspendLambda implements p0.p<g0, kotlin.coroutines.c<? super t>, Object> {
    final /* synthetic */ p<Object> $collector;
    final /* synthetic */ kotlinx.coroutines.flow.d<Object> $inner;
    final /* synthetic */ kotlinx.coroutines.sync.d $semaphore;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ChannelFlowMerge$collectTo$2$1(kotlinx.coroutines.flow.d<Object> dVar, p<Object> pVar, kotlinx.coroutines.sync.d dVar2, kotlin.coroutines.c<? super ChannelFlowMerge$collectTo$2$1> cVar) {
        super(2, cVar);
        this.$inner = dVar;
        this.$collector = pVar;
        this.$semaphore = dVar2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final kotlin.coroutines.c<t> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
        return new ChannelFlowMerge$collectTo$2$1(this.$inner, this.$collector, this.$semaphore, cVar);
    }

    @Override // p0.p
    @Nullable
    public final Object invoke(@NotNull g0 g0Var, @Nullable kotlin.coroutines.c<? super t> cVar) {
        return ((ChannelFlowMerge$collectTo$2$1) create(g0Var, cVar)).invokeSuspend(t.f3507a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objD = kotlin.coroutines.intrinsics.b.d();
        int i2 = this.label;
        try {
            if (i2 == 0) {
                kotlin.h.b(obj);
                kotlinx.coroutines.flow.d<Object> dVar = this.$inner;
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
            this.$semaphore.release();
            return t.f3507a;
        } catch (Throwable th) {
            this.$semaphore.release();
            throw th;
        }
    }
}
