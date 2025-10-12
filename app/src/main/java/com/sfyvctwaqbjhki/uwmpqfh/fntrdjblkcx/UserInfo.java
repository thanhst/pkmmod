package com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx;

/* loaded from: classes.dex */
public class UserInfo {
    private int accountType;
    private String basepwd;
    private String clientDate;
    private String email;
    private String nickName;
    private String password;
    private String thirdPartyId;
    private int userId;
    private String userName;
    private int userType;
    private int isDead = 0;
    private long updateTime = 0;

    public int getAccountType() {
        return this.accountType;
    }

    public String getBasepwd() {
        String str = this.basepwd;
        return str == null ? "" : str;
    }

    public String getClientDate() {
        String str = this.clientDate;
        return str == null ? "" : str;
    }

    public String getEmail() {
        return this.email;
    }

    public int getIsDead() {
        return this.isDead;
    }

    public String getNickName() {
        String str = this.nickName;
        return str == null ? "" : str;
    }

    public String getPassword() {
        String str = this.password;
        return str == null ? "" : str;
    }

    public String getThirdPartyId() {
        String str = this.thirdPartyId;
        return str == null ? "" : str;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public int getUserId() {
        return this.userId;
    }

    public String getUserName() {
        String str = this.userName;
        return str == null ? "" : str;
    }

    public int getUserType() {
        return this.userType;
    }

    public void setAccountType(int i2) {
        this.accountType = i2;
    }

    public void setBasepwd(String str) {
        this.basepwd = str;
    }

    public void setClientDate(String str) {
        this.clientDate = str;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setIsDead(int i2) {
        this.isDead = i2;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setThirdPartyId(String str) {
        this.thirdPartyId = str;
    }

    public void setUpdateTime(long j2) {
        this.updateTime = j2;
    }

    public void setUserId(int i2) {
        this.userId = i2;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public void setUserType(int i2) {
        this.userType = i2;
    }
}
