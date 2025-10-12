package com.facebook.internal;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: InternalSettings.kt */
@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0007R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\bR\u001a\u0010\u000b\u001a\u00020\n8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/facebook/internal/InternalSettings;", "", "", "getCustomUserAgent", "value", "Lkotlin/t;", "setCustomUserAgent", "UNITY_PREFIX", "Ljava/lang/String;", "customUserAgent", "", "isUnityApp", "()Z", "isUnityApp$annotations", "()V", "<init>", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class InternalSettings {

    @NotNull
    public static final InternalSettings INSTANCE = new InternalSettings();

    @NotNull
    private static final String UNITY_PREFIX = "Unity.";

    @Nullable
    private static volatile String customUserAgent;

    private InternalSettings() {
    }

    @JvmStatic
    @Nullable
    public static final String getCustomUserAgent() {
        return customUserAgent;
    }

    public static final boolean isUnityApp() {
        String str = customUserAgent;
        return kotlin.jvm.internal.s.a(str != null ? Boolean.valueOf(kotlin.text.s.u(str, UNITY_PREFIX, false, 2, null)) : null, Boolean.TRUE);
    }

    @JvmStatic
    public static /* synthetic */ void isUnityApp$annotations() {
    }

    @JvmStatic
    public static final void setCustomUserAgent(@NotNull String value) {
        kotlin.jvm.internal.s.e(value, "value");
        customUserAgent = value;
    }
}
