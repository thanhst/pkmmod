package kotlinx.coroutines.channels;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.t;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.internal.d0;
import p0.l_p0;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LinkedListChannel.kt */
@Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B)\u0012 \u0010\u001b\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\f\u0018\u00010\u0019j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J/\u0010\r\u001a\u00020\f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\nH\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u000f8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u000f8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u000f8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0018\u001a\u00020\u000f8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0011\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"Lkotlinx/coroutines/channels/l;", "E", "Lkotlinx/coroutines/channels/AbstractChannel;", "element", "", "u", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/k;", "Lkotlinx/coroutines/channels/r;", "list", "Lkotlinx/coroutines/channels/j;", "closed", "Lkotlin/t;", "S", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/j;)V", "", "N", "()Z", "isBufferAlwaysEmpty", "O", "isBufferEmpty", "r", "isBufferAlwaysFull", "s", "isBufferFull", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(Lp0/l;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public class l<E> extends AbstractChannel<E> {
    public l(@Nullable l_p0<? super E, t> lP0Var) {
        super(lP0Var);
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected final boolean N() {
        return true;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected final boolean O() {
        return true;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected void S(@NotNull Object list, @NotNull j<?> closed) {
        UndeliveredElementException undeliveredElementExceptionC = null;
        if (list != null) {
            if (list instanceof ArrayList) {
                ArrayList arrayList = (ArrayList) list;
                int size = arrayList.size() - 1;
                if (size >= 0) {
                    UndeliveredElementException undeliveredElementExceptionC2 = null;
                    while (true) {
                        int i2 = size - 1;
                        r rVar = (r) arrayList.get(size);
                        if (rVar instanceof b.a) {
                            l_p0<E, t> lP0Var = this.onUndeliveredElement;
                            undeliveredElementExceptionC2 = lP0Var == null ? null : OnUndeliveredElementKt.c(lP0Var, ((b.a) rVar).element, undeliveredElementExceptionC2);
                        } else {
                            rVar.S(closed);
                        }
                        if (i2 < 0) {
                            break;
                        } else {
                            size = i2;
                        }
                    }
                    undeliveredElementExceptionC = undeliveredElementExceptionC2;
                }
            } else {
                r rVar2 = (r) list;
                if (rVar2 instanceof b.a) {
                    l_p0<E, t> lP0Var2 = this.onUndeliveredElement;
                    if (lP0Var2 != null) {
                        undeliveredElementExceptionC = OnUndeliveredElementKt.c(lP0Var2, ((b.a) rVar2).element, null);
                    }
                } else {
                    rVar2.S(closed);
                }
            }
        }
        if (undeliveredElementExceptionC != null) {
            throw undeliveredElementExceptionC;
        }
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
        p<?> pVarA;
        do {
            Object objU = super.u(element);
            d0 d0Var = a.f3576b;
            if (objU == d0Var) {
                return d0Var;
            }
            if (objU != a.f3577c) {
                if (objU instanceof j) {
                    return objU;
                }
                throw new IllegalStateException(kotlin.jvm.internal.s.m("Invalid offerInternal result ", objU).toString());
            }
            pVarA = A(element);
            if (pVarA == null) {
                return d0Var;
            }
        } while (!(pVarA instanceof j));
        return pVarA;
    }
}
