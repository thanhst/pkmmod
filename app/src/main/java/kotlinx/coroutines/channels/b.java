package kotlinx.coroutines.channels;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.y;
import kotlin.t;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.internal.d0;
import p0.l_p0;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AbstractChannel.kt */
@Metadata(bv = {}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001JB)\u0012 \u00103\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0004\u0018\u00010$j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`1¢\u0006\u0004\bI\u0010(J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\n\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\u0003\u001a\u00028\u00002\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0010\u001a\u00020\u00042\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\bH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0011\u0010\u0001\u001a\u0004\u0018\u00010\u0018H\u0004¢\u0006\u0004\b\u0001\u0010\u0019J\u001d\u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001a2\u0006\u0010\u0003\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\u001b\u0010\u001cJ\u001b\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0006J\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001e\u001a\u00020\u0018H\u0014¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010\"\u001a\u00020!2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\"\u0010#J)\u0010'\u001a\u00020\u00042\u0018\u0010&\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u00040$j\u0002`%H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020)H\u0014¢\u0006\u0004\b*\u0010+J\u0017\u0010,\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001aH\u0014¢\u0006\u0004\b,\u0010-J\u000f\u0010/\u001a\u00020.H\u0016¢\u0006\u0004\b/\u00100R.\u00103\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0004\u0018\u00010$j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`18\u0004X\u0085\u0004¢\u0006\u0006\n\u0004\b\u001f\u00102R\u001a\u00109\u001a\u0002048\u0004X\u0084\u0004¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u0014\u0010<\u001a\u00020!8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;R\u0014\u0010>\u001a\u00020.8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b=\u00100R\u0014\u0010@\u001a\u00020!8$X¤\u0004¢\u0006\u0006\u001a\u0004\b?\u0010;R\u0014\u0010B\u001a\u00020!8$X¤\u0004¢\u0006\u0006\u001a\u0004\bA\u0010;R\u001a\u0010E\u001a\b\u0012\u0002\b\u0003\u0018\u00010\b8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bC\u0010DR\u001a\u0010G\u001a\b\u0012\u0002\b\u0003\u0018\u00010\b8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bF\u0010DR\u0014\u0010H\u001a\u00020.8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b5\u00100\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006K"}, d2 = {"Lkotlinx/coroutines/channels/b;", "E", "Lkotlinx/coroutines/channels/s;", "element", "Lkotlin/t;", "C", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/coroutines/c;", "Lkotlinx/coroutines/channels/j;", "closed", "o", "(Lkotlin/coroutines/c;Ljava/lang/Object;Lkotlinx/coroutines/channels/j;)V", "", "cause", "p", "(Ljava/lang/Throwable;)V", "m", "(Lkotlinx/coroutines/channels/j;)V", "", "d", "()I", "", "u", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/r;", "()Lkotlinx/coroutines/channels/r;", "Lkotlinx/coroutines/channels/p;", "A", "(Ljava/lang/Object;)Lkotlinx/coroutines/channels/p;", "y", "send", "e", "(Lkotlinx/coroutines/channels/r;)Ljava/lang/Object;", "", "g", "(Ljava/lang/Throwable;)Z", "Lkotlin/Function1;", "Lkotlinx/coroutines/channels/Handler;", "handler", "x", "(Lp0/l;)V", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "w", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "D", "()Lkotlinx/coroutines/channels/p;", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "Lp0/l;", "onUndeliveredElement", "Lkotlinx/coroutines/internal/n;", "f", "Lkotlinx/coroutines/internal/n;", "j", "()Lkotlinx/coroutines/internal/n;", "queue", "t", "()Z", "isFullImpl", "l", "queueDebugStateString", "r", "isBufferAlwaysFull", "s", "isBufferFull", "i", "()Lkotlinx/coroutines/channels/j;", "closedForSend", "h", "closedForReceive", "bufferDebugString", "<init>", "a", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public abstract class b<E> implements s<E> {

    /* renamed from: g, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f3581g = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "onCloseHandler");

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @Nullable
    protected final l_p0<E, t> onUndeliveredElement;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final kotlinx.coroutines.internal.n queue = new kotlinx.coroutines.internal.n();

    @NotNull
    private volatile /* synthetic */ Object onCloseHandler = null;

    /* compiled from: AbstractChannel.kt */
    @Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0000\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0010\u001a\u00028\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0014\u0010\u000b\u001a\u00020\u00072\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\u0014\u0010\u0010\u001a\u00028\u00018\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/channels/b$a;", "E", "Lkotlinx/coroutines/channels/r;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$c;", "otherOp", "Lkotlinx/coroutines/internal/d0;", "T", "Lkotlin/t;", "Q", "Lkotlinx/coroutines/channels/j;", "closed", "S", "", "toString", "h", "Ljava/lang/Object;", "element", "", "R", "()Ljava/lang/Object;", "pollResult", "<init>", "(Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static final class a<E> extends r {

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @JvmField
        public final E element;

        public a(E e2) {
            this.element = e2;
        }

        @Override // kotlinx.coroutines.channels.r
        public void Q() {
        }

        @Override // kotlinx.coroutines.channels.r
        @Nullable
        /* renamed from: R, reason: from getter */
        public Object getElement() {
            return this.element;
        }

        @Override // kotlinx.coroutines.channels.r
        public void S(@NotNull j<?> jVar) {
        }

        @Override // kotlinx.coroutines.channels.r
        @Nullable
        public d0 T(@Nullable LockFreeLinkedListNode.PrepareOp otherOp) {
            d0 d0Var = kotlinx.coroutines.m.f3863a;
            if (otherOp != null) {
                otherOp.d();
            }
            return d0Var;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        @NotNull
        public String toString() {
            return "SendBuffered@" + i0.b(this) + '(' + this.element + ')';
        }
    }

    /* compiled from: LockFreeLinkedList.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/channels/b$b", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$b;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "affected", "", "k", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    /* renamed from: kotlinx.coroutines.channels.b$b, reason: collision with other inner class name */
    public static final class C0060b extends LockFreeLinkedListNode.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LockFreeLinkedListNode f3585d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f3586e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0060b(LockFreeLinkedListNode lockFreeLinkedListNode, b bVar) {
            super(lockFreeLinkedListNode);
            this.f3585d = lockFreeLinkedListNode;
            this.f3586e = bVar;
        }

        @Override // kotlinx.coroutines.internal.d
        @Nullable
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public Object i(@NotNull LockFreeLinkedListNode affected) {
            if (this.f3586e.s()) {
                return null;
            }
            return kotlinx.coroutines.internal.o.a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(@Nullable l_p0<? super E, t> lP0Var) {
        this.onUndeliveredElement = lP0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0055 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.Object C(E r4, kotlin.coroutines.c<? super kotlin.t> r5) {
        /*
            r3 = this;
            kotlin.coroutines.c r0 = kotlin.coroutines.intrinsics.a.c(r5)
            kotlinx.coroutines.l r0 = kotlinx.coroutines.n.b(r0)
        L8:
            boolean r1 = c(r3)
            if (r1 == 0) goto L4d
            p0.l<E, kotlin.t> r1 = r3.onUndeliveredElement
            if (r1 != 0) goto L18
            kotlinx.coroutines.channels.t r1 = new kotlinx.coroutines.channels.t
            r1.<init>(r4, r0)
            goto L1f
        L18:
            kotlinx.coroutines.channels.u r1 = new kotlinx.coroutines.channels.u
            p0.l<E, kotlin.t> r2 = r3.onUndeliveredElement
            r1.<init>(r4, r0, r2)
        L1f:
            java.lang.Object r2 = r3.e(r1)
            if (r2 != 0) goto L29
            kotlinx.coroutines.n.c(r0, r1)
            goto L6f
        L29:
            boolean r1 = r2 instanceof kotlinx.coroutines.channels.j
            if (r1 == 0) goto L33
            kotlinx.coroutines.channels.j r2 = (kotlinx.coroutines.channels.j) r2
            b(r3, r0, r4, r2)
            goto L6f
        L33:
            kotlinx.coroutines.internal.d0 r1 = kotlinx.coroutines.channels.a.f3579e
            if (r2 != r1) goto L38
            goto L4d
        L38:
            boolean r1 = r2 instanceof kotlinx.coroutines.channels.o
            if (r1 == 0) goto L3d
            goto L4d
        L3d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "enqueueSend returned "
            java.lang.String r5 = kotlin.jvm.internal.s.m(r5, r2)
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        L4d:
            java.lang.Object r1 = r3.u(r4)
            kotlinx.coroutines.internal.d0 r2 = kotlinx.coroutines.channels.a.f3576b
            if (r1 != r2) goto L61
            kotlin.Result$a r4 = kotlin.Result.INSTANCE
            kotlin.t r4 = kotlin.t.f3507a
            java.lang.Object r4 = kotlin.Result.m158constructorimpl(r4)
            r0.resumeWith(r4)
            goto L6f
        L61:
            kotlinx.coroutines.internal.d0 r2 = kotlinx.coroutines.channels.a.f3577c
            if (r1 != r2) goto L66
            goto L8
        L66:
            boolean r2 = r1 instanceof kotlinx.coroutines.channels.j
            if (r2 == 0) goto L86
            kotlinx.coroutines.channels.j r1 = (kotlinx.coroutines.channels.j) r1
            b(r3, r0, r4, r1)
        L6f:
            java.lang.Object r4 = r0.t()
            java.lang.Object r0 = kotlin.coroutines.intrinsics.a.d()
            if (r4 != r0) goto L7c
            kotlin.coroutines.jvm.internal.e.c(r5)
        L7c:
            java.lang.Object r5 = kotlin.coroutines.intrinsics.a.d()
            if (r4 != r5) goto L83
            return r4
        L83:
            kotlin.t r4 = kotlin.t.f3507a
            return r4
        L86:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "offerInternal returned "
            java.lang.String r5 = kotlin.jvm.internal.s.m(r5, r1)
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            goto L97
        L96:
            throw r4
        L97:
            goto L96
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.b.C(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
    }

    private final int d() {
        kotlinx.coroutines.internal.n nVar = this.queue;
        int i2 = 0;
        for (LockFreeLinkedListNode lockFreeLinkedListNodeC = (LockFreeLinkedListNode) nVar.B(); !kotlin.jvm.internal.s.a(lockFreeLinkedListNodeC, nVar); lockFreeLinkedListNodeC = lockFreeLinkedListNodeC.C()) {
            if (lockFreeLinkedListNodeC instanceof LockFreeLinkedListNode) {
                i2++;
            }
        }
        return i2;
    }

    private final String l() {
        LockFreeLinkedListNode lockFreeLinkedListNodeC = this.queue.C();
        if (lockFreeLinkedListNodeC == this.queue) {
            return "EmptyQueue";
        }
        String string = lockFreeLinkedListNodeC instanceof j ? lockFreeLinkedListNodeC.toString() : lockFreeLinkedListNodeC instanceof o ? "ReceiveQueued" : lockFreeLinkedListNodeC instanceof r ? "SendQueued" : kotlin.jvm.internal.s.m("UNEXPECTED:", lockFreeLinkedListNodeC);
        LockFreeLinkedListNode lockFreeLinkedListNodeF = this.queue.F();
        if (lockFreeLinkedListNodeF == lockFreeLinkedListNodeC) {
            return string;
        }
        String str = string + ",queueSize=" + d();
        if (!(lockFreeLinkedListNodeF instanceof j)) {
            return str;
        }
        return str + ",closedForSend=" + lockFreeLinkedListNodeF;
    }

    private final void m(j<?> closed) {
        Object objB = kotlinx.coroutines.internal.k.b(null, 1, null);
        while (true) {
            LockFreeLinkedListNode lockFreeLinkedListNodeF = closed.F();
            o oVar = lockFreeLinkedListNodeF instanceof o ? (o) lockFreeLinkedListNodeF : null;
            if (oVar == null) {
                break;
            } else if (oVar.L()) {
                objB = kotlinx.coroutines.internal.k.c(objB, oVar);
            } else {
                oVar.I();
            }
        }
        if (objB != null) {
            if (objB instanceof ArrayList) {
                ArrayList arrayList = (ArrayList) objB;
                int size = arrayList.size() - 1;
                if (size >= 0) {
                    while (true) {
                        int i2 = size - 1;
                        ((o) arrayList.get(size)).S(closed);
                        if (i2 < 0) {
                            break;
                        } else {
                            size = i2;
                        }
                    }
                }
            } else {
                ((o) objB).S(closed);
            }
        }
        w(closed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(kotlin.coroutines.c<?> cVar, E e2, j<?> jVar) {
        UndeliveredElementException undeliveredElementExceptionD;
        m(jVar);
        Throwable thY = jVar.Y();
        l_p0<E, t> lP0Var = this.onUndeliveredElement;
        if (lP0Var == null || (undeliveredElementExceptionD = OnUndeliveredElementKt.d(lP0Var, e2, null, 2, null)) == null) {
            Result.Companion companion = Result.INSTANCE;
            cVar.resumeWith(Result.m158constructorimpl(kotlin.h.a(thY)));
        } else {
            kotlin.b.a(undeliveredElementExceptionD, thY);
            Result.Companion companion2 = Result.INSTANCE;
            cVar.resumeWith(Result.m158constructorimpl(kotlin.h.a(undeliveredElementExceptionD)));
        }
    }

    private final void p(Throwable cause) {
        d0 d0Var;
        Object obj = this.onCloseHandler;
        if (obj == null || obj == (d0Var = kotlinx.coroutines.channels.a.f3580f) || !kotlin.i.a(f3581g, this, obj, d0Var)) {
            return;
        }
        ((l_p0) y.b(obj, 1)).invoke(cause);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean t() {
        return !(this.queue.C() instanceof p) && s();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    protected final p<?> A(E element) {
        LockFreeLinkedListNode lockFreeLinkedListNodeF;
        kotlinx.coroutines.internal.n nVar = this.queue;
        a aVar = new a(element);
        do {
            lockFreeLinkedListNodeF = nVar.F();
            if (lockFreeLinkedListNodeF instanceof p) {
                return (p) lockFreeLinkedListNodeF;
            }
        } while (!lockFreeLinkedListNodeF.w(aVar, nVar));
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000b, code lost:
    
        r1 = 0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [kotlinx.coroutines.internal.LockFreeLinkedListNode] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected kotlinx.coroutines.channels.p<E> D() {
        /*
            r4 = this;
            kotlinx.coroutines.internal.n r0 = r4.queue
        L2:
            java.lang.Object r1 = r0.B()
            kotlinx.coroutines.internal.LockFreeLinkedListNode r1 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r1
            r2 = 0
            if (r1 != r0) goto Ld
        Lb:
            r1 = r2
            goto L26
        Ld:
            boolean r3 = r1 instanceof kotlinx.coroutines.channels.p
            if (r3 != 0) goto L12
            goto Lb
        L12:
            r2 = r1
            kotlinx.coroutines.channels.p r2 = (kotlinx.coroutines.channels.p) r2
            boolean r2 = r2 instanceof kotlinx.coroutines.channels.j
            if (r2 == 0) goto L20
            boolean r2 = r1.K()
            if (r2 != 0) goto L20
            goto L26
        L20:
            kotlinx.coroutines.internal.LockFreeLinkedListNode r2 = r1.N()
            if (r2 != 0) goto L29
        L26:
            kotlinx.coroutines.channels.p r1 = (kotlinx.coroutines.channels.p) r1
            return r1
        L29:
            r2.J()
            goto L2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.b.D():kotlinx.coroutines.channels.p");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000b, code lost:
    
        r1 = null;
     */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final kotlinx.coroutines.channels.r E() {
        /*
            r4 = this;
            kotlinx.coroutines.internal.n r0 = r4.queue
        L2:
            java.lang.Object r1 = r0.B()
            kotlinx.coroutines.internal.LockFreeLinkedListNode r1 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r1
            r2 = 0
            if (r1 != r0) goto Ld
        Lb:
            r1 = r2
            goto L26
        Ld:
            boolean r3 = r1 instanceof kotlinx.coroutines.channels.r
            if (r3 != 0) goto L12
            goto Lb
        L12:
            r2 = r1
            kotlinx.coroutines.channels.r r2 = (kotlinx.coroutines.channels.r) r2
            boolean r2 = r2 instanceof kotlinx.coroutines.channels.j
            if (r2 == 0) goto L20
            boolean r2 = r1.K()
            if (r2 != 0) goto L20
            goto L26
        L20:
            kotlinx.coroutines.internal.LockFreeLinkedListNode r2 = r1.N()
            if (r2 != 0) goto L29
        L26:
            kotlinx.coroutines.channels.r r1 = (kotlinx.coroutines.channels.r) r1
            return r1
        L29:
            r2.J()
            goto L2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.b.E():kotlinx.coroutines.channels.r");
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0034, code lost:
    
        if (r3 != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0038, code lost:
    
        return kotlinx.coroutines.channels.a.f3579e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0039, code lost:
    
        return null;
     */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected java.lang.Object e(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.r r5) {
        /*
            r4 = this;
            boolean r0 = r4.r()
            if (r0 == 0) goto L18
            kotlinx.coroutines.internal.n r0 = r4.queue
        L8:
            kotlinx.coroutines.internal.LockFreeLinkedListNode r1 = r0.F()
            boolean r2 = r1 instanceof kotlinx.coroutines.channels.p
            if (r2 == 0) goto L11
            return r1
        L11:
            boolean r1 = r1.w(r5, r0)
            if (r1 == 0) goto L8
            goto L39
        L18:
            kotlinx.coroutines.internal.n r0 = r4.queue
            kotlinx.coroutines.channels.b$b r1 = new kotlinx.coroutines.channels.b$b
            r1.<init>(r5, r4)
        L1f:
            kotlinx.coroutines.internal.LockFreeLinkedListNode r2 = r0.F()
            boolean r3 = r2 instanceof kotlinx.coroutines.channels.p
            if (r3 == 0) goto L28
            return r2
        L28:
            int r2 = r2.P(r5, r0, r1)
            r3 = 1
            if (r2 == r3) goto L34
            r3 = 2
            if (r2 == r3) goto L33
            goto L1f
        L33:
            r3 = 0
        L34:
            if (r3 != 0) goto L39
            kotlinx.coroutines.internal.d0 r5 = kotlinx.coroutines.channels.a.f3579e
            return r5
        L39:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.b.e(kotlinx.coroutines.channels.r):java.lang.Object");
    }

    @NotNull
    protected String f() {
        return "";
    }

    @Override // kotlinx.coroutines.channels.s
    public boolean g(@Nullable Throwable cause) {
        boolean z2;
        j<?> jVar = new j<>(cause);
        LockFreeLinkedListNode lockFreeLinkedListNode = this.queue;
        while (true) {
            LockFreeLinkedListNode lockFreeLinkedListNodeF = lockFreeLinkedListNode.F();
            z2 = true;
            if (!(!(lockFreeLinkedListNodeF instanceof j))) {
                z2 = false;
                break;
            }
            if (lockFreeLinkedListNodeF.w(jVar, lockFreeLinkedListNode)) {
                break;
            }
        }
        if (!z2) {
            jVar = (j) this.queue.F();
        }
        m(jVar);
        if (z2) {
            p(cause);
        }
        return z2;
    }

    @Nullable
    protected final j<?> h() {
        LockFreeLinkedListNode lockFreeLinkedListNodeC = this.queue.C();
        j<?> jVar = lockFreeLinkedListNodeC instanceof j ? (j) lockFreeLinkedListNodeC : null;
        if (jVar == null) {
            return null;
        }
        m(jVar);
        return jVar;
    }

    @Nullable
    protected final j<?> i() {
        LockFreeLinkedListNode lockFreeLinkedListNodeF = this.queue.F();
        j<?> jVar = lockFreeLinkedListNodeF instanceof j ? (j) lockFreeLinkedListNodeF : null;
        if (jVar == null) {
            return null;
        }
        m(jVar);
        return jVar;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    protected final kotlinx.coroutines.internal.n getQueue() {
        return this.queue;
    }

    protected abstract boolean r();

    protected abstract boolean s();

    @NotNull
    public String toString() {
        return i0.a(this) + '@' + i0.b(this) + '{' + l() + '}' + f();
    }

    @NotNull
    protected Object u(E element) {
        p<E> pVarD;
        do {
            pVarD = D();
            if (pVarD == null) {
                return kotlinx.coroutines.channels.a.f3577c;
            }
        } while (pVarD.n(element, null) == null);
        pVarD.f(element);
        return pVarD.k();
    }

    protected void w(@NotNull LockFreeLinkedListNode closed) {
    }

    @Override // kotlinx.coroutines.channels.s
    public void x(@NotNull l_p0<? super Throwable, t> handler) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3581g;
        if (!kotlin.i.a(atomicReferenceFieldUpdater, this, null, handler)) {
            Object obj = this.onCloseHandler;
            if (obj != kotlinx.coroutines.channels.a.f3580f) {
                throw new IllegalStateException(kotlin.jvm.internal.s.m("Another handler was already registered: ", obj));
            }
            throw new IllegalStateException("Another handler was already registered and successfully invoked");
        }
        j<?> jVarI = i();
        if (jVarI == null || !kotlin.i.a(atomicReferenceFieldUpdater, this, handler, kotlinx.coroutines.channels.a.f3580f)) {
            return;
        }
        handler.invoke(jVarI.closeCause);
    }

    @Override // kotlinx.coroutines.channels.s
    @Nullable
    public final Object y(E e2, @NotNull kotlin.coroutines.c<? super kotlin.t> cVar) {
        if (u(e2) == kotlinx.coroutines.channels.a.f3576b) {
            return kotlin.t.f3507a;
        }
        Object objC = C(e2, cVar);
        return objC == kotlin.coroutines.intrinsics.b.d() ? objC : kotlin.t.f3507a;
    }
}
