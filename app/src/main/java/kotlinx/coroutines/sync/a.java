package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.t;
import kotlinx.coroutines.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Semaphore.kt */
@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/sync/a;", "Lkotlinx/coroutines/i;", "", "cause", "Lkotlin/t;", "a", "", "toString", "Lkotlinx/coroutines/sync/f;", "e", "Lkotlinx/coroutines/sync/f;", "segment", "", "f", "I", "index", "<init>", "(Lkotlinx/coroutines/sync/f;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
final class a extends i {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f segment;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int index;

    public a(@NotNull f fVar, int i2) {
        this.segment = fVar;
        this.index = i2;
    }

    @Override // kotlinx.coroutines.j
    public void a(@Nullable Throwable th) {
        this.segment.q(this.index);
    }

    @Override // p0.l
    public /* bridge */ /* synthetic */ t invoke(Throwable th) {
        a(th);
        return t.f3507a;
    }

    @NotNull
    public String toString() {
        return "CancelSemaphoreAcquisitionHandler[" + this.segment + ", " + this.index + ']';
    }
}
