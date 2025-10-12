package com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import com.sfyvctwaqbjhki.uwmpqfh.R;

/* loaded from: classes.dex */
public class SmMyRuq extends RelativeLayout {
    public static final int ANIM_NO = 0;
    public static final int ANIM_SYSTER = 1;
    public int anim_enter;
    public int anim_exit;
    private Handler handler;

    public SmMyRuq(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.anim_enter = -1;
        this.anim_exit = -1;
        this.handler = new Handler();
    }

    public void setAnimations(int i2, int i3) {
        if (i2 == 1) {
            this.anim_enter = R.anim.view_enter_anim;
        } else if (this.anim_enter != 0) {
            this.anim_enter = i2;
        }
        if (i3 == 1) {
            this.anim_exit = R.anim.view_exit_anim;
        } else if (this.anim_enter != 0) {
            this.anim_exit = i3;
        }
    }

    @Override // android.view.View
    public void setVisibility(final int i2) {
        if (i2 == 4 || i2 == 8) {
            if (this.anim_exit != -1) {
                startAnimation(AnimationUtils.loadAnimation(getContext(), this.anim_exit));
            }
            this.handler.postDelayed(new Runnable() { // from class: com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SmMyRuq.1
                @Override // java.lang.Runnable
                public void run() {
                    SmMyRuq.super.setVisibility(i2);
                }
            }, 500L);
        } else {
            if (this.anim_enter != -1) {
                startAnimation(AnimationUtils.loadAnimation(getContext(), this.anim_enter));
            }
            super.setVisibility(i2);
        }
    }
}
