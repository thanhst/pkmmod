package kotlin.text;

import kotlin.Metadata;
import kotlin.PublishedApi;
import s0.f_s0;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CharJVM.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0010\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0000\u001a\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¨\u0006\b"}, d2 = {"", "", "c", "char", "", "radix", "b", "a", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/text/CharsKt")
/* loaded from: classes.dex */
public class b {
    @PublishedApi
    public static int a(int i2) {
        if (new f_s0(2, 36).f(i2)) {
            return i2;
        }
        throw new IllegalArgumentException("radix " + i2 + " was not in valid range " + new f_s0(2, 36));
    }

    public static final int b(char c2, int i2) {
        return Character.digit((int) c2, i2);
    }

    public static final boolean c(char c2) {
        return Character.isWhitespace(c2) || Character.isSpaceChar(c2);
    }
}
