package com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import android.provider.Settings;
import androidx.core.content.ContextCompat;
import com.adjust.sdk.Constants;
import com.sfyvctwaqbjhki.uwmpqfh.R;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.DataUtil;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.WxGIMQL;
import com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.AskPermissionCallBack;
import com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.DoubleBtnCallBack;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class PermissionUtils {
    private static PermissionUtils instance;
    private AskPermissionCallBack callback;
    private Activity mContext;
    private final int REQUEST_SPECIAL_PERMISSION = 1010;
    private final int REQUEST_SINGLE_PERMISSION = 9527;
    private final int REQUEST_MUTIPLE_PERMISSION = 124;
    private final String mSpecialPermission = "android.permission.SYSTEM_ALERT_WINDOW,android.permission.WRITE_SETTINGS";
    private List<String> mNeedRqSpcPermission = new ArrayList();
    private final String MARK = Build.MANUFACTURER.toLowerCase();

    private PermissionUtils() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkSpecialPermission() {
        if (this.mNeedRqSpcPermission.size() == 0) {
            this.callback.result(true);
            return;
        }
        for (String str : this.mNeedRqSpcPermission) {
            if (str == "android.permission.SYSTEM_ALERT_WINDOW") {
                getOverlayPermission();
            } else if (str == "android.permission.WRITE_SETTINGS") {
                getWriteSetPermission();
            }
        }
    }

    public static PermissionUtils getInstance() {
        if (instance == null) {
            instance = new PermissionUtils();
        }
        return instance;
    }

    private void getOverlayPermission() {
        if (Build.VERSION.SDK_INT < 23 || Settings.canDrawOverlays(this.mContext)) {
            this.callback.result(true);
            return;
        }
        WxGIMQL.createAndShow(this.mContext.getString(R.string.txt_warn), this.mContext.getString(R.string.txt_not_get_special_permission), this.mContext.getString(R.string.txt_cancel), this.mContext.getString(R.string.txt_confirm), new DoubleBtnCallBack() { // from class: com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.PermissionUtils.1
            @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.DoubleBtnCallBack
            public void cancel() {
                PermissionUtils.this.mContext.finish();
                Process.killProcess(Process.myPid());
            }

            @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.SingleBtnCallBack
            public void confirm() {
                Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
                intent.setData(Uri.parse("package:" + PermissionUtils.this.mContext.getPackageName()));
                PermissionUtils.this.mContext.startActivityForResult(intent, 1010);
            }
        });
    }

    private void getWriteSetPermission() {
        if (Build.VERSION.SDK_INT < 23 || Settings.System.canWrite(this.mContext)) {
            this.callback.result(true);
            return;
        }
        WxGIMQL.createAndShow(this.mContext.getString(R.string.txt_warn), this.mContext.getString(R.string.txt_not_get_special_permission), this.mContext.getString(R.string.txt_cancel), this.mContext.getString(R.string.txt_confirm), new DoubleBtnCallBack() { // from class: com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.PermissionUtils.2
            @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.DoubleBtnCallBack
            public void cancel() {
                PermissionUtils.this.mContext.finish();
                Process.killProcess(Process.myPid());
            }

            @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.SingleBtnCallBack
            public void confirm() {
                Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
                intent.setData(Uri.parse("package:" + PermissionUtils.this.mContext.getPackageName()));
                PermissionUtils.this.mContext.startActivityForResult(intent, 1010);
            }
        });
    }

    private Intent googlePlt(Context context) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), null));
        return intent;
    }

    private boolean hasIntent(Context context, Intent intent) {
        return !context.getPackageManager().queryIntentActivities(intent, 65536).isEmpty();
    }

    private Intent huaweiPlt(Context context) {
        Intent intent = new Intent();
        intent.putExtra(DataUtil.LEVEL_COLUMN.PACKAGENAME, context.getPackageName());
        intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
        if (hasIntent(context, intent)) {
            return intent;
        }
        intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity"));
        if (hasIntent(context, intent)) {
            return intent;
        }
        intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.notificationmanager.ui.NotificationManagmentActivity"));
        return intent;
    }

    private Intent leshiPlt(Context context) {
        Intent intent = new Intent();
        intent.putExtra(DataUtil.LEVEL_COLUMN.PACKAGENAME, context.getPackageName());
        intent.setComponent(new ComponentName("com.letv.android.letvsafe", "com.letv.android.letvsafe.PermissionAndApps"));
        return intent;
    }

    private Intent lgPlt(Context context) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.putExtra(DataUtil.LEVEL_COLUMN.PACKAGENAME, context.getPackageName());
        intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$AccessLockSummaryActivity"));
        return intent;
    }

    private Intent meizuPlt(Context context) {
        Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        intent.putExtra(DataUtil.LEVEL_COLUMN.PACKAGENAME, context.getPackageName());
        intent.setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity"));
        return intent;
    }

    private Intent oppoPlt(Context context) {
        Intent intent = new Intent();
        intent.putExtra(DataUtil.LEVEL_COLUMN.PACKAGENAME, context.getPackageName());
        intent.setClassName("com.color.safecenter", "com.color.safecenter.permission.floatwindow.FloatWindowListActivity");
        if (hasIntent(context, intent)) {
            return intent;
        }
        intent.setClassName("com.coloros.safecenter", "com.coloros.safecenter.sysfloatwindow.FloatWindowListActivity");
        if (hasIntent(context, intent)) {
            return intent;
        }
        intent.setClassName("com.oppo.safe", "com.oppo.safe.permission.PermissionAppListActivity");
        return intent;
    }

    private Intent os360Plt(Context context) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.putExtra(DataUtil.LEVEL_COLUMN.PACKAGENAME, context.getPackageName());
        intent.setComponent(new ComponentName("com.qihoo360.mobilesafe", "com.qihoo360.mobilesafe.ui.index.AppEnterActivity"));
        return intent;
    }

    private Intent sonyPlt(Context context) {
        Intent intent = new Intent();
        intent.putExtra(DataUtil.LEVEL_COLUMN.PACKAGENAME, context.getPackageName());
        intent.setComponent(new ComponentName("com.sonymobile.cta", "com.sonymobile.cta.SomcCTAMainActivity"));
        return intent;
    }

    private Intent vivoPlt(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.iqoo.secure", "com.iqoo.secure.ui.phoneoptimize.FloatWindowManager");
        intent.putExtra("packagename", context.getPackageName());
        if (hasIntent(context, intent)) {
            return intent;
        }
        intent.setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.safeguard.SoftPermissionDetailActivity"));
        return intent;
    }

    private Intent xiaomiPlt(Context context) {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.putExtra("extra_pkgname", context.getPackageName());
        if (hasIntent(context, intent)) {
            return intent;
        }
        intent.setPackage("com.miui.securitycenter");
        if (hasIntent(context, intent)) {
            return intent;
        }
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        if (hasIntent(context, intent)) {
            return intent;
        }
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
        return intent;
    }

    public void goPermissionsControlView(Context context, boolean z2) {
        Intent intentHuaweiPlt = this.MARK.contains(Constants.REFERRER_API_HUAWEI) ? huaweiPlt(context) : this.MARK.contains("xiaomi") ? xiaomiPlt(context) : this.MARK.contains("oppo") ? oppoPlt(context) : this.MARK.contains("vivo") ? vivoPlt(context) : this.MARK.contains("meizu") ? meizuPlt(context) : this.MARK.contains("lge") ? lgPlt(context) : this.MARK.contains("qihoo360") ? os360Plt(context) : this.MARK.contains("letv") ? leshiPlt(context) : this.MARK.contains("sony") ? sonyPlt(context) : null;
        if (intentHuaweiPlt == null || !hasIntent(context, intentHuaweiPlt)) {
            intentHuaweiPlt = googlePlt(context);
        }
        if (z2) {
            intentHuaweiPlt.addFlags(268435456);
        }
        try {
            context.startActivity(intentHuaweiPlt);
        } catch (Exception unused) {
            context.startActivity(googlePlt(context));
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 != 1010 || this.mContext == null) {
            return;
        }
        new Handler(this.mContext.getMainLooper()).postDelayed(new Runnable() { // from class: com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.PermissionUtils.4
            @Override // java.lang.Runnable
            public void run() {
                PermissionUtils.this.checkSpecialPermission();
            }
        }, 1000L);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onRequestPermissionsResult(int r4, java.lang.String[] r5, int[] r6) {
        /*
            r3 = this;
            r5 = 9527(0x2537, float:1.335E-41)
            r0 = 124(0x7c, float:1.74E-43)
            if (r4 == r0) goto L8
            if (r4 != r5) goto L62
        L8:
            com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.AskPermissionCallBack r1 = r3.callback
            if (r1 == 0) goto L62
            android.app.Activity r1 = r3.mContext
            if (r1 == 0) goto L62
            r1 = 1
            r2 = 0
            if (r4 == r0) goto L21
            if (r4 == r5) goto L17
            goto L34
        L17:
            if (r6 == 0) goto L33
            int r4 = r6.length
            if (r4 == 0) goto L33
            r4 = r6[r2]
            if (r4 == 0) goto L34
            goto L33
        L21:
            if (r6 == 0) goto L33
            int r4 = r6.length
            if (r4 != 0) goto L27
            goto L33
        L27:
            int r4 = r6.length
            r5 = 0
        L29:
            if (r5 >= r4) goto L34
            r0 = r6[r5]
            if (r0 == 0) goto L30
            r1 = 0
        L30:
            int r5 = r5 + 1
            goto L29
        L33:
            r1 = 0
        L34:
            if (r1 == 0) goto L3a
            r3.checkSpecialPermission()
            goto L62
        L3a:
            android.app.Activity r4 = r3.mContext
            int r5 = com.sfyvctwaqbjhki.uwmpqfh.R.string.txt_warn
            java.lang.String r4 = r4.getString(r5)
            android.app.Activity r5 = r3.mContext
            int r6 = com.sfyvctwaqbjhki.uwmpqfh.R.string.txt_please_open_permission
            java.lang.String r5 = r5.getString(r6)
            android.app.Activity r6 = r3.mContext
            int r0 = com.sfyvctwaqbjhki.uwmpqfh.R.string.txt_confirm
            java.lang.String r6 = r6.getString(r0)
            android.app.Activity r0 = r3.mContext
            int r1 = com.sfyvctwaqbjhki.uwmpqfh.R.string.txt_cancel
            java.lang.String r0 = r0.getString(r1)
            com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.PermissionUtils$3 r1 = new com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.PermissionUtils$3
            r1.<init>()
            com.sfyvctwaqbjhki.uwmpqfh.ebvmj.WxGIMQL.createAndShow(r4, r5, r0, r6, r1)
        L62:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.PermissionUtils.onRequestPermissionsResult(int, java.lang.String[], int[]):void");
    }

    public void requestPermission(Activity activity, String str, AskPermissionCallBack askPermissionCallBack) {
        this.callback = askPermissionCallBack;
        this.mContext = activity;
        if (activity.getApplicationInfo().targetSdkVersion < 23 || Build.VERSION.SDK_INT < 23) {
            askPermissionCallBack.result(true);
            return;
        }
        if ("android.permission.SYSTEM_ALERT_WINDOW,android.permission.WRITE_SETTINGS".contains(str)) {
            this.mNeedRqSpcPermission.add(str);
            checkSpecialPermission();
        } else if (ContextCompat.a(activity, str) != 0) {
            androidx.core.app.b.q(activity, new String[]{str}, 9527);
        } else {
            askPermissionCallBack.result(true);
        }
    }

    public void requestPermission(Activity activity, String[] strArr, AskPermissionCallBack askPermissionCallBack) {
        this.callback = askPermissionCallBack;
        this.mContext = activity;
        if (activity.getApplicationInfo().targetSdkVersion >= 23 && Build.VERSION.SDK_INT >= 23) {
            ArrayList arrayList = new ArrayList();
            for (String str : strArr) {
                if ("android.permission.SYSTEM_ALERT_WINDOW,android.permission.WRITE_SETTINGS".contains(str)) {
                    this.mNeedRqSpcPermission.add(str);
                } else if (ContextCompat.a(activity, str) != 0) {
                    arrayList.add(str);
                }
            }
            if (!arrayList.isEmpty()) {
                androidx.core.app.b.q(activity, (String[]) arrayList.toArray(new String[arrayList.size()]), 124);
                return;
            } else if (this.mNeedRqSpcPermission.size() != 0) {
                checkSpecialPermission();
                return;
            } else {
                askPermissionCallBack.result(true);
                return;
            }
        }
        askPermissionCallBack.result(true);
    }
}
