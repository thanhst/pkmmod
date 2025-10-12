package b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* compiled from: ITrustedWebActivityCallback.java */
/* loaded from: classes.dex */
public interface a extends IInterface {

    /* compiled from: ITrustedWebActivityCallback.java */
    /* renamed from: b.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0038a extends Binder implements a {

        /* compiled from: ITrustedWebActivityCallback.java */
        /* renamed from: b.a$a$a, reason: collision with other inner class name */
        private static class C0039a implements a {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f2748a;

            C0039a(IBinder iBinder) {
                this.f2748a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f2748a;
            }
        }

        public static a C(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("android.support.customtabs.trusted.ITrustedWebActivityCallback");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0039a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }
    }
}
