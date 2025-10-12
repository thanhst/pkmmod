package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.d0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AbstractChannel.kt */
@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0010\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0011\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b!\u0010\"J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J!\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00028\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0014\u0010\u0010\u001a\u00020\b2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0019\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u001b\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001d¨\u0006#"}, d2 = {"Lkotlinx/coroutines/channels/j;", "E", "Lkotlinx/coroutines/channels/r;", "Lkotlinx/coroutines/channels/p;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$c;", "otherOp", "Lkotlinx/coroutines/internal/d0;", "T", "Lkotlin/t;", "Q", "value", "n", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$c;)Lkotlinx/coroutines/internal/d0;", "f", "(Ljava/lang/Object;)V", "closed", "S", "", "toString", "", "h", "Ljava/lang/Throwable;", "closeCause", "Y", "()Ljava/lang/Throwable;", "sendException", "X", "receiveException", "V", "()Lkotlinx/coroutines/channels/j;", "offerResult", "W", "pollResult", "<init>", "(Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class j<E> extends r implements p<E> {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @Nullable
    public final Throwable closeCause;

    public j(@Nullable Throwable th) {
        this.closeCause = th;
    }

    @Override // kotlinx.coroutines.channels.r
    public void Q() {
    }

    @Override // kotlinx.coroutines.channels.r
    public void S(@NotNull j<?> jVar) {
    }

    @Override // kotlinx.coroutines.channels.r
    @NotNull
    public d0 T(@Nullable LockFreeLinkedListNode.PrepareOp otherOp) {
        d0 d0Var = kotlinx.coroutines.m.f3863a;
        if (otherOp != null) {
            otherOp.d();
        }
        return d0Var;
    }

    @Override // kotlinx.coroutines.channels.p
    @NotNull
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public j<E> k() {
        return this;
    }

    @Override // kotlinx.coroutines.channels.r
    @NotNull
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public j<E> R() {
        return this;
    }

    @NotNull
    public final Throwable X() {
        Throwable th = this.closeCause;
        return th == null ? new ClosedReceiveChannelException("Channel was closed") : th;
    }

    @NotNull
    public final Throwable Y() {
        Throwable th = this.closeCause;
        return th == null ? new ClosedSendChannelException("Channel was closed") : th;
    }

    @Override // kotlinx.coroutines.channels.p
    public void f(E value) {
    }

    @Override // kotlinx.coroutines.channels.p
    @NotNull
    public d0 n(E value, @Nullable LockFreeLinkedListNode.PrepareOp otherOp) {
        d0 d0Var = kotlinx.coroutines.m.f3863a;
        if (otherOp != null) {
            otherOp.d();
        }
        return d0Var;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    @NotNull
    public String toString() {
        return "Closed@" + i0.b(this) + '[' + this.closeCause + ']';
    }
}
