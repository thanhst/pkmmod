package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: FragmentContainer.java */
/* loaded from: classes.dex */
public abstract class e {
    @NonNull
    @Deprecated
    public Fragment b(@NonNull Context context, @NonNull String str, @Nullable Bundle bundle) {
        return Fragment.instantiate(context, str, bundle);
    }

    @Nullable
    public abstract View c(@IdRes int i2);

    public abstract boolean d();
}
