package androidx.core.os;

import android.os.Build;
import android.os.LocaleList;
import androidx.annotation.DoNotInline;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.Locale;

/* compiled from: LocaleListCompat.java */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: b, reason: collision with root package name */
    private static final g f1557b = a(new Locale[0]);

    /* renamed from: a, reason: collision with root package name */
    private final i f1558a;

    /* compiled from: LocaleListCompat.java */
    @RequiresApi(21)
    static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final Locale[] f1559a = {new Locale("en", "XA"), new Locale("ar", "XB")};

        @DoNotInline
        static Locale a(String str) {
            return Locale.forLanguageTag(str);
        }

        private static boolean b(Locale locale) {
            for (Locale locale2 : f1559a) {
                if (locale2.equals(locale)) {
                    return true;
                }
            }
            return false;
        }

        @DoNotInline
        static boolean c(@NonNull Locale locale, @NonNull Locale locale2) {
            if (locale.equals(locale2)) {
                return true;
            }
            if (!locale.getLanguage().equals(locale2.getLanguage()) || b(locale) || b(locale2)) {
                return false;
            }
            String strC = androidx.core.text.b.c(locale);
            if (!strC.isEmpty()) {
                return strC.equals(androidx.core.text.b.c(locale2));
            }
            String country = locale.getCountry();
            return country.isEmpty() || country.equals(locale2.getCountry());
        }
    }

    /* compiled from: LocaleListCompat.java */
    @RequiresApi(24)
    static class b {
        @DoNotInline
        static LocaleList a(Locale... localeArr) {
            return new LocaleList(localeArr);
        }

        @DoNotInline
        static LocaleList b() {
            return LocaleList.getAdjustedDefault();
        }

        @DoNotInline
        static LocaleList c() {
            return LocaleList.getDefault();
        }
    }

    private g(i iVar) {
        this.f1558a = iVar;
    }

    @NonNull
    public static g a(@NonNull Locale... localeArr) {
        return Build.VERSION.SDK_INT >= 24 ? i(b.a(localeArr)) : new g(new h(localeArr));
    }

    static Locale b(String str) {
        if (str.contains("-")) {
            String[] strArrSplit = str.split("-", -1);
            if (strArrSplit.length > 2) {
                return new Locale(strArrSplit[0], strArrSplit[1], strArrSplit[2]);
            }
            if (strArrSplit.length > 1) {
                return new Locale(strArrSplit[0], strArrSplit[1]);
            }
            if (strArrSplit.length == 1) {
                return new Locale(strArrSplit[0]);
            }
        } else {
            if (!str.contains("_")) {
                return new Locale(str);
            }
            String[] strArrSplit2 = str.split("_", -1);
            if (strArrSplit2.length > 2) {
                return new Locale(strArrSplit2[0], strArrSplit2[1], strArrSplit2[2]);
            }
            if (strArrSplit2.length > 1) {
                return new Locale(strArrSplit2[0], strArrSplit2[1]);
            }
            if (strArrSplit2.length == 1) {
                return new Locale(strArrSplit2[0]);
            }
        }
        throw new IllegalArgumentException("Can not parse language tag: [" + str + "]");
    }

    @NonNull
    public static g c(@Nullable String str) {
        if (str == null || str.isEmpty()) {
            return e();
        }
        String[] strArrSplit = str.split(",", -1);
        int length = strArrSplit.length;
        Locale[] localeArr = new Locale[length];
        for (int i2 = 0; i2 < length; i2++) {
            localeArr[i2] = Build.VERSION.SDK_INT >= 21 ? a.a(strArrSplit[i2]) : b(strArrSplit[i2]);
        }
        return a(localeArr);
    }

    @NonNull
    public static g e() {
        return f1557b;
    }

    @NonNull
    @RequiresApi(24)
    public static g i(@NonNull LocaleList localeList) {
        return new g(new j(localeList));
    }

    @Nullable
    public Locale d(int i2) {
        return this.f1558a.get(i2);
    }

    public boolean equals(Object obj) {
        return (obj instanceof g) && this.f1558a.equals(((g) obj).f1558a);
    }

    public boolean f() {
        return this.f1558a.isEmpty();
    }

    @IntRange(from = 0)
    public int g() {
        return this.f1558a.size();
    }

    @NonNull
    public String h() {
        return this.f1558a.a();
    }

    public int hashCode() {
        return this.f1558a.hashCode();
    }

    @NonNull
    public String toString() {
        return this.f1558a.toString();
    }
}
