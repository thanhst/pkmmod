package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlinx.coroutines.internal.d0;
import org.jetbrains.annotations.NotNull;

/* compiled from: Select.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\" \u0010\u0007\u001a\u00020\u00008\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0001\u0010\u0002\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004\" \u0010\u000b\u001a\u00020\u00008\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u0002\u0012\u0004\b\n\u0010\u0006\u001a\u0004\b\t\u0010\u0004\"\u001a\u0010\u000e\u001a\u00020\u00008\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\f\u0010\u0002\u0012\u0004\b\r\u0010\u0006\"\u001a\u0010\u0010\u001a\u00020\u00008\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\t\u0010\u0002\u0012\u0004\b\u000f\u0010\u0006\"\u001a\u0010\u0014\u001a\u00020\u00118\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u0012\u0004\b\u0013\u0010\u0006¨\u0006\u0015"}, d2 = {"", "a", "Ljava/lang/Object;", "e", "()Ljava/lang/Object;", "getNOT_SELECTED$annotations", "()V", "NOT_SELECTED", "b", "d", "getALREADY_SELECTED$annotations", "ALREADY_SELECTED", "c", "getUNDECIDED$annotations", "UNDECIDED", "getRESUMED$annotations", "RESUMED", "Lkotlinx/coroutines/selects/h;", "Lkotlinx/coroutines/selects/h;", "getSelectOpSequenceNumber$annotations", "selectOpSequenceNumber", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final Object f3952a = new d0("NOT_SELECTED");

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Object f3953b = new d0("ALREADY_SELECTED");

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Object f3954c = new d0("UNDECIDED");

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final Object f3955d = new d0("RESUMED");

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final h f3956e = new h();

    @NotNull
    public static final Object d() {
        return f3953b;
    }

    @NotNull
    public static final Object e() {
        return f3952a;
    }
}
