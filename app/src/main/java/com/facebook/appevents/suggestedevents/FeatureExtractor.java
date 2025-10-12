package com.facebook.appevents.suggestedevents;

import android.util.Patterns;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.share.internal.ShareInternalUtility;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.ConstantUtil;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.DataUtil;
import java.io.File;
import java.io.FileInputStream;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.l0;
import kotlin.j;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.s;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FeatureExtractor.kt */
@Metadata(bv = {}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u000b\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bB\u0010CJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J \u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0007J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\bH\u0007J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\rH\u0002J0\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0002J(\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\bH\u0002J\u0018\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\bH\u0002J+\u0010!\u001a\u00020\u00022\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\b0\u001e2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u001eH\u0002¢\u0006\u0004\b!\u0010\"J\u0018\u0010#\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0018\u0010&\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u000fH\u0002J\u0010\u0010'\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\rH\u0002J(\u0010-\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\r2\n\u0010+\u001a\u00060)j\u0002`*2\n\u0010,\u001a\u00060)j\u0002`*H\u0002J\u0012\u0010.\u001a\u0004\u0018\u00010\r2\u0006\u0010(\u001a\u00020\rH\u0002R\u0014\u00100\u001a\u00020/8\u0002X\u0082T¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u00102\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b2\u00103R\u0014\u00104\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b4\u00103R\u0014\u00105\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b5\u00103R\u0014\u00106\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b6\u00103R\u0014\u00107\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b7\u00103R\u0014\u00108\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b8\u00103R\"\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b098\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b:\u0010;R\"\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b098\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b<\u0010;R\"\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b098\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b=\u0010;R\u0016\u0010>\u001a\u00020\r8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010@\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010A¨\u0006D"}, d2 = {"Lcom/facebook/appevents/suggestedevents/FeatureExtractor;", "", "", "isInitialized", "Ljava/io/File;", ShareInternalUtility.STAGING_PARAM, "Lkotlin/t;", "initialize", "", "buttonText", "activityName", "appName", "getTextFeature", "Lorg/json/JSONObject;", "viewHierarchy", "", "getDenseFeatures", "node", "parseFeatures", "Lorg/json/JSONArray;", "siblings", "screenName", "formFieldsJSON", "nonparseFeatures", "language", "event", "textType", "matchText", "regexMatched", "pattern", "", "indicators", "values", "matchIndicators", "([Ljava/lang/String;[Ljava/lang/String;)Z", "pruneTree", "a", "b", "sum", "isButton", ViewHierarchyConstants.VIEW_KEY, "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "textSB", "hintSB", "updateHintAndTextRecursively", "getInteractedNode", "", "NUM_OF_FEATURES", "I", "REGEX_CR_PASSWORD_FIELD", "Ljava/lang/String;", "REGEX_CR_HAS_CONFIRM_PASSWORD_FIELD", "REGEX_CR_HAS_LOG_IN_KEYWORDS", "REGEX_CR_HAS_SIGN_ON_KEYWORDS", "REGEX_ADD_TO_CART_BUTTON_TEXT", "REGEX_ADD_TO_CART_PAGE_TITLE", "", "languageInfo", "Ljava/util/Map;", "eventInfo", "textTypeInfo", "rules", "Lorg/json/JSONObject;", "initialized", "Z", "<init>", "()V", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class FeatureExtractor {

    @NotNull
    public static final FeatureExtractor INSTANCE = new FeatureExtractor();
    private static final int NUM_OF_FEATURES = 30;

    @NotNull
    private static final String REGEX_ADD_TO_CART_BUTTON_TEXT = "(?i)add to(\\s|\\Z)|update(\\s|\\Z)|cart";

    @NotNull
    private static final String REGEX_ADD_TO_CART_PAGE_TITLE = "(?i)add to(\\s|\\Z)|update(\\s|\\Z)|cart|shop|buy";

    @NotNull
    private static final String REGEX_CR_HAS_CONFIRM_PASSWORD_FIELD = "(?i)(confirm.*password)|(password.*(confirmation|confirm)|confirmation)";

    @NotNull
    private static final String REGEX_CR_HAS_LOG_IN_KEYWORDS = "(?i)(sign in)|login|signIn";

    @NotNull
    private static final String REGEX_CR_HAS_SIGN_ON_KEYWORDS = "(?i)(sign.*(up|now)|registration|register|(create|apply).*(profile|account)|open.*account|account.*(open|creation|application)|enroll|join.*now)";

    @NotNull
    private static final String REGEX_CR_PASSWORD_FIELD = "password";
    private static Map<String, String> eventInfo;
    private static boolean initialized;
    private static Map<String, String> languageInfo;
    private static JSONObject rules;
    private static Map<String, String> textTypeInfo;

    private FeatureExtractor() {
    }

    @JvmStatic
    @Nullable
    public static final float[] getDenseFeatures(@NotNull JSONObject viewHierarchy, @NotNull String appName) {
        String lowerCase;
        JSONObject jSONObject;
        String screenName;
        JSONArray jSONArray;
        FeatureExtractor featureExtractor;
        JSONObject interactedNode;
        if (CrashShieldHandler.isObjectCrashing(FeatureExtractor.class)) {
            return null;
        }
        try {
            s.e(viewHierarchy, "viewHierarchy");
            s.e(appName, "appName");
            if (!initialized) {
                return null;
            }
            float[] fArr = new float[30];
            for (int i2 = 0; i2 < 30; i2++) {
                fArr[i2] = 0.0f;
            }
            try {
                lowerCase = appName.toLowerCase();
                s.d(lowerCase, "(this as java.lang.String).toLowerCase()");
                jSONObject = new JSONObject(viewHierarchy.optJSONObject(ViewHierarchyConstants.VIEW_KEY).toString());
                screenName = viewHierarchy.optString(ViewHierarchyConstants.SCREEN_NAME_KEY);
                jSONArray = new JSONArray();
                featureExtractor = INSTANCE;
                featureExtractor.pruneTree(jSONObject, jSONArray);
                featureExtractor.sum(fArr, featureExtractor.parseFeatures(jSONObject));
                interactedNode = featureExtractor.getInteractedNode(jSONObject);
            } catch (JSONException unused) {
            }
            if (interactedNode == null) {
                return null;
            }
            s.d(screenName, "screenName");
            String string = jSONObject.toString();
            s.d(string, "viewTree.toString()");
            featureExtractor.sum(fArr, featureExtractor.nonparseFeatures(interactedNode, jSONArray, screenName, string, lowerCase));
            return fArr;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, FeatureExtractor.class);
            return null;
        }
    }

    private final JSONObject getInteractedNode(JSONObject view) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
        } catch (JSONException unused) {
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
        if (view.optBoolean(ViewHierarchyConstants.IS_INTERACTED_KEY)) {
            return view;
        }
        JSONArray jSONArrayOptJSONArray = view.optJSONArray(ViewHierarchyConstants.CHILDREN_VIEW_KEY);
        if (jSONArrayOptJSONArray == null) {
            return null;
        }
        int i2 = 0;
        int length = jSONArrayOptJSONArray.length();
        if (length > 0) {
            while (true) {
                int i3 = i2 + 1;
                JSONObject jSONObject = jSONArrayOptJSONArray.getJSONObject(i2);
                s.d(jSONObject, "children.getJSONObject(i)");
                JSONObject interactedNode = getInteractedNode(jSONObject);
                if (interactedNode != null) {
                    return interactedNode;
                }
                if (i3 >= length) {
                    break;
                }
                i2 = i3;
            }
        }
        return null;
    }

    @JvmStatic
    @NotNull
    public static final String getTextFeature(@NotNull String buttonText, @NotNull String activityName, @NotNull String appName) {
        if (CrashShieldHandler.isObjectCrashing(FeatureExtractor.class)) {
            return null;
        }
        try {
            s.e(buttonText, "buttonText");
            s.e(activityName, "activityName");
            s.e(appName, "appName");
            String str = appName + " | " + activityName + ", " + buttonText;
            if (str == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = str.toLowerCase();
            s.d(lowerCase, "(this as java.lang.String).toLowerCase()");
            return lowerCase;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, FeatureExtractor.class);
            return null;
        }
    }

    @JvmStatic
    public static final void initialize(@Nullable File file) {
        if (CrashShieldHandler.isObjectCrashing(FeatureExtractor.class)) {
            return;
        }
        try {
            try {
                rules = new JSONObject();
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                fileInputStream.close();
                rules = new JSONObject(new String(bArr, d.UTF_8));
                languageInfo = l0.h(j.a(ViewHierarchyConstants.ENGLISH, "1"), j.a(ViewHierarchyConstants.GERMAN, ConstantUtil.SHOW_METHOD_PIN), j.a(ViewHierarchyConstants.SPANISH, ConstantUtil.SHOW_METHOD_LANUCH_NO_CONFIRM), j.a(ViewHierarchyConstants.JAPANESE, ConstantUtil.SHOW_METHOD_SQUARED));
                eventInfo = l0.h(j.a(ViewHierarchyConstants.VIEW_CONTENT, "0"), j.a(ViewHierarchyConstants.SEARCH, "1"), j.a(ViewHierarchyConstants.ADD_TO_CART, ConstantUtil.SHOW_METHOD_PIN), j.a(ViewHierarchyConstants.ADD_TO_WISHLIST, ConstantUtil.SHOW_METHOD_LANUCH_NO_CONFIRM), j.a(ViewHierarchyConstants.INITIATE_CHECKOUT, ConstantUtil.SHOW_METHOD_SQUARED), j.a(ViewHierarchyConstants.ADD_PAYMENT_INFO, ConstantUtil.SHOW_METHOD_LANUCH_CONFIRM), j.a(ViewHierarchyConstants.PURCHASE, ConstantUtil.SHOW_METHOD_CONTENT), j.a(ViewHierarchyConstants.LEAD, ConstantUtil.SHOW_METHOD_CONFIRM_NO_EXCHANGE), j.a(ViewHierarchyConstants.COMPLETE_REGISTRATION, "8"));
                textTypeInfo = l0.h(j.a(ViewHierarchyConstants.BUTTON_TEXT, "1"), j.a(ViewHierarchyConstants.PAGE_TITLE, ConstantUtil.SHOW_METHOD_PIN), j.a(ViewHierarchyConstants.RESOLVED_DOCUMENT_LINK, ConstantUtil.SHOW_METHOD_LANUCH_NO_CONFIRM), j.a(ViewHierarchyConstants.BUTTON_ID, ConstantUtil.SHOW_METHOD_SQUARED));
                initialized = true;
            } catch (Exception unused) {
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, FeatureExtractor.class);
        }
    }

    private final boolean isButton(JSONObject node) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            return ((node.optInt(ViewHierarchyConstants.CLASS_TYPE_BITMASK_KEY) & 1) << 5) > 0;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    @JvmStatic
    public static final boolean isInitialized() {
        if (CrashShieldHandler.isObjectCrashing(FeatureExtractor.class)) {
            return false;
        }
        try {
            return initialized;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, FeatureExtractor.class);
            return false;
        }
    }

    private final boolean matchIndicators(String[] indicators, String[] values) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            int length = indicators.length;
            int i2 = 0;
            while (i2 < length) {
                String str = indicators[i2];
                i2++;
                int length2 = values.length;
                int i3 = 0;
                while (i3 < length2) {
                    String str2 = values[i3];
                    i3++;
                    if (StringsKt__StringsKt.x(str2, str, false, 2, null)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    private final float[] nonparseFeatures(JSONObject node, JSONArray siblings, String screenName, String formFieldsJSON, String appName) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            float[] fArr = new float[30];
            for (int i2 = 0; i2 < 30; i2++) {
                fArr[i2] = 0.0f;
            }
            int length = siblings.length();
            fArr[3] = length > 1 ? length - 1.0f : 0.0f;
            try {
                int length2 = siblings.length();
                if (length2 > 0) {
                    int i3 = 0;
                    while (true) {
                        int i4 = i3 + 1;
                        JSONObject jSONObject = siblings.getJSONObject(i3);
                        s.d(jSONObject, "siblings.getJSONObject(i)");
                        if (isButton(jSONObject)) {
                            fArr[9] = fArr[9] + 1.0f;
                        }
                        if (i4 >= length2) {
                            break;
                        }
                        i3 = i4;
                    }
                }
            } catch (JSONException unused) {
            }
            fArr[13] = -1.0f;
            fArr[14] = -1.0f;
            String str = screenName + '|' + appName;
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            updateHintAndTextRecursively(node, sb2, sb);
            String string = sb.toString();
            s.d(string, "hintSB.toString()");
            String string2 = sb2.toString();
            s.d(string2, "textSB.toString()");
            fArr[15] = regexMatched(ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.COMPLETE_REGISTRATION, ViewHierarchyConstants.BUTTON_TEXT, string2) ? 1.0f : 0.0f;
            fArr[16] = regexMatched(ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.COMPLETE_REGISTRATION, ViewHierarchyConstants.PAGE_TITLE, str) ? 1.0f : 0.0f;
            fArr[17] = regexMatched(ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.COMPLETE_REGISTRATION, ViewHierarchyConstants.BUTTON_ID, string) ? 1.0f : 0.0f;
            fArr[18] = StringsKt__StringsKt.x(formFieldsJSON, "password", false, 2, null) ? 1.0f : 0.0f;
            fArr[19] = regexMatched(REGEX_CR_HAS_CONFIRM_PASSWORD_FIELD, formFieldsJSON) ? 1.0f : 0.0f;
            fArr[20] = regexMatched(REGEX_CR_HAS_LOG_IN_KEYWORDS, formFieldsJSON) ? 1.0f : 0.0f;
            fArr[21] = regexMatched(REGEX_CR_HAS_SIGN_ON_KEYWORDS, formFieldsJSON) ? 1.0f : 0.0f;
            fArr[22] = regexMatched(ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.PURCHASE, ViewHierarchyConstants.BUTTON_TEXT, string2) ? 1.0f : 0.0f;
            fArr[24] = regexMatched(ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.PURCHASE, ViewHierarchyConstants.PAGE_TITLE, str) ? 1.0f : 0.0f;
            fArr[25] = regexMatched(REGEX_ADD_TO_CART_BUTTON_TEXT, string2) ? 1.0f : 0.0f;
            fArr[27] = regexMatched(REGEX_ADD_TO_CART_PAGE_TITLE, str) ? 1.0f : 0.0f;
            fArr[28] = regexMatched(ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.LEAD, ViewHierarchyConstants.BUTTON_TEXT, string2) ? 1.0f : 0.0f;
            fArr[29] = regexMatched(ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.LEAD, ViewHierarchyConstants.PAGE_TITLE, str) ? 1.0f : 0.0f;
            return fArr;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final float[] parseFeatures(JSONObject node) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            float[] fArr = new float[30];
            int i2 = 0;
            for (int i3 = 0; i3 < 30; i3++) {
                fArr[i3] = 0.0f;
            }
            String strOptString = node.optString(ViewHierarchyConstants.TEXT_KEY);
            s.d(strOptString, "node.optString(TEXT_KEY)");
            String lowerCase = strOptString.toLowerCase();
            s.d(lowerCase, "(this as java.lang.String).toLowerCase()");
            String strOptString2 = node.optString(ViewHierarchyConstants.HINT_KEY);
            s.d(strOptString2, "node.optString(HINT_KEY)");
            String lowerCase2 = strOptString2.toLowerCase();
            s.d(lowerCase2, "(this as java.lang.String).toLowerCase()");
            String strOptString3 = node.optString(ViewHierarchyConstants.CLASS_NAME_KEY);
            s.d(strOptString3, "node.optString(CLASS_NAME_KEY)");
            String lowerCase3 = strOptString3.toLowerCase();
            s.d(lowerCase3, "(this as java.lang.String).toLowerCase()");
            int iOptInt = node.optInt(ViewHierarchyConstants.INPUT_TYPE_KEY, -1);
            String[] strArr = {lowerCase, lowerCase2};
            if (matchIndicators(new String[]{"$", DataUtil.ORDER_LIST_COLUMN.AMOUNT, "price", "total"}, strArr)) {
                fArr[0] = fArr[0] + 1.0f;
            }
            if (matchIndicators(new String[]{"password", "pwd"}, strArr)) {
                fArr[1] = fArr[1] + 1.0f;
            }
            if (matchIndicators(new String[]{"tel", DataUtil.USER_COLUMN.PHONE}, strArr)) {
                fArr[2] = fArr[2] + 1.0f;
            }
            if (matchIndicators(new String[]{"search"}, strArr)) {
                fArr[4] = fArr[4] + 1.0f;
            }
            if (iOptInt >= 0) {
                fArr[5] = fArr[5] + 1.0f;
            }
            if (iOptInt == 3 || iOptInt == 2) {
                fArr[6] = fArr[6] + 1.0f;
            }
            if (iOptInt == 32 || Patterns.EMAIL_ADDRESS.matcher(lowerCase).matches()) {
                fArr[7] = fArr[7] + 1.0f;
            }
            if (StringsKt__StringsKt.x(lowerCase3, "checkbox", false, 2, null)) {
                fArr[8] = fArr[8] + 1.0f;
            }
            if (matchIndicators(new String[]{"complete", "confirm", "done", "submit"}, new String[]{lowerCase})) {
                fArr[10] = fArr[10] + 1.0f;
            }
            if (StringsKt__StringsKt.x(lowerCase3, "radio", false, 2, null) && StringsKt__StringsKt.x(lowerCase3, "button", false, 2, null)) {
                fArr[12] = fArr[12] + 1.0f;
            }
            try {
                JSONArray jSONArrayOptJSONArray = node.optJSONArray(ViewHierarchyConstants.CHILDREN_VIEW_KEY);
                int length = jSONArrayOptJSONArray.length();
                if (length > 0) {
                    while (true) {
                        int i4 = i2 + 1;
                        JSONObject jSONObject = jSONArrayOptJSONArray.getJSONObject(i2);
                        s.d(jSONObject, "childViews.getJSONObject(i)");
                        sum(fArr, parseFeatures(jSONObject));
                        if (i4 >= length) {
                            break;
                        }
                        i2 = i4;
                    }
                }
            } catch (JSONException unused) {
            }
            return fArr;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final boolean pruneTree(JSONObject node, JSONArray siblings) {
        boolean z2;
        boolean z3;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            if (node.optBoolean(ViewHierarchyConstants.IS_INTERACTED_KEY)) {
                return true;
            }
            JSONArray jSONArrayOptJSONArray = node.optJSONArray(ViewHierarchyConstants.CHILDREN_VIEW_KEY);
            int length = jSONArrayOptJSONArray.length();
            if (length > 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    if (jSONArrayOptJSONArray.getJSONObject(i2).optBoolean(ViewHierarchyConstants.IS_INTERACTED_KEY)) {
                        z2 = true;
                        z3 = true;
                        break;
                    }
                    if (i3 >= length) {
                        break;
                    }
                    i2 = i3;
                }
                z2 = false;
                z3 = false;
            } else {
                z2 = false;
                z3 = false;
            }
            JSONArray jSONArray = new JSONArray();
            if (z2) {
                int length2 = jSONArrayOptJSONArray.length();
                if (length2 > 0) {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4 + 1;
                        siblings.put(jSONArrayOptJSONArray.getJSONObject(i4));
                        if (i5 >= length2) {
                            break;
                        }
                        i4 = i5;
                    }
                }
            } else {
                int length3 = jSONArrayOptJSONArray.length();
                if (length3 > 0) {
                    int i6 = 0;
                    while (true) {
                        int i7 = i6 + 1;
                        JSONObject child = jSONArrayOptJSONArray.getJSONObject(i6);
                        s.d(child, "child");
                        if (pruneTree(child, siblings)) {
                            jSONArray.put(child);
                            z3 = true;
                        }
                        if (i7 >= length3) {
                            break;
                        }
                        i6 = i7;
                    }
                }
                node.put(ViewHierarchyConstants.CHILDREN_VIEW_KEY, jSONArray);
            }
            return z3;
        } catch (JSONException unused) {
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    private final boolean regexMatched(String language, String event, String textType, String matchText) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        JSONObject jSONObjectOptJSONObject3;
        JSONObject jSONObjectOptJSONObject4;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            JSONObject jSONObject = rules;
            String strOptString = null;
            if (jSONObject == null) {
                s.t("rules");
                throw null;
            }
            JSONObject jSONObjectOptJSONObject5 = jSONObject.optJSONObject("rulesForLanguage");
            if (jSONObjectOptJSONObject5 == null) {
                jSONObjectOptJSONObject = null;
            } else {
                Map<String, String> map = languageInfo;
                if (map == null) {
                    s.t("languageInfo");
                    throw null;
                }
                jSONObjectOptJSONObject = jSONObjectOptJSONObject5.optJSONObject(map.get(language));
            }
            if (jSONObjectOptJSONObject == null || (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("rulesForEvent")) == null) {
                jSONObjectOptJSONObject3 = null;
            } else {
                Map<String, String> map2 = eventInfo;
                if (map2 == null) {
                    s.t("eventInfo");
                    throw null;
                }
                jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject(map2.get(event));
            }
            if (jSONObjectOptJSONObject3 != null && (jSONObjectOptJSONObject4 = jSONObjectOptJSONObject3.optJSONObject("positiveRules")) != null) {
                Map<String, String> map3 = textTypeInfo;
                if (map3 == null) {
                    s.t("textTypeInfo");
                    throw null;
                }
                strOptString = jSONObjectOptJSONObject4.optString(map3.get(textType));
            }
            if (strOptString == null) {
                return false;
            }
            return regexMatched(strOptString, matchText);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    private final void sum(float[] fArr, float[] fArr2) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        int i2 = 0;
        try {
            int length = fArr.length - 1;
            if (length < 0) {
                return;
            }
            while (true) {
                int i3 = i2 + 1;
                fArr[i2] = fArr[i2] + fArr2[i2];
                if (i3 > length) {
                    return;
                } else {
                    i2 = i3;
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private final void updateHintAndTextRecursively(JSONObject jSONObject, StringBuilder sb, StringBuilder sb2) {
        int length;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            String strOptString = jSONObject.optString(ViewHierarchyConstants.TEXT_KEY, "");
            s.d(strOptString, "view.optString(TEXT_KEY, \"\")");
            String lowerCase = strOptString.toLowerCase();
            s.d(lowerCase, "(this as java.lang.String).toLowerCase()");
            String strOptString2 = jSONObject.optString(ViewHierarchyConstants.HINT_KEY, "");
            s.d(strOptString2, "view.optString(HINT_KEY, \"\")");
            String lowerCase2 = strOptString2.toLowerCase();
            s.d(lowerCase2, "(this as java.lang.String).toLowerCase()");
            boolean z2 = true;
            int i2 = 0;
            if (lowerCase.length() > 0) {
                sb.append(lowerCase);
                sb.append(" ");
            }
            if (lowerCase2.length() <= 0) {
                z2 = false;
            }
            if (z2) {
                sb2.append(lowerCase2);
                sb2.append(" ");
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(ViewHierarchyConstants.CHILDREN_VIEW_KEY);
            if (jSONArrayOptJSONArray == null || (length = jSONArrayOptJSONArray.length()) <= 0) {
                return;
            }
            while (true) {
                int i3 = i2 + 1;
                try {
                    JSONObject currentChildView = jSONArrayOptJSONArray.getJSONObject(i2);
                    s.d(currentChildView, "currentChildView");
                    updateHintAndTextRecursively(currentChildView, sb, sb2);
                } catch (JSONException unused) {
                }
                if (i3 >= length) {
                    return;
                } else {
                    i2 = i3;
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private final boolean regexMatched(String pattern, String matchText) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            return Pattern.compile(pattern).matcher(matchText).find();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }
}
