package com.sfyvctwaqbjhki.uwmpqfh.ebvmj;

import android.content.Context;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.sfyvctwaqbjhki.uwmpqfh.R;
import com.sfyvctwaqbjhki.uwmpqfh.WoUjMp;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.CommonUtils;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.ConstantUtil;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.CryptogramUtil;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.ErrorUtil;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.NetParamsBean;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.UserInfo;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.AccTipsManager;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.Response;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager;
import com.sfyvctwaqbjhki.uwmpqfh.msdiykjb.MhrJWomE;
import com.sfyvctwaqbjhki.uwmpqfh.msdiykjb.ZGJWDCUOkpgHBx;
import com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI;

/* loaded from: classes.dex */
public class AJlqeOYiZ extends SLdJjpRXaI {
    private Button btn_register;
    private EditText edit_account;
    private EditText edit_confirm_pwd;
    private EditText edit_pwd;
    private ImageView img_check;
    private RelativeLayout layout_back;
    private RelativeLayout layout_check;
    private int returnType;

    /* renamed from: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.AJlqeOYiZ$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$AJlqeOYiZ$Buttons;

        static {
            int[] iArr = new int[Buttons.values().length];
            $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$AJlqeOYiZ$Buttons = iArr;
            try {
                iArr[Buttons.BTN_REGISTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$AJlqeOYiZ$Buttons[Buttons.LAYOUT_CHECK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$AJlqeOYiZ$Buttons[Buttons.LAYOUT_BACK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private enum Buttons {
        BTN_REGISTER,
        LAYOUT_CHECK,
        LAYOUT_BACK
    }

    public AJlqeOYiZ(Context context, int i2) {
        this(context);
        this.returnType = i2;
    }

    private void register() {
        MhrJWomE.netRegister(new UserManager(UserManager.Type.REGISTER) { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.AJlqeOYiZ.1
            @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager
            public void fail(int i2, String str) {
                Toast.makeText(((SLdJjpRXaI) AJlqeOYiZ.this).context, ErrorUtil.getIdByCode(i2), 0).show();
            }

            @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager
            public void response(Response response) {
                if (Response.getInstance().getEDakAXiM().getPublics().getPg_is_rating() != 0) {
                    AJlqeOYiZ aJlqeOYiZ = AJlqeOYiZ.this;
                    aJlqeOYiZ.jumpToActivity(new CDCbGzOh(aJlqeOYiZ.getContext()));
                } else {
                    AJlqeOYiZ.this.dismiss();
                    AccTipsManager.getInstance().regCommonAccTip(AJlqeOYiZ.this.getContext());
                }
                WoUjMp.getInstance().setLogin(true);
                ZGJWDCUOkpgHBx.loginSuccess(response.getToken(), response.getUserInfo());
            }
        });
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    protected void click(View view) {
        if (isDoubleClick()) {
            return;
        }
        int i2 = AnonymousClass2.$SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$AJlqeOYiZ$Buttons[((Buttons) view.getTag()).ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    return;
                }
                if (this.returnType == 1) {
                    jumpToActivity(new OMUbvus(this.context));
                    return;
                } else {
                    jumpToActivity(new JFbcyKpeE(this.context));
                    return;
                }
            }
            if (this.img_check.getVisibility() == 0) {
                this.img_check.setVisibility(4);
                this.edit_pwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.edit_confirm_pwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                return;
            } else {
                this.img_check.setVisibility(0);
                this.edit_pwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                this.edit_confirm_pwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                return;
            }
        }
        UserInfo userInfo = new UserInfo();
        NetParamsBean netParamsBean = new NetParamsBean();
        String strTrim = this.edit_account.getText().toString().trim();
        String strTrim2 = this.edit_pwd.getText().toString().trim();
        String strTrim3 = this.edit_confirm_pwd.getText().toString().trim();
        if (strTrim.equals("")) {
            Toast.makeText(this.context, R.string.txt_hint_account, 0).show();
            return;
        }
        if (strTrim.length() > 50 || strTrim.length() < 4 || !CommonUtils.accountFormat(strTrim)) {
            Toast.makeText(this.context, R.string.txt_account_err, 0).show();
            return;
        }
        if (strTrim2.equals("")) {
            Toast.makeText(this.context, R.string.txt_hint_password, 0).show();
            return;
        }
        if (strTrim2.length() < 6 || strTrim2.length() > 20) {
            Toast.makeText(this.context, R.string.txt_password_err, 0).show();
            return;
        }
        if (!strTrim3.equals(strTrim2)) {
            Toast.makeText(this.context, R.string.two_psw_unlike, 0).show();
            return;
        }
        int i3 = ConstantUtil.ACCOUNTTYPE_NORMAL;
        if (CommonUtils.emailFormat(strTrim)) {
            i3 = ConstantUtil.ACCOUNTTYPE_EMAIL;
            userInfo.setEmail(strTrim);
        } else {
            userInfo.setEmail("");
        }
        userInfo.setAccountType(i3);
        userInfo.setUserName(strTrim);
        userInfo.setPassword(CryptogramUtil.encryptMD5(strTrim2));
        userInfo.setBasepwd(strTrim2);
        Response.getInstance().setUserInfo(userInfo);
        Response.getInstance().setNetParamsBean(netParamsBean);
        register();
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    protected int createView() {
        return R.layout.cg_activity_register;
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    protected void initView() {
        ImageView imageView = (ImageView) findViewById(R.id.img_logo);
        if (Response.getInstance().getConfigBean().getIsVNCheck() == 1) {
            imageView.setImageResource(R.drawable.cg_18logo);
        } else {
            imageView.setImageResource(R.drawable.cg_logo);
        }
        imageView.setVisibility(0);
        findViewById(R.id.txt_title).setVisibility(8);
        findViewById(R.id.layout_back).setVisibility(8);
        this.edit_account = (EditText) findViewById(R.id.edit_account);
        this.edit_pwd = (EditText) findViewById(R.id.edit_pwd);
        this.edit_confirm_pwd = (EditText) findViewById(R.id.edit_confirm_pwd);
        this.img_check = (ImageView) findViewById(R.id.img_check);
        this.layout_check = (RelativeLayout) findViewById(R.id.layout_check);
        this.btn_register = (Button) findViewById(R.id.btn_register);
        this.layout_back = (RelativeLayout) findViewById(R.id.layout_close);
        this.btn_register.setTag(Buttons.BTN_REGISTER);
        this.layout_check.setTag(Buttons.LAYOUT_CHECK);
        this.layout_back.setTag(Buttons.LAYOUT_BACK);
        this.btn_register.setOnTouchListener(this);
        this.layout_check.setOnTouchListener(this);
        this.layout_back.setOnTouchListener(this);
        this.img_check.setVisibility(4);
    }

    public AJlqeOYiZ(Context context) {
        super(context);
    }
}
