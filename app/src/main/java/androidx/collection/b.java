package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: ArraySet.java */
/* loaded from: classes.dex */
public final class b<E> implements Collection<E>, Set<E> {

    /* renamed from: i, reason: collision with root package name */
    private static final int[] f1306i = new int[0];

    /* renamed from: j, reason: collision with root package name */
    private static final Object[] f1307j = new Object[0];

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    private static Object[] f1308k;

    /* renamed from: l, reason: collision with root package name */
    private static int f1309l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    private static Object[] f1310m;

    /* renamed from: n, reason: collision with root package name */
    private static int f1311n;

    /* renamed from: e, reason: collision with root package name */
    private int[] f1312e;

    /* renamed from: f, reason: collision with root package name */
    Object[] f1313f;

    /* renamed from: g, reason: collision with root package name */
    int f1314g;

    /* renamed from: h, reason: collision with root package name */
    private f<E, E> f1315h;

    /* compiled from: ArraySet.java */
    class a extends f<E, E> {
        a() {
        }

        @Override // androidx.collection.f
        protected void a() {
            b.this.clear();
        }

        @Override // androidx.collection.f
        protected Object b(int i2, int i3) {
            return b.this.f1313f[i2];
        }

        @Override // androidx.collection.f
        protected Map<E, E> c() {
            throw new UnsupportedOperationException("not a map");
        }

        @Override // androidx.collection.f
        protected int d() {
            return b.this.f1314g;
        }

        @Override // androidx.collection.f
        protected int e(Object obj) {
            return b.this.indexOf(obj);
        }

        @Override // androidx.collection.f
        protected int f(Object obj) {
            return b.this.indexOf(obj);
        }

        @Override // androidx.collection.f
        protected void g(E e2, E e3) {
            b.this.add(e2);
        }

        @Override // androidx.collection.f
        protected void h(int i2) {
            b.this.g(i2);
        }

        @Override // androidx.collection.f
        protected E i(int i2, E e2) {
            throw new UnsupportedOperationException("not a map");
        }
    }

    public b() {
        this(0);
    }

    private void a(int i2) {
        if (i2 == 8) {
            synchronized (b.class) {
                Object[] objArr = f1310m;
                if (objArr != null) {
                    this.f1313f = objArr;
                    f1310m = (Object[]) objArr[0];
                    this.f1312e = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f1311n--;
                    return;
                }
            }
        } else if (i2 == 4) {
            synchronized (b.class) {
                Object[] objArr2 = f1308k;
                if (objArr2 != null) {
                    this.f1313f = objArr2;
                    f1308k = (Object[]) objArr2[0];
                    this.f1312e = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f1309l--;
                    return;
                }
            }
        }
        this.f1312e = new int[i2];
        this.f1313f = new Object[i2];
    }

