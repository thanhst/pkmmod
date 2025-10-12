package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* compiled from: WrappedDrawableApi14.java */
/* loaded from: classes.dex */
class t extends Drawable implements Drawable.Callback, s, r {

    /* renamed from: k, reason: collision with root package name */
    static final PorterDuff.Mode f1513k = PorterDuff.Mode.SRC_IN;

    /* renamed from: e, reason: collision with root package name */
    private int f1514e;

    /* renamed from: f, reason: collision with root package name */
    private PorterDuff.Mode f1515f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f1516g;

    /* renamed from: h, reason: collision with root package name */
    w f1517h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f1518i;

    /* renamed from: j, reason: collision with root package name */
    Drawable f1519j;

    t(@NonNull w wVar, @Nullable Resources resources) {
        this.f1517h = wVar;
        e(resources);
    }

    @NonNull
    private w d() {
        return new w(this.f1517h);
    }

    private void e(@Nullable Resources resources) {
        Drawable.ConstantState constantState;
        w wVar = this.f1517h;
        if (wVar == null || (constantState = wVar.f1522b) == null) {
            return;
        }
        a(constantState.newDrawable(resources));
    }

    private boolean f(int[] iArr) {
        if (!c()) {
            return false;
        }
        w wVar = this.f1517h;
        ColorStateList colorStateList = wVar.f1523c;
        PorterDuff.Mode mode = wVar.f1524d;
        if (colorStateList == null || mode == null) {
            this.f1516g = false;
            clearColorFilter();
        } else {
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!this.f1516g || colorForState != this.f1514e || mode != this.f1515f) {
                setColorFilter(colorForState, mode);
                this.f1514e = colorForState;
                this.f1515f = mode;
                this.f1516g = true;
                return true;
            }
        }
        return false;
    }

    @Override // androidx.core.graphics.drawable.s
    public final void a(Drawable drawable) {
        Drawable drawable2 = this.f1519j;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f1519j = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            w wVar = this.f1517h;
            if (wVar != null) {
                wVar.f1522b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    @Override // androidx.core.graphics.drawable.s
    public final Drawable b() {
        return this.f1519j;
    }

    protected boolean c() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.f1519j.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        w wVar = this.f1517h;
        return changingConfigurations | (wVar != null ? wVar.getChangingConfigurations() : 0) | this.f1519j.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        w wVar = this.f1517h;
        if (wVar == null || !wVar.a()) {
            return null;
        }
        this.f1517h.f1521a = getChangingConfigurations();
        return this.f1517h;
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable getCurrent() {
        return this.f1519j.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f1519j.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f1519j.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(23)
    public int getLayoutDirection() {
        return a.e(this.f1519j);
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f1519j.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f1519j.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f1519j.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        return this.f1519j.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public int[] getState() {
        return this.f1519j.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.f1519j.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(19)
    public boolean isAutoMirrored() {
        return a.g(this.f1519j);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        w wVar;
        ColorStateList colorStateList = (!c() || (wVar = this.f1517h) == null) ? null : wVar.f1523c;
        return (colorStateList != null && colorStateList.isStateful()) || this.f1519j.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.f1519j.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        if (!this.f1518i && super.mutate() == this) {
            this.f1517h = d();
            Drawable drawable = this.f1519j;
            if (drawable != null) {
                drawable.mutate();
            }
            w wVar = this.f1517h;
            if (wVar != null) {
                Drawable drawable2 = this.f1519j;
                wVar.f1522b = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.f1518i = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f1519j;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(23)
    public boolean onLayoutDirectionChanged(int i2) {
        return a.l(this.f1519j, i2);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i2) {
        return this.f1519j.setLevel(i2);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j2) {
        scheduleSelf(runnable, j2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f1519j.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(19)
    public void setAutoMirrored(boolean z2) {
        a.i(this.f1519j, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i2) {
        this.f1519j.setChangingConfigurations(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f1519j.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z2) {
        this.f1519j.setDither(z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z2) {
        this.f1519j.setFilterBitmap(z2);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(@NonNull int[] iArr) {
        return f(iArr) || this.f1519j.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.r
    public void setTint(int i2) {
        setTintList(ColorStateList.valueOf(i2));
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.r
    public void setTintList(ColorStateList colorStateList) {
        this.f1517h.f1523c = colorStateList;
        f(getState());
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.r
    public void setTintMode(@NonNull PorterDuff.Mode mode) {
        this.f1517h.f1524d = mode;
        f(getState());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z2, boolean z3) {
        return super.setVisible(z2, z3) || this.f1519j.setVisible(z2, z3);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        unscheduleSelf(runnable);
    }

    t(@Nullable Drawable drawable) {
        this.f1517h = d();
        a(drawable);
    }
}
