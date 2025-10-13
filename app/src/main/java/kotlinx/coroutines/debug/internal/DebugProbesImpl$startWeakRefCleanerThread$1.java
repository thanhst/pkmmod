package kotlinx.coroutines.debug.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.t;
import p0.a_p0;

/* compiled from: DebugProbesImpl.kt */
@Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lkotlin/t;", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 6, 0})
/* loaded from: classes.dex */
final class DebugProbesImpl$startWeakRefCleanerThread$1 extends Lambda implements a_p0<t> {
    public static final DebugProbesImpl$startWeakRefCleanerThread$1 INSTANCE = new DebugProbesImpl$startWeakRefCleanerThread$1();

    DebugProbesImpl$startWeakRefCleanerThread$1() {
        super(0);
    }

    @Override // p0.a
    public /* bridge */ /* synthetic */ t invoke() throws InterruptedException {
        invoke2();
        return t.f3507a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() throws InterruptedException {
        d.callerInfoCache.j();
    }
}
