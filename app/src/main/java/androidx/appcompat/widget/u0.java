package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R$styleable;
import androidx.core.content.res.h;
import androidx.core.view.ViewCompat;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* compiled from: AppCompatTextHelper.java */
/* loaded from: classes.dex */
class u0 {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final TextView f1144a;

    /* renamed from: b, reason: collision with root package name */
    private i2 f1145b;

    /* renamed from: c, reason: collision with root package name */
    private i2 f1146c;

    /* renamed from: d, reason: collision with root package name */
    private i2 f1147d;

    /* renamed from: e, reason: collision with root package name */
    private i2 f1148e;

    /* renamed from: f, reason: collision with root package name */
    private i2 f1149f;

    /* renamed from: g, reason: collision with root package name */
    private i2 f1150g;

    /* renamed from: h, reason: collision with root package name */
    private i2 f1151h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    private final d1 f1152i;

    /* renamed from: j, reason: collision with root package name */
    private int f1153j = 0;

    /* renamed from: k, reason: collision with root package name */
    private int f1154k = -1;

    /* renamed from: l, reason: collision with root package name */
    private Typeface f1155l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f1156m;

    /* compiled from: AppCompatTextHelper.java */
    class a extends h.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f1157a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f1158b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ WeakReference f1159c;

        a(int i2, int i3, WeakReference weakReference) {
            this.f1157a = i2;
            this.f1158b = i3;
            this.f1159c = weakReference;
        }

        @Override // androidx.core.content.res.h.f
        /* renamed from: h */
        public void f(int i2) {
        }

