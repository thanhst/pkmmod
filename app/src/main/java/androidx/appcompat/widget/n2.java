package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$drawable;
import androidx.appcompat.R$id;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.core.view.a3;
import androidx.core.view.y2;

/* compiled from: ToolbarWidgetWrapper.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class n2 implements k1 {

    /* renamed from: a, reason: collision with root package name */
    Toolbar f1038a;

    /* renamed from: b, reason: collision with root package name */
    private int f1039b;

    /* renamed from: c, reason: collision with root package name */
    private View f1040c;

    /* renamed from: d, reason: collision with root package name */
    private View f1041d;

    /* renamed from: e, reason: collision with root package name */
    private Drawable f1042e;

    /* renamed from: f, reason: collision with root package name */
    private Drawable f1043f;

    /* renamed from: g, reason: collision with root package name */
    private Drawable f1044g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f1045h;

    /* renamed from: i, reason: collision with root package name */
    CharSequence f1046i;

    /* renamed from: j, reason: collision with root package name */
    private CharSequence f1047j;

    /* renamed from: k, reason: collision with root package name */
    private CharSequence f1048k;

    /* renamed from: l, reason: collision with root package name */
    Window.Callback f1049l;

    /* renamed from: m, reason: collision with root package name */
    boolean f1050m;

    /* renamed from: n, reason: collision with root package name */
    private c f1051n;

    /* renamed from: o, reason: collision with root package name */
    private int f1052o;

    /* renamed from: p, reason: collision with root package name */
    private int f1053p;

    /* renamed from: q, reason: collision with root package name */
    private Drawable f1054q;

    /* compiled from: ToolbarWidgetWrapper.java */
    class a implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final androidx.appcompat.view.menu.a f1055e;

        a() {
            this.f1055e = new androidx.appcompat.view.menu.a(n2.this.f1038a.getContext(), 0, R.id.home, 0, 0, n2.this.f1046i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            n2 n2Var = n2.this;
            Window.Callback callback = n2Var.f1049l;
            if (callback == null || !n2Var.f1050m) {
                return;
            }
            callback.onMenuItemSelected(0, this.f1055e);
        }
    }

    /* compiled from: ToolbarWidgetWrapper.java */
    class b extends a3 {

        /* renamed from: a, reason: collision with root package name */
        private boolean f1057a = false;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f1058b;

        b(int i2) {
            this.f1058b = i2;
        }

        @Override // androidx.core.view.a3, androidx.core.view.z2
        public void a(View view) {
            this.f1057a = true;
        }

        @Override // androidx.core.view.z2
        public void b(View view) {
            if (this.f1057a) {
                return;
            }
            n2.this.f1038a.setVisibility(this.f1058b);
        }

        @Override // androidx.core.view.a3, androidx.core.view.z2
        public void c(View view) {
            n2.this.f1038a.setVisibility(0);
        }
    }

    public n2(Toolbar toolbar, boolean z2) {
        this(toolbar, z2, R$string.abc_action_bar_up_description, R$drawable.abc_ic_ab_back_material);
    }

    private void D(CharSequence charSequence) {
        this.f1046i = charSequence;
        if ((this.f1039b & 8) != 0) {
            this.f1038a.setTitle(charSequence);
            if (this.f1045h) {
                ViewCompat.Q(this.f1038a.getRootView(), charSequence);
            }
        }
    }

    private void E() {
        if ((this.f1039b & 4) != 0) {
            if (TextUtils.isEmpty(this.f1048k)) {
                this.f1038a.setNavigationContentDescription(this.f1053p);
            } else {
                this.f1038a.setNavigationContentDescription(this.f1048k);
            }
        }
    }

    private void F() {
        if ((this.f1039b & 4) == 0) {
            this.f1038a.setNavigationIcon((Drawable) null);
            return;
        }
        Toolbar toolbar = this.f1038a;
        Drawable drawable = this.f1044g;
        if (drawable == null) {
            drawable = this.f1054q;
        }
        toolbar.setNavigationIcon(drawable);
    }

    private void G() {
        Drawable drawable;
        int i2 = this.f1039b;
        if ((i2 & 2) == 0) {
            drawable = null;
        } else if ((i2 & 1) == 0 || (drawable = this.f1043f) == null) {
            drawable = this.f1042e;
        }
        this.f1038a.setLogo(drawable);
    }

    private int u() {
        if (this.f1038a.getNavigationIcon() == null) {
            return 11;
        }
        this.f1054q = this.f1038a.getNavigationIcon();
        return 15;
    }

    public void A(Drawable drawable) {
        this.f1044g = drawable;
        F();
    }

    public void B(CharSequence charSequence) {
        this.f1047j = charSequence;
        if ((this.f1039b & 8) != 0) {
            this.f1038a.setSubtitle(charSequence);
        }
    }

    public void C(CharSequence charSequence) {
        this.f1045h = true;
        D(charSequence);
    }

    @Override // androidx.appcompat.widget.k1
    public void a(Menu menu, k.a aVar) {
        if (this.f1051n == null) {
            c cVar = new c(this.f1038a.getContext());
            this.f1051n = cVar;
            cVar.p(R$id.action_menu_presenter);
        }
        this.f1051n.k(aVar);
        this.f1038a.K((androidx.appcompat.view.menu.e) menu, this.f1051n);
    }

    @Override // androidx.appcompat.widget.k1
    public boolean b() {
        return this.f1038a.B();
    }

    @Override // androidx.appcompat.widget.k1
    public void c() {
        this.f1050m = true;
    }

    @Override // androidx.appcompat.widget.k1
    public void collapseActionView() {
        this.f1038a.e();
    }

    @Override // androidx.appcompat.widget.k1
    public boolean d() {
        return this.f1038a.A();
    }

    @Override // androidx.appcompat.widget.k1
    public boolean e() {
        return this.f1038a.w();
    }

    @Override // androidx.appcompat.widget.k1
    public boolean f() {
        return this.f1038a.P();
    }

    @Override // androidx.appcompat.widget.k1
    public boolean g() {
        return this.f1038a.d();
    }

    @Override // androidx.appcompat.widget.k1
    public Context getContext() {
        return this.f1038a.getContext();
    }

    @Override // androidx.appcompat.widget.k1
    public CharSequence getTitle() {
        return this.f1038a.getTitle();
    }

    @Override // androidx.appcompat.widget.k1
    public void h() {
        this.f1038a.f();
    }

    @Override // androidx.appcompat.widget.k1
    public void i(int i2) {
        this.f1038a.setVisibility(i2);
    }

    @Override // androidx.appcompat.widget.k1
    public void j(c2 c2Var) {
        View view = this.f1040c;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.f1038a;
            if (parent == toolbar) {
                toolbar.removeView(this.f1040c);
            }
        }
        this.f1040c = c2Var;
        if (c2Var == null || this.f1052o != 2) {
            return;
        }
        this.f1038a.addView(c2Var, 0);
        Toolbar.g gVar = (Toolbar.g) this.f1040c.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) gVar).width = -2;
        ((ViewGroup.MarginLayoutParams) gVar).height = -2;
        gVar.f80a = 8388691;
        c2Var.setAllowCollapse(true);
    }

    @Override // androidx.appcompat.widget.k1
    public void k(boolean z2) {
    }

    @Override // androidx.appcompat.widget.k1
    public boolean l() {
        return this.f1038a.v();
    }

    @Override // androidx.appcompat.widget.k1
    public void m(int i2) {
        View view;
        int i3 = this.f1039b ^ i2;
        this.f1039b = i2;
        if (i3 != 0) {
            if ((i3 & 4) != 0) {
                if ((i2 & 4) != 0) {
                    E();
                }
                F();
            }
            if ((i3 & 3) != 0) {
                G();
            }
            if ((i3 & 8) != 0) {
                if ((i2 & 8) != 0) {
                    this.f1038a.setTitle(this.f1046i);
                    this.f1038a.setSubtitle(this.f1047j);
                } else {
                    this.f1038a.setTitle((CharSequence) null);
                    this.f1038a.setSubtitle((CharSequence) null);
                }
            }
            if ((i3 & 16) == 0 || (view = this.f1041d) == null) {
                return;
            }
            if ((i2 & 16) != 0) {
                this.f1038a.addView(view);
            } else {
                this.f1038a.removeView(view);
            }
        }
    }

    @Override // androidx.appcompat.widget.k1
    public int n() {
        return this.f1039b;
    }

    @Override // androidx.appcompat.widget.k1
    public void o(int i2) {
        x(i2 != 0 ? e.a.b(getContext(), i2) : null);
    }

    @Override // androidx.appcompat.widget.k1
    public int p() {
        return this.f1052o;
    }

    @Override // androidx.appcompat.widget.k1
    public y2 q(int i2, long j2) {
        return ViewCompat.c(this.f1038a).b(i2 == 0 ? 1.0f : 0.0f).f(j2).h(new b(i2));
    }

    @Override // androidx.appcompat.widget.k1
    public void r() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.k1
    public void s() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.k1
    public void setIcon(int i2) {
        setIcon(i2 != 0 ? e.a.b(getContext(), i2) : null);
    }

    @Override // androidx.appcompat.widget.k1
    public void setWindowCallback(Window.Callback callback) {
        this.f1049l = callback;
    }

    @Override // androidx.appcompat.widget.k1
    public void setWindowTitle(CharSequence charSequence) {
        if (this.f1045h) {
            return;
        }
        D(charSequence);
    }

    @Override // androidx.appcompat.widget.k1
    public void t(boolean z2) {
        this.f1038a.setCollapsible(z2);
    }

    public void v(View view) {
        View view2 = this.f1041d;
        if (view2 != null && (this.f1039b & 16) != 0) {
            this.f1038a.removeView(view2);
        }
        this.f1041d = view;
        if (view == null || (this.f1039b & 16) == 0) {
            return;
        }
        this.f1038a.addView(view);
    }

    public void w(int i2) {
        if (i2 == this.f1053p) {
            return;
        }
        this.f1053p = i2;
        if (TextUtils.isEmpty(this.f1038a.getNavigationContentDescription())) {
            y(this.f1053p);
        }
    }

    public void x(Drawable drawable) {
        this.f1043f = drawable;
        G();
    }

    public void y(int i2) {
        z(i2 == 0 ? null : getContext().getString(i2));
    }

    public void z(CharSequence charSequence) {
        this.f1048k = charSequence;
        E();
    }

    public n2(Toolbar toolbar, boolean z2, int i2, int i3) {
        Drawable drawable;
        this.f1052o = 0;
        this.f1053p = 0;
        this.f1038a = toolbar;
        this.f1046i = toolbar.getTitle();
        this.f1047j = toolbar.getSubtitle();
        this.f1045h = this.f1046i != null;
        this.f1044g = toolbar.getNavigationIcon();
        k2 k2VarU = k2.u(toolbar.getContext(), null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
        this.f1054q = k2VarU.f(R$styleable.ActionBar_homeAsUpIndicator);
        if (z2) {
            CharSequence charSequenceO = k2VarU.o(R$styleable.ActionBar_title);
            if (!TextUtils.isEmpty(charSequenceO)) {
                C(charSequenceO);
            }
            CharSequence charSequenceO2 = k2VarU.o(R$styleable.ActionBar_subtitle);
            if (!TextUtils.isEmpty(charSequenceO2)) {
                B(charSequenceO2);
            }
            Drawable drawableF = k2VarU.f(R$styleable.ActionBar_logo);
            if (drawableF != null) {
                x(drawableF);
            }
            Drawable drawableF2 = k2VarU.f(R$styleable.ActionBar_icon);
            if (drawableF2 != null) {
                setIcon(drawableF2);
            }
            if (this.f1044g == null && (drawable = this.f1054q) != null) {
                A(drawable);
            }
            m(k2VarU.j(R$styleable.ActionBar_displayOptions, 0));
            int iM = k2VarU.m(R$styleable.ActionBar_customNavigationLayout, 0);
            if (iM != 0) {
                v(LayoutInflater.from(this.f1038a.getContext()).inflate(iM, (ViewGroup) this.f1038a, false));
                m(this.f1039b | 16);
            }
            int iL = k2VarU.l(R$styleable.ActionBar_height, 0);
            if (iL > 0) {
                ViewGroup.LayoutParams layoutParams = this.f1038a.getLayoutParams();
                layoutParams.height = iL;
                this.f1038a.setLayoutParams(layoutParams);
            }
            int iD = k2VarU.d(R$styleable.ActionBar_contentInsetStart, -1);
            int iD2 = k2VarU.d(R$styleable.ActionBar_contentInsetEnd, -1);
            if (iD >= 0 || iD2 >= 0) {
                this.f1038a.J(Math.max(iD, 0), Math.max(iD2, 0));
            }
            int iM2 = k2VarU.m(R$styleable.ActionBar_titleTextStyle, 0);
            if (iM2 != 0) {
                Toolbar toolbar2 = this.f1038a;
                toolbar2.M(toolbar2.getContext(), iM2);
            }
            int iM3 = k2VarU.m(R$styleable.ActionBar_subtitleTextStyle, 0);
            if (iM3 != 0) {
                Toolbar toolbar3 = this.f1038a;
                toolbar3.L(toolbar3.getContext(), iM3);
            }
            int iM4 = k2VarU.m(R$styleable.ActionBar_popupTheme, 0);
            if (iM4 != 0) {
                this.f1038a.setPopupTheme(iM4);
            }
        } else {
            this.f1039b = u();
        }
        k2VarU.v();
        w(i2);
        this.f1048k = this.f1038a.getNavigationContentDescription();
        this.f1038a.setNavigationOnClickListener(new a());
    }

    @Override // androidx.appcompat.widget.k1
    public void setIcon(Drawable drawable) {
        this.f1042e = drawable;
        G();
    }
}
