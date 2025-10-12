package com.ykiocnwpdseglq.nhvkwyj.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookAuthorizationException;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.share.internal.ShareConstants;
import com.ykiocnwpdseglq.lbmntzwepqakgu.beans.FbLoginResult;
import com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.LoginCallBack;
import com.ykiocnwpdseglq.nhvkwyj.utils.LogUtil;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class EBQaRydFb {
    private static EBQaRydFb instance;
    private CallbackManager callbackManager;
    private FbLoginResult fbLoginResult;
    private LoginCallBack loginCallBack;
    private boolean isUseLogin = false;
    private boolean fbUInfoSuccess = false;
    private boolean fbMapInfoSuccess = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void fbLoginPlatform() {
        if (this.fbUInfoSuccess && this.fbMapInfoSuccess) {
            LoginCallBack loginCallBack = this.loginCallBack;
            if (loginCallBack != null) {
                loginCallBack.onSuccess(this.fbLoginResult);
            }
            this.fbUInfoSuccess = false;
            this.fbMapInfoSuccess = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getFbMapInfo(LoginResult loginResult) {
        new GraphRequest(loginResult.getAccessToken(), "/me/ids_for_business", new Bundle(), HttpMethod.GET, new GraphRequest.Callback() { // from class: com.ykiocnwpdseglq.nhvkwyj.login.EBQaRydFb.4
            @Override // com.facebook.GraphRequest.Callback
            public void onCompleted(GraphResponse graphResponse) throws JSONException {
                LogUtil.e("get fb Map Info complete");
                JSONObject graphObject = graphResponse.getGraphObject();
                if (graphObject != null && graphObject.optJSONArray(ShareConstants.WEB_DIALOG_PARAM_DATA) != null && graphObject.optJSONArray(ShareConstants.WEB_DIALOG_PARAM_DATA).length() != 0) {
                    JSONArray jSONArrayOptJSONArray = graphObject.optJSONArray(ShareConstants.WEB_DIALOG_PARAM_DATA);
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                        try {
                            JSONObject jSONObject = jSONArrayOptJSONArray.getJSONObject(i2);
                            String string = jSONObject.getString("id");
                            String string2 = jSONObject.getJSONObject("app").getString("id");
                            jSONObject.remove("app");
                            jSONObject.remove("id");
                            jSONObject.put("fbId", string2);
                            jSONObject.put("scopeId", string);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    EBQaRydFb.this.fbLoginResult.setFbBusinessMapStr(jSONArrayOptJSONArray.toString());
                }
                EBQaRydFb.this.fbMapInfoSuccess = true;
                EBQaRydFb.this.fbLoginPlatform();
            }
        }).executeAsync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getFbUserInfo(LoginResult loginResult) {
        Bundle bundle = new Bundle();
        bundle.putString(GraphRequest.FIELDS_PARAM, "id,name,email");
        new GraphRequest(loginResult.getAccessToken(), "/me", bundle, HttpMethod.GET, new GraphRequest.Callback() { // from class: com.ykiocnwpdseglq.nhvkwyj.login.EBQaRydFb.3
            @Override // com.facebook.GraphRequest.Callback
            public void onCompleted(GraphResponse graphResponse) {
                LogUtil.e("get fb user Info complete");
                if (graphResponse.getGraphObject() == null || graphResponse.getGraphObject().length() == 0) {
                    return;
                }
                EBQaRydFb.this.fbLoginResult.setNickName(graphResponse.getGraphObject().optString("name"));
                EBQaRydFb.this.fbLoginResult.setEmail(graphResponse.getGraphObject().optString("email"));
                EBQaRydFb.this.fbLoginResult.setThirdId(graphResponse.getGraphObject().optString("id"));
                EBQaRydFb.this.fbUInfoSuccess = true;
                EBQaRydFb.this.fbLoginPlatform();
            }
        }).executeAsync();
    }

    public static EBQaRydFb getInstance() {
        if (instance == null) {
            instance = new EBQaRydFb();
        }
        return instance;
    }

    private void registerCallBack() {
        this.callbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(this.callbackManager, new FacebookCallback<LoginResult>() { // from class: com.ykiocnwpdseglq.nhvkwyj.login.EBQaRydFb.2
            @Override // com.facebook.FacebookCallback
            public void onCancel() {
                LogUtil.e("LoginManager callback cancel");
                if (EBQaRydFb.this.loginCallBack != null) {
                    EBQaRydFb.this.loginCallBack.onCancel();
                }
            }

            @Override // com.facebook.FacebookCallback
            public void onError(FacebookException facebookException) {
                LogUtil.e("LoginManager callback Error : " + facebookException.getMessage());
                facebookException.printStackTrace();
                if ((facebookException instanceof FacebookAuthorizationException) && AccessToken.getCurrentAccessToken() != null) {
                    LoginManager.getInstance().logOut();
                }
                if (EBQaRydFb.this.loginCallBack != null) {
                    EBQaRydFb.this.loginCallBack.onError(facebookException.getMessage());
                }
            }

            @Override // com.facebook.FacebookCallback
            public void onSuccess(LoginResult loginResult) {
                LogUtil.e("LoginManager callback success!");
                EBQaRydFb.this.getFbUserInfo(loginResult);
                EBQaRydFb.this.getFbMapInfo(loginResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLogin(Activity activity) {
        this.isUseLogin = true;
        this.fbLoginResult = new FbLoginResult();
        registerCallBack();
        LoginManager.getInstance().logInWithReadPermissions(activity, Arrays.asList("public_profile", "email"));
    }

    public void login(final Activity activity, LoginCallBack loginCallBack) {
        this.loginCallBack = loginCallBack;
        if (FacebookSdk.isInitialized()) {
            startLogin(activity);
        } else {
            FacebookSdk.sdkInitialize(activity, new FacebookSdk.InitializeCallback() { // from class: com.ykiocnwpdseglq.nhvkwyj.login.EBQaRydFb.1
                @Override // com.facebook.FacebookSdk.InitializeCallback
                public void onInitialized() {
                    EBQaRydFb.this.startLogin(activity);
                }
            });
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        LogUtil.e("fb login onActivityResult " + this.isUseLogin);
        if (this.isUseLogin) {
            this.callbackManager.onActivityResult(i2, i3, intent);
            this.isUseLogin = false;
        }
    }
}
