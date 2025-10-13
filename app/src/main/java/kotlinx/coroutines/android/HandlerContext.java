package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import kotlin.t;
import kotlinx.coroutines.k;
import kotlinx.coroutines.k1;
import kotlinx.coroutines.p0;
import kotlinx.coroutines.q0;
import kotlinx.coroutines.s1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s0.l_s0;

/* compiled from: HandlerDispatcher.kt */
@Metadata(bv = {}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B#\b\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010#\u001a\u00020\n¢\u0006\u0004\b*\u0010+B\u001d\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b*\u0010,J\u001c\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001c\u0010\f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006H\u0016J\u001e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u000fH\u0016J$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\r2\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0013\u0010\u0018\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0016R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u0004\u0018\u00010\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u001fR\u0014\u0010#\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010$\u001a\u0004\u0018\u00010\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u001a\u0010)\u001a\u00020\u00008\u0016X\u0096\u0004¢\u0006\f\n\u0004\b&\u0010%\u001a\u0004\b'\u0010(¨\u0006-"}, d2 = {"Lkotlinx/coroutines/android/HandlerContext;", "Lkotlinx/coroutines/android/b;", "Lkotlinx/coroutines/l0;", "Lkotlin/coroutines/CoroutineContext;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lkotlin/t;", "y", "", "k", "g", "", "timeMillis", "Lkotlinx/coroutines/k;", "continuation", "e", "Lkotlinx/coroutines/q0;", "c", "", "toString", "", "other", "equals", "", "hashCode", "Landroid/os/Handler;", "f", "Landroid/os/Handler;", "handler", "Ljava/lang/String;", "name", "h", "Z", "invokeImmediately", "_immediate", "Lkotlinx/coroutines/android/HandlerContext;", "i", "z", "()Lkotlinx/coroutines/android/HandlerContext;", "immediate", "<init>", "(Landroid/os/Handler;Ljava/lang/String;Z)V", "(Landroid/os/Handler;Ljava/lang/String;)V", "kotlinx-coroutines-android"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class HandlerContext extends b {

    @Nullable
    private volatile HandlerContext _immediate;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler handler;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String name;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final boolean invokeImmediately;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HandlerContext immediate;

    /* compiled from: Runnable.kt */
    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lkotlin/t;", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    public static final class a implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ k f3546e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ HandlerContext f3547f;

        public a(k kVar, HandlerContext handlerContext) {
            this.f3546e = kVar;
            this.f3547f = handlerContext;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f3546e.e(this.f3547f, t.f3507a);
        }
    }

    private HandlerContext(Handler handler, String str, boolean z2) {
        super(null);
        this.handler = handler;
        this.name = str;
        this.invokeImmediately = z2;
        this._immediate = z2 ? this : null;
        HandlerContext handlerContext = this._immediate;
        if (handlerContext == null) {
            handlerContext = new HandlerContext(handler, str, true);
            this._immediate = handlerContext;
        }
        this.immediate = handlerContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(HandlerContext handlerContext, Runnable runnable) {
        handlerContext.handler.removeCallbacks(runnable);
    }

    private final void y(CoroutineContext coroutineContext, Runnable runnable) {
        k1.c(coroutineContext, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        p0.b().g(coroutineContext, runnable);
    }

    @Override // kotlinx.coroutines.android.b, kotlinx.coroutines.l0
    @NotNull
    public q0 c(long timeMillis, @NotNull final Runnable block, @NotNull CoroutineContext context) {
        if (this.handler.postDelayed(block, l_s0.d(timeMillis, 4611686018427387903L))) {
            return new q0() { // from class: kotlinx.coroutines.android.a
                @Override // kotlinx.coroutines.q0
                public final void a() {
                    HandlerContext.B(this.f3548e, block);
                }
            };
        }
        y(context, block);
        return s1.f3893e;
    }

    @Override // kotlinx.coroutines.l0
    public void e(long j2, @NotNull k<? super t> kVar) {
        final a aVar = new a(kVar, this);
        if (this.handler.postDelayed(aVar, l_s0.d(j2, 4611686018427387903L))) {
            kVar.s(new p0.l<Throwable, t>() { // from class: kotlinx.coroutines.android.HandlerContext$scheduleResumeAfterDelay$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // p0.l
                public /* bridge */ /* synthetic */ t invoke(Throwable th) {
                    invoke2(th);
                    return t.f3507a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Throwable th) {
                    this.this$0.handler.removeCallbacks(aVar);
                }
            });
        } else {
            y(kVar.getContext(), aVar);
        }
    }

    public boolean equals(@Nullable Object other) {
        return (other instanceof HandlerContext) && ((HandlerContext) other).handler == this.handler;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void g(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        if (this.handler.post(runnable)) {
            return;
        }
        y(coroutineContext, runnable);
    }

    public int hashCode() {
        return System.identityHashCode(this.handler);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean k(@NotNull CoroutineContext context) {
        return (this.invokeImmediately && s.a(Looper.myLooper(), this.handler.getLooper())) ? false : true;
    }

    @Override // kotlinx.coroutines.q1, kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public String toString() {
        String strS = s();
        if (strS != null) {
            return strS;
        }
        String string = this.name;
        if (string == null) {
            string = this.handler.toString();
        }
        return this.invokeImmediately ? s.m(string, ".immediate") : string;
    }

    @Override // kotlinx.coroutines.q1
    @NotNull
    /* renamed from: z, reason: from getter and merged with bridge method [inline-methods] */
    public HandlerContext q() {
        return this.immediate;
    }

    public /* synthetic */ HandlerContext(Handler handler, String str, int i2, o oVar) {
        this(handler, (i2 & 2) != 0 ? null : str);
    }

    public HandlerContext(@NotNull Handler handler, @Nullable String str) {
        this(handler, str, false);
    }
}
