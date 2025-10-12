package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.SinceKotlin;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.s;
import kotlin.t;
import org.jetbrains.annotations.NotNull;
import p0.l;
import p0.p;

/* compiled from: Continuation.kt */
@Metadata(bv = {}, d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a@\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001aY\u0010\f\u001a\u00020\u0005\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u0000*#\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t¢\u0006\u0002\b\n2\u0006\u0010\u000b\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"T", "Lkotlin/Function1;", "Lkotlin/coroutines/c;", "", "completion", "Lkotlin/t;", "a", "(Lp0/l;Lkotlin/coroutines/c;)V", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "receiver", "b", "(Lp0/p;Ljava/lang/Object;Lkotlin/coroutines/c;)V", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes.dex */
public final class e {
    @SinceKotlin(version = "1.3")
    public static final <T> void a(@NotNull l<? super c<? super T>, ? extends Object> lVar, @NotNull c<? super T> completion) {
        s.e(lVar, "<this>");
        s.e(completion, "completion");
        c cVarC = IntrinsicsKt__IntrinsicsJvmKt.c(IntrinsicsKt__IntrinsicsJvmKt.a(lVar, completion));
        Result.Companion companion = Result.INSTANCE;
        cVarC.resumeWith(Result.m158constructorimpl(t.f3507a));
    }

    @SinceKotlin(version = "1.3")
    public static final <R, T> void b(@NotNull p<? super R, ? super c<? super T>, ? extends Object> pVar, R r2, @NotNull c<? super T> completion) {
        s.e(pVar, "<this>");
        s.e(completion, "completion");
        c cVarC = IntrinsicsKt__IntrinsicsJvmKt.c(IntrinsicsKt__IntrinsicsJvmKt.b(pVar, r2, completion));
        Result.Companion companion = Result.INSTANCE;
        cVarC.resumeWith(Result.m158constructorimpl(t.f3507a));
    }
}
