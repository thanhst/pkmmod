package androidx.appcompat.app;

import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R$attr;
import androidx.appcompat.view.b;
import androidx.core.view.e;

/* compiled from: AppCompatDialog.java */
/* loaded from: classes.dex */
public class k extends android.view.f implements b {

    /* renamed from: g, reason: collision with root package name */
    private AppCompatDelegate f257g;

    /* renamed from: h, reason: collision with root package name */
    private final e.a f258h;

    public k(@NonNull Context context, int i2) {
        super(context, h(context, i2));
        this.f258h = new e.a() { // from class: androidx.appcompat.app.j
            @Override // androidx.core.view.e.a
            public final boolean superDispatchKeyEvent(KeyEvent keyEvent) {
                return this.f256e.i(keyEvent);
            }
        };
        AppCompatDelegate appCompatDelegateG = g();
        appCompatDelegateG.L(h(context, i2));
        appCompatDelegateG.x(null);
    }

    private static int h(Context context, int i2) {
        if (i2 != 0) {
            return i2;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // androidx.appcompat.app.b
    public void a(androidx.appcompat.view.b bVar) {
    }

    @Override // android.app.Dialog
    public void addContentView(@NonNull View view, ViewGroup.LayoutParams layoutParams) {
        g().e(view, layoutParams);
    }

    @Override // androidx.appcompat.app.b
    public void b(androidx.appcompat.view.b bVar) {
    }

    @Override // androidx.appcompat.app.b
    @Nullable
    public androidx.appcompat.view.b d(b.a aVar) {
        return null;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        g().y();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return androidx.core.view.e.e(this.f258h, getWindow().getDecorView(), this, keyEvent);
    }

    @Override // android.app.Dialog
    @Nullable
    public <T extends View> T findViewById(@IdRes int i2) {
        return (T) g().j(i2);
    }

    @NonNull
    public AppCompatDelegate g() {
        if (this.f257g == null) {
            this.f257g = AppCompatDelegate.i(this, this);
        }
        return this.f257g;
    }

    boolean i(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Dialog
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void invalidateOptionsMenu() {
        g().t();
    }

    public boolean j(int i2) {
        return g().G(i2);
    }

    @Override // android.view.f, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        g().s();
        super.onCreate(bundle);
        g().x(bundle);
    }

    @Override // android.view.f, android.app.Dialog
    protected void onStop() {
        super.onStop();
        g().D();
    }

    @Override // android.app.Dialog
    public void setContentView(@LayoutRes int i2) {
        g().H(i2);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        g().M(charSequence);
    }

    @Override // android.app.Dialog
    public void setContentView(@NonNull View view) {
        g().I(view);
    }

    @Override // android.app.Dialog
    public void setContentView(@NonNull View view, ViewGroup.LayoutParams layoutParams) {
        g().J(view, layoutParams);
    }

    @Override // android.app.Dialog
    public void setTitle(int i2) {
        super.setTitle(i2);
        g().M(getContext().getString(i2));
    }
}
