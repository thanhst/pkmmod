package com.sfyvctwaqbjhki.uwmpqfh.mcluykfz;

import com.sfyvctwaqbjhki.uwmpqfh.biohep.HttpNetWork;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.LogUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class NetManager {
    private static NetManager instance;
    private boolean isStop = false;

    public static NetManager getInstance() {
        if (instance == null) {
            instance = new NetManager();
        }
        return instance;
    }

    private Map<String, Object> joinPublic(Map<String, Object> map) {
        return map;
    }

    public void doGetRequest(String str, final UserManager userManager) {
        this.isStop = false;
        HttpNetWork.asyncConnect(str, joinPublic(userManager.getNetClass().getMap()), HttpNetWork.HttpMethod.GET, new HttpNetWork.HttpConnectionCallback() { // from class: com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.NetManager.2
            @Override // com.sfyvctwaqbjhki.uwmpqfh.biohep.HttpNetWork.HttpConnectionCallback
            public void onComplete(String str2) {
                if (NetManager.this.isStop) {
                    return;
                }
                LogUtils.e(str2);
                userManager.getNetClass().parseResponse(str2);
            }

            @Override // com.sfyvctwaqbjhki.uwmpqfh.biohep.HttpNetWork.HttpConnectionCallback
            public void onFault(String str2) throws JSONException {
                LogUtils.e("request error: " + str2);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", 111111);
                    jSONObject.put("error_msg", str2);
                    userManager.getNetClass().parseResponse(jSONObject.toString());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    public void doPostRequest(String str, final UserManager userManager) {
        this.isStop = false;
        HttpNetWork.asyncConnect(str, joinPublic(userManager.getNetClass().getMap()), HttpNetWork.HttpMethod.POST, new HttpNetWork.HttpConnectionCallback() { // from class: com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.NetManager.1
            @Override // com.sfyvctwaqbjhki.uwmpqfh.biohep.HttpNetWork.HttpConnectionCallback
            public void onComplete(String str2) {
                if (NetManager.this.isStop) {
                    return;
                }
                LogUtils.e(str2);
                userManager.getNetClass().parseResponse(str2);
            }

            @Override // com.sfyvctwaqbjhki.uwmpqfh.biohep.HttpNetWork.HttpConnectionCallback
            public void onFault(String str2) throws JSONException {
                LogUtils.e("request error: " + str2);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", 111111);
                    jSONObject.put("error_msg", str2);
                    userManager.getNetClass().parseResponse(jSONObject.toString());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    public String getUrlHead() {
        return Response.getInstance().getConfigBean().getUrl() + "/pocketgames/client/";
    }

    public boolean isStoped() {
        return this.isStop;
    }

    public void stopNet() {
        this.isStop = true;
    }
}
