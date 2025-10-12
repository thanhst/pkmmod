package androidx.core.util;

import androidx.annotation.NonNull;

/* compiled from: Pools.java */
/* loaded from: classes.dex */
public class g<T> extends f<T> {

    /* renamed from: c, reason: collision with root package name */
    private final Object f1638c;

    public g(int i2) {
        super(i2);
        this.f1638c = new Object();
    }

    @Override // androidx.core.util.f, androidx.core.util.e
    public T acquire() {
        T t2;
        synchronized (this.f1638c) {
            t2 = (T) super.acquire();
        }
        return t2;
    }

    @Override // androidx.core.util.f, androidx.core.util.e
    public boolean release(@NonNull T t2) {
        boolean zRelease;
        synchronized (this.f1638c) {
            zRelease = super.release(t2);
        }
        return zRelease;
    }
}
