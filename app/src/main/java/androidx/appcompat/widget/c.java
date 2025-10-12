package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.view.b;
import java.util.ArrayList;

/* compiled from: ActionMenuPresenter.java */
/* loaded from: classes.dex */
class c extends androidx.appcompat.view.menu.b implements b.a {
    private int A;
    private final SparseBooleanArray B;
    e C;
    a D;
    RunnableC0008c E;
    private b F;
    final f G;
    int H;

    /* renamed from: o, reason: collision with root package name */
    d f848o;

    /* renamed from: p, reason: collision with root package name */
    private Drawable f849p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f850q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f851r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f852s;

    /* renamed from: t, reason: collision with root package name */
    private int f853t;

    /* renamed from: u, reason: collision with root package name */
    private int f854u;

    /* renamed from: v, reason: collision with root package name */
    private int f855v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f856w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f857x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f858y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f859z;

    /* compiled from: ActionMenuPresenter.java */
    private class a extends androidx.appcompat.view.menu.j {
        public a(Context context, androidx.appcompat.view.menu.p pVar, View view) {
            super(context, pVar, view, false, R$attr.actionOverflowMenuStyle);
            if (!((androidx.appcompat.view.menu.g) pVar.getItem()).l()) {
                View view2 = c.this.f848o;
                f(view2 == null ? (View) ((androidx.appcompat.view.menu.b) c.this).f494m : view2);
            }
            j(c.this.G);
        }

        @Override // androidx.appcompat.view.menu.j
        protected void e() {
            c cVar = c.this;
            cVar.D = null;
            cVar.H = 0;
            super.e();
        }
    }

    /* compiled from: ActionMenuPresenter.java */
    private class b extends ActionMenuItemView.b {
        b() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.b
        public androidx.appcompat.view.menu.n a() {
            a aVar = c.this.D;
            if (aVar != null) {
                return aVar.c();
            }
            return null;
        }
    }

    /* compiled from: ActionMenuPresenter.java */
    /* renamed from: androidx.appcompat.widget.c$c, reason: collision with other inner class name */
    private class RunnableC0008c implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        private e f862e;

