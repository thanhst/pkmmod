package kotlinx.coroutines.flow;

import com.facebook.internal.NativeProtocol;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Collect.kt */
@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001b\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0000H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001aV\u0010\f\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u000021\u0010\u000b\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0005H\u0086@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a1\u0010\u0010\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/flow/d;", "Lkotlin/t;", "a", "(Lkotlinx/coroutines/flow/d;Lkotlin/coroutines/c;)Ljava/lang/Object;", "T", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "Lkotlin/coroutines/c;", "", NativeProtocol.WEB_DIALOG_ACTION, "b", "(Lkotlinx/coroutines/flow/d;Lp0/p;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/e;", "flow", "c", "(Lkotlinx/coroutines/flow/e;Lkotlinx/coroutines/flow/d;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes.dex */
final /* synthetic */ class t {
    @Nullable
    public static final Object a(@NotNull d<?> dVar, @NotNull kotlin.coroutines.c<? super kotlin.t> cVar) {
        Object objA = dVar.a(kotlinx.coroutines.flow.internal.m.f3760e, cVar);
        return objA == kotlin.coroutines.intrinsics.b.d() ? objA : kotlin.t.f3507a;
    }

    @Nullable
    public static final <T> Object b(@NotNull d<? extends T> dVar, @NotNull p0.p<? super T, ? super kotlin.coroutines.c<? super kotlin.t>, ? extends Object> pVar, @NotNull kotlin.coroutines.c<? super kotlin.t> cVar) {
        Object objD = f.d(u.b(f.v(dVar, pVar), 0, null, 2, null), cVar);
        return objD == kotlin.coroutines.intrinsics.b.d() ? objD : kotlin.t.f3507a;
    }

    @Nullable
    public static final <T> Object c(@NotNull e<? super T> eVar, @NotNull d<? extends T> dVar, @NotNull kotlin.coroutines.c<? super kotlin.t> cVar) throws Throwable {
        f.k(eVar);
        Object objA = dVar.a(eVar, cVar);
        return objA == kotlin.coroutines.intrinsics.b.d() ? objA : kotlin.t.f3507a;
    }
}
