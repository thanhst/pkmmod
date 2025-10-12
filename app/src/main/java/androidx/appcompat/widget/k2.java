package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleableRes;
import androidx.core.content.res.h;

/* compiled from: TintTypedArray.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class k2 {

    /* renamed from: a, reason: collision with root package name */
    private final Context f991a;

    /* renamed from: b, reason: collision with root package name */
    private final TypedArray f992b;

    /* renamed from: c, reason: collision with root package name */
    private TypedValue f993c;

    private k2(Context context, TypedArray typedArray) {
        this.f991a = context;
        this.f992b = typedArray;
    }

    public static k2 s(Context context, int i2, int[] iArr) {
        return new k2(context, context.obtainStyledAttributes(i2, iArr));
    }

    public static k2 t(Context context, AttributeSet attributeSet, int[] iArr) {
        return new k2(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static k2 u(Context context, AttributeSet attributeSet, int[] iArr, int i2, int i3) {
        return new k2(context, context.obtainStyledAttributes(attributeSet, iArr, i2, i3));
    }

    public boolean a(int i2, boolean z2) {
        return this.f992b.getBoolean(i2, z2);
    }

    public int b(int i2, int i3) {
        return this.f992b.getColor(i2, i3);
    }

    public ColorStateList c(int i2) {
        int resourceId;
        ColorStateList colorStateListA;
        return (!this.f992b.hasValue(i2) || (resourceId = this.f992b.getResourceId(i2, 0)) == 0 || (colorStateListA = e.a.a(this.f991a, resourceId)) == null) ? this.f992b.getColorStateList(i2) : colorStateListA;
    }

    public int d(int i2, int i3) {
        return this.f992b.getDimensionPixelOffset(i2, i3);
    }

    public int e(int i2, int i3) {
        return this.f992b.getDimensionPixelSize(i2, i3);
    }

    public Drawable f(int i2) {
        int resourceId;
        return (!this.f992b.hasValue(i2) || (resourceId = this.f992b.getResourceId(i2, 0)) == 0) ? this.f992b.getDrawable(i2) : e.a.b(this.f991a, resourceId);
    }

    public Drawable g(int i2) {
        int resourceId;
        if (!this.f992b.hasValue(i2) || (resourceId = this.f992b.getResourceId(i2, 0)) == 0) {
            return null;
        }
        return k.b().d(this.f991a, resourceId, true);
    }

    public float h(int i2, float f2) {
        return this.f992b.getFloat(i2, f2);
    }

    @Nullable
    public Typeface i(@StyleableRes int i2, int i3, @Nullable h.f fVar) {
        int resourceId = this.f992b.getResourceId(i2, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f993c == null) {
            this.f993c = new TypedValue();
        }
        return androidx.core.content.res.h.f(this.f991a, resourceId, this.f993c, i3, fVar);
    }

    public int j(int i2, int i3) {
        return this.f992b.getInt(i2, i3);
    }

    public int k(int i2, int i3) {
        return this.f992b.getInteger(i2, i3);
    }

    public int l(int i2, int i3) {
        return this.f992b.getLayoutDimension(i2, i3);
    }

    public int m(int i2, int i3) {
        return this.f992b.getResourceId(i2, i3);
    }

    public String n(int i2) {
        return this.f992b.getString(i2);
    }

    public CharSequence o(int i2) {
        return this.f992b.getText(i2);
    }

    public CharSequence[] p(int i2) {
        return this.f992b.getTextArray(i2);
    }

    public TypedArray q() {
        return this.f992b;
    }

    public boolean r(int i2) {
        return this.f992b.hasValue(i2);
    }

    public void v() {
        this.f992b.recycle();
    }
}
