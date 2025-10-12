package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JobSupport.kt */
@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlin/sequences/f;", "Lkotlinx/coroutines/h1;", "Lkotlin/t;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.coroutines.JobSupport$children$1", f = "JobSupport.kt", i = {1, 1, 1}, l = {952, 954}, m = "invokeSuspend", n = {"$this$sequence", "this_$iv", "cur$iv"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes.dex */
final class JobSupport$children$1 extends RestrictedSuspendLambda implements p0.p<kotlin.sequences.f<? super h1>, kotlin.coroutines.c<? super kotlin.t>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ n1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    JobSupport$children$1(n1 n1Var, kotlin.coroutines.c<? super JobSupport$children$1> cVar) {
        super(2, cVar);
        this.this$0 = n1Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final kotlin.coroutines.c<kotlin.t> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
        JobSupport$children$1 jobSupport$children$1 = new JobSupport$children$1(this.this$0, cVar);
        jobSupport$children$1.L$0 = obj;
        return jobSupport$children$1;
    }

    @Override // p0.p
    @Nullable
    public final Object invoke(@NotNull kotlin.sequences.f<? super h1> fVar, @Nullable kotlin.coroutines.c<? super kotlin.t> cVar) {
        return ((JobSupport$children$1) create(fVar, cVar)).invokeSuspend(kotlin.t.f3507a);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0067  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0069 -> B:28:0x007f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x007c -> B:28:0x007f). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.a.d()
            int r1 = r7.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L2b
            if (r1 == r3) goto L27
            if (r1 != r2) goto L1f
            java.lang.Object r1 = r7.L$2
            kotlinx.coroutines.internal.LockFreeLinkedListNode r1 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r1
            java.lang.Object r3 = r7.L$1
            kotlinx.coroutines.internal.n r3 = (kotlinx.coroutines.internal.n) r3
            java.lang.Object r4 = r7.L$0
            kotlin.sequences.f r4 = (kotlin.sequences.f) r4
            kotlin.h.b(r8)
            r8 = r7
            goto L7f
        L1f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L27:
            kotlin.h.b(r8)
            goto L84
        L2b:
            kotlin.h.b(r8)
            java.lang.Object r8 = r7.L$0
            kotlin.sequences.f r8 = (kotlin.sequences.f) r8
            kotlinx.coroutines.n1 r1 = r7.this$0
            java.lang.Object r1 = r1.f0()
            boolean r4 = r1 instanceof kotlinx.coroutines.r
            if (r4 == 0) goto L49
            kotlinx.coroutines.r r1 = (kotlinx.coroutines.r) r1
            kotlinx.coroutines.s r1 = r1.childJob
            r7.label = r3
            java.lang.Object r8 = r8.a(r1, r7)
            if (r8 != r0) goto L84
            return r0
        L49:
            boolean r3 = r1 instanceof kotlinx.coroutines.b1
            if (r3 == 0) goto L84
            kotlinx.coroutines.b1 r1 = (kotlinx.coroutines.b1) r1
            kotlinx.coroutines.r1 r1 = r1.getList()
            if (r1 != 0) goto L56
            goto L84
        L56:
            java.lang.Object r3 = r1.B()
            kotlinx.coroutines.internal.LockFreeLinkedListNode r3 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r3
            r4 = r8
            r8 = r7
            r6 = r3
            r3 = r1
            r1 = r6
        L61:
            boolean r5 = kotlin.jvm.internal.s.a(r1, r3)
            if (r5 != 0) goto L84
            boolean r5 = r1 instanceof kotlinx.coroutines.r
            if (r5 == 0) goto L7f
            r5 = r1
            kotlinx.coroutines.r r5 = (kotlinx.coroutines.r) r5
            kotlinx.coroutines.s r5 = r5.childJob
            r8.L$0 = r4
            r8.L$1 = r3
            r8.L$2 = r1
            r8.label = r2
            java.lang.Object r5 = r4.a(r5, r8)
            if (r5 != r0) goto L7f
            return r0
        L7f:
            kotlinx.coroutines.internal.LockFreeLinkedListNode r1 = r1.C()
            goto L61
        L84:
            kotlin.t r8 = kotlin.t.f3507a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport$children$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
