package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.appcompat.R$layout;
import androidx.appcompat.app.a;
import androidx.appcompat.view.menu.k;

/* compiled from: MenuDialogHelper.java */
/* loaded from: classes.dex */
class f implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, k.a {

    /* renamed from: e, reason: collision with root package name */
    private e f536e;

    /* renamed from: f, reason: collision with root package name */
    private androidx.appcompat.app.a f537f;

    /* renamed from: g, reason: collision with root package name */
    d f538g;

    /* renamed from: h, reason: collision with root package name */
    private k.a f539h;

    public f(e eVar) {
        this.f536e = eVar;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public void a(@NonNull e eVar, boolean z2) {
        if (z2 || eVar == this.f536e) {
            c();
        }
        k.a aVar = this.f539h;
        if (aVar != null) {
            aVar.a(eVar, z2);
        }
    }

    @Override // androidx.appcompat.view.menu.k.a
    public boolean b(@NonNull e eVar) {
        k.a aVar = this.f539h;
        if (aVar != null) {
            return aVar.b(eVar);
        }
        return false;
    }

    public void c() {
        androidx.appcompat.app.a aVar = this.f537f;
        if (aVar != null) {
            aVar.dismiss();
        }
    }

    public void d(IBinder iBinder) {
        e eVar = this.f536e;
        a.C0005a c0005a = new a.C0005a(eVar.u());
        d dVar = new d(c0005a.b(), R$layout.abc_list_menu_item_layout);
        this.f538g = dVar;
        dVar.k(this);
        this.f536e.b(this.f538g);
        c0005a.c(this.f538g.b(), this);
        View viewY = eVar.y();
        if (viewY != null) {
            c0005a.e(viewY);
        } else {
            c0005a.f(eVar.w()).l(eVar.x());
        }
        c0005a.i(this);
        androidx.appcompat.app.a aVarA = c0005a.a();
        this.f537f = aVarA;
        aVarA.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f537f.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f537f.show();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i2) {
        this.f536e.L((g) this.f538g.b().getItem(i2), 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f538g.a(this.f536e, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i2 == 82 || i2 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f537f.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f537f.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f536e.e(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f536e.performShortcut(i2, keyEvent, 0);
    }
}
