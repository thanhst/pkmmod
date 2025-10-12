package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.appcompat.R$attr;
import androidx.core.os.BuildCompat;
import androidx.core.view.y2;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: DropDownListView.java */
/* loaded from: classes.dex */
class n1 extends ListView {

    /* renamed from: e, reason: collision with root package name */
    private final Rect f1018e;

    /* renamed from: f, reason: collision with root package name */
    private int f1019f;

    /* renamed from: g, reason: collision with root package name */
    private int f1020g;

    /* renamed from: h, reason: collision with root package name */
    private int f1021h;

    /* renamed from: i, reason: collision with root package name */
    private int f1022i;

    /* renamed from: j, reason: collision with root package name */
    private int f1023j;

    /* renamed from: k, reason: collision with root package name */
    private d f1024k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f1025l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f1026m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f1027n;

    /* renamed from: o, reason: collision with root package name */
    private y2 f1028o;

    /* renamed from: p, reason: collision with root package name */
    private androidx.core.widget.t f1029p;

    /* renamed from: q, reason: collision with root package name */
    f f1030q;

    /* compiled from: DropDownListView.java */
    @RequiresApi(21)
    static class a {
        @DoNotInline
        static void a(View view, float f2, float f3) {
            view.drawableHotspotChanged(f2, f3);
        }
    }

    /* compiled from: DropDownListView.java */
    @RequiresApi(30)
    static class b {

        /* renamed from: a, reason: collision with root package name */
        private static Method f1031a;

        /* renamed from: b, reason: collision with root package name */
        private static Method f1032b;

        /* renamed from: c, reason: collision with root package name */
        private static Method f1033c;

        /* renamed from: d, reason: collision with root package name */
        private static boolean f1034d;

        static {
            try {
                Class cls = Integer.TYPE;
                Class cls2 = Float.TYPE;
                Method declaredMethod = AbsListView.class.getDeclaredMethod("positionSelector", cls, View.class, Boolean.TYPE, cls2, cls2);
                f1031a = declaredMethod;
                declaredMethod.setAccessible(true);
                Method declaredMethod2 = AdapterView.class.getDeclaredMethod("setSelectedPositionInt", cls);
                f1032b = declaredMethod2;
                declaredMethod2.setAccessible(true);
                Method declaredMethod3 = AdapterView.class.getDeclaredMethod("setNextSelectedPositionInt", cls);
                f1033c = declaredMethod3;
                declaredMethod3.setAccessible(true);
                f1034d = true;
            } catch (NoSuchMethodException e2) {
                e2.printStackTrace();
            }
        }

        static boolean a() {
            return f1034d;
        }

        @SuppressLint({"BanUncheckedReflection"})
        static void b(n1 n1Var, int i2, View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            try {
                f1031a.invoke(n1Var, Integer.valueOf(i2), view, Boolean.FALSE, -1, -1);
                f1032b.invoke(n1Var, Integer.valueOf(i2));
                f1033c.invoke(n1Var, Integer.valueOf(i2));
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        }
    }

    /* compiled from: DropDownListView.java */
    @RequiresApi(33)
    static class c {
        @DoNotInline
        static boolean a(AbsListView absListView) {
            return absListView.isSelectedChildViewEnabled();
        }

        @DoNotInline
        static void b(AbsListView absListView, boolean z2) {
            absListView.setSelectedChildViewEnabled(z2);
        }
    }

    /* compiled from: DropDownListView.java */
    private static class d extends f.f {

        /* renamed from: f, reason: collision with root package name */
        private boolean f1035f;

        d(Drawable drawable) {
            super(drawable);
            this.f1035f = true;
        }

        void b(boolean z2) {
            this.f1035f = z2;
        }

        @Override // f.f, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.f1035f) {
                super.draw(canvas);
            }
        }

        @Override // f.f, android.graphics.drawable.Drawable
        public void setHotspot(float f2, float f3) {
            if (this.f1035f) {
                super.setHotspot(f2, f3);
            }
        }

        @Override // f.f, android.graphics.drawable.Drawable
        public void setHotspotBounds(int i2, int i3, int i4, int i5) {
            if (this.f1035f) {
                super.setHotspotBounds(i2, i3, i4, i5);
            }
        }

        @Override // f.f, android.graphics.drawable.Drawable
        public boolean setState(int[] iArr) {
            if (this.f1035f) {
                return super.setState(iArr);
            }
            return false;
        }

