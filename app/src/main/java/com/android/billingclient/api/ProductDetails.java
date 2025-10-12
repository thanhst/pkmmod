package com.android.billingclient.api;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.share.internal.ShareConstants;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.DataUtil;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.android.billingclient:billing@@5.0.0 */
@zzj
/* loaded from: classes.dex */
public final class ProductDetails {
    private final String zza;
    private final JSONObject zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final String zzg;
    private final String zzh;

    @Nullable
    private final List zzi;

    /* compiled from: com.android.billingclient:billing@@5.0.0 */
    @zzg
    public static final class OneTimePurchaseOfferDetails {
        private final String zza;
        private final long zzb;
        private final String zzc;
        private final String zzd;
        private final String zze;

        OneTimePurchaseOfferDetails(JSONObject jSONObject) {
            this.zza = jSONObject.optString("formattedPrice");
            this.zzb = jSONObject.optLong("priceAmountMicros");
            this.zzc = jSONObject.optString("priceCurrencyCode");
            this.zzd = jSONObject.optString("offerIdToken");
            this.zze = jSONObject.optString("offerId");
            jSONObject.optInt("offerType");
        }

        @NonNull
        @zzg
        public String getFormattedPrice() {
            return this.zza;
        }

        @zzg
        public long getPriceAmountMicros() {
            return this.zzb;
        }

        @NonNull
        @zzg
        public String getPriceCurrencyCode() {
            return this.zzc;
        }

        @NonNull
        public final String zza() {
            return this.zzd;
        }
    }

    /* compiled from: com.android.billingclient:billing@@5.0.0 */
    @zzj
    public static final class PricingPhase {
        private final int billingCycleCount;
        private final String billingPeriod;
        private final String formattedPrice;
        private final long priceAmountMicros;
        private final String priceCurrencyCode;
        private final int recurrenceMode;

        PricingPhase(JSONObject jSONObject) {
            this.billingPeriod = jSONObject.optString("billingPeriod");
            this.priceCurrencyCode = jSONObject.optString("priceCurrencyCode");
            this.formattedPrice = jSONObject.optString("formattedPrice");
            this.priceAmountMicros = jSONObject.optLong("priceAmountMicros");
            this.recurrenceMode = jSONObject.optInt("recurrenceMode");
            this.billingCycleCount = jSONObject.optInt("billingCycleCount");
        }

        public int getBillingCycleCount() {
            return this.billingCycleCount;
        }

        @NonNull
        public String getBillingPeriod() {
            return this.billingPeriod;
        }

        @NonNull
        public String getFormattedPrice() {
            return this.formattedPrice;
        }

        public long getPriceAmountMicros() {
            return this.priceAmountMicros;
        }

        @NonNull
        public String getPriceCurrencyCode() {
            return this.priceCurrencyCode;
        }

        public int getRecurrenceMode() {
            return this.recurrenceMode;
        }
    }

    /* compiled from: com.android.billingclient:billing@@5.0.0 */
    @zzj
    public static class PricingPhases {
        private final List<PricingPhase> pricingPhaseList;

        PricingPhases(JSONArray jSONArray) {
            ArrayList arrayList = new ArrayList();
            if (jSONArray != null) {
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
                    if (jSONObjectOptJSONObject != null) {
                        arrayList.add(new PricingPhase(jSONObjectOptJSONObject));
                    }
                }
            }
            this.pricingPhaseList = arrayList;
        }

