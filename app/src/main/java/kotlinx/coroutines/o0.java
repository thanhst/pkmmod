package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: DispatchedTask.kt */
@Metadata(bv = {}, d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u001a \u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0000\u001a.\u0010\n\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\t\u001a\u00020\bH\u0000\u001a\u0010\u0010\u000b\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u0001H\u0002\"\u0018\u0010\u000e\u001a\u00020\b*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r\"\u0018\u0010\u0010\u001a\u00020\b*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\r¨\u0006\u0011"}, d2 = {"T", "Lkotlinx/coroutines/n0;", "", "mode", "Lkotlin/t;", "a", "Lkotlin/coroutines/c;", "delegate", "", "undispatched", "d", "e", "b", "(I)Z", "isCancellableMode", "c", "isReusableMode", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class o0 {
    public static final <T> void a(@NotNull n0<? super T> n0Var, int i2) {
        kotlin.coroutines.c<? super T> cVarB = n0Var.b();
        boolean z2 = i2 == 4;
        if (z2 || !(cVarB instanceof kotlinx.coroutines.internal.g) || b(i2) != b(n0Var.resumeMode)) {
            d(n0Var, cVarB, z2);
            return;
        }
        CoroutineDispatcher coroutineDispatcher = ((kotlinx.coroutines.internal.g) cVarB).dispatcher;
        CoroutineContext context = cVarB.getContext();
        if (coroutineDispatcher.k(context)) {
            coroutineDispatcher.g(context, n0Var);
        } else {
            e(n0Var);
        }
    }

    public static final boolean b(int i2) {
        return i2 == 1 || i2 == 2;
    }

    public static final boolean c(int i2) {
        return i2 == 2;
    }

    public static final <T> void d(@NotNull n0<? super T> n0Var, @NotNull kotlin.coroutines.c<? super T> cVar, boolean z2) {
        Object objF;
        Object objH = n0Var.h();
        Throwable thD = n0Var.d(objH);
        if (thD != null) {
            Result.Companion companion = Result.INSTANCE;
            objF = kotlin.h.a(thD);
        } else {
            Result.Companion companion2 = Result.INSTANCE;
            objF = n0Var.f(objH);
        }
        Object objM158constructorimpl = Result.m158constructorimpl(objF);
        if (!z2) {
            cVar.resumeWith(objM158constructorimpl);
            return;
        }
        kotlinx.coroutines.internal.g gVar = (kotlinx.coroutines.internal.g) cVar;
        kotlin.coroutines.c<T> cVar2 = gVar.continuation;
        Object obj = gVar.countOrElement;
        CoroutineContext context = cVar2.getContext();
        Object objC = ThreadContextKt.c(context, obj);
        d2<?> d2VarF = objC != ThreadContextKt.f3793a ? CoroutineContextKt.f(cVar2, context, objC) : null;
        try {
            gVar.continuation.resumeWith(objM158constructorimpl);
            kotlin.t tVar = kotlin.t.f3507a;
        } finally {
            if (d2VarF == null || d2VarF.P0()) {
                ThreadContextKt.a(context, objC);
            }
        }
    }

    private static final void e(n0<?> n0Var) {
        u0 u0VarA = z1.f4018a.a();
        if (u0VarA.B()) {
            u0VarA.v(n0Var);
            return;
        }
        u0VarA.y(true);
        try {
            d(n0Var, n0Var.b(), true);
            do {
            } while (u0VarA.E());
        } finally {
            try {
            } finally {
            }
        }
    }
}
