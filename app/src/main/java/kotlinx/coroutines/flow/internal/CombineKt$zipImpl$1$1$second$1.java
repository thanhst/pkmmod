package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.t;
import kotlinx.coroutines.channels.n;
import p0.p_p0;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Combine.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, d2 = {"T1", "T2", "R", "Lkotlinx/coroutines/channels/n;", "", "Lkotlin/t;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1", f = "Combine.kt", i = {}, l = {92}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class CombineKt$zipImpl$1$1$second$1 extends SuspendLambda implements p_p0<n<? super Object>, c<? super t>, Object> {
    final /* synthetic */ kotlinx.coroutines.flow.d<Object> $flow2;
    private /* synthetic */ Object L$0;
    int label;

    /* compiled from: Combine.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u00022\u0006\u0010\u0003\u001a\u00028\u0001H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T1", "T2", "R", "value", "Lkotlin/t;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1$1, reason: invalid class name */
    static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.e {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.channels.n<Object> f3746e;

        AnonymousClass1(kotlinx.coroutines.channels.n<Object> nVar) {
            this.f3746e = nVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.e
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(java.lang.Object r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super kotlin.t> r6) {
            /*
                r4 = this;
                boolean r0 = r6 instanceof kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1$1$emit$1
                if (r0 == 0) goto L13
                r0 = r6
                kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1$1$emit$1 r0 = (kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1$1$emit$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1$1$emit$1 r0 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1$1$emit$1
                r0.<init>(r4, r6)
            L18:
                java.lang.Object r6 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.a.d()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L31
                if (r2 != r3) goto L29
                kotlin.h.b(r6)
                goto L47
            L29:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L31:
                kotlin.h.b(r6)
                kotlinx.coroutines.channels.n<java.lang.Object> r6 = r4.f3746e
                kotlinx.coroutines.channels.s r6 = r6.B()
                if (r5 != 0) goto L3e
                kotlinx.coroutines.internal.d0 r5 = kotlinx.coroutines.flow.internal.n.f3761a
            L3e:
                r0.label = r3
                java.lang.Object r5 = r6.y(r5, r0)
                if (r5 != r1) goto L47
                return r1
            L47:
                kotlin.t r5 = kotlin.t.f3507a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1.AnonymousClass1.emit(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CombineKt$zipImpl$1$1$second$1(kotlinx.coroutines.flow.d<Object> dVar, kotlin.coroutines.c<? super CombineKt$zipImpl$1$1$second$1> cVar) {
        super(2, cVar);
        this.$flow2 = dVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final kotlin.coroutines.c<t> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
        CombineKt$zipImpl$1$1$second$1 combineKt$zipImpl$1$1$second$1 = new CombineKt$zipImpl$1$1$second$1(this.$flow2, cVar);
        combineKt$zipImpl$1$1$second$1.L$0 = obj;
        return combineKt$zipImpl$1$1$second$1;
    }

    @Override // p0.p
    public /* bridge */ /* synthetic */ Object invoke(kotlinx.coroutines.channels.n<? super Object> nVar, kotlin.coroutines.c<? super t> cVar) {
        return invoke2((kotlinx.coroutines.channels.n<Object>) nVar, cVar);
    }

    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull kotlinx.coroutines.channels.n<Object> nVar, @Nullable kotlin.coroutines.c<? super t> cVar) {
        return ((CombineKt$zipImpl$1$1$second$1) create(nVar, cVar)).invokeSuspend(t.f3507a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objD = kotlin.coroutines.intrinsics.b.d();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.h.b(obj);
            kotlinx.coroutines.channels.n nVar = (kotlinx.coroutines.channels.n) this.L$0;
            kotlinx.coroutines.flow.d<Object> dVar = this.$flow2;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(nVar);
            this.label = 1;
            if (dVar.a(anonymousClass1, this) == objD) {
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
