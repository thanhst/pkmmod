package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DoNotInline;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.app.w;
import androidx.core.os.BuildCompat;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@SuppressLint({"PrivateConstructorForUtilityClass"})
/* loaded from: classes.dex */
public class ContextCompat {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f1423a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static final Object f1424b = new Object();

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface RegisterReceiverFlags {
    }

    @RequiresApi(16)
    static class a {
        @DoNotInline
        static void a(Context context, Intent[] intentArr, Bundle bundle) {
            context.startActivities(intentArr, bundle);
        }

        @DoNotInline
        static void b(Context context, Intent intent, Bundle bundle) {
            context.startActivity(intent, bundle);
        }
    }

    @RequiresApi(19)
    static class b {
        @DoNotInline
        static File[] a(Context context) {
            return context.getExternalCacheDirs();
        }

        @DoNotInline
        static File[] b(Context context, String str) {
            return context.getExternalFilesDirs(str);
        }

        @DoNotInline
        static File[] c(Context context) {
            return context.getObbDirs();
        }
    }

    @RequiresApi(21)
    static class c {
        @DoNotInline
        static File a(Context context) {
            return context.getCodeCacheDir();
        }

        @DoNotInline
        static Drawable b(Context context, int i2) {
            return context.getDrawable(i2);
        }

        @DoNotInline
        static File c(Context context) {
            return context.getNoBackupFilesDir();
        }
    }

    @RequiresApi(23)
    static class d {
        @DoNotInline
        static int a(Context context, int i2) {
            return context.getColor(i2);
        }

        @DoNotInline
        static <T> T b(Context context, Class<T> cls) {
            return (T) context.getSystemService(cls);
        }

        @DoNotInline
        static String c(Context context, Class<?> cls) {
            return context.getSystemServiceName(cls);
        }
    }

    @RequiresApi(26)
    static class e {
        @DoNotInline
        static Intent a(Context context, @Nullable BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i2) {
            return ((i2 & 4) == 0 || str != null) ? context.registerReceiver(broadcastReceiver, intentFilter, str, handler, i2 & 1) : context.registerReceiver(broadcastReceiver, intentFilter, ContextCompat.g(context), handler);
        }

        @DoNotInline
        static ComponentName b(Context context, Intent intent) {
            return context.startForegroundService(intent);
        }
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public static int a(@NonNull Context context, @NonNull String str) {
        androidx.core.util.c.c(str, "permission must be non-null");
        return (BuildCompat.d() || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) ? context.checkPermission(str, Process.myPid(), Process.myUid()) : w.b(context).a() ? 0 : -1;
    }

    @ColorInt
    public static int b(@NonNull Context context, @ColorRes int i2) {
        return Build.VERSION.SDK_INT >= 23 ? d.a(context, i2) : context.getResources().getColor(i2);
    }

    @Nullable
    public static ColorStateList c(@NonNull Context context, @ColorRes int i2) {
        return androidx.core.content.res.h.c(context.getResources(), i2, context.getTheme());
    }

    @Nullable
    public static Drawable d(@NonNull Context context, @DrawableRes int i2) {
        return Build.VERSION.SDK_INT >= 21 ? c.b(context, i2) : context.getResources().getDrawable(i2);
    }

    @NonNull
    public static File[] e(@NonNull Context context) {
        return b.a(context);
    }

    @NonNull
    public static File[] f(@NonNull Context context, @Nullable String str) {
        return b.b(context, str);
    }

    static String g(Context context) {
        String str = context.getPackageName() + ".DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION";
        if (PermissionChecker.b(context, str) == 0) {
            return str;
        }
        throw new RuntimeException("Permission " + str + " is required by your application to receive broadcasts, please add it to your manifest");
    }

    public static boolean h(@NonNull Context context, @NonNull Intent[] intentArr, @Nullable Bundle bundle) {
        a.a(context, intentArr, bundle);
        return true;
    }

    public static void i(@NonNull Context context, @NonNull Intent intent, @Nullable Bundle bundle) {
        a.b(context, intent, bundle);
    }

    public static void j(@NonNull Context context, @NonNull Intent intent) {
        if (Build.VERSION.SDK_INT >= 26) {
            e.b(context, intent);
        } else {
            context.startService(intent);
        }
    }
}
