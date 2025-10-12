package kotlinx.coroutines.android;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.annotation.VisibleForTesting;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.h;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: HandlerDispatcher.kt */
@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0001\"\u001c\u0010\t\u001a\u0004\u0018\u00010\u00058\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0006\u0012\u0004\b\u0007\u0010\b\"\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroid/os/Looper;", "", "async", "Landroid/os/Handler;", "a", "Lkotlinx/coroutines/android/b;", "Lkotlinx/coroutines/android/b;", "getMain$annotations", "()V", "Main", "Landroid/view/Choreographer;", "choreographer", "Landroid/view/Choreographer;", "kotlinx-coroutines-android"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @JvmField
    @Nullable
    public static final b f3550a;

    @Nullable
    private static volatile Choreographer choreographer;

    static {
        Object objM158constructorimpl;
        byte b2 = 0;
        byte b3 = 0;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM158constructorimpl = Result.m158constructorimpl(new HandlerContext(a(Looper.getMainLooper(), true), b3 == true ? 1 : 0, 2, b2 == true ? 1 : 0));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM158constructorimpl = Result.m158constructorimpl(h.a(th));
        }
        f3550a = (b) (Result.m164isFailureimpl(objM158constructorimpl) ? null : objM158constructorimpl);
    }

    @VisibleForTesting
    @NotNull
    public static final Handler a(@NotNull Looper looper, boolean z2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (!z2) {
            return new Handler(looper);
        }
        if (Build.VERSION.SDK_INT < 28) {
            try {
                return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
            } catch (NoSuchMethodException unused) {
                return new Handler(looper);
            }
        }
        Object objInvoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
        if (objInvoke != null) {
            return (Handler) objInvoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.os.Handler");
    }
}
