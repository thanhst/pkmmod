package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AppGroupCreationContent.kt */
@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001b2\u00020\u0001:\u0003\u001c\u001d\u001bB\u0011\b\u0012\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018B\u0011\b\u0010\u0012\u0006\u0010\u0019\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/facebook/share/model/AppGroupCreationContent;", "Lcom/facebook/share/model/ShareModel;", "", "describeContents", "Landroid/os/Parcel;", "out", "flags", "Lkotlin/t;", "writeToParcel", "", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "description", "getDescription", "Lcom/facebook/share/model/AppGroupCreationContent$AppGroupPrivacy;", "appGroupPrivacy", "Lcom/facebook/share/model/AppGroupCreationContent$AppGroupPrivacy;", "getAppGroupPrivacy", "()Lcom/facebook/share/model/AppGroupCreationContent$AppGroupPrivacy;", "Lcom/facebook/share/model/AppGroupCreationContent$Builder;", "builder", "<init>", "(Lcom/facebook/share/model/AppGroupCreationContent$Builder;)V", "parcel", "(Landroid/os/Parcel;)V", "Companion", "AppGroupPrivacy", "Builder", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AppGroupCreationContent implements ShareModel {

    @Nullable
    private final AppGroupPrivacy appGroupPrivacy;

    @Nullable
    private final String description;

    @Nullable
    private final String name;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<AppGroupCreationContent> CREATOR = new Parcelable.Creator<AppGroupCreationContent>() { // from class: com.facebook.share.model.AppGroupCreationContent$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @Nullable
        public AppGroupCreationContent createFromParcel(@NotNull Parcel parcel) {
            s.e(parcel, "parcel");
            return new AppGroupCreationContent(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public AppGroupCreationContent[] newArray(int size) {
            return new AppGroupCreationContent[size];
        }
    };

    /* compiled from: AppGroupCreationContent.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/facebook/share/model/AppGroupCreationContent$AppGroupPrivacy;", "", "(Ljava/lang/String;I)V", "Open", "Closed", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum AppGroupPrivacy {
        Open,
        Closed;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static AppGroupPrivacy[] valuesCustom() {
            AppGroupPrivacy[] appGroupPrivacyArrValuesCustom = values();
            return (AppGroupPrivacy[]) Arrays.copyOf(appGroupPrivacyArrValuesCustom, appGroupPrivacyArrValuesCustom.length);
        }
    }

    /* compiled from: AppGroupCreationContent.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\u0012\u0010\u0014\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0016\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0017\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u0018\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/facebook/share/model/AppGroupCreationContent$Builder;", "Lcom/facebook/share/model/ShareModelBuilder;", "Lcom/facebook/share/model/AppGroupCreationContent;", "()V", "appGroupPrivacy", "Lcom/facebook/share/model/AppGroupCreationContent$AppGroupPrivacy;", "getAppGroupPrivacy$facebook_common_release", "()Lcom/facebook/share/model/AppGroupCreationContent$AppGroupPrivacy;", "setAppGroupPrivacy$facebook_common_release", "(Lcom/facebook/share/model/AppGroupCreationContent$AppGroupPrivacy;)V", "description", "", "getDescription$facebook_common_release", "()Ljava/lang/String;", "setDescription$facebook_common_release", "(Ljava/lang/String;)V", "name", "getName$facebook_common_release", "setName$facebook_common_release", "build", "readFrom", "content", "setAppGroupPrivacy", "setDescription", "setName", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Builder implements ShareModelBuilder<AppGroupCreationContent, Builder> {

        @Nullable
        private AppGroupPrivacy appGroupPrivacy;

        @Nullable
        private String description;

        @Nullable
        private String name;

        @Nullable
        /* renamed from: getAppGroupPrivacy$facebook_common_release, reason: from getter */
        public final AppGroupPrivacy getAppGroupPrivacy() {
            return this.appGroupPrivacy;
        }

        @Nullable
        /* renamed from: getDescription$facebook_common_release, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        /* renamed from: getName$facebook_common_release, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @NotNull
        public final Builder setAppGroupPrivacy(@Nullable AppGroupPrivacy appGroupPrivacy) {
            this.appGroupPrivacy = appGroupPrivacy;
            return this;
        }

        public final void setAppGroupPrivacy$facebook_common_release(@Nullable AppGroupPrivacy appGroupPrivacy) {
            this.appGroupPrivacy = appGroupPrivacy;
        }

        @NotNull
        public final Builder setDescription(@Nullable String description) {
            this.description = description;
            return this;
        }

        public final void setDescription$facebook_common_release(@Nullable String str) {
            this.description = str;
        }

        @NotNull
        public final Builder setName(@Nullable String name) {
            this.name = name;
            return this;
        }

        public final void setName$facebook_common_release(@Nullable String str) {
            this.name = str;
        }

        @Override // com.facebook.share.ShareBuilder
        @NotNull
        public AppGroupCreationContent build() {
            return new AppGroupCreationContent(this, null);
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        @NotNull
        public Builder readFrom(@Nullable AppGroupCreationContent content) {
            return content == null ? this : setName(content.getName()).setDescription(content.getDescription()).setAppGroupPrivacy(content.getAppGroupPrivacy());
        }
    }

    private AppGroupCreationContent(Builder builder) {
        this.name = builder.getName();
        this.description = builder.getDescription();
        this.appGroupPrivacy = builder.getAppGroupPrivacy();
    }

    public /* synthetic */ AppGroupCreationContent(Builder builder, o oVar) {
        this(builder);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final AppGroupPrivacy getAppGroupPrivacy() {
        return this.appGroupPrivacy;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i2) {
        s.e(out, "out");
        out.writeString(this.name);
        out.writeString(this.description);
        out.writeSerializable(this.appGroupPrivacy);
    }

    public AppGroupCreationContent(@NotNull Parcel parcel) {
        s.e(parcel, "parcel");
        this.name = parcel.readString();
        this.description = parcel.readString();
        this.appGroupPrivacy = (AppGroupPrivacy) parcel.readSerializable();
    }
}
