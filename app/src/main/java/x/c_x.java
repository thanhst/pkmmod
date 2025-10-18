package x;

import android.os.Trace;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: TraceApi18Impl.java */
@RequiresApi(18)
/* loaded from: classes.dex */
final class c_x {
    public static void a(@NonNull String str) {
        Trace.beginSection(str);
    }

    public static void b() {
        Trace.endSection();
    }
}
