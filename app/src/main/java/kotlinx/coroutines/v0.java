package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.l0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: EventLoop.common.kt */
@Metadata(bv = {}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\b \u0018\u00002\u00020\u00012\u00020\u0002:\u000489:;B\u0007¢\u0006\u0004\b7\u0010\rJ\u001b\u0010\u0007\u001a\u00020\u00062\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0017\u0010\rJ\u000f\u0010\u0018\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0018\u0010\rJ%\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00112\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ#\u0010 \u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u00112\n\u0010\u001e\u001a\u00060\u0003j\u0002`\u0004H\u0004¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\"\u0010#J!\u0010&\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020$2\n\u0010\u001e\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b&\u0010'J\u001b\u0010(\u001a\u00020\u000b2\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004H\u0016¢\u0006\u0004\b(\u0010)J\u001d\u0010*\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000e¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u000bH\u0004¢\u0006\u0004\b,\u0010\rR$\u00102\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00068B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0014\u00104\u001a\u00020\u00068TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b3\u0010/R\u0014\u00106\u001a\u00020\u00118TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b5\u0010#¨\u0006<"}, d2 = {"Lkotlinx/coroutines/v0;", "Lkotlinx/coroutines/w0;", "Lkotlinx/coroutines/l0;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "task", "", "N", "(Ljava/lang/Runnable;)Z", "L", "()Ljava/lang/Runnable;", "Lkotlin/t;", "K", "()V", "Lkotlinx/coroutines/v0$c;", "W", "(Lkotlinx/coroutines/v0$c;)Z", "", "now", "delayedTask", "", "T", "(JLkotlinx/coroutines/v0$c;)I", "Q", "shutdown", "timeMillis", "Lkotlinx/coroutines/k;", "continuation", "e", "(JLkotlinx/coroutines/k;)V", "block", "Lkotlinx/coroutines/q0;", "U", "(JLjava/lang/Runnable;)Lkotlinx/coroutines/q0;", "P", "()J", "Lkotlin/coroutines/CoroutineContext;", "context", "g", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "M", "(Ljava/lang/Runnable;)V", "S", "(JLkotlinx/coroutines/v0$c;)V", "R", "value", "w", "()Z", "V", "(Z)V", "isCompleted", "O", "isEmpty", "x", "nextTime", "<init>", "a", "b", "c", "d", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public abstract class v0 extends w0 implements l0 {

    /* renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f4001i = AtomicReferenceFieldUpdater.newUpdater(v0.class, Object.class, "_queue");

    /* renamed from: j, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f4002j = AtomicReferenceFieldUpdater.newUpdater(v0.class, Object.class, "_delayed");

    @NotNull
    private volatile /* synthetic */ Object _queue = null;

    @NotNull
    private volatile /* synthetic */ Object _delayed = null;

    @NotNull
    private volatile /* synthetic */ int _isCompleted = 0;

    /* compiled from: EventLoop.common.kt */
    @Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/v0$a;", "Lkotlinx/coroutines/v0$c;", "Lkotlin/t;", "run", "", "toString", "Lkotlinx/coroutines/k;", "h", "Lkotlinx/coroutines/k;", "cont", "", "nanoTime", "<init>", "(Lkotlinx/coroutines/v0;JLkotlinx/coroutines/k;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private final class a extends c {

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final k<kotlin.t> cont;

        /* JADX WARN: Multi-variable type inference failed */
        public a(long j2, @NotNull k<? super kotlin.t> kVar) {
            super(j2);
            this.cont = kVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.cont.e(v0.this, kotlin.t.f3507a);
        }

        @Override // kotlinx.coroutines.v0.c
        @NotNull
        public String toString() {
            return kotlin.jvm.internal.s.m(super.toString(), this.cont);
        }
    }

    /* compiled from: EventLoop.common.kt */
    @Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\u0010\n\u001a\u00060\u0006j\u0002`\u0007¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0018\u0010\n\u001a\u00060\u0006j\u0002`\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/v0$b;", "Lkotlinx/coroutines/v0$c;", "Lkotlin/t;", "run", "", "toString", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "h", "Ljava/lang/Runnable;", "block", "", "nanoTime", "<init>", "(JLjava/lang/Runnable;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private static final class b extends c {

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Runnable block;

        public b(long j2, @NotNull Runnable runnable) {
            super(j2);
            this.block = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.block.run();
        }

        @Override // kotlinx.coroutines.v0.c
        @NotNull
        public String toString() {
            return kotlin.jvm.internal.s.m(super.toString(), this.block);
        }
    }

    /* compiled from: EventLoop.common.kt */
    @Metadata(bv = {}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\b \u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u00032\u00020\u00042\u00020\u0005B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\t¢\u0006\u0004\b)\u0010*J\u0011\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0000H\u0096\u0002J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tJ\u001e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0013\u001a\u00020\u0012J\b\u0010\u0015\u001a\u00020\u0014H\u0016R\u0016\u0010\u0017\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0019R\"\u0010!\u001a\u00020\u00078\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R0\u0010(\u001a\b\u0012\u0002\b\u0003\u0018\u00010\"2\f\u0010#\u001a\b\u0012\u0002\b\u0003\u0018\u00010\"8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006+"}, d2 = {"Lkotlinx/coroutines/v0$c;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "Lkotlinx/coroutines/q0;", "Lkotlinx/coroutines/internal/i0;", "other", "", "d", "", "now", "", "f", "Lkotlinx/coroutines/v0$d;", "delayed", "Lkotlinx/coroutines/v0;", "eventLoop", "e", "Lkotlin/t;", "a", "", "toString", "J", "nanoTime", "", "Ljava/lang/Object;", "_heap", "g", "I", "getIndex", "()I", "setIndex", "(I)V", "index", "Lkotlinx/coroutines/internal/h0;", "value", "c", "()Lkotlinx/coroutines/internal/h0;", "b", "(Lkotlinx/coroutines/internal/h0;)V", "heap", "<init>", "(J)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static abstract class c implements Runnable, Comparable<c>, q0, kotlinx.coroutines.internal.i0 {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @JvmField
        public long nanoTime;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Object _heap;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private int index = -1;

        public c(long j2) {
            this.nanoTime = j2;
        }

        @Override // kotlinx.coroutines.q0
        public final synchronized void a() {
            Object obj = this._heap;
            if (obj == y0.f4016a) {
                return;
            }
            d dVar = obj instanceof d ? (d) obj : null;
            if (dVar != null) {
                dVar.g(this);
            }
            this._heap = y0.f4016a;
        }

        @Override // kotlinx.coroutines.internal.i0
        public void b(@Nullable kotlinx.coroutines.internal.h0<?> h0Var) {
            if (!(this._heap != y0.f4016a)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            this._heap = h0Var;
        }

        @Override // kotlinx.coroutines.internal.i0
        @Nullable
        public kotlinx.coroutines.internal.h0<?> c() {
            Object obj = this._heap;
            if (obj instanceof kotlinx.coroutines.internal.h0) {
                return (kotlinx.coroutines.internal.h0) obj;
            }
            return null;
        }

        @Override // java.lang.Comparable
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public int compareTo(@NotNull c other) {
            long j2 = this.nanoTime - other.nanoTime;
            if (j2 > 0) {
                return 1;
            }
            return j2 < 0 ? -1 : 0;
        }

        public final synchronized int e(long now, @NotNull d delayed, @NotNull v0 eventLoop) {
            if (this._heap == y0.f4016a) {
                return 2;
            }
            synchronized (delayed) {
                c cVarB = delayed.b();
                if (eventLoop.w()) {
                    return 1;
                }
                if (cVarB == null) {
                    delayed.timeNow = now;
                } else {
                    long j2 = cVarB.nanoTime;
                    if (j2 - now < 0) {
                        now = j2;
                    }
                    if (now - delayed.timeNow > 0) {
                        delayed.timeNow = now;
                    }
                }
                long j3 = this.nanoTime;
                long j4 = delayed.timeNow;
                if (j3 - j4 < 0) {
                    this.nanoTime = j4;
                }
                delayed.a(this);
                return 0;
            }
        }

        public final boolean f(long now) {
            return now - this.nanoTime >= 0;
        }

        @Override // kotlinx.coroutines.internal.i0
        public int getIndex() {
            return this.index;
        }

        @Override // kotlinx.coroutines.internal.i0
        public void setIndex(int i2) {
            this.index = i2;
        }

        @NotNull
        public String toString() {
            return "Delayed[nanos=" + this.nanoTime + ']';
        }
    }

    /* compiled from: EventLoop.common.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/v0$d;", "Lkotlinx/coroutines/internal/h0;", "Lkotlinx/coroutines/v0$c;", "", "b", "J", "timeNow", "<init>", "(J)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static final class d extends kotlinx.coroutines.internal.h0<c> {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @JvmField
        public long timeNow;

        public d(long j2) {
            this.timeNow = j2;
        }
    }

    private final void K() {
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                if (kotlin.i.a(f4001i, this, null, y0.f4017b)) {
                    return;
                }
            } else if (obj instanceof kotlinx.coroutines.internal.r) {
                ((kotlinx.coroutines.internal.r) obj).d();
                return;
            } else {
                if (obj == y0.f4017b) {
                    return;
                }
                kotlinx.coroutines.internal.r rVar = new kotlinx.coroutines.internal.r(8, true);
                rVar.a((Runnable) obj);
                if (kotlin.i.a(f4001i, this, obj, rVar)) {
                    return;
                }
            }
        }
    }

    private final Runnable L() {
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                return null;
            }
            if (obj instanceof kotlinx.coroutines.internal.r) {
                kotlinx.coroutines.internal.r rVar = (kotlinx.coroutines.internal.r) obj;
                Object objJ = rVar.j();
                if (objJ != kotlinx.coroutines.internal.r.f3839h) {
                    return (Runnable) objJ;
                }
                kotlin.i.a(f4001i, this, obj, rVar.i());
            } else {
                if (obj == y0.f4017b) {
                    return null;
                }
                if (kotlin.i.a(f4001i, this, obj, null)) {
                    return (Runnable) obj;
                }
            }
        }
    }

    private final boolean N(Runnable task) {
        while (true) {
            Object obj = this._queue;
            if (w()) {
                return false;
            }
            if (obj == null) {
                if (kotlin.i.a(f4001i, this, null, task)) {
                    return true;
                }
            } else if (obj instanceof kotlinx.coroutines.internal.r) {
                kotlinx.coroutines.internal.r rVar = (kotlinx.coroutines.internal.r) obj;
                int iA = rVar.a(task);
                if (iA == 0) {
                    return true;
                }
                if (iA == 1) {
                    kotlin.i.a(f4001i, this, obj, rVar.i());
                } else if (iA == 2) {
                    return false;
                }
            } else {
                if (obj == y0.f4017b) {
                    return false;
                }
                kotlinx.coroutines.internal.r rVar2 = new kotlinx.coroutines.internal.r(8, true);
                rVar2.a((Runnable) obj);
                rVar2.a(task);
                if (kotlin.i.a(f4001i, this, obj, rVar2)) {
                    return true;
                }
            }
        }
    }

    private final void Q() {
        kotlinx.coroutines.c.a();
        long jNanoTime = System.nanoTime();
        while (true) {
            d dVar = (d) this._delayed;
            c cVarI = dVar == null ? null : dVar.i();
            if (cVarI == null) {
                return;
            } else {
                H(jNanoTime, cVarI);
            }
        }
    }

    private final int T(long now, c delayedTask) {
        if (w()) {
            return 1;
        }
        d dVar = (d) this._delayed;
        if (dVar == null) {
            kotlin.i.a(f4002j, this, null, new d(now));
            Object obj = this._delayed;
            kotlin.jvm.internal.s.b(obj);
            dVar = (d) obj;
        }
        return delayedTask.e(now, dVar, this);
    }

    private final void V(boolean z2) {
        this._isCompleted = z2 ? 1 : 0;
    }

    private final boolean W(c task) {
        d dVar = (d) this._delayed;
        return (dVar == null ? null : dVar.e()) == task;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean w() {
        return this._isCompleted;
    }

    public void M(@NotNull Runnable task) {
        if (N(task)) {
            I();
        } else {
            j0.f3853k.M(task);
        }
    }

    protected boolean O() {
        if (!D()) {
            return false;
        }
        d dVar = (d) this._delayed;
        if (dVar != null && !dVar.d()) {
            return false;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (obj instanceof kotlinx.coroutines.internal.r) {
                return ((kotlinx.coroutines.internal.r) obj).g();
            }
            if (obj != y0.f4017b) {
                return false;
            }
        }
        return true;
    }

    public long P() {
        c cVarH;
        if (E()) {
            return 0L;
        }
        d dVar = (d) this._delayed;
        if (dVar != null && !dVar.d()) {
            kotlinx.coroutines.c.a();
            long jNanoTime = System.nanoTime();
            do {
                synchronized (dVar) {
                    c cVarB = dVar.b();
                    if (cVarB != null) {
                        c cVar = cVarB;
                        cVarH = cVar.f(jNanoTime) ? N(cVar) : false ? dVar.h(0) : null;
                    }
                }
            } while (cVarH != null);
        }
        Runnable runnableL = L();
        if (runnableL == null) {
            return x();
        }
        runnableL.run();
        return 0L;
    }

    protected final void R() {
        this._queue = null;
        this._delayed = null;
    }

    public final void S(long now, @NotNull c delayedTask) {
        int iT = T(now, delayedTask);
        if (iT == 0) {
            if (W(delayedTask)) {
                I();
            }
        } else if (iT == 1) {
            H(now, delayedTask);
        } else if (iT != 2) {
            throw new IllegalStateException("unexpected result".toString());
        }
    }

    @NotNull
    protected final q0 U(long timeMillis, @NotNull Runnable block) {
        long jD = y0.d(timeMillis);
        if (jD >= 4611686018427387903L) {
            return s1.f3893e;
        }
        kotlinx.coroutines.c.a();
        long jNanoTime = System.nanoTime();
        b bVar = new b(jD + jNanoTime, block);
        S(jNanoTime, bVar);
        return bVar;
    }

    @NotNull
    public q0 c(long j2, @NotNull Runnable runnable, @NotNull CoroutineContext coroutineContext) {
        return l0.a.a(this, j2, runnable, coroutineContext);
    }

    @Override // kotlinx.coroutines.l0
    public void e(long timeMillis, @NotNull k<? super kotlin.t> continuation) {
        long jD = y0.d(timeMillis);
        if (jD < 4611686018427387903L) {
            kotlinx.coroutines.c.a();
            long jNanoTime = System.nanoTime();
            a aVar = new a(jD + jNanoTime, continuation);
            n.a(continuation, aVar);
            S(jNanoTime, aVar);
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void g(@NotNull CoroutineContext context, @NotNull Runnable block) {
        M(block);
    }

    @Override // kotlinx.coroutines.u0
    public void shutdown() {
        z1.f4018a.b();
        V(true);
        K();
        while (P() <= 0) {
        }
        Q();
    }

    @Override // kotlinx.coroutines.u0
    protected long x() {
        if (super.x() == 0) {
            return 0L;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (!(obj instanceof kotlinx.coroutines.internal.r)) {
                return obj == y0.f4017b ? Long.MAX_VALUE : 0L;
            }
            if (!((kotlinx.coroutines.internal.r) obj).g()) {
                return 0L;
            }
        }
        d dVar = (d) this._delayed;
        c cVarE = dVar == null ? null : dVar.e();
        if (cVarE == null) {
            return Long.MAX_VALUE;
        }
        long j2 = cVarE.nanoTime;
        kotlinx.coroutines.c.a();
        return s0.l.b(j2 - System.nanoTime(), 0L);
    }
}
