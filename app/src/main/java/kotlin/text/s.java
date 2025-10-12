package kotlin.text;

import kotlin.Metadata;
import kotlin.collections.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StringsJVM.kt */
@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\n\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u001a \u0010\u0004\u001a\u00020\u0002*\u0004\u0018\u00010\u00002\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u001a$\u0010\b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u001a$\u0010\u000b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u001a\u001c\u0010\r\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u001a\u001c\u0010\u000f\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u001a\n\u0010\u0011\u001a\u00020\u0002*\u00020\u0010\u001a4\u0010\u0016\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00122\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u001a\u0012\u0010\u0017\u001a\u00020\u0000*\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0012¨\u0006\u0018"}, d2 = {"", "other", "", "ignoreCase", "l", "", "oldChar", "newChar", "p", "oldValue", "newValue", "q", "prefix", "t", "suffix", "j", "", "m", "", "thisOffset", "otherOffset", "length", "n", "o", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/text/StringsKt")
/* loaded from: classes.dex */
public class s extends r {
    public static final boolean j(@NotNull String str, @NotNull String suffix, boolean z2) {
        kotlin.jvm.internal.s.e(str, "<this>");
        kotlin.jvm.internal.s.e(suffix, "suffix");
        return !z2 ? str.endsWith(suffix) : n(str, str.length() - suffix.length(), suffix, 0, suffix.length(), true);
    }

    public static /* synthetic */ boolean k(String str, String str2, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        return j(str, str2, z2);
    }

    public static boolean l(@Nullable String str, @Nullable String str2, boolean z2) {
        return str == null ? str2 == null : !z2 ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m(@org.jetbrains.annotations.NotNull java.lang.CharSequence r4) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.s.e(r4, r0)
            int r0 = r4.length()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L3e
            s0.f r0 = kotlin.text.StringsKt__StringsKt.z(r4)
            boolean r3 = r0 instanceof java.util.Collection
            if (r3 == 0) goto L20
            r3 = r0
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L20
        L1e:
            r4 = 1
            goto L3c
        L20:
            java.util.Iterator r0 = r0.iterator()
        L24:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L1e
            r3 = r0
            kotlin.collections.g0 r3 = (kotlin.collections.g0) r3
            int r3 = r3.nextInt()
            char r3 = r4.charAt(r3)
            boolean r3 = kotlin.text.b.c(r3)
            if (r3 != 0) goto L24
            r4 = 0
        L3c:
            if (r4 == 0) goto L3f
        L3e:
            r1 = 1
        L3f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.s.m(java.lang.CharSequence):boolean");
    }

    public static final boolean n(@NotNull String str, int i2, @NotNull String other, int i3, int i4, boolean z2) {
        kotlin.jvm.internal.s.e(str, "<this>");
        kotlin.jvm.internal.s.e(other, "other");
        return !z2 ? str.regionMatches(i2, other, i3, i4) : str.regionMatches(z2, i2, other, i3, i4);
    }

    @NotNull
    public static String o(@NotNull CharSequence charSequence, int i2) {
        kotlin.jvm.internal.s.e(charSequence, "<this>");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i2 + '.').toString());
        }
        if (i2 == 0) {
            return "";
        }
        if (i2 == 1) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            char cCharAt = charSequence.charAt(0);
            char[] cArr = new char[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                cArr[i3] = cCharAt;
            }
            return new String(cArr);
        }
        StringBuilder sb = new StringBuilder(charSequence.length() * i2);
        g0 g0VarD = new s0.f(1, i2).iterator();
        while (g0VarD.hasNext()) {
            g0VarD.nextInt();
            sb.append(charSequence);
        }
        String string = sb.toString();
        kotlin.jvm.internal.s.d(string, "{\n                    va…tring()\n                }");
        return string;
    }

    @NotNull
    public static final String p(@NotNull String str, char c2, char c3, boolean z2) {
        kotlin.jvm.internal.s.e(str, "<this>");
        if (!z2) {
            String strReplace = str.replace(c2, c3);
            kotlin.jvm.internal.s.d(strReplace, "this as java.lang.String…replace(oldChar, newChar)");
            return strReplace;
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (c.e(cCharAt, c2, z2)) {
                cCharAt = c3;
            }
            sb.append(cCharAt);
        }
        String string = sb.toString();
        kotlin.jvm.internal.s.d(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    @NotNull
    public static final String q(@NotNull String str, @NotNull String oldValue, @NotNull String newValue, boolean z2) {
        kotlin.jvm.internal.s.e(str, "<this>");
        kotlin.jvm.internal.s.e(oldValue, "oldValue");
        kotlin.jvm.internal.s.e(newValue, "newValue");
        int i2 = 0;
        int iC = StringsKt__StringsKt.C(str, oldValue, 0, z2);
        if (iC < 0) {
            return str;
        }
        int length = oldValue.length();
        int iA = s0.l.a(length, 1);
        int length2 = (str.length() - length) + newValue.length();
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb = new StringBuilder(length2);
        do {
            sb.append((CharSequence) str, i2, iC);
            sb.append(newValue);
            i2 = iC + length;
            if (iC >= str.length()) {
                break;
            }
            iC = StringsKt__StringsKt.C(str, oldValue, iC + iA, z2);
        } while (iC > 0);
        sb.append((CharSequence) str, i2, str.length());
        String string = sb.toString();
        kotlin.jvm.internal.s.d(string, "stringBuilder.append(this, i, length).toString()");
        return string;
    }

    public static /* synthetic */ String r(String str, char c2, char c3, boolean z2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        return p(str, c2, c3, z2);
    }

    public static /* synthetic */ String s(String str, String str2, String str3, boolean z2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        return q(str, str2, str3, z2);
    }

    public static final boolean t(@NotNull String str, @NotNull String prefix, boolean z2) {
        kotlin.jvm.internal.s.e(str, "<this>");
        kotlin.jvm.internal.s.e(prefix, "prefix");
        return !z2 ? str.startsWith(prefix) : n(str, 0, prefix, 0, prefix.length(), z2);
    }

    public static /* synthetic */ boolean u(String str, String str2, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        return t(str, str2, z2);
    }
}
