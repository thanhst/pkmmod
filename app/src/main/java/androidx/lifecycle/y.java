package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Bundle;
import android.view.C0077b;
import android.view.InterfaceC0079d;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.b0;
import com.facebook.bolts.AppLinks;
import java.io.IOException;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SavedStateViewModelFactory.kt */
@Metadata(bv = {}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0017\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010$\u001a\u00020#\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b%\u0010&J/\u0010\t\u001a\u00028\u0000\"\b\b\u0000\u0010\u0004*\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ-\u0010\r\u001a\u00028\u0000\"\b\b\u0000\u0010\u0004*\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u000f\u001a\u00028\u0000\"\b\b\u0000\u0010\u0004*\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0003H\u0017R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!¨\u0006'"}, d2 = {"Landroidx/lifecycle/y;", "Landroidx/lifecycle/b0$d;", "Landroidx/lifecycle/b0$b;", "Landroidx/lifecycle/a0;", "T", "Ljava/lang/Class;", "modelClass", "Ls/a;", AppLinks.KEY_NAME_EXTRAS, "b", "(Ljava/lang/Class;Ls/a;)Landroidx/lifecycle/a0;", "", "key", "d", "(Ljava/lang/String;Ljava/lang/Class;)Landroidx/lifecycle/a0;", "a", "(Ljava/lang/Class;)Landroidx/lifecycle/a0;", "viewModel", "Lkotlin/t;", "c", "Landroid/app/Application;", "Landroid/app/Application;", "application", "Landroidx/lifecycle/b0$b;", "factory", "Landroid/os/Bundle;", "Landroid/os/Bundle;", "defaultArgs", "Landroidx/lifecycle/Lifecycle;", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "Landroidx/savedstate/b;", "e", "Landroidx/savedstate/b;", "savedStateRegistry", "Landroidx/savedstate/d;", "owner", "<init>", "(Landroid/app/Application;Landroidx/savedstate/d;Landroid/os/Bundle;)V", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class y extends b0.d implements b0.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Application application;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b0.b factory;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Bundle defaultArgs;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Lifecycle lifecycle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private C0077b savedStateRegistry;

    @SuppressLint({"LambdaLast"})
    public y(@Nullable Application application, @NotNull InterfaceC0079d owner, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.e(owner, "owner");
        this.savedStateRegistry = owner.getSavedStateRegistry();
        this.lifecycle = owner.getLifecycle();
        this.defaultArgs = bundle;
        this.application = application;
        this.factory = application != null ? b0.a.INSTANCE.a(application) : new b0.a();
    }

    @Override // androidx.lifecycle.b0.b
    @NotNull
    public <T extends a0> T a(@NotNull Class<T> modelClass) {
        kotlin.jvm.internal.s.e(modelClass, "modelClass");
        String canonicalName = modelClass.getCanonicalName();
        if (canonicalName != null) {
            return (T) d(canonicalName, modelClass);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // androidx.lifecycle.b0.b
    @NotNull
    public <T extends a0> T b(@NotNull Class<T> modelClass, @NotNull s.a extras) {
        kotlin.jvm.internal.s.e(modelClass, "modelClass");
        kotlin.jvm.internal.s.e(extras, "extras");
        String str = (String) extras.a(b0.c.f2445c);
        if (str == null) {
            throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        }
        if (extras.a(SavedStateHandleSupport.f2417a) == null || extras.a(SavedStateHandleSupport.f2418b) == null) {
            if (this.lifecycle != null) {
                return (T) d(str, modelClass);
            }
            throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }
        Application application = (Application) extras.a(b0.a.f2440g);
        boolean zIsAssignableFrom = a.class.isAssignableFrom(modelClass);
        Constructor constructorC = (!zIsAssignableFrom || application == null) ? z.c(modelClass, z.f2488b) : z.c(modelClass, z.f2487a);
        return constructorC == null ? (T) this.factory.b(modelClass, extras) : (!zIsAssignableFrom || application == null) ? (T) z.d(modelClass, constructorC, SavedStateHandleSupport.b(extras)) : (T) z.d(modelClass, constructorC, application, SavedStateHandleSupport.b(extras));
    }

    @Override // androidx.lifecycle.b0.d
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void c(@NotNull a0 viewModel) {
        kotlin.jvm.internal.s.e(viewModel, "viewModel");
        Lifecycle lifecycle = this.lifecycle;
        if (lifecycle != null) {
            LegacySavedStateHandleController.a(viewModel, this.savedStateRegistry, lifecycle);
        }
    }

    @NotNull
    public final <T extends a0> T d(@NotNull String key, @NotNull Class<T> modelClass) throws IOException {
        T t2;
        Application application;
        kotlin.jvm.internal.s.e(key, "key");
        kotlin.jvm.internal.s.e(modelClass, "modelClass");
        if (this.lifecycle == null) {
            throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        }
        boolean zIsAssignableFrom = a.class.isAssignableFrom(modelClass);
        Constructor constructorC = (!zIsAssignableFrom || this.application == null) ? z.c(modelClass, z.f2488b) : z.c(modelClass, z.f2487a);
        if (constructorC == null) {
            return this.application != null ? (T) this.factory.a(modelClass) : (T) b0.c.INSTANCE.a().a(modelClass);
        }
        SavedStateHandleController savedStateHandleControllerB = LegacySavedStateHandleController.b(this.savedStateRegistry, this.lifecycle, key, this.defaultArgs);
        if (!zIsAssignableFrom || (application = this.application) == null) {
            w wVarI = savedStateHandleControllerB.i();
            kotlin.jvm.internal.s.d(wVarI, "controller.handle");
            t2 = (T) z.d(modelClass, constructorC, wVarI);
        } else {
            kotlin.jvm.internal.s.b(application);
            w wVarI2 = savedStateHandleControllerB.i();
            kotlin.jvm.internal.s.d(wVarI2, "controller.handle");
            t2 = (T) z.d(modelClass, constructorC, application, wVarI2);
        }
        t2.e("androidx.lifecycle.savedstate.vm.tag", savedStateHandleControllerB);
        return t2;
    }
}
