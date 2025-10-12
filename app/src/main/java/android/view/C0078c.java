package android.view;

import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SavedStateRegistryController.kt */
@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00062\u00020\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0007R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0013¨\u0006\u0017"}, d2 = {"Landroidx/savedstate/c;", "", "Lkotlin/t;", "c", "Landroid/os/Bundle;", "savedState", "d", "outBundle", "e", "Landroidx/savedstate/d;", "a", "Landroidx/savedstate/d;", "owner", "Landroidx/savedstate/b;", "b", "Landroidx/savedstate/b;", "()Landroidx/savedstate/b;", "savedStateRegistry", "", "Z", "attached", "<init>", "(Landroidx/savedstate/d;)V", "savedstate_release"}, k = 1, mv = {1, 6, 0})
/* renamed from: androidx.savedstate.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0078c {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final InterfaceC0079d owner;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final C0077b savedStateRegistry;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean attached;

    /* compiled from: SavedStateRegistryController.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\b"}, d2 = {"Landroidx/savedstate/c$a;", "", "Landroidx/savedstate/d;", "owner", "Landroidx/savedstate/c;", "a", "<init>", "()V", "savedstate_release"}, k = 1, mv = {1, 6, 0})
    /* renamed from: androidx.savedstate.c$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(o oVar) {
            this();
        }

        @JvmStatic
        @NotNull
        public final C0078c a(@NotNull InterfaceC0079d owner) {
            s.e(owner, "owner");
            return new C0078c(owner, null);
        }
    }

    private C0078c(InterfaceC0079d interfaceC0079d) {
        this.owner = interfaceC0079d;
        this.savedStateRegistry = new C0077b();
    }

    public /* synthetic */ C0078c(InterfaceC0079d interfaceC0079d, o oVar) {
        this(interfaceC0079d);
    }

    @JvmStatic
    @NotNull
    public static final C0078c a(@NotNull InterfaceC0079d interfaceC0079d) {
        return INSTANCE.a(interfaceC0079d);
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final C0077b getSavedStateRegistry() {
        return this.savedStateRegistry;
    }

    @MainThread
    public final void c() {
        Lifecycle lifecycle = this.owner.getLifecycle();
        s.d(lifecycle, "owner.lifecycle");
        if (!(lifecycle.b() == Lifecycle.State.INITIALIZED)) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage".toString());
        }
        lifecycle.a(new Recreator(this.owner));
        this.savedStateRegistry.e(lifecycle);
        this.attached = true;
    }

    @MainThread
    public final void d(@Nullable Bundle bundle) {
        if (!this.attached) {
            c();
        }
        Lifecycle lifecycle = this.owner.getLifecycle();
        s.d(lifecycle, "owner.lifecycle");
        if (!lifecycle.b().isAtLeast(Lifecycle.State.STARTED)) {
            this.savedStateRegistry.f(bundle);
            return;
        }
        throw new IllegalStateException(("performRestore cannot be called when owner is " + lifecycle.b()).toString());
    }

    @MainThread
    public final void e(@NotNull Bundle outBundle) {
        s.e(outBundle, "outBundle");
        this.savedStateRegistry.g(outBundle);
    }
}
