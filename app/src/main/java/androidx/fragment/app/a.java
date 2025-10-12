package androidx.fragment.app;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.r;
import java.io.PrintWriter;
import java.util.ArrayList;

/* compiled from: BackStackRecord.java */
/* loaded from: classes.dex */
final class a extends r implements FragmentManager.m {

    /* renamed from: t, reason: collision with root package name */
    final FragmentManager f2170t;

    /* renamed from: u, reason: collision with root package name */
    boolean f2171u;

    /* renamed from: v, reason: collision with root package name */
    int f2172v;

    a(@NonNull FragmentManager fragmentManager) {
        super(fragmentManager.q0(), fragmentManager.t0() != null ? fragmentManager.t0().f().getClassLoader() : null);
        this.f2172v = -1;
        this.f2170t = fragmentManager;
    }

    private static boolean x(r.a aVar) {
        Fragment fragment = aVar.f2301b;
        return (fragment == null || !fragment.mAdded || fragment.mView == null || fragment.mDetached || fragment.mHidden || !fragment.isPostponed()) ? false : true;
    }

    void A(Fragment.k kVar) {
        for (int i2 = 0; i2 < this.f2283c.size(); i2++) {
            r.a aVar = this.f2283c.get(i2);
            if (x(aVar)) {
                aVar.f2301b.setOnStartEnterTransitionListener(kVar);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    androidx.fragment.app.Fragment B(java.util.ArrayList<androidx.fragment.app.Fragment> r6, androidx.fragment.app.Fragment r7) {
        /*
            r5 = this;
            java.util.ArrayList<androidx.fragment.app.r$a> r0 = r5.f2283c
            int r0 = r0.size()
            r1 = 1
            int r0 = r0 - r1
        L8:
            if (r0 < 0) goto L35
            java.util.ArrayList<androidx.fragment.app.r$a> r2 = r5.f2283c
            java.lang.Object r2 = r2.get(r0)
            androidx.fragment.app.r$a r2 = (androidx.fragment.app.r.a) r2
            int r3 = r2.f2300a
            if (r3 == r1) goto L2d
            r4 = 3
            if (r3 == r4) goto L27
            switch(r3) {
                case 6: goto L27;
                case 7: goto L2d;
                case 8: goto L25;
                case 9: goto L22;
                case 10: goto L1d;
                default: goto L1c;
            }
        L1c:
            goto L32
        L1d:
            androidx.lifecycle.Lifecycle$State r3 = r2.f2306g
            r2.f2307h = r3
            goto L32
        L22:
            androidx.fragment.app.Fragment r7 = r2.f2301b
            goto L32
        L25:
            r7 = 0
            goto L32
        L27:
            androidx.fragment.app.Fragment r2 = r2.f2301b
            r6.add(r2)
            goto L32
        L2d:
            androidx.fragment.app.Fragment r2 = r2.f2301b
            r6.remove(r2)
        L32:
            int r0 = r0 + (-1)
            goto L8
        L35:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.a.B(java.util.ArrayList, androidx.fragment.app.Fragment):androidx.fragment.app.Fragment");
    }

    @Override // androidx.fragment.app.FragmentManager.m
    public boolean a(@NonNull ArrayList<a> arrayList, @NonNull ArrayList<Boolean> arrayList2) {
        if (FragmentManager.F0(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.f2289i) {
            return true;
        }
        this.f2170t.e(this);
        return true;
    }

    @Override // androidx.fragment.app.r
    public int f() {
        return o(false);
    }

    @Override // androidx.fragment.app.r
    public int g() {
        return o(true);
    }

    @Override // androidx.fragment.app.r
    public void h() {
        j();
        this.f2170t.c0(this, false);
    }

    @Override // androidx.fragment.app.r
    public void i() {
        j();
        this.f2170t.c0(this, true);
    }

    @Override // androidx.fragment.app.r
    void k(int i2, Fragment fragment, @Nullable String str, int i3) {
        super.k(i2, fragment, str, i3);
        fragment.mFragmentManager = this.f2170t;
    }

    @Override // androidx.fragment.app.r
    @NonNull
    public r l(@NonNull Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.f2170t) {
            return super.l(fragment);
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    void n(int i2) {
        if (this.f2289i) {
            if (FragmentManager.F0(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i2);
            }
            int size = this.f2283c.size();
            for (int i3 = 0; i3 < size; i3++) {
                r.a aVar = this.f2283c.get(i3);
                Fragment fragment = aVar.f2301b;
                if (fragment != null) {
                    fragment.mBackStackNesting += i2;
                    if (FragmentManager.F0(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.f2301b + " to " + aVar.f2301b.mBackStackNesting);
                    }
                }
            }
        }
    }

    int o(boolean z2) {
        if (this.f2171u) {
            throw new IllegalStateException("commit already called");
        }
        if (FragmentManager.F0(2)) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new b0("FragmentManager"));
            p("  ", printWriter);
            printWriter.close();
        }
        this.f2171u = true;
        if (this.f2289i) {
            this.f2172v = this.f2170t.j();
        } else {
            this.f2172v = -1;
        }
        this.f2170t.Z(this, z2);
        return this.f2172v;
    }

    public void p(String str, PrintWriter printWriter) {
        q(str, printWriter, true);
    }

    public void q(String str, PrintWriter printWriter, boolean z2) {
        String str2;
        if (z2) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f2291k);
            printWriter.print(" mIndex=");
            printWriter.print(this.f2172v);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f2171u);
            if (this.f2288h != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f2288h));
            }
            if (this.f2284d != 0 || this.f2285e != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f2284d));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f2285e));
            }
            if (this.f2286f != 0 || this.f2287g != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f2286f));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f2287g));
            }
            if (this.f2292l != 0 || this.f2293m != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f2292l));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f2293m);
            }
            if (this.f2294n != 0 || this.f2295o != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f2294n));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f2295o);
            }
        }
        if (this.f2283c.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.f2283c.size();
        for (int i2 = 0; i2 < size; i2++) {
            r.a aVar = this.f2283c.get(i2);
            switch (aVar.f2300a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + aVar.f2300a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i2);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(aVar.f2301b);
            if (z2) {
                if (aVar.f2302c != 0 || aVar.f2303d != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f2302c));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f2303d));
                }
                if (aVar.f2304e != 0 || aVar.f2305f != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f2304e));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f2305f));
                }
            }
        }
    }

    void r() {
        int size = this.f2283c.size();
        for (int i2 = 0; i2 < size; i2++) {
            r.a aVar = this.f2283c.get(i2);
            Fragment fragment = aVar.f2301b;
            if (fragment != null) {
                fragment.setPopDirection(false);
                fragment.setNextTransition(this.f2288h);
                fragment.setSharedElementNames(this.f2296p, this.f2297q);
            }
            switch (aVar.f2300a) {
                case 1:
                    fragment.setAnimations(aVar.f2302c, aVar.f2303d, aVar.f2304e, aVar.f2305f);
                    this.f2170t.k1(fragment, false);
                    this.f2170t.g(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f2300a);
                case 3:
                    fragment.setAnimations(aVar.f2302c, aVar.f2303d, aVar.f2304e, aVar.f2305f);
                    this.f2170t.c1(fragment);
                    break;
                case 4:
                    fragment.setAnimations(aVar.f2302c, aVar.f2303d, aVar.f2304e, aVar.f2305f);
                    this.f2170t.C0(fragment);
                    break;
                case 5:
                    fragment.setAnimations(aVar.f2302c, aVar.f2303d, aVar.f2304e, aVar.f2305f);
                    this.f2170t.k1(fragment, false);
                    this.f2170t.o1(fragment);
                    break;
                case 6:
                    fragment.setAnimations(aVar.f2302c, aVar.f2303d, aVar.f2304e, aVar.f2305f);
                    this.f2170t.y(fragment);
                    break;
                case 7:
                    fragment.setAnimations(aVar.f2302c, aVar.f2303d, aVar.f2304e, aVar.f2305f);
                    this.f2170t.k1(fragment, false);
                    this.f2170t.l(fragment);
                    break;
                case 8:
                    this.f2170t.m1(fragment);
                    break;
                case 9:
                    this.f2170t.m1(null);
                    break;
                case 10:
                    this.f2170t.l1(fragment, aVar.f2307h);
                    break;
            }
            if (!this.f2298r && aVar.f2300a != 1 && fragment != null && !FragmentManager.P) {
                this.f2170t.P0(fragment);
            }
        }
        if (this.f2298r || FragmentManager.P) {
            return;
        }
        FragmentManager fragmentManager = this.f2170t;
        fragmentManager.Q0(fragmentManager.f2092q, true);
    }

    void s(boolean z2) {
        for (int size = this.f2283c.size() - 1; size >= 0; size--) {
            r.a aVar = this.f2283c.get(size);
            Fragment fragment = aVar.f2301b;
            if (fragment != null) {
                fragment.setPopDirection(true);
                fragment.setNextTransition(FragmentManager.h1(this.f2288h));
                fragment.setSharedElementNames(this.f2297q, this.f2296p);
            }
            switch (aVar.f2300a) {
                case 1:
                    fragment.setAnimations(aVar.f2302c, aVar.f2303d, aVar.f2304e, aVar.f2305f);
                    this.f2170t.k1(fragment, true);
                    this.f2170t.c1(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f2300a);
                case 3:
                    fragment.setAnimations(aVar.f2302c, aVar.f2303d, aVar.f2304e, aVar.f2305f);
                    this.f2170t.g(fragment);
                    break;
                case 4:
                    fragment.setAnimations(aVar.f2302c, aVar.f2303d, aVar.f2304e, aVar.f2305f);
                    this.f2170t.o1(fragment);
                    break;
                case 5:
                    fragment.setAnimations(aVar.f2302c, aVar.f2303d, aVar.f2304e, aVar.f2305f);
                    this.f2170t.k1(fragment, true);
                    this.f2170t.C0(fragment);
                    break;
                case 6:
                    fragment.setAnimations(aVar.f2302c, aVar.f2303d, aVar.f2304e, aVar.f2305f);
                    this.f2170t.l(fragment);
                    break;
                case 7:
                    fragment.setAnimations(aVar.f2302c, aVar.f2303d, aVar.f2304e, aVar.f2305f);
                    this.f2170t.k1(fragment, true);
                    this.f2170t.y(fragment);
                    break;
                case 8:
                    this.f2170t.m1(null);
                    break;
                case 9:
                    this.f2170t.m1(fragment);
                    break;
                case 10:
                    this.f2170t.l1(fragment, aVar.f2306g);
                    break;
            }
            if (!this.f2298r && aVar.f2300a != 3 && fragment != null && !FragmentManager.P) {
                this.f2170t.P0(fragment);
            }
        }
        if (this.f2298r || !z2 || FragmentManager.P) {
            return;
        }
        FragmentManager fragmentManager = this.f2170t;
        fragmentManager.Q0(fragmentManager.f2092q, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    androidx.fragment.app.Fragment t(java.util.ArrayList<androidx.fragment.app.Fragment> r17, androidx.fragment.app.Fragment r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r18
            r4 = 0
        L7:
            java.util.ArrayList<androidx.fragment.app.r$a> r5 = r0.f2283c
            int r5 = r5.size()
            if (r4 >= r5) goto Lba
            java.util.ArrayList<androidx.fragment.app.r$a> r5 = r0.f2283c
            java.lang.Object r5 = r5.get(r4)
            androidx.fragment.app.r$a r5 = (androidx.fragment.app.r.a) r5
            int r6 = r5.f2300a
            r7 = 0
            r8 = 1
            if (r6 == r8) goto Lb2
            r9 = 2
            r10 = 3
            r11 = 9
            if (r6 == r9) goto L58
            if (r6 == r10) goto L41
            r9 = 6
            if (r6 == r9) goto L41
            r7 = 7
            if (r6 == r7) goto Lb2
            r7 = 8
            if (r6 == r7) goto L31
            goto Lb7
        L31:
            java.util.ArrayList<androidx.fragment.app.r$a> r6 = r0.f2283c
            androidx.fragment.app.r$a r7 = new androidx.fragment.app.r$a
            r7.<init>(r11, r3)
            r6.add(r4, r7)
            int r4 = r4 + 1
            androidx.fragment.app.Fragment r3 = r5.f2301b
            goto Lb7
        L41:
            androidx.fragment.app.Fragment r6 = r5.f2301b
            r1.remove(r6)
            androidx.fragment.app.Fragment r5 = r5.f2301b
            if (r5 != r3) goto Lb7
            java.util.ArrayList<androidx.fragment.app.r$a> r3 = r0.f2283c
            androidx.fragment.app.r$a r6 = new androidx.fragment.app.r$a
            r6.<init>(r11, r5)
            r3.add(r4, r6)
            int r4 = r4 + 1
            r3 = r7
            goto Lb7
        L58:
            androidx.fragment.app.Fragment r6 = r5.f2301b
            int r9 = r6.mContainerId
            int r12 = r17.size()
            int r12 = r12 - r8
            r13 = 0
        L62:
            if (r12 < 0) goto La2
            java.lang.Object r14 = r1.get(r12)
            androidx.fragment.app.Fragment r14 = (androidx.fragment.app.Fragment) r14
            int r15 = r14.mContainerId
            if (r15 != r9) goto L9f
            if (r14 != r6) goto L72
            r13 = 1
            goto L9f
        L72:
            if (r14 != r3) goto L81
            java.util.ArrayList<androidx.fragment.app.r$a> r3 = r0.f2283c
            androidx.fragment.app.r$a r15 = new androidx.fragment.app.r$a
            r15.<init>(r11, r14)
            r3.add(r4, r15)
            int r4 = r4 + 1
            r3 = r7
        L81:
            androidx.fragment.app.r$a r15 = new androidx.fragment.app.r$a
            r15.<init>(r10, r14)
            int r2 = r5.f2302c
            r15.f2302c = r2
            int r2 = r5.f2304e
            r15.f2304e = r2
            int r2 = r5.f2303d
            r15.f2303d = r2
            int r2 = r5.f2305f
            r15.f2305f = r2
            java.util.ArrayList<androidx.fragment.app.r$a> r2 = r0.f2283c
            r2.add(r4, r15)
            r1.remove(r14)
            int r4 = r4 + r8
        L9f:
            int r12 = r12 + (-1)
            goto L62
        La2:
            if (r13 == 0) goto Lac
            java.util.ArrayList<androidx.fragment.app.r$a> r2 = r0.f2283c
            r2.remove(r4)
            int r4 = r4 + (-1)
            goto Lb7
        Lac:
            r5.f2300a = r8
            r1.add(r6)
            goto Lb7
        Lb2:
            androidx.fragment.app.Fragment r2 = r5.f2301b
            r1.add(r2)
        Lb7:
            int r4 = r4 + r8
            goto L7
        Lba:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.a.t(java.util.ArrayList, androidx.fragment.app.Fragment):androidx.fragment.app.Fragment");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f2172v >= 0) {
            sb.append(" #");
            sb.append(this.f2172v);
        }
        if (this.f2291k != null) {
            sb.append(" ");
            sb.append(this.f2291k);
        }
        sb.append("}");
        return sb.toString();
    }

    @Nullable
    public String u() {
        return this.f2291k;
    }

    boolean v(int i2) {
        int size = this.f2283c.size();
        for (int i3 = 0; i3 < size; i3++) {
            Fragment fragment = this.f2283c.get(i3).f2301b;
            int i4 = fragment != null ? fragment.mContainerId : 0;
            if (i4 != 0 && i4 == i2) {
                return true;
            }
        }
        return false;
    }

    boolean w(ArrayList<a> arrayList, int i2, int i3) {
        if (i3 == i2) {
            return false;
        }
        int size = this.f2283c.size();
        int i4 = -1;
        for (int i5 = 0; i5 < size; i5++) {
            Fragment fragment = this.f2283c.get(i5).f2301b;
            int i6 = fragment != null ? fragment.mContainerId : 0;
            if (i6 != 0 && i6 != i4) {
                for (int i7 = i2; i7 < i3; i7++) {
                    a aVar = arrayList.get(i7);
                    int size2 = aVar.f2283c.size();
                    for (int i8 = 0; i8 < size2; i8++) {
                        Fragment fragment2 = aVar.f2283c.get(i8).f2301b;
                        if ((fragment2 != null ? fragment2.mContainerId : 0) == i6) {
                            return true;
                        }
                    }
                }
                i4 = i6;
            }
        }
        return false;
    }

    boolean y() {
        for (int i2 = 0; i2 < this.f2283c.size(); i2++) {
            if (x(this.f2283c.get(i2))) {
                return true;
            }
        }
        return false;
    }

    public void z() {
        if (this.f2299s != null) {
            for (int i2 = 0; i2 < this.f2299s.size(); i2++) {
                this.f2299s.get(i2).run();
            }
            this.f2299s = null;
        }
    }
}
