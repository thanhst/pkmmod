package com.sfyvctwaqbjhki.uwmpqfh.ebvmj;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sfyvctwaqbjhki.uwmpqfh.R;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.BaWsrZQ;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.PFSIhpHobEQx;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.XzyBmafUZXNhlW;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.YvwXrkQl;
import com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY;
import com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.NNXOHlAajkUISYActivity;

/* loaded from: classes.dex */
public class SYwCAo extends NNXOHlAajkUISYActivity {
    private int firstStep;
    private TextView mTitleTv;

    /* renamed from: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.SYwCAo$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$SYwCAo$Buttons;

        static {
            int[] iArr = new int[Buttons.values().length];
            $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$SYwCAo$Buttons = iArr;
            try {
                iArr[Buttons.LAYOUT_BACK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$SYwCAo$Buttons[Buttons.LAYOUT_CLOSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private enum Buttons {
        LAYOUT_BACK,
        LAYOUT_CLOSE
    }

    public SYwCAo(Context context) {
        super(context);
        this.firstStep = 1;
    }

    public static SYwCAo createAndShow(Context context) {
        SYwCAo sYwCAo = new SYwCAo(context);
        sYwCAo.show();
        return sYwCAo;
    }

    public void changeTitleName(String str) {
        this.mTitleTv.setText(str);
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    protected void click(View view) {
        int i2 = AnonymousClass1.$SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$SYwCAo$Buttons[((Buttons) view.getTag()).ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                return;
            }
            dismiss();
        } else if (this.firstStep == 1 && backFragment() == -1) {
            dismiss();
        } else {
            if (this.firstStep == 1 || backFragment() != -1) {
                return;
            }
            clearTaskAndback(1);
            this.firstStep = 1;
        }
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.NNXOHlAajkUISYActivity
    protected NNXOHlAajkUISY createFragemnt(int i2) {
        if (i2 == 1) {
            return new XzyBmafUZXNhlW(this);
        }
        if (i2 == 2) {
            return new PFSIhpHobEQx(this);
        }
        if (i2 == 4) {
            return new BaWsrZQ(this);
        }
        if (i2 != 5) {
            return null;
        }
        return new YvwXrkQl(this);
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    protected int createView() {
        return R.layout.cg_activity_user_center;
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
        findViewById(R.id.img_logo).setVisibility(8);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.layout_back);
        relativeLayout.setTag(Buttons.LAYOUT_BACK);
        relativeLayout.setOnTouchListener(this);
        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(R.id.layout_close);
        relativeLayout2.setTag(Buttons.LAYOUT_CLOSE);
        relativeLayout2.setOnTouchListener(this);
        this.mTitleTv = (TextView) findViewById(R.id.txt_title);
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.NNXOHlAajkUISYActivity, com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    protected void onCreate(View view) {
        super.onCreate(view);
        proceeFragment(this.firstStep);
    }

    public static SYwCAo createAndShow(Context context, int i2) {
        SYwCAo sYwCAo = new SYwCAo(context);
        sYwCAo.firstStep = i2;
        sYwCAo.show();
        return sYwCAo;
    }
}
