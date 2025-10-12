package androidx.collection;

import androidx.annotation.Nullable;

/* compiled from: SparseArrayCompat.java */
/* loaded from: classes.dex */
public class h<E> implements Cloneable {

    /* renamed from: i, reason: collision with root package name */
    private static final Object f1348i = new Object();

    /* renamed from: e, reason: collision with root package name */
    private boolean f1349e;

    /* renamed from: f, reason: collision with root package name */
    private int[] f1350f;

    /* renamed from: g, reason: collision with root package name */
    private Object[] f1351g;

    /* renamed from: h, reason: collision with root package name */
    private int f1352h;

    public h() {
        this(10);
    }

    private void d() {
        int i2 = this.f1352h;
        int[] iArr = this.f1350f;
        Object[] objArr = this.f1351g;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            Object obj = objArr[i4];
            if (obj != f1348i) {
                if (i4 != i3) {
                    iArr[i3] = iArr[i4];
                    objArr[i3] = obj;
                    objArr[i4] = null;
                }
                i3++;
            }
        }
        this.f1349e = false;
        this.f1352h = i3;
    }

    public void a(int i2, E e2) {
        int i3 = this.f1352h;
        if (i3 != 0 && i2 <= this.f1350f[i3 - 1]) {
            h(i2, e2);
            return;
        }
        if (this.f1349e && i3 >= this.f1350f.length) {
            d();
        }
        int i4 = this.f1352h;
        if (i4 >= this.f1350f.length) {
            int iE = c.e(i4 + 1);
            int[] iArr = new int[iE];
            Object[] objArr = new Object[iE];
            int[] iArr2 = this.f1350f;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.f1351g;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f1350f = iArr;
            this.f1351g = objArr;
        }
        this.f1350f[i4] = i2;
        this.f1351g[i4] = e2;
        this.f1352h = i4 + 1;
    }

    public void b() {
        int i2 = this.f1352h;
        Object[] objArr = this.f1351g;
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = null;
        }
        this.f1352h = 0;
        this.f1349e = false;
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public h<E> clone() {
        try {
            h<E> hVar = (h) super.clone();
            hVar.f1350f = (int[]) this.f1350f.clone();
            hVar.f1351g = (Object[]) this.f1351g.clone();
            return hVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    @Nullable
    public E e(int i2) {
        return f(i2, null);
    }

    public E f(int i2, E e2) {
        E e3;
        int iA = c.a(this.f1350f, this.f1352h, i2);
        return (iA < 0 || (e3 = (E) this.f1351g[iA]) == f1348i) ? e2 : e3;
    }

    public int g(int i2) {
        if (this.f1349e) {
            d();
        }
        return this.f1350f[i2];
    }

    public void h(int i2, E e2) {
        int iA = c.a(this.f1350f, this.f1352h, i2);
        if (iA >= 0) {
            this.f1351g[iA] = e2;
            return;
        }
        int iA2 = iA ^ (-1);
        int i3 = this.f1352h;
        if (iA2 < i3) {
            Object[] objArr = this.f1351g;
            if (objArr[iA2] == f1348i) {
                this.f1350f[iA2] = i2;
                objArr[iA2] = e2;
                return;
            }
        }
        if (this.f1349e && i3 >= this.f1350f.length) {
            d();
            iA2 = c.a(this.f1350f, this.f1352h, i2) ^ (-1);
        }
        int i4 = this.f1352h;
        if (i4 >= this.f1350f.length) {
            int iE = c.e(i4 + 1);
            int[] iArr = new int[iE];
            Object[] objArr2 = new Object[iE];
            int[] iArr2 = this.f1350f;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f1351g;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f1350f = iArr;
            this.f1351g = objArr2;
        }
        int i5 = this.f1352h;
        if (i5 - iA2 != 0) {
            int[] iArr3 = this.f1350f;
            int i6 = iA2 + 1;
            System.arraycopy(iArr3, iA2, iArr3, i6, i5 - iA2);
            Object[] objArr4 = this.f1351g;
            System.arraycopy(objArr4, iA2, objArr4, i6, this.f1352h - iA2);
        }
        this.f1350f[iA2] = i2;
        this.f1351g[iA2] = e2;
        this.f1352h++;
    }

    public int i() {
        if (this.f1349e) {
            d();
        }
        return this.f1352h;
    }

    public E j(int i2) {
        if (this.f1349e) {
            d();
        }
        return (E) this.f1351g[i2];
    }

    public String toString() {
        if (i() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f1352h * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.f1352h; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(g(i2));
            sb.append('=');
            E eJ = j(i2);
            if (eJ != this) {
                sb.append(eJ);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public h(int i2) {
        this.f1349e = false;
        if (i2 == 0) {
            this.f1350f = c.f1317a;
            this.f1351g = c.f1319c;
        } else {
            int iE = c.e(i2);
            this.f1350f = new int[iE];
            this.f1351g = new Object[iE];
        }
    }
}
