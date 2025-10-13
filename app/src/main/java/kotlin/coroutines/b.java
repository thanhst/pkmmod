package kotlin.coroutines;

import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.coroutines.CoroutineContext.a;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p0.l_p0;

/* compiled from: CoroutineContextImpl.kt */
@SinceKotlin(version = "1.3")
@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b'\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00028\u00002\b\u0012\u0004\u0012\u00028\u00010\u0004B:\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012#\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0005\u0012\u0006\u0012\u0004\u0018\u00018\u00010\f¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0006\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\n\u001a\u00020\t2\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0000¢\u0006\u0004\b\n\u0010\u000bR1\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0005\u0012\u0006\u0012\u0004\u0018\u00018\u00010\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lkotlin/coroutines/b;", "Lkotlin/coroutines/CoroutineContext$a;", "B", "E", "Lkotlin/coroutines/CoroutineContext$b;", "element", "b", "(Lkotlin/coroutines/CoroutineContext$a;)Lkotlin/coroutines/CoroutineContext$a;", "key", "", "a", "(Lkotlin/coroutines/CoroutineContext$b;)Z", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "e", "Lp0/l;", "safeCast", "f", "Lkotlin/coroutines/CoroutineContext$b;", "topmostKey", "baseKey", "<init>", "(Lkotlin/coroutines/CoroutineContext$b;Lp0/l;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
@ExperimentalStdlibApi
/* loaded from: classes.dex */
public abstract class b<B extends CoroutineContext.a, E extends B> implements CoroutineContext.b<E> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final l_p0<a, E> safeCast;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineContext.b<?> topmostKey;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.coroutines.CoroutineContext$b<?>] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, p0.l<? super kotlin.coroutines.CoroutineContext$a, ? extends E extends B>, p0.l<kotlin.coroutines.CoroutineContext$a, E extends B>] */
    public b(@NotNull CoroutineContext.b<B> baseKey, @NotNull l_p0<? super a, ? extends E> safeCast) {
        s.e(baseKey, "baseKey");
        s.e(safeCast, "safeCast");
        this.safeCast = safeCast;
        this.topmostKey = baseKey instanceof b ? (CoroutineContext.b<B>) ((b) baseKey).topmostKey : baseKey;
    }

    public final boolean a(@NotNull CoroutineContext.b<?> key) {
        s.e(key, "key");
        return key == this || this.topmostKey == key;
    }

    /* JADX WARN: Incorrect return type in method signature: (Lkotlin/coroutines/CoroutineContext$a;)TE; */
    @Nullable
    public final CoroutineContext.a b(@NotNull CoroutineContext.a element) {
        s.e(element, "element");
        return (CoroutineContext.a) this.safeCast.invoke(element);
    }
}
