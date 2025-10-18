package kotlin.sequences;

import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p0.p_p0;
import p0.q_p0;

/* compiled from: _Sequences.kt */
@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u0002H\u008a@"}, d2 = {"T", "R", "Lkotlin/sequences/f;", "Lkotlin/t;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "kotlin.sequences.SequencesKt___SequencesKt$runningFoldIndexed$1", f = "_Sequences.kt", i = {0, 1, 1, 1}, l = {2314, 2319}, m = "invokeSuspend", n = {"$this$sequence", "$this$sequence", "accumulator", "index"}, s = {"L$0", "L$0", "L$1", "I$0"})
/* loaded from: classes.dex */
final class SequencesKt___SequencesKt$runningFoldIndexed$1 extends RestrictedSuspendLambda implements p_p0<f<Object>, c<? super t>, Object> {
    final /* synthetic */ Object $initial;
    final /* synthetic */ q_p0<Integer, Object, Object, Object> $operation;
    final /* synthetic */ d<Object> $this_runningFoldIndexed;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SequencesKt___SequencesKt$runningFoldIndexed$1(Object obj, d<Object> dVar, q_p0<? super Integer, Object, Object, Object> qP0Var, kotlin.coroutines.c<? super SequencesKt___SequencesKt$runningFoldIndexed$1> cVar) {
        super(2, cVar);
        this.$initial = obj;
        this.$this_runningFoldIndexed = dVar;
        this.$operation = qP0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final kotlin.coroutines.c<t> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
        SequencesKt___SequencesKt$runningFoldIndexed$1 sequencesKt___SequencesKt$runningFoldIndexed$1 = new SequencesKt___SequencesKt$runningFoldIndexed$1(this.$initial, this.$this_runningFoldIndexed, this.$operation, cVar);
        sequencesKt___SequencesKt$runningFoldIndexed$1.L$0 = obj;
        return sequencesKt___SequencesKt$runningFoldIndexed$1;
    }

    @Override // p0.p
    @Nullable
    public final Object invoke(@NotNull f<Object> fVar, @Nullable kotlin.coroutines.c<? super t> cVar) {
        return ((SequencesKt___SequencesKt$runningFoldIndexed$1) create(fVar, cVar)).invokeSuspend(t.f3507a);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0058  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.a.d()
            int r1 = r9.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L30
            if (r1 == r3) goto L28
            if (r1 != r2) goto L20
            int r1 = r9.I$0
            java.lang.Object r3 = r9.L$2
            java.util.Iterator r3 = (java.util.Iterator) r3
            java.lang.Object r4 = r9.L$1
            java.lang.Object r5 = r9.L$0
            kotlin.sequences.f r5 = (kotlin.sequences.f) r5
            kotlin.h.b(r10)
            r10 = r1
            r1 = r4
            goto L51
        L20:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L28:
            java.lang.Object r1 = r9.L$0
            kotlin.sequences.f r1 = (kotlin.sequences.f) r1
            kotlin.h.b(r10)
            goto L45
        L30:
            kotlin.h.b(r10)
            java.lang.Object r10 = r9.L$0
            r1 = r10
            kotlin.sequences.f r1 = (kotlin.sequences.f) r1
            java.lang.Object r10 = r9.$initial
            r9.L$0 = r1
            r9.label = r3
            java.lang.Object r10 = r1.a(r10, r9)
            if (r10 != r0) goto L45
            return r0
        L45:
            r10 = 0
            java.lang.Object r3 = r9.$initial
            kotlin.sequences.d<java.lang.Object> r4 = r9.$this_runningFoldIndexed
            java.util.Iterator r4 = r4.iterator()
            r5 = r1
            r1 = r3
            r3 = r4
        L51:
            r4 = r9
        L52:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L81
            java.lang.Object r6 = r3.next()
            p0.q<java.lang.Integer, java.lang.Object, java.lang.Object, java.lang.Object> r7 = r4.$operation
            int r8 = r10 + 1
            if (r10 >= 0) goto L65
            kotlin.collections.s.n()
        L65:
            java.lang.Integer r10 = kotlin.coroutines.jvm.internal.a.b(r10)
            java.lang.Object r10 = r7.invoke(r10, r1, r6)
            r4.L$0 = r5
            r4.L$1 = r10
            r4.L$2 = r3
            r4.I$0 = r8
            r4.label = r2
            java.lang.Object r1 = r5.a(r10, r4)
            if (r1 != r0) goto L7e
            return r0
        L7e:
            r1 = r10
            r10 = r8
            goto L52
        L81:
            kotlin.t r10 = kotlin.t.f3507a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.SequencesKt___SequencesKt$runningFoldIndexed$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
