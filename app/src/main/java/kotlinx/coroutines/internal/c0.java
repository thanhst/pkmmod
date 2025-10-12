package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.Result;
import org.jetbrains.annotations.NotNull;

/* compiled from: StackTraceRecovery.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0003\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\"\u001c\u0010\b\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0007\"\u001c\u0010\n\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0007*\f\b\u0000\u0010\f\"\u00020\u000b2\u00020\u000b*\f\b\u0000\u0010\u000e\"\u00020\r2\u00020\r¨\u0006\u000f"}, d2 = {"", "E", "exception", "a", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "", "kotlin.jvm.PlatformType", "Ljava/lang/String;", "baseContinuationImplClassName", "b", "stackTraceRecoveryClassName", "Lkotlin/coroutines/jvm/internal/c;", "CoroutineStackFrame", "Ljava/lang/StackTraceElement;", "StackTraceElement", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class c0 {

    /* renamed from: a, reason: collision with root package name */
    private static final String f3805a;

    /* renamed from: b, reason: collision with root package name */
    private static final String f3806b;

    static {
        Object objM158constructorimpl;
        Object objM158constructorimpl2;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM158constructorimpl = Result.m158constructorimpl(Class.forName("kotlin.coroutines.jvm.internal.BaseContinuationImpl").getCanonicalName());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM158constructorimpl = Result.m158constructorimpl(kotlin.h.a(th));
        }
        if (Result.m161exceptionOrNullimpl(objM158constructorimpl) != null) {
            objM158constructorimpl = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        f3805a = (String) objM158constructorimpl;
        try {
            objM158constructorimpl2 = Result.m158constructorimpl(c0.class.getCanonicalName());
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            objM158constructorimpl2 = Result.m158constructorimpl(kotlin.h.a(th2));
        }
        if (Result.m161exceptionOrNullimpl(objM158constructorimpl2) != null) {
            objM158constructorimpl2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        f3806b = (String) objM158constructorimpl2;
    }

    @NotNull
    public static final <E extends Throwable> E a(@NotNull E e2) {
        return e2;
    }
}
