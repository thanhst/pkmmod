package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Strings.kt */
@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ls0/f;", "it", "", "invoke", "(Ls0/f;)Ljava/lang/String;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes.dex */
final class StringsKt__StringsKt$splitToSequence$2 extends Lambda implements p0.l<s0.f, String> {
    final /* synthetic */ CharSequence $this_splitToSequence;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StringsKt__StringsKt$splitToSequence$2(CharSequence charSequence) {
        super(1);
        this.$this_splitToSequence = charSequence;
    }

    @Override // p0.l
    @NotNull
    public final String invoke(@NotNull s0.f it) {
        kotlin.jvm.internal.s.e(it, "it");
        return StringsKt__StringsKt.f0(this.$this_splitToSequence, it);
    }
}
