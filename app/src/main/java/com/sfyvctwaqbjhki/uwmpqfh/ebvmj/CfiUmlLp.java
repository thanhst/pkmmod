package com.sfyvctwaqbjhki.uwmpqfh.ebvmj;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sfyvctwaqbjhki.uwmpqfh.R;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.QLYtOmlwiU;
import com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY;
import com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.NNXOHlAajkUISYActivity;

/* loaded from: classes.dex */
public class CfiUmlLp extends NNXOHlAajkUISYActivity {
    private final String LAYOUT_BACK;
    private final String LAYOUT_CLOSE;
    private final String TXT_TITLE;
    private RelativeLayout layout_back;
    private RelativeLayout layout_close;

    /* renamed from: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.CfiUmlLp$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$CfiUmlLp$Buttons;

        static {
            int[] iArr = new int[Buttons.values().length];
            $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$CfiUmlLp$Buttons = iArr;
            try {
                iArr[Buttons.LAYOUT_BACK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$CfiUmlLp$Buttons[Buttons.LAYOUT_CLOSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private enum Buttons {
        LAYOUT_BACK,
        LAYOUT_CLOSE
    }

    public CfiUmlLp(Context context) {
        super(context);
        this.LAYOUT_BACK = "layout_back";
        this.LAYOUT_CLOSE = "layout_close";
        this.TXT_TITLE = "txt_title";
    }

    public static CfiUmlLp createAndShow(Context context) {
        CfiUmlLp cfiUmlLp = new CfiUmlLp(context);
        cfiUmlLp.show();
        return cfiUmlLp;
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    protected void click(View view) {
        int i2 = AnonymousClass1.$SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$CfiUmlLp$Buttons[((Buttons) view.getTag()).ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                return;
            }
            dismiss();
        } else if (backFragment() == -1) {
            dismiss();
        }
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.NNXOHlAajkUISYActivity
    protected NNXOHlAajkUISY createFragemnt(int i2) {
        if (i2 != 1) {
            return null;
        }
        return new QLYtOmlwiU(this);
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    protected int createView() {
        return R.layout.cg_activity_customer_service;
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.NNXOHlAajkUISYActivity
    protected int fragmentLayout() {
        return R.id.layout_fragment;
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    protected void initView() {
        this.layout_back = (RelativeLayout) findViewById(R.id.layout_back);
        this.layout_close = (RelativeLayout) findViewById(R.id.layout_close);
        ((TextView) findViewById(R.id.txt_title)).setText(R.string.txt_customer_service);
        this.layout_back.setTag(Buttons.LAYOUT_BACK);
        this.layout_close.setTag(Buttons.LAYOUT_CLOSE);
        this.layout_back.setOnTouchListener(this);
        this.layout_close.setOnTouchListener(this);
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.NNXOHlAajkUISYActivity, com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    protected void onCreate(View view) {
        super.onCreate(view);
        proceeFragment(1);
    }
}
