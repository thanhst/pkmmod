package com.sfyvctwaqbjhki.uwmpqfh.ovlfuarnk;

import android.app.Activity;
import com.sfyvctwaqbjhki.uwmpqfh.biohepbeans.EDakAXiM;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.LogUtils;
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
public class MYkqRJBojXaN extends ZYlKAS {

    /* renamed from: com.sfyvctwaqbjhki.uwmpqfh.ovlfuarnk.MYkqRJBojXaN$7, reason: invalid class name */
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
        ReDqOTXKRs.payCostOrder(OpHzXGktYUTIAhi.ONE_STORE_PLUGIN, activity, new DIUGfDWQpOJHLr.ParamGetter() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ovlfuarnk.MYkqRJBojXaN.6
            @Override // com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.DIUGfDWQpOJHLr.ParamGetter
            public Object getPayParam() {
                return aibIyCdHmGwOql;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void costAfterPay(final Activity activity, final AibIyCdHmGwOql aibIyCdHmGwOql) {
        LogUtils.e("调用sdk消费接口");
        MhrJWomE.netConsumeOrder(new UserManager(UserManager.Type.CONSUMEORDER) { // from class: com.sfyvctwaqbjhki.uwmpqfh.ovlfuarnk.MYkqRJBojXaN.5
            @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager
            public void fail(int i2, String str) {
                if (KcUwgofnY.getInstance().getPayComponentCallBack() != null) {
                    KcUwgofnY.getInstance().getPayComponentCallBack().payFail(i2, str);
                }
            }

            @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager
            public void response(Response response) {
                MYkqRJBojXaN.this.consumeAsync(activity, aibIyCdHmGwOql);
                if (KcUwgofnY.getInstance().getPayComponentCallBack() != null) {
                    KcUwgofnY.getInstance().getPayComponentCallBack().paySuccess();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPay(Activity activity) {
        ReDqOTXKRs.payStart(OpHzXGktYUTIAhi.ONE_STORE_PLUGIN, activity, new DIUGfDWQpOJHLr.ParamGetter<OEtWoBzalfeg>() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ovlfuarnk.MYkqRJBojXaN.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.DIUGfDWQpOJHLr.ParamGetter
            public OEtWoBzalfeg getPayParam() {
                EDakAXiM eDakAXiM = Response.getInstance().getEDakAXiM();
                NetParamsBean netParamsBean = Response.getInstance().getNetParamsBean();
                ConfigBean configBean = Response.getInstance().getConfigBean();
                UGuwCakoQHjtD uGuwCakoQHjtD = Response.getInstance().getUGuwCakoQHjtD();
                UserInfo userInfo = Response.getInstance().getUserInfo();
                OEtWoBzalfeg oEtWoBzalfeg = new OEtWoBzalfeg();
                oEtWoBzalfeg.setAppId(configBean.getAppId());
                oEtWoBzalfeg.setRoleId(uGuwCakoQHjtD.getRoleId());
                oEtWoBzalfeg.setRoleName(uGuwCakoQHjtD.getRoleName());
                oEtWoBzalfeg.setUserId(userInfo.getUserId());
                oEtWoBzalfeg.setCurrency(netParamsBean.getCurrency());
                oEtWoBzalfeg.setMoney(String.valueOf(netParamsBean.getMoney()));
                oEtWoBzalfeg.setPlatTransactionId(netParamsBean.getPlatTransactionId());
                oEtWoBzalfeg.setExInfo(eDakAXiM.getOneStoreAppId());
                return oEtWoBzalfeg;
            }
        });
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.ZYlKAS
    public void doPay(final Activity activity) {
        MhrJWomE.netMakeOrder(new UserManager(UserManager.Type.MAKEORDER) { // from class: com.sfyvctwaqbjhki.uwmpqfh.ovlfuarnk.MYkqRJBojXaN.3
            @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager
            public void fail(int i2, String str) {
                if (KcUwgofnY.getInstance().getPayComponentCallBack() != null) {
                    KcUwgofnY.getInstance().getPayComponentCallBack().payFail(i2, str);
                }
            }

            @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager
            public void response(Response response) {
                MYkqRJBojXaN.this.startPay(activity);
            }
        });
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.ZYlKAS
    public void init(final Activity activity) {
        ReDqOTXKRs.payInit(OpHzXGktYUTIAhi.ONE_STORE_PLUGIN, activity, new DIUGfDWQpOJHLr.ParamGetter<EHpbXBY>() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ovlfuarnk.MYkqRJBojXaN.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.DIUGfDWQpOJHLr.ParamGetter
            public EHpbXBY getPayParam() {
                return null;
            }
        }, new PurchaseListener<AibIyCdHmGwOql>() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ovlfuarnk.MYkqRJBojXaN.2
            @Override // com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.PurchaseListener
            public void initCallBack(PurchaseListener.PurchaseInitState purchaseInitState, String str) {
                int i2 = AnonymousClass7.$SwitchMap$com$ykiocnwpdseglq$lbmntzwepqakgu$interfaces$PurchaseListener$PurchaseInitState[purchaseInitState.ordinal()];
                if (i2 == 1) {
                    LogUtils.e("one store is init success");
                } else {
                    if (i2 != 2) {
                        return;
                    }
                    LogUtils.e("one store is init fail");
                }
            }

            @Override // com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.PurchaseListener
            public void payCallBack(PurchaseListener.PurchaseState purchaseState, AibIyCdHmGwOql aibIyCdHmGwOql, String str) {
                int i2 = AnonymousClass7.$SwitchMap$com$ykiocnwpdseglq$lbmntzwepqakgu$interfaces$PurchaseListener$PurchaseState[purchaseState.ordinal()];
                if (i2 == 1) {
                    MYkqRJBojXaN.this.costAfterPay(activity, aibIyCdHmGwOql);
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
}
