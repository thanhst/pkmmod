package com.facebook.appevents.ml;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.appevents.internal.FileDownloadTask;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.appevents.suggestedevents.SuggestedEventsManager;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.share.internal.ShareConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.g0;
import kotlin.collections.t;
import kotlin.collections.u;
import kotlin.collections.v;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import s0.f;
import s0.l;

/* compiled from: ModelManager.kt */
@Metadata(bv = {}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002<=B\t\b\u0002¢\u0006\u0004\b:\u0010;J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0002J\n\u0010\r\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0007J;\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00172\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00110\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0017H\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ'\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00172\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0011H\u0002¢\u0006\u0004\b \u0010!J'\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00172\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\"\u0010!R\"\u0010%\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0004\u0012\u00020$0#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\b)\u0010(R\u0014\u0010*\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010(R\u0014\u0010+\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\b+\u0010(R\u0014\u0010,\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\b,\u0010(R\u0014\u0010-\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\b-\u0010(R\u0014\u0010.\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\b.\u0010(R\u0014\u0010/\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\b/\u0010(R\u0014\u00100\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\b0\u0010(R\u0014\u00102\u001a\u0002018\u0006X\u0086T¢\u0006\u0006\n\u0004\b2\u00103R\u001a\u00105\u001a\b\u0012\u0004\u0012\u00020\u0019048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u001a\u00107\u001a\b\u0012\u0004\u0012\u00020\u0019048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00106R\u0014\u00108\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b8\u00109¨\u0006>"}, d2 = {"Lcom/facebook/appevents/ml/ModelManager;", "", "Lkotlin/t;", "enable", "", "timestamp", "", "isValidTimestamp", "Lorg/json/JSONObject;", ModelManager.CACHE_KEY_MODELS, "addModels", "jsonObject", "parseRawJsonObject", "fetchModels", "enableMTML", "Lorg/json/JSONArray;", "jsonArray", "", "parseJsonArray", "Lcom/facebook/appevents/ml/ModelManager$Task;", "task", "Ljava/io/File;", "getRuleFile", "", "denses", "", "texts", "predict", "(Lcom/facebook/appevents/ml/ModelManager$Task;[[F[Ljava/lang/String;)[Ljava/lang/String;", "Lcom/facebook/appevents/ml/MTensor;", "res", ModelManager.THRESHOLD_KEY, "processSuggestedEventResult", "(Lcom/facebook/appevents/ml/MTensor;[F)[Ljava/lang/String;", "processIntegrityDetectionResult", "", "Lcom/facebook/appevents/ml/ModelManager$TaskHandler;", "taskHandlers", "Ljava/util/Map;", "MODEL_ASSERT_STORE", "Ljava/lang/String;", "CACHE_KEY_MODELS", "MTML_USE_CASE", "USE_CASE_KEY", "VERSION_ID_KEY", "ASSET_URI_KEY", "RULES_URI_KEY", "THRESHOLD_KEY", "CACHE_KEY_REQUEST_TIMESTAMP", "", "MODEL_REQUEST_INTERVAL_MILLISECONDS", "I", "", "MTML_SUGGESTED_EVENTS_PREDICTION", "Ljava/util/List;", "MTML_INTEGRITY_DETECT_PREDICTION", "isLocaleEnglish", "()Z", "<init>", "()V", "Task", "TaskHandler", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public final class ModelManager {

    @NotNull
    private static final String ASSET_URI_KEY = "asset_uri";

    @NotNull
    private static final String CACHE_KEY_MODELS = "models";

    @NotNull
    private static final String CACHE_KEY_REQUEST_TIMESTAMP = "model_request_timestamp";

    @NotNull
    private static final String MODEL_ASSERT_STORE = "com.facebook.internal.MODEL_STORE";
    public static final int MODEL_REQUEST_INTERVAL_MILLISECONDS = 259200000;

    @NotNull
    private static final String MTML_USE_CASE = "MTML";

    @NotNull
    private static final String RULES_URI_KEY = "rules_uri";

    @NotNull
    private static final String THRESHOLD_KEY = "thresholds";

    @NotNull
    private static final String USE_CASE_KEY = "use_case";

    @NotNull
    private static final String VERSION_ID_KEY = "version_id";

    @NotNull
    public static final ModelManager INSTANCE = new ModelManager();

    @NotNull
    private static final Map<String, TaskHandler> taskHandlers = new ConcurrentHashMap();

    @NotNull
    private static final List<String> MTML_SUGGESTED_EVENTS_PREDICTION = u.k("other", AppEventsConstants.EVENT_NAME_COMPLETED_REGISTRATION, AppEventsConstants.EVENT_NAME_ADDED_TO_CART, AppEventsConstants.EVENT_NAME_PURCHASED, AppEventsConstants.EVENT_NAME_INITIATED_CHECKOUT);

    @NotNull
    private static final List<String> MTML_INTEGRITY_DETECT_PREDICTION = u.k(IntegrityManager.INTEGRITY_TYPE_NONE, IntegrityManager.INTEGRITY_TYPE_ADDRESS, IntegrityManager.INTEGRITY_TYPE_HEALTH);

    /* compiled from: ModelManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/facebook/appevents/ml/ModelManager$Task;", "", "(Ljava/lang/String;I)V", "toKey", "", "toUseCase", "MTML_INTEGRITY_DETECT", "MTML_APP_EVENT_PREDICTION", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum Task {
        MTML_INTEGRITY_DETECT,
        MTML_APP_EVENT_PREDICTION;

        /* compiled from: ModelManager.kt */
        @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Task.valuesCustom().length];
                iArr[Task.MTML_INTEGRITY_DETECT.ordinal()] = 1;
                iArr[Task.MTML_APP_EVENT_PREDICTION.ordinal()] = 2;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static Task[] valuesCustom() {
            Task[] taskArrValuesCustom = values();
            return (Task[]) Arrays.copyOf(taskArrValuesCustom, taskArrValuesCustom.length);
        }

        @NotNull
        public final String toKey() {
            int i2 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
            if (i2 == 1) {
                return "integrity_detect";
            }
            if (i2 == 2) {
                return "app_event_pred";
            }
            throw new NoWhenBranchMatchedException();
        }

        @NotNull
        public final String toUseCase() {
            int i2 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
            if (i2 == 1) {
                return "MTML_INTEGRITY_DETECT";
            }
            if (i2 == 2) {
                return "MTML_APP_EVENT_PRED";
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* compiled from: ModelManager.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 *2\u00020\u0001:\u0001*B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010)\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\u000eR\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\f\"\u0004\b$\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006+"}, d2 = {"Lcom/facebook/appevents/ml/ModelManager$TaskHandler;", "", "useCase", "", "assetUri", "ruleUri", "versionId", "", ModelManager.THRESHOLD_KEY, "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I[F)V", "getAssetUri", "()Ljava/lang/String;", "setAssetUri", "(Ljava/lang/String;)V", "model", "Lcom/facebook/appevents/ml/Model;", "getModel", "()Lcom/facebook/appevents/ml/Model;", "setModel", "(Lcom/facebook/appevents/ml/Model;)V", "onPostExecute", "Ljava/lang/Runnable;", "ruleFile", "Ljava/io/File;", "getRuleFile", "()Ljava/io/File;", "setRuleFile", "(Ljava/io/File;)V", "getRuleUri", "setRuleUri", "getThresholds", "()[F", "setThresholds", "([F)V", "getUseCase", "setUseCase", "getVersionId", "()I", "setVersionId", "(I)V", "setOnPostExecute", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TaskHandler {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        private String assetUri;

        @Nullable
        private Model model;

        @Nullable
        private Runnable onPostExecute;

        @Nullable
        private File ruleFile;

        @Nullable
        private String ruleUri;

        @Nullable
        private float[] thresholds;

        @NotNull
        private String useCase;
        private int versionId;

        /* compiled from: ModelManager.kt */
        @Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\"\u0010\f\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u000fJ\u001c\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u000f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0014¨\u0006\u0018"}, d2 = {"Lcom/facebook/appevents/ml/ModelManager$TaskHandler$Companion;", "", "", "useCase", "", "versionId", "Lkotlin/t;", "deleteOldFiles", ShareConstants.MEDIA_URI, "name", "Lcom/facebook/appevents/internal/FileDownloadTask$Callback;", "onComplete", "download", "Lorg/json/JSONObject;", "json", "Lcom/facebook/appevents/ml/ModelManager$TaskHandler;", "build", "handler", "execute", "master", "", "slaves", "<init>", "()V", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(o oVar) {
                this();
            }

            private final void deleteOldFiles(String str, int i2) {
                File[] fileArrListFiles;
                File mlDir = Utils.getMlDir();
                if (mlDir == null || (fileArrListFiles = mlDir.listFiles()) == null) {
                    return;
                }
                if (fileArrListFiles.length == 0) {
                    return;
                }
                String str2 = str + '_' + i2;
                int length = fileArrListFiles.length;
                int i3 = 0;
                while (i3 < length) {
                    File file = fileArrListFiles[i3];
                    i3++;
                    String name = file.getName();
                    s.d(name, "name");
                    if (kotlin.text.s.u(name, str, false, 2, null) && !kotlin.text.s.u(name, str2, false, 2, null)) {
                        file.delete();
                    }
                }
            }

            private final void download(String str, String str2, FileDownloadTask.Callback callback) {
                File file = new File(Utils.getMlDir(), str2);
                if (str == null || file.exists()) {
                    callback.onComplete(file);
                } else {
                    new FileDownloadTask(str, file, callback).execute(new String[0]);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: execute$lambda-1, reason: not valid java name */
            public static final void m70execute$lambda1(List slaves, File file) {
                s.e(slaves, "$slaves");
                s.e(file, "file");
                final Model modelBuild = Model.INSTANCE.build(file);
                if (modelBuild != null) {
                    Iterator it = slaves.iterator();
                    while (it.hasNext()) {
                        final TaskHandler taskHandler = (TaskHandler) it.next();
                        TaskHandler.INSTANCE.download(taskHandler.getRuleUri(), taskHandler.getUseCase() + '_' + taskHandler.getVersionId() + "_rule", new FileDownloadTask.Callback() { // from class: a0.e
                            @Override // com.facebook.appevents.internal.FileDownloadTask.Callback
                            public final void onComplete(File file2) {
                                ModelManager.TaskHandler.Companion.m71execute$lambda1$lambda0(taskHandler, modelBuild, file2);
                            }
                        });
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: execute$lambda-1$lambda-0, reason: not valid java name */
            public static final void m71execute$lambda1$lambda0(TaskHandler slave, Model model, File file) {
                s.e(slave, "$slave");
                s.e(file, "file");
                slave.setModel(model);
                slave.setRuleFile(file);
                Runnable runnable = slave.onPostExecute;
                if (runnable == null) {
                    return;
                }
                runnable.run();
            }

            @Nullable
            public final TaskHandler build(@Nullable JSONObject json) throws JSONException {
                if (json == null) {
                    return null;
                }
                try {
                    String useCase = json.getString(ModelManager.USE_CASE_KEY);
                    String assetUri = json.getString(ModelManager.ASSET_URI_KEY);
                    String strOptString = json.optString(ModelManager.RULES_URI_KEY, null);
                    int i2 = json.getInt(ModelManager.VERSION_ID_KEY);
                    float[] fArrAccess$parseJsonArray = ModelManager.access$parseJsonArray(ModelManager.INSTANCE, json.getJSONArray(ModelManager.THRESHOLD_KEY));
                    s.d(useCase, "useCase");
                    s.d(assetUri, "assetUri");
                    return new TaskHandler(useCase, assetUri, strOptString, i2, fArrAccess$parseJsonArray);
                } catch (Exception unused) {
                    return null;
                }
            }

            public final void execute(@NotNull TaskHandler handler) {
                s.e(handler, "handler");
                execute(handler, t.e(handler));
            }

            public final void execute(@NotNull TaskHandler master, @NotNull final List<TaskHandler> slaves) {
                s.e(master, "master");
                s.e(slaves, "slaves");
                deleteOldFiles(master.getUseCase(), master.getVersionId());
                download(master.getAssetUri(), master.getUseCase() + '_' + master.getVersionId(), new FileDownloadTask.Callback() { // from class: a0.d
                    @Override // com.facebook.appevents.internal.FileDownloadTask.Callback
                    public final void onComplete(File file) {
                        ModelManager.TaskHandler.Companion.m70execute$lambda1(slaves, file);
                    }
                });
            }
        }

        public TaskHandler(@NotNull String useCase, @NotNull String assetUri, @Nullable String str, int i2, @Nullable float[] fArr) {
            s.e(useCase, "useCase");
            s.e(assetUri, "assetUri");
            this.useCase = useCase;
            this.assetUri = assetUri;
            this.ruleUri = str;
            this.versionId = i2;
            this.thresholds = fArr;
        }

        @NotNull
        public final String getAssetUri() {
            return this.assetUri;
        }

        @Nullable
        public final Model getModel() {
            return this.model;
        }

        @Nullable
        public final File getRuleFile() {
            return this.ruleFile;
        }

        @Nullable
        public final String getRuleUri() {
            return this.ruleUri;
        }

        @Nullable
        public final float[] getThresholds() {
            return this.thresholds;
        }

        @NotNull
        public final String getUseCase() {
            return this.useCase;
        }

        public final int getVersionId() {
            return this.versionId;
        }

        public final void setAssetUri(@NotNull String str) {
            s.e(str, "<set-?>");
            this.assetUri = str;
        }

        public final void setModel(@Nullable Model model) {
            this.model = model;
        }

        @NotNull
        public final TaskHandler setOnPostExecute(@Nullable Runnable onPostExecute) {
            this.onPostExecute = onPostExecute;
            return this;
        }

        public final void setRuleFile(@Nullable File file) {
            this.ruleFile = file;
        }

        public final void setRuleUri(@Nullable String str) {
            this.ruleUri = str;
        }

        public final void setThresholds(@Nullable float[] fArr) {
            this.thresholds = fArr;
        }

        public final void setUseCase(@NotNull String str) {
            s.e(str, "<set-?>");
            this.useCase = str;
        }

        public final void setVersionId(int i2) {
            this.versionId = i2;
        }
    }

    /* compiled from: ModelManager.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Task.valuesCustom().length];
            iArr[Task.MTML_APP_EVENT_PREDICTION.ordinal()] = 1;
            iArr[Task.MTML_INTEGRITY_DETECT.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private ModelManager() {
    }

    public static final /* synthetic */ float[] access$parseJsonArray(ModelManager modelManager, JSONArray jSONArray) {
        if (CrashShieldHandler.isObjectCrashing(ModelManager.class)) {
            return null;
        }
        try {
            return modelManager.parseJsonArray(jSONArray);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ModelManager.class);
            return null;
        }
    }

    private final void addModels(JSONObject jSONObject) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                try {
                    TaskHandler taskHandlerBuild = TaskHandler.INSTANCE.build(jSONObject.getJSONObject(itKeys.next()));
                    if (taskHandlerBuild != null) {
                        taskHandlers.put(taskHandlerBuild.getUseCase(), taskHandlerBuild);
                    }
                } catch (JSONException unused) {
                    return;
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @JvmStatic
    public static final void enable() {
        if (CrashShieldHandler.isObjectCrashing(ModelManager.class)) {
            return;
        }
        try {
            Utility utility = Utility.INSTANCE;
            Utility.runOnNonUiThread(new Runnable() { // from class: a0.a
                @Override // java.lang.Runnable
                public final void run() {
                    ModelManager.m67enable$lambda0();
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ModelManager.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: enable$lambda-0, reason: not valid java name */
    public static final void m67enable$lambda0() {
        JSONObject jSONObject;
        if (CrashShieldHandler.isObjectCrashing(ModelManager.class)) {
            return;
        }
        try {
            SharedPreferences sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences(MODEL_ASSERT_STORE, 0);
            String string = sharedPreferences.getString(CACHE_KEY_MODELS, null);
            if (string != null) {
                jSONObject = string.length() == 0 ? new JSONObject() : new JSONObject(string);
            }
            long j2 = sharedPreferences.getLong(CACHE_KEY_REQUEST_TIMESTAMP, 0L);
            FeatureManager featureManager = FeatureManager.INSTANCE;
            if (!FeatureManager.isEnabled(FeatureManager.Feature.ModelRequest) || jSONObject.length() == 0 || !INSTANCE.isValidTimestamp(j2)) {
                jSONObject = INSTANCE.fetchModels();
                if (jSONObject == null) {
                    return;
                } else {
                    sharedPreferences.edit().putString(CACHE_KEY_MODELS, jSONObject.toString()).putLong(CACHE_KEY_REQUEST_TIMESTAMP, System.currentTimeMillis()).apply();
                }
            }
            ModelManager modelManager = INSTANCE;
            modelManager.addModels(jSONObject);
            modelManager.enableMTML();
        } catch (Exception unused) {
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ModelManager.class);
        }
    }

    private final void enableMTML() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            ArrayList arrayList = new ArrayList();
            String assetUri = null;
            int iMax = 0;
            for (Map.Entry<String, TaskHandler> entry : taskHandlers.entrySet()) {
                String key = entry.getKey();
                TaskHandler value = entry.getValue();
                if (s.a(key, Task.MTML_APP_EVENT_PREDICTION.toUseCase())) {
                    String assetUri2 = value.getAssetUri();
                    int iMax2 = Math.max(iMax, value.getVersionId());
                    FeatureManager featureManager = FeatureManager.INSTANCE;
                    if (FeatureManager.isEnabled(FeatureManager.Feature.SuggestedEvents) && isLocaleEnglish()) {
                        arrayList.add(value.setOnPostExecute(new Runnable() { // from class: a0.b
                            @Override // java.lang.Runnable
                            public final void run() {
                                ModelManager.m68enableMTML$lambda1();
                            }
                        }));
                    }
                    assetUri = assetUri2;
                    iMax = iMax2;
                }
                if (s.a(key, Task.MTML_INTEGRITY_DETECT.toUseCase())) {
                    assetUri = value.getAssetUri();
                    iMax = Math.max(iMax, value.getVersionId());
                    FeatureManager featureManager2 = FeatureManager.INSTANCE;
                    if (FeatureManager.isEnabled(FeatureManager.Feature.IntelligentIntegrity)) {
                        arrayList.add(value.setOnPostExecute(new Runnable() { // from class: a0.c
                            @Override // java.lang.Runnable
                            public final void run() {
                                ModelManager.m69enableMTML$lambda2();
                            }
                        }));
                    }
                }
            }
            if (assetUri == null || iMax <= 0 || arrayList.isEmpty()) {
                return;
            }
            TaskHandler.INSTANCE.execute(new TaskHandler(MTML_USE_CASE, assetUri, null, iMax, null), arrayList);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: enableMTML$lambda-1, reason: not valid java name */
    public static final void m68enableMTML$lambda1() {
        if (CrashShieldHandler.isObjectCrashing(ModelManager.class)) {
            return;
        }
        try {
            SuggestedEventsManager.enable();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ModelManager.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: enableMTML$lambda-2, reason: not valid java name */
    public static final void m69enableMTML$lambda2() {
        if (CrashShieldHandler.isObjectCrashing(ModelManager.class)) {
            return;
        }
        try {
            IntegrityManager.enable();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ModelManager.class);
        }
    }

    private final JSONObject fetchModels() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            String[] strArr = {USE_CASE_KEY, VERSION_ID_KEY, ASSET_URI_KEY, RULES_URI_KEY, THRESHOLD_KEY};
            Bundle bundle = new Bundle();
            bundle.putString(GraphRequest.FIELDS_PARAM, TextUtils.join(",", strArr));
            GraphRequest graphRequestNewGraphPathRequest = GraphRequest.INSTANCE.newGraphPathRequest(null, "app/model_asset", null);
            graphRequestNewGraphPathRequest.setParameters(bundle);
            JSONObject graphObject = graphRequestNewGraphPathRequest.executeAndWait().getGraphObject();
            if (graphObject == null) {
                return null;
            }
            return parseRawJsonObject(graphObject);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    @JvmStatic
    @Nullable
    public static final File getRuleFile(@NotNull Task task) {
        if (CrashShieldHandler.isObjectCrashing(ModelManager.class)) {
            return null;
        }
        try {
            s.e(task, "task");
            TaskHandler taskHandler = taskHandlers.get(task.toUseCase());
            if (taskHandler == null) {
                return null;
            }
            return taskHandler.getRuleFile();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ModelManager.class);
            return null;
        }
    }

    private final boolean isLocaleEnglish() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            Locale resourceLocale = Utility.getResourceLocale();
            if (resourceLocale != null) {
                String language = resourceLocale.getLanguage();
                s.d(language, "locale.language");
                if (!StringsKt__StringsKt.x(language, "en", false, 2, null)) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    private final boolean isValidTimestamp(long timestamp) {
        if (CrashShieldHandler.isObjectCrashing(this) || timestamp == 0) {
            return false;
        }
        try {
            return System.currentTimeMillis() - timestamp < 259200000;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    private final float[] parseJsonArray(JSONArray jsonArray) {
        if (CrashShieldHandler.isObjectCrashing(this) || jsonArray == null) {
            return null;
        }
        try {
            float[] fArr = new float[jsonArray.length()];
            int i2 = 0;
            int length = jsonArray.length();
            if (length > 0) {
                while (true) {
                    int i3 = i2 + 1;
                    try {
                        String string = jsonArray.getString(i2);
                        s.d(string, "jsonArray.getString(i)");
                        fArr[i2] = Float.parseFloat(string);
                    } catch (JSONException unused) {
                    }
                    if (i3 >= length) {
                        break;
                    }
                    i2 = i3;
                }
            }
            return fArr;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final JSONObject parseRawJsonObject(JSONObject jsonObject) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONArray jSONArray = jsonObject.getJSONArray(ShareConstants.WEB_DIALOG_PARAM_DATA);
                int i2 = 0;
                int length = jSONArray.length();
                if (length <= 0) {
                    return jSONObject;
                }
                while (true) {
                    int i3 = i2 + 1;
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(VERSION_ID_KEY, jSONObject2.getString(VERSION_ID_KEY));
                    jSONObject3.put(USE_CASE_KEY, jSONObject2.getString(USE_CASE_KEY));
                    jSONObject3.put(THRESHOLD_KEY, jSONObject2.getJSONArray(THRESHOLD_KEY));
                    jSONObject3.put(ASSET_URI_KEY, jSONObject2.getString(ASSET_URI_KEY));
                    if (jSONObject2.has(RULES_URI_KEY)) {
                        jSONObject3.put(RULES_URI_KEY, jSONObject2.getString(RULES_URI_KEY));
                    }
                    jSONObject.put(jSONObject2.getString(USE_CASE_KEY), jSONObject3);
                    if (i3 >= length) {
                        return jSONObject;
                    }
                    i2 = i3;
                }
            } catch (JSONException unused) {
                return new JSONObject();
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    @JvmStatic
    @Nullable
    public static final String[] predict(@NotNull Task task, @NotNull float[][] denses, @NotNull String[] texts) {
        if (CrashShieldHandler.isObjectCrashing(ModelManager.class)) {
            return null;
        }
        try {
            s.e(task, "task");
            s.e(denses, "denses");
            s.e(texts, "texts");
            TaskHandler taskHandler = taskHandlers.get(task.toUseCase());
            Model model = taskHandler == null ? null : taskHandler.getModel();
            if (model == null) {
                return null;
            }
            float[] thresholds = taskHandler.getThresholds();
            int length = texts.length;
            int length2 = denses[0].length;
            MTensor mTensor = new MTensor(new int[]{length, length2});
            if (length > 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    System.arraycopy(denses[i2], 0, mTensor.getData(), i2 * length2, length2);
                    if (i3 >= length) {
                        break;
                    }
                    i2 = i3;
                }
            }
            MTensor mTensorPredictOnMTML = model.predictOnMTML(mTensor, texts, task.toKey());
            if (mTensorPredictOnMTML != null && thresholds != null) {
                if (!(mTensorPredictOnMTML.getData().length == 0)) {
                    if (!(thresholds.length == 0)) {
                        int i4 = WhenMappings.$EnumSwitchMapping$0[task.ordinal()];
                        if (i4 == 1) {
                            return INSTANCE.processSuggestedEventResult(mTensorPredictOnMTML, thresholds);
                        }
                        if (i4 == 2) {
                            return INSTANCE.processIntegrityDetectionResult(mTensorPredictOnMTML, thresholds);
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                }
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ModelManager.class);
            return null;
        }
    }

    private final String[] processIntegrityDetectionResult(MTensor res, float[] thresholds) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            int shape = res.getShape(0);
            int shape2 = res.getShape(1);
            float[] data = res.getData();
            if (shape2 != thresholds.length) {
                return null;
            }
            f fVarH = l.h(0, shape);
            ArrayList arrayList = new ArrayList(v.o(fVarH, 10));
            Iterator<Integer> it = fVarH.iterator();
            while (it.hasNext()) {
                int iNextInt = ((g0) it).nextInt();
                String str = IntegrityManager.INTEGRITY_TYPE_NONE;
                int length = thresholds.length;
                int i2 = 0;
                int i3 = 0;
                while (i2 < length) {
                    int i4 = i3 + 1;
                    if (data[(iNextInt * shape2) + i3] >= thresholds[i2]) {
                        str = MTML_INTEGRITY_DETECT_PREDICTION.get(i3);
                    }
                    i2++;
                    i3 = i4;
                }
                arrayList.add(str);
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array != null) {
                return (String[]) array;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final String[] processSuggestedEventResult(MTensor res, float[] thresholds) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            int shape = res.getShape(0);
            int shape2 = res.getShape(1);
            float[] data = res.getData();
            if (shape2 != thresholds.length) {
                return null;
            }
            f fVarH = l.h(0, shape);
            ArrayList arrayList = new ArrayList(v.o(fVarH, 10));
            Iterator<Integer> it = fVarH.iterator();
            while (it.hasNext()) {
                int iNextInt = ((g0) it).nextInt();
                String str = "other";
                int length = thresholds.length;
                int i2 = 0;
                int i3 = 0;
                while (i2 < length) {
                    int i4 = i3 + 1;
                    if (data[(iNextInt * shape2) + i3] >= thresholds[i2]) {
                        str = MTML_SUGGESTED_EVENTS_PREDICTION.get(i3);
                    }
                    i2++;
                    i3 = i4;
                }
                arrayList.add(str);
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array != null) {
                return (String[]) array;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }
}
