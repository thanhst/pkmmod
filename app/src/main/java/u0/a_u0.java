package u0;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.h;
import kotlin.t;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p0.l_p0;
import p0.p_p0;

/* compiled from: Cancellable.kt */
@Metadata(bv = {}, d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u001a@\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a{\u0010\u0010\u001a\u00020\u0005\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u0000*\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t2\u0006\u0010\n\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00022%\b\u0002\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001e\u0010\u0013\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00050\u00022\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0000\u001a\u001c\u0010\u0015\u001a\u00020\u00052\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0014\u001a\u00020\u000bH\u0002\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"T", "Lkotlin/Function1;", "Lkotlin/coroutines/c;", "", "completion", "Lkotlin/t;", "c", "(Lp0/l;Lkotlin/coroutines/c;)V", "R", "Lkotlin/Function2;", "receiver", "", "Lkotlin/ParameterName;", "name", "cause", "onCancellation", "d", "(Lp0/p;Ljava/lang/Object;Lkotlin/coroutines/c;Lp0/l;)V", "fatalCompletion", "b", "e", "a", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class a_u0 {
    private static final void a(c<?> cVar, Throwable th) throws Throwable {
        Result.Companion companion = Result.INSTANCE;
        cVar.resumeWith(Result.m158constructorimpl(h.a(th)));
        throw th;
    }

    public static final void b(@NotNull c<? super t> cVar, @NotNull c<?> cVar2) throws Throwable {
        try {
            c cVarC = IntrinsicsKt__IntrinsicsJvmKt.c(cVar);
            Result.Companion companion = Result.INSTANCE;
            kotlinx.coroutines.internal.h.c(cVarC, Result.m158constructorimpl(t.f3507a), null, 2, null);
        } catch (Throwable th) {
            a(cVar2, th);
        }
    }

    @InternalCoroutinesApi
    public static final <T> void c(@NotNull l_p0<? super c<? super T>, ? extends Object> lP0Var, @NotNull c<? super T> cVar) {
        try {
            c cVarC = IntrinsicsKt__IntrinsicsJvmKt.c(IntrinsicsKt__IntrinsicsJvmKt.a(lP0Var, cVar));
            Result.Companion companion = Result.INSTANCE;
            kotlinx.coroutines.internal.h.c(cVarC, Result.m158constructorimpl(t.f3507a), null, 2, null);
        } catch (Throwable th) {
            a(cVar, th);
        }
    }

    public static final <R, T> void d(@NotNull p_p0<? super R, ? super c<? super T>, ? extends Object> pP0Var, R r2, @NotNull c<? super T> cVar, @Nullable l_p0<? super Throwable, t> lP0Var) throws Throwable {
        try {
            c cVarC = IntrinsicsKt__IntrinsicsJvmKt.c(IntrinsicsKt__IntrinsicsJvmKt.b(pP0Var, r2, cVar));
            Result.Companion companion = Result.INSTANCE;
            kotlinx.coroutines.internal.h.b(cVarC, Result.m158constructorimpl(t.f3507a), lP0Var);
        } catch (Throwable th) {
            a(cVar, th);
        }
    }

    public static /* synthetic */ void e(p_p0 pP0Var, Object obj, c cVar, l_p0 lP0Var, int i2, Object obj2) throws Throwable {
        if ((i2 & 4) != 0) {
            lP0Var = null;
        }
        d(pP0Var, obj, cVar, lP0Var);
    }
}
