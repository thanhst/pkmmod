package com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.sfyvctwaqbjhki.uwmpqfh.R;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.SYwCAo;
import com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY;
import com.sfyvctwaqbjhki.uwmpqfh.lebktch.WOMSQzPaksWfHUC;
import com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.NNXOHlAajkUISYActivity;

/* loaded from: classes.dex */
public class YvwXrkQl extends WOMSQzPaksWfHUC {
    private final String IMG_STEP_1;
    private final String IMG_STEP_2;
    private final String LINE_STEP_1;
    private final String LINE_STEP_2;
    private final String TXT_STEP_1;
    private final String TXT_STEP_2;
    private ImageView stepOneImage;
    private View stepOneLine;
    private TextView stepOneTv;
    private ImageView stepTwoImage;
    private View stepTwoLine;
    private TextView stepTwoTv;

    public YvwXrkQl(NNXOHlAajkUISYActivity nNXOHlAajkUISYActivity) {
        super(nNXOHlAajkUISYActivity);
        this.TXT_STEP_1 = "txt_step_1";
        this.LINE_STEP_1 = "line_step_1";
        this.IMG_STEP_1 = "img_step_1";
        this.TXT_STEP_2 = "txt_step_2";
        this.LINE_STEP_2 = "line_step_2";
        this.IMG_STEP_2 = "img_step_2";
    }

    private void changeTitle() {
        ((SYwCAo) this.activity).changeTitleName(getContext().getString(R.string.txt_safe_set));
    }

    private void refreshView() {
        changeTitle();
        proceeFragment(1);
    }

    public void changeStep(int i2) throws Resources.NotFoundException {
        Resources resources = getContext().getResources();
        int i3 = R.color.cg_color_dag;
        ColorStateList colorStateList = resources.getColorStateList(i3);
        Resources resources2 = getContext().getResources();
        int i4 = R.color.cg_color_light_blue;
        ColorStateList colorStateList2 = resources2.getColorStateList(i4);
        this.stepOneTv.setTextColor(colorStateList2);
        this.stepOneLine.setBackgroundResource(i4);
        ImageView imageView = this.stepOneImage;
        int i5 = R.drawable.cg_bg_circle_purple;
        imageView.setImageResource(i5);
        this.stepTwoTv.setTextColor(colorStateList2);
        this.stepTwoLine.setBackgroundResource(i4);
        this.stepTwoImage.setImageResource(i5);
        if (i2 != 1) {
            return;
        }
        this.stepTwoTv.setTextColor(colorStateList);
        this.stepTwoLine.setBackgroundResource(i3);
        this.stepTwoImage.setImageResource(R.drawable.cg_bg_circle_gray);
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.WOMSQzPaksWfHUC
    protected NNXOHlAajkUISY createFragemnt(int i2) {
        if (i2 == 1) {
            return new PprAFnoNiY(this.activity, this);
        }
        if (i2 != 2) {
            return null;
        }
        return new XerofhszwOaRjW(this.activity, this);
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.WOMSQzPaksWfHUC
    protected int fragmentLayout() {
        return R.id.bind_fragment;
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.WOMSQzPaksWfHUC, com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    public void onCreat(View view) {
        super.onCreat(view);
        this.stepOneTv = (TextView) view.findViewById(R.id.txt_step_1);
        this.stepOneLine = view.findViewById(R.id.line_step_1);
        this.stepOneImage = (ImageView) view.findViewById(R.id.img_step_1);
        this.stepTwoTv = (TextView) view.findViewById(R.id.txt_step_2);
        this.stepTwoLine = view.findViewById(R.id.line_step_2);
        this.stepTwoImage = (ImageView) view.findViewById(R.id.img_step_2);
        refreshView();
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.WOMSQzPaksWfHUC, com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    public View onCreateView(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(R.layout.cg_fragment_bind_main, (ViewGroup) null);
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    public void onRefresh() {
        super.onRefresh();
        refreshView();
    }
}
