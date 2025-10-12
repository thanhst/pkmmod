package android.view;

import android.annotation.SuppressLint;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.DoNotInline;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.core.os.BuildCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.k;
import androidx.lifecycle.m;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes.dex */
public final class OnBackPressedDispatcher {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final Runnable f24a;

    /* renamed from: c, reason: collision with root package name */
    private androidx.core.util.a<Boolean> f26c;

    /* renamed from: d, reason: collision with root package name */
    private OnBackInvokedCallback f27d;

    /* renamed from: e, reason: collision with root package name */
    private OnBackInvokedDispatcher f28e;

    /* renamed from: b, reason: collision with root package name */
    final ArrayDeque<g> f25b = new ArrayDeque<>();

    /* renamed from: f, reason: collision with root package name */
    private boolean f29f = false;

    private class LifecycleOnBackPressedCancellable implements k, android.view.a {

        /* renamed from: a, reason: collision with root package name */
        private final Lifecycle f30a;

        /* renamed from: b, reason: collision with root package name */
        private final g f31b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        private android.view.a f32c;

        LifecycleOnBackPressedCancellable(@NonNull Lifecycle lifecycle, @NonNull g gVar) {
            this.f30a = lifecycle;
            this.f31b = gVar;
            lifecycle.a(this);
        }

        @Override // android.view.a
        public void cancel() {
            this.f30a.c(this);
            this.f31b.e(this);
            android.view.a aVar = this.f32c;
            if (aVar != null) {
                aVar.cancel();
                this.f32c = null;
            }
        }

        @Override // androidx.lifecycle.k
        public void d(@NonNull m mVar, @NonNull Lifecycle.Event event) {
            if (event == Lifecycle.Event.ON_START) {
                this.f32c = OnBackPressedDispatcher.this.c(this.f31b);
                return;
            }
            if (event != Lifecycle.Event.ON_STOP) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    cancel();
                }
            } else {
                android.view.a aVar = this.f32c;
                if (aVar != null) {
                    aVar.cancel();
                }
            }
        }
    }

    @RequiresApi(33)
    static class a {
        @DoNotInline
        static OnBackInvokedCallback a(Runnable runnable) {
            Objects.requireNonNull(runnable);
            return new j(runnable);
        }

        @DoNotInline
        static void b(Object obj, int i2, Object obj2) {
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(i2, (OnBackInvokedCallback) obj2);
        }

        @DoNotInline
        static void c(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    private class b implements android.view.a {

        /* renamed from: a, reason: collision with root package name */
        private final g f34a;

        b(g gVar) {
            this.f34a = gVar;
        }

        @Override // android.view.a
        @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
        public void cancel() {
            OnBackPressedDispatcher.this.f25b.remove(this.f34a);
            this.f34a.e(this);
            if (BuildCompat.d()) {
                this.f34a.g(null);
                OnBackPressedDispatcher.this.h();
            }
        }
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public OnBackPressedDispatcher(@Nullable Runnable runnable) {
        this.f24a = runnable;
        if (BuildCompat.d()) {
            this.f26c = new androidx.core.util.a() { // from class: androidx.activity.h
                @Override // androidx.core.util.a
                public final void accept(Object obj) {
                    this.f45e.e((Boolean) obj);
                }
            };
            this.f27d = a.a(new Runnable() { // from class: androidx.activity.i
                @Override // java.lang.Runnable
                public final void run() {
                    this.f46e.f();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(Boolean bool) {
        if (BuildCompat.d()) {
            h();
        }
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @SuppressLint({"LambdaLast"})
    @MainThread
    public void b(@NonNull m mVar, @NonNull g gVar) {
        Lifecycle lifecycle = mVar.getLifecycle();
        if (lifecycle.b() == Lifecycle.State.DESTROYED) {
            return;
        }
        gVar.a(new LifecycleOnBackPressedCancellable(lifecycle, gVar));
        if (BuildCompat.d()) {
            h();
            gVar.g(this.f26c);
        }
    }

    @NonNull
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @MainThread
    android.view.a c(@NonNull g gVar) {
        this.f25b.add(gVar);
        b bVar = new b(gVar);
        gVar.a(bVar);
        if (BuildCompat.d()) {
            h();
            gVar.g(this.f26c);
        }
        return bVar;
    }

    @MainThread
    public boolean d() {
        Iterator<g> itDescendingIterator = this.f25b.descendingIterator();
        while (itDescendingIterator.hasNext()) {
            if (itDescendingIterator.next().c()) {
                return true;
            }
        }
        return false;
    }

    @MainThread
    public void f() {
        Iterator<g> itDescendingIterator = this.f25b.descendingIterator();
        while (itDescendingIterator.hasNext()) {
            g next = itDescendingIterator.next();
            if (next.c()) {
                next.b();
                return;
            }
        }
        Runnable runnable = this.f24a;
        if (runnable != null) {
            runnable.run();
        }
    }

    @RequiresApi(33)
    public void g(@NonNull OnBackInvokedDispatcher onBackInvokedDispatcher) {
        this.f28e = onBackInvokedDispatcher;
        h();
    }

    @RequiresApi(33)
    void h() {
        boolean zD = d();
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.f28e;
        if (onBackInvokedDispatcher != null) {
            if (zD && !this.f29f) {
                a.b(onBackInvokedDispatcher, 0, this.f27d);
                this.f29f = true;
            } else {
                if (zD || !this.f29f) {
                    return;
                }
                a.c(onBackInvokedDispatcher, this.f27d);
                this.f29f = false;
            }
        }
    }
}
