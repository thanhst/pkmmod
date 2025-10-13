package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import p0.l_p0;

import org.jetbrains.annotations.NotNull;

/* compiled from: _Strings.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
final class StringsKt___StringsKt$chunkedSequence$1 extends Lambda implements l_p0<CharSequence, String> {
    public static final StringsKt___StringsKt$chunkedSequence$1 INSTANCE = new StringsKt___StringsKt$chunkedSequence$1();

    StringsKt___StringsKt$chunkedSequence$1() {
        super(1);
    }

    @Override // p0.l
    @NotNull
    public final String invoke(@NotNull CharSequence it) {
        kotlin.jvm.internal.s.e(it, "it");
        return it.toString();
    }
}
