package kotlin;

import com.bumptech.glide.request.target.Target;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;

/* compiled from: UnsignedUtils.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u0018\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0001\u001a\u0018\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u0004H\u0001\u001a\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0000\u001a\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0000H\u0000¨\u0006\u000b"}, d2 = {"", "v1", "v2", "a", "", "b", "v", "", "c", "base", "d", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1})
@JvmName(name = "UnsignedKt")
/* loaded from: classes.dex */
public final class u {
    @PublishedApi
    public static final int a(int i2, int i3) {
        return kotlin.jvm.internal.s.f(i2 ^ Target.SIZE_ORIGINAL, i3 ^ Target.SIZE_ORIGINAL);
    }

    @PublishedApi
    public static final int b(long j2, long j3) {
        return kotlin.jvm.internal.s.g(j2 ^ Long.MIN_VALUE, j3 ^ Long.MIN_VALUE);
    }

    @NotNull
    public static final String c(long j2) {
        return d(j2, 10);
    }

    @NotNull
    public static final String d(long j2, int i2) {
        if (j2 >= 0) {
            String string = Long.toString(j2, kotlin.text.b.a(i2));
            kotlin.jvm.internal.s.d(string, "toString(this, checkRadix(radix))");
            return string;
        }
        long j3 = i2;
        long j4 = ((j2 >>> 1) / j3) << 1;
        long j5 = j2 - (j4 * j3);
        if (j5 >= j3) {
            j5 -= j3;
            j4++;
        }
        StringBuilder sb = new StringBuilder();
        String string2 = Long.toString(j4, kotlin.text.b.a(i2));
        kotlin.jvm.internal.s.d(string2, "toString(this, checkRadix(radix))");
        sb.append(string2);
        String string3 = Long.toString(j5, kotlin.text.b.a(i2));
        kotlin.jvm.internal.s.d(string3, "toString(this, checkRadix(radix))");
        sb.append(string3);
        return sb.toString();
    }
}
