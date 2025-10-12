package com.sfyvctwaqbjhki.uwmpqfh.mcluykfz;

import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.ConstantUtil;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.CryptogramUtil;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.LogUtils;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.VwEiglxMTZuLV;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.NetParamsBean;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.UserInfo;
import com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI;
import com.ykiocnwpdseglq.lbmntzwepqakgu.ReDqOTXKRs;
import com.ykiocnwpdseglq.lbmntzwepqakgu.beans.CommLoginResult;
import com.ykiocnwpdseglq.lbmntzwepqakgu.beans.FbLoginResult;
import com.ykiocnwpdseglq.lbmntzwepqakgu.beans.OpHzXGktYUTIAhi;
import com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.LoginCallBack;

/* loaded from: classes.dex */
public class ThreeLoginManager {
    private static ThreeLoginManager instance;
    private NetParamsBean mNetParamsBean;
    private UserInfo mUserInfo;

    public static ThreeLoginManager getInstance() {
        if (instance == null) {
            instance = new ThreeLoginManager();
        }
        return instance;
    }

    public void facebookLogin(final SLdJjpRXaI sLdJjpRXaI) {
        OpHzXGktYUTIAhi opHzXGktYUTIAhi = OpHzXGktYUTIAhi.FACEBOOK_PLUGIN;
        if (ReDqOTXKRs.isPluginExist(opHzXGktYUTIAhi)) {
            ReDqOTXKRs.login(opHzXGktYUTIAhi, sLdJjpRXaI.getContext(), new LoginCallBack<FbLoginResult>() { // from class: com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.ThreeLoginManager.2
                @Override // com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.LoginCallBack
                public void onCancel() {
                    LogUtils.e("fb login cancel");
                }

                @Override // com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.LoginCallBack
                public void onError(String str) {
                    LogUtils.e("fb login happen error");
                }

                @Override // com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.LoginCallBack
                public void onSuccess(FbLoginResult fbLoginResult) {
                    ThreeLoginManager.this.mUserInfo = new UserInfo();
                    ThreeLoginManager.this.mNetParamsBean = new NetParamsBean();
                    String nickName = fbLoginResult.getNickName();
                    String str = fbLoginResult.getThirdId() + "oneFlower1WorldOneLeaf1Bodhi";
                    ThreeLoginManager.this.mUserInfo.setNickName(nickName);
                    ThreeLoginManager.this.mUserInfo.setAccountType(ConstantUtil.ACCOUNTTYPE_FACEBOOK);
                    ThreeLoginManager.this.mUserInfo.setUserType(ConstantUtil.USER_TYPE_POSITIVE);
                    ThreeLoginManager.this.mUserInfo.setEmail(fbLoginResult.getEmail());
                    ThreeLoginManager.this.mUserInfo.setUserName("fb-" + fbLoginResult.getThirdId());
                    ThreeLoginManager.this.mUserInfo.setPassword(CryptogramUtil.encryptMD5(str));
                    ThreeLoginManager.this.mUserInfo.setBasepwd(str);
                    ThreeLoginManager.this.mNetParamsBean.setThirdPartyId(fbLoginResult.getThirdId());
                    ThreeLoginManager.this.mNetParamsBean.setExInfo(fbLoginResult.getFbBusinessMapStr());
                    ThreeLoginManager.this.mNetParamsBean.setAutoLogin(false);
                    Response.getInstance().setUserInfo(ThreeLoginManager.this.mUserInfo);
                    Response.getInstance().setNetParamsBean(ThreeLoginManager.this.mNetParamsBean);
                    SLdJjpRXaI sLdJjpRXaI2 = sLdJjpRXaI;
                    sLdJjpRXaI2.jumpToActivity(new VwEiglxMTZuLV(sLdJjpRXaI2.getContext()));
                }
            });
        } else {
            LogUtils.e("facebook plugin is not exist!!");
        }
    }

