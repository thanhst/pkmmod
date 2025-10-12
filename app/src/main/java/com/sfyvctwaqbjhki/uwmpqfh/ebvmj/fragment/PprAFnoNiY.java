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
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.CryptogramUtil;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.ErrorUtil;
import com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY;
import com.sfyvctwaqbjhki.uwmpqfh.lebktch.WOMSQzPaksWfHUC;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.Response;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager;
import com.sfyvctwaqbjhki.uwmpqfh.msdiykjb.MhrJWomE;
import com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.NNXOHlAajkUISYActivity;

/* loaded from: classes.dex */
public class PprAFnoNiY extends NNXOHlAajkUISY {
    private EditText pwdEt;

    /* renamed from: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.PprAFnoNiY$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$fragment$PprAFnoNiY$Buttons;

        static {
            int[] iArr = new int[Buttons.values().length];
            $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$fragment$PprAFnoNiY$Buttons = iArr;
            try {
                iArr[Buttons.BTN_CONFIRM_CHECK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private enum Buttons {
        BTN_CONFIRM_CHECK
    }

    public PprAFnoNiY(NNXOHlAajkUISYActivity nNXOHlAajkUISYActivity, WOMSQzPaksWfHUC wOMSQzPaksWfHUC) {
        super(nNXOHlAajkUISYActivity, wOMSQzPaksWfHUC);
    }

    private void checkPwd() {
        if (CommonUtils.isFastDoubleClick()) {
            return;
        }
        if (CryptogramUtil.encryptMD5(this.pwdEt.getText().toString().trim()).equals(Response.getInstance().getUserInfo().getPassword())) {
            MhrJWomE.netCheckPwd(new UserManager(UserManager.Type.CHECKPWD) { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.PprAFnoNiY.1
                @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager
                public void fail(int i2, String str) {
                    Toast.makeText(PprAFnoNiY.this.getContext(), ErrorUtil.getIdByCode(i2), 0).show();
                }

                @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager
                public void response(Response response) {
                    PprAFnoNiY.this.proceeInnerFragment(2);
                }
            });
        } else {
            Toast.makeText(getContext(), R.string.txt_password_wrong, 0).show();
        }
    }

    private void initView(View view) {
        this.pwdEt = (EditText) view.findViewById(R.id.edit_pwd);
        Button button = (Button) view.findViewById(R.id.btn_confirm_check);
        button.setTag(Buttons.BTN_CONFIRM_CHECK);
        button.setOnTouchListener(this);
    }

    private void resetView() throws Resources.NotFoundException {
        this.pwdEt.setText("");
        ((YvwXrkQl) getFragmentByTag(ConstantUtil.SHOW_METHOD_LANUCH_CONFIRM)).changeStep(1);
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    protected void click(View view) {
        if (AnonymousClass2.$SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$fragment$PprAFnoNiY$Buttons[((Buttons) view.getTag()).ordinal()] != 1) {
            return;
        }
        checkPwd();
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    public void onCreat(View view) throws Resources.NotFoundException {
        super.onCreat(view);
        initView(view);
        resetView();
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    public View onCreateView(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(R.layout.cg_fragment_bind_one, (ViewGroup) null);
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    public void onRefresh() throws Resources.NotFoundException {
        super.onRefresh();
        resetView();
    }
}
