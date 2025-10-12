package com.facebook.bolts;

import com.facebook.internal.NativeProtocol;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.x;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CancellationToken.kt */
@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0011\u0010\u000e\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/facebook/bolts/CancellationToken;", "", "Ljava/lang/Runnable;", NativeProtocol.WEB_DIALOG_ACTION, "Lcom/facebook/bolts/CancellationTokenRegistration;", "register", "Lkotlin/t;", "throwIfCancellationRequested", "", "toString", "Lcom/facebook/bolts/CancellationTokenSource;", "tokenSource", "Lcom/facebook/bolts/CancellationTokenSource;", "", "isCancellationRequested", "()Z", "<init>", "(Lcom/facebook/bolts/CancellationTokenSource;)V", "facebook-bolts_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class CancellationToken {

    @NotNull
    private final CancellationTokenSource tokenSource;

    public CancellationToken(@NotNull CancellationTokenSource tokenSource) {
        s.e(tokenSource, "tokenSource");
        this.tokenSource = tokenSource;
    }

    public final boolean isCancellationRequested() {
        return this.tokenSource.isCancellationRequested();
    }

    @NotNull
    public final CancellationTokenRegistration register(@Nullable Runnable action) {
        return this.tokenSource.register$facebook_bolts_release(action);
    }

    public final void throwIfCancellationRequested() throws CancellationException {
        this.tokenSource.throwIfCancellationRequested$facebook_bolts_release();
    }

    @NotNull
    public String toString() {
        x xVar = x.f3460a;
        String str = String.format(Locale.US, "%s@%s[cancellationRequested=%s]", Arrays.copyOf(new Object[]{CancellationToken.class.getName(), Integer.toHexString(hashCode()), Boolean.toString(this.tokenSource.isCancellationRequested())}, 3));
        s.d(str, "java.lang.String.format(locale, format, *args)");
        return str;
    }
}
