package android.view;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.MainThread;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.k;
import androidx.lifecycle.m;
import i.b_i;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SavedStateRegistry.kt */
@Metadata(bv = {}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0003\u0019\u0005\nB\t\b\u0000¢\u0006\u0004\b,\u0010-J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0010\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\u000e\u001a\u00020\b2\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000bH\u0007J\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0014\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0004H\u0007R \u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u001dR\u0018\u0010 \u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u001fR$\u0010#\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u001c8G@BX\u0086\u000e¢\u0006\f\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010$R\u0018\u0010'\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010&R\"\u0010+\u001a\u00020\u001c8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u001d\u001a\u0004\b(\u0010$\"\u0004\b)\u0010*¨\u0006."}, d2 = {"Landroidx/savedstate/b;", "", "", "key", "Landroid/os/Bundle;", "b", "Landroidx/savedstate/b$c;", "provider", "Lkotlin/t;", "h", "c", "Ljava/lang/Class;", "Landroidx/savedstate/b$a;", "clazz", "i", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "e", "(Landroidx/lifecycle/Lifecycle;)V", "savedState", "f", "(Landroid/os/Bundle;)V", "outBundle", "g", "Li/b;", "a", "Li/b;", "components", "", "Z", "attached", "Landroid/os/Bundle;", "restoredState", "<set-?>", "d", "isRestored", "()Z", "Landroidx/savedstate/Recreator$b;", "Landroidx/savedstate/Recreator$b;", "recreatorProvider", "isAllowingSavingState$savedstate_release", "setAllowingSavingState$savedstate_release", "(Z)V", "isAllowingSavingState", "<init>", "()V", "savedstate_release"}, k = 1, mv = {1, 6, 0})
@SuppressLint({"RestrictedApi"})
/* renamed from: androidx.savedstate.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0077b {

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final C0036b f2621g = new C0036b(null);

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean attached;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Bundle restoredState;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isRestored;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Recreator.b recreatorProvider;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b_i<String, c> components = new b_i<>();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isAllowingSavingState = true;

    /* compiled from: SavedStateRegistry.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Landroidx/savedstate/b$a;", "", "Landroidx/savedstate/d;", "owner", "Lkotlin/t;", "a", "savedstate_release"}, k = 1, mv = {1, 6, 0})
    /* renamed from: androidx.savedstate.b$a */
    public interface a {
        void a(@NotNull InterfaceC0079d interfaceC0079d);
    }

    /* compiled from: SavedStateRegistry.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Landroidx/savedstate/b$b;", "", "", "SAVED_COMPONENTS_KEY", "Ljava/lang/String;", "<init>", "()V", "savedstate_release"}, k = 1, mv = {1, 6, 0})
    /* renamed from: androidx.savedstate.b$b, reason: collision with other inner class name */
    private static final class C0036b {
        private C0036b() {
        }

        public /* synthetic */ C0036b(o oVar) {
            this();
        }
    }

    /* compiled from: SavedStateRegistry.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0004"}, d2 = {"Landroidx/savedstate/b$c;", "", "Landroid/os/Bundle;", "a", "savedstate_release"}, k = 1, mv = {1, 6, 0})
    /* renamed from: androidx.savedstate.b$c */
    public interface c {
        @NotNull
        Bundle a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(C0077b this$0, m mVar, Lifecycle.Event event) {
        s.e(this$0, "this$0");
        s.e(mVar, "<anonymous parameter 0>");
        s.e(event, "event");
        if (event == Lifecycle.Event.ON_START) {
            this$0.isAllowingSavingState = true;
        } else if (event == Lifecycle.Event.ON_STOP) {
            this$0.isAllowingSavingState = false;
        }
    }

    @MainThread
    @Nullable
    public final Bundle b(@NotNull String key) {
        s.e(key, "key");
        if (!this.isRestored) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component".toString());
        }
        Bundle bundle = this.restoredState;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle != null ? bundle.getBundle(key) : null;
        Bundle bundle3 = this.restoredState;
        if (bundle3 != null) {
            bundle3.remove(key);
        }
        Bundle bundle4 = this.restoredState;
        boolean z2 = false;
        if (bundle4 != null && !bundle4.isEmpty()) {
            z2 = true;
        }
        if (!z2) {
            this.restoredState = null;
        }
        return bundle2;
    }

    @Nullable
    public final c c(@NotNull String key) {
        s.e(key, "key");
        Iterator<Map.Entry<String, c>> it = this.components.iterator();
        while (it.hasNext()) {
            Map.Entry<String, c> components = it.next();
            s.d(components, "components");
            String key2 = components.getKey();
            c value = components.getValue();
            if (s.a(key2, key)) {
                return value;
            }
        }
        return null;
    }

    @MainThread
    public final void e(@NotNull Lifecycle lifecycle) {
        s.e(lifecycle, "lifecycle");
        if (!(!this.attached)) {
            throw new IllegalStateException("SavedStateRegistry was already attached.".toString());
        }
        lifecycle.a(new k() { // from class: androidx.savedstate.a
            @Override // androidx.lifecycle.k
            public final void d(m mVar, Lifecycle.Event event) {
                C0077b.d(this.f2620a, mVar, event);
            }
        });
        this.attached = true;
    }

    @MainThread
    public final void f(@Nullable Bundle savedState) {
        if (!this.attached) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).".toString());
        }
        if (!(!this.isRestored)) {
            throw new IllegalStateException("SavedStateRegistry was already restored.".toString());
        }
        this.restoredState = savedState != null ? savedState.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key") : null;
        this.isRestored = true;
    }

    @MainThread
    public final void g(@NotNull Bundle outBundle) {
        s.e(outBundle, "outBundle");
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.restoredState;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        b_i<String, c>.d dVarC = this.components.c();
        s.d(dVarC, "this.components.iteratorWithAdditions()");
        while (dVarC.hasNext()) {
            Map.Entry next = dVarC.next();
            bundle.putBundle((String) next.getKey(), ((c) next.getValue()).a());
        }
        if (bundle.isEmpty()) {
            return;
        }
        outBundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle);
    }

    @MainThread
    public final void h(@NotNull String key, @NotNull c provider) {
        s.e(key, "key");
        s.e(provider, "provider");
        if (!(this.components.f(key, provider) == null)) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered".toString());
        }
    }

    @MainThread
    public final void i(@NotNull Class<? extends a> clazz) throws NoSuchMethodException, SecurityException {
        s.e(clazz, "clazz");
        if (!this.isAllowingSavingState) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState".toString());
        }
        Recreator.b bVar = this.recreatorProvider;
        if (bVar == null) {
            bVar = new Recreator.b(this);
        }
        this.recreatorProvider = bVar;
        try {
            clazz.getDeclaredConstructor(new Class[0]);
            Recreator.b bVar2 = this.recreatorProvider;
            if (bVar2 != null) {
                String name = clazz.getName();
                s.d(name, "clazz.name");
                bVar2.b(name);
            }
        } catch (NoSuchMethodException e2) {
            throw new IllegalArgumentException("Class " + clazz.getSimpleName() + " must have default constructor in order to be automatically recreated", e2);
        }
    }
}
