package androidx.core.util;

import androidx.annotation.NonNull;

/* compiled from: Pair.java */
/* loaded from: classes.dex */
public class d<F, S> {

    /* renamed from: a, reason: collision with root package name */
    public final F f1634a;

    /* renamed from: b, reason: collision with root package name */
    public final S f1635b;

    public d(F f2, S s2) {
        this.f1634a = f2;
        this.f1635b = s2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return c.a(dVar.f1634a, this.f1634a) && c.a(dVar.f1635b, this.f1635b);
    }

    public int hashCode() {
        F f2 = this.f1634a;
        int iHashCode = f2 == null ? 0 : f2.hashCode();
        S s2 = this.f1635b;
        return iHashCode ^ (s2 != null ? s2.hashCode() : 0);
    }

    @NonNull
    public String toString() {
        return "Pair{" + this.f1634a + " " + this.f1635b + "}";
    }
}
