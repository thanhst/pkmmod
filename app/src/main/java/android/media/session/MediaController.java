package android.media.session;

import android.annotation.NonNull;
import android.annotation.Nullable;
import android.app.PendingIntent;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaMetadata;
import android.media.Rating;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.view.KeyEvent;
import java.util.List;

/* loaded from: classes.dex */
public final /* synthetic */ class MediaController {

    public final /* synthetic */ class PlaybackInfo implements Parcelable {
        static {
            throw new NoClassDefFoundError();
        }

        public native /* synthetic */ AudioAttributes getAudioAttributes();

        public native /* synthetic */ int getCurrentVolume();

        public native /* synthetic */ int getMaxVolume();

        public native /* synthetic */ int getPlaybackType();

        public native /* synthetic */ int getVolumeControl();
    }

    public final /* synthetic */ class TransportControls {
        static {
            throw new NoClassDefFoundError();
        }

        public native /* synthetic */ void fastForward();

        public native /* synthetic */ void pause();

        public native /* synthetic */ void play();

        public native /* synthetic */ void playFromMediaId(String str, Bundle bundle);

        public native /* synthetic */ void playFromSearch(String str, Bundle bundle);

        public native /* synthetic */ void rewind();

        public native /* synthetic */ void seekTo(long j2);

        public native /* synthetic */ void sendCustomAction(@NonNull String str, @Nullable Bundle bundle);

        public native /* synthetic */ void setRating(Rating rating);

        public native /* synthetic */ void skipToNext();

        public native /* synthetic */ void skipToPrevious();

        public native /* synthetic */ void skipToQueueItem(long j2);

        public native /* synthetic */ void stop();
    }

    static {
        throw new NoClassDefFoundError();
    }

    public /* synthetic */ MediaController(@NonNull Context context, @NonNull MediaSession.Token token) {
    }

    public native /* synthetic */ void adjustVolume(int i2, int i3);

    public native /* synthetic */ boolean dispatchMediaButtonEvent(@NonNull KeyEvent keyEvent);

    @Nullable
    public native /* synthetic */ Bundle getExtras();

    public native /* synthetic */ long getFlags();

    @Nullable
    public native /* synthetic */ MediaMetadata getMetadata();

    public native /* synthetic */ String getPackageName();

    @Nullable
    public native /* synthetic */ PlaybackInfo getPlaybackInfo();

    @Nullable
    public native /* synthetic */ PlaybackState getPlaybackState();

    @Nullable
    public native /* synthetic */ List<MediaSession.QueueItem> getQueue();

    @Nullable
    public native /* synthetic */ CharSequence getQueueTitle();

    public native /* synthetic */ int getRatingType();

    @Nullable
    public native /* synthetic */ PendingIntent getSessionActivity();

    @NonNull
    public native /* synthetic */ MediaSession.Token getSessionToken();

    @NonNull
    public native /* synthetic */ TransportControls getTransportControls();

    public native /* synthetic */ void registerCallback(@NonNull Callback callback, @Nullable Handler handler);

    public native /* synthetic */ void sendCommand(@NonNull String str, @Nullable Bundle bundle, @Nullable ResultReceiver resultReceiver);

    public native /* synthetic */ void setVolumeTo(int i2, int i3);

    public native /* synthetic */ void unregisterCallback(@NonNull Callback callback);
}
