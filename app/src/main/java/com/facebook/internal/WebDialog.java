package com.facebook.internal;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslError;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.VisibleForTesting;
import com.facebook.AccessToken;
import com.facebook.FacebookDialogException;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.FacebookServiceException;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestAsyncTask;
import com.facebook.GraphResponse;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.common.R;
import com.facebook.internal.WebDialog;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.LoginTargetApp;
import com.facebook.share.internal.ShareConstants;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.widget.ShareDialog;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: WebDialog.kt */
@Metadata(bv = {}, d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 W2\u00020\u0001:\u0006XWYZ[\\B\u0019\b\u0014\u0012\u0006\u0010L\u001a\u00020K\u0012\u0006\u0010)\u001a\u00020\u001d¢\u0006\u0004\bM\u0010NB!\b\u0012\u0012\u0006\u0010L\u001a\u00020K\u0012\u0006\u0010)\u001a\u00020\u001d\u0012\u0006\u0010O\u001a\u00020\u0002¢\u0006\u0004\bM\u0010PB?\b\u0012\u0012\u0006\u0010L\u001a\u00020K\u0012\b\u0010Q\u001a\u0004\u0018\u00010\u001d\u0012\b\u0010R\u001a\u0004\u0018\u00010\u001a\u0012\u0006\u0010O\u001a\u00020\u0002\u0012\u0006\u0010T\u001a\u00020S\u0012\b\u0010U\u001a\u0004\u0018\u00010+¢\u0006\u0004\bM\u0010VJ(\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0003J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016J\b\u0010\u0013\u001a\u00020\tH\u0014J\b\u0010\u0014\u001a\u00020\tH\u0014J\b\u0010\u0015\u001a\u00020\tH\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0012\u0010\u001c\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0014J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001dH\u0004J\u0012\u0010!\u001a\u00020\u001a2\b\u0010 \u001a\u0004\u0018\u00010\u001dH\u0017J\u0006\u0010\"\u001a\u00020\tJ\u0012\u0010$\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010\u001aH\u0004J\u0012\u0010'\u001a\u00020\t2\b\u0010&\u001a\u0004\u0018\u00010%H\u0004J\b\u0010(\u001a\u00020\tH\u0016R\u0018\u0010)\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010*R$\u0010,\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R(\u00104\u001a\u0004\u0018\u0001022\b\u00103\u001a\u0004\u0018\u0001028\u0004@BX\u0084\u000e¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0018\u00109\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010<\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010?\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u001c\u0010B\u001a\b\u0018\u00010AR\u00020\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR$\u0010D\u001a\u00020\u00102\u0006\u00103\u001a\u00020\u00108\u0004@BX\u0084\u000e¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bD\u0010FR\u0016\u0010G\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010ER$\u0010H\u001a\u00020\u00102\u0006\u00103\u001a\u00020\u00108\u0004@BX\u0084\u000e¢\u0006\f\n\u0004\bH\u0010E\u001a\u0004\bH\u0010FR\u0018\u0010I\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010J¨\u0006]"}, d2 = {"Lcom/facebook/internal/WebDialog;", "Landroid/app/Dialog;", "", "screenSize", "", "density", "noPaddingSize", "maxPaddingSize", "getScaledSize", "Lkotlin/t;", "createCrossImage", "margin", "setUpWebView", "keyCode", "Landroid/view/KeyEvent;", "event", "", "onKeyDown", "dismiss", "onStart", "onStop", "onDetachedFromWindow", "onAttachedToWindow", "Landroid/view/WindowManager$LayoutParams;", NativeProtocol.WEB_DIALOG_PARAMS, "onWindowAttributesChanged", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "", "expectedRedirectUrl", "setExpectedRedirectUrl", "urlString", "parseResponseUri", "resize", "values", "sendSuccessToListener", "", "error", "sendErrorToListener", "cancel", "url", "Ljava/lang/String;", "Lcom/facebook/internal/WebDialog$OnCompleteListener;", "onCompleteListener", "Lcom/facebook/internal/WebDialog$OnCompleteListener;", "getOnCompleteListener", "()Lcom/facebook/internal/WebDialog$OnCompleteListener;", "setOnCompleteListener", "(Lcom/facebook/internal/WebDialog$OnCompleteListener;)V", "Landroid/webkit/WebView;", "<set-?>", "webView", "Landroid/webkit/WebView;", "getWebView", "()Landroid/webkit/WebView;", "Landroid/app/ProgressDialog;", "spinner", "Landroid/app/ProgressDialog;", "Landroid/widget/ImageView;", "crossImageView", "Landroid/widget/ImageView;", "Landroid/widget/FrameLayout;", "contentFrameLayout", "Landroid/widget/FrameLayout;", "Lcom/facebook/internal/WebDialog$UploadStagingResourcesTask;", "uploadTask", "Lcom/facebook/internal/WebDialog$UploadStagingResourcesTask;", "isListenerCalled", "Z", "()Z", "isDetached", "isPageFinished", "windowParams", "Landroid/view/WindowManager$LayoutParams;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "theme", "(Landroid/content/Context;Ljava/lang/String;I)V", NativeProtocol.WEB_DIALOG_ACTION, "parameters", "Lcom/facebook/login/LoginTargetApp;", "targetApp", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;ILcom/facebook/login/LoginTargetApp;Lcom/facebook/internal/WebDialog$OnCompleteListener;)V", "Companion", "Builder", "DialogWebViewClient", "InitCallback", "OnCompleteListener", "UploadStagingResourcesTask", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public class WebDialog extends Dialog {
    private static final int API_EC_DIALOG_CANCEL = 4201;
    private static final int BACKGROUND_GRAY = -872415232;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int DEFAULT_THEME = R.style.com_facebook_activity_theme;
    public static final boolean DISABLE_SSL_CHECK_FOR_TESTING = false;

    @NotNull
    private static final String DISPLAY_TOUCH = "touch";

    @NotNull
    private static final String LOG_TAG = "FacebookSDK.WebDialog";
    private static final int MAX_PADDING_SCREEN_HEIGHT = 1280;
    private static final int MAX_PADDING_SCREEN_WIDTH = 800;
    private static final double MIN_SCALE_FACTOR = 0.5d;
    private static final int NO_PADDING_SCREEN_HEIGHT = 800;
    private static final int NO_PADDING_SCREEN_WIDTH = 480;

    @NotNull
    private static final String PLATFORM_DIALOG_PATH_REGEX = "^/(v\\d+\\.\\d+/)??dialog/.*";

    @Nullable
    private static InitCallback initCallback;
    private static volatile int webDialogTheme;

    @Nullable
    private FrameLayout contentFrameLayout;

    @Nullable
    private ImageView crossImageView;

    @NotNull
    private String expectedRedirectUrl;
    private boolean isDetached;
    private boolean isListenerCalled;
    private boolean isPageFinished;

    @Nullable
    private OnCompleteListener onCompleteListener;

    @Nullable
    private ProgressDialog spinner;

    @Nullable
    private UploadStagingResourcesTask uploadTask;

    @Nullable
    private String url;

    @Nullable
    private WebView webView;

    @Nullable
    private WindowManager.LayoutParams windowParams;

    /* compiled from: WebDialog.kt */
    @Metadata(bv = {}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J(\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J \u0010\u0012\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\"\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0018\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0019"}, d2 = {"Lcom/facebook/internal/WebDialog$DialogWebViewClient;", "Landroid/webkit/WebViewClient;", "Landroid/webkit/WebView;", ViewHierarchyConstants.VIEW_KEY, "", "url", "", "shouldOverrideUrlLoading", "", "errorCode", "description", "failingUrl", "Lkotlin/t;", "onReceivedError", "Landroid/webkit/SslErrorHandler;", "handler", "Landroid/net/http/SslError;", "error", "onReceivedSslError", "Landroid/graphics/Bitmap;", "favicon", "onPageStarted", "onPageFinished", "<init>", "(Lcom/facebook/internal/WebDialog;)V", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
    private final class DialogWebViewClient extends WebViewClient {
        final /* synthetic */ WebDialog this$0;

        public DialogWebViewClient(WebDialog this$0) {
            kotlin.jvm.internal.s.e(this$0, "this$0");
            this.this$0 = this$0;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(@NotNull WebView view, @NotNull String url) {
            ProgressDialog progressDialog;
            kotlin.jvm.internal.s.e(view, "view");
            kotlin.jvm.internal.s.e(url, "url");
            super.onPageFinished(view, url);
            if (!this.this$0.isDetached && (progressDialog = this.this$0.spinner) != null) {
                progressDialog.dismiss();
            }
            FrameLayout frameLayout = this.this$0.contentFrameLayout;
            if (frameLayout != null) {
                frameLayout.setBackgroundColor(0);
            }
            WebView webView = this.this$0.getWebView();
            if (webView != null) {
                webView.setVisibility(0);
            }
            ImageView imageView = this.this$0.crossImageView;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            this.this$0.isPageFinished = true;
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(@NotNull WebView view, @NotNull String url, @Nullable Bitmap bitmap) {
            ProgressDialog progressDialog;
            kotlin.jvm.internal.s.e(view, "view");
            kotlin.jvm.internal.s.e(url, "url");
            Utility utility = Utility.INSTANCE;
            Utility.logd(WebDialog.LOG_TAG, kotlin.jvm.internal.s.m("Webview loading URL: ", url));
            super.onPageStarted(view, url, bitmap);
            if (this.this$0.isDetached || (progressDialog = this.this$0.spinner) == null) {
                return;
            }
            progressDialog.show();
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(@NotNull WebView view, int i2, @NotNull String description, @NotNull String failingUrl) {
            kotlin.jvm.internal.s.e(view, "view");
            kotlin.jvm.internal.s.e(description, "description");
            kotlin.jvm.internal.s.e(failingUrl, "failingUrl");
            super.onReceivedError(view, i2, description, failingUrl);
            this.this$0.sendErrorToListener(new FacebookDialogException(description, i2, failingUrl));
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(@NotNull WebView view, @NotNull SslErrorHandler handler, @NotNull SslError error) {
            kotlin.jvm.internal.s.e(view, "view");
            kotlin.jvm.internal.s.e(handler, "handler");
            kotlin.jvm.internal.s.e(error, "error");
            super.onReceivedSslError(view, handler, error);
            handler.cancel();
            this.this$0.sendErrorToListener(new FacebookDialogException(null, -11, null));
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(@NotNull WebView view, @NotNull String url) throws NumberFormatException {
            int i2;
            kotlin.jvm.internal.s.e(view, "view");
            kotlin.jvm.internal.s.e(url, "url");
            Utility utility = Utility.INSTANCE;
            Utility.logd(WebDialog.LOG_TAG, kotlin.jvm.internal.s.m("Redirect URL: ", url));
            Uri uri = Uri.parse(url);
            boolean z2 = uri.getPath() != null && Pattern.matches(WebDialog.PLATFORM_DIALOG_PATH_REGEX, uri.getPath());
            if (!kotlin.text.s.u(url, this.this$0.expectedRedirectUrl, false, 2, null)) {
                if (kotlin.text.s.u(url, ServerProtocol.DIALOG_CANCEL_URI, false, 2, null)) {
                    this.this$0.cancel();
                    return true;
                }
                if (z2 || StringsKt__StringsKt.x(url, "touch", false, 2, null)) {
                    return false;
                }
                try {
                    this.this$0.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
                    return true;
                } catch (ActivityNotFoundException unused) {
                    return false;
                }
            }
            Bundle responseUri = this.this$0.parseResponseUri(url);
            String string = responseUri.getString("error");
            if (string == null) {
                string = responseUri.getString(NativeProtocol.BRIDGE_ARG_ERROR_TYPE);
            }
            String string2 = responseUri.getString("error_msg");
            if (string2 == null) {
                string2 = responseUri.getString(AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE);
            }
            if (string2 == null) {
                string2 = responseUri.getString(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION);
            }
            String string3 = responseUri.getString(NativeProtocol.BRIDGE_ARG_ERROR_CODE);
            if (string3 == null || Utility.isNullOrEmpty(string3)) {
                i2 = -1;
            } else {
                try {
                    i2 = Integer.parseInt(string3);
                } catch (NumberFormatException unused2) {
                }
            }
            if (Utility.isNullOrEmpty(string) && Utility.isNullOrEmpty(string2) && i2 == -1) {
                this.this$0.sendSuccessToListener(responseUri);
            } else if ((string == null || !(kotlin.jvm.internal.s.a(string, "access_denied") || kotlin.jvm.internal.s.a(string, "OAuthAccessDeniedException"))) && i2 != WebDialog.API_EC_DIALOG_CANCEL) {
                this.this$0.sendErrorToListener(new FacebookServiceException(new FacebookRequestError(i2, string, string2), string2));
            } else {
                this.this$0.cancel();
            }
            return true;
        }
    }

    /* compiled from: WebDialog.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/facebook/internal/WebDialog$InitCallback;", "", "Landroid/webkit/WebView;", "webView", "Lkotlin/t;", "onInit", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
    public interface InitCallback {
        void onInit(@Nullable WebView webView);
    }

    /* compiled from: WebDialog.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¨\u0006\b"}, d2 = {"Lcom/facebook/internal/WebDialog$OnCompleteListener;", "", "Landroid/os/Bundle;", "values", "Lcom/facebook/FacebookException;", "error", "Lkotlin/t;", "onComplete", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
    public interface OnCompleteListener {
        void onComplete(@Nullable Bundle bundle, @Nullable FacebookException facebookException);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: WebDialog.kt */
    @Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00030\u0001B\u0019\b\u0000\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0015\u0010\u0016J-\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0003\"\u00020\u0002H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\n\u001a\u00020\t2\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R$\u0010\u0013\u001a\u0010\u0012\f\u0012\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u00120\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/facebook/internal/WebDialog$UploadStagingResourcesTask;", "Landroid/os/AsyncTask;", "Ljava/lang/Void;", "", "", "p0", "doInBackground", "([Ljava/lang/Void;)[Ljava/lang/String;", "results", "Lkotlin/t;", "onPostExecute", "([Ljava/lang/String;)V", NativeProtocol.WEB_DIALOG_ACTION, "Ljava/lang/String;", "Landroid/os/Bundle;", "parameters", "Landroid/os/Bundle;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exceptions", "[Ljava/lang/Exception;", "<init>", "(Lcom/facebook/internal/WebDialog;Ljava/lang/String;Landroid/os/Bundle;)V", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
    final class UploadStagingResourcesTask extends AsyncTask<Void, Void, String[]> {

        @NotNull
        private final String action;

        @NotNull
        private Exception[] exceptions;

        @NotNull
        private final Bundle parameters;
        final /* synthetic */ WebDialog this$0;

        public UploadStagingResourcesTask(@NotNull WebDialog this$0, @NotNull String action, Bundle parameters) {
            kotlin.jvm.internal.s.e(this$0, "this$0");
            kotlin.jvm.internal.s.e(action, "action");
            kotlin.jvm.internal.s.e(parameters, "parameters");
            this.this$0 = this$0;
            this.action = action;
            this.parameters = parameters;
            this.exceptions = new Exception[0];
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: doInBackground$lambda-0, reason: not valid java name */
        public static final void m115doInBackground$lambda0(String[] results, int i2, UploadStagingResourcesTask this$0, CountDownLatch latch, GraphResponse response) {
            FacebookRequestError error;
            String str;
            kotlin.jvm.internal.s.e(results, "$results");
            kotlin.jvm.internal.s.e(this$0, "this$0");
            kotlin.jvm.internal.s.e(latch, "$latch");
            kotlin.jvm.internal.s.e(response, "response");
            try {
                error = response.getError();
                str = "Error staging photo.";
            } catch (Exception e2) {
                this$0.exceptions[i2] = e2;
            }
            if (error != null) {
                String errorMessage = error.getErrorMessage();
                if (errorMessage != null) {
                    str = errorMessage;
                }
                throw new FacebookGraphResponseException(response, str);
            }
            JSONObject graphObject = response.getGraphObject();
            if (graphObject == null) {
                throw new FacebookException("Error staging photo.");
            }
            String strOptString = graphObject.optString(ShareConstants.MEDIA_URI);
            if (strOptString == null) {
                throw new FacebookException("Error staging photo.");
            }
            results[i2] = strOptString;
            latch.countDown();
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ String[] doInBackground(Void[] voidArr) {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                if (CrashShieldHandler.isObjectCrashing(this)) {
                    return null;
                }
                try {
                    return doInBackground2(voidArr);
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, this);
                    return null;
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
                return null;
            }
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ void onPostExecute(String[] strArr) {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                if (CrashShieldHandler.isObjectCrashing(this)) {
                    return;
                }
                try {
                    onPostExecute2(strArr);
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, this);
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }

        @Nullable
        /* renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected String[] doInBackground2(@NotNull Void... p02) {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                if (CrashShieldHandler.isObjectCrashing(this)) {
                    return null;
                }
                try {
                    kotlin.jvm.internal.s.e(p02, "p0");
                    String[] stringArray = this.parameters.getStringArray(ShareConstants.WEB_DIALOG_PARAM_MEDIA);
                    if (stringArray == null) {
                        return null;
                    }
                    final String[] strArr = new String[stringArray.length];
                    this.exceptions = new Exception[stringArray.length];
                    final CountDownLatch countDownLatch = new CountDownLatch(stringArray.length);
                    ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
                    AccessToken currentAccessToken = AccessToken.INSTANCE.getCurrentAccessToken();
                    final int i2 = 0;
                    try {
                        int length = stringArray.length - 1;
                        if (length >= 0) {
                            while (true) {
                                int i3 = i2 + 1;
                                if (isCancelled()) {
                                    Iterator it = concurrentLinkedQueue.iterator();
                                    while (it.hasNext()) {
                                        ((GraphRequestAsyncTask) it.next()).cancel(true);
                                    }
                                    return null;
                                }
                                Uri uri = Uri.parse(stringArray[i2]);
                                if (Utility.isWebUri(uri)) {
                                    strArr[i2] = uri.toString();
                                    countDownLatch.countDown();
                                } else {
                                    GraphRequest.Callback callback = new GraphRequest.Callback() { // from class: com.facebook.internal.w
                                        @Override // com.facebook.GraphRequest.Callback
                                        public final void onCompleted(GraphResponse graphResponse) {
                                            WebDialog.UploadStagingResourcesTask.m115doInBackground$lambda0(strArr, i2, this, countDownLatch, graphResponse);
                                        }
                                    };
                                    ShareInternalUtility shareInternalUtility = ShareInternalUtility.INSTANCE;
                                    kotlin.jvm.internal.s.d(uri, "uri");
                                    concurrentLinkedQueue.add(ShareInternalUtility.newUploadStagingResourceWithImageRequest(currentAccessToken, uri, callback).executeAsync());
                                }
                                if (i3 > length) {
                                    break;
                                }
                                i2 = i3;
                            }
                        }
                        countDownLatch.await();
                        return strArr;
                    } catch (Exception unused) {
                        Iterator it2 = concurrentLinkedQueue.iterator();
                        while (it2.hasNext()) {
                            ((GraphRequestAsyncTask) it2.next()).cancel(true);
                        }
                        return null;
                    }
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, this);
                    return null;
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
                return null;
            }
        }

        /* renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(@Nullable String[] results) {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                if (CrashShieldHandler.isObjectCrashing(this)) {
                    return;
                }
                try {
                    ProgressDialog progressDialog = this.this$0.spinner;
                    if (progressDialog != null) {
                        progressDialog.dismiss();
                    }
                    Exception[] excArr = this.exceptions;
                    int i2 = 0;
                    int length = excArr.length;
                    while (i2 < length) {
                        Exception exc = excArr[i2];
                        i2++;
                        if (exc != null) {
                            this.this$0.sendErrorToListener(exc);
                            return;
                        }
                    }
                    if (results == null) {
                        this.this$0.sendErrorToListener(new FacebookException("Failed to stage photos for web dialog"));
                        return;
                    }
                    List listB = kotlin.collections.m.b(results);
                    if (listB.contains(null)) {
                        this.this$0.sendErrorToListener(new FacebookException("Failed to stage photos for web dialog"));
                        return;
                    }
                    Utility utility = Utility.INSTANCE;
                    Utility.putJSONValueInBundle(this.parameters, ShareConstants.WEB_DIALOG_PARAM_MEDIA, new JSONArray((Collection) listB));
                    this.this$0.url = Utility.buildUri(ServerProtocol.getDialogAuthority(), FacebookSdk.getGraphApiVersion() + "/dialog/" + this.action, this.parameters).toString();
                    ImageView imageView = this.this$0.crossImageView;
                    if (imageView == null) {
                        throw new IllegalStateException("Required value was null.".toString());
                    }
                    this.this$0.setUpWebView((imageView.getDrawable().getIntrinsicWidth() / 2) + 1);
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, this);
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    /* compiled from: WebDialog.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoginTargetApp.valuesCustom().length];
            iArr[LoginTargetApp.INSTAGRAM.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    protected WebDialog(@NotNull Context context, @NotNull String url) {
        this(context, url, INSTANCE.getWebDialogTheme());
        kotlin.jvm.internal.s.e(context, "context");
        kotlin.jvm.internal.s.e(url, "url");
    }

    public /* synthetic */ WebDialog(Context context, String str, Bundle bundle, int i2, LoginTargetApp loginTargetApp, OnCompleteListener onCompleteListener, kotlin.jvm.internal.o oVar) {
        this(context, str, bundle, i2, loginTargetApp, onCompleteListener);
    }

    private final void createCrossImage() throws Resources.NotFoundException {
        ImageView imageView = new ImageView(getContext());
        this.crossImageView = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.facebook.internal.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WebDialog.m112createCrossImage$lambda5(this.f2881e, view);
            }
        });
        Drawable drawable = getContext().getResources().getDrawable(R.drawable.com_facebook_close);
        ImageView imageView2 = this.crossImageView;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
        ImageView imageView3 = this.crossImageView;
        if (imageView3 == null) {
            return;
        }
        imageView3.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: createCrossImage$lambda-5, reason: not valid java name */
    public static final void m112createCrossImage$lambda5(WebDialog this$0, View view) {
        kotlin.jvm.internal.s.e(this$0, "this$0");
        this$0.cancel();
    }

    private final int getScaledSize(int screenSize, float density, int noPaddingSize, int maxPaddingSize) {
        int i2 = (int) (screenSize / density);
        double d2 = MIN_SCALE_FACTOR;
        if (i2 <= noPaddingSize) {
            d2 = 1.0d;
        } else if (i2 < maxPaddingSize) {
            double d3 = maxPaddingSize - i2;
            double d4 = maxPaddingSize - noPaddingSize;
            Double.isNaN(d3);
            Double.isNaN(d4);
            d2 = MIN_SCALE_FACTOR + ((d3 / d4) * MIN_SCALE_FACTOR);
        }
        double d5 = screenSize;
        Double.isNaN(d5);
        return (int) (d5 * d2);
    }

    @JvmStatic
    public static final int getWebDialogTheme() {
        return INSTANCE.getWebDialogTheme();
    }

    @JvmStatic
    protected static final void initDefaultTheme(@Nullable Context context) throws PackageManager.NameNotFoundException {
        INSTANCE.initDefaultTheme(context);
    }

    @JvmStatic
    @NotNull
    public static final WebDialog newInstance(@NotNull Context context, @Nullable String str, @Nullable Bundle bundle, int i2, @Nullable OnCompleteListener onCompleteListener) {
        return INSTANCE.newInstance(context, str, bundle, i2, onCompleteListener);
    }

    @JvmStatic
    @NotNull
    public static final WebDialog newInstance(@NotNull Context context, @Nullable String str, @Nullable Bundle bundle, int i2, @NotNull LoginTargetApp loginTargetApp, @Nullable OnCompleteListener onCompleteListener) {
        return INSTANCE.newInstance(context, str, bundle, i2, loginTargetApp, onCompleteListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreate$lambda-4, reason: not valid java name */
    public static final void m113onCreate$lambda4(WebDialog this$0, DialogInterface dialogInterface) {
        kotlin.jvm.internal.s.e(this$0, "this$0");
        this$0.cancel();
    }

    @JvmStatic
    public static final void setInitCallback(@Nullable InitCallback initCallback2) {
        INSTANCE.setInitCallback(initCallback2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"SetJavaScriptEnabled"})
    public final void setUpWebView(int i2) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.webView = new WebView(getContext()) { // from class: com.facebook.internal.WebDialog.setUpWebView.1
            @Override // android.webkit.WebView, android.view.View
            public void onWindowFocusChanged(boolean z2) {
                try {
                    super.onWindowFocusChanged(z2);
                } catch (NullPointerException unused) {
                }
            }
        };
        InitCallback initCallback2 = initCallback;
        if (initCallback2 != null) {
            initCallback2.onInit(getWebView());
        }
        WebView webView = this.webView;
        if (webView != null) {
            webView.setVerticalScrollBarEnabled(false);
        }
        WebView webView2 = this.webView;
        if (webView2 != null) {
            webView2.setHorizontalScrollBarEnabled(false);
        }
        WebView webView3 = this.webView;
        if (webView3 != null) {
            webView3.setWebViewClient(new DialogWebViewClient(this));
        }
        WebView webView4 = this.webView;
        WebSettings settings = webView4 == null ? null : webView4.getSettings();
        if (settings != null) {
            settings.setJavaScriptEnabled(true);
        }
        WebView webView5 = this.webView;
        if (webView5 != null) {
            String str = this.url;
            if (str == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            webView5.loadUrl(str);
        }
        WebView webView6 = this.webView;
        if (webView6 != null) {
            webView6.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
        WebView webView7 = this.webView;
        if (webView7 != null) {
            webView7.setVisibility(4);
        }
        WebView webView8 = this.webView;
        WebSettings settings2 = webView8 == null ? null : webView8.getSettings();
        if (settings2 != null) {
            settings2.setSavePassword(false);
        }
        WebView webView9 = this.webView;
        WebSettings settings3 = webView9 != null ? webView9.getSettings() : null;
        if (settings3 != null) {
            settings3.setSaveFormData(false);
        }
        WebView webView10 = this.webView;
        if (webView10 != null) {
            webView10.setFocusable(true);
        }
        WebView webView11 = this.webView;
        if (webView11 != null) {
            webView11.setFocusableInTouchMode(true);
        }
        WebView webView12 = this.webView;
        if (webView12 != null) {
            webView12.setOnTouchListener(new View.OnTouchListener() { // from class: com.facebook.internal.v
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return WebDialog.m114setUpWebView$lambda7(view, motionEvent);
                }
            });
        }
        linearLayout.setPadding(i2, i2, i2, i2);
        linearLayout.addView(this.webView);
        linearLayout.setBackgroundColor(BACKGROUND_GRAY);
        FrameLayout frameLayout = this.contentFrameLayout;
        if (frameLayout == null) {
            return;
        }
        frameLayout.addView(linearLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setUpWebView$lambda-7, reason: not valid java name */
    public static final boolean m114setUpWebView$lambda7(View view, MotionEvent motionEvent) {
        if (view.hasFocus()) {
            return false;
        }
        view.requestFocus();
        return false;
    }

    @JvmStatic
    public static final void setWebDialogTheme(int i2) {
        INSTANCE.setWebDialogTheme(i2);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        if (this.onCompleteListener == null || this.isListenerCalled) {
            return;
        }
        sendErrorToListener(new FacebookOperationCanceledException());
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        ProgressDialog progressDialog;
        WebView webView = this.webView;
        if (webView != null) {
            webView.stopLoading();
        }
        if (!this.isDetached && (progressDialog = this.spinner) != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        super.dismiss();
    }

    @Nullable
    public final OnCompleteListener getOnCompleteListener() {
        return this.onCompleteListener;
    }

    @Nullable
    protected final WebView getWebView() {
        return this.webView;
    }

    /* renamed from: isListenerCalled, reason: from getter */
    protected final boolean getIsListenerCalled() {
        return this.isListenerCalled;
    }

    /* renamed from: isPageFinished, reason: from getter */
    protected final boolean getIsPageFinished() {
        return this.isPageFinished;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        WindowManager.LayoutParams layoutParams;
        WindowManager.LayoutParams attributes;
        this.isDetached = false;
        Utility utility = Utility.INSTANCE;
        Context context = getContext();
        kotlin.jvm.internal.s.d(context, "context");
        if (Utility.mustFixWindowParamsForAutofill(context) && (layoutParams = this.windowParams) != null) {
            if ((layoutParams == null ? null : layoutParams.token) == null) {
                if (layoutParams != null) {
                    Activity ownerActivity = getOwnerActivity();
                    Window window = ownerActivity == null ? null : ownerActivity.getWindow();
                    layoutParams.token = (window == null || (attributes = window.getAttributes()) == null) ? null : attributes.token;
                }
                WindowManager.LayoutParams layoutParams2 = this.windowParams;
                Utility.logd(LOG_TAG, kotlin.jvm.internal.s.m("Set token on onAttachedToWindow(): ", layoutParams2 != null ? layoutParams2.token : null));
            }
        }
        super.onAttachedToWindow();
    }

    @Override // android.app.Dialog
    protected void onCreate(@Nullable Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        ProgressDialog progressDialog = new ProgressDialog(getContext());
        this.spinner = progressDialog;
        progressDialog.requestWindowFeature(1);
        ProgressDialog progressDialog2 = this.spinner;
        if (progressDialog2 != null) {
            progressDialog2.setMessage(getContext().getString(R.string.com_facebook_loading));
        }
        ProgressDialog progressDialog3 = this.spinner;
        if (progressDialog3 != null) {
            progressDialog3.setCanceledOnTouchOutside(false);
        }
        ProgressDialog progressDialog4 = this.spinner;
        if (progressDialog4 != null) {
            progressDialog4.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.facebook.internal.t
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    WebDialog.m113onCreate$lambda4(this.f2880e, dialogInterface);
                }
            });
        }
        requestWindowFeature(1);
        this.contentFrameLayout = new FrameLayout(getContext());
        resize();
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setSoftInputMode(16);
        }
        createCrossImage();
        if (this.url != null) {
            ImageView imageView = this.crossImageView;
            if (imageView == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            setUpWebView((imageView.getDrawable().getIntrinsicWidth() / 2) + 1);
        }
        FrameLayout frameLayout = this.contentFrameLayout;
        if (frameLayout != null) {
            frameLayout.addView(this.crossImageView, new ViewGroup.LayoutParams(-2, -2));
        }
        FrameLayout frameLayout2 = this.contentFrameLayout;
        if (frameLayout2 == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        setContentView(frameLayout2);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.isDetached = true;
        super.onDetachedFromWindow();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, @NotNull KeyEvent event) {
        kotlin.jvm.internal.s.e(event, "event");
        if (keyCode == 4) {
            WebView webView = this.webView;
            if (webView != null) {
                if (kotlin.jvm.internal.s.a(webView == null ? null : Boolean.valueOf(webView.canGoBack()), Boolean.TRUE)) {
                    WebView webView2 = this.webView;
                    if (webView2 == null) {
                        return true;
                    }
                    webView2.goBack();
                    return true;
                }
            }
            cancel();
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        UploadStagingResourcesTask uploadStagingResourcesTask = this.uploadTask;
        if (uploadStagingResourcesTask != null) {
            if ((uploadStagingResourcesTask == null ? null : uploadStagingResourcesTask.getStatus()) == AsyncTask.Status.PENDING) {
                UploadStagingResourcesTask uploadStagingResourcesTask2 = this.uploadTask;
                if (uploadStagingResourcesTask2 != null) {
                    uploadStagingResourcesTask2.execute(new Void[0]);
                }
                ProgressDialog progressDialog = this.spinner;
                if (progressDialog == null) {
                    return;
                }
                progressDialog.show();
                return;
            }
        }
        resize();
    }

    @Override // android.app.Dialog
    protected void onStop() {
        UploadStagingResourcesTask uploadStagingResourcesTask = this.uploadTask;
        if (uploadStagingResourcesTask != null) {
            uploadStagingResourcesTask.cancel(true);
            ProgressDialog progressDialog = this.spinner;
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
        }
        super.onStop();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowAttributesChanged(@NotNull WindowManager.LayoutParams params) {
        kotlin.jvm.internal.s.e(params, "params");
        if (params.token == null) {
            this.windowParams = params;
        }
        super.onWindowAttributesChanged(params);
    }

    @VisibleForTesting(otherwise = 4)
    @NotNull
    public Bundle parseResponseUri(@Nullable String urlString) {
        Uri uri = Uri.parse(urlString);
        Utility utility = Utility.INSTANCE;
        Bundle urlQueryString = Utility.parseUrlQueryString(uri.getQuery());
        urlQueryString.putAll(Utility.parseUrlQueryString(uri.getFragment()));
        return urlQueryString;
    }

    public final void resize() {
        Object systemService = getContext().getSystemService("window");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
        }
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        int i2 = displayMetrics.widthPixels;
        int i3 = displayMetrics.heightPixels;
        int i4 = i2 < i3 ? i2 : i3;
        if (i2 < i3) {
            i2 = i3;
        }
        int iMin = Math.min(getScaledSize(i4, displayMetrics.density, NO_PADDING_SCREEN_WIDTH, 800), displayMetrics.widthPixels);
        int iMin2 = Math.min(getScaledSize(i2, displayMetrics.density, 800, MAX_PADDING_SCREEN_HEIGHT), displayMetrics.heightPixels);
        Window window = getWindow();
        if (window == null) {
            return;
        }
        window.setLayout(iMin, iMin2);
    }

    protected final void sendErrorToListener(@Nullable Throwable th) {
        if (this.onCompleteListener == null || this.isListenerCalled) {
            return;
        }
        this.isListenerCalled = true;
        FacebookException facebookException = th instanceof FacebookException ? (FacebookException) th : new FacebookException(th);
        OnCompleteListener onCompleteListener = this.onCompleteListener;
        if (onCompleteListener != null) {
            onCompleteListener.onComplete(null, facebookException);
        }
        dismiss();
    }

    protected final void sendSuccessToListener(@Nullable Bundle bundle) {
        OnCompleteListener onCompleteListener = this.onCompleteListener;
        if (onCompleteListener == null || this.isListenerCalled) {
            return;
        }
        this.isListenerCalled = true;
        if (onCompleteListener != null) {
            onCompleteListener.onComplete(bundle, null);
        }
        dismiss();
    }

    protected final void setExpectedRedirectUrl(@NotNull String expectedRedirectUrl) {
        kotlin.jvm.internal.s.e(expectedRedirectUrl, "expectedRedirectUrl");
        this.expectedRedirectUrl = expectedRedirectUrl;
    }

    public final void setOnCompleteListener(@Nullable OnCompleteListener onCompleteListener) {
        this.onCompleteListener = onCompleteListener;
    }

    /* compiled from: WebDialog.kt */
    @Metadata(bv = {}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b,\u0010-J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0005J6\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0007J>\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0007J\b\u0010\u0012\u001a\u00020\nH\u0007J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0007J\u0012\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0007R\u0014\u0010\u0017\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u001b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010\u001fR\u0014\u0010!\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\u0018R\u0014\u0010\"\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010\u0018R\u0014\u0010$\u001a\u00020#8\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b&\u0010\u0018R\u0014\u0010'\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010\u0018R\u0014\u0010(\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010\u001fR\u0018\u0010)\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010+\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010\u0018¨\u0006."}, d2 = {"Lcom/facebook/internal/WebDialog$Companion;", "", "Landroid/content/Context;", "context", "Lkotlin/t;", "initDefaultTheme", "", NativeProtocol.WEB_DIALOG_ACTION, "Landroid/os/Bundle;", "parameters", "", "theme", "Lcom/facebook/internal/WebDialog$OnCompleteListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/facebook/internal/WebDialog;", "newInstance", "Lcom/facebook/login/LoginTargetApp;", "targetApp", "getWebDialogTheme", "setWebDialogTheme", "Lcom/facebook/internal/WebDialog$InitCallback;", "callback", "setInitCallback", "API_EC_DIALOG_CANCEL", "I", "BACKGROUND_GRAY", "DEFAULT_THEME", "", "DISABLE_SSL_CHECK_FOR_TESTING", "Z", "DISPLAY_TOUCH", "Ljava/lang/String;", "LOG_TAG", "MAX_PADDING_SCREEN_HEIGHT", "MAX_PADDING_SCREEN_WIDTH", "", "MIN_SCALE_FACTOR", "D", "NO_PADDING_SCREEN_HEIGHT", "NO_PADDING_SCREEN_WIDTH", "PLATFORM_DIALOG_PATH_REGEX", "initCallback", "Lcom/facebook/internal/WebDialog$InitCallback;", "webDialogTheme", "<init>", "()V", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.o oVar) {
            this();
        }

        @JvmStatic
        public final int getWebDialogTheme() {
            Validate.sdkInitialized();
            return WebDialog.webDialogTheme;
        }

        @JvmStatic
        protected final void initDefaultTheme(@Nullable Context context) throws PackageManager.NameNotFoundException {
            if (context == null) {
                return;
            }
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if ((applicationInfo == null ? null : applicationInfo.metaData) != null && WebDialog.webDialogTheme == 0) {
                    setWebDialogTheme(applicationInfo.metaData.getInt(FacebookSdk.WEB_DIALOG_THEME));
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }

        @JvmStatic
        @NotNull
        public final WebDialog newInstance(@NotNull Context context, @Nullable String action, @Nullable Bundle parameters, int theme, @Nullable OnCompleteListener listener) throws PackageManager.NameNotFoundException {
            kotlin.jvm.internal.s.e(context, "context");
            WebDialog.initDefaultTheme(context);
            return new WebDialog(context, action, parameters, theme, LoginTargetApp.FACEBOOK, listener, null);
        }

        @JvmStatic
        public final void setInitCallback(@Nullable InitCallback initCallback) {
            WebDialog.initCallback = initCallback;
        }

        @JvmStatic
        public final void setWebDialogTheme(int i2) {
            if (i2 == 0) {
                i2 = WebDialog.DEFAULT_THEME;
            }
            WebDialog.webDialogTheme = i2;
        }

        @JvmStatic
        @NotNull
        public final WebDialog newInstance(@NotNull Context context, @Nullable String action, @Nullable Bundle parameters, int theme, @NotNull LoginTargetApp targetApp, @Nullable OnCompleteListener listener) throws PackageManager.NameNotFoundException {
            kotlin.jvm.internal.s.e(context, "context");
            kotlin.jvm.internal.s.e(targetApp, "targetApp");
            WebDialog.initDefaultTheme(context);
            return new WebDialog(context, action, parameters, theme, targetApp, listener, null);
        }
    }

    private WebDialog(Context context, String str, int i2) {
        super(context, i2 == 0 ? INSTANCE.getWebDialogTheme() : i2);
        this.expectedRedirectUrl = ServerProtocol.DIALOG_REDIRECT_URI;
        this.url = str;
    }

    private WebDialog(Context context, String str, Bundle bundle, int i2, LoginTargetApp loginTargetApp, OnCompleteListener onCompleteListener) {
        Uri uriBuildUri;
        super(context, i2 == 0 ? INSTANCE.getWebDialogTheme() : i2);
        String str2 = ServerProtocol.DIALOG_REDIRECT_URI;
        this.expectedRedirectUrl = ServerProtocol.DIALOG_REDIRECT_URI;
        bundle = bundle == null ? new Bundle() : bundle;
        str2 = Utility.isChromeOS(context) ? ServerProtocol.DIALOG_REDIRECT_CHROME_OS_URI : str2;
        this.expectedRedirectUrl = str2;
        bundle.putString(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, str2);
        bundle.putString(ServerProtocol.DIALOG_PARAM_DISPLAY, "touch");
        bundle.putString("client_id", FacebookSdk.getApplicationId());
        kotlin.jvm.internal.x xVar = kotlin.jvm.internal.x.f3460a;
        String str3 = String.format(Locale.ROOT, "android-%s", Arrays.copyOf(new Object[]{FacebookSdk.getSdkVersion()}, 1));
        kotlin.jvm.internal.s.d(str3, "java.lang.String.format(locale, format, *args)");
        bundle.putString(ServerProtocol.DIALOG_PARAM_SDK_VERSION, str3);
        this.onCompleteListener = onCompleteListener;
        if (kotlin.jvm.internal.s.a(str, ShareDialog.WEB_SHARE_DIALOG) && bundle.containsKey(ShareConstants.WEB_DIALOG_PARAM_MEDIA)) {
            this.uploadTask = new UploadStagingResourcesTask(this, str, bundle);
            return;
        }
        if (WhenMappings.$EnumSwitchMapping$0[loginTargetApp.ordinal()] == 1) {
            uriBuildUri = Utility.buildUri(ServerProtocol.getInstagramDialogAuthority(), ServerProtocol.INSTAGRAM_OAUTH_PATH, bundle);
        } else {
            uriBuildUri = Utility.buildUri(ServerProtocol.getDialogAuthority(), FacebookSdk.getGraphApiVersion() + "/dialog/" + ((Object) str), bundle);
        }
        this.url = uriBuildUri.toString();
    }

    /* compiled from: WebDialog.kt */
    @Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b&\u0010'B-\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b&\u0010(J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nJ\u0010\u0010\u000f\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016R(\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R(\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0017R$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR(\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR(\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0007\u0010 \u001a\u0004\b!\u0010\"R\u0018\u0010$\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006)"}, d2 = {"Lcom/facebook/internal/WebDialog$Builder;", "", "Landroid/content/Context;", "context", "", NativeProtocol.WEB_DIALOG_ACTION, "Landroid/os/Bundle;", "parameters", "Lkotlin/t;", "finishInit", "", "theme", "setTheme", "Lcom/facebook/internal/WebDialog$OnCompleteListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnCompleteListener", "Lcom/facebook/internal/WebDialog;", "build", "<set-?>", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "applicationId", "Ljava/lang/String;", "getApplicationId", "()Ljava/lang/String;", "I", "getTheme", "()I", "Lcom/facebook/internal/WebDialog$OnCompleteListener;", "getListener", "()Lcom/facebook/internal/WebDialog$OnCompleteListener;", "Landroid/os/Bundle;", "getParameters", "()Landroid/os/Bundle;", "Lcom/facebook/AccessToken;", "accessToken", "Lcom/facebook/AccessToken;", "<init>", "(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)V", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
    public static class Builder {

        @Nullable
        private AccessToken accessToken;

        @Nullable
        private String action;

        @Nullable
        private String applicationId;

        @Nullable
        private Context context;

        @Nullable
        private OnCompleteListener listener;

        @Nullable
        private Bundle parameters;
        private int theme;

        public Builder(@NotNull Context context, @NotNull String action, @Nullable Bundle bundle) {
            kotlin.jvm.internal.s.e(context, "context");
            kotlin.jvm.internal.s.e(action, "action");
            AccessToken.Companion companion = AccessToken.INSTANCE;
            this.accessToken = companion.getCurrentAccessToken();
            if (!companion.isCurrentAccessTokenActive()) {
                String metadataApplicationId = Utility.getMetadataApplicationId(context);
                if (metadataApplicationId == null) {
                    throw new FacebookException("Attempted to create a builder without a valid access token or a valid default Application ID.");
                }
                this.applicationId = metadataApplicationId;
            }
            finishInit(context, action, bundle);
        }

        private final void finishInit(Context context, String str, Bundle bundle) {
            this.context = context;
            this.action = str;
            if (bundle != null) {
                this.parameters = bundle;
            } else {
                this.parameters = new Bundle();
            }
        }

        @Nullable
        public WebDialog build() {
            AccessToken accessToken = this.accessToken;
            if (accessToken != null) {
                Bundle bundle = this.parameters;
                if (bundle != null) {
                    bundle.putString("app_id", accessToken == null ? null : accessToken.getApplicationId());
                }
                Bundle bundle2 = this.parameters;
                if (bundle2 != null) {
                    AccessToken accessToken2 = this.accessToken;
                    bundle2.putString("access_token", accessToken2 != null ? accessToken2.getToken() : null);
                }
            } else {
                Bundle bundle3 = this.parameters;
                if (bundle3 != null) {
                    bundle3.putString("app_id", this.applicationId);
                }
            }
            Companion companion = WebDialog.INSTANCE;
            Context context = this.context;
            if (context != null) {
                return companion.newInstance(context, this.action, this.parameters, this.theme, this.listener);
            }
            throw new IllegalStateException("Required value was null.".toString());
        }

        @Nullable
        public final String getApplicationId() {
            return this.applicationId;
        }

        @Nullable
        public final Context getContext() {
            return this.context;
        }

        @Nullable
        public final OnCompleteListener getListener() {
            return this.listener;
        }

        @Nullable
        public final Bundle getParameters() {
            return this.parameters;
        }

        public final int getTheme() {
            return this.theme;
        }

        @NotNull
        public final Builder setOnCompleteListener(@Nullable OnCompleteListener listener) {
            this.listener = listener;
            return this;
        }

        @NotNull
        public final Builder setTheme(int theme) {
            this.theme = theme;
            return this;
        }

        public Builder(@NotNull Context context, @Nullable String str, @NotNull String action, @Nullable Bundle bundle) {
            kotlin.jvm.internal.s.e(context, "context");
            kotlin.jvm.internal.s.e(action, "action");
            this.applicationId = Validate.notNullOrEmpty(str == null ? Utility.getMetadataApplicationId(context) : str, "applicationId");
            finishInit(context, action, bundle);
        }
    }
}
