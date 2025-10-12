package androidx.core.provider;

import android.os.Handler;
import android.os.Process;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: RequestExecutor.java */
/* loaded from: classes.dex */
class g {

    /* compiled from: RequestExecutor.java */
    private static class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        private String f1610a;

        /* renamed from: b, reason: collision with root package name */
        private int f1611b;

        /* compiled from: RequestExecutor.java */
        /* renamed from: androidx.core.provider.g$a$a, reason: collision with other inner class name */
        private static class C0018a extends Thread {

            /* renamed from: e, reason: collision with root package name */
            private final int f1612e;

            C0018a(Runnable runnable, String str, int i2) {
                super(runnable, str);
                this.f1612e = i2;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() throws SecurityException, IllegalArgumentException {
                Process.setThreadPriority(this.f1612e);
                super.run();
            }
        }

        a(@NonNull String str, int i2) {
            this.f1610a = str;
            this.f1611b = i2;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new C0018a(runnable, this.f1610a, this.f1611b);
        }
    }

    /* compiled from: RequestExecutor.java */
    private static class b<T> implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        @NonNull
        private Callable<T> f1613e;

        /* renamed from: f, reason: collision with root package name */
        @NonNull
        private androidx.core.util.a<T> f1614f;

        /* renamed from: g, reason: collision with root package name */
        @NonNull
        private Handler f1615g;

        /* compiled from: RequestExecutor.java */
        class a implements Runnable {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ androidx.core.util.a f1616e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ Object f1617f;

            a(androidx.core.util.a aVar, Object obj) {
                this.f1616e = aVar;
                this.f1617f = obj;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                this.f1616e.accept(this.f1617f);
            }
        }

        b(@NonNull Handler handler, @NonNull Callable<T> callable, @NonNull androidx.core.util.a<T> aVar) {
            this.f1613e = callable;
            this.f1614f = aVar;
            this.f1615g = handler;
        }

        @Override // java.lang.Runnable
        public void run() throws Exception {
            T tCall;
            try {
                tCall = this.f1613e.call();
            } catch (Exception unused) {
                tCall = null;
            }
            this.f1615g.post(new a(this.f1614f, tCall));
        }
    }

    static ThreadPoolExecutor a(@NonNull String str, int i2, @IntRange(from = 0) int i3) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, i3, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new a(str, i2));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    static <T> void b(@NonNull Executor executor, @NonNull Callable<T> callable, @NonNull androidx.core.util.a<T> aVar) {
        executor.execute(new b(androidx.core.provider.b.a(), callable, aVar));
    }

    static <T> T c(@NonNull ExecutorService executorService, @NonNull Callable<T> callable, @IntRange(from = 0) int i2) throws InterruptedException {
        try {
            return executorService.submit(callable).get(i2, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e2) {
            throw e2;
        } catch (ExecutionException e3) {
            throw new RuntimeException(e3);
        } catch (TimeoutException unused) {
            throw new InterruptedException("timeout");
        }
    }
}
