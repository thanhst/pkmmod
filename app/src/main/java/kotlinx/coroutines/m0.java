package kotlinx.coroutines;

import com.facebook.internal.ServerProtocol;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Builders.common.kt */
@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\u000b\u0010\n¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/m0;", "T", "Lkotlinx/coroutines/internal/z;", "", "P0", "()Z", "", ServerProtocol.DIALOG_PARAM_STATE, "Lkotlin/t;", "M", "(Ljava/lang/Object;)V", "K0", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class m0<T> extends kotlinx.coroutines.internal.z<T> {

    /* renamed from: h, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f3864h = AtomicIntegerFieldUpdater.newUpdater(m0.class, "_decision");

    @NotNull
    private volatile /* synthetic */ int _decision;

    private final boolean P0() {
        do {
            int i2 = this._decision;
            if (i2 != 0) {
                if (i2 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f3864h.compareAndSet(this, 0, 2));
        return true;
    }

    @Override // kotlinx.coroutines.internal.z, kotlinx.coroutines.a
    protected void K0(@Nullable Object state) {
        if (P0()) {
            return;
        }
        kotlinx.coroutines.internal.h.c(IntrinsicsKt__IntrinsicsJvmKt.c(this.uCont), z.a(state, this.uCont), null, 2, null);
    }

    @Override // kotlinx.coroutines.internal.z, kotlinx.coroutines.n1
    protected void M(@Nullable Object state) {
        K0(state);
    }
}
