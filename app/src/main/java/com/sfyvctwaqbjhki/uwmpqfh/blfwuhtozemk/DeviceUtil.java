package com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import com.ykiocnwpdseglq.lbmntzwepqakgu.ReDqOTXKRs;

/* loaded from: classes.dex */
public class DeviceUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public static String getAndroidId(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(ConstantUtil.ACCOUNT_PREFERENCES, 0);
            String string = sharedPreferences.getString("androidIdCached", "");
            String string2 = Settings.Secure.getString(context.getContentResolver(), "android_id");
            if (string2 == null) {
                return string;
            }
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString("androidIdCached", string2);
            editorEdit.apply();
            return string2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static Drawable getAppIcon(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).loadIcon(context.getPackageManager());
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String getDeviceId(Context context) {
        return !ReDqOTXKRs.getGaid().equals("") ? ReDqOTXKRs.getGaid() : FileUtils.readGAID(context);
    }

    public static String getLocalMacAddress(Context context) {
        return getAndroidId(context);
    }

    public static String getSingleMacAddress(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(ConstantUtil.ACCOUNT_PREFERENCES, 0);
        try {
            String string = sharedPreferences.getString("macCached", "");
            String macAddress = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
            if (macAddress == null) {
                return string;
            }
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString("macCached", macAddress);
            editorEdit.apply();
            return macAddress;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String getVersion(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String getWifiInsideIpAddress(Context context) {
        try {
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
            if (!wifiManager.isWifiEnabled()) {
                wifiManager.setWifiEnabled(true);
            }
            return int2ip(wifiManager.getConnectionInfo().getIpAddress());
        } catch (Exception e2) {
            e2.printStackTrace();
            return "UNKNOWN_INNER_IP";
        }
    }

    public static String getWifiName(Context context) {
        int i2;
        try {
            i2 = Build.VERSION.SDK_INT;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (i2 > 26 && i2 != 28) {
            if (i2 == 27) {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo.isConnected() && activeNetworkInfo.getExtraInfo() != null) {
                    return activeNetworkInfo.getExtraInfo().replace("\"", "");
                }
            }
            return "UNKNOWN";
        }
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        String strReplace = connectionInfo.getSSID().replace("\"", "");
        if (!strReplace.equals("")) {
            return strReplace;
        }
        int networkId = connectionInfo.getNetworkId();
        for (WifiConfiguration wifiConfiguration : wifiManager.getConfiguredNetworks()) {
            if (wifiConfiguration.networkId == networkId) {
                return wifiConfiguration.SSID;
            }
        }
        return strReplace;
    }

    private static String int2ip(int i2) {
        return (i2 & 255) + "." + ((i2 >> 8) & 255) + "." + ((i2 >> 16) & 255) + "." + ((i2 >> 24) & 255);
    }
}
