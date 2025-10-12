package com.sfyvctwaqbjhki.uwmpqfh.mcluykfz;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.ConstantUtil;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.AccTipsActivity;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes.dex */
public class AccTipsManager {
    private static AccTipsManager instance;
    private boolean isVisitorTipsShow = false;
    private Handler mHandler;
    private Timer timer;

    /* renamed from: com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.AccTipsManager$3, reason: invalid class name */
    class AnonymousClass3 extends TimerTask {
        final /* synthetic */ Activity val$activity;

        AnonymousClass3(Activity activity) {
            this.val$activity = activity;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (AccTipsManager.this.isVisitorTipsShow) {
                return;
            }
            this.val$activity.runOnUiThread(new Runnable() { // from class: com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.AccTipsManager.3.1
                @Override // java.lang.Runnable
                public void run() {
                    AccTipsActivity.createAndShow(AccTipsActivity.AccTipsType.ACC_TIPS_VISITOR, AnonymousClass3.this.val$activity, new AccTipsActivity.AccTipListener() { // from class: com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.AccTipsManager.3.1.1
                        @Override // com.sfyvctwaqbjhki.uwmpqfh.ebvmj.AccTipsActivity.AccTipListener
                        public void dismiss() {
                            AccTipsManager.this.isVisitorTipsShow = false;
                        }
                    });
                    AccTipsManager.this.isVisitorTipsShow = true;
                }
            });
        }
    }

    public static AccTipsManager getInstance() {
        if (instance == null) {
            instance = new AccTipsManager();
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void visitorCyclePrompt(Activity activity) {
        AccTipsActivity.createAndShow(AccTipsActivity.AccTipsType.ACC_TIPS_VISITOR, activity, new AccTipsActivity.AccTipListener() { // from class: com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.AccTipsManager.2
            @Override // com.sfyvctwaqbjhki.uwmpqfh.ebvmj.AccTipsActivity.AccTipListener
            public void dismiss() {
                AccTipsManager.this.isVisitorTipsShow = false;
            }
        });
        this.isVisitorTipsShow = true;
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
        }
        Timer timer2 = new Timer();
        this.timer = timer2;
        timer2.schedule(new AnonymousClass3(activity), Response.getInstance().getEDakAXiM().getPublics().getPopUpInterval() * 1000, Response.getInstance().getEDakAXiM().getPublics().getPopUpInterval() * 1000);
    }

    public void regCommonAccTip(Activity activity) {
        AccTipsActivity.createAndShow(AccTipsActivity.AccTipsType.ACC_TIPS_COMMON_REG, activity, null);
    }

    public void updateSuccessTip(Activity activity) {
        AccTipsActivity.createAndShow(AccTipsActivity.AccTipsType.ACC_TIPS_UPGRADE_SUCCESS, activity, null);
    }

    public void visitorEntry(final Activity activity, int i2) {
        if (this.isVisitorTipsShow || Response.getInstance().getEDakAXiM() == null || Response.getInstance().getEDakAXiM().getPublics().getPopUpSwitch() != 1) {
            return;
        }
        if (this.mHandler == null) {
            this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.AccTipsManager.1
                @Override // android.os.Handler
                public void handleMessage(@NonNull Message message) {
                    super.handleMessage(message);
                    if (message.what == 1) {
                        AccTipsManager.this.visitorCyclePrompt(activity);
                    }
                }
            };
        }
        SharedPreferences sharedPreferences = activity.getSharedPreferences(ConstantUtil.ACCOUNT_PREFERENCES, 0);
        if (sharedPreferences.getString(String.valueOf(i2), null) != null) {
            visitorCyclePrompt(activity);
        } else {
            this.mHandler.sendEmptyMessageDelayed(1, Response.getInstance().getEDakAXiM() != null ? Response.getInstance().getEDakAXiM().getPublics().getFirstPopUpInterval() * 1000 : 1800000L);
            sharedPreferences.edit().putString(String.valueOf(i2), "entry").apply();
        }
    }

    public void visitorUpdatedOrSwitch() {
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
            this.timer = null;
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeMessages(1);
        }
    }
}
