package com.android.billingclient.api;

import androidx.annotation.NonNull;
import org.json.JSONException;

/* compiled from: com.android.billingclient:billing@@5.0.0 */
@zzi
/* loaded from: classes.dex */
public class PriceChangeFlowParams {
    private SkuDetails skuDetails;

    /* compiled from: com.android.billingclient:billing@@5.0.0 */
    @zzi
    public static class Builder {
        private SkuDetails skuDetails;

        private Builder setSkuDetails(String str) {
            try {
                this.skuDetails = new SkuDetails(str);
                return this;
            } catch (JSONException e2) {
                throw new IllegalArgumentException("Incorrect skuDetails JSON object!", e2);
            }
        }

        @NonNull
        public PriceChangeFlowParams build() {
            SkuDetails skuDetails = this.skuDetails;
            if (skuDetails == null) {
                throw new IllegalArgumentException("SkuDetails must be set");
            }
            PriceChangeFlowParams priceChangeFlowParams = new PriceChangeFlowParams();
            priceChangeFlowParams.skuDetails = skuDetails;
            return priceChangeFlowParams;
        }

        @NonNull
        public Builder setSkuDetails(@NonNull SkuDetails skuDetails) {
            this.skuDetails = skuDetails;
            return this;
        }
    }

    @NonNull
    public static Builder newBuilder() {
        return new Builder();
    }

    @NonNull
    public SkuDetails getSkuDetails() {
        return this.skuDetails;
    }
}
