package androidx.core.os;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Method;

/* compiled from: TraceCompat.java */
@Deprecated
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    private static long f1567a;

    /* renamed from: b, reason: collision with root package name */
    private static Method f1568b;

    /* renamed from: c, reason: collision with root package name */
    private static Method f1569c;

    /* renamed from: d, reason: collision with root package name */
    private static Method f1570d;

    /* renamed from: e, reason: collision with root package name */
    private static Method f1571e;

    /* compiled from: TraceCompat.java */
    @RequiresApi(18)
    static class a {
        @DoNotInline
        static void a(String str) {
            Trace.beginSection(str);
        }

        @DoNotInline
        static void b() {
            Trace.endSection();
        }
    }

    static {
        if (Build.VERSION.SDK_INT < 29) {
            try {
                f1567a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                Class cls = Long.TYPE;
                f1568b = Trace.class.getMethod("isTagEnabled", cls);
                Class cls2 = Integer.TYPE;
                f1569c = Trace.class.getMethod("asyncTraceBegin", cls, String.class, cls2);
                f1570d = Trace.class.getMethod("asyncTraceEnd", cls, String.class, cls2);
                f1571e = Trace.class.getMethod("traceCounter", cls, String.class, cls2);
            } catch (Exception e2) {
                Log.i("TraceCompat", "Unable to initialize via reflection.", e2);
            }
        }
    }

    public static void a(@NonNull String str) {
        a.a(str);
    }

    public static void b() {
        a.b();
    }
}
