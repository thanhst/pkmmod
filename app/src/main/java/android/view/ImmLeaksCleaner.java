package android.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.k;
import androidx.lifecycle.m;
import java.lang.reflect.Field;

@RequiresApi(19)
/* loaded from: classes.dex */
final class ImmLeaksCleaner implements k {

    /* renamed from: b, reason: collision with root package name */
    private static int f19b;

    /* renamed from: c, reason: collision with root package name */
    private static Field f20c;

    /* renamed from: d, reason: collision with root package name */
    private static Field f21d;

    /* renamed from: e, reason: collision with root package name */
    private static Field f22e;

    /* renamed from: a, reason: collision with root package name */
    private Activity f23a;

    ImmLeaksCleaner(Activity activity) {
        this.f23a = activity;
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    @MainThread
    private static void h() throws NoSuchFieldException, SecurityException {
        try {
            f19b = 2;
            Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
            f21d = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
            f22e = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
            f20c = declaredField3;
            declaredField3.setAccessible(true);
            f19b = 1;
        } catch (NoSuchFieldException unused) {
        }
    }

    @Override // androidx.lifecycle.k
    public void d(@NonNull m mVar, @NonNull Lifecycle.Event event) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        if (event != Lifecycle.Event.ON_DESTROY) {
            return;
        }
        if (f19b == 0) {
            h();
        }
        if (f19b == 1) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f23a.getSystemService("input_method");
            try {
                Object obj = f20c.get(inputMethodManager);
                if (obj == null) {
                    return;
                }
                synchronized (obj) {
                    try {
                        try {
                            View view = (View) f21d.get(inputMethodManager);
                            if (view == null) {
                                return;
                            }
                            if (view.isAttachedToWindow()) {
                                return;
                            }
                            try {
                                f22e.set(inputMethodManager, null);
                                inputMethodManager.isActive();
                            } catch (IllegalAccessException unused) {
                            }
                        } catch (ClassCastException unused2) {
                        } catch (IllegalAccessException unused3) {
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (IllegalAccessException unused4) {
            }
        }
    }
}
