package i;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: SafeIterableMap.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: e, reason: collision with root package name */
    c<K, V> f3300e;

    /* renamed from: f, reason: collision with root package name */
    private c<K, V> f3301f;

    /* renamed from: g, reason: collision with root package name */
    private WeakHashMap<f<K, V>, Boolean> f3302g = new WeakHashMap<>();

    /* renamed from: h, reason: collision with root package name */
    private int f3303h = 0;

    /* compiled from: SafeIterableMap.java */
    static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // i.b.e
        c<K, V> b(c<K, V> cVar) {
            return cVar.f3307h;
        }

        @Override // i.b.e
        c<K, V> c(c<K, V> cVar) {
            return cVar.f3306g;
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* renamed from: i.b$b, reason: collision with other inner class name */
    private static class C0052b<K, V> extends e<K, V> {
        C0052b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // i.b.e
        c<K, V> b(c<K, V> cVar) {
            return cVar.f3306g;
        }

        @Override // i.b.e
        c<K, V> c(c<K, V> cVar) {
            return cVar.f3307h;
        }
    }

    /* compiled from: SafeIterableMap.java */
    static class c<K, V> implements Map.Entry<K, V> {

        /* renamed from: e, reason: collision with root package name */
        @NonNull
        final K f3304e;

        /* renamed from: f, reason: collision with root package name */
        @NonNull
        final V f3305f;

        /* renamed from: g, reason: collision with root package name */
        c<K, V> f3306g;

        /* renamed from: h, reason: collision with root package name */
        c<K, V> f3307h;

        c(@NonNull K k2, @NonNull V v2) {
            this.f3304e = k2;
            this.f3305f = v2;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f3304e.equals(cVar.f3304e) && this.f3305f.equals(cVar.f3305f);
        }

        @Override // java.util.Map.Entry
        @NonNull
        public K getKey() {
            return this.f3304e;
        }

        @Override // java.util.Map.Entry
        @NonNull
        public V getValue() {
            return this.f3305f;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f3304e.hashCode() ^ this.f3305f.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v2) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f3304e + "=" + this.f3305f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SafeIterableMap.java */
    public class d implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* renamed from: e, reason: collision with root package name */
        private c<K, V> f3308e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f3309f = true;

        d() {
        }

        @Override // i.b.f
        public void a(@NonNull c<K, V> cVar) {
            c<K, V> cVar2 = this.f3308e;
            if (cVar == cVar2) {
                c<K, V> cVar3 = cVar2.f3307h;
                this.f3308e = cVar3;
                this.f3309f = cVar3 == null;
            }
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            if (this.f3309f) {
                this.f3309f = false;
                this.f3308e = b.this.f3300e;
            } else {
                c<K, V> cVar = this.f3308e;
                this.f3308e = cVar != null ? cVar.f3306g : null;
            }
            return this.f3308e;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f3309f) {
                return b.this.f3300e != null;
            }
            c<K, V> cVar = this.f3308e;
            return (cVar == null || cVar.f3306g == null) ? false : true;
        }
    }

    /* compiled from: SafeIterableMap.java */
    private static abstract class e<K, V> implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* renamed from: e, reason: collision with root package name */
        c<K, V> f3311e;

        /* renamed from: f, reason: collision with root package name */
        c<K, V> f3312f;

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.f3311e = cVar2;
            this.f3312f = cVar;
        }

        private c<K, V> e() {
            c<K, V> cVar = this.f3312f;
            c<K, V> cVar2 = this.f3311e;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return c(cVar);
        }

        @Override // i.b.f
        public void a(@NonNull c<K, V> cVar) {
            if (this.f3311e == cVar && cVar == this.f3312f) {
                this.f3312f = null;
                this.f3311e = null;
            }
            c<K, V> cVar2 = this.f3311e;
            if (cVar2 == cVar) {
                this.f3311e = b(cVar2);
            }
            if (this.f3312f == cVar) {
                this.f3312f = e();
            }
        }

        abstract c<K, V> b(c<K, V> cVar);

        abstract c<K, V> c(c<K, V> cVar);

        @Override // java.util.Iterator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.f3312f;
            this.f3312f = e();
            return cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f3312f != null;
        }
    }

    /* compiled from: SafeIterableMap.java */
    interface f<K, V> {
        void a(@NonNull c<K, V> cVar);
    }

    public Map.Entry<K, V> a() {
        return this.f3300e;
    }

    protected c<K, V> b(K k2) {
        c<K, V> cVar = this.f3300e;
        while (cVar != null && !cVar.f3304e.equals(k2)) {
            cVar = cVar.f3306g;
        }
        return cVar;
    }

    public b<K, V>.d c() {
        b<K, V>.d dVar = new d();
        this.f3302g.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public Map.Entry<K, V> d() {
        return this.f3301f;
    }

    public Iterator<Map.Entry<K, V>> descendingIterator() {
        C0052b c0052b = new C0052b(this.f3301f, this.f3300e);
        this.f3302g.put(c0052b, Boolean.FALSE);
        return c0052b;
    }

    protected c<K, V> e(@NonNull K k2, @NonNull V v2) {
        c<K, V> cVar = new c<>(k2, v2);
        this.f3303h++;
        c<K, V> cVar2 = this.f3301f;
        if (cVar2 == null) {
            this.f3300e = cVar;
            this.f3301f = cVar;
            return cVar;
        }
        cVar2.f3306g = cVar;
        cVar.f3307h = cVar2;
        this.f3301f = cVar;
        return cVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (size() != bVar.size()) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = iterator();
        Iterator<Map.Entry<K, V>> it2 = bVar.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry<K, V> next = it.next();
            Map.Entry<K, V> next2 = it2.next();
            if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    public V f(@NonNull K k2, @NonNull V v2) {
        c<K, V> cVarB = b(k2);
        if (cVarB != null) {
            return cVarB.f3305f;
        }
        e(k2, v2);
        return null;
    }

    public V g(@NonNull K k2) {
        c<K, V> cVarB = b(k2);
        if (cVarB == null) {
            return null;
        }
        this.f3303h--;
        if (!this.f3302g.isEmpty()) {
            Iterator<f<K, V>> it = this.f3302g.keySet().iterator();
            while (it.hasNext()) {
                it.next().a(cVarB);
            }
        }
        c<K, V> cVar = cVarB.f3307h;
        if (cVar != null) {
            cVar.f3306g = cVarB.f3306g;
        } else {
            this.f3300e = cVarB.f3306g;
        }
        c<K, V> cVar2 = cVarB.f3306g;
        if (cVar2 != null) {
            cVar2.f3307h = cVar;
        } else {
            this.f3301f = cVar;
        }
        cVarB.f3306g = null;
        cVarB.f3307h = null;
        return cVarB.f3305f;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            iHashCode += it.next().hashCode();
        }
        return iHashCode;
    }

    @Override // java.lang.Iterable
    @NonNull
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.f3300e, this.f3301f);
        this.f3302g.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public int size() {
        return this.f3303h;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
