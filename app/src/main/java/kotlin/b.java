package kotlin;

import java.io.PrintWriter;
import java.io.StringWriter;
import kotlin.internal.HidesMembers;
import l0.b_l0;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Exceptions.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0010\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007\u001a\u0014\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0007¨\u0006\u0006"}, d2 = {"", "", "b", "exception", "Lkotlin/t;", "a", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/ExceptionsKt")
/* loaded from: classes.dex */
public class b {
    @SinceKotlin(version = "1.1")
    @HidesMembers
    public static void a(@NotNull Throwable th, @NotNull Throwable exception) {
        kotlin.jvm.internal.s.e(th, "<this>");
        kotlin.jvm.internal.s.e(exception, "exception");
        if (th != exception) {
            b_l0.F_4023_AL_0.a(th, exception);
        }
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    public static String b(@NotNull Throwable th) {
        kotlin.jvm.internal.s.e(th, "<this>");
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        String string = stringWriter.toString();
        kotlin.jvm.internal.s.d(string, "sw.toString()");
        return string;
    }
}
