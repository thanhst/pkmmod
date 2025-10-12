package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;

/* compiled from: AppCompatImageHelper.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ImageView f1074a;

    /* renamed from: b, reason: collision with root package name */
    private i2 f1075b;

    /* renamed from: c, reason: collision with root package name */
    private i2 f1076c;

    /* renamed from: d, reason: collision with root package name */
    private i2 f1077d;

    /* renamed from: e, reason: collision with root package name */
    private int f1078e = 0;

    public q(@NonNull ImageView imageView) {
        this.f1074a = imageView;
    }

    private boolean a(@NonNull Drawable drawable) {
        if (this.f1077d == null) {
            this.f1077d = new i2();
        }
        i2 i2Var = this.f1077d;
        i2Var.a();
        ColorStateList colorStateListA = androidx.core.widget.s.a(this.f1074a);
        if (colorStateListA != null) {
            i2Var.f974d = true;
            i2Var.f971a = colorStateListA;
        }
        PorterDuff.Mode modeB = androidx.core.widget.s.b(this.f1074a);
        if (modeB != null) {
            i2Var.f973c = true;
            i2Var.f972b = modeB;
        }
        if (!i2Var.f974d && !i2Var.f973c) {
            return false;
        }
        k.i(drawable, i2Var, this.f1074a.getDrawableState());
        return true;
    }

    private boolean l() {
        int i2 = Build.VERSION.SDK_INT;
        return i2 > 21 ? this.f1075b != null : i2 == 21;
    }

    void b() {
        if (this.f1074a.getDrawable() != null) {
            this.f1074a.getDrawable().setLevel(this.f1078e);
        }
    }

    void c() {
        Drawable drawable = this.f1074a.getDrawable();
        if (drawable != null) {
            l1.b(drawable);
        }
        if (drawable != null) {
            if (l() && a(drawable)) {
                return;
            }
            i2 i2Var = this.f1076c;
            if (i2Var != null) {
                k.i(drawable, i2Var, this.f1074a.getDrawableState());
                return;
            }
            i2 i2Var2 = this.f1075b;
            if (i2Var2 != null) {
                k.i(drawable, i2Var2, this.f1074a.getDrawableState());
            }
        }
    }

    ColorStateList d() {
        i2 i2Var = this.f1076c;
        if (i2Var != null) {
            return i2Var.f971a;
        }
        return null;
    }

    PorterDuff.Mode e() {
        i2 i2Var = this.f1076c;
        if (i2Var != null) {
            return i2Var.f972b;
        }
        return null;
    }

    boolean f() {
        return Build.VERSION.SDK_INT < 21 || !(this.f1074a.getBackground() instanceof RippleDrawable);
    }

    public void g(AttributeSet attributeSet, int i2) {
        int iM;
        Context context = this.f1074a.getContext();
        int[] iArr = R$styleable.AppCompatImageView;
        k2 k2VarU = k2.u(context, attributeSet, iArr, i2, 0);
        ImageView imageView = this.f1074a;
        ViewCompat.M(imageView, imageView.getContext(), iArr, attributeSet, k2VarU.q(), i2, 0);
        try {
            Drawable drawable = this.f1074a.getDrawable();
            if (drawable == null && (iM = k2VarU.m(R$styleable.AppCompatImageView_srcCompat, -1)) != -1 && (drawable = e.a.b(this.f1074a.getContext(), iM)) != null) {
                this.f1074a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                l1.b(drawable);
            }
            int i3 = R$styleable.AppCompatImageView_tint;
            if (k2VarU.r(i3)) {
                androidx.core.widget.s.c(this.f1074a, k2VarU.c(i3));
            }
            int i4 = R$styleable.AppCompatImageView_tintMode;
            if (k2VarU.r(i4)) {
                androidx.core.widget.s.d(this.f1074a, l1.d(k2VarU.j(i4, -1), null));
            }
        } finally {
            k2VarU.v();
        }
    }

    void h(@NonNull Drawable drawable) {
        this.f1078e = drawable.getLevel();
    }

    public void i(int i2) {
        if (i2 != 0) {
            Drawable drawableB = e.a.b(this.f1074a.getContext(), i2);
            if (drawableB != null) {
                l1.b(drawableB);
            }
            this.f1074a.setImageDrawable(drawableB);
        } else {
            this.f1074a.setImageDrawable(null);
        }
        c();
    }

    void j(ColorStateList colorStateList) {
        if (this.f1076c == null) {
            this.f1076c = new i2();
        }
        i2 i2Var = this.f1076c;
        i2Var.f971a = colorStateList;
        i2Var.f974d = true;
        c();
    }

    void k(PorterDuff.Mode mode) {
        if (this.f1076c == null) {
            this.f1076c = new i2();
        }
        i2 i2Var = this.f1076c;
        i2Var.f972b = mode;
        i2Var.f973c = true;
        c();
    }
}
