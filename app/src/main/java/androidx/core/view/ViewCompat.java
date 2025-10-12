package androidx.core.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContentInfo;
import android.view.Display;
import android.view.KeyEvent;
import android.view.OnReceiveContentListener;
import android.view.View;
import android.view.View$OnApplyWindowInsetsListener;
import android.view.View$OnUnhandledKeyEventListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.core.R$id;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.a;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressLint({"PrivateConstructorForUtilityClass"})
/* loaded from: classes.dex */
public class ViewCompat {

    /* renamed from: b, reason: collision with root package name */
    private static WeakHashMap<View, String> f1654b;

    /* renamed from: d, reason: collision with root package name */
    private static Field f1656d;

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f1653a = new AtomicInteger(1);

    /* renamed from: c, reason: collision with root package name */
    private static WeakHashMap<View, y2> f1655c = null;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f1657e = false;

    /* renamed from: f, reason: collision with root package name */
    private static final int[] f1658f = {R$id.accessibility_custom_action_0, R$id.accessibility_custom_action_1, R$id.accessibility_custom_action_2, R$id.accessibility_custom_action_3, R$id.accessibility_custom_action_4, R$id.accessibility_custom_action_5, R$id.accessibility_custom_action_6, R$id.accessibility_custom_action_7, R$id.accessibility_custom_action_8, R$id.accessibility_custom_action_9, R$id.accessibility_custom_action_10, R$id.accessibility_custom_action_11, R$id.accessibility_custom_action_12, R$id.accessibility_custom_action_13, R$id.accessibility_custom_action_14, R$id.accessibility_custom_action_15, R$id.accessibility_custom_action_16, R$id.accessibility_custom_action_17, R$id.accessibility_custom_action_18, R$id.accessibility_custom_action_19, R$id.accessibility_custom_action_20, R$id.accessibility_custom_action_21, R$id.accessibility_custom_action_22, R$id.accessibility_custom_action_23, R$id.accessibility_custom_action_24, R$id.accessibility_custom_action_25, R$id.accessibility_custom_action_26, R$id.accessibility_custom_action_27, R$id.accessibility_custom_action_28, R$id.accessibility_custom_action_29, R$id.accessibility_custom_action_30, R$id.accessibility_custom_action_31};

    /* renamed from: g, reason: collision with root package name */
    private static final i0 f1659g = new i0() { // from class: androidx.core.view.l0
        @Override // androidx.core.view.i0
        public final ContentInfoCompat a(ContentInfoCompat contentInfoCompat) {
            return ViewCompat.D(contentInfoCompat);
        }
    };

