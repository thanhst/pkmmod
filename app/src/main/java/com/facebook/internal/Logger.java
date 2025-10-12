package com.facebook.internal;

import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

/* compiled from: Logger.kt */
@Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 %2\u00020\u0001:\u0001%B\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0018\u001a\u00020\u0004¢\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004J\u0012\u0010\r\u001a\u00020\u00062\n\u0010\f\u001a\u00060\nj\u0002`\u000bJ\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004J)\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00042\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000f\"\u00020\u0001¢\u0006\u0004\b\r\u0010\u0011J\u0016\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0001R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00060\nj\u0002`\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR*\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u001c8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lcom/facebook/internal/Logger;", "", "", "shouldLog", "", "getContents", "Lkotlin/t;", "log", "string", "logString", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "stringBuilder", "append", "format", "", "args", "(Ljava/lang/String;[Ljava/lang/Object;)V", "key", "value", "appendKeyValue", "Lcom/facebook/LoggingBehavior;", "behavior", "Lcom/facebook/LoggingBehavior;", ViewHierarchyConstants.TAG_KEY, "Ljava/lang/String;", "contents", "Ljava/lang/StringBuilder;", "", "priority", "I", "getPriority", "()I", "setPriority", "(I)V", "<init>", "(Lcom/facebook/LoggingBehavior;Ljava/lang/String;)V", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Logger {

    @NotNull
    public static final String LOG_TAG_BASE = "FacebookSDK.";

    @NotNull
    private final LoggingBehavior behavior;

    @NotNull
    private StringBuilder contents;
    private int priority;

    @NotNull
    private final String tag;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final HashMap<String, String> stringsToReplace = new HashMap<>();

    /* compiled from: Logger.kt */
    @Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0007J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0007J \u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J;\u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0012\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0010\"\u00020\u0001H\u0007¢\u0006\u0004\b\u000e\u0010\u0012JC\u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0012\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0010\"\u00020\u0001H\u0007¢\u0006\u0004\b\u000e\u0010\u0015J(\u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0016\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R0\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0018j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/facebook/internal/Logger$Companion;", "", "", "string", "replaceStrings", "original", "replace", "Lkotlin/t;", "registerStringToReplace", "accessToken", "registerAccessToken", "Lcom/facebook/LoggingBehavior;", "behavior", ViewHierarchyConstants.TAG_KEY, "log", "format", "", "args", "(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "", "priority", "(Lcom/facebook/LoggingBehavior;ILjava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "LOG_TAG_BASE", "Ljava/lang/String;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "stringsToReplace", "Ljava/util/HashMap;", "<init>", "()V", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.o oVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final synchronized String replaceStrings(String string) {
            String strS;
            strS = string;
            for (Map.Entry entry : Logger.stringsToReplace.entrySet()) {
                strS = kotlin.text.s.s(strS, (String) entry.getKey(), (String) entry.getValue(), false, 4, null);
            }
            return strS;
        }

        @JvmStatic
        public final void log(@NotNull LoggingBehavior behavior, @NotNull String tag, @NotNull String string) {
            kotlin.jvm.internal.s.e(behavior, "behavior");
            kotlin.jvm.internal.s.e(tag, "tag");
            kotlin.jvm.internal.s.e(string, "string");
            log(behavior, 3, tag, string);
        }

        @JvmStatic
        public final synchronized void registerAccessToken(@NotNull String accessToken) {
            kotlin.jvm.internal.s.e(accessToken, "accessToken");
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            if (!FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.INCLUDE_ACCESS_TOKENS)) {
                registerStringToReplace(accessToken, "ACCESS_TOKEN_REMOVED");
            }
        }

        @JvmStatic
        public final synchronized void registerStringToReplace(@NotNull String original, @NotNull String replace) {
            kotlin.jvm.internal.s.e(original, "original");
            kotlin.jvm.internal.s.e(replace, "replace");
            Logger.stringsToReplace.put(original, replace);
        }

        @JvmStatic
        public final void log(@NotNull LoggingBehavior behavior, @NotNull String tag, @NotNull String format, @NotNull Object... args) {
            kotlin.jvm.internal.s.e(behavior, "behavior");
            kotlin.jvm.internal.s.e(tag, "tag");
            kotlin.jvm.internal.s.e(format, "format");
            kotlin.jvm.internal.s.e(args, "args");
            if (FacebookSdk.isLoggingBehaviorEnabled(behavior)) {
                kotlin.jvm.internal.x xVar = kotlin.jvm.internal.x.f3460a;
                Object[] objArrCopyOf = Arrays.copyOf(args, args.length);
                String str = String.format(format, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
                kotlin.jvm.internal.s.d(str, "java.lang.String.format(format, *args)");
                log(behavior, 3, tag, str);
            }
        }

        @JvmStatic
        public final void log(@NotNull LoggingBehavior behavior, int priority, @NotNull String tag, @NotNull String format, @NotNull Object... args) {
            kotlin.jvm.internal.s.e(behavior, "behavior");
            kotlin.jvm.internal.s.e(tag, "tag");
            kotlin.jvm.internal.s.e(format, "format");
            kotlin.jvm.internal.s.e(args, "args");
            if (FacebookSdk.isLoggingBehaviorEnabled(behavior)) {
                kotlin.jvm.internal.x xVar = kotlin.jvm.internal.x.f3460a;
                Object[] objArrCopyOf = Arrays.copyOf(args, args.length);
                String str = String.format(format, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
                kotlin.jvm.internal.s.d(str, "java.lang.String.format(format, *args)");
                log(behavior, priority, tag, str);
            }
        }

        @JvmStatic
        public final void log(@NotNull LoggingBehavior behavior, int i2, @NotNull String tag, @NotNull String string) {
            kotlin.jvm.internal.s.e(behavior, "behavior");
            kotlin.jvm.internal.s.e(tag, "tag");
            kotlin.jvm.internal.s.e(string, "string");
            if (FacebookSdk.isLoggingBehaviorEnabled(behavior)) {
                String strReplaceStrings = replaceStrings(string);
                if (!kotlin.text.s.u(tag, Logger.LOG_TAG_BASE, false, 2, null)) {
                    tag = kotlin.jvm.internal.s.m(Logger.LOG_TAG_BASE, tag);
                }
                Log.println(i2, tag, strReplaceStrings);
                if (behavior == LoggingBehavior.DEVELOPER_ERRORS) {
                    new Exception().printStackTrace();
                }
            }
        }
    }

    public Logger(@NotNull LoggingBehavior behavior, @NotNull String tag) {
        kotlin.jvm.internal.s.e(behavior, "behavior");
        kotlin.jvm.internal.s.e(tag, "tag");
        this.priority = 3;
        this.behavior = behavior;
        this.tag = kotlin.jvm.internal.s.m(LOG_TAG_BASE, Validate.notNullOrEmpty(tag, ViewHierarchyConstants.TAG_KEY));
        this.contents = new StringBuilder();
    }

    @JvmStatic
    public static final void log(@NotNull LoggingBehavior loggingBehavior, int i2, @NotNull String str, @NotNull String str2) {
        INSTANCE.log(loggingBehavior, i2, str, str2);
    }

    @JvmStatic
    public static final void log(@NotNull LoggingBehavior loggingBehavior, int i2, @NotNull String str, @NotNull String str2, @NotNull Object... objArr) {
        INSTANCE.log(loggingBehavior, i2, str, str2, objArr);
    }

    @JvmStatic
    public static final void log(@NotNull LoggingBehavior loggingBehavior, @NotNull String str, @NotNull String str2) {
        INSTANCE.log(loggingBehavior, str, str2);
    }

    @JvmStatic
    public static final void log(@NotNull LoggingBehavior loggingBehavior, @NotNull String str, @NotNull String str2, @NotNull Object... objArr) {
        INSTANCE.log(loggingBehavior, str, str2, objArr);
    }

    @JvmStatic
    public static final synchronized void registerAccessToken(@NotNull String str) {
        INSTANCE.registerAccessToken(str);
    }

    @JvmStatic
    public static final synchronized void registerStringToReplace(@NotNull String str, @NotNull String str2) {
        INSTANCE.registerStringToReplace(str, str2);
    }

    private final boolean shouldLog() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        return FacebookSdk.isLoggingBehaviorEnabled(this.behavior);
    }

    public final void append(@NotNull StringBuilder stringBuilder) {
        kotlin.jvm.internal.s.e(stringBuilder, "stringBuilder");
        if (shouldLog()) {
            this.contents.append((CharSequence) stringBuilder);
        }
    }

    public final void appendKeyValue(@NotNull String key, @NotNull Object value) {
        kotlin.jvm.internal.s.e(key, "key");
        kotlin.jvm.internal.s.e(value, "value");
        append("  %s:\t%s\n", key, value);
    }

    @NotNull
    public final String getContents() {
        Companion companion = INSTANCE;
        String string = this.contents.toString();
        kotlin.jvm.internal.s.d(string, "contents.toString()");
        return companion.replaceStrings(string);
    }

    public final int getPriority() {
        return this.priority;
    }

    public final void log() {
        String string = this.contents.toString();
        kotlin.jvm.internal.s.d(string, "contents.toString()");
        logString(string);
        this.contents = new StringBuilder();
    }

    public final void logString(@NotNull String string) {
        kotlin.jvm.internal.s.e(string, "string");
        INSTANCE.log(this.behavior, this.priority, this.tag, string);
    }

    public final void setPriority(int i2) {
        Validate validate = Validate.INSTANCE;
        Validate.oneOf(Integer.valueOf(i2), "value", 7, 3, 6, 4, 2, 5);
        setPriority(i2);
    }

    public final void append(@NotNull String string) {
        kotlin.jvm.internal.s.e(string, "string");
        if (shouldLog()) {
            this.contents.append(string);
        }
    }

    public final void append(@NotNull String format, @NotNull Object... args) {
        kotlin.jvm.internal.s.e(format, "format");
        kotlin.jvm.internal.s.e(args, "args");
        if (shouldLog()) {
            StringBuilder sb = this.contents;
            kotlin.jvm.internal.x xVar = kotlin.jvm.internal.x.f3460a;
            Object[] objArrCopyOf = Arrays.copyOf(args, args.length);
            String str = String.format(format, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
            kotlin.jvm.internal.s.d(str, "java.lang.String.format(format, *args)");
            sb.append(str);
        }
    }
}
