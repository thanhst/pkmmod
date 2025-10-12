package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ContinuationInterceptor.kt */
@SinceKotlin(version = "1.3")
@Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 \b2\u00020\u0001:\u0001\u0007J\"\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H&J\u0014\u0010\u0007\u001a\u00020\u00062\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016¨\u0006\t"}, d2 = {"Lkotlin/coroutines/d;", "Lkotlin/coroutines/CoroutineContext$a;", "T", "Lkotlin/coroutines/c;", "continuation", "d", "Lkotlin/t;", "b", "a", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes.dex */
public interface d extends CoroutineContext.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f3394e;

    /* compiled from: ContinuationInterceptor.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        @Nullable
        public static <E extends CoroutineContext.a> E a(@NotNull d dVar, @NotNull CoroutineContext.b<E> key) {
            s.e(key, "key");
            if (!(key instanceof b)) {
                if (d.INSTANCE != key) {
                    return null;
                }
                s.c(dVar, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
                return dVar;
            }
            b bVar = (b) key;
            if (!bVar.a(dVar.getKey())) {
                return null;
            }
            E e2 = (E) bVar.b(dVar);
            if (e2 instanceof CoroutineContext.a) {
                return e2;
            }
            return null;
        }

        @NotNull
        public static CoroutineContext b(@NotNull d dVar, @NotNull CoroutineContext.b<?> key) {
            s.e(key, "key");
            if (!(key instanceof b)) {
                return d.INSTANCE == key ? EmptyCoroutineContext.INSTANCE : dVar;
            }
            b bVar = (b) key;
            return (!bVar.a(dVar.getKey()) || bVar.b(dVar) == null) ? dVar : EmptyCoroutineContext.INSTANCE;
        }
    }

    /* compiled from: ContinuationInterceptor.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/coroutines/d$b;", "Lkotlin/coroutines/CoroutineContext$b;", "Lkotlin/coroutines/d;", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
    /* renamed from: kotlin.coroutines.d$b, reason: from kotlin metadata */
    public static final class Companion implements CoroutineContext.b<d> {

        /* renamed from: e, reason: collision with root package name */
        static final /* synthetic */ Companion f3394e = new Companion();

        private Companion() {
        }
    }

    void b(@NotNull c<?> cVar);

    @NotNull
    <T> c<T> d(@NotNull c<? super T> continuation);
}
