package androidx.core.app;

import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

/* compiled from: NotificationManagerCompat.java */
/* loaded from: classes.dex */
public final class w {

    /* renamed from: c, reason: collision with root package name */
    private static final Object f1414c = new Object();

    /* renamed from: d, reason: collision with root package name */
    @GuardedBy("sEnabledNotificationListenersLock")
    private static Set<String> f1415d = new HashSet();

    /* renamed from: e, reason: collision with root package name */
    private static final Object f1416e = new Object();

    /* renamed from: a, reason: collision with root package name */
    private final Context f1417a;

    /* renamed from: b, reason: collision with root package name */
    private final NotificationManager f1418b;

    private w(Context context) {
        this.f1417a = context;
        this.f1418b = (NotificationManager) context.getSystemService("notification");
    }

    @NonNull
    public static w b(@NonNull Context context) {
        return new w(context);
    }

    public boolean a() throws ClassNotFoundException {
        if (Build.VERSION.SDK_INT >= 24) {
            return this.f1418b.areNotificationsEnabled();
        }
        AppOpsManager appOpsManager = (AppOpsManager) this.f1417a.getSystemService("appops");
        ApplicationInfo applicationInfo = this.f1417a.getApplicationInfo();
        String packageName = this.f1417a.getApplicationContext().getPackageName();
        int i2 = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class<?> cls2 = Integer.TYPE;
            return ((Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i2), packageName)).intValue() == 0;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        }
    }
}
