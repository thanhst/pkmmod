package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import androidx.cardview.R$color;
import androidx.cardview.R$dimen;

/* compiled from: RoundRectDrawableWithShadow.java */
/* loaded from: classes.dex */
class g extends Drawable {

    /* renamed from: q, reason: collision with root package name */
    private static final double f1287q = Math.cos(Math.toRadians(45.0d));

    /* renamed from: r, reason: collision with root package name */
    static a f1288r;

    /* renamed from: a, reason: collision with root package name */
    private final int f1289a;

    /* renamed from: c, reason: collision with root package name */
    private Paint f1291c;

    /* renamed from: d, reason: collision with root package name */
    private Paint f1292d;

    /* renamed from: e, reason: collision with root package name */
    private final RectF f1293e;

    /* renamed from: f, reason: collision with root package name */
    private float f1294f;

    /* renamed from: g, reason: collision with root package name */
    private Path f1295g;

    /* renamed from: h, reason: collision with root package name */
    private float f1296h;

    /* renamed from: i, reason: collision with root package name */
    private float f1297i;

    /* renamed from: j, reason: collision with root package name */
    private float f1298j;

    /* renamed from: k, reason: collision with root package name */
    private ColorStateList f1299k;

    /* renamed from: m, reason: collision with root package name */
    private final int f1301m;

    /* renamed from: n, reason: collision with root package name */
    private final int f1302n;

    /* renamed from: l, reason: collision with root package name */
    private boolean f1300l = true;

    /* renamed from: o, reason: collision with root package name */
    private boolean f1303o = true;

    /* renamed from: p, reason: collision with root package name */
    private boolean f1304p = false;

    /* renamed from: b, reason: collision with root package name */
    private Paint f1290b = new Paint(5);

    /* compiled from: RoundRectDrawableWithShadow.java */
    interface a {
        void a(Canvas canvas, RectF rectF, float f2, Paint paint);
    }

    g(Resources resources, ColorStateList colorStateList, float f2, float f3, float f4) {
        this.f1301m = resources.getColor(R$color.cardview_shadow_start_color);
        this.f1302n = resources.getColor(R$color.cardview_shadow_end_color);
        this.f1289a = resources.getDimensionPixelSize(R$dimen.cardview_compat_inset_shadow);
        n(colorStateList);
        Paint paint = new Paint(5);
        this.f1291c = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f1294f = (int) (f2 + 0.5f);
        this.f1293e = new RectF();
        Paint paint2 = new Paint(this.f1291c);
        this.f1292d = paint2;
        paint2.setAntiAlias(false);
        s(f3, f4);
    }

    private void a(Rect rect) {
        float f2 = this.f1296h;
        float f3 = 1.5f * f2;
        this.f1293e.set(rect.left + f2, rect.top + f3, rect.right - f2, rect.bottom - f3);
        b();
    }

