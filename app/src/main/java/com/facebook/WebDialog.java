package com.facebook;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

/* compiled from: WebDialog.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0007¨\u0006\t"}, d2 = {"Lcom/facebook/WebDialog;", "", "", "getWebDialogTheme", "theme", "Lkotlin/t;", "setWebDialogTheme", "<init>", "()V", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class WebDialog {

    @NotNull
    public static final WebDialog INSTANCE = new WebDialog();

    private WebDialog() {
    }

    @JvmStatic
    public static final int getWebDialogTheme() {
        return com.facebook.internal.WebDialog.INSTANCE.getWebDialogTheme();
    }

    @JvmStatic
    public static final void setWebDialogTheme(int i2) {
        com.facebook.internal.WebDialog.INSTANCE.setWebDialogTheme(i2);
    }
}
