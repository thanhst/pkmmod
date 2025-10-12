package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.StaticLayout$Builder;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: AppCompatTextViewAutoSizeHelper.java */
/* loaded from: classes.dex */
class d1 {

    /* renamed from: l, reason: collision with root package name */
    private static final RectF f902l = new RectF();

    /* renamed from: m, reason: collision with root package name */
    @SuppressLint({"BanConcurrentHashMap"})
    private static ConcurrentHashMap<String, Method> f903m = new ConcurrentHashMap<>();

    /* renamed from: n, reason: collision with root package name */
    @SuppressLint({"BanConcurrentHashMap"})
    private static ConcurrentHashMap<String, Field> f904n = new ConcurrentHashMap<>();

    /* renamed from: a, reason: collision with root package name */
    private int f905a = 0;

    /* renamed from: b, reason: collision with root package name */
    private boolean f906b = false;

    /* renamed from: c, reason: collision with root package name */
    private float f907c = -1.0f;

    /* renamed from: d, reason: collision with root package name */
    private float f908d = -1.0f;

    /* renamed from: e, reason: collision with root package name */
    private float f909e = -1.0f;

    /* renamed from: f, reason: collision with root package name */
    private int[] f910f = new int[0];

    /* renamed from: g, reason: collision with root package name */
    private boolean f911g = false;

    /* renamed from: h, reason: collision with root package name */
    private TextPaint f912h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    private final TextView f913i;

    /* renamed from: j, reason: collision with root package name */
    private final Context f914j;

    /* renamed from: k, reason: collision with root package name */
    private final f f915k;

    /* compiled from: AppCompatTextViewAutoSizeHelper.java */
    @RequiresApi(16)
    private static final class a {
        @NonNull
        @DoNotInline
        static StaticLayout a(@NonNull CharSequence charSequence, @NonNull Layout.Alignment alignment, int i2, @NonNull TextView textView, @NonNull TextPaint textPaint) {
            return new StaticLayout(charSequence, textPaint, i2, alignment, textView.getLineSpacingMultiplier(), textView.getLineSpacingExtra(), textView.getIncludeFontPadding());
        }

        @DoNotInline
        static int b(@NonNull TextView textView) {
            return textView.getMaxLines();
        }
    }

    /* compiled from: AppCompatTextViewAutoSizeHelper.java */
    @RequiresApi(18)
    private static final class b {
        @DoNotInline
        static boolean a(@NonNull View view) {
            return view.isInLayout();
        }
    }

    /* compiled from: AppCompatTextViewAutoSizeHelper.java */
    @RequiresApi(23)
    private static final class c {
        @NonNull
        @DoNotInline
        static StaticLayout a(@NonNull CharSequence charSequence, @NonNull Layout.Alignment alignment, int i2, int i3, @NonNull TextView textView, @NonNull TextPaint textPaint, @NonNull f fVar) {
            StaticLayout$Builder staticLayout$BuilderObtain = StaticLayout$Builder.obtain(charSequence, 0, charSequence.length(), textPaint, i2);
            StaticLayout$Builder hyphenationFrequency = staticLayout$BuilderObtain.setAlignment(alignment).setLineSpacing(textView.getLineSpacingExtra(), textView.getLineSpacingMultiplier()).setIncludePad(textView.getIncludeFontPadding()).setBreakStrategy(textView.getBreakStrategy()).setHyphenationFrequency(textView.getHyphenationFrequency());
            if (i3 == -1) {
                i3 = Integer.MAX_VALUE;
            }
            hyphenationFrequency.setMaxLines(i3);
            try {
                fVar.a(staticLayout$BuilderObtain, textView);
            } catch (ClassCastException unused) {
                Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
            }
            return staticLayout$BuilderObtain.build();
        }
    }

    /* compiled from: AppCompatTextViewAutoSizeHelper.java */
    @RequiresApi(23)
    private static class d extends f {
        d() {
        }

