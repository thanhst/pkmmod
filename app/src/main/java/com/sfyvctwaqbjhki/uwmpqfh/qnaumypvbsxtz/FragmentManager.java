package com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY;
import java.util.HashMap;

/* loaded from: classes.dex */
public class FragmentManager extends FragmentTransaction {
    private NNXOHlAajkUISYActivity context;
    private int enterAnim;
    private int exitAnim;
    private NNXOHlAajkUISY hideFragment;
    private HashMap<String, Object> map = new HashMap<>();
    private NNXOHlAajkUISY showFragment;

    public FragmentManager(NNXOHlAajkUISYActivity nNXOHlAajkUISYActivity) {
        this.context = nNXOHlAajkUISYActivity;
        resetAnim();
        resetFragment();
    }

    private void resetAnim() {
        this.enterAnim = -1;
        this.exitAnim = -1;
    }

    private void resetFragment() {
        this.showFragment = null;
        this.hideFragment = null;
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.FragmentTransaction
    public FragmentTransaction add(int i2, NNXOHlAajkUISY nNXOHlAajkUISY, String str) {
        ((NNXOHlAajkUISY) this.context.findViewById(i2)).addView(nNXOHlAajkUISY);
        nNXOHlAajkUISY.setVisibility(8);
        this.map.put(str, nNXOHlAajkUISY);
        nNXOHlAajkUISY.setAdded(true);
        show(nNXOHlAajkUISY);
        return this;
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.FragmentTransaction
    public void commit() {
        NNXOHlAajkUISY nNXOHlAajkUISY;
        NNXOHlAajkUISY nNXOHlAajkUISY2;
        if (this.enterAnim != -1 || (nNXOHlAajkUISY2 = this.showFragment) == null) {
            NNXOHlAajkUISY nNXOHlAajkUISY3 = this.showFragment;
            if (nNXOHlAajkUISY3 != null) {
                nNXOHlAajkUISY3.setVisibility(0);
                this.showFragment.startAnimation(AnimationUtils.loadAnimation(this.context.getContext(), this.enterAnim));
            }
        } else {
            nNXOHlAajkUISY2.setVisibility(0);
        }
        if (this.exitAnim == -1 && (nNXOHlAajkUISY = this.hideFragment) != null) {
            nNXOHlAajkUISY.setVisibility(8);
        } else if (this.hideFragment != null) {
            this.hideFragment.startAnimation(AnimationUtils.loadAnimation(this.context.getContext(), this.exitAnim));
            this.hideFragment.setVisibility(8);
        }
        resetAnim();
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.FragmentTransaction
    public NNXOHlAajkUISY findFragmentByTag(String str) {
        return (NNXOHlAajkUISY) this.map.get(str);
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.FragmentTransaction
    public FragmentTransaction hide(NNXOHlAajkUISY nNXOHlAajkUISY) {
        this.hideFragment = nNXOHlAajkUISY;
        return this;
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.FragmentTransaction
    public FragmentTransaction setCustomAnimations(int i2, int i3) {
        this.enterAnim = i2;
        this.exitAnim = i3;
        return this;
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.FragmentTransaction
    public FragmentTransaction show(NNXOHlAajkUISY nNXOHlAajkUISY) {
        this.showFragment = nNXOHlAajkUISY;
        return this;
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.FragmentTransaction
    public FragmentTransaction add(View view, int i2, NNXOHlAajkUISY nNXOHlAajkUISY, String str) {
        ((NNXOHlAajkUISY) view.findViewById(i2)).addView(nNXOHlAajkUISY);
        nNXOHlAajkUISY.setVisibility(8);
        this.map.put(str, nNXOHlAajkUISY);
        nNXOHlAajkUISY.setAdded(true);
        show(nNXOHlAajkUISY);
        return this;
    }
}
