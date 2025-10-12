package com.facebook.internal.instrument.crashshield;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.VisibleForTesting;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.ExceptionAnalyzer;
import com.facebook.internal.instrument.InstrumentData;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CrashShieldHandler.kt */
@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0004\u001a\u00020\u0002H\u0007J\u001a\u0010\b\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u0001H\u0007J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0001H\u0007J\u0012\u0010\u000b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0007J\b\u0010\f\u001a\u00020\u0002H\u0007J\b\u0010\r\u001a\u00020\u0002H\u0007J\b\u0010\u000e\u001a\u00020\tH\u0007J\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007R8\u0010\u0013\u001a&\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00010\u0001 \u0011*\u0012\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00120\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/facebook/internal/instrument/crashshield/CrashShieldHandler;", "", "Lkotlin/t;", "enable", "disable", "", "e", "o", "handleThrowable", "", "isObjectCrashing", "methodFinished", "reset", "resetCrashingObjects", "isDebug", "scheduleCrashInDebug", "", "kotlin.jvm.PlatformType", "", "crashingObjects", "Ljava/util/Set;", "enabled", "Z", "<init>", "()V", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class CrashShieldHandler {

    @NotNull
    public static final CrashShieldHandler INSTANCE = new CrashShieldHandler();
    private static final Set<Object> crashingObjects = Collections.newSetFromMap(new WeakHashMap());
    private static boolean enabled;

    private CrashShieldHandler() {
    }

    @JvmStatic
    @VisibleForTesting
    public static final void disable() {
        enabled = false;
    }

    @JvmStatic
    public static final void enable() {
        enabled = true;
    }

    @JvmStatic
    public static final void handleThrowable(@Nullable Throwable th, @NotNull Object o2) {
        s.e(o2, "o");
        if (enabled) {
            crashingObjects.add(o2);
            if (FacebookSdk.getAutoLogAppEventsEnabled()) {
                ExceptionAnalyzer.execute(th);
                InstrumentData.Builder builder = InstrumentData.Builder.INSTANCE;
                InstrumentData.Builder.build(th, InstrumentData.Type.CrashShield).save();
            }
            scheduleCrashInDebug(th);
        }
    }

    @JvmStatic
    @VisibleForTesting
    public static final boolean isDebug() {
        return false;
    }

    @JvmStatic
    public static final boolean isObjectCrashing(@NotNull Object o2) {
        s.e(o2, "o");
        return crashingObjects.contains(o2);
    }

    @JvmStatic
    public static final void methodFinished(@Nullable Object obj) {
    }

    @JvmStatic
    public static final void reset() {
        resetCrashingObjects();
    }

    @JvmStatic
    public static final void resetCrashingObjects() {
        crashingObjects.clear();
    }

    @JvmStatic
    @VisibleForTesting
    public static final void scheduleCrashInDebug(@Nullable final Throwable th) {
        if (isDebug()) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.facebook.internal.instrument.crashshield.CrashShieldHandler.scheduleCrashInDebug.1
                @Override // java.lang.Runnable
                public void run() {
                    if (CrashShieldHandler.isObjectCrashing(this)) {
                        return;
                    }
                    try {
                        throw new RuntimeException(th);
                    } catch (Throwable th2) {
                        CrashShieldHandler.handleThrowable(th2, this);
                    }
                }
            });
        }
    }
}
