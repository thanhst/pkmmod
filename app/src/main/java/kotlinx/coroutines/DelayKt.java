package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Delay.kt */
@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0013\u0010\u0001\u001a\u00020\u0000H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u001b\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0019\u0010\t\u001a\u00020\u0003*\u00020\bH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\n\"\u0018\u0010\u000f\u001a\u00020\f*\u00020\u000b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0010"}, d2 = {"", "a", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "timeMillis", "Lkotlin/t;", "b", "(JLkotlin/coroutines/c;)Ljava/lang/Object;", "Lt0/a;", "d", "(J)J", "Lkotlin/coroutines/CoroutineContext;", "Lkotlinx/coroutines/l0;", "c", "(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/l0;", "delay", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class DelayKt {
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(@org.jetbrains.annotations.NotNull kotlin.coroutines.c<?> r4) {
        /*
            boolean r0 = r4 instanceof kotlinx.coroutines.DelayKt$awaitCancellation$1
            if (r0 == 0) goto L13
            r0 = r4
            kotlinx.coroutines.DelayKt$awaitCancellation$1 r0 = (kotlinx.coroutines.DelayKt$awaitCancellation$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.DelayKt$awaitCancellation$1 r0 = new kotlinx.coroutines.DelayKt$awaitCancellation$1
            r0.<init>(r4)
        L18:
            java.lang.Object r4 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 == r3) goto L2d
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r0)
            throw r4
        L2d:
            kotlin.h.b(r4)
            goto L52
        L31:
            kotlin.h.b(r4)
            r0.label = r3
            kotlinx.coroutines.l r4 = new kotlinx.coroutines.l
            kotlin.coroutines.c r2 = kotlin.coroutines.intrinsics.a.c(r0)
            r4.<init>(r2, r3)
            r4.w()
            java.lang.Object r4 = r4.t()
            java.lang.Object r2 = kotlin.coroutines.intrinsics.a.d()
            if (r4 != r2) goto L4f
            kotlin.coroutines.jvm.internal.e.c(r0)
        L4f:
            if (r4 != r1) goto L52
            return r1
        L52:
            kotlin.KotlinNothingValueException r4 = new kotlin.KotlinNothingValueException
            r4.<init>()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.DelayKt.a(kotlin.coroutines.c):java.lang.Object");
    }

    @Nullable
    public static final Object b(long j2, @NotNull kotlin.coroutines.c<? super kotlin.t> cVar) {
        if (j2 <= 0) {
            return kotlin.t.f3507a;
        }
        l lVar = new l(IntrinsicsKt__IntrinsicsJvmKt.c(cVar), 1);
        lVar.w();
        if (j2 < Long.MAX_VALUE) {
            c(lVar.getContext()).e(j2, lVar);
        }
        Object objT = lVar.t();
        if (objT == kotlin.coroutines.intrinsics.b.d()) {
            kotlin.coroutines.jvm.internal.e.c(cVar);
        }
        return objT == kotlin.coroutines.intrinsics.b.d() ? objT : kotlin.t.f3507a;
    }

    @NotNull
    public static final l0 c(@NotNull CoroutineContext coroutineContext) {
        CoroutineContext.a aVar = coroutineContext.get(kotlin.coroutines.d.INSTANCE);
        l0 l0Var = aVar instanceof l0 ? (l0) aVar : null;
        return l0Var == null ? k0.a() : l0Var;
    }

    public static final long d(long j2) {
        if (t0.a.d(j2, t0.a.INSTANCE.a()) > 0) {
            return s0.l.b(t0.a.k(j2), 1L);
        }
        return 0L;
    }
}
