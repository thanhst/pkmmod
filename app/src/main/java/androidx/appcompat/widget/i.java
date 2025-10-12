package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;

/* compiled from: AppCompatCheckedTextViewHelper.java */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
class i {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final CheckedTextView f962a;

    /* renamed from: b, reason: collision with root package name */
    private ColorStateList f963b = null;

    /* renamed from: c, reason: collision with root package name */
    private PorterDuff.Mode f964c = null;

    /* renamed from: d, reason: collision with root package name */
    private boolean f965d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f966e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f967f;

    i(@NonNull CheckedTextView checkedTextView) {
        this.f962a = checkedTextView;
    }

    void a() {
        Drawable drawableA = androidx.core.widget.b.a(this.f962a);
        if (drawableA != null) {
            if (this.f965d || this.f966e) {
                Drawable drawableMutate = androidx.core.graphics.drawable.a.p(drawableA).mutate();
                if (this.f965d) {
                    androidx.core.graphics.drawable.a.n(drawableMutate, this.f963b);
                }
                if (this.f966e) {
                    androidx.core.graphics.drawable.a.o(drawableMutate, this.f964c);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(this.f962a.getDrawableState());
                }
                this.f962a.setCheckMarkDrawable(drawableMutate);
            }
        }
    }

    ColorStateList b() {
        return this.f963b;
    }

    PorterDuff.Mode c() {
        return this.f964c;
    }

    void d(@Nullable AttributeSet attributeSet, int i2) {
        boolean z2;
        int iM;
        int iM2;
        Context context = this.f962a.getContext();
        int[] iArr = R$styleable.CheckedTextView;
        k2 k2VarU = k2.u(context, attributeSet, iArr, i2, 0);
        CheckedTextView checkedTextView = this.f962a;
        ViewCompat.M(checkedTextView, checkedTextView.getContext(), iArr, attributeSet, k2VarU.q(), i2, 0);
        try {
            int i3 = R$styleable.CheckedTextView_checkMarkCompat;
            if (!k2VarU.r(i3) || (iM2 = k2VarU.m(i3, 0)) == 0) {
                z2 = false;
            } else {
                try {
                    CheckedTextView checkedTextView2 = this.f962a;
                    checkedTextView2.setCheckMarkDrawable(e.a.b(checkedTextView2.getContext(), iM2));
                    z2 = true;
                } catch (Resources.NotFoundException unused) {
                }
            }
            if (!z2) {
                int i4 = R$styleable.CheckedTextView_android_checkMark;
                if (k2VarU.r(i4) && (iM = k2VarU.m(i4, 0)) != 0) {
                    CheckedTextView checkedTextView3 = this.f962a;
                    checkedTextView3.setCheckMarkDrawable(e.a.b(checkedTextView3.getContext(), iM));
                }
            }
            int i5 = R$styleable.CheckedTextView_checkMarkTint;
            if (k2VarU.r(i5)) {
                androidx.core.widget.b.b(this.f962a, k2VarU.c(i5));
            }
            int i6 = R$styleable.CheckedTextView_checkMarkTintMode;
            if (k2VarU.r(i6)) {
                androidx.core.widget.b.c(this.f962a, l1.d(k2VarU.j(i6, -1), null));
            }
        } finally {
            k2VarU.v();
        }
    }

    void e() {
        if (this.f967f) {
            this.f967f = false;
        } else {
            this.f967f = true;
            a();
        }
    }

    void f(ColorStateList colorStateList) {
        this.f963b = colorStateList;
        this.f965d = true;
        a();
    }

    void g(@Nullable PorterDuff.Mode mode) {
        this.f964c = mode;
        this.f966e = true;
        a();
    }
}
