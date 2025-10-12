package androidx.core.app;

import android.content.res.Configuration;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: MultiWindowModeChangedInfo.java */
/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f1412a;

    /* renamed from: b, reason: collision with root package name */
    private final Configuration f1413b;

    public t(boolean z2) {
        this.f1412a = z2;
        this.f1413b = null;
    }

    @RequiresApi(26)
    public t(boolean z2, @NonNull Configuration configuration) {
        this.f1412a = z2;
        this.f1413b = configuration;
    }
}
