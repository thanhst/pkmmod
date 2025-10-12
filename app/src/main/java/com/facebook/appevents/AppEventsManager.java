package com.facebook.appevents;

import androidx.annotation.RestrictTo;
import com.facebook.appevents.AppEventsManager;
import com.facebook.appevents.aam.MetadataIndexer;
import com.facebook.appevents.cloudbridge.AppEventsCAPIManager;
import com.facebook.appevents.eventdeactivation.EventDeactivationManager;
import com.facebook.appevents.iap.InAppPurchaseManager;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AppEventsManager.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\u0006"}, d2 = {"Lcom/facebook/appevents/AppEventsManager;", "", "Lkotlin/t;", "start", "<init>", "()V", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class AppEventsManager {

    @NotNull
    public static final AppEventsManager INSTANCE = new AppEventsManager();

    /* compiled from: AppEventsManager.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016¨\u0006\u0007"}, d2 = {"com/facebook/appevents/AppEventsManager$start$1", "Lcom/facebook/internal/FetchedAppSettingsManager$FetchedAppSettingsCallback;", "Lcom/facebook/internal/FetchedAppSettings;", "fetchedAppSettings", "Lkotlin/t;", "onSuccess", "onError", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    /* renamed from: com.facebook.appevents.AppEventsManager$start$1, reason: invalid class name */
    public static final class AnonymousClass1 implements FetchedAppSettingsManager.FetchedAppSettingsCallback {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: onSuccess$lambda-0, reason: not valid java name */
        public static final void m36onSuccess$lambda0(boolean z2) {
            if (z2) {
                MetadataIndexer.enable();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: onSuccess$lambda-1, reason: not valid java name */
        public static final void m37onSuccess$lambda1(boolean z2) {
            if (z2) {
                RestrictiveDataManager.enable();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: onSuccess$lambda-2, reason: not valid java name */
        public static final void m38onSuccess$lambda2(boolean z2) {
            if (z2) {
                ModelManager.enable();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: onSuccess$lambda-3, reason: not valid java name */
        public static final void m39onSuccess$lambda3(boolean z2) {
            if (z2) {
                EventDeactivationManager.enable();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: onSuccess$lambda-4, reason: not valid java name */
        public static final void m40onSuccess$lambda4(boolean z2) {
            if (z2) {
                InAppPurchaseManager.enableAutoLogging();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: onSuccess$lambda-5, reason: not valid java name */
        public static final void m41onSuccess$lambda5(boolean z2) {
            if (z2) {
                AppEventsCAPIManager.enable();
            }
        }

        @Override // com.facebook.internal.FetchedAppSettingsManager.FetchedAppSettingsCallback
        public void onError() {
        }

        @Override // com.facebook.internal.FetchedAppSettingsManager.FetchedAppSettingsCallback
        public void onSuccess(@Nullable FetchedAppSettings fetchedAppSettings) {
            FeatureManager featureManager = FeatureManager.INSTANCE;
            FeatureManager.checkFeature(FeatureManager.Feature.AAM, new FeatureManager.Callback() { // from class: com.facebook.appevents.k
                @Override // com.facebook.internal.FeatureManager.Callback
                public final void onCompleted(boolean z2) {
                    AppEventsManager.AnonymousClass1.m36onSuccess$lambda0(z2);
                }
            });
            FeatureManager.checkFeature(FeatureManager.Feature.RestrictiveDataFiltering, new FeatureManager.Callback() { // from class: com.facebook.appevents.l
                @Override // com.facebook.internal.FeatureManager.Callback
                public final void onCompleted(boolean z2) {
                    AppEventsManager.AnonymousClass1.m37onSuccess$lambda1(z2);
                }
            });
            FeatureManager.checkFeature(FeatureManager.Feature.PrivacyProtection, new FeatureManager.Callback() { // from class: com.facebook.appevents.m
                @Override // com.facebook.internal.FeatureManager.Callback
                public final void onCompleted(boolean z2) {
                    AppEventsManager.AnonymousClass1.m38onSuccess$lambda2(z2);
                }
            });
            FeatureManager.checkFeature(FeatureManager.Feature.EventDeactivation, new FeatureManager.Callback() { // from class: com.facebook.appevents.n
                @Override // com.facebook.internal.FeatureManager.Callback
                public final void onCompleted(boolean z2) {
                    AppEventsManager.AnonymousClass1.m39onSuccess$lambda3(z2);
                }
            });
            FeatureManager.checkFeature(FeatureManager.Feature.IapLogging, new FeatureManager.Callback() { // from class: com.facebook.appevents.o
                @Override // com.facebook.internal.FeatureManager.Callback
                public final void onCompleted(boolean z2) {
                    AppEventsManager.AnonymousClass1.m40onSuccess$lambda4(z2);
                }
            });
            FeatureManager.checkFeature(FeatureManager.Feature.CloudBridge, new FeatureManager.Callback() { // from class: com.facebook.appevents.p
                @Override // com.facebook.internal.FeatureManager.Callback
                public final void onCompleted(boolean z2) {
                    AppEventsManager.AnonymousClass1.m41onSuccess$lambda5(z2);
                }
            });
        }
    }

    private AppEventsManager() {
    }

    @JvmStatic
    public static final void start() {
        if (CrashShieldHandler.isObjectCrashing(AppEventsManager.class)) {
            return;
        }
        try {
            FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
            FetchedAppSettingsManager.getAppSettingsAsync(new AnonymousClass1());
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventsManager.class);
        }
    }
}
