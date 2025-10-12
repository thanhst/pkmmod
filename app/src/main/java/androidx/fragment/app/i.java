package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

/* compiled from: FragmentHostCallback.java */
/* loaded from: classes.dex */
public abstract class i<E> extends e {

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private final Activity f2251e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    private final Context f2252f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    private final Handler f2253g;

    /* renamed from: h, reason: collision with root package name */
    private final int f2254h;

    /* renamed from: i, reason: collision with root package name */
    final FragmentManager f2255i;

    i(@NonNull FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, new Handler(), 0);
    }

    @Override // androidx.fragment.app.e
    @Nullable
    public View c(int i2) {
        return null;
    }

    @Override // androidx.fragment.app.e
    public boolean d() {
        return true;
    }

    @Nullable
    Activity e() {
        return this.f2251e;
    }

    @NonNull
    Context f() {
        return this.f2252f;
    }

    @NonNull
    Handler g() {
        return this.f2253g;
    }

    @Nullable
    public abstract E h();

    @NonNull
    public LayoutInflater i() {
        return LayoutInflater.from(this.f2252f);
    }

    @Deprecated
    public void j(@NonNull Fragment fragment, @NonNull String[] strArr, int i2) {
    }

    public boolean k(@NonNull Fragment fragment) {
        return true;
    }

    public boolean l(@NonNull String str) {
        return false;
    }

    public void m(@NonNull Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i2, @Nullable Bundle bundle) {
        if (i2 != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        ContextCompat.i(this.f2252f, intent, bundle);
    }

    @Deprecated
    public void n(@NonNull Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i2, @Nullable Intent intent, int i3, int i4, int i5, @Nullable Bundle bundle) throws IntentSender.SendIntentException {
        if (i2 != -1) {
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
        androidx.core.app.b.v(this.f2251e, intentSender, i2, intent, i3, i4, i5, bundle);
    }

    public void o() {
    }

    i(@Nullable Activity activity, @NonNull Context context, @NonNull Handler handler, int i2) {
        this.f2255i = new l();
        this.f2251e = activity;
        this.f2252f = (Context) androidx.core.util.h.g(context, "context == null");
        this.f2253g = (Handler) androidx.core.util.h.g(handler, "handler == null");
        this.f2254h = i2;
    }
}
