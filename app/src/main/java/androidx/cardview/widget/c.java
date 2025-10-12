package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.Nullable;

/* compiled from: CardViewBaseImpl.java */
/* loaded from: classes.dex */
class c implements e {

    /* renamed from: a, reason: collision with root package name */
    final RectF f1275a = new RectF();

    c() {
    }

    private g o(Context context, ColorStateList colorStateList, float f2, float f3, float f4) {
        return new g(context.getResources(), colorStateList, f2, f3, f4);
    }

    private g p(d dVar) {
        return (g) dVar.g();
    }

    @Override // androidx.cardview.widget.e
    public float a(d dVar) {
        return p(dVar).i();
    }

    @Override // androidx.cardview.widget.e
    public ColorStateList b(d dVar) {
        return p(dVar).f();
    }

    @Override // androidx.cardview.widget.e
    public void c(d dVar, Context context, ColorStateList colorStateList, float f2, float f3, float f4) {
        g gVarO = o(context, colorStateList, f2, f3, f4);
        gVarO.m(dVar.e());
        dVar.d(gVarO);
        q(dVar);
    }

    @Override // androidx.cardview.widget.e
    public void d(d dVar, float f2) {
        p(dVar).p(f2);
        q(dVar);
    }

    @Override // androidx.cardview.widget.e
    public float e(d dVar) {
        return p(dVar).l();
    }

    @Override // androidx.cardview.widget.e
    public float g(d dVar) {
        return p(dVar).g();
    }

    @Override // androidx.cardview.widget.e
    public float h(d dVar) {
        return p(dVar).j();
    }

    @Override // androidx.cardview.widget.e
    public float i(d dVar) {
        return p(dVar).k();
    }

    @Override // androidx.cardview.widget.e
    public void j(d dVar) {
    }

    @Override // androidx.cardview.widget.e
    public void k(d dVar, float f2) {
        p(dVar).r(f2);
    }

    @Override // androidx.cardview.widget.e
    public void l(d dVar) {
        p(dVar).m(dVar.e());
        q(dVar);
    }

    @Override // androidx.cardview.widget.e
    public void m(d dVar, @Nullable ColorStateList colorStateList) {
        p(dVar).o(colorStateList);
    }

    @Override // androidx.cardview.widget.e
    public void n(d dVar, float f2) {
        p(dVar).q(f2);
        q(dVar);
    }

    public void q(d dVar) {
        Rect rect = new Rect();
        p(dVar).h(rect);
        dVar.c((int) Math.ceil(i(dVar)), (int) Math.ceil(h(dVar)));
        dVar.b(rect.left, rect.top, rect.right, rect.bottom);
    }
}
