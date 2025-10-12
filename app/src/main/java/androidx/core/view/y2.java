package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.ref.WeakReference;

/* compiled from: ViewPropertyAnimatorCompat.java */
/* loaded from: classes.dex */
public final class y2 {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<View> f1780a;

    /* renamed from: b, reason: collision with root package name */
    Runnable f1781b = null;

    /* renamed from: c, reason: collision with root package name */
    Runnable f1782c = null;

    /* renamed from: d, reason: collision with root package name */
    int f1783d = -1;

    /* compiled from: ViewPropertyAnimatorCompat.java */
    class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ z2 f1784a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f1785b;

        a(z2 z2Var, View view) {
            this.f1784a = z2Var;
            this.f1785b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f1784a.a(this.f1785b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1784a.b(this.f1785b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f1784a.c(this.f1785b);
        }
    }

    /* compiled from: ViewPropertyAnimatorCompat.java */
    @RequiresApi(19)
    static class b {
        @DoNotInline
        static ViewPropertyAnimator a(ViewPropertyAnimator viewPropertyAnimator, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
            return viewPropertyAnimator.setUpdateListener(animatorUpdateListener);
        }
    }

    y2(View view) {
        this.f1780a = new WeakReference<>(view);
    }

    private void i(View view, z2 z2Var) {
        if (z2Var != null) {
            view.animate().setListener(new a(z2Var, view));
        } else {
            view.animate().setListener(null);
        }
    }

    @NonNull
    public y2 b(float f2) {
        View view = this.f1780a.get();
        if (view != null) {
            view.animate().alpha(f2);
        }
        return this;
    }

    public void c() {
        View view = this.f1780a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public long d() {
        View view = this.f1780a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    @NonNull
    public y2 f(long j2) {
        View view = this.f1780a.get();
        if (view != null) {
            view.animate().setDuration(j2);
        }
        return this;
    }

    @NonNull
    public y2 g(@Nullable Interpolator interpolator) {
        View view = this.f1780a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    @NonNull
    public y2 h(@Nullable z2 z2Var) {
        View view = this.f1780a.get();
        if (view != null) {
            i(view, z2Var);
        }
        return this;
    }

    @NonNull
    public y2 j(long j2) {
        View view = this.f1780a.get();
        if (view != null) {
            view.animate().setStartDelay(j2);
        }
        return this;
    }

    @NonNull
    public y2 k(@Nullable final b3 b3Var) {
        final View view = this.f1780a.get();
        if (view != null) {
            b.a(view.animate(), b3Var != null ? new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.core.view.x2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    b3Var.a(view);
                }
            } : null);
        }
        return this;
    }

    public void l() {
        View view = this.f1780a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    @NonNull
    public y2 m(float f2) {
        View view = this.f1780a.get();
        if (view != null) {
            view.animate().translationY(f2);
        }
        return this;
    }
}
