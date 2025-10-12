package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import androidx.core.view.j0;
import androidx.core.view.o2;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: FragmentTransitionImpl.java */
@SuppressLint({"UnknownNullness"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public abstract class z {

    /* compiled from: FragmentTransitionImpl.java */
    class a implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f2367e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ArrayList f2368f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ ArrayList f2369g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ ArrayList f2370h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ ArrayList f2371i;

        a(int i2, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
            this.f2367e = i2;
            this.f2368f = arrayList;
            this.f2369g = arrayList2;
            this.f2370h = arrayList3;
            this.f2371i = arrayList4;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i2 = 0; i2 < this.f2367e; i2++) {
                ViewCompat.Z((View) this.f2368f.get(i2), (String) this.f2369g.get(i2));
                ViewCompat.Z((View) this.f2370h.get(i2), (String) this.f2371i.get(i2));
            }
        }
    }

    /* compiled from: FragmentTransitionImpl.java */
    class b implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ArrayList f2373e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Map f2374f;

        b(ArrayList arrayList, Map map) {
            this.f2373e = arrayList;
            this.f2374f = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.f2373e.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = (View) this.f2373e.get(i2);
                String strW = ViewCompat.w(view);
                if (strW != null) {
                    ViewCompat.Z(view, z.i(this.f2374f, strW));
                }
            }
        }
    }

    /* compiled from: FragmentTransitionImpl.java */
    class c implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ArrayList f2376e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Map f2377f;

        c(ArrayList arrayList, Map map) {
            this.f2376e = arrayList;
            this.f2377f = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.f2376e.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = (View) this.f2376e.get(i2);
                ViewCompat.Z(view, (String) this.f2377f.get(ViewCompat.w(view)));
            }
        }
    }

    protected static void d(List<View> list, View view) {
        int size = list.size();
        if (h(list, view, size)) {
            return;
        }
        if (ViewCompat.w(view) != null) {
            list.add(view);
        }
        for (int i2 = size; i2 < list.size(); i2++) {
            View view2 = list.get(i2);
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = viewGroup.getChildAt(i3);
                    if (!h(list, childAt, size) && ViewCompat.w(childAt) != null) {
                        list.add(childAt);
                    }
                }
            }
        }
    }

    private static boolean h(List<View> list, View view, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            if (list.get(i3) == view) {
                return true;
            }
        }
        return false;
    }

    static String i(Map<String, String> map, String str) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (str.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    protected static boolean l(List list) {
        return list == null || list.isEmpty();
    }

    public abstract void A(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract Object B(Object obj);

    public abstract void a(Object obj, View view);

    public abstract void b(Object obj, ArrayList<View> arrayList);

    public abstract void c(ViewGroup viewGroup, Object obj);

    public abstract boolean e(Object obj);

    void f(ArrayList<View> arrayList, View view) {
        if (view.getVisibility() == 0) {
            if (!(view instanceof ViewGroup)) {
                arrayList.add(view);
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            if (o2.a(viewGroup)) {
                arrayList.add(viewGroup);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                f(arrayList, viewGroup.getChildAt(i2));
            }
        }
    }

    public abstract Object g(Object obj);

    void j(Map<String, View> map, @NonNull View view) {
        if (view.getVisibility() == 0) {
            String strW = ViewCompat.w(view);
            if (strW != null) {
                map.put(strW, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    j(map, viewGroup.getChildAt(i2));
                }
            }
        }
    }

    protected void k(View view, Rect rect) {
        if (ViewCompat.A(view)) {
            RectF rectF = new RectF();
            rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
            view.getMatrix().mapRect(rectF);
            rectF.offset(view.getLeft(), view.getTop());
            Object parent = view.getParent();
            while (parent instanceof View) {
                View view2 = (View) parent;
                rectF.offset(-view2.getScrollX(), -view2.getScrollY());
                view2.getMatrix().mapRect(rectF);
                rectF.offset(view2.getLeft(), view2.getTop());
                parent = view2.getParent();
            }
            view.getRootView().getLocationOnScreen(new int[2]);
            rectF.offset(r1[0], r1[1]);
            rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
        }
    }

    public abstract Object m(Object obj, Object obj2, Object obj3);

    public abstract Object n(Object obj, Object obj2, Object obj3);

    ArrayList<String> o(ArrayList<View> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = arrayList.get(i2);
            arrayList2.add(ViewCompat.w(view));
            ViewCompat.Z(view, null);
        }
        return arrayList2;
    }

    public abstract void p(Object obj, View view);

    public abstract void q(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract void r(Object obj, View view, ArrayList<View> arrayList);

    void s(ViewGroup viewGroup, ArrayList<View> arrayList, Map<String, String> map) {
        j0.a(viewGroup, new c(arrayList, map));
    }

    public abstract void t(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3);

    public abstract void u(Object obj, Rect rect);

    public abstract void v(Object obj, View view);

    public void w(@NonNull Fragment fragment, @NonNull Object obj, @NonNull androidx.core.os.f fVar, @NonNull Runnable runnable) {
        runnable.run();
    }

    void x(View view, ArrayList<View> arrayList, Map<String, String> map) {
        j0.a(view, new b(arrayList, map));
    }

    void y(View view, ArrayList<View> arrayList, ArrayList<View> arrayList2, ArrayList<String> arrayList3, Map<String, String> map) {
        int size = arrayList2.size();
        ArrayList arrayList4 = new ArrayList();
        for (int i2 = 0; i2 < size; i2++) {
            View view2 = arrayList.get(i2);
            String strW = ViewCompat.w(view2);
            arrayList4.add(strW);
            if (strW != null) {
                ViewCompat.Z(view2, null);
                String str = map.get(strW);
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        break;
                    }
                    if (str.equals(arrayList3.get(i3))) {
                        ViewCompat.Z(arrayList2.get(i3), strW);
                        break;
                    }
                    i3++;
                }
            }
        }
        j0.a(view, new a(size, arrayList2, arrayList3, arrayList, arrayList4));
    }

    public abstract void z(Object obj, View view, ArrayList<View> arrayList);
}
