package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Share.kt */
@Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00028\u00000\u0004B\u001f\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096Aø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ&\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/flow/h1;", "T", "Lkotlinx/coroutines/flow/p1;", "", "Lkotlinx/coroutines/flow/internal/k;", "Lkotlinx/coroutines/flow/e;", "collector", "", "a", "(Lkotlinx/coroutines/flow/e;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/d;", "c", "Lkotlinx/coroutines/h1;", "e", "Lkotlinx/coroutines/h1;", "job", "flow", "<init>", "(Lkotlinx/coroutines/flow/p1;Lkotlinx/coroutines/h1;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
final class h1<T> implements p1<T>, d, kotlinx.coroutines.flow.internal.k<T> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final kotlinx.coroutines.h1 job;

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ p1<T> f3728f;

    /* JADX WARN: Multi-variable type inference failed */
    public h1(@NotNull p1<? extends T> p1Var, @Nullable kotlinx.coroutines.h1 h1Var) {
        this.job = h1Var;
        this.f3728f = p1Var;
    }

    @Override // kotlinx.coroutines.flow.j1, kotlinx.coroutines.flow.d
    @Nullable
    public Object a(@NotNull e<? super T> eVar, @NotNull kotlin.coroutines.c<?> cVar) {
        return this.f3728f.a(eVar, cVar);
    }

    @Override // kotlinx.coroutines.flow.internal.k
    @NotNull
    public d<T> c(@NotNull CoroutineContext context, int capacity, @NotNull BufferOverflow onBufferOverflow) {
        return q1.d(this, context, capacity, onBufferOverflow);
    }
}
