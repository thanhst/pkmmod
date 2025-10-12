package androidx.appcompat.widget;

import com.bumptech.glide.request.target.Target;

/* compiled from: RtlSpacingHelper.java */
/* loaded from: classes.dex */
class b2 {

    /* renamed from: a, reason: collision with root package name */
    private int f840a = 0;

    /* renamed from: b, reason: collision with root package name */
    private int f841b = 0;

    /* renamed from: c, reason: collision with root package name */
    private int f842c = Target.SIZE_ORIGINAL;

    /* renamed from: d, reason: collision with root package name */
    private int f843d = Target.SIZE_ORIGINAL;

    /* renamed from: e, reason: collision with root package name */
    private int f844e = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f845f = 0;

    /* renamed from: g, reason: collision with root package name */
    private boolean f846g = false;

    /* renamed from: h, reason: collision with root package name */
    private boolean f847h = false;

    b2() {
    }

    public int a() {
        return this.f846g ? this.f840a : this.f841b;
    }

    public int b() {
        return this.f840a;
    }

    public int c() {
        return this.f841b;
    }

    public int d() {
        return this.f846g ? this.f841b : this.f840a;
    }

    public void e(int i2, int i3) {
        this.f847h = false;
        if (i2 != Integer.MIN_VALUE) {
            this.f844e = i2;
            this.f840a = i2;
        }
        if (i3 != Integer.MIN_VALUE) {
            this.f845f = i3;
            this.f841b = i3;
        }
    }

    public void f(boolean z2) {
        if (z2 == this.f846g) {
            return;
        }
        this.f846g = z2;
        if (!this.f847h) {
            this.f840a = this.f844e;
            this.f841b = this.f845f;
            return;
        }
        if (z2) {
            int i2 = this.f843d;
            if (i2 == Integer.MIN_VALUE) {
                i2 = this.f844e;
            }
            this.f840a = i2;
            int i3 = this.f842c;
            if (i3 == Integer.MIN_VALUE) {
                i3 = this.f845f;
            }
            this.f841b = i3;
            return;
        }
        int i4 = this.f842c;
        if (i4 == Integer.MIN_VALUE) {
            i4 = this.f844e;
        }
        this.f840a = i4;
        int i5 = this.f843d;
        if (i5 == Integer.MIN_VALUE) {
            i5 = this.f845f;
        }
        this.f841b = i5;
    }

    public void g(int i2, int i3) {
        this.f842c = i2;
        this.f843d = i3;
        this.f847h = true;
        if (this.f846g) {
            if (i3 != Integer.MIN_VALUE) {
                this.f840a = i3;
            }
            if (i2 != Integer.MIN_VALUE) {
                this.f841b = i2;
                return;
            }
            return;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f840a = i2;
        }
        if (i3 != Integer.MIN_VALUE) {
            this.f841b = i3;
        }
    }
}
