package kotlinx.coroutines.sync;

import com.facebook.internal.NativeProtocol;
import kotlin.Metadata;
import kotlinx.coroutines.internal.d0;
import kotlinx.coroutines.internal.g0;
import p0.a_p0;

import org.jetbrains.annotations.NotNull;

/* compiled from: Semaphore.kt */
@Metadata(bv = {}, d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\u001a8\u0010\u0004\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086Hø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001a\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002\"\u001a\u0010\u0010\u001a\u00020\u000b8\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u0012\u0004\b\u000e\u0010\u000f\"\u001a\u0010\u0015\u001a\u00020\u00118\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u0012\u0004\b\u0014\u0010\u000f\"\u001a\u0010\u0018\u001a\u00020\u00118\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u0012\u0004\b\u0017\u0010\u000f\"\u001a\u0010\u001b\u001a\u00020\u00118\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0013\u0012\u0004\b\u001a\u0010\u000f\"\u001a\u0010\u001e\u001a\u00020\u00118\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0013\u0012\u0004\b\u001d\u0010\u000f\"\u001a\u0010!\u001a\u00020\u000b8\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u001f\u0010\r\u0012\u0004\b \u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"T", "Lkotlinx/coroutines/sync/d;", "Lkotlin/Function0;", NativeProtocol.WEB_DIALOG_ACTION, "i", "(Lkotlinx/coroutines/sync/d;Lp0/a;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "id", "Lkotlinx/coroutines/sync/f;", "prev", "h", "", "a", "I", "getMAX_SPIN_CYCLES$annotations", "()V", "MAX_SPIN_CYCLES", "Lkotlinx/coroutines/internal/d0;", "b", "Lkotlinx/coroutines/internal/d0;", "getPERMIT$annotations", "PERMIT", "c", "getTAKEN$annotations", "TAKEN", "d", "getBROKEN$annotations", "BROKEN", "e", "getCANCELLED$annotations", "CANCELLED", "f", "getSEGMENT_SIZE$annotations", "SEGMENT_SIZE", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class SemaphoreKt {

    /* renamed from: a, reason: collision with root package name */
    private static final int f3975a = g0.d("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final d0 f3976b = new d0("PERMIT");

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final d0 f3977c = new d0("TAKEN");

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final d0 f3978d = new d0("BROKEN");

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final d0 f3979e = new d0("CANCELLED");

    /* renamed from: f, reason: collision with root package name */
    private static final int f3980f = g0.d("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final f h(long j2, f fVar) {
        return new f(j2, fVar, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object i(@org.jetbrains.annotations.NotNull kotlinx.coroutines.sync.d r4, @org.jetbrains.annotations.NotNull a_p0<? extends T> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super T> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.sync.SemaphoreKt$withPermit$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.sync.SemaphoreKt$withPermit$1 r0 = (kotlinx.coroutines.sync.SemaphoreKt$withPermit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.sync.SemaphoreKt$withPermit$1 r0 = new kotlinx.coroutines.sync.SemaphoreKt$withPermit$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r4 = r0.L$1
            r5 = r4
            p0.a r5 = (p0.a) r5
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.sync.d r4 = (kotlinx.coroutines.sync.d) r4
            kotlin.h.b(r6)
            goto L4a
        L32:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3a:
            kotlin.h.b(r6)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = r4.a(r0)
            if (r6 != r1) goto L4a
            return r1
        L4a:
            java.lang.Object r5 = r5.invoke()     // Catch: java.lang.Throwable -> L58
            kotlin.jvm.internal.q.b(r3)
            r4.release()
            kotlin.jvm.internal.q.a(r3)
            return r5
        L58:
            r5 = move-exception
            kotlin.jvm.internal.q.b(r3)
            r4.release()
            kotlin.jvm.internal.q.a(r3)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.SemaphoreKt.i(kotlinx.coroutines.sync.d, p0.a, kotlin.coroutines.c):java.lang.Object");
    }
}
