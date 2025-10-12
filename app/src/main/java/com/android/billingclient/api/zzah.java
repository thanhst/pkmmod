package com.android.billingclient.api;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.android.billingclient.api.BillingResult;

/* compiled from: com.android.billingclient:billing@@5.0.0 */
/* loaded from: classes.dex */
final class zzah extends ResultReceiver {
    final /* synthetic */ PriceChangeConfirmationListener zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzah(BillingClientImpl billingClientImpl, Handler handler, PriceChangeConfirmationListener priceChangeConfirmationListener) {
        super(handler);
        this.zza = priceChangeConfirmationListener;
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i2, Bundle bundle) {
        BillingResult.Builder builderNewBuilder = BillingResult.newBuilder();
        builderNewBuilder.setResponseCode(i2);
        builderNewBuilder.setDebugMessage(com.google.android.gms.internal.play_billing.zzb.zzk(bundle, "BillingClient"));
        this.zza.onPriceChangeConfirmationResult(builderNewBuilder.build());
    }
}
