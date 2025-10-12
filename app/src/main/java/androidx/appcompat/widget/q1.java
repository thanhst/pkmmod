package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.annotation.AttrRes;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;
import com.bumptech.glide.request.target.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: ListPopupWindow.java */
/* loaded from: classes.dex */
public class q1 implements androidx.appcompat.view.menu.n {
    private static Method K;
    private static Method L;
    private static Method M;
    final i A;
    private final h B;
    private final g C;
    private final e D;
    private Runnable E;
    final Handler F;
    private final Rect G;
    private Rect H;
    private boolean I;
    PopupWindow J;

    /* renamed from: e, reason: collision with root package name */
    private Context f1080e;

    /* renamed from: f, reason: collision with root package name */
    private ListAdapter f1081f;

    /* renamed from: g, reason: collision with root package name */
    n1 f1082g;

    /* renamed from: h, reason: collision with root package name */
    private int f1083h;

    /* renamed from: i, reason: collision with root package name */
    private int f1084i;

    /* renamed from: j, reason: collision with root package name */
    private int f1085j;

    /* renamed from: k, reason: collision with root package name */
    private int f1086k;

    /* renamed from: l, reason: collision with root package name */
    private int f1087l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f1088m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f1089n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f1090o;

    /* renamed from: p, reason: collision with root package name */
    private int f1091p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f1092q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f1093r;

    /* renamed from: s, reason: collision with root package name */
    int f1094s;

    /* renamed from: t, reason: collision with root package name */
    private View f1095t;

    /* renamed from: u, reason: collision with root package name */
    private int f1096u;

    /* renamed from: v, reason: collision with root package name */
    private DataSetObserver f1097v;

    /* renamed from: w, reason: collision with root package name */
    private View f1098w;

    /* renamed from: x, reason: collision with root package name */
    private Drawable f1099x;

    /* renamed from: y, reason: collision with root package name */
    private AdapterView.OnItemClickListener f1100y;

    /* renamed from: z, reason: collision with root package name */
    private AdapterView.OnItemSelectedListener f1101z;

    /* compiled from: ListPopupWindow.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View viewT = q1.this.t();
            if (viewT == null || viewT.getWindowToken() == null) {
                return;
            }
            q1.this.d();
        }
    }

    /* compiled from: ListPopupWindow.java */
    class b implements AdapterView.OnItemSelectedListener {
        b() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
            n1 n1Var;
            if (i2 == -1 || (n1Var = q1.this.f1082g) == null) {
                return;
            }
            n1Var.setListSelectionHidden(false);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* compiled from: ListPopupWindow.java */
    @RequiresApi(24)
    static class c {
        @DoNotInline
        static int a(PopupWindow popupWindow, View view, int i2, boolean z2) {
            return popupWindow.getMaxAvailableHeight(view, i2, z2);
        }
    }

    /* compiled from: ListPopupWindow.java */
    @RequiresApi(29)
    static class d {
        @DoNotInline
        static void a(PopupWindow popupWindow, Rect rect) {
            popupWindow.setEpicenterBounds(rect);
        }

        @DoNotInline
        static void b(PopupWindow popupWindow, boolean z2) {
            popupWindow.setIsClippedToScreen(z2);
        }
    }

