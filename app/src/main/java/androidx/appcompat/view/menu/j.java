package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.annotation.AttrRes;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.R$dimen;
import androidx.appcompat.view.menu.k;
import androidx.core.view.ViewCompat;

/* compiled from: MenuPopupHelper.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private final Context f579a;

    /* renamed from: b, reason: collision with root package name */
    private final e f580b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f581c;

    /* renamed from: d, reason: collision with root package name */
    private final int f582d;

    /* renamed from: e, reason: collision with root package name */
    private final int f583e;

    /* renamed from: f, reason: collision with root package name */
    private View f584f;

    /* renamed from: g, reason: collision with root package name */
    private int f585g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f586h;

    /* renamed from: i, reason: collision with root package name */
    private k.a f587i;

    /* renamed from: j, reason: collision with root package name */
    private i f588j;

    /* renamed from: k, reason: collision with root package name */
    private PopupWindow.OnDismissListener f589k;

    /* renamed from: l, reason: collision with root package name */
    private final PopupWindow.OnDismissListener f590l;

    /* compiled from: MenuPopupHelper.java */
    class a implements PopupWindow.OnDismissListener {
        a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            j.this.e();
        }
    }

    /* compiled from: MenuPopupHelper.java */
    @RequiresApi(17)
    static class b {
        @DoNotInline
        static void a(Display display, Point point) {
            display.getRealSize(point);
        }
    }

    public j(@NonNull Context context, @NonNull e eVar, @NonNull View view, boolean z2, @AttrRes int i2) {
        this(context, eVar, view, z2, i2, 0);
    }

    @NonNull
    private i a() {
        Display defaultDisplay = ((WindowManager) this.f579a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        b.a(defaultDisplay, point);
        i cascadingMenuPopup = Math.min(point.x, point.y) >= this.f579a.getResources().getDimensionPixelSize(R$dimen.abc_cascading_menus_min_smallest_width) ? new CascadingMenuPopup(this.f579a, this.f584f, this.f582d, this.f583e, this.f581c) : new o(this.f579a, this.f580b, this.f584f, this.f582d, this.f583e, this.f581c);
        cascadingMenuPopup.l(this.f580b);
        cascadingMenuPopup.u(this.f590l);
        cascadingMenuPopup.p(this.f584f);
        cascadingMenuPopup.k(this.f587i);
        cascadingMenuPopup.r(this.f586h);
        cascadingMenuPopup.s(this.f585g);
        return cascadingMenuPopup;
    }

    private void l(int i2, int i3, boolean z2, boolean z3) {
        i iVarC = c();
        iVarC.v(z3);
        if (z2) {
            if ((androidx.core.view.d.a(this.f585g, ViewCompat.r(this.f584f)) & 7) == 5) {
                i2 -= this.f584f.getWidth();
            }
            iVarC.t(i2);
            iVarC.w(i3);
            int i4 = (int) ((this.f579a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            iVarC.q(new Rect(i2 - i4, i3 - i4, i2 + i4, i3 + i4));
        }
        iVarC.d();
    }

    public void b() {
        if (d()) {
            this.f588j.dismiss();
        }
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public i c() {
        if (this.f588j == null) {
            this.f588j = a();
        }
        return this.f588j;
    }

    public boolean d() {
        i iVar = this.f588j;
        return iVar != null && iVar.b();
    }

    protected void e() {
        this.f588j = null;
        PopupWindow.OnDismissListener onDismissListener = this.f589k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void f(@NonNull View view) {
        this.f584f = view;
    }

    public void g(boolean z2) {
        this.f586h = z2;
        i iVar = this.f588j;
        if (iVar != null) {
            iVar.r(z2);
        }
    }

    public void h(int i2) {
        this.f585g = i2;
    }

    public void i(@Nullable PopupWindow.OnDismissListener onDismissListener) {
        this.f589k = onDismissListener;
    }

    public void j(@Nullable k.a aVar) {
        this.f587i = aVar;
        i iVar = this.f588j;
        if (iVar != null) {
            iVar.k(aVar);
        }
    }

    public void k() {
        if (!m()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public boolean m() {
        if (d()) {
            return true;
        }
        if (this.f584f == null) {
            return false;
        }
        l(0, 0, false, false);
        return true;
    }

    public boolean n(int i2, int i3) {
        if (d()) {
            return true;
        }
        if (this.f584f == null) {
            return false;
        }
        l(i2, i3, true, true);
        return true;
    }

    public j(@NonNull Context context, @NonNull e eVar, @NonNull View view, boolean z2, @AttrRes int i2, @StyleRes int i3) {
        this.f585g = 8388611;
        this.f590l = new a();
        this.f579a = context;
        this.f580b = eVar;
        this.f584f = view;
        this.f581c = z2;
        this.f582d = i2;
        this.f583e = i3;
    }
}
