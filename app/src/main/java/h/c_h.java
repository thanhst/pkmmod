package h;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: DefaultTaskExecutor.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class c_h extends d_h {

    /* renamed from: a, reason: collision with root package name */
    private final Object f3294a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private final ExecutorService f3295b = Executors.newFixedThreadPool(4, new a());

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private volatile Handler f3296c;

    /* compiled from: DefaultTaskExecutor.java */
    class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        private final AtomicInteger f3297a = new AtomicInteger(0);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(String.format("arch_disk_io_%d", Integer.valueOf(this.f3297a.getAndIncrement())));
            return thread;
        }
    }

    private static Handler d(@NonNull Looper looper) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Handler.createAsync(looper);
        }
        try {
            return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException unused) {
            return new Handler(looper);
        } catch (InvocationTargetException unused2) {
            return new Handler(looper);
        }
    }

    @Override // h.d
    public void a(Runnable runnable) {
        this.f3295b.execute(runnable);
    }

    @Override // h.d
    public boolean b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    @Override // h.d
    public void c(Runnable runnable) {
        if (this.f3296c == null) {
            synchronized (this.f3294a) {
                if (this.f3296c == null) {
                    this.f3296c = d(Looper.getMainLooper());
                }
            }
        }
        this.f3296c.post(runnable);
    }
}
