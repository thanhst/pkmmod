package kotlin.io;

import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.t;
import org.jetbrains.annotations.NotNull;
import p0.p;

/* compiled from: Utils.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Ljava/io/File;", "f", "Ljava/io/IOException;", "e", "Lkotlin/t;", "invoke", "(Ljava/io/File;Ljava/io/IOException;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes.dex */
final class FilesKt__UtilsKt$copyRecursively$2 extends Lambda implements p<File, IOException, t> {
    final /* synthetic */ p<File, IOException, OnErrorAction> $onError;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    FilesKt__UtilsKt$copyRecursively$2(p<? super File, ? super IOException, ? extends OnErrorAction> pVar) {
        super(2);
        this.$onError = pVar;
    }

    @Override // p0.p
    public /* bridge */ /* synthetic */ t invoke(File file, IOException iOException) throws TerminateException {
        invoke2(file, iOException);
        return t.f3507a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull File f2, @NotNull IOException e2) throws TerminateException {
        s.e(f2, "f");
        s.e(e2, "e");
        if (this.$onError.invoke(f2, e2) == OnErrorAction.TERMINATE) {
            throw new TerminateException(f2);
        }
    }
}
