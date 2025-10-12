package com.ykiocnwpdseglq.lbmntzwepqakgu.manager;

import com.ykiocnwpdseglq.lbmntzwepqakgu.beans.OpHzXGktYUTIAhi;
import com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.DIUGfDWQpOJHLr;
import com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.VKiwrnDgpL;
import com.ykiocnwpdseglq.lbmntzwepqakgu.utils.ClsTool;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class PluginFactory {
    private static PluginFactory instance;
    private Map<OpHzXGktYUTIAhi, VKiwrnDgpL> analPluginsObjects;
    private Map<OpHzXGktYUTIAhi, DIUGfDWQpOJHLr> payPluginsObjects;
    private Map<OpHzXGktYUTIAhi, String> pluginsMap;
    private Map<OpHzXGktYUTIAhi, Object> pluginsObjects;

    public PluginFactory() {
        init();
    }

    private void createPluginObjects() {
        this.pluginsObjects = new HashMap();
        for (Map.Entry<OpHzXGktYUTIAhi, String> entry : this.pluginsMap.entrySet()) {
            Object clzObject = ClsTool.getClzObject(entry.getValue());
            if (clzObject != null) {
                this.pluginsObjects.put(entry.getKey(), clzObject);
            }
        }
    }

    public static PluginFactory getInstance() {
        if (instance == null) {
            instance = new PluginFactory();
        }
        return instance;
    }

    private void init() {
        HashMap map = new HashMap();
        this.pluginsMap = map;
        map.put(OpHzXGktYUTIAhi.FACEBOOK_PLUGIN, "com.ykiocnwpdseglq.nhvkwyj.BNvGRxpPTguECUw");
        this.pluginsMap.put(OpHzXGktYUTIAhi.KAKAO_PLUGIN, "com.ykiocnwpdseglq.kakaosdk.RgKakaoSDK");
        this.pluginsMap.put(OpHzXGktYUTIAhi.GOOGLE_LOGIN_PLUGIN, "com.ykiocnwpdseglq.ggloginsdk.RgGoogleLoginSDK");
        this.pluginsMap.put(OpHzXGktYUTIAhi.ADJUST_PLUGIN, "com.ykiocnwpdseglq.nrapvku.QUXOdDKrcTYluo");
        this.pluginsMap.put(OpHzXGktYUTIAhi.APPSFLYER_PLUGIN, "com.ykiocnwpdseglq.appsflyersdk.RgAppsflyerSDK");
        this.pluginsMap.put(OpHzXGktYUTIAhi.FIRBASE_PLUGIN, "com.ykiocnwpdseglq.firelbmntzwepqakgu.RgFirebaseSDK");
        this.pluginsMap.put(OpHzXGktYUTIAhi.ONE_STORE_PLUGIN, "com.ykiocnwpdseglq.onestoresdk.RgOneStoreSDK");
        this.pluginsMap.put(OpHzXGktYUTIAhi.GOOGLE_PAY_PLUGIN, "com.ykiocnwpdseglq.cubgy.SiZkzMHDLVcpA");
        this.pluginsMap.put(OpHzXGktYUTIAhi.HW_PLUGIN, "com.ykiocnwpdseglq.huaweisdk.RgHuaweiSDK");
        createPluginObjects();
    }

    public Map<OpHzXGktYUTIAhi, VKiwrnDgpL> getAllAnalPluginsObjects() {
        if (this.analPluginsObjects == null) {
            this.analPluginsObjects = new HashMap();
            for (Map.Entry<OpHzXGktYUTIAhi, Object> entry : getAllPluginObjects().entrySet()) {
                if (entry.getValue() instanceof VKiwrnDgpL) {
                    this.analPluginsObjects.put(entry.getKey(), (VKiwrnDgpL) entry.getValue());
                }
            }
        }
        return this.analPluginsObjects;
    }

    public Map<OpHzXGktYUTIAhi, DIUGfDWQpOJHLr> getAllPayPluginObjects() {
        if (this.payPluginsObjects == null) {
            this.payPluginsObjects = new HashMap();
            for (Map.Entry<OpHzXGktYUTIAhi, Object> entry : getAllPluginObjects().entrySet()) {
                if (entry.getValue() instanceof DIUGfDWQpOJHLr) {
                    this.payPluginsObjects.put(entry.getKey(), (DIUGfDWQpOJHLr) entry.getValue());
                }
            }
        }
        return this.payPluginsObjects;
    }

    public Map<OpHzXGktYUTIAhi, Object> getAllPluginObjects() {
        if (this.pluginsObjects == null) {
            createPluginObjects();
        }
        return this.pluginsObjects;
    }

    public Object getPluginObject(OpHzXGktYUTIAhi opHzXGktYUTIAhi) {
        if (this.pluginsObjects.containsKey(opHzXGktYUTIAhi) && this.pluginsObjects.get(opHzXGktYUTIAhi) != null) {
            return this.pluginsObjects.get(opHzXGktYUTIAhi);
        }
        Object clzObject = ClsTool.getClzObject(this.pluginsMap.get(opHzXGktYUTIAhi));
        if (clzObject != null) {
            this.pluginsObjects.put(opHzXGktYUTIAhi, clzObject);
        }
        return clzObject;
    }

    public boolean isPluginExist(OpHzXGktYUTIAhi opHzXGktYUTIAhi) {
        return ClsTool.getClz(this.pluginsMap.get(opHzXGktYUTIAhi)) != null;
    }
}
