package com.ykiocnwpdseglq.nhvkwyj.analysis;

import android.content.Context;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.AppEventsLogger;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.DataUtil;
import com.ykiocnwpdseglq.nhvkwyj.R;
import java.math.BigDecimal;
import java.util.Currency;

/* loaded from: classes.dex */
public class QQZLsIxEqfWSyg {
    public static void eventCustom(Context context, String str, String str2) {
        if (!FacebookSdk.isInitialized() || !context.getString(R.string.pg_facebook_need_collect).equals("1") || str == null || str.equals("create_role_unique")) {
            return;
        }
        AppEventsLogger appEventsLoggerNewLogger = AppEventsLogger.newLogger(context);
        if (str.equals("create_role")) {
            appEventsLoggerNewLogger.logEvent(AppEventsConstants.EVENT_NAME_COMPLETED_TUTORIAL);
        } else {
            appEventsLoggerNewLogger.logEvent(str);
        }
    }

    public static void eventLogin(Context context, String str, String str2) {
        if (FacebookSdk.isInitialized() && context.getString(R.string.pg_facebook_need_collect).equals("1")) {
            AppEventsLogger appEventsLoggerNewLogger = AppEventsLogger.newLogger(context);
            Bundle bundle = new Bundle();
            bundle.putString(AccessToken.USER_ID_KEY, String.valueOf(str2));
            appEventsLoggerNewLogger.logEvent(str, bundle);
        }
    }

    public static void eventPay(Context context, String str, String str2, String str3, double d2, String str4) {
        if (FacebookSdk.isInitialized() && context.getString(R.string.pg_facebook_need_collect).equals("1")) {
            AppEventsLogger appEventsLoggerNewLogger = AppEventsLogger.newLogger(context);
            Bundle bundle = new Bundle();
            bundle.putString(AppEventsConstants.EVENT_PARAM_CONTENT_TYPE, DataUtil.ORDER_COLUMN.ORDER_GAME_ORDER_ID);
            bundle.putString(AppEventsConstants.EVENT_PARAM_CONTENT_ID, str3);
            if (str4 == null || str4.length() == 0) {
                appEventsLoggerNewLogger.logPurchase(BigDecimal.valueOf(d2), null, bundle);
            } else {
                appEventsLoggerNewLogger.logPurchase(BigDecimal.valueOf(d2), Currency.getInstance(str4), bundle);
            }
        }
    }

    public static void eventRegister(Context context, String str, String str2) {
        if (FacebookSdk.isInitialized() && context.getString(R.string.pg_facebook_need_collect).equals("1")) {
            AppEventsLogger appEventsLoggerNewLogger = AppEventsLogger.newLogger(context);
            Bundle bundle = new Bundle();
            bundle.putString(AccessToken.USER_ID_KEY, String.valueOf(str2));
            appEventsLoggerNewLogger.logEvent(AppEventsConstants.EVENT_NAME_COMPLETED_REGISTRATION, bundle);
        }
    }
}
