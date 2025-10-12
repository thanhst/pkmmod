package kotlinx.coroutines.internal;

import kotlin.Metadata;

/* compiled from: LimitedDispatcher.kt */
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¨\u0006\u0003"}, d2 = {"", "Lkotlin/t;", "a", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class m {
    public static final void a(int i2) {
        if (!(i2 >= 1)) {
            throw new IllegalArgumentException(kotlin.jvm.internal.s.m("Expected positive parallelism level, but got ", Integer.valueOf(i2)).toString());
        }
    }
}
