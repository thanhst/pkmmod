package kotlin.sequences;

import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import p0.l_p0;

/* compiled from: _Sequences.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "T", "it", "", "invoke", "(I)Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
final class SequencesKt___SequencesKt$elementAt$1 extends Lambda implements l_p0<Integer, Object> {
    final /* synthetic */ int $index;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesKt$elementAt$1(int i2) {
        super(1);
        this.$index = i2;
    }

    public final Object invoke(int i2) {
        throw new IndexOutOfBoundsException("Sequence doesn't contain element at index " + this.$index + '.');
    }

    @Override // p0.l
    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
        return invoke(num.intValue());
    }
}
