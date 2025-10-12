package androidx.appcompat.app;

import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.LongSparseArray;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Field;
import java.util.Map;

/* compiled from: ResourcesFlusher.java */
/* loaded from: classes.dex */
class q {

    /* renamed from: a, reason: collision with root package name */
    private static Field f278a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f279b;

    /* renamed from: c, reason: collision with root package name */
    private static Class<?> f280c;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f281d;

    /* renamed from: e, reason: collision with root package name */
    private static Field f282e;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f283f;

    /* renamed from: g, reason: collision with root package name */
    private static Field f284g;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f285h;

    /* compiled from: ResourcesFlusher.java */
    @RequiresApi(16)
    static class a {
        @DoNotInline
        static void a(LongSparseArray longSparseArray) {
            longSparseArray.clear();
        }
    }

    static void a(@NonNull Resources resources) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            return;
        }
        if (i2 >= 24) {
            d(resources);
        } else if (i2 >= 23) {
            c(resources);
        } else if (i2 >= 21) {
            b(resources);
        }
    }

    @RequiresApi(21)
    private static void b(@NonNull Resources resources) throws NoSuchFieldException, SecurityException {
        if (!f279b) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f278a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e2);
            }
            f279b = true;
        }
        Field field = f278a;
        if (field != null) {
            Map map = null;
            try {
                map = (Map) field.get(resources);
            } catch (IllegalAccessException e3) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e3);
            }
            if (map != null) {
                map.clear();
            }
        }
    }

    @RequiresApi(23)
    private static void c(@NonNull Resources resources) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        if (!f279b) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f278a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e2);
            }
            f279b = true;
        }
        Object obj = null;
        Field field = f278a;
        if (field != null) {
            try {
                obj = field.get(resources);
            } catch (IllegalAccessException e3) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e3);
            }
        }
        if (obj == null) {
            return;
        }
        e(obj);
    }

    @RequiresApi(24)
    private static void d(@NonNull Resources resources) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        Object obj;
        if (!f285h) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                f284g = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", e2);
            }
            f285h = true;
        }
        Field field = f284g;
        if (field == null) {
            return;
        }
        Object obj2 = null;
        try {
            obj = field.get(resources);
        } catch (IllegalAccessException e3) {
            Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", e3);
            obj = null;
        }
        if (obj == null) {
            return;
        }
        if (!f279b) {
            try {
                Field declaredField2 = obj.getClass().getDeclaredField("mDrawableCache");
                f278a = declaredField2;
                declaredField2.setAccessible(true);
            } catch (NoSuchFieldException e4) {
                Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", e4);
            }
            f279b = true;
        }
        Field field2 = f278a;
        if (field2 != null) {
            try {
                obj2 = field2.get(obj);
            } catch (IllegalAccessException e5) {
                Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", e5);
            }
        }
        if (obj2 != null) {
            e(obj2);
        }
    }

    @RequiresApi(16)
    private static void e(@NonNull Object obj) throws NoSuchFieldException, SecurityException {
        if (!f281d) {
            try {
                f280c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e2) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e2);
            }
            f281d = true;
        }
        Class<?> cls = f280c;
        if (cls == null) {
            return;
        }
        if (!f283f) {
            try {
                Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                f282e = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e3) {
                Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e3);
            }
            f283f = true;
        }
        Field field = f282e;
        if (field == null) {
            return;
        }
        LongSparseArray longSparseArray = null;
        try {
            longSparseArray = (LongSparseArray) field.get(obj);
        } catch (IllegalAccessException e4) {
            Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e4);
        }
        if (longSparseArray != null) {
            a.a(longSparseArray);
        }
    }
}
