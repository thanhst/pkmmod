package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: DebugProbes.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\"\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0001\u001a\u0014\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0001\u001a\u0014\u0010\u0007\u001a\u00020\u00052\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0001¨\u0006\b"}, d2 = {"T", "Lkotlin/coroutines/c;", "completion", "a", "frame", "Lkotlin/t;", "b", "c", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes.dex */
public final class e {
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <T> kotlin.coroutines.c<T> a(@NotNull kotlin.coroutines.c<? super T> completion) {
        s.e(completion, "completion");
        return completion;
    }

    @SinceKotlin(version = "1.3")
    public static final void b(@NotNull kotlin.coroutines.c<?> frame) {
        s.e(frame, "frame");
    }

    @SinceKotlin(version = "1.3")
    public static final void c(@NotNull kotlin.coroutines.c<?> frame) {
        s.e(frame, "frame");
    }
}
