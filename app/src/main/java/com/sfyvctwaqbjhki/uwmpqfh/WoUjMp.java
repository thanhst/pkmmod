package com.sfyvctwaqbjhki.uwmpqfh;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.ErrorUtil;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.LogUtils;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.PermissionUtils;
import com.sfyvctwaqbjhki.uwmpqfh.bokqjfarynhxdu.AFCBnG;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.CfiUmlLp;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.EQcWrywmxntsoaA;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.OMUbvus;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.RDnIREMt;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.SYwCAo;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.VwEiglxMTZuLV;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.WxGIMQL;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.GameRoleBean;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.NetParamsBean;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.UGuwCakoQHjtD;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.AccTipsManager;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.ActManager;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.KcUwgofnY;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.QxrbWKcFsmZ;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.Response;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager;
import com.sfyvctwaqbjhki.uwmpqfh.msdiykjb.MhrJWomE;
import com.sfyvctwaqbjhki.uwmpqfh.msdiykjb.PBvElADcPX;
import com.sfyvctwaqbjhki.uwmpqfh.msdiykjb.ZGJWDCUOkpgHBx;
import com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.ActivityListener;
import com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.AskPermissionCallBack;
import com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.CheckCallback;
import com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.DoubleBtnCallBack;
import com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.IActivityListener;
import com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.InitCallBack;
import com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.LoginCallBack;
import com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.MCBNKIfi;
import com.ykiocnwpdseglq.lbmntzwepqakgu.ReDqOTXKRs;

/* loaded from: classes.dex */
public class WoUjMp {
    private static WoUjMp instance;
    private Activity activity;
    private IActivityListener activityListener;
    private int activityNum;
    private QxrbWKcFsmZ callmanager;
    private boolean isInit = false;
    private boolean isLogin = false;

    public WoUjMp() {
        if (this.callmanager == null) {
            this.callmanager = new QxrbWKcFsmZ();
        }
    }

    public static WoUjMp getInstance() {
        if (instance == null) {
            instance = new WoUjMp();
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initSDK(Activity activity, InitCallBack initCallBack) {
        RDnIREMt.updateInstance(activity);
        this.activity = activity;
        this.callmanager.setInitCallBack(initCallBack);
        Response.getInstance().setUserInfo(PBvElADcPX.getLoginInfo(Response.getInstance().getConfigBean().getAppId()));
        MhrJWomE.netInit(new UserManager(UserManager.Type.INIT) { // from class: com.sfyvctwaqbjhki.uwmpqfh.WoUjMp.2
            @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager
            public void fail(final int i2, String str) {
                WoUjMp.this.isInit = false;
                WoUjMp.this.activity.runOnUiThread(new Runnable() { // from class: com.sfyvctwaqbjhki.uwmpqfh.WoUjMp.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ZGJWDCUOkpgHBx.initFail(WoUjMp.this.getContext().getString(ErrorUtil.getIdByCode(i2)));
                    }
                });
            }

            @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager
            public void response(Response response) {
                WoUjMp.this.isInit = true;
                WoUjMp.this.activity.runOnUiThread(new Runnable() { // from class: com.sfyvctwaqbjhki.uwmpqfh.WoUjMp.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AFCBnG.getInstance().initFinish(WoUjMp.this.activity);
                        KcUwgofnY.getInstance().initPay(WoUjMp.this.activity);
                        ZGJWDCUOkpgHBx.initSuccess();
                    }
                });
            }
        });
    }

    private void showExitDialog(final Activity activity) {
        WxGIMQL.createAndShow(activity.getString(R.string.txt_warn), activity.getString(R.string.txt_exit_tip), activity.getString(R.string.txt_cancel), activity.getString(R.string.txt_confirm), new DoubleBtnCallBack() { // from class: com.sfyvctwaqbjhki.uwmpqfh.WoUjMp.5
            @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.DoubleBtnCallBack
            public void cancel() {
            }

            @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.SingleBtnCallBack
            public void confirm() {
                AFCBnG.getInstance().onDestroy(WoUjMp.this.activity);
                ReDqOTXKRs.exitGame();
                ActManager.getAppManager().addActivity(activity);
                ActManager.getAppManager().finishAllActivity();
                Process.killProcess(Process.myPid());
            }
        });
    }

