package k0;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Comparisons.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0010\u000f\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u001a/\u0010\u0002\u001a\u00020\u0004\"\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u00002\b\u0010\u0002\u001a\u0004\u0018\u00018\u00002\b\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"", "T", "a", "b", "", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)I", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/comparisons/ComparisonsKt")
/* loaded from: classes.dex */
public class b {
    public static <T extends Comparable<?>> int a(@Nullable T t2, @Nullable T t3) {
        if (t2 == t3) {
            return 0;
        }
        if (t2 == null) {
            return -1;
        }
        if (t3 == null) {
            return 1;
        }
        return t2.compareTo(t3);
    }
}
