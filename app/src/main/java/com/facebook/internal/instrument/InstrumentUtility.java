package com.facebook.internal.instrument;

import androidx.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.InstrumentUtility;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.x;
import kotlin.text.Regex;
import kotlin.text.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: InstrumentUtility.kt */
@Metadata(bv = {}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b,\u0010-J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u0012\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\u000b\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007J\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0007¢\u0006\u0004\b\u0010\u0010\u000fJ\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0007¢\u0006\u0004\b\u0011\u0010\u000fJ\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\tH\u0007J\u001c\u0010\u0018\u001a\u00020\u00172\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\u0019\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0007J$\u0010\u001f\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0007J\n\u0010 \u001a\u0004\u0018\u00010\rH\u0007R\u0014\u0010!\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b#\u0010\"R\u0014\u0010$\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b$\u0010\"R\u0014\u0010%\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b%\u0010\"R\u0014\u0010&\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b&\u0010\"R\u0014\u0010'\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b'\u0010\"R\u0014\u0010(\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010\"R\u0014\u0010)\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b)\u0010\"R\u0014\u0010*\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010\"R\u0014\u0010+\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b+\u0010\"¨\u0006."}, d2 = {"Lcom/facebook/internal/instrument/InstrumentUtility;", "", "", "e", "", "getCause", "getStackTrace", "Ljava/lang/Thread;", "thread", "", "isSDKRelatedException", "isSDKRelatedThread", "", "Ljava/io/File;", "listAnrReportFiles", "()[Ljava/io/File;", "listExceptionAnalysisReportFiles", "listExceptionReportFiles", "filename", "deleteOnException", "Lorg/json/JSONObject;", "readFile", "content", "Lkotlin/t;", "writeFile", "deleteFile", "key", "Lorg/json/JSONArray;", "reports", "Lcom/facebook/GraphRequest$Callback;", "callback", "sendReports", "getInstrumentReportDir", "ANALYSIS_REPORT_PREFIX", "Ljava/lang/String;", "ANR_REPORT_PREFIX", "CRASH_REPORT_PREFIX", "CRASH_SHIELD_PREFIX", "THREAD_CHECK_PREFIX", "ERROR_REPORT_PREFIX", "FBSDK_PREFIX", "CODELESS_PREFIX", "SUGGESTED_EVENTS_PREFIX", "INSTRUMENT_DIR", "<init>", "()V", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class InstrumentUtility {

    @NotNull
    public static final String ANALYSIS_REPORT_PREFIX = "analysis_log_";

    @NotNull
    public static final String ANR_REPORT_PREFIX = "anr_log_";

    @NotNull
    private static final String CODELESS_PREFIX = "com.facebook.appevents.codeless";

    @NotNull
    public static final String CRASH_REPORT_PREFIX = "crash_log_";

    @NotNull
    public static final String CRASH_SHIELD_PREFIX = "shield_log_";

    @NotNull
    public static final String ERROR_REPORT_PREFIX = "error_log_";

    @NotNull
    private static final String FBSDK_PREFIX = "com.facebook";

    @NotNull
    public static final InstrumentUtility INSTANCE = new InstrumentUtility();

    @NotNull
    private static final String INSTRUMENT_DIR = "instrument";

    @NotNull
    private static final String SUGGESTED_EVENTS_PREFIX = "com.facebook.appevents.suggestedevents";

    @NotNull
    public static final String THREAD_CHECK_PREFIX = "thread_check_log_";

    private InstrumentUtility() {
    }

    @JvmStatic
    public static final boolean deleteFile(@Nullable String filename) {
        File instrumentReportDir = getInstrumentReportDir();
        if (instrumentReportDir == null || filename == null) {
            return false;
        }
        return new File(instrumentReportDir, filename).delete();
    }

    @JvmStatic
    @Nullable
    public static final String getCause(@Nullable Throwable e2) {
        if (e2 == null) {
            return null;
        }
        return e2.getCause() == null ? e2.toString() : String.valueOf(e2.getCause());
    }

    @JvmStatic
    @Nullable
    public static final File getInstrumentReportDir() {
        File file = new File(FacebookSdk.getApplicationContext().getCacheDir(), INSTRUMENT_DIR);
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        return null;
    }

    @JvmStatic
    @Nullable
    public static final String getStackTrace(@Nullable Throwable e2) {
        Throwable th = null;
        if (e2 == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        while (e2 != null && e2 != th) {
            StackTraceElement[] stackTrace = e2.getStackTrace();
            s.d(stackTrace, "t.stackTrace");
            int i2 = 0;
            int length = stackTrace.length;
            while (i2 < length) {
                StackTraceElement stackTraceElement = stackTrace[i2];
                i2++;
                jSONArray.put(stackTraceElement.toString());
            }
            th = e2;
            e2 = e2.getCause();
        }
        return jSONArray.toString();
    }

    @JvmStatic
    public static final boolean isSDKRelatedException(@Nullable Throwable e2) {
        if (e2 == null) {
            return false;
        }
        Throwable th = null;
        while (e2 != null && e2 != th) {
            StackTraceElement[] stackTrace = e2.getStackTrace();
            s.d(stackTrace, "t.stackTrace");
            int length = stackTrace.length;
            int i2 = 0;
            while (i2 < length) {
                StackTraceElement stackTraceElement = stackTrace[i2];
                i2++;
                String className = stackTraceElement.getClassName();
                s.d(className, "element.className");
                if (kotlin.text.s.u(className, FBSDK_PREFIX, false, 2, null)) {
                    return true;
                }
            }
            th = e2;
            e2 = e2.getCause();
        }
        return false;
    }

    @JvmStatic
    public static final boolean isSDKRelatedThread(@Nullable Thread thread) {
        StackTraceElement[] stackTrace;
        if (thread != null && (stackTrace = thread.getStackTrace()) != null) {
            for (StackTraceElement stackTraceElement : stackTrace) {
                String className = stackTraceElement.getClassName();
                s.d(className, "element.className");
                if (kotlin.text.s.u(className, FBSDK_PREFIX, false, 2, null)) {
                    String className2 = stackTraceElement.getClassName();
                    s.d(className2, "element.className");
                    if (!kotlin.text.s.u(className2, CODELESS_PREFIX, false, 2, null)) {
                        String className3 = stackTraceElement.getClassName();
                        s.d(className3, "element.className");
                        if (!kotlin.text.s.u(className3, SUGGESTED_EVENTS_PREFIX, false, 2, null)) {
                            return true;
                        }
                    }
                    String methodName = stackTraceElement.getMethodName();
                    s.d(methodName, "element.methodName");
                    if (kotlin.text.s.u(methodName, "onClick", false, 2, null)) {
                        continue;
                    } else {
                        String methodName2 = stackTraceElement.getMethodName();
                        s.d(methodName2, "element.methodName");
                        if (kotlin.text.s.u(methodName2, "onItemClick", false, 2, null)) {
                            continue;
                        } else {
                            String methodName3 = stackTraceElement.getMethodName();
                            s.d(methodName3, "element.methodName");
                            if (!kotlin.text.s.u(methodName3, "onTouch", false, 2, null)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @JvmStatic
    @NotNull
    public static final File[] listAnrReportFiles() {
        File instrumentReportDir = getInstrumentReportDir();
        if (instrumentReportDir == null) {
            return new File[0];
        }
        File[] fileArrListFiles = instrumentReportDir.listFiles(new FilenameFilter() { // from class: c0.g
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str) {
                return InstrumentUtility.m122listAnrReportFiles$lambda1(file, str);
            }
        });
        return fileArrListFiles == null ? new File[0] : fileArrListFiles;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listAnrReportFiles$lambda-1, reason: not valid java name */
    public static final boolean m122listAnrReportFiles$lambda1(File file, String name) {
        s.d(name, "name");
        x xVar = x.f3460a;
        String str = String.format("^%s[0-9]+.json$", Arrays.copyOf(new Object[]{ANR_REPORT_PREFIX}, 1));
        s.d(str, "java.lang.String.format(format, *args)");
        return new Regex(str).matches(name);
    }

    @JvmStatic
    @NotNull
    public static final File[] listExceptionAnalysisReportFiles() {
        File instrumentReportDir = getInstrumentReportDir();
        if (instrumentReportDir == null) {
            return new File[0];
        }
        File[] fileArrListFiles = instrumentReportDir.listFiles(new FilenameFilter() { // from class: c0.f
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str) {
                return InstrumentUtility.m123listExceptionAnalysisReportFiles$lambda2(file, str);
            }
        });
        return fileArrListFiles == null ? new File[0] : fileArrListFiles;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listExceptionAnalysisReportFiles$lambda-2, reason: not valid java name */
    public static final boolean m123listExceptionAnalysisReportFiles$lambda2(File file, String name) {
        s.d(name, "name");
        x xVar = x.f3460a;
        String str = String.format("^%s[0-9]+.json$", Arrays.copyOf(new Object[]{ANALYSIS_REPORT_PREFIX}, 1));
        s.d(str, "java.lang.String.format(format, *args)");
        return new Regex(str).matches(name);
    }

    @JvmStatic
    @NotNull
    public static final File[] listExceptionReportFiles() {
        File instrumentReportDir = getInstrumentReportDir();
        if (instrumentReportDir == null) {
            return new File[0];
        }
        File[] fileArrListFiles = instrumentReportDir.listFiles(new FilenameFilter() { // from class: c0.e
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str) {
                return InstrumentUtility.m124listExceptionReportFiles$lambda3(file, str);
            }
        });
        return fileArrListFiles == null ? new File[0] : fileArrListFiles;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listExceptionReportFiles$lambda-3, reason: not valid java name */
    public static final boolean m124listExceptionReportFiles$lambda3(File file, String name) {
        s.d(name, "name");
        x xVar = x.f3460a;
        String str = String.format("^(%s|%s|%s)[0-9]+.json$", Arrays.copyOf(new Object[]{CRASH_REPORT_PREFIX, CRASH_SHIELD_PREFIX, THREAD_CHECK_PREFIX}, 3));
        s.d(str, "java.lang.String.format(format, *args)");
        return new Regex(str).matches(name);
    }

    @JvmStatic
    @Nullable
    public static final JSONObject readFile(@Nullable String filename, boolean deleteOnException) {
        File instrumentReportDir = getInstrumentReportDir();
        if (instrumentReportDir != null && filename != null) {
            try {
                return new JSONObject(Utility.readStreamToString(new FileInputStream(new File(instrumentReportDir, filename))));
            } catch (Exception unused) {
                if (deleteOnException) {
                    deleteFile(filename);
                }
            }
        }
        return null;
    }

    @JvmStatic
    public static final void sendReports(@Nullable String str, @NotNull JSONArray reports, @Nullable GraphRequest.Callback callback) throws JSONException {
        s.e(reports, "reports");
        if (reports.length() == 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(str, reports.toString());
            JSONObject dataProcessingOptions = Utility.getDataProcessingOptions();
            if (dataProcessingOptions != null) {
                Iterator<String> itKeys = dataProcessingOptions.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    jSONObject.put(next, dataProcessingOptions.get(next));
                }
            }
            GraphRequest.Companion companion = GraphRequest.INSTANCE;
            x xVar = x.f3460a;
            String str2 = String.format("%s/instruments", Arrays.copyOf(new Object[]{FacebookSdk.getApplicationId()}, 1));
            s.d(str2, "java.lang.String.format(format, *args)");
            companion.newPostRequest(null, str2, jSONObject, callback).executeAsync();
        } catch (JSONException unused) {
        }
    }

    @JvmStatic
    public static final void writeFile(@Nullable String str, @Nullable String str2) throws IOException {
        File instrumentReportDir = getInstrumentReportDir();
        if (instrumentReportDir == null || str == null || str2 == null) {
            return;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(instrumentReportDir, str));
            byte[] bytes = str2.getBytes(d.UTF_8);
            s.d(bytes, "(this as java.lang.String).getBytes(charset)");
            fileOutputStream.write(bytes);
            fileOutputStream.close();
        } catch (Exception unused) {
        }
    }

    @JvmStatic
    @Nullable
    public static final String getStackTrace(@NotNull Thread thread) {
        s.e(thread, "thread");
        StackTraceElement[] stackTrace = thread.getStackTrace();
        JSONArray jSONArray = new JSONArray();
        s.d(stackTrace, "stackTrace");
        int length = stackTrace.length;
        int i2 = 0;
        while (i2 < length) {
            StackTraceElement stackTraceElement = stackTrace[i2];
            i2++;
            jSONArray.put(stackTraceElement.toString());
        }
        return jSONArray.toString();
    }
}
