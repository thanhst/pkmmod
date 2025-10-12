package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;

/* compiled from: ThreadContextElement.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/a0;", "S", "Lkotlinx/coroutines/y1;", "j", "Lkotlin/coroutines/CoroutineContext$a;", "overwritingElement", "Lkotlin/coroutines/CoroutineContext;", "f", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
@DelicateCoroutinesApi
@ExperimentalCoroutinesApi
/* loaded from: classes.dex */
public interface a0<S> extends y1<S> {
    @NotNull
    CoroutineContext f(@NotNull CoroutineContext.a overwritingElement);

    @NotNull
    a0<S> j();
}
