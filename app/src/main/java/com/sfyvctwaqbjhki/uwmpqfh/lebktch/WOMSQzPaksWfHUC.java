package com.sfyvctwaqbjhki.uwmpqfh.lebktch;

import android.view.LayoutInflater;
import android.view.View;
import com.sfyvctwaqbjhki.uwmpqfh.R;
import com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.FragmentManager;
import com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.NNXOHlAajkUISYActivity;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class WOMSQzPaksWfHUC extends NNXOHlAajkUISY {
    protected final int ANIM_NO;
    protected final int ANIM_NO_ENTER;
    protected final int ANIM_NO_EXIT;
    protected final int ANIM_SYSTEM;
    private int backResEnter;
    private int backResExit;
    private NNXOHlAajkUISY currentFragment;
    NNXOHlAajkUISY fragmentNew;
    private FragmentManager manager;
    private int newResEnter;
    private int newResExit;
    private ArrayList<Integer> task;

    public WOMSQzPaksWfHUC(NNXOHlAajkUISYActivity nNXOHlAajkUISYActivity) {
        super(nNXOHlAajkUISYActivity);
        this.ANIM_SYSTEM = 0;
        this.ANIM_NO = -1;
        this.ANIM_NO_ENTER = -2;
        this.ANIM_NO_EXIT = -3;
        this.newResEnter = 0;
        this.newResExit = 0;
        this.backResEnter = 0;
        this.backResExit = 0;
        this.currentFragment = null;
        this.fragmentNew = null;
        this.manager = new FragmentManager(nNXOHlAajkUISYActivity);
    }

    private void process(int i2, boolean z2, boolean z3) {
        FragmentManager fragmentManager = getFragmentManager();
        NNXOHlAajkUISY nNXOHlAajkUISYFindFragmentByTag = fragmentManager.findFragmentByTag(String.valueOf(i2));
        this.fragmentNew = nNXOHlAajkUISYFindFragmentByTag;
        NNXOHlAajkUISY nNXOHlAajkUISY = this.currentFragment;
        if (nNXOHlAajkUISY != null && nNXOHlAajkUISYFindFragmentByTag != null && nNXOHlAajkUISYFindFragmentByTag == nNXOHlAajkUISY) {
            nNXOHlAajkUISYFindFragmentByTag.onRefresh();
            return;
        }
        if (nNXOHlAajkUISY != null) {
            if (z3) {
                if (getAnimRes()[0] == 0) {
                    if (z2) {
                        fragmentManager.setCustomAnimations(R.anim.back_enter, R.anim.back_exit);
                    } else {
                        fragmentManager.setCustomAnimations(R.anim.anim_enter, R.anim.anim_exit);
                    }
                } else if (getAnimRes()[0] != -1) {
                    if (z2) {
                        fragmentManager.setCustomAnimations(getAnimRes()[2], getAnimRes()[3]);
                    } else {
                        fragmentManager.setCustomAnimations(getAnimRes()[0], getAnimRes()[1]);
                    }
                }
            }
            fragmentManager.hide(this.currentFragment);
        }
        NNXOHlAajkUISY nNXOHlAajkUISY2 = this.fragmentNew;
        if (nNXOHlAajkUISY2 == null || !nNXOHlAajkUISY2.isAdded()) {
            this.fragmentNew = createFragemnt(i2);
            fragmentManager.add(this, fragmentLayout(), this.fragmentNew, String.valueOf(i2)).commit();
        } else {
            this.fragmentNew.onRefresh();
            fragmentManager.show(this.fragmentNew).commit();
        }
        this.currentFragment = this.fragmentNew;
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    public int backFragment() {
        if (this.task.size() == 0) {
            return -1;
        }
        ArrayList<Integer> arrayList = this.task;
        arrayList.remove(arrayList.size() - 1);
        if (this.task.size() == 0) {
            return -1;
        }
        ArrayList<Integer> arrayList2 = this.task;
        process(arrayList2.get(arrayList2.size() - 1).intValue(), true, true);
        return 1;
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    public void clearTaskAndProcee(int i2) {
        this.task.clear();
        this.task.add(Integer.valueOf(i2));
        process(i2, false, true);
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    public void clearTaskAndback(int i2) {
        this.task.clear();
        this.task.add(Integer.valueOf(i2));
        process(i2, true, true);
    }

    public void clearTaskWithNoAnim(int i2) {
        this.task.clear();
        this.task.add(Integer.valueOf(i2));
        process(i2, true, false);
    }

    protected abstract NNXOHlAajkUISY createFragemnt(int i2);

    protected abstract int fragmentLayout();

    protected int[] getAnimRes() {
        return new int[]{this.newResEnter, this.newResExit, this.backResEnter, this.backResExit};
    }

    public FragmentManager getFragmentManager() {
        return this.manager;
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    public void onCreat(View view) {
        super.onCreat(view);
        this.task = new ArrayList<>();
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    public View onCreateView(LayoutInflater layoutInflater) {
        return null;
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    public void proceeFragment(int i2) {
        this.task.add(Integer.valueOf(i2));
        process(i2, false, true);
    }

    protected void setAnimRes(int i2, int i3, int i4, int i5) {
        this.newResEnter = i2;
        this.newResExit = i3;
        this.backResEnter = i4;
        this.backResExit = i5;
    }

    public WOMSQzPaksWfHUC(NNXOHlAajkUISYActivity nNXOHlAajkUISYActivity, WOMSQzPaksWfHUC wOMSQzPaksWfHUC) {
        super(nNXOHlAajkUISYActivity, wOMSQzPaksWfHUC);
        this.ANIM_SYSTEM = 0;
        this.ANIM_NO = -1;
        this.ANIM_NO_ENTER = -2;
        this.ANIM_NO_EXIT = -3;
        this.newResEnter = 0;
        this.newResExit = 0;
        this.backResEnter = 0;
        this.backResExit = 0;
        this.currentFragment = null;
        this.fragmentNew = null;
        this.manager = new FragmentManager(nNXOHlAajkUISYActivity);
    }
}
