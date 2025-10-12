package com.facebook.share.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.NativeProtocol;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.r0;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CameraEffectArguments.kt */
@Metadata(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001d\u001cB\u0011\b\u0012\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019B\u0011\b\u0010\u0012\u0006\u0010\u001a\u001a\u00020\u000e¢\u0006\u0004\b\u0018\u0010\u001bJ\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u001f\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0086\u0002J\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\nJ\b\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\fH\u0016R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u001e"}, d2 = {"Lcom/facebook/share/model/CameraEffectArguments;", "Lcom/facebook/share/model/ShareModel;", "", "key", "getString", "", "getStringArray", "(Ljava/lang/String;)[Ljava/lang/String;", "", "get", "", "keySet", "", "describeContents", "Landroid/os/Parcel;", "out", "flags", "Lkotlin/t;", "writeToParcel", "Landroid/os/Bundle;", NativeProtocol.WEB_DIALOG_PARAMS, "Landroid/os/Bundle;", "Lcom/facebook/share/model/CameraEffectArguments$Builder;", "builder", "<init>", "(Lcom/facebook/share/model/CameraEffectArguments$Builder;)V", "parcel", "(Landroid/os/Parcel;)V", "Companion", "Builder", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class CameraEffectArguments implements ShareModel {

    @Nullable
    private final Bundle params;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<CameraEffectArguments> CREATOR = new Parcelable.Creator<CameraEffectArguments>() { // from class: com.facebook.share.model.CameraEffectArguments$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public CameraEffectArguments createFromParcel(@NotNull Parcel parcel) {
            s.e(parcel, "parcel");
            return new CameraEffectArguments(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public CameraEffectArguments[] newArray(int size) {
            return new CameraEffectArguments[size];
        }
    };

    /* compiled from: CameraEffectArguments.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\u0002H\u0016J!\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\u0010\u000eJ\u0016\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0012J\u0012\u0010\u0010\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/facebook/share/model/CameraEffectArguments$Builder;", "Lcom/facebook/share/model/ShareModelBuilder;", "Lcom/facebook/share/model/CameraEffectArguments;", "()V", NativeProtocol.WEB_DIALOG_PARAMS, "Landroid/os/Bundle;", "getParams$facebook_common_release", "()Landroid/os/Bundle;", "build", "putArgument", "key", "", "arrayValue", "", "(Ljava/lang/String;[Ljava/lang/String;)Lcom/facebook/share/model/CameraEffectArguments$Builder;", "value", "readFrom", "parcel", "Landroid/os/Parcel;", "model", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Builder implements ShareModelBuilder<CameraEffectArguments, Builder> {

        @NotNull
        private final Bundle params = new Bundle();

        @NotNull
        /* renamed from: getParams$facebook_common_release, reason: from getter */
        public final Bundle getParams() {
            return this.params;
        }

        @NotNull
        public final Builder putArgument(@NotNull String key, @NotNull String value) {
            s.e(key, "key");
            s.e(value, "value");
            this.params.putString(key, value);
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        @NotNull
        public CameraEffectArguments build() {
            return new CameraEffectArguments(this, null);
        }

        @NotNull
        public final Builder putArgument(@NotNull String key, @NotNull String[] arrayValue) {
            s.e(key, "key");
            s.e(arrayValue, "arrayValue");
            this.params.putStringArray(key, arrayValue);
            return this;
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        @NotNull
        public Builder readFrom(@Nullable CameraEffectArguments model) {
            if (model != null) {
                this.params.putAll(model.params);
            }
            return this;
        }

        @NotNull
        public final Builder readFrom(@NotNull Parcel parcel) {
            s.e(parcel, "parcel");
            return readFrom((CameraEffectArguments) parcel.readParcelable(CameraEffectArguments.class.getClassLoader()));
        }
    }

    private CameraEffectArguments(Builder builder) {
        this.params = builder.getParams();
    }

    public /* synthetic */ CameraEffectArguments(Builder builder, o oVar) {
        this(builder);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Object get(@Nullable String key) {
        Bundle bundle = this.params;
        if (bundle == null) {
            return null;
        }
        return bundle.get(key);
    }

    @Nullable
    public final String getString(@Nullable String key) {
        Bundle bundle = this.params;
        if (bundle == null) {
            return null;
        }
        return bundle.getString(key);
    }

    @Nullable
    public final String[] getStringArray(@Nullable String key) {
        Bundle bundle = this.params;
        if (bundle == null) {
            return null;
        }
        return bundle.getStringArray(key);
    }

    @NotNull
    public final Set<String> keySet() {
        Bundle bundle = this.params;
        Set<String> setKeySet = bundle == null ? null : bundle.keySet();
        return setKeySet == null ? r0.d() : setKeySet;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i2) {
        s.e(out, "out");
        out.writeBundle(this.params);
    }

    public CameraEffectArguments(@NotNull Parcel parcel) {
        s.e(parcel, "parcel");
        this.params = parcel.readBundle(CameraEffectArguments.class.getClassLoader());
    }
}
