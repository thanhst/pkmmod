package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: JobSupport.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\t\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/a1;", "Lkotlinx/coroutines/b1;", "", "toString", "Lkotlinx/coroutines/r1;", "e", "Lkotlinx/coroutines/r1;", "p", "()Lkotlinx/coroutines/r1;", "list", "", "isActive", "()Z", "<init>", "(Lkotlinx/coroutines/r1;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class a1 implements b1 {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final r1 list;

    public a1(@NotNull r1 r1Var) {
        this.list = r1Var;
    }

    @Override // kotlinx.coroutines.b1
    public boolean isActive() {
        return false;
    }

    @Override // kotlinx.coroutines.b1
    @NotNull
    /* renamed from: p, reason: from getter */
    public r1 getList() {
        return this.list;
    }

    @NotNull
    public String toString() {
        return super.toString();
    }
}
