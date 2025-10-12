package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

/* compiled from: _Strings.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "R", "index", "", "invoke", "(I)Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
final class StringsKt___StringsKt$windowedSequence$2 extends Lambda implements p0.l<Integer, Object> {
    final /* synthetic */ int $size;
    final /* synthetic */ CharSequence $this_windowedSequence;
    final /* synthetic */ p0.l<CharSequence, Object> $transform;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    StringsKt___StringsKt$windowedSequence$2(int i2, CharSequence charSequence, p0.l<? super CharSequence, Object> lVar) {
        super(1);
        this.$size = i2;
        this.$this_windowedSequence = charSequence;
        this.$transform = lVar;
    }

    @Override // p0.l
    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
        return invoke(num.intValue());
    }

    public final Object invoke(int i2) {
        int length = this.$size + i2;
        if (length < 0 || length > this.$this_windowedSequence.length()) {
            length = this.$this_windowedSequence.length();
        }
        return this.$transform.invoke(this.$this_windowedSequence.subSequence(i2, length));
    }
}
