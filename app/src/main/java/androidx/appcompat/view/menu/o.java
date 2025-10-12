package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.x1;
import androidx.core.view.ViewCompat;

/* compiled from: StandardMenuPopup.java */
/* loaded from: classes.dex */
final class o extends i implements PopupWindow.OnDismissListener, View.OnKeyListener {

    /* renamed from: z, reason: collision with root package name */
    private static final int f593z = R$layout.abc_popup_menu_item_layout;

    /* renamed from: f, reason: collision with root package name */
    private final Context f594f;

    /* renamed from: g, reason: collision with root package name */
    private final e f595g;

    /* renamed from: h, reason: collision with root package name */
    private final MenuAdapter f596h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f597i;

    /* renamed from: j, reason: collision with root package name */
    private final int f598j;

    /* renamed from: k, reason: collision with root package name */
    private final int f599k;

    /* renamed from: l, reason: collision with root package name */
    private final int f600l;

    /* renamed from: m, reason: collision with root package name */
    final x1 f601m;

    /* renamed from: p, reason: collision with root package name */
    private PopupWindow.OnDismissListener f604p;

    /* renamed from: q, reason: collision with root package name */
    private View f605q;

    /* renamed from: r, reason: collision with root package name */
    View f606r;

    /* renamed from: s, reason: collision with root package name */
    private k.a f607s;

    /* renamed from: t, reason: collision with root package name */
    ViewTreeObserver f608t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f609u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f610v;

    /* renamed from: w, reason: collision with root package name */
    private int f611w;

    /* renamed from: y, reason: collision with root package name */
    private boolean f613y;

    /* renamed from: n, reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f602n = new a();

    /* renamed from: o, reason: collision with root package name */
    private final View.OnAttachStateChangeListener f603o = new b();

    /* renamed from: x, reason: collision with root package name */
    private int f612x = 0;

    /* compiled from: StandardMenuPopup.java */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!o.this.b() || o.this.f601m.x()) {
                return;
            }
            View view = o.this.f606r;
            if (view == null || !view.isShown()) {
                o.this.dismiss();
            } else {
                o.this.f601m.d();
            }
        }
    }

    /* compiled from: StandardMenuPopup.java */
    class b implements View.OnAttachStateChangeListener {
        b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = o.this.f608t;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    o.this.f608t = view.getViewTreeObserver();
                }
                o oVar = o.this;
                oVar.f608t.removeGlobalOnLayoutListener(oVar.f602n);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public o(Context context, e eVar, View view, int i2, int i3, boolean z2) {
        this.f594f = context;
        this.f595g = eVar;
        this.f597i = z2;
        this.f596h = new MenuAdapter(eVar, LayoutInflater.from(context), z2, f593z);
        this.f599k = i2;
        this.f600l = i3;
        Resources resources = context.getResources();
        this.f598j = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.abc_config_prefDialogWidth));
        this.f605q = view;
        this.f601m = new x1(context, null, i2, i3);
        eVar.c(this, context);
    }

    private boolean z() {
        View view;
        if (b()) {
            return true;
        }
        if (this.f609u || (view = this.f605q) == null) {
            return false;
        }
        this.f606r = view;
        this.f601m.G(this);
        this.f601m.H(this);
        this.f601m.F(true);
        View view2 = this.f606r;
        boolean z2 = this.f608t == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.f608t = viewTreeObserver;
        if (z2) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f602n);
        }
        view2.addOnAttachStateChangeListener(this.f603o);
        this.f601m.z(view2);
        this.f601m.C(this.f612x);
        if (!this.f610v) {
            this.f611w = i.o(this.f596h, null, this.f594f, this.f598j);
            this.f610v = true;
        }
        this.f601m.B(this.f611w);
        this.f601m.E(2);
        this.f601m.D(n());
        this.f601m.d();
        ListView listViewG = this.f601m.g();
        listViewG.setOnKeyListener(this);
        if (this.f613y && this.f595g.x() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f594f).inflate(R$layout.abc_popup_menu_header_item_layout, (ViewGroup) listViewG, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            if (textView != null) {
                textView.setText(this.f595g.x());
            }
            frameLayout.setEnabled(false);
            listViewG.addHeaderView(frameLayout, null, false);
        }
        this.f601m.p(this.f596h);
        this.f601m.d();
        return true;
    }

    @Override // androidx.appcompat.view.menu.k
    public void a(e eVar, boolean z2) {
        if (eVar != this.f595g) {
            return;
        }
        dismiss();
        k.a aVar = this.f607s;
        if (aVar != null) {
            aVar.a(eVar, z2);
        }
    }

    @Override // androidx.appcompat.view.menu.n
    public boolean b() {
        return !this.f609u && this.f601m.b();
    }

    @Override // androidx.appcompat.view.menu.n
    public void d() {
        if (!z()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // androidx.appcompat.view.menu.n
    public void dismiss() {
        if (b()) {
            this.f601m.dismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.k
    public boolean e(p pVar) {
        if (pVar.hasVisibleItems()) {
            j jVar = new j(this.f594f, pVar, this.f606r, this.f597i, this.f599k, this.f600l);
            jVar.j(this.f607s);
            jVar.g(i.x(pVar));
            jVar.i(this.f604p);
            this.f604p = null;
            this.f595g.e(false);
            int iA = this.f601m.a();
            int iN = this.f601m.n();
            if ((Gravity.getAbsoluteGravity(this.f612x, ViewCompat.r(this.f605q)) & 7) == 5) {
                iA += this.f605q.getWidth();
            }
            if (jVar.n(iA, iN)) {
                k.a aVar = this.f607s;
                if (aVar == null) {
                    return true;
                }
                aVar.b(pVar);
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.k
    public void f(boolean z2) {
        this.f610v = false;
        MenuAdapter menuAdapter = this.f596h;
        if (menuAdapter != null) {
            menuAdapter.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.n
    public ListView g() {
        return this.f601m.g();
    }

    @Override // androidx.appcompat.view.menu.k
    public boolean h() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.k
    public void k(k.a aVar) {
        this.f607s = aVar;
    }

    @Override // androidx.appcompat.view.menu.i
    public void l(e eVar) {
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f609u = true;
        this.f595g.close();
        ViewTreeObserver viewTreeObserver = this.f608t;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f608t = this.f606r.getViewTreeObserver();
            }
            this.f608t.removeGlobalOnLayoutListener(this.f602n);
            this.f608t = null;
        }
        this.f606r.removeOnAttachStateChangeListener(this.f603o);
        PopupWindow.OnDismissListener onDismissListener = this.f604p;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i2 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // androidx.appcompat.view.menu.i
    public void p(View view) {
        this.f605q = view;
    }

    @Override // androidx.appcompat.view.menu.i
    public void r(boolean z2) {
        this.f596h.d(z2);
    }

    @Override // androidx.appcompat.view.menu.i
    public void s(int i2) {
        this.f612x = i2;
    }

    @Override // androidx.appcompat.view.menu.i
    public void t(int i2) {
        this.f601m.l(i2);
    }

    @Override // androidx.appcompat.view.menu.i
    public void u(PopupWindow.OnDismissListener onDismissListener) {
        this.f604p = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.i
    public void v(boolean z2) {
        this.f613y = z2;
    }

    @Override // androidx.appcompat.view.menu.i
    public void w(int i2) {
        this.f601m.j(i2);
    }
}
