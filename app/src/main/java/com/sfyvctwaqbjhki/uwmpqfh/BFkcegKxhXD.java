package com.sfyvctwaqbjhki.uwmpqfh;

import android.app.Application;
import android.content.Context;
import com.sfyvctwaqbjhki.uwmpqfh.bokqjfarynhxdu.AFCBnG;
import com.ykiocnwpdseglq.lbmntzwepqakgu.ReDqOTXKRs;

/* loaded from: classes.dex */
public class BFkcegKxhXD extends Application {
    public static void applicationAttachBaseContext(Context context) {
        ReDqOTXKRs.applicationAttachBaseContext(context);
    }

    public static void applicationOnCreate(Application application) {
        ReDqOTXKRs.applicationOnCreate(application);
        AFCBnG.getInstance().analysisApplicationOnCreate(application);
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        applicationAttachBaseContext(context);
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        applicationOnCreate(this);
    }
}
