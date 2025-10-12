package com.ykiocnwpdseglq.lbmntzwepqakgu;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.ykiocnwpdseglq.lbmntzwepqakgu.beans.OpHzXGktYUTIAhi;
import com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.DIUGfDWQpOJHLr;
import com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.LoginCallBack;
import com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.PurchaseListener;
import com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.UJDWpUn;
import com.ykiocnwpdseglq.lbmntzwepqakgu.manager.RgPluginsManager;

/* loaded from: classes.dex */
public class ReDqOTXKRs {

    public interface ExitListener {
        void exit();
    }

    public static void applicationAttachBaseContext(Context context) {
        RgPluginsManager.getInstance().applicationAttachBaseContext(context);
    }

    public static void applicationOnCreate(Application application) {
        RgPluginsManager.getInstance().applicationOnCreate(application);
    }

    public static void eventCustom(Context context, String str, String str2) {
        RgPluginsManager.getInstance().eventCustom(context, str, str2);
    }

    public static void eventLogin(Context context, String str, String str2) {
        RgPluginsManager.getInstance().eventLogin(context, str, str2);
    }

    public static void eventPay(Context context, String str, String str2, String str3, double d2, String str4) {
        RgPluginsManager.getInstance().eventPay(context, str, str2, str3, d2, str4);
    }

    public static void eventRegister(Context context, String str, String str2) {
        RgPluginsManager.getInstance().eventRegister(context, str, str2);
    }

    public static void exitGame() {
        RgPluginsManager.getInstance().exitGame();
    }

    public static String getGaid() {
        return RgPluginsManager.getInstance().getGaid();
    }

    public static boolean isPluginExist(OpHzXGktYUTIAhi opHzXGktYUTIAhi) {
        return RgPluginsManager.getInstance().isPluginExist(opHzXGktYUTIAhi);
    }

    public static void login(OpHzXGktYUTIAhi opHzXGktYUTIAhi, Activity activity, LoginCallBack loginCallBack) {
        RgPluginsManager.getInstance().login(opHzXGktYUTIAhi, activity, loginCallBack);
    }

    public static void onActivityResult(int i2, int i3, Intent intent) {
        RgPluginsManager.getInstance().onActivityResult(i2, i3, intent);
    }

    public static void onCreate(Activity activity) {
        RgPluginsManager.getInstance().onCreate(activity);
    }

    public static void onDestroy(Activity activity) {
        RgPluginsManager.getInstance().onDestroy(activity);
    }

    public static void onPause(Activity activity) {
        RgPluginsManager.getInstance().onPause(activity);
    }

    public static void onResume(Activity activity) {
        RgPluginsManager.getInstance().onResume(activity);
    }

    public static void onSaveInstanceState(Bundle bundle) {
        RgPluginsManager.getInstance().onSaveInstanceState(bundle);
    }

    public static void onStart(Activity activity) {
        RgPluginsManager.getInstance().onStart(activity);
    }

    public static void onStop(Activity activity) {
        RgPluginsManager.getInstance().onStop(activity);
    }

    public static void payCostOrder(OpHzXGktYUTIAhi opHzXGktYUTIAhi, Activity activity, DIUGfDWQpOJHLr.ParamGetter paramGetter) {
        RgPluginsManager.getInstance().payCostOrder(opHzXGktYUTIAhi, activity, paramGetter);
    }

    public static void payInit(OpHzXGktYUTIAhi opHzXGktYUTIAhi, Context context, DIUGfDWQpOJHLr.ParamGetter paramGetter, PurchaseListener purchaseListener) {
        RgPluginsManager.getInstance().payInit(opHzXGktYUTIAhi, context, paramGetter, purchaseListener);
    }

    public static void payStart(OpHzXGktYUTIAhi opHzXGktYUTIAhi, Activity activity, DIUGfDWQpOJHLr.ParamGetter paramGetter) {
        RgPluginsManager.getInstance().payStart(opHzXGktYUTIAhi, activity, paramGetter);
    }

    public static void regExitListener(ExitListener exitListener) {
        RgPluginsManager.getInstance().regExitListener(exitListener);
    }

    public static void shareLink(OpHzXGktYUTIAhi opHzXGktYUTIAhi, Activity activity, String str, UJDWpUn uJDWpUn) {
        RgPluginsManager.getInstance().shareLink(opHzXGktYUTIAhi, activity, str, uJDWpUn);
    }
}
