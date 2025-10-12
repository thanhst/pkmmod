package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JobSupport.kt */
@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/r;", "Lkotlinx/coroutines/i1;", "Lkotlinx/coroutines/q;", "", "cause", "Lkotlin/t;", "Q", "", "m", "Lkotlinx/coroutines/s;", "i", "Lkotlinx/coroutines/s;", "childJob", "Lkotlinx/coroutines/h1;", "getParent", "()Lkotlinx/coroutines/h1;", "parent", "<init>", "(Lkotlinx/coroutines/s;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class r extends i1 implements q {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public final s childJob;

    public r(@NotNull s sVar) {
        this.childJob = sVar;
    }

    @Override // kotlinx.coroutines.y
    public void Q(@Nullable Throwable th) {
        this.childJob.A(R());
    }

    @Override // kotlinx.coroutines.q
    @NotNull
    public h1 getParent() {
        return R();
    }

    @Override // p0.l
    public /* bridge */ /* synthetic */ kotlin.t invoke(Throwable th) {
        Q(th);
        return kotlin.t.f3507a;
    }

    @Override // kotlinx.coroutines.q
    public boolean m(@NotNull Throwable cause) {
        return R().T(cause);
    }
}
