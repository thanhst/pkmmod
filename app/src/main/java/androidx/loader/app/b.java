package androidx.loader.app;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.h;
import androidx.lifecycle.a0;
import androidx.lifecycle.b0;
import androidx.lifecycle.c0;
import androidx.lifecycle.e0;
import androidx.lifecycle.m;
import androidx.lifecycle.r;
import androidx.lifecycle.s;
import java.io.FileDescriptor;
import java.io.PrintWriter;

import t.a_t;

/* compiled from: LoaderManagerImpl.java */
/* loaded from: classes.dex */
class b extends androidx.loader.app.a {

    /* renamed from: c, reason: collision with root package name */
    static boolean f2489c = false;

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final m f2490a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private final C0035b f2491b;

    /* compiled from: LoaderManagerImpl.java */
    public static class a<D> extends r<D> {

        /* renamed from: l, reason: collision with root package name */
        private final int f2492l;

        /* renamed from: m, reason: collision with root package name */
        @Nullable
        private final Bundle f2493m;

        /* renamed from: n, reason: collision with root package name */
        private m f2494n;

        @Override // androidx.lifecycle.LiveData
        protected void f() {
            if (b.f2489c) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            throw null;
        }

        @Override // androidx.lifecycle.LiveData
        protected void g() {
            if (b.f2489c) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            throw null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public void h(@NonNull s<? super D> sVar) {
            super.h(sVar);
            this.f2494n = null;
        }

        @Override // androidx.lifecycle.r, androidx.lifecycle.LiveData
        public void i(D d2) {
            super.i(d2);
        }

        @MainThread
        a_t<D> j(boolean z2) {
            if (b.f2489c) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            throw null;
        }

        public void k(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f2492l);
            printWriter.print(" mArgs=");
            printWriter.println(this.f2493m);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println((Object) null);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("  ");
            throw null;
        }

        void l() {
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.f2492l);
            sb.append(" : ");
            androidx.core.util.b.a(null, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    /* compiled from: LoaderManagerImpl.java */
    /* renamed from: androidx.loader.app.b$b, reason: collision with other inner class name */
    static class C0035b extends a0 {

        /* renamed from: f, reason: collision with root package name */
        private static final b0.b f2495f = new a();

        /* renamed from: d, reason: collision with root package name */
        private h<a> f2496d = new h<>();

        /* renamed from: e, reason: collision with root package name */
        private boolean f2497e = false;

        /* compiled from: LoaderManagerImpl.java */
        /* renamed from: androidx.loader.app.b$b$a */
        static class a implements b0.b {
            a() {
            }

            @Override // androidx.lifecycle.b0.b
            @NonNull
            public <T extends a0> T a(@NonNull Class<T> cls) {
                return new C0035b();
            }

            @Override // androidx.lifecycle.b0.b
            public /* synthetic */ a0 b(Class cls, s.a aVar) {
                return c0.b(this, cls, aVar);
            }
        }

        C0035b() {
        }

        @NonNull
        static C0035b g(e0 e0Var) {
            return (C0035b) new b0(e0Var, f2495f).a(C0035b.class);
        }

        @Override // androidx.lifecycle.a0
        protected void d() {
            super.d();
            int i2 = this.f2496d.i();
            for (int i3 = 0; i3 < i2; i3++) {
                this.f2496d.j(i3).j(true);
            }
            this.f2496d.b();
        }

        public void f(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f2496d.i() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i2 = 0; i2 < this.f2496d.i(); i2++) {
                    a aVarJ = this.f2496d.j(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f2496d.g(i2));
                    printWriter.print(": ");
                    printWriter.println(aVarJ.toString());
                    aVarJ.k(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        void h() {
            int i2 = this.f2496d.i();
            for (int i3 = 0; i3 < i2; i3++) {
                this.f2496d.j(i3).l();
            }
        }
    }

    b(@NonNull m mVar, @NonNull e0 e0Var) {
        this.f2490a = mVar;
        this.f2491b = C0035b.g(e0Var);
    }

    @Override // androidx.loader.app.a
    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f2491b.f(str, fileDescriptor, printWriter, strArr);
    }

    @Override // androidx.loader.app.a
    public void c() {
        this.f2491b.h();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        androidx.core.util.b.a(this.f2490a, sb);
        sb.append("}}");
        return sb.toString();
    }
}
