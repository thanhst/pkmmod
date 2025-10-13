package i;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

import java.util.HashMap;
import java.util.Map;

/* compiled from: FastSafeIterableMap.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class a_i<K, V> extends b_i<K, V> {

    /* renamed from: i, reason: collision with root package name */
    private HashMap<K, b_i.c<K, V>> f3299i = new HashMap<>();

    @Override // i.b
    protected b_i.c<K, V> b(K k2) {
        return this.f3299i.get(k2);
    }

    public boolean contains(K k2) {
        return this.f3299i.containsKey(k2);
    }

    @Override // i.b
    public V f(@NonNull K k2, @NonNull V v2) {
        b_i.c<K, V> cVarB = b(k2);
        if (cVarB != null) {
            return cVarB.f3305f;
        }
        this.f3299i.put(k2, e(k2, v2));
        return null;
    }

    @Override // i.b
    public V g(@NonNull K k2) {
        V v2 = (V) super.g(k2);
        this.f3299i.remove(k2);
        return v2;
    }

    public Map.Entry<K, V> h(K k2) {
        if (contains(k2)) {
            return this.f3299i.get(k2).f3307h;
        }
        return null;
    }
}
