package a;

import a.a;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* compiled from: IPostMessageService.java */
/* loaded from: classes.dex */
public interface c extends IInterface {

    /* compiled from: IPostMessageService.java */
    public static abstract class a extends Binder implements c {
        public a() {
            attachInterface(this, "android.support.customtabs.IPostMessageService");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 >= 1 && i2 <= 16777215) {
                parcel.enforceInterface("android.support.customtabs.IPostMessageService");
            }
            if (i2 == 1598968902) {
                parcel2.writeString("android.support.customtabs.IPostMessageService");
                return true;
            }
            if (i2 == 2) {
                g(a.AbstractBinderC0000a.C(parcel.readStrongBinder()), (Bundle) b.b(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
            } else {
                if (i2 != 3) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                n(a.AbstractBinderC0000a.C(parcel.readStrongBinder()), parcel.readString(), (Bundle) b.b(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
            }
            return true;
        }
    }

    /* compiled from: IPostMessageService.java */
    public static class b {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T b(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }
    }

    void g(a.a aVar, Bundle bundle) throws RemoteException;

    void n(a.a aVar, String str, Bundle bundle) throws RemoteException;
}
