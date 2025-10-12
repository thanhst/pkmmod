package kotlinx.coroutines.channels;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.PublishedApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {}, d1 = {"kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt", "kotlinx/coroutines/channels/ChannelsKt__DeprecatedKt"}, d2 = {}, k = 4, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class i {
    @PublishedApi
    public static final void b(@NotNull ReceiveChannel<?> receiveChannel, @Nullable Throwable th) {
        ChannelsKt__Channels_commonKt.a(receiveChannel, th);
    }

    @PublishedApi
    @Nullable
    public static final <E, C extends s<? super E>> Object s(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull C c2, @NotNull kotlin.coroutines.c<? super C> cVar) {
        return ChannelsKt__DeprecatedKt.r(receiveChannel, c2, cVar);
    }

    @PublishedApi
    @Nullable
    public static final <E, C extends Collection<? super E>> Object t(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull C c2, @NotNull kotlin.coroutines.c<? super C> cVar) {
        return ChannelsKt__DeprecatedKt.s(receiveChannel, c2, cVar);
    }

    @Nullable
    public static final <E> Object u(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull kotlin.coroutines.c<? super List<? extends E>> cVar) {
        return ChannelsKt__Channels_commonKt.d(receiveChannel, cVar);
    }

    @PublishedApi
    @Nullable
    public static final <K, V, M extends Map<? super K, ? super V>> Object v(@NotNull ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel, @NotNull M m2, @NotNull kotlin.coroutines.c<? super M> cVar) {
        return ChannelsKt__DeprecatedKt.t(receiveChannel, m2, cVar);
    }
}
