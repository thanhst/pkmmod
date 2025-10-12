package androidx.loader.app;

import androidx.annotation.NonNull;
import androidx.lifecycle.f0;
import androidx.lifecycle.m;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: LoaderManager.java */
/* loaded from: classes.dex */
public abstract class a {
    @NonNull
    public static <T extends m & f0> a b(@NonNull T t2) {
        return new b(t2, t2.getViewModelStore());
    }

    @Deprecated
    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract void c();
}
