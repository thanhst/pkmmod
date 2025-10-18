package kotlinx.coroutines.selects;

import com.facebook.login.LoginLogger;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.s;
import kotlin.t;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.h1;
import kotlinx.coroutines.i1;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.n;
import kotlinx.coroutines.internal.w;
import kotlinx.coroutines.m;
import kotlinx.coroutines.q0;
import kotlinx.coroutines.z;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p0.l_p0;
import p0.p_p0;
import u0.a_u0;
import u0.b_u0;

/* compiled from: Select.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\b\u0001\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0012\u0004\u0012\u00028\u00000\u00052\u00060\u0006j\u0002`\u0007:\u0004OHP8B\u0015\u0012\f\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\bM\u0010NJ\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\u000e\u001a\n\u0018\u00010\fj\u0004\u0018\u0001`\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0012\u001a\u00020\b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0011\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\u001c\u0010\u0017J\u0017\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b\"\u0010#J\u001b\u0010&\u001a\u0004\u0018\u00010\u00182\b\u0010%\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b&\u0010'J\u0019\u0010*\u001a\u0004\u0018\u00010\u00182\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b*\u0010+J\u000f\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b-\u0010.JG\u00103\u001a\u00020\b\"\u0004\b\u0001\u0010/*\b\u0012\u0004\u0012\u00028\u0001002\"\u00102\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u001801H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b3\u00104J8\u00108\u001a\u00020\b2\u0006\u00106\u001a\u0002052\u001c\u00102\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u001807H\u0016ø\u0001\u0000¢\u0006\u0004\b8\u00109R\u001a\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010:R(\u0010@\u001a\u0004\u0018\u00010\u001d2\b\u0010<\u001a\u0004\u0018\u00010\u001d8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b=\u0010>\"\u0004\b?\u0010 R\u001c\u0010C\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bA\u0010BR\u0014\u0010G\u001a\u00020D8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bE\u0010FR\u001a\u0010J\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bH\u0010IR\u0014\u0010L\u001a\u00020!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bK\u0010#\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006Q"}, d2 = {"Lkotlinx/coroutines/selects/b;", "R", "Lkotlinx/coroutines/internal/n;", "Lkotlinx/coroutines/selects/a;", "Lkotlinx/coroutines/selects/f;", "Lkotlin/coroutines/c;", "Lkotlin/coroutines/jvm/internal/c;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "Lkotlin/t;", "X", "()V", "T", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "Lkotlin/Result;", "result", "resumeWith", "(Ljava/lang/Object;)V", "", "exception", "g", "(Ljava/lang/Throwable;)V", "", "V", "()Ljava/lang/Object;", "e", "W", "Lkotlinx/coroutines/q0;", "handle", "o", "(Lkotlinx/coroutines/q0;)V", "", "l", "()Z", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$c;", "otherOp", "j", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$c;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/b;", "desc", "h", "(Lkotlinx/coroutines/internal/b;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", "Q", "Lkotlinx/coroutines/selects/d;", "Lkotlin/Function2;", "block", "i", "(Lkotlinx/coroutines/selects/d;Lp0/p;)V", "", "timeMillis", "Lkotlin/Function1;", "d", "(JLp0/l;)V", "Lkotlin/coroutines/c;", "uCont", "value", "U", "()Lkotlinx/coroutines/q0;", "Y", "parentHandle", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/c;", "callerFrame", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "context", "b", "()Lkotlin/coroutines/c;", "completion", "q", "isSelected", "<init>", "(Lkotlin/coroutines/c;)V", "a", "c", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
@PublishedApi
/* renamed from: kotlinx.coroutines.selects.b, reason: from toString */
/* loaded from: classes.dex */
public final class SelectInstance<R> extends n implements a<R>, f<R>, kotlin.coroutines.c<R>, kotlin.coroutines.jvm.internal.c {

    /* renamed from: i, reason: collision with root package name */
    static final /* synthetic */ AtomicReferenceFieldUpdater f3941i = AtomicReferenceFieldUpdater.newUpdater(SelectInstance.class, Object.class, "_state");

