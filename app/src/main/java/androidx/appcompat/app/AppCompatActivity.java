package androidx.appcompat.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.C0073l;
import android.view.C0077b;
import android.view.C0080e;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.CallSuper;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.b;
import androidx.appcompat.widget.u2;
import androidx.core.app.u;
import androidx.core.app.z;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.g0;
import androidx.lifecycle.h0;

/* loaded from: classes.dex */
public class AppCompatActivity extends FragmentActivity implements androidx.appcompat.app.b, z.a {

    /* renamed from: e, reason: collision with root package name */
    private AppCompatDelegate f161e;

    /* renamed from: f, reason: collision with root package name */
    private Resources f162f;

    class a implements C0077b.c {
        a() {
        }

        @Override // android.view.C0077b.c
        @NonNull
        public Bundle a() {
            Bundle bundle = new Bundle();
            AppCompatActivity.this.g().B(bundle);
            return bundle;
        }
    }

    class b implements c.b {
        b() {
        }

        @Override // c.b
        public void a(@NonNull Context context) {
            AppCompatDelegate appCompatDelegateG = AppCompatActivity.this.g();
            appCompatDelegateG.s();
            appCompatDelegateG.x(AppCompatActivity.this.getSavedStateRegistry().b("androidx:appcompat"));
        }
    }

    public AppCompatActivity() {
        i();
    }

    private void i() {
        getSavedStateRegistry().h("androidx:appcompat", new a());
        addOnContextAvailableListener(new b());
    }

    private void initViewTreeOwners() {
        g0.a(getWindow().getDecorView(), this);
        h0.a(getWindow().getDecorView(), this);
        C0080e.a(getWindow().getDecorView(), this);
        C0073l.a(getWindow().getDecorView(), this);
    }

    private boolean p(KeyEvent keyEvent) {
        Window window;
        return (Build.VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || KeyEvent.isModifierKey(keyEvent.getKeyCode()) || (window = getWindow()) == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) ? false : true;
    }

    @Override // androidx.appcompat.app.b
    @CallSuper
    public void a(@NonNull androidx.appcompat.view.b bVar) {
    }

    @Override // android.view.ComponentActivity, android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        g().e(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(g().g(context));
    }

    @Override // androidx.appcompat.app.b
    @CallSuper
    public void b(@NonNull androidx.appcompat.view.b bVar) {
    }

    @Override // androidx.core.app.z.a
    @Nullable
    public Intent c() {
        return u.a(this);
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        ActionBar actionBarH = h();
        if (getWindow().hasFeature(0)) {
            if (actionBarH == null || !actionBarH.g()) {
                super.closeOptionsMenu();
            }
        }
    }

    @Override // androidx.appcompat.app.b
    @Nullable
    public androidx.appcompat.view.b d(@NonNull b.a aVar) {
        return null;
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        ActionBar actionBarH = h();
        if (keyCode == 82 && actionBarH != null && actionBarH.p(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(@IdRes int i2) {
        return (T) g().j(i2);
    }

    @NonNull
    public AppCompatDelegate g() {
        if (this.f161e == null) {
            this.f161e = AppCompatDelegate.h(this, this);
        }
        return this.f161e;
    }

    @Override // android.app.Activity
    @NonNull
    public MenuInflater getMenuInflater() {
        return g().p();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.f162f == null && u2.c()) {
            this.f162f = new u2(this, super.getResources());
        }
        Resources resources = this.f162f;
        return resources == null ? super.getResources() : resources;
    }

    @Nullable
    public ActionBar h() {
        return g().r();
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        g().t();
    }

    public void j(@NonNull z zVar) {
        zVar.b(this);
    }

    protected void k(@NonNull androidx.core.os.g gVar) {
    }

    protected void l(int i2) {
    }

    public void m(@NonNull z zVar) {
    }

    @Deprecated
    public void n() {
    }

    public boolean o() {
        Intent intentC = c();
        if (intentC == null) {
            return false;
        }
        if (!r(intentC)) {
            q(intentC);
            return true;
        }
        z zVarD = z.d(this);
        j(zVarD);
        m(zVarD);
        zVarD.e();
        try {
            androidx.core.app.b.l(this);
            return true;
        } catch (IllegalStateException unused) {
            finish();
            return true;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.view.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        g().w(configuration);
        if (this.f162f != null) {
            this.f162f.updateConfiguration(super.getResources().getConfiguration(), super.getResources().getDisplayMetrics());
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        n();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        g().y();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (p(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.view.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i2, @NonNull MenuItem menuItem) {
        if (super.onMenuItemSelected(i2, menuItem)) {
            return true;
        }
        ActionBar actionBarH = h();
        if (menuItem.getItemId() != 16908332 || actionBarH == null || (actionBarH.j() & 4) == 0) {
            return false;
        }
        return o();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i2, Menu menu) {
        return super.onMenuOpened(i2, menu);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.view.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i2, @NonNull Menu menu) {
        super.onPanelClosed(i2, menu);
    }

    @Override // android.app.Activity
    protected void onPostCreate(@Nullable Bundle bundle) {
        super.onPostCreate(bundle);
        g().z(bundle);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        g().A();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        g().C();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        g().D();
    }

    @Override // android.app.Activity
    protected void onTitleChanged(CharSequence charSequence, int i2) {
        super.onTitleChanged(charSequence, i2);
        g().M(charSequence);
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        ActionBar actionBarH = h();
        if (getWindow().hasFeature(0)) {
            if (actionBarH == null || !actionBarH.q()) {
                super.openOptionsMenu();
            }
        }
    }

    public void q(@NonNull Intent intent) {
        u.e(this, intent);
    }

    public boolean r(@NonNull Intent intent) {
        return u.f(this, intent);
    }

    @Override // android.view.ComponentActivity, android.app.Activity
    public void setContentView(@LayoutRes int i2) {
        initViewTreeOwners();
        g().H(i2);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(@StyleRes int i2) {
        super.setTheme(i2);
        g().L(i2);
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void supportInvalidateOptionsMenu() {
        g().t();
    }

    @Override // android.view.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        initViewTreeOwners();
        g().I(view);
    }

    @Override // android.view.ComponentActivity, android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        g().J(view, layoutParams);
    }
}
