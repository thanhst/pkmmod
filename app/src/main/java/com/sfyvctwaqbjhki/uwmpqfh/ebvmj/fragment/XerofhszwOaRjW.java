package com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.sfyvctwaqbjhki.uwmpqfh.R;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.CommonUtils;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.ConstantUtil;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.ErrorUtil;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.WxGIMQL;
import com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY;
import com.sfyvctwaqbjhki.uwmpqfh.lebktch.WOMSQzPaksWfHUC;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.Response;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager;
import com.sfyvctwaqbjhki.uwmpqfh.msdiykjb.MhrJWomE;
import com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.NNXOHlAajkUISYActivity;
import com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.DoubleBtnCallBack;

/* loaded from: classes.dex */
public class XerofhszwOaRjW extends NNXOHlAajkUISY {
    private static final String BTN_CONFIRM_BIND = "btn_confirm_bind";
    private final String EDIT_BIND_EMAIL;
    private Button mConfirmBindTwoBtn;
    private EditText mEmailEt;

    /* renamed from: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.XerofhszwOaRjW$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$fragment$XerofhszwOaRjW$Buttons;

        static {
            int[] iArr = new int[Buttons.values().length];
            $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$fragment$XerofhszwOaRjW$Buttons = iArr;
            try {
                iArr[Buttons.BTN_CONFIRM_BIND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private enum Buttons {
        BTN_CONFIRM_BIND,
        BTN_GET_VERIFY
    }

    public XerofhszwOaRjW(NNXOHlAajkUISYActivity nNXOHlAajkUISYActivity, WOMSQzPaksWfHUC wOMSQzPaksWfHUC) {
        super(nNXOHlAajkUISYActivity, wOMSQzPaksWfHUC);
        this.EDIT_BIND_EMAIL = "edit_bind_email";
    }

    private void initView(View view) throws Resources.NotFoundException {
        this.mEmailEt = (EditText) view.findViewById(R.id.edit_bind_email);
        Button button = (Button) view.findViewById(R.id.btn_confirm_bind);
        this.mConfirmBindTwoBtn = button;
        button.setTag(Buttons.BTN_CONFIRM_BIND);
        this.mConfirmBindTwoBtn.setOnTouchListener(this);
        resetView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void netBind() {
        MhrJWomE.netBindEmail(new UserManager(UserManager.Type.BINDEMAIL) { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.XerofhszwOaRjW.2
            @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager
            public void fail(int i2, String str) {
                Toast.makeText(XerofhszwOaRjW.this.getContext(), ErrorUtil.getIdByCode(i2), 0).show();
            }

            @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager
            public void response(Response response) {
                ((NNXOHlAajkUISY) XerofhszwOaRjW.this).activity.clearTaskAndback(1);
                Toast.makeText(XerofhszwOaRjW.this.getContext(), R.string.account_bind_success, 0).show();
            }
        });
    }

    private void netConfirmBind() {
        if (CommonUtils.isFastDoubleClick()) {
            return;
        }
        String strTrim = this.mEmailEt.getText().toString().trim();
        if (!CommonUtils.emailFormat(strTrim)) {
            Toast.makeText(getContext(), R.string.txt_input_valid_email, 0).show();
            return;
        }
        Response.getInstance().getNetParamsBean().setBindEmail(strTrim);
        WxGIMQL.createAndShow(getContext().getString(R.string.txt_safe_set), getContext().getString(R.string.txt_alert_msg1) + "【" + strTrim + "】" + getContext().getString(R.string.txt_alert_msg2), getContext().getString(R.string.txt_cancel), getContext().getString(R.string.txt_confirm), new DoubleBtnCallBack() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.XerofhszwOaRjW.1
            @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.DoubleBtnCallBack
            public void cancel() {
            }

            @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.SingleBtnCallBack
            public void confirm() {
                XerofhszwOaRjW.this.netBind();
            }
        });
    }

    private void resetView() throws Resources.NotFoundException {
        ((YvwXrkQl) getFragmentByTag(ConstantUtil.SHOW_METHOD_LANUCH_CONFIRM)).changeStep(2);
        this.mEmailEt.setText("");
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    protected void click(View view) {
        if (AnonymousClass3.$SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$fragment$XerofhszwOaRjW$Buttons[((Buttons) view.getTag()).ordinal()] != 1) {
            return;
        }
        netConfirmBind();
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    public void onCreat(View view) throws Resources.NotFoundException {
        super.onCreat(view);
        initView(view);
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    public View onCreateView(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(R.layout.cg_fragment_bind_two, (ViewGroup) null);
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    public void onRefresh() throws Resources.NotFoundException {
        super.onRefresh();
        resetView();
    }
}
