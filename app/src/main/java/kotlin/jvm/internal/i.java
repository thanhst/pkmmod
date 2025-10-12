package kotlin.jvm.internal;

import kotlin.Metadata;
import kotlin.collections.c0;
import kotlin.collections.e0;
import kotlin.collections.g0;
import kotlin.collections.h0;
import kotlin.collections.t0;
import org.jetbrains.annotations.NotNull;

/* compiled from: ArrayIterators.kt */
@Metadata(bv = {}, d1 = {"\u0000T\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u0004\u001a\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u0007\u001a\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0001\u001a\u00020\n\u001a\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0001\u001a\u00020\r\u001a\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0001\u001a\u00020\u0010\u001a\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0001\u001a\u00020\u0013\u001a\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0001\u001a\u00020\u0016¨\u0006\u0019"}, d2 = {"", "array", "Lkotlin/collections/q;", "b", "", "Lkotlin/collections/r;", "c", "", "Lkotlin/collections/t0;", "h", "", "Lkotlin/collections/g0;", "f", "", "Lkotlin/collections/h0;", "g", "", "Lkotlin/collections/e0;", "e", "", "Lkotlin/collections/c0;", "d", "", "Lkotlin/collections/p;", "a", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes.dex */
public final class i {
    @NotNull
    public static final kotlin.collections.p a(@NotNull boolean[] array) {
        s.e(array, "array");
        return new a(array);
    }

    @NotNull
    public static final kotlin.collections.q b(@NotNull byte[] array) {
        s.e(array, "array");
        return new b(array);
    }

    @NotNull
    public static final kotlin.collections.r c(@NotNull char[] array) {
        s.e(array, "array");
        return new c(array);
    }

    @NotNull
    public static final c0 d(@NotNull double[] array) {
        s.e(array, "array");
        return new d(array);
    }

    @NotNull
    public static final e0 e(@NotNull float[] array) {
        s.e(array, "array");
        return new e(array);
    }

    @NotNull
    public static final g0 f(@NotNull int[] array) {
        s.e(array, "array");
        return new f(array);
    }

    @NotNull
    public static final h0 g(@NotNull long[] array) {
        s.e(array, "array");
        return new j(array);
    }

    @NotNull
    public static final t0 h(@NotNull short[] array) {
        s.e(array, "array");
        return new k(array);
    }
}