    /* renamed from: h, reason: collision with root package name */
    private static final e f1660h = new e();

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface FocusDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface FocusRealDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface FocusRelativeDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface NestedScrollType {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface ScrollAxis {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface ScrollIndicators {
    }

    class a extends f<Boolean> {
        a(int i2, Class cls, int i3) {
            super(i2, cls, i3);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.ViewCompat.f
        @RequiresApi(28)
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Boolean d(@NonNull View view) {
            return Boolean.valueOf(n.d(view));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.ViewCompat.f
        @RequiresApi(28)
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void e(@NonNull View view, Boolean bool) {
            n.i(view, bool.booleanValue());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.ViewCompat.f
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public boolean h(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    class b extends f<CharSequence> {
        b(int i2, Class cls, int i3, int i4) {
            super(i2, cls, i3, i4);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.ViewCompat.f
        @RequiresApi(28)
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public CharSequence d(View view) {
            return n.b(view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.ViewCompat.f
        @RequiresApi(28)
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void e(View view, CharSequence charSequence) {
            n.h(view, charSequence);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.ViewCompat.f
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public boolean h(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    class c extends f<CharSequence> {
        c(int i2, Class cls, int i3, int i4) {
            super(i2, cls, i3, i4);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.ViewCompat.f
        @RequiresApi(30)
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public CharSequence d(View view) {
            return p.a(view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.ViewCompat.f
        @RequiresApi(30)
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void e(View view, CharSequence charSequence) {
            p.b(view, charSequence);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.ViewCompat.f
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public boolean h(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    class d extends f<Boolean> {
        d(int i2, Class cls, int i3) {
            super(i2, cls, i3);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.ViewCompat.f
        @RequiresApi(28)
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Boolean d(View view) {
            return Boolean.valueOf(n.c(view));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.ViewCompat.f
        @RequiresApi(28)
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void e(View view, Boolean bool) {
            n.g(view, bool.booleanValue());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.ViewCompat.f
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public boolean h(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    static class e implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        /* renamed from: e, reason: collision with root package name */
        private final WeakHashMap<View, Boolean> f1661e = new WeakHashMap<>();

        e() {
        }

        @RequiresApi(19)
        private void b(View view, boolean z2) {
            boolean z3 = view.isShown() && view.getWindowVisibility() == 0;
            if (z2 != z3) {
                ViewCompat.E(view, z3 ? 16 : 32);
                this.f1661e.put(view, Boolean.valueOf(z3));
            }
        }

        @RequiresApi(19)
        private void c(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        @RequiresApi(19)
        private void e(View view) {
            h.o(view.getViewTreeObserver(), this);
        }

        @RequiresApi(19)
        void a(View view) {
            this.f1661e.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
            view.addOnAttachStateChangeListener(this);
            if (j.b(view)) {
                c(view);
            }
        }

        @RequiresApi(19)
        void d(View view) {
            this.f1661e.remove(view);
            view.removeOnAttachStateChangeListener(this);
            e(view);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        @RequiresApi(19)
        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                for (Map.Entry<View, Boolean> entry : this.f1661e.entrySet()) {
                    b(entry.getKey(), entry.getValue().booleanValue());
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        @RequiresApi(19)
        public void onViewAttachedToWindow(View view) {
            c(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    static abstract class f<T> {

        /* renamed from: a, reason: collision with root package name */
        private final int f1662a;

        /* renamed from: b, reason: collision with root package name */
        private final Class<T> f1663b;

        /* renamed from: c, reason: collision with root package name */
        private final int f1664c;

        /* renamed from: d, reason: collision with root package name */
        private final int f1665d;

        f(int i2, Class<T> cls, int i3) {
            this(i2, cls, 0, i3);
        }

        private boolean b() {
            return true;
        }

        private boolean c() {
            return Build.VERSION.SDK_INT >= this.f1664c;
        }

        boolean a(Boolean bool, Boolean bool2) {
            return (bool != null && bool.booleanValue()) == (bool2 != null && bool2.booleanValue());
        }

        abstract T d(View view);

        abstract void e(View view, T t2);

        T f(View view) {
            if (c()) {
                return d(view);
            }
            if (!b()) {
                return null;
            }
            T t2 = (T) view.getTag(this.f1662a);
            if (this.f1663b.isInstance(t2)) {
                return t2;
            }
            return null;
        }

        void g(View view, T t2) {
            if (c()) {
                e(view, t2);
            } else if (b() && h(f(view), t2)) {
                ViewCompat.h(view);
                view.setTag(this.f1662a, t2);
                ViewCompat.E(view, this.f1665d);
            }
        }

        abstract boolean h(T t2, T t3);

        f(int i2, Class<T> cls, int i3, int i4) {
            this.f1662a = i2;
            this.f1663b = cls;
            this.f1665d = i3;
            this.f1664c = i4;
        }
    }

    @RequiresApi(15)
    static class g {
        @DoNotInline
        static boolean a(@NonNull View view) {
            return view.hasOnClickListeners();
        }
    }

    @RequiresApi(16)
    static class h {
        @DoNotInline
        static AccessibilityNodeProvider a(View view) {
            return view.getAccessibilityNodeProvider();
        }

        @DoNotInline
        static boolean b(View view) {
            return view.getFitsSystemWindows();
        }

        @DoNotInline
        static int c(View view) {
            return view.getImportantForAccessibility();
        }

        @DoNotInline
        static int d(View view) {
            return view.getMinimumHeight();
        }

        @DoNotInline
        static int e(View view) {
            return view.getMinimumWidth();
        }

        @DoNotInline
        static ViewParent f(View view) {
            return view.getParentForAccessibility();
        }

        @DoNotInline
        static int g(View view) {
            return view.getWindowSystemUiVisibility();
        }

        @DoNotInline
        static boolean h(View view) {
            return view.hasOverlappingRendering();
        }

        @DoNotInline
        static boolean i(View view) {
            return view.hasTransientState();
        }

        @DoNotInline
        static boolean j(View view, int i2, Bundle bundle) {
            return view.performAccessibilityAction(i2, bundle);
        }

        @DoNotInline
        static void k(View view) {
            view.postInvalidateOnAnimation();
        }

        @DoNotInline
        static void l(View view, int i2, int i3, int i4, int i5) {
            view.postInvalidateOnAnimation(i2, i3, i4, i5);
        }

        @DoNotInline
        static void m(View view, Runnable runnable) {
            view.postOnAnimation(runnable);
        }

        @DoNotInline
        static void n(View view, Runnable runnable, long j2) {
            view.postOnAnimationDelayed(runnable, j2);
        }

        @DoNotInline
        static void o(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }

        @DoNotInline
        static void p(View view) {
            view.requestFitSystemWindows();
        }

        @DoNotInline
        static void q(View view, Drawable drawable) {
            view.setBackground(drawable);
        }

        @DoNotInline
        static void r(View view, boolean z2) {
            view.setHasTransientState(z2);
        }

        @DoNotInline
        static void s(View view, int i2) {
            view.setImportantForAccessibility(i2);
        }
    }

    @RequiresApi(17)
    static class i {
        @DoNotInline
        static int a() {
            return View.generateViewId();
        }

        @DoNotInline
        static Display b(@NonNull View view) {
            return view.getDisplay();
        }

        @DoNotInline
        static int c(View view) {
            return view.getLabelFor();
        }

        @DoNotInline
        static int d(View view) {
            return view.getLayoutDirection();
        }

        @DoNotInline
        static int e(View view) {
            return view.getPaddingEnd();
        }

        @DoNotInline
        static int f(View view) {
            return view.getPaddingStart();
        }

        @DoNotInline
        static boolean g(View view) {
            return view.isPaddingRelative();
        }

        @DoNotInline
        static void h(View view, int i2) {
            view.setLabelFor(i2);
        }

        @DoNotInline
        static void i(View view, Paint paint) {
            view.setLayerPaint(paint);
        }

        @DoNotInline
        static void j(View view, int i2) {
            view.setLayoutDirection(i2);
        }

        @DoNotInline
        static void k(View view, int i2, int i3, int i4, int i5) {
            view.setPaddingRelative(i2, i3, i4, i5);
        }
    }

    @RequiresApi(19)
    static class j {
        @DoNotInline
        static int a(View view) {
            return view.getAccessibilityLiveRegion();
        }

        @DoNotInline
        static boolean b(@NonNull View view) {
            return view.isAttachedToWindow();
        }

        @DoNotInline
        static boolean c(@NonNull View view) {
            return view.isLaidOut();
        }

        @DoNotInline
        static boolean d(@NonNull View view) {
            return view.isLayoutDirectionResolved();
        }

        @DoNotInline
        static void e(ViewParent viewParent, View view, View view2, int i2) {
            viewParent.notifySubtreeAccessibilityStateChanged(view, view2, i2);
        }

        @DoNotInline
        static void f(View view, int i2) {
            view.setAccessibilityLiveRegion(i2);
        }

        @DoNotInline
        static void g(AccessibilityEvent accessibilityEvent, int i2) {
            accessibilityEvent.setContentChangeTypes(i2);
        }
    }

    @RequiresApi(20)
    static class k {
        @DoNotInline
        static WindowInsets a(View view, WindowInsets windowInsets) {
            return view.dispatchApplyWindowInsets(windowInsets);
        }

        @DoNotInline
        static WindowInsets b(View view, WindowInsets windowInsets) {
            return view.onApplyWindowInsets(windowInsets);
        }

        @DoNotInline
        static void c(View view) {
            view.requestApplyInsets();
        }
    }

    @RequiresApi(21)
    private static class l {

        class a implements View$OnApplyWindowInsetsListener {

            /* renamed from: a, reason: collision with root package name */
            WindowInsetsCompat f1666a = null;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ View f1667b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ g0 f1668c;

            a(View view, g0 g0Var) {
                this.f1667b = view;
                this.f1668c = g0Var;
            }

            @Override // android.view.View$OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                WindowInsetsCompat windowInsetsCompatV = WindowInsetsCompat.v(windowInsets, view);
                int i2 = Build.VERSION.SDK_INT;
                if (i2 < 30) {
                    l.a(windowInsets, this.f1667b);
                    if (windowInsetsCompatV.equals(this.f1666a)) {
                        return this.f1668c.a(view, windowInsetsCompatV).t();
                    }
                }
                this.f1666a = windowInsetsCompatV;
                WindowInsetsCompat windowInsetsCompatA = this.f1668c.a(view, windowInsetsCompatV);
                if (i2 >= 30) {
                    return windowInsetsCompatA.t();
                }
                ViewCompat.L(view);
                return windowInsetsCompatA.t();
            }
        }

        @DoNotInline
        static void a(@NonNull WindowInsets windowInsets, @NonNull View view) {
            View$OnApplyWindowInsetsListener view$OnApplyWindowInsetsListener = (View$OnApplyWindowInsetsListener) view.getTag(R$id.tag_window_insets_animation_callback);
            if (view$OnApplyWindowInsetsListener != null) {
                view$OnApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        @DoNotInline
        static WindowInsetsCompat b(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Rect rect) {
            WindowInsets windowInsetsT = windowInsetsCompat.t();
            if (windowInsetsT != null) {
                return WindowInsetsCompat.v(view.computeSystemWindowInsets(windowInsetsT, rect), view);
            }
            rect.setEmpty();
            return windowInsetsCompat;
        }

        @DoNotInline
        static boolean c(@NonNull View view, float f2, float f3, boolean z2) {
            return view.dispatchNestedFling(f2, f3, z2);
        }

        @DoNotInline
        static boolean d(@NonNull View view, float f2, float f3) {
            return view.dispatchNestedPreFling(f2, f3);
        }

        @DoNotInline
        static boolean e(View view, int i2, int i3, int[] iArr, int[] iArr2) {
            return view.dispatchNestedPreScroll(i2, i3, iArr, iArr2);
        }

        @DoNotInline
        static boolean f(View view, int i2, int i3, int i4, int i5, int[] iArr) {
            return view.dispatchNestedScroll(i2, i3, i4, i5, iArr);
        }

        @DoNotInline
        static ColorStateList g(View view) {
            return view.getBackgroundTintList();
        }

        @DoNotInline
        static PorterDuff.Mode h(View view) {
            return view.getBackgroundTintMode();
        }

        @DoNotInline
        static float i(View view) {
            return view.getElevation();
        }

        @Nullable
        @DoNotInline
        public static WindowInsetsCompat j(@NonNull View view) {
            return WindowInsetsCompat.a.a(view);
        }

        @DoNotInline
        static String k(View view) {
            return view.getTransitionName();
        }

        @DoNotInline
        static float l(View view) {
            return view.getTranslationZ();
        }

        @DoNotInline
        static float m(@NonNull View view) {
            return view.getZ();
        }

        @DoNotInline
        static boolean n(View view) {
            return view.hasNestedScrollingParent();
        }

        @DoNotInline
        static boolean o(View view) {
            return view.isImportantForAccessibility();
        }

        @DoNotInline
        static boolean p(View view) {
            return view.isNestedScrollingEnabled();
        }

        @DoNotInline
        static void q(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
        }

        @DoNotInline
        static void r(View view, PorterDuff.Mode mode) {
            view.setBackgroundTintMode(mode);
        }

        @DoNotInline
        static void s(View view, float f2) {
            view.setElevation(f2);
        }

        @DoNotInline
        static void t(View view, boolean z2) {
            view.setNestedScrollingEnabled(z2);
        }

        @DoNotInline
        static void u(@NonNull View view, @Nullable g0 g0Var) {
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(R$id.tag_on_apply_window_listener, g0Var);
            }
            if (g0Var == null) {
                view.setOnApplyWindowInsetsListener((View$OnApplyWindowInsetsListener) view.getTag(R$id.tag_window_insets_animation_callback));
            } else {
                view.setOnApplyWindowInsetsListener(new a(view, g0Var));
            }
        }

        @DoNotInline
        static void v(View view, String str) {
            view.setTransitionName(str);
        }

        @DoNotInline
        static void w(View view, float f2) {
            view.setTranslationZ(f2);
        }

        @DoNotInline
        static void x(@NonNull View view, float f2) {
            view.setZ(f2);
        }

        @DoNotInline
        static boolean y(View view, int i2) {
            return view.startNestedScroll(i2);
        }

        @DoNotInline
        static void z(View view) {
            view.stopNestedScroll();
        }
    }

    @RequiresApi(23)
    private static class m {
        @Nullable
        public static WindowInsetsCompat a(@NonNull View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            WindowInsetsCompat windowInsetsCompatU = WindowInsetsCompat.u(rootWindowInsets);
            windowInsetsCompatU.r(windowInsetsCompatU);
            windowInsetsCompatU.d(view.getRootView());
            return windowInsetsCompatU;
        }

        @DoNotInline
        static int b(@NonNull View view) {
            return view.getScrollIndicators();
        }

        @DoNotInline
        static void c(@NonNull View view, int i2) {
            view.setScrollIndicators(i2);
        }

        @DoNotInline
        static void d(@NonNull View view, int i2, int i3) {
            view.setScrollIndicators(i2, i3);
        }
    }

    @RequiresApi(28)
    static class n {
        @DoNotInline
        static void a(@NonNull View view, @NonNull final s sVar) {
            int i2 = R$id.tag_unhandled_key_listeners;
            androidx.collection.g gVar = (androidx.collection.g) view.getTag(i2);
            if (gVar == null) {
                gVar = new androidx.collection.g();
                view.setTag(i2, gVar);
            }
            Objects.requireNonNull(sVar);
            View$OnUnhandledKeyEventListener view$OnUnhandledKeyEventListener = new View$OnUnhandledKeyEventListener() { // from class: androidx.core.view.y1
                public final boolean onUnhandledKeyEvent(View view2, KeyEvent keyEvent) {
                    return sVar.onUnhandledKeyEvent(view2, keyEvent);
                }
            };
            gVar.put(sVar, view$OnUnhandledKeyEventListener);
            view.addOnUnhandledKeyEventListener(view$OnUnhandledKeyEventListener);
        }

        @DoNotInline
        static CharSequence b(View view) {
            return view.getAccessibilityPaneTitle();
        }

        @DoNotInline
        static boolean c(View view) {
            return view.isAccessibilityHeading();
        }

        @DoNotInline
        static boolean d(View view) {
            return view.isScreenReaderFocusable();
        }

        @DoNotInline
        static void e(@NonNull View view, @NonNull s sVar) {
            View$OnUnhandledKeyEventListener view$OnUnhandledKeyEventListener;
            androidx.collection.g gVar = (androidx.collection.g) view.getTag(R$id.tag_unhandled_key_listeners);
            if (gVar == null || (view$OnUnhandledKeyEventListener = (View$OnUnhandledKeyEventListener) gVar.get(sVar)) == null) {
                return;
            }
            view.removeOnUnhandledKeyEventListener(view$OnUnhandledKeyEventListener);
        }

        @DoNotInline
        static <T> T f(View view, int i2) {
            return (T) view.requireViewById(i2);
        }

        @DoNotInline
        static void g(View view, boolean z2) {
            view.setAccessibilityHeading(z2);
        }

        @DoNotInline
        static void h(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        @DoNotInline
        static void i(View view, boolean z2) {
            view.setScreenReaderFocusable(z2);
        }
    }

    @RequiresApi(29)
    private static class o {
        @DoNotInline
        static View.AccessibilityDelegate a(View view) {
            return view.getAccessibilityDelegate();
        }

        @DoNotInline
        static List<Rect> b(View view) {
            return view.getSystemGestureExclusionRects();
        }

        @DoNotInline
        static void c(@NonNull View view, @NonNull Context context, @NonNull int[] iArr, @Nullable AttributeSet attributeSet, @NonNull TypedArray typedArray, int i2, int i3) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i2, i3);
        }

        @DoNotInline
        static void d(View view, List<Rect> list) {
            view.setSystemGestureExclusionRects(list);
        }
    }

    @RequiresApi(30)
    private static class p {
        @DoNotInline
        static CharSequence a(View view) {
            return view.getStateDescription();
        }

        @DoNotInline
        static void b(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }
    }

    @RequiresApi(31)
    private static final class q {
        @Nullable
        @DoNotInline
        public static String[] a(@NonNull View view) {
            return view.getReceiveContentMimeTypes();
        }

        @Nullable
        @DoNotInline
        public static ContentInfoCompat b(@NonNull View view, @NonNull ContentInfoCompat contentInfoCompat) {
            ContentInfo contentInfoF = contentInfoCompat.f();
            ContentInfo contentInfoPerformReceiveContent = view.performReceiveContent(contentInfoF);
            if (contentInfoPerformReceiveContent == null) {
                return null;
            }
            return contentInfoPerformReceiveContent == contentInfoF ? contentInfoCompat : ContentInfoCompat.g(contentInfoPerformReceiveContent);
        }

        @DoNotInline
        public static void c(@NonNull View view, @Nullable String[] strArr, @Nullable h0 h0Var) {
            if (h0Var == null) {
                view.setOnReceiveContentListener(strArr, null);
            } else {
                view.setOnReceiveContentListener(strArr, new r(h0Var));
            }
        }
    }

    @RequiresApi(31)
    private static final class r implements OnReceiveContentListener {

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        private final h0 f1669a;

        r(@NonNull h0 h0Var) {
            this.f1669a = h0Var;
        }

        @Nullable
        public ContentInfo onReceiveContent(@NonNull View view, @NonNull ContentInfo contentInfo) {
            ContentInfoCompat contentInfoCompatG = ContentInfoCompat.g(contentInfo);
            ContentInfoCompat contentInfoCompatA = this.f1669a.a(view, contentInfoCompatG);
            if (contentInfoCompatA == null) {
                return null;
            }
            return contentInfoCompatA == contentInfoCompatG ? contentInfo : contentInfoCompatA.f();
        }
    }

    public interface s {
        boolean onUnhandledKeyEvent(@NonNull View view, @NonNull KeyEvent keyEvent);
    }

    static class t {

        /* renamed from: d, reason: collision with root package name */
        private static final ArrayList<WeakReference<View>> f1670d = new ArrayList<>();

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        private WeakHashMap<View, Boolean> f1671a = null;

        /* renamed from: b, reason: collision with root package name */
        private SparseArray<WeakReference<View>> f1672b = null;

        /* renamed from: c, reason: collision with root package name */
        private WeakReference<KeyEvent> f1673c = null;

        t() {
        }

        static t a(View view) {
            int i2 = R$id.tag_unhandled_key_event_manager;
            t tVar = (t) view.getTag(i2);
            if (tVar != null) {
                return tVar;
            }
            t tVar2 = new t();
            view.setTag(i2, tVar2);
            return tVar2;
        }

        @Nullable
        private View c(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.f1671a;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View viewC = c(viewGroup.getChildAt(childCount), keyEvent);
                        if (viewC != null) {
                            return viewC;
                        }
                    }
                }
                if (e(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        private SparseArray<WeakReference<View>> d() {
            if (this.f1672b == null) {
                this.f1672b = new SparseArray<>();
            }
            return this.f1672b;
        }

        private boolean e(@NonNull View view, @NonNull KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(R$id.tag_unhandled_key_listeners);
            if (arrayList == null) {
                return false;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (((s) arrayList.get(size)).onUnhandledKeyEvent(view, keyEvent)) {
                    return true;
                }
            }
            return false;
        }

        private void g() {
            WeakHashMap<View, Boolean> weakHashMap = this.f1671a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList<WeakReference<View>> arrayList = f1670d;
            if (arrayList.isEmpty()) {
                return;
            }
            synchronized (arrayList) {
                if (this.f1671a == null) {
                    this.f1671a = new WeakHashMap<>();
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ArrayList<WeakReference<View>> arrayList2 = f1670d;
                    View view = arrayList2.get(size).get();
                    if (view == null) {
                        arrayList2.remove(size);
                    } else {
                        this.f1671a.put(view, Boolean.TRUE);
                        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                            this.f1671a.put((View) parent, Boolean.TRUE);
                        }
                    }
                }
            }
        }

        boolean b(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                g();
            }
            View viewC = c(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (viewC != null && !KeyEvent.isModifierKey(keyCode)) {
                    d().put(keyCode, new WeakReference<>(viewC));
                }
            }
            return viewC != null;
        }

        boolean f(KeyEvent keyEvent) {
            int iIndexOfKey;
            WeakReference<KeyEvent> weakReference = this.f1673c;
            if (weakReference != null && weakReference.get() == keyEvent) {
                return false;
            }
            this.f1673c = new WeakReference<>(keyEvent);
            WeakReference<View> weakReferenceValueAt = null;
            SparseArray<WeakReference<View>> sparseArrayD = d();
            if (keyEvent.getAction() == 1 && (iIndexOfKey = sparseArrayD.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                weakReferenceValueAt = sparseArrayD.valueAt(iIndexOfKey);
                sparseArrayD.removeAt(iIndexOfKey);
            }
            if (weakReferenceValueAt == null) {
                weakReferenceValueAt = sparseArrayD.get(keyEvent.getKeyCode());
            }
            if (weakReferenceValueAt == null) {
                return false;
            }
            View view = weakReferenceValueAt.get();
            if (view != null && ViewCompat.A(view)) {
                e(view, keyEvent);
            }
            return true;
        }
    }

    public static boolean A(@NonNull View view) {
        return j.b(view);
    }

    public static boolean B(@NonNull View view) {
        return j.c(view);
    }

    @UiThread
    public static boolean C(@NonNull View view) {
        Boolean boolF = N().f(view);
        return boolF != null && boolF.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ContentInfoCompat D(ContentInfoCompat contentInfoCompat) {
        return contentInfoCompat;
    }

    @RequiresApi(19)
    static void E(View view, int i2) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z2 = m(view) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (l(view) != 0 || z2) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z2 ? 32 : 2048);
                j.g(accessibilityEventObtain, i2);
                if (z2) {
                    accessibilityEventObtain.getText().add(m(view));
                    a0(view);
                }
                view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
                return;
            }
            if (i2 == 32) {
                AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(accessibilityEventObtain2);
                accessibilityEventObtain2.setEventType(32);
                j.g(accessibilityEventObtain2, i2);
                accessibilityEventObtain2.setSource(view);
                view.onPopulateAccessibilityEvent(accessibilityEventObtain2);
                accessibilityEventObtain2.getText().add(m(view));
                accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain2);
                return;
            }
            if (view.getParent() != null) {
                try {
                    j.e(view.getParent(), view, view, i2);
                } catch (AbstractMethodError e2) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e2);
                }
            }
        }
    }

    @NonNull
    public static WindowInsetsCompat F(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
        WindowInsets windowInsetsT;
        if (Build.VERSION.SDK_INT >= 21 && (windowInsetsT = windowInsetsCompat.t()) != null) {
            WindowInsets windowInsetsB = k.b(view, windowInsetsT);
            if (!windowInsetsB.equals(windowInsetsT)) {
                return WindowInsetsCompat.v(windowInsetsB, view);
            }
        }
        return windowInsetsCompat;
    }

    private static f<CharSequence> G() {
        return new b(R$id.tag_accessibility_pane_title, CharSequence.class, 8, 28);
    }

    @Nullable
    public static ContentInfoCompat H(@NonNull View view, @NonNull ContentInfoCompat contentInfoCompat) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + contentInfoCompat + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return q.b(view, contentInfoCompat);
        }
        h0 h0Var = (h0) view.getTag(R$id.tag_on_receive_content_listener);
        if (h0Var == null) {
            return p(view).a(contentInfoCompat);
        }
        ContentInfoCompat contentInfoCompatA = h0Var.a(view, contentInfoCompat);
        if (contentInfoCompatA == null) {
            return null;
        }
        return p(view).a(contentInfoCompatA);
    }

    public static void I(@NonNull View view) {
        h.k(view);
    }

    public static void J(@NonNull View view, @NonNull Runnable runnable) {
        h.m(view, runnable);
    }

    @SuppressLint({"LambdaLast"})
    public static void K(@NonNull View view, @NonNull Runnable runnable, long j2) {
        h.n(view, runnable, j2);
    }

    public static void L(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 20) {
            k.c(view);
        } else {
            h.p(view);
        }
    }

    public static void M(@NonNull View view, @NonNull @SuppressLint({"ContextFirst"}) Context context, @NonNull int[] iArr, @Nullable AttributeSet attributeSet, @NonNull TypedArray typedArray, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 29) {
            o.c(view, context, iArr, attributeSet, typedArray, i2, i3);
        }
    }

    private static f<Boolean> N() {
        return new a(R$id.tag_screen_reader_focusable, Boolean.class, 28);
    }

    public static void O(@NonNull View view, @Nullable androidx.core.view.a aVar) {
        if (aVar == null && (j(view) instanceof a.C0021a)) {
            aVar = new androidx.core.view.a();
        }
        view.setAccessibilityDelegate(aVar == null ? null : aVar.d());
    }

    @UiThread
    public static void P(@NonNull View view, boolean z2) {
        b().g(view, Boolean.valueOf(z2));
    }

    @UiThread
    public static void Q(@NonNull View view, @Nullable CharSequence charSequence) {
        G().g(view, charSequence);
        if (charSequence != null) {
            f1660h.a(view);
        } else {
            f1660h.d(view);
        }
    }

    public static void R(@NonNull View view, @Nullable Drawable drawable) {
        h.q(view, drawable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void S(@NonNull View view, @Nullable ColorStateList colorStateList) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 21) {
            if (view instanceof k0) {
                ((k0) view).setSupportBackgroundTintList(colorStateList);
                return;
            }
            return;
        }
        l.q(view, colorStateList);
        if (i2 == 21) {
            Drawable background = view.getBackground();
            boolean z2 = (l.g(view) == null && l.h(view) == null) ? false : true;
            if (background == null || !z2) {
                return;
            }
            if (background.isStateful()) {
                background.setState(view.getDrawableState());
            }
            h.q(view, background);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void T(@NonNull View view, @Nullable PorterDuff.Mode mode) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 21) {
            if (view instanceof k0) {
                ((k0) view).setSupportBackgroundTintMode(mode);
                return;
            }
            return;
        }
        l.r(view, mode);
        if (i2 == 21) {
            Drawable background = view.getBackground();
            boolean z2 = (l.g(view) == null && l.h(view) == null) ? false : true;
            if (background == null || !z2) {
                return;
            }
            if (background.isStateful()) {
                background.setState(view.getDrawableState());
            }
            h.q(view, background);
        }
    }

    public static void U(@NonNull View view, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            l.s(view, f2);
        }
    }

    @UiThread
    public static void V(@NonNull View view, int i2) {
        h.s(view, i2);
    }

    public static void W(@NonNull View view, @Nullable g0 g0Var) {
        if (Build.VERSION.SDK_INT >= 21) {
            l.u(view, g0Var);
        }
    }

    @UiThread
    public static void X(@NonNull View view, boolean z2) {
        N().g(view, Boolean.valueOf(z2));
    }

    public static void Y(@NonNull View view, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 23) {
            m.d(view, i2, i3);
        }
    }

    public static void Z(@NonNull View view, @Nullable String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            l.v(view, str);
            return;
        }
        if (f1654b == null) {
            f1654b = new WeakHashMap<>();
        }
        f1654b.put(view, str);
    }

    private static void a0(View view) {
        if (q(view) == 0) {
            V(view, 1);
        }
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            if (q((View) parent) == 4) {
                V(view, 2);
                return;
            }
        }
    }

    private static f<Boolean> b() {
        return new d(R$id.tag_accessibility_heading, Boolean.class, 28);
    }

    private static f<CharSequence> b0() {
        return new c(R$id.tag_state_description, CharSequence.class, 64, 30);
    }

    @NonNull
    public static y2 c(@NonNull View view) {
        if (f1655c == null) {
            f1655c = new WeakHashMap<>();
        }
        y2 y2Var = f1655c.get(view);
        if (y2Var != null) {
            return y2Var;
        }
        y2 y2Var2 = new y2(view);
        f1655c.put(view, y2Var2);
        return y2Var2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void c0(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            l.z(view);
        } else if (view instanceof a0) {
            ((a0) view).stopNestedScroll();
        }
    }

    @NonNull
    public static WindowInsetsCompat d(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Rect rect) {
        return Build.VERSION.SDK_INT >= 21 ? l.b(view, windowInsetsCompat, rect) : windowInsetsCompat;
    }

    @NonNull
    public static WindowInsetsCompat e(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
        WindowInsets windowInsetsT;
        if (Build.VERSION.SDK_INT >= 21 && (windowInsetsT = windowInsetsCompat.t()) != null) {
            WindowInsets windowInsetsA = k.a(view, windowInsetsT);
            if (!windowInsetsA.equals(windowInsetsT)) {
                return WindowInsetsCompat.v(windowInsetsA, view);
            }
        }
        return windowInsetsCompat;
    }

    @UiThread
    static boolean f(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return t.a(view).b(view, keyEvent);
    }

    @UiThread
    static boolean g(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return t.a(view).f(keyEvent);
    }

    static void h(@NonNull View view) {
        androidx.core.view.a aVarI = i(view);
        if (aVarI == null) {
            aVarI = new androidx.core.view.a();
        }
        O(view, aVarI);
    }

    @Nullable
    public static androidx.core.view.a i(@NonNull View view) {
        View.AccessibilityDelegate accessibilityDelegateJ = j(view);
        if (accessibilityDelegateJ == null) {
            return null;
        }
        return accessibilityDelegateJ instanceof a.C0021a ? ((a.C0021a) accessibilityDelegateJ).f1710a : new androidx.core.view.a(accessibilityDelegateJ);
    }

    @Nullable
    private static View.AccessibilityDelegate j(@NonNull View view) {
        return Build.VERSION.SDK_INT >= 29 ? o.a(view) : k(view);
    }

    @Nullable
    private static View.AccessibilityDelegate k(@NonNull View view) {
        if (f1657e) {
            return null;
        }
        if (f1656d == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f1656d = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f1657e = true;
                return null;
            }
        }
        try {
            Object obj = f1656d.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            f1657e = true;
            return null;
        }
    }

    public static int l(@NonNull View view) {
        return j.a(view);
    }

    @Nullable
    @UiThread
    public static CharSequence m(@NonNull View view) {
        return G().f(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static ColorStateList n(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return l.g(view);
        }
        if (view instanceof k0) {
            return ((k0) view).getSupportBackgroundTintList();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static PorterDuff.Mode o(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return l.h(view);
        }
        if (view instanceof k0) {
            return ((k0) view).getSupportBackgroundTintMode();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static i0 p(@NonNull View view) {
        return view instanceof i0 ? (i0) view : f1659g;
    }

    public static int q(@NonNull View view) {
        return h.c(view);
    }

    public static int r(@NonNull View view) {
        return i.d(view);
    }

    public static int s(@NonNull View view) {
        return h.d(view);
    }

    @Nullable
    public static String[] t(@NonNull View view) {
        return Build.VERSION.SDK_INT >= 31 ? q.a(view) : (String[]) view.getTag(R$id.tag_on_receive_content_mime_types);
    }

    @Nullable
    public static WindowInsetsCompat u(@NonNull View view) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            return m.a(view);
        }
        if (i2 >= 21) {
            return l.j(view);
        }
        return null;
    }

    @Nullable
    @UiThread
    public static CharSequence v(@NonNull View view) {
        return b0().f(view);
    }

    @Nullable
    public static String w(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return l.k(view);
        }
        WeakHashMap<View, String> weakHashMap = f1654b;
        if (weakHashMap == null) {
            return null;
        }
        return weakHashMap.get(view);
    }

    @Deprecated
    public static int x(@NonNull View view) {
        return h.g(view);
    }

    public static boolean y(@NonNull View view) {
        return g.a(view);
    }

    @UiThread
    public static boolean z(@NonNull View view) {
        Boolean boolF = b().f(view);
        return boolF != null && boolF.booleanValue();
    }
}
