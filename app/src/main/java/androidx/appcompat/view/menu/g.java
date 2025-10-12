package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R$string;
import androidx.appcompat.view.menu.l;
import androidx.core.view.b;

/* compiled from: MenuItemImpl.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class g implements n.b {
    private View A;
    private androidx.core.view.b B;
    private MenuItem.OnActionExpandListener C;
    private ContextMenu.ContextMenuInfo E;

    /* renamed from: a, reason: collision with root package name */
    private final int f540a;

    /* renamed from: b, reason: collision with root package name */
    private final int f541b;

    /* renamed from: c, reason: collision with root package name */
    private final int f542c;

    /* renamed from: d, reason: collision with root package name */
    private final int f543d;

    /* renamed from: e, reason: collision with root package name */
    private CharSequence f544e;

    /* renamed from: f, reason: collision with root package name */
    private CharSequence f545f;

    /* renamed from: g, reason: collision with root package name */
    private Intent f546g;

    /* renamed from: h, reason: collision with root package name */
    private char f547h;

    /* renamed from: j, reason: collision with root package name */
    private char f549j;

    /* renamed from: l, reason: collision with root package name */
    private Drawable f551l;

    /* renamed from: n, reason: collision with root package name */
    e f553n;

    /* renamed from: o, reason: collision with root package name */
    private p f554o;

    /* renamed from: p, reason: collision with root package name */
    private Runnable f555p;

    /* renamed from: q, reason: collision with root package name */
    private MenuItem.OnMenuItemClickListener f556q;

    /* renamed from: r, reason: collision with root package name */
    private CharSequence f557r;

    /* renamed from: s, reason: collision with root package name */
    private CharSequence f558s;

    /* renamed from: z, reason: collision with root package name */
    private int f565z;

    /* renamed from: i, reason: collision with root package name */
    private int f548i = 4096;

    /* renamed from: k, reason: collision with root package name */
    private int f550k = 4096;

    /* renamed from: m, reason: collision with root package name */
    private int f552m = 0;

    /* renamed from: t, reason: collision with root package name */
    private ColorStateList f559t = null;

    /* renamed from: u, reason: collision with root package name */
    private PorterDuff.Mode f560u = null;

    /* renamed from: v, reason: collision with root package name */
    private boolean f561v = false;

    /* renamed from: w, reason: collision with root package name */
    private boolean f562w = false;

    /* renamed from: x, reason: collision with root package name */
    private boolean f563x = false;

    /* renamed from: y, reason: collision with root package name */
    private int f564y = 16;
    private boolean D = false;

    /* compiled from: MenuItemImpl.java */
    class a implements b.InterfaceC0022b {
        a() {
        }

        @Override // androidx.core.view.b.InterfaceC0022b
        public void onActionProviderVisibilityChanged(boolean z2) {
            g gVar = g.this;
            gVar.f553n.J(gVar);
        }
    }

    g(e eVar, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6) {
        this.f553n = eVar;
        this.f540a = i3;
        this.f541b = i2;
        this.f542c = i4;
        this.f543d = i5;
        this.f544e = charSequence;
        this.f565z = i6;
    }

    private static void d(StringBuilder sb, int i2, int i3, String str) {
        if ((i2 & i3) == i3) {
            sb.append(str);
        }
    }

    private Drawable e(Drawable drawable) {
        if (drawable != null && this.f563x && (this.f561v || this.f562w)) {
            drawable = androidx.core.graphics.drawable.a.p(drawable).mutate();
            if (this.f561v) {
                androidx.core.graphics.drawable.a.n(drawable, this.f559t);
            }
            if (this.f562w) {
                androidx.core.graphics.drawable.a.o(drawable, this.f560u);
            }
            this.f563x = false;
        }
        return drawable;
    }

    boolean A() {
        return this.f553n.H() && g() != 0;
    }

    public boolean B() {
        return (this.f565z & 4) == 4;
    }

    @Override // n.b
    @NonNull
    public n.b a(androidx.core.view.b bVar) {
        androidx.core.view.b bVar2 = this.B;
        if (bVar2 != null) {
            bVar2.h();
        }
        this.A = null;
        this.B = bVar;
        this.f553n.K(true);
        androidx.core.view.b bVar3 = this.B;
        if (bVar3 != null) {
            bVar3.j(new a());
        }
        return this;
    }

    @Override // n.b
    public androidx.core.view.b b() {
        return this.B;
    }

    public void c() {
        this.f553n.I(this);
    }

    @Override // n.b, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.f565z & 8) == 0) {
            return false;
        }
        if (this.A == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f553n.f(this);
        }
        return false;
    }

    @Override // n.b, android.view.MenuItem
    public boolean expandActionView() {
        if (!j()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f553n.k(this);
        }
        return false;
    }

    public int f() {
        return this.f543d;
    }

    char g() {
        return this.f553n.G() ? this.f549j : this.f547h;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // n.b, android.view.MenuItem
    public View getActionView() {
        View view = this.A;
        if (view != null) {
            return view;
        }
        androidx.core.view.b bVar = this.B;
        if (bVar == null) {
            return null;
        }
        View viewD = bVar.d(this);
        this.A = viewD;
        return viewD;
    }

    @Override // n.b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f550k;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f549j;
    }

    @Override // n.b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f557r;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f541b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        Drawable drawable = this.f551l;
        if (drawable != null) {
            return e(drawable);
        }
        if (this.f552m == 0) {
            return null;
        }
        Drawable drawableB = e.a.b(this.f553n.u(), this.f552m);
        this.f552m = 0;
        this.f551l = drawableB;
        return e(drawableB);
    }

    @Override // n.b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f559t;
    }

    @Override // n.b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f560u;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f546g;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.f540a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.E;
    }

    @Override // n.b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f548i;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f547h;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f542c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.f554o;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.f544e;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f545f;
        return charSequence != null ? charSequence : this.f544e;
    }

    @Override // n.b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f558s;
    }

    String h() {
        char cG = g();
        if (cG == 0) {
            return "";
        }
        Resources resources = this.f553n.u().getResources();
        StringBuilder sb = new StringBuilder();
        if (ViewConfiguration.get(this.f553n.u()).hasPermanentMenuKey()) {
            sb.append(resources.getString(R$string.abc_prepend_shortcut_label));
        }
        int i2 = this.f553n.G() ? this.f550k : this.f548i;
        d(sb, i2, 65536, resources.getString(R$string.abc_menu_meta_shortcut_label));
        d(sb, i2, 4096, resources.getString(R$string.abc_menu_ctrl_shortcut_label));
        d(sb, i2, 2, resources.getString(R$string.abc_menu_alt_shortcut_label));
        d(sb, i2, 1, resources.getString(R$string.abc_menu_shift_shortcut_label));
        d(sb, i2, 4, resources.getString(R$string.abc_menu_sym_shortcut_label));
        d(sb, i2, 8, resources.getString(R$string.abc_menu_function_shortcut_label));
        if (cG == '\b') {
            sb.append(resources.getString(R$string.abc_menu_delete_shortcut_label));
        } else if (cG == '\n') {
            sb.append(resources.getString(R$string.abc_menu_enter_shortcut_label));
        } else if (cG != ' ') {
            sb.append(cG);
        } else {
            sb.append(resources.getString(R$string.abc_menu_space_shortcut_label));
        }
        return sb.toString();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f554o != null;
    }

    CharSequence i(l.a aVar) {
        return (aVar == null || !aVar.a()) ? getTitle() : getTitleCondensed();
    }

    @Override // n.b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.D;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f564y & 1) == 1;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f564y & 2) == 2;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f564y & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        androidx.core.view.b bVar = this.B;
        return (bVar == null || !bVar.g()) ? (this.f564y & 8) == 0 : (this.f564y & 8) == 0 && this.B.b();
    }

    public boolean j() {
        androidx.core.view.b bVar;
        if ((this.f565z & 8) == 0) {
            return false;
        }
        if (this.A == null && (bVar = this.B) != null) {
            this.A = bVar.d(this);
        }
        return this.A != null;
    }

    public boolean k() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.f556q;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        e eVar = this.f553n;
        if (eVar.h(eVar, this)) {
            return true;
        }
        Runnable runnable = this.f555p;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.f546g != null) {
            try {
                this.f553n.u().startActivity(this.f546g);
                return true;
            } catch (ActivityNotFoundException e2) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e2);
            }
        }
        androidx.core.view.b bVar = this.B;
        return bVar != null && bVar.e();
    }

    public boolean l() {
        return (this.f564y & 32) == 32;
    }

    public boolean m() {
        return (this.f564y & 4) != 0;
    }

    public boolean n() {
        return (this.f565z & 1) == 1;
    }

    public boolean o() {
        return (this.f565z & 2) == 2;
    }

    @Override // n.b, android.view.MenuItem
    @NonNull
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public n.b setActionView(int i2) {
        Context contextU = this.f553n.u();
        setActionView(LayoutInflater.from(contextU).inflate(i2, (ViewGroup) new LinearLayout(contextU), false));
        return this;
    }

    @Override // n.b, android.view.MenuItem
    @NonNull
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public n.b setActionView(View view) {
        int i2;
        this.A = view;
        this.B = null;
        if (view != null && view.getId() == -1 && (i2 = this.f540a) > 0) {
            view.setId(i2);
        }
        this.f553n.I(this);
        return this;
    }

    public void r(boolean z2) {
        this.D = z2;
        this.f553n.K(false);
    }

    void s(boolean z2) {
        int i2 = this.f564y;
        int i3 = (z2 ? 2 : 0) | (i2 & (-3));
        this.f564y = i3;
        if (i2 != i3) {
            this.f553n.K(false);
        }
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2) {
        if (this.f549j == c2) {
            return this;
        }
        this.f549j = Character.toLowerCase(c2);
        this.f553n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z2) {
        int i2 = this.f564y;
        int i3 = (z2 ? 1 : 0) | (i2 & (-2));
        this.f564y = i3;
        if (i2 != i3) {
            this.f553n.K(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z2) {
        if ((this.f564y & 4) != 0) {
            this.f553n.T(this);
        } else {
            s(z2);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z2) {
        if (z2) {
            this.f564y |= 16;
        } else {
            this.f564y &= -17;
        }
        this.f553n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f552m = 0;
        this.f551l = drawable;
        this.f563x = true;
        this.f553n.K(false);
        return this;
    }

    @Override // n.b, android.view.MenuItem
    @NonNull
    public MenuItem setIconTintList(@Nullable ColorStateList colorStateList) {
        this.f559t = colorStateList;
        this.f561v = true;
        this.f563x = true;
        this.f553n.K(false);
        return this;
    }

    @Override // n.b, android.view.MenuItem
    @NonNull
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f560u = mode;
        this.f562w = true;
        this.f563x = true;
        this.f553n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f546g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2) {
        if (this.f547h == c2) {
            return this;
        }
        this.f547h = c2;
        this.f553n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.C = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f556q = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3) {
        this.f547h = c2;
        this.f549j = Character.toLowerCase(c3);
        this.f553n.K(false);
        return this;
    }

    @Override // n.b, android.view.MenuItem
    public void setShowAsAction(int i2) {
        int i3 = i2 & 3;
        if (i3 != 0 && i3 != 1 && i3 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.f565z = i2;
        this.f553n.I(this);
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f544e = charSequence;
        this.f553n.K(false);
        p pVar = this.f554o;
        if (pVar != null) {
            pVar.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f545f = charSequence;
        this.f553n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z2) {
        if (y(z2)) {
            this.f553n.J(this);
        }
        return this;
    }

    public void t(boolean z2) {
        this.f564y = (z2 ? 4 : 0) | (this.f564y & (-5));
    }

    public String toString() {
        CharSequence charSequence = this.f544e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public void u(boolean z2) {
        if (z2) {
            this.f564y |= 32;
        } else {
            this.f564y &= -33;
        }
    }

    void v(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.E = contextMenuInfo;
    }

    @Override // n.b, android.view.MenuItem
    @NonNull
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public n.b setShowAsActionFlags(int i2) {
        setShowAsAction(i2);
        return this;
    }

    public void x(p pVar) {
        this.f554o = pVar;
        pVar.setHeaderTitle(getTitle());
    }

    boolean y(boolean z2) {
        int i2 = this.f564y;
        int i3 = (z2 ? 0 : 8) | (i2 & (-9));
        this.f564y = i3;
        return i2 != i3;
    }

    public boolean z() {
        return this.f553n.A();
    }

    @Override // android.view.MenuItem
    @NonNull
    public n.b setContentDescription(CharSequence charSequence) {
        this.f557r = charSequence;
        this.f553n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    @NonNull
    public n.b setTooltipText(CharSequence charSequence) {
        this.f558s = charSequence;
        this.f553n.K(false);
        return this;
    }

    @Override // n.b, android.view.MenuItem
    @NonNull
    public MenuItem setAlphabeticShortcut(char c2, int i2) {
        if (this.f549j == c2 && this.f550k == i2) {
            return this;
        }
        this.f549j = Character.toLowerCase(c2);
        this.f550k = KeyEvent.normalizeMetaState(i2);
        this.f553n.K(false);
        return this;
    }

    @Override // n.b, android.view.MenuItem
    @NonNull
    public MenuItem setNumericShortcut(char c2, int i2) {
        if (this.f547h == c2 && this.f548i == i2) {
            return this;
        }
        this.f547h = c2;
        this.f548i = KeyEvent.normalizeMetaState(i2);
        this.f553n.K(false);
        return this;
    }

    @Override // n.b, android.view.MenuItem
    @NonNull
    public MenuItem setShortcut(char c2, char c3, int i2, int i3) {
        this.f547h = c2;
        this.f548i = KeyEvent.normalizeMetaState(i2);
        this.f549j = Character.toLowerCase(c3);
        this.f550k = KeyEvent.normalizeMetaState(i3);
        this.f553n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i2) {
        this.f551l = null;
        this.f552m = i2;
        this.f563x = true;
        this.f553n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i2) {
        return setTitle(this.f553n.u().getString(i2));
    }
}
