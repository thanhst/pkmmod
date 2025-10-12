package com.ykiocnwpdseglq.nhvkwyj;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.JFjDWQslLwygrKe;
import com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.JsQpvRdkwX;
import com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.LoginCallBack;
import com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.UJDWpUn;
import com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.VKiwrnDgpL;
import com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.ZNyuaGhRckJjEA;
import com.ykiocnwpdseglq.nhvkwyj.managers.YcmyEVJeuABnU;
import com.ykiocnwpdseglq.nhvkwyj.utils.LogUtil;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class BNvGRxpPTguECUw implements ZNyuaGhRckJjEA, JsQpvRdkwX, VKiwrnDgpL {
    public static void getFriendsList(Activity activity, JFjDWQslLwygrKe jFjDWQslLwygrKe) {
        YcmyEVJeuABnU.getInstance().getFriendsList(activity, jFjDWQslLwygrKe);
    }

    public static void sharePhotoBySystem(Activity activity, String str, String str2) {
        YcmyEVJeuABnU.getInstance().systemSharePhoto(activity, str, str2);
    }

    public static void sharePhotosBySystem(Activity activity, ArrayList<Uri> arrayList, String str) {
        YcmyEVJeuABnU.getInstance().systemSharePhotos(activity, arrayList, str);
    }

    public static void shareTxtBySystem(Activity activity, String str, String str2) {
        YcmyEVJeuABnU.getInstance().systemShareTxt(activity, str, str2);
    }

    @Override // com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.SomnJeaLs
    public void applicationAttachBaseContext(Context context) {
    }

    @Override // com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.SomnJeaLs
    public void applicationOnCreate(Application application) {
        YcmyEVJeuABnU.getInstance().applicationOnCreate(application);
    }

    @Override // com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.VKiwrnDgpL
    public void eventCustom(Context context, String str, String str2) {
        YcmyEVJeuABnU.getInstance().eventCustom(context, str, str2);
    }

    @Override // com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.VKiwrnDgpL
    public void eventLogin(Context context, String str, String str2) {
        YcmyEVJeuABnU.getInstance().eventLogin(context, str, str2);
    }

    @Override // com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.VKiwrnDgpL
    public void eventPay(Context context, String str, String str2, String str3, double d2, String str4) {
        YcmyEVJeuABnU.getInstance().eventPay(context, str, str2, str3, d2, str4);
    }

    @Override // com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.VKiwrnDgpL
    public void eventRegister(Context context, String str, String str2) {
        YcmyEVJeuABnU.getInstance().eventRegister(context, str, str2);
    }

    @Override // com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.SomnJeaLs
    public void exit() {
    }

    @Override // com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.ZNyuaGhRckJjEA
    public void login(Activity activity, LoginCallBack loginCallBack) {
        YcmyEVJeuABnU.getInstance().login(activity, loginCallBack);
    }

    @Override // com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.SomnJeaLs
    public void onActivityResult(int i2, int i3, Intent intent) {
        LogUtil.e("onActivityResult");
        YcmyEVJeuABnU.getInstance().onActivityResult(i2, i3, intent);
    }

    @Override // com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.SomnJeaLs
    public void onCreate(Activity activity) {
    }

    @Override // com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.SomnJeaLs
    public void onDestroy(Activity activity) {
    }

    @Override // com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.SomnJeaLs
    public void onPause(Activity activity) {
    }

    @Override // com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.SomnJeaLs
    public void onResume(Activity activity) {
    }

    @Override // com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.SomnJeaLs
    public void onSaveInstanceState(Bundle bundle) {
    }

    @Override // com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.SomnJeaLs
    public void onStart(Activity activity) {
    }

    @Override // com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.SomnJeaLs
    public void onStop(Activity activity) {
    }

    @Override // com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.JsQpvRdkwX
    public void shareLink(Activity activity, String str, UJDWpUn uJDWpUn) {
        YcmyEVJeuABnU.getInstance().shareLink(activity, str, uJDWpUn);
    }

    @Override // com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.JsQpvRdkwX
    public void sharePhoto(Activity activity, Bitmap bitmap, UJDWpUn uJDWpUn) {
        YcmyEVJeuABnU.getInstance().sharePhoto(activity, bitmap, uJDWpUn);
    }

    @Override // com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.JsQpvRdkwX
    public void sharePhoto(Activity activity, String str, UJDWpUn uJDWpUn) {
        YcmyEVJeuABnU.getInstance().sharePhoto(activity, str, uJDWpUn);
    }

    @Override // com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.JsQpvRdkwX
    public void sharePhoto(Activity activity, Uri uri, UJDWpUn uJDWpUn) {
        YcmyEVJeuABnU.getInstance().sharePhoto(activity, uri, uJDWpUn);
    }
}
