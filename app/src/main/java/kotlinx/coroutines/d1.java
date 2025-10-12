package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

/* compiled from: Interruptible.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a+\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"T", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lkotlin/Function0;", "block", "b", "(Lkotlin/coroutines/CoroutineContext;Lp0/a;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class d1 {
    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> T b(CoroutineContext coroutineContext, p0.a<? extends T> aVar) throws Throwable {
        try {
            a2 a2Var = new a2(k1.g(coroutineContext));
            a2Var.d();
            try {
                return aVar.invoke();
            } finally {
                a2Var.a();
            }
        } catch (InterruptedException e2) {
            throw new CancellationException("Blocking call was interrupted due to parent cancellation").initCause(e2);
        }
    }
}
