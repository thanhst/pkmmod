package com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.sfyvctwaqbjhki.uwmpqfh.R;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.ErrorUtil;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.WxGIMQL;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.NetParamsBean;
import com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.Response;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager;
import com.sfyvctwaqbjhki.uwmpqfh.msdiykjb.MhrJWomE;
import com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.NNXOHlAajkUISYActivity;
import com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.SingleBtnCallBack;

/* loaded from: classes.dex */
public class KlcJIb extends NNXOHlAajkUISY {
    private final String BTN_CONFIRM;
    private final String EDIT_ACC;
    private Button btn_confirm;
    private Runnable ctdownRunnable;
    private int currentCountTime;
    private EditText edit_acc;

    /* renamed from: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.KlcJIb$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$fragment$KlcJIb$Buttons;

        static {
            int[] iArr = new int[Buttons.values().length];
            $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$fragment$KlcJIb$Buttons = iArr;
            try {
                iArr[Buttons.BTN_CONFIRM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private enum Buttons {
        BTN_CONFIRM
    }

    public KlcJIb(NNXOHlAajkUISYActivity nNXOHlAajkUISYActivity) {
        super(nNXOHlAajkUISYActivity);
        this.BTN_CONFIRM = "btn_confirm";
        this.EDIT_ACC = "edit_acc";
        this.currentCountTime = 60;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetConfirmCountdown() {
        Runnable runnable = this.ctdownRunnable;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
        }
        this.btn_confirm.setEnabled(true);
        this.currentCountTime = 60;
        this.btn_confirm.setText(getContext().getString(R.string.txt_confirm));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog(String str, String str2) {
        WxGIMQL.createAndShow(str, str2, getContext().getString(R.string.txt_confirm), new SingleBtnCallBack() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.KlcJIb.3
            @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.SingleBtnCallBack
            public void confirm() {
            }
        });
    }

    private void startConfirmCountdown() {
        if (this.ctdownRunnable == null) {
            this.ctdownRunnable = new Runnable() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.KlcJIb.2
                @Override // java.lang.Runnable
                public void run() {
                    if (KlcJIb.this.currentCountTime > 0) {
                        KlcJIb.this.btn_confirm.setText(KlcJIb.this.getContext().getString(R.string.txt_confirm) + "(" + KlcJIb.this.currentCountTime + "s)");
                        ((NNXOHlAajkUISY) KlcJIb.this).handler.postDelayed(this, 1000L);
                    } else {
                        KlcJIb.this.resetConfirmCountdown();
                    }
                    KlcJIb klcJIb = KlcJIb.this;
                    klcJIb.currentCountTime--;
                }
            };
        }
        this.handler.post(this.ctdownRunnable);
        this.btn_confirm.setEnabled(false);
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    protected void click(View view) {
        if (AnonymousClass4.$SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$fragment$KlcJIb$Buttons[((Buttons) view.getTag()).ordinal()] != 1) {
            return;
        }
        String strTrim = this.edit_acc.getText().toString().trim();
        if (strTrim.equals("")) {
            Toast.makeText(getContext(), R.string.txt_hint_account, 0).show();
            return;
        }
        NetParamsBean netParamsBean = new NetParamsBean();
        netParamsBean.setExInfo(strTrim);
        Response.getInstance().setNetParamsBean(netParamsBean);
        MhrJWomE.netForgetPwd(new UserManager(UserManager.Type.FORGETPSW) { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.KlcJIb.1
            @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager
            public void fail(int i2, String str) {
                KlcJIb.this.resetConfirmCountdown();
                KlcJIb klcJIb = KlcJIb.this;
                klcJIb.showDialog(klcJIb.getContext().getString(R.string.txt_send_fail), KlcJIb.this.getContext().getString(ErrorUtil.getIdByCode(i2)));
            }

            @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager
            public void response(Response response) {
                KlcJIb klcJIb = KlcJIb.this;
                klcJIb.showDialog(klcJIb.getContext().getString(R.string.txt_send_success), KlcJIb.this.getContext().getString(R.string.txt_send_email_success));
            }
        });
        startConfirmCountdown();
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    public void onCreat(View view) {
        this.btn_confirm = (Button) findViewById(R.id.btn_confirm);
        this.edit_acc = (EditText) findViewById(R.id.edit_acc);
        this.btn_confirm.setTag(Buttons.BTN_CONFIRM);
        this.btn_confirm.setOnTouchListener(this);
        onRefresh();
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    public View onCreateView(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(R.layout.cg_fragment_forget_pwd, (ViewGroup) null);
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    public void onRefresh() {
        this.edit_acc.setText("");
        resetConfirmCountdown();
    }
}
