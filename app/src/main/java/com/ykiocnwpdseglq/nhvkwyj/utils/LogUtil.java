package com.ykiocnwpdseglq.nhvkwyj.utils;

import android.util.Log;

/* loaded from: classes.dex */
public class LogUtil {
    private static final String TAG = "rgfb";
    private static boolean isDebug = false;

    public static void e(String str) {
        if (isDebug) {
            Log.e(TAG, str);
        }
    }
}
