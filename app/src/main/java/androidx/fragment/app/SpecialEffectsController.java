package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.os.f;
import androidx.core.view.ViewCompat;
import androidx.fragment.R$id;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
abstract class SpecialEffectsController {

    /* renamed from: a, reason: collision with root package name */
    private final ViewGroup f2150a;

    /* renamed from: b, reason: collision with root package name */
    final ArrayList<Operation> f2151b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    final ArrayList<Operation> f2152c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    boolean f2153d = false;

    /* renamed from: e, reason: collision with root package name */
    boolean f2154e = false;

    class a implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ d f2163e;

        a(d dVar) {
            this.f2163e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SpecialEffectsController.this.f2151b.contains(this.f2163e)) {
                this.f2163e.e().applyState(this.f2163e.f().mView);
            }
        }
    }

    class b implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ d f2165e;

        b(d dVar) {
            this.f2165e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            SpecialEffectsController.this.f2151b.remove(this.f2165e);
            SpecialEffectsController.this.f2152c.remove(this.f2165e);
        }
    }

    static /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2167a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f2168b;

        static {
            int[] iArr = new int[Operation.LifecycleImpact.values().length];
            f2168b = iArr;
            try {
                iArr[Operation.LifecycleImpact.ADDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2168b[Operation.LifecycleImpact.REMOVING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2168b[Operation.LifecycleImpact.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[Operation.State.values().length];
            f2167a = iArr2;
            try {
                iArr2[Operation.State.REMOVED.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2167a[Operation.State.VISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2167a[Operation.State.GONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2167a[Operation.State.INVISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private static class d extends Operation {

        /* renamed from: h, reason: collision with root package name */
        @NonNull
        private final p f2169h;

        d(@NonNull Operation.State state, @NonNull Operation.LifecycleImpact lifecycleImpact, @NonNull p pVar, @NonNull androidx.core.os.f fVar) {
            super(state, lifecycleImpact, pVar.k(), fVar);
            this.f2169h = pVar;
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Operation
        public void c() {
            super.c();
            this.f2169h.m();
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Operation
        void l() {
            if (g() == Operation.LifecycleImpact.ADDING) {
                Fragment fragmentK = this.f2169h.k();
                View viewFindFocus = fragmentK.mView.findFocus();
                if (viewFindFocus != null) {
                    fragmentK.setFocusedView(viewFindFocus);
                    if (FragmentManager.F0(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + fragmentK);
                    }
                }
                View viewRequireView = f().requireView();
                if (viewRequireView.getParent() == null) {
                    this.f2169h.b();
                    viewRequireView.setAlpha(0.0f);
                }
                if (viewRequireView.getAlpha() == 0.0f && viewRequireView.getVisibility() == 0) {
                    viewRequireView.setVisibility(4);
                }
                viewRequireView.setAlpha(fragmentK.getPostOnViewCreatedAlpha());
            }
        }
    }

    SpecialEffectsController(@NonNull ViewGroup viewGroup) {
        this.f2150a = viewGroup;
    }

    private void a(@NonNull Operation.State state, @NonNull Operation.LifecycleImpact lifecycleImpact, @NonNull p pVar) {
        synchronized (this.f2151b) {
            androidx.core.os.f fVar = new androidx.core.os.f();
            Operation operationH = h(pVar.k());
            if (operationH != null) {
                operationH.k(state, lifecycleImpact);
                return;
            }
            d dVar = new d(state, lifecycleImpact, pVar, fVar);
            this.f2151b.add(dVar);
            dVar.a(new a(dVar));
            dVar.a(new b(dVar));
        }
    }

    @Nullable
    private Operation h(@NonNull Fragment fragment) {
        Iterator<Operation> it = this.f2151b.iterator();
        while (it.hasNext()) {
            Operation next = it.next();
            if (next.f().equals(fragment) && !next.h()) {
                return next;
            }
        }
        return null;
    }

    @Nullable
    private Operation i(@NonNull Fragment fragment) {
        Iterator<Operation> it = this.f2152c.iterator();
        while (it.hasNext()) {
            Operation next = it.next();
            if (next.f().equals(fragment) && !next.h()) {
                return next;
            }
        }
        return null;
    }

    @NonNull
    static SpecialEffectsController n(@NonNull ViewGroup viewGroup, @NonNull FragmentManager fragmentManager) {
        return o(viewGroup, fragmentManager.y0());
    }

    @NonNull
    static SpecialEffectsController o(@NonNull ViewGroup viewGroup, @NonNull c0 c0Var) {
        int i2 = R$id.special_effects_controller_view_tag;
        Object tag = viewGroup.getTag(i2);
        if (tag instanceof SpecialEffectsController) {
            return (SpecialEffectsController) tag;
        }
        SpecialEffectsController specialEffectsControllerA = c0Var.a(viewGroup);
        viewGroup.setTag(i2, specialEffectsControllerA);
        return specialEffectsControllerA;
    }

    private void q() {
        Iterator<Operation> it = this.f2151b.iterator();
        while (it.hasNext()) {
            Operation next = it.next();
            if (next.g() == Operation.LifecycleImpact.ADDING) {
                next.k(Operation.State.from(next.f().requireView().getVisibility()), Operation.LifecycleImpact.NONE);
            }
        }
    }

    void b(@NonNull Operation.State state, @NonNull p pVar) {
        if (FragmentManager.F0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + pVar.k());
        }
        a(state, Operation.LifecycleImpact.ADDING, pVar);
    }

    void c(@NonNull p pVar) {
        if (FragmentManager.F0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + pVar.k());
        }
        a(Operation.State.GONE, Operation.LifecycleImpact.NONE, pVar);
    }

    void d(@NonNull p pVar) {
        if (FragmentManager.F0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + pVar.k());
        }
        a(Operation.State.REMOVED, Operation.LifecycleImpact.REMOVING, pVar);
    }

    void e(@NonNull p pVar) {
        if (FragmentManager.F0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + pVar.k());
        }
        a(Operation.State.VISIBLE, Operation.LifecycleImpact.NONE, pVar);
    }

    abstract void f(@NonNull List<Operation> list, boolean z2);

    void g() {
        if (this.f2154e) {
            return;
        }
        if (!ViewCompat.A(this.f2150a)) {
            j();
            this.f2153d = false;
            return;
        }
        synchronized (this.f2151b) {
            if (!this.f2151b.isEmpty()) {
                ArrayList arrayList = new ArrayList(this.f2152c);
                this.f2152c.clear();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Operation operation = (Operation) it.next();
                    if (FragmentManager.F0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + operation);
                    }
                    operation.b();
                    if (!operation.i()) {
                        this.f2152c.add(operation);
                    }
                }
                q();
                ArrayList arrayList2 = new ArrayList(this.f2151b);
                this.f2151b.clear();
                this.f2152c.addAll(arrayList2);
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    ((Operation) it2.next()).l();
                }
                f(arrayList2, this.f2153d);
                this.f2153d = false;
            }
        }
    }

    void j() {
        String str;
        String str2;
        boolean zA = ViewCompat.A(this.f2150a);
        synchronized (this.f2151b) {
            q();
            Iterator<Operation> it = this.f2151b.iterator();
            while (it.hasNext()) {
                it.next().l();
            }
            Iterator it2 = new ArrayList(this.f2152c).iterator();
            while (it2.hasNext()) {
                Operation operation = (Operation) it2.next();
                if (FragmentManager.F0(2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("SpecialEffectsController: ");
                    if (zA) {
                        str2 = "";
                    } else {
                        str2 = "Container " + this.f2150a + " is not attached to window. ";
                    }
                    sb.append(str2);
                    sb.append("Cancelling running operation ");
                    sb.append(operation);
                    Log.v("FragmentManager", sb.toString());
                }
                operation.b();
            }
            Iterator it3 = new ArrayList(this.f2151b).iterator();
            while (it3.hasNext()) {
                Operation operation2 = (Operation) it3.next();
                if (FragmentManager.F0(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("SpecialEffectsController: ");
                    if (zA) {
                        str = "";
                    } else {
                        str = "Container " + this.f2150a + " is not attached to window. ";
                    }
                    sb2.append(str);
                    sb2.append("Cancelling pending operation ");
                    sb2.append(operation2);
                    Log.v("FragmentManager", sb2.toString());
                }
                operation2.b();
            }
        }
    }

    void k() {
        if (this.f2154e) {
            this.f2154e = false;
            g();
        }
    }

    @Nullable
    Operation.LifecycleImpact l(@NonNull p pVar) {
        Operation operationH = h(pVar.k());
        Operation.LifecycleImpact lifecycleImpactG = operationH != null ? operationH.g() : null;
        Operation operationI = i(pVar.k());
        return (operationI == null || !(lifecycleImpactG == null || lifecycleImpactG == Operation.LifecycleImpact.NONE)) ? lifecycleImpactG : operationI.g();
    }

    @NonNull
    public ViewGroup m() {
        return this.f2150a;
    }

    void p() {
        synchronized (this.f2151b) {
            q();
            this.f2154e = false;
            int size = this.f2151b.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                Operation operation = this.f2151b.get(size);
                Operation.State stateFrom = Operation.State.from(operation.f().mView);
                Operation.State stateE = operation.e();
                Operation.State state = Operation.State.VISIBLE;
                if (stateE == state && stateFrom != state) {
                    this.f2154e = operation.f().isPostponed();
                    break;
                }
                size--;
            }
        }
    }

    void r(boolean z2) {
        this.f2153d = z2;
    }

    static class Operation {

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        private State f2155a;

        /* renamed from: b, reason: collision with root package name */
        @NonNull
        private LifecycleImpact f2156b;

        /* renamed from: c, reason: collision with root package name */
        @NonNull
        private final Fragment f2157c;

        /* renamed from: d, reason: collision with root package name */
        @NonNull
        private final List<Runnable> f2158d = new ArrayList();

        /* renamed from: e, reason: collision with root package name */
        @NonNull
        private final HashSet<androidx.core.os.f> f2159e = new HashSet<>();

        /* renamed from: f, reason: collision with root package name */
        private boolean f2160f = false;

        /* renamed from: g, reason: collision with root package name */
        private boolean f2161g = false;

        enum LifecycleImpact {
            NONE,
            ADDING,
            REMOVING
        }

        class a implements f.b {
            a() {
            }

            @Override // androidx.core.os.f.b
            public void onCancel() {
                Operation.this.b();
            }
        }

        Operation(@NonNull State state, @NonNull LifecycleImpact lifecycleImpact, @NonNull Fragment fragment, @NonNull androidx.core.os.f fVar) {
            this.f2155a = state;
            this.f2156b = lifecycleImpact;
            this.f2157c = fragment;
            fVar.c(new a());
        }

        final void a(@NonNull Runnable runnable) {
            this.f2158d.add(runnable);
        }

        final void b() {
            if (h()) {
                return;
            }
            this.f2160f = true;
            if (this.f2159e.isEmpty()) {
                c();
                return;
            }
            Iterator it = new ArrayList(this.f2159e).iterator();
            while (it.hasNext()) {
                ((androidx.core.os.f) it.next()).a();
            }
        }

        @CallSuper
        public void c() {
            if (this.f2161g) {
                return;
            }
            if (FragmentManager.F0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.f2161g = true;
            Iterator<Runnable> it = this.f2158d.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
        }

        public final void d(@NonNull androidx.core.os.f fVar) {
            if (this.f2159e.remove(fVar) && this.f2159e.isEmpty()) {
                c();
            }
        }

        @NonNull
        public State e() {
            return this.f2155a;
        }

        @NonNull
        public final Fragment f() {
            return this.f2157c;
        }

        @NonNull
        LifecycleImpact g() {
            return this.f2156b;
        }

        final boolean h() {
            return this.f2160f;
        }

        final boolean i() {
            return this.f2161g;
        }

        public final void j(@NonNull androidx.core.os.f fVar) {
            l();
            this.f2159e.add(fVar);
        }

        final void k(@NonNull State state, @NonNull LifecycleImpact lifecycleImpact) {
            int i2 = c.f2168b[lifecycleImpact.ordinal()];
            if (i2 == 1) {
                if (this.f2155a == State.REMOVED) {
                    if (FragmentManager.F0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f2157c + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.f2156b + " to ADDING.");
                    }
                    this.f2155a = State.VISIBLE;
                    this.f2156b = LifecycleImpact.ADDING;
                    return;
                }
                return;
            }
            if (i2 == 2) {
                if (FragmentManager.F0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f2157c + " mFinalState = " + this.f2155a + " -> REMOVED. mLifecycleImpact  = " + this.f2156b + " to REMOVING.");
                }
                this.f2155a = State.REMOVED;
                this.f2156b = LifecycleImpact.REMOVING;
                return;
            }
            if (i2 == 3 && this.f2155a != State.REMOVED) {
                if (FragmentManager.F0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f2157c + " mFinalState = " + this.f2155a + " -> " + state + ". ");
                }
                this.f2155a = state;
            }
        }

        void l() {
        }

        @NonNull
        public String toString() {
            return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {mFinalState = " + this.f2155a + "} {mLifecycleImpact = " + this.f2156b + "} {mFragment = " + this.f2157c + "}";
        }

        enum State {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;

            @NonNull
            static State from(@NonNull View view) {
                return (view.getAlpha() == 0.0f && view.getVisibility() == 0) ? INVISIBLE : from(view.getVisibility());
            }

            void applyState(@NonNull View view) {
                int i2 = c.f2167a[ordinal()];
                if (i2 == 1) {
                    ViewGroup viewGroup = (ViewGroup) view.getParent();
                    if (viewGroup != null) {
                        if (FragmentManager.F0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                        }
                        viewGroup.removeView(view);
                        return;
                    }
                    return;
                }
                if (i2 == 2) {
                    if (FragmentManager.F0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
                    }
                    view.setVisibility(0);
                    return;
                }
                if (i2 == 3) {
                    if (FragmentManager.F0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
                    }
                    view.setVisibility(8);
                    return;
                }
                if (i2 != 4) {
                    return;
                }
                if (FragmentManager.F0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
                }
                view.setVisibility(4);
            }

            @NonNull
            static State from(int i2) {
                if (i2 == 0) {
                    return VISIBLE;
                }
                if (i2 == 4) {
                    return INVISIBLE;
                }
                if (i2 == 8) {
                    return GONE;
                }
                throw new IllegalArgumentException("Unknown visibility " + i2);
            }
        }
    }
}
