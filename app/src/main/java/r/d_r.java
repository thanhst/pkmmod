package r;

import android.view.animation.Interpolator;

/* compiled from: LookupTableInterpolator.java */
/* loaded from: classes.dex */
abstract class d_r implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    private final float[] f4088a;

    /* renamed from: b, reason: collision with root package name */
    private final float f4089b;

    protected d_r(float[] fArr) {
        this.f4088a = fArr;
        this.f4089b = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f2) {
        if (f2 >= 1.0f) {
            return 1.0f;
        }
        if (f2 <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f4088a;
        int iMin = Math.min((int) ((fArr.length - 1) * f2), fArr.length - 2);
        float f3 = this.f4089b;
        float f4 = (f2 - (iMin * f3)) / f3;
        float[] fArr2 = this.f4088a;
        float f5 = fArr2[iMin];
        return f5 + (f4 * (fArr2[iMin + 1] - f5));
    }
}
