package com.sfyvctwaqbjhki.uwmpqfh.ebvmj;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Process;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.TextView;
import com.sfyvctwaqbjhki.uwmpqfh.R;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.ActManager;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.Response;
import com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI;

/* loaded from: classes.dex */
public class EQcWrywmxntsoaA extends SLdJjpRXaI {
    private int mAppId;
    private int mUserId;
    private WebView vAdWebview;
    private ImageButton vCloseBtn;
    private TextView vSummeryTv;

    public EQcWrywmxntsoaA(Context context) {
        super(context);
    }

    public static EQcWrywmxntsoaA createAndShow(Context context) {
        EQcWrywmxntsoaA eQcWrywmxntsoaA = new EQcWrywmxntsoaA(context);
        eQcWrywmxntsoaA.show();
        return eQcWrywmxntsoaA;
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    protected int createView() {
        return R.layout.cg_activity_ad_exit;
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    protected void initView() {
        String str;
        this.mUserId = Response.getInstance().getUserInfo().getUserId();
        this.mAppId = Response.getInstance().getConfigBean().getAppId();
        ((TextView) findViewById(R.id.txt_title)).setCompoundDrawablesWithIntrinsicBounds(Response.getInstance().getConfigBean().getIsVNCheck() == 1 ? R.drawable.cg_18logo : R.drawable.cg_logo, 0, 0, 0);
        WebView webView = (WebView) findViewById(R.id.web_ad);
        this.vAdWebview = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.vAdWebview.getSettings().setCacheMode(2);
        if (Response.getInstance().getEDakAXiM().getMessages() != null) {
            String pauseMessageUrl = Response.getInstance().getEDakAXiM().getMessages().getPauseMessageUrl();
            if (pauseMessageUrl.contains("?")) {
                str = pauseMessageUrl + "&userId=" + this.mUserId + "&appId=" + this.mAppId;
            } else {
                str = pauseMessageUrl + "?userId=" + this.mUserId + "&appId=" + this.mAppId;
            }
            this.vAdWebview.loadUrl(str);
        }
        this.vAdWebview.setWebViewClient(new WebViewClient() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.EQcWrywmxntsoaA.1
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView2, String str2) {
                String str3;
                if (str2.contains("?")) {
                    str3 = str2 + "&userId=" + EQcWrywmxntsoaA.this.mUserId + "&appId=" + EQcWrywmxntsoaA.this.mAppId;
                } else {
                    str3 = str2 + "?userId=" + EQcWrywmxntsoaA.this.mUserId + "&appId=" + EQcWrywmxntsoaA.this.mAppId;
                }
                System.out.println("ad  url  ::::: " + str3);
                if (!str3.contains("todlPage=2")) {
                    UpEMrGWDdilB.createAndShow(EQcWrywmxntsoaA.this.getContext(), str3, "");
                    EQcWrywmxntsoaA.this.dismiss();
                    return true;
                }
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(str3));
                ((SLdJjpRXaI) EQcWrywmxntsoaA.this).context.startActivity(intent);
                EQcWrywmxntsoaA.this.dismiss();
                return true;
            }
        });
        this.vAdWebview.setWebChromeClient(new WebChromeClient());
        ImageButton imageButton = (ImageButton) findViewById(R.id.imgbtn_close);
        this.vCloseBtn = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.EQcWrywmxntsoaA.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EQcWrywmxntsoaA.this.dismiss();
            }
        });
        TextView textView = (TextView) findViewById(R.id.txt_summary);
        this.vSummeryTv = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.EQcWrywmxntsoaA.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EQcWrywmxntsoaA.this.dismiss();
                ActManager.getAppManager().addActivity(((SLdJjpRXaI) EQcWrywmxntsoaA.this).context);
                ActManager.getAppManager().finishAllActivity();
                Process.killProcess(Process.myPid());
            }
        });
    }
}
