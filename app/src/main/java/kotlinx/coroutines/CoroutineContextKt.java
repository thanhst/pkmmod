package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CoroutineContext.kt */
@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u0014\u0010\u0003\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007\u001a\f\u0010\u0005\u001a\u00020\u0004*\u00020\u0001H\u0002\u001a \u0010\t\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0004H\u0002\u001a(\u0010\u000e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\r*\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0000\u001a\u0013\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\r*\u00020\u000fH\u0080\u0010\"\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u0011*\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/g0;", "Lkotlin/coroutines/CoroutineContext;", "context", "d", "", "c", "originalContext", "appendContext", "isNewCoroutine", "a", "Lkotlin/coroutines/c;", "", "oldValue", "Lkotlinx/coroutines/d2;", "f", "Lkotlin/coroutines/jvm/internal/c;", "e", "", "b", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/String;", "coroutineName", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class CoroutineContextKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.Object] */
    private static final CoroutineContext a(CoroutineContext coroutineContext, CoroutineContext coroutineContext2, final boolean z2) {
        boolean zC = c(coroutineContext);
        boolean zC2 = c(coroutineContext2);
        if (!zC && !zC2) {
            return coroutineContext.plus(coroutineContext2);
        }
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = coroutineContext2;
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        CoroutineContext coroutineContext3 = (CoroutineContext) coroutineContext.fold(emptyCoroutineContext, new p0.p<CoroutineContext, CoroutineContext.a, CoroutineContext>() { // from class: kotlinx.coroutines.CoroutineContextKt$foldCopies$folded$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            /* JADX WARN: Type inference failed for: r2v2, types: [T, kotlin.coroutines.CoroutineContext] */
            @Override // p0.p
            @NotNull
            public final CoroutineContext invoke(@NotNull CoroutineContext coroutineContext4, @NotNull CoroutineContext.a aVar) {
                if (!(aVar instanceof a0)) {
                    return coroutineContext4.plus(aVar);
                }
                CoroutineContext.a aVar2 = ref$ObjectRef.element.get(aVar.getKey());
                if (aVar2 != null) {
                    Ref$ObjectRef<CoroutineContext> ref$ObjectRef2 = ref$ObjectRef;
                    ref$ObjectRef2.element = ref$ObjectRef2.element.minusKey(aVar.getKey());
                    return coroutineContext4.plus(((a0) aVar).f(aVar2));
                }
                a0 a0VarJ = (a0) aVar;
                if (z2) {
                    a0VarJ = a0VarJ.j();
                }
                return coroutineContext4.plus(a0VarJ);
            }
        });
        if (zC2) {
            ref$ObjectRef.element = ((CoroutineContext) ref$ObjectRef.element).fold(emptyCoroutineContext, new p0.p<CoroutineContext, CoroutineContext.a, CoroutineContext>() { // from class: kotlinx.coroutines.CoroutineContextKt$foldCopies$1
                @Override // p0.p
                @NotNull
                public final CoroutineContext invoke(@NotNull CoroutineContext coroutineContext4, @NotNull CoroutineContext.a aVar) {
                    return aVar instanceof a0 ? coroutineContext4.plus(((a0) aVar).j()) : coroutineContext4.plus(aVar);
                }
            });
        }
        return coroutineContext3.plus((CoroutineContext) ref$ObjectRef.element);
    }

    @Nullable
    public static final String b(@NotNull CoroutineContext coroutineContext) {
        return null;
    }

    private static final boolean c(CoroutineContext coroutineContext) {
        return ((Boolean) coroutineContext.fold(Boolean.FALSE, new p0.p<Boolean, CoroutineContext.a, Boolean>() { // from class: kotlinx.coroutines.CoroutineContextKt$hasCopyableElements$1
            @NotNull
            public final Boolean invoke(boolean z2, @NotNull CoroutineContext.a aVar) {
                return Boolean.valueOf(z2 || (aVar instanceof a0));
            }

            @Override // p0.p
            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool, CoroutineContext.a aVar) {
                return invoke(bool.booleanValue(), aVar);
            }
        })).booleanValue();
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final CoroutineContext d(@NotNull g0 g0Var, @NotNull CoroutineContext coroutineContext) {
        CoroutineContext coroutineContextA = a(g0Var.h(), coroutineContext, true);
        return (coroutineContextA == p0.a() || coroutineContextA.get(kotlin.coroutines.d.INSTANCE) != null) ? coroutineContextA : coroutineContextA.plus(p0.a());
    }

    @Nullable
    public static final d2<?> e(@NotNull kotlin.coroutines.jvm.internal.c cVar) {
        while (!(cVar instanceof m0) && (cVar = cVar.getCallerFrame()) != null) {
            if (cVar instanceof d2) {
                return (d2) cVar;
            }
        }
        return null;
    }

    @Nullable
    public static final d2<?> f(@NotNull kotlin.coroutines.c<?> cVar, @NotNull CoroutineContext coroutineContext, @Nullable Object obj) {
        if (!(cVar instanceof kotlin.coroutines.jvm.internal.c)) {
            return null;
        }
        if (!(coroutineContext.get(e2.f3661e) != null)) {
            return null;
        }
        d2<?> d2VarE = e((kotlin.coroutines.jvm.internal.c) cVar);
        if (d2VarE != null) {
            d2VarE.Q0(coroutineContext, obj);
        }
        return d2VarE;
    }
}
