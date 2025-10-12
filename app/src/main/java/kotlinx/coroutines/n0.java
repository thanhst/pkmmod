package kotlinx.coroutines;

import com.facebook.internal.ServerProtocol;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DispatchedTask.kt */
@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00060\u0002j\u0002`\u0003B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0004H ¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\bH\u0010¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000e\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0010¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0010¢\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\nJ\u001a\u0010\u0015\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\bR\u0016\u0010\u0018\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0017R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u00198 X \u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lkotlinx/coroutines/n0;", "T", "Lkotlinx/coroutines/scheduling/g;", "Lkotlinx/coroutines/SchedulerTask;", "", "h", "()Ljava/lang/Object;", "takenState", "", "cause", "Lkotlin/t;", "a", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", ServerProtocol.DIALOG_PARAM_STATE, "f", "(Ljava/lang/Object;)Ljava/lang/Object;", "d", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "run", "exception", "finallyException", "g", "", "I", "resumeMode", "Lkotlin/coroutines/c;", "b", "()Lkotlin/coroutines/c;", "delegate", "<init>", "(I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public abstract class n0<T> extends kotlinx.coroutines.scheduling.g {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public int resumeMode;

    public n0(int i2) {
        this.resumeMode = i2;
    }

    public void a(@Nullable Object takenState, @NotNull Throwable cause) {
    }

    @NotNull
    public abstract kotlin.coroutines.c<T> b();

    @Nullable
    public Throwable d(@Nullable Object state) {
        w wVar = state instanceof w ? (w) state : null;
        if (wVar == null) {
            return null;
        }
        return wVar.cause;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T f(@Nullable Object state) {
        return state;
    }

    public final void g(@Nullable Throwable th, @Nullable Throwable th2) {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            kotlin.b.a(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        kotlin.jvm.internal.s.b(th);
        d0.a(b().getContext(), new CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    @Nullable
    public abstract Object h();

    /* JADX WARN: Removed duplicated region for block: B:25:0x0081 A[Catch: all -> 0x00ae, DONT_GENERATE, TRY_LEAVE, TryCatch #3 {all -> 0x00ae, blocks: (B:3:0x0002, B:5:0x0019, B:23:0x007b, B:25:0x0081, B:33:0x00a4, B:36:0x00ad, B:35:0x00aa, B:8:0x001f, B:10:0x002d, B:12:0x0035, B:15:0x0041, B:17:0x0047, B:21:0x0077, B:19:0x005e, B:20:0x006c), top: B:50:0x0002, inners: #0 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            r10 = this;
            kotlinx.coroutines.scheduling.h r0 = r10.taskContext
            kotlin.coroutines.c r1 = r10.b()     // Catch: java.lang.Throwable -> Lae
            kotlinx.coroutines.internal.g r1 = (kotlinx.coroutines.internal.g) r1     // Catch: java.lang.Throwable -> Lae
            kotlin.coroutines.c<T> r2 = r1.continuation     // Catch: java.lang.Throwable -> Lae
            java.lang.Object r1 = r1.countOrElement     // Catch: java.lang.Throwable -> Lae
            kotlin.coroutines.CoroutineContext r3 = r2.getContext()     // Catch: java.lang.Throwable -> Lae
            java.lang.Object r1 = kotlinx.coroutines.internal.ThreadContextKt.c(r3, r1)     // Catch: java.lang.Throwable -> Lae
            kotlinx.coroutines.internal.d0 r4 = kotlinx.coroutines.internal.ThreadContextKt.f3793a     // Catch: java.lang.Throwable -> Lae
            r5 = 0
            if (r1 == r4) goto L1e
            kotlinx.coroutines.d2 r4 = kotlinx.coroutines.CoroutineContextKt.f(r2, r3, r1)     // Catch: java.lang.Throwable -> Lae
            goto L1f
        L1e:
            r4 = r5
        L1f:
            kotlin.coroutines.CoroutineContext r6 = r2.getContext()     // Catch: java.lang.Throwable -> La1
            java.lang.Object r7 = r10.h()     // Catch: java.lang.Throwable -> La1
            java.lang.Throwable r8 = r10.d(r7)     // Catch: java.lang.Throwable -> La1
            if (r8 != 0) goto L3e
            int r9 = r10.resumeMode     // Catch: java.lang.Throwable -> La1
            boolean r9 = kotlinx.coroutines.o0.b(r9)     // Catch: java.lang.Throwable -> La1
            if (r9 == 0) goto L3e
            kotlinx.coroutines.h1$b r9 = kotlinx.coroutines.h1.INSTANCE     // Catch: java.lang.Throwable -> La1
            kotlin.coroutines.CoroutineContext$a r6 = r6.get(r9)     // Catch: java.lang.Throwable -> La1
            kotlinx.coroutines.h1 r6 = (kotlinx.coroutines.h1) r6     // Catch: java.lang.Throwable -> La1
            goto L3f
        L3e:
            r6 = r5
        L3f:
            if (r6 == 0) goto L5c
            boolean r9 = r6.isActive()     // Catch: java.lang.Throwable -> La1
            if (r9 != 0) goto L5c
            java.util.concurrent.CancellationException r6 = r6.t()     // Catch: java.lang.Throwable -> La1
            r10.a(r7, r6)     // Catch: java.lang.Throwable -> La1
            kotlin.Result$a r7 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> La1
            java.lang.Object r6 = kotlin.h.a(r6)     // Catch: java.lang.Throwable -> La1
            java.lang.Object r6 = kotlin.Result.m158constructorimpl(r6)     // Catch: java.lang.Throwable -> La1
            r2.resumeWith(r6)     // Catch: java.lang.Throwable -> La1
            goto L77
        L5c:
            if (r8 == 0) goto L6c
            kotlin.Result$a r6 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> La1
            java.lang.Object r6 = kotlin.h.a(r8)     // Catch: java.lang.Throwable -> La1
            java.lang.Object r6 = kotlin.Result.m158constructorimpl(r6)     // Catch: java.lang.Throwable -> La1
            r2.resumeWith(r6)     // Catch: java.lang.Throwable -> La1
            goto L77
        L6c:
            java.lang.Object r6 = r10.f(r7)     // Catch: java.lang.Throwable -> La1
            java.lang.Object r6 = kotlin.Result.m158constructorimpl(r6)     // Catch: java.lang.Throwable -> La1
            r2.resumeWith(r6)     // Catch: java.lang.Throwable -> La1
        L77:
            kotlin.t r2 = kotlin.t.f3507a     // Catch: java.lang.Throwable -> La1
            if (r4 == 0) goto L81
            boolean r2 = r4.P0()     // Catch: java.lang.Throwable -> Lae
            if (r2 == 0) goto L84
        L81:
            kotlinx.coroutines.internal.ThreadContextKt.a(r3, r1)     // Catch: java.lang.Throwable -> Lae
        L84:
            r0.a()     // Catch: java.lang.Throwable -> L8e
            kotlin.t r0 = kotlin.t.f3507a     // Catch: java.lang.Throwable -> L8e
            java.lang.Object r0 = kotlin.Result.m158constructorimpl(r0)     // Catch: java.lang.Throwable -> L8e
            goto L99
        L8e:
            r0 = move-exception
            kotlin.Result$a r1 = kotlin.Result.INSTANCE
            java.lang.Object r0 = kotlin.h.a(r0)
            java.lang.Object r0 = kotlin.Result.m158constructorimpl(r0)
        L99:
            java.lang.Throwable r0 = kotlin.Result.m161exceptionOrNullimpl(r0)
            r10.g(r5, r0)
            goto Lcd
        La1:
            r2 = move-exception
            if (r4 == 0) goto Laa
            boolean r4 = r4.P0()     // Catch: java.lang.Throwable -> Lae
            if (r4 == 0) goto Lad
        Laa:
            kotlinx.coroutines.internal.ThreadContextKt.a(r3, r1)     // Catch: java.lang.Throwable -> Lae
        Lad:
            throw r2     // Catch: java.lang.Throwable -> Lae
        Lae:
            r1 = move-exception
            kotlin.Result$a r2 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> Lbb
            r0.a()     // Catch: java.lang.Throwable -> Lbb
            kotlin.t r0 = kotlin.t.f3507a     // Catch: java.lang.Throwable -> Lbb
            java.lang.Object r0 = kotlin.Result.m158constructorimpl(r0)     // Catch: java.lang.Throwable -> Lbb
            goto Lc6
        Lbb:
            r0 = move-exception
            kotlin.Result$a r2 = kotlin.Result.INSTANCE
            java.lang.Object r0 = kotlin.h.a(r0)
            java.lang.Object r0 = kotlin.Result.m158constructorimpl(r0)
        Lc6:
            java.lang.Throwable r0 = kotlin.Result.m161exceptionOrNullimpl(r0)
            r10.g(r1, r0)
        Lcd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.n0.run():void");
    }
}
