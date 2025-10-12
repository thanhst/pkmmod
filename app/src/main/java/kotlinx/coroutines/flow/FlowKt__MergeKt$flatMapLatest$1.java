package kotlinx.coroutines.flow;

import com.facebook.internal.FacebookRequestErrorClassification;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Merge.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\u008a@"}, d2 = {"T", "R", "Lkotlinx/coroutines/flow/e;", "it", "Lkotlin/t;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapLatest$1", f = "Merge.kt", i = {}, l = {FacebookRequestErrorClassification.EC_INVALID_TOKEN, FacebookRequestErrorClassification.EC_INVALID_TOKEN}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
public final class FlowKt__MergeKt$flatMapLatest$1 extends SuspendLambda implements p0.q<e<Object>, Object, kotlin.coroutines.c<? super kotlin.t>, Object> {
    final /* synthetic */ p0.p<Object, kotlin.coroutines.c<? super d<Object>>, Object> $transform;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__MergeKt$flatMapLatest$1(p0.p<Object, ? super kotlin.coroutines.c<? super d<Object>>, ? extends Object> pVar, kotlin.coroutines.c<? super FlowKt__MergeKt$flatMapLatest$1> cVar) {
        super(3, cVar);
        this.$transform = pVar;
    }

    @Override // p0.q
    @Nullable
    public final Object invoke(@NotNull e<Object> eVar, Object obj, @Nullable kotlin.coroutines.c<? super kotlin.t> cVar) {
        FlowKt__MergeKt$flatMapLatest$1 flowKt__MergeKt$flatMapLatest$1 = new FlowKt__MergeKt$flatMapLatest$1(this.$transform, cVar);
        flowKt__MergeKt$flatMapLatest$1.L$0 = eVar;
        flowKt__MergeKt$flatMapLatest$1.L$1 = obj;
        return flowKt__MergeKt$flatMapLatest$1.invokeSuspend(kotlin.t.f3507a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        e eVar;
        Object objD = kotlin.coroutines.intrinsics.b.d();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.h.b(obj);
            eVar = (e) this.L$0;
            Object obj2 = this.L$1;
            p0.p<Object, kotlin.coroutines.c<? super d<Object>>, Object> pVar = this.$transform;
            this.L$0 = eVar;
            this.label = 1;
            obj = pVar.invoke(obj2, this);
            if (obj == objD) {
                return objD;
            }
        } else {
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.h.b(obj);
                return kotlin.t.f3507a;
            }
            eVar = (e) this.L$0;
            kotlin.h.b(obj);
        }
        this.L$0 = null;
        this.label = 2;
        if (f.j(eVar, (d) obj, this) == objD) {
            return objD;
        }
        return kotlin.t.f3507a;
    }

    @Nullable
    public final Object invokeSuspend$$forInline(@NotNull Object obj) {
        e eVar = (e) this.L$0;
        d dVar = (d) this.$transform.invoke(this.L$1, this);
        kotlin.jvm.internal.q.c(0);
        f.j(eVar, dVar, this);
        kotlin.jvm.internal.q.c(1);
        return kotlin.t.f3507a;
    }
}
