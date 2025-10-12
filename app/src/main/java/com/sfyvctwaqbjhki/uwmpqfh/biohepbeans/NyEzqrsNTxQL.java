package com.sfyvctwaqbjhki.uwmpqfh.biohepbeans;

import java.io.Serializable;

/* loaded from: classes.dex */
public class NyEzqrsNTxQL extends MsgBean {
    private MsgPlatformCoin data;

    public static class MsgPlatformCoin implements Serializable {
        private String money;
        private String productCoin;
        private String remain;

        public MsgPlatformCoin(String str, String str2, String str3) {
            this.remain = str;
            this.money = str2;
            this.productCoin = str3;
        }

        public String getMoney() {
            return this.money;
        }

        public String getProductCoin() {
            return this.productCoin;
        }

        public String getRemain() {
            return this.remain;
        }
    }

    public NyEzqrsNTxQL(int i2, String str, MsgPlatformCoin msgPlatformCoin) {
        super(i2, str);
        this.data = msgPlatformCoin;
    }

    public final MsgPlatformCoin getData() {
        return this.data;
    }

    public final void setData(MsgPlatformCoin msgPlatformCoin) {
        this.data = msgPlatformCoin;
    }
}
