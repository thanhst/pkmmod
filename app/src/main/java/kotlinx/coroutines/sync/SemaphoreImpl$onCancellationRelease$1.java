package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.t;
import org.jetbrains.annotations.NotNull;
import p0.l_p0;

/* compiled from: Semaphore.kt */
@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "<anonymous parameter 0>", "Lkotlin/t;", "invoke", "(Ljava/lang/Throwable;)V", "<anonymous>"}, k = 3, mv = {1, 6, 0})
/* loaded from: classes.dex */
final class SemaphoreImpl$onCancellationRelease$1 extends Lambda implements l_p0<Throwable, t> {
    final /* synthetic */ e this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SemaphoreImpl$onCancellationRelease$1(e eVar) {
        super(1);
        this.this$0 = eVar;
    }

    @Override // p0.l
    public /* bridge */ /* synthetic */ t invoke(Throwable th) {
        invoke2(th);
        return t.f3507a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull Throwable th) {
        this.this$0.release();
    }
}
