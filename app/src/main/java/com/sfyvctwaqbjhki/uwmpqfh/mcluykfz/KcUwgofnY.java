package com.sfyvctwaqbjhki.uwmpqfh.mcluykfz;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.widget.Toast;
import com.sfyvctwaqbjhki.uwmpqfh.R;
import com.sfyvctwaqbjhki.uwmpqfh.WoUjMp;
import com.sfyvctwaqbjhki.uwmpqfh.biohepbeans.EDakAXiM;
import com.sfyvctwaqbjhki.uwmpqfh.biohepbeans.RfybaJKCLilYpc;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.ConstantUtil;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.LogUtils;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.JqUIzeZd;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.vertial.DMPOSpjVN;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.UGuwCakoQHjtD;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager;
import com.sfyvctwaqbjhki.uwmpqfh.msdiykjb.MhrJWomE;
import com.sfyvctwaqbjhki.uwmpqfh.msdiykjb.ZGJWDCUOkpgHBx;
import com.sfyvctwaqbjhki.uwmpqfh.ovlfuarnk.HwPay;
import com.sfyvctwaqbjhki.uwmpqfh.ovlfuarnk.MYkqRJBojXaN;
import com.sfyvctwaqbjhki.uwmpqfh.ovlfuarnk.NXUfldNktBOT;
import com.sfyvctwaqbjhki.uwmpqfh.ovlfuarnk.PluginNXUfldNktBOT;
import com.sfyvctwaqbjhki.uwmpqfh.ovlfuarnk.UAdaiF;
import com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.MCBNKIfi;
import com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.ZYlKAS;
import java.util.List;

/* loaded from: classes.dex */
public class KcUwgofnY {
    private static KcUwgofnY instance;
    private boolean isPayShow = false;
    private ZYlKAS payClass;
    private PayComponentCallBack payComponentCallBack;

    public interface PayComponentCallBack {
        void payFail(int i2, String str);

        void paySuccess();
    }

    public static KcUwgofnY getInstance() {
        if (instance == null) {
            instance = new KcUwgofnY();
        }
        return instance;
    }

