package androidx.core.os;

import android.os.CancellationSignal;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* compiled from: CancellationSignal.java */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private boolean f1553a;

    /* renamed from: b, reason: collision with root package name */
    private b f1554b;

    /* renamed from: c, reason: collision with root package name */
    private Object f1555c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f1556d;

    /* compiled from: CancellationSignal.java */
    @RequiresApi(16)
    static class a {
        @DoNotInline
        static void a(Object obj) {
            ((CancellationSignal) obj).cancel();
        }

        @DoNotInline
        static CancellationSignal b() {
            return new CancellationSignal();
        }
    }

    /* compiled from: CancellationSignal.java */
    public interface b {
        void onCancel();
    }

    private void d() throws InterruptedException {
        while (this.f1556d) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    public void a() {
        synchronized (this) {
            if (this.f1553a) {
                return;
            }
            this.f1553a = true;
            this.f1556d = true;
            b bVar = this.f1554b;
            Object obj = this.f1555c;
            if (bVar != null) {
                try {
                    bVar.onCancel();
                } catch (Throwable th) {
                    synchronized (this) {
                        this.f1556d = false;
                        notifyAll();
                        throw th;
                    }
                }
            }
            if (obj != null) {
                a.a(obj);
            }
            synchronized (this) {
                this.f1556d = false;
                notifyAll();
            }
        }
    }

    public boolean b() {
        boolean z2;
        synchronized (this) {
            z2 = this.f1553a;
        }
        return z2;
    }

    public void c(@Nullable b bVar) {
        synchronized (this) {
            d();
            if (this.f1554b == bVar) {
                return;
            }
            this.f1554b = bVar;
            if (this.f1553a && bVar != null) {
                bVar.onCancel();
            }
        }
    }
}
