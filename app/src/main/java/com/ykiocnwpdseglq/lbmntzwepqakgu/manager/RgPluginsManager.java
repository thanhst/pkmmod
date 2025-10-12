package com.ykiocnwpdseglq.lbmntzwepqakgu.manager;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.ykiocnwpdseglq.lbmntzwepqakgu.ReDqOTXKRs;
import com.ykiocnwpdseglq.lbmntzwepqakgu.beans.OpHzXGktYUTIAhi;
import com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.DIUGfDWQpOJHLr;
import com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.JsQpvRdkwX;
import com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.LoginCallBack;
import com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.PurchaseListener;
import com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.SomnJeaLs;
import com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.UJDWpUn;
import com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.VKiwrnDgpL;
import com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.ZNyuaGhRckJjEA;
import com.ykiocnwpdseglq.lbmntzwepqakgu.utils.LogUtil;
import java.util.Map;

/* loaded from: classes.dex */
public class RgPluginsManager {
    private static String PRENAME = "devicemsginfo";
    private static RgPluginsManager instance;
    private ReDqOTXKRs.ExitListener exitListener;
    private boolean isApplicationExecute = false;
    private Application myApplication;

    public static RgPluginsManager getInstance() {
        if (instance == null) {
            instance = new RgPluginsManager();
        }
        return instance;
    }

    public void applicationAttachBaseContext(Context context) {
        for (Object obj : PluginFactory.getInstance().getAllPluginObjects().values()) {
            if (obj instanceof SomnJeaLs) {
                ((SomnJeaLs) obj).applicationAttachBaseContext(context);
            }
        }
    }

    public void applicationOnCreate(Application application) {
        if (this.isApplicationExecute) {
            return;
        }
        this.isApplicationExecute = true;
        this.myApplication = application;
        for (Object obj : PluginFactory.getInstance().getAllPluginObjects().values()) {
            if (obj instanceof SomnJeaLs) {
                ((SomnJeaLs) obj).applicationOnCreate(application);
            }
        }
    }

    public void eventCustom(Context context, String str, String str2) {
        for (VKiwrnDgpL vKiwrnDgpL : PluginFactory.getInstance().getAllAnalPluginsObjects().values()) {
            if (vKiwrnDgpL != null) {
                vKiwrnDgpL.eventCustom(context, str, str2);
            }
        }
    }

    public void eventLogin(Context context, String str, String str2) {
        for (VKiwrnDgpL vKiwrnDgpL : PluginFactory.getInstance().getAllAnalPluginsObjects().values()) {
            if (vKiwrnDgpL != null) {
                vKiwrnDgpL.eventLogin(context, str, str2);
            }
        }
    }

    public void eventPay(Context context, String str, String str2, String str3, double d2, String str4) {
        for (VKiwrnDgpL vKiwrnDgpL : PluginFactory.getInstance().getAllAnalPluginsObjects().values()) {
            if (vKiwrnDgpL != null) {
                vKiwrnDgpL.eventPay(context, str, str2, str3, d2, str4);
            }
        }
    }

    public void eventRegister(Context context, String str, String str2) {
        for (VKiwrnDgpL vKiwrnDgpL : PluginFactory.getInstance().getAllAnalPluginsObjects().values()) {
            if (vKiwrnDgpL != null) {
                vKiwrnDgpL.eventRegister(context, str, str2);
            }
        }
    }

    public void exitGame() {
        for (Object obj : PluginFactory.getInstance().getAllPluginObjects().values()) {
            if (obj instanceof SomnJeaLs) {
                ((SomnJeaLs) obj).exit();
            }
        }
        ReDqOTXKRs.ExitListener exitListener = this.exitListener;
        if (exitListener != null) {
            exitListener.exit();
        }
    }

    public String getGaid() {
        Application application = this.myApplication;
        return application == null ? "" : application.getSharedPreferences(PRENAME, 0).getString("gaid", "");
    }

    public boolean isPluginExist(OpHzXGktYUTIAhi opHzXGktYUTIAhi) {
        return PluginFactory.getInstance().isPluginExist(opHzXGktYUTIAhi);
    }

