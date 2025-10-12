package com.sfyvctwaqbjhki.uwmpqfh.biohepbeans;

/* loaded from: classes.dex */
public class HcONeadzJqn {
    private String channel;
    private String currency;
    private String money;
    private String productId;
    private String purchaseToken;
    private String receipt;
    private String signature;
    private String transactionId;

    public String getChannel() {
        String str = this.channel;
        return str == null ? "" : str;
    }

    public String getCurrency() {
        String str = this.currency;
        return str == null ? "" : str;
    }

    public String getMoney() {
        String str = this.money;
        return str == null ? "" : str;
    }

    public String getProductId() {
        return this.productId;
    }

    public String getPurchaseToken() {
        String str = this.purchaseToken;
        return str == null ? "" : str;
    }

    public String getReceipt() {
        String str = this.receipt;
        return str == null ? "" : str;
    }

    public String getSignature() {
        String str = this.signature;
        return str == null ? "" : str;
    }

    public String getTransactionId() {
        String str = this.transactionId;
        return str == null ? "" : str;
    }

    public void setChannel(String str) {
        this.channel = str;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setMoney(String str) {
        this.money = str;
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    public void setPurchaseToken(String str) {
        this.purchaseToken = str;
    }

    public void setReceipt(String str) {
        this.receipt = str;
    }

    public void setSignature(String str) {
        this.signature = str;
    }

    public void setTransactionId(String str) {
        this.transactionId = str;
    }

    public String toString() {
        return "transactionId: " + getTransactionId() + "\nchannel: " + getChannel() + "\nproductId: " + getProductId() + "\ncurrency: " + getCurrency() + "\nmoney: " + getMoney() + "\nreceipt: " + getReceipt() + "\nsignature: " + getSignature() + "\npurchaseToken: " + getPurchaseToken();
    }
}
