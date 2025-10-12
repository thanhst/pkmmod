package com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk;

import java.io.UnsupportedEncodingException;
import java.util.Random;

/* loaded from: classes.dex */
public class RestoreUtil {
    public static String decrypt(String str) throws UnsupportedEncodingException {
        try {
            byte[] bytes = str.getBytes("gbk");
            int length = bytes.length / 3;
            byte[] bArr = new byte[length];
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                byte b2 = bytes[i2];
                byte b3 = bytes[i2 + 1];
                byte b4 = bytes[i2 + 2];
                i2 += 3;
                bArr[i3] = (byte) (((byte) ((((byte) (((b3 - 65) - r7) - 1)) * 16) + ((byte) ((b2 - 65) - ((byte) ((b4 - 65) / 2)))))) ^ 15);
            }
            return new String(bArr, "gbk");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String encrypt(String str) throws UnsupportedEncodingException {
        Random random = new Random();
        try {
            byte[] bytes = str.getBytes("gbk");
            byte[] bArr = new byte[bytes.length * 3];
            int i2 = 0;
            for (byte b2 : bytes) {
                byte b3 = (byte) (b2 ^ 15);
                byte bNextInt = (byte) random.nextInt(10);
                bArr[i2] = (byte) (((byte) (b3 % 16)) + 65 + bNextInt);
                bArr[i2 + 1] = (byte) (((byte) (b3 / 16)) + 65 + bNextInt + 1);
                bArr[i2 + 2] = (byte) ((bNextInt * 2) + 65);
                i2 += 3;
            }
            return new String(bArr, "gbk");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return "";
        }
    }
}
