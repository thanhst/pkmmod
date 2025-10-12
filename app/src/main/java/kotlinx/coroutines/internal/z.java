package kotlinx.coroutines.internal;

import com.facebook.internal.ServerProtocol;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.h1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Scopes.kt */
@Metadata(bv = {}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u0004B\u001d\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\r¢\u0006\u0004\b\u001e\u0010\u001fJ\u000e\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\u0012\u0010\f\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0013\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00188@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006 "}, d2 = {"Lkotlinx/coroutines/internal/z;", "T", "Lkotlinx/coroutines/a;", "Lkotlin/coroutines/jvm/internal/c;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "", ServerProtocol.DIALOG_PARAM_STATE, "Lkotlin/t;", "M", "K0", "Lkotlin/coroutines/c;", "g", "Lkotlin/coroutines/c;", "uCont", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/c;", "callerFrame", "", "j0", "()Z", "isScopedCoroutine", "Lkotlinx/coroutines/h1;", "O0", "()Lkotlinx/coroutines/h1;", "parent", "Lkotlin/coroutines/CoroutineContext;", "context", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/c;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public class z<T> extends kotlinx.coroutines.a<T> implements kotlin.coroutines.jvm.internal.c {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public final kotlin.coroutines.c<T> uCont;

    /* JADX WARN: Multi-variable type inference failed */
    public z(@NotNull CoroutineContext coroutineContext, @NotNull kotlin.coroutines.c<? super T> cVar) {
        super(coroutineContext, true, true);
        this.uCont = cVar;
    }

    @Override // kotlinx.coroutines.a
    protected void K0(@Nullable Object obj) {
        kotlin.coroutines.c<T> cVar = this.uCont;
        cVar.resumeWith(kotlinx.coroutines.z.a(obj, cVar));
    }

    @Override // kotlinx.coroutines.n1
    protected void M(@Nullable Object obj) {
        h.c(IntrinsicsKt__IntrinsicsJvmKt.c(this.uCont), kotlinx.coroutines.z.a(obj, this.uCont), null, 2, null);
    }

    @Nullable
    public final h1 O0() {
        kotlinx.coroutines.q qVarE0 = e0();
        if (qVarE0 == null) {
            return null;
        }
        return qVarE0.getParent();
    }

    @Override // kotlin.coroutines.jvm.internal.c
    @Nullable
    public final kotlin.coroutines.jvm.internal.c getCallerFrame() {
        kotlin.coroutines.c<T> cVar = this.uCont;
        if (cVar instanceof kotlin.coroutines.jvm.internal.c) {
            return (kotlin.coroutines.jvm.internal.c) cVar;
        }
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.c
    @Nullable
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlinx.coroutines.n1
    protected final boolean j0() {
        return true;
    }
}
