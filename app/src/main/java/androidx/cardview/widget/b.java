package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* compiled from: CardViewApi21Impl.java */
@RequiresApi(21)
/* loaded from: classes.dex */
class b implements e {
    b() {
    }

    private f o(d dVar) {
        return (f) dVar.g();
    }

    @Override // androidx.cardview.widget.e
    public float a(d dVar) {
        return o(dVar).c();
    }

    @Override // androidx.cardview.widget.e
    public ColorStateList b(d dVar) {
        return o(dVar).b();
    }

    @Override // androidx.cardview.widget.e
    public void c(d dVar, Context context, ColorStateList colorStateList, float f2, float f3, float f4) {
        dVar.d(new f(colorStateList, f2));
        View viewA = dVar.a();
        viewA.setClipToOutline(true);
        viewA.setElevation(f3);
        n(dVar, f4);
    }

    @Override // androidx.cardview.widget.e
    public void d(d dVar, float f2) {
        o(dVar).h(f2);
    }

    @Override // androidx.cardview.widget.e
    public float e(d dVar) {
        return dVar.a().getElevation();
    }

    @Override // androidx.cardview.widget.e
    public void f() {
    }

    @Override // androidx.cardview.widget.e
    public float g(d dVar) {
        return o(dVar).d();
    }

    @Override // androidx.cardview.widget.e
    public float h(d dVar) {
        return g(dVar) * 2.0f;
    }

    @Override // androidx.cardview.widget.e
    public float i(d dVar) {
        return g(dVar) * 2.0f;
    }

    @Override // androidx.cardview.widget.e
    public void j(d dVar) {
        n(dVar, a(dVar));
    }

    @Override // androidx.cardview.widget.e
    public void k(d dVar, float f2) {
        dVar.a().setElevation(f2);
    }

    @Override // androidx.cardview.widget.e
    public void l(d dVar) {
        n(dVar, a(dVar));
    }

    @Override // androidx.cardview.widget.e
    public void m(d dVar, @Nullable ColorStateList colorStateList) {
        o(dVar).f(colorStateList);
    }

    @Override // androidx.cardview.widget.e
    public void n(d dVar, float f2) {
        o(dVar).g(f2, dVar.f(), dVar.e());
        p(dVar);
    }

    public void p(d dVar) {
        if (!dVar.f()) {
            dVar.b(0, 0, 0, 0);
            return;
        }
        float fA = a(dVar);
        float fG = g(dVar);
        int iCeil = (int) Math.ceil(g.c(fA, fG, dVar.e()));
        int iCeil2 = (int) Math.ceil(g.d(fA, fG, dVar.e()));
        dVar.b(iCeil, iCeil2, iCeil, iCeil2);
    }
}
