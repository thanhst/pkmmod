package kotlinx.coroutines;

import com.facebook.internal.ServerProtocol;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CoroutineContext.kt */
@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\n\u001a\u00020\tJ\u0012\u0010\f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0014R*\u0010\u0011\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000e0\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/d2;", "T", "Lkotlinx/coroutines/internal/z;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "oldValue", "Lkotlin/t;", "Q0", "", "P0", ServerProtocol.DIALOG_PARAM_STATE, "K0", "Ljava/lang/ThreadLocal;", "Lkotlin/Pair;", "h", "Ljava/lang/ThreadLocal;", "threadStateToRecover", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class d2<T> extends kotlinx.coroutines.internal.z<T> {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ThreadLocal<Pair<CoroutineContext, Object>> threadStateToRecover;

    @Override // kotlinx.coroutines.internal.z, kotlinx.coroutines.a
    protected void K0(@Nullable Object obj) {
        Pair<CoroutineContext, Object> pair = this.threadStateToRecover.get();
        if (pair != null) {
            ThreadContextKt.a(pair.component1(), pair.component2());
            this.threadStateToRecover.set(null);
        }
        Object objA = z.a(obj, this.uCont);
        kotlin.coroutines.c<T> cVar = this.uCont;
        CoroutineContext context = cVar.getContext();
        Object objC = ThreadContextKt.c(context, null);
        d2<?> d2VarF = objC != ThreadContextKt.f3793a ? CoroutineContextKt.f(cVar, context, objC) : null;
        try {
            this.uCont.resumeWith(objA);
            kotlin.t tVar = kotlin.t.f3507a;
        } finally {
            if (d2VarF == null || d2VarF.P0()) {
                ThreadContextKt.a(context, objC);
            }
        }
    }

    public final boolean P0() {
        if (this.threadStateToRecover.get() == null) {
            return false;
        }
        this.threadStateToRecover.set(null);
        return true;
    }

    public final void Q0(@NotNull CoroutineContext coroutineContext, @Nullable Object obj) {
        this.threadStateToRecover.set(kotlin.j.a(coroutineContext, obj));
    }
}
