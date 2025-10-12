package com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.sfyvctwaqbjhki.uwmpqfh.R;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.JqUIzeZd;
import com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY;
import com.sfyvctwaqbjhki.uwmpqfh.lebktch.WOMSQzPaksWfHUC;
import com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.NNXOHlAajkUISYActivity;

/* loaded from: classes.dex */
public class BHkzDf extends WOMSQzPaksWfHUC {
    private final int FRAGMENT_CONFIRM;
    private final int FRAGMENT_CONFIRM_CHANGE;
    private final int FRAGMENT_CONTENT;
    private final int FRAGMENT_GOODS_LIST;
    private final int FRAGMENT_SERIAL_PIN;
    private final int FRAGMENT_SUQERAD;
    private final int FRAGMENT_WEB;
    private final String LAYOUT_FRAGMENT;
    private JqUIzeZd activity;
    public GXdbWD cardSelectFragment;

    public BHkzDf(NNXOHlAajkUISYActivity nNXOHlAajkUISYActivity) {
        super(nNXOHlAajkUISYActivity);
        this.LAYOUT_FRAGMENT = "layout_fragment";
        this.FRAGMENT_SUQERAD = 1;
        this.FRAGMENT_SERIAL_PIN = 2;
        this.FRAGMENT_CONTENT = 3;
        this.FRAGMENT_WEB = 4;
        this.FRAGMENT_CONFIRM = 5;
        this.FRAGMENT_CONFIRM_CHANGE = 6;
        this.FRAGMENT_GOODS_LIST = 8;
        this.activity = (JqUIzeZd) nNXOHlAajkUISYActivity;
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.WOMSQzPaksWfHUC
    protected NNXOHlAajkUISY createFragemnt(int i2) {
        switch (i2) {
            case 1:
                GXdbWD gXdbWD = new GXdbWD(this.activity, this);
                this.cardSelectFragment = gXdbWD;
                return gXdbWD;
            case 2:
                return new VAswzYa(this.activity, this);
            case 3:
                return new YqDvVAX(this.activity, this);
            case 4:
                return new Zmxjahf(this.activity, this);
            case 5:
                return new NALdIqmRM(this.activity, this);
            case 6:
                return new OmoOpLlTaJfzAYs(this.activity, this);
            case 7:
            default:
                return null;
            case 8:
                return new OvSFXgdxe(this.activity, this);
        }
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.WOMSQzPaksWfHUC
    protected int fragmentLayout() {
        return R.id.layout_fragment;
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.WOMSQzPaksWfHUC, com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    public void onCreat(View view) {
        super.onCreat(view);
        onRefresh();
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.WOMSQzPaksWfHUC, com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    public View onCreateView(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(R.layout.cg_fragment_pay_main, (ViewGroup) null);
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    public void onRefresh() {
        clearTaskWithNoAnim(1);
    }
}
