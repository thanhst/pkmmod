package kotlinx.coroutines.channels;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.t;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.internal.d0;
import p0.l_p0;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConflatedChannel.kt */
@Metadata(bv = {}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B)\u0012 \u0010+\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000f\u0018\u00010)j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`*¢\u0006\u0004\b,\u0010-J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0017\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\n\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0014J\u0016\u0010\f\u001a\u0004\u0018\u00010\u00032\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\nH\u0014J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0014J\u0016\u0010\u0013\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0014R\u0018\u0010\u0018\u001a\u00060\u0014j\u0002`\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\r8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010 \u001a\u00020\r8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001dR\u0014\u0010\"\u001a\u00020\r8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001dR\u0014\u0010$\u001a\u00020\r8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u001dR\u0014\u0010(\u001a\u00020%8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006."}, d2 = {"Lkotlinx/coroutines/channels/k;", "E", "Lkotlinx/coroutines/channels/AbstractChannel;", "", "element", "Lkotlinx/coroutines/internal/UndeliveredElementException;", "b0", "u", "(Ljava/lang/Object;)Ljava/lang/Object;", "V", "Lkotlinx/coroutines/selects/f;", "select", "W", "", "wasClosed", "Lkotlin/t;", "R", "Lkotlinx/coroutines/channels/o;", "receive", "L", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "h", "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "i", "Ljava/lang/Object;", "value", "N", "()Z", "isBufferAlwaysEmpty", "O", "isBufferEmpty", "r", "isBufferAlwaysFull", "s", "isBufferFull", "", "f", "()Ljava/lang/String;", "bufferDebugString", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(Lp0/l;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public class k<E> extends AbstractChannel<E> {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ReentrantLock lock;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Object value;

    public k(@Nullable l_p0<? super E, t> lP0Var) {
        super(lP0Var);
        this.lock = new ReentrantLock();
        this.value = a.f3575a;
    }

    private final UndeliveredElementException b0(Object element) {
        l_p0<E, t> lP0Var;
        Object obj = this.value;
        UndeliveredElementException undeliveredElementExceptionD = null;
        if (obj != a.f3575a && (lP0Var = this.onUndeliveredElement) != null) {
            undeliveredElementExceptionD = OnUndeliveredElementKt.d(lP0Var, obj, null, 2, null);
        }
        this.value = element;
        return undeliveredElementExceptionD;
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
        return this.value == a.f3575a;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected void R(boolean z2) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            UndeliveredElementException undeliveredElementExceptionB0 = b0(a.f3575a);
            kotlin.t tVar = kotlin.t.f3507a;
            reentrantLock.unlock();
            super.R(z2);
            if (undeliveredElementExceptionB0 != null) {
                throw undeliveredElementExceptionB0;
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
            Object obj = this.value;
            d0 d0Var = a.f3575a;
            if (obj != d0Var) {
                this.value = d0Var;
                kotlin.t tVar = kotlin.t.f3507a;
                return obj;
            }
            Object objI = i();
            if (objI == null) {
                objI = a.f3578d;
            }
            return objI;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    @Nullable
    protected Object W(@NotNull kotlinx.coroutines.selects.f<?> select) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Object obj = this.value;
            d0 d0Var = a.f3575a;
            if (obj == d0Var) {
                Object objI = i();
                if (objI == null) {
                    objI = a.f3578d;
                }
                return objI;
            }
            if (!select.l()) {
                return kotlinx.coroutines.selects.g.d();
            }
            Object obj2 = this.value;
            this.value = d0Var;
            kotlin.t tVar = kotlin.t.f3507a;
            return obj2;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.b
    @NotNull
    protected String f() {
        return "(value=" + this.value + ')';
    }

    @Override // kotlinx.coroutines.channels.b
    protected final boolean r() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.b
    protected final boolean s() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.b
    @NotNull
    protected Object u(E element) {
        p<E> pVarD;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            j<?> jVarI = i();
            if (jVarI != null) {
                return jVarI;
            }
            if (this.value == a.f3575a) {
                do {
                    pVarD = D();
                    if (pVarD != null) {
                        if (pVarD instanceof j) {
                            return pVarD;
                        }
                    }
                } while (pVarD.n(element, null) == null);
                kotlin.t tVar = kotlin.t.f3507a;
                reentrantLock.unlock();
                pVarD.f(element);
                return pVarD.k();
            }
            UndeliveredElementException undeliveredElementExceptionB0 = b0(element);
            if (undeliveredElementExceptionB0 == null) {
                return a.f3576b;
            }
            throw undeliveredElementExceptionB0;
        } finally {
            reentrantLock.unlock();
        }
    }
}
