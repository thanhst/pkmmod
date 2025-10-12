package com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.sfyvctwaqbjhki.uwmpqfh.R;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.CryptogramUtil;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.ErrorUtil;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.SYwCAo;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.WxGIMQL;
import com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.Response;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager;
import com.sfyvctwaqbjhki.uwmpqfh.msdiykjb.MhrJWomE;
import com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.NNXOHlAajkUISYActivity;
import com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.SingleBtnCallBack;

/* loaded from: classes.dex */
public class PFSIhpHobEQx extends NNXOHlAajkUISY {
    private EditText mCheckNewPswEt;
    private Button mConfirmChangePswBtn;
    private EditText mNewPswEt;
    private EditText mOldPswEt;

    /* renamed from: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.PFSIhpHobEQx$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$fragment$PFSIhpHobEQx$Buttons;

        static {
            int[] iArr = new int[Buttons.values().length];
            $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$fragment$PFSIhpHobEQx$Buttons = iArr;
            try {
                iArr[Buttons.BTN_CONFIRM_CHANGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private enum Buttons {
        BTN_CONFIRM_CHANGE
    }

    public PFSIhpHobEQx(NNXOHlAajkUISYActivity nNXOHlAajkUISYActivity) {
        super(nNXOHlAajkUISYActivity);
    }

    private void changePswNet() {
        String strTrim = this.mOldPswEt.getText().toString().trim();
        String strTrim2 = this.mNewPswEt.getText().toString().trim();
        String strTrim3 = this.mCheckNewPswEt.getText().toString().trim();
        if (!CryptogramUtil.encryptMD5(strTrim).equals(Response.getInstance().getUserInfo().getPassword())) {
            Toast.makeText(getContext(), R.string.password_error, 0).show();
            return;
        }
        if (strTrim2.equals("")) {
            Toast.makeText(getContext(), R.string.password_empty, 0).show();
            return;
        }
        if (strTrim2.length() < 6 || strTrim2.length() > 20) {
            Toast.makeText(getContext(), R.string.password_length_error, 0).show();
        } else if (!strTrim2.equals(strTrim3)) {
            Toast.makeText(getContext(), R.string.two_psw_unlike, 0).show();
        } else {
            Response.getInstance().getNetParamsBean().setNewPassword(strTrim2);
            MhrJWomE.netChangePsw(new UserManager(UserManager.Type.CHANGEPSW) { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.PFSIhpHobEQx.1
                @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager
                public void fail(int i2, String str) {
                    PFSIhpHobEQx.this.showDialog(PFSIhpHobEQx.this.getContext().getString(ErrorUtil.getIdByCode(i2)));
                }

                @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager
                public void response(Response response) {
                    ((NNXOHlAajkUISY) PFSIhpHobEQx.this).activity.backFragment();
                    PFSIhpHobEQx.this.showDialog(PFSIhpHobEQx.this.getContext().getString(R.string.psw_change_success));
                }
            });
        }
    }

    private void changeTitle() {
        ((SYwCAo) this.activity).changeTitleName(getContext().getString(R.string.txt_change_psw));
    }

    private void initView(View view) {
        changeTitle();
        this.mOldPswEt = (EditText) view.findViewById(R.id.edit_input_old_psw);
        this.mNewPswEt = (EditText) view.findViewById(R.id.edit_input_new_psw);
        this.mCheckNewPswEt = (EditText) view.findViewById(R.id.edit_reinput_new_psw);
        Button button = (Button) view.findViewById(R.id.btn_confirm_change);
        this.mConfirmChangePswBtn = button;
        button.setTag(Buttons.BTN_CONFIRM_CHANGE);
        this.mConfirmChangePswBtn.setOnTouchListener(this);
    }

    private void refreshView() {
        this.mOldPswEt.setText("");
        this.mNewPswEt.setText("");
        this.mCheckNewPswEt.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog(String str) {
        WxGIMQL.createAndShow(getContext().getString(R.string.txt_warn), str, getContext().getString(R.string.txt_confirm), new SingleBtnCallBack() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.PFSIhpHobEQx.2
            @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.SingleBtnCallBack
            public void confirm() {
            }
        });
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    protected void click(View view) {
        if (AnonymousClass3.$SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$fragment$PFSIhpHobEQx$Buttons[((Buttons) view.getTag()).ordinal()] != 1) {
            return;
        }
        changePswNet();
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    public void onCreat(View view) {
        super.onCreat(view);
        initView(view);
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    public View onCreateView(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(R.layout.cg_fragment_change_psw, (ViewGroup) null);
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    public void onRefresh() {
        super.onRefresh();
        changeTitle();
        refreshView();
    }
}
