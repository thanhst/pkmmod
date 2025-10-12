package com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx;

/* loaded from: classes.dex */
public class JwpHqftVBZs {
    private String amount;
    private int appId;
    private int channel;
    private int chargingType;
    private String clientTime;
    private String currency;
    private int status;
    private String transactionId;
    private int userId;

    public JwpHqftVBZs() {
    }

    public String getAmount() {
        String str = this.amount;
        return str == null ? "" : str;
    }

    public int getAppId() {
        return this.appId;
    }

    public int getChannel() {
        return this.channel;
    }

    public int getChargingType() {
        return this.chargingType;
    }

    public final String getClientTime() {
        String str = this.clientTime;
        return str == null ? "" : str;
    }

    public String getCurrency() {
        String str = this.currency;
        return str == null ? "" : str;
    }

    public int getStatus() {
        return this.status;
    }

    public String getTransactionId() {
        String str = this.transactionId;
        return str == null ? "" : str;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public void setAppId(int i2) {
        this.appId = i2;
    }

    public void setChannel(int i2) {
        this.channel = i2;
    }

    public void setChargingType(int i2) {
        this.chargingType = i2;
    }

    public final void setClientTime(String str) {
        this.clientTime = str;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setStatus(int i2) {
        this.status = i2;
    }

    public void setTransactionId(String str) {
        this.transactionId = str;
    }

    public void setUserId(int i2) {
        this.userId = i2;
    }

    public JwpHqftVBZs(int i2, int i3, String str, String str2, String str3, int i4, int i5, int i6, String str4) {
        this.userId = i2;
        this.appId = i3;
        this.transactionId = str;
        this.amount = str2;
        this.currency = str3;
        this.channel = i4;
        this.status = i5;
        this.chargingType = i6;
        this.clientTime = str4;
    }
}
