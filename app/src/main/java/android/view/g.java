package android.view;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.core.os.BuildCompat;
import androidx.core.util.a;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: OnBackPressedCallback.java */
/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    private boolean f42a;

    /* renamed from: b, reason: collision with root package name */
    private CopyOnWriteArrayList<a> f43b = new CopyOnWriteArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private a<Boolean> f44c;

    public g(boolean z2) {
        this.f42a = z2;
    }

    void a(@NonNull a aVar) {
        this.f43b.add(aVar);
    }

    @MainThread
    public abstract void b();

    @MainThread
    public final boolean c() {
        return this.f42a;
    }

    @MainThread
    public final void d() {
        Iterator<a> it = this.f43b.iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
    }

    void e(@NonNull a aVar) {
        this.f43b.remove(aVar);
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @MainThread
    public final void f(boolean z2) {
        this.f42a = z2;
        a<Boolean> aVar = this.f44c;
        if (aVar != null) {
            aVar.accept(Boolean.valueOf(z2));
        }
    }

    void g(@Nullable a<Boolean> aVar) {
        this.f44c = aVar;
    }
}
