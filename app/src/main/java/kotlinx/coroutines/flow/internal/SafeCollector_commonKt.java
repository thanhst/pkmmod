package kotlinx.coroutines.flow.internal;

import com.bumptech.glide.request.target.Target;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmName;
import kotlinx.coroutines.h1;
import kotlinx.coroutines.internal.z;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SafeCollector.common.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0018\u0010\u0004\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0001\u001a\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u0005*\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0080\u0010¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/flow/internal/SafeCollector;", "Lkotlin/coroutines/CoroutineContext;", "currentContext", "Lkotlin/t;", "a", "Lkotlinx/coroutines/h1;", "collectJob", "b", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class SafeCollector_commonKt {
    @JvmName(name = "checkContext")
    public static final void a(@NotNull final SafeCollector<?> safeCollector, @NotNull CoroutineContext coroutineContext) {
        if (((Number) coroutineContext.fold(0, new p0.p<Integer, CoroutineContext.a, Integer>() { // from class: kotlinx.coroutines.flow.internal.SafeCollector_commonKt$checkContext$result$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // p0.p
            public /* bridge */ /* synthetic */ Integer invoke(Integer num, CoroutineContext.a aVar) {
                return invoke(num.intValue(), aVar);
            }

            @NotNull
            public final Integer invoke(int i2, @NotNull CoroutineContext.a aVar) {
                CoroutineContext.b<?> key = aVar.getKey();
                CoroutineContext.a aVar2 = safeCollector.collectContext.get(key);
                if (key != h1.INSTANCE) {
                    return Integer.valueOf(aVar != aVar2 ? Target.SIZE_ORIGINAL : i2 + 1);
                }
                h1 h1Var = (h1) aVar2;
                h1 h1VarB = SafeCollector_commonKt.b((h1) aVar, h1Var);
                if (h1VarB == h1Var) {
                    if (h1Var != null) {
                        i2++;
                    }
                    return Integer.valueOf(i2);
                }
                throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + h1VarB + ", expected child of " + h1Var + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
            }
        })).intValue() == safeCollector.collectContextSize) {
            return;
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + safeCollector.collectContext + ",\n\t\tbut emission happened in " + coroutineContext + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
    }

    @Nullable
    public static final h1 b(@Nullable h1 h1Var, @Nullable h1 h1Var2) {
        while (h1Var != null) {
            if (h1Var == h1Var2) {
                return h1Var;
            }
            if (!(h1Var instanceof z)) {
                return h1Var;
            }
            h1Var = ((z) h1Var).O0();
        }
        return null;
    }
}
