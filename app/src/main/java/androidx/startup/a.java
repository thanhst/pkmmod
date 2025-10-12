package androidx.startup;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import x.b;

/* compiled from: AppInitializer.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    private static volatile a f2632d;

    /* renamed from: e, reason: collision with root package name */
    private static final Object f2633e = new Object();

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    final Context f2636c;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    final Set<Class<? extends w.a<?>>> f2635b = new HashSet();

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    final Map<Class<?>, Object> f2634a = new HashMap();

    a(@NonNull Context context) {
        this.f2636c = context.getApplicationContext();
    }

    @NonNull
    private <T> T d(@NonNull Class<? extends w.a<?>> cls, @NonNull Set<Class<?>> set) {
        T t2;
        if (b.d()) {
            try {
                b.a(cls.getSimpleName());
            } finally {
                b.b();
            }
        }
        if (set.contains(cls)) {
            throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", cls.getName()));
        }
        if (this.f2634a.containsKey(cls)) {
            t2 = (T) this.f2634a.get(cls);
        } else {
            set.add(cls);
            try {
                w.a<?> aVarNewInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                List<Class<? extends w.a<?>>> listA = aVarNewInstance.a();
                if (!listA.isEmpty()) {
                    for (Class<? extends w.a<?>> cls2 : listA) {
                        if (!this.f2634a.containsKey(cls2)) {
                            d(cls2, set);
                        }
                    }
                }
                t2 = (T) aVarNewInstance.b(this.f2636c);
                set.remove(cls);
                this.f2634a.put(cls, t2);
            } catch (Throwable th) {
                throw new StartupException(th);
            }
        }
        return t2;
    }

    @NonNull
    public static a e(@NonNull Context context) {
        if (f2632d == null) {
            synchronized (f2633e) {
                if (f2632d == null) {
                    f2632d = new a(context);
                }
            }
        }
        return f2632d;
    }

    void a() {
        try {
            try {
                b.a("Startup");
                b(this.f2636c.getPackageManager().getProviderInfo(new ComponentName(this.f2636c.getPackageName(), InitializationProvider.class.getName()), 128).metaData);
            } catch (PackageManager.NameNotFoundException e2) {
                throw new StartupException(e2);
            }
        } finally {
            b.b();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    void b(@Nullable Bundle bundle) throws ClassNotFoundException {
        String string = this.f2636c.getString(R$string.androidx_startup);
        if (bundle != null) {
            try {
                HashSet hashSet = new HashSet();
                for (String str : bundle.keySet()) {
                    if (string.equals(bundle.getString(str, null))) {
                        Class<?> cls = Class.forName(str);
                        if (w.a.class.isAssignableFrom(cls)) {
                            this.f2635b.add(cls);
                        }
                    }
                }
                Iterator<Class<? extends w.a<?>>> it = this.f2635b.iterator();
                while (it.hasNext()) {
                    d(it.next(), hashSet);
                }
            } catch (ClassNotFoundException e2) {
                throw new StartupException(e2);
            }
        }
    }

    @NonNull
    <T> T c(@NonNull Class<? extends w.a<?>> cls) {
        T t2;
        synchronized (f2633e) {
            t2 = (T) this.f2634a.get(cls);
            if (t2 == null) {
                t2 = (T) d(cls, new HashSet());
            }
        }
        return t2;
    }

    @NonNull
    public <T> T f(@NonNull Class<? extends w.a<T>> cls) {
        return (T) c(cls);
    }

    public boolean g(@NonNull Class<? extends w.a<?>> cls) {
        return this.f2635b.contains(cls);
    }
}
