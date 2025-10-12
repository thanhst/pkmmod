package com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces;

import android.app.Activity;
import android.content.Context;

/* loaded from: classes.dex */
public interface DIUGfDWQpOJHLr extends SomnJeaLs {

    public interface ParamGetter<T> {
        T getPayParam();
    }

    public interface ParamGetters<T> {
        T getPayParam();
    }

    void consumeClientOrder(Context context, ParamGetter paramGetter);

    void initPay(Context context, ParamGetter paramGetter, PurchaseListener purchaseListener);

    void startPay(Activity activity, ParamGetter paramGetter);
}
