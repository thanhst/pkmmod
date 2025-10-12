package kotlin;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyJVM.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0005"}, d2 = {"T", "Lkotlin/Function0;", "initializer", "Lkotlin/d;", "a", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/LazyKt")
/* loaded from: classes.dex */
public class f {
    @NotNull
    public static <T> d<T> a(@NotNull p0.a<? extends T> initializer) {
        kotlin.jvm.internal.s.e(initializer, "initializer");
        kotlin.jvm.internal.o oVar = null;
        return new SynchronizedLazyImpl(initializer, oVar, 2, oVar);
    }
}
