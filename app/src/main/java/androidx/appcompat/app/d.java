package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.CallSuper;
import androidx.annotation.DoNotInline;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$color;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$style;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.b;
import androidx.appcompat.view.f;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.appcompat.widget.j1;
import androidx.appcompat.widget.k2;
import androidx.appcompat.widget.o1;
import androidx.appcompat.widget.u2;
import androidx.appcompat.widget.v2;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.h;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.a3;
import androidx.core.view.e;
import androidx.core.view.g0;
import androidx.core.view.y2;
import androidx.lifecycle.Lifecycle;
import com.facebook.internal.Utility;
import java.lang.Thread;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: AppCompatDelegateImpl.java */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
class d extends AppCompatDelegate implements e.a, LayoutInflater.Factory2 {

    /* renamed from: n0, reason: collision with root package name */
    private static final androidx.collection.g<String, Integer> f178n0 = new androidx.collection.g<>();

    /* renamed from: o0, reason: collision with root package name */
    private static final boolean f179o0;

    /* renamed from: p0, reason: collision with root package name */
    private static final int[] f180p0;

    /* renamed from: q0, reason: collision with root package name */
    private static final boolean f181q0;

    /* renamed from: r0, reason: collision with root package name */
    private static final boolean f182r0;

    /* renamed from: s0, reason: collision with root package name */
    private static boolean f183s0;
    PopupWindow A;
    Runnable B;
    y2 C;
    private boolean D;
    private boolean E;
    ViewGroup F;
    private TextView G;
    private View H;
    private boolean I;
    private boolean J;
    boolean K;
    boolean L;
    boolean M;
    boolean N;
    boolean O;
    private boolean P;
    private v[] Q;
    private v R;
    private boolean S;
    private boolean T;
    private boolean U;
    boolean V;
    private Configuration W;
    private int X;
    private int Y;
    private int Z;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f184a0;

    /* renamed from: b0, reason: collision with root package name */
    private r f185b0;

    /* renamed from: c0, reason: collision with root package name */
    private r f186c0;

    /* renamed from: d0, reason: collision with root package name */
    boolean f187d0;

    /* renamed from: e0, reason: collision with root package name */
    int f188e0;

    /* renamed from: f0, reason: collision with root package name */
    private final Runnable f189f0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f190g0;

    /* renamed from: h0, reason: collision with root package name */
    private Rect f191h0;

    /* renamed from: i0, reason: collision with root package name */
    private Rect f192i0;

    /* renamed from: j0, reason: collision with root package name */
    private androidx.appcompat.app.l f193j0;

    /* renamed from: k0, reason: collision with root package name */
    private androidx.appcompat.app.o f194k0;

    /* renamed from: l0, reason: collision with root package name */
    private OnBackInvokedDispatcher f195l0;

    /* renamed from: m0, reason: collision with root package name */
    private OnBackInvokedCallback f196m0;

    /* renamed from: n, reason: collision with root package name */
    final Object f197n;

    /* renamed from: o, reason: collision with root package name */
    final Context f198o;

    /* renamed from: p, reason: collision with root package name */
    Window f199p;

    /* renamed from: q, reason: collision with root package name */
    private p f200q;

    /* renamed from: r, reason: collision with root package name */
    final androidx.appcompat.app.b f201r;

    /* renamed from: s, reason: collision with root package name */
    ActionBar f202s;

    /* renamed from: t, reason: collision with root package name */
    MenuInflater f203t;

    /* renamed from: u, reason: collision with root package name */
    private CharSequence f204u;

    /* renamed from: v, reason: collision with root package name */
    private j1 f205v;

    /* renamed from: w, reason: collision with root package name */
    private i f206w;

    /* renamed from: x, reason: collision with root package name */
    private w f207x;

    /* renamed from: y, reason: collision with root package name */
    androidx.appcompat.view.b f208y;

    /* renamed from: z, reason: collision with root package name */
    ActionBarContextView f209z;

    /* compiled from: AppCompatDelegateImpl.java */
    class a implements Thread.UncaughtExceptionHandler {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Thread.UncaughtExceptionHandler f210a;

        a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f210a = uncaughtExceptionHandler;
        }

