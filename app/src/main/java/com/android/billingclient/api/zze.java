package com.android.billingclient.api;

import androidx.annotation.Nullable;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.DataUtil;
import java.util.Arrays;
import org.json.JSONObject;

/* compiled from: com.android.billingclient:billing@@5.0.0 */
/* loaded from: classes.dex */
public final class zze {
    private final String zza;
    private final String zzb;

    /* synthetic */ zze(JSONObject jSONObject, zzd zzdVar) {
        this.zza = jSONObject.optString(DataUtil.ORDER_COLUMN.ORDER_PRODUCT_ID);
        this.zzb = jSONObject.optString("productType");
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zze)) {
            return false;
        }
        zze zzeVar = (zze) obj;
        return this.zza.equals(zzeVar.zza) && this.zzb.equals(zzeVar.zzb);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb});
    }

    public final String toString() {
        return String.format("{id: %s, type: %s}", this.zza, this.zzb);
    }
}
