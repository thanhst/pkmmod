package com.facebook.login;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LoginConfiguration.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\b\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB!\b\u0017\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006B+\b\u0016\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0002\u0010\bR\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/facebook/login/LoginConfiguration;", "", "permissions", "", "", "nonce", "(Ljava/util/Collection;Ljava/lang/String;)V", "codeVerifier", "(Ljava/util/Collection;Ljava/lang/String;Ljava/lang/String;)V", "getCodeVerifier", "()Ljava/lang/String;", "getNonce", "", "getPermissions", "()Ljava/util/Set;", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class LoginConfiguration {

    @NotNull
    public static final String OPENID = "openid";

    @NotNull
    private final String codeVerifier;

    @NotNull
    private final String nonce;

    @NotNull
    private final Set<String> permissions;

    @JvmOverloads
    public LoginConfiguration(@Nullable Collection<String> collection) {
        this(collection, null, 2, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ LoginConfiguration(Collection collection, String str, int i2, kotlin.jvm.internal.o oVar) {
        if ((i2 & 2) != 0) {
            str = UUID.randomUUID().toString();
            s.d(str, "randomUUID().toString()");
        }
        this(collection, str);
    }

    @NotNull
    public final String getCodeVerifier() {
        return this.codeVerifier;
    }

    @NotNull
    public final String getNonce() {
        return this.nonce;
    }

    @NotNull
    public final Set<String> getPermissions() {
        return this.permissions;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LoginConfiguration(@Nullable Collection<String> collection, @NotNull String nonce) {
        this(collection, nonce, PKCEUtil.generateCodeVerifier());
        s.e(nonce, "nonce");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ LoginConfiguration(Collection collection, String str, String str2, int i2, kotlin.jvm.internal.o oVar) {
        collection = (i2 & 1) != 0 ? null : collection;
        if ((i2 & 2) != 0) {
            str = UUID.randomUUID().toString();
            s.d(str, "randomUUID().toString()");
        }
        this(collection, str, str2);
    }

    public LoginConfiguration(@Nullable Collection<String> collection, @NotNull String nonce, @NotNull String codeVerifier) {
        s.e(nonce, "nonce");
        s.e(codeVerifier, "codeVerifier");
        if (NonceUtil.isValidNonce(nonce) && PKCEUtil.isValidCodeVerifier(codeVerifier)) {
            HashSet hashSet = collection != null ? new HashSet(collection) : new HashSet();
            hashSet.add("openid");
            Set<String> setUnmodifiableSet = Collections.unmodifiableSet(hashSet);
            s.d(setUnmodifiableSet, "unmodifiableSet(permissions)");
            this.permissions = setUnmodifiableSet;
            this.nonce = nonce;
            this.codeVerifier = codeVerifier;
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}
