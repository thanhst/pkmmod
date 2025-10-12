package androidx.lifecycle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Lifecycling.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    private static Map<Class<?>, Integer> f2459a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private static Map<Class<?>, List<Constructor<? extends g>>> f2460b = new HashMap();

    private static g a(Constructor<? extends g> constructor, Object obj) {
        try {
            return constructor.newInstance(obj);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException(e3);
        } catch (InvocationTargetException e4) {
            throw new RuntimeException(e4);
        }
    }

    @Nullable
    private static Constructor<? extends g> b(Class<?> cls) throws NoSuchMethodException, SecurityException {
        try {
            Package r02 = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            String name = r02 != null ? r02.getName() : "";
            if (!name.isEmpty()) {
                canonicalName = canonicalName.substring(name.length() + 1);
            }
            String strC = c(canonicalName);
            if (!name.isEmpty()) {
                strC = name + "." + strC;
            }
            Constructor declaredConstructor = Class.forName(strC).getDeclaredConstructor(cls);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static String c(String str) {
        return str.replace(".", "_") + "_LifecycleAdapter";
    }

    private static int d(Class<?> cls) throws NoSuchMethodException, SecurityException {
        Integer num = f2459a.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int iG = g(cls);
        f2459a.put(cls, Integer.valueOf(iG));
        return iG;
    }

    private static boolean e(Class<?> cls) {
        return cls != null && l.class.isAssignableFrom(cls);
    }

    @NonNull
    static k f(Object obj) {
        boolean z2 = obj instanceof k;
        boolean z3 = obj instanceof f;
        if (z2 && z3) {
            return new FullLifecycleObserverAdapter((f) obj, (k) obj);
        }
        if (z3) {
            return new FullLifecycleObserverAdapter((f) obj, null);
        }
        if (z2) {
            return (k) obj;
        }
        Class<?> cls = obj.getClass();
        if (d(cls) != 2) {
            return new ReflectiveGenericLifecycleObserver(obj);
        }
        List<Constructor<? extends g>> list = f2460b.get(cls);
        if (list.size() == 1) {
            return new SingleGeneratedAdapterObserver(a(list.get(0), obj));
        }
        g[] gVarArr = new g[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            gVarArr[i2] = a(list.get(i2), obj);
        }
        return new CompositeGeneratedAdaptersObserver(gVarArr);
    }

    private static int g(Class<?> cls) throws NoSuchMethodException, SecurityException {
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor<? extends g> constructorB = b(cls);
        if (constructorB != null) {
            f2460b.put(cls, Collections.singletonList(constructorB));
            return 2;
        }
        if (b.f2428c.d(cls)) {
            return 1;
        }
        Class<? super Object> superclass = cls.getSuperclass();
        ArrayList arrayList = null;
        if (e(superclass)) {
            if (d(superclass) == 1) {
                return 1;
            }
            arrayList = new ArrayList(f2460b.get(superclass));
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            if (e(cls2)) {
                if (d(cls2) == 1) {
                    return 1;
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.addAll(f2460b.get(cls2));
            }
        }
        if (arrayList == null) {
            return 1;
        }
        f2460b.put(cls, arrayList);
        return 2;
    }
}