    private void b() {
        float f2 = this.f1294f;
        RectF rectF = new RectF(-f2, -f2, f2, f2);
        RectF rectF2 = new RectF(rectF);
        float f3 = this.f1297i;
        rectF2.inset(-f3, -f3);
        Path path = this.f1295g;
        if (path == null) {
            this.f1295g = new Path();
        } else {
            path.reset();
        }
        this.f1295g.setFillType(Path.FillType.EVEN_ODD);
        this.f1295g.moveTo(-this.f1294f, 0.0f);
        this.f1295g.rLineTo(-this.f1297i, 0.0f);
        this.f1295g.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f1295g.arcTo(rectF, 270.0f, -90.0f, false);
        this.f1295g.close();
        float f4 = this.f1294f;
        float f5 = f4 / (this.f1297i + f4);
        Paint paint = this.f1291c;
        float f6 = this.f1294f + this.f1297i;
        int i2 = this.f1301m;
        paint.setShader(new RadialGradient(0.0f, 0.0f, f6, new int[]{i2, i2, this.f1302n}, new float[]{0.0f, f5, 1.0f}, Shader.TileMode.CLAMP));
        Paint paint2 = this.f1292d;
        float f7 = this.f1294f;
        float f8 = this.f1297i;
        int i3 = this.f1301m;
        paint2.setShader(new LinearGradient(0.0f, (-f7) + f8, 0.0f, (-f7) - f8, new int[]{i3, i3, this.f1302n}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.f1292d.setAntiAlias(false);
    }

    static float c(float f2, float f3, boolean z2) {
        if (!z2) {
            return f2;
        }
        double d2 = f2;
        double d3 = 1.0d - f1287q;
        double d4 = f3;
        Double.isNaN(d4);
        Double.isNaN(d2);
        return (float) (d2 + (d3 * d4));
    }

    static float d(float f2, float f3, boolean z2) {
        if (!z2) {
            return f2 * 1.5f;
        }
        double d2 = f2 * 1.5f;
        double d3 = 1.0d - f1287q;
        double d4 = f3;
        Double.isNaN(d4);
        Double.isNaN(d2);
        return (float) (d2 + (d3 * d4));
    }

    private void e(Canvas canvas) {
        float f2 = this.f1294f;
        float f3 = (-f2) - this.f1297i;
        float f4 = f2 + this.f1289a + (this.f1298j / 2.0f);
        float f5 = f4 * 2.0f;
        boolean z2 = this.f1293e.width() - f5 > 0.0f;
        boolean z3 = this.f1293e.height() - f5 > 0.0f;
        int iSave = canvas.save();
        RectF rectF = this.f1293e;
        canvas.translate(rectF.left + f4, rectF.top + f4);
        canvas.drawPath(this.f1295g, this.f1291c);
        if (z2) {
            canvas.drawRect(0.0f, f3, this.f1293e.width() - f5, -this.f1294f, this.f1292d);
        }
        canvas.restoreToCount(iSave);
        int iSave2 = canvas.save();
        RectF rectF2 = this.f1293e;
        canvas.translate(rectF2.right - f4, rectF2.bottom - f4);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f1295g, this.f1291c);
        if (z2) {
            canvas.drawRect(0.0f, f3, this.f1293e.width() - f5, (-this.f1294f) + this.f1297i, this.f1292d);
        }
        canvas.restoreToCount(iSave2);
        int iSave3 = canvas.save();
        RectF rectF3 = this.f1293e;
        canvas.translate(rectF3.left + f4, rectF3.bottom - f4);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f1295g, this.f1291c);
        if (z3) {
            canvas.drawRect(0.0f, f3, this.f1293e.height() - f5, -this.f1294f, this.f1292d);
        }
        canvas.restoreToCount(iSave3);
        int iSave4 = canvas.save();
        RectF rectF4 = this.f1293e;
        canvas.translate(rectF4.right - f4, rectF4.top + f4);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f1295g, this.f1291c);
        if (z3) {
            canvas.drawRect(0.0f, f3, this.f1293e.height() - f5, -this.f1294f, this.f1292d);
        }
        canvas.restoreToCount(iSave4);
    }

    private void n(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f1299k = colorStateList;
        this.f1290b.setColor(colorStateList.getColorForState(getState(), this.f1299k.getDefaultColor()));
    }

    private void s(float f2, float f3) {
        if (f2 < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + f2 + ". Must be >= 0");
        }
        if (f3 < 0.0f) {
            throw new IllegalArgumentException("Invalid max shadow size " + f3 + ". Must be >= 0");
        }
        float fT = t(f2);
        float fT2 = t(f3);
        if (fT > fT2) {
            if (!this.f1304p) {
                this.f1304p = true;
            }
            fT = fT2;
        }
        if (this.f1298j == fT && this.f1296h == fT2) {
            return;
        }
        this.f1298j = fT;
        this.f1296h = fT2;
        this.f1297i = (int) ((fT * 1.5f) + this.f1289a + 0.5f);
        this.f1300l = true;
        invalidateSelf();
    }

    private int t(float f2) {
        int i2 = (int) (f2 + 0.5f);
        return i2 % 2 == 1 ? i2 - 1 : i2;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f1300l) {
            a(getBounds());
            this.f1300l = false;
        }
        canvas.translate(0.0f, this.f1298j / 2.0f);
        e(canvas);
        canvas.translate(0.0f, (-this.f1298j) / 2.0f);
        f1288r.a(canvas, this.f1293e, this.f1294f, this.f1290b);
    }

    ColorStateList f() {
        return this.f1299k;
    }

    float g() {
        return this.f1294f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int iCeil = (int) Math.ceil(d(this.f1296h, this.f1294f, this.f1303o));
        int iCeil2 = (int) Math.ceil(c(this.f1296h, this.f1294f, this.f1303o));
        rect.set(iCeil2, iCeil, iCeil2, iCeil);
        return true;
    }

    void h(Rect rect) {
        getPadding(rect);
    }

    float i() {
        return this.f1296h;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.f1299k;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    float j() {
        float f2 = this.f1296h;
        return (Math.max(f2, this.f1294f + this.f1289a + ((f2 * 1.5f) / 2.0f)) * 2.0f) + (((this.f1296h * 1.5f) + this.f1289a) * 2.0f);
    }

    float k() {
        float f2 = this.f1296h;
        return (Math.max(f2, this.f1294f + this.f1289a + (f2 / 2.0f)) * 2.0f) + ((this.f1296h + this.f1289a) * 2.0f);
    }

    float l() {
        return this.f1298j;
    }

    void m(boolean z2) {
        this.f1303o = z2;
        invalidateSelf();
    }

    void o(@Nullable ColorStateList colorStateList) {
        n(colorStateList);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f1300l = true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        ColorStateList colorStateList = this.f1299k;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.f1290b.getColor() == colorForState) {
            return false;
        }
        this.f1290b.setColor(colorForState);
        this.f1300l = true;
        invalidateSelf();
        return true;
    }

    void p(float f2) {
        if (f2 < 0.0f) {
            throw new IllegalArgumentException("Invalid radius " + f2 + ". Must be >= 0");
        }
        float f3 = (int) (f2 + 0.5f);
        if (this.f1294f == f3) {
            return;
        }
        this.f1294f = f3;
        this.f1300l = true;
        invalidateSelf();
    }

    void q(float f2) {
        s(this.f1298j, f2);
    }

    void r(float f2) {
        s(f2, this.f1296h);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f1290b.setAlpha(i2);
        this.f1291c.setAlpha(i2);
        this.f1292d.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f1290b.setColorFilter(colorFilter);
    }
}
