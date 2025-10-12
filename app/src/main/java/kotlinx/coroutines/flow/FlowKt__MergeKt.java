package kotlinx.coroutines.flow;

import kotlin.BuilderInference;
import kotlin.Metadata;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest;
import org.jetbrains.annotations.NotNull;

/* compiled from: Merge.kt */
@Metadata(bv = {}, d1 = {"\u0000D\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\u001at\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022D\b\u0001\u0010\f\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0003¢\u0006\u0002\b\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001ac\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u000223\b\u0001\u0010\f\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\" \u0010\u0018\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0010\u0010\u0013\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015\"\u001a\u0010\u001a\u001a\u00020\u00198\u0006X\u0087T¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u0012\u0004\b\u001c\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"T", "R", "Lkotlinx/coroutines/flow/d;", "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/e;", "Lkotlin/ParameterName;", "name", "value", "Lkotlin/coroutines/c;", "Lkotlin/t;", "", "Lkotlin/ExtensionFunctionType;", "transform", "b", "(Lkotlinx/coroutines/flow/d;Lp0/q;)Lkotlinx/coroutines/flow/d;", "Lkotlin/Function2;", "a", "(Lkotlinx/coroutines/flow/d;Lp0/p;)Lkotlinx/coroutines/flow/d;", "", "I", "getDEFAULT_CONCURRENCY", "()I", "getDEFAULT_CONCURRENCY$annotations", "()V", "DEFAULT_CONCURRENCY", "", "DEFAULT_CONCURRENCY_PROPERTY_NAME", "Ljava/lang/String;", "getDEFAULT_CONCURRENCY_PROPERTY_NAME$annotations", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes.dex */
final /* synthetic */ class FlowKt__MergeKt {

    /* renamed from: a, reason: collision with root package name */
    private static final int f3690a = kotlinx.coroutines.internal.e0.b("kotlinx.coroutines.flow.defaultConcurrency", 16, 1, Integer.MAX_VALUE);

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T, R> d<R> a(@NotNull d<? extends T> dVar, @BuilderInference @NotNull p0.p<? super T, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar) {
        return f.A(dVar, new FlowKt__MergeKt$mapLatest$1(pVar, null));
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T, R> d<R> b(@NotNull d<? extends T> dVar, @BuilderInference @NotNull p0.q<? super e<? super R>, ? super T, ? super kotlin.coroutines.c<? super kotlin.t>, ? extends Object> qVar) {
        return new ChannelFlowTransformLatest(qVar, dVar, null, 0, null, 28, null);
    }
}
