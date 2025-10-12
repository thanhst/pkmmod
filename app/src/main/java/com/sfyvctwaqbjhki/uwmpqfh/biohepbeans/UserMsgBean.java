package com.sfyvctwaqbjhki.uwmpqfh.biohepbeans;

/* loaded from: classes.dex */
public class UserMsgBean extends MsgBean {
    private User data;
    private String token;

    public static class User {
        private int accountType;
        private String email;
        private int emailValid;
        private int firstLogin;
        private String telephone;
        private int userId;
        private String userName;
        private int userType;

        public User() {
        }

        public User(int i2, String str, String str2, String str3, int i3, int i4, int i5, String str4, int i6) {
            this.userId = i2;
            this.userName = str;
            this.email = str2;
            this.emailValid = i3;
            this.userType = i4;
            this.accountType = i5;
            this.telephone = str3;
            this.firstLogin = i6;
        }

        public int getAccountType() {
            return this.accountType;
        }

        public String getEmail() {
            return this.email;
        }

        public int getEmailValid() {
            return this.emailValid;
        }

        public int getFirstLogin() {
            return this.firstLogin;
        }

        public String getTelephone() {
            return this.telephone;
        }

        public int getUserId() {
            return this.userId;
        }

        public String getUserName() {
            return this.userName;
        }

        public int getUserType() {
            return this.userType;
        }

        public void setAccountType(int i2) {
            this.accountType = i2;
        }

        public void setEmail(String str) {
            this.email = str;
        }

        public void setEmailValid(int i2) {
            this.emailValid = i2;
        }

        public void setFirstLogin(int i2) {
            this.firstLogin = i2;
        }

        public void setTelephone(String str) {
            this.telephone = str;
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

    public UserMsgBean(int i2, String str, String str2, User user) {
        super(i2, str);
        this.token = str2;
        this.data = user;
    }

    public User getData() {
        return this.data;
    }

    public String getToken() {
        return this.token;
    }

    public void setData(User user) {
        this.data = user;
    }

    public void setToken(String str) {
        this.token = str;
    }
}
