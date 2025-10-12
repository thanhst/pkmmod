package com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.rsa;

/* loaded from: classes.dex */
public class Base64 {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final boolean DECODE = false;
    public static final boolean ENCODE = true;
    private static final byte[] ALPHABET = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] WEBSAFE_ALPHABET = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private static final byte WHITE_SPACE_ENC = -5;
    private static final byte EQUALS_SIGN = 61;
    private static final byte EQUALS_SIGN_ENC = -1;
    private static final byte NEW_LINE = 10;
    private static final byte[] DECODABET = {-9, -9, -9, -9, -9, -9, -9, -9, -9, WHITE_SPACE_ENC, WHITE_SPACE_ENC, -9, -9, WHITE_SPACE_ENC, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, WHITE_SPACE_ENC, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, EQUALS_SIGN, -9, -9, -9, EQUALS_SIGN_ENC, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, NEW_LINE, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9};
    private static final byte[] WEBSAFE_DECODABET = {-9, -9, -9, -9, -9, -9, -9, -9, -9, WHITE_SPACE_ENC, WHITE_SPACE_ENC, -9, -9, WHITE_SPACE_ENC, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, WHITE_SPACE_ENC, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, EQUALS_SIGN, -9, -9, -9, EQUALS_SIGN_ENC, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, NEW_LINE, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9};

    private Base64() {
    }

    public static byte[] decode(String str) throws Base64DecoderException {
        byte[] bytes = str.getBytes();
        return decode(bytes, 0, bytes.length);
    }

    private static int decode4to3(byte[] bArr, int i2, byte[] bArr2, int i3, byte[] bArr3) {
        byte b2 = bArr[i2 + 2];
        if (b2 == 61) {
            bArr2[i3] = (byte) ((((bArr3[bArr[i2 + 1]] << 24) >>> 12) | ((bArr3[bArr[i2]] << 24) >>> 6)) >>> 16);
            return 1;
        }
        byte b3 = bArr[i2 + 3];
        if (b3 == 61) {
            int i4 = ((bArr3[bArr[i2 + 1]] << 24) >>> 12) | ((bArr3[bArr[i2]] << 24) >>> 6) | ((bArr3[b2] << 24) >>> 18);
            bArr2[i3] = (byte) (i4 >>> 16);
            bArr2[i3 + 1] = (byte) (i4 >>> 8);
            return 2;
        }
        int i5 = ((bArr3[bArr[i2 + 1]] << 24) >>> 12) | ((bArr3[bArr[i2]] << 24) >>> 6) | ((bArr3[b2] << 24) >>> 18) | ((bArr3[b3] << 24) >>> 24);
        bArr2[i3] = (byte) (i5 >> 16);
        bArr2[i3 + 1] = (byte) (i5 >> 8);
        bArr2[i3 + 2] = (byte) i5;
        return 3;
    }

    public static byte[] decodeWebSafe(String str) throws Base64DecoderException {
        byte[] bytes = str.getBytes();
        return decodeWebSafe(bytes, 0, bytes.length);
    }

    public static String encode(byte[] bArr) {
        return encode(bArr, 0, bArr.length, ALPHABET, true);
    }

    private static byte[] encode3to4(byte[] bArr, int i2, int i3, byte[] bArr2, int i4, byte[] bArr3) {
        int i5 = (i3 > 0 ? (bArr[i2] << 24) >>> 8 : 0) | (i3 > 1 ? (bArr[i2 + 1] << 24) >>> 16 : 0) | (i3 > 2 ? (bArr[i2 + 2] << 24) >>> 24 : 0);
        if (i3 == 1) {
            bArr2[i4] = bArr3[i5 >>> 18];
            bArr2[i4 + 1] = bArr3[(i5 >>> 12) & 63];
            bArr2[i4 + 2] = EQUALS_SIGN;
            bArr2[i4 + 3] = EQUALS_SIGN;
            return bArr2;
        }
        if (i3 == 2) {
            bArr2[i4] = bArr3[i5 >>> 18];
            bArr2[i4 + 1] = bArr3[(i5 >>> 12) & 63];
            bArr2[i4 + 2] = bArr3[(i5 >>> 6) & 63];
            bArr2[i4 + 3] = EQUALS_SIGN;
            return bArr2;
        }
        if (i3 != 3) {
            return bArr2;
        }
        bArr2[i4] = bArr3[i5 >>> 18];
        bArr2[i4 + 1] = bArr3[(i5 >>> 12) & 63];
        bArr2[i4 + 2] = bArr3[(i5 >>> 6) & 63];
        bArr2[i4 + 3] = bArr3[i5 & 63];
        return bArr2;
    }

    public static String encodeWebSafe(byte[] bArr, boolean z2) {
        return encode(bArr, 0, bArr.length, WEBSAFE_ALPHABET, z2);
    }

    public static String encode(byte[] bArr, int i2, int i3, byte[] bArr2, boolean z2) {
        byte[] bArrEncode = encode(bArr, i2, i3, bArr2, Integer.MAX_VALUE);
        int length = bArrEncode.length;
        while (!z2 && length > 0 && bArrEncode[length - 1] == 61) {
            length--;
        }
        return new String(bArrEncode, 0, length);
    }

    public static byte[] decode(byte[] bArr) throws Base64DecoderException {
        return decode(bArr, 0, bArr.length);
    }

    public static byte[] decodeWebSafe(byte[] bArr) throws Base64DecoderException {
        return decodeWebSafe(bArr, 0, bArr.length);
    }

    public static byte[] decode(byte[] bArr, int i2, int i3) throws Base64DecoderException {
        return decode(bArr, i2, i3, DECODABET);
    }

    public static byte[] decodeWebSafe(byte[] bArr, int i2, int i3) throws Base64DecoderException {
        return decode(bArr, i2, i3, WEBSAFE_DECODABET);
    }

    public static byte[] decode(byte[] bArr, int i2, int i3, byte[] bArr2) throws Base64DecoderException {
        byte[] bArr3 = new byte[((i3 * 3) / 4) + 2];
        byte[] bArr4 = new byte[4];
        int i4 = 0;
        int i5 = 0;
        int iDecode4to3 = 0;
        while (true) {
            if (i4 >= i3) {
                break;
            }
            int i6 = i4 + i2;
            byte b2 = (byte) (bArr[i6] & 127);
            byte b3 = bArr2[b2];
            if (b3 < -5) {
                throw new Base64DecoderException("Bad Base64 input character at " + i4 + ": " + ((int) bArr[i6]) + "(decimal)");
            }
            if (b3 >= -1) {
                if (b2 == 61) {
                    int i7 = i3 - i4;
                    byte b4 = (byte) (bArr[(i3 - 1) + i2] & 127);
                    if (i5 == 0 || i5 == 1) {
                        throw new Base64DecoderException("invalid padding byte '=' at byte offset " + i4);
                    }
                    if ((i5 == 3 && i7 > 2) || (i5 == 4 && i7 > 1)) {
                        throw new Base64DecoderException("padding byte '=' falsely signals end of encoded value at offset " + i4);
                    }
                    if (b4 != 61 && b4 != 10) {
                        throw new Base64DecoderException("encoded value has invalid trailing byte");
                    }
                } else {
                    int i8 = i5 + 1;
                    bArr4[i5] = b2;
                    if (i8 == 4) {
                        iDecode4to3 += decode4to3(bArr4, 0, bArr3, iDecode4to3, bArr2);
                        i5 = 0;
                    } else {
                        i5 = i8;
                    }
                }
            }
            i4++;
        }
        if (i5 != 0) {
            if (i5 != 1) {
                bArr4[i5] = EQUALS_SIGN;
                iDecode4to3 += decode4to3(bArr4, 0, bArr3, iDecode4to3, bArr2);
            } else {
                throw new Base64DecoderException("single trailing character at offset " + (i3 - 1));
            }
        }
        byte[] bArr5 = new byte[iDecode4to3];
        System.arraycopy(bArr3, 0, bArr5, 0, iDecode4to3);
        return bArr5;
    }

    public static byte[] encode(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        int i5 = ((i3 + 2) / 3) * 4;
        byte[] bArr3 = new byte[i5 + (i5 / i4)];
        int i6 = i3 - 2;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i7 < i6) {
            int i10 = ((bArr[i7 + i2] << 24) >>> 8) | ((bArr[(i7 + 1) + i2] << 24) >>> 16) | ((bArr[(i7 + 2) + i2] << 24) >>> 24);
            bArr3[i8] = bArr2[i10 >>> 18];
            int i11 = i8 + 1;
            bArr3[i11] = bArr2[(i10 >>> 12) & 63];
            bArr3[i8 + 2] = bArr2[(i10 >>> 6) & 63];
            bArr3[i8 + 3] = bArr2[i10 & 63];
            i9 += 4;
            if (i9 == i4) {
                bArr3[i8 + 4] = NEW_LINE;
                i8 = i11;
                i9 = 0;
            }
            i7 += 3;
            i8 += 4;
        }
        if (i7 < i3) {
            encode3to4(bArr, i7 + i2, i3 - i7, bArr3, i8, bArr2);
            if (i9 + 4 == i4) {
                bArr3[i8 + 4] = NEW_LINE;
            }
        }
        return bArr3;
    }
}
