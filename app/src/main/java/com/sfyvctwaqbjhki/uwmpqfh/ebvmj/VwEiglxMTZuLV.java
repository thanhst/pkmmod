package com.sfyvctwaqbjhki.uwmpqfh.ebvmj;

import android.content.Context;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.sfyvctwaqbjhki.uwmpqfh.R;
import com.sfyvctwaqbjhki.uwmpqfh.WoUjMp;
import com.sfyvctwaqbjhki.uwmpqfh.biohepbeans.EDakAXiM;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.ConstantUtil;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.ErrorUtil;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.UserInfo;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.AccTipsManager;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.Response;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager;
import com.sfyvctwaqbjhki.uwmpqfh.msdiykjb.MhrJWomE;
import com.sfyvctwaqbjhki.uwmpqfh.msdiykjb.ZGJWDCUOkpgHBx;
import com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI;

/* loaded from: classes.dex */
public class VwEiglxMTZuLV extends SLdJjpRXaI {
    private static final String LAYOUT_SWITCH = "layout_switch";
    private String msg;
    private int sendCode;
    private boolean shouldDismiss;
    private String token;

    /* renamed from: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.VwEiglxMTZuLV$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$VwEiglxMTZuLV$Buttons;

        static {
            int[] iArr = new int[Buttons.values().length];
            $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$VwEiglxMTZuLV$Buttons = iArr;
            try {
                iArr[Buttons.LAYOUT_SWITCH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private enum Buttons {
        LAYOUT_SWITCH
    }

    public VwEiglxMTZuLV(Context context) {
        super(context);
        this.shouldDismiss = false;
        this.sendCode = -1;
    }

    public static VwEiglxMTZuLV createAndShow(Context context) {
        VwEiglxMTZuLV vwEiglxMTZuLV = new VwEiglxMTZuLV(context);
        vwEiglxMTZuLV.show();
        return vwEiglxMTZuLV;
    }

    private void login() {
        MhrJWomE.netLogin(new UserManager(UserManager.Type.LOGIN) { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.VwEiglxMTZuLV.2
            @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager
            public void fail(int i2, String str) {
                VwEiglxMTZuLV vwEiglxMTZuLV = VwEiglxMTZuLV.this;
                vwEiglxMTZuLV.msg = vwEiglxMTZuLV.getContext().getString(ErrorUtil.getIdByCode(i2));
                VwEiglxMTZuLV.this.sendCode = 1;
                ((SLdJjpRXaI) VwEiglxMTZuLV.this).handler.sendEmptyMessage(VwEiglxMTZuLV.this.sendCode);
                WoUjMp.getInstance().setLogin(false);
            }

            @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager
            public void response(Response response) {
                VwEiglxMTZuLV.this.token = response.getToken();
                VwEiglxMTZuLV.this.sendCode = 0;
                ((SLdJjpRXaI) VwEiglxMTZuLV.this).handler.sendEmptyMessage(VwEiglxMTZuLV.this.sendCode);
                WoUjMp.getInstance().setLogin(true);
            }
        });
    }

    private void registerLogin() {
        MhrJWomE.netRegister(new UserManager(UserManager.Type.REGISTER) { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.VwEiglxMTZuLV.3
            @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager
            public void fail(int i2, String str) {
                VwEiglxMTZuLV vwEiglxMTZuLV = VwEiglxMTZuLV.this;
                vwEiglxMTZuLV.msg = vwEiglxMTZuLV.getContext().getString(ErrorUtil.getIdByCode(i2));
                VwEiglxMTZuLV.this.sendCode = 1;
                ((SLdJjpRXaI) VwEiglxMTZuLV.this).handler.sendEmptyMessage(VwEiglxMTZuLV.this.sendCode);
                WoUjMp.getInstance().setLogin(false);
            }

            @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager
            public void response(Response response) {
                VwEiglxMTZuLV.this.token = response.getToken();
                VwEiglxMTZuLV.this.sendCode = 0;
                ((SLdJjpRXaI) VwEiglxMTZuLV.this).handler.sendEmptyMessage(VwEiglxMTZuLV.this.sendCode);
                WoUjMp.getInstance().setLogin(true);
            }
        });
    }

    private void showAd() {
        EDakAXiM eDakAXiM = Response.getInstance().getEDakAXiM();
        if (eDakAXiM != null) {
            if (eDakAXiM.getMessages().getIsHasLogin() != null && Boolean.parseBoolean(eDakAXiM.getMessages().getIsHasLogin())) {
                TpyDWZ.createAndShow(getContext());
            } else {
                if (Response.getInstance().getUserInfo() == null || Response.getInstance().getUserInfo().getUserType() != ConstantUtil.USER_TYPE_VISTOR) {
                    return;
                }
                AccTipsManager.getInstance().visitorEntry(this.context, Response.getInstance().getUserInfo().getUserId());
            }
        }
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    protected void click(View view) {
        if (AnonymousClass4.$SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$VwEiglxMTZuLV$Buttons[((Buttons) view.getTag()).ordinal()] != 1) {
            return;
        }
        MhrJWomE.stopNet();
        jumpToActivity(new OMUbvus(this.context));
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    protected int createView() {
        return R.layout.cg_activity_login_progress;
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    protected void handleMessage(Message message) {
        if (!this.shouldDismiss || MhrJWomE.isStoped()) {
            return;
        }
        int i2 = message.what;
        if (i2 == 0) {
            dismiss();
            ZGJWDCUOkpgHBx.loginSuccess(this.token, Response.getInstance().getUserInfo());
            showAd();
        } else {
            if (i2 != 1) {
                return;
            }
            Toast.makeText(getContext(), this.msg, 0).show();
            jumpToActivity(new JFbcyKpeE(this.context));
        }
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    protected void initView() {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.layout_switch);
        relativeLayout.setTag(Buttons.LAYOUT_SWITCH);
        relativeLayout.setOnTouchListener(this);
        TextView textView = (TextView) findViewById(R.id.txt_password);
        TextView textView2 = (TextView) findViewById(R.id.txt_account);
        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(R.id.layout_pwd);
        UserInfo userInfo = Response.getInstance().getUserInfo();
        if (userInfo.getUserType() == ConstantUtil.USER_TYPE_VISTOR) {
            textView2.setText(userInfo.getUserName());
            textView.setVisibility(0);
        } else {
            relativeLayout2.setVisibility(8);
            if (userInfo.getAccountType() == ConstantUtil.ACCOUNTTYPE_EMAIL || userInfo.getAccountType() == ConstantUtil.ACCOUNTTYPE_NORMAL || userInfo.getAccountType() == ConstantUtil.ACCOUNTTYPE_PHONE) {
                textView2.setText(userInfo.getUserName());
            } else {
                textView2.setText(userInfo.getNickName());
            }
        }
        ImageView imageView = (ImageView) findViewById(R.id.img_logo);
        if (Response.getInstance().getConfigBean().getIsVNCheck() == 1) {
            imageView.setImageResource(R.drawable.cg_18logo);
        } else {
            imageView.setImageResource(R.drawable.cg_logo);
        }
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    protected void onCreate(View view) {
        super.onCreate(view);
        this.handler.postDelayed(new Runnable() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.VwEiglxMTZuLV.1
            @Override // java.lang.Runnable
            public void run() {
                VwEiglxMTZuLV.this.shouldDismiss = true;
                ((SLdJjpRXaI) VwEiglxMTZuLV.this).handler.sendEmptyMessage(VwEiglxMTZuLV.this.sendCode);
            }
        }, 2500L);
        UserInfo userInfo = Response.getInstance().getUserInfo();
        if (Response.getInstance().getNetParamsBean().isAutoLogin() || userInfo.getAccountType() == ConstantUtil.ACCOUNTTYPE_EMAIL || userInfo.getAccountType() == ConstantUtil.ACCOUNTTYPE_NORMAL || userInfo.getAccountType() == ConstantUtil.ACCOUNTTYPE_PHONE) {
            login();
        } else {
            registerLogin();
        }
    }
}
