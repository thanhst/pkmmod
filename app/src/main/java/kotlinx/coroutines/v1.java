package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CancellableContinuation.kt */
@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/v1;", "Lkotlinx/coroutines/e;", "", "cause", "Lkotlin/t;", "a", "", "toString", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "e", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "node", "<init>", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
final class v1 extends e {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LockFreeLinkedListNode node;

    public v1(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
        this.node = lockFreeLinkedListNode;
    }

    @Override // kotlinx.coroutines.j
    public void a(@Nullable Throwable th) {
        this.node.L();
    }

    @Override // p0.l
    public /* bridge */ /* synthetic */ kotlin.t invoke(Throwable th) {
        a(th);
        return kotlin.t.f3507a;
    }

    @NotNull
    public String toString() {
        return "RemoveOnCancel[" + this.node + ']';
    }
}
