package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.LocaleList;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.browser.customtabs.a;
import androidx.core.app.q;
import androidx.core.content.ContextCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class CustomTabsIntent {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    public final Intent f1186a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final Bundle f1187b;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface ActivityHeightResizeBehavior {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface CloseButtonPosition {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface ColorScheme {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface ShareState {
    }

    @RequiresApi(api = 24)
    private static class a {
        @Nullable
        @DoNotInline
        static String a() {
            LocaleList adjustedDefault = LocaleList.getAdjustedDefault();
            if (adjustedDefault.size() > 0) {
                return adjustedDefault.get(0).toLanguageTag();
            }
            return null;
        }
    }

    public static final class b {

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        private ArrayList<Bundle> f1190c;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        private Bundle f1191d;

        /* renamed from: e, reason: collision with root package name */
        @Nullable
        private ArrayList<Bundle> f1192e;

        /* renamed from: f, reason: collision with root package name */
        @Nullable
        private SparseArray<Bundle> f1193f;

        /* renamed from: g, reason: collision with root package name */
        @Nullable
        private Bundle f1194g;

        /* renamed from: a, reason: collision with root package name */
        private final Intent f1188a = new Intent("android.intent.action.VIEW");

        /* renamed from: b, reason: collision with root package name */
        private final a.C0009a f1189b = new a.C0009a();

        /* renamed from: h, reason: collision with root package name */
        private int f1195h = 0;

        /* renamed from: i, reason: collision with root package name */
        private boolean f1196i = true;

        public b(@Nullable f fVar) {
            if (fVar != null) {
                c(fVar);
            }
        }

        @RequiresApi(api = 24)
        private void b() {
            String strA = a.a();
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            Bundle bundleExtra = this.f1188a.hasExtra("com.android.browser.headers") ? this.f1188a.getBundleExtra("com.android.browser.headers") : new Bundle();
            if (bundleExtra.containsKey("Accept-Language")) {
                return;
            }
            bundleExtra.putString("Accept-Language", strA);
            this.f1188a.putExtra("com.android.browser.headers", bundleExtra);
        }

        private void d(@Nullable IBinder iBinder, @Nullable PendingIntent pendingIntent) {
            Bundle bundle = new Bundle();
            q.b(bundle, "android.support.customtabs.extra.SESSION", iBinder);
            if (pendingIntent != null) {
                bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", pendingIntent);
            }
            this.f1188a.putExtras(bundle);
        }

        @NonNull
        public CustomTabsIntent a() {
            if (!this.f1188a.hasExtra("android.support.customtabs.extra.SESSION")) {
                d(null, null);
            }
            ArrayList<Bundle> arrayList = this.f1190c;
            if (arrayList != null) {
                this.f1188a.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", arrayList);
            }
            ArrayList<Bundle> arrayList2 = this.f1192e;
            if (arrayList2 != null) {
                this.f1188a.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", arrayList2);
            }
            this.f1188a.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.f1196i);
            this.f1188a.putExtras(this.f1189b.a().a());
            Bundle bundle = this.f1194g;
            if (bundle != null) {
                this.f1188a.putExtras(bundle);
            }
            if (this.f1193f != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putSparseParcelableArray("androidx.browser.customtabs.extra.COLOR_SCHEME_PARAMS", this.f1193f);
                this.f1188a.putExtras(bundle2);
            }
            this.f1188a.putExtra("androidx.browser.customtabs.extra.SHARE_STATE", this.f1195h);
            if (Build.VERSION.SDK_INT >= 24) {
                b();
            }
            return new CustomTabsIntent(this.f1188a, this.f1191d);
        }

        @NonNull
        public b c(@NonNull f fVar) {
            this.f1188a.setPackage(fVar.d().getPackageName());
            d(fVar.c(), fVar.e());
            return this;
        }
    }

    CustomTabsIntent(@NonNull Intent intent, @Nullable Bundle bundle) {
        this.f1186a = intent;
        this.f1187b = bundle;
    }

    public void a(@NonNull Context context, @NonNull Uri uri) {
        this.f1186a.setData(uri);
        ContextCompat.i(context, this.f1186a, this.f1187b);
    }
}
