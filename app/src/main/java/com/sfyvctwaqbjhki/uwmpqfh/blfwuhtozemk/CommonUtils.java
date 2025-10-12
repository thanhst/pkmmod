package com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk;

import android.content.Context;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class CommonUtils {
    private static long lastClickTime;

    public static boolean accountFormat(String str) {
        return Pattern.compile("^[a-zA-Z0-9@\\._]+$").matcher(str).find();
    }

    public static int dip2px(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static boolean emailFormat(String str) {
        return Pattern.compile("^([a-zA-Z0-9_-]|\\.)+@([a-zA-Z0-9_-])+(\\.([a-zA-Z0-9_-])+)+$").matcher(str).find();
    }

    public static String formatNum(String str) {
        if (str == null) {
            return str;
        }
        try {
            if (!str.contains(".")) {
                return str;
            }
            String[] strArrSplit = str.split("\\.");
            String str2 = strArrSplit[1];
            int length = str2.length();
            for (int i2 = length - 1; i2 >= 0 && str2.charAt(i2) == '0'; i2--) {
                length--;
            }
            if (length <= 0) {
                return strArrSplit[0];
            }
            return strArrSplit[0] + "." + str2.substring(0, length);
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public static boolean isFastDoubleClick() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j2 = jCurrentTimeMillis - lastClickTime;
        if (0 < j2 && j2 < 1000) {
            return true;
        }
        lastClickTime = jCurrentTimeMillis;
        return false;
    }

    public static boolean isMobileNum(String str) {
        return Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$").matcher(str).matches();
    }

    public static boolean isValidVerification(String str) {
        return Pattern.compile("^[0-9]{6}$").matcher(str).find();
    }

    public static int px2dip(Context context, float f2) {
        return (int) ((f2 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
