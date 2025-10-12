package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Yield.kt */
@Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0001\u001a\u00020\u0000H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0003"}, d2 = {"Lkotlin/t;", "a", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class g2 {
    @Nullable
    public static final Object a(@NotNull kotlin.coroutines.c<? super kotlin.t> cVar) {
        Object objD;
        CoroutineContext context = cVar.getContext();
        k1.e(context);
        kotlin.coroutines.c cVarC = IntrinsicsKt__IntrinsicsJvmKt.c(cVar);
        kotlinx.coroutines.internal.g gVar = cVarC instanceof kotlinx.coroutines.internal.g ? (kotlinx.coroutines.internal.g) cVarC : null;
        if (gVar == null) {
            objD = kotlin.t.f3507a;
        } else {
            if (gVar.dispatcher.k(context)) {
                gVar.k(context, kotlin.t.f3507a);
            } else {
                f2 f2Var = new f2();
                CoroutineContext coroutineContextPlus = context.plus(f2Var);
                kotlin.t tVar = kotlin.t.f3507a;
                gVar.k(coroutineContextPlus, tVar);
                objD = (!f2Var.dispatcherWasUnconfined || kotlinx.coroutines.internal.h.d(gVar)) ? kotlin.coroutines.intrinsics.b.d() : tVar;
            }
            objD = kotlin.coroutines.intrinsics.b.d();
        }
        if (objD == kotlin.coroutines.intrinsics.b.d()) {
            kotlin.coroutines.jvm.internal.e.c(cVar);
        }
        return objD == kotlin.coroutines.intrinsics.b.d() ? objD : kotlin.t.f3507a;
    }
}
