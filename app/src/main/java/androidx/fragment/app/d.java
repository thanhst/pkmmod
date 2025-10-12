package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import androidx.annotation.AnimRes;
import androidx.annotation.NonNull;
import androidx.core.os.f;
import androidx.core.view.j0;
import androidx.fragment.R$animator;
import androidx.fragment.R$id;
import androidx.fragment.app.s;

/* compiled from: FragmentAnim.java */
/* loaded from: classes.dex */
class d {

    /* compiled from: FragmentAnim.java */
    class a implements f.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Fragment f2227a;

        a(Fragment fragment) {
            this.f2227a = fragment;
        }

        @Override // androidx.core.os.f.b
        public void onCancel() {
            if (this.f2227a.getAnimatingAway() != null) {
                View animatingAway = this.f2227a.getAnimatingAway();
                this.f2227a.setAnimatingAway(null);
                animatingAway.clearAnimation();
            }
            this.f2227a.setAnimator(null);
        }
    }

    /* compiled from: FragmentAnim.java */
    class b implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f2228a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Fragment f2229b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ s.g f2230c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ androidx.core.os.f f2231d;

        /* compiled from: FragmentAnim.java */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (b.this.f2229b.getAnimatingAway() != null) {
                    b.this.f2229b.setAnimatingAway(null);
                    b bVar = b.this;
                    bVar.f2230c.a(bVar.f2229b, bVar.f2231d);
                }
            }
        }

        b(ViewGroup viewGroup, Fragment fragment, s.g gVar, androidx.core.os.f fVar) {
            this.f2228a = viewGroup;
            this.f2229b = fragment;
            this.f2230c = gVar;
            this.f2231d = fVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f2228a.post(new a());
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* compiled from: FragmentAnim.java */
    class c extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f2233a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f2234b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Fragment f2235c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ s.g f2236d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ androidx.core.os.f f2237e;

        c(ViewGroup viewGroup, View view, Fragment fragment, s.g gVar, androidx.core.os.f fVar) {
            this.f2233a = viewGroup;
            this.f2234b = view;
            this.f2235c = fragment;
            this.f2236d = gVar;
            this.f2237e = fVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f2233a.endViewTransition(this.f2234b);
            Animator animator2 = this.f2235c.getAnimator();
            this.f2235c.setAnimator(null);
            if (animator2 == null || this.f2233a.indexOfChild(this.f2234b) >= 0) {
                return;
            }
            this.f2236d.a(this.f2235c, this.f2237e);
        }
    }

    static void a(@NonNull Fragment fragment, @NonNull C0030d c0030d, @NonNull s.g gVar) {
        View view = fragment.mView;
        ViewGroup viewGroup = fragment.mContainer;
        viewGroup.startViewTransition(view);
        androidx.core.os.f fVar = new androidx.core.os.f();
        fVar.c(new a(fragment));
        gVar.b(fragment, fVar);
        if (c0030d.f2238a != null) {
            e eVar = new e(c0030d.f2238a, viewGroup, view);
            fragment.setAnimatingAway(fragment.mView);
            eVar.setAnimationListener(new b(viewGroup, fragment, gVar, fVar));
            fragment.mView.startAnimation(eVar);
            return;
        }
        Animator animator = c0030d.f2239b;
        fragment.setAnimator(animator);
        animator.addListener(new c(viewGroup, view, fragment, gVar, fVar));
        animator.setTarget(fragment.mView);
        animator.start();
    }

    private static int b(Fragment fragment, boolean z2, boolean z3) {
        return z3 ? z2 ? fragment.getPopEnterAnim() : fragment.getPopExitAnim() : z2 ? fragment.getEnterAnim() : fragment.getExitAnim();
    }

    static C0030d c(@NonNull Context context, @NonNull Fragment fragment, boolean z2, boolean z3) {
        int nextTransition = fragment.getNextTransition();
        int iB = b(fragment, z2, z3);
        boolean z4 = false;
        fragment.setAnimations(0, 0, 0, 0);
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            int i2 = R$id.visible_removing_fragment_view_tag;
            if (viewGroup.getTag(i2) != null) {
                fragment.mContainer.setTag(i2, null);
            }
        }
        ViewGroup viewGroup2 = fragment.mContainer;
        if (viewGroup2 != null && viewGroup2.getLayoutTransition() != null) {
            return null;
        }
        Animation animationOnCreateAnimation = fragment.onCreateAnimation(nextTransition, z2, iB);
        if (animationOnCreateAnimation != null) {
            return new C0030d(animationOnCreateAnimation);
        }
        Animator animatorOnCreateAnimator = fragment.onCreateAnimator(nextTransition, z2, iB);
        if (animatorOnCreateAnimator != null) {
            return new C0030d(animatorOnCreateAnimator);
        }
        if (iB == 0 && nextTransition != 0) {
            iB = d(nextTransition, z2);
        }
        if (iB != 0) {
            boolean zEquals = "anim".equals(context.getResources().getResourceTypeName(iB));
            if (zEquals) {
                try {
                    Animation animationLoadAnimation = AnimationUtils.loadAnimation(context, iB);
                    if (animationLoadAnimation != null) {
                        return new C0030d(animationLoadAnimation);
                    }
                    z4 = true;
                } catch (Resources.NotFoundException e2) {
                    throw e2;
                } catch (RuntimeException unused) {
                }
            }
            if (!z4) {
                try {
                    Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, iB);
                    if (animatorLoadAnimator != null) {
                        return new C0030d(animatorLoadAnimator);
                    }
                } catch (RuntimeException e3) {
                    if (zEquals) {
                        throw e3;
                    }
                    Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(context, iB);
                    if (animationLoadAnimation2 != null) {
                        return new C0030d(animationLoadAnimation2);
                    }
                }
            }
        }
        return null;
    }

    @AnimRes
    private static int d(int i2, boolean z2) {
        if (i2 == 4097) {
            return z2 ? R$animator.fragment_open_enter : R$animator.fragment_open_exit;
        }
        if (i2 == 4099) {
            return z2 ? R$animator.fragment_fade_enter : R$animator.fragment_fade_exit;
        }
        if (i2 != 8194) {
            return -1;
        }
        return z2 ? R$animator.fragment_close_enter : R$animator.fragment_close_exit;
    }

    /* compiled from: FragmentAnim.java */
    /* renamed from: androidx.fragment.app.d$d, reason: collision with other inner class name */
    static class C0030d {

        /* renamed from: a, reason: collision with root package name */
        public final Animation f2238a;

        /* renamed from: b, reason: collision with root package name */
        public final Animator f2239b;

        C0030d(Animation animation) {
            this.f2238a = animation;
            this.f2239b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        C0030d(Animator animator) {
            this.f2238a = null;
            this.f2239b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    /* compiled from: FragmentAnim.java */
    static class e extends AnimationSet implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        private final ViewGroup f2240e;

        /* renamed from: f, reason: collision with root package name */
        private final View f2241f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f2242g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f2243h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f2244i;

        e(@NonNull Animation animation, @NonNull ViewGroup viewGroup, @NonNull View view) {
            super(false);
            this.f2244i = true;
            this.f2240e = viewGroup;
            this.f2241f = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j2, @NonNull Transformation transformation) {
            this.f2244i = true;
            if (this.f2242g) {
                return !this.f2243h;
            }
            if (!super.getTransformation(j2, transformation)) {
                this.f2242g = true;
                j0.a(this.f2240e, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f2242g || !this.f2244i) {
                this.f2240e.endViewTransition(this.f2241f);
                this.f2243h = true;
            } else {
                this.f2244i = false;
                this.f2240e.post(this);
            }
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j2, @NonNull Transformation transformation, float f2) {
            this.f2244i = true;
            if (this.f2242g) {
                return !this.f2243h;
            }
            if (!super.getTransformation(j2, transformation, f2)) {
                this.f2242g = true;
                j0.a(this.f2240e, this);
            }
            return true;
        }
    }
}
