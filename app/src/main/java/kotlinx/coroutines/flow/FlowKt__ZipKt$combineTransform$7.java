package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.flow.internal.CombineKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Zip.kt */
@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u0002H\u008a@"}, d2 = {"T", "R", "Lkotlinx/coroutines/flow/e;", "Lkotlin/t;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7", f = "Zip.kt", i = {}, l = {308}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
public final class FlowKt__ZipKt$combineTransform$7 extends SuspendLambda implements p0.p<e<Object>, kotlin.coroutines.c<? super kotlin.t>, Object> {
    final /* synthetic */ d<Object>[] $flowArray;
    final /* synthetic */ p0.q<e<Object>, Object[], kotlin.coroutines.c<? super kotlin.t>, Object> $transform;
    private /* synthetic */ Object L$0;
    int label;

    /* compiled from: Zip.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\u0010\u0000\u001a\f\u0012\u0006\u0012\u0004\u0018\u0001H\u0002\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0004\b\u0001\u0010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "R", "invoke", "()[Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 176)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements p0.a<Object[]> {
        final /* synthetic */ d<Object>[] $flowArray;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(d<Object>[] dVarArr) {
            super(0);
            this.$flowArray = dVarArr;
        }

        @Override // p0.a
        @Nullable
        public final Object[] invoke() {
            int length = this.$flowArray.length;
            kotlin.jvm.internal.s.j(0, "T?");
            return new Object[length];
        }
    }

    /* compiled from: Zip.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0006\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u008a@"}, d2 = {"T", "R", "Lkotlinx/coroutines/flow/e;", "", "it", "Lkotlin/t;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7$2", f = "Zip.kt", i = {}, l = {308}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p0.q<e<Object>, Object[], kotlin.coroutines.c<? super kotlin.t>, Object> {
        final /* synthetic */ p0.q<e<Object>, Object[], kotlin.coroutines.c<? super kotlin.t>, Object> $transform;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(p0.q<? super e<Object>, ? super Object[], ? super kotlin.coroutines.c<? super kotlin.t>, ? extends Object> qVar, kotlin.coroutines.c<? super AnonymousClass2> cVar) {
            super(3, cVar);
            this.$transform = qVar;
        }

        @Override // p0.q
        @Nullable
        public final Object invoke(@NotNull e<Object> eVar, @NotNull Object[] objArr, @Nullable kotlin.coroutines.c<? super kotlin.t> cVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$transform, cVar);
            anonymousClass2.L$0 = eVar;
            anonymousClass2.L$1 = objArr;
            return anonymousClass2.invokeSuspend(kotlin.t.f3507a);
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
    public FlowKt__ZipKt$combineTransform$7(d<Object>[] dVarArr, p0.q<? super e<Object>, ? super Object[], ? super kotlin.coroutines.c<? super kotlin.t>, ? extends Object> qVar, kotlin.coroutines.c<? super FlowKt__ZipKt$combineTransform$7> cVar) {
        super(2, cVar);
        this.$flowArray = dVarArr;
        this.$transform = qVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final kotlin.coroutines.c<kotlin.t> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
        FlowKt__ZipKt$combineTransform$7 flowKt__ZipKt$combineTransform$7 = new FlowKt__ZipKt$combineTransform$7(this.$flowArray, this.$transform, cVar);
        flowKt__ZipKt$combineTransform$7.L$0 = obj;
        return flowKt__ZipKt$combineTransform$7;
    }

    @Override // p0.p
    @Nullable
    public final Object invoke(@NotNull e<Object> eVar, @Nullable kotlin.coroutines.c<? super kotlin.t> cVar) {
        return ((FlowKt__ZipKt$combineTransform$7) create(eVar, cVar)).invokeSuspend(kotlin.t.f3507a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objD = kotlin.coroutines.intrinsics.b.d();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.h.b(obj);
            e eVar = (e) this.L$0;
            d<Object>[] dVarArr = this.$flowArray;
            kotlin.jvm.internal.s.i();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$flowArray);
            kotlin.jvm.internal.s.i();
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$transform, null);
            this.label = 1;
            if (CombineKt.a(eVar, dVarArr, anonymousClass1, anonymousClass2, this) == objD) {
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
        d<Object>[] dVarArr = this.$flowArray;
        kotlin.jvm.internal.s.i();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$flowArray);
        kotlin.jvm.internal.s.i();
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$transform, null);
        kotlin.jvm.internal.q.c(0);
        CombineKt.a(eVar, dVarArr, anonymousClass1, anonymousClass2, this);
        kotlin.jvm.internal.q.c(1);
        return kotlin.t.f3507a;
    }
}
