package s;

import androidx.lifecycle.a0;
import kotlin.Metadata;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import p0.l_p0;

/* compiled from: InitializerViewModelFactory.kt */
@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B.\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0002\b\u000b¢\u0006\u0004\b\u0010\u0010\u0011R \u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007R+\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0002\b\u000b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e¨\u0006\u0012"}, d2 = {"Ls/e;", "Landroidx/lifecycle/a0;", "T", "", "Ljava/lang/Class;", "a", "Ljava/lang/Class;", "()Ljava/lang/Class;", "clazz", "Lkotlin/Function1;", "Ls/a;", "Lkotlin/ExtensionFunctionType;", "b", "Lp0/l;", "()Lp0/l;", "initializer", "<init>", "(Ljava/lang/Class;Lp0/l;)V", "lifecycle-viewmodel_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class e_s<T extends a0> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Class<T> clazz;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final l_p0<a_s, T> initializer;

    /* JADX WARN: Multi-variable type inference failed */
    public e_s(@NotNull Class<T> clazz, @NotNull l_p0<? super a_s, ? extends T> initializer) {
        s.e(clazz, "clazz");
        s.e(initializer, "initializer");
        this.clazz = clazz;
        this.initializer = initializer;
    }

    @NotNull
    public final Class<T> a() {
        return this.clazz;
    }

    @NotNull
    public final l_p0<a_s, T> b() {
        return this.initializer;
    }
}
