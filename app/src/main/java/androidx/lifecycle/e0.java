package androidx.lifecycle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: ViewModelStore.java */
/* loaded from: classes.dex */
public class e0 {

    /* renamed from: a, reason: collision with root package name */
    private final HashMap<String, a0> f2447a = new HashMap<>();

    public final void a() {
        Iterator<a0> it = this.f2447a.values().iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.f2447a.clear();
    }

    final a0 b(String str) {
        return this.f2447a.get(str);
    }

    Set<String> c() {
        return new HashSet(this.f2447a.keySet());
    }

    final void d(String str, a0 a0Var) {
        a0 a0VarPut = this.f2447a.put(str, a0Var);
        if (a0VarPut != null) {
            a0VarPut.d();
        }
    }
}
