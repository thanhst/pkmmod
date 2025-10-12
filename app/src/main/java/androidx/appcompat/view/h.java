package androidx.appcompat.view;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.annotation.RestrictTo;
import androidx.core.view.a3;
import androidx.core.view.y2;
import androidx.core.view.z2;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ViewPropertyAnimatorCompatSet.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class h {

    /* renamed from: c, reason: collision with root package name */
    private Interpolator f389c;

    /* renamed from: d, reason: collision with root package name */
    z2 f390d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f391e;

    /* renamed from: b, reason: collision with root package name */
    private long f388b = -1;

    /* renamed from: f, reason: collision with root package name */
    private final a3 f392f = new a();

    /* renamed from: a, reason: collision with root package name */
    final ArrayList<y2> f387a = new ArrayList<>();

    /* compiled from: ViewPropertyAnimatorCompatSet.java */
    class a extends a3 {

        /* renamed from: a, reason: collision with root package name */
        private boolean f393a = false;

        /* renamed from: b, reason: collision with root package name */
        private int f394b = 0;

        a() {
        }

        @Override // androidx.core.view.z2
        public void b(View view) {
            int i2 = this.f394b + 1;
            this.f394b = i2;
            if (i2 == h.this.f387a.size()) {
                z2 z2Var = h.this.f390d;
                if (z2Var != null) {
                    z2Var.b(null);
                }
                d();
            }
        }

        @Override // androidx.core.view.a3, androidx.core.view.z2
        public void c(View view) {
            if (this.f393a) {
                return;
            }
            this.f393a = true;
            z2 z2Var = h.this.f390d;
            if (z2Var != null) {
                z2Var.c(null);
            }
        }

        void d() {
            this.f394b = 0;
            this.f393a = false;
            h.this.b();
        }
    }

    public void a() {
        if (this.f391e) {
            Iterator<y2> it = this.f387a.iterator();
            while (it.hasNext()) {
                it.next().c();
            }
            this.f391e = false;
        }
    }

    void b() {
        this.f391e = false;
    }

    public h c(y2 y2Var) {
        if (!this.f391e) {
            this.f387a.add(y2Var);
        }
        return this;
    }

    public h d(y2 y2Var, y2 y2Var2) {
        this.f387a.add(y2Var);
        y2Var2.j(y2Var.d());
        this.f387a.add(y2Var2);
        return this;
    }

    public h e(long j2) {
        if (!this.f391e) {
            this.f388b = j2;
        }
        return this;
    }

    public h f(Interpolator interpolator) {
        if (!this.f391e) {
            this.f389c = interpolator;
        }
        return this;
    }

    public h g(z2 z2Var) {
        if (!this.f391e) {
            this.f390d = z2Var;
        }
        return this;
    }

    public void h() {
        if (this.f391e) {
            return;
        }
        Iterator<y2> it = this.f387a.iterator();
        while (it.hasNext()) {
            y2 next = it.next();
            long j2 = this.f388b;
            if (j2 >= 0) {
                next.f(j2);
            }
            Interpolator interpolator = this.f389c;
            if (interpolator != null) {
                next.g(interpolator);
            }
            if (this.f390d != null) {
                next.h(this.f392f);
            }
            next.l();
        }
        this.f391e = true;
    }
}
