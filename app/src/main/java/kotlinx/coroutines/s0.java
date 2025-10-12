package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JobSupport.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/s0;", "Lkotlinx/coroutines/m1;", "", "cause", "Lkotlin/t;", "Q", "Lkotlinx/coroutines/q0;", "i", "Lkotlinx/coroutines/q0;", "handle", "<init>", "(Lkotlinx/coroutines/q0;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class s0 extends m1 {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final q0 handle;

    public s0(@NotNull q0 q0Var) {
        this.handle = q0Var;
    }

    @Override // kotlinx.coroutines.y
    public void Q(@Nullable Throwable th) {
        this.handle.a();
    }

    @Override // p0.l
    public /* bridge */ /* synthetic */ kotlin.t invoke(Throwable th) {
        Q(th);
        return kotlin.t.f3507a;
    }
}
