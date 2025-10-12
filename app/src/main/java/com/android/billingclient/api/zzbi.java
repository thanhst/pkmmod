package com.android.billingclient.api;

import android.os.Bundle;
import com.android.billingclient.api.BillingResult;
import java.util.ArrayList;

/* compiled from: com.android.billingclient:billing@@5.0.0 */
/* loaded from: classes.dex */
final class zzbi {
    static BillingResult zza(Bundle bundle, String str, String str2) {
        BillingResult billingResult = zzbb.zzj;
        if (bundle == null) {
            com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", String.format("%s got null owned items list", str2));
            return billingResult;
        }
        int iZzb = com.google.android.gms.internal.play_billing.zzb.zzb(bundle, "BillingClient");
        String strZzk = com.google.android.gms.internal.play_billing.zzb.zzk(bundle, "BillingClient");
        BillingResult.Builder builderNewBuilder = BillingResult.newBuilder();
        builderNewBuilder.setResponseCode(iZzb);
        builderNewBuilder.setDebugMessage(strZzk);
        BillingResult billingResultBuild = builderNewBuilder.build();
        if (iZzb != 0) {
            com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", String.format("%s failed. Response code: %s", str2, Integer.valueOf(iZzb)));
            return billingResultBuild;
        }
        if (!bundle.containsKey("INAPP_PURCHASE_ITEM_LIST") || !bundle.containsKey("INAPP_PURCHASE_DATA_LIST") || !bundle.containsKey("INAPP_DATA_SIGNATURE_LIST")) {
            com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", String.format("Bundle returned from %s doesn't contain required fields.", str2));
            return billingResult;
        }
        ArrayList<String> stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
        ArrayList<String> stringArrayList2 = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
        ArrayList<String> stringArrayList3 = bundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
        if (stringArrayList == null) {
            com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", String.format("Bundle returned from %s contains null SKUs list.", str2));
            return billingResult;
        }
        if (stringArrayList2 == null) {
            com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", String.format("Bundle returned from %s contains null purchases list.", str2));
            return billingResult;
        }
        if (stringArrayList3 != null) {
            return zzbb.zzl;
        }
        com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", String.format("Bundle returned from %s contains null signatures list.", str2));
        return billingResult;
    }
}
