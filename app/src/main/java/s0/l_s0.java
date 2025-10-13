package s0;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.s;
import kotlin.random.Random;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _Ranges.kt */
@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007\u001a\u0015\u0010\u0007\u001a\u00020\u0006*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0086\u0004\u001a\u0015\u0010\b\u001a\u00020\u0000*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0086\u0004\u001a\u0012\u0010\n\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003\u001a\u0012\u0010\f\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\t\u001a\u00020\u000b\u001a\u0012\u0010\u000e\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003\u001a\u0012\u0010\u000f\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b\u001a\u001a\u0010\u0010\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003¨\u0006\u0011"}, d2 = {"Ls0/f;", "Lkotlin/random/Random;", "random", "", "g", "to", "Ls0/d;", "f", "h", "minimumValue", "a", "", "b", "maximumValue", "c", "d", "e", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/ranges/RangesKt")
/* loaded from: classes.dex */
public class l_s0 extends k_s0 {
    public static int a(int i2, int i3) {
        return i2 < i3 ? i3 : i2;
    }

    public static long b(long j2, long j3) {
        return j2 < j3 ? j3 : j2;
    }

    public static int c(int i2, int i3) {
        return i2 > i3 ? i3 : i2;
    }

    public static long d(long j2, long j3) {
        return j2 > j3 ? j3 : j2;
    }

    public static int e(int i2, int i3, int i4) {
        if (i3 <= i4) {
            return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i4 + " is less than minimum " + i3 + '.');
    }

    @NotNull
    public static d_s0 f(int i2, int i3) {
        return d_s0.INSTANCE.a(i2, i3, -1);
    }

    @SinceKotlin(version = "1.3")
    public static int g(@NotNull f_s0 fS0Var, @NotNull Random random) {
        s.e(fS0Var, "<this>");
        s.e(random, "random");
        try {
            return kotlin.random.d.f(random, fS0Var);
        } catch (IllegalArgumentException e2) {
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @NotNull
    public static f_s0 h(int i2, int i3) {
        return i3 <= Integer.MIN_VALUE ? f_s0.INSTANCE.a() : new f_s0(i2, i3 - 1);
    }
}