        public RunnableC0008c(e eVar) {
            this.f862e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((androidx.appcompat.view.menu.b) c.this).f488g != null) {
                ((androidx.appcompat.view.menu.b) c.this).f488g.d();
            }
            View view = (View) ((androidx.appcompat.view.menu.b) c.this).f494m;
            if (view != null && view.getWindowToken() != null && this.f862e.m()) {
                c.this.C = this.f862e;
            }
            c.this.E = null;
        }
    }

    /* compiled from: ActionMenuPresenter.java */
    private class d extends AppCompatImageView implements ActionMenuView.a {

        /* compiled from: ActionMenuPresenter.java */
        class a extends p1 {

            /* renamed from: n, reason: collision with root package name */
            final /* synthetic */ c f865n;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(View view, c cVar) {
                super(view);
                this.f865n = cVar;
            }

            @Override // androidx.appcompat.widget.p1
            public androidx.appcompat.view.menu.n b() {
                e eVar = c.this.C;
                if (eVar == null) {
                    return null;
                }
                return eVar.c();
            }

            @Override // androidx.appcompat.widget.p1
            public boolean c() {
                c.this.K();
                return true;
            }

            @Override // androidx.appcompat.widget.p1
            public boolean d() {
                c cVar = c.this;
                if (cVar.E != null) {
                    return false;
                }
                cVar.B();
                return true;
            }
        }

        public d(Context context) {
            super(context, null, R$attr.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            p2.a(this, getContentDescription());
            setOnTouchListener(new a(this, c.this));
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean b() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean c() {
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            c.this.K();
            return true;
        }

        @Override // android.widget.ImageView
        protected boolean setFrame(int i2, int i3, int i4, int i5) {
            boolean frame = super.setFrame(i2, i3, i4, i5);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int iMax = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                androidx.core.graphics.drawable.a.k(background, paddingLeft - iMax, paddingTop - iMax, paddingLeft + iMax, paddingTop + iMax);
            }
            return frame;
        }
    }

    /* compiled from: ActionMenuPresenter.java */
    private class e extends androidx.appcompat.view.menu.j {
        public e(Context context, androidx.appcompat.view.menu.e eVar, View view, boolean z2) {
            super(context, eVar, view, z2, R$attr.actionOverflowMenuStyle);
            h(8388613);
            j(c.this.G);
        }

        @Override // androidx.appcompat.view.menu.j
        protected void e() {
            if (((androidx.appcompat.view.menu.b) c.this).f488g != null) {
                ((androidx.appcompat.view.menu.b) c.this).f488g.close();
            }
            c.this.C = null;
            super.e();
        }
    }

    /* compiled from: ActionMenuPresenter.java */
    private class f implements k.a {
        f() {
        }

        @Override // androidx.appcompat.view.menu.k.a
        public void a(@NonNull androidx.appcompat.view.menu.e eVar, boolean z2) {
            if (eVar instanceof androidx.appcompat.view.menu.p) {
                eVar.D().e(false);
            }
            k.a aVarM = c.this.m();
            if (aVarM != null) {
                aVarM.a(eVar, z2);
            }
        }

        @Override // androidx.appcompat.view.menu.k.a
        public boolean b(@NonNull androidx.appcompat.view.menu.e eVar) {
            if (eVar == ((androidx.appcompat.view.menu.b) c.this).f488g) {
                return false;
            }
            c.this.H = ((androidx.appcompat.view.menu.p) eVar).getItem().getItemId();
            k.a aVarM = c.this.m();
            if (aVarM != null) {
                return aVarM.b(eVar);
            }
            return false;
        }
    }

    public c(Context context) {
        super(context, R$layout.abc_action_menu_layout, R$layout.abc_action_menu_item_layout);
        this.B = new SparseBooleanArray();
        this.G = new f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private View z(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f494m;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if ((childAt instanceof l.a) && ((l.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public Drawable A() {
        d dVar = this.f848o;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (this.f850q) {
            return this.f849p;
        }
        return null;
    }

    public boolean B() {
        Object obj;
        RunnableC0008c runnableC0008c = this.E;
        if (runnableC0008c != null && (obj = this.f494m) != null) {
            ((View) obj).removeCallbacks(runnableC0008c);
            this.E = null;
            return true;
        }
        e eVar = this.C;
        if (eVar == null) {
            return false;
        }
        eVar.b();
        return true;
    }

    public boolean C() {
        a aVar = this.D;
        if (aVar == null) {
            return false;
        }
        aVar.b();
        return true;
    }

    public boolean D() {
        return this.E != null || E();
    }

    public boolean E() {
        e eVar = this.C;
        return eVar != null && eVar.d();
    }

    public void F(Configuration configuration) {
        if (!this.f856w) {
            this.f855v = androidx.appcompat.view.a.b(this.f487f).d();
        }
        androidx.appcompat.view.menu.e eVar = this.f488g;
        if (eVar != null) {
            eVar.K(true);
        }
    }

    public void G(boolean z2) {
        this.f859z = z2;
    }

    public void H(ActionMenuView actionMenuView) {
        this.f494m = actionMenuView;
        actionMenuView.b(this.f488g);
    }

    public void I(Drawable drawable) {
        d dVar = this.f848o;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
        } else {
            this.f850q = true;
            this.f849p = drawable;
        }
    }

    public void J(boolean z2) {
        this.f851r = z2;
        this.f852s = true;
    }

    public boolean K() {
        androidx.appcompat.view.menu.e eVar;
        if (!this.f851r || E() || (eVar = this.f488g) == null || this.f494m == null || this.E != null || eVar.z().isEmpty()) {
            return false;
        }
        RunnableC0008c runnableC0008c = new RunnableC0008c(new e(this.f487f, this.f488g, this.f848o, true));
        this.E = runnableC0008c;
        ((View) this.f494m).post(runnableC0008c);
        return true;
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.k
    public void a(androidx.appcompat.view.menu.e eVar, boolean z2) {
        y();
        super.a(eVar, z2);
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.k
    public void c(@NonNull Context context, @Nullable androidx.appcompat.view.menu.e eVar) {
        super.c(context, eVar);
        Resources resources = context.getResources();
        androidx.appcompat.view.a aVarB = androidx.appcompat.view.a.b(context);
        if (!this.f852s) {
            this.f851r = aVarB.h();
        }
        if (!this.f858y) {
            this.f853t = aVarB.c();
        }
        if (!this.f856w) {
            this.f855v = aVarB.d();
        }
        int measuredWidth = this.f853t;
        if (this.f851r) {
            if (this.f848o == null) {
                d dVar = new d(this.f486e);
                this.f848o = dVar;
                if (this.f850q) {
                    dVar.setImageDrawable(this.f849p);
                    this.f849p = null;
                    this.f850q = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f848o.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.f848o.getMeasuredWidth();
        } else {
            this.f848o = null;
        }
        this.f854u = measuredWidth;
        this.A = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    @Override // androidx.appcompat.view.menu.b
    public void d(androidx.appcompat.view.menu.g gVar, l.a aVar) {
        aVar.d(gVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f494m);
        if (this.F == null) {
            this.F = new b();
        }
        actionMenuItemView.setPopupCallback(this.F);
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.k
    public boolean e(androidx.appcompat.view.menu.p pVar) {
        boolean z2 = false;
        if (!pVar.hasVisibleItems()) {
            return false;
        }
        androidx.appcompat.view.menu.p pVar2 = pVar;
        while (pVar2.e0() != this.f488g) {
            pVar2 = (androidx.appcompat.view.menu.p) pVar2.e0();
        }
        View viewZ = z(pVar2.getItem());
        if (viewZ == null) {
            return false;
        }
        this.H = pVar.getItem().getItemId();
        int size = pVar.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            MenuItem item = pVar.getItem(i2);
            if (item.isVisible() && item.getIcon() != null) {
                z2 = true;
                break;
            }
            i2++;
        }
        a aVar = new a(this.f487f, pVar, viewZ);
        this.D = aVar;
        aVar.g(z2);
        this.D.k();
        super.e(pVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.k
    public void f(boolean z2) {
        super.f(z2);
        ((View) this.f494m).requestLayout();
        androidx.appcompat.view.menu.e eVar = this.f488g;
        boolean z3 = false;
        if (eVar != null) {
            ArrayList<androidx.appcompat.view.menu.g> arrayListS = eVar.s();
            int size = arrayListS.size();
            for (int i2 = 0; i2 < size; i2++) {
                androidx.core.view.b bVarB = arrayListS.get(i2).b();
                if (bVarB != null) {
                    bVarB.i(this);
                }
            }
        }
        androidx.appcompat.view.menu.e eVar2 = this.f488g;
        ArrayList<androidx.appcompat.view.menu.g> arrayListZ = eVar2 != null ? eVar2.z() : null;
        if (this.f851r && arrayListZ != null) {
            int size2 = arrayListZ.size();
            if (size2 == 1) {
                z3 = !arrayListZ.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z3 = true;
            }
        }
        if (z3) {
            if (this.f848o == null) {
                this.f848o = new d(this.f486e);
            }
            ViewGroup viewGroup = (ViewGroup) this.f848o.getParent();
            if (viewGroup != this.f494m) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f848o);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f494m;
                actionMenuView.addView(this.f848o, actionMenuView.B());
            }
        } else {
            d dVar = this.f848o;
            if (dVar != null) {
                Object parent = dVar.getParent();
                Object obj = this.f494m;
                if (parent == obj) {
                    ((ViewGroup) obj).removeView(this.f848o);
                }
            }
        }
        ((ActionMenuView) this.f494m).setOverflowReserved(this.f851r);
    }

    @Override // androidx.appcompat.view.menu.k
    public boolean h() {
        ArrayList<androidx.appcompat.view.menu.g> arrayListE;
        int size;
        int i2;
        int iH;
        int i3;
        c cVar = this;
        androidx.appcompat.view.menu.e eVar = cVar.f488g;
        View view = null;
        int i4 = 0;
        if (eVar != null) {
            arrayListE = eVar.E();
            size = arrayListE.size();
        } else {
            arrayListE = null;
            size = 0;
        }
        int i5 = cVar.f855v;
        int i6 = cVar.f854u;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) cVar.f494m;
        boolean z2 = false;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < size; i9++) {
            androidx.appcompat.view.menu.g gVar = arrayListE.get(i9);
            if (gVar.o()) {
                i7++;
            } else if (gVar.n()) {
                i8++;
            } else {
                z2 = true;
            }
            if (cVar.f859z && gVar.isActionViewExpanded()) {
                i5 = 0;
            }
        }
        if (cVar.f851r && (z2 || i8 + i7 > i5)) {
            i5--;
        }
        int i10 = i5 - i7;
        SparseBooleanArray sparseBooleanArray = cVar.B;
        sparseBooleanArray.clear();
        if (cVar.f857x) {
            int i11 = cVar.A;
            iH = i6 / i11;
            i2 = i11 + ((i6 % i11) / iH);
        } else {
            i2 = 0;
            iH = 0;
        }
        int i12 = 0;
        int i13 = 0;
        while (i12 < size) {
            androidx.appcompat.view.menu.g gVar2 = arrayListE.get(i12);
            if (gVar2.o()) {
                View viewN = cVar.n(gVar2, view, viewGroup);
                if (cVar.f857x) {
                    iH -= ActionMenuView.H(viewN, i2, iH, iMakeMeasureSpec, i4);
                } else {
                    viewN.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                }
                int measuredWidth = viewN.getMeasuredWidth();
                i6 -= measuredWidth;
                if (i13 == 0) {
                    i13 = measuredWidth;
                }
                int groupId = gVar2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                gVar2.u(true);
                i3 = size;
            } else if (gVar2.n()) {
                int groupId2 = gVar2.getGroupId();
                boolean z3 = sparseBooleanArray.get(groupId2);
                boolean z4 = (i10 > 0 || z3) && i6 > 0 && (!cVar.f857x || iH > 0);
                boolean z5 = z4;
                i3 = size;
                if (z4) {
                    View viewN2 = cVar.n(gVar2, null, viewGroup);
                    if (cVar.f857x) {
                        int iH2 = ActionMenuView.H(viewN2, i2, iH, iMakeMeasureSpec, 0);
                        iH -= iH2;
                        if (iH2 == 0) {
                            z5 = false;
                        }
                    } else {
                        viewN2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                    }
                    boolean z6 = z5;
                    int measuredWidth2 = viewN2.getMeasuredWidth();
                    i6 -= measuredWidth2;
                    if (i13 == 0) {
                        i13 = measuredWidth2;
                    }
                    z4 = z6 & (!cVar.f857x ? i6 + i13 <= 0 : i6 < 0);
                }
                if (z4 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z3) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i14 = 0; i14 < i12; i14++) {
                        androidx.appcompat.view.menu.g gVar3 = arrayListE.get(i14);
                        if (gVar3.getGroupId() == groupId2) {
                            if (gVar3.l()) {
                                i10++;
                            }
                            gVar3.u(false);
                        }
                    }
                }
                if (z4) {
                    i10--;
                }
                gVar2.u(z4);
            } else {
                i3 = size;
                gVar2.u(false);
                i12++;
                view = null;
                cVar = this;
                size = i3;
                i4 = 0;
            }
            i12++;
            view = null;
            cVar = this;
            size = i3;
            i4 = 0;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean l(ViewGroup viewGroup, int i2) {
        if (viewGroup.getChildAt(i2) == this.f848o) {
            return false;
        }
        return super.l(viewGroup, i2);
    }

    @Override // androidx.appcompat.view.menu.b
    public View n(androidx.appcompat.view.menu.g gVar, View view, ViewGroup viewGroup) {
        View actionView = gVar.getActionView();
        if (actionView == null || gVar.j()) {
            actionView = super.n(gVar, view, viewGroup);
        }
        actionView.setVisibility(gVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // androidx.appcompat.view.menu.b
    public androidx.appcompat.view.menu.l o(ViewGroup viewGroup) {
        androidx.appcompat.view.menu.l lVar = this.f494m;
        androidx.appcompat.view.menu.l lVarO = super.o(viewGroup);
        if (lVar != lVarO) {
            ((ActionMenuView) lVarO).setPresenter(this);
        }
        return lVarO;
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean q(int i2, androidx.appcompat.view.menu.g gVar) {
        return gVar.l();
    }

    public boolean y() {
        return B() | C();
    }
}
