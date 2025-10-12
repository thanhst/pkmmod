package com.ykiocnwpdseglq.nhvkwyj.social;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import java.io.File;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class SystemShareHelper {
    private static SystemShareHelper instance;

    public static SystemShareHelper getInstance() {
        if (instance == null) {
            instance = new SystemShareHelper();
        }
        return instance;
    }

    public void sharePhoto(Activity activity, String str, String str2) {
        Uri uriFromFile = Uri.fromFile(new File(str));
        Intent intent = new Intent("android.intent.action.SEND");
        if (uriFromFile == null || str == null || str == "") {
            intent.setType("text/plain");
        } else {
            intent.putExtra("android.intent.extra.STREAM", uriFromFile);
            intent.setType("image/*");
            intent.putExtra("sms_body", str2);
        }
        intent.putExtra("android.intent.extra.TEXT", str2);
        activity.startActivity(intent);
    }

    public void sharePhotos(Activity activity, ArrayList<Uri> arrayList, String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND_MULTIPLE");
        intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
        intent.setType("image/*");
        if (str == null || str.length() == 0) {
            activity.startActivity(intent);
        } else {
            activity.startActivity(Intent.createChooser(intent, str));
        }
    }

    public void shareText(Activity activity, String str, String str2) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", str2);
        intent.setType("text/plain");
        activity.startActivity(Intent.createChooser(intent, str));
    }
}
