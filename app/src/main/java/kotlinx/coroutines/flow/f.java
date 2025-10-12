package kotlinx.coroutines.flow;

import java.util.Collection;
import kotlin.BuilderInference;
import kotlin.Metadata;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ReceiveChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {}, d1 = {"kotlinx/coroutines/flow/q", "kotlinx/coroutines/flow/FlowKt__ChannelsKt", "kotlinx/coroutines/flow/t", "kotlinx/coroutines/flow/FlowKt__CollectionKt", "kotlinx/coroutines/flow/u", "kotlinx/coroutines/flow/FlowKt__CountKt", "kotlinx/coroutines/flow/FlowKt__DelayKt", "kotlinx/coroutines/flow/FlowKt__DistinctKt", "kotlinx/coroutines/flow/FlowKt__EmittersKt", "kotlinx/coroutines/flow/FlowKt__ErrorsKt", "kotlinx/coroutines/flow/FlowKt__LimitKt", "kotlinx/coroutines/flow/FlowKt__MergeKt", "kotlinx/coroutines/flow/FlowKt__ReduceKt", "kotlinx/coroutines/flow/FlowKt__ZipKt"}, d2 = {}, k = 4, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class f {
    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T, R> d<R> A(@NotNull d<? extends T> dVar, @BuilderInference @NotNull p0.q<? super e<? super R>, ? super T, ? super kotlin.coroutines.c<? super kotlin.t>, ? extends Object> qVar) {
        return FlowKt__MergeKt.b(dVar, qVar);
    }

    @NotNull
    public static final <T> d<T> a(@NotNull d<? extends T> dVar, int i2, @NotNull BufferOverflow bufferOverflow) {
        return u.a(dVar, i2, bufferOverflow);
    }

    @Nullable
    public static final <T> Object c(@NotNull d<? extends T> dVar, @NotNull e<? super T> eVar, @NotNull kotlin.coroutines.c<? super Throwable> cVar) {
        return FlowKt__ErrorsKt.a(dVar, eVar, cVar);
    }

    @Nullable
    public static final Object d(@NotNull d<?> dVar, @NotNull kotlin.coroutines.c<? super kotlin.t> cVar) {
        return t.a(dVar, cVar);
    }

    @Nullable
    public static final <T> Object e(@NotNull d<? extends T> dVar, @NotNull p0.p<? super T, ? super kotlin.coroutines.c<? super kotlin.t>, ? extends Object> pVar, @NotNull kotlin.coroutines.c<? super kotlin.t> cVar) {
        return t.b(dVar, pVar, cVar);
    }

    @Nullable
    public static final <T> Object f(@NotNull d<? extends T> dVar, @NotNull kotlin.coroutines.c<? super Integer> cVar) {
        return FlowKt__CountKt.a(dVar, cVar);
    }

    @Nullable
    public static final <T> Object g(@NotNull d<? extends T> dVar, @NotNull p0.p<? super T, ? super kotlin.coroutines.c<? super Boolean>, ? extends Object> pVar, @NotNull kotlin.coroutines.c<? super Integer> cVar) {
        return FlowKt__CountKt.b(dVar, pVar, cVar);
    }

    @NotNull
    public static final <T> d<T> h(@NotNull d<? extends T> dVar) {
        return FlowKt__DistinctKt.a(dVar);
    }

    @Nullable
    public static final <T> Object i(@NotNull e<? super T> eVar, @NotNull ReceiveChannel<? extends T> receiveChannel, @NotNull kotlin.coroutines.c<? super kotlin.t> cVar) {
        return FlowKt__ChannelsKt.b(eVar, receiveChannel, cVar);
    }

    @Nullable
    public static final <T> Object j(@NotNull e<? super T> eVar, @NotNull d<? extends T> dVar, @NotNull kotlin.coroutines.c<? super kotlin.t> cVar) {
        return t.c(eVar, dVar, cVar);
    }

    public static final void k(@NotNull e<?> eVar) throws Throwable {
        FlowKt__EmittersKt.b(eVar);
    }

    @Nullable
    public static final <T> Object l(@NotNull d<? extends T> dVar, @NotNull kotlin.coroutines.c<? super T> cVar) {
        return FlowKt__ReduceKt.a(dVar, cVar);
    }

    @Nullable
    public static final <T> Object m(@NotNull d<? extends T> dVar, @NotNull p0.p<? super T, ? super kotlin.coroutines.c<? super Boolean>, ? extends Object> pVar, @NotNull kotlin.coroutines.c<? super T> cVar) {
        return FlowKt__ReduceKt.b(dVar, pVar, cVar);
    }

    @Nullable
    public static final <T> Object n(@NotNull d<? extends T> dVar, @NotNull kotlin.coroutines.c<? super T> cVar) {
        return FlowKt__ReduceKt.c(dVar, cVar);
    }

    @Nullable
    public static final <T> Object o(@NotNull d<? extends T> dVar, @NotNull p0.p<? super T, ? super kotlin.coroutines.c<? super Boolean>, ? extends Object> pVar, @NotNull kotlin.coroutines.c<? super T> cVar) {
        return FlowKt__ReduceKt.d(dVar, pVar, cVar);
    }

    @NotNull
    public static final ReceiveChannel<kotlin.t> p(@NotNull kotlinx.coroutines.g0 g0Var, long j2, long j3) {
        return FlowKt__DelayKt.a(g0Var, j2, j3);
    }

    @NotNull
    public static final <T> d<T> r(@BuilderInference @NotNull p0.p<? super e<? super T>, ? super kotlin.coroutines.c<? super kotlin.t>, ? extends Object> pVar) {
        return q.a(pVar);
    }

    @NotNull
    public static final <T> d<T> s(T t2) {
        return q.b(t2);
    }

    @Nullable
    public static final <T> Object t(@NotNull d<? extends T> dVar, @NotNull kotlin.coroutines.c<? super T> cVar) {
        return FlowKt__ReduceKt.f(dVar, cVar);
    }

    @Nullable
    public static final <T> Object u(@NotNull d<? extends T> dVar, @NotNull kotlin.coroutines.c<? super T> cVar) {
        return FlowKt__ReduceKt.g(dVar, cVar);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T, R> d<R> v(@NotNull d<? extends T> dVar, @BuilderInference @NotNull p0.p<? super T, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar) {
        return FlowKt__MergeKt.a(dVar, pVar);
    }

    @Nullable
    public static final <S, T extends S> Object w(@NotNull d<? extends T> dVar, @NotNull p0.q<? super S, ? super T, ? super kotlin.coroutines.c<? super S>, ? extends Object> qVar, @NotNull kotlin.coroutines.c<? super S> cVar) {
        return FlowKt__ReduceKt.h(dVar, qVar, cVar);
    }

    @Nullable
    public static final <T> Object x(@NotNull d<? extends T> dVar, @NotNull kotlin.coroutines.c<? super T> cVar) {
        return FlowKt__ReduceKt.i(dVar, cVar);
    }

    @Nullable
    public static final <T> Object y(@NotNull d<? extends T> dVar, @NotNull kotlin.coroutines.c<? super T> cVar) {
        return FlowKt__ReduceKt.j(dVar, cVar);
    }

    @Nullable
    public static final <T, C extends Collection<? super T>> Object z(@NotNull d<? extends T> dVar, @NotNull C c2, @NotNull kotlin.coroutines.c<? super C> cVar) {
        return FlowKt__CollectionKt.a(dVar, c2, cVar);
    }
}
