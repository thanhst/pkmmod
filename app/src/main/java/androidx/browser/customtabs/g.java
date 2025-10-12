package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: CustomTabsSessionToken.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    final a.a f1245a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private final PendingIntent f1246b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private final b f1247c;

    /* compiled from: CustomTabsSessionToken.java */
    class a extends b {
        a() {
        }

        @Override // androidx.browser.customtabs.b
        public void a(@NonNull String str, @Nullable Bundle bundle) {
            try {
                g.this.f1245a.i(str, bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }

        @Override // androidx.browser.customtabs.b
        @NonNull
        public Bundle b(@NonNull String str, @Nullable Bundle bundle) {
            try {
                return g.this.f1245a.p(str, bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
                return null;
            }
        }

        @Override // androidx.browser.customtabs.b
        public void c(int i2, int i3, @NonNull Bundle bundle) {
            try {
                g.this.f1245a.a(i2, i3, bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }

        @Override // androidx.browser.customtabs.b
        public void d(@Nullable Bundle bundle) {
            try {
                g.this.f1245a.w(bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }

        @Override // androidx.browser.customtabs.b
        public void e(int i2, @Nullable Bundle bundle) {
            try {
                g.this.f1245a.m(i2, bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }

        @Override // androidx.browser.customtabs.b
        public void f(@NonNull String str, @Nullable Bundle bundle) {
            try {
                g.this.f1245a.u(str, bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }

        @Override // androidx.browser.customtabs.b
        public void g(int i2, @NonNull Uri uri, boolean z2, @Nullable Bundle bundle) {
            try {
                g.this.f1245a.y(i2, uri, z2, bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }
    }

    g(@Nullable a.a aVar, @Nullable PendingIntent pendingIntent) {
        if (aVar == null && pendingIntent == null) {
            throw new IllegalStateException("CustomTabsSessionToken must have either a session id or a callback (or both).");
        }
        this.f1245a = aVar;
        this.f1246b = pendingIntent;
        this.f1247c = aVar == null ? null : new a();
    }

    private IBinder b() {
        a.a aVar = this.f1245a;
        if (aVar != null) {
            return aVar.asBinder();
        }
        throw new IllegalStateException("CustomTabSessionToken must have valid binder or pending session");
    }

    @Nullable
    IBinder a() {
        a.a aVar = this.f1245a;
        if (aVar == null) {
            return null;
        }
        return aVar.asBinder();
    }

    @Nullable
    PendingIntent c() {
        return this.f1246b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        PendingIntent pendingIntentC = gVar.c();
        PendingIntent pendingIntent = this.f1246b;
        if ((pendingIntent == null) != (pendingIntentC == null)) {
            return false;
        }
        return pendingIntent != null ? pendingIntent.equals(pendingIntentC) : b().equals(gVar.b());
    }

    public int hashCode() {
        PendingIntent pendingIntent = this.f1246b;
        return pendingIntent != null ? pendingIntent.hashCode() : b().hashCode();
    }
}
