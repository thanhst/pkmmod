package android.media.session;

import android.os.Bundle;
import android.os.Parcelable;
import java.util.List;

/* loaded from: classes.dex */
public final /* synthetic */ class PlaybackState implements Parcelable {

    public final /* synthetic */ class Builder {
        static {
            throw new NoClassDefFoundError();
        }

        public native /* synthetic */ Builder addCustomAction(CustomAction customAction);

        public native /* synthetic */ PlaybackState build();

        public native /* synthetic */ Builder setActions(long j2);

        public native /* synthetic */ Builder setActiveQueueItemId(long j2);

        public native /* synthetic */ Builder setBufferedPosition(long j2);

        public native /* synthetic */ Builder setErrorMessage(CharSequence charSequence);

        public native /* synthetic */ Builder setState(int i2, long j2, float f2, long j3);
    }

    public final /* synthetic */ class CustomAction implements Parcelable {

        public final /* synthetic */ class Builder {
            static {
                throw new NoClassDefFoundError();
            }

            public /* synthetic */ Builder(String str, CharSequence charSequence, int i2) {
            }

            public native /* synthetic */ CustomAction build();

            public native /* synthetic */ Builder setExtras(Bundle bundle);
        }

        static {
            throw new NoClassDefFoundError();
        }

        public native /* synthetic */ String getAction();

        public native /* synthetic */ Bundle getExtras();

        public native /* synthetic */ int getIcon();

        public native /* synthetic */ CharSequence getName();
    }

    static {
        throw new NoClassDefFoundError();
    }

    public native /* synthetic */ long getActions();

    public native /* synthetic */ long getActiveQueueItemId();

    public native /* synthetic */ long getBufferedPosition();

    public native /* synthetic */ List<CustomAction> getCustomActions();

    public native /* synthetic */ CharSequence getErrorMessage();

    public native /* synthetic */ long getLastPositionUpdateTime();

    public native /* synthetic */ float getPlaybackSpeed();

    public native /* synthetic */ long getPosition();

    public native /* synthetic */ int getState();
}
