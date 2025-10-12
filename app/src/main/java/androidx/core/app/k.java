package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* compiled from: ActivityRecreator.java */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
final class k {

    /* renamed from: a, reason: collision with root package name */
    protected static final Class<?> f1393a;

    /* renamed from: b, reason: collision with root package name */
    protected static final Field f1394b;

    /* renamed from: c, reason: collision with root package name */
    protected static final Field f1395c;

    /* renamed from: d, reason: collision with root package name */
    protected static final Method f1396d;

    /* renamed from: e, reason: collision with root package name */
    protected static final Method f1397e;

    /* renamed from: f, reason: collision with root package name */
    protected static final Method f1398f;

    /* renamed from: g, reason: collision with root package name */
    private static final Handler f1399g = new Handler(Looper.getMainLooper());

    /* compiled from: ActivityRecreator.java */
    class a implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ d f1400e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Object f1401f;

        a(d dVar, Object obj) {
            this.f1400e = dVar;
            this.f1401f = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1400e.f1406e = this.f1401f;
        }
    }

    /* compiled from: ActivityRecreator.java */
    class b implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Application f1402e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ d f1403f;

        b(Application application, d dVar) {
            this.f1402e = application;
            this.f1403f = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1402e.unregisterActivityLifecycleCallbacks(this.f1403f);
        }
    }

    /* compiled from: ActivityRecreator.java */
    class c implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Object f1404e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Object f1405f;

        c(Object obj, Object obj2) {
            this.f1404e = obj;
            this.f1405f = obj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Method method = k.f1396d;
                if (method != null) {
                    method.invoke(this.f1404e, this.f1405f, Boolean.FALSE, "AppCompat recreation");
                } else {
                    k.f1397e.invoke(this.f1404e, this.f1405f, Boolean.FALSE);
                }
            } catch (RuntimeException e2) {
                if (e2.getClass() == RuntimeException.class && e2.getMessage() != null && e2.getMessage().startsWith("Unable to stop")) {
                    throw e2;
                }
            } catch (Throwable th) {
                Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
            }
        }
    }

    /* compiled from: ActivityRecreator.java */
    private static final class d implements Application.ActivityLifecycleCallbacks {

        /* renamed from: e, reason: collision with root package name */
        Object f1406e;

        /* renamed from: f, reason: collision with root package name */
        private Activity f1407f;

        /* renamed from: g, reason: collision with root package name */
        private final int f1408g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f1409h = false;

        /* renamed from: i, reason: collision with root package name */
        private boolean f1410i = false;

        /* renamed from: j, reason: collision with root package name */
        private boolean f1411j = false;

        d(@NonNull Activity activity) {
            this.f1407f = activity;
            this.f1408g = activity.hashCode();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (this.f1407f == activity) {
                this.f1407f = null;
                this.f1410i = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (!this.f1410i || this.f1411j || this.f1409h || !k.h(this.f1406e, this.f1408g, activity)) {
                return;
            }
            this.f1411j = true;
            this.f1406e = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (this.f1407f == activity) {
                this.f1409h = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    static {
        Class<?> clsA = a();
        f1393a = clsA;
        f1394b = b();
        f1395c = f();
        f1396d = d(clsA);
        f1397e = c(clsA);
        f1398f = e(clsA);
    }

    private static Class<?> a() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Field b() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method c(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method d(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE, String.class);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method e(Class<?> cls) {
        if (g() && cls != null) {
            try {
                Class<?> cls2 = Boolean.TYPE;
                Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, cls2, Configuration.class, Configuration.class, cls2, cls2);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static Field f() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean g() {
        int i2 = Build.VERSION.SDK_INT;
        return i2 == 26 || i2 == 27;
    }

    protected static boolean h(Object obj, int i2, Activity activity) {
        try {
            Object obj2 = f1395c.get(activity);
            if (obj2 == obj && activity.hashCode() == i2) {
                f1399g.postAtFrontOfQueue(new c(f1394b.get(activity), obj2));
                return true;
            }
            return false;
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while fetching field values", th);
            return false;
        }
    }

    static boolean i(@NonNull Activity activity) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        }
        if (g() && f1398f == null) {
            return false;
        }
        if (f1397e == null && f1396d == null) {
            return false;
        }
        try {
            Object obj2 = f1395c.get(activity);
            if (obj2 == null || (obj = f1394b.get(activity)) == null) {
                return false;
            }
            Application application = activity.getApplication();
            d dVar = new d(activity);
            application.registerActivityLifecycleCallbacks(dVar);
            Handler handler = f1399g;
            handler.post(new a(dVar, obj2));
            try {
                if (g()) {
                    Method method = f1398f;
                    Boolean bool = Boolean.FALSE;
                    method.invoke(obj, obj2, null, null, 0, bool, null, null, bool, bool);
                } else {
                    activity.recreate();
                }
                handler.post(new b(application, dVar));
                return true;
            } catch (Throwable th) {
                f1399g.post(new b(application, dVar));
                throw th;
            }
        } catch (Throwable unused) {
            return false;
        }
    }
}
