package com.sfyvctwaqbjhki.uwmpqfh.ebvmj;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.sfyvctwaqbjhki.uwmpqfh.R;
import com.sfyvctwaqbjhki.uwmpqfh.WoUjMp;
import com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI;
import com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.DoubleBtnCallBack;
import com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.SingleBtnCallBack;

/* loaded from: classes.dex */
public class WxGIMQL extends SLdJjpRXaI {
    private final String BTN_CANCEL;
    private final String BTN_CONFIRM;
    private final String DIVIDE_LINE;
    private final String TXT_DESCRIBE;
    private final String TXT_TITLE;
    private int btnFlag;
    private String cancelDes;
    private String confirmDes;
    private String description;
    private SingleBtnCallBack mCallBack;
    private String title;

    /* renamed from: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.WxGIMQL$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$WxGIMQL$Buttons;

        static {
            int[] iArr = new int[Buttons.values().length];
            $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$WxGIMQL$Buttons = iArr;
            try {
                iArr[Buttons.BTN_CANCEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$WxGIMQL$Buttons[Buttons.BTN_CONFIRM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private enum Buttons {
        BTN_CANCEL,
        BTN_CONFIRM
    }

    public WxGIMQL(int i2, String str, String str2, String str3, Context context, SingleBtnCallBack singleBtnCallBack) {
        this(context);
        this.title = str;
        this.description = str2;
        this.mCallBack = singleBtnCallBack;
        this.confirmDes = str3;
        this.btnFlag = i2;
    }

    public static void createAndShow(String str, String str2, String str3, SingleBtnCallBack singleBtnCallBack) {
        new WxGIMQL(0, str, str2, str3, WoUjMp.getInstance().getContext(), singleBtnCallBack).show();
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    protected void click(View view) {
        int i2 = AnonymousClass1.$SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$WxGIMQL$Buttons[((Buttons) view.getTag()).ordinal()];
        if (i2 == 1) {
            dismiss();
            ((DoubleBtnCallBack) this.mCallBack).cancel();
        } else {
            if (i2 != 2) {
                return;
            }
            dismiss();
            this.mCallBack.confirm();
        }
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    protected int createView() {
        return R.layout.cg_activity_alert_dialog;
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    protected void initView() {
        ((TextView) findViewById(R.id.txt_title)).setText(this.title);
        TextView textView = (TextView) findViewById(R.id.txt_describe);
        textView.setText(this.description);
        String str = this.description;
        if (str != null && str.length() > 40) {
            textView.setPadding(0, 20, 0, 15);
        }
        Button button = (Button) findViewById(R.id.btn_confirm);
        button.setTag(Buttons.BTN_CONFIRM);
        button.setOnTouchListener(this);
        Button button2 = (Button) findViewById(R.id.btn_cancel);
        View viewFindViewById = findViewById(R.id.divide_line);
        if (this.btnFlag == 1) {
            button2.setTag(Buttons.BTN_CANCEL);
            button2.setOnTouchListener(this);
            button2.setVisibility(0);
            viewFindViewById.setVisibility(0);
        } else {
            button2.setVisibility(8);
            button2.setVisibility(8);
        }
        String str2 = this.confirmDes;
        if (str2 != null && str2.length() != 0) {
            button.setText(this.confirmDes);
        }
        String str3 = this.cancelDes;
        if (str3 == null || str3.length() == 0) {
            return;
        }
        button2.setText(this.cancelDes);
    }

    public static void createAndShow(String str, String str2, String str3, String str4, DoubleBtnCallBack doubleBtnCallBack) {
        new WxGIMQL(1, str, str2, str3, str4, WoUjMp.getInstance().getContext(), doubleBtnCallBack).show();
    }

    public WxGIMQL(int i2, String str, String str2, String str3, String str4, Context context, DoubleBtnCallBack doubleBtnCallBack) {
        this(context);
        this.title = str;
        this.description = str2;
        this.mCallBack = doubleBtnCallBack;
        this.confirmDes = str4;
        this.cancelDes = str3;
        this.btnFlag = i2;
    }

    public WxGIMQL(Context context) {
        super(context);
        this.TXT_TITLE = "txt_title";
        this.TXT_DESCRIBE = "txt_describe";
        this.BTN_CANCEL = "btn_cancel";
        this.BTN_CONFIRM = "btn_confirm";
        this.DIVIDE_LINE = "divide_line";
    }
}
