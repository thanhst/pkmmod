package com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz;

import android.app.Activity;
import android.graphics.PorterDuff;
import android.view.View;
import com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.TimerCut;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes.dex */
public class XmjMIE {
    private static final int CUTDOWNTIME = 31;
    private static int allTime;
    private static Timer timer;

    public static void cutDownTimer(final Activity activity, final View view, final TimerCut timerCut) {
        allTime = 31;
        Timer timer2 = timer;
        if (timer2 != null) {
            timer2.cancel();
            timer = null;
        }
        timer = new Timer();
        view.setClickable(false);
        view.getBackground().setColorFilter(-3355444, PorterDuff.Mode.MULTIPLY);
        timer.schedule(new TimerTask() { // from class: com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.XmjMIE.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                activity.runOnUiThread(new Runnable() { // from class: com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.XmjMIE.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        XmjMIE.allTime--;
                        if (XmjMIE.allTime == -1) {
                            XmjMIE.timer.cancel();
                            view.setClickable(true);
                            view.getBackground().clearColorFilter();
                        }
                        timerCut.onCut(XmjMIE.allTime);
                    }
                });
            }
        }, 0L, 1000L);
    }
}
