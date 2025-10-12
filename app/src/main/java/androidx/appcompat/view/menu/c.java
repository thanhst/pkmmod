package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;

/* compiled from: BaseMenuWrapper.java */
/* loaded from: classes.dex */
abstract class c {

    /* renamed from: a, reason: collision with root package name */
    final Context f496a;

    /* renamed from: b, reason: collision with root package name */
    private androidx.collection.g<n.b, MenuItem> f497b;

    /* renamed from: c, reason: collision with root package name */
    private androidx.collection.g<n.c, SubMenu> f498c;

    c(Context context) {
        this.f496a = context;
    }

    final MenuItem c(MenuItem menuItem) {
        if (!(menuItem instanceof n.b)) {
            return menuItem;
        }
        n.b bVar = (n.b) menuItem;
        if (this.f497b == null) {
            this.f497b = new androidx.collection.g<>();
        }
        MenuItem menuItem2 = this.f497b.get(bVar);
        if (menuItem2 != null) {
            return menuItem2;
        }
        h hVar = new h(this.f496a, bVar);
        this.f497b.put(bVar, hVar);
        return hVar;
    }

    final SubMenu d(SubMenu subMenu) {
        if (!(subMenu instanceof n.c)) {
            return subMenu;
        }
        n.c cVar = (n.c) subMenu;
        if (this.f498c == null) {
            this.f498c = new androidx.collection.g<>();
        }
        SubMenu subMenu2 = this.f498c.get(cVar);
        if (subMenu2 != null) {
            return subMenu2;
        }
        q qVar = new q(this.f496a, cVar);
        this.f498c.put(cVar, qVar);
        return qVar;
    }

    final void e() {
        androidx.collection.g<n.b, MenuItem> gVar = this.f497b;
        if (gVar != null) {
            gVar.clear();
        }
        androidx.collection.g<n.c, SubMenu> gVar2 = this.f498c;
        if (gVar2 != null) {
            gVar2.clear();
        }
    }

    final void f(int i2) {
        if (this.f497b == null) {
            return;
        }
        int i3 = 0;
        while (i3 < this.f497b.size()) {
            if (this.f497b.keyAt(i3).getGroupId() == i2) {
                this.f497b.removeAt(i3);
                i3--;
            }
            i3++;
        }
    }

    final void g(int i2) {
        if (this.f497b == null) {
            return;
        }
        for (int i3 = 0; i3 < this.f497b.size(); i3++) {
            if (this.f497b.keyAt(i3).getItemId() == i2) {
                this.f497b.removeAt(i3);
                return;
            }
        }
    }
}
