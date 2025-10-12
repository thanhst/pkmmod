package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import androidx.annotation.RestrictTo;
import java.lang.reflect.Method;

/* compiled from: VersionedParcelParcel.java */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
class a extends VersionedParcel {

    /* renamed from: d, reason: collision with root package name */
    private final SparseIntArray f2740d;

    /* renamed from: e, reason: collision with root package name */
    private final Parcel f2741e;

    /* renamed from: f, reason: collision with root package name */
    private final int f2742f;

    /* renamed from: g, reason: collision with root package name */
    private final int f2743g;

    /* renamed from: h, reason: collision with root package name */
    private final String f2744h;

    /* renamed from: i, reason: collision with root package name */
    private int f2745i;

    /* renamed from: j, reason: collision with root package name */
    private int f2746j;

    /* renamed from: k, reason: collision with root package name */
    private int f2747k;

    a(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new androidx.collection.a(), new androidx.collection.a(), new androidx.collection.a());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void A(byte[] bArr) {
        if (bArr == null) {
            this.f2741e.writeInt(-1);
        } else {
            this.f2741e.writeInt(bArr.length);
            this.f2741e.writeByteArray(bArr);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected void C(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f2741e, 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void E(int i2) {
        this.f2741e.writeInt(i2);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void G(Parcelable parcelable) {
        this.f2741e.writeParcelable(parcelable, 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void I(String str) {
        this.f2741e.writeString(str);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void a() {
        int i2 = this.f2745i;
        if (i2 >= 0) {
            int i3 = this.f2740d.get(i2);
            int iDataPosition = this.f2741e.dataPosition();
            this.f2741e.setDataPosition(i3);
            this.f2741e.writeInt(iDataPosition - i3);
            this.f2741e.setDataPosition(iDataPosition);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected VersionedParcel b() {
        Parcel parcel = this.f2741e;
        int iDataPosition = parcel.dataPosition();
        int i2 = this.f2746j;
        if (i2 == this.f2742f) {
            i2 = this.f2743g;
        }
        return new a(parcel, iDataPosition, i2, this.f2744h + "  ", this.f2737a, this.f2738b, this.f2739c);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean g() {
        return this.f2741e.readInt() != 0;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public byte[] i() {
        int i2 = this.f2741e.readInt();
        if (i2 < 0) {
            return null;
        }
        byte[] bArr = new byte[i2];
        this.f2741e.readByteArray(bArr);
        return bArr;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected CharSequence k() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f2741e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean m(int i2) {
        while (this.f2746j < this.f2743g) {
            int i3 = this.f2747k;
            if (i3 == i2) {
                return true;
            }
            if (String.valueOf(i3).compareTo(String.valueOf(i2)) > 0) {
                return false;
            }
            this.f2741e.setDataPosition(this.f2746j);
            int i4 = this.f2741e.readInt();
            this.f2747k = this.f2741e.readInt();
            this.f2746j += i4;
        }
        return this.f2747k == i2;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public int o() {
        return this.f2741e.readInt();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public <T extends Parcelable> T q() {
        return (T) this.f2741e.readParcelable(getClass().getClassLoader());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public String s() {
        return this.f2741e.readString();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void w(int i2) {
        a();
        this.f2745i = i2;
        this.f2740d.put(i2, this.f2741e.dataPosition());
        E(0);
        E(i2);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void y(boolean z2) {
        this.f2741e.writeInt(z2 ? 1 : 0);
    }

    private a(Parcel parcel, int i2, int i3, String str, androidx.collection.a<String, Method> aVar, androidx.collection.a<String, Method> aVar2, androidx.collection.a<String, Class> aVar3) {
        super(aVar, aVar2, aVar3);
        this.f2740d = new SparseIntArray();
        this.f2745i = -1;
        this.f2747k = -1;
        this.f2741e = parcel;
        this.f2742f = i2;
        this.f2743g = i3;
        this.f2746j = i2;
        this.f2744h = str;
    }
}
