package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.CompletedWithCancellation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.u0;
import kotlinx.coroutines.z1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DispatchedContinuation.kt */
@Metadata(bv = {}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u00028\u00000\u0005B\u001d\u0012\u0006\u00100\u001a\u00020.\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b@\u0010AJ\u0017\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u000fJ\u0015\u0010\u0012\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0011\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0010¢\u0006\u0004\b\u001d\u0010\u001eJ \u0010!\u001a\u00020\r2\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0016ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J!\u0010$\u001a\u00020\r2\b\u0010#\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0019\u001a\u00020\u0016H\u0010¢\u0006\u0004\b$\u0010%J\u001f\u0010)\u001a\u00020\r2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00028\u0000H\u0000¢\u0006\u0004\b)\u0010*J\u000f\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b,\u0010-R\u0014\u00100\u001a\u00020.8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010/R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000e\u00101R\u001e\u00104\u001a\u0004\u0018\u00010\u001c8\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\b\u0012\u00102\u0012\u0004\b3\u0010\u000fR\u0014\u00105\u001a\u00020\u001c8\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b)\u00102R\u001a\u00107\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b6\u0010\u0013R\u0014\u0010'\u001a\u00020&8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b8\u00109R\u001c\u0010<\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006B"}, d2 = {"Lkotlinx/coroutines/internal/g;", "T", "Lkotlinx/coroutines/n0;", "Lkotlin/coroutines/jvm/internal/c;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "Lkotlin/coroutines/c;", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "", "m", "()Z", "Lkotlin/t;", "i", "()V", "o", "Lkotlinx/coroutines/l;", "j", "()Lkotlinx/coroutines/l;", "Lkotlinx/coroutines/k;", "continuation", "", "p", "(Lkotlinx/coroutines/k;)Ljava/lang/Throwable;", "cause", "n", "(Ljava/lang/Throwable;)Z", "", "h", "()Ljava/lang/Object;", "Lkotlin/Result;", "result", "resumeWith", "(Ljava/lang/Object;)V", "takenState", "a", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "Lkotlin/coroutines/CoroutineContext;", "context", "value", "k", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Lkotlin/coroutines/c;", "Ljava/lang/Object;", "get_state$kotlinx_coroutines_core$annotations", "_state", "countOrElement", "l", "reusableCancellableContinuation", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/c;", "callerFrame", "b", "()Lkotlin/coroutines/c;", "delegate", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/c;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class g<T> extends n0<T> implements kotlin.coroutines.jvm.internal.c, kotlin.coroutines.c<T> {

    /* renamed from: l, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f3813l = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "_reusableCancellableContinuation");

    @NotNull
    private volatile /* synthetic */ Object _reusableCancellableContinuation;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public final CoroutineDispatcher dispatcher;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public final kotlin.coroutines.c<T> continuation;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @Nullable
    public Object _state;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public final Object countOrElement;

    /* JADX WARN: Multi-variable type inference failed */
    public g(@NotNull CoroutineDispatcher coroutineDispatcher, @NotNull kotlin.coroutines.c<? super T> cVar) {
        super(-1);
        this.dispatcher = coroutineDispatcher;
        this.continuation = cVar;
        this._state = h.f3818a;
        this.countOrElement = ThreadContextKt.b(getContext());
        this._reusableCancellableContinuation = null;
    }

    private final kotlinx.coroutines.l<?> l() {
        Object obj = this._reusableCancellableContinuation;
        if (obj instanceof kotlinx.coroutines.l) {
            return (kotlinx.coroutines.l) obj;
        }
        return null;
    }

    @Override // kotlinx.coroutines.n0
    public void a(@Nullable Object takenState, @NotNull Throwable cause) {
        if (takenState instanceof CompletedWithCancellation) {
            ((CompletedWithCancellation) takenState).onCancellation.invoke(cause);
        }
    }

    @Override // kotlinx.coroutines.n0
    @NotNull
    public kotlin.coroutines.c<T> b() {
        return this;
    }

    @Override // kotlin.coroutines.jvm.internal.c
    @Nullable
    public kotlin.coroutines.jvm.internal.c getCallerFrame() {
        kotlin.coroutines.c<T> cVar = this.continuation;
        if (cVar instanceof kotlin.coroutines.jvm.internal.c) {
            return (kotlin.coroutines.jvm.internal.c) cVar;
        }
        return null;
    }

    @Override // kotlin.coroutines.c
    @NotNull
    public CoroutineContext getContext() {
        return this.continuation.getContext();
    }

    @Override // kotlin.coroutines.jvm.internal.c
    @Nullable
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlinx.coroutines.n0
    @Nullable
    public Object h() {
        Object obj = this._state;
        this._state = h.f3818a;
        return obj;
    }

    public final void i() {
        while (this._reusableCancellableContinuation == h.f3819b) {
        }
    }

    @Nullable
    public final kotlinx.coroutines.l<T> j() {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            if (obj == null) {
                this._reusableCancellableContinuation = h.f3819b;
                return null;
            }
            if (obj instanceof kotlinx.coroutines.l) {
                if (kotlin.i.a(f3813l, this, obj, h.f3819b)) {
                    return (kotlinx.coroutines.l) obj;
                }
            } else if (obj != h.f3819b && !(obj instanceof Throwable)) {
                throw new IllegalStateException(kotlin.jvm.internal.s.m("Inconsistent state ", obj).toString());
            }
        }
    }

    public final void k(@NotNull CoroutineContext context, T value) {
        this._state = value;
        this.resumeMode = 1;
        this.dispatcher.h(context, this);
    }

    public final boolean m() {
        return this._reusableCancellableContinuation != null;
    }

    public final boolean n(@NotNull Throwable cause) {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            d0 d0Var = h.f3819b;
            if (kotlin.jvm.internal.s.a(obj, d0Var)) {
                if (kotlin.i.a(f3813l, this, d0Var, cause)) {
                    return true;
                }
            } else {
                if (obj instanceof Throwable) {
                    return true;
                }
                if (kotlin.i.a(f3813l, this, obj, null)) {
                    return false;
                }
            }
        }
    }

    public final void o() {
        i();
        kotlinx.coroutines.l<?> lVarL = l();
        if (lVarL == null) {
            return;
        }
        lVarL.o();
    }

    @Nullable
    public final Throwable p(@NotNull kotlinx.coroutines.k<?> continuation) {
        d0 d0Var;
        do {
            Object obj = this._reusableCancellableContinuation;
            d0Var = h.f3819b;
            if (obj != d0Var) {
                if (!(obj instanceof Throwable)) {
                    throw new IllegalStateException(kotlin.jvm.internal.s.m("Inconsistent state ", obj).toString());
                }
                if (kotlin.i.a(f3813l, this, obj, null)) {
                    return (Throwable) obj;
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        } while (!kotlin.i.a(f3813l, this, d0Var, continuation));
        return null;
    }

    @Override // kotlin.coroutines.c
    public void resumeWith(@NotNull Object result) {
        CoroutineContext context = this.continuation.getContext();
        Object objD = kotlinx.coroutines.z.d(result, null, 1, null);
        if (this.dispatcher.k(context)) {
            this._state = objD;
            this.resumeMode = 0;
            this.dispatcher.g(context, this);
            return;
        }
        u0 u0VarA = z1.f4018a.a();
        if (u0VarA.B()) {
            this._state = objD;
            this.resumeMode = 0;
            u0VarA.v(this);
            return;
        }
        u0VarA.y(true);
        try {
            CoroutineContext context2 = getContext();
            Object objC = ThreadContextKt.c(context2, this.countOrElement);
            try {
                this.continuation.resumeWith(result);
                kotlin.t tVar = kotlin.t.f3507a;
                while (u0VarA.E()) {
                }
            } finally {
                ThreadContextKt.a(context2, objC);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    @NotNull
    public String toString() {
        return "DispatchedContinuation[" + this.dispatcher + ", " + kotlinx.coroutines.i0.c(this.continuation) + ']';
    }
}
