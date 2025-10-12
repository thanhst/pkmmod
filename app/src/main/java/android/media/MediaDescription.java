package android.media;

import android.annotation.Nullable;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public /* synthetic */ class MediaDescription implements Parcelable {

    public /* synthetic */ class Builder {
        static {
            throw new NoClassDefFoundError();
        }

        public native /* synthetic */ MediaDescription build();

        public native /* synthetic */ Builder setDescription(@Nullable CharSequence charSequence);

        public native /* synthetic */ Builder setExtras(@Nullable Bundle bundle);

        public native /* synthetic */ Builder setIconBitmap(@Nullable Bitmap bitmap);

        public native /* synthetic */ Builder setIconUri(@Nullable Uri uri);

        public native /* synthetic */ Builder setMediaId(@Nullable String str);

        public native /* synthetic */ Builder setSubtitle(@Nullable CharSequence charSequence);

        public native /* synthetic */ Builder setTitle(@Nullable CharSequence charSequence);
    }

    static {
        throw new NoClassDefFoundError();
    }

    @Nullable
    public native /* synthetic */ CharSequence getDescription();

    @Nullable
    public native /* synthetic */ Bundle getExtras();

    @Nullable
    public native /* synthetic */ Bitmap getIconBitmap();

    @Nullable
    public native /* synthetic */ Uri getIconUri();

    @Nullable
    public native /* synthetic */ String getMediaId();

    @Nullable
    public native /* synthetic */ CharSequence getSubtitle();

    @Nullable
    public native /* synthetic */ CharSequence getTitle();

    @Override // android.os.Parcelable
    public native /* synthetic */ void writeToParcel(Parcel parcel, int i2);
}
