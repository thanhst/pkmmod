package com.facebook.share.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.facebook.share.model.ShareMedia;
import com.facebook.share.model.ShareMedia.Builder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.u;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ShareMedia.kt */
@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b'\u0018\u0000*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000*\u0014\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u00020\u0004:\u0002\u0019\u001aB\u001d\b\u0014\u0012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0016B\u0011\b\u0010\u0012\u0006\u0010\u0017\u001a\u00020\t¢\u0006\u0004\b\u0015\u0010\u0018J\b\u0010\u0006\u001a\u00020\u0005H\u0007J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016R\u0014\u0010\u000e\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00108&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001b"}, d2 = {"Lcom/facebook/share/model/ShareMedia;", "M", "Lcom/facebook/share/model/ShareMedia$Builder;", "B", "Lcom/facebook/share/model/ShareModel;", "Landroid/os/Bundle;", "getParameters", "", "describeContents", "Landroid/os/Parcel;", "dest", "flags", "Lkotlin/t;", "writeToParcel", NativeProtocol.WEB_DIALOG_PARAMS, "Landroid/os/Bundle;", "Lcom/facebook/share/model/ShareMedia$Type;", "getMediaType", "()Lcom/facebook/share/model/ShareMedia$Type;", "mediaType", "builder", "<init>", "(Lcom/facebook/share/model/ShareMedia$Builder;)V", "parcel", "(Landroid/os/Parcel;)V", "Builder", "Type", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public abstract class ShareMedia<M extends ShareMedia<M, B>, B extends Builder<M, B>> implements ShareModel {

    @NotNull
    private final Bundle params;

    /* compiled from: ShareMedia.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0007\b&\u0018\u0000 \u0017*\u0014\b\u0002\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0002*\u0014\b\u0003\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00002\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0005J\u0017\u0010\f\u001a\u00028\u00032\b\u0010\r\u001a\u0004\u0018\u00018\u0002H\u0016¢\u0006\u0002\u0010\u000eJ\u001d\u0010\u000f\u001a\u00028\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010\u0013J\u0015\u0010\u0014\u001a\u00028\u00032\u0006\u0010\u0015\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/facebook/share/model/ShareMedia$Builder;", "M", "Lcom/facebook/share/model/ShareMedia;", "B", "Lcom/facebook/share/model/ShareModelBuilder;", "()V", NativeProtocol.WEB_DIALOG_PARAMS, "Landroid/os/Bundle;", "getParams$facebook_common_release", "()Landroid/os/Bundle;", "setParams$facebook_common_release", "(Landroid/os/Bundle;)V", "readFrom", "model", "(Lcom/facebook/share/model/ShareMedia;)Lcom/facebook/share/model/ShareMedia$Builder;", "setParameter", "key", "", "value", "(Ljava/lang/String;Ljava/lang/String;)Lcom/facebook/share/model/ShareMedia$Builder;", "setParameters", "parameters", "(Landroid/os/Bundle;)Lcom/facebook/share/model/ShareMedia$Builder;", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static abstract class Builder<M extends ShareMedia<M, B>, B extends Builder<M, B>> implements ShareModelBuilder<M, B> {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        private Bundle params = new Bundle();

        /* compiled from: ShareMedia.kt */
        @Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J5\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00070\u0006H\u0001¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u0010\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00070\u00062\u0006\u0010\r\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/facebook/share/model/ShareMedia$Builder$Companion;", "", "Landroid/os/Parcel;", "out", "", "parcelFlags", "", "Lcom/facebook/share/model/ShareMedia;", ShareConstants.WEB_DIALOG_PARAM_MEDIA, "Lkotlin/t;", "writeListTo$facebook_common_release", "(Landroid/os/Parcel;ILjava/util/List;)V", "writeListTo", "parcel", "readListFrom$facebook_common_release", "(Landroid/os/Parcel;)Ljava/util/List;", "readListFrom", "<init>", "()V", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(o oVar) {
                this();
            }

            @JvmStatic
            @NotNull
            public final List<ShareMedia<?, ?>> readListFrom$facebook_common_release(@NotNull Parcel parcel) {
                s.e(parcel, "parcel");
                Parcelable[] parcelableArray = parcel.readParcelableArray(ShareMedia.class.getClassLoader());
                if (parcelableArray == null) {
                    return u.h();
                }
                ArrayList arrayList = new ArrayList();
                for (Parcelable parcelable : parcelableArray) {
                    if (parcelable instanceof ShareMedia) {
                        arrayList.add(parcelable);
                    }
                }
                return arrayList;
            }

            @JvmStatic
            public final void writeListTo$facebook_common_release(@NotNull Parcel out, int parcelFlags, @NotNull List<? extends ShareMedia<?, ?>> media) {
                s.e(out, "out");
                s.e(media, "media");
                Object[] array = media.toArray(new ShareMedia[0]);
                if (array == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                out.writeParcelableArray((Parcelable[]) array, parcelFlags);
            }
        }

        @NotNull
        /* renamed from: getParams$facebook_common_release, reason: from getter */
        public final Bundle getParams() {
            return this.params;
        }

        @Deprecated(message = "This method is deprecated. Use GraphRequest directly to set parameters.")
        @NotNull
        public final B setParameter(@NotNull String key, @NotNull String value) {
            s.e(key, "key");
            s.e(value, "value");
            this.params.putString(key, value);
            return this;
        }

        @Deprecated(message = "This method is deprecated. Use GraphRequest directly to set parameters.")
        @NotNull
        public final B setParameters(@NotNull Bundle parameters) {
            s.e(parameters, "parameters");
            this.params.putAll(parameters);
            return this;
        }

        public final void setParams$facebook_common_release(@NotNull Bundle bundle) {
            s.e(bundle, "<set-?>");
            this.params = bundle;
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        @NotNull
        public B readFrom(@Nullable M model) {
            return model == null ? this : (B) setParameters(((ShareMedia) model).params);
        }
    }

    /* compiled from: ShareMedia.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/facebook/share/model/ShareMedia$Type;", "", "(Ljava/lang/String;I)V", "PHOTO", ShareConstants.VIDEO_URL, "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum Type {
        PHOTO,
        VIDEO;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static Type[] valuesCustom() {
            Type[] typeArrValuesCustom = values();
            return (Type[]) Arrays.copyOf(typeArrValuesCustom, typeArrValuesCustom.length);
        }
    }

    protected ShareMedia(@NotNull Builder<M, B> builder) {
        s.e(builder, "builder");
        this.params = new Bundle(builder.getParams());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public abstract Type getMediaType();

    @Deprecated(message = "This method is deprecated. Use GraphRequest directly to set parameters.")
    @NotNull
    public final Bundle getParameters() {
        return new Bundle(this.params);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel dest, int i2) {
        s.e(dest, "dest");
        dest.writeBundle(this.params);
    }

    public ShareMedia(@NotNull Parcel parcel) {
        s.e(parcel, "parcel");
        Bundle bundle = parcel.readBundle(getClass().getClassLoader());
        this.params = bundle == null ? new Bundle() : bundle;
    }
}