        @NonNull
        public List<PricingPhase> getPricingPhaseList() {
            return this.pricingPhaseList;
        }
    }

    /* compiled from: com.android.billingclient:billing@@5.0.0 */
    @zzj
    @Retention(RetentionPolicy.SOURCE)
    public @interface RecurrenceMode {

        @zzj
        public static final int FINITE_RECURRING = 2;

        @zzj
        public static final int INFINITE_RECURRING = 1;

        @zzj
        public static final int NON_RECURRING = 3;
    }

    /* compiled from: com.android.billingclient:billing@@5.0.0 */
    @zzj
    public static final class SubscriptionOfferDetails {

        @Nullable
        private final zzbg installmentPlanDetails;
        private final List<String> offerTags;
        private final String offerToken;
        private final PricingPhases pricingPhases;

        SubscriptionOfferDetails(JSONObject jSONObject) throws JSONException {
            this.offerToken = jSONObject.getString("offerIdToken");
            this.pricingPhases = new PricingPhases(jSONObject.getJSONArray("pricingPhases"));
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("installmentPlanDetails");
            this.installmentPlanDetails = jSONObjectOptJSONObject == null ? null : new zzbg(jSONObjectOptJSONObject);
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("offerTags");
            if (jSONArrayOptJSONArray != null) {
                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    arrayList.add(jSONArrayOptJSONArray.getString(i2));
                }
            }
            this.offerTags = arrayList;
        }

        @Nullable
        public zzbg getInstallmentPlanDetails() {
            return this.installmentPlanDetails;
        }

        @NonNull
        public List<String> getOfferTags() {
            return this.offerTags;
        }

        @NonNull
        public String getOfferToken() {
            return this.offerToken;
        }

        @NonNull
        public PricingPhases getPricingPhases() {
            return this.pricingPhases;
        }
    }

    ProductDetails(String str) throws JSONException {
        this.zza = str;
        JSONObject jSONObject = new JSONObject(str);
        this.zzb = jSONObject;
        String strOptString = jSONObject.optString(DataUtil.ORDER_COLUMN.ORDER_PRODUCT_ID);
        this.zzc = strOptString;
        String strOptString2 = jSONObject.optString(ShareConstants.MEDIA_TYPE);
        this.zzd = strOptString2;
        if (TextUtils.isEmpty(strOptString)) {
            throw new IllegalArgumentException("Product id cannot be empty.");
        }
        if (TextUtils.isEmpty(strOptString2)) {
            throw new IllegalArgumentException("Product type cannot be empty.");
        }
        this.zze = jSONObject.optString(ShareConstants.WEB_DIALOG_PARAM_TITLE);
        this.zzf = jSONObject.optString("name");
        this.zzg = jSONObject.optString("description");
        this.zzh = jSONObject.optString("skuDetailsToken");
        if (strOptString2.equals("inapp")) {
            this.zzi = null;
            return;
        }
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("subscriptionOfferDetails");
        if (jSONArrayOptJSONArray != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                arrayList.add(new SubscriptionOfferDetails(jSONArrayOptJSONArray.getJSONObject(i2)));
            }
        }
        this.zzi = arrayList;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ProductDetails) {
            return TextUtils.equals(this.zza, ((ProductDetails) obj).zza);
        }
        return false;
    }

    @NonNull
    @zzj
    public String getDescription() {
        return this.zzg;
    }

    @NonNull
    @zzj
    public String getName() {
        return this.zzf;
    }

    @Nullable
    @zzg
    public OneTimePurchaseOfferDetails getOneTimePurchaseOfferDetails() {
        JSONObject jSONObjectOptJSONObject = this.zzb.optJSONObject("oneTimePurchaseOfferDetails");
        if (jSONObjectOptJSONObject != null) {
            return new OneTimePurchaseOfferDetails(jSONObjectOptJSONObject);
        }
        return null;
    }

    @NonNull
    @zzj
    public String getProductId() {
        return this.zzc;
    }

    @NonNull
    @zzj
    public String getProductType() {
        return this.zzd;
    }

    @Nullable
    @zzj
    public List<SubscriptionOfferDetails> getSubscriptionOfferDetails() {
        return this.zzi;
    }

    @NonNull
    @zzj
    public String getTitle() {
        return this.zze;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    @NonNull
    public final String toString() {
        return "ProductDetails{jsonString='" + this.zza + "', parsedJson=" + this.zzb.toString() + ", productId='" + this.zzc + "', productType='" + this.zzd + "', title='" + this.zze + "', productDetailsToken='" + this.zzh + "', subscriptionOfferDetails=" + String.valueOf(this.zzi) + "}";
    }

    @NonNull
    public final String zza() {
        return this.zzb.optString(DataUtil.LEVEL_COLUMN.PACKAGENAME);
    }

    final String zzb() {
        return this.zzh;
    }
}
