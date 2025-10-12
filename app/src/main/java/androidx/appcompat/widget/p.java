package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R$attr;

/* compiled from: AppCompatImageButton.java */
/* loaded from: classes.dex */
public class p extends ImageButton implements androidx.core.view.k0, androidx.core.widget.p0 {

    /* renamed from: e, reason: collision with root package name */
    private final e f1060e;

    /* renamed from: f, reason: collision with root package name */
    private final q f1061f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f1062g;

    public p(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.imageButtonStyle);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f1060e;
        if (eVar != null) {
            eVar.b();
        }
        q qVar = this.f1061f;
        if (qVar != null) {
            qVar.c();
        }
    }

    @Override // androidx.core.view.k0
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f1060e;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    @Override // androidx.core.view.k0
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f1060e;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    @Override // androidx.core.widget.p0
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportImageTintList() {
        q qVar = this.f1061f;
        if (qVar != null) {
            return qVar.d();
        }
        return null;
    }

    @Override // androidx.core.widget.p0
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportImageTintMode() {
        q qVar = this.f1061f;
        if (qVar != null) {
            return qVar.e();
        }
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return this.f1061f.f() && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f1060e;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int i2) {
        super.setBackgroundResource(i2);
        e eVar = this.f1060e;
        if (eVar != null) {
            eVar.g(i2);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        q qVar = this.f1061f;
        if (qVar != null) {
            qVar.c();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        q qVar = this.f1061f;
        if (qVar != null && drawable != null && !this.f1062g) {
            qVar.h(drawable);
        }
        super.setImageDrawable(drawable);
        q qVar2 = this.f1061f;
        if (qVar2 != null) {
            qVar2.c();
            if (this.f1062g) {
                return;
            }
            this.f1061f.b();
        }
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int i2) {
        super.setImageLevel(i2);
        this.f1062g = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(@DrawableRes int i2) {
        this.f1061f.i(i2);
    }

    @Override // android.widget.ImageView
    public void setImageURI(@Nullable Uri uri) {
        super.setImageURI(uri);
        q qVar = this.f1061f;
        if (qVar != null) {
            qVar.c();
        }
    }

    @Override // androidx.core.view.k0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        e eVar = this.f1060e;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    @Override // androidx.core.view.k0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        e eVar = this.f1060e;
        if (eVar != null) {
            eVar.j(mode);
        }
    }

    @Override // androidx.core.widget.p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportImageTintList(@Nullable ColorStateList colorStateList) {
        q qVar = this.f1061f;
        if (qVar != null) {
            qVar.j(colorStateList);
        }
    }

    @Override // androidx.core.widget.p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportImageTintMode(@Nullable PorterDuff.Mode mode) {
        q qVar = this.f1061f;
        if (qVar != null) {
            qVar.k(mode);
        }
    }

    public p(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(h2.b(context), attributeSet, i2);
        this.f1062g = false;
        f2.a(this, getContext());
        e eVar = new e(this);
        this.f1060e = eVar;
        eVar.e(attributeSet, i2);
        q qVar = new q(this);
        this.f1061f = qVar;
        qVar.g(attributeSet, i2);
    }
}
