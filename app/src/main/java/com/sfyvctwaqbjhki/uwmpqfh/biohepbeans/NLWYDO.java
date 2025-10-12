package com.sfyvctwaqbjhki.uwmpqfh.biohepbeans;

import java.util.List;

/* loaded from: classes.dex */
public class NLWYDO extends MsgBean {
    private List<Order> data;
    private String lastTime;

    public static class Order {
        private String amount;
        private int channel;
        private int chargingType;
        private String clientDate;
        private String currency;
        private int status;
        private String transactionId;

        public Order() {
        }

        public Order(String str, String str2, String str3, int i2, int i3, int i4, String str4) {
            this.transactionId = str;
            this.amount = str2;
            this.currency = str3;
            this.channel = i2;
            this.status = i3;
            this.chargingType = i4;
            this.clientDate = str4;
        }

        public String getAmount() {
            return this.amount;
        }

        public int getChannel() {
            return this.channel;
        }

        public int getChargingType() {
            return this.chargingType;
        }

        public String getClientDate() {
            return this.clientDate;
        }

        public String getCurrency() {
            return this.currency;
        }

        public int getStatus() {
            return this.status;
        }

        public String getTransactionId() {
            return this.transactionId;
        }

        public void setAmount(String str) {
            this.amount = str;
        }

        public void setChannel(int i2) {
            this.channel = i2;
        }

        public void setChargingType(int i2) {
            this.chargingType = i2;
        }

        public void setClientDate(String str) {
            this.clientDate = str;
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
    }

    public NLWYDO(int i2, String str, String str2, List<Order> list) {
        super(i2, str);
        this.lastTime = str2;
        this.data = list;
    }

    public List<Order> getData() {
        return this.data;
    }

    public String getLastTime() {
        return this.lastTime;
    }

    public void setData(List<Order> list) {
        this.data = list;
    }

    public void setLastTime(String str) {
        this.lastTime = str;
    }
}
