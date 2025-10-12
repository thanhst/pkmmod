package com.sfyvctwaqbjhki.uwmpqfh.bokqjfarynhxdu;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.facebook.share.internal.ShareConstants;
import com.sfyvctwaqbjhki.uwmpqfh.R;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.DataUtil;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.LogUtils;
import com.ykiocnwpdseglq.lbmntzwepqakgu.ReDqOTXKRs;

/* loaded from: classes.dex */
public class AFCBnG {
    public static final String TAG = "com.sfyvctwaqbjhki.uwmpqfh.bokqjfarynhxdu.AFCBnG";
    private static AFCBnG instance;
    private final String GOOGLE_API_KEY = "google_api_key";
    private final String EVENT_KEY_TYPE = ShareConstants.MEDIA_TYPE;
    private final String EVENT_KEY_USERID = "userId";
    private final String EVENT_KEY_GAMEOEDERID = DataUtil.ORDER_COLUMN.ORDER_GAME_ORDER_ID;
    private final String EVENT_KEY_MONEY = "money";
    private final String EVENT_KEY_CURRENCY = DataUtil.ORDER_LIST_COLUMN.CURRENCY;
    private final String EVENT_KEY_VIPLEVEL = "vipLevel";
    private final String EVENT_KEY_LEVELTAG = "levelTag";
    private final String EVENT_NAME = "eventName";
    private final String EVENT_ADJUST_TOKEN = "eventToken";
    private final int EVENT_TYPE_INIT = 1000;
    private final int EVENT_TYPE_REGISTER = 1001;
    private final int EVENT_TYPE_LOGIN = 1002;
    private final int EVENT_TYPE_PAY = 1003;
    private final int EVENT_TYPE_CREATE_ROLE = 1004;
    private final int EVENT_TYPE_LEVEL_REACHERED = 1005;
    private final int EVENT_TYPE_EXTRA_RECORD = 1006;
    private final int EVENT_TYPE_INIT_FINISH = 1007;
    private final int EVENT_TYPE_EXIST = 111111;

    private AFCBnG() {
    }

    private void connectHostAndMKEvent(Context context, Runnable runnable) {
    }

    public static AFCBnG getInstance() {
        if (instance == null) {
            instance = new AFCBnG();
        }
        return instance;
    }

    public void analysisApplicationOnCreate(Application application) {
    }

    public void enterGame(Context context) {
        ReDqOTXKRs.eventCustom(context, "enter_game", context.getString(R.string.pg_adjust_enter_game));
    }

    public void initFinish(Activity activity) {
        LogUtils.e("初始化打点===============================");
        ReDqOTXKRs.eventCustom(activity, "sdkinitfinish", activity.getString(R.string.pg_adjust_sdkinitfinish));
    }

    public void onCreateRole(Activity activity) {
        LogUtils.e("创角打点===============================");
        ReDqOTXKRs.eventCustom(activity, "create_role", activity.getString(R.string.pg_adjust_CreateRole));
        ReDqOTXKRs.eventCustom(activity, "create_role_unique", activity.getString(R.string.pg_adjust_CreateRole_unique));
    }

    public void onDestroy(Context context) {
    }

    public void onExtraEvent(Context context, String str, String str2) {
        LogUtils.e("额外事件打点===============================");
        ReDqOTXKRs.eventCustom(context, str, str2);
    }

    public void onInit(Activity activity) {
        LogUtils.e("初始化打点===============================");
        ReDqOTXKRs.eventCustom(activity, "gamelaunch", activity.getString(R.string.pg_adjust_gamelaunch));
    }

    public void onLogin(int i2, Activity activity) {
        LogUtils.e("登录打点===============================");
        ReDqOTXKRs.eventLogin(activity, "login", String.valueOf(i2));
    }

    public void onPay(int i2, String str, double d2, String str2, int i3, Activity activity) {
        LogUtils.e("支付打点===============================");
        LogUtils.e("===currency==" + str2 + "===money==" + d2 + "===gameOrderId==" + str);
        ReDqOTXKRs.eventPay(activity, "purchase", String.valueOf(i2), str, d2, str2);
    }

    public void onRegister(int i2, Activity activity) {
        LogUtils.e("注册打点===============================");
        ReDqOTXKRs.eventRegister(activity, "registration", String.valueOf(i2));
    }

    @Deprecated
    public void onExtraEvent(Context context, String str) {
        LogUtils.e("额外事件打点===============================");
        ReDqOTXKRs.eventCustom(context, str, "");
    }
}
