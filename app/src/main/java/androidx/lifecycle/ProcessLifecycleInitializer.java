package androidx.lifecycle;

import android.content.Context;
import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class ProcessLifecycleInitializer implements w.a<m> {
    @Override // w.a
    @NonNull
    public List<Class<? extends w.a<?>>> a() {
        return Collections.emptyList();
    }

    @Override // w.a
    @NonNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public m b(@NonNull Context context) {
        if (!androidx.startup.a.e(context).g(ProcessLifecycleInitializer.class)) {
            throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily. \nPlease ensure that you have: \n<meta-data\n    android:name='androidx.lifecycle.ProcessLifecycleInitializer' \n    android:value='androidx.startup' /> \nunder InitializationProvider in your AndroidManifest.xml");
        }
        j.a(context);
        t.i(context);
        return t.h();
    }
}
