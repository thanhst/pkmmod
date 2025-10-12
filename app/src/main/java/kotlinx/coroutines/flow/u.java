package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.k;
import org.jetbrains.annotations.NotNull;

/* compiled from: Context.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a0\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004¨\u0006\u0007"}, d2 = {"T", "Lkotlinx/coroutines/flow/d;", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "a", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes.dex */
final /* synthetic */ class u {
    @NotNull
    public static final <T> d<T> a(@NotNull d<? extends T> dVar, int i2, @NotNull BufferOverflow bufferOverflow) {
        int i3;
        BufferOverflow bufferOverflow2;
        boolean z2 = true;
        if (!(i2 >= 0 || i2 == -2 || i2 == -1)) {
            throw new IllegalArgumentException(kotlin.jvm.internal.s.m("Buffer size should be non-negative, BUFFERED, or CONFLATED, but was ", Integer.valueOf(i2)).toString());
        }
        if (i2 == -1 && bufferOverflow != BufferOverflow.SUSPEND) {
            z2 = false;
        }
        if (!z2) {
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
        }
        if (i2 == -1) {
            bufferOverflow2 = BufferOverflow.DROP_OLDEST;
            i3 = 0;
        } else {
            i3 = i2;
            bufferOverflow2 = bufferOverflow;
        }
        return dVar instanceof kotlinx.coroutines.flow.internal.k ? k.a.a((kotlinx.coroutines.flow.internal.k) dVar, null, i3, bufferOverflow2, 1, null) : new kotlinx.coroutines.flow.internal.f(dVar, null, i3, bufferOverflow2, 2, null);
    }

    public static /* synthetic */ d b(d dVar, int i2, BufferOverflow bufferOverflow, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = -2;
        }
        if ((i3 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        return f.a(dVar, i2, bufferOverflow);
    }
}
