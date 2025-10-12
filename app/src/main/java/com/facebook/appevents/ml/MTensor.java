package com.facebook.appevents.ml;

import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.collections.n;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: MTensor.kt */
@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\f\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\tR\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR$\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/facebook/appevents/ml/MTensor;", "", "", "i", "getShape", "", "shape", "Lkotlin/t;", "reshape", "[I", "capacity", "I", "", "<set-?>", ShareConstants.WEB_DIALOG_PARAM_DATA, "[F", "getData", "()[F", "getShapeSize", "()I", "shapeSize", "<init>", "([I)V", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class MTensor {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private int capacity;

    @NotNull
    private float[] data;

    @NotNull
    private int[] shape;

    /* compiled from: MTensor.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0007"}, d2 = {"Lcom/facebook/appevents/ml/MTensor$Companion;", "", "()V", "getCapacity", "", "shape", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(o oVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int getCapacity(int[] shape) {
            int i2 = 1;
            if (shape.length == 0) {
                throw new UnsupportedOperationException("Empty array can't be reduced.");
            }
            int i3 = shape[0];
            int iN = n.n(shape);
            if (1 <= iN) {
                while (true) {
                    i3 *= shape[i2];
                    if (i2 == iN) {
                        break;
                    }
                    i2++;
                }
            }
            return i3;
        }
    }

    public MTensor(@NotNull int[] shape) {
        s.e(shape, "shape");
        this.shape = shape;
        int capacity = INSTANCE.getCapacity(shape);
        this.capacity = capacity;
        this.data = new float[capacity];
    }

    @NotNull
    public final float[] getData() {
        return this.data;
    }

    public final int getShape(int i2) {
        return this.shape[i2];
    }

    public final int getShapeSize() {
        return this.shape.length;
    }

    public final void reshape(@NotNull int[] shape) {
        s.e(shape, "shape");
        this.shape = shape;
        int capacity = INSTANCE.getCapacity(shape);
        float[] fArr = new float[capacity];
        System.arraycopy(this.data, 0, fArr, 0, Math.min(this.capacity, capacity));
        this.data = fArr;
        this.capacity = capacity;
    }
}
