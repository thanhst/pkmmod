package androidx.core.app;

import android.os.Bundle;
import android.os.IBinder;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* compiled from: BundleCompat.java */
/* loaded from: classes.dex */
public final class q {

    /* compiled from: BundleCompat.java */
    @RequiresApi(18)
    static class a {
        @DoNotInline
        static IBinder a(Bundle bundle, String str) {
            return bundle.getBinder(str);
        }

        @DoNotInline
        static void b(Bundle bundle, String str, IBinder iBinder) {
            bundle.putBinder(str, iBinder);
        }
    }

    @Nullable
    public static IBinder a(@NonNull Bundle bundle, @Nullable String str) {
        return a.a(bundle, str);
    }

    public static void b(@NonNull Bundle bundle, @Nullable String str, @Nullable IBinder iBinder) {
        a.b(bundle, str, iBinder);
    }
}
