package com.sfyvctwaqbjhki.uwmpqfh.ebvmj;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.sfyvctwaqbjhki.uwmpqfh.R;
import com.sfyvctwaqbjhki.uwmpqfh.biohepbeans.EDakAXiM;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.Response;
import com.sfyvctwaqbjhki.uwmpqfh.ovlfuarnk.PluginNXUfldNktBOT;

/* loaded from: classes.dex */
public class YuHblIgwNAmtVR extends Activity {
    private void jumpToGooglePlay(Activity activity) {
        final EDakAXiM eDakAXiM = Response.getInstance().getEDakAXiM();
        View viewInflate = LayoutInflater.from(activity).inflate(R.layout.cg_pay_gp_dialog, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.dialog_gp_tip);
        String string = activity.getString(R.string.txt_plugin_pay_dialog_tip);
        if (string.indexOf("Pocketgame") != -1) {
            string = string.replace("Pocketgame", eDakAXiM.getPublics().getGpPluginName());
        }
        textView.setText(string);
        final Dialog dialog = new Dialog(activity);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        dialog.setContentView(viewInflate);
        dialog.getWindow().setBackgroundDrawable(null);
        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.YuHblIgwNAmtVR.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                if (i2 != 4) {
                    return false;
                }
                dialog.dismiss();
                YuHblIgwNAmtVR.this.finish();
                PluginNXUfldNktBOT.getInstance().setDoPay(false);
                return true;
            }
        });
        ((Button) viewInflate.findViewById(R.id.dialog_gp_pay)).setOnClickListener(new View.OnClickListener() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.YuHblIgwNAmtVR.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (eDakAXiM.getPublics().getGpPluginLoadingUrl().equals("")) {
                    YuHblIgwNAmtVR yuHblIgwNAmtVR = YuHblIgwNAmtVR.this;
                    yuHblIgwNAmtVR.launchAppDetail(yuHblIgwNAmtVR, eDakAXiM.getPublics().getGpPluginGpUrl(), "com.android.vending");
                } else {
                    YuHblIgwNAmtVR.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(eDakAXiM.getPublics().getGpPluginLoadingUrl())));
                }
                dialog.dismiss();
                YuHblIgwNAmtVR.this.finish();
            }
        });
    }

    public void launchAppDetail(Activity activity, String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + str));
            if (!TextUtils.isEmpty(str2)) {
                intent.setPackage(str2);
            }
            intent.addFlags(268435456);
            activity.startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        jumpToGooglePlay(this);
    }
}
