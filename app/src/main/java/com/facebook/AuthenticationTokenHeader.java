package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import androidx.annotation.VisibleForTesting;
import com.facebook.internal.Validate;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AuthenticationTokenHeader.kt */
@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u0000 '2\u00020\u0001:\u0001'B\u0011\b\u0016\u0012\u0006\u0010\u001f\u001a\u00020\u0002¢\u0006\u0004\b \u0010!B\u0011\b\u0010\u0012\u0006\u0010\"\u001a\u00020\u0006¢\u0006\u0004\b \u0010#B\u0011\b\u0010\u0012\u0006\u0010$\u001a\u00020\u0012¢\u0006\u0004\b \u0010%B!\b\u0017\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0002¢\u0006\u0004\b \u0010&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016J\u0013\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\b\u0010\u0011\u001a\u00020\bH\u0016J\u000f\u0010\u0015\u001a\u00020\u0012H\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0016\u001a\u00020\u0002H\u0007R\u0017\u0010\u0017\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u001aR\u0017\u0010\u001d\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001a¨\u0006("}, d2 = {"Lcom/facebook/AuthenticationTokenHeader;", "Landroid/os/Parcelable;", "", "headerString", "", "isValidHeader", "Landroid/os/Parcel;", "dest", "", "flags", "Lkotlin/t;", "writeToParcel", "describeContents", "toString", "", "other", "equals", "hashCode", "Lorg/json/JSONObject;", "toJSONObject$facebook_core_release", "()Lorg/json/JSONObject;", "toJSONObject", "toEnCodedString", "alg", "Ljava/lang/String;", "getAlg", "()Ljava/lang/String;", "typ", "getTyp", "kid", "getKid", "encodedHeaderString", "<init>", "(Ljava/lang/String;)V", "parcel", "(Landroid/os/Parcel;)V", "jsonObject", "(Lorg/json/JSONObject;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AuthenticationTokenHeader implements Parcelable {

    @NotNull
    private final String alg;

    @NotNull
    private final String kid;

    @NotNull
    private final String typ;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<AuthenticationTokenHeader> CREATOR = new Parcelable.Creator<AuthenticationTokenHeader>() { // from class: com.facebook.AuthenticationTokenHeader$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public AuthenticationTokenHeader createFromParcel(@NotNull Parcel source) {
            kotlin.jvm.internal.s.e(source, "source");
            return new AuthenticationTokenHeader(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public AuthenticationTokenHeader[] newArray(int size) {
            return new AuthenticationTokenHeader[size];
        }
    };

    public AuthenticationTokenHeader(@NotNull String encodedHeaderString) throws JSONException {
        kotlin.jvm.internal.s.e(encodedHeaderString, "encodedHeaderString");
        if (!isValidHeader(encodedHeaderString)) {
            throw new IllegalArgumentException("Invalid Header".toString());
        }
        byte[] decodedBytes = Base64.decode(encodedHeaderString, 0);
        kotlin.jvm.internal.s.d(decodedBytes, "decodedBytes");
        JSONObject jSONObject = new JSONObject(new String(decodedBytes, kotlin.text.d.UTF_8));
        String string = jSONObject.getString("alg");
        kotlin.jvm.internal.s.d(string, "jsonObj.getString(\"alg\")");
        this.alg = string;
        String string2 = jSONObject.getString("typ");
        kotlin.jvm.internal.s.d(string2, "jsonObj.getString(\"typ\")");
        this.typ = string2;
        String string3 = jSONObject.getString("kid");
        kotlin.jvm.internal.s.d(string3, "jsonObj.getString(\"kid\")");
        this.kid = string3;
    }

    private final boolean isValidHeader(String headerString) {
        Validate.notEmpty(headerString, "encodedHeaderString");
        byte[] decodedBytes = Base64.decode(headerString, 0);
        kotlin.jvm.internal.s.d(decodedBytes, "decodedBytes");
        try {
            JSONObject jSONObject = new JSONObject(new String(decodedBytes, kotlin.text.d.UTF_8));
            String alg = jSONObject.optString("alg");
            kotlin.jvm.internal.s.d(alg, "alg");
            boolean z2 = (alg.length() > 0) && kotlin.jvm.internal.s.a(alg, "RS256");
            String strOptString = jSONObject.optString("kid");
            kotlin.jvm.internal.s.d(strOptString, "jsonObj.optString(\"kid\")");
            boolean z3 = strOptString.length() > 0;
            String strOptString2 = jSONObject.optString("typ");
            kotlin.jvm.internal.s.d(strOptString2, "jsonObj.optString(\"typ\")");
            return z2 && z3 && (strOptString2.length() > 0);
        } catch (JSONException unused) {
            return false;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AuthenticationTokenHeader)) {
            return false;
        }
        AuthenticationTokenHeader authenticationTokenHeader = (AuthenticationTokenHeader) other;
        return kotlin.jvm.internal.s.a(this.alg, authenticationTokenHeader.alg) && kotlin.jvm.internal.s.a(this.typ, authenticationTokenHeader.typ) && kotlin.jvm.internal.s.a(this.kid, authenticationTokenHeader.kid);
    }

    @NotNull
    public final String getAlg() {
        return this.alg;
    }

    @NotNull
    public final String getKid() {
        return this.kid;
    }

    @NotNull
    public final String getTyp() {
        return this.typ;
    }

    public int hashCode() {
        return ((((527 + this.alg.hashCode()) * 31) + this.typ.hashCode()) * 31) + this.kid.hashCode();
    }

    @VisibleForTesting(otherwise = 2)
    @NotNull
    public final String toEnCodedString() {
        String string = toString();
        Charset charset = kotlin.text.d.UTF_8;
        if (string == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = string.getBytes(charset);
        kotlin.jvm.internal.s.d(bytes, "(this as java.lang.String).getBytes(charset)");
        String strEncodeToString = Base64.encodeToString(bytes, 0);
        kotlin.jvm.internal.s.d(strEncodeToString, "encodeToString(claimsJsonString.toByteArray(), Base64.DEFAULT)");
        return strEncodeToString;
    }

    @NotNull
    public final JSONObject toJSONObject$facebook_core_release() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("alg", this.alg);
        jSONObject.put("typ", this.typ);
        jSONObject.put("kid", this.kid);
        return jSONObject;
    }

    @NotNull
    public String toString() {
        String string = toJSONObject$facebook_core_release().toString();
        kotlin.jvm.internal.s.d(string, "headerJsonObject.toString()");
        return string;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel dest, int i2) {
        kotlin.jvm.internal.s.e(dest, "dest");
        dest.writeString(this.alg);
        dest.writeString(this.typ);
        dest.writeString(this.kid);
    }

    public AuthenticationTokenHeader(@NotNull Parcel parcel) {
        kotlin.jvm.internal.s.e(parcel, "parcel");
        this.alg = Validate.notNullOrEmpty(parcel.readString(), "alg");
        this.typ = Validate.notNullOrEmpty(parcel.readString(), "typ");
        this.kid = Validate.notNullOrEmpty(parcel.readString(), "kid");
    }

    public AuthenticationTokenHeader(@NotNull JSONObject jsonObject) throws JSONException {
        kotlin.jvm.internal.s.e(jsonObject, "jsonObject");
        String string = jsonObject.getString("alg");
        kotlin.jvm.internal.s.d(string, "jsonObject.getString(\"alg\")");
        this.alg = string;
        String string2 = jsonObject.getString("typ");
        kotlin.jvm.internal.s.d(string2, "jsonObject.getString(\"typ\")");
        this.typ = string2;
        String string3 = jsonObject.getString("kid");
        kotlin.jvm.internal.s.d(string3, "jsonObject.getString(\"kid\")");
        this.kid = string3;
    }

    @VisibleForTesting(otherwise = 2)
    public AuthenticationTokenHeader(@NotNull String alg, @NotNull String typ, @NotNull String kid) {
        kotlin.jvm.internal.s.e(alg, "alg");
        kotlin.jvm.internal.s.e(typ, "typ");
        kotlin.jvm.internal.s.e(kid, "kid");
        this.alg = alg;
        this.typ = typ;
        this.kid = kid;
    }
}
