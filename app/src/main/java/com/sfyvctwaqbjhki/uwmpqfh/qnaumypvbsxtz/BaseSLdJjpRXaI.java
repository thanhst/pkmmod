package com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.sfyvctwaqbjhki.uwmpqfh.WoUjMp;
import java.util.Objects;

/* loaded from: classes.dex */
public class BaseSLdJjpRXaI extends Dialog {
    private SLdJjpRXaI activity;
    private ColorStateList btn_color;
    protected Activity context;
    protected Handler handler;
    private boolean isClick;
    private RelativeLayout layout;
    private int num;
    private View view;

    /* renamed from: x, reason: collision with root package name */
    private float f3220x;

    /* renamed from: y, reason: collision with root package name */
    private float f3221y;

    public BaseSLdJjpRXaI(Context context) {
        this(context, R.style.Theme.NoTitleBar.Fullscreen);
    }

    public void addView(SLdJjpRXaI sLdJjpRXaI) {
        this.activity = sLdJjpRXaI;
        this.view = sLdJjpRXaI.getView();
        this.layout.addView(sLdJjpRXaI.getView());
        sLdJjpRXaI.onCreate(sLdJjpRXaI.getView());
        sLdJjpRXaI.initView();
    }

    protected void click(View view) {
        this.activity.click(view);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        this.handler.postDelayed(new Runnable() { // from class: com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.BaseSLdJjpRXaI.3
            @Override // java.lang.Runnable
            public void run() {
                BaseSLdJjpRXaI.super.dismiss();
                BaseSLdJjpRXaI.this.layout.removeView(BaseSLdJjpRXaI.this.view);
                BaseSLdJjpRXaI.this.num = WoUjMp.getInstance().getActivityNum() - 1;
                WoUjMp.getInstance().setActivityNum(BaseSLdJjpRXaI.this.num);
                BaseSLdJjpRXaI.this.handler.removeCallbacks(this);
            }
        }, startAnimation(com.sfyvctwaqbjhki.uwmpqfh.R.anim.dialog_exit_anim));
    }

    protected void hideInput() {
        if (getCurrentFocus() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.context.getSystemService("input_method");
            inputMethodManager.showSoftInput(this.view, 2);
            inputMethodManager.hideSoftInputFromWindow(this.view.getWindowToken(), 0);
        }
    }

    protected void jumpToActivity(final SLdJjpRXaI sLdJjpRXaI) {
        this.handler.postDelayed(new Runnable() { // from class: com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.BaseSLdJjpRXaI.1
            @Override // java.lang.Runnable
            public void run() {
                BaseSLdJjpRXaI.this.layout.removeView(BaseSLdJjpRXaI.this.activity.getView());
                BaseSLdJjpRXaI.this.activity = null;
                BaseSLdJjpRXaI.this.addView(sLdJjpRXaI);
                BaseSLdJjpRXaI.this.startAnimation(com.sfyvctwaqbjhki.uwmpqfh.R.anim.dialog_enter_anim);
                BaseSLdJjpRXaI.this.handler.removeCallbacks(this);
            }
        }, startAnimation(com.sfyvctwaqbjhki.uwmpqfh.R.anim.dialog_exit_anim));
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        super.onKeyUp(i2, keyEvent);
        if (i2 != 24 && i2 != 25) {
            return false;
        }
        HideNavHelper.hideDialogNav(this);
        return false;
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        HideNavHelper.hideDialogNav(this);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.isClick = true;
            this.f3220x = motionEvent.getX();
            this.f3221y = motionEvent.getY();
            if (view.getTag() == null || !view.getTag().toString().contains("NOCC")) {
                if (view.getBackground() != null) {
                    view.getBackground().setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
                    view.getBackground().setAlpha(130);
                }
                if (view.getTag() != null && view.getTag().toString().contains("BTN")) {
                    Button button = (Button) view;
                    ColorStateList textColors = button.getTextColors();
                    this.btn_color = textColors;
                    button.setTextColor(textColors.withAlpha(130));
                }
            }
        } else if (action == 1) {
            if (view.getTag() == null || !view.getTag().toString().contains("NOCC")) {
                if (view.getBackground() != null) {
                    view.getBackground().clearColorFilter();
                    view.getBackground().setAlpha(255);
                }
                if (view.getTag() != null && view.getTag().toString().contains("BTN")) {
                    ((Button) view).setTextColor(this.btn_color);
                }
            }
            if (this.isClick) {
                click(view);
            }
        } else if (action != 2) {
            if (view.getBackground() != null) {
                view.getBackground().clearColorFilter();
            }
            if (view.getTag() != null && view.getTag().toString().contains("BTN")) {
                ((Button) view).setTextColor(this.btn_color);
            }
        } else if (Math.abs(motionEvent.getX() - this.f3220x) > 10.0f || Math.abs(motionEvent.getY() - this.f3221y) > 10.0f) {
            this.isClick = false;
        }
        return true;
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            hideInput();
        }
        this.activity.onTouchEvent(motionEvent);
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        if (z2) {
            HideNavHelper.hideDialogNav(this);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        startAnimation(com.sfyvctwaqbjhki.uwmpqfh.R.anim.dialog_enter_anim);
        this.num = WoUjMp.getInstance().getActivityNum() + 1;
        WoUjMp.getInstance().setActivityNum(this.num);
    }

    public int startAnimation(int i2) {
        int activityAnimation = this.activity.getActivityAnimation();
        Objects.requireNonNull(this.activity);
        if (activityAnimation != 0) {
            int activityAnimation2 = this.activity.getActivityAnimation();
            Objects.requireNonNull(this.activity);
            if (activityAnimation2 != -3) {
                int activityAnimation3 = this.activity.getActivityAnimation();
                Objects.requireNonNull(this.activity);
                if (activityAnimation3 == -1) {
                    return 0;
                }
                this.layout.startAnimation(AnimationUtils.loadAnimation(getContext(), this.activity.getActivityAnimation()));
                return 500;
            }
        }
        this.layout.startAnimation(AnimationUtils.loadAnimation(getContext(), i2));
        return 500;
    }

    public BaseSLdJjpRXaI(Context context, int i2) {
        super(context, i2);
        this.isClick = false;
        this.f3220x = 0.0f;
        this.f3221y = 0.0f;
        this.num = 0;
        this.handler = new Handler();
        this.context = (Activity) context;
        getWindow().setSoftInputMode(32);
        getWindow().setFlags(1024, 1024);
        getWindow().setSoftInputMode(32);
        requestWindowFeature(1);
        getWindow().setBackgroundDrawableResource(R.color.transparent);
        setCancelable(false);
        View viewInflate = LayoutInflater.from(context).inflate(com.sfyvctwaqbjhki.uwmpqfh.R.layout.cg_black_background, (ViewGroup) null);
        this.layout = (RelativeLayout) viewInflate.findViewById(com.sfyvctwaqbjhki.uwmpqfh.R.id.layout_black);
        setContentView(viewInflate);
        getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.BaseSLdJjpRXaI.2
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public void onSystemUiVisibilityChange(int i3) {
                HideNavHelper.hideDialogNav(BaseSLdJjpRXaI.this);
            }
        });
    }
}
