package android.view.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.j;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.k;
import androidx.lifecycle.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/* loaded from: classes.dex */
public abstract class ActivityResultRegistry {

    /* renamed from: a, reason: collision with root package name */
    private Random f50a = new Random();

    /* renamed from: b, reason: collision with root package name */
    private final Map<Integer, String> f51b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    final Map<String, Integer> f52c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private final Map<String, d> f53d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    ArrayList<String> f54e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    final transient Map<String, c<?>> f55f = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    final Map<String, Object> f56g = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    final Bundle f57h = new Bundle();

    /* JADX INFO: Add missing generic type declarations: [I] */
    class a<I> extends android.view.result.b<I> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f62a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.a f63b;

        a(String str, d.a aVar) {
            this.f62a = str;
            this.f63b = aVar;
        }

        @Override // android.view.result.b
        @NonNull
        public d.a<I, ?> a() {
            return this.f63b;
        }

        @Override // android.view.result.b
        public void c(I i2, @Nullable j jVar) throws Exception {
            Integer num = ActivityResultRegistry.this.f52c.get(this.f62a);
            if (num != null) {
                ActivityResultRegistry.this.f54e.add(this.f62a);
                try {
                    ActivityResultRegistry.this.f(num.intValue(), this.f63b, i2, jVar);
                    return;
                } catch (Exception e2) {
                    ActivityResultRegistry.this.f54e.remove(this.f62a);
                    throw e2;
                }
            }
            throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + this.f63b + " and input " + i2 + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
        }

