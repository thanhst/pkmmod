package androidx.core.provider;

import android.graphics.Typeface;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.core.provider.FontsContractCompat;
import androidx.core.provider.f;

/* compiled from: CallbackWithHandler.java */
/* loaded from: classes.dex */
class a {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FontsContractCompat.FontRequestCallback f1579a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private final Handler f1580b;

    /* compiled from: CallbackWithHandler.java */
    /* renamed from: androidx.core.provider.a$a, reason: collision with other inner class name */
    class RunnableC0017a implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ FontsContractCompat.FontRequestCallback f1581e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Typeface f1582f;

        RunnableC0017a(FontsContractCompat.FontRequestCallback fontRequestCallback, Typeface typeface) {
            this.f1581e = fontRequestCallback;
            this.f1582f = typeface;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1581e.b(this.f1582f);
        }
    }

    /* compiled from: CallbackWithHandler.java */
    class b implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ FontsContractCompat.FontRequestCallback f1584e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f1585f;

        b(FontsContractCompat.FontRequestCallback fontRequestCallback, int i2) {
            this.f1584e = fontRequestCallback;
            this.f1585f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1584e.a(this.f1585f);
        }
    }

    a(@NonNull FontsContractCompat.FontRequestCallback fontRequestCallback, @NonNull Handler handler) {
        this.f1579a = fontRequestCallback;
        this.f1580b = handler;
    }

    private void a(int i2) {
        this.f1580b.post(new b(this.f1579a, i2));
    }

    private void c(@NonNull Typeface typeface) {
        this.f1580b.post(new RunnableC0017a(this.f1579a, typeface));
    }

    void b(@NonNull f.e eVar) {
        if (eVar.a()) {
            c(eVar.f1608a);
        } else {
            a(eVar.f1609b);
        }
    }
}
