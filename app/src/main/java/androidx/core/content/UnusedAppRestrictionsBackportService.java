package androidx.core.content;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import m.b;

/* loaded from: classes.dex */
public abstract class UnusedAppRestrictionsBackportService extends Service {

    /* renamed from: e, reason: collision with root package name */
    private b.a f1432e = new a();

    class a extends b.a {
        a() {
        }

        @Override // m.b
        public void f(@Nullable m.a aVar) throws RemoteException {
            if (aVar == null) {
                return;
            }
            UnusedAppRestrictionsBackportService.this.a(new i(aVar));
        }
    }

    protected abstract void a(@NonNull i iVar);

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(@Nullable Intent intent) {
        return this.f1432e;
    }
}