        @Override // androidx.appcompat.widget.d1.f
        void a(StaticLayout$Builder staticLayout$Builder, TextView textView) {
            staticLayout$Builder.setTextDirection((TextDirectionHeuristic) d1.m(textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    /* compiled from: AppCompatTextViewAutoSizeHelper.java */
    @RequiresApi(29)
    private static class e extends d {
        e() {
        }

        @Override // androidx.appcompat.widget.d1.d, androidx.appcompat.widget.d1.f
        void a(StaticLayout$Builder staticLayout$Builder, TextView textView) {
            staticLayout$Builder.setTextDirection(textView.getTextDirectionHeuristic());
        }

        @Override // androidx.appcompat.widget.d1.f
        boolean b(TextView textView) {
            return textView.isHorizontallyScrollable();
        }
    }

    /* compiled from: AppCompatTextViewAutoSizeHelper.java */
    private static class f {
        f() {
        }

        void a(StaticLayout$Builder staticLayout$Builder, TextView textView) {
        }

        boolean b(TextView textView) {
            return ((Boolean) d1.m(textView, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue();
        }
    }

    d1(@NonNull TextView textView) {
        this.f913i = textView;
        this.f914j = textView.getContext();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            this.f915k = new e();
        } else if (i2 >= 23) {
            this.f915k = new d();
        } else {
            this.f915k = new f();
        }
    }

    private int[] b(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i2 : iArr) {
            if (i2 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i2)) < 0) {
                arrayList.add(Integer.valueOf(i2));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i3 = 0; i3 < size; i3++) {
            iArr2[i3] = ((Integer) arrayList.get(i3)).intValue();
        }
        return iArr2;
    }

    private void c() {
        this.f905a = 0;
        this.f908d = -1.0f;
        this.f909e = -1.0f;
        this.f907c = -1.0f;
        this.f910f = new int[0];
        this.f906b = false;
    }

    private int e(RectF rectF) {
        int length = this.f910f.length;
        if (length == 0) {
            throw new IllegalStateException("No available text sizes to choose from.");
        }
        int i2 = length - 1;
        int i3 = 1;
        int i4 = 0;
        while (i3 <= i2) {
            int i5 = (i3 + i2) / 2;
            if (x(this.f910f[i5], rectF)) {
                int i6 = i5 + 1;
                i4 = i3;
                i3 = i6;
            } else {
                i4 = i5 - 1;
                i2 = i4;
            }
        }
        return this.f910f[i4];
    }

    @Nullable
    private static Method k(@NonNull String str) throws SecurityException {
        try {
            Method declaredMethod = f903m.get(str);
            if (declaredMethod == null && (declaredMethod = TextView.class.getDeclaredMethod(str, new Class[0])) != null) {
                declaredMethod.setAccessible(true);
                f903m.put(str, declaredMethod);
            }
            return declaredMethod;
        } catch (Exception e2) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e2);
            return null;
        }
    }

