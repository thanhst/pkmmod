package androidx.core.view;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;

/* compiled from: OneShotPreDrawListener.java */
/* loaded from: classes.dex */
public final class j0 implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: e, reason: collision with root package name */
    private final View f1773e;

    /* renamed from: f, reason: collision with root package name */
    private ViewTreeObserver f1774f;

    /* renamed from: g, reason: collision with root package name */
    private final Runnable f1775g;

    private j0(View view, Runnable runnable) {
        this.f1773e = view;
        this.f1774f = view.getViewTreeObserver();
        this.f1775g = runnable;
    }

    @NonNull
    public static j0 a(@NonNull View view, @NonNull Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        }
        if (runnable == null) {
            throw new NullPointerException("runnable == null");
        }
        j0 j0Var = new j0(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(j0Var);
        view.addOnAttachStateChangeListener(j0Var);
        return j0Var;
    }

    public void b() {
        if (this.f1774f.isAlive()) {
            this.f1774f.removeOnPreDrawListener(this);
        } else {
            this.f1773e.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f1773e.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        b();
        this.f1775g.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(@NonNull View view) {
        this.f1774f = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(@NonNull View view) {
        b();
    }
}
