package com.facebook;

import android.content.Context;
import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.VisibleForTesting;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestBatch;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.InternalSettings;
import com.facebook.internal.Logger;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.share.internal.ShareConstants;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.x;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: GraphRequest.kt */
@Metadata(bv = {}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 g2\u00020\u0001:\thigjklmnoBQ\b\u0017\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010<\u0012\n\b\u0002\u0010U\u001a\u0004\u0018\u00010S\u0012\n\b\u0002\u0010M\u001a\u0004\u0018\u00010L\u0012\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\bc\u0010dB\u001b\b\u0010\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\u0006\u0010\\\u001a\u00020e¢\u0006\u0004\bc\u0010fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u00020\bH\u0002J$\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\u000e\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\bJ\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u0010\u001a\u001a\u00020\u0019J\b\u0010\u001b\u001a\u00020\u0004H\u0016R$\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010#\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010*\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u00100\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010$\u001a\u0004\b1\u0010&\"\u0004\b2\u0010(R$\u00103\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010$\u001a\u0004\b4\u0010&\"\u0004\b5\u0010(R\"\u00106\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010=\u001a\u00020<8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR$\u0010C\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR$\u0010I\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u0010$\u001a\u0004\bJ\u0010&\"\u0004\bK\u0010(R.\u0010M\u001a\u0004\u0018\u00010L2\b\u0010M\u001a\u0004\u0018\u00010L8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR.\u0010U\u001a\u0004\u0018\u00010S2\b\u0010T\u001a\u0004\u0018\u00010S8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u0016\u0010[\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u00107R\u0018\u0010\\\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010$R\u0016\u0010^\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b]\u0010&R\u0011\u0010`\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b_\u0010&R\u0011\u0010b\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\ba\u0010&¨\u0006p"}, d2 = {"Lcom/facebook/GraphRequest;", "", "Lkotlin/t;", "addCommonParameters", "", "getAccessTokenToUseForRequest", "getClientTokenForRequest", "baseUrl", "", "isBatch", "appendParametersToBaseUrl", "getUrlWithGraphPath", "shouldForceClientTokenForRequest", "isValidGraphRequestForDomain", "isApplicationRequest", "Lorg/json/JSONArray;", GraphRequest.BATCH_PARAM, "", "Lcom/facebook/GraphRequest$Attachment;", "attachments", "serializeToBatch", "forceOverride", "setForceApplicationRequest", "Lcom/facebook/GraphResponse;", "executeAndWait", "Lcom/facebook/GraphRequestAsyncTask;", "executeAsync", "toString", "Lcom/facebook/AccessToken;", "accessToken", "Lcom/facebook/AccessToken;", "getAccessToken", "()Lcom/facebook/AccessToken;", "setAccessToken", "(Lcom/facebook/AccessToken;)V", "graphPath", "Ljava/lang/String;", "getGraphPath", "()Ljava/lang/String;", "setGraphPath", "(Ljava/lang/String;)V", "Lorg/json/JSONObject;", "graphObject", "Lorg/json/JSONObject;", "getGraphObject", "()Lorg/json/JSONObject;", "setGraphObject", "(Lorg/json/JSONObject;)V", "batchEntryName", "getBatchEntryName", "setBatchEntryName", "batchEntryDependsOn", "getBatchEntryDependsOn", "setBatchEntryDependsOn", "batchEntryOmitResultOnSuccess", "Z", "getBatchEntryOmitResultOnSuccess", "()Z", "setBatchEntryOmitResultOnSuccess", "(Z)V", "Landroid/os/Bundle;", "parameters", "Landroid/os/Bundle;", "getParameters", "()Landroid/os/Bundle;", "setParameters", "(Landroid/os/Bundle;)V", ViewHierarchyConstants.TAG_KEY, "Ljava/lang/Object;", "getTag", "()Ljava/lang/Object;", "setTag", "(Ljava/lang/Object;)V", "version", "getVersion", "setVersion", "Lcom/facebook/GraphRequest$Callback;", "callback", "Lcom/facebook/GraphRequest$Callback;", "getCallback", "()Lcom/facebook/GraphRequest$Callback;", "setCallback", "(Lcom/facebook/GraphRequest$Callback;)V", "Lcom/facebook/HttpMethod;", "value", "httpMethod", "Lcom/facebook/HttpMethod;", "getHttpMethod", "()Lcom/facebook/HttpMethod;", "setHttpMethod", "(Lcom/facebook/HttpMethod;)V", "forceApplicationRequest", "overriddenURL", "getGraphPathWithVersion", "graphPathWithVersion", "getRelativeUrlForBatchedRequest", "relativeUrlForBatchedRequest", "getUrlForSingleRequest", "urlForSingleRequest", "<init>", "(Lcom/facebook/AccessToken;Ljava/lang/String;Landroid/os/Bundle;Lcom/facebook/HttpMethod;Lcom/facebook/GraphRequest$Callback;Ljava/lang/String;)V", "Ljava/net/URL;", "(Lcom/facebook/AccessToken;Ljava/net/URL;)V", "Companion", "Attachment", "Callback", "GraphJSONArrayCallback", "GraphJSONObjectCallback", "KeyValueSerializer", "OnProgressCallback", "ParcelableResourceWithMimeType", "Serializer", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class GraphRequest {

    @NotNull
    private static final String ACCEPT_LANGUAGE_HEADER = "Accept-Language";

    @NotNull
    public static final String ACCESS_TOKEN_PARAM = "access_token";

    @NotNull
    private static final String ATTACHED_FILES_PARAM = "attached_files";

    @NotNull
    private static final String ATTACHMENT_FILENAME_PREFIX = "file";

    @NotNull
    private static final String BATCH_APP_ID_PARAM = "batch_app_id";

    @NotNull
    private static final String BATCH_BODY_PARAM = "body";

    @NotNull
    private static final String BATCH_ENTRY_DEPENDS_ON_PARAM = "depends_on";

    @NotNull
    private static final String BATCH_ENTRY_NAME_PARAM = "name";

    @NotNull
    private static final String BATCH_ENTRY_OMIT_RESPONSE_ON_SUCCESS_PARAM = "omit_response_on_success";

    @NotNull
    private static final String BATCH_METHOD_PARAM = "method";

    @NotNull
    private static final String BATCH_PARAM = "batch";

    @NotNull
    private static final String BATCH_RELATIVE_URL_PARAM = "relative_url";

    @NotNull
    private static final String CAPTION_PARAM = "caption";

    @NotNull
    private static final String CONTENT_ENCODING_HEADER = "Content-Encoding";

    @NotNull
    private static final String CONTENT_TYPE_HEADER = "Content-Type";

    @NotNull
    private static final String DEBUG_KEY = "__debug__";

    @NotNull
    private static final String DEBUG_MESSAGES_KEY = "messages";

    @NotNull
    private static final String DEBUG_MESSAGE_KEY = "message";

    @NotNull
    private static final String DEBUG_MESSAGE_LINK_KEY = "link";

    @NotNull
    private static final String DEBUG_MESSAGE_TYPE_KEY = "type";

    @NotNull
    private static final String DEBUG_PARAM = "debug";

    @NotNull
    private static final String DEBUG_SEVERITY_INFO = "info";

    @NotNull
    private static final String DEBUG_SEVERITY_WARNING = "warning";

    @NotNull
    public static final String FIELDS_PARAM = "fields";

    @NotNull
    private static final String FORMAT_JSON = "json";

    @NotNull
    private static final String FORMAT_PARAM = "format";

    @NotNull
    private static final String ISO_8601_FORMAT_STRING = "yyyy-MM-dd'T'HH:mm:ssZ";
    public static final int MAXIMUM_BATCH_SIZE = 50;

    @NotNull
    private static final String ME = "me";

    @NotNull
    private static final String MIME_BOUNDARY;

    @NotNull
    private static final String MY_FRIENDS = "me/friends";

    @NotNull
    private static final String MY_PHOTOS = "me/photos";

    @NotNull
    private static final String PICTURE_PARAM = "picture";

    @NotNull
    private static final String SDK_ANDROID = "android";

    @NotNull
    private static final String SDK_PARAM = "sdk";

    @NotNull
    private static final String SEARCH = "search";

    @NotNull
    private static final String USER_AGENT_BASE = "FBAndroidSDK";

    @NotNull
    private static final String USER_AGENT_HEADER = "User-Agent";

    @NotNull
    private static final String VIDEOS_SUFFIX = "/videos";

    @Nullable
    private static String defaultBatchApplicationId;

    @Nullable
    private static volatile String userAgent;
    private static final Pattern versionPattern;

    @Nullable
    private AccessToken accessToken;

    @Nullable
    private String batchEntryDependsOn;

    @Nullable
    private String batchEntryName;
    private boolean batchEntryOmitResultOnSuccess;

    @Nullable
    private Callback callback;
    private boolean forceApplicationRequest;

    @Nullable
    private JSONObject graphObject;

    @Nullable
    private String graphPath;

    @Nullable
    private HttpMethod httpMethod;

    @Nullable
    private String overriddenURL;

    @NotNull
    private Bundle parameters;

    @Nullable
    private Object tag;

    @Nullable
    private String version;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    public static final String TAG = GraphRequest.class.getSimpleName();

    /* compiled from: GraphRequest.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/facebook/GraphRequest$Attachment;", "", "request", "Lcom/facebook/GraphRequest;", "value", "(Lcom/facebook/GraphRequest;Ljava/lang/Object;)V", "getRequest", "()Lcom/facebook/GraphRequest;", "getValue", "()Ljava/lang/Object;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Attachment {

        @NotNull
        private final GraphRequest request;

        @Nullable
        private final Object value;

        public Attachment(@NotNull GraphRequest request, @Nullable Object obj) {
            kotlin.jvm.internal.s.e(request, "request");
            this.request = request;
            this.value = obj;
        }

        @NotNull
        public final GraphRequest getRequest() {
            return this.request;
        }

        @Nullable
        public final Object getValue() {
            return this.value;
        }
    }

    /* compiled from: GraphRequest.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/facebook/GraphRequest$Callback;", "", "Lcom/facebook/GraphResponse;", "response", "Lkotlin/t;", "onCompleted", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public interface Callback {
        void onCompleted(@NotNull GraphResponse graphResponse);
    }

    /* compiled from: GraphRequest.kt */
    @Metadata(bv = {}, d1 = {"\u0000ð\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0010%\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b>\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u000b\b\u0002¢\u0006\u0006\b¨\u0001\u0010 \u0001J\u0012\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J:\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0002H\u0002J \u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J(\u0010#\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u000bH\u0002J \u0010)\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020&2\u0006\u0010(\u001a\u00020'H\u0002J$\u0010-\u001a\u00020\u000f2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020+0*2\u0006\u0010\u001e\u001a\u00020&H\u0002J2\u00100\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020&2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020'0.2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020+0/H\u0002J\u0010\u00102\u001a\u00020\u00022\u0006\u00101\u001a\u00020\tH\u0002J\u0012\u00103\u001a\u00020\u000b2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u0002J\u0012\u00104\u001a\u00020\u000b2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u0002J\u0012\u00105\u001a\u00020\u00022\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u0002J\n\u00106\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u00108\u001a\u00020\u000f2\b\u00107\u001a\u0004\u0018\u00010\u0002H\u0007J&\u0010>\u001a\u00020'2\b\u0010:\u001a\u0004\u0018\u0001092\b\u0010;\u001a\u0004\u0018\u00010\u00022\b\u0010=\u001a\u0004\u0018\u00010<H\u0007J\u001c\u0010@\u001a\u00020'2\b\u0010:\u001a\u0004\u0018\u0001092\b\u0010=\u001a\u0004\u0018\u00010?H\u0007J0\u0010A\u001a\u00020'2\b\u0010:\u001a\u0004\u0018\u0001092\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010=\u001a\u0004\u0018\u00010<H\u0007J0\u0010C\u001a\u00020'2\b\u0010:\u001a\u0004\u0018\u0001092\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010B\u001a\u0004\u0018\u00010$2\b\u0010=\u001a\u0004\u0018\u00010<H\u0007J\u001c\u0010E\u001a\u00020'2\b\u0010:\u001a\u0004\u0018\u0001092\b\u0010=\u001a\u0004\u0018\u00010DH\u0007J&\u0010F\u001a\u00020'2\b\u0010:\u001a\u0004\u0018\u0001092\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010=\u001a\u0004\u0018\u00010<H\u0007J@\u0010L\u001a\u00020'2\b\u0010:\u001a\u0004\u0018\u0001092\b\u0010H\u001a\u0004\u0018\u00010G2\u0006\u0010I\u001a\u00020\u00142\u0006\u0010J\u001a\u00020\u00142\b\u0010K\u001a\u0004\u0018\u00010\u00022\b\u0010=\u001a\u0004\u0018\u00010DH\u0007JB\u0010Q\u001a\u00020'2\b\u0010:\u001a\u0004\u0018\u0001092\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010N\u001a\u00020M2\b\u0010O\u001a\u0004\u0018\u00010\u00022\b\u0010P\u001a\u0004\u0018\u00010$2\b\u0010=\u001a\u0004\u0018\u00010<H\u0007JB\u0010Q\u001a\u00020'2\b\u0010:\u001a\u0004\u0018\u0001092\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010S\u001a\u00020R2\b\u0010O\u001a\u0004\u0018\u00010\u00022\b\u0010P\u001a\u0004\u0018\u00010$2\b\u0010=\u001a\u0004\u0018\u00010<H\u0007JB\u0010Q\u001a\u00020'2\b\u0010:\u001a\u0004\u0018\u0001092\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010U\u001a\u00020T2\b\u0010O\u001a\u0004\u0018\u00010\u00022\b\u0010P\u001a\u0004\u0018\u00010$2\b\u0010=\u001a\u0004\u0018\u00010<H\u0007J.\u0010X\u001a\u00020'2\b\u0010:\u001a\u0004\u0018\u0001092\u0006\u0010W\u001a\u00020V2\b\u00107\u001a\u0004\u0018\u00010\u00022\b\u0010=\u001a\u0004\u0018\u00010<H\u0007J$\u0010X\u001a\u00020'2\b\u0010:\u001a\u0004\u0018\u0001092\u0006\u0010W\u001a\u00020V2\b\u0010=\u001a\u0004\u0018\u00010<H\u0007J#\u0010Z\u001a\u00020\u00072\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020'0Y\"\u00020'H\u0007¢\u0006\u0004\bZ\u0010[J\u0016\u0010Z\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020'0.H\u0007J\u0010\u0010Z\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0007J\u0010\u0010]\u001a\u00020\\2\u0006\u0010(\u001a\u00020'H\u0007J)\u0010_\u001a\b\u0012\u0004\u0012\u00020\\0^2\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020'0Y\"\u00020'H\u0007¢\u0006\u0004\b_\u0010`J\u001c\u0010_\u001a\b\u0012\u0004\u0012\u00020\\0^2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020'0.H\u0007J\u0016\u0010_\u001a\b\u0012\u0004\u0012\u00020\\0^2\u0006\u0010\n\u001a\u00020\tH\u0007J#\u0010b\u001a\u00020a2\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020'0Y\"\u00020'H\u0007¢\u0006\u0004\bb\u0010cJ\u0016\u0010b\u001a\u00020a2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020'0.H\u0007J\u0010\u0010b\u001a\u00020a2\u0006\u0010\n\u001a\u00020\tH\u0007J$\u0010d\u001a\b\u0012\u0004\u0012\u00020\\0^2\u0006\u0010\r\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020'0.H\u0007J\u001e\u0010d\u001a\b\u0012\u0004\u0012\u00020\\0^2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0007J\u0018\u0010e\u001a\u00020a2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0007J\"\u0010e\u001a\u00020a2\b\u0010g\u001a\u0004\u0018\u00010f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0007J%\u0010k\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\f\u0010h\u001a\b\u0012\u0004\u0012\u00020\\0^H\u0001¢\u0006\u0004\bi\u0010jJ\u0017\u0010n\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\tH\u0001¢\u0006\u0004\bl\u0010mJ\u001f\u0010q\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0007H\u0001¢\u0006\u0004\bo\u0010pR\u0014\u0010t\u001a\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\br\u0010sR\u001e\u0010u\u001a\u0004\u0018\u00010\u00028B@\u0002X\u0082\u000e¢\u0006\f\n\u0004\bu\u0010v\u001a\u0004\bw\u0010sR\u0014\u0010x\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\bx\u0010vR\u0014\u0010y\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\by\u0010vR\u0014\u0010z\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\bz\u0010vR\u0014\u0010{\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b{\u0010vR\u0014\u0010|\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b|\u0010vR\u0014\u0010}\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b}\u0010vR\u0014\u0010~\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b~\u0010vR\u0014\u0010\u007f\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u007f\u0010vR\u0016\u0010\u0080\u0001\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u0080\u0001\u0010vR\u0016\u0010\u0081\u0001\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u0081\u0001\u0010vR\u0016\u0010\u0082\u0001\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u0082\u0001\u0010vR\u0016\u0010\u0083\u0001\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u0083\u0001\u0010vR\u0016\u0010\u0084\u0001\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u0084\u0001\u0010vR\u0016\u0010\u0085\u0001\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u0085\u0001\u0010vR\u0016\u0010\u0086\u0001\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u0086\u0001\u0010vR\u0016\u0010\u0087\u0001\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u0087\u0001\u0010vR\u0016\u0010\u0088\u0001\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u0088\u0001\u0010vR\u0016\u0010\u0089\u0001\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u0089\u0001\u0010vR\u0016\u0010\u008a\u0001\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u008a\u0001\u0010vR\u0016\u0010\u008b\u0001\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u008b\u0001\u0010vR\u0016\u0010\u008c\u0001\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u008c\u0001\u0010vR\u0016\u0010\u008d\u0001\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u008d\u0001\u0010vR\u0016\u0010\u008e\u0001\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u008e\u0001\u0010vR\u0016\u0010\u008f\u0001\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u008f\u0001\u0010vR\u0016\u0010\u0090\u0001\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u0090\u0001\u0010vR\u0016\u0010\u0091\u0001\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u0091\u0001\u0010vR\u0016\u0010\u0092\u0001\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u0092\u0001\u0010vR\u0017\u0010\u0093\u0001\u001a\u00020\u00148\u0006X\u0086T¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001R\u0016\u0010\u0095\u0001\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u0095\u0001\u0010vR\u0016\u0010\u0096\u0001\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0096\u0001\u0010vR\u0016\u0010\u0097\u0001\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u0097\u0001\u0010vR\u0016\u0010\u0098\u0001\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u0098\u0001\u0010vR\u0016\u0010\u0099\u0001\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u0099\u0001\u0010vR\u0016\u0010\u009a\u0001\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u009a\u0001\u0010vR\u0016\u0010\u009b\u0001\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u009b\u0001\u0010vR\u0016\u0010\u009c\u0001\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u009c\u0001\u0010vR'\u0010\u009e\u0001\u001a\u000b \u009d\u0001*\u0004\u0018\u00010\u00020\u00028\u0000X\u0081\u0004¢\u0006\u000f\n\u0005\b\u009e\u0001\u0010v\u0012\u0006\b\u009f\u0001\u0010 \u0001R\u0016\u0010¡\u0001\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0007\n\u0005\b¡\u0001\u0010vR\u0016\u0010¢\u0001\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0007\n\u0005\b¢\u0001\u0010vR\u0016\u0010£\u0001\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0007\n\u0005\b£\u0001\u0010vR\u001a\u0010¤\u0001\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¤\u0001\u0010vR\"\u0010¦\u0001\u001a\r \u009d\u0001*\u0005\u0018\u00010¥\u00010¥\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¦\u0001\u0010§\u0001¨\u0006©\u0001"}, d2 = {"Lcom/facebook/GraphRequest$Companion;", "", "", "graphPath", "getDefaultPhotoPathIfNull", "Ljava/net/URL;", "url", "Ljava/net/HttpURLConnection;", "createConnection", "Lcom/facebook/GraphRequestBatch;", "requests", "", "hasOnProgressCallbacks", "connection", "shouldUseGzip", "Lkotlin/t;", "setConnectionContentType", "isGzipCompressible", "Lcom/facebook/internal/Logger;", "logger", "", "numRequests", "Ljava/io/OutputStream;", "outputStream", "processRequest", "path", "isMeRequest", "Lorg/json/JSONObject;", "graphObject", "Lcom/facebook/GraphRequest$KeyValueSerializer;", "serializer", "processGraphObject", "key", "value", "passByValue", "processGraphObjectProperty", "Landroid/os/Bundle;", "bundle", "Lcom/facebook/GraphRequest$Serializer;", "Lcom/facebook/GraphRequest;", "request", "serializeParameters", "", "Lcom/facebook/GraphRequest$Attachment;", "attachments", "serializeAttachments", "", "", "serializeRequestsAsJSON", GraphRequest.BATCH_PARAM, "getBatchAppId", "isSupportedAttachmentType", "isSupportedParameterType", "parameterToString", "getDefaultBatchApplicationId", "applicationId", "setDefaultBatchApplicationId", "Lcom/facebook/AccessToken;", "accessToken", "id", "Lcom/facebook/GraphRequest$Callback;", "callback", "newDeleteObjectRequest", "Lcom/facebook/GraphRequest$GraphJSONObjectCallback;", "newMeRequest", "newPostRequest", "parameters", "newPostRequestWithBundle", "Lcom/facebook/GraphRequest$GraphJSONArrayCallback;", "newMyFriendsRequest", "newGraphPathRequest", "Landroid/location/Location;", "location", "radiusInMeters", "resultsLimit", "searchText", "newPlacesSearchRequest", "Landroid/graphics/Bitmap;", "image", "caption", NativeProtocol.WEB_DIALOG_PARAMS, "newUploadPhotoRequest", "Ljava/io/File;", "file", "Landroid/net/Uri;", "photoUri", "Landroid/content/Context;", "context", "newCustomAudienceThirdPartyIdRequest", "", "toHttpConnection", "([Lcom/facebook/GraphRequest;)Ljava/net/HttpURLConnection;", "Lcom/facebook/GraphResponse;", "executeAndWait", "", "executeBatchAndWait", "([Lcom/facebook/GraphRequest;)Ljava/util/List;", "Lcom/facebook/GraphRequestAsyncTask;", "executeBatchAsync", "([Lcom/facebook/GraphRequest;)Lcom/facebook/GraphRequestAsyncTask;", "executeConnectionAndWait", "executeConnectionAsync", "Landroid/os/Handler;", "callbackHandler", "responses", "runCallbacks$facebook_core_release", "(Lcom/facebook/GraphRequestBatch;Ljava/util/List;)V", "runCallbacks", "validateFieldsParamForGetRequests$facebook_core_release", "(Lcom/facebook/GraphRequestBatch;)V", "validateFieldsParamForGetRequests", "serializeToUrlConnection$facebook_core_release", "(Lcom/facebook/GraphRequestBatch;Ljava/net/HttpURLConnection;)V", "serializeToUrlConnection", "getMimeContentType", "()Ljava/lang/String;", "mimeContentType", "userAgent", "Ljava/lang/String;", "getUserAgent", "ACCEPT_LANGUAGE_HEADER", "ACCESS_TOKEN_PARAM", "ATTACHED_FILES_PARAM", "ATTACHMENT_FILENAME_PREFIX", "BATCH_APP_ID_PARAM", "BATCH_BODY_PARAM", "BATCH_ENTRY_DEPENDS_ON_PARAM", "BATCH_ENTRY_NAME_PARAM", "BATCH_ENTRY_OMIT_RESPONSE_ON_SUCCESS_PARAM", "BATCH_METHOD_PARAM", "BATCH_PARAM", "BATCH_RELATIVE_URL_PARAM", "CAPTION_PARAM", "CONTENT_ENCODING_HEADER", "CONTENT_TYPE_HEADER", "DEBUG_KEY", "DEBUG_MESSAGES_KEY", "DEBUG_MESSAGE_KEY", "DEBUG_MESSAGE_LINK_KEY", "DEBUG_MESSAGE_TYPE_KEY", "DEBUG_PARAM", "DEBUG_SEVERITY_INFO", "DEBUG_SEVERITY_WARNING", "FIELDS_PARAM", "FORMAT_JSON", "FORMAT_PARAM", "ISO_8601_FORMAT_STRING", "MAXIMUM_BATCH_SIZE", "I", "ME", "MIME_BOUNDARY", "MY_FRIENDS", "MY_PHOTOS", "PICTURE_PARAM", "SDK_ANDROID", "SDK_PARAM", ViewHierarchyConstants.SEARCH, "kotlin.jvm.PlatformType", "TAG", "getTAG$facebook_core_release$annotations", "()V", "USER_AGENT_BASE", "USER_AGENT_HEADER", "VIDEOS_SUFFIX", "defaultBatchApplicationId", "Ljava/util/regex/Pattern;", "versionPattern", "Ljava/util/regex/Pattern;", "<init>", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.o oVar) {
            this();
        }

        private final HttpURLConnection createConnection(URL url) throws IOException {
            URLConnection uRLConnectionOpenConnection = url.openConnection();
            if (uRLConnectionOpenConnection == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
            httpURLConnection.setRequestProperty(GraphRequest.USER_AGENT_HEADER, getUserAgent());
            httpURLConnection.setRequestProperty(GraphRequest.ACCEPT_LANGUAGE_HEADER, Locale.getDefault().toString());
            httpURLConnection.setChunkedStreamingMode(0);
            return httpURLConnection;
        }

        private final String getBatchAppId(GraphRequestBatch batch) {
            String batchApplicationId = batch.getBatchApplicationId();
            if (batchApplicationId != null && (!batch.isEmpty())) {
                return batchApplicationId;
            }
            Iterator<GraphRequest> it = batch.iterator();
            while (it.hasNext()) {
                AccessToken accessToken = it.next().getAccessToken();
                if (accessToken != null) {
                    return accessToken.getApplicationId();
                }
            }
            String str = GraphRequest.defaultBatchApplicationId;
            if (str != null) {
                if (str.length() > 0) {
                    return str;
                }
            }
            return FacebookSdk.getApplicationId();
        }

        private final String getDefaultPhotoPathIfNull(String graphPath) {
            return graphPath == null ? GraphRequest.MY_PHOTOS : graphPath;
        }

        private final String getMimeContentType() {
            x xVar = x.f3460a;
            String str = String.format("multipart/form-data; boundary=%s", Arrays.copyOf(new Object[]{GraphRequest.MIME_BOUNDARY}, 1));
            kotlin.jvm.internal.s.d(str, "java.lang.String.format(format, *args)");
            return str;
        }

        @VisibleForTesting(otherwise = 2)
        public static /* synthetic */ void getTAG$facebook_core_release$annotations() {
        }

        private final String getUserAgent() {
            if (GraphRequest.userAgent == null) {
                x xVar = x.f3460a;
                String str = String.format("%s.%s", Arrays.copyOf(new Object[]{GraphRequest.USER_AGENT_BASE, FacebookSdkVersion.BUILD}, 2));
                kotlin.jvm.internal.s.d(str, "java.lang.String.format(format, *args)");
                GraphRequest.userAgent = str;
                String customUserAgent = InternalSettings.getCustomUserAgent();
                if (!Utility.isNullOrEmpty(customUserAgent)) {
                    String str2 = String.format(Locale.ROOT, "%s/%s", Arrays.copyOf(new Object[]{GraphRequest.userAgent, customUserAgent}, 2));
                    kotlin.jvm.internal.s.d(str2, "java.lang.String.format(locale, format, *args)");
                    GraphRequest.userAgent = str2;
                }
            }
            return GraphRequest.userAgent;
        }

        private final boolean hasOnProgressCallbacks(GraphRequestBatch requests) {
            Iterator<GraphRequestBatch.Callback> it = requests.getCallbacks().iterator();
            while (it.hasNext()) {
                if (it.next() instanceof GraphRequestBatch.OnProgressCallback) {
                    return true;
                }
            }
            Iterator<GraphRequest> it2 = requests.iterator();
            while (it2.hasNext()) {
                if (it2.next().getCallback() instanceof OnProgressCallback) {
                    return true;
                }
            }
            return false;
        }

        private final boolean isGzipCompressible(GraphRequestBatch requests) {
            Iterator<GraphRequest> it = requests.iterator();
            while (it.hasNext()) {
                GraphRequest next = it.next();
                Iterator it2 = next.getParameters().keySet().iterator();
                while (it2.hasNext()) {
                    if (isSupportedAttachmentType(next.getParameters().get((String) it2.next()))) {
                        return false;
                    }
                }
            }
            return true;
        }

        private final boolean isMeRequest(String path) {
            Matcher matcher = GraphRequest.versionPattern.matcher(path);
            if (matcher.matches()) {
                path = matcher.group(1);
                kotlin.jvm.internal.s.d(path, "matcher.group(1)");
            }
            return kotlin.text.s.u(path, "me/", false, 2, null) || kotlin.text.s.u(path, "/me/", false, 2, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isSupportedAttachmentType(Object value) {
            return (value instanceof Bitmap) || (value instanceof byte[]) || (value instanceof Uri) || (value instanceof ParcelFileDescriptor) || (value instanceof ParcelableResourceWithMimeType);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isSupportedParameterType(Object value) {
            return (value instanceof String) || (value instanceof Boolean) || (value instanceof Number) || (value instanceof Date);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: newMeRequest$lambda-0, reason: not valid java name */
        public static final void m19newMeRequest$lambda0(GraphJSONObjectCallback graphJSONObjectCallback, GraphResponse response) {
            kotlin.jvm.internal.s.e(response, "response");
            if (graphJSONObjectCallback == null) {
                return;
            }
            graphJSONObjectCallback.onCompleted(response.getGraphObject(), response);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: newPlacesSearchRequest$lambda-1, reason: not valid java name */
        public static final void m20newPlacesSearchRequest$lambda1(GraphJSONArrayCallback graphJSONArrayCallback, GraphResponse response) {
            kotlin.jvm.internal.s.e(response, "response");
            if (graphJSONArrayCallback != null) {
                JSONObject jSONObject = response.getGraphObject();
                graphJSONArrayCallback.onCompleted(jSONObject == null ? null : jSONObject.optJSONArray(ShareConstants.WEB_DIALOG_PARAM_DATA), response);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String parameterToString(Object value) {
            if (value instanceof String) {
                return (String) value;
            }
            if ((value instanceof Boolean) || (value instanceof Number)) {
                return value.toString();
            }
            if (!(value instanceof Date)) {
                throw new IllegalArgumentException("Unsupported parameter type.");
            }
            String str = new SimpleDateFormat(GraphRequest.ISO_8601_FORMAT_STRING, Locale.US).format((Date) value);
            kotlin.jvm.internal.s.d(str, "iso8601DateFormat.format(value)");
            return str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void processGraphObject(org.json.JSONObject r10, java.lang.String r11, com.facebook.GraphRequest.KeyValueSerializer r12) {
            /*
                r9 = this;
                boolean r0 = r9.isMeRequest(r11)
                r1 = 1
                r2 = 0
                if (r0 == 0) goto L23
                r5 = 0
                r6 = 0
                r7 = 6
                r8 = 0
                java.lang.String r4 = ":"
                r3 = r11
                int r0 = kotlin.text.k.G(r3, r4, r5, r6, r7, r8)
                java.lang.String r4 = "?"
                int r11 = kotlin.text.k.G(r3, r4, r5, r6, r7, r8)
                r3 = 3
                if (r0 <= r3) goto L23
                r3 = -1
                if (r11 == r3) goto L21
                if (r0 >= r11) goto L23
            L21:
                r11 = 1
                goto L24
            L23:
                r11 = 0
            L24:
                java.util.Iterator r0 = r10.keys()
            L28:
                boolean r3 = r0.hasNext()
                if (r3 == 0) goto L53
                java.lang.Object r3 = r0.next()
                java.lang.String r3 = (java.lang.String) r3
                java.lang.Object r4 = r10.opt(r3)
                if (r11 == 0) goto L44
                java.lang.String r5 = "image"
                boolean r5 = kotlin.text.k.l(r3, r5, r1)
                if (r5 == 0) goto L44
                r5 = 1
                goto L45
            L44:
                r5 = 0
            L45:
                java.lang.String r6 = "key"
                kotlin.jvm.internal.s.d(r3, r6)
                java.lang.String r6 = "value"
                kotlin.jvm.internal.s.d(r4, r6)
                r9.processGraphObjectProperty(r3, r4, r12, r5)
                goto L28
            L53:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.GraphRequest.Companion.processGraphObject(org.json.JSONObject, java.lang.String, com.facebook.GraphRequest$KeyValueSerializer):void");
        }

        private final void processGraphObjectProperty(String str, Object obj, KeyValueSerializer keyValueSerializer, boolean z2) {
            Class<?> cls = obj.getClass();
            if (JSONObject.class.isAssignableFrom(cls)) {
                JSONObject jSONObject = (JSONObject) obj;
                if (z2) {
                    Iterator<String> itKeys = jSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        x xVar = x.f3460a;
                        String str2 = String.format("%s[%s]", Arrays.copyOf(new Object[]{str, next}, 2));
                        kotlin.jvm.internal.s.d(str2, "java.lang.String.format(format, *args)");
                        Object objOpt = jSONObject.opt(next);
                        kotlin.jvm.internal.s.d(objOpt, "jsonObject.opt(propertyName)");
                        processGraphObjectProperty(str2, objOpt, keyValueSerializer, z2);
                    }
                    return;
                }
                if (jSONObject.has("id")) {
                    String strOptString = jSONObject.optString("id");
                    kotlin.jvm.internal.s.d(strOptString, "jsonObject.optString(\"id\")");
                    processGraphObjectProperty(str, strOptString, keyValueSerializer, z2);
                    return;
                } else if (jSONObject.has("url")) {
                    String strOptString2 = jSONObject.optString("url");
                    kotlin.jvm.internal.s.d(strOptString2, "jsonObject.optString(\"url\")");
                    processGraphObjectProperty(str, strOptString2, keyValueSerializer, z2);
                    return;
                } else {
                    if (jSONObject.has(NativeProtocol.OPEN_GRAPH_CREATE_OBJECT_KEY)) {
                        String string = jSONObject.toString();
                        kotlin.jvm.internal.s.d(string, "jsonObject.toString()");
                        processGraphObjectProperty(str, string, keyValueSerializer, z2);
                        return;
                    }
                    return;
                }
            }
            if (!JSONArray.class.isAssignableFrom(cls)) {
                if (String.class.isAssignableFrom(cls) || Number.class.isAssignableFrom(cls) || Boolean.class.isAssignableFrom(cls)) {
                    keyValueSerializer.writeString(str, obj.toString());
                    return;
                }
                if (Date.class.isAssignableFrom(cls)) {
                    String str3 = new SimpleDateFormat(GraphRequest.ISO_8601_FORMAT_STRING, Locale.US).format((Date) obj);
                    kotlin.jvm.internal.s.d(str3, "iso8601DateFormat.format(date)");
                    keyValueSerializer.writeString(str, str3);
                    return;
                }
                Utility utility = Utility.INSTANCE;
                Utility.logd(GraphRequest.TAG, "The type of property " + str + " in the graph object is unknown. It won't be sent in the request.");
                return;
            }
            JSONArray jSONArray = (JSONArray) obj;
            int length = jSONArray.length();
            if (length <= 0) {
                return;
            }
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                x xVar2 = x.f3460a;
                String str4 = String.format(Locale.ROOT, "%s[%d]", Arrays.copyOf(new Object[]{str, Integer.valueOf(i2)}, 2));
                kotlin.jvm.internal.s.d(str4, "java.lang.String.format(locale, format, *args)");
                Object objOpt2 = jSONArray.opt(i2);
                kotlin.jvm.internal.s.d(objOpt2, "jsonArray.opt(i)");
                processGraphObjectProperty(str4, objOpt2, keyValueSerializer, z2);
                if (i3 >= length) {
                    return;
                } else {
                    i2 = i3;
                }
            }
        }

        private final void processRequest(GraphRequestBatch graphRequestBatch, Logger logger, int i2, URL url, OutputStream outputStream, boolean z2) throws JSONException, IOException {
            Serializer serializer = new Serializer(outputStream, logger, z2);
            if (i2 != 1) {
                String batchAppId = getBatchAppId(graphRequestBatch);
                if (batchAppId.length() == 0) {
                    throw new FacebookException("App ID was not specified at the request or Settings.");
                }
                serializer.writeString(GraphRequest.BATCH_APP_ID_PARAM, batchAppId);
                HashMap map = new HashMap();
                serializeRequestsAsJSON(serializer, graphRequestBatch, map);
                if (logger != null) {
                    logger.append("  Attachments:\n");
                }
                serializeAttachments(map, serializer);
                return;
            }
            GraphRequest graphRequest = graphRequestBatch.get(0);
            HashMap map2 = new HashMap();
            for (String key : graphRequest.getParameters().keySet()) {
                Object obj = graphRequest.getParameters().get(key);
                if (isSupportedAttachmentType(obj)) {
                    kotlin.jvm.internal.s.d(key, "key");
                    map2.put(key, new Attachment(graphRequest, obj));
                }
            }
            if (logger != null) {
                logger.append("  Parameters:\n");
            }
            serializeParameters(graphRequest.getParameters(), serializer, graphRequest);
            if (logger != null) {
                logger.append("  Attachments:\n");
            }
            serializeAttachments(map2, serializer);
            JSONObject graphObject = graphRequest.getGraphObject();
            if (graphObject != null) {
                String path = url.getPath();
                kotlin.jvm.internal.s.d(path, "url.path");
                processGraphObject(graphObject, path, serializer);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: runCallbacks$lambda-2, reason: not valid java name */
        public static final void m21runCallbacks$lambda2(ArrayList callbacks, GraphRequestBatch requests) {
            kotlin.jvm.internal.s.e(callbacks, "$callbacks");
            kotlin.jvm.internal.s.e(requests, "$requests");
            Iterator it = callbacks.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                Callback callback = (Callback) pair.first;
                Object obj = pair.second;
                kotlin.jvm.internal.s.d(obj, "pair.second");
                callback.onCompleted((GraphResponse) obj);
            }
            Iterator<GraphRequestBatch.Callback> it2 = requests.getCallbacks().iterator();
            while (it2.hasNext()) {
                it2.next().onBatchCompleted(requests);
            }
        }

        private final void serializeAttachments(Map<String, Attachment> map, Serializer serializer) throws IOException {
            for (Map.Entry<String, Attachment> entry : map.entrySet()) {
                if (GraphRequest.INSTANCE.isSupportedAttachmentType(entry.getValue().getValue())) {
                    serializer.writeObject(entry.getKey(), entry.getValue().getValue(), entry.getValue().getRequest());
                }
            }
        }

        private final void serializeParameters(Bundle bundle, Serializer serializer, GraphRequest graphRequest) throws IOException {
            for (String key : bundle.keySet()) {
                Object obj = bundle.get(key);
                if (isSupportedParameterType(obj)) {
                    kotlin.jvm.internal.s.d(key, "key");
                    serializer.writeObject(key, obj, graphRequest);
                }
            }
        }

        private final void serializeRequestsAsJSON(Serializer serializer, Collection<GraphRequest> collection, Map<String, Attachment> map) throws JSONException, IOException {
            JSONArray jSONArray = new JSONArray();
            Iterator<GraphRequest> it = collection.iterator();
            while (it.hasNext()) {
                it.next().serializeToBatch(jSONArray, map);
            }
            serializer.writeRequestsAsJson(GraphRequest.BATCH_PARAM, jSONArray, collection);
        }

        private final void setConnectionContentType(HttpURLConnection httpURLConnection, boolean z2) {
            if (!z2) {
                httpURLConnection.setRequestProperty(GraphRequest.CONTENT_TYPE_HEADER, getMimeContentType());
            } else {
                httpURLConnection.setRequestProperty(GraphRequest.CONTENT_TYPE_HEADER, "application/x-www-form-urlencoded");
                httpURLConnection.setRequestProperty(GraphRequest.CONTENT_ENCODING_HEADER, "gzip");
            }
        }

        @JvmStatic
        @NotNull
        public final GraphResponse executeAndWait(@NotNull GraphRequest request) {
            kotlin.jvm.internal.s.e(request, "request");
            List<GraphResponse> listExecuteBatchAndWait = executeBatchAndWait(request);
            if (listExecuteBatchAndWait.size() == 1) {
                return listExecuteBatchAndWait.get(0);
            }
            throw new FacebookException("invalid state: expected a single response");
        }

        @JvmStatic
        @NotNull
        public final List<GraphResponse> executeBatchAndWait(@NotNull GraphRequest... requests) {
            kotlin.jvm.internal.s.e(requests, "requests");
            return executeBatchAndWait(kotlin.collections.n.t(requests));
        }

        @JvmStatic
        @NotNull
        public final GraphRequestAsyncTask executeBatchAsync(@NotNull GraphRequest... requests) {
            kotlin.jvm.internal.s.e(requests, "requests");
            return executeBatchAsync(kotlin.collections.n.t(requests));
        }

        @JvmStatic
        @NotNull
        public final List<GraphResponse> executeConnectionAndWait(@NotNull HttpURLConnection connection, @NotNull Collection<GraphRequest> requests) {
            kotlin.jvm.internal.s.e(connection, "connection");
            kotlin.jvm.internal.s.e(requests, "requests");
            return executeConnectionAndWait(connection, new GraphRequestBatch(requests));
        }

        @JvmStatic
        @NotNull
        public final GraphRequestAsyncTask executeConnectionAsync(@NotNull HttpURLConnection connection, @NotNull GraphRequestBatch requests) {
            kotlin.jvm.internal.s.e(connection, "connection");
            kotlin.jvm.internal.s.e(requests, "requests");
            return executeConnectionAsync(null, connection, requests);
        }

        @JvmStatic
        @Nullable
        public final String getDefaultBatchApplicationId() {
            return GraphRequest.defaultBatchApplicationId;
        }

        @JvmStatic
        @NotNull
        public final GraphRequest newCustomAudienceThirdPartyIdRequest(@Nullable AccessToken accessToken, @NotNull Context context, @Nullable String applicationId, @Nullable Callback callback) {
            kotlin.jvm.internal.s.e(context, "context");
            if (applicationId == null && accessToken != null) {
                applicationId = accessToken.getApplicationId();
            }
            if (applicationId == null) {
                applicationId = Utility.getMetadataApplicationId(context);
            }
            if (applicationId == null) {
                throw new FacebookException("Facebook App ID cannot be determined");
            }
            String strM = kotlin.jvm.internal.s.m(applicationId, "/custom_audience_third_party_id");
            AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.INSTANCE.getAttributionIdentifiers(context);
            Bundle bundle = new Bundle();
            if (accessToken == null) {
                if (attributionIdentifiers == null) {
                    throw new FacebookException("There is no access token and attribution identifiers could not be retrieved");
                }
                String attributionId = attributionIdentifiers.getAttributionId() != null ? attributionIdentifiers.getAttributionId() : attributionIdentifiers.getAndroidAdvertiserId();
                if (attributionId != null) {
                    bundle.putString("udid", attributionId);
                }
            }
            if (FacebookSdk.getLimitEventAndDataUsage(context) || (attributionIdentifiers != null && attributionIdentifiers.getIsTrackingLimited())) {
                bundle.putString("limit_event_usage", "1");
            }
            return new GraphRequest(accessToken, strM, bundle, HttpMethod.GET, callback, null, 32, null);
        }

        @JvmStatic
        @NotNull
        public final GraphRequest newDeleteObjectRequest(@Nullable AccessToken accessToken, @Nullable String id, @Nullable Callback callback) {
            return new GraphRequest(accessToken, id, null, HttpMethod.DELETE, callback, null, 32, null);
        }

        @JvmStatic
        @NotNull
        public final GraphRequest newGraphPathRequest(@Nullable AccessToken accessToken, @Nullable String graphPath, @Nullable Callback callback) {
            return new GraphRequest(accessToken, graphPath, null, null, callback, null, 32, null);
        }

        @JvmStatic
        @NotNull
        public final GraphRequest newMeRequest(@Nullable AccessToken accessToken, @Nullable final GraphJSONObjectCallback callback) {
            return new GraphRequest(accessToken, GraphRequest.ME, null, null, new Callback() { // from class: com.facebook.s
                @Override // com.facebook.GraphRequest.Callback
                public final void onCompleted(GraphResponse graphResponse) {
                    GraphRequest.Companion.m19newMeRequest$lambda0(callback, graphResponse);
                }
            }, null, 32, null);
        }

        @JvmStatic
        @NotNull
        public final GraphRequest newMyFriendsRequest(@Nullable AccessToken accessToken, @Nullable final GraphJSONArrayCallback callback) {
            return new GraphRequest(accessToken, GraphRequest.MY_FRIENDS, null, null, new Callback() { // from class: com.facebook.GraphRequest$Companion$newMyFriendsRequest$wrapper$1
                @Override // com.facebook.GraphRequest.Callback
                public void onCompleted(@NotNull GraphResponse response) {
                    kotlin.jvm.internal.s.e(response, "response");
                    if (callback != null) {
                        JSONObject graphObject = response.getGraphObject();
                        callback.onCompleted(graphObject == null ? null : graphObject.optJSONArray(ShareConstants.WEB_DIALOG_PARAM_DATA), response);
                    }
                }
            }, null, 32, null);
        }

        @JvmStatic
        @NotNull
        public final GraphRequest newPlacesSearchRequest(@Nullable AccessToken accessToken, @Nullable Location location, int radiusInMeters, int resultsLimit, @Nullable String searchText, @Nullable final GraphJSONArrayCallback callback) {
            if (location == null && Utility.isNullOrEmpty(searchText)) {
                throw new FacebookException("Either location or searchText must be specified.");
            }
            Bundle bundle = new Bundle(5);
            bundle.putString("type", "place");
            bundle.putInt("limit", resultsLimit);
            if (location != null) {
                x xVar = x.f3460a;
                String str = String.format(Locale.US, "%f,%f", Arrays.copyOf(new Object[]{Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude())}, 2));
                kotlin.jvm.internal.s.d(str, "java.lang.String.format(locale, format, *args)");
                bundle.putString("center", str);
                bundle.putInt("distance", radiusInMeters);
            }
            if (!Utility.isNullOrEmpty(searchText)) {
                bundle.putString("q", searchText);
            }
            return new GraphRequest(accessToken, GraphRequest.SEARCH, bundle, HttpMethod.GET, new Callback() { // from class: com.facebook.t
                @Override // com.facebook.GraphRequest.Callback
                public final void onCompleted(GraphResponse graphResponse) {
                    GraphRequest.Companion.m20newPlacesSearchRequest$lambda1(callback, graphResponse);
                }
            }, null, 32, null);
        }

        @JvmStatic
        @NotNull
        public final GraphRequest newPostRequest(@Nullable AccessToken accessToken, @Nullable String graphPath, @Nullable JSONObject graphObject, @Nullable Callback callback) {
            GraphRequest graphRequest = new GraphRequest(accessToken, graphPath, null, HttpMethod.POST, callback, null, 32, null);
            graphRequest.setGraphObject(graphObject);
            return graphRequest;
        }

        @JvmStatic
        @NotNull
        public final GraphRequest newPostRequestWithBundle(@Nullable AccessToken accessToken, @Nullable String graphPath, @Nullable Bundle parameters, @Nullable Callback callback) {
            return new GraphRequest(accessToken, graphPath, parameters, HttpMethod.POST, callback, null, 32, null);
        }

        @JvmStatic
        @NotNull
        public final GraphRequest newUploadPhotoRequest(@Nullable AccessToken accessToken, @Nullable String graphPath, @NotNull Bitmap image, @Nullable String caption, @Nullable Bundle params, @Nullable Callback callback) {
            kotlin.jvm.internal.s.e(image, "image");
            Bundle bundle = new Bundle();
            if (params != null) {
                bundle.putAll(params);
            }
            bundle.putParcelable("picture", image);
            if (caption != null) {
                if (caption.length() > 0) {
                    bundle.putString("caption", caption);
                }
            }
            return new GraphRequest(accessToken, getDefaultPhotoPathIfNull(graphPath), bundle, HttpMethod.POST, callback, null, 32, null);
        }

        @JvmStatic
        public final void runCallbacks$facebook_core_release(@NotNull final GraphRequestBatch requests, @NotNull List<GraphResponse> responses) {
            kotlin.jvm.internal.s.e(requests, "requests");
            kotlin.jvm.internal.s.e(responses, "responses");
            int size = requests.size();
            final ArrayList arrayList = new ArrayList();
            if (size > 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    GraphRequest graphRequest = requests.get(i2);
                    if (graphRequest.getCallback() != null) {
                        arrayList.add(new Pair(graphRequest.getCallback(), responses.get(i2)));
                    }
                    if (i3 >= size) {
                        break;
                    } else {
                        i2 = i3;
                    }
                }
            }
            if (arrayList.size() > 0) {
                Runnable runnable = new Runnable() { // from class: com.facebook.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        GraphRequest.Companion.m21runCallbacks$lambda2(arrayList, requests);
                    }
                };
                Handler callbackHandler = requests.getCallbackHandler();
                if ((callbackHandler == null ? null : Boolean.valueOf(callbackHandler.post(runnable))) == null) {
                    runnable.run();
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:33:0x00f2  */
        @kotlin.jvm.JvmStatic
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void serializeToUrlConnection$facebook_core_release(@org.jetbrains.annotations.NotNull com.facebook.GraphRequestBatch r14, @org.jetbrains.annotations.NotNull java.net.HttpURLConnection r15) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 246
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.GraphRequest.Companion.serializeToUrlConnection$facebook_core_release(com.facebook.GraphRequestBatch, java.net.HttpURLConnection):void");
        }

        @JvmStatic
        public final void setDefaultBatchApplicationId(@Nullable String str) {
            GraphRequest.defaultBatchApplicationId = str;
        }

        @JvmStatic
        @NotNull
        public final HttpURLConnection toHttpConnection(@NotNull GraphRequest... requests) {
            kotlin.jvm.internal.s.e(requests, "requests");
            return toHttpConnection(kotlin.collections.n.t(requests));
        }

        @JvmStatic
        public final void validateFieldsParamForGetRequests$facebook_core_release(@NotNull GraphRequestBatch requests) {
            kotlin.jvm.internal.s.e(requests, "requests");
            Iterator<GraphRequest> it = requests.iterator();
            while (it.hasNext()) {
                GraphRequest next = it.next();
                if (HttpMethod.GET == next.getHttpMethod()) {
                    Utility utility = Utility.INSTANCE;
                    if (Utility.isNullOrEmpty(next.getParameters().getString(GraphRequest.FIELDS_PARAM))) {
                        Logger.Companion companion = Logger.INSTANCE;
                        LoggingBehavior loggingBehavior = LoggingBehavior.DEVELOPER_ERRORS;
                        StringBuilder sb = new StringBuilder();
                        sb.append("GET requests for /");
                        String graphPath = next.getGraphPath();
                        if (graphPath == null) {
                            graphPath = "";
                        }
                        sb.append(graphPath);
                        sb.append(" should contain an explicit \"fields\" parameter.");
                        companion.log(loggingBehavior, 5, "Request", sb.toString());
                    }
                }
            }
        }

        @JvmStatic
        @NotNull
        public final List<GraphResponse> executeBatchAndWait(@NotNull Collection<GraphRequest> requests) {
            kotlin.jvm.internal.s.e(requests, "requests");
            return executeBatchAndWait(new GraphRequestBatch(requests));
        }

        @JvmStatic
        @NotNull
        public final GraphRequestAsyncTask executeBatchAsync(@NotNull Collection<GraphRequest> requests) {
            kotlin.jvm.internal.s.e(requests, "requests");
            return executeBatchAsync(new GraphRequestBatch(requests));
        }

        @JvmStatic
        @NotNull
        public final List<GraphResponse> executeConnectionAndWait(@NotNull HttpURLConnection connection, @NotNull GraphRequestBatch requests) {
            kotlin.jvm.internal.s.e(connection, "connection");
            kotlin.jvm.internal.s.e(requests, "requests");
            List<GraphResponse> listFromHttpConnection$facebook_core_release = GraphResponse.INSTANCE.fromHttpConnection$facebook_core_release(connection, requests);
            Utility.disconnectQuietly(connection);
            int size = requests.size();
            if (size == listFromHttpConnection$facebook_core_release.size()) {
                runCallbacks$facebook_core_release(requests, listFromHttpConnection$facebook_core_release);
                AccessTokenManager.INSTANCE.getInstance().extendAccessTokenIfNeeded();
                return listFromHttpConnection$facebook_core_release;
            }
            x xVar = x.f3460a;
            String str = String.format(Locale.US, "Received %d responses while expecting %d", Arrays.copyOf(new Object[]{Integer.valueOf(listFromHttpConnection$facebook_core_release.size()), Integer.valueOf(size)}, 2));
            kotlin.jvm.internal.s.d(str, "java.lang.String.format(locale, format, *args)");
            throw new FacebookException(str);
        }

        @JvmStatic
        @NotNull
        public final GraphRequestAsyncTask executeConnectionAsync(@Nullable Handler callbackHandler, @NotNull HttpURLConnection connection, @NotNull GraphRequestBatch requests) {
            kotlin.jvm.internal.s.e(connection, "connection");
            kotlin.jvm.internal.s.e(requests, "requests");
            GraphRequestAsyncTask graphRequestAsyncTask = new GraphRequestAsyncTask(connection, requests);
            requests.setCallbackHandler(callbackHandler);
            graphRequestAsyncTask.executeOnExecutor(FacebookSdk.getExecutor(), new Void[0]);
            return graphRequestAsyncTask;
        }

        @JvmStatic
        @NotNull
        public final HttpURLConnection toHttpConnection(@NotNull Collection<GraphRequest> requests) {
            kotlin.jvm.internal.s.e(requests, "requests");
            Validate.notEmpty(requests, "requests");
            return toHttpConnection(new GraphRequestBatch(requests));
        }

        @JvmStatic
        @NotNull
        public final List<GraphResponse> executeBatchAndWait(@NotNull GraphRequestBatch requests) throws Throwable {
            Exception exc;
            HttpURLConnection httpConnection;
            List<GraphResponse> listExecuteConnectionAndWait;
            kotlin.jvm.internal.s.e(requests, "requests");
            Validate.notEmptyAndContainsNoNulls(requests, "requests");
            HttpURLConnection httpURLConnection = null;
            try {
                httpConnection = toHttpConnection(requests);
                exc = null;
            } catch (Exception e2) {
                exc = e2;
                httpConnection = null;
            } catch (Throwable th) {
                th = th;
                Utility.disconnectQuietly(httpURLConnection);
                throw th;
            }
            try {
                if (httpConnection != null) {
                    listExecuteConnectionAndWait = executeConnectionAndWait(httpConnection, requests);
                } else {
                    List<GraphResponse> listConstructErrorResponses = GraphResponse.INSTANCE.constructErrorResponses(requests.getRequests(), null, new FacebookException(exc));
                    runCallbacks$facebook_core_release(requests, listConstructErrorResponses);
                    listExecuteConnectionAndWait = listConstructErrorResponses;
                }
                Utility.disconnectQuietly(httpConnection);
                return listExecuteConnectionAndWait;
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection = httpConnection;
                Utility.disconnectQuietly(httpURLConnection);
                throw th;
            }
        }

        @JvmStatic
        @NotNull
        public final GraphRequestAsyncTask executeBatchAsync(@NotNull GraphRequestBatch requests) {
            kotlin.jvm.internal.s.e(requests, "requests");
            Validate.notEmptyAndContainsNoNulls(requests, "requests");
            GraphRequestAsyncTask graphRequestAsyncTask = new GraphRequestAsyncTask(requests);
            graphRequestAsyncTask.executeOnExecutor(FacebookSdk.getExecutor(), new Void[0]);
            return graphRequestAsyncTask;
        }

        @JvmStatic
        @NotNull
        public final HttpURLConnection toHttpConnection(@NotNull GraphRequestBatch requests) throws Throwable {
            URL url;
            kotlin.jvm.internal.s.e(requests, "requests");
            validateFieldsParamForGetRequests$facebook_core_release(requests);
            try {
                if (requests.size() == 1) {
                    url = new URL(requests.get(0).getUrlForSingleRequest());
                } else {
                    url = new URL(ServerProtocol.getGraphUrlBase());
                }
                HttpURLConnection httpURLConnectionCreateConnection = null;
                try {
                    httpURLConnectionCreateConnection = createConnection(url);
                    serializeToUrlConnection$facebook_core_release(requests, httpURLConnectionCreateConnection);
                    return httpURLConnectionCreateConnection;
                } catch (IOException e2) {
                    Utility.disconnectQuietly(httpURLConnectionCreateConnection);
                    throw new FacebookException("could not construct request body", e2);
                } catch (JSONException e3) {
                    Utility.disconnectQuietly(httpURLConnectionCreateConnection);
                    throw new FacebookException("could not construct request body", e3);
                }
            } catch (MalformedURLException e4) {
                throw new FacebookException("could not construct URL for request", e4);
            }
        }

        @JvmStatic
        @NotNull
        public final GraphRequest newUploadPhotoRequest(@Nullable AccessToken accessToken, @Nullable String graphPath, @NotNull File file, @Nullable String caption, @Nullable Bundle params, @Nullable Callback callback) throws FileNotFoundException {
            kotlin.jvm.internal.s.e(file, "file");
            ParcelFileDescriptor parcelFileDescriptorOpen = ParcelFileDescriptor.open(file, 268435456);
            Bundle bundle = new Bundle();
            if (params != null) {
                bundle.putAll(params);
            }
            bundle.putParcelable("picture", parcelFileDescriptorOpen);
            if (caption != null) {
                if (caption.length() > 0) {
                    bundle.putString("caption", caption);
                }
            }
            return new GraphRequest(accessToken, getDefaultPhotoPathIfNull(graphPath), bundle, HttpMethod.POST, callback, null, 32, null);
        }

        @JvmStatic
        @NotNull
        public final GraphRequest newCustomAudienceThirdPartyIdRequest(@Nullable AccessToken accessToken, @NotNull Context context, @Nullable Callback callback) {
            kotlin.jvm.internal.s.e(context, "context");
            return newCustomAudienceThirdPartyIdRequest(accessToken, context, null, callback);
        }

        @JvmStatic
        @NotNull
        public final GraphRequest newUploadPhotoRequest(@Nullable AccessToken accessToken, @Nullable String graphPath, @NotNull Uri photoUri, @Nullable String caption, @Nullable Bundle params, @Nullable Callback callback) throws FacebookException, FileNotFoundException {
            kotlin.jvm.internal.s.e(photoUri, "photoUri");
            if (Utility.isFileUri(photoUri)) {
                return newUploadPhotoRequest(accessToken, graphPath, new File(photoUri.getPath()), caption, params, callback);
            }
            if (Utility.isContentUri(photoUri)) {
                Bundle bundle = new Bundle();
                if (params != null) {
                    bundle.putAll(params);
                }
                bundle.putParcelable("picture", photoUri);
                if (caption != null) {
                    if (caption.length() > 0) {
                        bundle.putString("caption", caption);
                    }
                }
                return new GraphRequest(accessToken, getDefaultPhotoPathIfNull(graphPath), bundle, HttpMethod.POST, callback, null, 32, null);
            }
            throw new FacebookException("The photo Uri must be either a file:// or content:// Uri");
        }
    }

    /* compiled from: GraphRequest.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¨\u0006\b"}, d2 = {"Lcom/facebook/GraphRequest$GraphJSONArrayCallback;", "", "Lorg/json/JSONArray;", "objects", "Lcom/facebook/GraphResponse;", "response", "Lkotlin/t;", "onCompleted", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public interface GraphJSONArrayCallback {
        void onCompleted(@Nullable JSONArray jSONArray, @Nullable GraphResponse graphResponse);
    }

    /* compiled from: GraphRequest.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¨\u0006\b"}, d2 = {"Lcom/facebook/GraphRequest$GraphJSONObjectCallback;", "", "Lorg/json/JSONObject;", "obj", "Lcom/facebook/GraphResponse;", "response", "Lkotlin/t;", "onCompleted", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public interface GraphJSONObjectCallback {
        void onCompleted(@Nullable JSONObject jSONObject, @Nullable GraphResponse graphResponse);
    }

    /* compiled from: GraphRequest.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bâ\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¨\u0006\u0007"}, d2 = {"Lcom/facebook/GraphRequest$KeyValueSerializer;", "", "", "key", "value", "Lkotlin/t;", "writeString", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    private interface KeyValueSerializer {
        void writeString(@NotNull String str, @NotNull String str2);
    }

    /* compiled from: GraphRequest.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¨\u0006\u0007"}, d2 = {"Lcom/facebook/GraphRequest$OnProgressCallback;", "Lcom/facebook/GraphRequest$Callback;", "", "current", "max", "Lkotlin/t;", "onProgress", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public interface OnProgressCallback extends Callback {
        void onProgress(long j2, long j3);
    }

    /* compiled from: GraphRequest.kt */
    @Metadata(bv = {}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010)\u001a\u00020(\u0012\b\u0010,\u001a\u0004\u0018\u00010+\u0012\u0006\u00101\u001a\u00020.¢\u0006\u0004\b7\u00108J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J$\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\fJ\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0016\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010J\u0016\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013J \u0010\u0019\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002J \u0010\u001c\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u001d\u001a\u00020\bJ$\u0010!\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\u00022\b\u0010 \u001a\u0004\u0018\u00010\u0002J-\u0010%\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u00022\u0016\u0010$\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040#\"\u0004\u0018\u00010\u0004¢\u0006\u0004\b%\u0010&J-\u0010'\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u00022\u0016\u0010$\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040#\"\u0004\u0018\u00010\u0004¢\u0006\u0004\b'\u0010&R\u0014\u0010)\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010,\u001a\u0004\u0018\u00010+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00100R\u0018\u00106\u001a\u000602j\u0002`38BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b4\u00105¨\u00069"}, d2 = {"Lcom/facebook/GraphRequest$Serializer;", "Lcom/facebook/GraphRequest$KeyValueSerializer;", "", "key", "", "value", "Lcom/facebook/GraphRequest;", "request", "Lkotlin/t;", "writeObject", "Lorg/json/JSONArray;", "requestJsonArray", "", "requests", "writeRequestsAsJson", "writeString", "Landroid/graphics/Bitmap;", "bitmap", "writeBitmap", "", "bytes", "writeBytes", "Landroid/net/Uri;", "contentUri", "mimeType", "writeContentUri", "Landroid/os/ParcelFileDescriptor;", "descriptor", "writeFile", "writeRecordBoundary", "name", "filename", "contentType", "writeContentDisposition", GraphRequest.FORMAT_PARAM, "", "args", "write", "(Ljava/lang/String;[Ljava/lang/Object;)V", "writeLine", "Ljava/io/OutputStream;", "outputStream", "Ljava/io/OutputStream;", "Lcom/facebook/internal/Logger;", "logger", "Lcom/facebook/internal/Logger;", "", "firstWrite", "Z", "useUrlEncode", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "getInvalidTypeError", "()Ljava/lang/RuntimeException;", "invalidTypeError", "<init>", "(Ljava/io/OutputStream;Lcom/facebook/internal/Logger;Z)V", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    private static final class Serializer implements KeyValueSerializer {
        private boolean firstWrite;

        @Nullable
        private final Logger logger;

        @NotNull
        private final OutputStream outputStream;
        private final boolean useUrlEncode;

        public Serializer(@NotNull OutputStream outputStream, @Nullable Logger logger, boolean z2) {
            kotlin.jvm.internal.s.e(outputStream, "outputStream");
            this.outputStream = outputStream;
            this.logger = logger;
            this.firstWrite = true;
            this.useUrlEncode = z2;
        }

        private final RuntimeException getInvalidTypeError() {
            return new IllegalArgumentException("value is not a supported type.");
        }

        public final void write(@NotNull String format, @NotNull Object... args) throws IOException {
            kotlin.jvm.internal.s.e(format, "format");
            kotlin.jvm.internal.s.e(args, "args");
            if (this.useUrlEncode) {
                OutputStream outputStream = this.outputStream;
                x xVar = x.f3460a;
                Locale locale = Locale.US;
                Object[] objArrCopyOf = Arrays.copyOf(args, args.length);
                String str = String.format(locale, format, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
                kotlin.jvm.internal.s.d(str, "java.lang.String.format(locale, format, *args)");
                String strEncode = URLEncoder.encode(str, "UTF-8");
                kotlin.jvm.internal.s.d(strEncode, "encode(String.format(Locale.US, format, *args), \"UTF-8\")");
                byte[] bytes = strEncode.getBytes(kotlin.text.d.UTF_8);
                kotlin.jvm.internal.s.d(bytes, "(this as java.lang.String).getBytes(charset)");
                outputStream.write(bytes);
                return;
            }
            if (this.firstWrite) {
                OutputStream outputStream2 = this.outputStream;
                Charset charset = kotlin.text.d.UTF_8;
                byte[] bytes2 = "--".getBytes(charset);
                kotlin.jvm.internal.s.d(bytes2, "(this as java.lang.String).getBytes(charset)");
                outputStream2.write(bytes2);
                OutputStream outputStream3 = this.outputStream;
                String str2 = GraphRequest.MIME_BOUNDARY;
                if (str2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                byte[] bytes3 = str2.getBytes(charset);
                kotlin.jvm.internal.s.d(bytes3, "(this as java.lang.String).getBytes(charset)");
                outputStream3.write(bytes3);
                OutputStream outputStream4 = this.outputStream;
                byte[] bytes4 = "\r\n".getBytes(charset);
                kotlin.jvm.internal.s.d(bytes4, "(this as java.lang.String).getBytes(charset)");
                outputStream4.write(bytes4);
                this.firstWrite = false;
            }
            OutputStream outputStream5 = this.outputStream;
            x xVar2 = x.f3460a;
            Object[] objArrCopyOf2 = Arrays.copyOf(args, args.length);
            String str3 = String.format(format, Arrays.copyOf(objArrCopyOf2, objArrCopyOf2.length));
            kotlin.jvm.internal.s.d(str3, "java.lang.String.format(format, *args)");
            Charset charset2 = kotlin.text.d.UTF_8;
            if (str3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            byte[] bytes5 = str3.getBytes(charset2);
            kotlin.jvm.internal.s.d(bytes5, "(this as java.lang.String).getBytes(charset)");
            outputStream5.write(bytes5);
        }

        public final void writeBitmap(@NotNull String key, @NotNull Bitmap bitmap) throws IOException {
            kotlin.jvm.internal.s.e(key, "key");
            kotlin.jvm.internal.s.e(bitmap, "bitmap");
            writeContentDisposition(key, key, "image/png");
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, this.outputStream);
            writeLine("", new Object[0]);
            writeRecordBoundary();
            Logger logger = this.logger;
            if (logger == null) {
                return;
            }
            logger.appendKeyValue(kotlin.jvm.internal.s.m("    ", key), "<Image>");
        }

        public final void writeBytes(@NotNull String key, @NotNull byte[] bytes) throws IOException {
            kotlin.jvm.internal.s.e(key, "key");
            kotlin.jvm.internal.s.e(bytes, "bytes");
            writeContentDisposition(key, key, "content/unknown");
            this.outputStream.write(bytes);
            writeLine("", new Object[0]);
            writeRecordBoundary();
            Logger logger = this.logger;
            if (logger == null) {
                return;
            }
            String strM = kotlin.jvm.internal.s.m("    ", key);
            x xVar = x.f3460a;
            String str = String.format(Locale.ROOT, "<Data: %d>", Arrays.copyOf(new Object[]{Integer.valueOf(bytes.length)}, 1));
            kotlin.jvm.internal.s.d(str, "java.lang.String.format(locale, format, *args)");
            logger.appendKeyValue(strM, str);
        }

        public final void writeContentDisposition(@Nullable String str, @Nullable String str2, @Nullable String str3) throws IOException {
            if (!this.useUrlEncode) {
                write("Content-Disposition: form-data; name=\"%s\"", str);
                if (str2 != null) {
                    write("; filename=\"%s\"", str2);
                }
                writeLine("", new Object[0]);
                if (str3 != null) {
                    writeLine("%s: %s", GraphRequest.CONTENT_TYPE_HEADER, str3);
                }
                writeLine("", new Object[0]);
                return;
            }
            OutputStream outputStream = this.outputStream;
            x xVar = x.f3460a;
            String str4 = String.format("%s=", Arrays.copyOf(new Object[]{str}, 1));
            kotlin.jvm.internal.s.d(str4, "java.lang.String.format(format, *args)");
            Charset charset = kotlin.text.d.UTF_8;
            if (str4 == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            byte[] bytes = str4.getBytes(charset);
            kotlin.jvm.internal.s.d(bytes, "(this as java.lang.String).getBytes(charset)");
            outputStream.write(bytes);
        }

        public final void writeContentUri(@NotNull String key, @NotNull Uri contentUri, @Nullable String str) throws IOException {
            int iCopyAndCloseInputStream;
            kotlin.jvm.internal.s.e(key, "key");
            kotlin.jvm.internal.s.e(contentUri, "contentUri");
            if (str == null) {
                str = "content/unknown";
            }
            writeContentDisposition(key, key, str);
            if (this.outputStream instanceof ProgressNoopOutputStream) {
                ((ProgressNoopOutputStream) this.outputStream).addProgress(Utility.getContentSize(contentUri));
                iCopyAndCloseInputStream = 0;
            } else {
                InputStream inputStreamOpenInputStream = FacebookSdk.getApplicationContext().getContentResolver().openInputStream(contentUri);
                Utility utility = Utility.INSTANCE;
                iCopyAndCloseInputStream = Utility.copyAndCloseInputStream(inputStreamOpenInputStream, this.outputStream) + 0;
            }
            writeLine("", new Object[0]);
            writeRecordBoundary();
            Logger logger = this.logger;
            if (logger == null) {
                return;
            }
            String strM = kotlin.jvm.internal.s.m("    ", key);
            x xVar = x.f3460a;
            String str2 = String.format(Locale.ROOT, "<Data: %d>", Arrays.copyOf(new Object[]{Integer.valueOf(iCopyAndCloseInputStream)}, 1));
            kotlin.jvm.internal.s.d(str2, "java.lang.String.format(locale, format, *args)");
            logger.appendKeyValue(strM, str2);
        }

        public final void writeFile(@NotNull String key, @NotNull ParcelFileDescriptor descriptor, @Nullable String str) throws IOException {
            int iCopyAndCloseInputStream;
            kotlin.jvm.internal.s.e(key, "key");
            kotlin.jvm.internal.s.e(descriptor, "descriptor");
            if (str == null) {
                str = "content/unknown";
            }
            writeContentDisposition(key, key, str);
            OutputStream outputStream = this.outputStream;
            if (outputStream instanceof ProgressNoopOutputStream) {
                ((ProgressNoopOutputStream) outputStream).addProgress(descriptor.getStatSize());
                iCopyAndCloseInputStream = 0;
            } else {
                ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(descriptor);
                Utility utility = Utility.INSTANCE;
                iCopyAndCloseInputStream = Utility.copyAndCloseInputStream(autoCloseInputStream, this.outputStream) + 0;
            }
            writeLine("", new Object[0]);
            writeRecordBoundary();
            Logger logger = this.logger;
            if (logger == null) {
                return;
            }
            String strM = kotlin.jvm.internal.s.m("    ", key);
            x xVar = x.f3460a;
            String str2 = String.format(Locale.ROOT, "<Data: %d>", Arrays.copyOf(new Object[]{Integer.valueOf(iCopyAndCloseInputStream)}, 1));
            kotlin.jvm.internal.s.d(str2, "java.lang.String.format(locale, format, *args)");
            logger.appendKeyValue(strM, str2);
        }

        public final void writeLine(@NotNull String format, @NotNull Object... args) throws IOException {
            kotlin.jvm.internal.s.e(format, "format");
            kotlin.jvm.internal.s.e(args, "args");
            write(format, Arrays.copyOf(args, args.length));
            if (this.useUrlEncode) {
                return;
            }
            write("\r\n", new Object[0]);
        }

        public final void writeObject(@NotNull String key, @Nullable Object obj, @Nullable GraphRequest graphRequest) throws IOException {
            kotlin.jvm.internal.s.e(key, "key");
            Closeable closeable = this.outputStream;
            if (closeable instanceof RequestOutputStream) {
                ((RequestOutputStream) closeable).setCurrentRequest(graphRequest);
            }
            Companion companion = GraphRequest.INSTANCE;
            if (companion.isSupportedParameterType(obj)) {
                writeString(key, companion.parameterToString(obj));
                return;
            }
            if (obj instanceof Bitmap) {
                writeBitmap(key, (Bitmap) obj);
                return;
            }
            if (obj instanceof byte[]) {
                writeBytes(key, (byte[]) obj);
                return;
            }
            if (obj instanceof Uri) {
                writeContentUri(key, (Uri) obj, null);
                return;
            }
            if (obj instanceof ParcelFileDescriptor) {
                writeFile(key, (ParcelFileDescriptor) obj, null);
                return;
            }
            if (!(obj instanceof ParcelableResourceWithMimeType)) {
                throw getInvalidTypeError();
            }
            ParcelableResourceWithMimeType parcelableResourceWithMimeType = (ParcelableResourceWithMimeType) obj;
            Parcelable resource = parcelableResourceWithMimeType.getResource();
            String mimeType = parcelableResourceWithMimeType.getMimeType();
            if (resource instanceof ParcelFileDescriptor) {
                writeFile(key, (ParcelFileDescriptor) resource, mimeType);
            } else {
                if (!(resource instanceof Uri)) {
                    throw getInvalidTypeError();
                }
                writeContentUri(key, (Uri) resource, mimeType);
            }
        }

        public final void writeRecordBoundary() throws IOException {
            if (!this.useUrlEncode) {
                writeLine("--%s", GraphRequest.MIME_BOUNDARY);
                return;
            }
            OutputStream outputStream = this.outputStream;
            byte[] bytes = "&".getBytes(kotlin.text.d.UTF_8);
            kotlin.jvm.internal.s.d(bytes, "(this as java.lang.String).getBytes(charset)");
            outputStream.write(bytes);
        }

        public final void writeRequestsAsJson(@NotNull String key, @NotNull JSONArray requestJsonArray, @NotNull Collection<GraphRequest> requests) throws JSONException, IOException {
            kotlin.jvm.internal.s.e(key, "key");
            kotlin.jvm.internal.s.e(requestJsonArray, "requestJsonArray");
            kotlin.jvm.internal.s.e(requests, "requests");
            Closeable closeable = this.outputStream;
            if (!(closeable instanceof RequestOutputStream)) {
                String string = requestJsonArray.toString();
                kotlin.jvm.internal.s.d(string, "requestJsonArray.toString()");
                writeString(key, string);
                return;
            }
            RequestOutputStream requestOutputStream = (RequestOutputStream) closeable;
            writeContentDisposition(key, null, null);
            write("[", new Object[0]);
            int i2 = 0;
            for (GraphRequest graphRequest : requests) {
                int i3 = i2 + 1;
                JSONObject jSONObject = requestJsonArray.getJSONObject(i2);
                requestOutputStream.setCurrentRequest(graphRequest);
                if (i2 > 0) {
                    write(",%s", jSONObject.toString());
                } else {
                    write("%s", jSONObject.toString());
                }
                i2 = i3;
            }
            write("]", new Object[0]);
            Logger logger = this.logger;
            if (logger == null) {
                return;
            }
            String strM = kotlin.jvm.internal.s.m("    ", key);
            String string2 = requestJsonArray.toString();
            kotlin.jvm.internal.s.d(string2, "requestJsonArray.toString()");
            logger.appendKeyValue(strM, string2);
        }

        @Override // com.facebook.GraphRequest.KeyValueSerializer
        public void writeString(@NotNull String key, @NotNull String value) throws IOException {
            kotlin.jvm.internal.s.e(key, "key");
            kotlin.jvm.internal.s.e(value, "value");
            writeContentDisposition(key, null, null);
            writeLine("%s", value);
            writeRecordBoundary();
            Logger logger = this.logger;
            if (logger == null) {
                return;
            }
            logger.appendKeyValue(kotlin.jvm.internal.s.m("    ", key), value);
        }
    }

    static {
        char[] charArray = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        kotlin.jvm.internal.s.d(charArray, "(this as java.lang.String).toCharArray()");
        StringBuilder sb = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        int iNextInt = secureRandom.nextInt(11) + 30;
        if (iNextInt > 0) {
            int i2 = 0;
            do {
                i2++;
                sb.append(charArray[secureRandom.nextInt(charArray.length)]);
            } while (i2 < iNextInt);
        }
        String string = sb.toString();
        kotlin.jvm.internal.s.d(string, "buffer.toString()");
        MIME_BOUNDARY = string;
        versionPattern = Pattern.compile("^/?v\\d+\\.\\d+/(.*)");
    }

    @JvmOverloads
    public GraphRequest() {
        this(null, null, null, null, null, null, 63, null);
    }

    @JvmOverloads
    public GraphRequest(@Nullable AccessToken accessToken) {
        this(accessToken, null, null, null, null, null, 62, null);
    }

    @JvmOverloads
    public GraphRequest(@Nullable AccessToken accessToken, @Nullable String str) {
        this(accessToken, str, null, null, null, null, 60, null);
    }

    @JvmOverloads
    public GraphRequest(@Nullable AccessToken accessToken, @Nullable String str, @Nullable Bundle bundle) {
        this(accessToken, str, bundle, null, null, null, 56, null);
    }

    @JvmOverloads
    public GraphRequest(@Nullable AccessToken accessToken, @Nullable String str, @Nullable Bundle bundle, @Nullable HttpMethod httpMethod) {
        this(accessToken, str, bundle, httpMethod, null, null, 48, null);
    }

    @JvmOverloads
    public GraphRequest(@Nullable AccessToken accessToken, @Nullable String str, @Nullable Bundle bundle, @Nullable HttpMethod httpMethod, @Nullable Callback callback) {
        this(accessToken, str, bundle, httpMethod, callback, null, 32, null);
    }

    public /* synthetic */ GraphRequest(AccessToken accessToken, String str, Bundle bundle, HttpMethod httpMethod, Callback callback, String str2, int i2, kotlin.jvm.internal.o oVar) {
        this((i2 & 1) != 0 ? null : accessToken, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : bundle, (i2 & 8) != 0 ? null : httpMethod, (i2 & 16) != 0 ? null : callback, (i2 & 32) != 0 ? null : str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: _set_callback_$lambda-0, reason: not valid java name */
    public static final void m18_set_callback_$lambda0(Callback callback, GraphResponse response) {
        kotlin.jvm.internal.s.e(response, "response");
        JSONObject jSONObject = response.getGraphObject();
        JSONObject jSONObjectOptJSONObject = jSONObject == null ? null : jSONObject.optJSONObject(DEBUG_KEY);
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject == null ? null : jSONObjectOptJSONObject.optJSONArray(DEBUG_MESSAGES_KEY);
        if (jSONArrayOptJSONArray != null) {
            int i2 = 0;
            int length = jSONArrayOptJSONArray.length();
            if (length > 0) {
                while (true) {
                    int i3 = i2 + 1;
                    JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i2);
                    String strOptString = jSONObjectOptJSONObject2 == null ? null : jSONObjectOptJSONObject2.optString("message");
                    String strOptString2 = jSONObjectOptJSONObject2 == null ? null : jSONObjectOptJSONObject2.optString("type");
                    String strOptString3 = jSONObjectOptJSONObject2 == null ? null : jSONObjectOptJSONObject2.optString("link");
                    if (strOptString != null && strOptString2 != null) {
                        LoggingBehavior loggingBehavior = LoggingBehavior.GRAPH_API_DEBUG_INFO;
                        if (kotlin.jvm.internal.s.a(strOptString2, DEBUG_SEVERITY_WARNING)) {
                            loggingBehavior = LoggingBehavior.GRAPH_API_DEBUG_WARNING;
                        }
                        if (!Utility.isNullOrEmpty(strOptString3)) {
                            strOptString = ((Object) strOptString) + " Link: " + ((Object) strOptString3);
                        }
                        Logger.Companion companion = Logger.INSTANCE;
                        String TAG2 = TAG;
                        kotlin.jvm.internal.s.d(TAG2, "TAG");
                        companion.log(loggingBehavior, TAG2, strOptString);
                    }
                    if (i3 >= length) {
                        break;
                    } else {
                        i2 = i3;
                    }
                }
            }
        }
        if (callback == null) {
            return;
        }
        callback.onCompleted(response);
    }

    private final void addCommonParameters() {
        Bundle bundle = this.parameters;
        if (shouldForceClientTokenForRequest()) {
            bundle.putString("access_token", getClientTokenForRequest());
        } else {
            String accessTokenToUseForRequest = getAccessTokenToUseForRequest();
            if (accessTokenToUseForRequest != null) {
                bundle.putString("access_token", accessTokenToUseForRequest);
            }
        }
        if (!bundle.containsKey("access_token")) {
            Utility utility = Utility.INSTANCE;
            if (Utility.isNullOrEmpty(FacebookSdk.getClientToken())) {
                Log.w(TAG, "Starting with v13 of the SDK, a client token must be embedded in your client code before making Graph API calls. Visit https://developers.facebook.com/docs/android/getting-started#client-token to learn how to implement this change.");
            }
        }
        bundle.putString("sdk", "android");
        bundle.putString(FORMAT_PARAM, FORMAT_JSON);
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_INFO)) {
            bundle.putString(DEBUG_PARAM, DEBUG_SEVERITY_INFO);
        } else if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_WARNING)) {
            bundle.putString(DEBUG_PARAM, DEBUG_SEVERITY_WARNING);
        }
    }

    private final String appendParametersToBaseUrl(String baseUrl, boolean isBatch) {
        if (!isBatch && this.httpMethod == HttpMethod.POST) {
            return baseUrl;
        }
        Uri.Builder builderBuildUpon = Uri.parse(baseUrl).buildUpon();
        for (String str : this.parameters.keySet()) {
            Object obj = this.parameters.get(str);
            if (obj == null) {
                obj = "";
            }
            Companion companion = INSTANCE;
            if (companion.isSupportedParameterType(obj)) {
                builderBuildUpon.appendQueryParameter(str, companion.parameterToString(obj).toString());
            } else if (this.httpMethod != HttpMethod.GET) {
                x xVar = x.f3460a;
                String str2 = String.format(Locale.US, "Unsupported parameter type for GET request: %s", Arrays.copyOf(new Object[]{obj.getClass().getSimpleName()}, 1));
                kotlin.jvm.internal.s.d(str2, "java.lang.String.format(locale, format, *args)");
                throw new IllegalArgumentException(str2);
            }
        }
        String string = builderBuildUpon.toString();
        kotlin.jvm.internal.s.d(string, "uriBuilder.toString()");
        return string;
    }

    @JvmStatic
    @NotNull
    public static final GraphResponse executeAndWait(@NotNull GraphRequest graphRequest) {
        return INSTANCE.executeAndWait(graphRequest);
    }

    @JvmStatic
    @NotNull
    public static final List<GraphResponse> executeBatchAndWait(@NotNull GraphRequestBatch graphRequestBatch) {
        return INSTANCE.executeBatchAndWait(graphRequestBatch);
    }

    @JvmStatic
    @NotNull
    public static final List<GraphResponse> executeBatchAndWait(@NotNull Collection<GraphRequest> collection) {
        return INSTANCE.executeBatchAndWait(collection);
    }

    @JvmStatic
    @NotNull
    public static final List<GraphResponse> executeBatchAndWait(@NotNull GraphRequest... graphRequestArr) {
        return INSTANCE.executeBatchAndWait(graphRequestArr);
    }

    @JvmStatic
    @NotNull
    public static final GraphRequestAsyncTask executeBatchAsync(@NotNull GraphRequestBatch graphRequestBatch) {
        return INSTANCE.executeBatchAsync(graphRequestBatch);
    }

    @JvmStatic
    @NotNull
    public static final GraphRequestAsyncTask executeBatchAsync(@NotNull Collection<GraphRequest> collection) {
        return INSTANCE.executeBatchAsync(collection);
    }

    @JvmStatic
    @NotNull
    public static final GraphRequestAsyncTask executeBatchAsync(@NotNull GraphRequest... graphRequestArr) {
        return INSTANCE.executeBatchAsync(graphRequestArr);
    }

    @JvmStatic
    @NotNull
    public static final List<GraphResponse> executeConnectionAndWait(@NotNull HttpURLConnection httpURLConnection, @NotNull GraphRequestBatch graphRequestBatch) {
        return INSTANCE.executeConnectionAndWait(httpURLConnection, graphRequestBatch);
    }

    @JvmStatic
    @NotNull
    public static final List<GraphResponse> executeConnectionAndWait(@NotNull HttpURLConnection httpURLConnection, @NotNull Collection<GraphRequest> collection) {
        return INSTANCE.executeConnectionAndWait(httpURLConnection, collection);
    }

    @JvmStatic
    @NotNull
    public static final GraphRequestAsyncTask executeConnectionAsync(@Nullable Handler handler, @NotNull HttpURLConnection httpURLConnection, @NotNull GraphRequestBatch graphRequestBatch) {
        return INSTANCE.executeConnectionAsync(handler, httpURLConnection, graphRequestBatch);
    }

    @JvmStatic
    @NotNull
    public static final GraphRequestAsyncTask executeConnectionAsync(@NotNull HttpURLConnection httpURLConnection, @NotNull GraphRequestBatch graphRequestBatch) {
        return INSTANCE.executeConnectionAsync(httpURLConnection, graphRequestBatch);
    }

    private final String getAccessTokenToUseForRequest() {
        AccessToken accessToken = this.accessToken;
        if (accessToken != null) {
            if (!this.parameters.containsKey("access_token")) {
                String token = accessToken.getToken();
                Logger.INSTANCE.registerAccessToken(token);
                return token;
            }
        } else if (!this.parameters.containsKey("access_token")) {
            return getClientTokenForRequest();
        }
        return this.parameters.getString("access_token");
    }

    private final String getClientTokenForRequest() {
        String applicationId = FacebookSdk.getApplicationId();
        String clientToken = FacebookSdk.getClientToken();
        if (applicationId.length() > 0) {
            if (clientToken.length() > 0) {
                return applicationId + '|' + clientToken;
            }
        }
        Utility utility = Utility.INSTANCE;
        Utility.logd(TAG, "Warning: Request without access token missing application ID or client token.");
        return null;
    }

    @JvmStatic
    @Nullable
    public static final String getDefaultBatchApplicationId() {
        return INSTANCE.getDefaultBatchApplicationId();
    }

    private final String getGraphPathWithVersion() {
        if (versionPattern.matcher(this.graphPath).matches()) {
            return this.graphPath;
        }
        x xVar = x.f3460a;
        String str = String.format("%s/%s", Arrays.copyOf(new Object[]{this.version, this.graphPath}, 2));
        kotlin.jvm.internal.s.d(str, "java.lang.String.format(format, *args)");
        return str;
    }

    private final String getUrlWithGraphPath(String baseUrl) {
        if (!isValidGraphRequestForDomain()) {
            baseUrl = ServerProtocol.getFacebookGraphUrlBase();
        }
        x xVar = x.f3460a;
        String str = String.format("%s/%s", Arrays.copyOf(new Object[]{baseUrl, getGraphPathWithVersion()}, 2));
        kotlin.jvm.internal.s.d(str, "java.lang.String.format(format, *args)");
        return str;
    }

    private final boolean isApplicationRequest() {
        if (this.graphPath == null) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("^/?");
        sb.append(FacebookSdk.getApplicationId());
        sb.append("/?.*");
        return this.forceApplicationRequest || Pattern.matches(sb.toString(), this.graphPath) || Pattern.matches("^/?app/?.*", this.graphPath);
    }

    private final boolean isValidGraphRequestForDomain() {
        if (kotlin.jvm.internal.s.a(FacebookSdk.getGraphDomain(), FacebookSdk.INSTAGRAM_COM)) {
            return !isApplicationRequest();
        }
        return true;
    }

    @JvmStatic
    @NotNull
    public static final GraphRequest newCustomAudienceThirdPartyIdRequest(@Nullable AccessToken accessToken, @NotNull Context context, @Nullable Callback callback) {
        return INSTANCE.newCustomAudienceThirdPartyIdRequest(accessToken, context, callback);
    }

    @JvmStatic
    @NotNull
    public static final GraphRequest newCustomAudienceThirdPartyIdRequest(@Nullable AccessToken accessToken, @NotNull Context context, @Nullable String str, @Nullable Callback callback) {
        return INSTANCE.newCustomAudienceThirdPartyIdRequest(accessToken, context, str, callback);
    }

    @JvmStatic
    @NotNull
    public static final GraphRequest newDeleteObjectRequest(@Nullable AccessToken accessToken, @Nullable String str, @Nullable Callback callback) {
        return INSTANCE.newDeleteObjectRequest(accessToken, str, callback);
    }

    @JvmStatic
    @NotNull
    public static final GraphRequest newGraphPathRequest(@Nullable AccessToken accessToken, @Nullable String str, @Nullable Callback callback) {
        return INSTANCE.newGraphPathRequest(accessToken, str, callback);
    }

    @JvmStatic
    @NotNull
    public static final GraphRequest newMeRequest(@Nullable AccessToken accessToken, @Nullable GraphJSONObjectCallback graphJSONObjectCallback) {
        return INSTANCE.newMeRequest(accessToken, graphJSONObjectCallback);
    }

    @JvmStatic
    @NotNull
    public static final GraphRequest newMyFriendsRequest(@Nullable AccessToken accessToken, @Nullable GraphJSONArrayCallback graphJSONArrayCallback) {
        return INSTANCE.newMyFriendsRequest(accessToken, graphJSONArrayCallback);
    }

    @JvmStatic
    @NotNull
    public static final GraphRequest newPlacesSearchRequest(@Nullable AccessToken accessToken, @Nullable Location location, int i2, int i3, @Nullable String str, @Nullable GraphJSONArrayCallback graphJSONArrayCallback) {
        return INSTANCE.newPlacesSearchRequest(accessToken, location, i2, i3, str, graphJSONArrayCallback);
    }

    @JvmStatic
    @NotNull
    public static final GraphRequest newPostRequest(@Nullable AccessToken accessToken, @Nullable String str, @Nullable JSONObject jSONObject, @Nullable Callback callback) {
        return INSTANCE.newPostRequest(accessToken, str, jSONObject, callback);
    }

    @JvmStatic
    @NotNull
    public static final GraphRequest newPostRequestWithBundle(@Nullable AccessToken accessToken, @Nullable String str, @Nullable Bundle bundle, @Nullable Callback callback) {
        return INSTANCE.newPostRequestWithBundle(accessToken, str, bundle, callback);
    }

    @JvmStatic
    @NotNull
    public static final GraphRequest newUploadPhotoRequest(@Nullable AccessToken accessToken, @Nullable String str, @NotNull Bitmap bitmap, @Nullable String str2, @Nullable Bundle bundle, @Nullable Callback callback) {
        return INSTANCE.newUploadPhotoRequest(accessToken, str, bitmap, str2, bundle, callback);
    }

    @JvmStatic
    @NotNull
    public static final GraphRequest newUploadPhotoRequest(@Nullable AccessToken accessToken, @Nullable String str, @NotNull Uri uri, @Nullable String str2, @Nullable Bundle bundle, @Nullable Callback callback) throws FacebookException, FileNotFoundException {
        return INSTANCE.newUploadPhotoRequest(accessToken, str, uri, str2, bundle, callback);
    }

    @JvmStatic
    @NotNull
    public static final GraphRequest newUploadPhotoRequest(@Nullable AccessToken accessToken, @Nullable String str, @NotNull File file, @Nullable String str2, @Nullable Bundle bundle, @Nullable Callback callback) throws FileNotFoundException {
        return INSTANCE.newUploadPhotoRequest(accessToken, str, file, str2, bundle, callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void serializeToBatch(JSONArray jSONArray, Map<String, Attachment> map) throws JSONException, IOException {
        JSONObject jSONObject = new JSONObject();
        String str = this.batchEntryName;
        if (str != null) {
            jSONObject.put("name", str);
            jSONObject.put(BATCH_ENTRY_OMIT_RESPONSE_ON_SUCCESS_PARAM, this.batchEntryOmitResultOnSuccess);
        }
        String str2 = this.batchEntryDependsOn;
        if (str2 != null) {
            jSONObject.put(BATCH_ENTRY_DEPENDS_ON_PARAM, str2);
        }
        String relativeUrlForBatchedRequest = getRelativeUrlForBatchedRequest();
        jSONObject.put(BATCH_RELATIVE_URL_PARAM, relativeUrlForBatchedRequest);
        jSONObject.put(BATCH_METHOD_PARAM, this.httpMethod);
        AccessToken accessToken = this.accessToken;
        if (accessToken != null) {
            Logger.INSTANCE.registerAccessToken(accessToken.getToken());
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = this.parameters.keySet().iterator();
        while (it.hasNext()) {
            Object obj = this.parameters.get((String) it.next());
            if (INSTANCE.isSupportedAttachmentType(obj)) {
                x xVar = x.f3460a;
                String str3 = String.format(Locale.ROOT, "%s%d", Arrays.copyOf(new Object[]{"file", Integer.valueOf(map.size())}, 2));
                kotlin.jvm.internal.s.d(str3, "java.lang.String.format(locale, format, *args)");
                arrayList.add(str3);
                map.put(str3, new Attachment(this, obj));
            }
        }
        if (!arrayList.isEmpty()) {
            jSONObject.put(ATTACHED_FILES_PARAM, TextUtils.join(",", arrayList));
        }
        JSONObject jSONObject2 = this.graphObject;
        if (jSONObject2 != null) {
            final ArrayList arrayList2 = new ArrayList();
            INSTANCE.processGraphObject(jSONObject2, relativeUrlForBatchedRequest, new KeyValueSerializer() { // from class: com.facebook.GraphRequest.serializeToBatch.1
                @Override // com.facebook.GraphRequest.KeyValueSerializer
                public void writeString(@NotNull String key, @NotNull String value) throws IOException {
                    kotlin.jvm.internal.s.e(key, "key");
                    kotlin.jvm.internal.s.e(value, "value");
                    ArrayList<String> arrayList3 = arrayList2;
                    x xVar2 = x.f3460a;
                    String str4 = String.format(Locale.US, "%s=%s", Arrays.copyOf(new Object[]{key, URLEncoder.encode(value, "UTF-8")}, 2));
                    kotlin.jvm.internal.s.d(str4, "java.lang.String.format(locale, format, *args)");
                    arrayList3.add(str4);
                }
            });
            jSONObject.put(BATCH_BODY_PARAM, TextUtils.join("&", arrayList2));
        }
        jSONArray.put(jSONObject);
    }

    @JvmStatic
    public static final void setDefaultBatchApplicationId(@Nullable String str) {
        INSTANCE.setDefaultBatchApplicationId(str);
    }

    private final boolean shouldForceClientTokenForRequest() {
        String accessTokenToUseForRequest = getAccessTokenToUseForRequest();
        boolean zX = accessTokenToUseForRequest == null ? false : StringsKt__StringsKt.x(accessTokenToUseForRequest, "|", false, 2, null);
        if (((accessTokenToUseForRequest == null || !kotlin.text.s.u(accessTokenToUseForRequest, "IG", false, 2, null) || zX) ? false : true) && isApplicationRequest()) {
            return true;
        }
        return (isValidGraphRequestForDomain() || zX) ? false : true;
    }

    @JvmStatic
    @NotNull
    public static final HttpURLConnection toHttpConnection(@NotNull GraphRequestBatch graphRequestBatch) {
        return INSTANCE.toHttpConnection(graphRequestBatch);
    }

    @JvmStatic
    @NotNull
    public static final HttpURLConnection toHttpConnection(@NotNull Collection<GraphRequest> collection) {
        return INSTANCE.toHttpConnection(collection);
    }

    @JvmStatic
    @NotNull
    public static final HttpURLConnection toHttpConnection(@NotNull GraphRequest... graphRequestArr) {
        return INSTANCE.toHttpConnection(graphRequestArr);
    }

    @NotNull
    public final GraphResponse executeAndWait() {
        return INSTANCE.executeAndWait(this);
    }

    @NotNull
    public final GraphRequestAsyncTask executeAsync() {
        return INSTANCE.executeBatchAsync(this);
    }

    @Nullable
    public final AccessToken getAccessToken() {
        return this.accessToken;
    }

    @Nullable
    public final String getBatchEntryDependsOn() {
        return this.batchEntryDependsOn;
    }

    @Nullable
    public final String getBatchEntryName() {
        return this.batchEntryName;
    }

    public final boolean getBatchEntryOmitResultOnSuccess() {
        return this.batchEntryOmitResultOnSuccess;
    }

    @Nullable
    public final Callback getCallback() {
        return this.callback;
    }

    @Nullable
    public final JSONObject getGraphObject() {
        return this.graphObject;
    }

    @Nullable
    public final String getGraphPath() {
        return this.graphPath;
    }

    @Nullable
    public final HttpMethod getHttpMethod() {
        return this.httpMethod;
    }

    @NotNull
    public final Bundle getParameters() {
        return this.parameters;
    }

    @NotNull
    public final String getRelativeUrlForBatchedRequest() {
        if (this.overriddenURL != null) {
            throw new FacebookException("Can't override URL for a batch request");
        }
        String urlWithGraphPath = getUrlWithGraphPath(ServerProtocol.getGraphUrlBase());
        addCommonParameters();
        Uri uri = Uri.parse(appendParametersToBaseUrl(urlWithGraphPath, true));
        x xVar = x.f3460a;
        String str = String.format("%s?%s", Arrays.copyOf(new Object[]{uri.getPath(), uri.getQuery()}, 2));
        kotlin.jvm.internal.s.d(str, "java.lang.String.format(format, *args)");
        return str;
    }

    @Nullable
    public final Object getTag() {
        return this.tag;
    }

    @NotNull
    public final String getUrlForSingleRequest() {
        String graphUrlBaseForSubdomain;
        String str = this.overriddenURL;
        if (str != null) {
            return String.valueOf(str);
        }
        String str2 = this.graphPath;
        if (this.httpMethod == HttpMethod.POST && str2 != null && kotlin.text.s.k(str2, VIDEOS_SUFFIX, false, 2, null)) {
            graphUrlBaseForSubdomain = ServerProtocol.getGraphVideoUrlBase();
        } else {
            ServerProtocol serverProtocol = ServerProtocol.INSTANCE;
            graphUrlBaseForSubdomain = ServerProtocol.getGraphUrlBaseForSubdomain(FacebookSdk.getGraphDomain());
        }
        String urlWithGraphPath = getUrlWithGraphPath(graphUrlBaseForSubdomain);
        addCommonParameters();
        return appendParametersToBaseUrl(urlWithGraphPath, false);
    }

    @Nullable
    public final String getVersion() {
        return this.version;
    }

    public final void setAccessToken(@Nullable AccessToken accessToken) {
        this.accessToken = accessToken;
    }

    public final void setBatchEntryDependsOn(@Nullable String str) {
        this.batchEntryDependsOn = str;
    }

    public final void setBatchEntryName(@Nullable String str) {
        this.batchEntryName = str;
    }

    public final void setBatchEntryOmitResultOnSuccess(boolean z2) {
        this.batchEntryOmitResultOnSuccess = z2;
    }

    public final void setCallback(@Nullable final Callback callback) {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_INFO) || FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_WARNING)) {
            this.callback = new Callback() { // from class: com.facebook.q
                @Override // com.facebook.GraphRequest.Callback
                public final void onCompleted(GraphResponse graphResponse) {
                    GraphRequest.m18_set_callback_$lambda0(callback, graphResponse);
                }
            };
        } else {
            this.callback = callback;
        }
    }

    public final void setForceApplicationRequest(boolean z2) {
        this.forceApplicationRequest = z2;
    }

    public final void setGraphObject(@Nullable JSONObject jSONObject) {
        this.graphObject = jSONObject;
    }

    public final void setGraphPath(@Nullable String str) {
        this.graphPath = str;
    }

    public final void setHttpMethod(@Nullable HttpMethod httpMethod) {
        if (this.overriddenURL != null && httpMethod != HttpMethod.GET) {
            throw new FacebookException("Can't change HTTP method on request with overridden URL.");
        }
        if (httpMethod == null) {
            httpMethod = HttpMethod.GET;
        }
        this.httpMethod = httpMethod;
    }

    public final void setParameters(@NotNull Bundle bundle) {
        kotlin.jvm.internal.s.e(bundle, "<set-?>");
        this.parameters = bundle;
    }

    public final void setTag(@Nullable Object obj) {
        this.tag = obj;
    }

    public final void setVersion(@Nullable String str) {
        this.version = str;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{Request: ");
        sb.append(" accessToken: ");
        Object obj = this.accessToken;
        if (obj == null) {
            obj = "null";
        }
        sb.append(obj);
        sb.append(", graphPath: ");
        sb.append(this.graphPath);
        sb.append(", graphObject: ");
        sb.append(this.graphObject);
        sb.append(", httpMethod: ");
        sb.append(this.httpMethod);
        sb.append(", parameters: ");
        sb.append(this.parameters);
        sb.append("}");
        String string = sb.toString();
        kotlin.jvm.internal.s.d(string, "StringBuilder()\n        .append(\"{Request: \")\n        .append(\" accessToken: \")\n        .append(if (accessToken == null) \"null\" else accessToken)\n        .append(\", graphPath: \")\n        .append(graphPath)\n        .append(\", graphObject: \")\n        .append(graphObject)\n        .append(\", httpMethod: \")\n        .append(httpMethod)\n        .append(\", parameters: \")\n        .append(parameters)\n        .append(\"}\")\n        .toString()");
        return string;
    }

    @JvmOverloads
    public GraphRequest(@Nullable AccessToken accessToken, @Nullable String str, @Nullable Bundle bundle, @Nullable HttpMethod httpMethod, @Nullable Callback callback, @Nullable String str2) {
        this.batchEntryOmitResultOnSuccess = true;
        this.accessToken = accessToken;
        this.graphPath = str;
        this.version = str2;
        setCallback(callback);
        setHttpMethod(httpMethod);
        if (bundle != null) {
            this.parameters = new Bundle(bundle);
        } else {
            this.parameters = new Bundle();
        }
        if (this.version == null) {
            this.version = FacebookSdk.getGraphApiVersion();
        }
    }

    /* compiled from: GraphRequest.kt */
    @Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u0000 \u0017*\n\b\u0000\u0010\u0002*\u0004\u0018\u00010\u00012\u00020\u0001:\u0001\u0017B\u001b\b\u0016\u0012\u0006\u0010\u000f\u001a\u00028\u0000\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0013\u0010\u0014B\u0011\b\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0005¢\u0006\u0004\b\u0013\u0010\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u000f\u001a\u0004\u0018\u00018\u00008\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/facebook/GraphRequest$ParcelableResourceWithMimeType;", "Landroid/os/Parcelable;", "RESOURCE", "", "describeContents", "Landroid/os/Parcel;", "out", "flags", "Lkotlin/t;", "writeToParcel", "", "mimeType", "Ljava/lang/String;", "getMimeType", "()Ljava/lang/String;", "resource", "Landroid/os/Parcelable;", "getResource", "()Landroid/os/Parcelable;", "<init>", "(Landroid/os/Parcelable;Ljava/lang/String;)V", "source", "(Landroid/os/Parcel;)V", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class ParcelableResourceWithMimeType<RESOURCE extends Parcelable> implements Parcelable {

        @Nullable
        private final String mimeType;

        @Nullable
        private final RESOURCE resource;

        @JvmField
        @NotNull
        public static final Parcelable.Creator<ParcelableResourceWithMimeType<?>> CREATOR = new Parcelable.Creator<ParcelableResourceWithMimeType<?>>() { // from class: com.facebook.GraphRequest$ParcelableResourceWithMimeType$Companion$CREATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public GraphRequest.ParcelableResourceWithMimeType<?> createFromParcel(@NotNull Parcel source) {
                kotlin.jvm.internal.s.e(source, "source");
                return new GraphRequest.ParcelableResourceWithMimeType<>(source, (kotlin.jvm.internal.o) null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public GraphRequest.ParcelableResourceWithMimeType<?>[] newArray(int size) {
                return new GraphRequest.ParcelableResourceWithMimeType[size];
            }
        };

        public /* synthetic */ ParcelableResourceWithMimeType(Parcel parcel, kotlin.jvm.internal.o oVar) {
            this(parcel);
        }

        public ParcelableResourceWithMimeType(RESOURCE resource, @Nullable String str) {
            this.mimeType = str;
            this.resource = resource;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 1;
        }

        @Nullable
        public final String getMimeType() {
            return this.mimeType;
        }

        @Nullable
        public final RESOURCE getResource() {
            return this.resource;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel out, int i2) {
            kotlin.jvm.internal.s.e(out, "out");
            out.writeString(this.mimeType);
            out.writeParcelable(this.resource, i2);
        }

        private ParcelableResourceWithMimeType(Parcel parcel) {
            this.mimeType = parcel.readString();
            this.resource = (RESOURCE) parcel.readParcelable(FacebookSdk.getApplicationContext().getClassLoader());
        }
    }

    public GraphRequest(@Nullable AccessToken accessToken, @NotNull URL overriddenURL) {
        kotlin.jvm.internal.s.e(overriddenURL, "overriddenURL");
        this.batchEntryOmitResultOnSuccess = true;
        this.accessToken = accessToken;
        this.overriddenURL = overriddenURL.toString();
        setHttpMethod(HttpMethod.GET);
        this.parameters = new Bundle();
    }
}
