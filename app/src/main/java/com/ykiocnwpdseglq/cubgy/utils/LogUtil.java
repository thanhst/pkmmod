package com.ykiocnwpdseglq.cubgy.utils;

import android.util.Log;

/* loaded from: classes.dex */
public class LogUtil {
    private static final String TAG = "rg_google_pay";
    private static boolean isDebug = false;

    public static void e(String str) {
        if (isDebug) {
            Log.e(TAG, str);
        }
    }
}
