package com.sfyvctwaqbjhki.uwmpqfh.ebvmj;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.sfyvctwaqbjhki.uwmpqfh.R;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.KlcJIb;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.UmVZwgSWJbEGln;
import com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.Response;
import com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.NNXOHlAajkUISYActivity;

/* loaded from: classes.dex */
public class ZxCBKtlNarIqgjb extends NNXOHlAajkUISYActivity {
    private final String BTN_FIND_ACCOUNT;
    private final String BTN_FIND_PWD;
    private final String LAYOUT_BACK;
    private Button btn_find_account;
    private Button btn_find_pwd;
    private RelativeLayout layout_back;

    /* renamed from: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.ZxCBKtlNarIqgjb$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$ZxCBKtlNarIqgjb$Buttons;

        static {
            int[] iArr = new int[Buttons.values().length];
            $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$ZxCBKtlNarIqgjb$Buttons = iArr;
            try {
                iArr[Buttons.BTN_FIND_PWD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$ZxCBKtlNarIqgjb$Buttons[Buttons.BTN_FIND_ACCOUNT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$ZxCBKtlNarIqgjb$Buttons[Buttons.LAYOUT_BACK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private enum Buttons {
        BTN_FIND_PWD,
        BTN_FIND_ACCOUNT,
        LAYOUT_BACK
    }

    public ZxCBKtlNarIqgjb(Context context) {
        super(context);
        this.LAYOUT_BACK = "layout_close";
        this.BTN_FIND_PWD = "btn_find_pwd";
        this.BTN_FIND_ACCOUNT = "btn_find_account";
    }

    private void selector(String str) {
        int i2 = -1;
        int i3 = -7829368;
        if ("btn_find_pwd".equals(str)) {
            this.btn_find_pwd.setBackgroundResource(R.drawable.cg_btn_select);
            this.btn_find_account.setBackgroundResource(R.drawable.cg_btn_normal);
        } else {
            this.btn_find_pwd.setBackgroundResource(R.drawable.cg_btn_normal);
            this.btn_find_account.setBackgroundResource(R.drawable.cg_btn_select);
            i2 = -7829368;
            i3 = -1;
        }
        this.btn_find_pwd.setTextColor(i2);
        this.btn_find_account.setTextColor(i3);
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    protected void click(View view) {
        int i2 = AnonymousClass1.$SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$ZxCBKtlNarIqgjb$Buttons[((Buttons) view.getTag()).ordinal()];
        if (i2 == 1) {
            selector("btn_find_pwd");
            clearTaskAndback(1);
        } else if (i2 == 2) {
            selector("btn_find_account");
            clearTaskAndProcee(2);
        } else {
            if (i2 != 3) {
                return;
            }
            jumpToActivity(new JFbcyKpeE(this.context));
        }
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.NNXOHlAajkUISYActivity
    protected NNXOHlAajkUISY createFragemnt(int i2) {
        if (i2 == 1) {
            return new KlcJIb(this);
        }
        if (i2 != 2) {
            return null;
        }
        return new UmVZwgSWJbEGln(this);
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    protected int createView() {
        return R.layout.cg_activity_forget_pwd;
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.NNXOHlAajkUISYActivity
    protected int fragmentLayout() {
        return R.id.layout_fragment;
    }

    public Activity getActivity() {
        return this.context;
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
        this.btn_find_pwd = (Button) findViewById(R.id.btn_find_pwd);
        this.btn_find_account = (Button) findViewById(R.id.btn_find_account);
        this.layout_back = (RelativeLayout) findViewById(R.id.layout_close);
        this.btn_find_pwd.setText(R.string.txt_find_pwd);
        this.btn_find_account.setText(R.string.txt_find_account);
        this.btn_find_pwd.setTag(Buttons.BTN_FIND_PWD);
        this.btn_find_account.setTag(Buttons.BTN_FIND_ACCOUNT);
        this.layout_back.setTag(Buttons.LAYOUT_BACK);
        this.btn_find_pwd.setOnTouchListener(this);
        this.btn_find_account.setOnTouchListener(this);
        this.layout_back.setOnTouchListener(this);
        selector("btn_find_pwd");
    }

    public void jumpToLogin() {
        jumpToActivity(new JFbcyKpeE(this.context));
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.NNXOHlAajkUISYActivity, com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    protected void onCreate(View view) {
        super.onCreate(view);
        clearTaskAndProcee(1);
    }
}
