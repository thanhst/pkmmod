package com.facebook.share.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareContent;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ShareFeedContent.kt */
@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\u0018\u0000  2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002! B\u0011\b\u0012\u0012\u0006\u0010\u001b\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dB\u0011\b\u0010\u0012\u0006\u0010\u001e\u001a\u00020\u0005¢\u0006\u0004\b\u001c\u0010\u001fJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000eR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000eR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0014\u0010\u000eR\u0019\u0010\u0015\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u0015\u0010\f\u001a\u0004\b\u0016\u0010\u000eR\u0019\u0010\u0017\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0018\u0010\u000eR\u0019\u0010\u0019\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u0019\u0010\f\u001a\u0004\b\u001a\u0010\u000e¨\u0006\""}, d2 = {"Lcom/facebook/share/internal/ShareFeedContent;", "Lcom/facebook/share/model/ShareContent;", "Lcom/facebook/share/internal/ShareFeedContent$Builder;", "", "describeContents", "Landroid/os/Parcel;", "out", "flags", "Lkotlin/t;", "writeToParcel", "", "toId", "Ljava/lang/String;", "getToId", "()Ljava/lang/String;", "link", "getLink", "linkName", "getLinkName", "linkCaption", "getLinkCaption", "linkDescription", "getLinkDescription", "picture", "getPicture", "mediaSource", "getMediaSource", "builder", "<init>", "(Lcom/facebook/share/internal/ShareFeedContent$Builder;)V", "parcel", "(Landroid/os/Parcel;)V", "Companion", "Builder", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ShareFeedContent extends ShareContent<ShareFeedContent, Builder> {

    @Nullable
    private final String link;

    @Nullable
    private final String linkCaption;

    @Nullable
    private final String linkDescription;

    @Nullable
    private final String linkName;

    @Nullable
    private final String mediaSource;

    @Nullable
    private final String picture;

    @Nullable
    private final String toId;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<ShareFeedContent> CREATOR = new Parcelable.Creator<ShareFeedContent>() { // from class: com.facebook.share.internal.ShareFeedContent$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ShareFeedContent createFromParcel(@NotNull Parcel parcel) {
            s.e(parcel, "parcel");
            return new ShareFeedContent(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ShareFeedContent[] newArray(int size) {
            return new ShareFeedContent[size];
        }
    };

    /* compiled from: ShareFeedContent.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b!\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001c\u001a\u00020\u0002H\u0016J\u0012\u0010\u001d\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u001f\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u0010\u0010 \u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0005J\u0010\u0010!\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\"\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005J\u0010\u0010#\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005J\u0010\u0010$\u001a\u00020\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005J\u0010\u0010%\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\t¨\u0006&"}, d2 = {"Lcom/facebook/share/internal/ShareFeedContent$Builder;", "Lcom/facebook/share/model/ShareContent$Builder;", "Lcom/facebook/share/internal/ShareFeedContent;", "()V", "link", "", "getLink$facebook_common_release", "()Ljava/lang/String;", "setLink$facebook_common_release", "(Ljava/lang/String;)V", "linkCaption", "getLinkCaption$facebook_common_release", "setLinkCaption$facebook_common_release", "linkDescription", "getLinkDescription$facebook_common_release", "setLinkDescription$facebook_common_release", "linkName", "getLinkName$facebook_common_release", "setLinkName$facebook_common_release", "mediaSource", "getMediaSource$facebook_common_release", "setMediaSource$facebook_common_release", "picture", "getPicture$facebook_common_release", "setPicture$facebook_common_release", "toId", "getToId$facebook_common_release", "setToId$facebook_common_release", "build", "readFrom", "content", "setLink", "setLinkCaption", "setLinkDescription", "setLinkName", "setMediaSource", "setPicture", "setToId", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Builder extends ShareContent.Builder<ShareFeedContent, Builder> {

        @Nullable
        private String link;

        @Nullable
        private String linkCaption;

        @Nullable
        private String linkDescription;

        @Nullable
        private String linkName;

        @Nullable
        private String mediaSource;

        @Nullable
        private String picture;

        @Nullable
        private String toId;

        @Nullable
        /* renamed from: getLink$facebook_common_release, reason: from getter */
        public final String getLink() {
            return this.link;
        }

        @Nullable
        /* renamed from: getLinkCaption$facebook_common_release, reason: from getter */
        public final String getLinkCaption() {
            return this.linkCaption;
        }

        @Nullable
        /* renamed from: getLinkDescription$facebook_common_release, reason: from getter */
        public final String getLinkDescription() {
            return this.linkDescription;
        }

        @Nullable
        /* renamed from: getLinkName$facebook_common_release, reason: from getter */
        public final String getLinkName() {
            return this.linkName;
        }

        @Nullable
        /* renamed from: getMediaSource$facebook_common_release, reason: from getter */
        public final String getMediaSource() {
            return this.mediaSource;
        }

        @Nullable
        /* renamed from: getPicture$facebook_common_release, reason: from getter */
        public final String getPicture() {
            return this.picture;
        }

        @Nullable
        /* renamed from: getToId$facebook_common_release, reason: from getter */
        public final String getToId() {
            return this.toId;
        }

        @NotNull
        public final Builder setLink(@Nullable String link) {
            this.link = link;
            return this;
        }

        public final void setLink$facebook_common_release(@Nullable String str) {
            this.link = str;
        }

        @NotNull
        public final Builder setLinkCaption(@Nullable String linkCaption) {
            this.linkCaption = linkCaption;
            return this;
        }

        public final void setLinkCaption$facebook_common_release(@Nullable String str) {
            this.linkCaption = str;
        }

        @NotNull
        public final Builder setLinkDescription(@Nullable String linkDescription) {
            this.linkDescription = linkDescription;
            return this;
        }

        public final void setLinkDescription$facebook_common_release(@Nullable String str) {
            this.linkDescription = str;
        }

        @NotNull
        public final Builder setLinkName(@Nullable String linkName) {
            this.linkName = linkName;
            return this;
        }

        public final void setLinkName$facebook_common_release(@Nullable String str) {
            this.linkName = str;
        }

        @NotNull
        public final Builder setMediaSource(@Nullable String mediaSource) {
            this.mediaSource = mediaSource;
            return this;
        }

        public final void setMediaSource$facebook_common_release(@Nullable String str) {
            this.mediaSource = str;
        }

        @NotNull
        public final Builder setPicture(@Nullable String picture) {
            this.picture = picture;
            return this;
        }

        public final void setPicture$facebook_common_release(@Nullable String str) {
            this.picture = str;
        }

        @NotNull
        public final Builder setToId(@Nullable String toId) {
            this.toId = toId;
            return this;
        }

        public final void setToId$facebook_common_release(@Nullable String str) {
            this.toId = str;
        }

        @Override // com.facebook.share.ShareBuilder
        @NotNull
        public ShareFeedContent build() {
            return new ShareFeedContent(this, null);
        }

        @Override // com.facebook.share.model.ShareContent.Builder, com.facebook.share.model.ShareModelBuilder
        @NotNull
        public Builder readFrom(@Nullable ShareFeedContent content) {
            return content == null ? this : ((Builder) super.readFrom((Builder) content)).setToId(content.getToId()).setLink(content.getLink()).setLinkName(content.getLinkName()).setLinkCaption(content.getLinkCaption()).setLinkDescription(content.getLinkDescription()).setPicture(content.getPicture()).setMediaSource(content.getMediaSource());
        }
    }

    private ShareFeedContent(Builder builder) {
        super(builder);
        this.toId = builder.getToId();
        this.link = builder.getLink();
        this.linkName = builder.getLinkName();
        this.linkCaption = builder.getLinkCaption();
        this.linkDescription = builder.getLinkDescription();
        this.picture = builder.getPicture();
        this.mediaSource = builder.getMediaSource();
    }

    public /* synthetic */ ShareFeedContent(Builder builder, o oVar) {
        this(builder);
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final String getLink() {
        return this.link;
    }

    @Nullable
    public final String getLinkCaption() {
        return this.linkCaption;
    }

    @Nullable
    public final String getLinkDescription() {
        return this.linkDescription;
    }

    @Nullable
    public final String getLinkName() {
        return this.linkName;
    }

    @Nullable
    public final String getMediaSource() {
        return this.mediaSource;
    }

    @Nullable
    public final String getPicture() {
        return this.picture;
    }

    @Nullable
    public final String getToId() {
        return this.toId;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i2) {
        s.e(out, "out");
        super.writeToParcel(out, i2);
        out.writeString(this.toId);
        out.writeString(this.link);
        out.writeString(this.linkName);
        out.writeString(this.linkCaption);
        out.writeString(this.linkDescription);
        out.writeString(this.picture);
        out.writeString(this.mediaSource);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareFeedContent(@NotNull Parcel parcel) {
        super(parcel);
        s.e(parcel, "parcel");
        this.toId = parcel.readString();
        this.link = parcel.readString();
        this.linkName = parcel.readString();
        this.linkCaption = parcel.readString();
        this.linkDescription = parcel.readString();
        this.picture = parcel.readString();
        this.mediaSource = parcel.readString();
    }
}
