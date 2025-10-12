package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.view.menu.l;
import java.util.ArrayList;

/* compiled from: ListMenuPresenter.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class d implements k, AdapterView.OnItemClickListener {

    /* renamed from: e, reason: collision with root package name */
    Context f499e;

    /* renamed from: f, reason: collision with root package name */
    LayoutInflater f500f;

    /* renamed from: g, reason: collision with root package name */
    e f501g;

    /* renamed from: h, reason: collision with root package name */
    ExpandedMenuView f502h;

    /* renamed from: i, reason: collision with root package name */
    int f503i;

    /* renamed from: j, reason: collision with root package name */
    int f504j;

    /* renamed from: k, reason: collision with root package name */
    int f505k;

    /* renamed from: l, reason: collision with root package name */
    private k.a f506l;

    /* renamed from: m, reason: collision with root package name */
    a f507m;

    /* compiled from: ListMenuPresenter.java */
    private class a extends BaseAdapter {

        /* renamed from: e, reason: collision with root package name */
        private int f508e = -1;

        public a() {
            a();
        }

        void a() {
            g gVarV = d.this.f501g.v();
            if (gVarV != null) {
                ArrayList<g> arrayListZ = d.this.f501g.z();
                int size = arrayListZ.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (arrayListZ.get(i2) == gVarV) {
                        this.f508e = i2;
                        return;
                    }
                }
            }
            this.f508e = -1;
        }

        @Override // android.widget.Adapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public g getItem(int i2) {
            ArrayList<g> arrayListZ = d.this.f501g.z();
            int i3 = i2 + d.this.f503i;
            int i4 = this.f508e;
            if (i4 >= 0 && i3 >= i4) {
                i3++;
            }
            return arrayListZ.get(i3);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = d.this.f501g.z().size() - d.this.f503i;
            return this.f508e < 0 ? size : size - 1;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            if (view == null) {
                d dVar = d.this;
                view = dVar.f500f.inflate(dVar.f505k, viewGroup, false);
            }
            ((l.a) view).d(getItem(i2), 0);
            return view;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }

    public d(Context context, int i2) {
        this(i2, 0);
        this.f499e = context;
        this.f500f = LayoutInflater.from(context);
    }

    @Override // androidx.appcompat.view.menu.k
    public void a(e eVar, boolean z2) {
        k.a aVar = this.f506l;
        if (aVar != null) {
            aVar.a(eVar, z2);
        }
    }

    public ListAdapter b() {
        if (this.f507m == null) {
            this.f507m = new a();
        }
        return this.f507m;
    }

    @Override // androidx.appcompat.view.menu.k
    public void c(Context context, e eVar) {
        if (this.f504j != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, this.f504j);
            this.f499e = contextThemeWrapper;
            this.f500f = LayoutInflater.from(contextThemeWrapper);
        } else if (this.f499e != null) {
            this.f499e = context;
            if (this.f500f == null) {
                this.f500f = LayoutInflater.from(context);
            }
        }
        this.f501g = eVar;
        a aVar = this.f507m;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public l d(ViewGroup viewGroup) {
        if (this.f502h == null) {
            this.f502h = (ExpandedMenuView) this.f500f.inflate(R$layout.abc_expanded_menu_layout, viewGroup, false);
            if (this.f507m == null) {
                this.f507m = new a();
            }
            this.f502h.setAdapter((ListAdapter) this.f507m);
            this.f502h.setOnItemClickListener(this);
        }
        return this.f502h;
    }

    @Override // androidx.appcompat.view.menu.k
    public boolean e(p pVar) {
        if (!pVar.hasVisibleItems()) {
            return false;
        }
        new f(pVar).d(null);
        k.a aVar = this.f506l;
        if (aVar == null) {
            return true;
        }
        aVar.b(pVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.k
    public void f(boolean z2) {
        a aVar = this.f507m;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.k
    public boolean h() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.k
    public boolean i(e eVar, g gVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.k
    public boolean j(e eVar, g gVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.k
    public void k(k.a aVar) {
        this.f506l = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        this.f501g.M(this.f507m.getItem(i2), this, 0);
    }

    public d(int i2, int i3) {
        this.f505k = i2;
        this.f504j = i3;
    }
}
