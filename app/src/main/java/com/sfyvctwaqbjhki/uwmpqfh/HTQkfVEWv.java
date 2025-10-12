package com.sfyvctwaqbjhki.uwmpqfh;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.UGuwCakoQHjtD;
import com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.CheckCallback;
import com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.InitCallBack;
import com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.LoginCallBack;
import com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.MCBNKIfi;

/* loaded from: classes.dex */
public class HTQkfVEWv {
    public static void autoLogin(Activity activity, LoginCallBack loginCallBack) {
        WoUjMp.getInstance().autoLogin(activity, loginCallBack);
    }

    public static void bindZoon(String str, String str2, String str3, String str4, boolean z2) {
        WoUjMp.getInstance().bindZone(str, str2, str3, str4, z2);
    }

    public static void checkAppStatus(Activity activity, CheckCallback checkCallback) {
        WoUjMp.getInstance().checkAppStatus(activity, checkCallback);
    }

    public static void diamondGet(int i2) {
        WoUjMp.getInstance().diamondGet(i2);
    }

    public static void enterNewActivity(Activity activity) {
        WoUjMp.getInstance().enterNewActivity(activity);
    }

    public static void gameEvent(Context context, String str, String str2) {
        WoUjMp.getInstance().onExtraEvent(context, str, str2);
    }

    public static void initSDK(Activity activity, InitCallBack initCallBack) {
        WoUjMp.getInstance().startInit(activity, initCallBack);
    }

    public static void onActivityResult(int i2, int i3, Intent intent) {
        WoUjMp.getInstance().onActivityResult(i2, i3, intent);
    }

    public static void onBackPressed(Activity activity) {
        WoUjMp.getInstance().onBackPressed(activity);
    }

    public static void onDestory() {
        WoUjMp.getInstance().destorySDK();
    }

    public static void onPause() {
        WoUjMp.getInstance().onPause();
    }

    public static void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        WoUjMp.getInstance().onRequestPermissionsResult(i2, strArr, iArr);
    }

    public static void onResume() {
        WoUjMp.getInstance().onResume();
    }

    public static void onSaveInstanceState(Bundle bundle) {
        WoUjMp.getInstance().onSaveInstanceState(bundle);
    }

    public static void openCustomServiceCenter(Context context) {
        WoUjMp.getInstance().openCustomServiceCenter(context);
    }

    public static void openLogin(Activity activity, LoginCallBack loginCallBack) {
        WoUjMp.getInstance().login(activity, loginCallBack);
    }

    public static void openUserCenter(Context context) {
        WoUjMp.getInstance().openUserCenter(context);
    }

    public static void startPay(Activity activity, UGuwCakoQHjtD uGuwCakoQHjtD, MCBNKIfi mCBNKIfi) {
        WoUjMp.getInstance().pay(activity, uGuwCakoQHjtD, mCBNKIfi);
    }

    public static void gameEvent(Context context, String str) {
        WoUjMp.getInstance().onExtraEvent(context, str);
    }
}
