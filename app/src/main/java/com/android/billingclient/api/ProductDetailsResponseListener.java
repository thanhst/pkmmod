package com.android.billingclient.api;

import androidx.annotation.NonNull;
import java.util.List;

/* compiled from: com.android.billingclient:billing@@5.0.0 */
@zzj
/* loaded from: classes.dex */
public interface ProductDetailsResponseListener {
    @zzj
    void onProductDetailsResponse(@NonNull BillingResult billingResult, @NonNull List<ProductDetails> list);
}
