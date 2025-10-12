package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: Zip.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\u0010\u0000\u001a\f\u0012\u0006\u0012\u0004\u0018\u0001H\u0002\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0004\b\u0001\u0010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "R", "invoke", "()[Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 176)
/* loaded from: classes.dex */
public final class FlowKt__ZipKt$combine$5$1 extends Lambda implements p0.a<Object[]> {
    final /* synthetic */ d<Object>[] $flows;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__ZipKt$combine$5$1(d<Object>[] dVarArr) {
        super(0);
        this.$flows = dVarArr;
    }

    @Override // p0.a
    @Nullable
    public final Object[] invoke() {
        int length = this.$flows.length;
        kotlin.jvm.internal.s.j(0, "T?");
        return new Object[length];
    }
}
