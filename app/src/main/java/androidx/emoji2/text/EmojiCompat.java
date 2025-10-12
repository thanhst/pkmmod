package androidx.emoji2.text;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.annotation.AnyThread;
import androidx.annotation.CheckResult;
import androidx.annotation.ColorInt;
import androidx.annotation.GuardedBy;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@AnyThread
/* loaded from: classes.dex */
public class EmojiCompat {

    /* renamed from: n, reason: collision with root package name */
    private static final Object f1876n = new Object();

    /* renamed from: o, reason: collision with root package name */
    private static final Object f1877o = new Object();

    /* renamed from: p, reason: collision with root package name */
    @Nullable
    @GuardedBy("INSTANCE_LOCK")
    private static volatile EmojiCompat f1878p;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    @GuardedBy("mInitLock")
    private final Set<e> f1880b;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    private final b f1883e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    final g f1884f;

    /* renamed from: g, reason: collision with root package name */
    final boolean f1885g;

    /* renamed from: h, reason: collision with root package name */
    final boolean f1886h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    final int[] f1887i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f1888j;

    /* renamed from: k, reason: collision with root package name */
    private final int f1889k;

    /* renamed from: l, reason: collision with root package name */
    private final int f1890l;

    /* renamed from: m, reason: collision with root package name */
    private final d f1891m;

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ReadWriteLock f1879a = new ReentrantReadWriteLock();

    /* renamed from: c, reason: collision with root package name */
    @GuardedBy("mInitLock")
    private volatile int f1881c = 3;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private final Handler f1882d = new Handler(Looper.getMainLooper());

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface CodepointSequenceMatchResult {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface LoadStrategy {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface ReplaceStrategy {
    }

    @RequiresApi(19)
    private static final class a extends b {

        /* renamed from: b, reason: collision with root package name */
        private volatile androidx.emoji2.text.f f1892b;

        /* renamed from: c, reason: collision with root package name */
        private volatile k f1893c;

        /* renamed from: androidx.emoji2.text.EmojiCompat$a$a, reason: collision with other inner class name */
        class C0026a extends h {
            C0026a() {
            }

            @Override // androidx.emoji2.text.EmojiCompat.h
            public void a(@Nullable Throwable th) {
                a.this.f1895a.m(th);
            }

            @Override // androidx.emoji2.text.EmojiCompat.h
            public void b(@NonNull k kVar) {
                a.this.d(kVar);
            }
        }

        a(EmojiCompat emojiCompat) {
            super(emojiCompat);
        }

        @Override // androidx.emoji2.text.EmojiCompat.b
        void a() {
            try {
                this.f1895a.f1884f.a(new C0026a());
            } catch (Throwable th) {
                this.f1895a.m(th);
            }
        }

        @Override // androidx.emoji2.text.EmojiCompat.b
        CharSequence b(@NonNull CharSequence charSequence, int i2, int i3, int i4, boolean z2) {
            return this.f1892b.h(charSequence, i2, i3, i4, z2);
        }

        @Override // androidx.emoji2.text.EmojiCompat.b
        void c(@NonNull EditorInfo editorInfo) {
            editorInfo.extras.putInt("android.support.text.emoji.emojiCompat_metadataVersion", this.f1893c.e());
            editorInfo.extras.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", this.f1895a.f1885g);
        }

        void d(@NonNull k kVar) {
            if (kVar == null) {
                this.f1895a.m(new IllegalArgumentException("metadataRepo cannot be null"));
                return;
            }
            this.f1893c = kVar;
            k kVar2 = this.f1893c;
            i iVar = new i();
            d dVar = this.f1895a.f1891m;
            EmojiCompat emojiCompat = this.f1895a;
            this.f1892b = new androidx.emoji2.text.f(kVar2, iVar, dVar, emojiCompat.f1886h, emojiCompat.f1887i);
            this.f1895a.n();
        }
    }

    private static class b {

        /* renamed from: a, reason: collision with root package name */
        final EmojiCompat f1895a;

        b(EmojiCompat emojiCompat) {
            this.f1895a = emojiCompat;
        }

        void a() {
            throw null;
        }

        CharSequence b(@NonNull CharSequence charSequence, @IntRange(from = 0) int i2, @IntRange(from = 0) int i3, @IntRange(from = 0) int i4, boolean z2) {
            throw null;
        }

        void c(@NonNull EditorInfo editorInfo) {
            throw null;
        }
    }

    public static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        final g f1896a;

        /* renamed from: b, reason: collision with root package name */
        boolean f1897b;

        /* renamed from: c, reason: collision with root package name */
        boolean f1898c;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        int[] f1899d;

        /* renamed from: e, reason: collision with root package name */
        @Nullable
        Set<e> f1900e;

        /* renamed from: f, reason: collision with root package name */
        boolean f1901f;

        /* renamed from: g, reason: collision with root package name */
        int f1902g = -16711936;

        /* renamed from: h, reason: collision with root package name */
        int f1903h = 0;

        /* renamed from: i, reason: collision with root package name */
        @NonNull
        d f1904i = new androidx.emoji2.text.d();

        protected c(@NonNull g gVar) {
            androidx.core.util.h.g(gVar, "metadataLoader cannot be null.");
            this.f1896a = gVar;
        }

        @NonNull
        protected final g a() {
            return this.f1896a;
        }

        @NonNull
        public c b(int i2) {
            this.f1903h = i2;
            return this;
        }
    }

    public interface d {
        boolean a(@NonNull CharSequence charSequence, @IntRange(from = 0) int i2, @IntRange(from = 0) int i3, @IntRange(from = 0) int i4);
    }

    public static abstract class e {
        public void a(@Nullable Throwable th) {
        }

        public void b() {
        }
    }

    private static class f implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        private final List<e> f1905e;

        /* renamed from: f, reason: collision with root package name */
        private final Throwable f1906f;

        /* renamed from: g, reason: collision with root package name */
        private final int f1907g;

        f(@NonNull e eVar, int i2) {
            this(Arrays.asList((e) androidx.core.util.h.g(eVar, "initCallback cannot be null")), i2, null);
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.f1905e.size();
            int i2 = 0;
            if (this.f1907g != 1) {
                while (i2 < size) {
                    this.f1905e.get(i2).a(this.f1906f);
                    i2++;
                }
            } else {
                while (i2 < size) {
                    this.f1905e.get(i2).b();
                    i2++;
                }
            }
        }

        f(@NonNull Collection<e> collection, int i2) {
            this(collection, i2, null);
        }

        f(@NonNull Collection<e> collection, int i2, @Nullable Throwable th) {
            androidx.core.util.h.g(collection, "initCallbacks cannot be null");
            this.f1905e = new ArrayList(collection);
            this.f1907g = i2;
            this.f1906f = th;
        }
    }

