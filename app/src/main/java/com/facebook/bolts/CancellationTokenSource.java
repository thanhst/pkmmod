package com.facebook.bolts;

import com.facebook.internal.NativeProtocol;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.x;
import kotlin.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CancellationTokenSource.kt */
@Metadata(bv = {}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b3\u0010\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\u000b\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\u0006H\u0002J\u0006\u0010\u000e\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\u0019\u0010\u0014\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0017\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\tH\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u001d\u001a\u00020\u001cH\u0016R\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u001c\u0010'\u001a\b\u0012\u0002\b\u0003\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010+R\u0011\u0010-\u001a\u00020)8F¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0011\u00102\u001a\u00020/8F¢\u0006\u0006\u001a\u0004\b0\u00101¨\u00064"}, d2 = {"Lcom/facebook/bolts/CancellationTokenSource;", "Ljava/io/Closeable;", "", "delay", "Ljava/util/concurrent/TimeUnit;", "timeUnit", "Lkotlin/t;", "cancelAfter", "", "Lcom/facebook/bolts/CancellationTokenRegistration;", "registrations", "notifyListeners", "throwIfClosed", "cancelScheduledCancellation", "cancel", "close", "Ljava/lang/Runnable;", NativeProtocol.WEB_DIALOG_ACTION, "register$facebook_bolts_release", "(Ljava/lang/Runnable;)Lcom/facebook/bolts/CancellationTokenRegistration;", "register", "throwIfCancellationRequested$facebook_bolts_release", "()V", "throwIfCancellationRequested", "registration", "unregister$facebook_bolts_release", "(Lcom/facebook/bolts/CancellationTokenRegistration;)V", "unregister", "", "toString", "", "lock", "Ljava/lang/Object;", "", "Ljava/util/List;", "Ljava/util/concurrent/ScheduledExecutorService;", "executor", "Ljava/util/concurrent/ScheduledExecutorService;", "Ljava/util/concurrent/ScheduledFuture;", "scheduledCancellation", "Ljava/util/concurrent/ScheduledFuture;", "", "cancellationRequested", "Z", "closed", "isCancellationRequested", "()Z", "Lcom/facebook/bolts/CancellationToken;", "getToken", "()Lcom/facebook/bolts/CancellationToken;", "token", "<init>", "facebook-bolts_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class CancellationTokenSource implements Closeable {
    private boolean cancellationRequested;
    private boolean closed;

    @Nullable
    private ScheduledFuture<?> scheduledCancellation;

    @NotNull
    private final Object lock = new Object();

    @NotNull
    private final List<CancellationTokenRegistration> registrations = new ArrayList();

    @NotNull
    private final ScheduledExecutorService executor = BoltsExecutors.INSTANCE.scheduled$facebook_bolts_release();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cancelAfter$lambda-6$lambda-5, reason: not valid java name */
    public static final void m78cancelAfter$lambda6$lambda5(CancellationTokenSource this$0) {
        s.e(this$0, "this$0");
        synchronized (this$0.lock) {
            this$0.scheduledCancellation = null;
            t tVar = t.f3507a;
        }
        this$0.cancel();
    }

    private final void cancelScheduledCancellation() {
        ScheduledFuture<?> scheduledFuture = this.scheduledCancellation;
        if (scheduledFuture == null) {
            return;
        }
        scheduledFuture.cancel(true);
        this.scheduledCancellation = null;
    }

    private final void notifyListeners(List<CancellationTokenRegistration> list) {
        Iterator<CancellationTokenRegistration> it = list.iterator();
        while (it.hasNext()) {
            it.next().runAction$facebook_bolts_release();
        }
    }

    private final void throwIfClosed() {
        if (!(!this.closed)) {
            throw new IllegalStateException("Object already closed".toString());
        }
    }

    public final void cancel() {
        synchronized (this.lock) {
            throwIfClosed();
            if (this.cancellationRequested) {
                return;
            }
            cancelScheduledCancellation();
            this.cancellationRequested = true;
            ArrayList arrayList = new ArrayList(this.registrations);
            t tVar = t.f3507a;
            notifyListeners(arrayList);
        }
    }

    public final void cancelAfter(long j2) {
        cancelAfter(j2, TimeUnit.MILLISECONDS);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.lock) {
            if (this.closed) {
                return;
            }
            cancelScheduledCancellation();
            Iterator<CancellationTokenRegistration> it = this.registrations.iterator();
            while (it.hasNext()) {
                it.next().close();
            }
            this.registrations.clear();
            this.closed = true;
            t tVar = t.f3507a;
        }
    }

    @NotNull
    public final CancellationToken getToken() {
        CancellationToken cancellationToken;
        synchronized (this.lock) {
            throwIfClosed();
            cancellationToken = new CancellationToken(this);
        }
        return cancellationToken;
    }

    public final boolean isCancellationRequested() {
        boolean z2;
        synchronized (this.lock) {
            throwIfClosed();
            z2 = this.cancellationRequested;
        }
        return z2;
    }

    @NotNull
    public final CancellationTokenRegistration register$facebook_bolts_release(@Nullable Runnable action) {
        CancellationTokenRegistration cancellationTokenRegistration;
        synchronized (this.lock) {
            throwIfClosed();
            cancellationTokenRegistration = new CancellationTokenRegistration(this, action);
            if (this.cancellationRequested) {
                cancellationTokenRegistration.runAction$facebook_bolts_release();
                t tVar = t.f3507a;
            } else {
                this.registrations.add(cancellationTokenRegistration);
            }
        }
        return cancellationTokenRegistration;
    }

    public final void throwIfCancellationRequested$facebook_bolts_release() throws CancellationException {
        synchronized (this.lock) {
            throwIfClosed();
            if (this.cancellationRequested) {
                throw new CancellationException();
            }
            t tVar = t.f3507a;
        }
    }

    @NotNull
    public String toString() {
        x xVar = x.f3460a;
        String str = String.format(Locale.US, "%s@%s[cancellationRequested=%s]", Arrays.copyOf(new Object[]{CancellationTokenSource.class.getName(), Integer.toHexString(hashCode()), Boolean.toString(isCancellationRequested())}, 3));
        s.d(str, "java.lang.String.format(locale, format, *args)");
        return str;
    }

    public final void unregister$facebook_bolts_release(@NotNull CancellationTokenRegistration registration) {
        s.e(registration, "registration");
        synchronized (this.lock) {
            throwIfClosed();
            this.registrations.remove(registration);
        }
    }

    private final void cancelAfter(long j2, TimeUnit timeUnit) {
        if (!(j2 >= -1)) {
            throw new IllegalArgumentException("Delay must be >= -1".toString());
        }
        if (j2 == 0) {
            cancel();
            return;
        }
        synchronized (this.lock) {
            if (this.cancellationRequested) {
                return;
            }
            cancelScheduledCancellation();
            if (j2 != -1) {
                this.scheduledCancellation = this.executor.schedule(new Runnable() { // from class: com.facebook.bolts.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        CancellationTokenSource.m78cancelAfter$lambda6$lambda5(this.f2807e);
                    }
                }, j2, timeUnit);
            }
            t tVar = t.f3507a;
        }
    }
}
