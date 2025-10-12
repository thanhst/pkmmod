package com.google.zxing;

import com.google.zxing.common.detector.MathUtils;

/* loaded from: classes.dex */
public class ResultPoint {

    /* renamed from: x, reason: collision with root package name */
    private final float f2941x;

    /* renamed from: y, reason: collision with root package name */
    private final float f2942y;

    public ResultPoint(float f2, float f3) {
        this.f2941x = f2;
        this.f2942y = f3;
    }

    private static float crossProductZ(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3) {
        float f2 = resultPoint2.f2941x;
        float f3 = resultPoint2.f2942y;
        return ((resultPoint3.f2941x - f2) * (resultPoint.f2942y - f3)) - ((resultPoint3.f2942y - f3) * (resultPoint.f2941x - f2));
    }

    public static float distance(ResultPoint resultPoint, ResultPoint resultPoint2) {
        return MathUtils.distance(resultPoint.f2941x, resultPoint.f2942y, resultPoint2.f2941x, resultPoint2.f2942y);
    }

    public static void orderBestPatterns(ResultPoint[] resultPointArr) {
        ResultPoint resultPoint;
        ResultPoint resultPoint2;
        ResultPoint resultPoint3;
        float fDistance = distance(resultPointArr[0], resultPointArr[1]);
        float fDistance2 = distance(resultPointArr[1], resultPointArr[2]);
        float fDistance3 = distance(resultPointArr[0], resultPointArr[2]);
        if (fDistance2 >= fDistance && fDistance2 >= fDistance3) {
            resultPoint = resultPointArr[0];
            resultPoint2 = resultPointArr[1];
            resultPoint3 = resultPointArr[2];
        } else if (fDistance3 < fDistance2 || fDistance3 < fDistance) {
            resultPoint = resultPointArr[2];
            resultPoint2 = resultPointArr[0];
            resultPoint3 = resultPointArr[1];
        } else {
            resultPoint = resultPointArr[1];
            resultPoint2 = resultPointArr[0];
            resultPoint3 = resultPointArr[2];
        }
        if (crossProductZ(resultPoint2, resultPoint, resultPoint3) < 0.0f) {
            ResultPoint resultPoint4 = resultPoint3;
            resultPoint3 = resultPoint2;
            resultPoint2 = resultPoint4;
        }
        resultPointArr[0] = resultPoint2;
        resultPointArr[1] = resultPoint;
        resultPointArr[2] = resultPoint3;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ResultPoint) {
            ResultPoint resultPoint = (ResultPoint) obj;
            if (this.f2941x == resultPoint.f2941x && this.f2942y == resultPoint.f2942y) {
                return true;
            }
        }
        return false;
    }

    public final float getX() {
        return this.f2941x;
    }

    public final float getY() {
        return this.f2942y;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f2941x) * 31) + Float.floatToIntBits(this.f2942y);
    }

    public final String toString() {
        return "(" + this.f2941x + ',' + this.f2942y + ')';
    }
}
