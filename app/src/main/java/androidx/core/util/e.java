package androidx.core.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: Pools.java */
/* loaded from: classes.dex */
public interface e<T> {
    @Nullable
    T acquire();

    boolean release(@NonNull T t2);
}
