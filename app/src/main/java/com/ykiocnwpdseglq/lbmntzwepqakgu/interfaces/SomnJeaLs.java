package com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/* loaded from: classes.dex */
public interface SomnJeaLs {
    void applicationAttachBaseContext(Context context);

    void applicationOnCreate(Application application);

    void exit();

    void onActivityResult(int i2, int i3, Intent intent);

    void onCreate(Activity activity);

    void onDestroy(Activity activity);

    void onPause(Activity activity);

    void onResume(Activity activity);

    void onSaveInstanceState(Bundle bundle);

    void onStart(Activity activity);

    void onStop(Activity activity);
}
