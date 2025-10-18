package androidx.browser.customtabs;

import a.c_a;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public class PostMessageService extends Service {

    /* renamed from: e, reason: collision with root package name */
    private c_a.a f1200e = new a();

    class a extends c_a.a {
        a() {
        }

        @Override // a.c
        public void g(@NonNull a.a aVar, @Nullable Bundle bundle) throws RemoteException {
            aVar.w(bundle);
        }

        @Override // a.c
        public void n(@NonNull a.a aVar, @NonNull String str, @Nullable Bundle bundle) throws RemoteException {
            aVar.u(str, bundle);
        }
    }

    @Override // android.app.Service
    @NonNull
    public IBinder onBind(@Nullable Intent intent) {
        return this.f1200e;
    }
}
