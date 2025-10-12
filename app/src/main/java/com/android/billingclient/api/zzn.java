package com.android.billingclient.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.android.billingclient:billing@@5.0.0 */
/* loaded from: classes.dex */
final class zzn extends BroadcastReceiver {
    final /* synthetic */ zzo zza;
    private final PurchasesUpdatedListener zzb;
    private final zzbe zzc;
    private final zzc zzd;
    private boolean zze;

    /* synthetic */ zzn(zzo zzoVar, zzbe zzbeVar, zzm zzmVar) {
        this.zza = zzoVar;
        this.zzb = null;
        this.zzd = null;
        this.zzc = null;
    }

    static /* bridge */ /* synthetic */ zzbe zza(zzn zznVar) {
        zzbe zzbeVar = zznVar.zzc;
        return null;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        BillingResult billingResultZzi = com.google.android.gms.internal.play_billing.zzb.zzi(intent, "BillingBroadcastManager");
        String action = intent.getAction();
        if (action.equals("com.android.vending.billing.PURCHASES_UPDATED")) {
            this.zzb.onPurchasesUpdated(billingResultZzi, com.google.android.gms.internal.play_billing.zzb.zzm(intent.getExtras()));
            return;
        }
        if (action.equals("com.android.vending.billing.ALTERNATIVE_BILLING")) {
            Bundle extras = intent.getExtras();
            if (billingResultZzi.getResponseCode() != 0) {
                this.zzb.onPurchasesUpdated(billingResultZzi, com.google.android.gms.internal.play_billing.zzu.zzl());
                return;
            }
            if (this.zzd == null) {
                com.google.android.gms.internal.play_billing.zzb.zzo("BillingBroadcastManager", "AlternativeBillingListener is null.");
                this.zzb.onPurchasesUpdated(zzbb.zzj, com.google.android.gms.internal.play_billing.zzu.zzl());
                return;
            }
            if (extras == null) {
                com.google.android.gms.internal.play_billing.zzb.zzo("BillingBroadcastManager", "Bundle is null.");
                this.zzb.onPurchasesUpdated(zzbb.zzj, com.google.android.gms.internal.play_billing.zzu.zzl());
                return;
            }
            String string = extras.getString("ALTERNATIVE_BILLING_USER_CHOICE_DATA");
            if (string == null) {
                com.google.android.gms.internal.play_billing.zzb.zzo("BillingBroadcastManager", "Couldn't find alternative billing user choice data in bundle.");
                this.zzb.onPurchasesUpdated(zzbb.zzj, com.google.android.gms.internal.play_billing.zzu.zzl());
                return;
            }
            try {
                JSONArray jSONArrayOptJSONArray = new JSONObject(string).optJSONArray("products");
                ArrayList arrayList = new ArrayList();
                if (jSONArrayOptJSONArray != null) {
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
                        if (jSONObjectOptJSONObject != null) {
                            arrayList.add(new zze(jSONObjectOptJSONObject, null));
                        }
                    }
                }
                this.zzd.zza();
            } catch (JSONException unused) {
                com.google.android.gms.internal.play_billing.zzb.zzo("BillingBroadcastManager", String.format("Error when parsing invalid alternative choice data: [%s]", string));
                this.zzb.onPurchasesUpdated(zzbb.zzj, com.google.android.gms.internal.play_billing.zzu.zzl());
            }
        }
    }

    public final void zzc(Context context, IntentFilter intentFilter) {
        if (this.zze) {
            return;
        }
        context.registerReceiver(this.zza.zzb, intentFilter);
        this.zze = true;
    }

    public final void zzd(Context context) {
        if (!this.zze) {
            com.google.android.gms.internal.play_billing.zzb.zzo("BillingBroadcastManager", "Receiver is not registered.");
        } else {
            context.unregisterReceiver(this.zza.zzb);
            this.zze = false;
        }
    }

    /* synthetic */ zzn(zzo zzoVar, PurchasesUpdatedListener purchasesUpdatedListener, zzc zzcVar, zzm zzmVar) {
        this.zza = zzoVar;
        this.zzb = purchasesUpdatedListener;
        this.zzd = zzcVar;
        this.zzc = null;
    }
}
