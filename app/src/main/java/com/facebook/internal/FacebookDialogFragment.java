package com.facebook.internal;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.FragmentActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;

import java.util.Arrays;
import kotlin.Metadata;
import s.a_s;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FacebookDialogFragment.kt */
@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u001b\u0010\fJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016J\u000f\u0010\r\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0006H\u0016R$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/facebook/internal/FacebookDialogFragment;", "Landroidx/fragment/app/c;", "Landroid/os/Bundle;", "values", "Lcom/facebook/FacebookException;", "error", "Lkotlin/t;", "onCompleteWebDialog", "onCompleteWebFallbackDialog", "savedInstanceState", "onCreate", "initDialog$facebook_common_release", "()V", "initDialog", "Landroid/app/Dialog;", "onCreateDialog", "onResume", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "onDestroyView", "innerDialog", "Landroid/app/Dialog;", "getInnerDialog", "()Landroid/app/Dialog;", "setInnerDialog", "(Landroid/app/Dialog;)V", "<init>", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class FacebookDialogFragment extends androidx.fragment.app.c {

    @NotNull
    public static final String TAG = "FacebookDialogFragment";

    @Nullable
    private Dialog innerDialog;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initDialog$lambda-0, reason: not valid java name */
    public static final void m93initDialog$lambda0(FacebookDialogFragment this$0, Bundle bundle, FacebookException facebookException) {
        kotlin.jvm.internal.s.e(this$0, "this$0");
        this$0.onCompleteWebDialog(bundle, facebookException);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initDialog$lambda-1, reason: not valid java name */
    public static final void m94initDialog$lambda1(FacebookDialogFragment this$0, Bundle bundle, FacebookException facebookException) {
        kotlin.jvm.internal.s.e(this$0, "this$0");
        this$0.onCompleteWebFallbackDialog(bundle);
    }

    private final void onCompleteWebDialog(Bundle bundle, FacebookException facebookException) {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
        Intent intent = activity.getIntent();
        kotlin.jvm.internal.s.d(intent, "fragmentActivity.intent");
        activity.setResult(facebookException == null ? -1 : 0, NativeProtocol.createProtocolResultIntent(intent, bundle, facebookException));
        activity.finish();
    }

    private final void onCompleteWebFallbackDialog(Bundle bundle) {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        Intent intent = new Intent();
        if (bundle == null) {
            bundle = new Bundle();
        }
        intent.putExtras(bundle);
        activity.setResult(-1, intent);
        activity.finish();
    }

    @Override // androidx.fragment.app.Fragment, androidx.lifecycle.i
    @NonNull
    public /* bridge */ /* synthetic */ a_s getDefaultViewModelCreationExtras() {
        return androidx.lifecycle.h.a(this);
    }

    @Nullable
    public final Dialog getInnerDialog() {
        return this.innerDialog;
    }

    @VisibleForTesting
    public final void initDialog$facebook_common_release() throws PackageManager.NameNotFoundException {
        FragmentActivity activity;
        WebDialog webDialogNewInstance;
        if (this.innerDialog == null && (activity = getActivity()) != null) {
            Intent intent = activity.getIntent();
            NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
            kotlin.jvm.internal.s.d(intent, "intent");
            Bundle methodArgumentsFromIntent = NativeProtocol.getMethodArgumentsFromIntent(intent);
            if (methodArgumentsFromIntent == null ? false : methodArgumentsFromIntent.getBoolean(NativeProtocol.WEB_DIALOG_IS_FALLBACK, false)) {
                String string = methodArgumentsFromIntent != null ? methodArgumentsFromIntent.getString("url") : null;
                if (Utility.isNullOrEmpty(string)) {
                    Utility.logd(TAG, "Cannot start a fallback WebDialog with an empty/missing 'url'");
                    activity.finish();
                    return;
                }
                kotlin.jvm.internal.x xVar = kotlin.jvm.internal.x.f3460a;
                String str = String.format("fb%s://bridge/", Arrays.copyOf(new Object[]{FacebookSdk.getApplicationId()}, 1));
                kotlin.jvm.internal.s.d(str, "java.lang.String.format(format, *args)");
                FacebookWebFallbackDialog.Companion companion = FacebookWebFallbackDialog.INSTANCE;
                if (string == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                webDialogNewInstance = companion.newInstance(activity, string, str);
                webDialogNewInstance.setOnCompleteListener(new WebDialog.OnCompleteListener() { // from class: com.facebook.internal.c
                    @Override // com.facebook.internal.WebDialog.OnCompleteListener
                    public final void onComplete(Bundle bundle, FacebookException facebookException) {
                        FacebookDialogFragment.m94initDialog$lambda1(this.f2857a, bundle, facebookException);
                    }
                });
            } else {
                String string2 = methodArgumentsFromIntent == null ? null : methodArgumentsFromIntent.getString(NativeProtocol.WEB_DIALOG_ACTION);
                Bundle bundle = methodArgumentsFromIntent != null ? methodArgumentsFromIntent.getBundle(NativeProtocol.WEB_DIALOG_PARAMS) : null;
                if (Utility.isNullOrEmpty(string2)) {
                    Utility.logd(TAG, "Cannot start a WebDialog with an empty/missing 'actionName'");
                    activity.finish();
                    return;
                } else {
                    if (string2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    webDialogNewInstance = new WebDialog.Builder(activity, string2, bundle).setOnCompleteListener(new WebDialog.OnCompleteListener() { // from class: com.facebook.internal.b
                        @Override // com.facebook.internal.WebDialog.OnCompleteListener
                        public final void onComplete(Bundle bundle2, FacebookException facebookException) {
                            FacebookDialogFragment.m93initDialog$lambda0(this.f2856a, bundle2, facebookException);
                        }
                    }).build();
                }
            }
            this.innerDialog = webDialogNewInstance;
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        kotlin.jvm.internal.s.e(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        if ((this.innerDialog instanceof WebDialog) && isResumed()) {
            Dialog dialog = this.innerDialog;
            if (dialog == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.facebook.internal.WebDialog");
            }
            ((WebDialog) dialog).resize();
        }
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) throws PackageManager.NameNotFoundException {
        super.onCreate(bundle);
        initDialog$facebook_common_release();
    }

    @Override // androidx.fragment.app.c
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog dialog = this.innerDialog;
        if (dialog != null) {
            if (dialog != null) {
                return dialog;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.app.Dialog");
        }
        onCompleteWebDialog(null, null);
        setShowsDialog(false);
        Dialog dialogOnCreateDialog = super.onCreateDialog(savedInstanceState);
        kotlin.jvm.internal.s.d(dialogOnCreateDialog, "super.onCreateDialog(savedInstanceState)");
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Dialog dialog = getDialog();
        if (dialog != null && getRetainInstance()) {
            dialog.setDismissMessage(null);
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Dialog dialog = this.innerDialog;
        if (dialog instanceof WebDialog) {
            if (dialog == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.facebook.internal.WebDialog");
            }
            ((WebDialog) dialog).resize();
        }
    }

    public final void setInnerDialog(@Nullable Dialog dialog) {
        this.innerDialog = dialog;
    }
}
