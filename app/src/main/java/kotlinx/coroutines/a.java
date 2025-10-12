package kotlinx.coroutines;

import com.facebook.internal.ServerProtocol;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AbstractCoroutine.kt */
@InternalCoroutinesApi
@Metadata(bv = {}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\b'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00028\u00000\u00042\u00020\u0005B\u001f\u0012\u0006\u00102\u001a\u00020&\u0012\u0006\u00103\u001a\u00020\f\u0012\u0006\u00104\u001a\u00020\f¢\u0006\u0004\b5\u00106J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0014J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\u0012\u0010\u0013\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0004J\u001e\u0010\u0016\u001a\u00020\u00072\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\tJ\u0012\u0010\u0017\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014J\u0017\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\nH\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u000fH\u0010¢\u0006\u0004\b\u001b\u0010\u001cJO\u0010$\u001a\u00020\u0007\"\u0004\b\u0001\u0010\u001d2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00028\u00012'\u0010#\u001a#\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00110!¢\u0006\u0002\b\"ø\u0001\u0000¢\u0006\u0004\b$\u0010%R\u001d\u0010-\u001a\u00020&8\u0006¢\u0006\u0012\n\u0004\b'\u0010(\u0012\u0004\b+\u0010,\u001a\u0004\b)\u0010*R\u0014\u0010/\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010*R\u0014\u00100\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u00101\u0082\u0002\u0004\n\u0002\b\u0019¨\u00067"}, d2 = {"Lkotlinx/coroutines/a;", "T", "Lkotlinx/coroutines/n1;", "Lkotlinx/coroutines/h1;", "Lkotlin/coroutines/c;", "Lkotlinx/coroutines/g0;", "value", "Lkotlin/t;", "M0", "(Ljava/lang/Object;)V", "", "cause", "", "handled", "L0", "", "S", "", ServerProtocol.DIALOG_PARAM_STATE, "u0", "Lkotlin/Result;", "result", "resumeWith", "K0", "exception", "h0", "(Ljava/lang/Throwable;)V", "p0", "()Ljava/lang/String;", "R", "Lkotlinx/coroutines/CoroutineStart;", "start", "receiver", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "block", "N0", "(Lkotlinx/coroutines/CoroutineStart;Ljava/lang/Object;Lp0/p;)V", "Lkotlin/coroutines/CoroutineContext;", "f", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "getContext$annotations", "()V", "context", "h", "coroutineContext", "isActive", "()Z", "parentContext", "initParentJob", "active", "<init>", "(Lkotlin/coroutines/CoroutineContext;ZZ)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public abstract class a<T> extends n1 implements kotlin.coroutines.c<T>, g0 {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineContext context;

    public a(@NotNull CoroutineContext coroutineContext, boolean z2, boolean z3) {
        super(z3);
        if (z2) {
            i0((h1) coroutineContext.get(h1.INSTANCE));
        }
        this.context = coroutineContext.plus(this);
    }

    protected void K0(@Nullable Object obj) {
        M(obj);
    }

    protected void L0(@NotNull Throwable th, boolean z2) {
    }

    protected void M0(T value) {
    }

    public final <R> void N0(@NotNull CoroutineStart start, R receiver, @NotNull p0.p<? super R, ? super kotlin.coroutines.c<? super T>, ? extends Object> block) {
        start.invoke(block, receiver, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.n1
    @NotNull
    public String S() {
        return kotlin.jvm.internal.s.m(i0.a(this), " was cancelled");
    }

    @Override // kotlin.coroutines.c
    @NotNull
    public final CoroutineContext getContext() {
        return this.context;
    }

    @Override // kotlinx.coroutines.g0
    @NotNull
    public CoroutineContext h() {
        return this.context;
    }

    @Override // kotlinx.coroutines.n1
    public final void h0(@NotNull Throwable exception) {
        d0.a(this.context, exception);
    }

    @Override // kotlinx.coroutines.n1, kotlinx.coroutines.h1
    public boolean isActive() {
        return super.isActive();
    }

    @Override // kotlinx.coroutines.n1
    @NotNull
    public String p0() {
        String strB = CoroutineContextKt.b(this.context);
        if (strB == null) {
            return super.p0();
        }
        return '\"' + strB + "\":" + super.p0();
    }

    @Override // kotlin.coroutines.c
    public final void resumeWith(@NotNull Object result) {
        Object objN0 = n0(z.d(result, null, 1, null));
        if (objN0 == o1.f3878b) {
            return;
        }
        K0(objN0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.n1
    protected final void u0(@Nullable Object obj) {
        if (!(obj instanceof w)) {
            M0(obj);
        } else {
            w wVar = (w) obj;
            L0(wVar.cause, wVar.a());
        }
    }
}
