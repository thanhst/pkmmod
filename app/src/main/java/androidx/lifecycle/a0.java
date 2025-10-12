package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: ViewModel.java */
/* loaded from: classes.dex */
public abstract class a0 {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final Map<String, Object> f2425a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private final Set<Closeable> f2426b = new LinkedHashSet();

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f2427c = false;

    private static void b(Object obj) throws IOException {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    @MainThread
    final void a() {
        this.f2427c = true;
        Map<String, Object> map = this.f2425a;
        if (map != null) {
            synchronized (map) {
                Iterator<Object> it = this.f2425a.values().iterator();
                while (it.hasNext()) {
                    b(it.next());
                }
            }
        }
        Set<Closeable> set = this.f2426b;
        if (set != null) {
            synchronized (set) {
                Iterator<Closeable> it2 = this.f2426b.iterator();
                while (it2.hasNext()) {
                    b(it2.next());
                }
            }
        }
        d();
    }

    <T> T c(String str) {
        T t2;
        Map<String, Object> map = this.f2425a;
        if (map == null) {
            return null;
        }
        synchronized (map) {
            t2 = (T) this.f2425a.get(str);
        }
        return t2;
    }

    protected void d() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    <T> T e(String str, T t2) throws IOException {
        Object obj;
        synchronized (this.f2425a) {
            obj = this.f2425a.get(str);
            if (obj == 0) {
                this.f2425a.put(str, t2);
            }
        }
        if (obj != 0) {
            t2 = obj;
        }
        if (this.f2427c) {
            b(t2);
        }
        return t2;
    }
}
