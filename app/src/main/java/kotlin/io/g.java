package kotlin.io;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FileTreeWalk.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001\u001a\n\u0010\u0005\u001a\u00020\u0003*\u00020\u0000¨\u0006\u0006"}, d2 = {"Ljava/io/File;", "Lkotlin/io/FileWalkDirection;", "direction", "Lkotlin/io/c;", "a", "b", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/io/FilesKt")
/* loaded from: classes.dex */
class g extends f {
    @NotNull
    public static final c a(@NotNull File file, @NotNull FileWalkDirection direction) {
        s.e(file, "<this>");
        s.e(direction, "direction");
        return new c(file, direction);
    }

    @NotNull
    public static final c b(@NotNull File file) {
        s.e(file, "<this>");
        return a(file, FileWalkDirection.BOTTOM_UP);
    }
}