        @Override // androidx.core.content.res.h.f
        /* renamed from: i */
        public void g(@NonNull Typeface typeface) {
            int i2;
            if (Build.VERSION.SDK_INT >= 28 && (i2 = this.f1157a) != -1) {
                typeface = g.a(typeface, i2, (this.f1158b & 2) != 0);
            }
            u0.this.n(this.f1159c, typeface);
        }
    }

    /* compiled from: AppCompatTextHelper.java */
    class b implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ TextView f1161e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Typeface f1162f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f1163g;

        b(TextView textView, Typeface typeface, int i2) {
            this.f1161e = textView;
            this.f1162f = typeface;
            this.f1163g = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1161e.setTypeface(this.f1162f, this.f1163g);
        }
    }

    /* compiled from: AppCompatTextHelper.java */
    @RequiresApi(17)
    static class c {
        @DoNotInline
        static Drawable[] a(TextView textView) {
            return textView.getCompoundDrawablesRelative();
        }

        @DoNotInline
        static void b(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }

        @DoNotInline
        static void c(TextView textView, Locale locale) {
            textView.setTextLocale(locale);
        }
    }

    /* compiled from: AppCompatTextHelper.java */
    @RequiresApi(21)
    static class d {
        @DoNotInline
        static Locale a(String str) {
            return Locale.forLanguageTag(str);
        }
    }

    /* compiled from: AppCompatTextHelper.java */
    @RequiresApi(24)
    static class e {
        @DoNotInline
        static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }

        @DoNotInline
        static void b(TextView textView, LocaleList localeList) {
            textView.setTextLocales(localeList);
        }
    }

    /* compiled from: AppCompatTextHelper.java */
    @RequiresApi(26)
    static class f {
        @DoNotInline
        static int a(TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }

        @DoNotInline
        static void b(TextView textView, int i2, int i3, int i4, int i5) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i2, i3, i4, i5);
        }

        @DoNotInline
        static void c(TextView textView, int[] iArr, int i2) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i2);
        }

        @DoNotInline
        static boolean d(TextView textView, String str) {
            return textView.setFontVariationSettings(str);
        }
    }

    /* compiled from: AppCompatTextHelper.java */
    @RequiresApi(28)
    static class g {
        @DoNotInline
        static Typeface a(Typeface typeface, int i2, boolean z2) {
            return Typeface.create(typeface, i2, z2);
        }
    }

    u0(@NonNull TextView textView) {
        this.f1144a = textView;
        this.f1152i = new d1(textView);
    }

    private void B(int i2, float f2) {
        this.f1152i.t(i2, f2);
    }

    private void C(Context context, k2 k2Var) {
        String strN;
        this.f1153j = k2Var.j(R$styleable.TextAppearance_android_textStyle, this.f1153j);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            int iJ = k2Var.j(R$styleable.TextAppearance_android_textFontWeight, -1);
            this.f1154k = iJ;
            if (iJ != -1) {
                this.f1153j = (this.f1153j & 2) | 0;
            }
        }
        int i3 = R$styleable.TextAppearance_android_fontFamily;
        if (!k2Var.r(i3) && !k2Var.r(R$styleable.TextAppearance_fontFamily)) {
            int i4 = R$styleable.TextAppearance_android_typeface;
            if (k2Var.r(i4)) {
                this.f1156m = false;
                int iJ2 = k2Var.j(i4, 1);
                if (iJ2 == 1) {
                    this.f1155l = Typeface.SANS_SERIF;
                    return;
                } else if (iJ2 == 2) {
                    this.f1155l = Typeface.SERIF;
                    return;
                } else {
                    if (iJ2 != 3) {
                        return;
                    }
                    this.f1155l = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.f1155l = null;
        int i5 = R$styleable.TextAppearance_fontFamily;
        if (k2Var.r(i5)) {
            i3 = i5;
        }
        int i6 = this.f1154k;
        int i7 = this.f1153j;
        if (!context.isRestricted()) {
            try {
                Typeface typefaceI = k2Var.i(i3, this.f1153j, new a(i6, i7, new WeakReference(this.f1144a)));
                if (typefaceI != null) {
                    if (i2 < 28 || this.f1154k == -1) {
                        this.f1155l = typefaceI;
                    } else {
                        this.f1155l = g.a(Typeface.create(typefaceI, 0), this.f1154k, (this.f1153j & 2) != 0);
                    }
                }
                this.f1156m = this.f1155l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f1155l != null || (strN = k2Var.n(i3)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28 || this.f1154k == -1) {
            this.f1155l = Typeface.create(strN, this.f1153j);
        } else {
            this.f1155l = g.a(Typeface.create(strN, 0), this.f1154k, (this.f1153j & 2) != 0);
        }
    }

    private void a(Drawable drawable, i2 i2Var) {
        if (drawable == null || i2Var == null) {
            return;
        }
        k.i(drawable, i2Var, this.f1144a.getDrawableState());
    }

    private static i2 d(Context context, k kVar, int i2) {
        ColorStateList colorStateListF = kVar.f(context, i2);
        if (colorStateListF == null) {
            return null;
        }
        i2 i2Var = new i2();
        i2Var.f974d = true;
        i2Var.f971a = colorStateListF;
        return i2Var;
    }

    private void y(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (drawable5 != null || drawable6 != null) {
            Drawable[] drawableArrA = c.a(this.f1144a);
            TextView textView = this.f1144a;
            if (drawable5 == null) {
                drawable5 = drawableArrA[0];
            }
            if (drawable2 == null) {
                drawable2 = drawableArrA[1];
            }
            if (drawable6 == null) {
                drawable6 = drawableArrA[2];
            }
            if (drawable4 == null) {
                drawable4 = drawableArrA[3];
            }
            c.b(textView, drawable5, drawable2, drawable6, drawable4);
            return;
        }
        if (drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) {
            return;
        }
        Drawable[] drawableArrA2 = c.a(this.f1144a);
        Drawable drawable7 = drawableArrA2[0];
        if (drawable7 != null || drawableArrA2[2] != null) {
            TextView textView2 = this.f1144a;
            if (drawable2 == null) {
                drawable2 = drawableArrA2[1];
            }
            Drawable drawable8 = drawableArrA2[2];
            if (drawable4 == null) {
                drawable4 = drawableArrA2[3];
            }
            c.b(textView2, drawable7, drawable2, drawable8, drawable4);
            return;
        }
        Drawable[] compoundDrawables = this.f1144a.getCompoundDrawables();
        TextView textView3 = this.f1144a;
        if (drawable == null) {
            drawable = compoundDrawables[0];
        }
        if (drawable2 == null) {
            drawable2 = compoundDrawables[1];
        }
        if (drawable3 == null) {
            drawable3 = compoundDrawables[2];
        }
        if (drawable4 == null) {
            drawable4 = compoundDrawables[3];
        }
        textView3.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    private void z() {
        i2 i2Var = this.f1151h;
        this.f1145b = i2Var;
        this.f1146c = i2Var;
        this.f1147d = i2Var;
        this.f1148e = i2Var;
        this.f1149f = i2Var;
        this.f1150g = i2Var;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    void A(int i2, float f2) {
        if (v2.f1168b || l()) {
            return;
        }
        B(i2, f2);
    }

    void b() {
        if (this.f1145b != null || this.f1146c != null || this.f1147d != null || this.f1148e != null) {
            Drawable[] compoundDrawables = this.f1144a.getCompoundDrawables();
            a(compoundDrawables[0], this.f1145b);
            a(compoundDrawables[1], this.f1146c);
            a(compoundDrawables[2], this.f1147d);
            a(compoundDrawables[3], this.f1148e);
        }
        if (this.f1149f == null && this.f1150g == null) {
            return;
        }
        Drawable[] drawableArrA = c.a(this.f1144a);
        a(drawableArrA[0], this.f1149f);
        a(drawableArrA[2], this.f1150g);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    void c() {
        this.f1152i.a();
    }

    int e() {
        return this.f1152i.f();
    }

    int f() {
        return this.f1152i.g();
    }

    int g() {
        return this.f1152i.h();
    }

    int[] h() {
        return this.f1152i.i();
    }

    int i() {
        return this.f1152i.j();
    }

    @Nullable
    ColorStateList j() {
        i2 i2Var = this.f1151h;
        if (i2Var != null) {
            return i2Var.f971a;
        }
        return null;
    }

    @Nullable
    PorterDuff.Mode k() {
        i2 i2Var = this.f1151h;
        if (i2Var != null) {
            return i2Var.f972b;
        }
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    boolean l() {
        return this.f1152i.n();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01a2  */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void m(@androidx.annotation.Nullable android.util.AttributeSet r24, int r25) {
        /*
            Method dump skipped, instructions count: 788
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.u0.m(android.util.AttributeSet, int):void");
    }

    void n(WeakReference<TextView> weakReference, Typeface typeface) {
        if (this.f1156m) {
            this.f1155l = typeface;
            TextView textView = weakReference.get();
            if (textView != null) {
                if (ViewCompat.A(textView)) {
                    textView.post(new b(textView, typeface, this.f1153j));
                } else {
                    textView.setTypeface(typeface, this.f1153j);
                }
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    void o(boolean z2, int i2, int i3, int i4, int i5) {
        if (v2.f1168b) {
            return;
        }
        c();
    }

    void p() {
        b();
    }

    void q(Context context, int i2) {
        String strN;
        ColorStateList colorStateListC;
        ColorStateList colorStateListC2;
        ColorStateList colorStateListC3;
        k2 k2VarS = k2.s(context, i2, R$styleable.TextAppearance);
        int i3 = R$styleable.TextAppearance_textAllCaps;
        if (k2VarS.r(i3)) {
            s(k2VarS.a(i3, false));
        }
        int i4 = Build.VERSION.SDK_INT;
        if (i4 < 23) {
            int i5 = R$styleable.TextAppearance_android_textColor;
            if (k2VarS.r(i5) && (colorStateListC3 = k2VarS.c(i5)) != null) {
                this.f1144a.setTextColor(colorStateListC3);
            }
            int i6 = R$styleable.TextAppearance_android_textColorLink;
            if (k2VarS.r(i6) && (colorStateListC2 = k2VarS.c(i6)) != null) {
                this.f1144a.setLinkTextColor(colorStateListC2);
            }
            int i7 = R$styleable.TextAppearance_android_textColorHint;
            if (k2VarS.r(i7) && (colorStateListC = k2VarS.c(i7)) != null) {
                this.f1144a.setHintTextColor(colorStateListC);
            }
        }
        int i8 = R$styleable.TextAppearance_android_textSize;
        if (k2VarS.r(i8) && k2VarS.e(i8, -1) == 0) {
            this.f1144a.setTextSize(0, 0.0f);
        }
        C(context, k2VarS);
        if (i4 >= 26) {
            int i9 = R$styleable.TextAppearance_fontVariationSettings;
            if (k2VarS.r(i9) && (strN = k2VarS.n(i9)) != null) {
                f.d(this.f1144a, strN);
            }
        }
        k2VarS.v();
        Typeface typeface = this.f1155l;
        if (typeface != null) {
            this.f1144a.setTypeface(typeface, this.f1153j);
        }
    }

    void r(@NonNull TextView textView, @Nullable InputConnection inputConnection, @NonNull EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 30 || inputConnection == null) {
            return;
        }
        p.b.f(editorInfo, textView.getText());
    }

    void s(boolean z2) {
        this.f1144a.setAllCaps(z2);
    }

    void t(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        this.f1152i.p(i2, i3, i4, i5);
    }

    void u(@NonNull int[] iArr, int i2) throws IllegalArgumentException {
        this.f1152i.q(iArr, i2);
    }

    void v(int i2) {
        this.f1152i.r(i2);
    }

    void w(@Nullable ColorStateList colorStateList) {
        if (this.f1151h == null) {
            this.f1151h = new i2();
        }
        i2 i2Var = this.f1151h;
        i2Var.f971a = colorStateList;
        i2Var.f974d = colorStateList != null;
        z();
    }

    void x(@Nullable PorterDuff.Mode mode) {
        if (this.f1151h == null) {
            this.f1151h = new i2();
        }
        i2 i2Var = this.f1151h;
        i2Var.f972b = mode;
        i2Var.f973c = mode != null;
        z();
    }
}
