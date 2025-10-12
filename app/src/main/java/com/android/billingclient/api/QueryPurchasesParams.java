package com.android.billingclient.api;

import androidx.annotation.NonNull;

/* compiled from: com.android.billingclient:billing@@5.0.0 */
@zzj
/* loaded from: classes.dex */
public final class QueryPurchasesParams {
    private final String zza;

    /* compiled from: com.android.billingclient:billing@@5.0.0 */
    @zzj
    public static class Builder {
        private String zza;

        private Builder() {
        }

        /* synthetic */ Builder(zzbp zzbpVar) {
        }

        @NonNull
        @zzj
        public QueryPurchasesParams build() {
            if (this.zza != null) {
                return new QueryPurchasesParams(this, null);
            }
            throw new IllegalArgumentException("Product type must be set");
        }

        @NonNull
        @zzj
        public Builder setProductType(@NonNull String str) {
            this.zza = str;
            return this;
        }
    }

    /* synthetic */ QueryPurchasesParams(Builder builder, zzbq zzbqVar) {
        this.zza = builder.zza;
    }

    @NonNull
    @zzj
    public static Builder newBuilder() {
        return new Builder(null);
    }

    @NonNull
    public final String zza() {
        return this.zza;
    }
}
