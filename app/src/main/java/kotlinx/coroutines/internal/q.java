package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LockFreeTaskQueue.kt */
@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0010\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u000f\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/internal/q;", "", "E", "Lkotlin/t;", "b", "()V", "element", "", "a", "(Ljava/lang/Object;)Z", "d", "()Ljava/lang/Object;", "", "c", "()I", "size", "singleConsumer", "<init>", "(Z)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public class q<E> {

    /* renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f3835a = AtomicReferenceFieldUpdater.newUpdater(q.class, Object.class, "_cur");

    @NotNull
    private volatile /* synthetic */ Object _cur;

    public q(boolean z2) {
        this._cur = new r(8, z2);
    }

    public final boolean a(@NotNull E element) {
        while (true) {
            r rVar = (r) this._cur;
            int iA = rVar.a(element);
            if (iA == 0) {
                return true;
            }
            if (iA == 1) {
                kotlin.i.a(f3835a, this, rVar, rVar.i());
            } else if (iA == 2) {
                return false;
            }
        }
    }

    public final void b() {
        while (true) {
            r rVar = (r) this._cur;
            if (rVar.d()) {
                return;
            } else {
                kotlin.i.a(f3835a, this, rVar, rVar.i());
            }
        }
    }

    public final int c() {
        return ((r) this._cur).f();
    }

    @Nullable
    public final E d() {
        while (true) {
            r rVar = (r) this._cur;
            E e2 = (E) rVar.j();
            if (e2 != r.f3839h) {
                return e2;
            }
            kotlin.i.a(f3835a, this, rVar, rVar.i());
        }
    }
}
