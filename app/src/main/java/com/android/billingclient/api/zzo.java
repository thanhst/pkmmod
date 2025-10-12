package com.android.billingclient.api;

import android.content.Context;
import android.content.IntentFilter;
import androidx.annotation.Nullable;

/* compiled from: com.android.billingclient:billing@@5.0.0 */
/* loaded from: classes.dex */
final class zzo {
    private final Context zza;
    private final zzn zzb;

    zzo(Context context, zzbe zzbeVar) {
        this.zza = context;
        this.zzb = new zzn(this, null, 0 == true ? 1 : 0);
    }

    @Nullable
    final zzbe zzb() {
        zzn.zza(this.zzb);
        return null;
    }

    @Nullable
    final PurchasesUpdatedListener zzc() {
        return this.zzb.zzb;
    }

    final void zzd() {
        this.zzb.zzd(this.zza);
    }

    final void zze() {
        IntentFilter intentFilter = new IntentFilter("com.android.vending.billing.PURCHASES_UPDATED");
        intentFilter.addAction("com.android.vending.billing.ALTERNATIVE_BILLING");
        this.zzb.zzc(this.zza, intentFilter);
    }

    zzo(Context context, PurchasesUpdatedListener purchasesUpdatedListener, zzc zzcVar) {
        this.zza = context;
        this.zzb = new zzn(this, purchasesUpdatedListener, zzcVar, null);
    }
}
