package com.facebook.login;

import java.util.Arrays;
import kotlin.Metadata;

/* compiled from: LoginBehavior.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B?\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\u0006\u0010\u0007\u001a\u00020\u0003J\u0006\u0010\u0006\u001a\u00020\u0003J\u0006\u0010\b\u001a\u00020\u0003J\u0006\u0010\u0002\u001a\u00020\u0003J\u0006\u0010\t\u001a\u00020\u0003J\u0006\u0010\u0004\u001a\u00020\u0003J\u0006\u0010\u0005\u001a\u00020\u0003R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/facebook/login/LoginBehavior;", "", "allowsGetTokenAuth", "", "allowsKatanaAuth", "allowsWebViewAuth", "allowsDeviceAuth", "allowsCustomTabAuth", "allowsFacebookLiteAuth", "allowsInstagramAppAuth", "(Ljava/lang/String;IZZZZZZZ)V", "NATIVE_WITH_FALLBACK", "NATIVE_ONLY", "KATANA_ONLY", "WEB_ONLY", "WEB_VIEW_ONLY", "DIALOG_ONLY", "DEVICE_AUTH", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public enum LoginBehavior {
    NATIVE_WITH_FALLBACK(true, true, true, false, true, true, true),
    NATIVE_ONLY(true, true, false, false, false, true, true),
    KATANA_ONLY(false, true, false, false, false, false, false),
    WEB_ONLY(false, false, true, false, true, false, false),
    WEB_VIEW_ONLY(false, false, true, false, false, false, false),
    DIALOG_ONLY(false, true, true, false, true, true, true),
    DEVICE_AUTH(false, false, false, true, false, false, false);

    private final boolean allowsCustomTabAuth;
    private final boolean allowsDeviceAuth;
    private final boolean allowsFacebookLiteAuth;
    private final boolean allowsGetTokenAuth;
    private final boolean allowsInstagramAppAuth;
    private final boolean allowsKatanaAuth;
    private final boolean allowsWebViewAuth;

    LoginBehavior(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8) {
        this.allowsGetTokenAuth = z2;
        this.allowsKatanaAuth = z3;
        this.allowsWebViewAuth = z4;
        this.allowsDeviceAuth = z5;
        this.allowsCustomTabAuth = z6;
        this.allowsFacebookLiteAuth = z7;
        this.allowsInstagramAppAuth = z8;
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static LoginBehavior[] valuesCustom() {
        LoginBehavior[] loginBehaviorArrValuesCustom = values();
        return (LoginBehavior[]) Arrays.copyOf(loginBehaviorArrValuesCustom, loginBehaviorArrValuesCustom.length);
    }

    /* renamed from: allowsCustomTabAuth, reason: from getter */
    public final boolean getAllowsCustomTabAuth() {
        return this.allowsCustomTabAuth;
    }

    /* renamed from: allowsDeviceAuth, reason: from getter */
    public final boolean getAllowsDeviceAuth() {
        return this.allowsDeviceAuth;
    }

    /* renamed from: allowsFacebookLiteAuth, reason: from getter */
    public final boolean getAllowsFacebookLiteAuth() {
        return this.allowsFacebookLiteAuth;
    }

    /* renamed from: allowsGetTokenAuth, reason: from getter */
    public final boolean getAllowsGetTokenAuth() {
        return this.allowsGetTokenAuth;
    }

    /* renamed from: allowsInstagramAppAuth, reason: from getter */
    public final boolean getAllowsInstagramAppAuth() {
        return this.allowsInstagramAppAuth;
    }

    /* renamed from: allowsKatanaAuth, reason: from getter */
    public final boolean getAllowsKatanaAuth() {
        return this.allowsKatanaAuth;
    }

    /* renamed from: allowsWebViewAuth, reason: from getter */
    public final boolean getAllowsWebViewAuth() {
        return this.allowsWebViewAuth;
    }
}
