package com.facebook.appevents.internal;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import com.facebook.FacebookSdk;
import com.facebook.bolts.AppLinks;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SourceApplicationInfo.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0002\u0010\u0011B\u001b\b\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0005\u001a\u00020\u0004R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/facebook/appevents/internal/SourceApplicationInfo;", "", "", "toString", "Lkotlin/t;", "writeSourceApplicationInfoToDisk", "callingApplicationPackage", "Ljava/lang/String;", "getCallingApplicationPackage", "()Ljava/lang/String;", "", "isOpenedByAppLink", "Z", "()Z", "<init>", "(Ljava/lang/String;Z)V", "Companion", "Factory", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SourceApplicationInfo {

    @NotNull
    private static final String CALL_APPLICATION_PACKAGE_KEY = "com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String OPENED_BY_APP_LINK_KEY = "com.facebook.appevents.SourceApplicationInfo.openedByApplink";

    @NotNull
    private static final String SOURCE_APPLICATION_HAS_BEEN_SET_BY_THIS_INTENT = "_fbSourceApplicationHasBeenSet";

    @Nullable
    private final String callingApplicationPackage;
    private final boolean isOpenedByAppLink;

    /* compiled from: SourceApplicationInfo.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\b¨\u0006\r"}, d2 = {"Lcom/facebook/appevents/internal/SourceApplicationInfo$Companion;", "", "Lcom/facebook/appevents/internal/SourceApplicationInfo;", "getStoredSourceApplicatioInfo", "Lkotlin/t;", "clearSavedSourceApplicationInfoFromDisk", "", "CALL_APPLICATION_PACKAGE_KEY", "Ljava/lang/String;", "OPENED_BY_APP_LINK_KEY", "SOURCE_APPLICATION_HAS_BEEN_SET_BY_THIS_INTENT", "<init>", "()V", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(o oVar) {
            this();
        }

        @JvmStatic
        public final void clearSavedSourceApplicationInfoFromDisk() {
            SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
            editorEdit.remove(SourceApplicationInfo.CALL_APPLICATION_PACKAGE_KEY);
            editorEdit.remove(SourceApplicationInfo.OPENED_BY_APP_LINK_KEY);
            editorEdit.apply();
        }

        @JvmStatic
        @Nullable
        public final SourceApplicationInfo getStoredSourceApplicatioInfo() {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext());
            o oVar = null;
            if (defaultSharedPreferences.contains(SourceApplicationInfo.CALL_APPLICATION_PACKAGE_KEY)) {
                return new SourceApplicationInfo(defaultSharedPreferences.getString(SourceApplicationInfo.CALL_APPLICATION_PACKAGE_KEY, null), defaultSharedPreferences.getBoolean(SourceApplicationInfo.OPENED_BY_APP_LINK_KEY, false), oVar);
            }
            return null;
        }
    }

    /* compiled from: SourceApplicationInfo.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/facebook/appevents/internal/SourceApplicationInfo$Factory;", "", "()V", "create", "Lcom/facebook/appevents/internal/SourceApplicationInfo;", "activity", "Landroid/app/Activity;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Factory {

        @NotNull
        public static final Factory INSTANCE = new Factory();

        private Factory() {
        }

        @JvmStatic
        @Nullable
        public static final SourceApplicationInfo create(@NotNull Activity activity) {
            String string;
            s.e(activity, "activity");
            ComponentName callingActivity = activity.getCallingActivity();
            o oVar = null;
            if (callingActivity != null) {
                string = callingActivity.getPackageName();
                if (s.a(string, activity.getPackageName())) {
                    return null;
                }
            } else {
                string = "";
            }
            Intent intent = activity.getIntent();
            boolean z2 = false;
            if (intent != null && !intent.getBooleanExtra(SourceApplicationInfo.SOURCE_APPLICATION_HAS_BEEN_SET_BY_THIS_INTENT, false)) {
                intent.putExtra(SourceApplicationInfo.SOURCE_APPLICATION_HAS_BEEN_SET_BY_THIS_INTENT, true);
                Bundle appLinkData = AppLinks.getAppLinkData(intent);
                if (appLinkData != null) {
                    Bundle bundle = appLinkData.getBundle("referer_app_link");
                    if (bundle != null) {
                        string = bundle.getString("package");
                    }
                    z2 = true;
                }
            }
            if (intent != null) {
                intent.putExtra(SourceApplicationInfo.SOURCE_APPLICATION_HAS_BEEN_SET_BY_THIS_INTENT, true);
            }
            return new SourceApplicationInfo(string, z2, oVar);
        }
    }

    private SourceApplicationInfo(String str, boolean z2) {
        this.callingApplicationPackage = str;
        this.isOpenedByAppLink = z2;
    }

    public /* synthetic */ SourceApplicationInfo(String str, boolean z2, o oVar) {
        this(str, z2);
    }

    @JvmStatic
    public static final void clearSavedSourceApplicationInfoFromDisk() {
        INSTANCE.clearSavedSourceApplicationInfoFromDisk();
    }

    @JvmStatic
    @Nullable
    public static final SourceApplicationInfo getStoredSourceApplicatioInfo() {
        return INSTANCE.getStoredSourceApplicatioInfo();
    }

    @Nullable
    public final String getCallingApplicationPackage() {
        return this.callingApplicationPackage;
    }

    /* renamed from: isOpenedByAppLink, reason: from getter */
    public final boolean getIsOpenedByAppLink() {
        return this.isOpenedByAppLink;
    }

    @NotNull
    public String toString() {
        String str = this.isOpenedByAppLink ? "Applink" : "Unclassified";
        if (this.callingApplicationPackage == null) {
            return str;
        }
        return str + '(' + ((Object) this.callingApplicationPackage) + ')';
    }

    public final void writeSourceApplicationInfoToDisk() {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
        editorEdit.putString(CALL_APPLICATION_PACKAGE_KEY, this.callingApplicationPackage);
        editorEdit.putBoolean(OPENED_BY_APP_LINK_KEY, this.isOpenedByAppLink);
        editorEdit.apply();
    }
}
