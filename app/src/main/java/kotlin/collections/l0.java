package kotlin.collections;

import com.facebook.share.internal.ShareConstants;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Maps.kt */
@Metadata(bv = {}, d1 = {"\u00006\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\f\u001a\u001e\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\u001aQ\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012*\u0010\u0006\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u0004\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0004\b\u0007\u0010\b\u001aa\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\tj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\n\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012*\u0010\u0006\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u0004\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0004\b\u000b\u0010\f\u001aI\u0010\u000f\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\r2\u001a\u0010\u0006\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u0004¢\u0006\u0004\b\u000f\u0010\u0010\u001a@\u0010\u0012\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\r2\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u0011\u001a4\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u0011\u001aQ\u0010\u0016\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0018\b\u0002\u0010\u0014*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\r*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u00112\u0006\u0010\u0015\u001a\u00028\u0002¢\u0006\u0004\b\u0016\u0010\u0017\u001aS\u0010\u0018\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0018\b\u0002\u0010\u0014*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\r*\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u00042\u0006\u0010\u0015\u001a\u00028\u0002¢\u0006\u0004\b\u0018\u0010\u0019\u001a2\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0007\u001a2\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0007\u001a0\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0000¨\u0006\u001d"}, d2 = {"K", "V", "", "f", "", "Lkotlin/Pair;", "pairs", "h", "([Lkotlin/Pair;)Ljava/util/Map;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "g", "([Lkotlin/Pair;)Ljava/util/HashMap;", "", "Lkotlin/t;", "k", "(Ljava/util/Map;[Lkotlin/Pair;)V", "", "j", "l", "M", ShareConstants.DESTINATION, "m", "(Ljava/lang/Iterable;Ljava/util/Map;)Ljava/util/Map;", "o", "([Lkotlin/Pair;Ljava/util/Map;)Ljava/util/Map;", "n", "p", "i", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/collections/MapsKt")
/* loaded from: classes.dex */
public class l0 extends k0 {
    @NotNull
    public static <K, V> Map<K, V> f() {
        EmptyMap emptyMap = EmptyMap.INSTANCE;
        kotlin.jvm.internal.s.c(emptyMap, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return emptyMap;
    }

    @NotNull
    public static <K, V> HashMap<K, V> g(@NotNull Pair<? extends K, ? extends V>... pairs) {
        kotlin.jvm.internal.s.e(pairs, "pairs");
        HashMap<K, V> map = new HashMap<>(k0.c(pairs.length));
        k(map, pairs);
        return map;
    }

    @NotNull
    public static <K, V> Map<K, V> h(@NotNull Pair<? extends K, ? extends V>... pairs) {
        kotlin.jvm.internal.s.e(pairs, "pairs");
        return pairs.length > 0 ? o(pairs, new LinkedHashMap(k0.c(pairs.length))) : f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V> Map<K, V> i(@NotNull Map<K, ? extends V> map) {
        kotlin.jvm.internal.s.e(map, "<this>");
        int size = map.size();
        return size != 0 ? size != 1 ? map : k0.e(map) : f();
    }

    public static final <K, V> void j(@NotNull Map<? super K, ? super V> map, @NotNull Iterable<? extends Pair<? extends K, ? extends V>> pairs) {
        kotlin.jvm.internal.s.e(map, "<this>");
        kotlin.jvm.internal.s.e(pairs, "pairs");
        for (Pair<? extends K, ? extends V> pair : pairs) {
            map.put(pair.component1(), pair.component2());
        }
    }

    public static final <K, V> void k(@NotNull Map<? super K, ? super V> map, @NotNull Pair<? extends K, ? extends V>[] pairs) {
        kotlin.jvm.internal.s.e(map, "<this>");
        kotlin.jvm.internal.s.e(pairs, "pairs");
        for (Pair<? extends K, ? extends V> pair : pairs) {
            map.put(pair.component1(), pair.component2());
        }
    }

    @NotNull
    public static <K, V> Map<K, V> l(@NotNull Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        kotlin.jvm.internal.s.e(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return i(m(iterable, new LinkedHashMap()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return f();
        }
        if (size != 1) {
            return m(iterable, new LinkedHashMap(k0.c(collection.size())));
        }
        return k0.d(iterable instanceof List ? (Pair<? extends K, ? extends V>) ((List) iterable).get(0) : iterable.iterator().next());
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M m(@NotNull Iterable<? extends Pair<? extends K, ? extends V>> iterable, @NotNull M destination) {
        kotlin.jvm.internal.s.e(iterable, "<this>");
        kotlin.jvm.internal.s.e(destination, "destination");
        j(destination, iterable);
        return destination;
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static <K, V> Map<K, V> n(@NotNull Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.s.e(map, "<this>");
        int size = map.size();
        return size != 0 ? size != 1 ? p(map) : k0.e(map) : f();
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M o(@NotNull Pair<? extends K, ? extends V>[] pairArr, @NotNull M destination) {
        kotlin.jvm.internal.s.e(pairArr, "<this>");
        kotlin.jvm.internal.s.e(destination, "destination");
        k(destination, pairArr);
        return destination;
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static <K, V> Map<K, V> p(@NotNull Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.s.e(map, "<this>");
        return new LinkedHashMap(map);
    }
}
