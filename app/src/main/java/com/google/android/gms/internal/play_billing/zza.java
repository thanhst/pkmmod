package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@5.0.0 */
/* loaded from: classes.dex */
enum zza {
    RESPONSE_CODE_UNSPECIFIED(-999),
    SERVICE_TIMEOUT(-3),
    FEATURE_NOT_SUPPORTED(-2),
    SERVICE_DISCONNECTED(-1),
    OK(0),
    USER_CANCELED(1),
    SERVICE_UNAVAILABLE(2),
    BILLING_UNAVAILABLE(3),
    ITEM_UNAVAILABLE(4),
    DEVELOPER_ERROR(5),
    ERROR(6),
    ITEM_ALREADY_OWNED(7),
    ITEM_NOT_OWNED(8),
    EXPIRED_OFFER_TOKEN(11);

    private static final zzx zzo;
    private final int zzq;

    static {
        zzw zzwVar = new zzw();
        for (zza zzaVar : values()) {
            zzwVar.zza(Integer.valueOf(zzaVar.zzq), zzaVar);
        }
        zzo = zzwVar.zzb();
    }

    zza(int i2) {
        this.zzq = i2;
    }

    static zza zza(int i2) {
        zzx zzxVar = zzo;
        Integer numValueOf = Integer.valueOf(i2);
        return !zzxVar.containsKey(numValueOf) ? RESPONSE_CODE_UNSPECIFIED : (zza) zzxVar.get(numValueOf);
    }
}
