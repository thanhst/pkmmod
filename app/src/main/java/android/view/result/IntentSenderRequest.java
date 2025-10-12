package android.view.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class IntentSenderRequest implements Parcelable {

    @NonNull
    public static final Parcelable.Creator<IntentSenderRequest> CREATOR = new a();

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    private final IntentSender f72e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private final Intent f73f;

    /* renamed from: g, reason: collision with root package name */
    private final int f74g;

    /* renamed from: h, reason: collision with root package name */
    private final int f75h;

    class a implements Parcelable.Creator<IntentSenderRequest> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public IntentSenderRequest createFromParcel(Parcel parcel) {
            return new IntentSenderRequest(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public IntentSenderRequest[] newArray(int i2) {
            return new IntentSenderRequest[i2];
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private IntentSender f76a;

        /* renamed from: b, reason: collision with root package name */
        private Intent f77b;

        /* renamed from: c, reason: collision with root package name */
        private int f78c;

        /* renamed from: d, reason: collision with root package name */
        private int f79d;

        public b(@NonNull IntentSender intentSender) {
            this.f76a = intentSender;
        }

        @NonNull
        public IntentSenderRequest a() {
            return new IntentSenderRequest(this.f76a, this.f77b, this.f78c, this.f79d);
        }

        @NonNull
        public b b(@Nullable Intent intent) {
            this.f77b = intent;
            return this;
        }

        @NonNull
        public b c(int i2, int i3) {
            this.f79d = i2;
            this.f78c = i3;
            return this;
        }
    }

    IntentSenderRequest(@NonNull IntentSender intentSender, @Nullable Intent intent, int i2, int i3) {
        this.f72e = intentSender;
        this.f73f = intent;
        this.f74g = i2;
        this.f75h = i3;
    }

    @Nullable
    public Intent a() {
        return this.f73f;
    }

    public int b() {
        return this.f74g;
    }

    public int c() {
        return this.f75h;
    }

    @NonNull
    public IntentSender d() {
        return this.f72e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i2) {
        parcel.writeParcelable(this.f72e, i2);
        parcel.writeParcelable(this.f73f, i2);
        parcel.writeInt(this.f74g);
        parcel.writeInt(this.f75h);
    }

    IntentSenderRequest(@NonNull Parcel parcel) {
        this.f72e = (IntentSender) parcel.readParcelable(IntentSender.class.getClassLoader());
        this.f73f = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
        this.f74g = parcel.readInt();
        this.f75h = parcel.readInt();
    }
}
