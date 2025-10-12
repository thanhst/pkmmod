package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;

/* loaded from: classes.dex */
public final class Encoder {
    public static final int DEFAULT_AZTEC_LAYERS = 0;
    public static final int DEFAULT_EC_PERCENT = 33;
    private static final int MAX_NB_BITS = 32;
    private static final int MAX_NB_BITS_COMPACT = 4;
    private static final int[] WORD_SIZE = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    private Encoder() {
    }

    private static int[] bitsToWords(BitArray bitArray, int i2, int i3) {
        int[] iArr = new int[i3];
        int size = bitArray.getSize() / i2;
        for (int i4 = 0; i4 < size; i4++) {
            int i5 = 0;
            for (int i6 = 0; i6 < i2; i6++) {
                i5 |= bitArray.get((i4 * i2) + i6) ? 1 << ((i2 - i6) - 1) : 0;
            }
            iArr[i4] = i5;
        }
        return iArr;
    }

    private static void drawBullsEye(BitMatrix bitMatrix, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4 += 2) {
            int i5 = i2 - i4;
            int i6 = i5;
            while (true) {
                int i7 = i2 + i4;
                if (i6 <= i7) {
                    bitMatrix.set(i6, i5);
                    bitMatrix.set(i6, i7);
                    bitMatrix.set(i5, i6);
                    bitMatrix.set(i7, i6);
                    i6++;
                }
            }
        }
        int i8 = i2 - i3;
        bitMatrix.set(i8, i8);
        int i9 = i8 + 1;
        bitMatrix.set(i9, i8);
        bitMatrix.set(i8, i9);
        int i10 = i2 + i3;
        bitMatrix.set(i10, i8);
        bitMatrix.set(i10, i9);
        bitMatrix.set(i10, i10 - 1);
    }

    private static void drawModeMessage(BitMatrix bitMatrix, boolean z2, int i2, BitArray bitArray) {
        int i3 = i2 / 2;
        int i4 = 0;
        if (z2) {
            while (i4 < 7) {
                int i5 = (i3 - 3) + i4;
                if (bitArray.get(i4)) {
                    bitMatrix.set(i5, i3 - 5);
                }
                if (bitArray.get(i4 + 7)) {
                    bitMatrix.set(i3 + 5, i5);
                }
                if (bitArray.get(20 - i4)) {
                    bitMatrix.set(i5, i3 + 5);
                }
                if (bitArray.get(27 - i4)) {
                    bitMatrix.set(i3 - 5, i5);
                }
                i4++;
            }
            return;
        }
        while (i4 < 10) {
            int i6 = (i3 - 5) + i4 + (i4 / 5);
            if (bitArray.get(i4)) {
                bitMatrix.set(i6, i3 - 7);
            }
            if (bitArray.get(i4 + 10)) {
                bitMatrix.set(i3 + 7, i6);
            }
            if (bitArray.get(29 - i4)) {
                bitMatrix.set(i6, i3 + 7);
            }
            if (bitArray.get(39 - i4)) {
                bitMatrix.set(i3 - 7, i6);
            }
            i4++;
        }
    }

    public static AztecCode encode(byte[] bArr) {
        return encode(bArr, 33, 0);
    }

    private static BitArray generateCheckWords(BitArray bitArray, int i2, int i3) {
        int size = bitArray.getSize() / i3;
        ReedSolomonEncoder reedSolomonEncoder = new ReedSolomonEncoder(getGF(i3));
        int i4 = i2 / i3;
        int[] iArrBitsToWords = bitsToWords(bitArray, i3, i4);
        reedSolomonEncoder.encode(iArrBitsToWords, i4 - size);
        BitArray bitArray2 = new BitArray();
        bitArray2.appendBits(0, i2 % i3);
        for (int i5 : iArrBitsToWords) {
            bitArray2.appendBits(i5, i3);
        }
        return bitArray2;
    }

    static BitArray generateModeMessage(boolean z2, int i2, int i3) {
        BitArray bitArray = new BitArray();
        if (z2) {
            bitArray.appendBits(i2 - 1, 2);
            bitArray.appendBits(i3 - 1, 6);
            return generateCheckWords(bitArray, 28, 4);
        }
        bitArray.appendBits(i2 - 1, 5);
        bitArray.appendBits(i3 - 1, 11);
        return generateCheckWords(bitArray, 40, 4);
    }

    private static GenericGF getGF(int i2) {
        if (i2 == 4) {
            return GenericGF.AZTEC_PARAM;
        }
        if (i2 == 6) {
            return GenericGF.AZTEC_DATA_6;
        }
        if (i2 == 8) {
            return GenericGF.AZTEC_DATA_8;
        }
        if (i2 == 10) {
            return GenericGF.AZTEC_DATA_10;
        }
        if (i2 == 12) {
            return GenericGF.AZTEC_DATA_12;
        }
        throw new IllegalArgumentException("Unsupported word size ".concat(String.valueOf(i2)));
    }

    static BitArray stuffBits(BitArray bitArray, int i2) {
        BitArray bitArray2 = new BitArray();
        int size = bitArray.getSize();
        int i3 = (1 << i2) - 2;
        int i4 = 0;
        while (i4 < size) {
            int i5 = 0;
            for (int i6 = 0; i6 < i2; i6++) {
                int i7 = i4 + i6;
                if (i7 >= size || bitArray.get(i7)) {
                    i5 |= 1 << ((i2 - 1) - i6);
                }
            }
            int i8 = i5 & i3;
            if (i8 == i3) {
                bitArray2.appendBits(i8, i2);
            } else if (i8 == 0) {
                bitArray2.appendBits(i5 | 1, i2);
            } else {
                bitArray2.appendBits(i5, i2);
                i4 += i2;
            }
            i4--;
            i4 += i2;
        }
        return bitArray2;
    }

    private static int totalBitsInLayer(int i2, boolean z2) {
        return ((z2 ? 88 : 112) + (i2 << 4)) * i2;
    }

    public static AztecCode encode(byte[] bArr, int i2, int i3) {
        BitArray bitArrayStuffBits;
        int i4;
        boolean z2;
        int iAbs;
        int i5;
        int i6;
        BitArray bitArrayEncode = new HighLevelEncoder(bArr).encode();
        int size = ((bitArrayEncode.getSize() * i2) / 100) + 11;
        int size2 = bitArrayEncode.getSize() + size;
        int i7 = 0;
        int i8 = 1;
        if (i3 == 0) {
            BitArray bitArrayStuffBits2 = null;
            int i9 = 0;
            int i10 = 0;
            while (i9 <= 32) {
                boolean z3 = i9 <= 3;
                int i11 = z3 ? i9 + 1 : i9;
                int i12 = totalBitsInLayer(i11, z3);
                if (size2 <= i12) {
                    if (bitArrayStuffBits2 == null || i10 != WORD_SIZE[i11]) {
                        int i13 = WORD_SIZE[i11];
                        i10 = i13;
                        bitArrayStuffBits2 = stuffBits(bitArrayEncode, i13);
                    }
                    int i14 = i12 - (i12 % i10);
                    if ((!z3 || bitArrayStuffBits2.getSize() <= (i10 << 6)) && bitArrayStuffBits2.getSize() + size <= i14) {
                        bitArrayStuffBits = bitArrayStuffBits2;
                        i4 = i10;
                        z2 = z3;
                        iAbs = i11;
                        i5 = i12;
                    }
                }
                i9++;
                i7 = 0;
                i8 = 1;
            }
            throw new IllegalArgumentException("Data too large for an Aztec code");
        }
        z2 = i3 < 0;
        iAbs = Math.abs(i3);
        if (iAbs > (z2 ? 4 : 32)) {
            throw new IllegalArgumentException(String.format("Illegal value %s for layers", Integer.valueOf(i3)));
        }
        i5 = totalBitsInLayer(iAbs, z2);
        i4 = WORD_SIZE[iAbs];
        int i15 = i5 - (i5 % i4);
        bitArrayStuffBits = stuffBits(bitArrayEncode, i4);
        if (bitArrayStuffBits.getSize() + size > i15) {
            throw new IllegalArgumentException("Data to large for user specified layer");
        }
        if (z2 && bitArrayStuffBits.getSize() > (i4 << 6)) {
            throw new IllegalArgumentException("Data to large for user specified layer");
        }
        BitArray bitArrayGenerateCheckWords = generateCheckWords(bitArrayStuffBits, i5, i4);
        int size3 = bitArrayStuffBits.getSize() / i4;
        BitArray bitArrayGenerateModeMessage = generateModeMessage(z2, iAbs, size3);
        int i16 = (z2 ? 11 : 14) + (iAbs << 2);
        int[] iArr = new int[i16];
        int i17 = 2;
        if (z2) {
            for (int i18 = 0; i18 < i16; i18++) {
                iArr[i18] = i18;
            }
            i6 = i16;
        } else {
            int i19 = i16 / 2;
            i6 = i16 + 1 + (((i19 - 1) / 15) * 2);
            int i20 = i6 / 2;
            for (int i21 = 0; i21 < i19; i21++) {
                iArr[(i19 - i21) - i8] = (i20 - r14) - 1;
                iArr[i19 + i21] = (i21 / 15) + i21 + i20 + i8;
            }
        }
        BitMatrix bitMatrix = new BitMatrix(i6);
        int i22 = 0;
        int i23 = 0;
        while (i22 < iAbs) {
            int i24 = ((iAbs - i22) << i17) + (z2 ? 9 : 12);
            int i25 = 0;
            while (i25 < i24) {
                int i26 = i25 << 1;
                while (i7 < i17) {
                    if (bitArrayGenerateCheckWords.get(i23 + i26 + i7)) {
                        int i27 = i22 << 1;
                        bitMatrix.set(iArr[i27 + i7], iArr[i27 + i25]);
                    }
                    if (bitArrayGenerateCheckWords.get((i24 << 1) + i23 + i26 + i7)) {
                        int i28 = i22 << 1;
                        bitMatrix.set(iArr[i28 + i25], iArr[((i16 - 1) - i28) - i7]);
                    }
                    if (bitArrayGenerateCheckWords.get((i24 << 2) + i23 + i26 + i7)) {
                        int i29 = (i16 - 1) - (i22 << 1);
                        bitMatrix.set(iArr[i29 - i7], iArr[i29 - i25]);
                    }
                    if (bitArrayGenerateCheckWords.get((i24 * 6) + i23 + i26 + i7)) {
                        int i30 = i22 << 1;
                        bitMatrix.set(iArr[((i16 - 1) - i30) - i25], iArr[i30 + i7]);
                    }
                    i7++;
                    i17 = 2;
                }
                i25++;
                i7 = 0;
                i17 = 2;
            }
            i23 += i24 << 3;
            i22++;
            i7 = 0;
            i17 = 2;
        }
        drawModeMessage(bitMatrix, z2, i6, bitArrayGenerateModeMessage);
        if (z2) {
            drawBullsEye(bitMatrix, i6 / 2, 5);
        } else {
            int i31 = i6 / 2;
            drawBullsEye(bitMatrix, i31, 7);
            int i32 = 0;
            int i33 = 0;
            while (i33 < (i16 / 2) - 1) {
                for (int i34 = i31 & 1; i34 < i6; i34 += 2) {
                    int i35 = i31 - i32;
                    bitMatrix.set(i35, i34);
                    int i36 = i31 + i32;
                    bitMatrix.set(i36, i34);
                    bitMatrix.set(i34, i35);
                    bitMatrix.set(i34, i36);
                }
                i33 += 15;
                i32 += 16;
            }
        }
        AztecCode aztecCode = new AztecCode();
        aztecCode.setCompact(z2);
        aztecCode.setSize(i6);
        aztecCode.setLayers(iAbs);
        aztecCode.setCodeWords(size3);
        aztecCode.setMatrix(bitMatrix);
        return aztecCode;
    }
}
