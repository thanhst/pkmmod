package androidx.browser.customtabs;

import a.b;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public abstract class CustomTabsService extends Service {

    /* renamed from: e, reason: collision with root package name */
    final androidx.collection.g<IBinder, IBinder.DeathRecipient> f1197e = new androidx.collection.g<>();

    /* renamed from: f, reason: collision with root package name */
    private b.a f1198f = new a();

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface FilePurpose {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Relation {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Result {
    }

    class a extends b.a {
        a() {
        }

        @Nullable
        private PendingIntent E(@Nullable Bundle bundle) {
            if (bundle == null) {
                return null;
            }
            PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("android.support.customtabs.extra.SESSION_ID");
            bundle.remove("android.support.customtabs.extra.SESSION_ID");
            return pendingIntent;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void F(g gVar) {
            CustomTabsService.this.a(gVar);
        }

        private boolean G(@NonNull a.a aVar, @Nullable PendingIntent pendingIntent) {
            final g gVar = new g(aVar, pendingIntent);
            try {
                IBinder.DeathRecipient deathRecipient = new IBinder.DeathRecipient() { // from class: androidx.browser.customtabs.d
                    @Override // android.os.IBinder.DeathRecipient
                    public final void binderDied() {
                        this.f1237a.F(gVar);
                    }
                };
                synchronized (CustomTabsService.this.f1197e) {
                    aVar.asBinder().linkToDeath(deathRecipient, 0);
                    CustomTabsService.this.f1197e.put(aVar.asBinder(), deathRecipient);
                }
                return CustomTabsService.this.d(gVar);
            } catch (RemoteException unused) {
                return false;
            }
        }

        @Override // a.b
        public boolean A(@NonNull a.a aVar, @Nullable Bundle bundle) {
            return CustomTabsService.this.h(new g(aVar, E(bundle)), bundle);
        }

        @Override // a.b
        public boolean B(@NonNull a.a aVar, int i2, @NonNull Uri uri, @Nullable Bundle bundle) {
            return CustomTabsService.this.i(new g(aVar, E(bundle)), i2, uri, bundle);
        }

        @Override // a.b
        public boolean e(@NonNull a.a aVar, @NonNull Uri uri) {
            return CustomTabsService.this.g(new g(aVar, null), uri);
        }

        @Override // a.b
        public boolean j(@Nullable a.a aVar, @Nullable Uri uri, @Nullable Bundle bundle, @Nullable List<Bundle> list) {
            return CustomTabsService.this.c(new g(aVar, E(bundle)), uri, bundle, list);
        }

        @Override // a.b
        public int o(@NonNull a.a aVar, @NonNull String str, @Nullable Bundle bundle) {
            return CustomTabsService.this.e(new g(aVar, E(bundle)), str, bundle);
        }

        @Override // a.b
        public Bundle q(@NonNull String str, @Nullable Bundle bundle) {
            return CustomTabsService.this.b(str, bundle);
        }

        @Override // a.b
        public boolean r(@NonNull a.a aVar) {
            return G(aVar, null);
        }

        @Override // a.b
        public boolean t(@NonNull a.a aVar, @NonNull Uri uri, @NonNull Bundle bundle) {
            return CustomTabsService.this.g(new g(aVar, E(bundle)), uri);
        }

        @Override // a.b
        public boolean v(@NonNull a.a aVar, @NonNull Uri uri, int i2, @Nullable Bundle bundle) {
            return CustomTabsService.this.f(new g(aVar, E(bundle)), uri, i2, bundle);
        }

        @Override // a.b
        public boolean x(long j2) {
            return CustomTabsService.this.j(j2);
        }

        @Override // a.b
        public boolean z(@NonNull a.a aVar, @Nullable Bundle bundle) {
            return G(aVar, E(bundle));
        }
    }

    protected boolean a(@NonNull g gVar) {
        try {
            synchronized (this.f1197e) {
                IBinder iBinderA = gVar.a();
                if (iBinderA == null) {
                    return false;
                }
                iBinderA.unlinkToDeath(this.f1197e.get(iBinderA), 0);
                this.f1197e.remove(iBinderA);
                return true;
            }
        } catch (NoSuchElementException unused) {
            return false;
        }
    }

    @Nullable
    protected abstract Bundle b(@NonNull String str, @Nullable Bundle bundle);

    protected abstract boolean c(@NonNull g gVar, @Nullable Uri uri, @Nullable Bundle bundle, @Nullable List<Bundle> list);

    protected abstract boolean d(@NonNull g gVar);

    protected abstract int e(@NonNull g gVar, @NonNull String str, @Nullable Bundle bundle);

    protected abstract boolean f(@NonNull g gVar, @NonNull Uri uri, int i2, @Nullable Bundle bundle);

    protected abstract boolean g(@NonNull g gVar, @NonNull Uri uri);

    protected abstract boolean h(@NonNull g gVar, @Nullable Bundle bundle);

    protected abstract boolean i(@NonNull g gVar, int i2, @NonNull Uri uri, @Nullable Bundle bundle);

    protected abstract boolean j(long j2);

    @Override // android.app.Service
    @NonNull
    public IBinder onBind(@Nullable Intent intent) {
        return this.f1198f;
    }
}
