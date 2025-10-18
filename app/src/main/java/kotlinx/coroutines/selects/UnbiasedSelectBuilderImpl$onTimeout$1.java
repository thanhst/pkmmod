package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.jvm.internal.Lambda;
import kotlin.t;
import p0.a_p0;
import p0.l_p0;

/* compiled from: SelectUnbiased.kt */
@Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0000 \u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"R", "Lkotlin/t;", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 6, 0})
/* loaded from: classes.dex */
final class UnbiasedSelectBuilderImpl$onTimeout$1 extends Lambda implements a_p0<t> {
    final /* synthetic */ l_p0<c<Object>, Object> $block;
    final /* synthetic */ long $timeMillis;
    final /* synthetic */ i<Object> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    UnbiasedSelectBuilderImpl$onTimeout$1(i<Object> iVar, long j2, l_p0<? super c<Object>, ? extends Object> lP0Var) {
        super(0);
        this.$timeMillis = j2;
        this.$block = lP0Var;
    }

    @Override // p0.a
    public /* bridge */ /* synthetic */ t invoke() {
        invoke2();
        return t.f3507a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        throw null;
    }
}
