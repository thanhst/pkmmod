package kotlinx.coroutines.android;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.o;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.q0;
import kotlinx.coroutines.q1;
import org.jetbrains.annotations.NotNull;

/* compiled from: HandlerDispatcher.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004\u0082\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/android/b;", "Lkotlinx/coroutines/q1;", "Lkotlinx/coroutines/l0;", "<init>", "()V", "Lkotlinx/coroutines/android/HandlerContext;", "kotlinx-coroutines-android"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public abstract class b extends q1 implements l0 {
    private b() {
    }

    public /* synthetic */ b(o oVar) {
        this();
    }

    @NotNull
    public q0 c(long j2, @NotNull Runnable runnable, @NotNull CoroutineContext coroutineContext) {
        return l0.a.a(this, j2, runnable, coroutineContext);
    }
}
