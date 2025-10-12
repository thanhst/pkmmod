package u0;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.e;
import kotlin.h;
import kotlin.jvm.internal.y;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.internal.z;
import kotlinx.coroutines.o1;
import kotlinx.coroutines.w;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p0.l;
import p0.p;

/* compiled from: Undispatched.kt */
@Metadata(bv = {}, d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a@\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001aT\u0010\u000b\u001a\u00020\u0005\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u0000*\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t2\u0006\u0010\n\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002H\u0000ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a@\u0010\r\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0000ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u0007\u001aT\u0010\u000e\u001a\u00020\u0005\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u0000*\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t2\u0006\u0010\n\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002H\u0000ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\f\u001a[\u0010\u0012\u001a\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\b*\b\u0012\u0004\u0012\u00028\u00000\u000f2\u0006\u0010\n\u001a\u00028\u00012'\u0010\u0011\u001a#\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t¢\u0006\u0002\b\u0010H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a[\u0010\u0014\u001a\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\b*\b\u0012\u0004\u0012\u00028\u00000\u000f2\u0006\u0010\n\u001a\u00028\u00012'\u0010\u0011\u001a#\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t¢\u0006\u0002\b\u0010H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"T", "Lkotlin/Function1;", "Lkotlin/coroutines/c;", "", "completion", "Lkotlin/t;", "c", "(Lp0/l;Lkotlin/coroutines/c;)V", "R", "Lkotlin/Function2;", "receiver", "d", "(Lp0/p;Ljava/lang/Object;Lkotlin/coroutines/c;)V", "a", "b", "Lkotlinx/coroutines/internal/z;", "Lkotlin/ExtensionFunctionType;", "block", "e", "(Lkotlinx/coroutines/internal/z;Ljava/lang/Object;Lp0/p;)Ljava/lang/Object;", "f", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class b {
    public static final <T> void a(@NotNull l<? super c<? super T>, ? extends Object> lVar, @NotNull c<? super T> cVar) {
        c cVarA = e.a(cVar);
        try {
            CoroutineContext context = cVar.getContext();
            Object objC = ThreadContextKt.c(context, null);
            try {
                Object objInvoke = ((l) y.b(lVar, 1)).invoke(cVarA);
                if (objInvoke != kotlin.coroutines.intrinsics.b.d()) {
                    cVarA.resumeWith(Result.m158constructorimpl(objInvoke));
                }
            } finally {
                ThreadContextKt.a(context, objC);
            }
        } catch (Throwable th) {
            Result.Companion companion = Result.INSTANCE;
            cVarA.resumeWith(Result.m158constructorimpl(h.a(th)));
        }
    }

    public static final <R, T> void b(@NotNull p<? super R, ? super c<? super T>, ? extends Object> pVar, R r2, @NotNull c<? super T> cVar) {
        c cVarA = e.a(cVar);
        try {
            CoroutineContext context = cVar.getContext();
            Object objC = ThreadContextKt.c(context, null);
            try {
                Object objInvoke = ((p) y.b(pVar, 2)).invoke(r2, cVarA);
                if (objInvoke != kotlin.coroutines.intrinsics.b.d()) {
                    cVarA.resumeWith(Result.m158constructorimpl(objInvoke));
                }
            } finally {
                ThreadContextKt.a(context, objC);
            }
        } catch (Throwable th) {
            Result.Companion companion = Result.INSTANCE;
            cVarA.resumeWith(Result.m158constructorimpl(h.a(th)));
        }
    }

    public static final <T> void c(@NotNull l<? super c<? super T>, ? extends Object> lVar, @NotNull c<? super T> cVar) {
        c cVarA = e.a(cVar);
        try {
            Object objInvoke = ((l) y.b(lVar, 1)).invoke(cVarA);
            if (objInvoke != kotlin.coroutines.intrinsics.b.d()) {
                cVarA.resumeWith(Result.m158constructorimpl(objInvoke));
            }
        } catch (Throwable th) {
            Result.Companion companion = Result.INSTANCE;
            cVarA.resumeWith(Result.m158constructorimpl(h.a(th)));
        }
    }

    public static final <R, T> void d(@NotNull p<? super R, ? super c<? super T>, ? extends Object> pVar, R r2, @NotNull c<? super T> cVar) {
        c cVarA = e.a(cVar);
        try {
            Object objInvoke = ((p) y.b(pVar, 2)).invoke(r2, cVarA);
            if (objInvoke != kotlin.coroutines.intrinsics.b.d()) {
                cVarA.resumeWith(Result.m158constructorimpl(objInvoke));
            }
        } catch (Throwable th) {
            Result.Companion companion = Result.INSTANCE;
            cVarA.resumeWith(Result.m158constructorimpl(h.a(th)));
        }
    }

    @Nullable
    public static final <T, R> Object e(@NotNull z<? super T> zVar, R r2, @NotNull p<? super R, ? super c<? super T>, ? extends Object> pVar) throws Throwable {
        Object wVar;
        try {
            wVar = ((p) y.b(pVar, 2)).invoke(r2, zVar);
        } catch (Throwable th) {
            wVar = new w(th, false, 2, null);
        }
        if (wVar == kotlin.coroutines.intrinsics.b.d()) {
            return kotlin.coroutines.intrinsics.b.d();
        }
        Object objN0 = zVar.n0(wVar);
        if (objN0 == o1.f3878b) {
            return kotlin.coroutines.intrinsics.b.d();
        }
        if (objN0 instanceof w) {
            throw ((w) objN0).cause;
        }
        return o1.h(objN0);
    }

    @Nullable
    public static final <T, R> Object f(@NotNull z<? super T> zVar, R r2, @NotNull p<? super R, ? super c<? super T>, ? extends Object> pVar) throws Throwable {
        Object wVar;
        try {
            wVar = ((p) y.b(pVar, 2)).invoke(r2, zVar);
        } catch (Throwable th) {
            wVar = new w(th, false, 2, null);
        }
        if (wVar == kotlin.coroutines.intrinsics.b.d()) {
            return kotlin.coroutines.intrinsics.b.d();
        }
        Object objN0 = zVar.n0(wVar);
        if (objN0 == o1.f3878b) {
            return kotlin.coroutines.intrinsics.b.d();
        }
        if (objN0 instanceof w) {
            Throwable th2 = ((w) objN0).cause;
            if (((th2 instanceof TimeoutCancellationException) && ((TimeoutCancellationException) th2).coroutine == zVar) ? false : true) {
                throw th2;
            }
            if (wVar instanceof w) {
                throw ((w) wVar).cause;
            }
        } else {
            wVar = o1.h(objN0);
        }
        return wVar;
    }
}
