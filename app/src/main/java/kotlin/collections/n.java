package kotlin.collections;

import com.facebook.share.internal.ShareConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _Arrays.kt */
@Metadata(bv = {}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0004\u001a/\u0010\u0005\u001a\u00020\u0004\"\t\b\u0000\u0010\u0001¢\u0006\u0002\b\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a,\u0010\b\u001a\u00020\u0007\"\t\b\u0000\u0010\u0001¢\u0006\u0002\b\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00022\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\b\u0010\t\u001a\n\u0010\f\u001a\u00020\u000b*\u00020\n\u001a!\u0010\r\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a+\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\b\b\u0000\u0010\u0001*\u00020\u000f*\f\u0012\b\b\u0001\u0012\u0004\u0018\u00018\u00000\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u001a?\u0010\u0016\u001a\u00028\u0000\"\u0010\b\u0000\u0010\u0014*\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u0013\"\b\b\u0001\u0010\u0001*\u00020\u000f*\f\u0012\b\b\u0001\u0012\u0004\u0018\u00018\u00010\u00022\u0006\u0010\u0015\u001a\u00028\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a9\u0010\u0018\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0001\"\u0010\b\u0001\u0010\u0014*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0013*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00022\u0006\u0010\u0015\u001a\u00028\u0001¢\u0006\u0004\b\u0018\u0010\u0017\u001a/\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0019j\b\u0012\u0004\u0012\u00028\u0000`\u001a\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u001b\u0010\u001c\u001a%\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u001d\u0010\u0012\u001a%\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u001f\u0010\u0012\u001a%\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000 \"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0002¢\u0006\u0004\b!\u0010\"\"\u0015\u0010&\u001a\u00020\u0007*\u00020#8F¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u0006'"}, d2 = {"Lkotlin/internal/OnlyInputTypes;", "T", "", "element", "", "k", "([Ljava/lang/Object;Ljava/lang/Object;)Z", "", "o", "([Ljava/lang/Object;Ljava/lang/Object;)I", "", "", "p", "q", "([Ljava/lang/Object;)Ljava/lang/Object;", "", "", "l", "([Ljava/lang/Object;)Ljava/util/List;", "", "C", ShareConstants.DESTINATION, "m", "([Ljava/lang/Object;Ljava/util/Collection;)Ljava/util/Collection;", "r", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "s", "([Ljava/lang/Object;)Ljava/util/HashSet;", "t", "", "u", "", "v", "([Ljava/lang/Object;)Ljava/util/Set;", "", "n", "([I)I", "lastIndex", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/collections/ArraysKt")
/* loaded from: classes.dex */
public class n extends m {
    public static <T> boolean k(@NotNull T[] tArr, T t2) {
        kotlin.jvm.internal.s.e(tArr, "<this>");
        return o(tArr, t2) >= 0;
    }

    @NotNull
    public static <T> List<T> l(@NotNull T[] tArr) {
        kotlin.jvm.internal.s.e(tArr, "<this>");
        return (List) m(tArr, new ArrayList());
    }

    @NotNull
    public static final <C extends Collection<? super T>, T> C m(@NotNull T[] tArr, @NotNull C destination) {
        kotlin.jvm.internal.s.e(tArr, "<this>");
        kotlin.jvm.internal.s.e(destination, "destination");
        for (T t2 : tArr) {
            if (t2 != null) {
                destination.add(t2);
            }
        }
        return destination;
    }

    public static int n(@NotNull int[] iArr) {
        kotlin.jvm.internal.s.e(iArr, "<this>");
        return iArr.length - 1;
    }

    public static final <T> int o(@NotNull T[] tArr, T t2) {
        kotlin.jvm.internal.s.e(tArr, "<this>");
        int i2 = 0;
        if (t2 == null) {
            int length = tArr.length;
            while (i2 < length) {
                if (tArr[i2] == null) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (i2 < length2) {
            if (kotlin.jvm.internal.s.a(t2, tArr[i2])) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static char p(@NotNull char[] cArr) {
        kotlin.jvm.internal.s.e(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    @Nullable
    public static <T> T q(@NotNull T[] tArr) {
        kotlin.jvm.internal.s.e(tArr, "<this>");
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C r(@NotNull T[] tArr, @NotNull C destination) {
        kotlin.jvm.internal.s.e(tArr, "<this>");
        kotlin.jvm.internal.s.e(destination, "destination");
        for (T t2 : tArr) {
            destination.add(t2);
        }
        return destination;
    }

    @NotNull
    public static <T> HashSet<T> s(@NotNull T[] tArr) {
        kotlin.jvm.internal.s.e(tArr, "<this>");
        return (HashSet) r(tArr, new HashSet(k0.c(tArr.length)));
    }

    @NotNull
    public static <T> List<T> t(@NotNull T[] tArr) {
        kotlin.jvm.internal.s.e(tArr, "<this>");
        int length = tArr.length;
        return length != 0 ? length != 1 ? u(tArr) : t.e(tArr[0]) : u.h();
    }

    @NotNull
    public static final <T> List<T> u(@NotNull T[] tArr) {
        kotlin.jvm.internal.s.e(tArr, "<this>");
        return new ArrayList(u.g(tArr));
    }

    @NotNull
    public static final <T> Set<T> v(@NotNull T[] tArr) {
        kotlin.jvm.internal.s.e(tArr, "<this>");
        int length = tArr.length;
        return length != 0 ? length != 1 ? (Set) r(tArr, new LinkedHashSet(k0.c(tArr.length))) : q0.c(tArr[0]) : r0.d();
    }
}
