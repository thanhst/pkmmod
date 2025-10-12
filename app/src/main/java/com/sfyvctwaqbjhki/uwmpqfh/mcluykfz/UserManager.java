package com.sfyvctwaqbjhki.uwmpqfh.mcluykfz;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sfyvctwaqbjhki.uwmpqfh.WoUjMp;
import com.sfyvctwaqbjhki.uwmpqfh.biohepbeans.EDakAXiM;
import com.sfyvctwaqbjhki.uwmpqfh.biohepbeans.NLWYDO;
import com.sfyvctwaqbjhki.uwmpqfh.biohepbeans.RfybaJKCLilYpc;
import com.sfyvctwaqbjhki.uwmpqfh.biohepbeans.ServerReturnInfo;
import com.sfyvctwaqbjhki.uwmpqfh.biohepbeans.UserMsgBean;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.ConstantUtil;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.CryptogramUtil;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.DataUtil;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.DateUtil;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.DeviceUtil;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.LogUtils;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.NetWorkUtil;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.rsa.AESCommonUtil;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.ConfigBean;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.JwpHqftVBZs;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.LoginInfo;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.NetParamsBean;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.UGuwCakoQHjtD;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.UserInfo;
import com.sfyvctwaqbjhki.uwmpqfh.msdiykjb.PBvElADcPX;
import com.sfyvctwaqbjhki.uwmpqfh.ovlfuarnk.PluginNXUfldNktBOT;
import com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.HttpInterface;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class UserManager {
    private int code;
    private String msg;
    private HttpInterface netClass;
    private final int SUCCESS = 0;
    private final int FAIL = 1;
    private ConfigBean configBean = Response.getInstance().getConfigBean();
    private UserInfo userInfo = Response.getInstance().getUserInfo();
    private NetParamsBean netParamsBean = Response.getInstance().getNetParamsBean();
    private UGuwCakoQHjtD payBean = Response.getInstance().getUGuwCakoQHjtD();
    private Activity context = WoUjMp.getInstance().getContext();
    private EDakAXiM initConfigBean = Response.getInstance().getEDakAXiM();
    private Handler handler = new Handler() { // from class: com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                UserManager.this.response(Response.getInstance());
            } else if (i2 == 1) {
                UserManager userManager = UserManager.this;
                userManager.fail(userManager.code, UserManager.this.msg);
            }
        }
    };
    private Gson gson = new Gson();

    /* renamed from: com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$mcluykfz$UserManager$Type;

        static {
            int[] iArr = new int[Type.values().length];
            $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$mcluykfz$UserManager$Type = iArr;
            try {
                iArr[Type.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$mcluykfz$UserManager$Type[Type.LOGIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$mcluykfz$UserManager$Type[Type.REGISTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$mcluykfz$UserManager$Type[Type.FORGETPSW.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$mcluykfz$UserManager$Type[Type.CHECKVALIDCODE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$mcluykfz$UserManager$Type[Type.RESETPSW.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$mcluykfz$UserManager$Type[Type.CHANGEPSW.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$mcluykfz$UserManager$Type[Type.BINDVISITOR.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$mcluykfz$UserManager$Type[Type.CHARGEDETAIL.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$mcluykfz$UserManager$Type[Type.CHARGELIST.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$mcluykfz$UserManager$Type[Type.BINDZONE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$mcluykfz$UserManager$Type[Type.UPLOADSOCIAL.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$mcluykfz$UserManager$Type[Type.CHECKPWD.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$mcluykfz$UserManager$Type[Type.BINDEMAIL.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$mcluykfz$UserManager$Type[Type.INITIABHELPER.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$mcluykfz$UserManager$Type[Type.REQUESTPRODUCTS.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$mcluykfz$UserManager$Type[Type.MAKEORDER.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$mcluykfz$UserManager$Type[Type.CONSUMEORDER.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$mcluykfz$UserManager$Type[Type.CHECKAPPSTATUS.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$mcluykfz$UserManager$Type[Type.CANCELACCADDR.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
        }
    }

    public class BindEmail implements HttpInterface {
        public BindEmail() {
        }

        @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.HttpInterface
        public Map<String, Object> getMap() {
            HashMap map = new HashMap();
            map.put("appId", Integer.valueOf(UserManager.this.configBean.getAppId()));
            map.put("userId", Integer.valueOf(UserManager.this.userInfo.getUserId()));
            map.put("email", UserManager.this.netParamsBean.getBindEmail());
            map.put("operatorType", 0);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(map.get("appId"));
            stringBuffer.append(map.get("userId"));
            stringBuffer.append(map.get("email"));
            stringBuffer.append(map.get("operatorType"));
            stringBuffer.append(UserManager.this.configBean.getAppKey());
            map.put(DataUtil.ORDER_COLUMN.ORDER_SIGN, CryptogramUtil.encryptMD5(stringBuffer.toString()));
            return map;
        }

        @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.HttpInterface
        public void parseResponse(String str) throws JSONException {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int i2 = jSONObject.getInt("code");
                if (i2 == 200) {
                    UserManager.this.userInfo.setEmail(UserManager.this.netParamsBean.getBindEmail());
                    Response.getInstance().setUserInfo(UserManager.this.userInfo);
                    PBvElADcPX.insertOrUpdateUser(UserManager.this.userInfo, true);
                    UserManager.this.handler.sendEmptyMessage(0);
                } else {
                    UserManager.this.code = i2;
                    UserManager.this.msg = jSONObject.getString("error_msg");
                    UserManager.this.handler.sendEmptyMessage(1);
                }
            } catch (Exception e2) {
                LogUtils.e(e2.getMessage());
                UserManager.this.msg = e2.getMessage();
                UserManager.this.code = 111111;
                UserManager.this.handler.sendEmptyMessage(1);
            }
        }
    }

    public class BindVisitor implements HttpInterface {
        public BindVisitor() {
        }

        @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.HttpInterface
        public Map<String, Object> getMap() {
            HashMap map = new HashMap();
            map.put("appId", Integer.valueOf(UserManager.this.configBean.getAppId()));
            map.put("userId", Integer.valueOf(UserManager.this.userInfo.getUserId()));
            map.put(DataUtil.USER_COLUMN.USERNAME, UserManager.this.netParamsBean.getBindAccountName());
            map.put(DataUtil.USER_COLUMN.PASSWORD, CryptogramUtil.encryptMD5(UserManager.this.netParamsBean.getNewPassword()));
            map.put("email", UserManager.this.netParamsBean.getBindEmail());
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(map.get("appId"));
            stringBuffer.append(map.get("userId"));
            stringBuffer.append(map.get(DataUtil.USER_COLUMN.USERNAME));
            stringBuffer.append(map.get(DataUtil.USER_COLUMN.PASSWORD));
            stringBuffer.append(UserManager.this.configBean.getAppKey());
            map.put(DataUtil.ORDER_COLUMN.ORDER_SIGN, CryptogramUtil.encryptMD5(stringBuffer.toString()));
            return map;
        }

        @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.HttpInterface
        public void parseResponse(String str) throws JSONException {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int i2 = jSONObject.getInt("code");
                if (i2 == 200) {
                    UserManager.this.userInfo.setAccountType(ConstantUtil.ACCOUNTTYPE_NORMAL);
                    UserManager.this.userInfo.setUserType(ConstantUtil.USER_TYPE_POSITIVE);
                    UserManager.this.userInfo.setUserName(UserManager.this.netParamsBean.getBindAccountName());
                    UserManager.this.userInfo.setPassword(CryptogramUtil.encryptMD5(UserManager.this.netParamsBean.getNewPassword()));
                    UserManager.this.userInfo.setBasepwd(UserManager.this.netParamsBean.getNewPassword());
                    UserManager.this.userInfo.setEmail(UserManager.this.netParamsBean.getBindEmail());
                    PBvElADcPX.insertOrUpdateUser(UserManager.this.userInfo, true);
                    UserManager.this.handler.sendEmptyMessage(0);
                } else {
                    UserManager.this.code = i2;
                    UserManager.this.msg = jSONObject.getString("error_msg");
                    UserManager.this.handler.sendEmptyMessage(1);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                UserManager.this.msg = e2.getMessage();
                UserManager.this.code = 111111;
                UserManager.this.handler.sendEmptyMessage(1);
            }
        }
    }

    public class BindZone implements HttpInterface {
        public BindZone() {
        }

        @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.HttpInterface
        public Map<String, Object> getMap() {
            HashMap map = new HashMap();
            map.put("appId", Integer.valueOf(UserManager.this.configBean.getAppId()));
            map.put("userId", Integer.valueOf(UserManager.this.userInfo.getUserId()));
            map.put(DataUtil.ORDER_COLUMN.ORDER_GAME_ZONE_ID, UserManager.this.payBean.getGameZoneId());
            map.put("createRole", Integer.valueOf(UserManager.this.netParamsBean.getCreateRole()));
            map.put(DataUtil.ORDER_COLUMN.ORDER_ADV_CHANNEL, UserManager.this.configBean.getAdvChannel());
            UserManager.this.putDeviceMsg(map);
            map.put(DataUtil.ORDER_COLUMN.ORDER_ROLE_ID, UserManager.this.payBean.getRoleId());
            map.put("level", UserManager.this.payBean.getLevel());
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(map.get("userId"));
            stringBuffer.append(map.get("appId"));
            stringBuffer.append(map.get(DataUtil.ORDER_COLUMN.ORDER_GAME_ZONE_ID));
            stringBuffer.append(map.get("source"));
            stringBuffer.append(UserManager.this.configBean.getAppKey());
            map.put(DataUtil.ORDER_COLUMN.ORDER_SIGN, CryptogramUtil.encryptMD5(stringBuffer.toString()));
            return map;
        }

        @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.HttpInterface
        public void parseResponse(String str) {
        }
    }

    private class CancelAccAddr implements HttpInterface {
        private CancelAccAddr() {
        }

        @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.HttpInterface
        public Map<String, Object> getMap() {
            HashMap map = new HashMap();
            map.put("appId", Integer.valueOf(UserManager.this.configBean.getAppId()));
            map.put("userId", Integer.valueOf(UserManager.this.userInfo.getUserId()));
            map.put(DataUtil.USER_COLUMN.PASSWORD, UserManager.this.userInfo.getPassword());
            map.put(DataUtil.USER_COLUMN.ACCOUNT_TYPE, Integer.valueOf(UserManager.this.userInfo.getAccountType()));
            map.put(DataUtil.ORDER_COLUMN.ORDER_ADV_CHANNEL, UserManager.this.configBean.getAdvChannel());
            UserManager.this.putDeviceMsg(map);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(map.get("appId"));
            stringBuffer.append(map.get("userId"));
            stringBuffer.append(map.get("source"));
            stringBuffer.append(map.get(DataUtil.USER_COLUMN.PASSWORD));
            stringBuffer.append(UserManager.this.configBean.getAppKey());
            map.put(DataUtil.ORDER_COLUMN.ORDER_SIGN, CryptogramUtil.encryptMD5(stringBuffer.toString()));
            return map;
        }

        @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.HttpInterface
        public void parseResponse(String str) throws JSONException {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int i2 = jSONObject.getInt("code");
                if (i2 == 200) {
                    UserManager.this.netParamsBean.setAccCancelAddr(jSONObject.getJSONObject(ShareConstants.WEB_DIALOG_PARAM_DATA).optString("url"));
                    UserManager.this.handler.sendEmptyMessage(0);
                } else {
                    UserManager.this.code = i2;
                    UserManager.this.handler.sendEmptyMessage(1);
                }
            } catch (Exception e2) {
                UserManager.this.msg = e2.getMessage();
                UserManager.this.code = PluginNXUfldNktBOT.ERROR_CONSUME_OR_PAY;
                UserManager.this.handler.sendEmptyMessage(1);
            }
        }
    }

    public class ChangePsw implements HttpInterface {
        public ChangePsw() {
        }

        @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.HttpInterface
        public Map<String, Object> getMap() {
            HashMap map = new HashMap();
            map.put("appId", Integer.valueOf(UserManager.this.configBean.getAppId()));
            map.put("userId", Integer.valueOf(UserManager.this.userInfo.getUserId()));
            map.put(DataUtil.USER_COLUMN.PASSWORD, UserManager.this.userInfo.getPassword());
            map.put("newPassword", CryptogramUtil.encryptMD5(UserManager.this.netParamsBean.getNewPassword()));
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(map.get("appId"));
            stringBuffer.append(map.get("userId"));
            stringBuffer.append(map.get(DataUtil.USER_COLUMN.PASSWORD));
            stringBuffer.append(map.get("newPassword"));
            stringBuffer.append(UserManager.this.configBean.getAppKey());
            map.put(DataUtil.ORDER_COLUMN.ORDER_SIGN, CryptogramUtil.encryptMD5(stringBuffer.toString()));
            return map;
        }

        @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.HttpInterface
        public void parseResponse(String str) throws JSONException {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int i2 = jSONObject.getInt("code");
                if (i2 == 200) {
                    UserManager.this.userInfo.setPassword(CryptogramUtil.encryptMD5(UserManager.this.netParamsBean.getNewPassword()));
                    UserManager.this.userInfo.setBasepwd(UserManager.this.netParamsBean.getNewPassword());
                    PBvElADcPX.insertOrUpdateUser(UserManager.this.userInfo, true);
                    UserManager.this.handler.sendEmptyMessage(0);
                } else {
                    UserManager.this.code = i2;
                    UserManager.this.msg = jSONObject.getString("error_msg");
                    UserManager.this.handler.sendEmptyMessage(1);
                }
            } catch (Exception e2) {
                LogUtils.e(e2.getMessage());
                UserManager.this.msg = e2.getMessage();
                UserManager.this.code = 111111;
                UserManager.this.handler.sendEmptyMessage(1);
            }
        }
    }

    private class CheckAppStatus implements HttpInterface {
        private CheckAppStatus() {
        }

        @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.HttpInterface
        public Map<String, Object> getMap() {
            HashMap map = new HashMap();
            map.put("appId", Integer.valueOf(UserManager.this.configBean.getAppId()));
            map.put(DataUtil.ORDER_COLUMN.ORDER_ADV_CHANNEL, UserManager.this.configBean.getAdvChannel());
            UserManager.this.putDeviceMsg(map);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(map.get("appId"));
            stringBuffer.append(map.get(DataUtil.ORDER_COLUMN.ORDER_ADV_CHANNEL));
            stringBuffer.append(map.get("clientTime"));
            stringBuffer.append(map.get("source"));
            stringBuffer.append(UserManager.this.configBean.getAppKey());
            map.put(DataUtil.ORDER_COLUMN.ORDER_SIGN, CryptogramUtil.encryptMD5(stringBuffer.toString()));
            return map;
        }

        @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.HttpInterface
        public void parseResponse(String str) throws JSONException {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int i2 = jSONObject.getInt("code");
                if (i2 == 200) {
                    Response.getInstance().setIsCheck(jSONObject.getJSONObject(ShareConstants.WEB_DIALOG_PARAM_DATA).optInt("isCheck"));
                    UserManager.this.handler.sendEmptyMessage(0);
                } else {
                    UserManager.this.code = i2;
                    UserManager.this.handler.sendEmptyMessage(1);
                }
            } catch (Exception e2) {
                UserManager.this.msg = e2.getMessage();
                UserManager.this.code = PluginNXUfldNktBOT.ERROR_CONSUME_OR_PAY;
                UserManager.this.handler.sendEmptyMessage(1);
            }
        }
    }

    public class CheckPWD implements HttpInterface {
        public CheckPWD() {
        }

        @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.HttpInterface
        public Map<String, Object> getMap() {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("appId", Integer.valueOf(UserManager.this.configBean.getAppId()));
            linkedHashMap.put("userId", Integer.valueOf(UserManager.this.userInfo.getUserId()));
            linkedHashMap.put(DataUtil.USER_COLUMN.PASSWORD, UserManager.this.userInfo.getPassword());
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(linkedHashMap.get("appId"));
            stringBuffer.append(linkedHashMap.get("userId"));
            stringBuffer.append(linkedHashMap.get(DataUtil.USER_COLUMN.PASSWORD));
            stringBuffer.append(UserManager.this.configBean.getAppKey());
            linkedHashMap.put(DataUtil.ORDER_COLUMN.ORDER_SIGN, CryptogramUtil.encryptMD5(stringBuffer.toString()));
            return linkedHashMap;
        }

        @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.HttpInterface
        public void parseResponse(String str) throws JSONException {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int i2 = jSONObject.getInt("code");
                if (i2 == 200) {
                    UserManager.this.handler.sendEmptyMessage(0);
                } else {
                    UserManager.this.code = i2;
                    UserManager.this.msg = jSONObject.getString("error_msg");
                    UserManager.this.handler.sendEmptyMessage(1);
                }
            } catch (Exception e2) {
                LogUtils.e(e2.getMessage());
                UserManager.this.msg = e2.getMessage();
                UserManager.this.code = 111111;
                UserManager.this.handler.sendEmptyMessage(1);
            }
        }
    }

    public class CheckValidCode implements HttpInterface {
        public CheckValidCode() {
        }

        @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.HttpInterface
        public Map<String, Object> getMap() {
            HashMap map = new HashMap();
            map.put("appId", Integer.valueOf(UserManager.this.configBean.getAppId()));
            map.put(DataUtil.USER_COLUMN.USERNAME, UserManager.this.userInfo.getUserName());
            map.put("verifyCode", UserManager.this.netParamsBean.getVerifyCode());
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(map.get("verifyCode"));
            stringBuffer.append(map.get(DataUtil.USER_COLUMN.USERNAME));
            stringBuffer.append(map.get("appId"));
            stringBuffer.append(UserManager.this.configBean.getAppKey());
            map.put(DataUtil.ORDER_COLUMN.ORDER_SIGN, CryptogramUtil.encryptMD5(stringBuffer.toString()));
            return map;
        }

        @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.HttpInterface
        public void parseResponse(String str) throws JSONException {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int i2 = jSONObject.getInt("code");
                if (i2 == 200) {
                    UserManager.this.handler.sendEmptyMessage(0);
                } else {
                    UserManager.this.code = i2;
                    UserManager.this.msg = jSONObject.getString("error_msg");
                    UserManager.this.handler.sendEmptyMessage(1);
                }
            } catch (Exception e2) {
                LogUtils.e(e2.getMessage());
                UserManager.this.msg = e2.getMessage();
                UserManager.this.code = 111111;
                UserManager.this.handler.sendEmptyMessage(1);
            }
        }
    }

    private class ConsumeOrder implements HttpInterface {
        private ConsumeOrder() {
        }

        @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.HttpInterface
        public Map<String, Object> getMap() {
            HashMap map = new HashMap();
            map.put("transactionId", UserManager.this.netParamsBean.getPlatTransactionId());
            map.put(DataUtil.ORDER_COLUMN.ORDER_RECEIPT, UserManager.this.netParamsBean.getReceipt());
            map.put(DataUtil.ORDER_COLUMN.ORDER_SIGNATURE, UserManager.this.netParamsBean.getSignature());
            map.put("channel", UserManager.this.netParamsBean.getPayChannel());
            map.put(DataUtil.ORDER_COLUMN.ORDER_ADV_CHANNEL, UserManager.this.configBean.getAdvChannel());
            UserManager.this.putDeviceMsg(map);
            map.put("exInfo", UserManager.this.netParamsBean.getPayChannel().equals("24") ? UserManager.this.initConfigBean.getOneStoreAppId() : UserManager.this.payBean != null ? UserManager.this.payBean.getExInfo() : "");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(map.get("transactionId"));
            stringBuffer.append(map.get(DataUtil.ORDER_COLUMN.ORDER_RECEIPT));
            stringBuffer.append(map.get(DataUtil.ORDER_COLUMN.ORDER_SIGNATURE));
            stringBuffer.append(map.get("channel"));
            stringBuffer.append(map.get(DataUtil.ORDER_COLUMN.ORDER_ADV_CHANNEL));
            stringBuffer.append(UserManager.this.configBean.getAppKey());
            map.put(DataUtil.ORDER_COLUMN.ORDER_SIGN, CryptogramUtil.encryptMD5(stringBuffer.toString()));
            LogUtils.e(map.toString());
            return map;
        }

        @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.HttpInterface
        public void parseResponse(String str) throws JSONException {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int i2 = jSONObject.getInt("code");
                if (i2 != 200) {
                    UserManager.this.code = i2;
                    UserManager.this.handler.sendEmptyMessage(1);
                } else {
                    String strOptString = jSONObject.optString("money");
                    UserManager.this.netParamsBean.setMoney(Double.valueOf(strOptString.equals("") ? 0.0d : Double.parseDouble(strOptString)));
                    UserManager.this.netParamsBean.setCurrency(jSONObject.optString(DataUtil.ORDER_LIST_COLUMN.CURRENCY));
                    UserManager.this.handler.sendEmptyMessage(0);
                }
            } catch (Exception e2) {
                UserManager.this.msg = e2.getMessage();
                UserManager.this.code = PluginNXUfldNktBOT.ERROR_CONSUME_OR_PAY;
                UserManager.this.handler.sendEmptyMessage(1);
            }
        }
    }

    public class ForgetPsw implements HttpInterface {
        public ForgetPsw() {
        }

        @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.HttpInterface
        public Map<String, Object> getMap() {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("appId", Integer.valueOf(UserManager.this.configBean.getAppId()));
            linkedHashMap.put(DataUtil.USER_COLUMN.USERNAME, UserManager.this.netParamsBean.getExInfo());
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(linkedHashMap.get("appId"));
            stringBuffer.append(linkedHashMap.get(DataUtil.USER_COLUMN.USERNAME));
            stringBuffer.append(UserManager.this.configBean.getAppKey());
            linkedHashMap.put(DataUtil.ORDER_COLUMN.ORDER_SIGN, CryptogramUtil.encryptMD5(stringBuffer.toString()));
            return linkedHashMap;
        }

        @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.HttpInterface
        public void parseResponse(String str) throws JSONException {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int i2 = jSONObject.getInt("code");
                if (i2 == 200) {
                    UserManager.this.handler.sendEmptyMessage(0);
                } else {
                    UserManager.this.code = i2;
                    UserManager.this.msg = jSONObject.getString("error_msg");
                    UserManager.this.handler.sendEmptyMessage(1);
                }
            } catch (Exception e2) {
                UserManager.this.msg = e2.getMessage();
                UserManager.this.code = 111111;
                UserManager.this.handler.sendEmptyMessage(1);
            }
        }
    }

    public class GetChargeDetail implements HttpInterface {
        public GetChargeDetail() {
        }

        @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.HttpInterface
        public Map<String, Object> getMap() {
            HashMap map = new HashMap();
            map.put("appId", Integer.valueOf(UserManager.this.configBean.getAppId()));
            map.put("transactionId", "");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(map.get("appId"));
            stringBuffer.append(map.get("transactionId"));
            stringBuffer.append(UserManager.this.configBean.getAppKey());
            map.put(DataUtil.ORDER_COLUMN.ORDER_SIGN, CryptogramUtil.encryptMD5(stringBuffer.toString()));
            return map;
        }

        @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.HttpInterface
        public void parseResponse(String str) {
        }
    }

    public class GetChargeList implements HttpInterface {
        public GetChargeList() {
        }

        @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.HttpInterface
        public Map<String, Object> getMap() {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("appId", Integer.valueOf(UserManager.this.configBean.getAppId()));
            linkedHashMap.put("userId", Integer.valueOf(UserManager.this.userInfo.getUserId()));
            linkedHashMap.put("lastTime", UserManager.this.netParamsBean.getLastTime());
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(linkedHashMap.get("appId"));
            stringBuffer.append(linkedHashMap.get("userId"));
            stringBuffer.append(UserManager.this.configBean.getAppKey());
            linkedHashMap.put(DataUtil.ORDER_COLUMN.ORDER_SIGN, CryptogramUtil.encryptMD5(stringBuffer.toString()));
            return linkedHashMap;
        }

        @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.HttpInterface
        public void parseResponse(String str) {
            try {
                NLWYDO nlwydo = (NLWYDO) new Gson().fromJson(str, NLWYDO.class);
                if (nlwydo.getCode() != 200) {
                    UserManager userManager = UserManager.this;
                    userManager.code = userManager.code;
                    UserManager.this.msg = nlwydo.getError_msg();
                    UserManager.this.handler.sendEmptyMessage(1);
                    return;
                }
                List<NLWYDO.Order> data = nlwydo.getData();
                if (data != null && data.size() != 0) {
                    SharedPreferences.Editor editorEdit = UserManager.this.context.getSharedPreferences(ConstantUtil.ACCOUNT_PREFERENCES, 0).edit();
                    editorEdit.putString((UserManager.this.userInfo.getUserId() + UserManager.this.configBean.getAppId()) + "orderLastUpdateTime", nlwydo.getLastTime());
                    editorEdit.commit();
                    for (NLWYDO.Order order : data) {
                        JwpHqftVBZs jwpHqftVBZs = new JwpHqftVBZs();
                        jwpHqftVBZs.setAppId(UserManager.this.configBean.getAppId());
                        jwpHqftVBZs.setUserId(UserManager.this.userInfo.getUserId());
                        jwpHqftVBZs.setTransactionId(order.getTransactionId());
                        jwpHqftVBZs.setAmount(order.getAmount());
                        jwpHqftVBZs.setCurrency(order.getCurrency());
                        jwpHqftVBZs.setChannel(order.getChannel());
                        jwpHqftVBZs.setStatus(order.getStatus());
                        jwpHqftVBZs.setChargingType(order.getChargingType());
                        jwpHqftVBZs.setClientTime(order.getClientDate());
                        PBvElADcPX.insertOrUpdateOrder(jwpHqftVBZs);
                    }
                }
                UserManager.this.handler.sendEmptyMessage(0);
            } catch (Exception e2) {
                LogUtils.e(e2.getMessage());
                UserManager.this.msg = e2.getMessage();
                UserManager.this.code = 111111;
                UserManager.this.handler.sendEmptyMessage(1);
            }
        }
    }

    public class Init implements HttpInterface {
        public Init() {
        }

        @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.HttpInterface
        public Map<String, Object> getMap() {
            HashMap map = new HashMap();
            map.put("appId", Integer.valueOf(UserManager.this.configBean.getAppId()));
            map.put(DataUtil.ORDER_COLUMN.ORDER_ADV_CHANNEL, UserManager.this.configBean.getAdvChannel());
            UserManager.this.putDeviceMsg(map);
            map.put("firstInstall", Integer.valueOf(PBvElADcPX.isFirstLoadPackage(UserManager.this.configBean.getAppId()) ? 1 : 0));
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(map.get("appId"));
            stringBuffer.append(map.get("source"));
            stringBuffer.append(map.get(DataUtil.ORDER_COLUMN.ORDER_ADV_CHANNEL));
            stringBuffer.append(UserManager.this.configBean.getAppKey());
            map.put(DataUtil.ORDER_COLUMN.ORDER_SIGN, CryptogramUtil.encryptMD5(stringBuffer.toString()));
            LogUtils.e("==================================================netInit  start " + UserManager.this.configBean.getAppId());
            return map;
        }

        @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.HttpInterface
        public void parseResponse(String str) throws JSONException {
            LogUtils.e("==================================================netInit  end");
            try {
                JSONObject jSONObject = new JSONObject(str);
                int i2 = jSONObject.getInt("code");
                if (i2 != 200) {
                    LogUtils.e("netInit fail::::::::" + str);
                    UserManager.this.code = i2;
                    UserManager.this.msg = jSONObject.getString("error_msg");
                    UserManager.this.handler.sendEmptyMessage(1);
                    return;
                }
                EDakAXiM eDakAXiM = (EDakAXiM) UserManager.this.gson.fromJson(str, EDakAXiM.class);
                if (eDakAXiM.getPublics() != null) {
                    UserManager.this.configBean.setIsDebug(eDakAXiM.getPublics().getPg_is_log());
                    UserManager.this.configBean.setIsVNCheck(eDakAXiM.getPublics().getIsVNCheck());
                }
                LogUtils.e("=========netInit  response========= " + str);
                if (eDakAXiM.getVerifys() != null && eDakAXiM.getVerifys().length() != 0) {
                    JSONObject jSONObject2 = new JSONObject(AESCommonUtil.getInstance().decrypt(eDakAXiM.getVerifys()));
                    eDakAXiM.setOneStoreAppId(jSONObject2.optString("oneStoreAppId"));
                    int iOptInt = jSONObject2.optInt("fbLiveFlag");
                    String strOptString = jSONObject2.optString("fbLiveServerUrl");
                    eDakAXiM.setFbLiveFlag(iOptInt);
                    eDakAXiM.setFbLiveServerUrl(strOptString);
                    if (jSONObject2.has("gpProduct") && jSONObject2.has("gpVerify")) {
                        eDakAXiM.getGoogleVerify().setGpProduct((List) UserManager.this.gson.fromJson(jSONObject2.getString("gpProduct"), new TypeToken<List<String>>() { // from class: com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager.Init.1
                        }.getType()));
                        eDakAXiM.getGoogleVerify().setGpVerify(jSONObject2.getString("gpVerify"));
                    }
                    if (jSONObject2.has("blueMobileProductId") && jSONObject2.has("blueMobileLanguage") && jSONObject2.has("blueMobilePromotionId") && jSONObject2.has("blueMobileAppKey")) {
                        eDakAXiM.getGoogleVerify().setBlueMobileLanguage(jSONObject2.getString("blueMobileLanguage"));
                        eDakAXiM.getGoogleVerify().setBlueMobileProductId(jSONObject2.getInt("blueMobileProductId"));
                        eDakAXiM.getGoogleVerify().setBlueMobilePromotionId(jSONObject2.getString("blueMobilePromotionId"));
                        eDakAXiM.getGoogleVerify().setBlueMobileAppKey(jSONObject2.getString("blueMobileAppKey"));
                    }
                }
                Response.getInstance().setEDakAXiM(eDakAXiM);
                UserManager.this.handler.sendEmptyMessage(0);
            } catch (Exception e2) {
                LogUtils.e("netInit fail::: response is:" + str + "   exception is:" + e2.getMessage());
                UserManager.this.msg = e2.getMessage();
                UserManager.this.code = 111111;
                UserManager.this.handler.sendEmptyMessage(1);
            }
        }
    }

    public class Initiabhelper implements HttpInterface {
        public Initiabhelper() {
        }

        @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.HttpInterface
        public Map<String, Object> getMap() {
            HashMap map = new HashMap();
            map.put("url", UserManager.this.configBean.getUrl());
            map.put("appId", Integer.valueOf(UserManager.this.configBean.getAppId()));
            map.put("appKey", UserManager.this.configBean.getAppKey());
            map.put(DataUtil.ORDER_COLUMN.ORDER_ADV_CHANNEL, UserManager.this.configBean.getAdvChannel());
            UserManager.this.putDeviceMsg(map);
            map.put("googlePlayKey", UserManager.this.initConfigBean.getGoogleVerify().getGpVerify());
            map.put("products", UserManager.this.initConfigBean.getGoogleVerify().getGpProduct());
            map.put("language", UserManager.this.initConfigBean.getGoogleVerify().getBlueMobileLanguage());
            map.put("ek", UserManager.this.initConfigBean.getGoogleVerify().getBlueMobileAppKey());
            map.put("promotionId", UserManager.this.initConfigBean.getGoogleVerify().getBlueMobilePromotionId());
            map.put("bluePayProduct", Integer.valueOf(UserManager.this.initConfigBean.getGoogleVerify().getBlueMobileProductId()));
            return map;
        }

        @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.HttpInterface
        public void parseResponse(String str) {
            LogUtils.e("google消费订单 === " + str);
        }
    }

    public class Login implements HttpInterface {
        public Login() {
        }

        @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.HttpInterface
        public Map<String, Object> getMap() {
            HashMap map = new HashMap();
            map.put("appId", Integer.valueOf(UserManager.this.configBean.getAppId()));
            map.put(DataUtil.USER_COLUMN.USERNAME, UserManager.this.userInfo.getUserName());
            map.put(DataUtil.USER_COLUMN.PASSWORD, UserManager.this.userInfo.getPassword());
            map.put(DataUtil.ORDER_COLUMN.ORDER_ADV_CHANNEL, UserManager.this.configBean.getAdvChannel());
            UserManager.this.putDeviceMsg(map);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(map.get("appId"));
            stringBuffer.append(map.get(DataUtil.USER_COLUMN.USERNAME));
            stringBuffer.append(map.get(DataUtil.USER_COLUMN.PASSWORD));
            stringBuffer.append(map.get("source"));
            stringBuffer.append(UserManager.this.configBean.getAppKey());
            map.put(DataUtil.ORDER_COLUMN.ORDER_SIGN, CryptogramUtil.encryptMD5(stringBuffer.toString()));
            LogUtils.e("==================================================Login  start");
            return map;
        }

        @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.HttpInterface
        public void parseResponse(String str) throws JSONException {
            LogUtils.e("==================================================Login  end");
            try {
                JSONObject jSONObject = new JSONObject(str);
                int i2 = jSONObject.getInt("code");
                if (i2 == 200) {
                    UserMsgBean userMsgBean = (UserMsgBean) UserManager.this.gson.fromJson(str, UserMsgBean.class);
                    UserManager.this.userInfo.setUserId(userMsgBean.getData().getUserId());
                    UserManager.this.userInfo.setUserName(userMsgBean.getData().getUserName());
                    UserManager.this.userInfo.setUserType(userMsgBean.getData().getUserType());
                    UserManager.this.userInfo.setAccountType(userMsgBean.getData().getAccountType());
                    UserManager.this.userInfo.setEmail(userMsgBean.getData().getEmail());
                    UserManager.this.userInfo.setClientDate(String.valueOf(System.currentTimeMillis()));
                    LoginInfo loginInfo = new LoginInfo();
                    loginInfo.setAppId(UserManager.this.configBean.getAppId());
                    loginInfo.setClientDate(String.valueOf(System.currentTimeMillis()));
                    loginInfo.setUserId(userMsgBean.getData().getUserId());
                    Response.getInstance().setToken(userMsgBean.getToken());
                    Response.getInstance().setUserInfo(UserManager.this.userInfo);
                    PBvElADcPX.insertOrUpdateLogin(loginInfo);
                    PBvElADcPX.insertOrUpdateUser(UserManager.this.userInfo, false);
                    UserManager.this.netParamsBean.setFirstLogin(userMsgBean.getData().getFirstLogin() == 1);
                    UserManager.this.handler.sendEmptyMessage(0);
                } else {
                    UserManager.this.code = i2;
                    UserManager.this.msg = jSONObject.getString("error_msg");
                    UserManager.this.handler.sendEmptyMessage(1);
                }
            } catch (JSONException e2) {
                LogUtils.e(e2.getMessage());
                UserManager.this.msg = e2.getMessage();
                UserManager.this.code = 111111;
                UserManager.this.handler.sendEmptyMessage(1);
            }
        }
    }

    private class MakeOrder implements HttpInterface {
        private MakeOrder() {
        }

        @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.HttpInterface
        public Map<String, Object> getMap() throws JSONException {
            RfybaJKCLilYpc choosePayChannel = Response.getInstance().getChoosePayChannel();
            HashMap map = new HashMap();
            map.put("appId", Integer.valueOf(UserManager.this.configBean.getAppId()));
            map.put(DataUtil.ORDER_COLUMN.ORDER_ADV_CHANNEL, UserManager.this.configBean.getAdvChannel());
            map.put("userId", Integer.valueOf(UserManager.this.userInfo.getUserId()));
            map.put(DataUtil.ORDER_COLUMN.ORDER_GAME_ORDER_ID, UserManager.this.payBean.getGameOrderId());
            map.put(DataUtil.ORDER_COLUMN.ORDER_GAME_ZONE_ID, UserManager.this.payBean.getGameZoneId());
            map.put(DataUtil.ORDER_COLUMN.ORDER_ROLE_ID, UserManager.this.payBean.getRoleId());
            map.put("roleName", UserManager.this.payBean.getRoleName());
            map.put("level", UserManager.this.payBean.getLevel());
            map.put("channel", choosePayChannel.getChannel());
            map.put("code", choosePayChannel.getCode());
            map.put(DataUtil.ORDER_LIST_COLUMN.AMOUNT, choosePayChannel.getSelectedProduct().getAmount());
            map.put(DataUtil.ORDER_LIST_COLUMN.CURRENCY, choosePayChannel.getSelectedProduct().getCurrency());
            map.put("productName", choosePayChannel.getSelectedProduct().getProductName());
            UserManager.this.putDeviceMsg(map);
            map.put("isOfficial", Integer.valueOf(choosePayChannel.getIsOfficial()));
            map.put("itemType", Integer.valueOf(choosePayChannel.getSelectedProduct().getItemType()));
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("serialNo", UserManager.this.netParamsBean.getCardNumber());
                jSONObject.put("pin", UserManager.this.netParamsBean.getCardPassword());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            map.put("exInfo", jSONObject.toString());
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(map.get("appId"));
            stringBuffer.append(map.get(DataUtil.ORDER_COLUMN.ORDER_ADV_CHANNEL));
            stringBuffer.append(map.get("userId"));
            stringBuffer.append(map.get(DataUtil.ORDER_COLUMN.ORDER_ROLE_ID));
            stringBuffer.append(map.get(DataUtil.ORDER_COLUMN.ORDER_GAME_ORDER_ID));
            stringBuffer.append(map.get(DataUtil.ORDER_COLUMN.ORDER_GAME_ZONE_ID));
            stringBuffer.append(map.get("code"));
            stringBuffer.append(map.get("source"));
            stringBuffer.append(map.get("channel"));
            stringBuffer.append(map.get(DataUtil.ORDER_LIST_COLUMN.AMOUNT));
            stringBuffer.append(map.get(DataUtil.ORDER_LIST_COLUMN.CURRENCY));
            stringBuffer.append(map.get("productName"));
            stringBuffer.append(map.get("exInfo"));
            stringBuffer.append(UserManager.this.configBean.getAppKey());
            map.put(DataUtil.ORDER_COLUMN.ORDER_SIGN, CryptogramUtil.encryptMD5(stringBuffer.toString()));
            return map;
        }

        @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.HttpInterface
        public void parseResponse(String str) throws JSONException {
            try {
                LogUtils.e("make order response==========================" + str);
                JSONObject jSONObject = new JSONObject(str);
                Gson gson = new Gson();
                int i2 = jSONObject.getInt("code");
                if (i2 != 200) {
                    UserManager.this.code = i2;
                    UserManager.this.handler.sendEmptyMessage(1);
                    return;
                }
                JSONObject jSONObject2 = jSONObject.getJSONObject(ShareConstants.WEB_DIALOG_PARAM_DATA);
                if (jSONObject2.has("returnInfo")) {
                    UserManager.this.netParamsBean.setPaymentUrl(((ServerReturnInfo) gson.fromJson(jSONObject2.getString("returnInfo"), ServerReturnInfo.class)).getUrl());
                }
                UserManager.this.netParamsBean.setPlatTransactionId(jSONObject2.optString("transactionId"));
                String strOptString = jSONObject2.optString("money");
                UserManager.this.netParamsBean.setMoney(Double.valueOf(strOptString.equals("") ? 0.0d : Double.parseDouble(strOptString)));
                UserManager.this.netParamsBean.setCurrency(jSONObject2.optString(DataUtil.ORDER_LIST_COLUMN.CURRENCY));
                UserManager.this.handler.sendEmptyMessage(0);
            } catch (Exception e2) {
                UserManager.this.msg = e2.getMessage();
                UserManager.this.code = PluginNXUfldNktBOT.ERROR_CONSUME_OR_PAY;
                UserManager.this.handler.sendEmptyMessage(1);
            }
        }
    }

    public class Register implements HttpInterface {
        public Register() {
        }

        @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.HttpInterface
        public Map<String, Object> getMap() {
            HashMap map = new HashMap();
            map.put("appId", Integer.valueOf(UserManager.this.configBean.getAppId()));
            map.put(DataUtil.USER_COLUMN.USERNAME, UserManager.this.userInfo.getUserName());
            map.put(DataUtil.USER_COLUMN.PASSWORD, UserManager.this.userInfo.getPassword());
            map.put("email", UserManager.this.userInfo.getEmail());
            map.put(DataUtil.USER_COLUMN.THIRDPARTYID, UserManager.this.netParamsBean.getThirdPartyId());
            map.put(DataUtil.USER_COLUMN.ACCOUNT_TYPE, Integer.valueOf(UserManager.this.userInfo.getAccountType()));
            map.put("userChannel", 0);
            map.put(DataUtil.ORDER_COLUMN.ORDER_ADV_CHANNEL, UserManager.this.configBean.getAdvChannel());
            UserManager.this.putDeviceMsg(map);
            map.put("exInfo", UserManager.this.netParamsBean.getExInfo());
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(map.get("appId"));
            stringBuffer.append(map.get(DataUtil.USER_COLUMN.USERNAME));
            stringBuffer.append(map.get(DataUtil.USER_COLUMN.PASSWORD));
            stringBuffer.append(map.get("source"));
            stringBuffer.append(UserManager.this.configBean.getAppKey());
            map.put(DataUtil.ORDER_COLUMN.ORDER_SIGN, CryptogramUtil.encryptMD5(stringBuffer.toString()));
            LogUtils.e("==================================================Register  start");
            return map;
        }

        @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.HttpInterface
        public void parseResponse(String str) throws JSONException {
            LogUtils.e("==================================================Register  end");
            try {
                JSONObject jSONObject = new JSONObject(str);
                int i2 = jSONObject.getInt("code");
                if (i2 == 200) {
                    UserMsgBean userMsgBean = (UserMsgBean) UserManager.this.gson.fromJson(str, UserMsgBean.class);
                    UserManager.this.userInfo.setUserId(userMsgBean.getData().getUserId());
                    UserManager.this.userInfo.setUserName(userMsgBean.getData().getUserName());
                    UserManager.this.userInfo.setUserType(userMsgBean.getData().getUserType());
                    UserManager.this.userInfo.setAccountType(userMsgBean.getData().getAccountType());
                    UserManager.this.userInfo.setEmail(userMsgBean.getData().getEmail());
                    UserManager.this.userInfo.setClientDate(String.valueOf(System.currentTimeMillis()));
                    LoginInfo loginInfo = new LoginInfo();
                    loginInfo.setAppId(UserManager.this.configBean.getAppId());
                    loginInfo.setClientDate(String.valueOf(System.currentTimeMillis()));
                    loginInfo.setUserId(userMsgBean.getData().getUserId());
                    Response.getInstance().setToken(userMsgBean.getToken());
                    Response.getInstance().setUserInfo(UserManager.this.userInfo);
                    PBvElADcPX.insertOrUpdateLogin(loginInfo);
                    PBvElADcPX.insertOrUpdateUser(UserManager.this.userInfo, false);
                    UserManager.this.netParamsBean.setFirstLogin(userMsgBean.getData().getFirstLogin() == 1);
                    UserManager.this.handler.sendEmptyMessage(0);
                } else {
                    UserManager.this.code = i2;
                    UserManager.this.msg = jSONObject.getString("error_msg");
                    UserManager.this.handler.sendEmptyMessage(1);
                    Response.getInstance().setUserInfo(null);
                }
            } catch (Exception e2) {
                LogUtils.e(e2.getMessage());
                UserManager.this.msg = e2.getMessage();
                UserManager.this.code = 111111;
                UserManager.this.handler.sendEmptyMessage(1);
                Response.getInstance().setUserInfo(null);
            }
        }
    }

    public class RequestProducts implements HttpInterface {
        public RequestProducts() {
        }

        @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.HttpInterface
        public Map<String, Object> getMap() {
            HashMap map = new HashMap();
            map.put("appId", Integer.valueOf(UserManager.this.configBean.getAppId()));
            map.put("userId", Integer.valueOf(UserManager.this.userInfo.getUserId()));
            map.put("source", 1);
            map.put(DataUtil.ORDER_COLUMN.ORDER_ADV_CHANNEL, UserManager.this.configBean.getAdvChannel());
            map.put(DataUtil.ORDER_COLUMN.ORDER_NET_WORK, Integer.valueOf(1 ^ (NetWorkUtil.isWifiConnect(UserManager.this.context) ? 1 : 0)));
            map.put("level", UserManager.this.payBean.getLevel() == null ? "" : UserManager.this.payBean.getLevel());
            map.put("version", DeviceUtil.getVersion(UserManager.this.context));
            map.put("gameCoin", Integer.valueOf(UserManager.this.payBean.getGameCoin()));
            map.put(DataUtil.ORDER_COLUMN.ORDER_ROLE_ID, UserManager.this.payBean.getRoleId());
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(map.get("appId"));
            stringBuffer.append(map.get(DataUtil.ORDER_COLUMN.ORDER_ADV_CHANNEL));
            stringBuffer.append(map.get("userId"));
            stringBuffer.append(map.get("gameCoin"));
            stringBuffer.append(map.get("level"));
            stringBuffer.append(map.get("source"));
            stringBuffer.append(map.get(DataUtil.ORDER_COLUMN.ORDER_NET_WORK));
            stringBuffer.append(UserManager.this.configBean.getAppKey());
            map.put(DataUtil.ORDER_COLUMN.ORDER_SIGN, CryptogramUtil.encryptMD5(stringBuffer.toString()));
            LogUtils.e("==================================================RequestProducts  start");
            return map;
        }

        @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.HttpInterface
        public void parseResponse(String str) throws JSONException {
            LogUtils.e("==================================================RequestProducts  end");
            try {
                JSONObject jSONObject = new JSONObject(str);
                int i2 = jSONObject.getInt("code");
                if (i2 != 200) {
                    UserManager.this.code = i2;
                    UserManager.this.msg = jSONObject.getString("error_msg");
                    UserManager.this.handler.sendEmptyMessage(1);
                    return;
                }
                if (jSONObject.has("payments")) {
                    Response.getInstance().setPayChannelList((List) UserManager.this.gson.fromJson(jSONObject.getString("payments"), new TypeToken<List<RfybaJKCLilYpc>>() { // from class: com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager.RequestProducts.1
                    }.getType()));
                }
                UserManager.this.handler.sendEmptyMessage(0);
            } catch (Exception e2) {
                LogUtils.e(e2.getMessage());
                UserManager.this.msg = e2.getMessage();
                UserManager.this.code = 111111;
                UserManager.this.handler.sendEmptyMessage(1);
            }
        }
    }

    public class ResetPsw implements HttpInterface {
        public ResetPsw() {
        }

        @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.HttpInterface
        public Map<String, Object> getMap() {
            HashMap map = new HashMap();
            map.put("appId", Integer.valueOf(UserManager.this.configBean.getAppId()));
            map.put(DataUtil.USER_COLUMN.USERNAME, UserManager.this.userInfo.getUserName());
            map.put("newPassword", CryptogramUtil.encryptMD5(UserManager.this.netParamsBean.getNewPassword()));
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(map.get("newPassword"));
            stringBuffer.append(map.get(DataUtil.USER_COLUMN.USERNAME));
            stringBuffer.append(map.get("appId"));
            stringBuffer.append(UserManager.this.configBean.getAppKey());
            map.put(DataUtil.ORDER_COLUMN.ORDER_SIGN, CryptogramUtil.encryptMD5(stringBuffer.toString()));
            return map;
        }

        @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.HttpInterface
        public void parseResponse(String str) throws JSONException {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int i2 = jSONObject.getInt("code");
                if (i2 == 200) {
                    UserManager.this.handler.sendEmptyMessage(0);
                } else {
                    UserManager.this.code = i2;
                    UserManager.this.msg = jSONObject.getString("error_msg");
                    UserManager.this.handler.sendEmptyMessage(1);
                }
            } catch (Exception e2) {
                LogUtils.e(e2.getMessage());
                UserManager.this.msg = e2.getMessage();
                UserManager.this.code = 111111;
                UserManager.this.handler.sendEmptyMessage(1);
            }
        }
    }

    public enum Type {
        INIT,
        LOGIN,
        REGISTER,
        FORGETPSW,
        CHECKVALIDCODE,
        RESETPSW,
        CHANGEPSW,
        BINDVISITOR,
        CHARGEDETAIL,
        CHARGELIST,
        BINDZONE,
        REQUESTPRODUCTS,
        UPLOADSOCIAL,
        CHECKPWD,
        BINDEMAIL,
        INITIABHELPER,
        MAKEORDER,
        CONSUMEORDER,
        CHECKAPPSTATUS,
        CANCELACCADDR
    }

    public class UploadSocial implements HttpInterface {
        public UploadSocial() {
        }

        @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.HttpInterface
        public Map<String, Object> getMap() {
            HashMap map = new HashMap();
            map.put("appId", Integer.valueOf(UserManager.this.configBean.getAppId()));
            map.put(DataUtil.ORDER_COLUMN.ORDER_ADV_CHANNEL, UserManager.this.configBean.getAdvChannel());
            map.put("userId", Integer.valueOf(UserManager.this.userInfo.getUserId()));
            map.put("platform", UserManager.this.netParamsBean.getPlatform());
            map.put("operator", Integer.valueOf(UserManager.this.netParamsBean.getOperator()));
            map.put("description", UserManager.this.netParamsBean.getDescription());
            UserManager.this.putDeviceMsg(map);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(map.get("operator"));
            stringBuffer.append(map.get("appId"));
            stringBuffer.append(map.get("source"));
            stringBuffer.append(map.get("platform"));
            stringBuffer.append(map.get(DataUtil.ORDER_COLUMN.ORDER_ADV_CHANNEL));
            stringBuffer.append(UserManager.this.configBean.getAppKey());
            map.put(DataUtil.ORDER_COLUMN.ORDER_SIGN, CryptogramUtil.encryptMD5(stringBuffer.toString()));
            return map;
        }

        @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.HttpInterface
        public void parseResponse(String str) throws JSONException {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int i2 = jSONObject.getInt("code");
                if (i2 == 200) {
                    LogUtils.e("上传社会化数据成功");
                    UserManager.this.handler.sendEmptyMessage(0);
                } else {
                    UserManager.this.code = i2;
                    UserManager.this.msg = jSONObject.getString("error_msg");
                    UserManager.this.handler.sendEmptyMessage(1);
                }
            } catch (Exception e2) {
                LogUtils.e(e2.getMessage());
                UserManager.this.msg = e2.getMessage();
                UserManager.this.code = 111111;
                UserManager.this.handler.sendEmptyMessage(1);
            }
        }
    }

    public UserManager(Type type) {
        byte b2 = 0;
        byte b3 = 0;
        byte b4 = 0;
        switch (AnonymousClass2.$SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$mcluykfz$UserManager$Type[type.ordinal()]) {
            case 1:
                this.netClass = new Init();
                break;
            case 2:
                this.netClass = new Login();
                break;
            case 3:
                this.netClass = new Register();
                break;
            case 4:
                this.netClass = new ForgetPsw();
                break;
            case 5:
                this.netClass = new CheckValidCode();
                break;
            case 6:
                this.netClass = new ResetPsw();
                break;
            case 7:
                this.netClass = new ChangePsw();
                break;
            case 8:
                this.netClass = new BindVisitor();
                break;
            case 9:
                this.netClass = new GetChargeDetail();
                break;
            case 10:
                this.netClass = new GetChargeList();
                break;
            case 11:
                this.netClass = new BindZone();
                break;
            case 12:
                this.netClass = new UploadSocial();
                break;
            case 13:
                this.netClass = new CheckPWD();
                break;
            case 14:
                this.netClass = new BindEmail();
                break;
            case 15:
                this.netClass = new Initiabhelper();
                break;
            case 16:
                this.netClass = new RequestProducts();
                break;
            case 17:
                this.netClass = new MakeOrder();
                break;
            case 18:
                this.netClass = new ConsumeOrder();
                break;
            case 19:
                this.netClass = new CheckAppStatus();
                break;
            case 20:
                this.netClass = new CancelAccAddr();
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> putDeviceMsg(Map<String, Object> map) {
        map.put(DataUtil.ORDER_COLUMN.ORDER_DEVICE_NO, DeviceUtil.getDeviceId(this.context));
        map.put("device", DeviceUtil.getLocalMacAddress(this.context));
        map.put(DataUtil.ORDER_COLUMN.ORDER_NET_WORK, Integer.valueOf(!NetWorkUtil.isWifiConnect(this.context) ? 1 : 0));
        map.put("model", Build.MODEL);
        map.put(DataUtil.ORDER_COLUMN.ORDER_OPERATOR_OS, "android" + Build.VERSION.RELEASE + "#" + DeviceUtil.getWifiName(this.context) + "#" + DeviceUtil.getWifiInsideIpAddress(this.context));
        map.put("version", DeviceUtil.getVersion(this.context));
        map.put("sdkVersion", "4.5.1");
        map.put("clientTime", DateUtil.getTimeStringFormat(new Date(), "yyyy-MM-dd HH:mm:ss"));
        map.put("source", Integer.valueOf(ConstantUtil.SOURCE_ANDROID));
        return map;
    }

    public abstract void fail(int i2, String str);

    public HttpInterface getNetClass() {
        return this.netClass;
    }

    public abstract void response(Response response);
}
