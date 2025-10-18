package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p0.p_p0;

/* compiled from: CoroutineContextImpl.kt */
@SinceKotlin(version = "1.3")
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001e\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lkotlin/coroutines/a;", "Lkotlin/coroutines/CoroutineContext$a;", "Lkotlin/coroutines/CoroutineContext$b;", "key", "Lkotlin/coroutines/CoroutineContext$b;", "getKey", "()Lkotlin/coroutines/CoroutineContext$b;", "<init>", "(Lkotlin/coroutines/CoroutineContext$b;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes.dex */
public abstract class a implements CoroutineContext.a {

    @NotNull
    private final CoroutineContext.b<?> key;

    public a(@NotNull CoroutineContext.b<?> key) {
        s.e(key, "key");
        this.key = key;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r2, @NotNull p_p0<? super R, ? super a, ? extends R> pP0Var) {
        return (R) CoroutineContext.a.C0056a.a(this, r2, pP0Var);
    }

    @Override // kotlin.coroutines.CoroutineContext.a, kotlin.coroutines.CoroutineContext
    @Nullable
    public <E extends CoroutineContext.a> E get(@NotNull CoroutineContext.b<E> bVar) {
        return (E) CoroutineContext.a.C0056a.b(this, bVar);
    }

    @Override // kotlin.coroutines.CoroutineContext.a
    @NotNull
    public CoroutineContext.b<?> getKey() {
        return this.key;
    }

    @Override // kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext minusKey(@NotNull CoroutineContext.b<?> bVar) {
        return CoroutineContext.a.C0056a.c(this, bVar);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext plus(@NotNull CoroutineContext coroutineContext) {
        return CoroutineContext.a.C0056a.d(this, coroutineContext);
    }
}
