package com.android.billingclient.api;

import androidx.annotation.NonNull;
import java.util.List;

/* compiled from: com.android.billingclient:billing@@5.0.0 */
@zzj
/* loaded from: classes.dex */
public final class QueryProductDetailsParams {
    private final com.google.android.gms.internal.play_billing.zzu zza;

    /* compiled from: com.android.billingclient:billing@@5.0.0 */
    @zzj
    public static class Builder {
        private com.google.android.gms.internal.play_billing.zzu zza;

        private Builder() {
        }

        /* synthetic */ Builder(zzbj zzbjVar) {
        }

        @NonNull
        @zzj
        public QueryProductDetailsParams build() {
            return new QueryProductDetailsParams(this, null);
        }

        @NonNull
        @zzj
        public Builder setProductList(@NonNull List<Product> list) {
            if (list == null || list.isEmpty()) {
                throw new IllegalArgumentException("Product list cannot be empty.");
            }
            boolean zEquals = false;
            boolean zEquals2 = false;
            for (Product product : list) {
                zEquals |= product.zzb().equals("inapp");
                zEquals2 |= product.zzb().equals("subs");
            }
            if (zEquals && zEquals2) {
                throw new IllegalArgumentException("All products should be of the same product type.");
            }
            this.zza = com.google.android.gms.internal.play_billing.zzu.zzk(list);
            return this;
        }
    }

    /* compiled from: com.android.billingclient:billing@@5.0.0 */
    @zzj
    public static class Product {
        private final String zza;
        private final String zzb;

        /* compiled from: com.android.billingclient:billing@@5.0.0 */
        @zzj
        public static class Builder {
            private String zza;
            private String zzb;

            private Builder() {
            }

            /* synthetic */ Builder(zzbk zzbkVar) {
            }

            @NonNull
            @zzj
            public Product build() {
                if (this.zza == null) {
                    throw new IllegalArgumentException("Product id must be provided.");
                }
                if (this.zzb != null) {
                    return new Product(this, null);
                }
                throw new IllegalArgumentException("Product type must be provided.");
            }

            @NonNull
            @zzj
            public Builder setProductId(@NonNull String str) {
                this.zza = str;
                return this;
            }

            @NonNull
            @zzj
            public Builder setProductType(@NonNull String str) {
                this.zzb = str;
                return this;
            }
        }

        /* synthetic */ Product(Builder builder, zzbl zzblVar) {
            this.zza = builder.zza;
            this.zzb = builder.zzb;
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

        @NonNull
        public final String zzb() {
            return this.zzb;
        }
    }

    /* synthetic */ QueryProductDetailsParams(Builder builder, zzbm zzbmVar) {
        this.zza = builder.zza;
    }

    @NonNull
    @zzj
    public static Builder newBuilder() {
        return new Builder(null);
    }

    public final com.google.android.gms.internal.play_billing.zzu zza() {
        return this.zza;
    }

    @NonNull
    public final String zzb() {
        return ((Product) this.zza.get(0)).zzb();
    }
}
