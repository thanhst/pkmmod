package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* compiled from: RoundRectDrawable.java */
@RequiresApi(21)
/* loaded from: classes.dex */
class f extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    private float f1276a;

    /* renamed from: c, reason: collision with root package name */
    private final RectF f1278c;

    /* renamed from: d, reason: collision with root package name */
    private final Rect f1279d;

    /* renamed from: e, reason: collision with root package name */
    private float f1280e;

    /* renamed from: h, reason: collision with root package name */
    private ColorStateList f1283h;

    /* renamed from: i, reason: collision with root package name */
    private PorterDuffColorFilter f1284i;

    /* renamed from: j, reason: collision with root package name */
    private ColorStateList f1285j;

    /* renamed from: f, reason: collision with root package name */
    private boolean f1281f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f1282g = true;

    /* renamed from: k, reason: collision with root package name */
    private PorterDuff.Mode f1286k = PorterDuff.Mode.SRC_IN;

    /* renamed from: b, reason: collision with root package name */
    private final Paint f1277b = new Paint(5);

    f(ColorStateList colorStateList, float f2) {
        this.f1276a = f2;
        e(colorStateList);
        this.f1278c = new RectF();
        this.f1279d = new Rect();
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    private void e(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f1283h = colorStateList;
        this.f1277b.setColor(colorStateList.getColorForState(getState(), this.f1283h.getDefaultColor()));
    }

    private void i(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f1278c.set(rect.left, rect.top, rect.right, rect.bottom);
        this.f1279d.set(rect);
        if (this.f1281f) {
            this.f1279d.inset((int) Math.ceil(g.c(this.f1280e, this.f1276a, this.f1282g)), (int) Math.ceil(g.d(this.f1280e, this.f1276a, this.f1282g)));
            this.f1278c.set(this.f1279d);
        }
    }

    public ColorStateList b() {
        return this.f1283h;
    }

    float c() {
        return this.f1280e;
    }

    public float d() {
        return this.f1276a;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z2;
        Paint paint = this.f1277b;
        if (this.f1284i == null || paint.getColorFilter() != null) {
            z2 = false;
        } else {
            paint.setColorFilter(this.f1284i);
            z2 = true;
        }
        RectF rectF = this.f1278c;
        float f2 = this.f1276a;
        canvas.drawRoundRect(rectF, f2, f2, paint);
        if (z2) {
            paint.setColorFilter(null);
        }
    }

    public void f(@Nullable ColorStateList colorStateList) {
        e(colorStateList);
        invalidateSelf();
    }

    void g(float f2, boolean z2, boolean z3) {
        if (f2 == this.f1280e && this.f1281f == z2 && this.f1282g == z3) {
            return;
        }
        this.f1280e = f2;
        this.f1281f = z2;
        this.f1282g = z3;
        i(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f1279d, this.f1276a);
    }

    void h(float f2) {
        if (f2 == this.f1276a) {
            return;
        }
        this.f1276a = f2;
        i(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f1285j;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f1283h) != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        i(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f1283h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        boolean z2 = colorForState != this.f1277b.getColor();
        if (z2) {
            this.f1277b.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f1285j;
        if (colorStateList2 == null || (mode = this.f1286k) == null) {
            return z2;
        }
        this.f1284i = a(colorStateList2, mode);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f1277b.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f1277b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f1285j = colorStateList;
        this.f1284i = a(colorStateList, this.f1286k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f1286k = mode;
        this.f1284i = a(this.f1285j, mode);
        invalidateSelf();
    }
}
