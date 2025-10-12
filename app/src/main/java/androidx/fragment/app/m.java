package androidx.fragment.app;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.b0;
import androidx.lifecycle.e0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: FragmentManagerViewModel.java */
/* loaded from: classes.dex */
final class m extends androidx.lifecycle.a0 {

    /* renamed from: k, reason: collision with root package name */
    private static final b0.b f2262k = new a();

    /* renamed from: g, reason: collision with root package name */
    private final boolean f2266g;

    /* renamed from: d, reason: collision with root package name */
    private final HashMap<String, Fragment> f2263d = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    private final HashMap<String, m> f2264e = new HashMap<>();

    /* renamed from: f, reason: collision with root package name */
    private final HashMap<String, e0> f2265f = new HashMap<>();

    /* renamed from: h, reason: collision with root package name */
    private boolean f2267h = false;

    /* renamed from: i, reason: collision with root package name */
    private boolean f2268i = false;

    /* renamed from: j, reason: collision with root package name */
    private boolean f2269j = false;

    /* compiled from: FragmentManagerViewModel.java */
    class a implements b0.b {
        a() {
        }

        @Override // androidx.lifecycle.b0.b
        @NonNull
        public <T extends androidx.lifecycle.a0> T a(@NonNull Class<T> cls) {
            return new m(true);
        }

        @Override // androidx.lifecycle.b0.b
        public /* synthetic */ androidx.lifecycle.a0 b(Class cls, s.a aVar) {
            return androidx.lifecycle.c0.b(this, cls, aVar);
        }
    }

    m(boolean z2) {
        this.f2266g = z2;
    }

    @NonNull
    static m j(e0 e0Var) {
        return (m) new androidx.lifecycle.b0(e0Var, f2262k).a(m.class);
    }

    @Override // androidx.lifecycle.a0
    protected void d() {
        if (FragmentManager.F0(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f2267h = true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || m.class != obj.getClass()) {
            return false;
        }
        m mVar = (m) obj;
        return this.f2263d.equals(mVar.f2263d) && this.f2264e.equals(mVar.f2264e) && this.f2265f.equals(mVar.f2265f);
    }

    void f(@NonNull Fragment fragment) {
        if (this.f2269j) {
            if (FragmentManager.F0(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else {
            if (this.f2263d.containsKey(fragment.mWho)) {
                return;
            }
            this.f2263d.put(fragment.mWho, fragment);
            if (FragmentManager.F0(2)) {
                Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
            }
        }
    }

    void g(@NonNull Fragment fragment) {
        if (FragmentManager.F0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + fragment);
        }
        m mVar = this.f2264e.get(fragment.mWho);
        if (mVar != null) {
            mVar.d();
            this.f2264e.remove(fragment.mWho);
        }
        e0 e0Var = this.f2265f.get(fragment.mWho);
        if (e0Var != null) {
            e0Var.a();
            this.f2265f.remove(fragment.mWho);
        }
    }

    @Nullable
    Fragment h(String str) {
        return this.f2263d.get(str);
    }

    public int hashCode() {
        return (((this.f2263d.hashCode() * 31) + this.f2264e.hashCode()) * 31) + this.f2265f.hashCode();
    }

    @NonNull
    m i(@NonNull Fragment fragment) {
        m mVar = this.f2264e.get(fragment.mWho);
        if (mVar != null) {
            return mVar;
        }
        m mVar2 = new m(this.f2266g);
        this.f2264e.put(fragment.mWho, mVar2);
        return mVar2;
    }

    @NonNull
    Collection<Fragment> k() {
        return new ArrayList(this.f2263d.values());
    }

    @NonNull
    e0 l(@NonNull Fragment fragment) {
        e0 e0Var = this.f2265f.get(fragment.mWho);
        if (e0Var != null) {
            return e0Var;
        }
        e0 e0Var2 = new e0();
        this.f2265f.put(fragment.mWho, e0Var2);
        return e0Var2;
    }

    boolean m() {
        return this.f2267h;
    }

    void n(@NonNull Fragment fragment) {
        if (this.f2269j) {
            if (FragmentManager.F0(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
                return;
            }
            return;
        }
        if ((this.f2263d.remove(fragment.mWho) != null) && FragmentManager.F0(2)) {
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
        }
    }

    void o(boolean z2) {
        this.f2269j = z2;
    }

    boolean p(@NonNull Fragment fragment) {
        if (this.f2263d.containsKey(fragment.mWho)) {
            return this.f2266g ? this.f2267h : !this.f2268i;
        }
        return true;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<Fragment> it = this.f2263d.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> it2 = this.f2264e.keySet().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it3 = this.f2265f.keySet().iterator();
        while (it3.hasNext()) {
            sb.append(it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
