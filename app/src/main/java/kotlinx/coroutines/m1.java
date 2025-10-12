package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JobSupport.kt */
@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/m1;", "Lkotlinx/coroutines/y;", "Lkotlinx/coroutines/q0;", "Lkotlinx/coroutines/b1;", "Lkotlin/t;", "a", "", "toString", "Lkotlinx/coroutines/n1;", "h", "Lkotlinx/coroutines/n1;", "R", "()Lkotlinx/coroutines/n1;", "S", "(Lkotlinx/coroutines/n1;)V", "job", "", "isActive", "()Z", "Lkotlinx/coroutines/r1;", "p", "()Lkotlinx/coroutines/r1;", "list", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public abstract class m1 extends y implements q0, b1 {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public n1 job;

    @NotNull
    public final n1 R() {
        n1 n1Var = this.job;
        if (n1Var != null) {
            return n1Var;
        }
        kotlin.jvm.internal.s.t("job");
        return null;
    }

    public final void S(@NotNull n1 n1Var) {
        this.job = n1Var;
    }

    @Override // kotlinx.coroutines.q0
    public void a() {
        R().y0(this);
    }

    @Override // kotlinx.coroutines.b1
    /* renamed from: isActive */
    public boolean getIsActive() {
        return true;
    }

    @Override // kotlinx.coroutines.b1
    @Nullable
    /* renamed from: p */
    public r1 getList() {
        return null;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    @NotNull
    public String toString() {
        return i0.a(this) + '@' + i0.b(this) + "[job@" + i0.b(R()) + ']';
    }
}
