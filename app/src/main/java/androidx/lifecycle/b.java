package androidx.lifecycle;

import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ClassesInfoCache.java */
@Deprecated
/* loaded from: classes.dex */
final class b {

    /* renamed from: c, reason: collision with root package name */
    static b f2428c = new b();

    /* renamed from: a, reason: collision with root package name */
    private final Map<Class<?>, a> f2429a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final Map<Class<?>, Boolean> f2430b = new HashMap();

    /* compiled from: ClassesInfoCache.java */
    @Deprecated
    static class a {

        /* renamed from: a, reason: collision with root package name */
        final Map<Lifecycle.Event, List<C0031b>> f2431a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        final Map<C0031b, Lifecycle.Event> f2432b;

        a(Map<C0031b, Lifecycle.Event> map) {
            this.f2432b = map;
            for (Map.Entry<C0031b, Lifecycle.Event> entry : map.entrySet()) {
                Lifecycle.Event value = entry.getValue();
                List<C0031b> arrayList = this.f2431a.get(value);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.f2431a.put(value, arrayList);
                }
                arrayList.add(entry.getKey());
            }
        }

        private static void b(List<C0031b> list, m mVar, Lifecycle.Event event, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).a(mVar, event, obj);
                }
            }
        }

        void a(m mVar, Lifecycle.Event event, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            b(this.f2431a.get(event), mVar, event, obj);
            b(this.f2431a.get(Lifecycle.Event.ON_ANY), mVar, event, obj);
        }
    }

    /* compiled from: ClassesInfoCache.java */
    @Deprecated
    /* renamed from: androidx.lifecycle.b$b, reason: collision with other inner class name */
    static final class C0031b {

        /* renamed from: a, reason: collision with root package name */
        final int f2433a;

        /* renamed from: b, reason: collision with root package name */
        final Method f2434b;

        C0031b(int i2, Method method) throws SecurityException {
            this.f2433a = i2;
            this.f2434b = method;
            method.setAccessible(true);
        }

        void a(m mVar, Lifecycle.Event event, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            try {
                int i2 = this.f2433a;
                if (i2 == 0) {
                    this.f2434b.invoke(obj, new Object[0]);
                } else if (i2 == 1) {
                    this.f2434b.invoke(obj, mVar);
                } else {
                    if (i2 != 2) {
                        return;
                    }
                    this.f2434b.invoke(obj, mVar, event);
                }
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            } catch (InvocationTargetException e3) {
                throw new RuntimeException("Failed to call observer method", e3.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0031b)) {
                return false;
            }
            C0031b c0031b = (C0031b) obj;
            return this.f2433a == c0031b.f2433a && this.f2434b.getName().equals(c0031b.f2434b.getName());
        }

        public int hashCode() {
            return (this.f2433a * 31) + this.f2434b.getName().hashCode();
        }
    }

    b() {
    }

    private a a(Class<?> cls, @Nullable Method[] methodArr) {
        int i2;
        a aVarC;
        Class<? super Object> superclass = cls.getSuperclass();
        HashMap map = new HashMap();
        if (superclass != null && (aVarC = c(superclass)) != null) {
            map.putAll(aVarC.f2432b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry<C0031b, Lifecycle.Event> entry : c(cls2).f2432b.entrySet()) {
                e(map, entry.getKey(), entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = b(cls);
        }
        boolean z2 = false;
        for (Method method : methodArr) {
            OnLifecycleEvent onLifecycleEvent = (OnLifecycleEvent) method.getAnnotation(OnLifecycleEvent.class);
            if (onLifecycleEvent != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i2 = 0;
                } else {
                    if (!parameterTypes[0].isAssignableFrom(m.class)) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i2 = 1;
                }
                Lifecycle.Event eventValue = onLifecycleEvent.value();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(Lifecycle.Event.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (eventValue != Lifecycle.Event.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i2 = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                e(map, new C0031b(i2, method), eventValue, cls);
                z2 = true;
            }
        }
        a aVar = new a(map);
        this.f2429a.put(cls, aVar);
        this.f2430b.put(cls, Boolean.valueOf(z2));
        return aVar;
    }

    private Method[] b(Class<?> cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e2) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e2);
        }
    }

    private void e(Map<C0031b, Lifecycle.Event> map, C0031b c0031b, Lifecycle.Event event, Class<?> cls) {
        Lifecycle.Event event2 = map.get(c0031b);
        if (event2 == null || event == event2) {
            if (event2 == null) {
                map.put(c0031b, event);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + c0031b.f2434b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + event2 + ", new value " + event);
    }

    a c(Class<?> cls) {
        a aVar = this.f2429a.get(cls);
        return aVar != null ? aVar : a(cls, null);
    }

    boolean d(Class<?> cls) {
        Boolean bool = this.f2430b.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] methodArrB = b(cls);
        for (Method method : methodArrB) {
            if (((OnLifecycleEvent) method.getAnnotation(OnLifecycleEvent.class)) != null) {
                a(cls, methodArrB);
                return true;
            }
        }
        this.f2430b.put(cls, Boolean.FALSE);
        return false;
    }
}
