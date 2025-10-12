package v;

import android.media.session.MediaSessionManager$RemoteUserInfo;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

/* compiled from: MediaSessionManager.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    c f4147a;

    public b(@NonNull String str, int i2, int i3) {
        if (str == null) {
            throw new NullPointerException("package shouldn't be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("packageName should be nonempty");
        }
        if (Build.VERSION.SDK_INT >= 28) {
            this.f4147a = new d(str, i2, i3);
        } else {
            this.f4147a = new e(str, i2, i3);
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            return this.f4147a.equals(((b) obj).f4147a);
        }
        return false;
    }

    public int hashCode() {
        return this.f4147a.hashCode();
    }

    @RequiresApi(28)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public b(MediaSessionManager$RemoteUserInfo mediaSessionManager$RemoteUserInfo) {
        String strA = d.a(mediaSessionManager$RemoteUserInfo);
        if (strA != null) {
            if (!TextUtils.isEmpty(strA)) {
                this.f4147a = new d(mediaSessionManager$RemoteUserInfo);
                return;
            }
            throw new IllegalArgumentException("packageName should be nonempty");
        }
        throw new NullPointerException("package shouldn't be null");
    }
}
