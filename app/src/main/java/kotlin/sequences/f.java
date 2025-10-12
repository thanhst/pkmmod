package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.coroutines.RestrictsSuspension;
import kotlin.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SequenceBuilder.kt */
@SinceKotlin(version = "1.3")
@RestrictsSuspension
@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002B\t\b\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H¦@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H¦@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ!\u0010\r\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0086@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lkotlin/sequences/f;", "T", "", "value", "Lkotlin/t;", "a", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "iterator", "b", "(Ljava/util/Iterator;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/sequences/d;", "sequence", "d", "(Lkotlin/sequences/d;Lkotlin/coroutines/c;)Ljava/lang/Object;", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes.dex */
public abstract class f<T> {
    @Nullable
    public abstract Object a(T t2, @NotNull kotlin.coroutines.c<? super t> cVar);

    @Nullable
    public abstract Object b(@NotNull Iterator<? extends T> it, @NotNull kotlin.coroutines.c<? super t> cVar);

    @Nullable
    public final Object d(@NotNull d<? extends T> dVar, @NotNull kotlin.coroutines.c<? super t> cVar) {
        Object objB = b(dVar.iterator(), cVar);
        return objB == kotlin.coroutines.intrinsics.b.d() ? objB : t.f3507a;
    }
}
