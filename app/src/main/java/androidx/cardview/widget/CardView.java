package androidx.cardview.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.cardview.R$attr;
import androidx.cardview.R$color;
import androidx.cardview.R$style;
import androidx.cardview.R$styleable;

/* loaded from: classes.dex */
public class CardView extends FrameLayout {

    /* renamed from: l, reason: collision with root package name */
    private static final int[] f1263l = {R.attr.colorBackground};

    /* renamed from: m, reason: collision with root package name */
    private static final e f1264m;

    /* renamed from: e, reason: collision with root package name */
    private boolean f1265e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f1266f;

    /* renamed from: g, reason: collision with root package name */
    int f1267g;

    /* renamed from: h, reason: collision with root package name */
    int f1268h;

    /* renamed from: i, reason: collision with root package name */
    final Rect f1269i;

    /* renamed from: j, reason: collision with root package name */
    final Rect f1270j;

    /* renamed from: k, reason: collision with root package name */
    private final d f1271k;

    class a implements d {

        /* renamed from: a, reason: collision with root package name */
        private Drawable f1272a;

        a() {
        }

        @Override // androidx.cardview.widget.d
        public View a() {
            return CardView.this;
        }

        @Override // androidx.cardview.widget.d
        public void b(int i2, int i3, int i4, int i5) {
            CardView.this.f1270j.set(i2, i3, i4, i5);
            CardView cardView = CardView.this;
            Rect rect = cardView.f1269i;
            CardView.super.setPadding(i2 + rect.left, i3 + rect.top, i4 + rect.right, i5 + rect.bottom);
        }

        @Override // androidx.cardview.widget.d
        public void c(int i2, int i3) {
            CardView cardView = CardView.this;
            if (i2 > cardView.f1267g) {
                CardView.super.setMinimumWidth(i2);
            }
            CardView cardView2 = CardView.this;
            if (i3 > cardView2.f1268h) {
                CardView.super.setMinimumHeight(i3);
            }
        }

        @Override // androidx.cardview.widget.d
        public void d(Drawable drawable) {
            this.f1272a = drawable;
            CardView.this.setBackgroundDrawable(drawable);
        }

        @Override // androidx.cardview.widget.d
        public boolean e() {
            return CardView.this.getPreventCornerOverlap();
        }

        @Override // androidx.cardview.widget.d
        public boolean f() {
            return CardView.this.getUseCompatPadding();
        }

        @Override // androidx.cardview.widget.d
        public Drawable g() {
            return this.f1272a;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            f1264m = new b();
        } else {
            f1264m = new androidx.cardview.widget.a();
        }
        f1264m.f();
    }

    public CardView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.cardViewStyle);
    }

    @NonNull
    public ColorStateList getCardBackgroundColor() {
        return f1264m.b(this.f1271k);
    }

    public float getCardElevation() {
        return f1264m.e(this.f1271k);
    }

    @Px
    public int getContentPaddingBottom() {
        return this.f1269i.bottom;
    }

    @Px
    public int getContentPaddingLeft() {
        return this.f1269i.left;
    }

    @Px
    public int getContentPaddingRight() {
        return this.f1269i.right;
    }

    @Px
    public int getContentPaddingTop() {
        return this.f1269i.top;
    }

    public float getMaxCardElevation() {
        return f1264m.a(this.f1271k);
    }

    public boolean getPreventCornerOverlap() {
        return this.f1266f;
    }

    public float getRadius() {
        return f1264m.g(this.f1271k);
    }

    public boolean getUseCompatPadding() {
        return this.f1265e;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        if (f1264m instanceof b) {
            super.onMeasure(i2, i3);
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r0.i(this.f1271k)), View.MeasureSpec.getSize(i2)), mode);
        }
        int mode2 = View.MeasureSpec.getMode(i3);
        if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
            i3 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r0.h(this.f1271k)), View.MeasureSpec.getSize(i3)), mode2);
        }
        super.onMeasure(i2, i3);
    }

    public void setCardBackgroundColor(@ColorInt int i2) {
        f1264m.m(this.f1271k, ColorStateList.valueOf(i2));
    }

    public void setCardElevation(float f2) {
        f1264m.k(this.f1271k, f2);
    }

    public void setMaxCardElevation(float f2) {
        f1264m.n(this.f1271k, f2);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i2) {
        this.f1268h = i2;
        super.setMinimumHeight(i2);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i2) {
        this.f1267g = i2;
        super.setMinimumWidth(i2);
    }

    @Override // android.view.View
    public void setPadding(int i2, int i3, int i4, int i5) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i2, int i3, int i4, int i5) {
    }

    public void setPreventCornerOverlap(boolean z2) {
        if (z2 != this.f1266f) {
            this.f1266f = z2;
            f1264m.l(this.f1271k);
        }
    }

    public void setRadius(float f2) {
        f1264m.d(this.f1271k, f2);
    }

    public void setUseCompatPadding(boolean z2) {
        if (this.f1265e != z2) {
            this.f1265e = z2;
            f1264m.j(this.f1271k);
        }
    }

    public CardView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        ColorStateList colorStateListValueOf;
        super(context, attributeSet, i2);
        Rect rect = new Rect();
        this.f1269i = rect;
        this.f1270j = new Rect();
        a aVar = new a();
        this.f1271k = aVar;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CardView, i2, R$style.CardView);
        int i3 = R$styleable.CardView_cardBackgroundColor;
        if (typedArrayObtainStyledAttributes.hasValue(i3)) {
            colorStateListValueOf = typedArrayObtainStyledAttributes.getColorStateList(i3);
        } else {
            TypedArray typedArrayObtainStyledAttributes2 = getContext().obtainStyledAttributes(f1263l);
            int color = typedArrayObtainStyledAttributes2.getColor(0, 0);
            typedArrayObtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            colorStateListValueOf = ColorStateList.valueOf(fArr[2] > 0.5f ? getResources().getColor(R$color.cardview_light_background) : getResources().getColor(R$color.cardview_dark_background));
        }
        ColorStateList colorStateList = colorStateListValueOf;
        float dimension = typedArrayObtainStyledAttributes.getDimension(R$styleable.CardView_cardCornerRadius, 0.0f);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(R$styleable.CardView_cardElevation, 0.0f);
        float dimension3 = typedArrayObtainStyledAttributes.getDimension(R$styleable.CardView_cardMaxElevation, 0.0f);
        this.f1265e = typedArrayObtainStyledAttributes.getBoolean(R$styleable.CardView_cardUseCompatPadding, false);
        this.f1266f = typedArrayObtainStyledAttributes.getBoolean(R$styleable.CardView_cardPreventCornerOverlap, true);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_contentPadding, 0);
        rect.left = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_contentPaddingLeft, dimensionPixelSize);
        rect.top = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_contentPaddingTop, dimensionPixelSize);
        rect.right = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_contentPaddingRight, dimensionPixelSize);
        rect.bottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_contentPaddingBottom, dimensionPixelSize);
        float f2 = dimension2 > dimension3 ? dimension2 : dimension3;
        this.f1267g = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_android_minWidth, 0);
        this.f1268h = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_android_minHeight, 0);
        typedArrayObtainStyledAttributes.recycle();
        f1264m.c(aVar, context, colorStateList, dimension, dimension2, f2);
    }

    public void setCardBackgroundColor(@Nullable ColorStateList colorStateList) {
        f1264m.m(this.f1271k, colorStateList);
    }
}
