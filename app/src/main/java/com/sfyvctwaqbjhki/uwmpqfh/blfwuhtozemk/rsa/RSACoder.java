package com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.rsa;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public class RSACoder {
    static final String algorithmStr = "AES/ECB/PKCS5Padding";
    private static String private_key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCkh0aKknIsmF838HITg8rdA0I+HwS1huM3FGC/rJC0L0UC/DfNp9tYqNgxAoG4WgG+zNtSz2CxghfM8UaUP8eslQRuJHojuZxgy9MLC37Dm4VQaiXALoYdMU3f2593l61Ads3YHHToA4izYprm5Ng3q83QqJoQsopxysRpN274BwIDAQAB";
    private static String public_key = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAKSHRoqSciyYXzfwchODyt0DQj4fBLWG4zcUYL+skLQvRQL8N82n21io2DECgbhaAb7M21LPYLGCF8zxRpQ/x6yVBG4keiO5nGDL0wsLfsObhVBqJcAuhh0xTd/bn3eXrUB2zdgcdOgDiLNimubk2DerzdComhCyinHKxGk3bvgHAgMBAAECgYAbnNR69z8QOvZoFgOfQNQwKZbZhC0vJhdGLDZclOKoSvKjIJ9g9ZX7mELIXupUfU6jrg/1IvbQc8v4ylmVEes5x0pSzsbhI3iuH7m5PNLXChqzAN4K1uC6qGNy9WL3lDTQJ2LV57/1S7iDLtWCfv/aseOzStUL9Znv19W6lX6YSQJBAOkW9A5niW9X0LxxbcMw+xwqDvfDv2nZWmCLqT56W+rjrUEP62fqRX2KqP+zwtUHOYwvaiQSh35TyQ+m1e+QdbMCQQC0syvPgrg2oMl+MkYy0cE2uMV+vZ6evzSaeq6BosUQsnpe/DOKTQZ5GkB+BnYMFZFF5YwkBifsXdIApb8mC/JdAj91dBuHJqUadiW4z29/7C6dApSIRRsvO1dPTxD5aq7mrdOf9WWp92MM39JJB0wmDH3zJfFWPAAKqC2otWkYTrMCQQCZ2Z8oi9y6LkXAG5/nLu354HHOijXeZV+tU1z25RYyNDO6YbKkQxaKz44vfuLNQSOyRlH+bftZ5Tui73wDMdLFAkEArVdICaxILdndxnPB/KSUFNPIoupBvjz+WhoyuXiujs2KKtojLY5DMa/LkAcW2Akr9ZwqkPVeuDcDbVQrEEyfdg==";

    public static String decode(String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(2, getPrivateKey(public_key));
            return new String(cipher.doFinal(Base64.decode(str)));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static byte[] decrypt(byte[] bArr, String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(getKey(str), "AES");
            Cipher cipher = Cipher.getInstance(algorithmStr);
            cipher.init(2, secretKeySpec);
            return cipher.doFinal(bArr);
        } catch (InvalidKeyException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e3) {
            e3.printStackTrace();
            return null;
        } catch (BadPaddingException e4) {
            e4.printStackTrace();
            return null;
        } catch (IllegalBlockSizeException e5) {
            e5.printStackTrace();
            return null;
        } catch (NoSuchPaddingException e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public static String encode(String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            byte[] bytes = str.getBytes();
            cipher.init(1, getPublicKey(private_key));
            return Base64.encode(cipher.doFinal(bytes));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static byte[] getKey(String str) {
        return str != null ? str.getBytes() : new byte[24];
    }

    public static PrivateKey getPrivateKey(String str) throws Exception {
        return KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str)));
    }

    public static PublicKey getPublicKey(String str) throws Exception {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str)));
    }

    public static String parseByte2HexStr(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                hexString = '0' + hexString;
            }
            stringBuffer.append(hexString.toUpperCase());
        }
        return stringBuffer.toString();
    }

    public static byte[] parseHexStr2Byte(String str) throws NumberFormatException {
        if (str.length() < 1) {
            return null;
        }
        byte[] bArr = new byte[str.length() / 2];
        for (int i2 = 0; i2 < str.length() / 2; i2++) {
            int i3 = i2 * 2;
            int i4 = i3 + 1;
            bArr[i2] = (byte) ((Integer.parseInt(str.substring(i3, i4), 16) * 16) + Integer.parseInt(str.substring(i4, i3 + 2), 16));
        }
        return bArr;
    }

    public static String decrypt(String str) {
        return new String(decrypt(parseHexStr2Byte(str), "flowerwordchangi"));
    }
}
