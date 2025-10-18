package kotlin.text;

import kotlin.Metadata;
import s0.l_s0;

import org.jetbrains.annotations.NotNull;

/* compiled from: _Strings.kt */
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0012\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¨\u0006\u0004"}, d2 = {"", "", "n", "r0", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/text/StringsKt")
/* loaded from: classes.dex */
class u extends t {
    @NotNull
    public static final String r0(@NotNull String str, int i2) {
        kotlin.jvm.internal.s.e(str, "<this>");
        if (i2 >= 0) {
            String strSubstring = str.substring(l_s0.c(i2, str.length()));
            kotlin.jvm.internal.s.d(strSubstring, "this as java.lang.String).substring(startIndex)");
            return strSubstring;
        }
        throw new IllegalArgumentException(("Requested character count " + i2 + " is less than zero.").toString());
    }
}
