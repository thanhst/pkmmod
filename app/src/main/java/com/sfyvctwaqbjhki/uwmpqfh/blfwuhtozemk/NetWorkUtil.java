package com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.DataUtil;

/* loaded from: classes.dex */
public class NetWorkUtil {
    public static String getMobileOperators(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(DataUtil.USER_COLUMN.PHONE);
        if (telephonyManager != null) {
            return telephonyManager.getSimOperator();
        }
        return null;
    }

    public static boolean isNetworkConnect(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return (activeNetworkInfo == null || activeNetworkInfo.getState() == NetworkInfo.State.DISCONNECTED || activeNetworkInfo.getState() != NetworkInfo.State.CONNECTED) ? false : true;
    }

    public static boolean isShowThirdPay(Context context) {
        return (isWifiConnect(context) || getMobileOperators(context) == null || !getMobileOperators(context).startsWith(ConstantUtil.COUNTRY_MOBILE_OPERATORS)) ? false : true;
    }

    public static boolean isWifiConnect(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 1 && activeNetworkInfo.isConnected();
    }
}
