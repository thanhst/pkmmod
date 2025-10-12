package m;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* compiled from: IUnusedAppRestrictionsBackportCallback.java */
/* loaded from: classes.dex */
public interface a extends IInterface {

    /* compiled from: IUnusedAppRestrictionsBackportCallback.java */
    /* renamed from: m.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0066a extends Binder implements a {

        /* compiled from: IUnusedAppRestrictionsBackportCallback.java */
        /* renamed from: m.a$a$a, reason: collision with other inner class name */
        private static class C0067a implements a {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f4024a;

            C0067a(IBinder iBinder) {
                this.f4024a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f4024a;
            }
        }

        public static a C(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0067a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }
    }
}
