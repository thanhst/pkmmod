package androidx.core.content.res;

import androidx.annotation.NonNull;

/* compiled from: ViewingConditions.java */
/* loaded from: classes.dex */
final class q {

    /* renamed from: k, reason: collision with root package name */
    static final q f1480k;

    /* renamed from: a, reason: collision with root package name */
    private final float f1481a;

    /* renamed from: b, reason: collision with root package name */
    private final float f1482b;

    /* renamed from: c, reason: collision with root package name */
    private final float f1483c;

    /* renamed from: d, reason: collision with root package name */
    private final float f1484d;

    /* renamed from: e, reason: collision with root package name */
    private final float f1485e;

    /* renamed from: f, reason: collision with root package name */
    private final float f1486f;

    /* renamed from: g, reason: collision with root package name */
    private final float[] f1487g;

    /* renamed from: h, reason: collision with root package name */
    private final float f1488h;

    /* renamed from: i, reason: collision with root package name */
    private final float f1489i;

    /* renamed from: j, reason: collision with root package name */
    private final float f1490j;

    static {
        float[] fArr = b.f1457c;
        double dH = b.h(50.0f);
        Double.isNaN(dH);
        f1480k = k(fArr, (float) ((dH * 63.66197723675813d) / 100.0d), 50.0f, 2.0f, false);
    }

    private q(float f2, float f3, float f4, float f5, float f6, float f7, float[] fArr, float f8, float f9, float f10) {
        this.f1486f = f2;
        this.f1481a = f3;
        this.f1482b = f4;
        this.f1483c = f5;
        this.f1484d = f6;
        this.f1485e = f7;
        this.f1487g = fArr;
        this.f1488h = f8;
        this.f1489i = f9;
        this.f1490j = f10;
    }

    @NonNull
    static q k(@NonNull float[] fArr, float f2, float f3, float f4, boolean z2) {
        float[][] fArr2 = b.f1455a;
        float f5 = fArr[0];
        float[] fArr3 = fArr2[0];
        float f6 = fArr3[0] * f5;
        float f7 = fArr[1];
        float f8 = f6 + (fArr3[1] * f7);
        float f9 = fArr[2];
        float f10 = f8 + (fArr3[2] * f9);
        float[] fArr4 = fArr2[1];
        float f11 = (fArr4[0] * f5) + (fArr4[1] * f7) + (fArr4[2] * f9);
        float[] fArr5 = fArr2[2];
        float f12 = (f5 * fArr5[0]) + (f7 * fArr5[1]) + (f9 * fArr5[2]);
        float f13 = (f4 / 10.0f) + 0.8f;
        float fD = ((double) f13) >= 0.9d ? b.d(0.59f, 0.69f, (f13 - 0.9f) * 10.0f) : b.d(0.525f, 0.59f, (f13 - 0.8f) * 10.0f);
        float fExp = z2 ? 1.0f : (1.0f - (((float) Math.exp(((-f2) - 42.0f) / 92.0f)) * 0.2777778f)) * f13;
        double d2 = fExp;
        if (d2 > 1.0d) {
            fExp = 1.0f;
        } else if (d2 < 0.0d) {
            fExp = 0.0f;
        }
        float[] fArr6 = {(((100.0f / f10) * fExp) + 1.0f) - fExp, (((100.0f / f11) * fExp) + 1.0f) - fExp, (((100.0f / f12) * fExp) + 1.0f) - fExp};
        float f14 = 1.0f / ((5.0f * f2) + 1.0f);
        float f15 = f14 * f14 * f14 * f14;
        float f16 = 1.0f - f15;
        double d3 = f2;
        Double.isNaN(d3);
        float fCbrt = (f15 * f2) + (0.1f * f16 * f16 * ((float) Math.cbrt(d3 * 5.0d)));
        float fH = b.h(f3) / fArr[1];
        double d4 = fH;
        float fSqrt = ((float) Math.sqrt(d4)) + 1.48f;
        float fPow = 0.725f / ((float) Math.pow(d4, 0.2d));
        double d5 = fArr6[0] * fCbrt * f10;
        Double.isNaN(d5);
        double d6 = fArr6[1] * fCbrt * f11;
        Double.isNaN(d6);
        double d7 = fArr6[2] * fCbrt * f12;
        Double.isNaN(d7);
        float fPow2 = (float) Math.pow(d7 / 100.0d, 0.42d);
        float[] fArr7 = {(float) Math.pow(d5 / 100.0d, 0.42d), (float) Math.pow(d6 / 100.0d, 0.42d), fPow2};
        float f17 = fArr7[0];
        float f18 = (f17 * 400.0f) / (f17 + 27.13f);
        float f19 = fArr7[1];
        return new q(fH, ((f18 * 2.0f) + ((f19 * 400.0f) / (f19 + 27.13f)) + (((400.0f * fPow2) / (fPow2 + 27.13f)) * 0.05f)) * fPow, fPow, fPow, fD, f13, fArr6, fCbrt, (float) Math.pow(fCbrt, 0.25d), fSqrt);
    }

    float a() {
        return this.f1481a;
    }

    float b() {
        return this.f1484d;
    }

    float c() {
        return this.f1488h;
    }

    float d() {
        return this.f1489i;
    }

    float e() {
        return this.f1486f;
    }

    float f() {
        return this.f1482b;
    }

    float g() {
        return this.f1485e;
    }

    float h() {
        return this.f1483c;
    }

    @NonNull
    float[] i() {
        return this.f1487g;
    }

    float j() {
        return this.f1490j;
    }
}
