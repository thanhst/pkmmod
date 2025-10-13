package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.t;
import p0.l_p0;

import org.jetbrains.annotations.Nullable;

/* compiled from: Deprecated.kt */
@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "cause", "Lkotlin/t;", "invoke", "(Ljava/lang/Throwable;)V", "<anonymous>"}, k = 3, mv = {1, 6, 0})
/* loaded from: classes.dex */
final class ChannelsKt__DeprecatedKt$consumesAll$1 extends Lambda implements l_p0<Throwable, t> {
    final /* synthetic */ ReceiveChannel<?>[] $channels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ChannelsKt__DeprecatedKt$consumesAll$1(ReceiveChannel<?>[] receiveChannelArr) {
        super(1);
        this.$channels = receiveChannelArr;
    }

    @Override // p0.l
    public /* bridge */ /* synthetic */ kotlin.t invoke(Throwable th) throws Throwable {
        invoke2(th);
        return kotlin.t.f3507a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable Throwable th) throws Throwable {
        ReceiveChannel<?>[] receiveChannelArr = this.$channels;
        int length = receiveChannelArr.length;
        Throwable th2 = null;
        int i2 = 0;
        while (i2 < length) {
            ReceiveChannel<?> receiveChannel = receiveChannelArr[i2];
            i2++;
            try {
                i.b(receiveChannel, th);
            } catch (Throwable th3) {
                if (th2 == null) {
                    th2 = th3;
                } else {
                    kotlin.b.a(th2, th3);
                }
            }
        }
        if (th2 != null) {
            throw th2;
        }
    }
}
