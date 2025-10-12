package kotlinx.coroutines;

import com.facebook.internal.ServerProtocol;
import kotlin.Metadata;
import kotlin.Result;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CompletionState.kt */
@Metadata(bv = {}, d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aK\u0010\n\u001a\u0004\u0018\u00010\t\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012%\b\u0002\u0010\b\u001a\u001f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002H\u0000ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a0\u0010\u000e\u001a\u0004\u0018\u00010\t\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\fH\u0000ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a6\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"T", "Lkotlin/Result;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlin/t;", "onCancellation", "", "c", "(Ljava/lang/Object;Lp0/l;)Ljava/lang/Object;", "Lkotlinx/coroutines/k;", "caller", "b", "(Ljava/lang/Object;Lkotlinx/coroutines/k;)Ljava/lang/Object;", ServerProtocol.DIALOG_PARAM_STATE, "Lkotlin/coroutines/c;", "uCont", "a", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class z {
    @NotNull
    public static final <T> Object a(@Nullable Object obj, @NotNull kotlin.coroutines.c<? super T> cVar) {
        if (!(obj instanceof w)) {
            return Result.m158constructorimpl(obj);
        }
        Result.Companion companion = Result.INSTANCE;
        return Result.m158constructorimpl(kotlin.h.a(((w) obj).cause));
    }

    @Nullable
    public static final <T> Object b(@NotNull Object obj, @NotNull k<?> kVar) {
        Throwable thM161exceptionOrNullimpl = Result.m161exceptionOrNullimpl(obj);
        return thM161exceptionOrNullimpl == null ? obj : new w(thM161exceptionOrNullimpl, false, 2, null);
    }

    @Nullable
    public static final <T> Object c(@NotNull Object obj, @Nullable p0.l<? super Throwable, kotlin.t> lVar) {
        Throwable thM161exceptionOrNullimpl = Result.m161exceptionOrNullimpl(obj);
        return thM161exceptionOrNullimpl == null ? lVar != null ? new CompletedWithCancellation(obj, lVar) : obj : new w(thM161exceptionOrNullimpl, false, 2, null);
    }

    public static /* synthetic */ Object d(Object obj, p0.l lVar, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            lVar = null;
        }
        return c(obj, lVar);
    }
}
