package kotlinx.coroutines.debug.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.debug.internal.d;
import org.jetbrains.annotations.NotNull;
import p0.l;

/* compiled from: DebugProbesImpl.kt */
@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/debug/internal/d$a;", "it", "", "invoke", "(Lkotlinx/coroutines/debug/internal/d$a;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
/* loaded from: classes.dex */
final class DebugProbesImpl$dumpCoroutinesSynchronized$1$2 extends Lambda implements l<d.a<?>, Boolean> {
    public static final DebugProbesImpl$dumpCoroutinesSynchronized$1$2 INSTANCE = new DebugProbesImpl$dumpCoroutinesSynchronized$1$2();

    DebugProbesImpl$dumpCoroutinesSynchronized$1$2() {
        super(1);
    }

    @Override // p0.l
    @NotNull
    public final Boolean invoke(@NotNull d.a<?> aVar) {
        return Boolean.valueOf(!d.f3643a.e(aVar));
    }
}
