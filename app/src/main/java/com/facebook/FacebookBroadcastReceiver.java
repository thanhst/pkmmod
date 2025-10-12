package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.bolts.AppLinks;
import com.facebook.internal.NativeProtocol;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: FacebookBroadcastReceiver.kt */
@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0014J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0014¨\u0006\u0011"}, d2 = {"Lcom/facebook/FacebookBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "Lkotlin/t;", "onReceive", "", "appCallId", NativeProtocol.WEB_DIALOG_ACTION, "Landroid/os/Bundle;", AppLinks.KEY_NAME_EXTRAS, "onSuccessfulAppCall", "onFailedAppCall", "<init>", "()V", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public class FacebookBroadcastReceiver extends BroadcastReceiver {
    protected void onFailedAppCall(@NotNull String appCallId, @NotNull String action, @NotNull Bundle extras) {
        kotlin.jvm.internal.s.e(appCallId, "appCallId");
        kotlin.jvm.internal.s.e(action, "action");
        kotlin.jvm.internal.s.e(extras, "extras");
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
        kotlin.jvm.internal.s.e(context, "context");
        kotlin.jvm.internal.s.e(intent, "intent");
        String stringExtra = intent.getStringExtra(NativeProtocol.EXTRA_PROTOCOL_CALL_ID);
        String stringExtra2 = intent.getStringExtra(NativeProtocol.EXTRA_PROTOCOL_ACTION);
        Bundle extras = intent.getExtras();
        if (stringExtra == null || stringExtra2 == null || extras == null) {
            return;
        }
        if (NativeProtocol.isErrorResult(intent)) {
            onFailedAppCall(stringExtra, stringExtra2, extras);
        } else {
            onSuccessfulAppCall(stringExtra, stringExtra2, extras);
        }
    }

    protected void onSuccessfulAppCall(@NotNull String appCallId, @NotNull String action, @NotNull Bundle extras) {
        kotlin.jvm.internal.s.e(appCallId, "appCallId");
        kotlin.jvm.internal.s.e(action, "action");
        kotlin.jvm.internal.s.e(extras, "extras");
    }
}
