package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* compiled from: Table.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    protected int f1939a;

    /* renamed from: b, reason: collision with root package name */
    protected ByteBuffer f1940b;

    /* renamed from: c, reason: collision with root package name */
    private int f1941c;

    /* renamed from: d, reason: collision with root package name */
    private int f1942d;

    /* renamed from: e, reason: collision with root package name */
    Utf8 f1943e = Utf8.a();

    protected int a(int i2) {
        return i2 + this.f1940b.getInt(i2);
    }

    protected int b(int i2) {
        if (i2 < this.f1942d) {
            return this.f1940b.getShort(this.f1941c + i2);
        }
        return 0;
    }

    protected void c(int i2, ByteBuffer byteBuffer) {
        this.f1940b = byteBuffer;
        if (byteBuffer == null) {
            this.f1939a = 0;
            this.f1941c = 0;
            this.f1942d = 0;
        } else {
            this.f1939a = i2;
            int i3 = i2 - byteBuffer.getInt(i2);
            this.f1941c = i3;
            this.f1942d = this.f1940b.getShort(i3);
        }
    }

    protected int d(int i2) {
        int i3 = i2 + this.f1939a;
        return i3 + this.f1940b.getInt(i3) + 4;
    }

    protected int e(int i2) {
        int i3 = i2 + this.f1939a;
        return this.f1940b.getInt(i3 + this.f1940b.getInt(i3));
    }
}
