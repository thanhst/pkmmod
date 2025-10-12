package androidx.fragment.app;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.core.view.j0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: FragmentTransition.java */
/* loaded from: classes.dex */
class s {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f2308a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};

    /* renamed from: b, reason: collision with root package name */
    static final z f2309b;

    /* renamed from: c, reason: collision with root package name */
    static final z f2310c;

    /* compiled from: FragmentTransition.java */
    class a implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ g f2311e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Fragment f2312f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ androidx.core.os.f f2313g;

        a(g gVar, Fragment fragment, androidx.core.os.f fVar) {
            this.f2311e = gVar;
            this.f2312f = fragment;
            this.f2313g = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2311e.a(this.f2312f, this.f2313g);
        }
    }

    /* compiled from: FragmentTransition.java */
    class b implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ArrayList f2314e;

        b(ArrayList arrayList) {
            this.f2314e = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            s.A(this.f2314e, 4);
        }
    }

    /* compiled from: FragmentTransition.java */
    class c implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ g f2315e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Fragment f2316f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ androidx.core.os.f f2317g;

        c(g gVar, Fragment fragment, androidx.core.os.f fVar) {
            this.f2315e = gVar;
            this.f2316f = fragment;
            this.f2317g = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2315e.a(this.f2316f, this.f2317g);
        }
    }

    /* compiled from: FragmentTransition.java */
    class d implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Object f2318e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ z f2319f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ View f2320g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Fragment f2321h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ ArrayList f2322i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ ArrayList f2323j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ ArrayList f2324k;

        /* renamed from: l, reason: collision with root package name */
        final /* synthetic */ Object f2325l;

        d(Object obj, z zVar, View view, Fragment fragment, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
            this.f2318e = obj;
            this.f2319f = zVar;
            this.f2320g = view;
            this.f2321h = fragment;
            this.f2322i = arrayList;
            this.f2323j = arrayList2;
            this.f2324k = arrayList3;
            this.f2325l = obj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj = this.f2318e;
            if (obj != null) {
                this.f2319f.p(obj, this.f2320g);
                this.f2323j.addAll(s.k(this.f2319f, this.f2318e, this.f2321h, this.f2322i, this.f2320g));
            }
            if (this.f2324k != null) {
                if (this.f2325l != null) {
                    ArrayList<View> arrayList = new ArrayList<>();
                    arrayList.add(this.f2320g);
                    this.f2319f.q(this.f2325l, this.f2324k, arrayList);
                }
                this.f2324k.clear();
                this.f2324k.add(this.f2320g);
            }
        }
    }

    /* compiled from: FragmentTransition.java */
    class e implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Fragment f2326e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Fragment f2327f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f2328g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ androidx.collection.a f2329h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ View f2330i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ z f2331j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ Rect f2332k;

        e(Fragment fragment, Fragment fragment2, boolean z2, androidx.collection.a aVar, View view, z zVar, Rect rect) {
            this.f2326e = fragment;
            this.f2327f = fragment2;
            this.f2328g = z2;
            this.f2329h = aVar;
            this.f2330i = view;
            this.f2331j = zVar;
            this.f2332k = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            s.f(this.f2326e, this.f2327f, this.f2328g, this.f2329h, false);
            View view = this.f2330i;
            if (view != null) {
                this.f2331j.k(view, this.f2332k);
            }
        }
    }

    /* compiled from: FragmentTransition.java */
    class f implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ z f2333e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ androidx.collection.a f2334f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Object f2335g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ h f2336h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ ArrayList f2337i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ View f2338j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ Fragment f2339k;

        /* renamed from: l, reason: collision with root package name */
        final /* synthetic */ Fragment f2340l;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ boolean f2341m;

        /* renamed from: n, reason: collision with root package name */
        final /* synthetic */ ArrayList f2342n;

        /* renamed from: o, reason: collision with root package name */
        final /* synthetic */ Object f2343o;

        /* renamed from: p, reason: collision with root package name */
        final /* synthetic */ Rect f2344p;

        f(z zVar, androidx.collection.a aVar, Object obj, h hVar, ArrayList arrayList, View view, Fragment fragment, Fragment fragment2, boolean z2, ArrayList arrayList2, Object obj2, Rect rect) {
            this.f2333e = zVar;
            this.f2334f = aVar;
            this.f2335g = obj;
            this.f2336h = hVar;
            this.f2337i = arrayList;
            this.f2338j = view;
            this.f2339k = fragment;
            this.f2340l = fragment2;
            this.f2341m = z2;
            this.f2342n = arrayList2;
            this.f2343o = obj2;
            this.f2344p = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx.collection.a<String, View> aVarH = s.h(this.f2333e, this.f2334f, this.f2335g, this.f2336h);
            if (aVarH != null) {
                this.f2337i.addAll(aVarH.values());
                this.f2337i.add(this.f2338j);
            }
            s.f(this.f2339k, this.f2340l, this.f2341m, aVarH, false);
            Object obj = this.f2335g;
            if (obj != null) {
                this.f2333e.A(obj, this.f2342n, this.f2337i);
                View viewS = s.s(aVarH, this.f2336h, this.f2343o, this.f2341m);
                if (viewS != null) {
                    this.f2333e.k(viewS, this.f2344p);
                }
            }
        }
    }

    /* compiled from: FragmentTransition.java */
    interface g {
        void a(@NonNull Fragment fragment, @NonNull androidx.core.os.f fVar);

        void b(@NonNull Fragment fragment, @NonNull androidx.core.os.f fVar);
    }

    /* compiled from: FragmentTransition.java */
    static class h {

        /* renamed from: a, reason: collision with root package name */
        public Fragment f2345a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f2346b;

        /* renamed from: c, reason: collision with root package name */
        public androidx.fragment.app.a f2347c;

        /* renamed from: d, reason: collision with root package name */
        public Fragment f2348d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f2349e;

        /* renamed from: f, reason: collision with root package name */
        public androidx.fragment.app.a f2350f;

        h() {
        }
    }

    static {
        f2309b = Build.VERSION.SDK_INT >= 21 ? new y() : null;
        f2310c = w();
    }

    static void A(ArrayList<View> arrayList, int i2) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            arrayList.get(size).setVisibility(i2);
        }
    }

    static void B(@NonNull Context context, @NonNull androidx.fragment.app.e eVar, ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3, boolean z2, g gVar) {
        ViewGroup viewGroup;
        SparseArray sparseArray = new SparseArray();
        for (int i4 = i2; i4 < i3; i4++) {
            androidx.fragment.app.a aVar = arrayList.get(i4);
            if (arrayList2.get(i4).booleanValue()) {
                e(aVar, sparseArray, z2);
            } else {
                c(aVar, sparseArray, z2);
            }
        }
        if (sparseArray.size() != 0) {
            View view = new View(context);
            int size = sparseArray.size();
            for (int i5 = 0; i5 < size; i5++) {
                int iKeyAt = sparseArray.keyAt(i5);
                androidx.collection.a<String, String> aVarD = d(iKeyAt, arrayList, arrayList2, i2, i3);
                h hVar = (h) sparseArray.valueAt(i5);
                if (eVar.d() && (viewGroup = (ViewGroup) eVar.c(iKeyAt)) != null) {
                    if (z2) {
                        o(viewGroup, hVar, view, aVarD, gVar);
                    } else {
                        n(viewGroup, hVar, view, aVarD, gVar);
                    }
                }
            }
        }
    }

    private static void a(ArrayList<View> arrayList, androidx.collection.a<String, View> aVar, Collection<String> collection) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View viewValueAt = aVar.valueAt(size);
            if (collection.contains(ViewCompat.w(viewValueAt))) {
                arrayList.add(viewValueAt);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(androidx.fragment.app.a r8, androidx.fragment.app.r.a r9, android.util.SparseArray<androidx.fragment.app.s.h> r10, boolean r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 228
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.s.b(androidx.fragment.app.a, androidx.fragment.app.r$a, android.util.SparseArray, boolean, boolean):void");
    }

    public static void c(androidx.fragment.app.a aVar, SparseArray<h> sparseArray, boolean z2) {
        int size = aVar.f2283c.size();
        for (int i2 = 0; i2 < size; i2++) {
            b(aVar, aVar.f2283c.get(i2), sparseArray, false, z2);
        }
    }

    private static androidx.collection.a<String, String> d(int i2, ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i3, int i4) {
        ArrayList<String> arrayList3;
        ArrayList<String> arrayList4;
        androidx.collection.a<String, String> aVar = new androidx.collection.a<>();
        for (int i5 = i4 - 1; i5 >= i3; i5--) {
            androidx.fragment.app.a aVar2 = arrayList.get(i5);
            if (aVar2.v(i2)) {
                boolean zBooleanValue = arrayList2.get(i5).booleanValue();
                ArrayList<String> arrayList5 = aVar2.f2296p;
                if (arrayList5 != null) {
                    int size = arrayList5.size();
                    if (zBooleanValue) {
                        arrayList3 = aVar2.f2296p;
                        arrayList4 = aVar2.f2297q;
                    } else {
                        ArrayList<String> arrayList6 = aVar2.f2296p;
                        arrayList3 = aVar2.f2297q;
                        arrayList4 = arrayList6;
                    }
                    for (int i6 = 0; i6 < size; i6++) {
                        String str = arrayList4.get(i6);
                        String str2 = arrayList3.get(i6);
                        String strRemove = aVar.remove(str2);
                        if (strRemove != null) {
                            aVar.put(str, strRemove);
                        } else {
                            aVar.put(str, str2);
                        }
                    }
                }
            }
        }
        return aVar;
    }

    public static void e(androidx.fragment.app.a aVar, SparseArray<h> sparseArray, boolean z2) {
        if (aVar.f2170t.o0().d()) {
            for (int size = aVar.f2283c.size() - 1; size >= 0; size--) {
                b(aVar, aVar.f2283c.get(size), sparseArray, true, z2);
            }
        }
    }

    static void f(Fragment fragment, Fragment fragment2, boolean z2, androidx.collection.a<String, View> aVar, boolean z3) {
        if (z2) {
            fragment2.getEnterTransitionCallback();
        } else {
            fragment.getEnterTransitionCallback();
        }
    }

    private static boolean g(z zVar, List<Object> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!zVar.e(list.get(i2))) {
                return false;
            }
        }
        return true;
    }

    static androidx.collection.a<String, View> h(z zVar, androidx.collection.a<String, String> aVar, Object obj, h hVar) {
        ArrayList<String> arrayList;
        Fragment fragment = hVar.f2345a;
        View view = fragment.getView();
        if (aVar.isEmpty() || obj == null || view == null) {
            aVar.clear();
            return null;
        }
        androidx.collection.a<String, View> aVar2 = new androidx.collection.a<>();
        zVar.j(aVar2, view);
        androidx.fragment.app.a aVar3 = hVar.f2347c;
        if (hVar.f2346b) {
            fragment.getExitTransitionCallback();
            arrayList = aVar3.f2296p;
        } else {
            fragment.getEnterTransitionCallback();
            arrayList = aVar3.f2297q;
        }
        if (arrayList != null) {
            aVar2.retainAll(arrayList);
            aVar2.retainAll(aVar.values());
        }
        x(aVar, aVar2);
        return aVar2;
    }

    private static androidx.collection.a<String, View> i(z zVar, androidx.collection.a<String, String> aVar, Object obj, h hVar) {
        ArrayList<String> arrayList;
        if (aVar.isEmpty() || obj == null) {
            aVar.clear();
            return null;
        }
        Fragment fragment = hVar.f2348d;
        androidx.collection.a<String, View> aVar2 = new androidx.collection.a<>();
        zVar.j(aVar2, fragment.requireView());
        androidx.fragment.app.a aVar3 = hVar.f2350f;
        if (hVar.f2349e) {
            fragment.getEnterTransitionCallback();
            arrayList = aVar3.f2297q;
        } else {
            fragment.getExitTransitionCallback();
            arrayList = aVar3.f2296p;
        }
        if (arrayList != null) {
            aVar2.retainAll(arrayList);
        }
        aVar.retainAll(aVar2.keySet());
        return aVar2;
    }

    private static z j(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object exitTransition = fragment.getExitTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
            Object returnTransition = fragment.getReturnTransition();
            if (returnTransition != null) {
                arrayList.add(returnTransition);
            }
            Object sharedElementReturnTransition = fragment.getSharedElementReturnTransition();
            if (sharedElementReturnTransition != null) {
                arrayList.add(sharedElementReturnTransition);
            }
        }
        if (fragment2 != null) {
            Object enterTransition = fragment2.getEnterTransition();
            if (enterTransition != null) {
                arrayList.add(enterTransition);
            }
            Object reenterTransition = fragment2.getReenterTransition();
            if (reenterTransition != null) {
                arrayList.add(reenterTransition);
            }
            Object sharedElementEnterTransition = fragment2.getSharedElementEnterTransition();
            if (sharedElementEnterTransition != null) {
                arrayList.add(sharedElementEnterTransition);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        z zVar = f2309b;
        if (zVar != null && g(zVar, arrayList)) {
            return zVar;
        }
        z zVar2 = f2310c;
        if (zVar2 != null && g(zVar2, arrayList)) {
            return zVar2;
        }
        if (zVar == null && zVar2 == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    static ArrayList<View> k(z zVar, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        View view2 = fragment.getView();
        if (view2 != null) {
            zVar.f(arrayList2, view2);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        zVar.b(obj, arrayList2);
        return arrayList2;
    }

    private static Object l(z zVar, ViewGroup viewGroup, View view, androidx.collection.a<String, String> aVar, h hVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object objT;
        androidx.collection.a<String, String> aVar2;
        Object obj3;
        Rect rect;
        Fragment fragment = hVar.f2345a;
        Fragment fragment2 = hVar.f2348d;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z2 = hVar.f2346b;
        if (aVar.isEmpty()) {
            aVar2 = aVar;
            objT = null;
        } else {
            objT = t(zVar, fragment, fragment2, z2);
            aVar2 = aVar;
        }
        androidx.collection.a<String, View> aVarI = i(zVar, aVar2, objT, hVar);
        if (aVar.isEmpty()) {
            obj3 = null;
        } else {
            arrayList.addAll(aVarI.values());
            obj3 = objT;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        f(fragment, fragment2, z2, aVarI, true);
        if (obj3 != null) {
            rect = new Rect();
            zVar.z(obj3, view, arrayList);
            z(zVar, obj3, obj2, aVarI, hVar.f2349e, hVar.f2350f);
            if (obj != null) {
                zVar.u(obj, rect);
            }
        } else {
            rect = null;
        }
        j0.a(viewGroup, new f(zVar, aVar, obj3, hVar, arrayList2, view, fragment, fragment2, z2, arrayList, obj, rect));
        return obj3;
    }

    private static Object m(z zVar, ViewGroup viewGroup, View view, androidx.collection.a<String, String> aVar, h hVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        View view2;
        Rect rect;
        Fragment fragment = hVar.f2345a;
        Fragment fragment2 = hVar.f2348d;
        if (fragment != null) {
            fragment.requireView().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z2 = hVar.f2346b;
        Object objT = aVar.isEmpty() ? null : t(zVar, fragment, fragment2, z2);
        androidx.collection.a<String, View> aVarI = i(zVar, aVar, objT, hVar);
        androidx.collection.a<String, View> aVarH = h(zVar, aVar, objT, hVar);
        if (aVar.isEmpty()) {
            if (aVarI != null) {
                aVarI.clear();
            }
            if (aVarH != null) {
                aVarH.clear();
            }
            obj3 = null;
        } else {
            a(arrayList, aVarI, aVar.keySet());
            a(arrayList2, aVarH, aVar.values());
            obj3 = objT;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        f(fragment, fragment2, z2, aVarI, true);
        if (obj3 != null) {
            arrayList2.add(view);
            zVar.z(obj3, view, arrayList);
            z(zVar, obj3, obj2, aVarI, hVar.f2349e, hVar.f2350f);
            Rect rect2 = new Rect();
            View viewS = s(aVarH, hVar, obj, z2);
            if (viewS != null) {
                zVar.u(obj, rect2);
            }
            rect = rect2;
            view2 = viewS;
        } else {
            view2 = null;
            rect = null;
        }
        j0.a(viewGroup, new e(fragment, fragment2, z2, aVarH, view2, zVar, rect));
        return obj3;
    }

    private static void n(@NonNull ViewGroup viewGroup, h hVar, View view, androidx.collection.a<String, String> aVar, g gVar) {
        Object obj;
        Fragment fragment = hVar.f2345a;
        Fragment fragment2 = hVar.f2348d;
        z zVarJ = j(fragment2, fragment);
        if (zVarJ == null) {
            return;
        }
        boolean z2 = hVar.f2346b;
        boolean z3 = hVar.f2349e;
        Object objQ = q(zVarJ, fragment, z2);
        Object objR = r(zVarJ, fragment2, z3);
        ArrayList arrayList = new ArrayList();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object objL = l(zVarJ, viewGroup, view, aVar, hVar, arrayList, arrayList2, objQ, objR);
        if (objQ == null && objL == null) {
            obj = objR;
            if (obj == null) {
                return;
            }
        } else {
            obj = objR;
        }
        ArrayList<View> arrayListK = k(zVarJ, obj, fragment2, arrayList, view);
        if (arrayListK == null || arrayListK.isEmpty()) {
            obj = null;
        }
        Object obj2 = obj;
        zVarJ.a(objQ, view);
        Object objU = u(zVarJ, objQ, obj2, objL, fragment, hVar.f2346b);
        if (fragment2 != null && arrayListK != null && (arrayListK.size() > 0 || arrayList.size() > 0)) {
            androidx.core.os.f fVar = new androidx.core.os.f();
            gVar.b(fragment2, fVar);
            zVarJ.w(fragment2, objU, fVar, new c(gVar, fragment2, fVar));
        }
        if (objU != null) {
            ArrayList<View> arrayList3 = new ArrayList<>();
            zVarJ.t(objU, objQ, arrayList3, obj2, arrayListK, objL, arrayList2);
            y(zVarJ, viewGroup, fragment, view, arrayList2, objQ, arrayList3, obj2, arrayListK);
            zVarJ.x(viewGroup, arrayList2, aVar);
            zVarJ.c(viewGroup, objU);
            zVarJ.s(viewGroup, arrayList2, aVar);
        }
    }

    private static void o(@NonNull ViewGroup viewGroup, h hVar, View view, androidx.collection.a<String, String> aVar, g gVar) {
        Object obj;
        Fragment fragment = hVar.f2345a;
        Fragment fragment2 = hVar.f2348d;
        z zVarJ = j(fragment2, fragment);
        if (zVarJ == null) {
            return;
        }
        boolean z2 = hVar.f2346b;
        boolean z3 = hVar.f2349e;
        ArrayList<View> arrayList = new ArrayList<>();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object objQ = q(zVarJ, fragment, z2);
        Object objR = r(zVarJ, fragment2, z3);
        Object objM = m(zVarJ, viewGroup, view, aVar, hVar, arrayList2, arrayList, objQ, objR);
        if (objQ == null && objM == null) {
            obj = objR;
            if (obj == null) {
                return;
            }
        } else {
            obj = objR;
        }
        ArrayList<View> arrayListK = k(zVarJ, obj, fragment2, arrayList2, view);
        ArrayList<View> arrayListK2 = k(zVarJ, objQ, fragment, arrayList, view);
        A(arrayListK2, 4);
        Object objU = u(zVarJ, objQ, obj, objM, fragment, z2);
        if (fragment2 != null && arrayListK != null && (arrayListK.size() > 0 || arrayList2.size() > 0)) {
            androidx.core.os.f fVar = new androidx.core.os.f();
            gVar.b(fragment2, fVar);
            zVarJ.w(fragment2, objU, fVar, new a(gVar, fragment2, fVar));
        }
        if (objU != null) {
            v(zVarJ, obj, fragment2, arrayListK);
            ArrayList<String> arrayListO = zVarJ.o(arrayList);
            zVarJ.t(objU, objQ, arrayListK2, obj, arrayListK, objM, arrayList);
            zVarJ.c(viewGroup, objU);
            zVarJ.y(viewGroup, arrayList2, arrayList, arrayListO, aVar);
            A(arrayListK2, 0);
            zVarJ.A(objM, arrayList2, arrayList);
        }
    }

    private static h p(h hVar, SparseArray<h> sparseArray, int i2) {
        if (hVar != null) {
            return hVar;
        }
        h hVar2 = new h();
        sparseArray.put(i2, hVar2);
        return hVar2;
    }

    private static Object q(z zVar, Fragment fragment, boolean z2) {
        if (fragment == null) {
            return null;
        }
        return zVar.g(z2 ? fragment.getReenterTransition() : fragment.getEnterTransition());
    }

    private static Object r(z zVar, Fragment fragment, boolean z2) {
        if (fragment == null) {
            return null;
        }
        return zVar.g(z2 ? fragment.getReturnTransition() : fragment.getExitTransition());
    }

    static View s(androidx.collection.a<String, View> aVar, h hVar, Object obj, boolean z2) {
        ArrayList<String> arrayList;
        androidx.fragment.app.a aVar2 = hVar.f2347c;
        if (obj == null || aVar == null || (arrayList = aVar2.f2296p) == null || arrayList.isEmpty()) {
            return null;
        }
        return aVar.get(z2 ? aVar2.f2296p.get(0) : aVar2.f2297q.get(0));
    }

    private static Object t(z zVar, Fragment fragment, Fragment fragment2, boolean z2) {
        if (fragment == null || fragment2 == null) {
            return null;
        }
        return zVar.B(zVar.g(z2 ? fragment2.getSharedElementReturnTransition() : fragment.getSharedElementEnterTransition()));
    }

    private static Object u(z zVar, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z2) {
        return (obj == null || obj2 == null || fragment == null) ? true : z2 ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap() ? zVar.n(obj2, obj, obj3) : zVar.m(obj2, obj, obj3);
    }

    private static void v(z zVar, Object obj, Fragment fragment, ArrayList<View> arrayList) {
        if (fragment != null && obj != null && fragment.mAdded && fragment.mHidden && fragment.mHiddenChanged) {
            fragment.setHideReplaced(true);
            zVar.r(obj, fragment.getView(), arrayList);
            j0.a(fragment.mContainer, new b(arrayList));
        }
    }

    private static z w() {
        try {
            return (z) Class.forName("androidx.transition.FragmentTransitionSupport").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static void x(@NonNull androidx.collection.a<String, String> aVar, @NonNull androidx.collection.a<String, View> aVar2) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            if (!aVar2.containsKey(aVar.valueAt(size))) {
                aVar.removeAt(size);
            }
        }
    }

    private static void y(z zVar, ViewGroup viewGroup, Fragment fragment, View view, ArrayList<View> arrayList, Object obj, ArrayList<View> arrayList2, Object obj2, ArrayList<View> arrayList3) {
        j0.a(viewGroup, new d(obj, zVar, view, fragment, arrayList, arrayList2, arrayList3, obj2));
    }

    private static void z(z zVar, Object obj, Object obj2, androidx.collection.a<String, View> aVar, boolean z2, androidx.fragment.app.a aVar2) {
        ArrayList<String> arrayList = aVar2.f2296p;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        View view = aVar.get(z2 ? aVar2.f2297q.get(0) : aVar2.f2296p.get(0));
        zVar.v(obj, view);
        if (obj2 != null) {
            zVar.v(obj2, view);
        }
    }
}
