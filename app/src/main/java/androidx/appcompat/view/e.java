package androidx.appcompat.view;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.b;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* compiled from: StandaloneActionMode.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class e extends b implements e.a {

    /* renamed from: g, reason: collision with root package name */
    private Context f339g;

    /* renamed from: h, reason: collision with root package name */
    private ActionBarContextView f340h;

    /* renamed from: i, reason: collision with root package name */
    private b.a f341i;

    /* renamed from: j, reason: collision with root package name */
    private WeakReference<View> f342j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f343k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f344l;

    /* renamed from: m, reason: collision with root package name */
    private androidx.appcompat.view.menu.e f345m;

    public e(Context context, ActionBarContextView actionBarContextView, b.a aVar, boolean z2) {
        this.f339g = context;
        this.f340h = actionBarContextView;
        this.f341i = aVar;
        androidx.appcompat.view.menu.e eVarS = new androidx.appcompat.view.menu.e(actionBarContextView.getContext()).S(1);
        this.f345m = eVarS;
        eVarS.R(this);
        this.f344l = z2;
    }

    @Override // androidx.appcompat.view.menu.e.a
    public boolean a(@NonNull androidx.appcompat.view.menu.e eVar, @NonNull MenuItem menuItem) {
        return this.f341i.c(this, menuItem);
    }

    @Override // androidx.appcompat.view.menu.e.a
    public void b(@NonNull androidx.appcompat.view.menu.e eVar) {
        k();
        this.f340h.l();
    }

    @Override // androidx.appcompat.view.b
    public void c() {
        if (this.f343k) {
            return;
        }
        this.f343k = true;
        this.f341i.b(this);
    }

    @Override // androidx.appcompat.view.b
    public View d() {
        WeakReference<View> weakReference = this.f342j;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // androidx.appcompat.view.b
    public Menu e() {
        return this.f345m;
    }

    @Override // androidx.appcompat.view.b
    public MenuInflater f() {
        return new g(this.f340h.getContext());
    }

    @Override // androidx.appcompat.view.b
    public CharSequence g() {
        return this.f340h.getSubtitle();
    }

    @Override // androidx.appcompat.view.b
    public CharSequence i() {
        return this.f340h.getTitle();
    }

    @Override // androidx.appcompat.view.b
    public void k() {
        this.f341i.a(this, this.f345m);
    }

    @Override // androidx.appcompat.view.b
    public boolean l() {
        return this.f340h.j();
    }

    @Override // androidx.appcompat.view.b
    public void m(View view) {
        this.f340h.setCustomView(view);
        this.f342j = view != null ? new WeakReference<>(view) : null;
    }

    @Override // androidx.appcompat.view.b
    public void n(int i2) {
        o(this.f339g.getString(i2));
    }

    @Override // androidx.appcompat.view.b
    public void o(CharSequence charSequence) {
        this.f340h.setSubtitle(charSequence);
    }

    @Override // androidx.appcompat.view.b
    public void q(int i2) {
        r(this.f339g.getString(i2));
    }

    @Override // androidx.appcompat.view.b
    public void r(CharSequence charSequence) {
        this.f340h.setTitle(charSequence);
    }

    @Override // androidx.appcompat.view.b
    public void s(boolean z2) {
        super.s(z2);
        this.f340h.setTitleOptional(z2);
    }
}
