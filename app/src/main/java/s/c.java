package s;

import androidx.lifecycle.a0;
import androidx.lifecycle.b0;
import androidx.lifecycle.viewmodel.ViewModelFactoryDsl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import p0.l;

/* compiled from: InitializerViewModelFactory.kt */
@Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J7\u0010\u000b\u001a\u00020\n\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\b\bJ\u0006\u0010\r\u001a\u00020\fR\u001e\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f0\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0010¨\u0006\u0014"}, d2 = {"Ls/c;", "", "Landroidx/lifecycle/a0;", "T", "Lkotlin/reflect/c;", "clazz", "Lkotlin/Function1;", "Ls/a;", "Lkotlin/ExtensionFunctionType;", "initializer", "Lkotlin/t;", "a", "Landroidx/lifecycle/b0$b;", "b", "", "Ls/e;", "Ljava/util/List;", "initializers", "<init>", "()V", "lifecycle-viewmodel_release"}, k = 1, mv = {1, 6, 0})
@ViewModelFactoryDsl
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<e<?>> initializers = new ArrayList();

    public final <T extends a0> void a(@NotNull kotlin.reflect.c<T> clazz, @NotNull l<? super a, ? extends T> initializer) {
        s.e(clazz, "clazz");
        s.e(initializer, "initializer");
        this.initializers.add(new e<>(o0.a.a(clazz), initializer));
    }

    @NotNull
    public final b0.b b() {
        Object[] array = this.initializers.toArray(new e[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        e[] eVarArr = (e[]) array;
        return new b((e[]) Arrays.copyOf(eVarArr, eVarArr.length));
    }
}
