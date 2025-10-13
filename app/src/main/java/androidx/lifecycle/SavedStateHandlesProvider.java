package androidx.lifecycle;

import android.os.Bundle;
import android.view.C0077b;
import java.util.Map;
import kotlin.Metadata;
import p0.a_p0;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SavedStateHandleSupport.kt */
@Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\nR\u0016\u0010\u000e\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\rR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0015\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u000f\u0010\u0014¨\u0006\u001a"}, d2 = {"Landroidx/lifecycle/SavedStateHandlesProvider;", "Landroidx/savedstate/b$c;", "Landroid/os/Bundle;", "a", "Lkotlin/t;", "d", "", "key", "b", "Landroidx/savedstate/b;", "Landroidx/savedstate/b;", "savedStateRegistry", "", "Z", "restored", "c", "Landroid/os/Bundle;", "restoredState", "Landroidx/lifecycle/x;", "Lkotlin/d;", "()Landroidx/lifecycle/x;", "viewModel", "Landroidx/lifecycle/f0;", "viewModelStoreOwner", "<init>", "(Landroidx/savedstate/b;Landroidx/lifecycle/f0;)V", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class SavedStateHandlesProvider implements C0077b.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final C0077b savedStateRegistry;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean restored;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Bundle restoredState;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final kotlin.d viewModel;

    public SavedStateHandlesProvider(@NotNull C0077b savedStateRegistry, @NotNull final f0 viewModelStoreOwner) {
        kotlin.jvm.internal.s.e(savedStateRegistry, "savedStateRegistry");
        kotlin.jvm.internal.s.e(viewModelStoreOwner, "viewModelStoreOwner");
        this.savedStateRegistry = savedStateRegistry;
        this.viewModel = kotlin.f.a(new a_p0<x>() { // from class: androidx.lifecycle.SavedStateHandlesProvider$viewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // p0.a
            @NotNull
            public final x invoke() {
                return SavedStateHandleSupport.e(viewModelStoreOwner);
            }
        });
    }

    private final x c() {
        return (x) this.viewModel.getValue();
    }

    @Override // android.view.C0077b.c
    @NotNull
    public Bundle a() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.restoredState;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        for (Map.Entry<String, w> entry : c().f().entrySet()) {
            String key = entry.getKey();
            Bundle bundleA = entry.getValue().getSavedStateProvider().a();
            if (!kotlin.jvm.internal.s.a(bundleA, Bundle.EMPTY)) {
                bundle.putBundle(key, bundleA);
            }
        }
        this.restored = false;
        return bundle;
    }

    @Nullable
    public final Bundle b(@NotNull String key) {
        kotlin.jvm.internal.s.e(key, "key");
        d();
        Bundle bundle = this.restoredState;
        Bundle bundle2 = bundle != null ? bundle.getBundle(key) : null;
        Bundle bundle3 = this.restoredState;
        if (bundle3 != null) {
            bundle3.remove(key);
        }
        Bundle bundle4 = this.restoredState;
        if (bundle4 != null && bundle4.isEmpty()) {
            this.restoredState = null;
        }
        return bundle2;
    }

    public final void d() {
        if (this.restored) {
            return;
        }
        this.restoredState = this.savedStateRegistry.b("androidx.lifecycle.internal.SavedStateHandlesProvider");
        this.restored = true;
        c();
    }
}
