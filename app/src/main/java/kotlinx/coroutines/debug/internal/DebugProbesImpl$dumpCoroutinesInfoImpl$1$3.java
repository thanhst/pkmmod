package kotlinx.coroutines.debug.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Lambda;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p0.l_p0;
import p0.p_p0;

/* compiled from: DebugProbesImpl.kt */
@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "R", "Lkotlinx/coroutines/debug/internal/d$a;", "owner", "invoke", "(Lkotlinx/coroutines/debug/internal/d$a;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class DebugProbesImpl$dumpCoroutinesInfoImpl$1$3 extends Lambda implements l_p0<d.a<?>, Object> {
    final /* synthetic */ p_p0<d.a<?>, CoroutineContext, Object> $create;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DebugProbesImpl$dumpCoroutinesInfoImpl$1$3(p_p0<? super d.a<?>, ? super CoroutineContext, Object> pP0Var) {
        super(1);
        this.$create = pP0Var;
    }

    @Override // p0.l
    @Nullable
    public final Object invoke(@NotNull d.a<?> aVar) {
        CoroutineContext coroutineContextC;
        if (d.f3643a.e(aVar) || (coroutineContextC = aVar.info.c()) == null) {
            return null;
        }
        return this.$create.invoke(aVar, coroutineContextC);
    }
}
