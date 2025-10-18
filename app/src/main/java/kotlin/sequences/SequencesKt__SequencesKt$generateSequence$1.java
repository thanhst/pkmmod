package kotlin.sequences;

import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import p0.a_p0;
import p0.l_p0;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Sequences.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u0002H\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "T", "", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
final class SequencesKt__SequencesKt$generateSequence$1 extends Lambda implements l_p0<Object, Object> {
    final /* synthetic */ a_p0<Object> $nextFunction;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SequencesKt__SequencesKt$generateSequence$1(a_p0<Object> aP0Var) {
        super(1);
        this.$nextFunction = aP0Var;
    }

    @Override // p0.l
    @Nullable
    public final Object invoke(@NotNull Object it) {
        s.e(it, "it");
        return this.$nextFunction.invoke();
    }
}
