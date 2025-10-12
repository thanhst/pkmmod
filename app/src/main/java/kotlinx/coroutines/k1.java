package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {}, d1 = {"kotlinx/coroutines/l1"}, d2 = {}, k = 4, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class k1 {
    @NotNull
    public static final u a(@Nullable h1 h1Var) {
        return l1.a(h1Var);
    }

    public static final void c(@NotNull CoroutineContext coroutineContext, @Nullable CancellationException cancellationException) {
        l1.c(coroutineContext, cancellationException);
    }

    @NotNull
    public static final q0 d(@NotNull h1 h1Var, @NotNull q0 q0Var) {
        return l1.d(h1Var, q0Var);
    }

    public static final void e(@NotNull CoroutineContext coroutineContext) {
        l1.e(coroutineContext);
    }

    public static final void f(@NotNull h1 h1Var) {
        l1.f(h1Var);
    }

    @NotNull
    public static final h1 g(@NotNull CoroutineContext coroutineContext) {
        return l1.g(coroutineContext);
    }
}
