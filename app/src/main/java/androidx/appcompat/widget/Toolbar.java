package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.ColorInt;
import androidx.annotation.DoNotInline;
import androidx.annotation.DrawableRes;
import androidx.annotation.MainThread;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.bumptech.glide.request.target.Target;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public class Toolbar extends ViewGroup {
    private int A;
    private CharSequence B;
    private CharSequence C;
    private ColorStateList D;
    private ColorStateList E;
    private boolean F;
    private boolean G;
    private final ArrayList<View> H;
    private final ArrayList<View> I;
    private final int[] J;
    final androidx.core.view.j K;
    private ArrayList<MenuItem> L;
    h M;
    private final ActionMenuView.e N;
    private n2 O;
    private androidx.appcompat.widget.c P;
    private f Q;
    private k.a R;
    e.a S;
    private boolean T;
    private OnBackInvokedCallback U;
    private OnBackInvokedDispatcher V;
    private boolean W;

    /* renamed from: a0, reason: collision with root package name */
    private final Runnable f789a0;

    /* renamed from: e, reason: collision with root package name */
    ActionMenuView f790e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f791f;

    /* renamed from: g, reason: collision with root package name */
    private TextView f792g;

    /* renamed from: h, reason: collision with root package name */
    private ImageButton f793h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f794i;

    /* renamed from: j, reason: collision with root package name */
    private Drawable f795j;

    /* renamed from: k, reason: collision with root package name */
    private CharSequence f796k;

    /* renamed from: l, reason: collision with root package name */
    ImageButton f797l;

    /* renamed from: m, reason: collision with root package name */
    View f798m;

    /* renamed from: n, reason: collision with root package name */
    private Context f799n;

    /* renamed from: o, reason: collision with root package name */
    private int f800o;

    /* renamed from: p, reason: collision with root package name */
    private int f801p;

    /* renamed from: q, reason: collision with root package name */
    private int f802q;

    /* renamed from: r, reason: collision with root package name */
    int f803r;

    /* renamed from: s, reason: collision with root package name */
    private int f804s;

    /* renamed from: t, reason: collision with root package name */
    private int f805t;

    /* renamed from: u, reason: collision with root package name */
    private int f806u;

    /* renamed from: v, reason: collision with root package name */
    private int f807v;

    /* renamed from: w, reason: collision with root package name */
    private int f808w;

    /* renamed from: x, reason: collision with root package name */
    private b2 f809x;

    /* renamed from: y, reason: collision with root package name */
    private int f810y;

    /* renamed from: z, reason: collision with root package name */
    private int f811z;

    class a implements ActionMenuView.e {
        a() {
        }

        @Override // androidx.appcompat.widget.ActionMenuView.e
        public boolean onMenuItemClick(MenuItem menuItem) {
            if (Toolbar.this.K.j(menuItem)) {
                return true;
            }
            h hVar = Toolbar.this.M;
            if (hVar != null) {
                return hVar.onMenuItemClick(menuItem);
            }
            return false;
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Toolbar.this.P();
        }
    }

    class c implements e.a {
        c() {
        }

        @Override // androidx.appcompat.view.menu.e.a
        public boolean a(@NonNull androidx.appcompat.view.menu.e eVar, @NonNull MenuItem menuItem) {
            e.a aVar = Toolbar.this.S;
            return aVar != null && aVar.a(eVar, menuItem);
        }

        @Override // androidx.appcompat.view.menu.e.a
        public void b(@NonNull androidx.appcompat.view.menu.e eVar) {
            if (!Toolbar.this.f790e.F()) {
                Toolbar.this.K.k(eVar);
            }
            e.a aVar = Toolbar.this.S;
            if (aVar != null) {
                aVar.b(eVar);
            }
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Toolbar.this.e();
        }
    }

    @RequiresApi(33)
    static class e {
        @Nullable
        @DoNotInline
        static OnBackInvokedDispatcher a(@NonNull View view) {
            return view.findOnBackInvokedDispatcher();
        }

        @NonNull
        @DoNotInline
        static OnBackInvokedCallback b(@NonNull Runnable runnable) {
            Objects.requireNonNull(runnable);
            return new android.view.j(runnable);
        }

        @DoNotInline
        static void c(@NonNull Object obj, @NonNull Object obj2) {
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(1000000, (OnBackInvokedCallback) obj2);
        }

        @DoNotInline
        static void d(@NonNull Object obj, @NonNull Object obj2) {
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    private class f implements androidx.appcompat.view.menu.k {

        /* renamed from: e, reason: collision with root package name */
        androidx.appcompat.view.menu.e f818e;

        /* renamed from: f, reason: collision with root package name */
        androidx.appcompat.view.menu.g f819f;

        f() {
        }

        @Override // androidx.appcompat.view.menu.k
        public void a(androidx.appcompat.view.menu.e eVar, boolean z2) {
        }

        @Override // androidx.appcompat.view.menu.k
        public void c(Context context, androidx.appcompat.view.menu.e eVar) {
            androidx.appcompat.view.menu.g gVar;
            androidx.appcompat.view.menu.e eVar2 = this.f818e;
            if (eVar2 != null && (gVar = this.f819f) != null) {
                eVar2.f(gVar);
            }
            this.f818e = eVar;
        }

        @Override // androidx.appcompat.view.menu.k
        public boolean e(androidx.appcompat.view.menu.p pVar) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.k
        public void f(boolean z2) {
            if (this.f819f != null) {
                androidx.appcompat.view.menu.e eVar = this.f818e;
                boolean z3 = false;
                if (eVar != null) {
                    int size = eVar.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            break;
                        }
                        if (this.f818e.getItem(i2) == this.f819f) {
                            z3 = true;
                            break;
                        }
                        i2++;
                    }
                }
                if (z3) {
                    return;
                }
                i(this.f818e, this.f819f);
            }
        }

        @Override // androidx.appcompat.view.menu.k
        public boolean h() {
            return false;
        }

        @Override // androidx.appcompat.view.menu.k
        public boolean i(androidx.appcompat.view.menu.e eVar, androidx.appcompat.view.menu.g gVar) {
            KeyEvent.Callback callback = Toolbar.this.f798m;
            if (callback instanceof androidx.appcompat.view.c) {
                ((androidx.appcompat.view.c) callback).onActionViewCollapsed();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.f798m);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.f797l);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.f798m = null;
            toolbar3.a();
            this.f819f = null;
            Toolbar.this.requestLayout();
            gVar.r(false);
            Toolbar.this.Q();
            return true;
        }

        @Override // androidx.appcompat.view.menu.k
        public boolean j(androidx.appcompat.view.menu.e eVar, androidx.appcompat.view.menu.g gVar) {
            Toolbar.this.g();
            ViewParent parent = Toolbar.this.f797l.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.f797l);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.f797l);
            }
            Toolbar.this.f798m = gVar.getActionView();
            this.f819f = gVar;
            ViewParent parent2 = Toolbar.this.f798m.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.f798m);
                }
                g gVarGenerateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                Toolbar toolbar4 = Toolbar.this;
                gVarGenerateDefaultLayoutParams.f80a = 8388611 | (toolbar4.f803r & 112);
                gVarGenerateDefaultLayoutParams.f821b = 2;
                toolbar4.f798m.setLayoutParams(gVarGenerateDefaultLayoutParams);
                Toolbar toolbar5 = Toolbar.this;
                toolbar5.addView(toolbar5.f798m);
            }
            Toolbar.this.I();
            Toolbar.this.requestLayout();
            gVar.r(true);
            KeyEvent.Callback callback = Toolbar.this.f798m;
            if (callback instanceof androidx.appcompat.view.c) {
                ((androidx.appcompat.view.c) callback).onActionViewExpanded();
            }
            Toolbar.this.Q();
            return true;
        }
    }

    public interface h {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public Toolbar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.toolbarStyle);
    }

    private int C(View view, int i2, int[] iArr, int i3) {
        g gVar = (g) view.getLayoutParams();
        int i4 = ((ViewGroup.MarginLayoutParams) gVar).leftMargin - iArr[0];
        int iMax = i2 + Math.max(0, i4);
        iArr[0] = Math.max(0, -i4);
        int iQ = q(view, i3);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, iQ, iMax + measuredWidth, view.getMeasuredHeight() + iQ);
        return iMax + measuredWidth + ((ViewGroup.MarginLayoutParams) gVar).rightMargin;
    }

    private int D(View view, int i2, int[] iArr, int i3) {
        g gVar = (g) view.getLayoutParams();
        int i4 = ((ViewGroup.MarginLayoutParams) gVar).rightMargin - iArr[1];
        int iMax = i2 - Math.max(0, i4);
        iArr[1] = Math.max(0, -i4);
        int iQ = q(view, i3);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, iQ, iMax, view.getMeasuredHeight() + iQ);
        return iMax - (measuredWidth + ((ViewGroup.MarginLayoutParams) gVar).leftMargin);
    }

    private int E(View view, int i2, int i3, int i4, int i5, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i6 = marginLayoutParams.leftMargin - iArr[0];
        int i7 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i6) + Math.max(0, i7);
        iArr[0] = Math.max(0, -i6);
        iArr[1] = Math.max(0, -i7);
        view.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + iMax + i3, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i4, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i5, marginLayoutParams.height));
        return view.getMeasuredWidth() + iMax;
    }

    private void F(View view, int i2, int i3, int i4, int i5, int i6) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i3, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i4, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i5, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i6 >= 0) {
            if (mode != 0) {
                i6 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i6);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private void G() {
        Menu menu = getMenu();
        ArrayList<MenuItem> currentMenuItems = getCurrentMenuItems();
        this.K.h(menu, getMenuInflater());
        ArrayList<MenuItem> currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.L = currentMenuItems2;
    }

    private void H() {
        removeCallbacks(this.f789a0);
        post(this.f789a0);
    }

    private boolean N() {
        if (!this.T) {
            return false;
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (O(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean O(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private void b(List<View> list, int i2) {
        boolean z2 = ViewCompat.r(this) == 1;
        int childCount = getChildCount();
        int iA = androidx.core.view.d.a(i2, ViewCompat.r(this));
        list.clear();
        if (!z2) {
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                g gVar = (g) childAt.getLayoutParams();
                if (gVar.f821b == 0 && O(childAt) && p(gVar.f80a) == iA) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i4 = childCount - 1; i4 >= 0; i4--) {
            View childAt2 = getChildAt(i4);
            g gVar2 = (g) childAt2.getLayoutParams();
            if (gVar2.f821b == 0 && O(childAt2) && p(gVar2.f80a) == iA) {
                list.add(childAt2);
            }
        }
    }

    private void c(View view, boolean z2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        g gVarGenerateDefaultLayoutParams = layoutParams == null ? generateDefaultLayoutParams() : !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : (g) layoutParams;
        gVarGenerateDefaultLayoutParams.f821b = 1;
        if (!z2 || this.f798m == null) {
            addView(view, gVarGenerateDefaultLayoutParams);
        } else {
            view.setLayoutParams(gVarGenerateDefaultLayoutParams);
            this.I.add(view);
        }
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menu = getMenu();
        for (int i2 = 0; i2 < menu.size(); i2++) {
            arrayList.add(menu.getItem(i2));
        }
        return arrayList;
    }

    private MenuInflater getMenuInflater() {
        return new androidx.appcompat.view.g(getContext());
    }

    private void h() {
        if (this.f809x == null) {
            this.f809x = new b2();
        }
    }

    private void i() {
        if (this.f794i == null) {
            this.f794i = new AppCompatImageView(getContext());
        }
    }

    private void j() {
        k();
        if (this.f790e.J() == null) {
            androidx.appcompat.view.menu.e eVar = (androidx.appcompat.view.menu.e) this.f790e.getMenu();
            if (this.Q == null) {
                this.Q = new f();
            }
            this.f790e.setExpandedActionViewsExclusive(true);
            eVar.c(this.Q, this.f799n);
            Q();
        }
    }

    private void k() {
        if (this.f790e == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.f790e = actionMenuView;
            actionMenuView.setPopupTheme(this.f800o);
            this.f790e.setOnMenuItemClickListener(this.N);
            this.f790e.K(this.R, new c());
            g gVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            gVarGenerateDefaultLayoutParams.f80a = 8388613 | (this.f803r & 112);
            this.f790e.setLayoutParams(gVarGenerateDefaultLayoutParams);
            c(this.f790e, false);
        }
    }

    private void l() {
        if (this.f793h == null) {
            this.f793h = new p(getContext(), null, R$attr.toolbarNavigationButtonStyle);
            g gVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            gVarGenerateDefaultLayoutParams.f80a = 8388611 | (this.f803r & 112);
            this.f793h.setLayoutParams(gVarGenerateDefaultLayoutParams);
        }
    }

    private int p(int i2) {
        int iR = ViewCompat.r(this);
        int iA = androidx.core.view.d.a(i2, iR) & 7;
        return (iA == 1 || iA == 3 || iA == 5) ? iA : iR == 1 ? 5 : 3;
    }

    private int q(View view, int i2) {
        g gVar = (g) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i3 = i2 > 0 ? (measuredHeight - i2) / 2 : 0;
        int iR = r(gVar.f80a);
        if (iR == 48) {
            return getPaddingTop() - i3;
        }
        if (iR == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) gVar).bottomMargin) - i3;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i4 = ((ViewGroup.MarginLayoutParams) gVar).topMargin;
        if (iMax < i4) {
            iMax = i4;
        } else {
            int i5 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            int i6 = ((ViewGroup.MarginLayoutParams) gVar).bottomMargin;
            if (i5 < i6) {
                iMax = Math.max(0, iMax - (i6 - i5));
            }
        }
        return paddingTop + iMax;
    }

    private int r(int i2) {
        int i3 = i2 & 112;
        return (i3 == 16 || i3 == 48 || i3 == 80) ? i3 : this.A & 112;
    }

    private int s(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return androidx.core.view.g.b(marginLayoutParams) + androidx.core.view.g.a(marginLayoutParams);
    }

    private int t(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private int u(List<View> list, int[] iArr) {
        int i2 = iArr[0];
        int i3 = iArr[1];
        int size = list.size();
        int i4 = 0;
        int measuredWidth = 0;
        while (i4 < size) {
            View view = list.get(i4);
            g gVar = (g) view.getLayoutParams();
            int i5 = ((ViewGroup.MarginLayoutParams) gVar).leftMargin - i2;
            int i6 = ((ViewGroup.MarginLayoutParams) gVar).rightMargin - i3;
            int iMax = Math.max(0, i5);
            int iMax2 = Math.max(0, i6);
            int iMax3 = Math.max(0, -i5);
            int iMax4 = Math.max(0, -i6);
            measuredWidth += iMax + view.getMeasuredWidth() + iMax2;
            i4++;
            i3 = iMax4;
            i2 = iMax3;
        }
        return measuredWidth;
    }

    private boolean z(View view) {
        return view.getParent() == this || this.I.contains(view);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean A() {
        ActionMenuView actionMenuView = this.f790e;
        return actionMenuView != null && actionMenuView.E();
    }

    public boolean B() {
        ActionMenuView actionMenuView = this.f790e;
        return actionMenuView != null && actionMenuView.F();
    }

    void I() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (((g) childAt.getLayoutParams()).f821b != 2 && childAt != this.f790e) {
                removeViewAt(childCount);
                this.I.add(childAt);
            }
        }
    }

    public void J(int i2, int i3) {
        h();
        this.f809x.g(i2, i3);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void K(androidx.appcompat.view.menu.e eVar, androidx.appcompat.widget.c cVar) {
        if (eVar == null && this.f790e == null) {
            return;
        }
        k();
        androidx.appcompat.view.menu.e eVarJ = this.f790e.J();
        if (eVarJ == eVar) {
            return;
        }
        if (eVarJ != null) {
            eVarJ.O(this.P);
            eVarJ.O(this.Q);
        }
        if (this.Q == null) {
            this.Q = new f();
        }
        cVar.G(true);
        if (eVar != null) {
            eVar.c(cVar, this.f799n);
            eVar.c(this.Q, this.f799n);
        } else {
            cVar.c(this.f799n, null);
            this.Q.c(this.f799n, null);
            cVar.f(true);
            this.Q.f(true);
        }
        this.f790e.setPopupTheme(this.f800o);
        this.f790e.setPresenter(cVar);
        this.P = cVar;
        Q();
    }

    public void L(Context context, @StyleRes int i2) {
        this.f802q = i2;
        TextView textView = this.f792g;
        if (textView != null) {
            textView.setTextAppearance(context, i2);
        }
    }

    public void M(Context context, @StyleRes int i2) {
        this.f801p = i2;
        TextView textView = this.f791f;
        if (textView != null) {
            textView.setTextAppearance(context, i2);
        }
    }

    public boolean P() {
        ActionMenuView actionMenuView = this.f790e;
        return actionMenuView != null && actionMenuView.L();
    }

    void Q() {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher onBackInvokedDispatcherA = e.a(this);
            boolean z2 = v() && onBackInvokedDispatcherA != null && ViewCompat.A(this) && this.W;
            if (z2 && this.V == null) {
                if (this.U == null) {
                    this.U = e.b(new Runnable() { // from class: androidx.appcompat.widget.m2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f1014e.e();
                        }
                    });
                }
                e.c(onBackInvokedDispatcherA, this.U);
                this.V = onBackInvokedDispatcherA;
                return;
            }
            if (z2 || (onBackInvokedDispatcher = this.V) == null) {
                return;
            }
            e.d(onBackInvokedDispatcher, this.U);
            this.V = null;
        }
    }

    void a() {
        for (int size = this.I.size() - 1; size >= 0; size--) {
            addView(this.I.get(size));
        }
        this.I.clear();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof g);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean d() {
        ActionMenuView actionMenuView;
        return getVisibility() == 0 && (actionMenuView = this.f790e) != null && actionMenuView.G();
    }

    public void e() {
        f fVar = this.Q;
        androidx.appcompat.view.menu.g gVar = fVar == null ? null : fVar.f819f;
        if (gVar != null) {
            gVar.collapseActionView();
        }
    }

    public void f() {
        ActionMenuView actionMenuView = this.f790e;
        if (actionMenuView != null) {
            actionMenuView.x();
        }
    }

    void g() {
        if (this.f797l == null) {
            p pVar = new p(getContext(), null, R$attr.toolbarNavigationButtonStyle);
            this.f797l = pVar;
            pVar.setImageDrawable(this.f795j);
            this.f797l.setContentDescription(this.f796k);
            g gVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            gVarGenerateDefaultLayoutParams.f80a = 8388611 | (this.f803r & 112);
            gVarGenerateDefaultLayoutParams.f821b = 2;
            this.f797l.setLayoutParams(gVarGenerateDefaultLayoutParams);
            this.f797l.setOnClickListener(new d());
        }
    }

    @Nullable
    public CharSequence getCollapseContentDescription() {
        ImageButton imageButton = this.f797l;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    @Nullable
    public Drawable getCollapseIcon() {
        ImageButton imageButton = this.f797l;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        b2 b2Var = this.f809x;
        if (b2Var != null) {
            return b2Var.a();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i2 = this.f811z;
        return i2 != Integer.MIN_VALUE ? i2 : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        b2 b2Var = this.f809x;
        if (b2Var != null) {
            return b2Var.b();
        }
        return 0;
    }

    public int getContentInsetRight() {
        b2 b2Var = this.f809x;
        if (b2Var != null) {
            return b2Var.c();
        }
        return 0;
    }

    public int getContentInsetStart() {
        b2 b2Var = this.f809x;
        if (b2Var != null) {
            return b2Var.d();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i2 = this.f810y;
        return i2 != Integer.MIN_VALUE ? i2 : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        androidx.appcompat.view.menu.e eVarJ;
        ActionMenuView actionMenuView = this.f790e;
        return actionMenuView != null && (eVarJ = actionMenuView.J()) != null && eVarJ.hasVisibleItems() ? Math.max(getContentInsetEnd(), Math.max(this.f811z, 0)) : getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        return ViewCompat.r(this) == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return ViewCompat.r(this) == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.f810y, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        ImageView imageView = this.f794i;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.f794i;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        j();
        return this.f790e.getMenu();
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.TESTS})
    View getNavButtonView() {
        return this.f793h;
    }

    @Nullable
    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.f793h;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    @Nullable
    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.f793h;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    androidx.appcompat.widget.c getOuterActionMenuPresenter() {
        return this.P;
    }

    @Nullable
    public Drawable getOverflowIcon() {
        j();
        return this.f790e.getOverflowIcon();
    }

    Context getPopupContext() {
        return this.f799n;
    }

    @StyleRes
    public int getPopupTheme() {
        return this.f800o;
    }

    public CharSequence getSubtitle() {
        return this.C;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.TESTS})
    final TextView getSubtitleTextView() {
        return this.f792g;
    }

    public CharSequence getTitle() {
        return this.B;
    }

    public int getTitleMarginBottom() {
        return this.f808w;
    }

    public int getTitleMarginEnd() {
        return this.f806u;
    }

    public int getTitleMarginStart() {
        return this.f805t;
    }

    public int getTitleMarginTop() {
        return this.f807v;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.TESTS})
    final TextView getTitleTextView() {
        return this.f791f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public k1 getWrapper() {
        if (this.O == null) {
            this.O = new n2(this, true);
        }
        return this.O;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public g generateDefaultLayoutParams() {
        return new g(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public g generateLayoutParams(AttributeSet attributeSet) {
        return new g(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public g generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof g ? new g((g) layoutParams) : layoutParams instanceof ActionBar.a ? new g((ActionBar.a) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new g((ViewGroup.MarginLayoutParams) layoutParams) : new g(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Q();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f789a0);
        Q();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.G = false;
        }
        if (!this.G) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.G = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.G = false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x029f A[LOOP:0: B:104:0x029d->B:105:0x029f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02c1 A[LOOP:1: B:107:0x02bf->B:108:0x02c1, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02fa A[LOOP:2: B:116:0x02f8->B:117:0x02fa, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0227  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instructions count: 783
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int measuredWidth;
        int iMax;
        int iCombineMeasuredStates;
        int measuredWidth2;
        int iCombineMeasuredStates2;
        int iMax2;
        int measuredHeight;
        int[] iArr = this.J;
        boolean zB = v2.b(this);
        int i4 = !zB ? 1 : 0;
        if (O(this.f793h)) {
            F(this.f793h, i2, 0, i3, 0, this.f804s);
            measuredWidth = this.f793h.getMeasuredWidth() + s(this.f793h);
            iMax = Math.max(0, this.f793h.getMeasuredHeight() + t(this.f793h));
            iCombineMeasuredStates = View.combineMeasuredStates(0, this.f793h.getMeasuredState());
        } else {
            measuredWidth = 0;
            iMax = 0;
            iCombineMeasuredStates = 0;
        }
        if (O(this.f797l)) {
            F(this.f797l, i2, 0, i3, 0, this.f804s);
            measuredWidth = this.f797l.getMeasuredWidth() + s(this.f797l);
            iMax = Math.max(iMax, this.f797l.getMeasuredHeight() + t(this.f797l));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f797l.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int iMax3 = 0 + Math.max(currentContentInsetStart, measuredWidth);
        iArr[zB ? 1 : 0] = Math.max(0, currentContentInsetStart - measuredWidth);
        if (O(this.f790e)) {
            F(this.f790e, i2, iMax3, i3, 0, this.f804s);
            measuredWidth2 = this.f790e.getMeasuredWidth() + s(this.f790e);
            iMax = Math.max(iMax, this.f790e.getMeasuredHeight() + t(this.f790e));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f790e.getMeasuredState());
        } else {
            measuredWidth2 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int iMax4 = iMax3 + Math.max(currentContentInsetEnd, measuredWidth2);
        iArr[i4] = Math.max(0, currentContentInsetEnd - measuredWidth2);
        if (O(this.f798m)) {
            iMax4 += E(this.f798m, i2, iMax4, i3, 0, iArr);
            iMax = Math.max(iMax, this.f798m.getMeasuredHeight() + t(this.f798m));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f798m.getMeasuredState());
        }
        if (O(this.f794i)) {
            iMax4 += E(this.f794i, i2, iMax4, i3, 0, iArr);
            iMax = Math.max(iMax, this.f794i.getMeasuredHeight() + t(this.f794i));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f794i.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (((g) childAt.getLayoutParams()).f821b == 0 && O(childAt)) {
                iMax4 += E(childAt, i2, iMax4, i3, 0, iArr);
                iMax = Math.max(iMax, childAt.getMeasuredHeight() + t(childAt));
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt.getMeasuredState());
            }
        }
        int i6 = this.f807v + this.f808w;
        int i7 = this.f805t + this.f806u;
        if (O(this.f791f)) {
            E(this.f791f, i2, iMax4 + i7, i3, i6, iArr);
            int measuredWidth3 = this.f791f.getMeasuredWidth() + s(this.f791f);
            measuredHeight = this.f791f.getMeasuredHeight() + t(this.f791f);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f791f.getMeasuredState());
            iMax2 = measuredWidth3;
        } else {
            iCombineMeasuredStates2 = iCombineMeasuredStates;
            iMax2 = 0;
            measuredHeight = 0;
        }
        if (O(this.f792g)) {
            iMax2 = Math.max(iMax2, E(this.f792g, i2, iMax4 + i7, i3, measuredHeight + i6, iArr));
            measuredHeight += this.f792g.getMeasuredHeight() + t(this.f792g);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, this.f792g.getMeasuredState());
        }
        int iMax5 = Math.max(iMax, measuredHeight);
        setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax4 + iMax2 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i2, (-16777216) & iCombineMeasuredStates2), N() ? 0 : View.resolveSizeAndState(Math.max(iMax5 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i3, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        ActionMenuView actionMenuView = this.f790e;
        androidx.appcompat.view.menu.e eVarJ = actionMenuView != null ? actionMenuView.J() : null;
        int i2 = savedState.f812g;
        if (i2 != 0 && this.Q != null && eVarJ != null && (menuItemFindItem = eVarJ.findItem(i2)) != null) {
            menuItemFindItem.expandActionView();
        }
        if (savedState.f813h) {
            H();
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i2) {
        super.onRtlPropertiesChanged(i2);
        h();
        this.f809x.f(i2 == 1);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        androidx.appcompat.view.menu.g gVar;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        f fVar = this.Q;
        if (fVar != null && (gVar = fVar.f819f) != null) {
            savedState.f812g = gVar.getItemId();
        }
        savedState.f813h = B();
        return savedState;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.F = false;
        }
        if (!this.F) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.F = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.F = false;
        }
        return true;
    }

    public void setBackInvokedCallbackEnabled(boolean z2) {
        if (this.W != z2) {
            this.W = z2;
            Q();
        }
    }

    public void setCollapseContentDescription(@StringRes int i2) {
        setCollapseContentDescription(i2 != 0 ? getContext().getText(i2) : null);
    }

    public void setCollapseIcon(@DrawableRes int i2) {
        setCollapseIcon(e.a.b(getContext(), i2));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setCollapsible(boolean z2) {
        this.T = z2;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i2) {
        if (i2 < 0) {
            i2 = Target.SIZE_ORIGINAL;
        }
        if (i2 != this.f811z) {
            this.f811z = i2;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i2) {
        if (i2 < 0) {
            i2 = Target.SIZE_ORIGINAL;
        }
        if (i2 != this.f810y) {
            this.f810y = i2;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(@DrawableRes int i2) {
        setLogo(e.a.b(getContext(), i2));
    }

    public void setLogoDescription(@StringRes int i2) {
        setLogoDescription(getContext().getText(i2));
    }

    public void setNavigationContentDescription(@StringRes int i2) {
        setNavigationContentDescription(i2 != 0 ? getContext().getText(i2) : null);
    }

    public void setNavigationIcon(@DrawableRes int i2) {
        setNavigationIcon(e.a.b(getContext(), i2));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        l();
        this.f793h.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(h hVar) {
        this.M = hVar;
    }

    public void setOverflowIcon(@Nullable Drawable drawable) {
        j();
        this.f790e.setOverflowIcon(drawable);
    }

    public void setPopupTheme(@StyleRes int i2) {
        if (this.f800o != i2) {
            this.f800o = i2;
            if (i2 == 0) {
                this.f799n = getContext();
            } else {
                this.f799n = new ContextThemeWrapper(getContext(), i2);
            }
        }
    }

    public void setSubtitle(@StringRes int i2) {
        setSubtitle(getContext().getText(i2));
    }

    public void setSubtitleTextColor(@ColorInt int i2) {
        setSubtitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setTitle(@StringRes int i2) {
        setTitle(getContext().getText(i2));
    }

    public void setTitleMarginBottom(int i2) {
        this.f808w = i2;
        requestLayout();
    }

    public void setTitleMarginEnd(int i2) {
        this.f806u = i2;
        requestLayout();
    }

    public void setTitleMarginStart(int i2) {
        this.f805t = i2;
        requestLayout();
    }

    public void setTitleMarginTop(int i2) {
        this.f807v = i2;
        requestLayout();
    }

    public void setTitleTextColor(@ColorInt int i2) {
        setTitleTextColor(ColorStateList.valueOf(i2));
    }

    public boolean v() {
        f fVar = this.Q;
        return (fVar == null || fVar.f819f == null) ? false : true;
    }

    public boolean w() {
        ActionMenuView actionMenuView = this.f790e;
        return actionMenuView != null && actionMenuView.D();
    }

    public void x(@MenuRes int i2) {
        getMenuInflater().inflate(i2, getMenu());
    }

    @MainThread
    public void y() {
        Iterator<MenuItem> it = this.L.iterator();
        while (it.hasNext()) {
            getMenu().removeItem(it.next().getItemId());
        }
        G();
    }

    public static class g extends ActionBar.a {

        /* renamed from: b, reason: collision with root package name */
        int f821b;

        public g(@NonNull Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f821b = 0;
        }

        void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
        }

        public g(int i2, int i3) {
            super(i2, i3);
            this.f821b = 0;
            this.f80a = 8388627;
        }

        public g(g gVar) {
            super((ActionBar.a) gVar);
            this.f821b = 0;
            this.f821b = gVar.f821b;
        }

        public g(ActionBar.a aVar) {
            super(aVar);
            this.f821b = 0;
        }

        public g(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f821b = 0;
            a(marginLayoutParams);
        }

        public g(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f821b = 0;
        }
    }

    public Toolbar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.A = 8388627;
        this.H = new ArrayList<>();
        this.I = new ArrayList<>();
        this.J = new int[2];
        this.K = new androidx.core.view.j(new Runnable() { // from class: androidx.appcompat.widget.l2
            @Override // java.lang.Runnable
            public final void run() {
                this.f1007e.y();
            }
        });
        this.L = new ArrayList<>();
        this.N = new a();
        this.f789a0 = new b();
        Context context2 = getContext();
        int[] iArr = R$styleable.Toolbar;
        k2 k2VarU = k2.u(context2, attributeSet, iArr, i2, 0);
        ViewCompat.M(this, context, iArr, attributeSet, k2VarU.q(), i2, 0);
        this.f801p = k2VarU.m(R$styleable.Toolbar_titleTextAppearance, 0);
        this.f802q = k2VarU.m(R$styleable.Toolbar_subtitleTextAppearance, 0);
        this.A = k2VarU.k(R$styleable.Toolbar_android_gravity, this.A);
        this.f803r = k2VarU.k(R$styleable.Toolbar_buttonGravity, 48);
        int iD = k2VarU.d(R$styleable.Toolbar_titleMargin, 0);
        int i3 = R$styleable.Toolbar_titleMargins;
        iD = k2VarU.r(i3) ? k2VarU.d(i3, iD) : iD;
        this.f808w = iD;
        this.f807v = iD;
        this.f806u = iD;
        this.f805t = iD;
        int iD2 = k2VarU.d(R$styleable.Toolbar_titleMarginStart, -1);
        if (iD2 >= 0) {
            this.f805t = iD2;
        }
        int iD3 = k2VarU.d(R$styleable.Toolbar_titleMarginEnd, -1);
        if (iD3 >= 0) {
            this.f806u = iD3;
        }
        int iD4 = k2VarU.d(R$styleable.Toolbar_titleMarginTop, -1);
        if (iD4 >= 0) {
            this.f807v = iD4;
        }
        int iD5 = k2VarU.d(R$styleable.Toolbar_titleMarginBottom, -1);
        if (iD5 >= 0) {
            this.f808w = iD5;
        }
        this.f804s = k2VarU.e(R$styleable.Toolbar_maxButtonHeight, -1);
        int iD6 = k2VarU.d(R$styleable.Toolbar_contentInsetStart, Target.SIZE_ORIGINAL);
        int iD7 = k2VarU.d(R$styleable.Toolbar_contentInsetEnd, Target.SIZE_ORIGINAL);
        int iE = k2VarU.e(R$styleable.Toolbar_contentInsetLeft, 0);
        int iE2 = k2VarU.e(R$styleable.Toolbar_contentInsetRight, 0);
        h();
        this.f809x.e(iE, iE2);
        if (iD6 != Integer.MIN_VALUE || iD7 != Integer.MIN_VALUE) {
            this.f809x.g(iD6, iD7);
        }
        this.f810y = k2VarU.d(R$styleable.Toolbar_contentInsetStartWithNavigation, Target.SIZE_ORIGINAL);
        this.f811z = k2VarU.d(R$styleable.Toolbar_contentInsetEndWithActions, Target.SIZE_ORIGINAL);
        this.f795j = k2VarU.f(R$styleable.Toolbar_collapseIcon);
        this.f796k = k2VarU.o(R$styleable.Toolbar_collapseContentDescription);
        CharSequence charSequenceO = k2VarU.o(R$styleable.Toolbar_title);
        if (!TextUtils.isEmpty(charSequenceO)) {
            setTitle(charSequenceO);
        }
        CharSequence charSequenceO2 = k2VarU.o(R$styleable.Toolbar_subtitle);
        if (!TextUtils.isEmpty(charSequenceO2)) {
            setSubtitle(charSequenceO2);
        }
        this.f799n = getContext();
        setPopupTheme(k2VarU.m(R$styleable.Toolbar_popupTheme, 0));
        Drawable drawableF = k2VarU.f(R$styleable.Toolbar_navigationIcon);
        if (drawableF != null) {
            setNavigationIcon(drawableF);
        }
        CharSequence charSequenceO3 = k2VarU.o(R$styleable.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(charSequenceO3)) {
            setNavigationContentDescription(charSequenceO3);
        }
        Drawable drawableF2 = k2VarU.f(R$styleable.Toolbar_logo);
        if (drawableF2 != null) {
            setLogo(drawableF2);
        }
        CharSequence charSequenceO4 = k2VarU.o(R$styleable.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(charSequenceO4)) {
            setLogoDescription(charSequenceO4);
        }
        int i4 = R$styleable.Toolbar_titleTextColor;
        if (k2VarU.r(i4)) {
            setTitleTextColor(k2VarU.c(i4));
        }
        int i5 = R$styleable.Toolbar_subtitleTextColor;
        if (k2VarU.r(i5)) {
            setSubtitleTextColor(k2VarU.c(i5));
        }
        int i6 = R$styleable.Toolbar_menu;
        if (k2VarU.r(i6)) {
            x(k2VarU.m(i6, 0));
        }
        k2VarU.v();
    }

    public void setCollapseContentDescription(@Nullable CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            g();
        }
        ImageButton imageButton = this.f797l;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(@Nullable Drawable drawable) {
        if (drawable != null) {
            g();
            this.f797l.setImageDrawable(drawable);
        } else {
            ImageButton imageButton = this.f797l;
            if (imageButton != null) {
                imageButton.setImageDrawable(this.f795j);
            }
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            i();
            if (!z(this.f794i)) {
                c(this.f794i, true);
            }
        } else {
            ImageView imageView = this.f794i;
            if (imageView != null && z(imageView)) {
                removeView(this.f794i);
                this.I.remove(this.f794i);
            }
        }
        ImageView imageView2 = this.f794i;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            i();
        }
        ImageView imageView = this.f794i;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(@Nullable CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            l();
        }
        ImageButton imageButton = this.f793h;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
            p2.a(this.f793h, charSequence);
        }
    }

    public void setNavigationIcon(@Nullable Drawable drawable) {
        if (drawable != null) {
            l();
            if (!z(this.f793h)) {
                c(this.f793h, true);
            }
        } else {
            ImageButton imageButton = this.f793h;
            if (imageButton != null && z(imageButton)) {
                removeView(this.f793h);
                this.I.remove(this.f793h);
            }
        }
        ImageButton imageButton2 = this.f793h;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f792g;
            if (textView != null && z(textView)) {
                removeView(this.f792g);
                this.I.remove(this.f792g);
            }
        } else {
            if (this.f792g == null) {
                Context context = getContext();
                c1 c1Var = new c1(context);
                this.f792g = c1Var;
                c1Var.setSingleLine();
                this.f792g.setEllipsize(TextUtils.TruncateAt.END);
                int i2 = this.f802q;
                if (i2 != 0) {
                    this.f792g.setTextAppearance(context, i2);
                }
                ColorStateList colorStateList = this.E;
                if (colorStateList != null) {
                    this.f792g.setTextColor(colorStateList);
                }
            }
            if (!z(this.f792g)) {
                c(this.f792g, true);
            }
        }
        TextView textView2 = this.f792g;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.C = charSequence;
    }

    public void setSubtitleTextColor(@NonNull ColorStateList colorStateList) {
        this.E = colorStateList;
        TextView textView = this.f792g;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f791f;
            if (textView != null && z(textView)) {
                removeView(this.f791f);
                this.I.remove(this.f791f);
            }
        } else {
            if (this.f791f == null) {
                Context context = getContext();
                c1 c1Var = new c1(context);
                this.f791f = c1Var;
                c1Var.setSingleLine();
                this.f791f.setEllipsize(TextUtils.TruncateAt.END);
                int i2 = this.f801p;
                if (i2 != 0) {
                    this.f791f.setTextAppearance(context, i2);
                }
                ColorStateList colorStateList = this.D;
                if (colorStateList != null) {
                    this.f791f.setTextColor(colorStateList);
                }
            }
            if (!z(this.f791f)) {
                c(this.f791f, true);
            }
        }
        TextView textView2 = this.f791f;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.B = charSequence;
    }

    public void setTitleTextColor(@NonNull ColorStateList colorStateList) {
        this.D = colorStateList;
        TextView textView = this.f791f;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: g, reason: collision with root package name */
        int f812g;

        /* renamed from: h, reason: collision with root package name */
        boolean f813h;

        class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f812g = parcel.readInt();
            this.f813h = parcel.readInt() != 0;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f812g);
            parcel.writeInt(this.f813h ? 1 : 0);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }
}
