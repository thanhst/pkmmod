package com.sfyvctwaqbjhki.uwmpqfh.mcluykfz;

import com.sfyvctwaqbjhki.uwmpqfh.WoUjMp;
import com.sfyvctwaqbjhki.uwmpqfh.biohepbeans.EDakAXiM;
import com.sfyvctwaqbjhki.uwmpqfh.biohepbeans.NyEzqrsNTxQL;
import com.sfyvctwaqbjhki.uwmpqfh.biohepbeans.RfybaJKCLilYpc;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.ConfigBean;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.GameRoleBean;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.NetParamsBean;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.UGuwCakoQHjtD;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.UserInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class Response {
    private static Response instance;
    private RfybaJKCLilYpc choosePayChannel;
    private ConfigBean configBean;
    private GameRoleBean gameRoleBean;
    private EDakAXiM initConfigBean;
    private int isCheck = 1;
    private NetParamsBean netParamsBean;
    private UGuwCakoQHjtD payBean;
    private List<RfybaJKCLilYpc> payChannelList;
    private NyEzqrsNTxQL platformBean;
    private String token;
    private UserInfo userInfo;

    public static Response getInstance() {
        if (instance == null) {
            instance = new Response();
        }
        return instance;
    }

    public RfybaJKCLilYpc getChoosePayChannel() {
        if (this.choosePayChannel == null) {
            this.choosePayChannel = new RfybaJKCLilYpc();
        }
        return this.choosePayChannel;
    }

    public ConfigBean getConfigBean() {
        if (this.configBean == null) {
            this.configBean = YPQkALXcGtOUj.createConfigBean(WoUjMp.getInstance().getContext());
        }
        return this.configBean;
    }

    public EDakAXiM getEDakAXiM() {
        return this.initConfigBean;
    }

    public GameRoleBean getGameRoleBean() {
        if (this.gameRoleBean == null) {
            this.gameRoleBean = new GameRoleBean();
        }
        return this.gameRoleBean;
    }

    public int getIsCheck() {
        return this.isCheck;
    }

    public NetParamsBean getNetParamsBean() {
        if (this.netParamsBean == null) {
            this.netParamsBean = new NetParamsBean();
        }
        return this.netParamsBean;
    }

    public List<RfybaJKCLilYpc> getPayChannelList() {
        if (this.payChannelList == null) {
            this.payChannelList = new ArrayList();
        }
        return this.payChannelList;
    }

    public NyEzqrsNTxQL getPlatformBean() {
        return this.platformBean;
    }

    public String getToken() {
        return this.token;
    }

    public UGuwCakoQHjtD getUGuwCakoQHjtD() {
        return this.payBean;
    }

    public UserInfo getUserInfo() {
        return this.userInfo;
    }

    public void setChoosePayChannel(RfybaJKCLilYpc rfybaJKCLilYpc) {
        this.choosePayChannel = rfybaJKCLilYpc;
    }

    public void setConfigBean(ConfigBean configBean) {
        this.configBean = configBean;
    }

    public void setEDakAXiM(EDakAXiM eDakAXiM) {
        this.initConfigBean = eDakAXiM;
    }

    public void setGameRoleBean(GameRoleBean gameRoleBean) {
        this.gameRoleBean = gameRoleBean;
    }

    public void setIsCheck(int i2) {
        this.isCheck = i2;
    }

    public void setNetParamsBean(NetParamsBean netParamsBean) {
        this.netParamsBean = netParamsBean;
    }

    public void setPayChannelList(List<RfybaJKCLilYpc> list) {
        this.payChannelList = list;
    }

    public void setPlatformBean(NyEzqrsNTxQL nyEzqrsNTxQL) {
        this.platformBean = nyEzqrsNTxQL;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setUGuwCakoQHjtD(UGuwCakoQHjtD uGuwCakoQHjtD) {
        this.payBean = uGuwCakoQHjtD;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
