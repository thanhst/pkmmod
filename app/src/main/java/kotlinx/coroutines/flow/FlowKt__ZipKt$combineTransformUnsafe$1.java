package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.flow.internal.CombineKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Zip.kt */
@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u0002H\u008a@"}, d2 = {"T", "R", "Lkotlinx/coroutines/flow/e;", "Lkotlin/t;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransformUnsafe$1", f = "Zip.kt", i = {}, l = {273}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
public final class FlowKt__ZipKt$combineTransformUnsafe$1 extends SuspendLambda implements p0.p<e<Object>, kotlin.coroutines.c<? super kotlin.t>, Object> {
    final /* synthetic */ d<Object>[] $flows;
    final /* synthetic */ p0.q<e<Object>, Object[], kotlin.coroutines.c<? super kotlin.t>, Object> $transform;
    private /* synthetic */ Object L$0;
    int label;

    /* compiled from: Zip.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0006\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u008a@"}, d2 = {"T", "R", "Lkotlinx/coroutines/flow/e;", "", "it", "Lkotlin/t;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransformUnsafe$1$1", f = "Zip.kt", i = {}, l = {273}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransformUnsafe$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p0.q<e<Object>, Object[], kotlin.coroutines.c<? super kotlin.t>, Object> {
        final /* synthetic */ p0.q<e<Object>, Object[], kotlin.coroutines.c<? super kotlin.t>, Object> $transform;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(p0.q<? super e<Object>, ? super Object[], ? super kotlin.coroutines.c<? super kotlin.t>, ? extends Object> qVar, kotlin.coroutines.c<? super AnonymousClass1> cVar) {
            super(3, cVar);
            this.$transform = qVar;
        }

        @Override // p0.q
        @Nullable
        public final Object invoke(@NotNull e<Object> eVar, @NotNull Object[] objArr, @Nullable kotlin.coroutines.c<? super kotlin.t> cVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$transform, cVar);
            anonymousClass1.L$0 = eVar;
            anonymousClass1.L$1 = objArr;
            return anonymousClass1.invokeSuspend(kotlin.t.f3507a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objD = kotlin.coroutines.intrinsics.b.d();
            int i2 = this.label;
            if (i2 == 0) {
                kotlin.h.b(obj);
                e<Object> eVar = (e) this.L$0;
                Object[] objArr = (Object[]) this.L$1;
                p0.q<e<Object>, Object[], kotlin.coroutines.c<? super kotlin.t>, Object> qVar = this.$transform;
                this.L$0 = null;
                this.label = 1;
                if (qVar.invoke(eVar, objArr, this) == objD) {
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

        @Nullable
        public final Object invokeSuspend$$forInline(@NotNull Object obj) {
            this.$transform.invoke((e) this.L$0, (Object[]) this.L$1, this);
            return kotlin.t.f3507a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ZipKt$combineTransformUnsafe$1(d<Object>[] dVarArr, p0.q<? super e<Object>, ? super Object[], ? super kotlin.coroutines.c<? super kotlin.t>, ? extends Object> qVar, kotlin.coroutines.c<? super FlowKt__ZipKt$combineTransformUnsafe$1> cVar) {
        super(2, cVar);
        this.$flows = dVarArr;
        this.$transform = qVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final kotlin.coroutines.c<kotlin.t> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
        FlowKt__ZipKt$combineTransformUnsafe$1 flowKt__ZipKt$combineTransformUnsafe$1 = new FlowKt__ZipKt$combineTransformUnsafe$1(this.$flows, this.$transform, cVar);
        flowKt__ZipKt$combineTransformUnsafe$1.L$0 = obj;
        return flowKt__ZipKt$combineTransformUnsafe$1;
    }

    @Override // p0.p
    @Nullable
    public final Object invoke(@NotNull e<Object> eVar, @Nullable kotlin.coroutines.c<? super kotlin.t> cVar) {
        return ((FlowKt__ZipKt$combineTransformUnsafe$1) create(eVar, cVar)).invokeSuspend(kotlin.t.f3507a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objD = kotlin.coroutines.intrinsics.b.d();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.h.b(obj);
            e eVar = (e) this.L$0;
            d<Object>[] dVarArr = this.$flows;
            p0.a aVarB = FlowKt__ZipKt.b();
            kotlin.jvm.internal.s.i();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$transform, null);
            this.label = 1;
            if (CombineKt.a(eVar, dVarArr, aVarB, anonymousClass1, this) == objD) {
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

    @Nullable
    public final Object invokeSuspend$$forInline(@NotNull Object obj) throws Throwable {
        e eVar = (e) this.L$0;
        d<Object>[] dVarArr = this.$flows;
        p0.a aVarB = FlowKt__ZipKt.b();
        kotlin.jvm.internal.s.i();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$transform, null);
        kotlin.jvm.internal.q.c(0);
        CombineKt.a(eVar, dVarArr, aVarB, anonymousClass1, this);
        kotlin.jvm.internal.q.c(1);
        return kotlin.t.f3507a;
    }
}
