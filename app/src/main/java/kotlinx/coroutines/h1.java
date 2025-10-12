package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Job.kt */
@Metadata(bv = {}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\bf\u0018\u0000  2\u00020\u0001:\u0001!J\f\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H'J\b\u0010\u0006\u001a\u00020\u0005H&J\u001a\u0010\t\u001a\u00020\b2\u0010\b\u0002\u0010\u0007\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003H&J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH'J\u0013\u0010\u000e\u001a\u00020\bH¦@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ1\u0010\u0017\u001a\u00020\u00162'\u0010\u0015\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0010j\u0002`\u0014H&JE\u0010\u001a\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u00052'\u0010\u0015\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0010j\u0002`\u0014H'R\u0014\u0010\u001b\u001a\u00020\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001c\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"Lkotlinx/coroutines/h1;", "Lkotlin/coroutines/CoroutineContext$a;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "t", "", "start", "cause", "Lkotlin/t;", "a", "Lkotlinx/coroutines/s;", "child", "Lkotlinx/coroutines/q;", "F", "m", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "Lkotlinx/coroutines/q0;", "i", "onCancelling", "invokeImmediately", "u", "isActive", "()Z", "w", "isCompleted", "isCancelled", "c", "b", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public interface h1 extends CoroutineContext.a {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f3781e;

    /* compiled from: Job.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        public static <R> R a(@NotNull h1 h1Var, R r2, @NotNull p0.p<? super R, ? super CoroutineContext.a, ? extends R> pVar) {
            return (R) CoroutineContext.a.C0056a.a(h1Var, r2, pVar);
        }

        @Nullable
        public static <E extends CoroutineContext.a> E b(@NotNull h1 h1Var, @NotNull CoroutineContext.b<E> bVar) {
            return (E) CoroutineContext.a.C0056a.b(h1Var, bVar);
        }

        public static /* synthetic */ q0 c(h1 h1Var, boolean z2, boolean z3, p0.l lVar, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
            }
            if ((i2 & 1) != 0) {
                z2 = false;
            }
            if ((i2 & 2) != 0) {
                z3 = true;
            }
            return h1Var.u(z2, z3, lVar);
        }

        @NotNull
        public static CoroutineContext d(@NotNull h1 h1Var, @NotNull CoroutineContext.b<?> bVar) {
            return CoroutineContext.a.C0056a.c(h1Var, bVar);
        }

        @NotNull
        public static CoroutineContext e(@NotNull h1 h1Var, @NotNull CoroutineContext coroutineContext) {
            return CoroutineContext.a.C0056a.d(h1Var, coroutineContext);
        }
    }

    /* compiled from: Job.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/h1$b;", "Lkotlin/coroutines/CoroutineContext$b;", "Lkotlinx/coroutines/h1;", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    /* renamed from: kotlinx.coroutines.h1$b, reason: from kotlin metadata */
    public static final class Companion implements CoroutineContext.b<h1> {

        /* renamed from: e, reason: collision with root package name */
        static final /* synthetic */ Companion f3781e = new Companion();

        private Companion() {
        }
    }

    @InternalCoroutinesApi
    @NotNull
    q F(@NotNull s child);

    void a(@Nullable CancellationException cancellationException);

    @NotNull
    q0 i(@NotNull p0.l<? super Throwable, kotlin.t> lVar);

    boolean isActive();

    boolean isCancelled();

    @Nullable
    Object m(@NotNull kotlin.coroutines.c<? super kotlin.t> cVar);

    boolean start();

    @InternalCoroutinesApi
    @NotNull
    CancellationException t();

    @InternalCoroutinesApi
    @NotNull
    q0 u(boolean z2, boolean z3, @NotNull p0.l<? super Throwable, kotlin.t> lVar);

    boolean w();
}
