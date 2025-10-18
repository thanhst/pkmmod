package kotlin.sequences;

import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.s;
import p0.l_p0;

import org.jetbrains.annotations.NotNull;

/* compiled from: _Sequences.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
final class SequencesKt___SequencesKt$minus$1$iterator$1 extends Lambda implements l_p0<Object, Boolean> {
    final /* synthetic */ Object $element;
    final /* synthetic */ Ref$BooleanRef $removed;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesKt$minus$1$iterator$1(Ref$BooleanRef ref$BooleanRef, Object obj) {
        super(1);
        this.$removed = ref$BooleanRef;
        this.$element = obj;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p0.l
    @NotNull
    public final Boolean invoke(Object obj) {
        boolean z2 = true;
        if (!this.$removed.element && s.a(obj, this.$element)) {
            this.$removed.element = true;
            z2 = false;
        }
        return Boolean.valueOf(z2);
    }
}
