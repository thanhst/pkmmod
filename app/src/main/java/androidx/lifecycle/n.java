package androidx.lifecycle;

import android.annotation.SuppressLint;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* compiled from: LifecycleRegistry.java */
/* loaded from: classes.dex */
public class n extends Lifecycle {

    /* renamed from: b, reason: collision with root package name */
    private i.a<l, a> f2449b;

    /* renamed from: c, reason: collision with root package name */
    private Lifecycle.State f2450c;

    /* renamed from: d, reason: collision with root package name */
    private final WeakReference<m> f2451d;

    /* renamed from: e, reason: collision with root package name */
    private int f2452e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f2453f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f2454g;

    /* renamed from: h, reason: collision with root package name */
    private ArrayList<Lifecycle.State> f2455h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f2456i;

    /* compiled from: LifecycleRegistry.java */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        Lifecycle.State f2457a;

        /* renamed from: b, reason: collision with root package name */
        k f2458b;

        a(l lVar, Lifecycle.State state) {
            this.f2458b = p.f(lVar);
            this.f2457a = state;
        }

        void a(m mVar, Lifecycle.Event event) {
            Lifecycle.State targetState = event.getTargetState();
            this.f2457a = n.k(this.f2457a, targetState);
            this.f2458b.d(mVar, event);
            this.f2457a = targetState;
        }
    }

    public n(@NonNull m mVar) {
        this(mVar, true);
    }

    private void d(m mVar) {
        Iterator<Map.Entry<l, a>> itDescendingIterator = this.f2449b.descendingIterator();
        while (itDescendingIterator.hasNext() && !this.f2454g) {
            Map.Entry<l, a> next = itDescendingIterator.next();
            a value = next.getValue();
            while (value.f2457a.compareTo(this.f2450c) > 0 && !this.f2454g && this.f2449b.contains(next.getKey())) {
                Lifecycle.Event eventDownFrom = Lifecycle.Event.downFrom(value.f2457a);
                if (eventDownFrom == null) {
                    throw new IllegalStateException("no event down from " + value.f2457a);
                }
                n(eventDownFrom.getTargetState());
                value.a(mVar, eventDownFrom);
                m();
            }
        }
    }

    private Lifecycle.State e(l lVar) {
        Map.Entry<l, a> entryH = this.f2449b.h(lVar);
        Lifecycle.State state = null;
        Lifecycle.State state2 = entryH != null ? entryH.getValue().f2457a : null;
        if (!this.f2455h.isEmpty()) {
            state = this.f2455h.get(r0.size() - 1);
        }
        return k(k(this.f2450c, state2), state);
    }

    @SuppressLint({"RestrictedApi"})
    private void f(String str) {
        if (!this.f2456i || h.a.d().b()) {
            return;
        }
        throw new IllegalStateException("Method " + str + " must be called on the main thread");
    }

    private void g(m mVar) {
        i.b<l, a>.d dVarC = this.f2449b.c();
        while (dVarC.hasNext() && !this.f2454g) {
            Map.Entry next = dVarC.next();
            a aVar = (a) next.getValue();
            while (aVar.f2457a.compareTo(this.f2450c) < 0 && !this.f2454g && this.f2449b.contains((l) next.getKey())) {
                n(aVar.f2457a);
                Lifecycle.Event eventUpFrom = Lifecycle.Event.upFrom(aVar.f2457a);
                if (eventUpFrom == null) {
                    throw new IllegalStateException("no event up from " + aVar.f2457a);
                }
                aVar.a(mVar, eventUpFrom);
                m();
            }
        }
    }

    private boolean i() {
        if (this.f2449b.size() == 0) {
            return true;
        }
        Lifecycle.State state = this.f2449b.a().getValue().f2457a;
        Lifecycle.State state2 = this.f2449b.d().getValue().f2457a;
        return state == state2 && this.f2450c == state2;
    }

    static Lifecycle.State k(@NonNull Lifecycle.State state, @Nullable Lifecycle.State state2) {
        return (state2 == null || state2.compareTo(state) >= 0) ? state : state2;
    }

    private void l(Lifecycle.State state) {
        Lifecycle.State state2 = this.f2450c;
        if (state2 == state) {
            return;
        }
        if (state2 == Lifecycle.State.INITIALIZED && state == Lifecycle.State.DESTROYED) {
            throw new IllegalStateException("no event down from " + this.f2450c);
        }
        this.f2450c = state;
        if (this.f2453f || this.f2452e != 0) {
            this.f2454g = true;
            return;
        }
        this.f2453f = true;
        p();
        this.f2453f = false;
        if (this.f2450c == Lifecycle.State.DESTROYED) {
            this.f2449b = new i.a<>();
        }
    }

    private void m() {
        this.f2455h.remove(r0.size() - 1);
    }

    private void n(Lifecycle.State state) {
        this.f2455h.add(state);
    }

    private void p() {
        m mVar = this.f2451d.get();
        if (mVar == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
        }
        while (!i()) {
            this.f2454g = false;
            if (this.f2450c.compareTo(this.f2449b.a().getValue().f2457a) < 0) {
                d(mVar);
            }
            Map.Entry<l, a> entryD = this.f2449b.d();
            if (!this.f2454g && entryD != null && this.f2450c.compareTo(entryD.getValue().f2457a) > 0) {
                g(mVar);
            }
        }
        this.f2454g = false;
    }

    @Override // androidx.lifecycle.Lifecycle
    public void a(@NonNull l lVar) {
        m mVar;
        f("addObserver");
        Lifecycle.State state = this.f2450c;
        Lifecycle.State state2 = Lifecycle.State.DESTROYED;
        if (state != state2) {
            state2 = Lifecycle.State.INITIALIZED;
        }
        a aVar = new a(lVar, state2);
        if (this.f2449b.f(lVar, aVar) == null && (mVar = this.f2451d.get()) != null) {
            boolean z2 = this.f2452e != 0 || this.f2453f;
            Lifecycle.State stateE = e(lVar);
            this.f2452e++;
            while (aVar.f2457a.compareTo(stateE) < 0 && this.f2449b.contains(lVar)) {
                n(aVar.f2457a);
                Lifecycle.Event eventUpFrom = Lifecycle.Event.upFrom(aVar.f2457a);
                if (eventUpFrom == null) {
                    throw new IllegalStateException("no event up from " + aVar.f2457a);
                }
                aVar.a(mVar, eventUpFrom);
                m();
                stateE = e(lVar);
            }
            if (!z2) {
                p();
            }
            this.f2452e--;
        }
    }

    @Override // androidx.lifecycle.Lifecycle
    @NonNull
    public Lifecycle.State b() {
        return this.f2450c;
    }

    @Override // androidx.lifecycle.Lifecycle
    public void c(@NonNull l lVar) {
        f("removeObserver");
        this.f2449b.g(lVar);
    }

    public void h(@NonNull Lifecycle.Event event) {
        f("handleLifecycleEvent");
        l(event.getTargetState());
    }

    @MainThread
    @Deprecated
    public void j(@NonNull Lifecycle.State state) {
        f("markState");
        o(state);
    }

    @MainThread
    public void o(@NonNull Lifecycle.State state) {
        f("setCurrentState");
        l(state);
    }

    private n(@NonNull m mVar, boolean z2) {
        this.f2449b = new i.a<>();
        this.f2452e = 0;
        this.f2453f = false;
        this.f2454g = false;
        this.f2455h = new ArrayList<>();
        this.f2451d = new WeakReference<>(mVar);
        this.f2450c = Lifecycle.State.INITIALIZED;
        this.f2456i = z2;
    }
}
