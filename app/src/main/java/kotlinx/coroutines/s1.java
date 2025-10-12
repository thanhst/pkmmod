package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Job.kt */
@InternalCoroutinesApi
@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/s1;", "Lkotlinx/coroutines/q0;", "Lkotlinx/coroutines/q;", "Lkotlin/t;", "a", "", "cause", "", "m", "", "toString", "Lkotlinx/coroutines/h1;", "getParent", "()Lkotlinx/coroutines/h1;", "parent", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class s1 implements q0, q {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final s1 f3893e = new s1();

    private s1() {
    }

    @Override // kotlinx.coroutines.q0
    public void a() {
    }

    @Override // kotlinx.coroutines.q
    @Nullable
    public h1 getParent() {
        return null;
    }

    @Override // kotlinx.coroutines.q
    public boolean m(@NotNull Throwable cause) {
        return false;
    }

    @NotNull
    public String toString() {
        return "NonDisposableHandle";
    }
}
