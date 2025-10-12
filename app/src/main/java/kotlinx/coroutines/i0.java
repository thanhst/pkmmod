package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import org.jetbrains.annotations.NotNull;

/* compiled from: DebugStrings.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\u001a\u0010\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0000H\u0000\"\u0018\u0010\u0006\u001a\u00020\u0001*\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0018\u0010\b\u001a\u00020\u0001*\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\t"}, d2 = {"Lkotlin/coroutines/c;", "", "c", "", "b", "(Ljava/lang/Object;)Ljava/lang/String;", "hexAddress", "a", "classSimpleName", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class i0 {
    @NotNull
    public static final String a(@NotNull Object obj) {
        return obj.getClass().getSimpleName();
    }

    @NotNull
    public static final String b(@NotNull Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    @NotNull
    public static final String c(@NotNull kotlin.coroutines.c<?> cVar) {
        Object objM158constructorimpl;
        if (cVar instanceof kotlinx.coroutines.internal.g) {
            return cVar.toString();
        }
        try {
            Result.Companion aVar = Result.INSTANCE;
            objM158constructorimpl = Result.m158constructorimpl(cVar + '@' + b(cVar));
        } catch (Throwable th) {
            Result.Companion aVar2 = Result.INSTANCE;
            objM158constructorimpl = Result.m158constructorimpl(kotlin.h.a(th));
        }
        if (Result.m161exceptionOrNullimpl(objM158constructorimpl) != null) {
            objM158constructorimpl = ((Object) cVar.getClass().getName()) + '@' + b(cVar);
        }
        return (String) objM158constructorimpl;
    }
}
