package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: MetadataList.java */
/* loaded from: classes.dex */
public final class b extends c {
    public static b h(ByteBuffer byteBuffer) {
        return i(byteBuffer, new b());
    }

    public static b i(ByteBuffer byteBuffer, b bVar) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return bVar.f(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public b f(int i2, ByteBuffer byteBuffer) {
        g(i2, byteBuffer);
        return this;
    }

    public void g(int i2, ByteBuffer byteBuffer) {
        c(i2, byteBuffer);
    }

    public a j(a aVar, int i2) {
        int iB = b(6);
        if (iB != 0) {
            return aVar.f(a(d(iB) + (i2 * 4)), this.f1940b);
        }
        return null;
    }

    public int k() {
        int iB = b(6);
        if (iB != 0) {
            return e(iB);
        }
        return 0;
    }

    public int l() {
        int iB = b(4);
        if (iB != 0) {
            return this.f1940b.getInt(iB + this.f1939a);
        }
        return 0;
    }
}
