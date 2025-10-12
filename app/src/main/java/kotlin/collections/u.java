package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Collections.kt */
@Metadata(bv = {}, d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u001a'\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0012\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u0000\u001a-\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001\"\u00028\u0000¢\u0006\u0004\b\b\u0010\t\u001a7\u0010\f\u001a\u0012\u0012\u0004\u0012\u00028\u00000\nj\b\u0012\u0004\u0012\u00028\u0000`\u000b\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001\"\u00028\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0000\u001a\b\u0010\u0010\u001a\u00020\u000fH\u0001\u001a\b\u0010\u0011\u001a\u00020\u000fH\u0001\"\u0019\u0010\u0015\u001a\u00020\u0012*\u0006\u0012\u0002\b\u00030\u00028F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\"!\u0010\u0019\u001a\u00020\u0016\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00058F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"T", "", "", "g", "([Ljava/lang/Object;)Ljava/util/Collection;", "", "h", "elements", "k", "([Ljava/lang/Object;)Ljava/util/List;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "f", "([Ljava/lang/Object;)Ljava/util/ArrayList;", "l", "Lkotlin/t;", "n", "m", "Ls0/f;", "i", "(Ljava/util/Collection;)Ls0/f;", "indices", "", "j", "(Ljava/util/List;)I", "lastIndex", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/collections/CollectionsKt")
/* loaded from: classes.dex */
public class u extends t {
    @NotNull
    public static <T> ArrayList<T> f(@NotNull T... elements) {
        kotlin.jvm.internal.s.e(elements, "elements");
        return elements.length == 0 ? new ArrayList<>() : new ArrayList<>(new h(elements, true));
    }

    @NotNull
    public static final <T> Collection<T> g(@NotNull T[] tArr) {
        kotlin.jvm.internal.s.e(tArr, "<this>");
        return new h(tArr, false);
    }

    @NotNull
    public static <T> List<T> h() {
        return EmptyList.INSTANCE;
    }

    @NotNull
    public static s0.f i(@NotNull Collection<?> collection) {
        kotlin.jvm.internal.s.e(collection, "<this>");
        return new s0.f(0, collection.size() - 1);
    }

    public static <T> int j(@NotNull List<? extends T> list) {
        kotlin.jvm.internal.s.e(list, "<this>");
        return list.size() - 1;
    }

    @NotNull
    public static <T> List<T> k(@NotNull T... elements) {
        kotlin.jvm.internal.s.e(elements, "elements");
        return elements.length > 0 ? m.b(elements) : h();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static <T> List<T> l(@NotNull List<? extends T> list) {
        kotlin.jvm.internal.s.e(list, "<this>");
        int size = list.size();
        return size != 0 ? size != 1 ? list : t.e(list.get(0)) : h();
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static void m() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static void n() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
