package com.adjust.sdk;

/* loaded from: classes.dex */
public class ReferrerDetails {
    public Boolean googlePlayInstant;
    public long installBeginTimestampSeconds;
    public long installBeginTimestampServerSeconds;
    public String installReferrer;
    public String installVersion;
    public long referrerClickTimestampSeconds;
    public long referrerClickTimestampServerSeconds;

    public ReferrerDetails(String str, long j2, long j3, long j4, long j5, String str2, Boolean bool) {
        this.installReferrer = str;
        this.referrerClickTimestampSeconds = j2;
        this.installBeginTimestampSeconds = j3;
        this.referrerClickTimestampServerSeconds = j4;
        this.installBeginTimestampServerSeconds = j5;
        this.installVersion = str2;
        this.googlePlayInstant = bool;
    }

    public ReferrerDetails(String str, long j2, long j3) {
        this(str, j2, j3, -1L, -1L, null, null);
    }
}
