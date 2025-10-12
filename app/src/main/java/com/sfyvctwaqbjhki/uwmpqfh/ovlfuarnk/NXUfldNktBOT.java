package com.sfyvctwaqbjhki.uwmpqfh.ovlfuarnk;

import android.app.Activity;
import android.content.Intent;
import com.sfyvctwaqbjhki.uwmpqfh.WoUjMp;
import com.sfyvctwaqbjhki.uwmpqfh.biohepbeans.RfybaJKCLilYpc;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.LogUtils;
import com.sfyvctwaqbjhki.uwmpqfh.bokqjfarynhxdu.AFCBnG;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.ConfigBean;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.NetParamsBean;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.UGuwCakoQHjtD;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.UserInfo;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.KcUwgofnY;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.Response;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager;
import com.sfyvctwaqbjhki.uwmpqfh.msdiykjb.MhrJWomE;
import com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.ZYlKAS;
import com.ykiocnwpdseglq.lbmntzwepqakgu.ReDqOTXKRs;
import com.ykiocnwpdseglq.lbmntzwepqakgu.beans.AibIyCdHmGwOql;
import com.ykiocnwpdseglq.lbmntzwepqakgu.beans.EHpbXBY;
import com.ykiocnwpdseglq.lbmntzwepqakgu.beans.OEtWoBzalfeg;
import com.ykiocnwpdseglq.lbmntzwepqakgu.beans.OpHzXGktYUTIAhi;
import com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.DIUGfDWQpOJHLr;
import com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.PurchaseListener;

/* loaded from: classes.dex */
public class NXUfldNktBOT extends ZYlKAS {

