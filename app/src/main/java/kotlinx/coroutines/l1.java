package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Job.kt */
@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0012\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u001a\u0014\u0010\u0006\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0000\u001a\u001c\u0010\f\u001a\u00020\u000b*\u00020\u00072\u0010\b\u0002\u0010\n\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t\u001a\n\u0010\r\u001a\u00020\u000b*\u00020\u0000\u001a\n\u0010\u000e\u001a\u00020\u000b*\u00020\u0007\"\u0015\u0010\u0011\u001a\u00020\u0000*\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/h1;", "parent", "Lkotlinx/coroutines/u;", "a", "Lkotlinx/coroutines/q0;", "handle", "d", "Lkotlin/coroutines/CoroutineContext;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cause", "Lkotlin/t;", "c", "f", "e", "g", "(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/h1;", "job", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xs = "kotlinx/coroutines/JobKt")
/* loaded from: classes.dex */
public final /* synthetic */ class l1 {
    @NotNull
    public static final u a(@Nullable h1 h1Var) {
        return new j1(h1Var);
    }

    public static /* synthetic */ u b(h1 h1Var, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            h1Var = null;
        }
        return k1.a(h1Var);
    }

    public static final void c(@NotNull CoroutineContext coroutineContext, @Nullable CancellationException cancellationException) {
        h1 h1Var = (h1) coroutineContext.get(h1.INSTANCE);
        if (h1Var == null) {
            return;
        }
        h1Var.a(cancellationException);
    }

    @NotNull
    public static final q0 d(@NotNull h1 h1Var, @NotNull q0 q0Var) {
        return h1Var.i(new s0(q0Var));
    }

    public static final void e(@NotNull CoroutineContext coroutineContext) {
        h1 h1Var = (h1) coroutineContext.get(h1.INSTANCE);
        if (h1Var == null) {
            return;
        }
        k1.f(h1Var);
    }

    public static final void f(@NotNull h1 h1Var) {
        if (!h1Var.isActive()) {
            throw h1Var.t();
        }
    }

    @NotNull
    public static final h1 g(@NotNull CoroutineContext coroutineContext) {
        h1 h1Var = (h1) coroutineContext.get(h1.INSTANCE);
        if (h1Var != null) {
            return h1Var;
        }
        throw new IllegalStateException(kotlin.jvm.internal.s.m("Current context doesn't contain Job in it: ", coroutineContext).toString());
    }
}
