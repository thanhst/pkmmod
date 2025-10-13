package b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* compiled from: ITrustedWebActivityCallback.java */
/* loaded from: classes.dex */
public interface a_b extends IInterface {

    /* compiled from: ITrustedWebActivityCallback.java */
    /* renamed from: b.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0038AB extends Binder implements a_b {

        /* compiled from: ITrustedWebActivityCallback.java */
        /* renamed from: b.a$a$a, reason: collision with other inner class name */
        private static class C0039AB implements a_b {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f2748a;

            C0039AB(IBinder iBinder) {
                this.f2748a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f2748a;
            }
        }

        public static a_b C(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("android.support.customtabs.trusted.ITrustedWebActivityCallback");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a_b)) ? new C0039AB(iBinder) : (a_b) iInterfaceQueryLocalInterface;
        }
    }
}
