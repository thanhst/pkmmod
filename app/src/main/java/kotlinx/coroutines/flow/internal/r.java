package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.SharedFlowImpl;
import kotlinx.coroutines.flow.p1;

/* compiled from: AbstractSharedFlow.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/flow/internal/r;", "Lkotlinx/coroutines/flow/p1;", "", "Lkotlinx/coroutines/flow/SharedFlowImpl;", "delta", "", "Y", "initialValue", "<init>", "(I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
final class r extends SharedFlowImpl<Integer> implements p1<Integer> {
    public r(int i2) {
        super(1, Integer.MAX_VALUE, BufferOverflow.DROP_OLDEST);
        d(Integer.valueOf(i2));
    }

    public final boolean Y(int delta) {
        boolean zD;
        synchronized (this) {
            zD = d(Integer.valueOf(L().intValue() + delta));
        }
        return zD;
    }
}
