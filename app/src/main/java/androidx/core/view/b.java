package androidx.core.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* compiled from: ActionProvider.java */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private final Context f1746a;

    /* renamed from: b, reason: collision with root package name */
    private a f1747b;

    /* renamed from: c, reason: collision with root package name */
    private InterfaceC0022b f1748c;

    /* compiled from: ActionProvider.java */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface a {
    }

    /* compiled from: ActionProvider.java */
    /* renamed from: androidx.core.view.b$b, reason: collision with other inner class name */
    public interface InterfaceC0022b {
        void onActionProviderVisibilityChanged(boolean z2);
    }

    public b(@NonNull Context context) {
        this.f1746a = context;
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return true;
    }

    @NonNull
    public abstract View c();

    @NonNull
    public View d(@NonNull MenuItem menuItem) {
        return c();
    }

    public boolean e() {
        return false;
    }

    public void f(@NonNull SubMenu subMenu) {
    }

    public boolean g() {
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void h() {
        this.f1748c = null;
        this.f1747b = null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void i(@Nullable a aVar) {
        this.f1747b = aVar;
    }

    public void j(@Nullable InterfaceC0022b interfaceC0022b) {
        if (this.f1748c != null && interfaceC0022b != null) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f1748c = interfaceC0022b;
    }
}
