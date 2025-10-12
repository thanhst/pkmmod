package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.view.menu.l;
import java.util.ArrayList;

/* compiled from: BaseMenuPresenter.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public abstract class b implements k {

    /* renamed from: e, reason: collision with root package name */
    protected Context f486e;

    /* renamed from: f, reason: collision with root package name */
    protected Context f487f;

    /* renamed from: g, reason: collision with root package name */
    protected e f488g;

    /* renamed from: h, reason: collision with root package name */
    protected LayoutInflater f489h;

    /* renamed from: i, reason: collision with root package name */
    protected LayoutInflater f490i;

    /* renamed from: j, reason: collision with root package name */
    private k.a f491j;

    /* renamed from: k, reason: collision with root package name */
    private int f492k;

    /* renamed from: l, reason: collision with root package name */
    private int f493l;

    /* renamed from: m, reason: collision with root package name */
    protected l f494m;

    /* renamed from: n, reason: collision with root package name */
    private int f495n;

    public b(Context context, int i2, int i3) {
        this.f486e = context;
        this.f489h = LayoutInflater.from(context);
        this.f492k = i2;
        this.f493l = i3;
    }

    @Override // androidx.appcompat.view.menu.k
    public void a(e eVar, boolean z2) {
        k.a aVar = this.f491j;
        if (aVar != null) {
            aVar.a(eVar, z2);
        }
    }

    protected void b(View view, int i2) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f494m).addView(view, i2);
    }

    @Override // androidx.appcompat.view.menu.k
    public void c(Context context, e eVar) {
        this.f487f = context;
        this.f490i = LayoutInflater.from(context);
        this.f488g = eVar;
    }

    public abstract void d(g gVar, l.a aVar);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [androidx.appcompat.view.menu.e] */
    @Override // androidx.appcompat.view.menu.k
    public boolean e(p pVar) {
        k.a aVar = this.f491j;
        p pVar2 = pVar;
        if (aVar == null) {
            return false;
        }
        if (pVar == null) {
            pVar2 = this.f488g;
        }
        return aVar.b(pVar2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.menu.k
    public void f(boolean z2) {
        ViewGroup viewGroup = (ViewGroup) this.f494m;
        if (viewGroup == null) {
            return;
        }
        e eVar = this.f488g;
        int i2 = 0;
        if (eVar != null) {
            eVar.r();
            ArrayList<g> arrayListE = this.f488g.E();
            int size = arrayListE.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                g gVar = arrayListE.get(i4);
                if (q(i3, gVar)) {
                    View childAt = viewGroup.getChildAt(i3);
                    g itemData = childAt instanceof l.a ? ((l.a) childAt).getItemData() : null;
                    View viewN = n(gVar, childAt, viewGroup);
                    if (gVar != itemData) {
                        viewN.setPressed(false);
                        viewN.jumpDrawablesToCurrentState();
                    }
                    if (viewN != childAt) {
                        b(viewN, i3);
                    }
                    i3++;
                }
            }
            i2 = i3;
        }
        while (i2 < viewGroup.getChildCount()) {
            if (!l(viewGroup, i2)) {
                i2++;
            }
        }
    }

    public l.a g(ViewGroup viewGroup) {
        return (l.a) this.f489h.inflate(this.f493l, viewGroup, false);
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
        this.f491j = aVar;
    }

    protected boolean l(ViewGroup viewGroup, int i2) {
        viewGroup.removeViewAt(i2);
        return true;
    }

    public k.a m() {
        return this.f491j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View n(g gVar, View view, ViewGroup viewGroup) {
        l.a aVarG = view instanceof l.a ? (l.a) view : g(viewGroup);
        d(gVar, aVarG);
        return (View) aVarG;
    }

    public l o(ViewGroup viewGroup) {
        if (this.f494m == null) {
            l lVar = (l) this.f489h.inflate(this.f492k, viewGroup, false);
            this.f494m = lVar;
            lVar.b(this.f488g);
            f(true);
        }
        return this.f494m;
    }

    public void p(int i2) {
        this.f495n = i2;
    }

    public abstract boolean q(int i2, g gVar);
}
