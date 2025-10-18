package x;

import android.annotation.SuppressLint;
import android.os.Trace;
import android.util.Log;
import androidx.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: Trace.java */
/* loaded from: classes.dex */
public final class b_x {

    /* renamed from: a, reason: collision with root package name */
    private static long f4157a;

    /* renamed from: b, reason: collision with root package name */
    private static Method f4158b;

    public static void a(@NonNull String str) {
        c_x.a(str);
    }

    public static void b() {
        c_x.b();
    }

    private static void c(@NonNull String str, @NonNull Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (!(cause instanceof RuntimeException)) {
                throw new RuntimeException(cause);
            }
            throw ((RuntimeException) cause);
        }
        Log.v("Trace", "Unable to call " + str + " via reflection", exc);
    }

    @SuppressLint({"NewApi"})
    public static boolean d() {
        try {
            if (f4158b == null) {
                return Trace.isEnabled();
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        return e();
    }

    private static boolean e() {
        try {
            if (f4158b == null) {
                f4157a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                f4158b = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) f4158b.invoke(null, Long.valueOf(f4157a))).booleanValue();
        } catch (Exception e2) {
            c("isTagEnabled", e2);
            return false;
        }
    }
}
