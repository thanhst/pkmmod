package com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.sfyvctwaqbjhki.uwmpqfh.R;
import com.sfyvctwaqbjhki.uwmpqfh.WoUjMp;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.CommonUtils;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.ConstantUtil;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.DeviceUtil;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.ErrorUtil;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.SYwCAo;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.UpEMrGWDdilB;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.WxGIMQL;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.NetParamsBean;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.UserInfo;
import com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.AccTipsManager;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.Response;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager;
import com.sfyvctwaqbjhki.uwmpqfh.msdiykjb.MhrJWomE;
import com.sfyvctwaqbjhki.uwmpqfh.msdiykjb.PBvElADcPX;
import com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.NNXOHlAajkUISYActivity;
import com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.DoubleBtnCallBack;
import com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.SingleBtnCallBack;

/* loaded from: classes.dex */
public class XzyBmafUZXNhlW extends NNXOHlAajkUISY {
    private EditText mAccountEdit;
    private TextView mAccountTv;
    private LinearLayout mBindEmailLay;
    private LinearLayout mChangePsw;
    private TextView mChangePswTitleTv;
    private EditText mConfirmPwdEdit;
    private Button mConfirmUpdateBtn;
    private Button mCopyBtn;
    private LinearLayout mPositiveLay;
    private EditText mPswEdit;
    private TextView mSafeSetTitleTv;
    private TextView mUserSwitch;
    private LinearLayout mVisitorLay;
    private TextView mWarnTv;

    /* renamed from: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.XzyBmafUZXNhlW$6, reason: invalid class name */
    static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$fragment$XzyBmafUZXNhlW$Buttons;

