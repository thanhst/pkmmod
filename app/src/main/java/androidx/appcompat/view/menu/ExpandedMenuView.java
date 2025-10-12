package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.widget.k2;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements e.b, l, AdapterView.OnItemClickListener {

    /* renamed from: g, reason: collision with root package name */
    private static final int[] f440g = {R.attr.background, R.attr.divider};

    /* renamed from: e, reason: collision with root package name */
    private e f441e;

    /* renamed from: f, reason: collision with root package name */
    private int f442f;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listViewStyle);
    }

    @Override // androidx.appcompat.view.menu.e.b
    public boolean a(g gVar) {
        return this.f441e.L(gVar, 0);
    }

    @Override // androidx.appcompat.view.menu.l
    public void b(e eVar) {
        this.f441e = eVar;
    }

    public int getWindowAnimations() {
        return this.f442f;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
        a((g) getAdapter().getItem(i2));
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        k2 k2VarU = k2.u(context, attributeSet, f440g, i2, 0);
        if (k2VarU.r(0)) {
            setBackgroundDrawable(k2VarU.f(0));
        }
        if (k2VarU.r(1)) {
            setDivider(k2VarU.f(1));
        }
        k2VarU.v();
    }
}
