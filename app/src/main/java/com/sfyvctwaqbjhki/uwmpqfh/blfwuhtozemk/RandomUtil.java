package com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk;

import java.util.Random;

/* loaded from: classes.dex */
public class RandomUtil {
    public static String genRandom(int i2) {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = 0; i3 < i2; i3++) {
            stringBuffer.append(random.nextInt(10));
        }
        return stringBuffer.toString();
    }

    public static String genRandomNum(int i2) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        StringBuffer stringBuffer = new StringBuffer("");
        Random random = new Random();
        int i3 = 0;
        while (i3 < i2) {
            int iAbs = Math.abs(random.nextInt(36));
            if (iAbs >= 0 && iAbs < 10) {
                stringBuffer.append(cArr[iAbs]);
                i3++;
            }
        }
        return stringBuffer.toString();
    }
}
