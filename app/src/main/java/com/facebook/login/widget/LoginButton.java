package com.facebook.login.widget;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.result.c;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookButtonBase;
import com.facebook.FacebookCallback;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.DefaultAudience;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.LoginTargetApp;
import com.facebook.login.R;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import e.a_e;

/* loaded from: classes.dex */
public class LoginButton extends FacebookButtonBase {
    private static final int MAX_BUTTON_TRANSPARENCY = 255;
    private static final int MIN_BUTTON_TRANSPARENCY = 0;
    private static final String TAG = LoginButton.class.getName();
    private AccessTokenTracker accessTokenTracker;

    @Nullable
    private android.view.result.b<Collection<? extends String>> androidXLoginCaller;

    @Nullable
    private CallbackManager callbackManager;
    private boolean confirmLogout;
    private Float customButtonRadius;
    private int customButtonTransparency;
    private final String loggerID;
    private String loginLogoutEventName;
    private LoginManager loginManager;
    private String loginText;
    private String logoutText;
    protected LoginButtonProperties properties;
    private boolean toolTipChecked;
    private long toolTipDisplayTime;
    private ToolTipMode toolTipMode;
    private ToolTipPopup toolTipPopup;
    private ToolTipPopup.Style toolTipStyle;

    /* renamed from: com.facebook.login.widget.LoginButton$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$login$widget$LoginButton$ToolTipMode;

        static {
            int[] iArr = new int[ToolTipMode.values().length];
            $SwitchMap$com$facebook$login$widget$LoginButton$ToolTipMode = iArr;
            try {
                iArr[ToolTipMode.AUTOMATIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$facebook$login$widget$LoginButton$ToolTipMode[ToolTipMode.DISPLAY_ALWAYS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$facebook$login$widget$LoginButton$ToolTipMode[ToolTipMode.NEVER_DISPLAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static class LoginButtonProperties {

        @Nullable
        private String messengerPageId;
        private boolean resetMessengerState;
        private DefaultAudience defaultAudience = DefaultAudience.FRIENDS;
        private List<String> permissions = Collections.emptyList();
        private LoginBehavior loginBehavior = LoginBehavior.NATIVE_WITH_FALLBACK;
        private String authType = ServerProtocol.DIALOG_REREQUEST_AUTH_TYPE;
        private LoginTargetApp targetApp = LoginTargetApp.FACEBOOK;
        private boolean shouldSkipAccountDeduplication = false;

        LoginButtonProperties() {
        }

        public void clearPermissions() {
            this.permissions = null;
        }

        public String getAuthType() {
            return this.authType;
        }

        public DefaultAudience getDefaultAudience() {
            return this.defaultAudience;
        }

        public LoginBehavior getLoginBehavior() {
            return this.loginBehavior;
        }

        public LoginTargetApp getLoginTargetApp() {
            return this.targetApp;
        }

        @Nullable
        public String getMessengerPageId() {
            return this.messengerPageId;
        }

        List<String> getPermissions() {
            return this.permissions;
        }

        public boolean getResetMessengerState() {
            return this.resetMessengerState;
        }

        public boolean getShouldSkipAccountDeduplication() {
            return this.shouldSkipAccountDeduplication;
        }

        public void setAuthType(String str) {
            this.authType = str;
        }

        public void setDefaultAudience(DefaultAudience defaultAudience) {
            this.defaultAudience = defaultAudience;
        }

        public void setLoginBehavior(LoginBehavior loginBehavior) {
            this.loginBehavior = loginBehavior;
        }

        public void setLoginTargetApp(LoginTargetApp loginTargetApp) {
            this.targetApp = loginTargetApp;
        }

        public void setMessengerPageId(@Nullable String str) {
            this.messengerPageId = str;
        }

        public void setPermissions(List<String> list) {
            this.permissions = list;
        }

        public void setResetMessengerState(boolean z2) {
            this.resetMessengerState = z2;
        }

        protected void setShouldSkipAccountDeduplication(boolean z2) {
            this.shouldSkipAccountDeduplication = z2;
        }
    }

    protected class LoginClickListener implements View.OnClickListener {
        protected LoginClickListener() {
        }

        protected LoginManager getLoginManager() {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                LoginManager loginManager = LoginManager.getInstance();
                loginManager.setDefaultAudience(LoginButton.this.getDefaultAudience());
                loginManager.setLoginBehavior(LoginButton.this.getLoginBehavior());
                loginManager.setLoginTargetApp(getLoginTargetApp());
                loginManager.setAuthType(LoginButton.this.getAuthType());
                loginManager.setFamilyLogin(isFamilyLogin());
                loginManager.setShouldSkipAccountDeduplication(LoginButton.this.getShouldSkipAccountDeduplication());
                loginManager.setMessengerPageId(LoginButton.this.getMessengerPageId());
                loginManager.setResetMessengerState(LoginButton.this.getResetMessengerState());
                return loginManager;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
                return null;
            }
        }

        protected LoginTargetApp getLoginTargetApp() {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                return LoginTargetApp.FACEBOOK;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
                return null;
            }
        }

        protected boolean isFamilyLogin() {
            CrashShieldHandler.isObjectCrashing(this);
            return false;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                LoginButton.this.callExternalOnClickListener(view);
                AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
                if (AccessToken.isCurrentAccessTokenActive()) {
                    performLogout(LoginButton.this.getContext());
                } else {
                    performLogin();
                }
                InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(LoginButton.this.getContext());
                Bundle bundle = new Bundle();
                bundle.putInt("logging_in", currentAccessToken != null ? 0 : 1);
                bundle.putInt("access_token_expired", AccessToken.isCurrentAccessTokenActive() ? 1 : 0);
                internalAppEventsLogger.logEventImplicitly(LoginButton.this.loginLogoutEventName, bundle);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }

        protected void performLogin() {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                LoginManager loginManager = getLoginManager();
                if (LoginButton.this.androidXLoginCaller != null) {
                    ((LoginManager.FacebookLoginActivityResultContract) LoginButton.this.androidXLoginCaller.a()).setCallbackManager(LoginButton.this.callbackManager != null ? LoginButton.this.callbackManager : new CallbackManagerImpl());
                    LoginButton.this.androidXLoginCaller.b(LoginButton.this.properties.permissions);
                } else if (LoginButton.this.getFragment() != null) {
                    loginManager.logIn(LoginButton.this.getFragment(), LoginButton.this.properties.permissions, LoginButton.this.getLoggerID());
                } else if (LoginButton.this.getNativeFragment() != null) {
                    loginManager.logIn(LoginButton.this.getNativeFragment(), LoginButton.this.properties.permissions, LoginButton.this.getLoggerID());
                } else {
                    loginManager.logIn(LoginButton.this.getActivity(), LoginButton.this.properties.permissions, LoginButton.this.getLoggerID());
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }

        protected void performLogout(Context context) {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                final LoginManager loginManager = getLoginManager();
                if (!LoginButton.this.confirmLogout) {
                    loginManager.logOut();
                    return;
                }
                String string = LoginButton.this.getResources().getString(R.string.com_facebook_loginview_log_out_action);
                String string2 = LoginButton.this.getResources().getString(R.string.com_facebook_loginview_cancel_action);
                Profile currentProfile = Profile.getCurrentProfile();
                String string3 = (currentProfile == null || currentProfile.getName() == null) ? LoginButton.this.getResources().getString(R.string.com_facebook_loginview_logged_in_using_facebook) : String.format(LoginButton.this.getResources().getString(R.string.com_facebook_loginview_logged_in_as), currentProfile.getName());
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage(string3).setCancelable(true).setPositiveButton(string, new DialogInterface.OnClickListener() { // from class: com.facebook.login.widget.LoginButton.LoginClickListener.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        loginManager.logOut();
                    }
                }).setNegativeButton(string2, (DialogInterface.OnClickListener) null);
                builder.create().show();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public enum ToolTipMode {
        AUTOMATIC(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_AUTOMATIC, 0),
        DISPLAY_ALWAYS("display_always", 1),
        NEVER_DISPLAY("never_display", 2);

        public static ToolTipMode DEFAULT = AUTOMATIC;
        private int intValue;
        private String stringValue;

        ToolTipMode(String str, int i2) {
            this.stringValue = str;
            this.intValue = i2;
        }

        public static ToolTipMode fromInt(int i2) {
            for (ToolTipMode toolTipMode : values()) {
                if (toolTipMode.getValue() == i2) {
                    return toolTipMode;
                }
            }
            return null;
        }

        public int getValue() {
            return this.intValue;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.stringValue;
        }
    }

    public LoginButton(Context context) {
        this(context, null, 0, 0, AnalyticsEvents.EVENT_LOGIN_BUTTON_CREATE, AnalyticsEvents.EVENT_LOGIN_BUTTON_DID_TAP);
    }

    private void checkToolTipSettings() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            int i2 = AnonymousClass4.$SwitchMap$com$facebook$login$widget$LoginButton$ToolTipMode[this.toolTipMode.ordinal()];
            if (i2 == 1) {
                final String metadataApplicationId = Utility.getMetadataApplicationId(getContext());
                FacebookSdk.getExecutor().execute(new Runnable() { // from class: com.facebook.login.widget.LoginButton.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (CrashShieldHandler.isObjectCrashing(this)) {
                            return;
                        }
                        try {
                            final FetchedAppSettings fetchedAppSettingsQueryAppSettings = FetchedAppSettingsManager.queryAppSettings(metadataApplicationId, false);
                            LoginButton.this.getActivity().runOnUiThread(new Runnable() { // from class: com.facebook.login.widget.LoginButton.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (CrashShieldHandler.isObjectCrashing(this)) {
                                        return;
                                    }
                                    try {
                                        LoginButton.this.showToolTipPerSettings(fetchedAppSettingsQueryAppSettings);
                                    } catch (Throwable th) {
                                        CrashShieldHandler.handleThrowable(th, this);
                                    }
                                }
                            });
                        } catch (Throwable th) {
                            CrashShieldHandler.handleThrowable(th, this);
                        }
                    }
                });
            } else {
                if (i2 != 2) {
                    return;
                }
                displayToolTip(getResources().getString(R.string.com_facebook_tooltip_default));
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private void displayToolTip(String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            ToolTipPopup toolTipPopup = new ToolTipPopup(str, this);
            this.toolTipPopup = toolTipPopup;
            toolTipPopup.setStyle(this.toolTipStyle);
            this.toolTipPopup.setNuxDisplayTime(this.toolTipDisplayTime);
            this.toolTipPopup.show();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private int measureButtonWidth(String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            return getCompoundPaddingLeft() + getCompoundDrawablePadding() + measureTextWidth(str) + getCompoundPaddingRight();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToolTipPerSettings(FetchedAppSettings fetchedAppSettings) {
        if (CrashShieldHandler.isObjectCrashing(this) || fetchedAppSettings == null) {
            return;
        }
        try {
            if (fetchedAppSettings.getNuxEnabled() && getVisibility() == 0) {
                displayToolTip(fetchedAppSettings.getNuxContent());
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public void clearPermissions() {
        this.properties.clearPermissions();
    }

    @Override // com.facebook.FacebookButtonBase
    protected void configureButton(Context context, AttributeSet attributeSet, int i2, int i3) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            super.configureButton(context, attributeSet, i2, i3);
            setInternalOnClickListener(getNewLoginClickListener());
            parseLoginButtonAttributes(context, attributeSet, i2, i3);
            if (isInEditMode()) {
                setBackgroundColor(getResources().getColor(com.facebook.common.R.color.com_facebook_blue));
                this.loginText = "Continue with Facebook";
            } else {
                this.accessTokenTracker = new AccessTokenTracker() { // from class: com.facebook.login.widget.LoginButton.3
                    @Override // com.facebook.AccessTokenTracker
                    protected void onCurrentAccessTokenChanged(AccessToken accessToken, AccessToken accessToken2) {
                        LoginButton.this.setButtonText();
                        LoginButton.this.setButtonIcon();
                    }
                };
            }
            setButtonText();
            setButtonRadius();
            setButtonTransparency();
            setButtonIcon();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public void dismissToolTip() {
        ToolTipPopup toolTipPopup = this.toolTipPopup;
        if (toolTipPopup != null) {
            toolTipPopup.dismiss();
            this.toolTipPopup = null;
        }
    }

    public String getAuthType() {
        return this.properties.getAuthType();
    }

    @Nullable
    public CallbackManager getCallbackManager() {
        return this.callbackManager;
    }

    public DefaultAudience getDefaultAudience() {
        return this.properties.getDefaultAudience();
    }

    @Override // com.facebook.FacebookButtonBase
    protected int getDefaultRequestCode() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            return CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return 0;
        }
    }

    @Override // com.facebook.FacebookButtonBase
    protected int getDefaultStyleResource() {
        return R.style.com_facebook_loginview_default_style;
    }

    public String getLoggerID() {
        return this.loggerID;
    }

    public LoginBehavior getLoginBehavior() {
        return this.properties.getLoginBehavior();
    }

    @StringRes
    protected int getLoginButtonContinueLabel() {
        return R.string.com_facebook_loginview_log_in_button_continue;
    }

    protected int getLoginButtonWidth(int i2) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            Resources resources = getResources();
            String string = this.loginText;
            if (string == null) {
                string = resources.getString(R.string.com_facebook_loginview_log_in_button_continue);
                int iMeasureButtonWidth = measureButtonWidth(string);
                if (View.resolveSize(iMeasureButtonWidth, i2) < iMeasureButtonWidth) {
                    string = resources.getString(R.string.com_facebook_loginview_log_in_button);
                }
            }
            return measureButtonWidth(string);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return 0;
        }
    }

    LoginManager getLoginManager() {
        if (this.loginManager == null) {
            this.loginManager = LoginManager.getInstance();
        }
        return this.loginManager;
    }

    public LoginTargetApp getLoginTargetApp() {
        return this.properties.getLoginTargetApp();
    }

    @Nullable
    public String getMessengerPageId() {
        return this.properties.getMessengerPageId();
    }

    protected LoginClickListener getNewLoginClickListener() {
        return new LoginClickListener();
    }

    List<String> getPermissions() {
        return this.properties.getPermissions();
    }

    public boolean getResetMessengerState() {
        return this.properties.getResetMessengerState();
    }

    public boolean getShouldSkipAccountDeduplication() {
        return this.properties.getShouldSkipAccountDeduplication();
    }

    public long getToolTipDisplayTime() {
        return this.toolTipDisplayTime;
    }

    public ToolTipMode getToolTipMode() {
        return this.toolTipMode;
    }

    @Override // com.facebook.FacebookButtonBase, android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            super.onAttachedToWindow();
            if (getContext() instanceof c) {
                this.androidXLoginCaller = ((c) getContext()).getActivityResultRegistry().j("facebook-login", getLoginManager().createLogInActivityResultContract(this.callbackManager, this.loggerID), new android.view.result.a<CallbackManager.ActivityResultParameters>() { // from class: com.facebook.login.widget.LoginButton.1
                    @Override // android.view.result.a
                    public void onActivityResult(CallbackManager.ActivityResultParameters activityResultParameters) {
                    }
                });
            }
            AccessTokenTracker accessTokenTracker = this.accessTokenTracker;
            if (accessTokenTracker == null || accessTokenTracker.getIsTracking()) {
                return;
            }
            this.accessTokenTracker.startTracking();
            setButtonText();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            super.onDetachedFromWindow();
            android.view.result.b<Collection<? extends String>> bVar = this.androidXLoginCaller;
            if (bVar != null) {
                bVar.d();
            }
            AccessTokenTracker accessTokenTracker = this.accessTokenTracker;
            if (accessTokenTracker != null) {
                accessTokenTracker.stopTracking();
            }
            dismissToolTip();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @Override // com.facebook.FacebookButtonBase, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            super.onDraw(canvas);
            if (this.toolTipChecked || isInEditMode()) {
                return;
            }
            this.toolTipChecked = true;
            checkToolTipSettings();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            super.onLayout(z2, i2, i3, i4, i5);
            setButtonText();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i2, int i3) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
            int compoundPaddingTop = getCompoundPaddingTop() + ((int) Math.ceil(Math.abs(fontMetrics.top) + Math.abs(fontMetrics.bottom))) + getCompoundPaddingBottom();
            Resources resources = getResources();
            int loginButtonWidth = getLoginButtonWidth(i2);
            String string = this.logoutText;
            if (string == null) {
                string = resources.getString(R.string.com_facebook_loginview_log_out_button);
            }
            setMeasuredDimension(View.resolveSize(Math.max(loginButtonWidth, measureButtonWidth(string)), i2), compoundPaddingTop);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onVisibilityChanged(View view, int i2) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            super.onVisibilityChanged(view, i2);
            if (i2 != 0) {
                dismissToolTip();
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    protected void parseLoginButtonAttributes(Context context, AttributeSet attributeSet, int i2, int i3) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            this.toolTipMode = ToolTipMode.DEFAULT;
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.com_facebook_login_view, i2, i3);
            try {
                this.confirmLogout = typedArrayObtainStyledAttributes.getBoolean(R.styleable.com_facebook_login_view_com_facebook_confirm_logout, true);
                this.loginText = typedArrayObtainStyledAttributes.getString(R.styleable.com_facebook_login_view_com_facebook_login_text);
                this.logoutText = typedArrayObtainStyledAttributes.getString(R.styleable.com_facebook_login_view_com_facebook_logout_text);
                this.toolTipMode = ToolTipMode.fromInt(typedArrayObtainStyledAttributes.getInt(R.styleable.com_facebook_login_view_com_facebook_tooltip_mode, ToolTipMode.DEFAULT.getValue()));
                int i4 = R.styleable.com_facebook_login_view_com_facebook_login_button_radius;
                if (typedArrayObtainStyledAttributes.hasValue(i4)) {
                    this.customButtonRadius = Float.valueOf(typedArrayObtainStyledAttributes.getDimension(i4, 0.0f));
                }
                int integer = typedArrayObtainStyledAttributes.getInteger(R.styleable.com_facebook_login_view_com_facebook_login_button_transparency, MAX_BUTTON_TRANSPARENCY);
                this.customButtonTransparency = integer;
                if (integer < 0) {
                    this.customButtonTransparency = 0;
                }
                if (this.customButtonTransparency > MAX_BUTTON_TRANSPARENCY) {
                    this.customButtonTransparency = MAX_BUTTON_TRANSPARENCY;
                }
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public void registerCallback(CallbackManager callbackManager, FacebookCallback<LoginResult> facebookCallback) {
        getLoginManager().registerCallback(callbackManager, facebookCallback);
        CallbackManager callbackManager2 = this.callbackManager;
        if (callbackManager2 == null) {
            this.callbackManager = callbackManager;
        } else if (callbackManager2 != callbackManager) {
            Log.w(TAG, "You're registering a callback on the one Facebook login button with two different callback managers. It's almost wrong and may cause unexpected results. Only the first callback manager will be used for handling activity result with androidx.");
        }
    }

    public void setAuthType(String str) {
        this.properties.setAuthType(str);
    }

    protected void setButtonIcon() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            setCompoundDrawablesWithIntrinsicBounds(a_e.b(getContext(), com.facebook.common.R.drawable.com_facebook_button_icon), (Drawable) null, (Drawable) null, (Drawable) null);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @TargetApi(29)
    protected void setButtonRadius() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if (this.customButtonRadius == null) {
                return;
            }
            Drawable background = getBackground();
            if (Build.VERSION.SDK_INT >= 29 && (background instanceof StateListDrawable)) {
                StateListDrawable stateListDrawable = (StateListDrawable) background;
                for (int i2 = 0; i2 < stateListDrawable.getStateCount(); i2++) {
                    GradientDrawable gradientDrawable = (GradientDrawable) stateListDrawable.getStateDrawable(i2);
                    if (gradientDrawable != null) {
                        gradientDrawable.setCornerRadius(this.customButtonRadius.floatValue());
                    }
                }
            }
            if (background instanceof GradientDrawable) {
                ((GradientDrawable) background).setCornerRadius(this.customButtonRadius.floatValue());
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    protected void setButtonText() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Resources resources = getResources();
            if (!isInEditMode() && AccessToken.isCurrentAccessTokenActive()) {
                String string = this.logoutText;
                if (string == null) {
                    string = resources.getString(R.string.com_facebook_loginview_log_out_button);
                }
                setText(string);
                return;
            }
            String str = this.loginText;
            if (str != null) {
                setText(str);
                return;
            }
            String string2 = resources.getString(getLoginButtonContinueLabel());
            int width = getWidth();
            if (width != 0 && measureButtonWidth(string2) > width) {
                string2 = resources.getString(R.string.com_facebook_loginview_log_in_button);
            }
            setText(string2);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    protected void setButtonTransparency() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            getBackground().setAlpha(this.customButtonTransparency);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public void setDefaultAudience(DefaultAudience defaultAudience) {
        this.properties.setDefaultAudience(defaultAudience);
    }

    public void setLoginBehavior(LoginBehavior loginBehavior) {
        this.properties.setLoginBehavior(loginBehavior);
    }

    void setLoginManager(LoginManager loginManager) {
        this.loginManager = loginManager;
    }

    public void setLoginTargetApp(LoginTargetApp loginTargetApp) {
        this.properties.setLoginTargetApp(loginTargetApp);
    }

    public void setLoginText(String str) {
        this.loginText = str;
        setButtonText();
    }

    public void setLogoutText(String str) {
        this.logoutText = str;
        setButtonText();
    }

    public void setMessengerPageId(String str) {
        this.properties.setMessengerPageId(str);
    }

    public void setPermissions(List<String> list) {
        this.properties.setPermissions(list);
    }

    void setProperties(LoginButtonProperties loginButtonProperties) {
        this.properties = loginButtonProperties;
    }

    public void setPublishPermissions(List<String> list) {
        this.properties.setPermissions(list);
    }

    public void setReadPermissions(List<String> list) {
        this.properties.setPermissions(list);
    }

    public void setResetMessengerState(boolean z2) {
        this.properties.setResetMessengerState(z2);
    }

    public void setToolTipDisplayTime(long j2) {
        this.toolTipDisplayTime = j2;
    }

    public void setToolTipMode(ToolTipMode toolTipMode) {
        this.toolTipMode = toolTipMode;
    }

    public void setToolTipStyle(ToolTipPopup.Style style) {
        this.toolTipStyle = style;
    }

    public void unregisterCallback(CallbackManager callbackManager) {
        getLoginManager().unregisterCallback(callbackManager);
    }

    public LoginButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, AnalyticsEvents.EVENT_LOGIN_BUTTON_CREATE, AnalyticsEvents.EVENT_LOGIN_BUTTON_DID_TAP);
    }

    public void setPermissions(String... strArr) {
        this.properties.setPermissions(Arrays.asList(strArr));
    }

    public void setPublishPermissions(String... strArr) {
        this.properties.setPermissions(Arrays.asList(strArr));
    }

    public void setReadPermissions(String... strArr) {
        this.properties.setPermissions(Arrays.asList(strArr));
    }

    public LoginButton(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0, AnalyticsEvents.EVENT_LOGIN_BUTTON_CREATE, AnalyticsEvents.EVENT_LOGIN_BUTTON_DID_TAP);
    }

    protected LoginButton(Context context, AttributeSet attributeSet, int i2, int i3, String str, String str2) {
        super(context, attributeSet, i2, i3, str, str2);
        this.properties = new LoginButtonProperties();
        this.loginLogoutEventName = AnalyticsEvents.EVENT_LOGIN_VIEW_USAGE;
        this.toolTipStyle = ToolTipPopup.Style.BLUE;
        this.toolTipDisplayTime = ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME;
        this.customButtonTransparency = MAX_BUTTON_TRANSPARENCY;
        this.loggerID = UUID.randomUUID().toString();
        this.callbackManager = null;
        this.androidXLoginCaller = null;
    }
}
