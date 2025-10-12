package com.facebook.internal.gatekeeper;

import com.facebook.FacebookSdk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: GateKeeperRuntimeCache.kt */
@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\"\u0010\t\u001a\u00020\b2\f\b\u0002\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u001c\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\f\b\u0002\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003J$\u0010\u000e\u001a\u00020\f2\f\b\u0002\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fJ$\u0010\u0010\u001a\u00020\b2\f\b\u0002\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\fJ\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00062\f\b\u0002\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u000b\u001a\u00020\u0002J\u001c\u0010\u0013\u001a\u00020\b2\f\b\u0002\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0012\u001a\u00020\u0006J\u0014\u0010\u0014\u001a\u00020\b2\f\b\u0002\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003R0\u0010\u0016\u001a\u001e\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00150\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/facebook/internal/gatekeeper/GateKeeperRuntimeCache;", "", "", "Lcom/facebook/internal/gatekeeper/AppID;", "appId", "", "Lcom/facebook/internal/gatekeeper/GateKeeper;", "gateKeeperList", "Lkotlin/t;", "setGateKeepers", "dumpGateKeepers", "name", "", "defaultValue", "getGateKeeperValue", "value", "setGateKeeperValue", "getGateKeeper", "gateKeeper", "setGateKeeper", "resetCache", "Ljava/util/concurrent/ConcurrentHashMap;", "gateKeepers", "Ljava/util/concurrent/ConcurrentHashMap;", "<init>", "()V", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class GateKeeperRuntimeCache {

    @NotNull
    private final ConcurrentHashMap<String, ConcurrentHashMap<String, GateKeeper>> gateKeepers = new ConcurrentHashMap<>();

    public static /* synthetic */ List dumpGateKeepers$default(GateKeeperRuntimeCache gateKeeperRuntimeCache, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = FacebookSdk.getApplicationId();
        }
        return gateKeeperRuntimeCache.dumpGateKeepers(str);
    }

    public static /* synthetic */ GateKeeper getGateKeeper$default(GateKeeperRuntimeCache gateKeeperRuntimeCache, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = FacebookSdk.getApplicationId();
        }
        return gateKeeperRuntimeCache.getGateKeeper(str, str2);
    }

    public static /* synthetic */ boolean getGateKeeperValue$default(GateKeeperRuntimeCache gateKeeperRuntimeCache, String str, String str2, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = FacebookSdk.getApplicationId();
        }
        return gateKeeperRuntimeCache.getGateKeeperValue(str, str2, z2);
    }

    public static /* synthetic */ void resetCache$default(GateKeeperRuntimeCache gateKeeperRuntimeCache, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = FacebookSdk.getApplicationId();
        }
        gateKeeperRuntimeCache.resetCache(str);
    }

    public static /* synthetic */ void setGateKeeper$default(GateKeeperRuntimeCache gateKeeperRuntimeCache, String str, GateKeeper gateKeeper, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = FacebookSdk.getApplicationId();
        }
        gateKeeperRuntimeCache.setGateKeeper(str, gateKeeper);
    }

    public static /* synthetic */ void setGateKeeperValue$default(GateKeeperRuntimeCache gateKeeperRuntimeCache, String str, String str2, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = FacebookSdk.getApplicationId();
        }
        gateKeeperRuntimeCache.setGateKeeperValue(str, str2, z2);
    }

    public static /* synthetic */ void setGateKeepers$default(GateKeeperRuntimeCache gateKeeperRuntimeCache, String str, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = FacebookSdk.getApplicationId();
        }
        gateKeeperRuntimeCache.setGateKeepers(str, list);
    }

    @Nullable
    public final List<GateKeeper> dumpGateKeepers(@NotNull String appId) {
        s.e(appId, "appId");
        ConcurrentHashMap<String, GateKeeper> concurrentHashMap = this.gateKeepers.get(appId);
        if (concurrentHashMap == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(concurrentHashMap.size());
        Iterator<Map.Entry<String, GateKeeper>> it = concurrentHashMap.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getValue());
        }
        return arrayList;
    }

    @Nullable
    public final GateKeeper getGateKeeper(@NotNull String appId, @NotNull String name) {
        s.e(appId, "appId");
        s.e(name, "name");
        ConcurrentHashMap<String, GateKeeper> concurrentHashMap = this.gateKeepers.get(appId);
        if (concurrentHashMap == null) {
            return null;
        }
        return concurrentHashMap.get(name);
    }

    public final boolean getGateKeeperValue(@NotNull String appId, @NotNull String name, boolean defaultValue) {
        s.e(appId, "appId");
        s.e(name, "name");
        GateKeeper gateKeeper = getGateKeeper(appId, name);
        return gateKeeper == null ? defaultValue : gateKeeper.getValue();
    }

    public final void resetCache(@NotNull String appId) {
        s.e(appId, "appId");
        this.gateKeepers.remove(appId);
    }

    public final void setGateKeeper(@NotNull String appId, @NotNull GateKeeper gateKeeper) {
        s.e(appId, "appId");
        s.e(gateKeeper, "gateKeeper");
        if (!this.gateKeepers.containsKey(appId)) {
            this.gateKeepers.put(appId, new ConcurrentHashMap<>());
        }
        ConcurrentHashMap<String, GateKeeper> concurrentHashMap = this.gateKeepers.get(appId);
        if (concurrentHashMap == null) {
            return;
        }
        concurrentHashMap.put(gateKeeper.getName(), gateKeeper);
    }

    public final void setGateKeeperValue(@NotNull String appId, @NotNull String name, boolean z2) {
        s.e(appId, "appId");
        s.e(name, "name");
        setGateKeeper(appId, new GateKeeper(name, z2));
    }

    public final void setGateKeepers(@NotNull String appId, @NotNull List<GateKeeper> gateKeeperList) {
        s.e(appId, "appId");
        s.e(gateKeeperList, "gateKeeperList");
        ConcurrentHashMap<String, GateKeeper> concurrentHashMap = new ConcurrentHashMap<>();
        for (GateKeeper gateKeeper : gateKeeperList) {
            concurrentHashMap.put(gateKeeper.getName(), gateKeeper);
        }
        this.gateKeepers.put(appId, concurrentHashMap);
    }
}
