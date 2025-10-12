package com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public abstract class SLdJjpRXaI implements View.OnTouchListener, View.OnClickListener {
    protected Activity context;
    private boolean isDismiss;
    private ActivityManager manager;
    private View view;
    protected final int ANIM_SYSTEM = 0;
    protected final int ANIM_NO = -1;
    protected final int ANIM_NO_ENTER = -2;
    protected final int ANIM_NO_EXIT = -3;
    private long lastClickTime = 0;
    private final int MIN_CLICK_DELAY_TIME = 1000;
    protected Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            SLdJjpRXaI.this.handleMessage(message);
        }
    };
    private int animationRes = 0;

    public SLdJjpRXaI(Context context) {
        this.context = (Activity) context;
        this.view = LayoutInflater.from(context).inflate(createView(), (ViewGroup) null);
    }

    protected void click(View view) {
    }

    protected abstract int createView();

    public void dismiss() {
        this.isDismiss = true;
        this.manager.dissmess();
    }

    public View findViewById(int i2) {
        return this.view.findViewById(i2);
    }

    protected int getActivityAnimation() {
        return this.animationRes;
    }

    public Activity getContext() {
        return this.context;
    }

    public ActivityManager getManager() {
        return this.manager;
    }

    public View getView() {
        return this.view;
    }

    protected void handleMessage(Message message) {
    }

    protected abstract void initView();

    public boolean isDoubleClick() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.lastClickTime <= 1000) {
            return true;
        }
        this.lastClickTime = jCurrentTimeMillis;
        return false;
    }

    public boolean isShowing() {
        ActivityManager activityManager = this.manager;
        if (activityManager == null) {
            return false;
        }
        return activityManager.isShowing();
    }

    public void jumpToActivity(SLdJjpRXaI sLdJjpRXaI) {
        this.isDismiss = true;
        sLdJjpRXaI.setManager(this.manager);
        this.manager.jumpToActivity(sLdJjpRXaI);
    }

    public void onClick(View view) {
    }

    protected void onCreate(View view) {
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.isDismiss) {
            return false;
        }
        return this.manager.onTouch(view, motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    protected void setActivityAnimation(int i2) {
        this.animationRes = i2;
    }

    public void setManager(ActivityManager activityManager) {
        this.manager = activityManager;
    }

    public void show() {
        if (isShowing()) {
            return;
        }
        this.manager = new ActivityManager(this.context);
        this.handler.postDelayed(new Runnable() { // from class: com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI.2
            @Override // java.lang.Runnable
            public void run() {
                SLdJjpRXaI.this.manager.show(SLdJjpRXaI.this);
                SLdJjpRXaI.this.handler.removeCallbacks(this);
            }
        }, 0L);
    }
}
