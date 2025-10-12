package com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk;

import android.util.Log;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.Response;

/* loaded from: classes.dex */
public class LogUtils {
    private static final String TAG = "royaleSDK";

    public static void e(String str) {
        if (Response.getInstance().getConfigBean().getIsDebug() == 1) {
            Log.e(TAG, str);
        }
    }
}
