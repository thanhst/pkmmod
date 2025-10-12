package v;

import android.text.TextUtils;

/* compiled from: MediaSessionManagerImplBase.java */
/* loaded from: classes.dex */
class e implements c {

    /* renamed from: a, reason: collision with root package name */
    private String f4149a;

    /* renamed from: b, reason: collision with root package name */
    private int f4150b;

    /* renamed from: c, reason: collision with root package name */
    private int f4151c;

    e(String str, int i2, int i3) {
        this.f4149a = str;
        this.f4150b = i2;
        this.f4151c = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return (this.f4150b < 0 || eVar.f4150b < 0) ? TextUtils.equals(this.f4149a, eVar.f4149a) && this.f4151c == eVar.f4151c : TextUtils.equals(this.f4149a, eVar.f4149a) && this.f4150b == eVar.f4150b && this.f4151c == eVar.f4151c;
    }

    public int hashCode() {
        return androidx.core.util.c.b(this.f4149a, Integer.valueOf(this.f4151c));
    }
}
