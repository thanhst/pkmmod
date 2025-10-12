package com.facebook;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.AsyncTask;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.adjust.sdk.Constants;
import com.facebook.GraphRequest;
import com.facebook.Profile;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.AppEventsManager;
import com.facebook.appevents.UserDataStore;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.appevents.internal.AppEventsLoggerUtility;
import com.facebook.appevents.ondeviceprocessing.OnDeviceProcessingManager;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.BoltsMeasurementEventListener;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.LockOnGetVariable;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.internal.instrument.InstrumentManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.r0;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.x;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FacebookSdk.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004\u009f\u0001 \u0001B\u000b\b\u0002¢\u0006\u0006\b\u009d\u0001\u0010\u009e\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0007J\b\u0010\b\u001a\u00020\u0007H\u0007J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0007J\b\u0010\f\u001a\u00020\u000bH\u0007J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000bH\u0007J\b\u0010\u000f\u001a\u00020\u000bH\u0007J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000bH\u0007J\b\u0010\u0013\u001a\u00020\u0012H\u0007J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0012H\u0007J\b\u0010\u0016\u001a\u00020\u000bH\u0007J\b\u0010\u0017\u001a\u00020\u0012H\u0007J\b\u0010\u0018\u001a\u00020\u0012H\u0007J\b\u0010\u0019\u001a\u00020\u0012H\u0007J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0012H\u0007J\u0018\u0010 \u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001eH\u0007J\"\u0010 \u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0007J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001cH\u0007J\u001a\u0010 \u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0007J\b\u0010#\u001a\u00020\u000bH\u0007J\b\u0010$\u001a\u00020\u0005H\u0007J\u000e\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%H\u0007J\u0010\u0010)\u001a\u00020\u00052\u0006\u0010(\u001a\u00020&H\u0007J\u0010\u0010*\u001a\u00020\u00052\u0006\u0010(\u001a\u00020&H\u0007J\b\u0010+\u001a\u00020\u0005H\u0007J\u0010\u0010,\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020&H\u0007J\b\u0010-\u001a\u00020\u0005H\u0002J\b\u0010.\u001a\u00020\u0012H\u0007J\b\u0010/\u001a\u00020\u001cH\u0007J\u0018\u00102\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\u0012H\u0007J\u0018\u00103\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\u0012H\u0003J\b\u00104\u001a\u00020\u0012H\u0007J\u0010\u00105\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u001cH\u0007J\u0018\u00107\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u001c2\u0006\u00106\u001a\u00020\u000bH\u0007J\u0019\u0010:\u001a\u00020\u00052\b\u00100\u001a\u0004\u0018\u00010\u001cH\u0001¢\u0006\u0004\b8\u00109J\u0014\u0010;\u001a\u0004\u0018\u00010\u00122\b\u00100\u001a\u0004\u0018\u00010\u001cH\u0007J\b\u0010<\u001a\u00020\u0012H\u0007J\u0010\u0010=\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u0012H\u0007J\n\u0010>\u001a\u0004\u0018\u00010\u0012H\u0007J\u0012\u0010@\u001a\u00020\u00052\b\u0010?\u001a\u0004\u0018\u00010\u0012H\u0007J\b\u0010A\u001a\u00020\u0012H\u0007J\u0012\u0010C\u001a\u00020\u00052\b\u0010B\u001a\u0004\u0018\u00010\u0012H\u0007J\b\u0010D\u001a\u00020\u000bH\u0007J\u0010\u0010F\u001a\u00020\u00052\u0006\u0010E\u001a\u00020\u000bH\u0007J\b\u0010G\u001a\u00020\u000bH\u0007J\u0010\u0010H\u001a\u00020\u00052\u0006\u0010E\u001a\u00020\u000bH\u0007J\b\u0010I\u001a\u00020\u000bH\u0007J\b\u0010J\u001a\u00020\u000bH\u0007J\b\u0010K\u001a\u00020\u000bH\u0007J\u0010\u0010L\u001a\u00020\u00052\u0006\u0010E\u001a\u00020\u000bH\u0007J\u0010\u0010M\u001a\u00020\u00052\u0006\u0010E\u001a\u00020\u000bH\u0007J\b\u0010N\u001a\u00020\u000bH\u0007J\u0010\u0010O\u001a\u00020\u00052\u0006\u0010E\u001a\u00020\u000bH\u0007J\u001f\u0010R\u001a\u00020\u00052\u000e\u0010Q\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010PH\u0007¢\u0006\u0004\bR\u0010SJ/\u0010R\u001a\u00020\u00052\u000e\u0010Q\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010P2\u0006\u0010T\u001a\u00020\u001e2\u0006\u0010U\u001a\u00020\u001eH\u0007¢\u0006\u0004\bR\u0010VJ\n\u0010X\u001a\u0004\u0018\u00010WH\u0007J\u0010\u0010Z\u001a\u00020\u00052\u0006\u0010Y\u001a\u00020WH\u0007J\b\u0010[\u001a\u00020\u001eH\u0007J\u0010\u0010]\u001a\u00020\u000b2\u0006\u0010\\\u001a\u00020\u001eH\u0007J\u0017\u0010b\u001a\u00020\u00052\u0006\u0010_\u001a\u00020^H\u0001¢\u0006\u0004\b`\u0010aR\u001c\u0010d\u001a\n c*\u0004\u0018\u00010\u00120\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bd\u0010eR$\u0010h\u001a\u0012\u0012\u0004\u0012\u00020&0fj\b\u0012\u0004\u0012\u00020&`g8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bh\u0010iR\u0014\u0010j\u001a\u00020\u001e8\u0002X\u0082T¢\u0006\u0006\n\u0004\bj\u0010kR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010lR\u0018\u00101\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u0010eR\u0018\u0010?\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010eR\u0018\u0010m\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010eR\u0018\u0010n\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010oR\u0016\u0010q\u001a\u00020p8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010rR\u0016\u0010s\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010tR\u0016\u0010\u000f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010tR\u001c\u0010Y\u001a\b\u0012\u0004\u0012\u00020W0u8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bY\u0010vR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001d\u0010wR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010kR\u0014\u0010y\u001a\u00020x8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\by\u0010zR\u0016\u0010\u0014\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010eR\u0014\u0010{\u001a\u00020\u001e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b{\u0010kR\u0014\u0010|\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b|\u0010eR\u0014\u0010}\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b}\u0010eR\u0014\u0010~\u001a\u00020\u00128\u0006X\u0086T¢\u0006\u0006\n\u0004\b~\u0010eR\u0014\u0010\u007f\u001a\u00020\u00128\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u007f\u0010eR\u0016\u0010\u0080\u0001\u001a\u00020\u00128\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0080\u0001\u0010eR\u0016\u0010\u0081\u0001\u001a\u00020\u00128\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0081\u0001\u0010eR\u0016\u0010\u0082\u0001\u001a\u00020\u00128\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0082\u0001\u0010eR\u0016\u0010\u0083\u0001\u001a\u00020\u00128\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0083\u0001\u0010eR\u0016\u0010\u0084\u0001\u001a\u00020\u00128\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0084\u0001\u0010eR\u0016\u0010\u0085\u0001\u001a\u00020\u00128\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0085\u0001\u0010eR\u0016\u0010\u0086\u0001\u001a\u00020\u00128\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0086\u0001\u0010eR\u0016\u0010\u0087\u0001\u001a\u00020\u00128\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0087\u0001\u0010eR\u0016\u0010\u0088\u0001\u001a\u00020\u00128\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0088\u0001\u0010eR\u0016\u0010\u0089\u0001\u001a\u00020\u00128\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0089\u0001\u0010eR\u0016\u0010\u008a\u0001\u001a\u00020\u00128\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u008a\u0001\u0010eR\u0016\u0010\u008b\u0001\u001a\u00020\u00128\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u008b\u0001\u0010eR\u0016\u0010\u008c\u0001\u001a\u00020\u00128\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u008c\u0001\u0010eR\u0016\u0010\u008d\u0001\u001a\u00020\u00128\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u008d\u0001\u0010eR\u0016\u0010\u008e\u0001\u001a\u00020\u00128\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u008e\u0001\u0010eR\u0018\u0010\u008f\u0001\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0007\n\u0005\b\u008f\u0001\u0010tR\u0018\u0010\u0090\u0001\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0007\n\u0005\b\u0090\u0001\u0010tR\u0018\u0010\u0091\u0001\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0007\n\u0005\b\u0091\u0001\u0010tR\u0016\u0010\u0092\u0001\u001a\u00020\u00128\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0092\u0001\u0010eR\u0016\u0010\u0093\u0001\u001a\u00020\u00128\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0093\u0001\u0010eR\u0016\u0010\u0094\u0001\u001a\u00020\u00128\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0094\u0001\u0010eR\u0016\u0010\u0095\u0001\u001a\u00020\u00128\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0095\u0001\u0010eR\u0016\u0010\u0096\u0001\u001a\u00020\u00128\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0096\u0001\u0010eR\u0018\u0010\u0098\u0001\u001a\u00030\u0097\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0098\u0001\u0010\u0099\u0001R\u0018\u0010\u009a\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009a\u0001\u0010eR\u0016\u0010\u001a\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010eR\u0017\u0010_\u001a\u00020^8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b_\u0010\u009b\u0001R\u0016\u0010\u009c\u0001\u001a\u00020\u00128\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u009c\u0001\u0010eR\u0016\u0010\u0016\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010t¨\u0006¡\u0001"}, d2 = {"Lcom/facebook/FacebookSdk;", "", "Ljava/util/concurrent/Executor;", "getExecutor", "executor", "Lkotlin/t;", "setExecutor", "", "getOnProgressThreshold", "threshold", "setOnProgressThreshold", "", "isDebugEnabled", "enabled", "setIsDebugEnabled", "isLegacyTokenUpgradeSupported", "supported", "setLegacyTokenUpgradeSupported", "", "getGraphApiVersion", "graphApiVersion", "setGraphApiVersion", "isFullyInitialized", "getFacebookDomain", "getFacebookGamingDomain", "getInstagramDomain", "facebookDomain", "setFacebookDomain", "Landroid/content/Context;", "applicationContext", "", "callbackRequestCodeOffset", "sdkInitialize", "Lcom/facebook/FacebookSdk$InitializeCallback;", "callback", "isInitialized", "fullyInitialize", "", "Lcom/facebook/LoggingBehavior;", "getLoggingBehaviors", "behavior", "addLoggingBehavior", "removeLoggingBehavior", "clearLoggingBehaviors", "isLoggingBehaviorEnabled", "updateGraphDebugBehavior", "getGraphDomain", "getApplicationContext", "context", "applicationId", "publishInstallAsync", "publishInstallAndWaitForResponse", "getSdkVersion", "getLimitEventAndDataUsage", "limitEventUsage", "setLimitEventAndDataUsage", "loadDefaultsFromMetadata$facebook_core_release", "(Landroid/content/Context;)V", "loadDefaultsFromMetadata", "getApplicationSignature", "getApplicationId", "setApplicationId", "getApplicationName", "applicationName", "setApplicationName", "getClientToken", "clientToken", "setClientToken", "getAutoInitEnabled", "flag", "setAutoInitEnabled", "getAutoLogAppEventsEnabled", "setAutoLogAppEventsEnabled", "getCodelessDebugLogEnabled", "getCodelessSetupEnabled", "getAdvertiserIDCollectionEnabled", "setAdvertiserIDCollectionEnabled", "setCodelessDebugLogEnabled", "getMonitorEnabled", "setMonitorEnabled", "", "options", "setDataProcessingOptions", "([Ljava/lang/String;)V", UserDataStore.COUNTRY, ServerProtocol.DIALOG_PARAM_STATE, "([Ljava/lang/String;II)V", "Ljava/io/File;", "getCacheDir", "cacheDir", "setCacheDir", "getCallbackRequestCodeOffset", "requestCode", "isFacebookRequestCode", "Lcom/facebook/FacebookSdk$GraphRequestCreator;", "graphRequestCreator", "setGraphRequestCreator$facebook_core_release", "(Lcom/facebook/FacebookSdk$GraphRequestCreator;)V", "setGraphRequestCreator", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "loggingBehaviors", "Ljava/util/HashSet;", "DEFAULT_CALLBACK_REQUEST_CODE_OFFSET", "I", "Ljava/util/concurrent/Executor;", "appClientToken", "codelessDebugLogEnabled", "Ljava/lang/Boolean;", "Ljava/util/concurrent/atomic/AtomicLong;", "onProgressThreshold", "Ljava/util/concurrent/atomic/AtomicLong;", "isDebugEnabledField", "Z", "Lcom/facebook/internal/LockOnGetVariable;", "Lcom/facebook/internal/LockOnGetVariable;", "Landroid/content/Context;", "Ljava/util/concurrent/locks/ReentrantLock;", "LOCK", "Ljava/util/concurrent/locks/ReentrantLock;", "MAX_REQUEST_CODE_RANGE", "ATTRIBUTION_PREFERENCES", "PUBLISH_ACTIVITY_PATH", "CALLBACK_OFFSET_CHANGED_AFTER_INIT", "CALLBACK_OFFSET_NEGATIVE", "APP_EVENT_PREFERENCES", "DATA_PROCESSING_OPTIONS_PREFERENCES", "APPLICATION_ID_PROPERTY", "APPLICATION_NAME_PROPERTY", "CLIENT_TOKEN_PROPERTY", "WEB_DIALOG_THEME", "AUTO_INIT_ENABLED_PROPERTY", "AUTO_LOG_APP_EVENTS_ENABLED_PROPERTY", "CODELESS_DEBUG_LOG_ENABLED_PROPERTY", "ADVERTISER_ID_COLLECTION_ENABLED_PROPERTY", "CALLBACK_OFFSET_PROPERTY", "MONITOR_ENABLED_PROPERTY", "DATA_PROCESSION_OPTIONS", "DATA_PROCESSION_OPTIONS_COUNTRY", "DATA_PROCESSION_OPTIONS_STATE", "hasCustomTabsPrefetching", "ignoreAppSwitchToLoggedOut", "bypassAppSwitch", "INSTAGRAM", "GAMING", "FACEBOOK_COM", "FB_GG", "INSTAGRAM_COM", "Ljava/util/concurrent/atomic/AtomicBoolean;", "sdkInitialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "instagramDomain", "Lcom/facebook/FacebookSdk$GraphRequestCreator;", "CLOUDBRIDGE_SAVED_CREDENTIALS", "<init>", "()V", "GraphRequestCreator", "InitializeCallback", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class FacebookSdk {

    @NotNull
    public static final String ADVERTISER_ID_COLLECTION_ENABLED_PROPERTY = "com.facebook.sdk.AdvertiserIDCollectionEnabled";

    @NotNull
    public static final String APPLICATION_ID_PROPERTY = "com.facebook.sdk.ApplicationId";

    @NotNull
    public static final String APPLICATION_NAME_PROPERTY = "com.facebook.sdk.ApplicationName";

    @NotNull
    public static final String APP_EVENT_PREFERENCES = "com.facebook.sdk.appEventPreferences";

    @NotNull
    private static final String ATTRIBUTION_PREFERENCES = "com.facebook.sdk.attributionTracking";

    @NotNull
    public static final String AUTO_INIT_ENABLED_PROPERTY = "com.facebook.sdk.AutoInitEnabled";

    @NotNull
    public static final String AUTO_LOG_APP_EVENTS_ENABLED_PROPERTY = "com.facebook.sdk.AutoLogAppEventsEnabled";

    @NotNull
    public static final String CALLBACK_OFFSET_CHANGED_AFTER_INIT = "The callback request code offset can't be updated once the SDK is initialized. Call FacebookSdk.setCallbackRequestCodeOffset inside your Application.onCreate method";

    @NotNull
    public static final String CALLBACK_OFFSET_NEGATIVE = "The callback request code offset can't be negative.";

    @NotNull
    public static final String CALLBACK_OFFSET_PROPERTY = "com.facebook.sdk.CallbackOffset";

    @NotNull
    public static final String CLIENT_TOKEN_PROPERTY = "com.facebook.sdk.ClientToken";

    @NotNull
    public static final String CLOUDBRIDGE_SAVED_CREDENTIALS = "com.facebook.sdk.CloudBridgeSavedCredentials";

    @NotNull
    public static final String CODELESS_DEBUG_LOG_ENABLED_PROPERTY = "com.facebook.sdk.CodelessDebugLogEnabled";

    @NotNull
    public static final String DATA_PROCESSING_OPTIONS_PREFERENCES = "com.facebook.sdk.DataProcessingOptions";

    @NotNull
    public static final String DATA_PROCESSION_OPTIONS = "data_processing_options";

    @NotNull
    public static final String DATA_PROCESSION_OPTIONS_COUNTRY = "data_processing_options_country";

    @NotNull
    public static final String DATA_PROCESSION_OPTIONS_STATE = "data_processing_options_state";

    @NotNull
    public static final String FB_GG = "fb.gg";

    @NotNull
    public static final String GAMING = "gaming";

    @NotNull
    public static final String INSTAGRAM = "instagram";
    private static final int MAX_REQUEST_CODE_RANGE = 100;

    @NotNull
    public static final String MONITOR_ENABLED_PROPERTY = "com.facebook.sdk.MonitorEnabled";

    @NotNull
    private static final String PUBLISH_ACTIVITY_PATH = "%s/activities";

    @NotNull
    public static final String WEB_DIALOG_THEME = "com.facebook.sdk.WebDialogTheme";

    @Nullable
    private static volatile String appClientToken;
    private static Context applicationContext;

    @Nullable
    private static volatile String applicationId;

    @Nullable
    private static volatile String applicationName;

    @JvmField
    public static boolean bypassAppSwitch;
    private static LockOnGetVariable<File> cacheDir;

    @Nullable
    private static volatile Boolean codelessDebugLogEnabled;

    @Nullable
    private static Executor executor;

    @JvmField
    public static boolean hasCustomTabsPrefetching;

    @JvmField
    public static boolean ignoreAppSwitchToLoggedOut;
    private static volatile boolean isDebugEnabledField;
    private static boolean isFullyInitialized;
    private static boolean isLegacyTokenUpgradeSupported;

    @NotNull
    public static final FacebookSdk INSTANCE = new FacebookSdk();
    private static final String TAG = FacebookSdk.class.getCanonicalName();

    @NotNull
    private static final HashSet<LoggingBehavior> loggingBehaviors = r0.e(LoggingBehavior.DEVELOPER_ERRORS);

    @NotNull
    private static AtomicLong onProgressThreshold = new AtomicLong(PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH);
    private static final int DEFAULT_CALLBACK_REQUEST_CODE_OFFSET = 64206;
    private static int callbackRequestCodeOffset = DEFAULT_CALLBACK_REQUEST_CODE_OFFSET;

    @NotNull
    private static final ReentrantLock LOCK = new ReentrantLock();

    @NotNull
    private static String graphApiVersion = ServerProtocol.getDefaultAPIVersion();

    @NotNull
    private static final AtomicBoolean sdkInitialized = new AtomicBoolean(false);

    @NotNull
    public static final String INSTAGRAM_COM = "instagram.com";

    @NotNull
    private static volatile String instagramDomain = INSTAGRAM_COM;

    @NotNull
    public static final String FACEBOOK_COM = "facebook.com";

    @NotNull
    private static volatile String facebookDomain = FACEBOOK_COM;

    @NotNull
    private static GraphRequestCreator graphRequestCreator = new GraphRequestCreator() { // from class: com.facebook.p
        @Override // com.facebook.FacebookSdk.GraphRequestCreator
        public final GraphRequest createPostRequest(AccessToken accessToken, String str, JSONObject jSONObject, GraphRequest.Callback callback) {
            return FacebookSdk.m9graphRequestCreator$lambda0(accessToken, str, jSONObject, callback);
        }
    };

    /* compiled from: FacebookSdk.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bá\u0080\u0001\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&¨\u0006\f"}, d2 = {"Lcom/facebook/FacebookSdk$GraphRequestCreator;", "", "createPostRequest", "Lcom/facebook/GraphRequest;", "accessToken", "Lcom/facebook/AccessToken;", "publishUrl", "", "publishParams", "Lorg/json/JSONObject;", "callback", "Lcom/facebook/GraphRequest$Callback;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    @VisibleForTesting
    public interface GraphRequestCreator {
        @NotNull
        GraphRequest createPostRequest(@Nullable AccessToken accessToken, @Nullable String publishUrl, @Nullable JSONObject publishParams, @Nullable GraphRequest.Callback callback);
    }

    /* compiled from: FacebookSdk.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0004"}, d2 = {"Lcom/facebook/FacebookSdk$InitializeCallback;", "", "Lkotlin/t;", "onInitialized", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public interface InitializeCallback {
        void onInitialized();
    }

    private FacebookSdk() {
    }

    @JvmStatic
    public static final void addLoggingBehavior(@NotNull LoggingBehavior behavior) {
        kotlin.jvm.internal.s.e(behavior, "behavior");
        HashSet<LoggingBehavior> hashSet = loggingBehaviors;
        synchronized (hashSet) {
            hashSet.add(behavior);
            INSTANCE.updateGraphDebugBehavior();
            kotlin.t tVar = kotlin.t.f3507a;
        }
    }

    @JvmStatic
    public static final void clearLoggingBehaviors() {
        HashSet<LoggingBehavior> hashSet = loggingBehaviors;
        synchronized (hashSet) {
            hashSet.clear();
            kotlin.t tVar = kotlin.t.f3507a;
        }
    }

    @JvmStatic
    public static final void fullyInitialize() {
        isFullyInitialized = true;
    }

    @JvmStatic
    public static final boolean getAdvertiserIDCollectionEnabled() {
        return UserSettingsManager.getAdvertiserIDCollectionEnabled();
    }

    @JvmStatic
    @NotNull
    public static final Context getApplicationContext() {
        Validate.sdkInitialized();
        Context context = applicationContext;
        if (context != null) {
            return context;
        }
        kotlin.jvm.internal.s.t("applicationContext");
        throw null;
    }

    @JvmStatic
    @NotNull
    public static final String getApplicationId() {
        Validate.sdkInitialized();
        String str = applicationId;
        if (str != null) {
            return str;
        }
        throw new FacebookException("A valid Facebook app id must be set in the AndroidManifest.xml or set by calling FacebookSdk.setApplicationId before initializing the sdk.");
    }

    @JvmStatic
    @Nullable
    public static final String getApplicationName() {
        Validate.sdkInitialized();
        return applicationName;
    }

    @JvmStatic
    @Nullable
    public static final String getApplicationSignature(@Nullable Context context) {
        PackageManager packageManager;
        if (CrashShieldHandler.isObjectCrashing(FacebookSdk.class)) {
            return null;
        }
        try {
            Validate.sdkInitialized();
            if (context == null || (packageManager = context.getPackageManager()) == null) {
                return null;
            }
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 64);
                Signature[] signatureArr = packageInfo.signatures;
                if (signatureArr != null) {
                    if (!(signatureArr.length == 0)) {
                        MessageDigest messageDigest = MessageDigest.getInstance(Constants.SHA1);
                        messageDigest.update(packageInfo.signatures[0].toByteArray());
                        return Base64.encodeToString(messageDigest.digest(), 9);
                    }
                }
            } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException unused) {
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, FacebookSdk.class);
            return null;
        }
    }

    @JvmStatic
    public static final boolean getAutoInitEnabled() {
        return UserSettingsManager.getAutoInitEnabled();
    }

    @JvmStatic
    public static final boolean getAutoLogAppEventsEnabled() {
        return UserSettingsManager.getAutoLogAppEventsEnabled();
    }

    @JvmStatic
    @Nullable
    public static final File getCacheDir() {
        Validate.sdkInitialized();
        LockOnGetVariable<File> lockOnGetVariable = cacheDir;
        if (lockOnGetVariable != null) {
            return lockOnGetVariable.getValue();
        }
        kotlin.jvm.internal.s.t("cacheDir");
        throw null;
    }

    @JvmStatic
    public static final int getCallbackRequestCodeOffset() {
        Validate.sdkInitialized();
        return callbackRequestCodeOffset;
    }

    @JvmStatic
    @NotNull
    public static final String getClientToken() {
        Validate.sdkInitialized();
        String str = appClientToken;
        if (str != null) {
            return str;
        }
        throw new FacebookException("A valid Facebook client token must be set in the AndroidManifest.xml or set by calling FacebookSdk.setClientToken before initializing the sdk. Visit https://developers.facebook.com/docs/android/getting-started#add-app_id for more information.");
    }

    @JvmStatic
    public static final boolean getCodelessDebugLogEnabled() {
        Validate.sdkInitialized();
        Boolean bool = codelessDebugLogEnabled;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @JvmStatic
    public static final boolean getCodelessSetupEnabled() {
        return UserSettingsManager.getCodelessSetupEnabled();
    }

    @JvmStatic
    @NotNull
    public static final Executor getExecutor() {
        ReentrantLock reentrantLock = LOCK;
        reentrantLock.lock();
        try {
            if (executor == null) {
                executor = AsyncTask.THREAD_POOL_EXECUTOR;
            }
            kotlin.t tVar = kotlin.t.f3507a;
            reentrantLock.unlock();
            Executor executor2 = executor;
            if (executor2 != null) {
                return executor2;
            }
            throw new IllegalStateException("Required value was null.".toString());
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @JvmStatic
    @NotNull
    public static final String getFacebookDomain() {
        return facebookDomain;
    }

    @JvmStatic
    @NotNull
    public static final String getFacebookGamingDomain() {
        return FB_GG;
    }

    @JvmStatic
    @NotNull
    public static final String getGraphApiVersion() {
        Utility utility = Utility.INSTANCE;
        String str = TAG;
        x xVar = x.f3460a;
        String str2 = String.format("getGraphApiVersion: %s", Arrays.copyOf(new Object[]{graphApiVersion}, 1));
        kotlin.jvm.internal.s.d(str2, "java.lang.String.format(format, *args)");
        Utility.logd(str, str2);
        return graphApiVersion;
    }

    @JvmStatic
    @NotNull
    public static final String getGraphDomain() {
        AccessToken currentAccessToken = AccessToken.INSTANCE.getCurrentAccessToken();
        return Utility.getGraphDomainFromTokenDomain(currentAccessToken != null ? currentAccessToken.getGraphDomain() : null);
    }

    @JvmStatic
    @NotNull
    public static final String getInstagramDomain() {
        return instagramDomain;
    }

    @JvmStatic
    public static final boolean getLimitEventAndDataUsage(@NotNull Context context) {
        kotlin.jvm.internal.s.e(context, "context");
        Validate.sdkInitialized();
        return context.getSharedPreferences(APP_EVENT_PREFERENCES, 0).getBoolean("limitEventUsage", false);
    }

    @JvmStatic
    @NotNull
    public static final Set<LoggingBehavior> getLoggingBehaviors() {
        Set<LoggingBehavior> setUnmodifiableSet;
        HashSet<LoggingBehavior> hashSet = loggingBehaviors;
        synchronized (hashSet) {
            setUnmodifiableSet = Collections.unmodifiableSet(new HashSet(hashSet));
            kotlin.jvm.internal.s.d(setUnmodifiableSet, "unmodifiableSet(HashSet(loggingBehaviors))");
        }
        return setUnmodifiableSet;
    }

    @JvmStatic
    public static final boolean getMonitorEnabled() {
        return UserSettingsManager.getMonitorEnabled();
    }

    @JvmStatic
    public static final long getOnProgressThreshold() {
        Validate.sdkInitialized();
        return onProgressThreshold.get();
    }

    @JvmStatic
    @NotNull
    public static final String getSdkVersion() {
        return FacebookSdkVersion.BUILD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: graphRequestCreator$lambda-0, reason: not valid java name */
    public static final GraphRequest m9graphRequestCreator$lambda0(AccessToken accessToken, String str, JSONObject jSONObject, GraphRequest.Callback callback) {
        return GraphRequest.INSTANCE.newPostRequest(accessToken, str, jSONObject, callback);
    }

    @JvmStatic
    public static final boolean isDebugEnabled() {
        return isDebugEnabledField;
    }

    @JvmStatic
    public static final boolean isFacebookRequestCode(int requestCode) {
        int i2 = callbackRequestCodeOffset;
        return requestCode >= i2 && requestCode < i2 + 100;
    }

    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final synchronized boolean isFullyInitialized() {
        return isFullyInitialized;
    }

    @JvmStatic
    public static final boolean isInitialized() {
        return sdkInitialized.get();
    }

    @JvmStatic
    public static final boolean isLegacyTokenUpgradeSupported() {
        return isLegacyTokenUpgradeSupported;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0016  */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean isLoggingBehaviorEnabled(@org.jetbrains.annotations.NotNull com.facebook.LoggingBehavior r2) {
        /*
            java.lang.String r0 = "behavior"
            kotlin.jvm.internal.s.e(r2, r0)
            java.util.HashSet<com.facebook.LoggingBehavior> r0 = com.facebook.FacebookSdk.loggingBehaviors
            monitor-enter(r0)
            boolean r1 = isDebugEnabled()     // Catch: java.lang.Throwable -> L19
            if (r1 == 0) goto L16
            boolean r2 = r0.contains(r2)     // Catch: java.lang.Throwable -> L19
            if (r2 == 0) goto L16
            r2 = 1
            goto L17
        L16:
            r2 = 0
        L17:
            monitor-exit(r0)
            return r2
        L19:
            r2 = move-exception
            monitor-exit(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.FacebookSdk.isLoggingBehaviorEnabled(com.facebook.LoggingBehavior):boolean");
    }

    @JvmStatic
    public static final void loadDefaultsFromMetadata$facebook_core_release(@Nullable Context context) throws PackageManager.NameNotFoundException {
        if (context == null) {
            return;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            kotlin.jvm.internal.s.d(applicationInfo, "try {\n          context.packageManager.getApplicationInfo(\n              context.packageName, PackageManager.GET_META_DATA)\n        } catch (e: PackageManager.NameNotFoundException) {\n          return\n        }");
            if (applicationInfo.metaData == null) {
                return;
            }
            if (applicationId == null) {
                Object obj = applicationInfo.metaData.get(APPLICATION_ID_PROPERTY);
                if (obj instanceof String) {
                    String str = (String) obj;
                    Locale ROOT = Locale.ROOT;
                    kotlin.jvm.internal.s.d(ROOT, "ROOT");
                    String lowerCase = str.toLowerCase(ROOT);
                    kotlin.jvm.internal.s.d(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                    if (kotlin.text.s.u(lowerCase, "fb", false, 2, null)) {
                        String strSubstring = str.substring(2);
                        kotlin.jvm.internal.s.d(strSubstring, "(this as java.lang.String).substring(startIndex)");
                        applicationId = strSubstring;
                    } else {
                        applicationId = str;
                    }
                } else if (obj instanceof Number) {
                    throw new FacebookException("App Ids cannot be directly placed in the manifest.They must be prefixed by 'fb' or be placed in the string resource file.");
                }
            }
            if (applicationName == null) {
                applicationName = applicationInfo.metaData.getString(APPLICATION_NAME_PROPERTY);
            }
            if (appClientToken == null) {
                appClientToken = applicationInfo.metaData.getString(CLIENT_TOKEN_PROPERTY);
            }
            if (callbackRequestCodeOffset == DEFAULT_CALLBACK_REQUEST_CODE_OFFSET) {
                callbackRequestCodeOffset = applicationInfo.metaData.getInt(CALLBACK_OFFSET_PROPERTY, DEFAULT_CALLBACK_REQUEST_CODE_OFFSET);
            }
            if (codelessDebugLogEnabled == null) {
                codelessDebugLogEnabled = Boolean.valueOf(applicationInfo.metaData.getBoolean(CODELESS_DEBUG_LOG_ENABLED_PROPERTY, false));
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    private final void publishInstallAndWaitForResponse(Context context, String str) {
        try {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.INSTANCE.getAttributionIdentifiers(context);
                SharedPreferences sharedPreferences = context.getSharedPreferences(ATTRIBUTION_PREFERENCES, 0);
                String strM = kotlin.jvm.internal.s.m(str, "ping");
                long j2 = sharedPreferences.getLong(strM, 0L);
                try {
                    AppEventsLoggerUtility appEventsLoggerUtility = AppEventsLoggerUtility.INSTANCE;
                    JSONObject jSONObjectForGraphAPICall = AppEventsLoggerUtility.getJSONObjectForGraphAPICall(AppEventsLoggerUtility.GraphAPIActivityType.MOBILE_INSTALL_EVENT, attributionIdentifiers, AppEventsLogger.INSTANCE.getAnonymousAppDeviceGUID(context), getLimitEventAndDataUsage(context), context);
                    x xVar = x.f3460a;
                    String str2 = String.format(PUBLISH_ACTIVITY_PATH, Arrays.copyOf(new Object[]{str}, 1));
                    kotlin.jvm.internal.s.d(str2, "java.lang.String.format(format, *args)");
                    GraphRequest graphRequestCreatePostRequest = graphRequestCreator.createPostRequest(null, str2, jSONObjectForGraphAPICall, null);
                    if (j2 == 0 && graphRequestCreatePostRequest.executeAndWait().getError() == null) {
                        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                        editorEdit.putLong(strM, System.currentTimeMillis());
                        editorEdit.apply();
                    }
                } catch (JSONException e2) {
                    throw new FacebookException("An error occurred while publishing install.", e2);
                }
            } catch (Exception e3) {
                Utility.logd("Facebook-publish", e3);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @JvmStatic
    @VisibleForTesting(otherwise = 3)
    public static final void publishInstallAsync(@NotNull Context context, @NotNull final String applicationId2) {
        if (CrashShieldHandler.isObjectCrashing(FacebookSdk.class)) {
            return;
        }
        try {
            kotlin.jvm.internal.s.e(context, "context");
            kotlin.jvm.internal.s.e(applicationId2, "applicationId");
            final Context applicationContext2 = context.getApplicationContext();
            getExecutor().execute(new Runnable() { // from class: com.facebook.h
                @Override // java.lang.Runnable
                public final void run() {
                    FacebookSdk.m10publishInstallAsync$lambda15(applicationContext2, applicationId2);
                }
            });
            FeatureManager featureManager = FeatureManager.INSTANCE;
            if (FeatureManager.isEnabled(FeatureManager.Feature.OnDeviceEventProcessing) && OnDeviceProcessingManager.isOnDeviceProcessingEnabled()) {
                OnDeviceProcessingManager.sendInstallEventAsync(applicationId2, ATTRIBUTION_PREFERENCES);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, FacebookSdk.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: publishInstallAsync$lambda-15, reason: not valid java name */
    public static final void m10publishInstallAsync$lambda15(Context applicationContext2, String applicationId2) {
        kotlin.jvm.internal.s.e(applicationId2, "$applicationId");
        FacebookSdk facebookSdk = INSTANCE;
        kotlin.jvm.internal.s.d(applicationContext2, "applicationContext");
        facebookSdk.publishInstallAndWaitForResponse(applicationContext2, applicationId2);
    }

    @JvmStatic
    public static final void removeLoggingBehavior(@NotNull LoggingBehavior behavior) {
        kotlin.jvm.internal.s.e(behavior, "behavior");
        HashSet<LoggingBehavior> hashSet = loggingBehaviors;
        synchronized (hashSet) {
            hashSet.remove(behavior);
        }
    }

    @Deprecated(message = "")
    @JvmStatic
    public static final synchronized void sdkInitialize(@NotNull Context applicationContext2, int i2) {
        kotlin.jvm.internal.s.e(applicationContext2, "applicationContext");
        sdkInitialize(applicationContext2, i2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: sdkInitialize$lambda-3, reason: not valid java name */
    public static final File m11sdkInitialize$lambda3() {
        Context context = applicationContext;
        if (context != null) {
            return context.getCacheDir();
        }
        kotlin.jvm.internal.s.t("applicationContext");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: sdkInitialize$lambda-4, reason: not valid java name */
    public static final void m12sdkInitialize$lambda4(boolean z2) {
        if (z2) {
            InstrumentManager.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: sdkInitialize$lambda-5, reason: not valid java name */
    public static final void m13sdkInitialize$lambda5(boolean z2) {
        if (z2) {
            AppEventsManager.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: sdkInitialize$lambda-6, reason: not valid java name */
    public static final void m14sdkInitialize$lambda6(boolean z2) {
        if (z2) {
            hasCustomTabsPrefetching = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: sdkInitialize$lambda-7, reason: not valid java name */
    public static final void m15sdkInitialize$lambda7(boolean z2) {
        if (z2) {
            ignoreAppSwitchToLoggedOut = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: sdkInitialize$lambda-8, reason: not valid java name */
    public static final void m16sdkInitialize$lambda8(boolean z2) {
        if (z2) {
            bypassAppSwitch = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: sdkInitialize$lambda-9, reason: not valid java name */
    public static final Void m17sdkInitialize$lambda9(InitializeCallback initializeCallback) {
        AccessTokenManager.INSTANCE.getInstance().loadCurrentAccessToken();
        ProfileManager.INSTANCE.getInstance().loadCurrentProfile();
        if (AccessToken.INSTANCE.isCurrentAccessTokenActive()) {
            Profile.Companion companion = Profile.INSTANCE;
            if (companion.getCurrentProfile() == null) {
                companion.fetchProfileForCurrentAccessToken();
            }
        }
        if (initializeCallback != null) {
            initializeCallback.onInitialized();
        }
        AppEventsLogger.Companion companion2 = AppEventsLogger.INSTANCE;
        companion2.initializeLib(getApplicationContext(), applicationId);
        UserSettingsManager.logIfAutoAppLinkEnabled();
        Context applicationContext2 = getApplicationContext().getApplicationContext();
        kotlin.jvm.internal.s.d(applicationContext2, "getApplicationContext().applicationContext");
        companion2.newLogger(applicationContext2).flush();
        return null;
    }

    @JvmStatic
    public static final void setAdvertiserIDCollectionEnabled(boolean z2) {
        UserSettingsManager.setAdvertiserIDCollectionEnabled(z2);
    }

    @JvmStatic
    public static final void setApplicationId(@NotNull String applicationId2) {
        kotlin.jvm.internal.s.e(applicationId2, "applicationId");
        Validate.notEmpty(applicationId2, "applicationId");
        applicationId = applicationId2;
    }

    @JvmStatic
    public static final void setApplicationName(@Nullable String str) {
        applicationName = str;
    }

    @JvmStatic
    public static final void setAutoInitEnabled(boolean z2) {
        UserSettingsManager.setAutoInitEnabled(z2);
        if (z2) {
            fullyInitialize();
        }
    }

    @JvmStatic
    public static final void setAutoLogAppEventsEnabled(boolean z2) {
        UserSettingsManager.setAutoLogAppEventsEnabled(z2);
        if (z2) {
            Application application = (Application) getApplicationContext();
            ActivityLifecycleTracker activityLifecycleTracker = ActivityLifecycleTracker.INSTANCE;
            ActivityLifecycleTracker.startTracking(application, getApplicationId());
        }
    }

    @JvmStatic
    public static final void setCacheDir(@NotNull File cacheDir2) {
        kotlin.jvm.internal.s.e(cacheDir2, "cacheDir");
        cacheDir = new LockOnGetVariable<>(cacheDir2);
    }

    @JvmStatic
    public static final void setClientToken(@Nullable String str) {
        appClientToken = str;
    }

    @JvmStatic
    public static final void setCodelessDebugLogEnabled(boolean z2) {
        codelessDebugLogEnabled = Boolean.valueOf(z2);
    }

    @JvmStatic
    public static final void setDataProcessingOptions(@Nullable String[] options) {
        if (CrashShieldHandler.isObjectCrashing(FacebookSdk.class)) {
            return;
        }
        try {
            setDataProcessingOptions(options, 0, 0);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, FacebookSdk.class);
        }
    }

    @JvmStatic
    public static final void setExecutor(@NotNull Executor executor2) {
        kotlin.jvm.internal.s.e(executor2, "executor");
        ReentrantLock reentrantLock = LOCK;
        reentrantLock.lock();
        try {
            executor = executor2;
            kotlin.t tVar = kotlin.t.f3507a;
        } finally {
            reentrantLock.unlock();
        }
    }

    @JvmStatic
    public static final void setFacebookDomain(@NotNull String facebookDomain2) {
        kotlin.jvm.internal.s.e(facebookDomain2, "facebookDomain");
        Log.w(TAG, "WARNING: Calling setFacebookDomain from non-DEBUG code.");
        facebookDomain = facebookDomain2;
    }

    @JvmStatic
    public static final void setGraphApiVersion(@NotNull String graphApiVersion2) {
        kotlin.jvm.internal.s.e(graphApiVersion2, "graphApiVersion");
        Log.w(TAG, "WARNING: Calling setGraphApiVersion from non-DEBUG code.");
        if (Utility.isNullOrEmpty(graphApiVersion2) || kotlin.jvm.internal.s.a(graphApiVersion, graphApiVersion2)) {
            return;
        }
        graphApiVersion = graphApiVersion2;
    }

    @JvmStatic
    @VisibleForTesting
    public static final void setGraphRequestCreator$facebook_core_release(@NotNull GraphRequestCreator graphRequestCreator2) {
        kotlin.jvm.internal.s.e(graphRequestCreator2, "graphRequestCreator");
        graphRequestCreator = graphRequestCreator2;
    }

    @JvmStatic
    public static final void setIsDebugEnabled(boolean z2) {
        isDebugEnabledField = z2;
    }

    @JvmStatic
    public static final void setLegacyTokenUpgradeSupported(boolean z2) {
        isLegacyTokenUpgradeSupported = z2;
    }

    @JvmStatic
    public static final void setLimitEventAndDataUsage(@NotNull Context context, boolean z2) {
        kotlin.jvm.internal.s.e(context, "context");
        context.getSharedPreferences(APP_EVENT_PREFERENCES, 0).edit().putBoolean("limitEventUsage", z2).apply();
    }

    @JvmStatic
    public static final void setMonitorEnabled(boolean z2) {
        UserSettingsManager.setMonitorEnabled(z2);
    }

    @JvmStatic
    public static final void setOnProgressThreshold(long j2) {
        onProgressThreshold.set(j2);
    }

    private final void updateGraphDebugBehavior() {
        HashSet<LoggingBehavior> hashSet = loggingBehaviors;
        if (hashSet.contains(LoggingBehavior.GRAPH_API_DEBUG_INFO)) {
            LoggingBehavior loggingBehavior = LoggingBehavior.GRAPH_API_DEBUG_WARNING;
            if (hashSet.contains(loggingBehavior)) {
                return;
            }
            hashSet.add(loggingBehavior);
        }
    }

    @Deprecated(message = "")
    @JvmStatic
    public static final synchronized void sdkInitialize(@NotNull Context applicationContext2, int i2, @Nullable InitializeCallback initializeCallback) {
        kotlin.jvm.internal.s.e(applicationContext2, "applicationContext");
        if (sdkInitialized.get() && i2 != callbackRequestCodeOffset) {
            throw new FacebookException(CALLBACK_OFFSET_CHANGED_AFTER_INIT);
        }
        if (i2 >= 0) {
            callbackRequestCodeOffset = i2;
            sdkInitialize(applicationContext2, initializeCallback);
        } else {
            throw new FacebookException(CALLBACK_OFFSET_NEGATIVE);
        }
    }

    @JvmStatic
    public static final void setDataProcessingOptions(@Nullable String[] options, int country, int state) {
        if (CrashShieldHandler.isObjectCrashing(FacebookSdk.class)) {
            return;
        }
        if (options == null) {
            try {
                options = new String[0];
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, FacebookSdk.class);
                return;
            }
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DATA_PROCESSION_OPTIONS, new JSONArray((Collection) kotlin.collections.n.t(options)));
            jSONObject.put(DATA_PROCESSION_OPTIONS_COUNTRY, country);
            jSONObject.put(DATA_PROCESSION_OPTIONS_STATE, state);
            Context context = applicationContext;
            if (context != null) {
                context.getSharedPreferences(DATA_PROCESSING_OPTIONS_PREFERENCES, 0).edit().putString(DATA_PROCESSION_OPTIONS, jSONObject.toString()).apply();
            } else {
                kotlin.jvm.internal.s.t("applicationContext");
                throw null;
            }
        } catch (JSONException unused) {
        }
    }

    @Deprecated(message = "")
    @JvmStatic
    public static final synchronized void sdkInitialize(@NotNull Context applicationContext2) {
        kotlin.jvm.internal.s.e(applicationContext2, "applicationContext");
        sdkInitialize(applicationContext2, (InitializeCallback) null);
    }

    @Deprecated(message = "")
    @JvmStatic
    public static final synchronized void sdkInitialize(@NotNull Context applicationContext2, @Nullable final InitializeCallback initializeCallback) {
        kotlin.jvm.internal.s.e(applicationContext2, "applicationContext");
        AtomicBoolean atomicBoolean = sdkInitialized;
        if (atomicBoolean.get()) {
            if (initializeCallback != null) {
                initializeCallback.onInitialized();
            }
            return;
        }
        Validate.hasFacebookActivity(applicationContext2, false);
        Validate.hasInternetPermissions(applicationContext2, false);
        Context applicationContext3 = applicationContext2.getApplicationContext();
        kotlin.jvm.internal.s.d(applicationContext3, "applicationContext.applicationContext");
        applicationContext = applicationContext3;
        AppEventsLogger.INSTANCE.getAnonymousAppDeviceGUID(applicationContext2);
        Context context = applicationContext;
        if (context != null) {
            loadDefaultsFromMetadata$facebook_core_release(context);
            String str = applicationId;
            if (!(str == null || str.length() == 0)) {
                String str2 = appClientToken;
                if (!(str2 == null || str2.length() == 0)) {
                    atomicBoolean.set(true);
                    if (getAutoInitEnabled()) {
                        fullyInitialize();
                    }
                    Context context2 = applicationContext;
                    if (context2 != null) {
                        if ((context2 instanceof Application) && UserSettingsManager.getAutoLogAppEventsEnabled()) {
                            ActivityLifecycleTracker activityLifecycleTracker = ActivityLifecycleTracker.INSTANCE;
                            Context context3 = applicationContext;
                            if (context3 == null) {
                                kotlin.jvm.internal.s.t("applicationContext");
                                throw null;
                            }
                            ActivityLifecycleTracker.startTracking((Application) context3, applicationId);
                        }
                        FetchedAppSettingsManager.loadAppSettingsAsync();
                        NativeProtocol.updateAllAvailableProtocolVersionsAsync();
                        BoltsMeasurementEventListener.Companion companion = BoltsMeasurementEventListener.INSTANCE;
                        Context context4 = applicationContext;
                        if (context4 != null) {
                            companion.getInstance(context4);
                            cacheDir = new LockOnGetVariable<>(new Callable() { // from class: com.facebook.i
                                @Override // java.util.concurrent.Callable
                                public final Object call() {
                                    return FacebookSdk.m11sdkInitialize$lambda3();
                                }
                            });
                            FeatureManager featureManager = FeatureManager.INSTANCE;
                            FeatureManager.checkFeature(FeatureManager.Feature.Instrument, new FeatureManager.Callback() { // from class: com.facebook.j
                                @Override // com.facebook.internal.FeatureManager.Callback
                                public final void onCompleted(boolean z2) {
                                    FacebookSdk.m12sdkInitialize$lambda4(z2);
                                }
                            });
                            FeatureManager.checkFeature(FeatureManager.Feature.AppEvents, new FeatureManager.Callback() { // from class: com.facebook.k
                                @Override // com.facebook.internal.FeatureManager.Callback
                                public final void onCompleted(boolean z2) {
                                    FacebookSdk.m13sdkInitialize$lambda5(z2);
                                }
                            });
                            FeatureManager.checkFeature(FeatureManager.Feature.ChromeCustomTabsPrefetching, new FeatureManager.Callback() { // from class: com.facebook.l
                                @Override // com.facebook.internal.FeatureManager.Callback
                                public final void onCompleted(boolean z2) {
                                    FacebookSdk.m14sdkInitialize$lambda6(z2);
                                }
                            });
                            FeatureManager.checkFeature(FeatureManager.Feature.IgnoreAppSwitchToLoggedOut, new FeatureManager.Callback() { // from class: com.facebook.m
                                @Override // com.facebook.internal.FeatureManager.Callback
                                public final void onCompleted(boolean z2) {
                                    FacebookSdk.m15sdkInitialize$lambda7(z2);
                                }
                            });
                            FeatureManager.checkFeature(FeatureManager.Feature.BypassAppSwitch, new FeatureManager.Callback() { // from class: com.facebook.n
                                @Override // com.facebook.internal.FeatureManager.Callback
                                public final void onCompleted(boolean z2) {
                                    FacebookSdk.m16sdkInitialize$lambda8(z2);
                                }
                            });
                            getExecutor().execute(new FutureTask(new Callable() { // from class: com.facebook.o
                                @Override // java.util.concurrent.Callable
                                public final Object call() {
                                    return FacebookSdk.m17sdkInitialize$lambda9(initializeCallback);
                                }
                            }));
                            return;
                        }
                        kotlin.jvm.internal.s.t("applicationContext");
                        throw null;
                    }
                    kotlin.jvm.internal.s.t("applicationContext");
                    throw null;
                }
                throw new FacebookException("A valid Facebook app client token must be set in the AndroidManifest.xml or set by calling FacebookSdk.setClientToken before initializing the sdk.");
            }
            throw new FacebookException("A valid Facebook app id must be set in the AndroidManifest.xml or set by calling FacebookSdk.setApplicationId before initializing the sdk.");
        }
        kotlin.jvm.internal.s.t("applicationContext");
        throw null;
    }
}
