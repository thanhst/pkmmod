package kotlinx.coroutines.debug.internal;

import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.y;
import kotlin.t;
import kotlinx.coroutines.h1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p0.l;

/* compiled from: DebugProbesImpl.kt */
@Metadata(bv = {}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001:\u00010B\t\b\u0002¢\u0006\u0004\b.\u0010/J\u001d\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u000b\u001a\u0004\u0018\u00010\n*\u00020\nH\u0082\u0010¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u000e\u001a\u00020\u00042\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R$\u0010\u0017\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\u00030\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u001cR\"\u0010#\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010'\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010\u001e\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R\"\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R \u0010-\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020+0\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010\u0016¨\u00061"}, d2 = {"Lkotlinx/coroutines/debug/internal/d;", "", "Lkotlin/Function1;", "", "Lkotlin/t;", "d", "()Lp0/l;", "Lkotlinx/coroutines/debug/internal/d$a;", "e", "(Lkotlinx/coroutines/debug/internal/d$a;)Z", "Lkotlin/coroutines/jvm/internal/c;", "g", "(Lkotlin/coroutines/jvm/internal/c;)Lkotlin/coroutines/jvm/internal/c;", "owner", "f", "(Lkotlinx/coroutines/debug/internal/d$a;)V", "Ljava/text/SimpleDateFormat;", "b", "Ljava/text/SimpleDateFormat;", "dateFormat", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "c", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "capturedCoroutinesMap", "", "installations", "I", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "coroutineStateLock", "Z", "getSanitizeStackTraces", "()Z", "setSanitizeStackTraces", "(Z)V", "sanitizeStackTraces", "h", "getEnableCreationStackTraces", "setEnableCreationStackTraces", "enableCreationStackTraces", "i", "Lp0/l;", "dynamicAttach", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "j", "callerInfoCache", "<init>", "()V", "a", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f3643a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final SimpleDateFormat dateFormat;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentWeakMap<a<?>, Boolean> capturedCoroutinesMap;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final /* synthetic */ e f3646d;

    /* renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f3647e;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ReentrantReadWriteLock coroutineStateLock;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static boolean sanitizeStackTraces;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static boolean enableCreationStackTraces;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static final l<Boolean, t> dynamicAttach;
    private static volatile int installations;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentWeakMap<kotlin.coroutines.jvm.internal.c, DebugCoroutineInfo> callerInfoCache;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DebugProbesImpl.kt */
    @Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u0003J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J \u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\b\u0010\f\u001a\u00020\u000bH\u0016R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Lkotlinx/coroutines/debug/internal/d$a;", "T", "Lkotlin/coroutines/c;", "Lkotlin/coroutines/jvm/internal/c;", "Ljava/lang/StackTraceElement;", "getStackTraceElement", "Lkotlin/Result;", "result", "Lkotlin/t;", "resumeWith", "(Ljava/lang/Object;)V", "", "toString", "e", "Lkotlin/coroutines/c;", "delegate", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "f", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "info", "g", "Lkotlin/coroutines/jvm/internal/c;", "frame", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "context", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/c;", "callerFrame", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    static final class a<T> implements kotlin.coroutines.c<T>, kotlin.coroutines.jvm.internal.c {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public final kotlin.coroutines.c<T> delegate;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public final DebugCoroutineInfo info;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final kotlin.coroutines.jvm.internal.c frame;

        @Override // kotlin.coroutines.jvm.internal.c
        @Nullable
        public kotlin.coroutines.jvm.internal.c getCallerFrame() {
            kotlin.coroutines.jvm.internal.c cVar = this.frame;
            if (cVar == null) {
                return null;
            }
            return cVar.getCallerFrame();
        }

        @Override // kotlin.coroutines.c
        @NotNull
        public CoroutineContext getContext() {
            return this.delegate.getContext();
        }

        @Override // kotlin.coroutines.jvm.internal.c
        @Nullable
        public StackTraceElement getStackTraceElement() {
            kotlin.coroutines.jvm.internal.c cVar = this.frame;
            if (cVar == null) {
                return null;
            }
            return cVar.getStackTraceElement();
        }

        @Override // kotlin.coroutines.c
        public void resumeWith(@NotNull Object result) {
            d.f3643a.f(this);
            this.delegate.resumeWith(result);
        }

        @NotNull
        public String toString() {
            return this.delegate.toString();
        }
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [kotlinx.coroutines.debug.internal.e] */
    static {
        d dVar = new d();
        f3643a = dVar;
        dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        capturedCoroutinesMap = new ConcurrentWeakMap<>(false, 1, null);
        final long j2 = 0;
        f3646d = new Object(j2) { // from class: kotlinx.coroutines.debug.internal.e
            volatile long sequenceNumber;

            {
                this.sequenceNumber = j2;
            }
        };
        coroutineStateLock = new ReentrantReadWriteLock();
        sanitizeStackTraces = true;
        enableCreationStackTraces = true;
        dynamicAttach = dVar.d();
        callerInfoCache = new ConcurrentWeakMap<>(true);
        f3647e = AtomicLongFieldUpdater.newUpdater(e.class, "sequenceNumber");
    }

    private d() {
    }

    private final l<Boolean, t> d() {
        Object objM158constructorimpl;
        Object objNewInstance;
        try {
            Result.Companion companion = Result.INSTANCE;
            objNewInstance = Class.forName("kotlinx.coroutines.debug.internal.ByteBuddyDynamicAttach").getConstructors()[0].newInstance(new Object[0]);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM158constructorimpl = Result.m158constructorimpl(kotlin.h.a(th));
        }
        if (objNewInstance == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Function1<kotlin.Boolean, kotlin.Unit>");
        }
        objM158constructorimpl = Result.m158constructorimpl((l) y.b(objNewInstance, 1));
        if (Result.m164isFailureimpl(objM158constructorimpl)) {
            objM158constructorimpl = null;
        }
        return (l) objM158constructorimpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean e(a<?> aVar) {
        CoroutineContext coroutineContextC = aVar.info.c();
        h1 h1Var = coroutineContextC == null ? null : (h1) coroutineContextC.get(h1.INSTANCE);
        if (h1Var == null || !h1Var.w()) {
            return false;
        }
        capturedCoroutinesMap.remove(aVar);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(a<?> owner) {
        capturedCoroutinesMap.remove(owner);
        kotlin.coroutines.jvm.internal.c cVarF = owner.info.f();
        kotlin.coroutines.jvm.internal.c cVarG = cVarF == null ? null : g(cVarF);
        if (cVarG == null) {
            return;
        }
        callerInfoCache.remove(cVarG);
    }

    private final kotlin.coroutines.jvm.internal.c g(kotlin.coroutines.jvm.internal.c cVar) {
        do {
            cVar = cVar.getCallerFrame();
            if (cVar == null) {
                return null;
            }
        } while (cVar.getStackTraceElement() == null);
        return cVar;
    }
}
