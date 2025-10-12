package com.facebook.share.model;

import android.os.Parcel;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ShareMessengerActionButton.kt */
@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001:\u0001\u0014B\u0019\b\u0014\u0012\u000e\u0010\u000f\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000e¢\u0006\u0004\b\u0010\u0010\u0011B\u0011\b\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/facebook/share/model/ShareMessengerActionButton;", "Lcom/facebook/share/model/ShareModel;", "", "describeContents", "Landroid/os/Parcel;", "dest", "flags", "Lkotlin/t;", "writeToParcel", "", ShareConstants.WEB_DIALOG_PARAM_TITLE, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "Lcom/facebook/share/model/ShareMessengerActionButton$Builder;", "builder", "<init>", "(Lcom/facebook/share/model/ShareMessengerActionButton$Builder;)V", "parcel", "(Landroid/os/Parcel;)V", "Builder", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class ShareMessengerActionButton implements ShareModel {

    @Nullable
    private final String title;

    /* compiled from: ShareMessengerActionButton.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0014\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00002\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0017\u0010\f\u001a\u00028\u00012\b\u0010\r\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u000eJ\u0015\u0010\u000f\u001a\u00028\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0010R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/facebook/share/model/ShareMessengerActionButton$Builder;", "M", "Lcom/facebook/share/model/ShareMessengerActionButton;", "B", "Lcom/facebook/share/model/ShareModelBuilder;", "()V", ShareConstants.WEB_DIALOG_PARAM_TITLE, "", "getTitle$facebook_common_release", "()Ljava/lang/String;", "setTitle$facebook_common_release", "(Ljava/lang/String;)V", "readFrom", "model", "(Lcom/facebook/share/model/ShareMessengerActionButton;)Lcom/facebook/share/model/ShareMessengerActionButton$Builder;", "setTitle", "(Ljava/lang/String;)Lcom/facebook/share/model/ShareMessengerActionButton$Builder;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static abstract class Builder<M extends ShareMessengerActionButton, B extends Builder<M, B>> implements ShareModelBuilder<M, B> {

        @Nullable
        private String title;

        @Nullable
        /* renamed from: getTitle$facebook_common_release, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        public final B setTitle(@Nullable String title) {
            this.title = title;
            return this;
        }

        public final void setTitle$facebook_common_release(@Nullable String str) {
            this.title = str;
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        @NotNull
        public B readFrom(@Nullable M model) {
            return model == null ? this : (B) setTitle(model.getTitle());
        }
    }

    protected ShareMessengerActionButton(@NotNull Builder<?, ?> builder) {
        s.e(builder, "builder");
        this.title = builder.getTitle();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel dest, int i2) {
        s.e(dest, "dest");
        dest.writeString(this.title);
    }

    public ShareMessengerActionButton(@NotNull Parcel parcel) {
        s.e(parcel, "parcel");
        this.title = parcel.readString();
    }
}
