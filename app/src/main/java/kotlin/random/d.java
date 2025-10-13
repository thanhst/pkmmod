package kotlin.random;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import s0.f_s0;

/* compiled from: Random.kt */
@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007\u001a\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0000\u001a\u0014\u0010\b\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0000\u001a\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0000\u001a\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\rH\u0000\u001a\u0018\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000fH\u0000\u001a\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u0011H\u0000¨\u0006\u0014"}, d2 = {"Lkotlin/random/Random;", "Ls0/f;", "range", "", "f", "value", "e", "bitCount", "g", "from", "until", "Lkotlin/t;", "c", "", "d", "", "b", "", "", "a", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes.dex */
public final class d {
    @NotNull
    public static final String a(@NotNull Object from, @NotNull Object until) {
        s.e(from, "from");
        s.e(until, "until");
        return "Random range is empty: [" + from + ", " + until + ").";
    }

    public static final void b(double d2, double d3) {
        if (!(d3 > d2)) {
            throw new IllegalArgumentException(a(Double.valueOf(d2), Double.valueOf(d3)).toString());
        }
    }

    public static final void c(int i2, int i3) {
        if (!(i3 > i2)) {
            throw new IllegalArgumentException(a(Integer.valueOf(i2), Integer.valueOf(i3)).toString());
        }
    }

    public static final void d(long j2, long j3) {
        if (!(j3 > j2)) {
            throw new IllegalArgumentException(a(Long.valueOf(j2), Long.valueOf(j3)).toString());
        }
    }

    public static final int e(int i2) {
        return 31 - Integer.numberOfLeadingZeros(i2);
    }

    @SinceKotlin(version = "1.3")
    public static final int f(@NotNull Random random, @NotNull f_s0 range) {
        s.e(random, "<this>");
        s.e(range, "range");
        if (!range.isEmpty()) {
            return range.getLast() < Integer.MAX_VALUE ? random.nextInt(range.getFirst(), range.getLast() + 1) : range.getFirst() > Integer.MIN_VALUE ? random.nextInt(range.getFirst() - 1, range.getLast()) + 1 : random.nextInt();
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + range);
    }

    public static final int g(int i2, int i3) {
        return (i2 >>> (32 - i3)) & ((-i3) >> 31);
    }
}
