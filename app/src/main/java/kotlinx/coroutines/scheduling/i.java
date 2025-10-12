package kotlinx.coroutines.scheduling;

import kotlin.Metadata;

/* compiled from: Tasks.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\b\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/scheduling/i;", "Lkotlinx/coroutines/scheduling/h;", "Lkotlin/t;", "a", "", "I", "b", "()I", "taskMode", "<init>", "(I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
final class i implements h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int taskMode;

    public i(int i2) {
        this.taskMode = i2;
    }

    @Override // kotlinx.coroutines.scheduling.h
    public void a() {
    }

    @Override // kotlinx.coroutines.scheduling.h
    /* renamed from: b, reason: from getter */
    public int getTaskMode() {
        return this.taskMode;
    }
}
