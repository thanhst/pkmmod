package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.internal.AppCall;
import kotlin.Metadata;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ResultProcessor.kt */
@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016R\u001a\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/facebook/share/internal/ResultProcessor;", "", "Lcom/facebook/internal/AppCall;", "appCall", "Landroid/os/Bundle;", "results", "Lkotlin/t;", "onSuccess", "onCancel", "Lcom/facebook/FacebookException;", "error", "onError", "Lcom/facebook/FacebookCallback;", "appCallback", "Lcom/facebook/FacebookCallback;", "<init>", "(Lcom/facebook/FacebookCallback;)V", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class ResultProcessor {

    @Nullable
    private final FacebookCallback<?> appCallback;

    public ResultProcessor(@Nullable FacebookCallback<?> facebookCallback) {
        this.appCallback = facebookCallback;
    }

    public void onCancel(@NotNull AppCall appCall) {
        s.e(appCall, "appCall");
        FacebookCallback<?> facebookCallback = this.appCallback;
        if (facebookCallback == null) {
            return;
        }
        facebookCallback.onCancel();
    }

    public void onError(@NotNull AppCall appCall, @NotNull FacebookException error) {
        s.e(appCall, "appCall");
        s.e(error, "error");
        FacebookCallback<?> facebookCallback = this.appCallback;
        if (facebookCallback == null) {
            return;
        }
        facebookCallback.onError(error);
    }

    public abstract void onSuccess(@NotNull AppCall appCall, @Nullable Bundle bundle);
}
