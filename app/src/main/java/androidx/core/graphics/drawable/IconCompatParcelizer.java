package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcel;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(VersionedParcel versionedParcel) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f1499a = versionedParcel.p(iconCompat.f1499a, 1);
        iconCompat.f1501c = versionedParcel.j(iconCompat.f1501c, 2);
        iconCompat.f1502d = versionedParcel.r(iconCompat.f1502d, 3);
        iconCompat.f1503e = versionedParcel.p(iconCompat.f1503e, 4);
        iconCompat.f1504f = versionedParcel.p(iconCompat.f1504f, 5);
        iconCompat.f1505g = (ColorStateList) versionedParcel.r(iconCompat.f1505g, 6);
        iconCompat.f1507i = versionedParcel.t(iconCompat.f1507i, 7);
        iconCompat.f1508j = versionedParcel.t(iconCompat.f1508j, 8);
        iconCompat.g();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, VersionedParcel versionedParcel) {
        versionedParcel.x(true, true);
        iconCompat.h(versionedParcel.f());
        int i2 = iconCompat.f1499a;
        if (-1 != i2) {
            versionedParcel.F(i2, 1);
        }
        byte[] bArr = iconCompat.f1501c;
        if (bArr != null) {
            versionedParcel.B(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f1502d;
        if (parcelable != null) {
            versionedParcel.H(parcelable, 3);
        }
        int i3 = iconCompat.f1503e;
        if (i3 != 0) {
            versionedParcel.F(i3, 4);
        }
        int i4 = iconCompat.f1504f;
        if (i4 != 0) {
            versionedParcel.F(i4, 5);
        }
        ColorStateList colorStateList = iconCompat.f1505g;
        if (colorStateList != null) {
            versionedParcel.H(colorStateList, 6);
        }
        String str = iconCompat.f1507i;
        if (str != null) {
            versionedParcel.J(str, 7);
        }
        String str2 = iconCompat.f1508j;
        if (str2 != null) {
            versionedParcel.J(str2, 8);
        }
    }
}
