package androidx.browser.trusted;

import android.app.Notification;
import android.os.Bundle;
import android.os.Parcelable;

/* compiled from: TrustedWebActivityServiceConnection.java */
/* loaded from: classes.dex */
public final class d {

    /* compiled from: TrustedWebActivityServiceConnection.java */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        public final Parcelable[] f1254a;

        a(Parcelable[] parcelableArr) {
            this.f1254a = parcelableArr;
        }

        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putParcelableArray("android.support.customtabs.trusted.ACTIVE_NOTIFICATIONS", this.f1254a);
            return bundle;
        }
    }

    /* compiled from: TrustedWebActivityServiceConnection.java */
    static class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f1255a;

        /* renamed from: b, reason: collision with root package name */
        public final int f1256b;

        b(String str, int i2) {
            this.f1255a = str;
            this.f1256b = i2;
        }

        public static b a(Bundle bundle) {
            d.a(bundle, "android.support.customtabs.trusted.PLATFORM_TAG");
            d.a(bundle, "android.support.customtabs.trusted.PLATFORM_ID");
            return new b(bundle.getString("android.support.customtabs.trusted.PLATFORM_TAG"), bundle.getInt("android.support.customtabs.trusted.PLATFORM_ID"));
        }
    }

    /* compiled from: TrustedWebActivityServiceConnection.java */
    static class c {

        /* renamed from: a, reason: collision with root package name */
        public final String f1257a;

        c(String str) {
            this.f1257a = str;
        }

        public static c a(Bundle bundle) {
            d.a(bundle, "android.support.customtabs.trusted.CHANNEL_NAME");
            return new c(bundle.getString("android.support.customtabs.trusted.CHANNEL_NAME"));
        }
    }

    /* compiled from: TrustedWebActivityServiceConnection.java */
    /* renamed from: androidx.browser.trusted.d$d, reason: collision with other inner class name */
    static class C0012d {

        /* renamed from: a, reason: collision with root package name */
        public final String f1258a;

        /* renamed from: b, reason: collision with root package name */
        public final int f1259b;

        /* renamed from: c, reason: collision with root package name */
        public final Notification f1260c;

        /* renamed from: d, reason: collision with root package name */
        public final String f1261d;

        C0012d(String str, int i2, Notification notification, String str2) {
            this.f1258a = str;
            this.f1259b = i2;
            this.f1260c = notification;
            this.f1261d = str2;
        }

        public static C0012d a(Bundle bundle) {
            d.a(bundle, "android.support.customtabs.trusted.PLATFORM_TAG");
            d.a(bundle, "android.support.customtabs.trusted.PLATFORM_ID");
            d.a(bundle, "android.support.customtabs.trusted.NOTIFICATION");
            d.a(bundle, "android.support.customtabs.trusted.CHANNEL_NAME");
            return new C0012d(bundle.getString("android.support.customtabs.trusted.PLATFORM_TAG"), bundle.getInt("android.support.customtabs.trusted.PLATFORM_ID"), (Notification) bundle.getParcelable("android.support.customtabs.trusted.NOTIFICATION"), bundle.getString("android.support.customtabs.trusted.CHANNEL_NAME"));
        }
    }

    /* compiled from: TrustedWebActivityServiceConnection.java */
    static class e {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f1262a;

        e(boolean z2) {
            this.f1262a = z2;
        }

        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putBoolean("android.support.customtabs.trusted.NOTIFICATION_SUCCESS", this.f1262a);
            return bundle;
        }
    }

    static void a(Bundle bundle, String str) {
        if (bundle.containsKey(str)) {
            return;
        }
        throw new IllegalArgumentException("Bundle must contain " + str);
    }
}
