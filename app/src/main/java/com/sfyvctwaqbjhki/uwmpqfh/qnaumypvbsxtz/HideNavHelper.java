package com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz;

import android.app.Activity;
import android.app.Dialog;
import android.view.Window;
import android.view.WindowManager;

/* loaded from: classes.dex */
public class HideNavHelper {
    public static void hideActivityNav(Activity activity) {
        activity.getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    public static void hideDialogNav(Dialog dialog) {
        Window window = dialog.getWindow();
        window.setFlags(1024, 1024);
        window.getDecorView().setSystemUiVisibility(5894);
    }

    public static void hideVirtualKey(Dialog dialog) {
        Window window = dialog.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.systemUiVisibility = 2;
        window.setAttributes(attributes);
    }

    public static boolean isNavHide(int i2) {
        return i2 == 5894;
    }
}
