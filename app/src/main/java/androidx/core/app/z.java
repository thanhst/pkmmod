package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: TaskStackBuilder.java */
/* loaded from: classes.dex */
public final class z implements Iterable<Intent> {

    /* renamed from: e, reason: collision with root package name */
    private final ArrayList<Intent> f1421e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    private final Context f1422f;

    /* compiled from: TaskStackBuilder.java */
    public interface a {
        @Nullable
        Intent c();
    }

    private z(Context context) {
        this.f1422f = context;
    }

    @NonNull
    public static z d(@NonNull Context context) {
        return new z(context);
    }

    @NonNull
    public z a(@NonNull Intent intent) {
        this.f1421e.add(intent);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public z b(@NonNull Activity activity) {
        Intent intentC = activity instanceof a ? ((a) activity).c() : null;
        if (intentC == null) {
            intentC = u.a(activity);
        }
        if (intentC != null) {
            ComponentName component = intentC.getComponent();
            if (component == null) {
                component = intentC.resolveActivity(this.f1422f.getPackageManager());
            }
            c(component);
            a(intentC);
        }
        return this;
    }

    @NonNull
    public z c(@NonNull ComponentName componentName) {
        int size = this.f1421e.size();
        try {
            Intent intentB = u.b(this.f1422f, componentName);
            while (intentB != null) {
                this.f1421e.add(size, intentB);
                intentB = u.b(this.f1422f, intentB.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e2);
        }
    }

    public void e() {
        f(null);
    }

    public void f(@Nullable Bundle bundle) {
        if (this.f1421e.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) this.f1421e.toArray(new Intent[0]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (ContextCompat.h(this.f1422f, intentArr, bundle)) {
            return;
        }
        Intent intent = new Intent(intentArr[intentArr.length - 1]);
        intent.addFlags(268435456);
        this.f1422f.startActivity(intent);
    }

    @Override // java.lang.Iterable
    @NonNull
    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f1421e.iterator();
    }
}
