package com.sfyvctwaqbjhki.uwmpqfh.ebvmj;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.sfyvctwaqbjhki.uwmpqfh.R;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.UserInfo;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.Response;
import com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI;

/* loaded from: classes.dex */
public class AccTipsActivity extends SLdJjpRXaI {
    private AccTipListener accTipListener;
    private AccTipsType accTipsType;

    /* renamed from: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.AccTipsActivity$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$AccTipsActivity$AccTipsType;
        static final /* synthetic */ int[] $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$AccTipsActivity$Buttons;

        static {
            int[] iArr = new int[Buttons.values().length];
            $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$AccTipsActivity$Buttons = iArr;
            try {
                iArr[Buttons.BTN_COPY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$AccTipsActivity$Buttons[Buttons.BTN_REWARD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$AccTipsActivity$Buttons[Buttons.BTN_UPGRADE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$AccTipsActivity$Buttons[Buttons.BTN_CONTINUE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[AccTipsType.values().length];
            $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$AccTipsActivity$AccTipsType = iArr2;
            try {
                iArr2[AccTipsType.ACC_TIPS_UPGRADE_SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$AccTipsActivity$AccTipsType[AccTipsType.ACC_TIPS_VISITOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$AccTipsActivity$AccTipsType[AccTipsType.ACC_TIPS_COMMON_REG.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public interface AccTipListener {
        void dismiss();
    }

    public enum AccTipsType {
        ACC_TIPS_UPGRADE_SUCCESS,
        ACC_TIPS_COMMON_REG,
        ACC_TIPS_VISITOR
    }

    private enum Buttons {
        BTN_COPY,
        BTN_UPGRADE,
        BTN_REWARD,
        BTN_CONTINUE
    }

    public AccTipsActivity(AccTipsType accTipsType, Context context, AccTipListener accTipListener) {
        this(context);
        this.accTipsType = accTipsType;
        this.accTipListener = accTipListener;
    }

    private void copyAcc() {
        UserInfo userInfo = Response.getInstance().getUserInfo();
        ClipboardManager clipboardManager = (ClipboardManager) this.context.getSystemService("clipboard");
        StringBuilder sb = new StringBuilder();
        sb.append((Object) this.context.getText(R.string.txt_comp_account));
        sb.append(userInfo.getUserName());
        sb.append(" ");
        sb.append((Object) this.context.getText(R.string.txt_comp_pwd));
        sb.append(userInfo.getBasepwd().equals("") ? "unknown" : userInfo.getBasepwd());
        clipboardManager.setPrimaryClip(ClipData.newPlainText("acc", sb.toString()));
        Activity activity = this.context;
        Toast.makeText(activity, activity.getString(R.string.txt_acc_copy_success_tip), 0).show();
    }

    public static void createAndShow(AccTipsType accTipsType, Context context, AccTipListener accTipListener) {
        new AccTipsActivity(accTipsType, context, accTipListener).show();
    }

    private void getReward() {
        getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(Response.getInstance().getEDakAXiM().getPublics().getRewardUrl())));
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    protected void click(View view) {
        int i2 = AnonymousClass1.$SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$AccTipsActivity$Buttons[((Buttons) view.getTag()).ordinal()];
        if (i2 == 1) {
            copyAcc();
            return;
        }
        if (i2 == 2) {
            getReward();
            return;
        }
        if (i2 == 3) {
            SYwCAo.createAndShow(getContext());
            dismiss();
            AccTipListener accTipListener = this.accTipListener;
            if (accTipListener != null) {
                accTipListener.dismiss();
                return;
            }
            return;
        }
        if (i2 != 4) {
            return;
        }
        dismiss();
        AccTipListener accTipListener2 = this.accTipListener;
        if (accTipListener2 != null) {
            accTipListener2.dismiss();
        }
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    protected int createView() {
        return R.layout.cg_activity_acc_tips;
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    protected void initView() {
        TextView textView = (TextView) findViewById(R.id.tv_tip_title);
        TextView textView2 = (TextView) findViewById(R.id.tv_tip_msg);
        Button button = (Button) findViewById(R.id.btn_upgrade);
        button.setTag(Buttons.BTN_UPGRADE);
        button.setOnTouchListener(this);
        Button button2 = (Button) findViewById(R.id.btn_copy);
        button2.setTag(Buttons.BTN_COPY);
        button2.setOnTouchListener(this);
        Button button3 = (Button) findViewById(R.id.btn_reward);
        button3.setTag(Buttons.BTN_REWARD);
        button3.setOnTouchListener(this);
        Button button4 = (Button) findViewById(R.id.btn_continue);
        button4.setTag(Buttons.BTN_CONTINUE);
        button4.setOnTouchListener(this);
        int i2 = AnonymousClass1.$SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$AccTipsActivity$AccTipsType[this.accTipsType.ordinal()];
        if (i2 == 1) {
            textView.setText(R.string.txt_acc_upgrade_success);
            textView2.setText(R.string.txt_memorandum_tips);
            button.setVisibility(8);
            button2.setVisibility(0);
            if (Response.getInstance().getEDakAXiM() != null && Response.getInstance().getEDakAXiM().getPublics().getRewardUrl() != null) {
                button3.setVisibility(0);
            }
            button4.setText(R.string.txt_continue_game);
            return;
        }
        if (i2 != 2) {
            if (i2 != 3) {
                return;
            }
            textView.setText(R.string.txt_reg_common_acc);
            textView2.setText(R.string.txt_memorandum_tips);
            button.setVisibility(8);
            button2.setVisibility(0);
            button3.setVisibility(8);
            button4.setText(R.string.txt_continue_game);
            return;
        }
        textView.setTextSize(2, 16.0f);
        Resources resources = this.context.getResources();
        int i3 = R.color.cg_color_black;
        textView.setTextColor(resources.getColor(i3));
        textView.setText(R.string.txt_visitor_warn);
        textView2.setTextSize(2, 16.0f);
        textView2.setTextColor(this.context.getResources().getColor(i3));
        textView2.setText(R.string.txt_upgrade_reward_tip);
        button.setVisibility(0);
        button2.setVisibility(8);
        button3.setVisibility(8);
        button4.setText(R.string.txt_next_warn);
    }

    public AccTipsActivity(Context context) {
        super(context);
        this.accTipsType = AccTipsType.ACC_TIPS_VISITOR;
    }
}
