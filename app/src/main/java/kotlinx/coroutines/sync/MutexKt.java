package kotlinx.coroutines.sync;

import com.facebook.internal.NativeProtocol;
import kotlin.Metadata;
import kotlinx.coroutines.internal.d0;
import org.jetbrains.annotations.NotNull;

/* compiled from: Mutex.kt */
@Metadata(bv = {}, d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aD\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0086Hø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\u0006\u0010\u0007\"\u001a\u0010\r\u001a\u00020\b8\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u0012\u0004\b\u000b\u0010\f\"\u001a\u0010\u0010\u001a\u00020\b8\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u000e\u0010\n\u0012\u0004\b\u000f\u0010\f\"\u001a\u0010\u0013\u001a\u00020\b8\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0011\u0010\n\u0012\u0004\b\u0012\u0010\f\"\u001a\u0010\u0016\u001a\u00020\b8\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0014\u0010\n\u0012\u0004\b\u0015\u0010\f\"\u001a\u0010\u001b\u001a\u00020\u00178\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u0012\u0004\b\u001a\u0010\f\"\u001a\u0010\u001d\u001a\u00020\u00178\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u0012\u0004\b\u001c\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"T", "Lkotlinx/coroutines/sync/c;", "", "owner", "Lkotlin/Function0;", NativeProtocol.WEB_DIALOG_ACTION, "f", "(Lkotlinx/coroutines/sync/c;Ljava/lang/Object;Lp0/a;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/d0;", "a", "Lkotlinx/coroutines/internal/d0;", "getLOCK_FAIL$annotations", "()V", "LOCK_FAIL", "b", "getUNLOCK_FAIL$annotations", "UNLOCK_FAIL", "c", "getLOCKED$annotations", "LOCKED", "d", "getUNLOCKED$annotations", "UNLOCKED", "Lkotlinx/coroutines/sync/b;", "e", "Lkotlinx/coroutines/sync/b;", "getEMPTY_LOCKED$annotations", "EMPTY_LOCKED", "getEMPTY_UNLOCKED$annotations", "EMPTY_UNLOCKED", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class MutexKt {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final d0 f3969a = new d0("LOCK_FAIL");

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final d0 f3970b = new d0("UNLOCK_FAIL");

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final d0 f3971c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final d0 f3972d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final b f3973e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final b f3974f;

    static {
        d0 d0Var = new d0("LOCKED");
        f3971c = d0Var;
        d0 d0Var2 = new d0("UNLOCKED");
        f3972d = d0Var2;
        f3973e = new b(d0Var);
        f3974f = new b(d0Var2);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object f(@org.jetbrains.annotations.NotNull kotlinx.coroutines.sync.c r4, @org.jetbrains.annotations.Nullable java.lang.Object r5, @org.jetbrains.annotations.NotNull p0.a<? extends T> r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super T> r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.sync.MutexKt$withLock$1
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.sync.MutexKt$withLock$1 r0 = (kotlinx.coroutines.sync.MutexKt$withLock$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.sync.MutexKt$withLock$1 r0 = new kotlinx.coroutines.sync.MutexKt$withLock$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r4 = r0.L$2
            r6 = r4
            p0.a r6 = (p0.a) r6
            java.lang.Object r5 = r0.L$1
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.sync.c r4 = (kotlinx.coroutines.sync.c) r4
            kotlin.h.b(r7)
            goto L4e
        L34:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3c:
            kotlin.h.b(r7)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.L$2 = r6
            r0.label = r3
            java.lang.Object r7 = r4.a(r5, r0)
            if (r7 != r1) goto L4e
            return r1
        L4e:
            java.lang.Object r6 = r6.invoke()     // Catch: java.lang.Throwable -> L5c
            kotlin.jvm.internal.q.b(r3)
            r4.b(r5)
            kotlin.jvm.internal.q.a(r3)
            return r6
        L5c:
            r6 = move-exception
            kotlin.jvm.internal.q.b(r3)
            r4.b(r5)
            kotlin.jvm.internal.q.a(r3)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.MutexKt.f(kotlinx.coroutines.sync.c, java.lang.Object, p0.a, kotlin.coroutines.c):java.lang.Object");
    }
}
