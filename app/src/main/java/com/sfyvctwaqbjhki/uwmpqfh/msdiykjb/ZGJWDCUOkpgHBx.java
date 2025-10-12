package com.sfyvctwaqbjhki.uwmpqfh.msdiykjb;

import com.sfyvctwaqbjhki.uwmpqfh.WoUjMp;
import com.sfyvctwaqbjhki.uwmpqfh.bokqjfarynhxdu.AFCBnG;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.UserInfo;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.QxrbWKcFsmZ;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.Response;

/* loaded from: classes.dex */
public class ZGJWDCUOkpgHBx {
    private static QxrbWKcFsmZ manager = WoUjMp.getInstance().getCallManager();

    public static void initFail(String str) {
        QxrbWKcFsmZ qxrbWKcFsmZ = manager;
        if (qxrbWKcFsmZ == null || qxrbWKcFsmZ.getInitCallBack() == null) {
            return;
        }
        WoUjMp.getInstance().getCallManager().getInitCallBack().initFail(str);
    }

    public static void initSuccess() {
        QxrbWKcFsmZ qxrbWKcFsmZ = manager;
        if (qxrbWKcFsmZ == null || qxrbWKcFsmZ.getInitCallBack() == null) {
            return;
        }
        WoUjMp.getInstance().getCallManager().getInitCallBack().initSuccess();
    }

    public static void loginFail(String str) {
        QxrbWKcFsmZ qxrbWKcFsmZ = manager;
        if (qxrbWKcFsmZ == null || qxrbWKcFsmZ.getLoginCallBack() == null) {
            return;
        }
        WoUjMp.getInstance().getCallManager().getLoginCallBack().loginFail(str);
    }

    public static void loginSuccess(String str, UserInfo userInfo) {
        QxrbWKcFsmZ qxrbWKcFsmZ = manager;
        if (qxrbWKcFsmZ == null || qxrbWKcFsmZ.getLoginCallBack() == null) {
            return;
        }
        WoUjMp.getInstance().getCallManager().getLoginCallBack().loginSuccess(str, userInfo);
        if (!Response.getInstance().getNetParamsBean().isFirstLogin()) {
            AFCBnG.getInstance().onLogin(Response.getInstance().getUserInfo().getUserId(), WoUjMp.getInstance().getContext());
        } else {
            AFCBnG.getInstance().onRegister(Response.getInstance().getUserInfo().getUserId(), WoUjMp.getInstance().getContext());
            AFCBnG.getInstance().onLogin(Response.getInstance().getUserInfo().getUserId(), WoUjMp.getInstance().getContext());
        }
    }

    public static void payFail(String str) {
        QxrbWKcFsmZ qxrbWKcFsmZ = manager;
        if (qxrbWKcFsmZ == null || qxrbWKcFsmZ.getMCBNKIfi() == null) {
            return;
        }
        WoUjMp.getInstance().getCallManager().getMCBNKIfi().payFail(str);
    }

    public static void paySuccess() {
        QxrbWKcFsmZ qxrbWKcFsmZ = manager;
        if (qxrbWKcFsmZ == null || qxrbWKcFsmZ.getMCBNKIfi() == null) {
            return;
        }
        WoUjMp.getInstance().getCallManager().getMCBNKIfi().payFinish();
    }

    public static void switchSuccess() {
        QxrbWKcFsmZ qxrbWKcFsmZ = manager;
        if (qxrbWKcFsmZ == null || qxrbWKcFsmZ.getInitCallBack() == null) {
            return;
        }
        WoUjMp.getInstance().getCallManager().getInitCallBack().doSwitch();
    }
}
