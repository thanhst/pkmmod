package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import java.util.List;

/* compiled from: CustomTabsSession.java */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private final Object f1240a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private final a.b f1241b;

    /* renamed from: c, reason: collision with root package name */
    private final a.a f1242c;

    /* renamed from: d, reason: collision with root package name */
    private final ComponentName f1243d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private final PendingIntent f1244e;

    f(a.b bVar, a.a aVar, ComponentName componentName, @Nullable PendingIntent pendingIntent) {
        this.f1241b = bVar;
        this.f1242c = aVar;
        this.f1243d = componentName;
        this.f1244e = pendingIntent;
    }

    private void a(Bundle bundle) {
        PendingIntent pendingIntent = this.f1244e;
        if (pendingIntent != null) {
            bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", pendingIntent);
        }
    }

    private Bundle b(@Nullable Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        a(bundle2);
        return bundle2;
    }

    IBinder c() {
        return this.f1242c.asBinder();
    }

    ComponentName d() {
        return this.f1243d;
    }

    @Nullable
    PendingIntent e() {
        return this.f1244e;
    }

    public boolean f(@Nullable Uri uri, @Nullable Bundle bundle, @Nullable List<Bundle> list) {
        try {
            return this.f1241b.j(this.f1242c, uri, b(bundle), list);
        } catch (RemoteException unused) {
            return false;
        }
    }
}
