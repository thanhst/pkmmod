package com.google.zxing.oned.rss.expanded.decoders;

/* loaded from: classes.dex */
final class BlockParsedResult {
    private final DecodedInformation decodedInformation;
    private final boolean finished;

    BlockParsedResult(boolean z2) {
        this(null, z2);
    }

    DecodedInformation getDecodedInformation() {
        return this.decodedInformation;
    }

    boolean isFinished() {
        return this.finished;
    }

    BlockParsedResult(DecodedInformation decodedInformation, boolean z2) {
        this.finished = z2;
        this.decodedInformation = decodedInformation;
    }
}
