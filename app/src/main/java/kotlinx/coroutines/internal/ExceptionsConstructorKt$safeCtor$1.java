package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ExceptionsConstructor.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "e", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ExceptionsConstructorKt$safeCtor$1 extends Lambda implements p0.l<Throwable, Throwable> {
    final /* synthetic */ p0.l<Throwable, Throwable> $block;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ExceptionsConstructorKt$safeCtor$1(p0.l<? super Throwable, ? extends Throwable> lVar) {
        super(1);
        this.$block = lVar;
    }

    @Override // p0.l
    @Nullable
    public final Throwable invoke(@NotNull Throwable th) {
        Object objM158constructorimpl;
        p0.l<Throwable, Throwable> lVar = this.$block;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM158constructorimpl = Result.m158constructorimpl(lVar.invoke(th));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            objM158constructorimpl = Result.m158constructorimpl(kotlin.h.a(th2));
        }
        if (Result.m164isFailureimpl(objM158constructorimpl)) {
            objM158constructorimpl = null;
        }
        return (Throwable) objM158constructorimpl;
    }
}
