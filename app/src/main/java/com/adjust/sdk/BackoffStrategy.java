package com.adjust.sdk;

/* loaded from: classes.dex */
public enum BackoffStrategy {
    LONG_WAIT(1, 120000, 86400000, 0.5d, 1.0d),
    SHORT_WAIT(1, 200, 3600000, 0.5d, 1.0d),
    TEST_WAIT(1, 200, 1000, 0.5d, 1.0d),
    NO_WAIT(100, 1, 1000, 1.0d, 1.0d);

    double maxRange;
    long maxWait;
    long milliSecondMultiplier;
    double minRange;
    int minRetries;

    BackoffStrategy(int i2, long j2, long j3, double d2, double d3) {
        this.minRetries = i2;
        this.milliSecondMultiplier = j2;
        this.maxWait = j3;
        this.minRange = d2;
        this.maxRange = d3;
    }
}
