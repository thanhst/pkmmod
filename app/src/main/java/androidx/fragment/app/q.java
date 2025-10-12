package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: FragmentStore.java */
/* loaded from: classes.dex */
class q {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<Fragment> f2278a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private final HashMap<String, p> f2279b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private m f2280c;

    q() {
    }

    void a(@NonNull Fragment fragment) {
        if (this.f2278a.contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        synchronized (this.f2278a) {
            this.f2278a.add(fragment);
        }
        fragment.mAdded = true;
    }

    void b() {
        this.f2279b.values().removeAll(Collections.singleton(null));
    }

    boolean c(@NonNull String str) {
        return this.f2279b.get(str) != null;
    }

    void d(int i2) {
        for (p pVar : this.f2279b.values()) {
            if (pVar != null) {
                pVar.t(i2);
            }
        }
    }

    void e(@NonNull String str, @Nullable FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @Nullable String[] strArr) {
        String str2 = str + "    ";
        if (!this.f2279b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (p pVar : this.f2279b.values()) {
                printWriter.print(str);
                if (pVar != null) {
                    Fragment fragmentK = pVar.k();
                    printWriter.println(fragmentK);
                    fragmentK.dump(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size = this.f2278a.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i2 = 0; i2 < size; i2++) {
                Fragment fragment = this.f2278a.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
    }

    @Nullable
    Fragment f(@NonNull String str) {
        p pVar = this.f2279b.get(str);
        if (pVar != null) {
            return pVar.k();
        }
        return null;
    }

    @Nullable
    Fragment g(@IdRes int i2) {
        for (int size = this.f2278a.size() - 1; size >= 0; size--) {
            Fragment fragment = this.f2278a.get(size);
            if (fragment != null && fragment.mFragmentId == i2) {
                return fragment;
            }
        }
        for (p pVar : this.f2279b.values()) {
            if (pVar != null) {
                Fragment fragmentK = pVar.k();
                if (fragmentK.mFragmentId == i2) {
                    return fragmentK;
                }
            }
        }
        return null;
    }

    @Nullable
    Fragment h(@Nullable String str) {
        if (str != null) {
            for (int size = this.f2278a.size() - 1; size >= 0; size--) {
                Fragment fragment = this.f2278a.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (p pVar : this.f2279b.values()) {
            if (pVar != null) {
                Fragment fragmentK = pVar.k();
                if (str.equals(fragmentK.mTag)) {
                    return fragmentK;
                }
            }
        }
        return null;
    }

    @Nullable
    Fragment i(@NonNull String str) {
        Fragment fragmentFindFragmentByWho;
        for (p pVar : this.f2279b.values()) {
            if (pVar != null && (fragmentFindFragmentByWho = pVar.k().findFragmentByWho(str)) != null) {
                return fragmentFindFragmentByWho;
            }
        }
        return null;
    }

    int j(@NonNull Fragment fragment) {
        View view;
        View view2;
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup == null) {
            return -1;
        }
        int iIndexOf = this.f2278a.indexOf(fragment);
        for (int i2 = iIndexOf - 1; i2 >= 0; i2--) {
            Fragment fragment2 = this.f2278a.get(i2);
            if (fragment2.mContainer == viewGroup && (view2 = fragment2.mView) != null) {
                return viewGroup.indexOfChild(view2) + 1;
            }
        }
        while (true) {
            iIndexOf++;
            if (iIndexOf >= this.f2278a.size()) {
                return -1;
            }
            Fragment fragment3 = this.f2278a.get(iIndexOf);
            if (fragment3.mContainer == viewGroup && (view = fragment3.mView) != null) {
                return viewGroup.indexOfChild(view);
            }
        }
    }

    @NonNull
    List<p> k() {
        ArrayList arrayList = new ArrayList();
        for (p pVar : this.f2279b.values()) {
            if (pVar != null) {
                arrayList.add(pVar);
            }
        }
        return arrayList;
    }

    @NonNull
    List<Fragment> l() {
        ArrayList arrayList = new ArrayList();
        for (p pVar : this.f2279b.values()) {
            if (pVar != null) {
                arrayList.add(pVar.k());
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    @Nullable
    p m(@NonNull String str) {
        return this.f2279b.get(str);
    }

    @NonNull
    List<Fragment> n() {
        ArrayList arrayList;
        if (this.f2278a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f2278a) {
            arrayList = new ArrayList(this.f2278a);
        }
        return arrayList;
    }

    m o() {
        return this.f2280c;
    }

    void p(@NonNull p pVar) {
        Fragment fragmentK = pVar.k();
        if (c(fragmentK.mWho)) {
            return;
        }
        this.f2279b.put(fragmentK.mWho, pVar);
        if (fragmentK.mRetainInstanceChangedWhileDetached) {
            if (fragmentK.mRetainInstance) {
                this.f2280c.f(fragmentK);
            } else {
                this.f2280c.n(fragmentK);
            }
            fragmentK.mRetainInstanceChangedWhileDetached = false;
        }
        if (FragmentManager.F0(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + fragmentK);
        }
    }

    void q(@NonNull p pVar) {
        Fragment fragmentK = pVar.k();
        if (fragmentK.mRetainInstance) {
            this.f2280c.n(fragmentK);
        }
        if (this.f2279b.put(fragmentK.mWho, null) != null && FragmentManager.F0(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + fragmentK);
        }
    }

    void r() {
        Iterator<Fragment> it = this.f2278a.iterator();
        while (it.hasNext()) {
            p pVar = this.f2279b.get(it.next().mWho);
            if (pVar != null) {
                pVar.m();
            }
        }
        for (p pVar2 : this.f2279b.values()) {
            if (pVar2 != null) {
                pVar2.m();
                Fragment fragmentK = pVar2.k();
                if (fragmentK.mRemoving && !fragmentK.isInBackStack()) {
                    q(pVar2);
                }
            }
        }
    }

    void s(@NonNull Fragment fragment) {
        synchronized (this.f2278a) {
            this.f2278a.remove(fragment);
        }
        fragment.mAdded = false;
    }

    void t() {
        this.f2279b.clear();
    }

    void u(@Nullable List<String> list) {
        this.f2278a.clear();
        if (list != null) {
            for (String str : list) {
                Fragment fragmentF = f(str);
                if (fragmentF == null) {
                    throw new IllegalStateException("No instantiated fragment for (" + str + ")");
                }
                if (FragmentManager.F0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + str + "): " + fragmentF);
                }
                a(fragmentF);
            }
        }
    }

    @NonNull
    ArrayList<FragmentState> v() {
        ArrayList<FragmentState> arrayList = new ArrayList<>(this.f2279b.size());
        for (p pVar : this.f2279b.values()) {
            if (pVar != null) {
                Fragment fragmentK = pVar.k();
                FragmentState fragmentStateR = pVar.r();
                arrayList.add(fragmentStateR);
                if (FragmentManager.F0(2)) {
                    Log.v("FragmentManager", "Saved state of " + fragmentK + ": " + fragmentStateR.f2149q);
                }
            }
        }
        return arrayList;
    }

    @Nullable
    ArrayList<String> w() {
        synchronized (this.f2278a) {
            if (this.f2278a.isEmpty()) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>(this.f2278a.size());
            Iterator<Fragment> it = this.f2278a.iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                arrayList.add(next.mWho);
                if (FragmentManager.F0(2)) {
                    Log.v("FragmentManager", "saveAllState: adding fragment (" + next.mWho + "): " + next);
                }
            }
            return arrayList;
        }
    }

    void x(@NonNull m mVar) {
        this.f2280c = mVar;
    }
}
