package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
import s.a;

/* compiled from: ViewModelProvider.kt */
@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¨\u0006\u0004"}, d2 = {"Landroidx/lifecycle/f0;", "owner", "Ls/a;", "a", "lifecycle-viewmodel_release"}, k = 2, mv = {1, 6, 0})
@JvmName(name = "ViewModelProviderGetKt")
/* loaded from: classes.dex */
public final class d0 {
    @NotNull
    public static final s.a a(@NotNull f0 owner) {
        kotlin.jvm.internal.s.e(owner, "owner");
        if (!(owner instanceof i)) {
            return a.C0069a.f4091b;
        }
        s.a defaultViewModelCreationExtras = ((i) owner).getDefaultViewModelCreationExtras();
        kotlin.jvm.internal.s.d(defaultViewModelCreationExtras, "{\n        owner.defaultV…ModelCreationExtras\n    }");
        return defaultViewModelCreationExtras;
    }
}
