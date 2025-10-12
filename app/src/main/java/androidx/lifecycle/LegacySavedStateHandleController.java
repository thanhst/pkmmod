package androidx.lifecycle;

import android.os.Bundle;
import android.view.C0077b;
import android.view.InterfaceC0079d;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import java.util.Iterator;

/* loaded from: classes.dex */
class LegacySavedStateHandleController {

    static final class a implements C0077b.a {
        a() {
        }

        @Override // android.view.C0077b.a
        public void a(@NonNull InterfaceC0079d interfaceC0079d) throws NoSuchMethodException, SecurityException {
            if (!(interfaceC0079d instanceof f0)) {
                throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner");
            }
            e0 viewModelStore = ((f0) interfaceC0079d).getViewModelStore();
            C0077b savedStateRegistry = interfaceC0079d.getSavedStateRegistry();
            Iterator<String> it = viewModelStore.c().iterator();
            while (it.hasNext()) {
                LegacySavedStateHandleController.a(viewModelStore.b(it.next()), savedStateRegistry, interfaceC0079d.getLifecycle());
            }
            if (viewModelStore.c().isEmpty()) {
                return;
            }
            savedStateRegistry.i(a.class);
        }
    }

    static void a(a0 a0Var, C0077b c0077b, Lifecycle lifecycle) {
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) a0Var.c("androidx.lifecycle.savedstate.vm.tag");
        if (savedStateHandleController == null || savedStateHandleController.j()) {
            return;
        }
        savedStateHandleController.h(c0077b, lifecycle);
        c(c0077b, lifecycle);
    }

    static SavedStateHandleController b(C0077b c0077b, Lifecycle lifecycle, String str, Bundle bundle) {
        SavedStateHandleController savedStateHandleController = new SavedStateHandleController(str, w.c(c0077b.b(str), bundle));
        savedStateHandleController.h(c0077b, lifecycle);
        c(c0077b, lifecycle);
        return savedStateHandleController;
    }

    private static void c(final C0077b c0077b, final Lifecycle lifecycle) throws NoSuchMethodException, SecurityException {
        Lifecycle.State stateB = lifecycle.b();
        if (stateB == Lifecycle.State.INITIALIZED || stateB.isAtLeast(Lifecycle.State.STARTED)) {
            c0077b.i(a.class);
        } else {
            lifecycle.a(new k() { // from class: androidx.lifecycle.LegacySavedStateHandleController.1
                @Override // androidx.lifecycle.k
                public void d(@NonNull m mVar, @NonNull Lifecycle.Event event) throws NoSuchMethodException, SecurityException {
                    if (event == Lifecycle.Event.ON_START) {
                        lifecycle.c(this);
                        c0077b.i(a.class);
                    }
                }
            });
        }
    }
}
