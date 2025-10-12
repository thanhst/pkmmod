package kotlinx.coroutines.scheduling;

import android.support.v4.media.session.PlaybackStateCompat;
import com.facebook.internal.ServerProtocol;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.s;
import kotlin.random.Random;
import kotlin.t;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.internal.d0;
import kotlinx.coroutines.internal.y;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CoroutineScheduler.kt */
@Metadata(bv = {}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0003\u00064NB+\u0012\u0006\u0010=\u001a\u00020\f\u0012\u0006\u0010?\u001a\u00020\f\u0012\b\b\u0002\u0010A\u001a\u00020\u0013\u0012\b\b\u0002\u0010C\u001a\u000207¢\u0006\u0004\bL\u0010MJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0018\u00010\bR\u00020\u0000H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\r\u001a\u00020\f2\n\u0010\u000b\u001a\u00060\bR\u00020\u0000H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ+\u0010\u001c\u001a\u0004\u0018\u00010\u0003*\b\u0018\u00010\bR\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001e\u001a\b\u0018\u00010\bR\u00020\u0000H\u0002¢\u0006\u0004\b\u001e\u0010\nJ)\u0010!\u001a\u00020\u00102\n\u0010\u000b\u001a\u00060\bR\u00020\u00002\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\f¢\u0006\u0004\b!\u0010\"J\u0019\u0010#\u001a\u00020\u00052\n\u0010\u000b\u001a\u00060\bR\u00020\u0000¢\u0006\u0004\b#\u0010$J\u001b\u0010(\u001a\u00020\u00102\n\u0010'\u001a\u00060%j\u0002`&H\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0010H\u0016¢\u0006\u0004\b*\u0010+J\u0015\u0010-\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u0013¢\u0006\u0004\b-\u0010.J-\u00102\u001a\u00020\u00102\n\u0010/\u001a\u00060%j\u0002`&2\b\b\u0002\u00101\u001a\u0002002\b\b\u0002\u0010\u001b\u001a\u00020\u0005¢\u0006\u0004\b2\u00103J!\u00104\u001a\u00020\u00032\n\u0010/\u001a\u00060%j\u0002`&2\u0006\u00101\u001a\u000200¢\u0006\u0004\b4\u00105J\r\u00106\u001a\u00020\u0010¢\u0006\u0004\b6\u0010+J\u000f\u00108\u001a\u000207H\u0016¢\u0006\u0004\b8\u00109J\u0015\u0010:\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b:\u0010;R\u0014\u0010=\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b2\u0010<R\u0014\u0010?\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b>\u0010<R\u0014\u0010A\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\r\u0010@R\u0014\u0010C\u001a\u0002078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\t\u0010BR\u0014\u0010F\u001a\u00020D8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b#\u0010ER\u0014\u0010G\u001a\u00020D8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b!\u0010ER\u001e\u0010J\u001a\f\u0012\b\u0012\u00060\bR\u00020\u00000H8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b:\u0010IR\u0011\u0010K\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\bK\u0010\u0018¨\u0006O"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "Ljava/util/concurrent/Executor;", "Ljava/io/Closeable;", "Lkotlinx/coroutines/scheduling/g;", "task", "", "a", "(Lkotlinx/coroutines/scheduling/g;)Z", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$c;", "h", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler$c;", "worker", "", "g", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$c;)I", "skipUnpark", "Lkotlin/t;", "m", "(Z)V", "", ServerProtocol.DIALOG_PARAM_STATE, "p", "(J)Z", "r", "()Z", "b", "()I", "tailDispatch", "o", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$c;Lkotlinx/coroutines/scheduling/g;Z)Lkotlinx/coroutines/scheduling/g;", "d", "oldIndex", "newIndex", "j", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$c;II)V", "i", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$c;)Z", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "command", "execute", "(Ljava/lang/Runnable;)V", "close", "()V", "timeout", "l", "(J)V", "block", "Lkotlinx/coroutines/scheduling/h;", "taskContext", "e", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/h;Z)V", "c", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/h;)Lkotlinx/coroutines/scheduling/g;", "n", "", "toString", "()Ljava/lang/String;", "k", "(Lkotlinx/coroutines/scheduling/g;)V", "I", "corePoolSize", "f", "maxPoolSize", "J", "idleWorkerKeepAliveNs", "Ljava/lang/String;", "schedulerName", "Lkotlinx/coroutines/scheduling/c;", "Lkotlinx/coroutines/scheduling/c;", "globalCpuQueue", "globalBlockingQueue", "Lkotlinx/coroutines/internal/y;", "Lkotlinx/coroutines/internal/y;", "workers", "isTerminated", "<init>", "(IIJLjava/lang/String;)V", "WorkerState", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class CoroutineScheduler implements Executor, Closeable {

    @NotNull
    private volatile /* synthetic */ int _isTerminated;

    @NotNull
    volatile /* synthetic */ long controlState;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public final int corePoolSize;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public final int maxPoolSize;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public final long idleWorkerKeepAliveNs;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public final String schedulerName;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public final kotlinx.coroutines.scheduling.c globalCpuQueue;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public final kotlinx.coroutines.scheduling.c globalBlockingQueue;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public final y<c> workers;

    @NotNull
    private volatile /* synthetic */ long parkedWorkersStack;

    /* renamed from: p, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final d0 f3898p = new d0("NOT_IN_STACK");

    /* renamed from: m, reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f3895m = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack");

    /* renamed from: n, reason: collision with root package name */
    static final /* synthetic */ AtomicLongFieldUpdater f3896n = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState");

    /* renamed from: o, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f3897o = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated");

    /* compiled from: CoroutineScheduler.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "", "(Ljava/lang/String;I)V", "CPU_ACQUIRED", "BLOCKING", "PARKING", "DORMANT", "TERMINATED", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum WorkerState {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    /* compiled from: CoroutineScheduler.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3906a;

        static {
            int[] iArr = new int[WorkerState.values().length];
            iArr[WorkerState.PARKING.ordinal()] = 1;
            iArr[WorkerState.BLOCKING.ordinal()] = 2;
            iArr[WorkerState.CPU_ACQUIRED.ordinal()] = 3;
            iArr[WorkerState.DORMANT.ordinal()] = 4;
            iArr[WorkerState.TERMINATED.ordinal()] = 5;
            f3906a = iArr;
        }
    }

    public CoroutineScheduler(int i2, int i3, long j2, @NotNull String str) {
        this.corePoolSize = i2;
        this.maxPoolSize = i3;
        this.idleWorkerKeepAliveNs = j2;
        this.schedulerName = str;
        if (!(i2 >= 1)) {
            throw new IllegalArgumentException(("Core pool size " + i2 + " should be at least 1").toString());
        }
        if (!(i3 >= i2)) {
            throw new IllegalArgumentException(("Max pool size " + i3 + " should be greater than or equals to core pool size " + i2).toString());
        }
        if (!(i3 <= 2097150)) {
            throw new IllegalArgumentException(("Max pool size " + i3 + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (!(j2 > 0)) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j2 + " must be positive").toString());
        }
        this.globalCpuQueue = new kotlinx.coroutines.scheduling.c();
        this.globalBlockingQueue = new kotlinx.coroutines.scheduling.c();
        this.parkedWorkersStack = 0L;
        this.workers = new y<>(i2 + 1);
        this.controlState = i2 << 42;
        this._isTerminated = 0;
    }

    private final boolean a(g task) {
        return task.taskContext.getTaskMode() == 1 ? this.globalBlockingQueue.a(task) : this.globalCpuQueue.a(task);
    }

    private final int b() {
        synchronized (this.workers) {
            if (isTerminated()) {
                return -1;
            }
            long j2 = this.controlState;
            int i2 = (int) (j2 & 2097151);
            int iA = s0.l.a(i2 - ((int) ((j2 & 4398044413952L) >> 21)), 0);
            if (iA >= this.corePoolSize) {
                return 0;
            }
            if (i2 >= this.maxPoolSize) {
                return 0;
            }
            int i3 = ((int) (this.controlState & 2097151)) + 1;
            if (!(i3 > 0 && this.workers.b(i3) == null)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            c cVar = new c(i3);
            this.workers.c(i3, cVar);
            if (!(i3 == ((int) (2097151 & f3896n.incrementAndGet(this))))) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            cVar.start();
            return iA + 1;
        }
    }

    private final c d() {
        Thread threadCurrentThread = Thread.currentThread();
        c cVar = threadCurrentThread instanceof c ? (c) threadCurrentThread : null;
        if (cVar != null && s.a(CoroutineScheduler.this, this)) {
            return cVar;
        }
        return null;
    }

    public static /* synthetic */ void f(CoroutineScheduler coroutineScheduler, Runnable runnable, h hVar, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            hVar = k.f3933f;
        }
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        coroutineScheduler.e(runnable, hVar, z2);
    }

    private final int g(c worker) {
        Object nextParkedWorker = worker.getNextParkedWorker();
        while (nextParkedWorker != f3898p) {
            if (nextParkedWorker == null) {
                return 0;
            }
            c cVar = (c) nextParkedWorker;
            int indexInArray = cVar.getIndexInArray();
            if (indexInArray != 0) {
                return indexInArray;
            }
            nextParkedWorker = cVar.getNextParkedWorker();
        }
        return -1;
    }

    private final c h() {
        while (true) {
            long j2 = this.parkedWorkersStack;
            c cVarB = this.workers.b((int) (2097151 & j2));
            if (cVarB == null) {
                return null;
            }
            long j3 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j2) & (-2097152);
            int iG = g(cVarB);
            if (iG >= 0 && f3895m.compareAndSet(this, j2, iG | j3)) {
                cVarB.p(f3898p);
                return cVarB;
            }
        }
    }

    private final void m(boolean skipUnpark) {
        long jAddAndGet = f3896n.addAndGet(this, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE);
        if (skipUnpark || r() || p(jAddAndGet)) {
            return;
        }
        r();
    }

    private final g o(c cVar, g gVar, boolean z2) {
        if (cVar == null || cVar.state == WorkerState.TERMINATED) {
            return gVar;
        }
        if (gVar.taskContext.getTaskMode() == 0 && cVar.state == WorkerState.BLOCKING) {
            return gVar;
        }
        cVar.mayHaveLocalTasks = true;
        return cVar.localQueue.a(gVar, z2);
    }

    private final boolean p(long state) {
        if (s0.l.a(((int) (2097151 & state)) - ((int) ((state & 4398044413952L) >> 21)), 0) < this.corePoolSize) {
            int iB = b();
            if (iB == 1 && this.corePoolSize > 1) {
                b();
            }
            if (iB > 0) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ boolean q(CoroutineScheduler coroutineScheduler, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = coroutineScheduler.controlState;
        }
        return coroutineScheduler.p(j2);
    }

    private final boolean r() {
        c cVarH;
        do {
            cVarH = h();
            if (cVarH == null) {
                return false;
            }
        } while (!c.f3907l.compareAndSet(cVarH, -1, 0));
        LockSupport.unpark(cVarH);
        return true;
    }

    @NotNull
    public final g c(@NotNull Runnable block, @NotNull h taskContext) {
        long jA = k.f3932e.a();
        if (!(block instanceof g)) {
            return new j(block, jA, taskContext);
        }
        g gVar = (g) block;
        gVar.submissionTime = jA;
        gVar.taskContext = taskContext;
        return gVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws InterruptedException {
        l(10000L);
    }

    public final void e(@NotNull Runnable block, @NotNull h taskContext, boolean tailDispatch) {
        kotlinx.coroutines.c.a();
        g gVarC = c(block, taskContext);
        c cVarD = d();
        g gVarO = o(cVarD, gVarC, tailDispatch);
        if (gVarO != null && !a(gVarO)) {
            throw new RejectedExecutionException(s.m(this.schedulerName, " was terminated"));
        }
        boolean z2 = tailDispatch && cVarD != null;
        if (gVarC.taskContext.getTaskMode() != 0) {
            m(z2);
        } else {
            if (z2) {
                return;
            }
            n();
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NotNull Runnable command) {
        f(this, command, null, false, 6, null);
    }

    public final boolean i(@NotNull c worker) {
        long j2;
        long j3;
        int indexInArray;
        if (worker.getNextParkedWorker() != f3898p) {
            return false;
        }
        do {
            j2 = this.parkedWorkersStack;
            j3 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j2) & (-2097152);
            indexInArray = worker.getIndexInArray();
            worker.p(this.workers.b((int) (2097151 & j2)));
        } while (!f3895m.compareAndSet(this, j2, j3 | indexInArray));
        return true;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean isTerminated() {
        return this._isTerminated;
    }

    public final void j(@NotNull c worker, int oldIndex, int newIndex) {
        while (true) {
            long j2 = this.parkedWorkersStack;
            int iG = (int) (2097151 & j2);
            long j3 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j2) & (-2097152);
            if (iG == oldIndex) {
                iG = newIndex == 0 ? g(worker) : newIndex;
            }
            if (iG >= 0 && f3895m.compareAndSet(this, j2, j3 | iG)) {
                return;
            }
        }
    }

    public final void k(@NotNull g task) {
        try {
            task.run();
        } finally {
            try {
            } finally {
            }
        }
    }

    public final void l(long timeout) throws InterruptedException {
        int i2;
        if (f3897o.compareAndSet(this, 0, 1)) {
            c cVarD = d();
            synchronized (this.workers) {
                i2 = (int) (this.controlState & 2097151);
            }
            if (1 <= i2) {
                int i3 = 1;
                while (true) {
                    int i4 = i3 + 1;
                    c cVarB = this.workers.b(i3);
                    s.b(cVarB);
                    c cVar = cVarB;
                    if (cVar != cVarD) {
                        while (cVar.isAlive()) {
                            LockSupport.unpark(cVar);
                            cVar.join(timeout);
                        }
                        cVar.localQueue.g(this.globalBlockingQueue);
                    }
                    if (i3 == i2) {
                        break;
                    } else {
                        i3 = i4;
                    }
                }
            }
            this.globalBlockingQueue.b();
            this.globalCpuQueue.b();
            while (true) {
                g gVarF = cVarD == null ? null : cVarD.f(true);
                if (gVarF == null && (gVarF = this.globalCpuQueue.d()) == null && (gVarF = this.globalBlockingQueue.d()) == null) {
                    break;
                } else {
                    k(gVarF);
                }
            }
            if (cVarD != null) {
                cVarD.s(WorkerState.TERMINATED);
            }
            this.parkedWorkersStack = 0L;
            this.controlState = 0L;
        }
    }

    public final void n() {
        if (r() || q(this, 0L, 1, null)) {
            return;
        }
        r();
    }

    @NotNull
    public String toString() {
        ArrayList arrayList = new ArrayList();
        int iA = this.workers.a();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 1;
        while (i7 < iA) {
            int i8 = i7 + 1;
            c cVarB = this.workers.b(i7);
            if (cVarB != null) {
                int iF = cVarB.localQueue.f();
                int i9 = b.f3906a[cVarB.state.ordinal()];
                if (i9 == 1) {
                    i4++;
                } else if (i9 == 2) {
                    i3++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(iF);
                    sb.append('b');
                    arrayList.add(sb.toString());
                } else if (i9 == 3) {
                    i2++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(iF);
                    sb2.append('c');
                    arrayList.add(sb2.toString());
                } else if (i9 == 4) {
                    i5++;
                    if (iF > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(iF);
                        sb3.append('d');
                        arrayList.add(sb3.toString());
                    }
                } else if (i9 == 5) {
                    i6++;
                }
            }
            i7 = i8;
        }
        long j2 = this.controlState;
        return this.schedulerName + '@' + i0.b(this) + "[Pool Size {core = " + this.corePoolSize + ", max = " + this.maxPoolSize + "}, Worker States {CPU = " + i2 + ", blocking = " + i3 + ", parked = " + i4 + ", dormant = " + i5 + ", terminated = " + i6 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.globalCpuQueue.c() + ", global blocking queue size = " + this.globalBlockingQueue.c() + ", Control State {created workers= " + ((int) (2097151 & j2)) + ", blocking tasks = " + ((int) ((4398044413952L & j2) >> 21)) + ", CPUs acquired = " + (this.corePoolSize - ((int) ((9223367638808264704L & j2) >> 42))) + "}]";
    }

    /* compiled from: CoroutineScheduler.kt */
    @Metadata(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000e\b\u0080\u0004\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b@\u0010AB\u0011\b\u0016\u0012\u0006\u0010'\u001a\u00020\u000e¢\u0006\u0004\b@\u0010BJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0007J\u000f\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\u0004J\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0013\u0010\u0007J\u000f\u0010\u0014\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0014\u0010\u0007J\u0017\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0016\u0010\u0011J\u0019\u0010\u0018\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0017\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0011\u0010\u001a\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001d\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001c\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001d\u0010\u0019J\u0015\u0010 \u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\"\u0010\u0007J\u0015\u0010$\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u000e¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b&\u0010\u0019R*\u0010(\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u000e8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010\u0011R\u0014\u0010/\u001a\u00020-8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010.R\u0016\u00101\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b&\u00100R\u0016\u00104\u001a\u0002028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u00103R$\u00106\u001a\u0004\u0018\u0001058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0016\u0010<\u001a\u0002028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00103R\u0016\u0010=\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010)R\u0016\u0010?\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010>¨\u0006C"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$c;", "Ljava/lang/Thread;", "", "q", "()Z", "Lkotlin/t;", "n", "()V", "r", "j", "Lkotlinx/coroutines/scheduling/g;", "task", "d", "(Lkotlinx/coroutines/scheduling/g;)V", "", "taskMode", "c", "(I)V", "b", "l", "u", "mode", "i", "scanLocalQueue", "e", "(Z)Lkotlinx/coroutines/scheduling/g;", "m", "()Lkotlinx/coroutines/scheduling/g;", "blockingOnly", "t", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "newState", "s", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;)Z", "run", "upperBound", "k", "(I)I", "f", "index", "indexInArray", "I", "g", "()I", "o", "Lkotlinx/coroutines/scheduling/m;", "Lkotlinx/coroutines/scheduling/m;", "localQueue", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", ServerProtocol.DIALOG_PARAM_STATE, "", "J", "terminationDeadline", "", "nextParkedWorker", "Ljava/lang/Object;", "h", "()Ljava/lang/Object;", "p", "(Ljava/lang/Object;)V", "minDelayUntilStealableTaskNs", "rngState", "Z", "mayHaveLocalTasks", "<init>", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;)V", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public final class c extends Thread {

        /* renamed from: l, reason: collision with root package name */
        static final /* synthetic */ AtomicIntegerFieldUpdater f3907l = AtomicIntegerFieldUpdater.newUpdater(c.class, "workerCtl");

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public final m localQueue;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public WorkerState state;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private long terminationDeadline;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private long minDelayUntilStealableTaskNs;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private int rngState;
        private volatile int indexInArray;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        @JvmField
        public boolean mayHaveLocalTasks;

        @Nullable
        private volatile Object nextParkedWorker;

        @NotNull
        volatile /* synthetic */ int workerCtl;

        private c() {
            setDaemon(true);
            this.localQueue = new m();
            this.state = WorkerState.DORMANT;
            this.workerCtl = 0;
            this.nextParkedWorker = CoroutineScheduler.f3898p;
            this.rngState = Random.INSTANCE.nextInt();
        }

        private final void b(int taskMode) {
            if (taskMode == 0) {
                return;
            }
            CoroutineScheduler.f3896n.addAndGet(CoroutineScheduler.this, -2097152L);
            if (this.state != WorkerState.TERMINATED) {
                this.state = WorkerState.DORMANT;
            }
        }

        private final void c(int taskMode) {
            if (taskMode != 0 && s(WorkerState.BLOCKING)) {
                CoroutineScheduler.this.n();
            }
        }

        private final void d(g task) {
            int taskMode = task.taskContext.getTaskMode();
            i(taskMode);
            c(taskMode);
            CoroutineScheduler.this.k(task);
            b(taskMode);
        }

        private final g e(boolean scanLocalQueue) {
            g gVarM;
            g gVarM2;
            if (scanLocalQueue) {
                boolean z2 = k(CoroutineScheduler.this.corePoolSize * 2) == 0;
                if (z2 && (gVarM2 = m()) != null) {
                    return gVarM2;
                }
                g gVarH = this.localQueue.h();
                if (gVarH != null) {
                    return gVarH;
                }
                if (!z2 && (gVarM = m()) != null) {
                    return gVarM;
                }
            } else {
                g gVarM3 = m();
                if (gVarM3 != null) {
                    return gVarM3;
                }
            }
            return t(false);
        }

        private final void i(int mode) {
            this.terminationDeadline = 0L;
            if (this.state == WorkerState.PARKING) {
                this.state = WorkerState.BLOCKING;
            }
        }

        private final boolean j() {
            return this.nextParkedWorker != CoroutineScheduler.f3898p;
        }

        private final void l() {
            if (this.terminationDeadline == 0) {
                this.terminationDeadline = System.nanoTime() + CoroutineScheduler.this.idleWorkerKeepAliveNs;
            }
            LockSupport.parkNanos(CoroutineScheduler.this.idleWorkerKeepAliveNs);
            if (System.nanoTime() - this.terminationDeadline >= 0) {
                this.terminationDeadline = 0L;
                u();
            }
        }

        private final g m() {
            if (k(2) == 0) {
                g gVarD = CoroutineScheduler.this.globalCpuQueue.d();
                return gVarD == null ? CoroutineScheduler.this.globalBlockingQueue.d() : gVarD;
            }
            g gVarD2 = CoroutineScheduler.this.globalBlockingQueue.d();
            return gVarD2 == null ? CoroutineScheduler.this.globalCpuQueue.d() : gVarD2;
        }

        private final void n() {
            loop0: while (true) {
                boolean z2 = false;
                while (!CoroutineScheduler.this.isTerminated() && this.state != WorkerState.TERMINATED) {
                    g gVarF = f(this.mayHaveLocalTasks);
                    if (gVarF != null) {
                        this.minDelayUntilStealableTaskNs = 0L;
                        d(gVarF);
                    } else {
                        this.mayHaveLocalTasks = false;
                        if (this.minDelayUntilStealableTaskNs == 0) {
                            r();
                        } else if (z2) {
                            s(WorkerState.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.minDelayUntilStealableTaskNs);
                            this.minDelayUntilStealableTaskNs = 0L;
                        } else {
                            z2 = true;
                        }
                    }
                }
                break loop0;
            }
            s(WorkerState.TERMINATED);
        }

        private final boolean q() {
            boolean z2;
            if (this.state != WorkerState.CPU_ACQUIRED) {
                CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
                while (true) {
                    long j2 = coroutineScheduler.controlState;
                    if (((int) ((9223367638808264704L & j2) >> 42)) == 0) {
                        z2 = false;
                        break;
                    }
                    if (CoroutineScheduler.f3896n.compareAndSet(coroutineScheduler, j2, j2 - 4398046511104L)) {
                        z2 = true;
                        break;
                    }
                }
                if (!z2) {
                    return false;
                }
                this.state = WorkerState.CPU_ACQUIRED;
            }
            return true;
        }

        private final void r() {
            if (!j()) {
                CoroutineScheduler.this.i(this);
                return;
            }
            this.workerCtl = -1;
            while (j() && this.workerCtl == -1 && !CoroutineScheduler.this.isTerminated() && this.state != WorkerState.TERMINATED) {
                s(WorkerState.PARKING);
                Thread.interrupted();
                l();
            }
        }

        private final g t(boolean blockingOnly) {
            int i2 = (int) (CoroutineScheduler.this.controlState & 2097151);
            if (i2 < 2) {
                return null;
            }
            int iK = k(i2);
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            int i3 = 0;
            long jMin = Long.MAX_VALUE;
            while (i3 < i2) {
                i3++;
                iK++;
                if (iK > i2) {
                    iK = 1;
                }
                c cVarB = coroutineScheduler.workers.b(iK);
                if (cVarB != null && cVarB != this) {
                    long jK = blockingOnly ? this.localQueue.k(cVarB.localQueue) : this.localQueue.l(cVarB.localQueue);
                    if (jK == -1) {
                        return this.localQueue.h();
                    }
                    if (jK > 0) {
                        jMin = Math.min(jMin, jK);
                    }
                }
            }
            if (jMin == Long.MAX_VALUE) {
                jMin = 0;
            }
            this.minDelayUntilStealableTaskNs = jMin;
            return null;
        }

        private final void u() {
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            synchronized (coroutineScheduler.workers) {
                if (coroutineScheduler.isTerminated()) {
                    return;
                }
                if (((int) (coroutineScheduler.controlState & 2097151)) <= coroutineScheduler.corePoolSize) {
                    return;
                }
                if (f3907l.compareAndSet(this, -1, 1)) {
                    int indexInArray = getIndexInArray();
                    o(0);
                    coroutineScheduler.j(this, indexInArray, 0);
                    int andDecrement = (int) (2097151 & CoroutineScheduler.f3896n.getAndDecrement(coroutineScheduler));
                    if (andDecrement != indexInArray) {
                        c cVarB = coroutineScheduler.workers.b(andDecrement);
                        s.b(cVarB);
                        c cVar = cVarB;
                        coroutineScheduler.workers.c(indexInArray, cVar);
                        cVar.o(indexInArray);
                        coroutineScheduler.j(cVar, andDecrement, indexInArray);
                    }
                    coroutineScheduler.workers.c(andDecrement, null);
                    t tVar = t.f3507a;
                    this.state = WorkerState.TERMINATED;
                }
            }
        }

        @Nullable
        public final g f(boolean scanLocalQueue) {
            g gVarD;
            if (q()) {
                return e(scanLocalQueue);
            }
            if (!scanLocalQueue || (gVarD = this.localQueue.h()) == null) {
                gVarD = CoroutineScheduler.this.globalBlockingQueue.d();
            }
            return gVarD == null ? t(true) : gVarD;
        }

        /* renamed from: g, reason: from getter */
        public final int getIndexInArray() {
            return this.indexInArray;
        }

        @Nullable
        /* renamed from: h, reason: from getter */
        public final Object getNextParkedWorker() {
            return this.nextParkedWorker;
        }

        public final int k(int upperBound) {
            int i2 = this.rngState;
            int i3 = i2 ^ (i2 << 13);
            int i4 = i3 ^ (i3 >> 17);
            int i5 = i4 ^ (i4 << 5);
            this.rngState = i5;
            int i6 = upperBound - 1;
            return (i6 & upperBound) == 0 ? i5 & i6 : (i5 & Integer.MAX_VALUE) % upperBound;
        }

        public final void o(int i2) {
            StringBuilder sb = new StringBuilder();
            sb.append(CoroutineScheduler.this.schedulerName);
            sb.append("-worker-");
            sb.append(i2 == 0 ? "TERMINATED" : String.valueOf(i2));
            setName(sb.toString());
            this.indexInArray = i2;
        }

        public final void p(@Nullable Object obj) {
            this.nextParkedWorker = obj;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            n();
        }

        public final boolean s(@NotNull WorkerState newState) {
            WorkerState workerState = this.state;
            boolean z2 = workerState == WorkerState.CPU_ACQUIRED;
            if (z2) {
                CoroutineScheduler.f3896n.addAndGet(CoroutineScheduler.this, 4398046511104L);
            }
            if (workerState != newState) {
                this.state = newState;
            }
            return z2;
        }

        public c(int i2) {
            this();
            o(i2);
        }
    }
}
