package com.facebook.internal.instrument.errorreport;

import androidx.annotation.RestrictTo;
import com.facebook.internal.instrument.InstrumentUtility;
import com.facebook.share.internal.ShareConstants;
import com.facebook.share.internal.ShareInternalUtility;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ErrorReportData.kt */
@Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0013\b\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0018\u0010\u0019B\u0011\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u0018\u0010\u001cJ\u0011\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\b\u0010\t\u001a\u00020\bH\u0016R\u0016\u0010\n\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0011\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001e"}, d2 = {"Lcom/facebook/internal/instrument/errorreport/ErrorReportData;", "", ShareConstants.WEB_DIALOG_PARAM_DATA, "", "compareTo", "Lkotlin/t;", "save", "clear", "", "toString", "filename", "Ljava/lang/String;", "errorMessage", "", ErrorReportData.PARAM_TIMESTAMP, "Ljava/lang/Long;", "", "isValid", "()Z", "Lorg/json/JSONObject;", "getParameters", "()Lorg/json/JSONObject;", "parameters", ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "<init>", "(Ljava/lang/String;)V", "Ljava/io/File;", ShareInternalUtility.STAGING_PARAM, "(Ljava/io/File;)V", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class ErrorReportData {

    @NotNull
    private static final String PARAM_TIMESTAMP = "timestamp";

    @NotNull
    private static final String PRARAM_ERROR_MESSAGE = "error_message";

    @Nullable
    private String errorMessage;

    @NotNull
    private String filename;

    @Nullable
    private Long timestamp;

    public ErrorReportData(@Nullable String str) {
        this.timestamp = Long.valueOf(System.currentTimeMillis() / 1000);
        this.errorMessage = str;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(InstrumentUtility.ERROR_REPORT_PREFIX);
        Long l2 = this.timestamp;
        if (l2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
        }
        stringBuffer.append(l2.longValue());
        stringBuffer.append(".json");
        String string = stringBuffer.toString();
        s.d(string, "StringBuffer()\n            .append(InstrumentUtility.ERROR_REPORT_PREFIX)\n            .append(timestamp as Long)\n            .append(\".json\")\n            .toString()");
        this.filename = string;
    }

    public final void clear() {
        InstrumentUtility instrumentUtility = InstrumentUtility.INSTANCE;
        InstrumentUtility.deleteFile(this.filename);
    }

    public final int compareTo(@NotNull ErrorReportData data) {
        s.e(data, "data");
        Long l2 = this.timestamp;
        if (l2 == null) {
            return -1;
        }
        long jLongValue = l2.longValue();
        Long l3 = data.timestamp;
        if (l3 == null) {
            return 1;
        }
        return s.g(l3.longValue(), jLongValue);
    }

    @Nullable
    public final JSONObject getParameters() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            Long l2 = this.timestamp;
            if (l2 != null) {
                jSONObject.put(PARAM_TIMESTAMP, l2);
            }
            jSONObject.put("error_message", this.errorMessage);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public final boolean isValid() {
        return (this.errorMessage == null || this.timestamp == null) ? false : true;
    }

    public final void save() throws IOException {
        if (isValid()) {
            InstrumentUtility instrumentUtility = InstrumentUtility.INSTANCE;
            InstrumentUtility.writeFile(this.filename, toString());
        }
    }

    @NotNull
    public String toString() throws JSONException {
        JSONObject parameters = getParameters();
        if (parameters == null) {
            return super.toString();
        }
        String string = parameters.toString();
        s.d(string, "params.toString()");
        return string;
    }

    public ErrorReportData(@NotNull File file) {
        s.e(file, "file");
        String name = file.getName();
        s.d(name, "file.name");
        this.filename = name;
        JSONObject file2 = InstrumentUtility.readFile(name, true);
        if (file2 != null) {
            this.timestamp = Long.valueOf(file2.optLong(PARAM_TIMESTAMP, 0L));
            this.errorMessage = file2.optString("error_message", null);
        }
    }
}
