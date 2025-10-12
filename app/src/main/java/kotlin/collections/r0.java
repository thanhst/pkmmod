package kotlin.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Sets.kt */
@Metadata(bv = {}, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0012\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000\u001a-\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0003\"\u00028\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a-\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0003\"\u00028\u0000¢\u0006\u0004\b\b\u0010\u0006\u001a7\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00028\u00000\tj\b\u0012\u0004\u0012\u00028\u0000`\n\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0003\"\u00028\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0000¨\u0006\u000e"}, d2 = {"T", "", "d", "", "elements", "h", "([Ljava/lang/Object;)Ljava/util/Set;", "", "f", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "e", "([Ljava/lang/Object;)Ljava/util/HashSet;", "g", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/collections/SetsKt")
/* loaded from: classes.dex */
public class r0 extends q0 {
    @NotNull
    public static <T> Set<T> d() {
        return EmptySet.INSTANCE;
    }

    @NotNull
    public static <T> HashSet<T> e(@NotNull T... elements) {
        kotlin.jvm.internal.s.e(elements, "elements");
        return (HashSet) n.r(elements, new HashSet(k0.c(elements.length)));
    }

    @NotNull
    public static <T> Set<T> f(@NotNull T... elements) {
        kotlin.jvm.internal.s.e(elements, "elements");
        return (Set) n.r(elements, new LinkedHashSet(k0.c(elements.length)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> Set<T> g(@NotNull Set<? extends T> set) {
        kotlin.jvm.internal.s.e(set, "<this>");
        int size = set.size();
        return size != 0 ? size != 1 ? set : q0.c(set.iterator().next()) : d();
    }

    @NotNull
    public static <T> Set<T> h(@NotNull T... elements) {
        kotlin.jvm.internal.s.e(elements, "elements");
        return elements.length > 0 ? n.v(elements) : d();
    }
}