        @Override // f.f, android.graphics.drawable.Drawable
        public boolean setVisible(boolean z2, boolean z3) {
            if (this.f1035f) {
                return super.setVisible(z2, z3);
            }
            return false;
        }
    }

    /* compiled from: DropDownListView.java */
    static class e {

        /* renamed from: a, reason: collision with root package name */
        private static final Field f1036a;

        static {
            Field declaredField = null;
            try {
                declaredField = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                e2.printStackTrace();
            }
            f1036a = declaredField;
        }

        static boolean a(AbsListView absListView) {
            Field field = f1036a;
            if (field == null) {
                return false;
            }
            try {
                return field.getBoolean(absListView);
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return false;
            }
        }

        static void b(AbsListView absListView, boolean z2) throws IllegalAccessException, IllegalArgumentException {
            Field field = f1036a;
            if (field != null) {
                try {
                    field.set(absListView, Boolean.valueOf(z2));
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* compiled from: DropDownListView.java */
    private class f implements Runnable {
        f() {
        }

        public void a() {
            n1 n1Var = n1.this;
            n1Var.f1030q = null;
            n1Var.removeCallbacks(this);
        }

        public void b() {
            n1.this.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            n1 n1Var = n1.this;
            n1Var.f1030q = null;
            n1Var.drawableStateChanged();
        }
    }

    n1(@NonNull Context context, boolean z2) {
        super(context, null, R$attr.dropDownListViewStyle);
        this.f1018e = new Rect();
        this.f1019f = 0;
        this.f1020g = 0;
        this.f1021h = 0;
        this.f1022i = 0;
        this.f1026m = z2;
        setCacheColorHint(0);
    }

    private void a() {
        this.f1027n = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f1023j - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        y2 y2Var = this.f1028o;
        if (y2Var != null) {
            y2Var.c();
            this.f1028o = null;
        }
    }

    private void b(View view, int i2) {
        performItemClick(view, i2, getItemIdAtPosition(i2));
    }

    private void c(Canvas canvas) {
        Drawable selector;
        if (this.f1018e.isEmpty() || (selector = getSelector()) == null) {
            return;
        }
        selector.setBounds(this.f1018e);
        selector.draw(canvas);
    }

    private void f(int i2, View view) throws IllegalAccessException, IllegalArgumentException {
        Rect rect = this.f1018e;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f1019f;
        rect.top -= this.f1020g;
        rect.right += this.f1021h;
        rect.bottom += this.f1022i;
        boolean zJ = j();
        if (view.isEnabled() != zJ) {
            k(!zJ);
            if (i2 != -1) {
                refreshDrawableState();
            }
        }
    }

    private void g(int i2, View view) throws IllegalAccessException, IllegalArgumentException {
        Drawable selector = getSelector();
        boolean z2 = (selector == null || i2 == -1) ? false : true;
        if (z2) {
            selector.setVisible(false, false);
        }
        f(i2, view);
        if (z2) {
            Rect rect = this.f1018e;
            float fExactCenterX = rect.exactCenterX();
            float fExactCenterY = rect.exactCenterY();
            selector.setVisible(getVisibility() == 0, false);
            androidx.core.graphics.drawable.a.j(selector, fExactCenterX, fExactCenterY);
        }
    }

    private void h(int i2, View view, float f2, float f3) throws IllegalAccessException, IllegalArgumentException {
        g(i2, view);
        Drawable selector = getSelector();
        if (selector == null || i2 == -1) {
            return;
        }
        androidx.core.graphics.drawable.a.j(selector, f2, f3);
    }

    private void i(View view, int i2, float f2, float f3) throws IllegalAccessException, IllegalArgumentException {
        View childAt;
        this.f1027n = true;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 21) {
            a.a(this, f2, f3);
        }
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        int i4 = this.f1023j;
        if (i4 != -1 && (childAt = getChildAt(i4 - getFirstVisiblePosition())) != null && childAt != view && childAt.isPressed()) {
            childAt.setPressed(false);
        }
        this.f1023j = i2;
        float left = f2 - view.getLeft();
        float top = f3 - view.getTop();
        if (i3 >= 21) {
            a.a(view, left, top);
        }
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        h(i2, view, f2, f3);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    private boolean j() {
        return BuildCompat.d() ? c.a(this) : e.a(this);
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    private void k(boolean z2) throws IllegalAccessException, IllegalArgumentException {
        if (BuildCompat.d()) {
            c.b(this, z2);
        } else {
            e.b(this, z2);
        }
    }

    private boolean l() {
        return this.f1027n;
    }

    private void m() {
        Drawable selector = getSelector();
        if (selector != null && l() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    private void setSelectorEnabled(boolean z2) {
        d dVar = this.f1024k;
        if (dVar != null) {
            dVar.b(z2);
        }
    }

    public int d(int i2, int i3, int i4, int i5, int i6) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int measuredHeight = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        View view = null;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i7 < count) {
            int itemViewType = adapter.getItemViewType(i7);
            if (itemViewType != i8) {
                view = null;
                i8 = itemViewType;
            }
            view = adapter.getView(i7, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i10 = layoutParams.height;
            view.measure(i2, i10 > 0 ? View.MeasureSpec.makeMeasureSpec(i10, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            if (i7 > 0) {
                measuredHeight += dividerHeight;
            }
            measuredHeight += view.getMeasuredHeight();
            if (measuredHeight >= i5) {
                return (i6 < 0 || i7 <= i6 || i9 <= 0 || measuredHeight == i5) ? i5 : i9;
            }
            if (i6 >= 0 && i7 >= i6) {
                i9 = measuredHeight;
            }
            i7++;
        }
        return measuredHeight;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        c(canvas);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.f1030q != null) {
            return;
        }
        super.drawableStateChanged();
        setSelectorEnabled(true);
        m();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean e(android.view.MotionEvent r8, int r9) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        /*
            r7 = this;
            int r0 = r8.getActionMasked()
            r1 = 0
            r2 = 1
            if (r0 == r2) goto L16
            r3 = 2
            if (r0 == r3) goto L14
            r9 = 3
            if (r0 == r9) goto L11
        Le:
            r9 = 0
            r3 = 1
            goto L46
        L11:
            r9 = 0
            r3 = 0
            goto L46
        L14:
            r3 = 1
            goto L17
        L16:
            r3 = 0
        L17:
            int r9 = r8.findPointerIndex(r9)
            if (r9 >= 0) goto L1e
            goto L11
        L1e:
            float r4 = r8.getX(r9)
            int r4 = (int) r4
            float r9 = r8.getY(r9)
            int r9 = (int) r9
            int r5 = r7.pointToPosition(r4, r9)
            r6 = -1
            if (r5 != r6) goto L31
            r9 = 1
            goto L46
        L31:
            int r3 = r7.getFirstVisiblePosition()
            int r3 = r5 - r3
            android.view.View r3 = r7.getChildAt(r3)
            float r4 = (float) r4
            float r9 = (float) r9
            r7.i(r3, r5, r4, r9)
            if (r0 != r2) goto Le
            r7.b(r3, r5)
            goto Le
        L46:
            if (r3 == 0) goto L4a
            if (r9 == 0) goto L4d
        L4a:
            r7.a()
        L4d:
            if (r3 == 0) goto L65
            androidx.core.widget.t r9 = r7.f1029p
            if (r9 != 0) goto L5a
            androidx.core.widget.t r9 = new androidx.core.widget.t
            r9.<init>(r7)
            r7.f1029p = r9
        L5a:
            androidx.core.widget.t r9 = r7.f1029p
            r9.m(r2)
            androidx.core.widget.t r9 = r7.f1029p
            r9.onTouch(r7, r8)
            goto L6c
        L65:
            androidx.core.widget.t r8 = r7.f1029p
            if (r8 == 0) goto L6c
            r8.m(r1)
        L6c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.n1.e(android.view.MotionEvent, int):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        return this.f1026m || super.hasFocus();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.f1026m || super.hasWindowFocus();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.f1026m || super.isFocused();
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        return (this.f1026m && this.f1025l) || super.isInTouchMode();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.f1030q = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(@NonNull MotionEvent motionEvent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f1030q == null) {
            f fVar = new f();
            this.f1030q = fVar;
            fVar.b();
        }
        boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (iPointToPosition != -1 && iPointToPosition != getSelectedItemPosition()) {
                View childAt = getChildAt(iPointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    requestFocus();
                    if (i2 < 30 || !b.a()) {
                        setSelectionFromTop(iPointToPosition, childAt.getTop() - getTop());
                    } else {
                        b.b(this, iPointToPosition, childAt);
                    }
                }
                m();
            }
        } else {
            setSelection(-1);
        }
        return zOnHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f1023j = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        f fVar = this.f1030q;
        if (fVar != null) {
            fVar.a();
        }
        return super.onTouchEvent(motionEvent);
    }

    void setListSelectionHidden(boolean z2) {
        this.f1025l = z2;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        d dVar = drawable != null ? new d(drawable) : null;
        this.f1024k = dVar;
        super.setSelector(dVar);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f1019f = rect.left;
        this.f1020g = rect.top;
        this.f1021h = rect.right;
        this.f1022i = rect.bottom;
    }
}
