package androidx.core.app;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.app.SharedElementCallback$OnSharedElementsReadyListener;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.DoNotInline;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.core.os.BuildCompat;
import java.util.Arrays;
import java.util.HashSet;

/* compiled from: ActivityCompat.java */
/* loaded from: classes.dex */
public class b extends ContextCompat {

    /* renamed from: c, reason: collision with root package name */
    private static f f1389c;

    /* compiled from: ActivityCompat.java */
    class a implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String[] f1390e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Activity f1391f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f1392g;

        a(String[] strArr, Activity activity, int i2) {
            this.f1390e = strArr;
            this.f1391f = activity;
            this.f1392g = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int[] iArr = new int[this.f1390e.length];
            PackageManager packageManager = this.f1391f.getPackageManager();
            String packageName = this.f1391f.getPackageName();
            int length = this.f1390e.length;
            for (int i2 = 0; i2 < length; i2++) {
                iArr[i2] = packageManager.checkPermission(this.f1390e[i2], packageName);
            }
            ((e) this.f1391f).onRequestPermissionsResult(this.f1392g, this.f1390e, iArr);
        }
    }

    /* compiled from: ActivityCompat.java */
    @RequiresApi(16)
    /* renamed from: androidx.core.app.b$b, reason: collision with other inner class name */
    static class C0015b {
        @DoNotInline
        static void a(Activity activity) {
            activity.finishAffinity();
        }

        @DoNotInline
        static void b(Activity activity, Intent intent, int i2, Bundle bundle) {
            activity.startActivityForResult(intent, i2, bundle);
        }

        @DoNotInline
        static void c(Activity activity, IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws IntentSender.SendIntentException {
            activity.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
        }
    }

    /* compiled from: ActivityCompat.java */
    @RequiresApi(21)
    static class c {
        @DoNotInline
        static void a(Activity activity) {
            activity.finishAfterTransition();
        }

        @DoNotInline
        static void b(Activity activity) {
            activity.postponeEnterTransition();
        }

        @DoNotInline
        static void c(Activity activity, SharedElementCallback sharedElementCallback) {
            activity.setEnterSharedElementCallback(sharedElementCallback);
        }

        @DoNotInline
        static void d(Activity activity, SharedElementCallback sharedElementCallback) {
            activity.setExitSharedElementCallback(sharedElementCallback);
        }

        @DoNotInline
        static void e(Activity activity) {
            activity.startPostponedEnterTransition();
        }
    }

    /* compiled from: ActivityCompat.java */
    @RequiresApi(23)
    static class d {
        @DoNotInline
        static void a(Object obj) {
            ((SharedElementCallback$OnSharedElementsReadyListener) obj).onSharedElementsReady();
        }

        @DoNotInline
        static void b(Activity activity, String[] strArr, int i2) {
            activity.requestPermissions(strArr, i2);
        }

        @DoNotInline
        static boolean c(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
    }

    /* compiled from: ActivityCompat.java */
    public interface e {
        void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr);
    }

    /* compiled from: ActivityCompat.java */
    public interface f {
        boolean a(@NonNull Activity activity, @NonNull String[] strArr, @IntRange(from = 0) int i2);
    }

    /* compiled from: ActivityCompat.java */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface g {
        void validateRequestPermissionsRequestCode(int i2);
    }

    public static void l(@NonNull Activity activity) {
        C0015b.a(activity);
    }

    public static void m(@NonNull Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            c.a(activity);
        } else {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void n(Activity activity) {
        if (activity.isFinishing() || k.i(activity)) {
            return;
        }
        activity.recreate();
    }

    public static void o(@NonNull Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            c.b(activity);
        }
    }

    public static void p(@NonNull final Activity activity) {
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
        } else {
            new Handler(activity.getMainLooper()).post(new Runnable() { // from class: androidx.core.app.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.n(activity);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public static void q(@NonNull Activity activity, @NonNull String[] strArr, @IntRange(from = 0) int i2) {
        f fVar = f1389c;
        if (fVar == null || !fVar.a(activity, strArr, i2)) {
            HashSet hashSet = new HashSet();
            for (int i3 = 0; i3 < strArr.length; i3++) {
                if (TextUtils.isEmpty(strArr[i3])) {
                    throw new IllegalArgumentException("Permission request for permissions " + Arrays.toString(strArr) + " must not contain null or empty values");
                }
                if (!BuildCompat.d() && TextUtils.equals(strArr[i3], "android.permission.POST_NOTIFICATIONS")) {
                    hashSet.add(Integer.valueOf(i3));
                }
            }
            int size = hashSet.size();
            String[] strArr2 = size > 0 ? new String[strArr.length - size] : strArr;
            if (size > 0) {
                if (size == strArr.length) {
                    return;
                }
                int i4 = 0;
                for (int i5 = 0; i5 < strArr.length; i5++) {
                    if (!hashSet.contains(Integer.valueOf(i5))) {
                        strArr2[i4] = strArr[i5];
                        i4++;
                    }
                }
            }
            if (Build.VERSION.SDK_INT >= 23) {
                if (activity instanceof g) {
                    ((g) activity).validateRequestPermissionsRequestCode(i2);
                }
                d.b(activity, strArr, i2);
            } else if (activity instanceof e) {
                new Handler(Looper.getMainLooper()).post(new a(strArr2, activity, i2));
            }
        }
    }

    public static void r(@NonNull Activity activity, @Nullable y yVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            c.c(activity, null);
        }
    }

    public static void s(@NonNull Activity activity, @Nullable y yVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            c.d(activity, null);
        }
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public static boolean t(@NonNull Activity activity, @NonNull String str) {
        if ((BuildCompat.d() || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) && Build.VERSION.SDK_INT >= 23) {
            return d.c(activity, str);
        }
        return false;
    }

    public static void u(@NonNull Activity activity, @NonNull Intent intent, int i2, @Nullable Bundle bundle) {
        C0015b.b(activity, intent, i2, bundle);
    }

    public static void v(@NonNull Activity activity, @NonNull IntentSender intentSender, int i2, @Nullable Intent intent, int i3, int i4, int i5, @Nullable Bundle bundle) throws IntentSender.SendIntentException {
        C0015b.c(activity, intentSender, i2, intent, i3, i4, i5, bundle);
    }

    public static void w(@NonNull Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            c.e(activity);
        }
    }
}
