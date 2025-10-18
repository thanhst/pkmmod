package com.facebook.login;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.AccessToken;
import com.facebook.AuthenticationToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookActivity;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphResponse;
import com.facebook.LoginStatusCallback;
import com.facebook.Profile;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CustomTabUtils;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.PlatformServiceClient;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.share.internal.ShareConstants;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import d.a_d;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.r0;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.s;
import kotlin.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LoginManager.kt */
@Metadata(bv = {}, d1 = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0016\u0018\u0000 ~2\u00020\u0001:\n\u007f\u0080\u0001~\u0081\u0001\u0082\u0001\u0083\u0001B\u0007¢\u0006\u0004\b|\u0010}J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001e\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J \u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0018\u0010\u0018\u001a\u00020\u00062\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0002J\u0018\u0010\u0019\u001a\u00020\u00062\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0002J\u0018\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\bH\u0002J\u001c\u0010!\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010 \u001a\u0004\u0018\u00010\bH\u0002JL\u0010*\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010#\u001a\u00020\"2\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010$2\b\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010)\u001a\u00020(2\b\u0010\u001c\u001a\u0004\u0018\u00010\bH\u0002J\u0018\u0010+\u001a\u00020(2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\bH\u0002J\u0010\u0010.\u001a\u00020(2\u0006\u0010-\u001a\u00020,H\u0002JH\u00109\u001a\u00020\u00062\b\u00100\u001a\u0004\u0018\u00010/2\b\u00102\u001a\u0004\u0018\u0001012\b\u00103\u001a\u0004\u0018\u00010\b2\b\u0010'\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u00020(2\u000e\u00108\u001a\n\u0012\u0004\u0012\u000207\u0018\u000106H\u0002J \u0010>\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010;\u001a\u00020:2\u0006\u0010=\u001a\u00020<H\u0002J\u0010\u0010@\u001a\u00020\u00062\u0006\u0010?\u001a\u00020(H\u0002J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010B\u001a\u00020A2\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020C2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020C2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020D2\u0006\u0010\u0005\u001a\u00020\u0004J\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u0004J \u0010E\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u000e\u00108\u001a\n\u0012\u0004\u0012\u000207\u0018\u000106J\u0010\u0010F\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J,\u0010J\u001a\u00020(2\u0006\u0010H\u001a\u00020G2\b\u0010I\u001a\u0004\u0018\u00010,2\u0010\b\u0002\u00108\u001a\n\u0012\u0004\u0012\u000207\u0018\u000106H\u0017J\u000e\u0010M\u001a\u00020\u00002\u0006\u0010L\u001a\u00020KJ\u000e\u0010P\u001a\u00020\u00002\u0006\u0010O\u001a\u00020NJ\u000e\u0010S\u001a\u00020\u00002\u0006\u0010R\u001a\u00020QJ\u000e\u0010U\u001a\u00020\u00002\u0006\u0010T\u001a\u00020\u000bJ\u0010\u0010W\u001a\u00020\u00002\b\u0010V\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010Y\u001a\u00020\u00002\u0006\u0010X\u001a\u00020(J\u000e\u0010[\u001a\u00020\u00002\u0006\u0010Z\u001a\u00020(J\u000e\u0010]\u001a\u00020\u00002\u0006\u0010\\\u001a\u00020(J\b\u0010^\u001a\u00020\u0006H\u0016J\u0016\u0010_\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010;\u001a\u00020:J\u001e\u0010_\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020<2\u0006\u0010;\u001a\u00020:J\u001e\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020C2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007J$\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020C2\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u001c\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020D2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u001e\u0010\r\u001a\u00020\u00062\u0006\u0010B\u001a\u00020A2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nJ$\u0010\r\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u0016\u0010`\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020C2\u0006\u0010\u000f\u001a\u00020\u000eJ\u0016\u0010\u0010\u001a\u00020\u00062\u0006\u0010B\u001a\u00020A2\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0011\u001a\u00020\u00062\u0006\u0010B\u001a\u00020AJ\u000e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020CJ\u001e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020C2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007J$\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020C2\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u001c\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020D2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u001e\u0010\u0012\u001a\u00020\u00062\u0006\u0010B\u001a\u00020A2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nJ$\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u001e\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020C2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nJ(\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020C2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\b\u0010a\u001a\u0004\u0018\u00010\u000bJ\u001e\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020D2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nJ(\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020D2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\b\u0010a\u001a\u0004\u0018\u00010\u000bJ\u001e\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nJ(\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\b\u0010a\u001a\u0004\u0018\u00010\u000bJ\u001e\u0010\u0017\u001a\u00020\u00062\u0006\u0010B\u001a\u00020A2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nJ\u0016\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eJ\u0016\u0010\u0017\u001a\u00020\u00062\u0006\u0010B\u001a\u00020A2\u0006\u0010\u000f\u001a\u00020\u000eJ(\u0010\u0017\u001a\u00020\u00062\u0006\u0010B\u001a\u00020A2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\b\u0010a\u001a\u0004\u0018\u00010\u000bJ.\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\u0010a\u001a\u0004\u0018\u00010\u000bJ$\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ$\u0010c\u001a\u00060bR\u00020\u00002\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010a\u001a\u0004\u0018\u00010\u000bH\u0007J\u0010\u0010d\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0014J\u0018\u0010e\u001a\u00020\b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0014J\b\u0010f\u001a\u00020\bH\u0014J\u0010\u0010g\u001a\u00020,2\u0006\u0010\u001c\u001a\u00020\bH\u0014R$\u0010L\u001a\u00020K2\u0006\u0010h\u001a\u00020K8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bL\u0010i\u001a\u0004\bj\u0010kR$\u0010R\u001a\u00020Q2\u0006\u0010h\u001a\u00020Q8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bR\u0010l\u001a\u0004\bm\u0010nR\u0014\u0010p\u001a\u00020o8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bp\u0010qR$\u0010T\u001a\u00020\u000b2\u0006\u0010h\u001a\u00020\u000b8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bT\u0010r\u001a\u0004\bs\u0010tR\u0018\u0010V\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010rR\u0016\u0010X\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010uR$\u0010v\u001a\u00020N2\u0006\u0010h\u001a\u00020N8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bv\u0010w\u001a\u0004\bx\u0010yR$\u0010Z\u001a\u00020(2\u0006\u0010h\u001a\u00020(8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bZ\u0010u\u001a\u0004\bZ\u0010zR$\u0010\\\u001a\u00020(2\u0006\u0010h\u001a\u00020(8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\\\u0010u\u001a\u0004\b{\u0010zR\u0014\u0010?\u001a\u00020(8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b?\u0010z¨\u0006\u0084\u0001"}, d2 = {"Lcom/facebook/login/LoginManager;", "", "Lcom/facebook/internal/FragmentWrapper;", "fragment", "Lcom/facebook/GraphResponse;", "response", "Lkotlin/t;", "resolveError", "Lcom/facebook/login/LoginClient$Request;", "createLoginRequestFromResponse", "", "", "permissions", "logInWithReadPermissions", "Lcom/facebook/login/LoginConfiguration;", "loginConfig", "loginWithConfiguration", "reauthorizeDataAccess", "logInWithPublishPermissions", "Landroidx/activity/result/c;", "activityResultRegistryOwner", "Lcom/facebook/CallbackManager;", "callbackManager", "logIn", "validateReadPermissions", "validatePublishPermissions", "Lcom/facebook/login/StartActivityDelegate;", "startActivityDelegate", "request", "startLogin", "Landroid/content/Context;", "context", "loginRequest", "logStartLogin", "Lcom/facebook/login/LoginClient$Result$Code;", "result", "", "resultExtras", "Ljava/lang/Exception;", "exception", "", "wasLoginActivityTried", "logCompleteLogin", "tryFacebookActivity", "Landroid/content/Intent;", "intent", "resolveIntent", "Lcom/facebook/AccessToken;", "newToken", "Lcom/facebook/AuthenticationToken;", "newIdToken", "origRequest", "Lcom/facebook/FacebookException;", "isCanceled", "Lcom/facebook/FacebookCallback;", "Lcom/facebook/login/LoginResult;", "callback", "finishLogin", "Lcom/facebook/LoginStatusCallback;", "responseCallback", "", "toastDurationMs", "retrieveLoginStatusImpl", "isExpressLoginAllowed", "setExpressLoginStatus", "Landroid/app/Activity;", "activity", "Landroidx/fragment/app/Fragment;", "Landroid/app/Fragment;", "registerCallback", "unregisterCallback", "", "resultCode", ShareConstants.WEB_DIALOG_PARAM_DATA, "onActivityResult", "Lcom/facebook/login/LoginBehavior;", "loginBehavior", "setLoginBehavior", "Lcom/facebook/login/LoginTargetApp;", "targetApp", "setLoginTargetApp", "Lcom/facebook/login/DefaultAudience;", "defaultAudience", "setDefaultAudience", "authType", "setAuthType", "messengerPageId", "setMessengerPageId", "resetMessengerState", "setResetMessengerState", "isFamilyLogin", "setFamilyLogin", "shouldSkipAccountDeduplication", "setShouldSkipAccountDeduplication", "logOut", "retrieveLoginStatus", "logInWithConfiguration", "loggerID", "Lcom/facebook/login/LoginManager$FacebookLoginActivityResultContract;", "createLogInActivityResultContract", "createLoginRequestWithConfig", "createLoginRequest", "createReauthorizeRequest", "getFacebookActivityIntent", "<set-?>", "Lcom/facebook/login/LoginBehavior;", "getLoginBehavior", "()Lcom/facebook/login/LoginBehavior;", "Lcom/facebook/login/DefaultAudience;", "getDefaultAudience", "()Lcom/facebook/login/DefaultAudience;", "Landroid/content/SharedPreferences;", "sharedPreferences", "Landroid/content/SharedPreferences;", "Ljava/lang/String;", "getAuthType", "()Ljava/lang/String;", "Z", "loginTargetApp", "Lcom/facebook/login/LoginTargetApp;", "getLoginTargetApp", "()Lcom/facebook/login/LoginTargetApp;", "()Z", "getShouldSkipAccountDeduplication", "<init>", "()V", "Companion", "ActivityStartActivityDelegate", "AndroidxActivityResultRegistryOwnerStartActivityDelegate", "FacebookLoginActivityResultContract", "FragmentStartActivityDelegate", "LoginLoggerHolder", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public class LoginManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String EXPRESS_LOGIN_ALLOWED = "express_login_allowed";

    @NotNull
    private static final String MANAGE_PERMISSION_PREFIX = "manage";

    @NotNull
    private static final Set<String> OTHER_PUBLISH_PERMISSIONS;

    @NotNull
    private static final String PREFERENCE_LOGIN_MANAGER = "com.facebook.loginManager";

    @NotNull
    private static final String PUBLISH_PERMISSION_PREFIX = "publish";

    @NotNull
    private static final String TAG;
    private static volatile LoginManager instance;
    private boolean isFamilyLogin;

    @Nullable
    private String messengerPageId;
    private boolean resetMessengerState;

    @NotNull
    private final SharedPreferences sharedPreferences;
    private boolean shouldSkipAccountDeduplication;

    @NotNull
    private LoginBehavior loginBehavior = LoginBehavior.NATIVE_WITH_FALLBACK;

    @NotNull
    private DefaultAudience defaultAudience = DefaultAudience.FRIENDS;

    @NotNull
    private String authType = ServerProtocol.DIALOG_REREQUEST_AUTH_TYPE;

    @NotNull
    private LoginTargetApp loginTargetApp = LoginTargetApp.FACEBOOK;

    /* compiled from: LoginManager.kt */
    @Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/facebook/login/LoginManager$ActivityStartActivityDelegate;", "Lcom/facebook/login/StartActivityDelegate;", "Landroid/content/Intent;", "intent", "", "requestCode", "Lkotlin/t;", "startActivityForResult", "Landroid/app/Activity;", "activityContext", "Landroid/app/Activity;", "getActivityContext", "()Landroid/app/Activity;", "activity", "<init>", "(Landroid/app/Activity;)V", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
    private static final class ActivityStartActivityDelegate implements StartActivityDelegate {

        @NotNull
        private final Activity activityContext;

        public ActivityStartActivityDelegate(@NotNull Activity activity) {
            s.e(activity, "activity");
            this.activityContext = activity;
        }

        @Override // com.facebook.login.StartActivityDelegate
        @NotNull
        public Activity getActivityContext() {
            return this.activityContext;
        }

        @Override // com.facebook.login.StartActivityDelegate
        public void startActivityForResult(@NotNull Intent intent, int i2) {
            s.e(intent, "intent");
            getActivityContext().startActivityForResult(intent, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LoginManager.kt */
    @Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/facebook/login/LoginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate;", "Lcom/facebook/login/StartActivityDelegate;", "Landroid/content/Intent;", "intent", "", "requestCode", "Lkotlin/t;", "startActivityForResult", "Landroidx/activity/result/c;", "activityResultRegistryOwner", "Landroidx/activity/result/c;", "Lcom/facebook/CallbackManager;", "callbackManager", "Lcom/facebook/CallbackManager;", "Landroid/app/Activity;", "getActivityContext", "()Landroid/app/Activity;", "activityContext", "<init>", "(Landroidx/activity/result/c;Lcom/facebook/CallbackManager;)V", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
    static final class AndroidxActivityResultRegistryOwnerStartActivityDelegate implements StartActivityDelegate {

        @NotNull
        private final android.view.result.c activityResultRegistryOwner;

        @NotNull
        private final CallbackManager callbackManager;

        public AndroidxActivityResultRegistryOwnerStartActivityDelegate(@NotNull android.view.result.c activityResultRegistryOwner, @NotNull CallbackManager callbackManager) {
            s.e(activityResultRegistryOwner, "activityResultRegistryOwner");
            s.e(callbackManager, "callbackManager");
            this.activityResultRegistryOwner = activityResultRegistryOwner;
            this.callbackManager = callbackManager;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: startActivityForResult$lambda-0, reason: not valid java name */
        public static final void m149startActivityForResult$lambda0(AndroidxActivityResultRegistryOwnerStartActivityDelegate this$0, LoginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder launcherHolder, Pair pair) {
            s.e(this$0, "this$0");
            s.e(launcherHolder, "$launcherHolder");
            CallbackManager callbackManager = this$0.callbackManager;
            int requestCode = CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode();
            Object obj = pair.first;
            s.d(obj, "result.first");
            callbackManager.onActivityResult(requestCode, ((Number) obj).intValue(), (Intent) pair.second);
            android.view.result.b<Intent> launcher = launcherHolder.getLauncher();
            if (launcher != null) {
                launcher.d();
            }
            launcherHolder.setLauncher(null);
        }

        @Override // com.facebook.login.StartActivityDelegate
        @Nullable
        public Activity getActivityContext() {
            Object obj = this.activityResultRegistryOwner;
            if (obj instanceof Activity) {
                return (Activity) obj;
            }
            return null;
        }

        @Override // com.facebook.login.StartActivityDelegate
        public void startActivityForResult(@NotNull Intent intent, int i2) {
            s.e(intent, "intent");
            final LoginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder = new LoginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder();
            loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder.setLauncher(this.activityResultRegistryOwner.getActivityResultRegistry().j("facebook-login", new a_d<Intent, Pair<Integer, Intent>>() { // from class: com.facebook.login.LoginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$1
                @Override // d.a
                @NotNull
                public Intent createIntent(@NotNull Context context, @NotNull Intent input) {
                    s.e(context, "context");
                    s.e(input, "input");
                    return input;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // d.a
                @NotNull
                public Pair<Integer, Intent> parseResult(int resultCode, @Nullable Intent intent2) {
                    Pair<Integer, Intent> pairCreate = Pair.create(Integer.valueOf(resultCode), intent2);
                    s.d(pairCreate, "create(resultCode, intent)");
                    return pairCreate;
                }
            }, new android.view.result.a() { // from class: com.facebook.login.p
                @Override // android.view.result.a
                public final void onActivityResult(Object obj) {
                    LoginManager.AndroidxActivityResultRegistryOwnerStartActivityDelegate.m149startActivityForResult$lambda0(this.f2919a, loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder, (Pair) obj);
                }
            }));
            android.view.result.b<Intent> launcher = loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder.getLauncher();
            if (launcher == null) {
                return;
            }
            launcher.b(intent);
        }
    }

    /* compiled from: LoginManager.kt */
    @Metadata(bv = {}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b+\u0010,J2\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\fH\u0017J \u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0007J\u0012\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0007J\"\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0007R\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u001d8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010\"R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b&\u0010\"R\u0014\u0010'\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010\"R\u0014\u0010(\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010\"R\u0016\u0010)\u001a\u00020\f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006-"}, d2 = {"Lcom/facebook/login/LoginManager$Companion;", "", "", "errorType", "errorDescription", "loggerRef", "Lcom/facebook/login/LoginLogger;", "logger", "Lcom/facebook/LoginStatusCallback;", "responseCallback", "Lkotlin/t;", "handleLoginStatusError", "Lcom/facebook/login/LoginManager;", "getInstance", "Landroid/content/Intent;", "intent", "", "getExtraDataFromIntent", "permission", "", "isPublishPermission", "Lcom/facebook/login/LoginClient$Request;", "request", "Lcom/facebook/AccessToken;", "newToken", "Lcom/facebook/AuthenticationToken;", "newIdToken", "Lcom/facebook/login/LoginResult;", "computeLoginResult", "", "getOtherPublishPermissions", "()Ljava/util/Set;", "otherPublishPermissions", "EXPRESS_LOGIN_ALLOWED", "Ljava/lang/String;", "MANAGE_PERMISSION_PREFIX", "OTHER_PUBLISH_PERMISSIONS", "Ljava/util/Set;", "PREFERENCE_LOGIN_MANAGER", "PUBLISH_PERMISSION_PREFIX", "TAG", "instance", "Lcom/facebook/login/LoginManager;", "<init>", "()V", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.o oVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Set<String> getOtherPublishPermissions() {
            return r0.h("ads_management", "create_event", "rsvp_event");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void handleLoginStatusError(String str, String str2, String str3, LoginLogger loginLogger, LoginStatusCallback loginStatusCallback) {
            FacebookException facebookException = new FacebookException(str + ": " + ((Object) str2));
            loginLogger.logLoginStatusError(str3, facebookException);
            loginStatusCallback.onError(facebookException);
        }

        @JvmStatic
        @VisibleForTesting(otherwise = 2)
        @NotNull
        public final LoginResult computeLoginResult(@NotNull LoginClient.Request request, @NotNull AccessToken newToken, @Nullable AuthenticationToken newIdToken) {
            s.e(request, "request");
            s.e(newToken, "newToken");
            Set<String> permissions = request.getPermissions();
            Set setY = CollectionsKt___CollectionsKt.Y(CollectionsKt___CollectionsKt.A(newToken.getPermissions()));
            if (request.getIsRerequest()) {
                setY.retainAll(permissions);
            }
            Set setY2 = CollectionsKt___CollectionsKt.Y(CollectionsKt___CollectionsKt.A(permissions));
            setY2.removeAll(setY);
            return new LoginResult(newToken, newIdToken, setY, setY2);
        }

        @JvmStatic
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @Nullable
        public final Map<String, String> getExtraDataFromIntent(@Nullable Intent intent) {
            if (intent == null) {
                return null;
            }
            intent.setExtrasClassLoader(LoginClient.Result.class.getClassLoader());
            LoginClient.Result result = (LoginClient.Result) intent.getParcelableExtra(LoginFragment.RESULT_KEY);
            if (result == null) {
                return null;
            }
            return result.extraData;
        }

        @JvmStatic
        @NotNull
        public LoginManager getInstance() {
            if (LoginManager.instance == null) {
                synchronized (this) {
                    LoginManager.instance = new LoginManager();
                    t tVar = t.f3507a;
                }
            }
            LoginManager loginManager = LoginManager.instance;
            if (loginManager != null) {
                return loginManager;
            }
            s.t("instance");
            throw null;
        }

        @JvmStatic
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final boolean isPublishPermission(@Nullable String permission) {
            if (permission != null) {
                return kotlin.text.s.u(permission, LoginManager.PUBLISH_PERMISSION_PREFIX, false, 2, null) || kotlin.text.s.u(permission, LoginManager.MANAGE_PERMISSION_PREFIX, false, 2, null) || LoginManager.OTHER_PUBLISH_PERMISSIONS.contains(permission);
            }
            return false;
        }
    }

    /* compiled from: LoginManager.kt */
    @Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\u0004\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001B\u001f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u001a\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0016R$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/facebook/login/LoginManager$FacebookLoginActivityResultContract;", "Ld/a;", "", "", "Lcom/facebook/CallbackManager$ActivityResultParameters;", "Landroid/content/Context;", "context", "permissions", "Landroid/content/Intent;", "createIntent", "", "resultCode", "intent", "parseResult", "Lcom/facebook/CallbackManager;", "callbackManager", "Lcom/facebook/CallbackManager;", "getCallbackManager", "()Lcom/facebook/CallbackManager;", "setCallbackManager", "(Lcom/facebook/CallbackManager;)V", "loggerID", "Ljava/lang/String;", "getLoggerID", "()Ljava/lang/String;", "setLoggerID", "(Ljava/lang/String;)V", "<init>", "(Lcom/facebook/login/LoginManager;Lcom/facebook/CallbackManager;Ljava/lang/String;)V", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
    public final class FacebookLoginActivityResultContract extends a_d<Collection<? extends String>, CallbackManager.ActivityResultParameters> {

        @Nullable
        private CallbackManager callbackManager;

        @Nullable
        private String loggerID;

        public FacebookLoginActivityResultContract(@Nullable LoginManager this$0, @Nullable CallbackManager callbackManager, String str) {
            s.e(this$0, "this$0");
            LoginManager.this = this$0;
            this.callbackManager = callbackManager;
            this.loggerID = str;
        }

        @Override // d.a
        public /* bridge */ /* synthetic */ Intent createIntent(Context context, Collection<? extends String> collection) {
            return createIntent2(context, (Collection<String>) collection);
        }

        @Nullable
        public final CallbackManager getCallbackManager() {
            return this.callbackManager;
        }

        @Nullable
        public final String getLoggerID() {
            return this.loggerID;
        }

        public final void setCallbackManager(@Nullable CallbackManager callbackManager) {
            this.callbackManager = callbackManager;
        }

        public final void setLoggerID(@Nullable String str) {
            this.loggerID = str;
        }

        @NotNull
        /* renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(@NotNull Context context, @NotNull Collection<String> permissions) throws NoSuchAlgorithmException {
            s.e(context, "context");
            s.e(permissions, "permissions");
            LoginClient.Request requestCreateLoginRequestWithConfig = LoginManager.this.createLoginRequestWithConfig(new LoginConfiguration(permissions, null, 2, null));
            String str = this.loggerID;
            if (str != null) {
                requestCreateLoginRequestWithConfig.setAuthId(str);
            }
            LoginManager.this.logStartLogin(context, requestCreateLoginRequestWithConfig);
            Intent facebookActivityIntent = LoginManager.this.getFacebookActivityIntent(requestCreateLoginRequestWithConfig);
            if (LoginManager.this.resolveIntent(facebookActivityIntent)) {
                return facebookActivityIntent;
            }
            FacebookException facebookException = new FacebookException("Log in attempt failed: FacebookActivity could not be started. Please make sure you added FacebookActivity to the AndroidManifest.");
            LoginManager.this.logCompleteLogin(context, LoginClient.Result.Code.ERROR, null, facebookException, false, requestCreateLoginRequestWithConfig);
            throw facebookException;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.a
        @NotNull
        public CallbackManager.ActivityResultParameters parseResult(int resultCode, @Nullable Intent intent) {
            LoginManager.onActivityResult$default(LoginManager.this, resultCode, intent, null, 4, null);
            int requestCode = CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode();
            CallbackManager callbackManager = this.callbackManager;
            if (callbackManager != null) {
                callbackManager.onActivityResult(requestCode, resultCode, intent);
            }
            return new CallbackManager.ActivityResultParameters(requestCode, resultCode, intent);
        }

        public /* synthetic */ FacebookLoginActivityResultContract(CallbackManager callbackManager, String str, int i2, kotlin.jvm.internal.o oVar) {
            this(LoginManager.this, (i2 & 1) != 0 ? null : callbackManager, (i2 & 2) != 0 ? null : str);
        }
    }

    /* compiled from: LoginManager.kt */
    @Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/facebook/login/LoginManager$FragmentStartActivityDelegate;", "Lcom/facebook/login/StartActivityDelegate;", "Landroid/content/Intent;", "intent", "", "requestCode", "Lkotlin/t;", "startActivityForResult", "Lcom/facebook/internal/FragmentWrapper;", "fragment", "Lcom/facebook/internal/FragmentWrapper;", "Landroid/app/Activity;", "activityContext", "Landroid/app/Activity;", "getActivityContext", "()Landroid/app/Activity;", "<init>", "(Lcom/facebook/internal/FragmentWrapper;)V", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
    private static final class FragmentStartActivityDelegate implements StartActivityDelegate {

        @Nullable
        private final Activity activityContext;

        @NotNull
        private final FragmentWrapper fragment;

        public FragmentStartActivityDelegate(@NotNull FragmentWrapper fragment) {
            s.e(fragment, "fragment");
            this.fragment = fragment;
            this.activityContext = fragment.getActivity();
        }

        @Override // com.facebook.login.StartActivityDelegate
        @Nullable
        public Activity getActivityContext() {
            return this.activityContext;
        }

        @Override // com.facebook.login.StartActivityDelegate
        public void startActivityForResult(@NotNull Intent intent, int i2) {
            s.e(intent, "intent");
            this.fragment.startActivityForResult(intent, i2);
        }
    }

    /* compiled from: LoginManager.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/facebook/login/LoginManager$LoginLoggerHolder;", "", "()V", "logger", "Lcom/facebook/login/LoginLogger;", "getLogger", "context", "Landroid/content/Context;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class LoginLoggerHolder {

        @NotNull
        public static final LoginLoggerHolder INSTANCE = new LoginLoggerHolder();

        @Nullable
        private static LoginLogger logger;

        private LoginLoggerHolder() {
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x000f A[Catch: all -> 0x0008, TRY_ENTER, TryCatch #0 {, blocks: (B:4:0x0003, B:12:0x000f, B:14:0x0013, B:15:0x001e), top: B:20:0x0003 }] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x000c  */
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final synchronized com.facebook.login.LoginLogger getLogger(@org.jetbrains.annotations.Nullable android.content.Context r3) {
            /*
                r2 = this;
                monitor-enter(r2)
                if (r3 != 0) goto La
                android.content.Context r3 = com.facebook.FacebookSdk.getApplicationContext()     // Catch: java.lang.Throwable -> L8
                goto La
            L8:
                r3 = move-exception
                goto L22
            La:
                if (r3 != 0) goto Lf
                r3 = 0
                monitor-exit(r2)
                return r3
            Lf:
                com.facebook.login.LoginLogger r0 = com.facebook.login.LoginManager.LoginLoggerHolder.logger     // Catch: java.lang.Throwable -> L8
                if (r0 != 0) goto L1e
                com.facebook.login.LoginLogger r0 = new com.facebook.login.LoginLogger     // Catch: java.lang.Throwable -> L8
                java.lang.String r1 = com.facebook.FacebookSdk.getApplicationId()     // Catch: java.lang.Throwable -> L8
                r0.<init>(r3, r1)     // Catch: java.lang.Throwable -> L8
                com.facebook.login.LoginManager.LoginLoggerHolder.logger = r0     // Catch: java.lang.Throwable -> L8
            L1e:
                com.facebook.login.LoginLogger r3 = com.facebook.login.LoginManager.LoginLoggerHolder.logger     // Catch: java.lang.Throwable -> L8
                monitor-exit(r2)
                return r3
            L22:
                monitor-exit(r2)
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.LoginManager.LoginLoggerHolder.getLogger(android.content.Context):com.facebook.login.LoginLogger");
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        OTHER_PUBLISH_PERMISSIONS = companion.getOtherPublishPermissions();
        String string = LoginManager.class.toString();
        s.d(string, "LoginManager::class.java.toString()");
        TAG = string;
    }

    public LoginManager() {
        Validate.sdkInitialized();
        SharedPreferences sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences(PREFERENCE_LOGIN_MANAGER, 0);
        s.d(sharedPreferences, "getApplicationContext().getSharedPreferences(PREFERENCE_LOGIN_MANAGER, Context.MODE_PRIVATE)");
        this.sharedPreferences = sharedPreferences;
        if (!FacebookSdk.hasCustomTabsPrefetching || CustomTabUtils.getChromePackage() == null) {
            return;
        }
        androidx.browser.customtabs.c.a(FacebookSdk.getApplicationContext(), "com.android.chrome", new CustomTabPrefetchHelper());
        androidx.browser.customtabs.c.b(FacebookSdk.getApplicationContext(), FacebookSdk.getApplicationContext().getPackageName());
    }

    @JvmStatic
    @VisibleForTesting(otherwise = 2)
    @NotNull
    public static final LoginResult computeLoginResult(@NotNull LoginClient.Request request, @NotNull AccessToken accessToken, @Nullable AuthenticationToken authenticationToken) {
        return INSTANCE.computeLoginResult(request, accessToken, authenticationToken);
    }

    public static /* synthetic */ FacebookLoginActivityResultContract createLogInActivityResultContract$default(LoginManager loginManager, CallbackManager callbackManager, String str, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createLogInActivityResultContract");
        }
        if ((i2 & 1) != 0) {
            callbackManager = null;
        }
        if ((i2 & 2) != 0) {
            str = null;
        }
        return loginManager.createLogInActivityResultContract(callbackManager, str);
    }

    private final LoginClient.Request createLoginRequestFromResponse(GraphResponse response) {
        Set<String> permissions;
        AccessToken accessToken = response.getRequest().getAccessToken();
        List listA = null;
        if (accessToken != null && (permissions = accessToken.getPermissions()) != null) {
            listA = CollectionsKt___CollectionsKt.A(permissions);
        }
        return createLoginRequest(listA);
    }

    private final void finishLogin(AccessToken accessToken, AuthenticationToken authenticationToken, LoginClient.Request request, FacebookException facebookException, boolean z2, FacebookCallback<LoginResult> facebookCallback) {
        if (accessToken != null) {
            AccessToken.INSTANCE.setCurrentAccessToken(accessToken);
            Profile.INSTANCE.fetchProfileForCurrentAccessToken();
        }
        if (authenticationToken != null) {
            AuthenticationToken.INSTANCE.setCurrentAuthenticationToken(authenticationToken);
        }
        if (facebookCallback != null) {
            LoginResult loginResultComputeLoginResult = (accessToken == null || request == null) ? null : INSTANCE.computeLoginResult(request, accessToken, authenticationToken);
            if (z2 || (loginResultComputeLoginResult != null && loginResultComputeLoginResult.getRecentlyGrantedPermissions().isEmpty())) {
                facebookCallback.onCancel();
                return;
            }
            if (facebookException != null) {
                facebookCallback.onError(facebookException);
            } else {
                if (accessToken == null || loginResultComputeLoginResult == null) {
                    return;
                }
                setExpressLoginStatus(true);
                facebookCallback.onSuccess(loginResultComputeLoginResult);
            }
        }
    }

    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Nullable
    public static final Map<String, String> getExtraDataFromIntent(@Nullable Intent intent) {
        return INSTANCE.getExtraDataFromIntent(intent);
    }

    @JvmStatic
    @NotNull
    public static LoginManager getInstance() {
        return INSTANCE.getInstance();
    }

    private final boolean isExpressLoginAllowed() {
        return this.sharedPreferences.getBoolean(EXPRESS_LOGIN_ALLOWED, true);
    }

    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final boolean isPublishPermission(@Nullable String str) {
        return INSTANCE.isPublishPermission(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logCompleteLogin(Context context, LoginClient.Result.Code code, Map<String, String> map, Exception exc, boolean z2, LoginClient.Request request) {
        LoginLogger logger = LoginLoggerHolder.INSTANCE.getLogger(context);
        if (logger == null) {
            return;
        }
        if (request == null) {
            LoginLogger.logUnexpectedError$default(logger, LoginLogger.EVENT_NAME_LOGIN_COMPLETE, "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.", null, 4, null);
            return;
        }
        HashMap map2 = new HashMap();
        map2.put(LoginLogger.EVENT_EXTRAS_TRY_LOGIN_ACTIVITY, z2 ? "1" : "0");
        logger.logCompleteLogin(request.getAuthId(), map2, code, map, exc, request.getIsFamilyLogin() ? LoginLogger.EVENT_NAME_FOA_LOGIN_COMPLETE : LoginLogger.EVENT_NAME_LOGIN_COMPLETE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logStartLogin(Context context, LoginClient.Request request) {
        LoginLogger logger = LoginLoggerHolder.INSTANCE.getLogger(context);
        if (logger == null || request == null) {
            return;
        }
        logger.logStartLogin(request, request.getIsFamilyLogin() ? LoginLogger.EVENT_NAME_FOA_LOGIN_START : LoginLogger.EVENT_NAME_LOGIN_START);
    }

    private final void loginWithConfiguration(FragmentWrapper fragmentWrapper, LoginConfiguration loginConfiguration) throws FacebookException, NoSuchAlgorithmException {
        logIn(fragmentWrapper, loginConfiguration);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean onActivityResult$default(LoginManager loginManager, int i2, Intent intent, FacebookCallback facebookCallback, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onActivityResult");
        }
        if ((i3 & 4) != 0) {
            facebookCallback = null;
        }
        return loginManager.onActivityResult(i2, intent, facebookCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: registerCallback$lambda-0, reason: not valid java name */
    public static final boolean m146registerCallback$lambda0(LoginManager this$0, FacebookCallback facebookCallback, int i2, Intent intent) {
        s.e(this$0, "this$0");
        return this$0.onActivityResult(i2, intent, facebookCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean resolveIntent(Intent intent) {
        return FacebookSdk.getApplicationContext().getPackageManager().resolveActivity(intent, 0) != null;
    }

    private final void retrieveLoginStatusImpl(Context context, final LoginStatusCallback loginStatusCallback, long j2) {
        final String applicationId = FacebookSdk.getApplicationId();
        final String string = UUID.randomUUID().toString();
        s.d(string, "randomUUID().toString()");
        final LoginLogger loginLogger = new LoginLogger(context == null ? FacebookSdk.getApplicationContext() : context, applicationId);
        if (!isExpressLoginAllowed()) {
            loginLogger.logLoginStatusFailure(string);
            loginStatusCallback.onFailure();
            return;
        }
        LoginStatusClient loginStatusClientNewInstance$facebook_common_release = LoginStatusClient.INSTANCE.newInstance$facebook_common_release(context, applicationId, string, FacebookSdk.getGraphApiVersion(), j2, null);
        loginStatusClientNewInstance$facebook_common_release.setCompletedListener(new PlatformServiceClient.CompletedListener() { // from class: com.facebook.login.n
            @Override // com.facebook.internal.PlatformServiceClient.CompletedListener
            public final void completed(Bundle bundle) throws NumberFormatException {
                LoginManager.m147retrieveLoginStatusImpl$lambda2(string, loginLogger, loginStatusCallback, applicationId, bundle);
            }
        });
        loginLogger.logLoginStatusStart(string);
        if (loginStatusClientNewInstance$facebook_common_release.start()) {
            return;
        }
        loginLogger.logLoginStatusFailure(string);
        loginStatusCallback.onFailure();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: retrieveLoginStatusImpl$lambda-2, reason: not valid java name */
    public static final void m147retrieveLoginStatusImpl$lambda2(String loggerRef, LoginLogger logger, LoginStatusCallback responseCallback, String applicationId, Bundle bundle) throws NumberFormatException {
        s.e(loggerRef, "$loggerRef");
        s.e(logger, "$logger");
        s.e(responseCallback, "$responseCallback");
        s.e(applicationId, "$applicationId");
        if (bundle == null) {
            logger.logLoginStatusFailure(loggerRef);
            responseCallback.onFailure();
            return;
        }
        String string = bundle.getString(NativeProtocol.STATUS_ERROR_TYPE);
        String string2 = bundle.getString(NativeProtocol.STATUS_ERROR_DESCRIPTION);
        if (string != null) {
            INSTANCE.handleLoginStatusError(string, string2, loggerRef, logger, responseCallback);
            return;
        }
        String string3 = bundle.getString(NativeProtocol.EXTRA_ACCESS_TOKEN);
        Utility utility = Utility.INSTANCE;
        Date bundleLongAsDate = Utility.getBundleLongAsDate(bundle, NativeProtocol.EXTRA_EXPIRES_SECONDS_SINCE_EPOCH, new Date(0L));
        ArrayList<String> stringArrayList = bundle.getStringArrayList(NativeProtocol.EXTRA_PERMISSIONS);
        String string4 = bundle.getString(NativeProtocol.RESULT_ARGS_SIGNED_REQUEST);
        String string5 = bundle.getString("graph_domain");
        Date bundleLongAsDate2 = Utility.getBundleLongAsDate(bundle, NativeProtocol.EXTRA_DATA_ACCESS_EXPIRATION_TIME, new Date(0L));
        String userIDFromSignedRequest = string4 == null || string4.length() == 0 ? null : LoginMethodHandler.INSTANCE.getUserIDFromSignedRequest(string4);
        if (!(string3 == null || string3.length() == 0)) {
            if (!(stringArrayList == null || stringArrayList.isEmpty())) {
                if (!(userIDFromSignedRequest == null || userIDFromSignedRequest.length() == 0)) {
                    AccessToken accessToken = new AccessToken(string3, applicationId, userIDFromSignedRequest, stringArrayList, null, null, null, bundleLongAsDate, null, bundleLongAsDate2, string5);
                    AccessToken.INSTANCE.setCurrentAccessToken(accessToken);
                    Profile.INSTANCE.fetchProfileForCurrentAccessToken();
                    logger.logLoginStatusSuccess(loggerRef);
                    responseCallback.onCompleted(accessToken);
                    return;
                }
            }
        }
        logger.logLoginStatusFailure(loggerRef);
        responseCallback.onFailure();
    }

    private final void setExpressLoginStatus(boolean z2) {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putBoolean(EXPRESS_LOGIN_ALLOWED, z2);
        editorEdit.apply();
    }

    private final void startLogin(StartActivityDelegate startActivityDelegate, LoginClient.Request request) throws FacebookException {
        logStartLogin(startActivityDelegate.getActivityContext(), request);
        CallbackManagerImpl.INSTANCE.registerStaticCallback(CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode(), new CallbackManagerImpl.Callback() { // from class: com.facebook.login.o
            @Override // com.facebook.internal.CallbackManagerImpl.Callback
            public final boolean onActivityResult(int i2, Intent intent) {
                return LoginManager.m148startLogin$lambda1(this.f2918a, i2, intent);
            }
        });
        if (tryFacebookActivity(startActivityDelegate, request)) {
            return;
        }
        FacebookException facebookException = new FacebookException("Log in attempt failed: FacebookActivity could not be started. Please make sure you added FacebookActivity to the AndroidManifest.");
        logCompleteLogin(startActivityDelegate.getActivityContext(), LoginClient.Result.Code.ERROR, null, facebookException, false, request);
        throw facebookException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: startLogin$lambda-1, reason: not valid java name */
    public static final boolean m148startLogin$lambda1(LoginManager this$0, int i2, Intent intent) {
        s.e(this$0, "this$0");
        return onActivityResult$default(this$0, i2, intent, null, 4, null);
    }

    private final boolean tryFacebookActivity(StartActivityDelegate startActivityDelegate, LoginClient.Request request) {
        Intent facebookActivityIntent = getFacebookActivityIntent(request);
        if (!resolveIntent(facebookActivityIntent)) {
            return false;
        }
        try {
            startActivityDelegate.startActivityForResult(facebookActivityIntent, LoginClient.INSTANCE.getLoginRequestCode());
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    private final void validatePublishPermissions(Collection<String> collection) {
        if (collection == null) {
            return;
        }
        for (String str : collection) {
            if (!INSTANCE.isPublishPermission(str)) {
                throw new FacebookException("Cannot pass a read permission (" + str + ") to a request for publish authorization");
            }
        }
    }

    private final void validateReadPermissions(Collection<String> collection) {
        if (collection == null) {
            return;
        }
        for (String str : collection) {
            if (INSTANCE.isPublishPermission(str)) {
                throw new FacebookException("Cannot pass a publish or manage permission (" + str + ") to a request for read authorization");
            }
        }
    }

    @JvmOverloads
    @NotNull
    public final FacebookLoginActivityResultContract createLogInActivityResultContract() {
        return createLogInActivityResultContract$default(this, null, null, 3, null);
    }

    @JvmOverloads
    @NotNull
    public final FacebookLoginActivityResultContract createLogInActivityResultContract(@Nullable CallbackManager callbackManager) {
        return createLogInActivityResultContract$default(this, callbackManager, null, 2, null);
    }

    @JvmOverloads
    @NotNull
    public final FacebookLoginActivityResultContract createLogInActivityResultContract(@Nullable CallbackManager callbackManager, @Nullable String loggerID) {
        return new FacebookLoginActivityResultContract(this, callbackManager, loggerID);
    }

    @NotNull
    protected LoginClient.Request createLoginRequest(@Nullable Collection<String> permissions) {
        LoginBehavior loginBehavior = this.loginBehavior;
        Set setZ = permissions == null ? null : CollectionsKt___CollectionsKt.Z(permissions);
        DefaultAudience defaultAudience = this.defaultAudience;
        String str = this.authType;
        String applicationId = FacebookSdk.getApplicationId();
        String string = UUID.randomUUID().toString();
        s.d(string, "randomUUID().toString()");
        LoginClient.Request request = new LoginClient.Request(loginBehavior, setZ, defaultAudience, str, applicationId, string, this.loginTargetApp, null, null, null, null, 1920, null);
        request.setRerequest(AccessToken.INSTANCE.isCurrentAccessTokenActive());
        request.setMessengerPageId(this.messengerPageId);
        request.setResetMessengerState(this.resetMessengerState);
        request.setFamilyLogin(this.isFamilyLogin);
        request.setShouldSkipAccountDeduplication(this.shouldSkipAccountDeduplication);
        return request;
    }

    @NotNull
    protected LoginClient.Request createLoginRequestWithConfig(@NotNull LoginConfiguration loginConfig) throws NoSuchAlgorithmException {
        String codeVerifier;
        s.e(loginConfig, "loginConfig");
        CodeChallengeMethod codeChallengeMethod = CodeChallengeMethod.S256;
        try {
            PKCEUtil pKCEUtil = PKCEUtil.INSTANCE;
            codeVerifier = PKCEUtil.generateCodeChallenge(loginConfig.getCodeVerifier(), codeChallengeMethod);
        } catch (FacebookException unused) {
            codeChallengeMethod = CodeChallengeMethod.PLAIN;
            codeVerifier = loginConfig.getCodeVerifier();
        }
        LoginBehavior loginBehavior = this.loginBehavior;
        Set setZ = CollectionsKt___CollectionsKt.Z(loginConfig.getPermissions());
        DefaultAudience defaultAudience = this.defaultAudience;
        String str = this.authType;
        String applicationId = FacebookSdk.getApplicationId();
        String string = UUID.randomUUID().toString();
        s.d(string, "randomUUID().toString()");
        LoginTargetApp loginTargetApp = this.loginTargetApp;
        String nonce = loginConfig.getNonce();
        String codeVerifier2 = loginConfig.getCodeVerifier();
        LoginClient.Request request = new LoginClient.Request(loginBehavior, setZ, defaultAudience, str, applicationId, string, loginTargetApp, nonce, codeVerifier2, codeVerifier, codeChallengeMethod);
        request.setRerequest(AccessToken.INSTANCE.isCurrentAccessTokenActive());
        request.setMessengerPageId(this.messengerPageId);
        request.setResetMessengerState(this.resetMessengerState);
        request.setFamilyLogin(this.isFamilyLogin);
        request.setShouldSkipAccountDeduplication(this.shouldSkipAccountDeduplication);
        return request;
    }

    @NotNull
    protected LoginClient.Request createReauthorizeRequest() {
        LoginBehavior loginBehavior = LoginBehavior.DIALOG_ONLY;
        HashSet hashSet = new HashSet();
        DefaultAudience defaultAudience = this.defaultAudience;
        String applicationId = FacebookSdk.getApplicationId();
        String string = UUID.randomUUID().toString();
        s.d(string, "randomUUID().toString()");
        LoginClient.Request request = new LoginClient.Request(loginBehavior, hashSet, defaultAudience, "reauthorize", applicationId, string, this.loginTargetApp, null, null, null, null, 1920, null);
        request.setFamilyLogin(this.isFamilyLogin);
        request.setShouldSkipAccountDeduplication(this.shouldSkipAccountDeduplication);
        return request;
    }

    @NotNull
    public final String getAuthType() {
        return this.authType;
    }

    @NotNull
    public final DefaultAudience getDefaultAudience() {
        return this.defaultAudience;
    }

    @NotNull
    protected Intent getFacebookActivityIntent(@NotNull LoginClient.Request request) {
        s.e(request, "request");
        Intent intent = new Intent();
        intent.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
        intent.setAction(request.getLoginBehavior().toString());
        Bundle bundle = new Bundle();
        bundle.putParcelable("request", request);
        intent.putExtra(LoginFragment.REQUEST_KEY, bundle);
        return intent;
    }

    @NotNull
    public final LoginBehavior getLoginBehavior() {
        return this.loginBehavior;
    }

    @NotNull
    public final LoginTargetApp getLoginTargetApp() {
        return this.loginTargetApp;
    }

    public final boolean getShouldSkipAccountDeduplication() {
        return this.shouldSkipAccountDeduplication;
    }

    /* renamed from: isFamilyLogin, reason: from getter */
    public final boolean getIsFamilyLogin() {
        return this.isFamilyLogin;
    }

    public final void logIn(@NotNull Fragment fragment, @Nullable Collection<String> collection) throws FacebookException, NoSuchAlgorithmException {
        s.e(fragment, "fragment");
        logIn(new FragmentWrapper(fragment), collection);
    }

    public final void logInWithConfiguration(@NotNull Fragment fragment, @NotNull LoginConfiguration loginConfig) throws FacebookException, NoSuchAlgorithmException {
        s.e(fragment, "fragment");
        s.e(loginConfig, "loginConfig");
        loginWithConfiguration(new FragmentWrapper(fragment), loginConfig);
    }

    @Deprecated(message = "")
    public final void logInWithPublishPermissions(@NotNull Fragment fragment, @NotNull Collection<String> permissions) throws FacebookException, NoSuchAlgorithmException {
        s.e(fragment, "fragment");
        s.e(permissions, "permissions");
        logInWithPublishPermissions(new FragmentWrapper(fragment), permissions);
    }

    @Deprecated(message = "")
    public final void logInWithReadPermissions(@NotNull Fragment fragment, @NotNull Collection<String> permissions) throws FacebookException, NoSuchAlgorithmException {
        s.e(fragment, "fragment");
        s.e(permissions, "permissions");
        logInWithReadPermissions(new FragmentWrapper(fragment), permissions);
    }

    public void logOut() {
        AccessToken.INSTANCE.setCurrentAccessToken(null);
        AuthenticationToken.INSTANCE.setCurrentAuthenticationToken(null);
        Profile.INSTANCE.setCurrentProfile(null);
        setExpressLoginStatus(false);
    }

    @JvmOverloads
    @VisibleForTesting(otherwise = 3)
    public final boolean onActivityResult(int i2, @Nullable Intent intent) {
        return onActivityResult$default(this, i2, intent, null, 4, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0053  */
    @kotlin.jvm.JvmOverloads
    @androidx.annotation.VisibleForTesting(otherwise = 3)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onActivityResult(int r16, @org.jetbrains.annotations.Nullable android.content.Intent r17, @org.jetbrains.annotations.Nullable com.facebook.FacebookCallback<com.facebook.login.LoginResult> r18) {
        /*
            r15 = this;
            r0 = r16
            r1 = r17
            com.facebook.login.LoginClient$Result$Code r2 = com.facebook.login.LoginClient.Result.Code.ERROR
            r3 = 1
            r4 = 0
            r5 = 0
            if (r1 == 0) goto L48
            java.lang.Class<com.facebook.login.LoginClient$Result> r6 = com.facebook.login.LoginClient.Result.class
            java.lang.ClassLoader r6 = r6.getClassLoader()
            r1.setExtrasClassLoader(r6)
            java.lang.String r6 = "com.facebook.LoginFragment:Result"
            android.os.Parcelable r1 = r1.getParcelableExtra(r6)
            com.facebook.login.LoginClient$Result r1 = (com.facebook.login.LoginClient.Result) r1
            if (r1 == 0) goto L53
            com.facebook.login.LoginClient$Request r2 = r1.request
            com.facebook.login.LoginClient$Result$Code r6 = r1.code
            r7 = -1
            if (r0 == r7) goto L2e
            if (r0 == 0) goto L2a
            r0 = r4
            r7 = r0
            goto L41
        L2a:
            r0 = r4
            r7 = r0
            r5 = 1
            goto L41
        L2e:
            com.facebook.login.LoginClient$Result$Code r0 = com.facebook.login.LoginClient.Result.Code.SUCCESS
            if (r6 != r0) goto L37
            com.facebook.AccessToken r0 = r1.token
            com.facebook.AuthenticationToken r7 = r1.authenticationToken
            goto L41
        L37:
            com.facebook.FacebookAuthorizationException r0 = new com.facebook.FacebookAuthorizationException
            java.lang.String r7 = r1.errorMessage
            r0.<init>(r7)
            r7 = r4
            r4 = r0
            r0 = r7
        L41:
            java.util.Map<java.lang.String, java.lang.String> r1 = r1.loggingExtras
            r8 = r1
            r13 = r5
            r1 = r7
            r7 = r6
            goto L59
        L48:
            if (r0 != 0) goto L53
            com.facebook.login.LoginClient$Result$Code r2 = com.facebook.login.LoginClient.Result.Code.CANCEL
            r7 = r2
            r0 = r4
            r1 = r0
            r2 = r1
            r8 = r2
            r13 = 1
            goto L59
        L53:
            r7 = r2
            r0 = r4
            r1 = r0
            r2 = r1
            r8 = r2
            r13 = 0
        L59:
            if (r4 != 0) goto L66
            if (r0 != 0) goto L66
            if (r13 != 0) goto L66
            com.facebook.FacebookException r4 = new com.facebook.FacebookException
            java.lang.String r5 = "Unexpected call to LoginManager.onActivityResult"
            r4.<init>(r5)
        L66:
            r12 = r4
            r10 = 1
            r6 = 0
            r5 = r15
            r9 = r12
            r11 = r2
            r5.logCompleteLogin(r6, r7, r8, r9, r10, r11)
            r8 = r15
            r9 = r0
            r10 = r1
            r14 = r18
            r8.finishLogin(r9, r10, r11, r12, r13, r14)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.LoginManager.onActivityResult(int, android.content.Intent, com.facebook.FacebookCallback):boolean");
    }

    public final void reauthorizeDataAccess(@NotNull Activity activity) throws FacebookException {
        s.e(activity, "activity");
        startLogin(new ActivityStartActivityDelegate(activity), createReauthorizeRequest());
    }

    public final void registerCallback(@Nullable CallbackManager callbackManager, @Nullable final FacebookCallback<LoginResult> facebookCallback) {
        if (!(callbackManager instanceof CallbackManagerImpl)) {
            throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
        }
        ((CallbackManagerImpl) callbackManager).registerCallback(CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode(), new CallbackManagerImpl.Callback() { // from class: com.facebook.login.m
            @Override // com.facebook.internal.CallbackManagerImpl.Callback
            public final boolean onActivityResult(int i2, Intent intent) {
                return LoginManager.m146registerCallback$lambda0(this.f2912a, facebookCallback, i2, intent);
            }
        });
    }

    public final void resolveError(@NotNull Activity activity, @NotNull GraphResponse response) throws FacebookException {
        s.e(activity, "activity");
        s.e(response, "response");
        startLogin(new ActivityStartActivityDelegate(activity), createLoginRequestFromResponse(response));
    }

    public final void retrieveLoginStatus(@NotNull Context context, @NotNull LoginStatusCallback responseCallback) {
        s.e(context, "context");
        s.e(responseCallback, "responseCallback");
        retrieveLoginStatus(context, 5000L, responseCallback);
    }

    @NotNull
    public final LoginManager setAuthType(@NotNull String authType) {
        s.e(authType, "authType");
        this.authType = authType;
        return this;
    }

    @NotNull
    public final LoginManager setDefaultAudience(@NotNull DefaultAudience defaultAudience) {
        s.e(defaultAudience, "defaultAudience");
        this.defaultAudience = defaultAudience;
        return this;
    }

    @NotNull
    public final LoginManager setFamilyLogin(boolean isFamilyLogin) {
        this.isFamilyLogin = isFamilyLogin;
        return this;
    }

    @NotNull
    public final LoginManager setLoginBehavior(@NotNull LoginBehavior loginBehavior) {
        s.e(loginBehavior, "loginBehavior");
        this.loginBehavior = loginBehavior;
        return this;
    }

    @NotNull
    public final LoginManager setLoginTargetApp(@NotNull LoginTargetApp targetApp) {
        s.e(targetApp, "targetApp");
        this.loginTargetApp = targetApp;
        return this;
    }

    @NotNull
    public final LoginManager setMessengerPageId(@Nullable String messengerPageId) {
        this.messengerPageId = messengerPageId;
        return this;
    }

    @NotNull
    public final LoginManager setResetMessengerState(boolean resetMessengerState) {
        this.resetMessengerState = resetMessengerState;
        return this;
    }

    @NotNull
    public final LoginManager setShouldSkipAccountDeduplication(boolean shouldSkipAccountDeduplication) {
        this.shouldSkipAccountDeduplication = shouldSkipAccountDeduplication;
        return this;
    }

    public final void unregisterCallback(@Nullable CallbackManager callbackManager) {
        if (!(callbackManager instanceof CallbackManagerImpl)) {
            throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
        }
        ((CallbackManagerImpl) callbackManager).unregisterCallback(CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode());
    }

    public final void logIn(@NotNull Fragment fragment, @Nullable Collection<String> collection, @Nullable String str) throws FacebookException, NoSuchAlgorithmException {
        s.e(fragment, "fragment");
        logIn(new FragmentWrapper(fragment), collection, str);
    }

    public final void logInWithPublishPermissions(@NotNull Fragment fragment, @NotNull CallbackManager callbackManager, @NotNull Collection<String> permissions) throws FacebookException, NoSuchAlgorithmException {
        s.e(fragment, "fragment");
        s.e(callbackManager, "callbackManager");
        s.e(permissions, "permissions");
        FragmentActivity activity = fragment.getActivity();
        if (activity == null) {
            throw new FacebookException(s.m("Cannot obtain activity context on the fragment ", fragment));
        }
        logInWithPublishPermissions(activity, callbackManager, permissions);
    }

    public final void logInWithReadPermissions(@NotNull Fragment fragment, @NotNull CallbackManager callbackManager, @NotNull Collection<String> permissions) throws FacebookException, NoSuchAlgorithmException {
        s.e(fragment, "fragment");
        s.e(callbackManager, "callbackManager");
        s.e(permissions, "permissions");
        FragmentActivity activity = fragment.getActivity();
        if (activity == null) {
            throw new FacebookException(s.m("Cannot obtain activity context on the fragment ", fragment));
        }
        logInWithReadPermissions(activity, callbackManager, permissions);
    }

    public final void loginWithConfiguration(@NotNull Activity activity, @NotNull LoginConfiguration loginConfig) throws FacebookException, NoSuchAlgorithmException {
        s.e(activity, "activity");
        s.e(loginConfig, "loginConfig");
        logIn(activity, loginConfig);
    }

    @Deprecated(message = "")
    public final void resolveError(@NotNull Fragment fragment, @NotNull GraphResponse response) throws FacebookException {
        s.e(fragment, "fragment");
        s.e(response, "response");
        resolveError(new FragmentWrapper(fragment), response);
    }

    public final void retrieveLoginStatus(@NotNull Context context, long j2, @NotNull LoginStatusCallback responseCallback) {
        s.e(context, "context");
        s.e(responseCallback, "responseCallback");
        retrieveLoginStatusImpl(context, responseCallback, j2);
    }

    public final void logIn(@NotNull android.app.Fragment fragment, @Nullable Collection<String> collection) throws FacebookException, NoSuchAlgorithmException {
        s.e(fragment, "fragment");
        logIn(new FragmentWrapper(fragment), collection);
    }

    public final void reauthorizeDataAccess(@NotNull Fragment fragment) throws FacebookException {
        s.e(fragment, "fragment");
        reauthorizeDataAccess(new FragmentWrapper(fragment));
    }

    public final void resolveError(@NotNull Fragment fragment, @NotNull CallbackManager callbackManager, @NotNull GraphResponse response) throws FacebookException {
        s.e(fragment, "fragment");
        s.e(callbackManager, "callbackManager");
        s.e(response, "response");
        FragmentActivity activity = fragment.getActivity();
        if (activity != null) {
            resolveError(activity, callbackManager, response);
            return;
        }
        throw new FacebookException(s.m("Cannot obtain activity context on the fragment ", fragment));
    }

    private final void reauthorizeDataAccess(FragmentWrapper fragmentWrapper) throws FacebookException {
        startLogin(new FragmentStartActivityDelegate(fragmentWrapper), createReauthorizeRequest());
    }

    public final void logIn(@NotNull android.app.Fragment fragment, @Nullable Collection<String> collection, @Nullable String str) throws FacebookException, NoSuchAlgorithmException {
        s.e(fragment, "fragment");
        logIn(new FragmentWrapper(fragment), collection, str);
    }

    public final void logIn(@NotNull FragmentWrapper fragment, @Nullable Collection<String> collection) throws FacebookException, NoSuchAlgorithmException {
        s.e(fragment, "fragment");
        logIn(fragment, new LoginConfiguration(collection, null, 2, null));
    }

    public final void logInWithPublishPermissions(@NotNull android.app.Fragment fragment, @NotNull Collection<String> permissions) throws FacebookException, NoSuchAlgorithmException {
        s.e(fragment, "fragment");
        s.e(permissions, "permissions");
        logInWithPublishPermissions(new FragmentWrapper(fragment), permissions);
    }

    public final void logInWithReadPermissions(@NotNull android.app.Fragment fragment, @NotNull Collection<String> permissions) throws FacebookException, NoSuchAlgorithmException {
        s.e(fragment, "fragment");
        s.e(permissions, "permissions");
        logInWithReadPermissions(new FragmentWrapper(fragment), permissions);
    }

    private final void logInWithPublishPermissions(FragmentWrapper fragmentWrapper, Collection<String> collection) throws FacebookException, NoSuchAlgorithmException {
        validatePublishPermissions(collection);
        loginWithConfiguration(fragmentWrapper, new LoginConfiguration(collection, null, 2, null));
    }

    private final void logInWithReadPermissions(FragmentWrapper fragmentWrapper, Collection<String> collection) throws FacebookException, NoSuchAlgorithmException {
        validateReadPermissions(collection);
        logIn(fragmentWrapper, new LoginConfiguration(collection, null, 2, null));
    }

    public final void resolveError(@NotNull android.app.Fragment fragment, @NotNull GraphResponse response) throws FacebookException {
        s.e(fragment, "fragment");
        s.e(response, "response");
        resolveError(new FragmentWrapper(fragment), response);
    }

    private final void resolveError(FragmentWrapper fragmentWrapper, GraphResponse graphResponse) throws FacebookException {
        startLogin(new FragmentStartActivityDelegate(fragmentWrapper), createLoginRequestFromResponse(graphResponse));
    }

    public final void logIn(@NotNull FragmentWrapper fragment, @Nullable Collection<String> collection, @Nullable String str) throws FacebookException, NoSuchAlgorithmException {
        s.e(fragment, "fragment");
        LoginClient.Request requestCreateLoginRequestWithConfig = createLoginRequestWithConfig(new LoginConfiguration(collection, null, 2, null));
        if (str != null) {
            requestCreateLoginRequestWithConfig.setAuthId(str);
        }
        startLogin(new FragmentStartActivityDelegate(fragment), requestCreateLoginRequestWithConfig);
    }

    public final void resolveError(@NotNull android.view.result.c activityResultRegistryOwner, @NotNull CallbackManager callbackManager, @NotNull GraphResponse response) throws FacebookException {
        s.e(activityResultRegistryOwner, "activityResultRegistryOwner");
        s.e(callbackManager, "callbackManager");
        s.e(response, "response");
        startLogin(new AndroidxActivityResultRegistryOwnerStartActivityDelegate(activityResultRegistryOwner, callbackManager), createLoginRequestFromResponse(response));
    }

    public final void logInWithPublishPermissions(@NotNull Activity activity, @Nullable Collection<String> collection) {
        s.e(activity, "activity");
        validatePublishPermissions(collection);
        loginWithConfiguration(activity, new LoginConfiguration(collection, null, 2, null));
    }

    public final void logInWithReadPermissions(@NotNull Activity activity, @Nullable Collection<String> collection) {
        s.e(activity, "activity");
        validateReadPermissions(collection);
        logIn(activity, new LoginConfiguration(collection, null, 2, null));
    }

    public final void logIn(@NotNull Activity activity, @Nullable Collection<String> collection) throws FacebookException, NoSuchAlgorithmException {
        s.e(activity, "activity");
        logIn(activity, new LoginConfiguration(collection, null, 2, null));
    }

    public final void logInWithPublishPermissions(@NotNull android.view.result.c activityResultRegistryOwner, @NotNull CallbackManager callbackManager, @NotNull Collection<String> permissions) throws FacebookException, NoSuchAlgorithmException {
        s.e(activityResultRegistryOwner, "activityResultRegistryOwner");
        s.e(callbackManager, "callbackManager");
        s.e(permissions, "permissions");
        validatePublishPermissions(permissions);
        logIn(activityResultRegistryOwner, callbackManager, new LoginConfiguration(permissions, null, 2, null));
    }

    public final void logInWithReadPermissions(@NotNull android.view.result.c activityResultRegistryOwner, @NotNull CallbackManager callbackManager, @NotNull Collection<String> permissions) throws FacebookException, NoSuchAlgorithmException {
        s.e(activityResultRegistryOwner, "activityResultRegistryOwner");
        s.e(callbackManager, "callbackManager");
        s.e(permissions, "permissions");
        validateReadPermissions(permissions);
        logIn(activityResultRegistryOwner, callbackManager, new LoginConfiguration(permissions, null, 2, null));
    }

    public final void logIn(@NotNull FragmentWrapper fragment, @NotNull LoginConfiguration loginConfig) throws FacebookException, NoSuchAlgorithmException {
        s.e(fragment, "fragment");
        s.e(loginConfig, "loginConfig");
        startLogin(new FragmentStartActivityDelegate(fragment), createLoginRequestWithConfig(loginConfig));
    }

    public final void logIn(@NotNull Activity activity, @NotNull LoginConfiguration loginConfig) throws FacebookException, NoSuchAlgorithmException {
        s.e(activity, "activity");
        s.e(loginConfig, "loginConfig");
        if (activity instanceof android.view.result.c) {
            Log.w(TAG, "You're calling logging in Facebook with an activity supports androidx activity result APIs. Please follow our document to upgrade to new APIs to avoid overriding onActivityResult().");
        }
        startLogin(new ActivityStartActivityDelegate(activity), createLoginRequestWithConfig(loginConfig));
    }

    public final void logIn(@NotNull Activity activity, @Nullable Collection<String> collection, @Nullable String str) throws FacebookException, NoSuchAlgorithmException {
        s.e(activity, "activity");
        LoginClient.Request requestCreateLoginRequestWithConfig = createLoginRequestWithConfig(new LoginConfiguration(collection, null, 2, null));
        if (str != null) {
            requestCreateLoginRequestWithConfig.setAuthId(str);
        }
        startLogin(new ActivityStartActivityDelegate(activity), requestCreateLoginRequestWithConfig);
    }

    private final void logIn(android.view.result.c cVar, CallbackManager callbackManager, LoginConfiguration loginConfiguration) throws FacebookException, NoSuchAlgorithmException {
        startLogin(new AndroidxActivityResultRegistryOwnerStartActivityDelegate(cVar, callbackManager), createLoginRequestWithConfig(loginConfiguration));
    }

    public final void logIn(@NotNull android.view.result.c activityResultRegistryOwner, @NotNull CallbackManager callbackManager, @NotNull Collection<String> permissions, @Nullable String str) throws FacebookException, NoSuchAlgorithmException {
        s.e(activityResultRegistryOwner, "activityResultRegistryOwner");
        s.e(callbackManager, "callbackManager");
        s.e(permissions, "permissions");
        LoginClient.Request requestCreateLoginRequestWithConfig = createLoginRequestWithConfig(new LoginConfiguration(permissions, null, 2, null));
        if (str != null) {
            requestCreateLoginRequestWithConfig.setAuthId(str);
        }
        startLogin(new AndroidxActivityResultRegistryOwnerStartActivityDelegate(activityResultRegistryOwner, callbackManager), requestCreateLoginRequestWithConfig);
    }

    public final void logIn(@NotNull android.view.result.c activityResultRegistryOwner, @NotNull CallbackManager callbackManager, @NotNull Collection<String> permissions) throws FacebookException, NoSuchAlgorithmException {
        s.e(activityResultRegistryOwner, "activityResultRegistryOwner");
        s.e(callbackManager, "callbackManager");
        s.e(permissions, "permissions");
        logIn(activityResultRegistryOwner, callbackManager, new LoginConfiguration(permissions, null, 2, null));
    }
}
