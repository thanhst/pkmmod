package com.ykiocnwpdseglq.nhvkwyj.managers;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import com.facebook.FacebookSdk;
import com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.JFjDWQslLwygrKe;
import com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.LoginCallBack;
import com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.UJDWpUn;
import com.ykiocnwpdseglq.nhvkwyj.analysis.QQZLsIxEqfWSyg;
import com.ykiocnwpdseglq.nhvkwyj.login.EBQaRydFb;
import com.ykiocnwpdseglq.nhvkwyj.social.CSueJN;
import com.ykiocnwpdseglq.nhvkwyj.social.SystemShareHelper;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class YcmyEVJeuABnU {
    private static YcmyEVJeuABnU instance;

    public static YcmyEVJeuABnU getInstance() {
        if (instance == null) {
            instance = new YcmyEVJeuABnU();
        }
        return instance;
    }

    public void applicationOnCreate(Application application) {
        if (FacebookSdk.isInitialized()) {
            return;
        }
        FacebookSdk.sdkInitialize(application, new FacebookSdk.InitializeCallback() { // from class: com.ykiocnwpdseglq.nhvkwyj.managers.YcmyEVJeuABnU.1
            @Override // com.facebook.FacebookSdk.InitializeCallback
            public void onInitialized() {
            }
        });
    }

    public void eventCustom(Context context, String str, String str2) {
        QQZLsIxEqfWSyg.eventCustom(context, str, str2);
    }

    public void eventLogin(Context context, String str, String str2) {
        QQZLsIxEqfWSyg.eventLogin(context, str, str2);
    }

    public void eventPay(Context context, String str, String str2, String str3, double d2, String str4) {
        QQZLsIxEqfWSyg.eventPay(context, str, str2, str3, d2, str4);
    }

    public void eventRegister(Context context, String str, String str2) {
        QQZLsIxEqfWSyg.eventRegister(context, str, str2);
    }

    public void getFriendsList(Activity activity, JFjDWQslLwygrKe jFjDWQslLwygrKe) {
        CSueJN.getInstance().getFriendsList(activity, jFjDWQslLwygrKe);
    }

    public void login(Activity activity, LoginCallBack loginCallBack) {
        EBQaRydFb.getInstance().login(activity, loginCallBack);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        EBQaRydFb.getInstance().onActivityResult(i2, i3, intent);
        CSueJN.getInstance().onActivityResult(i2, i3, intent);
    }

    public void shareLink(Activity activity, String str, UJDWpUn uJDWpUn) {
        CSueJN.getInstance().shareLink(activity, str, uJDWpUn);
    }

    public void sharePhoto(Activity activity, Bitmap bitmap, UJDWpUn uJDWpUn) {
        CSueJN.getInstance().sharePhoto(activity, bitmap, uJDWpUn);
    }

    public void systemSharePhoto(Activity activity, String str, String str2) {
        SystemShareHelper.getInstance().sharePhoto(activity, str, str2);
    }

    public void systemSharePhotos(Activity activity, ArrayList<Uri> arrayList, String str) {
        SystemShareHelper.getInstance().sharePhotos(activity, arrayList, str);
    }

    public void systemShareTxt(Activity activity, String str, String str2) {
        SystemShareHelper.getInstance().shareText(activity, str, str2);
    }

    public void sharePhoto(Activity activity, String str, UJDWpUn uJDWpUn) {
        CSueJN.getInstance().sharePhoto(activity, str, uJDWpUn);
    }

    public void sharePhoto(Activity activity, Uri uri, UJDWpUn uJDWpUn) {
        CSueJN.getInstance().sharePhoto(activity, uri, uJDWpUn);
    }
}
