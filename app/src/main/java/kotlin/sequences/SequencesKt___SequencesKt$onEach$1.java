package kotlin.sequences;

import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.t;

/* compiled from: _Sequences.kt */
@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0005\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "T", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
final class SequencesKt___SequencesKt$onEach$1 extends Lambda implements p0.l<Object, Object> {
    final /* synthetic */ p0.l<Object, t> $action;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesKt$onEach$1(p0.l<Object, t> lVar) {
        super(1);
        this.$action = lVar;
    }

    @Override // p0.l
    public final Object invoke(Object obj) {
        this.$action.invoke(obj);
        return obj;
    }
}