    public void googlePlayLogin(final SLdJjpRXaI sLdJjpRXaI) {
        OpHzXGktYUTIAhi opHzXGktYUTIAhi = OpHzXGktYUTIAhi.GOOGLE_LOGIN_PLUGIN;
        if (ReDqOTXKRs.isPluginExist(opHzXGktYUTIAhi)) {
            ReDqOTXKRs.login(opHzXGktYUTIAhi, sLdJjpRXaI.getContext(), new LoginCallBack<CommLoginResult>() { // from class: com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.ThreeLoginManager.1
                @Override // com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.LoginCallBack
                public void onCancel() {
                    LogUtils.e("google login happen cancel");
                }

                @Override // com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.LoginCallBack
                public void onError(String str) {
                    LogUtils.e("google login happen error");
                }

                @Override // com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.LoginCallBack
                public void onSuccess(CommLoginResult commLoginResult) {
                    UserInfo userInfo = new UserInfo();
                    userInfo.setNickName(commLoginResult.getNickName() == null ? commLoginResult.getEmail() : commLoginResult.getNickName());
                    userInfo.setAccountType(ConstantUtil.ACCOUNTTYPE_GOOGLE);
                    userInfo.setUserType(ConstantUtil.USER_TYPE_POSITIVE);
                    userInfo.setEmail(commLoginResult.getEmail());
                    userInfo.setUserName(commLoginResult.getThirdId() + "@google");
                    userInfo.setPassword(CryptogramUtil.encryptMD5(commLoginResult.getThirdId() + "oneFlower1WorldOneLeaf1Bodhi"));
                    userInfo.setBasepwd(commLoginResult.getThirdId() + "oneFlower1WorldOneLeaf1Bodhi");
                    NetParamsBean netParamsBean = new NetParamsBean();
                    netParamsBean.setAutoLogin(false);
                    netParamsBean.setThirdPartyId(String.valueOf(commLoginResult.getThirdId()));
                    Response.getInstance().setUserInfo(userInfo);
                    Response.getInstance().setNetParamsBean(netParamsBean);
                    SLdJjpRXaI sLdJjpRXaI2 = sLdJjpRXaI;
                    sLdJjpRXaI2.jumpToActivity(new VwEiglxMTZuLV(sLdJjpRXaI2.getContext()));
                }
            });
        } else {
            LogUtils.e("google plugin is not exist!!");
        }
    }

    public void kakaoLogin(final SLdJjpRXaI sLdJjpRXaI) {
        OpHzXGktYUTIAhi opHzXGktYUTIAhi = OpHzXGktYUTIAhi.KAKAO_PLUGIN;
        if (ReDqOTXKRs.isPluginExist(opHzXGktYUTIAhi)) {
            ReDqOTXKRs.login(opHzXGktYUTIAhi, sLdJjpRXaI.getContext(), new LoginCallBack<CommLoginResult>() { // from class: com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.ThreeLoginManager.3
                @Override // com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.LoginCallBack
                public void onCancel() {
                    LogUtils.e("kakao login happen cancel");
                }

                @Override // com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.LoginCallBack
                public void onError(String str) {
                    LogUtils.e("kakao login happen error");
                }

                @Override // com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.LoginCallBack
                public void onSuccess(CommLoginResult commLoginResult) {
                    UserInfo userInfo = new UserInfo();
                    userInfo.setNickName(commLoginResult.getNickName() == null ? commLoginResult.getEmail() : commLoginResult.getNickName());
                    userInfo.setAccountType(ConstantUtil.ACCOUNTTYPE_KAKAO);
                    userInfo.setUserType(ConstantUtil.USER_TYPE_POSITIVE);
                    userInfo.setEmail(commLoginResult.getEmail());
                    userInfo.setUserName("kakao-" + commLoginResult.getThirdId());
                    userInfo.setPassword(CryptogramUtil.encryptMD5(commLoginResult.getThirdId() + "oneFlower1WorldOneLeaf1Bodhi"));
                    userInfo.setBasepwd(commLoginResult.getThirdId() + "oneFlower1WorldOneLeaf1Bodhi");
                    NetParamsBean netParamsBean = new NetParamsBean();
                    netParamsBean.setAutoLogin(false);
                    netParamsBean.setThirdPartyId(String.valueOf(commLoginResult.getThirdId()));
                    Response.getInstance().setUserInfo(userInfo);
                    Response.getInstance().setNetParamsBean(netParamsBean);
                    SLdJjpRXaI sLdJjpRXaI2 = sLdJjpRXaI;
                    sLdJjpRXaI2.jumpToActivity(new VwEiglxMTZuLV(sLdJjpRXaI2.getContext()));
                }
            });
        } else {
            LogUtils.e("kakao plugin is not exist!!");
        }
    }
}
