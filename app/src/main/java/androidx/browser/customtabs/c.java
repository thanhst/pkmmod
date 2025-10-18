package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: CustomTabsClient.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final a.b f1210a;

    /* renamed from: b, reason: collision with root package name */
    private final ComponentName f1211b;

    /* renamed from: c, reason: collision with root package name */
    private final Context f1212c;

    /* compiled from: CustomTabsClient.java */
    class a extends e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f1213a;

        a(Context context) {
            this.f1213a = context;
        }

        @Override // androidx.browser.customtabs.e
        public final void onCustomTabsServiceConnected(@NonNull ComponentName componentName, @NonNull c cVar) {
            cVar.f(0L);
            this.f1213a.unbindService(this);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* compiled from: CustomTabsClient.java */
    class b extends a.AbstractBinderC0000a {

        /* renamed from: a, reason: collision with root package name */
        private Handler f1214a = new Handler(Looper.getMainLooper());

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ androidx.browser.customtabs.b f1215b;

        /* compiled from: CustomTabsClient.java */
        class a implements Runnable {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f1217e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ Bundle f1218f;

            a(int i2, Bundle bundle) {
                this.f1217e = i2;
                this.f1218f = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f1215b.e(this.f1217e, this.f1218f);
            }
        }

        /* compiled from: CustomTabsClient.java */
        /* renamed from: androidx.browser.customtabs.c$b$b, reason: collision with other inner class name */
        class RunnableC0010b implements Runnable {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f1220e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ Bundle f1221f;

            RunnableC0010b(String str, Bundle bundle) {
                this.f1220e = str;
                this.f1221f = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f1215b.a(this.f1220e, this.f1221f);
            }
        }

        /* compiled from: CustomTabsClient.java */
        /* renamed from: androidx.browser.customtabs.c$b$c, reason: collision with other inner class name */
        class RunnableC0011c implements Runnable {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Bundle f1223e;

            RunnableC0011c(Bundle bundle) {
                this.f1223e = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f1215b.d(this.f1223e);
            }
        }

        /* compiled from: CustomTabsClient.java */
        class d implements Runnable {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f1225e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ Bundle f1226f;

            d(String str, Bundle bundle) {
                this.f1225e = str;
                this.f1226f = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f1215b.f(this.f1225e, this.f1226f);
            }
        }

        /* compiled from: CustomTabsClient.java */
        class e implements Runnable {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f1228e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ Uri f1229f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ boolean f1230g;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ Bundle f1231h;

            e(int i2, Uri uri, boolean z2, Bundle bundle) {
                this.f1228e = i2;
                this.f1229f = uri;
                this.f1230g = z2;
                this.f1231h = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f1215b.g(this.f1228e, this.f1229f, this.f1230g, this.f1231h);
            }
        }

        /* compiled from: CustomTabsClient.java */
        class f implements Runnable {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f1233e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f1234f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ Bundle f1235g;

            f(int i2, int i3, Bundle bundle) {
                this.f1233e = i2;
                this.f1234f = i3;
                this.f1235g = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f1215b.c(this.f1233e, this.f1234f, this.f1235g);
            }
        }

        b(androidx.browser.customtabs.b bVar) {
            this.f1215b = bVar;
        }

        @Override // a.a
        public void a(int i2, int i3, @Nullable Bundle bundle) throws RemoteException {
            if (this.f1215b == null) {
                return;
            }
            this.f1214a.post(new f(i2, i3, bundle));
        }

        @Override // a.a
        public void i(String str, Bundle bundle) throws RemoteException {
            if (this.f1215b == null) {
                return;
            }
            this.f1214a.post(new RunnableC0010b(str, bundle));
        }

        @Override // a.a
        public void m(int i2, Bundle bundle) {
            if (this.f1215b == null) {
                return;
            }
            this.f1214a.post(new a(i2, bundle));
        }

        @Override // a.a
        public Bundle p(@NonNull String str, @Nullable Bundle bundle) throws RemoteException {
            androidx.browser.customtabs.b bVar = this.f1215b;
            if (bVar == null) {
                return null;
            }
            return bVar.b(str, bundle);
        }

        @Override // a.a
        public void u(String str, Bundle bundle) throws RemoteException {
            if (this.f1215b == null) {
                return;
            }
            this.f1214a.post(new d(str, bundle));
        }

        @Override // a.a
        public void w(Bundle bundle) throws RemoteException {
            if (this.f1215b == null) {
                return;
            }
            this.f1214a.post(new RunnableC0011c(bundle));
        }

        @Override // a.a
        public void y(int i2, Uri uri, boolean z2, @Nullable Bundle bundle) throws RemoteException {
            if (this.f1215b == null) {
                return;
            }
            this.f1214a.post(new e(i2, uri, z2, bundle));
        }
    }

    c(a.b bVar, ComponentName componentName, Context context) {
        this.f1210a = bVar;
        this.f1211b = componentName;
        this.f1212c = context;
    }

    public static boolean a(@NonNull Context context, @Nullable String str, @NonNull e eVar) {
        eVar.setApplicationContext(context.getApplicationContext());
        Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
        if (!TextUtils.isEmpty(str)) {
            intent.setPackage(str);
        }
        return context.bindService(intent, eVar, 33);
    }

    public static boolean b(@NonNull Context context, @NonNull String str) {
        if (str == null) {
            return false;
        }
        Context applicationContext = context.getApplicationContext();
        try {
            return a(applicationContext, str, new a(applicationContext));
        } catch (SecurityException unused) {
            return false;
        }
    }

    private a.AbstractBinderC0000a c(@Nullable androidx.browser.customtabs.b bVar) {
        return new b(bVar);
    }

    @Nullable
    private f e(@Nullable androidx.browser.customtabs.b bVar, @Nullable PendingIntent pendingIntent) {
        boolean zR;
        a.AbstractBinderC0000a abstractBinderC0000aC = c(bVar);
        try {
            if (pendingIntent != null) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", pendingIntent);
                zR = this.f1210a.z(abstractBinderC0000aC, bundle);
            } else {
                zR = this.f1210a.r(abstractBinderC0000aC);
            }
            if (zR) {
                return new f(this.f1210a, abstractBinderC0000aC, this.f1211b, pendingIntent);
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Nullable
    public f d(@Nullable androidx.browser.customtabs.b bVar) {
        return e(bVar, null);
    }

    public boolean f(long j2) {
        try {
            return this.f1210a.x(j2);
        } catch (RemoteException unused) {
            return false;
        }
    }
}
