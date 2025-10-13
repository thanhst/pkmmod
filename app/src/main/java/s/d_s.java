package s;

import kotlin.Metadata;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CreationExtras.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0001¢\u0006\u0004\b\f\u0010\rJ,\u0010\u0007\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0005\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u0007\u0010\bJ&\u0010\t\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002¢\u0006\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Ls/d;", "Ls/a;", "T", "Ls/a$b;", "key", "t", "Lkotlin/t;", "c", "(Ls/a$b;Ljava/lang/Object;)V", "a", "(Ls/a$b;)Ljava/lang/Object;", "initialExtras", "<init>", "(Ls/a;)V", "lifecycle-viewmodel_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class d_s extends a_s {
    public d_s() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public d_s(@NotNull a_s initialExtras) {
        s.e(initialExtras, "initialExtras");
        b().putAll(initialExtras.b());
    }

    @Override // s.a
    @Nullable
    public <T> T a(@NotNull a_s.b<T> key) {
        s.e(key, "key");
        return (T) b().get(key);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> void c(@NotNull a_s.b<T> key, T t2) {
        s.e(key, "key");
        b().put(key, t2);
    }

    public /* synthetic */ d_s(a_s aSVar, int i2, o oVar) {
        this((i2 & 1) != 0 ? s.a_s.C0069AS.f4091b : aSVar);
    }
}
