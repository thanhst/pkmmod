package androidx.appcompat.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.view.menu.k;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.bumptech.glide.request.target.Target;
import java.lang.reflect.InvocationTargetException;

@SuppressLint({"UnknownNullness"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements j1, androidx.core.view.e0, androidx.core.view.c0, androidx.core.view.d0 {
    static final int[] J = {R$attr.actionBarSize, R.attr.windowContentOverlay};

    @NonNull
    private WindowInsetsCompat A;

    @NonNull
    private WindowInsetsCompat B;
    private d C;
    private OverScroller D;
    ViewPropertyAnimator E;
    final AnimatorListenerAdapter F;
    private final Runnable G;
    private final Runnable H;
    private final androidx.core.view.f0 I;

    /* renamed from: e, reason: collision with root package name */
    private int f641e;

    /* renamed from: f, reason: collision with root package name */
    private int f642f;

    /* renamed from: g, reason: collision with root package name */
    private ContentFrameLayout f643g;

    /* renamed from: h, reason: collision with root package name */
    ActionBarContainer f644h;

    /* renamed from: i, reason: collision with root package name */
    private k1 f645i;

    /* renamed from: j, reason: collision with root package name */
    private Drawable f646j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f647k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f648l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f649m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f650n;

    /* renamed from: o, reason: collision with root package name */
    boolean f651o;

    /* renamed from: p, reason: collision with root package name */
    private int f652p;

    /* renamed from: q, reason: collision with root package name */
    private int f653q;

    /* renamed from: r, reason: collision with root package name */
    private final Rect f654r;

    /* renamed from: s, reason: collision with root package name */
    private final Rect f655s;

    /* renamed from: t, reason: collision with root package name */
    private final Rect f656t;

    /* renamed from: u, reason: collision with root package name */
    private final Rect f657u;

    /* renamed from: v, reason: collision with root package name */
    private final Rect f658v;

    /* renamed from: w, reason: collision with root package name */
    private final Rect f659w;

    /* renamed from: x, reason: collision with root package name */
    private final Rect f660x;

    /* renamed from: y, reason: collision with root package name */
    @NonNull
    private WindowInsetsCompat f661y;

    /* renamed from: z, reason: collision with root package name */
    @NonNull
    private WindowInsetsCompat f662z;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.E = null;
            actionBarOverlayLayout.f651o = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.E = null;
            actionBarOverlayLayout.f651o = false;
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.u();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.E = actionBarOverlayLayout.f644h.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.F);
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.u();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.E = actionBarOverlayLayout.f644h.animate().translationY(-ActionBarOverlayLayout.this.f644h.getHeight()).setListener(ActionBarOverlayLayout.this.F);
        }
    }

    public interface d {
        void a();

        void b();

        void c(int i2);

        void d();

        void e(boolean z2);

        void f();
    }

    public static class e extends ViewGroup.MarginLayoutParams {
        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public e(int i2, int i3) {
            super(i2, i3);
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public ActionBarOverlayLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f642f = 0;
        this.f654r = new Rect();
        this.f655s = new Rect();
        this.f656t = new Rect();
        this.f657u = new Rect();
        this.f658v = new Rect();
        this.f659w = new Rect();
        this.f660x = new Rect();
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.f1674b;
        this.f661y = windowInsetsCompat;
        this.f662z = windowInsetsCompat;
        this.A = windowInsetsCompat;
        this.B = windowInsetsCompat;
        this.F = new a();
        this.G = new b();
        this.H = new c();
        v(context);
        this.I = new androidx.core.view.f0(this);
    }

    private void A() {
        u();
        this.G.run();
    }

    private boolean B(float f2) {
        this.D.fling(0, 0, 0, (int) f2, 0, 0, Target.SIZE_ORIGINAL, Integer.MAX_VALUE);
        return this.D.getFinalY() > this.f644h.getHeight();
    }

    private void p() {
        u();
        this.H.run();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean q(@androidx.annotation.NonNull android.view.View r3, @androidx.annotation.NonNull android.graphics.Rect r4, boolean r5, boolean r6, boolean r7, boolean r8) {
        /*
            r2 = this;
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            androidx.appcompat.widget.ActionBarOverlayLayout$e r3 = (androidx.appcompat.widget.ActionBarOverlayLayout.e) r3
            r0 = 1
            if (r5 == 0) goto L13
            int r5 = r3.leftMargin
            int r1 = r4.left
            if (r5 == r1) goto L13
            r3.leftMargin = r1
            r5 = 1
            goto L14
        L13:
            r5 = 0
        L14:
            if (r6 == 0) goto L1f
            int r6 = r3.topMargin
            int r1 = r4.top
            if (r6 == r1) goto L1f
            r3.topMargin = r1
            r5 = 1
        L1f:
            if (r8 == 0) goto L2a
            int r6 = r3.rightMargin
            int r8 = r4.right
            if (r6 == r8) goto L2a
            r3.rightMargin = r8
            r5 = 1
        L2a:
            if (r7 == 0) goto L35
            int r6 = r3.bottomMargin
            int r4 = r4.bottom
            if (r6 == r4) goto L35
            r3.bottomMargin = r4
            goto L36
        L35:
            r0 = r5
        L36:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarOverlayLayout.q(android.view.View, android.graphics.Rect, boolean, boolean, boolean, boolean):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private k1 t(View view) {
        if (view instanceof k1) {
            return (k1) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    private void v(Context context) {
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(J);
        this.f641e = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        this.f646j = drawable;
        setWillNotDraw(drawable == null);
        typedArrayObtainStyledAttributes.recycle();
        this.f647k = context.getApplicationInfo().targetSdkVersion < 19;
        this.D = new OverScroller(context);
    }

    private void x() {
        u();
        postDelayed(this.H, 600L);
    }

    private void y() {
        u();
        postDelayed(this.G, 600L);
    }

    @Override // androidx.appcompat.widget.j1
    public void a(Menu menu, k.a aVar) {
        z();
        this.f645i.a(menu, aVar);
    }

    @Override // androidx.appcompat.widget.j1
    public boolean b() {
        z();
        return this.f645i.b();
    }

    @Override // androidx.appcompat.widget.j1
    public void c() {
        z();
        this.f645i.c();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e;
    }

    @Override // androidx.appcompat.widget.j1
    public boolean d() {
        z();
        return this.f645i.d();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f646j == null || this.f647k) {
            return;
        }
        int bottom = this.f644h.getVisibility() == 0 ? (int) (this.f644h.getBottom() + this.f644h.getTranslationY() + 0.5f) : 0;
        this.f646j.setBounds(0, bottom, getWidth(), this.f646j.getIntrinsicHeight() + bottom);
        this.f646j.draw(canvas);
    }

    @Override // androidx.appcompat.widget.j1
    public boolean e() {
        z();
        return this.f645i.e();
    }

    @Override // androidx.appcompat.widget.j1
    public boolean f() {
        z();
        return this.f645i.f();
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (Build.VERSION.SDK_INT >= 21) {
            return super.fitSystemWindows(rect);
        }
        z();
        boolean zQ = q(this.f644h, rect, true, true, false, true);
        this.f657u.set(rect);
        v2.a(this, this.f657u, this.f654r);
        if (!this.f658v.equals(this.f657u)) {
            this.f658v.set(this.f657u);
            zQ = true;
        }
        if (!this.f655s.equals(this.f654r)) {
            this.f655s.set(this.f654r);
            zQ = true;
        }
        if (zQ) {
            requestLayout();
        }
        return true;
    }

    @Override // androidx.appcompat.widget.j1
    public boolean g() {
        z();
        return this.f645i.g();
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f644h;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.I.a();
    }

    public CharSequence getTitle() {
        z();
        return this.f645i.getTitle();
    }

    @Override // androidx.core.view.c0
    public void h(View view, View view2, int i2, int i3) {
        if (i3 == 0) {
            onNestedScrollAccepted(view, view2, i2);
        }
    }

    @Override // androidx.core.view.c0
    public void i(View view, int i2) {
        if (i2 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // androidx.core.view.c0
    public void j(View view, int i2, int i3, int[] iArr, int i4) {
        if (i4 == 0) {
            onNestedPreScroll(view, i2, i3, iArr);
        }
    }

    @Override // androidx.appcompat.widget.j1
    public void k(int i2) {
        z();
        if (i2 == 2) {
            this.f645i.r();
        } else if (i2 == 5) {
            this.f645i.s();
        } else {
            if (i2 != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    @Override // androidx.appcompat.widget.j1
    public void l() {
        z();
        this.f645i.h();
    }

    @Override // androidx.core.view.d0
    public void m(View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        n(view, i2, i3, i4, i5, i6);
    }

    @Override // androidx.core.view.c0
    public void n(View view, int i2, int i3, int i4, int i5, int i6) {
        if (i6 == 0) {
            onNestedScroll(view, i2, i3, i4, i5);
        }
    }

    @Override // androidx.core.view.c0
    public boolean o(View view, View view2, int i2, int i3) {
        return i3 == 0 && onStartNestedScroll(view, view2, i2);
    }

    @Override // android.view.View
    @RequiresApi(21)
    public WindowInsets onApplyWindowInsets(@NonNull WindowInsets windowInsets) {
        z();
        WindowInsetsCompat windowInsetsCompatV = WindowInsetsCompat.v(windowInsets, this);
        boolean zQ = q(this.f644h, new Rect(windowInsetsCompatV.i(), windowInsetsCompatV.k(), windowInsetsCompatV.j(), windowInsetsCompatV.h()), true, true, false, true);
        ViewCompat.d(this, windowInsetsCompatV, this.f654r);
        Rect rect = this.f654r;
        WindowInsetsCompat windowInsetsCompatL = windowInsetsCompatV.l(rect.left, rect.top, rect.right, rect.bottom);
        this.f661y = windowInsetsCompatL;
        boolean z2 = true;
        if (!this.f662z.equals(windowInsetsCompatL)) {
            this.f662z = this.f661y;
            zQ = true;
        }
        if (this.f655s.equals(this.f654r)) {
            z2 = zQ;
        } else {
            this.f655s.set(this.f654r);
        }
        if (z2) {
            requestLayout();
        }
        return windowInsetsCompatV.a().c().b().t();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        v(getContext());
        ViewCompat.L(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        u();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i7 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin + paddingLeft;
                int i8 = ((ViewGroup.MarginLayoutParams) eVar).topMargin + paddingTop;
                childAt.layout(i7, i8, measuredWidth + i7, measuredHeight + i8);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int measuredHeight;
        z();
        measureChildWithMargins(this.f644h, i2, 0, i3, 0);
        e eVar = (e) this.f644h.getLayoutParams();
        int iMax = Math.max(0, this.f644h.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin + ((ViewGroup.MarginLayoutParams) eVar).rightMargin);
        int iMax2 = Math.max(0, this.f644h.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar).topMargin + ((ViewGroup.MarginLayoutParams) eVar).bottomMargin);
        int iCombineMeasuredStates = View.combineMeasuredStates(0, this.f644h.getMeasuredState());
        boolean z2 = (ViewCompat.x(this) & 256) != 0;
        if (z2) {
            measuredHeight = this.f641e;
            if (this.f649m && this.f644h.getTabContainer() != null) {
                measuredHeight += this.f641e;
            }
        } else {
            measuredHeight = this.f644h.getVisibility() != 8 ? this.f644h.getMeasuredHeight() : 0;
        }
        this.f656t.set(this.f654r);
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 21) {
            this.A = this.f661y;
        } else {
            this.f659w.set(this.f657u);
        }
        if (!this.f648l && !z2) {
            Rect rect = this.f656t;
            rect.top += measuredHeight;
            rect.bottom += 0;
            if (i4 >= 21) {
                this.A = this.A.l(0, measuredHeight, 0, 0);
            }
        } else if (i4 >= 21) {
            this.A = new WindowInsetsCompat.b(this.A).c(androidx.core.graphics.b.b(this.A.i(), this.A.k() + measuredHeight, this.A.j(), this.A.h() + 0)).a();
        } else {
            Rect rect2 = this.f659w;
            rect2.top += measuredHeight;
            rect2.bottom += 0;
        }
        q(this.f643g, this.f656t, true, true, true, true);
        if (i4 >= 21 && !this.B.equals(this.A)) {
            WindowInsetsCompat windowInsetsCompat = this.A;
            this.B = windowInsetsCompat;
            ViewCompat.e(this.f643g, windowInsetsCompat);
        } else if (i4 < 21 && !this.f660x.equals(this.f659w)) {
            this.f660x.set(this.f659w);
            this.f643g.a(this.f659w);
        }
        measureChildWithMargins(this.f643g, i2, 0, i3, 0);
        e eVar2 = (e) this.f643g.getLayoutParams();
        int iMax3 = Math.max(iMax, this.f643g.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar2).leftMargin + ((ViewGroup.MarginLayoutParams) eVar2).rightMargin);
        int iMax4 = Math.max(iMax2, this.f643g.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar2).topMargin + ((ViewGroup.MarginLayoutParams) eVar2).bottomMargin);
        int iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f643g.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i2, iCombineMeasuredStates2), View.resolveSizeAndState(Math.max(iMax4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i3, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.e0
    public boolean onNestedFling(View view, float f2, float f3, boolean z2) {
        if (!this.f650n || !z2) {
            return false;
        }
        if (B(f3)) {
            p();
        } else {
            A();
        }
        this.f651o = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.e0
    public boolean onNestedPreFling(View view, float f2, float f3) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.e0
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.e0
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        int i6 = this.f652p + i3;
        this.f652p = i6;
        setActionBarHideOffset(i6);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.e0
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        this.I.b(view, view2, i2);
        this.f652p = getActionBarHideOffset();
        u();
        d dVar = this.C;
        if (dVar != null) {
            dVar.b();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.e0
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        if ((i2 & 2) == 0 || this.f644h.getVisibility() != 0) {
            return false;
        }
        return this.f650n;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.e0
    public void onStopNestedScroll(View view) {
        if (this.f650n && !this.f651o) {
            if (this.f652p <= this.f644h.getHeight()) {
                y();
            } else {
                x();
            }
        }
        d dVar = this.C;
        if (dVar != null) {
            dVar.d();
        }
    }

    @Override // android.view.View
    @Deprecated
    public void onWindowSystemUiVisibilityChanged(int i2) {
        super.onWindowSystemUiVisibilityChanged(i2);
        z();
        int i3 = this.f653q ^ i2;
        this.f653q = i2;
        boolean z2 = (i2 & 4) == 0;
        boolean z3 = (i2 & 256) != 0;
        d dVar = this.C;
        if (dVar != null) {
            dVar.e(!z3);
            if (z2 || !z3) {
                this.C.a();
            } else {
                this.C.f();
            }
        }
        if ((i3 & 256) == 0 || this.C == null) {
            return;
        }
        ViewCompat.L(this);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        this.f642f = i2;
        d dVar = this.C;
        if (dVar != null) {
            dVar.c(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public e generateDefaultLayoutParams() {
        return new e(-1, -1);
    }

    @Override // android.view.ViewGroup
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    public void setActionBarHideOffset(int i2) {
        u();
        this.f644h.setTranslationY(-Math.max(0, Math.min(i2, this.f644h.getHeight())));
    }

    public void setActionBarVisibilityCallback(d dVar) {
        this.C = dVar;
        if (getWindowToken() != null) {
            this.C.c(this.f642f);
            int i2 = this.f653q;
            if (i2 != 0) {
                onWindowSystemUiVisibilityChanged(i2);
                ViewCompat.L(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z2) {
        this.f649m = z2;
    }

    public void setHideOnContentScrollEnabled(boolean z2) {
        if (z2 != this.f650n) {
            this.f650n = z2;
            if (z2) {
                return;
            }
            u();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i2) {
        z();
        this.f645i.setIcon(i2);
    }

    public void setLogo(int i2) {
        z();
        this.f645i.o(i2);
    }

    public void setOverlayMode(boolean z2) {
        this.f648l = z2;
        this.f647k = z2 && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z2) {
    }

    public void setUiOptions(int i2) {
    }

    @Override // androidx.appcompat.widget.j1
    public void setWindowCallback(Window.Callback callback) {
        z();
        this.f645i.setWindowCallback(callback);
    }

    @Override // androidx.appcompat.widget.j1
    public void setWindowTitle(CharSequence charSequence) {
        z();
        this.f645i.setWindowTitle(charSequence);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    void u() {
        removeCallbacks(this.G);
        removeCallbacks(this.H);
        ViewPropertyAnimator viewPropertyAnimator = this.E;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public boolean w() {
        return this.f648l;
    }

    void z() {
        if (this.f643g == null) {
            this.f643g = (ContentFrameLayout) findViewById(R$id.action_bar_activity_content);
            this.f644h = (ActionBarContainer) findViewById(R$id.action_bar_container);
            this.f645i = t(findViewById(R$id.action_bar));
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new e(layoutParams);
    }

    public void setIcon(Drawable drawable) {
        z();
        this.f645i.setIcon(drawable);
    }
}
