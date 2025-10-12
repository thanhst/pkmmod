package com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx;

/* loaded from: classes.dex */
public class ConfigBean {
    private String advChannel;
    private int appId;
    private String appKey;
    private int isDebug = 0;
    private int isVNCheck = 0;
    private String loginJson;
    private String url;

    public String getAdvChannel() {
        return this.advChannel;
    }

    public int getAppId() {
        return this.appId;
    }

    public String getAppKey() {
        String str = this.appKey;
        return str == null ? "" : str;
    }

    public int getIsDebug() {
        return this.isDebug;
    }

    public int getIsVNCheck() {
        return this.isVNCheck;
    }

    public String getLoginJson() {
        return this.loginJson;
    }

    public String getUrl() {
        String str = this.url;
        return str == null ? "" : str;
    }

    public void setAdvChannel(String str) {
        this.advChannel = str;
    }

    public void setAppId(int i2) {
        this.appId = i2;
    }

    public void setAppKey(String str) {
        this.appKey = str;
    }

    public void setIsDebug(int i2) {
        this.isDebug = i2;
    }

    public void setIsVNCheck(int i2) {
        this.isVNCheck = i2;
    }

    public void setLoginJson(String str) {
        this.loginJson = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
