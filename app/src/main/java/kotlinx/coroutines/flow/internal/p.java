package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.t;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.channels.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SendingCollector.kt */
@InternalCoroutinesApi
@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0015\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/flow/internal/p;", "T", "Lkotlinx/coroutines/flow/e;", "value", "Lkotlin/t;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/s;", "e", "Lkotlinx/coroutines/channels/s;", "channel", "<init>", "(Lkotlinx/coroutines/channels/s;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class p<T> implements kotlinx.coroutines.flow.e<T> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final s<T> channel;

    /* JADX WARN: Multi-variable type inference failed */
    public p(@NotNull s<? super T> sVar) {
        this.channel = sVar;
    }

    @Override // kotlinx.coroutines.flow.e
    @Nullable
    public Object emit(T t2, @NotNull kotlin.coroutines.c<? super t> cVar) {
        Object objY = this.channel.y(t2, cVar);
        return objY == kotlin.coroutines.intrinsics.b.d() ? objY : t.f3507a;
    }
}
