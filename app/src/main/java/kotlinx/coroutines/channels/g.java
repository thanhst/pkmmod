package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.t;
import p0.l_p0;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Channel.kt */
@Metadata(bv = {}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a>\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¨\u0006\n"}, d2 = {"E", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlin/Function1;", "Lkotlin/t;", "onUndeliveredElement", "Lkotlinx/coroutines/channels/e;", "a", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class g {
    @NotNull
    public static final <E> e<E> a(int i2, @NotNull BufferOverflow bufferOverflow, @Nullable l_p0<? super E, t> lP0Var) {
        if (i2 == -2) {
            return new c(bufferOverflow == BufferOverflow.SUSPEND ? e.INSTANCE.a() : 1, bufferOverflow, lP0Var);
        }
        if (i2 != -1) {
            return i2 != 0 ? i2 != Integer.MAX_VALUE ? (i2 == 1 && bufferOverflow == BufferOverflow.DROP_OLDEST) ? new k(lP0Var) : new c(i2, bufferOverflow, lP0Var) : new l(lP0Var) : bufferOverflow == BufferOverflow.SUSPEND ? new q(lP0Var) : new c(1, bufferOverflow, lP0Var);
        }
        if ((bufferOverflow != BufferOverflow.SUSPEND ? 0 : 1) != 0) {
            return new k(lP0Var);
        }
        throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
    }

    public static /* synthetic */ e b(int i2, BufferOverflow bufferOverflow, l_p0 lP0Var, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        if ((i3 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        if ((i3 & 4) != 0) {
            lP0Var = null;
        }
        return a(i2, bufferOverflow, lP0Var);
    }
}