    private void getProductList(final Activity activity) {
        MhrJWomE.netRequestProducts(new UserManager(UserManager.Type.REQUESTPRODUCTS) { // from class: com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.KcUwgofnY.2
            @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager
            public void fail(int i2, String str) {
                KcUwgofnY.this.isPayShow = false;
                LogUtils.e("get product list fail :" + str);
                WoUjMp.getInstance().getCallManager().getMCBNKIfi().payFail(str);
            }

            @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager
            public void response(Response response) {
                LogUtils.e("get product list by server success");
                List<RfybaJKCLilYpc> payChannelList = response.getPayChannelList();
                if (payChannelList.size() == 1 && ((payChannelList.get(0).getShowMethod().equals(ConstantUtil.SHOW_METHOD_LANUCH_NO_CONFIRM) || payChannelList.get(0).getShowMethod().equals(ConstantUtil.SHOW_METHOD_SYS_BROWSER)) && payChannelList.get(0).getShowProductList() == 0)) {
                    final RfybaJKCLilYpc rfybaJKCLilYpc = payChannelList.get(0);
                    Response.getInstance().setChoosePayChannel(rfybaJKCLilYpc);
                    KcUwgofnY.this.startPay(activity, rfybaJKCLilYpc, new PayComponentCallBack() { // from class: com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.KcUwgofnY.2.1
                        @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.KcUwgofnY.PayComponentCallBack
                        public void payFail(int i2, String str) {
                            KcUwgofnY.this.isPayShow = false;
                            ZGJWDCUOkpgHBx.payFail(str);
                        }

                        @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.KcUwgofnY.PayComponentCallBack
                        public void paySuccess() {
                            if (rfybaJKCLilYpc.getShowMethod().equals(ConstantUtil.SHOW_METHOD_SYS_BROWSER)) {
                                activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(Response.getInstance().getNetParamsBean().getPaymentUrl())));
                            }
                            KcUwgofnY.this.isPayShow = false;
                            ZGJWDCUOkpgHBx.paySuccess();
                        }
                    });
                } else if (activity.getResources().getConfiguration().orientation == 2) {
                    JqUIzeZd.createAndShow(activity);
                } else {
                    DMPOSpjVN.createAndShow(activity);
                }
            }
        });
    }

    private boolean isPayParamsOk(Activity activity, UGuwCakoQHjtD uGuwCakoQHjtD) {
        if (uGuwCakoQHjtD.getGameOrderId().equals("")) {
            Toast.makeText(activity, "GameOrderId is null", 0).show();
            return false;
        }
        if (uGuwCakoQHjtD.getGameZoneId().equals("")) {
            Toast.makeText(activity, "GameZoneId is null", 0).show();
            return false;
        }
        if (uGuwCakoQHjtD.getLevel().equals("")) {
            Toast.makeText(activity, "Level is null", 0).show();
            return false;
        }
        if (uGuwCakoQHjtD.getRoleId().equals("")) {
            Toast.makeText(activity, "RoleId is null", 0).show();
            return false;
        }
        if (!uGuwCakoQHjtD.getRoleName().equals("")) {
            return true;
        }
        Toast.makeText(activity, "RoleName is null", 0).show();
        return false;
    }

    private void preventInterruptCase() {
        new Handler().postDelayed(new Runnable() { // from class: com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.KcUwgofnY.1
            @Override // java.lang.Runnable
            public void run() {
                KcUwgofnY.this.isPayShow = false;
            }
        }, 5000L);
    }

    public PayComponentCallBack getPayComponentCallBack() {
        return this.payComponentCallBack;
    }

    public void initPay(Activity activity) {
        new NXUfldNktBOT().init(activity);
        new MYkqRJBojXaN().init(activity);
        new HwPay().init(activity);
    }

    public void launchPay(Activity activity, UGuwCakoQHjtD uGuwCakoQHjtD, MCBNKIfi mCBNKIfi) {
        if (!isPayParamsOk(activity, uGuwCakoQHjtD)) {
            WoUjMp.getInstance().getCallManager().getMCBNKIfi().payFail("UGuwCakoQHjtD Param is wrong!!!!!!");
            return;
        }
        boolean zIsInit = WoUjMp.getInstance().isInit();
        boolean zIsLogin = WoUjMp.getInstance().isLogin();
        if (zIsInit && zIsLogin && uGuwCakoQHjtD != null) {
            if (this.isPayShow) {
                LogUtils.e("Pay is going on!!!!!!!");
                return;
            }
            preventInterruptCase();
            this.isPayShow = true;
            Response.getInstance().setUGuwCakoQHjtD(uGuwCakoQHjtD);
            getProductList(activity);
            return;
        }
        if (!zIsInit) {
            mCBNKIfi.payFail(activity.getString(R.string.txt_noinit));
        } else if (zIsLogin) {
            mCBNKIfi.payFail(activity.getString(R.string.txt_pay_bean_null));
        } else {
            mCBNKIfi.payFail(activity.getString(R.string.txt_nologin));
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        ZYlKAS zYlKAS = this.payClass;
        if (zYlKAS != null) {
            zYlKAS.onActivityResult(i2, i3, intent);
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
    }

    public void setPayShow(boolean z2) {
        this.isPayShow = z2;
    }

    public void startPay(Activity activity, RfybaJKCLilYpc rfybaJKCLilYpc, PayComponentCallBack payComponentCallBack) {
        EDakAXiM eDakAXiM;
        this.payComponentCallBack = payComponentCallBack;
        eDakAXiM = Response.getInstance().getEDakAXiM();
        LogUtils.e("start pay channel " + rfybaJKCLilYpc.getChannel());
        String channel = rfybaJKCLilYpc.getChannel();
        channel.hashCode();
        switch (channel) {
            case "1":
                if (!eDakAXiM.getPublics().getGpPluginType().equals("1")) {
                    this.payClass = new NXUfldNktBOT();
                    break;
                } else {
                    this.payClass = PluginNXUfldNktBOT.getInstance();
                    break;
                }
            case "20":
                this.payClass = new HwPay();
                break;
            case "24":
                this.payClass = new MYkqRJBojXaN();
                break;
            default:
                this.payClass = UAdaiF.getInstance();
                break;
        }
        this.payClass.doPay(activity);
    }
}
