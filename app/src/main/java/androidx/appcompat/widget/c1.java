package androidx.appcompat.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.core.text.h;
import androidx.core.widget.TextViewCompat;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* compiled from: AppCompatTextView.java */
/* loaded from: classes.dex */
public class c1 extends TextView implements androidx.core.view.k0, androidx.core.widget.o0 {

    /* renamed from: e, reason: collision with root package name */
    private final e f869e;

    /* renamed from: f, reason: collision with root package name */
    private final u0 f870f;

    /* renamed from: g, reason: collision with root package name */
    private final t0 f871g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    private n f872h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f873i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    private a f874j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    private Future<androidx.core.text.h> f875k;

    /* compiled from: AppCompatTextView.java */
    private interface a {
        void a(int[] iArr, int i2);

        void b(@Nullable TextClassifier textClassifier);

        int[] c();

        void d(@Px int i2);

        TextClassifier e();

        int f();

        void g(int i2, int i3, int i4, int i5);

        int h();

        int i();

        void j(@Px int i2);

        int k();

        void l(int i2);
    }

    /* compiled from: AppCompatTextView.java */
    @RequiresApi(api = 26)
    class b implements a {
        b() {
        }

        @Override // androidx.appcompat.widget.c1.a
        public void a(int[] iArr, int i2) {
            c1.super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i2);
        }

        @Override // androidx.appcompat.widget.c1.a
        public void b(@Nullable TextClassifier textClassifier) {
            c1.super.setTextClassifier(textClassifier);
        }

        @Override // androidx.appcompat.widget.c1.a
        public int[] c() {
            return c1.super.getAutoSizeTextAvailableSizes();
        }

        @Override // androidx.appcompat.widget.c1.a
        public void d(int i2) {
        }

        @Override // androidx.appcompat.widget.c1.a
        public TextClassifier e() {
            return c1.super.getTextClassifier();
        }

        @Override // androidx.appcompat.widget.c1.a
        public int f() {
            return c1.super.getAutoSizeMaxTextSize();
        }

        @Override // androidx.appcompat.widget.c1.a
        public void g(int i2, int i3, int i4, int i5) {
            c1.super.setAutoSizeTextTypeUniformWithConfiguration(i2, i3, i4, i5);
        }

        @Override // androidx.appcompat.widget.c1.a
        public int h() {
            return c1.super.getAutoSizeTextType();
        }

        @Override // androidx.appcompat.widget.c1.a
        public int i() {
            return c1.super.getAutoSizeMinTextSize();
        }

        @Override // androidx.appcompat.widget.c1.a
        public void j(int i2) {
        }

        @Override // androidx.appcompat.widget.c1.a
        public int k() {
            return c1.super.getAutoSizeStepGranularity();
        }

