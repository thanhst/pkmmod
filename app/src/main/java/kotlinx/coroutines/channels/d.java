package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import org.jetbrains.annotations.NotNull;

/* compiled from: BroadcastChannel.kt */
@ObsoleteCoroutinesApi
@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H&¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/channels/d;", "E", "Lkotlinx/coroutines/channels/s;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "k", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public interface d<E> extends s<E> {
    @NotNull
    ReceiveChannel<E> k();
}
