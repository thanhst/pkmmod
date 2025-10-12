package kotlin.collections;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: AbstractMap.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010&\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0006\b\u0001\u0010\u0003 \u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "K", "V", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
final class AbstractMap$toString$1 extends Lambda implements p0.l<Map.Entry<Object, Object>, CharSequence> {
    final /* synthetic */ c<Object, Object> this$0;

    AbstractMap$toString$1(c<Object, Object> cVar) {
        super(1);
    }

    @Override // p0.l
    @NotNull
    public final CharSequence invoke(@NotNull Map.Entry<Object, Object> it) {
        kotlin.jvm.internal.s.e(it, "it");
        return c.a(null, it);
    }
}
