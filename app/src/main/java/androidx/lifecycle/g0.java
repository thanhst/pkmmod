package androidx.lifecycle;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.runtime.R$id;

/* compiled from: ViewTreeLifecycleOwner.java */
/* loaded from: classes.dex */
public class g0 {
    public static void a(@NonNull View view, @Nullable m mVar) {
        view.setTag(R$id.view_tree_lifecycle_owner, mVar);
    }
}
