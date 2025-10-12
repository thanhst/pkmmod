package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Share.kt */
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {"T", "Lkotlinx/coroutines/g0;", "Lkotlin/t;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharingDeferred$1", f = "Share.kt", i = {}, l = {340}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class FlowKt__ShareKt$launchSharingDeferred$1 extends SuspendLambda implements p0.p<kotlinx.coroutines.g0, kotlin.coroutines.c<? super kotlin.t>, Object> {
    final /* synthetic */ kotlinx.coroutines.t<p1<Object>> $result;
    final /* synthetic */ d<Object> $upstream;
    private /* synthetic */ Object L$0;
    int label;

    /* compiled from: Share.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "value", "Lkotlin/t;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    static final class a<T> implements e {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Ref$ObjectRef<g1<T>> f3706e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.g0 f3707f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.t<p1<T>> f3708g;

        a(Ref$ObjectRef<g1<T>> ref$ObjectRef, kotlinx.coroutines.g0 g0Var, kotlinx.coroutines.t<p1<T>> tVar) {
            this.f3706e = ref$ObjectRef;
            this.f3707f = g0Var;
            this.f3708g = tVar;
        }

        /* JADX WARN: Type inference failed for: r4v2, types: [T, kotlinx.coroutines.flow.g1, kotlinx.coroutines.flow.p1] */
        @Override // kotlinx.coroutines.flow.e
        @Nullable
        public final Object emit(T t2, @NotNull kotlin.coroutines.c<? super kotlin.t> cVar) {
            kotlin.t tVar;
            g1<T> g1Var = this.f3706e.element;
            if (g1Var == null) {
                tVar = null;
            } else {
                g1Var.setValue(t2);
                tVar = kotlin.t.f3507a;
            }
            if (tVar == null) {
                kotlinx.coroutines.g0 g0Var = this.f3707f;
                Ref$ObjectRef<g1<T>> ref$ObjectRef = this.f3706e;
                kotlinx.coroutines.t<p1<T>> tVar2 = this.f3708g;
                ?? r4 = (T) q1.a(t2);
                tVar2.p(new h1(r4, kotlinx.coroutines.k1.g(g0Var.h())));
                ref$ObjectRef.element = r4;
            }
            return kotlin.t.f3507a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FlowKt__ShareKt$launchSharingDeferred$1(d<Object> dVar, kotlinx.coroutines.t<p1<Object>> tVar, kotlin.coroutines.c<? super FlowKt__ShareKt$launchSharingDeferred$1> cVar) {
        super(2, cVar);
        this.$upstream = dVar;
        this.$result = tVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final kotlin.coroutines.c<kotlin.t> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
        FlowKt__ShareKt$launchSharingDeferred$1 flowKt__ShareKt$launchSharingDeferred$1 = new FlowKt__ShareKt$launchSharingDeferred$1(this.$upstream, this.$result, cVar);
        flowKt__ShareKt$launchSharingDeferred$1.L$0 = obj;
        return flowKt__ShareKt$launchSharingDeferred$1;
    }

    @Override // p0.p
    @Nullable
    public final Object invoke(@NotNull kotlinx.coroutines.g0 g0Var, @Nullable kotlin.coroutines.c<? super kotlin.t> cVar) {
        return ((FlowKt__ShareKt$launchSharingDeferred$1) create(g0Var, cVar)).invokeSuspend(kotlin.t.f3507a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objD = kotlin.coroutines.intrinsics.b.d();
        int i2 = this.label;
        try {
            if (i2 == 0) {
                kotlin.h.b(obj);
                kotlinx.coroutines.g0 g0Var = (kotlinx.coroutines.g0) this.L$0;
                Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                d<Object> dVar = this.$upstream;
                a aVar = new a(ref$ObjectRef, g0Var, this.$result);
                this.label = 1;
                if (dVar.a(aVar, this) == objD) {
                    return objD;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.h.b(obj);
            }
            return kotlin.t.f3507a;
        } catch (Throwable th) {
            this.$result.o(th);
            throw th;
        }
    }
}
