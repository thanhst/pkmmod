package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.internal.d0;
import org.jetbrains.annotations.NotNull;

/* compiled from: AbstractChannel.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u001a\u0010\u0005\u001a\u00020\u00008\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u0012\u0004\b\u0003\u0010\u0004\"\u001a\u0010\b\u001a\u00020\u00008\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0002\u0012\u0004\b\u0007\u0010\u0004\"\u001a\u0010\u000b\u001a\u00020\u00008\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\t\u0010\u0002\u0012\u0004\b\n\u0010\u0004\"\u001a\u0010\u000e\u001a\u00020\u00008\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\f\u0010\u0002\u0012\u0004\b\r\u0010\u0004\"\u001a\u0010\u0011\u001a\u00020\u00008\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0002\u0012\u0004\b\u0010\u0010\u0004\"\u001a\u0010\u0014\u001a\u00020\u00008\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0002\u0012\u0004\b\u0013\u0010\u0004*(\b\u0000\u0010\u0018\"\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0004\u0012\u00020\u00170\u00152\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0004\u0012\u00020\u00170\u0015¨\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/internal/d0;", "a", "Lkotlinx/coroutines/internal/d0;", "getEMPTY$annotations", "()V", "EMPTY", "b", "getOFFER_SUCCESS$annotations", "OFFER_SUCCESS", "c", "getOFFER_FAILED$annotations", "OFFER_FAILED", "d", "getPOLL_FAILED$annotations", "POLL_FAILED", "e", "getENQUEUE_FAILED$annotations", "ENQUEUE_FAILED", "f", "getHANDLER_INVOKED$annotations", "HANDLER_INVOKED", "Lkotlin/Function1;", "", "Lkotlin/t;", "Handler", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final d0 f3575a = new d0("EMPTY");

    /* renamed from: b, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final d0 f3576b = new d0("OFFER_SUCCESS");

    /* renamed from: c, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final d0 f3577c = new d0("OFFER_FAILED");

    /* renamed from: d, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final d0 f3578d = new d0("POLL_FAILED");

    /* renamed from: e, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final d0 f3579e = new d0("ENQUEUE_FAILED");

    /* renamed from: f, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final d0 f3580f = new d0("ON_CLOSE_HANDLER_INVOKED");
}
