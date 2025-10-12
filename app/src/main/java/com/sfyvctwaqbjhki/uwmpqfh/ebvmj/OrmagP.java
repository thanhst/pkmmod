package com.sfyvctwaqbjhki.uwmpqfh.ebvmj;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.sfyvctwaqbjhki.uwmpqfh.R;
import com.sfyvctwaqbjhki.uwmpqfh.WoUjMp;
import com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI;

/* loaded from: classes.dex */
public class OrmagP extends SLdJjpRXaI {
    private String description;

    public OrmagP(String str, Context context) {
        this(context);
        this.description = str;
    }

    public static void createAndShow(String str) {
        new OrmagP(str, WoUjMp.getInstance().getContext()).show();
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    protected void click(View view) {
        dismiss();
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    protected int createView() {
        return R.layout.cg_activity_alert_toast_dialog;
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    protected void initView() {
        TextView textView = (TextView) findViewById(R.id.txt_describe);
        textView.setText(this.description);
        String str = this.description;
        if (str != null && str.length() > 40) {
            textView.setPadding(0, 20, 0, 15);
        }
        ((ImageView) findViewById(R.id.img_colse)).setOnTouchListener(this);
    }

    public OrmagP(Context context) {
        super(context);
    }
}
