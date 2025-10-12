package com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx;

/* loaded from: classes.dex */
public class ConsumeInfo {
    private int appId;
    private String clientTime;
    private String platformCoin;
    private String productDesc;
    private int status;
    private String transactionId;
    private int userId;

    public ConsumeInfo() {
    }

    public final int getAppId() {
        return this.appId;
    }

    public final String getClientTime() {
        String str = this.clientTime;
        return str == null ? "" : str;
    }

    public final String getPlatformCoin() {
        String str = this.platformCoin;
        return str == null ? "" : str;
    }

    public final String getProductDesc() {
        String str = this.productDesc;
        return str == null ? "" : str;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getTransactionId() {
        String str = this.transactionId;
        return str == null ? "" : str;
    }

    public final int getUserId() {
        return this.userId;
    }

    public final void setAppId(int i2) {
        this.appId = i2;
    }

    public final void setClientTime(String str) {
        this.clientTime = str;
    }

    public final void setPlatformCoin(String str) {
        this.platformCoin = str;
    }

    public final void setProductDesc(String str) {
        this.productDesc = str;
    }

    public final void setStatus(int i2) {
        this.status = i2;
    }

    public final void setTransactionId(String str) {
        this.transactionId = str;
    }

    public final void setUserId(int i2) {
        this.userId = i2;
    }

    public ConsumeInfo(int i2, int i3, String str, String str2, String str3, int i4, String str4) {
        this.userId = i2;
        this.appId = i3;
        this.transactionId = str;
        this.platformCoin = str2;
        this.productDesc = str3;
        this.status = i4;
        this.clientTime = str4;
    }
}
