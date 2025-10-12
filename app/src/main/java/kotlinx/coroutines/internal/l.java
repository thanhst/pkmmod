package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.q0;
import org.jetbrains.annotations.NotNull;

/* compiled from: LimitedDispatcher.kt */
@Metadata(bv = {}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u00032\u00020\u0004B\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0001\u0012\u0006\u0010\u001b\u001a\u00020\u0019¢\u0006\u0004\b&\u0010'J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0014\u0010\b\u001a\u00020\u00052\n\u0010\u0007\u001a\u00060\u0002j\u0002`\u0003H\u0002J%\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\n\u0010\u0007\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0096\u0001J\u001f\u0010\u0012\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0096\u0001J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\u001c\u0010\u0014\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\n\u0010\u0007\u001a\u00060\u0002j\u0002`\u0003H\u0016J\u001c\u0010\u0015\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\n\u0010\u0007\u001a\u00060\u0002j\u0002`\u0003H\u0017R\u0014\u0010\u0018\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u001e\u0010 \u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010%\u001a\u00060!j\u0002`\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006("}, d2 = {"Lkotlinx/coroutines/internal/l;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "Lkotlinx/coroutines/l0;", "", "s", "block", "q", "", "timeMillis", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlinx/coroutines/q0;", "c", "Lkotlinx/coroutines/k;", "Lkotlin/t;", "continuation", "e", "run", "g", "h", "f", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "", "I", "parallelism", "runningWorkers", "Lkotlinx/coroutines/internal/q;", "i", "Lkotlinx/coroutines/internal/q;", "queue", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "j", "Ljava/lang/Object;", "workerAllocationLock", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class l extends CoroutineDispatcher implements Runnable, l0 {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineDispatcher dispatcher;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final int parallelism;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ l0 f3829h;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final q<Runnable> queue;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Object workerAllocationLock;
    private volatile int runningWorkers;

    /* JADX WARN: Multi-variable type inference failed */
    public l(@NotNull CoroutineDispatcher coroutineDispatcher, int i2) {
        this.dispatcher = coroutineDispatcher;
        this.parallelism = i2;
        l0 l0Var = coroutineDispatcher instanceof l0 ? (l0) coroutineDispatcher : null;
        this.f3829h = l0Var == null ? k0.a() : l0Var;
        this.queue = new q<>(false);
        this.workerAllocationLock = new Object();
    }

    private final boolean q(Runnable block) {
        this.queue.a(block);
        return this.runningWorkers >= this.parallelism;
    }

    private final boolean s() {
        synchronized (this.workerAllocationLock) {
            if (this.runningWorkers >= this.parallelism) {
                return false;
            }
            this.runningWorkers++;
            return true;
        }
    }

    @Override // kotlinx.coroutines.l0
    @NotNull
    public q0 c(long timeMillis, @NotNull Runnable block, @NotNull CoroutineContext context) {
        return this.f3829h.c(timeMillis, block, context);
    }

    @Override // kotlinx.coroutines.l0
    public void e(long j2, @NotNull kotlinx.coroutines.k<? super kotlin.t> kVar) {
        this.f3829h.e(j2, kVar);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void g(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        if (!q(runnable) && s()) {
            this.dispatcher.g(this, this);
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @InternalCoroutinesApi
    public void h(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        if (!q(runnable) && s()) {
            this.dispatcher.h(this, this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002a, code lost:
    
        r1 = r4.workerAllocationLock;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002c, code lost:
    
        monitor-enter(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002d, code lost:
    
        r4.runningWorkers--;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0039, code lost:
    
        if (r4.queue.c() != 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003b, code lost:
    
        monitor-exit(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003c, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003d, code lost:
    
        r4.runningWorkers++;
        r2 = kotlin.t.f3507a;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            r4 = this;
            r0 = 0
        L1:
            r1 = 0
        L2:
            kotlinx.coroutines.internal.q<java.lang.Runnable> r2 = r4.queue
            java.lang.Object r2 = r2.d()
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            if (r2 == 0) goto L2a
            r2.run()     // Catch: java.lang.Throwable -> L10
            goto L16
        L10:
            r2 = move-exception
            kotlin.coroutines.EmptyCoroutineContext r3 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlinx.coroutines.d0.a(r3, r2)
        L16:
            int r1 = r1 + 1
            r2 = 16
            if (r1 < r2) goto L2
            kotlinx.coroutines.CoroutineDispatcher r2 = r4.dispatcher
            boolean r2 = r2.k(r4)
            if (r2 == 0) goto L2
            kotlinx.coroutines.CoroutineDispatcher r0 = r4.dispatcher
            r0.g(r4, r4)
            return
        L2a:
            java.lang.Object r1 = r4.workerAllocationLock
            monitor-enter(r1)
            int r2 = r4.runningWorkers     // Catch: java.lang.Throwable -> L47
            int r2 = r2 + (-1)
            r4.runningWorkers = r2     // Catch: java.lang.Throwable -> L47
            kotlinx.coroutines.internal.q<java.lang.Runnable> r2 = r4.queue     // Catch: java.lang.Throwable -> L47
            int r2 = r2.c()     // Catch: java.lang.Throwable -> L47
            if (r2 != 0) goto L3d
            monitor-exit(r1)
            return
        L3d:
            int r2 = r4.runningWorkers     // Catch: java.lang.Throwable -> L47
            int r2 = r2 + 1
            r4.runningWorkers = r2     // Catch: java.lang.Throwable -> L47
            kotlin.t r2 = kotlin.t.f3507a     // Catch: java.lang.Throwable -> L47
            monitor-exit(r1)
            goto L1
        L47:
            r0 = move-exception
            monitor-exit(r1)
            goto L4b
        L4a:
            throw r0
        L4b:
            goto L4a
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.l.run():void");
    }
}
