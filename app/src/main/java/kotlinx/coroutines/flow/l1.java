package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SharedFlow.kt */
@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\b\u0000\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0014\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016J)\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00070\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/flow/l1;", "Lkotlinx/coroutines/flow/internal/c;", "Lkotlinx/coroutines/flow/SharedFlowImpl;", "flow", "", "c", "", "Lkotlin/coroutines/c;", "Lkotlin/t;", "d", "(Lkotlinx/coroutines/flow/SharedFlowImpl;)[Lkotlin/coroutines/c;", "", "a", "J", "index", "b", "Lkotlin/coroutines/c;", "cont", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class l1 extends kotlinx.coroutines.flow.internal.c<SharedFlowImpl<?>> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public long index = -1;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @Nullable
    public kotlin.coroutines.c<? super kotlin.t> cont;

    @Override // kotlinx.coroutines.flow.internal.c
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(@NotNull SharedFlowImpl<?> flow) {
        if (this.index >= 0) {
            return false;
        }
        this.index = flow.X();
        return true;
    }

    @Override // kotlinx.coroutines.flow.internal.c
    @NotNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public kotlin.coroutines.c<kotlin.t>[] b(@NotNull SharedFlowImpl<?> flow) {
        long j2 = this.index;
        this.index = -1L;
        this.cont = null;
        return flow.W(j2);
    }
}
