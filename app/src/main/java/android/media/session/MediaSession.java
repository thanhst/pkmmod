package android.media.session;

import android.annotation.NonNull;
import android.annotation.Nullable;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.MediaDescription;
import android.media.MediaMetadata;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import java.util.List;

/* loaded from: classes.dex */
public final /* synthetic */ class MediaSession {

    public /* synthetic */ class Callback {
        static {
            throw new NoClassDefFoundError();
        }

        public native /* synthetic */ boolean onMediaButtonEvent(@NonNull Intent intent);
    }

    public final /* synthetic */ class QueueItem implements Parcelable {
        static {
            throw new NoClassDefFoundError();
        }

        public /* synthetic */ QueueItem(MediaDescription mediaDescription, long j2) {
        }

        public native /* synthetic */ MediaDescription getDescription();

        public native /* synthetic */ long getQueueId();
    }

    public final /* synthetic */ class Token implements Parcelable {
        static {
            throw new NoClassDefFoundError();
        }
    }

    static {
        throw new NoClassDefFoundError();
    }

    public /* synthetic */ MediaSession(@NonNull Context context, @NonNull String str) {
    }

    public /* synthetic */ MediaSession(@NonNull Context context, @NonNull String str, @Nullable Bundle bundle) {
    }

    @NonNull
    public native /* synthetic */ MediaController getController();

    @NonNull
    public native /* synthetic */ Token getSessionToken();

    public native /* synthetic */ boolean isActive();

    public native /* synthetic */ void release();

    public native /* synthetic */ void sendSessionEvent(@NonNull String str, @Nullable Bundle bundle);

    public native /* synthetic */ void setActive(boolean z2);

    public native /* synthetic */ void setCallback(@Nullable Callback callback);

    public native /* synthetic */ void setCallback(@Nullable Callback callback, @Nullable Handler handler);

    public native /* synthetic */ void setExtras(@Nullable Bundle bundle);

    public native /* synthetic */ void setFlags(int i2);

    @Deprecated
    public native /* synthetic */ void setMediaButtonReceiver(@Nullable PendingIntent pendingIntent);

    public native /* synthetic */ void setMetadata(@Nullable MediaMetadata mediaMetadata);

    public native /* synthetic */ void setPlaybackState(@Nullable PlaybackState playbackState);

    public native /* synthetic */ void setPlaybackToLocal(AudioAttributes audioAttributes);

    public native /* synthetic */ void setQueue(@Nullable List<QueueItem> list);

    public native /* synthetic */ void setQueueTitle(@Nullable CharSequence charSequence);

    public native /* synthetic */ void setSessionActivity(@Nullable PendingIntent pendingIntent);
}