    public void login(OpHzXGktYUTIAhi opHzXGktYUTIAhi, Activity activity, LoginCallBack loginCallBack) {
        Object pluginObject = PluginFactory.getInstance().getPluginObject(opHzXGktYUTIAhi);
        if (pluginObject instanceof ZNyuaGhRckJjEA) {
            ((ZNyuaGhRckJjEA) pluginObject).login(activity, loginCallBack);
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        LogUtil.e("onActivityResult");
        for (Object obj : PluginFactory.getInstance().getAllPluginObjects().values()) {
            if (obj instanceof SomnJeaLs) {
                ((SomnJeaLs) obj).onActivityResult(i2, i3, intent);
            }
        }
    }

    public void onCreate(Activity activity) {
        for (Object obj : PluginFactory.getInstance().getAllPluginObjects().values()) {
            if (obj instanceof SomnJeaLs) {
                ((SomnJeaLs) obj).onCreate(activity);
            }
        }
    }

    public void onDestroy(Activity activity) {
        for (Object obj : PluginFactory.getInstance().getAllPluginObjects().values()) {
            if (obj instanceof SomnJeaLs) {
                ((SomnJeaLs) obj).onDestroy(activity);
            }
        }
    }

    public void onPause(Activity activity) {
        for (Object obj : PluginFactory.getInstance().getAllPluginObjects().values()) {
            if (obj instanceof SomnJeaLs) {
                ((SomnJeaLs) obj).onPause(activity);
            }
        }
    }

    public void onResume(Activity activity) {
        for (Object obj : PluginFactory.getInstance().getAllPluginObjects().values()) {
            if (obj instanceof SomnJeaLs) {
                ((SomnJeaLs) obj).onResume(activity);
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        for (Object obj : PluginFactory.getInstance().getAllPluginObjects().values()) {
            if (obj instanceof SomnJeaLs) {
                ((SomnJeaLs) obj).onSaveInstanceState(bundle);
            }
        }
    }

    public void onStart(Activity activity) {
        for (Object obj : PluginFactory.getInstance().getAllPluginObjects().values()) {
            if (obj instanceof SomnJeaLs) {
                ((SomnJeaLs) obj).onStart(activity);
            }
        }
    }

    public void onStop(Activity activity) {
        for (Object obj : PluginFactory.getInstance().getAllPluginObjects().values()) {
            if (obj instanceof SomnJeaLs) {
                ((SomnJeaLs) obj).onStop(activity);
            }
        }
    }

    public void payAllInit(Context context, Map<OpHzXGktYUTIAhi, DIUGfDWQpOJHLr.ParamGetter> map, PurchaseListener purchaseListener) {
        LogUtil.e("all pay plugin init");
        for (Map.Entry<OpHzXGktYUTIAhi, DIUGfDWQpOJHLr> entry : PluginFactory.getInstance().getAllPayPluginObjects().entrySet()) {
            if (entry.getValue() != null) {
                entry.getValue().initPay(context, map.get(entry.getKey()), purchaseListener);
            }
        }
    }

    public void payCostOrder(OpHzXGktYUTIAhi opHzXGktYUTIAhi, Activity activity, DIUGfDWQpOJHLr.ParamGetter paramGetter) {
        LogUtil.e("pay cost order");
        Object pluginObject = PluginFactory.getInstance().getPluginObject(opHzXGktYUTIAhi);
        if (pluginObject instanceof DIUGfDWQpOJHLr) {
            ((DIUGfDWQpOJHLr) pluginObject).consumeClientOrder(activity, paramGetter);
        }
    }

    public void payInit(OpHzXGktYUTIAhi opHzXGktYUTIAhi, Context context, DIUGfDWQpOJHLr.ParamGetter paramGetter, PurchaseListener purchaseListener) {
        LogUtil.e(opHzXGktYUTIAhi.name() + " init");
        Object pluginObject = PluginFactory.getInstance().getPluginObject(opHzXGktYUTIAhi);
        if (pluginObject instanceof DIUGfDWQpOJHLr) {
            ((DIUGfDWQpOJHLr) pluginObject).initPay(context, paramGetter, purchaseListener);
        }
    }

    public void payStart(OpHzXGktYUTIAhi opHzXGktYUTIAhi, Activity activity, DIUGfDWQpOJHLr.ParamGetter paramGetter) {
        LogUtil.e("pay start");
        Object pluginObject = PluginFactory.getInstance().getPluginObject(opHzXGktYUTIAhi);
        LogUtil.e("plugin..." + pluginObject);
        if (pluginObject instanceof DIUGfDWQpOJHLr) {
            ((DIUGfDWQpOJHLr) pluginObject).startPay(activity, paramGetter);
        } else {
            LogUtil.e("obj is not DIUGfDWQpOJHLr instance");
        }
    }

    public void regExitListener(ReDqOTXKRs.ExitListener exitListener) {
        this.exitListener = exitListener;
    }

    public void shareLink(OpHzXGktYUTIAhi opHzXGktYUTIAhi, Activity activity, String str, UJDWpUn uJDWpUn) {
        Object pluginObject = PluginFactory.getInstance().getPluginObject(opHzXGktYUTIAhi);
        if (pluginObject instanceof JsQpvRdkwX) {
            ((JsQpvRdkwX) pluginObject).shareLink(activity, str, uJDWpUn);
        }
    }
}
