package androidx.emoji2.text;

import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: MetadataListReader.java */
@AnyThread
@RequiresApi(19)
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
class j {

    /* compiled from: MetadataListReader.java */
    private static class a implements c {

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        private final ByteBuffer f1961a;

        a(@NonNull ByteBuffer byteBuffer) {
            this.f1961a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // androidx.emoji2.text.j.c
        public void a(int i2) throws IOException {
            ByteBuffer byteBuffer = this.f1961a;
            byteBuffer.position(byteBuffer.position() + i2);
        }

        @Override // androidx.emoji2.text.j.c
        public long b() throws IOException {
            return j.c(this.f1961a.getInt());
        }

        @Override // androidx.emoji2.text.j.c
        public int c() throws IOException {
            return this.f1961a.getInt();
        }

        @Override // androidx.emoji2.text.j.c
        public long getPosition() {
            return this.f1961a.position();
        }

        @Override // androidx.emoji2.text.j.c
        public int readUnsignedShort() throws IOException {
            return j.d(this.f1961a.getShort());
        }
    }

    /* compiled from: MetadataListReader.java */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private final long f1962a;

        /* renamed from: b, reason: collision with root package name */
        private final long f1963b;

        b(long j2, long j3) {
            this.f1962a = j2;
            this.f1963b = j3;
        }

        long a() {
            return this.f1962a;
        }
    }

    /* compiled from: MetadataListReader.java */
    private interface c {
        void a(int i2) throws IOException;

        long b() throws IOException;

        int c() throws IOException;

        long getPosition();

        int readUnsignedShort() throws IOException;
    }

    private static b a(c cVar) throws IOException {
        long jB;
        cVar.a(4);
        int unsignedShort = cVar.readUnsignedShort();
        if (unsignedShort > 100) {
            throw new IOException("Cannot read metadata.");
        }
        cVar.a(6);
        int i2 = 0;
        while (true) {
            if (i2 >= unsignedShort) {
                jB = -1;
                break;
            }
            int iC = cVar.c();
            cVar.a(4);
            jB = cVar.b();
            cVar.a(4);
            if (1835365473 == iC) {
                break;
            }
            i2++;
        }
        if (jB != -1) {
            cVar.a((int) (jB - cVar.getPosition()));
            cVar.a(12);
            long jB2 = cVar.b();
            for (int i3 = 0; i3 < jB2; i3++) {
                int iC2 = cVar.c();
                long jB3 = cVar.b();
                long jB4 = cVar.b();
                if (1164798569 == iC2 || 1701669481 == iC2) {
                    return new b(jB3 + jB, jB4);
                }
            }
        }
        throw new IOException("Cannot read metadata.");
    }

    static androidx.emoji2.text.flatbuffer.b b(ByteBuffer byteBuffer) throws IOException {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.position((int) a(new a(byteBufferDuplicate)).a());
        return androidx.emoji2.text.flatbuffer.b.h(byteBufferDuplicate);
    }

    static long c(int i2) {
        return i2 & 4294967295L;
    }

    static int d(short s2) {
        return s2 & 65535;
    }
}
