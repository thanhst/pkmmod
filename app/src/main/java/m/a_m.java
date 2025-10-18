package m;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* compiled from: IUnusedAppRestrictionsBackportCallback.java */
/* loaded from: classes.dex */
public interface a_m extends IInterface {

    /* compiled from: IUnusedAppRestrictionsBackportCallback.java */
    /* renamed from: m.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0066AM extends Binder implements a_m {

        /* compiled from: IUnusedAppRestrictionsBackportCallback.java */
        /* renamed from: m.a$a$a, reason: collision with other inner class name */
        private static class C0067AM implements a_m {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f4024a;

            C0067AM(IBinder iBinder) {
                this.f4024a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f4024a;
            }
        }

        public static a_m C(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a_m)) ? new C0067AM(iBinder) : (a_m) iInterfaceQueryLocalInterface;
        }
    }
}
