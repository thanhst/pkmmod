package kotlinx.coroutines.scheduling;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: WorkQueue.kt */
@Metadata(bv = {}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b(\u0010)J\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\u0012*\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0011J!\u0010\u0017\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0000¢\u0006\u0004\b\u001b\u0010\u001aJ\u0015\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\f¢\u0006\u0004\b\u001d\u0010\u001eR\u001c\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010 R\u0014\u0010%\u001a\u00020\"8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020\"8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b&\u0010$¨\u0006*"}, d2 = {"Lkotlinx/coroutines/scheduling/m;", "", "Lkotlinx/coroutines/scheduling/g;", "task", "c", "(Lkotlinx/coroutines/scheduling/g;)Lkotlinx/coroutines/scheduling/g;", "victim", "", "blockingOnly", "", "m", "(Lkotlinx/coroutines/scheduling/m;Z)J", "Lkotlinx/coroutines/scheduling/c;", "queue", "j", "(Lkotlinx/coroutines/scheduling/c;)Z", "i", "()Lkotlinx/coroutines/scheduling/g;", "Lkotlin/t;", "d", "(Lkotlinx/coroutines/scheduling/g;)V", "h", "fair", "a", "(Lkotlinx/coroutines/scheduling/g;Z)Lkotlinx/coroutines/scheduling/g;", "l", "(Lkotlinx/coroutines/scheduling/m;)J", "k", "globalQueue", "g", "(Lkotlinx/coroutines/scheduling/c;)V", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "buffer", "", "e", "()I", "bufferSize", "f", "size", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class m {

    /* renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f3936b = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "lastScheduledTask");

    /* renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f3937c = AtomicIntegerFieldUpdater.newUpdater(m.class, "producerIndex");

    /* renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f3938d = AtomicIntegerFieldUpdater.newUpdater(m.class, "consumerIndex");

    /* renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f3939e = AtomicIntegerFieldUpdater.newUpdater(m.class, "blockingTasksInBuffer");

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicReferenceArray<g> buffer = new AtomicReferenceArray<>(128);

    @NotNull
    private volatile /* synthetic */ Object lastScheduledTask = null;

    @NotNull
    private volatile /* synthetic */ int producerIndex = 0;

    @NotNull
    private volatile /* synthetic */ int consumerIndex = 0;

    @NotNull
    private volatile /* synthetic */ int blockingTasksInBuffer = 0;

    public static /* synthetic */ g b(m mVar, g gVar, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        return mVar.a(gVar, z2);
    }

    private final g c(g task) {
        if (task.taskContext.getTaskMode() == 1) {
            f3939e.incrementAndGet(this);
        }
        if (e() == 127) {
            return task;
        }
        int i2 = this.producerIndex & 127;
        while (this.buffer.get(i2) != null) {
            Thread.yield();
        }
        this.buffer.lazySet(i2, task);
        f3937c.incrementAndGet(this);
        return null;
    }

    private final void d(g gVar) {
        if (gVar != null) {
            if (gVar.taskContext.getTaskMode() == 1) {
                f3939e.decrementAndGet(this);
            }
        }
    }

    private final g i() {
        g andSet;
        while (true) {
            int i2 = this.consumerIndex;
            if (i2 - this.producerIndex == 0) {
                return null;
            }
            int i3 = i2 & 127;
            if (f3938d.compareAndSet(this, i2, i2 + 1) && (andSet = this.buffer.getAndSet(i3, null)) != null) {
                d(andSet);
                return andSet;
            }
        }
    }

    private final boolean j(c queue) {
        g gVarI = i();
        if (gVarI == null) {
            return false;
        }
        queue.a(gVarI);
        return true;
    }

    private final long m(m victim, boolean blockingOnly) {
        g gVar;
        do {
            gVar = (g) victim.lastScheduledTask;
            if (gVar == null) {
                return -2L;
            }
            if (blockingOnly) {
                if (!(gVar.taskContext.getTaskMode() == 1)) {
                    return -2L;
                }
            }
            long jA = k.f3932e.a() - gVar.submissionTime;
            long j2 = k.f3928a;
            if (jA < j2) {
                return j2 - jA;
            }
        } while (!kotlin.i.a(f3936b, victim, gVar, null));
        b(this, gVar, false, 2, null);
        return -1L;
    }

    @Nullable
    public final g a(@NotNull g task, boolean fair) {
        if (fair) {
            return c(task);
        }
        g gVar = (g) f3936b.getAndSet(this, task);
        if (gVar == null) {
            return null;
        }
        return c(gVar);
    }

    public final int e() {
        return this.producerIndex - this.consumerIndex;
    }

    public final int f() {
        return this.lastScheduledTask != null ? e() + 1 : e();
    }

    public final void g(@NotNull c globalQueue) {
        g gVar = (g) f3936b.getAndSet(this, null);
        if (gVar != null) {
            globalQueue.a(gVar);
        }
        while (j(globalQueue)) {
        }
    }

    @Nullable
    public final g h() {
        g gVar = (g) f3936b.getAndSet(this, null);
        return gVar == null ? i() : gVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003f, code lost:
    
        return m(r9, true);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long k(@org.jetbrains.annotations.NotNull kotlinx.coroutines.scheduling.m r9) {
        /*
            r8 = this;
            int r0 = r9.consumerIndex
            int r1 = r9.producerIndex
            java.util.concurrent.atomic.AtomicReferenceArray<kotlinx.coroutines.scheduling.g> r2 = r9.buffer
        L6:
            r3 = 1
            if (r0 == r1) goto L3b
            r4 = r0 & 127(0x7f, float:1.78E-43)
            int r5 = r9.blockingTasksInBuffer
            if (r5 != 0) goto L10
            goto L3b
        L10:
            java.lang.Object r5 = r2.get(r4)
            kotlinx.coroutines.scheduling.g r5 = (kotlinx.coroutines.scheduling.g) r5
            if (r5 == 0) goto L38
            kotlinx.coroutines.scheduling.h r6 = r5.taskContext
            int r6 = r6.getTaskMode()
            r7 = 0
            if (r6 != r3) goto L22
            goto L23
        L22:
            r3 = 0
        L23:
            if (r3 == 0) goto L38
            r3 = 0
            boolean r4 = kotlinx.coroutines.debug.internal.a.a(r2, r4, r5, r3)
            if (r4 == 0) goto L38
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = kotlinx.coroutines.scheduling.m.f3939e
            r0.decrementAndGet(r9)
            r9 = 2
            b(r8, r5, r7, r9, r3)
            r0 = -1
            return r0
        L38:
            int r0 = r0 + 1
            goto L6
        L3b:
            long r0 = r8.m(r9, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.m.k(kotlinx.coroutines.scheduling.m):long");
    }

    public final long l(@NotNull m victim) {
        g gVarI = victim.i();
        if (gVarI == null) {
            return m(victim, false);
        }
        b(this, gVarI, false, 2, null);
        return -1L;
    }
}
