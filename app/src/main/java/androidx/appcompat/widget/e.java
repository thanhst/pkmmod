package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;

/* compiled from: AppCompatBackgroundHelper.java */
/* loaded from: classes.dex */
class e {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f916a;

    /* renamed from: d, reason: collision with root package name */
    private i2 f919d;

    /* renamed from: e, reason: collision with root package name */
    private i2 f920e;

    /* renamed from: f, reason: collision with root package name */
    private i2 f921f;

    /* renamed from: c, reason: collision with root package name */
    private int f918c = -1;

    /* renamed from: b, reason: collision with root package name */
    private final k f917b = k.b();

    e(@NonNull View view) {
        this.f916a = view;
    }

    private boolean a(@NonNull Drawable drawable) {
        if (this.f921f == null) {
            this.f921f = new i2();
        }
        i2 i2Var = this.f921f;
        i2Var.a();
        ColorStateList colorStateListN = ViewCompat.n(this.f916a);
        if (colorStateListN != null) {
            i2Var.f974d = true;
            i2Var.f971a = colorStateListN;
        }
        PorterDuff.Mode modeO = ViewCompat.o(this.f916a);
        if (modeO != null) {
            i2Var.f973c = true;
            i2Var.f972b = modeO;
        }
        if (!i2Var.f974d && !i2Var.f973c) {
            return false;
        }
        k.i(drawable, i2Var, this.f916a.getDrawableState());
        return true;
    }

    private boolean k() {
        int i2 = Build.VERSION.SDK_INT;
        return i2 > 21 ? this.f919d != null : i2 == 21;
    }

    void b() {
        Drawable background = this.f916a.getBackground();
        if (background != null) {
            if (k() && a(background)) {
                return;
            }
            i2 i2Var = this.f920e;
            if (i2Var != null) {
                k.i(background, i2Var, this.f916a.getDrawableState());
                return;
            }
            i2 i2Var2 = this.f919d;
            if (i2Var2 != null) {
                k.i(background, i2Var2, this.f916a.getDrawableState());
            }
        }
    }

    ColorStateList c() {
        i2 i2Var = this.f920e;
        if (i2Var != null) {
            return i2Var.f971a;
        }
        return null;
    }

    PorterDuff.Mode d() {
        i2 i2Var = this.f920e;
        if (i2Var != null) {
            return i2Var.f972b;
        }
        return null;
    }

    void e(@Nullable AttributeSet attributeSet, int i2) {
        Context context = this.f916a.getContext();
        int[] iArr = R$styleable.ViewBackgroundHelper;
        k2 k2VarU = k2.u(context, attributeSet, iArr, i2, 0);
        View view = this.f916a;
        ViewCompat.M(view, view.getContext(), iArr, attributeSet, k2VarU.q(), i2, 0);
        try {
            int i3 = R$styleable.ViewBackgroundHelper_android_background;
            if (k2VarU.r(i3)) {
                this.f918c = k2VarU.m(i3, -1);
                ColorStateList colorStateListF = this.f917b.f(this.f916a.getContext(), this.f918c);
                if (colorStateListF != null) {
                    h(colorStateListF);
                }
            }
            int i4 = R$styleable.ViewBackgroundHelper_backgroundTint;
            if (k2VarU.r(i4)) {
                ViewCompat.S(this.f916a, k2VarU.c(i4));
            }
            int i5 = R$styleable.ViewBackgroundHelper_backgroundTintMode;
            if (k2VarU.r(i5)) {
                ViewCompat.T(this.f916a, l1.d(k2VarU.j(i5, -1), null));
            }
        } finally {
            k2VarU.v();
        }
    }

    void f(Drawable drawable) {
        this.f918c = -1;
        h(null);
        b();
    }

    void g(int i2) {
        this.f918c = i2;
        k kVar = this.f917b;
        h(kVar != null ? kVar.f(this.f916a.getContext(), i2) : null);
        b();
    }

    void h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f919d == null) {
                this.f919d = new i2();
            }
            i2 i2Var = this.f919d;
            i2Var.f971a = colorStateList;
            i2Var.f974d = true;
        } else {
            this.f919d = null;
        }
        b();
    }

    void i(ColorStateList colorStateList) {
        if (this.f920e == null) {
            this.f920e = new i2();
        }
        i2 i2Var = this.f920e;
        i2Var.f971a = colorStateList;
        i2Var.f974d = true;
        b();
    }

    void j(PorterDuff.Mode mode) {
        if (this.f920e == null) {
            this.f920e = new i2();
        }
        i2 i2Var = this.f920e;
        i2Var.f972b = mode;
        i2Var.f973c = true;
        b();
    }
}
