package androidx.lifecycle;

import androidx.lifecycle.b0;
import org.jetbrains.annotations.NotNull;

/* compiled from: ViewModelProvider.kt */
/* loaded from: classes.dex */
public final /* synthetic */ class c0 {
    @NotNull
    public static a0 a(b0.b bVar, @NotNull Class modelClass) {
        kotlin.jvm.internal.s.e(modelClass, "modelClass");
        throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
    }

    @NotNull
    public static a0 b(b0.b bVar, @NotNull Class modelClass, @NotNull s.a extras) {
        kotlin.jvm.internal.s.e(modelClass, "modelClass");
        kotlin.jvm.internal.s.e(extras, "extras");
        return bVar.a(modelClass);
    }
}
