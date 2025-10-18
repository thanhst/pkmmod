package androidx.browser.trusted;

import android.os.IBinder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: TrustedWebActivityCallbackRemote.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final b.a f1253a;

    private c(@NonNull b.a aVar) {
        this.f1253a = aVar;
    }

    @Nullable
    static c a(@Nullable IBinder iBinder) {
        b.a aVarC = iBinder == null ? null : b.a_b.AbstractBinderC0038AB.C(iBinder);
        if (aVarC == null) {
            return null;
        }
        return new c(aVarC);
    }
}
