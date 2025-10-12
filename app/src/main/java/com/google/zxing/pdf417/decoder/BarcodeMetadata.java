package com.google.zxing.pdf417.decoder;

/* loaded from: classes.dex */
final class BarcodeMetadata {
    private final int columnCount;
    private final int errorCorrectionLevel;
    private final int rowCount;
    private final int rowCountLowerPart;
    private final int rowCountUpperPart;

    BarcodeMetadata(int i2, int i3, int i4, int i5) {
        this.columnCount = i2;
        this.errorCorrectionLevel = i5;
        this.rowCountUpperPart = i3;
        this.rowCountLowerPart = i4;
        this.rowCount = i3 + i4;
    }

    int getColumnCount() {
        return this.columnCount;
    }

    int getErrorCorrectionLevel() {
        return this.errorCorrectionLevel;
    }

    int getRowCount() {
        return this.rowCount;
    }

    int getRowCountLowerPart() {
        return this.rowCountLowerPart;
    }

    int getRowCountUpperPart() {
        return this.rowCountUpperPart;
    }
}
