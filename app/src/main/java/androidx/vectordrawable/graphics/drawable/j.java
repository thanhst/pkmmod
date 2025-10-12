package androidx.vectordrawable.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.res.p;
import androidx.core.graphics.e;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: VectorDrawableCompat.java */
/* loaded from: classes.dex */
public class j extends androidx.vectordrawable.graphics.drawable.i {

    /* renamed from: o, reason: collision with root package name */
    static final PorterDuff.Mode f2667o = PorterDuff.Mode.SRC_IN;

    /* renamed from: f, reason: collision with root package name */
    private h f2668f;

    /* renamed from: g, reason: collision with root package name */
    private PorterDuffColorFilter f2669g;

    /* renamed from: h, reason: collision with root package name */
    private ColorFilter f2670h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f2671i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f2672j;

    /* renamed from: k, reason: collision with root package name */
    private Drawable.ConstantState f2673k;

    /* renamed from: l, reason: collision with root package name */
    private final float[] f2674l;

    /* renamed from: m, reason: collision with root package name */
    private final Matrix f2675m;

    /* renamed from: n, reason: collision with root package name */
    private final Rect f2676n;

    /* compiled from: VectorDrawableCompat.java */
    private static class b extends f {
        b() {
        }

        private void f(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f2703b = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f2702a = androidx.core.graphics.e.d(string2);
            }
            this.f2704c = p.g(typedArray, xmlPullParser, "fillType", 2, 0);
        }

        @Override // androidx.vectordrawable.graphics.drawable.j.f
        public boolean c() {
            return true;
        }

        public void e(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (p.j(xmlPullParser, "pathData")) {
                TypedArray typedArrayK = p.k(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f2640d);
                f(typedArrayK, xmlPullParser);
                typedArrayK.recycle();
            }
        }

