package com.sfyvctwaqbjhki.uwmpqfh.ovlfuarnk;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import com.google.gson.Gson;
import com.sfyvctwaqbjhki.uwmpqfh.WoUjMp;
import com.sfyvctwaqbjhki.uwmpqfh.biohepbeans.EDakAXiM;
import com.sfyvctwaqbjhki.uwmpqfh.biohepbeans.HcONeadzJqn;
import com.sfyvctwaqbjhki.uwmpqfh.biohepbeans.RfybaJKCLilYpc;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.DataUtil;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.LogUtils;
import com.sfyvctwaqbjhki.uwmpqfh.bokqjfarynhxdu.AFCBnG;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.YuHblIgwNAmtVR;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.NetParamsBean;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.KcUwgofnY;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.Response;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager;
import com.sfyvctwaqbjhki.uwmpqfh.msdiykjb.MhrJWomE;
import com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.ZYlKAS;

/* loaded from: classes.dex */
public class PluginNXUfldNktBOT extends ZYlKAS {
    public static final int ERROR_BINDSERVICE = -101;
    public static final int ERROR_CANNEL = -111;
    public static final int ERROR_CONSUME_OR_PAY = 2002;
    public static final int ERROR_NULL = -100;
    public static final int ERROR_UNKNOW = -11000;
    public static final int RESULT_ERROR = -1;
    public static final int SDK_CONSUME_ERROR = -1000;
    public static final int SDK_CONSUME_SUCCESS = 1000;
    private static PluginNXUfldNktBOT instance;
    private boolean isDoPay;
    private boolean isRegistAppInstall;
    private final String APPINSTALL_ACTION = "_VA_com.pg.event.INSTALL";
    private final int INVOKE_REQUEST_CODE = 100;
    private final int RESULT_SUCCESS = 200;
    private final int RESULT_CONSUME = 300;
    private Gson gson = new Gson();
    private PluginIghKACSecQpXL appInstallReceiver = new PluginIghKACSecQpXL();