    public void autoLogin(Activity activity, LoginCallBack loginCallBack) {
        RDnIREMt.updateInstance(activity);
        this.callmanager.setLoginCallBack(loginCallBack);
        this.activity = activity;
        if (!this.isInit) {
            loginCallBack.loginFail(activity.getString(R.string.txt_noinit));
            return;
        }
        if (Response.getInstance().getUserInfo() == null || Response.getInstance().getUserInfo().getUserName() == null || Response.getInstance().getUserInfo().getIsDead() == 1) {
            login(activity, loginCallBack);
            return;
        }
        if (this.activityNum != 0) {
            LogUtils.e("autoLogin button is double click!!!");
            return;
        }
        NetParamsBean netParamsBean = new NetParamsBean();
        netParamsBean.setAutoLogin(true);
        Response.getInstance().setNetParamsBean(netParamsBean);
        VwEiglxMTZuLV.createAndShow(activity);
    }

    public void bindZone(String str, String str2, String str3, String str4, boolean z2) {
        LogUtils.e("bindZone::::::zoneId=" + str + "::roleId=" + str2 + "::level=" + str4 + "::isCreatRole=" + z2);
        if (this.isInit && this.isLogin) {
            UGuwCakoQHjtD uGuwCakoQHjtD = new UGuwCakoQHjtD();
            uGuwCakoQHjtD.setGameZoneId(str);
            uGuwCakoQHjtD.setRoleId(str2);
            uGuwCakoQHjtD.setLevel(str4);
            Response.getInstance().setUGuwCakoQHjtD(uGuwCakoQHjtD);
            if (z2) {
                AFCBnG.getInstance().onCreateRole(this.activity);
            }
            AFCBnG.getInstance().enterGame(this.activity);
            GameRoleBean gameRoleBean = new GameRoleBean();
            gameRoleBean.setGameZoneId(str);
            gameRoleBean.setLevel(str4);
            gameRoleBean.setRoleId(str2);
            gameRoleBean.setRoleName(str3);
            Response.getInstance().setGameRoleBean(gameRoleBean);
            NetParamsBean netParamsBean = new NetParamsBean();
            netParamsBean.setCreateRole(z2 ? 1 : 0);
            Response.getInstance().setNetParamsBean(netParamsBean);
            MhrJWomE.netBindZone(new UserManager(UserManager.Type.BINDZONE) { // from class: com.sfyvctwaqbjhki.uwmpqfh.WoUjMp.3
                @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager
                public void fail(int i2, String str5) {
                }

                @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager
                public void response(Response response) {
                }
            });
        }
    }

    public void checkAppStatus(Activity activity, final CheckCallback checkCallback) {
        RDnIREMt.updateInstance(activity);
        this.activity = activity;
        MhrJWomE.netAppCheck(new UserManager(UserManager.Type.CHECKAPPSTATUS) { // from class: com.sfyvctwaqbjhki.uwmpqfh.WoUjMp.4
            @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager
            public void fail(int i2, String str) {
                LogUtils.e("code " + i2 + "  error_msg " + str);
                checkCallback.isCheck(false);
            }

            @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager
            public void response(Response response) {
                if (checkCallback == null) {
                    return;
                }
                if (response.getIsCheck() == 1) {
                    checkCallback.isCheck(true);
                } else {
                    checkCallback.isCheck(false);
                }
            }
        });
    }

    public void destorySDK() {
        this.isInit = false;
        this.isLogin = false;
        PBvElADcPX.close();
        ReDqOTXKRs.onDestroy(this.activity);
        AFCBnG.getInstance().onDestroy(this.activity);
        instance = null;
    }

    public void diamondGet(int i2) {
    }

    public void enterNewActivity(Activity activity) {
        ActManager.getAppManager().addActivity(activity);
    }

    public int getActivityNum() {
        return this.activityNum;
    }

    public QxrbWKcFsmZ getCallManager() {
        return this.callmanager;
    }

    public Activity getContext() {
        return this.activity;
    }

    public boolean isInit() {
        return this.isInit;
    }

    public boolean isLogin() {
        return this.isLogin;
    }

