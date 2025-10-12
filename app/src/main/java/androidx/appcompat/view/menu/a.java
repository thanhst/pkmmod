package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;

/* compiled from: ActionMenuItem.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class a implements n.b {

    /* renamed from: a, reason: collision with root package name */
    private final int f466a;

    /* renamed from: b, reason: collision with root package name */
    private final int f467b;

    /* renamed from: c, reason: collision with root package name */
    private final int f468c;

    /* renamed from: d, reason: collision with root package name */
    private CharSequence f469d;

    /* renamed from: e, reason: collision with root package name */
    private CharSequence f470e;

    /* renamed from: f, reason: collision with root package name */
    private Intent f471f;

    /* renamed from: g, reason: collision with root package name */
    private char f472g;

    /* renamed from: i, reason: collision with root package name */
    private char f474i;

    /* renamed from: k, reason: collision with root package name */
    private Drawable f476k;

    /* renamed from: l, reason: collision with root package name */
    private Context f477l;

    /* renamed from: m, reason: collision with root package name */
    private MenuItem.OnMenuItemClickListener f478m;

    /* renamed from: n, reason: collision with root package name */
    private CharSequence f479n;

    /* renamed from: o, reason: collision with root package name */
    private CharSequence f480o;

    /* renamed from: h, reason: collision with root package name */
    private int f473h = 4096;

    /* renamed from: j, reason: collision with root package name */
    private int f475j = 4096;

    /* renamed from: p, reason: collision with root package name */
    private ColorStateList f481p = null;

    /* renamed from: q, reason: collision with root package name */
    private PorterDuff.Mode f482q = null;

    /* renamed from: r, reason: collision with root package name */
    private boolean f483r = false;

    /* renamed from: s, reason: collision with root package name */
    private boolean f484s = false;

    /* renamed from: t, reason: collision with root package name */
    private int f485t = 16;

    public a(Context context, int i2, int i3, int i4, int i5, CharSequence charSequence) {
        this.f477l = context;
        this.f466a = i3;
        this.f467b = i2;
        this.f468c = i5;
        this.f469d = charSequence;
    }

    private void c() {
        Drawable drawable = this.f476k;
        if (drawable != null) {
            if (this.f483r || this.f484s) {
                Drawable drawableP = androidx.core.graphics.drawable.a.p(drawable);
                this.f476k = drawableP;
                Drawable drawableMutate = drawableP.mutate();
                this.f476k = drawableMutate;
                if (this.f483r) {
                    androidx.core.graphics.drawable.a.n(drawableMutate, this.f481p);
                }
                if (this.f484s) {
                    androidx.core.graphics.drawable.a.o(this.f476k, this.f482q);
                }
            }
        }
    }

    @Override // n.b
    @NonNull
    public n.b a(androidx.core.view.b bVar) {
        throw new UnsupportedOperationException();
    }

    @Override // n.b
    public androidx.core.view.b b() {
        return null;
    }

    @Override // n.b, android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // n.b, android.view.MenuItem
    @NonNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public n.b setActionView(int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // n.b, android.view.MenuItem
    @NonNull
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public n.b setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // n.b, android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    @Override // n.b, android.view.MenuItem
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public n.b setShowAsActionFlags(int i2) {
        setShowAsAction(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // n.b, android.view.MenuItem
    public View getActionView() {
        return null;
    }

    @Override // n.b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f475j;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f474i;
    }

    @Override // n.b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f479n;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f467b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f476k;
    }

    @Override // n.b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f481p;
    }

    @Override // n.b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f482q;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f471f;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f466a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // n.b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f473h;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f472g;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f468c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f469d;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f470e;
        return charSequence != null ? charSequence : this.f469d;
    }

    @Override // n.b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f480o;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    @Override // n.b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f485t & 1) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f485t & 2) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f485t & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.f485t & 8) == 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2) {
        this.f474i = Character.toLowerCase(c2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z2) {
        this.f485t = (z2 ? 1 : 0) | (this.f485t & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z2) {
        this.f485t = (z2 ? 2 : 0) | (this.f485t & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z2) {
        this.f485t = (z2 ? 16 : 0) | (this.f485t & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f476k = drawable;
        c();
        return this;
    }

    @Override // n.b, android.view.MenuItem
    @NonNull
    public MenuItem setIconTintList(@Nullable ColorStateList colorStateList) {
        this.f481p = colorStateList;
        this.f483r = true;
        c();
        return this;
    }

    @Override // n.b, android.view.MenuItem
    @NonNull
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f482q = mode;
        this.f484s = true;
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f471f = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2) {
        this.f472g = c2;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f478m = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3) {
        this.f472g = c2;
        this.f474i = Character.toLowerCase(c3);
        return this;
    }

    @Override // n.b, android.view.MenuItem
    public void setShowAsAction(int i2) {
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f469d = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f470e = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z2) {
        this.f485t = (this.f485t & 8) | (z2 ? 0 : 8);
        return this;
    }

    @Override // n.b, android.view.MenuItem
    @NonNull
    public MenuItem setAlphabeticShortcut(char c2, int i2) {
        this.f474i = Character.toLowerCase(c2);
        this.f475j = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    @Override // android.view.MenuItem
    @NonNull
    public n.b setContentDescription(CharSequence charSequence) {
        this.f479n = charSequence;
        return this;
    }

    @Override // n.b, android.view.MenuItem
    @NonNull
    public MenuItem setNumericShortcut(char c2, int i2) {
        this.f472g = c2;
        this.f473h = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i2) {
        this.f469d = this.f477l.getResources().getString(i2);
        return this;
    }

    @Override // android.view.MenuItem
    @NonNull
    public n.b setTooltipText(CharSequence charSequence) {
        this.f480o = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i2) {
        this.f476k = ContextCompat.d(this.f477l, i2);
        c();
        return this;
    }

    @Override // n.b, android.view.MenuItem
    @NonNull
    public MenuItem setShortcut(char c2, char c3, int i2, int i3) {
        this.f472g = c2;
        this.f473h = KeyEvent.normalizeMetaState(i2);
        this.f474i = Character.toLowerCase(c3);
        this.f475j = KeyEvent.normalizeMetaState(i3);
        return this;
    }
}
