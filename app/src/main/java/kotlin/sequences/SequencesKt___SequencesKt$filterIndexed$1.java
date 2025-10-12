package kotlin.sequences;

import kotlin.Metadata;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import p0.p;

/* compiled from: _Sequences.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "Lkotlin/collections/f0;", "it", "", "invoke", "(Lkotlin/collections/f0;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes.dex */
final class SequencesKt___SequencesKt$filterIndexed$1 extends Lambda implements p0.l<IndexedValue<Object>, Boolean> {
    final /* synthetic */ p<Integer, Object, Boolean> $predicate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SequencesKt___SequencesKt$filterIndexed$1(p<? super Integer, Object, Boolean> pVar) {
        super(1);
        this.$predicate = pVar;
    }

    @Override // p0.l
    @NotNull
    public final Boolean invoke(@NotNull IndexedValue<Object> it) {
        s.e(it, "it");
        return this.$predicate.invoke(Integer.valueOf(it.getIndex()), it.b());
    }
}
