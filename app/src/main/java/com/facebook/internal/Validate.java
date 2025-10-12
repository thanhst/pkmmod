package com.facebook.internal;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Looper;
import android.util.Log;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.FacebookSdkNotInitializedException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Validate.kt */
@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b.\u0010/J\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J$\u0010\n\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J$\u0010\u000b\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J \u0010\f\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J$\u0010\r\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J\b\u0010\u000e\u001a\u00020\u0005H\u0007J\u001a\u0010\u000f\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J9\u0010\u0012\u001a\u00020\u00052\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0016\u0010\u0011\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0010\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0005H\u0007J\b\u0010\u0015\u001a\u00020\u0003H\u0007J\b\u0010\u0016\u001a\u00020\u0003H\u0007J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017H\u0007J\u0018\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001aH\u0007J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u0017H\u0007J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u0017H\u0007J\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u0017H\u0007J\u0010\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u0017H\u0007J\u0018\u0010!\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u0003H\u0007J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017H\u0007J\u0018\u0010\"\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001aH\u0007J\u0018\u0010$\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u0003H\u0007J\u0010\u0010%\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017H\u0007R\u001c\u0010'\u001a\n &*\u0004\u0018\u00010\u00030\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\u00038\u0002X\u0082T¢\u0006\u0006\n\u0004\b)\u0010(R\u0014\u0010*\u001a\u00020\u00038\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010(R\u0014\u0010+\u001a\u00020\u00038\u0002X\u0082T¢\u0006\u0006\n\u0004\b+\u0010(R\u0014\u0010,\u001a\u00020\u00038\u0002X\u0082T¢\u0006\u0006\n\u0004\b,\u0010(R\u0014\u0010-\u001a\u00020\u00038\u0006X\u0086T¢\u0006\u0006\n\u0004\b-\u0010(¨\u00060"}, d2 = {"Lcom/facebook/internal/Validate;", "", "arg", "", "name", "Lkotlin/t;", "notNull", "T", "", "container", "notEmpty", "containsNoNulls", "containsNoNullOrEmpty", "notEmptyAndContainsNoNulls", "runningOnUiThread", "notNullOrEmpty", "", "values", "oneOf", "(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)V", "sdkInitialized", "hasAppID", "hasClientToken", "Landroid/content/Context;", "context", "hasInternetPermissions", "", "shouldThrow", "hasWiFiPermission", "hasChangeWifiStatePermission", "hasLocationPermission", "hasBluetoothPermission", "permission", "hasPermission", "hasFacebookActivity", "redirectURI", "hasCustomTabRedirectActivity", "hasContentProvider", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "NO_INTERNET_PERMISSION_REASON", "FACEBOOK_ACTIVITY_NOT_FOUND_REASON", "CONTENT_PROVIDER_NOT_FOUND_REASON", "CONTENT_PROVIDER_BASE", "CUSTOM_TAB_REDIRECT_URI_PREFIX", "<init>", "()V", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Validate {

    @NotNull
    private static final String CONTENT_PROVIDER_BASE = "com.facebook.app.FacebookContentProvider";

    @NotNull
    private static final String CONTENT_PROVIDER_NOT_FOUND_REASON = "A ContentProvider for this app was not set up in the AndroidManifest.xml, please add %s as a provider to your AndroidManifest.xml file. See https://developers.facebook.com/docs/sharing/android for more info.";

    @NotNull
    public static final String CUSTOM_TAB_REDIRECT_URI_PREFIX = "fbconnect://cct.";

    @NotNull
    private static final String FACEBOOK_ACTIVITY_NOT_FOUND_REASON = "FacebookActivity is not declared in the AndroidManifest.xml. If you are using the facebook-common module or dependent modules please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.";

    @NotNull
    private static final String NO_INTERNET_PERMISSION_REASON = "No internet permissions granted for the app, please add <uses-permission android:name=\"android.permission.INTERNET\" /> to your AndroidManifest.xml.";

    @NotNull
    public static final Validate INSTANCE = new Validate();
    private static final String TAG = Validate.class.getName();

    private Validate() {
    }

    @JvmStatic
    public static final void containsNoNullOrEmpty(@NotNull Collection<String> container, @NotNull String name) {
        kotlin.jvm.internal.s.e(container, "container");
        kotlin.jvm.internal.s.e(name, "name");
        for (String str : container) {
            if (str == null) {
                throw new NullPointerException("Container '" + name + "' cannot contain null values");
            }
            if (!(str.length() > 0)) {
                throw new IllegalArgumentException(("Container '" + name + "' cannot contain empty values").toString());
            }
        }
    }

    @JvmStatic
    public static final <T> void containsNoNulls(@NotNull Collection<? extends T> container, @NotNull String name) {
        kotlin.jvm.internal.s.e(container, "container");
        kotlin.jvm.internal.s.e(name, "name");
        Iterator<? extends T> it = container.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new NullPointerException("Container '" + name + "' cannot contain null values");
            }
        }
    }

    @JvmStatic
    @NotNull
    public static final String hasAppID() {
        String applicationId = FacebookSdk.getApplicationId();
        if (applicationId != null) {
            return applicationId;
        }
        throw new IllegalStateException("No App ID found, please set the App ID.".toString());
    }

    @JvmStatic
    public static final boolean hasBluetoothPermission(@NotNull Context context) {
        kotlin.jvm.internal.s.e(context, "context");
        return hasPermission(context, "android.permission.BLUETOOTH") && hasPermission(context, "android.permission.BLUETOOTH_ADMIN");
    }

    @JvmStatic
    public static final boolean hasChangeWifiStatePermission(@NotNull Context context) {
        kotlin.jvm.internal.s.e(context, "context");
        return hasPermission(context, "android.permission.CHANGE_WIFI_STATE");
    }

    @JvmStatic
    @NotNull
    public static final String hasClientToken() {
        String clientToken = FacebookSdk.getClientToken();
        if (clientToken != null) {
            return clientToken;
        }
        throw new IllegalStateException("No Client Token found, please set the Client Token. Please follow https://developers.facebook.com/docs/android/getting-started/#client-access-token to get the token and fill it in AndroidManifest.xml".toString());
    }

    @JvmStatic
    public static final void hasContentProvider(@NotNull Context context) {
        kotlin.jvm.internal.s.e(context, "context");
        String strHasAppID = hasAppID();
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            String strM = kotlin.jvm.internal.s.m(CONTENT_PROVIDER_BASE, strHasAppID);
            if (packageManager.resolveContentProvider(strM, 0) != null) {
                return;
            }
            kotlin.jvm.internal.x xVar = kotlin.jvm.internal.x.f3460a;
            String str = String.format(CONTENT_PROVIDER_NOT_FOUND_REASON, Arrays.copyOf(new Object[]{strM}, 1));
            kotlin.jvm.internal.s.d(str, "java.lang.String.format(format, *args)");
            throw new IllegalStateException(str.toString());
        }
    }

    @JvmStatic
    public static final boolean hasCustomTabRedirectActivity(@NotNull Context context, @NotNull String redirectURI) {
        List<ResolveInfo> listQueryIntentActivities;
        kotlin.jvm.internal.s.e(context, "context");
        kotlin.jvm.internal.s.e(redirectURI, "redirectURI");
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setData(Uri.parse(redirectURI));
            listQueryIntentActivities = packageManager.queryIntentActivities(intent, 64);
        } else {
            listQueryIntentActivities = null;
        }
        if (listQueryIntentActivities == null) {
            return false;
        }
        Iterator<ResolveInfo> it = listQueryIntentActivities.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            ActivityInfo activityInfo = it.next().activityInfo;
            if (!kotlin.jvm.internal.s.a(activityInfo.name, "com.facebook.CustomTabActivity") || !kotlin.jvm.internal.s.a(activityInfo.packageName, context.getPackageName())) {
                return false;
            }
            z2 = true;
        }
        return z2;
    }

    @JvmStatic
    public static final void hasFacebookActivity(@NotNull Context context) throws PackageManager.NameNotFoundException {
        kotlin.jvm.internal.s.e(context, "context");
        hasFacebookActivity(context, true);
    }

    @JvmStatic
    public static final void hasInternetPermissions(@NotNull Context context) {
        kotlin.jvm.internal.s.e(context, "context");
        hasInternetPermissions(context, true);
    }

    @JvmStatic
    public static final boolean hasLocationPermission(@NotNull Context context) {
        kotlin.jvm.internal.s.e(context, "context");
        return hasPermission(context, "android.permission.ACCESS_COARSE_LOCATION") || hasPermission(context, "android.permission.ACCESS_FINE_LOCATION");
    }

    @JvmStatic
    public static final boolean hasPermission(@NotNull Context context, @NotNull String permission) {
        kotlin.jvm.internal.s.e(context, "context");
        kotlin.jvm.internal.s.e(permission, "permission");
        return context.checkCallingOrSelfPermission(permission) == 0;
    }

    @JvmStatic
    public static final boolean hasWiFiPermission(@NotNull Context context) {
        kotlin.jvm.internal.s.e(context, "context");
        return hasPermission(context, "android.permission.ACCESS_WIFI_STATE");
    }

    @JvmStatic
    public static final <T> void notEmpty(@NotNull Collection<? extends T> container, @NotNull String name) {
        kotlin.jvm.internal.s.e(container, "container");
        kotlin.jvm.internal.s.e(name, "name");
        if (!container.isEmpty()) {
            return;
        }
        throw new IllegalArgumentException(("Container '" + name + "' cannot be empty").toString());
    }

    @JvmStatic
    public static final <T> void notEmptyAndContainsNoNulls(@NotNull Collection<? extends T> container, @NotNull String name) {
        kotlin.jvm.internal.s.e(container, "container");
        kotlin.jvm.internal.s.e(name, "name");
        containsNoNulls(container, name);
        notEmpty(container, name);
    }

    @JvmStatic
    public static final void notNull(@Nullable Object obj, @NotNull String name) {
        kotlin.jvm.internal.s.e(name, "name");
        if (obj != null) {
            return;
        }
        throw new NullPointerException("Argument '" + name + "' cannot be null");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0015  */
    @kotlin.jvm.JvmStatic
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.String notNullOrEmpty(@org.jetbrains.annotations.Nullable java.lang.String r3, @org.jetbrains.annotations.NotNull java.lang.String r4) {
        /*
            java.lang.String r0 = "name"
            kotlin.jvm.internal.s.e(r4, r0)
            r0 = 1
            r1 = 0
            if (r3 == 0) goto L15
            int r2 = r3.length()
            if (r2 <= 0) goto L11
            r2 = 1
            goto L12
        L11:
            r2 = 0
        L12:
            if (r2 == 0) goto L15
            goto L16
        L15:
            r0 = 0
        L16:
            if (r0 == 0) goto L19
            return r3
        L19:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r0 = "Argument '"
            r3.append(r0)
            r3.append(r4)
            java.lang.String r4 = "' cannot be null or empty"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r3 = r3.toString()
            r4.<init>(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.Validate.notNullOrEmpty(java.lang.String, java.lang.String):java.lang.String");
    }

    @JvmStatic
    public static final void oneOf(@Nullable Object arg, @NotNull String name, @NotNull Object... values) {
        kotlin.jvm.internal.s.e(name, "name");
        kotlin.jvm.internal.s.e(values, "values");
        int length = values.length;
        int i2 = 0;
        while (i2 < length) {
            Object obj = values[i2];
            i2++;
            if (kotlin.jvm.internal.s.a(obj, arg)) {
                return;
            }
        }
        throw new IllegalArgumentException("Argument '" + name + "' was not one of the allowed values");
    }

    @JvmStatic
    public static final void runningOnUiThread() {
        if (!kotlin.jvm.internal.s.a(Looper.getMainLooper(), Looper.myLooper())) {
            throw new FacebookException("This method should be called from the UI thread");
        }
    }

    @JvmStatic
    public static final void sdkInitialized() {
        if (!FacebookSdk.isInitialized()) {
            throw new FacebookSdkNotInitializedException("The SDK has not been initialized, make sure to call FacebookSdk.sdkInitialize() first.");
        }
    }

    @JvmStatic
    @SuppressLint({"WrongConstant"})
    public static final void hasFacebookActivity(@NotNull Context context, boolean z2) throws PackageManager.NameNotFoundException {
        ActivityInfo activityInfo;
        kotlin.jvm.internal.s.e(context, "context");
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                activityInfo = packageManager.getActivityInfo(new ComponentName(context, "com.facebook.FacebookActivity"), 1);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        } else {
            activityInfo = null;
        }
        if (activityInfo == null) {
            if (!(!z2)) {
                throw new IllegalStateException(FACEBOOK_ACTIVITY_NOT_FOUND_REASON.toString());
            }
            Log.w(TAG, FACEBOOK_ACTIVITY_NOT_FOUND_REASON);
        }
    }

    @JvmStatic
    public static final void hasInternetPermissions(@NotNull Context context, boolean z2) {
        kotlin.jvm.internal.s.e(context, "context");
        if (context.checkCallingOrSelfPermission("android.permission.INTERNET") == -1) {
            if (!(!z2)) {
                throw new IllegalStateException(NO_INTERNET_PERMISSION_REASON.toString());
            }
            Log.w(TAG, NO_INTERNET_PERMISSION_REASON);
        }
    }

    @JvmStatic
    public static final void notEmpty(@NotNull String arg, @NotNull String name) {
        kotlin.jvm.internal.s.e(arg, "arg");
        kotlin.jvm.internal.s.e(name, "name");
        if (arg.length() > 0) {
            return;
        }
        throw new IllegalArgumentException(("Argument '" + name + "' cannot be empty").toString());
    }
}
