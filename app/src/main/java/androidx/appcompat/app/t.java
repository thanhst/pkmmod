package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.b;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.c2;
import androidx.appcompat.widget.k1;
import androidx.core.view.ViewCompat;
import androidx.core.view.a3;
import androidx.core.view.b3;
import androidx.core.view.y2;
import androidx.core.view.z2;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: WindowDecorActionBar.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class t extends ActionBar implements ActionBarOverlayLayout.d {
    private static final Interpolator E = new AccelerateInterpolator();
    private static final Interpolator F = new DecelerateInterpolator();
    boolean A;

    /* renamed from: a, reason: collision with root package name */
    Context f296a;

    /* renamed from: b, reason: collision with root package name */
    private Context f297b;

    /* renamed from: c, reason: collision with root package name */
    private Activity f298c;

    /* renamed from: d, reason: collision with root package name */
    ActionBarOverlayLayout f299d;

    /* renamed from: e, reason: collision with root package name */
    ActionBarContainer f300e;

    /* renamed from: f, reason: collision with root package name */
    k1 f301f;

    /* renamed from: g, reason: collision with root package name */
    ActionBarContextView f302g;

    /* renamed from: h, reason: collision with root package name */
    View f303h;

    /* renamed from: i, reason: collision with root package name */
    c2 f304i;

    /* renamed from: l, reason: collision with root package name */
    private boolean f307l;

    /* renamed from: m, reason: collision with root package name */
    d f308m;

    /* renamed from: n, reason: collision with root package name */
    androidx.appcompat.view.b f309n;

    /* renamed from: o, reason: collision with root package name */
    b.a f310o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f311p;

    /* renamed from: r, reason: collision with root package name */
    private boolean f313r;

    /* renamed from: u, reason: collision with root package name */
    boolean f316u;

    /* renamed from: v, reason: collision with root package name */
    boolean f317v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f318w;

    /* renamed from: y, reason: collision with root package name */
    androidx.appcompat.view.h f320y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f321z;

    /* renamed from: j, reason: collision with root package name */
    private ArrayList<Object> f305j = new ArrayList<>();

    /* renamed from: k, reason: collision with root package name */
    private int f306k = -1;

    /* renamed from: q, reason: collision with root package name */
    private ArrayList<ActionBar.b> f312q = new ArrayList<>();

    /* renamed from: s, reason: collision with root package name */
    private int f314s = 0;

    /* renamed from: t, reason: collision with root package name */
    boolean f315t = true;

    /* renamed from: x, reason: collision with root package name */
    private boolean f319x = true;
    final z2 B = new a();
    final z2 C = new b();
    final b3 D = new c();

    /* compiled from: WindowDecorActionBar.java */
    class a extends a3 {
        a() {
        }

        @Override // androidx.core.view.z2
        public void b(View view) {
            View view2;
            t tVar = t.this;
            if (tVar.f315t && (view2 = tVar.f303h) != null) {
                view2.setTranslationY(0.0f);
                t.this.f300e.setTranslationY(0.0f);
            }
            t.this.f300e.setVisibility(8);
            t.this.f300e.setTransitioning(false);
            t tVar2 = t.this;
            tVar2.f320y = null;
            tVar2.x();
            ActionBarOverlayLayout actionBarOverlayLayout = t.this.f299d;
            if (actionBarOverlayLayout != null) {
                ViewCompat.L(actionBarOverlayLayout);
            }
        }
    }

    /* compiled from: WindowDecorActionBar.java */
    class b extends a3 {
        b() {
        }

        @Override // androidx.core.view.z2
        public void b(View view) {
            t tVar = t.this;
            tVar.f320y = null;
            tVar.f300e.requestLayout();
        }
    }

    /* compiled from: WindowDecorActionBar.java */
    class c implements b3 {
        c() {
        }

        @Override // androidx.core.view.b3
        public void a(View view) {
            ((View) t.this.f300e.getParent()).invalidate();
        }
    }

    /* compiled from: WindowDecorActionBar.java */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public class d extends androidx.appcompat.view.b implements e.a {

        /* renamed from: g, reason: collision with root package name */
        private final Context f325g;

        /* renamed from: h, reason: collision with root package name */
        private final androidx.appcompat.view.menu.e f326h;

        /* renamed from: i, reason: collision with root package name */
        private b.a f327i;

        /* renamed from: j, reason: collision with root package name */
        private WeakReference<View> f328j;

        public d(Context context, b.a aVar) {
            this.f325g = context;
            this.f327i = aVar;
            androidx.appcompat.view.menu.e eVarS = new androidx.appcompat.view.menu.e(context).S(1);
            this.f326h = eVarS;
            eVarS.R(this);
        }

        @Override // androidx.appcompat.view.menu.e.a
        public boolean a(@NonNull androidx.appcompat.view.menu.e eVar, @NonNull MenuItem menuItem) {
            b.a aVar = this.f327i;
            if (aVar != null) {
                return aVar.c(this, menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.e.a
        public void b(@NonNull androidx.appcompat.view.menu.e eVar) {
            if (this.f327i == null) {
                return;
            }
            k();
            t.this.f302g.l();
        }

        @Override // androidx.appcompat.view.b
        public void c() {
            t tVar = t.this;
            if (tVar.f308m != this) {
                return;
            }
            if (t.w(tVar.f316u, tVar.f317v, false)) {
                this.f327i.b(this);
            } else {
                t tVar2 = t.this;
                tVar2.f309n = this;
                tVar2.f310o = this.f327i;
            }
            this.f327i = null;
            t.this.v(false);
            t.this.f302g.g();
            t tVar3 = t.this;
            tVar3.f299d.setHideOnContentScrollEnabled(tVar3.A);
            t.this.f308m = null;
        }

        @Override // androidx.appcompat.view.b
        public View d() {
            WeakReference<View> weakReference = this.f328j;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // androidx.appcompat.view.b
        public Menu e() {
            return this.f326h;
        }

        @Override // androidx.appcompat.view.b
        public MenuInflater f() {
            return new androidx.appcompat.view.g(this.f325g);
        }

        @Override // androidx.appcompat.view.b
        public CharSequence g() {
            return t.this.f302g.getSubtitle();
        }

        @Override // androidx.appcompat.view.b
        public CharSequence i() {
            return t.this.f302g.getTitle();
        }

        @Override // androidx.appcompat.view.b
        public void k() {
            if (t.this.f308m != this) {
                return;
            }
            this.f326h.d0();
            try {
                this.f327i.a(this, this.f326h);
            } finally {
                this.f326h.c0();
            }
        }

        @Override // androidx.appcompat.view.b
        public boolean l() {
            return t.this.f302g.j();
        }

        @Override // androidx.appcompat.view.b
        public void m(View view) {
            t.this.f302g.setCustomView(view);
            this.f328j = new WeakReference<>(view);
        }

        @Override // androidx.appcompat.view.b
        public void n(int i2) {
            o(t.this.f296a.getResources().getString(i2));
        }

        @Override // androidx.appcompat.view.b
        public void o(CharSequence charSequence) {
            t.this.f302g.setSubtitle(charSequence);
        }

        @Override // androidx.appcompat.view.b
        public void q(int i2) {
            r(t.this.f296a.getResources().getString(i2));
        }

        @Override // androidx.appcompat.view.b
        public void r(CharSequence charSequence) {
            t.this.f302g.setTitle(charSequence);
        }

        @Override // androidx.appcompat.view.b
        public void s(boolean z2) {
            super.s(z2);
            t.this.f302g.setTitleOptional(z2);
        }

        public boolean t() {
            this.f326h.d0();
            try {
                return this.f327i.d(this, this.f326h);
            } finally {
                this.f326h.c0();
            }
        }
    }

    public t(Activity activity, boolean z2) {
        this.f298c = activity;
        View decorView = activity.getWindow().getDecorView();
        D(decorView);
        if (z2) {
            return;
        }
        this.f303h = decorView.findViewById(R.id.content);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private k1 A(View view) {
        if (view instanceof k1) {
            return (k1) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view != 0 ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb.toString());
    }

    private void C() {
        if (this.f318w) {
            this.f318w = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f299d;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            M(false);
        }
    }

    private void D(View view) {
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(R$id.decor_content_parent);
        this.f299d = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f301f = A(view.findViewById(R$id.action_bar));
        this.f302g = (ActionBarContextView) view.findViewById(R$id.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(R$id.action_bar_container);
        this.f300e = actionBarContainer;
        k1 k1Var = this.f301f;
        if (k1Var == null || this.f302g == null || actionBarContainer == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f296a = k1Var.getContext();
        boolean z2 = (this.f301f.n() & 4) != 0;
        if (z2) {
            this.f307l = true;
        }
        androidx.appcompat.view.a aVarB = androidx.appcompat.view.a.b(this.f296a);
        J(aVarB.a() || z2);
        H(aVarB.g());
        TypedArray typedArrayObtainStyledAttributes = this.f296a.obtainStyledAttributes(null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(R$styleable.ActionBar_hideOnContentScroll, false)) {
            I(true);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            G(dimensionPixelSize);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private void H(boolean z2) {
        this.f313r = z2;
        if (z2) {
            this.f300e.setTabContainer(null);
            this.f301f.j(this.f304i);
        } else {
            this.f301f.j(null);
            this.f300e.setTabContainer(this.f304i);
        }
        boolean z3 = B() == 2;
        c2 c2Var = this.f304i;
        if (c2Var != null) {
            if (z3) {
                c2Var.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f299d;
                if (actionBarOverlayLayout != null) {
                    ViewCompat.L(actionBarOverlayLayout);
                }
            } else {
                c2Var.setVisibility(8);
            }
        }
        this.f301f.t(!this.f313r && z3);
        this.f299d.setHasNonEmbeddedTabs(!this.f313r && z3);
    }

    private boolean K() {
        return ViewCompat.B(this.f300e);
    }

    private void L() {
        if (this.f318w) {
            return;
        }
        this.f318w = true;
        ActionBarOverlayLayout actionBarOverlayLayout = this.f299d;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setShowingForActionMode(true);
        }
        M(false);
    }

    private void M(boolean z2) {
        if (w(this.f316u, this.f317v, this.f318w)) {
            if (this.f319x) {
                return;
            }
            this.f319x = true;
            z(z2);
            return;
        }
        if (this.f319x) {
            this.f319x = false;
            y(z2);
        }
    }

    static boolean w(boolean z2, boolean z3, boolean z4) {
        if (z4) {
            return true;
        }
        return (z2 || z3) ? false : true;
    }

    public int B() {
        return this.f301f.p();
    }

    public void E(boolean z2) {
        F(z2 ? 4 : 0, 4);
    }

    public void F(int i2, int i3) {
        int iN = this.f301f.n();
        if ((i3 & 4) != 0) {
            this.f307l = true;
        }
        this.f301f.m((i2 & i3) | ((i3 ^ (-1)) & iN));
    }

    public void G(float f2) {
        ViewCompat.U(this.f300e, f2);
    }

    public void I(boolean z2) {
        if (z2 && !this.f299d.w()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.A = z2;
        this.f299d.setHideOnContentScrollEnabled(z2);
    }

    public void J(boolean z2) {
        this.f301f.k(z2);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void a() {
        if (this.f317v) {
            this.f317v = false;
            M(true);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void b() {
        androidx.appcompat.view.h hVar = this.f320y;
        if (hVar != null) {
            hVar.a();
            this.f320y = null;
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void c(int i2) {
        this.f314s = i2;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void d() {
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void e(boolean z2) {
        this.f315t = z2;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void f() {
        if (this.f317v) {
            return;
        }
        this.f317v = true;
        M(true);
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean h() {
        k1 k1Var = this.f301f;
        if (k1Var == null || !k1Var.l()) {
            return false;
        }
        this.f301f.collapseActionView();
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void i(boolean z2) {
        if (z2 == this.f311p) {
            return;
        }
        this.f311p = z2;
        int size = this.f312q.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f312q.get(i2).onMenuVisibilityChanged(z2);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public int j() {
        return this.f301f.n();
    }

    @Override // androidx.appcompat.app.ActionBar
    public Context k() {
        if (this.f297b == null) {
            TypedValue typedValue = new TypedValue();
            this.f296a.getTheme().resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                this.f297b = new ContextThemeWrapper(this.f296a, i2);
            } else {
                this.f297b = this.f296a;
            }
        }
        return this.f297b;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void m(Configuration configuration) {
        H(androidx.appcompat.view.a.b(this.f296a).g());
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean o(int i2, KeyEvent keyEvent) {
        Menu menuE;
        d dVar = this.f308m;
        if (dVar == null || (menuE = dVar.e()) == null) {
            return false;
        }
        menuE.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menuE.performShortcut(i2, keyEvent, 0);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void r(boolean z2) {
        if (this.f307l) {
            return;
        }
        E(z2);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void s(boolean z2) {
        androidx.appcompat.view.h hVar;
        this.f321z = z2;
        if (z2 || (hVar = this.f320y) == null) {
            return;
        }
        hVar.a();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void t(CharSequence charSequence) {
        this.f301f.setWindowTitle(charSequence);
    }

    @Override // androidx.appcompat.app.ActionBar
    public androidx.appcompat.view.b u(b.a aVar) {
        d dVar = this.f308m;
        if (dVar != null) {
            dVar.c();
        }
        this.f299d.setHideOnContentScrollEnabled(false);
        this.f302g.k();
        d dVar2 = new d(this.f302g.getContext(), aVar);
        if (!dVar2.t()) {
            return null;
        }
        this.f308m = dVar2;
        dVar2.k();
        this.f302g.h(dVar2);
        v(true);
        return dVar2;
    }

    public void v(boolean z2) {
        y2 y2VarQ;
        y2 y2VarF;
        if (z2) {
            L();
        } else {
            C();
        }
        if (!K()) {
            if (z2) {
                this.f301f.i(4);
                this.f302g.setVisibility(0);
                return;
            } else {
                this.f301f.i(0);
                this.f302g.setVisibility(8);
                return;
            }
        }
        if (z2) {
            y2VarF = this.f301f.q(4, 100L);
            y2VarQ = this.f302g.f(0, 200L);
        } else {
            y2VarQ = this.f301f.q(0, 200L);
            y2VarF = this.f302g.f(8, 100L);
        }
        androidx.appcompat.view.h hVar = new androidx.appcompat.view.h();
        hVar.d(y2VarF, y2VarQ);
        hVar.h();
    }

    void x() {
        b.a aVar = this.f310o;
        if (aVar != null) {
            aVar.b(this.f309n);
            this.f309n = null;
            this.f310o = null;
        }
    }

    public void y(boolean z2) {
        View view;
        androidx.appcompat.view.h hVar = this.f320y;
        if (hVar != null) {
            hVar.a();
        }
        if (this.f314s != 0 || (!this.f321z && !z2)) {
            this.B.b(null);
            return;
        }
        this.f300e.setAlpha(1.0f);
        this.f300e.setTransitioning(true);
        androidx.appcompat.view.h hVar2 = new androidx.appcompat.view.h();
        float f2 = -this.f300e.getHeight();
        if (z2) {
            this.f300e.getLocationInWindow(new int[]{0, 0});
            f2 -= r5[1];
        }
        y2 y2VarM = ViewCompat.c(this.f300e).m(f2);
        y2VarM.k(this.D);
        hVar2.c(y2VarM);
        if (this.f315t && (view = this.f303h) != null) {
            hVar2.c(ViewCompat.c(view).m(f2));
        }
        hVar2.f(E);
        hVar2.e(250L);
        hVar2.g(this.B);
        this.f320y = hVar2;
        hVar2.h();
    }

    public void z(boolean z2) {
        View view;
        View view2;
        androidx.appcompat.view.h hVar = this.f320y;
        if (hVar != null) {
            hVar.a();
        }
        this.f300e.setVisibility(0);
        if (this.f314s == 0 && (this.f321z || z2)) {
            this.f300e.setTranslationY(0.0f);
            float f2 = -this.f300e.getHeight();
            if (z2) {
                this.f300e.getLocationInWindow(new int[]{0, 0});
                f2 -= r5[1];
            }
            this.f300e.setTranslationY(f2);
            androidx.appcompat.view.h hVar2 = new androidx.appcompat.view.h();
            y2 y2VarM = ViewCompat.c(this.f300e).m(0.0f);
            y2VarM.k(this.D);
            hVar2.c(y2VarM);
            if (this.f315t && (view2 = this.f303h) != null) {
                view2.setTranslationY(f2);
                hVar2.c(ViewCompat.c(this.f303h).m(0.0f));
            }
            hVar2.f(F);
            hVar2.e(250L);
            hVar2.g(this.C);
            this.f320y = hVar2;
            hVar2.h();
        } else {
            this.f300e.setAlpha(1.0f);
            this.f300e.setTranslationY(0.0f);
            if (this.f315t && (view = this.f303h) != null) {
                view.setTranslationY(0.0f);
            }
            this.C.b(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f299d;
        if (actionBarOverlayLayout != null) {
            ViewCompat.L(actionBarOverlayLayout);
        }
    }

    public t(Dialog dialog) {
        D(dialog.getWindow().getDecorView());
    }
}
