package m0;

import kotlin.Metadata;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: JDK7PlatformImplementations.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lm0/a;", "Ll0/a;", "", "cause", "exception", "Lkotlin/t;", "a", "<init>", "()V", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public class a extends l0.a {
    @Override // l0.a
    public void a(@NotNull Throwable cause, @NotNull Throwable exception) {
        s.e(cause, "cause");
        s.e(exception, "exception");
        cause.addSuppressed(exception);
    }
}
