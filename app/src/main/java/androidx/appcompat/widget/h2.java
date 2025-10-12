package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: TintContextWrapper.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class h2 extends ContextWrapper {

    /* renamed from: c, reason: collision with root package name */
    private static final Object f958c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private static ArrayList<WeakReference<h2>> f959d;

    /* renamed from: a, reason: collision with root package name */
    private final Resources f960a;

    /* renamed from: b, reason: collision with root package name */
    private final Resources.Theme f961b;

    private h2(@NonNull Context context) {
        super(context);
        if (!u2.c()) {
            this.f960a = new j2(this, context.getResources());
            this.f961b = null;
            return;
        }
        u2 u2Var = new u2(this, context.getResources());
        this.f960a = u2Var;
        Resources.Theme themeNewTheme = u2Var.newTheme();
        this.f961b = themeNewTheme;
        themeNewTheme.setTo(context.getTheme());
    }

    private static boolean a(@NonNull Context context) {
        if ((context instanceof h2) || (context.getResources() instanceof j2) || (context.getResources() instanceof u2)) {
            return false;
        }
        return Build.VERSION.SDK_INT < 21 || u2.c();
    }

    public static Context b(@NonNull Context context) {
        if (!a(context)) {
            return context;
        }
        synchronized (f958c) {
            ArrayList<WeakReference<h2>> arrayList = f959d;
            if (arrayList == null) {
                f959d = new ArrayList<>();
            } else {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    WeakReference<h2> weakReference = f959d.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        f959d.remove(size);
                    }
                }
                for (int size2 = f959d.size() - 1; size2 >= 0; size2--) {
                    WeakReference<h2> weakReference2 = f959d.get(size2);
                    h2 h2Var = weakReference2 != null ? weakReference2.get() : null;
                    if (h2Var != null && h2Var.getBaseContext() == context) {
                        return h2Var;
                    }
                }
            }
            h2 h2Var2 = new h2(context);
            f959d.add(new WeakReference<>(h2Var2));
            return h2Var2;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.f960a.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.f960a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f961b;
        return theme == null ? super.getTheme() : theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i2) {
        Resources.Theme theme = this.f961b;
        if (theme == null) {
            super.setTheme(i2);
        } else {
            theme.applyStyle(i2, true);
        }
    }
}
