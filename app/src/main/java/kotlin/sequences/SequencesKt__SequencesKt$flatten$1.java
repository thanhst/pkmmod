package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import p0.l_p0;

import org.jetbrains.annotations.NotNull;

/* compiled from: Sequences.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\b\u0003\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "Lkotlin/sequences/d;", "it", "", "invoke", "(Lkotlin/sequences/d;)Ljava/util/Iterator;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes.dex */
final class SequencesKt__SequencesKt$flatten$1 extends Lambda implements l_p0<d<Object>, Iterator<Object>> {
    public static final SequencesKt__SequencesKt$flatten$1 INSTANCE = new SequencesKt__SequencesKt$flatten$1();

    SequencesKt__SequencesKt$flatten$1() {
        super(1);
    }

    @Override // p0.l
    @NotNull
    public final Iterator<Object> invoke(@NotNull d<Object> it) {
        s.e(it, "it");
        return it.iterator();
    }
}
