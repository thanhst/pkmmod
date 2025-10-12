package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.os.Handler;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.core.provider.FontsContractCompat;
import androidx.emoji2.text.EmojiCompat;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: FontRequestEmojiCompatConfig.java */
/* loaded from: classes.dex */
public class h extends EmojiCompat.c {

    /* renamed from: j, reason: collision with root package name */
    private static final a f1949j = new a();

    /* compiled from: FontRequestEmojiCompatConfig.java */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class a {
        @Nullable
        public Typeface a(@NonNull Context context, @NonNull FontsContractCompat.b bVar) throws PackageManager.NameNotFoundException {
            return FontsContractCompat.a(context, null, new FontsContractCompat.b[]{bVar});
        }

        @NonNull
        public FontsContractCompat.a b(@NonNull Context context, @NonNull androidx.core.provider.e eVar) throws PackageManager.NameNotFoundException {
            return FontsContractCompat.b(context, null, eVar);
        }

        public void c(@NonNull Context context, @NonNull ContentObserver contentObserver) {
            context.getContentResolver().unregisterContentObserver(contentObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FontRequestEmojiCompatConfig.java */
    static class b implements EmojiCompat.g {

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        private final Context f1950a;

        /* renamed from: b, reason: collision with root package name */
        @NonNull
        private final androidx.core.provider.e f1951b;

        /* renamed from: c, reason: collision with root package name */
        @NonNull
        private final a f1952c;

        /* renamed from: d, reason: collision with root package name */
        @NonNull
        private final Object f1953d = new Object();

        /* renamed from: e, reason: collision with root package name */
        @Nullable
        @GuardedBy("mLock")
        private Handler f1954e;

        /* renamed from: f, reason: collision with root package name */
        @Nullable
        @GuardedBy("mLock")
        private Executor f1955f;

        /* renamed from: g, reason: collision with root package name */
        @Nullable
        @GuardedBy("mLock")
        private ThreadPoolExecutor f1956g;

        /* renamed from: h, reason: collision with root package name */
        @Nullable
        @GuardedBy("mLock")
        EmojiCompat.h f1957h;

        /* renamed from: i, reason: collision with root package name */
        @Nullable
        @GuardedBy("mLock")
        private ContentObserver f1958i;

        /* renamed from: j, reason: collision with root package name */
        @Nullable
        @GuardedBy("mLock")
        private Runnable f1959j;

        b(@NonNull Context context, @NonNull androidx.core.provider.e eVar, @NonNull a aVar) {
            androidx.core.util.h.g(context, "Context cannot be null");
            androidx.core.util.h.g(eVar, "FontRequest cannot be null");
            this.f1950a = context.getApplicationContext();
            this.f1951b = eVar;
            this.f1952c = aVar;
        }

        private void b() {
            synchronized (this.f1953d) {
                this.f1957h = null;
                ContentObserver contentObserver = this.f1958i;
                if (contentObserver != null) {
                    this.f1952c.c(this.f1950a, contentObserver);
                    this.f1958i = null;
                }
                Handler handler = this.f1954e;
                if (handler != null) {
                    handler.removeCallbacks(this.f1959j);
                }
                this.f1954e = null;
                ThreadPoolExecutor threadPoolExecutor = this.f1956g;
                if (threadPoolExecutor != null) {
                    threadPoolExecutor.shutdown();
                }
                this.f1955f = null;
                this.f1956g = null;
            }
        }

        @WorkerThread
        private FontsContractCompat.b e() {
            try {
                FontsContractCompat.a aVarB = this.f1952c.b(this.f1950a, this.f1951b);
                if (aVarB.c() == 0) {
                    FontsContractCompat.b[] bVarArrB = aVarB.b();
                    if (bVarArrB == null || bVarArrB.length == 0) {
                        throw new RuntimeException("fetchFonts failed (empty result)");
                    }
                    return bVarArrB[0];
                }
                throw new RuntimeException("fetchFonts failed (" + aVarB.c() + ")");
            } catch (PackageManager.NameNotFoundException e2) {
                throw new RuntimeException("provider not found", e2);
            }
        }

        @Override // androidx.emoji2.text.EmojiCompat.g
        @RequiresApi(19)
        public void a(@NonNull EmojiCompat.h hVar) {
            androidx.core.util.h.g(hVar, "LoaderCallback cannot be null");
            synchronized (this.f1953d) {
                this.f1957h = hVar;
            }
            d();
        }

        @RequiresApi(19)
        @WorkerThread
        void c() {
            synchronized (this.f1953d) {
                if (this.f1957h == null) {
                    return;
                }
                try {
                    FontsContractCompat.b bVarE = e();
                    int iB = bVarE.b();
                    if (iB == 2) {
                        synchronized (this.f1953d) {
                        }
                    }
                    if (iB != 0) {
                        throw new RuntimeException("fetchFonts result is not OK. (" + iB + ")");
                    }
                    try {
                        androidx.core.os.k.a("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                        Typeface typefaceA = this.f1952c.a(this.f1950a, bVarE);
                        ByteBuffer byteBufferF = androidx.core.graphics.m.f(this.f1950a, null, bVarE.d());
                        if (byteBufferF == null || typefaceA == null) {
                            throw new RuntimeException("Unable to open file.");
                        }
                        k kVarB = k.b(typefaceA, byteBufferF);
                        androidx.core.os.k.b();
                        synchronized (this.f1953d) {
                            EmojiCompat.h hVar = this.f1957h;
                            if (hVar != null) {
                                hVar.b(kVarB);
                            }
                        }
                        b();
                    } catch (Throwable th) {
                        androidx.core.os.k.b();
                        throw th;
                    }
                } catch (Throwable th2) {
                    synchronized (this.f1953d) {
                        EmojiCompat.h hVar2 = this.f1957h;
                        if (hVar2 != null) {
                            hVar2.a(th2);
                        }
                        b();
                    }
                }
            }
        }

        @RequiresApi(19)
        void d() {
            synchronized (this.f1953d) {
                if (this.f1957h == null) {
                    return;
                }
                if (this.f1955f == null) {
                    ThreadPoolExecutor threadPoolExecutorB = androidx.emoji2.text.b.b("emojiCompat");
                    this.f1956g = threadPoolExecutorB;
                    this.f1955f = threadPoolExecutorB;
                }
                this.f1955f.execute(new Runnable() { // from class: androidx.emoji2.text.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f1960e.c();
                    }
                });
            }
        }

        public void f(@NonNull Executor executor) {
            synchronized (this.f1953d) {
                this.f1955f = executor;
            }
        }
    }

    public h(@NonNull Context context, @NonNull androidx.core.provider.e eVar) {
        super(new b(context, eVar, f1949j));
    }

    @NonNull
    public h c(@NonNull Executor executor) {
        ((b) a()).f(executor);
        return this;
    }
}
