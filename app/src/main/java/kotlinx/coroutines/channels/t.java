package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.d0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AbstractChannel.kt */
@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0012\u001a\u00028\u0000\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0004\b\u0017\u0010\u0018J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0014\u0010\u000b\u001a\u00020\u00072\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\u001a\u0010\u0012\u001a\u00028\u00008\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u00138\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/channels/t;", "E", "Lkotlinx/coroutines/channels/r;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$c;", "otherOp", "Lkotlinx/coroutines/internal/d0;", "T", "Lkotlin/t;", "Q", "Lkotlinx/coroutines/channels/j;", "closed", "S", "", "toString", "h", "Ljava/lang/Object;", "R", "()Ljava/lang/Object;", "pollResult", "Lkotlinx/coroutines/k;", "i", "Lkotlinx/coroutines/k;", "cont", "<init>", "(Ljava/lang/Object;Lkotlinx/coroutines/k;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public class t<E> extends r {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final E pollResult;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public final kotlinx.coroutines.k<kotlin.t> cont;

    /* JADX WARN: Multi-variable type inference failed */
    public t(E e2, @NotNull kotlinx.coroutines.k<? super kotlin.t> kVar) {
        this.pollResult = e2;
        this.cont = kVar;
    }

    @Override // kotlinx.coroutines.channels.r
    public void Q() {
        this.cont.G(kotlinx.coroutines.m.f3863a);
    }

    @Override // kotlinx.coroutines.channels.r
    /* renamed from: R */
    public E getElement() {
        return this.pollResult;
    }

    @Override // kotlinx.coroutines.channels.r
    public void S(@NotNull j<?> jVar) {
        kotlinx.coroutines.k<kotlin.t> kVar = this.cont;
        Result.Companion companion = Result.INSTANCE;
        kVar.resumeWith(Result.m158constructorimpl(kotlin.h.a(jVar.Y())));
    }

    @Override // kotlinx.coroutines.channels.r
    @Nullable
    public d0 T(@Nullable LockFreeLinkedListNode.PrepareOp otherOp) {
        if (this.cont.c(kotlin.t.f3507a, otherOp == null ? null : otherOp.desc) == null) {
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
        return i0.a(this) + '@' + i0.b(this) + '(' + getElement() + ')';
    }
}
