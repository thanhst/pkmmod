package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import org.jetbrains.annotations.NotNull;

/* compiled from: CancellableContinuation.kt */
@Metadata(bv = {}, d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0000\u001a\u0018\u0010\t\u001a\u00020\b*\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0007\u001a\u00020\u0006H\u0000\u001a\u0018\u0010\f\u001a\u00020\b*\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0007¨\u0006\r"}, d2 = {"T", "Lkotlin/coroutines/c;", "delegate", "Lkotlinx/coroutines/l;", "b", "Lkotlinx/coroutines/k;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "node", "Lkotlin/t;", "c", "Lkotlinx/coroutines/q0;", "handle", "a", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class n {
    @InternalCoroutinesApi
    public static final void a(@NotNull k<?> kVar, @NotNull q0 q0Var) {
        kVar.s(new r0(q0Var));
    }

    @NotNull
    public static final <T> l<T> b(@NotNull kotlin.coroutines.c<? super T> cVar) {
        if (!(cVar instanceof kotlinx.coroutines.internal.g)) {
            return new l<>(cVar, 1);
        }
        l<T> lVarJ = ((kotlinx.coroutines.internal.g) cVar).j();
        if (lVarJ == null || !lVarJ.J()) {
            lVarJ = null;
        }
        return lVarJ == null ? new l<>(cVar, 2) : lVarJ;
    }

    public static final void c(@NotNull k<?> kVar, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
        kVar.s(new v1(lockFreeLinkedListNode));
    }
}
