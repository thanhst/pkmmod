package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import p0.l_p0;

import org.jetbrains.annotations.NotNull;

/* compiled from: AbstractChannel.kt */
@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B;\u0012\u0006\u0010\f\u001a\u00028\u0000\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\r\u0012\u001c\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0007j\b\u0012\u0004\u0012\u00028\u0000`\b¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016R*\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0007j\b\u0012\u0004\u0012\u00028\u0000`\b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/channels/u;", "E", "Lkotlinx/coroutines/channels/t;", "", "L", "Lkotlin/t;", "U", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "j", "Lp0/l;", "onUndeliveredElement", "pollResult", "Lkotlinx/coroutines/k;", "cont", "<init>", "(Ljava/lang/Object;Lkotlinx/coroutines/k;Lp0/l;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class u<E> extends t<E> {

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public final l_p0<E, kotlin.t> onUndeliveredElement;

    /* JADX WARN: Multi-variable type inference failed */
    public u(E e2, @NotNull kotlinx.coroutines.k<? super kotlin.t> kVar, @NotNull l_p0<? super E, kotlin.t> lP0Var) {
        super(e2, kVar);
        this.onUndeliveredElement = lP0Var;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public boolean L() {
        if (!super.L()) {
            return false;
        }
        U();
        return true;
    }

    @Override // kotlinx.coroutines.channels.r
    public void U() {
        OnUndeliveredElementKt.b(this.onUndeliveredElement, getElement(), this.cont.getContext());
    }
}
