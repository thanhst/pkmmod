package com.sfyvctwaqbjhki.uwmpqfh.ebvmj.vertial;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.sfyvctwaqbjhki.uwmpqfh.R;
import com.sfyvctwaqbjhki.uwmpqfh.biohepbeans.RfybaJKCLilYpc;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.ErrorUtil;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.LogUtils;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.WxGIMQL;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.NALdIqmRM;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.OmoOpLlTaJfzAYs;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.OvSFXgdxe;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.VAswzYa;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.YqDvVAX;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.Zmxjahf;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.vertial.LGEvTK;
import com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.KcUwgofnY;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.Response;
import com.sfyvctwaqbjhki.uwmpqfh.msdiykjb.ZGJWDCUOkpgHBx;
import com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.NNXOHlAajkUISYActivity;
import com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.SingleBtnCallBack;
import java.util.List;

/* loaded from: classes.dex */
public class DMPOSpjVN extends NNXOHlAajkUISYActivity {
    private final int FRAGMENT_CONFIRM;
    private final int FRAGMENT_CONFIRM_CHANGE;
    private final int FRAGMENT_CONTENT;
    private final int FRAGMENT_GOODS_LIST;
    private final int FRAGMENT_SERIAL_PIN;
    private final int FRAGMENT_SUQERAD;
    private final int FRAGMENT_WEB;
    public LGEvTK cardSelectFragment;
    private RelativeLayout layout_back;
    private RelativeLayout layout_close;
    private List<RfybaJKCLilYpc> payChannelList;

    /* renamed from: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.vertial.DMPOSpjVN$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$vertial$DMPOSpjVN$Buttons;

        static {
            int[] iArr = new int[Buttons.values().length];
            $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$vertial$DMPOSpjVN$Buttons = iArr;
            try {
                iArr[Buttons.LAYOUT_BACK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$vertial$DMPOSpjVN$Buttons[Buttons.LAYOUT_CLOSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private enum Buttons {
        LAYOUT_BACK,
        LAYOUT_CLOSE
    }

    public DMPOSpjVN(Context context) {
        super(context);
        this.FRAGMENT_SUQERAD = 1;
        this.FRAGMENT_SERIAL_PIN = 2;
        this.FRAGMENT_CONTENT = 3;
        this.FRAGMENT_WEB = 4;
        this.FRAGMENT_CONFIRM = 5;
        this.FRAGMENT_CONFIRM_CHANGE = 6;
        this.FRAGMENT_GOODS_LIST = 8;
    }

    public static DMPOSpjVN createAndShow(Context context) {
        DMPOSpjVN dMPOSpjVN = new DMPOSpjVN(context);
        dMPOSpjVN.show();
        return dMPOSpjVN;
    }

    private void payCloseShow() {
        TextView textView = (TextView) findViewById(R.id.tv_pay_close);
        textView.setVisibility(0);
        textView.setText(R.string.txt_pay_not_open);
    }

    private void sendPay() {
        KcUwgofnY.getInstance().startPay(this.context, Response.getInstance().getChoosePayChannel(), new KcUwgofnY.PayComponentCallBack() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.vertial.DMPOSpjVN.1
            @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.KcUwgofnY.PayComponentCallBack
            public void payFail(int i2, String str) {
                DMPOSpjVN.this.showSingleBtnDialog(false, DMPOSpjVN.this.getContext().getString(R.string.txt_buy_fail), DMPOSpjVN.this.getContext().getString(ErrorUtil.getIdByCode(i2)));
            }

            @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.KcUwgofnY.PayComponentCallBack
            public void paySuccess() {
                DMPOSpjVN.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(Response.getInstance().getNetParamsBean().getPaymentUrl())));
                DMPOSpjVN.this.dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSingleBtnDialog(final boolean z2, String str, String str2) {
        WxGIMQL.createAndShow(str, str2, getContext().getString(R.string.txt_confirm), new SingleBtnCallBack() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.vertial.DMPOSpjVN.2
            @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.SingleBtnCallBack
            public void confirm() {
                if (z2) {
                    DMPOSpjVN.this.dismiss();
                }
            }
        });
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    protected void click(View view) {
        int i2 = AnonymousClass3.$SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$vertial$DMPOSpjVN$Buttons[((Buttons) view.getTag()).ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                return;
            }
            dismiss();
        } else if (backFragment() == -1) {
            dismiss();
        }
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.NNXOHlAajkUISYActivity
    protected NNXOHlAajkUISY createFragemnt(int i2) {
        switch (i2) {
            case 1:
                LGEvTK lGEvTK = new LGEvTK(this);
                this.cardSelectFragment = lGEvTK;
                return lGEvTK;
            case 2:
                return new VAswzYa(this);
            case 3:
                return new YqDvVAX(this);
            case 4:
                return new Zmxjahf(this);
            case 5:
                return new NALdIqmRM(this);
            case 6:
                return new OmoOpLlTaJfzAYs(this);
            case 7:
            default:
                return null;
            case 8:
                return new OvSFXgdxe(this);
        }
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    protected int createView() {
        return R.layout.cg_activity_pay_vertial;
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    public void dismiss() {
        LogUtils.e("支付界面关闭=====================================");
        ZGJWDCUOkpgHBx.paySuccess();
        KcUwgofnY.getInstance().setPayShow(false);
        super.dismiss();
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.NNXOHlAajkUISYActivity
    protected int fragmentLayout() {
        return R.id.fragment_main;
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    protected void initView() {
        this.layout_back = (RelativeLayout) findViewById(R.id.layout_back);
        this.layout_close = (RelativeLayout) findViewById(R.id.layout_close);
        this.layout_back.setTag(Buttons.LAYOUT_BACK);
        this.layout_close.setTag(Buttons.LAYOUT_CLOSE);
        this.layout_back.setOnTouchListener(this);
        this.layout_close.setOnTouchListener(this);
        List<RfybaJKCLilYpc> payChannelList = Response.getInstance().getPayChannelList();
        this.payChannelList = payChannelList;
        if (payChannelList.size() == 1) {
            showPayChannel(-1, this.payChannelList.get(0));
        } else if (this.payChannelList.size() > 1) {
            clearTaskWithNoAnim(1);
        } else {
            payCloseShow();
        }
    }

    public void showPayChannel(int i2, RfybaJKCLilYpc rfybaJKCLilYpc) {
        Response.getInstance().setChoosePayChannel(rfybaJKCLilYpc);
        String showMethod = rfybaJKCLilYpc.getShowMethod();
        showMethod.hashCode();
        switch (showMethod) {
            case "0":
                clearTaskWithNoAnim(4);
                break;
            case "1":
            case "2":
                clearTaskWithNoAnim(2);
                break;
            case "3":
            case "7":
            case "9":
            case "10":
            case "11":
            case "13":
                clearTaskWithNoAnim(5);
                break;
            case "4":
                if (rfybaJKCLilYpc.getNodes().size() != 0) {
                    if (rfybaJKCLilYpc.getNodes().size() != 1) {
                        clearTaskWithNoAnim(1);
                        break;
                    } else {
                        showPayChannel(i2, rfybaJKCLilYpc.getNodes().get(0));
                        break;
                    }
                } else {
                    Toast.makeText(this.context, "Server Pay way configuration is wrong!", 0).show();
                    break;
                }
            case "5":
                clearTaskWithNoAnim(6);
                break;
            case "6":
                clearTaskWithNoAnim(3);
                break;
            case "12":
                sendPay();
                break;
        }
    }
}
