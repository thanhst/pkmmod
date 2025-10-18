package kotlin.collections.unsigned;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.o;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import p0.a_p0;

/* compiled from: _UArrays.kt */
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Lkotlin/o;", "invoke", "()Ljava/util/Iterator;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes.dex */
final class UArraysKt___UArraysKt$withIndex$2 extends Lambda implements a_p0<Iterator<? extends o>> {
    final /* synthetic */ long[] $this_withIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UArraysKt___UArraysKt$withIndex$2(long[] jArr) {
        super(0);
        this.$this_withIndex = jArr;
    }

    @Override // p0.a
    @NotNull
    public final Iterator<? extends o> invoke() {
        return p.a(this.$this_withIndex);
    }
}
