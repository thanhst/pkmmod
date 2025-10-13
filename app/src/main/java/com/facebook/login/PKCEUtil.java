package com.facebook.login;

import android.os.Bundle;
import android.util.Base64;
import com.adjust.sdk.Constants;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.HttpMethod;
import com.facebook.internal.ServerProtocol;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.s;
import kotlin.random.Random;
import kotlin.text.Regex;
import s0.c_s0;
import s0.f_s0;
import s0.l_s0;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PKCEUtil.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0007J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\f\u001a\u00020\u0006H\u0007J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u000f"}, d2 = {"Lcom/facebook/login/PKCEUtil;", "", "()V", "createCodeExchangeRequest", "Lcom/facebook/GraphRequest;", "authorizationCode", "", "redirectUri", "codeVerifier", "generateCodeChallenge", "codeChallengeMethod", "Lcom/facebook/login/CodeChallengeMethod;", "generateCodeVerifier", "isValidCodeVerifier", "", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class PKCEUtil {

    @NotNull
    public static final PKCEUtil INSTANCE = new PKCEUtil();

    private PKCEUtil() {
    }

    @JvmStatic
    @NotNull
    public static final GraphRequest createCodeExchangeRequest(@NotNull String authorizationCode, @NotNull String redirectUri, @NotNull String codeVerifier) {
        s.e(authorizationCode, "authorizationCode");
        s.e(redirectUri, "redirectUri");
        s.e(codeVerifier, "codeVerifier");
        Bundle bundle = new Bundle();
        bundle.putString("code", authorizationCode);
        bundle.putString("client_id", FacebookSdk.getApplicationId());
        bundle.putString(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, redirectUri);
        bundle.putString("code_verifier", codeVerifier);
        GraphRequest graphRequestNewGraphPathRequest = GraphRequest.INSTANCE.newGraphPathRequest(null, "oauth/access_token", null);
        graphRequestNewGraphPathRequest.setHttpMethod(HttpMethod.GET);
        graphRequestNewGraphPathRequest.setParameters(bundle);
        return graphRequestNewGraphPathRequest;
    }

    @JvmStatic
    @NotNull
    public static final String generateCodeChallenge(@NotNull String codeVerifier, @NotNull CodeChallengeMethod codeChallengeMethod) throws FacebookException, NoSuchAlgorithmException {
        s.e(codeVerifier, "codeVerifier");
        s.e(codeChallengeMethod, "codeChallengeMethod");
        if (!isValidCodeVerifier(codeVerifier)) {
            throw new FacebookException("Invalid Code Verifier.");
        }
        if (codeChallengeMethod == CodeChallengeMethod.PLAIN) {
            return codeVerifier;
        }
        try {
            byte[] bytes = codeVerifier.getBytes(kotlin.text.d.US_ASCII);
            s.d(bytes, "(this as java.lang.String).getBytes(charset)");
            MessageDigest messageDigest = MessageDigest.getInstance(Constants.SHA256);
            messageDigest.update(bytes, 0, bytes.length);
            String strEncodeToString = Base64.encodeToString(messageDigest.digest(), 11);
            s.d(strEncodeToString, "{\n      // try to generate challenge with S256\n      val bytes: ByteArray = codeVerifier.toByteArray(Charsets.US_ASCII)\n      val messageDigest = MessageDigest.getInstance(\"SHA-256\")\n      messageDigest.update(bytes, 0, bytes.size)\n      val digest = messageDigest.digest()\n\n      Base64.encodeToString(digest, Base64.URL_SAFE or Base64.NO_PADDING or Base64.NO_WRAP)\n    }");
            return strEncodeToString;
        } catch (Exception e2) {
            throw new FacebookException(e2);
        }
    }

    @JvmStatic
    @NotNull
    public static final String generateCodeVerifier() {
        int iG = l_s0.g(new f_s0(43, 128), Random.INSTANCE);
        List listO = CollectionsKt___CollectionsKt.O(CollectionsKt___CollectionsKt.O(CollectionsKt___CollectionsKt.O(CollectionsKt___CollectionsKt.O(CollectionsKt___CollectionsKt.N(CollectionsKt___CollectionsKt.M(new c_s0('a', 'z'), new c_s0('A', 'Z')), new c_s0('0', '9')), '-'), '.'), '_'), '~');
        ArrayList arrayList = new ArrayList(iG);
        for (int i2 = 0; i2 < iG; i2++) {
            arrayList.add(Character.valueOf(((Character) CollectionsKt___CollectionsKt.P(listO, Random.INSTANCE)).charValue()));
        }
        return CollectionsKt___CollectionsKt.I(arrayList, "", null, null, 0, null, null, 62, null);
    }

    @JvmStatic
    public static final boolean isValidCodeVerifier(@Nullable String codeVerifier) {
        if ((codeVerifier == null || codeVerifier.length() == 0) || codeVerifier.length() < 43 || codeVerifier.length() > 128) {
            return false;
        }
        return new Regex("^[-._~A-Za-z0-9]+$").matches(codeVerifier);
    }
}
