package androidx.core.widget;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: PopupWindowCompat.java */
/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    private static Method f1849a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f1850b;

    /* renamed from: c, reason: collision with root package name */
    private static Field f1851c;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f1852d;

    /* compiled from: PopupWindowCompat.java */
    @RequiresApi(19)
    static class a {
        @DoNotInline
        static void a(PopupWindow popupWindow, View view, int i2, int i3, int i4) {
            popupWindow.showAsDropDown(view, i2, i3, i4);
        }
    }

    /* compiled from: PopupWindowCompat.java */
    @RequiresApi(23)
    static class b {
        @DoNotInline
        static boolean a(PopupWindow popupWindow) {
            return popupWindow.getOverlapAnchor();
        }

        @DoNotInline
        static int b(PopupWindow popupWindow) {
            return popupWindow.getWindowLayoutType();
        }

        @DoNotInline
        static void c(PopupWindow popupWindow, boolean z2) {
            popupWindow.setOverlapAnchor(z2);
        }

        @DoNotInline
        static void d(PopupWindow popupWindow, int i2) {
            popupWindow.setWindowLayoutType(i2);
        }
    }

    public static void a(@NonNull PopupWindow popupWindow, boolean z2) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            b.c(popupWindow, z2);
            return;
        }
        if (i2 >= 21) {
            if (!f1852d) {
                try {
                    Field declaredField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                    f1851c = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException e2) {
                    Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e2);
                }
                f1852d = true;
            }
            Field field = f1851c;
            if (field != null) {
                try {
                    field.set(popupWindow, Boolean.valueOf(z2));
                } catch (IllegalAccessException e3) {
                    Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", e3);
                }
            }
        }
    }

    public static void b(@NonNull PopupWindow popupWindow, int i2) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (Build.VERSION.SDK_INT >= 23) {
            b.d(popupWindow, i2);
            return;
        }
        if (!f1850b) {
            try {
                Method declaredMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", Integer.TYPE);
                f1849a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Exception unused) {
            }
            f1850b = true;
        }
        Method method = f1849a;
        if (method != null) {
            try {
                method.invoke(popupWindow, Integer.valueOf(i2));
            } catch (Exception unused2) {
            }
        }
    }

    public static void c(@NonNull PopupWindow popupWindow, @NonNull View view, int i2, int i3, int i4) {
        a.a(popupWindow, view, i2, i3, i4);
    }
}
