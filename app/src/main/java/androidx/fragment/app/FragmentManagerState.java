package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new a();

    /* renamed from: e, reason: collision with root package name */
    ArrayList<FragmentState> f2129e;

    /* renamed from: f, reason: collision with root package name */
    ArrayList<String> f2130f;

    /* renamed from: g, reason: collision with root package name */
    BackStackState[] f2131g;

    /* renamed from: h, reason: collision with root package name */
    int f2132h;

    /* renamed from: i, reason: collision with root package name */
    String f2133i;

    /* renamed from: j, reason: collision with root package name */
    ArrayList<String> f2134j;

    /* renamed from: k, reason: collision with root package name */
    ArrayList<Bundle> f2135k;

    /* renamed from: l, reason: collision with root package name */
    ArrayList<FragmentManager.LaunchedFragmentInfo> f2136l;

    class a implements Parcelable.Creator<FragmentManagerState> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FragmentManagerState createFromParcel(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public FragmentManagerState[] newArray(int i2) {
            return new FragmentManagerState[i2];
        }
    }

    public FragmentManagerState() {
        this.f2133i = null;
        this.f2134j = new ArrayList<>();
        this.f2135k = new ArrayList<>();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeTypedList(this.f2129e);
        parcel.writeStringList(this.f2130f);
        parcel.writeTypedArray(this.f2131g, i2);
        parcel.writeInt(this.f2132h);
        parcel.writeString(this.f2133i);
        parcel.writeStringList(this.f2134j);
        parcel.writeTypedList(this.f2135k);
        parcel.writeTypedList(this.f2136l);
    }

    public FragmentManagerState(Parcel parcel) {
        this.f2133i = null;
        this.f2134j = new ArrayList<>();
        this.f2135k = new ArrayList<>();
        this.f2129e = parcel.createTypedArrayList(FragmentState.CREATOR);
        this.f2130f = parcel.createStringArrayList();
        this.f2131g = (BackStackState[]) parcel.createTypedArray(BackStackState.CREATOR);
        this.f2132h = parcel.readInt();
        this.f2133i = parcel.readString();
        this.f2134j = parcel.createStringArrayList();
        this.f2135k = parcel.createTypedArrayList(Bundle.CREATOR);
        this.f2136l = parcel.createTypedArrayList(FragmentManager.LaunchedFragmentInfo.CREATOR);
    }
}
