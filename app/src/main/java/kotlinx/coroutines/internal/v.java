package kotlinx.coroutines.internal;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.q0;
import kotlinx.coroutines.q1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MainDispatchers.kt */
@Metadata(bv = {}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b!\u0010\"J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\n\u0010\r\u001a\u00060\u000bj\u0002`\f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001c\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\n\u0010\r\u001a\u00060\u000bj\u0002`\fH\u0016J\u001e\u0010\u0014\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lkotlinx/coroutines/internal/v;", "Lkotlinx/coroutines/q1;", "Lkotlinx/coroutines/l0;", "", "x", "Lkotlin/coroutines/CoroutineContext;", "context", "", "k", "", "timeMillis", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lkotlinx/coroutines/q0;", "c", "v", "Lkotlinx/coroutines/k;", "Lkotlin/t;", "continuation", "y", "", "toString", "", "f", "Ljava/lang/Throwable;", "cause", "g", "Ljava/lang/String;", "errorHint", "q", "()Lkotlinx/coroutines/q1;", "immediate", "<init>", "(Ljava/lang/Throwable;Ljava/lang/String;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
final class v extends q1 implements l0 {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Throwable cause;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String errorHint;

    public v(@Nullable Throwable th, @Nullable String str) {
        this.cause = th;
        this.errorHint = str;
    }

    private final Void x() {
        String strM;
        if (this.cause == null) {
            u.d();
            throw new KotlinNothingValueException();
        }
        String str = this.errorHint;
        String str2 = "";
        if (str != null && (strM = kotlin.jvm.internal.s.m(". ", str)) != null) {
            str2 = strM;
        }
        throw new IllegalStateException(kotlin.jvm.internal.s.m("Module with the Main dispatcher had failed to initialize", str2), this.cause);
    }

    @Override // kotlinx.coroutines.l0
    @NotNull
    public q0 c(long timeMillis, @NotNull Runnable block, @NotNull CoroutineContext context) {
        x();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean k(@NotNull CoroutineContext context) {
        x();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.q1
    @NotNull
    public q1 q() {
        return this;
    }

    @Override // kotlinx.coroutines.q1, kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Dispatchers.Main[missing");
        Throwable th = this.cause;
        sb.append(th != null ? kotlin.jvm.internal.s.m(", cause=", th) : "");
        sb.append(']');
        return sb.toString();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public Void g(@NotNull CoroutineContext context, @NotNull Runnable block) {
        x();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.l0
    @NotNull
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public Void e(long timeMillis, @NotNull kotlinx.coroutines.k<? super kotlin.t> continuation) {
        x();
        throw new KotlinNothingValueException();
    }
}
