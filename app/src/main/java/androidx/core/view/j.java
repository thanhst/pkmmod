package androidx.core.view;

import android.annotation.SuppressLint;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: MenuHostHelper.java */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private final Runnable f1768a;

    /* renamed from: b, reason: collision with root package name */
    private final CopyOnWriteArrayList<y> f1769b = new CopyOnWriteArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private final Map<y, a> f1770c = new HashMap();

    /* compiled from: MenuHostHelper.java */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        final Lifecycle f1771a;

        /* renamed from: b, reason: collision with root package name */
        private androidx.lifecycle.k f1772b;

        a(@NonNull Lifecycle lifecycle, @NonNull androidx.lifecycle.k kVar) {
            this.f1771a = lifecycle;
            this.f1772b = kVar;
            lifecycle.a(kVar);
        }

        void a() {
            this.f1771a.c(this.f1772b);
            this.f1772b = null;
        }
    }

    public j(@NonNull Runnable runnable) {
        this.f1768a = runnable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(y yVar, androidx.lifecycle.m mVar, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            l(yVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(Lifecycle.State state, y yVar, androidx.lifecycle.m mVar, Lifecycle.Event event) {
        if (event == Lifecycle.Event.upTo(state)) {
            c(yVar);
            return;
        }
        if (event == Lifecycle.Event.ON_DESTROY) {
            l(yVar);
        } else if (event == Lifecycle.Event.downFrom(state)) {
            this.f1769b.remove(yVar);
            this.f1768a.run();
        }
    }

    public void c(@NonNull y yVar) {
        this.f1769b.add(yVar);
        this.f1768a.run();
    }

    public void d(@NonNull final y yVar, @NonNull androidx.lifecycle.m mVar) {
        c(yVar);
        Lifecycle lifecycle = mVar.getLifecycle();
        a aVarRemove = this.f1770c.remove(yVar);
        if (aVarRemove != null) {
            aVarRemove.a();
        }
        this.f1770c.put(yVar, new a(lifecycle, new androidx.lifecycle.k() { // from class: androidx.core.view.h
            @Override // androidx.lifecycle.k
            public final void d(androidx.lifecycle.m mVar2, Lifecycle.Event event) {
                this.f1763a.f(yVar, mVar2, event);
            }
        }));
    }

    @SuppressLint({"LambdaLast"})
    public void e(@NonNull final y yVar, @NonNull androidx.lifecycle.m mVar, @NonNull final Lifecycle.State state) {
        Lifecycle lifecycle = mVar.getLifecycle();
        a aVarRemove = this.f1770c.remove(yVar);
        if (aVarRemove != null) {
            aVarRemove.a();
        }
        this.f1770c.put(yVar, new a(lifecycle, new androidx.lifecycle.k() { // from class: androidx.core.view.i
            @Override // androidx.lifecycle.k
            public final void d(androidx.lifecycle.m mVar2, Lifecycle.Event event) {
                this.f1765a.g(state, yVar, mVar2, event);
            }
        }));
    }

    public void h(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
        Iterator<y> it = this.f1769b.iterator();
        while (it.hasNext()) {
            it.next().c(menu, menuInflater);
        }
    }

    public void i(@NonNull Menu menu) {
        Iterator<y> it = this.f1769b.iterator();
        while (it.hasNext()) {
            it.next().b(menu);
        }
    }

    public boolean j(@NonNull MenuItem menuItem) {
        Iterator<y> it = this.f1769b.iterator();
        while (it.hasNext()) {
            if (it.next().a(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void k(@NonNull Menu menu) {
        Iterator<y> it = this.f1769b.iterator();
        while (it.hasNext()) {
            it.next().d(menu);
        }
    }

    public void l(@NonNull y yVar) {
        this.f1769b.remove(yVar);
        a aVarRemove = this.f1770c.remove(yVar);
        if (aVarRemove != null) {
            aVarRemove.a();
        }
        this.f1768a.run();
    }
}
