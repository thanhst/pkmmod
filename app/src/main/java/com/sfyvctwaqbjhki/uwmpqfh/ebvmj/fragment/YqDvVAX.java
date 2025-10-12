package com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.sfyvctwaqbjhki.uwmpqfh.R;
import com.sfyvctwaqbjhki.uwmpqfh.biohepbeans.RfybaJKCLilYpc;
import com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY;
import com.sfyvctwaqbjhki.uwmpqfh.lebktch.WOMSQzPaksWfHUC;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.Response;
import com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.NNXOHlAajkUISYActivity;

/* loaded from: classes.dex */
public class YqDvVAX extends NNXOHlAajkUISY {
    private final String TXT_CONTENT;
    private RfybaJKCLilYpc payChannel;
    private TextView txt_content;

    public YqDvVAX(NNXOHlAajkUISYActivity nNXOHlAajkUISYActivity) {
        super(nNXOHlAajkUISYActivity);
        this.TXT_CONTENT = "txt_content";
    }

    private void payByContent() {
        RfybaJKCLilYpc choosePayChannel = Response.getInstance().getChoosePayChannel();
        this.payChannel = choosePayChannel;
        this.txt_content.setText(choosePayChannel.getDescription());
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    public void onCreat(View view) {
        this.txt_content = (TextView) findViewById(R.id.txt_content);
        payByContent();
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    public View onCreateView(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(R.layout.cg_fragment_pay_content, (ViewGroup) null);
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    public void onRefresh() {
        payByContent();
    }

    public YqDvVAX(NNXOHlAajkUISYActivity nNXOHlAajkUISYActivity, WOMSQzPaksWfHUC wOMSQzPaksWfHUC) {
        super(nNXOHlAajkUISYActivity, wOMSQzPaksWfHUC);
        this.TXT_CONTENT = "txt_content";
    }
}
