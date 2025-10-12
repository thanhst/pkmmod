package com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes.dex */
public class ActivityManager {
    private BaseSLdJjpRXaI activity;

    public ActivityManager(Context context) {
        createActivity(context);
    }

    public void close() {
        this.activity = null;
    }

    public void createActivity(Context context) {
        if (this.activity == null) {
            this.activity = new BaseSLdJjpRXaI(context);
        }
    }

    public void dissmess() {
        BaseSLdJjpRXaI baseSLdJjpRXaI = this.activity;
        if (baseSLdJjpRXaI == null) {
            return;
        }
        baseSLdJjpRXaI.dismiss();
        close();
    }

    public boolean isShowing() {
        BaseSLdJjpRXaI baseSLdJjpRXaI = this.activity;
        if (baseSLdJjpRXaI == null) {
            return false;
        }
        return baseSLdJjpRXaI.isShowing();
    }

    public void jumpToActivity(SLdJjpRXaI sLdJjpRXaI) {
        BaseSLdJjpRXaI baseSLdJjpRXaI = this.activity;
        if (baseSLdJjpRXaI == null) {
            return;
        }
        baseSLdJjpRXaI.jumpToActivity(sLdJjpRXaI);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        BaseSLdJjpRXaI baseSLdJjpRXaI = this.activity;
        if (baseSLdJjpRXaI == null) {
            return false;
        }
        return baseSLdJjpRXaI.onTouch(view, motionEvent);
    }

    public void show(SLdJjpRXaI sLdJjpRXaI) {
        this.activity.addView(sLdJjpRXaI);
        this.activity.show();
    }
}
