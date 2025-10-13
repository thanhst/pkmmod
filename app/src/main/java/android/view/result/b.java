package android.view.result;

import android.annotation.SuppressLint;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.j;
import d.a_d;

/* compiled from: ActivityResultLauncher.java */
/* loaded from: classes.dex */
public abstract class b<I> {
    @NonNull
    public abstract a_d<I, ?> a();

    public void b(@SuppressLint({"UnknownNullness"}) I i2) {
        c(i2, null);
    }

    public abstract void c(@SuppressLint({"UnknownNullness"}) I i2, @Nullable j jVar);

    @MainThread
    public abstract void d();
}
