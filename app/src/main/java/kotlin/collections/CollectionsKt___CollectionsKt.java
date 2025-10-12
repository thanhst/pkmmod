package kotlin.collections;

import com.facebook.share.internal.ShareConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.SinceKotlin;
import kotlin.random.Random;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _Collections.kt */
@Metadata(bv = {}, d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\u000f\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a-\u0010\u0005\u001a\u00020\u0004\"\t\b\u0000\u0010\u0001¢\u0006\u0002\b\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a%\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n\u001a9\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00000\u000b¢\u0006\u0004\b\r\u0010\u000e\u001a\u001d\u0010\u0010\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u000f¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001f\u0010\u0012\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u000f¢\u0006\u0004\b\u0012\u0010\u0011\u001a*\u0010\u0013\u001a\u00020\u0007\"\t\b\u0000\u0010\u0001¢\u0006\u0002\b\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001d\u0010\u0015\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001d\u0010\u0017\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u000f¢\u0006\u0004\b\u0017\u0010\u0011\u001a'\u0010\u001b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00182\u0006\u0010\u001a\u001a\u00020\u0019H\u0007¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u001d\u0010\u001d\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u001d\u0010\u0016\u001a\u001d\u0010\u001e\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u000f¢\u0006\u0004\b\u001e\u0010\u0011\u001a$\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u001f\u001a\u00020\u0007\u001a\"\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\"\b\b\u0000\u0010\u0001*\u00020!*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0002\u001a=\u0010%\u001a\u00028\u0000\"\u0010\b\u0000\u0010\u0010*\n\u0012\u0006\b\u0000\u0012\u00028\u00010#\"\b\b\u0001\u0010\u0001*\u00020!*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u00022\u0006\u0010$\u001a\u00028\u0000¢\u0006\u0004\b%\u0010&\u001a$\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u000f2\u0006\u0010(\u001a\u00020'\u001a8\u0010\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u001a\u0010,\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000*j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`+\u001a7\u0010-\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0001\"\u0010\b\u0001\u0010\u0010*\n\u0012\u0006\b\u0000\u0012\u00028\u00000#*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010$\u001a\u00028\u0001¢\u0006\u0004\b-\u0010&\u001a\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0002\u001a\u001c\u00100\u001a\b\u0012\u0004\u0012\u00028\u00000/\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0002\u001a\u001c\u00101\u001a\b\u0012\u0004\u0012\u00028\u00000/\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0018\u001a\u001c\u00103\u001a\b\u0012\u0004\u0012\u00028\u000002\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0002\u001a\u001c\u00105\u001a\b\u0012\u0004\u0012\u00028\u000004\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0002\u001a+\u00107\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u000006*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0007¢\u0006\u0004\b7\u00108\u001a.\u00109\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00182\u0006\u0010\u0003\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b9\u0010:\u001a-\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\u0002\u001a-\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00182\f\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\u0002\u001a?\u0010@\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010?0\u000f\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u001e*\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010>\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002H\u0086\u0004\u001a}\u0010K\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0001\"\f\b\u0001\u0010\"*\u00060Aj\u0002`B*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010C\u001a\u00028\u00012\b\b\u0002\u0010E\u001a\u00020D2\b\b\u0002\u0010F\u001a\u00020D2\b\b\u0002\u0010G\u001a\u00020D2\b\b\u0002\u0010H\u001a\u00020\u00072\b\b\u0002\u0010I\u001a\u00020D2\u0016\b\u0002\u0010J\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020D\u0018\u00010\u000b¢\u0006\u0004\bK\u0010L\u001a`\u0010N\u001a\u00020M\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\b\b\u0002\u0010E\u001a\u00020D2\b\b\u0002\u0010F\u001a\u00020D2\b\b\u0002\u0010G\u001a\u00020D2\b\b\u0002\u0010H\u001a\u00020\u00072\b\b\u0002\u0010I\u001a\u00020D2\u0016\b\u0002\u0010J\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020D\u0018\u00010\u000b\u001a\u001c\u0010P\u001a\b\u0012\u0004\u0012\u00028\u00000O\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0002¨\u0006Q"}, d2 = {"Lkotlin/internal/OnlyInputTypes;", "T", "", "element", "", "w", "(Ljava/lang/Iterable;Ljava/lang/Object;)Z", "", "index", "y", "(Ljava/lang/Iterable;I)Ljava/lang/Object;", "Lkotlin/Function1;", "defaultValue", "z", "(Ljava/lang/Iterable;ILp0/l;)Ljava/lang/Object;", "", "C", "(Ljava/util/List;)Ljava/lang/Object;", "D", "E", "(Ljava/lang/Iterable;Ljava/lang/Object;)I", "J", "(Ljava/lang/Iterable;)Ljava/lang/Object;", "K", "", "Lkotlin/random/Random;", "random", "P", "(Ljava/util/Collection;Lkotlin/random/Random;)Ljava/lang/Object;", "Q", "R", "n", "x", "", "A", "", ShareConstants.DESTINATION, "B", "(Ljava/lang/Iterable;Ljava/util/Collection;)Ljava/util/Collection;", "Ls0/f;", "indices", "S", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "U", "V", "", "W", "X", "", "Z", "", "Y", "", "L", "(Ljava/lang/Iterable;)Ljava/lang/Comparable;", "O", "(Ljava/util/Collection;Ljava/lang/Object;)Ljava/util/List;", "elements", "M", "N", "other", "Lkotlin/Pair;", "a0", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "buffer", "", "separator", "prefix", "postfix", "limit", "truncated", "transform", "F", "(Ljava/lang/Iterable;Ljava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lp0/l;)Ljava/lang/Appendable;", "", "H", "Lkotlin/sequences/d;", "v", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/collections/CollectionsKt")
/* loaded from: classes.dex */
public class CollectionsKt___CollectionsKt extends b0 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002¨\u0006\u0004"}, d2 = {"kotlin/collections/CollectionsKt___CollectionsKt$a", "Lkotlin/sequences/d;", "", "iterator", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
    public static final class a<T> implements kotlin.sequences.d<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterable f3354a;

        public a(Iterable iterable) {
            this.f3354a = iterable;
        }

        @Override // kotlin.sequences.d
        @NotNull
        public Iterator<T> iterator() {
            return this.f3354a.iterator();
        }
    }

    @NotNull
    public static <T> List<T> A(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.s.e(iterable, "<this>");
        return (List) B(iterable, new ArrayList());
    }

    @NotNull
    public static final <C extends Collection<? super T>, T> C B(@NotNull Iterable<? extends T> iterable, @NotNull C destination) {
        kotlin.jvm.internal.s.e(iterable, "<this>");
        kotlin.jvm.internal.s.e(destination, "destination");
        for (T t2 : iterable) {
            if (t2 != null) {
                destination.add(t2);
            }
        }
        return destination;
    }

    public static <T> T C(@NotNull List<? extends T> list) {
        kotlin.jvm.internal.s.e(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    @Nullable
    public static <T> T D(@NotNull List<? extends T> list) {
        kotlin.jvm.internal.s.e(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static final <T> int E(@NotNull Iterable<? extends T> iterable, T t2) {
        kotlin.jvm.internal.s.e(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(t2);
        }
        int i2 = 0;
        for (T t3 : iterable) {
            if (i2 < 0) {
                u.n();
            }
            if (kotlin.jvm.internal.s.a(t2, t3)) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    @NotNull
    public static final <T, A extends Appendable> A F(@NotNull Iterable<? extends T> iterable, @NotNull A buffer, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i2, @NotNull CharSequence truncated, @Nullable p0.l<? super T, ? extends CharSequence> lVar) throws IOException {
        kotlin.jvm.internal.s.e(iterable, "<this>");
        kotlin.jvm.internal.s.e(buffer, "buffer");
        kotlin.jvm.internal.s.e(separator, "separator");
        kotlin.jvm.internal.s.e(prefix, "prefix");
        kotlin.jvm.internal.s.e(postfix, "postfix");
        kotlin.jvm.internal.s.e(truncated, "truncated");
        buffer.append(prefix);
        int i3 = 0;
        for (T t2 : iterable) {
            i3++;
            if (i3 > 1) {
                buffer.append(separator);
            }
            if (i2 >= 0 && i3 > i2) {
                break;
            }
            kotlin.text.l.a(buffer, t2, lVar);
        }
        if (i2 >= 0 && i3 > i2) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    @NotNull
    public static final <T> String H(@NotNull Iterable<? extends T> iterable, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i2, @NotNull CharSequence truncated, @Nullable p0.l<? super T, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.s.e(iterable, "<this>");
        kotlin.jvm.internal.s.e(separator, "separator");
        kotlin.jvm.internal.s.e(prefix, "prefix");
        kotlin.jvm.internal.s.e(postfix, "postfix");
        kotlin.jvm.internal.s.e(truncated, "truncated");
        String string = ((StringBuilder) F(iterable, new StringBuilder(), separator, prefix, postfix, i2, truncated, lVar)).toString();
        kotlin.jvm.internal.s.d(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    public static /* synthetic */ String I(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, p0.l lVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i3 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i3 & 4) == 0 ? charSequence3 : "";
        int i4 = (i3 & 8) != 0 ? -1 : i2;
        if ((i3 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i3 & 32) != 0) {
            lVar = null;
        }
        return H(iterable, charSequence, charSequence5, charSequence6, i4, charSequence7, lVar);
    }

    public static final <T> T J(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.s.e(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) K((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        T next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    public static <T> T K(@NotNull List<? extends T> list) {
        kotlin.jvm.internal.s.e(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(u.j(list));
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static <T extends Comparable<? super T>> T L(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.s.e(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    @NotNull
    public static <T> List<T> M(@NotNull Iterable<? extends T> iterable, @NotNull Iterable<? extends T> elements) {
        kotlin.jvm.internal.s.e(iterable, "<this>");
        kotlin.jvm.internal.s.e(elements, "elements");
        if (iterable instanceof Collection) {
            return N((Collection) iterable, elements);
        }
        ArrayList arrayList = new ArrayList();
        z.r(arrayList, iterable);
        z.r(arrayList, elements);
        return arrayList;
    }

    @NotNull
    public static <T> List<T> N(@NotNull Collection<? extends T> collection, @NotNull Iterable<? extends T> elements) {
        kotlin.jvm.internal.s.e(collection, "<this>");
        kotlin.jvm.internal.s.e(elements, "elements");
        if (!(elements instanceof Collection)) {
            ArrayList arrayList = new ArrayList(collection);
            z.r(arrayList, elements);
            return arrayList;
        }
        Collection collection2 = (Collection) elements;
        ArrayList arrayList2 = new ArrayList(collection.size() + collection2.size());
        arrayList2.addAll(collection);
        arrayList2.addAll(collection2);
        return arrayList2;
    }

    @NotNull
    public static <T> List<T> O(@NotNull Collection<? extends T> collection, T t2) {
        kotlin.jvm.internal.s.e(collection, "<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(t2);
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    public static <T> T P(@NotNull Collection<? extends T> collection, @NotNull Random random) {
        kotlin.jvm.internal.s.e(collection, "<this>");
        kotlin.jvm.internal.s.e(random, "random");
        if (collection.isEmpty()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        return (T) y(collection, random.nextInt(collection.size()));
    }

    public static <T> T Q(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.s.e(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) R((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        T next = it.next();
        if (it.hasNext()) {
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        return next;
    }

    public static final <T> T R(@NotNull List<? extends T> list) {
        kotlin.jvm.internal.s.e(list, "<this>");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        }
        if (size == 1) {
            return list.get(0);
        }
        throw new IllegalArgumentException("List has more than one element.");
    }

    @NotNull
    public static <T> List<T> S(@NotNull List<? extends T> list, @NotNull s0.f indices) {
        kotlin.jvm.internal.s.e(list, "<this>");
        kotlin.jvm.internal.s.e(indices, "indices");
        return indices.isEmpty() ? u.h() : V(list.subList(indices.h().intValue(), indices.g().intValue() + 1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static <T> List<T> T(@NotNull Iterable<? extends T> iterable, @NotNull Comparator<? super T> comparator) {
        kotlin.jvm.internal.s.e(iterable, "<this>");
        kotlin.jvm.internal.s.e(comparator, "comparator");
        if (!(iterable instanceof Collection)) {
            List<T> listW = W(iterable);
            y.q(listW, comparator);
            return listW;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return V(iterable);
        }
        Object[] array = collection.toArray(new Object[0]);
        kotlin.jvm.internal.s.c(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        kotlin.jvm.internal.s.c(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.CollectionsKt___CollectionsKt.sortedWith>");
        m.j(array, comparator);
        return m.b(array);
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C U(@NotNull Iterable<? extends T> iterable, @NotNull C destination) {
        kotlin.jvm.internal.s.e(iterable, "<this>");
        kotlin.jvm.internal.s.e(destination, "destination");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            destination.add(it.next());
        }
        return destination;
    }

    @NotNull
    public static <T> List<T> V(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.s.e(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return u.l(W(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return u.h();
        }
        if (size != 1) {
            return X(collection);
        }
        return t.e(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    @NotNull
    public static final <T> List<T> W(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.s.e(iterable, "<this>");
        return iterable instanceof Collection ? X((Collection) iterable) : (List) U(iterable, new ArrayList());
    }

    @NotNull
    public static <T> List<T> X(@NotNull Collection<? extends T> collection) {
        kotlin.jvm.internal.s.e(collection, "<this>");
        return new ArrayList(collection);
    }

    @NotNull
    public static <T> Set<T> Y(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.s.e(iterable, "<this>");
        return iterable instanceof Collection ? new LinkedHashSet((Collection) iterable) : (Set) U(iterable, new LinkedHashSet());
    }

    @NotNull
    public static <T> Set<T> Z(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.s.e(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return r0.g((Set) U(iterable, new LinkedHashSet()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return r0.d();
        }
        if (size != 1) {
            return (Set) U(iterable, new LinkedHashSet(k0.c(collection.size())));
        }
        return q0.c(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    @NotNull
    public static <T, R> List<Pair<T, R>> a0(@NotNull Iterable<? extends T> iterable, @NotNull Iterable<? extends R> other) {
        kotlin.jvm.internal.s.e(iterable, "<this>");
        kotlin.jvm.internal.s.e(other, "other");
        Iterator<? extends T> it = iterable.iterator();
        Iterator<? extends R> it2 = other.iterator();
        ArrayList arrayList = new ArrayList(Math.min(v.o(iterable, 10), v.o(other, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(kotlin.j.a(it.next(), it2.next()));
        }
        return arrayList;
    }

    @NotNull
    public static <T> kotlin.sequences.d<T> v(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.s.e(iterable, "<this>");
        return new a(iterable);
    }

    public static <T> boolean w(@NotNull Iterable<? extends T> iterable, T t2) {
        kotlin.jvm.internal.s.e(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).contains(t2) : E(iterable, t2) >= 0;
    }

    @NotNull
    public static <T> List<T> x(@NotNull Iterable<? extends T> iterable, int i2) {
        ArrayList arrayList;
        kotlin.jvm.internal.s.e(iterable, "<this>");
        int i3 = 0;
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
        }
        if (i2 == 0) {
            return V(iterable);
        }
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size() - i2;
            if (size <= 0) {
                return u.h();
            }
            if (size == 1) {
                return t.e(J(iterable));
            }
            arrayList = new ArrayList(size);
            if (iterable instanceof List) {
                if (iterable instanceof RandomAccess) {
                    int size2 = collection.size();
                    while (i2 < size2) {
                        arrayList.add(((List) iterable).get(i2));
                        i2++;
                    }
                } else {
                    ListIterator listIterator = ((List) iterable).listIterator(i2);
                    while (listIterator.hasNext()) {
                        arrayList.add(listIterator.next());
                    }
                }
                return arrayList;
            }
        } else {
            arrayList = new ArrayList();
        }
        for (T t2 : iterable) {
            if (i3 >= i2) {
                arrayList.add(t2);
            } else {
                i3++;
            }
        }
        return u.l(arrayList);
    }

    public static final <T> T y(@NotNull Iterable<? extends T> iterable, final int i2) {
        kotlin.jvm.internal.s.e(iterable, "<this>");
        return iterable instanceof List ? (T) ((List) iterable).get(i2) : (T) z(iterable, i2, new p0.l<Integer, T>() { // from class: kotlin.collections.CollectionsKt___CollectionsKt$elementAt$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final T invoke(int i3) {
                throw new IndexOutOfBoundsException("Collection doesn't contain element at index " + i2 + '.');
            }

            @Override // p0.l
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }
        });
    }

    public static final <T> T z(@NotNull Iterable<? extends T> iterable, int i2, @NotNull p0.l<? super Integer, ? extends T> defaultValue) {
        kotlin.jvm.internal.s.e(iterable, "<this>");
        kotlin.jvm.internal.s.e(defaultValue, "defaultValue");
        if (iterable instanceof List) {
            List list = (List) iterable;
            return (i2 < 0 || i2 > u.j(list)) ? defaultValue.invoke(Integer.valueOf(i2)) : (T) list.get(i2);
        }
        if (i2 < 0) {
            return defaultValue.invoke(Integer.valueOf(i2));
        }
        int i3 = 0;
        for (T t2 : iterable) {
            int i4 = i3 + 1;
            if (i2 == i3) {
                return t2;
            }
            i3 = i4;
        }
        return defaultValue.invoke(Integer.valueOf(i2));
    }
}
