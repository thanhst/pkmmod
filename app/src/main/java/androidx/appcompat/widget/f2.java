package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R$styleable;

/* compiled from: ThemeUtils.java */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class f2 {

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f940a = new ThreadLocal<>();

    /* renamed from: b, reason: collision with root package name */
    static final int[] f941b = {-16842910};

    /* renamed from: c, reason: collision with root package name */
    static final int[] f942c = {R.attr.state_focused};

    /* renamed from: d, reason: collision with root package name */
    static final int[] f943d = {R.attr.state_activated};

    /* renamed from: e, reason: collision with root package name */
    static final int[] f944e = {R.attr.state_pressed};

    /* renamed from: f, reason: collision with root package name */
    static final int[] f945f = {R.attr.state_checked};

    /* renamed from: g, reason: collision with root package name */
    static final int[] f946g = {R.attr.state_selected};

    /* renamed from: h, reason: collision with root package name */
    static final int[] f947h = {-16842919, -16842908};

    /* renamed from: i, reason: collision with root package name */
    static final int[] f948i = new int[0];

    /* renamed from: j, reason: collision with root package name */
    private static final int[] f949j = new int[1];

    public static void a(@NonNull View view, @NonNull Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(R$styleable.AppCompatTheme);
        try {
            if (!typedArrayObtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowActionBar)) {
                Log.e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static int b(@NonNull Context context, int i2) {
        ColorStateList colorStateListE = e(context, i2);
        if (colorStateListE != null && colorStateListE.isStateful()) {
            return colorStateListE.getColorForState(f941b, colorStateListE.getDefaultColor());
        }
        TypedValue typedValueF = f();
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, typedValueF, true);
        return d(context, i2, typedValueF.getFloat());
    }

    public static int c(@NonNull Context context, int i2) {
        int[] iArr = f949j;
        iArr[0] = i2;
        k2 k2VarT = k2.t(context, null, iArr);
        try {
            return k2VarT.b(0, 0);
        } finally {
            k2VarT.v();
        }
    }

    static int d(@NonNull Context context, int i2, float f2) {
        return androidx.core.graphics.a.f(c(context, i2), Math.round(Color.alpha(r0) * f2));
    }

    @Nullable
    public static ColorStateList e(@NonNull Context context, int i2) {
        int[] iArr = f949j;
        iArr[0] = i2;
        k2 k2VarT = k2.t(context, null, iArr);
        try {
            return k2VarT.c(0);
        } finally {
            k2VarT.v();
        }
    }

    private static TypedValue f() {
        ThreadLocal<TypedValue> threadLocal = f940a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }
}
