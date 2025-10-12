package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.internal.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: LegacyTokenHelper.kt */
@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001d\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0016J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\bR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/facebook/LegacyTokenHelper;", "", "", "key", "Landroid/os/Bundle;", "bundle", "Landroid/content/SharedPreferences$Editor;", "editor", "Lkotlin/t;", "serializeKey", "deserializeKey", "load", "save", "clear", "cacheKey", "Ljava/lang/String;", "Landroid/content/SharedPreferences;", "cache", "Landroid/content/SharedPreferences;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class LegacyTokenHelper {

    @NotNull
    public static final String APPLICATION_ID_KEY = "com.facebook.TokenCachingStrategy.ApplicationId";

    @NotNull
    public static final String DECLINED_PERMISSIONS_KEY = "com.facebook.TokenCachingStrategy.DeclinedPermissions";

    @NotNull
    public static final String DEFAULT_CACHE_KEY = "com.facebook.SharedPreferencesTokenCachingStrategy.DEFAULT_KEY";

    @NotNull
    public static final String EXPIRATION_DATE_KEY = "com.facebook.TokenCachingStrategy.ExpirationDate";

    @NotNull
    public static final String EXPIRED_PERMISSIONS_KEY = "com.facebook.TokenCachingStrategy.ExpiredPermissions";
    private static final long INVALID_BUNDLE_MILLISECONDS = Long.MIN_VALUE;

    @NotNull
    private static final String IS_SSO_KEY = "com.facebook.TokenCachingStrategy.IsSSO";

    @NotNull
    private static final String JSON_VALUE = "value";

    @NotNull
    private static final String JSON_VALUE_ENUM_TYPE = "enumType";

    @NotNull
    private static final String JSON_VALUE_TYPE = "valueType";

    @NotNull
    public static final String LAST_REFRESH_DATE_KEY = "com.facebook.TokenCachingStrategy.LastRefreshDate";

    @NotNull
    public static final String PERMISSIONS_KEY = "com.facebook.TokenCachingStrategy.Permissions";

    @NotNull
    public static final String TOKEN_KEY = "com.facebook.TokenCachingStrategy.Token";

    @NotNull
    public static final String TOKEN_SOURCE_KEY = "com.facebook.TokenCachingStrategy.AccessTokenSource";

    @NotNull
    private static final String TYPE_BOOLEAN = "bool";

    @NotNull
    private static final String TYPE_BOOLEAN_ARRAY = "bool[]";

    @NotNull
    private static final String TYPE_BYTE = "byte";

    @NotNull
    private static final String TYPE_BYTE_ARRAY = "byte[]";

    @NotNull
    private static final String TYPE_CHAR = "char";

    @NotNull
    private static final String TYPE_CHAR_ARRAY = "char[]";

    @NotNull
    private static final String TYPE_DOUBLE = "double";

    @NotNull
    private static final String TYPE_DOUBLE_ARRAY = "double[]";

    @NotNull
    private static final String TYPE_ENUM = "enum";

    @NotNull
    private static final String TYPE_FLOAT = "float";

    @NotNull
    private static final String TYPE_FLOAT_ARRAY = "float[]";

    @NotNull
    private static final String TYPE_INTEGER = "int";

    @NotNull
    private static final String TYPE_INTEGER_ARRAY = "int[]";

    @NotNull
    private static final String TYPE_LONG = "long";

    @NotNull
    private static final String TYPE_LONG_ARRAY = "long[]";

    @NotNull
    private static final String TYPE_SHORT = "short";

    @NotNull
    private static final String TYPE_SHORT_ARRAY = "short[]";

    @NotNull
    private static final String TYPE_STRING = "string";

    @NotNull
    private static final String TYPE_STRING_LIST = "stringList";

    @NotNull
    private final SharedPreferences cache;

    @NotNull
    private final String cacheKey;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = LegacyTokenHelper.class.getSimpleName();

    /* compiled from: LegacyTokenHelper.kt */
    @Metadata(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b0\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bI\u0010JJ\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\"\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0004H\u0007J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0006H\u0007J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0012H\u0007J\u0018\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00152\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u001e\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0017H\u0007J\u001e\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0017H\u0007J\u001e\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0017H\u0007J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u001bH\u0007J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0006H\u0007J\u0010\u0010 \u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010!\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0012H\u0007J\u0012\u0010\"\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u001a\u0010#\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0007R\u0014\u0010$\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b&\u0010%R\u0014\u0010'\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b'\u0010%R\u0014\u0010(\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b(\u0010%R\u0014\u0010)\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b)\u0010%R\u0014\u0010*\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b,\u0010%R\u0014\u0010-\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b-\u0010%R\u0014\u0010.\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b.\u0010%R\u0014\u0010/\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b/\u0010%R\u0014\u00100\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b0\u0010%R\u0014\u00101\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b1\u0010%R\u001c\u00103\u001a\n 2*\u0004\u0018\u00010\u00040\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u0010%R\u0014\u00104\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b4\u0010%R\u0014\u00105\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b5\u0010%R\u0014\u00106\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b6\u0010%R\u0014\u00107\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b7\u0010%R\u0014\u00108\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b8\u0010%R\u0014\u00109\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b9\u0010%R\u0014\u0010:\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b:\u0010%R\u0014\u0010;\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b;\u0010%R\u0014\u0010<\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b<\u0010%R\u0014\u0010=\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b=\u0010%R\u0014\u0010>\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b>\u0010%R\u0014\u0010?\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b?\u0010%R\u0014\u0010@\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b@\u0010%R\u0014\u0010A\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\bA\u0010%R\u0014\u0010B\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\bB\u0010%R\u0014\u0010C\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\bC\u0010%R\u0014\u0010D\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\bD\u0010%R\u0014\u0010E\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\bE\u0010%R\u0014\u0010F\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\bF\u0010%R\u0014\u0010G\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\bG\u0010%R\u0014\u0010H\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\bH\u0010%¨\u0006K"}, d2 = {"Lcom/facebook/LegacyTokenHelper$Companion;", "", "Landroid/os/Bundle;", "bundle", "", "key", "Ljava/util/Date;", "getDate", "date", "Lkotlin/t;", "putDate", "", "hasTokenInformation", "getToken", LegacyTokenHelper.JSON_VALUE, "putToken", "getExpirationDate", "putExpirationDate", "", "getExpirationMilliseconds", "putExpirationMilliseconds", "", "getPermissions", "", "putPermissions", "putDeclinedPermissions", "putExpiredPermissions", "Lcom/facebook/AccessTokenSource;", "getSource", "putSource", "getLastRefreshDate", "putLastRefreshDate", "getLastRefreshMilliseconds", "putLastRefreshMilliseconds", "getApplicationId", "putApplicationId", "APPLICATION_ID_KEY", "Ljava/lang/String;", "DECLINED_PERMISSIONS_KEY", "DEFAULT_CACHE_KEY", "EXPIRATION_DATE_KEY", "EXPIRED_PERMISSIONS_KEY", "INVALID_BUNDLE_MILLISECONDS", "J", "IS_SSO_KEY", "JSON_VALUE", "JSON_VALUE_ENUM_TYPE", "JSON_VALUE_TYPE", "LAST_REFRESH_DATE_KEY", "PERMISSIONS_KEY", "kotlin.jvm.PlatformType", "TAG", "TOKEN_KEY", "TOKEN_SOURCE_KEY", "TYPE_BOOLEAN", "TYPE_BOOLEAN_ARRAY", "TYPE_BYTE", "TYPE_BYTE_ARRAY", "TYPE_CHAR", "TYPE_CHAR_ARRAY", "TYPE_DOUBLE", "TYPE_DOUBLE_ARRAY", "TYPE_ENUM", "TYPE_FLOAT", "TYPE_FLOAT_ARRAY", "TYPE_INTEGER", "TYPE_INTEGER_ARRAY", "TYPE_LONG", "TYPE_LONG_ARRAY", "TYPE_SHORT", "TYPE_SHORT_ARRAY", "TYPE_STRING", "TYPE_STRING_LIST", "<init>", "()V", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.o oVar) {
            this();
        }

        private final Date getDate(Bundle bundle, String key) {
            if (bundle == null) {
                return null;
            }
            long j2 = bundle.getLong(key, LegacyTokenHelper.INVALID_BUNDLE_MILLISECONDS);
            if (j2 == LegacyTokenHelper.INVALID_BUNDLE_MILLISECONDS) {
                return null;
            }
            return new Date(j2);
        }

        private final void putDate(Bundle bundle, String str, Date date) {
            bundle.putLong(str, date.getTime());
        }

        @JvmStatic
        @Nullable
        public final String getApplicationId(@NotNull Bundle bundle) {
            kotlin.jvm.internal.s.e(bundle, "bundle");
            return bundle.getString(LegacyTokenHelper.APPLICATION_ID_KEY);
        }

        @JvmStatic
        @Nullable
        public final Date getExpirationDate(@NotNull Bundle bundle) {
            kotlin.jvm.internal.s.e(bundle, "bundle");
            return getDate(bundle, LegacyTokenHelper.EXPIRATION_DATE_KEY);
        }

        @JvmStatic
        public final long getExpirationMilliseconds(@NotNull Bundle bundle) {
            kotlin.jvm.internal.s.e(bundle, "bundle");
            return bundle.getLong(LegacyTokenHelper.EXPIRATION_DATE_KEY);
        }

        @JvmStatic
        @Nullable
        public final Date getLastRefreshDate(@NotNull Bundle bundle) {
            kotlin.jvm.internal.s.e(bundle, "bundle");
            return getDate(bundle, LegacyTokenHelper.LAST_REFRESH_DATE_KEY);
        }

        @JvmStatic
        public final long getLastRefreshMilliseconds(@NotNull Bundle bundle) {
            kotlin.jvm.internal.s.e(bundle, "bundle");
            return bundle.getLong(LegacyTokenHelper.LAST_REFRESH_DATE_KEY);
        }

        @JvmStatic
        @Nullable
        public final Set<String> getPermissions(@NotNull Bundle bundle) {
            kotlin.jvm.internal.s.e(bundle, "bundle");
            ArrayList<String> stringArrayList = bundle.getStringArrayList(LegacyTokenHelper.PERMISSIONS_KEY);
            if (stringArrayList == null) {
                return null;
            }
            return new HashSet(stringArrayList);
        }

        @JvmStatic
        @Nullable
        public final AccessTokenSource getSource(@NotNull Bundle bundle) {
            kotlin.jvm.internal.s.e(bundle, "bundle");
            return bundle.containsKey(LegacyTokenHelper.TOKEN_SOURCE_KEY) ? (AccessTokenSource) bundle.getSerializable(LegacyTokenHelper.TOKEN_SOURCE_KEY) : bundle.getBoolean(LegacyTokenHelper.IS_SSO_KEY) ? AccessTokenSource.FACEBOOK_APPLICATION_WEB : AccessTokenSource.WEB_VIEW;
        }

        @JvmStatic
        @Nullable
        public final String getToken(@NotNull Bundle bundle) {
            kotlin.jvm.internal.s.e(bundle, "bundle");
            return bundle.getString(LegacyTokenHelper.TOKEN_KEY);
        }

        @JvmStatic
        public final boolean hasTokenInformation(@Nullable Bundle bundle) {
            String string;
            if (bundle == null || (string = bundle.getString(LegacyTokenHelper.TOKEN_KEY)) == null) {
                return false;
            }
            return ((string.length() == 0) || bundle.getLong(LegacyTokenHelper.EXPIRATION_DATE_KEY, 0L) == 0) ? false : true;
        }

        @JvmStatic
        public final void putApplicationId(@NotNull Bundle bundle, @Nullable String str) {
            kotlin.jvm.internal.s.e(bundle, "bundle");
            bundle.putString(LegacyTokenHelper.APPLICATION_ID_KEY, str);
        }

        @JvmStatic
        public final void putDeclinedPermissions(@NotNull Bundle bundle, @NotNull Collection<String> value) {
            kotlin.jvm.internal.s.e(bundle, "bundle");
            kotlin.jvm.internal.s.e(value, "value");
            bundle.putStringArrayList(LegacyTokenHelper.DECLINED_PERMISSIONS_KEY, new ArrayList<>(value));
        }

        @JvmStatic
        public final void putExpirationDate(@NotNull Bundle bundle, @NotNull Date value) {
            kotlin.jvm.internal.s.e(bundle, "bundle");
            kotlin.jvm.internal.s.e(value, "value");
            putDate(bundle, LegacyTokenHelper.EXPIRATION_DATE_KEY, value);
        }

        @JvmStatic
        public final void putExpirationMilliseconds(@NotNull Bundle bundle, long j2) {
            kotlin.jvm.internal.s.e(bundle, "bundle");
            bundle.putLong(LegacyTokenHelper.EXPIRATION_DATE_KEY, j2);
        }

        @JvmStatic
        public final void putExpiredPermissions(@NotNull Bundle bundle, @NotNull Collection<String> value) {
            kotlin.jvm.internal.s.e(bundle, "bundle");
            kotlin.jvm.internal.s.e(value, "value");
            bundle.putStringArrayList(LegacyTokenHelper.EXPIRED_PERMISSIONS_KEY, new ArrayList<>(value));
        }

        @JvmStatic
        public final void putLastRefreshDate(@NotNull Bundle bundle, @NotNull Date value) {
            kotlin.jvm.internal.s.e(bundle, "bundle");
            kotlin.jvm.internal.s.e(value, "value");
            putDate(bundle, LegacyTokenHelper.LAST_REFRESH_DATE_KEY, value);
        }

        @JvmStatic
        public final void putLastRefreshMilliseconds(@NotNull Bundle bundle, long j2) {
            kotlin.jvm.internal.s.e(bundle, "bundle");
            bundle.putLong(LegacyTokenHelper.LAST_REFRESH_DATE_KEY, j2);
        }

        @JvmStatic
        public final void putPermissions(@NotNull Bundle bundle, @NotNull Collection<String> value) {
            kotlin.jvm.internal.s.e(bundle, "bundle");
            kotlin.jvm.internal.s.e(value, "value");
            bundle.putStringArrayList(LegacyTokenHelper.PERMISSIONS_KEY, new ArrayList<>(value));
        }

        @JvmStatic
        public final void putSource(@NotNull Bundle bundle, @NotNull AccessTokenSource value) {
            kotlin.jvm.internal.s.e(bundle, "bundle");
            kotlin.jvm.internal.s.e(value, "value");
            bundle.putSerializable(LegacyTokenHelper.TOKEN_SOURCE_KEY, value);
        }

        @JvmStatic
        public final void putToken(@NotNull Bundle bundle, @NotNull String value) {
            kotlin.jvm.internal.s.e(bundle, "bundle");
            kotlin.jvm.internal.s.e(value, "value");
            bundle.putString(LegacyTokenHelper.TOKEN_KEY, value);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LegacyTokenHelper(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        kotlin.jvm.internal.s.e(context, "context");
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0016  */
    @kotlin.jvm.JvmOverloads
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public LegacyTokenHelper(@org.jetbrains.annotations.NotNull android.content.Context r3, @org.jetbrains.annotations.Nullable java.lang.String r4) {
        /*
            r2 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.s.e(r3, r0)
            r2.<init>()
            r0 = 0
            if (r4 == 0) goto L16
            int r1 = r4.length()
            if (r1 != 0) goto L13
            r1 = 1
            goto L14
        L13:
            r1 = 0
        L14:
            if (r1 == 0) goto L18
        L16:
            java.lang.String r4 = "com.facebook.SharedPreferencesTokenCachingStrategy.DEFAULT_KEY"
        L18:
            r2.cacheKey = r4
            android.content.Context r1 = r3.getApplicationContext()
            if (r1 != 0) goto L21
            goto L22
        L21:
            r3 = r1
        L22:
            android.content.SharedPreferences r3 = r3.getSharedPreferences(r4, r0)
            java.lang.String r4 = "context.getSharedPreferences(this.cacheKey, Context.MODE_PRIVATE)"
            kotlin.jvm.internal.s.d(r3, r4)
            r2.cache = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.LegacyTokenHelper.<init>(android.content.Context, java.lang.String):void");
    }

    private final void deserializeKey(String str, Bundle bundle) throws JSONException {
        String str2;
        String string;
        String string2 = this.cache.getString(str, "{}");
        if (string2 == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        JSONObject jSONObject = new JSONObject(string2);
        String string3 = jSONObject.getString(JSON_VALUE_TYPE);
        if (string3 != null) {
            int i2 = 0;
            switch (string3.hashCode()) {
                case -1573317553:
                    if (string3.equals(TYPE_STRING_LIST)) {
                        JSONArray jSONArray = jSONObject.getJSONArray(JSON_VALUE);
                        int length = jSONArray.length();
                        ArrayList<String> arrayList = new ArrayList<>(length);
                        if (length > 0) {
                            while (true) {
                                int i3 = i2 + 1;
                                Object obj = jSONArray.get(i2);
                                if (obj == JSONObject.NULL) {
                                    str2 = null;
                                } else {
                                    if (obj == null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                    }
                                    str2 = (String) obj;
                                }
                                arrayList.add(i2, str2);
                                if (i3 < length) {
                                    i2 = i3;
                                }
                            }
                        }
                        bundle.putStringArrayList(str, arrayList);
                        return;
                    }
                    return;
                case -1383386164:
                    if (string3.equals(TYPE_BOOLEAN_ARRAY)) {
                        JSONArray jSONArray2 = jSONObject.getJSONArray(JSON_VALUE);
                        int length2 = jSONArray2.length();
                        boolean[] zArr = new boolean[length2];
                        int i4 = length2 - 1;
                        if (i4 >= 0) {
                            while (true) {
                                int i5 = i2 + 1;
                                zArr[i2] = jSONArray2.getBoolean(i2);
                                if (i5 <= i4) {
                                    i2 = i5;
                                }
                            }
                        }
                        bundle.putBooleanArray(str, zArr);
                        return;
                    }
                    return;
                case -1374008726:
                    if (string3.equals(TYPE_BYTE_ARRAY)) {
                        JSONArray jSONArray3 = jSONObject.getJSONArray(JSON_VALUE);
                        int length3 = jSONArray3.length();
                        byte[] bArr = new byte[length3];
                        int i6 = length3 - 1;
                        if (i6 >= 0) {
                            while (true) {
                                int i7 = i2 + 1;
                                bArr[i2] = (byte) jSONArray3.getInt(i2);
                                if (i7 <= i6) {
                                    i2 = i7;
                                }
                            }
                        }
                        bundle.putByteArray(str, bArr);
                        return;
                    }
                    return;
                case -1361632968:
                    if (string3.equals(TYPE_CHAR_ARRAY)) {
                        JSONArray jSONArray4 = jSONObject.getJSONArray(JSON_VALUE);
                        int length4 = jSONArray4.length();
                        char[] cArr = new char[length4];
                        int i8 = length4 - 1;
                        if (i8 >= 0) {
                            int i9 = 0;
                            while (true) {
                                int i10 = i9 + 1;
                                String string4 = jSONArray4.getString(i9);
                                if (string4 != null && string4.length() == 1) {
                                    cArr[i9] = string4.charAt(0);
                                }
                                if (i10 <= i8) {
                                    i9 = i10;
                                }
                            }
                        }
                        bundle.putCharArray(str, cArr);
                        return;
                    }
                    return;
                case -1325958191:
                    if (string3.equals(TYPE_DOUBLE)) {
                        bundle.putDouble(str, jSONObject.getDouble(JSON_VALUE));
                        return;
                    }
                    return;
                case -1097129250:
                    if (string3.equals(TYPE_LONG_ARRAY)) {
                        JSONArray jSONArray5 = jSONObject.getJSONArray(JSON_VALUE);
                        int length5 = jSONArray5.length();
                        long[] jArr = new long[length5];
                        int i11 = length5 - 1;
                        if (i11 >= 0) {
                            while (true) {
                                int i12 = i2 + 1;
                                jArr[i2] = jSONArray5.getLong(i2);
                                if (i12 <= i11) {
                                    i2 = i12;
                                }
                            }
                        }
                        bundle.putLongArray(str, jArr);
                        return;
                    }
                    return;
                case -891985903:
                    if (string3.equals(TYPE_STRING)) {
                        bundle.putString(str, jSONObject.getString(JSON_VALUE));
                        return;
                    }
                    return;
                case -766441794:
                    if (string3.equals(TYPE_FLOAT_ARRAY)) {
                        JSONArray jSONArray6 = jSONObject.getJSONArray(JSON_VALUE);
                        int length6 = jSONArray6.length();
                        float[] fArr = new float[length6];
                        int i13 = length6 - 1;
                        if (i13 >= 0) {
                            while (true) {
                                int i14 = i2 + 1;
                                fArr[i2] = (float) jSONArray6.getDouble(i2);
                                if (i14 <= i13) {
                                    i2 = i14;
                                }
                            }
                        }
                        bundle.putFloatArray(str, fArr);
                        return;
                    }
                    return;
                case 104431:
                    if (string3.equals(TYPE_INTEGER)) {
                        bundle.putInt(str, jSONObject.getInt(JSON_VALUE));
                        return;
                    }
                    return;
                case 3029738:
                    if (string3.equals(TYPE_BOOLEAN)) {
                        bundle.putBoolean(str, jSONObject.getBoolean(JSON_VALUE));
                        return;
                    }
                    return;
                case 3039496:
                    if (string3.equals(TYPE_BYTE)) {
                        bundle.putByte(str, (byte) jSONObject.getInt(JSON_VALUE));
                        return;
                    }
                    return;
                case 3052374:
                    if (string3.equals(TYPE_CHAR) && (string = jSONObject.getString(JSON_VALUE)) != null && string.length() == 1) {
                        bundle.putChar(str, string.charAt(0));
                        return;
                    }
                    return;
                case 3118337:
                    if (string3.equals(TYPE_ENUM)) {
                        try {
                            bundle.putSerializable(str, Enum.valueOf(Class.forName(jSONObject.getString(JSON_VALUE_ENUM_TYPE)), jSONObject.getString(JSON_VALUE)));
                            return;
                        } catch (ClassNotFoundException | IllegalArgumentException unused) {
                            return;
                        }
                    }
                    return;
                case 3327612:
                    if (string3.equals("long")) {
                        bundle.putLong(str, jSONObject.getLong(JSON_VALUE));
                        return;
                    }
                    return;
                case 97526364:
                    if (string3.equals(TYPE_FLOAT)) {
                        bundle.putFloat(str, (float) jSONObject.getDouble(JSON_VALUE));
                        return;
                    }
                    return;
                case 100361105:
                    if (string3.equals(TYPE_INTEGER_ARRAY)) {
                        JSONArray jSONArray7 = jSONObject.getJSONArray(JSON_VALUE);
                        int length7 = jSONArray7.length();
                        int[] iArr = new int[length7];
                        int i15 = length7 - 1;
                        if (i15 >= 0) {
                            while (true) {
                                int i16 = i2 + 1;
                                iArr[i2] = jSONArray7.getInt(i2);
                                if (i16 <= i15) {
                                    i2 = i16;
                                }
                            }
                        }
                        bundle.putIntArray(str, iArr);
                        return;
                    }
                    return;
                case 109413500:
                    if (string3.equals(TYPE_SHORT)) {
                        bundle.putShort(str, (short) jSONObject.getInt(JSON_VALUE));
                        return;
                    }
                    return;
                case 1359468275:
                    if (string3.equals(TYPE_DOUBLE_ARRAY)) {
                        JSONArray jSONArray8 = jSONObject.getJSONArray(JSON_VALUE);
                        int length8 = jSONArray8.length();
                        double[] dArr = new double[length8];
                        int i17 = length8 - 1;
                        if (i17 >= 0) {
                            while (true) {
                                int i18 = i2 + 1;
                                dArr[i2] = jSONArray8.getDouble(i2);
                                if (i18 <= i17) {
                                    i2 = i18;
                                }
                            }
                        }
                        bundle.putDoubleArray(str, dArr);
                        return;
                    }
                    return;
                case 2067161310:
                    if (string3.equals(TYPE_SHORT_ARRAY)) {
                        JSONArray jSONArray9 = jSONObject.getJSONArray(JSON_VALUE);
                        int length9 = jSONArray9.length();
                        short[] sArr = new short[length9];
                        int i19 = length9 - 1;
                        if (i19 >= 0) {
                            while (true) {
                                int i20 = i2 + 1;
                                sArr[i2] = (short) jSONArray9.getInt(i2);
                                if (i20 <= i19) {
                                    i2 = i20;
                                }
                            }
                        }
                        bundle.putShortArray(str, sArr);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @JvmStatic
    @Nullable
    public static final String getApplicationId(@NotNull Bundle bundle) {
        return INSTANCE.getApplicationId(bundle);
    }

    @JvmStatic
    @Nullable
    public static final Date getExpirationDate(@NotNull Bundle bundle) {
        return INSTANCE.getExpirationDate(bundle);
    }

    @JvmStatic
    public static final long getExpirationMilliseconds(@NotNull Bundle bundle) {
        return INSTANCE.getExpirationMilliseconds(bundle);
    }

    @JvmStatic
    @Nullable
    public static final Date getLastRefreshDate(@NotNull Bundle bundle) {
        return INSTANCE.getLastRefreshDate(bundle);
    }

    @JvmStatic
    public static final long getLastRefreshMilliseconds(@NotNull Bundle bundle) {
        return INSTANCE.getLastRefreshMilliseconds(bundle);
    }

    @JvmStatic
    @Nullable
    public static final Set<String> getPermissions(@NotNull Bundle bundle) {
        return INSTANCE.getPermissions(bundle);
    }

    @JvmStatic
    @Nullable
    public static final AccessTokenSource getSource(@NotNull Bundle bundle) {
        return INSTANCE.getSource(bundle);
    }

    @JvmStatic
    @Nullable
    public static final String getToken(@NotNull Bundle bundle) {
        return INSTANCE.getToken(bundle);
    }

    @JvmStatic
    public static final boolean hasTokenInformation(@Nullable Bundle bundle) {
        return INSTANCE.hasTokenInformation(bundle);
    }

    @JvmStatic
    public static final void putApplicationId(@NotNull Bundle bundle, @Nullable String str) {
        INSTANCE.putApplicationId(bundle, str);
    }

    @JvmStatic
    public static final void putDeclinedPermissions(@NotNull Bundle bundle, @NotNull Collection<String> collection) {
        INSTANCE.putDeclinedPermissions(bundle, collection);
    }

    @JvmStatic
    public static final void putExpirationDate(@NotNull Bundle bundle, @NotNull Date date) {
        INSTANCE.putExpirationDate(bundle, date);
    }

    @JvmStatic
    public static final void putExpirationMilliseconds(@NotNull Bundle bundle, long j2) {
        INSTANCE.putExpirationMilliseconds(bundle, j2);
    }

    @JvmStatic
    public static final void putExpiredPermissions(@NotNull Bundle bundle, @NotNull Collection<String> collection) {
        INSTANCE.putExpiredPermissions(bundle, collection);
    }

    @JvmStatic
    public static final void putLastRefreshDate(@NotNull Bundle bundle, @NotNull Date date) {
        INSTANCE.putLastRefreshDate(bundle, date);
    }

    @JvmStatic
    public static final void putLastRefreshMilliseconds(@NotNull Bundle bundle, long j2) {
        INSTANCE.putLastRefreshMilliseconds(bundle, j2);
    }

    @JvmStatic
    public static final void putPermissions(@NotNull Bundle bundle, @NotNull Collection<String> collection) {
        INSTANCE.putPermissions(bundle, collection);
    }

    @JvmStatic
    public static final void putSource(@NotNull Bundle bundle, @NotNull AccessTokenSource accessTokenSource) {
        INSTANCE.putSource(bundle, accessTokenSource);
    }

    @JvmStatic
    public static final void putToken(@NotNull Bundle bundle, @NotNull String str) {
        INSTANCE.putToken(bundle, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:112:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x018b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void serializeKey(java.lang.String r9, android.os.Bundle r10, android.content.SharedPreferences.Editor r11) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 418
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.LegacyTokenHelper.serializeKey(java.lang.String, android.os.Bundle, android.content.SharedPreferences$Editor):void");
    }

    public final void clear() {
        this.cache.edit().clear().apply();
    }

    @Nullable
    public final Bundle load() {
        Bundle bundle = new Bundle();
        for (String key : this.cache.getAll().keySet()) {
            try {
                kotlin.jvm.internal.s.d(key, "key");
                deserializeKey(key, bundle);
            } catch (JSONException e2) {
                Logger.Companion companion = Logger.INSTANCE;
                LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                String TAG2 = TAG;
                kotlin.jvm.internal.s.d(TAG2, "TAG");
                companion.log(loggingBehavior, 5, TAG2, "Error reading cached value for key: '" + ((Object) key) + "' -- " + e2);
                return null;
            }
        }
        return bundle;
    }

    public final void save(@NotNull Bundle bundle) {
        kotlin.jvm.internal.s.e(bundle, "bundle");
        SharedPreferences.Editor editor = this.cache.edit();
        for (String key : bundle.keySet()) {
            try {
                kotlin.jvm.internal.s.d(key, "key");
                kotlin.jvm.internal.s.d(editor, "editor");
                serializeKey(key, bundle, editor);
            } catch (JSONException e2) {
                Logger.Companion companion = Logger.INSTANCE;
                LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                String TAG2 = TAG;
                kotlin.jvm.internal.s.d(TAG2, "TAG");
                companion.log(loggingBehavior, 5, TAG2, "Error processing value for key: '" + ((Object) key) + "' -- " + e2);
                return;
            }
        }
        editor.apply();
    }

    public /* synthetic */ LegacyTokenHelper(Context context, String str, int i2, kotlin.jvm.internal.o oVar) {
        this(context, (i2 & 2) != 0 ? null : str);
    }
}
