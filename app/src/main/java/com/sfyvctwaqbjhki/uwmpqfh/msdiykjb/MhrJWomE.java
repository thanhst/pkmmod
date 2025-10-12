package com.sfyvctwaqbjhki.uwmpqfh.msdiykjb;

import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.NetManager;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager;

/* loaded from: classes.dex */
public class MhrJWomE {
    private static NetManager manager = NetManager.getInstance();

    public static void getAccCancelAddr(UserManager userManager) {
        manager.doPostRequest(manager.getUrlHead() + "user/applyCancellation", userManager);
    }

    public static boolean isStoped() {
        return manager.isStoped();
    }

    public static void netAppCheck(UserManager userManager) {
        manager.doPostRequest(manager.getUrlHead() + "user/verify/userInfo", userManager);
    }

    public static void netBindEmail(UserManager userManager) {
        manager.doPostRequest(manager.getUrlHead() + "user/operatorEmail", userManager);
    }

    public static void netBindVisitor(UserManager userManager) {
        manager.doPostRequest(manager.getUrlHead() + "user/bindVisitor", userManager);
    }

    public static void netBindZone(UserManager userManager) {
        manager.doPostRequest(manager.getUrlHead() + "user/v3/bindZone", userManager);
    }

    public static void netChangePsw(UserManager userManager) {
        manager.doPostRequest(manager.getUrlHead() + "user/changePwd", userManager);
    }

    public static void netCheckPwd(UserManager userManager) {
        manager.doGetRequest(manager.getUrlHead() + "user/verifyPassword", userManager);
    }

    public static void netCheckValidCode(UserManager userManager) {
        manager.doGetRequest(manager.getUrlHead() + "user/checkValidCode", userManager);
    }

    public static void netConsumeOrder(UserManager userManager) {
        manager.doPostRequest(manager.getUrlHead() + "official/order/finish/v4.0", userManager);
    }

    public static void netDeductPCoin(UserManager userManager) {
        manager.doPostRequest(manager.getUrlHead() + "order/platformCoin/deduct", userManager);
    }

    public static void netForgetPwd(UserManager userManager) {
        manager.doGetRequest(manager.getUrlHead() + "user/forgetPwd", userManager);
    }

    public static void netGetChargeDetail(UserManager userManager) {
        manager.doGetRequest(manager.getUrlHead() + "order/chargeDetail", userManager);
    }

    public static void netGetChargeList(UserManager userManager) {
        manager.doGetRequest(manager.getUrlHead() + "order/getOrderList", userManager);
    }

    public static void netGetConsumeDetail(UserManager userManager) {
        manager.doGetRequest(manager.getUrlHead() + "order/consumeDetail", userManager);
    }

    public static void netGetConsumerList(UserManager userManager) {
        manager.doGetRequest(manager.getUrlHead() + "order/getPlatformConsumerList", userManager);
    }

    public static void netInit(UserManager userManager) {
        manager.doPostRequest(manager.getUrlHead() + "config/v3.1/initSDK", userManager);
    }

    public static void netLogin(UserManager userManager) {
        manager.doPostRequest(manager.getUrlHead() + "user/v3/login", userManager);
    }

    public static void netMakeOrder(UserManager userManager) {
        manager.doPostRequest(manager.getUrlHead() + "order/create/v4.0", userManager);
    }

    public static void netRegister(UserManager userManager) {
        manager.doPostRequest(manager.getUrlHead() + "user/v3/register", userManager);
    }

    public static void netRequestPCoin(UserManager userManager) {
        manager.doGetRequest(manager.getUrlHead() + "order/platformCoin/platformRemain", userManager);
    }

    public static void netRequestProducts(UserManager userManager) {
        manager.doPostRequest(manager.getUrlHead() + "config/paymentConfig/v4.0", userManager);
    }

    public static void netResetPsw(UserManager userManager) {
        manager.doPostRequest(manager.getUrlHead() + "user/resetPassword", userManager);
    }

    public static void netSafeSetting(UserManager userManager) {
        manager.doPostRequest(manager.getUrlHead() + "user/safeSetting", userManager);
    }

    public static void netSendValidCode(UserManager userManager) {
        manager.doGetRequest(manager.getUrlHead() + "user/sendValidCode", userManager);
    }

    public static void netSocial(UserManager userManager) {
        manager.doPostRequest(manager.getUrlHead() + "config/social", userManager);
    }

    public static void stopNet() {
        manager.stopNet();
    }
}
