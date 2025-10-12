package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.l;
import java.util.ArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class MenuAdapter extends BaseAdapter {

    /* renamed from: e, reason: collision with root package name */
    e f460e;

    /* renamed from: f, reason: collision with root package name */
    private int f461f = -1;

    /* renamed from: g, reason: collision with root package name */
    private boolean f462g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f463h;

    /* renamed from: i, reason: collision with root package name */
    private final LayoutInflater f464i;

    /* renamed from: j, reason: collision with root package name */
    private final int f465j;

    public MenuAdapter(e eVar, LayoutInflater layoutInflater, boolean z2, int i2) {
        this.f463h = z2;
        this.f464i = layoutInflater;
        this.f460e = eVar;
        this.f465j = i2;
        a();
    }

    void a() {
        g gVarV = this.f460e.v();
        if (gVarV != null) {
            ArrayList<g> arrayListZ = this.f460e.z();
            int size = arrayListZ.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (arrayListZ.get(i2) == gVarV) {
                    this.f461f = i2;
                    return;
                }
            }
        }
        this.f461f = -1;
    }

    public e b() {
        return this.f460e;
    }

    @Override // android.widget.Adapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public g getItem(int i2) {
        ArrayList<g> arrayListZ = this.f463h ? this.f460e.z() : this.f460e.E();
        int i3 = this.f461f;
        if (i3 >= 0 && i2 >= i3) {
            i2++;
        }
        return arrayListZ.get(i2);
    }

    public void d(boolean z2) {
        this.f462g = z2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f461f < 0 ? (this.f463h ? this.f460e.z() : this.f460e.E()).size() : r0.size() - 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f464i.inflate(this.f465j, viewGroup, false);
        }
        int groupId = getItem(i2).getGroupId();
        int i3 = i2 - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f460e.F() && groupId != (i3 >= 0 ? getItem(i3).getGroupId() : groupId));
        l.a aVar = (l.a) view;
        if (this.f462g) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.d(getItem(i2), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
