package kotlin.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.g0;
import kotlin.collections.v;
import p0.l_p0;
import p0.p_p0;
import s0.d_s0;
import s0.f_s0;
import s0.l_s0;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Strings.kt */
@Metadata(bv = {}, d1 = {"\u0000f\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0002\b\b\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000e\u001a\n\u0010\u0001\u001a\u00020\u0000*\u00020\u0000\u001a\u001c\u0010\u0006\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u001a\u001c\u0010\b\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u001a\r\u0010\n\u001a\u00020\t*\u00020\u0000H\u0086\u0002\u001a\u0012\u0010\r\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b\u001a\u001c\u0010\u0010\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u001a\u001c\u0010\u0011\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u001a\u001c\u0010\u0012\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u001a\u001c\u0010\u0013\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u001a\u001c\u0010\u0014\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u001a4\u0010\u001a\u001a\u00020\u0018*\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0000\u001a&\u0010\u001e\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u001a&\u0010\u001f\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u001a=\u0010\"\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010!\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\"\u0010#\u001aG\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0018\u00010&*\u00020\u00002\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00070$2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u0018H\u0002¢\u0006\u0004\b'\u0010(\u001a&\u0010*\u001a\u00020\u0002*\u00020\u00002\u0006\u0010)\u001a\u00020\u00042\b\b\u0002\u0010\u001d\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u001a&\u0010,\u001a\u00020\u0002*\u00020\u00002\u0006\u0010+\u001a\u00020\u00072\b\b\u0002\u0010\u001d\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u001a&\u0010-\u001a\u00020\u0002*\u00020\u00002\u0006\u0010)\u001a\u00020\u00042\b\b\u0002\u0010\u001d\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u001a&\u0010.\u001a\u00020\u0002*\u00020\u00002\u0006\u0010+\u001a\u00020\u00072\b\b\u0002\u0010\u001d\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u001a\u001f\u0010/\u001a\u00020\u0018*\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0019\u001a\u00020\u0018H\u0086\u0002\u001a?\u00103\u001a\b\u0012\u0004\u0012\u00020\u000b02*\u00020\u00002\u0006\u00100\u001a\u00020\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u00101\u001a\u00020\u0002H\u0002¢\u0006\u0004\b3\u00104\u001aG\u00106\u001a\b\u0012\u0004\u0012\u00020\u000b02*\u00020\u00002\u000e\u00100\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u0007052\b\b\u0002\u0010\u001d\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u00101\u001a\u00020\u0002H\u0002¢\u0006\u0004\b6\u00107\u001a\u0010\u00109\u001a\u0002082\u0006\u00101\u001a\u00020\u0002H\u0000\u001a?\u0010:\u001a\b\u0012\u0004\u0012\u00020\u000702*\u00020\u00002\u0012\u00100\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000705\"\u00020\u00072\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u00101\u001a\u00020\u0002¢\u0006\u0004\b:\u0010;\u001a?\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00070<*\u00020\u00002\u0012\u00100\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000705\"\u00020\u00072\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u00101\u001a\u00020\u0002¢\u0006\u0004\b=\u0010>\u001a0\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00070<*\u00020\u00002\n\u00100\u001a\u00020\u001b\"\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u00101\u001a\u00020\u0002\u001a1\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00070<*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u00101\u001a\u00020\u0002H\u0002¢\u0006\u0004\b@\u0010A\u001a\u0010\u0010B\u001a\b\u0012\u0004\u0012\u00020\u000702*\u00020\u0000\u001a\u0010\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00070<*\u00020\u0000\"\u0015\u0010F\u001a\u00020\u000b*\u00020\u00008F¢\u0006\u0006\u001a\u0004\bD\u0010E\"\u0015\u0010I\u001a\u00020\u0002*\u00020\u00008F¢\u0006\u0006\u001a\u0004\bG\u0010H¨\u0006J"}, d2 = {"", "q0", "", "length", "", "padChar", "Q", "", "R", "Lkotlin/collections/r;", "I", "Ls0/f;", "range", "f0", "delimiter", "missingDelimiterValue", "m0", "n0", "g0", "h0", "k0", "thisOffset", "other", "otherOffset", "", "ignoreCase", "W", "", "chars", "startIndex", "H", "N", "endIndex", "last", "D", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IIZZ)I", "", "strings", "Lkotlin/Pair;", "y", "(Ljava/lang/CharSequence;Ljava/util/Collection;IZZ)Lkotlin/Pair;", "char", "B", "string", "C", "J", "K", "w", "delimiters", "limit", "Lkotlin/sequences/d;", "S", "(Ljava/lang/CharSequence;[CIZI)Lkotlin/sequences/d;", "", "T", "(Ljava/lang/CharSequence;[Ljava/lang/String;IZI)Lkotlin/sequences/d;", "Lkotlin/t;", "X", "d0", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Lkotlin/sequences/d;", "", "Z", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Ljava/util/List;", "Y", "a0", "(Ljava/lang/CharSequence;Ljava/lang/String;ZI)Ljava/util/List;", "O", "P", "z", "(Ljava/lang/CharSequence;)Ls0/f;", "indices", "A", "(Ljava/lang/CharSequence;)I", "lastIndex", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/text/StringsKt")
/* loaded from: classes.dex */
public class StringsKt__StringsKt extends s {

    /* compiled from: Strings.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u0096\u0002R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"kotlin/text/StringsKt__StringsKt$a", "Lkotlin/collections/r;", "", "a", "", "hasNext", "", "e", "I", "index", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
    public static final class a extends kotlin.collections.r {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int index;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ CharSequence f3513f;

        a(CharSequence charSequence) {
            this.f3513f = charSequence;
        }

        @Override // kotlin.collections.r
        public char a() {
            CharSequence charSequence = this.f3513f;
            int i2 = this.index;
            this.index = i2 + 1;
            return charSequence.charAt(i2);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.f3513f.length();
        }
    }

    public static final int A(@NotNull CharSequence charSequence) {
        kotlin.jvm.internal.s.e(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int B(@NotNull CharSequence charSequence, char c2, int i2, boolean z2) {
        kotlin.jvm.internal.s.e(charSequence, "<this>");
        return (z2 || !(charSequence instanceof String)) ? H(charSequence, new char[]{c2}, i2, z2) : ((String) charSequence).indexOf(c2, i2);
    }

    public static final int C(@NotNull CharSequence charSequence, @NotNull String string, int i2, boolean z2) {
        kotlin.jvm.internal.s.e(charSequence, "<this>");
        kotlin.jvm.internal.s.e(string, "string");
        return (z2 || !(charSequence instanceof String)) ? E(charSequence, string, i2, charSequence.length(), z2, false, 16, null) : ((String) charSequence).indexOf(string, i2);
    }

    private static final int D(CharSequence charSequence, CharSequence charSequence2, int i2, int i3, boolean z2, boolean z3) {
        d_s0 fVar = !z3 ? new f_s0(l_s0.a(i2, 0), l_s0.c(i3, charSequence.length())) : l_s0.f(l_s0.c(i2, A(charSequence)), l_s0.a(i3, 0));
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int iA = fVar.getFirst();
            int iB = fVar.getLast();
            int iC = fVar.getStep();
            if ((iC <= 0 || iA > iB) && (iC >= 0 || iB > iA)) {
                return -1;
            }
            while (!s.n((String) charSequence2, 0, (String) charSequence, iA, charSequence2.length(), z2)) {
                if (iA == iB) {
                    return -1;
                }
                iA += iC;
            }
            return iA;
        }
        int iA2 = fVar.getFirst();
        int iB2 = fVar.getLast();
        int iC2 = fVar.getStep();
        if ((iC2 <= 0 || iA2 > iB2) && (iC2 >= 0 || iB2 > iA2)) {
            return -1;
        }
        while (!W(charSequence2, 0, charSequence, iA2, charSequence2.length(), z2)) {
            if (iA2 == iB2) {
                return -1;
            }
            iA2 += iC2;
        }
        return iA2;
    }

    static /* synthetic */ int E(CharSequence charSequence, CharSequence charSequence2, int i2, int i3, boolean z2, boolean z3, int i4, Object obj) {
        return D(charSequence, charSequence2, i2, i3, z2, (i4 & 16) != 0 ? false : z3);
    }

    public static /* synthetic */ int F(CharSequence charSequence, char c2, int i2, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        return B(charSequence, c2, i2, z2);
    }

    public static /* synthetic */ int G(CharSequence charSequence, String str, int i2, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        return C(charSequence, str, i2, z2);
    }

    public static final int H(@NotNull CharSequence charSequence, @NotNull char[] chars, int i2, boolean z2) {
        boolean z3;
        kotlin.jvm.internal.s.e(charSequence, "<this>");
        kotlin.jvm.internal.s.e(chars, "chars");
        if (!z2 && chars.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(kotlin.collections.n.p(chars), i2);
        }
        g0 g0VarD = new f_s0(l_s0.a(i2, 0), A(charSequence)).iterator();
        while (g0VarD.hasNext()) {
            int iNextInt = g0VarD.nextInt();
            char cCharAt = charSequence.charAt(iNextInt);
            int length = chars.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    z3 = false;
                    break;
                }
                if (c.e(chars[i3], cCharAt, z2)) {
                    z3 = true;
                    break;
                }
                i3++;
            }
            if (z3) {
                return iNextInt;
            }
        }
        return -1;
    }

    @NotNull
    public static final kotlin.collections.r I(@NotNull CharSequence charSequence) {
        kotlin.jvm.internal.s.e(charSequence, "<this>");
        return new a(charSequence);
    }

    public static final int J(@NotNull CharSequence charSequence, char c2, int i2, boolean z2) {
        kotlin.jvm.internal.s.e(charSequence, "<this>");
        return (z2 || !(charSequence instanceof String)) ? N(charSequence, new char[]{c2}, i2, z2) : ((String) charSequence).lastIndexOf(c2, i2);
    }

    public static final int K(@NotNull CharSequence charSequence, @NotNull String string, int i2, boolean z2) {
        kotlin.jvm.internal.s.e(charSequence, "<this>");
        kotlin.jvm.internal.s.e(string, "string");
        return (z2 || !(charSequence instanceof String)) ? D(charSequence, string, i2, 0, z2, true) : ((String) charSequence).lastIndexOf(string, i2);
    }

    public static /* synthetic */ int L(CharSequence charSequence, char c2, int i2, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = A(charSequence);
        }
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        return J(charSequence, c2, i2, z2);
    }

    public static /* synthetic */ int M(CharSequence charSequence, String str, int i2, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = A(charSequence);
        }
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        return K(charSequence, str, i2, z2);
    }

    public static final int N(@NotNull CharSequence charSequence, @NotNull char[] chars, int i2, boolean z2) {
        kotlin.jvm.internal.s.e(charSequence, "<this>");
        kotlin.jvm.internal.s.e(chars, "chars");
        if (!z2 && chars.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(kotlin.collections.n.p(chars), i2);
        }
        for (int iC = l_s0.c(i2, A(charSequence)); -1 < iC; iC--) {
            char cCharAt = charSequence.charAt(iC);
            int length = chars.length;
            boolean z3 = false;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                if (c.e(chars[i3], cCharAt, z2)) {
                    z3 = true;
                    break;
                }
                i3++;
            }
            if (z3) {
                return iC;
            }
        }
        return -1;
    }

    @NotNull
    public static final kotlin.sequences.d<String> O(@NotNull CharSequence charSequence) {
        kotlin.jvm.internal.s.e(charSequence, "<this>");
        return e0(charSequence, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, null);
    }

    @NotNull
    public static final List<String> P(@NotNull CharSequence charSequence) {
        kotlin.jvm.internal.s.e(charSequence, "<this>");
        return kotlin.sequences.k.l(O(charSequence));
    }

    @NotNull
    public static final CharSequence Q(@NotNull CharSequence charSequence, int i2, char c2) {
        kotlin.jvm.internal.s.e(charSequence, "<this>");
        if (i2 < 0) {
            throw new IllegalArgumentException("Desired length " + i2 + " is less than zero.");
        }
        if (i2 <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb = new StringBuilder(i2);
        g0 g0VarD = new f_s0(1, i2 - charSequence.length()).iterator();
        while (g0VarD.hasNext()) {
            g0VarD.nextInt();
            sb.append(c2);
        }
        sb.append(charSequence);
        return sb;
    }

    @NotNull
    public static String R(@NotNull String str, int i2, char c2) {
        kotlin.jvm.internal.s.e(str, "<this>");
        return Q(str, i2, c2).toString();
    }

    private static final kotlin.sequences.d<f_s0> S(CharSequence charSequence, final char[] cArr, int i2, final boolean z2, int i3) {
        X(i3);
        return new e(charSequence, i2, i3, new p_p0<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>>() { // from class: kotlin.text.StringsKt__StringsKt$rangesDelimitedBy$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // p0.p
            public /* bridge */ /* synthetic */ Pair<? extends Integer, ? extends Integer> invoke(CharSequence charSequence2, Integer num) {
                return invoke(charSequence2, num.intValue());
            }

            @Nullable
            public final Pair<Integer, Integer> invoke(@NotNull CharSequence $receiver, int i4) {
                kotlin.jvm.internal.s.e($receiver, "$this$$receiver");
                int iH = StringsKt__StringsKt.H($receiver, cArr, i4, z2);
                if (iH < 0) {
                    return null;
                }
                return kotlin.j.a(Integer.valueOf(iH), 1);
            }
        });
    }

    private static final kotlin.sequences.d<f_s0> T(CharSequence charSequence, String[] strArr, int i2, final boolean z2, int i3) {
        X(i3);
        final List listB = kotlin.collections.m.b(strArr);
        return new e(charSequence, i2, i3, new p_p0<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>>() { // from class: kotlin.text.StringsKt__StringsKt$rangesDelimitedBy$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // p0.p
            public /* bridge */ /* synthetic */ Pair<? extends Integer, ? extends Integer> invoke(CharSequence charSequence2, Integer num) {
                return invoke(charSequence2, num.intValue());
            }

            @Nullable
            public final Pair<Integer, Integer> invoke(@NotNull CharSequence $receiver, int i4) {
                kotlin.jvm.internal.s.e($receiver, "$this$$receiver");
                Pair pairY = StringsKt__StringsKt.y($receiver, listB, i4, z2, false);
                if (pairY != null) {
                    return kotlin.j.a(pairY.getFirst(), Integer.valueOf(((String) pairY.getSecond()).length()));
                }
                return null;
            }
        });
    }

    static /* synthetic */ kotlin.sequences.d U(CharSequence charSequence, char[] cArr, int i2, boolean z2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            z2 = false;
        }
        if ((i4 & 8) != 0) {
            i3 = 0;
        }
        return S(charSequence, cArr, i2, z2, i3);
    }

    static /* synthetic */ kotlin.sequences.d V(CharSequence charSequence, String[] strArr, int i2, boolean z2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            z2 = false;
        }
        if ((i4 & 8) != 0) {
            i3 = 0;
        }
        return T(charSequence, strArr, i2, z2, i3);
    }

    public static final boolean W(@NotNull CharSequence charSequence, int i2, @NotNull CharSequence other, int i3, int i4, boolean z2) {
        kotlin.jvm.internal.s.e(charSequence, "<this>");
        kotlin.jvm.internal.s.e(other, "other");
        if (i3 < 0 || i2 < 0 || i2 > charSequence.length() - i4 || i3 > other.length() - i4) {
            return false;
        }
        for (int i5 = 0; i5 < i4; i5++) {
            if (!c.e(charSequence.charAt(i2 + i5), other.charAt(i3 + i5), z2)) {
                return false;
            }
        }
        return true;
    }

    public static final void X(int i2) {
        if (i2 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2).toString());
    }

    @NotNull
    public static final List<String> Y(@NotNull CharSequence charSequence, @NotNull char[] delimiters, boolean z2, int i2) {
        kotlin.jvm.internal.s.e(charSequence, "<this>");
        kotlin.jvm.internal.s.e(delimiters, "delimiters");
        if (delimiters.length == 1) {
            return a0(charSequence, String.valueOf(delimiters[0]), z2, i2);
        }
        Iterable iterableG = kotlin.sequences.k.g(U(charSequence, delimiters, 0, z2, i2, 2, null));
        ArrayList arrayList = new ArrayList(v.o(iterableG, 10));
        Iterator it = iterableG.iterator();
        while (it.hasNext()) {
            arrayList.add(f0(charSequence, (f_s0) it.next()));
        }
        return arrayList;
    }

    @NotNull
    public static final List<String> Z(@NotNull CharSequence charSequence, @NotNull String[] delimiters, boolean z2, int i2) {
        kotlin.jvm.internal.s.e(charSequence, "<this>");
        kotlin.jvm.internal.s.e(delimiters, "delimiters");
        if (delimiters.length == 1) {
            String str = delimiters[0];
            if (!(str.length() == 0)) {
                return a0(charSequence, str, z2, i2);
            }
        }
        Iterable iterableG = kotlin.sequences.k.g(V(charSequence, delimiters, 0, z2, i2, 2, null));
        ArrayList arrayList = new ArrayList(v.o(iterableG, 10));
        Iterator it = iterableG.iterator();
        while (it.hasNext()) {
            arrayList.add(f0(charSequence, (f_s0) it.next()));
        }
        return arrayList;
    }

    private static final List<String> a0(CharSequence charSequence, String str, boolean z2, int i2) {
        X(i2);
        int length = 0;
        int iC = C(charSequence, str, 0, z2);
        if (iC == -1 || i2 == 1) {
            return kotlin.collections.t.e(charSequence.toString());
        }
        boolean z3 = i2 > 0;
        ArrayList arrayList = new ArrayList(z3 ? l_s0.c(i2, 10) : 10);
        do {
            arrayList.add(charSequence.subSequence(length, iC).toString());
            length = str.length() + iC;
            if (z3 && arrayList.size() == i2 - 1) {
                break;
            }
            iC = C(charSequence, str, length, z2);
        } while (iC != -1);
        arrayList.add(charSequence.subSequence(length, charSequence.length()).toString());
        return arrayList;
    }

    public static /* synthetic */ List b0(CharSequence charSequence, char[] cArr, boolean z2, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return Y(charSequence, cArr, z2, i2);
    }

    public static /* synthetic */ List c0(CharSequence charSequence, String[] strArr, boolean z2, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return Z(charSequence, strArr, z2, i2);
    }

    @NotNull
    public static final kotlin.sequences.d<String> d0(@NotNull final CharSequence charSequence, @NotNull String[] delimiters, boolean z2, int i2) {
        kotlin.jvm.internal.s.e(charSequence, "<this>");
        kotlin.jvm.internal.s.e(delimiters, "delimiters");
        return kotlin.sequences.k.j(V(charSequence, delimiters, 0, z2, i2, 2, null), new l_p0<f_s0, String>() { // from class: kotlin.text.StringsKt__StringsKt$splitToSequence$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // p0.l
            @NotNull
            public final String invoke(@NotNull f_s0 it) {
                kotlin.jvm.internal.s.e(it, "it");
                return StringsKt__StringsKt.f0(charSequence, it);
            }
        });
    }

    public static /* synthetic */ kotlin.sequences.d e0(CharSequence charSequence, String[] strArr, boolean z2, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return d0(charSequence, strArr, z2, i2);
    }

    @NotNull
    public static final String f0(@NotNull CharSequence charSequence, @NotNull f_s0 range) {
        kotlin.jvm.internal.s.e(charSequence, "<this>");
        kotlin.jvm.internal.s.e(range, "range");
        return charSequence.subSequence(range.h().intValue(), range.g().intValue() + 1).toString();
    }

    @NotNull
    public static final String g0(@NotNull String str, char c2, @NotNull String missingDelimiterValue) {
        kotlin.jvm.internal.s.e(str, "<this>");
        kotlin.jvm.internal.s.e(missingDelimiterValue, "missingDelimiterValue");
        int iF = F(str, c2, 0, false, 6, null);
        if (iF == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iF + 1, str.length());
        kotlin.jvm.internal.s.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    @NotNull
    public static final String h0(@NotNull String str, @NotNull String delimiter, @NotNull String missingDelimiterValue) {
        kotlin.jvm.internal.s.e(str, "<this>");
        kotlin.jvm.internal.s.e(delimiter, "delimiter");
        kotlin.jvm.internal.s.e(missingDelimiterValue, "missingDelimiterValue");
        int iG = G(str, delimiter, 0, false, 6, null);
        if (iG == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iG + delimiter.length(), str.length());
        kotlin.jvm.internal.s.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static /* synthetic */ String i0(String str, char c2, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = str;
        }
        return g0(str, c2, str2);
    }

    public static /* synthetic */ String j0(String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str3 = str;
        }
        return h0(str, str2, str3);
    }

    @NotNull
    public static final String k0(@NotNull String str, char c2, @NotNull String missingDelimiterValue) {
        kotlin.jvm.internal.s.e(str, "<this>");
        kotlin.jvm.internal.s.e(missingDelimiterValue, "missingDelimiterValue");
        int iL = L(str, c2, 0, false, 6, null);
        if (iL == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iL + 1, str.length());
        kotlin.jvm.internal.s.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static /* synthetic */ String l0(String str, char c2, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = str;
        }
        return k0(str, c2, str2);
    }

    @NotNull
    public static final String m0(@NotNull String str, char c2, @NotNull String missingDelimiterValue) {
        kotlin.jvm.internal.s.e(str, "<this>");
        kotlin.jvm.internal.s.e(missingDelimiterValue, "missingDelimiterValue");
        int iF = F(str, c2, 0, false, 6, null);
        if (iF == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(0, iF);
        kotlin.jvm.internal.s.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    @NotNull
    public static final String n0(@NotNull String str, @NotNull String delimiter, @NotNull String missingDelimiterValue) {
        kotlin.jvm.internal.s.e(str, "<this>");
        kotlin.jvm.internal.s.e(delimiter, "delimiter");
        kotlin.jvm.internal.s.e(missingDelimiterValue, "missingDelimiterValue");
        int iG = G(str, delimiter, 0, false, 6, null);
        if (iG == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(0, iG);
        kotlin.jvm.internal.s.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static /* synthetic */ String o0(String str, char c2, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = str;
        }
        return m0(str, c2, str2);
    }

    public static /* synthetic */ String p0(String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str3 = str;
        }
        return n0(str, str2, str3);
    }

    @NotNull
    public static CharSequence q0(@NotNull CharSequence charSequence) {
        kotlin.jvm.internal.s.e(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i2 = 0;
        boolean z2 = false;
        while (i2 <= length) {
            boolean zC = b.c(charSequence.charAt(!z2 ? i2 : length));
            if (z2) {
                if (!zC) {
                    break;
                }
                length--;
            } else if (zC) {
                i2++;
            } else {
                z2 = true;
            }
        }
        return charSequence.subSequence(i2, length + 1);
    }

    public static final boolean w(@NotNull CharSequence charSequence, @NotNull CharSequence other, boolean z2) {
        kotlin.jvm.internal.s.e(charSequence, "<this>");
        kotlin.jvm.internal.s.e(other, "other");
        if (other instanceof String) {
            if (G(charSequence, (String) other, 0, z2, 2, null) >= 0) {
                return true;
            }
        } else if (E(charSequence, other, 0, charSequence.length(), z2, false, 16, null) >= 0) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean x(CharSequence charSequence, CharSequence charSequence2, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        return w(charSequence, charSequence2, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair<Integer, String> y(CharSequence charSequence, Collection<String> collection, int i2, boolean z2, boolean z3) {
        Object next;
        Object next2;
        if (!z2 && collection.size() == 1) {
            String str = (String) CollectionsKt___CollectionsKt.Q(collection);
            int iG = !z3 ? G(charSequence, str, i2, false, 4, null) : M(charSequence, str, i2, false, 4, null);
            if (iG < 0) {
                return null;
            }
            return kotlin.j.a(Integer.valueOf(iG), str);
        }
        d_s0 fVar = !z3 ? new f_s0(l_s0.a(i2, 0), charSequence.length()) : l_s0.f(l_s0.c(i2, A(charSequence)), 0);
        if (charSequence instanceof String) {
            int iA = fVar.getFirst();
            int iB = fVar.getLast();
            int iC = fVar.getStep();
            if ((iC > 0 && iA <= iB) || (iC < 0 && iB <= iA)) {
                while (true) {
                    Iterator<T> it = collection.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it.next();
                        String str2 = (String) next2;
                        if (s.n(str2, 0, (String) charSequence, iA, str2.length(), z2)) {
                            break;
                        }
                    }
                    String str3 = (String) next2;
                    if (str3 == null) {
                        if (iA == iB) {
                            break;
                        }
                        iA += iC;
                    } else {
                        return kotlin.j.a(Integer.valueOf(iA), str3);
                    }
                }
            }
        } else {
            int iA2 = fVar.getFirst();
            int iB2 = fVar.getLast();
            int iC2 = fVar.getStep();
            if ((iC2 > 0 && iA2 <= iB2) || (iC2 < 0 && iB2 <= iA2)) {
                while (true) {
                    Iterator<T> it2 = collection.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it2.next();
                        String str4 = (String) next;
                        if (W(str4, 0, charSequence, iA2, str4.length(), z2)) {
                            break;
                        }
                    }
                    String str5 = (String) next;
                    if (str5 == null) {
                        if (iA2 == iB2) {
                            break;
                        }
                        iA2 += iC2;
                    } else {
                        return kotlin.j.a(Integer.valueOf(iA2), str5);
                    }
                }
            }
        }
        return null;
    }

    @NotNull
    public static final f_s0 z(@NotNull CharSequence charSequence) {
        kotlin.jvm.internal.s.e(charSequence, "<this>");
        return new f_s0(0, charSequence.length() - 1);
    }
}
