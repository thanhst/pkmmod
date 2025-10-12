package android.content.pm;

import android.annotation.NonNull;
import android.annotation.Nullable;
import android.os.Parcelable;
import java.util.List;

/* loaded from: classes.dex */
public /* synthetic */ class PackageInstaller {

    public /* synthetic */ class SessionInfo implements Parcelable {
        static {
            throw new NoClassDefFoundError();
        }

        @Nullable
        public native /* synthetic */ String getAppPackageName();
    }

    static {
        throw new NoClassDefFoundError();
    }

    @NonNull
    public native /* synthetic */ List<SessionInfo> getAllSessions();
}
