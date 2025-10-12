package com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces;

/* loaded from: classes.dex */
public interface PurchaseListener<T> {

    public enum PurchaseInitState {
        PURCHASE_INIT_STATE_FINISH,
        PURCHASE_INIT_STATE_FAIL
    }

    public enum PurchaseState {
        PURCHASE_STATE_PAY_SUCCESS,
        PURCHASE_STATE_PAY_FAIL,
        PURCHASE_STATE_PAY_CANCEL,
        PURCHASE_STATE_PAY_UNKNOWN,
        PURCHASE_STATE_CONSUME_SUCCESS,
        PURCHASE_STATE_CONSUME_FAIL
    }

    void initCallBack(PurchaseInitState purchaseInitState, String str);

    void payCallBack(PurchaseState purchaseState, T t2, String str);
}
