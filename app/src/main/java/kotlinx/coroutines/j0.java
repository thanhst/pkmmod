package kotlinx.coroutines;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.v0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DefaultExecutor.kt */
@Metadata(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\f\bÀ\u0002\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003B\t\b\u0002¢\u0006\u0004\b,\u0010 J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0014\u0010\f\u001a\u00020\u00042\n\u0010\u000b\u001a\u00060\u0002j\u0002`\u0003H\u0016J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0014J\b\u0010\u0012\u001a\u00020\u0004H\u0016J$\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\r2\n\u0010\u0014\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016R\u0014\u0010\u001c\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u0012\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010&\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010(\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010%R\u0014\u0010+\u001a\u00020\u00068TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u0006-"}, d2 = {"Lkotlinx/coroutines/j0;", "Lkotlinx/coroutines/v0;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "Lkotlin/t;", "c0", "Ljava/lang/Thread;", "Y", "", "b0", "X", "task", "M", "", "now", "Lkotlinx/coroutines/v0$c;", "delayedTask", "H", "shutdown", "timeMillis", "block", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlinx/coroutines/q0;", "c", "run", "l", "J", "KEEP_ALIVE_NANOS", "_thread", "Ljava/lang/Thread;", "get_thread$annotations", "()V", "", "debugStatus", "I", "Z", "()Z", "isShutDown", "a0", "isShutdownRequested", "G", "()Ljava/lang/Thread;", "thread", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class j0 extends v0 implements Runnable {

    @Nullable
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public static final j0 f3853k;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private static final long KEEP_ALIVE_NANOS;

    static {
        Long l2;
        j0 j0Var = new j0();
        f3853k = j0Var;
        u0.z(j0Var, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l2 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l2 = 1000L;
        }
        KEEP_ALIVE_NANOS = timeUnit.toNanos(l2.longValue());
    }

    private j0() {
    }

    private final synchronized void X() {
        if (a0()) {
            debugStatus = 3;
            R();
            notifyAll();
        }
    }

    private final synchronized Thread Y() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    private final boolean Z() {
        return debugStatus == 4;
    }

    private final boolean a0() {
        int i2 = debugStatus;
        return i2 == 2 || i2 == 3;
    }

    private final synchronized boolean b0() {
        if (a0()) {
            return false;
        }
        debugStatus = 1;
        notifyAll();
        return true;
    }

    private final void c0() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // kotlinx.coroutines.w0
    @NotNull
    /* renamed from: G */
    protected Thread getThread() {
        Thread thread = _thread;
        return thread == null ? Y() : thread;
    }

    @Override // kotlinx.coroutines.w0
    protected void H(long j2, @NotNull v0.c cVar) {
        c0();
    }

    @Override // kotlinx.coroutines.v0
    public void M(@NotNull Runnable runnable) {
        if (Z()) {
            c0();
        }
        super.M(runnable);
    }

    @Override // kotlinx.coroutines.v0, kotlinx.coroutines.l0
    @NotNull
    public q0 c(long timeMillis, @NotNull Runnable block, @NotNull CoroutineContext context) {
        return U(timeMillis, block);
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean zO;
        z1.f4018a.c(this);
        c.a();
        try {
            if (!b0()) {
                if (zO) {
                    return;
                } else {
                    return;
                }
            }
            long j2 = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long jP = P();
                if (jP == Long.MAX_VALUE) {
                    c.a();
                    long jNanoTime = System.nanoTime();
                    if (j2 == Long.MAX_VALUE) {
                        j2 = KEEP_ALIVE_NANOS + jNanoTime;
                    }
                    long j3 = j2 - jNanoTime;
                    if (j3 <= 0) {
                        _thread = null;
                        X();
                        c.a();
                        if (O()) {
                            return;
                        }
                        getThread();
                        return;
                    }
                    jP = s0.l.d(jP, j3);
                } else {
                    j2 = Long.MAX_VALUE;
                }
                if (jP > 0) {
                    if (a0()) {
                        _thread = null;
                        X();
                        c.a();
                        if (O()) {
                            return;
                        }
                        getThread();
                        return;
                    }
                    c.a();
                    LockSupport.parkNanos(this, jP);
                }
            }
        } finally {
            _thread = null;
            X();
            c.a();
            if (!O()) {
                getThread();
            }
        }
    }

    @Override // kotlinx.coroutines.v0, kotlinx.coroutines.u0
    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }
}
