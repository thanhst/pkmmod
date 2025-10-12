package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.LocaleManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.LocaleList;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.AnyThread;
import androidx.annotation.CallSuper;
import androidx.annotation.DoNotInline;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.n;
import androidx.core.os.BuildCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class AppCompatDelegate {

    /* renamed from: e, reason: collision with root package name */
    static n.a f165e = new n.a(new n.b());

    /* renamed from: f, reason: collision with root package name */
    private static int f166f = -100;

    /* renamed from: g, reason: collision with root package name */
    private static androidx.core.os.g f167g = null;

    /* renamed from: h, reason: collision with root package name */
    private static androidx.core.os.g f168h = null;

    /* renamed from: i, reason: collision with root package name */
    private static Boolean f169i = null;

    /* renamed from: j, reason: collision with root package name */
    private static boolean f170j = false;

    /* renamed from: k, reason: collision with root package name */
    private static final androidx.collection.b<WeakReference<AppCompatDelegate>> f171k = new androidx.collection.b<>();

    /* renamed from: l, reason: collision with root package name */
    private static final Object f172l = new Object();

    /* renamed from: m, reason: collision with root package name */
    private static final Object f173m = new Object();

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface NightMode {
    }

    @RequiresApi(24)
    static class a {
        @DoNotInline
        static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }
    }

    @RequiresApi(33)
    static class b {
        @DoNotInline
        static LocaleList a(Object obj) {
            return ((LocaleManager) obj).getApplicationLocales();
        }

        @DoNotInline
        static void b(Object obj, LocaleList localeList) {
            ((LocaleManager) obj).setApplicationLocales(localeList);
        }
    }

    AppCompatDelegate() {
    }

    static void E(@NonNull AppCompatDelegate appCompatDelegate) {
        synchronized (f172l) {
            F(appCompatDelegate);
        }
    }

    private static void F(@NonNull AppCompatDelegate appCompatDelegate) {
        synchronized (f172l) {
            Iterator<WeakReference<AppCompatDelegate>> it = f171k.iterator();
            while (it.hasNext()) {
                AppCompatDelegate appCompatDelegate2 = it.next().get();
                if (appCompatDelegate2 == appCompatDelegate || appCompatDelegate2 == null) {
                    it.remove();
                }
            }
        }
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    static void N(final Context context) {
        if (u(context)) {
            if (BuildCompat.d()) {
                if (f170j) {
                    return;
                }
                f165e.execute(new Runnable() { // from class: androidx.appcompat.app.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        AppCompatDelegate.v(context);
                    }
                });
                return;
            }
            synchronized (f173m) {
                androidx.core.os.g gVar = f167g;
                if (gVar == null) {
                    if (f168h == null) {
                        f168h = androidx.core.os.g.c(n.b(context));
                    }
                    if (f168h.f()) {
                    } else {
                        f167g = f168h;
                    }
                } else if (!gVar.equals(f168h)) {
                    androidx.core.os.g gVar2 = f167g;
                    f168h = gVar2;
                    n.a(context, gVar2.h());
                }
            }
        }
    }

    static void d(@NonNull AppCompatDelegate appCompatDelegate) {
        synchronized (f172l) {
            F(appCompatDelegate);
            f171k.add(new WeakReference<>(appCompatDelegate));
        }
    }

    @NonNull
    public static AppCompatDelegate h(@NonNull Activity activity, @Nullable androidx.appcompat.app.b bVar) {
        return new d(activity, bVar);
    }

    @NonNull
    public static AppCompatDelegate i(@NonNull Dialog dialog, @Nullable androidx.appcompat.app.b bVar) {
        return new d(dialog, bVar);
    }

    @NonNull
    @AnyThread
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public static androidx.core.os.g k() {
        if (BuildCompat.d()) {
            Object objO = o();
            if (objO != null) {
                return androidx.core.os.g.i(b.a(objO));
            }
        } else {
            androidx.core.os.g gVar = f167g;
            if (gVar != null) {
                return gVar;
            }
        }
        return androidx.core.os.g.e();
    }

    public static int m() {
        return f166f;
    }

    @RequiresApi(33)
    static Object o() {
        Context contextL;
        Iterator<WeakReference<AppCompatDelegate>> it = f171k.iterator();
        while (it.hasNext()) {
            AppCompatDelegate appCompatDelegate = it.next().get();
            if (appCompatDelegate != null && (contextL = appCompatDelegate.l()) != null) {
                return contextL.getSystemService("locale");
            }
        }
        return null;
    }

    @Nullable
    static androidx.core.os.g q() {
        return f167g;
    }

    static boolean u(Context context) {
        if (f169i == null) {
            try {
                Bundle bundle = AppLocalesMetadataHolderService.a(context).metaData;
                if (bundle != null) {
                    f169i = Boolean.valueOf(bundle.getBoolean("autoStoreLocales"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.d("AppCompatDelegate", "Checking for metadata for AppLocalesMetadataHolderService : Service not found");
                f169i = Boolean.FALSE;
            }
        }
        return f169i.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void v(Context context) {
        n.c(context);
        f170j = true;
    }

    public abstract void A();

    public abstract void B(Bundle bundle);

    public abstract void C();

    public abstract void D();

    public abstract boolean G(int i2);

    public abstract void H(@LayoutRes int i2);

    public abstract void I(View view);

    public abstract void J(View view, ViewGroup.LayoutParams layoutParams);

    @RequiresApi(33)
    @CallSuper
    public void K(@Nullable OnBackInvokedDispatcher onBackInvokedDispatcher) {
    }

    public void L(@StyleRes int i2) {
    }

    public abstract void M(@Nullable CharSequence charSequence);

    public abstract void e(View view, ViewGroup.LayoutParams layoutParams);

    @Deprecated
    public void f(Context context) {
    }

    @NonNull
    @CallSuper
    public Context g(@NonNull Context context) {
        f(context);
        return context;
    }

    @Nullable
    public abstract <T extends View> T j(@IdRes int i2);

    @Nullable
    public Context l() {
        return null;
    }

    public int n() {
        return -100;
    }

    public abstract MenuInflater p();

    @Nullable
    public abstract ActionBar r();

    public abstract void s();

    public abstract void t();

    public abstract void w(Configuration configuration);

    public abstract void x(Bundle bundle);

    public abstract void y();

    public abstract void z(Bundle bundle);
}
