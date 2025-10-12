package kotlinx.coroutines.flow.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.s;
import kotlin.t;
import kotlinx.coroutines.flow.internal.c;
import kotlinx.coroutines.flow.p1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AbstractSharedFlow.kt */
@Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u0000*\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00012\u00060\u0003j\u0002`\u0004B\u0007¢\u0006\u0004\b&\u0010\u0017J\u000f\u0010\u0005\u001a\u00028\u0000H$¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\t2\u0006\u0010\b\u001a\u00020\u0007H$¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\f\u0010\u0006J\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\u000f\u0010\u0010R>\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\t2\u0010\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\t8\u0004@BX\u0084\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R$\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00078\u0004@BX\u0084\u000e¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001aR\u0018\u0010\"\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010!R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00070#8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010$¨\u0006'"}, d2 = {"Lkotlinx/coroutines/flow/internal/a;", "Lkotlinx/coroutines/flow/internal/c;", "S", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "i", "()Lkotlinx/coroutines/flow/internal/c;", "", "size", "", "j", "(I)[Lkotlinx/coroutines/flow/internal/c;", "h", "slot", "Lkotlin/t;", "k", "(Lkotlinx/coroutines/flow/internal/c;)V", "<set-?>", "e", "[Lkotlinx/coroutines/flow/internal/c;", "m", "()[Lkotlinx/coroutines/flow/internal/c;", "getSlots$annotations", "()V", "slots", "f", "I", "l", "()I", "nCollectors", "g", "nextIndex", "Lkotlinx/coroutines/flow/internal/r;", "Lkotlinx/coroutines/flow/internal/r;", "_subscriptionCount", "Lkotlinx/coroutines/flow/p1;", "()Lkotlinx/coroutines/flow/p1;", "subscriptionCount", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public abstract class a<S extends c<?>> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private S[] slots;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int nCollectors;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int nextIndex;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private r _subscriptionCount;

    @NotNull
    public final p1<Integer> f() {
        r rVar;
        synchronized (this) {
            rVar = this._subscriptionCount;
            if (rVar == null) {
                rVar = new r(getNCollectors());
                this._subscriptionCount = rVar;
            }
        }
        return rVar;
    }

    @NotNull
    protected final S h() {
        S s2;
        r rVar;
        synchronized (this) {
            S[] sArr = (S[]) m();
            if (sArr == null) {
                sArr = (S[]) j(2);
                this.slots = sArr;
            } else if (getNCollectors() >= sArr.length) {
                Object[] objArrCopyOf = Arrays.copyOf(sArr, sArr.length * 2);
                s.d(objArrCopyOf, "copyOf(this, newSize)");
                this.slots = (S[]) ((c[]) objArrCopyOf);
                sArr = (S[]) ((c[]) objArrCopyOf);
            }
            int i2 = this.nextIndex;
            do {
                s2 = sArr[i2];
                if (s2 == null) {
                    s2 = (S) i();
                    sArr[i2] = s2;
                }
                i2++;
                if (i2 >= sArr.length) {
                    i2 = 0;
                }
            } while (!s2.a(this));
            this.nextIndex = i2;
            this.nCollectors = getNCollectors() + 1;
            rVar = this._subscriptionCount;
        }
        if (rVar != null) {
            rVar.Y(1);
        }
        return s2;
    }

    @NotNull
    protected abstract S i();

    @NotNull
    protected abstract S[] j(int size);

    protected final void k(@NotNull S slot) {
        r rVar;
        int i2;
        kotlin.coroutines.c<t>[] cVarArrB;
        synchronized (this) {
            this.nCollectors = getNCollectors() - 1;
            rVar = this._subscriptionCount;
            i2 = 0;
            if (getNCollectors() == 0) {
                this.nextIndex = 0;
            }
            cVarArrB = slot.b(this);
        }
        int length = cVarArrB.length;
        while (i2 < length) {
            kotlin.coroutines.c<t> cVar = cVarArrB[i2];
            i2++;
            if (cVar != null) {
                Result.Companion companion = Result.INSTANCE;
                cVar.resumeWith(Result.m158constructorimpl(t.f3507a));
            }
        }
        if (rVar == null) {
            return;
        }
        rVar.Y(-1);
    }

    /* renamed from: l, reason: from getter */
    protected final int getNCollectors() {
        return this.nCollectors;
    }

    @Nullable
    protected final S[] m() {
        return this.slots;
    }
}
