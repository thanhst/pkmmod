package kotlinx.coroutines.channels;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.t;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.internal.d0;
import p0.l_p0;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ArrayChannel.kt */
@Metadata(bv = {}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B9\u0012\u0006\u0010%\u001a\u00020\u0003\u0012\u0006\u0010)\u001a\u00020&\u0012 \u0010F\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t\u0018\u00010Dj\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`E¢\u0006\u0004\bG\u0010HJ\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u0011\u0010\u0015\u001a\u0004\u0018\u00010\u000eH\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u000e2\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u0017H\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001e\u001a\u00020\u001d2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u001dH\u0014¢\u0006\u0004\b!\u0010\"R\u0014\u0010%\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010.\u001a\u00060*j\u0002`+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u001e\u00102\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u0010$R\u0014\u00107\u001a\u00020\u001d8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b5\u00106R\u0014\u00109\u001a\u00020\u001d8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b8\u00106R\u0014\u0010;\u001a\u00020\u001d8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b:\u00106R\u0014\u0010=\u001a\u00020\u001d8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b<\u00106R\u0014\u0010?\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b>\u00106R\u0014\u0010C\u001a\u00020@8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\bA\u0010B¨\u0006I"}, d2 = {"Lkotlinx/coroutines/channels/c;", "E", "Lkotlinx/coroutines/channels/AbstractChannel;", "", "currentSize", "Lkotlinx/coroutines/internal/d0;", "d0", "(I)Lkotlinx/coroutines/internal/d0;", "element", "Lkotlin/t;", "b0", "(ILjava/lang/Object;)V", "c0", "(I)V", "", "u", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/r;", "send", "e", "(Lkotlinx/coroutines/channels/r;)Ljava/lang/Object;", "V", "()Ljava/lang/Object;", "Lkotlinx/coroutines/selects/f;", "select", "W", "(Lkotlinx/coroutines/selects/f;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/o;", "receive", "", "L", "(Lkotlinx/coroutines/channels/o;)Z", "wasClosed", "R", "(Z)V", "h", "I", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "i", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "j", "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "", "k", "[Ljava/lang/Object;", "buffer", "l", "head", "N", "()Z", "isBufferAlwaysEmpty", "O", "isBufferEmpty", "r", "isBufferAlwaysFull", "s", "isBufferFull", "P", "isClosedForReceive", "", "f", "()Ljava/lang/String;", "bufferDebugString", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(ILkotlinx/coroutines/channels/BufferOverflow;Lp0/l;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public class c<E> extends AbstractChannel<E> {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int capacity;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final BufferOverflow onBufferOverflow;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ReentrantLock lock;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Object[] buffer;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private int head;

    @NotNull
    private volatile /* synthetic */ int size;

    /* compiled from: ArrayChannel.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3592a;

        static {
            int[] iArr = new int[BufferOverflow.values().length];
            iArr[BufferOverflow.SUSPEND.ordinal()] = 1;
            iArr[BufferOverflow.DROP_LATEST.ordinal()] = 2;
            iArr[BufferOverflow.DROP_OLDEST.ordinal()] = 3;
            f3592a = iArr;
        }
    }

    public c(int i2, @NotNull BufferOverflow bufferOverflow, @Nullable l_p0<? super E, t> lP0Var) {
        super(lP0Var);
        this.capacity = i2;
        this.onBufferOverflow = bufferOverflow;
        if (!(i2 >= 1)) {
            throw new IllegalArgumentException(("ArrayChannel capacity must be at least 1, but " + i2 + " was specified").toString());
        }
        this.lock = new ReentrantLock();
        Object[] objArr = new Object[Math.min(i2, 8)];
        kotlin.collections.m.h(objArr, kotlinx.coroutines.channels.a.f3575a, 0, 0, 6, null);
        this.buffer = objArr;
        this.size = 0;
    }

    private final void b0(int currentSize, E element) {
        if (currentSize < this.capacity) {
            c0(currentSize);
            Object[] objArr = this.buffer;
            objArr[(this.head + currentSize) % objArr.length] = element;
        } else {
            Object[] objArr2 = this.buffer;
            int i2 = this.head;
            objArr2[i2 % objArr2.length] = null;
            objArr2[(currentSize + i2) % objArr2.length] = element;
            this.head = (i2 + 1) % objArr2.length;
        }
    }

    private final void c0(int currentSize) {
        Object[] objArr = this.buffer;
        if (currentSize >= objArr.length) {
            int iMin = Math.min(objArr.length * 2, this.capacity);
            Object[] objArr2 = new Object[iMin];
            for (int i2 = 0; i2 < currentSize; i2++) {
                Object[] objArr3 = this.buffer;
                objArr2[i2] = objArr3[(this.head + i2) % objArr3.length];
            }
            kotlin.collections.m.g(objArr2, kotlinx.coroutines.channels.a.f3575a, currentSize, iMin);
            this.buffer = objArr2;
            this.head = 0;
        }
    }

    private final d0 d0(int currentSize) {
        if (currentSize < this.capacity) {
            this.size = currentSize + 1;
            return null;
        }
        int i2 = a.f3592a[this.onBufferOverflow.ordinal()];
        if (i2 == 1) {
            return kotlinx.coroutines.channels.a.f3577c;
        }
        if (i2 == 2) {
            return kotlinx.coroutines.channels.a.f3576b;
        }
        if (i2 == 3) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected boolean L(@NotNull o<? super E> receive) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return super.L(receive);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected final boolean N() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected final boolean O() {
        return this.size == 0;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    public boolean P() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return super.P();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected void R(boolean wasClosed) {
        l_p0<E, t> lP0Var = this.onUndeliveredElement;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int i2 = this.size;
            UndeliveredElementException undeliveredElementExceptionC = null;
            int i3 = 0;
            while (i3 < i2) {
                i3++;
                Object obj = this.buffer[this.head];
                if (lP0Var != null && obj != kotlinx.coroutines.channels.a.f3575a) {
                    undeliveredElementExceptionC = OnUndeliveredElementKt.c(lP0Var, obj, undeliveredElementExceptionC);
                }
                Object[] objArr = this.buffer;
                int i4 = this.head;
                objArr[i4] = kotlinx.coroutines.channels.a.f3575a;
                this.head = (i4 + 1) % objArr.length;
            }
            this.size = 0;
            kotlin.t tVar = kotlin.t.f3507a;
            reentrantLock.unlock();
            super.R(wasClosed);
            if (undeliveredElementExceptionC != null) {
                throw undeliveredElementExceptionC;
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    @Nullable
    protected Object V() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int i2 = this.size;
            if (i2 == 0) {
                Object objI = i();
                if (objI == null) {
                    objI = kotlinx.coroutines.channels.a.f3578d;
                }
                return objI;
            }
            Object[] objArr = this.buffer;
            int i3 = this.head;
            Object obj = objArr[i3];
            r rVar = null;
            objArr[i3] = null;
            this.size = i2 - 1;
            Object element = kotlinx.coroutines.channels.a.f3578d;
            boolean z2 = false;
            if (i2 == this.capacity) {
                r rVar2 = null;
                while (true) {
                    r rVarE = E();
                    if (rVarE == null) {
                        rVar = rVar2;
                        break;
                    }
                    if (rVarE.T(null) != null) {
                        element = rVarE.getElement();
                        rVar = rVarE;
                        z2 = true;
                        break;
                    }
                    rVarE.U();
                    rVar2 = rVarE;
                }
            }
            if (element != kotlinx.coroutines.channels.a.f3578d && !(element instanceof j)) {
                this.size = i2;
                Object[] objArr2 = this.buffer;
                objArr2[(this.head + i2) % objArr2.length] = element;
            }
            this.head = (this.head + 1) % this.buffer.length;
            kotlin.t tVar = kotlin.t.f3507a;
            if (z2) {
                kotlin.jvm.internal.s.b(rVar);
                rVar.Q();
            }
            return obj;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    @Nullable
    protected Object W(@NotNull kotlinx.coroutines.selects.f<?> select) {
        boolean z2;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int i2 = this.size;
            if (i2 == 0) {
                Object objI = i();
                if (objI == null) {
                    objI = kotlinx.coroutines.channels.a.f3578d;
                }
                return objI;
            }
            Object[] objArr = this.buffer;
            int i3 = this.head;
            Object obj = objArr[i3];
            Object objO = null;
            objArr[i3] = null;
            this.size = i2 - 1;
            Object element = kotlinx.coroutines.channels.a.f3578d;
            if (i2 == this.capacity) {
                while (true) {
                    AbstractChannel.g<E> gVarJ = J();
                    Object objH = select.h(gVarJ);
                    if (objH == null) {
                        objO = gVarJ.o();
                        kotlin.jvm.internal.s.b(objO);
                        element = ((r) objO).getElement();
                        break;
                    }
                    if (objH == kotlinx.coroutines.channels.a.f3578d) {
                        break;
                    }
                    if (objH != kotlinx.coroutines.internal.c.f3804b) {
                        if (objH == kotlinx.coroutines.selects.g.d()) {
                            this.size = i2;
                            this.buffer[this.head] = obj;
                            return objH;
                        }
                        if (!(objH instanceof j)) {
                            throw new IllegalStateException(kotlin.jvm.internal.s.m("performAtomicTrySelect(describeTryOffer) returned ", objH).toString());
                        }
                        element = objH;
                        objO = element;
                    }
                }
                z2 = true;
            } else {
                z2 = false;
            }
            if (element != kotlinx.coroutines.channels.a.f3578d && !(element instanceof j)) {
                this.size = i2;
                Object[] objArr2 = this.buffer;
                objArr2[(this.head + i2) % objArr2.length] = element;
            } else if (!select.l()) {
                this.size = i2;
                this.buffer[this.head] = obj;
                return kotlinx.coroutines.selects.g.d();
            }
            this.head = (this.head + 1) % this.buffer.length;
            kotlin.t tVar = kotlin.t.f3507a;
            if (z2) {
                kotlin.jvm.internal.s.b(objO);
                ((r) objO).Q();
            }
            return obj;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.b
    @Nullable
    protected Object e(@NotNull r send) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return super.e(send);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.b
    @NotNull
    protected String f() {
        return "(buffer:capacity=" + this.capacity + ",size=" + this.size + ')';
    }

    @Override // kotlinx.coroutines.channels.b
    protected final boolean r() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.b
    protected final boolean s() {
        return this.size == this.capacity && this.onBufferOverflow == BufferOverflow.SUSPEND;
    }

    @Override // kotlinx.coroutines.channels.b
    @NotNull
    protected Object u(E element) {
        p<E> pVarD;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int i2 = this.size;
            j<?> jVarI = i();
            if (jVarI != null) {
                return jVarI;
            }
            d0 d0VarD0 = d0(i2);
            if (d0VarD0 != null) {
                return d0VarD0;
            }
            if (i2 == 0) {
                do {
                    pVarD = D();
                    if (pVarD != null) {
                        if (pVarD instanceof j) {
                            this.size = i2;
                            return pVarD;
                        }
                    }
                } while (pVarD.n(element, null) == null);
                this.size = i2;
                kotlin.t tVar = kotlin.t.f3507a;
                reentrantLock.unlock();
                pVarD.f(element);
                return pVarD.k();
            }
            b0(i2, element);
            return kotlinx.coroutines.channels.a.f3576b;
        } finally {
            reentrantLock.unlock();
        }
    }
}
