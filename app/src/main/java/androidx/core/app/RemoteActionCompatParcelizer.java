package androidx.core.app;

import android.app.PendingIntent;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.VersionedParcel;
import java.lang.reflect.InvocationTargetException;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(VersionedParcel versionedParcel) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f1382a = (IconCompat) versionedParcel.v(remoteActionCompat.f1382a, 1);
        remoteActionCompat.f1383b = versionedParcel.l(remoteActionCompat.f1383b, 2);
        remoteActionCompat.f1384c = versionedParcel.l(remoteActionCompat.f1384c, 3);
        remoteActionCompat.f1385d = (PendingIntent) versionedParcel.r(remoteActionCompat.f1385d, 4);
        remoteActionCompat.f1386e = versionedParcel.h(remoteActionCompat.f1386e, 5);
        remoteActionCompat.f1387f = versionedParcel.h(remoteActionCompat.f1387f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, VersionedParcel versionedParcel) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        versionedParcel.x(false, false);
        versionedParcel.M(remoteActionCompat.f1382a, 1);
        versionedParcel.D(remoteActionCompat.f1383b, 2);
        versionedParcel.D(remoteActionCompat.f1384c, 3);
        versionedParcel.H(remoteActionCompat.f1385d, 4);
        versionedParcel.z(remoteActionCompat.f1386e, 5);
        versionedParcel.z(remoteActionCompat.f1387f, 6);
    }
}
