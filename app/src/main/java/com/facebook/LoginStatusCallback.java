package com.facebook;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: LoginStatusCallback.kt */
@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&J\u0014\u0010\n\u001a\u00020\u00042\n\u0010\t\u001a\u00060\u0007j\u0002`\bH&¨\u0006\u000b"}, d2 = {"Lcom/facebook/LoginStatusCallback;", "", "Lcom/facebook/AccessToken;", "accessToken", "Lkotlin/t;", "onCompleted", "onFailure", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "onError", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public interface LoginStatusCallback {
    void onCompleted(@NotNull AccessToken accessToken);

    void onError(@NotNull Exception exc);

    void onFailure();
}
