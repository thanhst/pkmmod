package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;
import org.jetbrains.annotations.NotNull;

/* compiled from: LockFreeLinkedList.kt */
@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002*\u00020\u0000H\u0001\" \u0010\t\u001a\u00020\u00008\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0004\u0010\u0006\" \u0010\f\u001a\u00020\u00008\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u0012\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006*\n\u0010\u000e\"\u00020\r2\u00020\r*\u001c\u0010\u0010\u001a\u0004\b\u0000\u0010\u000f\"\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0012\u0004\u0012\u00028\u00000\u0000*\f\b\u0002\u0010\u0011\"\u00020\u00012\u00020\u0001*\n\u0010\u0013\"\u00020\u00122\u00020\u0012*\u001c\u0010\u0015\u001a\u0004\b\u0000\u0010\u000f\"\b\u0012\u0004\u0012\u00028\u00000\u00142\b\u0012\u0004\u0012\u00028\u00000\u0014¨\u0006\u0016"}, d2 = {"", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "c", "a", "Ljava/lang/Object;", "()Ljava/lang/Object;", "getCONDITION_FALSE$annotations", "()V", "CONDITION_FALSE", "b", "getLIST_EMPTY$annotations", "LIST_EMPTY", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$a;", "AbstractAtomicDesc", "T", "AddLastDesc", "Node", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$c;", "PrepareOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$d;", "RemoveFirstDesc", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final Object f3832a = new d0("CONDITION_FALSE");

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Object f3833b = new d0("LIST_EMPTY");

    @NotNull
    public static final Object a() {
        return f3832a;
    }

    @NotNull
    public static final Object b() {
        return f3833b;
    }

    @PublishedApi
    @NotNull
    public static final LockFreeLinkedListNode c(@NotNull Object obj) {
        x xVar = obj instanceof x ? (x) obj : null;
        LockFreeLinkedListNode lockFreeLinkedListNode = xVar != null ? xVar.ref : null;
        return lockFreeLinkedListNode == null ? (LockFreeLinkedListNode) obj : lockFreeLinkedListNode;
    }
}
