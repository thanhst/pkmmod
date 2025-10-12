package com.facebook.appevents.ml;

import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: Operator.kt */
@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0007J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0007J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0007J\u001d\u0010\u000f\u001a\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\rH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J \u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0007J-\u0010\u0016\u001a\u00020\u00022\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\r2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0007J\u0018\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\nH\u0007¨\u0006\u001f"}, d2 = {"Lcom/facebook/appevents/ml/Operator;", "", "Lcom/facebook/appevents/ml/MTensor;", "x", "b", "Lkotlin/t;", "addmv", "w", "mul", "relu", "", "startDim", "flatten", "", "tensors", "concatenate", "([Lcom/facebook/appevents/ml/MTensor;)Lcom/facebook/appevents/ml/MTensor;", "softmax", "dense", "", "texts", "seqLength", "embedding", "([Ljava/lang/String;ILcom/facebook/appevents/ml/MTensor;)Lcom/facebook/appevents/ml/MTensor;", "transpose2D", "transpose3D", "conv1D", "poolSize", "maxPool1D", "<init>", "()V", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Operator {

    @NotNull
    public static final Operator INSTANCE = new Operator();

    private Operator() {
    }

    @JvmStatic
    public static final void addmv(@NotNull MTensor x2, @NotNull MTensor b2) {
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return;
        }
        try {
            s.e(x2, "x");
            s.e(b2, "b");
            int shape = x2.getShape(0);
            int shape2 = x2.getShape(1);
            int shape3 = x2.getShape(2);
            float[] data = x2.getData();
            float[] data2 = b2.getData();
            if (shape <= 0) {
                return;
            }
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (shape2 > 0) {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4 + 1;
                        if (shape3 > 0) {
                            int i6 = 0;
                            while (true) {
                                int i7 = i6 + 1;
                                int i8 = (i2 * shape2 * shape3) + (i4 * shape3) + i6;
                                data[i8] = data[i8] + data2[i6];
                                if (i7 >= shape3) {
                                    break;
                                } else {
                                    i6 = i7;
                                }
                            }
                        }
                        if (i5 >= shape2) {
                            break;
                        } else {
                            i4 = i5;
                        }
                    }
                }
                if (i3 >= shape) {
                    return;
                } else {
                    i2 = i3;
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Operator.class);
        }
    }

    @JvmStatic
    @NotNull
    public static final MTensor concatenate(@NotNull MTensor[] tensors) {
        int shape;
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return null;
        }
        try {
            s.e(tensors, "tensors");
            int shape2 = tensors[0].getShape(0);
            int length = tensors.length - 1;
            if (length >= 0) {
                int i2 = 0;
                shape = 0;
                while (true) {
                    int i3 = i2 + 1;
                    shape += tensors[i2].getShape(1);
                    if (i3 > length) {
                        break;
                    }
                    i2 = i3;
                }
            } else {
                shape = 0;
            }
            MTensor mTensor = new MTensor(new int[]{shape2, shape});
            float[] data = mTensor.getData();
            if (shape2 > 0) {
                int i4 = 0;
                while (true) {
                    int i5 = i4 + 1;
                    int i6 = i4 * shape;
                    int length2 = tensors.length - 1;
                    if (length2 >= 0) {
                        int i7 = 0;
                        while (true) {
                            int i8 = i7 + 1;
                            float[] data2 = tensors[i7].getData();
                            int shape3 = tensors[i7].getShape(1);
                            System.arraycopy(data2, i4 * shape3, data, i6, shape3);
                            i6 += shape3;
                            if (i8 > length2) {
                                break;
                            }
                            i7 = i8;
                        }
                    }
                    if (i5 >= shape2) {
                        break;
                    }
                    i4 = i5;
                }
            }
            return mTensor;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Operator.class);
            return null;
        }
    }

    @JvmStatic
    @NotNull
    public static final MTensor conv1D(@NotNull MTensor x2, @NotNull MTensor w2) {
        Class<Operator> cls;
        Class<Operator> cls2;
        MTensor mTensor;
        Class<Operator> cls3 = Operator.class;
        if (CrashShieldHandler.isObjectCrashing(cls3)) {
            return null;
        }
        try {
            s.e(x2, "x");
            s.e(w2, "w");
            int shape = x2.getShape(0);
            int shape2 = x2.getShape(1);
            int shape3 = x2.getShape(2);
            int shape4 = w2.getShape(0);
            int i2 = (shape2 - shape4) + 1;
            int shape5 = w2.getShape(2);
            MTensor mTensor2 = new MTensor(new int[]{shape, i2, shape5});
            float[] data = x2.getData();
            float[] data2 = mTensor2.getData();
            float[] data3 = w2.getData();
            if (shape <= 0) {
                return mTensor2;
            }
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                if (shape5 > 0) {
                    int i5 = 0;
                    while (true) {
                        int i6 = i5 + 1;
                        if (i2 > 0) {
                            int i7 = 0;
                            while (true) {
                                int i8 = i7 + 1;
                                float f2 = 0.0f;
                                if (shape4 > 0) {
                                    int i9 = 0;
                                    while (true) {
                                        cls2 = cls3;
                                        int i10 = i9 + 1;
                                        if (shape3 > 0) {
                                            int i11 = 0;
                                            while (true) {
                                                mTensor = mTensor2;
                                                int i12 = i11 + 1;
                                                try {
                                                    f2 += data[(shape2 * shape3 * i3) + ((i9 + i7) * shape3) + i11] * data3[(((i9 * shape3) + i11) * shape5) + i5];
                                                    if (i12 >= shape3) {
                                                        break;
                                                    }
                                                    i11 = i12;
                                                    mTensor2 = mTensor;
                                                } catch (Throwable th) {
                                                    th = th;
                                                    cls = cls2;
                                                    CrashShieldHandler.handleThrowable(th, cls);
                                                    return null;
                                                }
                                            }
                                        } else {
                                            mTensor = mTensor2;
                                        }
                                        if (i10 >= shape4) {
                                            break;
                                        }
                                        i9 = i10;
                                        cls3 = cls2;
                                        mTensor2 = mTensor;
                                    }
                                } else {
                                    cls2 = cls3;
                                    mTensor = mTensor2;
                                }
                                data2[(i2 * shape5 * i3) + (i7 * shape5) + i5] = f2;
                                if (i8 >= i2) {
                                    break;
                                }
                                i7 = i8;
                                cls3 = cls2;
                                mTensor2 = mTensor;
                            }
                        } else {
                            cls2 = cls3;
                            mTensor = mTensor2;
                        }
                        if (i6 >= shape5) {
                            break;
                        }
                        i5 = i6;
                        cls3 = cls2;
                        mTensor2 = mTensor;
                    }
                } else {
                    cls2 = cls3;
                    mTensor = mTensor2;
                }
                if (i4 >= shape) {
                    return mTensor;
                }
                i3 = i4;
                cls3 = cls2;
                mTensor2 = mTensor;
            }
        } catch (Throwable th2) {
            th = th2;
            cls = cls3;
        }
    }

    @JvmStatic
    @NotNull
    public static final MTensor dense(@NotNull MTensor x2, @NotNull MTensor w2, @NotNull MTensor b2) {
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return null;
        }
        try {
            s.e(x2, "x");
            s.e(w2, "w");
            s.e(b2, "b");
            int shape = x2.getShape(0);
            int shape2 = b2.getShape(0);
            MTensor mTensorMul = mul(x2, w2);
            float[] data = b2.getData();
            float[] data2 = mTensorMul.getData();
            if (shape > 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    if (shape2 > 0) {
                        int i4 = 0;
                        while (true) {
                            int i5 = i4 + 1;
                            int i6 = (i2 * shape2) + i4;
                            data2[i6] = data2[i6] + data[i4];
                            if (i5 >= shape2) {
                                break;
                            }
                            i4 = i5;
                        }
                    }
                    if (i3 >= shape) {
                        break;
                    }
                    i2 = i3;
                }
            }
            return mTensorMul;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Operator.class);
            return null;
        }
    }

    @JvmStatic
    @NotNull
    public static final MTensor embedding(@NotNull String[] texts, int seqLength, @NotNull MTensor w2) {
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return null;
        }
        try {
            s.e(texts, "texts");
            s.e(w2, "w");
            int length = texts.length;
            int shape = w2.getShape(1);
            MTensor mTensor = new MTensor(new int[]{length, seqLength, shape});
            float[] data = mTensor.getData();
            float[] data2 = w2.getData();
            if (length > 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    int[] iArrVectorize = Utils.INSTANCE.vectorize(texts[i2], seqLength);
                    if (seqLength > 0) {
                        int i4 = 0;
                        while (true) {
                            int i5 = i4 + 1;
                            System.arraycopy(data2, iArrVectorize[i4] * shape, data, (shape * seqLength * i2) + (i4 * shape), shape);
                            if (i5 >= seqLength) {
                                break;
                            }
                            i4 = i5;
                        }
                    }
                    if (i3 >= length) {
                        break;
                    }
                    i2 = i3;
                }
            }
            return mTensor;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Operator.class);
            return null;
        }
    }

    @JvmStatic
    public static final void flatten(@NotNull MTensor x2, int i2) {
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return;
        }
        try {
            s.e(x2, "x");
            if (i2 >= x2.getShapeSize()) {
                return;
            }
            int shapeSize = x2.getShapeSize();
            int shape = 1;
            if (i2 < shapeSize) {
                int i3 = i2;
                while (true) {
                    int i4 = i3 + 1;
                    shape *= x2.getShape(i3);
                    if (i4 >= shapeSize) {
                        break;
                    } else {
                        i3 = i4;
                    }
                }
            }
            int[] iArr = new int[i2 + 1];
            int i5 = 0;
            if (i2 > 0) {
                while (true) {
                    int i6 = i5 + 1;
                    iArr[i5] = x2.getShape(i5);
                    if (i6 >= i2) {
                        break;
                    } else {
                        i5 = i6;
                    }
                }
            }
            iArr[i2] = shape;
            x2.reshape(iArr);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Operator.class);
        }
    }

    @JvmStatic
    @NotNull
    public static final MTensor maxPool1D(@NotNull MTensor x2, int poolSize) {
        int i2;
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return null;
        }
        try {
            s.e(x2, "x");
            int shape = x2.getShape(0);
            int shape2 = x2.getShape(1);
            int shape3 = x2.getShape(2);
            int i3 = (shape2 - poolSize) + 1;
            MTensor mTensor = new MTensor(new int[]{shape, i3, shape3});
            float[] data = x2.getData();
            float[] data2 = mTensor.getData();
            if (shape > 0) {
                int i4 = 0;
                while (true) {
                    int i5 = i4 + 1;
                    if (shape3 > 0) {
                        int i6 = 0;
                        while (true) {
                            int i7 = i6 + 1;
                            if (i3 > 0) {
                                int i8 = 0;
                                while (true) {
                                    int i9 = i8 + 1;
                                    int i10 = i8 * shape3;
                                    int i11 = (i4 * i3 * shape3) + i10 + i6;
                                    int i12 = (i4 * shape2 * shape3) + i10 + i6;
                                    data2[i11] = Float.MIN_VALUE;
                                    if (poolSize > 0) {
                                        int i13 = 0;
                                        while (true) {
                                            int i14 = i13 + 1;
                                            i2 = shape2;
                                            data2[i11] = Math.max(data2[i11], data[i12 + (i13 * shape3)]);
                                            if (i14 >= poolSize) {
                                                break;
                                            }
                                            i13 = i14;
                                            shape2 = i2;
                                        }
                                    } else {
                                        i2 = shape2;
                                    }
                                    if (i9 >= i3) {
                                        break;
                                    }
                                    i8 = i9;
                                    shape2 = i2;
                                }
                            } else {
                                i2 = shape2;
                            }
                            if (i7 >= shape3) {
                                break;
                            }
                            i6 = i7;
                            shape2 = i2;
                        }
                    } else {
                        i2 = shape2;
                    }
                    if (i5 >= shape) {
                        break;
                    }
                    i4 = i5;
                    shape2 = i2;
                }
            }
            return mTensor;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Operator.class);
            return null;
        }
    }

    @JvmStatic
    @NotNull
    public static final MTensor mul(@NotNull MTensor x2, @NotNull MTensor w2) {
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return null;
        }
        try {
            s.e(x2, "x");
            s.e(w2, "w");
            int shape = x2.getShape(0);
            int shape2 = w2.getShape(0);
            int shape3 = w2.getShape(1);
            MTensor mTensor = new MTensor(new int[]{shape, shape3});
            float[] data = x2.getData();
            float[] data2 = w2.getData();
            float[] data3 = mTensor.getData();
            if (shape > 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    if (shape3 > 0) {
                        int i4 = 0;
                        while (true) {
                            int i5 = i4 + 1;
                            int i6 = (i2 * shape3) + i4;
                            data3[i6] = 0.0f;
                            if (shape2 > 0) {
                                int i7 = 0;
                                while (true) {
                                    int i8 = i7 + 1;
                                    data3[i6] = data3[i6] + (data[(i2 * shape2) + i7] * data2[(i7 * shape3) + i4]);
                                    if (i8 >= shape2) {
                                        break;
                                    }
                                    i7 = i8;
                                }
                            }
                            if (i5 >= shape3) {
                                break;
                            }
                            i4 = i5;
                        }
                    }
                    if (i3 >= shape) {
                        break;
                    }
                    i2 = i3;
                }
            }
            return mTensor;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Operator.class);
            return null;
        }
    }

    @JvmStatic
    public static final void relu(@NotNull MTensor x2) {
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return;
        }
        try {
            s.e(x2, "x");
            float[] data = x2.getData();
            int i2 = 0;
            int length = data.length - 1;
            if (length < 0) {
                return;
            }
            while (true) {
                int i3 = i2 + 1;
                if (data[i2] < 0.0f) {
                    data[i2] = 0.0f;
                }
                if (i3 > length) {
                    return;
                } else {
                    i2 = i3;
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Operator.class);
        }
    }

    @JvmStatic
    public static final void softmax(@NotNull MTensor x2) {
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return;
        }
        try {
            s.e(x2, "x");
            int i2 = 0;
            int shape = x2.getShape(0);
            int shape2 = x2.getShape(1);
            float[] data = x2.getData();
            if (shape <= 0) {
                return;
            }
            while (true) {
                int i3 = i2 + 1;
                int i4 = i2 * shape2;
                int i5 = i4 + shape2;
                float f2 = Float.MIN_VALUE;
                float f3 = 0.0f;
                if (i4 < i5) {
                    int i6 = i4;
                    while (true) {
                        int i7 = i6 + 1;
                        float f4 = data[i6];
                        if (f4 > f2) {
                            f2 = f4;
                        }
                        if (i7 >= i5) {
                            break;
                        } else {
                            i6 = i7;
                        }
                    }
                }
                if (i4 < i5) {
                    int i8 = i4;
                    while (true) {
                        int i9 = i8 + 1;
                        float fExp = (float) Math.exp(data[i8] - f2);
                        data[i8] = fExp;
                        f3 += fExp;
                        if (i9 >= i5) {
                            break;
                        } else {
                            i8 = i9;
                        }
                    }
                }
                if (i4 < i5) {
                    while (true) {
                        int i10 = i4 + 1;
                        data[i4] = data[i4] / f3;
                        if (i10 >= i5) {
                            break;
                        } else {
                            i4 = i10;
                        }
                    }
                }
                if (i3 >= shape) {
                    return;
                } else {
                    i2 = i3;
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Operator.class);
        }
    }

    @JvmStatic
    @NotNull
    public static final MTensor transpose2D(@NotNull MTensor x2) {
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return null;
        }
        try {
            s.e(x2, "x");
            int shape = x2.getShape(0);
            int shape2 = x2.getShape(1);
            MTensor mTensor = new MTensor(new int[]{shape2, shape});
            float[] data = x2.getData();
            float[] data2 = mTensor.getData();
            if (shape > 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    if (shape2 > 0) {
                        int i4 = 0;
                        while (true) {
                            int i5 = i4 + 1;
                            data2[(i4 * shape) + i2] = data[(i2 * shape2) + i4];
                            if (i5 >= shape2) {
                                break;
                            }
                            i4 = i5;
                        }
                    }
                    if (i3 >= shape) {
                        break;
                    }
                    i2 = i3;
                }
            }
            return mTensor;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Operator.class);
            return null;
        }
    }

    @JvmStatic
    @NotNull
    public static final MTensor transpose3D(@NotNull MTensor x2) {
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return null;
        }
        try {
            s.e(x2, "x");
            int shape = x2.getShape(0);
            int shape2 = x2.getShape(1);
            int shape3 = x2.getShape(2);
            MTensor mTensor = new MTensor(new int[]{shape3, shape2, shape});
            float[] data = x2.getData();
            float[] data2 = mTensor.getData();
            if (shape > 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    if (shape2 > 0) {
                        int i4 = 0;
                        while (true) {
                            int i5 = i4 + 1;
                            if (shape3 > 0) {
                                int i6 = 0;
                                while (true) {
                                    int i7 = i6 + 1;
                                    data2[(i6 * shape * shape2) + (i4 * shape) + i2] = data[(i2 * shape2 * shape3) + (i4 * shape3) + i6];
                                    if (i7 >= shape3) {
                                        break;
                                    }
                                    i6 = i7;
                                }
                            }
                            if (i5 >= shape2) {
                                break;
                            }
                            i4 = i5;
                        }
                    }
                    if (i3 >= shape) {
                        break;
                    }
                    i2 = i3;
                }
            }
            return mTensor;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Operator.class);
            return null;
        }
    }
}
