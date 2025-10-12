package com.adjust.sdk;

/* loaded from: classes.dex */
public enum TrackingState {
    OPTED_OUT(1);

    private int value;

    TrackingState(int i2) {
        this.value = i2;
    }

    public int getValue() {
        return this.value;
    }
}
