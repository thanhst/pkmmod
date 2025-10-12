package b;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* compiled from: ITrustedWebActivityService.java */
/* loaded from: classes.dex */
public interface b extends IInterface {

    /* compiled from: ITrustedWebActivityService.java */
    public static abstract class a extends Binder implements b {
        public a() {
            attachInterface(this, "android.support.customtabs.trusted.ITrustedWebActivityService");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 >= 1 && i2 <= 16777215) {
                parcel.enforceInterface("android.support.customtabs.trusted.ITrustedWebActivityService");
            }
            if (i2 == 1598968902) {
                parcel2.writeString("android.support.customtabs.trusted.ITrustedWebActivityService");
                return true;
            }
            switch (i2) {
                case 2:
                    Bundle bundleL = l((Bundle) C0040b.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    C0040b.d(parcel2, bundleL, 1);
                    return true;
                case 3:
                    k((Bundle) C0040b.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    int iB = b();
                    parcel2.writeNoException();
                    parcel2.writeInt(iB);
                    return true;
                case 5:
                    Bundle bundleH = h();
                    parcel2.writeNoException();
                    C0040b.d(parcel2, bundleH, 1);
                    return true;
                case 6:
                    Bundle bundleD = d((Bundle) C0040b.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    C0040b.d(parcel2, bundleD, 1);
                    return true;
                case 7:
                    Bundle bundleC = c();
                    parcel2.writeNoException();
                    C0040b.d(parcel2, bundleC, 1);
                    return true;
                case 8:
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
                case 9:
                    Bundle bundleS = s(parcel.readString(), (Bundle) C0040b.c(parcel, Bundle.CREATOR), parcel.readStrongBinder());
                    parcel2.writeNoException();
                    C0040b.d(parcel2, bundleS, 1);
                    return true;
            }
        }
    }

    /* compiled from: ITrustedWebActivityService.java */
    /* renamed from: b.b$b, reason: collision with other inner class name */
    public static class C0040b {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T c(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void d(Parcel parcel, T t2, int i2) {
            if (t2 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t2.writeToParcel(parcel, i2);
            }
        }
    }

    int b() throws RemoteException;

    Bundle c() throws RemoteException;

    Bundle d(Bundle bundle) throws RemoteException;

    Bundle h() throws RemoteException;

    void k(Bundle bundle) throws RemoteException;

    Bundle l(Bundle bundle) throws RemoteException;

    Bundle s(String str, Bundle bundle, IBinder iBinder) throws RemoteException;
}
