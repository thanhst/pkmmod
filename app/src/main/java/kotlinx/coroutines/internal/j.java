package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.Result;

/* compiled from: FastServiceLoader.kt */
@Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0005\"\u001a\u0010\u0004\u001a\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0001\u0010\u0003¨\u0006\u0005"}, d2 = {"", "a", "Z", "()Z", "ANDROID_DETECTED", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f3822a;

    static {
        Object objM158constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM158constructorimpl = Result.m158constructorimpl(Class.forName("android.os.Build"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM158constructorimpl = Result.m158constructorimpl(kotlin.h.a(th));
        }
        f3822a = Result.m165isSuccessimpl(objM158constructorimpl);
    }

    public static final boolean a() {
        return f3822a;
    }
}
