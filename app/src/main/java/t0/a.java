package t0;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import kotlin.text.StringsKt__StringsKt;
import kotlin.time.DurationUnit;
import kotlin.time.ExperimentalTime;
import org.jetbrains.annotations.NotNull;
import s0.i;

/* compiled from: Duration.kt */
@SinceKotlin(version = "1.6")
@Metadata(bv = {}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b%\b\u0087@\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001FB\u0014\b\u0000\u0012\u0006\u0010'\u001a\u00020\u0011ø\u0001\u0001¢\u0006\u0004\b%\u0010\u0007J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0016\u0010\u0006\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0004J\r\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\u0004J\r\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u0004J\u001b\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0000H\u0096\u0002ø\u0001\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J?\u0010\u001e\u001a\u00020\u001d*\u00060\u0017j\u0002`\u00182\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\fHÖ\u0001¢\u0006\u0004\b \u0010!J\u001a\u0010#\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\"HÖ\u0003¢\u0006\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010)\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u0007R\u0014\u0010,\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0017\u0010.\u001a\u00020\u00008Fø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b-\u0010\u0007R\u001a\u00102\u001a\u00020\f8@X\u0081\u0004¢\u0006\f\u0012\u0004\b0\u00101\u001a\u0004\b/\u0010!R\u001a\u00105\u001a\u00020\f8@X\u0081\u0004¢\u0006\f\u0012\u0004\b4\u00101\u001a\u0004\b3\u0010!R\u001a\u00108\u001a\u00020\f8@X\u0081\u0004¢\u0006\f\u0012\u0004\b7\u00101\u001a\u0004\b6\u0010!R\u001a\u0010;\u001a\u00020\f8@X\u0081\u0004¢\u0006\f\u0012\u0004\b:\u00101\u001a\u0004\b9\u0010!R\u0011\u0010=\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b<\u0010\u0007R\u0011\u0010?\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b>\u0010\u0007R\u0011\u0010A\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b@\u0010\u0007R\u0011\u0010C\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\bB\u0010\u0007R\u0011\u0010E\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\bD\u0010\u0007\u0088\u0001'\u0092\u0001\u00020\u0011ø\u0001\u0001\u0082\u0002\b\n\u0002\b!\n\u0002\b\u0019¨\u0006G"}, d2 = {"Lt0/a;", "", "", "v", "(J)Z", "u", "A", "(J)J", "x", "w", "t", "other", "", "d", "(JJ)I", "Lkotlin/time/DurationUnit;", "unit", "", "y", "(JLkotlin/time/DurationUnit;)J", "", "z", "(J)Ljava/lang/String;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "whole", "fractional", "fractionalSize", "isoZeroes", "Lkotlin/t;", "b", "(JLjava/lang/StringBuilder;IIILjava/lang/String;Z)V", "s", "(J)I", "", "f", "(JLjava/lang/Object;)Z", "e", "J", "rawValue", "r", "value", "q", "(J)Lkotlin/time/DurationUnit;", "storageUnit", "g", "absoluteValue", "h", "getHoursComponent$annotations", "()V", "hoursComponent", "n", "getMinutesComponent$annotations", "minutesComponent", "p", "getSecondsComponent$annotations", "secondsComponent", "o", "getNanosecondsComponent$annotations", "nanosecondsComponent", "i", "inWholeDays", "j", "inWholeHours", "l", "inWholeMinutes", "m", "inWholeSeconds", "k", "inWholeMilliseconds", "a", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
@JvmInline
@WasExperimental(markerClass = {ExperimentalTime.class})
/* loaded from: classes.dex */
public final class a implements Comparable<a> {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: g, reason: collision with root package name */
    private static final long f4127g = e(0);

    /* renamed from: h, reason: collision with root package name */
    private static final long f4128h = c.e(4611686018427387903L);

    /* renamed from: i, reason: collision with root package name */
    private static final long f4129i = c.e(-4611686018427387903L);

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final long rawValue;

    /* compiled from: Duration.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001d\u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\t"}, d2 = {"Lt0/a$a;", "", "Lt0/a;", "ZERO", "J", "a", "()J", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
    /* renamed from: t0.a$a, reason: collision with other inner class name and from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(o oVar) {
            this();
        }

        public final long a() {
            return a.f4127g;
        }
    }

    public static final long A(long j2) {
        return c.d(-r(j2), ((int) j2) & 1);
    }

    private static final void b(long j2, StringBuilder sb, int i2, int i3, int i4, String str, boolean z2) {
        sb.append(i2);
        if (i3 != 0) {
            sb.append('.');
            String strR = StringsKt__StringsKt.R(String.valueOf(i3), i4, '0');
            int i5 = -1;
            int length = strR.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i6 = length - 1;
                    if (strR.charAt(length) != '0') {
                        i5 = length;
                        break;
                    } else if (i6 < 0) {
                        break;
                    } else {
                        length = i6;
                    }
                }
            }
            int i7 = i5 + 1;
            if (z2 || i7 >= 3) {
                sb.append((CharSequence) strR, 0, ((i7 + 2) / 3) * 3);
                s.d(sb, "this.append(value, startIndex, endIndex)");
            } else {
                sb.append((CharSequence) strR, 0, i7);
                s.d(sb, "this.append(value, startIndex, endIndex)");
            }
        }
        sb.append(str);
    }

    public static int d(long j2, long j3) {
        long j4 = j2 ^ j3;
        if (j4 < 0 || (((int) j4) & 1) == 0) {
            return s.g(j2, j3);
        }
        int i2 = (((int) j2) & 1) - (((int) j3) & 1);
        return x(j2) ? -i2 : i2;
    }

    public static long e(long j2) {
        if (b.a()) {
            if (v(j2)) {
                if (!new i(-4611686018426999999L, 4611686018426999999L).d(r(j2))) {
                    throw new AssertionError(r(j2) + " ns is out of nanoseconds range");
                }
            } else {
                if (!new i(-4611686018427387903L, 4611686018427387903L).d(r(j2))) {
                    throw new AssertionError(r(j2) + " ms is out of milliseconds range");
                }
                if (new i(-4611686018426L, 4611686018426L).d(r(j2))) {
                    throw new AssertionError(r(j2) + " ms is denormalized");
                }
            }
        }
        return j2;
    }

    public static boolean f(long j2, Object obj) {
        return (obj instanceof a) && j2 == ((a) obj).getRawValue();
    }

    public static final long g(long j2) {
        return x(j2) ? A(j2) : j2;
    }

    public static final int h(long j2) {
        if (w(j2)) {
            return 0;
        }
        return (int) (j(j2) % 24);
    }

    public static final long i(long j2) {
        return y(j2, DurationUnit.DAYS);
    }

    public static final long j(long j2) {
        return y(j2, DurationUnit.HOURS);
    }

    public static final long k(long j2) {
        return (u(j2) && t(j2)) ? r(j2) : y(j2, DurationUnit.MILLISECONDS);
    }

    public static final long l(long j2) {
        return y(j2, DurationUnit.MINUTES);
    }

    public static final long m(long j2) {
        return y(j2, DurationUnit.SECONDS);
    }

    public static final int n(long j2) {
        if (w(j2)) {
            return 0;
        }
        return (int) (l(j2) % 60);
    }

    public static final int o(long j2) {
        if (w(j2)) {
            return 0;
        }
        return (int) (u(j2) ? c.f(r(j2) % 1000) : r(j2) % 1000000000);
    }

    public static final int p(long j2) {
        if (w(j2)) {
            return 0;
        }
        return (int) (m(j2) % 60);
    }

    private static final DurationUnit q(long j2) {
        return v(j2) ? DurationUnit.NANOSECONDS : DurationUnit.MILLISECONDS;
    }

    private static final long r(long j2) {
        return j2 >> 1;
    }

    public static int s(long j2) {
        return (int) (j2 ^ (j2 >>> 32));
    }

    public static final boolean t(long j2) {
        return !w(j2);
    }

    private static final boolean u(long j2) {
        return (((int) j2) & 1) == 1;
    }

    private static final boolean v(long j2) {
        return (((int) j2) & 1) == 0;
    }

    public static final boolean w(long j2) {
        return j2 == f4128h || j2 == f4129i;
    }

    public static final boolean x(long j2) {
        return j2 < 0;
    }

    public static final long y(long j2, @NotNull DurationUnit unit) {
        s.e(unit, "unit");
        if (j2 == f4128h) {
            return Long.MAX_VALUE;
        }
        if (j2 == f4129i) {
            return Long.MIN_VALUE;
        }
        return d.a(r(j2), q(j2), unit);
    }

    @NotNull
    public static String z(long j2) {
        if (j2 == 0) {
            return "0s";
        }
        if (j2 == f4128h) {
            return "Infinity";
        }
        if (j2 == f4129i) {
            return "-Infinity";
        }
        boolean zX = x(j2);
        StringBuilder sb = new StringBuilder();
        if (zX) {
            sb.append('-');
        }
        long jG = g(j2);
        long jI = i(jG);
        int iH = h(jG);
        int iN = n(jG);
        int iP = p(jG);
        int iO = o(jG);
        int i2 = 0;
        boolean z2 = jI != 0;
        boolean z3 = iH != 0;
        boolean z4 = iN != 0;
        boolean z5 = (iP == 0 && iO == 0) ? false : true;
        if (z2) {
            sb.append(jI);
            sb.append('d');
            i2 = 1;
        }
        if (z3 || (z2 && (z4 || z5))) {
            int i3 = i2 + 1;
            if (i2 > 0) {
                sb.append(' ');
            }
            sb.append(iH);
            sb.append('h');
            i2 = i3;
        }
        if (z4 || (z5 && (z3 || z2))) {
            int i4 = i2 + 1;
            if (i2 > 0) {
                sb.append(' ');
            }
            sb.append(iN);
            sb.append('m');
            i2 = i4;
        }
        if (z5) {
            int i5 = i2 + 1;
            if (i2 > 0) {
                sb.append(' ');
            }
            if (iP != 0 || z2 || z3 || z4) {
                b(j2, sb, iP, iO, 9, "s", false);
            } else if (iO >= 1000000) {
                b(j2, sb, iO / 1000000, iO % 1000000, 6, "ms", false);
            } else if (iO >= 1000) {
                b(j2, sb, iO / 1000, iO % 1000, 3, "us", false);
            } else {
                sb.append(iO);
                sb.append("ns");
            }
            i2 = i5;
        }
        if (zX && i2 > 1) {
            sb.insert(1, '(').append(')');
        }
        String string = sb.toString();
        s.d(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* renamed from: B, reason: from getter */
    public final /* synthetic */ long getRawValue() {
        return this.rawValue;
    }

    public int c(long j2) {
        return d(this.rawValue, j2);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(a aVar) {
        return c(aVar.getRawValue());
    }

    public boolean equals(Object obj) {
        return f(this.rawValue, obj);
    }

    public int hashCode() {
        return s(this.rawValue);
    }

    @NotNull
    public String toString() {
        return z(this.rawValue);
    }
}