    /* renamed from: com.sfyvctwaqbjhki.uwmpqfh.ovlfuarnk.NXUfldNktBOT$7, reason: invalid class name */
    static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] $SwitchMap$com$ykiocnwpdseglq$lbmntzwepqakgu$interfaces$PurchaseListener$PurchaseInitState;
        static final /* synthetic */ int[] $SwitchMap$com$ykiocnwpdseglq$lbmntzwepqakgu$interfaces$PurchaseListener$PurchaseState;

        static {
            int[] iArr = new int[PurchaseListener.PurchaseState.values().length];
            $SwitchMap$com$ykiocnwpdseglq$lbmntzwepqakgu$interfaces$PurchaseListener$PurchaseState = iArr;
            try {
                iArr[PurchaseListener.PurchaseState.PURCHASE_STATE_PAY_SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ykiocnwpdseglq$lbmntzwepqakgu$interfaces$PurchaseListener$PurchaseState[PurchaseListener.PurchaseState.PURCHASE_STATE_PAY_FAIL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ykiocnwpdseglq$lbmntzwepqakgu$interfaces$PurchaseListener$PurchaseState[PurchaseListener.PurchaseState.PURCHASE_STATE_PAY_CANCEL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[PurchaseListener.PurchaseInitState.values().length];
            $SwitchMap$com$ykiocnwpdseglq$lbmntzwepqakgu$interfaces$PurchaseListener$PurchaseInitState = iArr2;
            try {
                iArr2[PurchaseListener.PurchaseInitState.PURCHASE_INIT_STATE_FINISH.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ykiocnwpdseglq$lbmntzwepqakgu$interfaces$PurchaseListener$PurchaseInitState[PurchaseListener.PurchaseInitState.PURCHASE_INIT_STATE_FAIL.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void consumeAsync(Activity activity, final AibIyCdHmGwOql aibIyCdHmGwOql) {
        NetParamsBean netParamsBean = Response.getInstance().getNetParamsBean();
        if (netParamsBean != null && netParamsBean.getPlatTransactionId() != null && netParamsBean.getPlatTransactionId().length() != 0) {
            AFCBnG.getInstance().onPay(Response.getInstance().getUserInfo().getUserId(), netParamsBean.getPlatTransactionId(), netParamsBean.getMoney().doubleValue(), netParamsBean.getCurrency(), netParamsBean.getVipLevel(), WoUjMp.getInstance().getContext());
        }
        ReDqOTXKRs.payCostOrder(OpHzXGktYUTIAhi.GOOGLE_PAY_PLUGIN, activity, new DIUGfDWQpOJHLr.ParamGetter() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ovlfuarnk.NXUfldNktBOT.6
            @Override // com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.DIUGfDWQpOJHLr.ParamGetter
            public Object getPayParam() {
                return aibIyCdHmGwOql;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postNXUfldNktBOT(final Activity activity, final AibIyCdHmGwOql aibIyCdHmGwOql) {
        NetParamsBean netParamsBean = Response.getInstance().getNetParamsBean();
        netParamsBean.setReceipt(aibIyCdHmGwOql.getReceipt());
        netParamsBean.setSignature(aibIyCdHmGwOql.getSignature());
        netParamsBean.setPayChannel(aibIyCdHmGwOql.getOEtWoBzalfeg().getPayChannel());
        netParamsBean.setPlatTransactionId(aibIyCdHmGwOql.getOEtWoBzalfeg().getPlatTransactionId());
        netParamsBean.setExInfo(aibIyCdHmGwOql.getExInfo());
        LogUtils.e("调用sdk消费接口");
        MhrJWomE.netConsumeOrder(new UserManager(UserManager.Type.CONSUMEORDER) { // from class: com.sfyvctwaqbjhki.uwmpqfh.ovlfuarnk.NXUfldNktBOT.5
            @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager
            public void fail(int i2, String str) {
                if (KcUwgofnY.getInstance().getPayComponentCallBack() != null) {
                    KcUwgofnY.getInstance().getPayComponentCallBack().payFail(i2, str);
                }
            }

            @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager
            public void response(Response response) {
                LogUtils.e("sdk 服务器消费成功，调用google消费接口");
                NXUfldNktBOT.this.consumeAsync(activity, aibIyCdHmGwOql);
                if (KcUwgofnY.getInstance().getPayComponentCallBack() != null) {
                    KcUwgofnY.getInstance().getPayComponentCallBack().paySuccess();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPay(Activity activity) {
        LogUtils.e("official pay start pay...");
        ReDqOTXKRs.payStart(OpHzXGktYUTIAhi.GOOGLE_PAY_PLUGIN, activity, new DIUGfDWQpOJHLr.ParamGetter<OEtWoBzalfeg>() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ovlfuarnk.NXUfldNktBOT.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.DIUGfDWQpOJHLr.ParamGetter
            public OEtWoBzalfeg getPayParam() {
                NetParamsBean netParamsBean = Response.getInstance().getNetParamsBean();
                UserInfo userInfo = Response.getInstance().getUserInfo();
                ConfigBean configBean = Response.getInstance().getConfigBean();
                UGuwCakoQHjtD uGuwCakoQHjtD = Response.getInstance().getUGuwCakoQHjtD();
                RfybaJKCLilYpc choosePayChannel = Response.getInstance().getChoosePayChannel();
                OEtWoBzalfeg oEtWoBzalfeg = new OEtWoBzalfeg();
                oEtWoBzalfeg.setPlatTransactionId(netParamsBean.getPlatTransactionId());
                oEtWoBzalfeg.setMoney(String.valueOf(netParamsBean.getMoney()));
                oEtWoBzalfeg.setCurrency(netParamsBean.getCurrency());
                oEtWoBzalfeg.setUserId(userInfo.getUserId());
                oEtWoBzalfeg.setRoleName(uGuwCakoQHjtD.getRoleName());
                oEtWoBzalfeg.setRoleId(uGuwCakoQHjtD.getRoleId());
                oEtWoBzalfeg.setAdvChannel(configBean.getAdvChannel());
                oEtWoBzalfeg.setAppId(configBean.getAppId());
                oEtWoBzalfeg.setPayChannel(choosePayChannel.getChannel());
                oEtWoBzalfeg.setProductId(choosePayChannel.getSelectedProduct().getProductName());
                oEtWoBzalfeg.setProductName(choosePayChannel.getSelectedProduct().getProductDesc());
                oEtWoBzalfeg.setExInfo(choosePayChannel.getExInfo());
                return oEtWoBzalfeg;
            }
        });
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.ZYlKAS
    public void doPay(final Activity activity) {
        MhrJWomE.netMakeOrder(new UserManager(UserManager.Type.MAKEORDER) { // from class: com.sfyvctwaqbjhki.uwmpqfh.ovlfuarnk.NXUfldNktBOT.3
            @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager
            public void fail(int i2, String str) {
                if (KcUwgofnY.getInstance().getPayComponentCallBack() != null) {
                    KcUwgofnY.getInstance().getPayComponentCallBack().payFail(i2, str);
                }
            }

            @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager
            public void response(Response response) {
                NXUfldNktBOT.this.startPay(activity);
            }
        });
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.ZYlKAS
    public void init(final Activity activity) {
        ReDqOTXKRs.payInit(OpHzXGktYUTIAhi.GOOGLE_PAY_PLUGIN, activity, new DIUGfDWQpOJHLr.ParamGetter<EHpbXBY>() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ovlfuarnk.NXUfldNktBOT.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.DIUGfDWQpOJHLr.ParamGetter
            public EHpbXBY getPayParam() {
                ConfigBean configBean = Response.getInstance().getConfigBean();
                EHpbXBY eHpbXBY = new EHpbXBY();
                eHpbXBY.setAppChannel(configBean.getAdvChannel());
                eHpbXBY.setAppId(String.valueOf(configBean.getAppId()));
                return eHpbXBY;
            }
        }, new PurchaseListener<AibIyCdHmGwOql>() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ovlfuarnk.NXUfldNktBOT.2
            @Override // com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.PurchaseListener
            public void initCallBack(PurchaseListener.PurchaseInitState purchaseInitState, String str) {
                int i2 = AnonymousClass7.$SwitchMap$com$ykiocnwpdseglq$lbmntzwepqakgu$interfaces$PurchaseListener$PurchaseInitState[purchaseInitState.ordinal()];
                if (i2 == 1) {
                    LogUtils.e("google pay is init success");
                } else {
                    if (i2 != 2) {
                        return;
                    }
                    LogUtils.e("google pay is init fail");
                }
            }

            @Override // com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.PurchaseListener
            public void payCallBack(PurchaseListener.PurchaseState purchaseState, AibIyCdHmGwOql aibIyCdHmGwOql, String str) {
                int i2 = AnonymousClass7.$SwitchMap$com$ykiocnwpdseglq$lbmntzwepqakgu$interfaces$PurchaseListener$PurchaseState[purchaseState.ordinal()];
                if (i2 == 1) {
                    NXUfldNktBOT.this.postNXUfldNktBOT(activity, aibIyCdHmGwOql);
                    return;
                }
                if (i2 != 2) {
                    if (i2 != 3) {
                        return;
                    }
                    LogUtils.e("user cancel");
                } else {
                    LogUtils.e(str);
                    if (KcUwgofnY.getInstance().getPayComponentCallBack() != null) {
                        KcUwgofnY.getInstance().getPayComponentCallBack().payFail(PluginNXUfldNktBOT.ERROR_CONSUME_OR_PAY, str);
                    }
                }
            }
        });
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.ZYlKAS
    public void onActivityResult(int i2, int i3, Intent intent) {
    }
}
