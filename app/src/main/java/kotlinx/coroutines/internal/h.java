package kotlinx.coroutines.internal;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.t;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.d2;
import kotlinx.coroutines.h1;
import kotlinx.coroutines.u0;
import kotlinx.coroutines.z1;
import p0.l_p0;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DispatchedContinuation.kt */
@Metadata(bv = {}, d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001aW\u0010\u000b\u001a\u00020\t\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022%\b\u0002\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u0012\u0010\u000f\u001a\u00020\u000e*\b\u0012\u0004\u0012\u00020\t0\rH\u0000\"\u001a\u0010\u0015\u001a\u00020\u00108\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u0012\u0004\b\u0013\u0010\u0014\"\u001a\u0010\u0017\u001a\u00020\u00108\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0012\u0012\u0004\b\u0016\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"T", "Lkotlin/coroutines/c;", "Lkotlin/Result;", "result", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlin/t;", "onCancellation", "b", "(Lkotlin/coroutines/c;Ljava/lang/Object;Lp0/l;)V", "Lkotlinx/coroutines/internal/g;", "", "d", "Lkotlinx/coroutines/internal/d0;", "a", "Lkotlinx/coroutines/internal/d0;", "getUNDEFINED$annotations", "()V", "UNDEFINED", "getREUSABLE_CLAIMED$annotations", "REUSABLE_CLAIMED", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final d0 f3818a = new d0("UNDEFINED");

    /* renamed from: b, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final d0 f3819b = new d0("REUSABLE_CLAIMED");

    /* JADX WARN: Finally extract failed */
    @InternalCoroutinesApi
    public static final <T> void b(@NotNull kotlin.coroutines.c<? super T> cVar, @NotNull Object obj, @Nullable l_p0<? super Throwable, t> lP0Var) {
        boolean z2;
        if (!(cVar instanceof g)) {
            cVar.resumeWith(obj);
            return;
        }
        g gVar = (g) cVar;
        Object objC = kotlinx.coroutines.z.c(obj, lP0Var);
        if (gVar.dispatcher.k(gVar.getContext())) {
            gVar._state = objC;
            gVar.resumeMode = 1;
            gVar.dispatcher.g(gVar.getContext(), gVar);
            return;
        }
        u0 u0VarA = z1.f4018a.a();
        if (u0VarA.B()) {
            gVar._state = objC;
            gVar.resumeMode = 1;
            u0VarA.v(gVar);
            return;
        }
        u0VarA.y(true);
        try {
            h1 h1Var = (h1) gVar.getContext().get(h1.INSTANCE);
            if (h1Var == null || h1Var.isActive()) {
                z2 = false;
            } else {
                CancellationException cancellationExceptionT = h1Var.t();
                gVar.a(objC, cancellationExceptionT);
                Result.Companion companion = Result.INSTANCE;
                gVar.resumeWith(Result.m158constructorimpl(kotlin.h.a(cancellationExceptionT)));
                z2 = true;
            }
            if (!z2) {
                kotlin.coroutines.c<T> cVar2 = gVar.continuation;
                Object obj2 = gVar.countOrElement;
                CoroutineContext context = cVar2.getContext();
                Object objC2 = ThreadContextKt.c(context, obj2);
                d2<?> d2VarF = objC2 != ThreadContextKt.f3793a ? CoroutineContextKt.f(cVar2, context, objC2) : null;
                try {
                    gVar.continuation.resumeWith(obj);
                    kotlin.t tVar = kotlin.t.f3507a;
                    if (d2VarF == null || d2VarF.P0()) {
                        ThreadContextKt.a(context, objC2);
                    }
                } catch (Throwable th) {
                    if (d2VarF == null || d2VarF.P0()) {
                        ThreadContextKt.a(context, objC2);
                    }
                    throw th;
                }
            }
            while (u0VarA.E()) {
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public static /* synthetic */ void c(kotlin.coroutines.c cVar, Object obj, l_p0 lP0Var, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            lP0Var = null;
        }
        b(cVar, obj, lP0Var);
    }

    public static final boolean d(@NotNull g<? super kotlin.t> gVar) {
        kotlin.t tVar = kotlin.t.f3507a;
        u0 u0VarA = z1.f4018a.a();
        if (u0VarA.D()) {
            return false;
        }
        if (u0VarA.B()) {
            gVar._state = tVar;
            gVar.resumeMode = 1;
            u0VarA.v(gVar);
            return true;
        }
        u0VarA.y(true);
        try {
            gVar.run();
            do {
            } while (u0VarA.E());
        } finally {
            try {
                return false;
            } finally {
            }
        }
        return false;
    }
}
