package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.coroutines.c;
import kotlin.t;
import kotlinx.coroutines.flow.e;
import p0.a_p0;
import p0.q_p0;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Combine.kt */
@Metadata(bv = {}, d1 = {"\u00008\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0092\u0001\u0010\u000e\u001a\u00020\n\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0014\u0010\u0005\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u00032\u0016\u0010\u0007\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0018\u00010\u00030\u000629\u0010\r\u001a5\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b¢\u0006\u0002\b\fH\u0081@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f*\u001c\b\u0002\u0010\u0011\"\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00102\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"R", "T", "Lkotlinx/coroutines/flow/e;", "", "Lkotlinx/coroutines/flow/d;", "flows", "Lkotlin/Function0;", "arrayFactory", "Lkotlin/Function3;", "Lkotlin/coroutines/c;", "Lkotlin/t;", "", "Lkotlin/ExtensionFunctionType;", "transform", "a", "(Lkotlinx/coroutines/flow/e;[Lkotlinx/coroutines/flow/d;Lp0/a;Lp0/q;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/collections/f0;", "Update", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class CombineKt {
    @PublishedApi
    @Nullable
    public static final <R, T> Object a(@NotNull kotlinx.coroutines.flow.e<? super R> eVar, @NotNull kotlinx.coroutines.flow.d<? extends T>[] dVarArr, @NotNull a_p0<T[]> aP0Var, @NotNull q_p0<? super e<? super R>, ? super T[], ? super c<? super t>, ? extends Object> qP0Var, @NotNull kotlin.coroutines.c<? super t> cVar) throws Throwable {
        Object objA = i.a(new CombineKt$combineInternal$2(dVarArr, aP0Var, qP0Var, eVar, null), cVar);
        return objA == kotlin.coroutines.intrinsics.b.d() ? objA : t.f3507a;
    }
}
