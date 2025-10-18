package com.bdesfamlqk.ynufhaz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.internal.ServerProtocol;
import com.lomfsqxinjb.KRgTbxlWh.PCJDkVISZlhELOr;

/* loaded from: classes.dex */
public class XVlfRcH extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = new Intent(this, (Class<?>) PCJDkVISZlhELOr.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        intent.putExtra("UseSplashScreen", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        intent.putExtra("DataString", getIntent().getDataString());
        startActivity(intent);
        finish();
    }
}
