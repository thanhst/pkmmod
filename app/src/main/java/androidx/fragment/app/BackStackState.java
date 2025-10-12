package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.r;
import androidx.lifecycle.Lifecycle;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
final class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new a();

    /* renamed from: e, reason: collision with root package name */
    final int[] f2018e;

    /* renamed from: f, reason: collision with root package name */
    final ArrayList<String> f2019f;

    /* renamed from: g, reason: collision with root package name */
    final int[] f2020g;

    /* renamed from: h, reason: collision with root package name */
    final int[] f2021h;

    /* renamed from: i, reason: collision with root package name */
    final int f2022i;

    /* renamed from: j, reason: collision with root package name */
    final String f2023j;

    /* renamed from: k, reason: collision with root package name */
    final int f2024k;

    /* renamed from: l, reason: collision with root package name */
    final int f2025l;

    /* renamed from: m, reason: collision with root package name */
    final CharSequence f2026m;

    /* renamed from: n, reason: collision with root package name */
    final int f2027n;

    /* renamed from: o, reason: collision with root package name */
    final CharSequence f2028o;

    /* renamed from: p, reason: collision with root package name */
    final ArrayList<String> f2029p;

    /* renamed from: q, reason: collision with root package name */
    final ArrayList<String> f2030q;

    /* renamed from: r, reason: collision with root package name */
    final boolean f2031r;

    class a implements Parcelable.Creator<BackStackState> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BackStackState createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public BackStackState[] newArray(int i2) {
            return new BackStackState[i2];
        }
    }

    public BackStackState(androidx.fragment.app.a aVar) {
        int size = aVar.f2283c.size();
        this.f2018e = new int[size * 5];
        if (!aVar.f2289i) {
            throw new IllegalStateException("Not on back stack");
        }
        this.f2019f = new ArrayList<>(size);
        this.f2020g = new int[size];
        this.f2021h = new int[size];
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            r.a aVar2 = aVar.f2283c.get(i2);
            int i4 = i3 + 1;
            this.f2018e[i3] = aVar2.f2300a;
            ArrayList<String> arrayList = this.f2019f;
            Fragment fragment = aVar2.f2301b;
            arrayList.add(fragment != null ? fragment.mWho : null);
            int[] iArr = this.f2018e;
            int i5 = i4 + 1;
            iArr[i4] = aVar2.f2302c;
            int i6 = i5 + 1;
            iArr[i5] = aVar2.f2303d;
            int i7 = i6 + 1;
            iArr[i6] = aVar2.f2304e;
            iArr[i7] = aVar2.f2305f;
            this.f2020g[i2] = aVar2.f2306g.ordinal();
            this.f2021h[i2] = aVar2.f2307h.ordinal();
            i2++;
            i3 = i7 + 1;
        }
        this.f2022i = aVar.f2288h;
        this.f2023j = aVar.f2291k;
        this.f2024k = aVar.f2172v;
        this.f2025l = aVar.f2292l;
        this.f2026m = aVar.f2293m;
        this.f2027n = aVar.f2294n;
        this.f2028o = aVar.f2295o;
        this.f2029p = aVar.f2296p;
        this.f2030q = aVar.f2297q;
        this.f2031r = aVar.f2298r;
    }

    public androidx.fragment.app.a a(FragmentManager fragmentManager) {
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(fragmentManager);
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.f2018e.length) {
            r.a aVar2 = new r.a();
            int i4 = i2 + 1;
            aVar2.f2300a = this.f2018e[i2];
            if (FragmentManager.F0(2)) {
                Log.v("FragmentManager", "Instantiate " + aVar + " op #" + i3 + " base fragment #" + this.f2018e[i4]);
            }
            String str = this.f2019f.get(i3);
            if (str != null) {
                aVar2.f2301b = fragmentManager.g0(str);
            } else {
                aVar2.f2301b = null;
            }
            aVar2.f2306g = Lifecycle.State.values()[this.f2020g[i3]];
            aVar2.f2307h = Lifecycle.State.values()[this.f2021h[i3]];
            int[] iArr = this.f2018e;
            int i5 = i4 + 1;
            int i6 = iArr[i4];
            aVar2.f2302c = i6;
            int i7 = i5 + 1;
            int i8 = iArr[i5];
            aVar2.f2303d = i8;
            int i9 = i7 + 1;
            int i10 = iArr[i7];
            aVar2.f2304e = i10;
            int i11 = iArr[i9];
            aVar2.f2305f = i11;
            aVar.f2284d = i6;
            aVar.f2285e = i8;
            aVar.f2286f = i10;
            aVar.f2287g = i11;
            aVar.e(aVar2);
            i3++;
            i2 = i9 + 1;
        }
        aVar.f2288h = this.f2022i;
        aVar.f2291k = this.f2023j;
        aVar.f2172v = this.f2024k;
        aVar.f2289i = true;
        aVar.f2292l = this.f2025l;
        aVar.f2293m = this.f2026m;
        aVar.f2294n = this.f2027n;
        aVar.f2295o = this.f2028o;
        aVar.f2296p = this.f2029p;
        aVar.f2297q = this.f2030q;
        aVar.f2298r = this.f2031r;
        aVar.n(1);
        return aVar;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeIntArray(this.f2018e);
        parcel.writeStringList(this.f2019f);
        parcel.writeIntArray(this.f2020g);
        parcel.writeIntArray(this.f2021h);
        parcel.writeInt(this.f2022i);
        parcel.writeString(this.f2023j);
        parcel.writeInt(this.f2024k);
        parcel.writeInt(this.f2025l);
        TextUtils.writeToParcel(this.f2026m, parcel, 0);
        parcel.writeInt(this.f2027n);
        TextUtils.writeToParcel(this.f2028o, parcel, 0);
        parcel.writeStringList(this.f2029p);
        parcel.writeStringList(this.f2030q);
        parcel.writeInt(this.f2031r ? 1 : 0);
    }

    public BackStackState(Parcel parcel) {
        this.f2018e = parcel.createIntArray();
        this.f2019f = parcel.createStringArrayList();
        this.f2020g = parcel.createIntArray();
        this.f2021h = parcel.createIntArray();
        this.f2022i = parcel.readInt();
        this.f2023j = parcel.readString();
        this.f2024k = parcel.readInt();
        this.f2025l = parcel.readInt();
        this.f2026m = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f2027n = parcel.readInt();
        this.f2028o = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f2029p = parcel.createStringArrayList();
        this.f2030q = parcel.createStringArrayList();
        this.f2031r = parcel.readInt() != 0;
    }
}
