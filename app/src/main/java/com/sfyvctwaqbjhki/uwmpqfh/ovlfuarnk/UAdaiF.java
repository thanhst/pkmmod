package com.sfyvctwaqbjhki.uwmpqfh.ovlfuarnk;

import android.app.Activity;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.KcUwgofnY;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.Response;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager;
import com.sfyvctwaqbjhki.uwmpqfh.msdiykjb.MhrJWomE;
import com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.ZYlKAS;

/* loaded from: classes.dex */
public class UAdaiF extends ZYlKAS {
    private static UAdaiF instance;

    public static UAdaiF getInstance() {
        if (instance == null) {
            instance = new UAdaiF();
        }
        return instance;
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.ZYlKAS
    public void doPay(Activity activity) {
        MhrJWomE.netMakeOrder(new UserManager(UserManager.Type.MAKEORDER) { // from class: com.sfyvctwaqbjhki.uwmpqfh.ovlfuarnk.UAdaiF.1
            @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager
            public void fail(int i2, String str) {
                if (KcUwgofnY.getInstance().getPayComponentCallBack() != null) {
                    KcUwgofnY.getInstance().getPayComponentCallBack().payFail(i2, str);
                }
            }

            @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager
            public void response(Response response) {
                if (KcUwgofnY.getInstance().getPayComponentCallBack() != null) {
                    KcUwgofnY.getInstance().getPayComponentCallBack().paySuccess();
                }
            }
        });
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.ZYlKAS
    public void init(Activity activity) {
    }
}
