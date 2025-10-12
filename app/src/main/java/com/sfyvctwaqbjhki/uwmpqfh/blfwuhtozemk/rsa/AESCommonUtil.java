package com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.rsa;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public class AESCommonUtil {
    private static AESCommonUtil instance;
    private String sKey = "flowerwordchangi";
    private String ivParameter = "0392039203920300";

    private AESCommonUtil() {
    }

    public static String encodeBytes(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < bArr.length; i2++) {
            stringBuffer.append((char) (((bArr[i2] >> 4) & 15) + 97));
            stringBuffer.append((char) ((bArr[i2] & 15) + 97));
        }
        return stringBuffer.toString();
    }

    public static AESCommonUtil getInstance() {
        if (instance == null) {
            instance = new AESCommonUtil();
        }
        return instance;
    }

    public static void main(String[] strArr) {
        try {
            String strEncrypt = getInstance().encrypt("love");
            System.out.println("1:" + strEncrypt);
            String strDecrypt = getInstance().decrypt(strEncrypt);
            System.out.println("3：" + strDecrypt);
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    public String decrypt(String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(this.sKey.getBytes("ASCII"), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(this.ivParameter.getBytes()));
            return new String(cipher.doFinal(Base64.decode(str)), "utf-8");
        } catch (Exception unused) {
            return null;
        }
    }

    public String encrypt(String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, new SecretKeySpec(this.sKey.getBytes(), "AES"), new IvParameterSpec(this.ivParameter.getBytes()));
            return Base64.encode(cipher.doFinal(str.getBytes("utf-8")));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