        private boolean a(Throwable th) {
            String message;
            if (!(th instanceof Resources.NotFoundException) || (message = th.getMessage()) == null) {
                return false;
            }
            return message.contains("drawable") || message.contains("Drawable");
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(@NonNull Thread thread, @NonNull Throwable th) {
            if (!a(th)) {
                this.f210a.uncaughtException(thread, th);
                return;
            }
            Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
            notFoundException.initCause(th.getCause());
            notFoundException.setStackTrace(th.getStackTrace());
            this.f210a.uncaughtException(thread, notFoundException);
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = d.this;
            if ((dVar.f188e0 & 1) != 0) {
                dVar.f0(0);
            }
            d dVar2 = d.this;
            if ((dVar2.f188e0 & 4096) != 0) {
                dVar2.f0(108);
            }
            d dVar3 = d.this;
            dVar3.f187d0 = false;
            dVar3.f188e0 = 0;
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    class c implements g0 {
        c() {
        }

        @Override // androidx.core.view.g0
        public WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            int iK = windowInsetsCompat.k();
            int iC1 = d.this.c1(windowInsetsCompat, null);
            if (iK != iC1) {
                windowInsetsCompat = windowInsetsCompat.o(windowInsetsCompat.i(), iC1, windowInsetsCompat.j(), windowInsetsCompat.h());
            }
            return ViewCompat.F(view, windowInsetsCompat);
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: androidx.appcompat.app.d$d, reason: collision with other inner class name */
    class C0006d implements o1.a {
        C0006d() {
        }

        @Override // androidx.appcompat.widget.o1.a
        public void a(Rect rect) {
            rect.top = d.this.c1(null, rect);
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    class e implements ContentFrameLayout.a {
        e() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void a() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void onDetachedFromWindow() {
            d.this.d0();
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    class f implements Runnable {

        /* compiled from: AppCompatDelegateImpl.java */
        class a extends a3 {
            a() {
            }

            @Override // androidx.core.view.z2
            public void b(View view) {
                d.this.f209z.setAlpha(1.0f);
                d.this.C.h(null);
                d.this.C = null;
            }

            @Override // androidx.core.view.a3, androidx.core.view.z2
            public void c(View view) {
                d.this.f209z.setVisibility(0);
            }
        }

        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = d.this;
            dVar.A.showAtLocation(dVar.f209z, 55, 0, 0);
            d.this.g0();
            if (!d.this.R0()) {
                d.this.f209z.setAlpha(1.0f);
                d.this.f209z.setVisibility(0);
            } else {
                d.this.f209z.setAlpha(0.0f);
                d dVar2 = d.this;
                dVar2.C = ViewCompat.c(dVar2.f209z).b(1.0f);
                d.this.C.h(new a());
            }
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    class g extends a3 {
        g() {
        }

        @Override // androidx.core.view.z2
        public void b(View view) {
            d.this.f209z.setAlpha(1.0f);
            d.this.C.h(null);
            d.this.C = null;
        }

        @Override // androidx.core.view.a3, androidx.core.view.z2
        public void c(View view) {
            d.this.f209z.setVisibility(0);
            if (d.this.f209z.getParent() instanceof View) {
                ViewCompat.L((View) d.this.f209z.getParent());
            }
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    interface h {
        boolean a(int i2);

        @Nullable
        View onCreatePanelView(int i2);
    }

    /* compiled from: AppCompatDelegateImpl.java */
    private final class i implements k.a {
        i() {
        }

        @Override // androidx.appcompat.view.menu.k.a
        public void a(@NonNull androidx.appcompat.view.menu.e eVar, boolean z2) {
            d.this.W(eVar);
        }

        @Override // androidx.appcompat.view.menu.k.a
        public boolean b(@NonNull androidx.appcompat.view.menu.e eVar) {
            Window.Callback callbackS0 = d.this.s0();
            if (callbackS0 == null) {
                return true;
            }
            callbackS0.onMenuOpened(108, eVar);
            return true;
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    class j implements b.a {

        /* renamed from: a, reason: collision with root package name */
        private b.a f219a;

        /* compiled from: AppCompatDelegateImpl.java */
        class a extends a3 {
            a() {
            }

            @Override // androidx.core.view.z2
            public void b(View view) {
                d.this.f209z.setVisibility(8);
                d dVar = d.this;
                PopupWindow popupWindow = dVar.A;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (dVar.f209z.getParent() instanceof View) {
                    ViewCompat.L((View) d.this.f209z.getParent());
                }
                d.this.f209z.k();
                d.this.C.h(null);
                d dVar2 = d.this;
                dVar2.C = null;
                ViewCompat.L(dVar2.F);
            }
        }

        public j(b.a aVar) {
            this.f219a = aVar;
        }

        @Override // androidx.appcompat.view.b.a
        public boolean a(androidx.appcompat.view.b bVar, Menu menu) {
            ViewCompat.L(d.this.F);
            return this.f219a.a(bVar, menu);
        }

        @Override // androidx.appcompat.view.b.a
        public void b(androidx.appcompat.view.b bVar) {
            this.f219a.b(bVar);
            d dVar = d.this;
            if (dVar.A != null) {
                dVar.f199p.getDecorView().removeCallbacks(d.this.B);
            }
            d dVar2 = d.this;
            if (dVar2.f209z != null) {
                dVar2.g0();
                d dVar3 = d.this;
                dVar3.C = ViewCompat.c(dVar3.f209z).b(0.0f);
                d.this.C.h(new a());
            }
            d dVar4 = d.this;
            androidx.appcompat.app.b bVar2 = dVar4.f201r;
            if (bVar2 != null) {
                bVar2.b(dVar4.f208y);
            }
            d dVar5 = d.this;
            dVar5.f208y = null;
            ViewCompat.L(dVar5.F);
            d.this.a1();
        }

        @Override // androidx.appcompat.view.b.a
        public boolean c(androidx.appcompat.view.b bVar, MenuItem menuItem) {
            return this.f219a.c(bVar, menuItem);
        }

        @Override // androidx.appcompat.view.b.a
        public boolean d(androidx.appcompat.view.b bVar, Menu menu) {
            return this.f219a.d(bVar, menu);
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    @RequiresApi(17)
    static class k {
        static Context a(@NonNull Context context, @NonNull Configuration configuration) {
            return context.createConfigurationContext(configuration);
        }

        static void b(@NonNull Configuration configuration, @NonNull Configuration configuration2, @NonNull Configuration configuration3) {
            int i2 = configuration.densityDpi;
            int i3 = configuration2.densityDpi;
            if (i2 != i3) {
                configuration3.densityDpi = i3;
            }
        }

        @DoNotInline
        static void c(Configuration configuration, Locale locale) {
            configuration.setLayoutDirection(locale);
        }

        @DoNotInline
        static void d(Configuration configuration, Locale locale) {
            configuration.setLocale(locale);
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    @RequiresApi(21)
    static class l {
        static boolean a(PowerManager powerManager) {
            return powerManager.isPowerSaveMode();
        }

        @DoNotInline
        static String b(Locale locale) {
            return locale.toLanguageTag();
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    @RequiresApi(24)
    static class m {
        @DoNotInline
        static void a(@NonNull Configuration configuration, @NonNull Configuration configuration2, @NonNull Configuration configuration3) {
            LocaleList locales = configuration.getLocales();
            LocaleList locales2 = configuration2.getLocales();
            if (locales.equals(locales2)) {
                return;
            }
            configuration3.setLocales(locales2);
            configuration3.locale = configuration2.locale;
        }

        @DoNotInline
        static androidx.core.os.g b(Configuration configuration) {
            return androidx.core.os.g.c(configuration.getLocales().toLanguageTags());
        }

        @DoNotInline
        public static void c(androidx.core.os.g gVar) {
            LocaleList.setDefault(LocaleList.forLanguageTags(gVar.h()));
        }

        @DoNotInline
        static void d(Configuration configuration, androidx.core.os.g gVar) {
            configuration.setLocales(LocaleList.forLanguageTags(gVar.h()));
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    @RequiresApi(26)
    static class n {
        static void a(@NonNull Configuration configuration, @NonNull Configuration configuration2, @NonNull Configuration configuration3) {
            int i2 = configuration.colorMode & 3;
            int i3 = configuration2.colorMode;
            if (i2 != (i3 & 3)) {
                configuration3.colorMode |= i3 & 3;
            }
            int i4 = configuration.colorMode & 12;
            int i5 = configuration2.colorMode;
            if (i4 != (i5 & 12)) {
                configuration3.colorMode |= i5 & 12;
            }
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    @RequiresApi(33)
    static class o {
        @DoNotInline
        static OnBackInvokedDispatcher a(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }

        @DoNotInline
        static OnBackInvokedCallback b(Object obj, final d dVar) {
            Objects.requireNonNull(dVar);
            OnBackInvokedCallback onBackInvokedCallback = new OnBackInvokedCallback() { // from class: androidx.appcompat.app.i
                @Override // android.window.OnBackInvokedCallback
                public final void onBackInvoked() {
                    dVar.A0();
                }
            };
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(1000000, onBackInvokedCallback);
            return onBackInvokedCallback;
        }

        @DoNotInline
        static void c(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    private class q extends r {

        /* renamed from: c, reason: collision with root package name */
        private final PowerManager f227c;

        q(@NonNull Context context) {
            super();
            this.f227c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        @Override // androidx.appcompat.app.d.r
        IntentFilter b() {
            if (Build.VERSION.SDK_INT < 21) {
                return null;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.d.r
        public int c() {
            return (Build.VERSION.SDK_INT < 21 || !l.a(this.f227c)) ? 1 : 2;
        }

        @Override // androidx.appcompat.app.d.r
        public void d() {
            d.this.Q();
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @VisibleForTesting
    abstract class r {

        /* renamed from: a, reason: collision with root package name */
        private BroadcastReceiver f229a;

        /* compiled from: AppCompatDelegateImpl.java */
        class a extends BroadcastReceiver {
            a() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                r.this.d();
            }
        }

        r() {
        }

        void a() {
            BroadcastReceiver broadcastReceiver = this.f229a;
            if (broadcastReceiver != null) {
                try {
                    d.this.f198o.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.f229a = null;
            }
        }

        @Nullable
        abstract IntentFilter b();

        abstract int c();

        abstract void d();

        void e() {
            a();
            IntentFilter intentFilterB = b();
            if (intentFilterB == null || intentFilterB.countActions() == 0) {
                return;
            }
            if (this.f229a == null) {
                this.f229a = new a();
            }
            d.this.f198o.registerReceiver(this.f229a, intentFilterB);
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    private class s extends r {

        /* renamed from: c, reason: collision with root package name */
        private final androidx.appcompat.app.s f232c;

        s(@NonNull androidx.appcompat.app.s sVar) {
            super();
            this.f232c = sVar;
        }

        @Override // androidx.appcompat.app.d.r
        IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.d.r
        public int c() {
            return this.f232c.d() ? 2 : 1;
        }

        @Override // androidx.appcompat.app.d.r
        public void d() {
            d.this.Q();
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    @RequiresApi(17)
    private static class t {
        static void a(ContextThemeWrapper contextThemeWrapper, Configuration configuration) {
            contextThemeWrapper.applyOverrideConfiguration(configuration);
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    private class u extends ContentFrameLayout {
        public u(Context context) {
            super(context);
        }

        private boolean c(int i2, int i3) {
            return i2 < -5 || i3 < -5 || i2 > getWidth() + 5 || i3 > getHeight() + 5;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return d.this.e0(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !c((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            d.this.Y(0);
            return true;
        }

        @Override // android.view.View
        public void setBackgroundResource(int i2) {
            setBackgroundDrawable(e.a.b(getContext(), i2));
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    protected static final class v {

        /* renamed from: a, reason: collision with root package name */
        int f235a;

        /* renamed from: b, reason: collision with root package name */
        int f236b;

        /* renamed from: c, reason: collision with root package name */
        int f237c;

        /* renamed from: d, reason: collision with root package name */
        int f238d;

        /* renamed from: e, reason: collision with root package name */
        int f239e;

        /* renamed from: f, reason: collision with root package name */
        int f240f;

        /* renamed from: g, reason: collision with root package name */
        ViewGroup f241g;

        /* renamed from: h, reason: collision with root package name */
        View f242h;

        /* renamed from: i, reason: collision with root package name */
        View f243i;

        /* renamed from: j, reason: collision with root package name */
        androidx.appcompat.view.menu.e f244j;

        /* renamed from: k, reason: collision with root package name */
        androidx.appcompat.view.menu.d f245k;

        /* renamed from: l, reason: collision with root package name */
        Context f246l;

        /* renamed from: m, reason: collision with root package name */
        boolean f247m;

        /* renamed from: n, reason: collision with root package name */
        boolean f248n;

        /* renamed from: o, reason: collision with root package name */
        boolean f249o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f250p;

        /* renamed from: q, reason: collision with root package name */
        boolean f251q = false;

        /* renamed from: r, reason: collision with root package name */
        boolean f252r;

        /* renamed from: s, reason: collision with root package name */
        Bundle f253s;

        v(int i2) {
            this.f235a = i2;
        }

        androidx.appcompat.view.menu.l a(k.a aVar) {
            if (this.f244j == null) {
                return null;
            }
            if (this.f245k == null) {
                androidx.appcompat.view.menu.d dVar = new androidx.appcompat.view.menu.d(this.f246l, R$layout.abc_list_menu_item_layout);
                this.f245k = dVar;
                dVar.k(aVar);
                this.f244j.b(this.f245k);
            }
            return this.f245k.d(this.f241g);
        }

        public boolean b() {
            if (this.f242h == null) {
                return false;
            }
            return this.f243i != null || this.f245k.b().getCount() > 0;
        }

        void c(androidx.appcompat.view.menu.e eVar) {
            androidx.appcompat.view.menu.d dVar;
            androidx.appcompat.view.menu.e eVar2 = this.f244j;
            if (eVar == eVar2) {
                return;
            }
            if (eVar2 != null) {
                eVar2.O(this.f245k);
            }
            this.f244j = eVar;
            if (eVar == null || (dVar = this.f245k) == null) {
                return;
            }
            eVar.b(dVar);
        }

        void d(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme themeNewTheme = context.getResources().newTheme();
            themeNewTheme.setTo(context.getTheme());
            themeNewTheme.resolveAttribute(R$attr.actionBarPopupTheme, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                themeNewTheme.applyStyle(i2, true);
            }
            themeNewTheme.resolveAttribute(R$attr.panelMenuListTheme, typedValue, true);
            int i3 = typedValue.resourceId;
            if (i3 != 0) {
                themeNewTheme.applyStyle(i3, true);
            } else {
                themeNewTheme.applyStyle(R$style.Theme_AppCompat_CompactMenu, true);
            }
            androidx.appcompat.view.d dVar = new androidx.appcompat.view.d(context, 0);
            dVar.getTheme().setTo(themeNewTheme);
            this.f246l = dVar;
            TypedArray typedArrayObtainStyledAttributes = dVar.obtainStyledAttributes(R$styleable.AppCompatTheme);
            this.f236b = typedArrayObtainStyledAttributes.getResourceId(R$styleable.AppCompatTheme_panelBackground, 0);
            this.f240f = typedArrayObtainStyledAttributes.getResourceId(R$styleable.AppCompatTheme_android_windowAnimationStyle, 0);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    private final class w implements k.a {
        w() {
        }

        @Override // androidx.appcompat.view.menu.k.a
        public void a(@NonNull androidx.appcompat.view.menu.e eVar, boolean z2) {
            androidx.appcompat.view.menu.e eVarD = eVar.D();
            boolean z3 = eVarD != eVar;
            d dVar = d.this;
            if (z3) {
                eVar = eVarD;
            }
            v vVarJ0 = dVar.j0(eVar);
            if (vVarJ0 != null) {
                if (!z3) {
                    d.this.Z(vVarJ0, z2);
                } else {
                    d.this.V(vVarJ0.f235a, vVarJ0, eVarD);
                    d.this.Z(vVarJ0, true);
                }
            }
        }

        @Override // androidx.appcompat.view.menu.k.a
        public boolean b(@NonNull androidx.appcompat.view.menu.e eVar) {
            Window.Callback callbackS0;
            if (eVar != eVar.D()) {
                return true;
            }
            d dVar = d.this;
            if (!dVar.K || (callbackS0 = dVar.s0()) == null || d.this.V) {
                return true;
            }
            callbackS0.onMenuOpened(108, eVar);
            return true;
        }
    }

    static {
        boolean z2 = Build.VERSION.SDK_INT < 21;
        f179o0 = z2;
        f180p0 = new int[]{R.attr.windowBackground};
        f181q0 = !"robolectric".equals(Build.FINGERPRINT);
        f182r0 = true;
        if (!z2 || f183s0) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(new a(Thread.getDefaultUncaughtExceptionHandler()));
        f183s0 = true;
    }

    d(Activity activity, androidx.appcompat.app.b bVar) {
        this(activity, null, bVar, activity);
    }

    private boolean C0(int i2, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        v vVarQ0 = q0(i2, true);
        if (vVarQ0.f249o) {
            return false;
        }
        return M0(vVarQ0, keyEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean F0(int r5, android.view.KeyEvent r6) {
        /*
            r4 = this;
            androidx.appcompat.view.b r0 = r4.f208y
            r1 = 0
            if (r0 == 0) goto L6
            return r1
        L6:
            r0 = 1
            androidx.appcompat.app.d$v r2 = r4.q0(r5, r0)
            if (r5 != 0) goto L43
            androidx.appcompat.widget.j1 r5 = r4.f205v
            if (r5 == 0) goto L43
            boolean r5 = r5.g()
            if (r5 == 0) goto L43
            android.content.Context r5 = r4.f198o
            android.view.ViewConfiguration r5 = android.view.ViewConfiguration.get(r5)
            boolean r5 = r5.hasPermanentMenuKey()
            if (r5 != 0) goto L43
            androidx.appcompat.widget.j1 r5 = r4.f205v
            boolean r5 = r5.b()
            if (r5 != 0) goto L3c
            boolean r5 = r4.V
            if (r5 != 0) goto L62
            boolean r5 = r4.M0(r2, r6)
            if (r5 == 0) goto L62
            androidx.appcompat.widget.j1 r5 = r4.f205v
            boolean r0 = r5.f()
            goto L68
        L3c:
            androidx.appcompat.widget.j1 r5 = r4.f205v
            boolean r0 = r5.e()
            goto L68
        L43:
            boolean r5 = r2.f249o
            if (r5 != 0) goto L64
            boolean r3 = r2.f248n
            if (r3 == 0) goto L4c
            goto L64
        L4c:
            boolean r5 = r2.f247m
            if (r5 == 0) goto L62
            boolean r5 = r2.f252r
            if (r5 == 0) goto L5b
            r2.f247m = r1
            boolean r5 = r4.M0(r2, r6)
            goto L5c
        L5b:
            r5 = 1
        L5c:
            if (r5 == 0) goto L62
            r4.J0(r2, r6)
            goto L68
        L62:
            r0 = 0
            goto L68
        L64:
            r4.Z(r2, r0)
            r0 = r5
        L68:
            if (r0 == 0) goto L85
            android.content.Context r5 = r4.f198o
            android.content.Context r5 = r5.getApplicationContext()
            java.lang.String r6 = "audio"
            java.lang.Object r5 = r5.getSystemService(r6)
            android.media.AudioManager r5 = (android.media.AudioManager) r5
            if (r5 == 0) goto L7e
            r5.playSoundEffect(r1)
            goto L85
        L7e:
            java.lang.String r5 = "AppCompatDelegate"
            java.lang.String r6 = "Couldn't get audio manager"
            android.util.Log.w(r5, r6)
        L85:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.d.F0(int, android.view.KeyEvent):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void J0(androidx.appcompat.app.d.v r14, android.view.KeyEvent r15) {
        /*
            Method dump skipped, instructions count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.d.J0(androidx.appcompat.app.d$v, android.view.KeyEvent):void");
    }

    private boolean L0(v vVar, int i2, KeyEvent keyEvent, int i3) {
        androidx.appcompat.view.menu.e eVar;
        boolean zPerformShortcut = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((vVar.f247m || M0(vVar, keyEvent)) && (eVar = vVar.f244j) != null) {
            zPerformShortcut = eVar.performShortcut(i2, keyEvent, i3);
        }
        if (zPerformShortcut && (i3 & 1) == 0 && this.f205v == null) {
            Z(vVar, true);
        }
        return zPerformShortcut;
    }

    private boolean M0(v vVar, KeyEvent keyEvent) {
        j1 j1Var;
        j1 j1Var2;
        j1 j1Var3;
        if (this.V) {
            return false;
        }
        if (vVar.f247m) {
            return true;
        }
        v vVar2 = this.R;
        if (vVar2 != null && vVar2 != vVar) {
            Z(vVar2, false);
        }
        Window.Callback callbackS0 = s0();
        if (callbackS0 != null) {
            vVar.f243i = callbackS0.onCreatePanelView(vVar.f235a);
        }
        int i2 = vVar.f235a;
        boolean z2 = i2 == 0 || i2 == 108;
        if (z2 && (j1Var3 = this.f205v) != null) {
            j1Var3.c();
        }
        if (vVar.f243i == null) {
            if (z2) {
                K0();
            }
            androidx.appcompat.view.menu.e eVar = vVar.f244j;
            if (eVar == null || vVar.f252r) {
                if (eVar == null && (!w0(vVar) || vVar.f244j == null)) {
                    return false;
                }
                if (z2 && this.f205v != null) {
                    if (this.f206w == null) {
                        this.f206w = new i();
                    }
                    this.f205v.a(vVar.f244j, this.f206w);
                }
                vVar.f244j.d0();
                if (!callbackS0.onCreatePanelMenu(vVar.f235a, vVar.f244j)) {
                    vVar.c(null);
                    if (z2 && (j1Var = this.f205v) != null) {
                        j1Var.a(null, this.f206w);
                    }
                    return false;
                }
                vVar.f252r = false;
            }
            vVar.f244j.d0();
            Bundle bundle = vVar.f253s;
            if (bundle != null) {
                vVar.f244j.P(bundle);
                vVar.f253s = null;
            }
            if (!callbackS0.onPreparePanel(0, vVar.f243i, vVar.f244j)) {
                if (z2 && (j1Var2 = this.f205v) != null) {
                    j1Var2.a(null, this.f206w);
                }
                vVar.f244j.c0();
                return false;
            }
            boolean z3 = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            vVar.f250p = z3;
            vVar.f244j.setQwertyMode(z3);
            vVar.f244j.c0();
        }
        vVar.f247m = true;
        vVar.f248n = false;
        this.R = vVar;
        return true;
    }

    private void N0(boolean z2) {
        j1 j1Var = this.f205v;
        if (j1Var == null || !j1Var.g() || (ViewConfiguration.get(this.f198o).hasPermanentMenuKey() && !this.f205v.d())) {
            v vVarQ0 = q0(0, true);
            vVarQ0.f251q = true;
            Z(vVarQ0, false);
            J0(vVarQ0, null);
            return;
        }
        Window.Callback callbackS0 = s0();
        if (this.f205v.b() && z2) {
            this.f205v.e();
            if (this.V) {
                return;
            }
            callbackS0.onPanelClosed(108, q0(0, true).f244j);
            return;
        }
        if (callbackS0 == null || this.V) {
            return;
        }
        if (this.f187d0 && (this.f188e0 & 1) != 0) {
            this.f199p.getDecorView().removeCallbacks(this.f189f0);
            this.f189f0.run();
        }
        v vVarQ02 = q0(0, true);
        androidx.appcompat.view.menu.e eVar = vVarQ02.f244j;
        if (eVar == null || vVarQ02.f252r || !callbackS0.onPreparePanel(0, vVarQ02.f243i, eVar)) {
            return;
        }
        callbackS0.onMenuOpened(108, vVarQ02.f244j);
        this.f205v.f();
    }

    private boolean O(boolean z2) {
        return P(z2, true);
    }

    private int O0(int i2) {
        if (i2 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        }
        if (i2 != 9) {
            return i2;
        }
        Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
        return 109;
    }

    private boolean P(boolean z2, boolean z3) throws IllegalAccessException, NoSuchFieldException, PackageManager.NameNotFoundException, SecurityException, IllegalArgumentException {
        if (this.V) {
            return false;
        }
        int iU = U();
        int iZ0 = z0(this.f198o, iU);
        androidx.core.os.g gVarT = Build.VERSION.SDK_INT < 33 ? T(this.f198o) : null;
        if (!z3 && gVarT != null) {
            gVarT = p0(this.f198o.getResources().getConfiguration());
        }
        boolean zZ0 = Z0(iZ0, gVarT, z2);
        if (iU == 0) {
            o0(this.f198o).e();
        } else {
            r rVar = this.f185b0;
            if (rVar != null) {
                rVar.a();
            }
        }
        if (iU == 3) {
            n0(this.f198o).e();
        } else {
            r rVar2 = this.f186c0;
            if (rVar2 != null) {
                rVar2.a();
            }
        }
        return zZ0;
    }

    private void R() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.F.findViewById(R.id.content);
        View decorView = this.f199p.getDecorView();
        contentFrameLayout.b(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray typedArrayObtainStyledAttributes = this.f198o.obtainStyledAttributes(R$styleable.AppCompatTheme);
        typedArrayObtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        typedArrayObtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        int i2 = R$styleable.AppCompatTheme_windowFixedWidthMajor;
        if (typedArrayObtainStyledAttributes.hasValue(i2)) {
            typedArrayObtainStyledAttributes.getValue(i2, contentFrameLayout.getFixedWidthMajor());
        }
        int i3 = R$styleable.AppCompatTheme_windowFixedWidthMinor;
        if (typedArrayObtainStyledAttributes.hasValue(i3)) {
            typedArrayObtainStyledAttributes.getValue(i3, contentFrameLayout.getFixedWidthMinor());
        }
        int i4 = R$styleable.AppCompatTheme_windowFixedHeightMajor;
        if (typedArrayObtainStyledAttributes.hasValue(i4)) {
            typedArrayObtainStyledAttributes.getValue(i4, contentFrameLayout.getFixedHeightMajor());
        }
        int i5 = R$styleable.AppCompatTheme_windowFixedHeightMinor;
        if (typedArrayObtainStyledAttributes.hasValue(i5)) {
            typedArrayObtainStyledAttributes.getValue(i5, contentFrameLayout.getFixedHeightMinor());
        }
        typedArrayObtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private void S(@NonNull Window window) {
        if (this.f199p != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof p) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        p pVar = new p(callback);
        this.f200q = pVar;
        window.setCallback(pVar);
        k2 k2VarT = k2.t(this.f198o, null, f180p0);
        Drawable drawableG = k2VarT.g(0);
        if (drawableG != null) {
            window.setBackgroundDrawable(drawableG);
        }
        k2VarT.v();
        this.f199p = window;
        if (Build.VERSION.SDK_INT < 33 || this.f195l0 != null) {
            return;
        }
        K(null);
    }

    private boolean S0(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f199p.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || ViewCompat.A((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    private int U() {
        int i2 = this.X;
        return i2 != -100 ? i2 : AppCompatDelegate.m();
    }

    private void W0() {
        if (this.E) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private void X() {
        r rVar = this.f185b0;
        if (rVar != null) {
            rVar.a();
        }
        r rVar2 = this.f186c0;
        if (rVar2 != null) {
            rVar2.a();
        }
    }

    @Nullable
    private AppCompatActivity X0() {
        for (Context baseContext = this.f198o; baseContext != null; baseContext = ((ContextWrapper) baseContext).getBaseContext()) {
            if (baseContext instanceof AppCompatActivity) {
                return (AppCompatActivity) baseContext;
            }
            if (!(baseContext instanceof ContextWrapper)) {
                break;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void Y0(Configuration configuration) {
        Activity activity = (Activity) this.f197n;
        if (activity instanceof androidx.lifecycle.m) {
            if (((androidx.lifecycle.m) activity).getLifecycle().b().isAtLeast(Lifecycle.State.CREATED)) {
                activity.onConfigurationChanged(configuration);
            }
        } else {
            if (!this.U || this.V) {
                return;
            }
            activity.onConfigurationChanged(configuration);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean Z0(int r9, @androidx.annotation.Nullable androidx.core.os.g r10, boolean r11) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException, android.content.pm.PackageManager.NameNotFoundException, java.lang.SecurityException, java.lang.IllegalArgumentException {
        /*
            r8 = this;
            android.content.Context r1 = r8.f198o
            r4 = 0
            r5 = 0
            r0 = r8
            r2 = r9
            r3 = r10
            android.content.res.Configuration r0 = r0.a0(r1, r2, r3, r4, r5)
            android.content.Context r1 = r8.f198o
            int r1 = r8.m0(r1)
            android.content.res.Configuration r2 = r8.W
            if (r2 != 0) goto L1f
            android.content.Context r2 = r8.f198o
            android.content.res.Resources r2 = r2.getResources()
            android.content.res.Configuration r2 = r2.getConfiguration()
        L1f:
            int r3 = r2.uiMode
            r3 = r3 & 48
            int r4 = r0.uiMode
            r4 = r4 & 48
            androidx.core.os.g r2 = r8.p0(r2)
            r5 = 0
            if (r10 != 0) goto L30
            r0 = r5
            goto L34
        L30:
            androidx.core.os.g r0 = r8.p0(r0)
        L34:
            r6 = 0
            if (r3 == r4) goto L3a
            r3 = 512(0x200, float:7.17E-43)
            goto L3b
        L3a:
            r3 = 0
        L3b:
            if (r0 == 0) goto L47
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L47
            r2 = r3 | 4
            r3 = r2 | 8192(0x2000, float:1.148E-41)
        L47:
            r2 = r1 ^ (-1)
            r2 = r2 & r3
            r7 = 1
            if (r2 == 0) goto L72
            if (r11 == 0) goto L72
            boolean r11 = r8.T
            if (r11 == 0) goto L72
            boolean r11 = androidx.appcompat.app.d.f181q0
            if (r11 != 0) goto L5b
            boolean r11 = r8.U
            if (r11 == 0) goto L72
        L5b:
            java.lang.Object r11 = r8.f197n
            boolean r2 = r11 instanceof android.app.Activity
            if (r2 == 0) goto L72
            android.app.Activity r11 = (android.app.Activity) r11
            boolean r11 = r11.isChild()
            if (r11 != 0) goto L72
            java.lang.Object r11 = r8.f197n
            android.app.Activity r11 = (android.app.Activity) r11
            androidx.core.app.b.p(r11)
            r11 = 1
            goto L73
        L72:
            r11 = 0
        L73:
            if (r11 != 0) goto L80
            if (r3 == 0) goto L80
            r11 = r3 & r1
            if (r11 != r3) goto L7c
            r6 = 1
        L7c:
            r8.b1(r4, r0, r6, r5)
            goto L81
        L80:
            r7 = r11
        L81:
            if (r7 == 0) goto L9d
            java.lang.Object r11 = r8.f197n
            boolean r1 = r11 instanceof androidx.appcompat.app.AppCompatActivity
            if (r1 == 0) goto L9d
            r1 = r3 & 512(0x200, float:7.17E-43)
            if (r1 == 0) goto L92
            androidx.appcompat.app.AppCompatActivity r11 = (androidx.appcompat.app.AppCompatActivity) r11
            r11.l(r9)
        L92:
            r9 = r3 & 4
            if (r9 == 0) goto L9d
            java.lang.Object r9 = r8.f197n
            androidx.appcompat.app.AppCompatActivity r9 = (androidx.appcompat.app.AppCompatActivity) r9
            r9.k(r10)
        L9d:
            if (r7 == 0) goto Lb2
            if (r0 == 0) goto Lb2
            android.content.Context r9 = r8.f198o
            android.content.res.Resources r9 = r9.getResources()
            android.content.res.Configuration r9 = r9.getConfiguration()
            androidx.core.os.g r9 = r8.p0(r9)
            r8.Q0(r9)
        Lb2:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.d.Z0(int, androidx.core.os.g, boolean):boolean");
    }

    @NonNull
    private Configuration a0(@NonNull Context context, int i2, @Nullable androidx.core.os.g gVar, @Nullable Configuration configuration, boolean z2) {
        int i3 = i2 != 1 ? i2 != 2 ? z2 ? 0 : context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i3 | (configuration2.uiMode & (-49));
        if (gVar != null) {
            P0(configuration2, gVar);
        }
        return configuration2;
    }

    private ViewGroup b0() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        ViewGroup viewGroup;
        TypedArray typedArrayObtainStyledAttributes = this.f198o.obtainStyledAttributes(R$styleable.AppCompatTheme);
        int i2 = R$styleable.AppCompatTheme_windowActionBar;
        if (!typedArrayObtainStyledAttributes.hasValue(i2)) {
            typedArrayObtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (typedArrayObtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowNoTitle, false)) {
            G(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(i2, false)) {
            G(108);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowActionBarOverlay, false)) {
            G(109);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowActionModeOverlay, false)) {
            G(10);
        }
        this.N = typedArrayObtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_android_windowIsFloating, false);
        typedArrayObtainStyledAttributes.recycle();
        i0();
        this.f199p.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f198o);
        if (this.O) {
            viewGroup = this.M ? (ViewGroup) layoutInflaterFrom.inflate(R$layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) layoutInflaterFrom.inflate(R$layout.abc_screen_simple, (ViewGroup) null);
        } else if (this.N) {
            viewGroup = (ViewGroup) layoutInflaterFrom.inflate(R$layout.abc_dialog_title_material, (ViewGroup) null);
            this.L = false;
            this.K = false;
        } else if (this.K) {
            TypedValue typedValue = new TypedValue();
            this.f198o.getTheme().resolveAttribute(R$attr.actionBarTheme, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new androidx.appcompat.view.d(this.f198o, typedValue.resourceId) : this.f198o).inflate(R$layout.abc_screen_toolbar, (ViewGroup) null);
            j1 j1Var = (j1) viewGroup.findViewById(R$id.decor_content_parent);
            this.f205v = j1Var;
            j1Var.setWindowCallback(s0());
            if (this.L) {
                this.f205v.k(109);
            }
            if (this.I) {
                this.f205v.k(2);
            }
            if (this.J) {
                this.f205v.k(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.K + ", windowActionBarOverlay: " + this.L + ", android:windowIsFloating: " + this.N + ", windowActionModeOverlay: " + this.M + ", windowNoTitle: " + this.O + " }");
        }
        if (Build.VERSION.SDK_INT >= 21) {
            ViewCompat.W(viewGroup, new c());
        } else if (viewGroup instanceof o1) {
            ((o1) viewGroup).setOnFitSystemWindowsListener(new C0006d());
        }
        if (this.f205v == null) {
            this.G = (TextView) viewGroup.findViewById(R$id.title);
        }
        v2.c(viewGroup);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(R$id.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) this.f199p.findViewById(R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.f199p.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new e());
        return viewGroup;
    }

    private void b1(int i2, @Nullable androidx.core.os.g gVar, boolean z2, @Nullable Configuration configuration) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        Resources resources = this.f198o.getResources();
        Configuration configuration2 = new Configuration(resources.getConfiguration());
        if (configuration != null) {
            configuration2.updateFrom(configuration);
        }
        configuration2.uiMode = i2 | (resources.getConfiguration().uiMode & (-49));
        if (gVar != null) {
            P0(configuration2, gVar);
        }
        resources.updateConfiguration(configuration2, null);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 26) {
            androidx.appcompat.app.q.a(resources);
        }
        int i4 = this.Y;
        if (i4 != 0) {
            this.f198o.setTheme(i4);
            if (i3 >= 23) {
                this.f198o.getTheme().applyStyle(this.Y, true);
            }
        }
        if (z2 && (this.f197n instanceof Activity)) {
            Y0(configuration2);
        }
    }

    private void d1(View view) {
        view.setBackgroundColor((ViewCompat.x(view) & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? ContextCompat.b(this.f198o, R$color.abc_decor_view_status_guard_light) : ContextCompat.b(this.f198o, R$color.abc_decor_view_status_guard));
    }

    private void h0() {
        if (this.E) {
            return;
        }
        this.F = b0();
        CharSequence charSequenceR0 = r0();
        if (!TextUtils.isEmpty(charSequenceR0)) {
            j1 j1Var = this.f205v;
            if (j1Var != null) {
                j1Var.setWindowTitle(charSequenceR0);
            } else if (K0() != null) {
                K0().t(charSequenceR0);
            } else {
                TextView textView = this.G;
                if (textView != null) {
                    textView.setText(charSequenceR0);
                }
            }
        }
        R();
        I0(this.F);
        this.E = true;
        v vVarQ0 = q0(0, false);
        if (this.V) {
            return;
        }
        if (vVarQ0 == null || vVarQ0.f244j == null) {
            x0(108);
        }
    }

    private void i0() {
        if (this.f199p == null) {
            Object obj = this.f197n;
            if (obj instanceof Activity) {
                S(((Activity) obj).getWindow());
            }
        }
        if (this.f199p == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    @NonNull
    private static Configuration k0(@NonNull Configuration configuration, @Nullable Configuration configuration2) {
        Configuration configuration3 = new Configuration();
        configuration3.fontScale = 0.0f;
        if (configuration2 != null && configuration.diff(configuration2) != 0) {
            float f2 = configuration.fontScale;
            float f3 = configuration2.fontScale;
            if (f2 != f3) {
                configuration3.fontScale = f3;
            }
            int i2 = configuration.mcc;
            int i3 = configuration2.mcc;
            if (i2 != i3) {
                configuration3.mcc = i3;
            }
            int i4 = configuration.mnc;
            int i5 = configuration2.mnc;
            if (i4 != i5) {
                configuration3.mnc = i5;
            }
            int i6 = Build.VERSION.SDK_INT;
            if (i6 >= 24) {
                m.a(configuration, configuration2, configuration3);
            } else if (!androidx.core.util.c.a(configuration.locale, configuration2.locale)) {
                configuration3.locale = configuration2.locale;
            }
            int i7 = configuration.touchscreen;
            int i8 = configuration2.touchscreen;
            if (i7 != i8) {
                configuration3.touchscreen = i8;
            }
            int i9 = configuration.keyboard;
            int i10 = configuration2.keyboard;
            if (i9 != i10) {
                configuration3.keyboard = i10;
            }
            int i11 = configuration.keyboardHidden;
            int i12 = configuration2.keyboardHidden;
            if (i11 != i12) {
                configuration3.keyboardHidden = i12;
            }
            int i13 = configuration.navigation;
            int i14 = configuration2.navigation;
            if (i13 != i14) {
                configuration3.navigation = i14;
            }
            int i15 = configuration.navigationHidden;
            int i16 = configuration2.navigationHidden;
            if (i15 != i16) {
                configuration3.navigationHidden = i16;
            }
            int i17 = configuration.orientation;
            int i18 = configuration2.orientation;
            if (i17 != i18) {
                configuration3.orientation = i18;
            }
            int i19 = configuration.screenLayout & 15;
            int i20 = configuration2.screenLayout;
            if (i19 != (i20 & 15)) {
                configuration3.screenLayout |= i20 & 15;
            }
            int i21 = configuration.screenLayout & 192;
            int i22 = configuration2.screenLayout;
            if (i21 != (i22 & 192)) {
                configuration3.screenLayout |= i22 & 192;
            }
            int i23 = configuration.screenLayout & 48;
            int i24 = configuration2.screenLayout;
            if (i23 != (i24 & 48)) {
                configuration3.screenLayout |= i24 & 48;
            }
            int i25 = configuration.screenLayout & 768;
            int i26 = configuration2.screenLayout;
            if (i25 != (i26 & 768)) {
                configuration3.screenLayout |= i26 & 768;
            }
            if (i6 >= 26) {
                n.a(configuration, configuration2, configuration3);
            }
            int i27 = configuration.uiMode & 15;
            int i28 = configuration2.uiMode;
            if (i27 != (i28 & 15)) {
                configuration3.uiMode |= i28 & 15;
            }
            int i29 = configuration.uiMode & 48;
            int i30 = configuration2.uiMode;
            if (i29 != (i30 & 48)) {
                configuration3.uiMode |= i30 & 48;
            }
            int i31 = configuration.screenWidthDp;
            int i32 = configuration2.screenWidthDp;
            if (i31 != i32) {
                configuration3.screenWidthDp = i32;
            }
            int i33 = configuration.screenHeightDp;
            int i34 = configuration2.screenHeightDp;
            if (i33 != i34) {
                configuration3.screenHeightDp = i34;
            }
            int i35 = configuration.smallestScreenWidthDp;
            int i36 = configuration2.smallestScreenWidthDp;
            if (i35 != i36) {
                configuration3.smallestScreenWidthDp = i36;
            }
            k.b(configuration, configuration2, configuration3);
        }
        return configuration3;
    }

    private int m0(Context context) throws PackageManager.NameNotFoundException {
        if (!this.f184a0 && (this.f197n instanceof Activity)) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return 0;
            }
            try {
                int i2 = Build.VERSION.SDK_INT;
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(context, this.f197n.getClass()), i2 >= 29 ? 269221888 : i2 >= 24 ? 786432 : 0);
                if (activityInfo != null) {
                    this.Z = activityInfo.configChanges;
                }
            } catch (PackageManager.NameNotFoundException e2) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e2);
                this.Z = 0;
            }
        }
        this.f184a0 = true;
        return this.Z;
    }

    private r n0(@NonNull Context context) {
        if (this.f186c0 == null) {
            this.f186c0 = new q(context);
        }
        return this.f186c0;
    }

    private r o0(@NonNull Context context) {
        if (this.f185b0 == null) {
            this.f185b0 = new s(androidx.appcompat.app.s.a(context));
        }
        return this.f185b0;
    }

    private void t0() {
        h0();
        if (this.K && this.f202s == null) {
            Object obj = this.f197n;
            if (obj instanceof Activity) {
                this.f202s = new androidx.appcompat.app.t((Activity) this.f197n, this.L);
            } else if (obj instanceof Dialog) {
                this.f202s = new androidx.appcompat.app.t((Dialog) this.f197n);
            }
            ActionBar actionBar = this.f202s;
            if (actionBar != null) {
                actionBar.r(this.f190g0);
            }
        }
    }

    private boolean u0(v vVar) {
        View view = vVar.f243i;
        if (view != null) {
            vVar.f242h = view;
            return true;
        }
        if (vVar.f244j == null) {
            return false;
        }
        if (this.f207x == null) {
            this.f207x = new w();
        }
        View view2 = (View) vVar.a(this.f207x);
        vVar.f242h = view2;
        return view2 != null;
    }

    private boolean v0(v vVar) {
        vVar.d(l0());
        vVar.f241g = new u(vVar.f246l);
        vVar.f237c = 81;
        return true;
    }

    private boolean w0(v vVar) {
        Context context = this.f198o;
        int i2 = vVar.f235a;
        if ((i2 == 0 || i2 == 108) && this.f205v != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(R$attr.actionBarTheme, typedValue, true);
            Resources.Theme themeNewTheme = null;
            if (typedValue.resourceId != 0) {
                themeNewTheme = context.getResources().newTheme();
                themeNewTheme.setTo(theme);
                themeNewTheme.applyStyle(typedValue.resourceId, true);
                themeNewTheme.resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (themeNewTheme == null) {
                    themeNewTheme = context.getResources().newTheme();
                    themeNewTheme.setTo(theme);
                }
                themeNewTheme.applyStyle(typedValue.resourceId, true);
            }
            if (themeNewTheme != null) {
                androidx.appcompat.view.d dVar = new androidx.appcompat.view.d(context, 0);
                dVar.getTheme().setTo(themeNewTheme);
                context = dVar;
            }
        }
        androidx.appcompat.view.menu.e eVar = new androidx.appcompat.view.menu.e(context);
        eVar.R(this);
        vVar.c(eVar);
        return true;
    }

    private void x0(int i2) {
        this.f188e0 = (1 << i2) | this.f188e0;
        if (this.f187d0) {
            return;
        }
        ViewCompat.J(this.f199p.getDecorView(), this.f189f0);
        this.f187d0 = true;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void A() {
        ActionBar actionBarR = r();
        if (actionBarR != null) {
            actionBarR.s(true);
        }
    }

    boolean A0() {
        boolean z2 = this.S;
        this.S = false;
        v vVarQ0 = q0(0, false);
        if (vVarQ0 != null && vVarQ0.f249o) {
            if (!z2) {
                Z(vVarQ0, true);
            }
            return true;
        }
        androidx.appcompat.view.b bVar = this.f208y;
        if (bVar != null) {
            bVar.c();
            return true;
        }
        ActionBar actionBarR = r();
        return actionBarR != null && actionBarR.h();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void B(Bundle bundle) {
    }

    boolean B0(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            this.S = (keyEvent.getFlags() & 128) != 0;
        } else if (i2 == 82) {
            C0(0, keyEvent);
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void C() throws IllegalAccessException, NoSuchFieldException, PackageManager.NameNotFoundException, SecurityException, IllegalArgumentException {
        P(true, false);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void D() {
        ActionBar actionBarR = r();
        if (actionBarR != null) {
            actionBarR.s(false);
        }
    }

    boolean D0(int i2, KeyEvent keyEvent) {
        ActionBar actionBarR = r();
        if (actionBarR != null && actionBarR.o(i2, keyEvent)) {
            return true;
        }
        v vVar = this.R;
        if (vVar != null && L0(vVar, keyEvent.getKeyCode(), keyEvent, 1)) {
            v vVar2 = this.R;
            if (vVar2 != null) {
                vVar2.f248n = true;
            }
            return true;
        }
        if (this.R == null) {
            v vVarQ0 = q0(0, true);
            M0(vVarQ0, keyEvent);
            boolean zL0 = L0(vVarQ0, keyEvent.getKeyCode(), keyEvent, 1);
            vVarQ0.f247m = false;
            if (zL0) {
                return true;
            }
        }
        return false;
    }

    boolean E0(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            if (i2 == 82) {
                F0(0, keyEvent);
                return true;
            }
        } else if (A0()) {
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public boolean G(int i2) {
        int iO0 = O0(i2);
        if (this.O && iO0 == 108) {
            return false;
        }
        if (this.K && iO0 == 1) {
            this.K = false;
        }
        if (iO0 == 1) {
            W0();
            this.O = true;
            return true;
        }
        if (iO0 == 2) {
            W0();
            this.I = true;
            return true;
        }
        if (iO0 == 5) {
            W0();
            this.J = true;
            return true;
        }
        if (iO0 == 10) {
            W0();
            this.M = true;
            return true;
        }
        if (iO0 == 108) {
            W0();
            this.K = true;
            return true;
        }
        if (iO0 != 109) {
            return this.f199p.requestFeature(iO0);
        }
        W0();
        this.L = true;
        return true;
    }

    void G0(int i2) {
        ActionBar actionBarR;
        if (i2 != 108 || (actionBarR = r()) == null) {
            return;
        }
        actionBarR.i(true);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void H(int i2) {
        h0();
        ViewGroup viewGroup = (ViewGroup) this.F.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f198o).inflate(i2, viewGroup);
        this.f200q.c(this.f199p.getCallback());
    }

    void H0(int i2) {
        if (i2 == 108) {
            ActionBar actionBarR = r();
            if (actionBarR != null) {
                actionBarR.i(false);
                return;
            }
            return;
        }
        if (i2 == 0) {
            v vVarQ0 = q0(i2, true);
            if (vVarQ0.f249o) {
                Z(vVarQ0, false);
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void I(View view) {
        h0();
        ViewGroup viewGroup = (ViewGroup) this.F.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f200q.c(this.f199p.getCallback());
    }

    void I0(ViewGroup viewGroup) {
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void J(View view, ViewGroup.LayoutParams layoutParams) {
        h0();
        ViewGroup viewGroup = (ViewGroup) this.F.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f200q.c(this.f199p.getCallback());
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002c  */
    @Override // androidx.appcompat.app.AppCompatDelegate
    @androidx.annotation.RequiresApi(33)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void K(@androidx.annotation.Nullable android.window.OnBackInvokedDispatcher r3) {
        /*
            r2 = this;
            super.K(r3)
            android.window.OnBackInvokedDispatcher r0 = r2.f195l0
            if (r0 == 0) goto L11
            android.window.OnBackInvokedCallback r1 = r2.f196m0
            if (r1 == 0) goto L11
            androidx.appcompat.app.d.o.c(r0, r1)
            r0 = 0
            r2.f196m0 = r0
        L11:
            if (r3 != 0) goto L2c
            java.lang.Object r0 = r2.f197n
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L2c
            android.app.Activity r0 = (android.app.Activity) r0
            android.view.Window r0 = r0.getWindow()
            if (r0 == 0) goto L2c
            java.lang.Object r3 = r2.f197n
            android.app.Activity r3 = (android.app.Activity) r3
            android.window.OnBackInvokedDispatcher r3 = androidx.appcompat.app.d.o.a(r3)
            r2.f195l0 = r3
            goto L2e
        L2c:
            r2.f195l0 = r3
        L2e:
            r2.a1()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.d.K(android.window.OnBackInvokedDispatcher):void");
    }

    final ActionBar K0() {
        return this.f202s;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void L(@StyleRes int i2) {
        this.Y = i2;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void M(CharSequence charSequence) {
        this.f204u = charSequence;
        j1 j1Var = this.f205v;
        if (j1Var != null) {
            j1Var.setWindowTitle(charSequence);
            return;
        }
        if (K0() != null) {
            K0().t(charSequence);
            return;
        }
        TextView textView = this.G;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    void P0(Configuration configuration, @NonNull androidx.core.os.g gVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            m.d(configuration, gVar);
        } else {
            k.d(configuration, gVar.d(0));
            k.c(configuration, gVar.d(0));
        }
    }

    public boolean Q() {
        return O(true);
    }

    void Q0(androidx.core.os.g gVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            m.c(gVar);
        } else {
            Locale.setDefault(gVar.d(0));
        }
    }

    final boolean R0() {
        ViewGroup viewGroup;
        return this.E && (viewGroup = this.F) != null && ViewCompat.B(viewGroup);
    }

    @Nullable
    androidx.core.os.g T(@NonNull Context context) {
        androidx.core.os.g gVarQ;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 33 || (gVarQ = AppCompatDelegate.q()) == null) {
            return null;
        }
        androidx.core.os.g gVarP0 = p0(context.getApplicationContext().getResources().getConfiguration());
        androidx.core.os.g gVarB = i2 >= 24 ? androidx.appcompat.app.p.b(gVarQ, gVarP0) : gVarQ.f() ? androidx.core.os.g.e() : androidx.core.os.g.c(gVarQ.d(0).toString());
        return gVarB.f() ? gVarP0 : gVarB;
    }

    boolean T0() {
        if (this.f195l0 == null) {
            return false;
        }
        v vVarQ0 = q0(0, false);
        return (vVarQ0 != null && vVarQ0.f249o) || this.f208y != null;
    }

    public androidx.appcompat.view.b U0(@NonNull b.a aVar) {
        androidx.appcompat.app.b bVar;
        if (aVar == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        androidx.appcompat.view.b bVar2 = this.f208y;
        if (bVar2 != null) {
            bVar2.c();
        }
        j jVar = new j(aVar);
        ActionBar actionBarR = r();
        if (actionBarR != null) {
            androidx.appcompat.view.b bVarU = actionBarR.u(jVar);
            this.f208y = bVarU;
            if (bVarU != null && (bVar = this.f201r) != null) {
                bVar.a(bVarU);
            }
        }
        if (this.f208y == null) {
            this.f208y = V0(jVar);
        }
        a1();
        return this.f208y;
    }

    void V(int i2, v vVar, Menu menu) {
        if (menu == null) {
            if (vVar == null && i2 >= 0) {
                v[] vVarArr = this.Q;
                if (i2 < vVarArr.length) {
                    vVar = vVarArr[i2];
                }
            }
            if (vVar != null) {
                menu = vVar.f244j;
            }
        }
        if ((vVar == null || vVar.f249o) && !this.V) {
            this.f200q.d(this.f199p.getCallback(), i2, menu);
        }
    }

    androidx.appcompat.view.b V0(@NonNull b.a aVar) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        androidx.appcompat.view.b bVarD;
        Context dVar;
        androidx.appcompat.app.b bVar;
        g0();
        androidx.appcompat.view.b bVar2 = this.f208y;
        if (bVar2 != null) {
            bVar2.c();
        }
        if (!(aVar instanceof j)) {
            aVar = new j(aVar);
        }
        androidx.appcompat.app.b bVar3 = this.f201r;
        if (bVar3 == null || this.V) {
            bVarD = null;
        } else {
            try {
                bVarD = bVar3.d(aVar);
            } catch (AbstractMethodError unused) {
            }
        }
        if (bVarD != null) {
            this.f208y = bVarD;
        } else {
            if (this.f209z == null) {
                if (this.N) {
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme theme = this.f198o.getTheme();
                    theme.resolveAttribute(R$attr.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Resources.Theme themeNewTheme = this.f198o.getResources().newTheme();
                        themeNewTheme.setTo(theme);
                        themeNewTheme.applyStyle(typedValue.resourceId, true);
                        dVar = new androidx.appcompat.view.d(this.f198o, 0);
                        dVar.getTheme().setTo(themeNewTheme);
                    } else {
                        dVar = this.f198o;
                    }
                    this.f209z = new ActionBarContextView(dVar);
                    PopupWindow popupWindow = new PopupWindow(dVar, (AttributeSet) null, R$attr.actionModePopupWindowStyle);
                    this.A = popupWindow;
                    androidx.core.widget.w.b(popupWindow, 2);
                    this.A.setContentView(this.f209z);
                    this.A.setWidth(-1);
                    dVar.getTheme().resolveAttribute(R$attr.actionBarSize, typedValue, true);
                    this.f209z.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, dVar.getResources().getDisplayMetrics()));
                    this.A.setHeight(-2);
                    this.B = new f();
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) this.F.findViewById(R$id.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(l0()));
                        this.f209z = (ActionBarContextView) viewStubCompat.a();
                    }
                }
            }
            if (this.f209z != null) {
                g0();
                this.f209z.k();
                androidx.appcompat.view.e eVar = new androidx.appcompat.view.e(this.f209z.getContext(), this.f209z, aVar, this.A == null);
                if (aVar.d(eVar, eVar.e())) {
                    eVar.k();
                    this.f209z.h(eVar);
                    this.f208y = eVar;
                    if (R0()) {
                        this.f209z.setAlpha(0.0f);
                        y2 y2VarB = ViewCompat.c(this.f209z).b(1.0f);
                        this.C = y2VarB;
                        y2VarB.h(new g());
                    } else {
                        this.f209z.setAlpha(1.0f);
                        this.f209z.setVisibility(0);
                        if (this.f209z.getParent() instanceof View) {
                            ViewCompat.L((View) this.f209z.getParent());
                        }
                    }
                    if (this.A != null) {
                        this.f199p.getDecorView().post(this.B);
                    }
                } else {
                    this.f208y = null;
                }
            }
        }
        androidx.appcompat.view.b bVar4 = this.f208y;
        if (bVar4 != null && (bVar = this.f201r) != null) {
            bVar.a(bVar4);
        }
        a1();
        return this.f208y;
    }

    void W(@NonNull androidx.appcompat.view.menu.e eVar) {
        if (this.P) {
            return;
        }
        this.P = true;
        this.f205v.l();
        Window.Callback callbackS0 = s0();
        if (callbackS0 != null && !this.V) {
            callbackS0.onPanelClosed(108, eVar);
        }
        this.P = false;
    }

    void Y(int i2) {
        Z(q0(i2, true), true);
    }

    void Z(v vVar, boolean z2) {
        ViewGroup viewGroup;
        j1 j1Var;
        if (z2 && vVar.f235a == 0 && (j1Var = this.f205v) != null && j1Var.b()) {
            W(vVar.f244j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f198o.getSystemService("window");
        if (windowManager != null && vVar.f249o && (viewGroup = vVar.f241g) != null) {
            windowManager.removeView(viewGroup);
            if (z2) {
                V(vVar.f235a, vVar, null);
            }
        }
        vVar.f247m = false;
        vVar.f248n = false;
        vVar.f249o = false;
        vVar.f242h = null;
        vVar.f251q = true;
        if (this.R == vVar) {
            this.R = null;
        }
        if (vVar.f235a == 0) {
            a1();
        }
    }

    @Override // androidx.appcompat.view.menu.e.a
    public boolean a(@NonNull androidx.appcompat.view.menu.e eVar, @NonNull MenuItem menuItem) {
        v vVarJ0;
        Window.Callback callbackS0 = s0();
        if (callbackS0 == null || this.V || (vVarJ0 = j0(eVar.D())) == null) {
            return false;
        }
        return callbackS0.onMenuItemSelected(vVarJ0.f235a, menuItem);
    }

    void a1() {
        OnBackInvokedCallback onBackInvokedCallback;
        if (Build.VERSION.SDK_INT >= 33) {
            boolean zT0 = T0();
            if (zT0 && this.f196m0 == null) {
                this.f196m0 = o.b(this.f195l0, this);
            } else {
                if (zT0 || (onBackInvokedCallback = this.f196m0) == null) {
                    return;
                }
                o.c(this.f195l0, onBackInvokedCallback);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.e.a
    public void b(@NonNull androidx.appcompat.view.menu.e eVar) {
        N0(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View c0(View view, String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        boolean z2;
        boolean zS0 = false;
        if (this.f193j0 == null) {
            String string = this.f198o.obtainStyledAttributes(R$styleable.AppCompatTheme).getString(R$styleable.AppCompatTheme_viewInflaterClass);
            if (string == null) {
                this.f193j0 = new androidx.appcompat.app.l();
            } else {
                try {
                    this.f193j0 = (androidx.appcompat.app.l) this.f198o.getClassLoader().loadClass(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.f193j0 = new androidx.appcompat.app.l();
                }
            }
        }
        boolean z3 = f179o0;
        if (z3) {
            if (this.f194k0 == null) {
                this.f194k0 = new androidx.appcompat.app.o();
            }
            if (this.f194k0.a(attributeSet)) {
                z2 = true;
            } else {
                if (!(attributeSet instanceof XmlPullParser)) {
                    zS0 = S0((ViewParent) view);
                } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                    zS0 = true;
                }
                z2 = zS0;
            }
        } else {
            z2 = false;
        }
        return this.f193j0.r(view, str, context, attributeSet, z2, z3, true, u2.c());
    }

    final int c1(@Nullable WindowInsetsCompat windowInsetsCompat, @Nullable Rect rect) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        boolean z2;
        boolean z3;
        int iK = windowInsetsCompat != null ? windowInsetsCompat.k() : rect != null ? rect.top : 0;
        ActionBarContextView actionBarContextView = this.f209z;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z2 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f209z.getLayoutParams();
            if (this.f209z.isShown()) {
                if (this.f191h0 == null) {
                    this.f191h0 = new Rect();
                    this.f192i0 = new Rect();
                }
                Rect rect2 = this.f191h0;
                Rect rect3 = this.f192i0;
                if (windowInsetsCompat == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(windowInsetsCompat.i(), windowInsetsCompat.k(), windowInsetsCompat.j(), windowInsetsCompat.h());
                }
                v2.a(this.F, rect2, rect3);
                int i2 = rect2.top;
                int i3 = rect2.left;
                int i4 = rect2.right;
                WindowInsetsCompat windowInsetsCompatU = ViewCompat.u(this.F);
                int i5 = windowInsetsCompatU == null ? 0 : windowInsetsCompatU.i();
                int iJ = windowInsetsCompatU == null ? 0 : windowInsetsCompatU.j();
                if (marginLayoutParams.topMargin == i2 && marginLayoutParams.leftMargin == i3 && marginLayoutParams.rightMargin == i4) {
                    z3 = false;
                } else {
                    marginLayoutParams.topMargin = i2;
                    marginLayoutParams.leftMargin = i3;
                    marginLayoutParams.rightMargin = i4;
                    z3 = true;
                }
                if (i2 <= 0 || this.H != null) {
                    View view = this.H;
                    if (view != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                        int i6 = marginLayoutParams2.height;
                        int i7 = marginLayoutParams.topMargin;
                        if (i6 != i7 || marginLayoutParams2.leftMargin != i5 || marginLayoutParams2.rightMargin != iJ) {
                            marginLayoutParams2.height = i7;
                            marginLayoutParams2.leftMargin = i5;
                            marginLayoutParams2.rightMargin = iJ;
                            this.H.setLayoutParams(marginLayoutParams2);
                        }
                    }
                } else {
                    View view2 = new View(this.f198o);
                    this.H = view2;
                    view2.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = i5;
                    layoutParams.rightMargin = iJ;
                    this.F.addView(this.H, -1, layoutParams);
                }
                View view3 = this.H;
                z = view3 != null;
                if (z && view3.getVisibility() != 0) {
                    d1(this.H);
                }
                if (!this.M && z) {
                    iK = 0;
                }
                z2 = z;
                z = z3;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z2 = false;
            } else {
                z2 = false;
                z = false;
            }
            if (z) {
                this.f209z.setLayoutParams(marginLayoutParams);
            }
        }
        View view4 = this.H;
        if (view4 != null) {
            view4.setVisibility(z2 ? 0 : 8);
        }
        return iK;
    }

    void d0() {
        androidx.appcompat.view.menu.e eVar;
        j1 j1Var = this.f205v;
        if (j1Var != null) {
            j1Var.l();
        }
        if (this.A != null) {
            this.f199p.getDecorView().removeCallbacks(this.B);
            if (this.A.isShowing()) {
                try {
                    this.A.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.A = null;
        }
        g0();
        v vVarQ0 = q0(0, false);
        if (vVarQ0 == null || (eVar = vVarQ0.f244j) == null) {
            return;
        }
        eVar.close();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void e(View view, ViewGroup.LayoutParams layoutParams) {
        h0();
        ((ViewGroup) this.F.findViewById(R.id.content)).addView(view, layoutParams);
        this.f200q.c(this.f199p.getCallback());
    }

    boolean e0(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.f197n;
        if (((obj instanceof e.a) || (obj instanceof androidx.appcompat.app.k)) && (decorView = this.f199p.getDecorView()) != null && androidx.core.view.e.d(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.f200q.b(this.f199p.getCallback(), keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? B0(keyCode, keyEvent) : E0(keyCode, keyEvent);
    }

    void f0(int i2) {
        v vVarQ0;
        v vVarQ02 = q0(i2, true);
        if (vVarQ02.f244j != null) {
            Bundle bundle = new Bundle();
            vVarQ02.f244j.Q(bundle);
            if (bundle.size() > 0) {
                vVarQ02.f253s = bundle;
            }
            vVarQ02.f244j.d0();
            vVarQ02.f244j.clear();
        }
        vVarQ02.f252r = true;
        vVarQ02.f251q = true;
        if ((i2 != 108 && i2 != 0) || this.f205v == null || (vVarQ0 = q0(0, false)) == null) {
            return;
        }
        vVarQ0.f247m = false;
        M0(vVarQ0, null);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    @NonNull
    @CallSuper
    public Context g(@NonNull Context context) {
        this.T = true;
        int iZ0 = z0(context, U());
        if (AppCompatDelegate.u(context)) {
            AppCompatDelegate.N(context);
        }
        androidx.core.os.g gVarT = T(context);
        if (f182r0 && (context instanceof ContextThemeWrapper)) {
            try {
                t.a((ContextThemeWrapper) context, a0(context, iZ0, gVarT, null, false));
                return context;
            } catch (IllegalStateException unused) {
            }
        }
        if (context instanceof androidx.appcompat.view.d) {
            try {
                ((androidx.appcompat.view.d) context).a(a0(context, iZ0, gVarT, null, false));
                return context;
            } catch (IllegalStateException unused2) {
            }
        }
        if (!f181q0) {
            return super.g(context);
        }
        Configuration configuration = new Configuration();
        configuration.uiMode = -1;
        configuration.fontScale = 0.0f;
        Configuration configuration2 = k.a(context, configuration).getResources().getConfiguration();
        Configuration configuration3 = context.getResources().getConfiguration();
        configuration2.uiMode = configuration3.uiMode;
        Configuration configurationA0 = a0(context, iZ0, gVarT, configuration2.equals(configuration3) ? null : k0(configuration2, configuration3), true);
        androidx.appcompat.view.d dVar = new androidx.appcompat.view.d(context, R$style.Theme_AppCompat_Empty);
        dVar.a(configurationA0);
        boolean z2 = false;
        try {
            z2 = context.getTheme() != null;
        } catch (NullPointerException unused3) {
        }
        if (z2) {
            h.g.a(dVar.getTheme());
        }
        return super.g(dVar);
    }

    void g0() {
        y2 y2Var = this.C;
        if (y2Var != null) {
            y2Var.c();
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    @Nullable
    public <T extends View> T j(@IdRes int i2) {
        h0();
        return (T) this.f199p.findViewById(i2);
    }

    v j0(Menu menu) {
        v[] vVarArr = this.Q;
        int length = vVarArr != null ? vVarArr.length : 0;
        for (int i2 = 0; i2 < length; i2++) {
            v vVar = vVarArr[i2];
            if (vVar != null && vVar.f244j == menu) {
                return vVar;
            }
        }
        return null;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public Context l() {
        return this.f198o;
    }

    final Context l0() {
        ActionBar actionBarR = r();
        Context contextK = actionBarR != null ? actionBarR.k() : null;
        return contextK == null ? this.f198o : contextK;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public int n() {
        return this.X;
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return c0(view, str, context, attributeSet);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public MenuInflater p() {
        if (this.f203t == null) {
            t0();
            ActionBar actionBar = this.f202s;
            this.f203t = new androidx.appcompat.view.g(actionBar != null ? actionBar.k() : this.f198o);
        }
        return this.f203t;
    }

    androidx.core.os.g p0(Configuration configuration) {
        int i2 = Build.VERSION.SDK_INT;
        return i2 >= 24 ? m.b(configuration) : i2 >= 21 ? androidx.core.os.g.c(l.b(configuration.locale)) : androidx.core.os.g.a(configuration.locale);
    }

    protected v q0(int i2, boolean z2) {
        v[] vVarArr = this.Q;
        if (vVarArr == null || vVarArr.length <= i2) {
            v[] vVarArr2 = new v[i2 + 1];
            if (vVarArr != null) {
                System.arraycopy(vVarArr, 0, vVarArr2, 0, vVarArr.length);
            }
            this.Q = vVarArr2;
            vVarArr = vVarArr2;
        }
        v vVar = vVarArr[i2];
        if (vVar != null) {
            return vVar;
        }
        v vVar2 = new v(i2);
        vVarArr[i2] = vVar2;
        return vVar2;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public ActionBar r() {
        t0();
        return this.f202s;
    }

    final CharSequence r0() {
        Object obj = this.f197n;
        return obj instanceof Activity ? ((Activity) obj).getTitle() : this.f204u;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void s() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f198o);
        if (layoutInflaterFrom.getFactory() == null) {
            androidx.core.view.f.b(layoutInflaterFrom, this);
        } else {
            if (layoutInflaterFrom.getFactory2() instanceof d) {
                return;
            }
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    final Window.Callback s0() {
        return this.f199p.getCallback();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void t() {
        if (K0() == null || r().l()) {
            return;
        }
        x0(0);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void w(Configuration configuration) throws IllegalAccessException, NoSuchFieldException, PackageManager.NameNotFoundException, SecurityException, IllegalArgumentException {
        ActionBar actionBarR;
        if (this.K && this.E && (actionBarR = r()) != null) {
            actionBarR.m(configuration);
        }
        androidx.appcompat.widget.k.b().g(this.f198o);
        this.W = new Configuration(this.f198o.getResources().getConfiguration());
        P(false, false);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void x(Bundle bundle) {
        this.T = true;
        O(false);
        i0();
        Object obj = this.f197n;
        if (obj instanceof Activity) {
            String strC = null;
            try {
                strC = androidx.core.app.u.c((Activity) obj);
            } catch (IllegalArgumentException unused) {
            }
            if (strC != null) {
                ActionBar actionBarK0 = K0();
                if (actionBarK0 == null) {
                    this.f190g0 = true;
                } else {
                    actionBarK0.r(true);
                }
            }
            AppCompatDelegate.d(this);
        }
        this.W = new Configuration(this.f198o.getResources().getConfiguration());
        this.U = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0045  */
    @Override // androidx.appcompat.app.AppCompatDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void y() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f197n
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L9
            androidx.appcompat.app.AppCompatDelegate.E(r3)
        L9:
            boolean r0 = r3.f187d0
            if (r0 == 0) goto L18
            android.view.Window r0 = r3.f199p
            android.view.View r0 = r0.getDecorView()
            java.lang.Runnable r1 = r3.f189f0
            r0.removeCallbacks(r1)
        L18:
            r0 = 1
            r3.V = r0
            int r0 = r3.X
            r1 = -100
            if (r0 == r1) goto L45
            java.lang.Object r0 = r3.f197n
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L45
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L45
            androidx.collection.g<java.lang.String, java.lang.Integer> r0 = androidx.appcompat.app.d.f178n0
            java.lang.Object r1 = r3.f197n
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.X
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L54
        L45:
            androidx.collection.g<java.lang.String, java.lang.Integer> r0 = androidx.appcompat.app.d.f178n0
            java.lang.Object r1 = r3.f197n
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L54:
            androidx.appcompat.app.ActionBar r0 = r3.f202s
            if (r0 == 0) goto L5b
            r0.n()
        L5b:
            r3.X()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.d.y():void");
    }

    public boolean y0() {
        return this.D;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void z(Bundle bundle) {
        h0();
    }

    int z0(@NonNull Context context, int i2) {
        if (i2 == -100) {
            return -1;
        }
        if (i2 != -1) {
            if (i2 == 0) {
                if (Build.VERSION.SDK_INT < 23 || ((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() != 0) {
                    return o0(context).c();
                }
                return -1;
            }
            if (i2 != 1 && i2 != 2) {
                if (i2 == 3) {
                    return n0(context).c();
                }
                throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
            }
        }
        return i2;
    }

    d(Dialog dialog, androidx.appcompat.app.b bVar) {
        this(dialog.getContext(), dialog.getWindow(), bVar, dialog);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    private d(Context context, Window window, androidx.appcompat.app.b bVar, Object obj) {
        androidx.collection.g<String, Integer> gVar;
        Integer num;
        AppCompatActivity appCompatActivityX0;
        this.C = null;
        this.D = true;
        this.X = -100;
        this.f189f0 = new b();
        this.f198o = context;
        this.f201r = bVar;
        this.f197n = obj;
        if (this.X == -100 && (obj instanceof Dialog) && (appCompatActivityX0 = X0()) != null) {
            this.X = appCompatActivityX0.g().n();
        }
        if (this.X == -100 && (num = (gVar = f178n0).get(obj.getClass().getName())) != null) {
            this.X = num.intValue();
            gVar.remove(obj.getClass().getName());
        }
        if (window != null) {
            S(window);
        }
        androidx.appcompat.widget.k.h();
    }

    /* compiled from: AppCompatDelegateImpl.java */
    class p extends androidx.appcompat.view.k {

        /* renamed from: f, reason: collision with root package name */
        private h f222f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f223g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f224h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f225i;

        p(Window.Callback callback) {
            super(callback);
        }

        public boolean b(Window.Callback callback, KeyEvent keyEvent) {
            try {
                this.f224h = true;
                return callback.dispatchKeyEvent(keyEvent);
            } finally {
                this.f224h = false;
            }
        }

        public void c(Window.Callback callback) {
            try {
                this.f223g = true;
                callback.onContentChanged();
            } finally {
                this.f223g = false;
            }
        }

        public void d(Window.Callback callback, int i2, Menu menu) {
            try {
                this.f225i = true;
                callback.onPanelClosed(i2, menu);
            } finally {
                this.f225i = false;
            }
        }

        @Override // androidx.appcompat.view.k, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return this.f224h ? a().dispatchKeyEvent(keyEvent) : d.this.e0(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // androidx.appcompat.view.k, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || d.this.D0(keyEvent.getKeyCode(), keyEvent);
        }

        final ActionMode e(ActionMode.Callback callback) {
            f.a aVar = new f.a(d.this.f198o, callback);
            androidx.appcompat.view.b bVarU0 = d.this.U0(aVar);
            if (bVarU0 != null) {
                return aVar.e(bVarU0);
            }
            return null;
        }

        @Override // android.view.Window.Callback
        public void onContentChanged() {
            if (this.f223g) {
                a().onContentChanged();
            }
        }

        @Override // androidx.appcompat.view.k, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i2, Menu menu) {
            if (i2 != 0 || (menu instanceof androidx.appcompat.view.menu.e)) {
                return super.onCreatePanelMenu(i2, menu);
            }
            return false;
        }

        @Override // androidx.appcompat.view.k, android.view.Window.Callback
        public View onCreatePanelView(int i2) {
            View viewOnCreatePanelView;
            h hVar = this.f222f;
            return (hVar == null || (viewOnCreatePanelView = hVar.onCreatePanelView(i2)) == null) ? super.onCreatePanelView(i2) : viewOnCreatePanelView;
        }

        @Override // androidx.appcompat.view.k, android.view.Window.Callback
        public boolean onMenuOpened(int i2, Menu menu) {
            super.onMenuOpened(i2, menu);
            d.this.G0(i2);
            return true;
        }

        @Override // androidx.appcompat.view.k, android.view.Window.Callback
        public void onPanelClosed(int i2, Menu menu) {
            if (this.f225i) {
                a().onPanelClosed(i2, menu);
            } else {
                super.onPanelClosed(i2, menu);
                d.this.H0(i2);
            }
        }

        @Override // androidx.appcompat.view.k, android.view.Window.Callback
        public boolean onPreparePanel(int i2, View view, Menu menu) {
            androidx.appcompat.view.menu.e eVar = menu instanceof androidx.appcompat.view.menu.e ? (androidx.appcompat.view.menu.e) menu : null;
            if (i2 == 0 && eVar == null) {
                return false;
            }
            if (eVar != null) {
                eVar.a0(true);
            }
            h hVar = this.f222f;
            boolean zOnPreparePanel = hVar != null && hVar.a(i2);
            if (!zOnPreparePanel) {
                zOnPreparePanel = super.onPreparePanel(i2, view, menu);
            }
            if (eVar != null) {
                eVar.a0(false);
            }
            return zOnPreparePanel;
        }

        @Override // androidx.appcompat.view.k, android.view.Window.Callback
        @RequiresApi(24)
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i2) {
            androidx.appcompat.view.menu.e eVar;
            v vVarQ0 = d.this.q0(0, true);
            if (vVarQ0 == null || (eVar = vVarQ0.f244j) == null) {
                super.onProvideKeyboardShortcuts(list, menu, i2);
            } else {
                super.onProvideKeyboardShortcuts(list, eVar, i2);
            }
        }

        @Override // androidx.appcompat.view.k, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            return d.this.y0() ? e(callback) : super.onWindowStartingActionMode(callback);
        }

        @Override // androidx.appcompat.view.k, android.view.Window.Callback
        @RequiresApi(23)
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i2) {
            if (d.this.y0() && i2 == 0) {
                return e(callback);
            }
            return super.onWindowStartingActionMode(callback, i2);
        }
    }
}
