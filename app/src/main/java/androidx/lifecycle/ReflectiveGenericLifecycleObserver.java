package androidx.lifecycle;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.b;
import java.lang.reflect.InvocationTargetException;

@Deprecated
/* loaded from: classes.dex */
class ReflectiveGenericLifecycleObserver implements k {

    /* renamed from: a, reason: collision with root package name */
    private final Object f2410a;

    /* renamed from: b, reason: collision with root package name */
    private final b.a f2411b;

    ReflectiveGenericLifecycleObserver(Object obj) {
        this.f2410a = obj;
        this.f2411b = b.f2428c.c(obj.getClass());
    }

    @Override // androidx.lifecycle.k
    public void d(@NonNull m mVar, @NonNull Lifecycle.Event event) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.f2411b.a(mVar, event, this.f2410a);
    }
}
