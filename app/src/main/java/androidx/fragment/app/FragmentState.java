package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new a();

    /* renamed from: e, reason: collision with root package name */
    final String f2137e;

    /* renamed from: f, reason: collision with root package name */
    final String f2138f;

    /* renamed from: g, reason: collision with root package name */
    final boolean f2139g;

    /* renamed from: h, reason: collision with root package name */
    final int f2140h;

    /* renamed from: i, reason: collision with root package name */
    final int f2141i;

    /* renamed from: j, reason: collision with root package name */
    final String f2142j;

    /* renamed from: k, reason: collision with root package name */
    final boolean f2143k;

    /* renamed from: l, reason: collision with root package name */
    final boolean f2144l;

    /* renamed from: m, reason: collision with root package name */
    final boolean f2145m;

    /* renamed from: n, reason: collision with root package name */
    final Bundle f2146n;

    /* renamed from: o, reason: collision with root package name */
    final boolean f2147o;

    /* renamed from: p, reason: collision with root package name */
    final int f2148p;

    /* renamed from: q, reason: collision with root package name */
    Bundle f2149q;

    class a implements Parcelable.Creator<FragmentState> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FragmentState createFromParcel(Parcel parcel) {
            return new FragmentState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public FragmentState[] newArray(int i2) {
            return new FragmentState[i2];
        }
    }

    FragmentState(Fragment fragment) {
        this.f2137e = fragment.getClass().getName();
        this.f2138f = fragment.mWho;
        this.f2139g = fragment.mFromLayout;
        this.f2140h = fragment.mFragmentId;
        this.f2141i = fragment.mContainerId;
        this.f2142j = fragment.mTag;
        this.f2143k = fragment.mRetainInstance;
        this.f2144l = fragment.mRemoving;
        this.f2145m = fragment.mDetached;
        this.f2146n = fragment.mArguments;
        this.f2147o = fragment.mHidden;
        this.f2148p = fragment.mMaxState.ordinal();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f2137e);
        sb.append(" (");
        sb.append(this.f2138f);
        sb.append(")}:");
        if (this.f2139g) {
            sb.append(" fromLayout");
        }
        if (this.f2141i != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f2141i));
        }
        String str = this.f2142j;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.f2142j);
        }
        if (this.f2143k) {
            sb.append(" retainInstance");
        }
        if (this.f2144l) {
            sb.append(" removing");
        }
        if (this.f2145m) {
            sb.append(" detached");
        }
        if (this.f2147o) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f2137e);
        parcel.writeString(this.f2138f);
        parcel.writeInt(this.f2139g ? 1 : 0);
        parcel.writeInt(this.f2140h);
        parcel.writeInt(this.f2141i);
        parcel.writeString(this.f2142j);
        parcel.writeInt(this.f2143k ? 1 : 0);
        parcel.writeInt(this.f2144l ? 1 : 0);
        parcel.writeInt(this.f2145m ? 1 : 0);
        parcel.writeBundle(this.f2146n);
        parcel.writeInt(this.f2147o ? 1 : 0);
        parcel.writeBundle(this.f2149q);
        parcel.writeInt(this.f2148p);
    }

    FragmentState(Parcel parcel) {
        this.f2137e = parcel.readString();
        this.f2138f = parcel.readString();
        this.f2139g = parcel.readInt() != 0;
        this.f2140h = parcel.readInt();
        this.f2141i = parcel.readInt();
        this.f2142j = parcel.readString();
        this.f2143k = parcel.readInt() != 0;
        this.f2144l = parcel.readInt() != 0;
        this.f2145m = parcel.readInt() != 0;
        this.f2146n = parcel.readBundle();
        this.f2147o = parcel.readInt() != 0;
        this.f2149q = parcel.readBundle();
        this.f2148p = parcel.readInt();
    }
}
