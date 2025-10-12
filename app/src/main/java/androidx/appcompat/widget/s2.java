package androidx.appcompat.widget;

import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;

/* compiled from: TooltipCompatHandler.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
class s2 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* renamed from: o, reason: collision with root package name */
    private static s2 f1123o;

    /* renamed from: p, reason: collision with root package name */
    private static s2 f1124p;

    /* renamed from: e, reason: collision with root package name */
    private final View f1125e;

    /* renamed from: f, reason: collision with root package name */
    private final CharSequence f1126f;

    /* renamed from: g, reason: collision with root package name */
    private final int f1127g;

    /* renamed from: h, reason: collision with root package name */
    private final Runnable f1128h = new Runnable() { // from class: androidx.appcompat.widget.q2
        @Override // java.lang.Runnable
        public final void run() throws Resources.NotFoundException {
            this.f1109e.e();
        }
    };

    /* renamed from: i, reason: collision with root package name */
    private final Runnable f1129i = new Runnable() { // from class: androidx.appcompat.widget.r2
        @Override // java.lang.Runnable
        public final void run() {
            this.f1120e.d();
        }
    };

    /* renamed from: j, reason: collision with root package name */
    private int f1130j;

    /* renamed from: k, reason: collision with root package name */
    private int f1131k;

    /* renamed from: l, reason: collision with root package name */
    private t2 f1132l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f1133m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f1134n;

    private s2(View view, CharSequence charSequence) {
        this.f1125e = view;
        this.f1126f = charSequence;
        this.f1127g = androidx.core.view.k2.a(ViewConfiguration.get(view.getContext()));
        c();
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    private void b() {
        this.f1125e.removeCallbacks(this.f1128h);
    }

    private void c() {
        this.f1134n = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() throws Resources.NotFoundException {
        i(false);
    }

    private void f() {
        this.f1125e.postDelayed(this.f1128h, ViewConfiguration.getLongPressTimeout());
    }

    private static void g(s2 s2Var) {
        s2 s2Var2 = f1123o;
        if (s2Var2 != null) {
            s2Var2.b();
        }
        f1123o = s2Var;
        if (s2Var != null) {
            s2Var.f();
        }
    }

    public static void h(View view, CharSequence charSequence) {
        s2 s2Var = f1123o;
        if (s2Var != null && s2Var.f1125e == view) {
            g(null);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            new s2(view, charSequence);
            return;
        }
        s2 s2Var2 = f1124p;
        if (s2Var2 != null && s2Var2.f1125e == view) {
            s2Var2.d();
        }
        view.setOnLongClickListener(null);
        view.setLongClickable(false);
        view.setOnHoverListener(null);
    }

    private boolean j(MotionEvent motionEvent) {
        int x2 = (int) motionEvent.getX();
        int y2 = (int) motionEvent.getY();
        if (!this.f1134n && Math.abs(x2 - this.f1130j) <= this.f1127g && Math.abs(y2 - this.f1131k) <= this.f1127g) {
            return false;
        }
        this.f1130j = x2;
        this.f1131k = y2;
        this.f1134n = false;
        return true;
    }

    void d() {
        if (f1124p == this) {
            f1124p = null;
            t2 t2Var = this.f1132l;
            if (t2Var != null) {
                t2Var.c();
                this.f1132l = null;
                c();
                this.f1125e.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f1123o == this) {
            g(null);
        }
        this.f1125e.removeCallbacks(this.f1129i);
    }

    void i(boolean z2) throws Resources.NotFoundException {
        long j2;
        int longPressTimeout;
        long j3;
        if (ViewCompat.A(this.f1125e)) {
            g(null);
            s2 s2Var = f1124p;
            if (s2Var != null) {
                s2Var.d();
            }
            f1124p = this;
            this.f1133m = z2;
            t2 t2Var = new t2(this.f1125e.getContext());
            this.f1132l = t2Var;
            t2Var.e(this.f1125e, this.f1130j, this.f1131k, this.f1133m, this.f1126f);
            this.f1125e.addOnAttachStateChangeListener(this);
            if (this.f1133m) {
                j3 = 2500;
            } else {
                if ((ViewCompat.x(this.f1125e) & 1) == 1) {
                    j2 = 3000;
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                } else {
                    j2 = 15000;
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                }
                j3 = j2 - longPressTimeout;
            }
            this.f1125e.removeCallbacks(this.f1129i);
            this.f1125e.postDelayed(this.f1129i, j3);
        }
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f1132l != null && this.f1133m) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f1125e.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                c();
                d();
            }
        } else if (this.f1125e.isEnabled() && this.f1132l == null && j(motionEvent)) {
            g(this);
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) throws Resources.NotFoundException {
        this.f1130j = view.getWidth() / 2;
        this.f1131k = view.getHeight() / 2;
        i(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        d();
    }
}
