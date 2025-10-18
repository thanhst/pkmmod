package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.s;
import p0.l_p0;

import org.jetbrains.annotations.NotNull;

/* compiled from: _Sequences.kt */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
final /* synthetic */ class SequencesKt___SequencesKt$flatMap$1 extends FunctionReferenceImpl implements l_p0<Iterable<Object>, Iterator<Object>> {
    public static final SequencesKt___SequencesKt$flatMap$1 INSTANCE = new SequencesKt___SequencesKt$flatMap$1();

    SequencesKt___SequencesKt$flatMap$1() {
        super(1, Iterable.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
    }

    @Override // p0.l
    @NotNull
    public final Iterator<Object> invoke(@NotNull Iterable<Object> p02) {
        s.e(p02, "p0");
        return p02.iterator();
    }
}
