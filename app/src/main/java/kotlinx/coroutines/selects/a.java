package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import p0.l;
import p0.p;

/* compiled from: Select.kt */
@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002JG\u0010\t\u001a\u00020\b\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00010\u00042\"\u0010\u0007\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005H¦\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ8\u0010\u000e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u001c\u0010\u0007\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00020\rH'ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/selects/a;", "R", "", "Q", "Lkotlinx/coroutines/selects/d;", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "block", "Lkotlin/t;", "i", "(Lkotlinx/coroutines/selects/d;Lp0/p;)V", "", "timeMillis", "Lkotlin/Function1;", "d", "(JLp0/l;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public interface a<R> {
    @ExperimentalCoroutinesApi
    void d(long timeMillis, @NotNull l<? super kotlin.coroutines.c<? super R>, ? extends Object> block);

    <Q> void i(@NotNull d<? extends Q> dVar, @NotNull p<? super Q, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar);
}
