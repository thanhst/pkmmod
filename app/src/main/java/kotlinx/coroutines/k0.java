package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: DefaultExecutor.kt */
@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u001a\b\u0010\u0001\u001a\u00020\u0000H\u0002\"\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004\"\u001a\u0010\b\u001a\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0001\u0010\u0006\u001a\u0004\b\u0003\u0010\u0007¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/l0;", "b", "", "a", "Z", "defaultMainDelayOptIn", "Lkotlinx/coroutines/l0;", "()Lkotlinx/coroutines/l0;", "DefaultDelay", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class k0 {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f3856a = kotlinx.coroutines.internal.e0.e("kotlinx.coroutines.main.delay", false);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final l0 f3857b = b();

    @NotNull
    public static final l0 a() {
        return f3857b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final l0 b() {
        if (!f3856a) {
            return j0.f3853k;
        }
        q1 q1VarC = p0.c();
        return (kotlinx.coroutines.internal.u.c(q1VarC) || !(q1VarC instanceof l0)) ? j0.f3853k : (l0) q1VarC;
    }
}
