package androidx.core.util;

import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.Objects;

/* compiled from: ObjectsCompat.java */
/* loaded from: classes.dex */
public class c {

    /* compiled from: ObjectsCompat.java */
    @RequiresApi(19)
    static class a {
        @DoNotInline
        static boolean a(Object obj, Object obj2) {
            return Objects.equals(obj, obj2);
        }

        @DoNotInline
        static int b(Object... objArr) {
            return Objects.hash(objArr);
        }
    }

    public static boolean a(@Nullable Object obj, @Nullable Object obj2) {
        return a.a(obj, obj2);
    }

    public static int b(@Nullable Object... objArr) {
        return a.b(objArr);
    }

    @NonNull
    public static <T> T c(@Nullable T t2, @NonNull String str) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(str);
    }

    @Nullable
    public static String d(@Nullable Object obj, @Nullable String str) {
        return obj != null ? obj.toString() : str;
    }
}
