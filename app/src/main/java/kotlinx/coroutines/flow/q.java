package kotlinx.coroutines.flow;

import kotlin.BuilderInference;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Builders.kt */
@Metadata(bv = {}, d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aM\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002/\b\u0001\u0010\u0007\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001¢\u0006\u0002\b\u0006ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a!\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u000b\u001a\u00028\u0000¢\u0006\u0004\b\f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"T", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/e;", "Lkotlin/coroutines/c;", "Lkotlin/t;", "", "Lkotlin/ExtensionFunctionType;", "block", "Lkotlinx/coroutines/flow/d;", "a", "(Lp0/p;)Lkotlinx/coroutines/flow/d;", "value", "b", "(Ljava/lang/Object;)Lkotlinx/coroutines/flow/d;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes.dex */
final /* synthetic */ class q {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: SafeCollector.common.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/o", "Lkotlinx/coroutines/flow/d;", "Lkotlinx/coroutines/flow/e;", "collector", "Lkotlin/t;", "a", "(Lkotlinx/coroutines/flow/e;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static final class a<T> implements d<T> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Object f3774e;

        public a(Object obj) {
            this.f3774e = obj;
        }

        @Override // kotlinx.coroutines.flow.d
        @Nullable
        public Object a(@NotNull e<? super T> eVar, @NotNull kotlin.coroutines.c<? super kotlin.t> cVar) {
            Object objEmit = eVar.emit((Object) this.f3774e, cVar);
            return objEmit == kotlin.coroutines.intrinsics.b.d() ? objEmit : kotlin.t.f3507a;
        }
    }

    @NotNull
    public static final <T> d<T> a(@BuilderInference @NotNull p0.p<? super e<? super T>, ? super kotlin.coroutines.c<? super kotlin.t>, ? extends Object> pVar) {
        return new i1(pVar);
    }

    @NotNull
    public static final <T> d<T> b(T t2) {
        return new a(t2);
    }
}
