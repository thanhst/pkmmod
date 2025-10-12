package androidx.core.app;

import android.content.res.Configuration;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: PictureInPictureModeChangedInfo.java */
/* loaded from: classes.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f1419a;

    /* renamed from: b, reason: collision with root package name */
    private final Configuration f1420b;

    public x(boolean z2) {
        this.f1419a = z2;
        this.f1420b = null;
    }

    @RequiresApi(26)
    public x(boolean z2, @NonNull Configuration configuration) {
        this.f1419a = z2;
        this.f1420b = configuration;
    }
}
