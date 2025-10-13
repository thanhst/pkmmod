package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.t;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.s;
import kotlinx.coroutines.g0;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.l1;
import kotlinx.coroutines.u;
import p0.l_p0;
import p0.p_p0;
import p0.q_p0;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Combine.kt */
@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"T1", "T2", "R", "Lkotlinx/coroutines/g0;", "Lkotlin/t;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1", f = "Combine.kt", i = {0}, l = {129}, m = "invokeSuspend", n = {"second"}, s = {"L$0"})
/* loaded from: classes.dex */
final class CombineKt$zipImpl$1$1 extends SuspendLambda implements p_p0<g0, c<? super t>, Object> {
    final /* synthetic */ kotlinx.coroutines.flow.d<Object> $flow;
    final /* synthetic */ kotlinx.coroutines.flow.d<Object> $flow2;
    final /* synthetic */ kotlinx.coroutines.flow.e<Object> $this_unsafeFlow;
    final /* synthetic */ q_p0<Object, Object, c<Object>, Object> $transform;
    private /* synthetic */ Object L$0;
    int label;

    /* compiled from: Combine.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u008a@"}, d2 = {"T1", "T2", "R", "Lkotlin/t;", "it", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2", f = "Combine.kt", i = {}, l = {130}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements p_p0<t, c<? super t>, Object> {
        final /* synthetic */ Object $cnt;
        final /* synthetic */ kotlinx.coroutines.flow.d<Object> $flow;
        final /* synthetic */ CoroutineContext $scopeContext;
        final /* synthetic */ ReceiveChannel<Object> $second;
        final /* synthetic */ kotlinx.coroutines.flow.e<Object> $this_unsafeFlow;
        final /* synthetic */ q_p0<Object, Object, c<Object>, Object> $transform;
        int label;

