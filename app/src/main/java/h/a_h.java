package h;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.concurrent.Executor;

/* compiled from: ArchTaskExecutor.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class a_h extends d_h {

    /* renamed from: c, reason: collision with root package name */
    private static volatile a_h f3289c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private static final Executor f3290d = new ExecutorC0051a();

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    private static final Executor f3291e = new b();

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private d_h f3292a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private d_h f3293b;

    /* compiled from: ArchTaskExecutor.java */
    /* renamed from: h.a$a, reason: collision with other inner class name */
    static class ExecutorC0051a implements Executor {
        ExecutorC0051a() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a_h.d().c(runnable);
        }
    }

    /* compiled from: ArchTaskExecutor.java */
    static class b implements Executor {
        b() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a_h.d().a(runnable);
        }
    }

    private a_h() {
        c_h cHVar = new c_h();
        this.f3293b = cHVar;
        this.f3292a = cHVar;
    }

    @NonNull
    public static a_h d() {
        if (f3289c != null) {
            return f3289c;
        }
        synchronized (a_h.class) {
            if (f3289c == null) {
                f3289c = new a_h();
            }
        }
        return f3289c;
    }

    @Override // h.d
    public void a(Runnable runnable) {
        this.f3292a.a(runnable);
    }

    @Override // h.d
    public boolean b() {
        return this.f3292a.b();
    }

    @Override // h.d
    public void c(Runnable runnable) {
        this.f3292a.c(runnable);
    }
}
