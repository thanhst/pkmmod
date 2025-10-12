package com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import com.sfyvctwaqbjhki.uwmpqfh.R;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.ErrorUtil;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.JqUIzeZd;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.WxGIMQL;
import com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY;
import com.sfyvctwaqbjhki.uwmpqfh.lebktch.WOMSQzPaksWfHUC;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.KcUwgofnY;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.Response;
import com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.NNXOHlAajkUISYActivity;
import com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.SingleBtnCallBack;
import java.net.URISyntaxException;

/* loaded from: classes.dex */
public class Zmxjahf extends NNXOHlAajkUISY {
    private RelativeLayout cg_failLoad_rl;
    private RelativeLayout layout_progress;
    private WebView web_card;

    public Zmxjahf(NNXOHlAajkUISYActivity nNXOHlAajkUISYActivity) {
        super(nNXOHlAajkUISYActivity);
    }

    private void cardPayByWeb() {
        KcUwgofnY.getInstance().startPay(this.activity.getContext(), Response.getInstance().getChoosePayChannel(), new KcUwgofnY.PayComponentCallBack() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.Zmxjahf.3
            @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.KcUwgofnY.PayComponentCallBack
            public void payFail(int i2, String str) {
                Zmxjahf.this.cg_failLoad_rl.setVisibility(0);
                Zmxjahf.this.web_card.setVisibility(8);
                String string = Zmxjahf.this.getContext().getString(ErrorUtil.getIdByCode(i2));
                Zmxjahf zmxjahf = Zmxjahf.this;
                zmxjahf.showSingleBtnDialog(i2 == 206, zmxjahf.getContext().getString(i2 == 206 ? R.string.txt_pay_pending : R.string.txt_buy_fail), string);
            }

            @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.KcUwgofnY.PayComponentCallBack
            public void paySuccess() {
                String paymentUrl = Response.getInstance().getNetParamsBean().getPaymentUrl();
                if (paymentUrl.contains("_explore")) {
                    Zmxjahf.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paymentUrl)));
                    ((NNXOHlAajkUISY) Zmxjahf.this).activity.dismiss();
                    return;
                }
                Zmxjahf.this.cg_failLoad_rl.setVisibility(8);
                Zmxjahf.this.web_card.setVisibility(0);
                Zmxjahf.this.web_card.loadUrl(paymentUrl);
                if (Build.VERSION.SDK_INT >= 21) {
                    CookieManager.getInstance().setAcceptThirdPartyCookies(Zmxjahf.this.web_card, true);
                } else {
                    CookieManager.getInstance().setAcceptCookie(true);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSingleBtnDialog(final boolean z2, String str, String str2) {
        WxGIMQL.createAndShow(str, str2, getContext().getString(R.string.txt_confirm), new SingleBtnCallBack() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.Zmxjahf.2
            @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.SingleBtnCallBack
            public void confirm() {
                if (z2) {
                    ((NNXOHlAajkUISY) Zmxjahf.this).activity.dismiss();
                }
            }
        });
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    protected void click(View view) {
        super.click(view);
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    public void onCreat(View view) {
        super.onCreat(view);
        this.web_card = (WebView) findViewById(R.id.web_card);
        this.cg_failLoad_rl = (RelativeLayout) findViewById(R.id.cg_failLoad_rl);
        this.layout_progress = (RelativeLayout) findViewById(R.id.layout_progress);
        this.web_card.getSettings().setJavaScriptEnabled(true);
        this.web_card.getSettings().setUseWideViewPort(true);
        this.web_card.getSettings().setLoadWithOverviewMode(true);
        this.web_card.getSettings().setBuiltInZoomControls(true);
        this.web_card.getSettings().setSupportZoom(true);
        this.web_card.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.web_card.getSettings().setAllowFileAccessFromFileURLs(true);
        this.web_card.getSettings().setAllowUniversalAccessFromFileURLs(true);
        this.web_card.getSettings().setSupportMultipleWindows(true);
        this.web_card.getSettings().setLoadsImagesAutomatically(true);
        this.web_card.getSettings().setDomStorageEnabled(true);
        this.web_card.getSettings().setDatabaseEnabled(true);
        this.web_card.setWebViewClient(new WebViewClient() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.Zmxjahf.1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                Zmxjahf.this.layout_progress.setVisibility(8);
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) throws URISyntaxException {
                if (str.startsWith("intent:")) {
                    try {
                        PackageManager packageManager = Zmxjahf.this.getContext().getPackageManager();
                        Intent uri = Intent.parseUri(str, 1);
                        if (uri.resolveActivity(packageManager) != null) {
                            Zmxjahf.this.getContext().startActivity(uri);
                            return true;
                        }
                        String stringExtra = uri.getStringExtra("browser_fallback_url");
                        if (stringExtra != null) {
                            webView.loadUrl(stringExtra);
                            return true;
                        }
                        Intent data = new Intent("android.intent.action.VIEW").setData(Uri.parse("market://details?id=" + uri.getPackage()));
                        if (data.resolveActivity(packageManager) != null) {
                            Zmxjahf.this.getContext().startActivity(data);
                            return true;
                        }
                    } catch (URISyntaxException e2) {
                        e2.printStackTrace();
                    }
                } else if (str.startsWith("sms:")) {
                    Zmxjahf.this.getContext().startActivity(new Intent("android.intent.action.SENDTO", Uri.parse(str)));
                    webView.reload();
                } else {
                    String[] strArrSplit = str.split("/");
                    String str2 = strArrSplit[strArrSplit.length - 1];
                    if (str2.equals("pocket_back.jsp")) {
                        ((NNXOHlAajkUISY) Zmxjahf.this).activity.dismiss();
                    } else if (str2.equals("pocket_goPay.jsp")) {
                        ((NNXOHlAajkUISY) Zmxjahf.this).activity.jumpToActivity(new JqUIzeZd(Zmxjahf.this.getContext()));
                    } else if (str2.equals("pocket_bindAccount.jsp")) {
                        Zmxjahf.this.showSingleBtnDialog(true, Zmxjahf.this.getContext().getString(R.string.txt_buy_success), Zmxjahf.this.getContext().getString(R.string.txt_buy_success_tip));
                    } else if (str2.contains("_explore")) {
                        Zmxjahf.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                        ((NNXOHlAajkUISY) Zmxjahf.this).activity.dismiss();
                    } else {
                        Zmxjahf.this.layout_progress.setVisibility(0);
                        webView.loadUrl(str);
                    }
                }
                return true;
            }
        });
        this.web_card.setWebChromeClient(new WebChromeClient());
        onRefresh();
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    public View onCreateView(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(R.layout.cg_fragment_pay_web_card, (ViewGroup) null);
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    public void onRefresh() {
        this.web_card.loadUrl("");
        this.web_card.setVisibility(0);
        this.cg_failLoad_rl.setVisibility(8);
        this.layout_progress.setVisibility(8);
        cardPayByWeb();
    }

    public Zmxjahf(NNXOHlAajkUISYActivity nNXOHlAajkUISYActivity, WOMSQzPaksWfHUC wOMSQzPaksWfHUC) {
        super(nNXOHlAajkUISYActivity, wOMSQzPaksWfHUC);
    }
}
