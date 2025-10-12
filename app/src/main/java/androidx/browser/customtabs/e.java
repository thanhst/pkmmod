package androidx.browser.customtabs;

import a.b;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* compiled from: CustomTabsServiceConnection.java */
/* loaded from: classes.dex */
public abstract class e implements ServiceConnection {

    @Nullable
    private Context mApplicationContext;

    /* compiled from: CustomTabsServiceConnection.java */
    class a extends c {
        a(a.b bVar, ComponentName componentName, Context context) {
            super(bVar, componentName, context);
        }
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    Context getApplicationContext() {
        return this.mApplicationContext;
    }

    public abstract void onCustomTabsServiceConnected(@NonNull ComponentName componentName, @NonNull c cVar);

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(@NonNull ComponentName componentName, @NonNull IBinder iBinder) {
        if (this.mApplicationContext == null) {
            throw new IllegalStateException("Custom Tabs Service connected before an applicationcontext has been provided.");
        }
        onCustomTabsServiceConnected(componentName, new a(b.a.C(iBinder), componentName, this.mApplicationContext));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    void setApplicationContext(@NonNull Context context) {
        this.mApplicationContext = context;
    }
}
