package kotlinx.coroutines.internal;

import com.facebook.login.LoginLogger;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LockFreeLinkedList.kt */
@InternalCoroutinesApi
@Metadata(bv = {}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0017\u0018\u00002\u00020\u0001:\u00041234B\u0007¢\u0006\u0004\b0\u0010\"J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0007\u001a\u00060\u0000j\u0002`\u00052\n\u0010\u0006\u001a\u00060\u0000j\u0002`\u0005H\u0082\u0010¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u000b\u001a\u00020\n2\n\u0010\t\u001a\u00060\u0000j\u0002`\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\"\u0010\u000f\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0082\u0010¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\u00122\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u0005¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0015\u001a\u00020\n2\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u0005¢\u0006\u0004\b\u0015\u0010\fJ'\u0010\u0016\u001a\u00020\u00122\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u00052\n\u0010\t\u001a\u00060\u0000j\u0002`\u0005H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J/\u0010\u001b\u001a\u00020\u001a2\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u00052\n\u0010\t\u001a\u00060\u0000j\u0002`\u00052\u0006\u0010\u0019\u001a\u00020\u0018H\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0005H\u0001¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\n¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\nH\u0001¢\u0006\u0004\b#\u0010\"J\u0015\u0010$\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0005¢\u0006\u0004\b$\u0010 J\u000f\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b&\u0010'R\u0014\u0010)\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u001eR\u0011\u0010\t\u001a\u00020\u00018F¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0015\u0010-\u001a\u00060\u0000j\u0002`\u00058F¢\u0006\u0006\u001a\u0004\b,\u0010 R\u0015\u0010/\u001a\u00060\u0000j\u0002`\u00058F¢\u0006\u0006\u001a\u0004\b.\u0010 ¨\u00065"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "", "Lkotlinx/coroutines/internal/x;", "O", "()Lkotlinx/coroutines/internal/x;", "Lkotlinx/coroutines/internal/Node;", "current", "z", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "next", "Lkotlin/t;", "A", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "Lkotlinx/coroutines/internal/w;", "op", "y", "(Lkotlinx/coroutines/internal/w;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "node", "", "x", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Z", "v", "w", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Z", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$b;", "condAdd", "", "P", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$b;)I", "L", "()Z", "N", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "I", "()V", "J", "M", "", "toString", "()Ljava/lang/String;", "K", "isRemoved", "B", "()Ljava/lang/Object;", "C", "nextNode", "F", "prevNode", "<init>", "a", "b", "c", "d", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public class LockFreeLinkedListNode {

    /* renamed from: e, reason: collision with root package name */
    static final /* synthetic */ AtomicReferenceFieldUpdater f3782e = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_next");

    /* renamed from: f, reason: collision with root package name */
    static final /* synthetic */ AtomicReferenceFieldUpdater f3783f = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_prev");

    /* renamed from: g, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f3784g = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_removedRef");

    @NotNull
    volatile /* synthetic */ Object _next = this;

    @NotNull
    volatile /* synthetic */ Object _prev = this;

    @NotNull
    private volatile /* synthetic */ Object _removedRef = null;

    /* compiled from: LockFreeLinkedList.kt */
    @Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\u0006\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u0016\u0010\t\u001a\u0004\u0018\u00010\b2\n\u0010\u0007\u001a\u00060\u0004j\u0002`\u0005H\u0014J\u001c\u0010\f\u001a\u00020\u000b2\n\u0010\u0007\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\n\u001a\u00020\bH\u0014J \u0010\u000e\u001a\u00020\r2\n\u0010\u0007\u001a\u00060\u0004j\u0002`\u00052\n\u0010\n\u001a\u00060\u0004j\u0002`\u0005H$J \u0010\u000f\u001a\u00020\b2\n\u0010\u0007\u001a\u00060\u0004j\u0002`\u00052\n\u0010\n\u001a\u00060\u0004j\u0002`\u0005H&J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H&J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0014\u0010\u0014\u001a\u00020\r2\n\u0010\u0007\u001a\u00060\u0004j\u0002`\u0005H\u0016J\u0014\u0010\u0016\u001a\u0004\u0018\u00010\b2\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0015J\u001c\u0010\u0018\u001a\u00020\r2\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\bR\u001c\u0010\u001b\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00058$X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001d\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00058$X¤\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001a¨\u0006 "}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$a;", "Lkotlinx/coroutines/internal/b;", "Lkotlinx/coroutines/internal/w;", "op", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "m", "affected", "", "e", "next", "", "l", "Lkotlin/t;", "f", "n", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$c;", "prepareOp", "g", "j", "k", "Lkotlinx/coroutines/internal/d;", "c", LoginLogger.EVENT_EXTRAS_FAILURE, "a", "h", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "affectedNode", "i", "originalNext", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static abstract class a extends kotlinx.coroutines.internal.b {
        @Override // kotlinx.coroutines.internal.b
        public final void a(@NotNull kotlinx.coroutines.internal.d<?> dVar, @Nullable Object obj) {
            LockFreeLinkedListNode lockFreeLinkedListNodeI;
            boolean z2 = obj == null;
            LockFreeLinkedListNode lockFreeLinkedListNodeH = h();
            if (lockFreeLinkedListNodeH == null || (lockFreeLinkedListNodeI = i()) == null) {
                return;
            }
            if (kotlin.i.a(LockFreeLinkedListNode.f3782e, lockFreeLinkedListNodeH, dVar, z2 ? n(lockFreeLinkedListNodeH, lockFreeLinkedListNodeI) : lockFreeLinkedListNodeI) && z2) {
                f(lockFreeLinkedListNodeH, lockFreeLinkedListNodeI);
            }
        }

        @Override // kotlinx.coroutines.internal.b
        @Nullable
        public final Object c(@NotNull kotlinx.coroutines.internal.d<?> op) {
            while (true) {
                LockFreeLinkedListNode lockFreeLinkedListNodeM = m(op);
                if (lockFreeLinkedListNodeM == null) {
                    return c.f3804b;
                }
                Object obj = lockFreeLinkedListNodeM._next;
                if (obj == op || op.h()) {
                    return null;
                }
                if (obj instanceof w) {
                    w wVar = (w) obj;
                    if (op.b(wVar)) {
                        return c.f3804b;
                    }
                    wVar.c(lockFreeLinkedListNodeM);
                } else {
                    Object objE = e(lockFreeLinkedListNodeM);
                    if (objE != null) {
                        return objE;
                    }
                    if (l(lockFreeLinkedListNodeM, obj)) {
                        continue;
                    } else {
                        PrepareOp prepareOp = new PrepareOp(lockFreeLinkedListNodeM, (LockFreeLinkedListNode) obj, this);
                        if (kotlin.i.a(LockFreeLinkedListNode.f3782e, lockFreeLinkedListNodeM, obj, prepareOp)) {
                            try {
                                if (prepareOp.c(lockFreeLinkedListNodeM) != p.f3834a) {
                                    return null;
                                }
                            } catch (Throwable th) {
                                kotlin.i.a(LockFreeLinkedListNode.f3782e, lockFreeLinkedListNodeM, prepareOp, obj);
                                throw th;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        }

        @Nullable
        protected abstract Object e(@NotNull LockFreeLinkedListNode affected);

        protected abstract void f(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2);

        public abstract void g(@NotNull PrepareOp prepareOp);

        @Nullable
        protected abstract LockFreeLinkedListNode h();

        @Nullable
        protected abstract LockFreeLinkedListNode i();

        @Nullable
        public Object j(@NotNull PrepareOp prepareOp) {
            g(prepareOp);
            return null;
        }

        public void k(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
        }

        protected abstract boolean l(@NotNull LockFreeLinkedListNode affected, @NotNull Object next);

        @Nullable
        protected abstract LockFreeLinkedListNode m(@NotNull w op);

        @NotNull
        public abstract Object n(@NotNull LockFreeLinkedListNode affected, @NotNull LockFreeLinkedListNode next);
    }

    /* compiled from: LockFreeLinkedList.kt */
    @Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b!\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001B\u0013\u0012\n\u0010\u000b\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016R\u0018\u0010\u000b\u001a\u00060\u0002j\u0002`\u00038\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001e\u0010\r\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\n¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$b;", "Lkotlinx/coroutines/internal/d;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "affected", "", LoginLogger.EVENT_EXTRAS_FAILURE, "Lkotlin/t;", "j", "b", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "newNode", "c", "oldNext", "<init>", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    @PublishedApi
    public static abstract class b extends kotlinx.coroutines.internal.d<LockFreeLinkedListNode> {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public final LockFreeLinkedListNode newNode;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public LockFreeLinkedListNode oldNext;

        public b(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
            this.newNode = lockFreeLinkedListNode;
        }

        @Override // kotlinx.coroutines.internal.d
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void d(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @Nullable Object obj) {
            boolean z2 = obj == null;
            LockFreeLinkedListNode lockFreeLinkedListNode2 = z2 ? this.newNode : this.oldNext;
            if (lockFreeLinkedListNode2 != null && kotlin.i.a(LockFreeLinkedListNode.f3782e, lockFreeLinkedListNode, this, lockFreeLinkedListNode2) && z2) {
                LockFreeLinkedListNode lockFreeLinkedListNode3 = this.newNode;
                LockFreeLinkedListNode lockFreeLinkedListNode4 = this.oldNext;
                kotlin.jvm.internal.s.b(lockFreeLinkedListNode4);
                lockFreeLinkedListNode3.A(lockFreeLinkedListNode4);
            }
        }
    }

    /* compiled from: LockFreeLinkedList.kt */
    @Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\u0012\n\u0010\u0003\u001a\u00060\tj\u0002`\n\u0012\n\u0010\u000e\u001a\u00060\tj\u0002`\n\u0012\u0006\u0010\u0011\u001a\u00020\u000f¢\u0006\u0004\b\u0015\u0010\u0016J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0006\u0010\u0006\u001a\u00020\u0005J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0018\u0010\u0003\u001a\u00060\tj\u0002`\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u000e\u001a\u00060\tj\u0002`\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0010R\u0018\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0013¨\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$c;", "Lkotlinx/coroutines/internal/w;", "", "affected", "c", "Lkotlin/t;", "d", "", "toString", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "a", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "b", "next", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$a;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$a;", "desc", "Lkotlinx/coroutines/internal/d;", "()Lkotlinx/coroutines/internal/d;", "atomicOp", "<init>", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$a;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    /* renamed from: kotlinx.coroutines.internal.LockFreeLinkedListNode$c, reason: from toString */
    public static final class PrepareOp extends w {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public final LockFreeLinkedListNode affected;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public final LockFreeLinkedListNode next;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public final a desc;

        public PrepareOp(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2, @NotNull a aVar) {
            this.affected = lockFreeLinkedListNode;
            this.next = lockFreeLinkedListNode2;
            this.desc = aVar;
        }

        @Override // kotlinx.coroutines.internal.w
        @NotNull
        public kotlinx.coroutines.internal.d<?> a() {
            return this.desc.b();
        }

        @Override // kotlinx.coroutines.internal.w
        @Nullable
        public Object c(@Nullable Object affected) {
            if (affected == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            }
            LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) affected;
            Object objJ = this.desc.j(this);
            Object obj = p.f3834a;
            if (objJ != obj) {
                Object objE = objJ != null ? a().e(objJ) : a().get_consensus();
                kotlin.i.a(LockFreeLinkedListNode.f3782e, lockFreeLinkedListNode, this, objE == c.f3803a ? a() : objE == null ? this.desc.n(lockFreeLinkedListNode, this.next) : this.next);
                return null;
            }
            LockFreeLinkedListNode lockFreeLinkedListNode2 = this.next;
            if (kotlin.i.a(LockFreeLinkedListNode.f3782e, lockFreeLinkedListNode, this, lockFreeLinkedListNode2.O())) {
                this.desc.k(lockFreeLinkedListNode);
                lockFreeLinkedListNode2.y(null);
            }
            return obj;
        }

        public final void d() {
            this.desc.g(this);
        }

        @Override // kotlinx.coroutines.internal.w
        @NotNull
        public String toString() {
            return "PrepareOp(op=" + a() + ')';
        }
    }

    /* compiled from: LockFreeLinkedList.kt */
    @Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\u0012\n\u0010\u001c\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b'\u0010(J\u001f\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00062\u0006\u0010\u0004\u001a\u00020\u0003H\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\u0010\t\u001a\u00060\u0005j\u0002`\u0006H\u0014¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u000f\u001a\u00020\u000e2\n\u0010\t\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\r\u001a\u00020\nH\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0016\u001a\u00020\n2\n\u0010\t\u001a\u00060\u0005j\u0002`\u00062\n\u0010\r\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u0018\u001a\u00020\u00132\n\u0010\t\u001a\u00060\u0005j\u0002`\u00062\n\u0010\r\u001a\u00060\u0005j\u0002`\u0006H\u0004¢\u0006\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001c\u001a\u00060\u0005j\u0002`\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0017\u0010!\u001a\u00028\u00008F¢\u0006\f\u0012\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010$\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00068DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u001c\u0010&\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00068DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b%\u0010#¨\u0006)"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$d;", "T", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$a;", "Lkotlinx/coroutines/internal/w;", "op", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "m", "(Lkotlinx/coroutines/internal/w;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "affected", "", "e", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", "next", "", "l", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$c;", "prepareOp", "Lkotlin/t;", "g", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$c;)V", "n", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", "f", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "b", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "queue", "o", "()Ljava/lang/Object;", "getResult$annotations", "()V", "result", "h", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "affectedNode", "i", "originalNext", "<init>", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static class d<T> extends a {

        /* renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ AtomicReferenceFieldUpdater f3790c = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "_affectedNode");

        /* renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ AtomicReferenceFieldUpdater f3791d = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "_originalNext");

        @NotNull
        private volatile /* synthetic */ Object _affectedNode = null;

        @NotNull
        private volatile /* synthetic */ Object _originalNext = null;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public final LockFreeLinkedListNode queue;

        public d(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
            this.queue = lockFreeLinkedListNode;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.a
        @Nullable
        protected Object e(@NotNull LockFreeLinkedListNode affected) {
            if (affected == this.queue) {
                return o.b();
            }
            return null;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.a
        protected final void f(@NotNull LockFreeLinkedListNode affected, @NotNull LockFreeLinkedListNode next) {
            next.y(null);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.a
        public void g(@NotNull PrepareOp prepareOp) {
            kotlin.i.a(f3790c, this, null, prepareOp.affected);
            kotlin.i.a(f3791d, this, null, prepareOp.next);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.a
        @Nullable
        protected final LockFreeLinkedListNode h() {
            return (LockFreeLinkedListNode) this._affectedNode;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.a
        @Nullable
        protected final LockFreeLinkedListNode i() {
            return (LockFreeLinkedListNode) this._originalNext;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.a
        protected final boolean l(@NotNull LockFreeLinkedListNode affected, @NotNull Object next) {
            if (!(next instanceof x)) {
                return false;
            }
            ((x) next).ref.J();
            return true;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.a
        @Nullable
        protected final LockFreeLinkedListNode m(@NotNull w op) {
            LockFreeLinkedListNode lockFreeLinkedListNode = this.queue;
            while (true) {
                Object obj = lockFreeLinkedListNode._next;
                if (!(obj instanceof w)) {
                    return (LockFreeLinkedListNode) obj;
                }
                w wVar = (w) obj;
                if (op.b(wVar)) {
                    return null;
                }
                wVar.c(this.queue);
            }
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.a
        @NotNull
        public final Object n(@NotNull LockFreeLinkedListNode affected, @NotNull LockFreeLinkedListNode next) {
            return next.O();
        }

        public final T o() {
            T t2 = (T) h();
            kotlin.jvm.internal.s.b(t2);
            return t2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(LockFreeLinkedListNode next) {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        do {
            lockFreeLinkedListNode = (LockFreeLinkedListNode) next._prev;
            if (B() != next) {
                return;
            }
        } while (!kotlin.i.a(f3783f, next, lockFreeLinkedListNode, this));
        if (K()) {
            next.y(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final x O() {
        x xVar = (x) this._removedRef;
        if (xVar != null) {
            return xVar;
        }
        x xVar2 = new x(this);
        f3784g.lazySet(this, xVar2);
        return xVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0048, code lost:
    
        if (kotlin.i.a(kotlinx.coroutines.internal.LockFreeLinkedListNode.f3782e, r3, r2, ((kotlinx.coroutines.internal.x) r4).f3851a) != false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final kotlinx.coroutines.internal.LockFreeLinkedListNode y(kotlinx.coroutines.internal.w r8) {
        /*
            r7 = this;
        L0:
            java.lang.Object r0 = r7._prev
            kotlinx.coroutines.internal.LockFreeLinkedListNode r0 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r0
            r1 = 0
            r2 = r0
        L6:
            r3 = r1
        L7:
            java.lang.Object r4 = r2._next
            if (r4 != r7) goto L18
            if (r0 != r2) goto Le
            return r2
        Le:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = kotlinx.coroutines.internal.LockFreeLinkedListNode.f3783f
            boolean r0 = kotlin.i.a(r1, r7, r0, r2)
            if (r0 != 0) goto L17
            goto L0
        L17:
            return r2
        L18:
            boolean r5 = r7.K()
            if (r5 == 0) goto L1f
            return r1
        L1f:
            if (r4 != r8) goto L22
            return r2
        L22:
            boolean r5 = r4 instanceof kotlinx.coroutines.internal.w
            if (r5 == 0) goto L38
            if (r8 == 0) goto L32
            r0 = r4
            kotlinx.coroutines.internal.w r0 = (kotlinx.coroutines.internal.w) r0
            boolean r0 = r8.b(r0)
            if (r0 == 0) goto L32
            return r1
        L32:
            kotlinx.coroutines.internal.w r4 = (kotlinx.coroutines.internal.w) r4
            r4.c(r2)
            goto L0
        L38:
            boolean r5 = r4 instanceof kotlinx.coroutines.internal.x
            if (r5 == 0) goto L52
            if (r3 == 0) goto L4d
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = kotlinx.coroutines.internal.LockFreeLinkedListNode.f3782e
            kotlinx.coroutines.internal.x r4 = (kotlinx.coroutines.internal.x) r4
            kotlinx.coroutines.internal.LockFreeLinkedListNode r4 = r4.ref
            boolean r2 = kotlin.i.a(r5, r3, r2, r4)
            if (r2 != 0) goto L4b
            goto L0
        L4b:
            r2 = r3
            goto L6
        L4d:
            java.lang.Object r2 = r2._prev
            kotlinx.coroutines.internal.LockFreeLinkedListNode r2 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r2
            goto L7
        L52:
            r3 = r4
            kotlinx.coroutines.internal.LockFreeLinkedListNode r3 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r3
            r6 = r3
            r3 = r2
            r2 = r6
            goto L7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.LockFreeLinkedListNode.y(kotlinx.coroutines.internal.w):kotlinx.coroutines.internal.LockFreeLinkedListNode");
    }

    private final LockFreeLinkedListNode z(LockFreeLinkedListNode current) {
        while (current.K()) {
            current = (LockFreeLinkedListNode) current._prev;
        }
        return current;
    }

    @NotNull
    public final Object B() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof w)) {
                return obj;
            }
            ((w) obj).c(this);
        }
    }

    @NotNull
    public final LockFreeLinkedListNode C() {
        return o.c(B());
    }

    @NotNull
    public final LockFreeLinkedListNode F() {
        LockFreeLinkedListNode lockFreeLinkedListNodeY = y(null);
        return lockFreeLinkedListNodeY == null ? z((LockFreeLinkedListNode) this._prev) : lockFreeLinkedListNodeY;
    }

    public final void I() {
        ((x) B()).ref.J();
    }

    @PublishedApi
    public final void J() {
        LockFreeLinkedListNode lockFreeLinkedListNode = this;
        while (true) {
            Object objB = lockFreeLinkedListNode.B();
            if (!(objB instanceof x)) {
                lockFreeLinkedListNode.y(null);
                return;
            }
            lockFreeLinkedListNode = ((x) objB).ref;
        }
    }

    public boolean K() {
        return B() instanceof x;
    }

    public boolean L() {
        return N() == null;
    }

    @Nullable
    public final LockFreeLinkedListNode M() {
        while (true) {
            LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) B();
            if (lockFreeLinkedListNode == this) {
                return null;
            }
            if (lockFreeLinkedListNode.L()) {
                return lockFreeLinkedListNode;
            }
            lockFreeLinkedListNode.I();
        }
    }

    @PublishedApi
    @Nullable
    public final LockFreeLinkedListNode N() {
        Object objB;
        LockFreeLinkedListNode lockFreeLinkedListNode;
        do {
            objB = B();
            if (objB instanceof x) {
                return ((x) objB).ref;
            }
            if (objB == this) {
                return (LockFreeLinkedListNode) objB;
            }
            lockFreeLinkedListNode = (LockFreeLinkedListNode) objB;
        } while (!kotlin.i.a(f3782e, this, objB, lockFreeLinkedListNode.O()));
        lockFreeLinkedListNode.y(null);
        return null;
    }

    @PublishedApi
    public final int P(@NotNull LockFreeLinkedListNode node, @NotNull LockFreeLinkedListNode next, @NotNull b condAdd) {
        f3783f.lazySet(node, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3782e;
        atomicReferenceFieldUpdater.lazySet(node, next);
        condAdd.oldNext = next;
        if (kotlin.i.a(atomicReferenceFieldUpdater, this, next, condAdd)) {
            return condAdd.c(this) == null ? 1 : 2;
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return new PropertyReference0Impl(this) { // from class: kotlinx.coroutines.internal.LockFreeLinkedListNode.toString.1
            @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.jvm.internal.PropertyReference0
            @Nullable
            public Object get() {
                return kotlinx.coroutines.i0.a(this.receiver);
            }
        } + '@' + kotlinx.coroutines.i0.b(this);
    }

    public final void v(@NotNull LockFreeLinkedListNode node) {
        while (!F().w(node, this)) {
        }
    }

    @PublishedApi
    public final boolean w(@NotNull LockFreeLinkedListNode node, @NotNull LockFreeLinkedListNode next) {
        f3783f.lazySet(node, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3782e;
        atomicReferenceFieldUpdater.lazySet(node, next);
        if (!kotlin.i.a(atomicReferenceFieldUpdater, this, next, node)) {
            return false;
        }
        node.A(next);
        return true;
    }

    public final boolean x(@NotNull LockFreeLinkedListNode node) {
        f3783f.lazySet(node, this);
        f3782e.lazySet(node, this);
        while (B() == this) {
            if (kotlin.i.a(f3782e, this, this, node)) {
                node.A(this);
                return true;
            }
        }
        return false;
    }
}
