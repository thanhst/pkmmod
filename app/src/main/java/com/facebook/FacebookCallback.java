package com.facebook;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: FacebookCallback.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0004H&J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH&¨\u0006\u000b"}, d2 = {"Lcom/facebook/FacebookCallback;", "RESULT", "", "result", "Lkotlin/t;", "onSuccess", "(Ljava/lang/Object;)V", "onCancel", "Lcom/facebook/FacebookException;", "error", "onError", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public interface FacebookCallback<RESULT> {
    void onCancel();

    void onError(@NotNull FacebookException facebookException);

    void onSuccess(RESULT result);
}
