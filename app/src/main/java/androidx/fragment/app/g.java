package androidx.fragment.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.f0;

/* compiled from: FragmentController.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private final i<?> f2249a;

    private g(i<?> iVar) {
        this.f2249a = iVar;
    }

    @NonNull
    public static g b(@NonNull i<?> iVar) {
        return new g((i) androidx.core.util.h.g(iVar, "callbacks == null"));
    }

    public void a(@Nullable Fragment fragment) {
        i<?> iVar = this.f2249a;
        iVar.f2255i.k(iVar, iVar, fragment);
    }

    public void c() {
        this.f2249a.f2255i.z();
    }

    public void d(@NonNull Configuration configuration) {
        this.f2249a.f2255i.B(configuration);
    }

    public boolean e(@NonNull MenuItem menuItem) {
        return this.f2249a.f2255i.C(menuItem);
    }

    public void f() {
        this.f2249a.f2255i.D();
    }

    public boolean g(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
        return this.f2249a.f2255i.E(menu, menuInflater);
    }

    public void h() {
        this.f2249a.f2255i.F();
    }

    public void i() {
        this.f2249a.f2255i.H();
    }

    public void j(boolean z2) {
        this.f2249a.f2255i.I(z2);
    }

    public boolean k(@NonNull MenuItem menuItem) {
        return this.f2249a.f2255i.K(menuItem);
    }

    public void l(@NonNull Menu menu) {
        this.f2249a.f2255i.L(menu);
    }

    public void m() {
        this.f2249a.f2255i.N();
    }

    public void n(boolean z2) {
        this.f2249a.f2255i.O(z2);
    }

    public boolean o(@NonNull Menu menu) {
        return this.f2249a.f2255i.P(menu);
    }

    public void p() {
        this.f2249a.f2255i.R();
    }

    public void q() {
        this.f2249a.f2255i.S();
    }

    public void r() {
        this.f2249a.f2255i.U();
    }

    public boolean s() {
        return this.f2249a.f2255i.b0(true);
    }

    @NonNull
    public FragmentManager t() {
        return this.f2249a.f2255i;
    }

    public void u() {
        this.f2249a.f2255i.T0();
    }

    @Nullable
    public View v(@Nullable View view, @NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        return this.f2249a.f2255i.u0().onCreateView(view, str, context, attributeSet);
    }

    public void w(@Nullable Parcelable parcelable) {
        i<?> iVar = this.f2249a;
        if (!(iVar instanceof f0)) {
            throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
        }
        iVar.f2255i.g1(parcelable);
    }

    @Nullable
    public Parcelable x() {
        return this.f2249a.f2255i.i1();
    }
}
