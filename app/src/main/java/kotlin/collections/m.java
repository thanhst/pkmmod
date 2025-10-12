package kotlin.collections;

import com.facebook.share.internal.ShareConstants;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _ArraysJvm.kt */
@Metadata(bv = {}, d1 = {"\u00002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a%\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001aS\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a5\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u001a9\u0010\u0012\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0010\u001a\u00028\u00002\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u0013\u001a&\u0010\u0015\u001a\u00020\u0011*\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u0006\u001a\u001f\u0010\u0016\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0016\u0010\u0017\u001a;\u0010\u001b\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u001a\u0010\u001a\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u0018j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u0019¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"T", "", "", "b", "([Ljava/lang/Object;)Ljava/util/List;", ShareConstants.DESTINATION, "", "destinationOffset", "startIndex", "endIndex", "c", "([Ljava/lang/Object;[Ljava/lang/Object;III)[Ljava/lang/Object;", "fromIndex", "toIndex", "e", "([Ljava/lang/Object;II)[Ljava/lang/Object;", "element", "Lkotlin/t;", "g", "([Ljava/lang/Object;Ljava/lang/Object;II)V", "", "f", "i", "([Ljava/lang/Object;)V", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "j", "([Ljava/lang/Object;Ljava/util/Comparator;)V", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/collections/ArraysKt")
/* loaded from: classes.dex */
public class m extends l {
    @NotNull
    public static <T> List<T> b(@NotNull T[] tArr) {
        kotlin.jvm.internal.s.e(tArr, "<this>");
        List<T> listA = o.a(tArr);
        kotlin.jvm.internal.s.d(listA, "asList(this)");
        return listA;
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static <T> T[] c(@NotNull T[] tArr, @NotNull T[] destination, int i2, int i3, int i4) {
        kotlin.jvm.internal.s.e(tArr, "<this>");
        kotlin.jvm.internal.s.e(destination, "destination");
        System.arraycopy(tArr, i3, destination, i2, i4 - i3);
        return destination;
    }

    public static /* synthetic */ Object[] d(Object[] objArr, Object[] objArr2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = objArr.length;
        }
        return c(objArr, objArr2, i2, i3, i4);
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "copyOfRange")
    @NotNull
    @PublishedApi
    public static <T> T[] e(@NotNull T[] tArr, int i2, int i3) {
        kotlin.jvm.internal.s.e(tArr, "<this>");
        k.a(i3, tArr.length);
        T[] tArr2 = (T[]) Arrays.copyOfRange(tArr, i2, i3);
        kotlin.jvm.internal.s.d(tArr2, "copyOfRange(this, fromIndex, toIndex)");
        return tArr2;
    }

    public static void f(@NotNull int[] iArr, int i2, int i3, int i4) {
        kotlin.jvm.internal.s.e(iArr, "<this>");
        Arrays.fill(iArr, i3, i4, i2);
    }

    public static <T> void g(@NotNull T[] tArr, T t2, int i2, int i3) {
        kotlin.jvm.internal.s.e(tArr, "<this>");
        Arrays.fill(tArr, i2, i3, t2);
    }

    public static /* synthetic */ void h(Object[] objArr, Object obj, int i2, int i3, int i4, Object obj2) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = objArr.length;
        }
        g(objArr, obj, i2, i3);
    }

    public static <T> void i(@NotNull T[] tArr) {
        kotlin.jvm.internal.s.e(tArr, "<this>");
        if (tArr.length > 1) {
            Arrays.sort(tArr);
        }
    }

    public static final <T> void j(@NotNull T[] tArr, @NotNull Comparator<? super T> comparator) {
        kotlin.jvm.internal.s.e(tArr, "<this>");
        kotlin.jvm.internal.s.e(comparator, "comparator");
        if (tArr.length > 1) {
            Arrays.sort(tArr, comparator);
        }
    }
}
