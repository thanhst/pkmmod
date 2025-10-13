package com.facebook.appevents;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import com.adjust.sdk.Constants;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.cloudbridge.AppEventsCAPIManager;
import com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformerWebRequests;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Logger;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.x;
import u.a_u;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: AppEventQueue.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b4\u00105J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0007J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\fH\u0007J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0007J\u001e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0011H\u0007J*\u0010\u001c\u001a\u0004\u0018\u00010\u00152\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0011H\u0007J0\u0010 \u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0011H\u0007R\u001c\u0010#\u001a\n \"*\u0004\u0018\u00010!0!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010&\u001a\u00020%8\u0002X\u0082D¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020%8\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010'R\u0014\u0010)\u001a\u00020%8\u0002X\u0082T¢\u0006\u0006\n\u0004\b)\u0010'R\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010*R\u001c\u0010,\u001a\n \"*\u0004\u0018\u00010+0+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u001c\u0010/\u001a\b\u0012\u0002\b\u0003\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00102\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103¨\u00066"}, d2 = {"Lcom/facebook/appevents/AppEventQueue;", "", "Lkotlin/t;", "persistToDisk", "Lcom/facebook/appevents/FlushReason;", "reason", "flush", "Lcom/facebook/appevents/AccessTokenAppIdPair;", "accessTokenAppId", "Lcom/facebook/appevents/AppEvent;", "appEvent", "add", "", "getKeySet", "flushAndWait", "Lcom/facebook/appevents/AppEventCollection;", "appEventCollection", "Lcom/facebook/appevents/FlushStatistics;", "sendEventsToServer", "flushResults", "", "Lcom/facebook/GraphRequest;", "buildRequests", "Lcom/facebook/appevents/SessionEventsState;", "appEvents", "", "limitEventUsage", "flushState", "buildRequestForSession", "request", "Lcom/facebook/GraphResponse;", "response", "handleResponse", "", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "", "NUM_LOG_EVENTS_TO_TRY_TO_FLUSH_AFTER", "I", "FLUSH_PERIOD_IN_SECONDS", "NO_CONNECTIVITY_ERROR_CODE", "Lcom/facebook/appevents/AppEventCollection;", "Ljava/util/concurrent/ScheduledExecutorService;", "singleThreadExecutor", "Ljava/util/concurrent/ScheduledExecutorService;", "Ljava/util/concurrent/ScheduledFuture;", "scheduledFuture", "Ljava/util/concurrent/ScheduledFuture;", "Ljava/lang/Runnable;", "flushRunnable", "Ljava/lang/Runnable;", "<init>", "()V", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AppEventQueue {
    private static final int FLUSH_PERIOD_IN_SECONDS = 15;
    private static final int NO_CONNECTIVITY_ERROR_CODE = -1;

    @Nullable
    private static ScheduledFuture<?> scheduledFuture;

    @NotNull
    public static final AppEventQueue INSTANCE = new AppEventQueue();
    private static final String TAG = AppEventQueue.class.getName();
    private static final int NUM_LOG_EVENTS_TO_TRY_TO_FLUSH_AFTER = 100;

    @NotNull
    private static volatile AppEventCollection appEventCollection = new AppEventCollection();
    private static final ScheduledExecutorService singleThreadExecutor = Executors.newSingleThreadScheduledExecutor();

    @NotNull
    private static final Runnable flushRunnable = new Runnable() { // from class: com.facebook.appevents.h
        @Override // java.lang.Runnable
        public final void run() {
            AppEventQueue.m31flushRunnable$lambda0();
        }
    };

    private AppEventQueue() {
    }

    @JvmStatic
    public static final void add(@NotNull final AccessTokenAppIdPair accessTokenAppId, @NotNull final AppEvent appEvent) {
        if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
            return;
        }
        try {
            kotlin.jvm.internal.s.e(accessTokenAppId, "accessTokenAppId");
            kotlin.jvm.internal.s.e(appEvent, "appEvent");
            singleThreadExecutor.execute(new Runnable() { // from class: com.facebook.appevents.g
                @Override // java.lang.Runnable
                public final void run() {
                    AppEventQueue.m28add$lambda3(accessTokenAppId, appEvent);
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventQueue.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: add$lambda-3, reason: not valid java name */
    public static final void m28add$lambda3(AccessTokenAppIdPair accessTokenAppId, AppEvent appEvent) {
        if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
            return;
        }
        try {
            kotlin.jvm.internal.s.e(accessTokenAppId, "$accessTokenAppId");
            kotlin.jvm.internal.s.e(appEvent, "$appEvent");
            appEventCollection.addEvent(accessTokenAppId, appEvent);
            if (AppEventsLogger.INSTANCE.getFlushBehavior() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY && appEventCollection.getEventCount() > NUM_LOG_EVENTS_TO_TRY_TO_FLUSH_AFTER) {
                flushAndWait(FlushReason.EVENT_THRESHOLD);
            } else if (scheduledFuture == null) {
                scheduledFuture = singleThreadExecutor.schedule(flushRunnable, 15L, TimeUnit.SECONDS);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventQueue.class);
        }
    }

    @JvmStatic
    @Nullable
    public static final GraphRequest buildRequestForSession(@NotNull final AccessTokenAppIdPair accessTokenAppId, @NotNull final SessionEventsState appEvents, boolean limitEventUsage, @NotNull final FlushStatistics flushState) {
        if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
            return null;
        }
        try {
            kotlin.jvm.internal.s.e(accessTokenAppId, "accessTokenAppId");
            kotlin.jvm.internal.s.e(appEvents, "appEvents");
            kotlin.jvm.internal.s.e(flushState, "flushState");
            String applicationId = accessTokenAppId.getApplicationId();
            FetchedAppSettings fetchedAppSettingsQueryAppSettings = FetchedAppSettingsManager.queryAppSettings(applicationId, false);
            GraphRequest.Companion companion = GraphRequest.INSTANCE;
            x xVar = x.f3460a;
            String str = String.format("%s/activities", Arrays.copyOf(new Object[]{applicationId}, 1));
            kotlin.jvm.internal.s.d(str, "java.lang.String.format(format, *args)");
            final GraphRequest graphRequestNewPostRequest = companion.newPostRequest(null, str, null, null);
            graphRequestNewPostRequest.setForceApplicationRequest(true);
            Bundle parameters = graphRequestNewPostRequest.getParameters();
            if (parameters == null) {
                parameters = new Bundle();
            }
            parameters.putString("access_token", accessTokenAppId.getAccessTokenString());
            String pushNotificationsRegistrationId = InternalAppEventsLogger.INSTANCE.getPushNotificationsRegistrationId();
            if (pushNotificationsRegistrationId != null) {
                parameters.putString("device_token", pushNotificationsRegistrationId);
            }
            String installReferrer = AppEventsLoggerImpl.INSTANCE.getInstallReferrer();
            if (installReferrer != null) {
                parameters.putString(Constants.INSTALL_REFERRER, installReferrer);
            }
            graphRequestNewPostRequest.setParameters(parameters);
            int iPopulateRequest = appEvents.populateRequest(graphRequestNewPostRequest, FacebookSdk.getApplicationContext(), fetchedAppSettingsQueryAppSettings != null ? fetchedAppSettingsQueryAppSettings.getSupportsImplicitLogging() : false, limitEventUsage);
            if (iPopulateRequest == 0) {
                return null;
            }
            flushState.setNumEvents(flushState.getNumEvents() + iPopulateRequest);
            graphRequestNewPostRequest.setCallback(new GraphRequest.Callback() { // from class: com.facebook.appevents.d
                @Override // com.facebook.GraphRequest.Callback
                public final void onCompleted(GraphResponse graphResponse) {
                    AppEventQueue.m29buildRequestForSession$lambda4(accessTokenAppId, graphRequestNewPostRequest, appEvents, flushState, graphResponse);
                }
            });
            return graphRequestNewPostRequest;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventQueue.class);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildRequestForSession$lambda-4, reason: not valid java name */
    public static final void m29buildRequestForSession$lambda4(AccessTokenAppIdPair accessTokenAppId, GraphRequest postRequest, SessionEventsState appEvents, FlushStatistics flushState, GraphResponse response) {
        if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
            return;
        }
        try {
            kotlin.jvm.internal.s.e(accessTokenAppId, "$accessTokenAppId");
            kotlin.jvm.internal.s.e(postRequest, "$postRequest");
            kotlin.jvm.internal.s.e(appEvents, "$appEvents");
            kotlin.jvm.internal.s.e(flushState, "$flushState");
            kotlin.jvm.internal.s.e(response, "response");
            handleResponse(accessTokenAppId, postRequest, response, appEvents, flushState);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventQueue.class);
        }
    }

    @JvmStatic
    @NotNull
    public static final List<GraphRequest> buildRequests(@NotNull AppEventCollection appEventCollection2, @NotNull FlushStatistics flushResults) {
        if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
            return null;
        }
        try {
            kotlin.jvm.internal.s.e(appEventCollection2, "appEventCollection");
            kotlin.jvm.internal.s.e(flushResults, "flushResults");
            boolean limitEventAndDataUsage = FacebookSdk.getLimitEventAndDataUsage(FacebookSdk.getApplicationContext());
            ArrayList arrayList = new ArrayList();
            for (AccessTokenAppIdPair accessTokenAppIdPair : appEventCollection2.keySet()) {
                SessionEventsState sessionEventsState = appEventCollection2.get(accessTokenAppIdPair);
                if (sessionEventsState == null) {
                    throw new IllegalStateException("Required value was null.".toString());
                }
                GraphRequest graphRequestBuildRequestForSession = buildRequestForSession(accessTokenAppIdPair, sessionEventsState, limitEventAndDataUsage, flushResults);
                if (graphRequestBuildRequestForSession != null) {
                    arrayList.add(graphRequestBuildRequestForSession);
                    if (AppEventsCAPIManager.INSTANCE.isEnabled$facebook_core_release()) {
                        AppEventsConversionsAPITransformerWebRequests.transformGraphRequestAndSendToCAPIGEndPoint(graphRequestBuildRequestForSession);
                    }
                }
            }
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventQueue.class);
            return null;
        }
    }

    @JvmStatic
    public static final void flush(@NotNull final FlushReason reason) {
        if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
            return;
        }
        try {
            kotlin.jvm.internal.s.e(reason, "reason");
            singleThreadExecutor.execute(new Runnable() { // from class: com.facebook.appevents.e
                @Override // java.lang.Runnable
                public final void run() {
                    AppEventQueue.m30flush$lambda2(reason);
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventQueue.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: flush$lambda-2, reason: not valid java name */
    public static final void m30flush$lambda2(FlushReason reason) {
        if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
            return;
        }
        try {
            kotlin.jvm.internal.s.e(reason, "$reason");
            flushAndWait(reason);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventQueue.class);
        }
    }

    @JvmStatic
    public static final void flushAndWait(@NotNull FlushReason reason) {
        if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
            return;
        }
        try {
            kotlin.jvm.internal.s.e(reason, "reason");
            appEventCollection.addPersistedEvents(AppEventDiskStore.readAndClearStore());
            try {
                FlushStatistics flushStatisticsSendEventsToServer = sendEventsToServer(reason, appEventCollection);
                if (flushStatisticsSendEventsToServer != null) {
                    Intent intent = new Intent(AppEventsLogger.ACTION_APP_EVENTS_FLUSHED);
                    intent.putExtra(AppEventsLogger.APP_EVENTS_EXTRA_NUM_EVENTS_FLUSHED, flushStatisticsSendEventsToServer.getNumEvents());
                    intent.putExtra(AppEventsLogger.APP_EVENTS_EXTRA_FLUSH_RESULT, flushStatisticsSendEventsToServer.getResult());
                    a_u.b(FacebookSdk.getApplicationContext()).d(intent);
                }
            } catch (Exception e2) {
                Log.w(TAG, "Caught unexpected exception while flushing app events: ", e2);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventQueue.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: flushRunnable$lambda-0, reason: not valid java name */
    public static final void m31flushRunnable$lambda0() {
        if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
            return;
        }
        try {
            scheduledFuture = null;
            if (AppEventsLogger.INSTANCE.getFlushBehavior() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY) {
                flushAndWait(FlushReason.TIMER);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventQueue.class);
        }
    }

    @JvmStatic
    @NotNull
    public static final Set<AccessTokenAppIdPair> getKeySet() {
        if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
            return null;
        }
        try {
            return appEventCollection.keySet();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventQueue.class);
            return null;
        }
    }

    @JvmStatic
    public static final void handleResponse(@NotNull final AccessTokenAppIdPair accessTokenAppId, @NotNull GraphRequest request, @NotNull GraphResponse response, @NotNull final SessionEventsState appEvents, @NotNull FlushStatistics flushState) {
        String string;
        if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
            return;
        }
        try {
            kotlin.jvm.internal.s.e(accessTokenAppId, "accessTokenAppId");
            kotlin.jvm.internal.s.e(request, "request");
            kotlin.jvm.internal.s.e(response, "response");
            kotlin.jvm.internal.s.e(appEvents, "appEvents");
            kotlin.jvm.internal.s.e(flushState, "flushState");
            FacebookRequestError error = response.getError();
            String str = "Success";
            FlushResult flushResult = FlushResult.SUCCESS;
            boolean z2 = true;
            if (error != null) {
                if (error.getErrorCode() == -1) {
                    str = "Failed: No Connectivity";
                    flushResult = FlushResult.NO_CONNECTIVITY;
                } else {
                    x xVar = x.f3460a;
                    str = String.format("Failed:\n  Response: %s\n  Error %s", Arrays.copyOf(new Object[]{response.toString(), error.toString()}, 2));
                    kotlin.jvm.internal.s.d(str, "java.lang.String.format(format, *args)");
                    flushResult = FlushResult.SERVER_ERROR;
                }
            }
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.APP_EVENTS)) {
                try {
                    string = new JSONArray((String) request.getTag()).toString(2);
                    kotlin.jvm.internal.s.d(string, "{\n            val jsonArray = JSONArray(eventsJsonString)\n            jsonArray.toString(2)\n          }");
                } catch (JSONException unused) {
                    string = "<Can't encode events for debug logging>";
                }
                Logger.Companion companion = Logger.INSTANCE;
                LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
                String TAG2 = TAG;
                kotlin.jvm.internal.s.d(TAG2, "TAG");
                companion.log(loggingBehavior, TAG2, "Flush completed\nParams: %s\n  Result: %s\n  Events JSON: %s", String.valueOf(request.getGraphObject()), str, string);
            }
            if (error == null) {
                z2 = false;
            }
            appEvents.clearInFlightAndStats(z2);
            FlushResult flushResult2 = FlushResult.NO_CONNECTIVITY;
            if (flushResult == flushResult2) {
                FacebookSdk.getExecutor().execute(new Runnable() { // from class: com.facebook.appevents.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        AppEventQueue.m32handleResponse$lambda5(accessTokenAppId, appEvents);
                    }
                });
            }
            if (flushResult == FlushResult.SUCCESS || flushState.getResult() == flushResult2) {
                return;
            }
            flushState.setResult(flushResult);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventQueue.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleResponse$lambda-5, reason: not valid java name */
    public static final void m32handleResponse$lambda5(AccessTokenAppIdPair accessTokenAppId, SessionEventsState appEvents) {
        if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
            return;
        }
        try {
            kotlin.jvm.internal.s.e(accessTokenAppId, "$accessTokenAppId");
            kotlin.jvm.internal.s.e(appEvents, "$appEvents");
            AppEventStore.persistEvents(accessTokenAppId, appEvents);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventQueue.class);
        }
    }

    @JvmStatic
    public static final void persistToDisk() {
        if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
            return;
        }
        try {
            singleThreadExecutor.execute(new Runnable() { // from class: com.facebook.appevents.f
                @Override // java.lang.Runnable
                public final void run() {
                    AppEventQueue.m33persistToDisk$lambda1();
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventQueue.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: persistToDisk$lambda-1, reason: not valid java name */
    public static final void m33persistToDisk$lambda1() {
        if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
            return;
        }
        try {
            AppEventStore appEventStore = AppEventStore.INSTANCE;
            AppEventStore.persistEvents(appEventCollection);
            appEventCollection = new AppEventCollection();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventQueue.class);
        }
    }

    @JvmStatic
    @VisibleForTesting(otherwise = 2)
    @Nullable
    public static final FlushStatistics sendEventsToServer(@NotNull FlushReason reason, @NotNull AppEventCollection appEventCollection2) {
        if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
            return null;
        }
        try {
            kotlin.jvm.internal.s.e(reason, "reason");
            kotlin.jvm.internal.s.e(appEventCollection2, "appEventCollection");
            FlushStatistics flushStatistics = new FlushStatistics();
            List<GraphRequest> listBuildRequests = buildRequests(appEventCollection2, flushStatistics);
            if (!(!listBuildRequests.isEmpty())) {
                return null;
            }
            Logger.Companion companion = Logger.INSTANCE;
            LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
            String TAG2 = TAG;
            kotlin.jvm.internal.s.d(TAG2, "TAG");
            companion.log(loggingBehavior, TAG2, "Flushing %d events due to %s.", Integer.valueOf(flushStatistics.getNumEvents()), reason.toString());
            Iterator<GraphRequest> it = listBuildRequests.iterator();
            while (it.hasNext()) {
                it.next().executeAndWait();
            }
            return flushStatistics;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventQueue.class);
            return null;
        }
    }
}