        /* compiled from: Combine.kt */
        @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T1", "T2", "R", "value", "Lkotlin/t;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
        /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1, reason: invalid class name */
        static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.e {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ CoroutineContext f3741e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ Object f3742f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ ReceiveChannel<Object> f3743g;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.e<Object> f3744h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ q_p0<Object, Object, c<Object>, Object> f3745i;

            /* compiled from: Combine.kt */
            @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u008a@"}, d2 = {"T1", "T2", "R", "Lkotlin/t;", "it", "<anonymous>"}, k = 3, mv = {1, 6, 0})
            @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$1", f = "Combine.kt", i = {}, l = {132, 135, 135}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$1, reason: invalid class name and collision with other inner class name */
            static final class C00631 extends SuspendLambda implements p_p0<t, c<? super t>, Object> {
                final /* synthetic */ ReceiveChannel<Object> $second;
                final /* synthetic */ kotlinx.coroutines.flow.e<Object> $this_unsafeFlow;
                final /* synthetic */ q_p0<Object, Object, c<Object>, Object> $transform;
                final /* synthetic */ Object $value;
                Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C00631(ReceiveChannel<? extends Object> receiveChannel, kotlinx.coroutines.flow.e<Object> eVar, q_p0<Object, Object, ? super c<Object>, ? extends Object> qP0Var, Object obj, kotlin.coroutines.c<? super C00631> cVar) {
                    super(2, cVar);
                    this.$second = receiveChannel;
                    this.$this_unsafeFlow = eVar;
                    this.$transform = qP0Var;
                    this.$value = obj;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final kotlin.coroutines.c<t> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
                    return new C00631(this.$second, this.$this_unsafeFlow, this.$transform, this.$value, cVar);
                }

                @Override // p0.p
                @Nullable
                public final Object invoke(@NotNull t tVar, @Nullable kotlin.coroutines.c<? super t> cVar) {
                    return ((C00631) create(tVar, cVar)).invokeSuspend(t.f3507a);
                }

                /* JADX WARN: Removed duplicated region for block: B:29:0x006e A[RETURN] */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r9) throws java.lang.Throwable {
                    /*
                        r8 = this;
                        java.lang.Object r0 = kotlin.coroutines.intrinsics.a.d()
                        int r1 = r8.label
                        r2 = 0
                        r3 = 3
                        r4 = 2
                        r5 = 1
                        if (r1 == 0) goto L30
                        if (r1 == r5) goto L26
                        if (r1 == r4) goto L1e
                        if (r1 != r3) goto L16
                        kotlin.h.b(r9)
                        goto L6f
                    L16:
                        java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r9.<init>(r0)
                        throw r9
                    L1e:
                        java.lang.Object r1 = r8.L$0
                        kotlinx.coroutines.flow.e r1 = (kotlinx.coroutines.flow.e) r1
                        kotlin.h.b(r9)
                        goto L64
                    L26:
                        kotlin.h.b(r9)
                        kotlinx.coroutines.channels.h r9 = (kotlinx.coroutines.channels.h) r9
                        java.lang.Object r9 = r9.getHolder()
                        goto L3e
                    L30:
                        kotlin.h.b(r9)
                        kotlinx.coroutines.channels.ReceiveChannel<java.lang.Object> r9 = r8.$second
                        r8.label = r5
                        java.lang.Object r9 = r9.z(r8)
                        if (r9 != r0) goto L3e
                        return r0
                    L3e:
                        kotlinx.coroutines.flow.e<java.lang.Object> r1 = r8.$this_unsafeFlow
                        boolean r5 = r9 instanceof kotlinx.coroutines.channels.h.c
                        if (r5 == 0) goto L50
                        java.lang.Throwable r9 = kotlinx.coroutines.channels.h.e(r9)
                        if (r9 != 0) goto L4f
                        kotlinx.coroutines.flow.internal.AbortFlowException r9 = new kotlinx.coroutines.flow.internal.AbortFlowException
                        r9.<init>(r1)
                    L4f:
                        throw r9
                    L50:
                        p0.q<java.lang.Object, java.lang.Object, kotlin.coroutines.c<java.lang.Object>, java.lang.Object> r5 = r8.$transform
                        java.lang.Object r6 = r8.$value
                        kotlinx.coroutines.internal.d0 r7 = kotlinx.coroutines.flow.internal.n.f3761a
                        if (r9 != r7) goto L59
                        r9 = r2
                    L59:
                        r8.L$0 = r1
                        r8.label = r4
                        java.lang.Object r9 = r5.invoke(r6, r9, r8)
                        if (r9 != r0) goto L64
                        return r0
                    L64:
                        r8.L$0 = r2
                        r8.label = r3
                        java.lang.Object r9 = r1.emit(r9, r8)
                        if (r9 != r0) goto L6f
                        return r0
                    L6f:
                        kotlin.t r9 = kotlin.t.f3507a
                        return r9
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1.AnonymousClass2.AnonymousClass1.C00631.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(CoroutineContext coroutineContext, Object obj, ReceiveChannel<? extends Object> receiveChannel, kotlinx.coroutines.flow.e<Object> eVar, q_p0<Object, Object, ? super c<Object>, ? extends Object> qP0Var) {
                this.f3741e = coroutineContext;
                this.f3742f = obj;
                this.f3743g = receiveChannel;
                this.f3744h = eVar;
                this.f3745i = qP0Var;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.e
            @org.jetbrains.annotations.Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object emit(java.lang.Object r13, @org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super kotlin.t> r14) {
                /*
                    r12 = this;
                    boolean r0 = r14 instanceof kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$emit$1
                    if (r0 == 0) goto L13
                    r0 = r14
                    kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$emit$1 r0 = (kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$emit$1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.label = r1
                    goto L18
                L13:
                    kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$emit$1 r0 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$emit$1
                    r0.<init>(r12, r14)
                L18:
                    java.lang.Object r14 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.a.d()
                    int r2 = r0.label
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    kotlin.h.b(r14)
                    goto L51
                L29:
                    java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                    java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
                    r13.<init>(r14)
                    throw r13
                L31:
                    kotlin.h.b(r14)
                    kotlin.coroutines.CoroutineContext r14 = r12.f3741e
                    kotlin.t r2 = kotlin.t.f3507a
                    java.lang.Object r4 = r12.f3742f
                    kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$1 r11 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$1
                    kotlinx.coroutines.channels.ReceiveChannel<java.lang.Object> r6 = r12.f3743g
                    kotlinx.coroutines.flow.e<java.lang.Object> r7 = r12.f3744h
                    p0.q<java.lang.Object, java.lang.Object, kotlin.coroutines.c<java.lang.Object>, java.lang.Object> r8 = r12.f3745i
                    r10 = 0
                    r5 = r11
                    r9 = r13
                    r5.<init>(r6, r7, r8, r9, r10)
                    r0.label = r3
                    java.lang.Object r13 = kotlinx.coroutines.flow.internal.d.b(r14, r2, r4, r11, r0)
                    if (r13 != r1) goto L51
                    return r1
                L51:
                    kotlin.t r13 = kotlin.t.f3507a
                    return r13
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1.AnonymousClass2.AnonymousClass1.emit(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(kotlinx.coroutines.flow.d<Object> dVar, CoroutineContext coroutineContext, Object obj, ReceiveChannel<? extends Object> receiveChannel, kotlinx.coroutines.flow.e<Object> eVar, q_p0<Object, Object, ? super c<Object>, ? extends Object> qP0Var, kotlin.coroutines.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$flow = dVar;
            this.$scopeContext = coroutineContext;
            this.$cnt = obj;
            this.$second = receiveChannel;
            this.$this_unsafeFlow = eVar;
            this.$transform = qP0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<t> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            return new AnonymousClass2(this.$flow, this.$scopeContext, this.$cnt, this.$second, this.$this_unsafeFlow, this.$transform, cVar);
        }

        @Override // p0.p
        @Nullable
        public final Object invoke(@NotNull t tVar, @Nullable kotlin.coroutines.c<? super t> cVar) {
            return ((AnonymousClass2) create(tVar, cVar)).invokeSuspend(t.f3507a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objD = kotlin.coroutines.intrinsics.b.d();
            int i2 = this.label;
            if (i2 == 0) {
                kotlin.h.b(obj);
                kotlinx.coroutines.flow.d<Object> dVar = this.$flow;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$scopeContext, this.$cnt, this.$second, this.$this_unsafeFlow, this.$transform);
                this.label = 1;
                if (dVar.a(anonymousClass1, this) == objD) {
                    return objD;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.h.b(obj);
            }
            return t.f3507a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    CombineKt$zipImpl$1$1(kotlinx.coroutines.flow.e<Object> eVar, kotlinx.coroutines.flow.d<Object> dVar, kotlinx.coroutines.flow.d<Object> dVar2, q_p0<Object, Object, ? super c<Object>, ? extends Object> qP0Var, kotlin.coroutines.c<? super CombineKt$zipImpl$1$1> cVar) {
        super(2, cVar);
        this.$this_unsafeFlow = eVar;
        this.$flow2 = dVar;
        this.$flow = dVar2;
        this.$transform = qP0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final kotlin.coroutines.c<t> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
        CombineKt$zipImpl$1$1 combineKt$zipImpl$1$1 = new CombineKt$zipImpl$1$1(this.$this_unsafeFlow, this.$flow2, this.$flow, this.$transform, cVar);
        combineKt$zipImpl$1$1.L$0 = obj;
        return combineKt$zipImpl$1$1;
    }

    @Override // p0.p
    @Nullable
    public final Object invoke(@NotNull g0 g0Var, @Nullable kotlin.coroutines.c<? super t> cVar) {
        return ((CombineKt$zipImpl$1$1) create(g0Var, cVar)).invokeSuspend(t.f3507a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v12, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v2, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r1v5 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        ReceiveChannel receiveChannel;
        ReceiveChannel receiveChannel2;
        CoroutineContext coroutineContextPlus;
        t tVar;
        AnonymousClass2 anonymousClass2;
        Object objD = kotlin.coroutines.intrinsics.b.d();
        ?? r1 = this.label;
        try {
            if (r1 != 0) {
                if (r1 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                receiveChannel2 = (ReceiveChannel) this.L$0;
                try {
                    kotlin.h.b(obj);
                    r1 = receiveChannel2;
                } catch (AbortFlowException e2) {
                    e = e2;
                }
                ReceiveChannel.DefaultImpls.a(r1, null, 1, null);
                return t.f3507a;
            }
            kotlin.h.b(obj);
            g0 g0Var = (g0) this.L$0;
            ReceiveChannel receiveChannelE = ProduceKt.e(g0Var, null, 0, new CombineKt$zipImpl$1$1$second$1(this.$flow2, null), 3, null);
            final u uVarB = l1.b(null, 1, null);
            final kotlinx.coroutines.flow.e<Object> eVar = this.$this_unsafeFlow;
            ((s) receiveChannelE).x(new l_p0<Throwable, t>() { // from class: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1.1
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
                    if (uVarB.isActive()) {
                        uVarB.a(new AbortFlowException(eVar));
                    }
                }
            });
            try {
                CoroutineContext coroutineContextH = g0Var.h();
                Object objB = ThreadContextKt.b(coroutineContextH);
                coroutineContextPlus = g0Var.h().plus(uVarB);
                tVar = t.f3507a;
                anonymousClass2 = new AnonymousClass2(this.$flow, coroutineContextH, objB, receiveChannelE, this.$this_unsafeFlow, this.$transform, null);
                this.L$0 = receiveChannelE;
                this.label = 1;
                receiveChannel = receiveChannelE;
            } catch (AbortFlowException e3) {
                e = e3;
                receiveChannel = receiveChannelE;
            } catch (Throwable th) {
                th = th;
                receiveChannel = receiveChannelE;
            }
            try {
            } catch (AbortFlowException e4) {
                e = e4;
                receiveChannel2 = receiveChannel;
                j.a(e, this.$this_unsafeFlow);
                r1 = receiveChannel2;
                ReceiveChannel.DefaultImpls.a(r1, null, 1, null);
                return t.f3507a;
            } catch (Throwable th2) {
                th = th2;
                r1 = receiveChannel;
                ReceiveChannel.DefaultImpls.a(r1, null, 1, null);
                throw th;
            }
            if (d.c(coroutineContextPlus, tVar, null, anonymousClass2, this, 4, null) == objD) {
                return objD;
            }
            r1 = receiveChannel;
            ReceiveChannel.DefaultImpls.a(r1, null, 1, null);
            return t.f3507a;
            j.a(e, this.$this_unsafeFlow);
            r1 = receiveChannel2;
            ReceiveChannel.DefaultImpls.a(r1, null, 1, null);
            return t.f3507a;
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
