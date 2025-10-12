package com.facebook.appevents.iap;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import androidx.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.share.internal.ShareConstants;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.DataUtil;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.s;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: InAppPurchaseEventManager.kt */
@Metadata(bv = {}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bR\u0010SJ\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007JF\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\r\u001a\u00020\fH\u0007JF\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\r\u001a\u00020\fH\u0002J,\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00112\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tH\u0002J\u001c\u0010\u0015\u001a\u00020\u00142\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u000eH\u0002J\"\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0016\u001a\u00020\bH\u0002J*\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0007J*\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0007J2\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0016\u001a\u00020\bH\u0002J*\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0007J0\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\bH\u0002J0\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tH\u0002J\u001e\u0010#\u001a\u0004\u0018\u00010\"2\n\u0010 \u001a\u0006\u0012\u0002\b\u00030\u001f2\u0006\u0010!\u001a\u00020\bH\u0002J\u001e\u0010%\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\bH\u0002JC\u0010)\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\b2\u0006\u0010!\u001a\u00020\b2\b\u0010&\u001a\u0004\u0018\u00010\u00012\u000e\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010'H\u0002¢\u0006\u0004\b)\u0010*J\b\u0010+\u001a\u00020\u0014H\u0007J\u000e\u0010-\u001a\u00020\f2\u0006\u0010,\u001a\u00020\bR0\u00100\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\"0.j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\"`/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R8\u00102\u001a&\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001f0.j\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001f`/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00101R\u0014\u00104\u001a\u0002038\u0002X\u0082T¢\u0006\u0006\n\u0004\b4\u00105R\u0014\u00106\u001a\u0002038\u0002X\u0082T¢\u0006\u0006\n\u0004\b6\u00105R\u0014\u00107\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b7\u00108R\u0014\u00109\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b9\u00108R\u0014\u0010:\u001a\u0002038\u0002X\u0082T¢\u0006\u0006\n\u0004\b:\u00105R\u0014\u0010;\u001a\u0002038\u0002X\u0082T¢\u0006\u0006\n\u0004\b;\u00105R\u0014\u0010<\u001a\u0002038\u0002X\u0082T¢\u0006\u0006\n\u0004\b<\u00105R\u0014\u0010=\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b=\u00108R\u0014\u0010>\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b>\u00108R\u0014\u0010?\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b?\u00108R\u0014\u0010@\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b@\u00108R\u0014\u0010A\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\bA\u00108R\u0014\u0010B\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\bB\u00108R\u0014\u0010C\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\bC\u00108R\u0014\u0010D\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\bD\u00108R\u0014\u0010E\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\bE\u00108R\u0014\u0010F\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\bF\u00108R\u0014\u0010G\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\bG\u00108R\u0014\u0010H\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\bH\u00108R\u0014\u0010I\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\bI\u00108R\u001c\u0010K\u001a\n J*\u0004\u0018\u00010\b0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u00108R\u0014\u0010L\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\bL\u00108R\u0014\u0010M\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\bM\u00108R\u001c\u0010O\u001a\n J*\u0004\u0018\u00010N0N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u001c\u0010Q\u001a\n J*\u0004\u0018\u00010N0N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010P¨\u0006T"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseEventManager;", "", "Landroid/content/Context;", "context", "Landroid/os/IBinder;", "service", InAppPurchaseEventManager.AS_INTERFACE, "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "skuList", "inAppBillingObj", "", "isSubscription", "", InAppPurchaseEventManager.GET_SKU_DETAILS, "getSkuDetailsFromGoogle", "", "readSkuDetailsFromCache", "skuDetailsMap", "Lkotlin/t;", "writeSkuDetailsToCache", ShareConstants.MEDIA_TYPE, InAppPurchaseEventManager.IS_BILLING_SUPPORTED, "getPurchasesInapp", "getPurchasesSubs", InAppPurchaseEventManager.GET_PURCHASES, "getPurchaseHistoryInapp", InAppPurchaseEventManager.GET_PURCHASE_HISTORY, "purchases", "filterPurchases", "Ljava/lang/Class;", "classObj", "methodName", "Ljava/lang/reflect/Method;", "getMethod", "className", "getClass", "obj", "", "args", "invokeMethod", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", "clearSkuDetailsCache", "skuDetail", "hasFreeTrialPeirod", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "methodMap", "Ljava/util/HashMap;", "classMap", "", "CACHE_CLEAR_TIME_LIMIT_SEC", "I", "SKU_DETAIL_EXPIRE_TIME_SEC", "SUBSCRIPTION", "Ljava/lang/String;", "INAPP", "PURCHASE_EXPIRE_TIME_SEC", "PURCHASE_STOP_QUERY_TIME_SEC", "MAX_QUERY_PURCHASE_NUM", "IN_APP_BILLING_SERVICE_STUB", "IN_APP_BILLING_SERVICE", "AS_INTERFACE", "GET_SKU_DETAILS", "GET_PURCHASES", "GET_PURCHASE_HISTORY", "IS_BILLING_SUPPORTED", InAppPurchaseEventManager.ITEM_ID_LIST, InAppPurchaseEventManager.RESPONSE_CODE, InAppPurchaseEventManager.DETAILS_LIST, InAppPurchaseEventManager.INAPP_PURCHASE_DATA_LIST, InAppPurchaseEventManager.INAPP_CONTINUATION_TOKEN, InAppPurchaseEventManager.LAST_CLEARED_TIME, "kotlin.jvm.PlatformType", "PACKAGE_NAME", "SKU_DETAILS_STORE", "PURCHASE_INAPP_STORE", "Landroid/content/SharedPreferences;", "skuDetailSharedPrefs", "Landroid/content/SharedPreferences;", "purchaseInappSharedPrefs", "<init>", "()V", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class InAppPurchaseEventManager {

    @NotNull
    private static final String AS_INTERFACE = "asInterface";
    private static final int CACHE_CLEAR_TIME_LIMIT_SEC = 604800;

    @NotNull
    private static final String DETAILS_LIST = "DETAILS_LIST";

    @NotNull
    private static final String GET_PURCHASES = "getPurchases";

    @NotNull
    private static final String GET_PURCHASE_HISTORY = "getPurchaseHistory";

    @NotNull
    private static final String GET_SKU_DETAILS = "getSkuDetails";

    @NotNull
    private static final String INAPP = "inapp";

    @NotNull
    private static final String INAPP_CONTINUATION_TOKEN = "INAPP_CONTINUATION_TOKEN";

    @NotNull
    private static final String INAPP_PURCHASE_DATA_LIST = "INAPP_PURCHASE_DATA_LIST";

    @NotNull
    private static final String IN_APP_BILLING_SERVICE = "com.android.vending.billing.IInAppBillingService";

    @NotNull
    private static final String IN_APP_BILLING_SERVICE_STUB = "com.android.vending.billing.IInAppBillingService$Stub";

    @NotNull
    private static final String IS_BILLING_SUPPORTED = "isBillingSupported";

    @NotNull
    private static final String ITEM_ID_LIST = "ITEM_ID_LIST";

    @NotNull
    private static final String LAST_CLEARED_TIME = "LAST_CLEARED_TIME";
    private static final int MAX_QUERY_PURCHASE_NUM = 30;
    private static final int PURCHASE_EXPIRE_TIME_SEC = 86400;
    private static final int PURCHASE_STOP_QUERY_TIME_SEC = 1200;

    @NotNull
    private static final String RESPONSE_CODE = "RESPONSE_CODE";
    private static final int SKU_DETAIL_EXPIRE_TIME_SEC = 43200;

    @NotNull
    private static final String SUBSCRIPTION = "subs";

    @NotNull
    public static final InAppPurchaseEventManager INSTANCE = new InAppPurchaseEventManager();

    @NotNull
    private static final HashMap<String, Method> methodMap = new HashMap<>();

    @NotNull
    private static final HashMap<String, Class<?>> classMap = new HashMap<>();
    private static final String PACKAGE_NAME = FacebookSdk.getApplicationContext().getPackageName();

    @NotNull
    private static final String SKU_DETAILS_STORE = "com.facebook.internal.SKU_DETAILS";
    private static final SharedPreferences skuDetailSharedPrefs = FacebookSdk.getApplicationContext().getSharedPreferences(SKU_DETAILS_STORE, 0);

    @NotNull
    private static final String PURCHASE_INAPP_STORE = "com.facebook.internal.PURCHASE";
    private static final SharedPreferences purchaseInappSharedPrefs = FacebookSdk.getApplicationContext().getSharedPreferences(PURCHASE_INAPP_STORE, 0);

    private InAppPurchaseEventManager() {
    }

    @JvmStatic
    @Nullable
    public static final Object asInterface(@NotNull Context context, @Nullable IBinder service) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseEventManager.class)) {
            return null;
        }
        try {
            s.e(context, "context");
            return INSTANCE.invokeMethod(context, IN_APP_BILLING_SERVICE_STUB, AS_INTERFACE, null, new Object[]{service});
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseEventManager.class);
            return null;
        }
    }

    @JvmStatic
    public static final void clearSkuDetailsCache() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseEventManager.class)) {
            return;
        }
        try {
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            SharedPreferences sharedPreferences = skuDetailSharedPrefs;
            long j2 = sharedPreferences.getLong(LAST_CLEARED_TIME, 0L);
            if (j2 == 0) {
                sharedPreferences.edit().putLong(LAST_CLEARED_TIME, jCurrentTimeMillis).apply();
            } else if (jCurrentTimeMillis - j2 > CACHE_CLEAR_TIME_LIMIT_SEC) {
                sharedPreferences.edit().clear().putLong(LAST_CLEARED_TIME, jCurrentTimeMillis).apply();
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseEventManager.class);
        }
    }

    private final ArrayList<String> filterPurchases(ArrayList<String> purchases) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            ArrayList<String> arrayList = new ArrayList<>();
            SharedPreferences.Editor editorEdit = purchaseInappSharedPrefs.edit();
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            Iterator<String> it = purchases.iterator();
            while (it.hasNext()) {
                String next = it.next();
                try {
                    JSONObject jSONObject = new JSONObject(next);
                    String string = jSONObject.getString(DataUtil.ORDER_COLUMN.ORDER_PRODUCT_ID);
                    long j2 = jSONObject.getLong("purchaseTime");
                    String string2 = jSONObject.getString("purchaseToken");
                    if (jCurrentTimeMillis - (j2 / 1000) <= 86400 && !s.a(purchaseInappSharedPrefs.getString(string, ""), string2)) {
                        editorEdit.putString(string, string2);
                        arrayList.add(next);
                    }
                } catch (JSONException unused) {
                }
            }
            editorEdit.apply();
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final Class<?> getClass(Context context, String className) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            HashMap<String, Class<?>> map = classMap;
            Class<?> cls = map.get(className);
            if (cls != null) {
                return cls;
            }
            Class<?> classFromContext$facebook_core_release = InAppPurchaseUtils.getClassFromContext$facebook_core_release(context, className);
            if (classFromContext$facebook_core_release != null) {
                map.put(className, classFromContext$facebook_core_release);
            }
            return classFromContext$facebook_core_release;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final Method getMethod(Class<?> classObj, String methodName) {
        Class[] clsArr;
        Method declaredMethod$facebook_core_release;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            HashMap<String, Method> map = methodMap;
            Method method = map.get(methodName);
            if (method != null) {
                return method;
            }
            switch (methodName.hashCode()) {
                case -1801122596:
                    if (!methodName.equals(GET_PURCHASES)) {
                        clsArr = null;
                        break;
                    } else {
                        Class TYPE = Integer.TYPE;
                        s.d(TYPE, "TYPE");
                        clsArr = new Class[]{TYPE, String.class, String.class, String.class};
                        break;
                    }
                case -1450694211:
                    if (!methodName.equals(IS_BILLING_SUPPORTED)) {
                        clsArr = null;
                        break;
                    } else {
                        Class TYPE2 = Integer.TYPE;
                        s.d(TYPE2, "TYPE");
                        clsArr = new Class[]{TYPE2, String.class, String.class};
                        break;
                    }
                case -1123215065:
                    if (!methodName.equals(AS_INTERFACE)) {
                        clsArr = null;
                        break;
                    } else {
                        clsArr = new Class[]{IBinder.class};
                        break;
                    }
                case -594356707:
                    if (!methodName.equals(GET_PURCHASE_HISTORY)) {
                        clsArr = null;
                        break;
                    } else {
                        Class TYPE3 = Integer.TYPE;
                        s.d(TYPE3, "TYPE");
                        clsArr = new Class[]{TYPE3, String.class, String.class, String.class, Bundle.class};
                        break;
                    }
                case -573310373:
                    if (!methodName.equals(GET_SKU_DETAILS)) {
                        clsArr = null;
                        break;
                    } else {
                        Class TYPE4 = Integer.TYPE;
                        s.d(TYPE4, "TYPE");
                        clsArr = new Class[]{TYPE4, String.class, String.class, Bundle.class};
                        break;
                    }
                default:
                    clsArr = null;
                    break;
            }
            if (clsArr == null) {
                declaredMethod$facebook_core_release = InAppPurchaseUtils.getDeclaredMethod$facebook_core_release(classObj, methodName, null);
            } else {
                InAppPurchaseUtils inAppPurchaseUtils = InAppPurchaseUtils.INSTANCE;
                declaredMethod$facebook_core_release = InAppPurchaseUtils.getDeclaredMethod$facebook_core_release(classObj, methodName, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
            }
            if (declaredMethod$facebook_core_release != null) {
                map.put(methodName, declaredMethod$facebook_core_release);
            }
            return declaredMethod$facebook_core_release;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.ArrayList<java.lang.String> getPurchaseHistory(android.content.Context r19, java.lang.Object r20, java.lang.String r21) {
        /*
            r18 = this;
            boolean r0 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r18)
            r1 = 0
            if (r0 == 0) goto L8
            return r1
        L8:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L9b
            r0.<init>()     // Catch: java.lang.Throwable -> L9b
            boolean r2 = r18.isBillingSupported(r19, r20, r21)     // Catch: java.lang.Throwable -> L9b
            if (r2 == 0) goto L9a
            r2 = 0
            r3 = r1
            r4 = 0
            r5 = 0
        L17:
            r6 = 5
            java.lang.Object[] r12 = new java.lang.Object[r6]     // Catch: java.lang.Throwable -> L9b
            r6 = 6
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> L9b
            r12[r2] = r6     // Catch: java.lang.Throwable -> L9b
            java.lang.String r6 = com.facebook.appevents.iap.InAppPurchaseEventManager.PACKAGE_NAME     // Catch: java.lang.Throwable -> L9b
            r13 = 1
            r12[r13] = r6     // Catch: java.lang.Throwable -> L9b
            r6 = 2
            r12[r6] = r21     // Catch: java.lang.Throwable -> L9b
            r6 = 3
            r12[r6] = r3     // Catch: java.lang.Throwable -> L9b
            r3 = 4
            android.os.Bundle r6 = new android.os.Bundle     // Catch: java.lang.Throwable -> L9b
            r6.<init>()     // Catch: java.lang.Throwable -> L9b
            r12[r3] = r6     // Catch: java.lang.Throwable -> L9b
            java.lang.String r9 = "com.android.vending.billing.IInAppBillingService"
            java.lang.String r10 = "getPurchaseHistory"
            r7 = r18
            r8 = r19
            r11 = r20
            java.lang.Object r3 = r7.invokeMethod(r8, r9, r10, r11, r12)     // Catch: java.lang.Throwable -> L9b
            if (r3 == 0) goto L91
            long r6 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L9b
            r8 = 1000(0x3e8, double:4.94E-321)
            long r6 = r6 / r8
            android.os.Bundle r3 = (android.os.Bundle) r3     // Catch: java.lang.Throwable -> L9b
            java.lang.String r10 = "RESPONSE_CODE"
            int r10 = r3.getInt(r10)     // Catch: java.lang.Throwable -> L9b
            if (r10 != 0) goto L91
            java.lang.String r10 = "INAPP_PURCHASE_DATA_LIST"
            java.util.ArrayList r10 = r3.getStringArrayList(r10)     // Catch: java.lang.Throwable -> L9b
            if (r10 != 0) goto L5e
            goto L91
        L5e:
            java.util.Iterator r10 = r10.iterator()     // Catch: java.lang.Throwable -> L9b
        L62:
            boolean r11 = r10.hasNext()     // Catch: java.lang.Throwable -> L9b
            if (r11 == 0) goto L8a
            java.lang.Object r11 = r10.next()     // Catch: java.lang.Throwable -> L9b
            java.lang.String r11 = (java.lang.String) r11     // Catch: java.lang.Throwable -> L9b
            org.json.JSONObject r12 = new org.json.JSONObject     // Catch: org.json.JSONException -> L62 java.lang.Throwable -> L9b
            r12.<init>(r11)     // Catch: org.json.JSONException -> L62 java.lang.Throwable -> L9b
            java.lang.String r14 = "purchaseTime"
            long r14 = r12.getLong(r14)     // Catch: org.json.JSONException -> L62 java.lang.Throwable -> L9b
            long r14 = r14 / r8
            long r14 = r6 - r14
            r16 = 1200(0x4b0, double:5.93E-321)
            int r12 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r12 <= 0) goto L84
            r5 = 1
            goto L8a
        L84:
            r0.add(r11)     // Catch: org.json.JSONException -> L62 java.lang.Throwable -> L9b
            int r4 = r4 + 1
            goto L62
        L8a:
            java.lang.String r6 = "INAPP_CONTINUATION_TOKEN"
            java.lang.String r3 = r3.getString(r6)     // Catch: java.lang.Throwable -> L9b
            goto L92
        L91:
            r3 = r1
        L92:
            r6 = 30
            if (r4 >= r6) goto L9a
            if (r3 == 0) goto L9a
            if (r5 == 0) goto L17
        L9a:
            return r0
        L9b:
            r0 = move-exception
            r2 = r18
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r0, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.iap.InAppPurchaseEventManager.getPurchaseHistory(android.content.Context, java.lang.Object, java.lang.String):java.util.ArrayList");
    }

    @JvmStatic
    @NotNull
    public static final ArrayList<String> getPurchaseHistoryInapp(@NotNull Context context, @Nullable Object inAppBillingObj) {
        InAppPurchaseEventManager inAppPurchaseEventManager;
        Class<?> cls;
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseEventManager.class)) {
            return null;
        }
        try {
            s.e(context, "context");
            ArrayList<String> arrayList = new ArrayList<>();
            return (inAppBillingObj == null || (cls = (inAppPurchaseEventManager = INSTANCE).getClass(context, IN_APP_BILLING_SERVICE)) == null || inAppPurchaseEventManager.getMethod(cls, GET_PURCHASE_HISTORY) == null) ? arrayList : inAppPurchaseEventManager.filterPurchases(inAppPurchaseEventManager.getPurchaseHistory(context, inAppBillingObj, "inapp"));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseEventManager.class);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.ArrayList<java.lang.String> getPurchases(android.content.Context r13, java.lang.Object r14, java.lang.String r15) {
        /*
            r12 = this;
            boolean r0 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r12)
            r1 = 0
            if (r0 == 0) goto L8
            return r1
        L8:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L63
            r0.<init>()     // Catch: java.lang.Throwable -> L63
            if (r14 != 0) goto L10
            return r0
        L10:
            boolean r2 = r12.isBillingSupported(r13, r14, r15)     // Catch: java.lang.Throwable -> L63
            if (r2 == 0) goto L62
            r2 = 0
            r3 = r1
            r4 = 0
        L19:
            r5 = 4
            java.lang.Object[] r11 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L63
            r5 = 3
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> L63
            r11[r2] = r6     // Catch: java.lang.Throwable -> L63
            r6 = 1
            java.lang.String r7 = com.facebook.appevents.iap.InAppPurchaseEventManager.PACKAGE_NAME     // Catch: java.lang.Throwable -> L63
            r11[r6] = r7     // Catch: java.lang.Throwable -> L63
            r6 = 2
            r11[r6] = r15     // Catch: java.lang.Throwable -> L63
            r11[r5] = r3     // Catch: java.lang.Throwable -> L63
            java.lang.String r8 = "com.android.vending.billing.IInAppBillingService"
            java.lang.String r9 = "getPurchases"
            r6 = r12
            r7 = r13
            r10 = r14
            java.lang.Object r3 = r6.invokeMethod(r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L63
            if (r3 == 0) goto L5b
            android.os.Bundle r3 = (android.os.Bundle) r3     // Catch: java.lang.Throwable -> L63
            java.lang.String r5 = "RESPONSE_CODE"
            int r5 = r3.getInt(r5)     // Catch: java.lang.Throwable -> L63
            if (r5 != 0) goto L5b
            java.lang.String r5 = "INAPP_PURCHASE_DATA_LIST"
            java.util.ArrayList r5 = r3.getStringArrayList(r5)     // Catch: java.lang.Throwable -> L63
            if (r5 == 0) goto L62
            int r6 = r5.size()     // Catch: java.lang.Throwable -> L63
            int r4 = r4 + r6
            r0.addAll(r5)     // Catch: java.lang.Throwable -> L63
            java.lang.String r5 = "INAPP_CONTINUATION_TOKEN"
            java.lang.String r3 = r3.getString(r5)     // Catch: java.lang.Throwable -> L63
            goto L5c
        L5b:
            r3 = r1
        L5c:
            r5 = 30
            if (r4 >= r5) goto L62
            if (r3 != 0) goto L19
        L62:
            return r0
        L63:
            r13 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r13, r12)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.iap.InAppPurchaseEventManager.getPurchases(android.content.Context, java.lang.Object, java.lang.String):java.util.ArrayList");
    }

    @JvmStatic
    @NotNull
    public static final ArrayList<String> getPurchasesInapp(@NotNull Context context, @Nullable Object inAppBillingObj) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseEventManager.class)) {
            return null;
        }
        try {
            s.e(context, "context");
            InAppPurchaseEventManager inAppPurchaseEventManager = INSTANCE;
            return inAppPurchaseEventManager.filterPurchases(inAppPurchaseEventManager.getPurchases(context, inAppBillingObj, "inapp"));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseEventManager.class);
            return null;
        }
    }

    @JvmStatic
    @NotNull
    public static final ArrayList<String> getPurchasesSubs(@NotNull Context context, @Nullable Object inAppBillingObj) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseEventManager.class)) {
            return null;
        }
        try {
            s.e(context, "context");
            InAppPurchaseEventManager inAppPurchaseEventManager = INSTANCE;
            return inAppPurchaseEventManager.filterPurchases(inAppPurchaseEventManager.getPurchases(context, inAppBillingObj, "subs"));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseEventManager.class);
            return null;
        }
    }

    @JvmStatic
    @NotNull
    public static final Map<String, String> getSkuDetails(@NotNull Context context, @NotNull ArrayList<String> skuList, @Nullable Object inAppBillingObj, boolean isSubscription) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseEventManager.class)) {
            return null;
        }
        try {
            s.e(context, "context");
            s.e(skuList, "skuList");
            Map<String, String> skuDetailsFromCache = INSTANCE.readSkuDetailsFromCache(skuList);
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator<String> it = skuList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!skuDetailsFromCache.containsKey(next)) {
                    arrayList.add(next);
                }
            }
            skuDetailsFromCache.putAll(INSTANCE.getSkuDetailsFromGoogle(context, arrayList, inAppBillingObj, isSubscription));
            return skuDetailsFromCache;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseEventManager.class);
            return null;
        }
    }

    private final Map<String, String> getSkuDetailsFromGoogle(Context context, ArrayList<String> skuList, Object inAppBillingObj, boolean isSubscription) {
        int size;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Map<String, String> linkedHashMap = new LinkedHashMap<>();
            if (inAppBillingObj != null && !skuList.isEmpty()) {
                Bundle bundle = new Bundle();
                bundle.putStringArrayList(ITEM_ID_LIST, skuList);
                Object[] objArr = new Object[4];
                int i2 = 0;
                objArr[0] = 3;
                objArr[1] = PACKAGE_NAME;
                objArr[2] = isSubscription ? "subs" : "inapp";
                objArr[3] = bundle;
                Object objInvokeMethod = invokeMethod(context, IN_APP_BILLING_SERVICE, GET_SKU_DETAILS, inAppBillingObj, objArr);
                if (objInvokeMethod != null) {
                    Bundle bundle2 = (Bundle) objInvokeMethod;
                    if (bundle2.getInt(RESPONSE_CODE) == 0) {
                        ArrayList<String> stringArrayList = bundle2.getStringArrayList(DETAILS_LIST);
                        if (stringArrayList != null && skuList.size() == stringArrayList.size() && skuList.size() - 1 >= 0) {
                            while (true) {
                                int i3 = i2 + 1;
                                String str = skuList.get(i2);
                                s.d(str, "skuList[i]");
                                String str2 = stringArrayList.get(i2);
                                s.d(str2, "skuDetailsList[i]");
                                linkedHashMap.put(str, str2);
                                if (i3 > size) {
                                    break;
                                }
                                i2 = i3;
                            }
                        }
                        writeSkuDetailsToCache(linkedHashMap);
                    }
                }
            }
            return linkedHashMap;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final Object invokeMethod(Context context, String className, String methodName, Object obj, Object[] args) {
        Method method;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Class<?> cls = getClass(context, className);
            if (cls == null || (method = getMethod(cls, methodName)) == null) {
                return null;
            }
            InAppPurchaseUtils inAppPurchaseUtils = InAppPurchaseUtils.INSTANCE;
            return InAppPurchaseUtils.invokeMethod(cls, method, obj, Arrays.copyOf(args, args.length));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final boolean isBillingSupported(Context context, Object inAppBillingObj, String type) {
        if (CrashShieldHandler.isObjectCrashing(this) || inAppBillingObj == null) {
            return false;
        }
        try {
            Object objInvokeMethod = invokeMethod(context, IN_APP_BILLING_SERVICE, IS_BILLING_SUPPORTED, inAppBillingObj, new Object[]{3, PACKAGE_NAME, type});
            if (objInvokeMethod != null) {
                return ((Integer) objInvokeMethod).intValue() == 0;
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    private final Map<String, String> readSkuDetailsFromCache(ArrayList<String> skuList) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            Iterator<String> it = skuList.iterator();
            while (it.hasNext()) {
                String sku = it.next();
                String string = skuDetailSharedPrefs.getString(sku, null);
                if (string != null) {
                    List listC0 = StringsKt__StringsKt.c0(string, new String[]{";"}, false, 2, 2, null);
                    if (jCurrentTimeMillis - Long.parseLong((String) listC0.get(0)) < 43200) {
                        s.d(sku, "sku");
                        linkedHashMap.put(sku, listC0.get(1));
                    }
                }
            }
            return linkedHashMap;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final void writeSkuDetailsToCache(Map<String, String> map) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            SharedPreferences.Editor editorEdit = skuDetailSharedPrefs.edit();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                editorEdit.putString(entry.getKey(), jCurrentTimeMillis + ';' + entry.getValue());
            }
            editorEdit.apply();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public final boolean hasFreeTrialPeirod(@NotNull String skuDetail) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            s.e(skuDetail, "skuDetail");
            try {
                String strOptString = new JSONObject(skuDetail).optString("freeTrialPeriod");
                if (strOptString != null) {
                    return strOptString.length() > 0;
                }
                return false;
            } catch (JSONException unused) {
                return false;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }
}
