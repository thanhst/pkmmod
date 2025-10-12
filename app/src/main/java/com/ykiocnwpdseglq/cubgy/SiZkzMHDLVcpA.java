package com.ykiocnwpdseglq.cubgy;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import com.ykiocnwpdseglq.cubgy.managers.RgGGKcUwgofnY;
import com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.DIUGfDWQpOJHLr;
import com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.PurchaseListener;
import com.ykiocnwpdseglq.lbmntzwepqakgu.wrappers.YghfcYFCEZXR;

/* loaded from: classes.dex */
public class SiZkzMHDLVcpA extends YghfcYFCEZXR {
    @Override // com.ykiocnwpdseglq.lbmntzwepqakgu.wrappers.YghfcYFCEZXR, com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.SomnJeaLs
    public void applicationOnCreate(Application application) {
        RgGGKcUwgofnY.getInstance().applicationOnCreate(application);
    }

    @Override // com.ykiocnwpdseglq.lbmntzwepqakgu.wrappers.YghfcYFCEZXR, com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.DIUGfDWQpOJHLr
    public void consumeClientOrder(Context context, DIUGfDWQpOJHLr.ParamGetter paramGetter) {
        RgGGKcUwgofnY.getInstance().consumeClientOrder(context, paramGetter);
    }

    @Override // com.ykiocnwpdseglq.lbmntzwepqakgu.wrappers.YghfcYFCEZXR, com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.SomnJeaLs
    public void exit() {
        RgGGKcUwgofnY.getInstance().exit();
    }

    @Override // com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.DIUGfDWQpOJHLr
    public void initPay(Context context, DIUGfDWQpOJHLr.ParamGetter paramGetter, PurchaseListener purchaseListener) {
        RgGGKcUwgofnY.getInstance().initPay(context, paramGetter, purchaseListener);
    }

    @Override // com.ykiocnwpdseglq.lbmntzwepqakgu.wrappers.YghfcYFCEZXR, com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.SomnJeaLs
    public void onActivityResult(int i2, int i3, Intent intent) {
        RgGGKcUwgofnY.getInstance().onActivityResult(i2, i3, intent);
    }

    @Override // com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.DIUGfDWQpOJHLr
    public void startPay(Activity activity, DIUGfDWQpOJHLr.ParamGetter paramGetter) {
        RgGGKcUwgofnY.getInstance().startPay(activity, paramGetter);
    }
}
