package com.bumptech.glide.util.pool;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.e;
import androidx.core.util.f;
import androidx.core.util.g;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class FactoryPools {
    private static final int DEFAULT_POOL_SIZE = 20;
    private static final Resetter<Object> EMPTY_RESETTER = new Resetter<Object>() { // from class: com.bumptech.glide.util.pool.FactoryPools.1
        @Override // com.bumptech.glide.util.pool.FactoryPools.Resetter
        public void reset(@NonNull Object obj) {
        }
    };
    private static final String TAG = "FactoryPools";

    public interface Factory<T> {
        T create();
    }

    private static final class FactoryPool<T> implements e<T> {
        private final Factory<T> factory;
        private final e<T> pool;
        private final Resetter<T> resetter;

        FactoryPool(@NonNull e<T> eVar, @NonNull Factory<T> factory, @NonNull Resetter<T> resetter) {
            this.pool = eVar;
            this.factory = factory;
            this.resetter = resetter;
        }

        @Override // androidx.core.util.e
        public T acquire() {
            T tAcquire = this.pool.acquire();
            if (tAcquire == null) {
                tAcquire = this.factory.create();
                if (Log.isLoggable(FactoryPools.TAG, 2)) {
                    Log.v(FactoryPools.TAG, "Created new " + tAcquire.getClass());
                }
            }
            if (tAcquire instanceof Poolable) {
                tAcquire.getVerifier().setRecycled(false);
            }
            return (T) tAcquire;
        }

        @Override // androidx.core.util.e
        public boolean release(@NonNull T t2) {
            if (t2 instanceof Poolable) {
                ((Poolable) t2).getVerifier().setRecycled(true);
            }
            this.resetter.reset(t2);
            return this.pool.release(t2);
        }
    }

    public interface Poolable {
        @NonNull
        StateVerifier getVerifier();
    }

    public interface Resetter<T> {
        void reset(@NonNull T t2);
    }

    private FactoryPools() {
    }

    @NonNull
    private static <T extends Poolable> e<T> build(@NonNull e<T> eVar, @NonNull Factory<T> factory) {
        return build(eVar, factory, emptyResetter());
    }

    @NonNull
    private static <T> Resetter<T> emptyResetter() {
        return (Resetter<T>) EMPTY_RESETTER;
    }

    @NonNull
    public static <T extends Poolable> e<T> simple(int i2, @NonNull Factory<T> factory) {
        return build(new f(i2), factory);
    }

    @NonNull
    public static <T extends Poolable> e<T> threadSafe(int i2, @NonNull Factory<T> factory) {
        return build(new g(i2), factory);
    }

    @NonNull
    public static <T> e<List<T>> threadSafeList() {
        return threadSafeList(20);
    }

    @NonNull
    private static <T> e<T> build(@NonNull e<T> eVar, @NonNull Factory<T> factory, @NonNull Resetter<T> resetter) {
        return new FactoryPool(eVar, factory, resetter);
    }

    @NonNull
    public static <T> e<List<T>> threadSafeList(int i2) {
        return build(new g(i2), new Factory<List<T>>() { // from class: com.bumptech.glide.util.pool.FactoryPools.2
            @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
            @NonNull
            public List<T> create() {
                return new ArrayList();
            }
        }, new Resetter<List<T>>() { // from class: com.bumptech.glide.util.pool.FactoryPools.3
            @Override // com.bumptech.glide.util.pool.FactoryPools.Resetter
            public void reset(@NonNull List<T> list) {
                list.clear();
            }
        });
    }
}
