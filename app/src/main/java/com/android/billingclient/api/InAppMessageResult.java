package com.android.billingclient.api;

import androidx.annotation.Nullable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: com.android.billingclient:billing@@5.0.0 */
@zzf
/* loaded from: classes.dex */
public final class InAppMessageResult {

    @Nullable
    private final String mPurchaseToken;
    private final int mResponseCode;

    /* compiled from: com.android.billingclient:billing@@5.0.0 */
    @zzf
    @Retention(RetentionPolicy.SOURCE)
    public @interface InAppMessageResponseCode {
        public static final int NO_ACTION_NEEDED = 0;
        public static final int SUBSCRIPTION_STATUS_UPDATED = 1;
    }

    public InAppMessageResult(int i2, @Nullable String str) {
        this.mResponseCode = i2;
        this.mPurchaseToken = str;
    }

    @Nullable
    public String getPurchaseToken() {
        return this.mPurchaseToken;
    }

    public int getResponseCode() {
        return this.mResponseCode;
    }
}
