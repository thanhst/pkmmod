package com.facebook.appevents.cloudbridge;

import com.facebook.GraphRequest;
import com.facebook.LoggingBehavior;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.share.internal.ShareConstants;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.UninitializedPropertyAccessException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.k0;
import kotlin.collections.l0;
import kotlin.collections.r0;
import kotlin.j;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.y;
import kotlin.t;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p0.p_p0;
import s0.f_s0;

/* compiled from: AppEventsConversionsAPITransformerWebRequests.kt */
@Metadata(bv = {}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001GB\t\b\u0002¢\u0006\u0004\bE\u0010FJ \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0007J\n\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0007J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0007J$\u0010\u000e\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\r\u0018\u00010\f2\u0006\u0010\n\u001a\u00020\tH\u0002J=\u0010\u0015\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0018\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\r0\f2\b\b\u0002\u0010\u0012\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u0013\u0010\u0014J+\u0010\u0019\u001a\u00020\u00062\u001a\u0010\u0016\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\r\u0018\u00010\fH\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0087\u0001\u0010&\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u00022\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\r2\b\b\u0002\u0010\u001e\u001a\u00020\u000f2<\u0010#\u001a8\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001fH\u0000¢\u0006\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\u000f8\u0000X\u0080T¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b+\u0010*R\u0014\u0010,\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b,\u0010*R$\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\u000f0-j\b\u0012\u0004\u0012\u00020\u000f`.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R$\u00101\u001a\u0012\u0012\u0004\u0012\u00020\u000f0-j\b\u0012\u0004\u0012\u00020\u000f`.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00100R\"\u00103\u001a\u0002028\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R4\u0010:\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\r098\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010\u0018R\u0014\u0010?\u001a\u00020\u000f8\u0000X\u0080T¢\u0006\u0006\n\u0004\b?\u0010*R\"\u0010@\u001a\u00020\u000f8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b@\u0010*\u001a\u0004\bA\u0010B\"\u0004\bC\u0010D¨\u0006H"}, d2 = {"Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformerWebRequests;", "", "", "datasetID", "url", "accessKey", "Lkotlin/t;", "configure", "getCredentials", "Lcom/facebook/GraphRequest;", "request", "transformGraphRequestAndSendToCAPIGEndPoint", "", "", "transformAppEventRequestForCAPIG", "", "responseCode", "processedEvents", "maxRetryCount", "handleError$facebook_core_release", "(Ljava/lang/Integer;Ljava/util/List;I)V", "handleError", "events", "appendEvents$facebook_core_release", "(Ljava/util/List;)V", "appendEvents", "urlStr", "requestMethod", "jsonBodyStr", "requestProperties", "timeOutInterval", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "requestResult", "requestCallback", "makeHttpRequest$facebook_core_release", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;ILp0/p;)V", "makeHttpRequest", "TAG", "Ljava/lang/String;", "MAX_CACHED_TRANSFORMED_EVENTS", "I", "MAX_PROCESSED_TRANSFORMED_EVENTS", "TIMEOUT_INTERVAL", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "ACCEPTABLE_HTTP_RESPONSE", "Ljava/util/HashSet;", "RETRY_EVENTS_HTTP_RESPONSE", "Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformerWebRequests$CloudBridgeCredentials;", "credentials", "Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformerWebRequests$CloudBridgeCredentials;", "getCredentials$facebook_core_release", "()Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformerWebRequests$CloudBridgeCredentials;", "setCredentials$facebook_core_release", "(Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformerWebRequests$CloudBridgeCredentials;)V", "", "transformedEvents", "Ljava/util/List;", "getTransformedEvents$facebook_core_release", "()Ljava/util/List;", "setTransformedEvents$facebook_core_release", "MAX_RETRY_COUNT", "currentRetryCount", "getCurrentRetryCount$facebook_core_release", "()I", "setCurrentRetryCount$facebook_core_release", "(I)V", "<init>", "()V", "CloudBridgeCredentials", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AppEventsConversionsAPITransformerWebRequests {
    public static final int MAX_CACHED_TRANSFORMED_EVENTS = 1000;
    private static final int MAX_PROCESSED_TRANSFORMED_EVENTS = 10;
    public static final int MAX_RETRY_COUNT = 5;

    @NotNull
    private static final String TAG = "CAPITransformerWebRequests";
    private static final int TIMEOUT_INTERVAL = 60000;
    public static CloudBridgeCredentials credentials;
    private static int currentRetryCount;
    public static List<Map<String, Object>> transformedEvents;

    @NotNull
    public static final AppEventsConversionsAPITransformerWebRequests INSTANCE = new AppEventsConversionsAPITransformerWebRequests();

    @NotNull
    private static final HashSet<Integer> ACCEPTABLE_HTTP_RESPONSE = r0.e(200, 202);

    @NotNull
    private static final HashSet<Integer> RETRY_EVENTS_HTTP_RESPONSE = r0.e(503, 504, 429);

    /* compiled from: AppEventsConversionsAPITransformerWebRequests.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformerWebRequests$CloudBridgeCredentials;", "", "datasetID", "", "cloudBridgeURL", "accessKey", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccessKey", "()Ljava/lang/String;", "getCloudBridgeURL", "getDatasetID", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final /* data */ class CloudBridgeCredentials {

        @NotNull
        private final String accessKey;

        @NotNull
        private final String cloudBridgeURL;

        @NotNull
        private final String datasetID;

        public CloudBridgeCredentials(@NotNull String datasetID, @NotNull String cloudBridgeURL, @NotNull String accessKey) {
            s.e(datasetID, "datasetID");
            s.e(cloudBridgeURL, "cloudBridgeURL");
            s.e(accessKey, "accessKey");
            this.datasetID = datasetID;
            this.cloudBridgeURL = cloudBridgeURL;
            this.accessKey = accessKey;
        }

        public static /* synthetic */ CloudBridgeCredentials copy$default(CloudBridgeCredentials cloudBridgeCredentials, String str, String str2, String str3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = cloudBridgeCredentials.datasetID;
            }
            if ((i2 & 2) != 0) {
                str2 = cloudBridgeCredentials.cloudBridgeURL;
            }
            if ((i2 & 4) != 0) {
                str3 = cloudBridgeCredentials.accessKey;
            }
            return cloudBridgeCredentials.copy(str, str2, str3);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getDatasetID() {
            return this.datasetID;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getCloudBridgeURL() {
            return this.cloudBridgeURL;
        }

        @NotNull
        /* renamed from: component3, reason: from getter */
        public final String getAccessKey() {
            return this.accessKey;
        }

        @NotNull
        public final CloudBridgeCredentials copy(@NotNull String datasetID, @NotNull String cloudBridgeURL, @NotNull String accessKey) {
            s.e(datasetID, "datasetID");
            s.e(cloudBridgeURL, "cloudBridgeURL");
            s.e(accessKey, "accessKey");
            return new CloudBridgeCredentials(datasetID, cloudBridgeURL, accessKey);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CloudBridgeCredentials)) {
                return false;
            }
            CloudBridgeCredentials cloudBridgeCredentials = (CloudBridgeCredentials) other;
            return s.a(this.datasetID, cloudBridgeCredentials.datasetID) && s.a(this.cloudBridgeURL, cloudBridgeCredentials.cloudBridgeURL) && s.a(this.accessKey, cloudBridgeCredentials.accessKey);
        }

        @NotNull
        public final String getAccessKey() {
            return this.accessKey;
        }

        @NotNull
        public final String getCloudBridgeURL() {
            return this.cloudBridgeURL;
        }

        @NotNull
        public final String getDatasetID() {
            return this.datasetID;
        }

        public int hashCode() {
            return (((this.datasetID.hashCode() * 31) + this.cloudBridgeURL.hashCode()) * 31) + this.accessKey.hashCode();
        }

        @NotNull
        public String toString() {
            return "CloudBridgeCredentials(datasetID=" + this.datasetID + ", cloudBridgeURL=" + this.cloudBridgeURL + ", accessKey=" + this.accessKey + ')';
        }
    }

    private AppEventsConversionsAPITransformerWebRequests() {
    }

    @JvmStatic
    public static final void configure(@NotNull String datasetID, @NotNull String url, @NotNull String accessKey) {
        s.e(datasetID, "datasetID");
        s.e(url, "url");
        s.e(accessKey, "accessKey");
        Logger.INSTANCE.log(LoggingBehavior.APP_EVENTS, TAG, " \n\nCloudbridge Configured: \n================\ndatasetID: %s\nurl: %s\naccessKey: %s\n\n", datasetID, url, accessKey);
        AppEventsConversionsAPITransformerWebRequests appEventsConversionsAPITransformerWebRequests = INSTANCE;
        appEventsConversionsAPITransformerWebRequests.setCredentials$facebook_core_release(new CloudBridgeCredentials(datasetID, url, accessKey));
        appEventsConversionsAPITransformerWebRequests.setTransformedEvents$facebook_core_release(new ArrayList());
    }

    @JvmStatic
    @Nullable
    public static final String getCredentials() {
        try {
            CloudBridgeCredentials credentials$facebook_core_release = INSTANCE.getCredentials$facebook_core_release();
            if (credentials$facebook_core_release == null) {
                return null;
            }
            return credentials$facebook_core_release.toString();
        } catch (UninitializedPropertyAccessException unused) {
            return null;
        }
    }

    public static /* synthetic */ void handleError$facebook_core_release$default(AppEventsConversionsAPITransformerWebRequests appEventsConversionsAPITransformerWebRequests, Integer num, List list, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 5;
        }
        appEventsConversionsAPITransformerWebRequests.handleError$facebook_core_release(num, list, i2);
    }

    private final List<Map<String, Object>> transformAppEventRequestForCAPIG(GraphRequest request) {
        JSONObject graphObject = request.getGraphObject();
        if (graphObject == null) {
            return null;
        }
        Map<String, ? extends Object> mapP = l0.p(Utility.convertJSONObjectToHashMap(graphObject));
        Object tag = request.getTag();
        if (tag == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
        }
        mapP.put("custom_events", tag);
        StringBuilder sb = new StringBuilder();
        for (String str : mapP.keySet()) {
            sb.append(str);
            sb.append(" : ");
            sb.append(mapP.get(str));
            sb.append(System.getProperty("line.separator"));
        }
        Logger.INSTANCE.log(LoggingBehavior.APP_EVENTS, TAG, "\nGraph Request data: \n\n%s \n\n", sb);
        return AppEventsConversionsAPITransformer.INSTANCE.conversionsAPICompatibleEvent$facebook_core_release(mapP);
    }

    @JvmStatic
    public static final void transformGraphRequestAndSendToCAPIGEndPoint(@NotNull final GraphRequest request) {
        s.e(request, "request");
        Utility utility = Utility.INSTANCE;
        Utility.runOnNonUiThread(new Runnable() { // from class: com.facebook.appevents.cloudbridge.b
            @Override // java.lang.Runnable
            public final void run() throws JSONException, IOException {
                AppEventsConversionsAPITransformerWebRequests.m48transformGraphRequestAndSendToCAPIGEndPoint$lambda0(request);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: transformGraphRequestAndSendToCAPIGEndPoint$lambda-0, reason: not valid java name */
    public static final void m48transformGraphRequestAndSendToCAPIGEndPoint$lambda0(GraphRequest request) throws JSONException, IOException {
        s.e(request, "$request");
        String graphPath = request.getGraphPath();
        List listC0 = graphPath == null ? null : StringsKt__StringsKt.c0(graphPath, new String[]{"/"}, false, 0, 6, null);
        if (listC0 == null || listC0.size() != 2) {
            Logger.INSTANCE.log(LoggingBehavior.DEVELOPER_ERRORS, TAG, "\n GraphPathComponents Error when logging: \n%s", request);
            return;
        }
        try {
            AppEventsConversionsAPITransformerWebRequests appEventsConversionsAPITransformerWebRequests = INSTANCE;
            String str = appEventsConversionsAPITransformerWebRequests.getCredentials$facebook_core_release().getCloudBridgeURL() + "/capi/" + appEventsConversionsAPITransformerWebRequests.getCredentials$facebook_core_release().getDatasetID() + "/events";
            List<Map<String, Object>> listTransformAppEventRequestForCAPIG = appEventsConversionsAPITransformerWebRequests.transformAppEventRequestForCAPIG(request);
            if (listTransformAppEventRequestForCAPIG == null) {
                return;
            }
            appEventsConversionsAPITransformerWebRequests.appendEvents$facebook_core_release(listTransformAppEventRequestForCAPIG);
            int iMin = Math.min(appEventsConversionsAPITransformerWebRequests.getTransformedEvents$facebook_core_release().size(), 10);
            List listS = CollectionsKt___CollectionsKt.S(appEventsConversionsAPITransformerWebRequests.getTransformedEvents$facebook_core_release(), new f_s0(0, iMin - 1));
            appEventsConversionsAPITransformerWebRequests.getTransformedEvents$facebook_core_release().subList(0, iMin).clear();
            JSONArray jSONArray = new JSONArray((Collection) listS);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(ShareConstants.WEB_DIALOG_PARAM_DATA, jSONArray);
            linkedHashMap.put("accessKey", appEventsConversionsAPITransformerWebRequests.getCredentials$facebook_core_release().getAccessKey());
            JSONObject jSONObject = new JSONObject(linkedHashMap);
            Logger.Companion companion = Logger.INSTANCE;
            LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
            String string = jSONObject.toString(2);
            s.d(string, "jsonBodyStr.toString(2)");
            companion.log(loggingBehavior, TAG, "\nTransformed_CAPI_JSON:\nURL: %s\nFROM=========\n%s\n>>>>>>TO>>>>>>\n%s\n=============\n", str, request, string);
            appEventsConversionsAPITransformerWebRequests.makeHttpRequest$facebook_core_release(str, "POST", jSONObject.toString(), k0.d(j.a("Content-Type", "application/json")), 60000, new AppEventsConversionsAPITransformerWebRequests$transformGraphRequestAndSendToCAPIGEndPoint$1$1(listS));
        } catch (UninitializedPropertyAccessException e2) {
            Logger.INSTANCE.log(LoggingBehavior.DEVELOPER_ERRORS, TAG, "\n Credentials not initialized Error when logging: \n%s", e2);
        }
    }

    public final void appendEvents$facebook_core_release(@Nullable List<? extends Map<String, ? extends Object>> events) {
        if (events != null) {
            getTransformedEvents$facebook_core_release().addAll(events);
        }
        int iMax = Math.max(0, getTransformedEvents$facebook_core_release().size() - 1000);
        if (iMax > 0) {
            setTransformedEvents$facebook_core_release(y.a(CollectionsKt___CollectionsKt.x(getTransformedEvents$facebook_core_release(), iMax)));
        }
    }

    @NotNull
    public final CloudBridgeCredentials getCredentials$facebook_core_release() {
        CloudBridgeCredentials cloudBridgeCredentials = credentials;
        if (cloudBridgeCredentials != null) {
            return cloudBridgeCredentials;
        }
        s.t("credentials");
        throw null;
    }

    public final int getCurrentRetryCount$facebook_core_release() {
        return currentRetryCount;
    }

    @NotNull
    public final List<Map<String, Object>> getTransformedEvents$facebook_core_release() {
        List<Map<String, Object>> list = transformedEvents;
        if (list != null) {
            return list;
        }
        s.t("transformedEvents");
        throw null;
    }

    public final void handleError$facebook_core_release(@Nullable Integer responseCode, @NotNull List<? extends Map<String, ? extends Object>> processedEvents, int maxRetryCount) {
        s.e(processedEvents, "processedEvents");
        if (CollectionsKt___CollectionsKt.w(RETRY_EVENTS_HTTP_RESPONSE, responseCode)) {
            if (currentRetryCount >= maxRetryCount) {
                getTransformedEvents$facebook_core_release().clear();
                currentRetryCount = 0;
            } else {
                getTransformedEvents$facebook_core_release().addAll(0, processedEvents);
                currentRetryCount++;
            }
        }
    }

    public final void makeHttpRequest$facebook_core_release(@NotNull String urlStr, @NotNull String requestMethod, @Nullable String jsonBodyStr, @Nullable Map<String, String> requestProperties, int timeOutInterval, @Nullable p_p0<? super String, ? super Integer, t> requestCallback) throws IOException {
        Set<String> setKeySet;
        s.e(urlStr, "urlStr");
        s.e(requestMethod, "requestMethod");
        try {
            URLConnection uRLConnectionOpenConnection = new URL(urlStr).openConnection();
            if (uRLConnectionOpenConnection == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
            httpURLConnection.setRequestMethod(requestMethod);
            if (requestProperties != null && (setKeySet = requestProperties.keySet()) != null) {
                for (String str : setKeySet) {
                    httpURLConnection.setRequestProperty(str, requestProperties.get(str));
                }
            }
            httpURLConnection.setDoOutput(httpURLConnection.getRequestMethod().equals("POST") || httpURLConnection.getRequestMethod().equals("PUT"));
            httpURLConnection.setConnectTimeout(timeOutInterval);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(bufferedOutputStream, "UTF-8"));
            bufferedWriter.write(jsonBodyStr);
            bufferedWriter.flush();
            bufferedWriter.close();
            bufferedOutputStream.close();
            StringBuilder sb = new StringBuilder();
            if (ACCEPTABLE_HTTP_RESPONSE.contains(Integer.valueOf(httpURLConnection.getResponseCode()))) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        } else {
                            sb.append(line);
                        }
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            kotlin.io.a.a(bufferedReader, th);
                            throw th2;
                        }
                    }
                }
                t tVar = t.f3507a;
                kotlin.io.a.a(bufferedReader, null);
            }
            String string = sb.toString();
            s.d(string, "connResponseSB.toString()");
            Logger.INSTANCE.log(LoggingBehavior.APP_EVENTS, TAG, "\nResponse Received: \n%s\n%s", string, Integer.valueOf(httpURLConnection.getResponseCode()));
            if (requestCallback != null) {
                requestCallback.invoke(string, Integer.valueOf(httpURLConnection.getResponseCode()));
            }
        } catch (UnknownHostException e2) {
            Logger.INSTANCE.log(LoggingBehavior.APP_EVENTS, TAG, "Connection failed, retrying: \n%s", e2.toString());
            if (requestCallback != null) {
                requestCallback.invoke(null, 503);
            }
        } catch (IOException e3) {
            Logger.INSTANCE.log(LoggingBehavior.DEVELOPER_ERRORS, TAG, "Send to server failed: \n%s", e3.toString());
        }
    }

    public final void setCredentials$facebook_core_release(@NotNull CloudBridgeCredentials cloudBridgeCredentials) {
        s.e(cloudBridgeCredentials, "<set-?>");
        credentials = cloudBridgeCredentials;
    }

    public final void setCurrentRetryCount$facebook_core_release(int i2) {
        currentRetryCount = i2;
    }

    public final void setTransformedEvents$facebook_core_release(@NotNull List<Map<String, Object>> list) {
        s.e(list, "<set-?>");
        transformedEvents = list;
    }
}
