package com.sfyvctwaqbjhki.uwmpqfh.ebvmj;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import com.sfyvctwaqbjhki.uwmpqfh.WoUjMp;
import com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.HideNavHelper;

/* loaded from: classes.dex */
public class RDnIREMt extends Dialog {
    private static RDnIREMt instance;
    private Handler handler;

    public RDnIREMt(Context context) {
        super(context, R.style.Theme.NoTitleBar.Fullscreen);
        this.handler = new Handler() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.RDnIREMt.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == 0) {
                    RDnIREMt.this.show();
                } else {
                    RDnIREMt.this.dismiss();
                }
            }
        };
    }

    public static synchronized RDnIREMt getInstance() {
        if (instance == null) {
            instance = new RDnIREMt(WoUjMp.getInstance().getContext());
        }
        return instance;
    }

    public static synchronized void updateInstance(Context context) {
        RDnIREMt rDnIREMt = instance;
        if (rDnIREMt != null && rDnIREMt.isShowing()) {
            instance.dismiss();
        }
        instance = new RDnIREMt(context);
    }

    public void doDismiss() {
        this.handler.sendEmptyMessage(1);
    }

    public void doShow() {
        this.handler.sendEmptyMessage(0);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setSoftInputMode(32);
        getWindow().setFlags(1024, 1024);
        getWindow().setSoftInputMode(32);
        requestWindowFeature(1);
        getWindow().setBackgroundDrawableResource(R.color.transparent);
        setCancelable(false);
        setContentView(com.sfyvctwaqbjhki.uwmpqfh.R.layout.cg_activity_loading);
        getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.RDnIREMt.2
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public void onSystemUiVisibilityChange(int i2) {
                HideNavHelper.hideDialogNav(RDnIREMt.this);
            }
        });
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

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        if (z2) {
            HideNavHelper.hideDialogNav(this);
        }
    }

    public void release() {
        instance = null;
    }
}
