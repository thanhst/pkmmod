package v;

import android.text.TextUtils;

/* compiled from: MediaSessionManagerImplBase.java */
/* loaded from: classes.dex */
class e_v implements c_v {

    /* renamed from: a, reason: collision with root package name */
    private String f4149a;

    /* renamed from: b, reason: collision with root package name */
    private int f4150b;

    /* renamed from: c, reason: collision with root package name */
    private int f4151c;

    e_v(String str, int i2, int i3) {
        this.f4149a = str;
        this.f4150b = i2;
        this.f4151c = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e_v)) {
            return false;
        }
        e_v eVVar = (e_v) obj;
        return (this.f4150b < 0 || eVVar.f4150b < 0) ? TextUtils.equals(this.f4149a, eVVar.f4149a) && this.f4151c == eVVar.f4151c : TextUtils.equals(this.f4149a, eVVar.f4149a) && this.f4150b == eVVar.f4150b && this.f4151c == eVVar.f4151c;
    }

    public int hashCode() {
        return androidx.core.util.c.b(this.f4149a, Integer.valueOf(this.f4151c));
    }
}
