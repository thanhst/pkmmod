package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;

/* compiled from: boxing.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0001\u001a\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u0004H\u0001¨\u0006\u0007"}, d2 = {"", "primitive", "Ljava/lang/Boolean;", "a", "", "Ljava/lang/Integer;", "b", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1})
@JvmName(name = "Boxing")
/* loaded from: classes.dex */
public final class a {
    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static final Boolean a(boolean z2) {
        return Boolean.valueOf(z2);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static final Integer b(int i2) {
        return new Integer(i2);
    }
}
