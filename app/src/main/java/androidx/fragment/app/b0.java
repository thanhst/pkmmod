package androidx.fragment.app;

import android.util.Log;
import java.io.Writer;

/* compiled from: LogWriter.java */
/* loaded from: classes.dex */
final class b0 extends Writer {

    /* renamed from: e, reason: collision with root package name */
    private final String f2219e;

    /* renamed from: f, reason: collision with root package name */
    private StringBuilder f2220f = new StringBuilder(128);

    b0(String str) {
        this.f2219e = str;
    }

    private void a() {
        if (this.f2220f.length() > 0) {
            Log.d(this.f2219e, this.f2220f.toString());
            StringBuilder sb = this.f2220f;
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        a();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            char c2 = cArr[i2 + i4];
            if (c2 == '\n') {
                a();
            } else {
                this.f2220f.append(c2);
            }
        }
    }
}
