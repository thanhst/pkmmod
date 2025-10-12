package com.ykiocnwpdseglq.nhvkwyj.social;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.AuthenticationTokenClaims;
import com.facebook.CallbackManager;
import com.facebook.FacebookAuthorizationException;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareDialog;
import com.ykiocnwpdseglq.lbmntzwepqakgu.beans.XWxHieRucvXCI;
import com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.JFjDWQslLwygrKe;
import com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.UJDWpUn;
import java.util.Arrays;

/* loaded from: classes.dex */
public class CSueJN {
    private static CSueJN instance;
    private AccessToken accessToken;
    private CallbackManager callbackManager;
    private JFjDWQslLwygrKe getFriendsCallBack;
    private String postId;
    private ShareDialog shareDialog;
    private ShareLinkContent shareLinkContent;
    private SharePhotoContent sharePhotoContent;
    private UJDWpUn socialCallBack;
    private ActionType currentAction = ActionType.NULL;
    private boolean isUseSocial = false;

    /* renamed from: com.ykiocnwpdseglq.nhvkwyj.social.CSueJN$5, reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$com$ykiocnwpdseglq$nhvkwyj$social$CSueJN$ActionType;

        static {
            int[] iArr = new int[ActionType.values().length];
            $SwitchMap$com$ykiocnwpdseglq$nhvkwyj$social$CSueJN$ActionType = iArr;
            try {
                iArr[ActionType.SHARE_PHOTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ykiocnwpdseglq$nhvkwyj$social$CSueJN$ActionType[ActionType.SHARE_LINK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ykiocnwpdseglq$nhvkwyj$social$CSueJN$ActionType[ActionType.INVITE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ykiocnwpdseglq$nhvkwyj$social$CSueJN$ActionType[ActionType.LIKE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ykiocnwpdseglq$nhvkwyj$social$CSueJN$ActionType[ActionType.FRIEND_LIST.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private enum ActionType {
        SHARE_PHOTO,
        SHARE_LINK,
        INVITE,
        LIKE,
        FRIEND_LIST,
        NULL
    }

    public static CSueJN getInstance() {
        if (instance == null) {
            instance = new CSueJN();
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getUserInfo() {
        Bundle bundle = new Bundle();
        bundle.putString(GraphRequest.FIELDS_PARAM, "id,name,email");
        new GraphRequest(this.accessToken, "/me", bundle, HttpMethod.GET, new GraphRequest.Callback() { // from class: com.ykiocnwpdseglq.nhvkwyj.social.CSueJN.3
            @Override // com.facebook.GraphRequest.Callback
            public void onCompleted(GraphResponse graphResponse) {
                XWxHieRucvXCI xWxHieRucvXCI = new XWxHieRucvXCI();
                xWxHieRucvXCI.setFbUserId(graphResponse.getGraphObject().optString("id"));
                xWxHieRucvXCI.setNickName(graphResponse.getGraphObject().optString("name"));
                xWxHieRucvXCI.setEmail(graphResponse.getGraphObject().optString("email"));
                if (CSueJN.this.currentAction == ActionType.SHARE_LINK || CSueJN.this.currentAction == ActionType.SHARE_PHOTO) {
                    xWxHieRucvXCI.setPostId(CSueJN.this.postId);
                }
                if (CSueJN.this.socialCallBack != null) {
                    CSueJN.this.socialCallBack.onSuccess(xWxHieRucvXCI);
                }
            }
        }).executeAsync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void graphRequestFriendList() {
        Bundle bundle = new Bundle();
        bundle.putString(GraphRequest.FIELDS_PARAM, "id,name,email");
        new GraphRequest(this.accessToken, "/me/friends", bundle, HttpMethod.GET, new GraphRequest.Callback() { // from class: com.ykiocnwpdseglq.nhvkwyj.social.CSueJN.2
            @Override // com.facebook.GraphRequest.Callback
            public void onCompleted(GraphResponse graphResponse) {
                if (graphResponse.getError() == null) {
                    if (CSueJN.this.getFriendsCallBack != null) {
                        CSueJN.this.getFriendsCallBack.onSuccess(graphResponse.getRawResponse());
                    }
                } else if (CSueJN.this.getFriendsCallBack != null) {
                    CSueJN.this.getFriendsCallBack.onError(graphResponse.getError().getErrorMessage());
                }
            }
        }).executeAsync();
    }

    private void initShareDialog(Activity activity) {
        ShareDialog shareDialog = new ShareDialog(activity);
        this.shareDialog = shareDialog;
        shareDialog.registerCallback(this.callbackManager, new FacebookCallback<Sharer.Result>() { // from class: com.ykiocnwpdseglq.nhvkwyj.social.CSueJN.1
            @Override // com.facebook.FacebookCallback
            public void onCancel() {
                if (CSueJN.this.socialCallBack != null) {
                    CSueJN.this.socialCallBack.onCancel();
                }
            }

            @Override // com.facebook.FacebookCallback
            public void onError(FacebookException facebookException) {
                if (CSueJN.this.socialCallBack != null) {
                    CSueJN.this.socialCallBack.onError();
                }
            }

            @Override // com.facebook.FacebookCallback
            public void onSuccess(Sharer.Result result) {
                CSueJN.this.postId = result.getPostId();
                CSueJN.this.getUserInfo();
            }
        });
    }

    private void registerCallBack(final Activity activity) {
        this.callbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(this.callbackManager, new FacebookCallback<LoginResult>() { // from class: com.ykiocnwpdseglq.nhvkwyj.social.CSueJN.4
            @Override // com.facebook.FacebookCallback
            public void onCancel() {
                if (CSueJN.this.socialCallBack != null) {
                    CSueJN.this.socialCallBack.onCancel();
                }
            }

            @Override // com.facebook.FacebookCallback
            public void onError(FacebookException facebookException) {
                if ((facebookException instanceof FacebookAuthorizationException) && AccessToken.getCurrentAccessToken() != null) {
                    LoginManager.getInstance().logOut();
                }
                if (CSueJN.this.socialCallBack != null) {
                    CSueJN.this.socialCallBack.onError();
                }
            }

            @Override // com.facebook.FacebookCallback
            public void onSuccess(LoginResult loginResult) {
                CSueJN.this.accessToken = loginResult.getAccessToken();
                int i2 = AnonymousClass5.$SwitchMap$com$ykiocnwpdseglq$nhvkwyj$social$CSueJN$ActionType[CSueJN.this.currentAction.ordinal()];
                if (i2 == 1) {
                    CSueJN.this.showPhotoShareDialog(activity);
                } else if (i2 == 2) {
                    CSueJN.this.showLinkShareDialog(activity);
                } else {
                    if (i2 != 5) {
                        return;
                    }
                    CSueJN.this.graphRequestFriendList();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLinkShareDialog(Activity activity) {
        if (ShareDialog.canShow((Class<? extends ShareContent<?, ?>>) ShareLinkContent.class)) {
            this.shareDialog.show(this.shareLinkContent);
        } else {
            LoginManager.getInstance().logInWithPublishPermissions(activity, Arrays.asList("publish_actions"));
            Log.d("FBLikeError:", "LikeDialog cannot show");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPhotoShareDialog(Activity activity) {
        if (ShareDialog.canShow((Class<? extends ShareContent<?, ?>>) SharePhotoContent.class)) {
            this.shareDialog.show(this.sharePhotoContent);
        } else {
            LoginManager.getInstance().logInWithPublishPermissions(activity, Arrays.asList("publish_actions"));
            Log.d("FBShareError:", "shareDialog cannot show");
        }
    }

    public void getFriendsList(Activity activity, JFjDWQslLwygrKe jFjDWQslLwygrKe) {
        this.isUseSocial = true;
        this.currentAction = ActionType.FRIEND_LIST;
        this.getFriendsCallBack = jFjDWQslLwygrKe;
        LoginManager.getInstance().logInWithReadPermissions(activity, Arrays.asList("public_profile", "email", AuthenticationTokenClaims.JSON_KEY_USER_FRIENDS));
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (this.isUseSocial) {
            this.callbackManager.onActivityResult(i2, i3, intent);
            this.isUseSocial = false;
        }
    }

    public void shareLink(Activity activity, String str, UJDWpUn uJDWpUn) {
        this.isUseSocial = true;
        this.currentAction = ActionType.SHARE_LINK;
        this.socialCallBack = uJDWpUn;
        initShareDialog(activity);
        registerCallBack(activity);
        this.shareLinkContent = new ShareLinkContent.Builder().setContentUrl(Uri.parse(str)).build();
        LoginManager.getInstance().logInWithPublishPermissions(activity, Arrays.asList("publish_actions"));
    }

    public void sharePhoto(Activity activity, Bitmap bitmap, UJDWpUn uJDWpUn) {
        this.isUseSocial = true;
        this.currentAction = ActionType.SHARE_PHOTO;
        this.socialCallBack = uJDWpUn;
        initShareDialog(activity);
        registerCallBack(activity);
        this.sharePhotoContent = new SharePhotoContent.Builder().addPhoto(new SharePhoto.Builder().setBitmap(bitmap).build()).build();
        LoginManager.getInstance().logInWithPublishPermissions(activity, Arrays.asList("publish_actions"));
    }

    public void sharePhoto(Activity activity, String str, UJDWpUn uJDWpUn) {
        this.isUseSocial = true;
        this.currentAction = ActionType.SHARE_PHOTO;
        this.socialCallBack = uJDWpUn;
        initShareDialog(activity);
        registerCallBack(activity);
        this.sharePhotoContent = new SharePhotoContent.Builder().addPhoto(new SharePhoto.Builder().setImageUrl(Uri.parse(str)).build()).build();
        LoginManager.getInstance().logInWithPublishPermissions(activity, Arrays.asList("publish_actions"));
    }

    public void sharePhoto(Activity activity, Uri uri, UJDWpUn uJDWpUn) {
        this.isUseSocial = true;
        this.currentAction = ActionType.SHARE_PHOTO;
        this.socialCallBack = uJDWpUn;
        initShareDialog(activity);
        registerCallBack(activity);
        this.sharePhotoContent = new SharePhotoContent.Builder().addPhoto(new SharePhoto.Builder().setImageUrl(uri).build()).build();
        LoginManager.getInstance().logInWithPublishPermissions(activity, Arrays.asList("publish_actions"));
    }
}
