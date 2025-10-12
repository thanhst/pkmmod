package kotlin.text;

import com.bumptech.glide.request.target.Target;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StringNumberConversions.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\u001a\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007*\u00020\u0000H\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u001d\u0010\n\u001a\u0004\u0018\u00010\u0007*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"", "", "f", "(Ljava/lang/String;)Ljava/lang/Integer;", "radix", "g", "(Ljava/lang/String;I)Ljava/lang/Integer;", "", "h", "(Ljava/lang/String;)Ljava/lang/Long;", "i", "(Ljava/lang/String;I)Ljava/lang/Long;", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/text/StringsKt")
/* loaded from: classes.dex */
public class r extends q {
    @SinceKotlin(version = "1.1")
    @Nullable
    public static Integer f(@NotNull String str) {
        kotlin.jvm.internal.s.e(str, "<this>");
        return g(str, 10);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static final Integer g(@NotNull String str, int i2) {
        boolean z2;
        int i3;
        kotlin.jvm.internal.s.e(str, "<this>");
        b.a(i2);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i4 = 0;
        char cCharAt = str.charAt(0);
        int i5 = -2147483647;
        int i6 = 1;
        if (kotlin.jvm.internal.s.f(cCharAt, 48) >= 0) {
            z2 = false;
            i6 = 0;
        } else {
            if (length == 1) {
                return null;
            }
            if (cCharAt == '-') {
                i5 = Target.SIZE_ORIGINAL;
                z2 = true;
            } else {
                if (cCharAt != '+') {
                    return null;
                }
                z2 = false;
            }
        }
        int i7 = -59652323;
        while (i6 < length) {
            int iB = b.b(str.charAt(i6), i2);
            if (iB < 0) {
                return null;
            }
            if ((i4 < i7 && (i7 != -59652323 || i4 < (i7 = i5 / i2))) || (i3 = i4 * i2) < i5 + iB) {
                return null;
            }
            i4 = i3 - iB;
            i6++;
        }
        return z2 ? Integer.valueOf(i4) : Integer.valueOf(-i4);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static Long h(@NotNull String str) {
        kotlin.jvm.internal.s.e(str, "<this>");
        return i(str, 10);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static final Long i(@NotNull String str, int i2) {
        kotlin.jvm.internal.s.e(str, "<this>");
        b.a(i2);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i3 = 0;
        char cCharAt = str.charAt(0);
        long j2 = -9223372036854775807L;
        boolean z2 = true;
        if (kotlin.jvm.internal.s.f(cCharAt, 48) >= 0) {
            z2 = false;
        } else {
            if (length == 1) {
                return null;
            }
            if (cCharAt == '-') {
                j2 = Long.MIN_VALUE;
                i3 = 1;
            } else {
                if (cCharAt != '+') {
                    return null;
                }
                i3 = 1;
                z2 = false;
            }
        }
        long j3 = -256204778801521550L;
        long j4 = 0;
        long j5 = -256204778801521550L;
        while (i3 < length) {
            int iB = b.b(str.charAt(i3), i2);
            if (iB < 0) {
                return null;
            }
            if (j4 < j5) {
                if (j5 == j3) {
                    j5 = j2 / i2;
                    if (j4 < j5) {
                    }
                }
                return null;
            }
            long j6 = j4 * i2;
            long j7 = iB;
            if (j6 < j2 + j7) {
                return null;
            }
            j4 = j6 - j7;
            i3++;
            j3 = -256204778801521550L;
        }
        return z2 ? Long.valueOf(j4) : Long.valueOf(-j4);
    }
}
