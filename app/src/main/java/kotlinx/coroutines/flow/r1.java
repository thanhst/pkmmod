package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: StateFlow.kt */
@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\rJ\u001b\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b0\u00072\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\tH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/flow/r1;", "Lkotlinx/coroutines/flow/internal/c;", "Lkotlinx/coroutines/flow/StateFlowImpl;", "flow", "", "c", "(Lkotlinx/coroutines/flow/StateFlowImpl;)Z", "", "Lkotlin/coroutines/c;", "Lkotlin/t;", "e", "(Lkotlinx/coroutines/flow/StateFlowImpl;)[Lkotlin/coroutines/c;", "f", "()V", "g", "()Z", "d", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
final class r1 extends kotlinx.coroutines.flow.internal.c<StateFlowImpl<?>> {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ AtomicReferenceFieldUpdater f3777a = AtomicReferenceFieldUpdater.newUpdater(r1.class, Object.class, "_state");

    @NotNull
    volatile /* synthetic */ Object _state = null;

    @Override // kotlinx.coroutines.flow.internal.c
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(@NotNull StateFlowImpl<?> flow) {
        if (this._state != null) {
            return false;
        }
        this._state = q1.f3775a;
        return true;
    }

    @Nullable
    public final Object d(@NotNull kotlin.coroutines.c<? super kotlin.t> cVar) {
        kotlinx.coroutines.l lVar = new kotlinx.coroutines.l(IntrinsicsKt__IntrinsicsJvmKt.c(cVar), 1);
        lVar.w();
        if (!kotlin.i.a(f3777a, this, q1.f3775a, lVar)) {
            Result.Companion companion = Result.INSTANCE;
            lVar.resumeWith(Result.m158constructorimpl(kotlin.t.f3507a));
        }
        Object objT = lVar.t();
        if (objT == kotlin.coroutines.intrinsics.b.d()) {
            kotlin.coroutines.jvm.internal.e.c(cVar);
        }
        return objT == kotlin.coroutines.intrinsics.b.d() ? objT : kotlin.t.f3507a;
    }

    @Override // kotlinx.coroutines.flow.internal.c
    @NotNull
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public kotlin.coroutines.c<kotlin.t>[] b(@NotNull StateFlowImpl<?> flow) {
        this._state = null;
        return kotlinx.coroutines.flow.internal.b.f3755a;
    }

    public final void f() {
        while (true) {
            Object obj = this._state;
            if (obj == null || obj == q1.f3776b) {
                return;
            }
            if (obj == q1.f3775a) {
                if (kotlin.i.a(f3777a, this, obj, q1.f3776b)) {
                    return;
                }
            } else if (kotlin.i.a(f3777a, this, obj, q1.f3775a)) {
                Result.Companion companion = Result.INSTANCE;
                ((kotlinx.coroutines.l) obj).resumeWith(Result.m158constructorimpl(kotlin.t.f3507a));
                return;
            }
        }
    }

    public final boolean g() {
        Object andSet = f3777a.getAndSet(this, q1.f3775a);
        kotlin.jvm.internal.s.b(andSet);
        return andSet == q1.f3776b;
    }
}
