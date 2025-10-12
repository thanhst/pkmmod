package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Errors.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0007\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u008a@"}, d2 = {"T", "Lkotlinx/coroutines/flow/e;", "", "cause", "", "attempt", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$3", f = "Errors.kt", i = {}, l = {95}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class FlowKt__ErrorsKt$retry$3 extends SuspendLambda implements p0.r<e<Object>, Throwable, Long, kotlin.coroutines.c<? super Boolean>, Object> {
    final /* synthetic */ p0.p<Throwable, kotlin.coroutines.c<? super Boolean>, Object> $predicate;
    final /* synthetic */ long $retries;
    /* synthetic */ long J$0;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__ErrorsKt$retry$3(long j2, p0.p<? super Throwable, ? super kotlin.coroutines.c<? super Boolean>, ? extends Object> pVar, kotlin.coroutines.c<? super FlowKt__ErrorsKt$retry$3> cVar) {
        super(4, cVar);
        this.$retries = j2;
        this.$predicate = pVar;
    }

    @Override // p0.r
    public /* bridge */ /* synthetic */ Object invoke(e<Object> eVar, Throwable th, Long l2, kotlin.coroutines.c<? super Boolean> cVar) {
        return invoke(eVar, th, l2.longValue(), cVar);
    }

    @Nullable
    public final Object invoke(@NotNull e<Object> eVar, @NotNull Throwable th, long j2, @Nullable kotlin.coroutines.c<? super Boolean> cVar) {
        FlowKt__ErrorsKt$retry$3 flowKt__ErrorsKt$retry$3 = new FlowKt__ErrorsKt$retry$3(this.$retries, this.$predicate, cVar);
        flowKt__ErrorsKt$retry$3.L$0 = th;
        flowKt__ErrorsKt$retry$3.J$0 = j2;
        return flowKt__ErrorsKt$retry$3.invokeSuspend(kotlin.t.f3507a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objD = kotlin.coroutines.intrinsics.b.d();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.h.b(obj);
            Throwable th = (Throwable) this.L$0;
            if (this.J$0 < this.$retries) {
                p0.p<Throwable, kotlin.coroutines.c<? super Boolean>, Object> pVar = this.$predicate;
                this.label = 1;
                obj = pVar.invoke(th, this);
                if (obj == objD) {
                    return objD;
                }
            }
            return kotlin.coroutines.jvm.internal.a.a(z);
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kotlin.h.b(obj);
        boolean z2 = ((Boolean) obj).booleanValue();
        return kotlin.coroutines.jvm.internal.a.a(z2);
    }
}
