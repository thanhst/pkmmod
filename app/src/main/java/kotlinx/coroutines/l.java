package kotlinx.coroutines;

import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.ServerProtocol;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmName;
import kotlinx.coroutines.h1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CancellableContinuationImpl.kt */
@Metadata(bv = {}, d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0011\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\u00060\u0004j\u0002`\u0005B\u001e\u0012\f\u0010o\u001a\b\u0012\u0004\u0012\u00028\u00000k\u0012\u0006\u0010)\u001a\u00020#¢\u0006\u0005\b\u007f\u0010\u0080\u0001J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJB\u0010\u0013\u001a\u00020\u00102'\u0010\u0012\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00100\rj\u0002`\u00112\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\bJ\u000f\u0010\u0016\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\bJ\u0011\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJB\u0010\u001e\u001a\u00020\u00102'\u0010\u0012\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00100\rj\u0002`\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ8\u0010!\u001a\u00020 2'\u0010\u0012\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00100\rj\u0002`\u0011H\u0002¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020\u00102\u0006\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b%\u0010&JZ\u0010,\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u001c2\u0006\u0010)\u001a\u00020#2#\u0010*\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\r2\b\u0010+\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\b,\u0010-JH\u0010.\u001a\u00020\u00102\b\u0010(\u001a\u0004\u0018\u00010\u001c2\u0006\u0010)\u001a\u00020#2%\b\u0002\u0010*\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\rH\u0002¢\u0006\u0004\b.\u0010/JJ\u00101\u001a\u0004\u0018\u0001002\b\u0010(\u001a\u0004\u0018\u00010\u001c2\b\u0010+\u001a\u0004\u0018\u00010\u001c2#\u0010*\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\rH\u0002¢\u0006\u0004\b1\u00102J\u0019\u00104\u001a\u0002032\b\u0010(\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\u0010H\u0002¢\u0006\u0004\b6\u0010\u001bJ\u000f\u00107\u001a\u00020\u0010H\u0016¢\u0006\u0004\b7\u0010\u001bJ\u000f\u00108\u001a\u00020\u0006H\u0001¢\u0006\u0004\b8\u0010\bJ\u0017\u0010;\u001a\n\u0018\u000109j\u0004\u0018\u0001`:H\u0016¢\u0006\u0004\b;\u0010<J\u0011\u0010=\u001a\u0004\u0018\u00010\u001cH\u0010¢\u0006\u0004\b=\u0010>J!\u0010@\u001a\u00020\u00102\b\u0010?\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\n\u001a\u00020\tH\u0010¢\u0006\u0004\b@\u0010AJ\u0019\u0010B\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\bB\u0010\fJ\u0017\u0010C\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\bC\u0010DJ\u001f\u0010E\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020 2\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\bE\u0010FJ8\u0010G\u001a\u00020\u00102!\u0010*\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00100\r2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\bG\u0010\u0014J\u0017\u0010J\u001a\u00020\t2\u0006\u0010I\u001a\u00020HH\u0016¢\u0006\u0004\bJ\u0010KJ\u0011\u0010L\u001a\u0004\u0018\u00010\u001cH\u0001¢\u0006\u0004\bL\u0010>J \u0010O\u001a\u00020\u00102\f\u0010N\u001a\b\u0012\u0004\u0012\u00028\u00000MH\u0016ø\u0001\u0000¢\u0006\u0004\bO\u0010PJ<\u0010R\u001a\u00020\u00102\u0006\u0010Q\u001a\u00028\u00002#\u0010*\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\rH\u0016¢\u0006\u0004\bR\u0010SJ8\u0010T\u001a\u00020\u00102'\u0010\u0012\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00100\rj\u0002`\u0011H\u0016¢\u0006\u0004\bT\u0010UJ\u000f\u0010V\u001a\u00020\u0010H\u0000¢\u0006\u0004\bV\u0010\u001bJ#\u0010W\u001a\u0004\u0018\u00010\u001c2\u0006\u0010Q\u001a\u00028\u00002\b\u0010+\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\bW\u0010XJH\u0010Y\u001a\u0004\u0018\u00010\u001c2\u0006\u0010Q\u001a\u00028\u00002\b\u0010+\u001a\u0004\u0018\u00010\u001c2#\u0010*\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\rH\u0016¢\u0006\u0004\bY\u0010ZJ\u0019\u0010\\\u001a\u0004\u0018\u00010\u001c2\u0006\u0010[\u001a\u00020\tH\u0016¢\u0006\u0004\b\\\u0010]J\u0017\u0010_\u001a\u00020\u00102\u0006\u0010^\u001a\u00020\u001cH\u0016¢\u0006\u0004\b_\u0010PJ\u001b\u0010a\u001a\u00020\u0010*\u00020`2\u0006\u0010Q\u001a\u00028\u0000H\u0016¢\u0006\u0004\ba\u0010bJ\u001f\u0010c\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0010¢\u0006\u0004\bc\u0010dJ\u001b\u0010e\u001a\u0004\u0018\u00010\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0010¢\u0006\u0004\be\u0010fJ\u000f\u0010h\u001a\u00020gH\u0016¢\u0006\u0004\bh\u0010iJ\u000f\u0010j\u001a\u00020gH\u0014¢\u0006\u0004\bj\u0010iR \u0010o\u001a\b\u0012\u0004\u0012\u00028\u00000k8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b=\u0010l\u001a\u0004\bm\u0010nR\u001a\u0010t\u001a\u00020p8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b4\u0010q\u001a\u0004\br\u0010sR\u0018\u0010v\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010uR\u0014\u0010x\u001a\u00020g8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bw\u0010iR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001c8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\by\u0010>R\u0014\u0010{\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bz\u0010\bR\u001c\u0010~\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b|\u0010}\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0081\u0001"}, d2 = {"Lkotlinx/coroutines/l;", "T", "Lkotlinx/coroutines/n0;", "Lkotlinx/coroutines/k;", "Lkotlin/coroutines/jvm/internal/c;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "", "z", "()Z", "", "cause", "n", "(Ljava/lang/Throwable;)Z", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlin/t;", "Lkotlinx/coroutines/CompletionHandler;", "handler", "k", "(Lp0/l;Ljava/lang/Throwable;)V", "P", "N", "Lkotlinx/coroutines/q0;", "x", "()Lkotlinx/coroutines/q0;", "I", "()V", "", ServerProtocol.DIALOG_PARAM_STATE, "B", "(Lp0/l;Ljava/lang/Object;)V", "Lkotlinx/coroutines/i;", "A", "(Lp0/l;)Lkotlinx/coroutines/i;", "", "mode", "q", "(I)V", "Lkotlinx/coroutines/t1;", "proposedUpdate", "resumeMode", "onCancellation", "idempotent", "M", "(Lkotlinx/coroutines/t1;Ljava/lang/Object;ILp0/l;Ljava/lang/Object;)Ljava/lang/Object;", "K", "(Ljava/lang/Object;ILp0/l;)V", "Lkotlinx/coroutines/internal/d0;", "O", "(Ljava/lang/Object;Ljava/lang/Object;Lp0/l;)Lkotlinx/coroutines/internal/d0;", "", "i", "(Ljava/lang/Object;)Ljava/lang/Void;", "p", "w", "J", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "h", "()Ljava/lang/Object;", "takenState", "a", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "m", "F", "(Ljava/lang/Throwable;)V", "j", "(Lkotlinx/coroutines/i;Ljava/lang/Throwable;)V", "l", "Lkotlinx/coroutines/h1;", "parent", "r", "(Lkotlinx/coroutines/h1;)Ljava/lang/Throwable;", "t", "Lkotlin/Result;", "result", "resumeWith", "(Ljava/lang/Object;)V", "value", "H", "(Ljava/lang/Object;Lp0/l;)V", "s", "(Lp0/l;)V", "o", "c", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "D", "(Ljava/lang/Object;Ljava/lang/Object;Lp0/l;)Ljava/lang/Object;", "exception", "E", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "token", "G", "Lkotlinx/coroutines/CoroutineDispatcher;", "e", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "f", "(Ljava/lang/Object;)Ljava/lang/Object;", "d", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "", "toString", "()Ljava/lang/String;", "C", "Lkotlin/coroutines/c;", "Lkotlin/coroutines/c;", "b", "()Lkotlin/coroutines/c;", "delegate", "Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlinx/coroutines/q0;", "parentHandle", "v", "stateDebugRepresentation", "u", "y", "isCompleted", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/c;", "callerFrame", "<init>", "(Lkotlin/coroutines/c;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
@PublishedApi
/* loaded from: classes.dex */
public class l<T> extends n0<T> implements k<T>, kotlin.coroutines.jvm.internal.c {

    /* renamed from: k, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f3858k = AtomicIntegerFieldUpdater.newUpdater(l.class, "_decision");

    /* renamed from: l, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f3859l = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "_state");

    @NotNull
    private volatile /* synthetic */ int _decision;

    @NotNull
    private volatile /* synthetic */ Object _state;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final kotlin.coroutines.c<T> delegate;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineContext context;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private q0 parentHandle;

    /* JADX WARN: Multi-variable type inference failed */
    public l(@NotNull kotlin.coroutines.c<? super T> cVar, int i2) {
        super(i2);
        this.delegate = cVar;
        this.context = cVar.getContext();
        this._decision = 0;
        this._state = d.f3607e;
    }

    private final i A(p0.l<? super Throwable, kotlin.t> handler) {
        return handler instanceof i ? (i) handler : new e1(handler);
    }

    private final void B(p0.l<? super Throwable, kotlin.t> handler, Object state) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + handler + ", already has " + state).toString());
    }

    private final void I() {
        kotlin.coroutines.c<T> cVar = this.delegate;
        kotlinx.coroutines.internal.g gVar = cVar instanceof kotlinx.coroutines.internal.g ? (kotlinx.coroutines.internal.g) cVar : null;
        Throwable thP = gVar != null ? gVar.p(this) : null;
        if (thP == null) {
            return;
        }
        o();
        m(thP);
    }

    private final void K(Object proposedUpdate, int resumeMode, p0.l<? super Throwable, kotlin.t> onCancellation) {
        Object obj;
        do {
            obj = this._state;
            if (!(obj instanceof t1)) {
                if (obj instanceof o) {
                    o oVar = (o) obj;
                    if (oVar.c()) {
                        if (onCancellation == null) {
                            return;
                        }
                        l(onCancellation, oVar.cause);
                        return;
                    }
                }
                i(proposedUpdate);
                throw new KotlinNothingValueException();
            }
        } while (!kotlin.i.a(f3859l, this, obj, M((t1) obj, proposedUpdate, resumeMode, onCancellation, null)));
        p();
        q(resumeMode);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void L(l lVar, Object obj, int i2, p0.l lVar2, int i3, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
        }
        if ((i3 & 4) != 0) {
            lVar2 = null;
        }
        lVar.K(obj, i2, lVar2);
    }

    private final Object M(t1 state, Object proposedUpdate, int resumeMode, p0.l<? super Throwable, kotlin.t> onCancellation, Object idempotent) {
        if (proposedUpdate instanceof w) {
            return proposedUpdate;
        }
        if (!o0.b(resumeMode) && idempotent == null) {
            return proposedUpdate;
        }
        if (onCancellation != null || (((state instanceof i) && !(state instanceof e)) || idempotent != null)) {
            return new CompletedContinuation(proposedUpdate, state instanceof i ? (i) state : null, onCancellation, idempotent, null, 16, null);
        }
        return proposedUpdate;
    }

    private final boolean N() {
        do {
            int i2 = this._decision;
            if (i2 != 0) {
                if (i2 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f3858k.compareAndSet(this, 0, 2));
        return true;
    }

    private final kotlinx.coroutines.internal.d0 O(Object proposedUpdate, Object idempotent, p0.l<? super Throwable, kotlin.t> onCancellation) {
        Object obj;
        do {
            obj = this._state;
            if (!(obj instanceof t1)) {
                if ((obj instanceof CompletedContinuation) && idempotent != null && ((CompletedContinuation) obj).idempotentResume == idempotent) {
                    return m.f3863a;
                }
                return null;
            }
        } while (!kotlin.i.a(f3859l, this, obj, M((t1) obj, proposedUpdate, this.resumeMode, onCancellation, idempotent)));
        p();
        return m.f3863a;
    }

    private final boolean P() {
        do {
            int i2 = this._decision;
            if (i2 != 0) {
                if (i2 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f3858k.compareAndSet(this, 0, 1));
        return true;
    }

    private final Void i(Object proposedUpdate) {
        throw new IllegalStateException(kotlin.jvm.internal.s.m("Already resumed, but proposed with update ", proposedUpdate).toString());
    }

    private final void k(p0.l<? super Throwable, kotlin.t> handler, Throwable cause) {
        try {
            handler.invoke(cause);
        } catch (Throwable th) {
            d0.a(getContext(), new CompletionHandlerException(kotlin.jvm.internal.s.m("Exception in invokeOnCancellation handler for ", this), th));
        }
    }

    private final boolean n(Throwable cause) {
        if (z()) {
            return ((kotlinx.coroutines.internal.g) this.delegate).n(cause);
        }
        return false;
    }

    private final void p() {
        if (z()) {
            return;
        }
        o();
    }

    private final void q(int mode) {
        if (N()) {
            return;
        }
        o0.a(this, mode);
    }

    private final String v() {
        Object obj = get_state();
        return obj instanceof t1 ? "Active" : obj instanceof o ? AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_CANCELLED : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_COMPLETED;
    }

    private final q0 x() {
        h1 h1Var = (h1) getContext().get(h1.INSTANCE);
        if (h1Var == null) {
            return null;
        }
        q0 q0VarC = h1.a.c(h1Var, true, false, new p(this), 2, null);
        this.parentHandle = q0VarC;
        return q0VarC;
    }

    private final boolean z() {
        return o0.c(this.resumeMode) && ((kotlinx.coroutines.internal.g) this.delegate).m();
    }

    @NotNull
    protected String C() {
        return "CancellableContinuation";
    }

    @Override // kotlinx.coroutines.k
    @Nullable
    public Object D(T value, @Nullable Object idempotent, @Nullable p0.l<? super Throwable, kotlin.t> onCancellation) {
        return O(value, idempotent, onCancellation);
    }

    @Override // kotlinx.coroutines.k
    @Nullable
    public Object E(@NotNull Throwable exception) {
        return O(new w(exception, false, 2, null), null, null);
    }

    public final void F(@NotNull Throwable cause) {
        if (n(cause)) {
            return;
        }
        m(cause);
        p();
    }

    @Override // kotlinx.coroutines.k
    public void G(@NotNull Object token) {
        q(this.resumeMode);
    }

    @Override // kotlinx.coroutines.k
    public void H(T value, @Nullable p0.l<? super Throwable, kotlin.t> onCancellation) {
        K(value, this.resumeMode, onCancellation);
    }

    @JvmName(name = "resetStateReusable")
    public final boolean J() {
        Object obj = this._state;
        if ((obj instanceof CompletedContinuation) && ((CompletedContinuation) obj).idempotentResume != null) {
            o();
            return false;
        }
        this._decision = 0;
        this._state = d.f3607e;
        return true;
    }

    @Override // kotlinx.coroutines.n0
    public void a(@Nullable Object takenState, @NotNull Throwable cause) {
        while (true) {
            Object obj = this._state;
            if (obj instanceof t1) {
                throw new IllegalStateException("Not completed".toString());
            }
            if (obj instanceof w) {
                return;
            }
            if (obj instanceof CompletedContinuation) {
                CompletedContinuation completedContinuation = (CompletedContinuation) obj;
                if (!(!completedContinuation.c())) {
                    throw new IllegalStateException("Must be called at most once".toString());
                }
                if (kotlin.i.a(f3859l, this, obj, CompletedContinuation.b(completedContinuation, null, null, null, null, cause, 15, null))) {
                    completedContinuation.d(this, cause);
                    return;
                }
            } else if (kotlin.i.a(f3859l, this, obj, new CompletedContinuation(obj, null, null, null, cause, 14, null))) {
                return;
            }
        }
    }

    @Override // kotlinx.coroutines.n0
    @NotNull
    public final kotlin.coroutines.c<T> b() {
        return this.delegate;
    }

    @Override // kotlinx.coroutines.k
    @Nullable
    public Object c(T value, @Nullable Object idempotent) {
        return O(value, idempotent, null);
    }

    @Override // kotlinx.coroutines.n0
    @Nullable
    public Throwable d(@Nullable Object state) {
        Throwable thD = super.d(state);
        if (thD == null) {
            return null;
        }
        b();
        return thD;
    }

    @Override // kotlinx.coroutines.k
    public void e(@NotNull CoroutineDispatcher coroutineDispatcher, T t2) {
        kotlin.coroutines.c<T> cVar = this.delegate;
        kotlinx.coroutines.internal.g gVar = cVar instanceof kotlinx.coroutines.internal.g ? (kotlinx.coroutines.internal.g) cVar : null;
        L(this, t2, (gVar != null ? gVar.dispatcher : null) == coroutineDispatcher ? 4 : this.resumeMode, null, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.n0
    public <T> T f(@Nullable Object state) {
        return state instanceof CompletedContinuation ? (T) ((CompletedContinuation) state).result : state;
    }

    @Override // kotlin.coroutines.jvm.internal.c
    @Nullable
    public kotlin.coroutines.jvm.internal.c getCallerFrame() {
        kotlin.coroutines.c<T> cVar = this.delegate;
        if (cVar instanceof kotlin.coroutines.jvm.internal.c) {
            return (kotlin.coroutines.jvm.internal.c) cVar;
        }
        return null;
    }

    @Override // kotlin.coroutines.c
    @NotNull
    public CoroutineContext getContext() {
        return this.context;
    }

    @Override // kotlin.coroutines.jvm.internal.c
    @Nullable
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlinx.coroutines.n0
    @Nullable
    public Object h() {
        return get_state();
    }

    public final void j(@NotNull i handler, @Nullable Throwable cause) {
        try {
            handler.a(cause);
        } catch (Throwable th) {
            d0.a(getContext(), new CompletionHandlerException(kotlin.jvm.internal.s.m("Exception in invokeOnCancellation handler for ", this), th));
        }
    }

    public final void l(@NotNull p0.l<? super Throwable, kotlin.t> onCancellation, @NotNull Throwable cause) {
        try {
            onCancellation.invoke(cause);
        } catch (Throwable th) {
            d0.a(getContext(), new CompletionHandlerException(kotlin.jvm.internal.s.m("Exception in resume onCancellation handler for ", this), th));
        }
    }

    public boolean m(@Nullable Throwable cause) {
        Object obj;
        boolean z2;
        do {
            obj = this._state;
            if (!(obj instanceof t1)) {
                return false;
            }
            z2 = obj instanceof i;
        } while (!kotlin.i.a(f3859l, this, obj, new o(this, cause, z2)));
        i iVar = z2 ? (i) obj : null;
        if (iVar != null) {
            j(iVar, cause);
        }
        p();
        q(this.resumeMode);
        return true;
    }

    public final void o() {
        q0 q0Var = this.parentHandle;
        if (q0Var == null) {
            return;
        }
        q0Var.a();
        this.parentHandle = s1.f3893e;
    }

    @NotNull
    public Throwable r(@NotNull h1 parent) {
        return parent.t();
    }

    @Override // kotlin.coroutines.c
    public void resumeWith(@NotNull Object result) {
        L(this, z.b(result, this), this.resumeMode, null, 4, null);
    }

    @Override // kotlinx.coroutines.k
    public void s(@NotNull p0.l<? super Throwable, kotlin.t> handler) {
        i iVarA = A(handler);
        while (true) {
            Object obj = this._state;
            if (obj instanceof d) {
                if (kotlin.i.a(f3859l, this, obj, iVarA)) {
                    return;
                }
            } else if (obj instanceof i) {
                B(handler, obj);
            } else {
                boolean z2 = obj instanceof w;
                if (z2) {
                    w wVar = (w) obj;
                    if (!wVar.b()) {
                        B(handler, obj);
                    }
                    if (obj instanceof o) {
                        if (!z2) {
                            wVar = null;
                        }
                        k(handler, wVar != null ? wVar.cause : null);
                        return;
                    }
                    return;
                }
                if (obj instanceof CompletedContinuation) {
                    CompletedContinuation completedContinuation = (CompletedContinuation) obj;
                    if (completedContinuation.cancelHandler != null) {
                        B(handler, obj);
                    }
                    if (iVarA instanceof e) {
                        return;
                    }
                    if (completedContinuation.c()) {
                        k(handler, completedContinuation.cancelCause);
                        return;
                    } else {
                        if (kotlin.i.a(f3859l, this, obj, CompletedContinuation.b(completedContinuation, null, iVarA, null, null, null, 29, null))) {
                            return;
                        }
                    }
                } else {
                    if (iVarA instanceof e) {
                        return;
                    }
                    if (kotlin.i.a(f3859l, this, obj, new CompletedContinuation(obj, iVarA, null, null, null, 28, null))) {
                        return;
                    }
                }
            }
        }
    }

    @PublishedApi
    @Nullable
    public final Object t() {
        h1 h1Var;
        boolean z2 = z();
        if (P()) {
            if (this.parentHandle == null) {
                x();
            }
            if (z2) {
                I();
            }
            return kotlin.coroutines.intrinsics.b.d();
        }
        if (z2) {
            I();
        }
        Object obj = get_state();
        if (obj instanceof w) {
            throw ((w) obj).cause;
        }
        if (!o0.b(this.resumeMode) || (h1Var = (h1) getContext().get(h1.INSTANCE)) == null || h1Var.isActive()) {
            return f(obj);
        }
        CancellationException cancellationExceptionT = h1Var.t();
        a(obj, cancellationExceptionT);
        throw cancellationExceptionT;
    }

    @NotNull
    public String toString() {
        return C() + '(' + i0.c(this.delegate) + "){" + v() + "}@" + i0.b(this);
    }

    @Nullable
    /* renamed from: u, reason: from getter */
    public final Object get_state() {
        return this._state;
    }

    public void w() {
        q0 q0VarX = x();
        if (q0VarX != null && y()) {
            q0VarX.a();
            this.parentHandle = s1.f3893e;
        }
    }

    public boolean y() {
        return !(get_state() instanceof t1);
    }
}
