package androidx.lifecycle;

import android.os.Bundle;
import android.view.C0077b;
import android.view.InterfaceC0079d;
import androidx.annotation.MainThread;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.b0;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
import s.a;

/* compiled from: SavedStateHandleSupport.kt */
@Metadata(bv = {}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a!\u0010\u0004\u001a\u00020\u0003\"\f\b\u0000\u0010\u0002*\u00020\u0000*\u00020\u0001*\u00028\u0000H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a*\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002\u001a\f\u0010\u000f\u001a\u00020\f*\u00020\u000eH\u0007\"\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00000\u00108\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0011\"\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u00108\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0011\"\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u00108\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0011\"\u0018\u0010\u0018\u001a\u00020\u0015*\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\"\u0018\u0010\u001c\u001a\u00020\u0019*\u00020\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Landroidx/savedstate/d;", "Landroidx/lifecycle/f0;", "T", "Lkotlin/t;", "c", "(Landroidx/savedstate/d;)V", "savedStateRegistryOwner", "viewModelStoreOwner", "", "key", "Landroid/os/Bundle;", "defaultArgs", "Landroidx/lifecycle/w;", "a", "Ls/a;", "b", "Ls/a$b;", "Ls/a$b;", "SAVED_STATE_REGISTRY_OWNER_KEY", "VIEW_MODEL_STORE_OWNER_KEY", "DEFAULT_ARGS_KEY", "Landroidx/lifecycle/x;", "e", "(Landroidx/lifecycle/f0;)Landroidx/lifecycle/x;", "savedStateHandlesVM", "Landroidx/lifecycle/SavedStateHandlesProvider;", "d", "(Landroidx/savedstate/d;)Landroidx/lifecycle/SavedStateHandlesProvider;", "savedStateHandlesProvider", "lifecycle-viewmodel-savedstate_release"}, k = 2, mv = {1, 6, 0})
@JvmName(name = "SavedStateHandleSupport")
/* loaded from: classes.dex */
public final class SavedStateHandleSupport {

    /* renamed from: a, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final a.b<InterfaceC0079d> f2417a = new b();

    /* renamed from: b, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final a.b<f0> f2418b = new c();

    /* renamed from: c, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final a.b<Bundle> f2419c = new a();

    /* compiled from: SavedStateHandleSupport.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"androidx/lifecycle/SavedStateHandleSupport$a", "Ls/a$b;", "Landroid/os/Bundle;", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {1, 6, 0})
    public static final class a implements a.b<Bundle> {
        a() {
        }
    }

    /* compiled from: SavedStateHandleSupport.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"androidx/lifecycle/SavedStateHandleSupport$b", "Ls/a$b;", "Landroidx/savedstate/d;", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {1, 6, 0})
    public static final class b implements a.b<InterfaceC0079d> {
        b() {
        }
    }

    /* compiled from: SavedStateHandleSupport.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"androidx/lifecycle/SavedStateHandleSupport$c", "Ls/a$b;", "Landroidx/lifecycle/f0;", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {1, 6, 0})
    public static final class c implements a.b<f0> {
        c() {
        }
    }

    private static final w a(InterfaceC0079d interfaceC0079d, f0 f0Var, String str, Bundle bundle) {
        SavedStateHandlesProvider savedStateHandlesProviderD = d(interfaceC0079d);
        x xVarE = e(f0Var);
        w wVar = xVarE.f().get(str);
        if (wVar != null) {
            return wVar;
        }
        w wVarA = w.INSTANCE.a(savedStateHandlesProviderD.b(str), bundle);
        xVarE.f().put(str, wVarA);
        return wVarA;
    }

    @MainThread
    @NotNull
    public static final w b(@NotNull s.a aVar) {
        kotlin.jvm.internal.s.e(aVar, "<this>");
        InterfaceC0079d interfaceC0079d = (InterfaceC0079d) aVar.a(f2417a);
        if (interfaceC0079d == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
        }
        f0 f0Var = (f0) aVar.a(f2418b);
        if (f0Var == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        Bundle bundle = (Bundle) aVar.a(f2419c);
        String str = (String) aVar.a(b0.c.f2445c);
        if (str != null) {
            return a(interfaceC0079d, f0Var, str, bundle);
        }
        throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @MainThread
    public static final <T extends InterfaceC0079d & f0> void c(@NotNull T t2) {
        kotlin.jvm.internal.s.e(t2, "<this>");
        Lifecycle.State stateB = t2.getLifecycle().b();
        kotlin.jvm.internal.s.d(stateB, "lifecycle.currentState");
        if (!(stateB == Lifecycle.State.INITIALIZED || stateB == Lifecycle.State.CREATED)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (t2.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider") == null) {
            SavedStateHandlesProvider savedStateHandlesProvider = new SavedStateHandlesProvider(t2.getSavedStateRegistry(), t2);
            t2.getSavedStateRegistry().h("androidx.lifecycle.internal.SavedStateHandlesProvider", savedStateHandlesProvider);
            t2.getLifecycle().a(new SavedStateHandleAttacher(savedStateHandlesProvider));
        }
    }

    @NotNull
    public static final SavedStateHandlesProvider d(@NotNull InterfaceC0079d interfaceC0079d) {
        kotlin.jvm.internal.s.e(interfaceC0079d, "<this>");
        C0077b.c cVarC = interfaceC0079d.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider");
        SavedStateHandlesProvider savedStateHandlesProvider = cVarC instanceof SavedStateHandlesProvider ? (SavedStateHandlesProvider) cVarC : null;
        if (savedStateHandlesProvider != null) {
            return savedStateHandlesProvider;
        }
        throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
    }

    @NotNull
    public static final x e(@NotNull f0 f0Var) {
        kotlin.jvm.internal.s.e(f0Var, "<this>");
        s.c cVar = new s.c();
        cVar.a(kotlin.jvm.internal.v.b(x.class), new p0.l<s.a, x>() { // from class: androidx.lifecycle.SavedStateHandleSupport$savedStateHandlesVM$1$1
            @Override // p0.l
            @NotNull
            public final x invoke(@NotNull s.a initializer) {
                kotlin.jvm.internal.s.e(initializer, "$this$initializer");
                return new x();
            }
        });
        return (x) new b0(f0Var, cVar.b()).b("androidx.lifecycle.internal.SavedStateHandlesVM", x.class);
    }
}
