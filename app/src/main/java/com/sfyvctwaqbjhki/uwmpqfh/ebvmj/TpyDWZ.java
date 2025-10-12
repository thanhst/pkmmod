package com.sfyvctwaqbjhki.uwmpqfh.ebvmj;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CheckBox;
import android.widget.ImageButton;
import com.sfyvctwaqbjhki.uwmpqfh.R;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.ConstantUtil;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.DateUtil;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.ConfigBean;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.UserInfo;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.AccTipsManager;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.Response;
import com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI;
import java.util.Date;

/* loaded from: classes.dex */
public class TpyDWZ extends SLdJjpRXaI {
    private ConfigBean mConfigBean;
    private CheckBox mSelectCh;
    private UserInfo mUserInfo;
    private WebView vAdWebview;
    private ImageButton vCloseBtn;

    public TpyDWZ(Context context) {
        super(context);
    }

    public static TpyDWZ createAndShow(Context context) {
        TpyDWZ tpyDWZ = new TpyDWZ(context);
        tpyDWZ.show();
        return tpyDWZ;
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    protected int createView() {
        return R.layout.cg_activity_ad_login;
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    protected void initView() {
        String str;
        this.mUserInfo = Response.getInstance().getUserInfo();
        this.mConfigBean = Response.getInstance().getConfigBean();
        this.vAdWebview = (WebView) findViewById(R.id.login_web_succuss);
        String loginMessageUrl = Response.getInstance().getEDakAXiM().getMessages() != null ? Response.getInstance().getEDakAXiM().getMessages().getLoginMessageUrl() : "";
        if (loginMessageUrl.contains("?")) {
            str = loginMessageUrl + "&userId=" + this.mUserInfo.getUserId() + "&appId=" + this.mConfigBean.getAppId();
        } else {
            str = loginMessageUrl + "?userId=" + this.mUserInfo.getUserId() + "&appId=" + this.mConfigBean.getAppId();
        }
        this.vAdWebview.getSettings().setJavaScriptEnabled(true);
        this.vAdWebview.getSettings().setCacheMode(2);
        this.vAdWebview.loadUrl(str);
        this.vAdWebview.setWebViewClient(new WebViewClient() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.TpyDWZ.1
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str2) {
                String str3;
                if (str2.contains("?")) {
                    str3 = str2 + "&userId=" + TpyDWZ.this.mUserInfo.getUserId() + "&appId=" + TpyDWZ.this.mConfigBean.getAppId();
                } else {
                    str3 = str2 + "?userId=" + TpyDWZ.this.mUserInfo.getUserId() + "&appId=" + TpyDWZ.this.mConfigBean.getAppId();
                }
                if (!str3.contains("todlPage=2")) {
                    UpEMrGWDdilB.createAndShow(TpyDWZ.this.getContext(), str3, "");
                    TpyDWZ.this.dismiss();
                    return true;
                }
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(str3));
                ((SLdJjpRXaI) TpyDWZ.this).context.startActivity(intent);
                TpyDWZ.this.dismiss();
                return true;
            }
        });
        this.vAdWebview.setWebChromeClient(new WebChromeClient());
        ImageButton imageButton = (ImageButton) findViewById(R.id.imgbtn_close);
        this.vCloseBtn = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.TpyDWZ.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TpyDWZ.this.dismiss();
                if (Response.getInstance().getUserInfo() == null || Response.getInstance().getUserInfo().getUserType() != ConstantUtil.USER_TYPE_VISTOR) {
                    return;
                }
                AccTipsManager.getInstance().visitorEntry(((SLdJjpRXaI) TpyDWZ.this).context, Response.getInstance().getUserInfo().getUserId());
            }
        });
        CheckBox checkBox = (CheckBox) findViewById(R.id.cg_not_show);
        this.mSelectCh = checkBox;
        checkBox.setOnClickListener(new View.OnClickListener() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.TpyDWZ.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SharedPreferences.Editor editorEdit = ((SLdJjpRXaI) TpyDWZ.this).context.getSharedPreferences(ConstantUtil.ACCOUNT_PREFERENCES, 0).edit();
                if (TpyDWZ.this.mSelectCh.isChecked()) {
                    editorEdit.putString("isToday", DateUtil.getTimeStringFormat(new Date(), "yyyy-MM-dd") + TpyDWZ.this.mUserInfo.getUserId());
                } else {
                    editorEdit.putString("isToday", "");
                }
                editorEdit.commit();
            }
        });
    }
}
