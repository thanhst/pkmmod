package com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment;

import android.content.Intent;
import android.net.Uri;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.sfyvctwaqbjhki.uwmpqfh.R;
import com.sfyvctwaqbjhki.uwmpqfh.biohepbeans.RfybaJKCLilYpc;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.ConstantUtil;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.DeviceUtil;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.ErrorUtil;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.SYwCAo;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.WxGIMQL;
import com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY;
import com.sfyvctwaqbjhki.uwmpqfh.lebktch.WOMSQzPaksWfHUC;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.KcUwgofnY;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.Response;
import com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.NNXOHlAajkUISYActivity;
import com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.DoubleBtnCallBack;
import com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.SingleBtnCallBack;

/* loaded from: classes.dex */
public class NALdIqmRM extends NNXOHlAajkUISY {
    private ImageView mAppIconIv;
    private Button mBuyBtn;
    private TextView mMoneyPayTv;
    private TextView mTipsTv;
    private TextView mTitleTv;
    private TextView mVirtualCoinTv;
    private RfybaJKCLilYpc selectPayChannel;

    /* renamed from: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.NALdIqmRM$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$fragment$NALdIqmRM$Buttons;

        static {
            int[] iArr = new int[Buttons.values().length];
            $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$fragment$NALdIqmRM$Buttons = iArr;
            try {
                iArr[Buttons.BTNBUY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private enum Buttons {
        BTNBUY
    }

    public NALdIqmRM(NNXOHlAajkUISYActivity nNXOHlAajkUISYActivity) {
        super(nNXOHlAajkUISYActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDoubleBtnDialog(String str, String str2) {
        WxGIMQL.createAndShow(str, str2, getContext().getString(R.string.txt_cancel), getContext().getString(R.string.txt_confirm), new DoubleBtnCallBack() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.NALdIqmRM.3
            @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.DoubleBtnCallBack
            public void cancel() {
                ((NNXOHlAajkUISY) NALdIqmRM.this).activity.dismiss();
            }

            @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.SingleBtnCallBack
            public void confirm() {
                ((NNXOHlAajkUISY) NALdIqmRM.this).activity.dismiss();
                SYwCAo.createAndShow(NALdIqmRM.this.getContext());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSingleBtnDialog(final boolean z2, String str, String str2) {
        WxGIMQL.createAndShow(str, str2, getContext().getString(R.string.txt_confirm), new SingleBtnCallBack() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.NALdIqmRM.2
            @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.SingleBtnCallBack
            public void confirm() {
                if (z2) {
                    ((NNXOHlAajkUISY) NALdIqmRM.this).activity.dismiss();
                }
            }
        });
    }

    private void startPay() {
        if (isDoubleClick()) {
        }
        String showMethod = this.selectPayChannel.getShowMethod();
        showMethod.hashCode();
        switch (showMethod) {
            case "9":
                WOMSQzPaksWfHUC wOMSQzPaksWfHUC = this.innerFragment;
                if (wOMSQzPaksWfHUC != null) {
                    if (wOMSQzPaksWfHUC instanceof BHkzDf) {
                        ((BHkzDf) wOMSQzPaksWfHUC).cardSelectFragment.proceeInnerFragment(4);
                        break;
                    }
                } else {
                    proceeFragment(4);
                    break;
                }
                break;
            case "10":
            case "11":
                WOMSQzPaksWfHUC wOMSQzPaksWfHUC2 = this.innerFragment;
                if (wOMSQzPaksWfHUC2 != null) {
                    if (wOMSQzPaksWfHUC2 instanceof BHkzDf) {
                        ((BHkzDf) wOMSQzPaksWfHUC2).cardSelectFragment.proceeInnerFragment(2);
                        break;
                    }
                } else {
                    proceeFragment(2);
                    break;
                }
                break;
            default:
                KcUwgofnY.getInstance().startPay(this.activity.getContext(), this.selectPayChannel, new KcUwgofnY.PayComponentCallBack() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.NALdIqmRM.1
                    @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.KcUwgofnY.PayComponentCallBack
                    public void payFail(int i2, String str) {
                        String string = NALdIqmRM.this.getContext().getString(ErrorUtil.getIdByCode(i2));
                        NALdIqmRM nALdIqmRM = NALdIqmRM.this;
                        nALdIqmRM.showSingleBtnDialog(i2 == 206, nALdIqmRM.getContext().getString(i2 == 206 ? R.string.txt_pay_pending : R.string.txt_buy_fail), string);
                    }

                    @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.KcUwgofnY.PayComponentCallBack
                    public void paySuccess() {
                        if (NALdIqmRM.this.selectPayChannel.getShowMethod().equals(ConstantUtil.SHOW_METHOD_CONFIRM_SYS_BROWSER)) {
                            NALdIqmRM.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(Response.getInstance().getNetParamsBean().getPaymentUrl())));
                            ((NNXOHlAajkUISY) NALdIqmRM.this).activity.dismiss();
                            return;
                        }
                        String string = NALdIqmRM.this.getContext().getString(R.string.txt_buy_success);
                        if (Response.getInstance().getUserInfo().getUserType() == ConstantUtil.USER_TYPE_VISTOR) {
                            NALdIqmRM.this.showDoubleBtnDialog(string, NALdIqmRM.this.getContext().getString(R.string.txt_tourist_update_tips));
                        } else {
                            NALdIqmRM.this.showSingleBtnDialog(true, string, NALdIqmRM.this.getContext().getString(R.string.txt_buy_success_tip));
                        }
                    }
                });
                break;
        }
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    protected void click(View view) {
        if (AnonymousClass4.$SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$fragment$NALdIqmRM$Buttons[((Buttons) view.getTag()).ordinal()] != 1) {
            return;
        }
        startPay();
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    public void onCreat(View view) {
        this.mTitleTv = (TextView) view.findViewById(R.id.confirm_title);
        TextView textView = (TextView) view.findViewById(R.id.confirm_exchange_rate);
        this.mTipsTv = (TextView) view.findViewById(R.id.buy_tips_tv);
        textView.setVisibility(4);
        this.mVirtualCoinTv = (TextView) view.findViewById(R.id.tv_virtual_coin);
        this.mMoneyPayTv = (TextView) view.findViewById(R.id.tv_pay_money);
        this.mBuyBtn = (Button) view.findViewById(R.id.btn_buy);
        this.mAppIconIv = (ImageView) view.findViewById(R.id.app_icon_iv);
        this.mBuyBtn.setTag(Buttons.BTNBUY);
        this.mBuyBtn.setOnTouchListener(this);
        onRefresh();
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    public View onCreateView(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(R.layout.cg_fragment_pay_confirm, (ViewGroup) null);
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    public void onRefresh() {
        RfybaJKCLilYpc choosePayChannel = Response.getInstance().getChoosePayChannel();
        this.selectPayChannel = choosePayChannel;
        this.mTitleTv.setText(choosePayChannel.getName());
        this.mVirtualCoinTv.setText(Html.fromHtml(this.selectPayChannel.getSelectedProduct().getProductDesc()));
        this.mMoneyPayTv.setText(this.selectPayChannel.getSelectedProduct().getShortCurrency() + " " + this.selectPayChannel.getSelectedProduct().getAmount());
        this.mAppIconIv.setImageDrawable(DeviceUtil.getAppIcon(getContext()));
        if (this.selectPayChannel.getDescription().length() != 0) {
            this.mTipsTv.setText(this.selectPayChannel.getDescription());
        } else {
            this.mTipsTv.setText(getContext().getString(R.string.txt_pay_defualt_tips));
        }
    }

    public NALdIqmRM(NNXOHlAajkUISYActivity nNXOHlAajkUISYActivity, WOMSQzPaksWfHUC wOMSQzPaksWfHUC) {
        super(nNXOHlAajkUISYActivity, wOMSQzPaksWfHUC);
    }
}
