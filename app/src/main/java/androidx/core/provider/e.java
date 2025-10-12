package androidx.core.provider;

import android.util.Base64;
import androidx.annotation.ArrayRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.h;
import java.util.List;

/* compiled from: FontRequest.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final String f1588a;

    /* renamed from: b, reason: collision with root package name */
    private final String f1589b;

    /* renamed from: c, reason: collision with root package name */
    private final String f1590c;

    /* renamed from: d, reason: collision with root package name */
    private final List<List<byte[]>> f1591d;

    /* renamed from: e, reason: collision with root package name */
    private final int f1592e = 0;

    /* renamed from: f, reason: collision with root package name */
    private final String f1593f;

    public e(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull List<List<byte[]>> list) {
        this.f1588a = (String) h.f(str);
        this.f1589b = (String) h.f(str2);
        this.f1590c = (String) h.f(str3);
        this.f1591d = (List) h.f(list);
        this.f1593f = a(str, str2, str3);
    }

    private String a(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        return str + "-" + str2 + "-" + str3;
    }

    @Nullable
    public List<List<byte[]>> b() {
        return this.f1591d;
    }

    @ArrayRes
    public int c() {
        return this.f1592e;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    String d() {
        return this.f1593f;
    }

    @NonNull
    public String e() {
        return this.f1588a;
    }

    @NonNull
    public String f() {
        return this.f1589b;
    }

    @NonNull
    public String g() {
        return this.f1590c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f1588a + ", mProviderPackage: " + this.f1589b + ", mQuery: " + this.f1590c + ", mCertificates:");
        for (int i2 = 0; i2 < this.f1591d.size(); i2++) {
            sb.append(" [");
            List<byte[]> list = this.f1591d.get(i2);
            for (int i3 = 0; i3 < list.size(); i3++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString(list.get(i3), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.f1592e);
        return sb.toString();
    }
}
