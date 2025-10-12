package androidx.core.text;

import android.annotation.SuppressLint;
import android.icu.util.ULocale;
import android.os.Build;
import android.util.Log;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* compiled from: ICUCompat.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static Method f1619a;

    /* renamed from: b, reason: collision with root package name */
    private static Method f1620b;

    /* compiled from: ICUCompat.java */
    @RequiresApi(21)
    static class a {
        @DoNotInline
        static String a(Locale locale) {
            return locale.getScript();
        }
    }

    /* compiled from: ICUCompat.java */
    @RequiresApi(24)
    /* renamed from: androidx.core.text.b$b, reason: collision with other inner class name */
    static class C0019b {
        @DoNotInline
        static ULocale a(Object obj) {
            return ULocale.addLikelySubtags((ULocale) obj);
        }

        @DoNotInline
        static ULocale b(Locale locale) {
            return ULocale.forLocale(locale);
        }

        @DoNotInline
        static String c(Object obj) {
            return ((ULocale) obj).getScript();
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            if (i2 < 24) {
                try {
                    f1620b = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", Locale.class);
                    return;
                } catch (Exception e2) {
                    throw new IllegalStateException(e2);
                }
            }
            return;
        }
        try {
            Class<?> cls = Class.forName("libcore.icu.ICU");
            f1619a = cls.getMethod("getScript", String.class);
            f1620b = cls.getMethod("addLikelySubtags", String.class);
        } catch (Exception e3) {
            f1619a = null;
            f1620b = null;
            Log.w("ICUCompat", e3);
        }
    }

    @SuppressLint({"BanUncheckedReflection"})
    private static String a(Locale locale) {
        String string = locale.toString();
        try {
            Method method = f1620b;
            if (method != null) {
                return (String) method.invoke(null, string);
            }
        } catch (IllegalAccessException e2) {
            Log.w("ICUCompat", e2);
        } catch (InvocationTargetException e3) {
            Log.w("ICUCompat", e3);
        }
        return string;
    }

    @SuppressLint({"BanUncheckedReflection"})
    private static String b(String str) {
        try {
            Method method = f1619a;
            if (method != null) {
                return (String) method.invoke(null, str);
            }
        } catch (IllegalAccessException e2) {
            Log.w("ICUCompat", e2);
        } catch (InvocationTargetException e3) {
            Log.w("ICUCompat", e3);
        }
        return null;
    }

    @Nullable
    public static String c(@NonNull Locale locale) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 24) {
            return C0019b.c(C0019b.a(C0019b.b(locale)));
        }
        if (i2 < 21) {
            String strA = a(locale);
            if (strA != null) {
                return b(strA);
            }
            return null;
        }
        try {
            return a.a((Locale) f1620b.invoke(null, locale));
        } catch (IllegalAccessException e2) {
            Log.w("ICUCompat", e2);
            return a.a(locale);
        } catch (InvocationTargetException e3) {
            Log.w("ICUCompat", e3);
            return a.a(locale);
        }
    }
}
