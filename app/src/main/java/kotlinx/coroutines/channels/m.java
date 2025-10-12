package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.s;
import kotlinx.coroutines.d0;
import org.jetbrains.annotations.NotNull;

/* compiled from: Produce.kt */
@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u001d\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0014R\u0014\u0010\r\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/channels/m;", "E", "Lkotlinx/coroutines/channels/f;", "Lkotlinx/coroutines/channels/n;", "Lkotlin/t;", "value", "Q0", "(Lkotlin/t;)V", "", "cause", "", "handled", "L0", "isActive", "()Z", "Lkotlin/coroutines/CoroutineContext;", "parentContext", "Lkotlinx/coroutines/channels/e;", "channel", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/e;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
final class m<E> extends f<E> implements n<E> {
    public m(@NotNull CoroutineContext coroutineContext, @NotNull e<E> eVar) {
        super(coroutineContext, eVar, true, true);
    }

    @Override // kotlinx.coroutines.channels.n
    public /* bridge */ /* synthetic */ s B() {
        return O0();
    }

    @Override // kotlinx.coroutines.a
    protected void L0(@NotNull Throwable th, boolean z2) {
        if (P0().g(th) || z2) {
            return;
        }
        d0.a(getContext(), th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.a
    /* renamed from: Q0, reason: merged with bridge method [inline-methods] */
    public void M0(@NotNull kotlin.t value) {
        s.a.a(P0(), null, 1, null);
    }

    @Override // kotlinx.coroutines.a, kotlinx.coroutines.n1, kotlinx.coroutines.h1
    public boolean isActive() {
        return super.isActive();
    }
}