    static <T> T m(@NonNull Object obj, @NonNull String str, @NonNull T t2) {
        try {
            return (T) k(str).invoke(obj, new Object[0]);
        } catch (Exception e2) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e2);
            return t2;
        }
    }

    private void s(float f2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (f2 != this.f913i.getPaint().getTextSize()) {
            this.f913i.getPaint().setTextSize(f2);
            boolean zA = b.a(this.f913i);
            if (this.f913i.getLayout() != null) {
                this.f906b = false;
                try {
                    Method methodK = k("nullLayouts");
                    if (methodK != null) {
                        methodK.invoke(this.f913i, new Object[0]);
                    }
                } catch (Exception e2) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e2);
                }
                if (zA) {
                    this.f913i.forceLayout();
                } else {
                    this.f913i.requestLayout();
                }
                this.f913i.invalidate();
            }
        }
    }

    private boolean u() {
        if (y() && this.f905a == 1) {
            if (!this.f911g || this.f910f.length == 0) {
                int iFloor = ((int) Math.floor((this.f909e - this.f908d) / this.f907c)) + 1;
                int[] iArr = new int[iFloor];
                for (int i2 = 0; i2 < iFloor; i2++) {
                    iArr[i2] = Math.round(this.f908d + (i2 * this.f907c));
                }
                this.f910f = b(iArr);
            }
            this.f906b = true;
        } else {
            this.f906b = false;
        }
        return this.f906b;
    }

    private void v(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i2 = 0; i2 < length; i2++) {
                iArr[i2] = typedArray.getDimensionPixelSize(i2, -1);
            }
            this.f910f = b(iArr);
            w();
        }
    }

    private boolean w() {
        boolean z2 = this.f910f.length > 0;
        this.f911g = z2;
        if (z2) {
            this.f905a = 1;
            this.f908d = r0[0];
            this.f909e = r0[r1 - 1];
            this.f907c = -1.0f;
        }
        return z2;
    }

    private boolean x(int i2, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.f913i.getText();
        TransformationMethod transformationMethod = this.f913i.getTransformationMethod();
        if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, this.f913i)) != null) {
            text = transformation;
        }
        int iB = a.b(this.f913i);
        l(i2);
        StaticLayout staticLayoutD = d(text, (Layout.Alignment) m(this.f913i, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), iB);
        return (iB == -1 || (staticLayoutD.getLineCount() <= iB && staticLayoutD.getLineEnd(staticLayoutD.getLineCount() - 1) == text.length())) && ((float) staticLayoutD.getHeight()) <= rectF.bottom;
    }

    private boolean y() {
        return !(this.f913i instanceof l);
    }

    private void z(float f2, float f3, float f4) throws IllegalArgumentException {
        if (f2 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f2 + "px) is less or equal to (0px)");
        }
        if (f3 <= f2) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f3 + "px) is less or equal to minimum auto-size text size (" + f2 + "px)");
        }
        if (f4 <= 0.0f) {
            throw new IllegalArgumentException("The auto-size step granularity (" + f4 + "px) is less or equal to (0px)");
        }
        this.f905a = 1;
        this.f908d = f2;
        this.f909e = f3;
        this.f907c = f4;
        this.f911g = false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    void a() {
        if (n()) {
            if (this.f906b) {
                if (this.f913i.getMeasuredHeight() <= 0 || this.f913i.getMeasuredWidth() <= 0) {
                    return;
                }
                int measuredWidth = this.f915k.b(this.f913i) ? 1048576 : (this.f913i.getMeasuredWidth() - this.f913i.getTotalPaddingLeft()) - this.f913i.getTotalPaddingRight();
                int height = (this.f913i.getHeight() - this.f913i.getCompoundPaddingBottom()) - this.f913i.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                RectF rectF = f902l;
                synchronized (rectF) {
                    rectF.setEmpty();
                    rectF.right = measuredWidth;
                    rectF.bottom = height;
                    float fE = e(rectF);
                    if (fE != this.f913i.getTextSize()) {
                        t(0, fE);
                    }
                }
            }
            this.f906b = true;
        }
    }

    @NonNull
    @VisibleForTesting
    StaticLayout d(@NonNull CharSequence charSequence, @NonNull Layout.Alignment alignment, int i2, int i3) {
        return Build.VERSION.SDK_INT >= 23 ? c.a(charSequence, alignment, i2, i3, this.f913i, this.f912h, this.f915k) : a.a(charSequence, alignment, i2, this.f913i, this.f912h);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    int f() {
        return Math.round(this.f909e);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    int g() {
        return Math.round(this.f908d);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    int h() {
        return Math.round(this.f907c);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    int[] i() {
        return this.f910f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    int j() {
        return this.f905a;
    }

    @VisibleForTesting
    void l(int i2) {
        TextPaint textPaint = this.f912h;
        if (textPaint == null) {
            this.f912h = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.f912h.set(this.f913i.getPaint());
        this.f912h.setTextSize(i2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    boolean n() {
        return y() && this.f905a != 0;
    }

    void o(@Nullable AttributeSet attributeSet, int i2) throws Resources.NotFoundException, IllegalArgumentException {
        int resourceId;
        Context context = this.f914j;
        int[] iArr = R$styleable.AppCompatTextView;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i2, 0);
        TextView textView = this.f913i;
        ViewCompat.M(textView, textView.getContext(), iArr, attributeSet, typedArrayObtainStyledAttributes, i2, 0);
        int i3 = R$styleable.AppCompatTextView_autoSizeTextType;
        if (typedArrayObtainStyledAttributes.hasValue(i3)) {
            this.f905a = typedArrayObtainStyledAttributes.getInt(i3, 0);
        }
        int i4 = R$styleable.AppCompatTextView_autoSizeStepGranularity;
        float dimension = typedArrayObtainStyledAttributes.hasValue(i4) ? typedArrayObtainStyledAttributes.getDimension(i4, -1.0f) : -1.0f;
        int i5 = R$styleable.AppCompatTextView_autoSizeMinTextSize;
        float dimension2 = typedArrayObtainStyledAttributes.hasValue(i5) ? typedArrayObtainStyledAttributes.getDimension(i5, -1.0f) : -1.0f;
        int i6 = R$styleable.AppCompatTextView_autoSizeMaxTextSize;
        float dimension3 = typedArrayObtainStyledAttributes.hasValue(i6) ? typedArrayObtainStyledAttributes.getDimension(i6, -1.0f) : -1.0f;
        int i7 = R$styleable.AppCompatTextView_autoSizePresetSizes;
        if (typedArrayObtainStyledAttributes.hasValue(i7) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(i7, 0)) > 0) {
            TypedArray typedArrayObtainTypedArray = typedArrayObtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            v(typedArrayObtainTypedArray);
            typedArrayObtainTypedArray.recycle();
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!y()) {
            this.f905a = 0;
            return;
        }
        if (this.f905a == 1) {
            if (!this.f911g) {
                DisplayMetrics displayMetrics = this.f914j.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                z(dimension2, dimension3, dimension);
            }
            u();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    void p(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        if (y()) {
            DisplayMetrics displayMetrics = this.f914j.getResources().getDisplayMetrics();
            z(TypedValue.applyDimension(i5, i2, displayMetrics), TypedValue.applyDimension(i5, i3, displayMetrics), TypedValue.applyDimension(i5, i4, displayMetrics));
            if (u()) {
                a();
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    void q(@NonNull int[] iArr, int i2) throws IllegalArgumentException {
        if (y()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArrCopyOf = new int[length];
                if (i2 == 0) {
                    iArrCopyOf = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.f914j.getResources().getDisplayMetrics();
                    for (int i3 = 0; i3 < length; i3++) {
                        iArrCopyOf[i3] = Math.round(TypedValue.applyDimension(i2, iArr[i3], displayMetrics));
                    }
                }
                this.f910f = b(iArrCopyOf);
                if (!w()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.f911g = false;
            }
            if (u()) {
                a();
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    void r(int i2) throws IllegalArgumentException {
        if (y()) {
            if (i2 == 0) {
                c();
                return;
            }
            if (i2 != 1) {
                throw new IllegalArgumentException("Unknown auto-size text type: " + i2);
            }
            DisplayMetrics displayMetrics = this.f914j.getResources().getDisplayMetrics();
            z(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (u()) {
                a();
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    void t(int i2, float f2) {
        Context context = this.f914j;
        s(TypedValue.applyDimension(i2, f2, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics()));
    }
}
