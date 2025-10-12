package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.LinkedHashMap;
import java.util.Locale;

/* compiled from: LruCache.java */
/* loaded from: classes.dex */
public class e<K, V> {

    /* renamed from: a, reason: collision with root package name */
    private final LinkedHashMap<K, V> f1325a;

    /* renamed from: b, reason: collision with root package name */
    private int f1326b;

    /* renamed from: c, reason: collision with root package name */
    private int f1327c;

    /* renamed from: d, reason: collision with root package name */
    private int f1328d;

    /* renamed from: e, reason: collision with root package name */
    private int f1329e;

    /* renamed from: f, reason: collision with root package name */
    private int f1330f;

    /* renamed from: g, reason: collision with root package name */
    private int f1331g;

    /* renamed from: h, reason: collision with root package name */
    private int f1332h;

    public e(int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f1327c = i2;
        this.f1325a = new LinkedHashMap<>(0, 0.75f, true);
    }

    private int e(K k2, V v2) {
        int iF = f(k2, v2);
        if (iF >= 0) {
            return iF;
        }
        throw new IllegalStateException("Negative size: " + k2 + "=" + v2);
    }

    @Nullable
    protected V a(@NonNull K k2) {
        return null;
    }

    protected void b(boolean z2, @NonNull K k2, @NonNull V v2, @Nullable V v3) {
    }

    @Nullable
    public final V c(@NonNull K k2) {
        V v2;
        if (k2 == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            V v3 = this.f1325a.get(k2);
            if (v3 != null) {
                this.f1331g++;
                return v3;
            }
            this.f1332h++;
            V vA = a(k2);
            if (vA == null) {
                return null;
            }
            synchronized (this) {
                this.f1329e++;
                v2 = (V) this.f1325a.put(k2, vA);
                if (v2 != null) {
                    this.f1325a.put(k2, v2);
                } else {
                    this.f1326b += e(k2, vA);
                }
            }
            if (v2 != null) {
                b(false, k2, vA, v2);
                return v2;
            }
            g(this.f1327c);
            return vA;
        }
    }

    @Nullable
    public final V d(@NonNull K k2, @NonNull V v2) {
        V vPut;
        if (k2 == null || v2 == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.f1328d++;
            this.f1326b += e(k2, v2);
            vPut = this.f1325a.put(k2, v2);
            if (vPut != null) {
                this.f1326b -= e(k2, vPut);
            }
        }
        if (vPut != null) {
            b(false, k2, vPut, v2);
        }
        g(this.f1327c);
        return vPut;
    }

    protected int f(@NonNull K k2, @NonNull V v2) {
        return 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0070, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void g(int r5) {
        /*
            r4 = this;
        L0:
            monitor-enter(r4)
            int r0 = r4.f1326b     // Catch: java.lang.Throwable -> L71
            if (r0 < 0) goto L52
            java.util.LinkedHashMap<K, V> r0 = r4.f1325a     // Catch: java.lang.Throwable -> L71
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L71
            if (r0 == 0) goto L11
            int r0 = r4.f1326b     // Catch: java.lang.Throwable -> L71
            if (r0 != 0) goto L52
        L11:
            int r0 = r4.f1326b     // Catch: java.lang.Throwable -> L71
            if (r0 <= r5) goto L50
            java.util.LinkedHashMap<K, V> r0 = r4.f1325a     // Catch: java.lang.Throwable -> L71
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L71
            if (r0 == 0) goto L1e
            goto L50
        L1e:
            java.util.LinkedHashMap<K, V> r0 = r4.f1325a     // Catch: java.lang.Throwable -> L71
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L71
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L71
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L71
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L71
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L71
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L71
            java.util.LinkedHashMap<K, V> r2 = r4.f1325a     // Catch: java.lang.Throwable -> L71
            r2.remove(r1)     // Catch: java.lang.Throwable -> L71
            int r2 = r4.f1326b     // Catch: java.lang.Throwable -> L71
            int r3 = r4.e(r1, r0)     // Catch: java.lang.Throwable -> L71
            int r2 = r2 - r3
            r4.f1326b = r2     // Catch: java.lang.Throwable -> L71
            int r2 = r4.f1330f     // Catch: java.lang.Throwable -> L71
            r3 = 1
            int r2 = r2 + r3
            r4.f1330f = r2     // Catch: java.lang.Throwable -> L71
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L71
            r2 = 0
            r4.b(r3, r1, r0, r2)
            goto L0
        L50:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L71
            return
        L52:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L71
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L71
            r0.<init>()     // Catch: java.lang.Throwable -> L71
            java.lang.Class r1 = r4.getClass()     // Catch: java.lang.Throwable -> L71
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L71
            r0.append(r1)     // Catch: java.lang.Throwable -> L71
            java.lang.String r1 = ".sizeOf() is reporting inconsistent results!"
            r0.append(r1)     // Catch: java.lang.Throwable -> L71
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L71
            r5.<init>(r0)     // Catch: java.lang.Throwable -> L71
            throw r5     // Catch: java.lang.Throwable -> L71
        L71:
            r5 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L71
            goto L75
        L74:
            throw r5
        L75:
            goto L74
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.e.g(int):void");
    }

    public final synchronized String toString() {
        int i2;
        int i3;
        i2 = this.f1331g;
        i3 = this.f1332h + i2;
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f1327c), Integer.valueOf(this.f1331g), Integer.valueOf(this.f1332h), Integer.valueOf(i3 != 0 ? (i2 * 100) / i3 : 0));
    }
}
