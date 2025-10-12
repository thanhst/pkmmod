package kotlin.collections;

import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Collections.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T", "K", "", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Integer;"}, k = 3, mv = {1, 7, 1}, xi = 176)
/* loaded from: classes.dex */
public final class CollectionsKt__CollectionsKt$binarySearchBy$1 extends Lambda implements p0.l<Object, Integer> {
    final /* synthetic */ Comparable<Object> $key;
    final /* synthetic */ p0.l<Object, Comparable<Object>> $selector;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CollectionsKt__CollectionsKt$binarySearchBy$1(p0.l<Object, Comparable<Object>> lVar, Comparable<Object> comparable) {
        super(1);
        this.$selector = lVar;
        this.$key = comparable;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p0.l
    @NotNull
    public final Integer invoke(Object obj) {
        return Integer.valueOf(k0.b.a(this.$selector.invoke(obj), this.$key));
    }
}
