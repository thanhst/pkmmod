package v;

import android.media.session.MediaSessionManager$RemoteUserInfo;
import androidx.annotation.RequiresApi;

/* compiled from: MediaSessionManagerImplApi28.java */
@RequiresApi(28)
/* loaded from: classes.dex */
final class d_v extends e_v {

    /* renamed from: d, reason: collision with root package name */
    final MediaSessionManager$RemoteUserInfo f4148d;

    d_v(String str, int i2, int i3) {
        super(str, i2, i3);
        this.f4148d = new MediaSessionManager$RemoteUserInfo(str, i2, i3);
    }

    static String a(MediaSessionManager$RemoteUserInfo mediaSessionManager$RemoteUserInfo) {
        return mediaSessionManager$RemoteUserInfo.getPackageName();
    }

    d_v(MediaSessionManager$RemoteUserInfo mediaSessionManager$RemoteUserInfo) {
        super(mediaSessionManager$RemoteUserInfo.getPackageName(), mediaSessionManager$RemoteUserInfo.getPid(), mediaSessionManager$RemoteUserInfo.getUid());
        this.f4148d = mediaSessionManager$RemoteUserInfo;
    }
}
