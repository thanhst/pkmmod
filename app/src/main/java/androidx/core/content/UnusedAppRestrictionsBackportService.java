package androidx.core.content;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import m.a_m;
import m.b_m;

/* loaded from: classes.dex */
public abstract class UnusedAppRestrictionsBackportService extends Service {

    /* renamed from: e, reason: collision with root package name */
    private b_m.a f1432e = new a();

    class a extends b_m.a {
        a() {
        }

        @Override // m.b
        public void f(@Nullable a_m aMVar) throws RemoteException {
            if (aMVar == null) {
                return;
            }
            UnusedAppRestrictionsBackportService.this.a(new i(aMVar));
        }
    }

    protected abstract void a(@NonNull i iVar);

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(@Nullable Intent intent) {
        return this.f1432e;
    }
}
