package kotlinx.coroutines;

import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JobSupport.kt */
@Deprecated(level = DeprecationLevel.ERROR, message = "This is internal API and may be removed in the future releases")
@Metadata(bv = {}, d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0003m¤\u0001B\u0012\u0012\u0007\u0010¡\u0001\u001a\u00020\u0016¢\u0006\u0006\b¢\u0001\u0010£\u0001J#\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ'\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0006\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\fH\u0002¢\u0006\u0004\b \u0010!J\u001d\u0010\"\u001a\u00020\u0011*\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\"\u0010\u001fJ\u0019\u0010$\u001a\u00020#2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b$\u0010%J@\u0010-\u001a\u00020,2'\u0010*\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00110&j\u0002`)2\u0006\u0010+\u001a\u00020\u0016H\u0002¢\u0006\u0004\b-\u0010.J'\u00101\u001a\u00020\u00162\u0006\u0010/\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u00100\u001a\u00020,H\u0002¢\u0006\u0004\b1\u00102J\u0017\u00104\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u000203H\u0002¢\u0006\u0004\b4\u00105J\u0017\u00106\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020,H\u0002¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\u0016H\u0002¢\u0006\u0004\b8\u00109J\u0013\u0010:\u001a\u00020\u0011H\u0082@ø\u0001\u0000¢\u0006\u0004\b:\u0010;J\u001b\u0010<\u001a\u0004\u0018\u00010\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b<\u0010=J\u0019\u0010>\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b>\u0010?J\u001b\u0010@\u001a\u0004\u0018\u00010\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b@\u0010=J\u0019\u0010A\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0006\u001a\u00020\u0014H\u0002¢\u0006\u0004\bA\u0010BJ\u001f\u0010C\u001a\u00020\u00162\u0006\u0010\u0006\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\fH\u0002¢\u0006\u0004\bC\u0010DJ%\u0010E\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\bE\u0010FJ#\u0010G\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u00142\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\bG\u0010HJ\u0019\u0010J\u001a\u0004\u0018\u00010I2\u0006\u0010\u0006\u001a\u00020\u0014H\u0002¢\u0006\u0004\bJ\u0010KJ*\u0010M\u001a\u00020\u00162\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010L\u001a\u00020I2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0082\u0010¢\u0006\u0004\bM\u0010NJ)\u0010P\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010O\u001a\u00020I2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\bP\u0010QJ\u0015\u0010S\u001a\u0004\u0018\u00010I*\u00020RH\u0002¢\u0006\u0004\bS\u0010TJ\u0019\u0010V\u001a\u00020U2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\bV\u0010WJ\u0019\u0010Y\u001a\u00020\u00112\b\u0010X\u001a\u0004\u0018\u00010\u0001H\u0004¢\u0006\u0004\bY\u0010ZJ\r\u0010[\u001a\u00020\u0016¢\u0006\u0004\b[\u00109J\u000f\u0010\\\u001a\u00020\u0011H\u0014¢\u0006\u0004\b\\\u0010]J\u0011\u0010`\u001a\u00060^j\u0002`_¢\u0006\u0004\b`\u0010aJ#\u0010c\u001a\u00060^j\u0002`_*\u00020\f2\n\b\u0002\u0010b\u001a\u0004\u0018\u00010UH\u0004¢\u0006\u0004\bc\u0010dJ6\u0010f\u001a\u00020e2'\u0010*\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00110&j\u0002`)¢\u0006\u0004\bf\u0010gJF\u0010i\u001a\u00020e2\u0006\u0010+\u001a\u00020\u00162\u0006\u0010h\u001a\u00020\u00162'\u0010*\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00110&j\u0002`)¢\u0006\u0004\bi\u0010jJ\u0013\u0010k\u001a\u00020\u0011H\u0086@ø\u0001\u0000¢\u0006\u0004\bk\u0010;J\u0017\u0010l\u001a\u00020\u00112\u0006\u00100\u001a\u00020,H\u0000¢\u0006\u0004\bl\u00107J\u001f\u0010m\u001a\u00020\u00112\u000e\u0010\u001d\u001a\n\u0018\u00010^j\u0004\u0018\u0001`_H\u0016¢\u0006\u0004\bm\u0010nJ\u000f\u0010o\u001a\u00020UH\u0014¢\u0006\u0004\bo\u0010pJ\u0017\u0010q\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\fH\u0016¢\u0006\u0004\bq\u0010rJ\u0015\u0010t\u001a\u00020\u00112\u0006\u0010s\u001a\u00020\u0003¢\u0006\u0004\bt\u0010uJ\u0017\u0010v\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\fH\u0016¢\u0006\u0004\bv\u0010!J\u0017\u0010w\u001a\u00020\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\f¢\u0006\u0004\bw\u0010!J\u0019\u0010x\u001a\u00020\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u0007H\u0000¢\u0006\u0004\bx\u0010yJ\u0013\u0010z\u001a\u00060^j\u0002`_H\u0016¢\u0006\u0004\bz\u0010aJ\u001b\u0010{\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0000¢\u0006\u0004\b{\u0010=J\u0015\u0010}\u001a\u00020|2\u0006\u0010L\u001a\u00020\u0002¢\u0006\u0004\b}\u0010~J\u0019\u0010\u0080\u0001\u001a\u00020\u00112\u0006\u0010\u007f\u001a\u00020\fH\u0010¢\u0006\u0005\b\u0080\u0001\u0010rJ\u001b\u0010\u0081\u0001\u001a\u00020\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\fH\u0014¢\u0006\u0005\b\u0081\u0001\u0010rJ\u0019\u0010\u0082\u0001\u001a\u00020\u00162\u0006\u0010\u007f\u001a\u00020\fH\u0014¢\u0006\u0005\b\u0082\u0001\u0010!J\u001c\u0010\u0083\u0001\u001a\u00020\u00112\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J\u001c\u0010\u0085\u0001\u001a\u00020\u00112\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0006\b\u0085\u0001\u0010\u0084\u0001J\u0011\u0010\u0086\u0001\u001a\u00020UH\u0016¢\u0006\u0005\b\u0086\u0001\u0010pJ\u0011\u0010\u0087\u0001\u001a\u00020UH\u0007¢\u0006\u0005\b\u0087\u0001\u0010pJ\u0011\u0010\u0088\u0001\u001a\u00020UH\u0010¢\u0006\u0005\b\u0088\u0001\u0010pR\u001e\u0010\u008a\u0001\u001a\u0004\u0018\u00010\f*\u0004\u0018\u00010\u00078BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0089\u0001\u0010?R\u0019\u0010\u008e\u0001\u001a\u0007\u0012\u0002\b\u00030\u008b\u00018F¢\u0006\b\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001R.\u0010\u0094\u0001\u001a\u0004\u0018\u00010|2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010|8@@@X\u0080\u000e¢\u0006\u0010\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001\"\u0006\b\u0092\u0001\u0010\u0093\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078@X\u0080\u0004¢\u0006\b\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001R\u0016\u0010\u0097\u0001\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0097\u0001\u00109R\u0013\u0010\u0099\u0001\u001a\u00020\u00168F¢\u0006\u0007\u001a\u0005\b\u0098\u0001\u00109R\u0013\u0010\u009a\u0001\u001a\u00020\u00168F¢\u0006\u0007\u001a\u0005\b\u009a\u0001\u00109R\u0016\u0010\u009c\u0001\u001a\u00020\u00168PX\u0090\u0004¢\u0006\u0007\u001a\u0005\b\u009b\u0001\u00109R\u0016\u0010\u009e\u0001\u001a\u00020\u00168TX\u0094\u0004¢\u0006\u0007\u001a\u0005\b\u009d\u0001\u00109R\u0016\u0010 \u0001\u001a\u00020\u00168PX\u0090\u0004¢\u0006\u0007\u001a\u0005\b\u009f\u0001\u00109\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006¥\u0001"}, d2 = {"Lkotlinx/coroutines/n1;", "Lkotlinx/coroutines/h1;", "Lkotlinx/coroutines/s;", "Lkotlinx/coroutines/u1;", "Lkotlinx/coroutines/selects/c;", "Lkotlinx/coroutines/n1$b;", ServerProtocol.DIALOG_PARAM_STATE, "", "proposedUpdate", "X", "(Lkotlinx/coroutines/n1$b;Ljava/lang/Object;)Ljava/lang/Object;", "", "", "exceptions", "a0", "(Lkotlinx/coroutines/n1$b;Ljava/util/List;)Ljava/lang/Throwable;", "rootCause", "Lkotlin/t;", "L", "(Ljava/lang/Throwable;Ljava/util/List;)V", "Lkotlinx/coroutines/b1;", "update", "", "F0", "(Lkotlinx/coroutines/b1;Ljava/lang/Object;)Z", "U", "(Lkotlinx/coroutines/b1;Ljava/lang/Object;)V", "Lkotlinx/coroutines/r1;", "list", "cause", "r0", "(Lkotlinx/coroutines/r1;Ljava/lang/Throwable;)V", "R", "(Ljava/lang/Throwable;)Z", "s0", "", "A0", "(Ljava/lang/Object;)I", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "onCancelling", "Lkotlinx/coroutines/m1;", "o0", "(Lp0/l;Z)Lkotlinx/coroutines/m1;", "expect", "node", "K", "(Ljava/lang/Object;Lkotlinx/coroutines/r1;Lkotlinx/coroutines/m1;)Z", "Lkotlinx/coroutines/t0;", "w0", "(Lkotlinx/coroutines/t0;)V", "x0", "(Lkotlinx/coroutines/m1;)V", "k0", "()Z", "l0", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "Q", "(Ljava/lang/Object;)Ljava/lang/Object;", "W", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "m0", "d0", "(Lkotlinx/coroutines/b1;)Lkotlinx/coroutines/r1;", "G0", "(Lkotlinx/coroutines/b1;Ljava/lang/Throwable;)Z", "H0", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "I0", "(Lkotlinx/coroutines/b1;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/r;", "Y", "(Lkotlinx/coroutines/b1;)Lkotlinx/coroutines/r;", "child", "J0", "(Lkotlinx/coroutines/n1$b;Lkotlinx/coroutines/r;Ljava/lang/Object;)Z", "lastChild", "V", "(Lkotlinx/coroutines/n1$b;Lkotlinx/coroutines/r;Ljava/lang/Object;)V", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "q0", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/r;", "", "B0", "(Ljava/lang/Object;)Ljava/lang/String;", "parent", "i0", "(Lkotlinx/coroutines/h1;)V", "start", "v0", "()V", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "t", "()Ljava/util/concurrent/CancellationException;", ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "C0", "(Ljava/lang/Throwable;Ljava/lang/String;)Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/q0;", "i", "(Lp0/l;)Lkotlinx/coroutines/q0;", "invokeImmediately", "u", "(ZZLp0/l;)Lkotlinx/coroutines/q0;", "m", "y0", "a", "(Ljava/util/concurrent/CancellationException;)V", "S", "()Ljava/lang/String;", "P", "(Ljava/lang/Throwable;)V", "parentJob", "A", "(Lkotlinx/coroutines/u1;)V", "T", "N", "O", "(Ljava/lang/Object;)Z", "r", "n0", "Lkotlinx/coroutines/q;", "F", "(Lkotlinx/coroutines/s;)Lkotlinx/coroutines/q;", "exception", "h0", "t0", "g0", "u0", "(Ljava/lang/Object;)V", "M", "toString", "E0", "p0", "Z", "exceptionOrNull", "Lkotlin/coroutines/CoroutineContext$b;", "getKey", "()Lkotlin/coroutines/CoroutineContext$b;", "key", "value", "e0", "()Lkotlinx/coroutines/q;", "z0", "(Lkotlinx/coroutines/q;)V", "parentHandle", "f0", "()Ljava/lang/Object;", "isActive", "w", "isCompleted", "isCancelled", "c0", "onCancelComplete", "j0", "isScopedCoroutine", "b0", "handlesException", "active", "<init>", "(Z)V", "b", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public class n1 implements h1, s, u1, kotlinx.coroutines.selects.c {

    /* renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f3867e = AtomicReferenceFieldUpdater.newUpdater(n1.class, Object.class, "_state");

    @NotNull
    private volatile /* synthetic */ Object _parentHandle;

    @NotNull
    private volatile /* synthetic */ Object _state;

    /* compiled from: JobSupport.kt */
    @Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lkotlinx/coroutines/n1$a;", "Lkotlinx/coroutines/m1;", "", "cause", "Lkotlin/t;", "Q", "Lkotlinx/coroutines/n1;", "i", "Lkotlinx/coroutines/n1;", "parent", "Lkotlinx/coroutines/n1$b;", "j", "Lkotlinx/coroutines/n1$b;", ServerProtocol.DIALOG_PARAM_STATE, "Lkotlinx/coroutines/r;", "k", "Lkotlinx/coroutines/r;", "child", "", "l", "Ljava/lang/Object;", "proposedUpdate", "<init>", "(Lkotlinx/coroutines/n1;Lkotlinx/coroutines/n1$b;Lkotlinx/coroutines/r;Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private static final class a extends m1 {

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final n1 parent;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final b state;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final r child;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final Object proposedUpdate;

        public a(@NotNull n1 n1Var, @NotNull b bVar, @NotNull r rVar, @Nullable Object obj) {
            this.parent = n1Var;
            this.state = bVar;
            this.child = rVar;
            this.proposedUpdate = obj;
        }

        @Override // kotlinx.coroutines.y
        public void Q(@Nullable Throwable th) {
            this.parent.V(this.state, this.child, this.proposedUpdate);
        }

        @Override // p0.l
        public /* bridge */ /* synthetic */ kotlin.t invoke(Throwable th) {
            Q(th);
            return kotlin.t.f3507a;
        }
    }

    /* compiled from: JobSupport.kt */
    @Metadata(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003B!\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\u0006\u0010%\u001a\u00020 \u0012\b\u0010)\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b.\u0010/J\u001f\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0019\u001a\u00020\u00148\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R(\u0010\u001f\u001a\u0004\u0018\u00010\u00012\b\u0010\u001a\u001a\u0004\u0018\u00010\u00018B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010%\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020 8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R(\u0010)\u001a\u0004\u0018\u00010\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b&\u0010'\"\u0004\b(\u0010\u0010R\u0011\u0010+\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b*\u0010\"R\u0011\u0010,\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\"R\u0014\u0010-\u001a\u00020 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\"¨\u00060"}, d2 = {"Lkotlinx/coroutines/n1$b;", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "Lkotlinx/coroutines/b1;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "b", "()Ljava/util/ArrayList;", "proposedException", "", "h", "(Ljava/lang/Throwable;)Ljava/util/List;", "exception", "Lkotlin/t;", "a", "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/r1;", "e", "Lkotlinx/coroutines/r1;", "p", "()Lkotlinx/coroutines/r1;", "list", "value", "c", "()Ljava/lang/Object;", "j", "(Ljava/lang/Object;)V", "exceptionsHolder", "", "f", "()Z", "i", "(Z)V", "isCompleting", "d", "()Ljava/lang/Throwable;", "k", "rootCause", "g", "isSealed", "isCancelling", "isActive", "<init>", "(Lkotlinx/coroutines/r1;ZLjava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private static final class b implements b1 {

        @NotNull
        private volatile /* synthetic */ Object _exceptionsHolder = null;

        @NotNull
        private volatile /* synthetic */ int _isCompleting;

        @NotNull
        private volatile /* synthetic */ Object _rootCause;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final r1 list;

        public b(@NotNull r1 r1Var, boolean z2, @Nullable Throwable th) {
            this.list = r1Var;
            this._isCompleting = z2 ? 1 : 0;
            this._rootCause = th;
        }

        private final ArrayList<Throwable> b() {
            return new ArrayList<>(4);
        }

        /* renamed from: c, reason: from getter */
        private final Object get_exceptionsHolder() {
            return this._exceptionsHolder;
        }

        private final void j(Object obj) {
            this._exceptionsHolder = obj;
        }

        public final void a(@NotNull Throwable exception) {
            Throwable thD = d();
            if (thD == null) {
                k(exception);
                return;
            }
            if (exception == thD) {
                return;
            }
            Object obj = get_exceptionsHolder();
            if (obj == null) {
                j(exception);
                return;
            }
            if (!(obj instanceof Throwable)) {
                if (!(obj instanceof ArrayList)) {
                    throw new IllegalStateException(kotlin.jvm.internal.s.m("State is ", obj).toString());
                }
                ((ArrayList) obj).add(exception);
            } else {
                if (exception == obj) {
                    return;
                }
                ArrayList<Throwable> arrayListB = b();
                arrayListB.add(obj);
                arrayListB.add(exception);
                j(arrayListB);
            }
        }

        @Nullable
        public final Throwable d() {
            return (Throwable) this._rootCause;
        }

        public final boolean e() {
            return d() != null;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
        public final boolean f() {
            return this._isCompleting;
        }

        public final boolean g() {
            return get_exceptionsHolder() == o1.f3881e;
        }

        @NotNull
        public final List<Throwable> h(@Nullable Throwable proposedException) {
            ArrayList<Throwable> arrayListB;
            Object obj = get_exceptionsHolder();
            if (obj == null) {
                arrayListB = b();
            } else if (obj instanceof Throwable) {
                ArrayList<Throwable> arrayListB2 = b();
                arrayListB2.add(obj);
                arrayListB = arrayListB2;
            } else {
                if (!(obj instanceof ArrayList)) {
                    throw new IllegalStateException(kotlin.jvm.internal.s.m("State is ", obj).toString());
                }
                arrayListB = (ArrayList) obj;
            }
            Throwable thD = d();
            if (thD != null) {
                arrayListB.add(0, thD);
            }
            if (proposedException != null && !kotlin.jvm.internal.s.a(proposedException, thD)) {
                arrayListB.add(proposedException);
            }
            j(o1.f3881e);
            return arrayListB;
        }

        public final void i(boolean z2) {
            this._isCompleting = z2 ? 1 : 0;
        }

        @Override // kotlinx.coroutines.b1
        /* renamed from: isActive */
        public boolean getIsActive() {
            return d() == null;
        }

        public final void k(@Nullable Throwable th) {
            this._rootCause = th;
        }

        @Override // kotlinx.coroutines.b1
        @NotNull
        /* renamed from: p, reason: from getter */
        public r1 getList() {
            return this.list;
        }

        @NotNull
        public String toString() {
            return "Finishing[cancelling=" + e() + ", completing=" + f() + ", rootCause=" + d() + ", exceptions=" + get_exceptionsHolder() + ", list=" + getList() + ']';
        }
    }

    /* compiled from: LockFreeLinkedList.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/n1$c", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$b;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "affected", "", "k", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static final class c extends LockFreeLinkedListNode.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LockFreeLinkedListNode f3873d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ n1 f3874e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Object f3875f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(LockFreeLinkedListNode lockFreeLinkedListNode, n1 n1Var, Object obj) {
            super(lockFreeLinkedListNode);
            this.f3873d = lockFreeLinkedListNode;
            this.f3874e = n1Var;
            this.f3875f = obj;
        }

        @Override // kotlinx.coroutines.internal.d
        @Nullable
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public Object i(@NotNull LockFreeLinkedListNode affected) {
            if (this.f3874e.f0() == this.f3875f) {
                return null;
            }
            return kotlinx.coroutines.internal.o.a();
        }
    }

    public n1(boolean z2) {
        this._state = z2 ? o1.f3883g : o1.f3882f;
        this._parentHandle = null;
    }

    private final int A0(Object state) {
        if (state instanceof t0) {
            if (((t0) state).getIsActive()) {
                return 0;
            }
            if (!kotlin.i.a(f3867e, this, state, o1.f3883g)) {
                return -1;
            }
            v0();
            return 1;
        }
        if (!(state instanceof a1)) {
            return 0;
        }
        if (!kotlin.i.a(f3867e, this, state, ((a1) state).getList())) {
            return -1;
        }
        v0();
        return 1;
    }

    private final String B0(Object state) {
        if (!(state instanceof b)) {
            return state instanceof b1 ? ((b1) state).getIsActive() ? "Active" : "New" : state instanceof w ? AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_CANCELLED : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_COMPLETED;
        }
        b bVar = (b) state;
        return bVar.e() ? "Cancelling" : bVar.f() ? "Completing" : "Active";
    }

    public static /* synthetic */ CancellationException D0(n1 n1Var, Throwable th, String str, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
        }
        if ((i2 & 1) != 0) {
            str = null;
        }
        return n1Var.C0(th, str);
    }

    private final boolean F0(b1 state, Object update) throws Throwable {
        if (!kotlin.i.a(f3867e, this, state, o1.g(update))) {
            return false;
        }
        t0(null);
        u0(update);
        U(state, update);
        return true;
    }

    private final boolean G0(b1 state, Throwable rootCause) throws Throwable {
        r1 r1VarD0 = d0(state);
        if (r1VarD0 == null) {
            return false;
        }
        if (!kotlin.i.a(f3867e, this, state, new b(r1VarD0, false, rootCause))) {
            return false;
        }
        r0(r1VarD0, rootCause);
        return true;
    }

    private final Object H0(Object state, Object proposedUpdate) {
        return !(state instanceof b1) ? o1.f3877a : ((!(state instanceof t0) && !(state instanceof m1)) || (state instanceof r) || (proposedUpdate instanceof w)) ? I0((b1) state, proposedUpdate) : F0((b1) state, proposedUpdate) ? proposedUpdate : o1.f3879c;
    }

    private final Object I0(b1 state, Object proposedUpdate) throws Throwable {
        r1 r1VarD0 = d0(state);
        if (r1VarD0 == null) {
            return o1.f3879c;
        }
        b bVar = state instanceof b ? (b) state : null;
        if (bVar == null) {
            bVar = new b(r1VarD0, false, null);
        }
        synchronized (bVar) {
            if (bVar.f()) {
                return o1.f3877a;
            }
            bVar.i(true);
            if (bVar != state && !kotlin.i.a(f3867e, this, state, bVar)) {
                return o1.f3879c;
            }
            boolean zE = bVar.e();
            w wVar = proposedUpdate instanceof w ? (w) proposedUpdate : null;
            if (wVar != null) {
                bVar.a(wVar.cause);
            }
            Throwable thD = true ^ zE ? bVar.d() : null;
            kotlin.t tVar = kotlin.t.f3507a;
            if (thD != null) {
                r0(r1VarD0, thD);
            }
            r rVarY = Y(state);
            return (rVarY == null || !J0(bVar, rVarY, proposedUpdate)) ? X(bVar, proposedUpdate) : o1.f3878b;
        }
    }

    private final boolean J0(b state, r child, Object proposedUpdate) {
        while (h1.a.c(child.childJob, false, false, new a(this, state, child, proposedUpdate), 1, null) == s1.f3893e) {
            child = q0(child);
            if (child == null) {
                return false;
            }
        }
        return true;
    }

    private final boolean K(Object expect, r1 list, m1 node) {
        int iP;
        c cVar = new c(node, this, expect);
        do {
            iP = list.F().P(node, list, cVar);
            if (iP == 1) {
                return true;
            }
        } while (iP != 2);
        return false;
    }

    private final void L(Throwable rootCause, List<? extends Throwable> exceptions) {
        if (exceptions.size() <= 1) {
            return;
        }
        Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(exceptions.size()));
        for (Throwable th : exceptions) {
            if (th != rootCause && th != rootCause && !(th instanceof CancellationException) && setNewSetFromMap.add(th)) {
                kotlin.b.a(rootCause, th);
            }
        }
    }

    private final Object Q(Object cause) {
        Object objH0;
        do {
            Object objF0 = f0();
            if (!(objF0 instanceof b1) || ((objF0 instanceof b) && ((b) objF0).f())) {
                return o1.f3877a;
            }
            objH0 = H0(objF0, new w(W(cause), false, 2, null));
        } while (objH0 == o1.f3879c);
        return objH0;
    }

    private final boolean R(Throwable cause) {
        if (j0()) {
            return true;
        }
        boolean z2 = cause instanceof CancellationException;
        q qVarE0 = e0();
        return (qVarE0 == null || qVarE0 == s1.f3893e) ? z2 : qVarE0.m(cause) || z2;
    }

    private final void U(b1 state, Object update) throws Throwable {
        q qVarE0 = e0();
        if (qVarE0 != null) {
            qVarE0.a();
            z0(s1.f3893e);
        }
        w wVar = update instanceof w ? (w) update : null;
        Throwable th = wVar != null ? wVar.cause : null;
        if (!(state instanceof m1)) {
            r1 list = state.getList();
            if (list == null) {
                return;
            }
            s0(list, th);
            return;
        }
        try {
            ((m1) state).Q(th);
        } catch (Throwable th2) {
            h0(new CompletionHandlerException("Exception in completion handler " + state + " for " + this, th2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V(b state, r lastChild, Object proposedUpdate) {
        r rVarQ0 = q0(lastChild);
        if (rVarQ0 == null || !J0(state, rVarQ0, proposedUpdate)) {
            M(X(state, proposedUpdate));
        }
    }

    private final Throwable W(Object cause) {
        if (cause == null ? true : cause instanceof Throwable) {
            Throwable th = (Throwable) cause;
            return th == null ? new JobCancellationException(S(), null, this) : th;
        }
        if (cause != null) {
            return ((u1) cause).r();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
    }

    private final Object X(b state, Object proposedUpdate) throws Throwable {
        boolean zE;
        Throwable thA0;
        w wVar = proposedUpdate instanceof w ? (w) proposedUpdate : null;
        Throwable th = wVar == null ? null : wVar.cause;
        synchronized (state) {
            zE = state.e();
            List<Throwable> listH = state.h(th);
            thA0 = a0(state, listH);
            if (thA0 != null) {
                L(thA0, listH);
            }
        }
        if (thA0 != null && thA0 != th) {
            proposedUpdate = new w(thA0, false, 2, null);
        }
        if (thA0 != null) {
            if (R(thA0) || g0(thA0)) {
                if (proposedUpdate == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                }
                ((w) proposedUpdate).b();
            }
        }
        if (!zE) {
            t0(thA0);
        }
        u0(proposedUpdate);
        kotlin.i.a(f3867e, this, state, o1.g(proposedUpdate));
        U(state, proposedUpdate);
        return proposedUpdate;
    }

    private final r Y(b1 state) {
        r rVar = state instanceof r ? (r) state : null;
        if (rVar != null) {
            return rVar;
        }
        r1 list = state.getList();
        if (list == null) {
            return null;
        }
        return q0(list);
    }

    private final Throwable Z(Object obj) {
        w wVar = obj instanceof w ? (w) obj : null;
        if (wVar == null) {
            return null;
        }
        return wVar.cause;
    }

    private final Throwable a0(b state, List<? extends Throwable> exceptions) {
        Object next;
        Object obj = null;
        if (exceptions.isEmpty()) {
            if (state.e()) {
                return new JobCancellationException(S(), null, this);
            }
            return null;
        }
        Iterator<T> it = exceptions.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (!(((Throwable) next) instanceof CancellationException)) {
                break;
            }
        }
        Throwable th = (Throwable) next;
        if (th != null) {
            return th;
        }
        Throwable th2 = exceptions.get(0);
        if (th2 instanceof TimeoutCancellationException) {
            Iterator<T> it2 = exceptions.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next2 = it2.next();
                Throwable th3 = (Throwable) next2;
                if (th3 != th2 && (th3 instanceof TimeoutCancellationException)) {
                    obj = next2;
                    break;
                }
            }
            Throwable th4 = (Throwable) obj;
            if (th4 != null) {
                return th4;
            }
        }
        return th2;
    }

    private final r1 d0(b1 state) {
        r1 list = state.getList();
        if (list != null) {
            return list;
        }
        if (state instanceof t0) {
            return new r1();
        }
        if (!(state instanceof m1)) {
            throw new IllegalStateException(kotlin.jvm.internal.s.m("State should have list: ", state).toString());
        }
        x0((m1) state);
        return null;
    }

    private final boolean k0() {
        Object objF0;
        do {
            objF0 = f0();
            if (!(objF0 instanceof b1)) {
                return false;
            }
        } while (A0(objF0) < 0);
        return true;
    }

    private final Object l0(kotlin.coroutines.c<? super kotlin.t> cVar) {
        l lVar = new l(IntrinsicsKt__IntrinsicsJvmKt.c(cVar), 1);
        lVar.w();
        n.a(lVar, i(new w1(lVar)));
        Object objT = lVar.t();
        if (objT == kotlin.coroutines.intrinsics.b.d()) {
            kotlin.coroutines.jvm.internal.e.c(cVar);
        }
        return objT == kotlin.coroutines.intrinsics.b.d() ? objT : kotlin.t.f3507a;
    }

    private final Object m0(Object cause) throws Throwable {
        Throwable thW = null;
        while (true) {
            Object objF0 = f0();
            if (objF0 instanceof b) {
                synchronized (objF0) {
                    if (((b) objF0).g()) {
                        return o1.f3880d;
                    }
                    boolean zE = ((b) objF0).e();
                    if (cause != null || !zE) {
                        if (thW == null) {
                            thW = W(cause);
                        }
                        ((b) objF0).a(thW);
                    }
                    Throwable thD = zE ^ true ? ((b) objF0).d() : null;
                    if (thD != null) {
                        r0(((b) objF0).getList(), thD);
                    }
                    return o1.f3877a;
                }
            }
            if (!(objF0 instanceof b1)) {
                return o1.f3880d;
            }
            if (thW == null) {
                thW = W(cause);
            }
            b1 b1Var = (b1) objF0;
            if (!b1Var.getIsActive()) {
                Object objH0 = H0(objF0, new w(thW, false, 2, null));
                if (objH0 == o1.f3877a) {
                    throw new IllegalStateException(kotlin.jvm.internal.s.m("Cannot happen in ", objF0).toString());
                }
                if (objH0 != o1.f3879c) {
                    return objH0;
                }
            } else if (G0(b1Var, thW)) {
                return o1.f3877a;
            }
        }
    }

    private final m1 o0(p0.l<? super Throwable, kotlin.t> handler, boolean onCancelling) {
        m1 g1Var;
        if (onCancelling) {
            g1Var = handler instanceof i1 ? (i1) handler : null;
            if (g1Var == null) {
                g1Var = new f1(handler);
            }
        } else {
            m1 m1Var = handler instanceof m1 ? (m1) handler : null;
            g1Var = m1Var != null ? m1Var : null;
            if (g1Var == null) {
                g1Var = new g1(handler);
            }
        }
        g1Var.S(this);
        return g1Var;
    }

    private final r q0(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (lockFreeLinkedListNode.K()) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.F();
        }
        while (true) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.C();
            if (!lockFreeLinkedListNode.K()) {
                if (lockFreeLinkedListNode instanceof r) {
                    return (r) lockFreeLinkedListNode;
                }
                if (lockFreeLinkedListNode instanceof r1) {
                    return null;
                }
            }
        }
    }

    private final void r0(r1 list, Throwable cause) throws Throwable {
        CompletionHandlerException completionHandlerException;
        t0(cause);
        CompletionHandlerException completionHandlerException2 = null;
        for (LockFreeLinkedListNode lockFreeLinkedListNodeC = (LockFreeLinkedListNode) list.B(); !kotlin.jvm.internal.s.a(lockFreeLinkedListNodeC, list); lockFreeLinkedListNodeC = lockFreeLinkedListNodeC.C()) {
            if (lockFreeLinkedListNodeC instanceof i1) {
                m1 m1Var = (m1) lockFreeLinkedListNodeC;
                try {
                    m1Var.Q(cause);
                } catch (Throwable th) {
                    if (completionHandlerException2 == null) {
                        completionHandlerException = null;
                    } else {
                        kotlin.b.a(completionHandlerException2, th);
                        completionHandlerException = completionHandlerException2;
                    }
                    if (completionHandlerException == null) {
                        completionHandlerException2 = new CompletionHandlerException("Exception in completion handler " + m1Var + " for " + this, th);
                    }
                }
            }
        }
        if (completionHandlerException2 != null) {
            h0(completionHandlerException2);
        }
        R(cause);
    }

    private final void s0(r1 r1Var, Throwable th) throws Throwable {
        CompletionHandlerException completionHandlerException;
        CompletionHandlerException completionHandlerException2 = null;
        for (LockFreeLinkedListNode lockFreeLinkedListNodeC = (LockFreeLinkedListNode) r1Var.B(); !kotlin.jvm.internal.s.a(lockFreeLinkedListNodeC, r1Var); lockFreeLinkedListNodeC = lockFreeLinkedListNodeC.C()) {
            if (lockFreeLinkedListNodeC instanceof m1) {
                m1 m1Var = (m1) lockFreeLinkedListNodeC;
                try {
                    m1Var.Q(th);
                } catch (Throwable th2) {
                    if (completionHandlerException2 == null) {
                        completionHandlerException = null;
                    } else {
                        kotlin.b.a(completionHandlerException2, th2);
                        completionHandlerException = completionHandlerException2;
                    }
                    if (completionHandlerException == null) {
                        completionHandlerException2 = new CompletionHandlerException("Exception in completion handler " + m1Var + " for " + this, th2);
                    }
                }
            }
        }
        if (completionHandlerException2 == null) {
            return;
        }
        h0(completionHandlerException2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [kotlinx.coroutines.a1] */
    private final void w0(t0 state) {
        r1 r1Var = new r1();
        if (!state.getIsActive()) {
            r1Var = new a1(r1Var);
        }
        kotlin.i.a(f3867e, this, state, r1Var);
    }

    private final void x0(m1 state) {
        state.x(new r1());
        kotlin.i.a(f3867e, this, state, state.C());
    }

    @Override // kotlinx.coroutines.s
    public final void A(@NotNull u1 parentJob) throws Throwable {
        O(parentJob);
    }

    @NotNull
    protected final CancellationException C0(@NotNull Throwable th, @Nullable String str) {
        CancellationException jobCancellationException = th instanceof CancellationException ? (CancellationException) th : null;
        if (jobCancellationException == null) {
            if (str == null) {
                str = S();
            }
            jobCancellationException = new JobCancellationException(str, th, this);
        }
        return jobCancellationException;
    }

    @InternalCoroutinesApi
    @NotNull
    public final String E0() {
        return p0() + '{' + B0(f0()) + '}';
    }

    @Override // kotlinx.coroutines.h1
    @NotNull
    public final q F(@NotNull s child) {
        return (q) h1.a.c(this, true, false, new r(child), 2, null);
    }

    protected void M(@Nullable Object state) {
    }

    public final boolean N(@Nullable Throwable cause) {
        return O(cause);
    }

    public final boolean O(@Nullable Object cause) throws Throwable {
        Object objM0 = o1.f3877a;
        if (c0() && (objM0 = Q(cause)) == o1.f3878b) {
            return true;
        }
        if (objM0 == o1.f3877a) {
            objM0 = m0(cause);
        }
        if (objM0 == o1.f3877a || objM0 == o1.f3878b) {
            return true;
        }
        if (objM0 == o1.f3880d) {
            return false;
        }
        M(objM0);
        return true;
    }

    public void P(@NotNull Throwable cause) throws Throwable {
        O(cause);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public String S() {
        return "Job was cancelled";
    }

    public boolean T(@NotNull Throwable cause) {
        if (cause instanceof CancellationException) {
            return true;
        }
        return O(cause) && getHandlesException();
    }

    @Override // kotlinx.coroutines.h1, kotlinx.coroutines.channels.ReceiveChannel
    public void a(@Nullable CancellationException cause) throws Throwable {
        if (cause == null) {
            cause = new JobCancellationException(S(), null, this);
        }
        P(cause);
    }

    /* renamed from: b0 */
    public boolean getHandlesException() {
        return true;
    }

    public boolean c0() {
        return false;
    }

    @Nullable
    public final q e0() {
        return (q) this._parentHandle;
    }

    @Nullable
    public final Object f0() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof kotlinx.coroutines.internal.w)) {
                return obj;
            }
            ((kotlinx.coroutines.internal.w) obj).c(this);
        }
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r2, @NotNull p0.p<? super R, ? super CoroutineContext.a, ? extends R> pVar) {
        return (R) h1.a.a(this, r2, pVar);
    }

    protected boolean g0(@NotNull Throwable exception) {
        return false;
    }

    @Override // kotlin.coroutines.CoroutineContext.a, kotlin.coroutines.CoroutineContext
    @Nullable
    public <E extends CoroutineContext.a> E get(@NotNull CoroutineContext.b<E> bVar) {
        return (E) h1.a.b(this, bVar);
    }

    @Override // kotlin.coroutines.CoroutineContext.a
    @NotNull
    public final CoroutineContext.b<?> getKey() {
        return h1.INSTANCE;
    }

    @Override // kotlinx.coroutines.h1
    @NotNull
    public final q0 i(@NotNull p0.l<? super Throwable, kotlin.t> handler) {
        return u(false, true, handler);
    }

    protected final void i0(@Nullable h1 parent) {
        if (parent == null) {
            z0(s1.f3893e);
            return;
        }
        parent.start();
        q qVarF = parent.F(this);
        z0(qVarF);
        if (w()) {
            qVarF.a();
            z0(s1.f3893e);
        }
    }

    @Override // kotlinx.coroutines.h1
    public boolean isActive() {
        Object objF0 = f0();
        return (objF0 instanceof b1) && ((b1) objF0).getIsActive();
    }

    @Override // kotlinx.coroutines.h1
    public final boolean isCancelled() {
        Object objF0 = f0();
        return (objF0 instanceof w) || ((objF0 instanceof b) && ((b) objF0).e());
    }

    protected boolean j0() {
        return false;
    }

    @Override // kotlinx.coroutines.h1
    @Nullable
    public final Object m(@NotNull kotlin.coroutines.c<? super kotlin.t> cVar) {
        if (k0()) {
            Object objL0 = l0(cVar);
            return objL0 == kotlin.coroutines.intrinsics.b.d() ? objL0 : kotlin.t.f3507a;
        }
        k1.e(cVar.getContext());
        return kotlin.t.f3507a;
    }

    @Override // kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext minusKey(@NotNull CoroutineContext.b<?> bVar) {
        return h1.a.d(this, bVar);
    }

    @Nullable
    public final Object n0(@Nullable Object proposedUpdate) {
        Object objH0;
        do {
            objH0 = H0(f0(), proposedUpdate);
            if (objH0 == o1.f3877a) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + proposedUpdate, Z(proposedUpdate));
            }
        } while (objH0 == o1.f3879c);
        return objH0;
    }

    @NotNull
    public String p0() {
        return i0.a(this);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext plus(@NotNull CoroutineContext coroutineContext) {
        return h1.a.e(this, coroutineContext);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Throwable] */
    @Override // kotlinx.coroutines.u1
    @NotNull
    public CancellationException r() {
        CancellationException cancellationExceptionD;
        Object objF0 = f0();
        if (objF0 instanceof b) {
            cancellationExceptionD = ((b) objF0).d();
        } else if (objF0 instanceof w) {
            cancellationExceptionD = ((w) objF0).cause;
        } else {
            if (objF0 instanceof b1) {
                throw new IllegalStateException(kotlin.jvm.internal.s.m("Cannot be cancelling child in this state: ", objF0).toString());
            }
            cancellationExceptionD = null;
        }
        CancellationException cancellationException = cancellationExceptionD instanceof CancellationException ? cancellationExceptionD : null;
        return cancellationException == null ? new JobCancellationException(kotlin.jvm.internal.s.m("Parent job is ", B0(objF0)), cancellationExceptionD, this) : cancellationException;
    }

    @Override // kotlinx.coroutines.h1
    public final boolean start() {
        int iA0;
        do {
            iA0 = A0(f0());
            if (iA0 == 0) {
                return false;
            }
        } while (iA0 != 1);
        return true;
    }

    @Override // kotlinx.coroutines.h1
    @NotNull
    public final CancellationException t() {
        Object objF0 = f0();
        if (!(objF0 instanceof b)) {
            if (objF0 instanceof b1) {
                throw new IllegalStateException(kotlin.jvm.internal.s.m("Job is still new or active: ", this).toString());
            }
            return objF0 instanceof w ? D0(this, ((w) objF0).cause, null, 1, null) : new JobCancellationException(kotlin.jvm.internal.s.m(i0.a(this), " has completed normally"), null, this);
        }
        Throwable thD = ((b) objF0).d();
        CancellationException cancellationExceptionC0 = thD != null ? C0(thD, kotlin.jvm.internal.s.m(i0.a(this), " is cancelling")) : null;
        if (cancellationExceptionC0 != null) {
            return cancellationExceptionC0;
        }
        throw new IllegalStateException(kotlin.jvm.internal.s.m("Job is still new or active: ", this).toString());
    }

    protected void t0(@Nullable Throwable cause) {
    }

    @NotNull
    public String toString() {
        return E0() + '@' + i0.b(this);
    }

    @Override // kotlinx.coroutines.h1
    @NotNull
    public final q0 u(boolean onCancelling, boolean invokeImmediately, @NotNull p0.l<? super Throwable, kotlin.t> handler) {
        m1 m1VarO0 = o0(handler, onCancelling);
        while (true) {
            Object objF0 = f0();
            if (objF0 instanceof t0) {
                t0 t0Var = (t0) objF0;
                if (!t0Var.getIsActive()) {
                    w0(t0Var);
                } else if (kotlin.i.a(f3867e, this, objF0, m1VarO0)) {
                    return m1VarO0;
                }
            } else {
                if (!(objF0 instanceof b1)) {
                    if (invokeImmediately) {
                        w wVar = objF0 instanceof w ? (w) objF0 : null;
                        handler.invoke(wVar != null ? wVar.cause : null);
                    }
                    return s1.f3893e;
                }
                r1 list = ((b1) objF0).getList();
                if (list != null) {
                    q0 q0Var = s1.f3893e;
                    if (onCancelling && (objF0 instanceof b)) {
                        synchronized (objF0) {
                            thD = ((b) objF0).d();
                            if (thD == null || ((handler instanceof r) && !((b) objF0).f())) {
                                if (K(objF0, list, m1VarO0)) {
                                    if (thD == null) {
                                        return m1VarO0;
                                    }
                                    q0Var = m1VarO0;
                                }
                            }
                            kotlin.t tVar = kotlin.t.f3507a;
                        }
                    }
                    if (thD != null) {
                        if (invokeImmediately) {
                            handler.invoke(thD);
                        }
                        return q0Var;
                    }
                    if (K(objF0, list, m1VarO0)) {
                        return m1VarO0;
                    }
                } else {
                    if (objF0 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    }
                    x0((m1) objF0);
                }
            }
        }
    }

    protected void u0(@Nullable Object state) {
    }

    protected void v0() {
    }

    @Override // kotlinx.coroutines.h1
    public final boolean w() {
        return !(f0() instanceof b1);
    }

    public final void y0(@NotNull m1 node) {
        Object objF0;
        do {
            objF0 = f0();
            if (!(objF0 instanceof m1)) {
                if (!(objF0 instanceof b1) || ((b1) objF0).getList() == null) {
                    return;
                }
                node.L();
                return;
            }
            if (objF0 != node) {
                return;
            }
        } while (!kotlin.i.a(f3867e, this, objF0, o1.f3883g));
    }

    public final void z0(@Nullable q qVar) {
        this._parentHandle = qVar;
    }

    public void h0(@NotNull Throwable exception) throws Throwable {
        throw exception;
    }
}
