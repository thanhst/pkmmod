package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class LruCache<T, Y> {
    private final Map<T, Y> cache = new LinkedHashMap(100, 0.75f, true);
    private long currentSize;
    private final long initialMaxSize;
    private long maxSize;

    public LruCache(long j2) {
        this.initialMaxSize = j2;
        this.maxSize = j2;
    }

    private void evict() {
        trimToSize(this.maxSize);
    }

    public void clearMemory() {
        trimToSize(0L);
    }

    public synchronized boolean contains(@NonNull T t2) {
        return this.cache.containsKey(t2);
    }

    @Nullable
    public synchronized Y get(@NonNull T t2) {
        return this.cache.get(t2);
    }

    protected synchronized int getCount() {
        return this.cache.size();
    }

    public synchronized long getCurrentSize() {
        return this.currentSize;
    }

    public synchronized long getMaxSize() {
        return this.maxSize;
    }

    protected int getSize(@Nullable Y y2) {
        return 1;
    }

    protected void onItemEvicted(@NonNull T t2, @Nullable Y y2) {
    }

    @Nullable
    public synchronized Y put(@NonNull T t2, @Nullable Y y2) {
        long size = getSize(y2);
        if (size >= this.maxSize) {
            onItemEvicted(t2, y2);
            return null;
        }
        if (y2 != null) {
            this.currentSize += size;
        }
        Y yPut = this.cache.put(t2, y2);
        if (yPut != null) {
            this.currentSize -= getSize(yPut);
            if (!yPut.equals(y2)) {
                onItemEvicted(t2, yPut);
            }
        }
        evict();
        return yPut;
    }

    @Nullable
    public synchronized Y remove(@NonNull T t2) {
        Y yRemove;
        yRemove = this.cache.remove(t2);
        if (yRemove != null) {
            this.currentSize -= getSize(yRemove);
        }
        return yRemove;
    }

    public synchronized void setSizeMultiplier(float f2) {
        if (f2 < 0.0f) {
            throw new IllegalArgumentException("Multiplier must be >= 0");
        }
        this.maxSize = Math.round(this.initialMaxSize * f2);
        evict();
    }

    protected synchronized void trimToSize(long j2) {
        while (this.currentSize > j2) {
            Iterator<Map.Entry<T, Y>> it = this.cache.entrySet().iterator();
            Map.Entry<T, Y> next = it.next();
            Y value = next.getValue();
            this.currentSize -= getSize(value);
            T key = next.getKey();
            it.remove();
            onItemEvicted(key, value);
        }
    }
}
