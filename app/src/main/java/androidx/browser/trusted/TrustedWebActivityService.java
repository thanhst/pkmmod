package androidx.browser.trusted;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import androidx.annotation.BinderThread;
import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.annotation.RestrictTo;
import androidx.core.app.w;
import b.b_b;
import java.util.Locale;
import k.g_k;

/* loaded from: classes.dex */
public abstract class TrustedWebActivityService extends Service {

    /* renamed from: e, reason: collision with root package name */
    private NotificationManager f1249e;

    /* renamed from: f, reason: collision with root package name */
    int f1250f = -1;

    /* renamed from: g, reason: collision with root package name */
    private final b_b.a f1251g = new a();

    class a extends b_b.a {
        a() {
        }

        private void C() {
            TrustedWebActivityService trustedWebActivityService = TrustedWebActivityService.this;
            if (trustedWebActivityService.f1250f == -1) {
                trustedWebActivityService.getPackageManager().getPackagesForUid(Binder.getCallingUid());
                TrustedWebActivityService.this.c().a();
                TrustedWebActivityService.this.getPackageManager();
            }
            if (TrustedWebActivityService.this.f1250f != Binder.getCallingUid()) {
                throw new SecurityException("Caller is not verified as Trusted Web Activity provider.");
            }
        }

        @Override // b.b
        public int b() {
            C();
            return TrustedWebActivityService.this.i();
        }

        @Override // b.b
        public Bundle c() {
            C();
            return TrustedWebActivityService.this.h();
        }

        @Override // b.b
        public Bundle d(Bundle bundle) {
            C();
            return new d.e(TrustedWebActivityService.this.d(d.c.a(bundle).f1257a)).a();
        }

        @Override // b.b
        public Bundle h() {
            C();
            return new d.a(TrustedWebActivityService.this.g()).a();
        }

        @Override // b.b
        public void k(Bundle bundle) {
            C();
            d.b bVarA = d.b.a(bundle);
            TrustedWebActivityService.this.e(bVarA.f1255a, bVarA.f1256b);
        }

        @Override // b.b
        @RequiresPermission("android.permission.POST_NOTIFICATIONS")
        public Bundle l(Bundle bundle) {
            C();
            d.C0012d c0012dA = d.C0012d.a(bundle);
            return new d.e(TrustedWebActivityService.this.j(c0012dA.f1258a, c0012dA.f1259b, c0012dA.f1260c, c0012dA.f1261d)).a();
        }

        @Override // b.b
        public Bundle s(String str, Bundle bundle, IBinder iBinder) {
            C();
            return TrustedWebActivityService.this.f(str, bundle, c.a(iBinder));
        }
    }

    private static String a(String str) {
        return str.toLowerCase(Locale.ROOT).replace(' ', '_') + "_channel_id";
    }

    private void b() {
        if (this.f1249e == null) {
            throw new IllegalStateException("TrustedWebActivityService has not been properly initialized. Did onCreate() call super.onCreate()?");
        }
    }

    @NonNull
    @BinderThread
    public abstract g_k c();

    @BinderThread
    public boolean d(@NonNull String str) {
        b();
        if (!w.b(this).a()) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 26) {
            return true;
        }
        return b_b.b(this.f1249e, a(str));
    }

    @BinderThread
    public void e(@NonNull String str, int i2) {
        b();
        this.f1249e.cancel(str, i2);
    }

    @Nullable
    @BinderThread
    public Bundle f(@NonNull String str, @NonNull Bundle bundle, @Nullable c cVar) {
        return null;
    }

    @NonNull
    @BinderThread
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Parcelable[] g() {
        b();
        if (Build.VERSION.SDK_INT >= 23) {
            return androidx.browser.trusted.a.a(this.f1249e);
        }
        throw new IllegalStateException("onGetActiveNotifications cannot be called pre-M.");
    }

    @NonNull
    @BinderThread
    public Bundle h() {
        int i2 = i();
        Bundle bundle = new Bundle();
        if (i2 == -1) {
            return bundle;
        }
        bundle.putParcelable("android.support.customtabs.trusted.SMALL_ICON_BITMAP", BitmapFactory.decodeResource(getResources(), i2));
        return bundle;
    }

    @BinderThread
    public int i() {
        try {
            Bundle bundle = getPackageManager().getServiceInfo(new ComponentName(this, getClass()), 128).metaData;
            if (bundle == null) {
                return -1;
            }
            return bundle.getInt("android.support.customtabs.trusted.SMALL_ICON", -1);
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    @BinderThread
    @RequiresPermission("android.permission.POST_NOTIFICATIONS")
    public boolean j(@NonNull String str, int i2, @NonNull Notification notification, @NonNull String str2) {
        b();
        if (!w.b(this).a()) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            String strA = a(str2);
            notification = b_b.a(this, this.f1249e, notification, strA, str2);
            if (!b_b.b(this.f1249e, strA)) {
                return false;
            }
        }
        this.f1249e.notify(str, i2, notification);
        return true;
    }

    @Override // android.app.Service
    @Nullable
    @MainThread
    public final IBinder onBind(@Nullable Intent intent) {
        return this.f1251g;
    }

    @Override // android.app.Service
    @CallSuper
    @MainThread
    public void onCreate() {
        super.onCreate();
        this.f1249e = (NotificationManager) getSystemService("notification");
    }

    @Override // android.app.Service
    @MainThread
    public final boolean onUnbind(@Nullable Intent intent) {
        this.f1250f = -1;
        return super.onUnbind(intent);
    }
}