        @Override // android.view.result.b
        public void d() {
            ActivityResultRegistry.this.l(this.f62a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [I] */
    class b<I> extends android.view.result.b<I> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f65a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.a f66b;

        b(String str, d.a aVar) {
            this.f65a = str;
            this.f66b = aVar;
        }

        @Override // android.view.result.b
        @NonNull
        public d.a<I, ?> a() {
            return this.f66b;
        }

        @Override // android.view.result.b
        public void c(I i2, @Nullable j jVar) throws Exception {
            Integer num = ActivityResultRegistry.this.f52c.get(this.f65a);
            if (num != null) {
                ActivityResultRegistry.this.f54e.add(this.f65a);
                try {
                    ActivityResultRegistry.this.f(num.intValue(), this.f66b, i2, jVar);
                    return;
                } catch (Exception e2) {
                    ActivityResultRegistry.this.f54e.remove(this.f65a);
                    throw e2;
                }
            }
            throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + this.f66b + " and input " + i2 + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
        }

        @Override // android.view.result.b
        public void d() {
            ActivityResultRegistry.this.l(this.f65a);
        }
    }

    private static class c<O> {

        /* renamed from: a, reason: collision with root package name */
        final android.view.result.a<O> f68a;

        /* renamed from: b, reason: collision with root package name */
        final d.a<?, O> f69b;

        c(android.view.result.a<O> aVar, d.a<?, O> aVar2) {
            this.f68a = aVar;
            this.f69b = aVar2;
        }
    }

    private static class d {

        /* renamed from: a, reason: collision with root package name */
        final Lifecycle f70a;

        /* renamed from: b, reason: collision with root package name */
        private final ArrayList<k> f71b = new ArrayList<>();

        d(@NonNull Lifecycle lifecycle) {
            this.f70a = lifecycle;
        }

        void a(@NonNull k kVar) {
            this.f70a.a(kVar);
            this.f71b.add(kVar);
        }

        void b() {
            Iterator<k> it = this.f71b.iterator();
            while (it.hasNext()) {
                this.f70a.c(it.next());
            }
            this.f71b.clear();
        }
    }

    private void a(int i2, String str) {
        this.f51b.put(Integer.valueOf(i2), str);
        this.f52c.put(str, Integer.valueOf(i2));
    }

    private <O> void d(String str, int i2, @Nullable Intent intent, @Nullable c<O> cVar) {
        if (cVar == null || cVar.f68a == null || !this.f54e.contains(str)) {
            this.f56g.remove(str);
            this.f57h.putParcelable(str, new ActivityResult(i2, intent));
        } else {
            cVar.f68a.onActivityResult(cVar.f69b.parseResult(i2, intent));
            this.f54e.remove(str);
        }
    }

    private int e() {
        int iNextInt = this.f50a.nextInt(2147418112);
        while (true) {
            int i2 = iNextInt + 65536;
            if (!this.f51b.containsKey(Integer.valueOf(i2))) {
                return i2;
            }
            iNextInt = this.f50a.nextInt(2147418112);
        }
    }

    private void k(String str) {
        if (this.f52c.get(str) != null) {
            return;
        }
        a(e(), str);
    }

    @MainThread
    public final boolean b(int i2, int i3, @Nullable Intent intent) {
        String str = this.f51b.get(Integer.valueOf(i2));
        if (str == null) {
            return false;
        }
        d(str, i3, intent, this.f55f.get(str));
        return true;
    }

    @MainThread
    public final <O> boolean c(int i2, @SuppressLint({"UnknownNullness"}) O o2) {
        android.view.result.a<?> aVar;
        String str = this.f51b.get(Integer.valueOf(i2));
        if (str == null) {
            return false;
        }
        c<?> cVar = this.f55f.get(str);
        if (cVar == null || (aVar = cVar.f68a) == null) {
            this.f57h.remove(str);
            this.f56g.put(str, o2);
            return true;
        }
        if (!this.f54e.remove(str)) {
            return true;
        }
        aVar.onActivityResult(o2);
        return true;
    }

    @MainThread
    public abstract <I, O> void f(int i2, @NonNull d.a<I, O> aVar, @SuppressLint({"UnknownNullness"}) I i3, @Nullable j jVar);

    public final void g(@Nullable Bundle bundle) {
        if (bundle == null) {
            return;
        }
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
        if (stringArrayList == null || integerArrayList == null) {
            return;
        }
        this.f54e = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
        this.f50a = (Random) bundle.getSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT");
        this.f57h.putAll(bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
        for (int i2 = 0; i2 < stringArrayList.size(); i2++) {
            String str = stringArrayList.get(i2);
            if (this.f52c.containsKey(str)) {
                Integer numRemove = this.f52c.remove(str);
                if (!this.f57h.containsKey(str)) {
                    this.f51b.remove(numRemove);
                }
            }
            a(integerArrayList.get(i2).intValue(), stringArrayList.get(i2));
        }
    }

    public final void h(@NonNull Bundle bundle) {
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(this.f52c.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(this.f52c.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(this.f54e));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) this.f57h.clone());
        bundle.putSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT", this.f50a);
    }

    @NonNull
    public final <I, O> android.view.result.b<I> i(@NonNull final String str, @NonNull m mVar, @NonNull final d.a<I, O> aVar, @NonNull final android.view.result.a<O> aVar2) {
        Lifecycle lifecycle = mVar.getLifecycle();
        if (lifecycle.b().isAtLeast(Lifecycle.State.STARTED)) {
            throw new IllegalStateException("LifecycleOwner " + mVar + " is attempting to register while current state is " + lifecycle.b() + ". LifecycleOwners must call register before they are STARTED.");
        }
        k(str);
        d dVar = this.f53d.get(str);
        if (dVar == null) {
            dVar = new d(lifecycle);
        }
        dVar.a(new k() { // from class: androidx.activity.result.ActivityResultRegistry.1
            @Override // androidx.lifecycle.k
            public void d(@NonNull m mVar2, @NonNull Lifecycle.Event event) {
                if (!Lifecycle.Event.ON_START.equals(event)) {
                    if (Lifecycle.Event.ON_STOP.equals(event)) {
                        ActivityResultRegistry.this.f55f.remove(str);
                        return;
                    } else {
                        if (Lifecycle.Event.ON_DESTROY.equals(event)) {
                            ActivityResultRegistry.this.l(str);
                            return;
                        }
                        return;
                    }
                }
                ActivityResultRegistry.this.f55f.put(str, new c<>(aVar2, aVar));
                if (ActivityResultRegistry.this.f56g.containsKey(str)) {
                    Object obj = ActivityResultRegistry.this.f56g.get(str);
                    ActivityResultRegistry.this.f56g.remove(str);
                    aVar2.onActivityResult(obj);
                }
                ActivityResult activityResult = (ActivityResult) ActivityResultRegistry.this.f57h.getParcelable(str);
                if (activityResult != null) {
                    ActivityResultRegistry.this.f57h.remove(str);
                    aVar2.onActivityResult(aVar.parseResult(activityResult.b(), activityResult.a()));
                }
            }
        });
        this.f53d.put(str, dVar);
        return new a(str, aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public final <I, O> android.view.result.b<I> j(@NonNull String str, @NonNull d.a<I, O> aVar, @NonNull android.view.result.a<O> aVar2) {
        k(str);
        this.f55f.put(str, new c<>(aVar2, aVar));
        if (this.f56g.containsKey(str)) {
            Object obj = this.f56g.get(str);
            this.f56g.remove(str);
            aVar2.onActivityResult(obj);
        }
        ActivityResult activityResult = (ActivityResult) this.f57h.getParcelable(str);
        if (activityResult != null) {
            this.f57h.remove(str);
            aVar2.onActivityResult(aVar.parseResult(activityResult.b(), activityResult.a()));
        }
        return new b(str, aVar);
    }

    @MainThread
    final void l(@NonNull String str) {
        Integer numRemove;
        if (!this.f54e.contains(str) && (numRemove = this.f52c.remove(str)) != null) {
            this.f51b.remove(numRemove);
        }
        this.f55f.remove(str);
        if (this.f56g.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f56g.get(str));
            this.f56g.remove(str);
        }
        if (this.f57h.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f57h.getParcelable(str));
            this.f57h.remove(str);
        }
        d dVar = this.f53d.get(str);
        if (dVar != null) {
            dVar.b();
            this.f53d.remove(str);
        }
    }
}
