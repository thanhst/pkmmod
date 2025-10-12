package androidx.core.graphics;

import android.graphics.Insets;
import android.graphics.Rect;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: Insets.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public static final b f1492e = new b(0, 0, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final int f1493a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1494b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1495c;

    /* renamed from: d, reason: collision with root package name */
    public final int f1496d;

    /* compiled from: Insets.java */
    @RequiresApi(29)
    static class a {
        @DoNotInline
        static Insets a(int i2, int i3, int i4, int i5) {
            return Insets.of(i2, i3, i4, i5);
        }
    }

    private b(int i2, int i3, int i4, int i5) {
        this.f1493a = i2;
        this.f1494b = i3;
        this.f1495c = i4;
        this.f1496d = i5;
    }

    @NonNull
    public static b a(@NonNull b bVar, @NonNull b bVar2) {
        return b(Math.max(bVar.f1493a, bVar2.f1493a), Math.max(bVar.f1494b, bVar2.f1494b), Math.max(bVar.f1495c, bVar2.f1495c), Math.max(bVar.f1496d, bVar2.f1496d));
    }

    @NonNull
    public static b b(int i2, int i3, int i4, int i5) {
        return (i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) ? f1492e : new b(i2, i3, i4, i5);
    }

    @NonNull
    public static b c(@NonNull Rect rect) {
        return b(rect.left, rect.top, rect.right, rect.bottom);
    }

    @NonNull
    @RequiresApi(api = 29)
    public static b d(@NonNull Insets insets) {
        return b(insets.left, insets.top, insets.right, insets.bottom);
    }

    @NonNull
    @RequiresApi(29)
    public Insets e() {
        return a.a(this.f1493a, this.f1494b, this.f1495c, this.f1496d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f1496d == bVar.f1496d && this.f1493a == bVar.f1493a && this.f1495c == bVar.f1495c && this.f1494b == bVar.f1494b;
    }

    public int hashCode() {
        return (((((this.f1493a * 31) + this.f1494b) * 31) + this.f1495c) * 31) + this.f1496d;
    }

    @NonNull
    public String toString() {
        return "Insets{left=" + this.f1493a + ", top=" + this.f1494b + ", right=" + this.f1495c + ", bottom=" + this.f1496d + '}';
    }
}
