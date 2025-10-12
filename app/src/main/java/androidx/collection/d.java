package androidx.collection;

import androidx.annotation.Nullable;

/* compiled from: LongSparseArray.java */
/* loaded from: classes.dex */
public class d<E> implements Cloneable {

    /* renamed from: i, reason: collision with root package name */
    private static final Object f1320i = new Object();

    /* renamed from: e, reason: collision with root package name */
    private boolean f1321e;

    /* renamed from: f, reason: collision with root package name */
    private long[] f1322f;

    /* renamed from: g, reason: collision with root package name */
    private Object[] f1323g;

    /* renamed from: h, reason: collision with root package name */
    private int f1324h;

    public d() {
        this(10);
    }

    private void d() {
        int i2 = this.f1324h;
        long[] jArr = this.f1322f;
        Object[] objArr = this.f1323g;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            Object obj = objArr[i4];
            if (obj != f1320i) {
                if (i4 != i3) {
                    jArr[i3] = jArr[i4];
                    objArr[i3] = obj;
                    objArr[i4] = null;
                }
                i3++;
            }
        }
        this.f1321e = false;
        this.f1324h = i3;
    }

    public void a(long j2, E e2) {
        int i2 = this.f1324h;
        if (i2 != 0 && j2 <= this.f1322f[i2 - 1]) {
            h(j2, e2);
            return;
        }
        if (this.f1321e && i2 >= this.f1322f.length) {
            d();
        }
        int i3 = this.f1324h;
        if (i3 >= this.f1322f.length) {
            int iF = c.f(i3 + 1);
            long[] jArr = new long[iF];
            Object[] objArr = new Object[iF];
            long[] jArr2 = this.f1322f;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr2 = this.f1323g;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f1322f = jArr;
            this.f1323g = objArr;
        }
        this.f1322f[i3] = j2;
        this.f1323g[i3] = e2;
        this.f1324h = i3 + 1;
    }

    public void b() {
        int i2 = this.f1324h;
        Object[] objArr = this.f1323g;
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = null;
        }
        this.f1324h = 0;
        this.f1321e = false;
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public d<E> clone() {
        try {
            d<E> dVar = (d) super.clone();
            dVar.f1322f = (long[]) this.f1322f.clone();
            dVar.f1323g = (Object[]) this.f1323g.clone();
            return dVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    @Nullable
    public E e(long j2) {
        return f(j2, null);
    }

    public E f(long j2, E e2) {
        E e3;
        int iB = c.b(this.f1322f, this.f1324h, j2);
        return (iB < 0 || (e3 = (E) this.f1323g[iB]) == f1320i) ? e2 : e3;
    }

    public long g(int i2) {
        if (this.f1321e) {
            d();
        }
        return this.f1322f[i2];
    }

    public void h(long j2, E e2) {
        int iB = c.b(this.f1322f, this.f1324h, j2);
        if (iB >= 0) {
            this.f1323g[iB] = e2;
            return;
        }
        int iB2 = iB ^ (-1);
        int i2 = this.f1324h;
        if (iB2 < i2) {
            Object[] objArr = this.f1323g;
            if (objArr[iB2] == f1320i) {
                this.f1322f[iB2] = j2;
                objArr[iB2] = e2;
                return;
            }
        }
        if (this.f1321e && i2 >= this.f1322f.length) {
            d();
            iB2 = c.b(this.f1322f, this.f1324h, j2) ^ (-1);
        }
        int i3 = this.f1324h;
        if (i3 >= this.f1322f.length) {
            int iF = c.f(i3 + 1);
            long[] jArr = new long[iF];
            Object[] objArr2 = new Object[iF];
            long[] jArr2 = this.f1322f;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f1323g;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f1322f = jArr;
            this.f1323g = objArr2;
        }
        int i4 = this.f1324h;
        if (i4 - iB2 != 0) {
            long[] jArr3 = this.f1322f;
            int i5 = iB2 + 1;
            System.arraycopy(jArr3, iB2, jArr3, i5, i4 - iB2);
            Object[] objArr4 = this.f1323g;
            System.arraycopy(objArr4, iB2, objArr4, i5, this.f1324h - iB2);
        }
        this.f1322f[iB2] = j2;
        this.f1323g[iB2] = e2;
        this.f1324h++;
    }

    public void i(long j2) {
        int iB = c.b(this.f1322f, this.f1324h, j2);
        if (iB >= 0) {
            Object[] objArr = this.f1323g;
            Object obj = objArr[iB];
            Object obj2 = f1320i;
            if (obj != obj2) {
                objArr[iB] = obj2;
                this.f1321e = true;
            }
        }
    }

    public int j() {
        if (this.f1321e) {
            d();
        }
        return this.f1324h;
    }

    public E k(int i2) {
        if (this.f1321e) {
            d();
        }
        return (E) this.f1323g[i2];
    }

    public String toString() {
        if (j() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f1324h * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.f1324h; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(g(i2));
            sb.append('=');
            E eK = k(i2);
            if (eK != this) {
                sb.append(eK);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public d(int i2) {
        this.f1321e = false;
        if (i2 == 0) {
            this.f1322f = c.f1318b;
            this.f1323g = c.f1319c;
        } else {
            int iF = c.f(i2);
            this.f1322f = new long[iF];
            this.f1323g = new Object[iF];
        }
    }
}