    private class PluginIghKACSecQpXL extends BroadcastReceiver {
        private PluginIghKACSecQpXL() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("_VA_com.pg.event.INSTALL")) {
                String stringExtra = intent.getStringExtra(DataUtil.LEVEL_COLUMN.PACKAGENAME);
                LogUtils.e("app installed --" + stringExtra);
                if (stringExtra.equals(Response.getInstance().getEDakAXiM().getPublics().getGpPluginGpUrl()) && PluginNXUfldNktBOT.getInstance().isDoPay()) {
                    PluginNXUfldNktBOT.getInstance().doPay(WoUjMp.getInstance().getContext());
                }
            }
        }
    }

    private PluginNXUfldNktBOT() {
    }

    public static PluginNXUfldNktBOT getInstance() {
        if (instance == null) {
            instance = new PluginNXUfldNktBOT();
        }
        return instance;
    }

    private void showJumpGooglePlay(Activity activity) {
        activity.startActivity(new Intent(activity, (Class<?>) YuHblIgwNAmtVR.class));
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.ZYlKAS
    public void doPay(final Activity activity) {
        this.isDoPay = true;
        unRegistReceiver(activity);
        MhrJWomE.netMakeOrder(new UserManager(UserManager.Type.MAKEORDER) { // from class: com.sfyvctwaqbjhki.uwmpqfh.ovlfuarnk.PluginNXUfldNktBOT.1
            @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager
            public void fail(int i2, String str) {
                PluginNXUfldNktBOT.this.isDoPay = false;
                if (KcUwgofnY.getInstance().getPayComponentCallBack() != null) {
                    KcUwgofnY.getInstance().getPayComponentCallBack().payFail(i2, str);
                }
            }

            @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager
            public void response(Response response) {
                NetParamsBean netParamsBean = Response.getInstance().getNetParamsBean();
                RfybaJKCLilYpc choosePayChannel = Response.getInstance().getChoosePayChannel();
                HcONeadzJqn hcONeadzJqn = new HcONeadzJqn();
                hcONeadzJqn.setTransactionId(netParamsBean.getPlatTransactionId());
                hcONeadzJqn.setMoney(String.valueOf(netParamsBean.getMoney()));
                hcONeadzJqn.setCurrency(netParamsBean.getCurrency());
                hcONeadzJqn.setChannel(choosePayChannel.getChannel());
                hcONeadzJqn.setProductId(choosePayChannel.getSelectedProduct().getProductName());
                PluginNXUfldNktBOT.this.invokeClient(activity, -1, hcONeadzJqn);
            }
        });
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.ZYlKAS
    public void init(Activity activity) {
    }

    public void invokeClient(Activity activity, int i2, HcONeadzJqn hcONeadzJqn) {
        EDakAXiM eDakAXiM = Response.getInstance().getEDakAXiM();
        try {
            Intent intent = new Intent();
            intent.setData(Uri.parse(String.format(eDakAXiM.getPublics().getGpPluginAction(), new Object[0])));
            Bundle bundle = new Bundle();
            bundle.putString(DataUtil.LEVEL_COLUMN.PACKAGENAME, activity.getPackageName());
            bundle.putString("gpGoods", this.gson.toJson(hcONeadzJqn));
            bundle.putInt("consumeCode", i2);
            intent.putExtras(bundle);
            if (intent.resolveActivityInfo(activity.getPackageManager(), 65536) != null) {
                activity.startActivityForResult(intent, 100);
                return;
            }
            LogUtils.e("can't find the action Activity");
            registReceiver(activity);
            showJumpGooglePlay(activity);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public boolean isDoPay() {
        return this.isDoPay;
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.ZYlKAS
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 != 100 || KcUwgofnY.getInstance().getPayComponentCallBack() == null) {
            return;
        }
        if (i3 == -1) {
            if (intent == null || intent.getExtras() == null) {
                return;
            }
            int i4 = intent.getExtras().getInt("errorCode", ERROR_UNKNOW);
            String string = intent.getExtras().getString("errorMsg", "unknow error,errorMsg is null");
            this.isDoPay = false;
            KcUwgofnY.getInstance().getPayComponentCallBack().payFail(i4, string);
            return;
        }
        if (i3 == 200) {
            this.isDoPay = false;
            KcUwgofnY.getInstance().getPayComponentCallBack().paySuccess();
            NetParamsBean netParamsBean = Response.getInstance().getNetParamsBean();
            if (netParamsBean == null || netParamsBean.getPlatTransactionId() == null || netParamsBean.getPlatTransactionId().length() == 0) {
                return;
            }
            AFCBnG.getInstance().onPay(Response.getInstance().getUserInfo().getUserId(), netParamsBean.getPlatTransactionId(), netParamsBean.getMoney().doubleValue(), netParamsBean.getCurrency(), netParamsBean.getVipLevel(), WoUjMp.getInstance().getContext());
            return;
        }
        if (i3 != 300) {
            return;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            this.isDoPay = false;
            KcUwgofnY.getInstance().getPayComponentCallBack().payFail(-100, "the consume bundle is null");
            return;
        }
        String string2 = extras.getString("gpGoods");
        if (string2 == null) {
            this.isDoPay = false;
            KcUwgofnY.getInstance().getPayComponentCallBack().payFail(-100, "the consume gpGoods is null");
            return;
        }
        HcONeadzJqn hcONeadzJqn = (HcONeadzJqn) this.gson.fromJson(string2, HcONeadzJqn.class);
        LogUtils.e("onActivityResult--consume goodsBean=" + hcONeadzJqn.toString());
        NetParamsBean netParamsBean2 = Response.getInstance().getNetParamsBean();
        netParamsBean2.setPlatTransactionId(hcONeadzJqn.getTransactionId());
        netParamsBean2.setReceipt(hcONeadzJqn.getReceipt());
        netParamsBean2.setSignature(hcONeadzJqn.getSignature());
        netParamsBean2.setPayChannel(hcONeadzJqn.getChannel());
        LogUtils.e("调用sdk消费接口");
        sdkConsume(hcONeadzJqn);
    }

    public void registReceiver(Activity activity) {
        if (this.appInstallReceiver == null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("_VA_com.pg.event.INSTALL");
        new Intent("_VA_com.pg.event.INSTALL");
        if (this.isRegistAppInstall) {
            return;
        }
        activity.registerReceiver(this.appInstallReceiver, intentFilter);
        this.isRegistAppInstall = true;
        LogUtils.e("registReceiver");
    }

    public void sdkConsume(final HcONeadzJqn hcONeadzJqn) {
        LogUtils.e("sdkConsume");
        MhrJWomE.netConsumeOrder(new UserManager(UserManager.Type.CONSUMEORDER) { // from class: com.sfyvctwaqbjhki.uwmpqfh.ovlfuarnk.PluginNXUfldNktBOT.2
            @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager
            public void fail(int i2, String str) {
                LogUtils.e("sdkConsume--fail=code=" + i2 + "--msg=" + str);
                PluginNXUfldNktBOT.this.invokeClient(WoUjMp.getInstance().getContext(), -1000, hcONeadzJqn);
            }

            @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager
            public void response(Response response) {
                LogUtils.e("sdkConsume--response");
                PluginNXUfldNktBOT.this.invokeClient(WoUjMp.getInstance().getContext(), 1000, hcONeadzJqn);
            }
        });
    }

    public void setDoPay(boolean z2) {
        this.isDoPay = z2;
    }

    public void unRegistReceiver(Activity activity) {
        if (this.appInstallReceiver == null) {
            return;
        }
        new Intent("_VA_com.pg.event.INSTALL");
        if (this.isRegistAppInstall) {
            activity.unregisterReceiver(this.appInstallReceiver);
            LogUtils.e("unRegistReceiver");
            this.isRegistAppInstall = false;
        }
    }
}
