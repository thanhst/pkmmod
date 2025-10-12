package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;

/* compiled from: AppCompatCompoundButtonHelper.java */
/* loaded from: classes.dex */
class j {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final CompoundButton f975a;

    /* renamed from: b, reason: collision with root package name */
    private ColorStateList f976b = null;

    /* renamed from: c, reason: collision with root package name */
    private PorterDuff.Mode f977c = null;

    /* renamed from: d, reason: collision with root package name */
    private boolean f978d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f979e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f980f;

    j(@NonNull CompoundButton compoundButton) {
        this.f975a = compoundButton;
    }

    void a() throws NoSuchFieldException, SecurityException {
        Drawable drawableA = androidx.core.widget.i.a(this.f975a);
        if (drawableA != null) {
            if (this.f978d || this.f979e) {
                Drawable drawableMutate = androidx.core.graphics.drawable.a.p(drawableA).mutate();
                if (this.f978d) {
                    androidx.core.graphics.drawable.a.n(drawableMutate, this.f976b);
                }
                if (this.f979e) {
                    androidx.core.graphics.drawable.a.o(drawableMutate, this.f977c);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(this.f975a.getDrawableState());
                }
                this.f975a.setButtonDrawable(drawableMutate);
            }
        }
    }

    int b(int i2) {
        return i2;
    }

    ColorStateList c() {
        return this.f976b;
    }

    PorterDuff.Mode d() {
        return this.f977c;
    }

    void e(@Nullable AttributeSet attributeSet, int i2) {
        boolean z2;
        int iM;
        int iM2;
        Context context = this.f975a.getContext();
        int[] iArr = R$styleable.CompoundButton;
        k2 k2VarU = k2.u(context, attributeSet, iArr, i2, 0);
        CompoundButton compoundButton = this.f975a;
        ViewCompat.M(compoundButton, compoundButton.getContext(), iArr, attributeSet, k2VarU.q(), i2, 0);
        try {
            int i3 = R$styleable.CompoundButton_buttonCompat;
            if (!k2VarU.r(i3) || (iM2 = k2VarU.m(i3, 0)) == 0) {
                z2 = false;
            } else {
                try {
                    CompoundButton compoundButton2 = this.f975a;
                    compoundButton2.setButtonDrawable(e.a.b(compoundButton2.getContext(), iM2));
                    z2 = true;
                } catch (Resources.NotFoundException unused) {
                }
            }
            if (!z2) {
                int i4 = R$styleable.CompoundButton_android_button;
                if (k2VarU.r(i4) && (iM = k2VarU.m(i4, 0)) != 0) {
                    CompoundButton compoundButton3 = this.f975a;
                    compoundButton3.setButtonDrawable(e.a.b(compoundButton3.getContext(), iM));
                }
            }
            int i5 = R$styleable.CompoundButton_buttonTint;
            if (k2VarU.r(i5)) {
                androidx.core.widget.i.b(this.f975a, k2VarU.c(i5));
            }
            int i6 = R$styleable.CompoundButton_buttonTintMode;
            if (k2VarU.r(i6)) {
                androidx.core.widget.i.c(this.f975a, l1.d(k2VarU.j(i6, -1), null));
            }
        } finally {
            k2VarU.v();
        }
    }

    void f() throws NoSuchFieldException, SecurityException {
        if (this.f980f) {
            this.f980f = false;
        } else {
            this.f980f = true;
            a();
        }
    }

    void g(ColorStateList colorStateList) throws NoSuchFieldException, SecurityException {
        this.f976b = colorStateList;
        this.f978d = true;
        a();
    }

    void h(@Nullable PorterDuff.Mode mode) throws NoSuchFieldException, SecurityException {
        this.f977c = mode;
        this.f979e = true;
        a();
    }
}
