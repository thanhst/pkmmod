package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JobSupport.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002R\u0018\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/p;", "Lkotlinx/coroutines/i1;", "", "cause", "Lkotlin/t;", "Q", "Lkotlinx/coroutines/l;", "i", "Lkotlinx/coroutines/l;", "child", "<init>", "(Lkotlinx/coroutines/l;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class p extends i1 {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public final l<?> child;

    public p(@NotNull l<?> lVar) {
        this.child = lVar;
    }

    @Override // kotlinx.coroutines.y
    public void Q(@Nullable Throwable th) {
        l<?> lVar = this.child;
        lVar.F(lVar.r(R()));
    }

    @Override // p0.l
    public /* bridge */ /* synthetic */ kotlin.t invoke(Throwable th) {
        Q(th);
        return kotlin.t.f3507a;
    }
}