        @Override // androidx.appcompat.widget.c1.a
        public void l(int i2) {
            c1.super.setAutoSizeTextTypeWithDefaults(i2);
        }
    }

    /* compiled from: AppCompatTextView.java */
    @RequiresApi(api = 28)
    class c extends b {
        c() {
            super();
        }

        @Override // androidx.appcompat.widget.c1.b, androidx.appcompat.widget.c1.a
        public void d(@Px int i2) {
            c1.super.setLastBaselineToBottomHeight(i2);
        }

        @Override // androidx.appcompat.widget.c1.b, androidx.appcompat.widget.c1.a
        public void j(@Px int i2) {
            c1.super.setFirstBaselineToTopHeight(i2);
        }
    }

    public c1(@NonNull Context context) {
        this(context, null);
    }

    @NonNull
    private n getEmojiTextViewHelper() {
        if (this.f872h == null) {
            this.f872h = new n(this);
        }
        return this.f872h;
    }

    private void q() {
        Future<androidx.core.text.h> future = this.f875k;
        if (future != null) {
            try {
                this.f875k = null;
                TextViewCompat.k(this, future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f869e;
        if (eVar != null) {
            eVar.b();
        }
        u0 u0Var = this.f870f;
        if (u0Var != null) {
            u0Var.b();
        }
    }

    @Override // android.widget.TextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeMaxTextSize() {
        if (v2.f1168b) {
            return getSuperCaller().f();
        }
        u0 u0Var = this.f870f;
        if (u0Var != null) {
            return u0Var.e();
        }
        return -1;
    }

    @Override // android.widget.TextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeMinTextSize() {
        if (v2.f1168b) {
            return getSuperCaller().i();
        }
        u0 u0Var = this.f870f;
        if (u0Var != null) {
            return u0Var.f();
        }
        return -1;
    }

    @Override // android.widget.TextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeStepGranularity() {
        if (v2.f1168b) {
            return getSuperCaller().k();
        }
        u0 u0Var = this.f870f;
        if (u0Var != null) {
            return u0Var.g();
        }
        return -1;
    }

    @Override // android.widget.TextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int[] getAutoSizeTextAvailableSizes() {
        if (v2.f1168b) {
            return getSuperCaller().c();
        }
        u0 u0Var = this.f870f;
        return u0Var != null ? u0Var.h() : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeTextType() {
        if (v2.f1168b) {
            return getSuperCaller().h() == 1 ? 1 : 0;
        }
        u0 u0Var = this.f870f;
        if (u0Var != null) {
            return u0Var.i();
        }
        return 0;
    }

    @Override // android.widget.TextView
    @Nullable
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return TextViewCompat.m(super.getCustomSelectionActionModeCallback());
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return TextViewCompat.a(this);
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return TextViewCompat.b(this);
    }

    @RequiresApi(api = 26)
    @UiThread
    a getSuperCaller() {
        if (this.f874j == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 28) {
                this.f874j = new c();
            } else if (i2 >= 26) {
                this.f874j = new b();
            }
        }
        return this.f874j;
    }

    @Override // androidx.core.view.k0
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f869e;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    @Override // androidx.core.view.k0
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f869e;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f870f.j();
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f870f.k();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        q();
        return super.getText();
    }

    @Override // android.widget.TextView
    @NonNull
    @RequiresApi(api = 26)
    public TextClassifier getTextClassifier() {
        t0 t0Var;
        return (Build.VERSION.SDK_INT >= 28 || (t0Var = this.f871g) == null) ? getSuperCaller().e() : t0Var.a();
    }

    @NonNull
    public h.a getTextMetricsParamsCompat() {
        return TextViewCompat.e(this);
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f870f.r(this, inputConnectionOnCreateInputConnection, editorInfo);
        return o.a(inputConnectionOnCreateInputConnection, editorInfo, this);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        u0 u0Var = this.f870f;
        if (u0Var != null) {
            u0Var.o(z2, i2, i3, i4, i5);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i2, int i3) {
        q();
        super.onMeasure(i2, i3);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        u0 u0Var = this.f870f;
        if ((u0Var == null || v2.f1168b || !u0Var.l()) ? false : true) {
            this.f870f.c();
        }
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z2) {
        super.setAllCaps(z2);
        getEmojiTextViewHelper().c(z2);
    }

    @Override // android.widget.TextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAutoSizeTextTypeUniformWithConfiguration(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        if (v2.f1168b) {
            getSuperCaller().g(i2, i3, i4, i5);
            return;
        }
        u0 u0Var = this.f870f;
        if (u0Var != null) {
            u0Var.t(i2, i3, i4, i5);
        }
    }

    @Override // android.widget.TextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull int[] iArr, int i2) throws IllegalArgumentException {
        if (v2.f1168b) {
            getSuperCaller().a(iArr, i2);
            return;
        }
        u0 u0Var = this.f870f;
        if (u0Var != null) {
            u0Var.u(iArr, i2);
        }
    }

    @Override // android.widget.TextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAutoSizeTextTypeWithDefaults(int i2) {
        if (v2.f1168b) {
            getSuperCaller().l(i2);
            return;
        }
        u0 u0Var = this.f870f;
        if (u0Var != null) {
            u0Var.v(i2);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f869e;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int i2) {
        super.setBackgroundResource(i2);
        e eVar = this.f869e;
        if (eVar != null) {
            eVar.g(i2);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        u0 u0Var = this.f870f;
        if (u0Var != null) {
            u0Var.p();
        }
    }

    @Override // android.widget.TextView
    @RequiresApi(17)
    public void setCompoundDrawablesRelative(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        u0 u0Var = this.f870f;
        if (u0Var != null) {
            u0Var.p();
        }
    }

    @Override // android.widget.TextView
    @RequiresApi(17)
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        u0 u0Var = this.f870f;
        if (u0Var != null) {
            u0Var.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        u0 u0Var = this.f870f;
        if (u0Var != null) {
            u0Var.p();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(@Nullable ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.n(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z2) {
        getEmojiTextViewHelper().d(z2);
    }

    @Override // android.widget.TextView
    public void setFilters(@NonNull InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(@IntRange(from = 0) @Px int i2) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().j(i2);
        } else {
            TextViewCompat.h(this, i2);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(@IntRange(from = 0) @Px int i2) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().d(i2);
        } else {
            TextViewCompat.i(this, i2);
        }
    }

    @Override // android.widget.TextView
    public void setLineHeight(@IntRange(from = 0) @Px int i2) {
        TextViewCompat.j(this, i2);
    }

    public void setPrecomputedText(@NonNull androidx.core.text.h hVar) {
        TextViewCompat.k(this, hVar);
    }

    @Override // androidx.core.view.k0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        e eVar = this.f869e;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    @Override // androidx.core.view.k0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        e eVar = this.f869e;
        if (eVar != null) {
            eVar.j(mode);
        }
    }

    @Override // androidx.core.widget.o0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintList(@Nullable ColorStateList colorStateList) {
        this.f870f.w(colorStateList);
        this.f870f.b();
    }

    @Override // androidx.core.widget.o0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintMode(@Nullable PorterDuff.Mode mode) {
        this.f870f.x(mode);
        this.f870f.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        u0 u0Var = this.f870f;
        if (u0Var != null) {
            u0Var.q(context, i2);
        }
    }

    @Override // android.widget.TextView
    @RequiresApi(api = 26)
    public void setTextClassifier(@Nullable TextClassifier textClassifier) {
        t0 t0Var;
        if (Build.VERSION.SDK_INT >= 28 || (t0Var = this.f871g) == null) {
            getSuperCaller().b(textClassifier);
        } else {
            t0Var.b(textClassifier);
        }
    }

    public void setTextFuture(@Nullable Future<androidx.core.text.h> future) {
        this.f875k = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(@NonNull h.a aVar) {
        TextViewCompat.l(this, aVar);
    }

    @Override // android.widget.TextView
    public void setTextSize(int i2, float f2) {
        if (v2.f1168b) {
            super.setTextSize(i2, f2);
            return;
        }
        u0 u0Var = this.f870f;
        if (u0Var != null) {
            u0Var.A(i2, f2);
        }
    }

    @Override // android.widget.TextView
    public void setTypeface(@Nullable Typeface typeface, int i2) {
        if (this.f873i) {
            return;
        }
        Typeface typefaceA = null;
        if (typeface != null && i2 > 0) {
            typefaceA = androidx.core.graphics.f.a(getContext(), typeface, i2);
        }
        this.f873i = true;
        if (typefaceA != null) {
            typeface = typefaceA;
        }
        try {
            super.setTypeface(typeface, i2);
        } finally {
            this.f873i = false;
        }
    }

    public c1(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    public c1(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(h2.b(context), attributeSet, i2);
        this.f873i = false;
        this.f874j = null;
        f2.a(this, getContext());
        e eVar = new e(this);
        this.f869e = eVar;
        eVar.e(attributeSet, i2);
        u0 u0Var = new u0(this);
        this.f870f = u0Var;
        u0Var.m(attributeSet, i2);
        u0Var.b();
        this.f871g = new t0(this);
        getEmojiTextViewHelper().b(attributeSet, i2);
    }

    @Override // android.widget.TextView
    @RequiresApi(17)
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i2 != 0 ? e.a.b(context, i2) : null, i3 != 0 ? e.a.b(context, i3) : null, i4 != 0 ? e.a.b(context, i4) : null, i5 != 0 ? e.a.b(context, i5) : null);
        u0 u0Var = this.f870f;
        if (u0Var != null) {
            u0Var.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i2 != 0 ? e.a.b(context, i2) : null, i3 != 0 ? e.a.b(context, i3) : null, i4 != 0 ? e.a.b(context, i4) : null, i5 != 0 ? e.a.b(context, i5) : null);
        u0 u0Var = this.f870f;
        if (u0Var != null) {
            u0Var.p();
        }
    }
}
