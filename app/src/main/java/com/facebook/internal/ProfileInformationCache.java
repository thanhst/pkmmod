package com.facebook.internal;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: ProfileInformationCache.kt */
@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0007R \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/facebook/internal/ProfileInformationCache;", "", "", "accessToken", "Lorg/json/JSONObject;", "getProfileInformation", "key", "value", "Lkotlin/t;", "putProfileInformation", "Ljava/util/concurrent/ConcurrentHashMap;", "infoCache", "Ljava/util/concurrent/ConcurrentHashMap;", "<init>", "()V", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ProfileInformationCache {

    @NotNull
    public static final ProfileInformationCache INSTANCE = new ProfileInformationCache();

    @NotNull
    private static final ConcurrentHashMap<String, JSONObject> infoCache = new ConcurrentHashMap<>();

    private ProfileInformationCache() {
    }

    @JvmStatic
    @Nullable
    public static final JSONObject getProfileInformation(@NotNull String accessToken) {
        kotlin.jvm.internal.s.e(accessToken, "accessToken");
        return infoCache.get(accessToken);
    }

    @JvmStatic
    public static final void putProfileInformation(@NotNull String key, @NotNull JSONObject value) {
        kotlin.jvm.internal.s.e(key, "key");
        kotlin.jvm.internal.s.e(value, "value");
        infoCache.put(key, value);
    }
}
