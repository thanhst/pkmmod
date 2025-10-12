package com.adjust.sdk;

import android.content.ContentResolver;
import android.text.TextUtils;
import com.facebook.appevents.UserDataStore;
import com.facebook.internal.NativeProtocol;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.DataUtil;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class PackageBuilder {
    private static ILogger logger = AdjustFactory.getLogger();
    private ActivityStateCopy activityStateCopy;
    private AdjustConfig adjustConfig;
    AdjustAttribution attribution;
    private long createdAt;
    String deeplink;
    private DeviceInfo deviceInfo;
    Map<String, String> extraParameters;
    Boolean googlePlayInstant;
    String installVersion;
    String preinstallLocation;
    String preinstallPayload;
    String rawReferrer;
    String referrer;
    String referrerApi;
    String reftag;
    private SessionParameters sessionParameters;
    long clickTimeInSeconds = -1;
    long clickTimeInMilliseconds = -1;
    long installBeginTimeInSeconds = -1;
    long clickTimeServerInSeconds = -1;
    long installBeginTimeServerInSeconds = -1;

    private class ActivityStateCopy {
        int eventCount;
        long lastInterval;
        String pushToken;
        int sessionCount;
        long sessionLength;
        int subsessionCount;
        long timeSpent;
        String uuid;

        ActivityStateCopy(ActivityState activityState) {
            this.eventCount = -1;
            this.sessionCount = -1;
            this.subsessionCount = -1;
            this.timeSpent = -1L;
            this.lastInterval = -1L;
            this.sessionLength = -1L;
            this.uuid = null;
            this.pushToken = null;
            if (activityState == null) {
                return;
            }
            this.eventCount = activityState.eventCount;
            this.sessionCount = activityState.sessionCount;
            this.subsessionCount = activityState.subsessionCount;
            this.timeSpent = activityState.timeSpent;
            this.lastInterval = activityState.lastInterval;
            this.sessionLength = activityState.sessionLength;
            this.uuid = activityState.uuid;
            this.pushToken = activityState.pushToken;
        }
    }

    PackageBuilder(AdjustConfig adjustConfig, DeviceInfo deviceInfo, ActivityState activityState, SessionParameters sessionParameters, long j2) {
        this.createdAt = j2;
        this.deviceInfo = deviceInfo;
        this.adjustConfig = adjustConfig;
        this.activityStateCopy = new ActivityStateCopy(activityState);
        this.sessionParameters = sessionParameters;
    }

    public static void addBoolean(Map<String, String> map, String str, Boolean bool) {
        if (bool == null) {
            return;
        }
        addLong(map, str, bool.booleanValue() ? 1L : 0L);
    }

    private static void addDate(Map<String, String> map, String str, Date date) {
        if (date == null) {
            return;
        }
        addString(map, str, Util.dateFormatter.format(date));
    }

    private static void addDateInMilliseconds(Map<String, String> map, String str, long j2) {
        if (j2 <= 0) {
            return;
        }
        addDate(map, str, new Date(j2));
    }

    private static void addDateInSeconds(Map<String, String> map, String str, long j2) {
        if (j2 <= 0) {
            return;
        }
        addDate(map, str, new Date(j2 * 1000));
    }

    private static void addDouble(Map<String, String> map, String str, Double d2) {
        if (d2 == null) {
            return;
        }
        addString(map, str, Util.formatString("%.5f", d2));
    }

    private static void addDuration(Map<String, String> map, String str, long j2) {
        if (j2 < 0) {
            return;
        }
        addLong(map, str, (j2 + 500) / 1000);
    }

    static void addJsonObject(Map<String, String> map, String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        addString(map, str, jSONObject.toString());
    }

    public static void addLong(Map<String, String> map, String str, long j2) {
        if (j2 < 0) {
            return;
        }
        addString(map, str, Long.toString(j2));
    }

    static void addMapJson(Map<String, String> map, String str, Map map2) {
        if (map2 == null || map2.size() == 0) {
            return;
        }
        addString(map, str, new JSONObject(map2).toString());
    }

    public static void addString(Map<String, String> map, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        map.put(str, str2);
    }

    private void checkDeviceIds(Map<String, String> map) {
        if (map == null || map.containsKey("mac_sha1") || map.containsKey("mac_md5") || map.containsKey("android_id") || map.containsKey("gps_adid") || map.containsKey("oaid") || map.containsKey("imei") || map.containsKey("meid") || map.containsKey("device_id") || map.containsKey("imeis") || map.containsKey("meids") || map.containsKey("device_ids")) {
            return;
        }
        logger.error("Missing device id's. Please check if Proguard is correctly set with Adjust SDK", new Object[0]);
    }

    private boolean containsFireIds(Map<String, String> map) {
        if (map == null) {
            return false;
        }
        return map.containsKey("fire_adid");
    }

    private boolean containsPlayIds(Map<String, String> map) {
        if (map == null) {
            return false;
        }
        return map.containsKey("gps_adid");
    }

    private Map<String, String> getAdRevenueParameters(String str, JSONObject jSONObject) {
        ContentResolver contentResolver = this.adjustConfig.context.getContentResolver();
        HashMap map = new HashMap();
        Map<String, String> imeiParameters = Reflection.getImeiParameters(this.adjustConfig.context, logger);
        if (imeiParameters != null) {
            map.putAll(imeiParameters);
        }
        Map<String, String> oaidParameters = Reflection.getOaidParameters(this.adjustConfig.context, logger);
        if (oaidParameters != null) {
            map.putAll(oaidParameters);
        }
        this.deviceInfo.reloadPlayIds(this.adjustConfig.context);
        addString(map, "android_uuid", this.activityStateCopy.uuid);
        addString(map, "gps_adid", this.deviceInfo.playAdId);
        addLong(map, "gps_adid_attempt", this.deviceInfo.playAdIdAttempt);
        addString(map, "gps_adid_src", this.deviceInfo.playAdIdSource);
        addBoolean(map, "tracking_enabled", this.deviceInfo.isTrackingEnabled);
        addString(map, "fire_adid", Util.getFireAdvertisingId(contentResolver));
        addBoolean(map, "fire_tracking_enabled", Util.getFireTrackingEnabled(contentResolver));
        if (!containsPlayIds(map) && !containsFireIds(map)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.reloadNonPlayIds(this.adjustConfig.context);
            addString(map, "android_id", this.deviceInfo.androidId);
            addString(map, "mac_md5", this.deviceInfo.macShortMd5);
            addString(map, "mac_sha1", this.deviceInfo.macSha1);
        }
        addString(map, "api_level", this.deviceInfo.apiLevel);
        addString(map, "app_secret", this.adjustConfig.appSecret);
        addString(map, "app_token", this.adjustConfig.appToken);
        addString(map, "app_version", this.deviceInfo.appVersion);
        Boolean bool = Boolean.TRUE;
        addBoolean(map, "attribution_deeplink", bool);
        addLong(map, "connectivity_type", Util.getConnectivityType(this.adjustConfig.context));
        addString(map, UserDataStore.COUNTRY, this.deviceInfo.country);
        addString(map, "cpu_type", this.deviceInfo.abi);
        addDateInMilliseconds(map, "created_at", this.createdAt);
        addString(map, "default_tracker", this.adjustConfig.defaultTracker);
        addBoolean(map, "device_known", this.adjustConfig.deviceKnown);
        addBoolean(map, "needs_cost", this.adjustConfig.needsCost);
        addString(map, "device_manufacturer", this.deviceInfo.deviceManufacturer);
        addString(map, "device_name", this.deviceInfo.deviceName);
        addString(map, "device_type", this.deviceInfo.deviceType);
        addString(map, "display_height", this.deviceInfo.displayHeight);
        addString(map, "display_width", this.deviceInfo.displayWidth);
        addString(map, "environment", this.adjustConfig.environment);
        addBoolean(map, "event_buffering_enabled", Boolean.valueOf(this.adjustConfig.eventBufferingEnabled));
        addString(map, "external_device_id", this.adjustConfig.externalDeviceId);
        addString(map, "fb_id", this.deviceInfo.fbAttributionId);
        addString(map, "hardware_name", this.deviceInfo.hardwareName);
        addString(map, "installed_at", this.deviceInfo.appInstallTime);
        addString(map, "language", this.deviceInfo.language);
        addDuration(map, "last_interval", this.activityStateCopy.lastInterval);
        addString(map, "mcc", Util.getMcc(this.adjustConfig.context));
        addString(map, "mnc", Util.getMnc(this.adjustConfig.context));
        addBoolean(map, "needs_response_details", bool);
        addLong(map, "network_type", Util.getNetworkType(this.adjustConfig.context));
        addString(map, "os_build", this.deviceInfo.buildName);
        addString(map, "os_name", this.deviceInfo.osName);
        addString(map, "os_version", this.deviceInfo.osVersion);
        addString(map, "package_name", this.deviceInfo.packageName);
        addString(map, "push_token", this.activityStateCopy.pushToken);
        addString(map, "screen_density", this.deviceInfo.screenDensity);
        addString(map, "screen_format", this.deviceInfo.screenFormat);
        addString(map, "screen_size", this.deviceInfo.screenSize);
        addString(map, "secret_id", this.adjustConfig.secretId);
        addString(map, "source", str);
        addJsonObject(map, "payload", jSONObject);
        addLong(map, "session_count", this.activityStateCopy.sessionCount);
        addDuration(map, "session_length", this.activityStateCopy.sessionLength);
        addLong(map, "subsession_count", this.activityStateCopy.subsessionCount);
        addDuration(map, "time_spent", this.activityStateCopy.timeSpent);
        addString(map, "updated_at", this.deviceInfo.appUpdateTime);
        checkDeviceIds(map);
        return map;
    }

    private Map<String, String> getAttributionParameters(String str) {
        ContentResolver contentResolver = this.adjustConfig.context.getContentResolver();
        HashMap map = new HashMap();
        Map<String, String> imeiParameters = Reflection.getImeiParameters(this.adjustConfig.context, logger);
        if (imeiParameters != null) {
            map.putAll(imeiParameters);
        }
        Map<String, String> oaidParameters = Reflection.getOaidParameters(this.adjustConfig.context, logger);
        if (oaidParameters != null) {
            map.putAll(oaidParameters);
        }
        this.deviceInfo.reloadPlayIds(this.adjustConfig.context);
        addString(map, "android_uuid", this.activityStateCopy.uuid);
        addString(map, "gps_adid", this.deviceInfo.playAdId);
        addLong(map, "gps_adid_attempt", this.deviceInfo.playAdIdAttempt);
        addString(map, "gps_adid_src", this.deviceInfo.playAdIdSource);
        addBoolean(map, "tracking_enabled", this.deviceInfo.isTrackingEnabled);
        addString(map, "fire_adid", Util.getFireAdvertisingId(contentResolver));
        addBoolean(map, "fire_tracking_enabled", Util.getFireTrackingEnabled(contentResolver));
        if (!containsPlayIds(map) && !containsFireIds(map)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.reloadNonPlayIds(this.adjustConfig.context);
            addString(map, "android_id", this.deviceInfo.androidId);
            addString(map, "mac_md5", this.deviceInfo.macShortMd5);
            addString(map, "mac_sha1", this.deviceInfo.macSha1);
        }
        addString(map, "api_level", this.deviceInfo.apiLevel);
        addString(map, "app_secret", this.adjustConfig.appSecret);
        addString(map, "app_token", this.adjustConfig.appToken);
        addString(map, "app_version", this.deviceInfo.appVersion);
        Boolean bool = Boolean.TRUE;
        addBoolean(map, "attribution_deeplink", bool);
        addDateInMilliseconds(map, "created_at", this.createdAt);
        addBoolean(map, "device_known", this.adjustConfig.deviceKnown);
        addBoolean(map, "needs_cost", this.adjustConfig.needsCost);
        addString(map, "device_name", this.deviceInfo.deviceName);
        addString(map, "device_type", this.deviceInfo.deviceType);
        addString(map, "environment", this.adjustConfig.environment);
        addBoolean(map, "event_buffering_enabled", Boolean.valueOf(this.adjustConfig.eventBufferingEnabled));
        addString(map, "external_device_id", this.adjustConfig.externalDeviceId);
        addString(map, "initiated_by", str);
        addBoolean(map, "needs_response_details", bool);
        addString(map, "os_name", this.deviceInfo.osName);
        addString(map, "os_version", this.deviceInfo.osVersion);
        addString(map, "package_name", this.deviceInfo.packageName);
        addString(map, "push_token", this.activityStateCopy.pushToken);
        addString(map, "secret_id", this.adjustConfig.secretId);
        checkDeviceIds(map);
        return map;
    }

    private Map<String, String> getClickParameters(String str) {
        ContentResolver contentResolver = this.adjustConfig.context.getContentResolver();
        HashMap map = new HashMap();
        Map<String, String> imeiParameters = Reflection.getImeiParameters(this.adjustConfig.context, logger);
        if (imeiParameters != null) {
            map.putAll(imeiParameters);
        }
        Map<String, String> oaidParameters = Reflection.getOaidParameters(this.adjustConfig.context, logger);
        if (oaidParameters != null) {
            map.putAll(oaidParameters);
        }
        this.deviceInfo.reloadPlayIds(this.adjustConfig.context);
        addString(map, "android_uuid", this.activityStateCopy.uuid);
        addString(map, "gps_adid", this.deviceInfo.playAdId);
        addLong(map, "gps_adid_attempt", this.deviceInfo.playAdIdAttempt);
        addString(map, "gps_adid_src", this.deviceInfo.playAdIdSource);
        addBoolean(map, "tracking_enabled", this.deviceInfo.isTrackingEnabled);
        addString(map, "fire_adid", Util.getFireAdvertisingId(contentResolver));
        addBoolean(map, "fire_tracking_enabled", Util.getFireTrackingEnabled(contentResolver));
        if (!containsPlayIds(map) && !containsFireIds(map)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.reloadNonPlayIds(this.adjustConfig.context);
            addString(map, "android_id", this.deviceInfo.androidId);
            addString(map, "mac_md5", this.deviceInfo.macShortMd5);
            addString(map, "mac_sha1", this.deviceInfo.macSha1);
        }
        AdjustAttribution adjustAttribution = this.attribution;
        if (adjustAttribution != null) {
            addString(map, "tracker", adjustAttribution.trackerName);
            addString(map, "campaign", this.attribution.campaign);
            addString(map, "adgroup", this.attribution.adgroup);
            addString(map, "creative", this.attribution.creative);
        }
        addString(map, "api_level", this.deviceInfo.apiLevel);
        addString(map, "app_secret", this.adjustConfig.appSecret);
        addString(map, "app_token", this.adjustConfig.appToken);
        addString(map, "app_version", this.deviceInfo.appVersion);
        Boolean bool = Boolean.TRUE;
        addBoolean(map, "attribution_deeplink", bool);
        addMapJson(map, Constants.CALLBACK_PARAMETERS, this.sessionParameters.callbackParameters);
        addDateInMilliseconds(map, "click_time", this.clickTimeInMilliseconds);
        addDateInSeconds(map, "click_time", this.clickTimeInSeconds);
        addDateInSeconds(map, "click_time_server", this.clickTimeServerInSeconds);
        addLong(map, "connectivity_type", Util.getConnectivityType(this.adjustConfig.context));
        addString(map, UserDataStore.COUNTRY, this.deviceInfo.country);
        addString(map, "cpu_type", this.deviceInfo.abi);
        addDateInMilliseconds(map, "created_at", this.createdAt);
        addString(map, Constants.DEEPLINK, this.deeplink);
        addBoolean(map, "device_known", this.adjustConfig.deviceKnown);
        addBoolean(map, "needs_cost", this.adjustConfig.needsCost);
        addString(map, "device_manufacturer", this.deviceInfo.deviceManufacturer);
        addString(map, "device_name", this.deviceInfo.deviceName);
        addString(map, "device_type", this.deviceInfo.deviceType);
        addString(map, "display_height", this.deviceInfo.displayHeight);
        addString(map, "display_width", this.deviceInfo.displayWidth);
        addString(map, "environment", this.adjustConfig.environment);
        addBoolean(map, "event_buffering_enabled", Boolean.valueOf(this.adjustConfig.eventBufferingEnabled));
        addString(map, "external_device_id", this.adjustConfig.externalDeviceId);
        addString(map, "fb_id", this.deviceInfo.fbAttributionId);
        addBoolean(map, "google_play_instant", this.googlePlayInstant);
        addString(map, "hardware_name", this.deviceInfo.hardwareName);
        addDateInSeconds(map, "install_begin_time", this.installBeginTimeInSeconds);
        addDateInSeconds(map, "install_begin_time_server", this.installBeginTimeServerInSeconds);
        addString(map, "install_version", this.installVersion);
        addString(map, "installed_at", this.deviceInfo.appInstallTime);
        addString(map, "language", this.deviceInfo.language);
        addDuration(map, "last_interval", this.activityStateCopy.lastInterval);
        addString(map, "mcc", Util.getMcc(this.adjustConfig.context));
        addString(map, "mnc", Util.getMnc(this.adjustConfig.context));
        addBoolean(map, "needs_response_details", bool);
        addLong(map, "network_type", Util.getNetworkType(this.adjustConfig.context));
        addString(map, "os_build", this.deviceInfo.buildName);
        addString(map, "os_name", this.deviceInfo.osName);
        addString(map, "os_version", this.deviceInfo.osVersion);
        addString(map, "package_name", this.deviceInfo.packageName);
        addMapJson(map, NativeProtocol.WEB_DIALOG_PARAMS, this.extraParameters);
        addMapJson(map, Constants.PARTNER_PARAMETERS, this.sessionParameters.partnerParameters);
        addString(map, "push_token", this.activityStateCopy.pushToken);
        addString(map, "raw_referrer", this.rawReferrer);
        addString(map, Constants.REFERRER, this.referrer);
        addString(map, "referrer_api", this.referrerApi);
        addString(map, Constants.REFTAG, this.reftag);
        addString(map, "screen_density", this.deviceInfo.screenDensity);
        addString(map, "screen_format", this.deviceInfo.screenFormat);
        addString(map, "screen_size", this.deviceInfo.screenSize);
        addString(map, "secret_id", this.adjustConfig.secretId);
        addLong(map, "session_count", this.activityStateCopy.sessionCount);
        addDuration(map, "session_length", this.activityStateCopy.sessionLength);
        addString(map, "source", str);
        addLong(map, "subsession_count", this.activityStateCopy.subsessionCount);
        addDuration(map, "time_spent", this.activityStateCopy.timeSpent);
        addString(map, "updated_at", this.deviceInfo.appUpdateTime);
        addString(map, "payload", this.preinstallPayload);
        addString(map, "found_location", this.preinstallLocation);
        checkDeviceIds(map);
        return map;
    }

    private ActivityPackage getDefaultActivityPackage(ActivityKind activityKind) {
        ActivityPackage activityPackage = new ActivityPackage(activityKind);
        activityPackage.setClientSdk(this.deviceInfo.clientSdk);
        return activityPackage;
    }

    private Map<String, String> getDisableThirdPartySharingParameters() {
        ContentResolver contentResolver = this.adjustConfig.context.getContentResolver();
        HashMap map = new HashMap();
        Map<String, String> imeiParameters = Reflection.getImeiParameters(this.adjustConfig.context, logger);
        if (imeiParameters != null) {
            map.putAll(imeiParameters);
        }
        Map<String, String> oaidParameters = Reflection.getOaidParameters(this.adjustConfig.context, logger);
        if (oaidParameters != null) {
            map.putAll(oaidParameters);
        }
        this.deviceInfo.reloadPlayIds(this.adjustConfig.context);
        addString(map, "android_uuid", this.activityStateCopy.uuid);
        addString(map, "gps_adid", this.deviceInfo.playAdId);
        addLong(map, "gps_adid_attempt", this.deviceInfo.playAdIdAttempt);
        addString(map, "gps_adid_src", this.deviceInfo.playAdIdSource);
        addBoolean(map, "tracking_enabled", this.deviceInfo.isTrackingEnabled);
        addString(map, "fire_adid", Util.getFireAdvertisingId(contentResolver));
        addBoolean(map, "fire_tracking_enabled", Util.getFireTrackingEnabled(contentResolver));
        if (!containsPlayIds(map) && !containsFireIds(map)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.reloadNonPlayIds(this.adjustConfig.context);
            addString(map, "android_id", this.deviceInfo.androidId);
            addString(map, "mac_md5", this.deviceInfo.macShortMd5);
            addString(map, "mac_sha1", this.deviceInfo.macSha1);
        }
        addString(map, "api_level", this.deviceInfo.apiLevel);
        addString(map, "app_secret", this.adjustConfig.appSecret);
        addString(map, "app_token", this.adjustConfig.appToken);
        addString(map, "app_version", this.deviceInfo.appVersion);
        Boolean bool = Boolean.TRUE;
        addBoolean(map, "attribution_deeplink", bool);
        addDateInMilliseconds(map, "created_at", this.createdAt);
        addBoolean(map, "device_known", this.adjustConfig.deviceKnown);
        addBoolean(map, "needs_cost", this.adjustConfig.needsCost);
        addString(map, "device_name", this.deviceInfo.deviceName);
        addString(map, "device_type", this.deviceInfo.deviceType);
        addString(map, "environment", this.adjustConfig.environment);
        addBoolean(map, "event_buffering_enabled", Boolean.valueOf(this.adjustConfig.eventBufferingEnabled));
        addString(map, "external_device_id", this.adjustConfig.externalDeviceId);
        addBoolean(map, "needs_response_details", bool);
        addString(map, "os_name", this.deviceInfo.osName);
        addString(map, "os_version", this.deviceInfo.osVersion);
        addString(map, "package_name", this.deviceInfo.packageName);
        addString(map, "push_token", this.activityStateCopy.pushToken);
        addString(map, "secret_id", this.adjustConfig.secretId);
        checkDeviceIds(map);
        return map;
    }

    private String getEventSuffix(AdjustEvent adjustEvent) {
        Double d2 = adjustEvent.revenue;
        return d2 == null ? Util.formatString("'%s'", adjustEvent.eventToken) : Util.formatString("(%.5f %s, '%s')", d2, adjustEvent.currency, adjustEvent.eventToken);
    }

    private Map<String, String> getGdprParameters() {
        ContentResolver contentResolver = this.adjustConfig.context.getContentResolver();
        HashMap map = new HashMap();
        Map<String, String> imeiParameters = Reflection.getImeiParameters(this.adjustConfig.context, logger);
        if (imeiParameters != null) {
            map.putAll(imeiParameters);
        }
        Map<String, String> oaidParameters = Reflection.getOaidParameters(this.adjustConfig.context, logger);
        if (oaidParameters != null) {
            map.putAll(oaidParameters);
        }
        this.deviceInfo.reloadPlayIds(this.adjustConfig.context);
        addString(map, "android_uuid", this.activityStateCopy.uuid);
        addString(map, "gps_adid", this.deviceInfo.playAdId);
        addLong(map, "gps_adid_attempt", this.deviceInfo.playAdIdAttempt);
        addString(map, "gps_adid_src", this.deviceInfo.playAdIdSource);
        addBoolean(map, "tracking_enabled", this.deviceInfo.isTrackingEnabled);
        addString(map, "fire_adid", Util.getFireAdvertisingId(contentResolver));
        addBoolean(map, "fire_tracking_enabled", Util.getFireTrackingEnabled(contentResolver));
        if (!containsPlayIds(map) && !containsFireIds(map)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.reloadNonPlayIds(this.adjustConfig.context);
            addString(map, "android_id", this.deviceInfo.androidId);
            addString(map, "mac_md5", this.deviceInfo.macShortMd5);
            addString(map, "mac_sha1", this.deviceInfo.macSha1);
        }
        addString(map, "api_level", this.deviceInfo.apiLevel);
        addString(map, "app_secret", this.adjustConfig.appSecret);
        addString(map, "app_token", this.adjustConfig.appToken);
        addString(map, "app_version", this.deviceInfo.appVersion);
        Boolean bool = Boolean.TRUE;
        addBoolean(map, "attribution_deeplink", bool);
        addDateInMilliseconds(map, "created_at", this.createdAt);
        addBoolean(map, "device_known", this.adjustConfig.deviceKnown);
        addBoolean(map, "needs_cost", this.adjustConfig.needsCost);
        addString(map, "device_name", this.deviceInfo.deviceName);
        addString(map, "device_type", this.deviceInfo.deviceType);
        addString(map, "environment", this.adjustConfig.environment);
        addBoolean(map, "event_buffering_enabled", Boolean.valueOf(this.adjustConfig.eventBufferingEnabled));
        addString(map, "external_device_id", this.adjustConfig.externalDeviceId);
        addBoolean(map, "needs_response_details", bool);
        addString(map, "os_name", this.deviceInfo.osName);
        addString(map, "os_version", this.deviceInfo.osVersion);
        addString(map, "package_name", this.deviceInfo.packageName);
        addString(map, "push_token", this.activityStateCopy.pushToken);
        addString(map, "secret_id", this.adjustConfig.secretId);
        checkDeviceIds(map);
        return map;
    }

    private Map<String, String> getInfoParameters(String str) {
        ContentResolver contentResolver = this.adjustConfig.context.getContentResolver();
        HashMap map = new HashMap();
        Map<String, String> imeiParameters = Reflection.getImeiParameters(this.adjustConfig.context, logger);
        if (imeiParameters != null) {
            map.putAll(imeiParameters);
        }
        Map<String, String> oaidParameters = Reflection.getOaidParameters(this.adjustConfig.context, logger);
        if (oaidParameters != null) {
            map.putAll(oaidParameters);
        }
        this.deviceInfo.reloadPlayIds(this.adjustConfig.context);
        addString(map, "android_uuid", this.activityStateCopy.uuid);
        addString(map, "gps_adid", this.deviceInfo.playAdId);
        addLong(map, "gps_adid_attempt", this.deviceInfo.playAdIdAttempt);
        addString(map, "gps_adid_src", this.deviceInfo.playAdIdSource);
        addBoolean(map, "tracking_enabled", this.deviceInfo.isTrackingEnabled);
        addString(map, "fire_adid", Util.getFireAdvertisingId(contentResolver));
        addBoolean(map, "fire_tracking_enabled", Util.getFireTrackingEnabled(contentResolver));
        if (!containsPlayIds(map) && !containsFireIds(map)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.reloadNonPlayIds(this.adjustConfig.context);
            addString(map, "android_id", this.deviceInfo.androidId);
            addString(map, "mac_md5", this.deviceInfo.macShortMd5);
            addString(map, "mac_sha1", this.deviceInfo.macSha1);
        }
        addString(map, "app_secret", this.adjustConfig.appSecret);
        addString(map, "app_token", this.adjustConfig.appToken);
        Boolean bool = Boolean.TRUE;
        addBoolean(map, "attribution_deeplink", bool);
        addDateInMilliseconds(map, "created_at", this.createdAt);
        addBoolean(map, "device_known", this.adjustConfig.deviceKnown);
        addBoolean(map, "needs_cost", this.adjustConfig.needsCost);
        addString(map, "environment", this.adjustConfig.environment);
        addBoolean(map, "event_buffering_enabled", Boolean.valueOf(this.adjustConfig.eventBufferingEnabled));
        addString(map, "external_device_id", this.adjustConfig.externalDeviceId);
        addBoolean(map, "needs_response_details", bool);
        addString(map, "push_token", this.activityStateCopy.pushToken);
        addString(map, "secret_id", this.adjustConfig.secretId);
        addString(map, "source", str);
        checkDeviceIds(map);
        return map;
    }

    private Map<String, String> getMeasurementConsentParameters(boolean z2) {
        ContentResolver contentResolver = this.adjustConfig.context.getContentResolver();
        HashMap map = new HashMap();
        Map<String, String> imeiParameters = Reflection.getImeiParameters(this.adjustConfig.context, logger);
        if (imeiParameters != null) {
            map.putAll(imeiParameters);
        }
        Map<String, String> oaidParameters = Reflection.getOaidParameters(this.adjustConfig.context, logger);
        if (oaidParameters != null) {
            map.putAll(oaidParameters);
        }
        addString(map, "measurement", z2 ? "enable" : "disable");
        this.deviceInfo.reloadPlayIds(this.adjustConfig.context);
        addString(map, "android_uuid", this.activityStateCopy.uuid);
        addString(map, "gps_adid", this.deviceInfo.playAdId);
        addLong(map, "gps_adid_attempt", this.deviceInfo.playAdIdAttempt);
        addString(map, "gps_adid_src", this.deviceInfo.playAdIdSource);
        addBoolean(map, "tracking_enabled", this.deviceInfo.isTrackingEnabled);
        addString(map, "fire_adid", Util.getFireAdvertisingId(contentResolver));
        addBoolean(map, "fire_tracking_enabled", Util.getFireTrackingEnabled(contentResolver));
        if (!containsPlayIds(map) && !containsFireIds(map)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.reloadNonPlayIds(this.adjustConfig.context);
            addString(map, "android_id", this.deviceInfo.androidId);
            addString(map, "mac_md5", this.deviceInfo.macShortMd5);
            addString(map, "mac_sha1", this.deviceInfo.macSha1);
        }
        addString(map, "api_level", this.deviceInfo.apiLevel);
        addString(map, "app_secret", this.adjustConfig.appSecret);
        addString(map, "app_token", this.adjustConfig.appToken);
        addString(map, "app_version", this.deviceInfo.appVersion);
        Boolean bool = Boolean.TRUE;
        addBoolean(map, "attribution_deeplink", bool);
        addDateInMilliseconds(map, "created_at", this.createdAt);
        addBoolean(map, "device_known", this.adjustConfig.deviceKnown);
        addString(map, "device_name", this.deviceInfo.deviceName);
        addString(map, "device_type", this.deviceInfo.deviceType);
        addString(map, "environment", this.adjustConfig.environment);
        addBoolean(map, "event_buffering_enabled", Boolean.valueOf(this.adjustConfig.eventBufferingEnabled));
        addString(map, "external_device_id", this.adjustConfig.externalDeviceId);
        addBoolean(map, "needs_response_details", bool);
        addString(map, "os_name", this.deviceInfo.osName);
        addString(map, "os_version", this.deviceInfo.osVersion);
        addString(map, "package_name", this.deviceInfo.packageName);
        addString(map, "push_token", this.activityStateCopy.pushToken);
        addString(map, "secret_id", this.adjustConfig.secretId);
        checkDeviceIds(map);
        return map;
    }

    private Map<String, String> getSessionParameters(boolean z2) {
        ContentResolver contentResolver = this.adjustConfig.context.getContentResolver();
        HashMap map = new HashMap();
        Map<String, String> imeiParameters = Reflection.getImeiParameters(this.adjustConfig.context, logger);
        if (imeiParameters != null) {
            map.putAll(imeiParameters);
        }
        Map<String, String> oaidParameters = Reflection.getOaidParameters(this.adjustConfig.context, logger);
        if (oaidParameters != null) {
            map.putAll(oaidParameters);
        }
        if (!z2) {
            addMapJson(map, Constants.CALLBACK_PARAMETERS, this.sessionParameters.callbackParameters);
            addMapJson(map, Constants.PARTNER_PARAMETERS, this.sessionParameters.partnerParameters);
        }
        this.deviceInfo.reloadPlayIds(this.adjustConfig.context);
        addString(map, "android_uuid", this.activityStateCopy.uuid);
        addString(map, "gps_adid", this.deviceInfo.playAdId);
        addLong(map, "gps_adid_attempt", this.deviceInfo.playAdIdAttempt);
        addString(map, "gps_adid_src", this.deviceInfo.playAdIdSource);
        addBoolean(map, "tracking_enabled", this.deviceInfo.isTrackingEnabled);
        addString(map, "fire_adid", Util.getFireAdvertisingId(contentResolver));
        addBoolean(map, "fire_tracking_enabled", Util.getFireTrackingEnabled(contentResolver));
        if (!containsPlayIds(map) && !containsFireIds(map)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.reloadNonPlayIds(this.adjustConfig.context);
            addString(map, "android_id", this.deviceInfo.androidId);
            addString(map, "mac_md5", this.deviceInfo.macShortMd5);
            addString(map, "mac_sha1", this.deviceInfo.macSha1);
        }
        addString(map, "api_level", this.deviceInfo.apiLevel);
        addString(map, "app_secret", this.adjustConfig.appSecret);
        addString(map, "app_token", this.adjustConfig.appToken);
        addString(map, "app_version", this.deviceInfo.appVersion);
        Boolean bool = Boolean.TRUE;
        addBoolean(map, "attribution_deeplink", bool);
        addLong(map, "connectivity_type", Util.getConnectivityType(this.adjustConfig.context));
        addString(map, UserDataStore.COUNTRY, this.deviceInfo.country);
        addString(map, "cpu_type", this.deviceInfo.abi);
        addDateInMilliseconds(map, "created_at", this.createdAt);
        addString(map, "default_tracker", this.adjustConfig.defaultTracker);
        addBoolean(map, "device_known", this.adjustConfig.deviceKnown);
        addBoolean(map, "needs_cost", this.adjustConfig.needsCost);
        addString(map, "device_manufacturer", this.deviceInfo.deviceManufacturer);
        addString(map, "device_name", this.deviceInfo.deviceName);
        addString(map, "device_type", this.deviceInfo.deviceType);
        addString(map, "display_height", this.deviceInfo.displayHeight);
        addString(map, "display_width", this.deviceInfo.displayWidth);
        addString(map, "environment", this.adjustConfig.environment);
        addBoolean(map, "event_buffering_enabled", Boolean.valueOf(this.adjustConfig.eventBufferingEnabled));
        addString(map, "external_device_id", this.adjustConfig.externalDeviceId);
        addString(map, "fb_id", this.deviceInfo.fbAttributionId);
        addString(map, "hardware_name", this.deviceInfo.hardwareName);
        addString(map, "installed_at", this.deviceInfo.appInstallTime);
        addString(map, "language", this.deviceInfo.language);
        addDuration(map, "last_interval", this.activityStateCopy.lastInterval);
        addString(map, "mcc", Util.getMcc(this.adjustConfig.context));
        addString(map, "mnc", Util.getMnc(this.adjustConfig.context));
        addBoolean(map, "needs_response_details", bool);
        addLong(map, "network_type", Util.getNetworkType(this.adjustConfig.context));
        addString(map, "os_build", this.deviceInfo.buildName);
        addString(map, "os_name", this.deviceInfo.osName);
        addString(map, "os_version", this.deviceInfo.osVersion);
        addString(map, "package_name", this.deviceInfo.packageName);
        addString(map, "push_token", this.activityStateCopy.pushToken);
        addString(map, "screen_density", this.deviceInfo.screenDensity);
        addString(map, "screen_format", this.deviceInfo.screenFormat);
        addString(map, "screen_size", this.deviceInfo.screenSize);
        addString(map, "secret_id", this.adjustConfig.secretId);
        addLong(map, "session_count", this.activityStateCopy.sessionCount);
        addDuration(map, "session_length", this.activityStateCopy.sessionLength);
        addLong(map, "subsession_count", this.activityStateCopy.subsessionCount);
        addDuration(map, "time_spent", this.activityStateCopy.timeSpent);
        addString(map, "updated_at", this.deviceInfo.appUpdateTime);
        checkDeviceIds(map);
        return map;
    }

    private Map<String, String> getSubscriptionParameters(AdjustPlayStoreSubscription adjustPlayStoreSubscription, boolean z2) {
        ContentResolver contentResolver = this.adjustConfig.context.getContentResolver();
        HashMap map = new HashMap();
        Map<String, String> imeiParameters = Reflection.getImeiParameters(this.adjustConfig.context, logger);
        if (imeiParameters != null) {
            map.putAll(imeiParameters);
        }
        Map<String, String> oaidParameters = Reflection.getOaidParameters(this.adjustConfig.context, logger);
        if (oaidParameters != null) {
            map.putAll(oaidParameters);
        }
        this.deviceInfo.reloadPlayIds(this.adjustConfig.context);
        addString(map, "android_uuid", this.activityStateCopy.uuid);
        addString(map, "gps_adid", this.deviceInfo.playAdId);
        addLong(map, "gps_adid_attempt", this.deviceInfo.playAdIdAttempt);
        addString(map, "gps_adid_src", this.deviceInfo.playAdIdSource);
        addBoolean(map, "tracking_enabled", this.deviceInfo.isTrackingEnabled);
        addString(map, "fire_adid", Util.getFireAdvertisingId(contentResolver));
        addBoolean(map, "fire_tracking_enabled", Util.getFireTrackingEnabled(contentResolver));
        if (!containsPlayIds(map) && !containsFireIds(map)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.reloadNonPlayIds(this.adjustConfig.context);
            addString(map, "android_id", this.deviceInfo.androidId);
            addString(map, "mac_md5", this.deviceInfo.macShortMd5);
            addString(map, "mac_sha1", this.deviceInfo.macSha1);
        }
        if (!z2) {
            addMapJson(map, Constants.CALLBACK_PARAMETERS, Util.mergeParameters(this.sessionParameters.callbackParameters, adjustPlayStoreSubscription.getCallbackParameters(), "Callback"));
            addMapJson(map, Constants.PARTNER_PARAMETERS, Util.mergeParameters(this.sessionParameters.partnerParameters, adjustPlayStoreSubscription.getPartnerParameters(), "Partner"));
        }
        addString(map, "api_level", this.deviceInfo.apiLevel);
        addString(map, "app_secret", this.adjustConfig.appSecret);
        addString(map, "app_token", this.adjustConfig.appToken);
        addString(map, "app_version", this.deviceInfo.appVersion);
        Boolean bool = Boolean.TRUE;
        addBoolean(map, "attribution_deeplink", bool);
        addLong(map, "connectivity_type", Util.getConnectivityType(this.adjustConfig.context));
        addString(map, UserDataStore.COUNTRY, this.deviceInfo.country);
        addString(map, "cpu_type", this.deviceInfo.abi);
        addDateInMilliseconds(map, "created_at", this.createdAt);
        addString(map, "default_tracker", this.adjustConfig.defaultTracker);
        addBoolean(map, "device_known", this.adjustConfig.deviceKnown);
        addBoolean(map, "needs_cost", this.adjustConfig.needsCost);
        addString(map, "device_manufacturer", this.deviceInfo.deviceManufacturer);
        addString(map, "device_name", this.deviceInfo.deviceName);
        addString(map, "device_type", this.deviceInfo.deviceType);
        addString(map, "display_height", this.deviceInfo.displayHeight);
        addString(map, "display_width", this.deviceInfo.displayWidth);
        addString(map, "environment", this.adjustConfig.environment);
        addBoolean(map, "event_buffering_enabled", Boolean.valueOf(this.adjustConfig.eventBufferingEnabled));
        addString(map, "external_device_id", this.adjustConfig.externalDeviceId);
        addString(map, "fb_id", this.deviceInfo.fbAttributionId);
        addString(map, "hardware_name", this.deviceInfo.hardwareName);
        addString(map, "installed_at", this.deviceInfo.appInstallTime);
        addString(map, "language", this.deviceInfo.language);
        addDuration(map, "last_interval", this.activityStateCopy.lastInterval);
        addString(map, "mcc", Util.getMcc(this.adjustConfig.context));
        addString(map, "mnc", Util.getMnc(this.adjustConfig.context));
        addBoolean(map, "needs_response_details", bool);
        addLong(map, "network_type", Util.getNetworkType(this.adjustConfig.context));
        addString(map, "os_build", this.deviceInfo.buildName);
        addString(map, "os_name", this.deviceInfo.osName);
        addString(map, "os_version", this.deviceInfo.osVersion);
        addString(map, "package_name", this.deviceInfo.packageName);
        addString(map, "push_token", this.activityStateCopy.pushToken);
        addString(map, "screen_density", this.deviceInfo.screenDensity);
        addString(map, "screen_format", this.deviceInfo.screenFormat);
        addString(map, "screen_size", this.deviceInfo.screenSize);
        addString(map, "secret_id", this.adjustConfig.secretId);
        addLong(map, "session_count", this.activityStateCopy.sessionCount);
        addDuration(map, "session_length", this.activityStateCopy.sessionLength);
        addLong(map, "subsession_count", this.activityStateCopy.subsessionCount);
        addDuration(map, "time_spent", this.activityStateCopy.timeSpent);
        addString(map, "updated_at", this.deviceInfo.appUpdateTime);
        addString(map, "billing_store", adjustPlayStoreSubscription.getBillingStore());
        addString(map, DataUtil.ORDER_LIST_COLUMN.CURRENCY, adjustPlayStoreSubscription.getCurrency());
        addString(map, "product_id", adjustPlayStoreSubscription.getSku());
        addString(map, "purchase_token", adjustPlayStoreSubscription.getPurchaseToken());
        addString(map, DataUtil.ORDER_COLUMN.ORDER_RECEIPT, adjustPlayStoreSubscription.getSignature());
        addLong(map, "revenue", adjustPlayStoreSubscription.getPrice());
        addDateInMilliseconds(map, "transaction_date", adjustPlayStoreSubscription.getPurchaseTime());
        addString(map, "transaction_id", adjustPlayStoreSubscription.getOrderId());
        checkDeviceIds(map);
        return map;
    }

    private Map<String, String> getThirdPartySharingParameters(AdjustThirdPartySharing adjustThirdPartySharing) {
        ContentResolver contentResolver = this.adjustConfig.context.getContentResolver();
        HashMap map = new HashMap();
        Map<String, String> imeiParameters = Reflection.getImeiParameters(this.adjustConfig.context, logger);
        if (imeiParameters != null) {
            map.putAll(imeiParameters);
        }
        Map<String, String> oaidParameters = Reflection.getOaidParameters(this.adjustConfig.context, logger);
        if (oaidParameters != null) {
            map.putAll(oaidParameters);
        }
        Boolean bool = adjustThirdPartySharing.isEnabled;
        if (bool != null) {
            addString(map, "sharing", bool.booleanValue() ? "enable" : "disable");
        }
        addMapJson(map, "granular_third_party_sharing_options", adjustThirdPartySharing.granularOptions);
        this.deviceInfo.reloadPlayIds(this.adjustConfig.context);
        addString(map, "android_uuid", this.activityStateCopy.uuid);
        addString(map, "gps_adid", this.deviceInfo.playAdId);
        addLong(map, "gps_adid_attempt", this.deviceInfo.playAdIdAttempt);
        addString(map, "gps_adid_src", this.deviceInfo.playAdIdSource);
        addBoolean(map, "tracking_enabled", this.deviceInfo.isTrackingEnabled);
        addString(map, "fire_adid", Util.getFireAdvertisingId(contentResolver));
        addBoolean(map, "fire_tracking_enabled", Util.getFireTrackingEnabled(contentResolver));
        if (!containsPlayIds(map) && !containsFireIds(map)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.reloadNonPlayIds(this.adjustConfig.context);
            addString(map, "android_id", this.deviceInfo.androidId);
            addString(map, "mac_md5", this.deviceInfo.macShortMd5);
            addString(map, "mac_sha1", this.deviceInfo.macSha1);
        }
        addString(map, "api_level", this.deviceInfo.apiLevel);
        addString(map, "app_secret", this.adjustConfig.appSecret);
        addString(map, "app_token", this.adjustConfig.appToken);
        addString(map, "app_version", this.deviceInfo.appVersion);
        Boolean bool2 = Boolean.TRUE;
        addBoolean(map, "attribution_deeplink", bool2);
        addDateInMilliseconds(map, "created_at", this.createdAt);
        addBoolean(map, "device_known", this.adjustConfig.deviceKnown);
        addString(map, "device_name", this.deviceInfo.deviceName);
        addString(map, "device_type", this.deviceInfo.deviceType);
        addString(map, "environment", this.adjustConfig.environment);
        addBoolean(map, "event_buffering_enabled", Boolean.valueOf(this.adjustConfig.eventBufferingEnabled));
        addString(map, "external_device_id", this.adjustConfig.externalDeviceId);
        addBoolean(map, "needs_response_details", bool2);
        addString(map, "os_name", this.deviceInfo.osName);
        addString(map, "os_version", this.deviceInfo.osVersion);
        addString(map, "package_name", this.deviceInfo.packageName);
        addString(map, "push_token", this.activityStateCopy.pushToken);
        addString(map, "secret_id", this.adjustConfig.secretId);
        checkDeviceIds(map);
        return map;
    }

    ActivityPackage buildAdRevenuePackage(String str, JSONObject jSONObject) {
        Map<String, String> adRevenueParameters = getAdRevenueParameters(str, jSONObject);
        ActivityKind activityKind = ActivityKind.AD_REVENUE;
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(activityKind);
        defaultActivityPackage.setPath("/ad_revenue");
        defaultActivityPackage.setSuffix("");
        String string = activityKind.toString();
        String clientSdk = defaultActivityPackage.getClientSdk();
        AdjustConfig adjustConfig = this.adjustConfig;
        AdjustSigner.sign(adRevenueParameters, string, clientSdk, adjustConfig.context, adjustConfig.logger);
        defaultActivityPackage.setParameters(adRevenueParameters);
        return defaultActivityPackage;
    }

    ActivityPackage buildAttributionPackage(String str) {
        Map<String, String> attributionParameters = getAttributionParameters(str);
        ActivityKind activityKind = ActivityKind.ATTRIBUTION;
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(activityKind);
        defaultActivityPackage.setPath("attribution");
        defaultActivityPackage.setSuffix("");
        String string = activityKind.toString();
        String clientSdk = defaultActivityPackage.getClientSdk();
        AdjustConfig adjustConfig = this.adjustConfig;
        AdjustSigner.sign(attributionParameters, string, clientSdk, adjustConfig.context, adjustConfig.logger);
        defaultActivityPackage.setParameters(attributionParameters);
        return defaultActivityPackage;
    }

    ActivityPackage buildClickPackage(String str) {
        Map<String, String> clickParameters = getClickParameters(str);
        ActivityKind activityKind = ActivityKind.CLICK;
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(activityKind);
        defaultActivityPackage.setPath("/sdk_click");
        defaultActivityPackage.setSuffix("");
        defaultActivityPackage.setClickTimeInMilliseconds(this.clickTimeInMilliseconds);
        defaultActivityPackage.setClickTimeInSeconds(this.clickTimeInSeconds);
        defaultActivityPackage.setInstallBeginTimeInSeconds(this.installBeginTimeInSeconds);
        defaultActivityPackage.setClickTimeServerInSeconds(this.clickTimeServerInSeconds);
        defaultActivityPackage.setInstallBeginTimeServerInSeconds(this.installBeginTimeServerInSeconds);
        defaultActivityPackage.setInstallVersion(this.installVersion);
        defaultActivityPackage.setGooglePlayInstant(this.googlePlayInstant);
        String string = activityKind.toString();
        String clientSdk = defaultActivityPackage.getClientSdk();
        AdjustConfig adjustConfig = this.adjustConfig;
        AdjustSigner.sign(clickParameters, string, clientSdk, adjustConfig.context, adjustConfig.logger);
        defaultActivityPackage.setParameters(clickParameters);
        return defaultActivityPackage;
    }

    ActivityPackage buildDisableThirdPartySharingPackage() {
        Map<String, String> disableThirdPartySharingParameters = getDisableThirdPartySharingParameters();
        ActivityKind activityKind = ActivityKind.DISABLE_THIRD_PARTY_SHARING;
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(activityKind);
        defaultActivityPackage.setPath("/disable_third_party_sharing");
        defaultActivityPackage.setSuffix("");
        String string = activityKind.toString();
        String clientSdk = defaultActivityPackage.getClientSdk();
        AdjustConfig adjustConfig = this.adjustConfig;
        AdjustSigner.sign(disableThirdPartySharingParameters, string, clientSdk, adjustConfig.context, adjustConfig.logger);
        defaultActivityPackage.setParameters(disableThirdPartySharingParameters);
        return defaultActivityPackage;
    }

    ActivityPackage buildEventPackage(AdjustEvent adjustEvent, boolean z2) {
        Map<String, String> eventParameters = getEventParameters(adjustEvent, z2);
        ActivityKind activityKind = ActivityKind.EVENT;
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(activityKind);
        defaultActivityPackage.setPath("/event");
        defaultActivityPackage.setSuffix(getEventSuffix(adjustEvent));
        String string = activityKind.toString();
        String clientSdk = defaultActivityPackage.getClientSdk();
        AdjustConfig adjustConfig = this.adjustConfig;
        AdjustSigner.sign(eventParameters, string, clientSdk, adjustConfig.context, adjustConfig.logger);
        defaultActivityPackage.setParameters(eventParameters);
        if (z2) {
            defaultActivityPackage.setCallbackParameters(adjustEvent.callbackParameters);
            defaultActivityPackage.setPartnerParameters(adjustEvent.partnerParameters);
        }
        return defaultActivityPackage;
    }

    ActivityPackage buildGdprPackage() {
        Map<String, String> gdprParameters = getGdprParameters();
        ActivityKind activityKind = ActivityKind.GDPR;
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(activityKind);
        defaultActivityPackage.setPath("/gdpr_forget_device");
        defaultActivityPackage.setSuffix("");
        String string = activityKind.toString();
        String clientSdk = defaultActivityPackage.getClientSdk();
        AdjustConfig adjustConfig = this.adjustConfig;
        AdjustSigner.sign(gdprParameters, string, clientSdk, adjustConfig.context, adjustConfig.logger);
        defaultActivityPackage.setParameters(gdprParameters);
        return defaultActivityPackage;
    }

    ActivityPackage buildInfoPackage(String str) {
        Map<String, String> infoParameters = getInfoParameters(str);
        ActivityKind activityKind = ActivityKind.INFO;
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(activityKind);
        defaultActivityPackage.setPath("/sdk_info");
        defaultActivityPackage.setSuffix("");
        String string = activityKind.toString();
        String clientSdk = defaultActivityPackage.getClientSdk();
        AdjustConfig adjustConfig = this.adjustConfig;
        AdjustSigner.sign(infoParameters, string, clientSdk, adjustConfig.context, adjustConfig.logger);
        defaultActivityPackage.setParameters(infoParameters);
        return defaultActivityPackage;
    }

    ActivityPackage buildMeasurementConsentPackage(boolean z2) {
        Map<String, String> measurementConsentParameters = getMeasurementConsentParameters(z2);
        ActivityKind activityKind = ActivityKind.MEASUREMENT_CONSENT;
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(activityKind);
        defaultActivityPackage.setPath("/measurement_consent");
        defaultActivityPackage.setSuffix("");
        String string = activityKind.toString();
        String clientSdk = defaultActivityPackage.getClientSdk();
        AdjustConfig adjustConfig = this.adjustConfig;
        AdjustSigner.sign(measurementConsentParameters, string, clientSdk, adjustConfig.context, adjustConfig.logger);
        defaultActivityPackage.setParameters(measurementConsentParameters);
        return defaultActivityPackage;
    }

    ActivityPackage buildSessionPackage(boolean z2) {
        Map<String, String> sessionParameters = getSessionParameters(z2);
        ActivityKind activityKind = ActivityKind.SESSION;
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(activityKind);
        defaultActivityPackage.setPath("/session");
        defaultActivityPackage.setSuffix("");
        String string = activityKind.toString();
        String clientSdk = defaultActivityPackage.getClientSdk();
        AdjustConfig adjustConfig = this.adjustConfig;
        AdjustSigner.sign(sessionParameters, string, clientSdk, adjustConfig.context, adjustConfig.logger);
        defaultActivityPackage.setParameters(sessionParameters);
        return defaultActivityPackage;
    }

    ActivityPackage buildSubscriptionPackage(AdjustPlayStoreSubscription adjustPlayStoreSubscription, boolean z2) {
        Map<String, String> subscriptionParameters = getSubscriptionParameters(adjustPlayStoreSubscription, z2);
        ActivityKind activityKind = ActivityKind.SUBSCRIPTION;
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(activityKind);
        defaultActivityPackage.setPath("/v2/purchase");
        defaultActivityPackage.setSuffix("");
        String string = activityKind.toString();
        String clientSdk = defaultActivityPackage.getClientSdk();
        AdjustConfig adjustConfig = this.adjustConfig;
        AdjustSigner.sign(subscriptionParameters, string, clientSdk, adjustConfig.context, adjustConfig.logger);
        defaultActivityPackage.setParameters(subscriptionParameters);
        return defaultActivityPackage;
    }

    ActivityPackage buildThirdPartySharingPackage(AdjustThirdPartySharing adjustThirdPartySharing) {
        Map<String, String> thirdPartySharingParameters = getThirdPartySharingParameters(adjustThirdPartySharing);
        ActivityKind activityKind = ActivityKind.THIRD_PARTY_SHARING;
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(activityKind);
        defaultActivityPackage.setPath("/third_party_sharing");
        defaultActivityPackage.setSuffix("");
        String string = activityKind.toString();
        String clientSdk = defaultActivityPackage.getClientSdk();
        AdjustConfig adjustConfig = this.adjustConfig;
        AdjustSigner.sign(thirdPartySharingParameters, string, clientSdk, adjustConfig.context, adjustConfig.logger);
        defaultActivityPackage.setParameters(thirdPartySharingParameters);
        return defaultActivityPackage;
    }

    public Map<String, String> getEventParameters(AdjustEvent adjustEvent, boolean z2) {
        ContentResolver contentResolver = this.adjustConfig.context.getContentResolver();
        HashMap map = new HashMap();
        Map<String, String> imeiParameters = Reflection.getImeiParameters(this.adjustConfig.context, logger);
        if (imeiParameters != null) {
            map.putAll(imeiParameters);
        }
        Map<String, String> oaidParameters = Reflection.getOaidParameters(this.adjustConfig.context, logger);
        if (oaidParameters != null) {
            map.putAll(oaidParameters);
        }
        if (!z2) {
            addMapJson(map, Constants.CALLBACK_PARAMETERS, Util.mergeParameters(this.sessionParameters.callbackParameters, adjustEvent.callbackParameters, "Callback"));
            addMapJson(map, Constants.PARTNER_PARAMETERS, Util.mergeParameters(this.sessionParameters.partnerParameters, adjustEvent.partnerParameters, "Partner"));
        }
        this.deviceInfo.reloadPlayIds(this.adjustConfig.context);
        addString(map, "android_uuid", this.activityStateCopy.uuid);
        addString(map, "gps_adid", this.deviceInfo.playAdId);
        addLong(map, "gps_adid_attempt", this.deviceInfo.playAdIdAttempt);
        addString(map, "gps_adid_src", this.deviceInfo.playAdIdSource);
        addBoolean(map, "tracking_enabled", this.deviceInfo.isTrackingEnabled);
        addString(map, "fire_adid", Util.getFireAdvertisingId(contentResolver));
        addBoolean(map, "fire_tracking_enabled", Util.getFireTrackingEnabled(contentResolver));
        if (!containsPlayIds(map) && !containsFireIds(map)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.reloadNonPlayIds(this.adjustConfig.context);
            addString(map, "android_id", this.deviceInfo.androidId);
            addString(map, "mac_md5", this.deviceInfo.macShortMd5);
            addString(map, "mac_sha1", this.deviceInfo.macSha1);
        }
        addString(map, "api_level", this.deviceInfo.apiLevel);
        addString(map, "app_secret", this.adjustConfig.appSecret);
        addString(map, "app_token", this.adjustConfig.appToken);
        addString(map, "app_version", this.deviceInfo.appVersion);
        Boolean bool = Boolean.TRUE;
        addBoolean(map, "attribution_deeplink", bool);
        addLong(map, "connectivity_type", Util.getConnectivityType(this.adjustConfig.context));
        addString(map, UserDataStore.COUNTRY, this.deviceInfo.country);
        addString(map, "cpu_type", this.deviceInfo.abi);
        addDateInMilliseconds(map, "created_at", this.createdAt);
        addString(map, DataUtil.ORDER_LIST_COLUMN.CURRENCY, adjustEvent.currency);
        addBoolean(map, "device_known", this.adjustConfig.deviceKnown);
        addBoolean(map, "needs_cost", this.adjustConfig.needsCost);
        addString(map, "device_manufacturer", this.deviceInfo.deviceManufacturer);
        addString(map, "device_name", this.deviceInfo.deviceName);
        addString(map, "device_type", this.deviceInfo.deviceType);
        addString(map, "display_height", this.deviceInfo.displayHeight);
        addString(map, "display_width", this.deviceInfo.displayWidth);
        addString(map, "environment", this.adjustConfig.environment);
        addString(map, "event_callback_id", adjustEvent.callbackId);
        addLong(map, "event_count", this.activityStateCopy.eventCount);
        addBoolean(map, "event_buffering_enabled", Boolean.valueOf(this.adjustConfig.eventBufferingEnabled));
        addString(map, "event_token", adjustEvent.eventToken);
        addString(map, "external_device_id", this.adjustConfig.externalDeviceId);
        addString(map, "fb_id", this.deviceInfo.fbAttributionId);
        addString(map, "hardware_name", this.deviceInfo.hardwareName);
        addString(map, "language", this.deviceInfo.language);
        addString(map, "mcc", Util.getMcc(this.adjustConfig.context));
        addString(map, "mnc", Util.getMnc(this.adjustConfig.context));
        addBoolean(map, "needs_response_details", bool);
        addLong(map, "network_type", Util.getNetworkType(this.adjustConfig.context));
        addString(map, "os_build", this.deviceInfo.buildName);
        addString(map, "os_name", this.deviceInfo.osName);
        addString(map, "os_version", this.deviceInfo.osVersion);
        addString(map, "package_name", this.deviceInfo.packageName);
        addString(map, "push_token", this.activityStateCopy.pushToken);
        addDouble(map, "revenue", adjustEvent.revenue);
        addString(map, "screen_density", this.deviceInfo.screenDensity);
        addString(map, "screen_format", this.deviceInfo.screenFormat);
        addString(map, "screen_size", this.deviceInfo.screenSize);
        addString(map, "secret_id", this.adjustConfig.secretId);
        addLong(map, "session_count", this.activityStateCopy.sessionCount);
        addDuration(map, "session_length", this.activityStateCopy.sessionLength);
        addLong(map, "subsession_count", this.activityStateCopy.subsessionCount);
        addDuration(map, "time_spent", this.activityStateCopy.timeSpent);
        checkDeviceIds(map);
        return map;
    }
}
