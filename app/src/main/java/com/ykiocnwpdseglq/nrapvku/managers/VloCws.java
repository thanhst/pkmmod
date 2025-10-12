package com.ykiocnwpdseglq.nrapvku.managers;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustAttribution;
import com.adjust.sdk.AdjustConfig;
import com.adjust.sdk.AdjustEvent;
import com.adjust.sdk.OnAttributionChangedListener;
import com.ykiocnwpdseglq.nrapvku.R;

/* loaded from: classes.dex */
public class VloCws {
    private static VloCws instance;
    private boolean isApplicationlaunch = false;
    private Application myApplication;

    public static VloCws getInstance() {
        if (instance == null) {
            instance = new VloCws();
        }
        return instance;
    }

    public void applicationOnCreate(Application application) {
        if (this.isApplicationlaunch) {
            return;
        }
        this.isApplicationlaunch = true;
        this.myApplication = application;
        String string = application.getString(R.string.pg_adjust_environment);
        String string2 = application.getString(R.string.pg_adjust_app_token);
        if (string2.equals("")) {
            return;
        }
        if (string.equals("")) {
            string = AdjustConfig.ENVIRONMENT_PRODUCTION;
        }
        AdjustConfig adjustConfig = new AdjustConfig(application, string2, string);
        String strReplaceAll = application.getString(R.string.pg_adjust_info).replaceAll(" ", "");
        String[] strArrSplit = strReplaceAll.substring(strReplaceAll.indexOf("(") + 1, strReplaceAll.indexOf(")")).split(",");
        if (strArrSplit.length != 5) {
            return;
        }
        adjustConfig.setAppSecret(Long.parseLong(strArrSplit[0]), Long.parseLong(strArrSplit[1]), Long.parseLong(strArrSplit[2]), Long.parseLong(strArrSplit[3]), Long.parseLong(strArrSplit[4]));
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.ykiocnwpdseglq.nrapvku.managers.VloCws.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                Adjust.onPause();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                Adjust.onResume();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
            }
        });
        adjustConfig.setOnAttributionChangedListener(new OnAttributionChangedListener() { // from class: com.ykiocnwpdseglq.nrapvku.managers.VloCws.2
            @Override // com.adjust.sdk.OnAttributionChangedListener
            public void onAttributionChanged(AdjustAttribution adjustAttribution) {
            }
        });
        Adjust.onCreate(adjustConfig);
    }

    public void eventCustom(Context context, String str, String str2) {
        if (str2 == null || str2.equals("") || !Adjust.isEnabled()) {
            return;
        }
        Adjust.trackEvent(new AdjustEvent(str2));
    }

    public void eventLogin(Context context, String str, String str2) {
        String string = this.myApplication.getString(R.string.pg_adjust_login);
        String string2 = this.myApplication.getString(R.string.pg_adjust_login_unique);
        if (!string.equals("") && Adjust.isEnabled()) {
            Adjust.trackEvent(new AdjustEvent(string));
        }
        if (string2.equals("") || !Adjust.isEnabled()) {
            return;
        }
        Adjust.trackEvent(new AdjustEvent(string2));
    }

    public void eventPay(Context context, String str, String str2, String str3, double d2, String str4) {
        String string = this.myApplication.getString(R.string.pg_adjust_purchase);
        String string2 = this.myApplication.getString(R.string.pg_adjust_purchase_unique);
        if (!string.equals("") && Adjust.isEnabled()) {
            AdjustEvent adjustEvent = new AdjustEvent(string);
            adjustEvent.setRevenue(d2, str4);
            adjustEvent.setOrderId(str3);
            Adjust.trackEvent(adjustEvent);
        }
        if (string2.equals("") || !Adjust.isEnabled()) {
            return;
        }
        AdjustEvent adjustEvent2 = new AdjustEvent(string2);
        adjustEvent2.setRevenue(d2, str4);
        adjustEvent2.setOrderId(str3);
        Adjust.trackEvent(adjustEvent2);
    }

    public void eventRegister(Context context, String str, String str2) {
        String string = this.myApplication.getString(R.string.pg_adjust_registration);
        String string2 = this.myApplication.getString(R.string.pg_adjust_registration_unique);
        if (!string.equals("") && Adjust.isEnabled()) {
            Adjust.trackEvent(new AdjustEvent(string));
        }
        if (string2.equals("") || !Adjust.isEnabled()) {
            return;
        }
        Adjust.trackEvent(new AdjustEvent(string2));
    }
}
