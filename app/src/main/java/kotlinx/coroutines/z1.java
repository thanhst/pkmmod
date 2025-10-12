package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: EventLoop.common.kt */
@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0007\u0010\bR(\u0010\f\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00050\tj\n\u0012\u0006\u0012\u0004\u0018\u00010\u0005`\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000bR\u0014\u0010\u0006\u001a\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/z1;", "", "Lkotlin/t;", "b", "()V", "Lkotlinx/coroutines/u0;", "eventLoop", "c", "(Lkotlinx/coroutines/u0;)V", "Ljava/lang/ThreadLocal;", "Lkotlinx/coroutines/internal/CommonThreadLocal;", "Ljava/lang/ThreadLocal;", "ref", "a", "()Lkotlinx/coroutines/u0;", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class z1 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final z1 f4018a = new z1();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ThreadLocal<u0> ref = new ThreadLocal<>();

    private z1() {
    }

    @NotNull
    public final u0 a() {
        ThreadLocal<u0> threadLocal = ref;
        u0 u0Var = threadLocal.get();
        if (u0Var != null) {
            return u0Var;
        }
        u0 u0VarA = x0.a();
        threadLocal.set(u0VarA);
        return u0VarA;
    }

    public final void b() {
        ref.set(null);
    }

    public final void c(@NotNull u0 eventLoop) {
        ref.set(eventLoop);
    }
}
