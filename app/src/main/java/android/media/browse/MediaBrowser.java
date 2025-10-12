package android.media.browse;

import android.annotation.NonNull;
import android.annotation.Nullable;
import android.content.ComponentName;
import android.content.Context;
import android.media.MediaDescription;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final /* synthetic */ class MediaBrowser {

    public /* synthetic */ class MediaItem implements Parcelable {
        static {
            throw new NoClassDefFoundError();
        }

        @NonNull
        public native /* synthetic */ MediaDescription getDescription();

        public native /* synthetic */ int getFlags();
    }

    static {
        throw new NoClassDefFoundError();
    }

    public /* synthetic */ MediaBrowser(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
    }

    public native /* synthetic */ void connect();

    public native /* synthetic */ void disconnect();

    @Nullable
    public native /* synthetic */ Bundle getExtras();

    @NonNull
    public native /* synthetic */ String getRoot();

    @NonNull
    public native /* synthetic */ ComponentName getServiceComponent();

    @NonNull
    public native /* synthetic */ MediaSession.Token getSessionToken();

    public native /* synthetic */ boolean isConnected();

    public native /* synthetic */ void subscribe(@NonNull String str, @NonNull SubscriptionCallback subscriptionCallback);

    public native /* synthetic */ void unsubscribe(@NonNull String str);
}