    public void login(Activity activity, LoginCallBack loginCallBack) {
        RDnIREMt.updateInstance(activity);
        this.callmanager.setLoginCallBack(loginCallBack);
        this.activity = activity;
        AccTipsManager.getInstance().visitorUpdatedOrSwitch();
        if (!this.isInit) {
            loginCallBack.loginFail(activity.getString(R.string.txt_noinit));
        } else if (this.activityNum == 0) {
            OMUbvus.createAndShow(activity);
        } else {
            LogUtils.e("login button is double click!!!");
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        IActivityListener iActivityListener = this.activityListener;
        if (iActivityListener != null) {
            iActivityListener.onActivityResult(i2, i3, intent);
        }
        PermissionUtils.getInstance().onActivityResult(i2, i3, intent);
        KcUwgofnY.getInstance().onActivityResult(i2, i3, intent);
        ReDqOTXKRs.onActivityResult(i2, i3, intent);
    }

    public void onBackPressed(Activity activity) {
        this.activity = activity;
        if (Response.getInstance() == null || Response.getInstance().getEDakAXiM() == null || Response.getInstance().getEDakAXiM().getMessages() == null || Response.getInstance().getEDakAXiM().getMessages().getIsHasPause() == null || !Boolean.parseBoolean(Response.getInstance().getEDakAXiM().getMessages().getIsHasLogin())) {
            showExitDialog(activity);
        } else {
            EQcWrywmxntsoaA.createAndShow(activity);
        }
    }

    public void onExtraEvent(Context context, String str, String str2) {
        AFCBnG.getInstance().onExtraEvent(context, str, str2);
    }

    public void onPause() {
        ReDqOTXKRs.onPause(this.activity);
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        PermissionUtils.getInstance().onRequestPermissionsResult(i2, strArr, iArr);
        KcUwgofnY.getInstance().onRequestPermissionsResult(i2, strArr, iArr);
    }

    public void onResume() {
        ReDqOTXKRs.onResume(this.activity);
    }

    public void onSaveInstanceState(Bundle bundle) {
        IActivityListener iActivityListener = this.activityListener;
        if (iActivityListener != null) {
            iActivityListener.onSaveInstanceState(bundle);
        }
    }

    public void openCustomServiceCenter(Context context) {
        RDnIREMt.updateInstance(context);
        CfiUmlLp.createAndShow(context);
    }

    public void openUserCenter(Context context) {
        RDnIREMt.updateInstance(context);
        if (this.isInit && this.isLogin) {
            SYwCAo.createAndShow(context);
        }
    }

    public void pay(Activity activity, UGuwCakoQHjtD uGuwCakoQHjtD, MCBNKIfi mCBNKIfi) {
        RDnIREMt.updateInstance(activity);
        this.activity = activity;
        this.callmanager.setMCBNKIfi(mCBNKIfi);
        KcUwgofnY.getInstance().launchPay(activity, uGuwCakoQHjtD, mCBNKIfi);
    }

    public void setActivityListener(ActivityListener activityListener) {
        this.activityListener = activityListener;
    }

    public void setActivityNum(int i2) {
        this.activityNum = i2;
    }

    public void setLogin(boolean z2) {
        this.isLogin = z2;
    }

    public void startInit(final Activity activity, final InitCallBack initCallBack) {
        this.activity = activity;
        LogUtils.e("onCreate askpermisions");
        ReDqOTXKRs.onCreate(this.activity);
        AFCBnG.getInstance().onInit(this.activity);
        AskPermissionCallBack askPermissionCallBack = new AskPermissionCallBack() { // from class: com.sfyvctwaqbjhki.uwmpqfh.WoUjMp.1
            @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.AskPermissionCallBack
            public void result(boolean z2) {
                if (z2) {
                    WoUjMp.this.initSDK(activity, initCallBack);
                }
            }
        };
        if (activity.getApplicationInfo().targetSdkVersion < 33 || Build.VERSION.SDK_INT < 33) {
            PermissionUtils.getInstance().requestPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE", askPermissionCallBack);
        } else {
            PermissionUtils.getInstance().requestPermission(activity, "android.permission.READ_MEDIA_IMAGES", askPermissionCallBack);
        }
    }

    @Deprecated
    public void onExtraEvent(Context context, String str) {
        AFCBnG.getInstance().onExtraEvent(context, str);
    }
}
