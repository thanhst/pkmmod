package com.sfyvctwaqbjhki.uwmpqfh.lebktch;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.NNXOHlAajkUISYActivity;

/* loaded from: classes.dex */
public class NNXOHlAajkUISY extends FrameLayout implements View.OnTouchListener, View.OnClickListener {
    private final int MIN_CLICK_DELAY_TIME;
    protected NNXOHlAajkUISYActivity activity;
    private ColorStateList btn_color;
    protected Handler handler;
    protected WOMSQzPaksWfHUC innerFragment;
    private boolean isAdded;
    private boolean isClick;
    private long lastClickTime;

    /* renamed from: x, reason: collision with root package name */
    private float f3218x;

    /* renamed from: y, reason: collision with root package name */
    private float f3219y;

    public NNXOHlAajkUISY(NNXOHlAajkUISYActivity nNXOHlAajkUISYActivity) {
        this(nNXOHlAajkUISYActivity.getContext());
        this.activity = nNXOHlAajkUISYActivity;
        this.handler = new Handler();
        View viewOnCreateView = onCreateView(LayoutInflater.from(getContext()));
        if (isInEditMode()) {
            return;
        }
        addView(viewOnCreateView);
    }

    public int backFragment() {
        return this.activity.backFragment();
    }

    public int backInnerFragment() {
        WOMSQzPaksWfHUC wOMSQzPaksWfHUC = this.innerFragment;
        if (wOMSQzPaksWfHUC == null) {
            return -1;
        }
        return wOMSQzPaksWfHUC.backFragment();
    }

    public void clearInnerTaskAndProcee(int i2) {
        WOMSQzPaksWfHUC wOMSQzPaksWfHUC = this.innerFragment;
        if (wOMSQzPaksWfHUC == null) {
            return;
        }
        wOMSQzPaksWfHUC.clearTaskAndProcee(i2);
    }

    public void clearInnerTaskAndback(int i2) {
        WOMSQzPaksWfHUC wOMSQzPaksWfHUC = this.innerFragment;
        if (wOMSQzPaksWfHUC == null) {
            return;
        }
        wOMSQzPaksWfHUC.clearTaskAndback(i2);
    }

    public void clearTaskAndProcee(int i2) {
        this.activity.clearTaskAndProcee(i2);
    }

    public void clearTaskAndback(int i2) {
        this.activity.clearTaskAndback(i2);
    }

    protected void click(View view) {
    }

    protected NNXOHlAajkUISY getFragmentByTag(String str) {
        return this.activity.getFragmentManager().findFragmentByTag(str);
    }

    public NNXOHlAajkUISY getInnerFragmentByTag(String str) {
        WOMSQzPaksWfHUC wOMSQzPaksWfHUC = this.innerFragment;
        if (wOMSQzPaksWfHUC == null) {
            return null;
        }
        return wOMSQzPaksWfHUC.getFragmentManager().findFragmentByTag(str);
    }

    public boolean isAdded() {
        return this.isAdded;
    }

    public boolean isDoubleClick() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.lastClickTime <= 1000) {
            return true;
        }
        this.lastClickTime = jCurrentTimeMillis;
        return false;
    }

    public void onClick(View view) {
    }

    public void onCreat(View view) {
    }

    public View onCreateView(LayoutInflater layoutInflater) {
        return null;
    }

    public void onRefresh() {
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.isClick = true;
            this.f3218x = motionEvent.getX();
            this.f3219y = motionEvent.getY();
            if (view.getBackground() != null) {
                view.getBackground().setColorFilter(-7829368, PorterDuff.Mode.MULTIPLY);
            }
            if (view.getTag() != null && view.getTag().toString().contains("btn")) {
                Button button = (Button) view;
                ColorStateList textColors = button.getTextColors();
                this.btn_color = textColors;
                button.setTextColor(textColors.withAlpha(130));
            }
        } else if (action == 1) {
            if (view.getBackground() != null) {
                view.getBackground().clearColorFilter();
            }
            if (view.getTag() != null && view.getTag().toString().contains("btn")) {
                ((Button) view).setTextColor(this.btn_color);
            }
            if (this.isClick) {
                click(view);
            }
        } else if (action != 2) {
            if (view.getBackground() != null) {
                view.getBackground().clearColorFilter();
            }
            if (view.getTag() != null && view.getTag().toString().contains("btn")) {
                ((Button) view).setTextColor(this.btn_color);
            }
        } else if (Math.abs(motionEvent.getX() - this.f3218x) > 10.0f || Math.abs(motionEvent.getY() - this.f3219y) > 10.0f) {
            this.isClick = false;
        }
        return true;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(final View view) {
        super.onViewAdded(view);
        new Handler().postDelayed(new Runnable() { // from class: com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY.1
            @Override // java.lang.Runnable
            public void run() {
                NNXOHlAajkUISY.this.onCreat(view);
            }
        }, 0L);
    }

    public void proceeFragment(int i2) {
        this.activity.proceeFragment(i2);
    }

    public void proceeInnerFragment(int i2) {
        WOMSQzPaksWfHUC wOMSQzPaksWfHUC = this.innerFragment;
        if (wOMSQzPaksWfHUC == null) {
            return;
        }
        wOMSQzPaksWfHUC.proceeFragment(i2);
    }

    public void setAdded(boolean z2) {
        this.isAdded = z2;
    }

    public NNXOHlAajkUISY(NNXOHlAajkUISYActivity nNXOHlAajkUISYActivity, WOMSQzPaksWfHUC wOMSQzPaksWfHUC) {
        this(nNXOHlAajkUISYActivity);
        this.innerFragment = wOMSQzPaksWfHUC;
    }

    public NNXOHlAajkUISY(Context context) {
        super(context);
        this.isClick = false;
        this.f3218x = 0.0f;
        this.f3219y = 0.0f;
        this.lastClickTime = 0L;
        this.MIN_CLICK_DELAY_TIME = 1000;
    }

    public NNXOHlAajkUISY(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isClick = false;
        this.f3218x = 0.0f;
        this.f3219y = 0.0f;
        this.lastClickTime = 0L;
        this.MIN_CLICK_DELAY_TIME = 1000;
    }
}
