package com.ykiocnwpdseglq.nrapvku;

import android.app.Application;
import android.content.Context;
import com.ykiocnwpdseglq.lbmntzwepqakgu.wrappers.ADXJOCEmpr;
import com.ykiocnwpdseglq.nrapvku.managers.VloCws;

/* loaded from: classes.dex */
public class QUXOdDKrcTYluo extends ADXJOCEmpr {
    @Override // com.ykiocnwpdseglq.lbmntzwepqakgu.wrappers.ADXJOCEmpr, com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.SomnJeaLs
    public void applicationOnCreate(Application application) {
        VloCws.getInstance().applicationOnCreate(application);
    }

    @Override // com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.VKiwrnDgpL
    public void eventCustom(Context context, String str, String str2) {
        VloCws.getInstance().eventCustom(context, str, str2);
    }

    @Override // com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.VKiwrnDgpL
    public void eventLogin(Context context, String str, String str2) {
        VloCws.getInstance().eventLogin(context, str, str2);
    }

    @Override // com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.VKiwrnDgpL
    public void eventPay(Context context, String str, String str2, String str3, double d2, String str4) {
        VloCws.getInstance().eventPay(context, str, str2, str3, d2, str4);
    }

    @Override // com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.VKiwrnDgpL
    public void eventRegister(Context context, String str, String str2) {
        VloCws.getInstance().eventRegister(context, str, str2);
    }
}
