package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.CameraEffectArguments;
import com.facebook.share.model.CameraEffectTextures;
import com.facebook.share.model.ShareContent;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ShareCameraEffectContent.kt */
@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001f\u001eB\u0011\b\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bB\u0011\b\u0010\u0012\u0006\u0010\u001c\u001a\u00020\u0003¢\u0006\u0004\b\u001a\u0010\u001dJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R(\u0010\u000b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR(\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u000f8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R(\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\n\u001a\u0004\u0018\u00010\u00148\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006 "}, d2 = {"Lcom/facebook/share/model/ShareCameraEffectContent;", "Lcom/facebook/share/model/ShareContent;", "Lcom/facebook/share/model/ShareCameraEffectContent$Builder;", "Landroid/os/Parcel;", "out", "", "flags", "Lkotlin/t;", "writeToParcel", "", "<set-?>", "effectId", "Ljava/lang/String;", "getEffectId", "()Ljava/lang/String;", "Lcom/facebook/share/model/CameraEffectArguments;", "arguments", "Lcom/facebook/share/model/CameraEffectArguments;", "getArguments", "()Lcom/facebook/share/model/CameraEffectArguments;", "Lcom/facebook/share/model/CameraEffectTextures;", "textures", "Lcom/facebook/share/model/CameraEffectTextures;", "getTextures", "()Lcom/facebook/share/model/CameraEffectTextures;", "builder", "<init>", "(Lcom/facebook/share/model/ShareCameraEffectContent$Builder;)V", "parcel", "(Landroid/os/Parcel;)V", "Companion", "Builder", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ShareCameraEffectContent extends ShareContent<ShareCameraEffectContent, Builder> {

    @Nullable
    private CameraEffectArguments arguments;

    @Nullable
    private String effectId;

    @Nullable
    private CameraEffectTextures textures;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<ShareCameraEffectContent> CREATOR = new Parcelable.Creator<ShareCameraEffectContent>() { // from class: com.facebook.share.model.ShareCameraEffectContent$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ShareCameraEffectContent createFromParcel(@NotNull Parcel parcel) {
            s.e(parcel, "parcel");
            return new ShareCameraEffectContent(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ShareCameraEffectContent[] newArray(int size) {
            return new ShareCameraEffectContent[size];
        }
    };

    /* compiled from: ShareCameraEffectContent.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\u0012\u0010\u0017\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0019\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u001a\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u001b\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001c"}, d2 = {"Lcom/facebook/share/model/ShareCameraEffectContent$Builder;", "Lcom/facebook/share/model/ShareContent$Builder;", "Lcom/facebook/share/model/ShareCameraEffectContent;", "()V", "arguments", "Lcom/facebook/share/model/CameraEffectArguments;", "getArguments$facebook_common_release", "()Lcom/facebook/share/model/CameraEffectArguments;", "setArguments$facebook_common_release", "(Lcom/facebook/share/model/CameraEffectArguments;)V", "effectId", "", "getEffectId$facebook_common_release", "()Ljava/lang/String;", "setEffectId$facebook_common_release", "(Ljava/lang/String;)V", "textures", "Lcom/facebook/share/model/CameraEffectTextures;", "getTextures$facebook_common_release", "()Lcom/facebook/share/model/CameraEffectTextures;", "setTextures$facebook_common_release", "(Lcom/facebook/share/model/CameraEffectTextures;)V", "build", "readFrom", "model", "setArguments", "setEffectId", "setTextures", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Builder extends ShareContent.Builder<ShareCameraEffectContent, Builder> {

        @Nullable
        private CameraEffectArguments arguments;

        @Nullable
        private String effectId;

        @Nullable
        private CameraEffectTextures textures;

        @Nullable
        /* renamed from: getArguments$facebook_common_release, reason: from getter */
        public final CameraEffectArguments getArguments() {
            return this.arguments;
        }

        @Nullable
        /* renamed from: getEffectId$facebook_common_release, reason: from getter */
        public final String getEffectId() {
            return this.effectId;
        }

        @Nullable
        /* renamed from: getTextures$facebook_common_release, reason: from getter */
        public final CameraEffectTextures getTextures() {
            return this.textures;
        }

        @NotNull
        public final Builder setArguments(@Nullable CameraEffectArguments arguments) {
            this.arguments = arguments;
            return this;
        }

        public final void setArguments$facebook_common_release(@Nullable CameraEffectArguments cameraEffectArguments) {
            this.arguments = cameraEffectArguments;
        }

        @NotNull
        public final Builder setEffectId(@Nullable String effectId) {
            this.effectId = effectId;
            return this;
        }

        public final void setEffectId$facebook_common_release(@Nullable String str) {
            this.effectId = str;
        }

        @NotNull
        public final Builder setTextures(@Nullable CameraEffectTextures textures) {
            this.textures = textures;
            return this;
        }

        public final void setTextures$facebook_common_release(@Nullable CameraEffectTextures cameraEffectTextures) {
            this.textures = cameraEffectTextures;
        }

        @Override // com.facebook.share.ShareBuilder
        @NotNull
        public ShareCameraEffectContent build() {
            return new ShareCameraEffectContent(this, null);
        }

        @Override // com.facebook.share.model.ShareContent.Builder, com.facebook.share.model.ShareModelBuilder
        @NotNull
        public Builder readFrom(@Nullable ShareCameraEffectContent model) {
            return model == null ? this : ((Builder) super.readFrom((Builder) model)).setEffectId(model.getEffectId()).setArguments(model.getArguments()).setTextures(model.getTextures());
        }
    }

    private ShareCameraEffectContent(Builder builder) {
        super(builder);
        this.effectId = builder.getEffectId();
        this.arguments = builder.getArguments();
        this.textures = builder.getTextures();
    }

    public /* synthetic */ ShareCameraEffectContent(Builder builder, o oVar) {
        this(builder);
    }

    @Nullable
    public final CameraEffectArguments getArguments() {
        return this.arguments;
    }

    @Nullable
    public final String getEffectId() {
        return this.effectId;
    }

    @Nullable
    public final CameraEffectTextures getTextures() {
        return this.textures;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i2) {
        s.e(out, "out");
        super.writeToParcel(out, i2);
        out.writeString(this.effectId);
        out.writeParcelable(this.arguments, 0);
        out.writeParcelable(this.textures, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareCameraEffectContent(@NotNull Parcel parcel) {
        super(parcel);
        s.e(parcel, "parcel");
        this.effectId = parcel.readString();
        this.arguments = new CameraEffectArguments.Builder().readFrom(parcel).build();
        this.textures = new CameraEffectTextures.Builder().readFrom(parcel).build();
    }
}
