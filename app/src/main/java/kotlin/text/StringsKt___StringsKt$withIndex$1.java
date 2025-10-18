package kotlin.text;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import p0.a_p0;

import org.jetbrains.annotations.NotNull;

/* compiled from: _Strings.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010(\n\u0002\u0010\f\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
final class StringsKt___StringsKt$withIndex$1 extends Lambda implements a_p0<Iterator<? extends Character>> {
    final /* synthetic */ CharSequence $this_withIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StringsKt___StringsKt$withIndex$1(CharSequence charSequence) {
        super(0);
        this.$this_withIndex = charSequence;
    }

    @Override // p0.a
    @NotNull
    public final Iterator<? extends Character> invoke() {
        return StringsKt__StringsKt.I(this.$this_withIndex);
    }
}
