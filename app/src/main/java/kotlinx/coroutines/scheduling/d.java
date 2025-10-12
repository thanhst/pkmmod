package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: Tasks.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/scheduling/d;", "Lkotlinx/coroutines/scheduling/f;", "", "a", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class d extends f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f3918a = new d();

    private d() {
    }

    @Override // kotlinx.coroutines.scheduling.f
    public long a() {
        return System.nanoTime();
    }
}
