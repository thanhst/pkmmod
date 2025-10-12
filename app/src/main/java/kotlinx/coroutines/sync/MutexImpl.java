package kotlinx.coroutines.sync;

import com.facebook.login.LoginLogger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.i;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.s;
import kotlin.t;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.n;
import kotlinx.coroutines.internal.w;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m;
import kotlinx.coroutines.q0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p0.l;
import p0.p;

/* compiled from: Mutex.kt */
@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00010\u0002:\u0005\u0011\u0012\u000b\f\u0006J\u001d\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u0007J\u0019\u0010\f\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl;", "Lkotlinx/coroutines/sync/c;", "Lkotlinx/coroutines/selects/e;", "", "owner", "Lkotlin/t;", "c", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "d", "(Ljava/lang/Object;)Z", "a", "b", "(Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "LockCont", "LockSelect", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class MutexImpl implements kotlinx.coroutines.sync.c, kotlinx.coroutines.selects.e<Object, kotlinx.coroutines.sync.c> {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ AtomicReferenceFieldUpdater f3958a = AtomicReferenceFieldUpdater.newUpdater(MutexImpl.class, Object.class, "_state");

    @NotNull
    volatile /* synthetic */ Object _state;

    /* compiled from: Mutex.kt */
    @Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u001f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$LockCont;", "Lkotlinx/coroutines/sync/MutexImpl$a;", "Lkotlinx/coroutines/sync/MutexImpl;", "", "S", "Lkotlin/t;", "Q", "", "toString", "Lkotlinx/coroutines/k;", "k", "Lkotlinx/coroutines/k;", "cont", "", "owner", "<init>", "(Lkotlinx/coroutines/sync/MutexImpl;Ljava/lang/Object;Lkotlinx/coroutines/k;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private final class LockCont extends a {

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final k<t> cont;

        /* JADX WARN: Multi-variable type inference failed */
        public LockCont(@Nullable Object obj, @NotNull k<? super t> kVar) {
            super(obj);
            this.cont = kVar;
        }

        @Override // kotlinx.coroutines.sync.MutexImpl.a
        public void Q() {
            this.cont.G(m.f3863a);
        }

        @Override // kotlinx.coroutines.sync.MutexImpl.a
        public boolean S() {
            if (!R()) {
                return false;
            }
            k<t> kVar = this.cont;
            t tVar = t.f3507a;
            final MutexImpl mutexImpl = MutexImpl.this;
            return kVar.D(tVar, null, new l<Throwable, t>() { // from class: kotlinx.coroutines.sync.MutexImpl$LockCont$tryResumeLockWaiter$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // p0.l
                public /* bridge */ /* synthetic */ t invoke(Throwable th) {
                    invoke2(th);
                    return t.f3507a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Throwable th) {
                    mutexImpl.b(this.owner);
                }
            }) != null;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        @NotNull
        public String toString() {
            return "LockCont[" + this.owner + ", " + this.cont + "] for " + MutexImpl.this;
        }
    }

    /* compiled from: Mutex.kt */
    @Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0082\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00060\u0002R\u00020\u0003J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR3\u0010\u0014\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000e8\u0006X\u0087\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$LockSelect;", "R", "Lkotlinx/coroutines/sync/MutexImpl$a;", "Lkotlinx/coroutines/sync/MutexImpl;", "", "S", "Lkotlin/t;", "Q", "", "toString", "Lkotlinx/coroutines/selects/f;", "k", "Lkotlinx/coroutines/selects/f;", "select", "Lkotlin/Function2;", "Lkotlinx/coroutines/sync/c;", "Lkotlin/coroutines/c;", "", "l", "Lp0/p;", "block", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private final class LockSelect<R> extends a {

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public final kotlinx.coroutines.selects.f<R> select;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public final p<kotlinx.coroutines.sync.c, kotlin.coroutines.c<? super R>, Object> block;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ MutexImpl f3963m;

        @Override // kotlinx.coroutines.sync.MutexImpl.a
        public void Q() throws Throwable {
            p<kotlinx.coroutines.sync.c, kotlin.coroutines.c<? super R>, Object> pVar = this.block;
            MutexImpl mutexImpl = this.f3963m;
            kotlin.coroutines.c<R> cVarB = this.select.b();
            final MutexImpl mutexImpl2 = this.f3963m;
            u0.a.d(pVar, mutexImpl, cVarB, new l<Throwable, t>() { // from class: kotlinx.coroutines.sync.MutexImpl$LockSelect$completeResumeLockWaiter$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // p0.l
                public /* bridge */ /* synthetic */ t invoke(Throwable th) {
                    invoke2(th);
                    return t.f3507a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Throwable th) {
                    mutexImpl2.b(this.owner);
                }
            });
        }

        @Override // kotlinx.coroutines.sync.MutexImpl.a
        public boolean S() {
            return R() && this.select.l();
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        @NotNull
        public String toString() {
            return "LockSelect[" + this.owner + ", " + this.select + "] for " + this.f3963m;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Mutex.kt */
    @Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0006\b¢\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0003H&¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0006H&¢\u0006\u0004\b\n\u0010\bR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$a;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/q0;", "", "R", "()Z", "Lkotlin/t;", "a", "()V", "S", "Q", "", "h", "Ljava/lang/Object;", "owner", "<init>", "(Lkotlinx/coroutines/sync/MutexImpl;Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    abstract class a extends LockFreeLinkedListNode implements q0 {

        /* renamed from: j, reason: collision with root package name */
        private static final /* synthetic */ AtomicIntegerFieldUpdater f3964j = AtomicIntegerFieldUpdater.newUpdater(a.class, "isTaken");

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public final Object owner;

        @NotNull
        private volatile /* synthetic */ int isTaken = 0;

        public a(@Nullable Object obj) {
            this.owner = obj;
        }

        public abstract void Q();

        public final boolean R() {
            return f3964j.compareAndSet(this, 0, 1);
        }

        public abstract boolean S();

        @Override // kotlinx.coroutines.q0
        public final void a() {
            L();
        }
    }

    /* compiled from: Mutex.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$b;", "Lkotlinx/coroutines/internal/n;", "", "toString", "", "h", "Ljava/lang/Object;", "owner", "<init>", "(Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private static final class b extends n {

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public Object owner;

        public b(@NotNull Object obj) {
            this.owner = obj;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        @NotNull
        public String toString() {
            return "LockedQueue[" + this.owner + ']';
        }
    }

    /* compiled from: Mutex.kt */
    @Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$c;", "Lkotlinx/coroutines/internal/d;", "Lkotlinx/coroutines/sync/MutexImpl;", "affected", "", "k", LoginLogger.EVENT_EXTRAS_FAILURE, "Lkotlin/t;", "j", "Lkotlinx/coroutines/sync/MutexImpl$b;", "b", "Lkotlinx/coroutines/sync/MutexImpl$b;", "queue", "<init>", "(Lkotlinx/coroutines/sync/MutexImpl$b;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private static final class c extends kotlinx.coroutines.internal.d<MutexImpl> {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public final b queue;

        public c(@NotNull b bVar) {
            this.queue = bVar;
        }

        @Override // kotlinx.coroutines.internal.d
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void d(@NotNull MutexImpl mutexImpl, @Nullable Object obj) {
            i.a(MutexImpl.f3958a, mutexImpl, this, obj == null ? MutexKt.f3974f : this.queue);
        }

        @Override // kotlinx.coroutines.internal.d
        @Nullable
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public Object i(@NotNull MutexImpl affected) {
            if (this.queue.Q()) {
                return null;
            }
            return MutexKt.f3970b;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x006e, code lost:
    
        kotlinx.coroutines.n.c(r0, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0071, code lost:
    
        r7 = r0.t();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0079, code lost:
    
        if (r7 != kotlin.coroutines.intrinsics.b.d()) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007b, code lost:
    
        kotlin.coroutines.jvm.internal.e.c(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0082, code lost:
    
        if (r7 != kotlin.coroutines.intrinsics.b.d()) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0084, code lost:
    
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0087, code lost:
    
        return kotlin.t.f3507a;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.Object c(final java.lang.Object r7, kotlin.coroutines.c<? super kotlin.t> r8) {
        /*
            r6 = this;
            kotlin.coroutines.c r0 = kotlin.coroutines.intrinsics.a.c(r8)
            kotlinx.coroutines.l r0 = kotlinx.coroutines.n.b(r0)
            kotlinx.coroutines.sync.MutexImpl$LockCont r1 = new kotlinx.coroutines.sync.MutexImpl$LockCont
            r1.<init>(r7, r0)
        Ld:
            java.lang.Object r2 = r6._state
            boolean r3 = r2 instanceof kotlinx.coroutines.sync.b
            if (r3 == 0) goto L4a
            r3 = r2
            kotlinx.coroutines.sync.b r3 = (kotlinx.coroutines.sync.b) r3
            java.lang.Object r4 = r3.locked
            kotlinx.coroutines.internal.d0 r5 = kotlinx.coroutines.sync.MutexKt.d()
            if (r4 == r5) goto L2b
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = kotlinx.coroutines.sync.MutexImpl.f3958a
            kotlinx.coroutines.sync.MutexImpl$b r5 = new kotlinx.coroutines.sync.MutexImpl$b
            java.lang.Object r3 = r3.locked
            r5.<init>(r3)
            kotlin.i.a(r4, r6, r2, r5)
            goto Ld
        L2b:
            if (r7 != 0) goto L32
            kotlinx.coroutines.sync.b r3 = kotlinx.coroutines.sync.MutexKt.a()
            goto L37
        L32:
            kotlinx.coroutines.sync.b r3 = new kotlinx.coroutines.sync.b
            r3.<init>(r7)
        L37:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = kotlinx.coroutines.sync.MutexImpl.f3958a
            boolean r2 = kotlin.i.a(r4, r6, r2, r3)
            if (r2 == 0) goto Ld
            kotlin.t r1 = kotlin.t.f3507a
            kotlinx.coroutines.sync.MutexImpl$lockSuspend$2$1$1 r2 = new kotlinx.coroutines.sync.MutexImpl$lockSuspend$2$1$1
            r2.<init>()
            r0.H(r1, r2)
            goto L71
        L4a:
            boolean r3 = r2 instanceof kotlinx.coroutines.sync.MutexImpl.b
            if (r3 == 0) goto L98
            r3 = r2
            kotlinx.coroutines.sync.MutexImpl$b r3 = (kotlinx.coroutines.sync.MutexImpl.b) r3
            java.lang.Object r4 = r3.owner
            if (r4 == r7) goto L57
            r4 = 1
            goto L58
        L57:
            r4 = 0
        L58:
            if (r4 == 0) goto L88
            r3.v(r1)
            java.lang.Object r3 = r6._state
            if (r3 == r2) goto L6e
            boolean r2 = r1.R()
            if (r2 != 0) goto L68
            goto L6e
        L68:
            kotlinx.coroutines.sync.MutexImpl$LockCont r1 = new kotlinx.coroutines.sync.MutexImpl$LockCont
            r1.<init>(r7, r0)
            goto Ld
        L6e:
            kotlinx.coroutines.n.c(r0, r1)
        L71:
            java.lang.Object r7 = r0.t()
            java.lang.Object r0 = kotlin.coroutines.intrinsics.a.d()
            if (r7 != r0) goto L7e
            kotlin.coroutines.jvm.internal.e.c(r8)
        L7e:
            java.lang.Object r8 = kotlin.coroutines.intrinsics.a.d()
            if (r7 != r8) goto L85
            return r7
        L85:
            kotlin.t r7 = kotlin.t.f3507a
            return r7
        L88:
            java.lang.String r8 = "Already locked by "
            java.lang.String r7 = kotlin.jvm.internal.s.m(r8, r7)
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r7 = r7.toString()
            r8.<init>(r7)
            throw r8
        L98:
            boolean r3 = r2 instanceof kotlinx.coroutines.internal.w
            if (r3 == 0) goto La3
            kotlinx.coroutines.internal.w r2 = (kotlinx.coroutines.internal.w) r2
            r2.c(r6)
            goto Ld
        La3:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "Illegal state "
            java.lang.String r8 = kotlin.jvm.internal.s.m(r8, r2)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            goto Lb4
        Lb3:
            throw r7
        Lb4:
            goto Lb3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.MutexImpl.c(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
    }

    @Override // kotlinx.coroutines.sync.c
    @Nullable
    public Object a(@Nullable Object obj, @NotNull kotlin.coroutines.c<? super t> cVar) {
        if (d(obj)) {
            return t.f3507a;
        }
        Object objC = c(obj, cVar);
        return objC == kotlin.coroutines.intrinsics.b.d() ? objC : t.f3507a;
    }

    @Override // kotlinx.coroutines.sync.c
    public void b(@Nullable Object owner) {
        while (true) {
            Object obj = this._state;
            if (obj instanceof kotlinx.coroutines.sync.b) {
                if (owner == null) {
                    if (!(((kotlinx.coroutines.sync.b) obj).locked != MutexKt.f3972d)) {
                        throw new IllegalStateException("Mutex is not locked".toString());
                    }
                } else {
                    kotlinx.coroutines.sync.b bVar = (kotlinx.coroutines.sync.b) obj;
                    if (!(bVar.locked == owner)) {
                        throw new IllegalStateException(("Mutex is locked by " + bVar.locked + " but expected " + owner).toString());
                    }
                }
                if (i.a(f3958a, this, obj, MutexKt.f3974f)) {
                    return;
                }
            } else if (obj instanceof w) {
                ((w) obj).c(this);
            } else {
                if (!(obj instanceof b)) {
                    throw new IllegalStateException(s.m("Illegal state ", obj).toString());
                }
                if (owner != null) {
                    b bVar2 = (b) obj;
                    if (!(bVar2.owner == owner)) {
                        throw new IllegalStateException(("Mutex is locked by " + bVar2.owner + " but expected " + owner).toString());
                    }
                }
                b bVar3 = (b) obj;
                LockFreeLinkedListNode lockFreeLinkedListNodeM = bVar3.M();
                if (lockFreeLinkedListNodeM == null) {
                    c cVar = new c(bVar3);
                    if (i.a(f3958a, this, obj, cVar) && cVar.c(this) == null) {
                        return;
                    }
                } else {
                    a aVar = (a) lockFreeLinkedListNodeM;
                    if (aVar.S()) {
                        Object obj2 = aVar.owner;
                        if (obj2 == null) {
                            obj2 = MutexKt.f3971c;
                        }
                        bVar3.owner = obj2;
                        aVar.Q();
                        return;
                    }
                }
            }
        }
    }

    public boolean d(@Nullable Object owner) {
        while (true) {
            Object obj = this._state;
            if (obj instanceof kotlinx.coroutines.sync.b) {
                if (((kotlinx.coroutines.sync.b) obj).locked != MutexKt.f3972d) {
                    return false;
                }
                if (i.a(f3958a, this, obj, owner == null ? MutexKt.f3973e : new kotlinx.coroutines.sync.b(owner))) {
                    return true;
                }
            } else {
                if (obj instanceof b) {
                    if (((b) obj).owner != owner) {
                        return false;
                    }
                    throw new IllegalStateException(s.m("Already locked by ", owner).toString());
                }
                if (!(obj instanceof w)) {
                    throw new IllegalStateException(s.m("Illegal state ", obj).toString());
                }
                ((w) obj).c(this);
            }
        }
    }

    @NotNull
    public String toString() {
        while (true) {
            Object obj = this._state;
            if (obj instanceof kotlinx.coroutines.sync.b) {
                return "Mutex[" + ((kotlinx.coroutines.sync.b) obj).locked + ']';
            }
            if (!(obj instanceof w)) {
                if (!(obj instanceof b)) {
                    throw new IllegalStateException(s.m("Illegal state ", obj).toString());
                }
                return "Mutex[" + ((b) obj).owner + ']';
            }
            ((w) obj).c(this);
        }
    }
}
