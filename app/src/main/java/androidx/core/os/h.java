package androidx.core.os;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;

/* compiled from: LocaleListCompatWrapper.java */
/* loaded from: classes.dex */
final class h implements i {

    /* renamed from: c, reason: collision with root package name */
    private static final Locale[] f1560c = new Locale[0];

    /* renamed from: d, reason: collision with root package name */
    private static final Locale f1561d = new Locale("en", "XA");

    /* renamed from: e, reason: collision with root package name */
    private static final Locale f1562e = new Locale("ar", "XB");

    /* renamed from: f, reason: collision with root package name */
    private static final Locale f1563f = g.b("en-Latn");

    /* renamed from: a, reason: collision with root package name */
    private final Locale[] f1564a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private final String f1565b;

    h(@NonNull Locale... localeArr) {
        if (localeArr.length == 0) {
            this.f1564a = f1560c;
            this.f1565b = "";
            return;
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < localeArr.length; i2++) {
            Locale locale = localeArr[i2];
            if (locale == null) {
                throw new NullPointerException("list[" + i2 + "] is null");
            }
            if (!hashSet.contains(locale)) {
                Locale locale2 = (Locale) locale.clone();
                arrayList.add(locale2);
                c(sb, locale2);
                if (i2 < localeArr.length - 1) {
                    sb.append(',');
                }
                hashSet.add(locale2);
            }
        }
        this.f1564a = (Locale[]) arrayList.toArray(new Locale[0]);
        this.f1565b = sb.toString();
    }

    @VisibleForTesting
    static void c(StringBuilder sb, Locale locale) {
        sb.append(locale.getLanguage());
        String country = locale.getCountry();
        if (country == null || country.isEmpty()) {
            return;
        }
        sb.append('-');
        sb.append(locale.getCountry());
    }

    @Override // androidx.core.os.i
    public String a() {
        return this.f1565b;
    }

    @Override // androidx.core.os.i
    @Nullable
    public Object b() {
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        Locale[] localeArr = ((h) obj).f1564a;
        if (this.f1564a.length != localeArr.length) {
            return false;
        }
        int i2 = 0;
        while (true) {
            Locale[] localeArr2 = this.f1564a;
            if (i2 >= localeArr2.length) {
                return true;
            }
            if (!localeArr2[i2].equals(localeArr[i2])) {
                return false;
            }
            i2++;
        }
    }

    @Override // androidx.core.os.i
    public Locale get(int i2) {
        if (i2 >= 0) {
            Locale[] localeArr = this.f1564a;
            if (i2 < localeArr.length) {
                return localeArr[i2];
            }
        }
        return null;
    }

    public int hashCode() {
        int iHashCode = 1;
        for (Locale locale : this.f1564a) {
            iHashCode = (iHashCode * 31) + locale.hashCode();
        }
        return iHashCode;
    }

    @Override // androidx.core.os.i
    public boolean isEmpty() {
        return this.f1564a.length == 0;
    }

    @Override // androidx.core.os.i
    public int size() {
        return this.f1564a.length;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int i2 = 0;
        while (true) {
            Locale[] localeArr = this.f1564a;
            if (i2 >= localeArr.length) {
                sb.append("]");
                return sb.toString();
            }
            sb.append(localeArr[i2]);
            if (i2 < this.f1564a.length - 1) {
                sb.append(',');
            }
            i2++;
        }
    }
}
