package com.sfyvctwaqbjhki.uwmpqfh.ebvmj;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sfyvctwaqbjhki.uwmpqfh.R;
import com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI;
import com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.SingleBtnCallBack;

/* loaded from: classes.dex */
public class UpEMrGWDdilB extends SLdJjpRXaI {
    private WebView cg_webview;
    private SingleBtnCallBack confirmCallBack;
    private boolean isWebFullScreen;
    private RelativeLayout layout_back;
    private RelativeLayout layout_close;
    private String title;
    private TextView txt_title;
    private String url;

    /* renamed from: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.UpEMrGWDdilB$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$UpEMrGWDdilB$Buttons;

        static {
            int[] iArr = new int[Buttons.values().length];
            $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$UpEMrGWDdilB$Buttons = iArr;
            try {
                iArr[Buttons.LAYOUT_BACK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$UpEMrGWDdilB$Buttons[Buttons.LAYOUT_CLOSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private enum Buttons {
        LAYOUT_BACK,
        LAYOUT_CLOSE
    }

    public UpEMrGWDdilB(Context context, String str, String str2) {
        this(context);
        this.url = str;
        this.title = str2;
    }

    public static UpEMrGWDdilB createAndShow(Context context, String str, String str2) {
        UpEMrGWDdilB upEMrGWDdilB = new UpEMrGWDdilB(context, str, str2);
        upEMrGWDdilB.show();
        return upEMrGWDdilB;
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    protected void click(View view) {
        int i2 = AnonymousClass2.$SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$UpEMrGWDdilB$Buttons[((Buttons) view.getTag()).ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                return;
            }
            dismiss();
        } else if (this.cg_webview.canGoBack()) {
            this.cg_webview.goBack();
        } else {
            dismiss();
        }
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    protected int createView() {
        return R.layout.cg_activity_message;
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    protected void initView() {
        if (this.isWebFullScreen) {
            WebView webView = (WebView) findViewById(R.id.fullscreen_web);
            this.cg_webview = webView;
            webView.setVisibility(0);
            ((RelativeLayout) findViewById(R.id.legacy_web_layout)).setVisibility(8);
        } else {
            this.layout_back = (RelativeLayout) findViewById(R.id.layout_back);
            this.layout_close = (RelativeLayout) findViewById(R.id.layout_close);
            this.cg_webview = (WebView) findViewById(R.id.cg_webview);
            TextView textView = (TextView) findViewById(R.id.txt_title);
            this.txt_title = textView;
            textView.setText(this.title);
            this.layout_back.setTag(Buttons.LAYOUT_BACK);
            this.layout_close.setTag(Buttons.LAYOUT_CLOSE);
            this.layout_back.setOnTouchListener(this);
            this.layout_close.setOnTouchListener(this);
        }
        this.cg_webview.getSettings().setJavaScriptEnabled(true);
        this.cg_webview.getSettings().setUseWideViewPort(true);
        this.cg_webview.getSettings().setLoadWithOverviewMode(true);
        this.cg_webview.getSettings().setBuiltInZoomControls(true);
        this.cg_webview.getSettings().setSupportZoom(true);
        this.cg_webview.loadUrl(this.url);
        this.cg_webview.setWebViewClient(new WebViewClient() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.UpEMrGWDdilB.1
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView2, String str) {
                Uri uri = Uri.parse(str);
                if (uri.getLastPathSegment() == null || !uri.getLastPathSegment().equals("go_home.html")) {
                    webView2.loadUrl(str);
                    return true;
                }
                if (uri.getQueryParameter("code") != null && uri.getQueryParameter("code").equals("200")) {
                    if (uri.getQueryParameter("redirectUrl") != null && !uri.getQueryParameter("redirectUrl").isEmpty()) {
                        UpEMrGWDdilB.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    }
                    if (UpEMrGWDdilB.this.confirmCallBack != null) {
                        UpEMrGWDdilB.this.confirmCallBack.confirm();
                    }
                }
                UpEMrGWDdilB.this.dismiss();
                return true;
            }
        });
        this.cg_webview.setWebChromeClient(new WebChromeClient());
    }

    public static UpEMrGWDdilB createAndShow(Context context, String str, SingleBtnCallBack singleBtnCallBack) {
        UpEMrGWDdilB upEMrGWDdilB = new UpEMrGWDdilB(context, str, true, singleBtnCallBack);
        upEMrGWDdilB.show();
        return upEMrGWDdilB;
    }

    public UpEMrGWDdilB(Context context, String str, boolean z2, SingleBtnCallBack singleBtnCallBack) {
        this(context);
        this.url = str;
        this.isWebFullScreen = z2;
        this.confirmCallBack = singleBtnCallBack;
    }

    private UpEMrGWDdilB(Context context) {
        super(context);
        this.isWebFullScreen = false;
    }
}