        b(b bVar) {
            super(bVar);
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    private static abstract class e {
        private e() {
        }

        public boolean a() {
            return false;
        }

        public boolean b(int[] iArr) {
            return false;
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    private static class h extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        int f2723a;

        /* renamed from: b, reason: collision with root package name */
        g f2724b;

        /* renamed from: c, reason: collision with root package name */
        ColorStateList f2725c;

        /* renamed from: d, reason: collision with root package name */
        PorterDuff.Mode f2726d;

        /* renamed from: e, reason: collision with root package name */
        boolean f2727e;

        /* renamed from: f, reason: collision with root package name */
        Bitmap f2728f;

        /* renamed from: g, reason: collision with root package name */
        ColorStateList f2729g;

        /* renamed from: h, reason: collision with root package name */
        PorterDuff.Mode f2730h;

        /* renamed from: i, reason: collision with root package name */
        int f2731i;

        /* renamed from: j, reason: collision with root package name */
        boolean f2732j;

        /* renamed from: k, reason: collision with root package name */
        boolean f2733k;

        /* renamed from: l, reason: collision with root package name */
        Paint f2734l;

        public h(h hVar) {
            this.f2725c = null;
            this.f2726d = j.f2667o;
            if (hVar != null) {
                this.f2723a = hVar.f2723a;
                g gVar = new g(hVar.f2724b);
                this.f2724b = gVar;
                if (hVar.f2724b.f2711e != null) {
                    gVar.f2711e = new Paint(hVar.f2724b.f2711e);
                }
                if (hVar.f2724b.f2710d != null) {
                    this.f2724b.f2710d = new Paint(hVar.f2724b.f2710d);
                }
                this.f2725c = hVar.f2725c;
                this.f2726d = hVar.f2726d;
                this.f2727e = hVar.f2727e;
            }
        }

        public boolean a(int i2, int i3) {
            return i2 == this.f2728f.getWidth() && i3 == this.f2728f.getHeight();
        }

        public boolean b() {
            return !this.f2733k && this.f2729g == this.f2725c && this.f2730h == this.f2726d && this.f2732j == this.f2727e && this.f2731i == this.f2724b.getRootAlpha();
        }

        public void c(int i2, int i3) {
            if (this.f2728f == null || !a(i2, i3)) {
                this.f2728f = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
                this.f2733k = true;
            }
        }

        public void d(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f2728f, (Rect) null, rect, e(colorFilter));
        }

        public Paint e(ColorFilter colorFilter) {
            if (!f() && colorFilter == null) {
                return null;
            }
            if (this.f2734l == null) {
                Paint paint = new Paint();
                this.f2734l = paint;
                paint.setFilterBitmap(true);
            }
            this.f2734l.setAlpha(this.f2724b.getRootAlpha());
            this.f2734l.setColorFilter(colorFilter);
            return this.f2734l;
        }

        public boolean f() {
            return this.f2724b.getRootAlpha() < 255;
        }

        public boolean g() {
            return this.f2724b.f();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f2723a;
        }

        public boolean h(int[] iArr) {
            boolean zG = this.f2724b.g(iArr);
            this.f2733k |= zG;
            return zG;
        }

        public void i() {
            this.f2729g = this.f2725c;
            this.f2730h = this.f2726d;
            this.f2731i = this.f2724b.getRootAlpha();
            this.f2732j = this.f2727e;
            this.f2733k = false;
        }

        public void j(int i2, int i3) {
            this.f2728f.eraseColor(0);
            this.f2724b.b(new Canvas(this.f2728f), i2, i3, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new j(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources resources) {
            return new j(this);
        }

        public h() {
            this.f2725c = null;
            this.f2726d = j.f2667o;
            this.f2724b = new g();
        }
    }

    j() {
        this.f2672j = true;
        this.f2674l = new float[9];
        this.f2675m = new Matrix();
        this.f2676n = new Rect();
        this.f2668f = new h();
    }

    static int a(int i2, float f2) {
        return (i2 & 16777215) | (((int) (Color.alpha(i2) * f2)) << 24);
    }

    @Nullable
    public static j b(@NonNull Resources resources, @DrawableRes int i2, @Nullable Resources.Theme theme) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            j jVar = new j();
            jVar.f2666e = androidx.core.content.res.h.d(resources, i2, theme);
            jVar.f2673k = new i(jVar.f2666e.getConstantState());
            return jVar;
        }
        try {
            XmlResourceParser xml = resources.getXml(i2);
            AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return c(resources, xml, attributeSetAsAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException e2) {
            Log.e("VectorDrawableCompat", "parser error", e2);
            return null;
        } catch (XmlPullParserException e3) {
            Log.e("VectorDrawableCompat", "parser error", e3);
            return null;
        }
    }

    public static j c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        j jVar = new j();
        jVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return jVar;
    }

    private void e(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        h hVar = this.f2668f;
        g gVar = hVar.f2724b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(gVar.f2714h);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z2 = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                d dVar = (d) arrayDeque.peek();
                if ("path".equals(name)) {
                    c cVar = new c();
                    cVar.g(resources, attributeSet, theme, xmlPullParser);
                    dVar.f2690b.add(cVar);
                    if (cVar.getPathName() != null) {
                        gVar.f2722p.put(cVar.getPathName(), cVar);
                    }
                    z2 = false;
                    hVar.f2723a = cVar.f2705d | hVar.f2723a;
                } else if ("clip-path".equals(name)) {
                    b bVar = new b();
                    bVar.e(resources, attributeSet, theme, xmlPullParser);
                    dVar.f2690b.add(bVar);
                    if (bVar.getPathName() != null) {
                        gVar.f2722p.put(bVar.getPathName(), bVar);
                    }
                    hVar.f2723a = bVar.f2705d | hVar.f2723a;
                } else if ("group".equals(name)) {
                    d dVar2 = new d();
                    dVar2.c(resources, attributeSet, theme, xmlPullParser);
                    dVar.f2690b.add(dVar2);
                    arrayDeque.push(dVar2);
                    if (dVar2.getGroupName() != null) {
                        gVar.f2722p.put(dVar2.getGroupName(), dVar2);
                    }
                    hVar.f2723a = dVar2.f2699k | hVar.f2723a;
                }
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z2) {
            throw new XmlPullParserException("no path defined");
        }
    }

    private boolean f() {
        return isAutoMirrored() && androidx.core.graphics.drawable.a.e(this) == 1;
    }

