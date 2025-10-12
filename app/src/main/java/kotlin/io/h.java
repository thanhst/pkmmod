package kotlin.io;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Utils.kt */
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¨\u0006\u0003"}, d2 = {"Ljava/io/File;", "", "c", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/io/FilesKt")
/* loaded from: classes.dex */
public class h extends g {
    public static boolean c(@NotNull File file) {
        s.e(file, "<this>");
        while (true) {
            boolean z2 = true;
            for (File file2 : g.b(file)) {
                if (!file2.delete() && file2.exists()) {
                    z2 = false;
                } else {
                    if (z2) {
                        break;
                    }
                    z2 = false;
                }
            }
            return z2;
        }
    }
}
