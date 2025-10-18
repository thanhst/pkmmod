package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.y1;
import p0.p_p0;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ThreadContext.kt */
@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000\u001a\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0000\u001a\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0000\"\u0014\u0010\u000b\u001a\u00020\t8\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\b\u0010\n\"*\u0010\u000f\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000e\"2\u0010\u0011\u001a \u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0010\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00100\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000e\"&\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00120\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u000e¨\u0006\u0015"}, d2 = {"Lkotlin/coroutines/CoroutineContext;", "context", "", "b", "countOrElement", "c", "oldState", "Lkotlin/t;", "a", "Lkotlinx/coroutines/internal/d0;", "Lkotlinx/coroutines/internal/d0;", "NO_THREAD_ELEMENTS", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext$a;", "Lp0/p;", "countAll", "Lkotlinx/coroutines/y1;", "findOne", "Lkotlinx/coroutines/internal/j0;", "d", "updateState", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class ThreadContextKt {

    /* renamed from: a, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final d0 f3793a = new d0("NO_THREAD_ELEMENTS");

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final p_p0<Object, CoroutineContext.a, Object> f3794b = new p_p0<Object, CoroutineContext.a, Object>() { // from class: kotlinx.coroutines.internal.ThreadContextKt$countAll$1
        @Override // p0.p
        @Nullable
        public final Object invoke(@Nullable Object obj, @NotNull CoroutineContext.a aVar) {
            if (!(aVar instanceof y1)) {
                return obj;
            }
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            int iIntValue = num == null ? 1 : num.intValue();
            return iIntValue == 0 ? aVar : Integer.valueOf(iIntValue + 1);
        }
    };

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final p_p0<y1<?>, CoroutineContext.a, y1<?>> f3795c = new p_p0<y1<?>, CoroutineContext.a, y1<?>>() { // from class: kotlinx.coroutines.internal.ThreadContextKt$findOne$1
        @Override // p0.p
        @Nullable
        public final y1<?> invoke(@Nullable y1<?> y1Var, @NotNull CoroutineContext.a aVar) {
            if (y1Var != null) {
                return y1Var;
            }
            if (aVar instanceof y1) {
                return (y1) aVar;
            }
            return null;
        }
    };

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final p_p0<j0, CoroutineContext.a, j0> f3796d = new p_p0<j0, CoroutineContext.a, j0>() { // from class: kotlinx.coroutines.internal.ThreadContextKt$updateState$1
        @Override // p0.p
        @NotNull
        public final j0 invoke(@NotNull j0 j0Var, @NotNull CoroutineContext.a aVar) {
            if (aVar instanceof y1) {
                y1<?> y1Var = (y1) aVar;
                j0Var.a(y1Var, y1Var.C(j0Var.context));
            }
            return j0Var;
        }
    };

    public static final void a(@NotNull CoroutineContext coroutineContext, @Nullable Object obj) {
        if (obj == f3793a) {
            return;
        }
        if (obj instanceof j0) {
            ((j0) obj).b(coroutineContext);
            return;
        }
        Object objFold = coroutineContext.fold(null, f3795c);
        if (objFold == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        }
        ((y1) objFold).l(coroutineContext, obj);
    }

    @NotNull
    public static final Object b(@NotNull CoroutineContext coroutineContext) {
        Object objFold = coroutineContext.fold(0, f3794b);
        kotlin.jvm.internal.s.b(objFold);
        return objFold;
    }

    @Nullable
    public static final Object c(@NotNull CoroutineContext coroutineContext, @Nullable Object obj) {
        if (obj == null) {
            obj = b(coroutineContext);
        }
        return obj == 0 ? f3793a : obj instanceof Integer ? coroutineContext.fold(new j0(coroutineContext, ((Number) obj).intValue()), f3796d) : ((y1) obj).C(coroutineContext);
    }
}