        static {
            int[] iArr = new int[Buttons.values().length];
            $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$fragment$XzyBmafUZXNhlW$Buttons = iArr;
            try {
                iArr[Buttons.BTN_CHECK_CHARGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$fragment$XzyBmafUZXNhlW$Buttons[Buttons.BTN_VISITOR_SWITCH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$fragment$XzyBmafUZXNhlW$Buttons[Buttons.BTN_UPDATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$fragment$XzyBmafUZXNhlW$Buttons[Buttons.BTN_COPY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$fragment$XzyBmafUZXNhlW$Buttons[Buttons.BTN_COPY_ACC.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$fragment$XzyBmafUZXNhlW$Buttons[Buttons.BTN_CANCEL_ACC.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$fragment$XzyBmafUZXNhlW$Buttons[Buttons.LAYOUT_BIND_EMAIL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$fragment$XzyBmafUZXNhlW$Buttons[Buttons.LAYOUT_CHANGE_PSW.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$fragment$XzyBmafUZXNhlW$Buttons[Buttons.LAYOUT_SWITCH_ACCOUNT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$fragment$XzyBmafUZXNhlW$Buttons[Buttons.LAYOUT_CANCEL_ACCOUNT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    private enum Buttons {
        BTN_CHECK_CHARGE,
        LAYOUT_CHANGE_PSW,
        LAYOUT_BIND_EMAIL,
        LAYOUT_SWITCH_ACCOUNT,
        LAYOUT_CANCEL_ACCOUNT,
        BTN_VISITOR_SWITCH,
        BTN_UPDATE,
        BTN_COPY,
        BTN_COPY_ACC,
        BTN_CANCEL_ACC
    }

    public XzyBmafUZXNhlW(NNXOHlAajkUISYActivity nNXOHlAajkUISYActivity) {
        super(nNXOHlAajkUISYActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void accCancelShow(String str) {
        UpEMrGWDdilB.createAndShow(this.activity.getContext(), str, new SingleBtnCallBack() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.e
            @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.SingleBtnCallBack
            public final void confirm() {
                this.f3217a.lambda$accCancelShow$0();
            }
        });
    }

    private void cancelAcc() {
        MhrJWomE.getAccCancelAddr(new UserManager(UserManager.Type.CANCELACCADDR) { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.XzyBmafUZXNhlW.3
            @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager
            public void fail(int i2, String str) {
                Toast.makeText(XzyBmafUZXNhlW.this.getContext(), ErrorUtil.getIdByCode(i2), 0).show();
            }

            @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager
            public void response(Response response) {
                NetParamsBean netParamsBean = response.getNetParamsBean();
                if (netParamsBean.getAccCancelAddr() == null || netParamsBean.getAccCancelAddr().isEmpty()) {
                    Toast.makeText(XzyBmafUZXNhlW.this.getContext(), "server config error!!", 0).show();
                } else {
                    XzyBmafUZXNhlW.this.accCancelShow(netParamsBean.getAccCancelAddr());
                }
            }
        });
    }

    private void changeTitle() {
        ((SYwCAo) this.activity).changeTitleName(getContext().getString(R.string.txt_title_user_center));
    }

    private void copyAcc(Context context) {
        UserInfo userInfo = Response.getInstance().getUserInfo();
        if (userInfo.getAccountType() == ConstantUtil.ACCOUNTTYPE_FACEBOOK) {
            Toast.makeText(context, context.getString(R.string.txt_fb_acc_copy_tip), 0).show();
            return;
        }
        if (userInfo.getAccountType() == ConstantUtil.ACCOUNTTYPE_KAKAO) {
            Toast.makeText(context, context.getString(R.string.txt_kakao_acc_copy_tip), 0).show();
            return;
        }
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
        StringBuilder sb = new StringBuilder();
        sb.append((Object) context.getText(R.string.txt_comp_account));
        sb.append(userInfo.getUserName());
        sb.append(" ");
        sb.append((Object) context.getText(R.string.txt_comp_pwd));
        sb.append(userInfo.getBasepwd().equals("") ? "unknown" : userInfo.getBasepwd());
        clipboardManager.setPrimaryClip(ClipData.newPlainText("acc", sb.toString()));
        Toast.makeText(context, context.getString(R.string.txt_acc_copy_success_tip), 0).show();
    }

    private void initView(View view) throws Resources.NotFoundException {
        changeTitle();
        this.mAccountTv = (TextView) view.findViewById(R.id.txt_account);
        Button button = (Button) view.findViewById(R.id.btn_copy_acc);
        button.setTag(Buttons.BTN_COPY_ACC);
        button.setOnTouchListener(this);
        ((TextView) view.findViewById(R.id.txt_device)).setText(DeviceUtil.getAndroidId(getContext()));
        this.mWarnTv = (TextView) view.findViewById(R.id.txt_warn);
        this.mSafeSetTitleTv = (TextView) view.findViewById(R.id.safe_set_title_tv);
        Button button2 = (Button) view.findViewById(R.id.btn_check_charge);
        button2.setTag(Buttons.BTN_CHECK_CHARGE);
        button2.setOnTouchListener(this);
        this.mUserSwitch = (Button) view.findViewById(R.id.btn_visitor_switch);
        this.mChangePswTitleTv = (TextView) view.findViewById(R.id.txt_change_psw_title);
        this.mChangePsw = (LinearLayout) view.findViewById(R.id.layout_change_psw);
        this.mBindEmailLay = (LinearLayout) view.findViewById(R.id.layout_safe_set);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.layout_switch_account);
        linearLayout.setTag(Buttons.LAYOUT_SWITCH_ACCOUNT);
        linearLayout.setOnClickListener(this);
        this.mVisitorLay = (LinearLayout) view.findViewById(R.id.layout_visitor);
        this.mPositiveLay = (LinearLayout) view.findViewById(R.id.layout_positive);
        this.mAccountEdit = (EditText) view.findViewById(R.id.edit_update_acc);
        this.mPswEdit = (EditText) view.findViewById(R.id.edit_update_pwd);
        this.mConfirmPwdEdit = (EditText) view.findViewById(R.id.edit_update_confirm);
        Button button3 = (Button) view.findViewById(R.id.btn_update);
        this.mConfirmUpdateBtn = button3;
        button3.setTag(Buttons.BTN_UPDATE);
        this.mConfirmUpdateBtn.setOnTouchListener(this);
        Button button4 = (Button) view.findViewById(R.id.btn_copy);
        this.mCopyBtn = button4;
        button4.setTag(Buttons.BTN_COPY);
        this.mCopyBtn.setOnTouchListener(this);
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.layout_cancel_account);
        linearLayout2.setTag(Buttons.LAYOUT_CANCEL_ACCOUNT);
        linearLayout2.setOnClickListener(this);
        Button button5 = (Button) findViewById(R.id.btn_cancel_account);
        button5.setTag(Buttons.BTN_CANCEL_ACC);
        button5.setOnTouchListener(this);
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$accCancelShow$0() {
        this.activity.dismiss();
        WoUjMp.getInstance().setLogin(false);
        PBvElADcPX.deleteUser(Response.getInstance().getUserInfo());
        this.handler.postDelayed(new f(), 600L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshView() throws Resources.NotFoundException {
        ColorStateList colorStateList = getContext().getResources().getColorStateList(R.color.cg_color_gray3);
        ColorStateList colorStateList2 = getContext().getResources().getColorStateList(R.color.cg_color_light_blue);
        UserInfo userInfo = Response.getInstance().getUserInfo();
        if (userInfo.getAccountType() == ConstantUtil.ACCOUNTTYPE_EMAIL || userInfo.getAccountType() == ConstantUtil.ACCOUNTTYPE_NORMAL || userInfo.getAccountType() == ConstantUtil.ACCOUNTTYPE_PHONE) {
            this.mAccountTv.setText(userInfo.getUserName());
        } else {
            this.mAccountTv.setText(userInfo.getNickName());
        }
        if (userInfo.getUserType() == ConstantUtil.USER_TYPE_VISTOR) {
            this.mVisitorLay.setVisibility(0);
            this.mPositiveLay.setVisibility(8);
            this.mUserSwitch.setVisibility(0);
            this.mUserSwitch.setTag(Buttons.BTN_VISITOR_SWITCH);
            this.mUserSwitch.setOnTouchListener(this);
            return;
        }
        this.mUserSwitch.setVisibility(8);
        this.mVisitorLay.setVisibility(8);
        this.mPositiveLay.setVisibility(0);
        String strReplace = "";
        if (userInfo.getEmail() != null && !userInfo.getEmail().equals("")) {
            String email = userInfo.getEmail();
            if (email != null && !email.equals("")) {
                String str = email.split("@")[0];
                if (str.length() == 1 || str.length() == 2) {
                    StringBuffer stringBuffer = new StringBuffer(str.substring(0, 1));
                    stringBuffer.append("*****");
                    strReplace = email.replace(str, stringBuffer);
                } else {
                    strReplace = email.replace(email.substring(1, str.length() - 1), "*****");
                }
            }
            this.mWarnTv.setText(getContext().getString(R.string.txt_have_bind) + strReplace);
            this.mWarnTv.setTextColor(colorStateList);
            this.mSafeSetTitleTv.setTextColor(colorStateList);
            this.mBindEmailLay.setClickable(false);
            this.mBindEmailLay.setFocusable(false);
            this.mBindEmailLay.setFocusableInTouchMode(false);
        } else if (userInfo.getAccountType() == ConstantUtil.ACCOUNTTYPE_EMAIL || userInfo.getAccountType() == ConstantUtil.ACCOUNTTYPE_NORMAL || userInfo.getAccountType() == ConstantUtil.ACCOUNTTYPE_PHONE) {
            this.mBindEmailLay.setTag(Buttons.LAYOUT_BIND_EMAIL);
            this.mBindEmailLay.setOnClickListener(this);
        } else {
            this.mWarnTv.setText("");
            this.mSafeSetTitleTv.setVisibility(0);
            this.mSafeSetTitleTv.setTextColor(colorStateList);
            this.mBindEmailLay.setClickable(false);
            this.mBindEmailLay.setFocusable(false);
            this.mBindEmailLay.setFocusableInTouchMode(false);
        }
        if (userInfo.getAccountType() != ConstantUtil.ACCOUNTTYPE_NORMAL && userInfo.getAccountType() != ConstantUtil.ACCOUNTTYPE_EMAIL) {
            this.mChangePswTitleTv.setTextColor(colorStateList);
            this.mChangePsw.setFocusable(false);
            this.mChangePsw.setClickable(false);
        } else {
            this.mChangePsw.setFocusable(true);
            this.mChangePsw.setClickable(true);
            this.mChangePswTitleTv.setTextColor(colorStateList2);
            this.mChangePsw.setTag(Buttons.LAYOUT_CHANGE_PSW);
            this.mChangePsw.setOnClickListener(this);
        }
    }

    private void showDoubleDialog() {
        WxGIMQL.createAndShow(getContext().getString(R.string.txt_switch_account), getContext().getString(R.string.txt_tourist_update_tips), getContext().getString(R.string.txt_cancel_switch), getContext().getString(R.string.txt_confirm_switch), new DoubleBtnCallBack() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.XzyBmafUZXNhlW.5
            @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.DoubleBtnCallBack
            public void cancel() {
            }

            @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.SingleBtnCallBack
            public void confirm() {
                ((NNXOHlAajkUISY) XzyBmafUZXNhlW.this).activity.dismiss();
                ((NNXOHlAajkUISY) XzyBmafUZXNhlW.this).handler.postDelayed(new f(), 500L);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSingleDialog(String str, String str2) {
        WxGIMQL.createAndShow(str, str2, getContext().getString(R.string.txt_confirm), new SingleBtnCallBack() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.XzyBmafUZXNhlW.4
            @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.SingleBtnCallBack
            public void confirm() {
            }
        });
    }

    private void updateAccount() {
        final String strTrim = this.mAccountEdit.getText().toString().trim();
        String strTrim2 = this.mPswEdit.getText().toString().trim();
        String strTrim3 = this.mConfirmPwdEdit.getText().toString().trim();
        if (!CommonUtils.accountFormat(strTrim) || strTrim.length() < 4 || strTrim.length() > 50) {
            Toast.makeText(getContext(), R.string.txt_account_err, 0).show();
            return;
        }
        if (strTrim2.equals("")) {
            Toast.makeText(getContext(), R.string.password_empty, 0).show();
            return;
        }
        if (strTrim2.length() < 6 || strTrim2.length() > 20) {
            Toast.makeText(getContext(), R.string.password_length_error, 0).show();
            return;
        }
        if (!strTrim2.equals(strTrim3)) {
            Toast.makeText(getContext(), R.string.two_psw_unlike, 0).show();
            return;
        }
        NetParamsBean netParamsBean = new NetParamsBean();
        netParamsBean.setNewPassword(strTrim2);
        netParamsBean.setBindAccountName(strTrim);
        Response.getInstance().setNetParamsBean(netParamsBean);
        if (!CommonUtils.emailFormat(strTrim)) {
            netParamsBean.setBindEmail("");
            updateRequest();
            return;
        }
        WxGIMQL.createAndShow(getContext().getString(R.string.txt_warn), getContext().getString(R.string.txt_alert_msg1) + "【" + strTrim + "】" + getContext().getString(R.string.txt_alert_msg2), getContext().getString(R.string.txt_cancel), getContext().getString(R.string.txt_confirm), new DoubleBtnCallBack() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.XzyBmafUZXNhlW.1
            @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.DoubleBtnCallBack
            public void cancel() {
                Response.getInstance().getNetParamsBean().setBindEmail("");
                XzyBmafUZXNhlW.this.updateRequest();
            }

            @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.SingleBtnCallBack
            public void confirm() {
                Response.getInstance().getNetParamsBean().setBindEmail(strTrim);
                XzyBmafUZXNhlW.this.updateRequest();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRequest() {
        MhrJWomE.netBindVisitor(new UserManager(UserManager.Type.BINDVISITOR) { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.XzyBmafUZXNhlW.2
            @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager
            public void fail(int i2, String str) {
                XzyBmafUZXNhlW.this.showSingleDialog(XzyBmafUZXNhlW.this.getContext().getString(R.string.txt_update_fail), XzyBmafUZXNhlW.this.getContext().getString(ErrorUtil.getIdByCode(i2)));
            }

            @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager
            public void response(Response response) throws Resources.NotFoundException {
                XzyBmafUZXNhlW.this.refreshView();
                AccTipsManager.getInstance().visitorUpdatedOrSwitch();
                AccTipsManager.getInstance().updateSuccessTip(((NNXOHlAajkUISY) XzyBmafUZXNhlW.this).activity.getContext());
            }
        });
    }

    public void bindEmail() {
        proceeFragment(5);
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    protected void click(View view) {
        switch (AnonymousClass6.$SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$fragment$XzyBmafUZXNhlW$Buttons[((Buttons) view.getTag()).ordinal()]) {
            case 1:
                proceeFragment(4);
                break;
            case 2:
                showDoubleDialog();
                break;
            case 3:
                updateAccount();
                break;
            case 4:
                ((ClipboardManager) getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(ViewHierarchyConstants.TEXT_KEY, DeviceUtil.getAndroidId(getContext())));
                Toast.makeText(getContext(), R.string.txt_copy_success, 0).show();
                break;
            case 5:
                copyAcc(this.activity.getContext());
                break;
            case 6:
                cancelAcc();
                break;
        }
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY, android.view.View.OnClickListener
    public void onClick(View view) {
        switch (AnonymousClass6.$SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$fragment$XzyBmafUZXNhlW$Buttons[((Buttons) view.getTag()).ordinal()]) {
            case 7:
                bindEmail();
                break;
            case 8:
                proceeFragment(2);
                break;
            case 9:
                this.activity.dismiss();
                this.handler.postDelayed(new f(), 500L);
                break;
            case 10:
                cancelAcc();
                break;
        }
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    public void onCreat(View view) throws Resources.NotFoundException {
        super.onCreat(view);
        initView(view);
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    public View onCreateView(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(R.layout.cg_fragment_user_center, (ViewGroup) null);
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    public void onRefresh() throws Resources.NotFoundException {
        super.onRefresh();
        changeTitle();
        refreshView();
    }
}
