package com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk;

import android.content.Context;
import android.os.Build;
import android.provider.BaseColumns;
import java.io.File;

/* loaded from: classes.dex */
public final class DataUtil {

    public static final class CONSUME_LIST_COLUMN implements BaseColumns {
        public static final String CONSUME_LIST_APP_ID = "appId";
        public static final String CONSUME_LIST_CLIENTTIME = "clientTime";
        public static final String CONSUME_LIST_PLATFORMCOIN = "platformCoin";
        public static final String CONSUME_LIST_PRODUCTDESC = "productDesc";
        public static final String CONSUME_LIST_STATUS = "status";
        public static final String CONSUME_LIST_TRABSACTION_ID = "transactionId";
        public static final String CONSUME_LIST_USER_ID = "userId";
    }

    public static final class LEVEL_COLUMN implements BaseColumns {
        public static final String APPID = "appId";
        public static final String CLIENTDATE = "clientDate";
        public static final String LEVEL = "level";
        public static final String PACKAGENAME = "packageName";
    }

    public static final class LOGIN_COLUMN implements BaseColumns {
        public static final String APPID = "appId";
        public static final String CLIENTDATE = "clientDate";
        public static final String USERID = "userId";
    }

    public static final class ORDER_COLUMN implements BaseColumns {
        public static final String ORDER_ADV_CHANNEL = "advChannel";
        public static final String ORDER_APP_ID = "appId";
        public static final String ORDER_CHANNEL = "channel";
        public static final String ORDER_CHARGING_TYPE = "chargingType";
        public static final String ORDER_CLIENT_TIME = "clientTime";
        public static final String ORDER_DEVICE = "device";
        public static final String ORDER_DEVICE_NO = "deviceNo";
        public static final String ORDER_GAME_ORDER_ID = "gameOrderId";
        public static final String ORDER_GAME_ZONE_ID = "gameZoneId";
        public static final String ORDER_LEVEL = "level";
        public static final String ORDER_MODEL = "model";
        public static final String ORDER_NET_WORK = "network";
        public static final String ORDER_OPERATOR_OS = "operatorOs";
        public static final String ORDER_PRODUCT_ID = "productId";
        public static final String ORDER_RECEIPT = "receipt";
        public static final String ORDER_ROLE_ID = "roleId";
        public static final String ORDER_SIGN = "sign";
        public static final String ORDER_SIGNATURE = "signature";
        public static final String ORDER_SIGNATURE_DATA = "signatureData";
        public static final String ORDER_SOURCE = "source";
        public static final String ORDER_USER_ID = "userId";
        public static final String ORDER_VERSION = "version";
    }

    public static final class ORDER_LIST_COLUMN implements BaseColumns {
        public static final String AMOUNT = "amount";
        public static final String APPID = "appId";
        public static final String CHANNEL = "channel";
        public static final String CHARGINGTYPE = "chargingType";
        public static final String CLIENTDATE = "clientDate";
        public static final String CURRENCY = "currency";
        public static final String STATUS = "status";
        public static final String TRANSACTIONID = "transactionId";
        public static final String USERID = "userId";
    }

    public static final class USER_COLUMN implements BaseColumns {
        public static final String ACCOUNT_TYPE = "accountType";
        public static final String BASEPWD = "basepwd";
        public static final String CLIENTDATE = "clientDate";
        public static final String EMAIL = "email";
        public static final String IS_DEAD = "isDead";
        public static final String NICKNAME = "nickName";
        public static final String PASSWORD = "password";
        public static final String PHONE = "phone";
        public static final String THIRDPARTYID = "thirdPartyId";
        public static final String UPDATE_TIME = "updateTime";
        public static final String USERID = "userId";
        public static final String USERNAME = "userName";
        public static final String USER_TYPE = "userType";
    }

    public static boolean needSyncPocketData(Context context) {
        if (Build.VERSION.SDK_INT < 29) {
            String str = FileUtils.getSDCardPath() + "/chrlife/sdk_v1.db";
            StringBuilder sb = new StringBuilder();
            sb.append(FileUtils.getSDCardPath());
            sb.append("/pocket/pocket_sdk_v1.db");
            return !new File(str).exists() && new File(sb.toString()).exists();
        }
        if (context.getApplicationInfo().targetSdkVersion >= 30) {
            return false;
        }
        String str2 = context.getFilesDir() + "/sdk_v1.db";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(FileUtils.getSDCardPath());
        sb2.append("/pocket/pocket_sdk_v1.db");
        return !new File(str2).exists() && new File(sb2.toString()).exists();
    }
}
