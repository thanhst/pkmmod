package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.internal.s;
import p0.a_p0;
import p0.l_p0;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Sequences.kt */
@Metadata(bv = {}, d1 = {"\u0000$\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001\u001a\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002\u001a?\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\b\b\u0000\u0010\u0000*\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00018\u00002\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0007H\u0007¢\u0006\u0004\b\t\u0010\n\u001a<\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\b\b\u0000\u0010\u0000*\u00020\u00052\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000b2\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0007¨\u0006\u000e"}, d2 = {"T", "", "Lkotlin/sequences/d;", "c", "d", "", "seed", "Lkotlin/Function1;", "nextFunction", "e", "(Ljava/lang/Object;Lp0/l;)Lkotlin/sequences/d;", "Lkotlin/Function0;", "seedFunction", "f", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/sequences/SequencesKt")
/* loaded from: classes.dex */
public class SequencesKt__SequencesKt extends i {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002¨\u0006\u0004"}, d2 = {"kotlin/sequences/SequencesKt__SequencesKt$a", "Lkotlin/sequences/d;", "", "iterator", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
    public static final class a<T> implements d<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterator f3489a;

        public a(Iterator it) {
            this.f3489a = it;
        }

        @Override // kotlin.sequences.d
        @NotNull
        public Iterator<T> iterator() {
            return this.f3489a;
        }
    }

    @NotNull
    public static <T> d<T> c(@NotNull Iterator<? extends T> it) {
        s.e(it, "<this>");
        return d(new a(it));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> d<T> d(@NotNull d<? extends T> dVar) {
        s.e(dVar, "<this>");
        return dVar instanceof kotlin.sequences.a ? dVar : new kotlin.sequences.a(dVar);
    }

    @LowPriorityInOverloadResolution
    @NotNull
    public static <T> d<T> e(@Nullable final T t2, @NotNull l_p0<? super T, ? extends T> nextFunction) {
        s.e(nextFunction, "nextFunction");
        return t2 == null ? b.f3491a : new c(new a_p0<T>() { // from class: kotlin.sequences.SequencesKt__SequencesKt$generateSequence$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // p0.a
            @Nullable
            public final T invoke() {
                return t2;
            }
        }, nextFunction);
    }

    @NotNull
    public static <T> d<T> f(@NotNull a_p0<? extends T> seedFunction, @NotNull l_p0<? super T, ? extends T> nextFunction) {
        s.e(seedFunction, "seedFunction");
        s.e(nextFunction, "nextFunction");
        return new c(seedFunction, nextFunction);
    }
}
