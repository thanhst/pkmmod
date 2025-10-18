package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.facebook.internal.Utility;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import u.a_u;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AuthenticationTokenManager.kt */
@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bB\u0019\b\u0000\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\t\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0006R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R(\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0007\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/facebook/AuthenticationTokenManager;", "", "Lcom/facebook/AuthenticationToken;", "currentAuthenticationToken", "", "saveToCache", "Lkotlin/t;", "setCurrentAuthenticationToken", "oldAuthenticationToken", "sendCurrentAuthenticationTokenChangedBroadcastIntent", "loadCurrentAuthenticationToken", "currentAuthenticationTokenChanged", "Lu/a;", "localBroadcastManager", "Lu/a;", "Lcom/facebook/AuthenticationTokenCache;", "authenticationTokenCache", "Lcom/facebook/AuthenticationTokenCache;", "currentAuthenticationTokenField", "Lcom/facebook/AuthenticationToken;", "value", "getCurrentAuthenticationToken", "()Lcom/facebook/AuthenticationToken;", "(Lcom/facebook/AuthenticationToken;)V", "<init>", "(Lu/a;Lcom/facebook/AuthenticationTokenCache;)V", "Companion", "CurrentAuthenticationTokenChangedBroadcastReceiver", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AuthenticationTokenManager {

    @NotNull
    public static final String ACTION_CURRENT_AUTHENTICATION_TOKEN_CHANGED = "com.facebook.sdk.ACTION_CURRENT_AUTHENTICATION_TOKEN_CHANGED";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String EXTRA_NEW_AUTHENTICATION_TOKEN = "com.facebook.sdk.EXTRA_NEW_AUTHENTICATION_TOKEN";

    @NotNull
    public static final String EXTRA_OLD_AUTHENTICATION_TOKEN = "com.facebook.sdk.EXTRA_OLD_AUTHENTICATION_TOKEN";

    @NotNull
    public static final String SHARED_PREFERENCES_NAME = "com.facebook.AuthenticationTokenManager.SharedPreferences";

    @NotNull
    public static final String TAG = "AuthenticationTokenManager";

    @Nullable
    private static AuthenticationTokenManager instanceField;

    @NotNull
    private final AuthenticationTokenCache authenticationTokenCache;

    @Nullable
    private AuthenticationToken currentAuthenticationTokenField;

    @NotNull
    private final a_u localBroadcastManager;

    /* compiled from: AuthenticationTokenManager.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/facebook/AuthenticationTokenManager$Companion;", "", "()V", "ACTION_CURRENT_AUTHENTICATION_TOKEN_CHANGED", "", "EXTRA_NEW_AUTHENTICATION_TOKEN", "EXTRA_OLD_AUTHENTICATION_TOKEN", "SHARED_PREFERENCES_NAME", "TAG", "instanceField", "Lcom/facebook/AuthenticationTokenManager;", "getInstance", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.o oVar) {
            this();
        }

        @JvmStatic
        @NotNull
        public final AuthenticationTokenManager getInstance() {
            AuthenticationTokenManager authenticationTokenManager;
            AuthenticationTokenManager authenticationTokenManager2 = AuthenticationTokenManager.instanceField;
            if (authenticationTokenManager2 != null) {
                return authenticationTokenManager2;
            }
            synchronized (this) {
                authenticationTokenManager = AuthenticationTokenManager.instanceField;
                if (authenticationTokenManager == null) {
                    a_u aUVarB = a_u.b(FacebookSdk.getApplicationContext());
                    kotlin.jvm.internal.s.d(aUVarB, "getInstance(applicationContext)");
                    AuthenticationTokenManager authenticationTokenManager3 = new AuthenticationTokenManager(aUVarB, new AuthenticationTokenCache());
                    AuthenticationTokenManager.instanceField = authenticationTokenManager3;
                    authenticationTokenManager = authenticationTokenManager3;
                }
            }
            return authenticationTokenManager;
        }
    }

    /* compiled from: AuthenticationTokenManager.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\n"}, d2 = {"Lcom/facebook/AuthenticationTokenManager$CurrentAuthenticationTokenChangedBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "Lkotlin/t;", "onReceive", "<init>", "()V", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class CurrentAuthenticationTokenChangedBroadcastReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(@NotNull Context context, @NotNull Intent intent) {
            kotlin.jvm.internal.s.e(context, "context");
            kotlin.jvm.internal.s.e(intent, "intent");
        }
    }

    public AuthenticationTokenManager(@NotNull a_u localBroadcastManager, @NotNull AuthenticationTokenCache authenticationTokenCache) {
        kotlin.jvm.internal.s.e(localBroadcastManager, "localBroadcastManager");
        kotlin.jvm.internal.s.e(authenticationTokenCache, "authenticationTokenCache");
        this.localBroadcastManager = localBroadcastManager;
        this.authenticationTokenCache = authenticationTokenCache;
    }

    @JvmStatic
    @NotNull
    public static final AuthenticationTokenManager getInstance() {
        return INSTANCE.getInstance();
    }

    private final void sendCurrentAuthenticationTokenChangedBroadcastIntent(AuthenticationToken authenticationToken, AuthenticationToken authenticationToken2) {
        Intent intent = new Intent(FacebookSdk.getApplicationContext(), (Class<?>) CurrentAuthenticationTokenChangedBroadcastReceiver.class);
        intent.setAction(ACTION_CURRENT_AUTHENTICATION_TOKEN_CHANGED);
        intent.putExtra(EXTRA_OLD_AUTHENTICATION_TOKEN, authenticationToken);
        intent.putExtra(EXTRA_NEW_AUTHENTICATION_TOKEN, authenticationToken2);
        this.localBroadcastManager.d(intent);
    }

    public final void currentAuthenticationTokenChanged() {
        sendCurrentAuthenticationTokenChangedBroadcastIntent(getCurrentAuthenticationTokenField(), getCurrentAuthenticationTokenField());
    }

    @Nullable
    /* renamed from: getCurrentAuthenticationToken, reason: from getter */
    public final AuthenticationToken getCurrentAuthenticationTokenField() {
        return this.currentAuthenticationTokenField;
    }

    public final boolean loadCurrentAuthenticationToken() {
        AuthenticationToken authenticationTokenLoad = this.authenticationTokenCache.load();
        if (authenticationTokenLoad == null) {
            return false;
        }
        setCurrentAuthenticationToken(authenticationTokenLoad, false);
        return true;
    }

    public final void setCurrentAuthenticationToken(@Nullable AuthenticationToken authenticationToken) {
        setCurrentAuthenticationToken(authenticationToken, true);
    }

    private final void setCurrentAuthenticationToken(AuthenticationToken authenticationToken, boolean z2) {
        AuthenticationToken currentAuthenticationTokenField = getCurrentAuthenticationTokenField();
        this.currentAuthenticationTokenField = authenticationToken;
        if (z2) {
            if (authenticationToken != null) {
                this.authenticationTokenCache.save(authenticationToken);
            } else {
                this.authenticationTokenCache.clear();
                Utility utility = Utility.INSTANCE;
                Utility.clearFacebookCookies(FacebookSdk.getApplicationContext());
            }
        }
        if (Utility.areObjectsEqual(currentAuthenticationTokenField, authenticationToken)) {
            return;
        }
        sendCurrentAuthenticationTokenChangedBroadcastIntent(currentAuthenticationTokenField, authenticationToken);
    }
}
