package kotlinx.coroutines;

import com.facebook.internal.ServerProtocol;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Interruptible.kt */
@Metadata(bv = {}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002#\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u0007B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u000eJ\u001a\u0010\u0010\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001c\u0010\u001a\u001a\n \u0017*\u0004\u0018\u00010\u00160\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lkotlinx/coroutines/a2;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlin/t;", "Lkotlinx/coroutines/CompletionHandler;", "", ServerProtocol.DIALOG_PARAM_STATE, "", "b", "(I)Ljava/lang/Void;", "d", "()V", "a", "c", "(Ljava/lang/Throwable;)V", "Lkotlinx/coroutines/h1;", "e", "Lkotlinx/coroutines/h1;", "job", "Ljava/lang/Thread;", "kotlin.jvm.PlatformType", "f", "Ljava/lang/Thread;", "targetThread", "Lkotlinx/coroutines/q0;", "g", "Lkotlinx/coroutines/q0;", "cancelHandle", "<init>", "(Lkotlinx/coroutines/h1;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
final class a2 implements p0.l<Throwable, kotlin.t> {

    /* renamed from: h, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f3538h = AtomicIntegerFieldUpdater.newUpdater(a2.class, "_state");

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final h1 job;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private q0 cancelHandle;

    @NotNull
    private volatile /* synthetic */ int _state = 0;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Thread targetThread = Thread.currentThread();

    public a2(@NotNull h1 h1Var) {
        this.job = h1Var;
    }

    private final Void b(int state) {
        throw new IllegalStateException(kotlin.jvm.internal.s.m("Illegal state ", Integer.valueOf(state)).toString());
    }

    public final void a() {
        while (true) {
            int i2 = this._state;
            if (i2 != 0) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        Thread.interrupted();
                        return;
                    } else {
                        b(i2);
                        throw new KotlinNothingValueException();
                    }
                }
            } else if (f3538h.compareAndSet(this, i2, 1)) {
                q0 q0Var = this.cancelHandle;
                if (q0Var == null) {
                    return;
                }
                q0Var.a();
                return;
            }
        }
    }

    public void c(@Nullable Throwable cause) {
        int i2;
        do {
            i2 = this._state;
            if (i2 != 0) {
                if (i2 == 1 || i2 == 2 || i2 == 3) {
                    return;
                }
                b(i2);
                throw new KotlinNothingValueException();
            }
        } while (!f3538h.compareAndSet(this, i2, 2));
        this.targetThread.interrupt();
        this._state = 3;
    }

    public final void d() {
        int i2;
        this.cancelHandle = this.job.u(true, true, this);
        do {
            i2 = this._state;
            if (i2 != 0) {
                if (i2 == 2 || i2 == 3) {
                    return;
                }
                b(i2);
                throw new KotlinNothingValueException();
            }
        } while (!f3538h.compareAndSet(this, i2, 0));
    }

    @Override // p0.l
    public /* bridge */ /* synthetic */ kotlin.t invoke(Throwable th) {
        c(th);
        return kotlin.t.f3507a;
    }
}
