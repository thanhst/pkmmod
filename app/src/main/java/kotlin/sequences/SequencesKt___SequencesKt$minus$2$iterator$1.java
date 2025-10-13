package kotlin.sequences;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import p0.l_p0;

import org.jetbrains.annotations.NotNull;

/* compiled from: _Sequences.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
final class SequencesKt___SequencesKt$minus$2$iterator$1 extends Lambda implements l_p0<Object, Boolean> {
    final /* synthetic */ Collection<Object> $other;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesKt$minus$2$iterator$1(Collection<Object> collection) {
        super(1);
        this.$other = collection;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p0.l
    @NotNull
    public final Boolean invoke(Object obj) {
        return Boolean.valueOf(this.$other.contains(obj));
    }
}
