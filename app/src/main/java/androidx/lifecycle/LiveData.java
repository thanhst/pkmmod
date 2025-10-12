package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;

/* loaded from: classes.dex */
public abstract class LiveData<T> {

    /* renamed from: k, reason: collision with root package name */
    static final Object f2391k = new Object();

    /* renamed from: a, reason: collision with root package name */
    final Object f2392a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private i.b<s<? super T>, LiveData<T>.c> f2393b = new i.b<>();

    /* renamed from: c, reason: collision with root package name */
    int f2394c = 0;

    /* renamed from: d, reason: collision with root package name */
    private boolean f2395d;

    /* renamed from: e, reason: collision with root package name */
    private volatile Object f2396e;

    /* renamed from: f, reason: collision with root package name */
    volatile Object f2397f;

    /* renamed from: g, reason: collision with root package name */
    private int f2398g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f2399h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f2400i;

    /* renamed from: j, reason: collision with root package name */
    private final Runnable f2401j;

    class LifecycleBoundObserver extends LiveData<T>.c implements k {

        /* renamed from: e, reason: collision with root package name */
        @NonNull
        final m f2402e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ LiveData f2403f;

        @Override // androidx.lifecycle.k
        public void d(@NonNull m mVar, @NonNull Lifecycle.Event event) {
            Lifecycle.State stateB = this.f2402e.getLifecycle().b();
            if (stateB == Lifecycle.State.DESTROYED) {
                this.f2403f.h(this.f2406a);
                return;
            }
            Lifecycle.State state = null;
            while (state != stateB) {
                h(j());
                state = stateB;
                stateB = this.f2402e.getLifecycle().b();
            }
        }

        @Override // androidx.lifecycle.LiveData.c
        void i() {
            this.f2402e.getLifecycle().c(this);
        }

        @Override // androidx.lifecycle.LiveData.c
        boolean j() {
            return this.f2402e.getLifecycle().b().isAtLeast(Lifecycle.State.STARTED);
        }
    }

    class a implements Runnable {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            synchronized (LiveData.this.f2392a) {
                obj = LiveData.this.f2397f;
                LiveData.this.f2397f = LiveData.f2391k;
            }
            LiveData.this.i(obj);
        }
    }

    private class b extends LiveData<T>.c {
        b(s<? super T> sVar) {
            super(sVar);
        }

        @Override // androidx.lifecycle.LiveData.c
        boolean j() {
            return true;
        }
    }

    private abstract class c {

        /* renamed from: a, reason: collision with root package name */
        final s<? super T> f2406a;

        /* renamed from: b, reason: collision with root package name */
        boolean f2407b;

        /* renamed from: c, reason: collision with root package name */
        int f2408c = -1;

        c(s<? super T> sVar) {
            this.f2406a = sVar;
        }

        void h(boolean z2) {
            if (z2 == this.f2407b) {
                return;
            }
            this.f2407b = z2;
            LiveData.this.b(z2 ? 1 : -1);
            if (this.f2407b) {
                LiveData.this.d(this);
            }
        }

        void i() {
        }

        abstract boolean j();
    }

    public LiveData() {
        Object obj = f2391k;
        this.f2397f = obj;
        this.f2401j = new a();
        this.f2396e = obj;
        this.f2398g = -1;
    }

    static void a(String str) {
        if (h.a.d().b()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    private void c(LiveData<T>.c cVar) {
        if (cVar.f2407b) {
            if (!cVar.j()) {
                cVar.h(false);
                return;
            }
            int i2 = cVar.f2408c;
            int i3 = this.f2398g;
            if (i2 >= i3) {
                return;
            }
            cVar.f2408c = i3;
            cVar.f2406a.a((Object) this.f2396e);
        }
    }

    @MainThread
    void b(int i2) {
        int i3 = this.f2394c;
        this.f2394c = i2 + i3;
        if (this.f2395d) {
            return;
        }
        this.f2395d = true;
        while (true) {
            try {
                int i4 = this.f2394c;
                if (i3 == i4) {
                    return;
                }
                boolean z2 = i3 == 0 && i4 > 0;
                boolean z3 = i3 > 0 && i4 == 0;
                if (z2) {
                    f();
                } else if (z3) {
                    g();
                }
                i3 = i4;
            } finally {
                this.f2395d = false;
            }
        }
    }

    void d(@Nullable LiveData<T>.c cVar) {
        if (this.f2399h) {
            this.f2400i = true;
            return;
        }
        this.f2399h = true;
        do {
            this.f2400i = false;
            if (cVar != null) {
                c(cVar);
                cVar = null;
            } else {
                i.b<s<? super T>, LiveData<T>.c>.d dVarC = this.f2393b.c();
                while (dVarC.hasNext()) {
                    c((c) dVarC.next().getValue());
                    if (this.f2400i) {
                        break;
                    }
                }
            }
        } while (this.f2400i);
        this.f2399h = false;
    }

    @MainThread
    public void e(@NonNull s<? super T> sVar) {
        a("observeForever");
        b bVar = new b(sVar);
        LiveData<T>.c cVarF = this.f2393b.f(sVar, bVar);
        if (cVarF instanceof LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (cVarF != null) {
            return;
        }
        bVar.h(true);
    }

    protected void f() {
    }

    protected void g() {
    }

    @MainThread
    public void h(@NonNull s<? super T> sVar) {
        a("removeObserver");
        LiveData<T>.c cVarG = this.f2393b.g(sVar);
        if (cVarG == null) {
            return;
        }
        cVarG.i();
        cVarG.h(false);
    }

    @MainThread
    protected void i(T t2) {
        a("setValue");
        this.f2398g++;
        this.f2396e = t2;
        d(null);
    }
}
