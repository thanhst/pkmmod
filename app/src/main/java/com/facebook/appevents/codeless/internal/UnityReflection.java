package com.facebook.appevents.codeless.internal;

import android.util.Log;
import com.facebook.share.internal.ShareConstants;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UnityReflection.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\f\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0002J&\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0007J\b\u0010\n\u001a\u00020\bH\u0007J\u0012\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0007R\u001c\u0010\u000e\u001a\n \r*\u0004\u0018\u00010\u00040\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u000fR\u001a\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/facebook/appevents/codeless/internal/UnityReflection;", "", "Ljava/lang/Class;", "getUnityPlayerClass", "", "unityObject", "unityMethod", ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "Lkotlin/t;", "sendMessage", "captureViewHierarchy", "eventMapping", "sendEventMapping", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "UNITY_PLAYER_CLASS", "UNITY_SEND_MESSAGE_METHOD", "FB_UNITY_GAME_OBJECT", "CAPTURE_VIEW_HIERARCHY_METHOD", "EVENT_MAPPING_METHOD", "unityPlayer", "Ljava/lang/Class;", "<init>", "()V", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class UnityReflection {

    @NotNull
    private static final String CAPTURE_VIEW_HIERARCHY_METHOD = "CaptureViewHierarchy";

    @NotNull
    private static final String EVENT_MAPPING_METHOD = "OnReceiveMapping";

    @NotNull
    private static final String FB_UNITY_GAME_OBJECT = "UnityFacebookSDKPlugin";

    @NotNull
    public static final UnityReflection INSTANCE = new UnityReflection();
    private static final String TAG = UnityReflection.class.getCanonicalName();

    @NotNull
    private static final String UNITY_PLAYER_CLASS = "com.unity3d.player.UnityPlayer";

    @NotNull
    private static final String UNITY_SEND_MESSAGE_METHOD = "UnitySendMessage";
    private static Class<?> unityPlayer;

    private UnityReflection() {
    }

    @JvmStatic
    public static final void captureViewHierarchy() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        sendMessage(FB_UNITY_GAME_OBJECT, CAPTURE_VIEW_HIERARCHY_METHOD, "");
    }

    private final Class<?> getUnityPlayerClass() throws ClassNotFoundException {
        Class<?> cls = Class.forName(UNITY_PLAYER_CLASS);
        s.d(cls, "forName(UNITY_PLAYER_CLASS)");
        return cls;
    }

    @JvmStatic
    public static final void sendEventMapping(@Nullable String str) {
        sendMessage(FB_UNITY_GAME_OBJECT, EVENT_MAPPING_METHOD, str);
    }

    @JvmStatic
    public static final void sendMessage(@Nullable String str, @Nullable String str2, @Nullable String str3) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            if (unityPlayer == null) {
                unityPlayer = INSTANCE.getUnityPlayerClass();
            }
            Class<?> cls = unityPlayer;
            if (cls == null) {
                s.t("unityPlayer");
                throw null;
            }
            Method method = cls.getMethod(UNITY_SEND_MESSAGE_METHOD, String.class, String.class, String.class);
            Class<?> cls2 = unityPlayer;
            if (cls2 != null) {
                method.invoke(cls2, str, str2, str3);
            } else {
                s.t("unityPlayer");
                throw null;
            }
        } catch (Exception e2) {
            Log.e(TAG, "Failed to send message to Unity", e2);
        }
    }
}