    /* renamed from: j, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f3942j = AtomicReferenceFieldUpdater.newUpdater(SelectInstance.class, Object.class, "_result");

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final kotlin.coroutines.c<R> uCont;

    /* renamed from: _state, reason: from toString */
    @NotNull
    volatile /* synthetic */ Object state = g.e();

    /* renamed from: _result, reason: from toString */
    @NotNull
    private volatile /* synthetic */ Object result = g.f3954c;

    @NotNull
    private volatile /* synthetic */ Object _parentHandle = null;

    /* compiled from: Select.kt */
    @Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u001b\u0012\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\r\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u001a\u0010\u001bJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002J\u0014\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\n\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R\u0018\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0019\u001a\u00020\u00158\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lkotlinx/coroutines/selects/b$a;", "Lkotlinx/coroutines/internal/d;", "", "k", "Lkotlin/t;", "l", LoginLogger.EVENT_EXTRAS_FAILURE, "j", "affected", "i", "d", "", "toString", "Lkotlinx/coroutines/selects/b;", "b", "Lkotlinx/coroutines/selects/b;", "impl", "Lkotlinx/coroutines/internal/b;", "c", "Lkotlinx/coroutines/internal/b;", "desc", "", "J", "g", "()J", "opSequence", "<init>", "(Lkotlinx/coroutines/selects/b;Lkotlinx/coroutines/internal/b;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    /* renamed from: kotlinx.coroutines.selects.b$a, reason: from toString */
    private static final class AtomicSelectOp extends kotlinx.coroutines.internal.d<Object> {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public final SelectInstance<?> impl;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public final kotlinx.coroutines.internal.b desc;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final long opSequence = g.f3956e.a();

        public AtomicSelectOp(@NotNull SelectInstance<?> selectInstance, @NotNull kotlinx.coroutines.internal.b bVar) {
            this.impl = selectInstance;
            this.desc = bVar;
            bVar.d(this);
        }

        private final void j(Object obj) {
            boolean z2 = obj == null;
            if (kotlin.i.a(SelectInstance.f3941i, this.impl, this, z2 ? null : g.e()) && z2) {
                this.impl.T();
            }
        }

        private final Object k() {
            SelectInstance<?> selectInstance = this.impl;
            while (true) {
                Object obj = selectInstance.state;
                if (obj == this) {
                    return null;
                }
                if (obj instanceof w) {
                    ((w) obj).c(this.impl);
                } else {
                    if (obj != g.e()) {
                        return g.d();
                    }
                    if (kotlin.i.a(SelectInstance.f3941i, this.impl, g.e(), this)) {
                        return null;
                    }
                }
            }
        }

        private final void l() {
            kotlin.i.a(SelectInstance.f3941i, this.impl, this, g.e());
        }

        @Override // kotlinx.coroutines.internal.d
        public void d(@Nullable Object obj, @Nullable Object obj2) {
            j(obj2);
            this.desc.a(this, obj2);
        }

        @Override // kotlinx.coroutines.internal.d
        /* renamed from: g, reason: from getter */
        public long getOpSequence() {
            return this.opSequence;
        }

        @Override // kotlinx.coroutines.internal.d
        @Nullable
        public Object i(@Nullable Object affected) {
            Object objK;
            if (affected == null && (objK = k()) != null) {
                return objK;
            }
            try {
                return this.desc.c(this);
            } catch (Throwable th) {
                if (affected == null) {
                    l();
                }
                throw th;
            }
        }

        @Override // kotlinx.coroutines.internal.w
        @NotNull
        public String toString() {
            return "AtomicSelectOp(sequence=" + getOpSequence() + ')';
        }
    }

    /* compiled from: Select.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/selects/b$b;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/q0;", "h", "Lkotlinx/coroutines/q0;", "handle", "<init>", "(Lkotlinx/coroutines/q0;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    /* renamed from: kotlinx.coroutines.selects.b$b, reason: collision with other inner class name */
    private static final class C0064b extends LockFreeLinkedListNode {

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public final q0 handle;

        public C0064b(@NotNull q0 q0Var) {
            this.handle = q0Var;
        }
    }

    /* compiled from: Select.kt */
    @Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\n¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/selects/b$c;", "Lkotlinx/coroutines/internal/w;", "", "affected", "c", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$c;", "a", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$c;", "otherOp", "Lkotlinx/coroutines/internal/d;", "()Lkotlinx/coroutines/internal/d;", "atomicOp", "<init>", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$c;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    /* renamed from: kotlinx.coroutines.selects.b$c */
    private static final class c extends w {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public final LockFreeLinkedListNode.PrepareOp otherOp;

        public c(@NotNull LockFreeLinkedListNode.PrepareOp prepareOp) {
            this.otherOp = prepareOp;
        }

        @Override // kotlinx.coroutines.internal.w
        @NotNull
        public kotlinx.coroutines.internal.d<?> a() {
            return this.otherOp.a();
        }

        @Override // kotlinx.coroutines.internal.w
        @Nullable
        public Object c(@Nullable Object affected) {
            if (affected == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.selects.SelectBuilderImpl<*>");
            }
            SelectInstance selectInstance = (SelectInstance) affected;
            this.otherOp.d();
            Object objE = this.otherOp.a().e(null);
            kotlin.i.a(SelectInstance.f3941i, selectInstance, this, objE == null ? this.otherOp.desc : g.e());
            return objE;
        }
    }

    /* compiled from: Select.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/selects/b$d;", "Lkotlinx/coroutines/i1;", "", "cause", "Lkotlin/t;", "Q", "<init>", "(Lkotlinx/coroutines/selects/b;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    /* renamed from: kotlinx.coroutines.selects.b$d */
    private final class d extends i1 {
        public d() {
        }

        @Override // kotlinx.coroutines.y
        public void Q(@Nullable Throwable th) {
            if (SelectInstance.this.l()) {
                SelectInstance.this.g(R().t());
            }
        }

        @Override // p0.l
        public /* bridge */ /* synthetic */ t invoke(Throwable th) {
            Q(th);
            return t.f3507a;
        }
    }

    /* compiled from: Runnable.kt */
    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lkotlin/t;", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    /* renamed from: kotlinx.coroutines.selects.b$e */
    public static final class e implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ l_p0 f3951f;

        public e(l_p0 lP0Var) {
            this.f3951f = lP0Var;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (SelectInstance.this.l()) {
                a_u0.c(this.f3951f, SelectInstance.this.b());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SelectInstance(@NotNull kotlin.coroutines.c<? super R> cVar) {
        this.uCont = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T() {
        q0 q0VarU = U();
        if (q0VarU != null) {
            q0VarU.a();
        }
        for (LockFreeLinkedListNode lockFreeLinkedListNodeC = (LockFreeLinkedListNode) B(); !s.a(lockFreeLinkedListNodeC, this); lockFreeLinkedListNodeC = lockFreeLinkedListNodeC.C()) {
            if (lockFreeLinkedListNodeC instanceof C0064b) {
                ((C0064b) lockFreeLinkedListNodeC).handle.a();
            }
        }
    }

    private final q0 U() {
        return (q0) this._parentHandle;
    }

    private final void X() {
        h1 h1Var = (h1) getContext().get(h1.INSTANCE);
        if (h1Var == null) {
            return;
        }
        q0 q0VarC = h1.a.c(h1Var, true, false, new d(), 2, null);
        Y(q0VarC);
        if (q()) {
            q0VarC.a();
        }
    }

    private final void Y(q0 q0Var) {
        this._parentHandle = q0Var;
    }

    @PublishedApi
    @Nullable
    public final Object V() throws Throwable {
        if (!q()) {
            X();
        }
        Object obj = this.result;
        if (obj == g.f3954c) {
            if (kotlin.i.a(f3942j, this, g.f3954c, kotlin.coroutines.intrinsics.b.d())) {
                return kotlin.coroutines.intrinsics.b.d();
            }
            obj = this.result;
        }
        if (obj == g.f3955d) {
            throw new IllegalStateException("Already resumed");
        }
        if (obj instanceof kotlinx.coroutines.w) {
            throw ((kotlinx.coroutines.w) obj).cause;
        }
        return obj;
    }

    @PublishedApi
    public final void W(@NotNull Throwable e2) throws Throwable {
        if (l()) {
            Result.Companion companion = Result.INSTANCE;
            resumeWith(Result.m158constructorimpl(kotlin.h.a(e2)));
        } else {
            if (e2 instanceof CancellationException) {
                return;
            }
            Object objV = V();
            if ((objV instanceof kotlinx.coroutines.w) && ((kotlinx.coroutines.w) objV).cause == e2) {
                return;
            }
            d0.a(getContext(), e2);
        }
    }

    @Override // kotlinx.coroutines.selects.f
    @NotNull
    public kotlin.coroutines.c<R> b() {
        return this;
    }

    @Override // kotlinx.coroutines.selects.a
    public void d(long timeMillis, @NotNull l_p0<? super kotlin.coroutines.c<? super R>, ? extends Object> block) {
        if (timeMillis > 0) {
            o(DelayKt.c(getContext()).c(timeMillis, new e(block), getContext()));
        } else if (l()) {
            b_u0.c(block, b());
        }
    }

    @Override // kotlinx.coroutines.selects.f
    public void g(@NotNull Throwable exception) {
        while (true) {
            Object obj = this.result;
            if (obj == g.f3954c) {
                if (kotlin.i.a(f3942j, this, g.f3954c, new kotlinx.coroutines.w(exception, false, 2, null))) {
                    return;
                }
            } else {
                if (obj != kotlin.coroutines.intrinsics.b.d()) {
                    throw new IllegalStateException("Already resumed");
                }
                if (kotlin.i.a(f3942j, this, kotlin.coroutines.intrinsics.b.d(), g.f3955d)) {
                    kotlin.coroutines.c cVarC = IntrinsicsKt__IntrinsicsJvmKt.c(this.uCont);
                    Result.Companion companion = Result.INSTANCE;
                    cVarC.resumeWith(Result.m158constructorimpl(kotlin.h.a(exception)));
                    return;
                }
            }
        }
    }

    @Override // kotlin.coroutines.jvm.internal.c
    @Nullable
    public kotlin.coroutines.jvm.internal.c getCallerFrame() {
        kotlin.coroutines.c<R> cVar = this.uCont;
        if (cVar instanceof kotlin.coroutines.jvm.internal.c) {
            return (kotlin.coroutines.jvm.internal.c) cVar;
        }
        return null;
    }

    @Override // kotlin.coroutines.c
    @NotNull
    public CoroutineContext getContext() {
        return this.uCont.getContext();
    }

    @Override // kotlin.coroutines.jvm.internal.c
    @Nullable
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlinx.coroutines.selects.f
    @Nullable
    public Object h(@NotNull kotlinx.coroutines.internal.b desc) {
        return new AtomicSelectOp(this, desc).c(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.selects.a
    public <Q> void i(@NotNull kotlinx.coroutines.selects.d<? extends Q> dVar, @NotNull p_p0<? super Q, ? super kotlin.coroutines.c<? super R>, ? extends Object> pP0Var) {
        dVar.a(this, pP0Var);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0031, code lost:
    
        T();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0036, code lost:
    
        return kotlinx.coroutines.m.f3863a;
     */
    @Override // kotlinx.coroutines.selects.f
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object j(@org.jetbrains.annotations.Nullable kotlinx.coroutines.internal.LockFreeLinkedListNode.PrepareOp r4) {
        /*
            r3 = this;
        L0:
            java.lang.Object r0 = r3.state
            java.lang.Object r1 = kotlinx.coroutines.selects.g.e()
            r2 = 0
            if (r0 != r1) goto L37
            if (r4 != 0) goto L18
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = kotlinx.coroutines.selects.SelectInstance.f3941i
            java.lang.Object r1 = kotlinx.coroutines.selects.g.e()
            boolean r0 = kotlin.i.a(r0, r3, r1, r2)
            if (r0 != 0) goto L31
            goto L0
        L18:
            kotlinx.coroutines.selects.b$c r0 = new kotlinx.coroutines.selects.b$c
            r0.<init>(r4)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = kotlinx.coroutines.selects.SelectInstance.f3941i
            java.lang.Object r2 = kotlinx.coroutines.selects.g.e()
            boolean r1 = kotlin.i.a(r1, r3, r2, r0)
            if (r1 != 0) goto L2a
            goto L0
        L2a:
            java.lang.Object r4 = r0.c(r3)
            if (r4 == 0) goto L31
            return r4
        L31:
            r3.T()
            kotlinx.coroutines.internal.d0 r4 = kotlinx.coroutines.m.f3863a
            return r4
        L37:
            boolean r1 = r0 instanceof kotlinx.coroutines.internal.w
            if (r1 == 0) goto L6b
            if (r4 == 0) goto L65
            kotlinx.coroutines.internal.d r1 = r4.a()
            boolean r2 = r1 instanceof kotlinx.coroutines.selects.SelectInstance.AtomicSelectOp
            if (r2 == 0) goto L59
            r2 = r1
            kotlinx.coroutines.selects.b$a r2 = (kotlinx.coroutines.selects.SelectInstance.AtomicSelectOp) r2
            kotlinx.coroutines.selects.b<?> r2 = r2.impl
            if (r2 == r3) goto L4d
            goto L59
        L4d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "Cannot use matching select clauses on the same object"
            java.lang.String r0 = r0.toString()
            r4.<init>(r0)
            throw r4
        L59:
            r2 = r0
            kotlinx.coroutines.internal.w r2 = (kotlinx.coroutines.internal.w) r2
            boolean r1 = r1.b(r2)
            if (r1 == 0) goto L65
            java.lang.Object r4 = kotlinx.coroutines.internal.c.f3804b
            return r4
        L65:
            kotlinx.coroutines.internal.w r0 = (kotlinx.coroutines.internal.w) r0
            r0.c(r3)
            goto L0
        L6b:
            if (r4 != 0) goto L6e
            return r2
        L6e:
            kotlinx.coroutines.internal.LockFreeLinkedListNode$a r4 = r4.desc
            if (r0 != r4) goto L75
            kotlinx.coroutines.internal.d0 r4 = kotlinx.coroutines.m.f3863a
            return r4
        L75:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.selects.SelectInstance.j(kotlinx.coroutines.internal.LockFreeLinkedListNode$c):java.lang.Object");
    }

    @Override // kotlinx.coroutines.selects.f
    public boolean l() {
        Object objJ = j(null);
        if (objJ == m.f3863a) {
            return true;
        }
        if (objJ == null) {
            return false;
        }
        throw new IllegalStateException(s.m("Unexpected trySelectIdempotent result ", objJ).toString());
    }

    @Override // kotlinx.coroutines.selects.f
    public void o(@NotNull q0 handle) {
        C0064b c0064b = new C0064b(handle);
        if (!q()) {
            v(c0064b);
            if (!q()) {
                return;
            }
        }
        handle.a();
    }

    @Override // kotlinx.coroutines.selects.f
    public boolean q() {
        while (true) {
            Object obj = this.state;
            if (obj == g.e()) {
                return false;
            }
            if (!(obj instanceof w)) {
                return true;
            }
            ((w) obj).c(this);
        }
    }

    @Override // kotlin.coroutines.c
    public void resumeWith(@NotNull Object result) {
        while (true) {
            Object obj = this.result;
            if (obj == g.f3954c) {
                if (kotlin.i.a(f3942j, this, g.f3954c, z.d(result, null, 1, null))) {
                    return;
                }
            } else {
                if (obj != kotlin.coroutines.intrinsics.b.d()) {
                    throw new IllegalStateException("Already resumed");
                }
                if (kotlin.i.a(f3942j, this, kotlin.coroutines.intrinsics.b.d(), g.f3955d)) {
                    if (!Result.m164isFailureimpl(result)) {
                        this.uCont.resumeWith(result);
                        return;
                    }
                    kotlin.coroutines.c<R> cVar = this.uCont;
                    Throwable thM161exceptionOrNullimpl = Result.m161exceptionOrNullimpl(result);
                    s.b(thM161exceptionOrNullimpl);
                    cVar.resumeWith(Result.m158constructorimpl(kotlin.h.a(thM161exceptionOrNullimpl)));
                    return;
                }
            }
        }
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    @NotNull
    public String toString() {
        return "SelectInstance(state=" + this.state + ", result=" + this.result + ')';
    }
}
