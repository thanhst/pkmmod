package kotlinx.coroutines.flow.internal;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.s;
import kotlin.t;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.n;
import kotlinx.coroutines.g0;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i0;
import p0.p_p0;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChannelFlow.kt */
@InternalCoroutinesApi
@Metadata(bv = {}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b)\u0010*J&\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J&\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H$J!\u0010\u000f\u001a\u00020\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\fH¤@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00122\u0006\u0010\r\u001a\u00020\u0011H\u0016J!\u0010\u0016\u001a\u00020\u000e2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u001a\u001a\u00020\u0018H\u0016R\u0014\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001bR\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR9\u0010%\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0!\u0012\u0006\u0012\u0004\u0018\u00010\"0 8@X\u0080\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010(\u001a\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006+"}, d2 = {"Lkotlinx/coroutines/flow/internal/ChannelFlow;", "T", "Lkotlinx/coroutines/flow/internal/k;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/d;", "c", "i", "Lkotlinx/coroutines/channels/n;", "scope", "Lkotlin/t;", "h", "(Lkotlinx/coroutines/channels/n;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/g0;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "l", "Lkotlinx/coroutines/flow/e;", "collector", "a", "(Lkotlinx/coroutines/flow/e;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "e", "toString", "Lkotlin/coroutines/CoroutineContext;", "f", "I", "g", "Lkotlinx/coroutines/channels/BufferOverflow;", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "j", "()Lp0/p;", "collectToFun", "k", "()I", "produceCapacity", "<init>", "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public abstract class ChannelFlow<T> implements k<T> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public final CoroutineContext context;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public final int capacity;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public final BufferOverflow onBufferOverflow;

    public ChannelFlow(@NotNull CoroutineContext coroutineContext, int i2, @NotNull BufferOverflow bufferOverflow) {
        this.context = coroutineContext;
        this.capacity = i2;
        this.onBufferOverflow = bufferOverflow;
    }

    static /* synthetic */ Object g(ChannelFlow channelFlow, kotlinx.coroutines.flow.e eVar, kotlin.coroutines.c cVar) {
        Object objA = h0.a(new ChannelFlow$collect$2(eVar, channelFlow, null), cVar);
        return objA == kotlin.coroutines.intrinsics.b.d() ? objA : t.f3507a;
    }

    @Override // kotlinx.coroutines.flow.d
    @Nullable
    public Object a(@NotNull kotlinx.coroutines.flow.e<? super T> eVar, @NotNull kotlin.coroutines.c<? super t> cVar) {
        return g(this, eVar, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0013 A[PHI: r4
  0x0013: PHI (r4v5 int) = (r4v2 int), (r4v2 int), (r4v4 int) binds: [B:8:0x0011, B:13:0x0019, B:16:0x001d] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // kotlinx.coroutines.flow.internal.k
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public kotlinx.coroutines.flow.d<T> c(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext r2, int r3, @org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.BufferOverflow r4) {
        /*
            r1 = this;
            kotlin.coroutines.CoroutineContext r0 = r1.context
            kotlin.coroutines.CoroutineContext r2 = r2.plus(r0)
            kotlinx.coroutines.channels.BufferOverflow r0 = kotlinx.coroutines.channels.BufferOverflow.SUSPEND
            if (r4 == r0) goto Lb
            goto L25
        Lb:
            int r4 = r1.capacity
            r0 = -3
            if (r4 != r0) goto L11
            goto L23
        L11:
            if (r3 != r0) goto L15
        L13:
            r3 = r4
            goto L23
        L15:
            r0 = -2
            if (r4 != r0) goto L19
            goto L23
        L19:
            if (r3 != r0) goto L1c
            goto L13
        L1c:
            int r4 = r4 + r3
            if (r4 < 0) goto L20
            goto L13
        L20:
            r3 = 2147483647(0x7fffffff, float:NaN)
        L23:
            kotlinx.coroutines.channels.BufferOverflow r4 = r1.onBufferOverflow
        L25:
            kotlin.coroutines.CoroutineContext r0 = r1.context
            boolean r0 = kotlin.jvm.internal.s.a(r2, r0)
            if (r0 == 0) goto L36
            int r0 = r1.capacity
            if (r3 != r0) goto L36
            kotlinx.coroutines.channels.BufferOverflow r0 = r1.onBufferOverflow
            if (r4 != r0) goto L36
            return r1
        L36:
            kotlinx.coroutines.flow.internal.ChannelFlow r2 = r1.i(r2, r3, r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.ChannelFlow.c(kotlin.coroutines.CoroutineContext, int, kotlinx.coroutines.channels.BufferOverflow):kotlinx.coroutines.flow.d");
    }

    @Nullable
    protected String e() {
        return null;
    }

    @Nullable
    protected abstract Object h(@NotNull kotlinx.coroutines.channels.n<? super T> nVar, @NotNull kotlin.coroutines.c<? super t> cVar);

    @NotNull
    protected abstract ChannelFlow<T> i(@NotNull CoroutineContext context, int capacity, @NotNull BufferOverflow onBufferOverflow);

    @NotNull
    public final p_p0<n<? super T>, c<? super t>, Object> j() {
        return new ChannelFlow$collectToFun$1(this, null);
    }

    public final int k() {
        int i2 = this.capacity;
        if (i2 == -3) {
            return -2;
        }
        return i2;
    }

    @NotNull
    public ReceiveChannel<T> l(@NotNull g0 scope) {
        return ProduceKt.d(scope, this.context, k(), this.onBufferOverflow, CoroutineStart.ATOMIC, null, j(), 16, null);
    }

    @NotNull
    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        String strE = e();
        if (strE != null) {
            arrayList.add(strE);
        }
        CoroutineContext coroutineContext = this.context;
        if (coroutineContext != EmptyCoroutineContext.INSTANCE) {
            arrayList.add(s.m("context=", coroutineContext));
        }
        int i2 = this.capacity;
        if (i2 != -3) {
            arrayList.add(s.m("capacity=", Integer.valueOf(i2)));
        }
        BufferOverflow bufferOverflow = this.onBufferOverflow;
        if (bufferOverflow != BufferOverflow.SUSPEND) {
            arrayList.add(s.m("onBufferOverflow=", bufferOverflow));
        }
        return i0.a(this) + '[' + CollectionsKt___CollectionsKt.I(arrayList, ", ", null, null, 0, null, null, 62, null) + ']';
    }
}
