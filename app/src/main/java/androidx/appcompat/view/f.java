package androidx.appcompat.view;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.b;
import java.util.ArrayList;

/* compiled from: SupportActionModeWrapper.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class f extends ActionMode {

    /* renamed from: a, reason: collision with root package name */
    final Context f346a;

    /* renamed from: b, reason: collision with root package name */
    final b f347b;

    /* compiled from: SupportActionModeWrapper.java */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class a implements b.a {

        /* renamed from: a, reason: collision with root package name */
        final ActionMode.Callback f348a;

        /* renamed from: b, reason: collision with root package name */
        final Context f349b;

        /* renamed from: c, reason: collision with root package name */
        final ArrayList<f> f350c = new ArrayList<>();

        /* renamed from: d, reason: collision with root package name */
        final androidx.collection.g<Menu, Menu> f351d = new androidx.collection.g<>();

        public a(Context context, ActionMode.Callback callback) {
            this.f349b = context;
            this.f348a = callback;
        }

        private Menu f(Menu menu) {
            Menu menu2 = this.f351d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            androidx.appcompat.view.menu.m mVar = new androidx.appcompat.view.menu.m(this.f349b, (n.a) menu);
            this.f351d.put(menu, mVar);
            return mVar;
        }

        @Override // androidx.appcompat.view.b.a
        public boolean a(b bVar, Menu menu) {
            return this.f348a.onPrepareActionMode(e(bVar), f(menu));
        }

        @Override // androidx.appcompat.view.b.a
        public void b(b bVar) {
            this.f348a.onDestroyActionMode(e(bVar));
        }

        @Override // androidx.appcompat.view.b.a
        public boolean c(b bVar, MenuItem menuItem) {
            return this.f348a.onActionItemClicked(e(bVar), new androidx.appcompat.view.menu.h(this.f349b, (n.b) menuItem));
        }

        @Override // androidx.appcompat.view.b.a
        public boolean d(b bVar, Menu menu) {
            return this.f348a.onCreateActionMode(e(bVar), f(menu));
        }

        public ActionMode e(b bVar) {
            int size = this.f350c.size();
            for (int i2 = 0; i2 < size; i2++) {
                f fVar = this.f350c.get(i2);
                if (fVar != null && fVar.f347b == bVar) {
                    return fVar;
                }
            }
            f fVar2 = new f(this.f349b, bVar);
            this.f350c.add(fVar2);
            return fVar2;
        }
    }

    public f(Context context, b bVar) {
        this.f346a = context;
        this.f347b = bVar;
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.f347b.c();
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.f347b.d();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return new androidx.appcompat.view.menu.m(this.f346a, (n.a) this.f347b.e());
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.f347b.f();
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.f347b.g();
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.f347b.h();
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.f347b.i();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.f347b.j();
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.f347b.k();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.f347b.l();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.f347b.m(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f347b.o(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.f347b.p(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f347b.r(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z2) {
        this.f347b.s(z2);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i2) {
        this.f347b.n(i2);
    }

    @Override // android.view.ActionMode
    public void setTitle(int i2) {
        this.f347b.q(i2);
    }
}
