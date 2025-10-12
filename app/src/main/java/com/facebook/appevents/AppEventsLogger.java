package com.facebook.appevents;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.webkit.WebView;
import androidx.annotation.RestrictTo;
import com.adjust.sdk.Constants;
import com.facebook.AccessToken;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.DataUtil;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Currency;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AppEventsLogger.kt */
@Metadata(bv = {}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 /2\u00020\u0001:\u0004/012B%\b\u0002\u0012\u0006\u0010,\u001a\u00020+\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\"\u001a\u0004\u0018\u00010!¢\u0006\u0004\b-\u0010.J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0018\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bJ\"\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u001a\u0010\u000e\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fJ$\u0010\u000e\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\bJ\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002J\u0088\u0001\u0010\u001f\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0006\u0010 \u001a\u00020\u0004J\u000e\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020!R\u0014\u0010&\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0011\u0010*\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u00063"}, d2 = {"Lcom/facebook/appevents/AppEventsLogger;", "", "", "eventName", "Lkotlin/t;", "logEvent", "", "valueToSum", "Landroid/os/Bundle;", "parameters", "Ljava/math/BigDecimal;", "purchaseAmount", "Ljava/util/Currency;", DataUtil.ORDER_LIST_COLUMN.CURRENCY, "logPurchase", "payload", "logPushNotificationOpen", NativeProtocol.WEB_DIALOG_ACTION, "itemID", "Lcom/facebook/appevents/AppEventsLogger$ProductAvailability;", "availability", "Lcom/facebook/appevents/AppEventsLogger$ProductCondition;", "condition", "description", "imageLink", "link", ShareConstants.WEB_DIALOG_PARAM_TITLE, "priceAmount", "gtin", "mpn", "brand", "logProductItem", "flush", "Lcom/facebook/AccessToken;", "accessToken", "", "isValidForAccessToken", "Lcom/facebook/appevents/AppEventsLoggerImpl;", "loggerImpl", "Lcom/facebook/appevents/AppEventsLoggerImpl;", "getApplicationId", "()Ljava/lang/String;", "applicationId", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lcom/facebook/AccessToken;)V", "Companion", "FlushBehavior", "ProductAvailability", "ProductCondition", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AppEventsLogger {

    @NotNull
    public static final String ACTION_APP_EVENTS_FLUSHED = "com.facebook.sdk.APP_EVENTS_FLUSHED";

    @NotNull
    public static final String APP_EVENTS_EXTRA_FLUSH_RESULT = "com.facebook.sdk.APP_EVENTS_FLUSH_RESULT";

    @NotNull
    public static final String APP_EVENTS_EXTRA_NUM_EVENTS_FLUSHED = "com.facebook.sdk.APP_EVENTS_NUM_EVENTS_FLUSHED";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = AppEventsLogger.class.getCanonicalName();

    @NotNull
    private final AppEventsLoggerImpl loggerImpl;

    /* compiled from: AppEventsLogger.kt */
    @Metadata(bv = {}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b3\u00104J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u001a\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\bH\u0007J\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0007J$\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0007J\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0007J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000fH\u0007J\b\u0010\u0013\u001a\u00020\u0004H\u0007J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006H\u0007J\u001a\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0007J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010\u001b\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0006H\u0007J\b\u0010\u001c\u001a\u00020\u0004H\u0007Jl\u0010'\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u00062\b\u0010 \u001a\u0004\u0018\u00010\u00062\b\u0010!\u001a\u0004\u0018\u00010\u00062\b\u0010\"\u001a\u0004\u0018\u00010\u00062\b\u0010#\u001a\u0004\u0018\u00010\u00062\b\u0010$\u001a\u0004\u0018\u00010\u00062\b\u0010%\u001a\u0004\u0018\u00010\u00062\b\u0010&\u001a\u0004\u0018\u00010\u0006H\u0007J\b\u0010(\u001a\u00020\u0006H\u0007J\b\u0010)\u001a\u00020\u0004H\u0007J\u0010\u0010*\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007J\u0012\u0010,\u001a\u00020\u00042\b\u0010+\u001a\u0004\u0018\u00010\u0006H\u0007R\u0014\u0010-\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u0010/\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b/\u0010.R\u0014\u00100\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b0\u0010.R\u001c\u00102\u001a\n 1*\u0004\u0018\u00010\u00060\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u0010.¨\u00065"}, d2 = {"Lcom/facebook/appevents/AppEventsLogger$Companion;", "", "Landroid/app/Application;", "application", "Lkotlin/t;", "activateApp", "", "applicationId", "Landroid/content/Context;", "context", "initializeLib", "Lcom/facebook/appevents/AppEventsLogger;", "newLogger", "Lcom/facebook/AccessToken;", "accessToken", "Lcom/facebook/appevents/AppEventsLogger$FlushBehavior;", "getFlushBehavior", "flushBehavior", "setFlushBehavior", "onContextStop", "registrationId", "setPushNotificationsRegistrationId", "Landroid/webkit/WebView;", "webView", "augmentWebView", "getUserID", "userID", "setUserID", "clearUserID", "email", "firstName", "lastName", DataUtil.USER_COLUMN.PHONE, "dateOfBirth", "gender", "city", ServerProtocol.DIALOG_PARAM_STATE, "zip", UserDataStore.COUNTRY, "setUserData", "getUserData", "clearUserData", "getAnonymousAppDeviceGUID", Constants.REFERRER, "setInstallReferrer", "ACTION_APP_EVENTS_FLUSHED", "Ljava/lang/String;", "APP_EVENTS_EXTRA_FLUSH_RESULT", "APP_EVENTS_EXTRA_NUM_EVENTS_FLUSHED", "kotlin.jvm.PlatformType", "TAG", "<init>", "()V", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.o oVar) {
            this();
        }

        @JvmStatic
        public final void activateApp(@NotNull Application application) {
            kotlin.jvm.internal.s.e(application, "application");
            AppEventsLoggerImpl.INSTANCE.activateApp(application, null);
        }

        @JvmStatic
        public final void augmentWebView(@NotNull WebView webView, @Nullable Context context) {
            kotlin.jvm.internal.s.e(webView, "webView");
            AppEventsLoggerImpl.INSTANCE.augmentWebView(webView, context);
        }

        @JvmStatic
        public final void clearUserData() {
            UserDataStore.clear();
        }

        @JvmStatic
        public final void clearUserID() {
            AnalyticsUserIDStore.setUserID(null);
        }

        @JvmStatic
        @NotNull
        public final String getAnonymousAppDeviceGUID(@NotNull Context context) {
            kotlin.jvm.internal.s.e(context, "context");
            return AppEventsLoggerImpl.INSTANCE.getAnonymousAppDeviceGUID(context);
        }

        @JvmStatic
        @Nullable
        public final FlushBehavior getFlushBehavior() {
            return AppEventsLoggerImpl.INSTANCE.getFlushBehavior();
        }

        @JvmStatic
        @NotNull
        public final String getUserData() {
            return UserDataStore.getHashedUserData$facebook_core_release();
        }

        @JvmStatic
        @Nullable
        public final String getUserID() {
            return AnalyticsUserIDStore.getUserID();
        }

        @JvmStatic
        public final void initializeLib(@NotNull Context context, @Nullable String str) {
            kotlin.jvm.internal.s.e(context, "context");
            AppEventsLoggerImpl.INSTANCE.initializeLib(context, str);
        }

        @JvmStatic
        @NotNull
        public final AppEventsLogger newLogger(@NotNull Context context) {
            kotlin.jvm.internal.s.e(context, "context");
            return new AppEventsLogger(context, null, 0 == true ? 1 : 0, 0 == true ? 1 : 0);
        }

        @JvmStatic
        public final void onContextStop() {
            AppEventsLoggerImpl.INSTANCE.onContextStop();
        }

        @JvmStatic
        public final void setFlushBehavior(@NotNull FlushBehavior flushBehavior) {
            kotlin.jvm.internal.s.e(flushBehavior, "flushBehavior");
            AppEventsLoggerImpl.INSTANCE.setFlushBehavior(flushBehavior);
        }

        @JvmStatic
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final void setInstallReferrer(@Nullable String str) {
            AppEventsLoggerImpl.INSTANCE.setInstallReferrer(str);
        }

        @JvmStatic
        public final void setPushNotificationsRegistrationId(@Nullable String str) {
            AppEventsLoggerImpl.INSTANCE.setPushNotificationsRegistrationId(str);
        }

        @JvmStatic
        public final void setUserData(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10) {
            UserDataStore.setUserDataAndHash(str, str2, str3, str4, str5, str6, str7, str8, str9, str10);
        }

        @JvmStatic
        public final void setUserID(@Nullable String str) {
            AnalyticsUserIDStore.setUserID(str);
        }

        @JvmStatic
        public final void activateApp(@NotNull Application application, @Nullable String str) {
            kotlin.jvm.internal.s.e(application, "application");
            AppEventsLoggerImpl.INSTANCE.activateApp(application, str);
        }

        @JvmStatic
        @NotNull
        public final AppEventsLogger newLogger(@NotNull Context context, @Nullable AccessToken accessToken) {
            kotlin.jvm.internal.s.e(context, "context");
            return new AppEventsLogger(context, null, accessToken, 0 == true ? 1 : 0);
        }

        @JvmStatic
        @NotNull
        public final AppEventsLogger newLogger(@NotNull Context context, @Nullable String applicationId, @Nullable AccessToken accessToken) {
            kotlin.jvm.internal.s.e(context, "context");
            return new AppEventsLogger(context, applicationId, accessToken, null);
        }

        @JvmStatic
        @NotNull
        public final AppEventsLogger newLogger(@NotNull Context context, @Nullable String applicationId) {
            kotlin.jvm.internal.s.e(context, "context");
            return new AppEventsLogger(context, applicationId, null, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: AppEventsLogger.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/facebook/appevents/AppEventsLogger$FlushBehavior;", "", "(Ljava/lang/String;I)V", "AUTO", "EXPLICIT_ONLY", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum FlushBehavior {
        AUTO,
        EXPLICIT_ONLY;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static FlushBehavior[] valuesCustom() {
            FlushBehavior[] flushBehaviorArrValuesCustom = values();
            return (FlushBehavior[]) Arrays.copyOf(flushBehaviorArrValuesCustom, flushBehaviorArrValuesCustom.length);
        }
    }

    /* compiled from: AppEventsLogger.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/facebook/appevents/AppEventsLogger$ProductAvailability;", "", "(Ljava/lang/String;I)V", "IN_STOCK", "OUT_OF_STOCK", "PREORDER", "AVALIABLE_FOR_ORDER", "DISCONTINUED", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum ProductAvailability {
        IN_STOCK,
        OUT_OF_STOCK,
        PREORDER,
        AVALIABLE_FOR_ORDER,
        DISCONTINUED;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static ProductAvailability[] valuesCustom() {
            ProductAvailability[] productAvailabilityArrValuesCustom = values();
            return (ProductAvailability[]) Arrays.copyOf(productAvailabilityArrValuesCustom, productAvailabilityArrValuesCustom.length);
        }
    }

    /* compiled from: AppEventsLogger.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/facebook/appevents/AppEventsLogger$ProductCondition;", "", "(Ljava/lang/String;I)V", "NEW", "REFURBISHED", "USED", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum ProductCondition {
        NEW,
        REFURBISHED,
        USED;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static ProductCondition[] valuesCustom() {
            ProductCondition[] productConditionArrValuesCustom = values();
            return (ProductCondition[]) Arrays.copyOf(productConditionArrValuesCustom, productConditionArrValuesCustom.length);
        }
    }

    private AppEventsLogger(Context context, String str, AccessToken accessToken) {
        this.loggerImpl = new AppEventsLoggerImpl(context, str, accessToken);
    }

    public /* synthetic */ AppEventsLogger(Context context, String str, AccessToken accessToken, kotlin.jvm.internal.o oVar) {
        this(context, str, accessToken);
    }

    @JvmStatic
    public static final void activateApp(@NotNull Application application) {
        INSTANCE.activateApp(application);
    }

    @JvmStatic
    public static final void activateApp(@NotNull Application application, @Nullable String str) {
        INSTANCE.activateApp(application, str);
    }

    @JvmStatic
    public static final void augmentWebView(@NotNull WebView webView, @Nullable Context context) {
        INSTANCE.augmentWebView(webView, context);
    }

    @JvmStatic
    public static final void clearUserData() {
        INSTANCE.clearUserData();
    }

    @JvmStatic
    public static final void clearUserID() {
        INSTANCE.clearUserID();
    }

    @JvmStatic
    @NotNull
    public static final String getAnonymousAppDeviceGUID(@NotNull Context context) {
        return INSTANCE.getAnonymousAppDeviceGUID(context);
    }

    @JvmStatic
    @Nullable
    public static final FlushBehavior getFlushBehavior() {
        return INSTANCE.getFlushBehavior();
    }

    @JvmStatic
    @NotNull
    public static final String getUserData() {
        return INSTANCE.getUserData();
    }

    @JvmStatic
    @Nullable
    public static final String getUserID() {
        return INSTANCE.getUserID();
    }

    @JvmStatic
    public static final void initializeLib(@NotNull Context context, @Nullable String str) {
        INSTANCE.initializeLib(context, str);
    }

    @JvmStatic
    @NotNull
    public static final AppEventsLogger newLogger(@NotNull Context context) {
        return INSTANCE.newLogger(context);
    }

    @JvmStatic
    @NotNull
    public static final AppEventsLogger newLogger(@NotNull Context context, @Nullable AccessToken accessToken) {
        return INSTANCE.newLogger(context, accessToken);
    }

    @JvmStatic
    @NotNull
    public static final AppEventsLogger newLogger(@NotNull Context context, @Nullable String str) {
        return INSTANCE.newLogger(context, str);
    }

    @JvmStatic
    @NotNull
    public static final AppEventsLogger newLogger(@NotNull Context context, @Nullable String str, @Nullable AccessToken accessToken) {
        return INSTANCE.newLogger(context, str, accessToken);
    }

    @JvmStatic
    public static final void onContextStop() {
        INSTANCE.onContextStop();
    }

    @JvmStatic
    public static final void setFlushBehavior(@NotNull FlushBehavior flushBehavior) {
        INSTANCE.setFlushBehavior(flushBehavior);
    }

    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final void setInstallReferrer(@Nullable String str) {
        INSTANCE.setInstallReferrer(str);
    }

    @JvmStatic
    public static final void setPushNotificationsRegistrationId(@Nullable String str) {
        INSTANCE.setPushNotificationsRegistrationId(str);
    }

    @JvmStatic
    public static final void setUserData(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10) {
        INSTANCE.setUserData(str, str2, str3, str4, str5, str6, str7, str8, str9, str10);
    }

    @JvmStatic
    public static final void setUserID(@Nullable String str) {
        INSTANCE.setUserID(str);
    }

    public final void flush() {
        this.loggerImpl.flush();
    }

    @NotNull
    public final String getApplicationId() {
        return this.loggerImpl.getApplicationId();
    }

    public final boolean isValidForAccessToken(@NotNull AccessToken accessToken) {
        kotlin.jvm.internal.s.e(accessToken, "accessToken");
        return this.loggerImpl.isValidForAccessToken(accessToken);
    }

    public final void logEvent(@Nullable String str) {
        this.loggerImpl.logEvent(str);
    }

    public final void logProductItem(@Nullable String str, @Nullable ProductAvailability productAvailability, @Nullable ProductCondition productCondition, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable BigDecimal bigDecimal, @Nullable Currency currency, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable Bundle bundle) {
        this.loggerImpl.logProductItem(str, productAvailability, productCondition, str2, str3, str4, str5, bigDecimal, currency, str6, str7, str8, bundle);
    }

    public final void logPurchase(@Nullable BigDecimal bigDecimal, @Nullable Currency currency) {
        this.loggerImpl.logPurchase(bigDecimal, currency);
    }

    public final void logPushNotificationOpen(@NotNull Bundle payload) {
        kotlin.jvm.internal.s.e(payload, "payload");
        this.loggerImpl.logPushNotificationOpen(payload, null);
    }

    public final void logEvent(@Nullable String str, double d2) {
        this.loggerImpl.logEvent(str, d2);
    }

    public final void logPurchase(@Nullable BigDecimal bigDecimal, @Nullable Currency currency, @Nullable Bundle bundle) {
        this.loggerImpl.logPurchase(bigDecimal, currency, bundle);
    }

    public final void logPushNotificationOpen(@NotNull Bundle payload, @Nullable String str) {
        kotlin.jvm.internal.s.e(payload, "payload");
        this.loggerImpl.logPushNotificationOpen(payload, str);
    }

    public final void logEvent(@Nullable String str, @Nullable Bundle bundle) {
        this.loggerImpl.logEvent(str, bundle);
    }

    public final void logEvent(@Nullable String str, double d2, @Nullable Bundle bundle) {
        this.loggerImpl.logEvent(str, d2, bundle);
    }
}
