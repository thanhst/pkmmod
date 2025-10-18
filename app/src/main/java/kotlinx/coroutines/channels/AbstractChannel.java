package kotlinx.coroutines.channels;

import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.JvmField;
import kotlin.t;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.internal.d0;
import kotlinx.coroutines.k;
import kotlinx.coroutines.q0;
import p0.l_p0;
import p0.p_p0;
import u0.a_u0;
import u0.b_u0;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AbstractChannel.kt */
@Metadata(bv = {}, d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0007)QRSTUVB)\u0012 \u0010N\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0013\u0018\u00010Lj\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`M¢\u0006\u0004\bO\u0010PJ!\u0010\u0007\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\f\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0002JT\u0010\u0014\u001a\u00020\u0013\"\u0004\b\u0001\u0010\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\r2\u0006\u0010\u0006\u001a\u00020\u00052$\u0010\u0012\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015JZ\u0010\u0017\u001a\u00020\u0013\"\u0004\b\u0001\u0010\u0004* \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\r2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0010H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018JT\u0010\u0019\u001a\u00020\u000b\"\u0004\b\u0001\u0010\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\r2$\u0010\u0012\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ \u0010\u001d\u001a\u00020\u00132\n\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u001b2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0002J\n\u0010\u001e\u001a\u0004\u0018\u00010\u0010H\u0014J\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u00102\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\rH\u0014J\u0016\u0010 \u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0014J\"\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000!H\u0086@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\"\u0010#J\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000!ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b$\u0010%J\u0016\u0010)\u001a\u00020\u00132\u000e\u0010(\u001a\n\u0018\u00010&j\u0004\u0018\u0001`'J\u0019\u0010+\u001a\u00020\u000b2\b\u0010(\u001a\u0004\u0018\u00010*H\u0000¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0004\u001a\u00020\u00132\u0006\u0010-\u001a\u00020\u000bH\u0014J/\u00103\u001a\u00020\u00132\f\u00100\u001a\b\u0012\u0004\u0012\u00020/0.2\n\u00102\u001a\u0006\u0012\u0002\b\u000301H\u0014ø\u0001\u0000ø\u0001\u0002¢\u0006\u0004\b3\u00104J\u000f\u00106\u001a\b\u0012\u0004\u0012\u00028\u000005H\u0086\u0002J\u000e\u00108\u001a\b\u0012\u0004\u0012\u00028\u000007H\u0004J\u0010\u0010:\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u000109H\u0014J\b\u0010;\u001a\u00020\u0013H\u0014J\b\u0010<\u001a\u00020\u0013H\u0014R\u0014\u0010?\u001a\u00020\u000b8$X¤\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0014\u0010A\u001a\u00020\u000b8$X¤\u0004¢\u0006\u0006\u001a\u0004\b@\u0010>R\u0014\u0010C\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bB\u0010>R\u0014\u0010E\u001a\u00020\u000b8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bD\u0010>R\u0017\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000F8F¢\u0006\u0006\u001a\u0004\bG\u0010HR \u0010K\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000!0F8Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\bJ\u0010H\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006W"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel;", "E", "Lkotlinx/coroutines/channels/b;", "Lkotlinx/coroutines/channels/e;", "R", "", "receiveMode", "X", "(ILkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/o;", "receive", "", "K", "Lkotlinx/coroutines/selects/f;", "select", "Lkotlin/Function2;", "", "Lkotlin/coroutines/c;", "block", "Lkotlin/t;", "Y", "(Lkotlinx/coroutines/selects/f;ILp0/p;)V", "value", "a0", "(Lp0/p;Lkotlinx/coroutines/selects/f;ILjava/lang/Object;)V", "M", "(Lkotlinx/coroutines/selects/f;Lp0/p;I)Z", "Lkotlinx/coroutines/k;", "cont", "Z", "V", "W", "L", "Lkotlinx/coroutines/channels/h;", "z", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "v", "()Ljava/lang/Object;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cause", "a", "", "I", "(Ljava/lang/Throwable;)Z", "wasClosed", "Lkotlinx/coroutines/internal/k;", "Lkotlinx/coroutines/channels/r;", "list", "Lkotlinx/coroutines/channels/j;", "closed", "S", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/j;)V", "Lkotlinx/coroutines/channels/ChannelIterator;", "iterator", "Lkotlinx/coroutines/channels/AbstractChannel$g;", "J", "Lkotlinx/coroutines/channels/p;", "D", "U", "T", "N", "()Z", "isBufferAlwaysEmpty", "O", "isBufferEmpty", "P", "isClosedForReceive", "Q", "isEmptyImpl", "Lkotlinx/coroutines/selects/d;", "n", "()Lkotlinx/coroutines/selects/d;", "onReceive", "q", "onReceiveCatching", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(Lp0/l;)V", "b", "c", "d", "e", "f", "g", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public abstract class AbstractChannel<E> extends kotlinx.coroutines.channels.b<E> implements kotlinx.coroutines.channels.e<E> {

    /* compiled from: AbstractChannel.kt */
    @Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B\u0015\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\f¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0013\u0010\u0007\u001a\u00020\u0005H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\t\u001a\u00020\u0005H\u0096Bø\u0001\u0000¢\u0006\u0004\b\t\u0010\bJ\u0010\u0010\n\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\t\u0010\rR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0011\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$a;", "E", "Lkotlinx/coroutines/channels/ChannelIterator;", "", "result", "", "c", "d", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "a", "next", "()Ljava/lang/Object;", "Lkotlinx/coroutines/channels/AbstractChannel;", "Lkotlinx/coroutines/channels/AbstractChannel;", "channel", "b", "Ljava/lang/Object;", "e", "(Ljava/lang/Object;)V", "<init>", "(Lkotlinx/coroutines/channels/AbstractChannel;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private static final class a<E> implements ChannelIterator<E> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public final AbstractChannel<E> channel;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Object result = kotlinx.coroutines.channels.a.f3578d;

        public a(@NotNull AbstractChannel<E> abstractChannel) {
            this.channel = abstractChannel;
        }

        private final boolean c(Object result) throws Throwable {
            if (!(result instanceof kotlinx.coroutines.channels.j)) {
                return true;
            }
            kotlinx.coroutines.channels.j jVar = (kotlinx.coroutines.channels.j) result;
            if (jVar.closeCause == null) {
                return false;
            }
            throw c0.a(jVar.X());
        }

        private final Object d(kotlin.coroutines.c<? super Boolean> cVar) {
            kotlinx.coroutines.l lVarB = kotlinx.coroutines.n.b(IntrinsicsKt__IntrinsicsJvmKt.c(cVar));
            d dVar = new d(this, lVarB);
            while (true) {
                if (this.channel.K(dVar)) {
                    this.channel.Z(lVarB, dVar);
                    break;
                }
                Object objV = this.channel.V();
                e(objV);
                if (objV instanceof kotlinx.coroutines.channels.j) {
                    kotlinx.coroutines.channels.j jVar = (kotlinx.coroutines.channels.j) objV;
                    if (jVar.closeCause == null) {
                        Result.Companion companion = Result.INSTANCE;
                        lVarB.resumeWith(Result.m158constructorimpl(kotlin.coroutines.jvm.internal.a.a(false)));
                    } else {
                        Result.Companion companion2 = Result.INSTANCE;
                        lVarB.resumeWith(Result.m158constructorimpl(kotlin.h.a(jVar.X())));
                    }
                } else if (objV != kotlinx.coroutines.channels.a.f3578d) {
                    Boolean boolA = kotlin.coroutines.jvm.internal.a.a(true);
                    l_p0<E, t> lP0Var = this.channel.onUndeliveredElement;
                    lVarB.H(boolA, lP0Var == null ? null : OnUndeliveredElementKt.a(lP0Var, objV, lVarB.getContext()));
                }
            }
            Object objT = lVarB.t();
            if (objT == kotlin.coroutines.intrinsics.b.d()) {
                kotlin.coroutines.jvm.internal.e.c(cVar);
            }
            return objT;
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        @Nullable
        public Object a(@NotNull kotlin.coroutines.c<? super Boolean> cVar) {
            Object result = getResult();
            d0 d0Var = kotlinx.coroutines.channels.a.f3578d;
            if (result != d0Var) {
                return kotlin.coroutines.jvm.internal.a.a(c(getResult()));
            }
            e(this.channel.V());
            return getResult() != d0Var ? kotlin.coroutines.jvm.internal.a.a(c(getResult())) : d(cVar);
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final Object getResult() {
            return this.result;
        }

        public final void e(@Nullable Object obj) {
            this.result = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.coroutines.channels.ChannelIterator
        public E next() throws Throwable {
            E e2 = (E) this.result;
            if (e2 instanceof kotlinx.coroutines.channels.j) {
                throw c0.a(((kotlinx.coroutines.channels.j) e2).X());
            }
            d0 d0Var = kotlinx.coroutines.channels.a.f3578d;
            if (e2 == d0Var) {
                throw new IllegalStateException("'hasNext' should be called prior to 'next' invocation");
            }
            this.result = d0Var;
            return e2;
        }
    }

    /* compiled from: AbstractChannel.kt */
    @Metadata(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0012\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00010\u0002B\u001f\u0012\u000e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0014\u0012\u0006\u0010\u001b\u001a\u00020\u0018¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00028\u00012\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0014\u0010\u0011\u001a\u00020\f2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016R\u001c\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00148\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$b;", "E", "Lkotlinx/coroutines/channels/o;", "value", "", "T", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$c;", "otherOp", "Lkotlinx/coroutines/internal/d0;", "n", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$c;)Lkotlinx/coroutines/internal/d0;", "Lkotlin/t;", "f", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/channels/j;", "closed", "S", "", "toString", "Lkotlinx/coroutines/k;", "h", "Lkotlinx/coroutines/k;", "cont", "", "i", "I", "receiveMode", "<init>", "(Lkotlinx/coroutines/k;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private static class b<E> extends o<E> {

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public final kotlinx.coroutines.k<Object> cont;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @JvmField
        public final int receiveMode;

        public b(@NotNull kotlinx.coroutines.k<Object> kVar, int i2) {
            this.cont = kVar;
            this.receiveMode = i2;
        }

        @Override // kotlinx.coroutines.channels.o
        public void S(@NotNull kotlinx.coroutines.channels.j<?> jVar) {
            if (this.receiveMode == 1) {
                kotlinx.coroutines.k<Object> kVar = this.cont;
                Result.Companion companion = Result.INSTANCE;
                kVar.resumeWith(Result.m158constructorimpl(kotlinx.coroutines.channels.h.b(kotlinx.coroutines.channels.h.INSTANCE.a(jVar.closeCause))));
            } else {
                kotlinx.coroutines.k<Object> kVar2 = this.cont;
                Result.Companion companion2 = Result.INSTANCE;
                kVar2.resumeWith(Result.m158constructorimpl(kotlin.h.a(jVar.X())));
            }
        }

        @Nullable
        public final Object T(E value) {
            return this.receiveMode == 1 ? kotlinx.coroutines.channels.h.b(kotlinx.coroutines.channels.h.INSTANCE.c(value)) : value;
        }

        @Override // kotlinx.coroutines.channels.p
        public void f(E value) {
            this.cont.G(kotlinx.coroutines.m.f3863a);
        }

        @Override // kotlinx.coroutines.channels.p
        @Nullable
        public d0 n(E value, @Nullable LockFreeLinkedListNode.PrepareOp otherOp) {
            if (this.cont.D(T(value), otherOp == null ? null : otherOp.desc, R(value)) == null) {
                return null;
            }
            if (otherOp != null) {
                otherOp.d();
            }
            return kotlinx.coroutines.m.f3863a;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        @NotNull
        public String toString() {
            return "ReceiveElement@" + i0.b(this) + "[receiveMode=" + this.receiveMode + ']';
        }
    }

    /* compiled from: AbstractChannel.kt */
    @Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00010\u0002B=\u0012\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00060\u0004j\b\u0012\u0004\u0012\u00028\u0001`\t¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0007\u0010\bR*\u0010\f\u001a\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00060\u0004j\b\u0012\u0004\u0012\u00028\u0001`\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$c;", "E", "Lkotlinx/coroutines/channels/AbstractChannel$b;", "value", "Lkotlin/Function1;", "", "Lkotlin/t;", "R", "(Ljava/lang/Object;)Lp0/l;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "j", "Lp0/l;", "onUndeliveredElement", "Lkotlinx/coroutines/k;", "", "cont", "", "receiveMode", "<init>", "(Lkotlinx/coroutines/k;ILp0/l;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private static final class c<E> extends b<E> {

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public final l_p0<E, t> onUndeliveredElement;

        /* JADX WARN: Multi-variable type inference failed */
        public c(@NotNull kotlinx.coroutines.k<Object> kVar, int i2, @NotNull l_p0<? super E, t> lP0Var) {
            super(kVar, i2);
            this.onUndeliveredElement = lP0Var;
        }

        @Override // kotlinx.coroutines.channels.o
        @Nullable
        public l_p0<Throwable, t> R(E value) {
            return OnUndeliveredElementKt.a(this.onUndeliveredElement, value, this.cont.getContext());
        }
    }

    /* compiled from: AbstractChannel.kt */
    @Metadata(bv = {}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0012\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B#\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u0015\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\u0004\b\u001e\u0010\u001fJ#\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00028\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\u000e\u001a\u00020\t2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\fH\u0016J%\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\t\u0018\u00010\u000f2\u0006\u0010\u0003\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0014\u001a\u00020\u0013H\u0016R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u00158\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$d;", "E", "Lkotlinx/coroutines/channels/o;", "value", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$c;", "otherOp", "Lkotlinx/coroutines/internal/d0;", "n", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$c;)Lkotlinx/coroutines/internal/d0;", "Lkotlin/t;", "f", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/channels/j;", "closed", "S", "Lkotlin/Function1;", "", "R", "(Ljava/lang/Object;)Lp0/l;", "", "toString", "Lkotlinx/coroutines/channels/AbstractChannel$a;", "h", "Lkotlinx/coroutines/channels/AbstractChannel$a;", "iterator", "Lkotlinx/coroutines/k;", "", "i", "Lkotlinx/coroutines/k;", "cont", "<init>", "(Lkotlinx/coroutines/channels/AbstractChannel$a;Lkotlinx/coroutines/k;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private static class d<E> extends o<E> {

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public final a<E> iterator;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public final kotlinx.coroutines.k<Boolean> cont;

        /* JADX WARN: Multi-variable type inference failed */
        public d(@NotNull a<E> aVar, @NotNull kotlinx.coroutines.k<? super Boolean> kVar) {
            this.iterator = aVar;
            this.cont = kVar;
        }

        @Override // kotlinx.coroutines.channels.o
        @Nullable
        public l_p0<Throwable, t> R(E value) {
            l_p0<E, t> lP0Var = this.iterator.channel.onUndeliveredElement;
            if (lP0Var == null) {
                return null;
            }
            return OnUndeliveredElementKt.a(lP0Var, value, this.cont.getContext());
        }

        @Override // kotlinx.coroutines.channels.o
        public void S(@NotNull kotlinx.coroutines.channels.j<?> jVar) {
            Object objA = jVar.closeCause == null ? k.a.a(this.cont, Boolean.FALSE, null, 2, null) : this.cont.E(jVar.X());
            if (objA != null) {
                this.iterator.e(jVar);
                this.cont.G(objA);
            }
        }

        @Override // kotlinx.coroutines.channels.p
        public void f(E value) {
            this.iterator.e(value);
            this.cont.G(kotlinx.coroutines.m.f3863a);
        }

        @Override // kotlinx.coroutines.channels.p
        @Nullable
        public d0 n(E value, @Nullable LockFreeLinkedListNode.PrepareOp otherOp) {
            if (this.cont.D(Boolean.TRUE, otherOp == null ? null : otherOp.desc, R(value)) == null) {
                return null;
            }
            if (otherOp != null) {
                otherOp.d();
            }
            return kotlinx.coroutines.m.f3863a;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        @NotNull
        public String toString() {
            return kotlin.jvm.internal.s.m("ReceiveHasNext@", i0.b(this));
        }
    }

    /* compiled from: AbstractChannel.kt */
    @Metadata(bv = {}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u0001*\u0004\b\u0002\u0010\u00022\b\u0012\u0004\u0012\u00028\u00020\u00032\u00020\u0004BT\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00020\u0017\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00010\u001b\u0012$\u0010$\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010 \u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010!\u0012\u0006\u0012\u0004\u0018\u00010 0\u001f\u0012\u0006\u0010(\u001a\u00020%ø\u0001\u0000¢\u0006\u0004\b)\u0010*J#\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00028\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00028\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u0010\u001a\u00020\u000b2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J%\u0010\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00122\u0006\u0010\u0005\u001a\u00028\u0002H\u0016¢\u0006\u0004\b\u0001\u0010\u0014J\b\u0010\u0016\u001a\u00020\u0015H\u0016R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00020\u00178\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00010\u001b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR5\u0010$\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010 \u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010!\u0012\u0006\u0012\u0004\u0018\u00010 0\u001f8\u0006X\u0087\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b&\u0010'\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006+"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$e;", "R", "E", "Lkotlinx/coroutines/channels/o;", "Lkotlinx/coroutines/q0;", "value", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$c;", "otherOp", "Lkotlinx/coroutines/internal/d0;", "n", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$c;)Lkotlinx/coroutines/internal/d0;", "Lkotlin/t;", "f", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/channels/j;", "closed", "S", "a", "Lkotlin/Function1;", "", "(Ljava/lang/Object;)Lp0/l;", "", "toString", "Lkotlinx/coroutines/channels/AbstractChannel;", "h", "Lkotlinx/coroutines/channels/AbstractChannel;", "channel", "Lkotlinx/coroutines/selects/f;", "i", "Lkotlinx/coroutines/selects/f;", "select", "Lkotlin/Function2;", "", "Lkotlin/coroutines/c;", "j", "Lp0/p;", "block", "", "k", "I", "receiveMode", "<init>", "(Lkotlinx/coroutines/channels/AbstractChannel;Lkotlinx/coroutines/selects/f;Lp0/p;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private static final class e<R, E> extends o<E> implements q0 {

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public final AbstractChannel<E> channel;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public final kotlinx.coroutines.selects.f<R> select;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public final p_p0<Object, kotlin.coroutines.c<? super R>, Object> block;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        @JvmField
        public final int receiveMode;

        /* JADX WARN: Multi-variable type inference failed */
        public e(@NotNull AbstractChannel<E> abstractChannel, @NotNull kotlinx.coroutines.selects.f<? super R> fVar, @NotNull p_p0<Object, ? super kotlin.coroutines.c<? super R>, ? extends Object> pP0Var, int i2) {
            this.channel = abstractChannel;
            this.select = fVar;
            this.block = pP0Var;
            this.receiveMode = i2;
        }

        @Override // kotlinx.coroutines.channels.o
        @Nullable
        public l_p0<Throwable, t> R(E value) {
            l_p0<E, t> lP0Var = this.channel.onUndeliveredElement;
            if (lP0Var == null) {
                return null;
            }
            return OnUndeliveredElementKt.a(lP0Var, value, this.select.b().getContext());
        }

        @Override // kotlinx.coroutines.channels.o
        public void S(@NotNull kotlinx.coroutines.channels.j<?> jVar) throws Throwable {
            if (this.select.l()) {
                int i2 = this.receiveMode;
                if (i2 == 0) {
                    this.select.g(jVar.X());
                } else {
                    if (i2 != 1) {
                        return;
                    }
                    a_u0.e(this.block, kotlinx.coroutines.channels.h.b(kotlinx.coroutines.channels.h.INSTANCE.a(jVar.closeCause)), this.select.b(), null, 4, null);
                }
            }
        }

        @Override // kotlinx.coroutines.q0
        public void a() {
            if (L()) {
                this.channel.T();
            }
        }

        @Override // kotlinx.coroutines.channels.p
        public void f(E value) throws Throwable {
            a_u0.d(this.block, this.receiveMode == 1 ? kotlinx.coroutines.channels.h.b(kotlinx.coroutines.channels.h.INSTANCE.c(value)) : value, this.select.b(), R(value));
        }

        @Override // kotlinx.coroutines.channels.p
        @Nullable
        public d0 n(E value, @Nullable LockFreeLinkedListNode.PrepareOp otherOp) {
            return (d0) this.select.j(otherOp);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        @NotNull
        public String toString() {
            return "ReceiveSelect@" + i0.b(this) + '[' + this.select + ",receiveMode=" + this.receiveMode + ']';
        }
    }

    /* compiled from: AbstractChannel.kt */
    @Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\b¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0018\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$f;", "Lkotlinx/coroutines/e;", "", "cause", "Lkotlin/t;", "a", "", "toString", "Lkotlinx/coroutines/channels/o;", "e", "Lkotlinx/coroutines/channels/o;", "receive", "<init>", "(Lkotlinx/coroutines/channels/AbstractChannel;Lkotlinx/coroutines/channels/o;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private final class f extends kotlinx.coroutines.e {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final o<?> receive;

        public f(@NotNull o<?> oVar) {
            this.receive = oVar;
        }

        @Override // kotlinx.coroutines.j
        public void a(@Nullable Throwable th) {
            if (this.receive.L()) {
                AbstractChannel.this.T();
            }
        }

        @Override // p0.l
        public /* bridge */ /* synthetic */ kotlin.t invoke(Throwable th) {
            a(th);
            return kotlin.t.f3507a;
        }

        @NotNull
        public String toString() {
            return "RemoveReceiveOnCancel[" + this.receive + ']';
        }
    }

    /* compiled from: AbstractChannel.kt */
    @Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u0000*\u0004\b\u0001\u0010\u00012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J\u0016\u0010\f\u001a\u0004\u0018\u00010\u00072\n\u0010\u000b\u001a\u00060\tj\u0002`\nH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$g;", "E", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$d;", "Lkotlinx/coroutines/channels/r;", "Lkotlinx/coroutines/internal/RemoveFirstDesc;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "affected", "", "e", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$c;", "Lkotlinx/coroutines/internal/PrepareOp;", "prepareOp", "j", "Lkotlin/t;", "k", "Lkotlinx/coroutines/internal/n;", "queue", "<init>", "(Lkotlinx/coroutines/internal/n;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    protected static final class g<E> extends LockFreeLinkedListNode.d<r> {
        public g(@NotNull kotlinx.coroutines.internal.n nVar) {
            super(nVar);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.d, kotlinx.coroutines.internal.LockFreeLinkedListNode.a
        @Nullable
        protected Object e(@NotNull LockFreeLinkedListNode affected) {
            if (affected instanceof kotlinx.coroutines.channels.j) {
                return affected;
            }
            if (affected instanceof r) {
                return null;
            }
            return kotlinx.coroutines.channels.a.f3578d;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.a
        @Nullable
        public Object j(@NotNull LockFreeLinkedListNode.PrepareOp prepareOp) {
            d0 d0VarT = ((r) prepareOp.affected).T(prepareOp);
            if (d0VarT == null) {
                return kotlinx.coroutines.internal.p.f3834a;
            }
            Object obj = kotlinx.coroutines.internal.c.f3804b;
            if (d0VarT == obj) {
                return obj;
            }
            return null;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.a
        public void k(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
            ((r) lockFreeLinkedListNode).U();
        }
    }

    /* compiled from: LockFreeLinkedList.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/channels/AbstractChannel$h", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$b;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "affected", "", "k", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static final class h extends LockFreeLinkedListNode.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LockFreeLinkedListNode f3570d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AbstractChannel f3571e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(LockFreeLinkedListNode lockFreeLinkedListNode, AbstractChannel abstractChannel) {
            super(lockFreeLinkedListNode);
            this.f3570d = lockFreeLinkedListNode;
            this.f3571e = abstractChannel;
        }

        @Override // kotlinx.coroutines.internal.d
        @Nullable
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public Object i(@NotNull LockFreeLinkedListNode affected) {
            if (this.f3571e.O()) {
                return null;
            }
            return kotlinx.coroutines.internal.o.a();
        }
    }

    /* compiled from: AbstractChannel.kt */
    @Metadata(bv = {}, d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001JJ\u0010\n\u001a\u00020\t\"\u0004\b\u0001\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H\u0016ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"kotlinx/coroutines/channels/AbstractChannel$i", "Lkotlinx/coroutines/selects/d;", "R", "Lkotlinx/coroutines/selects/f;", "select", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "block", "Lkotlin/t;", "a", "(Lkotlinx/coroutines/selects/f;Lp0/p;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static final class i implements kotlinx.coroutines.selects.d<E> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AbstractChannel<E> f3572a;

        i(AbstractChannel<E> abstractChannel) {
            this.f3572a = abstractChannel;
        }

        @Override // kotlinx.coroutines.selects.d
        public <R> void a(@NotNull kotlinx.coroutines.selects.f<? super R> select, @NotNull p_p0<? super E, ? super kotlin.coroutines.c<? super R>, ? extends Object> block) throws Throwable {
            this.f3572a.Y(select, 0, block);
        }
    }

    /* compiled from: AbstractChannel.kt */
    @Metadata(bv = {}, d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001JS\u0010\u000b\u001a\u00020\n\"\u0004\b\u0001\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042(\u0010\t\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006H\u0016ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"kotlinx/coroutines/channels/AbstractChannel$j", "Lkotlinx/coroutines/selects/d;", "Lkotlinx/coroutines/channels/h;", "R", "Lkotlinx/coroutines/selects/f;", "select", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "block", "Lkotlin/t;", "a", "(Lkotlinx/coroutines/selects/f;Lp0/p;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static final class j implements kotlinx.coroutines.selects.d<kotlinx.coroutines.channels.h<? extends E>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AbstractChannel<E> f3573a;

        j(AbstractChannel<E> abstractChannel) {
            this.f3573a = abstractChannel;
        }

        @Override // kotlinx.coroutines.selects.d
        public <R> void a(@NotNull kotlinx.coroutines.selects.f<? super R> select, @NotNull p_p0<? super kotlinx.coroutines.channels.h<? extends E>, ? super kotlin.coroutines.c<? super R>, ? extends Object> block) throws Throwable {
            this.f3573a.Y(select, 1, block);
        }
    }

    public AbstractChannel(@Nullable l_p0<? super E, t> lP0Var) {
        super(lP0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean K(o<? super E> receive) {
        boolean zL = L(receive);
        if (zL) {
            U();
        }
        return zL;
    }

    private final <R> boolean M(kotlinx.coroutines.selects.f<? super R> select, p_p0<Object, ? super kotlin.coroutines.c<? super R>, ? extends Object> block, int receiveMode) {
        e eVar = new e(this, select, block, receiveMode);
        boolean zK = K(eVar);
        if (zK) {
            select.o(eVar);
        }
        return zK;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <R> Object X(int i2, kotlin.coroutines.c<? super R> cVar) {
        kotlinx.coroutines.l lVarB = kotlinx.coroutines.n.b(IntrinsicsKt__IntrinsicsJvmKt.c(cVar));
        b bVar = this.onUndeliveredElement == null ? new b(lVarB, i2) : new c(lVarB, i2, this.onUndeliveredElement);
        while (true) {
            if (K(bVar)) {
                Z(lVarB, bVar);
                break;
            }
            Object objV = V();
            if (objV instanceof kotlinx.coroutines.channels.j) {
                bVar.S((kotlinx.coroutines.channels.j) objV);
                break;
            }
            if (objV != kotlinx.coroutines.channels.a.f3578d) {
                lVarB.H(bVar.T(objV), bVar.R(objV));
                break;
            }
        }
        Object objT = lVarB.t();
        if (objT == kotlin.coroutines.intrinsics.b.d()) {
            kotlin.coroutines.jvm.internal.e.c(cVar);
        }
        return objT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <R> void Y(kotlinx.coroutines.selects.f<? super R> select, int receiveMode, p_p0<Object, ? super kotlin.coroutines.c<? super R>, ? extends Object> block) throws Throwable {
        while (!select.q()) {
            if (!Q()) {
                Object objW = W(select);
                if (objW == kotlinx.coroutines.selects.g.d()) {
                    return;
                }
                if (objW != kotlinx.coroutines.channels.a.f3578d && objW != kotlinx.coroutines.internal.c.f3804b) {
                    a0(block, select, receiveMode, objW);
                }
            } else if (M(select, block, receiveMode)) {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z(kotlinx.coroutines.k<?> kVar, o<?> oVar) {
        kVar.s(new f(oVar));
    }

    private final <R> void a0(p_p0<Object, ? super kotlin.coroutines.c<? super R>, ? extends Object> pP0Var, kotlinx.coroutines.selects.f<? super R> fVar, int i2, Object obj) throws Throwable {
        boolean z2 = obj instanceof kotlinx.coroutines.channels.j;
        if (!z2) {
            if (i2 != 1) {
                b_u0.d(pP0Var, obj, fVar.b());
                return;
            } else {
                h.Companion companion = kotlinx.coroutines.channels.h.INSTANCE;
                b_u0.d(pP0Var, kotlinx.coroutines.channels.h.b(z2 ? companion.a(((kotlinx.coroutines.channels.j) obj).closeCause) : companion.c(obj)), fVar.b());
                return;
            }
        }
        if (i2 == 0) {
            throw c0.a(((kotlinx.coroutines.channels.j) obj).X());
        }
        if (i2 == 1 && fVar.l()) {
            b_u0.d(pP0Var, kotlinx.coroutines.channels.h.b(kotlinx.coroutines.channels.h.INSTANCE.a(((kotlinx.coroutines.channels.j) obj).closeCause)), fVar.b());
        }
    }

    @Override // kotlinx.coroutines.channels.b
    @Nullable
    protected p<E> D() {
        p<E> pVarD = super.D();
        if (pVarD != null && !(pVarD instanceof kotlinx.coroutines.channels.j)) {
            T();
        }
        return pVarD;
    }

    public final boolean I(@Nullable Throwable cause) {
        boolean zG = g(cause);
        R(zG);
        return zG;
    }

    @NotNull
    protected final g<E> J() {
        return new g<>(getQueue());
    }

    protected boolean L(@NotNull o<? super E> receive) {
        int iP;
        LockFreeLinkedListNode lockFreeLinkedListNodeF;
        if (!N()) {
            LockFreeLinkedListNode queue = getQueue();
            h hVar = new h(receive, this);
            do {
                LockFreeLinkedListNode lockFreeLinkedListNodeF2 = queue.F();
                if (!(!(lockFreeLinkedListNodeF2 instanceof r))) {
                    return false;
                }
                iP = lockFreeLinkedListNodeF2.P(receive, queue, hVar);
                if (iP != 1) {
                }
            } while (iP != 2);
            return false;
        }
        LockFreeLinkedListNode queue2 = getQueue();
        do {
            lockFreeLinkedListNodeF = queue2.F();
            if (!(!(lockFreeLinkedListNodeF instanceof r))) {
                return false;
            }
        } while (!lockFreeLinkedListNodeF.w(receive, queue2));
        return true;
    }

    protected abstract boolean N();

    protected abstract boolean O();

    public boolean P() {
        return h() != null && O();
    }

    protected final boolean Q() {
        return !(getQueue().C() instanceof r) && O();
    }

    protected void R(boolean z2) {
        kotlinx.coroutines.channels.j<?> jVarI = i();
        if (jVarI == null) {
            throw new IllegalStateException("Cannot happen".toString());
        }
        Object objB = kotlinx.coroutines.internal.k.b(null, 1, null);
        while (true) {
            LockFreeLinkedListNode lockFreeLinkedListNodeF = jVarI.F();
            if (lockFreeLinkedListNodeF instanceof kotlinx.coroutines.internal.n) {
                S(objB, jVarI);
                return;
            } else if (lockFreeLinkedListNodeF.L()) {
                objB = kotlinx.coroutines.internal.k.c(objB, (r) lockFreeLinkedListNodeF);
            } else {
                lockFreeLinkedListNodeF.I();
            }
        }
    }

    protected void S(@NotNull Object list, @NotNull kotlinx.coroutines.channels.j<?> closed) {
        if (list == null) {
            return;
        }
        if (!(list instanceof ArrayList)) {
            ((r) list).S(closed);
            return;
        }
        ArrayList arrayList = (ArrayList) list;
        int size = arrayList.size() - 1;
        if (size < 0) {
            return;
        }
        while (true) {
            int i2 = size - 1;
            ((r) arrayList.get(size)).S(closed);
            if (i2 < 0) {
                return;
            } else {
                size = i2;
            }
        }
    }

    protected void T() {
    }

    protected void U() {
    }

    @Nullable
    protected Object V() {
        while (true) {
            r rVarE = E();
            if (rVarE == null) {
                return kotlinx.coroutines.channels.a.f3578d;
            }
            if (rVarE.T(null) != null) {
                rVarE.Q();
                return rVarE.getElement();
            }
            rVarE.U();
        }
    }

    @Nullable
    protected Object W(@NotNull kotlinx.coroutines.selects.f<?> select) {
        g<E> gVarJ = J();
        Object objH = select.h(gVarJ);
        if (objH != null) {
            return objH;
        }
        gVarJ.o().Q();
        return gVarJ.o().getElement();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final void a(@Nullable CancellationException cancellationException) {
        if (P()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new CancellationException(kotlin.jvm.internal.s.m(i0.a(this), " was cancelled"));
        }
        I(cancellationException);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public final ChannelIterator<E> iterator() {
        return new a(this);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public final kotlinx.coroutines.selects.d<E> n() {
        return new i(this);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public final kotlinx.coroutines.selects.d<kotlinx.coroutines.channels.h<E>> q() {
        return new j(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public final Object v() {
        Object objV = V();
        return objV == kotlinx.coroutines.channels.a.f3578d ? kotlinx.coroutines.channels.h.INSTANCE.b() : objV instanceof kotlinx.coroutines.channels.j ? kotlinx.coroutines.channels.h.INSTANCE.a(((kotlinx.coroutines.channels.j) objV).closeCause) : kotlinx.coroutines.channels.h.INSTANCE.c(objV);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object z(@org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super kotlinx.coroutines.channels.h<? extends E>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1 r0 = (kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1 r0 = new kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.h.b(r5)
            goto L5b
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            kotlin.h.b(r5)
            java.lang.Object r5 = r4.V()
            kotlinx.coroutines.internal.d0 r2 = kotlinx.coroutines.channels.a.f3578d
            if (r5 == r2) goto L52
            boolean r0 = r5 instanceof kotlinx.coroutines.channels.j
            if (r0 == 0) goto L4b
            kotlinx.coroutines.channels.h$b r0 = kotlinx.coroutines.channels.h.INSTANCE
            kotlinx.coroutines.channels.j r5 = (kotlinx.coroutines.channels.j) r5
            java.lang.Throwable r5 = r5.closeCause
            java.lang.Object r5 = r0.a(r5)
            goto L51
        L4b:
            kotlinx.coroutines.channels.h$b r0 = kotlinx.coroutines.channels.h.INSTANCE
            java.lang.Object r5 = r0.c(r5)
        L51:
            return r5
        L52:
            r0.label = r3
            java.lang.Object r5 = r4.X(r3, r0)
            if (r5 != r1) goto L5b
            return r1
        L5b:
            kotlinx.coroutines.channels.h r5 = (kotlinx.coroutines.channels.h) r5
            java.lang.Object r5 = r5.getHolder()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.AbstractChannel.z(kotlin.coroutines.c):java.lang.Object");
    }
}
