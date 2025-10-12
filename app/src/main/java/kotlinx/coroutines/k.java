package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CancellableContinuation.kt */
@Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u0002J%\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00028\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H'¢\u0006\u0004\b\u0006\u0010\u0007JH\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00028\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042#\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\tH'J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0004H'J1\u0010\u0017\u001a\u00020\r2'\u0010\u0016\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\bj\u0002`\u0015H&J\u001b\u0010\u0019\u001a\u00020\r*\u00020\u00182\u0006\u0010\u0003\u001a\u00028\u0000H'¢\u0006\u0004\b\u0019\u0010\u001aJ<\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00028\u00002#\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bH'¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lkotlinx/coroutines/k;", "T", "Lkotlin/coroutines/c;", "value", "", "idempotent", "c", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlin/t;", "onCancellation", "D", "(Ljava/lang/Object;Ljava/lang/Object;Lp0/l;)Ljava/lang/Object;", "exception", "E", "token", "G", "Lkotlinx/coroutines/CompletionHandler;", "handler", "s", "Lkotlinx/coroutines/CoroutineDispatcher;", "e", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "H", "(Ljava/lang/Object;Lp0/l;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public interface k<T> extends kotlin.coroutines.c<T> {

    /* compiled from: CancellableContinuation.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        public static /* synthetic */ Object a(k kVar, Object obj, Object obj2, int i2, Object obj3) {
            if (obj3 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryResume");
            }
            if ((i2 & 2) != 0) {
                obj2 = null;
            }
            return kVar.c(obj, obj2);
        }
    }

    @InternalCoroutinesApi
    @Nullable
    Object D(T value, @Nullable Object idempotent, @Nullable p0.l<? super Throwable, kotlin.t> onCancellation);

    @InternalCoroutinesApi
    @Nullable
    Object E(@NotNull Throwable exception);

    @InternalCoroutinesApi
    void G(@NotNull Object obj);

    @ExperimentalCoroutinesApi
    void H(T value, @Nullable p0.l<? super Throwable, kotlin.t> onCancellation);

    @InternalCoroutinesApi
    @Nullable
    Object c(T value, @Nullable Object idempotent);

    @ExperimentalCoroutinesApi
    void e(@NotNull CoroutineDispatcher coroutineDispatcher, T t2);

    void s(@NotNull p0.l<? super Throwable, kotlin.t> lVar);
}
