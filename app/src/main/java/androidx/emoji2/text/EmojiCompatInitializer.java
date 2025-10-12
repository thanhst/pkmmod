package androidx.emoji2.text;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.WorkerThread;
import androidx.emoji2.text.EmojiCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ProcessLifecycleInitializer;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes.dex */
public class EmojiCompatInitializer implements w.a<Boolean> {

    @RequiresApi(19)
    static class a extends EmojiCompat.c {
        protected a(Context context) {
            super(new b(context));
            b(1);
        }
    }

    @RequiresApi(19)
    static class b implements EmojiCompat.g {

        /* renamed from: a, reason: collision with root package name */
        private final Context f1910a;

        class a extends EmojiCompat.h {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ EmojiCompat.h f1911a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ ThreadPoolExecutor f1912b;

            a(EmojiCompat.h hVar, ThreadPoolExecutor threadPoolExecutor) {
                this.f1911a = hVar;
                this.f1912b = threadPoolExecutor;
            }

            @Override // androidx.emoji2.text.EmojiCompat.h
            public void a(@Nullable Throwable th) {
                try {
                    this.f1911a.a(th);
                } finally {
                    this.f1912b.shutdown();
                }
            }

            @Override // androidx.emoji2.text.EmojiCompat.h
            public void b(@NonNull k kVar) {
                try {
                    this.f1911a.b(kVar);
                } finally {
                    this.f1912b.shutdown();
                }
            }
        }

        b(Context context) {
            this.f1910a = context.getApplicationContext();
        }

        @Override // androidx.emoji2.text.EmojiCompat.g
        public void a(@NonNull final EmojiCompat.h hVar) {
            final ThreadPoolExecutor threadPoolExecutorB = androidx.emoji2.text.b.b("EmojiCompatInitializer");
            threadPoolExecutorB.execute(new Runnable() { // from class: androidx.emoji2.text.e
                @Override // java.lang.Runnable
                public final void run() {
                    this.f1922e.d(hVar, threadPoolExecutorB);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @WorkerThread
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void d(@NonNull EmojiCompat.h hVar, @NonNull ThreadPoolExecutor threadPoolExecutor) {
            try {
                h hVarA = androidx.emoji2.text.c.a(this.f1910a);
                if (hVarA == null) {
                    throw new RuntimeException("EmojiCompat font provider not available on this device.");
                }
                hVarA.c(threadPoolExecutor);
                hVarA.a().a(new a(hVar, threadPoolExecutor));
            } catch (Throwable th) {
                hVar.a(th);
                threadPoolExecutor.shutdown();
            }
        }
    }

    static class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                androidx.core.os.k.a("EmojiCompat.EmojiCompatInitializer.run");
                if (EmojiCompat.h()) {
                    EmojiCompat.b().k();
                }
            } finally {
                androidx.core.os.k.b();
            }
        }
    }

    @Override // w.a
    @NonNull
    public List<Class<? extends w.a<?>>> a() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    @Override // w.a
    @NonNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Boolean b(@NonNull Context context) {
        EmojiCompat.g(new a(context));
        d(context);
        return Boolean.TRUE;
    }

    @RequiresApi(19)
    void d(@NonNull Context context) {
        final Lifecycle lifecycle = ((androidx.lifecycle.m) androidx.startup.a.e(context).f(ProcessLifecycleInitializer.class)).getLifecycle();
        lifecycle.a(new androidx.lifecycle.d() { // from class: androidx.emoji2.text.EmojiCompatInitializer.1
            @Override // androidx.lifecycle.f
            public void a(@NonNull androidx.lifecycle.m mVar) {
                EmojiCompatInitializer.this.e();
                lifecycle.c(this);
            }

            @Override // androidx.lifecycle.f
            public /* synthetic */ void b(androidx.lifecycle.m mVar) {
                androidx.lifecycle.c.b(this, mVar);
            }

            @Override // androidx.lifecycle.f
            public /* synthetic */ void c(androidx.lifecycle.m mVar) {
                androidx.lifecycle.c.a(this, mVar);
            }

            @Override // androidx.lifecycle.f
            public /* synthetic */ void e(androidx.lifecycle.m mVar) {
                androidx.lifecycle.c.c(this, mVar);
            }

            @Override // androidx.lifecycle.f
            public /* synthetic */ void f(androidx.lifecycle.m mVar) {
                androidx.lifecycle.c.d(this, mVar);
            }

            @Override // androidx.lifecycle.f
            public /* synthetic */ void g(androidx.lifecycle.m mVar) {
                androidx.lifecycle.c.e(this, mVar);
            }
        });
    }

    @RequiresApi(19)
    void e() {
        androidx.emoji2.text.b.d().postDelayed(new c(), 500L);
    }
}
