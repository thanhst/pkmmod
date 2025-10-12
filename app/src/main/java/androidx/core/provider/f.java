package androidx.core.provider;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.provider.FontsContractCompat;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* compiled from: FontRequestWorker.java */
/* loaded from: classes.dex */
class f {

    /* renamed from: a, reason: collision with root package name */
    static final androidx.collection.e<String, Typeface> f1594a = new androidx.collection.e<>(16);

    /* renamed from: b, reason: collision with root package name */
    private static final ExecutorService f1595b = g.a("fonts-androidx", 10, 10000);

    /* renamed from: c, reason: collision with root package name */
    static final Object f1596c = new Object();

    /* renamed from: d, reason: collision with root package name */
    @GuardedBy("LOCK")
    static final androidx.collection.g<String, ArrayList<androidx.core.util.a<e>>> f1597d = new androidx.collection.g<>();

    /* compiled from: FontRequestWorker.java */
    class a implements Callable<e> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f1598a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f1599b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ androidx.core.provider.e f1600c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f1601d;

        a(String str, Context context, androidx.core.provider.e eVar, int i2) {
            this.f1598a = str;
            this.f1599b = context;
            this.f1600c = eVar;
            this.f1601d = i2;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e call() {
            return f.c(this.f1598a, this.f1599b, this.f1600c, this.f1601d);
        }
    }

    /* compiled from: FontRequestWorker.java */
    class b implements androidx.core.util.a<e> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ androidx.core.provider.a f1602e;

        b(androidx.core.provider.a aVar) {
            this.f1602e = aVar;
        }

        @Override // androidx.core.util.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(e eVar) {
            if (eVar == null) {
                eVar = new e(-3);
            }
            this.f1602e.b(eVar);
        }
    }

    /* compiled from: FontRequestWorker.java */
    class c implements Callable<e> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f1603a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f1604b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ androidx.core.provider.e f1605c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f1606d;

        c(String str, Context context, androidx.core.provider.e eVar, int i2) {
            this.f1603a = str;
            this.f1604b = context;
            this.f1605c = eVar;
            this.f1606d = i2;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e call() {
            try {
                return f.c(this.f1603a, this.f1604b, this.f1605c, this.f1606d);
            } catch (Throwable unused) {
                return new e(-3);
            }
        }
    }

    /* compiled from: FontRequestWorker.java */
    class d implements androidx.core.util.a<e> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f1607e;

        d(String str) {
            this.f1607e = str;
        }

        @Override // androidx.core.util.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(e eVar) {
            synchronized (f.f1596c) {
                androidx.collection.g<String, ArrayList<androidx.core.util.a<e>>> gVar = f.f1597d;
                ArrayList<androidx.core.util.a<e>> arrayList = gVar.get(this.f1607e);
                if (arrayList == null) {
                    return;
                }
                gVar.remove(this.f1607e);
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    arrayList.get(i2).accept(eVar);
                }
            }
        }
    }

    private static String a(@NonNull androidx.core.provider.e eVar, int i2) {
        return eVar.d() + "-" + i2;
    }

    @SuppressLint({"WrongConstant"})
    private static int b(@NonNull FontsContractCompat.a aVar) {
        int i2 = 1;
        if (aVar.c() != 0) {
            return aVar.c() != 1 ? -3 : -2;
        }
        FontsContractCompat.b[] bVarArrB = aVar.b();
        if (bVarArrB != null && bVarArrB.length != 0) {
            i2 = 0;
            for (FontsContractCompat.b bVar : bVarArrB) {
                int iB = bVar.b();
                if (iB != 0) {
                    if (iB < 0) {
                        return -3;
                    }
                    return iB;
                }
            }
        }
        return i2;
    }

    @NonNull
    static e c(@NonNull String str, @NonNull Context context, @NonNull androidx.core.provider.e eVar, int i2) {
        androidx.collection.e<String, Typeface> eVar2 = f1594a;
        Typeface typefaceC = eVar2.c(str);
        if (typefaceC != null) {
            return new e(typefaceC);
        }
        try {
            FontsContractCompat.a aVarE = androidx.core.provider.d.e(context, eVar, null);
            int iB = b(aVarE);
            if (iB != 0) {
                return new e(iB);
            }
            Typeface typefaceB = androidx.core.graphics.f.b(context, null, aVarE.b(), i2);
            if (typefaceB == null) {
                return new e(-3);
            }
            eVar2.d(str, typefaceB);
            return new e(typefaceB);
        } catch (PackageManager.NameNotFoundException unused) {
            return new e(-1);
        }
    }

    static Typeface d(@NonNull Context context, @NonNull androidx.core.provider.e eVar, int i2, @Nullable Executor executor, @NonNull androidx.core.provider.a aVar) {
        String strA = a(eVar, i2);
        Typeface typefaceC = f1594a.c(strA);
        if (typefaceC != null) {
            aVar.b(new e(typefaceC));
            return typefaceC;
        }
        b bVar = new b(aVar);
        synchronized (f1596c) {
            androidx.collection.g<String, ArrayList<androidx.core.util.a<e>>> gVar = f1597d;
            ArrayList<androidx.core.util.a<e>> arrayList = gVar.get(strA);
            if (arrayList != null) {
                arrayList.add(bVar);
                return null;
            }
            ArrayList<androidx.core.util.a<e>> arrayList2 = new ArrayList<>();
            arrayList2.add(bVar);
            gVar.put(strA, arrayList2);
            c cVar = new c(strA, context, eVar, i2);
            if (executor == null) {
                executor = f1595b;
            }
            g.b(executor, cVar, new d(strA));
            return null;
        }
    }

    static Typeface e(@NonNull Context context, @NonNull androidx.core.provider.e eVar, @NonNull androidx.core.provider.a aVar, int i2, int i3) {
        String strA = a(eVar, i2);
        Typeface typefaceC = f1594a.c(strA);
        if (typefaceC != null) {
            aVar.b(new e(typefaceC));
            return typefaceC;
        }
        if (i3 == -1) {
            e eVarC = c(strA, context, eVar, i2);
            aVar.b(eVarC);
            return eVarC.f1608a;
        }
        try {
            e eVar2 = (e) g.c(f1595b, new a(strA, context, eVar, i2), i3);
            aVar.b(eVar2);
            return eVar2.f1608a;
        } catch (InterruptedException unused) {
            aVar.b(new e(-3));
            return null;
        }
    }

    /* compiled from: FontRequestWorker.java */
    static final class e {

        /* renamed from: a, reason: collision with root package name */
        final Typeface f1608a;

        /* renamed from: b, reason: collision with root package name */
        final int f1609b;

        e(int i2) {
            this.f1608a = null;
            this.f1609b = i2;
        }

        @SuppressLint({"WrongConstant"})
        boolean a() {
            return this.f1609b == 0;
        }

        @SuppressLint({"WrongConstant"})
        e(@NonNull Typeface typeface) {
            this.f1608a = typeface;
            this.f1609b = 0;
        }
    }
}
