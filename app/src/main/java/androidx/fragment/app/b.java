package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.os.f;
import androidx.core.view.ViewCompat;
import androidx.core.view.j0;
import androidx.core.view.o2;
import androidx.fragment.app.SpecialEffectsController;
import androidx.fragment.app.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: DefaultSpecialEffectsController.java */
/* loaded from: classes.dex */
class b extends SpecialEffectsController {

    /* compiled from: DefaultSpecialEffectsController.java */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2177a;

        static {
            int[] iArr = new int[SpecialEffectsController.Operation.State.values().length];
            f2177a = iArr;
            try {
                iArr[SpecialEffectsController.Operation.State.GONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2177a[SpecialEffectsController.Operation.State.INVISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2177a[SpecialEffectsController.Operation.State.REMOVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2177a[SpecialEffectsController.Operation.State.VISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    /* renamed from: androidx.fragment.app.b$b, reason: collision with other inner class name */
    class RunnableC0028b implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ List f2178e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ SpecialEffectsController.Operation f2179f;

        RunnableC0028b(List list, SpecialEffectsController.Operation operation) {
            this.f2178e = list;
            this.f2179f = operation;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f2178e.contains(this.f2179f)) {
                this.f2178e.remove(this.f2179f);
                b.this.s(this.f2179f);
            }
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    class c extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f2181a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f2182b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f2183c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ SpecialEffectsController.Operation f2184d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ k f2185e;

        c(ViewGroup viewGroup, View view, boolean z2, SpecialEffectsController.Operation operation, k kVar) {
            this.f2181a = viewGroup;
            this.f2182b = view;
            this.f2183c = z2;
            this.f2184d = operation;
            this.f2185e = kVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f2181a.endViewTransition(this.f2182b);
            if (this.f2183c) {
                this.f2184d.e().applyState(this.f2182b);
            }
            this.f2185e.a();
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    class d implements f.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Animator f2187a;

        d(Animator animator) {
            this.f2187a = animator;
        }

        @Override // androidx.core.os.f.b
        public void onCancel() {
            this.f2187a.end();
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    class e implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f2189a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f2190b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ k f2191c;

        /* compiled from: DefaultSpecialEffectsController.java */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e eVar = e.this;
                eVar.f2189a.endViewTransition(eVar.f2190b);
                e.this.f2191c.a();
            }
        }

        e(ViewGroup viewGroup, View view, k kVar) {
            this.f2189a = viewGroup;
            this.f2190b = view;
            this.f2191c = kVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f2189a.post(new a());
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    class f implements f.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f2194a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewGroup f2195b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ k f2196c;

        f(View view, ViewGroup viewGroup, k kVar) {
            this.f2194a = view;
            this.f2195b = viewGroup;
            this.f2196c = kVar;
        }

        @Override // androidx.core.os.f.b
        public void onCancel() {
            this.f2194a.clearAnimation();
            this.f2195b.endViewTransition(this.f2194a);
            this.f2196c.a();
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    class g implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ SpecialEffectsController.Operation f2198e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ SpecialEffectsController.Operation f2199f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f2200g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ androidx.collection.a f2201h;

        g(SpecialEffectsController.Operation operation, SpecialEffectsController.Operation operation2, boolean z2, androidx.collection.a aVar) {
            this.f2198e = operation;
            this.f2199f = operation2;
            this.f2200g = z2;
            this.f2201h = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            s.f(this.f2198e.f(), this.f2199f.f(), this.f2200g, this.f2201h, false);
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    class h implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ z f2203e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f2204f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Rect f2205g;

        h(z zVar, View view, Rect rect) {
            this.f2203e = zVar;
            this.f2204f = view;
            this.f2205g = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2203e.k(this.f2204f, this.f2205g);
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    class i implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ArrayList f2207e;

        i(ArrayList arrayList) {
            this.f2207e = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            s.A(this.f2207e, 4);
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    class j implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ m f2209e;

        j(m mVar) {
            this.f2209e = mVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2209e.a();
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    private static class k extends l {

        /* renamed from: c, reason: collision with root package name */
        private boolean f2211c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f2212d;

        /* renamed from: e, reason: collision with root package name */
        @Nullable
        private d.C0030d f2213e;

        k(@NonNull SpecialEffectsController.Operation operation, @NonNull androidx.core.os.f fVar, boolean z2) {
            super(operation, fVar);
            this.f2212d = false;
            this.f2211c = z2;
        }

        @Nullable
        d.C0030d e(@NonNull Context context) {
            if (this.f2212d) {
                return this.f2213e;
            }
            d.C0030d c0030dC = androidx.fragment.app.d.c(context, b().f(), b().e() == SpecialEffectsController.Operation.State.VISIBLE, this.f2211c);
            this.f2213e = c0030dC;
            this.f2212d = true;
            return c0030dC;
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    private static class l {

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        private final SpecialEffectsController.Operation f2214a;

        /* renamed from: b, reason: collision with root package name */
        @NonNull
        private final androidx.core.os.f f2215b;

        l(@NonNull SpecialEffectsController.Operation operation, @NonNull androidx.core.os.f fVar) {
            this.f2214a = operation;
            this.f2215b = fVar;
        }

        void a() {
            this.f2214a.d(this.f2215b);
        }

        @NonNull
        SpecialEffectsController.Operation b() {
            return this.f2214a;
        }

        @NonNull
        androidx.core.os.f c() {
            return this.f2215b;
        }

        boolean d() {
            SpecialEffectsController.Operation.State state;
            SpecialEffectsController.Operation.State stateFrom = SpecialEffectsController.Operation.State.from(this.f2214a.f().mView);
            SpecialEffectsController.Operation.State stateE = this.f2214a.e();
            return stateFrom == stateE || !(stateFrom == (state = SpecialEffectsController.Operation.State.VISIBLE) || stateE == state);
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    private static class m extends l {

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        private final Object f2216c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f2217d;

        /* renamed from: e, reason: collision with root package name */
        @Nullable
        private final Object f2218e;

        m(@NonNull SpecialEffectsController.Operation operation, @NonNull androidx.core.os.f fVar, boolean z2, boolean z3) {
            super(operation, fVar);
            if (operation.e() == SpecialEffectsController.Operation.State.VISIBLE) {
                this.f2216c = z2 ? operation.f().getReenterTransition() : operation.f().getEnterTransition();
                this.f2217d = z2 ? operation.f().getAllowReturnTransitionOverlap() : operation.f().getAllowEnterTransitionOverlap();
            } else {
                this.f2216c = z2 ? operation.f().getReturnTransition() : operation.f().getExitTransition();
                this.f2217d = true;
            }
            if (!z3) {
                this.f2218e = null;
            } else if (z2) {
                this.f2218e = operation.f().getSharedElementReturnTransition();
            } else {
                this.f2218e = operation.f().getSharedElementEnterTransition();
            }
        }

        @Nullable
        private z f(Object obj) {
            if (obj == null) {
                return null;
            }
            z zVar = s.f2309b;
            if (zVar != null && zVar.e(obj)) {
                return zVar;
            }
            z zVar2 = s.f2310c;
            if (zVar2 != null && zVar2.e(obj)) {
                return zVar2;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + b().f() + " is not a valid framework Transition or AndroidX Transition");
        }

        @Nullable
        z e() {
            z zVarF = f(this.f2216c);
            z zVarF2 = f(this.f2218e);
            if (zVarF == null || zVarF2 == null || zVarF == zVarF2) {
                return zVarF != null ? zVarF : zVarF2;
            }
            throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + b().f() + " returned Transition " + this.f2216c + " which uses a different Transition  type than its shared element transition " + this.f2218e);
        }

        @Nullable
        public Object g() {
            return this.f2218e;
        }

        @Nullable
        Object h() {
            return this.f2216c;
        }

        public boolean i() {
            return this.f2218e != null;
        }

        boolean j() {
            return this.f2217d;
        }
    }

    b(@NonNull ViewGroup viewGroup) {
        super(viewGroup);
    }

    private void w(@NonNull List<k> list, @NonNull List<SpecialEffectsController.Operation> list2, boolean z2, @NonNull Map<SpecialEffectsController.Operation, Boolean> map) {
        ViewGroup viewGroupM = m();
        Context context = viewGroupM.getContext();
        ArrayList arrayList = new ArrayList();
        boolean z3 = false;
        for (k kVar : list) {
            if (kVar.d()) {
                kVar.a();
            } else {
                d.C0030d c0030dE = kVar.e(context);
                if (c0030dE == null) {
                    kVar.a();
                } else {
                    Animator animator = c0030dE.f2239b;
                    if (animator == null) {
                        arrayList.add(kVar);
                    } else {
                        SpecialEffectsController.Operation operationB = kVar.b();
                        Fragment fragmentF = operationB.f();
                        if (Boolean.TRUE.equals(map.get(operationB))) {
                            if (FragmentManager.F0(2)) {
                                Log.v("FragmentManager", "Ignoring Animator set on " + fragmentF + " as this Fragment was involved in a Transition.");
                            }
                            kVar.a();
                        } else {
                            boolean z4 = operationB.e() == SpecialEffectsController.Operation.State.GONE;
                            if (z4) {
                                list2.remove(operationB);
                            }
                            View view = fragmentF.mView;
                            viewGroupM.startViewTransition(view);
                            animator.addListener(new c(viewGroupM, view, z4, operationB, kVar));
                            animator.setTarget(view);
                            animator.start();
                            kVar.c().c(new d(animator));
                            z3 = true;
                        }
                    }
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            k kVar2 = (k) it.next();
            SpecialEffectsController.Operation operationB2 = kVar2.b();
            Fragment fragmentF2 = operationB2.f();
            if (z2) {
                if (FragmentManager.F0(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + fragmentF2 + " as Animations cannot run alongside Transitions.");
                }
                kVar2.a();
            } else if (z3) {
                if (FragmentManager.F0(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + fragmentF2 + " as Animations cannot run alongside Animators.");
                }
                kVar2.a();
            } else {
                View view2 = fragmentF2.mView;
                Animation animation = (Animation) androidx.core.util.h.f(((d.C0030d) androidx.core.util.h.f(kVar2.e(context))).f2238a);
                if (operationB2.e() != SpecialEffectsController.Operation.State.REMOVED) {
                    view2.startAnimation(animation);
                    kVar2.a();
                } else {
                    viewGroupM.startViewTransition(view2);
                    d.e eVar = new d.e(animation, viewGroupM, view2);
                    eVar.setAnimationListener(new e(viewGroupM, view2, kVar2));
                    view2.startAnimation(eVar);
                }
                kVar2.c().c(new f(view2, viewGroupM, kVar2));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    private Map<SpecialEffectsController.Operation, Boolean> x(@NonNull List<m> list, @NonNull List<SpecialEffectsController.Operation> list2, boolean z2, @Nullable SpecialEffectsController.Operation operation, @Nullable SpecialEffectsController.Operation operation2) {
        View view;
        Object obj;
        ArrayList<View> arrayList;
        Object obj2;
        ArrayList<View> arrayList2;
        SpecialEffectsController.Operation operation3;
        SpecialEffectsController.Operation operation4;
        View view2;
        Object objN;
        androidx.collection.a aVar;
        ArrayList<View> arrayList3;
        SpecialEffectsController.Operation operation5;
        ArrayList<View> arrayList4;
        Rect rect;
        View view3;
        z zVar;
        SpecialEffectsController.Operation operation6;
        View view4;
        boolean z3 = z2;
        SpecialEffectsController.Operation operation7 = operation;
        SpecialEffectsController.Operation operation8 = operation2;
        HashMap map = new HashMap();
        z zVar2 = null;
        for (m mVar : list) {
            if (!mVar.d()) {
                z zVarE = mVar.e();
                if (zVar2 == null) {
                    zVar2 = zVarE;
                } else if (zVarE != null && zVar2 != zVarE) {
                    throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + mVar.b().f() + " returned Transition " + mVar.h() + " which uses a different Transition  type than other Fragments.");
                }
            }
        }
        if (zVar2 == null) {
            for (m mVar2 : list) {
                map.put(mVar2.b(), Boolean.FALSE);
                mVar2.a();
            }
            return map;
        }
        View view5 = new View(m().getContext());
        Rect rect2 = new Rect();
        ArrayList<View> arrayList5 = new ArrayList<>();
        ArrayList<View> arrayList6 = new ArrayList<>();
        androidx.collection.a aVar2 = new androidx.collection.a();
        Object obj3 = null;
        View view6 = null;
        boolean z4 = false;
        for (m mVar3 : list) {
            if (!mVar3.i() || operation7 == null || operation8 == null) {
                aVar = aVar2;
                arrayList3 = arrayList6;
                operation5 = operation7;
                arrayList4 = arrayList5;
                rect = rect2;
                view3 = view5;
                zVar = zVar2;
                operation6 = operation8;
                view6 = view6;
            } else {
                Object objB = zVar2.B(zVar2.g(mVar3.g()));
                ArrayList<String> sharedElementSourceNames = operation2.f().getSharedElementSourceNames();
                ArrayList<String> sharedElementSourceNames2 = operation.f().getSharedElementSourceNames();
                ArrayList<String> sharedElementTargetNames = operation.f().getSharedElementTargetNames();
                View view7 = view6;
                int i2 = 0;
                while (i2 < sharedElementTargetNames.size()) {
                    int iIndexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames.get(i2));
                    ArrayList<String> arrayList7 = sharedElementTargetNames;
                    if (iIndexOf != -1) {
                        sharedElementSourceNames.set(iIndexOf, sharedElementSourceNames2.get(i2));
                    }
                    i2++;
                    sharedElementTargetNames = arrayList7;
                }
                ArrayList<String> sharedElementTargetNames2 = operation2.f().getSharedElementTargetNames();
                if (z3) {
                    operation.f().getEnterTransitionCallback();
                    operation2.f().getExitTransitionCallback();
                } else {
                    operation.f().getExitTransitionCallback();
                    operation2.f().getEnterTransitionCallback();
                }
                int i3 = 0;
                for (int size = sharedElementSourceNames.size(); i3 < size; size = size) {
                    aVar2.put(sharedElementSourceNames.get(i3), sharedElementTargetNames2.get(i3));
                    i3++;
                }
                androidx.collection.a<String, View> aVar3 = new androidx.collection.a<>();
                u(aVar3, operation.f().mView);
                aVar3.retainAll(sharedElementSourceNames);
                aVar2.retainAll(aVar3.keySet());
                androidx.collection.a<String, View> aVar4 = new androidx.collection.a<>();
                u(aVar4, operation2.f().mView);
                aVar4.retainAll(sharedElementTargetNames2);
                aVar4.retainAll(aVar2.values());
                s.x(aVar2, aVar4);
                v(aVar3, aVar2.keySet());
                v(aVar4, aVar2.values());
                if (aVar2.isEmpty()) {
                    arrayList5.clear();
                    arrayList6.clear();
                    aVar = aVar2;
                    arrayList3 = arrayList6;
                    operation5 = operation7;
                    arrayList4 = arrayList5;
                    rect = rect2;
                    view3 = view5;
                    zVar = zVar2;
                    view6 = view7;
                    obj3 = null;
                    operation6 = operation8;
                } else {
                    s.f(operation2.f(), operation.f(), z3, aVar3, true);
                    aVar = aVar2;
                    ArrayList<View> arrayList8 = arrayList6;
                    j0.a(m(), new g(operation2, operation, z2, aVar4));
                    arrayList5.addAll(aVar3.values());
                    if (sharedElementSourceNames.isEmpty()) {
                        view6 = view7;
                    } else {
                        View view8 = (View) aVar3.get(sharedElementSourceNames.get(0));
                        zVar2.v(objB, view8);
                        view6 = view8;
                    }
                    arrayList3 = arrayList8;
                    arrayList3.addAll(aVar4.values());
                    if (!sharedElementTargetNames2.isEmpty() && (view4 = (View) aVar4.get(sharedElementTargetNames2.get(0))) != null) {
                        j0.a(m(), new h(zVar2, view4, rect2));
                        z4 = true;
                    }
                    zVar2.z(objB, view5, arrayList5);
                    arrayList4 = arrayList5;
                    rect = rect2;
                    view3 = view5;
                    zVar = zVar2;
                    zVar2.t(objB, null, null, null, null, objB, arrayList3);
                    Boolean bool = Boolean.TRUE;
                    operation5 = operation;
                    map.put(operation5, bool);
                    operation6 = operation2;
                    map.put(operation6, bool);
                    obj3 = objB;
                }
            }
            operation7 = operation5;
            arrayList5 = arrayList4;
            rect2 = rect;
            view5 = view3;
            operation8 = operation6;
            aVar2 = aVar;
            z3 = z2;
            arrayList6 = arrayList3;
            zVar2 = zVar;
        }
        View view9 = view6;
        androidx.collection.a aVar5 = aVar2;
        ArrayList<View> arrayList9 = arrayList6;
        SpecialEffectsController.Operation operation9 = operation7;
        ArrayList<View> arrayList10 = arrayList5;
        Rect rect3 = rect2;
        View view10 = view5;
        z zVar3 = zVar2;
        SpecialEffectsController.Operation operation10 = operation8;
        ArrayList arrayList11 = new ArrayList();
        Object obj4 = null;
        Object objN2 = null;
        for (m mVar4 : list) {
            if (mVar4.d()) {
                map.put(mVar4.b(), Boolean.FALSE);
                mVar4.a();
            } else {
                Object objG = zVar3.g(mVar4.h());
                SpecialEffectsController.Operation operationB = mVar4.b();
                boolean z5 = obj3 != null && (operationB == operation9 || operationB == operation10);
                if (objG == null) {
                    if (!z5) {
                        map.put(operationB, Boolean.FALSE);
                        mVar4.a();
                    }
                    arrayList2 = arrayList9;
                    arrayList = arrayList10;
                    view = view10;
                    objN = obj4;
                    operation3 = operation10;
                    view2 = view9;
                } else {
                    ArrayList<View> arrayList12 = new ArrayList<>();
                    Object obj5 = obj4;
                    t(arrayList12, operationB.f().mView);
                    if (z5) {
                        if (operationB == operation9) {
                            arrayList12.removeAll(arrayList10);
                        } else {
                            arrayList12.removeAll(arrayList9);
                        }
                    }
                    if (arrayList12.isEmpty()) {
                        zVar3.a(objG, view10);
                        arrayList2 = arrayList9;
                        arrayList = arrayList10;
                        view = view10;
                        operation4 = operationB;
                        obj2 = objN2;
                        operation3 = operation10;
                        obj = obj5;
                    } else {
                        zVar3.b(objG, arrayList12);
                        view = view10;
                        obj = obj5;
                        arrayList = arrayList10;
                        obj2 = objN2;
                        arrayList2 = arrayList9;
                        operation3 = operation10;
                        zVar3.t(objG, objG, arrayList12, null, null, null, null);
                        if (operationB.e() == SpecialEffectsController.Operation.State.GONE) {
                            operation4 = operationB;
                            list2.remove(operation4);
                            ArrayList<View> arrayList13 = new ArrayList<>(arrayList12);
                            arrayList13.remove(operation4.f().mView);
                            zVar3.r(objG, operation4.f().mView, arrayList13);
                            j0.a(m(), new i(arrayList12));
                        } else {
                            operation4 = operationB;
                        }
                    }
                    if (operation4.e() == SpecialEffectsController.Operation.State.VISIBLE) {
                        arrayList11.addAll(arrayList12);
                        if (z4) {
                            zVar3.u(objG, rect3);
                        }
                        view2 = view9;
                    } else {
                        view2 = view9;
                        zVar3.v(objG, view2);
                    }
                    map.put(operation4, Boolean.TRUE);
                    if (mVar4.j()) {
                        objN2 = zVar3.n(obj2, objG, null);
                        objN = obj;
                    } else {
                        objN = zVar3.n(obj, objG, null);
                        objN2 = obj2;
                    }
                }
                operation10 = operation3;
                obj4 = objN;
                view9 = view2;
                view10 = view;
                arrayList10 = arrayList;
                arrayList9 = arrayList2;
            }
        }
        ArrayList<View> arrayList14 = arrayList9;
        ArrayList<View> arrayList15 = arrayList10;
        SpecialEffectsController.Operation operation11 = operation10;
        Object objM = zVar3.m(objN2, obj4, obj3);
        for (m mVar5 : list) {
            if (!mVar5.d()) {
                Object objH = mVar5.h();
                SpecialEffectsController.Operation operationB2 = mVar5.b();
                boolean z6 = obj3 != null && (operationB2 == operation9 || operationB2 == operation11);
                if (objH != null || z6) {
                    if (ViewCompat.B(m())) {
                        zVar3.w(mVar5.b().f(), objM, mVar5.c(), new j(mVar5));
                    } else {
                        if (FragmentManager.F0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Container " + m() + " has not been laid out. Completing operation " + operationB2);
                        }
                        mVar5.a();
                    }
                }
            }
        }
        if (!ViewCompat.B(m())) {
            return map;
        }
        s.A(arrayList11, 4);
        ArrayList<String> arrayListO = zVar3.o(arrayList14);
        zVar3.c(m(), objM);
        zVar3.y(m(), arrayList15, arrayList14, arrayListO, aVar5);
        s.A(arrayList11, 0);
        zVar3.A(obj3, arrayList15, arrayList14);
        return map;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0085  */
    @Override // androidx.fragment.app.SpecialEffectsController
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void f(@androidx.annotation.NonNull java.util.List<androidx.fragment.app.SpecialEffectsController.Operation> r11, boolean r12) {
        /*
            r10 = this;
            java.util.Iterator r0 = r11.iterator()
            r1 = 0
            r6 = r1
            r7 = r6
        L7:
            boolean r1 = r0.hasNext()
            r2 = 1
            if (r1 == 0) goto L44
            java.lang.Object r1 = r0.next()
            androidx.fragment.app.SpecialEffectsController$Operation r1 = (androidx.fragment.app.SpecialEffectsController.Operation) r1
            androidx.fragment.app.Fragment r3 = r1.f()
            android.view.View r3 = r3.mView
            androidx.fragment.app.SpecialEffectsController$Operation$State r3 = androidx.fragment.app.SpecialEffectsController.Operation.State.from(r3)
            int[] r4 = androidx.fragment.app.b.a.f2177a
            androidx.fragment.app.SpecialEffectsController$Operation$State r5 = r1.e()
            int r5 = r5.ordinal()
            r4 = r4[r5]
            if (r4 == r2) goto L3c
            r2 = 2
            if (r4 == r2) goto L3c
            r2 = 3
            if (r4 == r2) goto L3c
            r2 = 4
            if (r4 == r2) goto L36
            goto L7
        L36:
            androidx.fragment.app.SpecialEffectsController$Operation$State r2 = androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE
            if (r3 == r2) goto L7
            r7 = r1
            goto L7
        L3c:
            androidx.fragment.app.SpecialEffectsController$Operation$State r2 = androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE
            if (r3 != r2) goto L7
            if (r6 != 0) goto L7
            r6 = r1
            goto L7
        L44:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r11)
            java.util.Iterator r11 = r11.iterator()
        L57:
            boolean r4 = r11.hasNext()
            if (r4 == 0) goto L95
            java.lang.Object r4 = r11.next()
            androidx.fragment.app.SpecialEffectsController$Operation r4 = (androidx.fragment.app.SpecialEffectsController.Operation) r4
            androidx.core.os.f r5 = new androidx.core.os.f
            r5.<init>()
            r4.j(r5)
            androidx.fragment.app.b$k r8 = new androidx.fragment.app.b$k
            r8.<init>(r4, r5, r12)
            r0.add(r8)
            androidx.core.os.f r5 = new androidx.core.os.f
            r5.<init>()
            r4.j(r5)
            androidx.fragment.app.b$m r8 = new androidx.fragment.app.b$m
            r9 = 0
            if (r12 == 0) goto L83
            if (r4 != r6) goto L86
            goto L85
        L83:
            if (r4 != r7) goto L86
        L85:
            r9 = 1
        L86:
            r8.<init>(r4, r5, r12, r9)
            r3.add(r8)
            androidx.fragment.app.b$b r5 = new androidx.fragment.app.b$b
            r5.<init>(r1, r4)
            r4.a(r5)
            goto L57
        L95:
            r2 = r10
            r4 = r1
            r5 = r12
            java.util.Map r11 = r2.x(r3, r4, r5, r6, r7)
            java.lang.Boolean r12 = java.lang.Boolean.TRUE
            boolean r12 = r11.containsValue(r12)
            r10.w(r0, r1, r12, r11)
            java.util.Iterator r11 = r1.iterator()
        La9:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto Lb9
            java.lang.Object r12 = r11.next()
            androidx.fragment.app.SpecialEffectsController$Operation r12 = (androidx.fragment.app.SpecialEffectsController.Operation) r12
            r10.s(r12)
            goto La9
        Lb9:
            r1.clear()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.b.f(java.util.List, boolean):void");
    }

    void s(@NonNull SpecialEffectsController.Operation operation) {
        operation.e().applyState(operation.f().mView);
    }

    void t(ArrayList<View> arrayList, View view) {
        if (!(view instanceof ViewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (o2.a(viewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(viewGroup);
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt.getVisibility() == 0) {
                t(arrayList, childAt);
            }
        }
    }

    void u(Map<String, View> map, @NonNull View view) {
        String strW = ViewCompat.w(view);
        if (strW != null) {
            map.put(strW, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt.getVisibility() == 0) {
                    u(map, childAt);
                }
            }
        }
    }

    void v(@NonNull androidx.collection.a<String, View> aVar, @NonNull Collection<String> collection) {
        Iterator<Map.Entry<String, View>> it = aVar.entrySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(ViewCompat.w(it.next().getValue()))) {
                it.remove();
            }
        }
    }
}