    private static void c(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (b.class) {
                if (f1311n < 10) {
                    objArr[0] = f1310m;
                    objArr[1] = iArr;
                    for (int i3 = i2 - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f1310m = objArr;
                    f1311n++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (b.class) {
                if (f1309l < 10) {
                    objArr[0] = f1308k;
                    objArr[1] = iArr;
                    for (int i4 = i2 - 1; i4 >= 2; i4--) {
                        objArr[i4] = null;
                    }
                    f1308k = objArr;
                    f1309l++;
                }
            }
        }
    }

    private f<E, E> d() {
        if (this.f1315h == null) {
            this.f1315h = new a();
        }
        return this.f1315h;
    }

    private int e(Object obj, int i2) {
        int i3 = this.f1314g;
        if (i3 == 0) {
            return -1;
        }
        int iA = c.a(this.f1312e, i3, i2);
        if (iA < 0 || obj.equals(this.f1313f[iA])) {
            return iA;
        }
        int i4 = iA + 1;
        while (i4 < i3 && this.f1312e[i4] == i2) {
            if (obj.equals(this.f1313f[i4])) {
                return i4;
            }
            i4++;
        }
        for (int i5 = iA - 1; i5 >= 0 && this.f1312e[i5] == i2; i5--) {
            if (obj.equals(this.f1313f[i5])) {
                return i5;
            }
        }
        return i4 ^ (-1);
    }

    private int f() {
        int i2 = this.f1314g;
        if (i2 == 0) {
            return -1;
        }
        int iA = c.a(this.f1312e, i2, 0);
        if (iA < 0 || this.f1313f[iA] == null) {
            return iA;
        }
        int i3 = iA + 1;
        while (i3 < i2 && this.f1312e[i3] == 0) {
            if (this.f1313f[i3] == null) {
                return i3;
            }
            i3++;
        }
        for (int i4 = iA - 1; i4 >= 0 && this.f1312e[i4] == 0; i4--) {
            if (this.f1313f[i4] == null) {
                return i4;
            }
        }
        return i3 ^ (-1);
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(@Nullable E e2) {
        int i2;
        int iE;
        if (e2 == null) {
            iE = f();
            i2 = 0;
        } else {
            int iHashCode = e2.hashCode();
            i2 = iHashCode;
            iE = e(e2, iHashCode);
        }
        if (iE >= 0) {
            return false;
        }
        int i3 = iE ^ (-1);
        int i4 = this.f1314g;
        int[] iArr = this.f1312e;
        if (i4 >= iArr.length) {
            int i5 = 4;
            if (i4 >= 8) {
                i5 = (i4 >> 1) + i4;
            } else if (i4 >= 4) {
                i5 = 8;
            }
            Object[] objArr = this.f1313f;
            a(i5);
            int[] iArr2 = this.f1312e;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f1313f, 0, objArr.length);
            }
            c(iArr, objArr, this.f1314g);
        }
        int i6 = this.f1314g;
        if (i3 < i6) {
            int[] iArr3 = this.f1312e;
            int i7 = i3 + 1;
            System.arraycopy(iArr3, i3, iArr3, i7, i6 - i3);
            Object[] objArr2 = this.f1313f;
            System.arraycopy(objArr2, i3, objArr2, i7, this.f1314g - i3);
        }
        this.f1312e[i3] = i2;
        this.f1313f[i3] = e2;
        this.f1314g++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(@NonNull Collection<? extends E> collection) {
        b(this.f1314g + collection.size());
        Iterator<? extends E> it = collection.iterator();
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    public void b(int i2) {
        int[] iArr = this.f1312e;
        if (iArr.length < i2) {
            Object[] objArr = this.f1313f;
            a(i2);
            int i3 = this.f1314g;
            if (i3 > 0) {
                System.arraycopy(iArr, 0, this.f1312e, 0, i3);
                System.arraycopy(objArr, 0, this.f1313f, 0, this.f1314g);
            }
            c(iArr, objArr, this.f1314g);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i2 = this.f1314g;
        if (i2 != 0) {
            c(this.f1312e, this.f1313f, i2);
            this.f1312e = f1306i;
            this.f1313f = f1307j;
            this.f1314g = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(@Nullable Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(@NonNull Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.f1314g; i2++) {
                try {
                    if (!set.contains(h(i2))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public E g(int i2) {
        Object[] objArr = this.f1313f;
        E e2 = (E) objArr[i2];
        int i3 = this.f1314g;
        if (i3 <= 1) {
            c(this.f1312e, objArr, i3);
            this.f1312e = f1306i;
            this.f1313f = f1307j;
            this.f1314g = 0;
        } else {
            int[] iArr = this.f1312e;
            if (iArr.length <= 8 || i3 >= iArr.length / 3) {
                int i4 = i3 - 1;
                this.f1314g = i4;
                if (i2 < i4) {
                    int i5 = i2 + 1;
                    System.arraycopy(iArr, i5, iArr, i2, i4 - i2);
                    Object[] objArr2 = this.f1313f;
                    System.arraycopy(objArr2, i5, objArr2, i2, this.f1314g - i2);
                }
                this.f1313f[this.f1314g] = null;
            } else {
                a(i3 > 8 ? i3 + (i3 >> 1) : 8);
                this.f1314g--;
                if (i2 > 0) {
                    System.arraycopy(iArr, 0, this.f1312e, 0, i2);
                    System.arraycopy(objArr, 0, this.f1313f, 0, i2);
                }
                int i6 = this.f1314g;
                if (i2 < i6) {
                    int i7 = i2 + 1;
                    System.arraycopy(iArr, i7, this.f1312e, i2, i6 - i2);
                    System.arraycopy(objArr, i7, this.f1313f, i2, this.f1314g - i2);
                }
            }
        }
        return e2;
    }

    @Nullable
    public E h(int i2) {
        return (E) this.f1313f[i2];
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.f1312e;
        int i2 = this.f1314g;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 += iArr[i4];
        }
        return i3;
    }

    public int indexOf(@Nullable Object obj) {
        return obj == null ? f() : e(obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f1314g <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return d().m().iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(@Nullable Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf < 0) {
            return false;
        }
        g(iIndexOf);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(@NonNull Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(@NonNull Collection<?> collection) {
        boolean z2 = false;
        for (int i2 = this.f1314g - 1; i2 >= 0; i2--) {
            if (!collection.contains(this.f1313f[i2])) {
                g(i2);
                z2 = true;
            }
        }
        return z2;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.f1314g;
    }

    @Override // java.util.Collection, java.util.Set
    @NonNull
    public Object[] toArray() {
        int i2 = this.f1314g;
        Object[] objArr = new Object[i2];
        System.arraycopy(this.f1313f, 0, objArr, 0, i2);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f1314g * 14);
        sb.append('{');
        for (int i2 = 0; i2 < this.f1314g; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            E eH = h(i2);
            if (eH != this) {
                sb.append(eH);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public b(int i2) {
        if (i2 == 0) {
            this.f1312e = f1306i;
            this.f1313f = f1307j;
        } else {
            a(i2);
        }
        this.f1314g = 0;
    }

    @Override // java.util.Collection, java.util.Set
    @NonNull
    public <T> T[] toArray(@NonNull T[] tArr) {
        if (tArr.length < this.f1314g) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f1314g));
        }
        System.arraycopy(this.f1313f, 0, tArr, 0, this.f1314g);
        int length = tArr.length;
        int i2 = this.f1314g;
        if (length > i2) {
            tArr[i2] = null;
        }
        return tArr;
    }
}
