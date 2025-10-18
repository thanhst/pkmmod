package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.t;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.n1;
import p0.l_p0;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChannelCoroutine.kt */
@Metadata(bv = {}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u0004B-\u0012\u0006\u0010)\u001a\u00020(\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010*\u001a\u00020\u0007\u0012\u0006\u0010+\u001a\u00020\u0007¢\u0006\u0004\b,\u0010-J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0001J.\u0010\r\u001a\u00020\u00032#\u0010\f\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00030\tH\u0097\u0001J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0096\u0003J\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0096Aø\u0001\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00028\u0000H\u0096Aø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0096\u0001ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u001a\u001a\u00020\u00032\u000e\u0010\u0006\u001a\n\u0018\u00010\u0018j\u0004\u0018\u0001`\u0019J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R \u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000 8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b!\u0010\"R#\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00100 8\u0016X\u0096\u0005ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b$\u0010\"R\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048F¢\u0006\u0006\u001a\u0004\b&\u0010\u001e\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006."}, d2 = {"Lkotlinx/coroutines/channels/f;", "E", "Lkotlinx/coroutines/a;", "Lkotlin/t;", "Lkotlinx/coroutines/channels/e;", "", "cause", "", "g", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "handler", "x", "Lkotlinx/coroutines/channels/ChannelIterator;", "iterator", "Lkotlinx/coroutines/channels/h;", "z", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "element", "y", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "v", "()Ljava/lang/Object;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "a", "P", "Lkotlinx/coroutines/channels/e;", "P0", "()Lkotlinx/coroutines/channels/e;", "_channel", "Lkotlinx/coroutines/selects/d;", "n", "()Lkotlinx/coroutines/selects/d;", "onReceive", "q", "onReceiveCatching", "O0", "channel", "Lkotlin/coroutines/CoroutineContext;", "parentContext", "initParentJob", "active", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/e;ZZ)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public class f<E> extends kotlinx.coroutines.a<kotlin.t> implements e<E> {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e<E> _channel;

    public f(@NotNull CoroutineContext coroutineContext, @NotNull e<E> eVar, boolean z2, boolean z3) {
        super(coroutineContext, z2, z3);
        this._channel = eVar;
    }

    @NotNull
    public final e<E> O0() {
        return this;
    }

    @Override // kotlinx.coroutines.n1
    public void P(@NotNull Throwable th) {
        CancellationException cancellationExceptionD0 = n1.D0(this, th, null, 1, null);
        this._channel.a(cancellationExceptionD0);
        N(cancellationExceptionD0);
    }

    @NotNull
    protected final e<E> P0() {
        return this._channel;
    }

    @Override // kotlinx.coroutines.n1, kotlinx.coroutines.h1, kotlinx.coroutines.channels.ReceiveChannel
    public final void a(@Nullable CancellationException cancellationException) {
        if (isCancelled()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(S(), null, this);
        }
        P(cancellationException);
    }

    @Override // kotlinx.coroutines.channels.s
    public boolean g(@Nullable Throwable cause) {
        return this._channel.g(cause);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public ChannelIterator<E> iterator() {
        return this._channel.iterator();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public kotlinx.coroutines.selects.d<E> n() {
        return this._channel.n();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public kotlinx.coroutines.selects.d<h<E>> q() {
        return this._channel.q();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public Object v() {
        return this._channel.v();
    }

    @Override // kotlinx.coroutines.channels.s
    @ExperimentalCoroutinesApi
    public void x(@NotNull l_p0<? super Throwable, t> lP0Var) {
        this._channel.x(lP0Var);
    }

    @Override // kotlinx.coroutines.channels.s
    @Nullable
    public Object y(E e2, @NotNull kotlin.coroutines.c<? super kotlin.t> cVar) {
        return this._channel.y(e2, cVar);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Nullable
    public Object z(@NotNull kotlin.coroutines.c<? super h<? extends E>> cVar) {
        Object objZ = this._channel.z(cVar);
        kotlin.coroutines.intrinsics.b.d();
        return objZ;
    }
}