    /* compiled from: ListPopupWindow.java */
    private class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            q1.this.r();
        }
    }

    /* compiled from: ListPopupWindow.java */
    private class f extends DataSetObserver {
        f() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (q1.this.b()) {
                q1.this.d();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            q1.this.dismiss();
        }
    }

    /* compiled from: ListPopupWindow.java */
    private class g implements AbsListView.OnScrollListener {
        g() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            if (i2 != 1 || q1.this.w() || q1.this.J.getContentView() == null) {
                return;
            }
            q1 q1Var = q1.this;
            q1Var.F.removeCallbacks(q1Var.A);
            q1.this.A.run();
        }
    }

    /* compiled from: ListPopupWindow.java */
    private class h implements View.OnTouchListener {
        h() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x2 = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = q1.this.J) != null && popupWindow.isShowing() && x2 >= 0 && x2 < q1.this.J.getWidth() && y2 >= 0 && y2 < q1.this.J.getHeight()) {
                q1 q1Var = q1.this;
                q1Var.F.postDelayed(q1Var.A, 250L);
                return false;
            }
            if (action != 1) {
                return false;
            }
            q1 q1Var2 = q1.this;
            q1Var2.F.removeCallbacks(q1Var2.A);
            return false;
        }
    }

    /* compiled from: ListPopupWindow.java */
    private class i implements Runnable {
        i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            n1 n1Var = q1.this.f1082g;
            if (n1Var == null || !ViewCompat.A(n1Var) || q1.this.f1082g.getCount() <= q1.this.f1082g.getChildCount()) {
                return;
            }
            int childCount = q1.this.f1082g.getChildCount();
            q1 q1Var = q1.this;
            if (childCount <= q1Var.f1094s) {
                q1Var.J.setInputMethodMode(2);
                q1.this.d();
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                K = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                M = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                L = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
            } catch (NoSuchMethodException unused3) {
                Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public q1(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2) {
        this(context, attributeSet, i2, 0);
    }

    private void J(boolean z2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (Build.VERSION.SDK_INT > 28) {
            d.b(this.J, z2);
            return;
        }
        Method method = K;
        if (method != null) {
            try {
                method.invoke(this.J, Boolean.valueOf(z2));
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    private int q() {
        int measuredHeight;
        int i2;
        int iMakeMeasureSpec;
        int i3;
        if (this.f1082g == null) {
            Context context = this.f1080e;
            this.E = new a();
            n1 n1VarS = s(context, !this.I);
            this.f1082g = n1VarS;
            Drawable drawable = this.f1099x;
            if (drawable != null) {
                n1VarS.setSelector(drawable);
            }
            this.f1082g.setAdapter(this.f1081f);
            this.f1082g.setOnItemClickListener(this.f1100y);
            this.f1082g.setFocusable(true);
            this.f1082g.setFocusableInTouchMode(true);
            this.f1082g.setOnItemSelectedListener(new b());
            this.f1082g.setOnScrollListener(this.C);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f1101z;
            if (onItemSelectedListener != null) {
                this.f1082g.setOnItemSelectedListener(onItemSelectedListener);
            }
            View view = this.f1082g;
            View view2 = this.f1095t;
            if (view2 != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i4 = this.f1096u;
                if (i4 == 0) {
                    linearLayout.addView(view2);
                    linearLayout.addView(view, layoutParams);
                } else if (i4 != 1) {
                    Log.e("ListPopupWindow", "Invalid hint position " + this.f1096u);
                } else {
                    linearLayout.addView(view, layoutParams);
                    linearLayout.addView(view2);
                }
                int i5 = this.f1084i;
                if (i5 >= 0) {
                    i3 = Target.SIZE_ORIGINAL;
                } else {
                    i5 = 0;
                    i3 = 0;
                }
                view2.measure(View.MeasureSpec.makeMeasureSpec(i5, i3), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                measuredHeight = view2.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                view = linearLayout;
            } else {
                measuredHeight = 0;
            }
            this.J.setContentView(view);
        } else {
            View view3 = this.f1095t;
            if (view3 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                measuredHeight = view3.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                measuredHeight = 0;
            }
        }
        Drawable background = this.J.getBackground();
        if (background != null) {
            background.getPadding(this.G);
            Rect rect = this.G;
            int i6 = rect.top;
            i2 = rect.bottom + i6;
            if (!this.f1088m) {
                this.f1086k = -i6;
            }
        } else {
            this.G.setEmpty();
            i2 = 0;
        }
        int iU = u(t(), this.f1086k, this.J.getInputMethodMode() == 2);
        if (this.f1092q || this.f1083h == -1) {
            return iU + i2;
        }
        int i7 = this.f1084i;
        if (i7 == -2) {
            int i8 = this.f1080e.getResources().getDisplayMetrics().widthPixels;
            Rect rect2 = this.G;
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i8 - (rect2.left + rect2.right), Target.SIZE_ORIGINAL);
        } else if (i7 != -1) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
        } else {
            int i9 = this.f1080e.getResources().getDisplayMetrics().widthPixels;
            Rect rect3 = this.G;
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i9 - (rect3.left + rect3.right), 1073741824);
        }
        int iD = this.f1082g.d(iMakeMeasureSpec, 0, -1, iU - measuredHeight, -1);
        if (iD > 0) {
            measuredHeight += i2 + this.f1082g.getPaddingTop() + this.f1082g.getPaddingBottom();
        }
        return iD + measuredHeight;
    }

    private int u(View view, int i2, boolean z2) {
        if (Build.VERSION.SDK_INT > 23) {
            return c.a(this.J, view, i2, z2);
        }
        Method method = L;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.J, view, Integer.valueOf(i2), Boolean.valueOf(z2))).intValue();
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.J.getMaxAvailableHeight(view, i2);
    }

    private void y() {
        View view = this.f1095t;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f1095t);
            }
        }
    }

    public void A(@StyleRes int i2) {
        this.J.setAnimationStyle(i2);
    }

    public void B(int i2) {
        Drawable background = this.J.getBackground();
        if (background == null) {
            M(i2);
            return;
        }
        background.getPadding(this.G);
        Rect rect = this.G;
        this.f1084i = rect.left + rect.right + i2;
    }

    public void C(int i2) {
        this.f1091p = i2;
    }

    public void D(@Nullable Rect rect) {
        this.H = rect != null ? new Rect(rect) : null;
    }

    public void E(int i2) {
        this.J.setInputMethodMode(i2);
    }

    public void F(boolean z2) {
        this.I = z2;
        this.J.setFocusable(z2);
    }

    public void G(@Nullable PopupWindow.OnDismissListener onDismissListener) {
        this.J.setOnDismissListener(onDismissListener);
    }

    public void H(@Nullable AdapterView.OnItemClickListener onItemClickListener) {
        this.f1100y = onItemClickListener;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void I(boolean z2) {
        this.f1090o = true;
        this.f1089n = z2;
    }

    public void K(int i2) {
        this.f1096u = i2;
    }

    public void L(int i2) {
        n1 n1Var = this.f1082g;
        if (!b() || n1Var == null) {
            return;
        }
        n1Var.setListSelectionHidden(false);
        n1Var.setSelection(i2);
        if (n1Var.getChoiceMode() != 0) {
            n1Var.setItemChecked(i2, true);
        }
    }

    public void M(int i2) {
        this.f1084i = i2;
    }

    public int a() {
        return this.f1085j;
    }

    @Override // androidx.appcompat.view.menu.n
    public boolean b() {
        return this.J.isShowing();
    }

    @Override // androidx.appcompat.view.menu.n
    public void d() {
        int iQ = q();
        boolean zW = w();
        androidx.core.widget.w.b(this.J, this.f1087l);
        if (this.J.isShowing()) {
            if (ViewCompat.A(t())) {
                int width = this.f1084i;
                if (width == -1) {
                    width = -1;
                } else if (width == -2) {
                    width = t().getWidth();
                }
                int i2 = this.f1083h;
                if (i2 == -1) {
                    if (!zW) {
                        iQ = -1;
                    }
                    if (zW) {
                        this.J.setWidth(this.f1084i == -1 ? -1 : 0);
                        this.J.setHeight(0);
                    } else {
                        this.J.setWidth(this.f1084i == -1 ? -1 : 0);
                        this.J.setHeight(-1);
                    }
                } else if (i2 != -2) {
                    iQ = i2;
                }
                this.J.setOutsideTouchable((this.f1093r || this.f1092q) ? false : true);
                this.J.update(t(), this.f1085j, this.f1086k, width < 0 ? -1 : width, iQ < 0 ? -1 : iQ);
                return;
            }
            return;
        }
        int width2 = this.f1084i;
        if (width2 == -1) {
            width2 = -1;
        } else if (width2 == -2) {
            width2 = t().getWidth();
        }
        int i3 = this.f1083h;
        if (i3 == -1) {
            iQ = -1;
        } else if (i3 != -2) {
            iQ = i3;
        }
        this.J.setWidth(width2);
        this.J.setHeight(iQ);
        J(true);
        this.J.setOutsideTouchable((this.f1093r || this.f1092q) ? false : true);
        this.J.setTouchInterceptor(this.B);
        if (this.f1090o) {
            androidx.core.widget.w.a(this.J, this.f1089n);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = M;
            if (method != null) {
                try {
                    method.invoke(this.J, this.H);
                } catch (Exception e2) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e2);
                }
            }
        } else {
            d.a(this.J, this.H);
        }
        androidx.core.widget.w.c(this.J, t(), this.f1085j, this.f1086k, this.f1091p);
        this.f1082g.setSelection(-1);
        if (!this.I || this.f1082g.isInTouchMode()) {
            r();
        }
        if (this.I) {
            return;
        }
        this.F.post(this.D);
    }

    @Override // androidx.appcompat.view.menu.n
    public void dismiss() {
        this.J.dismiss();
        y();
        this.J.setContentView(null);
        this.f1082g = null;
        this.F.removeCallbacks(this.A);
    }

    @Nullable
    public Drawable f() {
        return this.J.getBackground();
    }

    @Override // androidx.appcompat.view.menu.n
    @Nullable
    public ListView g() {
        return this.f1082g;
    }

    public void i(@Nullable Drawable drawable) {
        this.J.setBackgroundDrawable(drawable);
    }

    public void j(int i2) {
        this.f1086k = i2;
        this.f1088m = true;
    }

    public void l(int i2) {
        this.f1085j = i2;
    }

    public int n() {
        if (this.f1088m) {
            return this.f1086k;
        }
        return 0;
    }

    public void p(@Nullable ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.f1097v;
        if (dataSetObserver == null) {
            this.f1097v = new f();
        } else {
            ListAdapter listAdapter2 = this.f1081f;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f1081f = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f1097v);
        }
        n1 n1Var = this.f1082g;
        if (n1Var != null) {
            n1Var.setAdapter(this.f1081f);
        }
    }

    public void r() {
        n1 n1Var = this.f1082g;
        if (n1Var != null) {
            n1Var.setListSelectionHidden(true);
            n1Var.requestLayout();
        }
    }

    @NonNull
    n1 s(Context context, boolean z2) {
        return new n1(context, z2);
    }

    @Nullable
    public View t() {
        return this.f1098w;
    }

    public int v() {
        return this.f1084i;
    }

    public boolean w() {
        return this.J.getInputMethodMode() == 2;
    }

    public boolean x() {
        return this.I;
    }

    public void z(@Nullable View view) {
        this.f1098w = view;
    }

    public q1(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        this.f1083h = -2;
        this.f1084i = -2;
        this.f1087l = 1002;
        this.f1091p = 0;
        this.f1092q = false;
        this.f1093r = false;
        this.f1094s = Integer.MAX_VALUE;
        this.f1096u = 0;
        this.A = new i();
        this.B = new h();
        this.C = new g();
        this.D = new e();
        this.G = new Rect();
        this.f1080e = context;
        this.F = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ListPopupWindow, i2, i3);
        this.f1085j = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        this.f1086k = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f1088m = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        s sVar = new s(context, attributeSet, i2, i3);
        this.J = sVar;
        sVar.setInputMethodMode(1);
    }
}
