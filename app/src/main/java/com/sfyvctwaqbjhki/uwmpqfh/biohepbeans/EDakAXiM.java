package com.sfyvctwaqbjhki.uwmpqfh.biohepbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class EDakAXiM implements Serializable {
    private static final long serialVersionUID = 514820499;
    private long code;
    private String error_msg;
    private int fbLiveFlag = 0;
    private String fbLiveServerUrl;
    private GoogleVerify googleVerify;
    private List<HandlerBtns> handlerBtns;
    private String imageRootUrl;
    private List<LoginMethods> loginMethods;
    private Messages messages;
    private String oneStoreAppId;
    private PaymentInfo paymentInfo;
    private Publics publics;
    private String verifys;

    public class GoogleVerify implements Serializable {
        private static final long serialVersionUID = 5810786226883410149L;
        private String blueMobileAppKey;
        private String blueMobileLanguage;
        private int blueMobileProductId;
        private String blueMobilePromotionId;
        private List<String> gpProduct;
        private String gpVerify;

        public GoogleVerify() {
        }

        public String getBlueMobileAppKey() {
            String str = this.blueMobileAppKey;
            return str == null ? "" : str;
        }

        public String getBlueMobileLanguage() {
            String str = this.blueMobileLanguage;
            return str == null ? "" : str;
        }

        public int getBlueMobileProductId() {
            return this.blueMobileProductId;
        }

        public String getBlueMobilePromotionId() {
            String str = this.blueMobilePromotionId;
            return str == null ? "" : str;
        }

        public List<String> getGpProduct() {
            List<String> list = this.gpProduct;
            return list == null ? new ArrayList() : list;
        }

        public String getGpVerify() {
            String str = this.gpVerify;
            return str == null ? "" : str;
        }

        public void setBlueMobileAppKey(String str) {
            this.blueMobileAppKey = str;
        }

        public void setBlueMobileLanguage(String str) {
            this.blueMobileLanguage = str;
        }

        public void setBlueMobileProductId(int i2) {
            this.blueMobileProductId = i2;
        }

        public void setBlueMobilePromotionId(String str) {
            this.blueMobilePromotionId = str;
        }

        public void setGpProduct(List<String> list) {
            this.gpProduct = list;
        }

        public void setGpVerify(String str) {
            this.gpVerify = str;
        }

        public GoogleVerify(String str, List<String> list) {
            this.gpProduct = list;
            this.gpVerify = str;
        }

        public GoogleVerify(int i2, String str, String str2, String str3) {
            this.blueMobileProductId = i2;
            this.blueMobileLanguage = str;
            this.blueMobilePromotionId = str2;
            this.blueMobileAppKey = str3;
        }
    }

    public class HandlerBtns implements Serializable {
        private static final long serialVersionUID = 1792503156;
        private String btnClientUrl;
        private String btnName;
        private String btnNormalIcon;
        private String btnNormalPressIcon;
        private String btnRedIcon;
        private String btnRedPressIcon;
        private String btnUrl;
        private long rotate;
        private long showRedSpots;

        public HandlerBtns() {
        }

        public String getBtnClientUrl() {
            String str = this.btnClientUrl;
            return str == null ? "" : str;
        }

        public String getBtnName() {
            String str = this.btnName;
            return str == null ? "" : str;
        }

        public String getBtnNormalIcon() {
            String str = this.btnNormalIcon;
            return str == null ? "" : str;
        }

        public String getBtnNormalPressIcon() {
            String str = this.btnNormalPressIcon;
            return str == null ? "" : str;
        }

        public String getBtnRedIcon() {
            String str = this.btnRedIcon;
            return str == null ? "" : str;
        }

        public String getBtnRedPressIcon() {
            String str = this.btnRedPressIcon;
            return str == null ? "" : str;
        }

        public String getBtnUrl() {
            String str = this.btnUrl;
            return str == null ? "" : str;
        }

        public long getRotate() {
            return this.rotate;
        }

        public long getShowRedSpots() {
            return this.showRedSpots;
        }

        public void setBtnClientUrl(String str) {
            this.btnClientUrl = str;
        }

        public void setBtnName(String str) {
            this.btnName = str;
        }

        public void setBtnNormalIcon(String str) {
            this.btnNormalIcon = str;
        }

        public void setBtnNormalPressIcon(String str) {
            this.btnNormalPressIcon = str;
        }

        public void setBtnRedIcon(String str) {
            this.btnRedIcon = str;
        }

        public void setBtnRedPressIcon(String str) {
            this.btnRedPressIcon = str;
        }

        public void setBtnUrl(String str) {
            this.btnUrl = str;
        }

        public void setRotate(long j2) {
            this.rotate = j2;
        }

        public void setShowRedSpots(long j2) {
            this.showRedSpots = j2;
        }

        public String toString() {
            return "HandlerBtns [showRedSpots = " + this.showRedSpots + ", btnNormalPressIcon = " + this.btnNormalPressIcon + ", btnRedPressIcon = " + this.btnRedPressIcon + ", btnNormalIcon = " + this.btnNormalIcon + ", btnName = " + this.btnName + ", rotate = " + this.rotate + ", btnClientUrl = " + this.btnClientUrl + ", btnRedIcon = " + this.btnRedIcon + ", btnUrl = " + this.btnUrl + "]";
        }

        public HandlerBtns(long j2, String str, String str2, String str3, String str4, long j3, String str5, String str6, String str7) {
            this.showRedSpots = j2;
            this.btnNormalPressIcon = str;
            this.btnRedPressIcon = str2;
            this.btnNormalIcon = str3;
            this.btnName = str4;
            this.rotate = j3;
            this.btnClientUrl = str5;
            this.btnRedIcon = str6;
            this.btnUrl = str7;
        }
    }

    public class Items implements Serializable {
        private static final long serialVersionUID = 514820499;
        private long channel;
        private String code;
        private String name;
        private long showMethod;
        private String thirdExInfo;

        public Items() {
        }

        public long getChannel() {
            return this.channel;
        }

        public String getCode() {
            String str = this.code;
            return str == null ? "" : str;
        }

        public String getName() {
            String str = this.name;
            return str == null ? "" : str;
        }

        public long getShowMethod() {
            return this.showMethod;
        }

        public String getThirdCardName() {
            String str = this.thirdExInfo;
            return str == null ? "" : str;
        }

        public void setChannel(long j2) {
            this.channel = j2;
        }

        public void setCode(String str) {
            this.code = str;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setShowMethod(long j2) {
            this.showMethod = j2;
        }

        public void setThirdCardName(String str) {
            this.thirdExInfo = str;
        }

        public String toString() {
            return "Items [showMethod = " + this.showMethod + ", code = " + this.code + ", channel = " + this.channel + ", name = " + this.name + "]";
        }

        public Items(long j2, String str, long j3, String str2) {
            this.showMethod = j2;
            this.code = str;
            this.channel = j3;
            this.name = str2;
        }
    }

    public static class LoginMethods implements Serializable {
        private static final long serialVersionUID = 943520201;
        private String callBackUrl;
        private String iconUrl;
        private long index;
        private String loginMethod;
        private String loginUrl;
        private long rotate;

        public LoginMethods() {
        }

        public LoginMethods(String str, String str2, long j2, String str3, String str4, long j3) {
            this.loginUrl = str;
            this.iconUrl = str2;
            this.rotate = j2;
            this.callBackUrl = str3;
            this.loginMethod = str4;
            this.index = j3;
        }

        public String getCallBackUrl() {
            String str = this.callBackUrl;
            return str == null ? "" : str;
        }

        public String getIconUrl() {
            String str = this.iconUrl;
            return str == null ? "" : str;
        }

        public long getIndex() {
            return this.index;
        }

        public String getLoginMethod() {
            String str = this.loginMethod;
            return str == null ? "" : str;
        }

        public String getLoginUrl() {
            String str = this.loginUrl;
            return str == null ? "" : str;
        }

        public long getRotate() {
            return this.rotate;
        }

        public void setCallBackUrl(String str) {
            this.callBackUrl = str;
        }

        public void setIconUrl(String str) {
            this.iconUrl = str;
        }

        public void setIndex(long j2) {
            this.index = j2;
        }

        public void setLoginMethod(String str) {
            this.loginMethod = str;
        }

        public void setLoginUrl(String str) {
            this.loginUrl = str;
        }

        public void setRotate(long j2) {
            this.rotate = j2;
        }

        public String toString() {
            return "LoginMethods [loginUrl = " + this.loginUrl + ", iconUrl = " + this.iconUrl + ", rotate = " + this.rotate + ", callBackUrl = " + this.callBackUrl + ", loginMethod = " + this.loginMethod + ", index = " + this.index + "]";
        }
    }

    public class Messages implements Serializable {
        private static final long serialVersionUID = 514820499;
        private String isHasLogin;
        private String isHasPause;
        private String loginMessageUrl;
        private String pauseMessageUrl;

        public Messages() {
        }

        public String getIsHasLogin() {
            String str = this.isHasLogin;
            return str == null ? "" : str;
        }

        public String getIsHasPause() {
            String str = this.isHasPause;
            return str == null ? "" : str;
        }

        public String getLoginMessageUrl() {
            String str = this.loginMessageUrl;
            return str == null ? "" : str;
        }

        public String getPauseMessageUrl() {
            String str = this.pauseMessageUrl;
            return str == null ? "" : str;
        }

        public void setIsHasLogin(String str) {
            this.isHasLogin = str;
        }

        public void setIsHasPause(String str) {
            this.isHasPause = str;
        }

        public void setLoginMessageUrl(String str) {
            this.loginMessageUrl = str;
        }

        public void setPauseMessageUrl(String str) {
            this.pauseMessageUrl = str;
        }

        public String toString() {
            return "Messages [isHasLogin = " + this.isHasLogin + ", loginMessageUrl = " + this.loginMessageUrl + ", isHasPause = " + this.isHasPause + ", pauseMessageUrl = " + this.pauseMessageUrl + "]";
        }

        public Messages(String str, String str2, String str3, String str4) {
            this.isHasLogin = str;
            this.loginMessageUrl = str2;
            this.isHasPause = str3;
            this.pauseMessageUrl = str4;
        }
    }

    public class PaymentInfo implements Serializable {
        private static final long serialVersionUID = 514820499;
        private List<Payments> payments;
        private long showPlatformCoin;

        public PaymentInfo() {
        }

        public List<Payments> getPayments() {
            List<Payments> list = this.payments;
            return list == null ? new ArrayList() : list;
        }

        public long getShowPlatformCoin() {
            return this.showPlatformCoin;
        }

        public void setPayments(List<Payments> list) {
            this.payments = list;
        }

        public void setShowPlatformCoin(long j2) {
            this.showPlatformCoin = j2;
        }

        public String toString() {
            return "PaymentInfo [showPlatformCoin = " + this.showPlatformCoin + ", payments = " + this.payments + "]";
        }

        public PaymentInfo(long j2, List<Payments> list) {
            this.showPlatformCoin = j2;
            this.payments = list;
        }
    }

    public class Payments implements Serializable {
        private static final long serialVersionUID = 514820499;
        private long channel;
        private List<Items> items;
        private long operator;
        private List<Products> products;
        private String title;
        private long type;
        private String typeName;

        public Payments() {
        }

        public long getChannel() {
            return this.channel;
        }

        public List<Items> getItems() {
            List<Items> list = this.items;
            return list == null ? new ArrayList() : list;
        }

        public long getOperator() {
            return this.operator;
        }

        public List<Products> getProducts() {
            List<Products> list = this.products;
            return list == null ? new ArrayList() : list;
        }

        public String getTitle() {
            String str = this.title;
            return str == null ? "" : str;
        }

        public long getType() {
            return this.type;
        }

        public String getTypeName() {
            String str = this.typeName;
            return str == null ? "" : str;
        }

        public void setChannel(long j2) {
            this.channel = j2;
        }

        public void setItems(List<Items> list) {
            this.items = list;
        }

        public void setOperator(long j2) {
            this.operator = j2;
        }

        public void setProducts(List<Products> list) {
            this.products = list;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public void setType(long j2) {
            this.type = j2;
        }

        public void setTypeName(String str) {
            this.typeName = str;
        }

        public String toString() {
            return "Payments [typeName = " + this.typeName + ", title = " + this.title + ", products = " + this.products + ", channel = " + this.channel + ", type = " + this.type + ", operator = " + this.operator + ", items = " + this.items + ", items = " + this.items + "]";
        }

        public Payments(String str, String str2, List<Products> list, long j2, long j3, long j4, List<Items> list2) {
            this.typeName = str;
            this.title = str2;
            this.products = list;
            this.channel = j2;
            this.type = j3;
            this.operator = j4;
            this.items = list2;
        }
    }

    public class Products implements Serializable {
        private static final long serialVersionUID = 772329131;
        private String amount;
        private String currency;
        private String gameCurrency;
        private String productName;

        public Products() {
        }

        public String getAmount() {
            String str = this.amount;
            return str == null ? "" : str;
        }

        public String getCurrency() {
            String str = this.currency;
            return str == null ? "" : str;
        }

        public String getGameCurrency() {
            String str = this.gameCurrency;
            return str == null ? "" : str;
        }

        public String getProductName() {
            String str = this.productName;
            return str == null ? "" : str;
        }

        public void setAmount(String str) {
            this.amount = str;
        }

        public void setCurrency(String str) {
            this.currency = str;
        }

        public void setGameCurrency(String str) {
            this.gameCurrency = str;
        }

        public void setProductName(String str) {
            this.productName = str;
        }

        public String toString() {
            return "Products [productName = " + this.productName + ", gameCurrency = " + this.gameCurrency + ", amount = " + this.amount + ", currency = " + this.currency + "]";
        }

        public Products(String str, String str2, String str3, String str4) {
            this.productName = str;
            this.gameCurrency = str2;
            this.amount = str3;
            this.currency = str4;
        }
    }

    public class Publics implements Serializable {
        private static final long serialVersionUID = 5810786226883410150L;
        private String fbUrl;
        private String gpPluginAction;
        private String gpPluginGpUrl;
        private String gpPluginLoadingUrl;
        private String gpPluginName;
        private String gpPluginType;
        private String pg_protocol_url;
        private String privacyPolicyLink;
        private String registerPage;
        private String rewardUrl;
        private int pg_is_log = 0;
        private int pg_is_rating = 0;
        private int isVNCheck = 0;
        private int popUpSwitch = 0;
        private int popUpInterval = 0;
        private int firstPopUpInterval = 0;

        public Publics() {
        }

        public String getFbUrl() {
            return this.fbUrl;
        }

        public int getFirstPopUpInterval() {
            int i2 = this.firstPopUpInterval;
            if (i2 == 0) {
                return 1800;
            }
            return i2;
        }

        public String getGpPluginAction() {
            String str = this.gpPluginAction;
            return str == null ? "" : str;
        }

        public String getGpPluginGpUrl() {
            String str = this.gpPluginGpUrl;
            return str == null ? "" : str;
        }

        public String getGpPluginLoadingUrl() {
            String str = this.gpPluginLoadingUrl;
            return str == null ? "" : str;
        }

        public String getGpPluginName() {
            String str = this.gpPluginName;
            return str == null ? "" : str;
        }

        public String getGpPluginType() {
            String str = this.gpPluginType;
            return str == null ? "" : str;
        }

        public int getIsVNCheck() {
            return this.isVNCheck;
        }

        public int getPg_is_log() {
            return this.pg_is_log;
        }

        public int getPg_is_rating() {
            return this.pg_is_rating;
        }

        public String getPg_protocol_url() {
            return this.pg_protocol_url;
        }

        public int getPopUpInterval() {
            return this.popUpInterval;
        }

        public int getPopUpSwitch() {
            return this.popUpSwitch;
        }

        public String getPrivacyPolicyLink() {
            String str = this.privacyPolicyLink;
            return str == null ? "" : str;
        }

        public String getRegisterPage() {
            String str = this.registerPage;
            return str == null ? "" : str;
        }

        public String getRewardUrl() {
            return this.rewardUrl;
        }
    }

    public EDakAXiM() {
    }

    public long getCode() {
        return this.code;
    }

    public String getError_msg() {
        String str = this.error_msg;
        return str == null ? "" : str;
    }

    public int getFbLiveFlag() {
        return this.fbLiveFlag;
    }

    public String getFbLiveServerUrl() {
        String str = this.fbLiveServerUrl;
        return str == null ? "" : str;
    }

    public GoogleVerify getGoogleVerify() {
        if (this.googleVerify == null) {
            this.googleVerify = new GoogleVerify();
        }
        return this.googleVerify;
    }

    public List<HandlerBtns> getHandlerBtns() {
        List<HandlerBtns> list = this.handlerBtns;
        return list == null ? new ArrayList() : list;
    }

    public String getImageRootUrl() {
        String str = this.imageRootUrl;
        return str == null ? "" : str;
    }

    public List<LoginMethods> getLoginMethods() {
        List<LoginMethods> list = this.loginMethods;
        return list == null ? new ArrayList() : list;
    }

    public Messages getMessages() {
        Messages messages = this.messages;
        return messages == null ? new Messages() : messages;
    }

    public String getOneStoreAppId() {
        String str = this.oneStoreAppId;
        return str == null ? "" : str;
    }

    public PaymentInfo getPaymentInfo() {
        PaymentInfo paymentInfo = this.paymentInfo;
        return paymentInfo == null ? new PaymentInfo() : paymentInfo;
    }

    public Publics getPublics() {
        if (this.publics == null) {
            this.publics = new Publics();
        }
        return this.publics;
    }

    public String getVerifys() {
        String str = this.verifys;
        return str == null ? "" : str;
    }

    public void setCode(long j2) {
        this.code = j2;
    }

    public void setError_msg(String str) {
        this.error_msg = str;
    }

    public void setFbLiveFlag(int i2) {
        this.fbLiveFlag = i2;
    }

    public void setFbLiveServerUrl(String str) {
        this.fbLiveServerUrl = str;
    }

    public void setGoogleVerify(GoogleVerify googleVerify) {
        this.googleVerify = googleVerify;
    }

    public void setHandlerBtns(List<HandlerBtns> list) {
        this.handlerBtns = list;
    }

    public void setImageRootUrl(String str) {
        this.imageRootUrl = str;
    }

    public void setLoginMethods(List<LoginMethods> list) {
        this.loginMethods = list;
    }

    public void setMessages(Messages messages) {
        this.messages = messages;
    }

    public void setOneStoreAppId(String str) {
        this.oneStoreAppId = str;
    }

    public void setPaymentInfo(PaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public void setPublics(Publics publics) {
        this.publics = publics;
    }

    public void setVerifys(String str) {
        this.verifys = str;
    }

    public String toString() {
        return "EDakAXiM [loginMethods = " + this.loginMethods + ", code = " + this.code + ", imageRootUrl = " + this.imageRootUrl + ", error_msg = " + this.error_msg + ", handlerBtns = " + this.handlerBtns + ", paymentInfo = " + this.paymentInfo + ", messages = " + this.messages + "]";
    }

    public EDakAXiM(List<LoginMethods> list, long j2, String str, String str2, List<HandlerBtns> list2, PaymentInfo paymentInfo, Messages messages) {
        this.loginMethods = list;
        this.code = j2;
        this.imageRootUrl = str;
        this.error_msg = str2;
        this.handlerBtns = list2;
        this.paymentInfo = paymentInfo;
        this.messages = messages;
    }
}
