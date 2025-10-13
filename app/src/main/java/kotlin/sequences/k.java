package kotlin.sequences;

import com.facebook.share.internal.ShareConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.u;
import kotlin.jvm.internal.s;
import p0.l_p0;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _Sequences.kt */
@Metadata(bv = {}, d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0002\u001a\u001d\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0002\u0010\u0003\u001a7\u0010\u0007\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0010\b\u0001\u0010\u0005*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0006\u001a\u00028\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001\u001a\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001\u001a6\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\r*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000e\u001a\u0016\u0010\u0012\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001\u001a\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0015"}, d2 = {"T", "Lkotlin/sequences/d;", "i", "(Lkotlin/sequences/d;)Ljava/lang/Object;", "", "C", ShareConstants.DESTINATION, "k", "(Lkotlin/sequences/d;Ljava/util/Collection;)Ljava/util/Collection;", "", "l", "", "m", "R", "Lkotlin/Function1;", "transform", "j", "", "h", "", "g", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/sequences/SequencesKt")
/* loaded from: classes.dex */
public class k extends j {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Iterables.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0010(\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002¨\u0006\u0004"}, d2 = {"kotlin/sequences/k$a", "", "", "iterator", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
    public static final class a_q0<T> implements Iterable<T>, q0.a_q0 {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ d f3502e;

        public a_q0(d dVar) {
            this.f3502e = dVar;
        }

        @Override // java.lang.Iterable
        @NotNull
        public Iterator<T> iterator() {
            return this.f3502e.iterator();
        }
    }

    @NotNull
    public static <T> Iterable<T> g(@NotNull d<? extends T> dVar) {
        s.e(dVar, "<this>");
        return new a_q0(dVar);
    }

    public static <T> int h(@NotNull d<? extends T> dVar) {
        s.e(dVar, "<this>");
        Iterator<? extends T> it = dVar.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            it.next();
            i2++;
            if (i2 < 0) {
                u.m();
            }
        }
        return i2;
    }

    public static <T> T i(@NotNull d<? extends T> dVar) {
        s.e(dVar, "<this>");
        Iterator<? extends T> it = dVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Sequence is empty.");
        }
        T next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    @NotNull
    public static <T, R> d<R> j(@NotNull d<? extends T> dVar, @NotNull l_p0<? super T, ? extends R> transform) {
        s.e(dVar, "<this>");
        s.e(transform, "transform");
        return new l(dVar, transform);
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C k(@NotNull d<? extends T> dVar, @NotNull C destination) {
        s.e(dVar, "<this>");
        s.e(destination, "destination");
        Iterator<? extends T> it = dVar.iterator();
        while (it.hasNext()) {
            destination.add(it.next());
        }
        return destination;
    }

    @NotNull
    public static <T> List<T> l(@NotNull d<? extends T> dVar) {
        s.e(dVar, "<this>");
        return u.l(m(dVar));
    }

    @NotNull
    public static final <T> List<T> m(@NotNull d<? extends T> dVar) {
        s.e(dVar, "<this>");
        return (List) k(dVar, new ArrayList());
    }
}
