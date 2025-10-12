package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Delay.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "emittedItem", "invoke", "(Ljava/lang/Object;)Ljava/lang/Long;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
final class FlowKt__DelayKt$debounce$3 extends Lambda implements p0.l<Object, Long> {
    final /* synthetic */ p0.l<Object, t0.a> $timeout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FlowKt__DelayKt$debounce$3(p0.l<Object, t0.a> lVar) {
        super(1);
        this.$timeout = lVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p0.l
    @NotNull
    public final Long invoke(Object obj) {
        return Long.valueOf(DelayKt.d(this.$timeout.invoke(obj).getRawValue()));
    }
}
