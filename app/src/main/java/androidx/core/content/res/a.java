package androidx.core.content.res;

import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: CamColor.java */
/* loaded from: classes.dex */
class a {

    /* renamed from: a, reason: collision with root package name */
    private final float f1446a;

    /* renamed from: b, reason: collision with root package name */
    private final float f1447b;

    /* renamed from: c, reason: collision with root package name */
    private final float f1448c;

    /* renamed from: d, reason: collision with root package name */
    private final float f1449d;

    /* renamed from: e, reason: collision with root package name */
    private final float f1450e;

    /* renamed from: f, reason: collision with root package name */
    private final float f1451f;

    /* renamed from: g, reason: collision with root package name */
    private final float f1452g;

    /* renamed from: h, reason: collision with root package name */
    private final float f1453h;

    /* renamed from: i, reason: collision with root package name */
    private final float f1454i;

    a(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        this.f1446a = f2;
        this.f1447b = f3;
        this.f1448c = f4;
        this.f1449d = f5;
        this.f1450e = f6;
        this.f1451f = f7;
        this.f1452g = f8;
        this.f1453h = f9;
        this.f1454i = f10;
    }

    /* JADX WARN: Failed to analyze thrown exceptions
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList$Itr.checkForComodification(Unknown Source)
    	at java.base/java.util.ArrayList$Itr.next(Unknown Source)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:179)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:132)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:179)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:132)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:179)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:132)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
     */
    @Nullable
    private static a b(@FloatRange(from = 0.0d, to = 360.0d) float f2, @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false) float f3, @FloatRange(from = 0.0d, to = 100.0d) float f4) {
        float f5 = 1000.0f;
        a aVar = null;
        float f6 = 1000.0f;
        float f7 = 100.0f;
        float f8 = 0.0f;
        while (Math.abs(f8 - f7) > 0.01f) {
            float f9 = ((f7 - f8) / 2.0f) + f8;
            int iP = e(f9, f3, f2).p();
            float fB = b.b(iP);
            float fAbs = Math.abs(f4 - fB);
            if (fAbs < 0.2f) {
                a aVarC = c(iP);
                float fA = aVarC.a(e(aVarC.k(), aVarC.i(), f2));
                if (fA <= 1.0f) {
                    aVar = aVarC;
                    f5 = fAbs;
                    f6 = fA;
                }
            }
            if (f5 == 0.0f && f6 == 0.0f) {
                break;
            }
            if (fB < f4) {
                f8 = f9;
            } else {
                f7 = f9;
            }
        }
        return aVar;
    }

    @NonNull
    static a c(@ColorInt int i2) {
        return d(i2, q.f1480k);
    }

    @NonNull
    static a d(@ColorInt int i2, @NonNull q qVar) {
        float[] fArrF = b.f(i2);
        float[][] fArr = b.f1455a;
        float f2 = fArrF[0];
        float[] fArr2 = fArr[0];
        float f3 = fArr2[0] * f2;
        float f4 = fArrF[1];
        float f5 = f3 + (fArr2[1] * f4);
        float f6 = fArrF[2];
        float f7 = f5 + (fArr2[2] * f6);
        float[] fArr3 = fArr[1];
        float f8 = (fArr3[0] * f2) + (fArr3[1] * f4) + (fArr3[2] * f6);
        float[] fArr4 = fArr[2];
        float f9 = (f2 * fArr4[0]) + (f4 * fArr4[1]) + (f6 * fArr4[2]);
        float f10 = qVar.i()[0] * f7;
        float f11 = qVar.i()[1] * f8;
        float f12 = qVar.i()[2] * f9;
        double dC = qVar.c() * Math.abs(f10);
        Double.isNaN(dC);
        float fPow = (float) Math.pow(dC / 100.0d, 0.42d);
        double dC2 = qVar.c() * Math.abs(f11);
        Double.isNaN(dC2);
        float fPow2 = (float) Math.pow(dC2 / 100.0d, 0.42d);
        double dC3 = qVar.c() * Math.abs(f12);
        Double.isNaN(dC3);
        float fPow3 = (float) Math.pow(dC3 / 100.0d, 0.42d);
        float fSignum = ((Math.signum(f10) * 400.0f) * fPow) / (fPow + 27.13f);
        float fSignum2 = ((Math.signum(f11) * 400.0f) * fPow2) / (fPow2 + 27.13f);
        float fSignum3 = ((Math.signum(f12) * 400.0f) * fPow3) / (fPow3 + 27.13f);
        double d2 = fSignum;
        Double.isNaN(d2);
        double d3 = fSignum2;
        Double.isNaN(d3);
        double d4 = (d2 * 11.0d) + (d3 * (-12.0d));
        double d5 = fSignum3;
        Double.isNaN(d5);
        double d6 = fSignum + fSignum2;
        Double.isNaN(d5);
        Double.isNaN(d6);
        float f13 = ((float) (d6 - (d5 * 2.0d))) / 9.0f;
        float f14 = fSignum2 * 20.0f;
        float f15 = (((fSignum * 20.0f) + f14) + (21.0f * fSignum3)) / 20.0f;
        float f16 = (((fSignum * 40.0f) + f14) + fSignum3) / 20.0f;
        float fAtan2 = (((float) Math.atan2(f13, ((float) (d4 + d5)) / 11.0f)) * 180.0f) / 3.1415927f;
        if (fAtan2 < 0.0f) {
            fAtan2 += 360.0f;
        } else if (fAtan2 >= 360.0f) {
            fAtan2 -= 360.0f;
        }
        float f17 = fAtan2;
        float f18 = (3.1415927f * f17) / 180.0f;
        float fPow4 = ((float) Math.pow((f16 * qVar.f()) / qVar.a(), qVar.b() * qVar.j())) * 100.0f;
        float fD = qVar.d() * (4.0f / qVar.b()) * ((float) Math.sqrt(fPow4 / 100.0f)) * (qVar.a() + 4.0f);
        Double.isNaN(((double) f17) < 20.14d ? 360.0f + f17 : f17);
        float fPow5 = ((float) Math.pow(1.64d - Math.pow(0.29d, qVar.e()), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos(((r9 * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * qVar.g()) * qVar.h()) * ((float) Math.sqrt((r3 * r3) + (f13 * f13)))) / (f15 + 0.305f), 0.9d));
        double d7 = fPow4;
        Double.isNaN(d7);
        float fSqrt = fPow5 * ((float) Math.sqrt(d7 / 100.0d));
        float fD2 = fSqrt * qVar.d();
        float fSqrt2 = ((float) Math.sqrt((fPow5 * qVar.b()) / (qVar.a() + 4.0f))) * 50.0f;
        float f19 = (1.7f * fPow4) / ((0.007f * fPow4) + 1.0f);
        float fLog = ((float) Math.log((0.0228f * fD2) + 1.0f)) * 43.85965f;
        double d8 = f18;
        return new a(f17, fSqrt, fPow4, fD, fD2, fSqrt2, f19, fLog * ((float) Math.cos(d8)), fLog * ((float) Math.sin(d8)));
    }

    @NonNull
    private static a e(@FloatRange(from = 0.0d, to = 100.0d) float f2, @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false) float f3, @FloatRange(from = 0.0d, to = 360.0d) float f4) {
        return f(f2, f3, f4, q.f1480k);
    }

    @NonNull
    private static a f(@FloatRange(from = 0.0d, to = 100.0d) float f2, @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false) float f3, @FloatRange(from = 0.0d, to = 360.0d) float f4, q qVar) {
        float fB = 4.0f / qVar.b();
        double d2 = f2;
        Double.isNaN(d2);
        float fSqrt = fB * ((float) Math.sqrt(d2 / 100.0d)) * (qVar.a() + 4.0f) * qVar.d();
        float fD = f3 * qVar.d();
        float fSqrt2 = ((float) Math.sqrt(((f3 / ((float) Math.sqrt(r4))) * qVar.b()) / (qVar.a() + 4.0f))) * 50.0f;
        float f5 = (1.7f * f2) / ((0.007f * f2) + 1.0f);
        double d3 = fD;
        Double.isNaN(d3);
        float fLog = ((float) Math.log((d3 * 0.0228d) + 1.0d)) * 43.85965f;
        double d4 = (3.1415927f * f4) / 180.0f;
        return new a(f4, f3, f2, fSqrt, fD, fSqrt2, f5, fLog * ((float) Math.cos(d4)), fLog * ((float) Math.sin(d4)));
    }

    static int m(@FloatRange(from = 0.0d, to = 360.0d) float f2, @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false) float f3, @FloatRange(from = 0.0d, to = 100.0d) float f4) {
        return n(f2, f3, f4, q.f1480k);
    }

    @ColorInt
    static int n(@FloatRange(from = 0.0d, to = 360.0d) float f2, @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false) float f3, @FloatRange(from = 0.0d, to = 100.0d) float f4, @NonNull q qVar) {
        if (f3 < 1.0d || Math.round(f4) <= 0.0d || Math.round(f4) >= 100.0d) {
            return b.a(f4);
        }
        float fMin = f2 < 0.0f ? 0.0f : Math.min(360.0f, f2);
        float f5 = f3;
        a aVar = null;
        float f6 = 0.0f;
        boolean z2 = true;
        while (Math.abs(f6 - f3) >= 0.4f) {
            a aVarB = b(fMin, f5, f4);
            if (z2) {
                if (aVarB != null) {
                    return aVarB.o(qVar);
                }
                z2 = false;
            } else if (aVarB == null) {
                f3 = f5;
            } else {
                f6 = f5;
                aVar = aVarB;
            }
            f5 = ((f3 - f6) / 2.0f) + f6;
        }
        return aVar == null ? b.a(f4) : aVar.o(qVar);
    }

    float a(@NonNull a aVar) {
        float fL = l() - aVar.l();
        float fG = g() - aVar.g();
        float fH = h() - aVar.h();
        return (float) (Math.pow(Math.sqrt((fL * fL) + (fG * fG) + (fH * fH)), 0.63d) * 1.41d);
    }

    @FloatRange(from = Double.NEGATIVE_INFINITY, fromInclusive = false, to = Double.POSITIVE_INFINITY, toInclusive = false)
    float g() {
        return this.f1453h;
    }

    @FloatRange(from = Double.NEGATIVE_INFINITY, fromInclusive = false, to = Double.POSITIVE_INFINITY, toInclusive = false)
    float h() {
        return this.f1454i;
    }

    @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false)
    float i() {
        return this.f1447b;
    }

    @FloatRange(from = 0.0d, to = 360.0d, toInclusive = false)
    float j() {
        return this.f1446a;
    }

    @FloatRange(from = 0.0d, to = 100.0d)
    float k() {
        return this.f1448c;
    }

    @FloatRange(from = 0.0d, to = 100.0d)
    float l() {
        return this.f1452g;
    }

    @ColorInt
    int o(@NonNull q qVar) {
        float fSqrt;
        if (i() == 0.0d || k() == 0.0d) {
            fSqrt = 0.0f;
        } else {
            float fI = i();
            double dK = k();
            Double.isNaN(dK);
            fSqrt = fI / ((float) Math.sqrt(dK / 100.0d));
        }
        double d2 = fSqrt;
        double dPow = Math.pow(1.64d - Math.pow(0.29d, qVar.e()), 0.73d);
        Double.isNaN(d2);
        float fPow = (float) Math.pow(d2 / dPow, 1.1111111111111112d);
        double dJ = (j() * 3.1415927f) / 180.0f;
        Double.isNaN(dJ);
        float fCos = ((float) (Math.cos(2.0d + dJ) + 3.8d)) * 0.25f;
        float fA = qVar.a();
        double dK2 = k();
        Double.isNaN(dK2);
        double dB = qVar.b();
        Double.isNaN(dB);
        double d3 = 1.0d / dB;
        double dJ2 = qVar.j();
        Double.isNaN(dJ2);
        float fPow2 = fA * ((float) Math.pow(dK2 / 100.0d, d3 / dJ2));
        float fG = fCos * 3846.1538f * qVar.g() * qVar.h();
        float f2 = fPow2 / qVar.f();
        float fSin = (float) Math.sin(dJ);
        float fCos2 = (float) Math.cos(dJ);
        float f3 = (((0.305f + f2) * 23.0f) * fPow) / (((fG * 23.0f) + ((11.0f * fPow) * fCos2)) + ((fPow * 108.0f) * fSin));
        float f4 = fCos2 * f3;
        float f5 = f3 * fSin;
        float f6 = f2 * 460.0f;
        float f7 = (((451.0f * f4) + f6) + (288.0f * f5)) / 1403.0f;
        float f8 = ((f6 - (891.0f * f4)) - (261.0f * f5)) / 1403.0f;
        float f9 = ((f6 - (f4 * 220.0f)) - (f5 * 6300.0f)) / 1403.0f;
        Double.isNaN(Math.abs(f7));
        Double.isNaN(Math.abs(f7));
        float fSignum = Math.signum(f7) * (100.0f / qVar.c()) * ((float) Math.pow((float) Math.max(0.0d, (r7 * 27.13d) / (400.0d - r11)), 2.380952380952381d));
        Double.isNaN(Math.abs(f8));
        Double.isNaN(Math.abs(f8));
        float fSignum2 = Math.signum(f8) * (100.0f / qVar.c()) * ((float) Math.pow((float) Math.max(0.0d, (r11 * 27.13d) / (400.0d - r9)), 2.380952380952381d));
        Double.isNaN(Math.abs(f9));
        Double.isNaN(Math.abs(f9));
        float fSignum3 = Math.signum(f9) * (100.0f / qVar.c()) * ((float) Math.pow((float) Math.max(0.0d, (r9 * 27.13d) / (400.0d - r11)), 2.380952380952381d));
        float f10 = fSignum / qVar.i()[0];
        float f11 = fSignum2 / qVar.i()[1];
        float f12 = fSignum3 / qVar.i()[2];
        float[][] fArr = b.f1456b;
        float[] fArr2 = fArr[0];
        float f13 = (fArr2[0] * f10) + (fArr2[1] * f11) + (fArr2[2] * f12);
        float[] fArr3 = fArr[1];
        float f14 = (fArr3[0] * f10) + (fArr3[1] * f11) + (fArr3[2] * f12);
        float[] fArr4 = fArr[2];
        return androidx.core.graphics.a.a(f13, f14, (f10 * fArr4[0]) + (f11 * fArr4[1]) + (f12 * fArr4[2]));
    }

    @ColorInt
    int p() {
        return o(q.f1480k);
    }
}
