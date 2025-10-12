package androidx.core.util;

import androidx.annotation.NonNull;

/* compiled from: Pools.java */
/* loaded from: classes.dex */
public class f<T> implements e<T> {

    /* renamed from: a, reason: collision with root package name */
    private final Object[] f1636a;

    /* renamed from: b, reason: collision with root package name */
    private int f1637b;

    public f(int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f1636a = new Object[i2];
    }

    private boolean a(@NonNull T t2) {
        for (int i2 = 0; i2 < this.f1637b; i2++) {
            if (this.f1636a[i2] == t2) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.core.util.e
    public T acquire() {
        int i2 = this.f1637b;
        if (i2 <= 0) {
            return null;
        }
        int i3 = i2 - 1;
        Object[] objArr = this.f1636a;
        T t2 = (T) objArr[i3];
        objArr[i3] = null;
        this.f1637b = i2 - 1;
        return t2;
    }

    @Override // androidx.core.util.e
    public boolean release(@NonNull T t2) {
        if (a(t2)) {
            throw new IllegalStateException("Already in the pool!");
        }
        int i2 = this.f1637b;
        Object[] objArr = this.f1636a;
        if (i2 >= objArr.length) {
            return false;
        }
        objArr[i2] = t2;
        this.f1637b = i2 + 1;
        return true;
    }
}
