package kotlinx.coroutines.flow;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.channels.BufferOverflow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SharedFlow.kt */
@Metadata(bv = {}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0012\u0004\u0012\u00028\u00000\u00052\b\u0012\u0004\u0012\u00028\u00000\u0006:\u00012B\u001f\u0012\u0006\u0010H\u001a\u00020\u0015\u0012\u0006\u0010J\u001a\u00020\u0015\u0012\u0006\u0010D\u001a\u00020C¢\u0006\u0004\bh\u0010iJ\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u000b\u0010\nJ\b\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0012\u0010\u0012\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0002J9\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00132\u0010\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00028\u0000H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J(\u0010#\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u000eH\u0002J\b\u0010$\u001a\u00020\fH\u0002J\u0012\u0010&\u001a\u0004\u0018\u00010\u00052\u0006\u0010%\u001a\u00020\u0003H\u0002J\u0010\u0010\u0001\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u0003H\u0002J\u0012\u0010(\u001a\u0004\u0018\u00010\u00052\u0006\u0010'\u001a\u00020\u000eH\u0002J\u001b\u0010)\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u0003H\u0082@ø\u0001\u0000¢\u0006\u0004\b)\u0010*J3\u0010-\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\f\u0018\u00010+0\u00132\u0014\u0010,\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\f\u0018\u00010+0\u0013H\u0002¢\u0006\u0004\b-\u0010.J!\u00102\u001a\u0002012\f\u00100\u001a\b\u0012\u0004\u0012\u00028\u00000/H\u0096@ø\u0001\u0000¢\u0006\u0004\b2\u00103J\u0017\u00104\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0004\b4\u0010\nJ\u001b\u00105\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b5\u0010\u001bJ\u000f\u00106\u001a\u00020\u000eH\u0000¢\u0006\u0004\b6\u00107J%\u00109\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\f\u0018\u00010+0\u00132\u0006\u00108\u001a\u00020\u000eH\u0000¢\u0006\u0004\b9\u0010:J\b\u0010;\u001a\u00020\u0003H\u0014J\u001f\u0010=\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00132\u0006\u0010<\u001a\u00020\u0015H\u0014¢\u0006\u0004\b=\u0010>J\b\u0010?\u001a\u00020\fH\u0016J&\u0010F\u001a\b\u0012\u0004\u0012\u00028\u00000E2\u0006\u0010A\u001a\u00020@2\u0006\u0010B\u001a\u00020\u00152\u0006\u0010D\u001a\u00020CH\u0016R\u0014\u0010H\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010-R\u0014\u0010J\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010-R\u0014\u0010D\u001a\u00020C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR \u0010O\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010R\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010T\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010QR\u0016\u0010V\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010-R\u0016\u0010X\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010-R\u0014\u0010Z\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bY\u00107R\u0014\u0010]\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b[\u0010\\R\u0014\u0010_\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b^\u0010\\R\u0014\u0010`\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bQ\u00107R\u0014\u0010b\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\ba\u00107R\u001a\u0010g\u001a\u00028\u00008DX\u0084\u0004¢\u0006\f\u0012\u0004\be\u0010f\u001a\u0004\bc\u0010d\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006j"}, d2 = {"Lkotlinx/coroutines/flow/SharedFlowImpl;", "T", "Lkotlinx/coroutines/flow/internal/a;", "Lkotlinx/coroutines/flow/l1;", "Lkotlinx/coroutines/flow/f1;", "", "Lkotlinx/coroutines/flow/internal/k;", "value", "", "R", "(Ljava/lang/Object;)Z", "S", "Lkotlin/t;", "E", "", "newHead", "B", "item", "H", "", "curBuffer", "", "curSize", "newSize", "Q", "([Ljava/lang/Object;II)[Ljava/lang/Object;", "G", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/SharedFlowImpl$a;", "emitter", "y", "newReplayIndex", "newMinCollectorIndex", "newBufferEndIndex", "newQueueEndIndex", "V", "z", "slot", "U", "index", "M", "x", "(Lkotlinx/coroutines/flow/l1;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/coroutines/c;", "resumesIn", "I", "([Lkotlin/coroutines/c;)[Lkotlin/coroutines/c;", "Lkotlinx/coroutines/flow/e;", "collector", "", "a", "(Lkotlinx/coroutines/flow/e;Lkotlin/coroutines/c;)Ljava/lang/Object;", "d", "emit", "X", "()J", "oldIndex", "W", "(J)[Lkotlin/coroutines/c;", "C", "size", "D", "(I)[Lkotlinx/coroutines/flow/l1;", "b", "Lkotlin/coroutines/CoroutineContext;", "context", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/d;", "c", "i", "replay", "j", "bufferCapacity", "k", "Lkotlinx/coroutines/channels/BufferOverflow;", "l", "[Ljava/lang/Object;", "buffer", "m", "J", "replayIndex", "n", "minCollectorIndex", "o", "bufferSize", "p", "queueSize", "K", "head", "O", "()I", "replaySize", "P", "totalSize", "bufferEndIndex", "N", "queueEndIndex", "L", "()Ljava/lang/Object;", "getLastReplayedLocked$annotations", "()V", "lastReplayedLocked", "<init>", "(IILkotlinx/coroutines/channels/BufferOverflow;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public class SharedFlowImpl<T> extends kotlinx.coroutines.flow.internal.a<l1> implements f1<T>, d, kotlinx.coroutines.flow.internal.k<T> {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int replay;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final int bufferCapacity;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final BufferOverflow onBufferOverflow;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Object[] buffer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private long replayIndex;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private long minCollectorIndex;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private int bufferSize;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private int queueSize;

    /* compiled from: SharedFlow.kt */
    @Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B3\u0012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\f\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0016\u0010\u000b\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lkotlinx/coroutines/flow/SharedFlowImpl$a;", "Lkotlinx/coroutines/q0;", "Lkotlin/t;", "a", "Lkotlinx/coroutines/flow/SharedFlowImpl;", "e", "Lkotlinx/coroutines/flow/SharedFlowImpl;", "flow", "", "f", "J", "index", "", "g", "Ljava/lang/Object;", "value", "Lkotlin/coroutines/c;", "h", "Lkotlin/coroutines/c;", "cont", "<init>", "(Lkotlinx/coroutines/flow/SharedFlowImpl;JLjava/lang/Object;Lkotlin/coroutines/c;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private static final class a implements kotlinx.coroutines.q0 {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public final SharedFlowImpl<?> flow;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @JvmField
        public long index;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public final Object value;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public final kotlin.coroutines.c<kotlin.t> cont;

        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull SharedFlowImpl<?> sharedFlowImpl, long j2, @Nullable Object obj, @NotNull kotlin.coroutines.c<? super kotlin.t> cVar) {
            this.flow = sharedFlowImpl;
            this.index = j2;
            this.value = obj;
            this.cont = cVar;
        }

        @Override // kotlinx.coroutines.q0
        public void a() {
            this.flow.y(this);
        }
    }

    /* compiled from: SharedFlow.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3721a;

        static {
            int[] iArr = new int[BufferOverflow.values().length];
            iArr[BufferOverflow.SUSPEND.ordinal()] = 1;
            iArr[BufferOverflow.DROP_LATEST.ordinal()] = 2;
            iArr[BufferOverflow.DROP_OLDEST.ordinal()] = 3;
            f3721a = iArr;
        }
    }

    public SharedFlowImpl(int i2, int i3, @NotNull BufferOverflow bufferOverflow) {
        this.replay = i2;
        this.bufferCapacity = i3;
        this.onBufferOverflow = bufferOverflow;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object A(kotlinx.coroutines.flow.SharedFlowImpl r8, kotlinx.coroutines.flow.e r9, kotlin.coroutines.c r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 225
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SharedFlowImpl.A(kotlinx.coroutines.flow.SharedFlowImpl, kotlinx.coroutines.flow.e, kotlin.coroutines.c):java.lang.Object");
    }

    private final void B(long j2) {
        kotlinx.coroutines.flow.internal.c[] cVarArr;
        if (((kotlinx.coroutines.flow.internal.a) this).nCollectors != 0 && (cVarArr = ((kotlinx.coroutines.flow.internal.a) this).slots) != null) {
            int i2 = 0;
            int length = cVarArr.length;
            while (i2 < length) {
                kotlinx.coroutines.flow.internal.c cVar = cVarArr[i2];
                i2++;
                if (cVar != null) {
                    l1 l1Var = (l1) cVar;
                    long j3 = l1Var.index;
                    if (j3 >= 0 && j3 < j2) {
                        l1Var.index = j2;
                    }
                }
            }
        }
        this.minCollectorIndex = j2;
    }

    private final void E() {
        Object[] objArr = this.buffer;
        kotlin.jvm.internal.s.b(objArr);
        k1.e(objArr, K(), null);
        this.bufferSize--;
        long jK = K() + 1;
        if (this.replayIndex < jK) {
            this.replayIndex = jK;
        }
        if (this.minCollectorIndex < jK) {
            B(jK);
        }
    }

    static /* synthetic */ Object F(SharedFlowImpl sharedFlowImpl, Object obj, kotlin.coroutines.c cVar) {
        if (sharedFlowImpl.d(obj)) {
            return kotlin.t.f3507a;
        }
        Object objG = sharedFlowImpl.G(obj, cVar);
        return objG == kotlin.coroutines.intrinsics.b.d() ? objG : kotlin.t.f3507a;
    }

    private final Object G(T t2, kotlin.coroutines.c<? super kotlin.t> cVar) {
        kotlin.coroutines.c<kotlin.t>[] cVarArrI;
        a aVar;
        kotlinx.coroutines.l lVar = new kotlinx.coroutines.l(IntrinsicsKt__IntrinsicsJvmKt.c(cVar), 1);
        lVar.w();
        kotlin.coroutines.c<kotlin.t>[] cVarArrI2 = kotlinx.coroutines.flow.internal.b.f3755a;
        synchronized (this) {
            if (R(t2)) {
                Result.Companion companion = Result.INSTANCE;
                lVar.resumeWith(Result.m158constructorimpl(kotlin.t.f3507a));
                cVarArrI = I(cVarArrI2);
                aVar = null;
            } else {
                a aVar2 = new a(this, P() + K(), t2, lVar);
                H(aVar2);
                this.queueSize++;
                if (this.bufferCapacity == 0) {
                    cVarArrI2 = I(cVarArrI2);
                }
                cVarArrI = cVarArrI2;
                aVar = aVar2;
            }
        }
        if (aVar != null) {
            kotlinx.coroutines.n.a(lVar, aVar);
        }
        int i2 = 0;
        int length = cVarArrI.length;
        while (i2 < length) {
            kotlin.coroutines.c<kotlin.t> cVar2 = cVarArrI[i2];
            i2++;
            if (cVar2 != null) {
                Result.Companion companion2 = Result.INSTANCE;
                cVar2.resumeWith(Result.m158constructorimpl(kotlin.t.f3507a));
            }
        }
        Object objT = lVar.t();
        if (objT == kotlin.coroutines.intrinsics.b.d()) {
            kotlin.coroutines.jvm.internal.e.c(cVar);
        }
        return objT == kotlin.coroutines.intrinsics.b.d() ? objT : kotlin.t.f3507a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(Object obj) {
        int iP = P();
        Object[] objArrQ = this.buffer;
        if (objArrQ == null) {
            objArrQ = Q(null, 0, 2);
        } else if (iP >= objArrQ.length) {
            objArrQ = Q(objArrQ, iP, objArrQ.length * 2);
        }
        k1.e(objArrQ, K() + iP, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v6, types: [java.lang.Object, java.lang.Object[]] */
    public final kotlin.coroutines.c<kotlin.t>[] I(kotlin.coroutines.c<kotlin.t>[] resumesIn) {
        kotlinx.coroutines.flow.internal.c[] cVarArr;
        l1 l1Var;
        kotlin.coroutines.c<? super kotlin.t> cVar;
        int length = resumesIn.length;
        if (((kotlinx.coroutines.flow.internal.a) this).nCollectors != 0 && (cVarArr = ((kotlinx.coroutines.flow.internal.a) this).slots) != null) {
            int i2 = 0;
            int length2 = cVarArr.length;
            while (i2 < length2) {
                kotlinx.coroutines.flow.internal.c cVar2 = cVarArr[i2];
                i2++;
                if (cVar2 != null && (cVar = (l1Var = (l1) cVar2).cont) != null && T(l1Var) >= 0) {
                    int length3 = resumesIn.length;
                    resumesIn = resumesIn;
                    if (length >= length3) {
                        ?? CopyOf = Arrays.copyOf(resumesIn, Math.max(2, resumesIn.length * 2));
                        kotlin.jvm.internal.s.d(CopyOf, "copyOf(this, newSize)");
                        resumesIn = CopyOf;
                    }
                    resumesIn[length] = cVar;
                    l1Var.cont = null;
                    length++;
                }
            }
        }
        return resumesIn;
    }

    private final long J() {
        return K() + this.bufferSize;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long K() {
        return Math.min(this.minCollectorIndex, this.replayIndex);
    }

    private final Object M(long index) {
        Object[] objArr = this.buffer;
        kotlin.jvm.internal.s.b(objArr);
        Object objD = k1.d(objArr, index);
        return objD instanceof a ? ((a) objD).value : objD;
    }

    private final long N() {
        return K() + this.bufferSize + this.queueSize;
    }

    private final int O() {
        return (int) ((K() + this.bufferSize) - this.replayIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int P() {
        return this.bufferSize + this.queueSize;
    }

    private final Object[] Q(Object[] curBuffer, int curSize, int newSize) {
        if (!(newSize > 0)) {
            throw new IllegalStateException("Buffer size overflow".toString());
        }
        Object[] objArr = new Object[newSize];
        this.buffer = objArr;
        if (curBuffer == null) {
            return objArr;
        }
        long jK = K();
        for (int i2 = 0; i2 < curSize; i2++) {
            long j2 = i2 + jK;
            k1.e(objArr, j2, k1.d(curBuffer, j2));
        }
        return objArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean R(T value) {
        if (getNCollectors() == 0) {
            return S(value);
        }
        if (this.bufferSize >= this.bufferCapacity && this.minCollectorIndex <= this.replayIndex) {
            int i2 = b.f3721a[this.onBufferOverflow.ordinal()];
            if (i2 == 1) {
                return false;
            }
            if (i2 == 2) {
                return true;
            }
        }
        H(value);
        int i3 = this.bufferSize + 1;
        this.bufferSize = i3;
        if (i3 > this.bufferCapacity) {
            E();
        }
        if (O() > this.replay) {
            V(this.replayIndex + 1, this.minCollectorIndex, J(), N());
        }
        return true;
    }

    private final boolean S(T value) {
        if (this.replay == 0) {
            return true;
        }
        H(value);
        int i2 = this.bufferSize + 1;
        this.bufferSize = i2;
        if (i2 > this.replay) {
            E();
        }
        this.minCollectorIndex = K() + this.bufferSize;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long T(l1 slot) {
        long j2 = slot.index;
        if (j2 < J()) {
            return j2;
        }
        if (this.bufferCapacity <= 0 && j2 <= K() && this.queueSize != 0) {
            return j2;
        }
        return -1L;
    }

    private final Object U(l1 slot) {
        Object obj;
        kotlin.coroutines.c<kotlin.t>[] cVarArrW = kotlinx.coroutines.flow.internal.b.f3755a;
        synchronized (this) {
            long jT = T(slot);
            if (jT < 0) {
                obj = k1.f3767a;
            } else {
                long j2 = slot.index;
                Object objM = M(jT);
                slot.index = jT + 1;
                cVarArrW = W(j2);
                obj = objM;
            }
        }
        int i2 = 0;
        int length = cVarArrW.length;
        while (i2 < length) {
            kotlin.coroutines.c<kotlin.t> cVar = cVarArrW[i2];
            i2++;
            if (cVar != null) {
                Result.Companion companion = Result.INSTANCE;
                cVar.resumeWith(Result.m158constructorimpl(kotlin.t.f3507a));
            }
        }
        return obj;
    }

    private final void V(long j2, long j3, long j4, long j5) {
        long jMin = Math.min(j3, j2);
        for (long jK = K(); jK < jMin; jK = 1 + jK) {
            Object[] objArr = this.buffer;
            kotlin.jvm.internal.s.b(objArr);
            k1.e(objArr, jK, null);
        }
        this.replayIndex = j2;
        this.minCollectorIndex = j3;
        this.bufferSize = (int) (j4 - jMin);
        this.queueSize = (int) (j5 - j4);
    }

    private final Object x(l1 l1Var, kotlin.coroutines.c<? super kotlin.t> cVar) {
        kotlinx.coroutines.l lVar = new kotlinx.coroutines.l(IntrinsicsKt__IntrinsicsJvmKt.c(cVar), 1);
        lVar.w();
        synchronized (this) {
            if (T(l1Var) < 0) {
                l1Var.cont = lVar;
            } else {
                Result.Companion companion = Result.INSTANCE;
                lVar.resumeWith(Result.m158constructorimpl(kotlin.t.f3507a));
            }
            kotlin.t tVar = kotlin.t.f3507a;
        }
        Object objT = lVar.t();
        if (objT == kotlin.coroutines.intrinsics.b.d()) {
            kotlin.coroutines.jvm.internal.e.c(cVar);
        }
        return objT == kotlin.coroutines.intrinsics.b.d() ? objT : kotlin.t.f3507a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(a aVar) {
        synchronized (this) {
            if (aVar.index < K()) {
                return;
            }
            Object[] objArr = this.buffer;
            kotlin.jvm.internal.s.b(objArr);
            if (k1.d(objArr, aVar.index) != aVar) {
                return;
            }
            k1.e(objArr, aVar.index, k1.f3767a);
            z();
            kotlin.t tVar = kotlin.t.f3507a;
        }
    }

    private final void z() {
        if (this.bufferCapacity != 0 || this.queueSize > 1) {
            Object[] objArr = this.buffer;
            kotlin.jvm.internal.s.b(objArr);
            while (this.queueSize > 0 && k1.d(objArr, (K() + P()) - 1) == k1.f3767a) {
                this.queueSize--;
                k1.e(objArr, K() + P(), null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.a
    @NotNull
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public l1 i() {
        return new l1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.a
    @NotNull
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public l1[] j(int size) {
        return new l1[size];
    }

    protected final T L() {
        Object[] objArr = this.buffer;
        kotlin.jvm.internal.s.b(objArr);
        return (T) k1.d(objArr, (this.replayIndex + O()) - 1);
    }

    @NotNull
    public final kotlin.coroutines.c<kotlin.t>[] W(long oldIndex) {
        long j2;
        kotlinx.coroutines.flow.internal.c[] cVarArr;
        if (oldIndex > this.minCollectorIndex) {
            return kotlinx.coroutines.flow.internal.b.f3755a;
        }
        long jK = K();
        long j3 = this.bufferSize + jK;
        long j4 = 1;
        if (this.bufferCapacity == 0 && this.queueSize > 0) {
            j3++;
        }
        if (((kotlinx.coroutines.flow.internal.a) this).nCollectors != 0 && (cVarArr = ((kotlinx.coroutines.flow.internal.a) this).slots) != null) {
            int length = cVarArr.length;
            int i2 = 0;
            while (i2 < length) {
                kotlinx.coroutines.flow.internal.c cVar = cVarArr[i2];
                i2++;
                if (cVar != null) {
                    long j5 = ((l1) cVar).index;
                    if (j5 >= 0 && j5 < j3) {
                        j3 = j5;
                    }
                }
            }
        }
        if (j3 <= this.minCollectorIndex) {
            return kotlinx.coroutines.flow.internal.b.f3755a;
        }
        long J = J();
        int iMin = getNCollectors() > 0 ? Math.min(this.queueSize, this.bufferCapacity - ((int) (J - j3))) : this.queueSize;
        kotlin.coroutines.c<kotlin.t>[] cVarArr2 = kotlinx.coroutines.flow.internal.b.f3755a;
        long j6 = this.queueSize + J;
        if (iMin > 0) {
            cVarArr2 = new kotlin.coroutines.c[iMin];
            Object[] objArr = this.buffer;
            kotlin.jvm.internal.s.b(objArr);
            long j7 = J;
            int i3 = 0;
            while (true) {
                if (J >= j6) {
                    j2 = j3;
                    break;
                }
                long j8 = J + j4;
                Object objD = k1.d(objArr, J);
                kotlinx.coroutines.internal.d0 d0Var = k1.f3767a;
                if (objD == d0Var) {
                    J = j8;
                } else {
                    if (objD == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
                    }
                    a aVar = (a) objD;
                    int i4 = i3 + 1;
                    j2 = j3;
                    cVarArr2[i3] = aVar.cont;
                    k1.e(objArr, J, d0Var);
                    long j9 = j7;
                    k1.e(objArr, j9, aVar.value);
                    j7 = j9 + 1;
                    if (i4 >= iMin) {
                        break;
                    }
                    i3 = i4;
                    J = j8;
                    j3 = j2;
                }
                j4 = 1;
            }
            J = j7;
        } else {
            j2 = j3;
        }
        int i5 = (int) (J - jK);
        long j10 = getNCollectors() == 0 ? J : j2;
        long jMax = Math.max(this.replayIndex, J - Math.min(this.replay, i5));
        if (this.bufferCapacity == 0 && jMax < j6) {
            Object[] objArr2 = this.buffer;
            kotlin.jvm.internal.s.b(objArr2);
            if (kotlin.jvm.internal.s.a(k1.d(objArr2, jMax), k1.f3767a)) {
                J++;
                jMax++;
            }
        }
        V(jMax, j10, J, j6);
        z();
        return (cVarArr2.length == 0) ^ true ? I(cVarArr2) : cVarArr2;
    }

    public final long X() {
        long j2 = this.replayIndex;
        if (j2 < this.minCollectorIndex) {
            this.minCollectorIndex = j2;
        }
        return j2;
    }

    @Override // kotlinx.coroutines.flow.j1, kotlinx.coroutines.flow.d
    @Nullable
    public Object a(@NotNull e<? super T> eVar, @NotNull kotlin.coroutines.c<?> cVar) {
        return A(this, eVar, cVar);
    }

    @Override // kotlinx.coroutines.flow.f1
    public void b() {
        synchronized (this) {
            V(J(), this.minCollectorIndex, J(), N());
            kotlin.t tVar = kotlin.t.f3507a;
        }
    }

    @Override // kotlinx.coroutines.flow.internal.k
    @NotNull
    public d<T> c(@NotNull CoroutineContext context, int capacity, @NotNull BufferOverflow onBufferOverflow) {
        return k1.c(this, context, capacity, onBufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.f1
    public boolean d(T value) {
        int i2;
        boolean z2;
        kotlin.coroutines.c<kotlin.t>[] cVarArrI = kotlinx.coroutines.flow.internal.b.f3755a;
        synchronized (this) {
            i2 = 0;
            if (R(value)) {
                cVarArrI = I(cVarArrI);
                z2 = true;
            } else {
                z2 = false;
            }
        }
        int length = cVarArrI.length;
        while (i2 < length) {
            kotlin.coroutines.c<kotlin.t> cVar = cVarArrI[i2];
            i2++;
            if (cVar != null) {
                Result.Companion companion = Result.INSTANCE;
                cVar.resumeWith(Result.m158constructorimpl(kotlin.t.f3507a));
            }
        }
        return z2;
    }

    @Override // kotlinx.coroutines.flow.e
    @Nullable
    public Object emit(T t2, @NotNull kotlin.coroutines.c<? super kotlin.t> cVar) {
        return F(this, t2, cVar);
    }
}
