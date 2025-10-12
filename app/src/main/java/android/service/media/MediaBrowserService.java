package android.service.media;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/* loaded from: classes.dex */
public /* synthetic */ class MediaBrowserService extends Service {

    public /* synthetic */ class Result {
        static {
            throw new NoClassDefFoundError();
        }

        public native /* synthetic */ void sendResult(Object obj);
    }

    static {
        throw new NoClassDefFoundError();
    }

    @Override // android.app.Service
    public native /* synthetic */ IBinder onBind(Intent intent);

    @Override // android.app.Service
    public native /* synthetic */ void onCreate();
}
