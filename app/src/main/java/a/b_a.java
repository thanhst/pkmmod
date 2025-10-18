package a;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import java.util.List;

/* compiled from: ICustomTabsService.java */
/* loaded from: classes.dex */
public interface b_a extends IInterface {

    /* compiled from: ICustomTabsService.java */
    public static abstract class a extends Binder implements b_a {

        /* compiled from: ICustomTabsService.java */
        /* renamed from: a.b$a$a, reason: collision with other inner class name */
        private static class C0002a implements b_a {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f2a;

            C0002a(IBinder iBinder) {
                this.f2a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f2a;
            }

            @Override // a.b
            public boolean j(a.a aVar, Uri uri, Bundle bundle, List<Bundle> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    parcelObtain.writeStrongInterface(aVar);
                    C0003b.d(parcelObtain, uri, 0);
                    C0003b.d(parcelObtain, bundle, 0);
                    parcelObtain.writeTypedList(list);
                    this.f2a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // a.b
            public boolean r(a.a aVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    parcelObtain.writeStrongInterface(aVar);
                    this.f2a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // a.b
            public boolean x(long j2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    parcelObtain.writeLong(j2);
                    this.f2a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // a.b
            public boolean z(a.a aVar, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    parcelObtain.writeStrongInterface(aVar);
                    C0003b.d(parcelObtain, bundle, 0);
                    this.f2a.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "android.support.customtabs.ICustomTabsService");
        }

        public static b_a C(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("android.support.customtabs.ICustomTabsService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof b_a)) ? new C0002a(iBinder) : (b_a) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 >= 1 && i2 <= 16777215) {
                parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
            }
            if (i2 == 1598968902) {
                parcel2.writeString("android.support.customtabs.ICustomTabsService");
                return true;
            }
            switch (i2) {
                case 2:
                    boolean zX = x(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(zX ? 1 : 0);
                    return true;
                case 3:
                    boolean zR = r(a.AbstractBinderC0000a.C(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(zR ? 1 : 0);
                    return true;
                case 4:
                    a.a aVarC = a.AbstractBinderC0000a.C(parcel.readStrongBinder());
                    Uri uri = (Uri) C0003b.c(parcel, Uri.CREATOR);
                    Parcelable.Creator creator = Bundle.CREATOR;
                    boolean zJ = j(aVarC, uri, (Bundle) C0003b.c(parcel, creator), parcel.createTypedArrayList(creator));
                    parcel2.writeNoException();
                    parcel2.writeInt(zJ ? 1 : 0);
                    return true;
                case 5:
                    Bundle bundleQ = q(parcel.readString(), (Bundle) C0003b.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    C0003b.d(parcel2, bundleQ, 1);
                    return true;
                case 6:
                    boolean zA = A(a.AbstractBinderC0000a.C(parcel.readStrongBinder()), (Bundle) C0003b.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(zA ? 1 : 0);
                    return true;
                case 7:
                    boolean zE = e(a.AbstractBinderC0000a.C(parcel.readStrongBinder()), (Uri) C0003b.c(parcel, Uri.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(zE ? 1 : 0);
                    return true;
                case 8:
                    int iO = o(a.AbstractBinderC0000a.C(parcel.readStrongBinder()), parcel.readString(), (Bundle) C0003b.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(iO);
                    return true;
                case 9:
                    boolean zB = B(a.AbstractBinderC0000a.C(parcel.readStrongBinder()), parcel.readInt(), (Uri) C0003b.c(parcel, Uri.CREATOR), (Bundle) C0003b.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(zB ? 1 : 0);
                    return true;
                case 10:
                    boolean z2 = z(a.AbstractBinderC0000a.C(parcel.readStrongBinder()), (Bundle) C0003b.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(z2 ? 1 : 0);
                    return true;
                case 11:
                    boolean zT = t(a.AbstractBinderC0000a.C(parcel.readStrongBinder()), (Uri) C0003b.c(parcel, Uri.CREATOR), (Bundle) C0003b.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(zT ? 1 : 0);
                    return true;
                case 12:
                    boolean zV = v(a.AbstractBinderC0000a.C(parcel.readStrongBinder()), (Uri) C0003b.c(parcel, Uri.CREATOR), parcel.readInt(), (Bundle) C0003b.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(zV ? 1 : 0);
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }
    }

    /* compiled from: ICustomTabsService.java */
    /* renamed from: a.b$b, reason: collision with other inner class name */
    public static class C0003b {
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

    boolean A(a.a aVar, Bundle bundle) throws RemoteException;

    boolean B(a.a aVar, int i2, Uri uri, Bundle bundle) throws RemoteException;

    boolean e(a.a aVar, Uri uri) throws RemoteException;

    boolean j(a.a aVar, Uri uri, Bundle bundle, List<Bundle> list) throws RemoteException;

    int o(a.a aVar, String str, Bundle bundle) throws RemoteException;

    Bundle q(String str, Bundle bundle) throws RemoteException;

    boolean r(a.a aVar) throws RemoteException;

    boolean t(a.a aVar, Uri uri, Bundle bundle) throws RemoteException;

    boolean v(a.a aVar, Uri uri, int i2, Bundle bundle) throws RemoteException;

    boolean x(long j2) throws RemoteException;

    boolean z(a.a aVar, Bundle bundle) throws RemoteException;
}
