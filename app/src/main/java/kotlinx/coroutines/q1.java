package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MainCoroutineDispatcher.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0005R\u0014\u0010\u0007\u001a\u00020\u00008&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/q1;", "Lkotlinx/coroutines/CoroutineDispatcher;", "", "toString", "s", "q", "()Lkotlinx/coroutines/q1;", "immediate", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public abstract class q1 extends CoroutineDispatcher {
    @NotNull
    public abstract q1 q();

    @InternalCoroutinesApi
    @Nullable
    protected final String s() {
        q1 q1VarQ;
        q1 q1VarC = p0.c();
        if (this == q1VarC) {
            return "Dispatchers.Main";
        }
        try {
            q1VarQ = q1VarC.q();
        } catch (UnsupportedOperationException unused) {
            q1VarQ = null;
        }
        if (this == q1VarQ) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public String toString() {
        String strS = s();
        if (strS != null) {
            return strS;
        }
        return i0.a(this) + '@' + i0.b(this);
    }
}
