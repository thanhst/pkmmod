package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.annotation.Nullable;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;
import java.lang.reflect.InvocationTargetException;

/* compiled from: AppCompatSeekBarHelper.java */
/* loaded from: classes.dex */
class r0 extends l0 {

    /* renamed from: d, reason: collision with root package name */
    private final SeekBar f1114d;

    /* renamed from: e, reason: collision with root package name */
    private Drawable f1115e;

    /* renamed from: f, reason: collision with root package name */
    private ColorStateList f1116f;

    /* renamed from: g, reason: collision with root package name */
    private PorterDuff.Mode f1117g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f1118h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f1119i;

    r0(SeekBar seekBar) {
        super(seekBar);
        this.f1116f = null;
        this.f1117g = null;
        this.f1118h = false;
        this.f1119i = false;
        this.f1114d = seekBar;
    }

    private void f() {
        Drawable drawable = this.f1115e;
        if (drawable != null) {
            if (this.f1118h || this.f1119i) {
                Drawable drawableP = androidx.core.graphics.drawable.a.p(drawable.mutate());
                this.f1115e = drawableP;
                if (this.f1118h) {
                    androidx.core.graphics.drawable.a.n(drawableP, this.f1116f);
                }
                if (this.f1119i) {
                    androidx.core.graphics.drawable.a.o(this.f1115e, this.f1117g);
                }
                if (this.f1115e.isStateful()) {
                    this.f1115e.setState(this.f1114d.getDrawableState());
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.l0
    void c(AttributeSet attributeSet, int i2) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super.c(attributeSet, i2);
        Context context = this.f1114d.getContext();
        int[] iArr = R$styleable.AppCompatSeekBar;
        k2 k2VarU = k2.u(context, attributeSet, iArr, i2, 0);
        SeekBar seekBar = this.f1114d;
        ViewCompat.M(seekBar, seekBar.getContext(), iArr, attributeSet, k2VarU.q(), i2, 0);
        Drawable drawableG = k2VarU.g(R$styleable.AppCompatSeekBar_android_thumb);
        if (drawableG != null) {
            this.f1114d.setThumb(drawableG);
        }
        j(k2VarU.f(R$styleable.AppCompatSeekBar_tickMark));
        int i3 = R$styleable.AppCompatSeekBar_tickMarkTintMode;
        if (k2VarU.r(i3)) {
            this.f1117g = l1.d(k2VarU.j(i3, -1), this.f1117g);
            this.f1119i = true;
        }
        int i4 = R$styleable.AppCompatSeekBar_tickMarkTint;
        if (k2VarU.r(i4)) {
            this.f1116f = k2VarU.c(i4);
            this.f1118h = true;
        }
        k2VarU.v();
        f();
    }

    void g(Canvas canvas) {
        if (this.f1115e != null) {
            int max = this.f1114d.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f1115e.getIntrinsicWidth();
                int intrinsicHeight = this.f1115e.getIntrinsicHeight();
                int i2 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i3 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f1115e.setBounds(-i2, -i3, i2, i3);
                float width = ((this.f1114d.getWidth() - this.f1114d.getPaddingLeft()) - this.f1114d.getPaddingRight()) / max;
                int iSave = canvas.save();
                canvas.translate(this.f1114d.getPaddingLeft(), this.f1114d.getHeight() / 2);
                for (int i4 = 0; i4 <= max; i4++) {
                    this.f1115e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(iSave);
            }
        }
    }

    void h() {
        Drawable drawable = this.f1115e;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f1114d.getDrawableState())) {
            this.f1114d.invalidateDrawable(drawable);
        }
    }

    void i() {
        Drawable drawable = this.f1115e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    void j(@Nullable Drawable drawable) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Drawable drawable2 = this.f1115e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f1115e = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f1114d);
            androidx.core.graphics.drawable.a.l(drawable, ViewCompat.r(this.f1114d));
            if (drawable.isStateful()) {
                drawable.setState(this.f1114d.getDrawableState());
            }
            f();
        }
        this.f1114d.invalidate();
    }
}