    public interface g {
        void a(@NonNull h hVar);
    }

    public static abstract class h {
        public abstract void a(@Nullable Throwable th);

        public abstract void b(@NonNull k kVar);
    }

    @RequiresApi(19)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    static class i {
        i() {
        }

        androidx.emoji2.text.g a(@NonNull EmojiMetadata emojiMetadata) {
            return new m(emojiMetadata);
        }
    }

    private EmojiCompat(@NonNull c cVar) {
        this.f1885g = cVar.f1897b;
        this.f1886h = cVar.f1898c;
        this.f1887i = cVar.f1899d;
        this.f1888j = cVar.f1901f;
        this.f1889k = cVar.f1902g;
        this.f1884f = cVar.f1896a;
        this.f1890l = cVar.f1903h;
        this.f1891m = cVar.f1904i;
        androidx.collection.b bVar = new androidx.collection.b();
        this.f1880b = bVar;
        Set<e> set = cVar.f1900e;
        if (set != null && !set.isEmpty()) {
            bVar.addAll(cVar.f1900e);
        }
        this.f1883e = new a(this);
        l();
    }

    @NonNull
    public static EmojiCompat b() {
        EmojiCompat emojiCompat;
        synchronized (f1876n) {
            emojiCompat = f1878p;
            androidx.core.util.h.h(emojiCompat != null, "EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
        }
        return emojiCompat;
    }

    public static boolean e(@NonNull InputConnection inputConnection, @NonNull Editable editable, @IntRange(from = 0) int i2, @IntRange(from = 0) int i3, boolean z2) {
        return androidx.emoji2.text.f.c(inputConnection, editable, i2, i3, z2);
    }

    public static boolean f(@NonNull Editable editable, int i2, @NonNull KeyEvent keyEvent) {
        return androidx.emoji2.text.f.d(editable, i2, keyEvent);
    }

    @NonNull
    public static EmojiCompat g(@NonNull c cVar) {
        EmojiCompat emojiCompat = f1878p;
        if (emojiCompat == null) {
            synchronized (f1876n) {
                emojiCompat = f1878p;
                if (emojiCompat == null) {
                    emojiCompat = new EmojiCompat(cVar);
                    f1878p = emojiCompat;
                }
            }
        }
        return emojiCompat;
    }

    public static boolean h() {
        return f1878p != null;
    }

    private boolean j() {
        return d() == 1;
    }

    private void l() {
        this.f1879a.writeLock().lock();
        try {
            if (this.f1890l == 0) {
                this.f1881c = 0;
            }
            this.f1879a.writeLock().unlock();
            if (d() == 0) {
                this.f1883e.a();
            }
        } catch (Throwable th) {
            this.f1879a.writeLock().unlock();
            throw th;
        }
    }

    @ColorInt
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int c() {
        return this.f1889k;
    }

    public int d() {
        this.f1879a.readLock().lock();
        try {
            return this.f1881c;
        } finally {
            this.f1879a.readLock().unlock();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean i() {
        return this.f1888j;
    }

    public void k() {
        androidx.core.util.h.h(this.f1890l == 1, "Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        if (j()) {
            return;
        }
        this.f1879a.writeLock().lock();
        try {
            if (this.f1881c == 0) {
                return;
            }
            this.f1881c = 0;
            this.f1879a.writeLock().unlock();
            this.f1883e.a();
        } finally {
            this.f1879a.writeLock().unlock();
        }
    }

    void m(@Nullable Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.f1879a.writeLock().lock();
        try {
            this.f1881c = 2;
            arrayList.addAll(this.f1880b);
            this.f1880b.clear();
            this.f1879a.writeLock().unlock();
            this.f1882d.post(new f(arrayList, this.f1881c, th));
        } catch (Throwable th2) {
            this.f1879a.writeLock().unlock();
            throw th2;
        }
    }

    void n() {
        ArrayList arrayList = new ArrayList();
        this.f1879a.writeLock().lock();
        try {
            this.f1881c = 1;
            arrayList.addAll(this.f1880b);
            this.f1880b.clear();
            this.f1879a.writeLock().unlock();
            this.f1882d.post(new f(arrayList, this.f1881c));
        } catch (Throwable th) {
            this.f1879a.writeLock().unlock();
            throw th;
        }
    }

    @Nullable
    @CheckResult
    public CharSequence o(@Nullable CharSequence charSequence) {
        return p(charSequence, 0, charSequence == null ? 0 : charSequence.length());
    }

    @Nullable
    @CheckResult
    public CharSequence p(@Nullable CharSequence charSequence, @IntRange(from = 0) int i2, @IntRange(from = 0) int i3) {
        return q(charSequence, i2, i3, Integer.MAX_VALUE);
    }

    @Nullable
    @CheckResult
    public CharSequence q(@Nullable CharSequence charSequence, @IntRange(from = 0) int i2, @IntRange(from = 0) int i3, @IntRange(from = 0) int i4) {
        return r(charSequence, i2, i3, i4, 0);
    }

    @Nullable
    @CheckResult
    public CharSequence r(@Nullable CharSequence charSequence, @IntRange(from = 0) int i2, @IntRange(from = 0) int i3, @IntRange(from = 0) int i4, int i5) {
        androidx.core.util.h.h(j(), "Not initialized yet");
        androidx.core.util.h.d(i2, "start cannot be negative");
        androidx.core.util.h.d(i3, "end cannot be negative");
        androidx.core.util.h.d(i4, "maxEmojiCount cannot be negative");
        androidx.core.util.h.a(i2 <= i3, "start should be <= than end");
        if (charSequence == null) {
            return null;
        }
        androidx.core.util.h.a(i2 <= charSequence.length(), "start should be < than charSequence length");
        androidx.core.util.h.a(i3 <= charSequence.length(), "end should be < than charSequence length");
        if (charSequence.length() == 0 || i2 == i3) {
            return charSequence;
        }
        return this.f1883e.b(charSequence, i2, i3, i4, i5 != 1 ? i5 != 2 ? this.f1885g : false : true);
    }

    public void s(@NonNull e eVar) {
        androidx.core.util.h.g(eVar, "initCallback cannot be null");
        this.f1879a.writeLock().lock();
        try {
            if (this.f1881c == 1 || this.f1881c == 2) {
                this.f1882d.post(new f(eVar, this.f1881c));
            } else {
                this.f1880b.add(eVar);
            }
        } finally {
            this.f1879a.writeLock().unlock();
        }
    }

    public void t(@NonNull e eVar) {
        androidx.core.util.h.g(eVar, "initCallback cannot be null");
        this.f1879a.writeLock().lock();
        try {
            this.f1880b.remove(eVar);
        } finally {
            this.f1879a.writeLock().unlock();
        }
    }

    public void u(@NonNull EditorInfo editorInfo) {
        if (!j() || editorInfo == null) {
            return;
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        this.f1883e.c(editorInfo);
    }
}