    private static PorterDuff.Mode g(int i2, PorterDuff.Mode mode) {
        if (i2 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i2 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i2 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i2) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    private void i(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException {
        h hVar = this.f2668f;
        g gVar = hVar.f2724b;
        hVar.f2726d = g(p.g(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList colorStateListC = p.c(typedArray, xmlPullParser, theme, "tint", 1);
        if (colorStateListC != null) {
            hVar.f2725c = colorStateListC;
        }
        hVar.f2727e = p.a(typedArray, xmlPullParser, "autoMirrored", 5, hVar.f2727e);
        gVar.f2717k = p.f(typedArray, xmlPullParser, "viewportWidth", 7, gVar.f2717k);
        float f2 = p.f(typedArray, xmlPullParser, "viewportHeight", 8, gVar.f2718l);
        gVar.f2718l = f2;
        if (gVar.f2717k <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (f2 <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
        gVar.f2715i = typedArray.getDimension(3, gVar.f2715i);
        float dimension = typedArray.getDimension(2, gVar.f2716j);
        gVar.f2716j = dimension;
        if (gVar.f2715i <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
        }
        if (dimension <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
        }
        gVar.setAlpha(p.f(typedArray, xmlPullParser, "alpha", 4, gVar.getAlpha()));
        String string = typedArray.getString(0);
        if (string != null) {
            gVar.f2720n = string;
            gVar.f2722p.put(string, gVar);
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f2666e;
        if (drawable == null) {
            return false;
        }
        androidx.core.graphics.drawable.a.b(drawable);
        return false;
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    Object d(String str) {
        return this.f2668f.f2724b.f2722p.get(str);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f2666e;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.f2676n);
        if (this.f2676n.width() <= 0 || this.f2676n.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.f2670h;
        if (colorFilter == null) {
            colorFilter = this.f2669g;
        }
        canvas.getMatrix(this.f2675m);
        this.f2675m.getValues(this.f2674l);
        float fAbs = Math.abs(this.f2674l[0]);
        float fAbs2 = Math.abs(this.f2674l[4]);
        float fAbs3 = Math.abs(this.f2674l[1]);
        float fAbs4 = Math.abs(this.f2674l[3]);
        if (fAbs3 != 0.0f || fAbs4 != 0.0f) {
            fAbs = 1.0f;
            fAbs2 = 1.0f;
        }
        int iMin = Math.min(2048, (int) (this.f2676n.width() * fAbs));
        int iMin2 = Math.min(2048, (int) (this.f2676n.height() * fAbs2));
        if (iMin <= 0 || iMin2 <= 0) {
            return;
        }
        int iSave = canvas.save();
        Rect rect = this.f2676n;
        canvas.translate(rect.left, rect.top);
        if (f()) {
            canvas.translate(this.f2676n.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        this.f2676n.offsetTo(0, 0);
        this.f2668f.c(iMin, iMin2);
        if (!this.f2672j) {
            this.f2668f.j(iMin, iMin2);
        } else if (!this.f2668f.b()) {
            this.f2668f.j(iMin, iMin2);
            this.f2668f.i();
        }
        this.f2668f.d(canvas, colorFilter, this.f2676n);
        canvas.restoreToCount(iSave);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f2666e;
        return drawable != null ? androidx.core.graphics.drawable.a.c(drawable) : this.f2668f.f2724b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f2666e;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f2668f.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f2666e;
        return drawable != null ? androidx.core.graphics.drawable.a.d(drawable) : this.f2670h;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f2666e != null && Build.VERSION.SDK_INT >= 24) {
            return new i(this.f2666e.getConstantState());
        }
        this.f2668f.f2723a = getChangingConfigurations();
        return this.f2668f;
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f2666e;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.f2668f.f2724b.f2716j;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f2666e;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.f2668f.f2724b.f2715i;
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f2666e;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    void h(boolean z2) {
        this.f2672j = z2;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.f2666e;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable drawable = this.f2666e;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f2666e;
        return drawable != null ? androidx.core.graphics.drawable.a.g(drawable) : this.f2668f.f2727e;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        h hVar;
        ColorStateList colorStateList;
        Drawable drawable = this.f2666e;
        return drawable != null ? drawable.isStateful() : super.isStateful() || ((hVar = this.f2668f) != null && (hVar.g() || ((colorStateList = this.f2668f.f2725c) != null && colorStateList.isStateful())));
    }

    PorterDuffColorFilter j(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f2666e;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f2671i && super.mutate() == this) {
            this.f2668f = new h(this.f2668f);
            this.f2671i = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f2666e;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        Drawable drawable = this.f2666e;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        boolean z2 = false;
        h hVar = this.f2668f;
        ColorStateList colorStateList = hVar.f2725c;
        if (colorStateList != null && (mode = hVar.f2726d) != null) {
            this.f2669g = j(this.f2669g, colorStateList, mode);
            invalidateSelf();
            z2 = true;
        }
        if (!hVar.g() || !hVar.h(iArr)) {
            return z2;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j2) {
        Drawable drawable = this.f2666e;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j2);
        } else {
            super.scheduleSelf(runnable, j2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        Drawable drawable = this.f2666e;
        if (drawable != null) {
            drawable.setAlpha(i2);
        } else if (this.f2668f.f2724b.getRootAlpha() != i2) {
            this.f2668f.f2724b.setRootAlpha(i2);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z2) {
        Drawable drawable = this.f2666e;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.i(drawable, z2);
        } else {
            this.f2668f.f2727e = z2;
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i2) {
        super.setChangingConfigurations(i2);
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i2, PorterDuff.Mode mode) {
        super.setColorFilter(i2, mode);
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z2) {
        super.setFilterBitmap(z2);
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i2, int i3, int i4, int i5) {
        super.setHotspotBounds(i2, i3, i4, i5);
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.r
    public void setTint(int i2) {
        Drawable drawable = this.f2666e;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.m(drawable, i2);
        } else {
            setTintList(ColorStateList.valueOf(i2));
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.r
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f2666e;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.n(drawable, colorStateList);
            return;
        }
        h hVar = this.f2668f;
        if (hVar.f2725c != colorStateList) {
            hVar.f2725c = colorStateList;
            this.f2669g = j(this.f2669g, colorStateList, hVar.f2726d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.r
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f2666e;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.o(drawable, mode);
            return;
        }
        h hVar = this.f2668f;
        if (hVar.f2726d != mode) {
            hVar.f2726d = mode;
            this.f2669g = j(this.f2669g, hVar.f2725c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z2, boolean z3) {
        Drawable drawable = this.f2666e;
        return drawable != null ? drawable.setVisible(z2, z3) : super.setVisible(z2, z3);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f2666e;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    @RequiresApi(24)
    private static class i extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        private final Drawable.ConstantState f2735a;

        public i(Drawable.ConstantState constantState) {
            this.f2735a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f2735a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f2735a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            j jVar = new j();
            jVar.f2666e = (VectorDrawable) this.f2735a.newDrawable();
            return jVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            j jVar = new j();
            jVar.f2666e = (VectorDrawable) this.f2735a.newDrawable(resources);
            return jVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            j jVar = new j();
            jVar.f2666e = (VectorDrawable) this.f2735a.newDrawable(resources, theme);
            return jVar;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f2666e;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f2670h = colorFilter;
            invalidateSelf();
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    private static abstract class f extends e {

        /* renamed from: a, reason: collision with root package name */
        protected e.b[] f2702a;

        /* renamed from: b, reason: collision with root package name */
        String f2703b;

        /* renamed from: c, reason: collision with root package name */
        int f2704c;

        /* renamed from: d, reason: collision with root package name */
        int f2705d;

        public f() {
            super();
            this.f2702a = null;
            this.f2704c = 0;
        }

        public boolean c() {
            return false;
        }

        public void d(Path path) {
            path.reset();
            e.b[] bVarArr = this.f2702a;
            if (bVarArr != null) {
                e.b.e(bVarArr, path);
            }
        }

        public e.b[] getPathData() {
            return this.f2702a;
        }

        public String getPathName() {
            return this.f2703b;
        }

        public void setPathData(e.b[] bVarArr) {
            if (androidx.core.graphics.e.b(this.f2702a, bVarArr)) {
                androidx.core.graphics.e.j(this.f2702a, bVarArr);
            } else {
                this.f2702a = androidx.core.graphics.e.f(bVarArr);
            }
        }

        public f(f fVar) {
            super();
            this.f2702a = null;
            this.f2704c = 0;
            this.f2703b = fVar.f2703b;
            this.f2705d = fVar.f2705d;
            this.f2702a = androidx.core.graphics.e.f(fVar.f2702a);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f2666e;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.f(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        h hVar = this.f2668f;
        hVar.f2724b = new g();
        TypedArray typedArrayK = p.k(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f2637a);
        i(typedArrayK, xmlPullParser, theme);
        typedArrayK.recycle();
        hVar.f2723a = getChangingConfigurations();
        hVar.f2733k = true;
        e(resources, xmlPullParser, attributeSet, theme);
        this.f2669g = j(this.f2669g, hVar.f2725c, hVar.f2726d);
    }

    j(@NonNull h hVar) {
        this.f2672j = true;
        this.f2674l = new float[9];
        this.f2675m = new Matrix();
        this.f2676n = new Rect();
        this.f2668f = hVar;
        this.f2669g = j(this.f2669g, hVar.f2725c, hVar.f2726d);
    }

    /* compiled from: VectorDrawableCompat.java */
    private static class c extends f {

        /* renamed from: e, reason: collision with root package name */
        private int[] f2677e;

        /* renamed from: f, reason: collision with root package name */
        androidx.core.content.res.d f2678f;

        /* renamed from: g, reason: collision with root package name */
        float f2679g;

        /* renamed from: h, reason: collision with root package name */
        androidx.core.content.res.d f2680h;

        /* renamed from: i, reason: collision with root package name */
        float f2681i;

        /* renamed from: j, reason: collision with root package name */
        float f2682j;

        /* renamed from: k, reason: collision with root package name */
        float f2683k;

        /* renamed from: l, reason: collision with root package name */
        float f2684l;

        /* renamed from: m, reason: collision with root package name */
        float f2685m;

        /* renamed from: n, reason: collision with root package name */
        Paint.Cap f2686n;

        /* renamed from: o, reason: collision with root package name */
        Paint.Join f2687o;

        /* renamed from: p, reason: collision with root package name */
        float f2688p;

        c() {
            this.f2679g = 0.0f;
            this.f2681i = 1.0f;
            this.f2682j = 1.0f;
            this.f2683k = 0.0f;
            this.f2684l = 1.0f;
            this.f2685m = 0.0f;
            this.f2686n = Paint.Cap.BUTT;
            this.f2687o = Paint.Join.MITER;
            this.f2688p = 4.0f;
        }

        private Paint.Cap e(int i2, Paint.Cap cap) {
            return i2 != 0 ? i2 != 1 ? i2 != 2 ? cap : Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
        }

        private Paint.Join f(int i2, Paint.Join join) {
            return i2 != 0 ? i2 != 1 ? i2 != 2 ? join : Paint.Join.BEVEL : Paint.Join.ROUND : Paint.Join.MITER;
        }

        private void h(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.f2677e = null;
            if (p.j(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f2703b = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.f2702a = androidx.core.graphics.e.d(string2);
                }
                this.f2680h = p.e(typedArray, xmlPullParser, theme, "fillColor", 1, 0);
                this.f2682j = p.f(typedArray, xmlPullParser, "fillAlpha", 12, this.f2682j);
                this.f2686n = e(p.g(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f2686n);
                this.f2687o = f(p.g(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.f2687o);
                this.f2688p = p.f(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.f2688p);
                this.f2678f = p.e(typedArray, xmlPullParser, theme, "strokeColor", 3, 0);
                this.f2681i = p.f(typedArray, xmlPullParser, "strokeAlpha", 11, this.f2681i);
                this.f2679g = p.f(typedArray, xmlPullParser, "strokeWidth", 4, this.f2679g);
                this.f2684l = p.f(typedArray, xmlPullParser, "trimPathEnd", 6, this.f2684l);
                this.f2685m = p.f(typedArray, xmlPullParser, "trimPathOffset", 7, this.f2685m);
                this.f2683k = p.f(typedArray, xmlPullParser, "trimPathStart", 5, this.f2683k);
                this.f2704c = p.g(typedArray, xmlPullParser, "fillType", 13, this.f2704c);
            }
        }

        @Override // androidx.vectordrawable.graphics.drawable.j.e
        public boolean a() {
            return this.f2680h.i() || this.f2678f.i();
        }

        @Override // androidx.vectordrawable.graphics.drawable.j.e
        public boolean b(int[] iArr) {
            return this.f2678f.j(iArr) | this.f2680h.j(iArr);
        }

        public void g(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray typedArrayK = p.k(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f2639c);
            h(typedArrayK, xmlPullParser, theme);
            typedArrayK.recycle();
        }

        float getFillAlpha() {
            return this.f2682j;
        }

        @ColorInt
        int getFillColor() {
            return this.f2680h.e();
        }

        float getStrokeAlpha() {
            return this.f2681i;
        }

        @ColorInt
        int getStrokeColor() {
            return this.f2678f.e();
        }

        float getStrokeWidth() {
            return this.f2679g;
        }

        float getTrimPathEnd() {
            return this.f2684l;
        }

        float getTrimPathOffset() {
            return this.f2685m;
        }

        float getTrimPathStart() {
            return this.f2683k;
        }

        void setFillAlpha(float f2) {
            this.f2682j = f2;
        }

        void setFillColor(int i2) {
            this.f2680h.k(i2);
        }

        void setStrokeAlpha(float f2) {
            this.f2681i = f2;
        }

        void setStrokeColor(int i2) {
            this.f2678f.k(i2);
        }

        void setStrokeWidth(float f2) {
            this.f2679g = f2;
        }

        void setTrimPathEnd(float f2) {
            this.f2684l = f2;
        }

        void setTrimPathOffset(float f2) {
            this.f2685m = f2;
        }

        void setTrimPathStart(float f2) {
            this.f2683k = f2;
        }

        c(c cVar) {
            super(cVar);
            this.f2679g = 0.0f;
            this.f2681i = 1.0f;
            this.f2682j = 1.0f;
            this.f2683k = 0.0f;
            this.f2684l = 1.0f;
            this.f2685m = 0.0f;
            this.f2686n = Paint.Cap.BUTT;
            this.f2687o = Paint.Join.MITER;
            this.f2688p = 4.0f;
            this.f2677e = cVar.f2677e;
            this.f2678f = cVar.f2678f;
            this.f2679g = cVar.f2679g;
            this.f2681i = cVar.f2681i;
            this.f2680h = cVar.f2680h;
            this.f2704c = cVar.f2704c;
            this.f2682j = cVar.f2682j;
            this.f2683k = cVar.f2683k;
            this.f2684l = cVar.f2684l;
            this.f2685m = cVar.f2685m;
            this.f2686n = cVar.f2686n;
            this.f2687o = cVar.f2687o;
            this.f2688p = cVar.f2688p;
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    private static class g {

        /* renamed from: q, reason: collision with root package name */
        private static final Matrix f2706q = new Matrix();

        /* renamed from: a, reason: collision with root package name */
        private final Path f2707a;

        /* renamed from: b, reason: collision with root package name */
        private final Path f2708b;

        /* renamed from: c, reason: collision with root package name */
        private final Matrix f2709c;

        /* renamed from: d, reason: collision with root package name */
        Paint f2710d;

        /* renamed from: e, reason: collision with root package name */
        Paint f2711e;

        /* renamed from: f, reason: collision with root package name */
        private PathMeasure f2712f;

        /* renamed from: g, reason: collision with root package name */
        private int f2713g;

        /* renamed from: h, reason: collision with root package name */
        final d f2714h;

        /* renamed from: i, reason: collision with root package name */
        float f2715i;

        /* renamed from: j, reason: collision with root package name */
        float f2716j;

        /* renamed from: k, reason: collision with root package name */
        float f2717k;

        /* renamed from: l, reason: collision with root package name */
        float f2718l;

        /* renamed from: m, reason: collision with root package name */
        int f2719m;

        /* renamed from: n, reason: collision with root package name */
        String f2720n;

        /* renamed from: o, reason: collision with root package name */
        Boolean f2721o;

        /* renamed from: p, reason: collision with root package name */
        final androidx.collection.a<String, Object> f2722p;

        public g() {
            this.f2709c = new Matrix();
            this.f2715i = 0.0f;
            this.f2716j = 0.0f;
            this.f2717k = 0.0f;
            this.f2718l = 0.0f;
            this.f2719m = 255;
            this.f2720n = null;
            this.f2721o = null;
            this.f2722p = new androidx.collection.a<>();
            this.f2714h = new d();
            this.f2707a = new Path();
            this.f2708b = new Path();
        }

        private static float a(float f2, float f3, float f4, float f5) {
            return (f2 * f5) - (f3 * f4);
        }

        private void c(d dVar, Matrix matrix, Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            dVar.f2689a.set(matrix);
            dVar.f2689a.preConcat(dVar.f2698j);
            canvas.save();
            for (int i4 = 0; i4 < dVar.f2690b.size(); i4++) {
                e eVar = dVar.f2690b.get(i4);
                if (eVar instanceof d) {
                    c((d) eVar, dVar.f2689a, canvas, i2, i3, colorFilter);
                } else if (eVar instanceof f) {
                    d(dVar, (f) eVar, canvas, i2, i3, colorFilter);
                }
            }
            canvas.restore();
        }

        private void d(d dVar, f fVar, Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            float f2 = i2 / this.f2717k;
            float f3 = i3 / this.f2718l;
            float fMin = Math.min(f2, f3);
            Matrix matrix = dVar.f2689a;
            this.f2709c.set(matrix);
            this.f2709c.postScale(f2, f3);
            float fE = e(matrix);
            if (fE == 0.0f) {
                return;
            }
            fVar.d(this.f2707a);
            Path path = this.f2707a;
            this.f2708b.reset();
            if (fVar.c()) {
                this.f2708b.setFillType(fVar.f2704c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                this.f2708b.addPath(path, this.f2709c);
                canvas.clipPath(this.f2708b);
                return;
            }
            c cVar = (c) fVar;
            float f4 = cVar.f2683k;
            if (f4 != 0.0f || cVar.f2684l != 1.0f) {
                float f5 = cVar.f2685m;
                float f6 = (f4 + f5) % 1.0f;
                float f7 = (cVar.f2684l + f5) % 1.0f;
                if (this.f2712f == null) {
                    this.f2712f = new PathMeasure();
                }
                this.f2712f.setPath(this.f2707a, false);
                float length = this.f2712f.getLength();
                float f8 = f6 * length;
                float f9 = f7 * length;
                path.reset();
                if (f8 > f9) {
                    this.f2712f.getSegment(f8, length, path, true);
                    this.f2712f.getSegment(0.0f, f9, path, true);
                } else {
                    this.f2712f.getSegment(f8, f9, path, true);
                }
                path.rLineTo(0.0f, 0.0f);
            }
            this.f2708b.addPath(path, this.f2709c);
            if (cVar.f2680h.l()) {
                androidx.core.content.res.d dVar2 = cVar.f2680h;
                if (this.f2711e == null) {
                    Paint paint = new Paint(1);
                    this.f2711e = paint;
                    paint.setStyle(Paint.Style.FILL);
                }
                Paint paint2 = this.f2711e;
                if (dVar2.h()) {
                    Shader shaderF = dVar2.f();
                    shaderF.setLocalMatrix(this.f2709c);
                    paint2.setShader(shaderF);
                    paint2.setAlpha(Math.round(cVar.f2682j * 255.0f));
                } else {
                    paint2.setShader(null);
                    paint2.setAlpha(255);
                    paint2.setColor(j.a(dVar2.e(), cVar.f2682j));
                }
                paint2.setColorFilter(colorFilter);
                this.f2708b.setFillType(cVar.f2704c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                canvas.drawPath(this.f2708b, paint2);
            }
            if (cVar.f2678f.l()) {
                androidx.core.content.res.d dVar3 = cVar.f2678f;
                if (this.f2710d == null) {
                    Paint paint3 = new Paint(1);
                    this.f2710d = paint3;
                    paint3.setStyle(Paint.Style.STROKE);
                }
                Paint paint4 = this.f2710d;
                Paint.Join join = cVar.f2687o;
                if (join != null) {
                    paint4.setStrokeJoin(join);
                }
                Paint.Cap cap = cVar.f2686n;
                if (cap != null) {
                    paint4.setStrokeCap(cap);
                }
                paint4.setStrokeMiter(cVar.f2688p);
                if (dVar3.h()) {
                    Shader shaderF2 = dVar3.f();
                    shaderF2.setLocalMatrix(this.f2709c);
                    paint4.setShader(shaderF2);
                    paint4.setAlpha(Math.round(cVar.f2681i * 255.0f));
                } else {
                    paint4.setShader(null);
                    paint4.setAlpha(255);
                    paint4.setColor(j.a(dVar3.e(), cVar.f2681i));
                }
                paint4.setColorFilter(colorFilter);
                paint4.setStrokeWidth(cVar.f2679g * fMin * fE);
                canvas.drawPath(this.f2708b, paint4);
            }
        }

        private float e(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float fHypot = (float) Math.hypot(fArr[0], fArr[1]);
            float fHypot2 = (float) Math.hypot(fArr[2], fArr[3]);
            float fA = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float fMax = Math.max(fHypot, fHypot2);
            if (fMax > 0.0f) {
                return Math.abs(fA) / fMax;
            }
            return 0.0f;
        }

        public void b(Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            c(this.f2714h, f2706q, canvas, i2, i3, colorFilter);
        }

        public boolean f() {
            if (this.f2721o == null) {
                this.f2721o = Boolean.valueOf(this.f2714h.a());
            }
            return this.f2721o.booleanValue();
        }

        public boolean g(int[] iArr) {
            return this.f2714h.b(iArr);
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.f2719m;
        }

        public void setAlpha(float f2) {
            setRootAlpha((int) (f2 * 255.0f));
        }

        public void setRootAlpha(int i2) {
            this.f2719m = i2;
        }

        public g(g gVar) {
            this.f2709c = new Matrix();
            this.f2715i = 0.0f;
            this.f2716j = 0.0f;
            this.f2717k = 0.0f;
            this.f2718l = 0.0f;
            this.f2719m = 255;
            this.f2720n = null;
            this.f2721o = null;
            androidx.collection.a<String, Object> aVar = new androidx.collection.a<>();
            this.f2722p = aVar;
            this.f2714h = new d(gVar.f2714h, aVar);
            this.f2707a = new Path(gVar.f2707a);
            this.f2708b = new Path(gVar.f2708b);
            this.f2715i = gVar.f2715i;
            this.f2716j = gVar.f2716j;
            this.f2717k = gVar.f2717k;
            this.f2718l = gVar.f2718l;
            this.f2713g = gVar.f2713g;
            this.f2719m = gVar.f2719m;
            this.f2720n = gVar.f2720n;
            String str = gVar.f2720n;
            if (str != null) {
                aVar.put(str, this);
            }
            this.f2721o = gVar.f2721o;
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    private static class d extends e {

        /* renamed from: a, reason: collision with root package name */
        final Matrix f2689a;

        /* renamed from: b, reason: collision with root package name */
        final ArrayList<e> f2690b;

        /* renamed from: c, reason: collision with root package name */
        float f2691c;

        /* renamed from: d, reason: collision with root package name */
        private float f2692d;

        /* renamed from: e, reason: collision with root package name */
        private float f2693e;

        /* renamed from: f, reason: collision with root package name */
        private float f2694f;

        /* renamed from: g, reason: collision with root package name */
        private float f2695g;

        /* renamed from: h, reason: collision with root package name */
        private float f2696h;

        /* renamed from: i, reason: collision with root package name */
        private float f2697i;

        /* renamed from: j, reason: collision with root package name */
        final Matrix f2698j;

        /* renamed from: k, reason: collision with root package name */
        int f2699k;

        /* renamed from: l, reason: collision with root package name */
        private int[] f2700l;

        /* renamed from: m, reason: collision with root package name */
        private String f2701m;

        public d(d dVar, androidx.collection.a<String, Object> aVar) {
            f bVar;
            super();
            this.f2689a = new Matrix();
            this.f2690b = new ArrayList<>();
            this.f2691c = 0.0f;
            this.f2692d = 0.0f;
            this.f2693e = 0.0f;
            this.f2694f = 1.0f;
            this.f2695g = 1.0f;
            this.f2696h = 0.0f;
            this.f2697i = 0.0f;
            Matrix matrix = new Matrix();
            this.f2698j = matrix;
            this.f2701m = null;
            this.f2691c = dVar.f2691c;
            this.f2692d = dVar.f2692d;
            this.f2693e = dVar.f2693e;
            this.f2694f = dVar.f2694f;
            this.f2695g = dVar.f2695g;
            this.f2696h = dVar.f2696h;
            this.f2697i = dVar.f2697i;
            this.f2700l = dVar.f2700l;
            String str = dVar.f2701m;
            this.f2701m = str;
            this.f2699k = dVar.f2699k;
            if (str != null) {
                aVar.put(str, this);
            }
            matrix.set(dVar.f2698j);
            ArrayList<e> arrayList = dVar.f2690b;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                e eVar = arrayList.get(i2);
                if (eVar instanceof d) {
                    this.f2690b.add(new d((d) eVar, aVar));
                } else {
                    if (eVar instanceof c) {
                        bVar = new c((c) eVar);
                    } else {
                        if (!(eVar instanceof b)) {
                            throw new IllegalStateException("Unknown object in the tree!");
                        }
                        bVar = new b((b) eVar);
                    }
                    this.f2690b.add(bVar);
                    String str2 = bVar.f2703b;
                    if (str2 != null) {
                        aVar.put(str2, bVar);
                    }
                }
            }
        }

        private void d() {
            this.f2698j.reset();
            this.f2698j.postTranslate(-this.f2692d, -this.f2693e);
            this.f2698j.postScale(this.f2694f, this.f2695g);
            this.f2698j.postRotate(this.f2691c, 0.0f, 0.0f);
            this.f2698j.postTranslate(this.f2696h + this.f2692d, this.f2697i + this.f2693e);
        }

        private void e(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f2700l = null;
            this.f2691c = p.f(typedArray, xmlPullParser, "rotation", 5, this.f2691c);
            this.f2692d = typedArray.getFloat(1, this.f2692d);
            this.f2693e = typedArray.getFloat(2, this.f2693e);
            this.f2694f = p.f(typedArray, xmlPullParser, "scaleX", 3, this.f2694f);
            this.f2695g = p.f(typedArray, xmlPullParser, "scaleY", 4, this.f2695g);
            this.f2696h = p.f(typedArray, xmlPullParser, "translateX", 6, this.f2696h);
            this.f2697i = p.f(typedArray, xmlPullParser, "translateY", 7, this.f2697i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.f2701m = string;
            }
            d();
        }

        @Override // androidx.vectordrawable.graphics.drawable.j.e
        public boolean a() {
            for (int i2 = 0; i2 < this.f2690b.size(); i2++) {
                if (this.f2690b.get(i2).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.vectordrawable.graphics.drawable.j.e
        public boolean b(int[] iArr) {
            boolean zB = false;
            for (int i2 = 0; i2 < this.f2690b.size(); i2++) {
                zB |= this.f2690b.get(i2).b(iArr);
            }
            return zB;
        }

        public void c(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray typedArrayK = p.k(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f2638b);
            e(typedArrayK, xmlPullParser);
            typedArrayK.recycle();
        }

        public String getGroupName() {
            return this.f2701m;
        }

        public Matrix getLocalMatrix() {
            return this.f2698j;
        }

        public float getPivotX() {
            return this.f2692d;
        }

        public float getPivotY() {
            return this.f2693e;
        }

        public float getRotation() {
            return this.f2691c;
        }

        public float getScaleX() {
            return this.f2694f;
        }

        public float getScaleY() {
            return this.f2695g;
        }

        public float getTranslateX() {
            return this.f2696h;
        }

        public float getTranslateY() {
            return this.f2697i;
        }

        public void setPivotX(float f2) {
            if (f2 != this.f2692d) {
                this.f2692d = f2;
                d();
            }
        }

        public void setPivotY(float f2) {
            if (f2 != this.f2693e) {
                this.f2693e = f2;
                d();
            }
        }

        public void setRotation(float f2) {
            if (f2 != this.f2691c) {
                this.f2691c = f2;
                d();
            }
        }

        public void setScaleX(float f2) {
            if (f2 != this.f2694f) {
                this.f2694f = f2;
                d();
            }
        }

        public void setScaleY(float f2) {
            if (f2 != this.f2695g) {
                this.f2695g = f2;
                d();
            }
        }

        public void setTranslateX(float f2) {
            if (f2 != this.f2696h) {
                this.f2696h = f2;
                d();
            }
        }

        public void setTranslateY(float f2) {
            if (f2 != this.f2697i) {
                this.f2697i = f2;
                d();
            }
        }

        public d() {
            super();
            this.f2689a = new Matrix();
            this.f2690b = new ArrayList<>();
            this.f2691c = 0.0f;
            this.f2692d = 0.0f;
            this.f2693e = 0.0f;
            this.f2694f = 1.0f;
            this.f2695g = 1.0f;
            this.f2696h = 0.0f;
            this.f2697i = 0.0f;
            this.f2698j = new Matrix();
            this.f2701m = null;
        }
    }
}
