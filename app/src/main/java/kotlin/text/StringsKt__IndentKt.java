package kotlin.text;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Indent.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\n\u0010\u0001\u001a\u00020\u0000*\u00020\u0000\u001a\u0014\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0000\u001a\u0013\u0010\u0005\u001a\u00020\u0004*\u00020\u0000H\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a#\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\b2\u0006\u0010\u0007\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"", "e", "newIndent", "d", "", "c", "(Ljava/lang/String;)I", "indent", "Lkotlin/Function1;", "b", "(Ljava/lang/String;)Lp0/l;", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/text/StringsKt")
/* loaded from: classes.dex */
public class StringsKt__IndentKt extends l {
    private static final p0.l<String, String> b(final String str) {
        return str.length() == 0 ? new p0.l<String, String>() { // from class: kotlin.text.StringsKt__IndentKt$getIndentFunction$1
            @Override // p0.l
            @NotNull
            public final String invoke(@NotNull String line) {
                kotlin.jvm.internal.s.e(line, "line");
                return line;
            }
        } : new p0.l<String, String>() { // from class: kotlin.text.StringsKt__IndentKt$getIndentFunction$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // p0.l
            @NotNull
            public final String invoke(@NotNull String line) {
                kotlin.jvm.internal.s.e(line, "line");
                return str + line;
            }
        };
    }

    private static final int c(String str) {
        int length = str.length();
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = -1;
                break;
            }
            if (!b.c(str.charAt(i2))) {
                break;
            }
            i2++;
        }
        return i2 == -1 ? str.length() : i2;
    }

    @NotNull
    public static final String d(@NotNull String str, @NotNull String newIndent) {
        String strInvoke;
        kotlin.jvm.internal.s.e(str, "<this>");
        kotlin.jvm.internal.s.e(newIndent, "newIndent");
        List<String> listP = StringsKt__StringsKt.P(str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listP) {
            if (!s.m((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(v.o(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf(c((String) it.next())));
        }
        Integer num = (Integer) CollectionsKt___CollectionsKt.L(arrayList2);
        int i2 = 0;
        int iIntValue = num != null ? num.intValue() : 0;
        int length = str.length() + (newIndent.length() * listP.size());
        p0.l<String, String> lVarB = b(newIndent);
        int iJ = kotlin.collections.u.j(listP);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : listP) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                kotlin.collections.u.n();
            }
            String str2 = (String) obj2;
            if ((i2 == 0 || i2 == iJ) && s.m(str2)) {
                str2 = null;
            } else {
                String strR0 = u.r0(str2, iIntValue);
                if (strR0 != null && (strInvoke = lVarB.invoke(strR0)) != null) {
                    str2 = strInvoke;
                }
            }
            if (str2 != null) {
                arrayList3.add(str2);
            }
            i2 = i3;
        }
        String string = ((StringBuilder) CollectionsKt___CollectionsKt.F(arrayList3, new StringBuilder(length), (124 & 2) != 0 ? ", " : "\n", (124 & 4) != 0 ? "" : null, (124 & 8) == 0 ? null : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : null)).toString();
        kotlin.jvm.internal.s.d(string, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return string;
    }

    @NotNull
    public static String e(@NotNull String str) {
        kotlin.jvm.internal.s.e(str, "<this>");
        return d(str, "");
    }
}
