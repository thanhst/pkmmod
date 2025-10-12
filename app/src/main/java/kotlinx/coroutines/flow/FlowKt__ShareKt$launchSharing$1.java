package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Share.kt */
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {"T", "Lkotlinx/coroutines/g0;", "Lkotlin/t;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1", f = "Share.kt", i = {}, l = {214, 218, 219, 225}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class FlowKt__ShareKt$launchSharing$1 extends SuspendLambda implements p0.p<kotlinx.coroutines.g0, kotlin.coroutines.c<? super kotlin.t>, Object> {
    final /* synthetic */ Object $initialValue;
    final /* synthetic */ f1<Object> $shared;
    final /* synthetic */ m1 $started;
    final /* synthetic */ d<Object> $upstream;
    int label;

    /* compiled from: Share.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@"}, d2 = {"T", "", "it", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1", f = "Share.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements p0.p<Integer, kotlin.coroutines.c<? super Boolean>, Object> {
        /* synthetic */ int I$0;
        int label;

        AnonymousClass1(kotlin.coroutines.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<kotlin.t> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(cVar);
            anonymousClass1.I$0 = ((Number) obj).intValue();
            return anonymousClass1;
        }

        @Nullable
        public final Object invoke(int i2, @Nullable kotlin.coroutines.c<? super Boolean> cVar) {
            return ((AnonymousClass1) create(Integer.valueOf(i2), cVar)).invokeSuspend(kotlin.t.f3507a);
        }

        @Override // p0.p
        public /* bridge */ /* synthetic */ Object invoke(Integer num, kotlin.coroutines.c<? super Boolean> cVar) {
            return invoke(num.intValue(), cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.b.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.h.b(obj);
            return kotlin.coroutines.jvm.internal.a.a(this.I$0 > 0);
        }
    }

    /* compiled from: Share.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@"}, d2 = {"T", "Lkotlinx/coroutines/flow/SharingCommand;", "it", "Lkotlin/t;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2", f = "Share.kt", i = {}, l = {227}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements p0.p<SharingCommand, kotlin.coroutines.c<? super kotlin.t>, Object> {
        final /* synthetic */ Object $initialValue;
        final /* synthetic */ f1<Object> $shared;
        final /* synthetic */ d<Object> $upstream;
        /* synthetic */ Object L$0;
        int label;

        /* compiled from: Share.kt */
        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2$a */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f3705a;

            static {
                int[] iArr = new int[SharingCommand.values().length];
                iArr[SharingCommand.START.ordinal()] = 1;
                iArr[SharingCommand.STOP.ordinal()] = 2;
                iArr[SharingCommand.STOP_AND_RESET_REPLAY_CACHE.ordinal()] = 3;
                f3705a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(d<Object> dVar, f1<Object> f1Var, Object obj, kotlin.coroutines.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$upstream = dVar;
            this.$shared = f1Var;
            this.$initialValue = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<kotlin.t> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$upstream, this.$shared, this.$initialValue, cVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // p0.p
        @Nullable
        public final Object invoke(@NotNull SharingCommand sharingCommand, @Nullable kotlin.coroutines.c<? super kotlin.t> cVar) {
            return ((AnonymousClass2) create(sharingCommand, cVar)).invokeSuspend(kotlin.t.f3507a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objD = kotlin.coroutines.intrinsics.b.d();
            int i2 = this.label;
            if (i2 == 0) {
                kotlin.h.b(obj);
                int i3 = a.f3705a[((SharingCommand) this.L$0).ordinal()];
                if (i3 == 1) {
                    d<Object> dVar = this.$upstream;
                    f1<Object> f1Var = this.$shared;
                    this.label = 1;
                    if (dVar.a(f1Var, this) == objD) {
                        return objD;
                    }
                } else if (i3 == 3) {
                    Object obj2 = this.$initialValue;
                    if (obj2 == k1.f3767a) {
                        this.$shared.b();
                    } else {
                        this.$shared.d(obj2);
                    }
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.h.b(obj);
            }
            return kotlin.t.f3507a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FlowKt__ShareKt$launchSharing$1(m1 m1Var, d<Object> dVar, f1<Object> f1Var, Object obj, kotlin.coroutines.c<? super FlowKt__ShareKt$launchSharing$1> cVar) {
        super(2, cVar);
        this.$started = m1Var;
        this.$upstream = dVar;
        this.$shared = f1Var;
        this.$initialValue = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final kotlin.coroutines.c<kotlin.t> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
        return new FlowKt__ShareKt$launchSharing$1(this.$started, this.$upstream, this.$shared, this.$initialValue, cVar);
    }

    @Override // p0.p
    @Nullable
    public final Object invoke(@NotNull kotlinx.coroutines.g0 g0Var, @Nullable kotlin.coroutines.c<? super kotlin.t> cVar) {
        return ((FlowKt__ShareKt$launchSharing$1) create(g0Var, cVar)).invokeSuspend(kotlin.t.f3507a);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0068 A[RETURN] */
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
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L25
            if (r1 == r5) goto L21
            if (r1 == r4) goto L1d
            if (r1 == r3) goto L21
            if (r1 != r2) goto L15
            goto L21
        L15:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L1d:
            kotlin.h.b(r8)
            goto L5c
        L21:
            kotlin.h.b(r8)
            goto L8d
        L25:
            kotlin.h.b(r8)
            kotlinx.coroutines.flow.m1 r8 = r7.$started
            kotlinx.coroutines.flow.m1$a r1 = kotlinx.coroutines.flow.m1.INSTANCE
            kotlinx.coroutines.flow.m1 r6 = r1.a()
            if (r8 != r6) goto L3f
            kotlinx.coroutines.flow.d<java.lang.Object> r8 = r7.$upstream
            kotlinx.coroutines.flow.f1<java.lang.Object> r1 = r7.$shared
            r7.label = r5
            java.lang.Object r8 = r8.a(r1, r7)
            if (r8 != r0) goto L8d
            return r0
        L3f:
            kotlinx.coroutines.flow.m1 r8 = r7.$started
            kotlinx.coroutines.flow.m1 r1 = r1.b()
            r5 = 0
            if (r8 != r1) goto L69
            kotlinx.coroutines.flow.f1<java.lang.Object> r8 = r7.$shared
            kotlinx.coroutines.flow.p1 r8 = r8.f()
            kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1 r1 = new kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1
            r1.<init>(r5)
            r7.label = r4
            java.lang.Object r8 = kotlinx.coroutines.flow.f.m(r8, r1, r7)
            if (r8 != r0) goto L5c
            return r0
        L5c:
            kotlinx.coroutines.flow.d<java.lang.Object> r8 = r7.$upstream
            kotlinx.coroutines.flow.f1<java.lang.Object> r1 = r7.$shared
            r7.label = r3
            java.lang.Object r8 = r8.a(r1, r7)
            if (r8 != r0) goto L8d
            return r0
        L69:
            kotlinx.coroutines.flow.m1 r8 = r7.$started
            kotlinx.coroutines.flow.f1<java.lang.Object> r1 = r7.$shared
            kotlinx.coroutines.flow.p1 r1 = r1.f()
            kotlinx.coroutines.flow.d r8 = r8.a(r1)
            kotlinx.coroutines.flow.d r8 = kotlinx.coroutines.flow.f.h(r8)
            kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2 r1 = new kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2
            kotlinx.coroutines.flow.d<java.lang.Object> r3 = r7.$upstream
            kotlinx.coroutines.flow.f1<java.lang.Object> r4 = r7.$shared
            java.lang.Object r6 = r7.$initialValue
            r1.<init>(r3, r4, r6, r5)
            r7.label = r2
            java.lang.Object r8 = kotlinx.coroutines.flow.f.e(r8, r1, r7)
            if (r8 != r0) goto L8d
            return r0
        L8d:
            kotlin.t r8 = kotlin.t.f3507a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
