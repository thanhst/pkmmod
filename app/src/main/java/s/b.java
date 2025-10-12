package s;

import androidx.lifecycle.a0;
import androidx.lifecycle.b0;
import androidx.lifecycle.c0;
import com.facebook.bolts.AppLinks;
import kotlin.Metadata;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: InitializerViewModelFactory.kt */
@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u001a\u0010\u000e\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u000b0\n\"\u0006\u0012\u0002\b\u00030\u000b¢\u0006\u0004\b\u000f\u0010\u0010J/\u0010\b\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tR \u0010\u000e\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u000b0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Ls/b;", "Landroidx/lifecycle/b0$b;", "Landroidx/lifecycle/a0;", "T", "Ljava/lang/Class;", "modelClass", "Ls/a;", AppLinks.KEY_NAME_EXTRAS, "b", "(Ljava/lang/Class;Ls/a;)Landroidx/lifecycle/a0;", "", "Ls/e;", "a", "[Ls/e;", "initializers", "<init>", "([Ls/e;)V", "lifecycle-viewmodel_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class b implements b0.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e<?>[] initializers;

    public b(@NotNull e<?>... initializers) {
        s.e(initializers, "initializers");
        this.initializers = initializers;
    }

    @Override // androidx.lifecycle.b0.b
    public /* synthetic */ a0 a(Class cls) {
        return c0.a(this, cls);
    }

    @Override // androidx.lifecycle.b0.b
    @NotNull
    public <T extends a0> T b(@NotNull Class<T> modelClass, @NotNull a extras) {
        s.e(modelClass, "modelClass");
        s.e(extras, "extras");
        T t2 = null;
        for (e<?> eVar : this.initializers) {
            if (s.a(eVar.a(), modelClass)) {
                T tInvoke = eVar.b().invoke(extras);
                t2 = tInvoke instanceof a0 ? tInvoke : null;
            }
        }
        if (t2 != null) {
            return t2;
        }
        throw new IllegalArgumentException("No initializer set for given class " + modelClass.getName());
    }
}
